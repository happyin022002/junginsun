<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0024.jsp
*@FileTitle  : Constraint Management  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
--%>
<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.event.EsdPrd0024Event"%>

<%
	EsdPrd0024Event  event = null;	
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	String nodeCd = JSPUtil.getNull(request.getParameter("node_cd"));
	String mode = JSPUtil.getNull(request.getParameter("mode"));
	
	String link_flg=StringUtil.xssFilter(request.getParameter("link_flg"));
	String fromNd = StringUtil.xssFilter(request.getParameter("fromNd"));
	String toNd = StringUtil.xssFilter(request.getParameter("toNd"));
	String hub_flg = StringUtil.xssFilter(request.getParameter("hub_flg"));
	try {
		event = (EsdPrd0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cnst_cd", "01", "CD01386", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("dir_cd", "01", "CD00593", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("point_cd", "01", "CD02351", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("spcl_cgo_cntr_tp_cd",     "", "CD01507", 0, "")%>

	function setupPage(){
		link_flag = "<%= link_flg%>";
		hub_flg = "<%= hub_flg%>";
		var errMessage = "<%=strErrMsg%>";
		
		nodeCd = "<%=nodeCd%>";
		mode = "<%=mode%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
<form method="post" name="form" id="form" >
<input	type="hidden" name="f_cmd" id="f_cmd">
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
		 --><button type="button" class="btn_normal" name="btn_loadexcel" 	id="btn_loadexcel">Load Excel</button><!-- 
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
					<col width="27"/>
					<col width="40"/>
					<col width="120"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td>
						<%
							if(mode.equals("pop")){
							%><input type="radio" name ="radioGubun" class="trans"  value="" onClick="changeSelection(0);" checked>
							<%
							}else{
							%>
							<input type="radio" name ="radioGubun" class="trans"  value="" onClick="changeSelection(0);" >
						<%} %>
					</td>
					<td><b>Location/Node</b></td>
					<td><input name="loc" type="text" maxlength="7" style="width:70px;text-align:center"   value="<%=nodeCd%>" dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_node_cd" id="btn_node_cd"></button></td>
					<td width="" colspan="13">
					<label for="point_code_ALL"><b>ALL</b></label><!--
					--><input type="radio" class="trans" name="point_code" value="ALL" checked/>&nbsp;&nbsp;&nbsp;&nbsp;<!--
					--><label for="point_code_POR"><b>POR</b></label><!--
					--><input type="radio" class="trans" name="point_code" value="POR"/>&nbsp;&nbsp;&nbsp;&nbsp;<!--
					--><label for="point_code_POL"><b>POL</b></label><!--
					--><input type="radio" class="trans" name="point_code" value="POL"/>&nbsp;&nbsp;&nbsp;&nbsp;<!--
					--><label for="point_code_TS"><b>T/S</b></label><!--
					--><input type="radio" class="trans" name="point_code" value="TS"/>&nbsp;&nbsp;&nbsp;&nbsp;<!--
					--><label for="point_code_POD"><b>POD</b></label><!--
					--><input type="radio" class="trans" name="point_code" value="POD"/>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
					--><label for="point_code_DEL"><b>DEL</b></label><!--
					--><input type="radio" class="trans" name="point_code" value="DEL"/>
					</td>
				</tr>
				<tr>
					<td>
						<% if(!mode.equals("pop") && "Y".equals(link_flg)) {%>
						<input type="radio" value="1" name ="radioGubun" class="trans" onClick="changeSelection(1);" checked >
						<%}else {%>
						<input type="radio" value="" name ="radioGubun" class="trans" onClick="changeSelection(1);" >
						<%}%>
					</td>
					<td><b>Link</b></td>
					<td colspan="14"><input name="from_nd" type="text" maxlength="7"  style="width:70px;text-align:center" value="<%=fromNd %>" dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_from_cd" id="btn_from_cd"></button>~&nbsp;<input name="to_nd" type="text" maxlength="7" style="width:70px;text-align:center" value="<%=toNd %>"  dataformat="engup" style="text-align:center"><!-- 
					  --><button type="button" class="input_seach_btn" name="btn_to_cd" id="btn_to_cd"></button></td>
				</tr>
				<tr>
					<td>
						<% if(!mode.equals("pop") && !"Y".equals(link_flg)) {%>
						<input type="radio" class="trans" name ="radioGubun" value=""  onClick="changeSelection(2);" checked >
						<%}else {%>
						<input type="radio" class="trans" name ="radioGubun" value=""  onClick="changeSelection(2);"  >
						<%}%>
					</td>
					<td><b>Route</b></td>
					<th>T.Lane</th>
					<td><input name="tlane" type="text" maxlength="3"  style="width:59px;text-align:center"  tabIndex="20" dataformat="engup" style="text-align:center"><!-- 
						 --><button type="button" class="input_seach_btn" name="btn_tnk_lane_cd" id="btn_tnk_lane_cd"></button></td>
					<th>BD</th>
					<td><input type="hidden" name="dir_cd" tabIndex="21" value="<%=event.getConstraintVO().getDirCd()%>" ><!-- 
					 --><select name="s_dir_cd" id="s_dir_cd" style="width:50px" onChange="changeDirection()"><!-- 
					 --><option value="0" selected>ALL</option><!-- 
					 --><option value="E">E</option><option value="W">W</option><option value="S">S</option><option value="N">N</option></select> </td>	
					 <th title="Place of Receipt">POR</th>
					<td><input name="por" type="text" maxlength="7"  style="width:58px;text-align:center"   tabIndex="22" dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_por_port_cd" id="btn_por_port_cd"></button></td>
					<th title="Port of Loading">POL</th>
					<td><input name="pol" type="text" maxlength="7"  style="width:58px;text-align:center"   tabIndex="22" dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_pol_port_cd" id="btn_pol_port_cd"></button></td>
					<th>T/S</th>
					<td><input name="tsport" type="text" maxlength="7" style="width:58px;text-align:center"  tabIndex="23" dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_ts_port_cd" id="btn_ts_port_cd"></button></td>
					<th title="Port of Discharging">POD</th>
					<td><input name="pod" type="text" maxlength="7"  style="width:58px;text-align:center"  tabIndex="24" dataformat="engup" style="text-align:center"><button type="button" class="input_seach_btn" name="btn_pod_port_cd" id="btn_pod_port_cd"></button></td>
					<th title="Place of Delivery">DEL</th>
					<td><input name="del" type="text" maxlength="7"  style="width:58px;text-align:center"  tabIndex="25" dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_del_port_cd" id="btn_del_port_cd"></button></td>
					<th>SVC</th>
					<td><select name="svc" id="svc" tabIndex="26" style="width:50px"><option value="A" >All</option><option value="Y" >Y</option><option value="N" >N</option> </select></td>
				</tr>
				<tr>
					<td>
						<input type="radio" value="1" name ="radioGubun" class="trans" onClick="changeSelection(3);">
					</td>
					<td><b>Hub</b></td>
					<th>Port</th>
					<td><input name="hport_cd" type="text" maxlength="7" style="width:70px;text-align:center"   value="" dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_hport_cd" id="btn_hport_cd"></button></td>
					<th>Hub Location</th>
					<td><input name="hhub_loc_cd" type="text" maxlength="7" style="width:70px;text-align:center"   value="" dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_hhub_loc_cd_cd" id="btn_hhub_loc_cd_cd"></button></td>
					<th>Location/Node</th>
					<td><input name="hnod_cd" type="text" maxlength="7" style="width:70px;text-align:center"   value="" dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_hnod_cd" id="btn_hnod_cd"></button></td>
					 <td colspan="8">&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<!-- opus_design_inquiry(E) -->

<div id="tabLayer" style="display:none">
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
		</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<h3>Creation staff should fill in the "remarks" with full detail.</h3>
</div>
</div>
<!-- opus_design_grid(E) -->
</div>

<div id="tabLayer" style="display:none">
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
		</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<h3>Creation staff should fill in the "remarks" with full detail.</h3>
</div>
</div>
<!-- opus_design_grid(E) -->
</div>

<div id="tabLayer" style="display:inline">
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
		</div>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
			<h3>Creation staff should fill in the "remarks" with full detail.</h3>
</div>
</div>
<!-- opus_design_grid(E) -->
</div>
<div id="tabLayer" style="display:none">
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_hrowadd" id="btng_hrowadd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btng_hrowcopy" id="btng_hrowcopy">Row Copy</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
		<h3>Creation staff should fill in the "remarks" with full detail.</h3>
</div>
</div>
<script type="text/javascript">ComSheetObject('sheet5');</script>
<!-- opus_design_grid(E) -->
</div>
</form>

