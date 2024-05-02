<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1174.jsp
*@FileTitle : NMC (Non-Manipulation Certificate)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.03
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2014.04.03 조인영
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
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg1174Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1174Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	try {
		event = (EsmBkg1174Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {	
		out.println(e.toString());
	}
%>
<html>
<head>
<title>NMC (Non-Manipulation Certificate)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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

<body onLoad="setupPage();">
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
		
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" ID="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">

					<td width="80">Booking No.</td>
					<td width="130"><input type="text" name="bkg_no" style="width:110;" class="input" maxlength="13" dataformat="engup"></td>
					<td width="50">B/L No.</td>
					<td width="140"><input type="text" name="bl_no" style="width:110;" class="input" maxlength="13" dataformat="engup"></td>
					<td width="65">CNTR No.</td>
					<td width="140"><input type="text" name="cntr_no" style="width:110;" class="input" maxlength="13" dataformat="engup"></td>
					<td width="400">
				</tr>
				</table>

				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	

		<table class="search"> 
       		<tr><td class="bg_b1" height="496" width="860">	
			
			<!-- Grid  (S) -->
			<table width="100%" height="100%" class="grid"> 
			<tr class="tr_head">
				<td height="450" width="860"><script language="javascript">comRdObject('report1');</script></td>
			</tr>			
			</table> 
			<!-- Grid (E) -->	
			
			</td></tr>
		</table>

		<!--biz page (E)-->
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
	
</td></tr>
</table> 

</form>
</body>
</html>
<DIV style="display:none">
		<!-- Grid  (S) --> 
		<table width="100%" class="search"  id="mainTable"> 
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 			
		<!-- Grid (E) -->
		
		<!-- Grid  (S) -->
		<table width="100%" class="search"  id="mainTable">
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table> 			
		<!-- Grid (E) --> 
</DIV>