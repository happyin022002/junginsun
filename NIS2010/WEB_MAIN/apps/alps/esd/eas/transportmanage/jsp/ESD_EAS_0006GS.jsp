<%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_006GS.jsp
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-19
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-19 yujin
* 1.0 최초 생성
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0006Event"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0006EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>

<%
	SignOnUserAccount account = null; //Session 정보
	EsdEas0006Event         event           = null;
	EsdEas0006EventResponse eventResponse   = null;
    Exception                serverException = null;
    DBRowSet                 rowSet          = null;
    int                      totCnt          = 0 ;
    String                   strErrMsg       = "";

    try {
    	account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event         = (EsdEas0006Event)request.getAttribute("Event");
            eventResponse = (EsdEas0006EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRowSet();
		if(rowSet != null){
	totCnt = rowSet.getRowCount();
		} // end if
            }
        }
    }catch(Exception e) {
    	out.println(e.getMessage()) ;
    }

    if (serverException == null) {
    	FormCommand formcommand = event.getFormCommand();
    
    if( formcommand.isCommand(FormCommand.SEARCH11) ){
		String sofc_cd = "";
		int n = 0;
%>
		<OFFICE>
<%
		if( rowSet != null ) {
			while( rowSet.next() ) {
				sofc_cd = JSPUtil.getNull(rowSet.getString("OFC_CD"));
%>
				<sub-office><%=sofc_cd%></sub-office>
<%
				n++;
			}
		}
%>
			<row-count><%=String.valueOf(n)%></row-count>
		</OFFICE>
<%
	}else {
%>    

<SHEET>
  <DATA TOTAL="<%=totCnt%>">
<%
			int i =1;
			int seq = 1;
			if (rowSet != null) {
				while (rowSet.next()) {
%>
	<TR>
					<TD><![CDATA[<%=seq%>]]></TD>
<%
					for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
%>
						
						<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString(i++))%>]]></TD>
<%
					}
					i = 1;
					seq++;
%>
	</TR>
<%
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