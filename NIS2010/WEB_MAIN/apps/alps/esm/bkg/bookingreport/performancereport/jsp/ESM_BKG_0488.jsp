<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0488.jsp
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.10 강동윤
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0488Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0488Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc= account.getOfc_cd();

		event = (EsmBkg0488Event)request.getAttribute("Event");
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
<title>SI Receiving List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		document.form.rcv_ofc_cd.value = "<%= strUsr_ofc %>";
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="sr_knd_cd">
<input type="hidden" name="rcv_rmk">
<input type="hidden" name="usr_id" value="<%= strUsr_id %>">
<input type="hidden" name="usr_grp_cd">
<input type="hidden" name="dpcs_wrk_prt_cd">
<input type="hidden" name="dpcs_wrk_svr_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="44">Period</td>
					<td width="210">
						<input type="text" name="from_dt" style="width:75" value="" class="input1" style="width:80;ime-mode:disabled" dataformat="ymd" maxlength="10" size="10" >
						&nbsp;~&nbsp;
						<input type="text" name="to_dt"  style="width:75" class="input1" value="" dataformat="ymd" maxlength="10" size="10" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar"></td>
					<td width="100">Transfer Status</td>
					<td width="100"><select name="sr_mtch_sts_cd" style="width:90;">
						<option value="">ALL</option>
						<option value="A" selected>Wt + Prc</option>
						<option value="W">Waiting</option>
						<option value="P">Processing</option>
						<option value="T">Transferred</option>						
						</select>
					</td>
					<td width="40">Office</td>
					<td width="70"><input type="text" name="rcv_ofc_cd" dataformat="engup" style="width:60" value="" class="input"></td>
					<td width="90">Incl. Sub OFC</td>
					<td width="30">
						<input type="checkbox" name="ofc_inc_sub" value="Y" class="trans">
					</td>
					
					<td width="45">BKG No</td>
					<td width="100"><input type="text" name="bkg_no" dataformat="engupnum" style="width:90" value="" class="input"></td>
					
					
					<td width="45">SI No</td>
					<td><input type="text" name="sr_no" dataformat="engupnum" style="width:100" value="" class="input"></td>
					
				</tr>
				</table>
				<table  id="div_Eml_cond" class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="60">Valid BKG</td> 
					<td width=""><script language="javascript">ComComboObject('sr_bkg_sts_cd', 1, 100, '');</script></td>			

					<td width="60">Urgency</td>
					<td width=""><script language="javascript">ComComboObject('sr_urgency_cd', 1, 100, '');</script></td>			
		
					<td width="60">SR Kind</td>
					<td width=""><script language="javascript">ComComboObject('sr_knd_combo_cd', 1, 100, '');</script></td>	
							
					<td width="110" align="left">Split BKG &nbsp;<input type="checkbox" value="S" id="split_bkg_yn" name="split_bkg_yn" class="trans" tabindex="44"></td>											
					<td width=""></td>

					<td width="70">I/F Status</td>
					<td width="100"><script language="javascript">ComComboObject('sr_if_status_cd', 1, 100, '');</script></td>					
 
					
				</tr>	
				</table>
			</td></tr>
	</table>	
				<!--  biz_1   (E) -->
<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				<!-- Tab ) (S) -->
	     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
	       		<tr><td width="100%">
							<script language="javascript">ComTabObject('tab1')</script>
						</td></tr>
</table>
				<!-- Tab ) (E) --> 
				
<div id="tabLayer" style="display:inline">				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
</div>			
<!--TAB 1 (E) --> 

			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table id="div_EmlCtnt" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Eml_Ctnt_View" id="btn_Eml_Ctnt_View">View&nbsp;Mail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table id="div_si_info_Save" width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_si_info_Save" id="btn_si_info_Save">Edit Tag</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>								
				<td class="btn1_line"></td>
				
				<td><table id="div_Save" width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Remark Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table id="div_Delete" width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--  
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_InputRemark">Input  Remark</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				<td><table id="div_GotoBKGMatch" width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1"  name="btn_GotoBKGMatch">Go to BKG Match</td>
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
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
		</table>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>