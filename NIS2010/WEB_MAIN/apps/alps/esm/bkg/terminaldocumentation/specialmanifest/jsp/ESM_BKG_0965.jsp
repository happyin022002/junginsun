<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0965.jsp
*@FileTitle : ESM_BKG_0965
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.28 경종윤
* 1.0 Creation
* ------------------------------------------------------
* HISTORY 
* 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0965Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0965Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCnt_cd		= "";
	String strPort_cd		= "";
	
	String dType			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.SpecialManifest");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		strPort_cd = strCnt_cd + strOfc_cd.substring(0, 3);
		
	   
		event = (EsmBkg0965Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		// 부모창에서 넘오온 파라메터 셋팅
		
		dType = (request.getParameter("d_type") == null) ? "" : request.getParameter("d_type");
		
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
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage('<%=dType%>');
	}
</script>
</head>


<body  onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bay_pln_id">
<input type="hidden" name="dg_list_local_yn">
<input type="hidden" name="trans_type">
<input type="hidden" name="cond_type"> <!-- 입력 Validation type ("bl_no", "pol_cd", "pod_cd", "cntr_no") -->
<input type="hidden" name="cond_value"><!-- 입력 Validation value -->
<input type="hidden" name="search_type"><!-- "ALL_SEARCH", "ETC_SEARCH" -->
<input type="hidden" name="ui_type" value="ESM_BKG_0965">
<input type="hidden" name="bl_no">	
<input type="hidden" name="hid_d_type">	
<input type="hidden" name="hid_vvd_cd">	
<input type="hidden" name="hid_port_cd">	

<input type="hidden" name="init_d_type" value="<%= dType %>">

<!-- Bay-Paln detail pop에서 셋팅 할때... 사용 (main grid list가 0이면 main page에 셋팅 할 필요가 없음)-->
<input type="hidden" name="currMainPageListCnt" value="0">	
	

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
	<!--Page Title, Historical (E)-->	

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="510">
							<table class="search_sm2" border="0" style="width:500;"> 
								<tr class="h23">
									<td width="80">&nbsp;Declaration </td> 
									<td width="" class="stm">
										<input type="checkbox" name="d_type1" value="D" class="trans">Discharging &nbsp;<input type="checkbox" name="d_type2" value="T" class="trans">Transit &nbsp;<input type="checkbox" name="d_type3" value="L" class="trans">Loading  &nbsp;<input type="checkbox" name="d_type4" value="P" class="trans">Pre-carriage  &nbsp;<input type="checkbox" name="d_type5" value="O" class="trans">On-Carriage
										<input type="hidden" name="d_type" value="D" required caption="Declaration">
									</td>	
								</tr>
							</table>
					</td>
					<td width="25">VVD</td>
					<td width="90">
						<input type="text" style="width:80; ime-mode: disabled" value="" class="input1" name="vvd_cd"
						dataformat="eng" required maxlength="9" fullfill caption="VVD">
					</td>
					<td width="30">Port</td>
					<td width="55">
						<script language="JavaScript">ComComboObject("port_cd", 1, 65);</script>
						<!-- 
						<input type="text" style="width:50; ime-mode: disabled" value="BEANR" class="input2" name="port_cd"
						dataformat="eng" required maxlength="5" fullfill caption="Port" ReadOnly="true">
						 -->
					</td>  
					<td width="80"><input type="checkbox" value="" class="trans" name="barge_check" disabled="true"><input type="hidden" name="barge_flag" value="N">BARGE&nbsp</td> 
					<td width=""><input type="checkbox" value="" class="trans" name="bay_plan_upload_check">Bay-Plan Upload Required&nbsp</td> 
				</tr>
			</table>
			
			
			<table class="grid2" border="0" style="width:979;"> 
				<tr class="h23">
					<td class="tr2_head" width="15%">Arrival</td>
					<td width="22%">
						<input type="text" style="width:80; ime-mode: disabled" class="input" name="frm_eta_d" dataformat="ymd" caption="Arrival Date" maxlength="10">&nbsp;
						<input type="text" style="width:45; ime-mode: disabled" class="input"name="frm_eta_t" dataformat="hm" caption="Arrival Time" maxlength="5">
					</td>
					<td class="tr2_head" width="10%">Departure</td>
					<td width="15%">
						<input type="text" style="width:80; ime-mode: disabled" class="input" name="frm_etd_d" dataformat="ymd" caption="Departure Date" maxlength="10">&nbsp;
						<input type="text" style="width:45; ime-mode: disabled" class="input" name="frm_etd_t" dataformat="hm" caption="Arrival Time" maxlength="5">
					</td>
					<td class="tr2_head" width="10%">Berth</td>
					<td width="%">
						<input type="text" style="width:70; ime-mode: disabled" class="input" name="frm_brth_yd_cd" dataformat="eng" maxlength="7" caption="Berth">&nbsp;
						<input type="text" style="width:200; ime-mode: disabled" class="input" name="frm_yd_nm">
					</td>
				</tr>
				<tr class="h23">
					<td class="tr2_head">Auto Transmit</td>
					<td><input type="text" style="width:80;" class="input2" name="frm_auto_snd_tp_cd" readOnly="true"></td>
					<td class="tr2_head">Vessel Code</td>
					<td width="%"><input type="text" style="width:80;  ime-mode: disabled" dataformat="eng" class="input" name="frm_vsl_cd"></td>
					
					<td class="tr2_head"><div id="layoutView" style="width:80px;">Vessel Name</div></td>
					<td width="%">
						<input type="text" style="width:100%;  ime-mode: disabled" class="input" name="frm_vsl_eng_nm">
					</td>
				</tr>
				<tr class="h23">
					<td class="tr2_head">Vessel Flag/Call Sign</td>
					<td>
						<input type="text" style="width:80; ime-mode: disabled" class="input" name="frm_vsl_cnt_cd" dataformat="engup" maxlength="2" caption="Vessel Flag">&nbsp;
						<input type="text" style="width:70; ime-mode: disabled" class="input" name="frm_call_sgn_no" dataformat="eng" maxlength="14" caption="Call Sign">
					</td>
					<td class="tr2_head">Lloyd code</td>
					<td width="%"><input type="text" style="width:80; ime-mode: disabled" class="input" name="frm_lloyd_no" dataformat="eng" maxlength="12" caption="Lloyd code"></td>
					<td class="tr2_head">SSR</td>
					<td width="%">
						<input type="text" style="width:80; ime-mode: disabled" value="" class="input1" name="frm_svc_rqst_no" 
						dataformat="yy" required maxlength="7" caption="SSR">
					</td>
				</tr>
				<tr class="h23">
					<td class="tr2_head">Agent or<br>Agent Forwarder</td>
					<td style="padding-left:2">
						<script language="javascript">ComComboObject('anr_role_div_cd',1,155, 1);</script>
						<!--
						<select style="width:150;" >
						<option value="0" selected>Agent</option>
						<option value="1">Agent and Forwarder</option>
						<option value="1">Forwarder</option>
						</select> -->
					</td>
					<td class="tr2_head">Reason of<br>Re-sending</td>
					<td width="%">
						<script language="javascript">ComComboObject('reason_resending',1,130, 1);</script>
					</td>
					<td class="tr2_head">Sent Status</td>
					<td width="%">
						<input type="hidden" style="width:100%; background-color:white; font-weight:bold;" name="frm_ack_rcv_sts_cd" id="frm_ack_rslt_id" readOnly>
						<input type="text" style="width:100%;background-color:white; font-weight:bold;" name="ack_rcv_sts_cd_name" id="frm_ack_rslt_id_name" readOnly>
					</td>
				</tr>
			</table>
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
<!-- Filter (S) -->	

	<!--  biz_1  (S) -->
	<table class="search" border="0" style="width:;"> 
	<tr class="h23">
		<td width="50">B/L No.</td>
		<td width="110">
			<input type="text" style="width:100; ime-mode: disabled" class="input" name="filter_bl_no"
			dataformat="eng" maxlength="12" caption="B/L No.">
		</td>
		<td width="90">Container No.</td>
		<td width="120">
			<input type="text" style="width:110; ime-mode: disabled" class="input" name="filter_cntr_no"
			dataformat="eng" maxlength="14" caption="Container No.">
		</td>  
		<td width="100" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn1_Filter">Filter</td>
					<td class="btn2_right"></td>
				</tr>
			</table>
		</td>	
		<td width="*">&nbsp;</td>	
		<td width="100" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn1_BayPlan">Bay-Plan</td>
					<td class="btn2_right"></td>
				</tr>
			</table>
		</td>	
	</tr>
	</table>
	
<!-- Filter (E) -->				
				
			
		    <!--Hidden Grid (S)-->
		    <table width="100%" id="mainTable" style="display:none">
		        <tr>
		            <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
		        </tr>
		    </table>
		    <!--Hidden Grid (E)-->
			
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			
			<table class="search" border="0" style="width:;"> 
			<tr class="h23">
				<!--  Total Container  (S) -->
				<td width="100">Total Container</td>
				<td width="110">
					<input type="text" style="width:100; ime-mode: disabled; text-align:Center" class="input2" name="cntr_cnt" readOnly="true">
				</td>
				<!--  Total Container  (E) -->
				<td width="*">&nbsp;</td>
				<td>
				<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_RowAdd">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_Delete">Row Delete</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
							</tr></table>
					</td></tr>
					</table>
				<!-- Button_Sub (E) -->
				</td>
			</tr>
			</table>
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Append_Retrieve">booking data append</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		    	<td class="btn1_line"></td><td>
		    		 <table class="search" border="0" cellpadding="0" cellspacing="0">
		    		<tr>
		    			<td>Copy<input type="checkbox" value="" class="trans" name="dg_list_copy_check" disabled="true">&nbsp
		    		<input type="hidden" name="dg_list_copy_flag" value="N"></td>
		    		</tr>
					</table>	
		    	</td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_EDITransmit">EDI Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_EDICancel">EDI  Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_SentResult">Transmit (Sending Results)</td>

					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_DownExcel">Down Excel</td>
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
		
		<br>
	    <!-임시 (S)-->
	    <!-- 
	    <table>
	    	<tr>
	    		<td>Original Flat File</td>
	    		<td>Update Flat File</td>
	    		<td>Cancel Flat File</td>
	    	</tr>
	    	<tr>
	    		<td><textarea name="output1" cols="60" rows="20"></textarea></td>
	    		<td><textarea name="output2" cols="60" rows="20"></textarea></td>
	    		<td><textarea name="output3" cols="60" rows="20"></textarea></td>
	    	</tr>
	    </table>
		 -->
	
</body>
</html>
