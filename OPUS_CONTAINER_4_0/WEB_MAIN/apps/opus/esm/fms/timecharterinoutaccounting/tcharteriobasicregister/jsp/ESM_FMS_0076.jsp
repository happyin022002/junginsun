<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0076.jsp
*@FileTitle  : Item Name
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException = null;			//Error from Server
	String strErrMsg = "";	

	String usrId = "";
	String fletAcctCateCd = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	usrId = account.getUsr_id();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		fletAcctCateCd = StringUtil.xssFilter(request.getParameter("flet_acct_cate_cd"));

	}catch(Exception e) {
		log.error(e.getMessage(),e);
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


<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="flet_acct_cate_cd" value="<%=fletAcctCateCd%>" id="flet_acct_cate_cd" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Item List Selection</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn1_Confirm" 	id="btn1_Confirm">Confirm</button><!--
			--><button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">

	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>           
<%@include file="/bizcommon/include/common_opus.jsp"%>