<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0497.jsp
*@FileTitle : Taiwan Customs EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.taiwan.event.EsmBkg0497Event"%><%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0497Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
<title>Taiwan Customs EDI</title>
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
<input type="hidden" name="frm_vsl_cd"> 
<input type="hidden" name="frm_skd_voy_no"> 
<input type="hidden" name="frm_skd_dir_cd">
<input type="hidden" name="vvd_nm">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search" style="width:100%;"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" id="mainTable" border="0"  style="width:979;"> 				 
				<tr class="h23">
					<td width="40">VVD</td>
					<td ><input name="frm_vvd_number" style="ime-mode: disabled" id="frm_vvd_number" maxlength="9" dataformat="uppernum" type="text" style="width:100" value="" class="input1"></td>
				</tr>				 
				</table>	
				<table class="search" id="mainTable"  border="0"  > 
					<tr class="h23">
						<td width="40">POL</td>
						<td width="70"> 
						<input name="frm_pol_cd"  maxlength="5" dataformat="engupnum"  style="ime-mode: disabled" type="text" style="width:60" value="" class="input"></td>
						<td width="40">POD</td>
						<td width=""><input name="frm_pod_cd" maxlength="5" dataformat="engupnum"  type="text" style="width:60;" class="input" value=""   style="ime-mode: disabled"></td>
					</tr> 
				</table>			   				 
			</td></tr>
			</table>

<div style="display:none">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					
					<td class="btn1_left"></td>					
					<td class="btn1" name="btn_edi"  >EDI Download</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				 
			</tr>
			</table>
		</td></tr>
		</table>
					
	</td></tr>
</table>
<!-- Copyright (S) -->
<!-- 
		<table style="width:979;height:100">
	    	<tr><td>result : </td></tr>
	        <tr>
	            <td><textarea name="output" cols="100" rows="20"></textarea></td>
	        </tr>
	    </table>  --> 
 
<!-- Copyright(E)-->
</form>
</body>
</html>