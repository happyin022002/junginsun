<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName    ESD_TRS_0231.jsp
*@FileTitle  : Agreement Inquiry by Route 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%

  Exception         serverException   = null;     //Server Exception
  String            strErrMsg     = "";                //Error Message

  String  userId  = "";
  String  ofcCd   = "";

  String optionStr2   = "000020::";
  
  //2015.03.13		Chanwoo Park Start
  String selCOSTMODE  = ""; // Cost Mode Combo
  // 2015.03.13		Chanwoo Park End
  String selCARGOMODE = ""; //Cargo Type Combo
  String selTRANSMODE = "";	//Trans Mode Combo
  
  // 2015.03.13		Chanwoo Park Start
  selCOSTMODE	= JSPUtil.getCodeCombo("costmode", "01", "style=width:60", "CD02177", 0, optionStr2);
  // 2015.03.13		Chanwoo Park End
  selCARGOMODE  = JSPUtil.getCodeCombo("cargo",     "01"  ,"style='width:80;'", "CD00748", 0, optionStr2);
  selTRANSMODE	= JSPUtil.getCodeCombo("fm_agmt_trsp_tp_cd", "01"	,"style=width:60", "CD00283", 0, optionStr2);

  try {
    SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
      userId            = account.getUsr_id();
      ofcCd           = account.getOfc_cd();

    serverException       = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
  }catch(Exception e) {
    out.println(e.toString());
  }
%>

<script type="text/javascript">
  function setupPage(){
    <%= JSPUtil.getIBCodeCombo("rail_svc_tp_cd",	"", "CD00916", 0, "")%>
    loadPage();
  }
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">

<input type="hidden" name="fm_rail_svc_tp_cd">
<input type="hidden" name="fm_agmt_trsp_tp_cd_sheet">
<input type="hidden" name="fm_trsp_agmt_ofc_cty_cd">
<input type="hidden" name="fm_trsp_agmt_seq">
<input type="hidden" name="fm_trsp_agmt_rt_tp_ser_no">
<input type="hidden" name="fm_vndr_seq">
<input type="hidden" name="fm_ctrt_ofc_cd">
<input type="hidden" name="fm_eq_knd_cd">
<input type="hidden" name="fm_trsp_agmt_eq_tp_sz_cd">
<input type="hidden" name="fm_cgo_tp_cd">
<input type="hidden" name="fm_trsp_cost_mod_cd">
<input type="hidden" name="fm_trsp_bnd_cd">
<input type="hidden" name="fm_fm_nod_cd">
<input type="hidden" name="fm_via_nod_cd">
<input type="hidden" name="fm_dor_nod_cd">
<input type="hidden" name="fm_to_nod_cd">
<input type="hidden" name="fm_trsp_agmt_bdl_qty">
<input type="hidden" name="fm_wgt_meas_ut_cd">
<input type="hidden" name="fm_basic_rt">
<input type="hidden" name="fm_curr_cd">
<input type="hidden" name="fm_way">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 			
			 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>			
		</div>
		<!-- opus_design_btn(E) -->
	
	   	<!-- page_location(S) -->
	   	<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit" id="MiniLayer">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>				            
				<col width="80"/>
				<col width="200"/>
				<col width="90"/>
				<col width="200" />
				<col width="100" />								            
				<col width="200" />				
				<col width="45" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>From</th>
				<td><input type="text" name = "search_fm_loc" id = "search_fm_loc" style="width:60px;" class="input1" onFocus='fun_Focus(this)' onChange="getComboList(this, search_fm_yard, 'F');" onBlur="" maxlength="5" dataformat="engup"><script type="text/javascript">ComComboObject('search_fm_yard', 1, 100, 0)</script><button class="input_seach_btn" name="btns_frmnode" id="btns_frmnode" type="button"></button></td>
				<th>Via</th>
				<td><input type="text" name = "search_via_loc"  id= "search_via_loc" style="width:60px;" class="input1" onFocus='fun_Focus(this)' onChange="getComboList(this, search_via_yard, 'V');" onBlur="" maxlength="5" dataformat="engup"><script type="text/javascript">ComComboObject('search_via_yard', 1, 100, 0)</script><button class="input_seach_btn" name="btns_vianode" id="btns_vianode" type="button"></button></td>
				<th>Door</th>
				<td><input type="text" name = "search_door_loc" id="search_door_loc" style="width:120px;" class="input1" onFocus='fun_Focus(this)' onChange="getComboList(this, search_door_yard, 'D');"  onBlur="" maxlength="5" dataformat="engup"><script type="text/javascript">ComComboObject('search_door_yard', 1, 100, 0)</script><button class="input_seach_btn" name="btns_dornode" id="btns_dornode" type="button"></button></td>
				<th>To</th>
				<td><input type="text" name = "search_to_loc" id="search_to_loc" style="width:60px;" class="input1" onFocus='fun_Focus(this)' onChange="getComboList(this, search_to_yard, 'T');"  onBlur="" maxlength="5" dataformat="engup"><script type="text/javascript">ComComboObject('search_to_yard', 1, 100, 0)</script><button class="input_seach_btn" name="btns_tonode" id="btns_tonode" type="button"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>				            
				<col width="80"/>
				<col width="200"/>
				<col width="90"/>
				<col width="200" />
				<col width="100" />
				<col width="*" />
			</colgroup>
		 	<tr>
				<th>Cost Mode</th>
				<td><%=selCOSTMODE%></td>
				<!-- <td><select name="costmode" id="costmode" style="width:60px;">
					<option value = ""> </option>
					<option value = "CY">CY</option>
					<option value = "DC">DC</option>
					<option value = "DR">DR</option>
					<option value = "BS">BS</option>
					<option value = "BF">BF</option>
					<option value = "MF">MF</option>
					<option value = "MM">MM</option></select></td> -->
					
				<th>Cargo Type</th>
				<td><%=selCARGOMODE%></td>
				<th>EQ Type/Size</th>
				<td><select name="eqtype" id="eqtype" style="width:120px;" class='input1'><!--
	                    --><option value="U" selected>Container</option><!--
	                    --><option value="Z" >Chassis</option><!--
	                    --><option value="G" >Genset</option><!--
	                --></select><input type="text" style="width:100px;" name='eqtpsz' id='eqtpsz' onChange='upperCase(this)' dataformat="engup" otherchar=","><button class="multiple_inq ir" name="btn_eqtpsz" id="btn_eqtpsz" type="button"></button>
				</td>
			</tr>
		</table>
		<table>
			<colgroup>				            
				<col width="80"/>
				<col width="198"/>
				<col width="90"/>
				<col width="198" />
				<col width="101" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>Trans Mode</th>
				<td><%=selTRANSMODE%></td>
				<th>Effective AGMT</th>
				<td><select style="width:120px;" class="input" name="fm_effective_agmt" id="fm_effective_agmt" ><option value="C">Current</option><option value="A" selected>ALL</option></select></td>
				<th>Service Provider</th>
				<td><input name="fm_vndr_prmry_seq" id="fm_vndr_prmry_seq" type="text" style="width:120px;" class="input" value="" onBlur="vender_blur();" dataformat="engup"><input name="fm_vndr_prmry_nm" id="fm_vndr_prmry_nm" type="text" style="width:100px;" class="input" value="" readonly dataformat="engup"><button class="input_seach_btn" name="btn_serviceprovider" id="btn_serviceprovider" type="button"></button></td>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<div class="grid_option_left">
			<div class="opus_design_inquiry" >
				<table >
					<colgroup>				            
						<col width="1" />
						<col width="90" />
						<col width="30" />
						<col width="45" />
						<col width="32" />
						<col width="38" />
						<col width="30" />
						<col width="" />
					</colgroup>
					<tbody>
						<tr>
							<th>From</th>
							<td><select style="width:100px;" class="input" name="page_size" id="page_size" onChange="javascript:reset_all();">
				                 <option value="500">500</option>
				                 <option value="1000">1000</option> 
				                 <option value="3000" selected>3000</option> 
				                 <option value="5000">5000</option>
				                </select></td>
							<td><button type="button" class="btn_left"  name="reward"  id="reward"></button></td>
							<th>Page :</th>
							<td><input type="text"  class="input2" style="width:30px; valign:bottom; text-align:right;"  name="tot_page_cnt" id="tot_page_cnt" value="0"></td>
							<td><input type="text" style="width:30px; valign:bottom; text-align:right"  name="cur_page_cnt" id="cur_page_cnt" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
							<td><button type="button" class="btn_right" name="forward" id="forward"></button></td>
							<td></td>
						</tr>
					</tbody>
				</table>	
        	</div>	
        </div>
        <!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>
		</div>
		<!-- opus_grid_btn(E) -->	
        
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet_main');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
	</div>
	<!-- opus_design_grid(E) -->
</div>
<div class="header_fixed"></div>
</form>

