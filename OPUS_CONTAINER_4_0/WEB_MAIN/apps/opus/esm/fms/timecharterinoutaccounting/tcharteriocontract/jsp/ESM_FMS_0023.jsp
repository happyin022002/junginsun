<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0023.jsp
*@FileTitle  : Contract No
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException = null;			//Error from Server
	String strErrMsg = "";	

	String usrId = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	usrId = account.getUsr_id();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>
<%
    String vsl_cd 	= StringUtil.xssFilter(request.getParameter("vsl_cd"));
    String ctrtFlag = StringUtil.xssFilter(request.getParameter("ctrtFlag"));
    String typeFlag = StringUtil.xssFilter(request.getParameter("typeFlag"));
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vsl_cd" value="<%=vsl_cd%>" id="vsl_cd" />
<input type="hidden" name="ctrtFlag" value="<%=ctrtFlag%>" id="ctrtFlag" />
<input type="hidden" name="typeFlag" value="<%=typeFlag%>" id="typeFlag" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Contract Code Search</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_confirm" id="btn_confirm" type="button">Confirm</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->


<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Contract Type</th>
                    <td><select style="width:100px;" name="flet_ctrt_tp_cd" id="flet_ctrt_tp_cd"></select></td> 
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->


</form>

 
