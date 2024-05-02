<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2077.jsp
*@FileTitle  : RFA Guideline Creation - Rate(Route Point)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAGuideline.RFARateGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- developer job	-->
<input type="hidden" name="cd" value="">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>" >
<input type="hidden" name="gline_seq" value="<%=StringUtil.xssFilter(request.getParameter("gline_seq"))%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq"))%>">
<input type="hidden" name="rout_seq" value="<%=StringUtil.xssFilter(request.getParameter("rout_seq"))%>">
<input type="hidden" name="org_dest_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_tp_cd"))%>">
<input type="hidden" name="pnt_via_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("pnt_via_tp_cd"))%>">
<input type="hidden" name="isEditable" value="<%=StringUtil.xssFilter(request.getParameter("isEditable"))%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>RFA Guideline Creation - Rate(Route Point)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
	                <col width="40"/>
	                <col />
	            </colgroup>
	            <tbody>
					<tr>
						<th>Route Point</th>
						<td style="padding-left:15px;">
							<input type="radio" class="trans" name="rt_pnt" value="4" checked>&nbsp;Origin&nbsp;&nbsp;
							<input type="radio" class="trans" name="rt_pnt" value="5" >&nbsp;Origin Via&nbsp;&nbsp;
							<input type="radio" class="trans" name="rt_pnt" value="6" >&nbsp;Destination Via&nbsp;&nbsp;
							<input type="radio" class="trans" name="rt_pnt" value="7" >&nbsp;Destination
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
					<button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

<div id="hiddenSheetLayer" style="display: none ">
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
</div>

</form>