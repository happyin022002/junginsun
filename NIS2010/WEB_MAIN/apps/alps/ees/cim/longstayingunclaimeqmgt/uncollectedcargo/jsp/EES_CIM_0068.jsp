<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0068.jsp
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
<%
	EesCim0065Event event = null;
	EesCim0067Event eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;		//서버에서 발생한 에러
	DBRowSet rowSet = null;					//DB ResultSet
	String strErrMsg = "";					//에러메세지
	int rowCount	 = 0;					//DB ResultSet 리스트의 건수

	String fileNo = ""; // fileNo : tpb_ttl_file_mgmt 테이블의 key
	String targetFnc = ""; // opener에서 fileNo값을 받을 대상
	String downloadLink = "N"; // opener에서 fileNo값을 받을 대상
	String filePath = ""; // file Path directory
	String col = JSPUtil.getNull(request.getParameter("col")); //리스트의 table column 갯수
	if(col.equals("")){
		col = "1";
	}

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
		fileNo = JSPUtil.getNull( (String)event.getEventParams().get("fileNo") );
		targetFnc = JSPUtil.getNull( (String)event.getEventParams().get("targetFnc") );
		downloadLink = JSPUtil.getNull( (String)event.getEventParams().get("downloadLink") );
		filePath = JSPUtil.getNull( (String)event.getEventParams().get("filePath") );
	}
	
	String sName = "";
	if(rowSet != null){
		sName = JSPUtil.getNull(rowSet.getString(4)); 
	}

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> CIM File Download </TITLE>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		TPBFilePath = "<%=filePath%>"; /// CIMCommon 전역변수에 할당
		loadPage("<%=targetFnc%>", "<%=downloadLink%>");
	}
</script>
</HEAD>

<BODY onload="setupPage();">

<!-- OUTER - POPUP (S)tart -->
<table width="300"  border="0"> 
<tr><td valign="top">
		
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search" border="0"> 
			<tr>
				<td>
				<!-- : ( Scenario ID ) (S) -->
				<!-- <table class="search" border="0" style="width:280;height:230"> 
				<tr class="h23"> -->
					<!-- <td valign="top"> -->
						<div id="spanFileNameList" name="spanFileNameList"></div>
					<!-- </td> -->
				<!-- </tr>
				</table> -->
				<!-- : ( Scenario ID ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) --> 	
	
</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->

<!-- : ( HIDDEN FORM : Added ) (S) -->

<!-- form for Adding a file  -->
<form method="post" name="form1" enctype="multipart/form-data">
	<input type="hidden" id="fileParameterNames" name="fileParameterNames" value="fileObj"><!-- file oblect id names, delimiter : '|'  -->
	<input type="hidden" id="f_cmd" name="f_cmd" value=""><!-- command -->
	<input type="hidden" id="fileNo" name="fileNo" value="<%=fileNo%>"><!-- fileNo -->
	<input type="hidden" id="fileNo" name="fileNo" value="<%=fileNo%>"><!-- fileNo -->
	<span id="spanFile" style="position:absolute;width:7px;height:7px;background-color:;clip:rect(2 43 25 2);
	z-index:9;cursor:hand;overflow-x:hidden;overflow-y:hidden;vertical-align:middle;align:center;"
	onclick=""><input type="file" id="fileObj" name="fileObj" style="cursor:hand;width:0px;height:100px;background-color:;filter:alpha(opacity=0);
	border-bottom:0px; border-left:0px; border-right:0px; border-top:0px;margin-bottom:0px; margin-left:0px; margin-right:0px; margin-top:0px;" onclick="disappearPoint();" onchange="fileObj_onchange();"></span>
</form>

<!-- form for Deleting upload files  -->
<form method="post" name="form2" enctype="multipart/form-data">
	<input type="hidden" id="f_cmd" name="f_cmd" value=""><!-- command -->
	<input type="hidden" id="fileNo" name="fileNo"><!-- fileNo -->
	<input type="hidden" id="delFileNoSeqs" name="delFileNoSeqs"><!-- fileNoSeqs to delete -->
</form>

<!-- target inner frame -->
<iframe id="ifrm1" name="ifrm1" width="0" height="0"></iframe>
<%=sName%>
<!-- : ( HIDDEN FORM : Added ) (E) -->
	
<!-- : ( Button : Sub ) (S) -->
<!-- : ( Button : Sub ) (E) -->

<!-- : JScript Variables Initiate (S) -->

<SCRIPT LANGUAGE="JavaScript">
<!--

	fileNo = "<%=fileNo%>"; 
	var col = "<%=col%>";
	var html = '<table class="search" border="0" style="width:100%;height:100%">';
	html += '<tr class="h23">';
	<% 
	// file_no / file_no_seq / file_nm / file_path_nm / cre_usr_id / cre_dt / upd_usr_id / upd_dt 

	if ( rowCount > 0 ) { 
		while (rowSet!=null && rowSet.next()) {
			%>
			fileNowIdx++;
			fileNameArr[fileNowIdx] = "<%=JSPUtil.getNull(rowSet.getString(3))%>"; 

			<% if ( !downloadLink.equals("Y") ) { %>
				fileChkNameArr[fileNowIdx] = fileNameArr[fileNowIdx]+"<br>";
			<% } else { %>
				fileChkNameArr[fileNowIdx] = " ○ <a href='#' onclick=\"fileDownLoad('<%=JSPUtil.getNull(rowSet.getString(4))%>', '<%=JSPUtil.getNull(rowSet.getString(3))%>', '<%=JSPUtil.getNull(rowSet.getString(5))%>', '','<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>);return false;\">"+fileNameArr[fileNowIdx]+"</a>";
			<% }%>

			fileNoSeqArr[fileNowIdx] = <%=JSPUtil.getNull(rowSet.getString(2))%>; 

			<% if ( downloadLink.equals("Y") ) { %>
				filePathNmArr[fileNowIdx] = "<%=JSPUtil.getNull(rowSet.getString(4))%>"; 
			<% } %>
		    

			html += '<td valign="top">';
			html += fileChkNameArr[fileNowIdx];
			html += '</td>';

			if(parseInt(fileNowIdx+1) % parseInt(col) == 0){
				html += '</tr><tr class="h23">';
			}
			<%
		}
	} 
	%>
			html += '</tr>';
			html += '</table>';
			spanFileNameList.innerHTML = html;
//-->
</SCRIPT>

<!-- : JScript Variables Initiate (E) -->

</BODY>
</HTML>