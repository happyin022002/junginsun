<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2018_02.jsp
*@FileTitle  : RFA Guideline Inquiry - Commodity Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.event.EsmPri201802Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri201802Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	//int rowCount   = 0;                       //count of DB resultSET list

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	//Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGroupCommodityGuideline");
	java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo> custList = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri201802Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		custList = (java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo>)com.clt.framework.component.util.code.CodeUtil.getInstance().getCodeSelect("CD01714", 0);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="svc_scp_cd" value="" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="" id="gline_seq" />
<input type="hidden" name="grp_cmdt_seq" value="" id="grp_cmdt_seq" />
<input type="hidden" name="cd" value="" id="cd" />
<input type="hidden" name="yn_data" value="N" id="yn_data" />
<!-- wrap_result(S) -->
<div>
<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</button>
	</div>
</div>
<!-- opus_design_btn (E) -->
<!-- layout_wrap(S) -->
<div class="layout_wrap" style="width: 100%">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 48%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
     <!-- layout_vertical_2(E) -->
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 3%">
		<table style="position: relative;top: 140px;left: 6px;">
			<tr>
				<td style="text-align: center;"><button type="button" class="btn_right"></button></td>
			</tr>
		</table>
	</div>
     <!-- layout_vertical_2(E) -->
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 49%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
     <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="sheetHidden" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>


</form>