<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0063.jsp
*@FileTitle  : Terminal Performance Port / Lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0063Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	VopOpf0063Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0063Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
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
<input type="hidden" name="carr_cd" value="<%=ConstantMgr.getCompanyCode()%>" id="carr_cd" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_Excel" 	id="btn_Excel">Down Excel</button><!--  
	-->	</div>  
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="200">
				<col width="80">
				<col width="340">
				<col width="70">
				<col width="70">
				<col width="*">
			</colgroup> 
			<tr>
				<th>Port</th>
				<td><!--  
				--><input type="text" name="loc_cd" style="width:60px;ime-mode:disabled" class="input1" dataformat="engup" maxlength="5" caption="Port" fullfill="" id="loc_cd" /><!--  
				--><button type="button" name="btn_loc_cd" id="btn_loc_cd" class="input_seach_btn"></button><!--  
				--><script type="text/javascript">ComComboObject('yd_cd', 2, 55, 1);</script></td>
				<th>From to Date</th>
				<td><input type="hidden" name="now_date" value="<%=DateTime.getFormatDate(new Date()," yyyy-MM-dd") %>" id="now_date" /><!--  
				--><input type="hidden" name="last_day" value="<%=DateTime.lastDayOfMonth(DateTime.getFormatDate(new Date(),"yyyyMMdd"))%>" id="last_day" /><!--  
				--><input type="text" name="from_date" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" caption="From to Date" id="from_date" />&nbsp;~ &nbsp;<!--  
				--><input type="text" name="to_date" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" caption="From to Date">&nbsp;<!--  
				--><button type="button" class="calendar ir" name="from_to_calendar" id="from_to_calendar"></button></td>
				<th style="text-align:left">Manu. in Time</th>
				<td><input type="text" style="width:60px;" class="input1" name="manu_in_time" value="0.0" dataformat="float" maxlength="4" size="3" pointcount="1" caption="Manu. in Time" id="manu_in_time" /></td>
				<td></td>
			</tr>
			<tr>
				<th>Lane</th>
				<td><input type="text" name="slan_cd" style="width:60px;ime-mode:disabled" class="input" dataformat="engup" maxlength="3" caption="Lane" fullfill="" id="slan_cd" /><!--  
				--><button type="button" name="btn_slan_cd_pop" id="btn_slan_cd_pop" class="input_seach_btn"></button></td>
				<th>Direction</th>
				<td><script type="text/javascript">ComComboObject('dir_cd', 1, 55, 1);</script></td>
				<th class="wrap_search_btn">Vessel Operator</th>
				<td class="wrap_search_btn"><input type="radio" name="radio_carr_cd" value="<%=ConstantMgr.getCompanyCode()%>" id="radio_carr_cd" class="trans" checked <%=ConstantMgr.getCompanyCode()%>/>&nbsp;NYK<!--  
				-->&nbsp;&nbsp;<input type="radio" name="radio_carr_cd" class="trans"/>&nbsp;Other<!--  
				-->&nbsp;&nbsp;<input type="radio" name="radio_carr_cd" class="trans"/>&nbsp;All</td>
				<td></td>
			</tr> 
		</table>	
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
</div>
</form>