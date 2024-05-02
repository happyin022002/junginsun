<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0220.jsp
*@FileTitle  : Agreement Header
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
	Exception serverException = null;	//Error occurred on the server
	String	  strErrMsg	= "";			//Error message
	String	  userId    = "";
	String	  ofcCd		= "";
	String    agmt_no   = "";	
	try {
		agmt_no = ((request.getParameter("agmt_no")==null )?"":request.getParameter("agmt_no"));	
		
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
  function setupPage(){
    loadPage();
  }
</script>

<form method="post" name="form" onSubmit="return false;" >
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="fm_trsp_agmt_ofc_cty_cd"	  value="">
<input type="hidden" name="f_cmd" >

<input type="hidden" name="hid_row" >
<input type="hidden" name="hid_col" >

	<!-- popup_title_area(S) -->
<div class="layer_popup_title">	
		<!-- page_title_area(S) -->
		 <div class="page_title_area clear">
			<!-- page_title(S) -->
			  <h2 class="page_title"><span>Agreement Header</span></h2>
			<!-- page_title(E) -->
					
			 <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btng_retrieve"   id="btng_retrieve">Retrieve</button><!--
		       	--><button type="button" class="btn_normal" name="btng_create"   id="btng_create">Create</button><!--
		       	--><button type="button" class="btn_normal" name="btng_update"   id="btng_update">Update</button><!--
		       	--><button type="button" class="btn_normal" name="btng_ok"   id="btng_ok">OK</button><!--
		       	--><button type="button" class="btn_normal" name="btng_close"   id="btng_close">Close</button><!--
		       	--><button type="button" class="btn_normal" name="btng_new"   id="btng_new">New</button>
		    </div>
		    <!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
		</div>
	<!-- popup_title_area(E) -->
<div class="layer_popup_contents"> 
		<!-- wrap_search (S) -->
		<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit" >
				<!--  MiniLayer (S) -->
				<table >
					<colgroup>				            
						<col width="100px" />
						<col width="130px" />				
						<col width="" />
					</colgroup>
					<tbody>
						<tr>
							<th>Agreement No.</th>
							<td>
								<input name="fm_agmtno" id="fm_agmtno" type="text" style="width:80px;" class="input" value="<%=StringUtil.xssFilter(agmt_no)%>" onKeyup="javascript:doSearchEnter();"  dataformat="engup">
							</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- wrap_search (E) -->
		<!-- wrap_result(S) -->
		<div class="wrap_result">
			<div class="opus_design_inquiry">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">
				<div class="layout_vertical_2" style="width:500px;">
					<h3 class="title_design">Header Information</h3>
					<!-- opus_design_inquiry(S) -->
						<!--  MiniLayer (S) -->
						<table style=" margin-top:34px">
							<colgroup>				            
								<col width="100px" />
								<col width="110px" />
								<col width="120px" />
								<col width="" />
							</colgroup>
							<tbody>
								<tr>
									<th>Service Provider</th>
									<td colspan="3">
										<input name="fm_vndr_prmry_seq" type="text"  style="width:50px;" value=""  maxlength="6" onBlur="vender_blur();"><!--
										--><input name="fm_vndr_prmry_nm" type="text" style="width:95px;" value="" class="input2"  title="This inputbox cant't write" readOnly><!--
										--><button type="button" class="input_seach_btn" id='btn_provider' name='btn_provider'></button>								
									</td>
								</tr>
								<tr>
									<th>Reference No.</th>
									<td><input name="fm_agmt_ref_no" class="input1" type="text" style="width:150px;" value=""  maxlength="15"></td>
									<th>Contract Office</th>
									<td><input name="fm_ctrt_ofc_cd" dataformat="enguponly" class="input1" type="text" style="width:110px;" value="" maxlength="6" onBlur="office_blur();"></td>
								</tr>
								<tr>
									<th>Remarks</th>
									<td colspan="3">
										<input name="fm_inter_rmk" type="text" style="width:387px;" value="" maxlength="1000">
									</td>
								</tr>
							</tbody>
						</table>
					
				</div>
			
				<div class="layout_vertical_2" style="width:300px">
					<!-- opus_design_grid(S) -->
					<div class="opus_design_grid" id="mainTable">
						<!-- opus_grid_btn(S) -->
						<div class="opus_design_btn">
							<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button><!--
							--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
						</div>
						<script type="text/javascript">ComSheetObject('sheet0');</script>				
					</div>
				</div>						
			</div>
			<!-- layout_wrap(E) -->
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	</div>
</div>		
</form>