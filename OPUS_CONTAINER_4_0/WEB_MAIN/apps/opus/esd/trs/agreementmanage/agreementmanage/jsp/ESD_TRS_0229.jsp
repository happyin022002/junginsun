<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0229.jsp
*@FileTitle  : Agreement Surcharge Rate Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
	Exception	serverException		= null;			//error from server
	String	strErrMsg = "";			//error message
	String userId	  = "";
	String ofc_cd	  = "";
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
	   	ofc_cd						= account.getOfc_cd();
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
<%= JSPUtil.getIBCodeCombo("trsp_scg_cd",	    "", "CD30002", 0, "")%>

<%= BizComUtil.getIBCodeCombo("curr_cd",		"", "CURR", 0, "")%>

  function setupPage(){
	var formObject = document.form;
	formObject.fm_trsp_agmt_rt_tp_cd.value = "<%=trsp_agmt_rt_tp_cd%>";
    loadPage();
  }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofc_cd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="fm_sub_title"	  value="<%=sub_title%>">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="header_row"	>
<input type="hidden" name="tot_page_cnt"	  value="">
<input type="hidden" name="cur_page_cnt"	  value="">
<input type="hidden" name="page_size"	  value="5000">
<input type="hidden" name="grid_flg"	  value="Y">
<input type="hidden" name="fm_trsp_agmt_rt_tp_ser_no" value="<%=trsp_agmt_rt_tp_ser_no%>">
<input type="hidden" name="fm_eq_knd_cd" >
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
<input type="hidden" name="chk_trsp_scg_cd" >
<input type="hidden" name="chk_agmt_route_all_flg" >
<!-- Pair Type set to always -->
<input type="hidden" name="fm_trsp_agmt_rt_tp_cd"	  value="P"> 
<input type="hidden" name="parm_eq_knd_cd" value="<%=StringUtil.xssFilter(eq_knd_cd)%>" id="parm_eq_knd_cd" />

	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Agreement Surcharge Rate Inquiry</span></h2>
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
<div class="layer_popup_contents">	

	<!-- wrap_search_tab(S) -->
	<div class="wrap_search_tab">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">			
			<!--  MiniLayer (S) -->				
			<div class="layout_wrap" id="MiniLayer">
	     		<!-- layout_vertical_2(S) -->
	   			<div class="layout_flex_fixed" style="width:0px">
					<table>
						<colgroup>				            
							<col width="108px" />
							<col width="62px" />				
							<col width="170px" />
							<col width="25px" />
							<col width="25px" />
							<col width="" />
						</colgroup>
						<tbody>
							<tr>
								<th>Agreement No.</th>
								<td colspan="2">
									<input name="fm_agmtno" type="text" style="width:80px;" class="input" value="<%=agmt_no%>" readonly>
								</td>
								<th>Service Provider</th>
								<td colapan="2">
									<input name="fm_vndr_prmry_seq" type="text"  style="width:60px;" readonly><!--
									 --><input name="fm_vndr_prmry_nm" type="text" style="width:145px;" readonly>
								</td>
								<td></td>
							</tr>
							<tr>
								<th>Contract Office</th>
								<td>
									<input name="fm_ctrt_ofc_cd" type="text" style="width:80px;" readonly>
								</td>
								<td></td>
							</tr>
							<tr>
								<th>Reference No.</th>
								<td colspan="2">
									<input name="fm_agmt_ref_no" type="text" style="width:80px;" readonly>
								</td>
								<th>Remark</th>
								<td>
									<input name="fm_inter_rmk" type="text" style="width:209px;" readonly>
								</td>
								<td></td>								
							</tr>						
						</tbody>
					</table>				
					
					<!-- opus_design_grid(S)-->
					<div class="opus_design_grid">
						 <script language="javascript">ComSheetObject('sheet0');</script>
					</div>
					<!-- opus_design_grid(S)-->		
					
				</div>
				<div class="layout_flex_flex" style="padding-left:520px">
					<!-- opus_design_grid(S)-->
					<div class="opus_design_grid" style="width:360px;">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</div>
					<!-- opus_design_grid(S)-->		
				</div>
			</div>		
		</div>
	</div>

<!-- wrap_result(S) -->
	<div class="wrap_result"">	
		<!-- opus_design_tab(S) -->
	    <div class="opus_design_tab">     	 	
	        <script language="javascript">ComTabObject('tab1' )</script>    
	    </div>
	    <div class="opus_design_grid">
	    
			<!-- opus_design_grid(S) -->
            <div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
			    <div class="grid_option_left">
			    	<table>
			    		<tbody>
			    			<tr>
		                        <td width="20"><button type="button" class="btn_left cursor" name="reward1"></button></td>
		                        <th width="60">Page :</th>
		                        <td width="35"><input type="text"  class="input2" style="width:30px; valign:bottom; text-align:right;"  name="tot_page_cnt1" value="0"></td>
		                        <td width="45"><input type="text" style="width:30px; valign:bottom; text-align:right"  name="cur_page_cnt1" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
		                        <td><button type="button" class="btn_right cursor" name="forward1"></button></td>
	                        </tr>
	                    </tbody>
	               </table>                
		        </div>
		    	<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">				
					<button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button>
					<button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>	
				</div>
				<!-- opus_grid_btn(E) -->
            	<script language="javascript">ComSheetObject('sheet2');</script>
            </div>
            
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
			    <div class="grid_option_left">
			    	<table>
			    		<tbody>
			    			<tr>
		                        <td width="20"><button type="button" class="btn_left cursor" name="reward2"></button></td>
		                        <th width="60">Page :</th>
		                        <td width="35"><input type="text"  class="input2" style="width:30px; valign:bottom; text-align:right;"  name="tot_page_cnt2" value="0"></td>
		                        <td width="45"><input type="text" style="width:30px; valign:bottom; text-align:right"  name="cur_page_cnt2" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
		                        <td><button type="button" class="btn_right cursor" name="forward2"></button></td>
	                        </tr>
	                    </tbody>
	               </table>                
		        </div>
		    	<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">				
					<button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button>
					<button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>	
				</div>
				 <!-- opus_grid_btn(E) -->
            	<script language="javascript">ComSheetObject('sheet3');</script>
            </div>
            
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
			    <div class="grid_option_left">
			    	<table>
			    		<tbody>
			    			<tr>
		                        <td width="20"><button type="button" class="btn_left cursor" name="reward3"></button></td>
		                        <th width="60">Page :</th>
		                        <td width="35"><input type="text"  class="input2" style="width:30px; valign:bottom; text-align:right;"  name="tot_page_cnt3" value="0"></td>
		                        <td width="45"><input type="text" style="width:30px; valign:bottom; text-align:right"  name="cur_page_cnt3" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
		                        <td><button type="button" class="btn_right cursor" name="forward3"></button></td>
	                        </tr>
	                    </tbody>
	               </table>                
		        </div>
		    	<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">				
					<button type="button" class="btn_normal" name="btng_history" id="btng_history">Rate History</button>
					<button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>	
				</div>
				 <!-- opus_grid_btn(E) -->
            <script language="javascript">ComSheetObject('sheet4');</script>
			</div>
		</div>
	</div>
<!-- popup_contens_area(E) -->
</div>
</form>


