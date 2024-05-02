<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0021.jsp
*@FileTitle  : [CPS_CNI_0021] Occurrence Analysis
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.event.CpsCni0021Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
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
	CpsCni0021Event event = null;    
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
    
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaimreport.ContainerCargoClaimReportSC");
    SignOnUserAccount account = null;
    String xml = HttpUtil.makeXML(request,response);
    
    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0021Event) request.getAttribute("Event");
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

    
%>
<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


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
<input type="hidden" name="sXml" id="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="100" id="pagerows" />
<input type="hidden" name="page_no" value="1" id="page_no" />
 <input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
 
<!-- 개발자 작업 -->

<!-- PRINT  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />

<input type="hidden" name="usr_id" id="usr_id" value="<%=userId%>" />
<input type="hidden" name="usr_roles" id="usr_roles"  value="<%=roles%>" />
<input type="hidden" name="usr_area" id="usr_area"  value="<%=area%>" />
<input type="hidden" name="usr_office"  id="usr_office" value="<%=ofcCd%>" />

<!-- 조회조건  -->
<input type="hidden" name="report_by" value="0" id="report_by" />
<input type="hidden" name="schFromStrGmt" id="schFromStrGmt" />
<input type="hidden" name="schToStrGmt" id="schToStrGmt" />
<!--RD 를 위한변수-->
<input type="hidden" name="rd_title" value="" id="rd_title" />
<input type="hidden" name="rd_title_nm" value="" id="rd_title_nm" />
<input type="hidden" name="rd_report_by" value="" id="rd_report_by" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_New" id="btn1_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_DownExcel" id="btn1_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Print" id="btn1_Print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
 <!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
<div class= "opus_design_inquiry wFit">
	<!-- layout_wrap(S) -->
      <table>
		<tbody>
			<colgroup>
				<col width="50">
				<col width="145">
				<col width="45">
				<col width="97">
				<col width="*">
			</colgroup>       
			<tr class="h23">
				<th>Report by</th>
				<td><script type="text/javascript">ComComboObject("combo1", 1, 220, 1);</script></td>
				<th>Period</th>
				<td>
					<script type="text/javascript">ComComboObject("period", 2, 80, 1);</script><!-- 
					 --><input type="text" value="" name="from_period" class="input1" style="width:75px;ime-mode:disabled;text-align:center" required  dataformat="ymd"  caption="Period(From Date)" id="from_period" /><!-- 
					 --><button type="button" class="calendar ir" name="btns_from_period" id="btns_from_period"></button>~<!-- 
					 --><input type="text" value="" name="to_period" style="width:75px;ime-mode:disabled;text-align:center" class="input1" required dataformat="ymd"  caption="Period(To Date)" id="to_period" /><!-- 
					 --><button type="button" class="calendar ir" name="btns_to_period" id="btns_to_period"></button>
				</td>
				<td>
					<input name="rdbtn" type="radio" value="0" class="trans" checked id="rdbtn" /><label for="rdbtn"><strong>POL - POD</strong></label><!-- 
					 --><input name="rdbtn" type="radio" value="1" class="trans" id="rdbtn" /><label for="rdbtn"><strong>POR - DEL</strong></label>
					</td>
			</tr>
			</tbody>
			</table> 
		</div>
	</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<div id="tbl1" style="display:;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
		<div id="tbl2" style="display: none;"><script type="text/javascript">ComSheetObject('sheet2');</script></div>
	</div>
</div>
         
</div>
</form>
	