<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1149.jsp
*@FileTitle : Vietnam Customs Manifest 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.10
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.10 조원주
* 1.0 Creation
*
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.event.EsmBkg1149Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1149Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg1149Event) request.getAttribute("Event");
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
<input type="hidden" name="pageno" value="ESM_BKG_1149">
<input type="hidden" name="frm_pol_cd">
<input type="hidden" name="frm_pod_cd">

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

									<table class="search" border="0" style="width:750;">
										<tr class="h23">
											<td>VVD&nbsp;&nbsp;<input type="text" style="width:80; ime-mode:disabled;" class="input1" maxlength="9" name="s_vvd" caption="VVD" dataformat="uppernum" required></td>
<!-- 											<td>Update VVD&nbsp;&nbsp;<input type="text" style="width:45; ime-mode:disabled;" class="input" maxlength="4" name="to_vsl_cd" dataformat="uppernum"> -->
<!-- 												<input type="text" style="width:40; ime-mode:disabled;" class="input" maxlength="4" name="to_skd_voy_no" dataformat="int"> -->
<!-- 												<input type="text" style="width:15; ime-mode:disabled;" class="input" maxlength="1" name="to_skd_dir_cd" dataformat="engup"></td> -->
											<td><table class="search_sm" border="0" style="width:180;">
													<tr class="h23">
														<td><input type="radio" name="pol_gubun" value="1" class="trans" checked>&nbsp;POL&nbsp;<input type="radio" name="pol_gubun" value="2" class="trans">&nbsp;POD
															<input name="frm_port_cd" type="text" dataformat="engupnum" maxlength="5" style="ime-mode: disabled;width:50;" class="input1">&nbsp;</td>
													</tr>
												</table>
											</td>
											 <td>B/L Total&nbsp;&nbsp;<input type="text" name="bl_tot_cnt" maxlength="5" style="width:50;text-align:right" class="input2" dataformat="uppernum" readonly></td>
										
										<td><input type="checkbox" value="X" class="trans" name="mis_flg">&nbsp;Mis-matched CNTR</td></tr>
									</table>
									<table class="search" border="0" style="width:750;">
										<tr class="h23">
											<td>Vessel Name&nbsp;&nbsp;<input type="text" name="vsl_nm" maxlength="100" style="width:150;" class="input2" dataformat="uppernum"></td>
											<td>Call Sign&nbsp;&nbsp;<input type="text" name="vsl_callsign" maxlength="5" style="width:50;" class="input2" dataformat="uppernum"></td>
											<td>ETD&nbsp;&nbsp;<input type="text" name="etd" maxlength="10" style="width:70;" class="input2"></td>
											<td>ETA&nbsp;&nbsp;<input type="text" name="eta" maxlength="10" style="width:70;" class="input2"></td>
<!-- 											<td><input type="checkbox" value="X" class="trans" name="mis_flg">&nbsp;Mis-matched CNTR</td> -->
<!-- 											<td width=120>Mis Flag&nbsp;&nbsp;<input type="text" name="mis_flg" maxlength="5" style="width:50;text-align:right" class="input" dataformat="engupnum"></td> -->
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

			<table class="height_8">
			<tr>
				<td></td>
			</tr>
		    </table>

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
							
							<div style="display:none">
							
								<script language="javascript">ComSheetObject('sheet2');</script>
							
							</div>


						</table>
					</td>
				</tr>


			</table>
		<!-- Grid (E) -->




			<div id="tabLayer" style="display:none;">
		<!-- Grid  (S) -->


		<!-- Grid (E) -->

			</div>
		<!--  Button_Sub (S) -->
		<table class="height_5"><tr><td></td></tr></table>

			<table width="100%" class="search" border="0">
				<tr class="h23" style="width:979">
					<td style="width:380">
						<table border="0" style="width:380; background-color:white;" class="grid2">
							<tr class="tr2_head">
								<td>20'</td>
								<td>40'</td>
								<td>TOTAL</td></tr>
							<tr align="center">
								<td><input type="text" name="tpsz_20_chk"   style="width:100; text-align: center" class="noinput" readonly></td>
								<td><input type="text" name="tpsz_40_chk"   style="width:100; text-align: center" class="noinput" readonly></td>
								<td><input type="text" name="tpsz_tot_chk" style="width:100; text-align: center" class="noinput" readonly></td>
							</tr>
        				</table>
		          	</td>


				</tr>
			</table>
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
									<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_down_excel2" id="btn_Retrieve">Down Excel2</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									</td>
									
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
											<td><script language="javascript">ComComboObject('s_status',1,80, 1, 0, 0, 'true');</script></td>
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