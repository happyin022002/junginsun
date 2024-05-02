<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0215.jsp
*@FileTitle : Tariff Detail Information_Pop_Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.07.14 김완규
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0215Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0215Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= ""; 
	String trf_no			= "";

	trf_no = JSPUtil.getParameter(request, "trf_no");
	
	Logger log = Logger.getLogger("com.hanjin.apps.AgreementManage.TariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0215Event)request.getAttribute("Event");
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
<title>Tariff Detail Information</title>
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
<script language="javascript">ComSheetObject('sheet1');</script>
</head>

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   Tariff Detail Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:879;"> 
				<tr class="h23">
					<td width="60">Tariff No.</td>
					<td width=""> <input name="search_trf_no" type="text" style="width:130" class="input2" value="<%=trf_no%>">&nbsp;<!-- img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"--></td>
				</tr> 
				</table>			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Eff. from </td>
					<td width="100"><input type="text" name="eff_dt" style="width:80;text-align:center" class="input2">&nbsp;<!-- img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"--></td>
					<td width="100">Tariff Office</td>
					<td width="90"><input type="text" name="rqst_ofc_cd" style="width:70" class="input2"></td>
					<td width="105">S/Provider Code</td>
					<td width="270"><input type="text" name="vndr_seq" style="width:60;text-align:center" class="input2" dataformat="engup" maxlength="6">&nbsp;<input type="text" name="vndr_nm" style="width:180" class="input2" readonly="readonly"></td>
					<td width="50">Status</td>
					<td width="" style="padding-left:3"><script language="javascript">ComComboObject('combo1', 1, 145, 1, 0);</script></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">EQ Type </td>
					<td width="100" style="padding-left:2;"><script language="javascript">ComComboObject('combo2', 1, 80, 1, 0);</script></td>
					<td width="100">Unit Of Measure</td>
					<td width="90" style="padding-left:0"><script language="javascript">ComComboObject('combo3', 1, 70, 1, 0);</script></td>
					<td width="60">Currency</td>
					<td width="115" style="padding-left:3"><script language="javascript">ComComboObject('combo4', 1, 80, 1, 0);</script></td>
					<td width="89">Creation Date</td>
					<td width="105"><input type="text" name="cre_dt" style="width:80;text-align:center" class="input2" readonly="readonly"></td>
					<td width="90">Creation User</td>
					<td width=""><input type="text" name="cre_usr_id" style="width:105;text-align:left" class="input2" readonly="readonly"></td>
				</tr> 
				</table>			
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							
				<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
			<!-- Tab (E) -->
				
<!-- TAB Dry All (S) -->
<div id="tabLayer" style="display:inline">

				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->

</div>
<!-- TAB Dry All (E) -->
				
<!-- TAB Reefer Box (S) -->
<div id="tabLayer" style="display:none">
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
</div>
<!-- TAB Reefer Box (E) -->


<!-- TAB Reefer Unit (S) -->
<div id="tabLayer" style="display:none">
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
</div>
<!-- TAB Reefer Box (E) -->

<!-- TAB Reefer Unit (S) -->
<div id="tabLayer" style="display:none">
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
</div>
<!-- TAB Reefer Box (E) -->

<!-- TAB Chassis (S) -->
<div id="tabLayer" style="display:none">
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t5sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
</div>
<!-- TAB Chassis (E) -->
<!-- TAB MG Set (S) -->
<div id="tabLayer" style="display:none">
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t6sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
</div>
<!-- TAB MG Set (E) -->
	       <table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			<td width="" valign="top" style="padding: 20 0 0 0">
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr><td class="tr2_head" width="100">Remark(s)</td>  
					<td>     
					<textarea name="mnr_trf_rmk" wrap="off" style="width:100%;height:60;" readOnly></textarea>
					</td>  
				</tr> 
				</table>
			</td>
			</tr>
			</table>


			</td></tr>
			</table>
	    	

<table class="height_5"><tr><td></td></tr></table>
	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
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
		</table>
</td></tr>
</table> 
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
			
</body>
</html>
