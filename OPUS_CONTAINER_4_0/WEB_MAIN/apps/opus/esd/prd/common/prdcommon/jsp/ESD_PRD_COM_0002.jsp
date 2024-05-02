<%--
=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_COM_0002.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-30
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-08-30 kimyoungchul
* 1.0
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.event.EsdPrd0001Event"%>
<%@ page import="com.clt.apps.opus.esd.prd.common.prdcommon.event.PrdCommonEvent %>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.clt.apps.opus.esd.prd.common.prdcommon.vo.ContinentVO"%>
<%@ page import="java.util.List"%>
<%
    GeneralEventResponse eventResponse = null;
    Exception serverException   = null;
	List list = null;
    String strErrMsg = "";
    int rowCount     = 0; 
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                list = eventResponse.getRsVoList();
            }
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<script Language="JavaScript">
	var list = parent.document.form.select2;
	var l_cnt = list.length;
	for(var i=0; i< l_cnt-1; i++){
		list.remove(list.length-1);
	}
<%
	for(int i=0; i< list.size(); i++){
		ContinentVO vo = (ContinentVO)list.get(i);
%>
	list.options[list.length] = new Option('<%=vo.getContiCode()%>', '<%=vo.getContiCode()%>');
<%
	}
%>
function setupPage(){
}
</script>
<body>
AAAAAA
</body>
</html>