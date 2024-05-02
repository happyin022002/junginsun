<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0082.jsp
*@FileTitle  : L/F Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0082Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0082Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0082Event)request.getAttribute("Event");
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span id="title"></span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new" alt="Alt+N">New</button><!--
		--><button class="btn_normal" type="button"  name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button class="btn_normal" type="button" name="btn_downexcel_data" id="btn_downexcel">Down Excel (Data)</button><!--
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
		<table id="zoomarea">
			<colgroup>
				<col width="70" />				
				<col width="150" />				
				<col width="70" />				
				<col width="90"/>				
				<col width="90" />	
				<col width="90"/>	
				<col width="70"/>	
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Start Week</th>
					<td><select class="input1" name="year" id="year" style="width:65px;" onchange="checkWeek();"></select><!-- 
					 --><select class="input1" name="week" id="week" style="width:52px;"></select></td>
					<th>Duration</th>
					<td>
						<select class="input1" name="duration" size="1">
						<%	for(int i=1; i<11; i++){ %>
								<option value="<%=i%>"><%=i%></option>
						<%	} %>
						</select>
					</td>
					<th>Trade</th>
					<td><script language="JavaScript">ComComboObject("trade", 2, 60, 0, 1);</script></td>
					<th>Sub Trade</th>
					<td><script language="JavaScript">ComComboObject("subtrade", 3, 60, 0, 0);</script></td>
				</tr>
				<tr>
					<th>RHQ</th>
					<td> 
						<select class="input1" name="rhq" id="rhq">
							<option value=""></option>
							<option value="SHAAS">SHAAS, SINWA</option>
							<option value="NYCNA">NYCNA</option>
							<option value="HAMUR">HAMUR</option>
						</select>
					</td>
	
					<th>Bound</th>
					<td colspan="3" ><select name="bound" id="bound"  style="width:54px;"></select></td>
	
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<table id="sheetControlDiv" style="">
			<tr>
				<td align="right" class="gray"><span>Unit : TEU</span> &nbsp;<!-- 
				 --><button type="button" name="maxi" id="maxi" class="btn_up" sheetId="sheet1" onclick="toggleSheetSize('zoomarea');" type="N" alt='Alt+↑'></button>
				</td>
			</tr>
			 <tr><td height="5"></td></tr>
		</table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none;">
		<table id="sheetControlDiv" style="">
			<tr><td align="right" class="gray"><span>Unit : TEU</span> &nbsp;<!-- 
				 --><button type="button" name="maxi" id="maxi" class="btn_up"  sheetId="sheet2" onclick="toggleSheetSize('zoomarea');" type="N"   alt='Alt+↑'></button>
				 </td>
			 </tr>
			 <tr><td height="5"></td></tr>
		</table>
						
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- TAB [ Port Log ] (S) -->
	<div id="tabLayer" style="display:none">
	
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />				
					<col width="100" />				
					<col width="70" />				
					<col width="100" />				
					<col width="100" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->	
	</div>
	<!-- TAB [ Port Log ] (E) -->
</div>

</form>
