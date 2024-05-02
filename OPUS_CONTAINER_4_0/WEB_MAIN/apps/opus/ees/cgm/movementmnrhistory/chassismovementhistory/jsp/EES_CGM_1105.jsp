<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_cgm_1105.jsp
*@FileTitle  : Movement Inquiry by Chassis
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1105Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	EesCgm1105Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String form_day         = "";
	String to_day		    = ""; 
	String eqNo             = "";
	String strOfc_id = "";
	Logger log = Logger.getLogger("com.clt.apps.MovementMnrHistory.ChassisMovementHistory");
	String popup = request.getParameter("popup")==null?"no":request.getParameter("popup");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_id = account.getOfc_cd();
	      
		
		
		event = (EesCgm1105Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		eqNo   		= StringUtil.xssFilter(request.getParameter("eq_no"));
		to_day      = StringUtil.xssFilter(request.getParameter("to_day"));
		
		
		form_day  = DateTime.getDateString().replace(".","");  
		if(to_day == null || to_day.trim().equals("")){
			to_day = DateTime.addMonths(form_day.replace(".",""),-6);
		}
		
		if(eqNo == null){
			eqNo="";
		}
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
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
 

<form name="form" onkeyup="ComKeyEnter('search');">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="calend1" id="calend1" value="<%=form_day%>" />
<input type="hidden" name="calend2" id="calend2" value="<%=to_day%>" />
<input type="hidden" name="s_usr_id"  id="s_usr_id" value="<%=strUsr_id %>"/>
<input type="hidden" name="s_ofc_id"  id="s_ofc_id" value="<%=strOfc_id %>"/>

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down&nbsp;Excel</button><!--
		--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
		--><%if(popup.equals("yes")) { %><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><%}%><!--
		--></div>
	<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60" />
				<col width="150" />
				<col width="70" />
				<col width="300" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Chassis No. </th>
					<td><input type="text" style="width:90px;ime-mode:disabled" dataformat="engup" class="input1" name="eq_no" value="<%=eqNo%>" maxlength="10" id="eq_no" /> </td>
					<th>Period</th>
					<td><input type="text" style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength="10" class="input" name="str_mvmt_dt" value="" id="str_mvmt_dt" />~&nbsp;<input type="text" style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" class="input" value="" name="end_mvmt_dt" id="end_mvmt_dt" /><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="72" />
				<col width="150" />
				<col width="70" />
				<col width="103" />
				<col width="30" />
				<col width="100" />
				<col width="70" />
				<col width="100" />
				<col width="70" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Type/Size </th>
					<td><input type="text" style="width:90px;text-align:center;" class="input2" name="eq_tpsz_cd" value="" readonly="readonly" id="eq_tpsz_cd" /> </td>
					<th>Term</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input2" name="agmt_lstm_cd" value="" readonly="readonly" id="agmt_lstm_cd" /> </td>
					<th>Pool</th>
					<td><input type="text" style="width:70px;text-align:center;" class="input2" name="chss_pool_cd" value="" readonly="readonly" id="chss_pool_cd" /> </td>
					<th>On-hire Date</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input2" name="onh_dt" value="" readonly="readonly" id="onh_dt" /> </td>
					<th>Status</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input2" name="aciac_div_cd" value="" readonly="readonly" id="aciac_div_cd" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
	<table class="search" border="0">
          <tr>
              <td><h3 class="title_design mar_btm_8">Chassis Movement History</h3></td>
          </tr>
    </table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid">
	<table class="search" border="0">
          <tr>
              <td><h3 class="title_design mar_btm_8">Chassis Attach/Detach History</h3></td>
          </tr>
    </table>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>
