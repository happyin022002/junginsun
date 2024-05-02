<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0306.jsp
*@FileTitle  : Vessel VVD & Name Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.cps.cni.codemgt.codemgt.event.CpsCni0306Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0306Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOBasicRegister");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (CpsCni0306Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		log.error("err " + e.toString(), e);
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>VVD & Name Inquiry</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn1_Select" id="btn1_Select" type="button">Select</button><!--
		--><button class="btn_normal" name="btn1_Close" id="btn1_Close" type="button">Close</button><!--
		--></div>
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
			<colgroup>
				<col width="30" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd_cd" style="width:80px;text-align:center;ime-mode:disabled" class="input" value="" maxlength="10" dataformat="engup" caption="VVD Code" id="vvd_cd" /><!-- 
					 --><button type="button" id="pop_vsl_cd" name="pop_vsl_cd" class="input_seach_btn"></button><!-- 
					 --><input type="text" name="vsl_eng_nm" style="width:200px;" class="input" value="" maxlength="50" caption="VVD Name" id="vsl_eng_nm" /> </td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>

<%@include file="/bizcommon/include/common_opus.jsp"%>