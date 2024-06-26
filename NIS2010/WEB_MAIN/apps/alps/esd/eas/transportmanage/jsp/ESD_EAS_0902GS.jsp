<%--
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0902.jsp
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-22
*@LastModifier : JeongHo_Lee
*@LastVersion : 1.0
* 2008-05-22 JeongHo_Lee
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="10kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0902Event"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0902EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%
	EsdEas0902Event event = null;
	EsdEas0902EventResponse eventResponse = null;	 //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;					 //서버에서 발생한 에러
	DBRowSet rowSet = null;							     //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								 //DB ResultSet 리스트의 건수

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
	event = (EsdEas0902Event)request.getAttribute("Event");
	eventResponse = (EsdEas0902EventResponse)request.getAttribute("EventResponse");
	if (eventResponse != null) {
		rowSet = eventResponse.getRowSet();
		if(rowSet != null){
	 rowCount = rowSet.getRowCount();
	 //out.println(rowCount);
		} // end if
	} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%
	if (serverException == null) {
		FormCommand formcommand = event.getFormCommand();
		//화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
		//FormCommand가 다를 경우 조건문에 추가한다.
		//ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
		if( formcommand.isCommand(FormCommand.MULTI) || 
			formcommand.isCommand(FormCommand.ADD) || 
			formcommand.isCommand(FormCommand.MODIFY) || 
			formcommand.isCommand(FormCommand.REMOVE) || 
			formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%
		   } else {	//조회XML인 경우%>
<SHEET>
  <DATA TOTAL="<%=rowCount%>">
<%
			int i = 1;
			if (rowSet != null) {
				if(formcommand.isCommand(FormCommand.SEARCH01) || formcommand.isCommand(FormCommand.MULTI01)){
					while (rowSet.next()) {
%>
		<TR>
<%
						for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
%>						
			<TD><![CDATA[<%=rowSet.getString(i++)%>]]></TD>
<%
						}
						i = 1;
%>
		</TR>
<%
					}
				}
			}
%>
  </DATA>
</SHEET>
<%
	}
} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
%>