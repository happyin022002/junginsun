<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1170.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 임재관
*@LastVersion : 1.0
* 2012.02.15 임재관
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1170Event"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1170Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");
	
	String[] svcScpCds = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1170Event)request.getAttribute("Event");
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
<title>booking report</title>
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
<input type="hidden" name="tab_cd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

	<!--Page Title, Historical (E)-->
	<table class="search"> 
       	<tr><td class="bg">
       	
<div id="msvcScpCd" style="margin-top:0px;margin-left:700px; position: absolute; display: none;" >
 	<table width="130" border="0"  cellpadding="0" cellspacing="0" >
		<tr>
			<td width = "100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
		</tr>
	</table> 

	<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
		<tr><td class="btn2_left"></td>
			<td class="btn2" id="svc_scp_list_add" name="svc_scp_list_add">&nbsp;Add&nbsp;</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="svc_scp_list_del" name="svc_scp_list_del">Del</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="svc_scp_list_ok" name="svc_scp_list_ok">OK</td>
			<td class="btn2_right"></td>
		</tr>
	</table>
</div>	     

<div id="bkgOfcList" style="margin-top:0px;margin-left:400px; position: absolute; display: none;" >
 	<table width="130" border="0"  cellpadding="0" cellspacing="0" >
		<tr>
			<td width = "100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
		</tr>
	</table> 

	<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
		<tr><td class="btn2_left"></td>
			<td class="btn2" id="ofc_list_add" name="ofc_list_add">&nbsp;Add&nbsp;</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="ofc_list_del" name="ofc_list_del">Del</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="ofc_list_ok" name="ofc_list_ok">OK</td>
			<td class="btn2_right"></td>
		</tr>
	</table>
</div>	

<div id="ctrOfcList" style="margin-top:0px;margin-left:690px; position: absolute; display: none;" >
 	<table width="130" border="0"  cellpadding="0" cellspacing="0" >
		<tr>
			<td width = "100%"><script language="javascript">ComSheetObject('sheet3');</script></td>
		</tr>
	</table> 

	<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
		<tr><td class="btn2_left"></td>
			<td class="btn2" id="cofc_list_add" name="cofc_list_add">&nbsp;Add&nbsp;</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="cofc_list_del" name="cofc_list_del">Del</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="cofc_list_ok" name="cofc_list_ok">OK</td>
			<td class="btn2_right"></td>
		</tr>
	</table>
</div>	

<div id="pOfcList" style="margin-top:0px;margin-left:690px; position: absolute; display: none;" >
 	<table width="130" border="0"  cellpadding="0" cellspacing="0" >
		<tr>
			<td width = "100%"><script language="javascript">ComSheetObject('sheet4');</script></td>
		</tr>
	</table> 

	<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
		<tr><td class="btn2_left"></td>
			<td class="btn2" id="pofc_list_add" name="pofc_list_add">&nbsp;Add&nbsp;</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="pofc_list_del" name="pofc_list_del">Del</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="pofc_list_ok" name="pofc_list_ok">OK</td>
			<td class="btn2_right"></td>
		</tr>
	</table>
</div>	


				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="30">Charge</td>
						<td width="120"><script language="javascript">ComComboObject('charge_cd', 1, 80, 0,1,0);</script></td>
						<td width="100"><label id="lbDate">Correction Date</label></td>
						<td width="240">
							<input type="text" name="fr_dt" style="width:80;" class="input1" value=""   dataformat="ymd" caption="Start Date" maxlength="10"  cofield="to_dt" required onFocus="this.select();">
							&nbsp;~&nbsp;
							<input type="text" name="to_dt" style="width:80;" class="input1" value=""    dataformat="ymd" caption="End Date" maxlength="10"  cofield="fr_dt" required onFocus="this.select();">
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')">
						</td>
						<td width="140" style="font-size:12;" class="stm">
							<input type="radio" class="trans" name="ctr_rfa_cd" value="C" checked>S/C
							<input type="radio" class="trans" name="ctr_rfa_cd" value="R">RFA
							<input type="radio" class="trans" name="ctr_rfa_cd" value="T">TAA
						</td>
						<td width="90">
							<input type="text" style="width:90;" class="input" maxlength='20' dataformat='engupnum' name="ctr_rfa_no" style="ime-mode:disabled" value="">
					    </td>
						
						<td width="170"></td>
					</tr>
					</table>
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="110">Booking RHQ</td>
								<td width="60"><script language="javascript">ComComboObject('p_rhq_bkg_ofc_cd', 2, 65, 0, 0, 0, false);</script></td>
						<td width="30"></td>		
						<td width="140">Booking GSO OFC</td>
						<td width="150" class="stm">
						<input type="text" name="p_gso_bkg_ofc_cd"  style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG OFC" >
								<img src="img/alps/button/btns_multisearch.gif" align="absmiddle"  style="cursor:hand" name="btn_multi_ofc"></td>
						<td width="70">C.RHQ</td>
						<td width="80"><input type="text" style="width:50" value="" name="p_rhq_ctrt_ofc_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
						<td width="70">C.OFC</td>
						<td width="150" class="stm">
						<input type="text" name="p_ctrt_ofc_cd"  style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG OFC" >
								<img src="img/alps/button/btns_multisearch.gif" align="absmiddle"  style="cursor:hand" name="btn_multi_cofc"></td>
						<td width="50">Scope</td>
					    <td width="220" class="stm">
								<input type="text" name="p_svc_scp_cd"  style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG OFC" >
								<img src="img/alps/button/btns_multisearch.gif" align="absmiddle"  style="cursor:hand" name="btn_multi_scp">
								</td>
					<td width="100"></td>
					</tr>
				</table>
			
				<table border="0">
					<tr class="h23" >
						<td width="35">POR</td>
						<td width="80"><input type="text" style="width:50" value="" name="p_por_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input">
						
						</td>
						<td width="35">POL</td>
						<td width="80"><input type="text" style="width:50" value="" name="p_pol_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
						<td width="35">POD</td>
						<td width="80"><input type="text" style="width:50" value="" name="p_pod_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
						<td width="35">DEL</td>
						<td width="88"><input type="text" style="width:50" value="" name="p_del_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
						<td width="500"><span id="id_lb_ofc">
										<span style="width:110px;"><label id="lbOfc">Correction Office</label></span>
										<span class="stm" style="width:130px;"><input type="text" name="p_sel_ofc_cd"  style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG OFC" >
											 <img src="img/alps/button/btns_multisearch.gif" align="absmiddle"  style="cursor:hand" name="btn_multi_pofc"></span>
									   </span>
										<span id="id_lb_ofc2" style="display:none">
										<span style="width:140px;"><label id="selOfc2">CCT-3rd party Office</label></span>
										<span class="stm"><input type="text" name="p_sel_ofc_cd2"  style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Prepaid OFC" >
											 <img src="img/alps/button/btns_multisearch.gif" align="absmiddle"  style="cursor:hand" name="btn_multi_pofc2"></span>
									   </span>									   
						</td>
					 <td id='td_info'></td>
					</tr>
				</table>     
				
				</td>
				</tr>
				</table>
				  		


		<table class="height_8"><tr><td></td></tr></table>	
		
		<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
			</table>
			
			
		<!-- Tab (E) -->

<!--TAB Summary View (S) -->

<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
       		
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->	
					
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>

<!--TAB Summary View (E) -->


<!--TAB Detail View (S) -->

<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>

<div id="pOfcList2" style="top:40px;margin-left:770px; position: absolute; display:none;" >
 	<table width="130" border="0"  cellpadding="0" cellspacing="0" >
		<tr>
			<td width = "100%"><script language="javascript">ComSheetObject('pOfcList2sheet');</script></td>
		</tr>
	</table> 

	<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
		<tr><td class="btn2_left"></td>
			<td class="btn2" id="pofc_list2_add" name="pofc_list2_add">&nbsp;Add&nbsp;</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="pofc_list2_del" name="pofc_list2_del">Del</td>
			<td class="btn2_right"></td>
			<td class="btn2_left"></td>
			<td class="btn2" id="pofc_list2_ok" name="pofc_list2_ok">OK</td>
			<td class="btn2_right"></td>
		</tr>
	</table>
</div>	
	
	</td></tr>
		</table>
	

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SaveExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BlInquiry">BL Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>