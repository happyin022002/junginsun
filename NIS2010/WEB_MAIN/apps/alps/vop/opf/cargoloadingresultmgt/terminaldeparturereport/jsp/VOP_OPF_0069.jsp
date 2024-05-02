<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0069.jsp
*@FileTitle : Terminal Productivity Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.09.03 김종옥
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0069Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>

<%
	VopOpf0069Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0069Event)request.getAttribute("Event");
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
<title>Terminal Productivity Report</title>
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
<input type="hidden" name="tml_prod_rpt_flg">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\">
<input type="hidden" name="com_mrdSaveDialogFileName" value="Terminal_ProductivityReportPrintPreview">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdDisableToolbar">
<input type="hidden" name="com_mrdTitle" value="Terminal Productivity Report Print Preview">
<input type="hidden" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Terminal Productivity Report Print Preview</span>">

<!-- 개발자 작업	-->
<input type="hidden" name="now_date" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd")%>">
<input type="hidden" name="last_day" value="<%=DateTime.lastDayOfMonth(DateTime.getFormatDate(new Date(),"yyyyMMdd"))%>">
<input type="hidden" name="carr_cd">
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
       	<tr>
       		<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="490">
						<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="70">&nbsp;&nbsp;Level</td>
							<td class="stm">
								RHQ&nbsp;<script language="javascript">ComComboObject('rhq', 1, 70, 1);</script>
								&nbsp;&nbsp;&nbsp;&nbsp;Port&nbsp;<input type="text" style="width:55;ime-mode:disabled" class="input" name="loc_cd" dataformat="engup" maxlength="5" caption="Port" required fullfill>&nbsp;<img src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<script language="javascript">ComComboObject('yd_cd', 2, 46, 1);</script>
								&nbsp;&nbsp;&nbsp;&nbsp;Lane&nbsp;<script language="javascript">ComComboObject('slan_cd', 1, 60, 1);</script>
							</td>
						</tr>
						</table>
					</td>
					<td width="50">Group</td>
					<td width="140">
						<script language="javascript">ComComboObject('group_by', 1, 100, 1);</script>
					</td>					
					<td width="60">Period</td>
					<td>
						<input type="text" name="from_date" style="width:60;" class="input1" dataformat="ym" maxlength="6" caption="Period">&nbsp;<img src="img/btns_calendar.gif" name="from_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;<input type="text" name="to_date" style="width:60;" class="input1" dataformat="ym" maxlength="6" caption="Period">&nbsp;<img src="img/btns_calendar.gif" name="to_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
				</tr> 
				<tr><td height="5"></td></tr>
				<tr class="h23">
					<table>
					<tr class="h23">
						<td width="270">
							<table class="search_sm2" border="0"  style="width:100%;">
							<tr class="h23">
								<td style="width:90;">&nbsp;Carrier Code</td>
								<!-- td align="left" class="stm">
								<input type="radio" name="carr_cd" value="SML" class="trans" checked>SML&nbsp;&nbsp;&nbsp;<input type="radio" name="carr_cd" value="" class="trans">Other
								</td -->
								<td width="25"><input type="checkbox" name="carr_cd1" class="trans" value="SML" checked></td>
								<td width="">SML</td>
								<td width="25"><input type="checkbox" name="carr_cd2" class="trans" value="O"></td>
								<td width="">Other</td>
							</tr>
							</table>
						</td>
						<td width="40">&nbsp;</td>
						<td width="110">Excluded fm TPR</td>
						<td width="60"><input type="checkbox" name="tml_prod_rpt_rsn_cd" class="trans" value="Y"></td>
						<td width="462">						
							<table class="search_sm2" border="0"  style="width:100%;">
							<tr class="h23">
								<td>&nbsp;Target&nbsp;&nbsp;</td>
								<td width="202">
									<script language="javascript">ComComboObject('target_lanes', 1, 160, 1);</script>&nbsp;<img src="img/btns_search.gif" name="btn_target_lanes" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								<td>
									<script language="javascript">ComComboObject('target_ports', 1, 160, 1);</script>&nbsp;<img src="img/btns_search.gif" name="btn_target_ports" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
				
			</td>
		</tr>
		</table>
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
		<table class="search" id="mainTable"> 
		<tr>
			<td class="bg">
				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<!-- Grid (E) -->
			</td>
		</tr>
		</table>
		<!-- Grid BG Box  (S) -->
			
		<!-- TAB [ Port/Oper ] (S) -->
		<div id="tabLayer" style="display:none">
			<!-- Grid BG Box  (S) -->
	     	<table class="search" id="mainTable">
	       	<tr><td class="bg">

				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
				</table>
				<!-- Grid (E) -->

				</td></tr>
			</table>
			<!-- Grid BG Box  (S) -->
		</div>
		<!-- TAB [ Port/Oper ] (E) -->			
			
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr>
			<td  class="btn1_bg">
			 	<table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
			    		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Detail">TDR Details</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Excel">Down Excel</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	    <!--Button (E) -->
		<!--biz page (E)-->
	</td>
</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>