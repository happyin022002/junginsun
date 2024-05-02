<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1046.jsp
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String repoFlag 		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1046Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		repoFlag = event.getMtyBalanceOptionVO().getRepoFlag();
		if ( repoFlag.equals("MINUS")) {
			repoFlag = "-";
		} else {
			repoFlag = "+";
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>MTY Balance Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=repoFlag %>');
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" onunload="callParentFnc();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="loc_grp_cd"  value="<%=event.getAttribute("loc_grp_cd") %>">
<input type="hidden" name="loc_cd"  value="<%=event.getAttribute("loc_cd") %>">
<input type="hidden" name="fcast_yrwk"  value="<%=event.getAttribute("fcast_yrwk") %>">
<input type="hidden" name="inp_yrwk"  value="<%=event.getMtyBalanceOptionVO().getInpYrwk() %>">
<input type="hidden" name="tp_cd"  value="<%=event.getMtyBalanceOptionVO().getTpCd() %>">
<input type="hidden" name="save_option"  value="<%=event.getAttribute("save_flag") %>">
<input type="hidden" name="search_flag"  value="<%=JSPUtil.getParameter(request, "search_flag") %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=repoFlag %> Others Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<table border="0" style="width:260;" class="search_sm2"> 
						<tr class="h23">
							<td width="">
								<input type="radio" name="viewFlag" class="trans" checked>&nbsp;DRY&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="viewFlag" class="trans">&nbsp;SPCL(RF, OT, FR)
								<input type="radio" name="viewFlag" class="trans">&nbsp;ALL
							</td>
						</tr>
					</table>
					
				<label class="h23" style="width:150;position:absolute;left:300px;top:100px;font-weight:bold;" class="search"><%=event.getAttribute("fcast_yrwk") %> Week</label>
				<table class="height_5"><tr><td colspan="8"></td></tr></table>
			<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable">
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
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
					<td class="btn2" name="btn_RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>


					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Delete">Row Delete</td>
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
	
		
<table class="height_5"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Save">Save</td>
				<td class="btn1_right"></td>
				</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>

