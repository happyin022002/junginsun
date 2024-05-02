<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0054.jsp
*@FileTitle : FOC Simulation by Speed
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.23
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.23 진마리아
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
<%@ page import="com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0054Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (VopFcm0054Event)request.getAttribute("Event");
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
<title>FOC Simulation by Speed</title>
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
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Simulation" id="btn_Simulation">Simulation</td>
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
				<td width="130" rowspan="2">
					<table class="search_sm2" style="width:130;">
						<tr class="h23">
							<td><input type="radio" name="rdo_tran" value="" class="trans" checked="checked">Vessel Code</td>
						</tr>
						<tr class="h23">
							<td><input type="radio" name="rdo_tran" value="" class="trans">Design Capacity</td>
						</tr>
					</table>
				</td>
				<td width="30" rowspan="2"></td>
				<td width="819" rowspan="2">
					<table class="search" style="width:819;">
						<tr><td>
							<table class="search" style="width:819;">
								<tr class="h23">
								<td>
									<div id="transVsl" style="display:inline;">
									<table class="search"><tr class="h23">
										<td width="115">Vessel Code</td>   
										<td width="140"><input type="text" name="vsl_cd" style="width:60;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" dataformat="uppernum">
							                			<img class="cursor" name="btn_vsl_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										<td width="80">Sub Item</td>
										<td width="110"><script language="javascript">ComComboObject('skd_dir_cd',1,80,0,1);</script></td>
										<td width="374"></td>
									</tr></table>
									</div>
									<div id="transCapa" style="display:none;">
									<table class="search"><tr class="h23">
										<td width="115">Design Capacity</td>   
										<td width="85"><script language="javascript">ComComboObject('vsl_clss_cd',1,80,0,1);</script></td>
										<td width="55"><script language="javascript">ComComboObject('vsl_clss_sub_cd',1,40,0,0);</script></td>
										<td width="80">Sub Item</td>
										<td width="110"><script language="javascript">ComComboObject('vsl_slan_cd',1,80,0,1);</script></td>
										<td width="374"></td>
									</tr></table>
									</div>
								</td>
								</tr>
							</table>
						</td></tr>
					
						<tr><td>
							<table class="search" style="width:819;">
								<tr class="h23">
									<td width="115">Speed</td>
									<td width="140"><input type="text" name="calc_spd_fm" style="width:40;text-align:center;" class="input" value="" dataformat="float" pointcount="1" maxlength="5">
									 &nbsp; ~ &nbsp;<input type="text" name="calc_spd_to" style="width:40;text-align:center;" class="input" value="" dataformat="float" pointcount="1" maxlength="5">
									</td>    
									<td width="80">Term</td>
									<td width="110"><select name="term" style="width:45;" class="input">
													<option value="0.5">0.5</option>
													<option value="1">1</option>
													<option value="3">3</option>
													<option value="5">5</option>
													</select></td>
									<td width="90">Applied Slip</td>
									<td width="100"><input type="text" name="aply_slp_rt" style="width:90;text-align:center;" class="input2" value="" readonly></td>
									<td width="184"></td>
								</tr>
							</table>
						</td></tr>
					</table>
				</td>
			</tr>
		</table>
		</td></tr>
		</table>
				<!--  biz_1   (E) -->
		<table class="height_8"><tr><td colspan="8"></td></tr></table>	

		<table class="search"> 
       	<tr><td class="bg">
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<!--시트-->
								<script language="javascript">ComSheetObject('sheet1');</script>
								<script language="javascript">ComSheetObject('sheet2');</script>
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