<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0009GS.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-08-29 SeongMun_Kang
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.ESD_SCE_0009Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.ESD_SCE_0009EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.clt.framework.core.layer.event.Event" %>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copreplan.event.ESD_SCE_0009Event_R" %>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copreplan.event.ESD_SCE_0009EventResponse_R" %>
<%
    ESD_SCE_0009Event event  = null;
    ESD_SCE_0009EventResponse eventResponse  = null;	//RDTO(Data Transfer Object including DB ResultSet
    Exception serverException = null;               //서버에서 발생한 에러

    DBRowSet rowSet  = null;							   				//DB ResultSet
    String strErrMsg = "";                          //에러메세지
    int rowCount  = 0;
	
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (ESD_SCE_0009Event)request.getAttribute("Event");
        	
			eventResponse = (ESD_SCE_0009EventResponse)request.getAttribute("EventResponse");
			
			if (eventResponse != null) {
				
				rowSet = eventResponse.getRs();
				
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if

			} // end if
            
        } // end else
    }catch(Exception ex) {
        out.println(ex.toString());
    }
%>
<%
	if (serverException == null) {
		//FormCommand formcommand = event.getFormCommand();
		//화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
		//FormCommand가 다를 경우 조건문에 추가한다.
		//ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
%>		   
      		   		   
        <?xml version="1.0"  ?>
        <SHEET>
  			<DATA TOTAL="<%=rowCount%>">
<%

			//20071115 사용하지 않는 지역 변수로 주석처리jsan int i =1;
			if (rowSet != null) {

				while (rowSet.next()) {
%>
	<TR>
		<TD></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_NO"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNTR_NO"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("ACT_NM"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("NOD_CD"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("ACT_DT"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("PLANED_DT"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("EST_DT"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("ESTM_COST"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("BND_VSKD_SEQ_CD"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("COST_ACT_GRP_SEQ"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("PCTL_NO"))%>]]></TD>
		<TD></TD>
		<TD></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_SUB_STS_CD"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("MAX_GRP_SEQ"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("MAX_DTL_SEQ"))%>]]></TD>
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