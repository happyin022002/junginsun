<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0057.jsp
*@FileTitle  : USA-FULL 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
*@LastVersion : 1.0
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0057Event"%>
<%
	EsdPrd0057Event  event = null; 
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
    try {
        event = (EsdPrd0057Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        selInvCodeNoSort = JSPUtil.getCodeCombo("i_inv", "01", "width='144' onChange='setCombindMode();'", "CD00126", 0, optStr);
        selPlanCodeNoSort = JSPUtil.getCodeCombo("i_rout_pln_cd", "01", "width='140'", "CD00127", 0, optStr);
        selWRSFullCode = JSPUtil.getCodeCombo("i_wrs_fl_cd",  "01", "width='140'", "CD00862", 0, optStr);
        selWRSEmptyCode = JSPUtil.getCodeCombo("i_wrs_mt_cd", "01", "width='140'", "CD00863", 0, optStr);        
    } catch(Exception e) {
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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="i_rout_org_nod_cd" id="i_rout_org_nod_cd" />
<input type="hidden" name="i_rout_dest_nod_cd" id="i_rout_dest_nod_cd" />
<input type="hidden" name="i_rout_seq" id="i_rout_seq" />
<input type="hidden" name="i_hub_search_gb" id="i_hub_search_gb" />
<input type="hidden" name="i_front_gb" id="i_front_gb" />
<input type="hidden" name="i_undefine_nod" id="i_undefine_nod" />
<input type="hidden" name="i_new_route_cd" id="i_new_route_cd" />
<input type="hidden" name="i_sel_row" id="i_sel_row" />
<input type="hidden" name="disable_bkg_flg" id="disable_bkg_flg" />
<input type="hidden" name="prio_seq_combo" id="prio_seq_combo" />
<input type="hidden" name="detail_org_i_inv" id="detail_org_i_inv" />
<input type="hidden" name="detail_org_i_rout_pln_cd" id="detail_org_i_rout_pln_cd" />
<input type="hidden" name="detail_org_i_bkg_flg" id="detail_org_i_bkg_flg" />
<input type="hidden" name="i_mcntr_rout_flg" value="" id="i_mcntr_rout_flg" />
<input type="hidden" name="detail_org_i_wrs_fl_cd">
<input type="hidden" name="detail_org_i_wrs_mt_cd">
<input type="hidden" name="r_btn_nod_ty_cd" value="Y" id="r_btn_nod_ty_cd" />
<input type="hidden" name="cnt_cd" value="" id="cnt_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>
		Delete Flag <input name="i_del_flg" id="i_del_flg" type="checkbox" class="trans"  value="Y" onClick="changeDeltFlg()" unchecked>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50px"/>
					<col width="50px"/>
					<col width="100px"/>
					<col width="70px"/>
					<col width="80px"/>
					<col width="70px"/>
					<col width="80px"/>
					<col width="70PX"/>
					<col width="80px"/>
					<col width="40"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td class="sm"><input type="hidden" name="r_btn_irg_cd" id="r_btn_irg_cd" value="I"><input type="radio" name='r_inbound' id='r_inbound' value='I' class="trans" onClick="changeSelection('I')" checked><b>IB</b></td>
					<td class="sm"><input type="radio" name='r_inbound' id='r_inbound' value='O' class="trans" onClick="changeSelection('O')"><b>OB</b></td>
					<td class="sm"><div id="div_desc" name="div_desc"><input type="radio" name='r_inbound' id='r_inbound' value='B' class="trans" onClick="changeSelection('B')"><b>TMNL SHTL</b></div></td>
					<script type="text/javascript">
								var desc = "Terminal Shuttle IRG for COP change " ;
								document.all.div_desc.title = desc;
								</script>
					 <th>Origin CD</th>
					  <td><input class="input1" name="i_org_cd" id="i_org_cd" type="text" caption="ORG CD" maxlength="7" tabIndex="1" style="width:65px;text-align:center"  dataformat="engup"><!-- 
					      --><button type="button" class="input_seach_btn" name="ib_org_loc_btn" id="ib_org_loc_btn"></button></td>
					  <th>DEST CD</td>
					  <td><input class="input1" name="i_dest_cd" id="i_dest_cd" type="text" caption="DEST CD" maxlength="7" tabIndex="2" style="width:65px;text-align:center"  dataformat="engup"><!--
					                	 --><button type="button" class="input_seach_btn" name="ib_dest_loc_btn" id="ib_org_loc_btn"></button></td>
					  <th>HUB CD</th>
					  <td><input name="i_hub_loc" id="i_hub_loc" type="text" caption="Hub LOC" maxlength="7" tabIndex="3" style="width:60px;text-align:center" dataformat="engup"></td>
					   <td class="sm">
					                <input type="radio" name='nod_tp_cd1' id='nod_tp_cd1' value='Y' class="trans" onClick="changeNodTy1('Y')" checked><b>Yard</b>&nbsp;&nbsp;
					                <input type="radio" name='nod_tp_cd1' id='nod_tp_cd1' value='Z' class="trans" onClick="changeNodTy1('Z')"><b>Zone</b></td>
					    <td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<!-- opus_design_inquiry(E) -->


<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<h3>If you want to change priority, please double-click on priority column.</h3>
</div>
</div>

<!-- opus_design_grid(E) -->
<div id="minimize" style="display:inline">
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
	<table>	
		<tbody>
			<colgroup>
				<col width="170px"/>
				<col width="300px"/>
				<col width="90px"/>
				<col width="*"/>
			 </colgroup>
			<tr>
				<th><img src="/opuscntr/img/ico_star.gif" >INV Billing &amp;INV Pattern </th>
				<td><%=selInvCodeNoSort %></td>
				<th><img src="/opuscntr/img/ico_star.gif" >Route Plan</th>
				<td><%=selPlanCodeNoSort %></td>
			</tr>	
			<tr class="h23">
				<th>Booking Flag <input name="i_bkg_flg" type="checkbox" class="trans" value="Y" unchecked></th>
				<td></td>
				<th>WRS(F)</th>
				<td><input name="wrs_f_chk" type="checkbox" class="trans" value="FN" unchecked> </td>							
			</tr>
		</tbody>	
	</table>
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btng_clear" id="btng_clear">Clear</button><!--
		--><button type="button" class="btn_normal" name="btng_new" id="btng_new">New</button><!--
		--><button type="button" class="btn_normal" name="btng_listlink" id="btng_listlink">List Link</button>
			<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
		--><button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btng_saveas" id="btng_saveas">Save As</button>
		
	</div>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<div class="opus_design_grid" id="hidden Table4">
    <script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<div class="opus_design_data">
	<table>	
		<tbody>
			<tr>
				<th>Remarks</th>
				<td><input name="i_route_rmk" id="i_route_rmk" type="text" style="width:900px"></td>
			</tr>	
		</tbody>	
	</table>
	</div>
<!-- opus_design_grid(E) -->
</div>
</div>

</form>

