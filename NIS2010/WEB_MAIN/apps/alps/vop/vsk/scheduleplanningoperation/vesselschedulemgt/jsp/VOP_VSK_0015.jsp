<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0015.jsp
*@FileTitle : Coastal SKD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.28
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.11 Jung Jinwoo
* 1.0 Creation
*
* History
* 2015.06.24 이병훈	[CHM-201536225] CSKED Update and Simulation 버튼 및 불필요한 기능 삭제
* 2015.07.03 이병훈	[CHM-201536734] [PSX] C SKED Update Add call 기능 관련 수정
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String eml = "";
	Logger log = Logger.getLogger("com.hanjin.apps.VSKCommon.VSKCodeFinder");
	
	// User Value
	String targetServer = "";
	String encodeGwUrl = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		eml = account.getUsr_eml();
		
		event = (VopVsk0015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		targetServer = eventResponse.getETCData("target_server");
		encodeGwUrl = eventResponse.getETCData("encode_gw_url");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Port Code Inquiry</title>
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
<input type="hidden" name="loc_cd">
<input type="hidden" name="vps_port_cd">
<input type="hidden" name="clpt_ind_seq">
<input type="hidden" name="yd_cd">
<input type="hidden" name="rtv_flg">
<input type="hidden" name="fm_loc_cd">
<input type="hidden" name="to_loc_cd">
<input type="hidden" name="vsl_sim_tp_cd" value="C">
<input type="hidden" name="spd">
<input type="hidden" name="vps_eta_dt">
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">

<input type="hidden" name="com_subject">
<input type="hidden" name="com_content">
<input type="hidden" name="com_from" value="<%=eml%>">

<input type="hidden" name="target_server" value="<%=targetServer %>">
<input type="hidden" name="encode_gw_url" value="<%=encodeGwUrl %>">

<input type="hidden" name="curr_yymm" >
<!-- 아래 hidden 항목은 Simulation No 항목대체용으로써 Recovery Plan 기능이 완전히 제거 되는 경우 해당 항목도 삭제 할 것! -->
<input type="hidden" name="sim_dt" >
<input type="hidden" name="sim_no" >
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
		<tr><td class="history"><img name="btn_height_sml" src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img name="btn_height_big" src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
	<table class="search"> 
      	<tr><td class="bg">
			<!--  biz_1  (S) -->
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="160" rowspan="2" style="display:none;">
					<table class="search_sm2" style="width:130;">
						<tr class="h23">
							<td><input type="radio" name="rdo_tran" value="" class="trans" checked="checked">Coastal SKD</td>
						</tr>
						<tr class="h23">
							<td><input type="radio" name="rdo_tran" value="" class="trans">Recovery Plan</td>
						</tr>
					</table>
				</td>  
				<td width="30" rowspan="">VVD</td>   
				<td width="190"><input type="text" name="vsl_cd" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_voy_no" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_dir_cd" style="width:25;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vvd_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				<!-- td width="90">Simulation No.</td>
				<td width="190"><input type="text" name="sim_dt" style="width:80;text-align:center;" class="input2" value="" maxlength="10" readonly="readonly">&nbsp;<input type="text" name="sim_no" style="width:40;text-align:center;" class="input2" value="" readonly="readonly">&nbsp;<img class="cursor" name="btn_sim_no" id="btn_sim_no" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" ></td-->
				<td width="170">Lane Code&nbsp;&nbsp;&nbsp;<input type="text" name="vsl_slan_cd" style="width:40;text-align:center;" class="input2" value="" readonly="readonly"></td>    
				<td width="300">Bound&nbsp;<select name="bound" style="width:45;" class="input">
					<option value="1">1</option>
					<option value="3" selected="selected">3</option>
					<option value="5">5</option>
					</select></td>
				<td width="90">Created Date</td>
				<td align="left"><input type="text" name="cre_dt" style="width:115;text-align:center;" class="input2" value="" readonly="readonly">&nbsp;<input type="text" name="cre_usr_id" style="width:120;" class="input2" value="" readonly="readonly"></td>
			</tr>
			<tr class="h23" colspan="2">
				<td colspan="4">&nbsp;</td>
				<td>Updated Date</td>
				<td align="left"><input type="text" name="upd_dt" style="width:115;text-align:center;" class="input2" value="" readonly="readonly">&nbsp;<input type="text" name="upd_usr_id" style="width:120;" class="input2" value="" readonly="readonly"></td>
			</tr>	
			</table> 
				
		
			
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
     	
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
					<!--td rowspan="2" align="center" valign="top">
						<br><br>
						<div id="div_col_show"><img src="img/btns_add.gif" name="btn_col_show" align="absmiddle" style="cursor: hand;"></div>
						<div id="div_col_hide" style="display: none"><img src="img/btns_del.gif" name="btn_col_hide" align="absmiddle" style="cursor: hand;"></div>
					</td-->
				</tr>
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
				 <tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table>

						<!-- Grid (E) -->
			
				<!--  biz_2   (E) -->
			
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td>
						<div id="div_add_call_cancel_1" style="display:none;"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_add_call_cancel_1">ADD Call Cancel</td>
						<td class="btn2_right"></td>
						</tr></table></div>
					</td>
					<td>
						<div id="div_add_call_1"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_add_call_1">ADD Call</td>
						<td class="btn2_right"></td>
						</tr></table></div>
						<div id="div_add_call_2" style="display:none;">
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_add_call_2">ADD Call</td>
						<td class="btn2_right"></td>
						</tr></table></div>
					</td>
					<td>
						<div id="div_reverse_call_1"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_reverse_call_1">Reverse Call</td>
						<td class="btn2_right"></td>
						</tr></table></div>
						<div id="div_reverse_call_2" style="display:none;"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_reverse_call_2">Reverse Call</td>
						<td class="btn2_right"></td>
						</tr></table></div>
					</td>
					<td>
						<div id="div_skip_call_1"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_skip_call_1">Skip Call</td>
						<td class="btn2_right"></td>
						</tr></table></div>
						<div id="div_skip_call_cancel_1" style="display:none;"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_skip_call_cancel_1">Skip Call Cancel</td>
						<td class="btn2_right"></td>
						</tr></table></div>
						<div id="div_skip_call_2" style="display:none;"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_skip_call_2">Skip Call</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div>
					</td>
					<!-- 
					<td><div id="div_p_in_1"><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="btn_p_in_1">Phase In</td>
					<td class="btn2_right"></td>
					</tr>
					</table></div>
					<div id="div_p_in_2" style="display:none;"><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="btn_p_in_2">Phase In</td>
					<td class="btn2_right"></td>
					</tr>
					</table></div></td>
					 -->
					<td>
						<div id="div_p_out_1"><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_p_out_1">Phase Out</td>
						<td class="btn2_right"></td>
						</tr></table></div>
						<div id="div_p_out_cancel_1" style="display:none;"><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_p_out_cancel_1">Phase Out Cancel</td>
						<td class="btn2_right"></td>
						</tr></table></div>
						<div id="div_p_out_2" style="display:none;"><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_p_out_2">Phase Out</td>
						<td class="btn2_right"></td>
						</tr></table></div>
					</td>
					<!-- 
					<td><div id="div_row_hide_1"><table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="btn_row_hide_1">Row Hide</td>
					<td class="btn2_right"></td>
					</tr>
					</table></div>
					<div id="div_row_hide_2" style="display:none;"><table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="btn_row_hide_2">Row Hide</td>
					<td class="btn2_right"></td>
					</tr>
					</table></div></td>
					-->
					<td><div id="div_col_show"></div><div id="div_col_hide" style="display: none"></div><div id="div_plan_col_show" style="display: none"></div></td>
				</tr></table>
			</td></tr>
			</table>
			
			<table width="100%" class="button" style="display: none"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					<td>
						&nbsp;
						<!-- div id="div_cost_calculation_1">
						<table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
								<td class="btn2_1" name="btn_cost_calculation_1">Cost Calculation</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</div-->
						<!-- div id="div_cost_calculation_2">
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
								<td class="btn2_1" name="btn_cost_calculation_2">Cost Calculation</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</div-->
					</td>

					<td>
						<!-- div id="div_skip_call_cancel_1" style="display:none;">
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
								<td class="btn2_1" name="btn_skip_call_cancel_1">Skip Call Cancel</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</div-->
						
						<div id="div_skip_call_cancel_2" style="display:none;">
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_skip_call_cancel_2">Skip Call Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div>
						</td>
						
						<td><!-- div id="div_add_call_cancel_1"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_add_call_cancel_1">ADD Call Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div-->
						<div id="div_add_call_cancel_2" style="display:none;"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_add_call_cancel_2">ADD Call Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div></td>
						<!--
						<td><div id="div_reverse_call_cancel_1"><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_reverse_call_cancel_1">Reverse Call Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div>
						<div id="div_reverse_call_cancel_2" style="display:none;"><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_reverse_call_cancel_2">Reverse Call Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div></td>
						<td><div id="div_p_in_cal_1"><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_p_in_cancel_1">Phase In Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div>
						<div id="div_p_in_cal_2" style="display:none;"><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_p_in_cancel_2">Phase In Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div></td>
						-->
						<td><div id="div_p_out_cancel_1"><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_p_out_cancel_1">Phase Out Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div>
						<div id="div_p_out_cancel_2" style="display:none;"><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_p_out_cancel_2">Phase Out Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div></td>
						<!-- 
						<td><div id="div_row_hide_cancel_1"><table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_row_hide_cancel_1">Row Hide Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div>
						<div id="div_row_hide_cancel_2" style="display:none;"><table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_1" name="btn_row_hide_cancel_2">Row Hide Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></div></td>
						-->
						<td><div id="div_col_hide"></div><div id="div_plan_col_hide" style="display: none"></div></td>
					</tr>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	<table class="height_8"><tr><td></td></tr></table>
			<table class="search" width="979">
				<tr>
					<td>
							<table class="grid2" width="979">
							<tr>
								<td class="tr2_head" width="110">Remark(s)</td> 
								<td><textarea style="width:100%;height:50;ime-mode:disabled;" name="skd_rmk" class="textarea"></textarea></td>
						</tr>
						</table>
					</td>
				</tr>
			</table>
			
						<!-- remark Combo Hidden 처리 1 START -->
						<!-- remark Combo 나타나지 않게 요청(2009.12.18 김기원 K) -->
						<div id="div_remark_tmp"  style="display:none">
						<table class="search">
						<tr class="h23"><td valign="top">
						<!-- remark Combo Hidden 처리 1 END -->
							<div id="div_remark">
							<script language="javascript">ComComboObject('remark',1,104,1,0);</script>
							</div>
						<!-- remark Combo Hidden 처리 2 START -->
						</td></tr>
						</table>
						</div>
						<!-- remark Combo Hidden 처리 2 END -->
					
			
	</td></tr>
	</table>
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_gw_mail">GW Mail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_e_mail">E-Mail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_bulletin_board">Bulletin Board</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				<!--
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_settlement">Settlement</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				<!--  
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_1" name="btn_loadableweight">Loadable Weight</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				<!-- 
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_send_edi_ckyh">Send EDI CKYH</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
			</tr>
			</table>
    <!--Button (E) -->
		</td></tr>
		</table>
</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
