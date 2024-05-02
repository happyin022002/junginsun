<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0012.jsp
*@FileTitle  : Empty Repo & Drayage for On/Off Hire
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.event.EsdTrs0012Event"%>
<%
    SignOnUserAccount account = null;
    EsdTrs0012Event  event = null;

    Exception serverException   = null;
    DBRowSet rowSet   = null;
    String strErrMsg = "";
    int rowCount     = 0;
    String selKIND = "";
    String selCntrSize = "";
    String optionStr = "000020:ALL:ALL";
    String today = DateTime.getFormatString("yyyyMMdd");
    String beforeOneMonth = DateTime.getFormatDate(DateTime.addDays(today, -30), "yyyyMMdd", "yyyy-MM-dd");
	String afterOneMonth = DateTime.getFormatDate(DateTime.addDays(today, 30), "yyyyMMdd", "yyyy-MM-dd");
    String isInquiry = "N";
    String refNo     = "";
    String ofcCd     = "";
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        selKIND  = JSPUtil.getCodeCombo("sel_kind", "01", "style=width:160", "CD00812", 0, optionStr);
        selCntrSize  = JSPUtil.getCodeCombo("cntr_size", "01", "style=width:60", "CD00937", 0, optionStr);
        event = (EsdTrs0012Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        refNo   = JSPUtil.getParameter(request, "refNo");
        if (refNo.indexOf(",") >= 0){
        	isInquiry = "Y";
        	ofcCd="";
        	beforeOneMonth = "";
        	afterOneMonth = "";
        } else {
        	ofcCd=account.getOfc_cd();
        }
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="cbstatus" id="cbstatus" />
<input type="hidden" name="hid_frmreqdate" id="hid_frmreqdate" />
<input type="hidden" name="hid_toreqdate" id="hid_toreqdate" />
<input type="hidden" name="hid_trsp_cost_mod_cd" id="hid_trsp_cost_mod_cd" />
<input type="hidden" name="hid_ref_id" id="hid_ref_id" />
<input type="hidden" name="hid_fm_nod_cd" id="hid_fm_nod_cd" />
<input type="hidden" name="hid_to_nod_cd" id="hid_to_nod_cd" />
<input type="hidden" name="hid_fm_yard_cd" id="hid_fm_yard_cd" />
<input type="hidden" name="hid_to_yard_cd" id="hid_to_yard_cd" />
<input type="hidden" name="hid_trsp_crr_mod_cd" id="hid_trsp_crr_mod_cd" />
<input type="hidden" name="hid_eq_tpsz_cd" id="hid_eq_tpsz_cd" />
<input type="hidden" name="hid_cntr_no" id="hid_cntr_no" />
<input type="hidden" name="hid_cntr_tpsz_cd" id="hid_cntr_tpsz_cd" />
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>" id="ctrl_ofc_cd" />
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>" id="ctrl_user_id" />
<input type="hidden" name="TRSP_SO_EQ_KIND" value="" id="TRSP_SO_EQ_KIND" />
<input type="hidden" name="eq_no_verify" value="" id="eq_no_verify" />
<input type="hidden" name="frm_node_verify" value="" id="frm_node_verify" />
<input type="hidden" name="old_ofc_cd" value="<%=account.getOfc_cd()%>" id="old_ofc_cd" />
<input type="hidden" name="page_type" value="C" id="page_type" />
<input type="hidden" name="isInquiry"       value="<%=isInquiry%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) --><h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
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

<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit" id="MiniLayer">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="100" />
                <col width="180" />
                <col width="50"  />
                <col width="220" />
                <col width="124" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Departure Date</th>
                    <td><input name="frm_reqdate" id="frm_reqdate" class="input1" type="text" style="width:75px;"  value="<%=beforeOneMonth%>" dataformat="ymd" onBlur="javascript:getDateBetween(this);"><span class="dash">~</span><!--
                        --><input name="to_reqdate" id="to_reqdate" class="input1" type="text" style="width:75px;" value="<%=afterOneMonth%>" dataformat="ymd" onKeyup="javascript:doSearchEnter();"><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
                    </td>
                    <th>Kind</th>
                    <td><%=selKIND%></td>
                    <th>Service Order Office</th>
                    <td><input name="ctrl_so_office" id="ctrl_so_office" class="input1" type="text" style="width:90px;" value="<%=ofcCd%>" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" name="btns_office" id="btns_office"></button><!--
                        --><input type="checkbox" name="chk_office"  id="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();"><label for="chk_office">Incl. Sub OFC</label>
                    </td>
                </tr>
                <tr>
                    <th>From </th>
                    <td><input name="frm_node" id="frm_node" type="text" style="width:75px;" maxlength="5" onChange="getComboList(this, 'frm_yard', 'F');" onBlur="setgetUpper(this);" dataformat="engup"><!--
                        --><script type="text/javascript">ComComboObject('frm_yard', 1, 85, 0)</script><!--
                        --><button type="button" class="input_seach_btn" name="btns_frmnode" id="btns_frmnode"></button>
                        <input name="search_fm_node" type="text" style="width:107px;" onchange="resetLocYard('FROM');" onblur="" id="search_fm_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_fm_node" name="btns_multi_search_fm_node" class="multiple_inq ir"></button>
                    </td>
                    <th>To</th>
                    <td>
                        <input name="to_node" id="to_node" type="text" style="width:56px;" maxlength="5" onChange="getComboList(this, 'to_yard', 'T');" onBlur="setgetUpper(this);" dataformat="engup"><!--
                        --><script type="text/javascript">ComComboObject('to_yard', 1, 80, 0)</script><!--
                        --><button type="button" class="input_seach_btn" name="btns_tonode" id="btns_tonode"></button>
                        <input name="search_to_node" type="text" style="width:107px;" onchange="resetLocYard('TO');" onblur="" id="search_to_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_to_node" name="btns_multi_search_to_node" class="multiple_inq ir"></button>
                    </td>
                    <th>Container Type/Size</th>
                    <td><select name="cntr_type" id="cntr_type" style="width:63px;" onChange="">
                            <option value="ALL" selected>ALL</option>
                            <option value="A">A</option>
                            <option value="D">D</option>
                            <option value="F">F</option>
                            <option value="O">O</option>
                            <option value="P">P</option>
                            <option value="R">R</option>
                            <option value="S">S</option>
                            <option value="T">T</option>
                        </select><!--
                        --><%=selCntrSize%>
                    </td>
                </tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
	<div class="opus_design_inquiry wFit" id="MiniLayer1">
		<table>
            <colgroup>
                <col width="100" />
                <col width="210" />
                <col width="100"  />
                <col width="210" />
                <col width="80" />
                <col width="220" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Reference No.</th>
                    <td><input type="text" name="reference_no" id="reference_no" style="width:164px;" value="<%=refNo%>" onKeyup="javascript:doSearchEnter();" dataformat="engup" otherchar=","><button type="button" class="multiple_inq ir" name="btns_multireference" id="btns_multireference"></button></td>
                    <th>Booking No.</th>
                    <td><input type="text" name="bkg_no" id="bkg_no" style="width:140px" value="" onKeyup="javascript:doSearchEnter();" onChange="checkDigit(this);" dataformat="engup" otherchar=","><button type="button" class="multiple_inq ir" name="btns_multibkgno" id="btns_multibkgno"></button></td>
                    <th>Container No.</th>
                    <td><input type="text" name="cntr_no" id="cntr_no" style="width:140px" value="" onKeyup="javascript:doSearchEnter();" onChange="checkDigit(this);" dataformat="engup" otherchar=","><button type="button" class="multiple_inq ir" name="btns_multicntrno" id="btns_multicntrno"></button></td>
                    <td colspan="2"></td>
                </tr>
            </tbody>
        </table>
        <!--  biz_1   (E) -->   
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <!-- opus_grid_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btng_apply" id="btng_apply">Apply</button>
        </div>
        <!-- opus_grid_btn(E) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <!-- opus_grid_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btng_officetransfer" id="btng_officetransfer">Office Transfer</button><!-- 
             --><button type="button" class="btn_normal" name="btng_fillincontainers" id="btng_fillincontainers">Fill in CNTR No.</button><!-- 
             --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!-- 
             --><button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button><!-- 
             --><button type="button" class="btn_normal" name="btng_socreation" id="btng_socreation">S/O Creation</button><!-- 
             --><button type="button" class="btn_normal" name="btng_woissue" id="btng_woissue">W/O Issue</button>
        </div>
        <!-- opus_grid_btn(E) -->
        <script type="text/javascript">ComSheetObject('t1sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <script type="text/javascript">ComSheetObject('sheet2');</script>
    </div>
    <!-- opus_design_grid(E) -->

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <script type="text/javascript">ComSheetObject('sheet3');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

</form>

<form name='woForm' method='POST'>
    <input type='hidden' name='trsp_so_ofc_cty_cd'>
    <input type='hidden' name='trsp_so_seq'>
    <input type='hidden' name='eq_mode'>
    <input type="hidden" name="sysCommUiTitle" value="Issue">
    <input type="hidden" name="sysCommUiNavigation" value="Trans S/O > Work Order">
    <input type="hidden" name="pgmNo" value='ESD_TRS_0023'>
</form>
