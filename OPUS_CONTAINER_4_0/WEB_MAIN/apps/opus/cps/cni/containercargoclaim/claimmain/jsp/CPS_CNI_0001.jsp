<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0001.jsp
*@FileTitle  : [CPS_CNI_0001] Client Default Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
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
	CpsCni0001Event event = null;
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
    String clmAreaCd = "";
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0001Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        clmAreaCd = (String)eventResponse.getCustomData("clmAreaCd");
        
    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    
    String sXml = HttpUtil.makeXML(request,response);
%>

<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event.CpsCni0001Event"%>

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

<!-- 개발자 작업 -->
<input type="hidden" name="sXml" value="<%=sXml%>" id="sXml" />
<input type="hidden" name="popupYn" value="<%=popupYn%>" id="popupYn" />
<input type="hidden" name="clmAreaCd" value="<%=clmAreaCd%>" id="clmAreaCd" />
<input type="hidden" name="vndr_seq" id="vndr_seq">
        
<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><%
  if("Y".equals(popupYn)) {
%>
Client Default Setup
<%
  } 
  else {
%>
<button type="button"><span id="title">Client Default Setup</span></button>
<%
  } 
%></h2> <!-- page_title(E) --> <!-- opus_design_btn (S) --> <div class="opus_design_btn"> <button class="btn_normal" name="btn1_Save" id="btn1_Save" type="button">Save</button><!--

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
				<col width="50px" />
				<col width="50px" />
				<col width="*" />
			</colgroup>
			<tbody>
			<tr class="h23">
                <th>Handling Office </th>
                <td><input type="text" name="ofc_cd" style="width:60px;text-align: center;" value="<%=userOffice%>" readonly="readonly" class="input2" id="ofc_cd" /> </td>
                <td></td>
            </tr>
            <tr class="h23">
                <th>Area</th>
                <td width=""><select style="width:60px;" name="clm_area_cd" onchange="onchangeClmAreaCd()"></select><input type="text" style="width:180;" name="clm_area_nm" readonly="readonly" class="input2"></td>
                <td></td>
            </tr>
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->
</form>
<div style="display: none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
