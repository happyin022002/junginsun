<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0013.jsp
*@FileTitle : Trendline Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
*
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.fcm.trendline.trendline.event.VopFcm0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0013Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	//Logger log = Logger.getLogger("com.hanjin.apps.vop.fcm.trendline.trendline");
	Logger log = Logger.getLogger("com.hanjin.apps.alps.vop.fcm");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopFcm0013Event)request.getAttribute("Event");
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
<title>Fuel Consumption Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/sheet/ibchart.js"></script>
<script language="javascript">
	var gOfcCd = "<%=strOfc_cd%>";
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
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 업무용 hidden -->
<input type="hidden" name="vsl_clss_cd">
<input type="hidden" name="vsl_clss_sub_cd">
<input type="hidden" name="vsl_slan_cd">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="trnd_line_tp_sub_cd">
<input type="hidden" name="trnd_line_fm_dt">
<input type="hidden" name="trnd_line_to_dt">
<input type="hidden" name="trnd_line_use_tp_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	
	<!-- Title, Navigation 고정 -->
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!-- 메인 화면 바깐쪽 화면 하단 버튼 부 -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>	
    <!--Button (E) -->
    
    	
	
	<!-- 메인 화면 : biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
       			<!-- 메인 조건부 : biz_1  (S) -->
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="110">Trend Line Type</td>
					<td width="130"><script language="javascript">ComComboObject('trnd_line_tp_cd',1,125,1,1);</script></td>
					<td width="200"><input type="text" name="trnd_line_no" style="width:125;text-align:center;ime-mode:disabled;" class="input2" readonly>
					<img class="cursor" name="btn_trnd_line_no" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle">
					</td>
					<!-- 
					<td width="80">Chart Type</td>
					<td width="150"><script language="javascript">ComComboObject('trnd_line_cht_tp_cd',1,150,1,0);</script></td>
					 -->
					<td width="539">
				</tr>
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">						
					<td width="110">Remark</td>  
					<td class="stm"><input type="text" name="trnd_line_rmk" style="width:100%;text-align:left;ime-mode:disabled;" class="input2" size="10" maxlength="10" readonly></td>
				</tr>
				</table>				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>	

		<table class="search"> 
       	<tr><td class="bg">
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<!--시트-->
								<script language="javascript">ComSheetObject('sheet1');</script>
								<!-- 차트 -->
								<script language="javascript">ComChartObject('chart1', 980, 0)</script>
								<script language="javascript">ComChartObject('chart2', 980, 0)</script>
								<script language="javascript">ComChartObject('chart3', 980, 0)</script>
								<script language="javascript">ComChartObject('chart4', 980, 0)</script>
								<script language="javascript">ComChartObject('chart5', 980, 0)</script>
								<script language="javascript">ComChartObject('chart6', 980, 0)</script>
							</td>
						</tr>
					</table> 
				<!-- Grid (E) -->
			</td></tr>
		</table>					
	<!--biz page (E)-->
	
</td></tr>
</table>
    
</form>			
</body>
</html>