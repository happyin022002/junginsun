<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0005.jsp
*@FileTitle : Entry and Inquiry of Target Voyage Choose by Settlement Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.21 박희동
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
//	String staSheet  = "";
//	String finSheet  = "";

	String mnthCondSheet = "";
	String mnthNameSheet = "";
	String portCondSheet = "";
	String portNameSheet = "";
	String portTypeSheet = "";
	String ptTpNameSheet = "";
	String operTypeSheet = "";
	String operNameSheet = "";

	String[] dir = null;
//	String[] sta = null;
//	String[] fin = null;
	String[] mnthCond = null;
	String[] portCond = null;
	String[] portType = null;
	String[] operType = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		crrCombo  = eventResponse.getETCData("jo_crr_cd"        );
		abbrSheet = eventResponse.getETCData("sheet1_jo_stl_cd" );
		
		dir = (String[])eventResponse.getCustomData("DIR");
//		sta = (String[])eventResponse.getCustomData("STA");
//		fin = (String[])eventResponse.getCustomData("FIN");
		mnthCond = (String[])eventResponse.getCustomData("MONTH");
		portCond = (String[])eventResponse.getCustomData("PORT");
		portType = (String[])eventResponse.getCustomData("PORT_TYPE");
		operType = (String[])eventResponse.getCustomData("OPER_TYPE");
		
		dirSheet = dir[0];
//		staSheet = sta[0];
//		finSheet = fin[0];
		mnthCondSheet = mnthCond[0];
		mnthNameSheet = mnthCond[1]; 
		portCondSheet = portCond[0];
		portNameSheet = portCond[1];
		portTypeSheet = portType[0];
		ptTpNameSheet = portType[1];
		operTypeSheet = operType[0];
		operNameSheet = operType[1];

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Entry and Inquiry of Target Voyage Choose by Settlement Item</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<script language="javascript">
var gMnthCondSheet = "<%=mnthCondSheet%>";
var gPortCondSheet = "<%=portCondSheet%>";
var gPortTypeSheet = "<%=portTypeSheet%>";
var gOperTypeSheet = "<%=operTypeSheet%>";
var gMnthNameSheet = "<%=mnthNameSheet%>";
var gPortNameSheet = "<%=portNameSheet%>";
var gPtTpNameSheet = "<%=ptTpNameSheet%>";
var gOperNameSheet = "<%=operNameSheet%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage("<%=crrCombo%>","<%=abbrSheet%>","<%=dirSheet%>");
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
<input type="hidden" name="curr_row">
<input type="hidden" name="jo_stl_opt_cd">
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
					<td width="45">Month</td>
					<td width="180"><input type="text" style="width:60" class="input1" name="acct_yrmon" value="<%=yyyyMM%>" dataformat="ym" maxlength=6>&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name="btns_back">&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name="btns_next"></td>
					<td width="45">Carrier</td>
					<td width="100"><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,1);</script><input type="checkbox" value="N" name="proc_jb_flg" id="proc_jb_flg" class="trans"></td>
					<td width="300">
					 	<table border="0" style="width:250;" class="search_sm">
					 	<tr  class="h23"><td width="70">Rev./Exp.</td>
						 <td width="" class="noinput1" style="font-size:12;"><input type="radio" name="re_divr_cd" value="R" class="trans" checked> Revenue <input type="radio" name="re_divr_cd" value="E" class="trans"> Expense </td></tr></table>
					</td>
					<td width="40">Trade</td>
					<td width="130"><script language="javascript">ComComboObject('trd_cd',1,55,0,1);</script></td>
					<td width="40">Lane</td>
					<td width=""><script language="javascript">ComComboObject('rlane_cd',4,100,0,1);</script></td>
					</tr> 
				</table>
				
				<!--  biz_1   (E) -->
				
				</td></tr>
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
				<!-- Hidden IBSheet For IBCombo-->
				<table width="0%"  id="mainTable"> 
					<tr>
						<td width="0%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_copy" name="btn_copy" auth="C">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_add" name="btn_add" auth="C">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_del" name="btn_del" auth="C">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_enable" id="btn_enable" auth="A">Adjust Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_create" id="btn_create" auth="U">Create</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save" auth="C">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete" id="btn_delete" auth="D">Adjust Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel" id="btn_downexcel" auth="R">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_lskd" id="btn_lskd" auth="C">L/SKD</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- Copyright (S) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>