<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0007.jsp
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 신영재
*@LastVersion : 1.0
* 2015.11.03 신영재
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
<%@ page import="com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.event.EesDod0007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesDod0007Event event = null; 						//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd      = "";
	Logger log = Logger.getLogger("com.hanjin.apps.DodDropOff.DropOffCreation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesDod0007Event)request.getAttribute("Event");
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
<title>Tariff Registration Confirm</title>
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
<input type="hidden" name="s_trf_div_cd">
<input type="hidden" name="s_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id %>">
<!-- 개발자 작업 -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px;">

	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
						<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
				<tr>
					<td class="btn2_bg" style="text-align:right;">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_new">New</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								
				
					
								
							</tr>
						</table>
					</td>
				 </tr>									
			</table>
		<!-- Button (E) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" style="width:979;">
						<tr class="h23">
										<td width="50"> Office </td>
										<td width ="80">
											 	<input type="text" class="input2" style="width:60px;text-align:center" dataformat="engup" name="login_ofc_cd" value="<%=strOfc_cd %>" readOnly maxlength="6"   ></td>
										<td width="55">  Country </td>
										<td = width= "80">
											 	<input type="text" class="input" style="width:30px; text-align:center" dataformat="engup" name="s_cnt_cd" maxlength="2" required caption="s_cnt_cd" fullfill ></td>
									    <td width="100">  &nbsp;&nbsp;&nbsp;RTN-Location </td>
										<td = width="80">
											 	<input type="text" class="input" style="width:60px; text-align:center" dataformat="engup" name="s_rtn_loc_cd" maxlength="5" required caption="s_rtn_loc_cd" fullfill ></td>

										<td width="100"> &nbsp;&nbsp;&nbsp;Effective Date </td> 
										<td width=""><input type="text" style="width:80;text-align:center;" class="input" size="8" maxlength="10"  onKeyPress='ComKeyOnlyNumber(window);' onKeyUp="pointAutoMove(this.value);" onKeyDown="dod_isNumD(this, 'Y');" onBlur="dod_validateDateObj(this);" name="s_frm_eff_dt"  dataformat="ymd" cofield="s_to_eff_dt" caption="start date">&nbsp;~
								 			<input type="text" style="width:80;text-align:center;" class="input" size="8" maxlength="10" onKeyPress='ComKeyOnlyNumber(window);' onKeyDown="dod_isNumD(this, 'Y');" onBlur="dod_validateDateObj(this);" name="s_to_eff_dt"  dataformat="ymd" cofield="s_frm_eff_dt" caption="end date">
											<img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;"></td>	
									
						                <td class="spcLayer"><input type="radio" class="trans"  name="s_no_type" value="S" checked>
										<td class="spcLayer">S/C No.</td>
										<td class="spcLayer"><input type="radio" class="trans"  name="s_no_type" value="R">
										<td class="spcLayer" >RFA No.</td>
										<td width="135" class="spcLayer"><input name="s_no" type="text" style="width:85;text-align: center;ime-mode:disabled" maxlength="10"></td>
										
						
						
						</tr>
					</table>
				</td>
			</tr>
		</table>
							
					
			</tr>
				
		</table>
		<!-- Tab (S) -->
		<table class="height_10"><tr><td></td></tr></table>
   		<table class="tab">
        	<tr><td><script language="javascript">ComTabObject("tab1")</script>
		</table>

		<!-- Tab (E) -->
		<!-- Tab DIV Region/Country (S) -->
		<!-- biz page (S) -->
		<div id="tabLayer" style="display:inline">

			
			<!--  Grid(S) -->
			<table class="search">
							<tr>
								<td class="bg" valign="top">
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject("sheet1");</script></td>
										</tr>
									</table>
								
								</td>
							</tr>
			</table>
				<!-- Grid (E) -->
			

		</div>
		<!-- Tab DIV Region/Country (E) -->
		
		
				<!-- Tab DIV Special (S) -->
		<!-- biz page (S) -->
		<div id="tabLayer" style="display:inline">

						
			<!--  Grid(S) -->
			<table class="search">
							<tr>
								<td class="bg" valign="top">
									<table width="100%" id="mainTable">
										<tr>
											<td><script language="javascript">ComSheetObject("sheet2");</script></td>
										</tr>
									</table>
								
								</td>
							</tr>
			</table>
				<!-- Grid (E) -->
			

		</div>
				<!-- Tab DIV Region/Country (E) -->
					<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
				<tr>
					<td class="btn2_bg" style="text-align:right;">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
			
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left">
											<td class="btn2" name="btn_confirm">Confirm</td>
											<td class="btn2_right">
										</tr>
									</table>
								</td>
								
							</tr>
						</table>
					</td>
				 </tr>									
			</table>
		<!-- Button (E) -->

		
				</td>
			</tr>
</table>







<!-- 개발자 작업 끝 -->
</form>
</body>
</html>