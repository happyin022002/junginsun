<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0930.jsp
*@FileTitle  : Office Transfer Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0930Event"%>
<%
String strErrMsg = ""; 
SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT); 
%>
<script type="text/javascript">
<!--
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
//-->
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>" id="ctrl_ofc_cd" />
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>" id="ctrl_user_id" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Office Transfer</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
     	<button type="button" class="btn_accent" name="btn_transfer"id="btn_transfer">Transfer</button><!-- 
   		--><button type="button" class="btn_normal" id="btn_close" name="btn_close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>

<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
	            <colgroup>
	                <col width="60"> 
	                <col width="100">
	                <col width="*">
	            </colgroup>
	            <tbody>
		             <tr>
						<th>Transfer To</th>
						<td>
							<input name="new_trns_rqst_ofc_cd" id="new_trns_rqst_ofc_cd" type="text" style="width:100px" value="" maxlength="6" dataformat="engup" onBlur="javascript:officeCheck(this);"><!-- 
							 --><button type="button" class="input_seach_btn" name="btns_search" id="btns_search"></button>
					</tr>
					<tr>
						<th>Transfer Reason</th>
						<td><input name="new_trns_rqst_rsn" id="new_trns_rqst_rsn" type="text" style="width:360px" value=""></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >		
		<script type="text/javascript">ComSheetObject('sheet');</script>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>