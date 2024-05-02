<%
/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0065.jsp
*@FileTitle : Fleet Status
*Open Issues : 
*Change history : CHM-201430343 HJSBIZ_CR_1454    Fleet status 수정 보완 요청건 
*@LastModifyDate : 2014.12.12
*@LastModifier :  YONG JOON, LEE 
*@LastVersion : 1.4
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0065Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0065Event event = null;
	Exception serverException = null;    // 서버에서 발생한 에러
	String strErrMsg = "";               // 에러메세지
	int rowCount = 0;                    // DB ResultSet 리스트의 건수 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.depositinvoice.depositinvoice");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopOpf0065Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
	
	String toDate = JSPUtil.getKST("yyyy-MM-dd");
	//String effDt = DateTime.addDays(expDt, -10, "yyyy-MM-dd");
%>
<html>
<head>
<title>Container Deposit Invoice</title>
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
<!-- 개발자 작업 -->

<!-- Input Box for Report Designer  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\">
<input type="hidden" name="com_mrdSaveDialogFileName" value="StevedoreDamageDetail">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdDisableToolbar">
<input type="hidden" name="com_mrdTitle" value="Container Cargo List Print">
<input type="hidden" name="com_mrdBodyTitle" value="Container Cargo List Print">

<!-- RD Pinter -->
<input type="hidden" name="com_rdSubSysCd" value="">
<input type="hidden" name="com_from" value="">
<input type="hidden" name="com_fromName" value="">
<input type="hidden" name="com_recipient" value="">
<input type="hidden" name="com_carbonCopy" value="<">
<input type="hidden" name="com_blindCarbonCopy">
<input type="hidden" name="com_subject" value="Re:SDMS Application">
<input type="hidden" name="com_fileKey">
<input type="hidden" name="com_content">
<input type="hidden" name="default_content" value="">
<input type="hidden" name="com_templateMrd" value="AON_BKK_0005.mrd">
<input type="hidden" name="com_templateMrdArguments">
<input type="hidden" name="com_templateMrdDescription" value="">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->

			<!-- biz page (S) -->
			<table  border="0" height="40" style="width:100%;">
				<tr class="h23">
					<td class="bg" width="650" valign="top">
												
						<table class="height_5">
		              		<tr><td colspan="10" class="height_2"></td></tr>
		              	</table>
		              
						<table class="height_5"><tr><td></td></tr></table>
						<table border="0" width="100%">
							<tr class="h23" align="center">
								<td width="350"></td>
								<td width="400">
									<table class="search" border="0" style="width:100%;">
										<tr class="h23">
											<td width="300"></td>
											<td width="30"></td>
											<td width="130"></td>
										</tr>
										<tr class="h23">
											<!-- <td width="300"></td>-->
											
											<td width="50">Type</td>
											<td width="150">
												<select style="width:110;" name="vsl_type" tabIndex="1">
													<option value="" selected>ALL</option>
													<option value="O">Owner</option>
													<option value="C">Charter</option>
													<option value="J">Joint Operation</option>
												</select>
											</td>
											
											<td>&nbsp;&nbsp;Owner</td>
											<td colspan="3" ><input type="text" name="ownr_nm" style="width:150;" class="input2"  caption="Owner" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_ownerpop" width="19" height="20" alt="" border="0" align="absmiddle"><input type="hidden" name="ownr_seq">
											
											<td width="50">&nbsp;&nbsp;Carrier</td>
                    						<td colspan="2"><input type="text" name="carrier_cd" style="width:70;text-align:center; IME-MODE:disabled; text-transform:uppercase;" class="input" required fullfill maxlength="3" onblur="obj_deactivate();">&nbsp;<img src="img/btns_search.gif" name="btn_crr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
											
											<td width="50">&nbsp;&nbsp;Date</td>
											<td colspan="3"><input type="text" name="p_date" dataformat="ymd" maxlength="8" caption="Date"  class="input" style="ime-mode:disabled; width:80px; text-align:center;" value="<%=toDate%>"><img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;"></td>
											
											<td width="30">&nbsp;&nbsp;BSA</td>
											<td colspan="3" ><input type="checkbox" name="bsa_type" value="Y" class="trans"></td>
										</tr>
									</table>
								</td>
							</tr>						
						</table>
					</td>
					<td width="57" valign="top"></td>
					<td width="300" valign="top">
						<table width="300"  height="68" id="mainTable0">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject("sheet1");</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>


			<table class="height_8"><tr><td></td></tr></table>


			<table class="search">
				<tr>
					<td class="bg" valign="top">
						<!-- biz_2 (S) -->
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject("sheet2");</script></td>
							</tr>
						</table>						
						<!-- Grid (E) -->		
					</td>
				</tr>
			</table>
			<!-- biz page (E) -->


			<!-- Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
				<tr>
					<td class="btn1_bg">
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
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left">
											<td class="btn1" name="btn_downExcel">Down Excel</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Print">Print</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
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