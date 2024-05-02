<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0243.jsp
*@FileTitle : Arrival Info. Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.06.03 박성호
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0243Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	EsmBkg0243Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_email	    = "";
	String strOfc_cd    = "";

	String strPodCd = "";

	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strUsr_email = account.getUsr_eml();
	    strOfc_cd = account.getOfc_cd();
	    strPodCd = request.getParameter("pod_cd");


		event = (EsmBkg0243Event)request.getAttribute("Event");
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
<%
//String[] arrColNames = new String[]{"vsl_nm","vvd","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd","pod_cd"};
String[] arrColNames = new String[]{"vsl_nm","vvd","vsl_flg","vsl_flg_cnt_nm","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","diff_rmk","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd","pod_cd"};
int x = 0;
%>
<html>
<head>
<title>Arrival Info. Setting</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var strUsr_nm    = "<%=strUsr_nm %>";
	var strUsr_email = "<%=strUsr_email %>";
	var strOfc_cd    = "<%=strOfc_cd %>";

	var arrColValues = new Array(<%=arrColNames.length%>);
	<%
	for(int i=0;i<arrColNames.length;i++){
	%>
		arrColValues[<%=i%>] = "<%=JSPUtil.getNull(request.getParameter(arrColNames[i]))%>";
	<%
	}
	%>



	function setupPage(){
		//var errMessage = "<%=strErrMsg%>";
		//if (errMessage.length >= 1) {
		//	showErrMessage(errMessage);
		//} // end if
		loadPage();
	}


</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input name="f_cmd" type="hidden" />
<input type="hidden" name="pagerows" value="<%=pageRows %>">

<!-- 개발자 작업	-->

<input type="hidden" name="ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="pod_cd" value="<%=StringUtil.xssFilter(strPodCd)%>">
<input type="hidden" name="row" value="<%= StringUtil.xssFilter(request.getParameter("row"))%>"></input>

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Arrival Info.Setup</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">
				<!--biz 1 (S)-->
				<table class="search" border="0" style="width:680;">
					<tr class="h23">
						<td width="355" valign="top">

							<table class="search" border="0" style="width:100%;">

								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="vsl_nm_chk" id="vsl_nm_chk" onClick="fncCheckboxOnClick('vsl_nm')">&nbsp;Arrival Vessel</td>
									<td width="210"><input type="text" style="width:100%;" class="input" value="" name="vsl_nm" id="vsl_nm" onblur="fncBlur(this);" maxlength="100"></td>
								</tr>
								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="vvd_chk" id="vvd_chk">&nbsp;VVD</td>
									<td width=""><select name="vvd" id="vvd" onChange="fncChangeVVD(this)"></select>
									<!-- <input type="text" style="width:70%;" class="input" value="" name="vvd" id="vvd" maxlength="9" onblur="fncBlur(this);" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled"> --></td>
								</tr>
								<tr class="h23">
									<td width=""><input type="checkbox" value="Y" class="trans" name="vsl_flg" id="vsl_flg">&nbsp;Vessel Flag</td>
									<td width="210"><input type="text" style="width:100%;" class="input2" value="" name="vsl_flg_cnt_nm" id="vsl_flg_cnt_nm" readOnly/></td>
								</tr>
								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="pod_arr_dt_chk"  id="pod_arr_dt_chk" onClick="fncCheckboxOnClick('pod_arr_dt')">&nbsp;ETA  POD</td>
									<td width=""><input type="text" style="width:60%;" class="input" value="" name="pod_arr_dt" id="pod_arr_dt" onKeyPress="ComKeyOnlyNumber(this,'-: ');" onblur="fncBlur(this);fncAutoSettingTime(this);ComChkObjValid(event.srcElement);" dataformat="ymdhm" style="ime-mode:disabled" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;NULL<input type="checkbox" class="trans" id="pod_arr_dt_null" onclick="pod_arr_dt.value=this.checked?'':pod_arr_dt.value;fncBlur(pod_arr_dt);"></td>
								</tr>
								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="del_eta_dt_chk" id="del_arr_dt_chk" onClick="fncCheckboxOnClick('del_arr_dt')">&nbsp;ETA  DEL.</td>
									<td width=""><input type="text" style="width:60%;" class="input" value="" name="del_arr_dt" id="del_arr_dt" onKeyPress="ComKeyOnlyNumber(this,'-: ');" onblur="fncBlur(this);fncAutoSettingTime(this);ComChkObjValid(event.srcElement);" dataformat="ymdhm" style="ime-mode:disabled" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;NULL<input type="checkbox" class="trans" id="del_arr_dt_null" onclick="del_arr_dt.value=this.checked?'':del_arr_dt.value;fncBlur(del_arr_dt);"></td>
								</tr>
								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="pkup_aval_dt_chk" id="pkup_aval_dt_chk" onClick="fncCheckboxOnClick('pkup_aval_dt')">&nbsp;Available Date</td>
									<td width=""><input type="text" style="width:60%;" class="input" value="" name="pkup_aval_dt" id="pkup_aval_dt" onKeyPress="ComKeyOnlyNumber(this,'-: ');" onblur="fncBlur(this);fncAutoSettingTime(this);ComChkObjValid(event.srcElement);" dataformat="ymdhm" style="ime-mode:disabled" maxlength="16">&nbsp;&nbsp;&nbsp;&nbsp;NULL<input type="checkbox" class="trans" id="pkup_aval_dt_null" onclick="pkup_aval_dt.value=this.checked?'':pkup_aval_dt.value;fncBlur(pkup_aval_dt);"></td>
								</tr>

								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="pkup_free_dt_chk" id="pkup_free_dt_chk" onClick="fncCheckboxOnClick('pkup_free_dt')">&nbsp;Last Free Date <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;to Pick up</td>
									<td width=""><input type="text" style="width:60%;" class="input" value="" name="pkup_free_dt" id="pkup_free_dt" onKeyPress="ComKeyOnlyNumber(this,'-');" onblur="fncBlur(this);ComChkObjValid(event.srcElement);" dataformat="ymd" maxlength="10" style="ime-mode:disabled;text-decoration:underline">&nbsp;&nbsp;&nbsp;&nbsp;NULL<input type="checkbox" class="trans" id="pkup_free_dt_null" onclick="pkup_free_dt.value=this.checked?'':pkup_free_dt.value;fncBlur(pkup_free_dt);"></td>
								</tr>
								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="pkup_yd_cd_chk" id="pkup_yd_cd_chk" onClick="fncCheckboxOnClick('pkup_yd_cd')">&nbsp;Full CNTR P/Up CY</td>
									<td width=""><input type="text" style="width:100%;" class="input" value="" name="pkup_yd_cd" id="pkup_yd_cd" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onblur="fncBlur(this)" maxlength="7" style="ime-mode:disabled"></td>
								</tr>
								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="rtn_yd_cd_chk" id="rtn_yd_cd_chk" onClick="fncCheckboxOnClick('rtn_yd_cd')">&nbsp;Empty Return CY</td>
									<td width=""><input type="text" style="width:100%;" class="input" value="" name="rtn_yd_cd" id="rtn_yd_cd" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onblur="fncBlur(this)" maxlength="7" style="ime-mode:disabled"></td>
								</tr>

								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="an_fom_cd_chk" id="an_fom_cd_chk">&nbsp;A/N Form Type</td>
									<td width="" style="padding-left:2">
									<select style="width:70%;" name="an_fom_cd" id="an_fom_cd" onChange="fncAnFomCdChange(this);fncBlur(this);">
										<option value="GE" selected>General</option>
										<option value="DR">Door </option>
										<option value="CY">CY</option>
										<option value="CF">CFS Cargo</option>
										<option value="SP">Special Cargo</option>
										<option value="E1">Event</option>
									</select></td>
								</tr>
								<tr class="h23">
									<td width="200"><input type="checkbox" value="" class="trans" name="chn_agn_cd_chk" onClick="fncCheckboxOnClick('chn_agn_cd')">&nbsp;Agent</td>
									<td width=""><input type="text" style="width:20%;" class="input" value="" name="chn_agn_cd" id="chn_agn_cd" onblur="fncBlur(this)" onKeyPress="ComKeyOnlyAlphabet('upper','42');" maxlength="2" style="ime-mode:disabled"></td>
								</tr>
								<tr class="h23">
									<td width=""><input type="checkbox" value="Y" class="trans" name="ntc_rvis_flg" id="ntc_rvis_flg">&nbsp;Revise</td>
								</tr>
								<tr class="h23">
									<td width=""><input type="checkbox" value=""class="trans" name="diff_rmk_chk" id="diff_rmk_chk" onClick="fncCheckboxOnClick('diff_rmk')">&nbsp;Remark</td>
									<td width=""><textarea style="width:100%;height:42;overflow-x:hidden" class="input" name="diff_rmk" id="diff_rmk" onblur="fncBlur(this)" wrap="hard"></textarea></td>
								</tr>
							</table>
						</td>
						<td width="20">&nbsp;</td>
						<td width="330" valign="top">

							<table class="grid2" border="0" style="width:100%;">
								<tr class="tr2_head"><td>Address</td></tr>
								<tr><td class="noinput2"><input type="text" style="width:100%;" class="noinput2" value="" name="addr_cnt" readOnly></td></tr>
							</table>
							<table class="line_bluedot"><tr><td></td></tr></table>
							<table class="grid2" border="0" style="width:100%;">
								<tr class="tr2_head"><td>Important Notice</td></tr>
								<tr><td class="noinput2" width=""><textarea style="width:100%;height:243" class="noinput2" name="impt_ntc_rmk" readOnly></textarea></td></tr>
							</table>
						</td>
					</tr>
				</table>
				<!--biz 1 (E)-->

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>






<!-- : ( Button : pop ) (S) -->
            <table width="100%" class="sbutton">
                <tr><td height="71" class="popup">

                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
                            <tr><td class="btn3_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                        	<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_mnr_rtn_yard_setup">MNR RTN Yard
									Setup</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_setup_arrival_info">Setup
									Arrival Info.</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
						<td class="btn1_line"></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_close">Close</td>
                                                        <td class="btn1_right"></td>
                                                    </tr></table></td>
                                        </tr>
                                    </table>
                                    <!--Button (E) -->

                                </td></tr>
                        </table>
                    </td></tr>
            </table>

            <!-- : ( Button : pop ) (E) -->


<!-- Grid  (S) -->
					<table width="100%"  id="mainTable" style="display:none">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
			<!-- Grid (E) -->
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>