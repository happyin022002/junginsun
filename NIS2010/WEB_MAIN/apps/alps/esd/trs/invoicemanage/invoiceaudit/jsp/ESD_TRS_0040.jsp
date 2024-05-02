<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0040.jsp
*@FileTitle : Currency Change Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Lee_SangWoo
*@LastVersion : 1.0
* 2006-12-06 Lee_SangWoo
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
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0040Event"%>
<%
	EsdTrs0040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String selCurr ="";
	selCurr  = BizComUtil.getCodeCombo("inv_curr_cd","01","style=width:80 onchange=checkCurr(this.value)","CURR",2,"0::ALL");

	String userId = "";
	String ofcId = "";
	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofcId=account.getOfc_cd();

		event = (EsdTrs0040Event)request.getAttribute("Event");

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
<title>Invoice Audit for 'Refund' Invoice  </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("trsp_cost_dtl_mod_cd", "01", "CD00958", 0, " |")%>
	<%=JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "01", "CD00283", 0, " |")%>
	<%=BizComUtil.getIBCodeCombo("eq_tpsz", "01", "CNTRTPSZ", 0, " |")%> 
	<%=BizComUtil.getIBCodeCombo("ch_tpsz", "01", "CHASSIS", 0, " |")%> 
	<%=BizComUtil.getIBCodeCombo("gn_tpsz", "01", "GENSET", 0, " |")%> 

</script>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=userId%>" >
<input type="hidden" name="ofc_cd" value="<%=ofcId%>">
<input type="hidden" name="hid_provider">
<input type="hidden" name="hid_svc_provider">
<input type='hidden' name='TRSP_SO_VNDR_NO'>
<input type="hidden" name="insflag" value="true" >

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<!--Button_L (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_apply" name="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
    		<!--Button_L (E) -->


        <div id="showMin" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="70">W/O S/P</td>
							<td width="75">
							<input type='text' name='combo_svc_provider'  style="width:80;" onChange='getVendorSeq();'>
							</td>
							<td width="237"><input type="text" name='svc_provider' ReadOnly style="width:199;"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='btng_provider'></td>
							<td width="170">Payment Service Provider</td>
							<td width="80"><input name="paymt_sp_cd" type="hidden">
											<script language="javascript">ComComboObject('paymt_sp_combo', 1, 80, 1);</script></td>
							<td align="right"><input name="paymt_sp_nm" ReadOnly type="text" style="width:100%;" ></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="70">Invoice No.</td>
							<td width="100"><input type="text" style="width=80;" value="" name="inv_no"></td>
							<td width="101">Issue Date</td>
							<td width="117"><input type="text" style="width=80;" value="" name="inv_iss_dt" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
							<td width="90">Receive Date</td>
							<td><input type="text" style="width=80;" value="" name="inv_rcv_dt" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="70">Currency</td>
							<td width="100"><%=selCurr%></td>
							<td width="101">Invoice Amount</td>
							<td width="117"><input type="text" style="width=80; text-align:right;" maxlength="14" name="inv_bzc_amt" value="0.00" onKeyUp="isMon(this,'Y');" onKeyDown="chkInput(this); isMon(this,'Y');" onBlur="chkAmtFmtObj(this); sumAmt();"></td>
							<td width="90">V.A.T Amount</td>
							<td width="117"><input type="text" style="width=80; text-align:right;" name="inv_vat_amt" value="0.00"  onKeyUp='isMon(this,"Y");' onKeyDown='chkInput(this); isMon(this,"Y");' onBlur="chkAmtFmtObj(this);sumAmt();"></td>
							<td width="94">W.H.T Amount</td>
							<td width="101"><input type="text" style="width=80; text-align:right;" name="inv_whld_tax_amt" value="0.00"  onKeyUp='isMon(this,"Y");' onKeyDown='chkInput(this); isMon(this,"Y");' onBlur="chkAmtFmtObj(this);sumAmt();"></td>
							<td width="90">Total Amount</td>
							<td><input type="text" style="width=100%; text-align:right;" value="0.00" name="inv_ttl_amt"></td>
						</tr>
					</table>
				</td>
			</tr>
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
					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->


					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_invoicefileimport" name="btng_invoicefileimport">Invoice File Import</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_delete" name="btng_delete">Delete</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_confirm" name="btng_confirm">Confirm</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
			    		<!-- Button_Sub (E) -->


				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>