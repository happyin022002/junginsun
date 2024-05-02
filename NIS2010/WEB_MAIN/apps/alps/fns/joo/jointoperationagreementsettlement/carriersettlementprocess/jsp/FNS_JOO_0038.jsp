<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0038.jsp
*@FileTitle : Summary of Monthly Clearance Status by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.10 장강철
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0038Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0038Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.CarrierSettlementProcess");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0038Event)request.getAttribute("Event");
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
<title>Summary of Monthly Clearance Status by VVD</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usdamount_chk">
<input type="hidden" name="summarydetail">
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
					<td width="30">VVD</td>
					<td width="120"><input type="text" style="width:90" class="input1" name='vvd' caption='VVD' style="ime-mode:disabled" maxlength=10 minlength=4 required   value=""></td>
					<td width="50">Carrier </td>
					<td width="90">&nbsp;<script language="javascript">ComComboObject('jo_crr_cd', 1, 60, 0, 0, 0 );</script>&nbsp;</td>
					<!-- 
					<td width="40">Type </td>
					 -->
					<td width="40">Item </td>
					<td width="90">&nbsp;<script language="javascript">ComComboObject('jo_stl_itm_cd', 1, 60, 0, 0,0 );</script></td>
					<td width="145">
							<table class="search_sm" border="0" style="width:145">
							<tr class="h23">
								<td width="145" class="noinput1">&nbsp;<input type="checkbox" name="usdamount_chk2" class="trans" >USD Amount
								</td>
							</tr>
							</table>
					</td>
					<td width="200">
							<table class="search_sm2" border="0" style="width:95%;">
                            <tr class="h23">
                                <td width="275" class="noinput1">&nbsp;<input type="radio"  value="S" name='summarydetail_radio'  class="trans" checked>&nbsp;&nbsp;Summary&nbsp;&nbsp;&nbsp;<input type="radio" value="D" name='summarydetail_radio' class="trans" >&nbsp;&nbsp;Detail&nbsp;&nbsp;&nbsp;
                                </td>                               
                            </tr>
                            </table>
						
					</td>
					<td width=""></td>
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
			<table width="100%" class="search" id="mainTable"> 
				<tr>
					<td width="100%" id="sheet_acct_detail1">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 	
			 <table width="100%"  id="mainTable">
                 <tr>
                     <td width="100%" id="sheet_acct_detail2" style="display:none">
                         <script language="javascript">ComSheetObject('sheet2');</script>
                     </td>
                 </tr>
             </table>
			 <table width="100%"  id="mainTable">
                 <tr>
                     <td width="100%" id="sheet_acct_detail3" style="display:none">
                         <script language="javascript">ComSheetObject('sheet3');</script>
                     </td>
                 </tr>
             </table>
			 <table width="100%"  id="mainTable">
                 <tr>
                     <td width="100%" id="sheet_acct_detail4" style="display:none">
                         <script language="javascript">ComSheetObject('sheet4');</script>
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
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td>
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn1_New">New</td>
									<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td class="btn1_line"></td>
							
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn1_Down_Excel">Down Excel</td>
									<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
					</tr>
					</table>
			    <!--Button (E) -->
				</td>
			</tr>
		</table>
		 </td>
	 </tr>
 </table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>