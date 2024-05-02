<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0057.jsp
*@FileTitle  : Cargo Handling Performance
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
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0057Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	VopOpf0057Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (VopOpf0057Event)request.getAttribute("Event");
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
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--
	--><button type="button" class="btn_normal" name="btn_Excel" 	id="btn_Excel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="120">
				<col width="60">
				<col width="60">
				<col width="100">
				<col width="250">
				<col width="80">
				<col width="120">
				<col width="40">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th>Port</th>
				<td><!--  
				--><input type="text" name="loc_cd" style="width:48px;ime-mode:disabled" class="input1" dataformat="engup" maxlength="5" caption="Port" required fullfill id="loc_cd" /><!--  
				--><button type="button" name="btn_loc_cd" id="btn_loc_cd" class="input_seach_btn"></button><!--  
				--><script type="text/javascript">ComComboObject('yd_cd', 2, 55, 1);</script><!--  
				--></td>
				<th>Lane</th>
				<td><input type="text" name="slan_cd" style="width:40px;ime-mode:disabled;" class="input1" dataformat="engup" maxlength="3" caption="Lane" required fullfill id="slan_cd" /><!--  
				--><button type="button" id="btn_slan_cd_pop" name="btn_slan_cd_pop" class="input_seach_btn"></button></td>
				<th>From to Date</th>
				<td><!--  
				--><input type="hidden" name="now_date" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd") %>" id="now_date" /><!--  
				--><input type="hidden" name="last_day" value="<%=DateTime.lastDayOfMonth(DateTime.getFormatDate(new Date(),"yyyyMMdd"))%>" id="last_day" /><!--  
				--><input type="text" name="from_date" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" caption="From to Date" id="from_date" /><span class="dash">~</span><!--  
				--><input type="text" name="to_date" style="width:80px;" class="input1" dataformat="ymd" maxlength="8" caption="From to Date"><!--  
				--><button type="button" class="calendar ir" name="from_to_calendar" id="from_to_calendar"></button></td>
				<th class="wrap_search_btn">Cargo Operator</th>
				<td class="wrap_search_btn"><!--
				--><input type="radio" name="opr_cd" value="" class="trans" checked id="opr_cd1" /><label for="opr_cd1" class="pad_rgt_8">All</label><!--
				--><input type="radio" name="opr_cd" value=<%=ConstantMgr.getCompanyCode()%> class="trans" id="opr_cd2"><label for="opr_cd2"><%=ConstantMgr.getCompanyCode()%></label>
				</td>
				<th class="wrap_search_btn">Option</th>
				<td class="wrap_search_btn"><!--
				--><input type="radio" name="option_cd" value="" class="trans" checked id="option_cd1" /><label for="option_cd1" class="pad_rgt_8">Trunk</label><!--
				--><input type="radio" name="option_cd" value="O" class="trans" id="option_cd2" /><label for="option_cd2">Feeder</label>
				</td>
				<td></td>
			</tr>
		</table>	
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="mainTable" style="display: none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>