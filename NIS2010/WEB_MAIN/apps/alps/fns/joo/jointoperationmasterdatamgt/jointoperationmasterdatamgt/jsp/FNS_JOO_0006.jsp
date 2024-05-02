<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0006.jsp
*@FileTitle : Carrier Merger
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.11 박희동
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
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

		event = (FnsJoo0006Event)request.getAttribute("Event");
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
					<td width="50">Trade</td>
					<td width="100"><script language="javascript">ComComboObject('trd_cd',1,60,0,0);</script></td>
					<td width="40">Lane	</td>
					<td width="100"><script language="javascript">ComComboObject('rlane_cd',1,80,0,0);</script></td>
					<td width="80">Carrier Code</td>
					<td width="100"><script language="javascript">ComComboObject('jo_crr_cd',1,60,0,0);</script></td>
					<td width="">
		                <table class="search_sm2" border="0" style="width:300;"> 
		                    <tr class="h23">    
		                    <td width="90">Delete Mark</td>
		                    <td width="" class="stm"><input type="radio" class="trans" name='delt_flg'  value='A' checked>&nbsp;All
		                    &nbsp;&nbsp;<input type="radio" class="trans"     name='delt_flg'  value='N' >&nbsp;No
		                    &nbsp;&nbsp;<input type="radio" class="trans"     name='delt_flg'  value='Y' >&nbsp;Yes</td>     
		                    </tr>
		                    </table>
					</td>
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