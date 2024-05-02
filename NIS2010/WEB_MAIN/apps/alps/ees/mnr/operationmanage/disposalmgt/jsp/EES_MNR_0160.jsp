<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0160.jsp
*@FileTitle : Disposal Sold Creationt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009.09.28 WanGyu Kim
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.10.14 허철용 [CHM-201113679-01] ALPS MNR-Disposal-SOLD Creation 에서
*                  office로 sold creation 할 수 있게 office 입력 및 조회할 수 있게 보완 개발
* 2012.05.07 신혜정 [CHM-201217691] Disposal Sold Creation 화면 조회시 Office 코드 조회조건 Mandatory 항목으로 설정
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0160Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0160Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String strRhq_ofc_cd    = "";  
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.PlanManage.PlanMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();  
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0160Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';
	var usrId     = "<%=strUsr_id.trim()%>";
	
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
<input type="hidden" name="selected_disp_no">
<input type="hidden" name="selected_mnr_prnr_cnt_cd">    
<input type="hidden" name="selected_mnr_prnr_seq">   
<input type="hidden" name="pagerows">
<!-- RD용  --> 
<input type="hidden" name="com_mrdPath" value="">  
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdBodyTitle" value="Disposal Sold Creation">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="iBtn_DocSend"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DocSend">Doc Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="79">Status</td>
					<td width="170" style="padding-left:2"><script language="javascript">ComComboObject('status', 1, 90, 1, 1);</script></td>
					<td width="55">EQ Type</td>
					<td width="150" style="padding-left:2"><script language="javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 1);</script></td>
					<td width="105">Approval Period</td>
					<td width="250"><input type="text" name="apro_dt_fr" style="width:80;text-align:center" class="input1" caption="from date" dataformat="ymd" maxlength="8" cofield="apro_dt_to"  requred >&nbsp;~&nbsp;<input type="text" name="apro_dt_to" style="width:80;text-align:center" class="input1" caption="to date" dataformat="ymd" maxlength="8" cofield="apro_dt_fr" requred >&nbsp;<img src="img/btns_calendar.gif" name="apro_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="45">Office </td>
					<td width="127">&nbsp;<input type="text" style="width:80;" class="input2" value="" readonly="true" name="ofc_cd" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_ofc_cd" name="btn_ofc_cd" style="filter:progid:DXImageTransform.Microsoft.alpha(Opacity=50)"; disabled="true"></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="79">Disposal No.</td>
					<td width="170"><input type="text" name="disp_no" style="width:120;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="disp_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="55">EQ No.</td>
					<td width="150"><input type="text" name="eq_no" style="width:100;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="40">Buyer</td>
					<td><input type="text" name="buyer_code" style="width:65;text-align:center" class="input" dataformat="engup">&nbsp;<img name="buyer_no_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="buyer_name" style="width:200;" class="input2">
					<input type="hidden" name="mnr_prnr_cnt_cd">					
					<input type="hidden" name="mnr_prnr_seq">					
					</td>
					<td width="45"></td>
					<td width="127"></td>
					</tr> 
				</table>					
				<!--  biz_1   (E) -->
				
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
		<!-- table class="search" border="0" style="width:979;"--> 
		<table class="search" border="0" style="width:100%;"> 
		<tr class="h23">
		<td width="500" valign="top">
		
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Disposal List</td></tr>
			</table>
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- Grid (E) -->
		</td>
		
		<td width="20">&nbsp;</td>
		
		<!-- td width="459"-->
		<td width="">
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Disposal Detail List</td></tr>
			</table>
		<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>				
				<!-- Grid (E) -->			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_LoadExcel">Load Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		</td></tr>
		</table>
		<!--biz page (E)-->
	</td></tr>
		</table>
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
</td>
</tr>
</table>	
</form>
</body>
</html>
