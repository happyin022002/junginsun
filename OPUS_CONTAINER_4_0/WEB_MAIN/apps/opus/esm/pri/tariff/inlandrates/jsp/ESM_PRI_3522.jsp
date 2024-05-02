<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3522.jsp
*@FileTitle  : Inland Rates Excel Imports
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3522Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3522Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String trfPfxCd 		= "";
	String trfNo 			= "";
	String trfInlndSeq 		= "";
	String amdtSeq 			= "";
	String updDt			= "";
	String dtlUpdDt			= "";
	
	String[] inlndRtTermCd = null;		  	//Term
	String[] prcRrspModCd = null;		  	//Trans. Mode
	String[] inlndRtLmtWgtUtCd = null;		//Weght Unit
	String[] prcCgoTpCd = null;		    	//Type
	String[] currCd = null;		    		//Currency
	
	Logger log = Logger.getLogger("com.clt.apps.Tariff.InlandRates");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3522Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		inlndRtTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("INLND_RT_TERM_CD"), false);
		prcRrspModCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_INLND_RT_TRSP_MOD_CD"), false);
		inlndRtLmtWgtUtCd	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("INLND_RT_LMT_WGT_UT_CD"));
		prcCgoTpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_CGO_TP_CD"), false);
		currCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);
		    
		trfPfxCd 		= JSPUtil.getNull(event.getPriTrfInlndParamVO().getTrfPfxCd());
		trfNo 			= JSPUtil.getNull(event.getPriTrfInlndParamVO().getTrfNo());
		trfInlndSeq		= JSPUtil.getNull(event.getPriTrfInlndParamVO().getTrfInlndSeq());
		amdtSeq			= JSPUtil.getNull(event.getPriTrfInlndParamVO().getAmdtSeq());
		updDt			= JSPUtil.getNull(event.getPriTrfInlndParamVO().getUpdDt());
		dtlUpdDt		= JSPUtil.getNull(event.getPriTrfInlndParamVO().getEtc2());
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	var inlndRtTermCdComboValue = " |<%=inlndRtTermCd[0]%>";
	var inlndRtTermCdComboText = " |<%=inlndRtTermCd[1]%>";
	
	var prcRrspModCdComboValue = " |<%=prcRrspModCd[0]%>";
	var prcRrspModCdComboText = " |<%=prcRrspModCd[1]%>";
	
	var inlndRtLmtWgtUtCdComboValue = " |<%=inlndRtLmtWgtUtCd[0]%>";
	var inlndRtLmtWgtUtCdComboText = " |<%=inlndRtLmtWgtUtCd[1]%>";
	
	var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";

	var currCdComboValue = " |<%=currCd[0]%>";
	var currCdComboText = " |<%=currCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd%>">
<input type="hidden" name="trf_no" value="<%=trfNo%>">
<input type="hidden" name="trf_inlnd_seq" value="<%=trfInlndSeq%>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>">
<input type="hidden" name="upd_dt" value="<%=updDt %>">
<input type="hidden" name="dtl_upd_dt" value="<%=dtlUpdDt %>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Inland Rate Excel Imports</span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Open File</button>
		<button type="button" class="btn_normal" name="btn_check" id="btn_check">Check</button>
		<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	
	<!-- opus_grid_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button>
		<button type="button" class="btn_normal" name="btn_rowdelete" id="btn_rowdelete">Row Delete</button>
	</div>
	<!-- opus_grid_btn(E) -->

	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->
</div>

</form>