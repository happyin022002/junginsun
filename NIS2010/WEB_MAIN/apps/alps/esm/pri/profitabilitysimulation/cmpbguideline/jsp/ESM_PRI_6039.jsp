<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6039.jsp
*@FileTitle : CMPB Guideline- SVC Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.07 이승준
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
<%@ page import="com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event.EsmPri6039Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6039Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	
	String svc_scp_nm  = (String)request.getParameter("svc_scp_nm");
	if(svc_scp_nm == null) svc_scp_nm = "";
	
	String cre_ofc_cd  = (String)request.getParameter("cre_ofc_cd");
	if(cre_ofc_cd == null) cre_ofc_cd = "";
	
	String gline_seq  = (String)request.getParameter("gline_seq");
	if(gline_seq == null) gline_seq = "";
	
	String prs_cust_tp_cd  = (String)request.getParameter("prs_cust_tp_cd");
	if(prs_cust_tp_cd == null) prs_cust_tp_cd = "";
	
	String bse_seq  = (String)request.getParameter("bse_seq");
	if(bse_seq == null) bse_seq = "";
	
	String vslCdList  = (String)request.getParameter("vslCdList");
	if(vslCdList == null) vslCdList = "";
	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri6039Event)request.getAttribute("Event");
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
<title>CMPB Guideline - SVC Lane</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="cre_ofc_cd" value="<%=cre_ofc_cd %>">
<input type="hidden" name="gline_seq" value="<%=gline_seq %>">
<input type="hidden" name="prs_cust_tp_cd" value="<%=prs_cust_tp_cd %>">
<input type="hidden" name="bse_seq" value="<%=bse_seq %>">
<input type="hidden" name="vslCdList" value="<%=vslCdList %>">

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CMPB Guideline - SVC Lane</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="80">SVC Scope</td>
					<td width=""><input type="text" name="svc_scp_cd" style="width:40;text-align:center;" class="input2" value="<%=svc_scp_cd %>">
					&nbsp;<input type="text" name="svc_scp_nm" style="width:360;" class="input2" value="<%=svc_scp_nm %>"></td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
					<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">SVC Lane</td>
					</tr>
				</table>
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
				
			
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

	</td></tr>
		</table>
<!-- : ( Button : pop ) (S) -->


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_OK">OK</td>
					<td class="btn1_right"></td></tr></table></td>
					<td class="btn1_line"></td>
				    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
					</table>
			</td>
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