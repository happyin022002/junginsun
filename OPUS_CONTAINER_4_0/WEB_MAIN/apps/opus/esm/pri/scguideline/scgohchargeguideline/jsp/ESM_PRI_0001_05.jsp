<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_005.js
*@FileTitle  : S/C GOH Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.event.EsmPri000105Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri000105Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGOHChargeGuideline");
	String[] currCd = null;
	String[] perCd = null;
	String[] barCd = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri000105Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"), false);
        perCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("perCd"), false);
        barCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("barCd"), false ,"|","\t","getCode","getName");
	} catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<script type="text/javascript">
    var currCdComboValue = " |<%=currCd[0]%>";
    var currCdComboText = " |<%=currCd[1]%>";
    var perCdComboValue = " |<%=perCd[0]%>";
    var perCdComboText = " |<%=perCd[1]%>";
    var barCdComboValue = " |<%=barCd[0]%>";
    var barCdComboText = " |<%=barCd[1]%>";
	function setupPage(){	
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" value="" type="hidden" />
<input id="gline_seq" name="gline_seq" value="" type="hidden" />
<input id="cd" name="cd" type="hidden" />

<div class="opus_design_title clear">
	<!-- page_title_area(S) -->
	<div>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--  
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<!-- <div class="wrap_result"> -->
    <!-- opus_design_grid(S) -->
	     <div class="opus_design_grid">
	         <div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Row Copy</button><!--  
				--><button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	    </div>
   <!-- opus_design_grid(E) -->
<!-- </div> -->
</form>