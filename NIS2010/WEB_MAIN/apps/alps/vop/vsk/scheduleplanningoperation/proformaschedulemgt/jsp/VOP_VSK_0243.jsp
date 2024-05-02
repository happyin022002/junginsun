<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0243.jsp
*@FileTitle : EOTP 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.05 서창열
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0243Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Enumeration" %>

<%
	VopVsk0243Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.SchedulePlanningOperation.ProformaScheduleMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0243Event)request.getAttribute("Event");
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
<title>EOTP </title>

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

<body  class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="eventNav">
<input type="hidden" name="portNm">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;EOTP Creation  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:960;"> 
				<tr class="h23">
					<td width="130">History Performance </td>   
					<td width="130"><select style="width:67;" class="input1" name="hist_yr">
						<option value="365" selected>1 Year</option>
						<option value="730">2 Years</option>
						</select></td>
					<td width="70">VSL Class</td>
					<td width=""><input type="text" style="width:50;text-align:center" class="input2" name="n1st_vsl_clss_cd" value="" readOnly>&nbsp;<input type="text" style="width:20;text-align:right" class="input2" name="n1st_vsl_clss_knt" value="" readOnly>&nbsp;&nbsp;&nbsp;<input type="text" style="width:50;text-align:center" class="input2" name="n2nd_vsl_clss_cd" value="" readOnly>&nbsp;<input type="text" style="width:20;text-align:right" name="n2nd_vsl_clss_knt" class="input2" value="" readOnly>&nbsp;&nbsp;&nbsp;<input type="text" style="width:50;text-align:center" class="input2" name="n3rd_vsl_clss_cd" value="" readOnly>&nbsp;<input type="text" style="width:20;text-align:right" class="input2" name="n3rd_vsl_clss_knt" value="" readOnly>&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="370">
				<!-- : ( Grid ) (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table> 				

				<!-- : ( Grid ) (E) -->	
				</td>
				<td width="10"></td>
				<td width="580">
				<!-- : ( Grid ) (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table> 				

				<!-- : ( Grid ) (E) -->	
				</td>
				</tr>
				</table>
		    
			
			
				<table class="search" style="width:100%;" border="0"> 
				<tr class="h23">
					<td width="715"></td>
					<td width="40">EOTP1</td>   
					<td width="100"><input type="text" style="width:70;text-align:right" name="eotp01" class="input2" value="" readOnly></td>
					<td width="40">EOTP2</td>   
					<td width=""><input type="text" style="width:70;text-align:right" name="eotp02" class="input2" value="" readOnly></td>
				</tr>
				</table>
			
			
			
			
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
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
								</tr>
								</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
								</tr>
								</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
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