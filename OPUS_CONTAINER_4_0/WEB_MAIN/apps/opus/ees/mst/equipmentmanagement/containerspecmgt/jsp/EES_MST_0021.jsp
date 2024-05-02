<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0021.jsp
*@FileTitle  : Container Specification Creation &amp; Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesMst0021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String popflag = StringUtil.xssFilter(request.getParameter("popflag"));
	if(popflag == null){
		popflag = "";
	}
	String cntr_spec_no = StringUtil.xssFilter(request.getParameter("cntr_spec_no"));
	if(cntr_spec_no == null){
		cntr_spec_no = "";
	}
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesMst0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form  name="form" id="form" >
<input type="hidden" name="cntr_tpsz_cd"     id="cntr_tpsz_cd" />
<input type="hidden" name="f_cmd"            id="f_cmd" />
<input type="hidden" name="pagerows"         id="pagerows" />
<input type="hidden" name="popflag"          id="popflag"  value="<%=popflag%>" />
<input type="hidden" name="code"             id="code" />
<input type="hidden" name="vndr_seq2"        id="vndr_seq2" />
<input type="hidden" name="spec_yr_mod"      id="spec_yr_mod" />
<input type="hidden" name="his_cntr_spec_no" id="his_cntr_spec_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<% if( popflag == "") { %>
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<%} else { %>
		<h2 class="page_title"><span>Container Specification</span></h2>
	<%} %>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<%
			if(popflag != "") {				// in case of called pop-up
		%>
		<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
		<%
		}
		else				// in case of called main
		{
		%>
		<button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
		<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
		<%} %> 
	</div>
	<!-- opus_design_btn(E) -->
	<% if( popflag == "") {%>
		<div class="location">
			<span id="navigation"></span>
			</div>
	<%} %> 

</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="50px" />
				<col width="180px" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Spec No.</th>
				<td><input type="text" name="cntr_spec_no" id="cntr_spec_no" style="width: 110px" class="input2" value="<%=cntr_spec_no%>" readonly style="text-align:center"><%if(popflag == "") {%><button type="button" class="input_seach_btn" name="btn_Popup" id="btn_Popup"></button><%} %></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
	<table class="wFit">
		<tbody>
			<colgroup>
                <col width="40" />
                <col width="20" />
                <col width="30" />
                <col width="20" />
                <col width="50" />
                <col width="70" />
                <col width="70" />
                <col width="30" />
                <col width="300" />
			</colgroup>
			<tr>
				<th>Spec Classification</th>
				<td></td>
				<td><select class="input1" style="width: 100px;"  name="own_cntr_flg" id="own_cntr_flg" style="text-align:center"><option value="O" >Own</option><option value="L">Lease</option><option value="S">Standard</option></select></td>
				<td></td>
				<th>Year</th>
				<td><input type="text" name="spec_yr" id="spec_yr" style="width: 70px" dataformat="yyyy" maxlength=4 class="input1" style="text-align:center" onmouseout="obj_focusout()"></td>
				<th>TP/SZ</th>
				<td><script type="text/javascript">ComComboObject('combo1', 1, 45, 1, 1);</script></td>
				<th align="left">
	                <div align="center" id="div_dcond0">
	                    Material <script type="text/javascript">ComComboObject('cntr_mtrl_cd',2,120,0,1,1);</script>
	                </div>				
				</th>
				<th align="left">	
                    <div align="center" id="div_dcond1">
                        M/facturer <script type="text/javascript">ComComboObject('mft_vndr_seq',2,200,0,1,1);</script>
                    </div>				
					<div align="left" id="div_dcond2" style="display: none;">
						Lessor <!-- 
						 --><input type="text" name="vndr_seq" id="vndr_seq" dataformat="num" maxlength="6" style="width: 70px; text-align: center; ime-mode: disabled" class="input1" value=""><!-- 
						 --><button type="button" class="input_seach_btn" name="btns_vndr" id="btn_popup2"></button><!--  
						 --><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" readonly style="width:200px; ime-mode: disabled" class="input2" value="">
					</div>
				</th>
			</tr>
		</tbody>
	</table>

    <table> 
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>	
	<!-- layout_wrap (S) -->
	<div class="layout_wrap wFit">
	    <div class="layout_vertical_2" style="width: 48%">
	    	<h3 class="title_design">Capacity</h3>
			<table class="grid_2 "> 
				<tr>
					<th width="110">Capacity</th> 
					<td width="115"><input type="text" name="lod_capa" id="lod_capa"  dataformat="float"  maxlength="8"  size="7"   pointcount="1"  style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"><strong>CBM</strong></td>
					<td width="105"><input type="text" name="lod_capa_cbf" id="lod_capa_cbf" style="width:77px;text-align:right" class="input2" readonly><strong>CBF</strong></td>
				</tr>
				<tr>
					<th width="%">Gross Weight</th> 
					<td width="%"><input type="text" name="cntr_grs_wgt" id="cntr_grs_wgt"  dataformat="float" pointcount="3" style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"><strong>KG</strong></td>
					<td width="%"><input type="text" name="cntr_grs_wgt_ibs" id="cntr_grs_wgt_ibs" style="width:77px;text-align:right" class="input2" readonly><strong>LBS</strong></td>
				</tr>
				<tr >
					<th width="%" >Tare Weight</th> 
					<td width="%"><input type="text" name="tare_wgt" id="tare_wgt"  dataformat="float" pointcount="3" style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"><strong>KG</strong></td>
					<td width="%"><input type="text" name="tare_wgt_ibs" id="tare_wgt_ibs" style="width:77px;text-align:right" class="input2" readonly><strong>LBS</strong></td>
				</tr>
				<tr >
					<th width="%" >Pay Load</th> 
					<td width="%"><input type="text" name="pay_load" style="width:77px;text-align:right" dataformat="float" pointcount="3" class="input2" readonly><strong>KG</strong></td>
					<td width="%"><input type="text" name="pay_load_ibs" style="width:77px;text-align:right" class="input2" readonly><strong>LBS</strong></td>
				</tr>
			</table> 
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 2%">
	        <table> 
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>	
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 45%">
	        <h3 class="title_design">Dimension</h3>
	        <table class="grid_2 "> 
				<tr style="height:26px">
					<th width="" >Unit (mm)</th> 
					<th width="">Length</th>
					<th width="" >Width</th>
					<th width="">Height</th>
				</tr>
				<tr class="">
					<th width="" class="tr2_head2" style="text-align:center;">Internal</th> 
					<td width="" align="right"><input type="text" name="inter_len" id="inter_len"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=5 style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"></td>
					<td width="" align="right"><input type="text" name="inter_wdt" id="inter_wdt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"></td>
					<td width="" align="right"><input type="text" name="inter_hgt" id="inter_hgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"></td>
				</tr>
				<tr class="">
					<th width="" class="tr2_head2" style="text-align:center;">External</th> 
					<td width="" align="right"><input type="text" name="xter_len" id="xter_len"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=5 style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"></td>
					<td width="" align="right"><input type="text" name="xter_wdt" id="xter_wdt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"></td>
					<td width="" align="right"><input type="text" name="xter_hgt" id="xter_hgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"></td>
				</tr>
				<tr class="">
					<th width="" class="tr2_head2" style="text-align:center;">Open Door</th> 
					<td width="" class=""></td>
					<td width="" align="right"><input type="text" name="opn_dor_wdt" id="opn_dor_wdt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"></td>
					<td width="" align="right"><input type="text" name="opn_dor_hgt" id="opn_dor_hgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77px;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"></td>
				</tr>
			</table> 
	    </div>
	</div>
	<!-- layout_wrap (E) -->
	
	<table> 
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	
	<!-- layout_wrap (S) -->
	<div class="layout_wrap wFit">
	    <div class="layout_vertical_2" style="width: 45%">
	    	<h3 class="title_design">Reefer Cargo Loadable</h3>
			<table class="search">
				<colgroup>
					<col width="30px" />
					<col width="20px" />
					<col width="100px" />
					<col width="35px" />
					<col width="100px" />
					<col width="*" />
				</colgroup> 
				<tr class="h23">
					<th width="102">Capacity</th> 
					<td></td>
					<td width="85"><input type="text" name="rc_ldb_capa" id="rc_ldb_capa"  <%if(popflag=="") {%> dataformat="float" <%} %> maxlength="8"  size="7"   pointcount="1" style="width: 77px; text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"> CBM</td>
					<td></td>
					<td width="85"><input type="text" name="rc_ldb_capa_cbf" id="rc_ldb_capa_cbf"  style="width:77;text-align:right" class="input2" readonly> CBF</td>
					<td></td>
				</tr>
				<tr class="h23">
					<th width="%">Height</th> 
					<td></td>
					<td width="%"><input type="text" name="rc_ldb_hgt"  id="rc_ldb_hgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=5 style="width: 77px; text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"> mm</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table> 
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 5%">
	        <table> 
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>	
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 45%">
	        <h3 class="title_design">Tank Capacity</h3>
	        <table class="search"> 
	        	<colgroup>
					<col width="50px" />
					<col width="35px" />
					<col width="100px" />
					<col width="35px" />
					<col width="100px" />
					<col width="*" />
				</colgroup>
				<tr class="h23">
					<th width="60">Capacity</th> 
					<td></td>
					<td width="85"><input type="text" name="tnk_capa" id="tnk_capa"  <%if(popflag=="") {%> dataformat="float" <%} %> maxlength="8"  size="7"   pointcount="1" style="width: 77px; text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> onmouseout="obj_focusout()"> CBM</td>
					<td></td>
					<td width="85"><input type="text" name="tnk_capa_cbf" id="tnk_capa_cbf" style="width: 77px; text-align:right" class="input2" readonly> CBF</td>
					<td></td>
				</tr>
				<tr class="h23">
					<th width="60">&nbsp;</th> 
					<td></td>
					<td width="85">&nbsp;</td>
					<td></td>
					<td width="85">&nbsp;</td>
					<td></td>
				</tr>
			</table> 
	    </div>
	    </div>
	    
	    <table> 
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	
	    <div class="layout_wrap wFit">
	    <div class="layout_vertical_2" style="width: 45%">
	    	<h3 class="title_design">Flat Rack Specification</h3>
			<table class="search">
				<colgroup>
					<col width="30px" />
					<col width="20px" />
					<col width="100px" />
					<col width="*" />
				</colgroup> 
				<tr class="h23">
					<th width="102">Collapsible</th> 
					<td></td>
					<td width="85"><input type="text" name="frack_clps_ctnt" id="frack_clps_ctnt" maxlength=100 style="width: 380px;" class="input" <%if(popflag!="") out.print("readonly"); %>> </td>
					<td></td>
				</tr>
				<tr class="h23">
					<th width="%">Bed Thick</th> 
					<td></td>
					<td width="%"><input type="text" name="frack_bed_tik_ctnt"  id="frack_bed_tik_ctnt" maxlength=100 style="width: 380px;" class="input" <%if(popflag!="") out.print("readonly"); %>></td>
					<td></td>
				</tr>
			</table> 
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 5%">
	        <table> 
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>	
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 45%">
	    	<h3 class="title_design">Open Top Specification</h3>
			<table class="search">
				<colgroup>
					<col width="30px" />
					<col width="20px" />
					<col width="100px" />
					<col width="*" />
				</colgroup> 
				<tr class="h23">
					<th width="102">Roof Opening</th> 
					<td></td>
					<td width="85"><input type="text" name="opntp_roof_opn_ctnt" id="opntp_roof_opn_ctnt" maxlength=100 style="width: 390px;" class="input" <%if(popflag!="") out.print("readonly"); %>> </td>
					<td></td>
				</tr>
				<tr class="h23">
					<th width="%">Interior Height</th> 
					<td></td>
					<td width="%"><input type="text" name="opntp_intr_hgt_ctnt"  id="opntp_intr_hgt_ctnt" maxlength=100 style="width: 390px;" class="input" <%if(popflag!="") out.print("readonly"); %>></td>
					<td></td>
				</tr>
				<tr class="h23">
					<th width="%">Rear Head Opening</th> 
					<td></td>
					<td width="%"><input type="text" name="opntp_rear_hdr_opn_ctnt"  id="opntp_rear_hdr_opn_ctnt" maxlength=100 style="width: 390px;" class="input"<%if(popflag!="") out.print("readonly"); %>> </td>
					<td></td>
				</tr>
			</table> 
	    </div>
	</div>
	<!-- layout_wrap (E) -->
</div>
</div> 
<!-- opus_design_inquiry(E) -->

<div class="wrap_result wFit">	
	<div id="hiddenLayer" style="display:none" class="opus_grid_design">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>  
	</div>		
</div>		
<!--    -->
</form>
</html>