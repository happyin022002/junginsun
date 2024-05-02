<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0508.jsp
*@FileTitle  : US AMS: Sent File
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

<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0508Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0508Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	// error from server
	String strErrMsg 			= "";	// error message
	int rowCount	 			= 0;	// count of DB resultSET list

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strCnt_cd    = "";

	String trsmMsgTpId = "";
	String vvd   	   = "";
	String polCd 	   = "";
	String podCd 	   = "";
	String ofcCd 	   = "";
	String usrId 	   = "";
	String sndDt       = "";
	String ofm         = "";

	String cntCd       = "";
	String ioBndCd     = "";
	String hisSeq      = "";
	String stwgSndId   = "";
	String sndDate     = "";


	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CustomsReport");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0508Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		trsmMsgTpId = JSPUtil.getParameter(request, "trsm_msg_tp_id");
		vvd   = JSPUtil.getParameter(request, "vvd2");
		polCd = JSPUtil.getParameter(request, "pol");
		podCd = JSPUtil.getParameter(request, "pod");
		ofcCd = JSPUtil.getParameter(request, "ofc");
		usrId = JSPUtil.getParameter(request, "usr");
		ofm   = JSPUtil.getParameter(request, "ofm");

		cntCd     = JSPUtil.getParameter(request, "cnt_cd");
		ioBndCd   = JSPUtil.getParameter(request, "io_bnd_cd");
		hisSeq    = JSPUtil.getParameter(request, "his_seq");
		stwgSndId = JSPUtil.getParameter(request, "stwg_snd_id");
		sndDt     = JSPUtil.getParameter(request, "snd_date");
		if(!"".equals(sndDt)){
			sndDate  = sndDt.substring(0,4)+"-"+sndDt.substring(4,6)+"-"+sndDt.substring(6,8)+" "+
						sndDt.substring(8,10)+":"+sndDt.substring(10,12)+":"+sndDt.substring(12);
		}

	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<script language="javascript">
	var strCntCd = "<%=strCnt_cd%>";
	var ofmFlg;
	function setupPage(){
		ofmFlg = "<%=ofm %>";
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="download">
<input type="hidden" name="ofm_flg" value="<%=ofm%>">
<input type="hidden" name="trsm_msg_tp_id" value="<%=trsmMsgTpId%>">
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="pod_cd" value="<%=podCd%>">
<input type="hidden" name="ofc_cd" value="<%=ofcCd%>">
<input type="hidden" name="usr_id" value="<%=usrId%>">
<input type="hidden" name="snd_dt" value="<%=sndDt%>">

<input type="hidden" name="cnt_cd" value="<%=cntCd%>">
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>">
<input type="hidden" name="his_seq" value="<%=hisSeq%>">
<input type="hidden" name="snd_date" value="<%=sndDate%>">
<input type="hidden" name="stwg_snd_id" value="<%=stwgSndId%>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>&nbsp;US AMS: Sent File</span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!--Page Title, Historical (E)-->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="layer_popup_contents">
		<div class="opus_design_grid">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('sheet1');</script>
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	</div>
</div>

</form>
<iframe name="download" id="download" style="display:none;width:1px;height:1px;"></iframe>
<!-- opus_design_grid(E) -->
