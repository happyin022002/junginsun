<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0039.jsp
*@FileTitle : (Korea) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.04 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0039Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0039Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (FnsInv0039Event)request.getAttribute("Event");
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
<title>(Korea) Invoice Issue</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="ar_ofc_cd">
<input type="hidden" name="inv_seq">
<input type="hidden" name="dp_prcs_knt" value="0">
<input type="hidden" name="bl_src_no" value="">
<input type="hidden" name="select_row" value="">

<input type="hidden" name="state">
<input type="hidden" name="send_flg" value="">
<input type="hidden" name="rd_name" value="">
<input type="hidden" name="email_subject" value="">
<input type="hidden" name="email_file_name" value="">
<input type="hidden" name="inv_prn_dvc_nm" value="">
<input type="hidden" name="bl_search">
<input type="hidden" name="com_mrdPath"> 
<input type="hidden" name="com_mrdArguments"> 
 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<table class="search" id="mainTable">
		<tr>
			<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="80" align="">Invoice No.&nbsp;</td>
					<td width="120"><input name="inv_no" type="text" style="width:100" class="input1" value="" dataformat="engup" maxlength="9" ></td>
					<td width="70" align="">Issue Date&nbsp;</td>
					<td width="520"><input name="iss_dt" type="text" style="width:75;text-align:left" class="input1" dataformat="ymd" maxlength="8" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="70" align="">Office&nbsp;</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('ofc_cd', 1, 100, 0);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="80" align="">Actual Cust.&nbsp;</td>
					<td width="710"><input name="act_cust_cnt_cd" type="text" style="width:31;text-align:left" class="input1" value="" maxlength="2" dataformat="engup">&nbsp;<input name="act_cust_seq" type="text" style="width:65;text-align:left" class="input1" maxlength="6" class="input" value="" dataformat="num">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust">&nbsp;<input name="cust_nm" type="text" style="width:370;" class="input2" value="" readonly>&nbsp;<input name="cust_rgst_no" type="text" style="width:90" class="input2" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust2"></td>
					<td width="70" align="">Issue Type&nbsp;</td>
					<td width=""><input name="iss_div_cd" type="text" style="width:100" class="input2" value="" readOnly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="80" align="">PIC&nbsp;</td>
					<td width="115"><input name="cntc_pson_nm" type="text" style="width:100" class="input2" value="" readOnly></td>
					<td width="75" align="">Address&nbsp;</td>
					<td width="340"><input name="locl_addr" type="text" style="width:307" class="input2" value="" readOnly></td>
					<td width="70" align="right">Biz Type&nbsp;</td>
					<td width="110"><input name="bzct_nm" type="text" style="width:100" class="input2" value="" readOnly></td>
					<td width="70" align="">Biz Item&nbsp;</td>
					<td width=""><input name="bztp_nm" type="text" style="width:100" class="input2" value="" readOnly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="80" align="">Remark(s)</td>
					<td width=""><input name="inv_rmk" type="text" style="width:880" class="input" value=""></td>
				</tr></table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="80" align="">Fax No.</td>
					<td width="300"><input name="cust_fax_no" type="text" style="width:300" class="input" value=""></td>
					<td width="70" align="right">E-mail</td>
					<td width=""><input name="cust_eml" type="text" style="width:508" class="input" value=""></td>
				</tr>
				</table>
				<!--  biz_2   (E) -->
			</td>
		</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
		<tr>
			<td class="bg">
				<table class="search" border="0" style="width:100%;">
				<tr class="h23" valign="top">
					<td width="53%" valign="top">
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
						</table>
						<!-- Grid (E) -->
						
						<!--  Button_Sub (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
						<tr>
							<td class="btn1_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_add">Row Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_delete">Row Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
						<!-- Button_Sub (E) -->
					</td>
					<td width="" align="right">&nbsp;</td>
				</tr>
				</table>
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23" valign="top">
					<td width="" align="right">
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
						</table>
						<!--  Button_Sub (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
						<tr>
							<td class="btn1_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_add2">Row Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_delete2">Row Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
						<!-- Button_Sub (E) -->
						<table class="height_8"><tr><td></td></tr></table>
						<!-- Grid (E) -->
						<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="90">S.Total</td>
							<td width="70" align="right">FRT_USD&nbsp;</td>
							<td width="200"class="input2" style="text-align:right;"><span id="total_usd">0</span></td>
							<td width="120" align="right">VAT_KRW&nbsp;</td>
							<td width="200"class="input2" style=";text-align:right;"><span id="vat_krw">0</span></td>
							<td width="120" align="right">Total_KRW&nbsp;</td>
							<td width=""class="input2" style="text-align:right;"><span id="total_krw">0</span></td>
						</tr>
						</table>
						
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="search" border="0" style="width:100%">
						<tr class="h23">
							<td width="70">&nbsp;Count</td>
							<td width="150"><input name="bl_no_cnt" type="text" style="width:110;text-align:right;" class="input2" value="" readOnly></td>	
							<td width="115">Total AMT(KRW)</td>
							<td width="150"><input name="total_amt" type="text" style="width:100%;text-align:right;" class="input2" value="" readOnly></td>
							<td width="">&nbsp;</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!--biz page (E)-->
			</td>
		</tr>
		</table>
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_fax">Fax Send</td>
							<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_eml">E-mail Send</td>
							<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_print">Print</td>
							<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
	</td>
</tr>
</table>
<div style="display:">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>
<!------- Print용 Hidden RD Object Start -------->
<table width="100%"  id="rdTable"> 
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