<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1141.jsp
*@FileTitle : Malaysia Customs Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.03
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2012.02.03 변종건
* 1.0 Creation
* 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event.EsmBkg1141Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1141Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String search_flg1 = "";
	String search_flg3 = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		String ofcCd = account.getOfc_cd();
			
		// Log-in ID 소속 Office 가 "MX" 인 경우 Default
		// 하동일 수석 가이드에 따라 조직코드의 앞 3자리가 MEX인 유저에 대해 로직을 적용함.
		if(ofcCd != null){
			if(ofcCd.substring(0, 3).equals("MEX")){
				search_flg1 = "checked";
			}
		}
		//Log-in ID 소속 Office 가 "MX" 가 아닌 경우 Default
		if( search_flg1.equals("")){
			search_flg3 = "checked";
		}
		
		event = (EsmBkg1141Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch (Exception e) {
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
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="pageno" value="ESM_BKG_1141">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		
		<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
		<!--Page Title, Historical (E)--> 
    
	    <!--biz page (S)-->
	    	<table class="search" id="mainTable">
	       		<tr>
	       			<td class="bg">
						<table class="search"> 
	       					<tr class="h23">
								<td valign="top">
									<!--  biz_1  (S) -->

									<table class="search" border="0" style="width:800;"> 
										<tr class="h23">
				       						<td width="250">
												<table class="search_sm" border="0" style="width:250;">
													<tr class="h23">
														<td width="60">Mode</td>
														<td width="90"><input type="radio" name="s_mode" value="E" class="trans" checked>Outbound</td>
														<td width="90"><input type="radio" name="s_mode" value="I" class="trans">Inbound</td>
													</tr>
												</table>
											</td>
											<td width="20"></td>
											<td width="40">TYPE</td>
									    	<td width="100" style="padding-left:1"><select style="width:79;" class="input" name="ts_tp_cd" onChange="tsTpCd_OnChange()">
											<option value="L">Local</option>
											<option value="T">T/S</option>
										
											
											</select></td>
											<td width="30">VVD</td> 
											<td width="100"><input type="text" style="width: 80; ime-mode:disabled;" class="input1" maxlength="9" value="" name="s_vvd" caption="VVD" dataformat="uppernum" required></td>
											<td width="30">POL</td>
											<td width="70"><input type="text" name="s_pol_cd" caption="POL" maxlength="5" style="width:50;ime-mode:disabled;" value="" class="input1" dataformat="uppernum" required></td>
											<td width="30">POD</td>
											<td width=""><input type="text" name="s_pod_cd" caption="POD" maxlength="5" style="width:50;ime-mode:disabled;" value="" class="input" dataformat="uppernum"></td>
										</tr>
									</table>
									<table>
										<tr>
											<td>
												<table class="search" border="0">
													<tr>
														<td class="title_h"></td>
														<td class="title_s">Booking Route</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<table class="search_sm" border="0">
													<tr class="h23">
														<td width="30">POR</td>
														<td width="70"><input type="text" name="s_trunk_por_cd" maxlength="5" style="width:50;" class="input" dataformat="uppernum" value=""></td>
														<td width="30">POL</td>
														<td width="70"><input type="text" name="s_trunk_pol_cd" maxlength="5" style="width:50;" class="input" dataformat="uppernum" value=""></td>
														<td width="30">POD</td>
														<td width="70"><input type="text" name="s_trunk_pod_cd" maxlength="5" style="width:50;" class="input" dataformat="uppernum" value=""></td>
														<td width="30">DEL</td>
														<td width=""><input type="text" name="s_trunk_del_cd" maxlength="5" style="width:50;" class="input" dataformat="uppernum" value=""></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<!--  biz_1   (E) -->
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		<!--biz page (E)-->

			
		<!-- Tab ) (S) -->
	   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="900"> 
	     		<tr>
	     			<td width="100%"><script language="javascript">ComTabObject('tab1')</script></td>
				</tr>
			</table>
			
			<div id="tabLayer" style="display:Inline;">
		<!-- Grid  (S) -->
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg">
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
							<tr>
								<td>B/L Total&nbsp;&nbsp;<input type="text" name="bl_tot_cnt" maxlength="5" style="width:50;text-align:right" class="input2" dataformat="uppernum" value="" readonly>
                                   &nbsp;&nbsp;&nbsp;&nbsp;Ship Call No.&nbsp;&nbsp;<input type="text" name="ship_call_no" style="width:50;text-align:right" class="input2" dataformat="uppernum" value="" readonly>
                                   &nbsp;&nbsp;&nbsp;&nbsp;Vessel ID	&nbsp;&nbsp;<input type="text" name="vsl_id"       style="width:50;text-align:right" class="input2" dataformat="uppernum" value="" readonly> 	
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		<!-- Grid (E) -->

			</div>
			
						
			<div id="tabLayer" style="display:none;">
		<!-- Grid  (S) -->
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg">
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
							<tr>
								<td>CNTR Total&nbsp;&nbsp;<input type="text" name="cntr_tot_cnt" maxlength="5" style="width:50;text-align:right" class="input2" dataformat="uppernum" value="" readonly></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

		<!-- Grid (E) -->

			</div>
		<!--  Button_Sub (S) -->
		
    	<!-- Button_Sub (E) -->	
					
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
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_down_excel" id="btn_Retrieve">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Transmit">EDI Transmit</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td><script language="javascript">ComComboObject('s_status',1,120, 1, 0, 0, 'true');</script></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    <!--Button (E) -->

    	</td>
	</tr>
</table>

<!-- Copyright(E)--> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>