<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0046.jsp
*@FileTitle  : Manufacture Date & Manufacturer Inquiry and Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffHire");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesMst0046Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="hidden_curdate" id="hidden_curdate">
<input type="hidden" name="cntr_nos" id="cntr_nos">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<div class="location"><span id="navigation"></span></div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="5px" />
				<col width="50px" />
				<col width="424px" />
				<col width="70px" />
				<col width="100px" />
				<col width="70px" />
				<col width="200px" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>Lessor</th>
				<td><input type="text" name="vndr_seq" id="vndr_seq" maxlength="6" style="width: 70px; text-align:center; ime-mode:disabled" value="" class="input1" dataformat="num"><button type="button" class="input_seach_btn" id="btns_vndr" name="btns_vndr"></button><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" readonly style="width: 200px; ime-mode:disabled" class="input2" value=""></td>
				<th>Lease Term</th>
				<td><select style="width: 55px;"  name="lstmcd" id="lstmcd" style="text-align:center"><option value="" >ALL</option><option value="ST">ST</option><option value="LT">LT</option></select></td>
				<th>AGMT No.</th>
				<td><input type="text" style="width: 35px" class="input" dataformat="engup" name="agmt_cty_cd" id="agmt_cty_cd" maxlength="3" value="HHO"><input type="text" style="width: 85px" class="input" dataformat="engup" name="agmt_seq" id="agmt_seq" style="ime-mode:disabled; text-align:center" maxlength="6"><button type="button" class="input_seach_btn" name="ComOpenPopupWithTargetAgmtNo" id="ComOpenPopupWithTargetAgmtNo"></button></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="10px" />
				<col width="140px" />
				<col width="15px" />
				<col width="100px" />
				<col width="175px" />
				<col width="150px" />
				<col width="15px" />
				<col width="100px" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>Manufacture Date Flag</th>
				<td></td>
				<td><input type="radio" name="md_flg" id="md_flg" value="Y" class="trans" > Yes<label></label><input type="radio" name="md_flg" id="md_flg" value="N" class="trans" checked> No</td>
				<td></td>
				<th>Manufacturer Flag</th>
				<td></td>
				<td><input type="radio" name="m_flg" id="m_flg" value="Y" class="trans"> Yes<label></label><input type="radio" name="m_flg" id="m_flg" value="N" class="trans" checked> No</td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->	
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>