<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0031.jsp
*@FileTitle  : Terminal invoice CSR Creation - Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0031Event"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl"%>
<%
	EsdTrs0031Event event = null;
	Exception serverException = null;
	String strErrMsg = "";
	String cnt_cd = "";
	String ofc_cd = "";
	String[] arrChinaSpeOffice = { "SZPBB", "CANBS" };
	String sBranchIndicator = "N";
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		ofc_cd = account.getOfc_cd();
		CSRIssueTransferSlipManageBCImpl csrBC = new CSRIssueTransferSlipManageBCImpl();
		cnt_cd = csrBC.searchOfficeChangedCntCd(ofc_cd);
		for (int i = 0; i < arrChinaSpeOffice.length; i++) {
			if (arrChinaSpeOffice[i].equals(ofc_cd)) {
				sBranchIndicator = "Y";
				break;
			}
		}
		event = (EsdTrs0031Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var cnt_cd = "<%=cnt_cd%>";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form  method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="is_valid_vndr_seq">
<input type="hidden" name="vndr_seq_hidden">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
         --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!--  biz_1 (S) -->
	    <table>
	        <colgroup>
	            <col width="180" />
	            <col width="130" />
	            <col width="100" />
	            <col width="110" />
	            <col width="80"  />
	            <col width="150" />
	            <col width="80"  />
	            <col width=""/>
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>Invoice Office</th>
	                <td><input class="input1" name="cost_ofc_cd" type="text" maxlength="6" style="width:100px" value="<%=ofc_cd%>" readonly ></td>
	                <th>Confirmed Date</th>
                <td><input name="inv_cfm_dt" type="text" maxlength="10" style="width:80px" value="" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyUp="javascript:isNum(this);"  dataformat="num"><!--
                     --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>
                </td>
                <th>Interface</th>
                <td align="center">
                    <input type="radio" id="asanogb" name="asanogb" value="A/P" class="trans" checked onkeypress="enter();"><label for="asanogb">To A/P</label>
                    <input type="radio" id="asanogb2" name="asanogb" value="ASA" class="trans" onkeypress="enter();"><label for="asanogb2">To ASA</label>
                </td>
                <% if("Y".equals(sBranchIndicator)) { %>
                <th>Payment</th>
                <td align="center">
                    <input type="radio" id="paymenttype" name="paymenttype" value="BRANCH" class="trans" checked onkeypress="enter();"><label for="paymenttype">By Branch</label>
                    <input type="radio" id="paymenttype2" name="paymenttype" value="RHQ" class="trans" onkeypress="enter();"><label for="paymenttype2">By RHQ</label></td>
                <% }else{ %>
                <td></td>
                <td></td>
                <% } %>
            </tr>
            <tr>
                <th>Payment Service Provider</th>
                <td colspan="7">
                    <input name="combo_svc_provider" type="text" maxlength="6" style="width:100px" value="" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' dataformat="engup"><!--
                     --><button type="button" class="input_seach_btn" name="btng_provider" id="btng_provider"></button><!--
                     --><input name="svc_provider" type="text" style="width:430px" readOnly class="input2">
                </td>
            </tr>
        </tbody>
    </table>
    <!--  biz_1   (E) -->   
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
	    <!-- opus_grid_btn(S) -->
	    <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btng_detail" id="btng_detail">Detail</button>
	    </div>
	    <!-- opus_grid_btn(E) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

<form action="ESD_TRS_0032.do" name="form1"     >
    <input type="hidden" name="form_inv_cfm_dt"     > 
    <input type="hidden" name="vndr_seq"        >
    <input type="hidden" name="vndr_seq_name"   >
    <input type="hidden" name="curr_cd"         >
    <input type="hidden" name="gen_pay_term_cd" >
    <input type="hidden" name="pay_term_tp_cd"  >
    <input type="hidden" name="payment_due_dt"  >
    <input type="hidden" name="asanogb"         >
    <input type="hidden" name="paymenttype"     >
    <input type="hidden" name="cost_office_cd"  >
    <input type="hidden" name="conti_cd"    >
    <input type="hidden" name="pgmNo"   >
    <input type="hidden" name="invoice_office_cd" value="<%=ofc_cd%>">
</form>

