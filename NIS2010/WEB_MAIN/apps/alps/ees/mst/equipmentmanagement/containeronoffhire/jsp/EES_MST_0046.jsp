<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0046.jsp
*@FileTitle : Manufacture Date & Manufacturer Inquiry and Update
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.02.18 이호선
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffHire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesMst0046Event)request.getAttribute("Event");
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
<title>::</title>
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
<input type="hidden" name="hidden_curdate">
<input type="hidden" name="cntr_nos">

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
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg" style="height:515;" valign="top">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Lessor</td>				
					<td> 
						<table class="search" style="width:805;">
						<tr class="h23">
						<td>
							<input type="text" name="vndr_seq" maxlength="6" style="width:70;text-align:center;ime-mode:disabled" readOnly value="" class="input1">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup2">&nbsp;<input type="text" name="vndr_lgl_eng_nm" readonly style="width:200;ime-mode:disabled" class="input2" value="">
						</td>	
						<td width="100">Lease Term</td>
						<td width="100"><select style="width:55;"  name="lstmcd" style="text-align:center">
						    <option value="" >&nbsp&nbspALL</option>
							<option value="ST" >&nbsp&nbspST</option>
							<option value="LT" >&nbsp&nbspLT</option>
							</select>
						</td>
						<td width="60">AGMT No.</td>
						<td width="180">&nbsp;<input type="text" style="width:35" class="input" dataformat="engup" name="agmt_cty_cd" maxlength="3" value="HHO">&nbsp;<input type="text" style="width:84" class="input" dataformat="engup" name="agmt_seq" style="ime-mode:disabled;text-align:center" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTargetAgmtNo"></td>
						</tr>
						</table>
					</td>
					<td></td>
					<td></td>
					
				</tr> 
				</table>
				<table class="search" border="0" style="width:859;"> 
				<tr class="h23">
					<td width="150">Manufacture Date Flag</td>
					<td class="stm"><input type="radio" name="md_flg" value="Y" class="trans" >&nbsp;Yes&nbsp;&nbsp;<input type="radio" name="md_flg" value="N" class="trans" checked>&nbsp;No</td>
					<td width="120">Manufacturer Flag</td>
					<td class="stm"><input type="radio" name="m_flg" value="Y" class="trans" >&nbsp;Yes&nbsp;&nbsp;<input type="radio" name="m_flg" value="N" class="trans" checked>&nbsp;No</td>
				</tr> 
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

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_loadexcel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>							
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downexcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
