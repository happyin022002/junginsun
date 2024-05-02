<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0058.jsp
*@FileTitle  : Priority Change
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0058Event"%>
<%
	EsdPrd0058Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								  //count of DB resultSET list
	

	try {
		event = (EsdPrd0058Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="openSheetRow" id="openSheetRow" />
<input type="hidden" name="routSeq" id="routSeq" />
<input type="hidden" name="r_inbound" id="r_inbound" />
<input type="hidden" name="rBtnIrgCd" id="rBtnIrgCd" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Priority</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_apply" id="btn_apply">Apply</button>	
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="150"/>
					<col width="80"/>
					<col width="140"/>
					<col width="100"/>
					<col width="*"/>
			    </colgroup>
			    <tbody>
					<tr>
		                <th>From (Location, TMNL)</th>
		                <td><input name="i_org_cd" id="i_org_cd" type="text" required caption="ORG LOC" maxlength="7" tabIndex="1" style="width:70" disabled=false;></td>
		                <th>To (Location, TMNL)</th>
		                <td><input name="i_dest_cd" id="i_dest_cd" type="text" required caption="DEST LOC" maxlength="7" tabIndex="2" style="width:70" disabled=false;></td>
						<td>
		                	<input type="hidden" name="r_btn_nod_ty_cd" id="r_btn_nod_ty_cd" value="Y">
			                <input type="radio" name='nod_tp_cd1' id="radio_nod_tp_cd1" value='Y' class="trans" disabled=false;><label for="radio_nod_tp_cd1">Yard</label>
			                <input type="radio" name='nod_tp_cd1' id="radio_nod_tp_cd2" value='Z' class="trans" disabled=false;><label for="radio_nod_tp_cd2">Zone</label>
		                </td>
		            </tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid" id="mainTable" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<SCRIPT type="text/javascript">
<!--

	  /*
		displaying values form form input
	  */
	  with(document.form)
	  {
		<%
		if(event != null){

			   String org_cd      =JSPUtil.getNull(event.getInlandRouteUSVO().getIOrgCd());
			   String dest_cd     =JSPUtil.getNull(event.getInlandRouteUSVO().getIDestCd());
			   String rInbound    =JSPUtil.getNull(event.getInlandRouteUSVO().getRInbound());
			   String rBtnIrgCd   =JSPUtil.getNull(event.getInlandRouteUSVO().getRBtnIrgCd());
			   String rBtnNodTyCd   =JSPUtil.getNull(event.getInlandRouteUSVO().getRBtnNodTyCd());
			   String openSheetRow  =JSPUtil.getNull(event.getInlandRouteUSVO().getISelectRow());
			   String routSeq  =JSPUtil.getNull(event.getInlandRouteUSVO().getRoutSeq());
			 	
			   //org_cd  = org_cd.substring(0,5);
		       dest_cd = dest_cd.substring(0,5);
		      
			   
		%>
		eval("i_org_cd" ).value  = "<%= org_cd	 %>";
		eval("i_dest_cd" ).value = "<%= dest_cd	 %>";
		eval("r_inbound" ).value  = "<%= rInbound	 %>";
		eval("rBtnIrgCd" ).value = "<%= rBtnIrgCd	 %>";
		eval("r_btn_nod_ty_cd" ).value  = "<%= rBtnNodTyCd	 %>";
		eval("openSheetRow" ).value = "<%= openSheetRow	 %>";
		eval("routSeq" ).value = "<%= routSeq	 %>";
		<%
		if(rBtnNodTyCd.equals("Y")) {
		%>
			eval("nod_tp_cd1[0]" ).checked = true;
		<%
		} else if(rBtnNodTyCd.equals("Z")) {
		%>
			eval("nod_tp_cd1[1]" ).checked = true;
		<%
		}
		%>
		<% } %>
	   }
-->
</SCRIPT>