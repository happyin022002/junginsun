<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0112.jsp
*@FileTitle : VSL Voyage Check
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.14 진마리아
* 1.0 Creation
*
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0112Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0112Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.vop.vsk.budget.vesselschedulemgt");
	
	String vsl_cd = 		JSPUtil.replaceForHTML(request.getParameter("vsl_cd"));
	String skd_voy_no = 	JSPUtil.replaceForHTML(request.getParameter("skd_voy_no"));
	String start_date = 	JSPUtil.replaceForHTML(request.getParameter("start_date"));
	String end_date = 		JSPUtil.replaceForHTML(request.getParameter("end_date"));
	String vsl_cnt = 		JSPUtil.replaceForHTML(request.getParameter("vsl_cnt"));
	String voy_no_type = 	JSPUtil.replaceForHTML(request.getParameter("voy_no_type"));
	String skd_dir_cd_1 = 	JSPUtil.replaceForHTML(request.getParameter("skd_dir_cd_1"));
	String skd_dir_cd_2 = 	JSPUtil.replaceForHTML(request.getParameter("skd_dir_cd_2"));
	String duration = 		JSPUtil.replaceForHTML(request.getParameter("duration"));
	
	vsl_cd = 		vsl_cd==null?"":vsl_cd.trim();
	skd_voy_no = 	skd_voy_no==null?"":skd_voy_no.trim();
	start_date = 	start_date==null?"":start_date.trim();
	end_date = 		end_date==null?"":end_date.trim();
	vsl_cnt = 		vsl_cnt==null?"":vsl_cnt.trim();
	voy_no_type = 	voy_no_type==null?"":voy_no_type.trim();
	skd_dir_cd_1 = 	skd_dir_cd_1==null?"":skd_dir_cd_1.trim();
	skd_dir_cd_2 = 	skd_dir_cd_2==null?"":skd_dir_cd_2.trim();
	duration = 		duration==null?"":duration.trim();
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (VopVsk0112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>VSL Voyage Check</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

</head>

<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd" value='<%=vsl_cd%>'>
<input type="hidden" name="skd_voy_no" value='<%=skd_voy_no%>'>
<input type="hidden" name="start_date" value='<%=start_date%>'>
<input type="hidden" name="end_date" value='<%=end_date%>'>
<input type="hidden" name="vsl_cnt" value='<%=vsl_cnt%>'>
<input type="hidden" name="voy_no_type" value='<%=voy_no_type%>'>
<input type="hidden" name="skd_dir_cd_1" value='<%=skd_dir_cd_1%>'>
<input type="hidden" name="skd_dir_cd_2" value='<%=skd_dir_cd_2%>'>
<input type="hidden" name="duration" value='<%=duration%>'>
 
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Vessel Voyage Check </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				
				<table class="height_5"><tr><td></td></tr></table>
				<!--  biz_1  (S) -->
				<table class="grid2" border="0" style="width:100%;"> 
				<tr class="tr2_head">
					<td align="left">Remark</td>
				</tr>	
				<tr>
					<td><textarea style="width:100%;height:50" name="remark" readonly></textarea></td>
					<!-- 
					<td><textarea style="width:100%;height:50">This Voyage <HJRM0001> already started_Can't Start Simulation</textarea></td>
					 -->
				</tr>	
				</table>
				<!--  biz_1   (E) -->
				
		  		
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
	
</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_simulation">Simulation Start</td>
					<td class="btn1_right">
				</tr></table></td></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td></td>
			</tr>
			</table>
    <!--Button (E) -->
	
		</td></tr>
		</table>
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>			
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
