<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2012.jsp
*@FileTitle  : On & Off-Hire Status Summary Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2012Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	EesCgm2012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
    String strOfc_id   = "";

	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_id = account.getOfc_cd();


		event = (EesCgm2012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>On & Off-Hire Status Summary Inquiry</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();" onkeyup="ComKeyEnter('search');">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="HIDDEN" name="intg_cd_id" id="intg_cd_id" />
<input type="HIDDEN" name="loc_cd" id="loc_cd" />
<input type="hidden" name="s_usr_id" value="<%=strUsr_id %>" id="s_usr_id" />
<input type="hidden" name="s_ofc_id" value="<%=strOfc_id %>" id="s_ofc_id" />
<input type="hidden" name="eq_orz_cht_chktype" id="eq_orz_cht_chktype" />
<input type="hidden" name="eq_orz_cht_rcc_cd" id="eq_orz_cht_rcc_cd" />
<input type="hidden" name="eq_orz_cht_lcc_cd" id="eq_orz_cht_lcc_cd" />
<input type="hidden" name="eq_orz_cht_scc_cd" id="eq_orz_cht_scc_cd" />
<input type="hidden" name="chk_ver" value="ver2" id="chk_ver" />
<input type="hidden" name="location" id="location" /> <!--  Location 선택 구분자 -->
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="head_eq_tpsz_cd" id="head_eq_tpsz_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />				
				<col width="320" />				
				<col width="100" />				
				<col width="100" />	
				<col width="70" />			
				<col width="160" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Period</th>
					<td><input type="text" name="evnt_dt_str" style="width:80px;ime-mode:disabled; text-align:center;" dataformat="ymd" class="input1" maxlength="10" id="evnt_dt_str" />~ <input type="text" name="evnt_dt_end" style="width:80px;ime-mode:disabled; text-align:center;" dataformat="ymd" class="input1" maxlength="10" id="evnt_dt_end" /><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button></td>
					<th>On &amp; Off-Hire</th>
					<td><select style="width:100px;" class="input1" name="eq_aset_sts_cd" id="eq_aset_sts_cd"><option value="LSO" selected>Off-Hire</option><option value="LSI" >On-Hire</option></select></td>
					<td></td>
					<td class="sm pad_left_8"><input type="radio" value="S" class="trans" name="str_gubun" checked onclick="javascript:chk(1)" id="str_gubun" />&nbsp;<strong>Summary</strong>&nbsp;&nbsp;&nbsp;<input type="radio" name="str_gubun" value="D" class="trans" onclick="javascript:chk(2)" id="str_gubun" />&nbsp;<strong>Detailed</strong></td>
					<td></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="80" />				
				<col width="320" />				
				<col width="100" />				
				<col width="100" />				
				<col width="150" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Location</th>
					<td><script type="text/javascript">ComComboObject('combo_location', 1, 51, 1, 1, 0, true);</script><input type="text" style="width:65px;ime-mode:disabled; text-align:center;" dataformat="engup" name="scc_cd"  id="scc_cd" class="input1" value="" maxlength='5'><button type="button" id="ComOpenPopupWithTarget2" name="ComOpenPopupWithTarget2" class="input_seach_btn"></button></td>
					<th>Yard</th>
					<td><input type="text" dataformat="eng" style="width:70px;ime-mode:disabled; text-align:center;" maxlength="7" name="sts_evnt_yd_cd" class="input" value="" id="sts_evnt_yd_cd" /><button type="button" id="ComOpenPopupWithTargetYard" name="ComOpenPopupWithTargetYard" class="input_seach_btn"></button></td>
					<th>Lease Term</th>
					<td><script type="text/javascript">ComComboObject('agmt_lstm_cd', 1, 110, 0, 0, 0, true);</script></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
			   		<th>Kind</th>
		   			<td><select style="width:120px;" class="input" name='kind'><option value="L" selected>Lessor</option><option value="A">Agreement No.</option></select><input type="text" style="width:195px; text-align:Left;" class="input" name="vndr_seq" id="vndr_seq" value=""><button type="button" id="ComOpenPopupWithTargetKind" name="ComOpenPopupWithTargetKind" class="multiple_inq ir"></button></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="tabLayer" name="tabLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="tabLayer" name="tabLayer" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>