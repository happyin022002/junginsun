<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0434.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0434Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0434Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String cnt_cd = "";
	String io_bnd_cd = "";
	String rcv_dt = "";
	String rcv_seq = "";

	String rcvMsgTpId= "";
	String vvdCd="";
	String polCd="";
	String podCd="";
	String blNo="";


	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0434Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		cnt_cd = JSPUtil.getNull(request.getParameter("cnt_cd"));
		io_bnd_cd = JSPUtil.getNull(request.getParameter("io_bnd_cd"));
		rcv_dt = JSPUtil.getNull(request.getParameter("rcv_dt"));
		rcv_seq = JSPUtil.getNull(request.getParameter("rcv_seq"));

		rcvMsgTpId= JSPUtil.getNull(request.getParameter("rcvMsgTpId"));
		vvdCd=JSPUtil.getNull(request.getParameter("vvdCd"));
		polCd=JSPUtil.getNull(request.getParameter("polCd"));
		podCd=JSPUtil.getNull(request.getParameter("podCd"));
		blNo=JSPUtil.getNull(request.getParameter("blNo"));


		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){

		with(document.form) {
		<%--
			if (event != null) {

				String cnt_cd = event.getCstmsRcvLogDtlCondVO().getCntCd();
				String io_bnd_cd = event.getCstmsRcvLogDtlCondVO().getIoBndCd();
				String rcv_dt = event.getCstmsRcvLogDtlCondVO().getRcvDt();
				String rcv_seq = event.getCstmsRcvLogDtlCondVO().getRcvSeq();

				String rcvMsgTpId= JSPUtil.getNull(request.getParameter("rcvMsgTpId"));
				String vvdCd=JSPUtil.getNull(request.getParameter("vvdCd"));
				String polCd=JSPUtil.getNull(request.getParameter("polCd"));
				String podCd=JSPUtil.getNull(request.getParameter("podCd"));
				String blNo=JSPUtil.getNull(request.getParameter("blNo"));


		--%>
		<%--
		eval("cnt_cd").value	= "<%=cnt_cd%>";
		eval("io_bnd_cd").value	= "<%=io_bnd_cd%>";
		eval("rcv_dt").value	= "<%=rcv_dt%>";
		eval("rcv_seq").value	= "<%=rcv_seq%>";

		eval("rcv_msg_tp_id").value	= "<%=rcvMsgTpId%>";
		eval("vvd_cd").value	= "<%=vvdCd%>";
		eval("pol_cd").value	= "<%=polCd%>";
		eval("pod_cd").value	= "<%=podCd%>";
		eval("bl_no").value		= "<%=blNo%>";
--%>
		<%
			//}
		%>
		}
		document.title = "Canada ACI: Received File";

		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">




<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Canada ACI: Received File</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
			 --><button type="button" class="btn_accent" name="btn_Excel" id="btn_Excel">Down Excel</button><!--
			 --><button type="button" class="btn_normal" name="btn_Print"  	id="btn_Print">Print</button><!--
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<div class="wrap_result">
		<!-- opus_design_grid(S) -->
<input type="hidden" name="cnt_cd" value="<%= cnt_cd%>">
<input type="hidden" name="io_bnd_cd" value="<%= io_bnd_cd%>">
<input type="hidden" name="rcv_dt" value="<%= rcv_dt%>">
<input type="hidden" name="rcv_seq"value="<%= rcv_seq%>">

<input type="hidden" name="rcv_msg_tp_id" value="<%= rcvMsgTpId%>">
<input type="hidden" name="vvd_cd" value="<%= vvdCd%>">
<input type="hidden" name="pol_cd" value="<%= polCd%>">
<input type="hidden" name="pod_cd" value="<%= podCd%>">
<input type="hidden" name="bl_no" value="<%=blNo%>">

	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	<!-- opus_design_grid(E) -->

</div>
<!-- popup_contens_area(E) -->
</form>
