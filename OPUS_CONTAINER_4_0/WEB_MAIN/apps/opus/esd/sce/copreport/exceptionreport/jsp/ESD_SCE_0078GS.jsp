<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0071GS.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*2008-07-01: rowSize추가
*@LastModifyDate : 2008-07-01
*@LastModifier : Hun-Il Jung
*@LastVersion : 1.6
* 2008-03-03 minestar
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.sce.copreport.exceptionreport.event.ESD_SCE_0078EventResponse"%>
<%@ page import="com.clt.apps.opus.esd.sce.copreport.exceptionreport.event.ESD_SCE_0078Event"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>

<%
	ESD_SCE_0078EventResponse eventResponse   = null;
	ESD_SCE_0078Event         event           = null;
    String                   strErrMsg       = "" ;
    Exception                serverException = null;
	DBRowSet 				 rowSet = null;
	 // Exception Noti Failure Report  rowsize추가 &&&
    int                      totCnt          = 0 ;	
	String str_day = "";
	String str_hr = "";
	String str_min = "";

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event         = (ESD_SCE_0078Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0078EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				 // Exception Noti Failure Report  rowsize추가 &&&
				totCnt = eventResponse.getTotalCount();
            } // end if
        } // end else
    }catch(Exception e) {
        serverException = e ;
        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        out.println(e.toString());
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
	} else if( formcommand.isCommand(FormCommand.SEARCH12) ){
				int n = 0;
		%>
				<ExceptionType>
		<%
				if( rowSet != null ) {
					
					while( rowSet.next() ) {
						
						//for (int j = 0 ; j < rowSet.getRowCount() ; j++) {
		%>
						<ExptTP>
						<sub-code><%=rowSet.getObject("cop_expt_tp_cd")%></sub-code>
						<sub-name><%=rowSet.getObject("cop_expt_tp_nm")%></sub-name>
						</ExptTP>						
		<%
						//}
						
						n++;
					}
				}
		%>
					<row-count><%=String.valueOf(n)%></row-count>
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
								<sub-code><%=rowSet.getObject("cop_expt_tp_dtl_nm")%></sub-code>
								<sub-name><%=rowSet.getObject("cop_expt_tp_dtl_nm")%></sub-name>
								</ExptDTLTP>						
				<%
								//}
								
								n++;
							}
						}
				%>
						<row-count><%=String.valueOf(n)%></row-count>
						</ExceptionDTLType>
		<%
				   }  else {
%>    
<SHEET>
  <DATA TOTAL="<%=totCnt%>">
<%
 		// Exception Noti Failure Report  rowsize추가 &&&
		if (rowSet != null) {
			try{
				while (rowSet.next()) {
		
			str_day = rowSet.getString("delay_dt").equals("")?"":rowSet.getString("delay_dt").substring(1,3);
			str_hr = rowSet.getString("delay_dt").equals("")?"":rowSet.getString("delay_dt").substring(4,6);
			str_min = rowSet.getString("delay_dt").equals("")?"":rowSet.getString("delay_dt").substring(7,9);
%>

		<TR>
			<TD></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("expt_no"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("bkg_no"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("bl_no"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("cop_no"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("cntr_no"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("expt_tp"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("expt_dtltp"))%>]]></TD>
			
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("shipper"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("consignee"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("notify"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("vvd"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("por"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("pol"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("pod"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("del"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("occur_dt"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("occur_ofc"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("occur_loc"))%>]]></TD>
			<TD><![CDATA[ <%=str_day+"Day "+str_hr+"Hr"+str_min+"Min"%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("logi_gid"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("logi_mail"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("cust_gid"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("cust_mail"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("urt_gid"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("urt_mail"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("f_act"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("f_actdt"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("t_act"))%>]]></TD>
			<TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("t_actdt"))%>]]></TD>
	        <TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("FM_ACT_NM"))%>]]></TD>
	        <TD><![CDATA[ <%=JSPUtil.getNull(rowSet.getString("TO_ACT_NM"))%>]]></TD>
		</TR>
<%
				}
			}catch(Exception e) {out.println(e.getMessage()) ;}
		}
%>
  </DATA>
<%			if(totCnt>0){%>
	<ETC-DATA>
	    <ETC NAME="totcnt"><![CDATA[<%=totCnt%>]]></ETC>
	</ETC-DATA>
<%			}%>		  
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

