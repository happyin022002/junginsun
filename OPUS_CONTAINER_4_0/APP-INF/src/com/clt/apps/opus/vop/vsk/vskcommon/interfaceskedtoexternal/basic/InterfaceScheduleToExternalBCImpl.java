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
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.CSSMVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfHdrVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfMstVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * VSKCommon Business Logic Basic Command implementation<br>
 * - Handling business logic of VSKCommon<br>
 *
 * @author 
 * @see UI_VSK-0202EventResponse,VSKCodeFinderBC, DAO
 * @since J2EE 1.4
 */

public class InterfaceScheduleToExternalBCImpl extends BasicCommandSupport implements InterfaceScheduleToExternalBC {

	// Database Access Object
	private transient InterfaceScheduleToExternalDBDAO dbDao = null;

	/**
	 * VSKCodeFinderBCImpl object creation<br>
	 * Creating VSKCodeFinderDBDAO<br>
	 */
	public InterfaceScheduleToExternalBCImpl() {
		dbDao = new InterfaceScheduleToExternalDBDAO();
	}

	/**
	 * VIPS I/F  
	 * 
	 * @param List<VskVipsIfMstVO> vskVipsIfMstVOs
	 * @param List<VskVipsIfDtlVO> vskVipsIfDtlVOs
	 * @param String sEventTypeCode
	 * @exception EventException
	 */
	public void createVskVipsIf(List<VskVipsIfMstVO> vskVipsIfMstVOs, List<VskVipsIfDtlVO> vskVipsIfDtlVOs, String sEventTypeCode) throws EventException {
	
		try{
			
			/******************************************************************************
			 * Change Notification Back End Job 처리
			 */
			this.createVskVipsIfBackEndJob(vskVipsIfMstVOs, vskVipsIfDtlVOs, sEventTypeCode);

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
	 * @param List<VskVipsIfMstVO> vskVipsIfMstVOs
	 * @param List<VskVipsIfDtlVO> vskVipsIfDtlVOs
	 * @param String sEventTypeCode
	 * @return String
	 * @exception EventException
	 */
	public String createVskVipsIfBackEndJob(List<VskVipsIfMstVO> vskVipsIfMstVOs, List<VskVipsIfDtlVO> vskVipsIfDtlVOs, String sEventTypeCode) throws EventException{
					
			String 												backendJobKey		= null;
			InterfaceScheduleToExternalBackEndJob 				backEndCommand		= new InterfaceScheduleToExternalBackEndJob();
			BackEndJobManager 									backEndJobManager 	= new BackEndJobManager();
			
			try {
				
				if(		(vskVipsIfMstVOs == null || vskVipsIfMstVOs.size() == 0)
					&&	(vskVipsIfDtlVOs == null || vskVipsIfDtlVOs.size() == 0))	
				return null;
				
				//backEndCommand.setVskVipsIfHdrVOs	(vskVipsIfHdrVOs);
				backEndCommand.setVskVipsIfMstVOs	(vskVipsIfMstVOs);
				backEndCommand.setVskVipsIfDtlVOs	(vskVipsIfDtlVOs);
				backEndCommand.setFromEventSystem	(sEventTypeCode	);
				
				backendJobKey	= backEndJobManager.execute(backEndCommand, "VSK_byTOP", "insertVskVipsIf");

			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
			return backendJobKey;
		}

}