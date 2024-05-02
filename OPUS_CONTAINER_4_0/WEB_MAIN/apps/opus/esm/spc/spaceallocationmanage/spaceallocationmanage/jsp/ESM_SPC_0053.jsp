<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 :  ESM_SPC_0053.jsp
*@FileTitle  : Control Option Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmSpc0053Event)request.getAttribute("Event");
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
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  		id="btn_downexcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="80"/>
					<col width="142"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Period</th>
					<td colspan="9">
						<select class="input1" name="year1" id="year1" style="width:70px;"></select><!--
						--><select class="input1" name="week1" id="week1" style="width:60px;"></select>~&nbsp;<!--
						--><select class="input1" name="year2" id="year2" style="width:70px;"></select><!--
						--><select class="input1" name="week2" id="week2" style="width:60px;"></select>
					</td>
				</tr>	
				<tr>
					<th>Rep. Trade</th>
					<td><script type="text/javascript">ComComboObject("trade", 2, 70, 0, 0);</script></td>
					<th>Rep. Sub Trade</th>
					<td>&nbsp;<script type="text/javascript">ComComboObject("subtrade", 3, 60, 0, 0, 1);</script></td>
					<th>Lane</th>
					<td><script type="text/javascript">ComComboObject("lane", 4, 80, 0, 0, 2);</script></td>
					<th>Bound</th>
					<td><select name="bound" id="bound" style="width:80px;"></select></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" style="width:80px;ime-mode:disabled;" name="vvd" dataformat="engup" value="" maxlength="9" onkeypress="eventKeyChangeChar(UPPER_CASE);" onchange="checkValue();" id="vvd" /><!--
						--><button type="button" id="btn_popup_vvd" name="btn_popup_vvd" class="input_seach_btn"></button>
					</td>	
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<table>
			<tr>
				<td align="right">Unit : TEU</td>
			</tr>
		</table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
