/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : JointOperationSettlementSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.07.29 민정호
* 1.0 Creation
* --------------------------------------------------------
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement;
 
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBC;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic.CarrierSettlementProcessBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0012Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0103Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBC;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0016Event;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBC;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.bizcommon.util.BizComUtil;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.StringUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.basic.SettlementProcessBC;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.basic.SettlementProcessBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.SltHirTgtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoEstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0104Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0105Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0106Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0107Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0108Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0109Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0110Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0111Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0113Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0114Event;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoLoadingVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.MvntEvntDtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlTgtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlStsVO;

/**
 * ALPS-JointOperationSettlementSC Business Logic ServiceCommand -
 * ALPS-JointOperationSettlementSC 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author JungHo Min
 * @see JointOperationConsultationDBDAO
 * @since J2EE 1.4
 */

public class JointOperationSettlementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * JointOperationSettlementSC system 업무 시나리오 선행작업<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * JointOperationSettlementSC system 업무 시나리오 마감작업<br>
	 */
	public void doEnd() {
		log.debug("JointOperationSettlementSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-JointOperationAgreementSettlement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		            
        if (e.getEventName().equalsIgnoreCase("FnsJoo0104Event")) {
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJointOperationAccrualList(e);
			}
			/* 2. Save */
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageJointOperationAccrual(e);
			}
			/* 조회 조건 변경시 */
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCond0104(e);
			}
			/* 5. Open */
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0104(e);				
			}
			/* 6. Call Batch */
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = callSLOTProcedure(e);				
			}
	    }else if (e.getEventName().equalsIgnoreCase("FnsJoo0105Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {        	
	           eventResponse = searchRobSummaryList(e);               
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchVslSkdEtd(e);	        	
				/* BackEndJob 상태조회 */
	   		}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
					eventResponse = searchRobSummaryEndJobStatus(e);
				/* BackEndJob 결과조회 */
	   		}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
					try{
						eventResponse = searchRobSummaryBackEndJobResult(e);
					}catch(BackEndJobException ex){
						throw new EventException(ex.getMessage());
					}
	   		}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// RDR Port 저장
	            eventResponse = manageRDRPort(e);
	   		}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Jo Loading 
	            eventResponse = manageJoLoading(e);      	            
	   		}else if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {
				eventResponse = callJELProcedure(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0106Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSettlementOTHList(e);
			//중복체크하는 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSettlementOTH(e);
			//VVD변경 (9자리 변경)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				FnsJoo0106Event event = (FnsJoo0106Event)e;
				eventResponse = searchRevDirList(event.getProcSettlementVO());
			//VVD변경
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStlVvdOTH(e);
			//Create
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddStlOTHList(e);
				//마감여부 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCloseYn(e);
			// S/H - M/S인 경우 BSA Type이 변경될 때 맞는 BSA Type인지 Check한다.
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBsaTypeValidationCheck(e);
			// Open시
	    	} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0012(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("FnsJoo0107Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0091(e);
		    }else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJoSettlementStatusList(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {
//				eventResponse = callProcedure(e);
			}			
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0108Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0057(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
//              eventResponse = searchTDRCarrierCodeString(e);
            	eventResponse = searchJoRevCarrierCodeString(e);                
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchTDRRatioCountByLane(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchTDRDownloadListByLane(e);
	   		}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Jo Revenue  Loading 
	            eventResponse = manageJoRevLoading(e);      	                            
            }			
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0109Event")) {			
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {        	
                eventResponse = searchMvntEvntDateList(e);	        	
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSkdEvntDatet(e);
	        }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageMvntEvntDate(e);	        	                
	        }else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = callMVMTProcedure(e);	                
	        }else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
                eventResponse = callMVMTALLProcedure(e);	                
	        }		
		} else if (e.getEventName().equalsIgnoreCase("FnsJoo0110Event")) {
			/* 1. Retirieve */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStlTgtList(e);
			}
			/* 2. Save */
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStlTgt(e);
			}
			/* 2. Sublet OUS/RF Save */
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageStlTgtSublet(e);
			}			
			/* 조회 조건 변경시 */
//			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
//				eventResponse = searchCondStl(e);
//			}
			/* 5. Open */
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0110(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)){			// Trd_cd
				eventResponse = searchTrdList(e);									
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)){			// Rlane_cd
				eventResponse = searchLaneList(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)){			// Carrier 조회
				eventResponse = searchCrrList(e);				
			}			
	    }else if (e.getEventName().equalsIgnoreCase("FnsJoo0111Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {        	
	           eventResponse = searchExpRptList(e);               
	        }
//	        else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//	            eventResponse = searchVslSkdEtd(e);	        	
//				/* BackEndJob 상태조회 */
//	   		}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
//					eventResponse = searchRobSummaryEndJobStatus(e);
//				/* BackEndJob 결과조회 */
//	   		}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
//					try{
//						eventResponse = searchRobSummaryBackEndJobResult(e);
//					}catch(BackEndJobException ex){
//						throw new EventException(ex.getMessage());
//					}
//	   		}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// RDR Port 저장
//	            eventResponse = manageRDRPort(e);
//	   		}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Jo Loading 
//	            eventResponse = manageJoLoading(e);      	            
//	   		}else if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {
//				eventResponse = callJELProcedure(e);
//			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0112Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = openFnsJoo0057(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchTDRCarrierCodeString(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchTDRRatioCountByLane(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchTDRDownloadListByLane(e);
	   		}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Jo Revenue  Loading 
	            eventResponse = manageJoRevLoading(e);      	                            
            }			        
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0113Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0113(e);
		    }else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJoSettlementPicList(e);
		    }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePic(e);            					
            }
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0114Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
                eventResponse = openFnsJoo0113(e);
		    }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMultiPic(e);            					                
		    }        	        	
	    }
        
		return eventResponse;
	}

	/**
	 * FNS_JOO_0104 : Retrieve
	 * Estimate Performance Creation - Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchJointOperationAccrualList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0104Event event = (FnsJoo0104Event) e;

		List<SltHirTgtVO> list = null;
		list = command.searchJointOperationAccrualList(event.getJoSettlementConditionVO());
		eventResponse.setRsVoList(list);
		
		//첫page인 경우만 total값을 조회한다.
		if ("1".equals(event.getJoSettlementConditionVO().getPageNo())){
			SltHirTgtVO sltHirTgtVO = command.searchJointOperationAccrualTotal(event.getJoSettlementConditionVO());
			
			eventResponse.setETCData("tot_page_cnt" , sltHirTgtVO.getTotPageCnt());		// 페이지 개수			
		}

		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0104 : Save
	 * D : [FnsJoo0104Event] <br>
	 * [JO Target Creation and Basic Slot Hire Settlement ]을 [Save]합니다. <br>
	 *
	 * @param FnsJoo0104Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageJointOperationAccrual(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0104Event event = (FnsJoo0104Event) e;

		try {
			begin();
			command.manageJointOperationAccrual(event.getSltHirTgtVOs(), event.getJoSettlementConditionVO(), this.account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;					
	}
		
    /**
     * FNS_JOO_0104 : Retrieve
     * Estimate Performance Creation 을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchCond0104(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		SettlementProcessBC command = new SettlementProcessBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsJoo0104Event event = (FnsJoo0104Event)e;

		JoEstmConditionVO estmConditionVO = event.getJoEstmConditionVO();

		String estmCondFlg = estmConditionVO.getEstmCondFlg();

		List<JoEstmConditionVO> list = null;

		String estmClzFlg = "N";
		String trdCombo   = "";
		String laneCombo  = "";
		String crrCombo   = "";

		switch (Integer.parseInt(estmCondFlg)){
			//exe_yrmon이나 re_divr_cd가 변경된경우
			case 1 :
				JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
				jooCodeParamVO.setSuperCd1(estmConditionVO.getExeYrmon());
				JooCodeInfoVO jooCodeInfoVO = command.searchCheckEstmClz(jooCodeParamVO);
				estmClzFlg = jooCodeInfoVO.getCode();
			//rev_yrmon period가 변경된 경우
			case 2 :
				//Trade Code List 조회
				list = command.searchTradeCodeListEstm(estmConditionVO);
				trdCombo = makeEstmComboString(list, 0);
			//trad변경된경우
			case 3 :
				//Rlane Code List 조회
				list = command.searchRlaneCodeListEstm(estmConditionVO);
				laneCombo = makeEstmComboString(list, 1);
			//lane변경된경우
			case 4 :
				//Carrier Code List 조회
				list = command.searchCarrierCodeListEstm(estmConditionVO);
				crrCombo = makeEstmComboString(list, 2);
				break;
		}

		eventResponse.setETCData("estm_clz_flg", estmClzFlg);
		eventResponse.setETCData("TRD_CD"      , trdCombo);
		eventResponse.setETCData("RLANE_CD"    , laneCombo);
		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
		return eventResponse;
	}	
	
	/**
	 * FNS_JOO_0007, FNS_JOO_0009, FNS_JOO_0010, FNS_JOO_0011, FNS_JOO_0012, FNS_JOO_0013, FNS_JOO_0014 : VVD(9자리) 변경
	 * @param ProcSettlementVO procSettlementVO
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRevDirList(ProcSettlementVO procSettlementVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		List<ProcSettlementVO> list = command.searchRevDirList(procSettlementVO);

		if (list.isEmpty()){
			eventResponse.setETCData("ERR_CD", "E");
		}else{
			eventResponse.setETCData("ERR_CD", "N");
		}

		StringBuilder comboList = new StringBuilder();

		for (int i=0; i < list.size(); i++){
			if (i == list.size()-1){
				comboList.append(list.get(i).getRevDirCd());
			}else{
				comboList.append(list.get(i).getRevDirCd()+"|");
			}
		}

		eventResponse.setETCData("REV_DIR_LIST", comboList.toString());

		return eventResponse;
	}
	
    /**
     * FNS_JOO_0104 : Open
     * Trade, Carrier, Lane Code Combo조회
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse openFnsJoo0104(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		SettlementProcessBC command = new SettlementProcessBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		String exeYrmon = "";
		String currentYrmon = "";
		
		// 마감여부 조회
		try{
			currentYrmon = DateTime.getFormatDate(new java.util.Date(), "yyyyMM");								
//			exeYrmon = DateTime.addMonths(currentYrmon, -1, "yyyyMM");
			exeYrmon = currentYrmon;
			
			jooCodeParamVO.setSuperCd1(exeYrmon);
		}catch(Exception ex){
			throw new EventException(ex.toString());
		}

		JooCodeInfoVO jooCodeInfoVO = command.searchCheckEstmClz(jooCodeParamVO);

		JoEstmConditionVO joEstmConditionVO = new JoEstmConditionVO();
//		estmConditionVO.setRevYrmonFr(exeYrmon.substring(0, 4)+"01");
//		estmConditionVO.setRevYrmonTo(exeYrmon);
		joEstmConditionVO.setRevYrmonFr(exeYrmon);
		joEstmConditionVO.setRevYrmonTo(exeYrmon);
		

		//Trade Code List 조회
		List<JoEstmConditionVO> list = command.searchTradeCodeListEstm(joEstmConditionVO);

		String trdCombo = makeEstmComboString(list, 0);

		//Rlane Code List 조회
		list = command.searchRlaneCodeListEstm(joEstmConditionVO);
		String laneCombo = makeEstmComboString(list, 1);

		//Carrier Code List 조회
		list = command.searchCarrierCodeListEstm(joEstmConditionVO);
		String crrCombo = makeEstmComboString(list, 2);

		eventResponse.setETCData("EXE_YRMON" , exeYrmon);
		eventResponse.setETCData("jo_crr_cd" , crrCombo);
		eventResponse.setETCData("trd_cd"    , trdCombo);
		eventResponse.setETCData("rlane_cd"  , laneCombo);
		eventResponse.setETCData("estm_clz_flg"  , jooCodeInfoVO.getCode());
		return eventResponse;
	}	

	/**
	 * FNS_JOO_0104 : Call Procedure - JOO_SLT_ALL_PRC
	 * JO Target Creation and Basic Slot Hire Settlement
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse callSLOTProcedure(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0104Event event = (FnsJoo0104Event)e;
		JoEstmConditionVO estmConditionVO = event.getJoEstmConditionVO();
		
		String pErrorCode = "";
		try {
			pErrorCode = command.callSLOTProcedure(estmConditionVO);

			if("Y".equals(pErrorCode.substring(0,1)))
				eventResponse.setUserMessage(new ErrorHandler("MAS00034", new String[]{"Data","created"}).getUserMessage());
			else
				eventResponse.setUserMessage(new ErrorHandler("MAS00035", new String[]{"Data","create"}).getUserMessage());
			
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * EstmConditionVO list를 IBSheet내에서 사용할 수 있도록 String으로 변환
	 * @param List<EstmConditionVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	private String makeEstmComboString(List<JoEstmConditionVO> list, int flg) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			JoEstmConditionVO joEstmConditionVO = (JoEstmConditionVO)iterator.next();

			if (flg==0){
				sb.append(joEstmConditionVO.getTrdCd()+"|");
			}else if (flg==1){
				sb.append(joEstmConditionVO.getRlaneCd()+"|");
			}else if (flg==2){
				sb.append(joEstmConditionVO.getJoCrrCd()+"|");
			}
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}

		return rtnVal;
	}
	
//===============================================================================================================
	/**
	 * FNS_JOO_0103 : btn_retrive<br>
	 * ROB Summary 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRobSummaryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0105Event event = (FnsJoo0105Event) e;
		TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
		
		List<JoLoadingVO> list = null;		
		list = command.searchRobSummaryList(tdrLoadVO, account, "1");
		eventResponse.setRsVoList(list);

		return eventResponse;								
	}		
		
	/**
	 * FNS_JOO_0103 : btn_retrive<br>
	 * Vessle ETD Schedule  리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslSkdEtd(Event e) throws EventException {
		try{
			FnsJoo0103Event event = (FnsJoo0103Event)e;
			CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl(); 
            
			TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
    		List<TdrLoadVO> list = command.searchVslSkdEtd(tdrLoadVO);
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }		
	}			
	
	
    /**
     * FNS_JOO_0103 : BackEndJob 상태 조회
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchRobSummaryEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		String key = (String)e.getAttribute("key");
		String status = command.searchRobSummaryEndJobStatus(key);
		eventResponse.setETCData("jb_sts_flg", status);
		return eventResponse;
	}


	/**
	 * FNS_JOO_0103 : BackEndJob 결과 조회
     * @param Event e
     * @return EventResponse
	 * @throws BackEndJobException
	 */
	private EventResponse searchRobSummaryBackEndJobResult(Event e) throws BackEndJobException {
		String key = (String)e.getAttribute("key");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList((List<TdrLoadVO>)BackEndJobResult.loadFromFile(key));
		return eventResponse;
	}	
	
	/**
	 * FNS_JOO_0103 : Save<br>
	 * RDR Port 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRDRPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0103Event event = (FnsJoo0103Event)e;
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
		
		try{
			begin();
			command.manageRDRPort(event.getTdrLoadVOs(), event.getRlaneCd(),  account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
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
	 * FNS_JOO_0105 : Save<br>
	 * Jo Loading 정보를 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageJoLoading(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0105Event event = (FnsJoo0105Event)e;
		SettlementProcessBC command = new SettlementProcessBCImpl();
		
		try{
			begin();
			command.manageJoLoading(event.getJoLoadingVOs(), event.getRlaneCd(),  account, "Exp");
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
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
	 * FNS_JOO_0105 : Call Procedure - JOO_ROB_CNTR_SMRY_PAS_PRC
	 * JO Expense Loading Information
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse callJELProcedure(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0105Event event = (FnsJoo0105Event) e;
		TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
		String pErrorCode = "";
		try {
			pErrorCode = command.callJELProcedure(tdrLoadVO);

			if("Y".equals(pErrorCode.substring(0,1)))
				eventResponse.setUserMessage(new ErrorHandler("MAS00034", new String[]{"Data","created"}).getUserMessage());
			else
				eventResponse.setUserMessage(new ErrorHandler("MAS00035", new String[]{"Data","create"}).getUserMessage());
			
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
//=========================================================================================================
	/**
	 * FNS_JOO_0012 : Retrieve
	 * Settlement Other 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSettlementOTHList(Event e) throws EventException {
		  try{
			// PDTO(Data Transfer Object including Parameters)
			FnsJoo0106Event event = (FnsJoo0106Event)e;
			SettlementProcessBC command = new SettlementProcessBCImpl();
			List<ProcSettlementVO> list = command.searchSettlementList(event.getProcSettlementVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
	    } catch (EventException ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    }
		
//		  try{
//				// PDTO(Data Transfer Object including Parameters)
//				FnsJoo0012Event event = (FnsJoo0012Event)e;
//				CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//				List<ProcSettlementVO> list = command.searchSettlementList(event.getProcSettlementVO());
//				GeneralEventResponse eventResponse = new GeneralEventResponse();
//				eventResponse.setRsVoList(list);
//				return eventResponse;
//		    } catch (EventException ex) {
//		        log.error("err " + ex.toString(), ex);
//		        throw new EventException(ex.getMessage(), ex);
//		    } catch (Exception ex) {
//		        log.error("err " + ex.toString(), ex);
//		        throw new EventException(ex.getMessage(), ex);
//		    }		
	}
	
	/**
	 * FNS_JOO_0106 : Save
	 * Other Surcharge Settlement dup check하고 저장한다.
	 * Dup Error시 UI에 표시하고 Dup Error가 발생하지 않은 경우 그냥 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettlementOTH(Event e) throws EventException {			
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0106Event event = (FnsJoo0106Event)e;
		SettlementProcessBC command = new SettlementProcessBCImpl();
		JointOperationMasterDataMgtBC command1 = new JointOperationMasterDataMgtBCImpl();
		
				
		try {
			begin();
			ProcSettlementVO[] procSettlementVOs = event.getProcSettlementVOS();
			
			log.debug("JointOperationSettlementSC event.getAcctYrmon() = "+event.getAcctYrmon());
			List<ProcSettlementVO> list = command.manageSettlement(procSettlementVOs, event.getAcctYrmon(), account);

			String dupFlg = list.get(0).getDupFlg();
			eventResponse.setETCData("RTNVAL", dupFlg);

			if ("E".equals(dupFlg)){
				eventResponse.setRsVoList(list);
				rollback();
			}else{
				command1.manageTargetVVDForSettlement(procSettlementVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
		
		
		
	}
	
	/**
	 * FNS_JOO_0012 : VVD변경
	 * Other VVD Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlVvdOTH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0106Event event = (FnsJoo0106Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchStlVvd(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String stlVvdSeq = "";
		String stlBzcPortCd = "";
		String etaDt = "";
		String loclCurrCd = "";
		String ucBssPortCd = "";
		String ucBssPortEtdDt = "";
		if (list.isEmpty()) {
			eventResponse.setETCData("CHECKVVD", "E");
		} else if (list.size() > 1) {
			eventResponse.setETCData("CHECKVVD", "T");
		} else {
			eventResponse.setETCData("CHECKVVD", "N");
			ProcSettlementVO voOut = list.get(0);

			stlVvdSeq = voOut.getStlVvdSeq();
			stlBzcPortCd = voOut.getStlBzcPortCd();
			etaDt = voOut.getEtaDt();
			loclCurrCd = voOut.getLoclCurrCd();
			ucBssPortCd = voOut.getUcBssPortCd();
			ucBssPortEtdDt = voOut.getUcBssPortEtdDt();

			//Other인 경우만 AR_MST_REV_VVD 조회
			if (vo.getJoMnuNm().equals("M/S")){
				String rtnVal = command.searchStlVvdOth(vo);
				eventResponse.setETCData("CHECKVVD", rtnVal);
			}
		}
		eventResponse.setETCData("stl_vvd_seq", stlVvdSeq);
		eventResponse.setETCData("stl_bzc_port_cd", stlBzcPortCd);
		eventResponse.setETCData("eta_dt", etaDt);
		eventResponse.setETCData("locl_curr_cd", loclCurrCd);
		eventResponse.setETCData("uc_bss_port_cd", ucBssPortCd);
		eventResponse.setETCData("uc_bss_port_etd_dt", ucBssPortEtdDt);

		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0101 : Create
	 * Settlement  Create용으로 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddStlOTHList(Event e) throws EventException {
		  try{
				// PDTO(Data Transfer Object including Parameters)
				FnsJoo0106Event event = (FnsJoo0106Event)e;
				SettlementProcessBC command = new SettlementProcessBCImpl();
				List<ProcSettlementVO> list = command.searchAddStlList(event.getProcSettlementVO(), account);
				GeneralEventResponse eventResponse = new GeneralEventResponse();
				eventResponse.setRsVoList(list);
				return eventResponse;
		    } catch (EventException ex) {
		        log.error("err " + ex.toString(), ex);
		        throw new EventException(ex.getMessage(), ex);
		    } catch (Exception ex) {
		        log.error("err " + ex.toString(), ex);
		        throw new EventException(ex.getMessage(), ex);
		    }		
		
	}	
	
	/**
     * FNS_JOO_0007, FNS_JOO_0009, FNS_JOO_0010, FNS_JOO_0011, FNS_JOO_0012, FNS_JOO_0013, FNS_JOO_0014, FNS_JOO_0045 : 마감여부 조회
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse searchCloseYn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		ProcSettlementVO procSettlementVO = null;

		if (e instanceof FnsJoo0012Event) {
			procSettlementVO = ((FnsJoo0012Event)e).getProcSettlementVO();
			
			procSettlementVO = new ProcSettlementVO();
			CmbConditionVO vo = ((FnsJoo0016Event)e).getCmbConditionVO();
			procSettlementVO.setAcctYrmon(vo.getAcctYrmon());
			procSettlementVO.setReDivrCd (vo.getReDivrCd ());						
		}

		if(procSettlementVO != null){		
			jooCodeParamVO.setAcctYrmon(procSettlementVO.getAcctYrmon());
			jooCodeParamVO.setCode     (procSettlementVO.getReDivrCd());
		}
		jooCodeParamVO.setOfcCd    (account.getOfc_cd());
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<JooCodeInfoVO> lst = command.searchCloseYn(jooCodeParamVO);
		String clzYn = "O";
		if (lst.isEmpty()){
			clzYn = "C";
		}else{
			clzYn = lst.get(0).getCode();
		}
		eventResponse.setETCData("clz_yn", clzYn);
		return eventResponse;
	}	
	
	/**
	 * FNS_JOO_0012 : S/H의 BSA_TYPE변경시
	 * BSA Type의 Validation Check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBsaTypeValidationCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsJoo0012Event event = (FnsJoo0012Event)e;
		ProcSettlementVO vo = event.getProcSettlementVO();
		// PDTO(Data Transfer Object including Parameters)
		CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();

		List<ProcSettlementVO> list = command.searchBsaTypeValidationCheck(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if (list.isEmpty()) {
			eventResponse.setETCData("CHECK_BSA_TYPE", "E");
		} else {
			eventResponse.setETCData("CHECK_BSA_TYPE", "N");
		}

		return eventResponse;
	}	
	
	/**
	 * FNS_JOO_0012 : 화면 Open
	 * Carrier Code List, Financial Direction, Settlement Item, BSA Type 등 코드성 정보를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0012(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    		GeneralEventResponse eventResponse = new GeneralEventResponse();

    		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

    		// Carrier 조회
    		jooCodeParamVO.setOfcCd(account.getOfc_cd());
    		List<JooCodeInfoVO> list = command.searchCarrierCodeList(jooCodeParamVO);

    		String crrCombo = makeComboString(list, 1);

    		// ABBR 조회
    		jooCodeParamVO.setSuperCd2("Y"); // Manual만
    		list = command.searchStlItemCodeList(jooCodeParamVO);

    		String abbrCombo = makeComboString(list, 1);
    		String abbrSheet = makeComboString(list, 2); // code
    		String nameSheet = makeComboString(list, 3); // name

    		// Revenue Direction
    		CodeUtil codeUtil = CodeUtil.getInstance();

    		// BSA Type
    		Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0);
    		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);
    		String bsaTypeCd[] = (stljbSheetList[0]).split("[|]");
    		String bsaTypeNm[] = (stljbSheetList[1]).split("[|]");

    		String code = "";
    		StringBuilder bsaTypeCdTmp = new StringBuilder();
    		StringBuilder bsaTypeNmTmp = new StringBuilder();
    		for (int i=0; i<bsaTypeCd.length; i++){
    			code = bsaTypeCd[i].substring(0,1);
    			if ("1".equals(code)){
    				bsaTypeCdTmp.append(bsaTypeCd[i]+"|");
    				bsaTypeNmTmp.append(bsaTypeNm[i]+"|");
    			}
    		}

    		String bsaTpCd = bsaTypeCdTmp.toString().substring(0, bsaTypeCdTmp.toString().length()-1);
    		String bsaTpNm = bsaTypeNmTmp.toString().substring(0, bsaTypeNmTmp.toString().length()-1);

    		ProcSettlementVO procSettlementVO = new ProcSettlementVO();
    		procSettlementVO.setAcctYrmon(JSPUtil.getKST("yyyyMM"));
    		procSettlementVO.setReDivrCd("R");
    		eventResponse.setETCData("clz_yn", searchCloseYn(procSettlementVO));
    		eventResponse.setETCData("jo_crr_cd", crrCombo);
    		eventResponse.setETCData("abbrCombo", abbrCombo);
    		eventResponse.setETCData("abbrSheet", abbrSheet);
    		eventResponse.setETCData("nameSheet", nameSheet);
    		eventResponse.setETCData("stl_jb_combo", bsaTpCd);
    		eventResponse.setETCData("stl_jb_comnm", bsaTpNm);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * Account Year Month, R/E 조건을 주면 AP_PERIOD에서 마감여부를 읽어 return한다.
	 * @param ProcSettlementVO procSettlementVO
	 * @return String
	 * @throws EventException
	 */
	private String searchCloseYn(ProcSettlementVO procSettlementVO) throws EventException{
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		jooCodeParamVO.setAcctYrmon(procSettlementVO.getAcctYrmon());
		jooCodeParamVO.setCode     (procSettlementVO.getReDivrCd());
		jooCodeParamVO.setOfcCd    (account.getOfc_cd());
		JointOperationMasterDataMgtBC command = new JointOperationMasterDataMgtBCImpl();
		List<JooCodeInfoVO> lst = command.searchCloseYn(jooCodeParamVO);
		String clzYn = "O";
		if (lst.isEmpty()){
			clzYn = "C";
		}else{
			clzYn = lst.get(0).getCode();
		}
		return clzYn;
	}	
	
	/**
	 * 공통 : Make
	 * list를 Combo용 String으로 변환한다.
	 * @param List<JooCodeInfoVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	private String makeComboString(List<JooCodeInfoVO> list, int flg)
			throws EventException {
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while (iterator.hasNext()) {
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO) iterator.next();
			// 일반적인 IBCombo용(name, code|)
			if (flg == 0) {
				sb.append(jooCodeInfoVO.getName() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBCombo (code, code|)
			} else if (flg == 1) {
				sb.append(jooCodeInfoVO.getCode() + ","
						+ jooCodeInfoVO.getCode() + "|");
				// IBSheet의 코드부분(code|)
			} else if (flg == 2) {
				sb.append(jooCodeInfoVO.getCode() + "|");
				// IBSheet의 코드명부분(name|)
			} else if (flg == 3) {
				sb.append(jooCodeInfoVO.getName() + "|");
				// SuperCd조회
			} else if (flg == 4) {
				sb.append(jooCodeInfoVO.getSuperCd1() + ","
						+ jooCodeInfoVO.getSuperCd2() + ","
						+ jooCodeInfoVO.getCode() + "|");
			} else if (flg == 5) {
				sb.append(jooCodeInfoVO.getCode() + "\t"
						+ jooCodeInfoVO.getName() + "|");
			} else if (flg == 6) {
				sb.append(jooCodeInfoVO.getCode() + ","
						+ jooCodeInfoVO.getName() + "|");
			}
		}
		rtnVal = sb.toString();

		if (rtnVal.length() > 0) {
			rtnVal = rtnVal.substring(0, rtnVal.length() - 1);
		}

		return rtnVal;
	}
	
	/**
	 * FNS_JOO_0109 : btn_retrive<br>
	 * Movement Event Date 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMvntEvntDateList(Event e) throws EventException {
		FnsJoo0109Event event = (FnsJoo0109Event)e;
		SettlementProcessBC command = new SettlementProcessBCImpl();
		MvntEvntDtVO mvntEvntDtVO = event.getMvntEvntDtVO();
		List<MvntEvntDtVO> list = command.searchMvntEvntDateList(mvntEvntDtVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}		
	
	/**
	 * FNS_JOO_0109 : btn_retrive<br>
	 * Skd Event Date 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSkdEvntDatet(Event e) throws EventException {
		FnsJoo0109Event event = (FnsJoo0109Event)e;
		SettlementProcessBC command = new SettlementProcessBCImpl();
		MvntEvntDtVO mvntEvntDtVO = event.getMvntEvntDtVO();
		List<MvntEvntDtVO> list = command.searchSkdEvntDatet(mvntEvntDtVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}			
	
	/**
	 * FNS_JOO_0109 : Save
	 * Movement Event Date를 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageMvntEvntDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0109Event event = (FnsJoo0109Event)e;
		SettlementProcessBC command = new SettlementProcessBCImpl();
		
		try{
			begin(); 
			//Save 버튼 클릭시 실행
			command.manageMvntEvntDate(event.getMvntEvntDtVOs(), this.account);						
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
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
	 * FNS_JOO_0109 : Call Procedure - JOO_CNTR_MVMT_EVNT_DT_SLAN_PRC
	 * Movement Event Date Setting
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse callMVMTProcedure(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0109Event event = (FnsJoo0109Event) e;
		MvntEvntDtVO mvntEvntDtVO = event.getMvntEvntDtVO();
		
		String pErrorCode = "";
		try {
			pErrorCode = command.callMVMTProcedure(mvntEvntDtVO);

			if("Y".equals(pErrorCode.substring(0,1)))
				eventResponse.setUserMessage(new ErrorHandler("MAS00034", new String[]{"Data","created"}).getUserMessage());
			else
				eventResponse.setUserMessage(new ErrorHandler("MAS00035", new String[]{"Data","create"}).getUserMessage());
			
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * FNS_JOO_0109 : Call Procedure - JOO_CNTR_MVMT_EVNT_DT_ALL_PRC
	 * Movement Event Date Setting
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse callMVMTALLProcedure(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0109Event event = (FnsJoo0109Event) e;
		MvntEvntDtVO mvntEvntDtVO = event.getMvntEvntDtVO();
		
		String pErrorCode = "";
		try {
			pErrorCode = command.callMVMTALLProcedure(mvntEvntDtVO);

			if("Y".equals(pErrorCode.substring(0,1)))
				eventResponse.setUserMessage(new ErrorHandler("MAS00034", new String[]{"Data","created"}).getUserMessage());
			else
				eventResponse.setUserMessage(new ErrorHandler("MAS00035", new String[]{"Data","create"}).getUserMessage());
			
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
    /**
     * FNS_JOO_0057 : Open
     * D : [FnsJoo0057Event]<br>
     * [RDR Download by VVD]을 조회위해 Open시 Direct [조회]합니다.<br>
     *
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse openFnsJoo0057(Event e) throws EventException {
        try{
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            GeneralEventResponse eventResponse = new GeneralEventResponse();

            JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

            FnsJoo0108Event event = (FnsJoo0108Event)e;
            TdrLoadVO tdrLoadVO   = event.getTdrLoadVO();
            jooCodeParamVO.setSuperCd1( tdrLoadVO.getSuperCd1() );

            List<JooCodeInfoVO> list = command.searchComCodeList(jooCodeParamVO);
            eventResponse.setRsVoList( list  );
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }	
    
    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * TDR Carrier Code를 조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse searchTDRCarrierCodeString(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0108Event event = (FnsJoo0108Event)e;
            JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
            List<JooCodeInfoVO> list = command.searchTDRCarrierCodeListByPeriodAndRlane (  event.getTdrLoadVO()  );
            //eventResponse.setRsVoList(list);

            StringBuilder comboCode = new StringBuilder();
    		StringBuilder comboText = new StringBuilder();
    		for (int i=0 ; i<list.size(); i++) {
    			comboCode.append(list.get(i).getCode() + "^#^");
    			comboText.append(list.get(i).getCode() + "^#^");  // Code를 그대로 보여준다.
    		}
    		eventResponse.setETCData("comboCode", comboCode.toString());
    		eventResponse.setETCData("comboText", comboText.toString());

    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }    
    
    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * 'Sub Allocation and Ratio'에 Rep. Carrier가 복수 선택되었거나 혹은 하나도 선택되지를 조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse searchTDRRatioCountByLane(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
//            FnsJoo0108Event event = (FnsJoo0108Event)e;
//            CarrierSettlementProcessBC command = new CarrierSettlementProcessBCImpl();
//            List<TdrLoadVO> list = command.searchTDRRatioCountByLane(event.getTdrLoadVO());
            
            eventResponse.setETCData("carrier_cnt", "1");            
//         eventResponse.setETCData("carrier_cnt", list.get(0).getCarrierCnt());
            return eventResponse;
//        } catch (EventException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }    
    
    /**
     * FNS_JOO_0057: Retrieve
     * D : [FnsJoo0057Event]<br>
     * RDR Load DownLoad by VVD 을  조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author jang kang cheol
     */
    private EventResponse searchTDRDownloadListByLane(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0108Event event = (FnsJoo0108Event)e;
            SettlementProcessBC command = new SettlementProcessBCImpl();
            List<JoLoadingVO> list = command.searchTDRDownloadListByLane (  event.getTdrLoadVO()  );
            eventResponse.setRsVoList(list);
            return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }    
    
	/**
	 * FNS_JOO_0108 : Save<br>
	 * Jo Rev Loading 정보를 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageJoRevLoading(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsJoo0108Event event = (FnsJoo0108Event)e;
		SettlementProcessBC command = new SettlementProcessBCImpl();
		
		try{
			begin();			
			if("".equals(event.getTdrLoadVO().getMergeCrr()) || event.getTdrLoadVO().getMergeCrr() == null){
				command.manageJoRevLoading(event.getJoLoadingVOs(), event.getTdrLoadVO(), account);				
			}else{
				command.manageJoRevLoadingMerge(event.getJoLoadingVOs(), event.getTdrLoadVO(), account);				
			}			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
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
     * TDR Carrier Code를 조회 Retrieve 합니다.<br>
     *
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse searchJoRevCarrierCodeString(Event e) throws EventException {
        try{
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            FnsJoo0108Event event = (FnsJoo0108Event)e;
            SettlementProcessBC command = new SettlementProcessBCImpl();
            List<JooCodeInfoVO> list = command.searchJoRevCarrierCodeString(event.getTdrLoadVO());

            StringBuilder comboCode = new StringBuilder();
    		StringBuilder comboText = new StringBuilder();
    		for (int i=0 ; i<list.size(); i++) {
    			comboCode.append(list.get(i).getCode() + "^#^");
    			comboText.append(list.get(i).getCode() + "^#^");  // Code를 그대로 보여준다.
    		}
    		eventResponse.setETCData("comboCode", comboCode.toString());
    		eventResponse.setETCData("comboText", comboText.toString());

    		return eventResponse;
        } catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    }    
    		
	/**
	 * FNS_JOO_0110 : Retrieve
	 * Settlement Target  - Retrieve
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchStlTgtList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0110Event event = (FnsJoo0110Event) e;

		List<StlTgtVO> list = null;
		list = command.searchStlTgtList(event.getJoSettlementConditionVO());
		eventResponse.setRsVoList(list);
		
		//첫page인 경우만 total값을 조회한다.
//		if ("1".equals(event.getJoSettlementConditionVO().getPageNo())){
//			SltHirTgtVO sltHirTgtVO = command.searchStlTgTotaltList(event.getJoSettlementConditionVO());
//			
//			eventResponse.setETCData("tot_page_cnt" , sltHirTgtVO.getTotPageCnt());		// 페이지 개수			
//		}
		eventResponse.setETCData("tot_page_cnt" , "1");		// 페이지 개수
		
		return eventResponse;
	}	
   
	/**
	 * FNS_JOO_0110 : Save
	 * D : [FnsJoo0110Event] <br>
	 * [Settlement Target]을 [Save]합니다. <br>
	 *
	 * @param FnsJoo0110Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageStlTgt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0110Event event = (FnsJoo0110Event) e;

		try {
			begin();
			command.manageStlTgt(event.getStlTgtVOs(), event.getJoSettlementConditionVO(), this.account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;					
	}	
	
	/**
	 * FNS_JOO_0110 : Save
	 * D : [FnsJoo0110Event] <br>
	 * [Settlement Target Sublet]을 [Save]합니다. <br>
	 *
	 * @param FnsJoo0110Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageStlTgtSublet(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0110Event event = (FnsJoo0110Event) e;

		try {
			begin();
			command.manageStlTgtSublet(event.getStlTgtVOs(), event.getJoSettlementConditionVO(), this.account);
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			commit();
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;					
	}		
    
	/**
	 * FNS_JOO_0107 : Retrieve
	 * JO Settlement Status Information
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchJoSettlementStatusList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0107Event event = (FnsJoo0107Event) e;

		List<StlStsVO> list = null;
		list = command.searchJoSettlementStatusList(event.getStlStsVO());
		eventResponse.setRsVoList(list);

		//첫page인 경우만 total값을 조회한다.
		if ("1".equals(event.getStlStsVO().getPageNo())){
			StlStsVO stlStsVO = command.searchJoSettlementStatusListTotal(event.getStlStsVO());
			
			eventResponse.setETCData("tot_page_cnt" , stlStsVO.getTotPageCnt());		// 페이지 개수			
		}
		
		return eventResponse;
	}	
		
//    /**
//     * FNS_JOO_0110 : Retrieve
//     * Estimate Performance Creation 을 조회합니다.<br>
//     *
//     * @param Event e
//     * @return EventResponse
//     * @throws Exception
//     */
//	private EventResponse searchCondStl(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		SettlementProcessBC command = new SettlementProcessBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		FnsJoo0110Event event = (FnsJoo0110Event)e;
//
//		JoEstmConditionVO estmConditionVO = event.getJoEstmConditionVO();
//
//		String estmCondFlg = estmConditionVO.getEstmCondFlg();
//
//		List<JoEstmConditionVO> list = null;
//
//		String estmClzFlg = "N";
//		String trdCombo   = "";
//		String laneCombo  = "";
//		String crrCombo   = "";
//
//		switch (Integer.parseInt(estmCondFlg)){
//			//exe_yrmon이나 re_divr_cd가 변경된경우
//			case 1 :
//				JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
//				jooCodeParamVO.setSuperCd1(estmConditionVO.getExeYrmon());
//				JooCodeInfoVO jooCodeInfoVO = command.searchCheckEstmClz(jooCodeParamVO);
//				estmClzFlg = jooCodeInfoVO.getCode();
//			//rev_yrmon period가 변경된 경우
//			case 2 :
//				//Trade Code List 조회
//				list = command.searchTradeCodeListStl(estmConditionVO);
//				trdCombo = makeEstmComboString(list, 0);
//			//trad변경된경우
//			case 3 :
//				//Rlane Code List 조회
//				list = command.searchRlaneCodeListStl(estmConditionVO);
//				laneCombo = makeEstmComboString(list, 1);
//			//lane변경된경우
//			case 4 :
//				//Carrier Code List 조회
//				list = command.searchCarrierCodeListStl(estmConditionVO);
//				crrCombo = makeEstmComboString(list, 2);
//				break;
//		}
//
//		eventResponse.setETCData("estm_clz_flg", estmClzFlg);
//		eventResponse.setETCData("TRD_CD"      , trdCombo);
//		eventResponse.setETCData("RLANE_CD"    , laneCombo);
//		eventResponse.setETCData("JO_CRR_CD"   , crrCombo);
//		return eventResponse;
//	}		
	
    /**
     * FNS_JOO_0110 : Open
     * Trade, Carrier, Lane Code Combo조회
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse openFnsJoo0110(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		SettlementProcessBC command = new SettlementProcessBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

		String exeYrmon = "";
		String currentYrmon = "";
		
		// 마감여부 조회
		try{
			currentYrmon = DateTime.getFormatDate(new java.util.Date(), "yyyyMM");								
			exeYrmon = currentYrmon;
			
			jooCodeParamVO.setSuperCd1(exeYrmon);
		}catch(Exception ex){
			throw new EventException(ex.toString());
		}

		JooCodeInfoVO jooCodeInfoVO = command.searchCheckEstmClz(jooCodeParamVO);

		JoEstmConditionVO joEstmConditionVO = new JoEstmConditionVO();
		joEstmConditionVO.setRevYrmonFr(exeYrmon);
		joEstmConditionVO.setRevYrmonTo(exeYrmon);
		

//		//Trade Code List 조회
//		List<JoEstmConditionVO> list = command.searchTradeCodeListStl(joEstmConditionVO);
//
//		String trdCombo = makeEstmComboString(list, 0);
//
//		//Rlane Code List 조회
//		list = command.searchRlaneCodeListStl(joEstmConditionVO);
//		String laneCombo = makeEstmComboString(list, 1);
//
//		//Carrier Code List 조회
//		list = command.searchCarrierCodeListStl(joEstmConditionVO);
//		String crrCombo = makeEstmComboString(list, 2);

		eventResponse.setETCData("EXE_YRMON" , exeYrmon);
//		eventResponse.setETCData("jo_crr_cd" , crrCombo);
//		eventResponse.setETCData("trd_cd"    , trdCombo);
//		eventResponse.setETCData("rlane_cd"  , laneCombo);
		eventResponse.setETCData("estm_clz_flg"  , jooCodeInfoVO.getCode());
		return eventResponse;
	}		
	
	/**
	 * FNS_JOO_0111 : btn_retrive<br>
	 * Jo Expense Report 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpRptList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0111Event event = (FnsJoo0111Event) e;
		TdrLoadVO tdrLoadVO = event.getTdrLoadVO();
		
		List<JoLoadingVO> list = null;		
		list = command.searchExpRptList(tdrLoadVO, account, "1");
		eventResponse.setRsVoList(list);

		return eventResponse;								
	}		
	
	/**
	 * FNS_JOO_0091 OPEN
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0091(Event e) throws EventException {
    	JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    	//FnsJoo0085Event event = (FnsJoo0085Event) e;
    	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
        
        String crrCdList = makeComboString(list, 0);
		eventResponse.setETCData("CRR_CD_LIST",crrCdList);

		list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        
        String trdCdList = makeComboString(list, 0);
		eventResponse.setETCData("TRD_CD_LIST",trdCdList);
		
		list = command.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
		
		String crrTrdLaneList = makeComboString(list, 4);
		eventResponse.setETCData("TRD_LANE_CRR_LIST",crrTrdLaneList);
			       				
        return eventResponse;        
    }	
		
	/**
	 * FNS_JOO_0113 : Retrieve
	 * JO Settlement PIC 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchJoSettlementPicList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SettlementProcessBC command = new SettlementProcessBCImpl();
		FnsJoo0113Event event = (FnsJoo0113Event) e;

		List<StlStsVO> list = null;
		list = command.searchJoSettlementPicList(event.getStlStsVO());
		eventResponse.setRsVoList(list);
		
		//첫page인 경우만 total값을 조회한다.
//		if ("1".equals(event.getStlStsVO().getPageNo())){
//			StlStsVO stlStsVO = command.searchJoSettlementPicListTotal(event.getStlStsVO());			
//			eventResponse.setETCData("tot_page_cnt" , stlStsVO.getTotPageCnt());		// 페이지 개수			
//		}		
		eventResponse.setETCData("tot_page_cnt" , "1");		// 페이지 개수		
		
		return eventResponse;
	}		
	
	/**
	 * FNS_JOO_0113 OPEN
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse openFnsJoo0113(Event e) throws EventException {
    	JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
		SettlementProcessBC command1 = new SettlementProcessBCImpl();    	
    	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();

        List<JooCodeInfoVO> list = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
        
        String crrCdList = makeComboString(list, 0);
		eventResponse.setETCData("CRR_CD_LIST",crrCdList);

		list = command.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
        
        String trdCdList = makeComboString(list, 0);
		eventResponse.setETCData("TRD_CD_LIST",trdCdList);
		
		list = command.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
		
		String crrTrdLaneList = makeComboString(list, 4);
		eventResponse.setETCData("TRD_LANE_CRR_LIST",crrTrdLaneList);
			       			
		list = command1.searchPicList();		
		
		String picList = makeComboString(list, 0);
		eventResponse.setETCData("PIC_LIST",picList);
		
		
        return eventResponse;        
    }		
	
    /**
     * Pic를 저장합니다.<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse managePic(Event e) throws EventException {
    	SettlementProcessBC command = new SettlementProcessBCImpl();
 
        FnsJoo0113Event event = (FnsJoo0113Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            String rtnVal = command.managePic( event.getStlStsVOs() , this.account);             
            eventResponse.setETCData("iRtn", rtnVal);
            if ("".equals(rtnVal)){
                eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
            	commit();      
            } else {
            	rollback();
            }            
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

        return eventResponse;
    }	
	
    /**
     * Pic를 저장합니다.<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     */
    private EventResponse manageMultiPic(Event e) throws EventException {
    	SettlementProcessBC command = new SettlementProcessBCImpl();
 
        FnsJoo0114Event event = (FnsJoo0114Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            command.manageMultiPic( event.getStlStsVOs() , this.account);             
            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
        	commit();      
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

        return eventResponse;
    }	    
    
    
    /**
     * FNS_JOO_0110 : Open
     * Trade, Carrier, Lane Code Combo조회
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchTrdList(Event e) throws EventException {
		SettlementProcessBC command = new SettlementProcessBCImpl();				
        FnsJoo0110Event event = (FnsJoo0110Event) e;		               
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		JoEstmConditionVO joEstmConditionVO = new JoEstmConditionVO();
		joEstmConditionVO.setRevYrmonFr( event.getJoSettlementConditionVO().getRevYrmonFr());
		joEstmConditionVO.setRevYrmonTo( event.getJoSettlementConditionVO().getRevYrmonTo());		
		joEstmConditionVO.setReDivrCd(event.getJoSettlementConditionVO().getReDivrCd());
				
		//Trade Code List 조회
		List<JoEstmConditionVO> list = command.searchTradeCodeListStl(event.getJoSettlementConditionVO());		
		eventResponse.setRsVoList(list);
				
		return eventResponse;
	}
	
    /**
     * FNS_JOO_0110 : Open
     * Trade, Carrier, Lane Code Combo조회
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchLaneList(Event e) throws EventException {
		SettlementProcessBC command = new SettlementProcessBCImpl();		
        FnsJoo0110Event event = (FnsJoo0110Event) e;		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JoEstmConditionVO joEstmConditionVO = new JoEstmConditionVO();
		joEstmConditionVO.setRevYrmonFr( event.getJoSettlementConditionVO().getRevYrmonFr());
		joEstmConditionVO.setRevYrmonTo( event.getJoSettlementConditionVO().getRevYrmonTo());		
		joEstmConditionVO.setReDivrCd(event.getJoSettlementConditionVO().getReDivrCd());
		
		//Rlane Code List 조회
		List<JoEstmConditionVO> list = command.searchRlaneCodeListStl(event.getJoSettlementConditionVO());		
		eventResponse.setRsVoList(list);		
		
		return eventResponse;
	}		
	
    /**
     * FNS_JOO_0110 : Settlement Target에서 Carrier 조회
     * 
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchCrrList(Event e) throws EventException {
		SettlementProcessBC command = new SettlementProcessBCImpl();
        FnsJoo0110Event event = (FnsJoo0110Event) e;		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		JoEstmConditionVO joEstmConditionVO = new JoEstmConditionVO();
		joEstmConditionVO.setRevYrmonFr( event.getJoSettlementConditionVO().getRevYrmonFr());
		joEstmConditionVO.setRevYrmonTo( event.getJoSettlementConditionVO().getRevYrmonTo());		
		joEstmConditionVO.setReDivrCd(event.getJoSettlementConditionVO().getReDivrCd());		
		
		//Carrier Code List 조회
		List<JoEstmConditionVO> list = command.searchCarrierCodeListStl(event.getJoSettlementConditionVO());		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}		
//=========================================================================================================			
}