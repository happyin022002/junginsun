/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : BkgCopManageBackEndJob.java
* @FileTitle : BkgCopManage BackEndJob
* Open Issues :
* Change history :
* @LastModifyDate : 2011-09-27
* @LastModifier : Poong-Yeon Cho
* @LastVersion : 1.0
* 2011-09-27 Poong-Yeon Cho
* 1.0 최초생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.core.BackEndMetaData;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAO;

/**
 * Back End Job 처리를 담당<br>
 * @author poong yeon cho
 * @see BkgCopManageBackEndJobBCImpl 참조
 * @since J2EE 1.6
 */
public class ReplanManageBackEndJobBCImpl extends BackEndCommandSupport implements ReplanManageBackEndJobBC{

	private static final long serialVersionUID = 2741857100652224677L;
	private transient ReplanManageDBDAO replanManageDbDao = null;
	private transient ReplanManageBCImpl replanManageBC = null;
	
	private String pctlNo = null;
	private String bkgNo = null;
	private String cntrNo = null;
	
	/**
	 * Constructor
	 * @param String pctlNoVal
	 * @param String bkgNoVal
	 * @param String cntrNoVal
	 */
	public ReplanManageBackEndJobBCImpl(String pctlNoVal, String bkgNoVal, String cntrNoVal){
		replanManageDbDao = new ReplanManageDBDAO();
		replanManageBC = new ReplanManageBCImpl();
		this.pctlNo = pctlNoVal;
		this.bkgNo = bkgNoVal;
		this.cntrNo = cntrNoVal;
	}
	
	/**
	 * back end job을 실행시키는 mail method
	 * @return Object
	 */
	public Object doStart() throws Exception {
		ReplanManageBackEndJob job = new ReplanManageBackEndJob(pctlNo, bkgNo, cntrNo);
		BackEndJobManager mnger = new BackEndJobManager();
		log.debug("************* backendjob ReplanManageBackEndJobBCImpl doStart ***************");
		log.debug("\npctlNo="+pctlNo);
		log.debug("\nbkgNo="+bkgNo);
		log.debug("\ncntrNo="+cntrNo);	
		log.debug("************* backendjob ReplanManageBackEndJobBCImpl execute ***************");
		
		return mnger.execute(job, "SCE_SO_RPLN", "SCE BackEndJob - S/O REPLAN FOR Partial COP");
	}
}