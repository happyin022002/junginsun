<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0933.jsp
*@FileTitle  : Multi-stop Location Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.common.multistoplocationinquiry.event.EsdTrs0933Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
	EsdTrs0933Event  event = null;
	Exception serverException   = null;			
	DBRowSet rowSet	  = null;
	String strErrMsg = "";								 
	int rowCount	 = 0;								 


	String bkgnumber  = "";
	String blnumber   = "";
	String cntrnumber = "";
	String tpsznumber = "";
	String troseqnumber = "";

	bkgnumber = ((request.getParameter("bkgnumber")==null )?"":request.getParameter("bkgnumber"));
	blnumber = ((request.getParameter("blnumber")==null )?"":request.getParameter("blnumber"));
	cntrnumber = ((request.getParameter("cntrnumber")==null )?"":request.getParameter("cntrnumber"));
	tpsznumber = ((request.getParameter("tpsznumber")==null )?"":request.getParameter("tpsznumber"));
	troseqnumber = ((request.getParameter("troseqnumber")==null )?"":request.getParameter("troseqnumber"));
	try {
		event = (EsdTrs0933Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Multi-stop Location Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="30" />
					<col width="110" />
					<col width="50" />
					<col width="110" />
					<col width="100" />
					<col width="110" />
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Booking No.</th>
						<td><input name="bkgnumber" type="text" style="width:100px;" value="<%=StringUtil.xssFilter(bkgnumber)%>" readonly class="input2" title="This inputbox cant't write" id="bkgnumber" /> </td>
						<th>B/L No.</th>
						<td><input name="blnumber" type="text" style="width:100px;" value="<%=StringUtil.xssFilter(blnumber)%>" readonly class="input2" title="This inputbox cant't write" id="blnumber" /> </td>
						<th>Container No.</th>
						<td><input name="cntrnumber" type="text" style="width:100px;" value="<%=StringUtil.xssFilter(cntrnumber)%>" readonly class="input2" title="This inputbox cant't write" id="cntrnumber" /> </td>
						<th>Type/Size</th>
						<td><input name="tpsznumber" type="text" style="width:60px;" value="<%=StringUtil.xssFilter(tpsznumber)%>" readonly class="input2" title="This inputbox cant't write" id="tpsznumber" /><!--  
						 	--><input name="troseqnumber" type="hidden" style="width:60px;" value="<%=StringUtil.xssFilter(troseqnumber)%>" readonly="" class="input2" title="This inputbox cant't write" id="troseqnumber" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result" style="overflow:hidden">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>


</form>