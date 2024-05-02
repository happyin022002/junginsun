<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0978.jsp
*@FileTitle  : Transport Status Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0025Event"%>
<%
	EsdTrs0025Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	String woNo = "";
	String trspSoOfcCtyCd = "";
	String trspSoSeq = "";
	String trsSubStsCd = "";
	SignOnUserAccount account= null;

	try {
	   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   event = (EsdTrs0025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} 
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
		trsSubStsCd = "<%= trsSubStsCd %>";
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="trsp_so_ofc_cty_cd" id="trsp_so_ofc_cty_cd"  value="<%= trspSoOfcCtyCd %>" />
<input type="hidden" name="trsp_so_seq" id="trsp_so_seq" value="<%= trspSoSeq %>" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Transport Status Update</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_history" name="btn_history" class="btn_accent">History</button><!-- 
		--><button type="button" id="btn_apply" name="btn_apply" class="btn_accent">Apply</button><!-- 
		--><button type="button" id="btn_close" name="btn_close" class="btn_accent">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="30" />
						<col width="90" />
						<col width="30" />
						<col width="90" />		
						<col width="30" />
						<col width="*" />
					</colgroup>
					<tr  height=35>
						<td><input name="trs_sub_sts_cd" type="radio" class="input" style="width:40px;"  value="DF" id="radio22" /></td>
						<td>Draft</td>
						<td><input name="trs_sub_sts_cd" type="radio" class="input" style="width:40px;"  value="OR" id="radio22" /></td>
						<td>Ordered</td>
						<td></td>
						<td></td>						
					</tr>
					<tr height=35>
						<td><input name="trs_sub_sts_cd" type="radio" class="input" style="width:40px;"  value="ST" id="radio22" /></td>
						<td>Started</td>
						<td><input name="trs_sub_sts_cd" type="radio" class="input" style="width:40px;"  value="AC" id="radio22" /></td>
						<td>Accepted</td>
						<td><input name="trs_sub_sts_cd" type="radio" class="input" style="width:40px;"  value="CM" id="radio22" /></td>
						<td>Completed</td>						
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	

</div>
</form>