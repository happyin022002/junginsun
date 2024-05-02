<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0015.js
*@FileTitle  : Service Order 생성화면 - Chassis or Genset 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.EsdTrs0014Event"%>
<%
	EsdTrs0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {

		event = (EsdTrs0014Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
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
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="TRSP_SO_EQ_KIND" value="" id="TRSP_SO_EQ_KIND" />
<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Detail Input</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_apply" 	id="btn_apply">Apply</button><!--
			--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th><div align="left">From Node </div></th>
					<td><input name="pop_fm_loc" dataformat="enguponly" type="text" class="input" style="width:276px;" onchange="getComboList('pop_fm')" onkeyup="enterCheck('pop_fm')" maxlength="5" id="pop_fm_loc"  /><script type="text/javascript">ComComboObject('pop_fm_yard', 1, 80, 1);</script><button type="button" id="btn_fm_node" name="btn_fm_node" class="input_seach_btn"></button></td>
				</tr>
				<tr>
					<th><div align="left">To Node </div></th>
					<td><input name="pop_to_loc" dataformat="enguponly" type="text" class="input" style="width:276px;" onchange="getComboList('pop_to')" onkeyup="enterCheck('pop_to')" maxlength="5" id="pop_to_loc" /><script type="text/javascript">ComComboObject('pop_to_yard', 1, 80, 1);</script><button type="button" id="btn_to_node" name="btn_to_node" class="input_seach_btn"></button></td>
				</tr>	
				<tr>
					<th><div align="left">Trans Mode</div></th>
					<td><%=JSPUtil.getCodeCombo("pop_transMode", "", "style='width:120px'", "CD00283", 0, "000010::")%></td>
				</tr>	
				<tr>
					<th><div align="left">Remarks</div></th>
					<td><input name="pop_remark" id="pop_remark" type="text" class="input" style="width:364px;"></td>
			  </tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>