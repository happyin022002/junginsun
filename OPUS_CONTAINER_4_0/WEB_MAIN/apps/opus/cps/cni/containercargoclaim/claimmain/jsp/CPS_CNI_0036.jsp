<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0036.jsp
*@FileTitle  : [CPS_CNI_0036] Transfer
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
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event.CpsCni0036Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0036Event event = null;
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
	String schFromDate = "";
	String schToDate = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	SignOnUserAccount account = null;

    try
    {

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0036Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		schFromDate = eventResponse.getETCData("schFromDate");
		schToDate = eventResponse.getETCData("schToDate");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }

    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 

    //roles = "CNI19";
    //area =  "E";
    //ofcCd = "GOABB";
    //userId = "003997933"; 
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="100" id="pagerows" />
<input type="hidden" name="page_no" value="1" id="page_no" />

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

<!--RD 를 위한변수-->
<input type="hidden" name="sch_date_div_chk" value="" id="sch_date_div_chk" />
<input type="hidden" name="sch_trns_auth_cd_chk" value="" id="sch_trns_auth_cd_chk" />
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
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
	--><button class="btn_normal" name="btn1_Down_Excel" id="btn1_Down_Excel" type="button">Down Excel</button><!--
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

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="47" />				
				<col width="170" />				
				<col width="55" />				
				<col width="140" />				
				<col width="100" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
	   			<th>&nbsp;&nbsp;HOFC</th>
				<td><input type="text" name="sch_ofc_cd" style="width:100px;text-align:center" value="<%=userOffice%>" class="input" caption="HOFC" dataformat="engup" id="sch_ofc_cd" /> </td>
				<th>Handler</th>
				<td><input type="text" name="sch_usr_id" style="width:100px;text-align:center" value="<%=userId%>" class="input" caption="Handler" dataformat="eng" otherchar="&-,._" id="sch_usr_id" /> </td>
				<td class="sm pad_left_4"><input type="radio" name="sch_date_div" value="T" class="trans" checked id="sch_date_div" />  <b>Transferred</b>    <input type="radio" name="sch_date_div" value="P" class="trans" id="sch_date_div" /><b>Processed</b></td>
				<td class="sm"><!--
				--><input type="text" name="sch_date_from" style="width:80px;text-align:center" value="<%=schFromDate%>" dataformat="ymd" maxlength="10" class="input1" required="" caption="From Date" id="sch_date_from" /><!--
				--><button type="button" id="btns_date_cal1" name="btns_date_cal1" class="calendar ir" ></button><!--
				-->~ <input type="text" name="sch_date_to" style="width:80px;text-align:center" value="<%=schToDate%>" dataformat="ymd" maxlength="10" class="input1" required caption="To Date" id="sch_date_to" /><!--
				--><button type="button" id="btns_date_cal2" name="btns_date_cal2" class="calendar ir"></button></td>
				<td></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="47" />
				<col width="325" />				
				<col width="*" />		
			</colgroup>
			<tr>
				<th class="sm pad_left_4">Status</th>
				<td class="sm"><input type="radio" name="sch_trns_auth_cd" value="W" class="trans" checked="" id="sch_trns_auth_cd" />  Waiting   <input type="radio" name="sch_trns_auth_cd" value="A" class="trans" id="sch_trns_auth_cd" />  Accepted   <input type="radio" name="sch_trns_auth_cd" value="R" class="trans" id="sch_trns_auth_cd" />  Rejected   <input type="radio" name="sch_trns_auth_cd" value="" class="trans" id="sch_trns_auth_cd" />  All </td>
				<td></td>
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
</div>
</form>
