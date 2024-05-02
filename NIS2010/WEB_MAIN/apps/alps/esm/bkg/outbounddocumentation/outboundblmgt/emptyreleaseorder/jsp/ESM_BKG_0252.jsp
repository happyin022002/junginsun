<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0252.jsp
*@FileTitle : Empty Container Release Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.10 최도순
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event.EsmBkg0252Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0252Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.EmptyReleaseOrder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0252Event)request.getAttribute("Event");
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
<title>Empty Container Release Order</title>
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
<input type="hidden" name="cnt_cd" value="<%=strCnt_cd%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="strCnt_cd" value="<%=strCnt_cd%>">
<input type="hidden" name="inter_rmk">
<!-- 개발자 작업	-->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=System.getProperty("user.home")+System.getProperty("file.separator")%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle" value="Empty Container Release Order">
<input type="hidden" name="com_mrdDisableToolbar" value="2;3;12;14">
<input type="hidden" name="com_mrdBodyTitle" value="<span style='color:red'>Empty Container Release Order</span>">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">

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
		<table class="search"> 
       	<tr><td class="bg">

			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="430" style="padding-left:3">
						<table border="0" style="width:420;" class="search_sm2"> 
							<tr>
								<td><input type="radio" name="datetype" value="BKG" class="trans" checked><b>BKG</b>&nbsp;&nbsp;<input type="radio" name="datetype" value="PUP" class="trans"><b>P/UP Date</b></td>
								<td><input type="text" style="width:110" class="input1" name="from_dt" dataformat="ymdhm" cofield="end_dt" value="<%=JSPUtil.getKST("yyyy-MM-dd")%> 00:00">&nbsp;&nbsp;~&nbsp;
                                    <input type="text" style="width:110" class="input1" name="end_dt" dataformat="ymdhm" cofield="from_dt" value="<%=JSPUtil.getKST("yyyy-MM-dd")%> 23:59">
                                    <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
                                </td>
							</tr>
						</table>
					</td>
					<td width="70">BKG Office</td>
					<td width="70"><input type="text" style="width:60;text-align:center;" class="input" name="bkg_ofc_cd" maxlength="6" dataformat="engup" value="<%=strOfc_cd%>" ></td>		
					<td width="60">BKG Staff</td>
					<td width="95"><input type="text" style="width:80;text-align:center;" class="input" name="doc_usr_id" value=""></td>
					<td width="70">EQ Control</td>
					<td width="60"><input type="text" style="width:48;" class="input" name="eq_ctrl_ofc_cd" maxlength="5" dataformat="engup" value="" ></td>		
					<td width="70">EQ Confirm</td>
					<td width="">
						<select style="width:50;" name="eq_confirm">
							<option value="" >All</option>
							<option value="Y" >Y</option>
							<option value="N" >N</option>
						</select>
					</td>						 
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="30">&nbsp;VVD</td>
					<td width="90"><input type="text" name="vvd" style="width:80;" class="input1" value="" style="ime-mode:disabled" dataformat="eng" caption="VVD" maxlength="9" fullfill></td>
					<td width="25">POR</td>
					<td width="80"><input type="text" name="por_cd" style="width:60;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="POR" maxlength="5" fullfill></td>								 
					<td width="25">POL</td>
					<td width="84"><input type="text" name="pol_cd" style="width:60;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="POL" maxlength="5" fullfill></td>								 
					<td width="25">POD</td>
					<td width="72"><input type="text" name="pod_cd" style="width:60;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="POD" maxlength="5" fullfill></td>								 
					<td width="50">P/UP CY</td>
					<td width="90"><input type="text" name="mty_pkup_yd_cd" style="width:80;" class="input" value="" style="ime-mode:disabled" caption="P/UP CY" maxlength="7" fullfill></td>								 
					<td width="60">RTN CY</td>
					<td width="95"><input type="text" name="full_rtn_yd_cd" style="width:80;" class="input" value="" style="ime-mode:disabled" caption="RTN CY" maxlength="7" fullfill></td>								 
					<td width="50">BKG No.</td>
					<td ><input type="text" name="bkg_no" style="width:100;" class="input1" value="" style="ime-mode:disabled" caption="BKG No." maxlength="13" minlength="11"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					
					<td width="250" style="padding-left:3">
						<table border="0" style="width:240;" class="search_sm2"> 
							<tr>
								<td align="right"><b>Type</b></td>
								<td>
									<input type="radio" name="ser_type" value="simple" class="trans" onClick="javascript:chkSerType(this)">Simple
									<input type="radio" name="ser_type" value="detail" class="trans" checked onClick="javascript:chkSerType(this)">Detail
									<input type="radio" name="ser_type" value="usa" class="trans" onClick="javascript:chkSerType(this)">Detail(USA)
								</td>
							</tr>
						</table>
					</td>
					<td width="97">Inland/Port(s)</td>
					<td width="83"><select style="width:70;" name="pi_type" class="input">
										<option value="" >All</option>
										<option value="I" >Inland</option>
										<option value="P" >Port(s)</option>
									</select>
					</td>		
					<td width="90">Loading Date</td>
					<td width="240">
					    <input type="text" style="width:80"  class="input" name="from_dt2" dataformat="ymd" cofield="end_dt2">&nbsp;&nbsp;~&nbsp;
                    	<input type="text" style="width:88"  class="input" name="end_dt2" dataformat="ymd" cofield="from_dt2">
                        <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
                    </td>
					<td width="">Empty P/UP ≠ Full Return CY&nbsp;<input type="checkbox" name="empty_full_chk" value="Y" class="trans"></td>	
				</tr>
			</table>
			
		</td>		
		</tr></table>
		
	<table class="height_8"><tr><td></td></tr></table>
			
				<!--  biz_2   (E) -->		
			<table class="search"> 
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
			
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg" name="no_aaaa">
				<table border="0" cellpadding="0" cellspacing="0">
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_CheckAll">Check All</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_UncheckAll">Uncheck All</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_Print">Print</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_Preview">Preview</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_EditFAXEmail">Edit Fax/E-mail</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_Remark">Remark(s)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td id="btn_Fax1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_FAX">Fax</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_EMail">E-mail</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_EDI">EDI</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<!-- 
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2_1" name="no_btn_EmailEdit">E-mail (Edit)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					-->
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
		</td>
	</tr></table>	
			
	</td></tr>
		</table>
			
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="font:15px;position:absolute;left:10px;"> 
		<tr><td>If you want to receive email copy, please go to “Setup -> Client Default” and select “Receiving mail copy option”</td></tr>
	</table><br>

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