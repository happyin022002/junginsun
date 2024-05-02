/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderBCImpl.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.CSSMVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfMstVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration.InterfaceScheduleToExternalScnDBDAO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * VSKCommon Business Logic Basic Command implementation<br>
 * - Handling business logic of VSKCommon<br>
 *
 * @author 
 * @see UI_VSK-0202EventResponse,VSKCodeFinderBC, DAO
 * @since J2EE 1.4
 */

public class InterfaceScheduleToExternalScnBCImpl extends BasicCommandSupport implements InterfaceScheduleToExternalScnBC {

	// Database Access Object
	private transient InterfaceScheduleToExternalScnDBDAO dbDao = null;

	/**
	 * VSKCodeFinderBCImpl object creation<br>
	 * Creating VSKCodeFinderDBDAO<br>
	 */
	public InterfaceScheduleToExternalScnBCImpl() {
		dbDao = new InterfaceScheduleToExternalScnDBDAO();
	}


	/**
	 * CSSM I/F  
	 * 
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @exception EventException
	 */
	public void manageScnCssmIf(List<VskVslSkdVO> vskVslSkdVOs) throws EventException{
		
		try {
			
			if(vskVslSkdVOs == null || vskVslSkdVOs.size() == 0)		return;
			
			this.createVskScnIf(vskVslSkdVOs);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} 
	}
	
	
	/**
	 * CSSM I/F  
	 * 
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @exception EventException
	 */
//	public void removeScnCssmIf(List<VskVslSkdVO> vskVslSkdVOs) throws EventException{
//		try {
//			for (CSSMVO cssVo : vvdVOs) {
//				 CSSMVO rtnCSSM = dbDao.checkCSSM(cssVo);
//				if( rtnCSSM != null ){
//					String rtn = rtnCSSM.getInsfCnqeVal();
//					cssVo.setInsfDvCd("D");
//					if (rtn == null || "".equals(rtn)) {
//						dbDao.updateCSSM(cssVo);
//					} else {						
//						dbDao.insertCSSM(cssVo);
//					}
//				}
//			}			
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
//		} 
//	}

	
	/**
	 * SCN I/F  
	 * 
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @exception EventException
	 */
	public void createVskScnIf(List<VskVslSkdVO> vskVslSkdVOs) throws EventException {
	
		try{
			
			/******************************************************************************
			 * Change Notification Back End Job 처리
			 */
			this.createVskScnIfBackEndJob(vskVslSkdVOs);

		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 *  VIPS I/F  
	 *
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @return String
	 * @exception EventException
	 */
	public String createVskScnIfBackEndJob(List<VskVslSkdVO> vskVslSkdVOs) throws EventException{
					
			String 											backendJobKey		= null;
			InterfaceScheduleToExternalScnBackEndJob 		backEndCommand		= new InterfaceScheduleToExternalScnBackEndJob();
			BackEndJobManager 								backEndJobManager 	= new BackEndJobManager();
			
			try {
				
				if(vskVslSkdVOs == null || vskVslSkdVOs.size() == 0)	return null;
				
				backEndCommand.setScnVskVslSkdVOs	(vskVslSkdVOs);
				
				backendJobKey	= backEndJobManager.execute(backEndCommand, "VSK_byTOP", "insertVskScnIf");

			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
			return backendJobKey;
		}

}