 <%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0311.jsp
*@FileTitle : Indonesia Customs Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장지영
*@LastVersion : 1.0
* 2009.09.29 장지영
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.event.EsmBkg0311Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
	EsmBkg0311Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = "";
	 
	Logger log = Logger.getLogger("com.hanjin.apps.esm.bkg.customsdeclaration.manifestListDownload.indonesia");
	
	String bkg_no = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0311Event) request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Indonesian Customs EDI</title>
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
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="strBkgNo"> 
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="bound_cd" value="O">
<input type="hidden" name="where_query" value="">
<input type="hidden" name="pg_no" value="esm0311">
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
			<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
		<td width="200" valign="top">
				<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:300;"> 
			<tr class="h23">
				<td width="">VVD</td>
				<td width=""><input name="vvd" type="text" style="width:100" maxlength="9" dataformat="uppernum" style="ime-mode:disabled" value="" class="input1"></td>
				</tr>
			<tr class="h23">
				<td width="">POL</td>
				<td width=""><input name="pol_code" type="text" style="width:100" maxlength="5" dataformat="upper" style="ime-mode:disabled" value="" class="input1"></td>
				</tr>	
			<tr class="h23">
				<td width="">POD</td>
				<td width=""><input name="pod_code" type="text" style="width:100" maxlength="5" dataformat="upper" style="ime-mode:disabled" value="" class="input1"></td>
				</tr>
			<tr class="h23">
				<td width="80">Booking No.</td>
				<td width=""><input name="bkg_no" type="text" maxlength="13" dataformat="uppernum" style="ime-mode:disabled;width:110px;" value="" class="input">
							<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
							<div id="layList" name="layList" style="position:absolute;z-index:999;display:none;"></div></td>
				</tr>
			</table></td>
			<td width="">	
			<table class="search_sm2" border="0" style="width:500;">
				<tr class="h23">
				<td width=""><input type="radio" value="09E" class="trans" name="mf_tp_cd" checked="checked">&nbsp;&nbsp;09E &nbsp;: Goods Loaded and registered at the same Customs Offices </td>
				</tr>
				<tr class="h23">
				<td width=""><input type="radio" value="10E" class="trans" name="mf_tp_cd">&nbsp;&nbsp;10E &nbsp;: Goods Loaded and registered at different Customs office </td>
				</tr>
				<tr class="h23">
				<td width=""><input type="radio" value="04E" class="trans" name="mf_tp_cd">&nbsp;&nbsp;04E &nbsp;: Transshipment Goods </td>
				</tr>
				<tr class="h23">
				<td width=""><input type="radio" value="05E" class="trans" name="mf_tp_cd">&nbsp;&nbsp;05E &nbsp;: Goods Retain on Board  </td>
				</tr>
				<tr class="h23">
				<td width=""><input type="radio" value="08X" class="trans" name="mf_tp_cd">&nbsp;&nbsp;08X &nbsp;: Empty Container  </td>
				</tr>
			</table>
		</td>
		</tr>
		</table>	
			<!--  biz_1  (S) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			<!--  biz_1  (S) -->
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
		</td>
		</tr>
		</table>	
		
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Excel Down</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_edi">EDI File Download</td>
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
		   
 
</form>
</body>
</html>
