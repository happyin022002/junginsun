<%--
/*=========================================================
*Copyright(c) 2006~2008 CyberLogitec
*@FileName : TPBFileUpload.jsp
*@FileTitle : 3자구상 파일업로드 팝업 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, Choi
*@LastVersion : 1.2
* 2006-11-15 Kim Jin-seung  1.0 최초 생성
* 2008-05-02 Kim Jin-seung	1.1 Correction : Adjustment Request/Approval Recovery Activity시 modal팝업 사용할 수 있도록 처리;
* 2009-12-02 Sun, Choi 		1.2 OPUS Migration
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.fileupload.event.TPBFileUploadEvent"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.fileupload.event.TPBFileUploadEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%

	TPBFileUploadEvent event = null;
	TPBFileUploadEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;					//서버에서 발생한 에러
	DBRowSet rowSet = null;							    //DB ResultSet
	String strErrMsg = "";								//에러메세지
	int rowCount	 = 0;								//DB ResultSet 리스트의 건수
	
	String fileNo = ""; // fileNo : tpb_ttl_file_mgmt 테이블의 key
	String targetFnc = ""; // opener에서 fileNo값을 받을 대상
	String downloadLink = "N"; // opener에서 fileNo값을 받을 대상
	String filePath = ""; // file Path directory
	String filePhysNm= ""; // filePhysNm
	
	String loginUsrId = ""; // 현재 로긴한 user_id
	boolean fileDeleteAuth = false; // check box disabled관련 권한 

	int fileSizeLimit = 1 * 1024 * 1024 ;
	
	// session으로 부터 login user정보 가져오기
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	loginUsrId = JSPUtil.getNull(account.getUsr_id());
	//out.println(account);
	//MultipartRequest multi = new MultipartRequest(request, filePath, fileSizeLimit, "euc-kr", new DefaultFileRenamePolicy());

	// tpbNo, invNo받기 
	String tpbNo = JSPUtil.getNull(request.getParameter("tpbNo"));
	//out.println(tpbNo);
	String invNo = JSPUtil.getNull(request.getParameter("invNo"));
	//out.println(invNo);
	// modal window 
	String modalWindow = JSPUtil.getNull(request.getParameter("modalWindow"));
	// out.println(modalWindow);
	// getting authority parameter to add and delete 
	String authYn = JSPUtil.getNull(request.getParameter("authYn"));

	// event, event response
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (TPBFileUploadEvent)request.getAttribute("Event");
			eventResponse = (TPBFileUploadEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else
	}catch(Exception e) {  
		out.println(e.toString());
	}

	if ( event!=null && event.getEventParams() !=null ) {
		fileNo = JSPUtil.getNull( (String)event.getEventParams().get("fileNo") );
		targetFnc = JSPUtil.getNull( (String)event.getEventParams().get("targetFnc") );
		downloadLink = JSPUtil.getNull( (String)event.getEventParams().get("downloadLink") );
		filePath = JSPUtil.getNull( (String)event.getEventParams().get("filePath") );
		filePhysNm = JSPUtil.getNull( (String)event.getEventParams().get("filePhysNm") );
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		TPBFilePath = "<%=filePath%>"; /// TPBCommon 전역변수에 할당
		TPBFileCount = parseInt("<%=rowCount%>");
		loadPage();

		modalWindow = "<%=modalWindow%>";
	}
</script>

<form name="form" >
	<input type="hidden" id="f_cmd" name="f_cmd" value=""><!-- command -->
	<input type="hidden" name="ibflag" id="ibflag" />
	<input type="hidden" name="pagerows" id="pagerows" />
	<input type="hidden" id="fileNo" name="fileNo" value="<%=fileNo%>"><!-- fileNo -->
	<input type="hidden" id="tpbNo" name="tpbNo" value="<%=tpbNo%>"><!-- tpbNo -->
	<input type="hidden" id="invNo" name="invNo" value="<%=invNo%>"><!-- invNo -->
	<input type="hidden" id="filePhysNm" name="filePhysNm" value="<%=filePhysNm%>"><!-- filePhysNm -->

<!-- 개발자 작업 -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span> File Attach </span></h2>
	<!-- page_title(E) -->
</div>


<!-- page_title_area(E) -->
	<!-- page_title_area(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit sm">
			<table>
	            <tbody>
					<tr>
						<td>
								<% if ( authYn.equals("Y") ) { %>
									<b><font color=red>**</font> File Maximum Size  <font color=blue>1.0 MB.</font> </b><br>
									<b><font color=red>**</font> Please use <font color=blue>JPG/GIF</font> for image files. </b><br>
								<% } %>		
								
						</td>
					</tr>
				</tbody>
			</table>
		</div>	
		<table class="height_10"><tr><td></td></tr></table>
		
	</div>
	
	<!-- page_title_area(E) -->
	<!-- wrap_result(S) -->
	<div class="wrap_result">
	    <!-- opus_design_grid(S) -->
	    
	    <div class="opus_design_grid clear" id="mainTable" >
			<!-- opus_design_grid(S) -->	
			<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:;">
				<div class="opus_design_btn">
				<% if ( authYn.equals("Y") ) { %>
					<button class="btn_normal" name="btn_t1Add" id="btn_t1Add" type="button">Row Add</button><!--
					--><!--
					--><button class="btn_normal" name="btn_t1Delete" id="btn_t1Delete" type="button">Row Del</button>
				<% } %>	
				</div>	
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			</div>
			
			<!-- opus_design_grid(E) -->
		</div>	  
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>	
	</div>

</form>


<!-- target inner frame -->
<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
