<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESPendingTesOpener.jsp
*@FileTitle : Pending TES Popup Open
*Open Issues :
*Change history :
*@LastModifyDate : 2010-11-15
*@LastModifier : KimYongJin
*@LastVersion : 1.0
* 2010-11-15 KimYongJin
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
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl"%>

<%
String ofc_cd = "";
String usr_id = "";
SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

ofc_cd = account.getOfc_cd();
usr_id = account.getUsr_id();
TESInvoiceCommonBC bc = new TESInvoiceCommonBCImpl();
String isPendingCd = bc.searchOldInvCsrChk(ofc_cd);
%>

<script language="javascript">
	var cookieKey = "TES9310OpenToday" + "_"+ "<%=ofc_cd%>" + "_"+ "<%=usr_id%>";
	var openTodayYN = Get_Cookie(cookieKey);
	//alert(cookieKey + ":" + openTodayYN);
	if( openTodayYN == "Y"){
		
	}else{
		if("<%=isPendingCd%>" == 'Y') {
	    	parent.openPendingTESWin("<%=isPendingCd%>");
		}	
	}
	
</script>
