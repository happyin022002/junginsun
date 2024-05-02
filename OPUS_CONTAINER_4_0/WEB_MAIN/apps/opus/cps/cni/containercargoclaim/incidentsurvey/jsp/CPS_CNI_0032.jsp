<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0032.jsp
*@FileTitle  : [CPS_CNI_0032] Incident-Claim Inquiry
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
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0032Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0032Event event = null;
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
	String schToStrGmt = "";//조회조건의 to날짜(GMT)

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	SignOnUserAccount account = null;

    try
    {

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0032Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		reqCgoClmInciNo  = JSPUtil.getParameter(request, "cgo_clm_inci_no","");

		schToStrGmt = eventResponse.getETCData("schToStr").substring(0,4);

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
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");

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
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="100" id="pagerows" />
<input type="hidden" name="page_no" value="1" id="page_no" />

<!-- 개발자 작업 -->
<!-- POPUP 용도로 사용시 -->

<input type="hidden" name="popupYn" value="<%=popupYn%>" id="popupYn" />
<!-- GMT 설정 -->
<input type="hidden" name="schToStrGmt" value="<%=schToStrGmt%>" id="schToStrGmt" />
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" />
<!-- rd 파라미터를 위한 session 값 -->
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
 <% if ("Y".equals(popupYn)) { %>
 	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title">Claim Find Popup</h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!--
			--><button class="btn_normal" type="button" name="btn1_New" id="btn1_New" >New</button><!--
			--><button class="btn_normal" type="button" name="btn1_Down_Excel" id="btn1_Down_Excel" >Down Excel</button><!--
			--><button class="btn_normal" type="button" name="btn1_Print" id="btn1_Print" >Print</button><!--
			--><button class="btn_normal" type="button" name="btn1_close" id="btn1_close" >Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
 
 <% } else { %>
		<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!--
			--><button class="btn_normal" type="button" name="btn1_New" id="btn1_New" >New</button><!--
			--><button class="btn_normal" type="button" name="btn1_Down_Excel" id="btn1_Down_Excel" >Down Excel</button><!--
			--><button class="btn_normal" type="button" name="btn1_Print" id="btn1_Print" >Print</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
	<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
 <% } %>
 
 
 <div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="100"/>
				<col width="20"/>
				<col width="90"/>
				<col width="40"/>
				<col width="50"/>
				<col width="60"/>
				<col width="60"/>
				<col width="40"/>
				<col width="90"/>
				<col width="30"/>
				<col width="*"/>
			</colgroup>
		   <tbody>
		   		<tr>
		   			<th>Incident No.</th>
					<td><input type="text" name="cgo_clm_inci_no" style="width:100px;ime-mode:disabled" value="<%=reqCgoClmInciNo%>" class="input1" maxlength="13" id="cgo_clm_inci_no" onblur="cgo_clm_inci_no_onblur();"/> </td>
					<th>Area</th>
					<td><input type="text" name="clm_area_cd2" style="width:21px;text-align:center" value="" class="input2" readonly id="clm_area_cd2" /> </td>
					<th title="Register Office Code">RGOFC</th>
					<td><input type="text" name="cre_ofc_cd" style="width:50px;text-align:center" value="" class="input2" readonly id="cre_ofc_cd" /> </td>
					<th>Register</th>
					<td><input type="text" name="cre_usr_id" style="width:80px;text-align:center" value="" class="input2" readonly id="cre_usr_id" /> </td>
					<th title="Date Of Registration">DORG</th>
					<td><input type="text" name="cre_dt" style="width:80px;text-align:center" value="" class="input2" readonly id="cre_dt" /> </td>
					<th title="Date Of Updated">DOU</th>
					<td><input type="text" name="upd_dt2" style="width:80px;text-align:center" value="" class="input2" readonly id="upd_dt2" /> </td>
		   		</tr>
		   		<tr>
		   		<th title="Place Of Incident">POI</th>
					<td><input type="text" name="inci_plc_tp_cd" style="width:40px;text-align:center" value="" class="input2" readonly id="inci_plc_tp_cd" /> </td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="inci_ref_vvd_no" style="width:80px;text-align:center" value="" class="input2" readonly id="inci_ref_vvd_no" /> </td>
					<th>Location</th>
					<td><input type="text" name="inci_loc_cd" style="width:50px;text-align:center" value="" class="input2" readonly id="inci_loc_cd" /> </td>
					<th title="Date Of Incident">DOI</th>
					<td colspan="5"><input type="text" name="inci_occr_dt" style="width:80px;text-align:center" value="" class="input2" readonly id="inci_occr_dt" /> </td>
		   		</tr>
		   		<tr>
					<th>Subject</th>
					<td colspan="11"><input type="text" name="inci_subj_nm" style="width:481px;" value="" class="input2" id="inci_subj_nm" /> </td>
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
