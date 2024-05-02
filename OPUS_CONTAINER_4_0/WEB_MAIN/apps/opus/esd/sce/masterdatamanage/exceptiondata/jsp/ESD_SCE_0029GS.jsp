<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0029GS.jsp
*@FileTitle : Exception Tolerance Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-10 Seong-mun Kang
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0029Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0029EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC" %>
<%

    ESD_SCE_0029Event         event           = null;
    ESD_SCE_0029EventResponse eventResponse   = null;
    Exception                serverException = null;
    //RequestDataSetBC         dataSet         = null;&&&소스품질주석처리	
    DBRowSet                 rowSet          = null;
    String                   strErrMsg       = "";

    int totalCount   = 0 ;
   

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESD_SCE_0029Event)request.getAttribute("Event");
			eventResponse = (ESD_SCE_0029EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet     = eventResponse.getRowSet();
                totalCount = eventResponse.getTotalCount() ;
            }
        }
    }catch(Exception e) {
        serverException = e ;
        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    	out.println(e.getMessage());
    }


    
    if (serverException == null) {
    	FormCommand formcommand = event.getFormCommand();

        if( formcommand.isCommand(FormCommand.SEARCH12) ){
     				int n = 0;
     		%>
     				<ExceptionType>
     		<%
     				if( rowSet != null ) {
     					
     					while( rowSet.next() ) {
     						
     		%>
     						<ExptTP>
     						<sub-code><%=rowSet.getObject("EXPT_CD")%></sub-code>
     						<sub-name><%=rowSet.getObject("EXPT_CD_NM")%></sub-name>
     						</ExptTP>						
     		<%
     						
     						n++;
     					}
     		%>
     					<row-count><%=rowSet.getRowCount()%></row-count>
     		<%
     				}
     		%>
     					
     				</ExceptionType>
     <%
     		   } else if( formcommand.isCommand(FormCommand.SEARCH13) ){
     				int n = 0;
     				%>
     						<ExceptionDTLType>
     				<%
     						if( rowSet != null ) {
     							
     							while( rowSet.next() ) {
     								
     								//for (int j = 0 ; j < rowSet.getRowCount() ; j++) {
     				%>
     								<ExptDTLTP>
     								<sub-code><%=rowSet.getObject("EXPT_CD")%></sub-code>
     								<sub-name><%=rowSet.getObject("EXPT_CD_NM")%></sub-name>
     								</ExptDTLTP>						
     				<%
     								//}
     								
     								n++;
     							}
     				%>
     							<row-count><%=rowSet.getRowCount()%></row-count>
     				<%
     						}
     				%>
     						</ExceptionDTLType>
     		<%
     		}  else {
     %>      
<SHEET>
  <DATA TOTAL="<%=totalCount%>">
<%
			if (rowSet != null) {
				String szActFlg = "";
				while (rowSet.next()) {
					szActFlg = 	JSPUtil.getNull(rowSet.getString("ACT_FLG"));
%>
	<TR>
        <TD></TD>
        <TD></TD>
        <TD></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("expt_tp_cd"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("expt_dtl_tp_cd"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("fm_act_cd"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("fm_act_nm"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("to_act_cd"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("to_act_nm"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("loc_cd"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("node_cd"))%>]]></TD>
        <TD EDIT="<%="N".equals( szActFlg)?"FALSE":"TRUE"%>"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("FOML_TM_DY"))%>]]></TD>
        <TD EDIT="<%="N".equals( szActFlg)?"FALSE":"TRUE"%>"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("FOML_TM_HR"))%>]]></TD>
        <TD EDIT="<%="N".equals( szActFlg)?"FALSE":"TRUE"%>"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("FOML_TM_MNT"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("UPD_USR_ID"))%>]]></TD>                
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("UPD_DT"))%>]]></TD>                
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("ACT_FLG"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("FA_ACT_NM"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("TA_ACT_NM"))%>]]></TD>
        
	</TR>

<%
				}
			}
%>
  </DATA>
</SHEET>
<%		}    
	}else{%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%	}%>    
    
    

