<%/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESS_MNR_0171.jsp
*@FileTitle : MNR Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0171Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0171Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
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
	   
		event = (EesMnr0171Event)request.getAttribute("Event");
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

<form name="form" id="form">
<!-- Developer's task	-->
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="ar_hd_qtr_ofc_cd" id="ar_hd_qtr_ofc_cd">
<input type="hidden" name="rqst_ofc_cd" id="rqst_ofc_cd">
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd">
<input type="hidden" name="mnr_trf_sts_cd" id="mnr_trf_sts_cd">
<input type="hidden" name="pagerows" id="pagerows">
	
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

	
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
<div class="opus_design_inquiry">
	<table>
		 <colgroup>
			<col width="80" />
			<col width="90" />
			<col width="100" />
			<col width="300" />
			<col width="90" />
			<col width="" />
		</colgroup> 
		<tbody>
			<tr>
				<th>Regional HQ</th>
				<td>
					<script type="text/javascript">ComComboObject('cbRegionalHq', 2, 75, 0, 1);</script>
				</td>
				<th>Tariff Office</th>
				<td>
					<script type="text/javascript">ComComboObject('cbAgmtOffice', 2, 72, 0, 1);</script>
				</td>
				<th>Tariff Status</th>
				<td>
					<script type="text/javascript">ComComboObject('cbTariffStatus', 1, 165, 1, 1);</script>
				</td>
			</tr>
			<tr>
				<th>EQ Type</th>
				<td>
					<script type="text/javascript">ComComboObject('cbEqType', 1, 75, 1, 1);</script>
				</td>
				<th>S/P Code</th>
				<td>
					<input type="text" name="vndr_seq" id="vndr_seq" style="width:70px;text-align:center" class="input"  dataformat="num" maxlength="6"><!-- 
					 --><button type="button" id="provider_popup" name="provider_popup" class="input_seach_btn"></button><!-- 
					 --><input type="text" name="vndr_nm" id="vndr_nm" style="width:180px" class="input2" readOnly="true">
				</td>
				<th>Effective Period</th>
				<td>
					<input type="text" name="eff_dt_fr" id="eff_dt_fr" style="width:50px;text-align:center" class="input" maxlength="4" dataformat="yyyy"><!-- 
					 --><button type="button" id="eff_dt_fr_cal" name="eff_dt_fr_cal" class="calendar ir"></button>~&nbsp;<!-- 
					 --><input type="text" name="eff_dt_to" id="eff_dt_to" style="width:50px;text-align:center" class="input" maxlength="4" dataformat="yyyy"><!-- 
					 --><button type="button" id="eff_dt_to_cal" name="eff_dt_to_cal" class="calendar ir"></button>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<div class="wrap_result">
<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="btn_DownExcel"   id="btn_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_TariffDetailInfo"   id="btn_TariffDetailInfo">Tariff Detail(s) Info.</button>
		</div>
		<!-- opus_design_btn(E) -->
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
<!-- opus_design_grid(E) -->

</div>

</form>
