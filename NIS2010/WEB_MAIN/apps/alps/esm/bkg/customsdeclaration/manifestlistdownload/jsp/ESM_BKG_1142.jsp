 <%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1142.jsp
*@FileTitle : Ghana Customs Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.04.12 김보배
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.event.EsmBkg1142Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1142Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	 
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
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
<title>Canada ACI: Vessel Arrival Manifest (A6)</title>
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
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="pg_no" value="esm1142">
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
				<td width="40">&nbsp;&nbsp;VVD</td>
				<td width="150"><input name="vvd_cd" type="text" style="width:80; ime-mode: disabled"  class="input1" dataformat="eng" required maxlength="9" fullfill caption="VVD"></td>
					
				<td width="300">
				<table class="search_sm2" border="0" style="width:200;"> 
				<tr class="h23">
					<td width="70"><input name="port_flg" type="radio"  class="trans" value="pol"   checked>POL</td>
					<td width=""><input name="pol_cd" type="text" style="width:50" value="" class="input1" 
										style="text-align:center" style="ime-mode: disabled" dataformat="engupnum" maxlength="5"></td>
					<td width="65"><input name="port_flg"  type="radio"  class="trans" value="pod" >&nbsp;&nbsp;POD</td>
					<td width=""><input name="pod_cd" type="text" style="width:50" value="" class="input1" 
										style="text-align:center" style="ime-mode: disabled" dataformat="engupnum" maxlength="5"></td>
					</tr>
				</table>
				</td>
				<td width="60">Total B/L</td>
				<td width=""><input name="total_bl" type="text" style="width:35" value="" class="input2" style="text-align:right" readonly></td>
				</tr>
				</table>
		</td>
		</tr>
		</table>	
		<table class="height_10"><tr><td colspan="8"></td></tr></table>	
		<table class="search"> 
       	<tr><td class="bg">
	
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="92">&nbsp;&nbsp;Vessel Name</td>
					<td width="230"><input name="vsl_eng_nm" type="text" style="width:170" value="" class="input2" readonly></td>
					<td width="30">ETD</td>
					<td width="152"><input name="etd_dt" type="text" style="width:90" value="" class="input2" readonly></td>
					<td width="30">ETA</td>
					<td width=""><input name="eta_dt" type="text" style="width:90" value="" class="input2" readonly></td>
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
			
			</td></tr>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_trans">EDI Transmit</td>
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
