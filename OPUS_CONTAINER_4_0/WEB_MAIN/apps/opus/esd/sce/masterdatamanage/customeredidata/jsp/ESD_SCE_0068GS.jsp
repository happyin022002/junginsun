<!--%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0068GS.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastVersion : 1.0
* 2008-03-26 sanghyunkim
* 1.0 최초 생성
=========================================================*/ %-->
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0068Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0068EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%

    ESD_SCE_0068Event event = null;
    ESD_SCE_0068EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;                     //서버에서 발생한 에러
    DBRowSet rowSet = null;                               //DB ResultSet
    String strErrMsg = "";                                //에러메세지
    int rowCount     = 0;                                 //DB ResultSet 리스트의 건수
    
    

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (ESD_SCE_0068Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0068EventResponse)request.getAttribute("EventResponse");
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

%>
<%
    if (serverException == null) {
        
        //화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
        //FormCommand가 다를 경우 조건문에 추가한다.
        //ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
%>
<SHEET>
  <DATA TOTAL="<%=rowCount%>">
<%
            //String xmlString = "";

            int i =1;
            if (rowSet != null) {

                while (rowSet.next()) {
%>
    <TR> <TD></TD>       
<%
                    for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
%>
		
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]>></TD>
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
