<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0404.jsp
*@FileTitle  : Vessel Entry Status View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.cps.cni.insurance.vesselstatus.event.CpsCni0403Event"%>
<%@ page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0403Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Insurance.DryWetClaim");
	String strTodate        = DateTime.getDateString().substring(0,4)+"-"+DateTime.getDateString().substring(5,7)+"-"+DateTime.getDateString().substring(8,10);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (CpsCni0403Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script language="javascript">
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
<!-- 개발자 작업	-->
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="insur_period" id="insur_period" />
<input type="hidden" name="insur_tp_cd" id="insur_tp_cd" />
<input type="hidden" name="insur_cvrg_cd" id="insur_cvrg_cd" />
<input type="hidden" name="insur_vsl_tp_cd" id="insur_vsl_tp_cd" />
<input type="hidden" name="insur_vsl_oshp_cd" id="insur_vsl_oshp_cd" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Entry Status" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
<input type="hidden" name="insur_clm_pty_no" id="insur_clm_pty_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_Print"  		id="btn_Print">Print</button>	
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
					<col width="300px"/>
					<col width="80px"/>
					<col width="100px"/>
					<col width="80px"/>
					<col width="100px"/>
					<col width="80px"/>
					<col width="80px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Period</th>
					<td><script type="text/javascript">ComComboObject("combo_insur_period", 2, 90, 1, 1, 0, true);</script><!--
						--><input type="text" name="insur_eff_dt" class="input1" style="width:75px;text-align:center;ime-mode:disabled;" dataformat="ymd" value="<%=strTodate.substring(0,4)+"-01-01"%>" caption="Period(From)"><!--
						--><button type="button" id="cal_insur_eff_dt" name="cal_insur_eff_dt" class="calendar ir"></button>&nbsp;~&nbsp;&nbsp;<input name="insur_exp_dt" class="input1" type="text" style="width:75px;text-align:center;ime-mode:disabled;" dataformat="ymd" value="<%=strTodate%>" caption="Period(To)"><button type="button" id="cal_insur_exp_dt" name="cal_insur_exp_dt" class="calendar ir"></button></td>
					<th>TOI</th>
					<td><script type="text/javascript">ComComboObject("combo_insur_tp_cd", 2, 60, 1, 0, 0, true);</script></td>
					<th>Coverage</th>
					<td><script type="text/javascript">ComComboObject("combo_insur_cvrg_cd", 2, 60, 1, 0, 0, true);</script></td>
					<th>Insurer</th>
					<td colspan="2"><input type="text" name="insur_clm_pty_nm" style="width:133px;" value="" dataformat="engup" class="input" id="insur_clm_pty_nm" readonly="readonly"/><button type="button" id="pop_insur_clm_pty_nm" name="pop_insur_clm_pty_nm" class="input_seach_btn"></button></td>
				</tr>
				<tr>
					<th>Name of Vessel</th>
					<td><input type="text" name="vsl_eng_nm" style="width:320px;" maxlength="50" caption="Name of Vessel" class="input" id="vsl_eng_nm" /> </td>
					<th>Code</th>
					<td><input type="text" name="vsl_cd" style="width:60px;text-align:center;" maxlength="4" dataformat="engup" caption="Code of Vessel" value="" class="input" id="vsl_cd" /> </td>
					<th>Type of Vessel(TOV)</th>
					<td><script type="text/javascript">ComComboObject("combo_insur_vsl_tp_cd", 2, 60, 1, 0, 0, true);</script></td>
					<th colspan="2">Type of Ownership(TOO)</th>
					<td><script type="text/javascript">ComComboObject("combo_insur_vsl_oshp_cd", 2, 83, 1, 0, 0, true);</script></td>
				</tr>					
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
