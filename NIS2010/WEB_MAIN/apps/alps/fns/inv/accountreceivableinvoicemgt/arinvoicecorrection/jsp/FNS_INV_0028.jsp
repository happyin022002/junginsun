<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0028.jsp
*@FileTitle : Invoice Data Manual Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.20 최도순
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0028Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strAdm		    = "XXX";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (FnsInv0028Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//if(strUsr_id.equals("2006614") || strUsr_id.equals("c9012602") || strUsr_id.equals("2007622")){
		if(strUsr_id.equals("21702009")){
			strAdm ="INVADM" ;
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice Data Manual Interface</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="man_div_ind">
<input type="hidden" name="inv_adm" value="<%=strAdm%>">

<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="backendjob_key">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"	align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="80">I/F Date</td>
						<td width="" colspan="2"><input type="text" class="input1" style="width: 80;" name="fm_if_dt" dataformat="ymd" cofield="to_if_dt" onBlur="fn_ComGetMaskedValue('fm_if_dt');" maxlength="10" onKeyUp="javascript:checkFmDtLeng(this.value)">&nbsp;
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" class="input1" style="width: 80;" name="to_if_dt" dataformat="ymd" cofield="fm_if_dt"	onBlur="fn_ComGetMaskedValue('to_if_dt');" maxlength="10">&nbsp;
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
						<td colspan="5" align="right" class="title_s">※ If nothing retrieved, input bkg no and then click on 'Re-interface from BKG/DOC'.
						</td>
					</tr>
					<tr class="h23">
						<td width="80">Trunk VVD</td>
						<td width="200"><input type="text" class="input1" style="width: 80;" name="trnk_vvd" class="input" maxlength="9" fullinput dataformat="uppernum"></td>
						<td width="50">B/L No.</td>
						<td width="200"><input type="text" class="input1" style="width: 100;" class="input" name="bl_src_no" maxlength="12"	fullinput dataformat="uppernum"></td>
						<td width="30">POL</td>
						<td width="200"><input type="text" style="width: 73;" name="pol_cd" value="" class="input" maxlength="5" fullinput dataformat="uppernum"></td>
						<td width="30">POD</td>
						<td width=""><input type="text" style="width: 73;"	name="pod_cd" value="" class="input" maxlength="5" fullinput dataformat="uppernum"></td>

					</tr>
				</table>
				</td>
			</tr>
		</table>

		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>

		<table class="search">
			<tr>
				<td class="bg" id="mainTable">
				<!-- Grid  (S) --> 
				<script language="javascript">ComSheetObject('sheet1');</script>
				<!-- Grid (E) -->

				<table class="search" border="0">
					<tr class="h23">
						<td width="70">&nbsp;&nbsp;BKG No.</td>
						<td><input type="text" class="input1" style="width: 100;" name="bkg_no"></td>
						<td width="100">&nbsp;&nbsp;Trunk VVD</td>
						<td width="100"><input type="text" class="input1" style="width: 80;" name="vvd" class="input" maxlength="9" fullinput dataformat="uppernum"></td>
						<td width="45">&nbsp;&nbsp;POL</td>
						<td width="55"><input type="text" class="input1" style="width: 50;" name="pol" class="input" maxlength="5" fullinput dataformat="uppernum"></td>
						<td width="45">&nbsp;&nbsp;POD</td>
						<td width="55"><input type="text" class="input1" style="width: 50;" name="pod" class="input" maxlength="5" fullinput dataformat="uppernum">  	</td>												
						<td width="200">
						<table width="200" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_ifbkg">Re-interface from BKG/DOC</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td width="400"></td>
					</tr>
				</table>
<%
   if(strAdm.equals("INVADM")){
%>				 
				<table class="search" border="0">
					<tr class="h23">
						<td width="70">&nbsp;&nbsp;IF No.</td>
						<td><input type="text" class="input1" style="width: 100;" name="ar_if_no"></td>
						
						<td width="120">
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr> 
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_erp">Send to ERP</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td width="140">
						<table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_erpU">Send to ERP(U)</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td width="120">
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_cancel">Manual Cancel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td width="320">
							 &nbsp;&nbsp;||&nbsp;&nbsp;SRC IF DT : <input type="text" class="input1" style="width: 70;" name="src_if_dt">
							   &nbsp;SRC IF SEQ : <input type="text" class="input1" style="width: 50;" name="src_if_seq">&nbsp;
						</td>
						<td width="100">
						<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_otherif">OTHER I/F</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
		 	
					<tr class="h23">
						<td width="75">&nbsp;&nbsp;다건 IF No.</td>
						<td colspan="4"><input type="text" class="input1" style="width: 100;" name="no_text">
						<input type="text" style="width:30;" name="if_no_cnt">
						<span>다건처리시 AR_IF_NO 단위 ','로 구분하여 ERP로 I/F</span>
						</td> 
						
					</tr>
					</table>
					<table>
					<tr class="h23">
						<td width="95">&nbsp;&nbsp;다건 BKG No.</td>
						<td width="150"><input type="text" class="input1" style="width: 100;" name="no_text2">
						<input type="text" style="width:30;" name="bkg_no_cnt">
						</td>
						<td width="270"> 
						<table width="250" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_multibkg">다건처리 Re-IF from BKG/DOC</td>
								<td class="btn1_right"></td>
							</tr>
						</table> 
						</td>
					</tr>  
					</table>
					
<%	
}
%>						
				

				</td>
			</tr>
		</table>
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
<!--						
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_execute">Execute</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
-->						
					</tr>
				</table>

				
				</td>
			</tr>
		</table>
		<!--Button (E) -->
		</td>
	</tr>
</table>		
		<!-- 개발자 작업  끝 -->
		</form>
</body>
</html>