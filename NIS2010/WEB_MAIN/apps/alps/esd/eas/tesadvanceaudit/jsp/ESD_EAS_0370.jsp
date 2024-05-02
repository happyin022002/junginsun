<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0370.jsp
*@FileTitle : TES Auto Audit Criterion Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-14
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0370Event"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
	String strUsr_id = "";
	String strOfc_cd = "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.ESD_EAS_0378");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strOfc_cd = account.getOfc_cd();
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TES Auto Audit Criterion Setting</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="code_key">
<input type="hidden" name="s_mnr_code_type">
<input type="hidden" name="login_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="ofc_cd"		value="<%=strOfc_cd%>">
<input type="hidden" name="ofclevel">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

	<!-- TABLE '#D' : ( Button : Main ) (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		<tr><td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->
			</tr></table>
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	<!-- TABLE '#D' : ( Search Options ) (S) -->
   	<table width="100%" class="search" border="0">
     	<tr>
     		<td class="bg">
			<!-- : ( Week ) (S) -->
			<table class="search_in" border="0">
				<tr class="h23">
					<td width="50">RHQ</td>
					<td width="120" style="padding-left:2"><script language="javascript">ComComboObject('s_aud_ofc_cd',1,80,1);</script>
					</td>
					<td width="85">Cost Group</td>
					<td width="120" style="padding-left:2"><script language="javascript">ComComboObject('s_lgs_cost_subj_cd',1,80,1);</script>
					</td>
					<td width="85">Calculation</td>
					<td width="120" style="padding-left:2"><script language="javascript">ComComboObject('s_cost_calc_mzd_cd',1,80,1);</script>
					</td>
					<td width="85">Auto Audit</td>
					<td width="120" style="padding-left:2"><script language="javascript">ComComboObject('s_expn_aud_tgt_flg',1,80,1);</script>
					</td>
					<td width="">&nbsp;</td>
				</tr>								
			</table>
			<!-- : ( Week ) (E) -->
			</td>
		</tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->			
	<table class="height_5"><tr><td></td></tr></table>
	<!-- TABLE '#D' : ( Grid ) (S) -->
    	<table class="search">
      		<tr><td class="bg">
			<!-- <table class="height_10"><tr><td></td></tr></table> -->
			<!-- : ( POR ) (S) -->
			<table width="100%" id="mainTable">
	              <tr><td>
	                     <script language="javascript">ComSheetObject('sheet1');</script>
	              </td></tr>
			</table>
			<!-- : ( POR ) (E) -->
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<div style="display:none;">
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
</form>
</body>
</html>