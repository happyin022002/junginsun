<%@ page import="com.clt.framework.component.util.StringUtil" %>
<div class="layout_vertical_2 pad_rgt_8" style="padding-bottom:5px"> 
	<div class="opus_design_grid">
		<h3 class="title_design">Booking Data OPUS</h3>
		<div class="specialCls">
			<button type="button" class="btn_etc" onclick="opusCancel()">Cancel Copy Data</button>
		</div>
	</div>
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry">
    	<table>
			<colgroup>
				<col width="30">
				<col width="60">
				<col width="80">
				<col width="100">
				<col width="70">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Seq.</th>
					<td><select name="eur_opus_seq" id="eur_opus_seq" style="width:60px;" onChange="javascript:opuschange_seq(this.value);"></select></td>
					<th>Booking No.</th>
					<td><input type="text" name="bkg_no" id="bkg_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
					<th>Type/Size</th>
					<td><input type="text" style="width:50px;" name="cntrTpszCd" class="input1" id="cntrTpszCd" />
						<font color="red"><span id="request_result" tabindex="-1"></span></font>
					</td>
					<td><div class="specialCls"><button type="button" class="btn_etc" onclick="opusSubSeqAdd()">Multi Add</button></div></td>
				</tr>
			</tbody>
		</table>
		<div id="opusTroDtlDiv">
			<table>
				<colgroup>
					<col width="100">
					<col width="200">
					<col width="100">
					<col width="80">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Supplier's Name</th>
						<td><input type="text" style="width:100%;" name="" id="" class="input2" /></td>
						<th>Contact Person</th>
						<td colspan="4"><input type="text" style="width:100%;" name="" id="" class="input2" /></td>
					</tr>
					<tr>
						<th rowspan="3" style="vertical-align:top;line-height:29px;">Address</th>
						<td><input type="text" style="width:100%;" name="" id="" class="input2" /></td>
						<th>Postal / Zip Code</th>
						<td><input type="text" style="width:100%;" name="" id="" class="input2"/></td>
						<th>Phone No.#</th>
						<td><input type="text" style="width:100%;" name="" id="" class="input2" /></td>
					</tr>
					<tr>
						<td><input type="text" style="width:100%;" name="" id="" class="input2" /></td>
						<th>E - Mail</th>
						<td colspan="4"><input type="text" style="width:100%;" name="" id="" class="input2" /></td>
					</tr>
					<tr>
						<td><input type="text" style="width:100%;" name="" id="" class="input2" /></td>
						<th>Drop-Off Date</th>
						<td colspan="3">
							<input type="text" name="dorOffDt" id="dorOffDt" style="width:74px;text-align:center" class="input2" /><!-- 
                         --><button type="button" id="btn_dorOffDt" name="btn_dorOffDt" class="calendar ir" onclick="getCalendar()"></button><!-- 
						 --><input type="text" style="width:22px" name="" id="" class="input2 align_center" />:<!--  
						 --><input type="text" style="width:22px" name="" id="" class="input2 align_center" /><!-- 
						 --><button type="button" class="btn_etc" onclick="opusSubSeqDel()" style="padding:0;width:34px">Del</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<table id="rmkTable">
			<colgroup>
				<col width="85">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Remarks</th>
					<td>
						<textarea name="diffRmk" id="diffRmk" style="width:100%; height:40px; resize:none"></textarea>	
					</td>
				</tr>
			</tbody>
		</table>
		<div class="specialCls">
			<button type="button" class="btn_etc" name="" id="" onclick="opusSeqDelete()">Remove Inland Pick Up</button>
			<button type="button" class="btn_etc" name="" id="" onclick="opusSeqAdd()">Add Inland Pick Up</button>
		</div>
   	</div>
   	<!-- opus_design_inquiry (E) -->
</div>
<div class="layout_vertical_2" style="padding-bottom:5px">
	<div class="opus_design_grid">
		<h3 class="title_design">From e- Service</h3>
		<div class="specialCls">
			<button type="button" class="btn_etc" onclick="xtroCopy()">Data Copy to OPUS</button>
		</div>
	</div>
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry">
    	<table>
			<colgroup>
				<col width="30">
				<col width="60">
				<col width="80">
				<col width="100">
				<col width="70">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Seq.</th>
					<td><select name="eur_xter_seq" id="eur_xter_seq" style="width:60px;" onChange="javascript:xterchange_seq(this.value)"></select></td>
					<th>Request No.</th>
					<td><input type="text" name="rqst_no" id="rqst_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></td>
					<th>Type/Size</th>
					<td><input type="text" style="width:50px;" name="eur_tro_cntr_tpsz_cd" class="input2" id="eur_tro_cntr_tpsz_cd" readonly /></td>
				</tr>
			</tbody>
		</table>
		<div id="xterTroDtlDiv">
		<table>
			<colgroup>
				<col width="100">
				<col width="200">
				<col width="100">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Supplier's Name</th>
					<td><input type="text" style="width:100%;" name="" id="" class="input2" readonly="readonly" /></td>
					<th>Contact Person</th>
					<td colspan="4"><input type="text" style="width:100%;" name="" id="" class="input2" readonly="readonly" /></td>
				</tr>
				<tr>
					<th rowspan="3"style="vertical-align:top;line-height:29px;">Address</th>
					<td><input type="text" style="width:100%;" name="" id="" class="input2"readonly="readonly"  /></td>
					<th>Postal / Zip Code</th>
					<td><input type="text" style="width:100%;" name="" id="" class="input2" readonly="readonly" /></td>
					<th>Phone No.#</th>
					<td><input type="text" style="width:100%;" name="" id="" class="input2" readonly="readonly" /></td>
				</tr>
				<tr>
					<td><input type="text" style="width:100%;" name="" id="" class="input2" readonly="readonly" /></td>
					<th>E - Mail</th>
					<td colspan="4"><input type="text" style="width:100%;" name="" id="" class="input2" readonly="readonly" /></td>
				</tr>
				<tr>
					<td><input type="text" style="width:100%;" name="" id="" class="input2" readonly="readonly" /></td>
					<th>Drop-Off Date</th>
					<td colspan="3">
						<input type="text" style="width:40%;" name="" id="" class="input2" readonly="readonly" />
						<input type="text" style="width:15%;" name="" id="" class="input2" readonly="readonly" />: 
						<input type="text" style="width:15%;" name="" id="" class="input2" readonly="readonly" />
					</td>
				</tr>
			</tbody>
		</table>
		</div>
		<table>
			<colgroup>
				<col width="85">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Remarks</th>
					<td>
						<textarea name="diff_rmk" id="diff_rmk" style="width:100%; height:40px; resize:none" class="input2" readonly></textarea>	
					</td>
				</tr>
			</tbody>
		</table>
   	</div>
</div>
