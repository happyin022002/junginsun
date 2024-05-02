<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0039.jsp
*@FileTitle  : [CPS_CNI_0039] Class Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.codemgt.codemgt.event.CpsCni0039Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%
	CpsCni0039Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0; 

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.codemgt.CodeMgtSC");
    SignOnUserAccount account = null;


    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0039Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }

    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
    String cookiesJSessionId="";

    Cookie[] cookies = request.getCookies();

      if (cookies != null) {

          for (int loop = 0; loop < cookies.length; loop++) {

                 if (cookies[loop].getName().equals("JSESSIONID")) {

                         cookiesJSessionId=cookies[loop].getValue();

                  }

          }

   }


%>
<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%><html>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<form name="form">
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
	--><button class="btn_normal" name="btn1_Save" id="btn1_Save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn1_Print" id="btn1_Print" type="button">Print</button><!--
	--></div>
<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		<button class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add" type="button">Row&nbsp;Add</button><!--
		--><button class="btn_normal" name="btn2_Row_Insert" id="btn2_Row_Insert" type="button">Row Insert</button><!--
		--><button class="btn_normal" name="btn2_Row_Copy" id="btn2_Row_Copy" type="button">Row Copy</button><!--
		--><button class="btn_normal" name="btn2_Row_Delete" id="btn2_Row_Delete" type="button">Row&nbsp;Delete</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>