<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0013.jsp
*@FileTitle : Monthly Estimation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.07 김진일
* 1.0 Creation
*
* History
* 2010.10.27 진마리아 CHM-201006714-01 추정결산 로직 보완
* 2011.03.04 진마리아 CHM-201108564-01 I/F to ERP화면내 조회 로직 및 버튼 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0013Event)request.getAttribute("Event");
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
<title> Monthly Estimation Creation</title>
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
<input type="hidden" name="sdt">
<input type="hidden" name="edt">
<input type="hidden" name="acct_cd">
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
						<td width="110">Revenue Month</td>
						<td width="">
							<input type="text" name="txtsdate" dataformat="ym" caption="시작년월" maxlength="6" size="10" cofield="txtedate" style="width:60;" class="input1" value="">&nbsp;<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
							&nbsp;~&nbsp;
							<input type="text" name="txtedate" dataformat="ym" caption="종료년월" maxlength="6" size="10" cofield="txtsdate" style="width:60;" class="input1" value="">&nbsp;<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						<td width="90">Account Code</td>						
						<!--<td width=""><input type="text" name="acct_cd" class="input" dataformat="int" maxlength="6"/></td>-->
						<td width="">&nbsp;<script language="javascript">ComComboObject('combo1', 2, 250, 0, 1)</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="47">Status</td>						
						<td width=""><input type="text" name="status" class="input2" readonly/></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
				
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
				
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0">
		    					<tr>
		    						<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_down_excel">Down Excel</td>
											<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>			
						</td>
					</tr>
				</table> 
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_Detail">Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_creation">Creation</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>
</td></tr>
</table>
<!-- Copyright (S) 
<table class="copy">
<tr><td class="familysite">&nbsp;
		<select name="sitelink" id="sitelink" class="select_family" onChange="javascript:go_sitelink(this);">
       	<option selected>&nbsp;&nbsp;  -- Family Site --  &nbsp;&nbsp;</option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
   		</select>
	</td>
	<td class="copy"><img src="img/img_bottom_logo.gif" width="460" height="16" alt="" border="0"></td></tr>
</table>
 Copyright(E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>