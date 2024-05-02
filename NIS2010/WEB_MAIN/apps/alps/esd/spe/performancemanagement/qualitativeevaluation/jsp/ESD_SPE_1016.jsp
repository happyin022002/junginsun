<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1016.jsp
*@FileTitle : S/P Qualitative Evaulation Inquiry
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
<%@ page import="com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.event.EsdSpe1016Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdSpe1016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String eg_rhq_cd  = "";
	String eg_ofc_cd  = "";
	
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

		event = (EsdSpe1016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		

		eg_id 		        = StringUtil.xssFilter(request.getParameter("EG_ID"))         !=null&&!StringUtil.xssFilter(request.getParameter("EG_ID")).equals("")         ?StringUtil.xssFilter(request.getParameter("EG_ID")):"";
		eg_rhq_cd           = StringUtil.xssFilter(request.getParameter("EG_RHQ_CD"))     !=null&&!StringUtil.xssFilter(request.getParameter("EG_RHQ_CD")).equals("")     ?StringUtil.xssFilter(request.getParameter("EG_RHQ_CD")):"";
		eg_ofc_cd	        = StringUtil.xssFilter(request.getParameter("EG_OFC_CD"))     !=null&&!StringUtil.xssFilter(request.getParameter("EG_OFC_CD")).equals("")     ?StringUtil.xssFilter(request.getParameter("EG_OFC_CD")):"";		
		ev_yr 		        = StringUtil.xssFilter(request.getParameter("EV_YR"))         !=null&&!StringUtil.xssFilter(request.getParameter("EV_YR")).equals("")         ?StringUtil.xssFilter(request.getParameter("EV_YR")):"";
		ev_mon 		        = StringUtil.xssFilter(request.getParameter("EV_MON"))        !=null&&!StringUtil.xssFilter(request.getParameter("EV_MON")).equals("")        ?StringUtil.xssFilter(request.getParameter("EV_MON")):""; 
		sp_kpi_id	        = StringUtil.xssFilter(request.getParameter("SP_KPI_ID"))     !=null&&!StringUtil.xssFilter(request.getParameter("SP_KPI_ID")).equals("")     ?StringUtil.xssFilter(request.getParameter("SP_KPI_ID")):"";
		sp_seq 		        = StringUtil.xssFilter(request.getParameter("SP_SEQ"))        !=null&&!StringUtil.xssFilter(request.getParameter("SP_SEQ")).equals("")        ?StringUtil.xssFilter(request.getParameter("SP_SEQ")):"";
		sp_nm 		        = StringUtil.xssFilter(request.getParameter("SP_NM"))         !=null&&!StringUtil.xssFilter(request.getParameter("SP_NM")).equals("")         ?StringUtil.xssFilter(request.getParameter("SP_NM")):"";		
		ev_svc_cate_cd 		= StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD"))!=null&&!StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD")).equals("")?StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD")):"";
		ev_svc_cate_nm 		= StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_NM"))!=null&&!StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_NM")).equals("")?StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_NM")):""; 
		score 		        = StringUtil.xssFilter(request.getParameter("SCORE"))         !=null&&!StringUtil.xssFilter(request.getParameter("SCORE")).equals("")         ?StringUtil.xssFilter(request.getParameter("SCORE")):"";
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Evaluation Group Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(year);
	}
</script>
</head>

<body onLoad="setupPage('<%=DateTime.getYear()%>');">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="code_key">
<input type="hidden" name="pagerows">
<input type="hidden" name="tml_cd">
<input type="hidden" name="sp_seq">
<input type="hidden" name="vndr_cd">
<input type="hidden" name="ev_svc_cate_cd">
<input type="hidden" name="eg_id">
<input type="hidden" name="search_type" value="A">
<input type="hidden" name="eg_rhq_cd"   value="<%=rhq_ofc_cd%>">
<input type="hidden" name="eg_ofc_cd"   value="<%=ofc_cd%>">

<input type="hidden" name="sp_seq_1019"         value="<%=sp_seq%>">
<input type="hidden" name="sp_nm_1019"          value="<%=sp_nm%>">
<input type="hidden" name="ev_yr_1019"          value="<%=ev_yr%>">
<input type="hidden" name="eg_rhq_cd_1019"      value="<%=eg_rhq_cd%>">
<input type="hidden" name="eg_ofc_cd_1019"      value="<%=eg_ofc_cd%>">
<input type="hidden" name="ev_svc_cate_cd_1019" value="<%=ev_svc_cate_cd%>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

			
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
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
			<table class="search" border="0"  style="width: 979;" >
				<tr class="h23">
					<td width="70">Year</td>
					<td width="130" style="padding-left:1;">
						<input type="text" style="width:70; text-align: center" class="input1" name="s_ev_yr" maxlength="4" required fullfill minnum="1900" maxnum="2050" caption="Year">
						<img class="cursor" src="img/btns_calendar.gif" width="20" height="20" border="0" align="absmiddle" name="btn_audit_month">
					</td>
					
					<td width="50">Month</td>
					<td width="50" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_ev_mon',1,50,0,0,0);</script>
					</td>
					
					<td width="100"></td>		
					<td width="104">Evaluator Name</td>		
				    <td width="200">
						<input name="s_ev_name" type="text" value="<%=usr_nm%>" style="width:198; text-align:left;" class="input2" readonly="readonly">
					</td>							
	
					<td width="275"></td>
					
				</tr>
			</table>	
			<!-- biz_1  (S) -->
						
			<table class="search" border="0"  style="width: 979;" >
				<tr class="h23">
					<td width="72">Level 1</td>
					<td width="94" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_eg_rhq_cd',1,94,0,0,0);</script>
					</td>
						
					<td width="34"></td>
					
					<td width="50">Level 2</td>
					<td width="100" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_eg_ofc_cd',1,100,0,0,0);</script>
					</td>
					<td width="50"></td>
					
					<td width="105">Level 3</td>
					<td width="160" style="padding-left:1;">
						<script language="javascript">ComComboObject('s_ev_svc_cate_cd',2,160,0,0,1);</script>
					</td>
						
					<td width="314"></td>
					
				</tr>
			</table>
			
			<table class="search" border="0"  style="width: 979;" >
				<tr class="h23">
					<td width="71">S/P Code</td>
					<td width="80" align="left">
						<input name="s_sp_seq" dataformat ="float" type="text" style="width:50; text-align:right;" class="input">
						<img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_vndr_seq">
					</td>
					<td width="198">
						<input name="s_sp_nm" type="text" style="width:198; text-align:left;" class="input2" readonly="readonly">
					</td>
					
								
	
					<td width="630"></td>
					
				</tr>
			</table>
										
			</td>
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
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
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