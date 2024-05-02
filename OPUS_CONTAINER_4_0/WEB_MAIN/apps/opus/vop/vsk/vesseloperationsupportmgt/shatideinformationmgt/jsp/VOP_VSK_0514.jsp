<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0514.jsp
*@FileTitle  : SHA Tide Information Inquiry
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
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.event.VopVsk0514Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0514Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.SHATideInformationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0514Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<input type="hidden" id="nowYear" name="nowYear" style="width:50;" class="input2" value="<%=DateTime.getYear()%>">
<input type="hidden" id="nowMonth" name="nowMonth" style="width:50;" class="input2" value="<%=(DateTime.getMonth()<10)?"0"+DateTime.getMonth():DateTime.getMonth()%>">
				

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
        --><button type="button" class="btn_normal" name="btn_Excel" id="btn_Excel">Down Excel</button>
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
				<col width="4%" />
				<col width="8%" />
				<col width="8%" />
				<col width="8%" />
				<col width="2%" />
				<col width="2%" />
				<col width="8%" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Port Code</th>
					<td><input type="text" style="width:70;text-align:center;" class="input2" name="loc_cd" dataformat="engup" style="ime-mode:disabled" maxlength="5" value="CNSHA" readOnly></td>
					<th>Year</th>
					<td><script language="javascript">ComComboObject('tide_yr', 1, 80, 1);</script></td>
					<th>Month</th>
					<td><script language="javascript">ComComboObject('tide_mon', 1, 50, 1);</script></td>
					<th>Updated Date</th>
					<td>
						<input type="text" name="upd_dt" style="width:115;text-align:center;" class="input2" readOnly>
						<input type="text" name="upd_usr_id" style="width:80;" class="input2" readOnly>
					</td>	
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	<!-- inquiry_area(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid" id="startinfo">  
	<script type="text/javascript">ComSheetObject('sheet1');</script>

</div>
<!-- opus_design_grid(E) -->

<!-- TAB [ Gang Structure ] (E) -->
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script type="text/javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!-- TAB [ Gang Structure ] (E) -->	
</div>
</form>