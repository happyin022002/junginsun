<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0037.jsp
*@FileTitle  : Tariff Value Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0037Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	VopPso0037Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopPso0037Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = '<%=strErrMsg%>';
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	/* function setupPage(){
        loadPage();
    } */
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="60px" />
					<col width="250px" />
					<col width="100px" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Period</th>
					<td><input id="from_date" name="from_date" dataformat="ymd" maxlength="8" style="width: 75px; ime-mode: disabled" class="input1" value="" type="text" /><button class="calendar ir" name="btns_Calendar1" id="btns_Calendar1" type="button"></button> ~ <input id="to_date" name="to_date" dataformat="ymd" style="width: 75px; ime-mode: disabled" class="input1" value="" type="text" /><button class="calendar ir" name="btns_Calendar2" id="btns_Calendar2" type="button"></button></td>
					<th>Port</th>
					<td><input name="port_cd" id="port_cd" type="text" dataformat="engup" style="width:90px" class="input" value="" size="5" maxlength="5"><button type="button" class="input_seach_btn" name="btn_port_cd" id="btn_port_cd"></button><script type="text/javascript">ComComboObject('yard_cd',2, 200, 0, 3);</script></td>
				</tr>
				<tr>
					<th>Account CD</th>
					<td><script type="text/javascript" >ComComboObject('acct_cd',2, 96, 0, 0);</script><input type="text" name="acct_nm" id="acct_nm" style="width: 300px; text-align: left" class="input2" value="" readonly></td>
					<th>Cost CD</th>
					<td><script type="text/javascript">ComComboObject('cost_cd',2, 90, 0, 0);</script><input type="text" name="cost_nm" id="cost_nm" style="width: 230px; text-align: left" class="input2" value="" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->


<div class="wrap_result">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width:75%; padding-right: 10px;">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    <div class="layout_vertical_2" style="width:25%; padding-right: 5px;"">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
</div>
<!-- layout_wrap(E) -->
</form>