<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0076.jsp
*@FileTitle : DG Prohibition Summary by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.30 장강철 jkc
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
<%@ page import="com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0076Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	VopScg0076Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DangerousCargoRestriction.PortRestriction");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0076Event)request.getAttribute("Event");
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
<title>DG Prohibition Summary by Port</title>
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
<!-- 개발자 작업 -->

<form name="form">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="70">Port Code</td>
					<td width="330"><input type="text" style="width:60;" class="input1" name='port_cd' dataformat='engup' fullfill   style="ime-mode:disabled" caption='Port Code' required maxlength=5 value="">&nbsp;<img class="Cursor" src="img/btns_search.gif" width="19" height="20" name='srch_port_cd' border="0" align="absmiddle">&nbsp;<input type="text" style="width:200;" class="input2" name='port_cd_nm' value=""></td>
					<td>
						<table class="search_sm2" border="0" style="width:200;">
						<tr class="h23">
						<td width="60">&nbsp;Option</td>
						<td class="stm"><input type="radio" value='class' name='optclass' class="trans" checked   >Class&nbsp;&nbsp;<input type="radio"  name='optclass'  value='unno' class="trans">UN No.</td>
						</tr>
						</table>
					</td>
				</tr></table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="70">Class</td>
					<td width="90"style="padding-left:2"><script language="javascript">ComComboObject('imdg_clss_cd', 2, 60, 0, 0);</script></td>
					<td width="40">UN No.</td>
					<td><input type="text" style="width:60;" name='imdg_un_no'  class="input" dataformat='eng' style="ime-mode:disabled" caption='UN No.'    fullfill   maxlength=4  value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name='srch_imdg_un_no' width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

		</td></tr>
		</table>
		<!-- 1 (E) -->

		<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="998">
			<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab ) (E) -->

		<!-- 2 (S) -->
		<div id="tabLayer" style="display:inline">
			<!--<table class="height_8"><tr><td></td></tr></table>-->
			<table class="search" id="mainTable">
	       		<tr><td class="bg">

				<!-- Grid - 1 (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				</td></tr>
			</table>
		</div>

		<div id="tabLayer" style="display:inline">
			<!--<table class="height_8"><tr><td></td></tr></table>-->
			<table class="search" id="mainTable">
	       		<tr><td class="bg">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				</td></tr>
			</table>
			<!-- Grid - 1 (E) -->
		</div>

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve"  id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Excel" id="btn_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->


		<!--biz page (E)-->



	</td></tr>
		</table>
	</td></tr>
		</table>

	<table class="height_10"><tr><td colspan="8"></td></tr></table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>