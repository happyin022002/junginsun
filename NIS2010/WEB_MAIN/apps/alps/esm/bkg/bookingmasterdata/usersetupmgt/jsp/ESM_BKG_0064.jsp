
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0064.jsp
	 *@FileTitle : B/L List For Inward Foreign Cargo Manifest(V 3.00)
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 * --------------------------------------------------------
	 * History
	 * 2013.11.18 김보배 [CHM-201327122] [RFS Lane] Double calling logic 적용 요청 (1) Print by VVD /Port
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String cnt_cd = "";//국가코드
	String vvd_cd  = JSPUtil.getNull(request.getParameter("vvd_cd")); ;//bl_no - BL No들을 파라메트로 받는다(bl_no=aaa|bbb|ccc). 
	String arr_bkg_no  = JSPUtil.getNull(request.getParameter("bkg_no")); ;//BKG No들을 파라메트로 받는다(bl_no=aaa|bbb|ccc). 
	String mode_type   = JSPUtil.getNull(request.getParameter("mode_type")); ;//outbound,inbound구분
	String pol_cd   = JSPUtil.getNull(request.getParameter("pol_cd")); ;
	String pol_yd_cd   = JSPUtil.getNull(request.getParameter("pol_yd_cd")); ;
	String pod_cd   = JSPUtil.getNull(request.getParameter("pod_cd")); ;
	String pod_yd_cd   = JSPUtil.getNull(request.getParameter("pod_yd_cd")); ;
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cnt_cd    = account.getCnt_cd();

		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<body onLoad="setupPage();"><div id='debug'></div>
<form method="post" name="form" onSubmit="return false;" target="if_print">
<input type="hidden" name="f_cmd">
<input type="hidden" name="vvd_cd"  value="<%=vvd_cd%>">
<input type="hidden" name="arr_bkg_no"  value="<%=arr_bkg_no%>">
<input type="hidden" name="bkg_no"  value="">
<input type="hidden" name="mode_type"   value="<%=mode_type%>">
<input type="hidden" name="pod_cd"   value="<%=pod_cd%>">
<input type="hidden" name="pod_yd_cd"   value="<%=pod_yd_cd%>">
<input type="hidden" name="pol_cd"   value="<%=pol_cd%>">
<input type="hidden" name="pol_yd_cd"   value="<%=pol_yd_cd%>">
<input type="hidden" name="cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="usr_id"      value="<%=strUsr_id%>">
<input type="hidden" name="bl_face_prn_dvc_nm" value="">
<input type="hidden" name="bl_ridr_prn_dvc_nm" value="">
	<input type="hidden" name="ch_usr_id">
	<input type="hidden" name="com_mrdPath">
	<input type="hidden" name="com_mrdArguments">
	<input type="hidden" name="com_mrdTitle">
	<input type="hidden" name="com_mrdBodyTitle">
	<input type="hidden" name="com_mrdSaveDialogDir" value="<%=System.getProperty("user.home")+System.getProperty("file.separator")%>">
	<input type="hidden" name="com_mrdSaveDialogFileName">
	<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
	<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
	<input type="hidden" name="com_mrdDisableToolbar" value="3">
	<input type="hidden" name="com_zoomIn">
	<input type="hidden" name="com_isBatch" value="N">
	
		
<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;General Cargo Manifest Print Setup</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			<!--biz page-1 (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search_sm2" border="0" width="100%">
					<tr class="h23">
						<td width="70">Type</td>
						<td width="" class="stm">
							<input type="radio" name="paper_type" value="1"	class="trans" checked>&nbsp;A4&nbsp;&nbsp;&nbsp;
							<input type="radio" name="paper_type" value="4" class="trans">&nbsp;Letter
							<input type="radio" name="paper_type" value="10" class="trans">&nbsp;DOT&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</table>
				
				<!--
				<table class="search" border="0" width="100%">
					<tr class="h23">
						<td width="90">&nbsp;&nbsp;Print</td>
						<td width=""><select style="width: 176;">
							<option value="0" selected>1. HP LaserJet 4100 SE</option>
							<option value="1"></option>
						</select>
					</tr>
				</table>-->
				<table class="search" border="0" width="100%" id="mainTable">
					<tr class="h23">
						<td width="90">&nbsp;&nbsp;Print Setup</td>
						<td width="">
						<script language="javascript">ComComboObject('bl_prn_dvc_nm', 1, 178, '');</script>
						<!--<input type="text" style="width:176" value="" class="input1"  name="bl_prn_dvc_nm" maxlength='100' required fullfill  dataformat='engupnum' style="ime-mode:disabled">
						-->
						</td>
					</tr>
					<tr class="h23">
						<td width="90">&nbsp;&nbsp;Print Form</td>
						<td width=""><select style="width: 176;" name="print_form">
							<option value="GEN">General</option>
							<option value="US">US</option>
							<option value="USC">US with Charge</option>
							<option value="NG">Nigeria</option>
							<option value="VN">Vietnam</option>
							<option value="NZ">New Zealand</option>
							<option value="PH">Philippines</option>
						</select></td>
					</tr>
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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print" id="btn_Print">Print</td>
					<td class="btn1_right">
				</tr></table></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_preview">Print Preview</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
		</td></tr>
	</table>
		</td></tr>
	</table>	
<!-- : ( Button : pop ) (E) -->
</form>
<div style="display:none"><script language="javascript">ComSheetObject('sheet1');</script></div>
<div style="z-index: 1;width:1px;height:1px;left:1px;top:1px; position:absolute">
	<script language="javascript">comRdObject('Rdviewer');</script>
</div>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>