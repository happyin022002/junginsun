<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0074.jsp
*@FileTitle : Planned Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.25
*@LastModifier : 이석준
*@LastVersion : 1.0
* =========================================================
* History	 
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI              
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0074Event"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.common.Utils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//	EsmCoa0074Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String pageRows  = "10";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.ESM_COA_0074");
	
    Utils utils = new Utils();

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Planned Expense</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form"  onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- design start -->
<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Planned Expense</td></tr>
		</table>
		<!-- : ( Title ) (E) -->



<!-- TABLE '#D' : ( Button : Main ) (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
     	<tr><td class="btn1_bg">

		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<!-- Repeat Pattern -->
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

			<td class="btn1_line"></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
			<!-- Repeat Pattern -->

		</tr></table>

	</td></tr>
</table>
<!-- TABLE '#D' : ( Button : Main ) (E) -->
<!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search" border="0">
            <tr class="h23">
                    <td width="2%">YYYY-MM</td>
					<td width="14%"><input type="text" class="input1" name="f_cost_yrmon" style="width:70" value="" maxlength="7" onKeyPress="ComKeyOnlyNumber(this);" onBlur="addDash(this, 4);" onFocus="ComClearSeparator(this, 'ym','-');this.select();" ></td>
              </tr>

            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr><td class="bg">
<table class="line_bluedot"><tr><td></td></tr></table>

		<table width="100%">
		<tr><td width="100%">

			<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>

			<!-- : ( Grid ) (E) -->

			</td>
		</tr>
		</table>


	</td>
</tr>
</table>
<!-- TABLE '#D' : ( Search Options ) (E) -->



	</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->



<table class="height_5"><tr><td></td></tr></table>
<!-- design end -->
</form>
</body>
</html>