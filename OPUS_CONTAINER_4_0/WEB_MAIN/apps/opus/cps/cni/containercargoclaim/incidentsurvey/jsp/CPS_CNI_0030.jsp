<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0030.js
*@FileTitle  : Incident-Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0030Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0030Event event = null;
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

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	
	SignOnUserAccount account = null;

    try
    {

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0030Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		reqCgoClmInciNo  = JSPUtil.getParameter(request, "cgo_clm_inci_no","");


    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
    //roles = "CNI03";
    //area =  "E";
    //ofcCd = "SELHO";
    //userId = "2001702";    
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
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="clss_clm_misc_cd" id="clss_clm_misc_cd" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<input type="hidden" name="cgo_clm_inci_no_old" value="" id="cgo_clm_inci_no_old" />

<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" />
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" />
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" />
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" />

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
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
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="70" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Incident No.</th>
					<td><input type="text" name="cgo_clm_inci_no" style="width:110px;text-align:center;ime-mode:disabled" value="<%=reqCgoClmInciNo%>" caption="Incident No" maxlength="13" dataformat="engup" class="input1" id="cgo_clm_inci_no" /> </td>
					<th>Area</th>
					<td><input type="text" name="clm_area_cd" style="width:30px;text-align:center" value="" class="input2" readonly id="clm_area_cd" /> </td>
					<th title="Register Office">RGOFC</th>
					<td><input type="text" name="cre_ofc_cd" style="width:85px;text-align:center" value="" class="input2" readonly id="cre_ofc_cd" /> </td>
					<th>Register</th>
					<td><input type="text" name="cre_usr_id" style="width:80px;text-align:center" value="" class="input2" readonly id="cre_usr_id" /> </td>
					<th title="Date of Register">DORG</th>
					<td><input type="text" name="cre_dt" dataformat="ymd" style="width:80px;text-align:center" value="" class="input2" readonly id="cre_dt" /> </td>
					<th title="Date Of Updated">DOU</th>
					<td><input type="text" name="upd_dt" dataformat="ymd" style="width:80px;text-align:center" value="" class="input2" readonly id="upd_dt" /> </td>
					<td></td>
				</tr>
				<tr>
					<th title="Place of Incident">POI</th>
					<td><script type="text/javascript">ComComboObject("combo1", 2, 110, 1);</script><input type="hidden" name="inci_plc_tp_cd" value="" id="inci_plc_tp_cd" /> </td>
					<th title="Date of Incident">DOI</th>
					<td><input type="text" name="inci_occr_dt" style="width:77px;text-align:center; ime-mode:disabled" required="" caption="DOI" dataformat="ymd" maxlength="10" value="" class="input1" id="inci_occr_dt" /><button type="button" id="btns_date_cal" name="btns_date_cal" class="calendar ir"></button></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="inci_ref_vvd_no" style="width:85px;text-align:center" value="" maxlength="20" class="input" id="inci_ref_vvd_no" dataformat="engup"  /><button type="button" id="btns_vvd" name="btns_vvd" class="input_seach_btn"></button></td>
					<th>Location</th>
					<td><input type="text" name="inci_loc_cd" style="width:80px;text-align:center" value="" class="input" caption="Location" maxlength="5" id="inci_loc_cd" dataformat="engup" /><button type="button" id="btns_location" name="btns_location" class="input_seach_btn"></button></td>
			    </tr>
			</tbody>
		</table>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Subject</th>
					<td><input type="text" name="inci_subj_nm" style="width:398px;" value="" required="" maxlength="100" class="input1" caption="Subject" id="inci_subj_nm" /> </td>
					<td><div class="opus_design_btn"><button class="btn_etc" name="btn1_File_Upload" id="btn1_File_Upload" type="button">File Upload</button></div></td>
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
		<h3 class="title_design">Outline of Incident</h3>
		<table>
			<tr>
				<td><textarea style="width:100%" name="inci_dev_desc" id="inci_dev_desc" rows="26" required="" class="textarea1" caption="Outline of Incident"></textarea></td>
			</tr>
		</table>
		<div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>
