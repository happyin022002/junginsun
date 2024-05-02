<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0007.jsp
*@FileTitle  : Link  List Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.event.EsdPrd0007Event"%>

<%
	EsdPrd0007Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	String optStr="|000010: : ";
	try {
		event = (EsdPrd0007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("rail_crr_tp_cd", "01", "CD00287", 0, optStr)%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>

<form method="post" name="form" id="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="i_page" id="i_page" />
<input type="hidden" name="row" id="row" />
<input type="hidden" name="col" id="col" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Link  List Inquiry</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal"  type="button" name="btn_save" id="btn_save">Save</button><!--
		--><button class="btn_normal"  type="button" name="btn_ok" id="btn_ok">Ok</button><!--
		--><button class="btn_normal"  type="button" name="btn_close" id="btn_close">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

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
				<col width="60" />				
				<col width="120" />				
				<col width="70" />				
				<col width="120" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Origin</th>
					<td><input class="input1" name="i_org_cd" maxlength="7" required="" caption="Origin" type="text" style="width:110px;" value="" dataformat="engup" id="i_org_cd" />  </td>
					<th>Destination</th>
					<td><input class="input1" name="i_dest_cd" maxlength="7" required="" caption="Destination" type="text" style="width:110px;" value="" dataformat="engup" id="i_dest_cd" /><button type="button" id="btn_dest_loc" name="btn_dest_loc" class="input_seach_btn"></button></td>
					<td> </td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_normal" name="btng_rowadd" id="btng_rowadd" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btng_rowcopy" id="btng_rowcopy" type="button">Row Copy</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>


<script type="text/javascript">
<!--

	  /*
		displaying values from form input
	  */
	  with(document.form)
	  {
		<%
		if(event != null){
			   String org_cd   = event.getSearchInlandLinkManageListVO().getIOrgCd();
			   String dest_cd   = event.getSearchInlandLinkManageListVO().getIDestCd();
			   String row   =  event.getSearchInlandLinkManageListVO().getRow();
			   String col   = event.getSearchInlandLinkManageListVO().getCol();
		%>
		eval("i_org_cd" ).value = "<%= org_cd	 %>";
		eval("i_dest_cd" ).value = "<%= dest_cd	 %>";
		eval("row" ).value = "<%= row	 %>";
		eval("col" ).value = "<%= col	 %>";
		<% } %>
	   }
-->
</script>