<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0110.jsp
*@FileTitle  : (RCC/LCC/ECC/SCC) Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.popup.event.EqYardOrzEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EqYardOrzEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Setting error at server side.
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.common.popup");
	
	String dist  = JSPUtil.getNull(request.getParameter("dist"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EqYardOrzEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// The data obtained from the server side on load.
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

<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<input    type="hidden" name="f_slt_idx" value="0">
<input    type="hidden" name="dist" value="<%=dist%>">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>
			<%if (dist.equals("rcc")){ %>
				RCC Inquiry
			<%}else if (dist.equals("lcc")){ %>
				LCC Inquiry
			<%}else if (dist.equals("ecc")){ %>
				ECC Inquiry>
			<%}else if (dist.equals("scc")){ %>
				SCC Inquiry
			<% }%>
		</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->

    <!-- wrap_search(S) -->	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
				<%if (dist.equals("rcc")){ %>

				<%}else if (dist.equals("lcc")){ %>
					<table> 
						<colgroup>
							<col width="30" />
							<col width="60" />
							<col width="30" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th>RCC</th>
								<td><input name="rcc_txt" type="text" style="width:53px; text-transform:uppercase;" value="" onkeyup="ComChkObjValid(this); this.value.toUpperCase()" id="rcc_txt" /> </td>
								<th>Country</th>
								<td><input name="cnt_txt" type="text" style="width:53px; text-transform:uppercase;" value="" onkeyup="ComChkObjValid(this);" onblur="ComChkObjValid(this); " id="cnt_txt" /> </td>
							</tr>
						</tbody>
					</table>
				<%}else if (dist.equals("ecc")){ %>
					<table> 
						<colgroup>
							<col width="30" />
							<col width="60" />
							<col width="30" />
							<col width="60" />
							<col width="30" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th>RCC</th>
								<td><input name="rcc_txt" type="text" style="width:53px;" value="" onkeyup="ComChkObjValid(this); this.value.toUpperCase()" id="rcc_txt" /> </td>
								<th>LCC</th>
								<td><input name="lcc_txt" type="text" style="width:53px;" value="" onkeyup="ComChkObjValid(this); this.value.toUpperCase()" id="lcc_txt" /> </td>
								<th>Country</th>
								<td><input name="cnt_txt" type="text" style="width:53px; text-transform:uppercase;" value="" onkeyup="ComChkObjValid(this);" onblur="ComChkObjValid(this); " id="cnt_txt" /> </td>
							</tr>
						</tbody>
					</table>
				<%}else if (dist.equals("scc")){ %>
					<table> 
						<colgroup>
							<col width="30" />
							<col width="60" />
							<col width="30" />
							<col width="60" />
							<col width="30" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th>RCC</th>
								<td><input name="rcc_txt" id="rcc_txt" type="text" style="width:53px;" value="" onkeyup="ComChkObjValid(this); this.value.toUpperCase()" /> </td>
								<th>LCC</th>
								<td><input name="lcc_txt" id="lcc_txt" type="text" style="width:53px;" value="" onkeyup="ComChkObjValid(this); this.value.toUpperCase()" /> </td>
								<th>ECC</th>
								<td><input name="ecc_txt" id="ecc_txt" type="text" style="width:53px;" value="" onkeyup="ComChkObjValid(this); this.value.toUpperCase()" /> </td>
								<th>Country</th>
								<td><input name="cnt_txt" id="cnt_txt" type="text" style="width:53px; text-transform:uppercase;" value="" onkeyup="ComChkObjValid(this);" onblur="ComChkObjValid(this); " /> </td>
							</tr>
						</tbody>
					</table>
				<% } %>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->	
	
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid (S) -->
		<div class="opus_design_grid" id="mainTable">
			<script language="javascript">ComSheetObject('sheet');</script>
		</div>
		<!-- opus_design_grid (E) -->
	</div>
	<!-- wrap_result(E) -->
</form>