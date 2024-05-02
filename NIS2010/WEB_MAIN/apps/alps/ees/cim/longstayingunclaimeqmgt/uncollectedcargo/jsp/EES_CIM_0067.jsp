<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0067.jsp
*@FileTitle : UC File Upload Process
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
<%
	response.setHeader("expires", "-1"); 
	response.setHeader("pragma", "no-cache"); 
	response.setHeader("cache-control", "no-cache"); 
%>
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
	//DBRowSet rowSet = null;				//DB ResultSet
	String strErrMsg = "";					//에러메세지
	//int rowCount	 = 0;					//DB ResultSet 리스트의 건수

	String[] fileNoVal = new String[]{"","", "","",""}; // Add File시 // fileNo, fileNoSeq, filePhysNm, fileLgcNm, filePathNm
	String strSuccessFlag = null; // remove files 처리시 

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (EesCim0065Event)request.getAttribute("Event");
			eventResponse = (EesCim0067Event)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				fileNoVal = eventResponse.getFileNoVal();
				strSuccessFlag = eventResponse.getSuccessFlag();

				//rowSet = eventResponse.getRs();
				//if(rowSet != null){
				//	 rowCount = rowSet.getRowCount();
				//} // end if
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> UC File Upload Process</TITLE>
<SCRIPT LANGUAGE="JavaScript">
<!--
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		<% if ( fileNoVal != null ) { // In case of File-Uploading %>
			parent.AddFileAfterFileupload( parent.document.forms[0], "<%=fileNoVal[0]%>", "<%=fileNoVal[1]%>", "<%=fileNoVal[2]%>", ComReplaceStr("<%=fileNoVal[3]%>","'",""), "<%=fileNoVal[4]%>" ); /// replace single quote In 2008-07-23
		<% } %> 

		<% if ( strSuccessFlag != null ) { // In case of Files-Deleting %>
			parent.DeleteFileAfterFileDelete( parent.document.forms[0],"<%=strSuccessFlag%>" );
		<% } %>

		location.href="EES_CIM_0069.do"; /// replace to blank page ( prevent from reloading page in the post method )
	}

//-->
</SCRIPT>
</HEAD>

<BODY onload="setupPage();">

<% if ( fileNoVal != null ) { %>
	"<%=fileNoVal[0]%>","<%=fileNoVal[1]%>"
<% } %> 

<% if ( strSuccessFlag != null ) { %>
	"<%=strSuccessFlag%>"
<% } %>

</BODY>
</HTML>