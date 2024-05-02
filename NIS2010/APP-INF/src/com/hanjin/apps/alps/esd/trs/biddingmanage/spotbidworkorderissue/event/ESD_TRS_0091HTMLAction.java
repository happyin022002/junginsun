/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0091HTMLAction.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.29
*@LastModifier : 유선오
*@LastVersion : 1.2
* 2006.11.21 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.10.08 최 선     1.1 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2011.12.29 유선오   1.2 [CHM-201115242] [TRS] W/O preview 화면 관련 Validation 추가, BKG data 참조로직 변경요청
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.event;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.event.SurchargeVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
import com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.vo.SpotBidWoIssueListVO;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderIssueSC로 실행요청<br>
 * - WorkOrderIssueSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 조풍연
 * @see EsdTrs0091Event , ESD_TRS_0091EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0091HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0091HTMLAction 객체를 생성
	 */
	public ESD_TRS_0091HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0091Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		/* 
        ibSheet 사용시 fromRequestGrid를 사용하는데 
        prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
        String prefix = "" ;  
        TRS_TRSP_SVC_ORD trs_trsp_svc_ord = TRS_TRSP_SVC_ORD.fromRequestGrid(request, prefix);
       */ 

		String prefix = "surcharge_" ;
		@SuppressWarnings("unused")
		int codeLength = 0;
		String [] ibflag = request.getParameterValues("ibflag");
		String [] scibflag = request.getParameterValues(prefix+"ibflag");
		
		TrsTrspSvcOrdVO [] trsTrspSvcOrdVOs = (new TrsTrspSvcOrdVO()).fromRequestGrid(request);
		
		if (ibflag != null) codeLength = ibflag.length;
		
		SpotBidWoIssueListVO [] SpotBidWoIssueListVOs = (new SpotBidWoIssueListVO()).fromRequestGrid(request);

		Collection surchargeVOCollection = null;

		if (scibflag != null) surchargeVOCollection = SurchargeVO.fromRequestGrid(request, prefix);
		
		EsdTrs0091Event event = new EsdTrs0091Event();
		event.setTrsTrspSvcOrdVOs(trsTrspSvcOrdVOs);
		event.setSpotBidWoIssueListVOs(SpotBidWoIssueListVOs);

		
		String  localTotAmt 	= request.getParameter("LOCAL_TOT_AMT");
		String  localCurrCd 	= request.getParameter("CURR_CD");
		String  formUsrOfcCd 	= request.getParameter("FORM_USR_OFC_CD");
		String  formCreUsrId 	= request.getParameter("FORM_CRE_USR_ID");
		String  trspSoOfcCtyCd 	= request.getParameter("trsp_so_ofc_cty_cd");
		String  trspSoSeq 	= request.getParameter("trsp_so_seq");
		String  vndrCd 		= request.getParameter("VNDR_CD");
		String  spTpCd 		= request.getParameter("SP_TP_CD");
		String  wyTpCd 		= request.getParameter("WY_TP_CD");
		String  wtrRcvTerm 	= request.getParameter("WTR_RCV_TERM");
		String  wtrDeTerm 	= request.getParameter("WTR_DE_TERM");
		String  custCntCd 	= request.getParameter("CUST_CNT_CD");
		String  custSeq 	= request.getParameter("CUST_SEQ");
		String  basisDt 	= request.getParameter("BASIS_DT");
		
		String woRadio 			   	= request.getParameter("wo_radio");
		String dtRadio 			   	= request.getParameter("dt_radio");
		String fmdate 				= request.getParameter("fmdate");
		String todate 				= request.getParameter("todate");
		String comboSvcProvider		= request.getParameter("combo_svc_provider");
		String woNo 				= request.getParameter("wo_no");
		String trsBndCd 		   	= request.getParameter("trs_bnd_cd");
		String trsCostMdCd     		= request.getParameter("trs_cost_md_cd");
		String trsMdCd 	       		= request.getParameter("trs_md_cd");
		String defalutCurr     		= request.getParameter("defalutCurr");
		String trsSoTpCd       		= request.getParameter("trs_so_tp_cd");
		String fmNod 			    = request.getParameter("search_fm_loc")+request.getParameter("search_fm_yard");
		String viaNod 		     	= request.getParameter("search_via_loc")+request.getParameter("search_via_yard");
		String toNod 			    = request.getParameter("search_to_loc")+request.getParameter("search_to_yard");
		String dorNod 		     	= request.getParameter("search_door_loc")+request.getParameter("search_door_yard");
		String tvvdNo 		     	= request.getParameter("tvvd_no");
		String fvvdNo 		     	= request.getParameter("fvvd_no");
		String fVvdRadio       		= request.getParameter("f_vvd_radio");
		String bkgNo 			    = request.getParameter("bkg_no");
		String blNo 			    = request.getParameter("bl_no");
		String eqRadio 		     	= request.getParameter("eq_radio");
		String eqNo 			    = request.getParameter("eq_no");
		String soNo 			    = request.getParameter("so_no");
		String mtyRfrnNo       		= request.getParameter("mty_rfrn_no");

		String woPrvGrpSeq    	= request.getParameter("wo_prv_grp_seq");
		String woIssNo       	= request.getParameter("wo_iss_no");
		String trspSoNo       	= request.getParameter("trsp_so_no");
		String cntFlg 			= request.getParameter("cnt_flg");
		
		String inv_grs_wgt_meas_ut_cd	= request.getParameter("inv_grs_wgt_meas_ut_cd");
		String wo_grs_wgt_meas_ut_cd	= request.getParameter("wo_grs_wgt_meas_ut_cd");
		
		String spotBidNo			= request.getParameter("spot_bid_no");
 

		
		event.setLocalTotAmt(localTotAmt);
		event.setLocalCurrCd(localCurrCd);
		
		event.setWoPrvGrpSeq(woPrvGrpSeq);
		event.setWoIssNo(woIssNo);		
		event.setWoPrvGrpSeq(woPrvGrpSeq);
		event.setWoIssNo(woIssNo);
		
		event.setFormUsrOfcCd(formUsrOfcCd);
		event.setFormCreUsrId(formCreUsrId);
		event.setTrspSoOfcCtyCd(trspSoOfcCtyCd);
		event.setTrspSoSeq(trspSoSeq);
		event.setVndrCd(vndrCd);
		event.setSpTpCd(spTpCd);
		event.setWyTpCd(wyTpCd);
		event.setWtrRcvTerm(wtrRcvTerm);
		event.setWtrDeTerm(wtrDeTerm);
		event.setCustCntCd(custCntCd);
		event.setCustSeq(custSeq);
		event.setBasisDt(basisDt);
		
		event.setWoRadio(woRadio); 
		event.setDtRadio(dtRadio); 
		event.setFmdate(fmdate);   
		event.setTodate(todate);   
		event.setComboSvcProvider(comboSvcProvider); 
		event.setWoNo(woNo);   
		event.setTrsBndCd(trsBndCd);   
		event.setTrsCostMdCd(trsCostMdCd);  
		event.setTrsMdCd(trsMdCd); 
		event.setDefalutCurr(defalutCurr);  
		event.setTrsSoTpCd(trsSoTpCd);  
		event.setFmNod(fmNod); 
		event.setToNod(toNod); 
		event.setDorNod(dorNod);   
		event.setViaNod(viaNod);   
		event.setTvvdNo(tvvdNo);   
		event.setFvvdNo(fvvdNo);   
		event.setFVvdRadio(fVvdRadio);  
		event.setBkgNo(bkgNo); 
		event.setBlNo(blNo);   
		event.setEqRadio(eqRadio); 
		event.setEqNo(eqNo);   
		event.setSoNo(soNo);   
		event.setMtyRfrnNo(mtyRfrnNo); 
		event.setTrspSoNo(trspSoNo); 
		event.setCntFlg(cntFlg);
		
		event.setInv_grs_wgt_meas_ut_cd(inv_grs_wgt_meas_ut_cd);
		event.setWo_grs_wgt_meas_ut_cd(wo_grs_wgt_meas_ut_cd);
		
		event.setSpotBidNo(spotBidNo);
		
		if (scibflag != null)  event.setSurchargeVOs(surchargeVOCollection);
		
		HashMap param = event.getHashParam();
		Enumeration em = (Enumeration) request.getParameterNames();
		while (em.hasMoreElements()){
			String keyName = (String) em.nextElement();
			if(keyName != null && !keyName.equals(""))
			param.put(keyName, JSPUtil.getParameter(request, keyName, ""));
		}
		event.setHashParam(param);
		
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}