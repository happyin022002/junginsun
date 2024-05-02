<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1154.jsp
*@FileTitle  :  Multi NCM Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/19
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event.EsmBkg1154Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1154Event  event 		= null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg 			= "";				//에러메세지
	int rowCount	 			= 0;				//DB ResultSet 리스트의 건수

	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";

	String strUsr_id			= "";
	String strUsr_nm			= "";

	String blNo					= "";
	String cntrNo				= "";
	String cntrMfSeq			= "";
	String ncmMultiNo			= "";
	String orgSheet				= "";
	String orgRow				= "";
	String orgUiId				= "";

	try {
		blNo					= JSPUtil.getNull(request.getParameter("bl_no"));
		cntrNo					= JSPUtil.getNull(request.getParameter("cntr_no"));
		cntrMfSeq				= JSPUtil.getNull(request.getParameter("cntr_mf_seq"));
		ncmMultiNo				= JSPUtil.getNull(request.getParameter("ncm_multi_no"));
		orgSheet				= JSPUtil.getNull(request.getParameter("org_sheet"));
		orgRow					= JSPUtil.getNull(request.getParameter("org_row"));
		orgUiId					= JSPUtil.getNull(request.getParameter("org_ui_id"));
		
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1154Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
<input type="hidden" name="bl_no" value="<%=blNo%>">
<input type="hidden" name="ncm_multi_no" value="<%=ncmMultiNo%>">
<input type="hidden" name="org_sheet" value="<%=orgSheet%>">
<input type="hidden" name="org_row" value="<%=orgRow%>">
<input type="hidden" name="org_ui_id" value="<%=orgUiId%>">
<input type="hidden" name="brz_cmdt_cd">

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<% if(!"ESM_BKG_0229_05_R".equals(orgUiId)){  %>
			<h2 class="page_title"><span>Multi NCM Input</span></h2>
		<%}else{ %>	
			<h2 class="page_title"><span>Multi NCM Display</span></h2>
		<%} %>	
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		<% if(!"ESM_BKG_0229_05_R".equals(orgUiId)){  %>
			--><button class="btn_accent" name="btn_add" id="btn_add" type="button">Add</button><!--
			--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button">Delete</button><!--
			--><button class="btn_normal" name="btn_apply" id="btn_apply" type="button">Apply</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		<% }else{ %>
			--><button class="btn_accent" name="btn_close" id="btn_close" type="button">Close</button><!--
		<%}%>-->
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="120"/>
					<col width="*" />				
				</colgroup> 
				<tr>
					<th>Container No.</th>
					<td><input name="cntr_no" type="text" style="width:120px;text-align:center;" class="input2" value="<%=cntrNo%>" readonly id="cntr_no" /></td>
					<td></td>
				</tr>
				<tr>
					<th>C/M Seq.</th>
					<td><input name="cntr_mf_seq" type="text" style="width:120px;text-align:center;" class="input2" value="<%=cntrMfSeq%>" readonly id="cntr_mf_seq" /></td>
					<td></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
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