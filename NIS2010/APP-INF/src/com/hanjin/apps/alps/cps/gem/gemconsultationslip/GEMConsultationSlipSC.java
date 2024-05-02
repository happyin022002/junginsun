/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipSC.java
*@FileTitle : Consultation Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip;

import java.util.List;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.basic.GEMConsultationSlipBC;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.basic.GEMConsultationSlipBCImpl;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event.CpsGem0033Event;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event.CpsGem0034Event;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event.CpsGem0035Event;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event.CpsGem0036Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.SerachConsultaionVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulHdrVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulDtlVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrInfoVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsrHisVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemConsultationVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.basic.GEMPlanningPerformanceBC;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.basic.GEMPlanningPerformanceBCImpl;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.OfficeHierarchyVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.OfficeLevelVO;



/**
 * ALPS-GEMConsultationSlip Business Logic ServiceCommand - ALPS-GEMConsultationSlip 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see GEMConsultationSlipDBDAO
 * @since J2EE 1.6
 */

public class GEMConsultationSlipSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * GEMConsultationSlip system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("GEMConsultationSlipSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * GEMConsultationSlip system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("GEMConsultationSlipSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-GEMConsultationSlip system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("CpsGem0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageConsultaion(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = open0033(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchCurrencyCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchExpenseCodeOffice(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){ //Detail 정보 조회
				eventResponse = searchConsultaionDetail(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = searchGemGWResult(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				eventResponse = searchExpenseCodeOffice(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){ //GW 보내기
				eventResponse = manageGemConsultationSlipGw(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){ //GW Result
				eventResponse = manageGemGwStatus(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){ // HDR 정보 조회
				eventResponse = searchConsultaionHdr(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){ // CSR Cancel
				eventResponse = consultaionCancel(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("CpsGem0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchConsultaionInquiry(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("CpsGem0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchConsultaionInquiryDetail(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("CpsGem0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCsrNoInquiry(e);
			}
		}
		return eventResponse;
	}
	/**
	 * office 별 Currency Code 조회 .<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsGem0033Event event = (CpsGem0033Event)e;
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
		try{
			
			// 리스트 취득
			List<SerachConsultaionVO> list = command.searchCurrencyCode(event.getSerachConsultaionVO());
			eventResponse.setRsVoList(list);
			if (list.size() > 0){
			 eventResponse.setETCData("usd_locl_xch_rt", list.get(0).getUsdLoclXchRt());
			 eventResponse.setETCData("locl_curr_cd", list.get(0).getLoclCurrCd());
			}
			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * CPS_GEM_0033 : Onblur<br>
	 * Expense NAME 과 CODE 조회 이벤트 처리 <br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchExpenseCodeOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsGem0033Event event = (CpsGem0033Event)e;
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
	
		try {
			List<SerachConsultaionVO> list = command.searchExpenseCodeOffice(event.getSerachConsultaionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("total_count", list.size() + "");
			
	        for ( int i = 0 ; i < list.size(); i++ ) {
	            eventResponse.setETCData("subs_expn_nm"+i, list.get(i).getSubsExpnNm());
	            eventResponse.setETCData("subs_expn_cd"+i, list.get(i).getSubsExpnCd());
	        }
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
		
	}
	

	/**
     * 화면 open시 오피스 정보 , 환율정보 , 마감일 취득 .<br>
     * 
     * @category CPS_GEM_0033
     * @category open0033
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse open0033(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());
			eventResponse.setETCData("usr_ofc_cd", ofcCd);
			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";

			// 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd, acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);

			// 실적을 입력할 년월
			String perfClosingDate = command.searchPerfClosingDate(ofcCd);
			eventResponse.setETCData("closingDate", perfClosingDate);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999", new String[] {}).getMessage());
		}
		return eventResponse;
	}


    /**
    * Consultaion 정보를 등록 및 변경한다<br>
    * 
    * @param e Event
    * @return eventResponse EventResponse
    * @exception EventException
    */
    private EventResponse manageConsultaion(Event e) throws EventException {
			
		GeneralEventResponse eventResponse = new GeneralEventResponse();
			
		CpsGem0033Event event = (CpsGem0033Event)e;
			
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
	    String CodeNm = "";		
		try {
			begin();
			GemSubsCsulHdrVO gemSubsCsulHdrVO = event.getGemSubsCsulHdrVO();
			if(event.getGemSubsCsulHdrVO() != null){
				GemSubsCsulHdrVO gemSubsCsulHdr = new GemSubsCsulHdrVO();
				gemSubsCsulHdr = command.manageConsultaion(gemSubsCsulHdrVO , event.getGemSubsCsulDtlVOs(), account);
				eventResponse.setETCData("new_csr_no" ,gemSubsCsulHdr.getSubsCsrNo());
				if(gemSubsCsulHdr.getAproRsltCd().equals("X")){
					CodeNm ="Saved";
				}else {
					CodeNm ="Submitted";
				}
				eventResponse.setETCData("status" ,CodeNm);
			}
		//	eventResponse = (GeneralEventResponse)searchOffhireInvoiceList2(e);
		//	eventResponse.setUserMessage((String) new ErrorHandler("GEM99999",new String[]{}).getUserMessage());
		//	eventResponse.setETCData("new_csr_no" ,gemSubsCsulHdr. );
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
 
    /**
     * GEM_SUBS_CSUL_DTL 테이블 조회 Data 조회<br>
     * 
     * 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchConsultaionDetail(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		CpsGem0033Event event = (CpsGem0033Event)e;
			
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
		try {
			// BC 객체 생성
			GemSubsCsulHdrVO gemSubsCsulHdrVO = event.getGemSubsCsulHdrVO();

			// 리스트 취득
			List<GemSubsCsulDtlVO> list = command.searchConsultaionDetail(gemSubsCsulHdrVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * approval request gwUrl open<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGemConsultationSlipGw(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		CpsGem0033Event event = (CpsGem0033Event)e;
		// BC 객체 생성
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GemSubsCsulHdrVO vo = event.getGemSubsCsulHdrVO();

		try {
			
			//그룹웨어 URL주소
			String gwUrl= "";
			
			//csr no 
			String csrNo = vo.getSubsCsrNo();
			//inv_sub_sys_cd
			String invSubSysCd = "GEM";		
			
			gwUrl = command.sendGwApprovalRequestInfo(csrNo, invSubSysCd, account);
			
			if (gwUrl == null) {
				gwUrl = "";
			}
			
			eventResponse.setETCData("GW_URL", gwUrl);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}

	/**
	 * Gw Status 정보 수정 EAI에서 수신<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGemGwStatus(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		CpsGem0033Event event = (CpsGem0033Event)e;
		GemCsrInfoVO vo = event.getGemsrInfoVO();		
		GemSubsCsrHisVO hisVo = new GemSubsCsrHisVO();
	
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();	
		
		String beComplete = "";

		try {		
			begin();
			// ---------------------------------------------
			// GW 승인여부  : result
			// --------------------------------------------
			// C (CANCLE)    : 창닫기
			// N (REJECT)    : disapprove
			// Y (COMPLETE)  : 최종결재 완료.
			// P (PANDING)   : 기안완료
			// --------------------------------------------			
			String gwResult = JSPUtil.getNull(vo.getResult());
			String csrNo = JSPUtil.getNull(vo.getCsrNo());
			String aproUsrNm = JSPUtil.getNull(vo.getAproUsrNm());
			String aproUsrJbTitNm = JSPUtil.getNull(vo.getAproUsrJbTitNm());	
			String userId = JSPUtil.getNull(vo.getUserId());
			String requestId = JSPUtil.getNull(vo.getRequestId());
			String gwAgmtDocCfmCd = JSPUtil.getNull(vo.getGwAgmtDocCfmCd());
			String resultMsg = JSPUtil.getNull(vo.getResultMsg());
			
			String ofcCd = command.searchOfcCd(csrNo);
			//csrNo로 SubSysCd 값을 가져온다
			String subSysCd = "GEM";
						
			log.error("============================");
			log.error("gwResult : " + gwResult);
			log.error("csrNo : " + csrNo);
			log.error("userId : " + userId);
			log.error("aproUsrNm : " + aproUsrNm);
			log.error("aproUsrJbTitNm : " + aproUsrJbTitNm);
			log.error("ofcCd : " + ofcCd);
			log.error("subSysCd : " + subSysCd);
			log.error("gwAgmtDocCfmCd : " + gwAgmtDocCfmCd);
			log.error("resultMsg : " + resultMsg);
			log.error("============================");
			
			vo.setCsrNo(csrNo);
			vo.setOfcCd(ofcCd);
			vo.setCsrAproTpCd("GW");
			vo.setResult(gwResult);
			vo.setGwAgmtDocCfmCd(gwAgmtDocCfmCd);
					
			// -------------------------------------
			// GW 연동 정보를  history 테이블에 저장한다.
			// -------------------------------------
			log.error("\n 3.START - ConsultationSlipRequestMgtSC.manageGwStatus : saveGWInfo (csr_no:"+JSPUtil.getNull(csrNo)+") \n");
	    	hisVo.setSubsCsrNo(csrNo);
	    	hisVo.setAutoMnlFlg("Y");
	    	hisVo.setIoBndCd("I");
	    	hisVo.setGwCsrRqstId(requestId);
	    	hisVo.setGwAproRsltCd(gwResult);
	    	hisVo.setCreUsrId(userId);					//생성자 ID(승인자 ID)
	    	hisVo.setUpdUsrId(userId);					//업데이트 ID(승인자 ID)
	    	hisVo.setAproUsrId(userId);					//승인자 ID
	    	hisVo.setAproUsrJbTitNm(aproUsrJbTitNm);	//승인자 직책
	    	hisVo.setAproUsrNm(aproUsrNm);				//승인자 이름
	    	hisVo.setAproRmk(resultMsg);				//승인 코멘트
	    	
	    	command.saveGWhisInfo(hisVo);
	    	log.error("\n 3.DONE - ConsultationSlipRequestMgtSC.manageGwStatus : saveGWInfo (csr_no:"+JSPUtil.getNull(csrNo)+") \n");	    
		    
	    	commit();	//EAI연동에 의해 에러가 발생해도 History table 에 저장되는 값은 rollback 되지 않도록 한다.
		    begin();
		    // ---------------------------------------------
		 	// 현재 결재 상태를 조회한다.
		 	// --------------------------------------------
		 	// X (Requesting) : CSR_NO만 생성된 상태
		    // P (PANDING)    : 기안완료
		    // N (REJECT)     : disapproved 상태
		 	// Y (COMPLETE)   : 최종결재 완료 상태	 	
		 	// --------------------------------------------			
	    	String  aproStepFlg = command.searchGemRqstAproStepFlg(csrNo);
	    	log.error("\n aproStepFlg="+aproStepFlg);
	    	
		    if ("P".equals(gwResult)) {		    			
				if(aproStepFlg.equals("X")) {
					//RESULT 값에 따라 DATE 컬럼, RQST_APRO_STEP_FLG = '' 업데이트
					command.updateGemAproGwDt(vo);					
					beComplete = "Success";
				} else if(aproStepFlg.equals("P")){ //기안이 완료된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("N")){ //disapproved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				 } else if(aproStepFlg.equals("Y")){ //approved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				}
			} else if ("N".equals(gwResult)) {				
				if(aproStepFlg.equals("P")) { //기안이 완료된 건에 대해서만 disapproved
					//RESULT 값에 따라 DATE 컬럼 업데이트
					command.updateGemAproGwDt(vo);					
					beComplete = "Success";
					
				} else if(aproStepFlg.equals("X")){ //기안 완료가 되지 않은 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("N")){ //disapproved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("Y")){ //approved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				}
					
			} else if ("Y".equals(gwResult)) {		
				if(aproStepFlg.equals("P")) { //기안이 완료된 건에 대해서만 approved	
					log.error("\n <<<<<<<<<<<<<  ConsultationSlipRequestMgtSC gwResult = Y  IF (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>>>");	  
					//RESULT 값에 따라 DATE 컬럼, GW_AGMT_DOC_CFM_CD 업데이트
					command.updateGemAproGwDt(vo);
					log.error("\n <<<<<<<<<<<<<  ConsultationSlipRequestMgtSC aproUtil.updateAproGwDt() DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>>>");	
					beComplete = "Success";	
					
				} else if(aproStepFlg.equals("X")){ //기안 롼료가 되지 않은 건입니다.
					log.error("\n ConsultationSlipRequestMgtSC.manageGwStatus() : "+JSPUtil.getNull(csrNo)+" ["+aproStepFlg+"] "+new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage()+"\n");
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("N")){ //disapproved 된 건입니다.
					log.error("\n ConsultationSlipRequestMgtSC.manageGwStatus() : "+JSPUtil.getNull(csrNo)+" ["+aproStepFlg+"] "+new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage()+"\n");
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("Y")){ //approved 된 건입니다.
					log.error("\n ConsultationSlipRequestMgtSC.manageGwStatus() : "+JSPUtil.getNull(csrNo)+" ["+aproStepFlg+"] "+new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage()+"\n");
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				}
			}

			commit(); 
			eventResponse.setUserMessage(beComplete);
			
		
		} catch(EventException ex) {
			rollback();
			log.error("\n manageGwStatus() - EventException err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("\n manageGwStatus() - Exception err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
		return eventResponse;
	}

	 /**
     * GEM_SUBS_CSUL_DTL 테이블 조회 Data 조회<br>
     * 
     * 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchConsultaionInquiry(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		CpsGem0034Event event = (CpsGem0034Event)e;
			
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
		try {
			// BC 객체 생성
			SerachConsultaionVO serachConsultaionVO = event.getSerachConsultaionVO();

			// 리스트 취득
			List<GemConsultationVO> list = command.searchConsultaionInquiry(serachConsultaionVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * approval request gwUrl open<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGemGWResult(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		CpsGem0033Event event = (CpsGem0033Event)e;
		// BC 객체 생성
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GemSubsCsulHdrVO vo = event.getGemSubsCsulHdrVO();

		try {
			if(vo.getSubsCsrNo() != null || vo.getSubsCsrNo() !=""){
			// 리스트 취득
			String result = command.searchGemRqstAproStepFlg(vo.getSubsCsrNo());
			eventResponse.setETCData("GW_Result", result);
			}
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}
	

	 /**
     * CSR No  Data pop-up 화면 조회<br>
     * 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrNoInquiry(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		CpsGem0036Event event = (CpsGem0036Event)e;
			
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
		try {
			// BC 객체 생성
			SerachConsultaionVO serachConsultaionVO = event.getSerachConsultaionVO();

			// 리스트 취득
			List<GemSubsCsulHdrVO> list = command.searchCsrNoInquiry(serachConsultaionVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}

	 /**
     * GEM_SUBS_CSUL_DTL 테이블 조회 Data 조회<br>
     * 
     * 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchConsultaionHdr(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		CpsGem0033Event event = (CpsGem0033Event)e;
			
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
		try {
			// BC 객체 생성
			SerachConsultaionVO serachConsultaionVO = event.getSerachConsultaionVO();

			// 리스트 취득
			List<GemSubsCsulHdrVO> list = command.searchConsultaionHdr(serachConsultaionVO);
			eventResponse.setETCData("inp_dt", list.get(0).getInpDt());
			eventResponse.setETCData("inv_dt", list.get(0).getInvDt());
			eventResponse.setETCData("apro_dt",list.get(0).getAproDt());
			eventResponse.setETCData("expn_div_cd" , list.get(0).getExpnDivCd());
			eventResponse.setETCData("apro_rslt_cd", list.get(0).getAproRsltCd());
			eventResponse.setETCData("inv_curr_cd" , list.get(0).getInvCurrCd());
			eventResponse.setETCData("inv_locl_ttl_amt" , list.get(0).getInvLoclTtlAmt());
			eventResponse.setETCData("expn_div_cd" , list.get(0).getExpnDivCd());
			eventResponse.setETCData("inv_usd_ttl_amt", list.get(0).getInvUsdTtlAmt());
			eventResponse.setETCData("pay_vndr_nm", list.get(0).getPayVndrNm());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}

	 /**
     * inquiry 상세정보 Data 조회<br>
     * 
     * 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchConsultaionInquiryDetail(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		CpsGem0035Event event = (CpsGem0035Event)e;
			
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
		try {
			// BC 객체 생성
			SerachConsultaionVO serachConsultaionVO = event.getSerachConsultaionVO();

			// 리스트 취득
			List<GemConsultationVO> list = command.searchConsultaionInquiryDetail(serachConsultaionVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}

    /**
    * Consultaion 정보를 Cancel (Delt_flg='Y')로 변경한다<br>
    * 
    * @param e Event
    * @return eventResponse EventResponse
    * @exception EventException
    */
    private EventResponse consultaionCancel(Event e) throws EventException {
			
		GeneralEventResponse eventResponse = new GeneralEventResponse();
			
		CpsGem0033Event event = (CpsGem0033Event)e;
			
		GEMConsultationSlipBC command = new GEMConsultationSlipBCImpl();
		try {
			begin();
			// BC 객체 생성
		  	SerachConsultaionVO serachConsultaionVO = event.getSerachConsultaionVO();

			if(event.getSerachConsultaionVO() != null){
		 	 command.consultaionCancel(event.getSerachConsultaionVO().getSubsCsrNo() , account);
				
			}
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
}