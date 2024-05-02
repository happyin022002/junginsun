<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1023.jsp
*@FileTitle : Vessel Stowage Plan Transmit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12 
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.12 김도완
* 1.0 Creation
*-------------------------------------------------------
* History
* 2011.10.13 김봉균 [CHM-201112452-01] 미세관 RECEIVE 데이터 중 CUSRES 반영 요청
=========================================================*/%>

<%@ page import="com.clt.framework.component.util.StringUtil" %>

<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="vvd" id="vvd" value="<%=StringUtil.xssFilter(request.getParameter("vvd"))%>">
<input type="hidden" name="vps_port_cd" id="vps_port_cd" value="<%=StringUtil.xssFilter(request.getParameter("vps_port_cd"))%>">
<input type="hidden" name="clpt_ind_seq" id="clpt_ind_seq" value="<%=StringUtil.xssFilter(request.getParameter("clpt_ind_seq"))%>">

<div class="layer_popup_contents">
 <div class="layer_popup_title">
    <div class="page_title_area clear">
    <h2 class="page_title"><span>Select CRN for Baplie</span></h2>
	    <div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_transmit"  id="btn_transmit">Transmit</button>
			<button type="button" class="btn_normal" name="btn_close"  id="btn_close">Close</button>
	    </div>
    </div>
</div>

<div class= "wrap_search">
	    <table>
	      <tbody>
	        <colgroup>
	        	<col width="30">
	        	<col width="60">
	        	<col width="60">
	        	<col width="90">
	        </colgroup>
				<tr>
					<td class = "sm"><input type="radio" name="allerror" id="allerror" value="1" class="trans" checked></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 85px; ime-mode:disabled;" class="input" value="" name="vvd1" id="vvd1" dataformat="engup" readonly> </td>
					<th title="CRN">CRN</th>
					<td><input type="text" name="crn1" style="width:140px;ime-mode:disabled;" value="" class="input" id="crn1" dataformat="engup" readonly> </td>
				</tr>
			</tbody>
		</table>
		<table>
	      <tbody>
	        <colgroup>
	        	<col width="30">
	        	<col width="60">
	        	<col width="60">
	        	<col width="90">
	        </colgroup>
				<tr>
					<td class = "sm"><input type="radio" name="allerror" value="2" class="trans"><label></label></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 85px; ime-mode:disabled;" class="input" value="" name="vvd2" id="vvd2" dataformat="engup" readonly> </td>
					<th title="CRN">CRN</th>
					<td><input type="text" name="crn2" style="width:140px;ime-mode:disabled;" value="" class="input" id="crn2" dataformat="engup" readonly> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid">
	    	<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	
 </div>
</form>