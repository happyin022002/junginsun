<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0234.jsp
*@FileTitle  : Agreement Rail Surcharge History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%> 
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException = null;	
	String	  strErrMsg	= "";			
	String	  userId    = "";
	String	  ofcCd		= "";
	try {		
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

	String agmtNo = JSPUtil.getNull(request.getParameter("agmt_no"));
	String vndrSeq = JSPUtil.getNull(request.getParameter("vndr_seq"));
	String trspRailScgCd = JSPUtil.getNull(request.getParameter("trsp_rail_scg_cd"));
	String agmtRoutAllFlg = JSPUtil.getNull(request.getParameter("agmt_rout_all_flg"));
	String fmNodCd = JSPUtil.getNull(request.getParameter("fm_nod_cd"));
	String toNodCd = JSPUtil.getNull(request.getParameter("to_nod_cd"));
	String cgoTpCd = JSPUtil.getNull(request.getParameter("cgo_tp_cd"));
	String cngEffFmDt = JSPUtil.getNull(request.getParameter("eff_fm_dt"));
	String cngEffToDt = JSPUtil.getNull(request.getParameter("eff_to_dt"));

	String cngFmLocCd = "";
	String cngFmYardCd = "";
	String cngToLocCd = "";
	String cngToYardCd = "";	

	if( fmNodCd.length() == 0 ){
		cngFmLocCd = "";
		cngFmYardCd = "";		
	}else if( fmNodCd.length() < 6 ){
		cngFmLocCd = fmNodCd;
		cngFmYardCd = "";	
	}else{
		cngFmLocCd = fmNodCd.substring(0, 5);
		cngFmYardCd = fmNodCd.substring(5);	
	}

	if( toNodCd.length() == 0 ){
		cngToLocCd = "";
		cngToYardCd = "";			
	}else if( toNodCd.length() < 6 ){
		cngToLocCd = toNodCd;
		cngToYardCd = "";	
	}else{
		cngToLocCd = toNodCd.substring(0, 5);
		cngToYardCd = toNodCd.substring(5);	
	}

	String cngTrspRailScgCd = "";
	if( trspRailScgCd.equals("") ){
		cngTrspRailScgCd = "";
	}else if( trspRailScgCd.equals("FSG") ){
		cngTrspRailScgCd = "FSG";		
	}else{
		cngTrspRailScgCd = "NFSG";		
	}
%>

<script type="text/javascript">
  function setupPage(){
	var formObject = document.form;
	formObject.routeAll.value = "<%=agmtRoutAllFlg%>";
    formObject.fm_fm_nod_cd.value = "<%=cngFmLocCd%>"; 
    formObject.fm_to_nod_cd.value = "<%=cngToLocCd%>";
    formObject.sel_scg.value = "<%=cngTrspRailScgCd%>";
    formObject.fm_eff_fm_dt1.value = "<%=cngEffFmDt%>";
    formObject.fm_eff_to_dt1.value = "<%=cngEffToDt%>";
    
    if( formObject.routeAll.value == "0" ){
    	formObject.routeAll.checked = false;
    	formObject.routeAll.value = "";
    }else if( formObject.routeAll.value == "1" ){
    	formObject.routeAll.checked = true;
    	formObject.routeAll.value = "Y";
    }
	  
    loadPage();

    formObject.fm_fm_nod_yd.CODE = "<%=cngFmYardCd%>";
    formObject.fm_to_nod_yd.CODE = "<%=cngToYardCd%>";

    getHypen(formObject.fm_eff_fm_dt1);
    getHypen(formObject.fm_eff_to_dt1);
  }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd" value="<%=ofcCd%>" id="fm_account_ofc_cd" />
<input type="hidden" name="fm_account_usr_id" value="<%=userId%>" id="fm_account_usr_id" />
<input type="hidden" name="hid_fm_eff_fm_dt1" value="" id="hid_fm_eff_fm_dt1" />
<input type="hidden" name="hid_fm_eff_to_dt1" value="" id="hid_fm_eff_to_dt1" />
<input type="hidden" name="agmtNo" value="<%=agmtNo%>" id="agmtNo" />
<input type="hidden" name="vndrSeq" value="<%=vndrSeq%>" id="vndrSeq" />
<input type="hidden" name="trspRailScgCd" value="<%=trspRailScgCd%>" id="trspRailScgCd" />
<input type="hidden" name="agmtRoutAllFlg" value="<%=agmtRoutAllFlg%>" id="agmtRoutAllFlg" />
<input type="hidden" name="fmNodCd" value="<%=fmNodCd%>" id="fmNodCd" />
<input type="hidden" name="toNodCd" value="<%=toNodCd%>" id="toNodCd" />
<input type="hidden" name="cgoTpCd" value="<%=cgoTpCd%>" id="cgoTpCd" />


<input type="hidden" name="f_cmd" id="f_cmd" />


	<!-- page_title_area(S) -->
	<div class="layer_popup_title">
		<div class="page_title_area clear">
		
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Agreement Rail Surcharge History</span></h2>
			<!-- page_title(E) -->
			
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btng_close" 			id="btng_close">Close</button>		
			</div>
			<!-- opus_design_btn(E) -->	
			
		</div>
	</div>
	<!-- page_title_area(E) -->
	
	
	<div class="layer_popup_contents">
		<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="100">
						<col width="110">
						<col width="170">
						<col width="60">
						<col width="170">
						<col width="*">				
					</colgroup>
					<tbody>
						<tr>
		                  	<th><label for="routeAll">Route ALL</label><input type="checkbox" name="routeAll" value="" class="trans" onclick="javascript:fun_allRoute();" id="routeAll" /></th>
		                   	<th>ORG</th>
			                <td><input name="fm_fm_nod_cd" type="text" style="width:60px;" maxlength="5" onchange="getComboList(this, fm_fm_nod_yd, 'F');" onblur="setgetUpper(this);" id="fm_fm_nod_cd" /><!-- 
				                --><script type="text/javascript">ComComboObject('fm_fm_nod_yd', 1, 45, 0)</script><!-- 
			                    --><button type="button" id="btn_frmnode" name="btn_frmnode" class="input_seach_btn"></button></td>
			                <th>DEST</th>
			                <td><input name="fm_to_nod_cd" type="text" style="width:60px;" maxlength="5" onchange="getComboList(this, fm_to_nod_yd, 'T');" onblur="setgetUpper(this);" id="fm_to_nod_cd" /><!-- 
			                	--><script type="text/javascript">ComComboObject('fm_to_nod_yd', 1, 48, 0);</script><!-- 
			                    --><button type="button" id="btn_tonode" name="btn_tonode" class="input_seach_btn"></button></td>
			                <td></td>
	                    </tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="80">
						<col width="100">
						<col width="60">
						<col width="180">
						<col width="*">				
					</colgroup>
					<tbody>
						<tr>
		                	<th>SCG Kind</th>
		                	<td><select name="sel_scg" style="width:60px;">
								<option value="" selected></option>
								<option value="FSG">Fuel</option>
								<option value="NFSG">Other</option>
							</select></td>
		                	<th>Effective Date</th>
		                  	<td><input name="fm_eff_fm_dt1" type="text" style="width:80px;" class="input" value="" dataformat="ymd" id="fm_eff_fm_dt1" />~&nbsp;<!-- 
		                  		 --><input name="fm_eff_to_dt1" type="text" style="width:80px;" class="input" value="" dataformat="ymd" id="fm_eff_to_dt1" /></td>
		                  	<td></td>
		                </tr>
					</tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
	
		<div class="wrap_result">
			
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
			
		</div>
	</div>
</form>