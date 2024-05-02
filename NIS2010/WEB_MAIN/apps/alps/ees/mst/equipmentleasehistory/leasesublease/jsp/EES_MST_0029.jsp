<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0029.jsp
*@FileTitle : Container Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.09 이호선
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
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String cntr_no          = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentLeaseHistory.LeaseSublease");
	
	// popflg 값 가져오기.
	String popflag = JSPUtil.getParameter(request,"popflag".trim(), "");
	if(popflag == null){
		popflag = "";
	}	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMst0029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		cntr_no = JSPUtil.getParameter (request, "cntr_no".trim() ,"");
		if (cntr_no == null)
			cntr_no = "";

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Container Status Inquiry</title>
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
<input type="hidden" name="popflag" value="<%=popflag%>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<%if(popflag == "") {%>
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;Equipment Management > CNTR Master > Status > Container Status Inquiry</td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			<%}else{ %>
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"></td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Container Status Inquiry</td></tr>
			<%} %> 		
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		
			
		
		<!-- Grid BG Box  (S) -->
     	<table class="search">
       	<tr><td class="bg" style="height:515;" valign="top">
		
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">CNTR No.</td>
					<td width="83"><input type="text" name="cntr_no"  style="width:80;text-align:center;text-transform:uppercase;ime-mode:disabled;" class="input1" maxlength="10" dataformat="engup" value="<%=cntr_no%>"></td>
					<td width="18"><input type="text" style="width:15;text-align:center" class="input2"  dataformat="int" maxlength="1" name = "chk_dgt" value=""></td>
					<td width="100"><input type="text" style="width:60;" class="input2"  readOnly value="" name = "aciac_div_cd" style="text-align:center"></td>
					<td width="70">TP/SZ</td>
					<td width="100"><input type="text" style="width:60;" class="input2"  readOnly value="" name = "cntr_tpsz_cd" style="text-align:center"></td>
					<td width="50">Term</td>
					<td width="100"><input type="text" style="width:60;" class="input2"  readOnly value="" name = "lstm_cd" style="text-align:center"></td>
					<td width="60">ISO Code</td>
					<td width=""><input type="text" style="width:60;" class="input2"  readOnly value="" name = "cntr_tpsz_iso_cd" style="text-align:center"></td>
				</tr> 
				<tr class="h23">
					<td width="">Old/New</td>
					<td width="" colspan="3"><input type="text" style="width:80;" class="input2"  readOnly value="" name = "cntr_old_van_flg" style="text-align:center"></td>
					<td width="">Ownership</td>
					<td width=""><input type="text" style="width:60;" class="input2"  readOnly value="" name = "ownr_co_cd" style="text-align:center"></td>
					<td width="">Current</td>
					<td width=""><input type="text" style="width:60;" class="input2"  readOnly value="" name = "cntr_use_co_cd" style="text-align:center"></td>
					<td width=""></td>
					<td width=""></td>
					<td width=""></td>
					<td width=""></td>
					<td width=""></td>
				</tr> 
				</table>
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
			
			<!-- Grid  (S) -->
														
			<table width="100%" id="mainTable"> 
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
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="Down_Excel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
<%
if(popflag != "") {				// 팝업으로 호출될 경우
%>
	<!-- : ( Button : pop ) (S) -->
	<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td width="">
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				</tr>
			</table>
	    <!--Button (E) -->
		
		</td></tr>
	</table>
	<!-- : ( Button : pop ) (E) -->
<%
}
else				// 메인으로 호출될 경우.
{
%>	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
    
<%
}
%>    
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>