<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0042.jsp
*@FileTitle  : CCC VVD & SKD Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
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
<%@page import="com.clt.apps.opus.cps.cni.codemgt.codemgt.event.CpsCni0042Event"%>
<%
	CpsCni0042Event event = null;
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

        event = (CpsCni0042Event) request.getAttribute("Event");
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
    String trnkRefVvdNo = JSPUtil.getParameter(request , "trnk_ref_vvd_no" , "");



%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%><html>
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>VVD & SKD Inquiry Popup</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_Retrieve" 	id="btn1_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn1_New" 	id="btn1_New">New</button><!--  
		--><button type="button" class="btn_normal" >Select</button><!--  
		--><button type="button" class="btn_normal" name="btn1_Close" 	id="btn1_Close">Close</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />
				<col width="100" />
				<col width="50" />
				<col width="60" />
				<col width="50" />
				<col width="*" />
				
			</colgroup>
			<tbody>
				<tr>                    
                    <th title="Vessel Voyage Direction">VVD</th>
                    <td><!-- 
	                    --><input type="text" style="width:90px;text-align: center;ime-mode:disabled;" fullfill="" dataformat="engup" required="" maxlength="9" caption="VVD" name="trnk_ref_vvd_no" value="<%=trnkRefVvdNo%>" class="input1" id="trnk_ref_vvd_no" /><!-- 
	                    --><input type="hidden" name="vsl_cd" id="vsl_cd" /><!-- 
	                    --><input type="hidden" name="skd_voy_no" id="skd_voy_no" /><!-- 
	                    --><input type="hidden" name="skd_dir_cd" id="skd_dir_cd" /></td>
                    <th title="Port of Loading">POL</th>
                    <td><input type="text" name="pol" maxlength="5" style="width:50px;text-align: center;ime-mode:disabled;" dataformat="engup" class="input" id="pol" /><button type="button" id="btns_pol" name="btns_pol" class="input_seach_btn"></button></td>
                    <th title="Port of Discharging">POD</th>
                    <td><input type="text" name="pod" maxlength="5" style="width:50px;text-align: center;ime-mode:disabled;" dataformat="engup" class="input" id="pod" /><button type="button" id="btns_pod" name="btns_pod" class="input_seach_btn"></button></td>
                </tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>			
</form>