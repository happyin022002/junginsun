<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0026.jsp
*@FileTitle  : Allocation History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmSpc0026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	
		event = (EsmSpc0026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
%>
<script type="text/javascript">
	var ofc_cd = "<%=ofc_cd%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- the value to set shortcut key -->
<input type="hidden" name="uiname" id="uiname" value="ESM_SPC_0026">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  		id="btn_downexcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="30">
					<col width="130">
					<col width="60">
					<col width="50">
					<col width="110">
					<col width="65">
					<col width="60">
					<col width="50">
					<col width="150">
					<col width="50">
					<col width="*">
			    </colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input class="input1" type="text" name="vvd" id="vvd" value = "" size="12" maxlength="9" style="ime-mode:disabled;" dataformat="engup" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
					<td><input type="radio" class="trans" name="ioc" id="id_chk_ocn" onclick = " return chk_combo();" value="O" checked>&nbsp;&nbsp;<b>OCN</b></td>
					<td><input type="radio" class="trans" name="ioc" id="id_chk_ipc" onclick = " return chk_combo();" value="I">&nbsp;&nbsp;<b>IPC</b></td>
					<td><input type="radio" class="trans" name="ioc" id="id_chk_ts" onclick = " return chk_combo();" value="T">&nbsp;&nbsp;<b>T/S by Office</b></td>
					<td><input type="radio" class="trans" name="ioc" id="id_chk_nycna" onclick = " return Clearcombo();" value="NYCHQ">&nbsp;&nbsp;<b>T/S A</b></td>
					<td><input type="radio" class="trans" name="ioc" id="id_chk_hamur" onclick = " return Clearcombo();" value="LONHQ">&nbsp;&nbsp;<b>T/S E</b></td>
					<th>&nbsp;&nbsp;H/O Controlled Office</th>
					<td><script type="text/javascript">ComComboObject("salesOffice", 2, 106, 0);</script></td>
					<th>Main Office Controlled Office</th>
					<td><script type="text/javascript">ComComboObject("subOffice", 2, 80, 0);</script></td>
				</tr>	
				
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">

	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
			<div class="wrap_result">
				<div class="opus_design_grid clear" >
						<span>(Unit : TEU)</span>
						<script type="text/javascript">ComSheetObject('t1sheet1');</script>
				</div>
			</div>
		<!-- opus_design_grid(E) -->
	</div>


<!-- opus_design_grid(S) -->
<div id="tabLayer" style="display:inline">
	<div class="opus_design_grid clear" >
		<div class="opus_design_inquiry" >
			<table>
			<tbody>
				<colgroup>
					<col width="90">					
					<col width="60">
					<col width="10">
					<col width="20">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="60">
					<col width="20">
					<col width="*">
			    </colgroup>
				<tr>
					<th>Data Selection : </th>
				    <td><input type="hidden" class="trans" name="chkDs2OFC" id="ds2OFC"  checked onclick="return changeDataSelection();"><input  type="checkbox" class="trans" name="chkDs2POL" id="ds2POL"  onclick="return changeDataSelection();"><label for="ds2POL">POL</label></td>
					<td><input type="checkbox" class="trans" name="chkDs2POD" id="ds2POD"   onclick="return changeDataSelection();"><label for="ds2POD">POD</label></td>
					<td><input type = "hidden"  class="trans" name="chkDs2OTH" id="ds2OTH"  onclick="return changeDataSelection();"></td>
					<td><input type="checkbox" class="trans" name="chkDs2HC" id="ds2HC"  onclick="return changeDataSelection();"><label for="ds2HC">HC</label></td>
					<td><input type="checkbox" class="trans" name="chkDs245" id="ds245"  onclick="return changeDataSelection();"><label for="ds245">45</label></td>					
					<td><input type="checkbox" class="trans" name="chkDs253" id="ds253"  onclick="return changeDataSelection();"><label for="ds253">53'</label></td>					
					<td><input type="checkbox" class="trans" name="chkDs2RF" id="ds2RF"  onclick="return changeDataSelection();"><label for="ds2RF">RF</label></td>					
					<td><input type="checkbox" class="trans" name="chkDs2WT" id="ds2WT"  onclick="return changeDataSelection();"><label for="ds2WT">WT</label></td>					
					<td align="right" id="sheetControlDiv" name="sheetControlDiv"><button type="button" class="btn_up" name="maxi" id="maxi" sheetId="t1sheet2" type="N" onclick="toggleSheetSize();"></button></td>
				</tr>
			</tbody>
		</table>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet2');</script>
	</div>
</div>
</div>
<!-- opus_design_grid(E) -->		
</form>