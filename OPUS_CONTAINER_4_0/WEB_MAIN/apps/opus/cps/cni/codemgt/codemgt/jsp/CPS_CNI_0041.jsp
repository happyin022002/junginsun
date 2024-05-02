<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0041.jsp
*@FileTitle  : [CPS_CNI_0041] Main Code-Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
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
<%@page import="com.clt.apps.opus.cps.cni.codemgt.codemgt.event.CpsCni0026Event"%>
<%
	CpsCni0026Event event = null;
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
    
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0026Event) request.getAttribute("Event");
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
    String clmPtyNo = JSPUtil.getParameter(request , "clm_pty_no" , "");
    
    
%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%><html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script type="text/javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage(year);
	}
</script>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="clm_pty_no" value="<%=clmPtyNo%>" id="clm_pty_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Main Code-Inquiry Popup</span>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn1_New" id="btn1_New">New</button><!--
		 --><button type="button" class="btn_normal" name="btn1_Select" id="btn1_Select">Select</button><!-- 
		  --><button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
</div>
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="55">
				<col width="110">
				<col width="120">
				<col width="*">
			</colgroup>
                <tr>
                    <th>Code</th>
                    <td><input type="text" style="width:110px;text-align: center;ime-mode:disabled;" name="clm_pty_abbr_nm" id="clm_pty_abbr_nm" dataformat="engup" otherchar=" +,.%" maxlength="8" value="" class="input"></td>
                    <th>Name</th>
                    <td><input type="text" style="width:180px;" name="pty_nm" id="pty_nm" value="" class="input" maxlength="100"></td>
                </tr>
                <tr>
                    <th>Register</th>
                    <td><input type="text" style="width:110px;" name="cre_usr_id" id="cre_usr_id" value="" class="input" maxlength="60"></td>
                    <th>RGOFC</th>
                    <td><input type="text" style="width:110px;ime-mode:disabled;text-align: center;" name="cre_ofc_cd" id="cre_ofc_cd" dataformat="engup" class="input" maxlength="20"></td>
                </tr>                
                <tr>
                    <th>Location</th>
                    <td><input type="text" style="width:70px;text-align: center;ime-mode:disabled;" name="loc_cd" id="loc_cd"  dataformat="engup" maxlength="5" class="input"><button type="button" name="btns_location" id="btns_location" class="input_seach_btn" onClick="openPopup('cust_cd')"></button></td>
                    <th>Deleted Code</th>
                    <td><input name="delt_flg" type="checkbox" value="Y" class="trans"></td>
                </tr>
                </tbody>
           </table>
 		</div>
</div>
<div class="wrap_result">                
     <div class="opus_design_grid clear"  >
         <script type="text/javascript">ComSheetObject('sheet1');</script>
         </div>
    </div>
  </form>