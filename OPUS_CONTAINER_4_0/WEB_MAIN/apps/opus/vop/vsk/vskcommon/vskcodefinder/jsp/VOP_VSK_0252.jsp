<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0252.jsp
*@FileTitle  : Other(s) Code Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0252Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<% 
	VopVsk0252Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");
	
	String codeType = null;
	String codeValue = null;
	String title = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0252Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		codeType = request.getParameter("code_type");
		codeType = codeType==null?"":codeType;
		
		codeValue = request.getParameter("code_value");
		codeValue = codeValue==null?"":codeValue;

		title = request.getParameter("title");
		title = title==null?"Other(s)":title;
		
	}catch(Exception e) {
		out.println(e.toString());
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

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span><%=StringUtil.xssFilter(title)%> Code Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- inquiry_area(S) -->
		<div class="opus_design_inquiry wFit" >   <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="65" />
					<col width="220" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Code Type</th>
						<td colspan="3" style="padding-left:2">
						<select style="width:210px;" name="grd_nm" tabIndex="1">
							<option value="CD00717" <%="CD00717".equals(codeType)?"selected":"" %>>Lane Service Type</option>
							<option value="CD01827" <%="CD00827".equals(codeType)?"selected":"" %>>Voyage Type</option>
							<option value="CD01819" <%="CD01819".equals(codeType)?"selected":"" %>>Phase In/Out Reason</option>
							<option value="CD01830" <%="CD01830".equals(codeType)?"selected":"" %>>Delay Reason</option>
							<option value="CD0XXXX" <%="CD0XXXX".equals(codeType)?"selected":"" %>>Owner(Carrier)</option>
						</select>
						</td>
						<td></td>
					</tr>

				</tbody>
			</table>
			<table> 
				<colgroup>
					<col width="65" />
					<col width="140" />
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Code</th>
						<td><input type="text" style="width:100px;ime-mode:disabled;text-align:left" class="input" name="code" id="code" dataformat="engup"  value="<%=StringUtil.xssFilter(codeValue)%>"  tabIndex="2"></td>
						<th>Code Name</th>
						<td><input type="text" style="width:100%;ime-mode:disabled;text-align:left" class="input" name="name" maxlength="50" tabIndex="3"></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- inquiry_area(E) -->
	</div>
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<!-- opus_grid_design_btn(S) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<!-- opus_grid_design_btn(E) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>