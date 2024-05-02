<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0023.jsp
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-21
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 1.9 CHM-200900431 Customer Code 입력가능요청(09.08.24)
* 1.11 2010.09.09 이재위 [SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event"%>

<%
	EsdTrs0023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	SignOnUserAccount account = null;

	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0023Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	//* 1.9 CHM-200900431 Customer Code 입력가능요청(09.08.24)
    String wo_radio = JSPUtil.getNull(request.getParameter("wo_radio"));
    String cust_cd = JSPUtil.getNull(request.getParameter("cust_cnt_cd_seq"));
    
%>
<html>
<head>
<title>Service Provider Select</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%//= JSPUtil.getIBCodeCombo("po_way_type", "", "CD00929", 0, "")%>
<%= JSPUtil.getIBCodeCombo("sp_type", "", "CD00919", 0, "")%>
<%=BizComUtil.getIBCodeCombo("default_curr", "01", "CURR", 1, " |")%>
<%= JSPUtil.getIBCodeCombo("ft_receiving", "", "CD00936", 0, " ")%>
<%= JSPUtil.getIBCodeCombo("ft_delivery", "", "CD00936", 0, " ")%>

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="WY_TP_CD">
<input type="hidden" name="SP_TP_CD">
<input type="hidden" name="VNDR_CD">
<input type="hidden" name="BASIS_DT">
<input type="hidden" name="WTR_RCV_TERM">
<input type="hidden" name="WTR_DE_TERM">
<input type="hidden" name="wo_radio" value='<%=wo_radio%>'>
<input type="hidden" name="CUST_CNT_CD">
<input type="hidden" name="CUST_SEQ">
<input type="hidden" name="cust_cnt_cd_seq" value='<%=cust_cd%>'>
<input type="hidden" name="combo_svc_provider">
<input type="hidden" name="form_cre_usr_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="form_usr_ofc_cd" value="<%=account.getOfc_cd()%>">

<!-- OUTER - POPUP (S)tart -->
<table width="650" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Service Provider Select</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Node / Link ) (S) -->
				    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<table width="100%" id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
				<!-- : ( Node / Link ) (E) -->


			</td></tr>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

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
