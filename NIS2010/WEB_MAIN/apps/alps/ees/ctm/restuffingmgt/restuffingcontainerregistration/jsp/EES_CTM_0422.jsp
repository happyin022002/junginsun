<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0422.jsp
*@FileTitle : Restuffing Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.04 우경민
* 1.0 Creation
* 2011.02.28 나상보
* CHM-201109072 Restuffing Remarks 항목 수정 (CTM)
* 1. Remarks 항목 480자 입력 제한
* 2. Remarks 항목 특수문자 입력 가능하도록 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0422Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0422Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RestuffingMgt.ContainerMovementMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0422Event)request.getAttribute("Event");
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
<title>Restuffing Creation</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg" style="height:516" valign="top">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="85">Origin Yard</td>
					<td width="60" style="padding-top:1;"><input type="text" maxlength="5" style="width:55;text-align:center;ime-mode:disabled;" name="p_yard1" class="input1" tabindex="1"></td>
					<td width="70"><script language="javascript">ComComboObject('p_yard2', 2, 50 , 0, '', 2, 0, 2)</script></td>
					<td width="75">Event date</td>
					<td><input type="text" style="width:75;ime-mode:disabled" maxlength="10" class="input1"  tabindex="4" name="p_date">&nbsp;<img src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar1">
						<input type="text" style="width:50;ime-mode:disabled" maxlength="5" class="input1" tabindex="5" name="p_time"><input type="hidden" name="p_date0">
					</td>
				</tr>
				<tr class="h23">
					<td>Reason Code</td>
					<td style="padding-left:2" colspan="2"><input type="text" style="width:60;display:none;" class="input" name="p_reson" readonly>
            <span id='m_combo' style="display:">
              <script language="javascript">ComComboObject('p_reson_op', 2, 108 , 0, '', 2, 0, 6)</script>
            </span>&nbsp;</td>
				</table>
        <table width="650" class="search_sm2" border="0">
          <tr class="h23">
            <td><table class="search_sm2" border="0">
                <tr class="h23">
                  <td class="stm">&nbsp;&nbsp;<input type="text" readonly style="width:20;border:0;text-align:right;display:none" name="sm0"></td>
                  <td>&nbsp;<input type="text" style="width:100;display:none" name="dm0" class="input2"></td>
                  <td class="stm">&nbsp;&nbsp;<input type="text" readonly style="width:20;border:0;text-align:right;display:none" name="sm1"></td>
                  <td>&nbsp;<input type="text" style="width:100;display:none" name="dm1" class="input2"></td>
                  <td class="stm">&nbsp;&nbsp;<input type="text" readonly style="width:20;border:0;text-align:right;display:none" name="sm2"></td>
                  <td>&nbsp;<input type="text" style="width:100;display:none" name="dm2" class="input2"></td>
                  <td class="stm">&nbsp;&nbsp;<input type="text" readonly style="width:20;border:0;text-align:right;display:none" name="sm3"></td>
                  <td>&nbsp;<input type="text" style="width:100;display:none" name="dm3" class="input2"></td>
                </tr>
              </table></td>
          </tr>
        </table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>


				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Object</td></tr>
				</table>
				<!-- Grid  (S) -->
				<table width="650" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="650" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_mvmt">MVMT History</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</td></tr>
			</table>
				</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				<!--  biz_2   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<!--  biz_3  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Replace</td></tr>
				</table>
				<!-- Grid  (S) -->
				<table width="650"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>

				<!-- Grid (E) -->

				<!--  biz_3  (E) -->

			<!--  Button_Sub (S) -->
			<table width="650" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<!--
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_copy">Row&nbsp;Copy</td>
						<td class="btn2_right"></td>

						</tr>
						</table></td>
						-->
				</tr>
			</table>
				</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<table class="search" border="0" style="width:650;">
				<tr class="h23">
					<td width="70">Remark(s)</td>
					<td><input type="text" style="width:100%;ime-mode:disabled;" class="input1" name="p_rmk" maxlength="480"></td>
				</tr>
				</table>

	<!--biz page (E)-->
	</td></tr>
		</table>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
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