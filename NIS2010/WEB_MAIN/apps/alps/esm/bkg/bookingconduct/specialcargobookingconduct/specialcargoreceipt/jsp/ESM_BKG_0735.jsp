<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0735.jsp
*@FileTitle : Dangerous cargo application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.08 이병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0735Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0735Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String copyFlg = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmBkg0735Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		copyFlg =  JSPUtil.getParameter(request, "copyFlg");
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DG application copy</title>
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
<input type="hidden" name="copyFlg" value="<%=copyFlg%>">
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="from_bkg_no">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;DG Application Copy</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<% if(copyFlg.equals("Y")){ %>
					<table border="0" style="width:379;" class="search"> 
					<tr class="h23">
					<td colspan="2"><input name="radioChk1" type="hidden" value="1" class="trans">&nbsp;&nbsp;Copy Container Seq.(Copy all Cargo Seq.)</td>
					</tr>
					<tr class="h23">
					<td width="170">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No. of New Sequence</td>
					<td><input name="chk1text" type="text" style="width:150" value=""></td>
					</tr>
					</table> 
				
				<% }else{ %>
				
					<table border="0" style="width:379;" class="search"> 
					<tr class="h23">
					<td colspan="2"><input name="radioChk1" type="hidden" value="2" class="trans">&nbsp;&nbsp;Copy cargo Sequence</td>
					</tr>
					<tr class="h23">
					<td width="170"></td>
					<td style="padding-left:10">No. of New Seq.</td>
					</tr>
					<tr class="h23">
					<td width="170"><input name="radioChk2" type="radio" value="1" class="trans">&nbsp;&nbsp;To New CNTR Seq.</td>
					<td><input name="chk2text" type="text" style="width:150" value=" "></td>
					</tr>
					<tr class="h23">
					<td colspan="2"><input name="radioChk2" type="radio" value="2" class="trans">&nbsp;&nbsp;To Existing CNTR Seq.</td>
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
							
					<table class="height_5"><tr><td></td></tr></table>
					
					<div id="oldBkgDiv" style="visibility:hidden;">	
					<table border="0" style="width:379;" class="search"> 
					<tr class="h23">
					<td width="170"></td>
					<td style="padding-left:10">Original Booking No.</td>
					</tr>
					<tr class="h23">
					<td width="170"><input name="radioChk2" type="radio" value="3" class="trans">&nbsp;&nbsp;Copy From Old BKG</td>
					<td><input name="chk2text3" type="text" style="width:150" value=" "></td>
					</tr>
					</table>
					</div>
					
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table> 
					<!-- Grid (E) -->			
			<% } %>
			
			</td></tr>
		</table>
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="72" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0"> <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
					</tr></table>
			</td>	
				<td class="btn1_line"></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				
			</tr></table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>