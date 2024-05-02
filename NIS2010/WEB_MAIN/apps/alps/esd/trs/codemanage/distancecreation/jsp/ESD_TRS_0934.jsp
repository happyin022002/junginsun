<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0934.jsp
*@FileTitle : Distance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-31 juhyun
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
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.event.EsdTrs0080Event"%>
<%
	EsdTrs0080Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId="";
	String ofc_cd="";

	String from_node="";		//전화면에서 받을 from node
	String from_zip_code="";	//전화면에서 받을 from_zip_code
	String to_node="";			//전화면에서 받을 to node
	String to_zip_code="";		//전화면에서 받을 to_zip_code

	from_node = ((request.getParameter("opner_from_node")==null )?"":request.getParameter("opner_from_node"));
	from_zip_code = ((request.getParameter("opner_from_zip_code")==null )?"":request.getParameter("opner_from_zip_code"));
	to_node = ((request.getParameter("opner_to_node")==null )?"":request.getParameter("opner_to_node"));
	to_zip_code = ((request.getParameter("opner_to_zip_code")==null )?"":request.getParameter("opner_to_zip_code"));

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofc_cd=account.getOfc_cd();

		event = (EsdTrs0080Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		/*
		아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다.
		보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다.
		*/
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Distance Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("dist_meas_ut_cd", "01", "CD00780", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("conv_meas_ut_cd", "01", "CD00780", 0, "")%>

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
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="hid_upd_date" value="<%=today%>">
<input type="hidden" name="hid_cre_date" value="<%=today%>">
<input type="hidden" name="hid_cre_usr_id" value="<%=userId%>">
<input type="hidden" name="hid_upd_usr_id" value="<%=userId%>">

<input type="hidden" name="hid_frm_node" value="<%=from_node%>">
<input type="hidden" name="hid_to_yard" value="<%=to_node%>">

<input type="hidden" name="opner_from_node" value="<%=from_node%>">
<input type="hidden" name="opner_from_zip_code" value="<%=from_zip_code%>">
<input type="hidden" name="opner_to_node" value="<%=to_node%>">
<input type="hidden" name="opner_to_zip_code" value="<%=to_zip_code%>">


<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Distance Creation History</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

						<table class="search" border="0">
							<tr class="h23">
								<td width="12%">From Node</td>
								<td width="20%"><input name="" class="input2" type="text" style="width:width:104;"  value="<%=from_node%>" readonly title="This inputbox cant't write"></td>
								<td width="10%">To Node </td>
								<td width="27%"><input name="" class="input2"  type="text" style="width:width:104;" value="<%=to_node%>" readonly title="This inputbox cant't write"></td>
								<td></td>
							</tr>
							<tr class="h23">
								<td>From Zip Code</td>
								<td ><input name="" class="input2"  type="text" style="width:width:104;" value="<%=from_zip_code%>" readonly title="This inputbox cant't write"></td>
								<td>To Zip Code</td>
								<td ><input name="" class="input2"  type="text" style="width:width:104;" value="<%=to_zip_code%>" readonly title="This inputbox cant't write"></td>
								<td width="20%"></td>
							</tr>
						</table>


					<table class="line_bluedot"><tr><td></td></tr></table>

					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet');</script>
			              </td></tr>
				    </table>
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