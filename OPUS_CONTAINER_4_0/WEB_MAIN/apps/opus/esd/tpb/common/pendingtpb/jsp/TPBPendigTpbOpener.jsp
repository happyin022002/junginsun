<%--
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : TPBPendigTpbOpener.jsp
*@FileTitle : Pending TPB Popup Open
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	String ofc_cd = "";
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	ofc_cd = account.getOfc_cd();

	String isTPBOffice = com.clt.apps.opus.esd.tpb.common.TPBUtils.getIsTPBOffice( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
%>
<script language="javascript">
	parent.openPendingTPBWin('<%=isTPBOffice%>');
</script>
