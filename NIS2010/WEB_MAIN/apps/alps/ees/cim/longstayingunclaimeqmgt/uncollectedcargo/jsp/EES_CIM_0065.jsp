<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0065.jsp
*@FileTitle : UC File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.04 
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0065Event"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0067Event"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%
 
	EesCim0065Event event = null;
	EesCim0067Event eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;		//서버에서 발생한 에러
	DBRowSet rowSet = null;					//DB ResultSet
	String strErrMsg = "";					//에러메세지
	int rowCount	 = 0;					//DB ResultSet 리스트의 건수
	
	String ucCsNo = "";
	String ucCgoFileId = ""; // ucCgoFileId : tpb_ttl_file_mgmt 테이블의 key
	String fileDesc = "";
	String targetFnc = ""; // opener에서 ucCgoFileId값을 받을 대상
	String downloadLink = "N"; // opener에서 ucCgoFileId값을 받을 대상
	String filePath = ""; // file Path directory
	String fileSavId= ""; // fileSavId
	
	String loginUsrId = ""; // 현재 로긴한 user_id
	boolean fileDeleteAuth = false; // check box disabled관련 권한 

	//int fileSizeLimit = 1 * 1024 * 1024 ;
	
	// session으로 부터 login user정보 가져오기
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	loginUsrId = JSPUtil.getNull(account.getUsr_id());
	//MultipartRequest multi = new MultipartRequest(request, filePath, fileSizeLimit, "euc-kr", new DefaultFileRenamePolicy());

	// modal window 
	String modalWindow = JSPUtil.getNull(request.getParameter("modalWindow"));
	// getting authority parameter to add and delete 
	String authYn = JSPUtil.getNull(request.getParameter("authYn"));

	// event, event response
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (EesCim0065Event)request.getAttribute("Event");
			eventResponse = (EesCim0067Event)request.getAttribute("EventResponse");
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
		ucCsNo = JSPUtil.getNull( (String)event.getEventParams().get("ucCsNo") );
		ucCgoFileId = JSPUtil.getNull( (String)event.getEventParams().get("ucCgoFileId") );
		fileSavId = JSPUtil.getNull( (String)event.getEventParams().get("fileSavId") );

		// 한글깨짐 방지
		request.setCharacterEncoding("euc-kr");
		//fileDesc = JSPUtil.getNull( (String)event.getEventParams().get("fileDesc") );
		fileDesc = JSPUtil.getNull(request.getParameter("fileDesc"));
		
		targetFnc = JSPUtil.getNull( (String)event.getEventParams().get("targetFnc") );
		downloadLink = JSPUtil.getNull( (String)event.getEventParams().get("downloadLink") );
		filePath = JSPUtil.getNull( (String)event.getEventParams().get("filePath") );
	}
	// 모달창 안 닫히게 조절
	//modalWindow = "N";
%>
<%//=ucCgoFileId%>
<%//out.println("rowCount===>"+rowCount);%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>UC File Attach </TITLE>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		CIMFilePath = "<%=filePath%>"; /// CIMCommon 전역변수에 할당
		CIMFileCount = parseInt("<%=rowCount%>");
		loadPage("<%=targetFnc%>", "<%=downloadLink%>");

		modalWindow = "<%=modalWindow%>";
		ucCgoFileIdGb = "<%=ucCgoFileId%>";
	}
</script>
</HEAD>

<!-- <BODY onload="setupPage();" onunload="btn_ok_onclick();"> -->
<BODY onload="setupPage();">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">			
			
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">UC File Attach</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
		
			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;"> 
				<tr>
					<td class="btn1_bg" align="left">
	
					<% if ( authYn.equals("Y") ) { %>
						<table border="0" cellpadding="0" cellspacing="0"> 
							<tr>
								<td class="btn1_left" id="btn1" name="btn1" onmouseover="AddButton_onmouseover();" onmousemove="AddButton_onmousemove()" onmouseout="" onclick="AddButton_onclick();"></td>
								<td class="btn1" id="btn1" name="btn1" value="Add" onmouseover="AddButton_onmouseover();" onmousemove="AddButton_onmousemove()" onmouseout="" onclick="AddButton_onclick();">Add</td>
								<td class="btn1_right" id="btn1" name="btn1" onmouseover="AddButton_onmouseover();" onmousemove="AddButton_onmousemove()" onmouseout="" onclick="AddButton_onclick();"></td>
								<td class="btn1_left" onclick="DeleteFile(document.forms[0], document.forms[1])"></td>
								<td class="btn1" onclick="DeleteFile(document.forms[0], document.forms[1])">Delete</td>
								<td class="btn1_right" onclick="DeleteFile(document.forms[0], document.forms[1])"></td>
							</tr>
						</table>
					<% } %>
	
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->
			
			<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
			<table class="search"> 
				<tr>
					<td class="bg_a">
						<!-- : ( Scenario ID ) (S) -->
						<table class="search" border="0" style="width:300;height:230"> 
							<tr class="h23">
								<td valign="top">
									<% if ( authYn.equals("Y") ) { %>
										<b><font color=red>**</font> Total File Maximum Size  <font color=blue>5.0 MB.</font> </b><br>
										<b><font color=red>**</font> Please use <font color=blue>JPG/GIF/Word/Excel/PPT</font> for Files.</b><br>
									<% } %>
									<span id="spanFileNameList" name="spanFileNameList"></span>
								</td>
							</tr>
						</table>
						<!-- : ( Scenario ID ) (E) -->
					</td>
				</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) --> 	

</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table> 

<!-- : ( HIDDEN FORM : Added ) (S) -->

<!-- form for Adding a file  -->
<form method="post" name="form1" enctype="multipart/form-data">
	<input type="hidden" id="fileParameterNames" name="fileParameterNames" value="fileObj"><!-- file oblect id names, delimiter : '|'  -->
	<input type="hidden" id="f_cmd" name="f_cmd" value=""><!-- command -->
	<input type="hidden" id="ucCsNo" name="ucCsNo" value="<%=ucCsNo%>"><!-- ucCsNo -->
	<input type="hidden" id="ucCgoFileId" name="ucCgoFileId" value="<%=ucCgoFileId%>"><!-- ucCgoFileId -->
	<input type="hidden" id="fileDesc" name="fileDesc" value="<%=fileDesc%>"><!-- fileDesc -->
	<input type="hidden" id="fileSavId" name="fileSavId" value="<%=fileSavId%>"><!-- fileSavId -->
	
	<span id="spanFile" style="position:absolute;width:7px;height:7px;background-color:;clip:rect(2 43 25 2);
	z-index:9;cursor:hand;overflow-x:hidden;overflow-y:hidden;vertical-align:middle;align:center;"
	onclick=""><input type="file" id="fileObj" name="fileObj" style="cursor:hand;width:0px;height:100px;background-color:;filter:alpha(opacity=0);
	border-bottom:0px; border-left:0px; border-right:0px; border-top:0px;margin-bottom:0px; margin-left:0px; margin-right:0px; margin-top:0px;" onclick="disappearPoint();" onchange="fileObj_onchange();"></span>
</form>

<!-- form for Deleting upload files  -->
<form method="post" name="form2" enctype="multipart/form-data">
	<input type="hidden" id="f_cmd" name="f_cmd" value=""><!-- command -->
	<input type="hidden" id="ucCsNo" name="ucCsNo" value="<%=ucCsNo%>"><!-- ucCsNo -->	
	<input type="hidden" id="ucCgoFileId" name="ucCgoFileId"><!-- ucCgoFileId -->
	<input type="hidden" id="delFileNoSeqs" name="delFileNoSeqs"><!-- ucCgoFileIdSeqs to delete -->
	<input type="hidden" id="fileSavId" name="fileSavId"><!-- fileSavId to delete -->
</form>

<!-- target inner frame -->
<iframe id="ifrm1" name="ifrm1" width="0" height="0"></iframe>

<!-- : ( HIDDEN FORM : Added ) (E) -->

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
					    	<tr>
					    		<td>       								
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left" onclick="btn_ok_onclick();"></td>
														<td class="btn1" name="btn_ok" onclick="btn_ok_onclick();">OK</td>
														<td class="btn1_right" onclick="btn_ok_onclick();"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

		</td>
	</tr>
</table>

<!-- : JScript Variables Initiate (S) -->

<SCRIPT LANGUAGE="JavaScript">
<!--

	ucCgoFileId = "<%=ucCgoFileId%>"; 

	<% 
	// file_no / file_no_seq / file_lgc_nm / file_phys_nm / file_path_nm / cre_usr_id / cre_dt / upd_usr_id / upd_dt 

	if ( rowCount > 0 ) { 
		while (rowSet!=null && rowSet.next()) {
			if ( loginUsrId.equals( JSPUtil.getNull(rowSet.getString(6)) ) ){ // login user vs. create user 
				fileDeleteAuth = true;
			} else {
				fileDeleteAuth = false;
			}
			
			%>

			// <%=loginUsrId%>, <%=JSPUtil.getNull(rowSet.getString(6))%>
			ucCgoFileIdwIdx++;
			fileNameArr[ucCgoFileIdwIdx] = "<%=JSPUtil.getNull(rowSet.getString(3))%>"; 

			<% if ( !downloadLink.equals("Y") ) { %>
				fileChkNameArr[ucCgoFileIdwIdx] = "<input type=checkbox name=chkFile"+ucCgoFileIdwIdx+" class='trans'<% if ( !authYn.equals("Y") ) { out.print(" style='display:none' "); } %><% if(!fileDeleteAuth){ out.print(" disabled"); }%> OnClick='SetFileDelCheck(this, "+ucCgoFileIdwIdx+")'>"+fileNameArr[ucCgoFileIdwIdx]+"<br>";
			<% } else { %>
				fileChkNameArr[ucCgoFileIdwIdx] = "<input type=checkbox name=chkFile"+ucCgoFileIdwIdx+" class='trans'<% if ( !authYn.equals("Y") ) { out.print(" style='display:none' "); } %><% if(!fileDeleteAuth){ out.print(" disabled"); }%> OnClick='SetFileDelCheck(this, "+ucCgoFileIdwIdx+")'><% if ( !authYn.equals("Y") ) { out.print(" ○ "); } %>"
														+"<a href='#' onclick=\"fileDownLoad('<%=JSPUtil.getNull(rowSet.getString(4))%>', '<%=JSPUtil.getNull(rowSet.getString(3))%>', '<%=JSPUtil.getNull(rowSet.getString(5))%>', '','<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>');\">"+fileNameArr[ucCgoFileIdwIdx]+"</a><br>";
			<% }%>

			ucCgoFileIdSeqArr[ucCgoFileIdwIdx] = <%=JSPUtil.getNull(rowSet.getString(2))%>;
			fileSavIdArr[ucCgoFileIdwIdx] = '<%=JSPUtil.getNull(rowSet.getString(4))%>';

			<% if ( downloadLink.equals("Y") ) { %>
				filePathNmArr[ucCgoFileIdwIdx] = "<%=JSPUtil.getNull(rowSet.getString(4))%>"; 
			<% } %>
		
			spanFileNameList.innerHTML += fileChkNameArr[ucCgoFileIdwIdx];
			<%
		}
	} 

	%>

//-->
</SCRIPT>

<!-- : JScript Variables Initiate (E) -->

</BODY>
</HTML>