<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0103.jsp
*@FileTitle :  Budget L/R SKD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
*
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event.VopVsk0103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Budget.VesselScheduleMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0103Event)request.getAttribute("Event");
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
<title>Budget L/R SKD Creation</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="op_type">
<input type="hidden" name="add_call_point" value="1">
<input type="hidden" name="add_vvd_point" value="3">
<input type="hidden" name="phasein_col">
<input type="hidden" name="phasein_row">
<input type="hidden" name="phasein_vsl_cd">
<input type="hidden" name="phasein_start_date">
<input type="hidden" name="phasein_voy_no">
<input type="hidden" name="vsl_cd">

<!--  Add Call 정보 -->
<input type="hidden" name="add_call_port_cd">
<input type="hidden" name="add_call_yard_cd">
<input type="hidden" name="add_call_etb">
<input type="hidden" name="add_call_etd">
<input type="hidden" name="add_call_turn_ind">
<input type="hidden" name="add_call_position">

<input type="hidden" name="skdDirCd1">
<input type="hidden" name="skdDirCd2">
<input type="hidden" name="svc_dur_dys">
<input type="hidden" name="vsl_count">

<%// 화면이 Feeder 용인 경우 vsl_svc_tp_cd는 "F", 그렇지 않은 경우는 "T" 이다.%>
<input type="hidden" name="vsl_svc_tp_cd" value="T">
<input type="hidden" name="slan_stnd_flg" value="Y">
<input type="hidden" name="tmp_vsl_slan_cd" value="">
<input type="hidden" name="pf_svc_tp_cd">
<input type="hidden" name="stnd_pf_svc_tp_cd">

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
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="65">Lane Code</td>   
					<td width="80"><input  name="vsl_slan_cd" type="text" style="width:37;text-align:center;ime-mode:disabled" class="input1" maxlength="3" tabindex="1">
					<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_search1"></td>
					<td width="60">End Date</td>   
					<td width="270">
						<input name="end_year" type="text" style="width:45;text-align:center;" class="input1" maxlength="4" tabindex="5">
						<img class="cursor" name="btns_back2" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle">
						<img class="cursor" name="btns_next2" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle">
						<select name="selEndQuarter" style="width:45;" class="input1" tabindex="6">
						<option value="1" selected>1/4</option>
						<option value="2">2/4</option>
						<option value="3">3/4</option>
						<option value="4">4/4</option></select>
						<input name="end_date"  type="text"  dataformat="ymd" style="width:80;;text-align:center;" class="input1" maxlength="8" size="10" tabindex="7">
						<img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<!-- 
					<td width="50">Period</td>   
					<td colspan="3" width="600">
						<input type="text" name="start_year" style="width:45;text-align:center;" class="input1" maxlength="4" tabindex="2">
						<img name="btns_back1" class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle">
						<img name="btns_next1"  class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle">
						<select name="selStartQuarter" style="width:45;" class="input1" tabindex="3">
						<option value="1" selected>1/4</option>
						<option value="2">2/4</option>
						<option value="3">3/4</option>
						<option value="4">4/4</option></select>
						<input name="start_date" type="text" caption="시작일" dataformat="ymd" style="width:80;text-align:center;" class="input1" maxlength="8" size="10" tabindex="4" cofield="end_date">
						<img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						<input type="text" style="width:15;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1">
						<input name="end_year" type="text" style="width:45;text-align:center;" class="input1" maxlength="4" tabindex="5">
						<img class="cursor" name="btns_back2" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle">
						<img class="cursor" name="btns_next2" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle">
						<select name="selEndQuarter" style="width:45;" class="input1" tabindex="6">
						<option value="1" selected>1/4</option>
						<option value="2">2/4</option>
						<option value="3">3/4</option>
						<option value="4">4/4</option></select>
						<input name="end_date"  type="text"  caption="종료일" dataformat="ymd" style="width:80;;text-align:center;" class="input1" maxlength="8" size="10" tabindex="7" cofield="start_date">
						<img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					 -->
				<!-- 
				</tr>
				<tr class="h23">
				 -->
				 	<!--  CHM-201005742-01 Frequency는 수정 불가 -->
					<td width="65">Frequency</td>
					<td width="50"><input type="text" name="brth_itval_dys" style="width:30;text-align:center;"  class="input2" tabindex="-1" readonly></td>
					<td width="65">Vessel No.</td>
					<td width="50"><input type="text" name="vsl_cnt" style="width:22;text-align:center;"  class="input" maxlength="2" tabindex="8"></td>
					<td width="70">Voyage No.</td>
					<td width=""><select style="width:140;" name="voy_no_type" class="input">
						<option value="0" selected>Normal</option>
						<option value="1">Direction (ADD One)</option>
						<option value="2">Sequence</option></select>
						<input type="text" name="start_date" style="width:0"/>
						 </td>
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<!--  grid  (S) -->
				
				<div id="startinfo" style="display: inline">
				<table class="search" > <!--  border="0" style="width:100%;"> --> 
				<tr class="h23">
					<td width="100%">
					
						<table width="100%"> 
							<tr>
								<td>
									<script language="javascript">ComSheetObject1('sheet1');</script>
								</td>
							</tr>
						</table> 
					
					</td> 
				</tr>
				</table>
				</div>

				<!--  grid   (E) -->
				
				
				
			</td></tr>	
		</table>
				<!--  biz_1   (E) -->
	<table class="height_8"><tr><td></td></tr></table>
		
	<table class="search"> 
       	<tr><td class="bg">
     	
				<!--  grid  (S) -->
				
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 

				<!--  grid   (E) -->
				
				<!--  grid  (S) -->
		
				<table width="100%">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table> 
			
				<!--  grid   (E) -->
				<!-- 
				<table class="grid2" border="0" style="width:979;"> 
						<tr class="h23">
							<td class="tr2_head" width="100%">Remark</td>
							<td width=""><textarea cols="170" rows="3"></textarea></td></tr>	
				</table>
				 -->
				
				
				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_PhaseIn">Phase In</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_PhaseInCancel">Phase In Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_PhaseOut">Phase Out</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_PhaseOutCancel">Phase Out Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AddCall">Add Call </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AddCallCancel">Add Call Cancel </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_SkipCall">Skip Call </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_SkipCallCancel">Skip Call Cancel </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
				
				
				
				
				<!--biz page (E)-->
	</td>
			</tr>
			</table>
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td>
		    		<div id="extend">
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Extend">Extend</td>
					<td class="btn1_right"></td>
					</tr>
					</table></div>
					<div id="reduce" style="display: none">
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Reduce">Reduce</td>
					<td class="btn1_right"></td>
					</tr>
					</table></div>
				</td>
		    	<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Simulation" name="btn_Simulation">Simulation</td>
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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>