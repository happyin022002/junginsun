<%--
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : TPBPendigTpbOpener.jsp
*@FileTitle : Pending TPB Popup Open
*Open Issues :
*Change history :
*@LastModifyDate : 2008-10-29
*@LastModifier : Kim Jin-seung
*@LastVersion : 1.0
* 2008-10-29 Kim Jin-seung
* 1.0 최초 생성
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	String ofc_cd = "";
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	ofc_cd = account.getOfc_cd();

	String isTPBOffice = com.hanjin.apps.alps.esd.tpb.common.TPBUtils.getIsTPBOffice( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
%>
<script language="javascript">
	parent.openPendingTPBWin('<%=isTPBOffice%>');
</script>
