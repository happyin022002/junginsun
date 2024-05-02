<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_FMS_0080.jsp
*@FileTitle  : Item Detail Management - Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event.EsmFms0080Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0080Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.FMSCommon.ExternalFinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0080Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
	}catch(Exception e) {
		log.error("err " + e.toString(), e);
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2><span >Item Detail Management</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_confirm" 		id="btn_confirm">Confirm</button><!--
		--><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="210">
				<col width="*">
			</colgroup>
				<tr>
					<th>Condition </th>
					<td><input type="radio" class="trans" name="rdo_acct_chk" value="0" onclick="javascript:sel_rdo_chk();" id="rdo_acct_chk" /><label>Account Code</label></td>
					<td><input type="radio" class="trans" name="rdo_acct_chk" value="1" checked="" onclick="javascript:sel_rdo_chk();" id="rdo_acct_chk" /><label> Account Name</label></td>
				</tr>				
				<tr >
					<th>Search Keyword </th>   
					<td><div id="act_cd"><input type="text" style="width:145px;" class="input1" name="acct_cd" id="acct_cd" maxlength="6" value=""  style="ime-mode:disabled" ></div></td>
					<td></td>
				</tr>
		</tbody>
	</table>
</div>
</div>
<div class="wrap_result">
<div class="opus_design_gird" >		
<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
</form>