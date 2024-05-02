<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0046.jsp
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-30
*@LastModifier : chkong
*@LastVersion : 1.0
* 2007-01-30 chkong
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.event.EsdTrs0046Event"%>
<%
	EsdTrs0046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	DBRowSet rowSet	 = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수

	SignOnUserAccount account= null;
	try {

	   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0046Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);

	// CJO SORT ----------------------------------------------------------------------------------------------------------------
	String dateCD         = JSPUtil.getCodeCombo("date_cd"         , "01", "style='width:125'", "CD00928", 0, "000030:ALL:ALL");
	String statusCD       = JSPUtil.getCodeCombo("status_cd"       , "01", "style='width:147'", "CD00824", 0, "000046:ALL:ALL");
	String holdCD         = JSPUtil.getCodeCombo("hold_cd"         , "01", "style='width:70'" , "CD00912", 0, "000046:ALL:ALL");
	String amountVeryfyCD = JSPUtil.getCodeCombo("amount_verify_cd", "01", "style='width:232'", "CD00927", 0, "000046:ALL:ALL");
%>
<html>
<head>
<title>USA Invoice Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("combo_svc_provider", "", "CD00930", 0, "")%>

	var beforeOneMonth = '<%=beforeOneMonth%>';
	var today = '<%=today%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post"  name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="inv_aud_sts_cd">
<input type="hidden" name="usr_id"     value="<%=account.getUsr_id()%>">
<input type="hidden" name="usr_ofc_cd" value="<%=account.getOfc_cd()%>">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">New</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 <div id="showMin" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="340" class="sm"><%=dateCD%>
								<input type="text" style="width:75" name='fmdate' value="">&nbsp;~&nbsp;<input type="text" style="width:75" name='todate' value=""><img src="" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='btns_calendar'></td>
							<td width="143">Status</td>
							<td width="195"><%=statusCD%></td>
							<td width="52">Hold</td>
							<td><%=holdCD%></td>
							</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="60">Amount</td>
							<td width="280"><%=amountVeryfyCD%></td>
							<td width="145">Service Provider</td>
							<td>
								<table border="0" style="height:10; width:100%; background-color: #E9E9E9;">
                                	<tr><td class="sm" style="padding-left:10;" width="160">
                                			<input type="radio" class="trans" name='sp_tp' value='wo' checked> Work Order
											<input type="radio" name='sp_tp' value='py'class="trans"> Payment</td>
										<td width="75"><script language="javascript">ComComboObject('combo_svc_provider', 2, 73, 0);</script></td>
										<td><input name='svc_provider' ReadOnly class="input2" type="text" style="width:100%;"></td>
									</tr>
                                </table>

							</td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="340">

								<table border="0" style="height:15; width:320; background-color: #E9E9E9;">
                                	<tr><td style="padding-left:10;" class="sm" width="118">
                                			<input type="radio" name='no_tp' value='iv' class="trans" checked>Invoice
											<input type="radio" name='no_tp' value='csr' class="trans">CSR</td>
										<td><input name="no_cd" type="text" style="width:164;"><img src="" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_no_cd'></td>
									</tr>
                                </table>
							</td>

							<td width="145">Invoice Creation Office</td>
							<td width="194"><input name="inv_cre_ofc" type="text" style="width:83;" onkeyup="upper(this)" value="<%=account.getOfc_cd()%>"></td>
							<td width="152">Invoice Creation User ID</td>
							<td><input name="ivc_cre_usr_id" type="text" style="width:100%;" maxlength='10'></td>


						</tr>
					</table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		</div>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->


					<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( From Location ) (E) -->


					<!-- : ( Grid ) (E) -->


					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downinexcel1" name="btng_downinexcel1">Down In Excel 1</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downinexcel2" name="btng_downinexcel2">Down In Excel 2</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_detailinquiry" name="btng_detailinquiry">Detail Inquiry</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_holdsave" name="btng_holdsave">Hold Save</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_invoicedelete" name="btng_invoicedelete">Invoice Delete</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_invaudit" name="btng_invaudit">Invoice Audit</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_invconfrimcancel" name="btng_invconfrimcancel">Invoice Confirm Cancel</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>

<form name='AuditForm' method='POST'>
<input type='hidden' name='inv_no'>
<input type='hidden' name='inv_vndr_seq'>
<input type='hidden' name='editflag'>
<input type="hidden" name="pgmNo" value="ESD_TRS_0038">
</form>

</body>
</html>
