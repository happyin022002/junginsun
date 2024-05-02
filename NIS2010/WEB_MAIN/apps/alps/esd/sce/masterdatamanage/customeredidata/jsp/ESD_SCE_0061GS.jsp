<!--%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0061GS.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : yongcheonshin
*@LastVersion : 1.0
* 2006-09-08 yongcheonshin
* 1.0 최초 생성
=========================================================*/ %-->
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0061Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0061EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

    ESD_SCE_0061Event event = null;
    ESD_SCE_0061EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;                     //서버에서 발생한 에러
    DBRowSet rowSet = null;                               //DB ResultSet
    DBRowSet rowSet1 = null;                              //DB ResultSet
    String strErrMsg = "";                                //에러메세지
    int rowCount     = 0;                                 //DB ResultSet 리스트의 건수
    String ediDesc  = "";
    StringBuffer custDesc = new StringBuffer();
   

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (ESD_SCE_0061Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0061EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRowSet();
                rowSet1 = eventResponse.getRowSet1();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if
                if(rowSet1 != null){
                	while (rowSet1.next()) {
                		ediDesc = JSPUtil.getNull(rowSet1.getString("ediDesc"));  
                		custDesc.append(rowSet1.getRow()>1?"\n":"");  
                		custDesc.append(JSPUtil.getNull(rowSet1.getString("custDesc")));  
                	}
               } // end if
            } // end if1
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
    <TR>        
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
  <%
		if(event.getFormCommand().isCommand(FormCommand.SEARCH01)){
%>
	<ETC-DATA>
		<ETC NAME="edi_sts_desc"><%=ediDesc%></ETC> 
		<ETC NAME="cust_sts_desc"><%=custDesc%></ETC> 
	</ETC-DATA>
<%
		}

%>  
</SHEET>
<%
    } else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>