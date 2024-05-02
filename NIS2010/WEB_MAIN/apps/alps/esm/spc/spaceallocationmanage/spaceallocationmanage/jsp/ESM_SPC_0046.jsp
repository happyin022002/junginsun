<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0046.jsp
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
* 2012.08.29 전상화 [CHM-201219578-01] Control by HO / RHQ 화면에 Alloc Copy & Paste 버튼 추가
* 2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpaceAllocationManage.SpaceAllocationManage");

	boolean isAdmin=false;
	String ofc_cd="" ;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0046Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		
		 isAdmin = false;
		 ofc_cd   = event.getSignOnUserAccount().getOfc_cd();
		

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Alloc Copy&Paste</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">




function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0046');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="uiname" value="ESM_SPC_0046">

<input type="hidden" name="vslCdText" value="">
<input type="hidden" name="skdVoyNoText" value="">
<input type="hidden" name="skdDirCdText" value="">

<input type="hidden" name="fcastCode" value="">
<input type="hidden" name="copyDiv" value="VVD">
<input type="hidden" name="acctCtrl" value="">
<input type="hidden" name="openUI" value="">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Alloc Copy&Paste
		</td></tr></table>
		<!-- : ( Title ) (E) -->
		
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_confirm" id="btn_save" alt="Alt+S">Confirm</td><td class="btn1_right"></td></tr></table></td>
						</tr></table>
				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr>
					<td>
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="90"><img class="nostar">Start Week</td>
								<td width="120" style="padding-left:1">									
									<input class="input" type="input" name="yearText" size="6" style="ime-mode:disabled;text-align:center;" readonly>
									<input class="input" type="input" name="weekText" size="2" style="ime-mode:disabled;text-align:center;" readonly>
								</td>
<!--								<td width="80"><img class="nostar">Duration</td>
								<td width="80">
									<select class="input" name="duration" size="1"></select>
								</td>
-->								
								<td width="120"><img class="nostar">Standard VVD</td>
								<td width="120"><input class="input" type="input" name="vvdText" size="12" maxlength="9" style="ime-mode:disabled;text-align:center;" readonly></td>
								
								<td width="190"><img class="nostar">Copy to Multiple Choices ( </td>
								<td>
							
								 	<input type="radio" class="trans" name="copy_div" value="VVD" onclick="changeCopy('VVD');" checked><label for="id_chk_pol">per VVD</label>&nbsp;
								        </td>
								 	
							            <td width="75"><img class="nostar"> Duration </td>
								        <td width="75">
									        <select class="input" name="duration" size="1"></select>
								        </td> 
								        <td width="17">/</td>
								        <td>								        
                                    <input type="radio" class="trans" name="copy_div" value="VSEL" onclick="changeCopy('VSEL');"><label for="id_chk_pod">per VSEL</label>&nbsp;
							 	
								</td><td> ) </td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table class="search_in" border="0">
							<tr class="h23">
							<td width="90"><img class="nostar">Rep. Trade</td>
							<td width="120" style="padding-left:3">
								<input class="input" type="input" name="tradeText" size="12" maxlength="9" style="ime-mode:disabled;text-align:center;" readonly>
							</td>
							<td width="80"><img class="nostar">Sub Trade</td>
							<td width="80" style="padding-left:3">								
								<input class="input" type="input" name="subtradeText" size="2" maxlength="9" style="ime-mode:disabled;text-align:center;" readonly>
							</td>
							<td width="120"><img class="nostar">Lane</td>
							<td width="120">								
								<input class="input" type="input" name="laneText" size="6" maxlength="9" style="ime-mode:disabled;text-align:center;" readonly>
							</td>
							<td width="60"><img class="nostar">Bound</td>
							<td width="120">
								<input class="input" type="input" name="boundText" size="1" maxlength="9" style="ime-mode:disabled;text-align:center;" readonly>
							</td>
							<td width="55"><img class="nostar">Origin</td>
							<td>
							   <input class="input" type="input" name="officeText" size="12" maxlength="9" style="ime-mode:disabled;text-align:center;" readonly>
							  
							</td>
							</tr>
						</table>
					</td>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				
				<table width="100%" id="mainTable1">
                    <tr><td>
                         <script language="javascript">ComSheetObject('sheet1');</script>
                    </td></tr>
	            </table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--


/**
 * ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
 */
with(document.form){		
	
	<% if(event != null) {%>
	
	yearText.value        	= "<%= JSPUtil.getNull(request.getParameter("year"))==null			?"":JSPUtil.getNull(request.getParameter("year")) %>";
	weekText.value     		= "<%= JSPUtil.getNull(request.getParameter("week"))==null			?"":JSPUtil.getNull(request.getParameter("week")) %>";
	officeText.value       	= "<%= JSPUtil.getNull(request.getParameter("office")) == null 		?"":JSPUtil.getNull(request.getParameter("office")) %>";
	laneText.value     		= "<%= JSPUtil.getNull(request.getParameter("lane"))==null			?"":JSPUtil.getNull(request.getParameter("lane")) %>";
	boundText.value     	= "<%= JSPUtil.getNull(request.getParameter("bound"))==null			?"":JSPUtil.getNull(request.getParameter("bound")) %>";

	vslCdText.value     	= "<%= JSPUtil.getNull(request.getParameter("vsl_cd")) == null 		?"":JSPUtil.getNull(request.getParameter("vsl_cd")) %>";
	skdVoyNoText.value    = "<%= JSPUtil.getNull(request.getParameter("skd_voy_no")) == null 	?"":JSPUtil.getNull(request.getParameter("skd_voy_no")) %>";
	skdDirCdText.value    = "<%= JSPUtil.getNull(request.getParameter("skd_dir_cd")) == null 	?"":JSPUtil.getNull(request.getParameter("skd_dir_cd")) %>";

    var fcast = "<%= JSPUtil.getNull(request.getParameter("fcast"))==null			?"":JSPUtil.getNull(request.getParameter("fcast")) %>";
 	fcastCode.value     	= fcast;
 	
	vvdText.value      		= "<%= JSPUtil.getNull(request.getParameter("vvd"))==null			?"":JSPUtil.getNull(request.getParameter("vvd")) %>";
	tradeText.value       	= "<%= JSPUtil.getNull(request.getParameter("trade"))==null			?"":JSPUtil.getNull(request.getParameter("trade")) %>";
	subtradeText.value      = "<%= JSPUtil.getNull(request.getParameter("subtrade"))==null		?"":JSPUtil.getNull(request.getParameter("subtrade")) %>";
	officeText.value 		= "<%= JSPUtil.getNull(request.getParameter("office"))==null		?"":JSPUtil.getNull(request.getParameter("office")) %>";

	duration.value 			= "<%= JSPUtil.getNull(request.getParameter("duration"))==null		?"":JSPUtil.getNull(request.getParameter("duration")) %>";
	acctCtrl.value 			= "<%= JSPUtil.getNull(request.getParameter("acct_ctrl"))==null		?"":JSPUtil.getNull(request.getParameter("acct_ctrl")) %>";
	openUI.value 			= "<%= JSPUtil.getNull(request.getParameter("openUI"))==null		?"":JSPUtil.getNull(request.getParameter("div")) %>";
	
	<%}%>
}
-->


</SCRIPT>

