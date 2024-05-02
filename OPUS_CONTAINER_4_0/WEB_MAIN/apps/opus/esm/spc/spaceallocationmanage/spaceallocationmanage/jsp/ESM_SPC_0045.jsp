<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0045.js
*@FileTitle  : Bottleneck Check  
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/06/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Calendar"%>

<%
	EsmSpc0045Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpaceAllocationManage.SpaceAllocationManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
		
		<%
		Calendar c = Calendar.getInstance();
		
		int year = c.get(Calendar.YEAR);
		String text_year = year + "";
		
		int week = c.get(Calendar.WEEK_OF_YEAR) - 1;
		String text_week = "";
		
		if (week < 10) {
			text_week = "0" + week;
		} else {
			text_week = week + "";
		}
		%>
		
		<%
        if(event != null){ 
        	
            String year1 = event.getConditionVO().getYear1();
            String week1 = event.getConditionVO().getWeek1();
            String lane  = event.getConditionVO().getLane();
            String bound = event.getConditionVO().getBound();
            String vvd   = event.getConditionVO().getVvd();
            
            if(year1 == ""){
            	year1 = text_year;
            }
            if(week1 == ""){
            	week1 = text_week;
            }
        %>
            var formObject = document.form;
	        formObject.year1.value = "<%=year1%>";
	        formObject.week1.value = "<%=week1%>";
	        lane.SetSelectCode("<%=lane%>");
	        formObject.bound.value = "<%=bound%>";
        	getVVD("<%=vvd%>");
	        formObject.vvd.value   = "<%=vvd%>";
			changeVVD();
			
	        if("<%=year1%>"!="" && "<%=week1%>"!="" && "<%=lane%>"!="" && "<%=bound%>"!="" && "<%=vvd%>"!=""){
	        	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	        }
        <% } %>
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<% if("Y".equals(JSPUtil.getNull(request.getParameter("popupcheck")))){ %>
	<h2 class="page_title"><span>Bottleneck Check</span></h2>
	<% } else { %>
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<% } %>
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<button class="btn_normal" type="button" name="btn_new" id="btn_new">New</button>
			<button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel" >Down Excel</button>
			</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<%  if("Y".equals(JSPUtil.getNull(request.getParameter("popupcheck")))){
		
	} else { %>
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<% } %>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="150"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Start Week</th>
					<td><select class="input1" name="year1"  id="year1" style="width:80px;" onChange="getVVD('');"></select><!--
						--><select class="input1" name="week1" id="week1" style="width:60px;" onChange="getVVD('');"></select></td>
					<th>Lane</th>
					<td><script type="text/javascript">ComComboObject("lane", 4, 90, 0, 1, 2);</script></td>
					<th>Bound</th>
					<td><select class="input1" name="bound"  id="bound" style="width:80px;" onChange="getVVD('');"></select></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><select class="input1" style="width: 100px;" name="vvd" id="vvd" onChange="changeVVD(this);"><option value=""></option></select></td>
					<th>Relative VVD</th>
					<td> <input type="text" name="re_vvd" size="14" readonly id="re_vvd" /> </td>
				</tr>					
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tr> 
					<td><input type="radio" value="F" name="dataSelect" id="dataSelect"	class="trans" onclick="changeTitle2();" checked>&nbsp;&nbsp;<b>F'cast + BKG</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="B" name="dataSelect" id="dataSelect" class="trans" onclick="changeTitle2();">&nbsp;&nbsp;<b>BKG</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="A" name="dataSelect" id="dataSelect" class="trans" onclick="changeTitle2();">&nbsp;&nbsp;<b>Alloc. +BKG</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="M" name="dataSelect" id="dataSelect" class="trans" onclick="changeTitle2();">&nbsp;&nbsp;<b>Alloc</b>
					</td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tr> 
					<td><input type="radio" value="F" name="dataSelect1" id="dataSelect1"	class="trans" onclick="changeTitle1();" checked>&nbsp;&nbsp;<b>F'cast + BKG</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="B" name="dataSelect1" id="dataSelect1" class="trans" onclick="changeTitle1();">&nbsp;&nbsp;<b>BKG</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="A" name="dataSelect1" id="dataSelect1" class="trans" onclick="changeTitle1();">&nbsp;&nbsp;<b>Alloc. +BKG</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="M" name="dataSelect1" id="dataSelect1" class="trans" onclick="changeTitle1();">&nbsp;&nbsp;<b>Alloc</b>
					</td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
</form>
