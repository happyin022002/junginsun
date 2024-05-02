<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0022.jsp
*@FileTitle  : Off-Hire Confirm from Lessor
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
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCur_dt		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0022Event)request.getAttribute("Event");
		strCur_dt = EesLse0022Event.getCurrentDate("yyyy-MM-dd");
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

<input type="hidden" name="complex_pk" id="complex_pk" />
<input type="hidden" name="lstm_cd" id="lstm_cd" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />
<input type="hidden" name="cnmv_sts_cd" id="cnmv_sts_cd" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="h_curr_dt" value="<%= strCur_dt %>" id="h_curr_dt" />
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
	--><button type="button" class="btn_normal" name="btn_save"  	id="btn_save">Save</button></div>
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
				<col width="82">
				<col width="150">
				<col width="90">
				<col width="55">
				<col width="40">
				<col width="120">
				<col width="90">
				<col width="113">
				<col width="*">
			</colgroup>
			<tr>
				<th>Division</th>
				<td><select name="loc_case" style="width:88px;"><!--  
				--><option value="0">ALL</option><!--  
				--><option value="1" selected>Location</option><!--  
				--><option value="3">Lane</option><!--
				--><option value="2">Port</option><!--  
				--></select></td>
				<th>Location</th>
			    <td><select name="loc_tp" style="width:65px"><!--  
			    --><option value="0">RCC</option><!--  
			    --><option value="1">LCC</option><!--  
			    --><option value="2" selected>SCC</option><!--  
			    --><option value="3">Yard</option><!--  
			    --></select></td>
                   <td><input type="text" name="loc_cd" caption="Location" style="width:68px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" dataformat="engup" id="loc_cd" /><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button></td>
				<th>Vessel Lane</th>
				<td><input type="text" name="slan_cd" caption="Lane" style="width:60px;text-align:center;ime-mode:inactive;" class="input" value="" maxlength="3" dataformat="engup" id="slan_cd" /><button type="button" name="btns_search7" id="btns_search7" class="input_seach_btn"></button></td>
				<th>Vessel Port</th>
				<td><input type="text" name="port_cd" caption="Port" style="width:60px;text-align:center;ime-mode:disabled;" value="" maxlength="5" dataformat="engup" id="port_cd" /><button type="button" name="btns_search6" id="btns_search6" class="input_seach_btn"></button></td>
			</tr>	
		</table>
		<table>
			<colgroup>
				<col width="82">
				<col width="150">
				<col width="90">
				<col width="55">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr>
				<th>Delivery SCC</th>
				<td><input type="text" name="del_cd" caption="Delivery SCC" style="width:60px;text-align:center" class="input" value="" maxlength="5" dataformat="engup" id="del_cd" /><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button></td>
				<th>VVD Code</th>
				<td><input type="text" name="vvd_cd" caption="VVD Code" style="width:140px;text-align:center;" class="input" value="" maxlength="9" dataformat="engup" id="vvd_cd" /><button type="button" id="btns_search3" name="btns_search3" class="input_seach_btn"></button></td>
				<th>ETA/ETD</th>
				<td><select name="estm_tp" style="width:61px;"><!--  
				--><option value="ETA" selected>ETA</option><!--  
				--><option value="ETD">ETD</option></select><!--  
				--><input type="text" name="str_estm_dt" caption="Start Duration" style="width:100px;text-align:center;ime-mode:disabled;" class="input" value="" dataformat="ymd" !cofield="end_estm_dt" id="str_estm_dt" /><!--  
				--><input type="text" name="end_estm_dt" caption="End Duration" style="width:100px;text-align:center;ime-mode:disabled;" class="input" value="" dataformat="ymd" !cofield="str_estm_dt" id="end_estm_dt" /><!--  
				--><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
			</tr>
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="82">
				<col width="150">
				<col width="90">
				<col width="280">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th>Lease Term</th>
				<td><script type="text/javascript" >ComComboObject('combo1', 1, 139, 1);</script></td>
				<th>TP/SZ</th>
				<td><script type="text/javascript" >ComComboObject('combo2', 1, 210, 1 );</script></td>
				<th>MVMT Status</th>
				<td><script type="text/javascript" >ComComboObject('combo3', 1, 200, 1);</script></td>

			</tr>
		</table>
		<table>
			<colgroup>
				<col width="82">
				<col width="150">
				<col width="90">
				<col width="283">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th>AGMT No.</th>
				<td><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:40px;text-align:center;" value="HHO" class="input2" readonly id="agmt_cty_cd" /><!--  
				--><input type="text" caption="AGMT No." name="agmt_seq" style="width:66px;text-align:center;" class="input" value="" maxlength="6" dataformat="num" id="agmt_seq" /><!--  
				--><button type="button" id="btns_search4" name="btns_search4" class="input_seach_btn"></button></td>
				<th>Lessor</th>
				<td><input type="text" name="vndr_seq" caption="Lessee" style="width:60px;text-align:center;" class="input" value="" maxlength="6" dataformat="num" id="vndr_seq" /><!--  
				--><button type="button" id="btns_search5" name="btns_search5" class="input_seach_btn"></button><!--  
				--><input type="text" name="vndr_nm" caption="Lessor." style="width:117px;" class="input2" value="" readonly="" id="vndr_nm" /></td>
				<th>CNTR No.</th>
				<td><input type="text" name="cntr_no" style="width:172px;" class="input" value="" dataformat="engup" otherchar="," id="cntr_no" />&nbsp;<img src="img/btns_multisearch.gif" name="cntr_no_multi" id="cntr_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> </td>
			
			</tr>
		</table>
		<table>
			<colgroup>
				<!-- <col width="80">
				<col width="101">
				<col width="130">
				<col width="*"> -->
				
				<col width="82">
				<col width="150">
				<col width="90">
				<col width="283">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th>Used Days</th>
				<td><input type="text" name="used_dys" caption="Used Days" style="width:40px;text-align:right;" value="" class="input" maxlength="3" dataformat="num" id="used_dys" />  Or Over</td>
				<th>Free Days </th>
				<td><input type="text" name="free_dys" caption="Free Days" style="width:40px;text-align:right;" value="" class="input" maxlength="3" dataformat="num" id="free_dys" />  Or Over</td>
				<th>RU Label</th>
				<td><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"   style="ime-mode:inactive;background-color:#ffffff;width:167px;"  value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--    
	--><button type="button" class="btn_normal" name="btn_DownExcel"  	id="btn_DownExcel">Down Excel</button></div>
	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>