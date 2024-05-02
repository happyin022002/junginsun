<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2104.jsp
*@FileTitle  : General Mgset Movement Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2016/11/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event.EesCgm2104Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm2104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MovementMnrHistory.ChassisMovementHistory");
	String xml = HttpUtil.makeXML(request,response);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm2104Event)request.getAttribute("Event");
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
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
<form name="form"  onkeyup="ComKeyEnter('search');" action="">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="HIDDEN" name="intg_cd_id" id="intg_cd_id" />
<input type="HIDDEN" name="np" value="N" id="np" />
<input type="hidden" name="eq_no" id="eq_no" />
<input type="HIDDEN" name="loc_cd" id="loc_cd" />
<input type="HIDDEN" name="chss_mvmt_dt" id="chss_mvmt_dt" />
<input type="hidden" name="eq_orz_cht_chktype" id="eq_orz_cht_chktype" />
<input type="hidden" name="eq_orz_cht_rcc_cd" id="eq_orz_cht_rcc_cd" />
<input type="hidden" name="eq_orz_cht_lcc_cd" id="eq_orz_cht_lcc_cd" />
<input type="hidden" name="eq_orz_cht_scc_cd" id="eq_orz_cht_scc_cd" />
<input type="hidden" name="pagerows" value="1000" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">DownExcel</button><!--
		--><button class="btn_normal" name="btn_master" id="btn_master" type="button">Master</button><!--
		--><button class="btn_normal" name="btn_mvmt" id="btn_mvmt" type="button">MVMT</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- wrap_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90">
				<col width="270">
				<col width="50">
				<col width="330">
				<col width="50">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Location </th>
					<td>
						<select style="width: 100px;" name='location' id="location" class="input1">
							<option value="L" selected>LCC</option>
							<option value="S">SCC</option></select><!-- 
					--><input type="text" style="width: 80px; ime-mode:disabled" dataformat="engup" name="scc_cd"  id="scc_cd"  class="input1"value="" maxlength='5'><!-- 
					--><button type="button" id="ComOpenPopupWithTarget" name="ComOpenPopupWithTarget" class="input_seach_btn"></button>
					</td>
					<th> </th><td></td>
					<th> </th><td></td>
					<th> </th><td></td>
					<th> </th><td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90">
				<col width="107">
				<col width="47">
				<col width="58">
				<col width="121">
				<col width="50">
				<col width="135">
				<col width="50">
				<col width="122">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Active Status </th>
					<td>
						<select style="width:100px;" name='aciac_div_cd' id='aciac_div_cd' class="input">
							<option value="" selected>ALL</option>
							<option value="A">Active</option>
							<option value="I">In-active</option>
						</select>
					</td> 
					<th> MVMT </th>
					<td><script type="text/javascript">ComComboObject('chss_mvmt_sts_cd', 1, 60, 0, 0, 0, true);</script></td>
					<th>Size</th>
					<td><script type="text/javascript">ComComboObject('eq_tpsz_cd', 1, 71,0);</script></td>
					<th>Lease Term </th>
					<td><script type="text/javascript">ComComboObject('agmt_lstm_cd', 1, 74,0);</script></td>
					<th>Staying Days</th>
					<td><input type="text" dataformat="ymd" style="width:70px;text-align:right" class="input" value="" name="days" id="days" />  or More</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_area(E) -->

<!-- result_area(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_more" id="btn_more" type="button">More</button><!--
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		</br>
		<div class="grid_option_left">
            <table> 
            	<colgroup>
					<col width="90" />
					<col width="100" />
					<col width="70" />
					<col width="100" />
					<col width="*" />
				</colgroup>
          		<tbody>
		           <tr>
		            <tr class="h23">
						<th>Retrieved Row</th>
						<td> <input type="text" style="width: 70px; text-align:right" class="input" readonly="readonly" name ="pngcnt" id ="pngcnt"></td>
						<th>Total Row</th>
						<td> <input type="text" style="width: 70px ;text-align:right" class="input" readonly="readonly" name ="ttl_knt" id ="ttl_knt"></td>
						<td></td>
		           </tr>
          		</tbody>
         </table>
  		</div>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>