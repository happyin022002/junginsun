<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0005.jsp
*@FileTitle  : [CPS_CNI_0005] Manager History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
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
    Exception serverException = null;
    String strErrMsg = "";

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.codemgt.CodeMgtSC");
    
    String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no" , "");
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
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
%>

<script type="text/javascript">
	
	var userOfficeCode = "<%=userOffice%>";  
	 
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="mgr_hdlr_div_cd" id="mgr_hdlr_div_cd">
<input type="hidden" name="usr_id" id="usr_id" value="<%=userId%>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Manager History</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn1_Retrieve" name="btn1_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn1_New" name="btn1_New" class="btn_normal">New</button><!--
		--><button type="button" id="btn1_Save" name="btn1_Save" class="btn_normal">Save</button><!--
		--><button type="button" id="btn1_Close" name="btn1_Close" class="btn_normal">Close</button><!--
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
					<col width="60"/>
					<col width="*" />				
				</colgroup> 
				<tr>
						<th>Claim  No.</th>
						<td><input type="text" style="width:100px;text-align:center" class="input1" maxlength="10" name="cgo_clm_no" id="cgo_clm_no" style="ime-mode:disabled" value="<%=cgoClmNo%>"></td>
					</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		
		<h3 class="title_design">Handler</h3>
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<h3 class="title_design">Manager</h3>
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn2_Row_Add" 		id="btn2_Row_Add">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn2_Row_Delete" 			id="btn2_Row_Delete">Row Delete</button><!-- 		
			 --></div>
			<!-- opus_design_btn(E) -->		
			
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		
		<!-- opus_design_grid(E) -->
	</div>
</form>