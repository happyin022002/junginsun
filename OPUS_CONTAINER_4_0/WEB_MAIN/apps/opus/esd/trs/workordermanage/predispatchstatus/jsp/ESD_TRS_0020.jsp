<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0020.jsp
*@FileTitle  : Pre-Dispatch Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.predispatchstatus.event.EsdTrs0020Event"%>
<%
    SignOnUserAccount account = null;
    EsdTrs0020Event  event = null;  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;
    DBRowSet rowSet = null; //DB ResultSet
    String strErrMsg = ""; 
    int rowCount = 0; 

    String queryParam = JSPUtil.getNull(request.getParameter("queryParam"));
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (EsdTrs0020Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript" src="/opuscntr/rpt/script/rdviewer50.js"></script>
<script type="text/javascript">
    var lvParam = "<%=queryParam%>";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "03");
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="queryParam" value="">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="rtv_flg" value="">

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
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
        --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
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
	<div class="opus_design_inquiry wFit" id="showMin"">
	    <!--  biz_1 (S) -->
	    <table>
	        <colgroup>
	            <col width="110" />
	            <col width="280" />
	            <col width="120" />
	            <col width="180"  />
	            <col width="150"  />
	            <col width=""    />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>Date</th>
	                <td class="sm" colspan="3" align="center"><!--
	    			--><input type="radio" name="rad_wonotic" class="trans" value="W" checked id="rad_wonotic1"><label class="pad_left_4 mar_rgt_12" for="rad_wonotic1">Work Order Issue</label><!--
	    			--><input type="radio" name="rad_wonotic" class="trans" value="L" id="rad_wonotic2"><label class="pad_left_4 mar_rgt_8" for="rad_wonotic2">List Sent</label><!--
	    			--><input type="radio" name="rad_wonotic" class="trans" value="N" id="rad_wonotic3"><label class="pad_left_4 mar_rgt_8" for="rad_wonotic3">Notice Sent</label><!--
	    			--><input name="frm_plandate" id="frm_plandate" type="text" maxlength="8" style="width:75px" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);">~&nbsp;<!--
	    			--><input name="to_plandate" id="to_plandate" type="text" maxlength="8" style="width:75px" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();"><!--
	    			--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
	                </td>
	                <td colspan=2></td>
	            </tr>
	            <tr>
	                <th>Reference No. </th>
	                <td><input name="reference_no" type="text" style="width:218px;"></td>
	                <th>Work Order No.</th>
	                <td><!--
	    			--><input name="wo_no" type="text" style="width:107px;" value="" dataformat="engup"  otherchar=","><!--
	    			--><button type="button" class="multiple_inq ir" name="btns_multiwrk" id="btns_multiwrk"></button>
	                </td>
	                <td colspan=2></td>
	            </tr>
	            <tr>
	                <th>Booking No.</th>
	                <td><!--
	    			--><input name="bkg_no" type="text" style="width:190px;" value="" dataformat="engup" otherchar=","><!--
	    			--><button type="button" class="multiple_inq ir" name="btns_multibkg" id="btns_multibkg"></button>
	                </td>
	                <th>Bill Of Lading No.</th>
	                <td><!--
	    			--><input name="bill_no" type="text" style="width:107px;" value="" dataformat="engup" otherchar=","><!--
	    			--><button type="button" class="multiple_inq ir" name="btns_multibl" id="btns_multibl"></button>
	                </td>
	                <th>Container No.</th>
	                <td><!--
	    			--><input name="cntr_no" type="text" style="width:109px;" value="" dataformat="engup" onChange="javascript:this.value=cntrCheckDigit(this.value);" otherchar=","><!--
	    			--><button type="button" class="multiple_inq ir" name="btns_multicntr" id="btns_multicntr"></button>
	                </td>
	            </tr>
	            <tr>
	                <th>Service Provider</th>
	                <td colspan="3"><!--
	    			--><input name="combo_svc_provider" type="text" style="width:73px;" value="" maxlength="6" onBlur="vender_blur();"><!--
	    			--><input type="text" name="trsp_so_vndr_no" style="width:430px;" readonly value="" class="input2"><!--
	    			--><button type="button" class="input_seach_btn" name="btns_vender" id="btns_vender"></button>
	                </td>
	                <th>Work Order Issue Office</th>
	                <td><!--
	    			--><input name="wo_iss_ofc_cd" maxlength="5" type="text" style="width:109px;"><!--
	    			--><button type="button" class="input_seach_btn" name="btns_woissoffice" id="btns_woissoffice"></button>
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
    <div class="opus_design_btn"><!--
    --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!--
    --><button type="button" class="btn_normal" name="btng_senthistory" id="btng_senthistory">Sent History</button><!--
    --><button type="button" class="btn_normal" name="btng_preview" id="btng_preview">Preview</button>
    </div>
    <!-- opus_grid_btn(E) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
<form method="post" name="formRd">
    <input type="hidden" name="ref_no" value="">
    <input type="hidden" name="vndr_seq" value="">
    <input type="hidden" name="so_ofc_cty_cd" value="">
    <input type="hidden" name="so_seq" value="">
    <input type="hidden" name="wo_ofc_cty_cd" value="">
    <input type="hidden" name="wo_seq" value="">
    <input type="hidden" name="ddl" value="">
    <input type="hidden" name="can" value="">
    <input type="hidden" name="loc_date" value="">
    <input type="hidden" name="tit_date" value="">
</form>