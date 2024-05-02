<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_026GS.jsp
*@FileTitle : Brokerage Shipper 관계 관리 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-30
*@LastModifier : Sang-Jun Kwon
*@LastVersion : 1.0
* 2006-11-30 Sang-Jun Kwon
* 1.0 최초 Insert
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.event.ESM_AGT_026Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.event.ESM_AGT_026EventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%

	ESM_AGT_026Event event = null;
	ESM_AGT_026EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;				//error from server
	DBRowSet rowSet = null;							//DB ResultSet
	String strErrMsg = "";							//error message
	int rowCount	 = 0;							//count of DB resultSET list

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			event = (ESM_AGT_026Event)request.getAttribute("Event");
			eventResponse = (ESM_AGT_026EventResponse)request.getAttribute("EventResponse");
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
		FormCommand formcommand = event.getFormCommand();
		//화면에서 CUD가 발생하는 FormCommand인 경우에는 RetrieveXML을 출력한다.
		//FormCommand가 다를 경우 조건문에 추가한다.
		//ServiceCommand에서는 재Retrieve를 하지 않고 EventResponse만 return한다.
		if( formcommand.isCommand(FormCommand.ADD) || 
			formcommand.isCommand(FormCommand.MODIFY) || 
			formcommand.isCommand(FormCommand.REMOVE) || 
			formcommand.isCommand(FormCommand.REMOVELIST) ){	//SaveXML인 경우
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%
		   } else {	//RetrieveXML인 경우%>
<SHEET>
  <DATA TOTAL="<%=rowCount%>">
<%
			//int i =1;
			if (rowSet != null) {

				while (rowSet.next()) {
%>
	<TR>
		<TD>R</TD>
		<TD></TD>
		<TD></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cust_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cust_nm"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("shpr_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("shpr_nm"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cust_cnt_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("cust_seq"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("shpr_cnt_cd"))%>]]></TD>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString("shpr_seq"))%>]]></TD>
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