/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccessHistoryBCImpl.java
*@FileTitle : AccessHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2010.02.01 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.accesshistory.basic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.util.ScheduleUtil;
import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;

/**
 * ALPS-AccessHistory Business Logic Command Interface<br>
 * - ALPS-AccessHistory에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kyungbum kim
 * @since J2EE 1.6
 * @see AccessHistoryBC
 */
public class AccessHistoryBCImpl extends BasicCommandSupport implements AccessHistoryBC {

	/**
	 * AccessHistoryBCImpl 객체 생성<br>
	 * AccessHistoryDBDAO를 생성한다.<br>
	 */
	public AccessHistoryBCImpl() {
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param HashMap<String, String> param
	 * @return List<AccessHistoryVO>
	 * @exception EventException
	 */
	public String getAccessHistory(HashMap<String, String> param) throws EventException {
		String rtnKey = null;
		try {
			AccessHistoryBackEndJob backEndJob = new AccessHistoryBackEndJob();
			backEndJob.setParam(param);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			rtnKey = backEndJobManager.execute(backEndJob, "AccessHistory", "Access History select");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
//		rtnKey = callAccessHistoryBatchJob("SYS_COM_B005", param);
		return rtnKey;
		
	}

	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param HashMap<String, String> param
	 * @return List<AccessHistoryVO>
	 * @exception EventException
	 */
	public String getAccessHistoryExcel(HashMap<String, String> param) throws EventException {
		String rtnKey = null;
		try {
			AccessHistoryExcelBackEndJob backEndJob = new AccessHistoryExcelBackEndJob();
			backEndJob.setParam(param);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			rtnKey = backEndJobManager.execute(backEndJob, "AccessHistoryExcel", "Access History Excel select");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
//		rtnKey = callAccessHistoryBatchJob("SYS_COM_B006", param);
		return rtnKey;
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param HashMap<String, String> param
	 * @return LString
	 * @exception EventException
	 */
	public String getLastLoginDate(HashMap<String, String> param) throws EventException {
		String rtnKey = null;
		try {
			LastLoginDateBackEndJob backEndJob = new LastLoginDateBackEndJob();
			backEndJob.setParam(param);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			rtnKey = backEndJobManager.execute(backEndJob, "LastLoginDate", "Last Login Date select");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
//		rtnKey = callAccessHistoryBatchJob("SYS_COM_B007", param);
		return rtnKey;
	}
	
	
	
	
	/**
	 * Batch Job execute ! 
	 * @param batchId
	 * @param param
	 * @return
	 * @throws EventException
	 */
//	private String callAccessHistoryBatchJob(String batchId, HashMap<String, String> param) throws EventException
//	{
//		String rtnKey = null;
//
//		ScheduleUtil scheduleUtil = new ScheduleUtil();
//		StringBuilder sb = new StringBuilder();
//		
//		Set<String> set = param.keySet();
//		Object []hmKeys = set.toArray();
//		for (int i = 0; i < hmKeys.length; i++) {
//			String key = (String)hmKeys[i];
//		    String value = (String)param.get(key);   
//		    sb.append(key+"="+value);
//		    sb.append("||");
//		}
//		try {
//			
//			if(log.isDebugEnabled())
//			{
//				log.debug(">> " + batchId + " : " + sb.toString());
//			}
//			
//			if(scheduleUtil.isRunning(batchId))
//			{
//				throw new InterruptedException(new ErrorHandler("COM12115", "Access History Search Batch JOB ").getMessage()+" ");
//			}else{
//				rtnKey = scheduleUtil.directExecuteJob(batchId, sb.toString());
//			}
//		} catch (IOException e) {
//			throw new EventException(new ErrorHandler(e).getMessage(),e);
//		} catch (InterruptedException e) {
//			throw new EventException(new ErrorHandler(e).getMessage(),e);
//		} catch (DAOException e) {
//			throw new EventException(new ErrorHandler(e).getMessage(),e);
//		}
//		return rtnKey;
//	}

	
	
}