<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1111.jsp
*@FileTitle : US AMS: Main Menu
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.23
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2009.08.18 이수빈
* 1.0 Creation
*
* 1.1 2011.05.23 민정호 [CHM-201110983] ENS Monitor 기능 - ENS Inbound화면에 중복생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strOfc_cd        = "";
    String strPgmNo         = "";
    String strOfcType       = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = request.getParameter("pgmNo");
		if("ESM_BKG_1111".equals(strPgmNo)) strOfcType = "Origin";
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Europe Advanced Manifest: Main Menu</title>
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
<input type="hidden" name="ofcType" value="<%=strOfcType%>">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       	<tr><td class="bg">

			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="450" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">EU ENS(Origin Office)</td></tr>
						</table>
						<table class="search_sm" border="0">
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23"><td>Manifest Transmit</td></tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_1_1" style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_1_1" onmouseover="obj_MouseOver('btn_1_1')" onmouseout="obj_MouseOut('btn_1_1')">1. ENS Download & Transmit</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_1_2" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_1_2" onmouseover="obj_MouseOver('btn_1_2')" onmouseout="obj_MouseOut('btn_1_2')">2. ENS B/L Inquiry(Origin)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>
									</table>
									<table class="height_10"><tr><td colspan="8"></td></tr></table>	
									<table class="search" border="0">
									<tr class="h23"><td>Report</td></tr>
									</table>
									<table class="search" border="0" style="width:390;"> 
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_2_1" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_2_1" onmouseover="obj_MouseOver('btn_2_1')" onmouseout="obj_MouseOut('btn_2_1')">1. ENS Report(Origin)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
									</tr>						
									<tr class="h23">
										<td width=""><table width="350" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_2_2" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span id="btn_2_2" onmouseover="obj_MouseOver('btn_2_2')" onmouseout="obj_MouseOut('btn_2_2')">2. ENS Monitor(Origin)</span></td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
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
				
		
			
		<table class="height_10"><tr><td colspan="8"></td></tr></table>	
		<!--Button (S) -->
			
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

</form>
</body>
</html>
