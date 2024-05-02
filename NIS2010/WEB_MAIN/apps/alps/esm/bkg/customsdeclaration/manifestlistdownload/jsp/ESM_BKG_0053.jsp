<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0053.jsp
*@FileTitle : Australlia Custom EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.08 임재택
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

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
 
  
Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	 
	strUsr_id =	account.getUsr_id();
	ofc_cd    = account.getOfc_cd();  
	strUsr_nm = account.getUsr_nm();
	 
	//event = (EsmBkg0440Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}

	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	 //http//127.0.0.1:7001/hanjin/nis2010Main.screen?pgmNo=ESM_BKG_M001&url=^hanjin^ESM_BKG_0013.do&id=ESM_BKG_0013 						 

}catch(Exception e) {
	out.println(e.toString());
}
	
%>
<html>
<head>
<title>Australia Custom EDI</title>
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
<input type="hidden" name="frm_vsl_cd"> 
<input type="hidden" name="frm_skd_voy_no"> 
<input type="hidden" name="frm_skd_dir_cd">
<input type="hidden" name="frm_pol_cd">
<input type="hidden" name="frm_pod_cd">
<input type="hidden" name="frm_trans_gubun">
<input type="hidden" name="frm_edi_ind" value="O">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td class="top"> 
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<% if (request.getParameter("pop_up") == null) { %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			<% } else { %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;ROCS:Received History</td></tr>
			<% }  %>
			
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			<!--biz page-1 (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" id="mainTable" style="width:564;"> 
				<tr class="h23">
					<td width="30">VVD</td>
					<td width="90"><input name="frm_vvd_number"  style="ime-mode: disabled;width:80" maxlength="9" dataformat="uppernum" type="text"  class="input1"  ></td> 
				<td>
				<table class="search_sm2" border="0" style="width:180;"> 
				<tr class="h23">
					<td width="110"><input type="radio" name="pol_gubun" value="1" class="trans" checked>&nbsp;POL&nbsp;&nbsp;<input type="radio" name="pol_gubun" value="2" class="trans">&nbsp;POD</td>
					<td width=""><input name="frm_port_cd" type="text" dataformat="engupnum" maxlength="5" style="ime-mode: disabled;width:50;" class="input1"  ></td>
				</tr>
				</table>
				</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="height_10"><tr><td></td></tr></table>
		
				<table class="search_sm2" border="0" style="width:300;"> 
				<tr class="h23">
					<td width="">&nbsp;&nbsp;<input type="checkbox" value="M" name="edi_gubun" class="trans" checked>&nbsp;Manifest&nbsp;&nbsp;&nbsp;&nbsp;
											 <input type="checkbox" value="P" name="edi_gubun2" class="trans">&nbsp;Port Authority</td>
					</tr>
				</table>
			
			
		
				<table class="search" border="0">
				<tr><td class="height_10"></td></tr>
				<tr><td class="title_h"></td>
					<td class="title_s">Manifest Type</td></tr>
				
				</table>
				
				<table class="search_sm2" border="0" style="width:300;"> 
				<tr class="h23">
					<td width="">&nbsp;&nbsp;<input type="radio" name="type_gubun" value="O" class="trans" checked>&nbsp;Original&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="type_gubun" value="R" class="trans">&nbsp;Replace&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  name="type_gubun" value="C" class="trans">&nbsp;Cancel</td>
					</tr>
				</table>
			
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 
<div style="display:none">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>

<table class="height_5"><tr><td></td></tr></table>
</td></tr>

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
<tr><td class="btn1_bg">
	
		<table border="0" cellpadding="0" cellspacing="0">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transmit">Manifest Transmission</td>
					<td class="btn1_right"></td>
				</tr></table></td>				 
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</td></tr>
</table> 
<!--  
<table style="width:979;height:100">
	    	<tr><td>result : </td></tr>
	        <tr>
	            <td><textarea name="output" cols="100" rows="20"></textarea></td>
	        </tr>
	    </table>
-->
<!-- : ( Button : pop ) (E) -->
			
</form>			
</body>
</html>