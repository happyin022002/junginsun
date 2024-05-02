<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0622.jsp
*@FileTitle : Outbound Container Movement Status
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.31
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.01.31 조정민
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0622Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0622Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0622Event)request.getAttribute("Event");
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
<title>Outbound Container Movement Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="mrdPath">
<input type="hidden" name="email_to">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="email_subject" value="O/B Container Movement Status">
<input type="hidden" name="eml_content" value="O/B Container Movement Status">
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
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">

					<td width="20"></td>
					<td width="82">VVD</td>
					<td width="148"><input type="text" name="vvd"  style="width:100" value="" dataformat="engupnum"  maxlength="9" class="input1"></td>
					<td width="90">POL/YARD</td>
					<td width="85"><input type="text" name="pol_cd"  style="width:80" value="" dataformat="engupnum" maxlength="5" class="input1"></td>
					<td width="87"><input type="text" name="pol_yd_cd"  style="width:40" dataformat="engupnum" value="" maxlength="2" class="input"></td>
					<td width="144">EXEMPTION STATUS</td>
					<td width="117"><select name="ntc_exp" style="width:80;">
						<option value="ALL" selected>ALL</option>
						<option value="DG DIRECT">DG DIRECT</option>
						<option value="FREE IN">FREE IN</option>
						<option value="TACKLE">TACKLE</option>
						<option value="CFS">CFS</option>
						</select></td>	
					<td width="190">POL TML GATE IN STATUS</td>
					<td width="102"><select name="tml_gi_sts" style="width:70;">
						<option value="ALL">ALL</option>
						<option value="Y">Y</option>
						<option value="N" selected>N</option>					
						</select></td>		
				</tr>
				
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="15"></td>
					<td width="77">R/D TERM</td> 					
					<td width="50">&nbsp;<script language="javascript" >ComComboObject('rcv_term_cd', 2, 48, 1)</script></td>
					<td width="90">&nbsp;<script language="javascript" >ComComboObject('de_term_cd', 2, 48, 1)</script></td>


					<td width="94">CARGO TYPE</td>
					<td width="165"><script language="javascript">ComComboObject("bkg_cgo_tp_cd", 1, 125, 1);</script>
					</td>			
					<td width="138">TRANS MODE</td>
					<td width="162">&nbsp;<select name="trns_mode" style="width:80;">
						<option value="ALL" selected>ALL</option>
						<option value="S/TRK">S/TRK</option>
						<option value="HJT">HJT</option>	
						<option value="SHUTTLE">SHUTTLE</option>					
						</select></td>		
					<td width="240"></td>				
				</tr>	
				</table>
				
			</td></tr>
	</table>	

		    <table class="height_8"><tr><td></td></tr></table>

   			<table class="search"><tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" class="search" id="mainTable">
					<tr><td width="90%"><script language="javascript">ComSheetObject("sheet1");</script></td></tr>
				</table>
				<!-- Grid (E) -->
				
				<table class="height_2"><tr><td></td></tr></table>

				<!-- Grid  (S) -->
				<table width="100%" class="search" id="mainTable">
					<tr><td width="100%"><script language="javascript">ComSheetObject("sheet2");</script></td></tr>
				</table>
				<!-- Grid (E) -->

			</td></tr></table>
		</td>
	</tr>
</table>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0"
	cellspacing="0" style="padding-top: 5; ">
	<tr>

		<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
                     <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                         <tr><td class="btn1_left"></td>
                         <td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
                         <td class="btn1_right"></td>
                         </tr>
                     </table></td>
					<td id="div_pic"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_print">Print</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td id="div_pic"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Send">Send&nbsp;Notice</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td id="div_pic"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_EQHistory">EQ&nbsp;History</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
			</table>
      		</td>
	</tr>
</table>
<!--Button (E) --> 
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
</form>
</body>
</html>