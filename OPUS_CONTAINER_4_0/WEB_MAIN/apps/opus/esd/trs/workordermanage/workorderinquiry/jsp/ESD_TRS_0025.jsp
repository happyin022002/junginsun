<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0025.jsp
*@FileTitle  : W/O issued Inquiry
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
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0025Event"%>
<%
    EsdTrs0025Event  event = null;
    Exception serverException	= null;         
    DBRowSet rowSet   = null;                            
    String strErrMsg = "";                              
    int rowCount     = 0;                                
    SignOnUserAccount account= null;
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (EsdTrs0025Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        out.println(e.toString());
    }
    String today = DateTime.getFormatString("yyyyMMdd");
    String beforeOneMonth = DateTime.addMonths(today, -1);
    String optionStr = "000020:ALL:ALL";
    String selCOSTMODE = "";
    String selTRANSMODE = "";
    selCOSTMODE  = JSPUtil.getCodeCombo("sel_costmode", "01"    ," onChange='bound_OnChange_2(this);', style='width:157'", "CD00958", 0, optionStr);
    selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01"  ," onChange='bound_OnChange_3(this);'", "CD00283", 0, optionStr);
%>

<script language="javascript">
    var beforeOneMonth = '<%=beforeOneMonth%>';
    var today = '<%=today%>';

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="TRSP_WO_OFC_CTY_CD">
<input type="hidden" name="TRSP_WO_SEQ">
<input type="hidden" name="WO_ISS_KNT">
<input type="hidden" name="VNDR_SEQ">
<input type="hidden" name="isResend" value='Y'>
<input type="hidden" name="WO_EDI_USE_FLG" value='EDI'>
<input type="hidden" name="wo_no_a" value=''>
<input type="hidden" name="hid_costmode">
<input type="hidden" name="hid_transmode">
<input type="hidden" name='btn_go' value =''>
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
        --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!-- 
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
<div class="opus_design_inquiry wFit" id="MiniLayer">
    <!--  biz_1 (S) -->
    <table>
        <colgroup>
            <col width="155" />
            <col width="190" />
            <col width="150" />
            <col width="150" />
            <col width="130" />
            <col width="130" />
            <col width="80"  />
            <col width=""    />
        </colgroup>
        <tbody>
            <tr>
                <th>Work Order Issue Date</th>
                <td>
                    <input name="fmdate" type="text" maxlength="8" style="width:75px;" dataformat="ymd" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);getDateBetween(this);" >~
                    <input name="todate" type="text" maxlength="8" style="width:75px;" dataformat="ymd" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);"><!--  
                    --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
                </td>
                <th>Service Provider</th>
                <td colspan="5">
                    <input type='text' name='combo_svc_provider'  style="width:82px;" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' dataformat="engup"><!--
                      --><input type="text" name='svc_provider' ReadOnly class="input2" style="width:453px;" dataformat="engup"><!--
                      --><button type="button" class="input_seach_btn" name="btng_provider" id="btng_provider"></button>
                </td>
            </tr>
            <tr>
                <th>Work Order No.</th>
                <td>
                    <input name="wo_no" type="text" onBlur='javascript:this.value=this.value.toUpperCase();' style="width:167px;" maxlength='180' dataformat="engup" otherchar=","><!--
                      --><button type="button" class="multiple_inq ir" name="btns_wo_no" id="btns_wo_no"></button>
                </td>
                <th>Work Order Issue Office</th>
                <td>
                    <input name="wo_issue_office" type="text" onBlur='javascript:this.value=this.value.toUpperCase();'style="width:82px;" value='<%=account.getOfc_cd()%>' maxlength='5' onBlur='value_upper(this)' dataformat="engup"><!--
                      --><button type="button" class="input_seach_btn" name="btns_wo_issue_office" id="btns_wo_issue_office" onClick="ofc_OnPopupClick()"></button>
                </td>
                <th>Work Order Issue User</th>
                <td colspan="3">
                    <input name="wo_issue_user" type="text" style="width:100px;" maxlength='20' dataformat="excepthan">
                </td>
            </tr>
            <tr>
                <th>Work Order Issue Status</th>
                <td>
                    <select name="wo_iss_sts" style="width:93px;">
                        <option value=""  selected>ALL</option>
                        <option value="I" >Issued</option>
                        <option value="R" >Reissued</option>
                        <option value="C" >Correction</option>
                        <option value="N" >Cancellation</option>
                    </select>
                </td>
                <th>Cost Mode</th>
                <td><%=selCOSTMODE%></td>
                <th>Issue type</td>
                <td>
                    <select name="issue_type" style="width:100px;">
                        <option value=""  selected></option>
                        <option value="PR" >PRN</option>
                        <option value="FA" >FAX</option>
                        <option value="EM" >EML</option>
                        <option value="ED" >EDI</option>
                    </select>
                </td>
                <th>Trans Mode</th>
                <td><%=selTRANSMODE%></td>
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
	        <button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>
	        <button type="button" class="btn_normal" name="btng_detailinquiry" id="btng_detailinquiry">Detail Inquiry</button>
	        <button type="button" class="btn_normal" name="btng_wopreview" id="btng_wopreview">W/O Preview</button>
	    </div>
	    <!-- opus_grid_btn(E) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <script language="javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<div class="header_fixed"></div>
</form>

<form name='woForm' method='POST' action='ESD_TRS_0024.screen'>
<input type="hidden" name="pgmNo" >
<input type='hidden' name='trsp_so_ofc_cty_cd'>
<input type='hidden' name='trsp_so_seq'>
<input type='hidden' name='wo_cancel_flag'>
<input type='hidden' name='detain'>
<input type='hidden' name='bno_issue'>
<input type='hidden' name='sowonumber'>
<input type='hidden' name='eq_mode' value='IS'>
<input type='hidden' name='issued'>
<input type='hidden' name='wo_check'>
<input type='hidden' name='parentPgmNo' value="ESD_TRS_M001">
<input type='hidden' name='isInquiry' value='Y'>
<input type="hidden" name="sysCommUiTitle" value="Preview">
<input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
<input type="hidden" name='p_pop_flg' value ='N'>
<input type="hidden" name="wo_no_a">
</form>
