<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0044.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
* ------------------------------------------------------
* HISTORY 
* 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가.
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0044Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg0044Event)request.getAttribute("Event");
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
<title>Ancs ACI: Vessel Arrival Manifest (A6)</title>
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

<!-- 개발자 작업	-->
<%
	String vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
	String podCd   = (request.getParameter("pod_cd")== null)?"":request.getParameter("pod_cd");
	String eta   = (request.getParameter("eta")== null)?"":request.getParameter("eta");
	String popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
%>	
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
					<td width="100">VVD</td>
					<td width="879"><input type="text" style="width:200;ime-mode:disabled" class="input1" name="vvd" align="middle" maxlength="9" dataformat="ennum" value="<%=vvd %>"></td>
				</tr>
				<tr class="h23">
					<td width="">SSR No</td>
					<td width=""><input type="text" style="width:200;ime-mode:disabled" name="ssr_no" class="input" align="middle" maxlength="7" dataformat="int" value="<%=ssrNo %>"></td>
				</tr>
				<tr class="h23">
					<td width="">POD</td>
					<td width="" style='padding-left:2px'><script language="JavaScript">ComComboObject("pod", 1, 200);</script>
					<input type="hidden" style="width:200" name="in_pod"  class="input2" readonly="readonly" value="<%=podCd%>">
					</td>
				</tr>
				<tr class="h23">
					<td width="">Call Date (ETA)</td>
					<td width=""><input type="text" style="width:200" name="eta" class="input2" maxlength="10" dataformat="ymd" readonly="readonly" value="<%=eta %>"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_vvdListForSSRCreation" style="text-align:left">1. VVD List for SSR Creation</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_ssrViewForCusrep" style="text-align:left">2. SSR View for CUSREP</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>
				
				<table class="height_10"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_blListForCuscar" style="text-align:left">3. B/L List for CUSCAR</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_blView" style="text-align:left">
						4. B/L View</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>
				
				<table class="height_10"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_cusrepHistoryByVvd" style="text-align:left">5. CUSREP History By VVD</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_cuscarHisByBl" style="text-align:left">
						6. CUSCAR History By B/L</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>
				
				<table class="height_10"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_codeValidate" style="text-align:left">
						7. Code Validate</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_notyLetter" style="text-align:left">
						8. Notify Letter</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="300" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_interCustomDataMgnt" style="text-align:left">
						9. Integrated Customer Data Management</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>								
				
			</td></tr>
			</table>
				
				
				
				</td></tr>
			</table>
				
			<script language="javascript">ComSheetObject('sheet0');</script>
			
			<!-- Grid (E) -->
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
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
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>