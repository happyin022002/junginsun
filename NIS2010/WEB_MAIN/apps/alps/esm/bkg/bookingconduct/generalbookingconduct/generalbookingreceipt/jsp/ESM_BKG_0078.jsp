<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : esm_bkg_xxxx.jsp
*@FileTitle : BKG Reactivate
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 양동훈
*@LastVersion : 1.0
* 2009.05.21 양동훈
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0078Event"%>

<%
	EsmBkg0078Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strPort_cd		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.generalbookingconduct.generalbookingreceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strPort_cd = account.getOfc_cd();


		event = (EsmBkg0078Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>BKG Reactivate</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		ComSetObjValue(document.form.screenName,"<%=screenName%>");
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<input type="hidden" name="sheet1_user_id" value="<%= strUsr_id %>">
<input type="hidden" name="sheet1_port_cd" value="<%= strPort_cd %>">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<!-- <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> -->
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">  BKG Reactivate</td></tr>
		</table>

	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:900;"> 
				<tr class="h23">
					<td width="60">BKG NO.</td>
					<td width="140"><input type="text" id = "bkgNo" name="bkgNo" style="width:100;" dataformat="engup" class="input1" value="" maxlength="14" style="ime-mode:disabled;" ></td>
					<td width="20">VVD</td>
					<td width="130"><input type="text" id = "trunkVVD" name="trunkVVD" style="width:100;" dataformat="engup" class="input1" value="" maxlength="9" style="ime-mode:disabled;" ></td>
					<td width="20">POL</td>
					<td width="120"><input type="text" id = "polCd" name="polCd" style="width:80;" dataformat="engup" class="input" value="" maxlength="5" style="ime-mode:disabled;" ></td>
					<td width="20">POD</td>
					<td width="120"><input type="text" id = "podCd" name="podCd" style="width:80;" dataformat="engup" class="input" value="" maxlength="5" style="ime-mode:disabled;" ></td>
					<td width="20">STATUS</td>
					<td width="120"><select name="sts" style="width:67;" class="input1" id= "sts">
						<option value="ALL">ALL</option>
						<option value="X">X</option>
						<option value="W">W</option>
						<option value="F">F</option>
						</select></td>
				</tr>
				<tr  class="h23">
					<td width="140">Total BKG Count</td>
					<td width="50"><input type="text" id = "totCnt" name="totCnt" style="width:50;" class="input2" value="" maxlength="14" style="ime-mode:disabled;" readonly tabindex=-1></td>
					<td width="140">Cancel BKG Count</td>
					<td width="50"><input type="text" id = "cxlCnt" name="cxlCnt" style="width:50;" class="input2" value="" maxlength="14" style="ime-mode:disabled;" readonly tabindex=-1></td>
					<td width="140">Cancel Reason</td>
					<td width="120"><select name="cxlRsn" style="width:120;" class="input" id = "cxlRsn">
						<option value="ALL"></option>
						<option value="U">By User</option>
						<option value="N">No Rate Sts</option>
						<option value="C">Combine</option>		
						</select></td>
				</tr>
				</table>
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			
	    	<!-- Button_Sub (E) -->
				</td></tr>
			</table>
	<!-- Grid BG Box  (S) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
	
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Reactivate">Reactivate</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (E)-->
	
	</td></tr>
		</table>
	


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>