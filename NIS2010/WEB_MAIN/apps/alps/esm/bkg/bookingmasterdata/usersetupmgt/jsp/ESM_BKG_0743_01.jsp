<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0743_01.jsp
	 *@FileTitle : B/L Print Option
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0743Event"%>	
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.StringTokenizer" %>

<%
	EsmBkg0743Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	boolean bBtn_Disabled = true;

	String bkg_no = "";
	String form_manifest = "";
	String form_hiddeData = "";
	String cnt_cd = "";
	String param_ui_id = "";
	
	String form_remark = ""; // Draft B/L의 Remark값 - 값이 없을 경우(사용자의 입력이 없을 경우) 기존방식(테이블에서 쿼리로)으로 처리

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		cnt_cd = account.getCnt_cd();
		
		event = (EsmBkg0743Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkg_no = request.getParameter("bkg_no") == null ? "" : request.getParameter("bkg_no");

		form_manifest = request.getParameter("form_manifest") == null ? "N" : request.getParameter("form_manifest");

		form_hiddeData = request.getParameter("form_hiddeData") == null ? "N" : request.getParameter("form_hiddeData");

		form_remark = request.getParameter("form_remark") == null ? "" : request.getParameter("form_remark");
		param_ui_id = request.getParameter("param_ui_id") == null ? "" : request.getParameter("param_ui_id");

		/*
		out.println("########################################<br>");
		out.println("<br>");
		out.println("bkg_no : [" + bkg_no + "]<br>");
		out.println("form_manifest : [" + form_manifest + "]<br>");
		out.println("form_hiddeData : [" + form_hiddeData + "]<br>");
		out.println("form_remark : [" + form_remark + "]<br>");
		out.println("<br>");
		out.println("########################################");
		*/

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="p_bkg_no"      value="<%=bkg_no%>">
	<input type="hidden" name="bkg_no"      value="">
	<input type="hidden" name="usr_id"      value="<%=strUsr_id%>">
	<input type="hidden" name="upd_usr_id"      value="<%=strUsr_id%>">
	<input type="hidden" name="ofc_cd"      value="<%=strOfc_cd%>">
	<input type="hidden" name="bl_prn_dvc_nm"      value="">
	<input type="hidden" name="obl_rlse_flg"      value="">
	
	<input type="hidden" name="corr_no"      value="">
	<input type="hidden" name="form_manifest"      value="<%=form_manifest%>">
	<input type="hidden" name="form_remark" value="<%=form_remark%>">
	<input type="hidden" name="uid" value="ESM_BKG_0743_01">
	<input type="hidden" name="param_ui_id" value ="<%=param_ui_id%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;B/L Print Option</td></tr>
		</table>
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

			<!--biz page (S)-->
		<table class="search" border='0'> 
       	<tr><td class="bg" valign='top'>
       	
       	
			<table class="search" border='0'> 
       		<tr><td valign='top' style="padding-top:5;">

				<!--  biz_1  (S) -->
				<table class="search_sm2" border="0" width="260">
					<tr class="h23">
						<td width="40">Type</td>
						<td width="" class="stm">
							<input type="radio" name="paper_type" value="1"	class="trans" checked>&nbsp;A4&nbsp;&nbsp;&nbsp;
							<input type="radio" name="paper_type" value="4" class="trans" >&nbsp;Letter
							<input type="radio" name="paper_type" value="10" class="trans">&nbsp;DOT&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr><td width="90"><input type="checkbox" value="Y" name="preview_yn" class="trans">&nbsp;Preview</td>
						<td colspan="2"><input type="checkbox" value="Y" name="hiddenData" class="trans" <% if (form_hiddeData.equals("Y")) {%>checked<%}%>>&nbsp;Display Hidden Data</td>
					</tr> 
					<tr style="display:none"><td width="90"><input type="checkbox" value="Y" name="rider_only_yn" class="trans">&nbsp;Rider Only</td>
						<td><input type="checkbox" value="Y" name="nvocc_only_yn" class="trans">&nbsp;NVOCC H/BL only</td>
						<td><input type="checkbox" value="Y" name="rider_nvocc_yn" class="trans">&nbsp;Rider + NVOCC H/BL</td>
					</tr>
					<tr><td height="5"></td></tr>
				</table>				
				<!--  biz_1   (E) -->

				<!-- Grid  (S) -->
				<table width="100%" class="grid2" id="mainTable"> 
				<tr><td width="30%" class="tr2_head">B/L Type</td>
					<td colspan="2" class="input">&nbsp;
					<script language="javascript">ComComboObject('form_type', 1, 202, true, '');</script>
					<!--<select name="form_type" style="width:200">
						<option value="1">A/Notice with B/L</option>
						<option value="2" selected>Non-Negotiable B/L</option>
						<option value="3">Non-Negotiable B/L for A/R</option>
						<option value="4">Original B/L</option>
						<option value="5">Sea Waybill</option>
						<option value="6">Sea Waybill for A/R</option>
					</select>
					--></td></tr>
				<tr><td class="tr2_head">Charge Type</td>
					<td colspan="2" class="input">&nbsp;
					<script language="javascript">ComComboObject('form_Rate', 1, 202, true, '');</script>
						<!--<select name="form_Rate" style="width:200">
							<option value="1" selected>Normal</option>
							<option value="2">B/L for Audit</option>
							<option value="3">FRT ALL as Arranged</option>
							<option value="4">FRT CCT as Arranged</option>
							<option value="5">FRT PPD as Arranged</option>
							<option value="6">No Charge</option>
							<option value="7">Incl. Manifest Charge</option>
						</select>
					--></td></tr>
				<tr><td class="tr2_head">Container Type</td>
					<td colspan="2" class="input">&nbsp;
					<script language="javascript">ComComboObject('form_Cntr', 1, 202, true, '');</script>
						<!--<select name="form_Cntr" style="width:200">
							<option value="1" selected>Normal</option>
							<option value="2">Remark with PKG</option>
							<option value="3">CNTR and Seal No. Only</option>
							<option value="4">No Information (for Break Bulk)</option>
						</select>
					--></td></tr>
				<tr><td class="tr2_head" nowrap>Print Setup (Face)</td>
					<td class="input" width="250" style="padding-left:5px" nowrap>
					<script language="javascript">ComComboObject('bl_face_prn_dvc_nm', 1, 200, '');</script>
					&nbsp;<img
									class="cursor" src="img/btns_search.gif" name="btn_Print_Setup"
									width="19" height="20" alt="" border="0" align="absmiddle">
					<!--<input type="text" style="width:240" value="" class="input1"  name="bl_face_prn_dvc_nm" maxlength='100' required fullfill  dataformat='engupnum' style="ime-mode:disabled">-->
					</td>					
					<td class="input">
						<select style="width:50" class="input" name="face_print_cnt">
							<option value="0">0</option>
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
						</select></td></tr>
				<tr><td class="tr2_head" nowrap>Print Setup (Rider)</td>
					<td class="input" style="padding-left:5px" nowrap>
					<script language="javascript">ComComboObject('bl_ridr_prn_dvc_nm', 1, 200, '');</script>
					&nbsp;<img
									class="cursor" src="img/btns_search.gif" name="btn_Print_Setup"
									width="19" height="20" alt="" border="0" align="absmiddle">
					<!--<input type="text" style="width:240" value="" class="input1"  name="bl_ridr_prn_dvc_nm" maxlength='100' required fullfill  dataformat='engupnum' style="ime-mode:disabled">
					--></td>
					<td class="input">
						<select style="width:50;" class="input"  name="rider_print_cnt">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
						</select>
					</td></tr>
					
					<tr><td class="tr2_head" nowrap>Print Margin</td>					
					<td colspan="2" class="input">&nbsp;
						<select style="width:50" class="input" name="bl_prn_mgn_val">
							<option value="0"selected>0</option>
							<option name ="-1" value="1" >-1</option>
							<option name ="-2" value="2" >-2</option>
							<option name ="-3" value="3" >-3</option>
							<option name ="-4" value="4" >-4</option>
							<option name ="-5" value="5" >-5</option>
							<option name ="1" value="6" >1</option>
							<option name ="2" value="7">2</option>
							<option name ="3" value="8">3</option>
							<option name ="4" value="9">4</option>
							<option name ="5" value="10">5</option>
							<option name ="6" value="11">6</option>
							<option name ="7" value="12">7</option>
							<option name ="8" value="13">8</option>
							<option name ="9" value="14">9</option>
							<option name ="10" value="15">10</option>
							
						</select></td></tr>
				</table> 
				<!-- Grid (E) -->
			
				<div style="display:none">
					<table class="search" border="0" style="width:100%;"> 
						<tr><td height="5"></td></tr>
						<tr class="h23">
							<td width="150" class="stm"><input type="checkbox" value="Y"	name="bl_ca_yn" class="trans">&nbsp;B/L before C/A</td>
							<td>C/A No.&nbsp;<script language="javascript">ComComboObject('ca_no', 1, 120, true, '');</script></td>
						</tr>
					</table>
				</div>
 
 				</td>
 				<td width="450" style='padding:4px' valign='top'> <!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%" style='padding-top:4px'>
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<table width="100%"  id="mainTable">
						<tr>
							<td width="60" style='padding-top:4px'>
										<b>Result</b>							
							</td>
							<td width="100" style='padding-top:4px'>
										Total: <span id="div_total"></span>
							</td>
							<td width="120" style='padding-top:4px'>
										Success: <span id="div_success">0</span>
							</td>
							<td style='padding-top:4px'>
										Failure: <span id="div_failure">0</span>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->
				</td>
			</tr>
		</table>

 

	</td>
	</tr>
</table>
<table class="height_5"><tr><td></td></tr></table>
			</td></tr>
			</table> 
<!-- : ( Button : pop ) (S) -->

<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Print">Print</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Print_Release">Print & Release</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>							
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_save">Save Print Setup</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td class="btn1_line"></td>							
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>

					</tr>
				</table>
	
			</td>
		</tr>
	</table>

		</td>
	</tr>
</table>
<!--Button (E) --> 
	
	
	<!--td valign="top"><textarea name="test_textarea" rows="20" cols="80" readOnly>test_textarea</textarea>
	</td-->
<!-- : ( Button : pop ) (E) -->

<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="0" width="0">
		<script language="javascript">comRdObject('report1');</script>
		</td>
	</tr>
	<tr>
		<td height="0" width="0">
		<script language="javascript">comRdObject('report2');</script>
		</td>
	</tr>
	<tr>
		<td height="0" width="0">
		<script language="javascript">comRdObject('report3');</script>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
<div style="width:1px;height:1px">
	<script language="javascript">
	comRdObjectPopup("Rdviewer");
	</script>
</div>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>