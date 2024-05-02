<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0047.jsp
*@FileTitle : Reefer Unit Info Inquiry and Update
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.18
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.10.18 남궁진호 1.0 Creation [CHM-201006507-01]
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0047Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0047Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

		event = (EesMst0047Event)request.getAttribute("Event");
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
<title>Reefer Unit Info Inquiry and Update</title>
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
<input type="hidden" name="eq_knd_cd" value="U">

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
					<td width="50">Lessor</td>				
					<td width="340"> 
						<input type="text" name="vndr_seq" maxlength="6" style="width:50;text-align:center;ime-mode:disabled" readOnly value="" class="input1">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup2">
						<input type="text" name="vndr_abbr_nm" readonly style="width:50;ime-mode:disabled" class="input2" value="">
						<input type="text" name="vndr_lgl_eng_nm" readonly style="width:200;ime-mode:disabled" class="input2" value="">
					</td>	
					<td width="80">Lease Term</td>
					 <td style="padding-left:2;">
						    <script language="javascript" >ComComboObject('combo1', 1, 100, 1 );</script>&nbsp
					        <input type="hidden" name="lstm_cd" value="" >
						    
					 </td>
					<td width="70">AGMT No.</td>
					<td width="210"><input type="text" style="width:35" class="input" dataformat="engup" name="agmt_cty_cd" maxlength="3" value="HHO">&nbsp;<input type="text" style="width:84" class="input" dataformat="engup" name="agmt_seq" style="ime-mode:disabled;text-align:center" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTargetAgmtNo"></td>
				</tr>
				<tr class="h23">
					<td width="50">Status</td>
					<td width="340">
					<table class="search_sm2" border="0" style="width:200;"> 
						<td class="stm"><input type="radio" name="sts_flg" value="" class="trans" >&nbsp;All&nbsp;&nbsp;
										<input type="radio" name="sts_flg" value="A" class="trans" checked>&nbsp;Active&nbsp;&nbsp;
										<input type="radio" name="sts_flg" value="I" class="trans" >&nbsp;InActive
						</td>
					</table>
					</td>
					<td width="80">Maker Info</td>
					<td width="220">
						<table class="search_sm2" border="0" style="width:210;"> 
							<td class="stm"><input type="radio" name="mi_flg" value="" class="trans" >&nbsp;All&nbsp;&nbsp;
											<input type="radio" name="mi_flg" value="Y" class="trans" checked>&nbsp;Exists&nbsp;&nbsp;
											<input type="radio" name="mi_flg" value="N" class="trans" >&nbsp;Not Exists
							</td>
						</table>
					</td>
					<td width="70">TP/SZ</td>
					<td style="padding-left:2;">
						    <script language="javascript" >ComComboObject('combo2', 1, 147, 1 );</script>&nbsp;
					        <input type="hidden" name="cntr_tpsz_cd" value="" >
					</td>
				</tr> 
			</table>
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
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
