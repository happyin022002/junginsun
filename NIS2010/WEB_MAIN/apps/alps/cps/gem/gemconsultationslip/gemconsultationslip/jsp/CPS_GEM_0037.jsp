<%/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CPS_GEM_0037.jsp
*@FileTitle : Consultation Slip -Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : HongSeongPil
*@LastVersion : 1.0
*2016.06.10 HongSeongPil
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event.CpsGem0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsGem0037Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String gen_expn_rqst_tp_cd = "";
	String period_stdt = "";
	String period_eddt = "";
	String csr_no = "";
	String ofc_lvl1 = "";
	String ofc_lvl2 = "";
	String ofc_lvl3 = "";
	String subs_expn_nm = "";
	String expn_div_cd = "";
	String status = "";
	
	
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String cnt_cd  = "";
	Logger log = Logger.getLogger("com.hanjin.apps.GEMConsultationSlip.GEMConsultationSlip");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		gen_expn_rqst_tp_cd = JSPUtil.getParameter(request, "gen_expn_rqst_tp_cd".trim(), "");
		period_stdt = JSPUtil.getParameter(request, "period_stdt".trim(), "");
		period_eddt = JSPUtil.getParameter(request, "period_eddt".trim(), "");
		csr_no = JSPUtil.getParameter(request, "csr_no".trim(), "");
		ofc_lvl1 = JSPUtil.getParameter(request, "ofc_lvl1".trim(), "");
		ofc_lvl2 = JSPUtil.getParameter(request, "ofc_lvl2".trim(), "");
		ofc_lvl3 = JSPUtil.getParameter(request, "ofc_lvl3".trim(), "");
		subs_expn_nm = JSPUtil.getParameter(request, "subs_expn_nm".trim(), "");
		expn_div_cd = JSPUtil.getParameter(request, "expn_div_cd".trim(), "");
		status = JSPUtil.getParameter(request, "status".trim(), "");

		event = (CpsGem0037Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Consultation Slip -Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="rd.js"></script>
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	var cnt_cd = "<%=cnt_cd%>";
	var p_gen_expn_rqst_tp_cd 	= "<%=gen_expn_rqst_tp_cd%>";
	var p_period_stdt 			= "<%=period_stdt%>";
	var p_period_eddt 			= "<%=period_eddt%>";
	var p_csr_no 				= "<%=csr_no%>";
	var p_ofc_lvl1 				= "<%=ofc_lvl1%>";
	var p_ofc_lvl2 				= "<%=ofc_lvl2%>";
	var p_ofc_lvl3 				= "<%=ofc_lvl3%>";
	var p_subs_expn_nm 			= "<%=subs_expn_nm%>";
	var p_expn_div_cd 			= "<%=expn_div_cd%>";
	var p_status 				= "<%=status%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();		
	}
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td class="title"><img src="img/ico_t1.gif" width="20" height="12">Consultation Slip Preview</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search" >
       	<tr><td class="bg_b1">
			<!-- : ( Seq. ) (S) -->
			<table border="1" style="width:937;" height="545" class="grid" >
			<tr><td><script language='javascript'>comRdObject('csrPrevie');</script></td></tr>
			</table>

				<!-- : ( Seq. ) (E) -->
			<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="sbutton">
		       	<tr><td class="align">
				    <table class="sbutton">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_print">Print</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>	
					</tr>
					</table>
				</td></tr>
			</table>
		    <!-- : ( Button : Sub ) (E) -->
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->



<table class="height_10"><tr><td></td></tr></table>

</td></tr>
</table>


</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<input type="hidden" name="test" style="width:800;">

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btng_close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>