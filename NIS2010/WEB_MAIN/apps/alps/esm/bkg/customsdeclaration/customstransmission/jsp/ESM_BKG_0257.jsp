<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0257.jsp
*@FileTitle : ESM_BKG_0257
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.21 경종윤
* 1.0 Creation
* ------------------------------------------------------
* History
* 2011.11.07 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
* 2013.05.30 김보배 [CHM-201324949] EU customs EDI 화면 수정 및 Receiver ID 추가요청
* 2013.11.29 김보배 [CHM-201327231] [EU Manifest] EU customs EDI 화면상 export(outbound) 전송 버튼 추가 요청
* 2014.11.13 이한나 [CHM-201432484] [FR/EDI/#3] EDI Developement - CELTIC Customs
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event.EsmBkg0257Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0257Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strPgmNo			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsTransmission");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (EsmBkg0257Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));

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
		
		loadPage();
	}
</script>
</head>


<body onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="call_type" value="ESM_BKG_0257">
<input type="hidden" name="pgmNo"  value="<%=strPgmNo%>">
<input type="hidden" name="search_pod_cd"  value="">

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
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="50">&nbsp;&nbsp;Type</td>
					<td width="200">
						<script language="javascript">ComComboObject('p_type', 1, 180, 1, '');</script>
					</td>
					<td width="800"></td>
				</tr>
			</table>
			<!--  biz_1  (E) -->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<!--  biz_2  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="250">
						<table class="search_sm2" border="0" style="width:200;"> 
							<tr class="h23">
								<td>Mode</td>
								<td class="stm" width="60"><input type="radio" value="O" class="trans" name="mode_type">Outbound</td>
								<td class="stm" width="60"><input type="radio" value="I" class="trans" name="mode_type" checked>Inbound</td>
								
							</tr>
							
						</table>	
					</td>
					<td  width="100">Type&nbsp;<select style="width:60;" class="input" name="ts_tp_cd" id="ts_tp_cd">
											<option value="" selected>All</option>
											<option value="L">Local</option>
											<option value="T">T/S</option>
									</select>
					</td>
					<td width="300">&nbsp;</td>
					<td>
						<table border="0"> 
						<tr class="h23">
						<td style="width:85;">Country</td>
						<td class="stm"><script language="javascript">ComComboObject('cnt_cd',1,90, 1, 0, 0, 'true');</script></td>
						</tr>
						</table> 					
					</td>										
				</tr>	
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">VVD&nbsp;</td>
					<td width="100">
						<input type="text" style="width:90; ime-mode: disabled;" value="" class="input1" name="vvd_cd"
						dataformat="eng" required maxlength="9" fullfill caption="VVD">
					</td>
					<td width="30">POL&nbsp;</td>
					<td width="50">
						<input type="text" style="width:50;ime-mode: disabled;" value="" class="input"  name="pol_cd"
						dataformat="eng" maxlength="5" fullfill caption="POL">
					</td>
					<td width="30">
						<input type="text" style="width:30;ime-mode: disabled;" value="" class="input"  name="pol_yd_cd"
						dataformat="eng" maxlength="2" fullfill caption="POLYD">
					</td>
					<td width="10">&nbsp;</td>
					<td width="30">POD&nbsp;</td>
					<td width="50">
						<input type="text" style="width:50;ime-mode: disabled;" value="" class="input1"  name="pod_cd"
						dataformat="eng" required maxlength="5" fullfill caption="POD">
					</td>
					<td width="30">
						<input type="text" style="width:30;ime-mode: disabled;" value="" class="input"  name="pod_yd_cd"
						dataformat="eng" maxlength="2" fullfill caption="PODYD">
					</td>
					<td width="10">&nbsp;</td>
					<td width="95">
						(<input type="checkbox" value="" class="trans" name="check_frob_search">Incl. FROB)
					</td>
					<td width="60" align="right">B/L No.&nbsp;</td>
					<td width="120">
						<input type="text" style="width:100; ime-mode: disabled;" value="" class="input" name="bl_no"
						dataformat="eng" maxlength="12" fullfill caption="B/L No.">
					</td>
					<!-- <td width="170"></td> -->
					<td width="210">RECEIVER ID &nbsp;
							<script language="javascript">ComComboObject('receiver',1,120, 1, 0, 0, 'true');</script>
							<input type="hidden" name="receiver_id" value="">
					</td>
					<td width="40">&nbsp;&nbsp;UVI</td>
					<td width="">
						<input type="text" style="width:80" value="" class="input" name="uvi" readOnly
							dataformat="int" maxlength="5" caption="UVI">
					</td>
				</tr>
			</table>
		</td>
		</tr>
		</table>	

		<table class="height_8"><tr><td></td></tr></table>

			<!--Grid (s)-->
				<table width="100%"  id="mainTable" style="display:none;"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!--Grid (E)-->
			
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg"> 
   		
				<table>
					<tr>
						<td width="170">
							<table class="search_sm2" border="0" style="width:150;"> 
								<tr>
							   	    <td width="60"><input type="radio" name="p_ori_amd_cd"  value="O" class="trans" checked>Original  </td>
									<td width=""><input type="radio" name="p_ori_amd_cd"    value="U" class="trans">Update</td>
									
									<td width="">
									<span id="span_cancel" style="display:none;">
									<input type="radio" name="p_ori_amd_cd"    value="C" class="trans">Cancel
									</span>
									</td>
									
								</tr>	
							</table>
					    </td>
					    <td width="480"></td>
					    <td width="300">
					    	<span id="span_ap"	style="display:none;">
					    		<table>
								<tr class="h23">
						    		<td width="90" >AP+Reference&nbsp;</td>
									<td width="160">
										<input type="text" style="width:150; ime-mode: disabled;" value="" class="input" name="ap_ref" maxlength="35"
										dataformat="eng"> 
									</td>
						    	</tr>
						    	</table>
					    	</span>
					    </td>
					</tr>
				</table>
				<table>
					<tr>
						<td>
							<table class="search_sm2" border="0"> 
								<tr>
									<td width="80">Vessel Name&nbsp;</td>
									<td width="140">
										<input type="text" style="width:120; ime-mode: disabled;" value="" class="input2" name="vvd_nm" readOnly>
									</td>
									<td width="80">Vessel LLOYD&nbsp;</td>
									<td width="80">
										<input type="text" style="width:60; ime-mode: disabled;" value="" class="input2"  name="vvd_ld" readOnly>
									</td>
									<td width="90">Vessel Call Sign&nbsp;</td>
									<td width="70">
										<input type="text" style="width:50; ime-mode: disabled;" value="" class="input2"  name="vvd_call" readOnly>
									</td>
									<td width="30">ETA&nbsp;</td>
									<td width="140">
										<input type="text" style="width:120; ime-mode: disabled;" value="" class="input2" name="eta" readOnly>
									</td>
									<td width="30">ETD&nbsp;</td>
									<td width="140">
										<input type="text" style="width:120; ime-mode: disabled;" value="" class="input2" name="etd" readOnly> 
									</td>
								</tr>	
							</table>
					    </td>
					</tr>
				</table>
				
				<table class="height_8"><tr><td></td></tr></table>
				
		
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
						</td>
					</tr>
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transmit" id="btn_Retrieve">EDI Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
    
		<!-- Grid  (S) Excel Down 용 sheet-->
		<table width="100%"  id="mainTable"  style="display:none;"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table>			
		<!-- Grid (E) -->
	  
	</td></tr>
		</table>

</form>
</body>
</html>
