<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0087.jsp
*@FileTitle  : On-Hire Report Summary by RCC
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0087Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0087Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseMgt.LeaseReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0087Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
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
<input type="hidden" name="tysz" id="tysz" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="270">
				<col width="80">
				<col width="250">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th>Period</th>
				<td>
				   <input type="text" name="period_stdt" style="width:80px;ime-mode:disabled;text-align:center;" value="" class="input1" dataformat="ymd" id="period_stdt" />&nbsp;~&nbsp;<!--  
				   --><input type="text" name="period_eddt" style="width:80px;ime-mode:disabled;text-align:center;" value="" class="input1" dataformat="ymd" ><!--  
				   --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td>
				<th>Lease Term</th>
				<td><script type="text/javascript" >ComComboObject('combo1', 1, 190, 1 );</script><input type="hidden" name="lstm_cd" value="" id="lstm_cd" /></td>
				<th>Location</th>
				<td><select name="loc_tp" dataformat="engup"><!--  
				-->	<option value="" selected>ALL</option><!--  
				--><option value="R">RCC</option><!--  
				--><option value="L">LCC</option><!--  
				--><option value="S">SCC</option></select><!--  
				--><input type="text" style="width:59px;text-align:center;" name="loc_cd" value="" class="input" dataformat="engup" maxlength="5" fullfill="" id="loc_cd" /><!--  
				--><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button><!--  
				--></td>
			</tr>
			<tr>
				<th>Term Change</th>
				<td><!--  
				--><select name="term_change" style="width:92px"><!--  
				--><option value="">Including</option><!--  
				--><option value="N" selected >Excluding</option><!--  
				--><option value="Y">Only</option></select></td>
				<th>DI0</th>
				<td><select name="dii" style="width:92px"><!--  
				--><option value="" selected>Including</option><!--  
				--><option value="N">Excluding</option><!--  
				--><option value="Y">Only</option><!--  
				--></select></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>