<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : CPS_CNI_0019.jsp
*@FileTitle  : Status Inquiry by Class Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/26
=========================================================*/
%>

<script language="javascript">
    function setupPage(){  
	    loadPage();
    }
</script>


<form name="form">
<input type="hidden" name="page_no" value="1">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Status Inquiry by Class</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn1_OK" id="btn1_OK">OK</button><!--  -->
			<button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<th width="60px">Template</th>
				<td width="310px"><select name="template_class" style="width:300px;">
					<option value="63" selected>By Area</option>
					<option value="64">By HOFC</option>
					<option value="65">By Handler</option>
					<option value="66">By Surveyor</option>
					<option value="67">By Liable Party</option>
					<option value="68">By VVD</option>
					<option value="69">By Container</option>
					<option value="70">By Claim Amount</option>
					<option value="71">By Application</option>
					<option value="72">By Settled Amount</option>
					<option value="73">By Litigation</option>
					<option value="74">By Insurer</option>
					<option value="75">By Handling Period</option>
					</select></td>
				<td >
				<button type="button" style="width:56px" class="btn_etc align_left" name="btns_Get" id="btns_Get">Get</button>
			</td>
			</tr>
			
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="layout_wrap">
		    <div class="layout_flex_flex" style="width:46%;">
		    	<h3 class="title_design">Selectable Columns</h3>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<th>column
					</th>
					<td><input type="text" style="width:81%;" name="sheet1autofind">
					</td>
				</tr>
				</table>
				<div class="opus_design_grid">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</div>
			</div>
			<div class="layout_flex_flex" style="width:5%;left:47%;">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23" style="height:270px">
				<td align="center">
				<img class="cursor" src="img/btns_add.gif" width="26" height="26" border="0" align="absmiddle" name="btns_Add"></td>
				</tr>
				<tr class="h23">
				<td align="center">
				<img class="cursor" src="img/btns_del.gif" width="26" height="26" border="0" align="absmiddle" name="btns_Del"></td>
				</tr>
				</table>
			
			</div>
			
			<div class="layout_flex_flex" style="right:0;left:auto;width:47%">
				<h3 class="title_design">Selected & To be displayed</h3>	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<th>column
					</th>
					<td><input type="text" style="width:81%;" name="sheet2autofind">
					</td>
				</tr>
				</table>
				<div class="opus_design_grid">
					<script language="javascript">ComSheetObject('sheet2');</script>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btns_Up" id="btns_Up">Up</button><!--  -->
						<button type="button" class="btn_normal" name="btns_Down" id="btns_Down">Down</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</form>
