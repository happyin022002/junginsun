<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0123.jps
*@FileTitle  :  Invoice Sheet Set
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0123Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0123Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StatusInquiry.PerformanceInquiry");
	
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	
/*
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0123Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
*/
	String ofc_cd = null;

	String readOnlyYn = "";
	String s_state = "";
	readOnlyYn = JSPUtil.getNull( request.getParameter("ReadOnlyYn") );
	s_state = JSPUtil.getNull( request.getParameter("s_state") );
	if ( !readOnlyYn.equals("N") ) {
		ofc_cd = account.getOfc_cd();
	} else {
		ofc_cd = JSPUtil.getNull( request.getParameter("s_sheet_set_ofc_cd") );
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="ReadOnlyYn" value="<%=readOnlyYn%>" id="ReadOnlyYn" />
<input type="hidden" name="iPage" id="iPage" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<% if (s_state.equals("Y")){ %>
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title">JO TPB Invoice Setting</span></button></h2>
		<!-- page_title(E) -->
	<%} else{ %>
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	<% } %>
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button>
		<button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button>		
		<% if ( !readOnlyYn.equals("N") ) { %>
			<button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button>
		<% } %>
			<button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>	
			
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
	<% if (s_state.equals("Y")){ %>
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Office</th>
					<td><input type="text" style="width:55px;" name="s_inv_iss_ofc_cd" id="s_inv_iss_ofc_cd" readonly value=<%=ofc_cd%>></td>
					<th>VAT Rate</th>
					<td><input type="text" style="width:55px;" name="s_vat_xch_rt" id="s_vat_xch_rt" maxlength="15" dir="rtl"> %</td>
				</tr>
				<tr>
					<th>Company Name</th>
					<td><input type="text" style="width:250px;" value="<%=ConstantMgr.getCompanyName()%> CO., LTD" onblur="ComChkLenByByte(this,50,'Company Name')" dataformat="engup" otherchar=" &-,."  name="s_co_nm" id="s_co_nm" maxlength="50"></td>
					<th>"Bill To" Location</th>
					<td><%=JSPUtil.getCodeCombo("s_bil_to_loc_div_cd", "", "style='width:71'", "CD00871", 0, "001: :&lt;&lt;Select&gt;&gt;")%></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>					
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Office Address</th>
					<td><input type="text" style="width:459px;" onblur="ComChkLenByByte(this,200,'Office Address')" name="s_ofc_addr" id="s_ofc_addr" maxlength="200"></td></tr>
				<tr>
					<th>Tel No.</th>
					<td><input type="text" style="width:459px;" name="s_ofc_phn_no" id="s_ofc_phn_no" dataformat="engup" maxlength="20"></td></tr>
				<tr>
					<th>Fax No.</th>
					<td><input type="text" style="width:459px;" name="s_ofc_fax_no" id="s_ofc_fax_no" dataformat="engup" maxlength="20"></td></tr>
				<tr>
					<td class="line_bluedot" colspan="2"></td>
				</tr>
			</table>
	
			<table>
				<colgroup>
					<col width="100"/>					
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Remark 1</th>
					<td><textarea type="text" style="width:459px;resize:none" rows="5" name="s_inv_rmk1" onblur="ComChkLenByByte(this,4000,'Remark 1')"></textarea></td>
				</tr>
				<tr>
					<th>Remark 2</th>
					<td><textarea type="text" style="width:459px;resize:none" rows="10" name="s_inv_rmk2" onblur="ComChkLenByByte(this,4000,'Remark 2')"></textarea></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	<%} else{ %>
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Office</th>
					<td><input type="text" style="width:55px;" name="s_inv_iss_ofc_cd" id="s_inv_iss_ofc_cd" readonly value=<%=ofc_cd%>></td>
					<th>VAT Rate</th>
					<td><input type="text" style="width:55px;" name="s_vat_xch_rt" id="s_vat_xch_rt" dataformat="engup" maxlength="15" dir="rtl"> %</td>
				</tr>
				<tr>
					<th>Company Name</th>
					<td><input type="text" style="width:250px;" value="<%=ConstantMgr.getCompanyName()%> CO., LTD" onblur="ComChkLenByByte(this,50,'Company Name')" dataformat="engup" otherchar=" &-,." name="s_co_nm" maxlength="50"></td>
					<th>"Bill To" Location</th>
					<td><%=JSPUtil.getCodeCombo("s_bil_to_loc_div_cd", "", "style='width:71'", "CD00871", 0, "001: :&lt;&lt;Select&gt;&gt;")%></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>					
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Office Address</th>
					<td><input type="text" style="width:459px;" onblur="ComChkLenByByte(this,200,'Office Address')" name="s_ofc_addr" id="s_ofc_addr" maxlength="200"></td></tr>
				<tr>
					<th>Tel No.</th>
					<td><input type="text" style="width:459px;" name="s_ofc_phn_no" id="s_ofc_phn_no" maxlength="20" dataformat="engup"></td></tr>
				<tr>
					<th>Fax No.</th>
					<td><input type="text" style="width:459px;" name="s_ofc_fax_no" id="s_ofc_fax_no" maxlength="20" dataformat="engup"></td></tr>
				<tr>
					<td class="line_bluedot" colspan="2"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100"/>				
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Remark 1</th>
					<td><textarea type="text" style="width:459px; resize:none" rows="5" name="s_inv_rmk1" id="s_inv_rmk1" onblur="ComChkLenByByte(this,4000,'Remark 1')"></textarea></td>
				</tr>
				<tr>
					<th>Remark 2</th>
					<td><textarea type="text" style="width:459px;resize:none" rows="10" name="s_inv_rmk2" id="s_inv_rmk2" onblur="ComChkLenByByte(this,4000,'Remark 2')"></textarea></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	<% } %>
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>