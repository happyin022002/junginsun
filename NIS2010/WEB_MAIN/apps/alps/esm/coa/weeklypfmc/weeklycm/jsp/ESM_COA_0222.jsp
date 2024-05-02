<%@page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_COA_0222.jsp
*@FileTitle : DEL Credit Ratio by Port-Pair(Backhaul Promotion Target Route)
*Open Issues :
*Change history : 2014.07.29 백형인 최초 생성
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd       = "";

	Logger log = Logger.getLogger("com.hanjin.apps.StdUnitCost.CostStructure");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		//strOfc_cd = "SELCTY";

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Node/Link U/C Adjustment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		sheetObjects[0].SelectCell(2, 3);
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form"  onKeyUp="ComKeyEnter(); ">  <!--  onKeyDown="keyEnter_rslt();"  --> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cost_yrmon">
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


              <!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			       	<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table>
							    </td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table>
							    </td>
							</tr>
						</table>
					</td></tr>
				</table>
              <!-- TABLE '#D' : ( Button : Main ) (E) -->




				<table class="search" cellpadding="0" >
				<tr><td class="bg">
						<!-- : ( Year ) (S) -->
						<table border="0">
						<tr class="h23">
							<td width="15%">YYYY-MM</td>
							<td width="14%"><input type="text" class="input1" style="width:60px" name="f_cost_yrmon" maxlength="6"  dataformat="ym" >&nbsp;
							</td>
			                <td width="160" class='sm'><div id='div_period'></div></td>
						</tr>
						</table>
						<!-- : ( Year ) (E) -->
					</td></tr>
				</table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->

              <table class="height_10"><tr><td></td></tr></table>

              <!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr><td class="bg">			
						<table width="100%" id="mainTable">				
							<tr class="h23">
								<td width="45%" class="title_s">OP ECC</td>
								<td width="5%">&nbsp;</td>
								<td width="45%" class="title_s">DEL ECC</td>
							</tr>
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
								<td>&nbsp;</td>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
					</td></tr>
				</table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>