<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0066.jsp
*@FileTitle : Slot Price Simulation 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.15 서창열
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0066Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0066Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (VopVsk0066Event)request.getAttribute("Event");
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
<title>Slot Price</title>
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





<body  onLoad="setupPage();" > 
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="eventNav">
<input type="hidden" name="port_cd">
<input type="hidden" name="dzndCls">
<input type="hidden" name="vslClsCnt">

<table width="100%"  border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history">
						<img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;<span id="navigation"></span>
					</td>
				</tr>
				<tr>
					<td class="title">
						<img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span>
					</td>
				</tr>
			</table>
			<!--Page Title, Historical (E)-->
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
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
											<td class="btn1" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Calculation">Calculation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    	<!--Button (E) -->
			<!--biz page (S)-->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="70">Lane Code</td>
								<td width="150"><input type="text" style="width:60;ime-mode:disabled;text-align:center;" name="vsl_slan_cd" maxlength="3" dataformat="uppernum" class="input1" value="" tabIndex="1" onKeyPress="if(event.keyCode==13) doSearch();">&nbsp;<img src="img/btns_search.gif" class="cursor" name="btns_search" width="19" height="20" alt="" border="0" align="absmiddle"></td>
								<td width="90">P/F SKD Type</td>
								<td width="150"><input type="text" style="width:60;ime-mode:disabled;text-align:center;" class="input1" name="pf_svc_tp_cd" dataformat="uppernum" maxlength="4" value="" tabIndex="2" onKeyPress="if(event.keyCode==13) doSearch();">&nbsp;<img src="img/btns_search.gif" name="btns_search02"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td> 
								<td width="50">Period</td>
								<td  width="200"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" name="slt_prc_wrk_yr" maxlength="4" dataformat="int" tabIndex="3" class="input1" value="">&nbsp;<img src="img/btns_back.gif" name="btns_back" class="cursor" width="18" height="19" alt="" border="0" align="absmiddle">&nbsp;<img src="img/btns_next.gif" name="btns_next"  class="cursor" width="18" height="19" alt="" border="0" align="absmiddle">&nbsp;
									<select style="width:50;text-align:center;" class="input1" name="bse_qtr_cd" tabIndex="4">
										<option value="1Q" selected="selected">1/4</option>
										<option value="2Q">2/4</option>
										<option value="3Q">3/4</option>
										<option value="4Q">4/4</option>
									</select>
								</td>
								<td width="80">Bunker Price</td>
								<td width="" class="stm"><input type="text" style="width:70;text-align:center;ime-mode:disabled;text-align:right" name="bnk_prc" maxlength="10" dataformat="float" class="input" value="" tabIndex="5" >&nbsp;(USD:$)&nbsp;</td>
							</tr>
							<tr class="h23">
								<td width="80">Vessel Class</td>
								<td width="" colspan="6" style="padding-left:2">
									<!-- input type="text" style="width:60;ime-mode:disabled;text-align:right" name="n1st_vsl_clss_cd" maxlength="5" dataformat="int" class="input" value="" tabIndex="6" -->
									<script language="javascript">ComComboObject('combo1',1,60,0,1);</script>&nbsp;<input type="text" style="width:20;ime-mode:disabled;text-align:right" name="n1st_vsl_clss_knt" maxlength="2" dataformat="int" class="input" value="" tabIndex="6">&nbsp;&nbsp;
									<!-- input type="text" style="width:60;ime-mode:disabled;text-align:right" name="n2nd_vsl_clss_cd" class="input" maxlength="5" dataformat="int" value="" tabIndex="7" -->
									<script language="javascript">ComComboObject('combo2',1,60,0,1);</script>&nbsp;<input type="text" style="width:20;ime-mode:disabled;text-align:right" name="n2nd_vsl_clss_knt" maxlength="2" dataformat="int" class="input" value="" tabIndex="8">&nbsp;&nbsp;
									<!-- input type="text" style="width:60;ime-mode:disabled;text-align:right" name="n3rd_vsl_clss_cd" maxlength="5" dataformat="int" class="input" value="" tabIndex="9" -->
									<script language="javascript">ComComboObject('combo3',1,60,0,1);</script>&nbsp;<input type="text" style="width:20;ime-mode:disabled;text-align:right" name="n3rd_vsl_clss_knt" maxlength="2" dataformat="int" class="input" value="" tabIndex="9">
								</td>
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_2  (S) -->
						<!-- Grid 1 (S) -->
						<table width="100%"  class="search" id="mainTable">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">P/F SKD & Port Expense</td>
							</tr>
							<tr>
								<td colspan="2">
									<script language="javascript">ComSheetObject('sheet1');</script>
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!--  Button_Sub (S) -->
						<div id="buttonLayer" style="display:none">
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
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
			    		<!-- Button_Sub (E) -->	
						<!-- Grid 1(E) -->
						<table class="height_10"><tr><td></td></tr></table>
						<!-- Grid 2 (S) -->
						<div id="tableLayer" style="display:none">
							<table width="800" class="grid2"> 
								<tr>
									<td width="100" class="tr2_head">R/Voyage</td>
									<td width="120" class="input2"><input type="text" style="width:99%;text-align:right" class="noinput2" name="durHrs" value="" readonly="readonly"></td>
									<td width="30" class="input2" align="center">Hrs</td>
									<td width="120" class="input2"><input type="text" style="width:99%;text-align:right" class="noinput2" name="durDay" value="" readonly="readonly"></td>
									<td width="40" class="input2" align="center">Days</td>
									<td width="80" class="tr2_head">Sea Time</td>
									<td width="120" class="input1"><input type="text" style="width:99%;text-align:right;ime-mode:disabled" class="noinput1" dataformat="float" name="seaHrs" value=""></td>
									<td width="30"  class="input2"align="center">Hrs</td>
									<td width="120"  class="input2"><input type="text" style="width:99%;text-align:right" class="noinput2" name="seaDay" value="" readonly="readonly"></td>
									<td width="40"  class="input2"align="center">Days</td>
								</tr>
								<tr>
									<td width="" class="tr2_head">Maneuvering</td>
									<td class="input1"><input type="text" style="width:99%;text-align:right;ime-mode:disabled" class="noinput1" dataformat="float" name="maneHrs" value=""></td>
									<td class="input2" align="center">Hrs</td>
									<td class="input2"><input type="text" style="width:99%;text-align:right" class="noinput2" name="maneDay" value="" readonly="readonly"></td>
									<td class="input2" align="center">Days</td>
									<td class="tr2_head">Port Time</td>
									<td class="input1"><input type="text" style="width:99%;text-align:right;ime-mode:disabled" class="noinput1" dataformat="float" name="portHrs" value=""></td>
									<td class="input2" align="center">Hrs</td>
									<td class="input2" ><input type="text" style="width:99%;text-align:right" class="noinput2" name="portDay" value="" readonly="readonly"></td>
									<td class="input2" align="center">Days</td>
								</tr>
								<!-- tr>
									<td width="" class="tr2_head">Service Speed</td>
									<td class="input1" align="right"><input type="text" style="width:100%;text-align:right" class="noinput1" name="serviceSpd" value="" readOnly="readonly"></td>
									<td width="" align="center"></td>
									<td width="" align="right" class="input2" colspan="7"></td>
								</tr -->
							</table> 
						</div>	
						<!-- Grid 2(E) -->
						<table class="line_bluedot"><tr><td></td></tr></table>
						<!-- Grid 2 (S) -->
						<table width="100%" height="10" class="search" id="mainTable">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Bunker Cost</td>
							</tr>
							<tr>
								<td colspan="2">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						<!-- Grid 2(E) -->
						<table class="line_bluedot"><tr><td></td></tr></table>
						<!-- Grid 3 (S) -->
						<table width="100%" height="10" class="search" id="mainTable">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Hire Base</td>
							</tr>
							<tr>
								<td colspan="2">
									<script language="javascript">ComSheetObject('sheet4');</script>
								</td>
							</tr>
						</table>
						<!-- Grid 3(E) -->
						<table class="line_bluedot"><tr><td></td></tr></table>
						<!-- Grid 4 (S) -->
						<table width="100%" height="10" class="search" id="mainTable">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Slot Price</td>
							</tr>
							<tr>
								<td colspan="2">
									<script language="javascript">ComSheetObject('sheet5');</script>
								</td>
							</tr>
						</table>
						<!-- Grid 4(E) -->
						<!--Sub Button (S) -->
						<table width="100%" class="button"> 
				       		<tr>
				       			<td class="btn2_bg">
						    		<table border="0" cellpadding="0" cellspacing="0">
						    			<tr>
											<td>
												<div id="excelLayer" style="display:none">
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr><td class="btn2_left"></td>
															<td class="btn2" name="btn_Excel">Down&nbsp;Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
    				<!--Sub Button (E) -->
					<!--  biz_2   (E) -->
					</td>
				</tr>
			</table>
			<table class="height_10"><tr><td></td></tr></table>
		</td>
	</tr>
</table>			
</form>
</body>
</html>
