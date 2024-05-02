<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0977.jsp
*@FileTitle  :  ESM_BKG_0977
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0977Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0977Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");
	String pageGubun = "";

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0977Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		pageGubun = StringUtil.xssFilter(request.getParameter("pageGubun")) == null ? "" : StringUtil.xssFilter(request.getParameter("pageGubun"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<input type="hidden" name="pageGubun" value="<%=pageGubun%>" id="pageGubun" />
		
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Belgian Codes for Type of special UN numbers</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
		
			     <button type="button" class="btn_accent" name="btn1_Retrieve" id="btn_Retrieve">Retrieve</button> 
			     <button type="button" class="btn_normal" name="btn1_Save" id="btn1_Save">Save</button> 
			     <% if(!"MAIN".equals(pageGubun)) { %>
			     <button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button> 
			     <button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button>
			     <% } %>
	    </div>
		 <!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			 <table> 
		         <colgroup>
		             <col width="60"> 
		             <col width="100">
		             <col width="120">
		             <col width="*">
		         </colgroup>
		         <tbody>
		             <tr>
						<th>UN Numbers</th>
						<td>
							<input type="text" class="input" style="width:100px;" value="" name="imdg_un_no" id="imdg_un_no" dataformat="engup" maxlength="4" caption="UN Numbers">
						</td>
						<th>Description</th>
						<td>
						    <%=JSPUtil.getCodeCombo("spcl_id_desc", "", "style=width:200 caption='Description'", "CD20048", 1, "")%>
							<script>ComAddBeginComboItem(form.spcl_id_desc,"","");ComSetObjValue(form.spcl_id_desc,'' );</script> 
						</td>
					</tr>
				</tbody>
			</table>
		</div> 
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >		
			<div class="opus_design_btn">
				<button class="btn_normal" type="button"  name="btn2_RowAdd" id="btn2_RowAdd">Row Add</button><!-- 
			 --><button class="btn_normal" type="button"  name="btn2_Delete" id="btn2_Delete">Delete</button>
			</div>		
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- opus_design_grid(E) -->
		</div>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>

</form>