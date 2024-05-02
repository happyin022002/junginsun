<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_918.jsp 
*@FileTitle : Register Throughput Cost Code
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-19
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-19 jongbaemoon
* 1.0 최초 생성

*@FileName :  ESD_TES_9180.jsp ( 2009-09-10 )
*@ALPSModifyDate : 2009.09.10
*@ALPSModifier : yOng hO lEE
*@ALPSVersion : 1.0
* 2009.09.10 yOng hO lEE
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9180Event"%>
<%
	EsdTes9180Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수	
	
	String cost_cd		=  JSPUtil.getParameter(request, "cost_cd    		".trim(), "");
	String agmt_no		=  JSPUtil.getParameter(request, "agmt_no    		".trim(), "");
	String agmt_ver_no	=  JSPUtil.getParameter(request, "agmt_ver_no		".trim(), "");
	
	String agmt_ofc_cty_cd	= agmt_no.substring(0,3);
	String agmt_seq		= agmt_no.substring(3,8);
	agmt_ver_no			= agmt_ver_no.substring(0,2)+agmt_ver_no.substring(3,5);
	
	String		userId	= "";

	try {
	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();

		event = (EsdTes9180Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Register Throughput Cost Code</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage	= "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		comboObjects[0].Code = "<%=cost_cd%>";	
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<input type="hidden" name="tml_agmt_ofc_cty_cd" value="<%=agmt_ofc_cty_cd%>">
<input type="hidden" name="tml_agmt_seq" value="<%=agmt_seq%>">
<input type="hidden" name="tml_agmt_ver_no" value="<%=agmt_ver_no%>">
<input type="hidden" name="lgs_cost_cd" value="<%=cost_cd%>">
<input type="hidden" name="cre_usr_id" value="<%=userId%>">
<input type="hidden" name="loop_value">


<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="380" border="0">
		<tr>
			<td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Register Throughput Cost Code</td>
		</tr>
		</table>
		<!-- : ( Title ) (E) -->



		<!-- TABLE '#D' : ( Button : Main ) (S) -->
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) --!>
		


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr>
			<td class="bg_a">
				<table class="search" border="0" style="width:362;">
					<tr class="h23">
						<td width="85">Cost Code </td>
						<td width="277"><script language="javascript">ComComboObject('lgs_cost_cd_c',1, 90 ,0)</script></td>
					</tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_5"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
		<table class="search"> 
		<tr><td class="bg_a">

			<!-- : ( Grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                            <script language="javascript">ComSheetObject('t1sheet1');</script>
                        </td></tr>
                    </table>
				<!-- : ( Grid ) (E) -->
				</td>
		</tr>
		</table>





</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table> 


</form>
</body>
</html>