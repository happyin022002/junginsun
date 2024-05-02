<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0098.jsp
*@FileTitle : Booking Receipt Notice (Fax/E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.09 전용진
* 1.0 Creation
*----------------------------------------------------------
* History
* 2012.08.08 조정민 [CHM-201218814] Booking Receipt Notice - VVD name change 기능
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0098Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%
	EsmBkg0098Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String strCnt_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingListSearch");
	String rtnOfcCd = null;
	List<BkgComboVO> bkg_sts_cd = null;
	List<BkgComboVO> bkg_kind = null;
	List<BkgComboVO> bkg_cust_tp_cd = null;
	List<BkgComboVO> fax_sts_cd = null;
	List<BkgComboVO> eml_sts_cd = null;
	String strUserHomerFileSeparator = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0098Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		rtnOfcCd = (String) eventResponse.getCustomData("rtn_ofc_cd");
		bkg_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_sts_cd");
		bkg_kind = (List<BkgComboVO>) eventResponse.getCustomData("bkg_kind");
		bkg_cust_tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_cust_tp_cd");
		fax_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("fax_sts_cd");
		eml_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("eml_sts_cd");

	    String strTemp1 = System.getProperty("user.home");
	    if (strTemp1 != null) {
	    } else {
	    	strTemp1 = "";
	    }
	  	
	    String strTemp2 = System.getProperty("file.separator");
	    if (strTemp2 != null) {
	    } else {
	    	strTemp2 = "";
	    }
	    strUserHomerFileSeparator = strTemp1 + strTemp2;
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking Receipt Notice (Fax/E-Mail)</title>
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
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="strCnt_cd" value="<%=strCnt_cd%>">
<input type="hidden" name="mrd" value="<%=("China".equals(JSPUtil.getNull(rtnOfcCd))?"ESM_BKG_5005C":"ESM_BKG_5005G")%>">
<input type="hidden" name="rtn_ofc_cd" value="<%=rtnOfcCd%>">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=strUserHomerFileSeparator%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle" value="Booking Receipt Notice">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle" value="Booking Receipt Notice">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">
<input type="hidden" name="com_fileKey"> 

<input type="hidden" name="edt_ntc_knd_cd">
<input type="hidden" name="edt_bkg_no_list">
<input type="hidden" name="edt_to_eml">
<input type="hidden" name="edt_cc_eml">
<input type="hidden" name="edt_from_eml">
<input type="hidden" name="edt_subject">
<input type="hidden" name="edt_contents">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">BKG DT</td>
						<td width="233"><input type="text" style="width:75" maxlength="10" class="input1" name="bkg_from_dt" caption="BKG DT" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:75" maxlength="10" class="input1" name="bkg_to_dt" caption="BKG DT" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
						<td width="70">BKG Office</td>
						<td width="120"><input type="text" name="bkg_ofc_cd" maxlength="6" dataformat="engup" style="width:70;" value="<%=strOfc_cd%>" class="input"></td>
						<td width="67">BKG Staff</td>
						<td width="100"><input type="text" name="bkg_staff" maxlength="20" style="ime-mode:disabled"  dataformat="engnum" style="width:70;" value="" class="input"></td>
						<td width="75">BKG Status</td>
						<td width="100" style="padding-left:2;"><%=HTMLUtil.getComboString("bkg_status", "width:70;", "", "","","All", bkg_sts_cd)%></td>
						<td width="65">BKG Kind</td>
						<td width="" align="right"><%=HTMLUtil.getComboString("bkg_kind", "width:100;", "", "","","All", bkg_kind)%></td>
					</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">VVD</td>
						<td width="120"><input type="text" name="vvd" maxlength="9" dataformat="engup" style="width:90;" value="" class="input1"></td>
						<td width="25">POL</td>
						<td width="100"><input type="text" name="pol_cd" maxlength="5" dataformat="engup" style="width:50;" value="" class="input">&nbsp;<input type="text" name="pol_yd_cd" maxlength="2" dataformat="engup" style="width:25;" value="" class="input"></td>
						<td width="25">POD</td>
						<td width="100"><input type="text" name="pod_cd" maxlength="5" dataformat="engup" style="width:50;" value="" class="input">&nbsp;<input type="text" name="pod_yd_cd" maxlength="2" dataformat="engup" style="width:25;" value="" class="input"></td>
						<td width="25">POR</td>
						<td width="70"><input type="text" name="por_cd" maxlength="5" dataformat="engup" style="width:50;" value="" class="input"></td>
						<td width="25">DEL</td>
						<td width="70"><input type="text" name="del_cd" maxlength="5" dataformat="engup" style="width:50;" value="" class="input"></td>
						<td width="75">Sales Office</td>
						<td width="70"><input type="text" name="sales_ofc" maxlength="6" dataformat="engup" style="width:50;" value="" class="input"></td>
						<td width="70">Sales Rep.</td>
						<td><input type="text" name="sales_rep" maxlength="5" dataformat="engup" style="width:70;" value="" class="input"></td>
					</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">BKG No.</td>
						<td width="100"><input type="text" name="bkg_no" maxlength="13" dataformat="engup" style="width:90;" value="" class="input1"></td>
						<td width="67">Customer</td>
						<td width="340" style="padding-left:2;"><%=HTMLUtil.getComboString("cust_tp_cd", "width:110;", "", "","","All", bkg_cust_tp_cd)%>
							<input type="text" name="cust_cnt_cd" maxlength="2" dataformat="engup" style="width:30;" value="">
							<input type="text" name="cust_seq" maxlength="6" dataformat="engup" style="width:50;" value="">
							<input type="text" name="cust_nm" maxlength="50" dataformat="eng" style="width:130;" value=""></td>
						<td width="180" class="stm"><b>Fax Status</b>
							<%=HTMLUtil.getComboString("fax_proc_sts_cd", "width:100;", "", "","","All", fax_sts_cd)%>
						</td>
						<td class="stm"><b>E-mail Status</b>
							<%=HTMLUtil.getComboString("eml_proc_sts_cd", "width:100;", "", "","","All", eml_sts_cd)%>
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->	
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	

			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->		

			<table border="0" style="padding-top:10; width:830; background-color:white;" class="grid2"> 
				<tr>
					<td width="40" class="tr2_head2"><b>Fax</b></td>
					<td width="60" class="tr2_head2">BKG Total</td>
					<td width="60" class="align_r"><input type="text" name="fax_bkg_total" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
					<td width="60" class="tr2_head2">Fax Total</td>
					<td width="60" class="align_r" align="right"><input type="text" name="fax_total" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
					<td width="60" class="tr2_head2">Success</td>
					<td width="60" class="align_r" align="right"><input type="text" name="fax_success" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
					<td width="60" class="tr2_head2">Sending</td>
					<td width="60" class="align_r" align="right"><input type="text" name="fax_send" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
					<td width="60" class="tr2_head2">Un-sent</td>
					<td width="" class="align_r" align="right"><input type="text" name="fax_unsent" style="width:200;text-align:right" class="noinput" value="" readOnly></td>
				</tr>
				<tr>
					<td width="40" class="tr2_head2"><b>E-mail</b></td>
					<td width="60" class="tr2_head2">BKG Total</td>
					<td width="60" class="align_r" align="right"><input type="text" name="eml_bkg_total" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
					<td width="60" class="tr2_head2">E-mail Total</td>
					<td width="60" class="align_r" align="right"><input type="text" name="eml_total" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
					<td width="60" class="tr2_head2">Success</td>
					<td width="60" class="align_r" align="right"><input type="text" name="eml_success" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
					<td width="60" class="tr2_head2">Sending</td>
					<td width="60" class="align_r" align="right"><input type="text" name="eml_send" style="width:60;text-align:right" class="noinput" value="" readOnly></td>
					<td width="60" class="tr2_head2">Un-sent</td>
					<td width="" class="align_r" align="right"><input type="text" name="eml_unsent" style="width:200;text-align:right" class="noinput" value="" readOnly></td>
				</tr>
			</table>

			<!--  Button_Sub (S) -->
			<table width="100%" class="button" border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Print">Print</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Preview">Preview</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_EditFaxEmail">Edit Fax/E-mail</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
			        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			        <tr><td class="btn2_left"></td>
			        <td class="btn2" name="btn_AssignEmail">Assign BKG Agent E-mail</td>
			        <td class="btn2_right"></td>
			        </tr>
			        </table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_EditRemark">Edit Remark(s)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_EditVVD">Edit VVD</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_EditCCT">Edit CCT</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr id="btn_Fax1"><td class="btn2_left"></td>
					<td class="btn2" name="btn_Fax">Fax</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Email">E-mail</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_GroupEmail">Group E-mail</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_EmailEdit">E-mail (Edit)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr>
				</table>
				   
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) --> 
  
			</td></tr>
		</table>
		<!--biz page (E)-->

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="font:15px;position:absolute;left:10px;"> 
			<tr><td>If you want to receive email copy, please go to “Setup -> Client Default” and select “Receiving mail copy option”</td></tr>
		</table><br>
  
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>  
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
	</td></tr>
		</table>
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
<!-- Copyright(E)-->
</form>
<form name="form3" method="post">
    <input type="hidden" name="pop_mode">
    <input type="hidden" name="display">
    <input type="hidden" name="func">
    <input type="hidden" name="row">
    <input type="hidden" name="col">
    <input type="hidden" name="sheetIdx">
	<input type="hidden" name="bkg_no">
	<input type="hidden" name="bl_no">
	<input type="hidden" name="ok_hidden">
	<input type="hidden" name="send_hidden">     
	<input type="hidden" name="form_type">
	<input type="hidden" name="form_dataOnly">
	<input type="hidden" name="form_manifest">
	<input type="hidden" name="form_hiddeData">
	<input type="hidden" name="form_mainOnly">
	<input type="hidden" name="form_level">
	<input type="hidden" name="form_remark">
	<input type="hidden" name="form_Cntr">     
	<input type="hidden" name="form_CorrNo">
	<input type="hidden" name="form_his_cntr">
	<input type="hidden" name="form_his_bkg">
	<input type="hidden" name="form_his_mkd">
	<input type="hidden" name="form_his_xpt">
	<input type="hidden" name="form_his_bl">
	<input type="hidden" name="rp">       
    <input type="hidden" name="ntc_knd_cd">
</form>
<form name="form4" method="post">
    <input type="hidden" name="row">
    <input type="hidden" name="col">
</form>
<form name="form5" method="post">
  <input type="hidden" name="f_cmd">
  <input type="hidden" name="bkg_no">
</form>
</body>
</html>