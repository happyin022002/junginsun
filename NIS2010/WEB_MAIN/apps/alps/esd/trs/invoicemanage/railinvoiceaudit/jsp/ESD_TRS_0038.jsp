<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0038.jsp
*@FileTitle : USA Rail Invoice 등록 및 Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-08
*@LastModifier : chkong
*@LastVersion : 1.0
* 2006-10-13 chkong
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0038Event"%>
<%
	EsdTrs0038Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	String codeList  = "";
	String userId = "";
	String ofcId = "";
	String inv_no = "";
	String inv_vndr_seq = "";
	String editflag = "";
	String today = DateTime.getFormatString("yyyy-MM-dd");
	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofcId=account.getOfc_cd();

	    inv_no = request.getParameter("inv_no") == null ? "" : request.getParameter("inv_no") ;
	    inv_vndr_seq = request.getParameter("inv_vndr_seq") == null ? "" : request.getParameter("inv_vndr_seq") ;
	    editflag = request.getParameter("editflag") == null ? "" : request.getParameter("editflag") ;

	    codeList  = JSPUtil.getCodeCombo("currency", "01", "style='width:90'", "CD00884", 0, "");

		event = (EsdTrs0038Event)request.getAttribute("Event");

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
<title>Audit & Confirm </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("rail_road_code", "", "CD00930", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("inv_curr_cd", "", "CD00884", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cgo_tp_cd", "", "CD00748", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("trsp_inv_co_ind_cd", "", "CD00875", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setAuditInquiry("<%=inv_no%>", "<%=inv_vndr_seq%>");
	}
</script>
</head>


<body scroll="auto" onLoad="setupPage();">
<form name="form">
<input type="hidden" name ="f_cmd">
<input type="hidden" name="VNDR_CNT_CD" value="Y">  <!-- USA Rail Vendor 를 가져오는 flag  -->
<input type="hidden" name="trsp_inv_aud_sts_cd" >
<input type="hidden" name="cntr_no" >
<input type="hidden" name="usr_id" value="<%=userId%>" >
<input type="hidden" name="ofc_cd" value="<%=ofcId%>">
<input type="hidden" name="seq" >
<input type="hidden" name="sts_cd" >
<input type="hidden" name="insflag" value="true" >
<input type="hidden" name="editflag" value="<%=editflag %>">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1"  id="btn_reset" name="btn_reset">New</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1"  id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



        <div id="MiniLayer" style="display:inline">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="73">Invoice No. </td>
							<td width="208"><input name="inv_no" type="text" style="width:90;" value="" onBlur='checkInvoiceName()'></td>
							<td width="110">Receive Date</td>
							<td width="122"><input name="receive_dt" type="text" style="width:75;" value="<%=today%>" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);'><img src="" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1" ></td>
							<td width="103">Issue Date</td>
							<td colspan="3"><input name="issue_dt" type="text" style="width:75;" value="<%=today%>" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);'><img src="" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
						</tr>
						<tr class="h23">
							<td>Currency</td>
							<td><%=codeList%></td>
							<td>Invoice Amount</td>
							<td><input name="invoice_amt" type="text" style="width:75;text-align:right;" value="0.00" onKeyUp='isMon(this,"Y");' onKeyDown='ComChkObjValid(this); isMon(this,"Y");' onBlur="chkAmtFmtObj(this);sumAmt();"> </td>
							<td>V.A.T Amount</td>
							<td width="175"><input name="vat_amt" type="text" style="width:75;text-align:right;" value="0.00" onKeyUp='isMon(this,"Y");' onKeyDown='ComChkObjValid(this); isMon(this,"Y");' onBlur="chkAmtFmtObj(this);sumAmt();"></td>
							<td width="90">Total Amount</td>
							<td align="right"><input name="total_amt" type="text" style="width:90;text-align:right;" value="0.00" readOnly class="input2"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="75">Rail Road</td>
							<td width="92"><script language="javascript">ComComboObject('rail_road_code',2, 90 , 1 )</script></td>
							<td width="346"><input name="rail_road_name" type="text" style="width:299;" readOnly class="input2"></td>
							<td width="103">Payment Vendor</td>
							<td><input name="payment_vndr_code" type="text" style="width:75;" class="input2"><img src="" width="2" height="1" border="0"><input name="payment_vndr_name" type="text" style="width:284;" class="input2"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="243">Total Amount of Selected for Payment</td>
							<td><input name="total_amt_for_payment" type="text" style="width:223;text-align:right;" value='0.00' readOnly class="input2"></td>
						</tr>
					</table>
					</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
	    </div>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab">
       	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->


        <div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet1');</script>
                        </td></tr>
                    </table>

					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				    <tr><td>

							<table border="0" cellpadding="0" cellspacing="0" align="left">
							<tr><td width="90"><b>Total Amount</b></td>
								<td><input name="total_amt_coincidence" type="text" style="width:100;text-align:right;" value='0.00' readOnly class="input2"></td>
							</tr>
							</table>

						</td>
						<td class="btn2_bg">

							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="btng_downexcel_1" name="btng_downexcel_1">Down Excel</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t1btng_invoicefileimport" name="t1btng_invoicefileimport">Invoice File Import</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t1btng_paymenthistory" name="t1btng_paymenthistory">Payment History</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t1btng_reaudit" name="t1btng_reaudit">Re-Audit</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t1btng_save" name="t1btng_save">Save</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t1btng_confirm" name="t1btng_confirm">Confirm</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t1btng_print" name="t1btng_print">Print</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
	   </div>
       <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t2sheet1');</script>
                        </td></tr>
                    </table>
					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				    <tr><td>

							<table border="0" cellpadding="0" cellspacing="0" align="left">
							<tr><td width="90"><b>Total Amount</b></td>
								<td><input name="total_amt_discrepancy" type="text" style="width:100;text-align:right;" value='0.00' readOnly class="input2"></td>
							</tr>
							</table>

						</td>
						<td class="btn2_bg">

							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="btng_downexcel_2" name="btng_downexcel_2">Down Excel</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t2btng_invoicefileimport" name="t2btng_invoicefileimport">Invoice File Import</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t2btng_paymenthistory" name="t2btng_paymenthistory">Payment History</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t2btng_reaudit" name="t2btng_reaudit">Re-Audit</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t2btng_move" name="t2btng_move">Move</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t2btng_save" name="t2btng_save">Save</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t2btng_confirm" name="t2btng_confirm">Confirm</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t2btng_print" name="t2btng_print">Print</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
	   </div>
       <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t3sheet1');</script>
                        </td></tr>
                    </table>

					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				    <tr><td>

							<table border="0" cellpadding="0" cellspacing="0" align="left">
							<tr><td width="90"><b>Total Amount</b></td>
								<td><input name="total_amt_invoice_only" type="text" style="width:100;text-align:right;" value='0.00' readOnly class="input2"></td>
							</tr>
							</table>

						</td>
						<td class="btn2_bg">

							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="btng_downexcel_3" name="btng_downexcel_3">Down Excel</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t3btng_invoicefileimport" name="t3btng_invoicefileimport">Invoice File Import</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t3btng_paymenthistory" name="t3btng_paymenthistory">Payment History</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t3btng_reaudit" name="t3btng_reaudit">Re-Audit</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t3btng_rowadd" name="t3btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t3btng_save" name="t3btng_save">Save</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t3btng_confirm" name="t3btng_confirm">Confirm</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t3btng_print" name="t3btng_print">Print</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
	   </div>

       <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t4sheet1');</script>
                        </td></tr>
                    </table>

					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				    <tr><td class="btn2_bg">

							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2"  id="t4btng_downexce" name="t4btng_downexce">Down Excel</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
	   </div>




</td></tr>
</table>
<!-- Outer Table (E)-->



<div  style="display:none">
 <script language="javascript">ComSheetObject('sheet2');</script>
 <script language="javascript">ComSheetObject('sheet3');</script>
 </div>
</form>
</body>
</html>