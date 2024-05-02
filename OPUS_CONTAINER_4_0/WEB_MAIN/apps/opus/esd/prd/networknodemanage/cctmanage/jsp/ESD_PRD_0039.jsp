<%@page import="com.clt.framework.component.util.JSPUtil"%>
<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0039.jsp
*@FileTitle  : VGM CCT History
*@author     : CLT
*@version    : 1.0
*@since      : 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
String yd_cd = JSPUtil.getParameter(request, "yd_cd");
String vps_port_cd = JSPUtil.getParameter(request, "vps_port_cd");
String vsl_slan_cd = JSPUtil.getParameter(request, "vsl_slan_cd");
String vsl_slan_dir_cd = JSPUtil.getParameter(request, "vsl_slan_dir_cd");
String cgo_tp_cd = JSPUtil.getParameter(request, "cgo_tp_cd");
String clpt_ind_seq = JSPUtil.getParameter(request, "clpt_ind_seq");
String pctl_use_flg = JSPUtil.getParameter(request, "pctl_use_flg");
String vgm_flg = JSPUtil.getParameter(request, "vgm_flg");
String vvd_cd = JSPUtil.getParameter(request, "vvd_cd");

%>
<script type="text/javascript">
	var pctl_use_flg = "<%= pctl_use_flg %>";
	var vgm_flg = "<%= vgm_flg %>";
    function setupPage(){
        loadPage();
    }
</script>

<form method="post" name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pctl_use_flg" id="pctl_use_flg" value="<%= pctl_use_flg %>" />
<input type="hidden" name="vps_port_cd" id="vps_port_cd" value="<%= vps_port_cd %>" />
 <div class="layer_popup_title">
    <div class="page_title_area clear">
        <h2 class="page_title">
            <span>VGM CCT History</span>
        </h2>
        <div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
        </div>
    </div>
</div>
<div class="layer_popup_contents">
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
    <% if("Y".equals(pctl_use_flg)) { %>
        <table>
            <colgroup>
                <col width="80" />
                <col width="100" />
                <col width="80" />
                <col width="60" />
                <col width="80" />
                <col width="40" />
                <col width="80" />
                <col width="60" />
                <col width="80" />
                <col width="40" />
                <col width="*" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Yard Code</th>
                    <td><input type="text" name="yd_cd" style="width:100px;ime-mode:disabled" id="yd_cd"  readonly="readonly"  value="<%= yd_cd %>" /> </td>
                    <th>Lane Code</th>
                    <td><input type="text" name="vsl_slan_cd" style="width:60px;ime-mode:disabled" id="vsl_slan_cd"  readonly="readonly"  value="<%= vsl_slan_cd %>" /> </td>
                    <th>Bound</th>
                    <td><input type="text" name="vsl_slan_dir_cd" style="width:40px;ime-mode:disabled" id="vsl_slan_dir_cd"  readonly="readonly"  value="<%= vsl_slan_dir_cd %>" /> </td>
                    <th>Cargo Type</th>
                    <td><input type="text" name="cgo_tp_cd" style="width:60px;" id="cgo_tp_cd" readonly="readonly"  value="<%= cgo_tp_cd %>" /> </td>
                    <th>VGM Flag</th>
                    <td><input type="text" name="vgm_flg" style="width:40px;" id="vgm_flg" readonly="readonly"  value="<%= vgm_flg %>" /> </td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    <% } else { %> 
        <table>
            <colgroup>
                <col width="80" />
                <col width="100" />
                <col width="80" />
                <col width="60" />
                <col width="80" />
                <col width="80" />
                <col width="80" />
                <col width="40" />
                <col width="*" />
            </colgroup>
            <tbody>
                <tr>
                    <th>VVD</th>
                    <td><input type="hidden" name="clpt_ind_seq" id="clpt_ind_seq" value="<%= clpt_ind_seq %>" />
                    	<input type="text" name="vvd_cd" style="width:100px;ime-mode:disabled" id="vvd_cd"  readonly="readonly"  value="<%= vvd_cd %>" />
                    </td>
                    <th>Lane Code</th>
                    <td><input type="text" name="vsl_slan_cd" style="width:60px;ime-mode:disabled" id="vsl_slan_cd"  readonly="readonly"  value="<%= vsl_slan_cd %>" /> </td>
                    <th>Port Code</th>
                    <td><input type="text" name="yd_cd" style="width:80px;ime-mode:disabled" id="yd_cd"  readonly="readonly"  value="<%= yd_cd %>" /> </td>
                    <th>VGM Flag</th>
                    <td><input type="text" name="vgm_flg" style="width:40px;" id="vgm_flg" readonly="readonly"  value="<%= vgm_flg %>" /> </td>
                    <td></td>
                </tr>
            </tbody>
        </table>     
    <% } %>        
	</div>
</div>
<div class="wrap_result">
    <div class="opus_design_grid">
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
</div>
</div>
</form>