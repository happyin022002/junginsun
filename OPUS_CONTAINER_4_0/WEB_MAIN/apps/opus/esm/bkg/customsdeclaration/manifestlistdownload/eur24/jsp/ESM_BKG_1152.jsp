<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1152.jsp
*@FileTitle  : Europe Advanced Manifest - EXS Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1152Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1152Event  event = null;
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	    
		event = (EsmBkg1152Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="call_type" value="ESM_BKG_1152">

<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="75" />				
				<col width="350" />				
				<col width="200" />				
				<col width="30" />	
				<col width="40" />
				<col width="80" />				
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<th>EU POL ETB</th>
					<td>
					  <input type="text" style="width:80px" value="" class="input1"  name="p_from_dt"  maxlength='10' dataformat="ymd" >
					  <input type="text" name="p_from_mt" style="width:40px" value="00:00" class="input1" dataformat="hm"  maxlength="5" required>
					   &nbsp;~&nbsp;
					  <input type="text" style="width:80px" value="" class="input1"  name="p_to_dt"  maxlength='10' dataformat="ymd" >
					  <input type="text" name="p_to_mt" style="width:40px" value="23:59" class="input1" dataformat="hm"  maxlength="5" required >
					  <button type="button" id="btn_date" name="btn_date" class="calendar ir"></button>
					</td>
				   	<th><input type="radio" name="p_rhq_gb" value="PO" class="trans" checked> &nbspPOL Office &nbsp
						                          <input type="radio" name="p_rhq_gb" value="BO"   class="trans"> &nbspBKG Office
				    </th>
				    <td></td>
					<th>Type</th>
					<td>
						<select style="width: 65px;" name="p_type">
							<option value="" selected>EXS</option>
						</select>
					</td>
					<td></td>
				</tr>	
			</tbody>
		</table> 
		<table> 
			<colgroup>
				<col width="75" />				
				<col width="80" />				
				<col width="65" />	
				<col width="80" />				
				<col width="40" />	
				<col width="90" />
				<col width="40" />
				<col width="40" />				
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<th>EU POL</th>
					<td><input type="text" style="width:80px;ime-mode:disabled" class="input" name="p_pol" value="" maxlength='7' dataformat='engup'></td>
					<th width="65"  style="display:none" id="p_bkg_ofc">BKG OFC</th>
					<th width="65" id="p_pol_ofc">POL OFC</th>
					<td><input type="text" style="width:70px;ime-mode:disabled" class="input" name="p_b_ofc_cd" maxlength='5' dataformat='engup'></td>					
					<th> &nbsp;VVD</th>
					<td><input type="text" style="width:90px;ime-mode:disabled" class="input" name="p_vvd" value=""  maxlength='9' dataformat='engup'></td>
					<th> &nbsp;LANE</th>
					<td><input type="text" style="width:33px;ime-mode:disabled" class="input" name="cond_lane" value=""  maxlength='3' dataformat='engup'></td>
					<td></td>
				</tr>
			</tbody>	
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_inquiry wFit">
		<table class="search" border="0" style="width:1000px;"> 
		  <colgroup>
			<col width="60">
			<col width="60">
			<col width="20">
			<col width="50">
			<col width="60">
			<col width="20">
			<col width="60">
			<col width="60">
			<col width="20">
			<col width="80">
			<col width="60">
			<col width="20">
			<col width="80">
			<col width="60">
			<col width="20">
			<col width="30">			
			<col width="60">
			<col width="20">
			<col width="50">
			<col width="*">						
		  </colgroup>
			<tr>
				<th>Sent B/L</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_sent_bl_cnt" readonly></td>
				<td align='center'> = </td>
				<th>Accepted</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_acc_bl_cnt" readonly></td>
				<th align='center'> + </th>
				<th style='color:red'>Rejected</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_rej_bl_cnt" readonly style='color:red'></td>
				<th align='center'> + </th>
				<th style='color:red'>Not-received</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_nrcv_bl_cnt" readonly style='color:red'></td>
				<th align='center'> + </th>
				<th style='color:red'>Do Not Load</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_donld_bl_cnt" readonly style='color:red'></td>
				<th align='center'> + </th>
				<th style='color:red'>Hold</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_hold_bl_cnt" readonly style='color:red'></td>
				<th align='center'> + </th>
				<th>Released</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_rel_bl_cnt" readonly></td>
			</tr>
		</table>
		<table class="search" border="0" style="width:1000px;">	
		  <colgroup>
		 	<col width="*">
		 	<col width="134">
		 	<col width="20">
		 	<col width="159">
		 	<col width="60">
			<col width="60">						
		  </colgroup>			
			<tr>
				<th>Total B/L</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_total_bl" readonly></td>
				<th>VVD</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_total_vvd" readonly></td>
				<th>EXS Amendment</th>
				<td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_total_amd_cnt" readonly></td>
			</tr>	
		</table>
	</div>
</div>


</form>
