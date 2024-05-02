<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0036.jsp
*@FileTitle  : QTA Establishing Status
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.planning.statusmanage.event.EsmCsq0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0036Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.planning.statusmanage");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmCsq0036Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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
<input type="hidden" name="backendjob_key" id="backendjob_key" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--  
		--><button class="btn_normal" name="btn_GrpbCreation" id="btn_GrpbCreation" type="button">HO L/F & G.RPB Creation</button><!--  
		--><button class="btn_normal" name="btn_HoCreation" id="btn_HoCreation" type="button">HO Creation</button><!--
		--><button class="btn_normal" name="btn_RhqCreation" id="btn_RhqCreation" type="button">RHQ Creation</button><!--
		--><button class="btn_normal" name="btn_QtaFreezing" id="btn_QtaFreezing" type="button">QTA Freezing</button><!--
		--><button class="btn_normal" name="btn_CancelConfirm" id="btn_CancelConfirm" type="button">Cancel Confirmation</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
		--><div id="td_trans"><button class="btn_normal" name="btn_Transfer" id="btn_Transfer" type="button">1Q Transfer</button></div>
	</div>
	<!-- opus_design_btn (E) -->
	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="95">
				<col width="50">
				<col width="80">
				<col width="80">
				<col width="100">
				<col width="50">
				<col width="120">
				<col width="50">
				<col width="*">		
			</colgroup>
			<tr>
				<td class='sm pad_left_8'><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd_y" class="trans" value="Y"><label for="f_bse_tp_cd_y"><strong>Yearly</strong></label></td>
				<th>Year</th>
				<td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1)</script></td>
				<th><div id="div_qtr">Quarter</div></th>
				<td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 50, 1, 1)</script></td>
				<td colspan="2"><div id="div_period"></div></td>
				<th>Step</th>
				<td><script type="text/javascript">ComComboObject('f_qta_step_cd', 1, 255, 1)</script></td>
			</tr>
			<tr>
				<td class='sm pad_left_8'><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd_q" class="trans" value="Q" checked><label for="f_bse_tp_cd_q"><strong>Quarterly</strong></label></td>
				<th>Trade</th>
				<td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 60, 1)</script></td>
				<th>Trade Bound</th>
				<td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 50, 1)</script></td>
				<th>HO Teams</th>
				<td><script type="text/javascript">ComComboObject('f_ho_team_cd', 1, 75, 1)</script></td>
				<th>Org.</th>
				<td><script type="text/javascript">ComComboObject('f_org_cd', 1, 80, 1)</script></td>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>