<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0231.jsp
*@FileTitle : e-Booking & SI Process - Copy Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.03 전용진
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0231Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0231Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	// Main에서 Parameter 받기
	String callFunc = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0231Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		callFunc  = JSPUtil.getParameter(request, "func");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & SI Process - Copy Option</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cust_nis" value="<%=StringUtil.xssFilter(request.getParameter("cust_nis"))%>">
<input type="hidden" name="cust_esvc" value="<%=StringUtil.xssFilter(request.getParameter("cust_esvc"))%>">
<input type="hidden" name="cntr_nis" value="<%=StringUtil.xssFilter(request.getParameter("cntr_nis"))%>">
<input type="hidden" name="cntr_esvc" value="<%=StringUtil.xssFilter(request.getParameter("cntr_esvc"))%>">
<input type="hidden" name="mnd_nis" value="<%=StringUtil.xssFilter(request.getParameter("mnd_nis"))%>">
<input type="hidden" name="mnd_esvc" value="<%=StringUtil.xssFilter(request.getParameter("mnd_esvc"))%>">
<input type="hidden" name="cm_nis" value="<%=StringUtil.xssFilter(request.getParameter("cm_nis"))%>">
<input type="hidden" name="cm_esvc" value="<%=StringUtil.xssFilter(request.getParameter("cm_esvc"))%>">
<input type="hidden" name="tro_nis" value="<%=StringUtil.xssFilter(request.getParameter("tro_nis"))%>">
<input type="hidden" name="tro_esvc" value="<%=StringUtil.xssFilter(request.getParameter("tro_esvc"))%>">
<input type="hidden" name="rf_nis" value="<%=StringUtil.xssFilter(request.getParameter("rf_nis"))%>">
<input type="hidden" name="rf_esvc" value="<%=StringUtil.xssFilter(request.getParameter("rf_esvc"))%>">
<input type="hidden" name="dg_nis" value="<%=StringUtil.xssFilter(request.getParameter("dg_nis"))%>">
<input type="hidden" name="dg_esvc" value="<%=StringUtil.xssFilter(request.getParameter("dg_esvc"))%>">
<input type="hidden" name="ak_nis" value="<%=StringUtil.xssFilter(request.getParameter("ak_nis"))%>">
<input type="hidden" name="ak_esvc" value="<%=StringUtil.xssFilter(request.getParameter("ak_esvc"))%>">
<input type="hidden" name="bb_nis" value="<%=StringUtil.xssFilter(request.getParameter("bb_nis"))%>">
<input type="hidden" name="bb_esvc" value="<%=StringUtil.xssFilter(request.getParameter("bb_esvc"))%>">
<input type="hidden" name="hbl1_nis" value="<%=StringUtil.xssFilter(request.getParameter("hbl1_nis"))%>">
<input type="hidden" name="hbl1_esvc" value="<%=StringUtil.xssFilter(request.getParameter("hbl1_esvc"))%>">
<input type="hidden" name="hbl2_nis" value="<%=StringUtil.xssFilter(request.getParameter("hbl2_nis"))%>">
<input type="hidden" name="hbl2_esvc" value="<%=StringUtil.xssFilter(request.getParameter("hbl2_esvc"))%>">
<input type="hidden" name="callFunc" value="<%=callFunc%>">

<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;e-Booking Upload Copy </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->

			<table class="search"> 
       		<tr><td class="bg">

							<table width="350" id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>

		    <!-- : ( Button : Grid ) (E) -->	

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
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td id="unchk" style="display:"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_uncheckall">Uncheck&nbsp;All</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td id="chk" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_checkall">Check&nbsp;All</td>
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
			
</form>			
</body>
</html>