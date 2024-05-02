<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0074GS.jsp
*@FileTitle : Missing List
*Open Issues :
*Change history :
* 2008-04-04 sanghyun kim
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0074Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0074EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%
	ESD_SCE_0074Event event = null;
	ESD_SCE_0074EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;                     //서버에서 발생한 에러
	DBRowSet rowSet = null;                               //DB ResultSet
	String strErrMsg = "";                                //에러메세지
	//int rowCount     = 0;                                 //DB ResultSet 리스트의 건수
	int cnt     = 0;                                 //DB ResultSet 리스트의 건수
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{

            event = (ESD_SCE_0074Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0074EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {

                rowSet = eventResponse.getRowSet();

				if((rowSet != null) || (event.getFormCommand().isCommand(FormCommand.COMMAND06))){
                     cnt = eventResponse.getCnt();               
                } // end if
            } // end if
        } // end else
       
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<%
	if (serverException == null)  {
%>
<SHEET>
  <DATA TOTAL="<%=cnt%>">
<%
String temp = "";
int i =1;
if (rowSet != null) {
	while (rowSet.next()){
%>
		<TR>
<%
		for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
        		temp = JSPUtil.getNull(rowSet.getObject(i++)+"");
%>
				<TD><![CDATA[<%=temp%>]]></TD>
<%
		}
        i = 1;
%>
</TR>
<%
	}
}
            
%>
  </DATA>
</SHEET>
<%
} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>