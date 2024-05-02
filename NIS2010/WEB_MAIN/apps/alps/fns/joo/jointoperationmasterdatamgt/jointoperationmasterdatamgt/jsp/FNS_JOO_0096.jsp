<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FNS_JOO_0096.jsp
*@FileTitle : Additional Slot Sales
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : 길정권
*@LastVersion : 1.0
* 2014.05.20 길정권
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0096Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0096Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfcCd         = "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");

	String tradeComboList ="";
	String tradeSheetList ="";
	String rlaneSheetList ="";
	String carriSheetList ="";
	String dirctSheetList ="";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfcCd  = account.getOfc_cd();

		event = (FnsJoo0096Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		tradeComboList = eventResponse.getETCData("tradeComboList");
		tradeSheetList = eventResponse.getETCData("tradeSheetList");
		rlaneSheetList = eventResponse.getETCData("rlaneSheetList");
		carriSheetList = eventResponse.getETCData("carriSheetList");
		dirctSheetList = eventResponse.getETCData("dirctSheetList");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Carrier Merger</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var gUserOfcCd = "<%=strOfcCd%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage("<%=tradeComboList%>","<%=tradeSheetList%>","<%=rlaneSheetList%>","<%=carriSheetList%>","<%=dirctSheetList%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
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
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						
						<td width="60">Carrier</td>
						<td width="120"><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,0);</script></td>

						<td width="62">Trade</td>
						<td width="248"><script language="javascript">ComComboObject('trd_cd',1,55,0,0);</script></td>
						
						<td width="60">Lane</td>
						<td width="149"><script language="javascript">ComComboObject('rlane_cd',1,80,0,0);</script></td>
						<td>&nbsp;</td>
						
						<td width="38">VVD</td>
	                    <td><input type="text" style="width:90" class="input" maxlength='9' value="" name="vvd_cd" dataformat="engup"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="60">Rev/Exp</td>
						<td width="120"><script language="javascript">ComComboObject('re_divr_cd', 1, 85, 1,0 );</script></td>
						
	                    <!--td width="60">Date</td>
	                    <td width="250">
	                    	<input type="text" name="cre_dt_fr" style="width:75;text-align:center" class="input" caption="from date" requred dataformat="ymd" maxlength="8" cofield="cre_dt_to" value="" required>&nbsp;~&nbsp;<input type="text" name="cre_dt_to" style="width:75;text-align:center" class="input" caption="to date" requred dataformat="ymd" maxlength="8" cofield="cre_dt_fr" value="" required>&nbsp;<img src="img/btns_calendar.gif" name="cre_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
	                    </td-->
						<td width="60">Date</td>
						<td width="250"><input type="text" name="cre_dt_fr" style="width:60;ime-mode:disabled" value="" class="input"  maxlength="6" dataformat="ym" >
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;
						<input type="text" name="cre_dt_to" style="width:60;ime-mode:disabled" value="" class="input" maxlength="6" dataformat="ym" >
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle"></td>

						<td width="60">Settled</td>
	                    <!--td width="160"><input type="text" style="width:80" class="input" maxlength='5' value="" name="setl_cd" dataformat="engup"></td-->						
						<td width="160"><script language="javascript">ComComboObject('stl_flg', 1, 65, 1,0 );</script></td>
						
						<td width="40">Del</td>
						<td><script language="javascript">ComComboObject('delt_flg',1,55,1,0);</script></td>
					</tr>
				</table>
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
	
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 			
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
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
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_copy" name="btns_copy" auth="C">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>				
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Row Delete</td>
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrive">Retrieve</td>
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<input type="hidden" name="code">
<input type="hidden" name="name">
<input type="hidden" name="super_cd1">
<input type="hidden" name="super_cd2">
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>