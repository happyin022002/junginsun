<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : CPS_CNI_0095.jsp
*@FileTitle  : [CPS_CNI_0095] Main Code-Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
* -----------------------------------------------------------------
* History
* 2010.12.10 이준범 [CHM-201007236-01]
* 1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
* 2.처리내역
*  2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
*      그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
*      information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완 
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
<%@ page import="com.clt.apps.opus.cps.cni.codemgt.codemgt.event.CpsCni0095Event"%>
<%
	CpsCni0095Event event = null;
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
    String clmPtyAbbrNm= "";
    String ptyNm = "";
    
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.codemgt.CodeMgtSC");
    
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0095Event) request.getAttribute("Event");
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
    // claim party no    
    clmPtyAbbrNm = JSPUtil.getParameter(request , "clm_pty_abbr_nm" , "");
    ptyNm        = JSPUtil.getParameter(request , "pty_nm" , "");
    
%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%><html>


<script language="javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage(year);
	}
</script>
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>


<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">

<input type="hidden" name="clm_pty_abbr_nm" value="<%=clmPtyAbbrNm%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Main Code- Popup</span></h2>
		
		<div class="opus_design_btn">
		  	<button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button>
		</div>
	</div>
</div>


<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
				<tr class="h23">
                    <td width="40">Name</td>
                    <td><input type="text" style="width:180;" name="pty_nm" value="<%=ptyNm%>" class="input2" readonly="readonly" maxlength="100"></td>
                </tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn2_Save" id="btn2_Save">Save</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>
