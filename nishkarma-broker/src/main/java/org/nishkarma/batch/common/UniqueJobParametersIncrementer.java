package org.nishkarma.batch.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersIncrementer;

public class UniqueJobParametersIncrementer implements JobParametersIncrementer {

	private static final long JOB_PARAMETER_MAXIMUM = 1000000;

	public JobParameters getNext(JobParameters orgParameters) {

		Map<String, JobParameter> orgParametersMap = orgParameters
				.getParameters();

		Map<String, JobParameter> uniqueParameters = new HashMap<String, JobParameter>();
		uniqueParameters.put("random", new JobParameter(
				(long) (Math.random() * JOB_PARAMETER_MAXIMUM)));

		uniqueParameters.putAll(orgParametersMap);

		return new JobParameters(uniqueParameters);
	}
}