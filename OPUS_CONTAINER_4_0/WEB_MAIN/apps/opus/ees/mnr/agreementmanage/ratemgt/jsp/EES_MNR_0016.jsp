<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0016.jsp
*@FileTitle  : M&R Agreement Inquiry_Pop Up
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
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.event.EesMnr0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
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
<input type="hidden" name="agmt_ofc_cd" id="agmt_ofc_cd" />
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd %>" id="ofc_cd" />
<input type="hidden" name="agmt_eq_type" id="agmt_eq_type" />
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>M&R Agreement Inquiry_Pop Up</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
				--><button type="button" class="btn_normal" name="btn_ok" 		id="btn_ok">Ok</button><!--
				--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
			<div class="location">
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<div class="layer_popup_contents">
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
					<colgroup>
						<col width="60"/>
						<col width="120"/>						
						<col width="80"/>
						<col width="120"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
				    <tbody>
					<tr>
						<th>EQ Type</th>
						<td><script type="text/javascript">ComComboObject('combo1',1, 100 , 1,1)</script> </td>
						<th>Agreement Office</th>
						<td><script type="text/javascript">ComComboObject('combo2',1, 100 , 1,1)</script></td>
						<th>Effective Period</th>
						<td><input type="text" style="width:80px;" class="input1" name="agmt_fm_dt" dataformat="ymd" maxlength="10" cofield="agmt_to_dt" id="agmt_fm_dt" />~&nbsp;<!-- 
						 --><input type="text" style="width:80px;" class="input1" name="agmt_to_dt" dataformat="ymd" maxlength="10" cofield="agmt_fm_dt" id="agmt_to_dt" /><!-- 
						 --><button type="button" id="cre_dt_cal" name="cre_dt_cal" class="calendar ir"></button>
						<th>Old AGMT No.</th>
						<td><input type="text" name="old_agmt_no" id="old_agmt_no"  style="width:80px;" value = "" dataformat="engup" otherchar="_-"></td>
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
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>
