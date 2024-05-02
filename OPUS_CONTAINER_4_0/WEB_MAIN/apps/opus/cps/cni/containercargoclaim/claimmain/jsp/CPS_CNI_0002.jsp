<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0002.jsp
*@FileTitle  :  [CPS_CNI_0002] Find
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
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event.CpsCni0002Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0002Event event = null;
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

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	SignOnUserAccount account = null;

    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0002Event) request.getAttribute("Event");
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

    String cookiesJSessionId="";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int loop = 0; loop < cookies.length; loop++) {
           	if (cookies[loop].getName().equals("JSESSIONID")) {
           		cookiesJSessionId=cookies[loop].getValue();
           	}
        }
    }
    
	/*현재년도*/
	String currYear = "CC"+DateTime.getYear();

	// 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();
%>
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="100" id="pagerows" />
<input type="hidden" name="page_no" value="1" id="page_no" />
<input type="hidden" name="clss_clm_misc_cd" id="clss_clm_misc_cd" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" />
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
	--><button class="btn_normal" name="btn1_Main" id="btn1_Main" type="button">Main</button><!--
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="570px" />
				<col width="50px" />
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td class="sm pad_left_8"><input type="radio" name="sch_cond" value="CLM_NO" class="trans" checked="" id="sch_cond" />  Claim No.   <input type="radio" name="sch_cond" value="BL_NO" class="trans" id="sch_cond" />  B/L   <input type="radio" name="sch_cond" value="CNTR_NO" class="trans" id="sch_cond" />  CNTR   <input type="radio" name="sch_cond" value="VVD" class="trans" id="sch_cond" />  VVD   <input type="radio" name="sch_cond" value="INCI_NO" class="trans" id="sch_cond" />  INC No.   <input type="radio" name="sch_cond" value="VOC_NO" class="trans" id="sch_cond" />  VOC No.   <input type="radio" name="sch_cond" value="INSURER_REF" class="trans" id="sch_cond" />  Insurer Ref.   <input type="radio" name="sch_cond" value="IMS_NO" class="trans" id="sch_cond" />  IMS No.</td>
					<td class="pad_left_12"><input type="text" style="width:170px;ime-mode:disabled" name="sch_str" value="<%=currYear%>" maxlength="30" onkeypress="ComKeyOnlyAlphabet('uppernum')" required="" caption="Data" class="input1" id="sch_str" dataformat="engup" /></td>
					<td><script type="text/javascript">ComComboObject("combo1", 2, 67, 1);</script><!-- 
					 --><input type="hidden" name="misc_cd" value="" id="misc_cd" /><!-- 
					 --><script type="text/javascript">ComComboObject("vt", 2, 57, 1);</script></td>
					<td></td>
				</tr> 
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->

<!-- result_area(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->



</form>