<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0028.jsp
*@FileTitle  : Container Status Update  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
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
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffHire");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EesMst0028Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
	
	String sCntrNo = (request.getParameter("s_cntrno") == null)? "": request.getParameter("s_cntrno");
	String strCntrNo = "";
	String strChkDgt = "";
	if(sCntrNo.length() == 11) {
		strCntrNo = sCntrNo.substring(0,10);
		strChkDgt = sCntrNo.substring(10, 11);
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
<input type="hidden" name="hid_ofc_cd" id="hid_ofc_cd" value="<%=strOfc_cd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="New" id="New">New</button><!-- 
		--><button type="button" class="btn_normal" name="Save" id="Save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<div class="location"><span id="navigation"></span></div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit" id="showMin" style="display:inline">
	<table>
		<tbody>
			<colgroup>
				<col width="80" />
				<col width="100" />
				<col width="80" />
				<col width="100" />
				<col width="80" />
				<col width="80" />
				<col width="100" />
				<col width="100" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>CNTR No.</th>
				<td><input type="text" style="width: 90px;" class="input1" dataformat="engup" maxlength="10" name="cntr_no" id="cntr_no" value="<%=strCntrNo %>" style="ime-mode:disabled; text-align:center; text-transform:uppercase;"><input type="text" style="width: 15px;" class="input2"  readOnly value="<%=strChkDgt %>" dataformat="num" name="chk_dgt" id="chk_dgt"></td>
				<th>Status</th>
				<td><input type="text" style="width: 60px;" class="input2"  readOnly value="" name="aciac_div_cd" id="aciac_div_cd"  style="text-align:center"></td>
				<th>TP/SZ</th>
				<td><input type="text" style="width: 50px;" class="input2"  readOnly value="" name="cntr_tpsz_cd" id="cntr_tpsz_cd" style="text-align:center"></td>
				<th>Lease Term</th>
				<td><input type="text" style="width: 50px;" class="input2"  readOnly value="" name="lstm_cd" id="lstm_cd" style="text-align:center"></td>
				<th>ISO Code</th>
				<td><input type="text" style="width: 50px;" class="input2"  readOnly value="" name="cntr_tpsz_iso_cd" id="cntr_tpsz_iso_cd" style="text-align:center"></td>
			</tr>
			<tr>
				<th>Ownership</th>
				<td colspan="3"><input type="text" style="width: 246px;" class="input2"  readOnly value="" name="ownr_co_cd" id="ownr_co_cd" style="text-align:center"></td>
				<th>Current</th>
				<td colspan="5"><input type="text" style="width: 230px;" class="input2"  readOnly value="" name="cntr_use_co_cd" id="cntr_use_co_cd" style="text-align:center"></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
 <!-- opus_design_grid(S) -->
 <div id="showsheet1" style="display:block">
 <div>
	<table>
		<tr>
		<td style="width:50%"><h3 class="title_design mar_btm_8">Container Movement</h3></td>
		<td style="width:50%;text-align:right;padding: 0px 0px 5px 0px;">
		<button type="button" class="btn_up" name="btn_minimize1" id="btn_minimize1" style=""></button>
		</td>
	</table>	
</div>
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->


 <!-- opus_design_grid(S) -->
 <div id="showsheet2" style="display:block">
 <div>
	<table>
		<tr>
			<td style="width:50%"><h3 class="title_design mar_btm_8">Container Status</h3></td>
			<td style="width:50%;text-align:right;padding: 0px 0px 5px 0px;">
			<button type="button" class="btn_up" name="btn_minimize2" id="btn_minimize2" style=""></button>
			</td>
		</tr>
	</table>	
</div>
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
