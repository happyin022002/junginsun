<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0903.jsp
*@FileTitle  : Next VVD Assign T/S Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0903Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0903Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo = "";
	String strRelayPort = "";
	Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0903Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		strBkgNo =JSPUtil.getNull(event.getBkgBlNoVO().getBkgNo());
		strRelayPort = JSPUtil.getNull(event.getRelayPort());

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Next VVD Assign T/S Remark(s)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<td width="85">Booking No.</td> 
						<td width="160"><input type="text" style="width:110" class="input2" name="bkg_no" value="<%=strBkgNo%>" readOnly></td>
						<td width="80">Relay Port</td> 
						<td><input type="text" style="width:50" class="input2" name="relay_port" readOnly value="<%=strRelayPort%>"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<td colspan="4" style="padding-left:"><textarea  style="width:100%;height:100px" name="ts_rmk"></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>	

</form>