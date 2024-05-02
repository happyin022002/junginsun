<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0131.jsp
*@FileTitle  : CodeManage
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.event.EsdTpb0131Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0131Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	StringBuffer codeSb = new StringBuffer();
	DBRowSet rowSet	  = null;

	Logger log = Logger.getLogger("com.clt.apps.MasterDataManage.CodeManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTpb0131Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		if (eventResponse != null) {
			rowSet = eventResponse.getRs();
			if(rowSet != null){
				 //rowCount = rowSet.getRowCount();
				 while(rowSet.next()){
					 codeSb.append(rowSet.getString("n3pty_bil_tp_cd"))
						   .append("|")
						   .append(rowSet.getString("act_flg"))
						   .append("^");
				 }
			} // end if
		} // end if

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00904", 0, "")%>
<%= JSPUtil.getIBCodeCombo("combo02", "01", "CD00579", 0, "")%>
<%= JSPUtil.getIBCodeCombo("combo03", "01", "CD00581", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>

<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="pagerows" id="pagerows" />
	<input type="hidden" name="s_codeAll" value="<%=codeSb%>" id="s_codeAll" />
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_downexcel" 			id="btn_downexcel">Down Excel</button>		
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
		
	</div>
	<!-- page_title_area(E) -->
	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100"/>				
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>Billing Type Code</th>
					<td><select name="s_billing_case_cd" id="s_billing_case_cd" style="width:100px;"></select>
					</td>
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
</form>