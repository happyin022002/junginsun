<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0052.jsp
*@FileTitle : (Korea) Terminal GIRO Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.09.23 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0052Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (FnsInv0052Event)request.getAttribute("Event");
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
<title>(Korea) Terminal GIRO Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="ar_ofc_cd">
<input type="hidden" name="inv_prn_dvc_nm" value="">
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
		<table class="search">
		<tr>
			<td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="68">B/L No.</td>
					<td width="132"><input name="bl_src_no" type="text" style="width:100;" class="input1" dataformat="engup" value=""></td>
					<td width="58">GIRO No.</td>
					<td width="132"><input name="giro_no" type="text" style="width:115;" class="input2" value=""></td>
					<td width="68">Issue Date</td>
					<td width="132"><input name="iss_dt" type="text" style="width:75;text-align:left" class="input1" dataformat="ymd" maxlength="8" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="68">Office</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('ofc_cd', 1, 100, 0);</script></td>
				</tr>
				</table>
				
				<!-- biz_1  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!-- biz_2  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="68">ACT Cust.</td>
					<td width="" colspan="3"><input name="act_cust_cnt_cd" type="text" style="width:30;" class="input2" value="" readOnly>&nbsp;<input name="act_cust_seq" type="text" style="width:66;" class="input2" value="" readOnly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust">&nbsp;<input name="cust_nm" type="text" style="width:402;" class="input2" value="" readOnly>&nbsp;<input name="cust_rgst_no" type="text" style="width:130;" class="input2" value="" readOnly></td>
				</tr>
				<tr class="h23">
					<td width="68">Address</td>
					<td width="" colspan="3"><input name="locl_addr" type="text" style="width:663;" class="input2" value="" readOnly></td>
				</tr>
				<tr class="h23">
					<td width="68">Owner</td>
					<td width="134"><input name="ownr_nm" type="text" style="width:100;" class="input2" value="" readOnly></td>
					<td width="58">Biz Kind</td>
					<td width="719"><input name="bzct_nm" type="text" style="width:471;" class="input2" value="" readOnly></td>
				</tr>
				</table>
				<!-- biz_2 (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!-- biz_3  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="68">VVD</td>
					<td width="132"><input name="vvd" type="text" style="width:100;" class="input2" value="" readOnly></td>
					<td width="60">S/A Date</td>
					<td width="132"><input name="sail_arr_dt" type="text" style="width:100;" class="input2" value="" readOnly></td>
					<td width="68">Due Date</td>
					<td width="132"><input name="due_dt" type="text" style="width:100;" class="input2" value="" readOnly></td>
					<td width="70">Remark(s)</td>
					<td width=""><input name="giro_rmk" type="text" style="width:100%;" class="input" value=""></td>
				</tr>
				</table>
				<!-- biz_3  (E) -->
				<table class="height_8"><tr><td></td></tr></table>
				<!-- Grid  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="760">
						<input name="select_row" type="hidden" value="0">
						<!-- Grid  (S) -->
						<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<td width="130" class="tr2_head">ITEM</td>
							<td width="210" class="tr2_head">발생 금액(Invoice)</td>
							<td width="210" class="tr2_head">지로 발생 금액</td>
							<td width="210" class="tr2_head">합계 금액</td>
						</tr>
						<tr>
							<td width="130" class="tr2_head">공급가액</td>
							<td width="210" class="input2" style="text-align:right;"><span id="inv_spl_amt">0</span></td>
							<td width="210" class="input"><input name="spl_amt" type="text" value="0" style="width:100%;text-align:right;" class="trans" dataformat="int"></td>
							<td width="210" class="input2" style="text-align:right;"><span id="sum_spl_amt">0</span></td>
						</tr>
						<tr>
							<td width="130" class="tr2_head">세액</td>
							<td width="210" class="input2" style="text-align:right;"><span id="inv_tva_amt">0</span></td>
							<td width="210" class="input"><input name="tva_amt" type="text" value="0" style="width:100%;text-align:right;" class="trans" dataformat="int"></td>
							<td width="210" class="input2" style="text-align:right;"><span id="sum_tva_amt">0</span></td>
						</tr>
						<tr>
							<td width="130" class="tr2_head">총액(KRW)</td>
							<td width="210" class="input2" style="text-align:right;"><span id="total_inv_amt">0</span></td>
							<td width="210" class="input2" style="text-align:right;"><span id="total_amt">0</span></td>
							<td width="210" class="input2" style="text-align:right;"><span id="total_giro_amt">0</span></td>
						</tr>
						</table>
						<!-- Grid (E) -->
					</td>
					<td>
						<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td align="center"><input name="row_index" type="text" style="width:70;text-align:center" class="input" value="1/1" readOnly tabIndex="-1"></td>
						</tr>
						<tr class="h23">
							<td align="center"><img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name="btns_pre">&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name="btns_next"></td>
						</tr>
						<tr class="h23">
							<td align="center">
								<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_addRow">Add</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
						</tr>
						<tr class="h23">
							<td align="center">
								<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_deleteRow">Delete</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Grid  (S) -->
			</td>
		</tr>
		</table>
		<!--biz page (E)-->


		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_delete">Delete</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_print">Print</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td><table class="search" border="0" style="width:100%;">
					<tr class="h23"><td width="85">&nbsp;&nbsp;Print Option</td>
						<td width="" class="stm"><input name="print_flg" type="radio" value="U" class="trans" checked>Up&nbsp;&nbsp;<input name="print_flg" type="radio" value="D" class="trans">Down&nbsp;&nbsp;</td>
					</tr>
					</table>
				</td>
			</tr>
			</table>
		</td>
	</tr>
	</table>
    <!--Button (E) -->
	</td>
</tr>
</table>
<div style="display:none">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
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