<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0116.jsp
*@FileTitle  : booking report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/30
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0116Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0116Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";              //error message
    int rowCount     = 0;               //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.BookingReport.StatusReport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg0116Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="tab_tp" value="0">

<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="pol_yd_cd">
<input type="hidden" name="pod_yd_cd">
<input type="hidden" name="usr_id" value="<%= strUsr_id %>">

<!-- 제목(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- btn_div(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
    </div>
    <!-- btn_div(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- 제목(E) -->


<div class="wrap_search_tab">
		<!--biz page (S)-->
		<div class="opus_design_inquiry wFit">
    <!--  biz_1 (S) -->
    <table>
        <colgroup>
            <col width="50px"  />
            <col width="160px" />
            <col width="50px"  />
            <col width="105px" />
            <col width="30px"  />
            <col width="95px"  />
            <col width="60px"  />
            <col width="90px"  />
            <col width="68px"  />
            <col width="112px" />
            <col width="60px"  />
            <col width=""      />
        </colgroup>
        <tbody>
            <tr>
                <th title="Vessel Voyage Direction">VVD</th>
                <td><input type="text" id="vvd" name="vvd" style="width:114px;" value="" class="input1" dataformat="engup" maxlength="9"></td>
                <th title="Port of Loading">POL</th>
                <td>
                    <input type="text" id="pol_cd" name="pol_cd" style="width:60px;" value="" dataformat="engup" maxlength="5"><!--  
                    --><input type="text" id="pol_nod_cd" name="pol_nod_cd" style="width:20px;" value="" dataformat="engup" maxlength="2" class="input">
                </td>
                <th title="Port of Discharging">POD</th>
                <td>
                    <input type="text" id="pod_cd" name="pod_cd" style="width:60px;" value="" dataformat="engup" maxlength="5"><!--
                    --><input type="text" id="pod_nod_cd" name="pod_nod_cd" style="width:20px;" value="" dataformat="engup" maxlength="2" class="input">
                </td>
                <th>R/D</th>
                <td>
                    <script language="javascript">ComComboObject('rcv_term_cd', 2, 40, true, '');</script>
                    <script language="javascript">ComComboObject('de_term_cd', 2, 40, true, '');</script>
                </td>
                <th>BKG Office</th>
                <td><input type="text" name="bkg_ofc_cd" style="width:70px;" value="" dataformat="engup" maxlength="6"></td>
                <th>BKG Staff</th>
                <td><input type="text" name="cre_usr_id" style="width:70px;" value="" maxlength="20"></td>
            </tr>
            <tr>
                <th>CNTR No.</th>
                <td><input type="text" name="cntr_no" style="width:114px;" value="" dataformat="engup" maxlength="12"></td>
                <th>BKG No.</th>
                <td colspan="3"><input name="bkg_no" type="text" style="width:116px;" value="" dataformat="engup" maxlength="13"></td>
                <th>B/L No.</th>
                <td colspan="3"><input name="bl_no" type="text" style="width:120px;" value="" dataformat="engup" maxlength="12"></td>
                <th>Sales Rep.</th>
                <td><input name="ob_srep_cd" type="text" style="width:70px;" value="" dataformat="engup" maxlength="5"></td>
            </tr>
            <tr>
                <th>Shipper</th>
                <td colspan="8">
                    <input type="text" name="cust_cnt_cd" style="width:30px;" value="" dataformat="engup" maxlength="2"><!--
                    --><input type="text" name="cust_seq" style="width:80px;" value="" dataformat="int" maxlength="6"><!--
                    --><input type="text" name="cust_nm" style="width:212px;" value="" >
                </td>
            </tr>
        </tbody>
    </table> 
    <!--  biz_1   (E) -->   
</div>
</div>
<!-- 검색영역(E)-->


<div class="wrap_result">
	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab">
	    <script language="javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->

	<!-- opus_design_grid(S) -->
	<div name="tabLayer" id="tabLayer" class="opus_design_grid" style="display:inline">
	    <!-- opus_grid_btn(S) -->
	    <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	    </div>
	    <!-- opus_grid_btn(E) -->
	
	    <script language="javascript">ComSheetObject('t1sheet1');</script>
	
		<div class="grid_option_right">
	        <table class="grid2 noinput2" style="width:700px">
	            <tbody>
	                <tr>
	                    <th width="120">Total Package</th>
	                    <td width="10"><input type="text" name="tot_package" style="width:100px; text-align:right;"  readonly></td>
	                    <th width="120">Total Weight</th>
	                    <td width="10"><input type="text" name="tot_weight" style="width:100px; text-align:right;"  readonly></td>
	                    <th width="120">Total Measure(CBM)</th>
	                    <td><input type="text" name="tot_Measure" style="width:100px; text-align:right;"  readonly></td>
	                </tr>
	            </tbody>
	        </table>
        </div>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="tabLayer" name="tabLayer" style="display:none">
	    <!-- opus_grid_btn(S) -->
	    <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btn_print2" id="btn_print">Print</button>
	        <button type="button" class="btn_normal" name="btn_checkall" id="btn_checkall">Check All</button>
	        <button type="button" class="btn_normal" name="btn_uncheckall" id="btn_uncheckall">Uncheck All</button>
	    </div>
	    <!-- opus_grid_btn(E) -->
	
	    <script language="javascript">ComSheetObject('t2sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
