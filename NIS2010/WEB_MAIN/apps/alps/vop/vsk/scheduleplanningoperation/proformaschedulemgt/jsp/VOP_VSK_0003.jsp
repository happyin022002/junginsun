<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0003.jsp
*@FileTitle : P/F SKD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.22 서창열
* 1.0 Creation
*
* History
* 2010.09.09 유혁 CHM-201005742-01 Non-Weekly P/F SKD 생성
* 2011.04.15 진마리아 padding-right 설정
* 2013.05.06 정상기    CHM-201221593 Proforma Schedule Excel Import 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (VopVsk0003Event)request.getAttribute("Event");
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
<title>P/F SKD Creation</title>
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
<input type="hidden" name="min_max_spd">
<input type="hidden" name="port_cd">
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
<input type="hidden" name="vsl_svc_tp_cd">
<input type="hidden" name="check_vsl_skd">
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
					<td class="title">
						<img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span>
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
								<td width="80">Lane Code</td>
								<td width="105"><input type="text" style="width:60;ime-mode:disabled;text-align:center" name="vsl_slan_cd" class="input1" maxlength="3" dataformat="uppernum" value="" tabIndex="1" onKeyPress="if(event.keyCode==13) doSearch();">&nbsp;<img src="img/btns_search.gif" name="btns_search"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td>
								<td width="87">P/F SKD Type</td>
								<td width="119"><input type="text" style="width:60;ime-mode:disabled;text-align:center" name="pf_svc_tp_cd" class="input1" dataformat="uppernum" maxlength="4" value="" tabIndex="2" onKeyPress="if(event.keyCode==13) doSearch();">&nbsp;<img src="img/btns_search.gif" name="btns_search02"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td> 
								<td width="90">Standard IND</td>   
								<td width="80">
									<select name="slan_stnd_flg" style="width:50;" class="input1">
										<option value="N" selected="selected">N</option>
										<option value="Y">Y</option>
									</select>	
								</td>
								<td width="70">Multi IND</td>   
								<td width="80">
									<select name="mml_usd_flg" style="width:50;" class="input1">
										<option value="N" selected="selected">N</option>
										<option value="Y">Y</option>
									</select>	
								</td>
								<td width="100">Updated Date</td>
								<td><input type="text" style="width:110;" name="upd_dt" class="input2" readOnly="readonly" value="">
								</td> 
							</tr>
							<tr class="h23">
								<td>Vessel Class</td>
								<td colspan="3" style="padding-left:2;">
								<!-- input type="text" style="width:50;ime-mode:disabled" name="n1st_vsl_clss_cd" maxlength="5" dataformat="int" class="input1" value="" tabIndex="3" onKeyPress="if(event.keyCode==13) doSearch();" -->
								<script language="javascript">ComComboObject('combo1',1,60,0,1);</script>&nbsp;<input type="text" style="width:20;ime-mode:disabled;text-align:right" name="n1st_vsl_clss_knt" maxlength="2" dataformat="int" class="input1" value="" tabIndex="4" onKeyPress="if(event.keyCode==13) doSearch();">&nbsp;&nbsp;
								<!-- input type="text" style="width:50;ime-mode:disabled" name="n2nd_vsl_clss_cd" class="input" maxlength="5" dataformat="int" value="" tabIndex="5" onKeyPress="if(event.keyCode==13) doSearch();" -->
								<script language="javascript">ComComboObject('combo2',1,60,0,1);</script>&nbsp;<input type="text" style="width:20;ime-mode:disabled;text-align:right" name="n2nd_vsl_clss_knt" maxlength="2" dataformat="int" class="input" value="" tabIndex="6" onKeyPress="if(event.keyCode==13) doSearch();">&nbsp;&nbsp;
								<!-- input type="text" style="width:50;ime-mode:disabled" name="n3rd_vsl_clss_cd" maxlength="5" dataformat="int" class="input" value="" tabIndex="7" onKeyPress="if(event.keyCode==13) doSearch();" -->
								<script language="javascript">ComComboObject('combo3',1,60,0,1);</script>&nbsp;<input type="text" style="width:20;ime-mode:disabled;text-align:right" name="n3rd_vsl_clss_knt" maxlength="2" dataformat="int" class="input" value="" tabIndex="8" onKeyPress="if(event.keyCode==13) doSearch();"></td>
								<td>Duration</td>
								<td><input type="text" style="width:50;ime-mode:disabled;text-align:right" name="svc_dur_dys" maxlength="4" dataformat="int" class="input" value="" tabIndex="9" onKeyPress="if(event.keyCode==13) doSearch();"></td> 
								<td>Frequency</td>
								<!-- CHM-201005742-01 Frequency 수정 불가 -->
								<td><input type="text" style="width:50;ime-mode:disabled;text-align:right" name="brth_itval_dys" maxlength="2" dataformat="int" class="input2"  value="" readOnly></td> 
								<td colspan="2">P/F SKD History <img src="img/btns_search.gif" name="btns_search03"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td>Remark(s)</td>
									<td colspan="9"><input type="text" style="width:100%;ime-mode:disabled" name="pf_skd_rmk" maxlength="4000"  class="input" value="" tabIndex="10">
								</td>
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
						<table border="0" style="width:979; background-color:white;" class="grid2"> 
							<tr>
								<td width="80" class="tr2_head2">Maximum Speed</td>
								<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="max_spd" value="" readOnly="readonly"></td> 
								<td width="85" class="tr2_head2">Sea Buffer Ratio</td>
								<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="sea_buf_rat" value="" readOnly="readonly"></td>
								<td width="80" class="tr2_head2">P/F Speed Ratio</td>
								<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="pf_spd_rat" value="" readOnly="readonly"></td>
								<td width="90" class="tr2_head2">Total Buffer Ratio</td>
								<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="tot_buf_rat" value="" readOnly="readonly"></td>
								<td width="85" class="tr2_head2">Port Buffer Ratio</td>
								<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="port_buf_rat" value="" readOnly="readonly"></td>
								<td width="100" class="tr2_head2">Buffer Speed Ratio</td>
								<td width="65"><input type="text" style="width:100%;text-align:right;" class="noinput" name="buf_spd_rat" value="" readOnly="readonly"></td>
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
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
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
								<td class="btn1" name="btn_Delete">Delete</td>
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
								<td class="btn1" name="btn_MSimulation">M/Calculation</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_ASimulation">A/Calculation</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>