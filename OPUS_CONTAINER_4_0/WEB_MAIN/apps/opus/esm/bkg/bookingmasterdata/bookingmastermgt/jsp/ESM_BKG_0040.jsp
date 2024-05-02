<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0040.jsp
*@FileTitle : BookingMaster
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0040Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0040Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strPort_cd		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");
	String mainPage 		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strPort_cd = account.getOfc_cd();
		mainPage = request.getParameter("mainPage");

		event = (EsmBkg0040Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");

	}catch(Exception e) {
		out.println(e.toString());
	}
	

%>
<script language="javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if

	ComSetObjValue(document.form.screenName,"<%=screenName%>");
	loadPage();
}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName">
<input type="hidden" name="user_id" value="<%= strUsr_id %>">
<input type="hidden" name="port_cd" value="<%= strPort_cd %>">

<%if(!mainPage.equals("true")){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>NVOCC SCAC Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new"      id="btn_new">New</button><!--
			--><% if (screenName.indexOf("Q") < 0){ %><!--	
			--><button type="button" class="btn_normal" name="btn_save"      id="btn_save">Save</button><!--
			--><% } %><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
	</div>
</div>
<%}else{%>
<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new"      id="btn_new">New</button><!--
		--><% if (screenName.indexOf("Q") < 0){ %><!--	
		--><button type="button" class="btn_normal" name="btn_save"      id="btn_save">Save</button><!--
		--><% } %><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<%}%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <tbody>
				<tr>
					<th width="60">Name</th>
					<td width="80">
						<input type="text" name="scac_nm" id="scac_nm" style="width:400px;" dataformat='engup' class="input" value="" otherchar=" ">
					</td>
					<th width="50">SCAC</th>
					<td width="90">
						<input type="text" name="scac_cd" id="scac_cd" style="width:80px;" dataformat='enguponly' class="input" value="" maxlength="4">
					</td>
					<th width="65">Auto Filer</th>
					<td width="80">
						<select name="usa_cstms_file_cd" style="width:67px;">
							<option value=" " selected>All</option>
							<option value="Y">Yes</option>
							<option value="N">No</option>
						</select>
					</td>
					<th width="40">Total</th>
					<td>
						<input type="text" name="tot_count" id="tot_count" style="width:60px;ime-mode:disabled;background-color:#eeeeee " class="input" value="" readonly>
					</td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<% if (screenName.indexOf("Q") < 0){ %>	
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
	        <button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
	    </div> 
	    <!-- opus_design_btn(E) -->
		<% } %>
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<%if(!mainPage.equals("true")){%></div><%}%>	
	
</form>