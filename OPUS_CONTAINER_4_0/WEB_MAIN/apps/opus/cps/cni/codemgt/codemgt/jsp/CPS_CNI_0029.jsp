<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0029.jsp
 *@FileTitle : [CPS_CNI_0029] Miscellaneous Code Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.19
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.10.19 박제성
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.10.11 이준범[] 버튼 색상 변경 (붉은색 -> 검정색 ) 
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
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.codemgt.codemgt.event.CpsCni0029Event"%>
<%
	CpsCni0029Event event = null;
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
        
        event = (CpsCni0029Event) request.getAttribute("Event");
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
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    
    String clssClmMiscCd = JSPUtil.getParameter(request , "clss_clm_misc_cd" , "");
    
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

<% if ("Y".equals(popupYn)) {%>
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<input type="hidden" name="clss_clm_misc_cd" value="<%=clssClmMiscCd%>">
<input type="hidden" name="popupYn" value="<%=popupYn%>">
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
        
       <% } else { %>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<input type="hidden" name="clss_clm_misc_cd" value="<%=clssClmMiscCd%>">
<input type="hidden" name="popupYn" value="<%=popupYn%>">
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>       
        <% } %>  
 <% if ("Y".equals(popupYn)) { %>
 <div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title"><span >Miscellaneous Code</span></h2>
        <div class="opus_design_btn">
			<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
			--><button class="btn_normal" name="btn1_Print" id="btn1_Print" type="button">Print</button><!--
			--><button class="btn_normal" name="btn1_Select" id="btn1_Select" type="button">Select</button><!--
			--><button class="btn_normal" name="btn1_Close" id="btn1_Close" type="button">Close</button><!--
			--></div>
</div>
        <% } else { %>
<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        	<div class="opus_design_btn">
			<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
			--><button class="btn_normal" name="btn1_Print" id="btn1_Print" type="button">Print</button><!--
			--></div>  
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
        <% } %>        
 <div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Class</th>
					<td><script type="text/javascript">ComComboObject("combo1", 1, 200, 1, 0, 0, false);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Code</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_misc_cd" value="" dataformat = "engup" maxlength="6" class="input" id="clm_misc_cd" /> </td>
					<th>Name</th>
					<td><input type="text" style="width:200px;text-align:center" name="clm_misc_nm" value="" maxlength="30" class="input" id="clm_misc_nm" /> </td>
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
		<!-- opus_design_btn (S) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
</form>       
 