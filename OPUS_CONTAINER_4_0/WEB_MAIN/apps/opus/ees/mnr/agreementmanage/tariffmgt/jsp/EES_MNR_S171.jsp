<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESS_MNR_S171.jsp
*@FileTitle  : MNR Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnrS171Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 	EesMnrS171Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strVndr_seq	= "";
	String strVndr_nm	= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	=	account.getUsr_id();
		strUsr_nm 	= 	account.getUsr_nm();
		strVndr_seq	= 	account.getOfc_eng_nm();
		strVndr_nm 	= 	account.getOfc_krn_nm();
		
	   
 		event = (EesMnrS171Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var strVndrSeq	= "<%=strVndr_seq%>";
    var strVndrNm	= "<%=strVndr_nm%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="mnr_trf_sts_cd" id="mnr_trf_sts_cd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		   <button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_New" id="btn_New">New</button>
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
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="60">
					<col width="240">
					<col width="60">
					<col width="100">
					<col width="100">
					<col width="190">
					<col width="*">
				</colgroup>
				<tr>
					<th>S/P Code</th>
					<td><input type="text" name="vndr_seq" style="width:60px;text-align:center" class="input2" readonly="true" dataformat="num" id="vndr_seq" /><!-- 
					 	 --><input type="text" name="vndr_nm" style="width:150px;" class="input2" readonly="true" id="vndr_nm" /> 
					</td>
					<th>EQ Type</th>
					<td><script type="text/javascript">ComComboObject('cbEqType', 1, 80, 1, 1);</script></td>
					<th>Effective Period</th>
					<td>
						    <input type="text" name="eff_dt_fr" style="width:50px;text-align:center" class="input" maxlength="4" dataformat="yyyy" id="eff_dt_fr" /><!--
						 --><button type="button" id="eff_dt_fr_cal" name="eff_dt_fr_cal" class="calendar ir"></button>~ <!--
						 --><input type="text" name="eff_dt_to" style="width:50px;text-align:center" class="input" maxlength="4" dataformat="yyyy"><!-- 
						 --><button type="button" id="eff_dt_to_cal" name="eff_dt_to_cal" class="calendar ir"></button>
					</td>
					<th>Tariff Status</th>
					<td><script type="text/javascript">ComComboObject('cbTariffStatus', 1, 150, 1, 1);</script></td>
				</tr> 
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
			--><button class="btn_normal" type="button" name="btn_TariffDetailInfo" id="btn_TariffDetailInfo">Tariff Detail(s) Info.</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</form>