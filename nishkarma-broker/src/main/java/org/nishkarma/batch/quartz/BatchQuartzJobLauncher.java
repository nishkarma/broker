/**
 * Nishkarma EAI Project
 */
package org.nishkarma.batch.quartz;

/** <pre>
 * 
 * </pre>
 * @Company Nishkarma
 * @Author lee suk jae
 * @Date 2015. 7. 15. 오전 8:37:17
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 7. 15.     lee suk jae
 *          -------------------------------------------------------------------
 */
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobParametersNotFoundException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class BatchQuartzJobLauncher extends QuartzJobBean {

	private JobLauncher jobLauncher;
	private JobLocator jobLocator;
	private JobExplorer jobExplorer;
	private Map<String, Object> jobParametersMap;
	public static final String JOB_NAME = "jobName";

	private static final Logger logger = LoggerFactory
			.getLogger(BatchQuartzJobLauncher.class);

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		Map<String, Object> jobDataMap = context.getMergedJobDataMap();
		String jobName = (String) jobDataMap.get(JOB_NAME);
		
		logger.debug("1---jobName={}", jobName);

		try {
			Job job = jobLocator.getJob(jobName);

			JobParameters jobParameters = getJobParametersFromJobMap(jobParametersMap);

			JobParametersIncrementer incrementer = job
					.getJobParametersIncrementer();

			if (incrementer != null) {
				jobParameters = getNextJobParameters(job, jobParameters,
						incrementer);
			}

			logger.debug("2---job={}", job.toString());
			logger.debug("3---jobParameters={}", jobParameters.toString());
			
			jobLauncher.run(job, jobParameters);

		} catch (Exception e) {
			logger.error("Could not execute job.", e);
		}
	}

	private JobParameters getNextJobParameters(Job job,
			JobParameters orgJobParameters, JobParametersIncrementer incrementer)
			throws JobParametersNotFoundException {

		JobParameters nextJobParameters = new JobParameters();

		String jobIdentifier = job.getName();

		List<JobInstance> lastInstances = jobExplorer.getJobInstances(
				jobIdentifier, 0, 1);

		if (incrementer == null) {
			throw new JobParametersNotFoundException(
					"No job parameters incrementer found for job="
							+ jobIdentifier);
		}

		if (lastInstances.isEmpty()) {
			nextJobParameters = incrementer.getNext(new JobParameters());
			if (nextJobParameters == null) {
				throw new JobParametersNotFoundException(
						"No bootstrap parameters found from incrementer for job="
								+ jobIdentifier);
			}
		} else {

			if (logger.isDebugEnabled()) {
				Map<String, JobParameter> orgMap = orgJobParameters
						.getParameters();

				for (Entry<String, JobParameter> entry : orgMap.entrySet()) {
					String key = entry.getKey();
					JobParameter value = entry.getValue();

					logger.debug("1.orgJobParameters-jobDataMap=({},{})", key,
							value.getValue());
				}
			}

			nextJobParameters = incrementer.getNext(orgJobParameters);

			if (logger.isDebugEnabled()) {
				Map<String, JobParameter> nextMap = nextJobParameters
						.getParameters();

				for (Entry<String, JobParameter> entry : nextMap.entrySet()) {
					String key = entry.getKey();
					JobParameter value = entry.getValue();

					logger.debug("2.nextJobParameters-jobDataMap=({},{})", key,
							value.getValue());
				}
			}
		}
		return nextJobParameters;
	}

	private JobParameters getJobParametersFromJobMap(
			Map<String, Object> jobDataMap) {

		JobParametersBuilder builder = new JobParametersBuilder();

		if (jobDataMap == null)
			return builder.toJobParameters();

		for (Entry<String, Object> entry : jobDataMap.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			logger.debug("jobDataMap=({},{})", key, value);

			if (value instanceof String && !key.equals(JOB_NAME)) {
				builder.addString(key, (String) value);
			} else if (value instanceof Float || value instanceof Double) {
				builder.addDouble(key, ((Number) value).doubleValue());
			} else if (value instanceof Integer || value instanceof Long) {
				builder.addLong(key, ((Number) value).longValue());
			} else if (value instanceof Date) {
				builder.addDate(key, (Date) value);
			} else if (value instanceof JobParameter) {
				builder.addParameter(key, (JobParameter) value);
			} else {
				logger.warn(
						"JobDataMap contains values which are not job parameters (ignoring) - {}",
						key);
			}

		}

		return builder.toJobParameters();

	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	public void setJobParametersMap(Map<String, Object> jobParametersMap) {
		this.jobParametersMap = jobParametersMap;
	}

	public void setJobExplorer(JobExplorer jobExplorer) {
		this.jobExplorer = jobExplorer;
	}

}
