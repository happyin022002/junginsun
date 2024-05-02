<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0250.jsp
*@FileTitle : Port SKD Information(Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.17 유혁
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0250Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0250Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.scheduleplanningoperation.vesselschedulemgt");
	
	String clptSeq = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0250Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		clptSeq = JSPUtil.replaceForHTML(request.getParameter("clpt_seq"));
		clptSeq = clptSeq==null || clptSeq.length()==0 ? "" : clptSeq;

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Port SKD Information</title>
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

<body  class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="clpt_seq" value="<%=clptSeq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Port SKD Information  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
		
		<!-- : ( Grid ) (S) -->
		<table width="100%"  id="mainTable" style="visible:false"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>	
		<!-- : ( Grid ) (E) -->
 			
			<table class="search" width="380"> 
       		<tr><td class="bg">
				<table class="search" border="0">
					<tr class="h23">
						<td width="120"> VVD</td>
						<td width=""><input type="text" style="width:40;" name="vsl_cd" value="<%=JSPUtil.replaceForHTML(request.getParameter("vsl_cd"))%>" class="input1">&nbsp;<input type="text" style="width:37" name="skd_voy_no" value="<%=JSPUtil.replaceForHTML(request.getParameter("skd_voy_no"))%>"class="input1">&nbsp;<input type="text" style="width:20;" name="skd_dir_cd" value="<%=JSPUtil.replaceForHTML(request.getParameter("skd_dir_cd"))%>"class="input1"> </td>
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				
				<table class="search" border="0">
					<tr class="h23">
						<td width="120">Vessel Name	</td>
						<td width=""><input type="text" style="width:100%;text-align:center;" name="vsl_eng_nm" class="input"> </td>
					</tr>
					<tr class="h23">
						<td width="">Port Code	</td>
						<td width=""><input type="text" style="width:100%;text-align:center;" name="vps_port_cd" value="<%=JSPUtil.replaceForHTML(request.getParameter("vps_port_cd"))%>" class="input"> </td>
					</tr>
					<tr class="h23">
						<td width="">Call Indicator</td>
						<td width=""><input type="text" style="width:100%;text-align:center;" name="clpt_ind_seq" class="input"></td>
					</tr>
					<tr class="h23">
						<td width="">Status	</td>
						<td width=""><input type="text" style="width:100%;text-align:center;" name="skd_ind" class="input"> </td>
					</tr>
					<tr class="h23">
						<td width="">Change Indicator	</td>
						<td width=""><input type="text" style="width:100%;text-align:center;" name="cng_ind" class="input"> </td>
					</tr>
					<tr class="h23">
						<td width="">ETA ( PF / EST )</td>
						<td width=""><input type="text" style="width:49%;text-align:center;" name="pf_eta_dt" class="input">&nbsp;<input type="text" style="width:49%;text-align:center;" name="vps_eta_dt" class="input"></td>
					</tr>
					<tr class="h23">
						<td width="">ETB ( PF / EST )</td>
						<td width=""><input type="text" style="width:49%;text-align:center;" name="pf_etb_dt" class="input">&nbsp;<input type="text" style="width:49%;text-align:center;" name="vps_etb_dt" class="input"> </td>
					</tr>
					<tr class="h23">
						<td width="">ETD ( PF / EST )</td>
						<td width=""><input type="text" style="width:49%;text-align:center;" name="pf_etd_dt" class="input">&nbsp;<input type="text" style="width:49%;text-align:center;" name="vps_etd_dt" class="input"> </td>
					</tr>
					<tr class="h23">
						<td width="">Remark</td>
						<td width=""><input type="text" style="width:100%;text-align:center;" name="vps_rmk" class="input"> </td>
					</tr>
				</table>
				
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
		    <tr><td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Close">Close</td>
				<td class="btn1_right"></td>
				</tr>
				</table>
			</td></tr>
			</table>
    <!--Button (E) -->
	
		</td></tr>
		</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>