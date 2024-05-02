<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0001.jsp
*@FileTitle : P/F SKD Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.09 서창열
* 1.0 Creation
*
* History
* 2011.04.15 진마리아 padding-right 설정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0001Event)request.getAttribute("Event");
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
<title>P/F SKD Settlement</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="port_cd">
<input type="hidden" name="min_max_spd">
<input type="hidden" name="port_name">
<input type="hidden" name="zd">
<input type="hidden" name="port_info_cnt">
<input type="hidden" name="curr_pos">
<input type="hidden" name="first_port_cd">
<input type="hidden" name="second_port_cd">
<input type="hidden" name="third_port_cd">
<input type="hidden" name="data_pos">
<input type="hidden" name="yd_cd">
<input type="hidden" name="currPos">
<input type="hidden" name="new_sim_data">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;<span id="navigation"></span>
					</td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span>
					</td>
				</tr>
			</table>
			<!--Page Title, Historical (E)-->
			<!--biz page (S)-->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="90">Simulation No.</td>
								<td width="150"><input type="text" style="width:70" name="sim_dt" class="input1" value="" maxlength="8" dataformat="int" tabIndex="1">&nbsp;<input type="text" style="width:35;text-align:right" name="sim_no"  class="input1" value="" maxlength="3" dataformat="int" tabIndex="2" onKeyPress="if(event.keyCode==13) doSearch();">&nbsp;<img src="img/btns_search.gif" name="btns_search03" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td>
								<td width="75">Lane Code</td>
								<td width="95"><input type="text" style="width:50;ime-mode:disabled;text-align:center" class="input" name="vsl_slan_cd" maxlength="3" dataformat="uppernum"  value="" tabIndex="3">&nbsp;<img src="img/btns_search.gif" class="cursor" name="btns_search" width="19" height="20" alt="" border="0" align="absmiddle"></td>
								<td width="90" style="visibility:hidden">Standard IND</td>
								<td width="" style="visibility:hidden"><select  name="slan_stnd_flg" style="width:61;" class="input" tabIndex="4"><option value="Y">Y</option><option value="N" selected="selected">N</option></select>
								</td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="90" style="display:none">P/F SKD Type</td>
								<td width="150" style="display:none"><input type="text" style="width:40;ime-mode:disabled;text-align:center" class="input" dataformat="uppernum" name="pf_svc_tp_cd" value="" maxlength="4" tabIndex="5">&nbsp;<img src="img/btns_search.gif" name="btns_search02"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle" ></td>
								<td width="90">Vessel Class</td>
								<td width="300"><input type="text" style="width:50;text-align:center" class="input" name="n1st_vsl_clss_cd" dataformat="int" value="" >&nbsp;<input type="text" style="width:20;text-align:right" class="input" name="n1st_vsl_clss_knt" value="" >&nbsp;&nbsp;&nbsp;<input type="text" style="width:50;text-align:center" class="input" name="n2nd_vsl_clss_cd" dataformat="int" value="" >&nbsp;<input type="text" style="width:20;text-align:right" class="input" name="n2nd_vsl_clss_knt" value="" >&nbsp;&nbsp;&nbsp;<input type="text" style="width:50;text-align:center" class="input" name="n3rd_vsl_clss_cd" dataformat="int" value="" >&nbsp;<input type="text" style="width:20;text-align:right" class="input" name="n3rd_vsl_clss_knt" value="" >&nbsp;&nbsp;&nbsp;</td>
								<!-- <td width="300"><input type="text" style="width:50;text-align:center" class="input2" name="n1st_vsl_clss_cd"  value="">&nbsp;<input type="text" style="width:20;text-align:right" class="input2" name="n1st_vsl_clss_knt" value="">&nbsp;&nbsp;&nbsp;<input type="text" style="width:50;text-align:center" class="input2" name="n2nd_vsl_clss_cd" value="">&nbsp;<input type="text" style="width:20;text-align:right" class="input2" name="n2nd_vsl_clss_knt" value="">&nbsp;&nbsp;&nbsp;<input type="text" style="width:50;text-align:center" class="input2" name="n3rd_vsl_clss_cd" value="">&nbsp;<input type="text" style="width:20;text-align:right" class="input2" name="n3rd_vsl_clss_knt" value="">&nbsp;&nbsp;&nbsp;</td> -->
								<td width="60">Duration</td>
								<td width="80"><input type="text" style="width:40;text-align:right" class="input" name="svc_dur_dys" value="" ></td>
								<td width="60">Frequency</td>
								<td width=""><input type="text" style="width:37;text-align:right"  maxlength="2" class="input" name="brth_itval_dys" value="" ></td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="90">Remark(s)</td>
								<td colspan="9"><input type="text" style="width:100%;ime-mode:disabled" class="input" name="pf_skd_rmk"  value=""  maxlength="4000"  tabIndex="6"></td>
							</tr>				
						</table> 
						<!--  biz_1   (E) -->
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<!--  biz_2  (S) -->
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
									<script language="javascript">ComSheetObject('sheet2');</script>
									<script language="javascript">ComSheetObject('sheet3');</script>
									<script language="javascript">ComSheetObject('sheet4');</script>
								</td>
							</tr>
						</table> 
						<!-- Grid (E) -->
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
				       		<tr>
				       			<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RowAdd">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RowInsert">Row Insert</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RowDelete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_UploadExcel">Upload Excel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_DownExcel">Down Excel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>	
										</tr>
									</table>
								</td>
							</tr>
						</table>
				    	<!-- Button_Sub (E) -->	
						<!-- BKG Information (S) -->
						<table class="search" border="0"><tr><td class="height_8"></td></tr></table>
						<table class="search" border="0" style="width:979; display:none" > 
							<tr class="h23">
								<td width="550">
									<table border="0" style="width:545; background-color:white;" class="grid2"> 
										<tr>
											<td class="tr2_head" width="107">Maximum Speed</td>
											<td width="72"><input type="text" style="width:99%;text-align:right" class="noinput" name="max_spd" value="" ReadOnly="readonly"></td> 
											<td class="tr2_head" width="101">Sea Buffer Ratio</td>
											<td width="72"><input type="text" style="width:99%;text-align:right" class="noinput" name="sea_buf_rat" value="" ReadOnly="readonly"></td>
											<td class="tr2_head" width="113">P/F Speed Ratio</td>
											<td width="72"><input type="text" style="width:99%;text-align:right" class="noinput" name="pf_spd_rat" value="" ReadOnly="readonly"></td>
										</tr>
										<tr>
											<td class="tr2_head">Total Buffer Ratio</td>
											<td><input type="text" style="width:99%;text-align:right" class="noinput" name="tot_buf_rat" value="" ReadOnly="readonly"></td>
											<td class="tr2_head">Port Buffer Ratio</td>
											<td><input type="text" style="width:99%;text-align:right" class="noinput" name="port_buf_rat" value="" ReadOnly="readonly"></td>
											<td class="tr2_head">Buffer Speed Ratio</td>
											<td><input type="text" style="width:99%;text-align:right" class="noinput" name="buf_spd_rat" value="" ReadOnly="readonly"></td>
										</tr>
									</table>
								</td>
								<td width="9"></td>
								<td width="420" valign="top">
									<table border="0" style="width:420; background-color:white;" class="grid2"> 
										<tr>
											<td class="tr2_head" width="35">L/F</td>
											<td width="85"><input type="text" style="width:99%;text-align:right;" name="lf" class="noinput" value="" readOnly="readonly"></td> 
											<td class="tr2_head" width="45">G.REV</td>
											<td width="135"><input type="text" style="width:99%;text-align:right;" name="rev" class="noinput" value="" readOnly="readonly"></td> 
											<td class="tr2_head" width="45">EOTP1</td>
											<td><input type="text" style="width:99%;text-align:right;" name="eotp1"class="noinput" value="" readOnly="readonly"></td>
										</tr>
										<tr>
											<td class="tr2_head">RPB</td>
											<td width=""><input type="text" style="width:99%;text-align:right;" name="rpb" class="noinput" value="" readOnly="readonly"></td>
											 <td class="tr2_head">OP</td>
											<td><input type="text" style="width:99%;text-align:right;" name="op" class="noinput" value="" readOnly="readonly"></td>
											<td class="tr2_head">EOTP2</td>
											<td width=""><input type="text" style="width:99%;text-align:right;" name="eotp2" class="noinput" value="" readOnly="readonly"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>	
						<!-- BKG Information (E) -->
						<!--  biz_2   (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--biz page (E)-->
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    <tr>
    	<td class="btn1_bg">
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
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_MCalculation">M/Calculation</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<!-- 7월10일 버튼 삭제
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_EOTP">EOTP</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Settlement">Settlement</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_BerthWindow">Berth Window</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					 -->
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- Copyright (S) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>