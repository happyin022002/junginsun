<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_GEM_0103.jsp
     *@FileTitle :  [CPS_GEM_0102] Note
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<% 
String rfn = JSPUtil.getParameter(request,"rfn","");
String rp = JSPUtil.getParameter(request,"rp","");
String rv = JSPUtil.getParameter(request,"rv","");
String mrd = JSPUtil.getParameter(request,"mrd","");
String title = JSPUtil.getParameter(request,"title","");
String rpost = JSPUtil.getParameter(request,"rpost","");
%>
<html>
<head>
<title><%=title%></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
    function setupPage(){      
        loadPage();
    }
</script>
</head>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="rfn" value="<%=rfn%>">
<input type="hidden" name="rpost" value="<%=rpost%>">
<input type="hidden" name="rp" value="<%=rp%>">
<input type="hidden" name="rv" value="<%=rv%>">
<input type="hidden" name="mrd" value="<%=mrd%>">
</form>
<script language="javascript">comRdObject('rd1');</script>
</body>
</html>