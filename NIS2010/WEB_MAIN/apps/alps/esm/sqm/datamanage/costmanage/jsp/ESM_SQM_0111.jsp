<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESM_SQM_0111.jsp
*@FileTitle      : Basic CMCB (CM Cost Per Box)_Add Creation
*Open Issues     :
*Change history  :
*@LastModifyDate : 2016.07.28
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 1.0 Creation
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0111Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String pBseTpCd    = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String pBseYr      = JSPUtil.getParameter(request, "f_bse_yr", "");
	String pBseQtrCd   = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String pOfcVwCd    = JSPUtil.getParameter(request, "f_ofc_vw_cd", "");	

	String pSubTrdCd   = JSPUtil.getParameter(request, "f_trd_cd", "");
	String pRlaneCd    = JSPUtil.getParameter(request, "f_rlane_cd", "");	
	String pDirCd      = JSPUtil.getParameter(request, "f_dir_cd", "");
	String pRhqCd      = JSPUtil.getParameter(request, "f_rhq_cd", "");
	String pRgnOfcCd   = JSPUtil.getParameter(request, "f_rgn_ofc_cd", "");
	
	EsmSqm0111Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.datamanage.costmanage");
	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmSqm0111Event)request.getAttribute("Event");
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
<title>Basic CMCB (CM Cost Per Box)_Add Creation</title>
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
<input type="hidden" name="f_fm_wk">
<input type="hidden" name="f_to_wk">
<input type="hidden" name="f_bat_id" >
<input type="hidden" name="p_bse_tp_cd" 	value="<%= pBseTpCd%>">
<input type="hidden" name="p_bse_yr" 		value="<%= pBseYr%>">
<input type="hidden" name="p_bse_qtr_cd" 	value="<%= pBseQtrCd%>">
<input type="hidden" name="p_ofc_vw_cd" 	value="<%= pOfcVwCd%>">
<input type="hidden" name="p_trd_cd" 		value="<%= pSubTrdCd%>">
<input type="hidden" name="p_rlane_cd" 		value="<%= pRlaneCd%>">
<input type="hidden" name="p_dir_cd"   		value="<%= pDirCd%>">
<input type="hidden" name="p_rhq_cd"   		value="<%= pRhqCd%>">
<input type="hidden" name="p_rgn_ofc_cd"   	value="<%= pRgnOfcCd%>">

<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Basic CMCB (CM Cost Per Box)_Add Creation</td></tr>
			</table>
			<!-- : ( Title ) (E) -->


			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table width="100%" class="search" >
				<tr>
					<td class="bg" >
						<table class="search">
							<tr>
								<td width="105" rowspan="2">
									<table class="search_sm2" width="95">
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" disabled><label style="padding-left:2;">Yearly</label></td></tr>
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" checked disabled><label style="padding-left:2;">Quarterly</label></td></tr>
									</table>
								</td>
								<td>
									<table class="search">
										<tr class="h23">
											<td width="45">Year</td>
											<td width="75"><script language="javascript">ComComboObject('f_bse_yr', 1, 60, 0, 1)</script></td>
											<td width="60"><div id="div_qtr">Quarter</div></td>
											<td width="85"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 70, 0, 1)</script></td>
											<td width="150" class='sm'><div id="div_period"></div></td>
											<td width="80">Office View</td>
											<td><script language="javascript">ComComboObject('f_ofc_vw_cd', 1, 80, 1, 1)</script></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search">
										<tr class="h23">
											<td width="45">Trade</td>
											<td width="75"><script language="javascript">ComComboObject('f_trd_cd', 1, 60, 1)</script></td>
											<td width="60">R/Lane</td>
											<td width="85"><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 1)</script></td>
											<td width="85">Lane Bound</td>
											<td width="65"><script language="javascript">ComComboObject('f_dir_cd', 1, 50, 1)</script></td>
											<td width="80">RHQ</td>
											<td width="95"><script language="javascript">ComComboObject('f_rhq_cd', 1, 80, 1)</script></td>
											<td width="45">Office</td>
											<td><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 75, 1)</script></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				
						<table class="search"><tr><td class="line_bluedot" style="height:21;"></td></tr></table>
						<table class="search">
							<tr class="h23">
								<td class="gray_tit" colspan="2"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">End Week</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="10">&nbsp;</td>
											<td width="40">Year</td>
											<td width="60"><input type="text" style="text-align:center;" class="input1" size="4" maxlength="4" name="f_year" onchange="period_OnChange();" onKeyPress="ComKeyOnlyNumber(this)"></td>
											<td width="40">Week</td>
											<td width="50"><input type="text" style="text-align:center;" class="input1" size="2" maxlength="2" name="f_week" onchange="period_OnChange();" onKeyPress="ComKeyOnlyNumber(this)"></td>
											<td width="60">Duration</td>
											<td width="50"><input type="text" style="text-align:center;" class="input1" size="2" maxlength="2" name="f_duration" onchange="period_OnChange();" onKeyPress="ComKeyOnlyNumber(this)"></td>
											<td class="sm"><div id="div_period2">&nbsp;</div></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				
						
					</td>
				</tr>
			</table>	
			<!-- TABLE '#D' : ( Search Options ) (E) -->
		

		<!--	<table class="height_10"><tr><td></td></tr></table>-->
			
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			
			<div style="display:none;">
			<table width="100%" class="search" border="0" >
				<tr>
					<td class="bg_b1">
						<!-- : ( POR ) (S) -->
						<table width="100%" border="0" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td>
				</tr>
			</table>
			</div>

		</td>
	</tr>
</table>


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
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