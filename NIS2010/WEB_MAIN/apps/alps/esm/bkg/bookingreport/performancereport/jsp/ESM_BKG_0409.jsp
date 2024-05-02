<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0409.jsp
*@FileTitle : Performance Report by Error
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.10 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0409Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0409Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0409Event)request.getAttribute("Event");
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
<title>Performance Report by Error</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Period</td>
					<td width="350">
						<input type="text" name="from_dt" style="width:80" value="" class="input1" dataformat="ymd" caption="Period Start Date" maxlength="10"  style="ime-mode:disabled"  required  cofield="to_dt">
						<input type="text" name="from_mt" style="width:40" value="00:00" class="input1" dataformat="hm" caption="Period Start Time" maxlength="5" required>
						&nbsp;&nbsp;~&nbsp;&nbsp;
						<input type="text" name="to_dt" style="width:80" value="" class="input1" dataformat="ymd" caption="Period End Date" maxlength="10"   style="ime-mode:disabled" required  cofield="from_dt">
						<input type="text" name="to_mt" style="width:40" value="23:59" class="input1" dataformat="hm" caption="Period End Time" maxlength="5" required>
						&nbsp;
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" onClick="callDatePop()"></td>
					<td>VVD</td>
					<td><input type="text" name="vvd_cd" style="width:110;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="VVD CD" maxlength="9"  fullfill></td>
					<td>POL</td>
					<td><input type="text" style="width:60;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="POL CD" maxlength="5"  fullfill></td>
					<td>POD</td>
					<td><input type="text" style="width:60;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="pod CD" maxlength="5"  fullfill></td>
					<td>Doc Part</td>
						<td><script language="javascript">ComComboObject('doc_part', 1, 100, '');</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="140">Performance by Queue</td>
					<td width="200">
						<script language="javascript" >ComComboObject('usr_grp_cd', 1, 90, 1, 0 ,1)</script><!--
						
						<select style="width:90;" class="input1">
						<option value="0" selected></option>
						<option value="1">D/C  ALL</option>
						<option value="1">Inputter</option>
						<option value="1">Rater</option>
						<option value="1">Auditor</option>
						<option value="1">Front Office</option>
						</select>
					--></td>
					<td>Performance by PIC</td>
					<td><input type="text" name="amd_respb_usr_id" style="width:90;" class="input" value=" "></td>
					<td>BKG No.</td>
					<td><input type="text" name="bkg_no" style="width:110;" class="input" value=" "></td>
					<td>Amend Reason</td>
					<td>
						<script language="javascript" >ComComboObject('sr_amd_rsn_cd', 1, 132, 1, 0 ,1)</script>
						<!--<select style="width:132;">
						<option value="0" selected></option>
						<option value="1">ALL</option>
						<option value="1">Mis-Typing</option>
						<option value="1">Wrong Data</option>
						<option value="1">Mis-Rating (S/C)</option>
						<option value="1">Mis-Rating (RFA)</option>
						<option value="1">Sales</option>
						<option value="1">FO Error</option>
						<option value="1">Data Missing</option>
						<option value="1">Unclear Fax</option>
						<option value="1">B/L Data Change</option>
						<option value="1">COD</option>
						<option value="1">Split/Combine</option>
						</select>
					--></td>
					
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
			
		
		
		<!-- Grid BG Box  (S) -->
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
			
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80" class="tr_head">Staffs</td>
					<td width="70"></td>
					<td width="20"</td>
					<td width="100" class="tr_head">S/R Kind</td>
					<td width="70"></td>
					<td width="20" align="center"></td>
					<td width="100" class="tr_head">Amend Reason</td>
					<td width="70"></td>
					<td width="20" align="center"></td>
					<td width="120" class="tr_head">Carrier</td>
					<td width="70"></td>
					<td width="20" align="center"></td>
					<td width="120" class="tr_head">Merchant</td>
					<td width=""></td>
				</tr>
				<tr class="h23">
					<td width="" class="tr2_head">Inputter</td>
					<td width=""><input type="text" name="tot_inputter" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Amend</td>
					<td width=""><input type="text" name="tot_amend" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Carrier</td>
					<td width=""><input type="text" name="tot_carrier" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Mis-Typing</td>
					<td width=""><input type="text" name="tot_mis_typing" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Data Missing</td>
					<td width=""><input type="text" name="tot_data_missing" style="width:60;text-align:right" value="0" class="input2" readonly></td>
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="" class="tr2_head">Rater</td>
					<td width=""><input type="text" name="tot_rater" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Return</td>
					<td width=""><input type="text" name="tot_return" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Merchant</td>
					<td width=""><input type="text" name="tot_mrchant"  style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Wrong Data</td>
					<td width=""><input type="text" name="tot_wrong_data"  style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Unclear Fax</td>
					<td width=""><input type="text" name="tot_unclear_fax" style="width:60;text-align:right" value="0" class="input2" readonly></td>
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="" class="tr2_head">Auditor</td>
					<td width=""><input type="text" name="tot_auditor" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Mis-Rating (S/C)</td>
					<td width=""><input type="text" name="tot_sc_mis_rating" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">B/L Data Change</td>
					<td width=""><input type="text" name="tot_bl_data_change" style="width:60;text-align:right" value="0" class="input2" readonly></td>
				</tr>
				<tr><td height="1"></td></tr>
				
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="" class="tr2_head">F/OFC</td>
					<td width=""><input type="text" name="tot_f_ofc" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">S/R Vol.</td>
					<td width=""><input type="text" name="tot_sr_vol" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Mis-Rating(RFA)</td>
					<td width=""><input type="text" name="tot_rfa_mis_rating" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">COD</td>
					<td width=""><input type="text" name="tot_cod" style="width:60;text-align:right" value="0" class="input2" readonly></td>
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Sales</td>
					<td width=""><input type="text" name="tot_sales" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width=""></td>
					<td width="" class="tr2_head">Split/Combine</td>
					<td width=""><input type="text" name="tot_split_combine" style="width:60;text-align:right" value="0" class="input2" readonly></td>
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">F/OFC Error</td>
					<td width=""><input type="text" name="tot_f_ofc_error" style="width:60;text-align:right" value="0" class="input2" readonly></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
				</tr>
				<tr><td height="1"></td></tr>
				</table>
				
				
			
			<table class="height_8"><tr><td></td></tr></table>
			
			
			
				
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
					<td class="btn1" name="btn_retrieve" id ="btn_retrieve" >Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
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
	


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>