<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_LSE_0019.jsp
*@FileTitle  : Receivable Charge & Invoice Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0019Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strQtyMonth	= "";
	String strOfc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strOfc_cd  = account.getOfc_cd();
		strQtyMonth = EesLse0019Event.getCurrAddMonths("yyyy-MM", -1);

		event = (EesLse0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="invoice_no" id="invoice_no" />
<input type="hidden" name="cost_yrmon" id="cost_yrmon" />
<input type="hidden" name="rcv_rntl_seq" id="rcv_rntl_seq" />
<input type="hidden" name="inv_agmt_seq" id="inv_agmt_seq" />
<input type="hidden" name="inv_lstm_cd" id="inv_lstm_cd" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="usr_id" value="<%= strUsr_id %>" id="usr_id" />
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>" id="ofc_cd" />
<input type="hidden" name="usd_xch_rt" id="usd_xch_rt" />
<input type="hidden" name="locl_tax_flg" id="locl_tax_flg" value="N" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--		
		--><button type="button" class="btn_accent" name="btn_ChargeCreation" 	id="btn_ChargeCreation">Monthly Charge Creation</button><!--
		--><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button>	 
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="80px"/>
					<col width="80px"/>
					<col width="80"/>
					<col width="100px"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Revenue Month</th>
					<td><input type="text" name="qty_yrmon" caption="Revenue Month" style="width:80px;text-align:center;ime-mode:disabled;" class="input1" value="<%= strQtyMonth %>" maxlength="6" dataformat="ym" required="" id="qty_yrmon" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
					<th>Term</th>
					<td><select name="lstm_cd" id="lstm_cd" caption="Term" style="width:80px;" class="input">
						<option value="" selected>All</option>
						<option value="SO">SO</option>
						<option value="MO">MO</option>
						</select></td>
					<th>Lessee</th>
					<td>
						<input type="text" name="vndr_seq" caption="Lessee" style="width:80px;text-align:center;" class="input" value="" maxlength="6" dataformat="num" id="vndr_seq" /><!--
						--><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button><!--
						--><input type="text" name="vndr_abbr_nm" style="width:100px;text-align:center;" class="input2" value="" readonly id="vndr_abbr_nm" /><!--
						--><input type="text" name="vndr_nm" style="width:300px;" class="input2" value="" readonly id="vndr_nm" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Row Delete</button><!--
			--><button type="button" class="btn_accent" name="btn_preparation" id="btn_preparation">Preparation</button><!--
			--><button type="button" class="btn_normal" name="btn_charge" 	id="btn_charge">Charge Creation</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

<!-- opus_design_grid(E) -->

<!-- opus_design_inquiry(S) -->

	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="100px"/>
					<col width="125px"/>
					<col width="100px"/>
					<col width="230px"/>
					<col width="100px"/>
					<col width="135px"/>
					<col width="20px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Invoice No.</th>
					<td><input type="text" name="inv_no" style="width:135px;text-align:center;" class="input2" value="" readonly id="inv_no" /> </td>
					<th>Lessee</th>
					<td>
						<input type="text" name="inv_vndr_seq" style="width:60px;text-align:center;" class="input2" value="" readonly id="inv_vndr_seq" /><!--
						--><input type="text" name="inv_vndr_abbr_nm" style="width:150px;" class="input2" value="" readonly id="inv_vndr_abbr_nm" />
					</td>
					<th>Customer</th>
					<td colspan="3">
						<input name="cust_cnt_cd" type="text" style="width:30px;text-align:left" class="input2" value="" maxlength="2" dataformat="engup" readonly id="cust_cnt_cd" /><!--
						--><input name="cust_seq" type="text" style="width:70px;text-align:left" class="input2" maxlength="6" value="" dataformat="num" readonly id="cust_seq" /><!--
						--><button type="button" id="btns_cust1" name="btns_cust1" class="input_seach_btn"></button><!--
						--><input name="cust_nm" type="text" style="width:190px;" class="input2" value="" readonly id="cust_nm" /><!--
						--><button type="button" id="btns_cust2" name="btns_cust2" class="input_seach_btn"></button>
					</td>
				</tr>
				<tr>
					<th>Invoice Amount</th>
					<td>
						<input type="text" name="fm_chg_amt" style="width:90px;text-align:right" class="input2" value="" readonly tabindex="-1" id="fm_chg_amt" /><!--
						--><input type="text" name="fm_curr_cd" style="width:40px;text-align:center" class="input2" value="" readonly tabindex="-1" id="fm_curr_cd" />
					</td>
					<th>Ex, Rate</th>
					<td>
						<!-- <select name="to_curr_cd" id="to_curr_cd" caption="Currency" style="width:60px;" class="input2">								
						</select> -->
						<script type="text/javascript">ComComboObject('to_curr_cd',2, 60 , 1,1);</script><!--
						--><input type="text" caption="Ex, Rate" name="to_curr_rt" style="width:95px;text-align:right" class="input2" value="" dataformat="float" maxlength="11" pointcount="3" maxnum="9999999.999" readonly id="to_curr_rt" />
					</td>
					<th>Receivable Amount</th>
					<td>
						<input type="text" name="to_chg_amt" style="width:135px;text-align:right" class="input2" value="" readonly tabindex="-1" id="to_chg_amt" />
					</td>
					<th>Tax</th>
					<td>
						<!-- <select name="locl_tax_flg" id="locl_tax_flg" style="width:60px">
							<option value="N" selected>&nbsp;0%</option>
							<option value="Y">10%</option>
		                </select> -->
		                <input type="text" name="inv_tax_rt" style="width:45px;text-align:right" dataformat="num" maxlength="4" class="input2" value="" tabindex="-1" id="inv_tax_rt" />%
		                <!--
						--><input name="tax_amount" type="text" style="width:125px;text-align:right" dataformat="float" pointcount="2" class="input2" value="" readonly tabindex="-1" id="tax_amount" />
					</td>
				</tr>
				<tr>
					<th>Invoice Issue Date</th>
					<td><input type="text" name="inv_isu_dt" caption="Invoice Issue Date" style="width:105px;text-align:center;" class="input2" value="" dataformat="ymd" readonly id="inv_isu_dt" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
					<th>Invoice Due Date</th>
					<td><input type="text" name="inv_due_dt" caption="Invoice Due Date" style="width:130px;text-align:center;" class="input2" value="" dataformat="ymd"  readonly id="inv_due_dt" /><button type="button" id="btns_calendar3" name="btns_calendar3" class="calendar ir"></button></td>
					<th colspan="2">TTL. Receivable Amount</th>
					<td colspan="2">
						<input type="text" name="ttl_chg_amt" style="width:165px;text-align:right" class="input2" value="" readonly tabindex="-1" id="ttl_chg_amt" /><!--
						--><input type="text" name="ttl_curr_cd" style="width:46px;text-align:center" class="input2" value="" readonly tabindex="-1" id="ttl_curr_cd" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>

<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->

	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_cntr" id="btn_cntr">CNTR List</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_accent" name="btn_invoice" id="btn_invoice">Invoice Creation</button><!--
			--><button type="button" class="btn_accent" name="btn_confirm" id="btn_confirm">Invoice Confirm</button><!--
			--><button type="button" class="btn_normal" name="btn_print" 	id="btn_print">Invoice Print</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result" style="display:none">
	<div class="opus_design_grid clear" >
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->								
</form>