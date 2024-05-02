<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0999.jsp
*@FileTitle  : Attorney Create Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0999Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0999Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strOfc_nm        = "";

    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.FullReleaseOrder");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        strUsr_id     = account.getUsr_id();
        strUsr_nm     = account.getUsr_nm();
        strOfc_cd     = account.getOfc_cd();
        strOfc_nm     = account.getOfc_eng_nm();

        event = (EsmBkg0999Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

		//when open screen, get data in server..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="insertRow" id="insertRow" value='0'>

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Attorney Create</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_Register" name="btn_Register" class="btn_normal">Register</button><!--
		--><button type="button" id="btn_Save" name="btn_Save" class="btn_normal">Save</button><!--
		--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
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
				<col width="200"/>
				<col width="70"/>
				<col width="160"/>
				<col width="120"/>
				<col width="*" />				
			</colgroup> 
		    <tr>
                   <td class="sm"><strong>고객 Type</strong> <input id="rdo_flag" name="rdo_flag" class="trans" type="radio" /> 수임자   <input id="rdo_flag" name="rdo_flag" class="trans" type="radio" /> 위임자</td>
                   <th>고객명</th>
                   <td><input id="cust_name" style="width:140px;" class="input" name="cust_name" type="text" /><button class="input_seach_btn" name="pop_attorney" id="pop_attorney" type="button"></button></td>
                   <th>사업자등록번호</th>
                   <td><input id="cust_biz_no" style="width:140px;" class="input" name="cust_biz_no" maxlength="12" value="<%=JSPUtil.getNull(request.getParameter(" cust_biz_no")) %>" type="text"></td>
               </tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_grid">	
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_Row_Add" name="btn_Row_Add" class="btn_accent">Row Add</button><!--
			--><button type="button" id="btn_Row_Copy" name="btn_Row_Copy" class="btn_normal">Row Copy</button><!--
			--><button type="button" id="btn_Row_Delete" name="btn_Row_Delete" class="btn_normal">Row Delete</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>	
</div>
<input type="hidden" name="user_id" id="user_id" value='<%=strUsr_nm%>'>
<input type="hidden" name="user_nm" id="user_nm" value='<%=strUsr_nm%>'>
<input type="hidden" name="ofc_cd" id="ofc_cd"  value='<%=strOfc_cd%>'>
<input type="hidden" name="ofc_nm" id="ofc_nm"  value='<%=strOfc_nm%>'>
<input type="hidden" name="atty_cust_nm" id="atty_cust_nm">
<!-- Developer Work End -->
</form>
