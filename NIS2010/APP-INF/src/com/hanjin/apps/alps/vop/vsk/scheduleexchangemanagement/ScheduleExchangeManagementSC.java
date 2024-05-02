/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleExchangeManagementSC.java
*@FileTitle : Schedule Receive/Send Management
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : JEONG SANG-KI
*@LastVersion : 1.0
* 2014.04.30 JEONG SANG-KI
* 1.0 Creation
* 
* History
* 
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.basic.ScheduleReceiveManagementBC;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.basic.ScheduleReceiveManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.event.UbizhjsAlpsvskSkdAllianceEvent;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.basic.ScheduleSendManagementBC;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.basic.ScheduleSendManagementBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.event.VopVskXchSkdEvent;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiHdrVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.SchedulePlanningOperationSC;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskVslSkdVO;
import com.jf.transfer.eai.exception.EAIException;

/**
 * ALPS-SchedulePlanningOperation ServiceCommand - ALPS-SchedulePlanningOperation 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author TOP
 * @see ScheduleExchangeManagementSC
 * @since J2EE 1.6
 */

public class ScheduleExchangeManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SchedulePlanningOperation system 업무 시나리오 선행작업<br>
	 * UI_VSK-0241업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {log.error(e.getMessage());}
	}

	/**
	 * SchedulePlanningOperation system 업무 시나리오 마감작업<br>
	 * UI_VSK-0241 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SchedulePlanningOperationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SchedulePlanningOperation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopVskXchSkdEvent")) {
			
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){		//::jsk::2014-03-21:://SEND EDI "CKYH"//
				eventResponse = sendEdiForScheduleExchangeCKYH(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("UbizhjsAlpsvskSkdAllianceEvent")) {
			
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = receiveEDIToCoastalSchedule(e);
			}
		}

		return eventResponse;
	}
	

	/**
	 * VOP_VSK_0015, VOP_VSK_0058 : Save<br>
	 * 입력받은 Vessel Port Schedule 정보를 등록 및 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEdiForScheduleExchangeCKYH(Event e) throws EventException {
		
		log.info("\n\n ::============= scscsc::jsk::sendEdiForScheduleExchangeCKYH started!!! ====================== ::");
		
		GeneralEventResponse 	eventResponse 			= new GeneralEventResponse();
		//SwapCstSkdSimVO[]		swapCstSkdSimVOs		= null;
		SwapCstSkdSimVO			swapCstSkdSimVO			= null;
		String					sFromEventSystem		= "";
		List<VskVslSkdVO>		tmpVVDList				= null;
		
		/*******************************************************************************
		 *	VESSEL SCHEDULE EXCHANGE LOGIC FOR SEND
		 * ----------------------------------------------------------------------------
		 *	1. HDR, DTL Table INSERT
		 *		- "VSK_VSL_SKD_XCH_EDI_HDR"
		 *		- "VSK_VSL_SKD_XCH_EDI_DTL"
		 *	2. F/F 생성
		 *	3. F/F TRANSFER
		 *******************************************************************************/
		
		if(e instanceof VopVskXchSkdEvent){
			VopVskXchSkdEvent event = (VopVskXchSkdEvent)e;
			//swapCstSkdSimVOs		= event.getSwapCstSkdSimVOs();
			swapCstSkdSimVO			= event.getSwapCstSkdSimVO();
			
			sFromEventSystem		= "VOP_VSK_0015";
		}else{
			return	null;
		}
		
		if(swapCstSkdSimVO == null)	return null;
		
		/////////////////////////////////////////////////
		//tmpVVDList		= this.makeVVDList(swapCstSkdSimVOs);
		/////////////////////////////////////////////////
		VskVslSkdVO			tmVO	= new VskVslSkdVO();
		tmVO.setVslCd		(swapCstSkdSimVO.getVslCd	());
		tmVO.setSkdVoyNo	(swapCstSkdSimVO.getSkdVoyNo());
		tmVO.setSkdDirCd	(swapCstSkdSimVO.getSkdDirCd());
		
		tmpVVDList			= new ArrayList<VskVslSkdVO>();
		tmpVVDList.add		(tmVO);
		/////////////////////////////////////////////////
		
		ScheduleSendManagementBC command = new ScheduleSendManagementBCImpl();

		try{
			
			this.begin();
			
			String 	sEdiSeq		= null;
			//boolean isSuccess	= false;
			
			/***************************************************************************
			 * Receiver ID Definition
			 * -------------------------------------------------------------------------
			 * <<Sending>>
			 * To : YANGMING
			 * $$$MSGSTART:SML                 CKY                 IFTSAI    ENT00000000335
			 * -------------------------------------------------------------------------
			 * To : K-LINE
			 * $$$MSGSTART:SML                 KKL                 IFTSAI    ENT00000000335
			 * -------------------------------------------------------------------------
			 * To : COSCO
			 * COS측 개발 Holding 으로 현재까지 ID 협의되지 않음
			 * =========================================================================
			 * <<Receiving>>
			 * From : YANGMING
			 * $$$MSGSTART:YML                 CKH                 IFTSAI    ENT00000000335
			 * -------------------------------------------------------------------------
			 * From : K-LINE
			 * $$$MSGSTART:KKL                 CKYH                IFTSAI    ENT00000000335
			 * -------------------------------------------------------------------------
			 * From : COSCO
			 * COS측 개발 Holding 으로 현재까지 ID 협의되지 않음
			 * -------------------------------------------------------------------------
			 */
			
			////String[] sArrAllnCo	= new String[]{"COS","KKL","YML"};
			String[] sArrAllnCo	= new String[]{"YML"};
			////String[] sArrAllnCo	= new String[]{"YML"};
			
			for(VskVslSkdVO tmpVO : tmpVVDList){
				
				//-----------------------------------------------------------------------//
				//-----------------------------------------------------------------------//
				for(int inx=0;inx<sArrAllnCo.length;inx++){
					
					//-----------------------------------------------------------------------//
					tmpVO.setCreUsrId(sFromEventSystem		);
					tmpVO.setUpdUsrId(account.getUsr_id()	);
					
					sEdiSeq		= command.createEdiForScheduleExchangeCKYH	(tmpVO, sArrAllnCo[inx]);
					
					//-----------------------------------------------------------------------//
					//-----------------------------------------------------------------------//
					
					VslSkdXchEdiHdrVO	tmpHdrVO	= new VslSkdXchEdiHdrVO();
					tmpHdrVO.setVslCdCtnt			(tmpVO.getVslCd		()	);
					tmpHdrVO.setSkdVoyNoCtnt		(tmpVO.getSkdVoyNo	()	);
					tmpHdrVO.setSkdDirCdCtnt		(tmpVO.getSkdDirCd	()	);
					tmpHdrVO.setSkdEdiRcvSeq		(sEdiSeq				);
					//----------------------------------------------------//
					
					//isSuccess	= command.sendEdiForScheduleExchangeCKYH	(tmpHdrVO);
					command.sendEdiForScheduleExchangeCKYH	(tmpHdrVO);
					//-----------------------------------------------------------------------//
				
				}
				//-----------------------------------------------------------------------//
				//-----------------------------------------------------------------------//
				
			}
			
			this.commit();
			
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * 입력된 port list데이터에서 vvd 목록을 추춣한다.<br>
	 * 
	 * @param SwapCstSkdSimVO[] swapCstSkdSimVOs
	 * @return List<VskVslSkdVO>
	 */
	public List<VskVslSkdVO> makeVVDList(SwapCstSkdSimVO[] swapCstSkdSimVOs){
		
		List<VskVslSkdVO>	tmpVVDList	= new ArrayList<VskVslSkdVO>();
		
		String sVslCd		= "";
		String sSkdVoyNo	= "";
		String sSkdDirCd	= "";
		
		for(int i=0; i<swapCstSkdSimVOs.length; i++){
			
			SwapCstSkdSimVO	tmpVO	= swapCstSkdSimVOs[i];
			
			if(!sVslCd.equals(tmpVO.getVslCd()) || !sSkdVoyNo.equals(tmpVO.getSkdVoyNo())|| !sSkdDirCd.equals(tmpVO.getSkdDirCd())){
				
				VskVslSkdVO	tmpVVD	= new VskVslSkdVO();
				
				tmpVVD.setVslCd		(tmpVO.getVslCd		());
				tmpVVD.setSkdVoyNo	(tmpVO.getSkdVoyNo	());
				tmpVVD.setSkdDirCd	(tmpVO.getSkdDirCd	());
				
				tmpVVDList.add		(tmpVVD);
				
				sVslCd			= tmpVO.getVslCd		();
				sSkdVoyNo		= tmpVO.getSkdVoyNo		();
				sSkdDirCd		= tmpVO.getSkdDirCd		();
				
			}
		}
		
		log.info("\n\n ::######################################################################::");
		log.info("\n\n ::######################### make vvd list ##############################::");
		int i = 0;
		for(VskVslSkdVO tvvd : tmpVVDList){
			
			i++;
			log.info("\n\n ::### ["+i+"] vvd ["+tvvd.getVslCd()+tvvd.getSkdVoyNo()+tvvd.getSkdDirCd()+"]");
			
		}
		log.info("\n\n ::######################### make vvd list ##############################::");
		log.info("\n\n ::######################################################################::");
		
		
		return tmpVVDList;
	}
		
	

	/**
	 * 멀티 이벤트 처리<br>
	 * MQ 메세지 전문 저장 및 체크<br>
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDIToCoastalSchedule(Event e) throws EventException {
		
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		ScheduleReceiveManagementBC command 		= new ScheduleReceiveManagementBCImpl();
		
		SchedulePlanningOperationSC	sc				= new SchedulePlanningOperationSC();
		//Event event									= (UbizhjsAlpsvskSkdAllianceEvent)e;

		try { 
			
			/* ###############################################################
			 * ######### METHOD CALL PROCESS #################################
			 * 1. this.createVskActPortSkdEdiLog
			 *    - 
			 * 2. this.auditReceivedEdiData
			 *    - 
			 * 3-1. this.manageActPortSkdByEDI >> this.manageActPortSkd 
			 *    :: BKG에 변경된 SCHEDULE 전송
			 *    :: VSK_ACT_PORT_SKD, VSK_ACT_PRT_SKD_HIS
			 *    :: SCE_ACT_RCV_IF
			 *    :: and so on...
			 * 3-2. this.manageActPortSkdByEDI >> this.modifyVskActPortSkdEdiLog
			 *    - 
			 * ###############################################################
			 */
			
			UbizhjsAlpsvskSkdAllianceEvent event = (UbizhjsAlpsvskSkdAllianceEvent)e;
			
			log.info("################### EDI EXCHANGE SCHEDULE START ###################");
			
//			################ MQ 메세지 원본 컬럼단위로 쪼개기 ################
			String					sRawFlatFile 		= event.getFlatFile();
			List<VslSkdXchEdiHdrVO> vslSkdXchEdiHdrVOs	= command.createEdiLogFromScheduleExchangeCKYH(sRawFlatFile);
			
//			################ MQ 메세지  체크 및 Parsing. ##################
			
			
//			################ MQ 메세지 Parsing 된 전문 저장 ################
			
//			################ MQ 메세지 Coastal Schedule 반영결과 UPDATE ################	
			
			for(VslSkdXchEdiHdrVO tmpHdrVO :vslSkdXchEdiHdrVOs){
							
				StringBuffer		sbUpdUserIdCKYH	= new StringBuffer();
				VslSkdXchEdiHdrVO	tmpHdrVO2		= command.selectVesselScheduleExchangeEdiHdr	(tmpHdrVO);
				
				//::update user id setting:://
				sbUpdUserIdCKYH.append(tmpHdrVO2.getCoCdCtnt());
				//////////////////////////////
				
				/**************************************************************************
				 * Applying to Coastal Schedule from CKYH EDI Data
				 * ========================================================================
				 * CoastalScheduleMgtBC - VesselScheduleMgtBCImpl
				 * 
				 */
				
				List<VslSkdXchEdiDtlVO>	tmpDTLVO2s	= command.selectVesselScheduleExchangeEdiDtlList(tmpHdrVO2);
				
				//public VslSkdChgStsGRPVO manageCstSkdByActual(SwapCstGRPVO swapCstGRPVO)
				//SwapCstGRPVO swapCstGRPVO	= new SwapCstGRPVO();
				
				//*********** VO Setting *******************************//
				
				CstSkdByVvdVO[] cstSkdByVvdVOs	= new CstSkdByVvdVO[tmpDTLVO2s.size()];
				
				log.info("\n\n################### Array Setting Start ###################");
				log.info("\n\n################### Array Size  ["+tmpDTLVO2s.size()+"] ################");
				
				for(int i=0; i<tmpDTLVO2s.size(); i++){
					
					//CstSkdByVvdVO	tmpCstVO			= new CstSkdByVvdVO();
					VslSkdXchEdiDtlVO	tmpVO			= new VslSkdXchEdiDtlVO();
					
					cstSkdByVvdVOs[i]					= new CstSkdByVvdVO();
					
					log.info("\n\n################### Array tmpVO bfr ["+tmpVO+"] ################");
					
					tmpVO								= tmpDTLVO2s.get(i);
					
					log.info("\n\n################### Array tmpVO aft ["+tmpVO+"] ################");
					
					
					log.info("\n\n################### Array ["+tmpVO.getVslCdCtnt()+"] ################");
					log.info("\n\n################### Array ["+tmpVO.getSkdVoyNoCtnt()+"] ################");
					log.info("\n\n################### Array ["+tmpVO.getSkdDirCdCtnt()+"] ################");
					log.info("\n\n################### Array ["+tmpVO.getVpsPortCdCtnt()+"] ################");
					log.info("\n\n################### Array ["+tmpVO.getVpsEtaDtCtnt()+"] ################");
					log.info("\n\n################### Array ["+tmpVO.getVpsEtbDtCtnt()+"] ################");
					log.info("\n\n################### Array ["+tmpVO.getVpsEtdDtCtnt()+"] ################");
					
					log.info("\n\n################### Array ["+tmpVO.getVslSlanCdCtnt()+"] ################");
					
					
					log.info("\n\n################### Array getClptSeq["+tmpVO.getClptSeq()+"] ################");
					log.info("\n\n################### Array getYdCd["+tmpVO.getYdCd()+"] ################");
					log.info("\n\n################### Array getCallYdIndSeq["+tmpVO.getCallYdIndSeq()+"] ################");
					log.info("\n\n################### Array getTmlCd["+tmpVO.getTmlCd()+"] ################");
					log.info("\n\n################### Array getTurnPortFlg["+tmpVO.getTurnPortFlg()+"] ################");
					log.info("\n\n################### Array getTurnPortIndCd["+tmpVO.getTurnPortIndCd()+"] ################");
					log.info("\n\n################### Array getTurnSkdVoyNo["+tmpVO.getTurnSkdVoyNo()+"] ################");
					log.info("\n\n################### Array getTurnSkdDirCd["+tmpVO.getTurnSkdDirCd()+"] ################");
					log.info("\n\n################### Array getTurnClptIndSeq["+tmpVO.getTurnClptIndSeq()+"] ################");
					
					//*********** Array Setting *****************************************//
					cstSkdByVvdVOs[i].setIbflag			("U");
					//=====================================================================
					cstSkdByVvdVOs[i].setVslCd			(tmpVO.getVslCdCtnt		()	);
					cstSkdByVvdVOs[i].setSkdVoyNo		(tmpVO.getSkdVoyNoCtnt	()	);
					cstSkdByVvdVOs[i].setSkdDirCd		(tmpVO.getSkdDirCdCtnt	()	);
					cstSkdByVvdVOs[i].setVpsPortCd		(tmpVO.getVpsPortCdCtnt	()	);
					cstSkdByVvdVOs[i].setClptIndSeq		("1");
					//---------------------------------------------------------------------
					cstSkdByVvdVOs[i].setVslSlanCd		(tmpVO.getVslSlanCdCtnt	()	);
					cstSkdByVvdVOs[i].setNewClptIndSeq	("1");
					//---------------------------------------------------------------------
					//---------------------------------------------------------------------
					cstSkdByVvdVOs[i].setClptSeq		(tmpVO.getClptSeq		()	);
					cstSkdByVvdVOs[i].setYdCd			(tmpVO.getYdCd			()	);
					cstSkdByVvdVOs[i].setCallYdIndSeq	(tmpVO.getCallYdIndSeq	()	);
					cstSkdByVvdVOs[i].setTmlCd			(tmpVO.getTmlCd			()	);
					cstSkdByVvdVOs[i].setTurnPortFlg	(tmpVO.getTurnPortFlg	()	);
					cstSkdByVvdVOs[i].setTurnPortIndCd	(tmpVO.getTurnPortIndCd	()	);
					cstSkdByVvdVOs[i].setTurnSkdVoyNo	(tmpVO.getTurnSkdVoyNo	()	);
					cstSkdByVvdVOs[i].setTurnSkdDirCd	(tmpVO.getTurnSkdDirCd	()	);
					cstSkdByVvdVOs[i].setTurnClptIndSeq	(tmpVO.getTurnClptIndSeq()	);
					//=====================================================================
					
					String sTmpEtaDt	= tmpVO.getVpsEtaDtCtnt	() == null ? "" : tmpVO.getVpsEtaDtCtnt	();
					String sTmpEtbDt	= tmpVO.getVpsEtbDtCtnt	() == null ? "" : tmpVO.getVpsEtbDtCtnt	();
					String sTmpEtdDt	= tmpVO.getVpsEtdDtCtnt	() == null ? "" : tmpVO.getVpsEtdDtCtnt	();
					
					if(!"".equals(sTmpEtaDt))	cstSkdByVvdVOs[i].setVpsEtaDt	(sTmpEtaDt);
					if(!"".equals(sTmpEtbDt))	cstSkdByVvdVOs[i].setVpsEtbDt	(sTmpEtbDt);
					if(!"".equals(sTmpEtdDt))	cstSkdByVvdVOs[i].setVpsEtdDt	(sTmpEtdDt);
					//---------------------------------------------------------------------
					
					log.info("\n\n################### 111111111111 ["+i+"]###################");
					
					////cstSkdByVvdVOs[i].setUpdUsrId		("EDI_XCH_AUTO_MAPPING"		);
					cstSkdByVvdVOs[i].setUpdUsrId		(tmpVO.getUpdUsrId		()	);
					cstSkdByVvdVOs[i].setUpdDt			(tmpVO.getUpdDt			()	);
					
					///////////////////////////////////////////////////////////////////////	
					
					log.info("\n\n################### 2222222222 ["+i+"]###################");
				}
				
				log.info("\n\n################### Array Setting end >> imple start ###################");
				
				//tmpCstVO.setVslCd(vslCd);
				
			
				event.setCstSkdByVvdVOs	(cstSkdByVvdVOs);
				sc.manageCstSkdByVvd	(event);

				//LOGGING//
				///////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////
				
				//////////////////////////////////////////////////
				StringBuffer	sbEdiProcRmk	= new StringBuffer();
				//////////////////////////////////////////////////

				String				sEdiProcRmk	= command.checkScheduleMappingProcRemark		(tmpHdrVO2);
				
				////sbEdiProcRmk.append("Updated Port Count is [");
				////sbEdiProcRmk.append(upCnt[0]);
				////sbEdiProcRmk.append("]");
				////sbEdiProcRmk.append("\n");
				sbEdiProcRmk.append(sEdiProcRmk);
				
				////log.info("\n ::2007816::applyCKYHScheduleToCoastalSchedule:: update count is ["+upCnt+"] \n");
				
				tmpHdrVO2.setEdiProcRmk						(sbEdiProcRmk.toString());
				
				this.begin();
				command.modifyEdiLogFromScheduleExchangeCKYH(tmpHdrVO2);
				
				//::Reflectiong UPDATE USER ID::[EDI_XCH_AUTO_MAPPING]/
				sbUpdUserIdCKYH.append("_EDI_MAPPING");
				tmpHdrVO2.setUpdUsrId(sbUpdUserIdCKYH.toString());
				command.updateCoastalSchedulebyEDICKYH		(tmpHdrVO2);
				this.commit();
				
				///////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////
				
			}
			
			log.info("################### EDI EXCHANGE SCHEDULE FINISHED ################");
				
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
}