<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0040.jsp
*@FileTitle  : CCC Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    Exception serverException = null;
    String strErrMsg = "";

    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");

    String pop_flag = JSPUtil.getNull(request.getParameter("pop_flag"));
    String pop_title = JSPUtil.getNull(request.getParameter("pop_title"));
    String pop_desc = JSPUtil.getNull(request.getParameter("pop_desc"));
    String pop_cont_col = JSPUtil.getNull(request.getParameter("pop_cont_col"));
    String pop_cont = JSPUtil.getNull(request.getParameter(pop_cont_col));
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


    } catch (Exception e) {
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
<input type="hidden" name="pop_cont_col" value="<%=pop_cont_col%>" id="pop_cont_col" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>CCC Detail</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class= "wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit" id="mainTable">
		<table class="grid_2" >
			<colgroup>
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th style="text-align: center;"><b><%=pop_title.replace("_","&")%></b></th>
				</tr>
				<tr>
					<td><textarea style="width:100%;resize:none;" name="contents" id="contents" rows="30"><%=pop_cont%></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>		
</form>