<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1515.jsp
*@FileTitle : Terminal EDI Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.10
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.06.10 문동선
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1515Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1515Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingProcessMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();

		event = (EsmBkg1515Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		log.debug("====================================");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Terminal EDI Setup</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="strSlanCd">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->   
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>   
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
    </table>   
	<!--Page Title, Historical (E)) -->
		
	<!--biz page (S)-->
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">
			<table class="search" border="0" style="width:900;"> 
			<tr class="h23">
				<td width="40">YARD</td>
				<td width="100"><input type="text" name="yd_cd" style="width:80;" value="" style="ime-mode:disabled" dataformat="engupnum" maxlength="7" ></td>
				<td width="40">PORT</td>
				<td width="100"><input type="text" name="port_cd" style="width:60;" value="" style="ime-mode:disabled" dataformat="engupnum" maxlength="5"  ></td>
				<td width="180">RCV EDI ID</td>
				<td width="120"><input type="text" name="edi_rcv_id" style="width:100;" value="" style="ime-mode:disabled" dataformat="engupnum" maxlength="30"  ></td>
				<td width="180">SEND EDI ID</td>
				<td width="120"><input type="text" name="edi_snd_id" style="width:100;" value="" style="ime-mode:disabled" dataformat="engupnum" maxlength="30"  ></td>								
				<td width="210">Rlse EDI Type</td>
				<td width="290">
				<select name="full_rlse_edi_cd" style="width:100;" class="input">
                    <option value="" selected>ALL</option>				
                    <option value="1">FO</option>
                    <option value="2">FOC</option>
                  </select>
				</td>				
			</tr> 
			</table>			
		</td></tr>
		</table>
		<!--biz page (E)-->
	<table class="height_8"><tr><td></td></tr></table>
		
	<!--biz page (S)-->
	
	<table class="search" id="mainTable"> 
 		<tr><td class="bg">				
			
			<table class="height_5"><tr><td></td></tr></table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
		</td></tr></table>
		<!--biz page (E)--> 

		<table class="height_5"><tr><td></td></tr></table>

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_history">History</td>
					<td class="btn1_right">
				</tr></table></td>								
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down Excel</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr></table>
			</td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<div id="downSheet" style="display:none">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>