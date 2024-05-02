<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SPE_0009.jsp
*@FileTitle  : EvaluationGroupTargetManage
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.event.EsdSpe0009Event"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchVndrSeqVO"%>
<%@ page import="com.clt.framework.core.layer.event.EventResponse"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsdSpe0009Event  event = null;							//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;						//Error from server
	DBRowSet rowSet	  = null;							   	//DB ResultSet
	DBRowSet otherRowSet = null;
	String strErrMsg = "";								 	//Error message
	int rowCount	 = 0;								  	//The count of DB ResultSet list
	int otherRowCount = 0;
	GeneralEventResponse eventResponse = null;		
	String vndr_seq = "";
	String vndr_abbr_nm ="";
	String yd_cd = "";
	List< SearchVndrSeqVO > list = null;
	SearchVndrSeqVO vo = null;
	try {
		event = (EsdSpe0009Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				list = eventResponse.getRsVoList();		
				rowCount=list.size();
			}
		}
	} catch(Exception e) {
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
<input type="hidden" name="yd_nm" id="yd_nm" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
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
				<col width="70" />				
				<col width="100" />				
				<col width="170" />				
				<col width="120" />				
				<col width="170" />				
				<col width="120" />				
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Terminal</th>
					<td><input type="text" name="yd_cd" class="input1" style="width:90px;" value="<%=yd_cd %>" id="yd_cd" /><button type="button" id="btn_yard" name="btn_yard" class="input_seach_btn"></button></td>
					<th>Service Provider Code</th>
					<td><input type="text" name="vndr_seq" class="input1" dataformat="engup" style="width:90px;" value="<%=vndr_seq %>" id="vndr_seq" /><button type="button" id="btn_sp" name="btn_sp" class="input_seach_btn"></button></td>
					<th>Service Provider Name</th>
					<td><input type="text" name="vndr_abbr_nm" style="width:150px;" value="<%=vndr_abbr_nm %>" readonly class="input2" id="vndr_abbr_nm" /> </td>
					<th>Year</th>
					<%
						Calendar cal = Calendar.getInstance();
						java.text.DateFormat df = new SimpleDateFormat("yyyy");
						String year = df.format(cal.getTime());
					%>
					<td><!-- 
						--><select name="ev_yr" style="width:70" class="input1"><!-- 
						--><option value="2007" <% if("2007".equals(year)) out.println("selected"); %>>2007</option><!-- 
						--><option value="2008" <% if("2008".equals(year)) out.println("selected"); %>>2008</option><!-- 
						--><option value="2009" <% if("2009".equals(year)) out.println("selected"); %>>2009</option><!-- 
						--><option value="2010" <% if("2010".equals(year)) out.println("selected"); %>>2010</option><!-- 
						--><option value="2011" <% if("2011".equals(year)) out.println("selected"); %>>2011</option><!-- 
						--><option value="2012" <% if("2012".equals(year)) out.println("selected"); %>>2012</option><!-- 
						--><option value="2013" <% if("2013".equals(year)) out.println("selected"); %>>2013</option><!-- 
						--><option value="2014" <% if("2014".equals(year)) out.println("selected"); %>>2014</option><!-- 
						--><option value="2015" <% if("2015".equals(year)) out.println("selected"); %>>2015</option><!-- 
						--><option value="2016" <% if("2016".equals(year)) out.println("selected"); %>>2016</option><!-- 
						--><option value="2017" <% if("2017".equals(year)) out.println("selected"); %>>2017</option><!-- 
						--></select><!-- 
					--></td>
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
			<button class="btn_accent" type="button" id="btng_delete" name="btng_delete">Delete</button><!--
			--><button class="btn_normal" type="button" id="btng_save" name="btng_save">Save</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>