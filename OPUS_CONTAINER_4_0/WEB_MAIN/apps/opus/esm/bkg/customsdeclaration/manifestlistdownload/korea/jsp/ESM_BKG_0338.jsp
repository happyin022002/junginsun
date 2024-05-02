<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0338.jsp
*@FileTitle  : Bonded Inform Designate-Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String type = JSPUtil.getParameter(request, "type");
	String vvd = JSPUtil.getParameter(request, "vvd");
	String mrn_no = JSPUtil.getParameter(request, "mrn_no");
	String mrn_chk_no = JSPUtil.getParameter(request, "mrn_chk_no");
	String mode = "".equals(JSPUtil.getParameter(request, "mode")) ? "Inbound" : JSPUtil.getParameter(request, "mode");
	String pol = JSPUtil.getParameter(request, "pol");
	String pod = JSPUtil.getParameter(request, "pod");
	String etd = JSPUtil.getParameter(request, "etd");
	String eta = JSPUtil.getParameter(request, "eta");
	String yard = JSPUtil.getParameter(request, "yard");
	String bl_cnt = "".equals(JSPUtil.getParameter(request, "cnt_bl_no")) ? "0" : JSPUtil.getParameter(request, "cnt_bl_no");
	String bkgNo = JSPUtil.getParameter(request, "bkg_no");
%>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" value="" id="f_cmd" />
<input type="hidden" name="yard" value="<%=yard%>" id="yard" />
<input type="hidden" name="bkg_no" value="<%=bkgNo%>" id="bkg_no" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Edit MSN/Customs Inform by POL/POD</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_listprint" id="btn_listprint">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm All</button><!--
		--><button type="button" class="btn_normal" name="btn_editBl" id="btn_editBl">Go to Edit B/L</button><!--
		--><button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button><!--
	--></div>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="35" />
				<col width="90" />
				<col width="30" />
				<col width="115" />
				<col width="30" />
				<col width="190" />
				<col width="40" />
				<col width="150" />
				<col width="30" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Type</th>
					<td><input type="text" style="width:60px; text-align:center;" name="type" class="input2" value="<%=type%>" readonly id="type" /> </td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:85px;text-align:center;" name="vvd" class="input2" value="<%=vvd%>" readonly id="vvd" /> </td>
					<th>MRN</th>
					<td><input type="text" style="width:90px;text-align:center;" name="mrn_no" class="input2" value="<%=mrn_no%>" readonly id="mrn_no" />- <input type="text" style="width:30px;text-align:center;" name="mrn_chk_no" class="input2" value="<%=mrn_chk_no%>" readonly id="mrn_chk_no" /> </td>
					<th>Mode</th>
					<td><input type="text" style="width:90px;text-align:center;" name="mode" class="input2" value="<%=mode%>" readonly id="mode" /> </td>
					<th>MSN</th>
					<td><input type="text" style="width:40px;" class="input1" name="msn1" dataformat="num" maxlength="4" onchange="msn1_onChange();" id="msn1" />- <input type="text" style="width:40px;" class="input2" name="msn2" dataformat="num" maxlength="4" onchange="msn2_onChange();" id="msn2" /> </td>
				</tr>
				<tr>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;text-align:center;" name="pol" class="input2" value="<%=pol%>" readonly id="pol" /></td>
					<th>ETD</th>
					<td><input type="text" style="width:85px;text-align:center;" class="input2" value="<%=etd%>" name="etd" readonly id="etd" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:90px;text-align:center;" name="pod" class="input2" value=" <%=pod%>" readonly id="pod" /></td>
					<th>ETA</th>
					<td><input type="text" style="width:90px;text-align:center;" class="input2" value="<%=eta%>" name="eta" readonly id="eta" /></td>
					<th>Total Record</th>
					<td><input type="text" style="width:30px;text-align:center;" name="bl_cnt" class="input2" value=" <%=bl_cnt%>" readonly id="bl_cnt" />B/Ls</td>
				</tr>
				<tr>
					<td colspan="10"><div class="opus_design_btn"><button type="button" class="btn_etc" name="btn_msn" 	id="btn_msn">MSN Assign</button></div></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>