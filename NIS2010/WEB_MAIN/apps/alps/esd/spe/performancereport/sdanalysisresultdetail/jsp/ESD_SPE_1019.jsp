<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1019.jsp
*@FileTitle : SD Analysis Result Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.event.EsdSpe1019Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsdSpe1019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

	
	// Multi Sheet인 경우, Sheet의 Index 정보
	String sheetIdx = request.getParameter("sheetIdx");
	
	// Sheet에서 팝업 호출시, Target이 되는 Cell의 row/col 정보
	String row = request.getParameter("row");
	String col = request.getParameter("col");		
	
	Logger log = Logger.getLogger("com.hanjin.apps.PerformanceManagement.QualitativeEvaluation");
	
	String ev_yr           = StringUtil.xssFilter(request.getParameter("EV_YR"))             !=null&&!StringUtil.xssFilter(request.getParameter("EV_YR")).equals("")             ?StringUtil.xssFilter(request.getParameter("EV_YR")):"";
	String eg_rhq_cd       = StringUtil.xssFilter(request.getParameter("EG_RHQ_CD"))         !=null&&!StringUtil.xssFilter(request.getParameter("EG_RHQ_CD")).equals("")         ?StringUtil.xssFilter(request.getParameter("EG_RHQ_CD")):"";
	String eg_ofc_cd	   = StringUtil.xssFilter(request.getParameter("EG_OFC_CD"))         !=null&&!StringUtil.xssFilter(request.getParameter("EG_OFC_CD")).equals("")         ?StringUtil.xssFilter(request.getParameter("EG_OFC_CD")):"";
	String ev_svc_cate_cd  = StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD"))    !=null&&!StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD")).equals("")    ?StringUtil.xssFilter(request.getParameter("EV_SVC_CATE_CD")):"";
	String eg_id		   = StringUtil.xssFilter(request.getParameter("EG_ID"))             !=null&&!StringUtil.xssFilter(request.getParameter("EG_ID")).equals("")             ?StringUtil.xssFilter(request.getParameter("EG_ID")):"";
	String eg_nm           = StringUtil.xssFilter(request.getParameter("EG_NM"))             !=null&&!StringUtil.xssFilter(request.getParameter("EG_NM")).equals("")             ?StringUtil.xssFilter(request.getParameter("EG_NM")):"";
	String sp_seq          = StringUtil.xssFilter(request.getParameter("SP_SEQ"))            !=null&&!StringUtil.xssFilter(request.getParameter("SP_SEQ")).equals("")            ?StringUtil.xssFilter(request.getParameter("SP_SEQ")):"";
	String sp_name         = StringUtil.xssFilter(request.getParameter("SP_NAME"))           !=null&&!StringUtil.xssFilter(request.getParameter("SP_NAME")).equals("")           ?StringUtil.xssFilter(request.getParameter("SP_NAME")):"";
	String sd_group        = StringUtil.xssFilter(request.getParameter("SD_GROUP"))          !=null&&!StringUtil.xssFilter(request.getParameter("SD_GROUP")).equals("")          ?StringUtil.xssFilter(request.getParameter("SD_GROUP")):"";
	String pa_point        = StringUtil.xssFilter(request.getParameter("PA_POINT"))          !=null&&!StringUtil.xssFilter(request.getParameter("PA_POINT")).equals("")          ?StringUtil.xssFilter(request.getParameter("PA_POINT")):"";
	String pa_group	       = StringUtil.xssFilter(request.getParameter("PA_GROUP"))          !=null&&!StringUtil.xssFilter(request.getParameter("PA_GROUP")).equals("")          ?StringUtil.xssFilter(request.getParameter("PA_GROUP")):"";
	String be_point	       = StringUtil.xssFilter(request.getParameter("BE_POINT"))          !=null&&!StringUtil.xssFilter(request.getParameter("BE_POINT")).equals("")          ?StringUtil.xssFilter(request.getParameter("BE_POINT")):"";
	String be_group	       = StringUtil.xssFilter(request.getParameter("BE_GROUP"))          !=null&&!StringUtil.xssFilter(request.getParameter("BE_GROUP")).equals("")          ?StringUtil.xssFilter(request.getParameter("BE_GROUP")):"";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	usr_id              = account.getUsr_id();
	   	usr_nm              = account.getUsr_nm();
	   	ofc_cd      		= account.getOfc_cd();    
		rhq_ofc_cd      	= account.getRhq_ofc_cd(); 

		event = (EsdSpe1019Event)request.getAttribute("Event");
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
<title>Evaluation Group Creation</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="code_key">
<input type="hidden" name="pagerows">
<input type="hidden" name="ev_yr"          value="<%=ev_yr%>">
<input type="hidden" name="eg_rhq_cd"      value="<%=rhq_ofc_cd%>">
<input type="hidden" name="eg_ofc_cd"      value="<%=eg_ofc_cd%>">
<input type="hidden" name="ev_svc_cate_cd" value="<%=ev_svc_cate_cd%>">
<input type="hidden" name="eg_id"          value="<%=eg_id%>">
<input type="hidden" name="eg_nm"          value="<%=eg_nm%>">
<input type="hidden" name="sp_seq"         value="<%=sp_seq%>">
<input type="hidden" name="sp_name"        value="<%=sp_name%>">
<input type="hidden" name="sd_group"       value="<%=sd_group%>">
<input type="hidden" name="pa_point"       value="<%=pa_point%>">
<input type="hidden" name="pa_group"       value="<%=pa_group%>">
<input type="hidden" name="be_point"       value="<%=be_point%>">
<input type="hidden" name="be_group"       value="<%=be_group%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> SD Analysis Result Detail(PA Result Summary)</td></tr>
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
							<td class="btn1" name="btn_downexcel">Down Excel</td>
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
		</td></tr>
	</table>		
	<table class="height_5"><tr><td></td></tr></table>
	<table class="search" > 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table class="search" border="0"  style="width: 400;" >
				<tr class="h23">
					<td width="60">PA Score</td>
					<td width="100" align="left">
						<input name="s_pa_score" dataformat ="float" type="text" style="width:50; text-align:right;" class="input">
					</td>
					<td width="240"></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<table class="height_5"><tr><td></td></tr></table>		
	<table class="search" id="mainTable">
	 	<tr><td class="bg" valign="top">
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