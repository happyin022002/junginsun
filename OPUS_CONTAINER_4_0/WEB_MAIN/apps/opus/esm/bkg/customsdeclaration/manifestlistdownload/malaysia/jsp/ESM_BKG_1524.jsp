<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1524.jsp
*@FileTitle  : Malaysia Special Cargo Info
*@author     : CLT
*@version    : 1.0
*@since      :
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String cntrNo = JSPUtil.getParameter(request, "cntr_no");
	String bkgNo = JSPUtil.getParameter(request, "bkg_no");
	String vslCd = JSPUtil.getParameter(request, "vsl_cd");
	String skdVoyNo = JSPUtil.getParameter(request, "skd_voy_no");
	String skdDirCd = JSPUtil.getParameter(request, "skd_dir_cd");
	String selectRow = JSPUtil.getParameter(request, "select_row");
%>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="bkg_no" value="<%=bkgNo%>" id="bkg_no" />
<input type="hidden" name="vsl_cd" value="<%=vslCd%>" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" value="<%=skdVoyNo%>" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd%>" id="skd_dir_cd" />
<input type="hidden" name="type_cd" value="U" id="type_cd" />
<input type="hidden" name="select_row" value="<%=selectRow%>" id="select_row" />
<input type="hidden" name="ovr_bak_dim_len" id="ovr_bak_dim_len" />

<div class="layer_popup_contents">
	<div class="layer_popup_title">
		<!-- page_title(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Malaysia Special Cargo Info.</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
				--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
				--><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
				--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
			</div>
			<!-- opus_design_btn (E) -->
			<!-- page_location(S) -->
			<div class="location">
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) -->
		</div>
	</div>

	<div class= "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="80" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Container No.</th>
						<td><input type="text" style="width:100px; text-align:center;" ReadOnly name="cntr_no" id="cntr_no" class="input2" value="<%=cntrNo%>"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col />
					<col />
					<col />
					<col />
					<col />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th>Over Dim.</th>
						<th>Height</th>
						<td><input type="text" style="width:60px; text-align:right" class="input" name="ovr_dim_hgt" dataformat="float" id="ovr_dim_hgt" /></td>
						<th>Height</th>
						<td style="padding-right:28px;"><input type="text" style="width:60px; text-align:right" class="input" name="dim_hgt" dataformat="float" id="dim_hgt" /></td>
						<th style="text-align:left;">Direct Delivery&nbsp;
							<select style="width:40px;" name="dir_de_flg" id="dir_de_flg">
								<option value=""></option>
								<option value="Y">Y</option>
								<option value="N">N</option>
							</select></th>
					</tr>
					<tr>
						<td></td>
						<th>Front</th>
						<td><input type="text" style="width:60px; text-align:right" class="input" name="ovr_fnt_dim_len" dataformat="float" id="ovr_fnt_dim_len" /></td>
						<th>Length</th>
						<td><input type="text" style="width:60px; text-align:right" class="input" name="dim_len" dataformat="float" id="dim_len" /></td>
						<th style="text-align:left;">Disch. Oversize (Bulk)&nbsp;
							<select style="width:40px;" name="dchg_ovr_sz_flg" id="dchg_ovr_sz_flg">
								<option value="" selected></option>
								<option value="Y">Y</option>
								<option value="N">N</option>
							</select></th>
					</tr>
					<tr>
						<td></td>
						<th>Left</th>
						<td><input type="text" style="width:60px; text-align:right" class="input" name="ovr_lf_dim_wdt" dataformat="float" id="ovr_lf_dim_wdt" /></td>
						<th>Width</th>
						<td><input type="text" style="width:60px; text-align:right" class="input" name="dim_wdt" dataformat="float" id="dim_wdt" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<th>Right</th>
						<td><input type="text" style="width:60px; text-align:right" class="input" name="ovr_rt_dim_wdt" dataformat="float" id="ovr_rt_dim_wdt" /></td>
						<td></td>
						<td></td>
						<th style="text-align:left;">Loading Ins. (T/S)&nbsp;
							<script type="text/javascript">ComComboObject1("ld_ins", 2, 60, 1, 0);</script></th>
					</tr>
					<tr>
						<td></td>
						<th>RF Temp.</th>
						<td><input type="text" style="width:60px; text-align:right" class="input" name="rf_flg" dataformat="singledfloat"  id="rf_flg" /></td>
						<th>DG Class</th>
						<td><input type="text" style="width:60px; text-align:right" class="input" name="imdg_clss_cd" dataformat="float" id="imdg_clss_cd" /></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<th>Ventilation</th>
						<td><input type="text" style="width:60px; text-align:right" class="input" name="cbm_per_hr_qty" dataformat="float" id="cbm_per_hr_qty" />CMH</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<br />
			<table>
				<colgroup>
					<col width="105" />
					<col width="530" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Cargo Desc.</th>
						<td><textarea style="width:100%; resize:none;" rows="4" name="cgo_desc" id="cgo_desc"></textarea></td>
						<td></td>
					</tr>
					<tr>
						<th>Commodity Desc.</th>
						<td><input type="text" style="width:100%;resize:none;" class="input" name="cmdt_desc" id="cmdt_desc" /></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" style="display:none;">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	</div>
<!-- opus_design_inquiry(E) -->
</div>
</form>