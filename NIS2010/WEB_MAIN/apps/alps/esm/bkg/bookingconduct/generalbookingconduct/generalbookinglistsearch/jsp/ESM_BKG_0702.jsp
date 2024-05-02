<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0702.jsp
*@FileTitle : Booking Receipt Draft BL EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.17 전용진
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.05.27 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2013.04.15 김태경 [CHM-201323872] ALPS > Draft B/L &Freight Invoice EDI 화면 보완 요청 드립니다.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0702Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg0702Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sXml = null;
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String pgmNo			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingListSearch");
	List<BkgComboVO> bkg_cust_tp_cd = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0702Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		pgmNo  = JSPUtil.getParameter(request, "pgmNo");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);	
		bkg_cust_tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_cust_tp_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Receipt Draft BL EDI</title>
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
<input type="hidden" name="pgm_no" value="<%=pgmNo%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="key">  <!-- BackEndJob -->

<!-- 개발자 작업	-->

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
					<td width="320"><table class="search_sm" border="0" width="310">
							<tr class="h23">
								<td width="55">Type</td>
								<td class="stm"><input type="radio" name="type_gbn" value="B" class="trans" onClick="javascript:checkType();" checked>Booking Confirm&nbsp;&nbsp;&nbsp;<input type="radio" name="type_gbn" value="D" onClick="javascript:checkType();" class="trans">B/L&nbsp;&nbsp;&nbsp;<input type="radio" name="type_gbn" value="ALL" onClick="javascript:checkType();" class="trans">All</td></tr>
								</table></td>
					<td width="15">&nbsp;</td>
					<td width="664"><table class="search_sm" border="0" width="655">
							<tr class="h23">
								<td width="40">Date</td>
								<td width="220"><input type="text" style="width:75" maxlength="10" class="input1" name="bkg_from_dt" caption="BKG DT" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:75" maxlength="10" class="input1" name="bkg_to_dt" caption="BKG DT" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
								<td class="stm"><input type="radio" name="type_date" value="R" class="trans">EDI Send Date&nbsp;&nbsp;
												<input type="radio" name="type_date" value="B" class="trans" checked>BKG Date&nbsp;&nbsp;
												<input type="radio" name="type_date" value="O" class="trans">Onboard Date</td>
								<td width=""></td>
								</table></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">VVD</td>
					<td width="110"><input type="text" name="vvd" style="width:85" maxlength="9" dataformat="engup" value="" class="input1"></td>
					<td width="30">POR</td>
					<td width="80"><input type="text" name="por_cd" style="width:55;" maxlength="5" dataformat="engup" value="" class="input"></td>
					<td width="30">POL</td>
					<td width="80"><input type="text" name="pol_cd" style="width:55;" maxlength="5" dataformat="engup" value="" class="input"></td>
					<td width="30">POD</td>
					<td width="90"><input type="text" name="pod_cd" style="width:55;" maxlength="5" dataformat="engup" value="" class="input"></td>
					<td width="30">DEL</td>
					<td width=""><input type="text" name="del_cd" style="width:55;" maxlength="5" dataformat="engup" value="" class="input"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">BKG Office</td>
					<td width="127"><input type="text" name="bkg_ofc_cd" style="width:90;" maxlength="6" dataformat="engup" class="input" value=""></td>
					<td width="70">BKG Staff</td>
					<td width="115"><input type="text" name="bkg_stf_cd" style="width:95;" maxlength="20" dataformat="engnum" class="input" value=""></td>
					<td width="82">Sales Office</td>
					<td width="86"><input type="text" name="sls_ofc_cd" style="width:75;" maxlength="6" dataformat="engup" class="input" value=""></td>
					<td width="70">Sales Rep.</td>
					<td width="100"><input type="text" name="sales_rep" maxlength="5" dataformat="engup" style="width:85" class="input" value=""></td> 
					<td width="">B/L Office &nbsp;&nbsp;<input type="text" name="bl_ofc_cd" style="width:70;" maxlength="6" dataformat="engup" value="" class="input"></td> 
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75">Booking No.</td>
					<td width="127"><input type="text" id="bkg_no" name="bkg_no" style="width:90;" maxlength="13" dataformat="engup" class="input1" value="">&nbsp;<img onClick="openAddPaste('bkg_no')" class="cursor" src="img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name=""></td>
					<td width="70">B/L No.</td>
					<td width="116"><input type="text" name="bl_no" style="width:95;" maxlength="13" dataformat="engup" class="input" value=""></td> 
					<td width="40">Via</td>
					<td width=""><script language="javascript">ComComboObject('xter_rqst_via_cd', 1, 120, 1, 0, 2);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="55">S/C No.</td>
					<td width="107"><input type="text" name="sc_no" style="width:90;" maxlength="11" dataformat="engup" class="input" value=""></td>
					<td width="60">Customer</td>
					<td width="306"><%=HTMLUtil.getComboString("cust_tp_cd", "width:90;", "", "","","All", bkg_cust_tp_cd)%><input type="text" name="cust_cnt_cd" maxlength="2" dataformat="engup" style="width:25;" class="input" value="">&nbsp;<input type="text" name="cust_seq" maxlength="6" dataformat="engup" style="width:55;" class="input" value="">&nbsp;<input type="text" name="cust_nm" maxlength="50" dataformat="eng" style="width:90;" class="input" value=""></td>
					<td width="90">EDI Receiver</td>
					<td width="206"><select style="width:95;" name="edi_group_id"><option value="G" selected>Group ID</option><option value="R">Receive ID</option><option value="N">Receiver Name</option></select>&nbsp;<input type="text" name="edi_receive_nm" maxlength="20" dataformat="eng" style="width:90;" class="input" value=""></td>
					<td width="110">EDI Sent Status</td>
					<td width="" style="padding-left:2"><select style="width:70;" name="edi_sent_sts_cd"><option value="All" selected>All</option><option value="N">Unsent</option><option value="Y">Sent</option></select></td>
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
			
			<table class="line_bluedot"><tr><td></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	
			<!--  biz_3 (S) -->
				
				<!--  biz_3  (E) -->
				
				<!--Grid (S)-->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->		

				<table border="0" style="padding-top:10; width:700; background-color:white;" class="grid2"> 
					<tr>
						<td width="60" class="tr2_head2">Total</td>
						<td width="60" class="align_r"><input type="text" name="total" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
						<td width="60" class="tr2_head2">Success</td>
						<td width="60" class="align_r" align="right"><input type="text" name="success" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
						<td width="60" class="tr2_head2">Sending</td>
						<td width="60" class="align_r" align="right"><input type="text" name="send" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
						<td width="60" class="tr2_head2">Un-sent</td>
						<td width="" class="align_r" align="right"><input type="text" name="unsent" style="width:200;text-align:right" class="noinput" value="" readOnly></td>
					</tr>
				</table>

			<!--  Button_Sub (S) -->
			<table width="100%" class="button" border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_SendtoCustomer">Send to Customer</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_SendtoTerminal">Send to Terminal</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					
						
				</table>
				
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
</form>
</body>
</html>
<script language="javascript" for="sheet1" event="OnMouseMove(Button, Shift, X, Y)">
  Row = MouseRow;
  Col = MouseCol;
  if (Col == 4) {
  	if(Row!=0){
	  	  if(CellText(Row,"bl_tp_cd")=="D"){
	  	  	sText = "Draft";
	  	  }else if(CellText(Row,"bl_tp_cd")=="W"){
	  	  	sText = "Waybill";
	  	  }else{
	  	  	sText = "";
	  	  }
		  MouseToolTipText = sText
		  MousePointer = "Hand";
		  window.status = MousePointer;
	  }
  }else if (Col == 19) {
	  sText = CellText(Row,"snd_usr_nm");
	  MouseToolTipText = sText
	  MousePointer = "Hand";
	  window.status = MousePointer;
  }else if(Col == 20){
  	if(Row!=0){
	  	  if(CellText(Row,"sent_status")=="U"){
	  	  	sText = "Un-Sent";
	  	  }else if(CellText(Row,"sent_status")=="S"){
	  	  	sText = "Sent";
	  	  }else{
	  	  	sText = "Fail";
	  	  }
		  MouseToolTipText = sText
		  MousePointer = "Hand";
		  window.status = MousePointer;
	  }
  }else{
  	  MouseToolTipText = "";
	  MousePointer = "Default";
	  window.status = MousePointer;
  }
</script>