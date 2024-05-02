<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_1052.jsp
*@FileTitle : Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.25 이선영
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.event.VopVsk9004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk9004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.vesseloperationsupportmgt.optimizeddistancemgt");
	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		


		event = (VopVsk9004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	//
	String VslCd = (request.getParameter("vsl_cd") == null)? "": request.getParameter("vsl_cd");	
	String SkdVoyNo = (request.getParameter("skd_voy_no") == null)? "": request.getParameter("skd_voy_no");	
	String SkdDirCd = (request.getParameter("skd_dir_cd") == null)? "": request.getParameter("skd_dir_cd");	
	String PasgPlnDt = (request.getParameter("pasg_pln_dt") == null)? "": request.getParameter("pasg_pln_dt");	
	String DepPortCd = (request.getParameter("dep_port_cd") == null)? "": request.getParameter("dep_port_cd");	
	String ArrPortCd = (request.getParameter("arr_port_cd") == null)? "": request.getParameter("arr_port_cd");
	String VpsEtaDt = (request.getParameter("vps_eta_dt") == null)? "": request.getParameter("vps_eta_dt");	
%>
<html>
<head>
<title>Distance Table(Detail)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
	    loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Distance Table(Detail)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
       			<table class="search" border="0" style="width:750;">
       			<tr><td width="900"></td></tr>
				<tr class="h23">
					<td width="500">Vessel Code : <%=VslCd%></td>
					<td width="500">Voyage : <%=SkdVoyNo%><%=SkdDirCd %></td>
					<td width="800">Port : <%=DepPortCd%> ~ <%=ArrPortCd%></td>
					
				</tr>
				<tr class="h23">
					<td width="900">Plan Date : <%=PasgPlnDt%></td>
					<td width="900">ETA Time : <%=VpsEtaDt%></td>
				</tr>
				<tr>
					<td width="900"></td>
					<td><input type="hidden" style="ime-mode:disabled;text-align:center" class="input" name="vsl_cd" value="<%=VslCd%>" maxlength="5" tabindex="1"></td>
					<td><input type="hidden" style="ime-mode:disabled;text-align:center" class="input" name="skd_voy_no" value="<%=SkdVoyNo%>" maxlength="5" tabindex="1"></td>
					<td><input type="hidden" style="ime-mode:disabled;text-align:center" class="input" name="skd_dir_cd" value="<%=SkdDirCd %>" maxlength="5" tabindex="1"></td>
					<td><input type="hidden" style="ime-mode:disabled;text-align:center" class="input" name="pasg_pln_dt" value="<%=PasgPlnDt%>" maxlength="5" tabindex="1"></td>
					<td><input type="hidden" style="ime-mode:disabled;text-align:center" class="input" name="dep_port_cd" value="<%=DepPortCd%>" maxlength="5" tabindex="1"></td>
					<td><input type="hidden" style="ime-mode:disabled;text-align:center" class="input" name="arr_port_cd" value="<%=ArrPortCd%>" maxlength="5" tabindex="1"></td>
					<td><input type="hidden" style="ime-mode:disabled;text-align:center" class="input" name="vps_eta_dt" value="<%=VpsEtaDt%>" maxlength="5" tabindex="1"></td>
				</tr>
				</table>
			
				<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid - 1 (E) -->	

				
		</td></tr></table>		
		<table class="height_5"><tr><td></td></tr></table>	
		<!-- 1 (E) -->
		<!--biz page (E)--> 

</td></tr></table>

<!--table class="height_5"><tr><td></td></tr></table-->
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="30" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Download</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>