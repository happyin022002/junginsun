<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3104.jsp
*@FileTitle  : Exemption Reason Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3104Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesDmt3104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="dmdt_chg_delt_rsn_cd" id="dmdt_chg_delt_rsn_cd" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Exemption Reason Entry</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Save" id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>	
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class= "opus_design_inquiry">
		<table class="grid_2">
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th><b>Remark(s)</b></th>
					<td><textarea name="corr_rmk" id="corr_rmk" cols="" rows="4" style="width:100%"></textarea></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="30"/>
					<col width="70"/>
					<col width="60"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Office</th>
					<td><input type="text" name="upd_ofc_cd" id="upd_ofc_cd" style="width:60px;" class="input2" readOnly value="<%=strOfc_cd%>"></td>
					<th>Name</th>
					<td><input type="text" name="usr_nm" id="usr_nm" style="width:100%;" class="input2" readOnly value="<%=strUsr_nm%>"></td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
	<div class="wrap_result" style="display:none;">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
<!-- opus_design_grid(E) -->
</div>
</form>