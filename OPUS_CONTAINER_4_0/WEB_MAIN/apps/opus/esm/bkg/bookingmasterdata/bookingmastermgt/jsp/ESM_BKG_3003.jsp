<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_3003.jsp
*@FileTitle  : BL Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/03
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg3003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg3003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String calllFunc = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg3003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		calllFunc  = JSPUtil.getParameter(request, "func");

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
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">


<!-- layer_popup_title(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear" >
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>BL Group Inquiry</span>
        </h2>
        <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn"><!--
		    --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		    --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!--
		    --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
	    --></div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		    <table>
		         <colgroup>
		            <col width="150" />
		            <col width="210" />
		            <col width="150" />
		            <col width="*" />
		        </colgroup> 
		        <tbody>
					<tr>
						<th>BL Group Name</th>
						<td><input type="text" style="width:200px; ime-mode:abled" name="bl_grp_nm" class="input"></td>
						<th>BL Group Description</th>
						<td><input type="text" style="width:200px; ime-mode:abled" name="bl_grp_desc" class="input" ></td>
					</tr>
					
				</tbody>
			</table>
	</div>
</div>


<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
</div>
</div>

</form>