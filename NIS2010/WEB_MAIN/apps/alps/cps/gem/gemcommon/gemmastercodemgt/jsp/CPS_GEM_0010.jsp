<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0010.jsp
	 *@FileTitle : Expense Code Inquiry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.04.21
	 *@LastModifier : 최정미
	 *@LastVersion : 1.0
	 * 2009.04.17 최정미
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0010Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0010Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	String strPopup = request.getParameter("popup") == null ? "N" : request.getParameter("popup");
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (CpsGem0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Expense Code Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="sch_expense_from">
<input type="hidden" name="sch_expense_to">
<input type="hidden" name="sch_expense_group">


		<!--Page Title, Historical (S)-->
		<%if("Y".equals(strPopup)) { %>
        <table width="100%" class="popup" cellpadding="10" border="0"> 
        <tr><td class="top"></td></tr>
        		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">  Expense Code Inquiry</td></tr>
		</table>
		<%} else { %>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
         <tr>
        <td valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<%} %>
		<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 100%">
					<tr class="h23">
						<td width="40%">
						<table class="search_sm2" border="0" style="width: 93%">
							<tr class="h23">
								<td width="50%">
									<input type="radio" value="Y" class="trans" name="sch_expense_gbn" id="sch_expense_gbn1" checked onclick="setExpnAcctSearch(this);">Expense&nbsp;
									<input type="radio" value="N" class="trans" name="sch_expense_gbn" id="sch_expense_gbn2" onclick="setExpnAcctSearch(this);">Account&nbsp;
								</td>
								<td width="43%">
									<script language="javascript">ComComboObject("combo1", 2, 70, 0, 0, 0, true);</script>&nbsp;~&nbsp;
									<script language="javascript">ComComboObject("combo2", 2, 70, 0, 0, 0, true);</script>
								</td>
							</tr>
						</table>
						</td>
						<td width="28%">
						<table class="search_sm2" border="0" style="width: 93%">
							<tr class="h23">
								<td width="40%">Expense DIV</td>
								<td class="stm">
									<input type="radio" value="Y" class="trans" name="sch_expense_div" checked>Sales&nbsp;
									<input type="radio" value="N" class="trans" name="sch_expense_div">General
								</td>
							</tr>
						</table>
						</td>
						<td width="22%">
						<table class="search_sm2" border="0" style="width: 93%">
							<tr class="h23">
								<td width="40%">Salary DIV</td>
								<td class="stm">
									<input type="radio" value="" class="trans" name="sch_slay_flg" checked>All&nbsp;
									<input type="radio" value="N" class="trans" name="sch_slay_flg">No&nbsp;
									<input type="radio" value="Y" class="trans" name="sch_slay_flg">Yes
								</td>
							</tr>
						</table>
						</td>
						<td width="10%">
						<table class="search_sm2" border="0" style="width: 93%">
							<tr class="h23">
								<td>
									<input type="radio" value="K" class="trans" name="sch_lang" onclick="isLangCheck(this);" checked>KOR&nbsp;
									<input type="radio" value="E" class="trans" name="sch_lang" onclick="isLangCheck(this);">ENG
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr><td height="3" colspan="4"></td></tr>
					<tr class="h23">
						<td width="40%">
						<table class="search_sm2" border="0" style="width: 93%">
							<tr class="h23">
								<td width="30%">&nbsp;&nbsp;Expense Group</td>
								<td width="20%">
									<script language="javascript">ComComboObject("combo3", 2, 70, 0, 0, 0, true);</script>
								</td>
								<td width="10%">TIC</td>
								<td width="33%" align="left">
									<select style="width: 75;" class="input" name="sch_tic_cd" onchange="comFocusChange('document.form.sch_slay_flg[0]');focusOut();"></select>
								</td>
							</tr>
						</table>
						</td>
						<td width="28%">
						<table class="search_sm2" border="0" style="width: 93%">
							<tr class="h23">
								<td width="40%">Sales DIV</td>
								<td class="stm">
									<input type="radio" value="" class="trans" name="sch_sls_div" checked>All&nbsp;
									<input type="radio" value="C" class="trans" name="sch_sls_div">Com&nbsp;
									<input type="radio" value="N" class="trans" name="sch_sls_div">No&nbsp;
									<input type="radio" value="Y" class="trans" name="sch_sls_div">Yes
								</td>
							</tr>
						</table>
						</td>
						<td width="35%" colspan="2"></td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
				</table>
				<!-- Grid (E) -->
				</td>
			</tr>
		</table>
		
		<!-- Grid BG Box  (S) --> 
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<%if("Y".equals(strPopup)) { %>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<%} %>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --> 
		<!--biz page (E)-->
		</td>
	</tr>
	<%if("Y".equals(strPopup)) { %>
	<tr><td height="35"></td></tr>
	<%} %>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>