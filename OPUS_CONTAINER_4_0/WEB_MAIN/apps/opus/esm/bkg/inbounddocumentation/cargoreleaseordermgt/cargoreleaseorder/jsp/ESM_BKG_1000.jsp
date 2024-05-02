<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1000
*@FileTitle  : Attorney Register
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1000Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1000Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strOfc_eng_nm    = "";

    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.FullReleaseOrder");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id     = account.getUsr_id();
        strUsr_nm     = account.getUsr_nm();
        strOfc_cd     = account.getOfc_cd();
        strOfc_eng_nm = account.getOfc_eng_nm();

        event = (EsmBkg1000Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

     // getting data from server when load the initial screen
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
        //focuse on customer's name
        document.all.atty_cust_nm.focus();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="insertRow" value='0'>


<div class="layer_popup_title">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Attorney Register</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn"><!-- 
		 	--><button type="button" id="btn1_Retrieve" name="btn1_Retrieve" class="btn_accent">Retrieve</button><!--
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

</div>

<div class="layer_popup_contents">

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60"/>
					<col width="220"/>
					<col width="100"/>
					<col width="*" />				
				</colgroup> 
		   		<tr class="h23">
                    <th>사업자명</th>
                    <td><input type="text" name='atty_cust_nm' id='atty_cust_nm' style="width:140px;" class="input" OnKeyUp="ComKeyEnter('search')"></td>
                    <th>사업자등록번호</th>
                    <td><input type="text" name='atty_biz_no' id='atty_biz_no' style="width:140px;" class="input" caption="사업자번호" int dataformat="saupja" caption="사업자번호" OnKeyUp="ComKeyEnter('search')" maxlength='12'></td>
            	</tr>
        	</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn2_Row_Add" 		id="btn2_Row_Add">Row Add</button>
				<button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button>		
			</div>
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<input type="hidden" name="user_id" value='<%=strUsr_nm%>'>
<input type="hidden" name="user_nm" value='<%=strUsr_nm%>'>
<input type="hidden" name="ofc_cd"  value='<%=strOfc_cd%>'>
<input type="hidden" name="ofc_nm"  value='<%=strOfc_eng_nm%>'>
</form>