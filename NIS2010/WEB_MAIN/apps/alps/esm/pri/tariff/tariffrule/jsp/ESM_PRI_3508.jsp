<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3508.jsp
*@FileTitle : Tariff Rule Summary Print
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3508Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3508Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strTrfPfxCd		= "";
	String strTrfNo			= "";
	String strAmdtSeq		= "";
	String strTrfRuleNo		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.Tariff.TariffRule");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3508Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		strTrfPfxCd = JSPUtil.getNull(request.getParameter("trf_pfx_cd"));
		strTrfNo    = JSPUtil.getNull(request.getParameter("trf_no"));
		strAmdtSeq  = JSPUtil.getNull(request.getParameter("amdt_seq"));
		strTrfRuleNo  = JSPUtil.getNull(request.getParameter("trf_rule_no"));
				
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
<title>Tariff Rule Summary Print</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="trf_pfx_cd" value="<%=strTrfPfxCd%>">
<input type="hidden" name="trf_no" value="<%=strTrfNo%>">
<input type="hidden" name="amdt_seq" value="<%=strAmdtSeq%>">
<input type="hidden" name="trf_rule_no" value="<%=strTrfRuleNo%>">
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Tariff Rule Summary Print</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->	
	<table class="search"> 
       	<tr><td class="bg">		
				<!-- Grid  (S) -->
					<table width="100%" height="585" class="grid"> 
						<tr class="tr_head">
							<td width="100%"><script language="javascript">comRdObject('report1');</script></td>
						</tr>		
					</table> 
				<!-- Grid (E) -->
				</td></tr>
			</table>
	
	<!--biz page (E)-->
</td></tr>
</table>
<table class="height_5"><tr><td></td></tr></table>
    	<!--Button (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_saveas">Save As</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
			</table>
		</td></tr>
		</table>
		
    <!--Button (E) -->
</td></tr>
</table>
<SCRIPT LANGUAGE=JavaScript FOR=report1 EVENT="ReportFinished();">
	ReportFinished();
</SCRIPT>





<!-- 개발자 작업  끝 -->
</form>
</body>
</html>