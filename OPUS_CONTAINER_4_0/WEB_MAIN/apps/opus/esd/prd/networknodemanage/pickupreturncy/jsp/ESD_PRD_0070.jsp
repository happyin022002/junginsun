<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0070.jsp
*@FileTitle  : Pick Up CY for Export Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.event.EsdPrd0070Event"%>

<%
    EsdPrd0070Event  event = null;
    Exception serverException   = null; 
    DBRowSet rowSet      = null;
    String strErrMsg = "";
    int rowCount     = 0;
    try {
        event = (EsdPrd0070Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    function setupPage(){
	    loadPage();
    }
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage">
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
		 --><button type="button" class="btn_normal" name="btn_loadexcel"   id="btn_loadexcel">Load Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>		
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
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="130">
					<col width="60">
					<col width="120">
					<col width="35">
					<col width="110">
					<col width="45">
					<col width="80">
					<col width="60">
					<col width="*">
			    </colgroup>
				<tr>
					 <th>Status</th>
                     <td><select name="delt_flg" id="delt_flg" style="width: 100px">
                            <option value="A" selected>All</option>
                            <option value="N">Live</option>
                            <option value="Y">Deleted</option>
                        </select></td>
						<th title="POR/DEL">POR/DEL</th>
						<td><input type="" name="por_del_cd" id="por_del_cd" value="" style="width: 100px;text-align:center" maxlength="5" dataformat="engup" style="text-align:center"><button type="button" class="input_seach_btn" name="btn_PorDel"  id="btn_PorDel"></button></td>
						<th title="POL/POD (Port)">POL/POD (Port)</th>
						<td><input type="" name="pol_pod_cd" id="pol_pod_cd" value="" style="width: 100px;text-align:center" maxlength="5"  dataformat="engup" style="text-align:center"><button type="button" class="input_seach_btn" name="btn_PolPod"  id="btn_PolPod"></button></td>
						<th title="Lane">Lane</th>
						<td><input type="" name="vsl_slan_cd" id="vsl_slan_cd" value="" style="width: 60px;text-align:center" maxlength="3"  dataformat="engup" style="text-align:center"><button type="button" class="input_seach_btn" name="btn_Lane"  id="btn_Lane"></button></td>
						<th title="Bound">Bound</th>
						<td><select name="io_bnd_cd" id="io_bnd_cd" style="width: 80px">
							<option value="AL">All</option>
							<option value="O">Out</option>
							<option value="I">In</option>
						</select></td>
						<th title="Cargo Type">Cargo Type</th>
						<td><select name="spcl_cgo_cd" id="spcl_cgo_cd">
							<option value="AL">All</option>
							<option value="DR">Dry</option>
							<option value="RF">Reefer</option>
							<option value="DG">DG</option>
						</select></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>

