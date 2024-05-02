<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0043.jsp
*@FileTitle  : Impending TB Claim
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event.CpsCni0043Event"%>
<%
    CpsCni0043Event  event = null;
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
    
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
    
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0043Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }


    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    String currDt = (String)eventResponse.getCustomData("curr_dt");
    
    
%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%>

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
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Impending TB Claim</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn1_Detail" id="btn1_Detail" type="button">Detail</button><!--
		--><button class="btn_normal" name="btn1_Close" id="btn1_Close" type="button">Close</button>
	</div>
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
			<tbody>
				<colgroup>
					<col width="225">
					<col width="*">
				</colgroup>
				<tr>
                    <th>Time Bar Claims Within 15 days From </th>
                    <td><input type="text" style="width:80px;text-align: center;" name="tb_dt" id="tb_dt" class="input2" value="<%=currDt%>"></td>                    
                </tr>
                <tr>
                    <td width="" colspan="2">
                        <table class="search_sm" style="width:300px;"> 
	                        <tr class="h23">
	                            <th width="30" class="sm">For</th>
	                            <td class="sm">
	                            	<input type="radio" class="trans" name="cond_for" value="1" checked="checked">Handler&nbsp;&nbsp;
		                            <input type="radio" name="cond_for" value="2" class="trans">HOFC&nbsp;&nbsp;
		                            <input type="radio" name="cond_for" value="3" class="trans">Area &nbsp;&nbsp;
		                            <input type="radio" name="cond_for" value="4" class="trans">All</td>
	                        </tr>
                        </table>
                    </td>
                </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<h3 class="title_design">Main Claim</h3>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<div class="wrap_result">
	<h3 class="title_design">Indemnity Claim</h3>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
