<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6001.jsp
*@FileTitle : CMPB Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.30 이승준
* 1.0 Creation
===================================== ====================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event.EsmPri6001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_office_cd = "";
	//srep cd 권한 체크(일반 사용자, 권한자)
	String strUsr_srep_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProfitabilitySimulation.CMPBGuideline");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_office_cd =	account.getOfc_cd();
		
		strUsr_srep_cd = JSPUtil.getNullNoTrim(account.getSrep_cd());

		event = (EsmPri6001Event)request.getAttribute("Event");
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
<title>CMPB Guideline Creation</title>
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

<body  onLoad="setupPage();" onResize="sheetColResize();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- 권한 체크 -->
<input type="hidden" name="srep_cd_hidden" value="<%=strUsr_srep_cd %>">

<input name="bse_seq" type="hidden" value="">

<input name="cd" type="hidden" value="">
<input name="etc1" type="hidden" value="">
<input name="etc2" type="hidden" value="">
<input name="etc3" type="hidden" value="">
<input name="etc4" type="hidden" value="">
<input name="etc5" type="hidden" value="">
<!-- ett_dt_before -->
<input type="hidden" name="exp_dt_before" value="">
<!-- dt combo select 여부 -->
<input type="hidden" name="exp_dt_hidden_select" value="">
<!-- 변경여부 체크 -->
<input type="hidden" name="svc_scp_cd_hidden" value="">
<input type="hidden" name="cre_ofc_cd_hidden" value="">
<!-- user office -->
<input type="hidden" name="user_ofc_cd_hidden" value="<%=strUsr_office_cd %>">
<input type="hidden" name="gline_seq" value="">
<input type="hidden" name="prs_cust_tp_cd_hidden" value="">
<input name="eff_dt" type="hidden" value="">
<input type="hidden" name="exp_dt_hidden" value="">
<!-- Copy 성공여부  재조회시 flag -->
<input type="hidden" name="max_gline_seq" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!-- Hidden sheet for Transaction (S) -->
		<script language="javascript">ComSheetObject('sheet0');</script>
		<!-- Hidden sheet for Transaction (E) -->
	
		<!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Confirm_Cancel">Confirm Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Down_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Load_Excel">
					Load Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td>
			</tr>
			</table>
    	<!--Button (E) -->
	
		
		<table class="search"> 
       		<tr><td class="bg">	
			
			
			<!-- biz_1  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Creation</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">SVC Scope</td>
					<td width="310" style="padding-left:2"><script language="javascript"> ComComboObject('svc_scp_cd', 2, 80, 0, 1, 0, false);</script>
					&nbsp;<input name="svc_scp_nm" type="text" style="width:180;"  value="" class="input2" readonly></td>
					<td width="90">Duration</td>   
					<td width="92" style="padding-left:2">
					<script language="javascript">ComComboObject('eff_dt_cd', 4, 90, 0, 1, 0, true);</script>
					</td>
					<td width="112">&nbsp;&nbsp; ~
					<input type="hidden" name="eff_dt_hidden" value="">
					<input name="exp_dt" type="text" style="width:80;text-align:center;"  value="" class="input1" caption="Expire Date" maxlength="10" 
						   dataformat="ymd" required>
					</td>
					<td width="65" align="left" style="padding-left:2">
					<img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" valign="bottom">
					</td>
					<td width="100">Creation Office</td>
					<td width=""><input type="text" name="cre_ofc_cd" style="width:50;text-align:center;" class="input2" value="<%=strUsr_office_cd %>" readOnly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">Customer Type</td>
					<td width="310" style="padding-left:2">
						<script language="javascript">ComComboObject('prs_cust_tp_cd', 1, 80, 0, 1, 0, false);</script></td>
					<td width="90">Creation Date</td>
					<td width="270"><input type="text" name="cre_dt" style="width:90;text-align:center;" class="input2" value="" readOnly></td>
					<td width="100" style="padding-left:3" >Confirmation</td>
					<td width="" style="padding-left:0"><input type="text" name="cfm_flg" style="width:50;text-align:center;" class="input2" value="" readOnly></td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s" width="100">Items</td>
					<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn2_CMDT_Group">
					CMDT Group</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td width=""><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn2_Loc_Group">
					Loc. Group</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr>
				</table>
				
				<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					<!--grid(E)-->
						
						
						
						<!--grid (s)-->
						<table width="100%"  id="mainTable" > 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet9');</script>
								</td>
							</tr>
						</table>
						<!--grid(E)-->
						
						
						<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<!-- 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						 -->
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
						
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
					<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s" width="100">CMPB Guideline</td>
					<td width=""><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn2_MQC_Setting">
					MQC Setting</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr>
				</table>
				<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
					<!--grid(E)-->
					<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn3_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn3_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn3_Row_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn3_Save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<!-- biz_1  (E) -->	
				
			</td></tr>
		</table>
	
 		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
 </td></tr>
</table>

<div id="hiddenSheetLayer" style="display: none">
	<script language="javascript">ComSheetObject('sheet3');</script>
	<script language="javascript">ComSheetObject('sheet4');</script>
	<script language="javascript">ComSheetObject('sheet5');</script>
	<script language="javascript">ComSheetObject('sheet6');</script>
	<script language="javascript">ComSheetObject('sheet7');</script>
	<script language="javascript">ComSheetObject('sheet8');</script>
	<script language="javascript">ComSheetObject('sheet10');</script>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>