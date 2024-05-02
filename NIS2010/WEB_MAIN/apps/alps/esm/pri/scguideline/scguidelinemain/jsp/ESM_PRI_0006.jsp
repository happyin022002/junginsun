<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0006.jsp
*@FileTitle : S/C Guideline Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.16 김재연
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.event.EsmPri0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGuidelineMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0006Event)request.getAttribute("Event");
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
<title>S/C Guideline Copy</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="gline_seq" value="<%=JSPUtil.getNull(request.getParameter("gline_seq"))%>">
<input type="hidden" name="trgt_gline_seq" value="">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; S/C Guideline Copy</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       		<tr><td class="bg">
				<!-- : ( grid ) (S) -->
				<table width="100%" class="grid"> 
				<tr class="tr_head">
					<td width="16%" rowspan="2">Service Scope</td>
					<td width="%" colspan="2">Duration		</td>
					<td width="10%" rowspan="2">Location<br>Group	</td>
					<td width="10%" rowspan="2">Commodity<br>Group	</td>
					<td width="10%" rowspan="2">Origin<br>Arbitrary	</td>
					<td width="10%" rowspan="2">Destination<br>Arbitrary</td>
					<td width="7%" rowspan="2">Rate	</td>
					<td width="7%" rowspan="2">GOH</td>
				</tr>
				<tr class="tr_head2">
					<td width="10%">Effective 	</td>
					<td width="10%">Expiration	</td>
				</tr>
				<tr align="center">
					<TD class="input2"><input type="text" name="svc_scp_cd" style="width:80;"  value="<%=JSPUtil.getNull(request.getParameter("svc_scp_cd"))%>" class="noinput2"></TD>
					<TD class="input2"><input type="text" name="eff_dt" value="<%=JSPUtil.getNull(request.getParameter("eff_dt"))%>" style="width:80;"  class="noinput2"></TD>
					<TD class="input2"><input type="text" name="exp_dt" value="<%=JSPUtil.getNull(request.getParameter("exp_dt"))%>" style="width:80;"  class="noinput2"></TD>
					<td><input type="checkbox" name="loc_grp" value="Y" class="trans"></td>
					<td><input type="checkbox" name="cmdt_grp" value="Y" class="trans"></td>
					<td><input type="checkbox" name="org_arb" value="Y" class="trans"></td>
					<td><input type="checkbox" name="dest_arb" value="Y" class="trans"></td>
					<td><input type="checkbox" name="rate" value="Y" class="trans"></td>
					<td><input type="checkbox" name="goh" value="Y" class="trans"></td>
				</tr>
				</table> 
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- : ( grid) (E) -->	
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Copy To</td></tr>
				</table>
				<table class="search" border="0" style="width:684;"> 
				<tr class="h23">
					<td width="110">&nbsp;&nbsp;Service Scope</td>
					<td width="294"><script language="javascript">ComComboObject('trgt_svc_scp_cd', 2, 50, 0, 1, 0, false);</script>
					&nbsp;<input name="trgt_svc_scp_nm" type="text" style="width:160;"  value="" class="input2" readonly caption="Service Scope"></td>
					<td width="60">Duration</td>
					<td width="">
						<input type="text" name="trgt_eff_dt" value="" style="width:80;" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;
						<input type="text" name="trgt_exp_dt" value="" style="width:80;" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle">
					</td></tr>
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

	</td></tr>
		</table>
<!-- : ( Button : pop ) (S) -->


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_ok">OK</td>
						<td class="btn1_right"></td></tr></table></td>
						<td class="btn1_line"></td>
				   		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
					</tr></table>
			</td>
		</tr>
		</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>