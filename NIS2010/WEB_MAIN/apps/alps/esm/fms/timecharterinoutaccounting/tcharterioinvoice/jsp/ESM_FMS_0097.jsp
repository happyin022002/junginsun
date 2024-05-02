<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : esm_fms_0097.jsp
*@FileTitle : (New)Owner’s Account
*@LastModifyDate : 2016.02.22
*@LastModifier : 
*@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0097Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0097Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지 

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0097Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>
<html>
<head>
<title>Owner's Account</title>
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
<input type="hidden" name="acct_cd">
<input type="hidden" name="acct_itm_seq">

<!-- 개발자 작업	-->
 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
	<table class="search"> 
		<tr><td class="bg">
			<!--  biz_1  (S) -->
			<!-- <table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Owner's Account - Master</td></tr>
			</table> -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="100">&nbsp;Effective Date</td>
				<td width="205">
					<input type="text" name="eff_dt1" class="input1" maxlength="6" dataformat="ym" required fullfill caption="Effective Date From" style="width:60;text-align:center;ime-mode:disabled;" value="">&nbsp;
					<img src="img/btns_calendar.gif" name="btn_effDt1" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~&nbsp;
					<input type="text" name="eff_dt2" class="input1" maxlength="6" dataformat="ym" required fullfill cofield="eff_dt1" caption="Effective Date To" style="width:60;text-align:center;ime-mode:disabled;" value="">&nbsp;
					<img src="img/btns_calendar.gif" name="btn_effDt2" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle">
				</td>
				<td width="90">&nbsp;&nbsp;Vessel Code</td>
				<td width="294">
					<input type="text" name="vsl_cd" style="width:57;text-align:center;ime-mode:disabled" class="input" maxlength="4" fullfill caption="Vessel Code">&nbsp;
					<img class="cursor" src="img/btns_search.gif" name="btn_vslPop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;
					<input type="text" style="width:195;" class="input2" name="vsl_eng_nm" readonly>
				</td>
				<td width="80">&nbsp;Location</td>
				<td width="">
					<input type="text" name="loc_cd" style="width:56;text-align:center;ime-mode:disabled" class="input" maxlength="5" fullfill caption="Location">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_locPop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" name="loc_nm" style="width:110;" class="input2" readonly>
				</td>
				
			</tr>
			
			
			<tr class="h23">
				<!-- <td width="120">&nbsp;&nbsp;O/A Item</td>
				<td width="240" style="padding-left:2" colspan='3'>
					<script language="javascript">ComComboObject('cmbOAItem', 1, 450, 1);</script>
				</td> -->
				<td width="100">&nbsp;O/A Item</td>
				<td width="" colspan="3">
					<input type="text" style="width:535" class="input2" name="acct_itm_nm" readonly>&nbsp;
					<img class="cursor" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="item_name">
					<input type="checkbox" name="chk_item_name" class="trans" checked onclick="setItemNameClear();" disabled>
				</td>
				<td width="80">&nbsp;Settlement</td>
				<td width="" style="padding-left:2">
					<script language="javascript">ComComboObject('cmb_sttlmnt', 1, 193, 1);</script>
				</td>
					<!-- <select name="cmb_sttlmnt" style="width:120;">
					<option value="" selected>All</option>
					<option value="RC">Received</option>
					<option value="EA">Editing Attachment</option>
					<option value="HD">Holding</option>
					<option value="CN">Cancelled</option>
					<option value="RF">Refund</option>
					<option value="ST">Settled</option>
					</select> -->
				</td>
				<!-- <td width=""></td> -->
				<!-- <td width="170"><select name="rct_flg" style="width:90;">
					<option value="" selected>All</option>
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
				</td> -->
			</tr>
			</table>

			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<!--  biz_2  (S) -->
			<!-- <table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Owner's account Billing to owner</td></tr>
			</table> -->
			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
		<!-- 
		2012.06.12. Editor [Start]				
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="287">&nbsp;</td>
				<td>
					<table border="0" width=220>
						<tr>
							<td><input type="text" name="amountSum_Owner_01" style="width:89;text-align:right;" class="input2" dataformat="float" value="" readonly ></td>
							<td width="40">&nbsp;</td>
							<td> </td>
						</tr>
					</table>
				</td>
			<td width=500>&nbsp;</td>
			</tr>
			</table>
		2012.06.12. Editor [End]	
	
		
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			 biz_2  (S)
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Owner's account cancelled slip from Local</td></tr>
			</table>
			Grid  (S)
				<table width="100%" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
					Grid (E)
					
						
		2012.06.12. Editor [Start]
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="287">&nbsp;</td>
				<td>
					<table border="0" width=220>
						<tr>
							<td><input type="text" name="amountSum_Local_01" style="width:89;text-align:right;" class="input2" dataformat="float" value="" readonly ></td>
							<td width="40">&nbsp;</td>
							<td></td>
						</tr>
					</table>
				</td>
			<td width=500>&nbsp;</td>
			</tr>
			</table>
		2012.06.12. Editor [End]	
		
				
			 biz_2   (E)
			
			<table width="100%" class="search" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
			<tr>
			<td width="400">&nbsp;</td>
			<td>
				<table class="search" border="0" style="width:500;">
					<tr class="h23">
						<td>Balanced Match Amount</td>
						<td>&nbsp;</td>
						<td><input type="text" name="plusSum" style="width:100;text-align:right;" class="input2" dataformat="float" value="0" readonly></td>
						<td>&nbsp;</td>
						<td><input type="text" name="minusSum" style="width:100;text-align:right;" class="input2" dataformat="float" value="0" readonly></td>
					</tr>
				</table>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
			
			</td></tr>
		</table> -->
	
	<!--biz page (E)-->
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		<tr><td align="right">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<!--<td class="btn1_line"></td>-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_saveToFile">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_autoFilter">Auto Matching Balance Filter</td>
					<td class="btn1_right">
					</tr>
				</table></td> -->
			</tr></table>
		</td></tr>
	</table>
	<!--Button (E) -->
	
	<!-- Button (S) -->
	<!-- <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr><td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_test">TEST</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_saveToFile">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_autoFilter">Auto Matching Balance Filter</td>
					<td class="btn1_right">
					</tr>
				</table></td> 
			</tr>
			</table>
		</td></tr>
	</table>-->
	<!-- Button (E) -->
 
</td></tr>
</table>
<!-- 
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>