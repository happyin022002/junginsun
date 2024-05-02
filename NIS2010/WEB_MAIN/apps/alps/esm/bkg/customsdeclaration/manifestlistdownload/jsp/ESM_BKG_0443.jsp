<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0443.jsp
*@FileTitle : ROCS_CRN Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.01 임재택
* 1.0 Creation
*--------------------------------------------------------
* History
* 2011.07.06 김보배 [SRM-201117905] [ROCS] Berth code 추가 - ECT DDE
* 2014.06.12 김보배 [CHM-201430469] CRN Create 화면에 Port 추가
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0443Event"%><%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0443Event  event = null;	
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";						//에러메세지
int rowCount	 = 0;						//DB ResultSet 리스트의 건수

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";

Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   
	ofc_cd    = account.getOfc_cd(); 
	strUsr_nm = account.getUsr_nm();
	strUsr_id = account.getUsr_id();

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
<title>ROCS:CRN Create</title>
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
<input type="hidden" name="f_user_id" value ="<%=strUsr_id%>">
<input type="hidden" name="frm_user_ofc_cd" value ="<%=ofc_cd%>">
<input type="hidden" name="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="frm_vsl_cd"> 
<input type="hidden" name="frm_skd_voy_no"> 
<input type="hidden" name="frm_skd_dir_cd">
<input type="hidden" name="frm_crn_number">
<input type="hidden" name="ibflag">
<input type="hidden" name="err_msg">
<input type="hidden" name="frm_vvd_number">
<input type="hidden" name="frm_pod_clpt_ind_seq">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>			 
		</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" id="mainTable" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">&nbsp;&nbsp;CRN</td>
					<td width="">
					<input name="frm_vsl_call_ref_no"  style="ime-mode: disabled" maxlength="13" dataformat="uppernum" type="text" style="width:110;" class="input1" value=""></td>
					</tr>
				</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">&nbsp;&nbsp;VVD Name</td>
					<td width="">
						<script language="javascript">ComComboObject('combo_vvd_cd', 1, 110, '');</script>
						<!-- <input type="text"  style="width:110;ime-mode: disabled" class="input1"  name = "frm_vvd_number" dataformat="uppernum"  id="frm_vvd_number"  maxlength="9" >--> 
					&nbsp;<input name = "frm_vsl_eng_nm" type="text" style="width:150;" class="input2" readonly  value=" ">
					</td>
				</tr>
			</table>
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">&nbsp;&nbsp;POD</td>
					<td width="190"><input type="text" style="width:110;" class="input2" readonly  value="NLRTM">&nbsp;<script language="javascript">ComComboObject('combo_pod_seq', 1, 40, '');</script></td>
					<td width="91">Call Date</td>
					<td width=""><input name= "frm_vps_eta_dt" type="text" style="width:147;" class="input2" readonly  value=" "></td>
				</tr>
				<tr class="h23">
					<td width="">&nbsp;&nbsp;DEM Free Time</td>
					<td width=""><input name= "frm_dem_free_dt" maxlength="8" type="text" style="width:110;" class="input"  dataformat="ymd" style="ime-mode: disabled"  reqEsmred> 
					<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="">Berth Code</td>
					<td width="">
					<select name ="frm_brth_ctnt"  id ="frm_brth_ctnt" style="width:147;">	
					    <option value=" "></option>				    
						<option value="19388557" >Hanno Terminal (P5)</option>
						<option value="19388558">Hanno Terminal (P6)</option>
						<option value="19387513">ECT Delta DDN</option>
						<option value="19388174">ALEXH ECT</option>
						<option value="19387630">ECT DDW</option>
						<option value="19387239">ECT DDE</option>
						<option value="74353661">EUROMAX</option>	
						<option value="19387327">APM</option>	
						<option value="4254">APM2</option>	
						<option value="19388560">UNIPORT</option>
					</select></td>
				</tr>
				</table>
				
			<table class="height_2"><tr><td></td></tr></table>
	
			<table border="0" style="width:662; background-color:white;" class="grid2"> 
				<tr>
				<td class="tr2_head" width="16%">N/L Text</td>
				<td><textarea value = " " style="ime-mode: disabled" name= "frm_ntfy_ltr_ctnt" style="width:100%" rows="6"> 
</textarea></td>
			</tr></table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">&nbsp;&nbsp;Creation ID</td>
					<td width="190"><input name= "frm_cstms_decl_usr_id" readonly type="text" style="width:110;" class="input2" value=""></td>
					<td width="91">Create Date</td>
					<td width=""><input name= "frm_cre_dt" readonly type="text" style="width:145;" class="input2" value=""></td>
				</tr></table>
			<!--  biz_1   (E) -->
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->	
				
			</td></tr>
		</table>
<div style="display:none">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<div style="display:none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<div style="display:none">
<script language="javascript">ComSheetObject('sheet3');</script>
</div>
	<!--biz page (E)-->
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
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_changeCrn">Change CRN</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_list">List</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>
	

<!-- Copyright (S) -->
 
</form>
</body>
</html>