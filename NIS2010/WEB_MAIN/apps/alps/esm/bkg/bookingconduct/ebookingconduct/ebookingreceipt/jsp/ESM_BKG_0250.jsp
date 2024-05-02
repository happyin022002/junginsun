<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0250.jsp
*@FileTitle : Booking History (B/L Data)
*Open Issues : ESM_BKG_0250 화면
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.04 이남경
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0250Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0250Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
/*	
	int rowCount	   = 0;						//DB ResultSet 리스트의 건수	
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
*/	
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSearch");
	
	try {	
/* 		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
*/ 
		event = (EsmBkg0250Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="com_mrdPath"      value="">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="xter_sndr_id" value="<%=StringUtil.xssFilter(request.getParameter("xter_sndr_id"))%>">
<input type="hidden" name="xter_rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("xter_rqst_no"))%>">
<input type="hidden" name="xter_rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("xter_rqst_seq"))%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  Booking History</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="83">Booking No.</td>
					<td width="150"><input type="text" style="width:120;" class="input2" name="bkg_no" value="" readonly></td>
					<td width="56">1st VVD</td>
					<td width="150"><input type="text" style="width:120;" class="input2" name="n1st_vvd" value="" readonly></td>			
					<td width="45">T/VVD</td>
					<td width="">   <input type="text" style="width:120;" class="input2" name="trnk_vvd" value="" readonly></td>		
				</tr> 
				<tr class="h23">
					<td>B/L No.</td>
					<td><input type="text" style="width:120;" class="input2" value="" name="bl_no"    readonly></td>
					<td>POL</td>
					<td><input type="text" style="width:120;" class="input2" value="" name="n1st_pol" readonly></td>			
					<td>POL</td>
					<td><input type="text" style="width:120;" class="input2" value="" name="trnk_pol" readonly></td>	
				</tr> 
				<tr class="h23">
					<td>Port Closing</td>
					<td><input type="text" style="width:120;" class="input2" value="" name="port_closing" readonly></td>
					<td>ETB</td>
					<td><input type="text" style="width:120;" class="input2" value="" name="n1st_etb" readonly></td>			
					<td>ETB</td>
					<td><input type="text" style="width:120;" class="input2" value="" name="trnk_etb" readonly></td>						
				</tr> 
				<tr class="h23">
					<td>BDR</td>
					<td><input type="text" style="width:120;" class="input2" value="" name="bdr_dt" readonly></td>
					<td>ETD</td>
					<td><input type="text" style="width:120;" class="input2" value="" name="n1st_etd" readonly></td>			
					<td>ETD</td>
					<td><input type="text" style="width:120;" class="input2" value="" name="trnk_etd" readonly></td>						
				</tr> 
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="560"></td>					
					<td width="110"><input type="checkbox" name="ca_only"  value="Y" class="trans">C/A Only</td>
					<td width="100">Search by Item</td>
					<td width="" class="stm">
					    <script language="javascript">ComComboObject('search_by_item', 1, 100, 1);</script>
					</td>	
				</tr>
				</table>					
				<!--  biz_1   (E) -->
				

		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
				
				
				
<!--TAB B/L Data (S) -->
<div id="tabLayer" style="display:inline">
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
</div>
<!--TAB B/L Data (E) -->

<!--TAB FAX/EDI (S) -->
<div id="tabLayer" style="display:none">
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
</div>
<!--TAB FAX/EDI (E) -->

<!--TAB Customs (S) -->
<div id="tabLayer" style="display:none">
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>
</div>
<!--TAB Customs (E) -->

<!--TAB Documentation (S) -->
<div id="tabLayer" style="display:none">
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>
</div>
<!--TAB Documentation (E) -->

		</td></tr></table>
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
					<td class="btn1" name="btn_print">Print</td>
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

<!-- RD (S) -->
<table>
    <tr>
      <td height="1" width="1">
          <script language="javascript">comRdObject('report1');</script>
      </td>
   </tr>	
</table>
<!-- RD (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      /* 
       * 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분
       */
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo = event.getBkgBlNoVO().getBkgNo();
        %>
            eval("bkg_no").value = "<%=bkgNo%>"; 
        <% } %>
       }
-->
</SCRIPT>
