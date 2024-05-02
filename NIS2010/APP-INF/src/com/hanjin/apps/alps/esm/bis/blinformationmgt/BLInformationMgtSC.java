/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtSC.java
*@FileTitle : C/A Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.14 강동윤
* 1.0 Creation
* History
* 2012.08.22 김기택 [CHM-201219155-01] [BIS] B/L Preview 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.basic.BLInformationMgtBC;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.basic.BLInformationMgtBCImpl;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event.EsmBis0000Event;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event.EsmBis0001Event;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event.EsmBis0174Event;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event.EsmBis0278Event;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event.EsmBis0567Event;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event.EsmBis0927Event;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration.BLInformationMgtDBDAO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisBlNoVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisManualListVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisMonitorListVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaDetailVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaInfoByBkgVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaSummaryReportOutVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.GrpBlPrtOutVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.GrpBlPrtVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-BLInformationMgt Business Logic ServiceCommand - ALPS-BLInformationMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author kang dong yun
 * @see BLInformationMgtDBDAO
 * @since J2EE 1.6
 */

public class BLInformationMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
    private transient BLInformationMgtDBDAO dbDao = null;
    
    
	/**
	 * BLInformationMgt system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("BLInformationMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * BLInformationMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("BLInformationMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-BLInformationMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBis0174Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCaSummaryReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchCaSummaryReportBLList(e);
			}	
	    }
		/* EsmBis0278Event */
		else if (e.getEventName().equalsIgnoreCase("EsmBis0278Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCommonCdListVO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgListForGrpBlPr(e);
			}
		}
		/* EsmBis0567Event */
		else if(e.getEventName().equalsIgnoreCase("EsmBis0567Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCaInfoByBkg(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
            	eventResponse = searchCaDetail(e);
            }
        }
		/* EsmBis927Event */
		else if (e.getEventName().equalsIgnoreCase("EsmBis0927Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBisBlInfoForPreview(e);
			} 
		}
		/* EsmBis0001Evnet */
		else if(e.getEventName().equalsIgnoreCase("EsmBis0001Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBisMonitorList(e);
			}
		}
		/* EsmBis0000Evnet */
		else if(e.getEventName().equalsIgnoreCase("EsmBis0000Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBisManualList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = manageBisBkgManual(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = manageBisManual(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BIS_0174 : C/A Summary Report Result 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaSummaryReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBis0174Event event = (EsmBis0174Event)e;
		BLInformationMgtBC command = new BLInformationMgtBCImpl();

		List<CaSummaryReportOutVO> list = command.searchCaSummaryReport(event.getCaSummaryReportInVO()); 

		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 	
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BIS_0174 : C/A Summary Report BL List 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaSummaryReportBLList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBis0174Event event = (EsmBis0174Event)e;
		BLInformationMgtBC command = new BLInformationMgtBCImpl();

		List<CaSummaryReportOutVO> list = command.searchCaSummaryReportBLList(event.getCaSummaryReportInVO()); 

		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 		

	/**
	 * 조회 이벤트 처리<br>
	 * 조회조건을 가져오기위한 MultiCombo조회 결과<br>
	 * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCommonCdListVO(Event e) throws EventException {
		EsmBis0278Event event = (EsmBis0278Event) e;
		BookingUtil comboUtil = new BookingUtil();
		BLInformationMgtBC command = new BLInformationMgtBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// R/D Term - rcv_term_cd - CD00764
			List<BkgComboVO> rcv_term_cd = comboUtil.searchCombo("CD00764");
			eventResponse.setRsVoList(rcv_term_cd);

			// R/D Term - de_term_cd - CD00765
			List<BkgComboVO> de_term_cd = comboUtil.searchCombo("CD00765");
			eventResponse.setRsVoList(de_term_cd);

			// S.Route(From) - org_sconti_cd - getBkgcombovo
			List<BkgComboVO> org_sconti_cd = command.searchSRouteFromList(event.getBkgcombovo());
			eventResponse.setRsVoList(org_sconti_cd);

			// S.Route(To) - org_sconti_cd - getBkgcombovo
			List<BkgComboVO> desc_sconti_cd = command.searchSRouteFromList(event.getBkgcombovo());
			eventResponse.setRsVoList(desc_sconti_cd);

			// S.Mode(From) - org_svc_mod_cd - CD02149
			List<BkgComboVO> org_svc_mod_cd = comboUtil.searchCombo("CD02149");
			eventResponse.setRsVoList(org_svc_mod_cd);

			// S.Mode(To) - desc_inlnd_svc_mod_cd - CD02149
			List<BkgComboVO> desc_inlnd_svc_mod_cd = comboUtil.searchCombo("CD02149");
			eventResponse.setRsVoList(desc_inlnd_svc_mod_cd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * O B/L을 group으로 출력하기 위한 대상 list를 조회한다.<br>
	 * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgListForGrpBlPr(Event e) throws EventException {

		EsmBis0278Event event = (EsmBis0278Event) e;
		BLInformationMgtBC command = new BLInformationMgtBCImpl();

		// 컨테이너 vo
		GrpBlPrtOutVO cVo = new GrpBlPrtOutVO();
		List<GrpBlPrtVO> grpBlPrt = new ArrayList<GrpBlPrtVO>();

		// 컨테이너 vo에서 각 조회결과를 뽑아서 response에 세팅
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// 컨테이너 vo로 조회 결과 리턴
			cVo = command.searchBkgListForGrpBlPr(event.getGrpBlPrtInVO());
			grpBlPrt = cVo.getGrpBlPrts();

			eventResponse.setRsVoList(grpBlPrt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * (ESM_BKG_0567) bkg별 기본 정보와 C/A 변경 list를 조회한다.<br>
	 * @author    Lee NamKyung
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaInfoByBkg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		EsmBis0567Event event = (EsmBis0567Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLInformationMgtBC command = new BLInformationMgtBCImpl();
		
		try {
			CaInfoByBkgVO caInfoByBkgVO = command.searchCaInfoByBkg(event.getBkgBlNoVO()); 
					
	        //01. etcData
			if (caInfoByBkgVO == null || caInfoByBkgVO.getCaBkgInfoVO() == null || 
			    "".equals(JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getBkgNo()))) {
				// No data found.
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());	
				eventResponse.setETCData("DataYn", "N");
			} else {		
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getBkgNo()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getBlNo()));
				eventResponse.setETCData("ca_no",            JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getCaNo()));
				eventResponse.setETCData("cust_cnt_cd",      JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getCustCntCd()));
				eventResponse.setETCData("cust_nm",          JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getCustNm()));
				eventResponse.setETCData("cust_seq",         JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getCustSeq()));
				eventResponse.setETCData("sailed_vvd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getSailedVvd()));
				eventResponse.setETCData("t_vvd",            JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getTVvd()));
				eventResponse.setETCData("por_cd",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPorCd()));
				eventResponse.setETCData("pol_cd",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPolCd()));
				eventResponse.setETCData("del_cd",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getDelCd()));
				eventResponse.setETCData("pod_cd",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPodCd()));
				eventResponse.setETCData("por_nod_cd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPorNodCd()));
				eventResponse.setETCData("pol_nod_cd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPolNodCd()));
				eventResponse.setETCData("del_nod_cd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getDelNodCd()));
				eventResponse.setETCData("pod_nod_cd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPodNodCd()));
				
				//02. list
				eventResponse.setRsVoList(caInfoByBkgVO.getCaListByBkgVOs());
				eventResponse.setETCData("DataYn", "Y");
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}
	
	/**
	 * B/L Preview 화면 설정을 위한 Data를 조회한다.(ESM_BIS_0927)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBisBlInfoForPreview(Event e) throws EventException {
		EsmBis0927Event event = (EsmBis0927Event) e;
		GeneralEventResponse eventResponse = null;

		BLInformationMgtBC command = null;

		BisBlNoVO bisBlNoIN = null;

		String bkg_no = "";
		String bl_no = "";
		String bl_tp_cd = "";
		String por_cd = "";
		String hiddenData = "";
		String rate = "";
		String cntr = "";
		String rider_yn = "";
		String houseBl_yn = "";
		String corr_no = "";
		String obl_iss_flg = "";

		try {
			
			dbDao = new BLInformationMgtDBDAO();
			eventResponse = new GeneralEventResponse();
			command = new BLInformationMgtBCImpl();

			// searchBkgBlNo
			bisBlNoIN = new BisBlNoVO();
			bisBlNoIN.setBkgNo(event.getBkg_no());
			bisBlNoIN.setBlNo(event.getBl_no());
			bisBlNoIN.setCaUsrId(account.getUsr_id());
			
			BisBlNoVO bisBlNoVO = searchBisBkgBlNoVO(bisBlNoIN);
			
			if (bisBlNoVO == null || bisBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkg_no() }).getMessage());
			}
			
			bkg_no = bisBlNoVO.getBkgNo(); // bkg_no
			bl_no = bisBlNoVO.getBlNo(); // bl_no
			bl_tp_cd = bisBlNoVO.getBlTpCd(); // bl_tp_cd
			por_cd = bisBlNoVO.getPorCd(); // por_cd
			
			hiddenData = event.getHiddenData();
			
			rate = event.getFormLevel() == null || event.getFormLevel().equals("") ? "1" : event.getFormLevel();
			cntr = event.getForm_Cntr() == null || event.getForm_Cntr().equals("") ? "1" : event.getForm_Cntr();
			log.error("**********************************************"+rate);
			corr_no = event.getForm_corr_no();

			rider_yn = command.searchRiderYn(bkg_no, hiddenData, rate, cntr, corr_no);
			houseBl_yn = command.searchHouseBlYn(bkg_no);
			obl_iss_flg = command.searchOblIssFlg(bkg_no);
			
			eventResponse.setETCData("bkg_no", bkg_no);
			eventResponse.setETCData("bl_no", bl_no);
			eventResponse.setETCData("bl_tp_cd", bl_tp_cd);
			eventResponse.setETCData("rider_yn", rider_yn);
			eventResponse.setETCData("houseBl_yn", houseBl_yn);
			eventResponse.setETCData("obl_iss_flg", obl_iss_flg);
			eventResponse.setETCData("por_cd", por_cd);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * bkg별 BDR, C/A 상태 조회.<br>
	 * @param BisBlNoVO vo
	 * @return BisBlNoVO
	 * @throws EventException
	 */
	private BisBlNoVO searchBisBkgBlNoVO (BisBlNoVO vo) throws EventException {
		try {
			return dbDao.searchBisBlNoVO(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	
	/**
	 * (ESM_BKG_0567) C/A 변경 건 별 상세 정보를 조회한다.<br>
	 * @author    Lee NamKyung
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaDetail(Event e) throws EventException {
		EsmBis0567Event event = (EsmBis0567Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLInformationMgtBC command = new BLInformationMgtBCImpl();
		
		try {
			CaDetailVO caDetailVO = command.searchCaDetail(event.getBkgBlNoVO()); 
	
			eventResponse.setRsVoList(caDetailVO.getCaGeneralVOs());
			eventResponse.setRsVoList(caDetailVO.getCaChargeVOs());
			eventResponse.setRsVoList(caDetailVO.getCaCustVOs());
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	
		return eventResponse;
	}
	/**
	 * (ESM_BIS_0001) BIS MonitorList 를 조회 환다.<br>
	 * @author    KIM TAE KYOUNG
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchBisMonitorList(Event e) throws EventException{
		EsmBis0001Event event = (EsmBis0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLInformationMgtBC command = new BLInformationMgtBCImpl();
		
		String fromDt = event.getFromDt();
		String toDt = event.getToDt();
		log.debug("@@@@1" +fromDt);
		log.debug("@@@@2" +toDt);
		
		try{
			List<BisMonitorListVO> list = command.searchBisMonitorList(fromDt, toDt);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * (ESM_BIS_0001) BIS MonitorList 를 조회 한다.<br>
	 * @author    KIM TAE KYOUNG
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchBisManualList(Event e) throws EventException{
		EsmBis0000Event event = (EsmBis0000Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLInformationMgtBC command = new BLInformationMgtBCImpl();
		
		String fromDt = event.getFromDt();
		String toDt = event.getToDt();
		
		try{
			List<BisManualListVO> list = command.searchBisManualList(fromDt, toDt);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
		return eventResponse;
	}
	/**
	 * (ESM_BIS_0001) BIS MonitorList 를 조회 한다.<br>
	 * @author    KIM TAE KYOUNG
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageBisBkgManual(Event e) throws EventException{
		EsmBis0000Event event = (EsmBis0000Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLInformationMgtBC command = new BLInformationMgtBCImpl();
		BisManualListVO bisManualListVO = event.getBisManualListVO();
		try{
			command.manageBisBkgManual(bisManualListVO);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
		return eventResponse;
	}

	/**
	 * (ESM_BIS_0001) BIS MonitorList 를 조회 한다.<br>
	 * @author    KIM TAE KYOUNG
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageBisManual(Event e) throws EventException{
		EsmBis0000Event event = (EsmBis0000Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLInformationMgtBC command = new BLInformationMgtBCImpl();
		
		String fromDt = event.getFromDt();
		String toDt = event.getToDt();
		
		try{
			command.manageBisManual(fromDt, toDt);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
		return eventResponse;
	}
}