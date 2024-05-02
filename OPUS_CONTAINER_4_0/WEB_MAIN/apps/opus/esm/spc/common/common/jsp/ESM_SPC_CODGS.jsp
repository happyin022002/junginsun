<%--==============================================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_SPC_CODGS.jsp
*@FileTitle      : Common 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2006-08-19
*@LastModifier   : choyoungjin
*@LastVersion    : 1.0
* 2006-08-19
* 1.0 최초 생성
==============================================================================--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.common.common.event.EsmSpcCodEvent"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%

    EsmSpcCodEvent event = null;
    Exception serverException = null;                     //서버에서 발생한 에러
    DBRowSet rowSet = null;                               //DB ResultSet
    String strErrMsg = "";                                //에러메세지
    String xml = "";
    
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsmSpcCodEvent)request.getAttribute("Event");
            GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = (DBRowSet)eventResponse.getRsVoList().get(0);
            } // end if
            
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }

%>
<%
    if (serverException == null) {
        FormCommand formcommand = event.getFormCommand();
        //화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
        //FormCommand가 다를 경우 조건문에 추가한다.
        //ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
        if( formcommand.isCommand(FormCommand.SEARCHLIST01)){    //저장XML인 경우
%>
<SHEET>
  <DATA TOTAL="">
<%
			if (rowSet != null) {
				String code = null;
				String text = null;
                while (rowSet.next()) {
					code = rowSet.getString("code");
					text = rowSet.getString("text");
%>
    <tr>
        <td>R</td>
        <td></td>
        <td><![CDATA[<%=code%>]]></td>
        <td><![CDATA[<%=text%>]]></td>
    </tr>
<%
                }
            }
%>
  </DATA>
</SHEET>
<%
        } else if( formcommand.isCommand(FormCommand.SEARCHLIST02)){
        	xml = HttpUtil.makeXML(request,response); 
	        xml = xml.replaceAll("\"", "'");
%>
		<%=xml%>
<%
		}
    } else {
%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>