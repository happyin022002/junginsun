/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeSC.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.06 이승준
* 1.0 Creation
=========================================================
* History
2011.07.07 김민아 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing) : ESM_PRI_4033 화면 추가
2012.03.07 서미진 [CHM-201216620] Surcharge Creation / Inquiry 에서 PSA 항목 추가
2013.03.07 전윤주 [CHM-201323465] Surcharge Creation / Inquiry 에서 RF Condition 항목 추가
2013.10.01 전윤주 [CHM-201326927] MDM rating flag와 연계하여 Auto 항목 추가
2014.03.20 전윤주 [CHM-201429456] Food Grade 항목 추가
2015.04.10 전지예 [CHM-201535041] Arrival Date 항목 추가
2016.02.04 전지예 [CHM-201640066] TPW Non-Cargo NOS 체크 권한 로직 부여 Request by Hye-In Ahn
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.event.PricommonEvent;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.basic.ApplicationDateRuleBC;
import com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.basic.ApplicationDateRuleBCImpl;
import com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.event.EsmPri4033Event;
import com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.vo.RsltPriScgAplyDtRuleVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.basic.EServiceCompensationBC;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.basic.EServiceCompensationBCImpl;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.event.EsmPri4009Event;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.event.EsmPri4010Event;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.MdmSvcScpLmtVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.PriCmpnEsvcVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.basic.SurchargeBC;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.basic.SurchargeBCImpl;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.event.EsmPri4003Event;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.event.EsmPri4011Event;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.event.EsmPri4015Event;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.event.EsmPri4016Event;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.CstPriScgRtVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgAuthVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.basic.SurchargeGroupCommodityBC;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.basic.SurchargeGroupCommodityBCImpl;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.event.EsmPri4008Event;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.event.EsmPri4019Event;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.CommonGroupCommodityVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriComGrpCmdtExcelVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriScgGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.basic.SurchargeGroupLocationBC;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.basic.SurchargeGroupLocationBCImpl;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.event.EsmPri4004Event;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.event.EsmPri4018Event;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.integration.SurchargeGroupLocationDBDAO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegrouplocation.vo.SurchargeGroupLocationVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;

/**
 * NIS2010-Surcharge Business Logic ServiceCommand - NIS2010-Surcharge 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Seung Jun Lee
 * @see SurchargeGroupLocationDBDAO
 * @since J2EE 1.4 
 */

public class SurchargeSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Surcharge system 업무 시나리오 선행작업<br>
	 * ESM_PRI_4004업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * Surcharge system 업무 시나리오 마감작업<br>
	 * ESM_PRI_4004 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SurchargeSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-Surcharge system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		
		
		//ESM_PRI_4004 Group Location start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri4004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupLocation(e);
			}
		}
		//ESM_PRI_4004 Group Location end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_4008 GRI Commodity start
		//////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSurchargeGroupCommodityList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSurchargeGroupCommodityDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSurchargeGroupCommodityExcelList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSurchargeGroupCommodity(e);
			}
		}
		//ESM_PRI_4008 GRI Commodity end
		//////////////////////////////////////////////////////////////////////////////////
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboPctBseCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSurchargePreferences(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSurcharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSurchargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkSurchargeDuplicate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = requestSurchargeList(e); //REQUEST
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = approveSurchargeList(e); // APPROVE
			}  else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchSurchargeAuth(e);  //  승인 권한 체크
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = checkServiceScope(e);  //  Service Scope 정합성 체크
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = cancelSurchargeList(e); // Save Cancel
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = searchTradeServiceScopeCodeList(e); // Trade 별 Service Scope
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = searchScgGrpCmdtCdList(e); // Trade 별 Service Scope
			} else {
				eventResponse = initSurchargeComboData(e);  // 화면 최초 호출 시 실행
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri4016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSurchargePreferences(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSurchargeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkSurchargeDuplicate(e);
			} else {
				eventResponse = initSurchargeComboData(e);  // 화면 최초 호출 시 실행
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri4019Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSurchargeGroupCommodityList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchSurchargeGroupCommodityDetailList(e);
            }
        }
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri4011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSurchargePreferences(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAllSurchargeList(e);
			} else {
				eventResponse = initSurchargeComboData(e);  // 화면 최초 호출 시 실행
			}
		}
		//////////////////////////////////////////////////////////////////////////////////			
		//////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationList(e);
			}
		}
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_4009 E-SVC Compensation Creation start
		//////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 리스트조회
				eventResponse = searchEServiceCompensationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //origin, dest 콤보조회
				eventResponse = searchEServiceCompensationOrigiComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //sc no 여부 조회
				eventResponse = searchEServiceCompensationSCNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { //rfa no 조회
				eventResponse = searchEServiceCompensationRFANo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //저장
				eventResponse = manageEServiceCompensation(e);
			} else {
				eventResponse = initEServiceCompensation(e);				
			}
		}
		//ESM_PRI_4009 E-SVC Compensation Creation end		
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_4010 E-SVC Compensation Inquiry start
		//////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 리스트조회
				eventResponse = searchEServiceCompensationList(e);
			} else {
				eventResponse = initEServiceCompensation(e);				
			}
		}
		//ESM_PRI_4010 E-SVC Compensation Inquiry end		
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_4029 Group Location Popup start
		//////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationList(e);
			}
		}
		//ESM_PRI_4029 Group Location Popup end
		//////////////////////////////////////////////////////////////////////////////////
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri4033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {			// 리스트 조회
				eventResponse = searchApplicatoinDateRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// 저장
				eventResponse = manageApplicationDateRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// Location 체크 및 Type 조회
				eventResponse = searchLocationTypeAndName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// SAVE전 중복 데이터 조회
				eventResponse = searchApplicationDateRuleDupCheck(e);
			} else {
				eventResponse = initApplicationDateRule(e);						// 화면 최초 호출 시 실행
			}
		}
		//ESM_PRI_4011 surcharge start
		////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri4015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				log.debug("COMMAND01~~~~");
				eventResponse = searchSurchargeExcelList(e);
				log.debug("COMMAND01#####");
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//It gets a status of backendjob. 2
				log.debug("COMMAND02~~~~");
				eventResponse = excelDownSurchargeList(e);
				log.debug("COMMAND02#####");
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				log.debug("SEARCH~~~~");
				eventResponse = comBakEndJbVOs(e);
				log.debug("SEARCH#####");
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4011 
	 * SurchargeExcelList 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeExcelList(Event e) throws EventException {
		SurchargeBC command = new SurchargeBCImpl();
		EsmPri4015Event event = (EsmPri4015Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchSurchargeExcelListDoStart(event.getCstPriScgRtVO(), account));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	/**
	 * ESM_PRI_4011: BackEndJob 결과 - Account별 엑셀다운 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownSurchargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		try{
			List<Object> oList = command.excelDownSurchargeList((String) e.getAttribute("KEY"));					
			log.debug("excelDownSurChargeList"+ oList.size()+"~~");
			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String[])oList.get(1));
			eventResponse.setCustomData("columns", (String[])oList.get(2));
			eventResponse.setCustomData("fileName", "SurchargeList.xls");
			eventResponse.setCustomData("isZip", false);
			
			log.debug("excelDownSurChargeList"+ eventResponse+"##");
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	

	/*************************************************************************************************/
	/*	BACK END JOB 관련																			 */
	/*************************************************************************************************/
	/**
	 * BackEndJob : interval <br>
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBakEndJbVOs(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		String status = null;
		SurchargeBC command = new SurchargeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			status = command.comBakEndJbVOs(key);			
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}		
		
	/**
		 * BackEndJob : search <br>
		 * BackEndJob 결과 리스트를 조회한다.<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		@SuppressWarnings("unchecked")
		private EventResponse comBackEndJbSearchListGetResult(Event e) throws EventException {
			List list = null;
			String key = (String)e.getAttribute("KEY");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			try {
				if(e.getEventName().equalsIgnoreCase("EsmPri4015Event")){
					list = (List<PriScgRtVO>)BackEndJobResult.loadFromFile(key);				 // VO변경
				}
				eventResponse.setRsVoList(list);		
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
			}		
			return eventResponse;
		}	
			
		
	//ESM_PRI_4004 Group Location start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_4029 : Retrieve <br>
	 * Surcharge Group Location List를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationList(Event e) throws EventException {
	    
	    SurchargeGroupLocationVO paramVo = new SurchargeGroupLocationVO();
	    if (e.getEventName().equalsIgnoreCase("EsmPri4004Event")) {
	        EsmPri4004Event event = (EsmPri4004Event) e;
	        paramVo = event.getSurchargeGroupLocationVO();
	    } else if (e.getEventName().equalsIgnoreCase("EsmPri4018Event")) {
            EsmPri4018Event event = (EsmPri4018Event) e;
            paramVo = event.getSurchargeGroupLocationVO();
	    }
		SurchargeGroupLocationBC command = new SurchargeGroupLocationBCImpl();
		
		
		//컨테이너 vo
		SurchargeGroupLocationVO cVo = new SurchargeGroupLocationVO();
		//searchGubun 1:Group Location, 2:Group Location Detail
		String searchGubun = paramVo.getSearchGubun();
		
		log.debug("*********************************************************");
		log.debug("searchGubun : " + searchGubun);
		log.debug("*********************************************************");
		
		//Group Location List 
		List<RsltPriScgGrpLocVO> rsltpriScgGrpLocVOList 		= new ArrayList<RsltPriScgGrpLocVO>();
		List<RsltPriScgGrpLocDtlVO> rsltPriScgGrpLocDtlVOList   = new ArrayList<RsltPriScgGrpLocDtlVO>();
	
		
		//컨테이너 vo로 조회 결과 리턴
		cVo = command.searchGroupLocationList(paramVo);
		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		//컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅
		if("1".equals(searchGubun)) {
			rsltpriScgGrpLocVOList  = cVo.getRsltPriScgGrpLocVOList();
			eventResponse.setRsVoList(rsltpriScgGrpLocVOList);
			//max seq setting
			eventResponse.setETCData("max_seq", cVo.getMaxSeq());
			log.debug("*********************************************************");
			log.debug("max_seq : " + eventResponse.getETCData("max_seq"));
			log.debug("*********************************************************");
		}
		else if("2".equals(searchGubun)) {
			rsltPriScgGrpLocDtlVOList 	  = cVo.getRsltPriScgGrpLocDtlVOList();
			eventResponse.setRsVoList(rsltPriScgGrpLocDtlVOList);
		}
		else if("3".equals(searchGubun)) {
			rsltpriScgGrpLocVOList  = cVo.getRsltPriScgGrpLocVOList();
			eventResponse.setRsVoList(rsltpriScgGrpLocVOList);
			
			rsltPriScgGrpLocDtlVOList 	  = cVo.getRsltPriScgGrpLocDtlVOList();
			eventResponse.setRsVoList(rsltPriScgGrpLocDtlVOList);
		}
			
		return eventResponse;
		
	}

	/**
	 * ESM_PRI_4004 : Save <br>
	 * Surcharge Group Location을 수정합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupLocation(Event e) throws EventException {
	    SurchargeGroupLocationVO paramVo = new SurchargeGroupLocationVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri4004Event")) {
            EsmPri4004Event event = (EsmPri4004Event) e;
            paramVo = event.getSurchargeGroupLocationVO();
        }
	    // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeGroupLocationBC command = new SurchargeGroupLocationBCImpl();
		try{
			begin();
			command.manageGroupLocation(paramVo,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	//ESM_PRI_4004 Group Location end
	//////////////////////////////////////////////////////////////////////////////////
	
	//ESM_PRI_4008 GRI Commodity start
	//////////////////////////////////////////////////////////////////////////////////
    /**
     * ESM_PRI_4008 : Retrieve <br>
     * GRI Commodity 의 Master 리스트를 조회합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSurchargeGroupCommodityList(Event e) throws EventException {

        PriScgGrpCmdtVO paramVo = new PriScgGrpCmdtVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri4008Event")) {
            // PDTO(Data Transfer Object including Parameters)
            EsmPri4008Event event = (EsmPri4008Event) e;
            paramVo = event.getPriScgGrpCmdtVO();
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri4019Event")) {
            // PDTO(Data Transfer Object including Parameters)
            EsmPri4019Event event = (EsmPri4019Event) e;
            paramVo = event.getPriScgGrpCmdtVO();
        }
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SurchargeGroupCommodityBC command = new SurchargeGroupCommodityBCImpl();

        try{
            //컨테이너 vo로 조회 결과 리턴
            CommonGroupCommodityVO cVo = command.searchSurchargeGroupCommodityList(paramVo);
            //Commodity List 
            List<PriScgGrpCmdtVO> priComGrpCmdtVOList = new ArrayList<PriScgGrpCmdtVO>();
            
            //컨테이너 vo에서 조회결과를 뽑아서 response에 세팅
            priComGrpCmdtVOList  = cVo.getPriScgGrpCmdtVOList();
            eventResponse.setRsVoList(priComGrpCmdtVOList);
            
            //max seq setting
            eventResponse.setETCData("max_seq", cVo.getMaxSeq());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * ESM_PRI_4008 : Retrieve <br>
     * GRI Commodity 의 Detail 리스트를 조회합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSurchargeGroupCommodityDetailList(Event e) throws EventException {

        PriScgGrpCmdtVO paramVo = new PriScgGrpCmdtVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri4008Event")) {
            // PDTO(Data Transfer Object including Parameters)
            EsmPri4008Event event = (EsmPri4008Event) e;
            paramVo = event.getPriScgGrpCmdtVO();
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri4019Event")) {
            // PDTO(Data Transfer Object including Parameters)
            EsmPri4019Event event = (EsmPri4019Event) e;
            paramVo = event.getPriScgGrpCmdtVO();
        }        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SurchargeGroupCommodityBC command = new SurchargeGroupCommodityBCImpl();
        
        try{
            // 조회 결과 리턴
            List<RsltPriScgGrpCmdtDtlVO> list = command.searchSurchargeGroupCommodityDetailList(paramVo, account);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_4008 : Down Excel <br>
     * GRI Commodity 의 Download Excel 리스트를 조회합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSurchargeGroupCommodityExcelList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri4008Event event = (EsmPri4008Event) e;
        SurchargeGroupCommodityBC command = new SurchargeGroupCommodityBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            // 조회 결과 리턴
            List<RsltPriComGrpCmdtExcelVO> list = command.searchSurchargeGroupCommodityExcelList(event.getPriScgGrpCmdtVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_4008 : Save<br>
	 * GRI Commodity 정보를 저장합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4008Event event = (EsmPri4008Event)e;
		SurchargeGroupCommodityBC command = new SurchargeGroupCommodityBCImpl();
		try{
			begin();
			command.manageSurchargeGroupCommodity(event.getCommonGroupCommodityVO(),account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	//ESM_PRI_4008 GRI Commodity end
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * ESM_PRI_4003 : Application Type Percentage 조회 <br>
	 * Percentage Base Code를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboPctBseCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4003Event event = (EsmPri4003Event)e;
		SurchargeBC command = new SurchargeBCImpl();
		try{
			List<RsltCdListVO> list = command.searchComboPctBseCdList(event.getPriScgPrfVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4003 : Retrieve <br>
	 * Surcharge Preferences 리스트를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargePreferences(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PriScgPrfVO paramVO = new PriScgPrfVO();
		if(e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
			EsmPri4003Event event = (EsmPri4003Event)e;
			paramVO = event.getPriScgPrfVO();
		} else if(e.getEventName().equalsIgnoreCase("EsmPri4011Event")) {
			EsmPri4011Event event = (EsmPri4011Event)e;
			paramVO = event.getPriScgPrfVO();
		} else if(e.getEventName().equalsIgnoreCase("EsmPri4016Event")) {
			EsmPri4016Event event = (EsmPri4016Event)e;
			paramVO = event.getPriScgPrfVO();
		}
		
		SurchargeBC command = new SurchargeBCImpl();
		try{
			List<PriScgPrfVO> list = command.searchSurchargePreferences(paramVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_PRI_4003, ESM_PRI_4016 : Save <br>
	 * Surcharge Preferences와 Surcharge를 수정합니다. <br>
	 * Surcharge와 Excel Upload 두화면에서 사용합니다. <br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurcharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PriScgPrfVO[] priScgPrfVOS = null;
		PriScgRtVO[] priScgRtVOS = null;
		
		EsmPri4003Event event = (EsmPri4003Event)e;
		priScgPrfVOS = event.getPriScgPrfVOS();   
		priScgRtVOS = event.getPriScgRtVOS();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		
		try{
			String stsCd = priScgPrfVOS[0].getIbflag();
			String svcScpCd = priScgPrfVOS[0].getSvcScpCd();
			String chgCd = priScgPrfVOS[0].getChgCd();
			log.debug("surcharge===================1");
			begin();
			
			if("I".equals(stsCd) || "U".equals(stsCd)) {
				command.manageSurchargePreferences(priScgPrfVOS, account);
				
				if(priScgRtVOS != null) {
					for(int i=0; i<priScgRtVOS.length; i++) {
						if("N".equals(priScgPrfVOS[0].getPorUseFlg())) {
							priScgRtVOS[i].setPorDefCd("");
							priScgRtVOS[i].setPorTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getPolUseFlg())) {
							priScgRtVOS[i].setPolDefCd("");
							priScgRtVOS[i].setPolTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getPodUseFlg())) {
							priScgRtVOS[i].setPodDefCd("");
							priScgRtVOS[i].setPodTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getDelUseFlg())) {
							priScgRtVOS[i].setDelDefCd("");
							priScgRtVOS[i].setDelTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getImdgClssUseFlg())) {
							priScgRtVOS[i].setScgImdgClssCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getSubTrdUseFlg())) {
							priScgRtVOS[i].setSubTrdCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getSlanUseFlg())) {
							priScgRtVOS[i].setVslSlanCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getTsPortUseFlg())) {
							priScgRtVOS[i].setTsPortCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getDirCallUseFlg())) {
							priScgRtVOS[i].setDirCallFlg("");
						}
						
						if("N".equals(priScgPrfVOS[0].getTmlUseFlg())) {
							priScgRtVOS[i].setTmlCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getTrnsModUseFlg())) {
							priScgRtVOS[i].setOrgTrspModCd("");
							priScgRtVOS[i].setDestTrspModCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getUsaSvcModUseFlg())) {
							priScgRtVOS[i].setUsaSvcModCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getRcvDeTermUseFlg())) {
							priScgRtVOS[i].setPrcRcvTermCd("");
							priScgRtVOS[i].setPrcDeTermCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getHngrBarUseFlg())) {
							priScgRtVOS[i].setPrcHngrBarTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getCgoWgtUseFlg())) {
							priScgRtVOS[i].setMinCgoWgt("");
							priScgRtVOS[i].setMaxCgoWgt("");
						}
						
						if("N".equals(priScgPrfVOS[0].getCmdtUseFlg())) {
							priScgRtVOS[i].setCmdtCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getGriCmdtUseFlg())) {
							priScgRtVOS[i].setScgGrpCmdtCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getSocUseFlg())) {
							priScgRtVOS[i].setSocFlg("");
						}
						
						if("N".equals(priScgPrfVOS[0].getIoGaUseFlg())) {
							priScgRtVOS[i].setIoGaCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getCrteDyKntUseFlg())) {
							priScgRtVOS[i].setScgCrteDyKnt("");
						}
					
						if("N".equals(priScgPrfVOS[0].getPrdCrteTpUseFlg())) {
							priScgRtVOS[i].setScgPrdTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getPrdCrteUseFlg())) {
							priScgRtVOS[i].setScgPrdCrteCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getPsaNoMngFlg())) {						                         
							priScgRtVOS[i].setPsaNo("");
						}
						
						if("N".equals(priScgPrfVOS[0].getRcAirCondTpUseFlg())) {						                         
							priScgRtVOS[i].setRcAirCondTpCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getCtrtDtUseFlg())) {						                         
							priScgRtVOS[i].setCtrtDt("");
						}
						
						if("N".equals(priScgPrfVOS[0].getActRatUseFlg())) {						                         
							priScgRtVOS[i].setActRatFlg("");
						}
						
						if("N".equals(priScgPrfVOS[0].getPrnHdnUseFlg())) {						                         
							priScgRtVOS[i].setPrnHdnFlg("");
						}
						
						if("N".equals(priScgPrfVOS[0].getFdGrdUseFlg())) {						                         
							priScgRtVOS[i].setFdGrdFlg("");
						}
						
						if("N".equals(priScgPrfVOS[0].getSteUseFlg())) {						                         
							priScgRtVOS[i].setCntCd("");
							priScgRtVOS[i].setSteCd("");
						}
						
						if("N".equals(priScgPrfVOS[0].getArrDtUseFlg())) {
							priScgRtVOS[i].setArrDt("");
						}
					}
					command.manageSurchargeRate(priScgRtVOS, account);
				}
			} else if("D".equals(stsCd)) {
				CstPriScgRtVO cstPriScgRtVO = new CstPriScgRtVO();
				cstPriScgRtVO.setSvcScpCd(svcScpCd);
				cstPriScgRtVO.setChgCd(chgCd);
				command.removeSurchargeRate(cstPriScgRtVO);
				command.removeSurchargePreferences(cstPriScgRtVO);
			}
			
			commit();
			
//			String dupIdx = command.checkSurchargeDuplicate(priScgRtVOS);
//			if("".equals(dupIdx)) {
//				eventResponse.setETCData("FLAG", "Y");
//				eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
//				commit();
//				log.debug("checkSurchargeDuplicate=======================commit");
//			} else {
//				eventResponse.setETCData("DUP_INDEX", dupIdx);
//				eventResponse.setETCData("FLAG", "N");
//				rollback();
//				log.debug("checkSurchargeDuplicate=======================rollback");
//			}
//						
			 
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
//	private EventResponse manageSurcharge(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		PriScgPrfVO[] priScgPrfVOS = null;
//		PriScgRtVO[] priScgRtVOS = null;
//		
//		EsmPri4003Event event = (EsmPri4003Event)e;
//		priScgPrfVOS = event.getPriScgPrfVOS();
//		priScgRtVOS = event.getPriScgRtVOS();
//
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		SurchargeBC command = new SurchargeBCImpl();
//		
//		try{
//			String stsCd = priScgPrfVOS[0].getIbflag();
//			String svcScpCd = priScgPrfVOS[0].getSvcScpCd();
//			String chgCd = priScgPrfVOS[0].getChgCd();
//			log.debug("surcharge===================1");
//			begin();
//			
//			if("I".equals(stsCd) || "U".equals(stsCd)) {
//				command.manageSurchargePreferences(priScgPrfVOS, account);
//				
//				if(priScgRtVOS != null) {
//					for(int i=0; i<priScgRtVOS.length; i++) {
//						if("N".equals(priScgPrfVOS[0].getPorUseFlg())) {
//							priScgRtVOS[i].setPorDefCd("");
//							priScgRtVOS[i].setPorTpCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getPolUseFlg())) {
//							priScgRtVOS[i].setPolDefCd("");
//							priScgRtVOS[i].setPolTpCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getPodUseFlg())) {
//							priScgRtVOS[i].setPodDefCd("");
//							priScgRtVOS[i].setPodTpCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getDelUseFlg())) {
//							priScgRtVOS[i].setDelDefCd("");
//							priScgRtVOS[i].setDelTpCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getImdgClssUseFlg())) {
//							priScgRtVOS[i].setScgImdgClssCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getSubTrdUseFlg())) {
//							priScgRtVOS[i].setSubTrdCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getSlanUseFlg())) {
//							priScgRtVOS[i].setVslSlanCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getTsPortUseFlg())) {
//							priScgRtVOS[i].setTsPortCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getDirCallUseFlg())) {
//							priScgRtVOS[i].setDirCallFlg("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getTmlUseFlg())) {
//							priScgRtVOS[i].setTmlCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getTrnsModUseFlg())) {
//							priScgRtVOS[i].setOrgTrspModCd("");
//							priScgRtVOS[i].setDestTrspModCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getUsaSvcModUseFlg())) {
//							priScgRtVOS[i].setUsaSvcModCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getRcvDeTermUseFlg())) {
//							priScgRtVOS[i].setPrcRcvTermCd("");
//							priScgRtVOS[i].setPrcDeTermCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getHngrBarUseFlg())) {
//							priScgRtVOS[i].setPrcHngrBarTpCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getCgoWgtUseFlg())) {
//							priScgRtVOS[i].setMinCgoWgt("");
//							priScgRtVOS[i].setMaxCgoWgt("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getCmdtUseFlg())) {
//							priScgRtVOS[i].setCmdtCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getGriCmdtUseFlg())) {
//							priScgRtVOS[i].setScgGrpCmdtCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getSocUseFlg())) {
//							priScgRtVOS[i].setSocFlg("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getIoGaUseFlg())) {
//							priScgRtVOS[i].setIoGaCd("");
//						}
//						
//						if("N".equals(priScgPrfVOS[0].getCnlTzFlg())) {
//							priScgRtVOS[i].setCnlTzCd("");
//						}
//					}
//					command.manageSurchargeRate(priScgRtVOS, account);
//				}
//			} else if("D".equals(stsCd)) {
//				CstPriScgRtVO cstPriScgRtVO = new CstPriScgRtVO();
//				cstPriScgRtVO.setSvcScpCd(svcScpCd);
//				cstPriScgRtVO.setChgCd(chgCd);
//				command.removeSurchargeRate(cstPriScgRtVO);
//				command.removeSurchargePreferences(cstPriScgRtVO);
//			}
//			
//			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
//			commit();
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		}catch(Exception ex){
//			rollback();
//		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//		}
//		return eventResponse;
//	}
	
	/**
	 * ESM_PRI_4003, ESM_PRI_4016 : Save <br>
	 * Surcharge Preferences와 Surcharge를 수정합니다. <br>
	 * Surcharge와 Excel Upload 두화면에서 사용합니다. <br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4016Event event = (EsmPri4016Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		PriScgRtVO[] priScgRtVOS = null;
		
		try{
			begin();			
			priScgRtVOS = event.getPriScgRtVOS();
			command.manageSurchargeRate(event.getPriScgRtVOS(), account);			
			String dupIdx = command.checkSurchargeDuplicate(priScgRtVOS);
			log.debug("dupIdx=================="+dupIdx);
//			commit();
			
			if("".equals(dupIdx)) {
				eventResponse.setETCData("FLAG", "Y");
				eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
				commit();
			} else {
				eventResponse.setETCData("DUP_INDEX", dupIdx);
				eventResponse.setETCData("FLAG", "N");
				rollback();
			}			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
//	private EventResponse manageSurchargeRate(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EsmPri4016Event event = (EsmPri4016Event)e;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		SurchargeBC command = new SurchargeBCImpl();
////		PriScgRtVO[] priScgRtVOS = null;
//		
//		try{
//			begin();
//			command.manageSurchargeRate(event.getPriScgRtVOS(), account);
//			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
//			commit();
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		}catch(Exception ex){
//			rollback();
//		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//		}
//		return eventResponse;
//	}	
	
	/**
	 * ESM_PRI_4003 : Retrieve <br>
	 * Surcharge를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
				GeneralEventResponse eventResponse = new GeneralEventResponse();
				PriScgRtVO paramVO = new PriScgRtVO();
				if(e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
					EsmPri4003Event event = (EsmPri4003Event)e;
					paramVO = event.getPriScgRtVO();
				} else if(e.getEventName().equalsIgnoreCase("EsmPri4016Event")) {
					EsmPri4016Event event = (EsmPri4016Event)e;
					paramVO = event.getPriScgRtVO();
				}
				
				try{
					SurchargeBC command = new SurchargeBCImpl();
					List<PriScgRtVO> list = command.searchSurchargeList(paramVO);
					eventResponse.setRsVoList(list);
					
					if(e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
						List<PriScgRtVO> list2 = command.searchSurchargeRequestList(paramVO);
						eventResponse.setRsVoList(list2);	
					}
					
				}catch(EventException ex){
		            throw ex;
		        }catch(Exception ex){
		            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		        }
				return eventResponse;
	}
	

	
	/**
	 * ESM_PRI_4016 : Save <br>
	 * Surcharge를 수정합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSurchargeDuplicate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PriScgRtVO[] priScgRtVOS = null;
		
		if(e.getEventName().equalsIgnoreCase("EsmPri4003Event")) {
			EsmPri4003Event event = (EsmPri4003Event)e;
			priScgRtVOS = event.getPriScgRtVOS();
		} else if(e.getEventName().equalsIgnoreCase("EsmPri4016Event")) {
			EsmPri4016Event event = (EsmPri4016Event)e;
			priScgRtVOS = event.getPriScgRtVOS();
		}
		
		SurchargeBC command = new SurchargeBCImpl();
		String dupIdx = command.checkSurchargeDuplicate(priScgRtVOS);
		if("".equals(dupIdx)) {
			eventResponse.setETCData("FLAG", "Y");
		} else {
			eventResponse.setETCData("DUP_INDEX", dupIdx);
			eventResponse.setETCData("FLAG", "N");
		}
		return eventResponse;
		
		
		
		
//		String dupIdx = command.checkSurchargeDuplicate(priScgRtVOS);
//		if("".equals(dupIdx)) {
//			eventResponse.setETCData("FLAG", "Y");
//			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
//			commit();
//			log.debug("checkSurchargeDuplicate=======================commit");
//		} else {
//			eventResponse.setETCData("DUP_INDEX", dupIdx);
//			eventResponse.setETCData("FLAG", "N");
//			rollback();
//			log.debug("checkSurchargeDuplicate=======================rollback");
//		}
		
	}
	
	/**
	 * ESM_PRI_4011 : Search <br>
	 * Sucharge의 전체 List를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllSurchargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4011Event event = (EsmPri4011Event)e;
		SurchargeBC command = new SurchargeBCImpl();
		try{
			List<PriScgRtVO> list = command.searchAllSurchargeList(event.getCstPriScgRtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	
	//ESM_PRI_4009 E-SVC Compensation Creation start
	//////////////////////////////////////////////////////////////////////////////////	
	
    /**
     * ESM_PRI_4009, ESM_PRI_4010 : Open<br>
     * E-SVC Compensation 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initEServiceCompensation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        EServiceCompensationBC esCommand = new EServiceCompensationBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();

        RsltCdListVO custVo = null;
        MdmSvcScpLmtVO esVo = null;
        RsltCompensationChargeComboListVO chgVo = null;
        
        List<RsltCdListVO> customData = null;
        List<MdmSvcScpLmtVO> esList = null;
        List<CodeInfo> ctList = null;
        List<RsltCompensationChargeComboListVO> chgList = null;

        try{
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            
            ctList = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 3);
            eventResponse.setCustomData("contract", ctList);
            
            if(e.getEventName().equalsIgnoreCase("EsmPri4009Event")) {
            	
	        	// orign
	            esVo = new MdmSvcScpLmtVO();
	            esVo.setSvcScpCd(""); esVo.setDeltFlg(""); esVo.setOrgDestCd("O");
	            esList = esCommand.searchEServiceCompensationOrigiComboList(esVo);
	            eventResponse.setCustomData("origin", esList);
	        	// dest
	            esVo = new MdmSvcScpLmtVO();
	            esVo.setSvcScpCd(""); esVo.setDeltFlg(""); esVo.setOrgDestCd("D");
	            esList = esCommand.searchEServiceCompensationOrigiComboList(esVo);
	            eventResponse.setCustomData("dest", esList);
	            // cur
	            custVo = new RsltCdListVO();
	            custVo.setEtc1("");
	            customData = command.searchAllCurrencyCodeList(custVo);
	            eventResponse.setCustomData("cur", customData);
	            
            }
            
        	// charge
            chgVo = new RsltCompensationChargeComboListVO();
	        if (e.getEventName().equalsIgnoreCase("EsmPri4009Event")) {
	            chgVo.setDeltFlg("N");
	            chgVo.setProgId("4009");
	        }else if(e.getEventName().equalsIgnoreCase("EsmPri4010Event")) {
	            chgVo.setDeltFlg("");
	            chgVo.setProgId("4010");
	        }
            chgList = command.searchCompensationChargeComboList(chgVo);
            eventResponse.setCustomData("charge", chgList);            
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * ESM_PRI_4009,4010 : Retrieve<br>
	 * E-SVC Compensation Creation, Inquiry의 리스트 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEServiceCompensationList(Event e) throws EventException {
		List<PriCmpnEsvcVO> list = null;
		EServiceCompensationBC command = new EServiceCompensationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PriCmpnEsvcVO priCmpnEsvcVO = new PriCmpnEsvcVO();
		try{
	        if (e.getEventName().equalsIgnoreCase("EsmPri4009Event")) {
	    		EsmPri4009Event event = (EsmPri4009Event)e;
	    		priCmpnEsvcVO = event.getPriCmpnEsvcVO();
	        }else if(e.getEventName().equalsIgnoreCase("EsmPri4010Event")) {
	        	EsmPri4010Event event = (EsmPri4010Event)e;
                priCmpnEsvcVO = event.getPriCmpnEsvcVO();
	        }
	        list = command.searchEServiceCompensationList(priCmpnEsvcVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4009 : scope change <br>
	 * E-SVC Compensation Creation의 event에 대한 origin, dest 콤보 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEServiceCompensationOrigiComboList(Event e) throws EventException {
		List<MdmSvcScpLmtVO> list = null;
		MdmSvcScpLmtVO paramVo = new MdmSvcScpLmtVO();
		EServiceCompensationBC command = new EServiceCompensationBCImpl();		
		EsmPri4009Event event = (EsmPri4009Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			paramVo = event.getMdmSvcScpLmtVO();
			list = command.searchEServiceCompensationOrigiComboList(paramVo);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4009 :  RFA & SC No change<br>
	 * E-SVC Compensation Creation의 event에 대한 SC No. 존재여부 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEServiceCompensationSCNo(Event e) throws EventException {
		String scNo = "";
		EServiceCompensationBC command = new EServiceCompensationBCImpl();
		EsmPri4009Event event = (EsmPri4009Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			scNo = command.searchEServiceCompensationSCNo(event.getPriSpHdrVO());
			eventResponse.setETCData("SC_NO", scNo);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_PRI_4009 :  RFA & SC No change<br>
	 * E-SVC Compensation Creation의 event에 대한 RFA NO. 존재여부 조회 이벤트 처리<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEServiceCompensationRFANo(Event e) throws EventException {
		String rfaNo = "";
		EServiceCompensationBC command = new EServiceCompensationBCImpl();
		EsmPri4009Event event = (EsmPri4009Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			rfaNo = command.searchEServiceCompensationRFANo(event.getPriRpHdrVO());
			eventResponse.setETCData("RFA_NO", rfaNo);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_PRI_4009 :  Save<br>
	 * E-SVC Compensation Creation의 event에 대한 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEServiceCompensation(Event e) throws EventException {
	    EServiceCompensationBC command = new EServiceCompensationBCImpl();
	    EsmPri4009Event event = (EsmPri4009Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
	        begin();
	        command.manageEServiceCompensation(event.getPriCmpnEsvcVOS(),account);
	        eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
	        commit();
	    }catch(EventException ex){
	        rollback();
	        throw ex;
	    }catch(Exception ex){
	        rollback();
	        throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
	    }
	    return eventResponse;
	}
	
	//ESM_PRI_4009 E-SVC Compensation Creation end
	//////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * ESM_PRI_4003 : Load Page <br>
	 * 기본 Code List를 초기화한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initSurchargeComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PRICommonBC command1 = new PRICommonBCImpl();
		SurchargeBC command2 = new SurchargeBCImpl();
		
		CodeUtil cdUtil = CodeUtil.getInstance();
		
		List<RsltCdListVO> customData = null;
		List<CodeInfo> codeInfos = null;
		
		try{
			// Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("SCG_Surcharge_Templet.xls");
			String fileKey = command1.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("templateKey", fileKey);
			
			//service scope code
			customData = command1.searchServiceScopeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("svcScpCd", customData);
			
//			//Trade code
			customData = command1.searchSurchargeTradeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("trdCd", customData);
			
			//charge code
			customData = command1.searchChargeCdList(new RsltCdListVO());
			eventResponse.setCustomData("chgCd", customData);
			
			customData = command2.searchComboPctBseCdList(new PriScgPrfVO());
			eventResponse.setCustomData("pctBseCd", customData);
			
			// Surcharge Imdge Class
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02128", 0);
		    eventResponse.setCustomData("scgImdgClssCd", codeInfos);
		    
		    // Origin Trans Mode
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
		    eventResponse.setCustomData("orgTrspModCd", codeInfos);
		    
		    // Dest Trans Mode
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
		    eventResponse.setCustomData("destTrspModCd", codeInfos);
		    
		    // Usa Service Mode Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01729", 0);
		    eventResponse.setCustomData("usaSvcModCd", codeInfos);
		    
		    // Pricing Receiving Term Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02070", 0);
		    eventResponse.setCustomData("prcRcvTermCd", codeInfos);
		    
		    // Pricing Destination Term Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02071", 0);
		    eventResponse.setCustomData("prcDeTermCd", codeInfos);
		    
		    // Pricing Hanger Bar Type Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01708", 0);
		    eventResponse.setCustomData("prcHngrBarTpCd", codeInfos);
		    
		    // Payment Term Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01713", 0);
		    eventResponse.setCustomData("payTermCd", codeInfos);
		    
		    // Rating Unit Code
		    customData = command1.searchAllPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("ratUtCd", customData);
		    
			// Cargo Type Code
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02141", 0);
		    eventResponse.setCustomData("prcCgoTpCd", codeInfos);
		    
		    // Surcharge Imdge Class Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02128", 0);
		    eventResponse.setCustomData("scgImdgClssCd", codeInfos);
		    
		    // Currency Code
		    customData = command1.searchAllCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCd", customData);
		    
			// Direct Call Code
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00912", 0);
		    eventResponse.setCustomData("dirCallFlg", codeInfos);
		    
		    // Commercial Feeder Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00912", 0);
		    eventResponse.setCustomData("socFlg", codeInfos);
		    
		    // In/Out Gauge
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02142", 0);
		    eventResponse.setCustomData("ioGaCd", codeInfos);
		    
		    // Sub trade Code
		    customData = command1.searchSubTrdCdList(new RsltCdListVO());
			eventResponse.setCustomData("subTrdCd", customData);
			
			// Size
			customData = command1.searchMdmCntrSzCodeList(new RsltCdListVO());
			eventResponse.setCustomData("cntrSzCd", customData);
			
			// Canal Transit Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02538", 0);
		    eventResponse.setCustomData("cnlTzCd", codeInfos);
		    
			// Period Type Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02955", 0);
		    eventResponse.setCustomData("scgPrdTpCd", codeInfos);
		    
			// Period Criteria Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02957", 0);
		    eventResponse.setCustomData("scgPrdCrteCd", codeInfos);
		    
			//PSA Group code
			customData = command2.searchComboPsaCdList(new PriScgPrfVO());
			eventResponse.setCustomData("psaCd", customData);
			
			// Reefer Cargo Air Condition Type Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03187", 0);
		    eventResponse.setCustomData("rfCondCd", codeInfos);
		    
		   // Auto Rating Falg
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00912", 0);
		    eventResponse.setCustomData("actRatFlg", codeInfos);
		    
		   // Food Grade
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00912", 0);
		    eventResponse.setCustomData("fdGrdFlg", codeInfos);

		    // Surcharge Process Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03494", 0);
		    eventResponse.setCustomData("scgRqstProcCd", codeInfos);
		    
		    // Surcharge Status Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD03495", 0);
		    eventResponse.setCustomData("scgRqstStsCd", codeInfos);
		    
		    
		    
		    
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
    /**
     * ESM_PRI_4033 : Open<br>
     * Application Date Rule 화면의 Sheet Combo Item 을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initApplicationDateRule(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        
        List<RsltCdListVO> customData = null;
        List<CodeInfo> ctList = null;
        
        try{
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
		    
            // Location Type Code List
            ctList = (List<CodeInfo>)cdUtil.getCodeSelect("CD01718", 3);
            eventResponse.setCustomData("tpCd", ctList);
            
            // Application Date Rule Code List
            ctList = (List<CodeInfo>)cdUtil.getCodeSelect("CD02861", 3);
            eventResponse.setCustomData("applDtRule", ctList);
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_4033 : Retrieve<br>
	 * Application Date Rule의 리스트 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApplicatoinDateRule(Event e) throws EventException {
		EsmPri4033Event event = (EsmPri4033Event)e;
		List<RsltPriScgAplyDtRuleVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();
		
		try{
	        list = command.searchApplicatoinDateRule(event.getPriScgAplyDtRuleVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4033 : Save <br>
	 * Application Date Rule을 저장합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageApplicationDateRule(Event e) throws EventException {
		EsmPri4033Event event = (EsmPri4033Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();
		
		try{
			begin();
			command.manageApplicationDateRule(event.getPriScgAplyDtRuleVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4033 : Location Check<br>
	 * Location 체크 및 Location Type 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationTypeAndName(Event e) throws EventException {
		EsmPri4033Event event = (EsmPri4033Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();
		
		try{
			
			List<RsltCdListVO> list = command.searchLocationTypeAndName(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_4033 : Dup Check<br> 
	 * SAVE전 중복 데이터를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchApplicationDateRuleDupCheck(Event e) throws EventException {
		EsmPri4033Event event = (EsmPri4033Event)e;
		List<RsltPriScgAplyDtRuleVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ApplicationDateRuleBC command = new ApplicationDateRuleBCImpl();
		
		try{
	        list = command.searchApplicationDateRuleDupCheck(event.getPriScgAplyDtRuleVOs());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_4003 : Request <br>
	 * Surcharge를 Request 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestSurchargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
				PriScgRtVO[] priScgRtVOS = null;
				
				EsmPri4003Event event = (EsmPri4003Event)e;
				priScgRtVOS = event.getPriScgRtVOS();

				GeneralEventResponse eventResponse = new GeneralEventResponse();
				SurchargeBC command = new SurchargeBCImpl();
				
				try{
					command.requestSurchargeList(priScgRtVOS, account);
				}catch(EventException ex){
					rollback();
					throw ex;
				}catch(Exception ex){
					rollback();
				    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
				}
				return eventResponse;
			}	
	
	/**
	 * ESM_PRI_4003 : approve <br>
	 * Surcharge를 approve 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approveSurchargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PriScgRtVO[] priScgRtVOS = null;
		
		EsmPri4003Event event = (EsmPri4003Event)e;
		priScgRtVOS = event.getPriScgRtVOS();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		
		try{
			begin();
			
			command.approveSurchargeList(priScgRtVOS, account);
		
			String dupIdx = command.checkSurchargeDuplicate(priScgRtVOS);
			
			if("".equals(dupIdx)) {
				eventResponse.setETCData("FLAG", "Y");
				eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
				commit();
				log.debug("checkSurchargeDuplicate=======================commit");
			} else {
				eventResponse.setETCData("DUP_INDEX", dupIdx);
				eventResponse.setETCData("FLAG", "N");
				rollback();
				log.debug("checkSurchargeDuplicate=======================rollback");
			}
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	

	/**
	 * ESM_PRI_4003 : approve <br>
	 * Surcharge 승인 권한을 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeAuth(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4003Event event = (EsmPri4003Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		
		try{
			PriScgAuthVO authVO = command.searchSurchargeAuth(event.getPriScgAuthVO(), account);
			String aproAuth = "";
			aproAuth = authVO.getAproAuth();
			eventResponse.setETCData("aproAuth" , aproAuth);
			log.error(">>>>>>>>>>>>>>>>: " + aproAuth);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_4003 :  <br>
	 * Service Scope 정합성 체크 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkServiceScope(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4003Event event = (EsmPri4003Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		
		try{
			PriScgAuthVO authVO = command.checkServiceScope(event.getPriScgAuthVO());
			String chkFlg = "";
			chkFlg = authVO.getChkFlg();
			eventResponse.setETCData("chkFlg" , chkFlg);
			log.error(">>>>>>>>>>>>>>>>: " + chkFlg);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * ESM_PRI_4003 : Save Cancel <br>
	 * Surcharge Save Cancel 기능 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelSurchargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PriScgRtVO[] priScgRtVOS = null;
		
		EsmPri4003Event event = (EsmPri4003Event)e;
		priScgRtVOS = event.getPriScgRtVOS();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		
		try{
			command.cancelSurchargeList(priScgRtVOS);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_4003 : Trade 별 Service Scope Code 검색 <br>
	 *  Trade 별 Service Scope Code 검색 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTradeServiceScopeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PriScgRtVO priScgRtVO = null;
		List<RsltCdListVO> list = null;
		EsmPri4003Event event = (EsmPri4003Event)e;
		priScgRtVO = event.getPriScgRtVO();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SurchargeBC command = new SurchargeBCImpl();
		
		try{
			list = command.searchTradeServiceScopeCodeList(priScgRtVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * Surcharge Group Commodity Code List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgGrpCmdtCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4003Event event = (EsmPri4003Event)e;
		SurchargeBC command = new SurchargeBCImpl();
		
		try {
			List<PriScgRtVO> list = command.searchScgGrpCmdtCdList(event.getPriScgRtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
}