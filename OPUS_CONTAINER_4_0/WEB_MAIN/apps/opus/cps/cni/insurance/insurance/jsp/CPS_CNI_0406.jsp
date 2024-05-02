<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : CPS_CNI_0406.jsp
*@FileTitle  : Detail2
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.clt.apps.DryWetClaim.DryWetClaim");

    String pop_title = JSPUtil.getNull(request.getParameter("pop_title"));
    String pop_desc = JSPUtil.getNull(request.getParameter("pop_desc"));
    String pop_cont_col = JSPUtil.getNull(request.getParameter("pop_cont_col"));
    String pop_cont = JSPUtil.getNull(request.getParameter(pop_cont_col));
    String insur_tp_nm = JSPUtil.getNull(request.getParameter("insur_tp_nm"));
    String insur_plcy_yr = JSPUtil.getNull(request.getParameter("insur_plcy_yr"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pop_cont_col" value="<%=pop_cont_col%>">
<input type="hidden" name="pop_cont_hidden" value="<%=pop_cont%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Detail</span></h2>
		
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Save</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<th width="130px">&nbsp;&nbsp;Type of Insurance</th>
				<td width="200px"><input type="text" style="width:230;" value="<%=insur_tp_nm%>" class="input2"></td>
				<th width="79px">&nbsp;&nbsp;Policy Year</th>
				<td width=""><input type="text" style="width:49;text-align:center" value="<%=insur_plcy_yr%>" class="input2"></td>
			</tr>
			<tr class="h23">
				<td width="" colspan="4"><textarea name="contents" caption="Contents" value="<%=pop_cont%>" style="width:100%" rows="30"></textarea></td>
			</tr>
			</table>
		</div>
	</div>
</div>

</form>

