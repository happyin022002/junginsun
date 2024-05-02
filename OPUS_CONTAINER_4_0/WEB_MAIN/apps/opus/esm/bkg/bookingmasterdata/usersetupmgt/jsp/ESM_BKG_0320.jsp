<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All RRRights Reserved.
*@FileName   : ESM_BKG_0320.jsp  
*@FileTitle  : Internet O/BL Release Authority
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>

<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0320Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0320Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");
	String screenName = ""; 
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0320Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	
	function setActualCustomer(p_cust_cnt_cd){
	   alert(p_cust_cnt_cd);
		form.cust_cnt_cd.value= p_cust_cnt_cd;
	//	form.cust_seq.value= p_cust_seq;
	}	
</script>
<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="pagerows" id="pagerows" />
	<input type="hidden" name="ch_usr_id" id="ch_usr_id" />
	
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		<% if (screenName.indexOf("Q") < 0){ %>
		--><button class="btn_normal" type="button" name="btn_Save" id="btn_Save">Save</button><!--
			<% } %>		
		--><button class="btn_normal" type="button" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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
			<colgroup>
				<col width="60">
				<col width="80">
				<col width="90">
				<col width="80">
				<col width="60">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>User ID</th>
					<td><input type="text" name="usr_id" style="width: 80px;" value="" class="input" maxlength="20" dataformat="eng" otherchar="_" id="usr_id" /> </td>
					<th>User Name</th>
					<td><input type="text" name="usr_nm" style="width: 80px;" value="" class="input" maxlength="20" dataformat="eng" otherchar=" " id="usr_nm" /> </td>
					<th>Office</th>
					<td><input type="text" name="ofc_cd" style="width: 65px;" value="" class="input" maxlength="6" dataformat="enguponly" id="ofc_cd" /> </td>
				</tr>
			</tbody>
		</table>
		</div>
		</div>
		
		<div class="wrap_result">		
		<div class="opus_design_grid" id="mainTable">
			<% if (screenName.indexOf("Q") < 0){ %>
				<div class="opus_design_btn">
				    <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>
				</div>
			<% } %>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->

</form>