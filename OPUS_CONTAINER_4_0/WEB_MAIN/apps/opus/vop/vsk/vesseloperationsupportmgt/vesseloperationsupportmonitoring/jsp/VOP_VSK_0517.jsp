<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0517.jsp
*@FileTitle  : VOSI Update Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.event.VopVsk0517Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>
<%
	VopVsk0517Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.VesselOperationSupportMonitoring");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0517Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
	</div>
	<!-- opus_design_btn(E) -->	
		
	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E)-->
</div>
<!-- page_title_area(E) -->

	<!-- inquiry_area(S) -->
	<div class="wrap_search">
	<div class="opus_design_inquiry">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="50" />
				<col width="250" />
				<col width="100" />
				<col width="250" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Year</th>
					<td>
					<input type="hidden" name="nowDate" style="width:50;" class="input2" value="<%=DateTime.getFormatDate(new Date(),"yyyy")%>">
					<input type="text" name="sel_date" style="width:40px;text-align:center;" class="input1" dataformat="num" maxlength="4" caption="Date" value="<%=DateTime.getFormatDate(new Date(),"yyyy")%>"><!--<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">--><!--
                    --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
					</td>
					<th>Port Code</th>
					<td><input type="text" name="loc_cd" style="width:60px;text-align:center;" class="input" dataformat="engup"  style="ime-mode:disabled" maxlength="5" caption="Port Code"><!--<img src="img/btns_search.gif" width="19" height="20" name="btn_loc_cd" alt="" border="0" align="absmiddle" class="cursor">--><!--
                    --><button type="button" class="input_seach_btn"  name="btn_loc_cd" id="btn_loc_cd"></button></td>
					<th>RHQ</th>
					<td><script language="javascript">ComComboObject('rhq', 1, 80, 1, 1);</script></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->
	</div>
	
	<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
			<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Monitoring_Port" id="btn_Monitoring_Port">Monitoring Port</button>
				<button type="button" class="btn_accent" name="btn_Excel" id="btn_Excel">Down Excel</button>
			</div>
			<!-- opus_grid_btn(E) -->
			
		
		   <script language="javascript">ComSheetObject('sheet1');</script>
			<!-- opus_grid_right(S)-->
				<span class="grid_option_right">Unit(%)</span>
			<!-- opus_grid_right(E)-->
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	</div>
	
	<div class="opus_design_tab" style="display:none">
		<script language="javascript">ComTabObject('t10sheet1')</script>
	</div>
</form>