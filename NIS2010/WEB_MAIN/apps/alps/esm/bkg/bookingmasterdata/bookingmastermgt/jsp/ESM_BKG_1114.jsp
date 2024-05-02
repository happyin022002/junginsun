<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1114.jsp
*@FileTitle : ZIP Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.09
*@LastModifier : 김현화
*@LastVersion : 1.0
* 2010.12.09 김현화
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1114Event"%>
<%@ page import="org.apache.log4j.Logger" %>



<%
	EsmBkg1114Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingMasterMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmBkg1114Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//log.debug("====================================");
	//	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//	screenName = screen.getName();
	//	log.debug("====================================");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// 검색조건의 초기화 값을 request로부터 설정
  	String zipCodeFunc       = JSPUtil.getNull(request.getParameter("func"));
  	String zipCode   		 = JSPUtil.getNull(request.getParameter("zip_cd"));
  	String cntCd			 = JSPUtil.getNull(request.getParameter("cnt_cd"));
%>

<html>
<head>
<title>Zip Code Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

<%
	if(!zipCodeFunc.equals("")) {
%>
	if(!opener)
	opener = window.dialogArguments;
	
	var callbackMethod = opener.<%= zipCodeFunc%>;
<%
	} else{
%>
	var callbackMethod = null; 
<%
	}
%>

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
<input type="hidden" name="sheet_user_id" value="<%= strUsr_id %>">
<input type="hidden" name="sheet_ofc_cd" value="<%= strOfc_cd %>">
<input type="hidden" name="sheet_cnt_cd" value="<%= cntCd %>">

 <%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>      

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="65">Country</td>
					<td style="padding-left:2;">
					<script language="javascript" >ComComboObject('cnt_cd', 1, 170, 1,1)</script>
										<!--
					<td width="200"><select style="width:102;" class="input">
						<option value="0" selected>Korea</option>
						<option value="1"></option>
						<option value="2"></option></select>-->
					</td>
					<td width="" colspan="2"><input type="checkbox" name="delt_flg" value="Y" class="trans">&nbsp;&nbsp;Including Deleted Code</td>
				</tr>	
				<tr class="h23">
					<td width="">ZIP Code</td>
					<td width=""><input type="text" name="zip_cd" style="width:100;" class="input" value="<%=zipCode%>" dataformat="etc"></td>
					<td width="178" style="padding-left:5">Street / P.O Box (Address)</td>
					<td width=""><input type="text" name="zip_dtl_addr" style="width:300;" class="input" value="" dataformat="etc"></td>
				</tr>	
				<tr class="h23">
					<td width="">City</td>
					<td width=""><input type="text" name="cty_nm"  style="width:100;" class="input" value="" dataformat="etc"></td>
					<td width="170" style="padding-left:5">State</td>
					<td width=""><input type="text" name="ste_nm"style="width:200;" class="input" value="" dataformat="etc"></td>
				</tr>	
				</table>
				
	<!--  biz_1   (E) -->			
	   <table class="height_10"><tr><td colspan="8"></td></tr></table>
			<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
<%
if(mainPage.equals("true")){
%>			
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="inq">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="inq">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete"> Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="inq">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Load_Excel">Excel Import</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
<%
}
%>	 			
	    	<!-- Button_Sub (E) -->
   	
	<!-- Grid BG Box  (S) -->
	</td>
	</tr>	
	</table>
				
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
						</td>
<%
if(mainPage.equals("true")){
%>			 			
				<td class="btn1_line" id="inq"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="inq">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

<%
}
%>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_down_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (E)-->

<%
if(!mainPage.equals("true")){
%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
			
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
								<td class="btn1_line"></td>
			              	    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                <tr><td class="btn1_left"></td>
				                	    <td class="btn1" name="btn_Select">Select</td>
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
<script>
	if(typeof(document.getElementById("title")) != "undefined"){
		document.getElementById("title").innerHTML = curTitle;
		document.body.className ="popup_bg";
	}
</script>
<%
}
%>

<!-- 개발자 작업  끝 -->

</form>
</body>
</html>