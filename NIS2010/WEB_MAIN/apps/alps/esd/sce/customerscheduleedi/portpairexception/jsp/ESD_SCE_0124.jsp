<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0124.jsp
*@FileTitle : Bottleneck Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.10.21 최윤성
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
<%@ page import="com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0124Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce0124Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rlaneSheetList 	= "";
	String rlaneNmSheetList 	= "";
	
	String gubun		=   "";
	String cust_trd_prnr_id = "";
	String pol_cd	=	"";
	String pod_cd	=   "";
	
	String rout_rcv_dt	=   "";
	String rout_seq	=   "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0124Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		rlaneSheetList = eventResponse.getETCData("rlaneSheetList");
		rlaneNmSheetList = eventResponse.getETCData("rlaneNmSheetList");
		
		gubun	= JSPUtil.getParameter(request, "gubun".trim(), "");
		
		cust_trd_prnr_id = JSPUtil.getParameter(request, "cust_trd_prnr_id".trim(), "");
		pol_cd	= JSPUtil.getParameter(request, "pol_cd".trim(), "");
		pod_cd  = JSPUtil.getParameter(request, "pod_cd".trim(), "");
		
		rout_rcv_dt = JSPUtil.getParameter(request, "rout_rcv_dt".trim(), "");
		rout_seq    = JSPUtil.getParameter(request, "rout_seq".trim(), "");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Bottleneck Input</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=rlaneSheetList%>", "<%=rlaneNmSheetList%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="gubun" value="<%=gubun%>">

<input type="hidden" name="cust_trd_prnr_id" value="<%=cust_trd_prnr_id%>">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">

<input type="hidden" name="rout_rcv_dt" value="<%=rout_rcv_dt%>">
<input type="hidden" name="rout_seq" value="<%=rout_seq%>">

<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
		
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<!-- tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"></span></td></tr -->
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Block lane</td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr><td class="bg">
				
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable1">
							<tr><td>
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td></tr>
						</table> 
						<!-- : ( POR ) (E) -->
						
						<!-- : ( Button : Grid ) (S) -->
						<table width="100%" class="button">
							<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="mainTable4" style="display:inline">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd1" id="btng_rowadd1">Row Add</td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
							</td></tr>
						</table>
						<!-- : ( Button : Grid ) (E) -->
						
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
			
						<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btng_ok">Close</td><td class="btn1_right"></td></tr>
							</table></td>
							</tr>
						</table>
				
				</td></tr>
			</table>
		
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>