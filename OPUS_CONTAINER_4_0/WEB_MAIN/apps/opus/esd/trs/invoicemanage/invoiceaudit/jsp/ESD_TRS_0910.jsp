<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_0910.jsp
*@FileTitle : Currency Change Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0910Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
	EsdTrs0910Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;

	String r_wo_currency  = "";
	String r_wo_totamount  = "";
	String r_invoice_currency  = "";

	r_wo_currency = ((request.getParameter("wo_currency")==null )?"":request.getParameter("wo_currency"));
	r_wo_totamount = ((request.getParameter("wo_totamount")==null )?"":request.getParameter("wo_totamount"));
	r_invoice_currency = ((request.getParameter("invoice_currency")==null )?"":request.getParameter("invoice_currency"));

	String selINVOICE = "";
	String optionStr = "000020:ALL:ALL";
	selINVOICE  = JSPUtil.getCodeCombo("sel_invoicemode", "01"		," onChange='invoice_OnChang(this);'","CURR_CD", 0, optionStr);
	try {
		event = (EsdTrs0910Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_woamount" value="D">
<input type="hidden" name="hid_invoicemode" value="<%=StringUtil.xssFilter(r_invoice_currency)%>">
<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Currency Change</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button><!--  -->
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<tr>
					<th width="100px">W/O Currency </th>
					<td width="250px"><input name="wo_currency" value="<%=StringUtil.xssFilter(r_wo_currency)%>"  class="input2" type="text" style="width:206px;" readonly></td>
					<th width="100px">W/O Total Amount </th>
					<td width="*"><input name="wo_totamount" value="<%=StringUtil.xssFilter(r_wo_totamount)%>"  class="input2" type="text" style="width:120px;"  readonly></td>
				</tr>
				<tr>
					<th>Invoice Currency</th>
					<td><%= BizComUtil.getCodeCombo("sel_invoicemode","","style='width:206px;' onChange='invoice_OnChang(this);'","CURR",1,"0::ALL") %></td>
					<th>Exchange Rate</th>
					<td><input name="ex_rate" type="text" style="width:120px;" onBlur="fn_check(this,'Exchange Rate');fun_addcomma();" onKeyup='enterCheck(this)'></td>
				</tr>
				<tr>
					<th>Invoice Amount </th>
					<td><input name="invoice_amount"  class="input2"  type="text" style="width:206px;"  onBlur="fn_check(this,'Invoice Amount');"   readonly></td>

				</tr>
			</table>
			<table>
				<tr style="height:30px">
					<th class="sm" width="105px">Calculation Logic</th>
				 	<td class="sm" width="200px"><input name="woamount" type="radio" value="TM"  class="trans"  onClick="change_amount();" checked> W/O Amount X Exchange Rate</td>
					<td class="sm" width="200px"><input name="woamount" type="radio" value="DV"  class="trans" onClick="change_amount();"> W/O Amount ÷ Exchange Rate</td>
					<td></td>
			     </tr>
			</table>
		</div>
	</div>
</div>
</form>
