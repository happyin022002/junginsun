<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1017.jsp
*@FileTitle : S/P Qualitative Evaulation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.event.EsdSpe1017Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdSpe1017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String usr_id		= "";
	String usr_nm		= "";
	String ofc_cd		= "";
	String rhq_ofc_cd	= "";
	
	String eg_id = "";
	String ev_yr = "";
	String ev_mon = "";
	String sp_kpi_id = "";
	String sp_seq = "";
	String sp_nm = "";
	String ev_svc_cate_cd = "";
	String ev_svc_cate_nm = "";
	String score = "";
	
	// Multi Sheet인 경우, Sheet의 Index 정보
	String sheetIdx = StringUtil.xssFilter(request.getParameter("sheetIdx"));
	
	// Sheet에서 팝업 호출시, Target이 되는 Cell의 row/col 정보
	String row = StringUtil.xssFilter(request.getParameter("row"));
	String col = StringUtil.xssFilter(request.getParameter("col"));		
	
	Logger log = Logger.getLogger("com.hanjin.apps.PerformanceManagement.QualitativeEvaluation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	usr_id =	account.getUsr_id();
	   	usr_nm = account.getUsr_nm();
	   	ofc_cd      		= account.getOfc_cd();    
		rhq_ofc_cd      	= account.getRhq_ofc_cd(); 

		event = (EsdSpe1017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		eg_id 		        = StringUtil.xssFilter(request.getParameter("EG_ID"));
		ev_yr 		        = StringUtil.xssFilter(request.getParameter("EV_YR"));
		ev_mon 		        = StringUtil.xssFilter(request.getParameter("EV_MON"));
		sp_kpi_id	        = StringUtil.xssFilter(request.getParameter("SP_KPI_ID"));
		sp_seq 		        = StringUtil.xssFilter(request.getParameter("SP_SEQ"));
		sp_nm 		        = StringUtil.xssFilter(request.getParameter("SP_NM"));		
		ev_svc_cate_cd 		= StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD"));
		ev_svc_cate_nm 		= StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_NM"));
		score 		        = StringUtil.xssFilter(request.getParameter("SCORE"));
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/P Qualitative Evaulation</title>
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
<input type="hidden" name="code_key">
<input type="hidden" name="pagerows">
<input type="hidden" name="sp_seq">
<input type="hidden" name="sheetIdx" value="<%=sheetIdx%>">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="col" value="<%=col%>">
<input type="hidden" name="eg_rhq_cd" value="<%=rhq_ofc_cd%>">
<input type="hidden" name="eg_ofc_cd" value="<%=ofc_cd%>">

<input type="hidden" name="s_sp_kpi_id" value="<%=sp_kpi_id%>">
<input type="hidden" name="s_ev_mon" value="<%=ev_mon%>">

<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		
		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">S/P Qualitative Evaulation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		

			
		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>					
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
		 
		<!--biz page (S)-->
		<table class="search" > 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table class="search" border="0"  style="width: 949;" >
			<tr class="h23">
				<td width="80">EG ID</td>
				<td width="100" align="left">
					<input name="s_eg_id" type="text" style="width:80; text-align:center;" class="input2" readonly="readonly" value="<%=eg_id %>">									
				</td>
				
				<td width="50">Year</td>
				<td width="60" style="padding-left:1;">
					<input type="text" style="width:50; text-align: center" class="input2" name="s_ev_yr" maxlength="4"  fullfill readonly="readonly" value="<%=ev_yr %>">
				</td>
				<td width="710"></td>
				
			</tr>
			</table>
			<table class="search" border="0"  style="width: 949;" >
				<tr class="h23">
					<td width="80">S/P Code</td>
					<td width="290" align="left">
						<input name="s_sp_seq" dataformat ="float" type="text" style="width:50; text-align:right;" class="input2" readonly="readonly" value="<%=sp_seq %>">
						<input name="s_sp_nm" type="text" style="width:200; text-align:left;" class="input2" readonly="readonly" value="<%=sp_nm %>">						
					</td>
					<td width="110">SVC Category</td>
					<td width="130" align="left">
						<input name="s_ev_svc_cate_cd" type="hidden" value="<%=ev_svc_cate_cd %>">
						<input name="s_ev_svc_cate_nm" type="text" style="width:100; text-align:left;" class="input2" readonly="readonly" value="<%=ev_svc_cate_nm %>">
					</td>
					<td width="110">Score</td>
					<td width="60" align="left">
						<input name="s_score" type="text" style="width:50; text-align:right;" class="input2" readonly="readonly" value="<%=score %>">									
					</td>
					<td width="179"></td>				
					
				</tr>
			</table>


	<table class="height_5"><tr><td></td></tr></table>
	<!-- Grid BG Box  (S) -->
	<table class="search" id="mainTable">
	 	<tr><td class="bg" valign="top">
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
<!-- Grid BG Box  (E) -->

		
<!-- 개발자 작업  끝 -->
			</td>
		</tr>
	</table>
</form>

</body>
</html>