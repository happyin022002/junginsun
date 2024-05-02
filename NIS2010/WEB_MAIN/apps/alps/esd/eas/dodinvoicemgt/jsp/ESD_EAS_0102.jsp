<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName  : ESD_EAS_0102.js
*@FileTitle : DOD Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.09.12 이혜민
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
<%@ page import="com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0102Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdEas0102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.specialkpi.planning");
	
	String strOfc_cd 	="";
	String strUsr_eml	= "";
	String rd_nm        = "";
	
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	strOfc_cd	= account.getOfc_cd();

	// 광양의 경우 Report를 분리
//	if ("KA".equals(strOfc_cd.substring(0,2)) ) {
//		rd_nm = "ESD_EAS_1003.mrd";
//	} else {
//		rd_nm = "ESD_EAS_1001.mrd";
//	}
	rd_nm = "ESD_EAS_1004.mrd";
//	String mrd_path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1003.mrd";
	String mrd_path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1004.mrd";
	

	try {
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsdEas0102Event)request.getAttribute("Event");
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
<title>DOD Invoice Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="success_yn" value="">
<input type="hidden" name="dod_inv_no" value="">
<input type="hidden" name="bl_no" value="">
<input type="hidden" name="in_dod_inv_no" value="">
<input type="hidden" name="cntc_pnt_nm" value="">
<input type="hidden" name="cntc_pnt_phn_no" value="">
<input type="hidden" name="cntc_pnt_fax_no" value="">
<input type="hidden" name="cntc_pnt_eml" value="">

<input type="hidden" name="cre_ofc_cd" 	value="<%=strUsr_ofc%>">
 
<input type="hidden" name="iPage"> 
<input type="hidden" name="mrd" value="<%=mrd_path%>">
<input type="hidden" name="rd_name" value="<%=rd_nm%>">
<input type="hidden" name="rd_parm">
<input type="hidden" name="send_flg">
<input type="hidden" name="usr_ofc" value="<%=strOfc_cd%>">

<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" width="100%">
				<tr>
					<td class="bg">
						<table class="search_in">
							<tr>
								<td width="80" rowspan="2">
									<table class="search_sm2" border="0" width="70">
										<tr class="h23">
											<td><input type="radio" name="f_tp_cd" class="trans" value="D" checked><label style="padding-left:2;">Date</label></td>
										</tr>
										<tr class="h23">
											<td><input type="radio" name="f_tp_cd" class="trans" value="I"><label style="padding-left:2;">INV</label></td>
										</tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="80">Issued Date</td>
											<td width="210">
												<input type="text" style="width:80;text-align:center;" class="input1" size="8" maxlength="8"  onKeyPress='ComKeyOnlyNumber(window);' onKeyUp="pointAutoMove(this.value);" name="fm_cre_dt" required dataformat="ymd" cofield="to_cre_dt" caption="start date">
												~&nbsp;<input type="text" style="width:80;text-align:center;" class="input1" size="8" maxlength="8" onKeyPress='ComKeyOnlyNumber(window);' name="to_cre_dt" required dataformat="ymd" cofield="fm_cre_dt" caption="end date">
												<img src="img/btns_calendar.gif" class="cursor" name="btn_Calendar" width="19" height="20" alt="" border="0" align="absmiddle" >
											</td>
											<td width="10"></td>
											<td width="57">INV OFC</td>
											<td width="90">
 												<script language="javascript">ComComboObject('inv_ofc_cd',1,90,1,1);</script>
							                </td>				
							                <td width="20"></td>							
											<td width="35">LOC</td>
											<td width="90">
 												<script language="javascript">ComComboObject('dod_loc_cd',1,90,1,0);</script>
							                </td>
							                <td width="20"></td>
							                <td width="40">Payer</td>
											<td >
												<input type="text" style="width:77;text-align:left;" class="input4" name="payer_cd" value="" dataformat="uppernum" maxlength="8">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_payer_cd" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="payer_nm" style="width:150;text-align:left;" class="input2" readonly>
											</td>							                
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="79">INV No.</td>
											<td width="215">
							                	<input type='text' name='m_dod_inv_no' style='width:178;ime-mode:disabled;' class="input1" dataformat="engupnumcomma" >
							                	<img class="cursor" name="btn_m_dod_inv_no" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="doProcessPopup('btn_m_dod_inv_no')">
							                </td>
							                <td width="56">B/L No.</td>
											<td width="202">
							                	<input type='text' name='m_bl_no' style='width:160;ime-mode:disabled;' class="input1" dataformat="engupnumcomma" >
							                	<img class="cursor" name="btn_m_bl_no" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="doProcessPopup('btn_m_bl_no')">
							                </td>
							                <td width="33">I/F</td>
											<td width="40">
							                	<select style="width:70;" name="ar_if_flg">
							                        <option value="A" selected>ALL</option>
							                        <option value="Y">Y</option>
							                        <option value="N">N</option>
							                    </select>
							                </td>
							                <td width="20"></td>
											<td><input type="checkbox" value="C" name="chk_cancel" class="trans">&nbsp;Including Cancel INV</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<!--<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>-->
			<table class="height_8"><tr><td></td></tr></table>	

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg_b1">
						<table class="height_10"><tr><td></td></tr></table>
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
			
			<table class="height_10"><tr><td>								
							</td></tr></table>
			
			<!--Button_L (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg" style="text-align:left;width:87px">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_fax">Fax Send</td>
									<td class="btn1_right"></td>
								</tr>
								</table>
					</td>
							<td class="btn1_bg" style="display:none;text-align:left;width:100px">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_email">Email Send</td>
									<td class="btn1_right"></td>
								</tr>
								</table>
							</td>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_New" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Ar_If" name="btn_Ar_If">A/R I/F</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Cancel" name="btn_Cancel">Cancel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>							
						</table>
					</td>
				</tr>
			</table>
			<!--Button_L (E) -->
			<tr style="display:none;">
				<td height="1" width="1">
					<script language="javascript">comRdObject('rd_invoice');</script>
				</td>
			</tr>
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html> 