<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0176.jsp
*@FileTitle  :  Copy C/M by Container
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0176Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0176Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");

	String cntrNo = "";
	String cntrTpszCd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0176Event)request.getAttribute("Event");
		cntrNo = event.getCntrNo();
        cntrTpszCd = event.getCntrTpszCd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Copy C/M by Container</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_OK" 	id="btn_OK">OK</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close">Close</button><!--
	--></div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
</div>
<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents">
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Copy From</th>
					<td><input type="text" name="cntr_no" style="ime-mode:disabled;width:100px;text-align:center;" class="input2" value="<%=cntrNo%>" readonly id="cntr_no" /><input type="text" name="cntr_tpsz_cd" style="ime-mode:disabled;width:30px;text-align:center;" class="input2" value="<%=cntrTpszCd%>" readonly id="cntr_tpsz_cd" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</div>
<!-- opus_design_grid(E) -->
</form>