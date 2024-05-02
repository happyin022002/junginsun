<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0056.js
*@FileTitle  : spacecontrolinquiry
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
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0056Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmSpc0056Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
					<col width="80px"/>
					<col width="100px"/>
					<col width="80px"/>
					<col width="100px"/>
					<col width="80px"/>
					<col width="100px"/>
					<col width="80px"/>
					<col width="100px"/>
					<col width="80px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Date</th>
					<td colspan="3">
						<input class="input1" type="text" style="width:80px;ime-mode:disabled;" value="" name="sDate" maxlength="8" onkeypress="checkDateFormat();" onfocus="initDate();" onchange="checkDate();" onblur="convertDateFnc();" id="sDate" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>&nbsp;~&nbsp;<!--						
						--><input class="input1" type="text" style="width:80px;ime-mode:disabled;" value="" name="eDate" maxlength="8" onkeypress="checkDateFormat();" onfocus="initDate();" onchange="checkDate();" onblur="convertDateFnc();" id="eDate" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>
					</td>
					<th>T/S Port</th>
					<td>
						<input class="input1" name="port" type="text" maxlength="5" style="width:50px;ime-mode:disabled;" value="" dataformat="engup" id="port" /><!--
						--><button type="button" id="btn_popup_port" name="btn_popup_port" class="input_seach_btn"></button>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input class="input1" type="input" name="vvd" size="9" maxlength="9" style="ime-mode:disabled;" dataformat="engup" id="vvd" /> </td>
					<th>Origin</th>
					<td><input type="text" size="5" value="<%//=event.getSignOnUserAccount().getOfc_cd() %>" name="org" dataformat="engup" id="org" /> </td>
				</tr>	
				<tr>
					<th>Rep. Trade</th>
					<td>
						<script type="text/javascript">ComComboObject("trade", 2, 95, 0, 1);</script>
					</td>
					<th>Sub Trade</th>
					<td>
						<script type="text/javascript">ComComboObject("subtrade", 3, 80, 0, 0);</script>
					</td>
					<th>Lane</th>
					<td>
						<script type="text/javascript">ComComboObject("lane", 4, 80, 0, 0);</script>
					</td>
					<th>Bound</th>
					<td>
						<select name="bound" id="bound" style="width:80px;"></select>
					</td>
					<th>O/I</th>
					<td>
						<select name="ioc" id="ioc" style="width:60px;"></select>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<table>
		<tbody>
				<colgroup>
					<col width="130px"/>
					<col width="*"/>
			    </colgroup>
		<tr>
			<th>Data Selection</th>
			<td>
				<input type="checkbox" value="" class="trans" checked name="chkTYP" id="idChkTYP" name="idChkTYP" onclick="return viewByTpSz()"><label for="idChkTYP"><b>View by Type / Size / WT</b></label>
			</td>
		</tr>
	</tbody>
	</table>
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
