<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0037.jsp
*@FileTitle : Entry and Inquiry of Target Voyage Choose by Settlement Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.19 함대성
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0037Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");

	String yyyyMM = JSPUtil.getKST("yyyy-MM");

	String crrCombo  = "";
	String abbrSheet = "";
	String dirSheet  = "";
	String staSheet  = "";
//	String finSheet  = "";

	String offList   = "";

	String[] dir = null;
	String[] sta = null;
//	String[] fin = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0037Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		offList    = eventResponse.getETCData("office");
/*
		crrCombo  = eventResponse.getETCData("jo_crr_cd"        );
		abbrSheet = eventResponse.getETCData("sheet1_jo_stl_cd" );
		
		dir = (String[])eventResponse.getCustomData("DIR");
		sta = (String[])eventResponse.getCustomData("STA");
//		fin = (String[])eventResponse.getCustomData("FIN");
		
		dirSheet = dir[0];
		staSheet = sta[0];*/
//		finSheet = fin[0];
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Entry and Inquiry of Target Voyage Choose by Settlement Item</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<script language="javascript">
var gOffList    = "<%=offList%>";
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
<input type="hidden" name="code">
<input type="hidden" name="name">
<input type="hidden" name="super_cd1">
<input type="hidden" name="super_cd2">
<input type="hidden" name="usdamount_chk">
<input type="hidden" name="hid_dt" value="<%=yyyyMM%>">
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
       		<tr>
	       		<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="150">Account Month</td>
						<td width="370"><input type="text" style="width:60" class="input1" name="from_dt" value="<%=yyyyMM%>" required maxlength=6 fullfill caption='Account Month'  cofield="to_dt" dataformat="ym">&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name="btns_back1">&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name="btns_next1">&nbsp;~&nbsp;<input type="text" style="width:60" class="input1" name="to_dt"  value="<%=yyyyMM%>"  required maxlength=6 fullfill caption='Account Month'  cofield="from_dt" dataformat="ym" >&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name="btns_back2">&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name="btns_next2"></td>
						<td width="40">Trade</td>
						<td width="100"><script language="javascript">ComComboObject('trd_cd',1,55,0,0);</script></td>
						<td width="35">Lane</td>
						<td width="100"><script language="javascript">ComComboObject('rlane_cd',1,80,0,0);</script></td>
						<td width="45">Carrier</td>
						<td width="100"><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,0);</script></td>					
						<td width="45">Office</td>
						<td width="85"><script language="javascript">ComComboObject('ofc_cd', 1, 80, 1, 0,0 );</script></td>
						<td width="145">
							<table class="search_sm" border="0" style="width:145">
							<tr class="h23">
								<td width="145" class="noinput1">&nbsp;<input type="checkbox" name="usdamount_chk2" class="trans" >USD Amount
								</td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				</td>
			</tr>
		</table>
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			<!-- Grid  (S) --> 
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr>
		       	<td class="btn1_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
					    <tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
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
								<td class="btn1" name="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td> 
						</tr>
					</table>
		    	<!--Button (E) -->
			 	</td>
	 		</tr>
		</table>
<!-- Copyright (S) -->
<!-- 개발자 작업  끝 -->
	</td>
	</tr>
	</table>
</form>
</body>
</html>