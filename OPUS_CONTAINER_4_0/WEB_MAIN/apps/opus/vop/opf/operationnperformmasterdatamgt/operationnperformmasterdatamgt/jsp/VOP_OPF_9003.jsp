<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_9003.jsp
*@FileTitle  : COD Diversion Fee Cdoe
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf9003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf9003Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationNPerformMasterDataMgt.OperationNPerformMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf9003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// setting  from server initializing   Data
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="conti_cd" id="conti_cd" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_save"  	id="btn_save">Save</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--  
		--><button type="button" class="btn_normal" name="btn_RowInsert"  	id="btn_RowInsert">Row Insert</button><!--  
		--><button type="button" class="btn_normal" name="btn_RowCopy" 	id="btn_RowCopy">Row Copy</button><!--  
		--><button type="button" class="btn_normal" name="btn_RowDelete" 	id="btn_RowDelete">Row Delete</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>