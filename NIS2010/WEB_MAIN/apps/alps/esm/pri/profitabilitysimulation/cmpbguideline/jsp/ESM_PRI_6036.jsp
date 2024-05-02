<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6036.jsp
*@FileTitle : CMPB Guideline Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.09 이승준
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

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProfitabilitySimulation.CMPBGuideline");
	
	String svc_scp_cd  = (String)request.getParameter("svc_scp_cd");
	if(svc_scp_cd == null) svc_scp_cd = "";
	
	String cre_ofc_cd  = (String)request.getParameter("cre_ofc_cd");
	if(cre_ofc_cd == null) cre_ofc_cd = "";
	
	String prs_cust_tp_cd  = (String)request.getParameter("prs_cust_tp_cd");
	if(prs_cust_tp_cd == null) prs_cust_tp_cd = "";
	
	String prs_cust_tp_nm  = (String)request.getParameter("prs_cust_tp_nm");
	if(prs_cust_tp_nm == null) prs_cust_tp_nm = "";
	
	String eff_dt  = (String)request.getParameter("eff_dt");
	if(eff_dt == null) eff_dt = "";
	
	String exp_dt  = (String)request.getParameter("exp_dt");
	if(exp_dt == null) exp_dt = "";
	
	String gline_seq  = (String)request.getParameter("gline_seq");
	if(gline_seq == null) gline_seq = "";

	String strUsr_office_cd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_office_cd =	account.getOfc_cd();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>CMPB Guideline Copy</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="cd" value="">
<input type="hidden" name="prs_cust_tp_cd_before" value="<%=prs_cust_tp_cd%>">
<input type="hidden" name="gline_seq" value="<%=gline_seq%>">
<input type="hidden" name="dup_gline_seq" value="">
<input type="hidden" name="max_gline_seq" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp   CMPB Guideline Copy</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- Hidden sheet for Transaction (S) -->
		<!--<script language="javascript">ComSheetObject('sheet0');</script> -->
		<!-- Hidden sheet for Transaction (E) -->
		
		<!-- : ( Search Options ) (S) -->

			<table class="search"> 
       		<tr><td class="bg">
			
			<table class="search"> 
       		<tr><td width="300" valign="top">
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Before</td></tr>
				</table>
				<table class="search_sm2" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="100">SVC Scope</td>
						<td><input type="text" name="svc_scp_cd_before" style="width:75;text-align:center;" value="<%=svc_scp_cd %>" class="input2" readonly></td>
					</tr>
					<tr class="h23">
						<td>Creation Office</td>
						<td><input type="text" name="cre_ofc_cd_hidden" style="width:75;text-align:center;" value="<%=cre_ofc_cd %>" class="input2" readonly></td>
					</tr>
					<tr class="h23">
						<td>Customer Type</td>
						<td><input type="text" name="prs_cust_tp_nm_before" style="width:75;text-align:center;" value="<%=prs_cust_tp_nm %>" class="input2" readonly></td>
					</tr>
					<tr class="h23">
						<td width="">Duration</td>
						<td width="">
						<input type="text" name="eff_dt_before" style="width:75;text-align:center;" value="<%=eff_dt %>" class="input2" readonly>
						~
						<input type="text" name="exp_dt_before" style="width:75;text-align:center;" value="<%=exp_dt %>" class="input2" readonly></td>
					</tr>
				</table>
			</td>
			<td width="50" align="center"><img class="cursor" src="img/btns_add.gif" width="26" height="26" border="0" align="absmiddle"></td>
			<td width="350">	
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">After</td></tr>
				</table>
				<table class="search_sm2" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="100">SVC Scope</td>
						<td><input type="text" name="svc_scp_cd" style="width:75;text-align:center;" value="<%=svc_scp_cd %>" class="input2" readonly></td>
					</tr>
					<tr class="h23">
						<td>Creation Office</td>
						<td><input type="text" name="cre_ofc_cd" style="width:75;text-align:center;" value="<%=strUsr_office_cd %>" class="input2" readonly></td>
					</tr>
					<tr class="h23">
						<td>Customer Type</td>
						<td style="padding-left:2"><script language="javascript">ComComboObject('prs_cust_tp_cd', 1, 75, 0, 1, 0, false);</script></td>
					</tr>
					<tr class="h23">
						<td width="">Duration</td>
						<td width="175"><input name="eff_dt" type="text" style="width:75;text-align:center;"  value="" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required> ~ <input name="exp_dt" type="text" style="width:75;text-align:center;"  value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required></td>
						<td width=""><img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" valign="bottom">
						</td>
					</tr>
				</table>
			</td></tr>
			</table> 
			
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<div id="hiddenSheetLayer" style="display: none">
	<script language="javascript">ComSheetObject('sheet0');</script>
</div>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>