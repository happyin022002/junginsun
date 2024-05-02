<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_SCE_0049.jsp
*@FileTitle : Exception Type & Subscriber Group Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-21
*@LastModifier : JeongSeon An
*@LastVersion : 1.0
* 2007-03-21 JeongSeon An
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0049Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.ESD_SCE_0049EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

    ESD_SCE_0049Event event = null;
    ESD_SCE_0049EventResponse eventResponse = null;	     //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;					 //서버에서 발생한 에러
	DBRowSet rowSet = null;							     //DB ResultSet
	String strErrMsg = "";								 //에러메세지
    int totalCount   = 0 ;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESD_SCE_0049Event)request.getAttribute("Event");
			eventResponse = (ESD_SCE_0049EventResponse)request.getAttribute("EventResponse");
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
    				}
    		%>
    					<row-count><%=rowSet.getRowCount()%></row-count>
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
    						}
    				%>
    							<row-count><%=rowSet.getRowCount()%></row-count>
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
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("to_act_cd"))%>]]></TD>

        <TD EDIT="<%="N".equals( szActFlg)?"FALSE":"TRUE"%>"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_expt_subsc_grp_cd"))%>]]></TD>

        <TD EDIT="<%="N".equals( szActFlg)?"FALSE":"TRUE"%>"><![CDATA[<%=JSPUtil.getNull(rowSet.getString("subsc_grp_ntfd_pty_cd"))%>]]></TD>

        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("upd_usr_id"))%>]]></TD>
   		<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("upd_dt"))%>]]></TD>
        <TD><![CDATA[<%=szActFlg%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("fm_act_desc"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("to_act_desc"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("expt_tp_nm"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("expt_dtl_tp_nm"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("expt_dtl_tp_desc"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cop_expt_subsc_grp_nm"))%>]]></TD>
        <TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("subsc_grp_ntfd_pty_nm"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("expt_tp_desc"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("fm_act_nm"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("to_act_nm"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_EXPT_SUBSC_CS_SEQ"))%>]]></TD>
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