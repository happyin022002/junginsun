<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1031.jsp
*@FileTitle  : Payable Charge Audit Result & Payable Amount Confirm
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1031Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1031Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

	String vndrSeq = "";
	String costYrmon = "";
	String chgCreSeq = "";
	String lseChgStsCd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1031Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vndrSeq = StringUtil.xssFilter(request.getParameter("vndr_seq"));
		costYrmon = StringUtil.xssFilter(request.getParameter("cost_yrmon"));
		chgCreSeq = StringUtil.xssFilter(request.getParameter("chg_cre_seq"));
		lseChgStsCd = StringUtil.xssFilter(request.getParameter("lse_chg_sts_cd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
    $("html").addClass("layer_popup_document").prepend("<button type='button' class='pop_close ir' onclick='ComClosePopup();' onmouseup='opener.closeSearch();'>Close</button>");
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eq_knd_cd" value="" id="eq_knd_cd" />
<input type="hidden" name="chg_cre_seq" value="<%=chgCreSeq%>" id="chg_cre_seq" />
<input type="hidden" name="lse_chg_sts_cd" value="<%=lseChgStsCd%>" id="lse_chg_sts_cd" />
<input type="hidden" name="inv_dt" value="" id="inv_dt" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Charge Audit Result & Payable Amount Confirm</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_soCreate" id="btn_soCreate">Payable Amount Confirm</button><!--
			--><button type="button" class="btn_normal" name="btn_remove" id="btn_remove">Delete</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">	
	<div class= "wrap_search_tab">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="470" />
					<col width="80" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Lessor</th>
						<td><input name="vndr_seq" type="text" style="width:60px;text-align:center" readonly class="input2" value="<%=vndrSeq %>" id="vndr_seq" /><input name="vndr_lgl_eng_nm" readonly type="text" style="width:350px;" class="input2" value="" id="vndr_lgl_eng_nm" /></td>
						<th>Cost Month</th>
						<td><input name="cost_yrmon" type="text" style="width:60px;text-align:center" readonly class="input2" value="<%=costYrmon %>" id="cost_yrmon" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
		</div>	
		<div id="tabLayer"  style="display:inline">
			
				<div class="opus_design_grid clear" id="mainTable" >
					<div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_coin_back" 	id="btn_coin_back">Back.</button><!--
						--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down&nbsp;Excel</button><!--
					--></div>
					<script type="text/javascript">ComSheetObject('t1sheet1');</script>
				</div>
				<div class= "opus_design_inquiry wFit">
					<table>
						<colgroup>
							<col width="220" />
							<col width="220" />
							<col width="180" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<td>Charge Amount : <input type="text" name="pay_chg_smry_amt" readonly style="width:80px;text-align:right;" class="input2" value="" id="pay_chg_smry_amt" /> </td>
								<td>Payable Amount : <input type="text" name="inv_smry_amt" readonly style="width:80px;text-align:right;" class="input2" value="" id="inv_smry_amt" /> </td>
								<td>Sales Tax  : <input type="text" name="tax_smry_amt" readonly style="width:80px;text-align:right;" class="input2" value="" id="tax_smry_amt" /> </td>
								<td>Credit : <input type="text" name="cr_smry_amt" readonly style="width:80px;text-align:right;" class="input2" value="" id="cr_smry_amt" /> </td>
							</tr>
						</tbody>
					</table>
				</div>
		</div>
		<div id="tabLayer"  style="display:none">
				<div class="opus_design_grid clear" id="mainTable" >
					<div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_coin" 	id="btn_coin">Coin.</button><!--
						--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down&nbsp;Excel</button><!--
					--></div>
					<script type="text/javascript">ComSheetObject('t2sheet1');</script>
				</div>
				<div class= "opus_design_inquiry wFit">
					<table>
						<colgroup>
							<col width="220" />
							<col width="220" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<td>Charge Amount : <input type="text" name="lse_chg_amt" readonly style="width:80px;text-align:right;" class="input" value="" id="lse_chg_amt" /> </td>
								<td>Invoice Amount : <input type="text" name="inv_lse_chg_amt" readonly style="width:80px;text-align:right;" class="input" value="" id="inv_lse_chg_amt" /> </td>
								<td>Difference : <input type="text" name="diff" readonly style="width:80px;text-align:right;color:red" class="input" value="" id="diff" /> </td>
							</tr>
						</tbody>
					</table>
				</div>
		</div>
		<div id="tabLayer" style="display:none">
				<div class="opus_design_grid clear" id="mainTable" >
					<div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_downExcel" id="btn_downExcel">Down&nbsp;Excel</button><!--
					--></div>
					<script type="text/javascript">ComSheetObject('t3sheet1');</script>
				</div>
				<div class= "opus_design_inquiry wFit">
					<table>
						<colgroup>
							<col width="220" />
							<col width="220" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<td>Charge Amount : <input type="text" name="lse_chg_amt2" readonly style="width:80px;text-align:right;" class="input" value="" id="lse_chg_amt2" /> </td>
								<td>Invoice Amount : <input type="text" name="inv_lse_chg_amt2" readonly style="width:80px;text-align:right;" class="input" value="" id="inv_lse_chg_amt2" /> </td>
								<td>Difference : <input type="text" name="diff2" readonly style="width:80px;text-align:right;color:red" class="input" value="" id="diff2" /> </td>
							</tr>
						</tbody>
					</table>
				</div>
		</div>
		<div id="tabLayer" style="display:none">
				<div class="opus_design_grid clear" id="mainTable" >
					<div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_coin" 	id="btn_coin">Coin.</button>
						<button type="button" class="btn_accent" name="btn_downExcel" id="btn_downExcel">Down&nbsp;Excel</button><!--
						--><button type="button" class="btn_normal" name="btn_add" id="btn_add">Row&nbsp;Add</button><!--
						--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row&nbsp;Delete</button><!--
					--></div>
					<script type="text/javascript">ComSheetObject('t4sheet1');</script>
				</div>
				<div class= "opus_design_inquiry wFit">
					<table>
						<colgroup>
							<col width="220" />
							<col width="220" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<td>Charge Amount : <input type="text" name="lse_chg_amt3" readonly style="width:80px;text-align:right;" class="input" value="" id="lse_chg_amt3" /> </td>
								<td>Invoice Amount : <input type="text" name="inv_lse_chg_amt3" readonly style="width:80px;text-align:right;" class="input" value="" id="inv_lse_chg_amt3" /> </td>
								<td>Difference : <input type="text" name="diff3" readonly style="width:80px;text-align:right;color:red" class="input" value="" id="diff3" /> </td>
							</tr>
						</tbody>
					</table>
				</div>
		</div>
	</div>
		
	<div id="hiddenLayer" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>  
	</div>
	<div id="hiddenLayer" style="display:none">
	    <script type="text/javascript">ComSheetObject('t1sheet1_tmp');</script>  
	</div>
	<div id="hiddenLayer" style="display:none">
	    <script type="text/javascript">ComSheetObject('t2sheet1_tmp');</script>  
	</div>
	<div id="hiddenLayer" style="display:none">
	    <script type="text/javascript">ComSheetObject('t4sheet1_tmp');</script>  
	</div>
</div>
</form>