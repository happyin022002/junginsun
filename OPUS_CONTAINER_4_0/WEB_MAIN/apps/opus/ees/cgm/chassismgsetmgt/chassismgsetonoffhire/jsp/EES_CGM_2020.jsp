<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2020.jsp
*@FileTitle  : Lost M.G.Set Summary Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2020Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm2020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm2020Event)request.getAttribute("Event");
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
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form2">
<input type="hidden" name="sXml" id="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="HIDDEN" name="loc_cd" id="loc_cd" />
<input type="hidden" name="eq_orz_cht_chktype" id="eq_orz_cht_chktype" />
<input type="hidden" name="eq_orz_cht_rcc_cd" id="eq_orz_cht_rcc_cd" />
<input type="hidden" name="eq_orz_cht_lcc_cd" id="eq_orz_cht_lcc_cd" />
<input type="hidden" name="eq_orz_cht_scc_cd" id="eq_orz_cht_scc_cd" />
<input type="hidden" name="location" id="location" value="R">
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--></div>
		<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="100">
				<col width="80">
				<col width="100">
				<col width="60">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody> 
				<tr>
					<th> Period</th>
					<td><input type="text" style="width:80px;text-align:center;ime-mode:disabled" maxlength="10" name="evnt_dt_str" dataformat="ymd" class="input1" value="" id="evnt_dt_str" />~&nbsp;<input type="text" style="width:80px;text-align:center;ime-mode:disabled" maxlength="10" name="evnt_dt_end" dataformat="ymd" class="input1" value="" id="evnt_dt_end" /><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button></td>
					<th>Location</th>
					<td><script type="text/javascript">ComComboObject('combo_location', 1, 55, 1, 1, 0, true);</script><!-- 
					  --><input type="text" style="width:75px;text-align:center;ime-mode:disabled" dataformat="engup" name="scc_cd" id="scc_cd"  class="input"value="" maxlength='5' ><!-- 
					  --><button type="button" id="ComOpenPopupWithScc_cd" name="ComOpenPopupWithScc_cd" class="input_seach_btn"></button></td>
					<th>Yard</th>
					<td><input type="text" maxlength="7" style="width:70px;text-align:center;ime-mode:disabled" name="sts_evnt_yd_cd" class="input" value="" id="sts_evnt_yd_cd" /><button type="button" id="ComOpenPopupWithTargetYard" name="ComOpenPopupWithTargetYard" class="input_seach_btn"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table><tr><td height="3"></td></tr></table>
		<table> 
			<colgroup>
					<col width="540">
					<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td  class="sm pad_left_8"><input type="radio" name="eq_aset_sts_cd" id="radio1" onclick="javascript:Period_Chk()" value="" class="trans" checked><lable for="radio1"> Currently in Lost (Total Loss Excluded)</lable></td>
					<td></td>
				</tr>
				<tr>
					<td  class="sm pad_left_8"><input type="radio" name="eq_aset_sts_cd" id="radio2" onclick="javascript:Period_Chk()" value="LST" class="trans"><lable for="radio2"> Lost Total (Total Loss and Found Included)</lable></td>
					<td></td>
				</tr>
				<tr>
					<td  class="sm pad_left_8"><input type="radio" name="eq_aset_sts_cd" id="radio3" onclick="javascript:Period_Chk()" value="FND" class="trans"><lable for="radio3">  Found Total (Found M.G.Set Only)</lable></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<!-- result_area(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>
