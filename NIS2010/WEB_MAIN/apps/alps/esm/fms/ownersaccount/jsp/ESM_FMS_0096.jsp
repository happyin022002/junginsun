<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_FMS_0096.jsp
*@FileTitle : Owner's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.02.18 민정호
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
<%@ page import="com.hanjin.apps.alps.esm.fms.ownersaccount.event.EsmFms0096Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0096Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지 

	String strUsr_id			= "";
	String strUsr_nm		= "";
	String strOfc_cd			= "";
	String strOfc_nm		= "";
    String strFromyyyyMMdd = "";
    String strToyyyyMMdd = "";	
	String inv_sub_sys_cd = "FMS";
	String strOffice = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOSettlement");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strOfc_nm = account.getOfc_eng_nm();
        strFromyyyyMMdd = DateTime.getFormatDate( DateTime.addMonths( JSPUtil.getKST("yyyyMMdd"), -1 ), "yyyyMMdd", "yyyy-MM-dd" );
        strToyyyyMMdd   = DateTime.getFormatDate( JSPUtil.getKST("yyyyMMdd"), "yyyyMMdd", "yyyy-MM-dd");

		event = (EsmFms0096Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strOffice   = eventResponse.getETCData("office");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Owner's Account to Expenses</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	var gOffice   = "<%=strOffice%>";

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
<!-- 개발자 작업	-->
<input type="hidden" name="spdeleted" value="">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="slp_no">
<input type="hidden" name="csr_type">
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Owner's Account">
<input type="hidden"   name="com_mrdBodyTitle" value="Owner's Account"">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">					
					<td width="200"><input type="radio" class="trans" name="date_gubun" value="gl" checked>G/L Date&nbsp;&nbsp;<input type="radio" class="trans" name="date_gubun" value="cr" >Creation Date</td>
					<td width="250"><input type="text" style="width:80;text-align:center;ime-mode:disabled;" class="input1" required dataformat="ymd"  maxlength="8" caption="Period From" value="<%=strFromyyyyMMdd%>"  name="pre_fr">&nbsp;<img src="img/btns_calendar.gif" align="absmiddle" name="btns_calendar_from" style="cursor:hand">&nbsp;~
                                    <input type="text" style="width:80;text-align:center;ime-mode:disabled;" class="input1" required dataformat="ymd"  maxlength="8"  caption="Period To" value="<%=strToyyyyMMdd%>"  name="pre_to">&nbsp;<img src="img/btns_calendar.gif" align="absmiddle" name="btns_calendar_to" style="cursor:hand"></td>
					<td width="50">Office.</td>
					<td width="200"><script language="javascript">ComComboObject("office", 1, 150, 1, 0, 0);</script>	</td>
					<td width="80">My CSR Only</td>
					<td width=""><input type="checkbox" value="Y" name="my_csr" id="my_csr" class="trans"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">					
					<td width="50">Supplier</td>
					<td width="350"><input type="text" name="spcode" maxlength="6" style="width:60;text-align:center;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" name="spname" style="width:220;text-align:left;" class="input2" value="" readonly></td>					
					<td width="90">Vessel code</td>
					<td width="300"><input type="text" name="vsl_cd" style="width:57;text-align:center;ime-mode:disabled" class="input" maxlength="4" fullfill caption="Vessel Code">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vslPop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:140;" class="input2" name="vsl_eng_nm" readonly>
					<input type="checkbox" name="btn_vslCdClr" class="trans">
					</td>
					<td width="60">Port</td>
					<td width=""><input type="text" name="loc_cd" style="width:56;text-align:center;ime-mode:disabled" class="input" maxlength="5" fullfill caption="Port">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_locPop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" name="loc_nm" style="width:110;" class="input2" readonly>&nbsp;<input type="checkbox" name="btn_locCdClr" class="trans">
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">					
					<td width="65">CSR No.</td>
					<td width="270"><input type="text" style="width:250;" class="input" name="csr_no" maxlength="22" style="ime-mode:disabled"></td>
					<td width="80">CSR Status</td>
					<td width="150"><script language="javascript">ComComboObject("csr_status", 1, 150, 1, 0, 0);</script></td>
					<td width="">&nbsp;</td>
				</tr>
				</table>				
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->

				</td></tr>
			</table>
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_oa_entry">O/A Entry</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_cancel_csr">Cancel CSR</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_del_resubmit">Re-Creation</td>
					<td class="btn1_right">
					</tr>
				</table></td>												
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_down_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>