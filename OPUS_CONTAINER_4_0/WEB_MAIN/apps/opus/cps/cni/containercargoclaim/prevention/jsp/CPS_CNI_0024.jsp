<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0024.jsp  
*@FileTitle  : Prevention-View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
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

<%
	CpsCni0023Event event = null;
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

        event = (CpsCni0023Event) request.getAttribute("Event");
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


    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------  
    String sXml = HttpUtil.makeXML(request,response);
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    String year = DateTime.getYear()+"";
    String clmPrveNo = JSPUtil.getParameter(request , "clm_prve_no" , "PRV"+year);
    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    String effDt = (String)eventResponse.getCustomData("eff_dt");
    String clmAreaCd = (String)eventResponse.getCustomData("clm_area_cd");
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
<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.prevention.event.CpsCni0023Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%><html>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="sXml" value="<%=sXml%>" id="sXml" />
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" />
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" />
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" />
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" />
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<!-- 개발자 작업 -->
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>

<input type="hidden" name="popupYn" value="<%=popupYn%>" id="popupYn" />

<% if ("Y".equals(popupYn)) {%><div class="layer_popup_title"><% } %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
   <% if ("Y".equals(popupYn)) { %>
	<h2 class="page_title"><span>Prevention-View</span></h2>
	<% } else { %>
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<% } %>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_Retrieve" 	id="btn1_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn1_New" id="btn1_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn1_Print" id="btn1_Print">Print</button><!--
		--><% if ("Y".equals(popupYn)) {%><button type="button" class="btn_normal" name="btn1_close" id="btn1_close">Close</button><% } %><!--
	--></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<% if ("Y".equals(popupYn)) {%></div><% } %>
<% if ("Y".equals(popupYn)) {%><div class="layer_popup_contents"><% } %>	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="55" />
					<col width="140" />
					<col width="50" />
					<col width="220" />
					<col width="55" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
		                <th>PRV No.</th>
		                <td><input type="text" style="width:100px;text-align: center;" dataformat="engup" required="" maxlength="11" name="clm_prve_no" caption="PRV No." value="<%=clmPrveNo%>" class="input1" id="clm_prve_no" /></td>
		                <th>CLASS</th>
		                <td><input type="text" name="clm_prve_div_nm" style="width:180px;" class="input2" readonly="readonly" id="clm_prve_div_nm" /></td>
		                <th>Effective</th>
		                <td><input type="text" style="width:80px;text-align: center;" name="eff_dt" class="input2" readonly="readonly" id="eff_dt" />~ <!-- 
		                 --><input type="text" style="width:80px;text-align: center;" name="exp_dt" class="input2" readonly="readonly" id="exp_dt" /></td>
		            </tr>
		            <tr>
		                <th>Register</th>
		                <td><input type="text" style="width:100px;text-align: center;" name="cre_usr_id" class="input2" readonly="readonly" id="cre_usr_id" /> </td>
		                <th>Area</th>
		                <td><input type="text" style="width:25px;text-align: center;" name="clm_area_cd" class="input2" readonly="readonly" id="clm_area_cd" /> </td>
		                <th>RGOFC</th>
		                <td><input type="text" style="width:80px;text-align: center;" name="cre_ofc_cd" class="input2" readonly="readonly" id="cre_ofc_cd" /> </td>
		            </tr>
		            <tr>
		                <th>Subject</th>
		                <td colspan="5"><input type="text" style="width:680px;" maxlength="200" name="clm_prve_subj_nm" class="input2" readonly="readonly" id="clm_prve_subj_nm" /> </td>
		            </tr>   
				</tbody>
			</table>
			</div>	
			<table class="line_bluedot"><tr><td></td></tr></table>
			
			<div class= "opus_design_inquiry wFit">
			<table class="grid_2"> 
                <tr><td><textarea style="width:100%; resize:none;" rows="15" name="clm_prve_desc" id="clm_prve_desc" class="textarea2"></textarea></td></tr>
            </table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
<% if ("Y".equals(popupYn)) {%></div><% } %>
</form>

<form name="form1" method="post">
</form>