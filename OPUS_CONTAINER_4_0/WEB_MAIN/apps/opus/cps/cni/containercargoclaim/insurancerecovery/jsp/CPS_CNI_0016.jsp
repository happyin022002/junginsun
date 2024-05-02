<%/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0016.jsp
*@FileTitle  : [CPS_GEM_0016] Insurance Recovery by VVD 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.event.CpsCni0016Event"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
	String cookiesJSessionId="";
	Cookie[] cookies = request.getCookies();
	  if (cookies != null) {
	      for (int loop = 0; loop < cookies.length; loop++) {
	             if (cookies[loop].getName().equals("JSESSIONID")) {
	                     cookiesJSessionId=cookies[loop].getValue();
	              }
	      }
	}
	CpsCni0016Event event = null;
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
    String xml = HttpUtil.makeXML(request,response);
    SignOnUserAccount account = null;
    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0016Event) request.getAttribute("Event");
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
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    
    // vvd 
    String vvd = CniUtil.getVvd(account);
    if (vvd == null || vvd.trim().length() == 0) {
    	vvd = "";
    }

    if ("Y".equals(popupYn)) {
    	vvd = JSPUtil.getParameter(request , "trnk_ref_vvd_no" , "");		
    }
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();
    
%>

<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="insur_clm_pty_no" id="insur_clm_pty_no" />
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" />
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" />
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" />
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" />
<!-- PRINT  -->
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<% if ("Y".equals(popupYn)) { %>
		<h2 class="page_title"><span id="titles">Insurance Recovery by VVD</span></h2>	
	<% } else { %>
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<% } %>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn1_New"  	id="btn1_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn1_Save" 	id="btn1_Save">Save</button><!--  
	--><button type="button" class="btn_normal" name="btn1_Print" 	id="btn1_Print">Print</button><!--  
	--><% if ("Y".equals(popupYn)) {%><!--  
	--><button type="button" class="btn_normal" name="btn1_close" 	id="btn1_close">Close</button><!--  
	--><% } %></div>
	<% if ("Y".equals(popupYn)) { %>
	<% } else { %>
		<div class="location">
			<span id="navigation"></span>
		</div>
	<% } %>
</div>

	<!-- page_title_area(E) -->

	<!-- opus_design_inquiry(S) -->
	
<!-- opus_design_inquiry(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="80">
				<col width="90">
				<col width="*">
			</colgroup>
			<tr>
                <th title="Vessel Voyage Direction">VVD</th>
                <td><input type="text" style="width:80px;text-align: center;ime-mode:disabled;" dataformat="engup" required fullfill maxlength="9" caption="VVD" class="input1" name="trnk_ref_vvd_no" value="<%=vvd%>" id="trnk_ref_vvd_no" /><input type="text" style="width:60px;text-align: center;ime-mode:disabled;" readonly="readonly" class="input2" name="insur_vsl_oshp_cd" id="insur_vsl_oshp_cd" /></td>
                <th><button type="button" class="btn_etc" name="btn1_FileUpload" 	id="btn1_FileUpload">File Upload</button></th>
                <td>&nbsp;</td>
            </tr>
		</table>
		<table>
			<colgroup>
				<col width="50">
				<col width="520">
				<col width="100">
				<col width="40">
				<col width="100">
				<col width="40">
				<col width="20">
				<col width="*">
			</colgroup>
			<tr>
                <th>Insurer</th>
                <td><input type="text" style="width:80px;text-align: center;" name="insur_clm_pty_abbr_nm" readonly="readonly" class="input2" id="insur_clm_pty_abbr_nm" /><input type="text" style="width:439px;" name="insur_pty_nm" class="input2" id="insur_pty_nm" /></td>
                <th>Policy Year</th>
                <td><input type="text" style="width:41px;text-align: center;" name="insur_plcy_yr" readonly="readonly" class="input2" id="insur_plcy_yr" /> </td>
                <th>Deductible</th>
                <td><input type="text" style="width:80px;text-align: right;" name="ddct_cgo_amt" caption="Deductible" readonly="readonly" class="input1" id="ddct_cgo_amt" /></td>
                <th>USD</th>
                <td>&nbsp;</td>
            </tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
</div>
</form>