<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0024.jsp
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-12-06 poong_yeon
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event"%>


<%
	EsdTrs0024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	SignOnUserAccount account = null;
	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0024Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);
	String trsp_wo_ofc_cty_cd = JSPUtil.getNull(request.getParameter("trsp_wo_ofc_cty_cd"));
	String wo_iss_knt = JSPUtil.getNull(request.getParameter("wo_iss_knt"));
	String wo_vndr_seq = JSPUtil.getNull(request.getParameter("wo_vndr_seq"));
	String wo_vndr_nm = JSPUtil.getNull(request.getParameter("wo_vndr_nm"));
	String wo_iss_sts_cd = JSPUtil.getNull(request.getParameter("wo_iss_sts_cd"));

	String trsp_crr_mod_cd = JSPUtil.getNull(request.getParameter("trsp_crr_mod_cd"));
	String trsp_cost_dtl_mod_cd = JSPUtil.getNull(request.getParameter("trsp_cost_dtl_mod_cd"));
	String ets_sts_flg = JSPUtil.getNull(request.getParameter("ets_sts_flg"));
%>
<html>
<head>
<title>W/O Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	var beforeOneMonth = '<%=beforeOneMonth%>';
	var today = '<%=today%>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="trsp_wo_ofc_cty_cd" value="<%=trsp_wo_ofc_cty_cd%>">
<input type="hidden" name="edi_trsp_wo_ofc_cty_cd">
<input type="hidden" name="edi_trsp_wo_seq">
<input type="hidden" name="edi_loc">
<input type="hidden" name="trsp_crr_mod_cd" value='<%=trsp_crr_mod_cd%>'>
<input type="hidden" name="trsp_cost_dtl_mod_cd" value='<%=trsp_cost_dtl_mod_cd%>'>
<input type="hidden" name="ets_sts_flg" value='<%=ets_sts_flg%>'>
<input type="hidden" name="wo_edi_use_flg" value="EDI">
<input type="hidden" name="edi_wo_iss_sts_cd" value='<%=wo_iss_sts_cd%>'>
<input type="hidden" name="edi_wo_iss_knt" value="<%=wo_iss_knt%>">
<input type="hidden" name="edi_vndr_seq" value="<%=wo_vndr_seq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; EDI Status Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0">
						<tr class="h23">
							<td width="13%">Work Order No.</td>
							<td width="20%">
								<input name="wo_no" type="text" style="width:120;" value="<%=trsp_wo_ofc_cty_cd%>" readonly class="input2"></td>
							<td width="14%">Service Provider</td>
							<td><input name="vndr_seq" type="text" style="width:100;" value="<%=wo_vndr_seq%>" readonly class="input2">
								<input name="vndr_nm" type="text" style="width:290;" value="<%=wo_vndr_nm%>" readonly class="input2"></td>
						</tr>
					</table></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">

					<!-- : ( Grid ) (S) -->

				<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( From Location ) (E) -->


					<!-- : ( Grid ) (E) -->
				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" name="button_r">
					<tr><td class="btn1_left" name="btn1_left_r" id="btn1_left_r"></td><td class="btn1" name="btng_edisend" id="btng_edisend">EDI Send</td><td class="btn1_right" name="btn1_right_r" id="btn1_right_r"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->



</form>
</body>
</html>
