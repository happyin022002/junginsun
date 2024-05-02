<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_0577.jsp
*@FileTitle : ESM_BKG_0577
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.17
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.08.17 박성진
* 1.0 Creation
* -----------------------------------------------------
* History
* 2012.03.09 김보배 [CHM-201216245] [BKG] PSA DG EDI 추가 요건 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.event.EsmBkg0577Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0577Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.PSASpecialManifest");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		strPort_cd = strCnt_cd + strOfc_cd.substring(0, 3);
		
	   
		event = (EsmBkg0577Event)request.getAttribute("Event");
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
<input type="hidden" name="trans_type">
<input type="hidden" name="cond_type"> <!-- 입력 Validation type ("bl_no", "pol_cd", "pod_cd", "cntr_no") -->
<input type="hidden" name="cond_value"><!-- 입력 Validation value -->
<!--<input type="hidden" name="search_type">--><!-- "ALL_SEARCH", "ETC_SEARCH" -->
<input type="hidden" name="ui_type" value="ESM_BKG_0577">
<input type="hidden" name="bl_no">	
<input type="hidden" name="hid_d_type">	
<input type="hidden" name="hid_vvd_cd">	

<input type="hidden" name="init_d_type" value="<%= dType %>">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
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
							<table class="search_sm2" border="0" style="width:490;"> 
								<tr class="h23">
									<td width="80">&nbsp;Declaration </td> 
									<td width="" class="stm">
										<input type="checkbox" name="d_type1" value="D" class="trans">Discharging &nbsp;<input type="checkbox" name="d_type2" value="T" class="trans">Transit &nbsp;<input type="checkbox" name="d_type3" value="L" class="trans">Loading  &nbsp;<input type="checkbox" name="d_type4" value="P" class="trans">Pre-carriage  &nbsp;<input type="checkbox" name="d_type5" value="O" class="trans">On-Carriage
										<input type="hidden" name="d_type" value="D" required caption="Declaration">
									</td>	
								</tr>
							</table>
					</td>
					<td>
						<td width="25">VVD</td>
						<td width="90">
							<input type="text" style="width:80; ime-mode: disabled" value="" class="input1" name="vvd_cd"
							dataformat="eng" required maxlength="9" fullfill caption="VVD">
						</td>
						<td width="30">Port</td>
						<td width="70"><input type="text" style="width:50;" class="input1" value="" name="port_cd" style="ime-mode: disabled"  dataformat="eng" required maxlength="5" fullfill caption="Port" > </td>
						<td width="30">Sent</td>
						<td width="70">
							<select name="search_type">
							<option value="A" selected>ALL</option>
							<option value="Y">Yes</option>
							<option value="N">No</option>
							</select>
						</td>
						<td width="*">&nbsp;</td>  
					</td>
				</tr>
			</table>
			
			
			<table class="grid2" border="0" style="width:979;"> 
				<tr class="h23">
					<td class="tr2_head" width="15%">Arrival</td>
					<td width="22%">
						<input type="text" style="width:80; ime-mode: disabled" class="input2" name="frm_eta_d" dataformat="ymd" caption="Arrival Date" maxlength="10" readonly>&nbsp;
						<input type="text" style="width:45; ime-mode: disabled" class="input2"name="frm_eta_t" dataformat="hm" caption="Arrival Time" maxlength="5" readonly>
					</td>
					<td class="tr2_head" width="10%">Departure</td>
					<td width="15%">
						<input type="text" style="width:80; ime-mode: disabled" class="input2" name="frm_etd_d" dataformat="ymd" caption="Departure Date" maxlength="10" readonly>&nbsp;
						<input type="text" style="width:45; ime-mode: disabled" class="input2" name="frm_etd_t" dataformat="hm" caption="Arrival Time" maxlength="5" readonly>
					</td>
					<td class="tr2_head" width="10%">Berth</td>
					<td width="%">
						<input type="text" style="width:70; ime-mode: disabled" class="input2" name="frm_brth_yd_cd" dataformat="eng" maxlength="7" caption="Berth" readonly>&nbsp;
						<input type="text" style="width:200; ime-mode: disabled" class="input2" name="frm_yd_nm" readonly>
					</td>
				</tr>
				<tr class="h23">
					<td class="tr2_head">Vessel Flag/Call Sign</td>
					<td>
						<input type="text" style="width:80; ime-mode: disabled" class="input2" name="frm_vsl_cnt_cd" dataformat="engup" maxlength="2" caption="Vessel Flag" readonly>&nbsp;
						<input type="text" style="width:70; ime-mode: disabled" class="input2" name="frm_call_sgn_no" dataformat="eng" maxlength="14" caption="Call Sign" readonly>
					</td>
					<td class="tr2_head">Vessel Code</td>
					<td width="%"><input type="text" style="width:80;  ime-mode: disabled" dataformat="eng" class="input2" name="frm_vsl_cd" readonly></td>
					
					<td class="tr2_head"><div id="layoutView" style="width:80px;">Vessel Name</div></td>
					<td width="%">
						<input type="text" style="width:100%;  ime-mode: disabled" class="input2" name="frm_vsl_eng_nm" readonly>
					</td>
				</tr>
				<tr class="h23">
					<td class="tr2_head">Reason of<br>Re-sending</td>
					<td width="%">
						<script language="javascript">ComComboObject('reason_resending',1,130, 1);</script>
					</td>
					<td class="tr2_head">Lloyd code</td>
					<td width="%"><input type="text" style="width:80; ime-mode: disabled" class="input2" name="frm_lloyd_no" dataformat="eng" maxlength="12" caption="Lloyd code" readonly></td>
					<td class="tr2_head">Total Container</td>
					<td style="padding-left:2"><input type="text" style="width:100; ime-mode: disabled; text-align:Center" class="input2" name="cntr_cnt" readOnly="true">
						<!-- <select name="search_type" style="width:150;">
						<option value="A" selected>ALL</option>
						<option value="Y">Yes</option>
						<option value="N">No</option>
						</select> -->
					</td>
				</tr>
				</table>
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
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
			
			<!-- <table class="search" border="0" style="width:;"> 
			<tr class="h23">
				<td width="100">Total Container</td>
				<td width="110">
					<input type="text" style="width:100; ime-mode: disabled; text-align:Center" class="input2" name="cntr_cnt" readOnly="true">
				</td>
				<td width="*">&nbsp;</td>
			</tr>
			</table> -->
				
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
	    <table>
	    	<tr>
	    		<td style="display:none;">Flat File</td>
	    		<td style="display:none;">Original Update Flat File</td>
	    		<td style="display:none;">Cancel Flat File</td>
	    	</tr>
	    	<tr>
	    		<td style="display:none;"><textarea name="output1" cols="180" rows="20"></textarea></td>
	    		<td style="display:none;"><textarea name="output2" cols="60" rows="20"></textarea></td>
	    		<td style="display:none;"><textarea name="output3" cols="90" rows="20"></textarea></td>
	    	</tr>
	    </table>
</body>
</html>
