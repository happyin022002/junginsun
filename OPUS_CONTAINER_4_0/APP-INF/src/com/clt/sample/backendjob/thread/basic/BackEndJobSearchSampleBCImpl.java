/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : BackEndJobSearchSampleBCImpl.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Sep 22, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.clt.sample.backendjob.thread.basic;

import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * 
 * BackEndJobSearchSampleBCImpl.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 13.
 */
public class BackEndJobSearchSampleBCImpl implements BackEndJobSearchSampleBC{

	/**
	 * 
	 * doStart
	 * @author Jeong-Hoon, KIM
	 * @param account
	 * @return String
	 */
	public String doStart(SignOnUserAccount account) {
		BackEndJobSampleJob job = new BackEndJobSampleJob();
		BackEndJobManager mnger = new BackEndJobManager();
		return mnger.execute(job, account.getCre_usr_id(), "BackEndJob Test");
	}

}
