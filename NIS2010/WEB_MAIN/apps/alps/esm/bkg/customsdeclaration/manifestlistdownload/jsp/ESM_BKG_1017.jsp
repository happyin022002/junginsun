<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_1017.jsp
*@FileTitle : Rocs BL ADD Pop-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.13
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.08 임재택
* 1.0 Creation
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
String bkg_no= "";
String frm_crn_number= ""; 
String vvd_no ="";
String pod_calling_seq = "";

Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	
   	bkg_no = StringUtil.xssFilter(request.getParameter("bkg_no"))==null?"":StringUtil.xssFilter(request.getParameter("bkg_no"));
   	frm_crn_number = StringUtil.xssFilter(request.getParameter("frm_crn_number"))==null?"":StringUtil.xssFilter(request.getParameter("frm_crn_number"));
   	
   	vvd_no = StringUtil.xssFilter(request.getParameter("vvd_no"))==null?"":StringUtil.xssFilter(request.getParameter("vvd_no"));
   	pod_calling_seq = StringUtil.xssFilter(request.getParameter("pod_clpt_ind_seq"))==null?"":StringUtil.xssFilter(request.getParameter("pod_clpt_ind_seq"));
   	
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
<title>B/L Add</title>
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

<body class="popup_bg" onLoad="setupPage();">
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
<input type="hidden" name="pg_no" value="esm1017">
<input type="hidden" name="dif_chr">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="crn_number" value ="<%=frm_crn_number%>">
<input type="hidden" name="etc_bkg_no">
<input type="hidden" name="user_id" value ="<%=strUsr_id%>">
<input type="hidden" name="vvd_number" value="<%=vvd_no%>">
<input type="hidden" name="pod_clpt_ind_seq" value="<%=pod_calling_seq%>">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> B/L Add</td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0"  style="width:184;"> 
				<tr class="h23">
					<td width="50">B/L No.</td>
					<td width=""><input type="text" style="width:100%;" maxlength="12" class="input" dataformat="uppernum" style="ime-mode: disabled" name = "bl_no" value=""></td>
				</tr>
				</table>
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<div style="display:none">
<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				</div> 		
				
<table class="height_5"><tr><td></td></tr></table>
	
</td></tr>
</table> 
	<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_new">Creation</td>
									<td class="btn1_right"></td>
									</tr></table></td>
								<td class="btn1_line"></td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
	
	</td></tr>
</table>
</form>
</body>
</html>