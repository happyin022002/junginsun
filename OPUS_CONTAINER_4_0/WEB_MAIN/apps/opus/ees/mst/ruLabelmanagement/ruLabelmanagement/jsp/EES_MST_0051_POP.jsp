<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0050
*@FileTitle  : RU Label Maintenance
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.event.EesMst0051Event"%>
<%
	EesMst0051Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //Error message
	int rowCount	 = 0;								  //DB ResultSet List the number of

	SignOnUserAccount account = null;

	try {

		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EesMst0051Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end if


	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// Container No.
	String strRuLabelTypeValue = (request.getParameter("rubel_type_value") == null)? "": request.getParameter("rubel_type_value");
	String strRuLabelTypeText = (request.getParameter("rubel_type_text") == null)? "": request.getParameter("rubel_type_text");
	String strTypeModifyYN = (request.getParameter("type_modify_yn") == null)? "": request.getParameter("type_modify_yn");
	
	String strTypeSearchYN = (request.getParameter("type_search_yn") == null)? "": request.getParameter("type_search_yn");
	
	 // change to table name
	String ruLableTp   = JSPUtil.getCodeCombo("ru_label_type", "01", "style='width:120'", "CD20097", 0, "000020:ALL:ALL");

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

<form method="post" name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />
<% if(!"Y".equals(strTypeModifyYN)) { %>
<input id="ru_label_type" name="ru_label_type" type="hidden" value="<%=strRuLabelTypeValue %>" />
<% } %>
<input id="ru_label_default" name="ru_label_default" type="hidden" value="<%=strRuLabelTypeValue %>" />
<input id="ru_label_type_mod_yn" name="ru_label_type_mod_yn" type="hidden" value="<%=strTypeModifyYN %>" />
<input id="ru_label_type_search_yn" name="ru_label_type_search_yn" type="hidden" value="<%=strTypeSearchYN %>" />

<div class="layer_popup_title">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>RU Label Value</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<% if(!"".equals(strTypeSearchYN)) { %>
			<button type="button" class="btn_accent" name="btn_search" id="btn_search">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_select" id="btn_select">Apply</button>
	    <%}else{ %>
	    	<button type="button" class="btn_accent" name="btn_select" id="btn_select">Apply</button>
		<%} %>
			<button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->

	</div>
	<!-- page_title_area(E) -->

</div>

<div class="layer_popup_contents">

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100"/>
					<% if(!"".equals(strTypeSearchYN)) { %>
					<col width="150"/>
					<col width="100"/>
					<% } %>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>RU Label  Type</th>
					<% if(!"".equals(strTypeSearchYN)) { %>
						<td><input type='text' name="ru_label_text" id="ru_label_text" style='width:100px;ime-mode:disabled;text-align:center;text-transform:uppercase;' class="input2" value='<%=strRuLabelTypeText %>' maxlength="11" dataformat="engup" disabled></td>
						<th>RU Label  Value</th>
						<td><input type='text' name="ru_label_value" id="ru_label_value" style='width:200px;text-align:left;' class="input" value='' ></td>
					<% } else { %>
						<% if(!"Y".equals(strTypeModifyYN)) { %>
						<td><input type='text' name="ru_label_text" id="ru_label_text" style='width:100px;ime-mode:disabled;text-align:center;text-transform:uppercase;' class="input2" value='<%=strRuLabelTypeText %>' maxlength="11" dataformat="engup" disabled></td>
						<% } else { %>
						<td class="pad_left_12"><%=ruLableTp%></td>
						<% } %>
					<% } %>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">

		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
</div>
</form>