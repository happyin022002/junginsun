<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0652.jsp
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.04 김병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0652Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0652Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	// Main에서 Parameter 받기
	String calllFunc = "";
	String bkgCustTpCd = "";
	String custCntCd = "";
	String custSeq = "";
	String custNm = "";
	String ctyNm ="";
	String steCd ="";
	String zipCd ="";
	String uiId = "";
	String sofcCd = "";
	String srepCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0652Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		calllFunc  = JSPUtil.getParameter(request, "func");
		bkgCustTpCd  = JSPUtil.getParameter(request, "bkg_cust_tp_cd");		
		custCntCd  = JSPUtil.getParameter(request, "cust_cnt_cd");
		custSeq  = JSPUtil.getParameter(request, "cust_seq");
		custNm = JSPUtil.getParameter(request, "cust_nm");
		ctyNm     = JSPUtil.getNull(request.getParameter("cty_nm")); 
		steCd     = JSPUtil.getNull(request.getParameter("ste_cd")); 
		zipCd     = JSPUtil.getNull(request.getParameter("zip_cd")); 
		uiId     = JSPUtil.getNull(request.getParameter("ui_id")); 
		sofcCd     = JSPUtil.getNull(request.getParameter("sofc_cd")); 
		srepCd     = JSPUtil.getNull(request.getParameter("srep_cd")); 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Customer Inquiry</title>
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
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="bkgCustTpCd" value="<%=bkgCustTpCd%>">
<input type="hidden" name="ui_id" value="<%=uiId%>">
<input type="hidden" name="sofc_cd" value="<%=sofcCd%>">
<input type="hidden" name="srep_cd" value="<%=srepCd%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Customer Code Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<!-- 1 (S) -->		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="40">Code</td>
						<td width="90"><input type="text" name="cust_cnt_cd" style="width:20;text-align:center;" class="input1" value="<%=custCntCd %>" style="ime-mode:disabled"  maxlength=2 dataformat="engup">&nbsp;<input type="text" name="cust_seq" style="width:60;text-align:center;" class="input" value="<%=custSeq %>" style="ime-mode:disabled"  maxlength=6 dataformat="int"></td>			
						<td width="40">Name</td>
						<td width="300"><input type="text" name="cust_nm" style="width:390;" class="input" style="ime-mode:disabled" value="<%=custNm %>" onKeyUp="upper(this);"></td>
						<td width="20"><input type="checkbox" name="include" Style="border-style:none"></td>
						<td width="150">Inclusive </td>
						<td width="50">No Use </td>
						<td width="30"><input type="checkbox" name="no_use"  Style="border-style:none"></td>
						<td width="80">Financial Risk </td>
						<td width="20"><input type="checkbox" name="bklst"  Style="border-style:none" checked></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="40">S. OFC</td>
						<td width="50"><input type="text" name="ofc_cd" style="width:80;" class="input" style="ime-mode:disabled" dataformat="engup"></td>	
						<td width="40">City</td>
						<td width="50"><input type="text" style="width:80;" class="input" name="cty_nm" dataformat='engup' maxlength='10' style="ime-mode:disabled" value="<%=ctyNm%>"></td> 
						<td width="40">State</td>
						<td width="50"><input type="text" style="width:70;" class="input" name="ste_cd" dataformat='engup' maxlength='3'  style="ime-mode:disabled" value="<%=steCd%>"></td> 
						<td width="60">Zip Code</td>
						<td width="50"><input type="text" style="width:60;" class="input"  name="zip_cd" dataformat='zipcode' maxlength='10' style="ime-mode:disabled" value="<%=zipCd%>"></td>
						<td width="72">Area Code</td>
						<td width="270"><input type="text" style="width:60;" class="input"  name="area_cd" dataformat='zipcode' maxlength='3' style="ime-mode:disabled"></td>			 
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
				
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			<!-- Grid 1,2 (S) -->
			<table class="search">
			<tr><td valign="top" width="75%">	

					<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>					
					<!-- Grid - 1 (E) -->
				
				<table class="search" border="0" style="width:100%;"> 
<!-- 				<tr><td  class="stm">P-Premium / B-Black listed</td> 
				</tr> -->
				</table>	
				</td>
				
				<td valign="top" style="padding-left:10px;">	

					<!-- Grid - 2 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>					
					<!-- Grid - 2 (E) -->	
				
				</td></tr>
			</table>
			<!-- Grid 1,2 (E) -->
			
		</td></tr>
		</table>
		<!-- 1 (E) -->		
		

		<!-- 2 (S) -->		
		<table class="height_8"><tr><td></td></tr></table>	
		

		<table class="search" id="mainTable" <%if(uiId.equals("ESM_BKG_0079_05")){%> height="0" <% } %>>
       		<tr height="0"><td class="bg" <%if(uiId.equals("ESM_BKG_0079_05")){%> height="0" <% } %>>	
				
					<!-- Grid - 3 (S) -->
				<table width="100%"  id="mainTable" <%if(uiId.equals("ESM_BKG_0079_05")){%> height="0" <% } %>> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>					
					<!-- Grid - 3 (E) -->
<%
if(!uiId.equals("ESM_BKG_0079_05")){
%>				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
<%
}
%>	    	
	
			
		</td></tr>
		</table>
		<!-- 2 (E) -->	
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
				<td class="btn1_line"></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
				<td class="btn1_line"></td>		
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