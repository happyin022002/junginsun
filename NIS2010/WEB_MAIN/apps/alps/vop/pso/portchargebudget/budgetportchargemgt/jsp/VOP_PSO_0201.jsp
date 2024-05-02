<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0201.jsp
*@FileTitle : Expense Plan Per VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.06 김진일
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
<%@ page import="com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0201Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0201Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag  = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strAcctNo		= "";
	String strLaneCd		= "";
	String strGubun			= "";
    String strLocCd			= "";
    String strVslCls		= "";
	String strCreDtFr		= "";
	String strCreDtTo		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0201Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//Main에서 넘어온 Parameter 설정
		strAcctNo		= StringUtil.xssFilter(request.getParameter("acctNo"));
		strLaneCd		= StringUtil.xssFilter(request.getParameter("laneCd"));
		strGubun		= StringUtil.xssFilter(request.getParameter("gubun"));//0:Port 1:lane
		strLocCd		= StringUtil.xssFilter(request.getParameter("locCd"));
		strVslCls		= StringUtil.xssFilter(request.getParameter("vslCls"));
		strCreDtFr		= StringUtil.xssFilter(request.getParameter("creDtFr"));
		strCreDtTo		= StringUtil.xssFilter(request.getParameter("creDtTo"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Expense Plan Per VVD</title>
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

<%-- 
acctNo:<%=strAcctNo %><br />
laneCd:<%=strLaneCd %><br />
gubun:<%=strGubun %><br />
locCd:<%=strLocCd %><br />
vslCls:<%=strVslCls %><br />
creDtFr:<%=strCreDtFr %><br />
creDtTo:<%=strCreDtTo %><br />
--%>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="acct_cd" value="<%=strAcctNo %>" />
<input type="hidden" name="lane_cd" value="<%=strLaneCd %>" />
<input type="hidden" name="cre_dt_fr" value="<%=strCreDtFr %>" />
<input type="hidden" name="cre_dt_to" value="<%=strCreDtTo %>" />
<input type="hidden" name="gubun" value="<%=strGubun %>" />
<input type="hidden" name="vsl_cls" value="<%=strVslCls %>" />
<input type="hidden" name="loc_cd" value="<%=strLocCd %>" />
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Expense Plan Per VVD</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->	
			
			
		</td></tr>
		</table>
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
	

</td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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