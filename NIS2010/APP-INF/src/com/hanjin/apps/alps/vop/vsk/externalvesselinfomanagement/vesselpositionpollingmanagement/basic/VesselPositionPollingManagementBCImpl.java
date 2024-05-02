/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselPositionPollingManagementBCImpl.java
*@FileTitle : Position Polling Receive Management
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : Lim Ye Ji
*@LastVersion : 1.0
* 2014.05.18 Lim Ye Ji
* 1.0 Creation
* 
* History
* 
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.basic;


import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration.VesselPositionPollingManagementDBDAO;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.vo.PositionPollingHeaderVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * Vessel Position Polling Management Business Logic Basic Command implementation<br>
 * -  Vessel Position Polling Management Business에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author LIM YE JI
 * @see VesselPositionPollingManagementBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class VesselPositionPollingManagementBCImpl extends BasicCommandSupport implements VesselPositionPollingManagementBC {
	
	// Database Access Object
	private transient VesselPositionPollingManagementDBDAO 		dbDao 	= null;

	/**
	 * VesselPositionPollingManagementBCImpl 객체 생성<br>
	 * VesselPositionPollingManagementDBDAO를 생성한다.<br>
	 */
	public VesselPositionPollingManagementBCImpl() {
		dbDao 	= new VesselPositionPollingManagementDBDAO();
	}

	/**
	 * Vessel Position Polling 데이터를 VSK_VSL_PSN_PLNG_HDR에 저장한다.
	 * @param String sRawFlatFile
	 * @return PositionPollingHeaderVO
	 * @exception EventException
	 */
	public PositionPollingHeaderVO createPositionPollingHeaderFromEdi(String sRawFlatFile) throws EventException{
		
		PositionPollingHeaderVO		positionPollingHeaderVO	= new PositionPollingHeaderVO();
		String 								sDlyRcvSeq					= null;
		String								sRcvDt						= null;
		
		try{
			
//			################ MQ 메세지 원본 컬럼단위로 쪼개기 ################
			sRcvDt							=   dbDao.createRcvDt();
			sDlyRcvSeq						=	dbDao.createDlyRcvSeq(sRcvDt);
				
			//::header message:://
			positionPollingHeaderVO.setFileNm(sRawFlatFile.substring(62,78));
			
			//::INSERT::VSK_VSL_PSN_PLNG_HDR:://////////////////////////////////////////
			//RCV_DT, DLY_RCV_SEQ 정보 
			positionPollingHeaderVO.setRcvDt(sRcvDt);
			positionPollingHeaderVO.setDlyRcvSeq(sDlyRcvSeq);
			//---------------------------------------------------------------------------//
			dbDao.createPositionPollingHeader		(positionPollingHeaderVO);
			
			//Position Polling File 동일한 것이 들어올 경우 Validation Check
			dbDao.selectPositionPollingHeaderDupInfo (positionPollingHeaderVO);
			
			positionPollingHeaderVO.setRcvCtnt(positionPollingHeaderVO.getRcvCtnt());
			///////////////////////////////////////////////////////////////////////////////
			
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return positionPollingHeaderVO;
	}

	/**
	 * Vessel Position Polling 데이터를 
	 * @param PositionPollingHeaderVO positionPollingHeaderVO, String sRawFlatFile
	 * @return void
	 * @exception EventException
	 */
	public void createPositionPollingDetailFromEdiBackEndJob(PositionPollingHeaderVO positionPollingHeaderVO, String sRawFlatFile) throws EventException{
		
		VesselPositionPollingDetailUpdateBackEndJob posPolBackEndJob 	= new VesselPositionPollingDetailUpdateBackEndJob();
		BackEndJobManager 					backEndJobManager 		= new BackEndJobManager();
		
		try{
			if(positionPollingHeaderVO == null);
			
			posPolBackEndJob.setPositionPollingHeaderVO(positionPollingHeaderVO);
			posPolBackEndJob.setRawFlatFile(sRawFlatFile);
			
			backEndJobManager.execute(posPolBackEndJob, "VSK_2014505", "createPositionPollingDetailFromEdiBackEndJob");
		
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	


	
}
