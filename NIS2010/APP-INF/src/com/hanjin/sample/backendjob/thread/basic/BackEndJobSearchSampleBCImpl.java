package com.hanjin.sample.backendjob.thread.basic;

import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

public class BackEndJobSearchSampleBCImpl implements BackEndJobSearchSampleBC{

	@Override
	public String doStart(SignOnUserAccount account) {
		BackEndJobSampleJob job = new BackEndJobSampleJob();
		BackEndJobManager mnger = new BackEndJobManager();
		return mnger.execute(job, account.getCre_usr_id(), "BackEndJob Test");
	}

}
