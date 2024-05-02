<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1009.jsp
*@FileTitle  : COD Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg1009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strIsPop			= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.CODCorrection");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1009Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strIsPop = event.getIsPop();

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
</head>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="isPop" id="isPop" value="<%=strIsPop%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span><%if (strIsPop.equals("R")){%>Reject Reason Remarks<%}else{%>COD Remark<%}%></span></h2>
		
		<div class="opus_design_btn">
		<%if (!strIsPop.equals("R")){%>
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
		<%}%>
			<button type="button" class="btn_normal" name="btn_close" id=btn_close>Close</button>
		</div>
	</div>
	
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<table class="grid_2 mar_btm_none">
		    <tbody>
		        <tr>
		            <td><textarea style="resize:none;" id="diff_rmk" name="diff_rmk" cols="20" rows="10" class="noinput" <%=(strIsPop.equals("R"))? "readOnly":""%>></textarea></td>
		        </tr>
		    </tbody>
		</table>
	</div>
</div>

</form>