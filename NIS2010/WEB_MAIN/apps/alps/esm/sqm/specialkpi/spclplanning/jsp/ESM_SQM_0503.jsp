<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0503.jsp
*@FileTitle      : Basic CMCB (CM Cost Per Box) New Lane Add
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.11
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.11 이혜민
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
<%@ page import="com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.event.EsmSqm0503Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String p_spcl_tgt_cd = JSPUtil.getParameter(request, "f_spcl_tgt_cd", "");
	
	EsmSqm0503Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.specialkpi.spclplanning");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0503Event)request.getAttribute("Event");
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
<title>Basic CMCB (CM Cost Per Box) New Lane Add</title>
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
<input type="hidden" name="p_bse_tp_cd" value="<%= p_bse_tp_cd%>">
<input type="hidden" name="p_spcl_tgt_cd" value="<%= p_spcl_tgt_cd%>">
<input type="hidden" name="f_trd_cd" >
<input type="hidden" name="f_rlane_cd" >
<input type="hidden" name="f_src_rlane_cd">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="550" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="500" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Basic CMCB_New Lane Add</td></tr>
			</table>
			<!-- : ( Title ) (E) -->
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" width="500" border="0">
				<tr>
					<td class="bg">
						<table >
							<tr>
								<td width="200" rowspan="2">
									<table class="search_sm2" width="180" border="0">
										<tr class="h23">
											<td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" disabled><label style="padding-left:2;">Yearly</label></td>
											<td><input type="radio" name="f_spcl_tgt_cd" class="trans" value="R" disabled><label style="padding-left:2;">Reefer</label></td>
										</tr>
										<tr class="h23">
											<td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" disabled><label style="padding-left:2;">Quarterly</label></td>
											<td><input type="radio" name="f_spcl_tgt_cd" class="trans" value="S" disabled><label style="padding-left:2;">Special</label></td>
										</tr>
									</table>
								</td>
								<td width="300">
									<table class="search" border="0">
										<tr class="h23">
											<td width="50">Year</td>
											<td width="75"><input type="text" name="f_bse_yr" style="width:70;text-align:center;ime-mode:disabled;" readonly class="input2" value="<%= p_bse_yr%>"></td>
											<td width="135"></td>
										</tr>
										<tr class="h23">
											<td width="50"><div id="div_qtr">Quarter</div></td>
											<td width="75"><input type="text" name="f_bse_qtr_cd" style="width:70;text-align:center;ime-mode:disabled;" readonly class="input2" value="<%= p_bse_qtr_cd%>"></td>
											<td width="135" class='sm'><div id="div_period"></div></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="line_bluedot" width="500" border="0"><tr><td colspan="8"></td></tr></table>	

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table width="100" class="search" border="0">
				<tr>
					<td class="bg_b1">
						<table width="400" border="0" class="height_10"><tr><td></td></tr></table>
						<!-- : ( POR ) (S) -->
						<table width="510" border="0" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<table width="550" class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="550" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Creation" id="btn_Creation">Creation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>