<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0015.jsp
*@FileTitle  : Vessel Arrival Transmit (A6)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0015Event"%><%@ page import="org.apache.log4j.Logger" %>
<%
    EsmBkg0015Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg0015Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // If you imported data from the server initialization when loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="frm_act_arr_dt">

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
    	--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
    	--><button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">Transmit A6</button><!--
    	<button type="button" class="btn_normal" name="btn_arr_transmit" id="btn_arr_transmit">Actual Arrival Transmission</button><!--
    	--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete A6</button>
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
	<div class="opus_design_inquiry">
	    <table>
	        <colgroup>
	            <col width="90px"  />
	            <col width="180px"  />
	            <col width="90px"  />
	            <col width="" />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th title="Vessel Voyage Direction">VVD</th>
	                <td><input type="text" style="width:90px;ime-mode:disabled" class="input1" required dataformat="engup" name="vvd_cd" minlength="9" maxlength="9" caption="VVD"></td>
	                <th title="Port of Discharging">POD</th>
	                <td><input type="text" style="width:90px;ime-mode:disabled" class="input1" required dataformat="engup" name="pod_cd" minlength="5" maxlength="5" caption="POD"></td>
	            </tr>
	        </tbody>
	    </table>
	    <table class="line_bluedot"><tr><td></td></tr></table>
	    <table>
	        <colgroup>
	            <col width="90"/>
	            <col width="180"/>
	            <col width="90"/>
	            <col width="170" />
	            <col width="120"/>
	            <col width="139"/>
	            <col width="90"/>
	            <col width="50"/>
	            <col width="*"/>
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>Carrier Code</th>
	                <td><input type="text" style="width:130px;" class="input2" readonly="true" name="frm_crr_cd" id="frm_crr_cd" /> </td>
	                <th>Arrival Date</th>
	                <td><input type="text" style="width:130px;" maxlength="10" class="input" name="frm_vps_eta_dt" dataformat="ymd" caption="Arrival Date" id="frm_vps_eta_dt" /> </td>
	                <th>Actual Arrival Date</th>
	                <td><input type="text" style="width:130px;" maxlength="10" class="input" name="frm_act_arr_da" dataformat="ymd" caption="Arrival Date" id="frm_act_arr_da" /> </td>
	                <td><input type="text" style="width:130px;" maxlength="10" class="input" name="frm_act_arr_tm" dataformat="hm" caption="Actual Arrival Time" id="frm_act_arr_tm" /> </td>
	                <th>CRN</th>
	                <td><input type="text" style="width:130px; ime-mode:disabled" maxlength="20" class="input2" name="frm_cvy_ref_no" dataformat="eng" caption="CRN" readonly="readonly" id="frm_cvy_ref_no" /> </td>
	            </tr>
	            <tr>
	            	<th>CREW</th>
	                <td ><input type="text" style="text-align:center" class="input"  name="frm_crw_knt" id="frm_crw_knt" dataformat="num" caption="CREW" maxlength="3"></td>
	                <th>Captain Name</th>
	                <td colspan="7"><input type="text" style="width:747px;text-align:center" class="input" name="frm_cap_nm" id="frm_cap_nm" dataformat="enguponly" otherchar=" " caption="Captain Name" maxlength="500"></td>
	            </tr>
	        </tbody>
	    </table>
		<table class="line_bluedot"><tr><td></td></tr></table>
	    <table>
	        <colgroup>
	            <col width="90px"  />
	            <col width="*" />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>Total WGT</th>
	                <td><input type="text" style="width:130px;text-align:right" class="noinput2" readOnly="true" name="frm_cgo_wgt"></td>
	            </tr>
	        </tbody>
	    </table>
	    <table>
	        <colgroup>
	            <col width="90"/>
	            <col width="180"/>
	            <col width="90"/>
	            <col width="170" />
	            <col width="120"/>
	            <col width="*"/>
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>TEU Full</th>
	                <td><input type="text" style="width:130px;text-align:right" class="input2" readOnly="true" name="frm_teu_ful"></td>
	                <th>FEU Full</th>
	                <td><input type="text" style="width:130px;text-align:right" class="input2" readOnly="true" name="frm_feu_ful"></td>
	                <th>OTH Full</th>
	                <td><input type="text" style="width:130px;text-align:right" class="input2" readOnly="true" name="frm_oth_ful"></td>
	            </tr>
	            <tr>
	                <th>TEU Empty</th>
	                <td><input type="text" style="width:130px;text-align:right" class="input2" readOnly="true" name="frm_teu_mty"></td>
	                <th>FEU Empty</th>
	                <td><input type="text" style="width:130px;text-align:right" class="input2" readOnly="true" name="frm_feu_mty"></td>
	                <th>OTH Empty</th>
	                <td><input type="text" style="width:130px;text-align:right" class="input2" readOnly="true" name="frm_oth_mty"></td>
	            </tr>
	        </tbody>
	    </table>
	</div>
</div>
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none">
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- data_area(E) -->

</form>
