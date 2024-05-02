<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0006
*@FileTitle  : Cargo Claim Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
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
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%
    Exception serverException = null;
    String strErrMsg = "";

    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaimreport.ContainerCargoClaimReportSC");

    String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no" , "");

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

        //세션에 Claim No가 존재하면
        String ssCgoClmNo =  eventResponse.getETCData("CGO_CLM_NO");
        if ( cgoClmNo.equals("") && ssCgoClmNo != null && !ssCgoClmNo.equals("")) {
        	cgoClmNo = ssCgoClmNo;
        }
        userArea =  CniUtil.getAreaInfo(account);
    }
    catch (Exception e)
    {
    	out.println(e.toString());
    }

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
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">

    function setupPage(){ 
    	var errMessage = "<%=strErrMsg.replace("\"","'")%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

	    loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="ofc_cd" value="<%=userOffice%>" id="ofc_cd" />
<input type="hidden" name="user_id" value="<%=userId%>" id="user_id" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="usr_area" value="<%=userArea%>" id="usr_area" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
<div class="opus_design_btn">
	<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
	--><button class="btn_normal" name="btn1_Print" id="btn1_Print" type="button">Print</button><!--
	--></div>
<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- wrap_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="50px">
				<col width="50px">
				<col width="20px">
				<col width="50px">
				<col width="120px">
				<col width="50px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Claim  No.</th>
					<td><input type="text" name="cgo_clm_no" style="width:85px;" maxlength="10" value="<%=cgoClmNo%>" dataformat="engup" class="input1" id="cgo_clm_no" /></td>
					<td><input type="text" name="area_cd" style="width:20px;text-align:center" value="" class="input2" readonly="readonly" id="area_cd" /></td>
					<th class="sm">Status</th>
					<td class="pad_left_12 pad_right_4 sm"><input type="radio" name="status" class="trans" checked="" value="B" id="status" />Before  Litigation</td>
					<td class="pad_left_12 pad_right_4 sm"><input type="radio" class="trans" name="status" value="A" id="status" />After Litigation </td>
					<td></td>
				</tr>
			</tbody>
		</table> 	
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->
<div class="wrap_result" style="height:1000px;">
	<div class="opus_design_RD">
		<script type="text/javascript">rdViewerObject();</script>
	</div>
</div>


<div style="display: none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>		


</form>