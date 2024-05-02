/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MNRCommonSC.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.04
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.05.12 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.12.16 신혜정 [CHM-201115121-01] 유저아이디 Office Change 로 로긴정보 중 RHQ 변경 안되는 로직 보완
* 2011.12.27 신혜정 [CHM-201115280] Estimate Creation 화면 Reefer Uint Maker 필드 추가   
* 2013.01.04 조경완 [CHM-201220942-01] ALPS MNR-Total Loss Module에서 Write Off 처리 건을 위하여 추가 메뉴 개발 요청                       
* 2013.01.04 조경완 [CHM-201220984-01] ALPS MNR-Total Loss-Write Off - Approval
* 2014-02-12 Jonghee HAN EQ_CMPO_CD, EQ_LOC_CD 관련 Validation Error 발생 원인 Terminate
* 2014-02-25 Jonghee HAN Estimate Verify Logic 미수행 Bug Fix (Array 미초기화로 NullPoint Exception 발생)
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.basic.ApprovalStepMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.basic.ApprovalStepMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPartnerVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.basic.StatusHistoryMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.basic.StatusHistoryMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.event.EesMnr0189Event;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.event.MnrComEvent;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration.GeneralCodeSearchMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EtcInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.GeneralCodeSearchGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ServiceProviderInfoListGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.event.MnrEDIInterfaceEvent;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.event.MnrInterfaceEvent;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
	
/**		
 * alps-MNRCommon Business Logic ServiceCommand - alps-MNRCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author park myoung sin
 * @see GeneralCodeSearchMgtDBDAO
 * @since J2EE 1.4
 */
   
public class MNRCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	 
	/**
	 * MNRCommon system 업무 시나리오 선행작업<br>
	 * EES_MNR_INIT업무 시나리오 호출시 관련 내부객체 생성<br>
	 */ 
	
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * MNRCommon system 업무 시나리오 마감작업<br>
	 * EES_MNR_INIT 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("MNRCommonSC 종료");
	}	
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-MNRCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;     
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분   
		if (e.getEventName().equalsIgnoreCase("MnrComEvent")) {
			//공통코드 콤보용
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboInitDataService(e);
			//공통코드 그리드용
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommonInitDataService(e);    
			} 
			//EQ General Info 그리드용 
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEQGeneralInfoService(e);    
			}     
			//Default Unit Of Measure 
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDEFUnitOfMeasureService(e);       
			}  
			// Service Provider Detail Information 공통필요성
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRepairPartnerService(e);     
			}    
			// Agreement Rate 가져오기
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchAgmtRtInfoService(e);	        
			}	    
			// Cost Code 가져오기
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCostCodeService(e); 	        
			}						    
			// Vessel Code과 관련되 Vessel Name,Lane 가져오기
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchVesselInfoService(e); 	        
			}
			//Status History 조회
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchStatusHistoryService(e); 	        
			}	
			//Unit Price 가져오기 
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchUnitPriceService(e);  	        
			} 
			//Customer 가져오기
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchCustomerInfoService(e); 	        
			}
			//Curr Rate 가져오기
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchCurrXchRtInfoService(e); 	        
			}				
			//OFFICE 별 로칼 날짜(YYYY-MM-DD)를 조회
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchLoCalDateInfoService(e);	 	        
			}				
			//SSP 바이어의 접속 오피스 정보를 구함
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchSPPOFCInfoService(e);			 	        
			}
			//Office 의 Rhq Office 정보 가져오기
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchHqOfcByOfcService(e); 	        
			}		
			// eqNo 로 rfUnitMaker 조회
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH20)){
				eventResponse = searchRfUnitMakerService(e);
			}
			// Approval Step 조회
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH21)){
				eventResponse = searchApprovalStepService(e);
			}
			// India SAC Code Validation Check : SAC_CD 유무 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = validSacCd(e);
			}
			// India GST Rate 조회(CGST, SGST, IGST, UGST)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = getIdaGstRto(e);
			}
			//벨리데이션 체크 공통    
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = checkGeneralCodeService(e);      
			}
			//EDI SEND(SUCCESS FLAG = XX)	   
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND40)) {
				eventResponse = reSendErrorEDIService(e);					      
			}
		 } else if(e.getEventName().equalsIgnoreCase("EesMnr0189Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchServiceProviderInfoListService(e);    
			    }    	
		 } else if(e.getEventName().equalsIgnoreCase("MnrInterfaceEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = createFileUploadService(e);     
				} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
					eventResponse = removeFileUploadService(e);          
				} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
					eventResponse = searchFileUploadService(e);          
				} 	
		//EDI  		
		} else if(e.getEventName().equalsIgnoreCase("MnrEDIInterfaceEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {   
				eventResponse = manageMQEstimateService(e);         
			} 
		}   
		return eventResponse;
	}
	
	/**
	 * Receive MQ 연동 처리<br>
	 * UDEVHJS_ALPSMNR_T_WESTIM MQ를 통한 입력처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException 
	 */    

	private EventResponse manageMQEstimateService(Event e) throws EventException {	
		EstimateGRPVO estimateGRPVO = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		RepairMgtBC command2 = new RepairMgtBCImpl();
		EQFlagMgtBC command3 = new EQFlagMgtBCImpl(); 
		
		//edi message를  Event로 받아옴  	    
		MnrEDIInterfaceEvent event = (MnrEDIInterfaceEvent)e;
		 	
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO(); 
			
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVOs = new CustomMnrRprRqstHdrVO();
		try{  		
			begin();	     
			//TMP 테이블에 인서트  
			interfaceGRPVO.setEaiRecMsg(event.getEdi_msg());
			interfaceGRPVO = command.manageMQEstimateBasic(interfaceGRPVO);
			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();
			 	
			//account 다시 세팅	  	   
			SignOnUserAccount ediAccount = new SignOnUserAccount(customMnrRprRqstTmpHdrVO.getCreUsrId(),null,null,null,null,null,null,null, customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt() , customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt(), customMnrRprRqstTmpHdrVO.getCostOfcCd(), null, null, null, null, null, null, null, null, null);
			
			interfaceGRPVO = command.checkEDIEstimateBasic(interfaceGRPVO);
				
			//벨리데이션 통과 했다면
			if(interfaceGRPVO.getValidOk()){
				//견적서 테이블에 인서트
				customMnrRprRqstHdrVOs = command2.ediEstimateCopyToEstimateDetail(interfaceGRPVO);
			
				/***********************FLAG *********************************/
				//STS VO
				CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
				customMnrEqStsVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrEqStsVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
				customMnrEqStsVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd()); 
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				customMnrEqStsVO.setMnrDmgFlgDt(today);	 
				customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd()); 
				customMnrEqStsVO.setMnrStsRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo()); 
				//FLG_HIS_VO
				CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
				customMnrFlgHisVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd());
				customMnrFlgHisVO.setMnrFlgTpCd("DMG"); 
				customMnrFlgHisVO.setMnrFlgInpTpCd("E");      
				customMnrFlgHisVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
				customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd());
				customMnrFlgHisVO.setMnrFlgInpDt(today);         
				customMnrFlgHisVO.setMnrFlgRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo());
				
				//RprWrkTpCd 에 따라 달라짐 무조건 플레깅 
				customMnrFlgHisVO.setMnrStsFlg("1");  
				
				CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];     
				CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];
				  
				arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;	
				arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;	
						
				EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
				eQFlagListINVO.setMnrFlgTpCd("DMG");   
				eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO); 
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
				command3.manageEQFlagListBasic(eQFlagListGRPVO,ediAccount);
				/********************** FLAG END **********************************/

				/***************** MST 외부 인터페이스 호출을 위한 **********************/
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				for(int j = 0;j < arrCustomMnrEqStsVOS.length; j++){
					IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();    
					iFMnrFlagVO.setFlagOfcCd(ediAccount.getOfc_cd());	
					iFMnrFlagVO.setFlagUserId(ediAccount.getUsr_id());
					iFMnrFlagVO.setFlagType("DMG");
					iFMnrFlagVO.setRetireFlag("N");
					iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[j].getEqKndCd());
					iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[j].getEqNo());
					iFMnrFlagVO.setStsFlag("Y");	
					iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[j].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[j].getMnrDmgFlgYdCd());
					iFMnrFlagVOS.add(iFMnrFlagVO);
				}	
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);		
				command.manageIFFlagBasic(interfaceGRPVO,ediAccount);				
				/***************** MST 외부 인터페이스 호출을 위한 *********************/
			}
			commit();
			
			/////////////////////////////////////////////////////////////////////////////////////////////////
			//Verify 기능 추가 Start
			/////////////////////////////////////////////////////////////////////////////////////////////////
			
			estimateGRPVO = new EstimateGRPVO();
			RepairMgtBC commandV0 = new RepairMgtBCImpl();
			
			//Verify 기능 추가 작업 전 조회
			//EDI를 통해 신규로 들어온 데이터들 조회.
			//Param1 : RQST_EQ_NO
			//Param2 : RPR_RQST_SEQ
			//Param3 : RPR_RQST_VER_NO
			EstimateINVO estimateINVOv = new EstimateINVO();
			estimateINVOv.setRqstEqNo(customMnrRprRqstHdrVOs.getRqstEqNo());
			estimateINVOv.setRprRqstSeq(customMnrRprRqstHdrVOs.getRprRqstSeq());
			estimateINVOv.setRprRqstVerNo(customMnrRprRqstHdrVOs.getRprRqstVerNo());
			estimateINVOv.setRprRqstLstVerFlg("Y");			
			estimateGRPVO.setEstimateINVO(estimateINVOv);
						
			estimateGRPVO = commandV0.searchEstimateDtl(estimateGRPVO,account);	
			
			/* 추가 부분 세팅 START
			: INP_MSG35 = AGMT_OFC_CTY_CD
			: INP_MSG36 = AGMT_SEQ
			: INP_MSG37 = 'NNN'
			: INP_MSG4  = 'SS'
			*/		
			GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();			
//			CustomMnrDatVrfyVO customMnrDatVrfyVO = new CustomMnrDatVrfyVO();
			CustomMnrDatVrfyVO[] customMnrDatVrfyVOS = new CustomMnrDatVrfyVO[estimateGRPVO.getCustomMnrRprRqstVDtlVOS().size()];
			
			//2014-02-12 Jonghee HAN EQ_CMPO_CD, EQ_LOC_CD 관련 Validation Error 발생 원인 Terminate
//			for(int k = 0;k < estimateGRPVO.getCustomMnrRprRqstVDtlVOS().size(); k++){
//				customMnrDatVrfyVO.setInpMsg1(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(k).getEqLocCd());
//				customMnrDatVrfyVO.setInpMsg2(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(k).getEqCmpoCd());
//				customMnrDatVrfyVOS[k] = customMnrDatVrfyVO;
//			}
			
			int cnt =  customMnrDatVrfyVOS.length;
			GeneralCodeSearchMgtBC commandV1 = new GeneralCodeSearchMgtBCImpl();	
			
			for(int i = 0;i < cnt; i++){	
				//2014-02-25 Jonghee HAN Estimate Verify Logic 미수행 Bug Fix (Array 미초기화로 NullPoint Exception 발생)
				customMnrDatVrfyVOS[i] = new CustomMnrDatVrfyVO();
				
				customMnrDatVrfyVOS[i].setInpMsg1(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getEqLocCd());
				customMnrDatVrfyVOS[i].setInpMsg2(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getEqCmpoCd());
				customMnrDatVrfyVOS[i].setInpMsg3(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getEqDmgCd());
				customMnrDatVrfyVOS[i].setInpMsg5(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getEqRprCd());
				customMnrDatVrfyVOS[i].setInpMsg6(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getTrfOptCd());
				customMnrDatVrfyVOS[i].setInpMsg7(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getTrfDivCd());
				customMnrDatVrfyVOS[i].setInpMsg8(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getVolTpCd());
				customMnrDatVrfyVOS[i].setInpMsg9(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getRprQty());
				customMnrDatVrfyVOS[i].setInpMsg10(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getRprSzNo());
				customMnrDatVrfyVOS[i].setInpMsg11(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getRprLbrHrs());
				customMnrDatVrfyVOS[i].setInpMsg12(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getRprLbrRt());
				customMnrDatVrfyVOS[i].setInpMsg13(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getLbrCostAmt());
				customMnrDatVrfyVOS[i].setInpMsg14(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getMtrlCostAmt());
				customMnrDatVrfyVOS[i].setInpMsg15(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getMnrWrkAmt());
				customMnrDatVrfyVOS[i].setInpMsg16(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getRprLbrBzcHrs());
				customMnrDatVrfyVOS[i].setInpMsg17(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getLbrMtrlBzcAmt());
				customMnrDatVrfyVOS[i].setInpMsg18(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getRprLbrBzcRt());
				customMnrDatVrfyVOS[i].setInpMsg19(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getCostCd());
				customMnrDatVrfyVOS[i].setInpMsg20(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getCostDtlCd());
				customMnrDatVrfyVOS[i].setInpMsg21(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getMnrLrAcctFlg());
				customMnrDatVrfyVOS[i].setInpMsg22(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getN3ptyFlg());
				customMnrDatVrfyVOS[i].setInpMsg23(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getN3ptyBilLbrHrs());
				customMnrDatVrfyVOS[i].setInpMsg24(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getN3ptyBilLbrRt());
				customMnrDatVrfyVOS[i].setInpMsg25(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getLbrCostAmt());
				customMnrDatVrfyVOS[i].setInpMsg26(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getN3ptyBilMtrlCostAmt());
				customMnrDatVrfyVOS[i].setInpMsg27(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getN3ptyBilAmt());
				customMnrDatVrfyVOS[i].setInpMsg28(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getMnrLbrBzcAmt());
				customMnrDatVrfyVOS[i].setInpMsg29(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getMnrAgmtAmt());
				customMnrDatVrfyVOS[i].setInpMsg30(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getRprDtlRmk());
				customMnrDatVrfyVOS[i].setUpdUsrId(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getUpdUsrId());
				customMnrDatVrfyVOS[i].setCreUsrId(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(i).getCreUsrId());
				
				customMnrDatVrfyVOS[i].setInpMsg35(customMnrRprRqstTmpHdrVO.getAgmtOfcCtyCd());
				customMnrDatVrfyVOS[i].setInpMsg36(customMnrRprRqstTmpHdrVO.getAgmtSeq());
				customMnrDatVrfyVOS[i].setInpMsg37("NNN");
				customMnrDatVrfyVOS[i].setInpMsg4("SS");
						
				//COST_CD 가 누락되어   없으면  여기서 다시 체크하여 넣어준다. INP_MSG19 ,ex) MRRURC
				//누락 되는 케이스를 찾을수가 없음 로그가 필요함
				if(customMnrDatVrfyVOS[i].getInpMsg19().equals("") || customMnrDatVrfyVOS[i].getInpMsg19() ==  null){
					//log.error("☞☞☞☞☞☞☞  COST_CD NOT EXIST ");	
					//log.error("☞☞☞☞☞☞☞  EQ No : " + customMnrRprRqstTmpHdrVO.getRqstEqNo());
					//log.error("☞☞☞☞☞☞☞  Estimate No : " + customMnrRprRqstTmpHdrVO.getRqstRefNo());
					//log.error("☞☞☞☞☞☞☞  EQ TPSZ : " + customMnrRprRqstTmpHdrVO.getEqTpszCd());
					//log.error("☞☞☞☞☞☞☞  Componet CD : " + customMnrDatVrfyVOS[i].getInpMsg19());
					if(customMnrRprRqstTmpHdrVO.getEqKndCd().equals("U")){
						if(customMnrRprRqstTmpHdrVO.getEqTpszCd().startsWith("D")){
							customMnrDatVrfyVOS[i].setInpMsg19("MRDRRC"); 
						} else if(customMnrRprRqstTmpHdrVO.getEqTpszCd().startsWith("R")){
							CostCodeINVO costCodeINVO = new CostCodeINVO();
							//Component Code				
							costCodeINVO.setCmpoCd(customMnrDatVrfyVOS[i].getInpMsg2());
							//Tpsz									
							costCodeINVO.setTpSz(customMnrRprRqstTmpHdrVO.getEqTpszCd());
							CostCodeGRPVO costCodeGRPVO = new CostCodeGRPVO();
							costCodeGRPVO.setCostCodeINVO(costCodeINVO); 		
							costCodeGRPVO = commandV1.searchCostCodeBasic(costCodeGRPVO); 
							List<CustomCostCodeVO> customCostCodeVOS = costCodeGRPVO.getCustomCostCodeVOS(); 
							if(customCostCodeVOS.size() > 0){				
								customMnrDatVrfyVOS[i].setInpMsg19(customCostCodeVOS.get(0).getCostCd());
							} else {					
								//DEFAULT				
								customMnrDatVrfyVOS[i].setInpMsg19("MRRURC"); 
							}
						} else {
							customMnrDatVrfyVOS[i].setInpMsg19("MRDSRC");	
						}			
					} else if(customMnrRprRqstTmpHdrVO.getEqKndCd().equals("G")){
						customMnrDatVrfyVOS[i].setInpMsg19("MRGSRC"); 
					} else {
						customMnrDatVrfyVOS[i].setInpMsg19("MRZSRC");  
					}			
				}
				//COST_DTL_CD 가 누락되어   없으면  여기서 다시 체크하여 넣어준다. INP_MSG20 ,ex) NR	
				if(customMnrDatVrfyVOS[i].getInpMsg20().equals("") || customMnrDatVrfyVOS[i].getInpMsg20() ==  null){
					customMnrDatVrfyVOS[i].setInpMsg20("NR");											  				  
				}
			}
			/* 추가 부분 세팅 END */
			generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(customMnrDatVrfyVOS);
			GeneralCodeCheckMgtBC commandV2  = new GeneralCodeCheckMgtBCImpl();
//			RepairMgtBC 	  	  commandV3 = new RepairMgtBCImpl();
						
			//로직시작
			begin();

			//MNR_DAT_VRFY 테이블에 인서트하고 시퀸스 값을 가져온다.
			String seqValue = commandV2.createMnrTempDetail(generalCodeCheckMgtGRPVO,account);
			
			//값 세팅
			//시퀸스
			EstimateINVO estimateINVO = new EstimateINVO();
			estimateINVO.setTmpSeq(seqValue);
			//AGMT
			estimateINVO.setAgmtOfcCtyCd(customMnrRprRqstTmpHdrVO.getAgmtOfcCtyCd());
			estimateINVO.setAgmtSeq(customMnrRprRqstTmpHdrVO.getAgmtSeq());
			estimateINVO.setAgmtVerNo(customMnrRprRqstTmpHdrVO.getAgmtVerNo());
			//TRF
			estimateINVO.setTrfNo(customMnrRprRqstTmpHdrVO.getEqTpszCd());
			
			//
			estimateINVO.setRqstEqNo(estimateINVOv.getRqstEqNo());
			estimateINVO.setRprRqstVerNo(estimateINVOv.getRprRqstVerNo());
			estimateINVO.setRprRqstSeq(estimateINVOv.getRprRqstSeq());
			estimateGRPVO.setEstimateINVO(estimateINVO);

			//비즈로직에 따른 업데이트 진행
			estimateGRPVO = commandV2.verifyEstimateCalcDetail(estimateGRPVO);
			commit();
			//로직완료 - 재조회기능 필요없음
//			eventResponse =	commandV3.searchLatestEstimateBasic(estimateGRPVO);
//			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstDtlVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0218 : setPopData_Sp <br>
	 * [EES_MNR_0218]Tariff Detail Information_Pop_Up의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairPartnerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try {	
			MnrComEvent event = (MnrComEvent)e;           
			PartnerMgtBC command = new PartnerMgtBCImpl(); 
			RepairPartnerGRPVO repairPartnerGRPVO = new RepairPartnerGRPVO();
			repairPartnerGRPVO.setPartnerMgtINVO(event.getPartnerMgtINVO());   
				
			repairPartnerGRPVO = command.searchRepairPartnerBasic(repairPartnerGRPVO);
			
			//리스트 반환  
			if(event.getPartnerMgtINVO().getMnrPrnrSeq().equals("") || event.getPartnerMgtINVO().getMnrPrnrSeq() == null){
				eventResponse.setRsVoList(repairPartnerGRPVO.getCustomMnrPartnerVOS());
			//단건 반환        
			} else {
				CustomMnrPartnerVO customMnrPartnerVO = repairPartnerGRPVO.getCustomMnrPartnerVO();
				if(customMnrPartnerVO != null){ 
					Map<String, String> mapVO = customMnrPartnerVO.getColumnValues();
					eventResponse.setETCData(mapVO);   
				}  
			}
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse; 
	}
	
	/**
	 * EES_MNR_0226 : Save <br>
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */					
	private EventResponse searchComboInitDataService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
		try {
			
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setComboInitDataINVOS(event.getComboInitDataINVOS());
			
			begin();
			generalCodeSearchGRPVO = command.searchComboInitDataListBasic(generalCodeSearchGRPVO,account);
			commit(); 
			
			//조회해온 데이타를 분해한다.   
			for (int i = 0; i < generalCodeSearchGRPVO.getListCustomMnrGeneralCodeVOS().size(); i++) {
				eventResponse.setRsVoList(generalCodeSearchGRPVO.getListCustomMnrGeneralCodeVOS().get(i));
			}     
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return eventResponse;
	}
		
	/**
	 * EES_MNR_0023 : t1sheet1_OnChange <br>
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
		try {
			MnrComEvent event = (MnrComEvent)e;            
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			CostCodeGRPVO costCodeGRPVO = command.searchCostCodeBasic(event.getCostCodeGRPVO());
			eventResponse.setRsVoList(costCodeGRPVO.getCustomCostCodeVOS());  
		 } catch(EventException ex){ 
				throw ex; 
		 } catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		 }	
		 return eventResponse;
	}
	
	/**
	 * EES_MNR_0223 : New <br>
	 * [EES_MNR_0223]MNR PFMC by VNDR/Manufacturer의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonInitDataService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;           
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setCommonInitDataINVO(event.getCommonInitDataINVO());
			  
			generalCodeSearchGRPVO = command.searchCommonInitDataListBasic(generalCodeSearchGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			//다중조회
			for (int i = 0; i < generalCodeSearchGRPVO.getListCustomMnrGeneralCodeVOS().size(); i++) {
				eventResponse.setRsVoList(generalCodeSearchGRPVO.getListCustomMnrGeneralCodeVOS().get(i));
			}
			return eventResponse;
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	/**
	 * EES_MNR_0226 : Retrieve <br>
	 * [EES_MNR_0226]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQGeneralInfoService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;         
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setEQGeneralInfoINVO(event.getEQGeneralInfoINVO());
			   
			generalCodeSearchGRPVO = command.searchEQGeneralInfoBasic(generalCodeSearchGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
			for (int i = 0; i < generalCodeSearchGRPVO.getListCustomMnrEqStsVVOs().size(); i++) {
				eventResponse.setRsVoList(generalCodeSearchGRPVO.getListCustomMnrEqStsVVOs().get(i));
			}
			return eventResponse; 
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}     
	  
	/**
	 * EES_MNR_0226 : yd_cd_confirm <br>
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGeneralCodeService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters) 
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeCheckMgtBC command = new GeneralCodeCheckMgtBCImpl(); 
			GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
			generalCodeCheckMgtGRPVO.setGeneralCodeINVO(event.getGeneralCodeINVO());
			           
			generalCodeCheckMgtGRPVO = command.checkGeneralCodeBasic(generalCodeCheckMgtGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			         
			eventResponse.setRsVoList(generalCodeCheckMgtGRPVO.getCustomMnrGeneralCodeVOS());
			return eventResponse; 
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
    
    /**
     * EES_MNR_0011 : eq_knd_cd onChange <br>
     * [EES_MNR_0011] 스탠다드 타리프의 EQ TYPE별 디폴트 Unit Of Measure를 구합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDEFUnitOfMeasureService(Event e) throws EventException {
    	try {
    		MnrComEvent event = (MnrComEvent)e;    
	    	GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();  
	    	DefaultUnitOfMeasureVO defaultUnitOfMeasureVO = command.searchDEFUnitOfMeasureBasic(event.getDefaultUnitOfMeasureVO());
	    	GeneralEventResponse eventResponse = new GeneralEventResponse();    
	    	eventResponse.setETCData("Measure",defaultUnitOfMeasureVO.getMnrMeasUtCd()); 
	    	return eventResponse;  
    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
  
	
	/**
	 * EES_MNR_0226 : calculateAgmtRateSubSum <br>
	 * [EES_MNR_0226]Simple W/O Inquiry Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtRtInfoService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;         
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			AGMTRtGRPVO agmtRtGRPVO = event.getAGMTRtGRPVO();
			agmtRtGRPVO = 	command.searchAgmtRtInfoBasic(agmtRtGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
			eventResponse.setRsVoList(agmtRtGRPVO.getAGMTRtListVOS());
			return eventResponse;
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	
	/**
	 * EES_MNR_0200 : t2_sheet8_OnPopupClick <br>
	 * [EES_MNR_0200]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileUploadService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			MnrInterfaceEvent event = (MnrInterfaceEvent)e;
			InterfaceMgtBC command = new InterfaceMgtBCImpl();    
						
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			interfaceGRPVO = command.searchFileUploadBasic(event.getInterfaceGRPVO().getFileSeq(), account); 
			eventResponse.setRsVoList(interfaceGRPVO.getListCustomMnrFileAtchVOs());
			return eventResponse; 
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	
	/**
	 * FileUpload :   <br>
	 * [FileUpload] 의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */ 
	private EventResponse createFileUploadService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		String seqValue  = "";
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MnrInterfaceEvent event = (MnrInterfaceEvent)e;
		InterfaceMgtBC command = new InterfaceMgtBCImpl(); 
		try{       
			begin();                   
			seqValue = command.createFileUploadBasic(event.getInterfaceGRPVO(), account);
			
			//썸네일 이미지 파일들을 MNR_FILE_ATCH_EXTR로 저장 시작
			if("Y".equals(e.getAttribute("thumbnail"))){
				if(event.getAttribute("filePathNm") != null || "".equals(event.getAttribute("filePathNm"))){
					String[] filePathNm = (String[]) event.getAttribute("filePathNm");
					command.createFileUploadThumbnail(seqValue, filePathNm, event.getInterfaceGRPVO(), account);
				}	
			}
			//썸네일 이미지 파일들을 MNR_FILE_ATCH_EXTR로 저장 종료
			commit();                 
		}catch(EventException ex){ 
			rollback();  
			throw ex; 
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		eventResponse.setETCData("seqValue", seqValue);
		return eventResponse;		
	}	
	
	/**
	 * EES_MNR_0159 : file_Remove <br>
	 * [EES_MNR_0159]Total Loss Request의 정보를 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeFileUploadService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MnrInterfaceEvent event = (MnrInterfaceEvent)e;
		InterfaceMgtBC command = new InterfaceMgtBCImpl();  
		try{       
			begin();	 	                  
			command.removeFileUploadBasic(event.getInterfaceGRPVO(), account);
			commit();                  
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
	 * EES_MNR_0189 : doIBSEARCH <br>
	 * [EES_MNR_0189]M&R Service Provider Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceProviderInfoListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
		try {
			EesMnr0189Event event = (EesMnr0189Event)e;         
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO = event.getServiceProviderInfoListGRPVO();
			                                                     
			serviceProviderInfoListGRPVO = 	command.searchServiceProviderInfoListBasic(serviceProviderInfoListGRPVO);
			eventResponse.setRsVoList(serviceProviderInfoListGRPVO.getCustomMdmVendorVOS());
		 
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * EES_MNR_0194 : setVesselInfo <br>
	 * [EES_MNR_0194]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchVesselInfoService(Event e) throws EventException {
    	try {	
    		// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setVesselInfoVO(event.getVesselInfoVO());
			
			generalCodeSearchGRPVO = command.searchVesselInfoBasic(generalCodeSearchGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
			eventResponse.setRsVoList(generalCodeSearchGRPVO.getVesselInfoVOS());  
			return eventResponse;
    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
    
    /**
     * EES_MNR_0155 : setCustomerName <br>
     * [EES_MNR_0155]Disposal Buyer Management의 정보를 조회 합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCustomerInfoService(Event e) throws EventException {
    	try {
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setCustomerInfoVO(event.getCustomerInfoVO());
			
			generalCodeSearchGRPVO = command.searchCustomerInfoBasic(generalCodeSearchGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
			eventResponse.setRsVoList(generalCodeSearchGRPVO.getCustomerInfoVOS());  
			return eventResponse;
    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
    
    /**
     * EES_MNR_0098 : sheet1_OnSearchEnd <br>
     * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchStatusHistoryService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			MnrComEvent event = (MnrComEvent)e;           
			StatusHistoryMgtBC command = new StatusHistoryMgtBCImpl(); 
			StatusHistoryGRPVO statusHistoryGRPVO = event.getStatusHistoryGRPVO();
				
			statusHistoryGRPVO = command.searchStatusHistoryBasic(statusHistoryGRPVO);
			
			eventResponse.setRsVoList(statusHistoryGRPVO.getListCustomMnrStsHisVO());
			return eventResponse; 
		} catch(EventException ex){ 
			throw ex; 		
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	
	/**
	 * EES_MNR_0157 : setEqInfo <br>
	 * [EES_MNR_0157]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnitPriceService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			MnrComEvent event = (MnrComEvent)e;            
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			UnitPriceGRPVO unitPriceGRPVO = event.getUnitPriceGRPVO();
			
			unitPriceGRPVO = command.searchUnitPriceBasic(unitPriceGRPVO); 
				
			eventResponse.setETCData("match_type",unitPriceGRPVO.getOutCustomUnitPriceVO().getMatchType());
			eventResponse.setETCData("match_cnt",unitPriceGRPVO.getOutCustomUnitPriceVO().getMatchCnt());
			eventResponse.setETCData("curr_cd",unitPriceGRPVO.getOutCustomUnitPriceVO().getCurrCd());
			eventResponse.setETCData("mnr_disp_trf_tot",unitPriceGRPVO.getOutCustomUnitPriceVO().getMnrDispTrfTot());
			eventResponse.setETCData("price",unitPriceGRPVO.getOutCustomUnitPriceVO().getMnrDispTrfAvg());
			return eventResponse; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	
	/**
	 * [EES_MNR_QEXE] 에러난 EDI 재전송해줌.FLAG XX <br>
	 *	 	
	 * @param Event e		
	 * @return EventResponse	
	 * @exception EventException	
	 */
	private EventResponse reSendErrorEDIService(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		RepairMgtBC command2 = new RepairMgtBCImpl();
		EQFlagMgtBC command3 = new EQFlagMgtBCImpl(); 
		
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO(); 
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		begin();
		try{  		
			
			//재전송할 목록 조회 			  	
			interfaceGRPVO = command.searchReSendErrorEDIListBasic(interfaceGRPVO);
			List<CustomMnrRprRqstTmpHdrVO> customMnrRprRqstTmpHdrVOS = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVOS();
			
			for (int i = 0; i < customMnrRprRqstTmpHdrVOS.size(); i++) {
				//2. 처리할 데이타 가져옴 
				CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = customMnrRprRqstTmpHdrVOS.get(i);
				interfaceGRPVO.setCustomMnrRprRqstTmpHdrVO(customMnrRprRqstTmpHdrVO);
				//VENDER 없는건 패스	
				if(customMnrRprRqstTmpHdrVO.getVndrSeq().equals("")){
					//VE처리 	
					interfaceGRPVO.setEdiErrCd("VE");	
					interfaceGRPVO = command.reSendErrorEDIBasic(interfaceGRPVO);
					continue;	
				}	
				//Estimate Number 없는건 패스 	
				if(customMnrRprRqstTmpHdrVO.getRqstRefNo().equals("")){
					//RE처리		 
					interfaceGRPVO.setEdiErrCd("RE");			
					interfaceGRPVO = command.reSendErrorEDIBasic(interfaceGRPVO);
					continue;			
				}
					
				//account 다시 세팅	  	   
				SignOnUserAccount ediAccount = new SignOnUserAccount(customMnrRprRqstTmpHdrVO.getCreUsrId(),null,null,null,null,null,null,null, customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt() , customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt(), customMnrRprRqstTmpHdrVO.getCostOfcCd(), null, null, null, null, null, null, null, null, null);
				
				//1. XX = SS처리 	
				//2. 처리할 데이타 가져옴 
				interfaceGRPVO.setEdiErrCd("SS");
				interfaceGRPVO = command.reSendErrorEDIBasic(interfaceGRPVO);
				
				//견적서 테이블에 인서트
				command2.ediEstimateCopyToEstimateBasic(interfaceGRPVO);
					
				/***********************FLAG *********************************/
				//STS VO
				CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
				customMnrEqStsVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrEqStsVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
				customMnrEqStsVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd()); 
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				customMnrEqStsVO.setMnrDmgFlgDt(today);	 
				customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd()); 
				customMnrEqStsVO.setMnrStsRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo()); 
				//FLG_HIS_VO
				CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
				customMnrFlgHisVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd());
				customMnrFlgHisVO.setMnrFlgTpCd("DMG"); 
				customMnrFlgHisVO.setMnrFlgInpTpCd("E");      
				customMnrFlgHisVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
				customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd());
				customMnrFlgHisVO.setMnrFlgInpDt(today);         
				customMnrFlgHisVO.setMnrFlgRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo());
				
				//RprWrkTpCd 에 따라 달라짐 무조건 플레깅 
				customMnrFlgHisVO.setMnrStsFlg("1");  
				
				CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];     
				CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];
				  
				arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;	
				arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;	
				
				EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
				eQFlagListINVO.setMnrFlgTpCd("DMG");   
				eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO); 
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
				command3.manageEQFlagListBasic(eQFlagListGRPVO,ediAccount);
				/********************** FLAG END **********************************/
				/***************** MST 외부 인터페이스 호출을 위한 **********************/
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				for(int j = 0;j < arrCustomMnrEqStsVOS.length; j++){
					IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();    
					iFMnrFlagVO.setFlagOfcCd(ediAccount.getOfc_cd());	
					iFMnrFlagVO.setFlagUserId(ediAccount.getUsr_id());
					iFMnrFlagVO.setFlagType("DMG");		
					iFMnrFlagVO.setRetireFlag("N");	
					iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[j].getEqKndCd());
					iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[j].getEqNo());
					iFMnrFlagVO.setStsFlag("Y");	
					iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[j].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[j].getMnrDmgFlgYdCd());
					iFMnrFlagVOS.add(iFMnrFlagVO);	
				}					
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);		
				command.manageIFFlagBasic(interfaceGRPVO,ediAccount);				
				/***************** MST 외부 인터페이스 호출을 위한 *********************/
			}
			commit();  
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0041 : setCurrRate <br>
	 * [EES_MNR_0041]Conversion할 Curr rate를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrXchRtInfoService(Event e) throws EventException {
		try {			
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			MnrComEvent event = (MnrComEvent)e;            
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			UnitPriceGRPVO unitPriceGRPVO = event.getUnitPriceGRPVO();
					
			unitPriceGRPVO = command.searchCurrXchRtInfoBasic(unitPriceGRPVO);
			
			eventResponse.setETCData("XchRt",unitPriceGRPVO.getCustomCurrXchRtVO().getXchRt());
			eventResponse.setETCData("DpPrcsKnt",unitPriceGRPVO.getCustomCurrXchRtVO().getDpPrcsKnt());
			
			return eventResponse; 

    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}	
	
	/**
	 * CoMnr : MnrGetLocalDate <br>
	 * [CoMnr] OFFICE 별 로칼 날짜(YYYY-MM-DD)를 조회합니다. <br>
	 * [CoMnr] OFFICE 별 로칼 날짜(YYYY-MM-DD)를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoCalDateInfoService(Event e) throws EventException {
		try {				
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			MnrComEvent event = (MnrComEvent)e;            
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			EtcInfoGRPVO etcInfoGRPVO = event.getEtcInfoGRPVO();
			
			etcInfoGRPVO = command.searchLoCalDateInfoBasic(etcInfoGRPVO);						
			
			eventResponse.setETCData("LCLDATE",etcInfoGRPVO.getOutCustomLocalDateVO().getLocTime());
			eventResponse.setETCData("WORKENABLE",etcInfoGRPVO.getOutCustomLocalDateVO().getWorkEnable());
			
			return eventResponse; 
			
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}	
	
	/**
	 * CoMnr : MnrGetSPPPartnerOFC <br>
	 * [CoMnr] SPP바이어 OFC정보를 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSPPOFCInfoService(Event e) throws EventException {
		try {				
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			MnrComEvent event = (MnrComEvent)e;            
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			EtcInfoGRPVO etcInfoGRPVO = event.getEtcInfoGRPVO();
			
			etcInfoGRPVO = command.searchSPPOFCInfoBasic(etcInfoGRPVO);						
			
			eventResponse.setETCData("SPPOFCCD",etcInfoGRPVO.getOutCustomSPPOFCVO().getSppOfcCd());
			
			return eventResponse; 
			
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}	
	
    /**
     * CoMnr : MnrHqOfcByOfc <br>
     * [CoMnr]오피스 코드의 해당 Rhq 오피스 코드 정보 가져오기. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchHqOfcByOfcService(Event e) throws EventException {
    	try {
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			
			String hqOfc = null;
			hqOfc = command.searchHqOfcByOfcBasic(event.getCustomerInfoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
			eventResponse.setETCData("hq_ofc_by_ofc", hqOfc);  
			return eventResponse;
    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
    
    /**
	 * EES_MNR_0019 : searchRfUnitMakerService <br>
	 * [EES_MNR_0019] rfUnitMaker를 조회 합니다. <br>
	 * 
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchRfUnitMakerService(Event e) throws EventException {
    	try {
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			CustomMnrEqStsVVO customMnrEqStsVVO = null;
			
			customMnrEqStsVVO = command.searchRfUnitMakerBasic(event.getCommonInitDataINVO().getEqNo());
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
	
			if(customMnrEqStsVVO != null){
				eventResponse.setETCData("disposal", customMnrEqStsVVO.getDspFlag());  
				eventResponse.setETCData("rf_unit_maker", customMnrEqStsVVO.getMkrNm());	
			}else{
				eventResponse.setETCData("disposal", "");  
				eventResponse.setETCData("rf_unit_maker", "");
			}
			
			return eventResponse;
    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
    
    /**
     * EES_MNR_0262 : h1sheet1_OnSearchEnd <br>
     * [EES_MNR_0262] Approval Step 의 정보를 조회 합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchApprovalStepService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			MnrComEvent event = (MnrComEvent)e;           
			ApprovalStepMgtBC command = new ApprovalStepMgtBCImpl(); 
			ApprovalStepGRPVO approvalStepGRPVO = event.getApprovalStepGRPVO();
			if("".equals(approvalStepGRPVO.getApprovalStepINVO().getWrtfNo())||"NEW".equals(approvalStepGRPVO.getApprovalStepINVO().getWrtfNo())){	
				approvalStepGRPVO = command.searchApprovalStepBasic(approvalStepGRPVO, account);
				eventResponse.setRsVoList(approvalStepGRPVO.getListCustomApprovalStepVO());
			}else{
				approvalStepGRPVO = command.searchApprovalStepHistoryBasic(approvalStepGRPVO);
				eventResponse.setRsVoList(approvalStepGRPVO.getListCustomApprovalStepHistoryVO());
			}
			
			return eventResponse; 
		} catch(EventException ex){ 
			throw ex; 		
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	
	/**
	 * India SAC Code의 존재 유무 확인 <br>
	 * SAC Code의 Validate Check의 Error Flag 리턴<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse validSacCd(Event e) throws EventException {
		MnrComEvent event = (MnrComEvent)e;
		EventResponse eventResponse = null;

		try {
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();			
			eventResponse = command.validSacCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse getIdaGstRto(Event e) throws EventException {
		MnrComEvent event = (MnrComEvent)e;
		EventResponse eventResponse = null;

		try {
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();			
			eventResponse = command.getIdaGstRto(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}