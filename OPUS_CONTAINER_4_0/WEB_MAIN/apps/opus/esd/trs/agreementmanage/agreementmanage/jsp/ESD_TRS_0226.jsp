<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0226.jsp
*@FileTitle  : Agreement Rate Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	Exception					serverException		= null;			//Server Exception
	String						strErrMsg			= "";								 //Error Message
	String userId	 = "";
	String ofcCd     = "";
    String eq_knd_cd = "";
	String agmt_no = ((request.getParameter("chk_agmt_no")==null )?"":request.getParameter("chk_agmt_no"));		
	String trsp_agmt_rt_tp_ser_no = ((request.getParameter("chk_trsp_agmt_rt_tp_ser_no")==null )?"":request.getParameter("chk_trsp_agmt_rt_tp_ser_no"));	
	String trsp_agmt_rt_tp_cd = ((request.getParameter("chk_trsp_agmt_rt_tp_cd")==null )?"":request.getParameter("chk_trsp_agmt_rt_tp_cd"));
	String fm_effective_agmt     = ((request.getParameter("fm_effective_agmt")==null )?"":request.getParameter("fm_effective_agmt"));
    eq_knd_cd  = ((request.getParameter("eq_knd_cd")==null )?"":request.getParameter("eq_knd_cd"));

	String sub_title = "";
	
	try {
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (!trsp_agmt_rt_tp_ser_no.equals("")) {
			sub_title = " (Rate Type)";
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
<%= JSPUtil.getIBCodeCombo("trsp_cost_mod_cd",	"", "CD02177", 0, "")%>
<%= JSPUtil.getIBCodeCombo("agmt_trsp_tp_cd",	"", "CD00283", 0, "")%>
<%= JSPUtil.getIBCodeCombo("cgo_tp_cd",			"", "CD00748", 0, "")%>
<%= JSPUtil.getIBCodeCombo("rail_svc_tp_cd",	"", "CD00916", 0, "")%>
<%= BizComUtil.getIBCodeCombo("curr_cd",		"", "CURR", 0, "")%>
<%= JSPUtil.getIBCodeCombo("wtr_term_cd",	    "", "CD01354", 0, "")%>

  function setupPage(){
	loadPage();
  }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="fm_sub_title"	  value="<%=sub_title%>">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="header_row"	>
<input type="hidden" name="tot_page_cnt"	  value="">
<input type="hidden" name="cur_page_cnt"	  value="">
<input type="hidden" name="page_size"	  value="5000">
<input type="hidden" name="grid_flg"	  value="Y">
<input type="hidden" name="TRSP_SO_EQ_KIND" 		value="">
<input type="hidden" name="fm_eq_knd_cd" >
<input type="hidden" name="fm_trsp_agmt_rt_tp_ser_no" value="<%=trsp_agmt_rt_tp_ser_no%>">
<input type="hidden" name="fm_effective_agmt"   value="<%=fm_effective_agmt%>">

<input type="hidden" name="chk_trsp_cost_mod_cd" >
<input type="hidden" name="chk_agmt_trsp_tp_cd" >
<input type="hidden" name="chk_cgo_tp_cd" >
<input type="hidden" name="chk_cust_cd" >
<input type="hidden" name="chk_cmdt_grp_cd" >
<input type="hidden" name="chk_rail_svc_tp_cd" >
<input type="hidden" name="chk_fm_nod_cd" >
<input type="hidden" name="chk_fm_nod_yd" >
<input type="hidden" name="chk_via_nod_cd" >
<input type="hidden" name="chk_via_nod_yd" >
<input type="hidden" name="chk_dor_nod_cd" >
<input type="hidden" name="chk_dor_nod_yd" >
<input type="hidden" name="chk_to_nod_cd" >
<input type="hidden" name="chk_to_nod_yd" >
<input type="hidden" name="chk_trsp_dist_tp_cd" >
<input type="hidden" name="chk_trsp_agmt_dist" >
<input type="hidden" name="chk_dist_meas_ut_cd" >

<input type="hidden" name="fm_trsp_agmt_rt_tp_cd"	  value="P"> 
<input type="hidden" name="parm_eq_knd_cd" value="<%=StringUtil.xssFilter(eq_knd_cd)%>" id="parm_eq_knd_cd" />

	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Agreement Rate Inquiry</span></h2>
			<!-- page_title(E) -->
	
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">			
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
				--><!--<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>--><!--
				--><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->	
	
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->
	
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden">
	
	<!-- wrap_result_tab(S) -->
	<div class="wrap_search_tab"  id="MiniLayer">
		<!-- opus_design_inquiry(S) -->
			<!--  MiniLayer (S) -->				
			<div class="opus_design_inquiry wFit">			
	     		<!-- layout_vertical_2(S) -->
	   			<div class="layout_flex_fixed" style="width:660px;float:left!important">
					<table>
						<tbody>
							<tr>
								<th width="100">Agreement No.</th>
								<td width="100">
									<input name="fm_agmtno" type="text" style="width:80px;" class="input" value="<%=agmt_no%>" readonly>
								</td>
								<th width="100">Service Provider</th>
								<td>
									<input name="fm_vndr_prmry_seq" type="text"  style="width:60px;" readonly><!--								
									--><input name="fm_vndr_prmry_nm" type="text" style="width:216px;" readonly>
								</td>
							</tr>
							<tr>
								<th>Contract Office</th>
								<td>
									<input name="fm_ctrt_ofc_cd" type="text" style="width:80px;" readonly>
								</td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<th>Reference No.</th>
								<td>
									<input name="fm_agmt_ref_no" type="text" style="width:80px;" readonly>
								</td>
								<th>Remarks</th>
								<td>
									<input name="fm_inter_rmk" type="text" style="width:100%;" readonly>
								</td>								
							</tr>						
						</tbody>
					</table>	
					
					<!-- opus_design_grid(S)-->
					<div class="opus_design_grid">
						<script language="javascript">ComSheetObject('sheet0');</script>
					</div>
					<!-- opus_design_grid(S)-->					
					
				</div>
				<div class="layout_flex_flex" style="padding-left:668px">
					<!-- opus_design_grid(S)-->
					<div class="opus_design_grid" style="width:360px;">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</div>
					<!-- opus_design_grid(S)-->		
				</div>
			</div>		
			<table class="line_bluedot"><tr><td></td></tr></table>
			<div class="opus_design_inquiry wFit">	
			<table>
				<colgroup>
                    <col width="30" />
                    <col width="160" />
                    <col width="40" />
                    <col width="160" />
                    <col width="30" />
                    <col width="160" />
                    <col width="30" />
                    <col width="160" />
                    <col width="*" />
                </colgroup>
				<tbody>
					<tr>
		               	<th>From</th>
						<td><input name="search_fm_loc" type="text" style="width:70px;" maxlength="5" onfocus="fun_Focus(this)" onchange="getComboList(this, search_fm_yard, 'F');" onblur="" id="search_fm_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_fm_yard', 1, 40, 0)</script><button type="button" name="btns_frmnode" id="btns_frmnode" class="input_seach_btn"></button></td>
						<th>Via</th>
						<td><input name="search_via_loc" type="text" style="width:70px;" maxlength="5" onfocus="fun_Focus(this)" onchange="getComboList(this, search_via_yard, 'V');" onblur="" id="search_via_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_via_yard', 1, 43, 0)</script><button type="button" name="btns_vianode" id="btns_vianode" class="input_seach_btn"></button></td>
						<th>To</th>
						<td><input name="search_to_loc" type="text" style="width:70px;" maxlength="5" onfocus="fun_Focus(this)" onchange="getComboList(this, search_to_yard, 'T');" onblur="" id="search_to_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_to_yard', 1, 48, 0)</script><button type="button" name="btns_tonode" id="btns_tonode" class="input_seach_btn"></button></td>
						<th>Door</th>
						<td><input name="search_door_loc" type="text" style="width:70px;" maxlength="5" onfocus="fun_Focus(this)" onchange="getComboList(this, search_door_yard, 'D');" onblur="" id="search_door_loc" dataformat="engup" /><script type="text/javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><button type="button" name="btns_dornode" id="btns_dorloc" class="input_seach_btn"></button></td>
		            	</tr>
				</tbody>
			</table>
		</div>

	<!-- wrap_search_tab(E) -->
	</div>
	<!-- wrap_result(S) -->
	<div class="wrap_result" height="450">	
		<!-- opus_design_tab(S) -->
	    <div class="opus_design_tab">     	 	
	        <script language="javascript">ComTabObject('tab1')</script>       
	    </div>
	    <div class="opus_design_grid">
			<!-- opus_grid_btn(E) -->
			
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
		    	<div class="grid_option_left">
		    		<table>
						<tbody>
							<tr>
							  <th width="70">Page Size :</th>
		                      <td width="100">
		                    	  <select style="width:60px;" class="input" name="page_size1" onChange="javascript:input_change();">
			                          <option value="500">500</option>
			                          <option value="1000">1000</option>
			                          <option value="3000" selected>3000</option>
			                          <option value="5000">5000</option>
		                          </select>
		                       </td>
		                       <td width="20"><img class="cursor" img src="/opuscntr/img/bu_prev02.gif" border="0" name="reward1"></td>
		                       <th width="60">Page :</th>
		                       <td width="35"><input type="text"  class="input2" style="width:30px; valign:bottom; text-align:right;"  name="tot_page_cnt1" value="0"></td>
		                       <td width="45"><input type="text" style="width:30px; valign:bottom; text-align:right"  name="cur_page_cnt1" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
		                       <td><img class="cursor" img src="/opuscntr/img/bu_next02.gif" border="0" name="forward1"></td>
							</tr>
						</tbody>
					</table>    	    	
		    	</div>    	
		    	<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">				
					<button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button>
					<button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>			
				</div>
		    	<script language="javascript">ComSheetObject('sheet2');</script>
			</div>
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
		    	<div class="grid_option_left">
		    		<table>
						<tbody>
							<tr>
							  <th width="70">Page Size :</th>
		                      <td width="100">
		                    	  <select style="width:60px;" class="input" name="page_size2" onChange="javascript:input_change();">
			                          <option value="500">500</option>
			                          <option value="1000">1000</option>
			                          <option value="3000" selected>3000</option>
			                          <option value="5000">5000</option>
		                          </select>
		                       </td>
		                       <td width="20"><img class="cursor" img src="/opuscntr/img/bu_prev02.gif" border="0" name="reward2"></td>
		                       <th width="60">Page :</th>
		                       <td width="35"><input type="text"  class="input2" style="width:30px; valign:bottom; text-align:right;"  name="tot_page_cnt2" id="tot_page_cnt2" value="0"></td>
		                       <td width="45"><input type="text" style="width:30px; valign:bottom; text-align:right"  name="cur_page_cnt2" value="1" onkeydown="if (event.keyCode == 13) gotopage();" id="cur_page_cnt2"></td>
		                       <td><img class="cursor" img src="/opuscntr/img/bu_next02.gif" border="0" name="forward2"></td>
							</tr>
						</tbody>
					</table>    	    	
		    	</div>    	
		    	<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">				
					<button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button>
					<button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>			
				</div>
		    	<script language="javascript">ComSheetObject('sheet3');</script>
			</div>
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
		    	<div class="grid_option_left">
		    		<table>
						<tbody>
							<tr>
							  <th width="70">Page Size :</th>
		                      <td width="100">
		                    	  <select style="width:60px;" class="input" name="page_size3" onChange="javascript:input_change();">
			                          <option value="500">500</option>
			                          <option value="1000">1000</option>
			                          <option value="3000" selected>3000</option>
			                          <option value="5000">5000</option>
		                          </select>
		                       </td>
		                       <td width="20"><img class="cursor" img src="/opuscntr/img/bu_prev02.gif" border="0" name="reward3"></td>
		                       <th width="60">Page :</th>
		                       <td width="35"><input type="text"  class="input2" style="width:30px; valign:bottom; text-align:right;"  name="tot_page_cnt3" id="tot_page_cnt3" value="0"></td>
		                       <td width="45"><input type="text" style="width:30px; valign:bottom; text-align:right"  name="cur_page_cnt3" value="1" onkeydown="if (event.keyCode == 13) gotopage();" id="cur_page_cnt3"></td>
		                       <td><img class="cursor" img src="/opuscntr/img/bu_next02.gif" border="0" name="forward3"></td>
							</tr>
						</tbody>
					</table>    	    	
		    	</div>    	
		    	<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">				
					<button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button>
					<button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>			
				</div>
		    	<script language="javascript">ComSheetObject('sheet4');</script>
			</div>				
		</div>
	</div>
<!-- popup_contens_area(E) -->
</div>
</form>