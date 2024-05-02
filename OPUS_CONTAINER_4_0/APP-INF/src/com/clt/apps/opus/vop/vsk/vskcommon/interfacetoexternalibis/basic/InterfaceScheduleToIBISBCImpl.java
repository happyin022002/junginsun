/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToIBISBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdDtlIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPortNworkIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslPortSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslSkdIbisIfVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * Vskcommon Business Logic Command Interface<br>
 * - business logic interface about Vskcommon<br>
 *
 * @author 
 * @see InterfaceScheduleToIBISBC
 * @since J2EE 1.4
 */
public class InterfaceScheduleToIBISBCImpl extends BasicCommandSupport implements InterfaceScheduleToIBISBC {

	/**
	 *  VSK_PORT_NWORK IBIS I/F  
	 *
	 * @param List<VskPortNworkIbisIfVO> vskPortNworkIbisIfVOs
	 * @param String jobType
	 * @return String
	 * @exception EventException
	 */
	public String createVskPortNworkIbisIfBackEndJob(List<VskPortNworkIbisIfVO> vskPortNworkIbisIfVOs, String jobType) throws EventException{
					
		String backendJobKey = null;
		InterfaceScheduleToIBISBackEndJob backEndCommand = new InterfaceScheduleToIBISBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
			
		try {
			backEndCommand.setVskPortNworkIbisIfVOs (vskPortNworkIbisIfVOs);
			backEndCommand.setJobType	(jobType);
			
			backendJobKey	= backEndJobManager.execute(backEndCommand, "VSK_byHS", "insertVskPortNwork");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return backendJobKey;
	}
	
	/**
	 *  VSK_PF_SKD, Dtl IBIS I/F  
	 *
	 * @param List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVOs
	 * @param List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs
	 * @param String sEventTypeCode
	 * @return String
	 * @exception EventException
	 */
	public String createVskPfSkdIbisIfBackEndJob(List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVOs, List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs, String sEventTypeCode) throws EventException{
					
		String backendJobKey = null;
		InterfaceScheduleToIBISBackEndJob backEndCommand = new InterfaceScheduleToIBISBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
			
		try {
			backEndCommand.setVskPfSkdIbisIfVOs (vskPfSkdIbisIfVOs);
			backEndCommand.setVskPfSkdDtlIbisIfVOs(vskPfSkdDtlIbisIfVOs);
			backEndCommand.setJobType	(sEventTypeCode	);
			
			backendJobKey	= backEndJobManager.execute(backEndCommand, "VSK_byHS", "insertVskPfSkd");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return backendJobKey;
	}
	
	/**
	 *  VSK_VSL_SKD, Dtl IBIS I/F  
	 *
	 * @param List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs
	 * @param List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs
	 * @param String sEventTypeCode
	 * @return String
	 * @exception EventException
	 */	
	public String createVskVslSkdIbisIfBackEndJob(List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs, List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs, String sEventTypeCode) throws EventException{
		
		String backendJobKey = null;
		InterfaceScheduleToIBISBackEndJob backEndCommand = new InterfaceScheduleToIBISBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
			
		try {
			backEndCommand.setVskVslSkdIbisIfVOs (vskVslSkdIbisIfVOs);
			backEndCommand.setVskVslPortSkdIbisIfVOs(vskVslPortSkdIbisIfVOs);
			backEndCommand.setJobType	(sEventTypeCode	);
			
			backendJobKey	= backEndJobManager.execute(backEndCommand, "VSK_byHS", "insertVskVslSkd");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return backendJobKey;
	}

}
