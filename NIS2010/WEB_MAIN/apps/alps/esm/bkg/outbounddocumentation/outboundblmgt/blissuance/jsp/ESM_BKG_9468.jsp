<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_9468.jsp
*@FileTitle : Web OB/L Paper Management History
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.19
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2015.10.19 조정민
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9468Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EsmBkg9468Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	// Main에서 Parameter 받기
	String dtrbYr = "";
	String rhqCd = "";
	String ofcCd  = "";
	String custCntCd = "";
	String custSeq  = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg9468Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		dtrbYr  = JSPUtil.getParameter(request, "dtrb_yr"); 
		rhqCd  = JSPUtil.getParameter(request, "rhq_cd"); 
		ofcCd  = JSPUtil.getParameter(request, "ofc_cd"); 
		custCntCd  = JSPUtil.getParameter(request, "cust_cnt_cd"); 
		custSeq  = JSPUtil.getParameter(request, "cust_seq"); 

		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Web OB/L Paper Management History</title>
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
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Web OB/L Paper Management History</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		
		<table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            <table class="search" border="0" style="width:100%;">
              <tr class="h23">
                <td width="40">Year</td>
           		<td width="75"><input type="text" name="dtrb_yr" style="width:60;" maxlength="5" dataformat="engupnum" class="input1" value="<%= dtrbYr%>"></td>
                <td width="40">RHQ</td>
                <td width="85"><input type="text" name="rhq_cd" style="width:60;" maxlength="5" dataformat="engupnum" class="input1" value="<%= rhqCd%>"></td>
                <td width="45">Office</td>
                <td width="85"><input type="text" name="ofc_cd" style="width:60;" maxlength="6" dataformat="engupnum" class="input1" value="<%= ofcCd%>"></td>
				<td width="70">Customer</td>
				<td width="26"><input type="text" name="cust_cnt_cd" style="width:25;" maxlength="2" dataformat="engup" class="input" value="<%= custCntCd%>"></td>
				<td width="51"><input type="text" name="cust_seq" style="width:50;" maxlength="6" dataformat="int"  class="input" value="<%= custSeq%>"></td>

				<td>&nbsp;</td>
              </tr>
            </table>
       	</table>
       
		<table class="height_5"><tr><td></td></tr></table>
		<table class="search"> 
       		<tr><td class="bg">
				<!-- : ( Grid ) (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table> 
				<!-- : ( Grid ) (E) -->	
			
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
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
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