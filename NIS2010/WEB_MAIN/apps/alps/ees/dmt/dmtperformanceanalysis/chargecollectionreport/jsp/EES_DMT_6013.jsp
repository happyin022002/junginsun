<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EES_DMT_6013.jsp
*@FileTitle :  Unissued Invoice by Aging – Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.05.11 김기태
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event.EesDmt6013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt6013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTPerformanceAnalysis.ChargeCollectionReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();

		event = (EesDmt6013Event)request.getAttribute("Event");
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
<title>Unissued Invoice by Aging – Detail(s)</title>
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
<input type="hidden" name="start_dt"		value="<%=JSPUtil.getParameter(request, "start_dt", "")%>">
<input type="hidden" name="end_dt"			value="<%=JSPUtil.getParameter(request, "end_dt", "")%>">
<input type="hidden" name="grp_flg"			value="<%=JSPUtil.getParameter(request, "grp_flg", "")%>">
<input type="hidden" name="ofc_cd"			value="<%=JSPUtil.getParameter(request, "ofc_cd", "")%>">
<input type="hidden" name="dmdt_trf_cd"		value="<%=JSPUtil.getParameter(request, "dmdt_trf_cd", "")%>">
<input type="hidden" name="uclm_flg"		value="<%=JSPUtil.getParameter(request, "uclm_flg", "")%>">
<input type="hidden" name="dmdt_cntr_tp_cd"	value="<%=JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", "")%>">
<input type="hidden" name="usr_rhq_ofc_cd"	value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="dmdt_chg_sts_cd"	value="<%=JSPUtil.getParameter(request, "dmdt_chg_sts_cd", "")%>">

<!-- LOCAL CURRENCY 위해 추가 2016.08.10 -->
<input type="hidden" name="bzc_trf_curr_cd"	value="<%=JSPUtil.getParameter(request, "bzc_trf_curr_cd", "")%>">

<!-- 지정 화면 Access 권한 정보 조회용  -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Unissued Invoice by Aging – Detail(s)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<!-- 1 (S) -->		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
				
					<!-- Grid - 3 (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>					
					<!-- Grid - 3 (E) -->
					
					<table class="height_5"><tr><td></td></tr></table>
					
					<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">CNTR Q'ty</td>
						<td><input type="text" name="cntr_qty" style="width:50;text-align:right;" readonly class="input"></td>
					</tr> 
					</table>				
					<!--  biz_1   (E) -->	
			
		</td></tr>
		</table>
		<!-- 1 (E) -->				
		
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>


	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByBKG">by BKG</td>
					<td class="btn1_right">
				</tr></table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByCNTR">by CNTR</td>
					<td class="btn1_right">
				</tr></table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line"></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
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