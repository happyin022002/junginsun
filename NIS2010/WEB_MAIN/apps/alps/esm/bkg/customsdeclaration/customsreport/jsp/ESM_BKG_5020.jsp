<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_5020.jsp
*@FileTitle : ESM_BKG_5020
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.07 경종윤
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	//EsmBkg5020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	String chk1 = "";
	String chk2 = "";
	String chk3 = "";
	String vslNm = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
/*	   
		event = (EsmBkg5020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
*/		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		// 부모창에서 넘오온 파라메터 셋팅
		vvdCd = StringUtil.xssFilter(request.getParameter("vvd_cd"))==null?"":StringUtil.xssFilter(request.getParameter("vvd_cd"));
		polCd = StringUtil.xssFilter(request.getParameter("pol_cd"))==null?"":StringUtil.xssFilter(request.getParameter("pol_cd"));
		podCd = StringUtil.xssFilter(request.getParameter("pod_cd"))==null?"":StringUtil.xssFilter(request.getParameter("pod_cd"));
		chk1 = StringUtil.xssFilter(request.getParameter("chk1"))==null?"false":StringUtil.xssFilter(request.getParameter("chk1"));
		chk2 = StringUtil.xssFilter(request.getParameter("chk2"))==null?"false":StringUtil.xssFilter(request.getParameter("chk2"));
		chk3 = StringUtil.xssFilter(request.getParameter("chk3"))==null?"false":StringUtil.xssFilter(request.getParameter("chk3"));
		vslNm = StringUtil.xssFilter(request.getParameter("vsl_nm"))==null?"":StringUtil.xssFilter(request.getParameter("vsl_nm"));
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Manifest Generation_IGM Form III Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		/*
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} 
		*/
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vvd_cd" value="<%= vvdCd %>">
<input type="hidden" name="pol_cd" value="<%= polCd %>">
<input type="hidden" name="pod_cd" value="<%= podCd %>">
<input type="hidden" name="chk1" value="<%= chk1 %>">
<input type="hidden" name="chk2" value="<%= chk2 %>">
<input type="hidden" name="chk3" value="<%= chk3 %>">
<input type="hidden" name="vsl_nm" value="<%= vslNm %>">
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="1024" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  Manifest Generation_IGM Form III Preview</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		

</td></tr></table>

			    <table width="100%" border="0" >
			    	<tr width="100%">
						<td width="10">&nbsp;</td>
			    	    <td width="100%" style="align=left;">
			    	    
					    	<!--Button (S) -->	
							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
					       	<tr><td>
							    <table border="0" cellpadding="0" cellspacing="0">
							    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_print">print</td>
										<td class="btn1_right">
									</tr></table></td>
									<td class="btn1_line"></td>		
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_close">Close</td>
										<td class="btn1_right">
									</tr></table></td>	
									
								</tr>
							</table>
					    	<!--Button (E) -->
			    	    
			    	    </td>
			    	    <!-- <td style="width=100%">&nbsp;</td> -->
						<td class="h23" style="width=100;align=right;">
							<table class="search_sm" border="0">
								<tr class="h23">
								<td>
									<input type="radio" name="entry_type" value="LC" checked class="trans">LC&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="entry_type" value="TC" class="trans">TC&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="entry_type" value="TI" class="trans">TI
								</td>
								</tr>
							</table>
						</td>
						<td width="10">&nbsp;</td>
					</tr>
				</table>

			    <!--biz page 2 (S)-->
			    <table width="100%" height="450">
			        <tr>
			            <td width="100%"><script language="javascript">comRdObject('report1');</script></td>
			            <td width="10">&nbsp;</td>
			        </tr>
			    </table>
			    <!--biz page 2 (E)-->


<table class="height_5"><tr><td></td></tr></table>
	
</form>			
</body>
</html>

		