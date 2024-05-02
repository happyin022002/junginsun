<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0041.jsp
*@FileTitle : Pool Chassis reposition cost 처리
*Open Issues :
*Change history :
*@LastModifyDate : 2008-12-04
*@LastModifier : ah young Han
*@LastVersion : 1.0
* 2008-12-04 ah young Han
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
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.event.EsdTrs0041Event"%>
<%

	EsdTrs0041Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String selCurr ="";
	selCurr  = BizComUtil.getCodeCombo("inv_curr_cd","USD","style=width:90 onchange=checkCurr(this.value)","CURR",2,"0::ALL");

	String userId = "";
	String ofcId = "";


	String currentYearMonth = DateTime.getFormatString("yyyyMM");



	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofcId=account.getOfc_cd();

		event = (EsdTrs0041Event)request.getAttribute("Event");

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
<title>Pool Chassis reposition cost 처리</title>
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



<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="insflag" value="true" >
<input type="hidden" name="paymt_sp_cd">
<input type="hidden" name="trsp_inv_aud_sts_cd">
<input type="hidden" name="hidden_chss_pool_cd">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (START) ####### -->

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
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

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
							<td width="80">Cost Month</td>
							<td width="105"><input type="text" style="width=90;"value="<%=currentYearMonth%>" name="pool_chss_cost_yrmon" onKeyUp='isYearMonth(this);' onKeyDown='isYearMonth(this);' onBlur="chkYearMonth(this);"></td>
							<td>&nbsp;</td>
					        </td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="82">Pool Name</td>
							<td width="92"><script language="javascript">ComComboObject('chss_pool_cd',2, 90 , 1 )</script></td>
							<td width="300"><input type="text" name='chss_pool_nm' ReadOnly style="width:270;"></td>
							<td width="160">Payment Service Provider</td>
							<td align="right"><input name="paymt_sp" type="text" style="width:103;" ReadOnly class="input2"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input name="paymt_sp_nm" type="text" style="width:234;" ReadOnly class="input2"></td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">Invoice No.</td>
							<td width="394"><input type="text" style="width=90;" value="" name="inv_no"></td>
							<td width="164">Receive Date</td>
							<td width="148"><input type="text" style="width=80;" value="" name="inv_rcv_dt" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></td>
						    <td width="90">Issue Date</td>
							<td><input type="text" style="width=80;" value="" name="inv_iss_dt" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">Currency</td>
							<td width="158"><%=selCurr%></td>
							<td width="105">Invoice Amount</td>
							<td width="130"><input type="text" style="width=101;text-align:right;" maxlength="14" name="inv_bzc_amt" value="0.00" ReadOnly class="input2"></td>
							<td width="165">Tax Amount</td>
							<td width="148"><input type="text" style="width=80;text-align:right;" name="inv_vat_amt" value="0.00" ReadOnly class="input2"></td>
							<td width="90">Total Amount</td>
							<td><input type="text" style="width=80;text-align:right;" value="0.00" name="inv_ttl_amt"  ReadOnly class="input2"></td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="145">Invoice Creation Office</td>
							<td width="329"><input type="text" style="width=299;" value="<%=ofcId%>" name="ofc_cd" ReadOnly class="input2"></td>
							<td width="164">Invoice Creation User ID</td>
							<td><input type="text" style="width=319;" value="<%=userId%>" name="usr_id" ReadOnly class="input2"></td>
					   	</tr>
					</table>
					</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

	</div>
		<!-- TABLE '#D' : ( Tab ) (S) -->

		<!-- TABLE '#D' : ( Tab ) (E) -->
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
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
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_save" name="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_invconfirm" name="btng_invconfirm">Invoice Confirm</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_invconfrimcancel" name="btng_invconfrimcancel">Invoice Confirm Cancel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_invoicedelete" name="btng_invoicedelete">Invoice Delete</td><td class="btn2_right"></td></tr></table></td>
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
</body>
</html>
