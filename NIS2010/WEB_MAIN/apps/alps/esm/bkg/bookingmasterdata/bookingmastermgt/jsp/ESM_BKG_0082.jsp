<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0082.jsp
*@FileTitle : Booking Creation 1_MT P/UP CY inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0082Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0082Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strLocCd			= "";
	String strYdCd			= "";
	String calllFunc 		= "";
	String callSheetIdx		= "";
	
	//Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingMasterMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0082Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		if (JSPUtil.getParameter(request, "searcheKeyOpener").length() > 4){
			strLocCd =  JSPUtil.getParameter(request, "searcheKeyOpener").substring(0,5);
			if (JSPUtil.getParameter(request, "searcheKeyOpener").length() > 4){
				strYdCd  =  JSPUtil.getParameter(request, "searcheKeyOpener").substring(5, JSPUtil.getParameter(request, "searcheKeyOpener").length());
			}else{
				strYdCd  =  JSPUtil.getParameter(request, "searcheKeyOpener");
			}
		}else{
			strLocCd =  JSPUtil.getParameter(request, "searcheKeyOpener");
		}
		// 호출할 부모창의 스크립트 메소드 (pop_mode가 1(function 호출형) 인 경우)
		calllFunc  = JSPUtil.getParameter(request, "func");
		callSheetIdx  = JSPUtil.getParameter(request, "callSheetIdx"); 
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Creation 1_MT P/UP CY inquiry</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="selectSheetYdCd">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="callSheetIdx" value="<%=callSheetIdx%>">
<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; MT Pick Up CY Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search" width="684"> 
       		<tr><td class="bg">
			<table class="search" border="0" style="width:480;"> 
				<tr class="h23">
					<td width="70">Yard Code</td>
					<td width=""><input type="text" name="loc_cd" style="width:50;" class="input1" value="<%=strLocCd %>" maxlength="5" style="ime-mode:disabled" dataformat="engup" caption="Yard"  fullfill>&nbsp;<input type="text" name="yd_cd"  style="width:30;" class="input" value="<%=strYdCd %>" maxlength="2" style="ime-mode:disabled" dataformat="uppernum" caption="Yard"  fullfill>
					</td>
					</tr>
				</table>
				<table class="search" border="0"> 
				<tr class="h23">
				<td width="20%">
				<!-- : ( Grid ) (S) -->
				<table width="92%" class="search"  id="leftTable"> 
                     <tr>
                         <td width="120">
                         <script language="javascript">ComSheetObject('sheet1');</script>
                         </td>
                     </tr>
                 </table>
				</td>
				<td valign="top">
				<table style="height:16;"><tr><td></td></tr></table>
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr><td class="tr2_head" width="20%">Yard Name</td>
					<td class="input2" width="" colspan="3">
					<input type="text" style="width:100%;text-align:left;" class="input2" name="yd_nm"  readonly>
					</td>
					</tr>
				<tr><td class="tr2_head" width="20%">Tel</td>
					<td class="input2" width="30%">
					<input type="text" style="width:100%;text-align:left;" class="input2" name="phn_no"  readonly>
					</td> 
					<td class="tr2_head" width="20%">P.I.C</td>
					<td class="input2" width="">
					<input type="text" style="width:100%;;text-align:left;" class="input2" name="yd_pic_nm"  readonly>
					</td> 
					</tr>
				</table>
				<table style="height:16;"><tr><td></td></tr></table>
				<!-- : ( Grid ) (S) -->
				<table width="100%" class="search"  id="rightTable"> 
                     <tr>
                         <td width="100%">
                         <script language="javascript">ComSheetObject('sheet2');</script>
                         </td>
                     </tr>
                 </table>
                 
				</td>
				</tr>
				
				
		</table>
		    <!-- : ( Button : Grid ) (E) -->
		    <font bold color="red">* </font>EQ Inventory information is subject to local situation. <br> For accurate information, please contact your local operation department directly.
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
