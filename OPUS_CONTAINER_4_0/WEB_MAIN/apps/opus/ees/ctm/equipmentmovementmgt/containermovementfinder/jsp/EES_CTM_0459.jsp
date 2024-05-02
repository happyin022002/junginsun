<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1949.jsp
*@FileTitle  : Load Factor by Trade-RD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>


<head>
<title>Movement History by Detail Form</title>


<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<%
	SignOnUserAccount act = new SignOnUserAccount();
	String cntCd = act.getCnt_cd();
%>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="user_id" value="<%=act.getUsr_id()%>" id="user_id" />
<input type="hidden" name="ofc_cd" value="<%=act.getOfc_cd()%>" id="ofc_cd" />
<input type="hidden" name="cnt_cd" value="<%=act.getCnt_cd()%>" id="cnt_cd" />

<script type="text/javascript">rdViewerObject();</script>
</form>