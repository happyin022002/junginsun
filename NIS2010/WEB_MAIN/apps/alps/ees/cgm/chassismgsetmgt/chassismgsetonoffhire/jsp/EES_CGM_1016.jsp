<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1016.jsp
*@FileTitle : Chassis Status를 조회하고 수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.06.11 최민회
* 1.0 Creation
*--------------------------------------------------
* History
* 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1016Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm1016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String form_day         = "";
	String tRole = "Authenticated"; 
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		form_day  = DateTime.getDateString().replace(".",""); 

		event = (EesCgm1016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
	}catch(Exception e) {
		out.println(e.toString());
	}
	String eq_no =  StringUtil.xssFilter(request.getParameter("eq_no"));
	if(eq_no == null) eq_no = "";
	
%>
<html>
<head>
<title>Chassis Status Inquiry/Correction</title>
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
<form name="form" onkeyup="ComKeyEnter('search');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="eq_sts_seq">
<input type="hidden" name="yd_cd">
<input type="hidden" name="eq_knd_cd" value="Z">
<input type="hidden" name="agmt_ofc_cty_cd">    
<input type="hidden" name="form_day" value="<%=form_day %>">         
<input type="hidden" name="trole" value="<%=tRole%>">
<input type="hidden" name="chk_ver" value="ver2">

<!-- 개발자 작업	-->      
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	
	
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S)  -->
			
			<table width="100%" class="search" > 
			<tr class="h23">
					<td width="70">Chassis No.</td>
					<td width="150"><input type="text" style="width:100;text-align:center;ime-mode:disabled" dataformat="engup"  maxlength='10' class="input1" value="<%=eq_no %>" name="eq_no"></td>
					<td width="45">Status</td>
					<td width="130"><input type="text" style="width:70;text-align:center;" class="input2" value="" name="aciac_div_nm" readonly="readonly"></td>
					<td width="65">Type/Size</td>
					<td width="130"><input type="text" style="width:50;text-align:center;" class="input2" value="" name="eq_tpsz_cd" readonly="readonly"></td>
					<td width="70">Lease Term</td>
					<td width=""><input type="text" style="width:35;text-align:center;" class="input2" value=""  name="agmt_lstm_cd" readonly="readonly"></td>
				</tr>
			</table>
				<!--  biz_1  (E)  -->
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
			<!-- grid (S)  -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- grid  (E)  -->
			
			<table class="line_bluedot"><tr><td></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			
			
			</td></tr>
		</table>
				
		
						
				
		</td></tr>
		</table>	
			
			
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1"  name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_del">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save2">Save</td>
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


                        
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>