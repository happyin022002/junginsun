<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0056.jsp
*@FileTitle  : USA-Empty 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0056Event"%>
<%
	EsdPrd0056Event  event = null;  
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
        event = (EsdPrd0056Event)request.getAttribute("Event");
        serverException   = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        selInvCodeNoSort  = JSPUtil.getCodeCombo("i_inv", "01", "style='width:200' onChange='setCombindMode();'", "CD00126", 0, optStr);
        selPlanCodeNoSort = JSPUtil.getCodeCombo("i_rout_pln_cd", "01", " style='width:180'", "CD00127", 0, optStr);
        selWRSFullCode    = JSPUtil.getCodeCombo("i_wrs_fl_cd", "01", "width='140'", "CD00862", 0, optStr);
        selWRSEmptyCode   = JSPUtil.getCodeCombo("i_wrs_mt_cd", "01", "width='140'", "CD00863", 0, optStr);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("rail_crr_tp_cd", "01", "CD00287", 0, optStr2)%>
	<%= JSPUtil.getIBCodeCombo("inv_bill_ptn", "01", "CD00126", 0, optStr)%>
	<%= JSPUtil.getIBCodeCombo("rout_plan", "01", "CD00127", 0, optStr)%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>
<form method="post" name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<input type="hidden" name="detail_org_i_inv" id="detail_org_i_inv" />
<input type="hidden" name="detail_org_i_rout_pln_cd" id="detail_org_i_rout_pln_cd" />

<input type="hidden" name="i_rout_org_nod_cd" id="i_rout_org_nod_cd" />
<input type="hidden" name="i_rout_dest_nod_cd" id="i_rout_dest_nod_cd" />

<input type="hidden" name="i_rout_seq" id="i_rout_seq" />

<input type="hidden" name="i_selrow" id="i_selrow" />

<input type="hidden" name="i_new_route_cd" id="i_new_route_cd" />

<input type="hidden" name="i_org_cd" id="i_org_cd" />
<input type="hidden" name="i_dest_cd" id="i_dest_cd" />

<input type="hidden" name="detail_org_i_wrs_fl_cd" />
<input type="hidden" name="detail_org_i_wrs_mt_cd" />

<input type="hidden" name="i_hub_search_gb" id="i_hub_search_gb" />
<input type="hidden" name="i_front_gb" id="i_front_gb" />
<input type="hidden" name="i_undefine_nod" id="i_undefine_nod" />


<input type="hidden" name="disable_bkg_flg" id="disable_bkg_flg" />
<input type="hidden" name="prio_seq_combo" id="prio_seq_combo" />


<input type="hidden" name="detail_org_i_bkg_flg" id="detail_org_i_bkg_flg" />
<input type="hidden" name="i_mcntr_rout_flg" value="" id="i_mcntr_rout_flg" />
<input type="hidden" name="cnt_cd" value="" id="cnt_cd" />
<input type="hidden" name="wrs_flg" value="" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!--
		 --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--
		 --><span style="height:100px; width:100px; background-color: #F3F2F8;"><b>Delete Flag</b>&nbsp;<input name="i_del_flg" id="i_del_flg" type="checkbox" class="trans"  value="Y" onClick="changeDeltFlg()" unchecked></span>
	</div>
	
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
			<table>	
				<tbody>
					<colgroup>
						<col width="45px"/>
						<col width="200px"/>
						<col width="45px"/>
						<col width="200px"/>
						<col width="45px"/>
						<col width="200px"/>
						<col width="*"/>
			    	</colgroup>
					<tr>
						<th>From</th>
						<td><input name="from_cd" id="from_cd" type="text" maxlength="7" tabIndex="1" style="text-transform:uppercase;text-align:center" style="width:100px"><!-- 
							 --><button type="button" class="input_seach_btn" name="ib_org_tml_btn" id="ib_org_tml_btn"></button></td>
						<th>To</th>
						<td><input name="to_cd" id="to_cd" type="text"  maxlength="7" tabIndex="2" style="text-transform:uppercase;text-align:center" style="width:100px"  ><!-- 
								 --><button type="button" class="input_seach_btn" name="ob_dest_tml_btn" id="ob_dest_tml_btn"></button>
						</td>
						<th>WRS Flag</th>
						<td class="sm pad_left_4">
								<input type="radio" name='rWrs' id="radio1" value=''   onClick="changeSelection('')"   class="trans" tabIndex="3" checked="checked"><label for="radio1">ALL</label><!-- 
							 --><input type="radio" name='rWrs' id="radio2" value='MN' onClick="changeSelection('MN')" class="trans"><label for="radio2">Y</label><!-- 
							 --><input type="radio" name='rWrs' id="radio3" value='N'  onClick="changeSelection('N')"  class="trans"><label for="radio3">N</label>
						</td>
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
				<col width="300px"/>
				<col width="90px"/>
				<col width="*"/>
			 </colgroup>
			<tr>
				<th><img src="/opuscntr/img/ico_star.gif" >INV Billing &amp;INV Pattern </th>
				<td><%=selInvCodeNoSort %></td>
				<th><img src="/opuscntr/img/ico_star.gif" >Route Plan</th>
				<td><%=selPlanCodeNoSort %></td>
				<th>WRS(M)</th>
				<td><input name="wrs_chk" type="checkbox" class="trans" value="MN" unchecked> </td>
			</tr>	
		</tbody>	
	</table>
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btng_clear" id="btng_clear">Clear</button><!--
		--><button type="button" class="btn_normal" name="btng_new" id="btng_new">New</button><!--
		--><button type="button" class="btn_normal" name="btng_listlink" id="btng_listlink">List Link</button>
			<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
		--><button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button><!--
		--><button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>
		
	</div>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_data" >
	<table>	
		<tbody>
			<tr>
				<th>Remarks</th>
				<td><input name="i_route_rmk" type="text" style="width:900px"></td>
			</tr>	
		</tbody>	
	</table>
</div>
<!-- opus_design_grid(E) -->
</div>
</div>

</form>
