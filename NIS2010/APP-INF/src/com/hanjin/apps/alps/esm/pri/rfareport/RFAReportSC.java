/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAReportSC.java
*@FileTitle : RFA Proposal Creation – Draft
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.15 변영주
* 1.0 Creation
=========================================================
2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정 - searchRFARateSearchListDoStart,searchRFAList SignOnUserAccount parameter 추가
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2014.11.25 최성환 [CHM-201432700] Retroactive RFA Minimization관련 시스템 개발요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.basic.RFAReportBC;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.basic.RFAReportBCImpl;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri2039Event;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri2042Event;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri2043Event;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri2046Event;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri2211Event;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri221901Event;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event.EsmPri221902Event;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration.RFAReportDBDAO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.MasterRFAConditionVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriCopiedRFAVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriMasterRFAOnlyVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRFABlVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRpRetroInfoVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltRFARetRDInfoVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFAListVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-RFAReport Business Logic ServiceCommand - ALPS-RFAReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Byeon Young Joo
 * @see RFAReportDBDAO
 * @since J2EE 1.6
 */

public class RFAReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RFAReport system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("RFAReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RFAReport system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("RFAReportSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-RFAReport system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmPri2039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRFARetrievalRDInfo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri2043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFAList(e);
			}else{
				eventResponse = initRFARetrieval(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri2042Event")) {
			if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//It starts a job of backend. 1
				eventResponse = searchRFARateSearchList(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJbVOs(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){//It returns a result. 3
				eventResponse = comBackEndJbSearchListGetResult(e);
			}else{
				eventResponse = initRateRetrieval(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri2046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRetroactiveRFAList(e);
			}else{
				eventResponse = initRetroactiveRFAList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmPri221901Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMasterRFAOnlyList(e);
			}else{
				eventResponse = initMasterRFAInquiry(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmPri221902Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCopiedRFAList(e);
			}else{
				eventResponse = initCopiedRFAInquiry(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmPri2211Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchRFABlList(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2039 : Retrieve<br>
	 * RFAReport의 Report 관련 정보 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFARetrievalRDInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2039Event event = (EsmPri2039Event)e;
		RFAReportBC command = new RFAReportBCImpl();

		try{
			List<RsltRFARetRDInfoVO> list = command.searchRFARetrievalRDInfo(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	

    /**
     * ESM_PRI_2043 : Open<br>
     * RFA Retrieval 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initRFARetrieval(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        try{
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        	// Customer code combo
            //codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02295", 0);
            //eventResponse.setCustomData("customerCode", codeInfos);
        	// Customer Type combo
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00697", 0);
            eventResponse.setCustomData("customerType", codeInfos);
            // RFA Type combo
			ArrayList<CodeInfo> rfaCtrtTpList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03493", 0); //CD03493 <--- CD03264
			eventResponse.setCustomData("rfaCtrtTpList", rfaCtrtTpList);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_PRI_2043 : Retrieve <br>
	 * RFA Search - RFA Retrieval 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFAList(Event e) throws EventException {
		List<RsltSearchRFAListVO> list = null;
		RFAReportBC command = new RFAReportBCImpl();
		EsmPri2043Event event = (EsmPri2043Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			list = command.searchRFAList(event.getRsltSearchRFAListVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	

    /**
     * ESM_PRI_2042 : Open<br>
     * RFA Retrieval 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initRateRetrieval(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<RsltCdListVO> customData = null;
        List<CodeInfo> codeInfos = null;
        try{
            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
            // charge S/C RATE SEARCH CHARGE CODE ( 통합코드 : CD02294 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02294", 0);
            eventResponse.setCustomData("charge", codeInfos);
            // TP/SZ => PRICommonSC.searchAllPerCodeList()
            customData = command.searchAllPerCodeList(new RsltCdListVO());
            eventResponse.setCustomData("tpSz", customData);
            // Cargo Type => S/C CARGO TYPE CODE  ( 통합코드 : CD02202 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02202", 0);
            eventResponse.setCustomData("cargoType", codeInfos);
        	// Customer Type combo
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00697", 0);
            eventResponse.setCustomData("customerType", codeInfos);
            // Rate  => S/C REPORT OPERATION CODE, S/C REPORT OPERATION CODE  ( 통합코드 : CD02280 )
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02280", 0);
            eventResponse.setCustomData("rate", codeInfos);
            // RFA Type combo
			ArrayList<CodeInfo> rfaCtrtTpList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03264", 0);
			eventResponse.setCustomData("rfaCtrtTpList", rfaCtrtTpList);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_PRI_2042 : Retrieve <br>
	 * RFA Search - Rate Retrieval 리스트를 조회 위해 BackEndJob을 실행한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFARateSearchList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2042Event event = (EsmPri2042Event)e;
		RFAReportBC command = new RFAReportBCImpl();
		try{
			eventResponse.setETCData("BackEndJobKey", command.searchRFARateSearchListDoStart(account, event.getRsltSearchRFARateSearchListVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	//CHM-201432700 Retroactive RFA Minimization관련 시스템 개발요청
	/**
	 * ESM_PRI_2046 : Retrieve <br>
	 * Retroactive RFA Search -Retroactive RFA Retrieval 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRetroactiveRFAList(Event e) throws EventException {
		List<RsltPriRpRetroInfoVO> list = null;
		RFAReportBC command = new RFAReportBCImpl();
		EsmPri2046Event event = (EsmPri2046Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			list = command.searchRetroactiveRFAList(event.getRsltPriRpRetroInfoVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}		

	/**
     * ESM_PRI_2046 : Open<br>
     * Retroactive RFA Retrieval 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initRetroactiveRFAList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        CodeUtil cdUtil = CodeUtil.getInstance();
        try{
        	
            // RFA Type combo
			ArrayList<CodeInfo> rfaCtrtTpList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03264", 0);
			eventResponse.setCustomData("rfaCtrtTpList", rfaCtrtTpList);
			
			// Retroactive RFA Note combo
			ArrayList<CodeInfo> rtroNoteList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03344", 0);
			eventResponse.setCustomData("rtroNoteList", rtroNoteList);

        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
/****************************************************************************************/
/* BACK END JOB 관련                                                                                      							        */
/****************************************************************************************/
	
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
		RFAReportBC command = new RFAReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
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
		String key = (String)e.getAttribute("KEY");
		List list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			if(e.getEventName().equalsIgnoreCase("EsmPri2042Event")) {
				list = (List<RsltSearchRFARateSearchListVO>)BackEndJobResult.loadFromFile(key);
			}
			eventResponse.setRsVoList(list);		
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
    

    /**
	 * ESM_PRI_2219_01 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMasterRFAOnlyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri221901Event event = (EsmPri221901Event)e;
		RFAReportBC command = new RFAReportBCImpl();
		try{
			List<RsltPriMasterRFAOnlyVO> list = command.searchMasterRFAOnlyList(event.getMasterRFAConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2219_01 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCopiedRFAList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri221902Event event = (EsmPri221902Event)e;
		RFAReportBC command = new RFAReportBCImpl();
		try{
			MasterRFAConditionVO convo = event.getMasterRFAConditionVO();
			convo.setFSlsRep(account.getSrep_cd());
			List<RsltPriCopiedRFAVO> list = command.searchCopiedRFAList(convo);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2211 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFABlList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2211Event event = (EsmPri2211Event)e;
		RFAReportBC command = new RFAReportBCImpl();
		try{
			List<RsltPriRFABlVO> list = command.searchRFABlList(event.getMasterRFAConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
    /**
     * ESM_PRI_2219_01 : Open<br>
     * Master RFA Inquiry (& Copied RFA List) <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse initMasterRFAInquiry(Event e) throws EventException {
    	PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;
        try{
        	// Service Scope
        	vo.setCd("CD03504");
        	list = command.searchComCodeDescList(vo);
        	eventResponse.setCustomData("scopeList", list);
        	  // Scope combo - ALL
//        	list = command.searchServiceScopeCodeList(new RsltCdListVO());
//            eventResponse.setCustomData("scopeList", list);
            
    		// Origin Term
			vo.setCd("CD03501");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("termOrgCdList", list);
			
			// Dest Term
			vo.setCd("CD03500");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("termDestCdList", list);
			
            //  RHQ combo
        	list = command.searchRHQList(new RsltCdListVO());
            eventResponse.setCustomData("rhq", list);
            
			// STATUS
			vo.setCd("CD02394");
			list = command.searchComCodeDescList(vo);
/*			// Returned 삭제 시
			for (int i = 0; i < list.size(); i++) {
				RsltCdListVO rsltCdListVO = list.get(i);
				if(rsltCdListVO.getCd().equals("R")){
					list.remove(i);
				}
			}*/
			eventResponse.setCustomData("propStsCd", list);
			

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_2219_02 : Open<br>
     * Master RFA Inquiry (& Copied RFA List) <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse initCopiedRFAInquiry(Event e) throws EventException {
    	PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;
        try{
        	// Service Scope
        	vo.setCd("CD03504");
        	list = command.searchComCodeDescList(vo);
        	eventResponse.setCustomData("scopeList", list);
        	
            //  RHQ combo
        	list = command.searchRHQList(new RsltCdListVO());
            eventResponse.setCustomData("rhq", list);
            
			// STATUS
			vo.setCd("CD02394");
			list = command.searchComCodeDescList(vo);
/*			// Returned 삭제 시
			for (int i = 0; i < list.size(); i++) {
				RsltCdListVO rsltCdListVO = list.get(i);
				if(rsltCdListVO.getCd().equals("R")){
					list.remove(i);
				}
			}*/
			eventResponse.setCustomData("propStsCd", list);

			// PRICING CONTRACT CUSTOMER TYPE CODE  
			vo.setCd("CD00779");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("prcCtrtCustTpCd", list);

			// DEM/DET FREE TIME TYPE CODE 
			vo.setCd("CD01704");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("dmdtFtTpCd", list);
			
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
}