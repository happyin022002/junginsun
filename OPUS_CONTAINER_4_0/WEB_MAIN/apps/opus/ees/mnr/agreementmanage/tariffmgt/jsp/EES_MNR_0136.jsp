<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESS_MNR_0136.jsp
*@FileTitle  : MNR Regional Tariff Approval 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0136Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0136Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String rhqOfcCd         = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		rhqOfcCd  = account.getRhq_ofc_cd();

		event = (EesMnr0136Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=rhqOfcCd %>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<!-- Developer's task	-->
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="ar_hd_qtr_ofc_cd" id="ar_hd_qtr_ofc_cd" />
<input type="hidden" name="rqst_ofc_cd" id="rqst_ofc_cd" />
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="mnr_trf_sts_cd" id="mnr_trf_sts_cd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Approval" id="btn_Approval">Approval</button><!--
		--><button type="button" class="btn_normal" name="btn_Reject" id="btn_Reject">Reject</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_TariffDetailInfo" id="btn_TariffDetailInfo">Tariff Detail(s) Info.</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="80" />
            <col width="110" />
            <col width="75" />
            <col width="350" />
            <col width="100" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr>
				<th>Regional HQ</th>
				<td><script type="text/javascript">ComComboObject('cbRegionalHq', 2, 75, 0, 1);</script></td>
				<th>Tariff Office</th>
				<td><script type="text/javascript">ComComboObject('cbAgmtOffice', 2, 70, 0, 1);</script></td>
				<th>Tariff Status</th>
				<td><script type="text/javascript">ComComboObject('cbTariffStatus', 1, 169, 1, 1);</script></td>
			</tr>
			<tr>
				<th>EQ Type </th>
				<td><script type="text/javascript">ComComboObject('cbEqType', 1, 75, 1, 1);</script></td>
				<th>S/P Code</th>
				<td><input type="text" name="vndr_seq" style="width:70;text-align:center" class="input" maxlength="6" dataformat="num"><button type="button" class="input_seach_btn" name="provider_popup" id="provider_popup"></button><input type="text" name="vndr_nm" style="width:180" class="input2" readOnly="true"></td>
				<th>Effective Period</th>
				<td>
				<input type="text" name="eff_dt_fr" style="width:60px;text-align:center" class="input" maxlength="4" dataformat="yyyy"><button type="button" class="calendar ir" name="eff_dt_fr_cal" id="eff_dt_fr_cal"></button>&nbsp;~
				<input type="text" name="eff_dt_to" style="width:60px;text-align:center" class="input" maxlength="4" dataformat="yyyy"><button type="button" class="calendar ir" name="eff_dt_to_cal" id="eff_dt_to_cal"></button>
				<input type="hidden" width="100%">
				</td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>