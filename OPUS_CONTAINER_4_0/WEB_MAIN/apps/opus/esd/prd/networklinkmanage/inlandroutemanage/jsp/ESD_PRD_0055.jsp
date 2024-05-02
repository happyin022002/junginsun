<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0055.jsp
*@FileTitle  : Inland Route Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0005Event"%>

<%
    EsdPrd0005Event  event = null;
    Exception serverException   = null;
    DBRowSet rowSet      = null;
    String strErrMsg = "";
    int rowCount     = 0;
  
    String selInvCodeNoSort ="";
    String selPlanCodeNoSort = "";
    String selWRSFullCode = "";
    String selWRSEmptyCode = "";    
    String optStr = "000010::";
    String optStr2="|000010: : ";
    
    String popMode  = (request.getParameter("pop_mode") == null)? "N": "Y";  
    try {
        event = (EsdPrd0005Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        selInvCodeNoSort = JSPUtil.getCodeCombo("i_inv", "01", "width='144' onChange='setCombindMode();'", "CD00126", 0, optStr);
        selPlanCodeNoSort = JSPUtil.getCodeCombo("i_rout_pln_cd", "01", "width='140'", "CD00127", 0, optStr);
        selWRSFullCode = JSPUtil.getCodeCombo("i_wrs_fl_cd", "01", "width='140'", "CD00862", 0, optStr);
        selWRSEmptyCode = JSPUtil.getCodeCombo("i_wrs_mt_cd", "01", "width='140'", "CD00863", 0, optStr);        
     }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("rail_crr_tp_cd", "01", "CD00287", 0, optStr2)%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>
<form method="post" name="form" id="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage">
<input type="hidden" name="i_rout_org_nod_cd" id="i_rout_org_nod_cd">
<input type="hidden" name="i_rout_dest_nod_cd" id="i_rout_dest_nod_cd">

<input type="hidden" name="i_rout_seq" id="i_rout_seq">
<input type="hidden" name="i_hub_search_gb" id="i_hub_search_gb">
<input type="hidden" name="i_front_gb" id="i_front_gb">
<input type="hidden" name="i_undefine_nod" id="i_undefine_nod">
<input type="hidden" name="i_newRouteCd"  id="i_newRouteCd">
<input type="hidden" name="i_selRow" id="i_selRow">
<input type="hidden" name="disable_bkg_flg" id="disable_bkg_flg">
<input type="hidden" name="prio_seq_combo" id="prio_seq_combo">


<!-- page_title_area(S) -->
<% if (popMode.equals("Y")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span> Inland Route Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
	</div>
</div>   
<% } else { %>
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<% } %>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="50"/>
					<col width="50"/>
					<col width="90"/>
					<col width="50"/>
					<col width="70"/>
					<col width="120"/>
					<col width="40"/>
					<col width="*"/>
			    </colgroup>
				<tr class="h23">
			        <th class="sm" style="text-align:left"><input type="radio" name='r_inbound' id='r_inbound' value='I' class="trans" onClick="changeSelection('I')" checked>IB<input type="hidden" name="rBtnIrgCd" value="I"></th>
			        <th class="sm" style="text-align:left"><input type="radio" name='r_inbound' id='r_inbound' value='O' class="trans" onClick="changeSelection('O')">OB</th>
			        <th class="sm" style="text-align:left"><input type="radio" name='r_inbound' id='r_inbound' value='B' class="trans" onClick="changeSelection('B')">TMNL STL</th>
			        <th class="sm" style="text-align:left"><input type="radio" name='r_inbound' id='r_inbound' value='M' class="trans" onClick="changeSelection('M')">MT</th>
			        <th>From</th>
			        <td><input class="input1" name="i_org_cd" id="i_org_cd" type="text" required caption="From" maxlength="7" tabIndex="1" style="width:70px;text-align:center" style="text-transform:uppercase" dataformat="engup" style="text-align:center"><!-- 
			             --><button type="button" class="input_seach_btn" name="ib_org_loc_btn" id="ib_org_loc_btn"></button></td>
			        <th>To</th>
			        <td><input class="input1" name="i_dest_cd" id="i_dest_cd" type="text" required caption="To" maxlength="7" tabIndex="2" style="width:70px;text-align:center" style="text-transform:uppercase" dataformat="engup" style="text-align:center"><!--
			             --><button type="button" class="input_seach_btn" name="ib_dest_loc_btn" id="ib_dest_loc_btn"></button></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_data(S) -->
	<div class="opus_design_inquiry" >
		<table >
			<tbody>
				<tr class="h23">
					<td><h3>The details are available for checkup by double-click on constraint column.</h3></td>
				</tr>
			</tbody>
		</table>
	</div>			
	<!-- opus_design_data(E) -->

<!-- opus_design_grid(E) -->

	<div id="minimize">
		<!-- opus_design_grid(S) -->
			<div class="opus_design_inquiry">
				<table>
					<tbody>
						<colgroup>
							<col width="160px" style="text-align:left;"/>
							<col width="350px"/>
							<col width="78px" style="text-align:left;"/>
							<col width="350px"/>
							<col width="78px" style="text-align:left;"/>
							<col width="*"/>
						</colgroup>
						<tr>
							<th>INV Billing INV Pattern </th>
							<td><%=selInvCodeNoSort %></td>
							<th>Route Plan</th>
							<td><%=selPlanCodeNoSort %></td>
							<td colspan="2">
						</tr>
						<tr>
							<th>Booking Flag</th>
							<td><input name="i_bkg_flg" id="i_bkg_flg" type="checkbox" class="trans" value="Y" unchecked></td>
							<th>WRS(F)</td>
							<td><%=selWRSFullCode %></td>
							<th>WRS(M)</th>
							<td><%=selWRSEmptyCode %></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="opus_design_grid" >
				<script type="text/javascript">ComSheetObject('sheet2');</script>	
			</div>
			<div class="opus_design_inquiry">
				<table >
					<tbody>
						<colgroup>
							<col width="90px"/>
							<col width="*"/>
						</colgroup>
						<tr>
							<th style="text-align:left;padding-left:15px;">Remarks</th>
							<td><div><input name="i_route_rmk" id="i_route_rmk" type="text" style="width:900px"></div></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
</div>
</form>