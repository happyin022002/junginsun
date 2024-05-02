<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1142.jsp
*@FileTitle : Pool Chassis Comparison Detailed
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.05 최민회
* 1.0 Creation
*--------------------------------------------------
* History
* 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1142Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm1142Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MovementMnrHistory.PoolChassisHistory");
	
	String mvmt_dt         = "";
	String chss_pool_cd    = "";
	String chss_ownr_co_cd = "";
	String cntr_ownr_co_cd = "";
	String gubun           = "";
    String chss_pool_nm    = "";
    String pool_mgmt_co_nm = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1142Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		mvmt_dt          = StringUtil.xssFilter(request.getParameter("mvmt_dt"));
		chss_pool_cd     = StringUtil.xssFilter(request.getParameter("chss_pool_cd"));
		chss_ownr_co_cd  = StringUtil.xssFilter(request.getParameter("chss_ownr_co_cd"));
		cntr_ownr_co_cd  = StringUtil.xssFilter(request.getParameter("cntr_ownr_co_cd"));
		gubun            = StringUtil.xssFilter(request.getParameter("gubun"));
		chss_pool_nm     = StringUtil.xssFilter(request.getParameter("chss_pool_nm"));
		pool_mgmt_co_nm  = StringUtil.xssFilter(request.getParameter("pool_mgmt_co_nm"));
		
		if(chss_pool_cd == null){
			chss_pool_cd = "";
		}
		
		if(mvmt_dt == null){
			mvmt_dt = "";
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
 
%>
<html>
<head>
<title>Pool Chassis Comparision Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="chss_ownr_co_cd" value="<%=chss_ownr_co_cd %>">
<input type="hidden" name="cntr_ownr_co_cd" value="<%=cntr_ownr_co_cd %>">
<input type="hidden" name="gubun" value="<%=gubun %>">
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		
		
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  Pool Chassis Comparison Detail 
 </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="40">Pool</td>
					<td width="380"><input type="text" style="width:80" class="input1" name="chss_pool_cd" value="<%=chss_pool_cd %>" readonly="readonly">&nbsp; 
					                <input type="text" style="width:260" class="input2" name="chss_pool_nm" value="<%=chss_pool_nm %>" readonly="readonly">
					</td>
					<td width="40">MGMT</td>
					<td width="240"><input type="text" style="width:230" class="input2" name="pool_mgmt_co_nm" value="<%=pool_mgmt_co_nm %>" readonly="readonly"> </td>
					<td width="90">Month</td>
					<td width=""><input type="text" style="width:80" class="input1" name="mvmt_dt" value="<%=mvmt_dt%>" readonly="readonly"></td>
					
				</tr>
				</table>
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search"> 
       	<tr><td class="bg">

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->			
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
		<table class="height_8"><tr><td></td></tr></table>	
</td></tr>
		</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	
	</td></tr>
		</table>
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>