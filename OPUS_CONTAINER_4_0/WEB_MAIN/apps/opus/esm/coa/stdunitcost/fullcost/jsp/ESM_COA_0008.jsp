<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0008.jsp
*@FileTitle  : Route Cost (PA/RA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.fullcost.event.EsmCoa0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
    EsmCoa0008Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String xml          = "";
    
    Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.FullCost");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmCoa0008Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
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
        } // end if
        loadPage();
        
    }
</script>

<div id = "div_coa" style="display:inline">
<form name='form' onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml" value="<%= xml%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_Downexcel"    id="btn_Downexcel">Down Excel</button>
    </div>
    <!-- opus_design_btn(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
</div>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="150" />
                <col width="50"  />
                <col width="110" />
                <col width="50"  />
                <col width="110"  />
                <col width="50"  />
                <col width="110"  />    
                <col width="50" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th style="text-align:left">
                        <input type="radio" class="trans" name="conditionType" id="conditionType1" value="0" onClick="changeConditionType(this.value);"><!--
                        --><label for="conditionType1">Orgin To Destination</label>
                    </th>
                    <th title="Place of Receipt">POR</th>
                    <td>
                        <input type="text" style="width:80px" name="f_por" class="input1" value="" maxlength="5" style="ime-mode:disabled" dataformat="enguponly" disabled><!--
                        --><button type="button" class="input_seach_btn" name="f_icon_search1" id="f_icon_search1" onClick="openLocationCode('getF_por');" disabled></button>
                    </td>
                    <th title="Port of Loading">POL</th>
                    <td><input type="text" style="width:80px" class="noact2" name="f_pol" value="" maxlength="5"  style="ime-mode:disabled" dataformat="enguponly" disabled></td>
                    <th title="Port of Discharging">POD</th>
                    <td><input type="text" style="width:80px" class="noact2" name="f_pod" value="" maxlength="5"  style="ime-mode:disabled" dataformat="enguponly"disabled></td>
                    <th title="Place of Delivery">DEL</th>
                    <td>
                        <input type="text" style="width:80px"  name="f_del" class="input1" value="" maxlength="5"  style="ime-mode:disabled" dataformat="enguponly" disabled><!--
                        --><button type="button" class="input_seach_btn" name="f_icon_search2" id="f_icon_search2" onClick="openLocationCode('getF_del');" disabled></button>
                    </td>
                </tr>
                <tr>
                    <th style="text-align:left">
                        <input type="radio" name="conditionType" id="conditionType2" class="trans" value="1" onClick="changeConditionType(this.value);" checked><!--
                        --><label for="conditionType2">Port To/From Inland</label>
                    </th>
                    <th>From</th>
                    <td>
                        <input type="text" style="width:80px" class="input1" name="f_from" value="" maxlength="7"  style="ime-mode:disabled" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" name="f_icon_search3" id="f_icon_search3" onClick="openLocationCode('getF_from');"></button>
                    </td>
                    <th>To</th>
                    <td>
                        <input type="text" style="width:80px" class="input1" name="f_to" value="" maxlength="7"  style="ime-mode:disabled" dataformat="engup" onKeyDown="ComKeyEnter()"><!--
                        --><button type="button" class="input_seach_btn" name="f_icon_search4" id="f_icon_search4" onClick="openLocationCode('getF_to');"></button>
                    </td>
                    <th colspan="2">Location Hierarchy</th>
                    <td colspan="2"><script type="text/javascript">ComComboObject('f_cost_loc_grp_cd',1, 98 , 0 )</script></td>
                </tr>
            </tbody>
        </table>

        <table class="line_bluedot"><tr><td></td></tr></table>

        <table>
            <colgroup>
                <col width="1"  />
                <col width="70"  />
                <col width="80" />
                <col width="90"  />
                <col width="100" />
                <col width="200" />
                <col width="100" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>YYYY-MM</th>
                    <td><input type="text" class="input1" style="width:60px" name="f_cost_yrmon" value="" maxlength="6" dataformat="ym" ></td>
                    <th>Type/Size</th>
                    <td><script type="text/javascript">ComComboObject('f_cntr_tpsz_cd',1, 77 , 0 )</script></td>
                    <th>Activity Group</th>
                    <td><script type="text/javascript">ComComboObject('f_act_grp_cd',1, 185 , 0 )</script></td>
                    <th>
                        <input type="radio" class="trans" name="f_full_mty_cd"  id="rdo1" value="F" onClick="showActGrpCombo();" checked><label for="rdo1">Full</label><!--
                        --><input type="radio" class="trans" name="f_full_mty_cd" id="rdo2" value="M" onClick="hideActGrpCombo();"><label for="rdo2">Empty</label>
                    </th>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
    <div class="opus_design_btn" >
        <div id="div_zoom_in" style="display:inline" class="grid_option_right mar_btm_4">
            <button type="button" class="btn_down" name="bu_zoom_in" title="Zoom in(+)"></button>
        </div>
        <div id="div_zoom_out" style="display:none" class="grid_option_right mar_btm_4">
            <button type="button" class="btn_up" name="bu_zoom_out"  title="Zoom out(-)" ></button>
        </div>
          </div>
        <script type="text/javascript">ComSheetObject('sheet1');</script> 
    </div>
	<div style="display:none;">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
</div>
