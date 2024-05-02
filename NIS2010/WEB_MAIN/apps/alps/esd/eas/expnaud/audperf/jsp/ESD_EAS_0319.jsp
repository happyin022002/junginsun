<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_EAS_0319.jsp
*@FileTitle : Logistics Expense Result - Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.16
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015.02.16 9014613
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
<%@ page import="com.hanjin.apps.alps.esd.eas.expnaud.audperf.event.EsdEas0319Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdEas0319Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.expnaud.audperf.basic.AudPerfBC");
	
	String ofcCd = "";
	String ym = "";
	String vndrSeq = "";
	String rhqYn = "";

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		// 부모창에서 넘오온 파라메터 셋팅
		ofcCd = ((StringUtil.xssFilter(request.getParameter("s_ofc_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_ofc_cd")));
		ym = ((StringUtil.xssFilter(request.getParameter("s_ym"))==null)?"":StringUtil.xssFilter(request.getParameter("s_ym")));
		vndrSeq = ((StringUtil.xssFilter(request.getParameter("s_vndr_seq"))==null)?"":StringUtil.xssFilter(request.getParameter("s_vndr_seq")));	
		rhqYn = ((StringUtil.xssFilter(request.getParameter("s_rhq_yn"))==null)?"":StringUtil.xssFilter(request.getParameter("s_rhq_yn")));		
		
		event = (EsdEas0319Event)request.getAttribute("Event");
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
<title>Logistics Expense Result - Cost Detail</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="s_compare_mon" 		value="1" >
<input type="hidden" name="s_ofc_cd" 		value="<%=ofcCd %>" >
<input type="hidden" name="s_ym" 		value="<%=ym %>" >
<input type="hidden" name="s_vndr_seq" 		value="<%=vndrSeq %>" >
<input type="hidden" name="s_rhq_yn" 		value="<%=rhqYn %>" >

<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">	
		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Logistics Expense Result - Cost Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->	
		
		<!-- ______________________________________________ Start Main Button -->
		<!-- | -->
		<!-- | -->	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr><td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr></table>
	
					</td></tr>
			</table>
		<!-- |______________________________________________ End Main Button -->
				
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search"> 
			<tr>
				<td class="bg">
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:670;"> 
					<tr class="h23">
						<td>Module</td>
						<td>
							<select class="input" style="width:100;" name="s_mdl_cd" caption="Module">
	<!-- | -->						<option value="" selected></option>
	<!-- | -->						<option value="SO_TRANS" >TRS</option>
	<!-- | -->						<option value="SO_TERMINAL" >TES</option>
	<!-- | -->						<option value="SO_PORT" >PSO</option>
	<!-- | -->						<option value="SO_M&R" >MNR</option>
							</select>
						</td>
						<td width="85">Cost Code</td>
	<!-- | -->				<td width="120">
	<!-- | -->					<script language="javascript">ComComboObject('s_lgs_cost_cd',4,100,0,0,0);</script>
	<!-- | -->				</td>
						<td>
							<input type="checkbox" name = "s_compare_mon_radio" class="trans" >&nbsp;Comparison
						</td>
	<!-- | -->				<td width="">&nbsp;
	<!-- | -->                 <script language="javascript">ComComboObject('s_rto_tp_cd',1,120,1,0,0);</script>&nbsp;
	<!-- | -->                 <input type="text" name="s_rto" dataformat="float" class="input" style="width:50; text-align: right;"> %
	<!-- | -->             </td>
						
					</tr>					
				</table>
				<!--  biz_1   (E) -->	
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
				<!-- Grid_2 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid_2 (E) -->
			
			</td></tr>
		</table>
		<!--biz page (E)-->
		<table class="height_5"><tr><td></td></tr></table>
	</td></tr>
	</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>