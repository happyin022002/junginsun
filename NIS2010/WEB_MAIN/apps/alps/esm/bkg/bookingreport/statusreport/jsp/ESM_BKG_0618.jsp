<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0618.jsp
*@FileTitle : Loading Confirmation by Shipper (Fax / E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.25 김기종 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.05.30 이일민 [CHM-201111164] Loading Confimation by Shipper기능 - VVD조회조건 FEEDER포함
* 2011.06.03 이일민 [CHM-201111164] Loading Confimation by Shipper기능 - VVD조회조건 FEEDER포함
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0618Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0618Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOffice_cd 	= "";
	String strCnt_cd		= "";
	String fax_no			= "";
	String mphn_no			= "";
	String strUserHomerFileSeparator = "";	
	String toDay = DateTime.getDateString().replace(".","-"); //DateTime.getDateString(); //DateTime.getFormatString("yyyy-mm-dd");
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOffice_cd = account.getOfc_cd();
		fax_no	  = account.getFax_no();
		mphn_no   = account.getMphn_no();
		strCnt_cd = account.getCnt_cd();
		
		event = (EsmBkg0618Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<title>Loading Confirmation by Shipper (Fax / E-Mail)</title>
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
<input type="hidden" name="rd_param" value="">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id %>">
<input type="hidden" name="strOffice_cd" value="<%=strOffice_cd %>">
<input type="hidden" name="strCnt_cd" value="<%=strCnt_cd%>">
<input type="hidden" size="200" name="com_mrdPath" value="">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=strUserHomerFileSeparator %>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" value="">
<input type="hidden" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Loading Confirmation by Shipper Preview & Print</span>">
<!-- 개발자 작업	-->

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
				
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="720" valign="top">
					<table style="width:100%;">
					<tr class="h23"><td width="66">VVD</td>
					<td width="99"><input type="text" name="vvd_cd" style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="VVD" maxlength="9" fullfill ></td>
					<td width="59">POL</td>
					<td width="55"><input type="text" name="pol_cd" style="width:50;" class="input" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="POL" maxlength="5" fullfill ></td>
					<td width="51">S/C No.</td>
					<td width=""><input type="text" name="sc_no" style="width:145;" class="input" value="" style="ime-mode:disabled" dataformat="uppernum"  caption="S/C No." maxlength="20" ></td>
					<td width="240"><table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
					<td width="43%"align="center"class="tr2_head2">Container Status</td>
					<td width=""align="left"td class="stm">
						<input type="radio" name="cnmv_sts_cd" value="VL" class="trans" checked >&nbsp;VL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="cnmv_sts_cd" value="" class="trans">&nbsp;All</td>
					</tr>
				</table></td>
			</tr></table>
			<table style="height:2;"><tr><td></td></tr></table>
				<table style="width:100%;">
				<tr class="h23"><td width="66">BKG Office</td>
					<td width="99"><input type="text" name="bkg_ofc_cd" style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="BKG Office" maxlength="6"  ></td>
					<td width="59">Customer</td>
					<td colspan="3" style="padding-left:2">
						<script language="javascript">ComComboObject('bkg_cust_tp_cd', 1, 100, 1,0,0);</script>
						<!--<select style="width:80;">
							<option value="0" selected>SH</option>
						</select>
						-->
						&nbsp;
						<input type="text" name="cust_cnt_cd" style="width:30;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="Country Code" maxlength="2" fullfill >
						<input type="text" name="cust_seq" style="width:80;" class="input" value="" style="ime-mode:disabled" dataformat="int"  caption="Cust Seq" maxlength="6" >
						<img src="img/btns_search.gif" name="btn_ComEns041Pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
					<td width="240">
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
					<td width="43%"align="center" rowspan="2" class="tr2_head2">Language</td>
					<td width="%"align="left"class="stm"class="input2">
						<input type="radio" name="language" value="F" class="trans" checked>&nbsp;French
				&nbsp;<input type="radio" name="language"  value="E" class="trans">&nbsp;English</td>
					</tr>
				</table></td>
					</tr>
					</table>
		</td>		
		<td width="10"></td>
		<td width="" valign="top" align="right">
		<table border="0" style="width:100%; background-color:white;" class="grid2"> 
		
				<tr >
					<td width="50%%"align="center"class="tr2_head2">Send Date</td>
					<td width="%"align="left" class="stm" class="input2">
						<input type="text" name="snd_dt" style="width:75;" class="noinput" value=""  dataformat="ymd" caption="SEND DATE" maxlength="10">
					</td>
					</tr>
				<tr >
					<td width="50%%"align="center"class="tr2_head2">Tel.</td>
					<td width="%"align="left" class="stm"class="">
						<input type="text" name="mphn_no" style="width:100%;text-align:left;" class="noinput" value="<%=mphn_no %>" style="ime-mode:disabled"  caption="Tel." maxlength="30" >
						
					</td>
					</tr>
				<tr >
					<td width="50%%"align="center"class="tr2_head2">Fax</td>
					<td width="%"align="left" class="stm"class="">
						<input type="text" name="fax_no" style="width:100%;text-align:left;" class="noinput" value="<%=fax_no %>" style="ime-mode:disabled"  caption="Fax" maxlength="30" >
						
					</td>
					</tr>
					</tr>
				</table>	
				</td></tr></table>
		
	
				<!--  biz_2   (E) -->		
				
	
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			
				
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_CheckAll">Check All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_UncheckAll">Uncheck All</td>
						<td class="btn2_right"></td>
						</tr>						
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Preview">Preview & Print</td>
						<td class="btn2_right"></td>
						</tr>						
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_EditFAXEmail">Edit Fax/E-mail</td>
						<td class="btn2_right"></td>
						</tr>						
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr id="btn_Fax1"><td class="btn2_left"></td>
						<td class="btn2" name="btn_FAX">Fax</td>
						<td class="btn2_right"></td>
						</tr>						
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_EMail">E-mail</td>
						<td class="btn2_right"></td>
						</tr>						
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		</td>
	</tr></table>	
			
			
		</td></tr>
	</table>	
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	</td></tr>
		</table>
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
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
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

	<table><tr>
	  <td height="0" width="0">
	  <script language="javascript">comRdObject('report1');</script>
	  </td>
	 </tr>	</table>
<!-- 개발자 작업  끝 -->
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
</body>
</html>