<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1098.jsp
*@FileTitle  : Inventory by Agreement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1098Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1098Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1098Event)request.getAttribute("Event");
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
<!-- developer working -->
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="eq_orz_cht_chktype" id="eq_orz_cht_chktype" />
<input type="hidden" name="eq_orz_cht_rcc_cd" id="eq_orz_cht_rcc_cd" />
<input type="hidden" name="eq_orz_cht_lcc_cd" id="eq_orz_cht_lcc_cd" />
<input type="hidden" name="eq_orz_cht_scc_cd" id="eq_orz_cht_scc_cd" />
<input type="hidden" name="location" id="location" />
<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
	<!-- opus_design_btn(E) -->	
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100"/>
				<col width="400"/>
				<col width="50"/>
				<col width="300"/>
				<col width="50"/>
				<col width="20"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>Location </th>
					<td><script type="text/javascript">ComComboObject('combo_location', 1, 50, 0, 1, 0, true);</script> <input type="text" name="crnt_loc_cd" dataformat="engup" maxlength="5" style="width:120px;ime-mode:disabled" class="input1" value="" id="crnt_loc_cd" /><button type="button" id="btns_crnt_loc_cd" name="btns_crnt_loc_cd" class="input_seach_btn"></button></td>
					<th>Yard </th>						
					<td><input type="text" name="crnt_yd_cd" dataformat="engup" style="width:160px;ime-mode:disabled" class="input" value="" id="crnt_yd_cd" /><button type="button" id="btns_crnt_yd_cd" name="btns_crnt_yd_cd" class="input_seach_btn"></button></td>
					<th>Include 'NP'<th>
					<td><input type="checkbox" name="include_np" value="" class="trans" id="include_np" /></td>
					<td></td>
				</tr>	
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100"/>
				<col width="400"/>
				<col width="50"/>
				<col width="120"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>Agreement No.</th>
					<td><input type="text" style="width:178px;ime-mode:disabled" class="input" name="agmt_no" dataformat="engup" value="" id="agmt_no" /><button type="button" id="btns_agmt_no" name="btns_agmt_no" class="input_seach_btn"></button /></td>
					<th>Lessor</th>
					<td><input type="text" name="vndr_seq" dataformat="eng" style="width:160px;ime-mode:disabled" class="input" value="" id="vndr_seq" /><button type="button" id="btns_vndr" name="btns_vndr" class="input_seach_btn"></button /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>


<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>