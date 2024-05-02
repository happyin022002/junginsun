<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0001.jsp
*@FileTitle  : COP Main Search 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page import="com.clt.framework.component.util.JSPUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.clt.apps.opus.esd.sce.copreport.cophsitory.event.EsdSce0071Event"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;


	EsdSce0071Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//
	String strErrMsg = "";						//
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String userId		= "";
	String userNm		= "";

	
	try {

			event = (EsdSce0071Event)request.getAttribute("Event");
			serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

			if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}

			// 
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		}catch(Exception e) {
			out.println(e.toString());
		}	
%>

<%
String mainPage ="";
String szCOPNo = request.getParameter( "cop_no");
mainPage  = request.getParameter( "mainPage");


%>

<script type="text/javascript">

    function setupPage(){
        loadPage();
        <% if( szCOPNo!= null && szCOPNo.length() > 0 ) {%>
	       	document.getElementById ("cop_no").value = "<%=szCOPNo%>";
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		<%}%>
    }

</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="<%=pageRows%>" id="pagerows" />
<input type="hidden" name="page_no" value="1" id="page_no" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">

	<%if ("false".equals(mainPage)){%>
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	<%}else{%>
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	<%}%>
	</div>
	<!-- opus_design_btn(E) -->
   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <table>
	        <tbody>
	        <colgroup>
				<col width="40" />				
				<col width="160" />				
				<col width="40" />				
				<col width="140" />				
				<col width="40" />	
				<col width="260" />				
				<col width="40" />		
				<col width="*" />				
		   </colgroup> 
				<tr>
					<th>Booking No. </th>
					<td><input name="bkg_no" type="text" style="width:120 ; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
					<th>B/L No.</th>
					<td><input name="bl_no" type="text" style="width:110px ; text-transform:uppercase;"  Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();'></td>
					<th>CNTR No.</th>
					<td><input name="cntr_no" id="cntr_no" type="text" value="" maxlength="11" style="width:100px ; text-transform:uppercase;" Onkeydown="onEnterKey(this)" onBlur='javascript:this.value=this.value.toUpperCase();'>
					    <input name="cntr_no_nonbit" type="hidden" style="width:100px ; text-transform:uppercase;" Onkeydown="onEnterKey(this)" onBlur='javascript:this.value=this.value.toUpperCase();' onChange="CheckDigitSplit(this,'cntr_no_split', 'cntr_no')" onKeyUp="CheckDigitSplit(this, 'cntr_no_split', 'cntr_no')">
					    <input id ="cntr_no_split" type="hidden" style="width:22px" maxlength="2" readonly></td>
					<th>COP No.</th>
					<td><input name="cop_no" id="cop_no" type="text" style="width:110px; text-transform:uppercase;" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();'></td>
				</tr>
			</tbody>
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
	<!-- page(E) -->
</div>
</form>