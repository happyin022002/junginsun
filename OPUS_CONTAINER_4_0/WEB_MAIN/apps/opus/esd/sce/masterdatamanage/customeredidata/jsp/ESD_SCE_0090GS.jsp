<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0090GS.jsp
*@FileTitle : Vessel Estimation Accunt
*Open Issues :
*@LastVersion : 1.0
* 2008-04-07 kim sang hyun
* 1.0 최초 생성
=========================================================*/
%>

<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0090Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0090EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%
		ESD_SCE_0090Event event = null;
		ESD_SCE_0090EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
		Exception serverException = null;                     //서버에서 발생한 에러
		DBRowSet rowSet = null;                               //DB ResultSet
		String strErrMsg = "";                                //에러메세지
		//int rowCount     = 0;                                 //DB ResultSet 리스트의 건수
		//String tabno = "1";
		int cnt = 0;
		
		try{
			serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	        if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (ESD_SCE_0090Event)request.getAttribute("Event");

	            eventResponse = (ESD_SCE_0090EventResponse)request.getAttribute("EventResponse");

	            if (eventResponse != null) {

	                rowSet = eventResponse.getRowSet();
                    cnt = 0;          
	            } // end if
	        }
		} catch(Exception e) {
	        out.println(e.toString());
	    }
%>
<%
if (serverException == null) {
    
    //화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
    //FormCommand가 다를 경우 조건문에 추가한다.
    //ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
    if(event.getFormCommand().isCommand(FormCommand.REMOVE01) || event.getFormCommand().isCommand(FormCommand.REMOVE02)){
%>
<RESULT>
	<TR-ALL>OK</TR-ALL>
</RESULT>
<%    	
    } else {
%>
<SHEET>
<%
if(event.getFormCommand().isCommand(FormCommand.SEARCH01) || event.getFormCommand().isCommand(FormCommand.SEARCH02)){
%>
<DATA>
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
}
//else if(event.getFormCommand().isCommand(FormCommand.SEARCH02)){}

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
