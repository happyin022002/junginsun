<%
/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_3306.jsp
*@FileTitle  :  SCE RAIL SPLC Manage
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3306Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce3306Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error On Server Side
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esd.sce.copreport");
	int rowSize = 3000 ;

	//selected value in exception combo box
	String expt_tp_idx = JSPUtil.getNull(request.getParameter("expt_tp_selected_idx"));

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce3306Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//The data obtained from the server side on load.
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="fm_cntr_tpsz_cd" id="fm_cntr_tpsz_cd" />
<input type="hidden" name="fm_cnt_cd" id="fm_cnt_cd" />
<input type="hidden" name="fm_loc_cd" id="fm_loc_cd" />
<input type="hidden" name="fm_rgn_cd" id="fm_rgn_cd" />
<input type="hidden" name="fm_yd_cd" id="fm_yd_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
	--><button type="button" class="btn_normal" name="btn_exceldown" id="btn_exceldown">Down Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_excelup" id="btn_excelup">Load Excel</button>		</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
	<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	<table>	
		<colgroup>
				<col width="70" />				
				<col width="100" />				
				<col width="95" />				
				<col width="240" />				
				<col width="75" />				
				<col width="*" />				
		   </colgroup> 	
		<tr>
			<th>SPLC Code</th>
			<td><input type="text" style="width:60px; ime-mode:disabled" name="frm_splc_cd"  class="input" dataformat="engup" maxlength="6"></td>
			<th>VENDOR NAME</th>
			<td><input type="text" style="width:200px; ime-mode:disabled" name="frm_splc_vndr_nm"  class="input" dataformat="engup" maxlength="20"></td>
			<th>YARD Code</th>
			<td><input type="text" style="width:70px; ime-mode:disabled" name="frm_yd_cd" class="input" dataformat="engup" maxlength="7"></td>			
		</tr>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
	--><button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button></div>
	<!-- opus_design_btn(e) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
