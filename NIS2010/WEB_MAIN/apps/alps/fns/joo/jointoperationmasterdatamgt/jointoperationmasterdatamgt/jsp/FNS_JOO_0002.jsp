<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0002.jsp
*@FileTitle : Entry and Inquiry of Financial Affairs
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.04.28 박희동
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");
	
	String trdCombo  = "";
	String laneCombo = "";
	String currCombo = "";
	String joStlOptCd = "";
	String joStlOptNm = "";
 	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (FnsJoo0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		trdCombo  = eventResponse.getETCData("trd_cd");
		currCombo = eventResponse.getETCData("CD02081");
		joStlOptCd = eventResponse.getETCData("joStlOptCd");
		joStlOptNm = eventResponse.getETCData("joStlOptNm");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Entry and Inquiry of Financial Affairs</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var joStlOptCd = "<%=joStlOptCd%>";
var joStlOptNm = "<%=joStlOptNm%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage("<%=trdCombo%>","<%=currCombo%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="code">
<input type="hidden" name="name">
<input type="hidden" name="super_cd1">
<input type="hidden" name="super_cd2">
<input type="hidden" name="delt_flg" value="N">
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="chg_ofc_gubun" value="1">
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
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="65">Carrier</td>
					<td width="100"><input type="text" style="width:60" class="input1" name="jo_crr_cd" dataformat="engup" maxlength="3">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pop_car" id="btn_pop_car" auth="R"></td>
					<td width="0"><input type="text" style="width:0" class="input1" name="jo_crr_cd_hid" dataformat="engup" maxlength="3">					
					<td width="40">Trade</td>
					<td width="100"><script language="javascript">ComComboObject('trd_cd',1,60,0,1);</script></td>
					<td width="45">Lane</td>
					<td width="140"><script language="javascript">ComComboObject('rlane_cd',2,72,0,1);</script></td>
					<td width="120">Settlement Option</td>
					<td width="140" style="padding-left:2"><script language="javascript">ComComboObject('jo_stl_opt_cd',1,70,0,1);</script></td>
					<td align="right" style="padding-right:20">Delete<input type="checkbox" value="N" name="delt_flg_tmp" id="delt_flg_tmp" class="trans"></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="65">Customer</td>
					<td width="431"><input type="text" style="width:60" class="input1" maxlength="8" name="cust_seq">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pop_customer" id="btn_pop_customer" auth="C">&nbsp;<input type="text" style="width:274" class="input" name="cust_lgl_eng_nm" readonly></td>
					<td width="120">Service Provider</td>
					<td width=""><input type="text" style="width:70" class="input1" maxlength="6" name="vndr_seq">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pop_vendor" id="btn_pop_vendor" auth="C">&nbsp;<input type="text" style="width:250" class="input" name="vndr_lgl_eng_nm" readonly></td>
					</tr> 
				</table>
				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			
			
			
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Revenue</td></tr>
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

			<!--  Grid_button (S) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><!--td class="btn2_left"></td>
						<td class="btn2" name="btn_add" id="btn_add" auth="C">Row&nbsp;Add</td>
						<td class="btn2_right"></td-->
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete1" id="btn_delete1" auth="C">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			<table class="line_bluedot"><tr><td></td></tr></table>
			
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Expense</td></tr>
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
			<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet3');</script>
									</td>
								</tr>
							</table>
			<!-- Grid (E) -->
			<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet4');</script>
									</td>
								</tr>
							</table>
			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><!--td class="btn2_left"></td>
						<td class="btn2" name="btn_add2"  id="btn_add2" auth="C"></td>
						<td class="btn2_right"></td-->
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete2"  id="btn_delete2" auth="C">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve" auth="R">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new" auth="R">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_create" id="btn_create" auth="C">Create</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				    <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save" auth="C">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				    <td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_changeOfc" id="btn_changeOfc">Change OFC</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>			
				
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
</td></tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>