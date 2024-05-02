<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0031.jsp
*@FileTitle  :  [CPS_CNI_0031] Incident-Inquiry
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
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0031Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryCondVO"%>
<%
	CpsCni0031Event event = null;
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
	String userCgoClmNo = "";//session claimNo 변수
	String reqCgoClmInciNo = "";
	String schFromStrGmt = "";
	String schToStrGmt = "";//조회조건의 to날짜(GMT)

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);

	IncidentInquiryCondVO condVO= null;
	SignOnUserAccount account = null;
    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0031Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		reqCgoClmInciNo  = JSPUtil.getParameter(request, "cgo_clm_inci_no","");
		schFromStrGmt = eventResponse.getETCData("schToStr").substring(0,4) + "-01" + "-01";
		schToStrGmt = eventResponse.getETCData("schToStr");
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
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
%>
<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%>
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
<!-- rd 파라미터를 위한 session 값 -->
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
<!-- 조회조건  -->
<input type="hidden" name="schFromStrGmt" value="<%=schFromStrGmt%>" id="schFromStrGmt" />
<input type="hidden" name="schToStrGmt" value="<%=schToStrGmt%>" id="schToStrGmt" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
			--><button class="btn_normal" name="btn1_Down_Excel" id="btn1_Down_Excel" type="button">Down Excel</button><!--
			--><button class="btn_normal" name="btn1_Print" id="btn1_Print" type="button">Print</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<div class="location">	
		<span id="navigation"></span>
		</div>
	</div>	
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="145">				
				<col width="30">				
				<col width="90">				
				<col width="146">				
				<col width="35">				
				<col width="139">				
				<col width="44">				
				<col width="80">				
				<col width="55">				
				<col width="*">				
		   </colgroup>
		   <tbody>
		   		<tr>
		   			<td class="sm pad_left_4"><input type="radio" name="sch_cond" id="sch_cond" value="INCI_NO" class="trans" checked checked="checked">&nbsp;&nbsp;<b>Incident No.</b>&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_cond" id="sch_cond" value="VVD" class="trans">&nbsp;&nbsp;<b>VVD</b> <input type="hidden" name="sch_cond_chk" id="sch_cond_chk" value=""><!--RD 를 위한변수--></td>
		   			<td></td>
					<td><input type="text" name="sch_str" id="sch_str" style="width:120px;" dataformat="engup" value="<%=reqCgoClmInciNo%>" class="input"></td>
					<td><button class="btn_etc" name="btn2_Claim_Search" id="btn2_Claim_Search" type="button">Claim Find</button></td>
					<th>Area</th>
					<td><script type="text/javascript">ComComboObject("combo1", 2, 67, 1);</script><input type="hidden" name="sch_area" value=""></td>
					<th title="Register Office Code">RGOFC</th>
					<td><input type="text" name="sch_ofc_cd" style="width:57px;text-align:center" dataformat="engup" value="" class="input" id="sch_ofc_cd" /> </td>
					<th>Register</th>
					<td><input type="text" name="sch_cre_usr_id" style="width:84px;text-align:center" value="" class="input" id="sch_cre_usr_id" /> </td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="35">				
				<col width="97">				
				<col width="75">				
				<col width=115>
				<col width="152">
				<col width="10">				
				<col width="*">	
			</colgroup>
			<tr>
				<th title="Place Of Incident">&nbsp;&nbsp;POI</th><!-- combo2 -->
				<td><script type="text/javascript">ComComboObject("combo2", 2, 67, 1);</script><input type="hidden" name="sch_plc_tp_cd" value=""></td>
				<th>Location</th>
				<td><input type="text" name="sch_loc_cd" dataformat="engup" style="width:60px;text-align:center" value="" class="input" id="sch_loc_cd" /><!--
				--><button type="button" id="btns_location" name="btns_location" class="input_seach_btn"></button></td>
				<td class="sm pad_left_4"><input type="radio" name="sch_duration" value="DOI" class="trans" checked title="Date Of Incident">&nbsp;&nbsp;<b>DOI</b>&nbsp;&nbsp;&nbsp;<input type="radio" name="sch_duration" value="DORG" class="trans" title="Date of Register">&nbsp;&nbsp;<b>DORG</b> <input type="hidden" name="sch_duration_chk" value=""><!--RD 를 위한변수--></td>
				<td></td>
				<td><input type="text" name="sch_from_str" style="width:80px;text-align:center" value="<%=schFromStrGmt%>" dataformat="ymd" maxlength="10" required="" class="input1" id="sch_from_str" /><!--
				--><button type="button" id="btns_date_cal1" name="btns_date_cal1" class="calendar ir"></button><!--
				-->~ <!--
				--><input type="text" name="sch_to_str" style="width:80px;text-align:center" value="<%=schToStrGmt%>" dataformat="ymd" maxlength="10" required="" class="input1" id="sch_to_str" /><!--
				--><button type="button" id="btns_date_cal2" name="btns_date_cal2" class="calendar ir"></button></td>
			</tr>
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
	
	<h3 class="title_design">Outline of Incident</h3>
	<textarea name="inci_dev_desc" style="width:100%" rows="10" class="textarea"></textarea>
</div>
</form>
