<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0207.jsp
*@FileTitle : Interface to ERP (Detail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.07 김진일
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
<%@ page import="com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0207Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0207Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String sdt = "";
	String edt = "";
	String xxx = "";
	String acctCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0207Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		sdt 	= StringUtil.xssFilter(request.getParameter("sdt"));
		edt 	= StringUtil.xssFilter(request.getParameter("edt"));
		acctCd 	= StringUtil.xssFilter(request.getParameter("acctCd"));
		xxx 	= StringUtil.xssFilter(request.getParameter("xxx"));

		sdt = xxx;
		edt = xxx;
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Interface to ERP (Detail)</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Interface to ERP (Detail)</td></tr>
		</table>
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="260">
						<table class="search_sm" border="0" style="width:230;"> 
							<tr class="h23">
								<td><input name="match_flag" type="radio" value="all" class="trans" checked>All&nbsp;&nbsp;&nbsp;&nbsp;<input name="match_flag" type="radio" value="match" class="trans">Match&nbsp;&nbsp;&nbsp;&nbsp;<input name="match_flag" type="radio" value="unmatch" class="trans">Mismatch</td>
							</tr>
						</table>
					</td>
					<td width="40">Month</td>
					<td width="200"><input readonly name="sdt" type="text" style="width:60;text-align:center;" class="input2" value="<%=sdt %>">&nbsp;~&nbsp;<input readonly name="edt" type="text" style="width:60;text-align:center;" class="input2" value="<%=edt %>"></td>
					<td width="90">Account Code</td>
					<td width=""><input readonly name="acct_cd" type="text" style="width:55;text-align:center;" class="input2" value="<%=acctCd %>"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
				
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
				
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->

<table class="height_5"><tr><td></td></tr></table>
	</td></tr>
</table>	
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				 -->
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		    <td class="btn1_line"></td>
		    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>	
			</tr>
		</table></td>	
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>