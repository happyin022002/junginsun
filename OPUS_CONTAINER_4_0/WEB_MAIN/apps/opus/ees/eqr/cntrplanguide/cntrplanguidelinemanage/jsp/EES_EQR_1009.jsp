<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1009.jsp
*@FileTitle  : Empty Repo Guideline Add/Amend.
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event.EesEqr1009Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1009ConditionVO"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesEqr1009Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	String vvd_cd 			= "";
	String eff_st_dt		= "";
	String eta_dt			= "";	
	String pol_cd 			= "";
	String combo_pol_cd 	= "";
	String event_div  		= StringUtil.xssFilter(request.getParameter("event_div"));
	String hidden_eta_dt  	= StringUtil.xssFilter(request.getParameter("h_eta_dt"));	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesEqr1009Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		EesEqr1009ConditionVO conditionVO = new EesEqr1009ConditionVO();
		conditionVO = event.getEesEqr1009ConditionVO();

		vvd_cd = conditionVO.getSVvdCd();
		eff_st_dt = conditionVO.getSEffStDt();
		pol_cd = conditionVO.getSPolCd();
		eta_dt = conditionVO.getSEtaDt();

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
		var formObj = document.form;
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		if("<%= event_div %>" =="M"){ //Amend일 경우
			formObj.s_vvd_cd.value		=	"<%=vvd_cd%>";
			formObj.s_pol_cd.value		=	"<%=pol_cd%>";
			formObj.s_eff_st_dt.value	=	"<%=eff_st_dt%>";
			formObj.s_eta_dt.value		=	"<%=eta_dt%>";
			formObj.h_eta_dt.value		=	"<%=hidden_eta_dt%>";
		}else{
			formObj.s_vvd_cd.value		=	"";
			formObj.s_pol_cd.value		=	"";
			formObj.s_eff_st_dt.value	=	"";
			formObj.s_eta_dt.value		=	"";
			formObj.h_eta_dt.value		=	""; 
		}
		ComOpenWait(true);
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="event_div" value="<%= event_div %>" id="event_div" />
<input type="hidden" name="s_eff_st_dt" value="" id="s_eff_st_dt" />
<input type="hidden" name="h_eta_dt" value="" id="h_eta_dt" />
<input type="hidden" name="cntr_tpsz_cd" value="" id="cntr_tpsz_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">Guideline Add/Amend</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_apply" id="btn_apply">Apply</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->

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
				<col width="40">
				<col width="120">
				<col width="60">
				<col width="120">
				<col width="40">
				<col width="130">
				<col width="40">
				<col width="120">
				<col width="40">
				<col width="120">
				<col width="40">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject("trade", 2, 80, 0, 1);</script></td>
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject("subtrade", 4, 80, 0, 1);</script></td>
					<th>Lane</th>
					<td><script type="text/javascript">ComComboObject("lane", 5, 85, 0, 1);</script></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="s_vvd_cd" class="input1" style="width:80px;" maxlength="9" onchange="change_vvd();" id="s_vvd_cd" /></td>
					<th title="Port of Loading">POL</th>
					<td><select name="s_pol_cd"  style="width:80px" maxlength="7" onChange="change_pol();" class="input1"></select> </td>
					<th>ETA</th>
					<td><input type="text" name="s_eta_dt" class="input2" style="width:80px;" dataformat="ymd" maxlength="8" readonly id="s_eta_dt" /></td> 
				</tr>
			</tbody>
		</table>
	</div>	
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>