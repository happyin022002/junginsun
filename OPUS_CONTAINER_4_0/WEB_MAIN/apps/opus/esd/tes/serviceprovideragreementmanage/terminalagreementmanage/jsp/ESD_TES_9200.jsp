<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9200.jsp
*@FileTitle  : Vol. Accumulate Method
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9200Event"%>
<%
	EsdTes9200Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count
	
	String ofc_cd = "";

	try {
		
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    
    	ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():""; //test? ?..

		event = (EsdTes9200Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>



<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}  // end if
		// InitTab();
		loadPage();
	}
</script>


<!-- <input type="button" value="script reload" onClick="uiScriptReload()"> -->

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="is_valid_yd_cd" id="is_valid_yd_cd" />
<input type="hidden" name="yd_cd_hidden" id="yd_cd_hidden" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="yd_cd_name" id="yd_cd_name" />
<input type="hidden" name="row_num" id="row_num" />
<input type="hidden" name="ofc_cd" id="ofc_cd" value="<%=ofc_cd%>" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Volume Accumulate Method</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_new" 	id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!--
			--><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
			</div>
	<!-- page_title_area(E) -->
	</div>
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Contract Office</th>
						<td><input type="text" name="ctrt_ofc_cd" style="width:90px;" value="" id="ctrt_ofc_cd" /> </td>
					<tr>
						<th>S/P</th>
						<td><input type="text" name="vndr_lgl_eng_nm"  style="width:255px;" value="" id="vndr_lgl_eng_nm" /> </td>

					<tr>
						<th>Period</th>
						<td><input type="text" name="accm_fm_dt" id="accm_fm_dt" style="width:75px" value="" maxlength="10" onKeyUp='tes_isNumD(this,"Y");tes_moveFocus(this, this.form.accm_to_dt, 10);' onKeyDown='tes_chkInput(this);'><!-- 
							  --><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button><!-- 
							  -->~ <input type="text" name="accm_to_dt" maxlength="10" style="width:75px;" value="" onkeyup="tes_isNumD(this,'Y');" onkeydown="tes_chkInput(this);" id="accm_to_dt" /><!-- 
							  --><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>
						</td>
					<tr>
						<th>UOM</th>
						<td><input type="radio" name="tml_accm_ut_cd" id="tml_accm_ut_cd1" value="T" class="trans" checked><label for="tml_accm_ut_cd1">TEU</label><!-- 
							  --><input type="radio" name="tml_accm_ut_cd" id="tml_accm_ut_cd2" value="B" class="trans"><label for="tml_accm_ut_cd2">BOX</label></td>
					</tr>
				</tbody>
				</table>
				<table class="grid_2 wAuto">
					<colgroup>
						<col width="30" />
						<col width="60" />
						<col width="30" />
						<col width="60" />
						<col width="30" />
						<col width="60" />
						<col width="30" />
						<col width="62" />
					</colgroup>
					<tr>
						<th colspan="8"  style="text-align: center;"><b>Cost Code For Volume Accumulate</b></th>
					</tr>
	
					<tr>
						<td  align="center"><input type="checkbox" name="SVLDFL" value="SVLDFL" class="trans" id="SVLDFL" /> </td>
						<th>SVLDFL</th>
						<td  align="center"><input type="checkbox" name="SVLDMT" value="SVLDMT" class="trans" id="SVLDMT" /> </td>
						<th>SVLDMT</th>
						<td  align="center"><input type="checkbox" name="SVLDTS" value="SVLDTS" class="trans" id="SVLDTS" /> </td>
						<th>SVLDTS</th>
						<td  align="center"><input type="checkbox" name="TPNDFL" value="TPNDFL" class="trans" id="TPNDFL" /> </td>
						<th>TPNDFL</th>

					<tr>
						<td  align="center"><input type="checkbox" name="TPNDMT" value="TPNDMT" class="trans" id="TPNDMT" /> </td>
						<th>TPNDMT</th>
						<td  align="center"><input type="checkbox" name="TPNDTS" value="TPNDTS" class="trans" id="TPNDTS" /> </td>
						<th>TPNDTS</th>
						<td  align="center"><input type="checkbox" name="CGCUFL" value="CGCUFL" class="trans" id="CGCUFL" /> </td>
						<th>CGCUFL</th>
						<td  align="center"><input type="checkbox" name="CGCUMT" value="CGCUMT" class="trans" id="CGCUMT" /> </td>
						<th>CGCUMT</th>

					<tr>						
						<td  align="center"><input type="checkbox" name="TMNDFL" value="TMNDFL" class="trans" id="TMNDFL" /> </td>
						<th>TMNDFL</th>
						<td  align="center"><input type="checkbox" name="TMNDMT" value="TMNDMT" class="trans" id="TMNDMT" /> </td>
						<th>TMNDMT</th>
						<td  align="center"><input type="checkbox" name="TMNDTS" value="TMNDTS" class="trans" id="TMNDTS" /> </td>
						<th>TMNDTS</th>
						<td  align="center"><input type="checkbox" name="SVLDTM" value="SVLDTM" class="trans" id="SVLDTM" /> </td>
						<th>SVLDTM</th>
						
					<tr>						
						<td  align="center"><input type="checkbox" name="TPNDTM" value="TPNDTM" class="trans" id="TPNDTM" /> </td>
						<th>TPNDTM</th>
					</tr>

				</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<div id="hidden_sheets1" style="display:none">
				<!-- hidden Method info -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<div id="hidden_sheets1" style="display:none">
				<!-- hidden Costcode info -->
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
			<input type="hidden" name="vndr_seq" id="vndr_seq">
		</div>	
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_rowadd" 	id="btng_rowadd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button><!--
			--></div>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>