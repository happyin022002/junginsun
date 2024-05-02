<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0001.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : minestar
*@LastVersion : 2.0
* 2008-03-03 minestar
* 1.0 
=========================================================*/
%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.copreport.cophsitory.event.EsdSce0071Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;


	EsdSce0071Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//
	String strErrMsg = "";						//
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String userId		= "";
	String userNm		= "";

	
	try {

			event = (EsdSce0071Event)request.getAttribute("Event");
			serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

			if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			// 
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		}catch(Exception e) {
			out.println(e.toString());
		}	
%>

<%
String szCOPNo = request.getParameter( "cop_no");
%>

<html>
<head>
<title>Welcome to NMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<script language="javascript">

    function setupPage(){
        loadPage();
        <% if( szCOPNo!= null && szCOPNo.length() > 0 ) {%>
	       	document.getElementById ("cop_no").value = "<%=szCOPNo%>";
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		<%}%>
    }

</script>
<body onLoad="setupPage();">

	<form name="form" method="post">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="pagerows" value="<%=pageRows%>">
		<input type="hidden" name="page_no" value="1">		
		
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
							<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
							<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
						</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

        <% if( szCOPNo == null || szCOPNo.length() <= 0 ) {%>
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr><td class="btn1_bg">

										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
											<td class="btn1_line"></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
						</table>

		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr>
			<td class="bg">
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="80">Booking No. </td>
					<td width="200"><input name="bkg_no" type="text" style="width:120 ; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
					<td width="55">B/L No.</td>
					<td  width="200"><input name="bl_no" type="text" style="width:110px ; text-transform:uppercase;"  Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();'></td>
					<td width="65">CNTR No.</td>
					<input name ="cntr_no" id ="cntr_no" type = "hidden" value ="">
					<td width="200"><input name="cntr_no_nonbit" type="text" style="width:100px ; text-transform:uppercase;" Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigitSplit(this,'cntr_no_split', 'cntr_no')"  onKeyUp="CheckDigitSplit(this, 'cntr_no_split', 'cntr_no')"> <input id ="cntr_no_split" type="text" style="width:22" maxlength="2" readonly></td>
					<td width="60">COP No.</td>
					<td width=""><input name="cop_no" type="text" style="width:110px; text-transform:uppercase;" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();'></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<%} else {%>
		<input name="cop_no" type="hidden"/>
		<%} %>
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
	    	<table class="search">
	      	<tr><td class="bg">
				<!-- : ( grid ) (S) -->
				<table width="100%" id="mainTable">
				<tr><td>
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td></tr>
				</table>
				<!-- : ( grid ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
</td></tr>
</table>
<!-- OUTER - (E)nd -->
	</form>
</body>
</html>







