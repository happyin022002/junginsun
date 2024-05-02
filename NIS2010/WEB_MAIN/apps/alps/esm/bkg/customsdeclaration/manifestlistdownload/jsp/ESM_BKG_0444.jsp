<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0444.jsp
*@FileTitle : B/L Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.13
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.08 임재택
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2012.06.20 김보배 [SRM-201227299] [BKG] [ROCS] CRN Cancel 버튼 제거
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
 
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";						//에러메세지
int rowCount	 = 0;						//DB ResultSet 리스트의 건수

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";
String cn_no= "";
String frm_bl_no= ""; 
String vvd_no= ""; 
Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	
   	cn_no = StringUtil.xssFilter(request.getParameter("crn_no"))==null?"":StringUtil.xssFilter(request.getParameter("crn_no"));
   	vvd_no =StringUtil.xssFilter(request.getParameter("vvd_no"))==null?"":StringUtil.xssFilter(request.getParameter("vvd_no"));
   	
	strUsr_id =	account.getUsr_id();
	ofc_cd    = account.getOfc_cd();  
	strUsr_nm = account.getUsr_nm();

	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}

}catch(Exception e) {
	out.println(e.toString());
}
	
%>
<html>
<head>
<title>ROCS: CRN List</title>
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
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="mt_flag">
<input type="hidden" name="pol_cd">
<input type="hidden" name="cntr_no">  
<input type="hidden" name="pg_no" value="esm0444">
<input type="hidden" name="dif_chr">
<input type="hidden" name="bkg_no_split">
<input type="hidden" name="frm_slan_cd">
<input type="hidden" name="crn_number">
<input type="hidden" name="lane_cd">
<input type="hidden" name="etc_bkg_no">
<input type="hidden" name="vsl_call_ref_no">
<input type="hidden" name="cn_no" value="<%=cn_no%>">
<input type="hidden" name="vvd_no" value="<%=vvd_no%>">
<input type="hidden" name="user_id" value ="<%=strUsr_id%>">
<input type="hidden" name="pod_clpt_ind_seq">

<!-- 개발자 작업	-->
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Call Date(ETA)</td>
					<td width="">
					
					<input type="text"
							style="width: 85; ime-mode: disabled" class="input1" maxlength="10"
							dataformat="ymd" maxlength="10" name="vps_eta_start_dt" caption="ETA" cofield="vps_eta_end_dt">
						&nbsp;~&nbsp; <input type="text"
							style="width: 85; ime-mode: disabled" class="input1" maxlength="10"
							dataformat="ymd" maxlength="10" name="vps_eta_end_dt" caption="ETA" cofield="vps_eta_start_dt">
						<img src="img/btns_calendar.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor" name="btn_calendar"></td>
					<!--
					<input type="text" class="input" style="width:75" 
					 name="vps_eta_start_dt" maxlength="10" dataformat="ymd" style="ime-mode: disabled" >&nbsp;&nbsp;~&nbsp;
					<input type="text" class="input1" style="width:75" value=""  style="ime-mode: disabled" name="vps_eta_end_dt" maxlength="10" dataformat="ymd" reqEsmred>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					 -->
					<td width="30">VVD</td>
					<td width="130"><input name="vvd_number"  style="ime-mode: disabled" dataformat="uppernum" style="ime-mode: disabled" maxlength="9"  type="text" style="width:80" value="" class="input1"></td>
					<td width="30">CRN</td>
					<td width="150"><input name="frm_crn_number"   style="ime-mode: disabled" dataformat="uppernum" style="ime-mode: disabled" maxlength="14" type="text" style="width:110" value="" class="input1"></td>
					<td width="100">Creation Status</td>
					<td><select name="slan_cd" style="width:80;">
						<option value="0" selected>All</option>
						<option value="Y">Created</option>
						<option value="N">New</option>
						<!--  <option value="C">Cancel</option>  -->
						<option value="V">Non CRN</option>
						</select></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<!-- Grid  (S) -->
				<table width="800"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->
				
				
				</td></tr>
			</table>
				
		
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_bl">B/L Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
<!-- 				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_crn">CRN Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
 -->
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_list">B/L List</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_addLane">Add Lane</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>	 
</form>
</body>
</html>