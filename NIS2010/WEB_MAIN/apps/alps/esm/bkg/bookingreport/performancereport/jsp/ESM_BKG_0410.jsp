
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0410.jsp
	 *@FileTitle : Performance Report by Volume
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0410Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0410Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0410Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
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
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
		<input type="hidden" name="usr_id"      value="<%=strUsr_id%>">
	<input type="hidden" name="curr_page"      value="1">
	<input type="hidden" name="rows_per_page"  value="50">
	
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		
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
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

		<table class="search"> 
    <tr><td class="bg">	
    
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Doc OFC</td>
					<td width="90"><script language="javascript">ComComboObject('dpcs_ofc_cd', 1, 70, '');</script></td>
					<td width="45">Period</td>
					<td width="300">
					<input type="text" name="from_dt" style="width:75" value="" class="input1" dataformat="ymd" caption="Period Start Date" maxlength="10"  style="ime-mode:disabled"  required  cofield="to_dt">
						<input type="text" name="from_mt" style="width:40" value="00:00" class="input1" dataformat="hm" caption="Period Start Time" maxlength="5" required>&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:75" value="" class="input1" dataformat="ymd" caption="Period End Date" maxlength="10"   style="ime-mode:disabled" required  cofield="from_dt"> <input type="text" name="to_mt" style="width:40" value="23:59" class="input1" dataformat="hm" caption="Period End Time" maxlength="5" required>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name ="btn_period">
					</td>
					<td width="30">VVD</td>
					<td width="90"><input type="text" style="width:75;ime-mode:disabled" class="input" value="" name="vvd_cd" maxlength='9' dataformat='engupnum'></td>
					<td width="30">POL</td>
					<td width="80"><input type="text" style="width:50;ime-mode:disabled"   class="input" value="" name="pol_cd" maxlength='5' dataformat='engupnum'></td>
					<td width="30">POD</td>
					<td width=""><input type="text" style="width:50;ime-mode:disabled"     class="input" value="" name="pod_cd" maxlength='5' dataformat='engupnum'></td>
					<td>Doc Part</td>
					<td ><script language="javascript">ComComboObject('doc_part', 1, 100, '');</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="145">Performance by Queue</td>
					<td width="110"><script language="javascript">ComComboObject('pfm_by_queue_cd', 1, 90, '');</script>
					</td>
					<td width="125">Performance by PIC</td>
					<td width="110"><input type="text" style="width:90;ime-mode:disabled" class="input" value="" name="pic_cd" maxlength='20' dataformat='engnum'></td>
					<td width="50">BKG No.</td>
					<td width="140"><input type="text" style="width:110;ime-mode:disabled" class="input" value="" name="bkg_no" maxlength="13" dataformat='engupnum'></td>
					<td width="60">S/R Kind</td>
					<td width=""><script language="javascript">ComComboObject('sr_knd_cd', 1, 100, '');</script></td>
					
				</tr>
				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			
		<!--biz page (E)-->	
 		<table class="height_8"><tr><td></td></tr></table>


			<!--biz page (S)-->
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
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h10">
					<td width="80" class=""></td>
					<td width="70"></td>
					<td width="20"></td>
					<td width="100"></td>
					<td width="70"></td>
					<td width="20"></td>
					<td width="100"></td>
					<td width="70"></td>
					<td width="20"></td>
					<td width="120"></td>
					<td width="70"></td>
					<td width="20"></td>
					<td width="120"></td>
					<td width=""></td>
				</tr>
				<tr class="h23">
					<td width="" class="tr2_head">Staffs</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_staffs" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">S/R Volume</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_vol" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">S/R Kind</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_kind" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">BKG Volume</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_bkg_vol" readonly></td>
				</tr>
				<tr><td height="1" colspan="12" bgcolor=""></td></tr>
				<tr><td height="1" colspan="12" bgcolor="#808080"></td></tr>
				<tr><td height="1" colspan="12" bgcolor=""></td></tr>
				<tr class="h23">
					<td width="" class="tr2_head">Inputter</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_staffs_inputter" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Inputter</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_vol_inputter" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">New</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_kind_new" readonly></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="" class="tr2_head">Rater</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_staffs_rater" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Rater</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_vol_rater" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Amend</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_kind_amend" readonly></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="" class="tr2_head">Auditor</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_staffs_auditor" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Auditor</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_vol_auditor" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">B/L CNFM</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_kind_bl_cnfm" readonly></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="" class="tr2_head">F/OFC</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_staffs_fofc" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">F/OFC</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_vol_fofc" readonly></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Addition</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="tot_sr_kind_addition" readonly></td>
					<td width="" align="center"></td>
					<td width="" class=""></td>
					<td width=""></td>
				</tr>
				</table>
			
				</td>
			</tr>
		</table>
		
		</td></tr>
	</table>		

<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; ">
			<tr>
				<td class="btn1_bg">
				
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_New">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td class="btn1_line"></td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td class="btn1_line"></td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_Weight">Weight</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>							
							<!-- td class="btn1_line"></td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_Print">Print</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td-->
						</tr>
					</table>

		</td>
			</tr>
		</table>
<!--Button (E) --> 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>