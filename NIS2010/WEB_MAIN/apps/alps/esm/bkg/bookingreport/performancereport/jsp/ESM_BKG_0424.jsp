
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0424.jsp
	 *@FileTitle : Queue Report By Pol 
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0424Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0424Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0424Event) request.getAttribute("Event");
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
	  String bkg_no   = JSPUtil.getParameter(request,"bkg_no"); 
	  String sr_kind  = JSPUtil.getParameter(request,"sr_kind"); 
	  String sr_no    = JSPUtil.getParameter(request,"sr_no"); 
	  String pnd_flg  = JSPUtil.getParameter(request,"pnd_flg"); 
	  String src_cd   = JSPUtil.getParameter(request,"src_cd"); 
	  String sr_crnt_info_cd = JSPUtil.getParameter(request,"sr_crnt_info_cd"); 
	  String sr_crnt_sts_cd  = JSPUtil.getParameter(request,"sr_crnt_sts_cd"); 
	  String ui_id           = JSPUtil.getParameter(request,"ui_id"); 
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
	<input type="hidden" name="curr_page"     value="1">
	<input type="hidden" name="rows_per_page" value="50">	
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
<tr><td class="top"></td></tr>
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

			<!--biz page (S)-->
			
<table class="search"> 
       	<tr><td class="bg">

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100"><input type="radio" value="ETD" class="trans" name="period_gubun" checked>&nbsp;&nbsp;ETD Period</td>
					<td width="230"><input type="text" style="width:75" value="" class="input1" name="etd_from_dt"  maxlength='10' dataformat="ymd" >&nbsp;~&nbsp;<input type="text" style="width:75" value="" class="input1" name="etd_to_dt"  maxlength='10' dataformat="ymd" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_etd_dt"></td>
					<td width="30">POL</td>
					<td width="95"><input type="text" style="width:60;" class="input1" value="" name="pol_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" ></td>
					<td width="65">Total VVD</td>
					<td width="110" ><script language="javascript">ComComboObject('total_vvd', 1, 100, '');</script>
					<!--<select style="width:100;" name="total_vvd">
						<option value="1" selected>ALL</option>
						<option value="1">APCA0638W</option>
						<option value="1">ASKC0816N</option>
						<option value="1">....</option>
						<option value="1">.. .</option>
						<option value="1">..</option>
						</select>-->
						</td>
					<td width="90">BKG Match</td>
					<td width="90"><select style="width:80;" name="bst_match">
						  <option value="A" selected>ALL</option>
						  <option value="M">Matched</option>
						  <option value="U">Unmatched</option>
						</select></td>
					<td width="70">Doc Part</td>
					<td><script language="javascript">ComComboObject('doc_part', 1, 100, '');</script></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="170"><input type="radio" value="SR" name="period_gubun" class="trans">&nbsp;&nbsp;SI Transferred Date</td>
					<td width="286"><input type="text" style="width:75"  value="" class="input1" name="sr_from_dt"  maxlength='10' dataformat="ymd" >&nbsp;~&nbsp;<input type="text" style="width:75"  value="" class="input1" name="sr_to_dt"  maxlength='10' dataformat="ymd" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_sr_dt">
					</td>
					<td width="62">BKG OFC</td>
					<td width="110"><input type="text" style="width:100" value=" " name="bkg_ofc" class="input" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td>
						<td width="90">List by Queue</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('list_by_queue', 1, 80, '');</script>
					<!--<select style="width:80;">
					<option value="1"selected>ALL</option>
						<option value="1">Input</option>
						<option value="1">Rate</option>
						<option value="1">Audit</option>
						<option value="1">Front OFC</option>
						<option value="1">Fax Out</option>
						</select>
						--></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="170"><input type="radio" value="PCT" name="period_gubun" class="trans">&nbsp;&nbsp;PCT Period</td>
					<td width="282"><input type="text" style="width:75" value="" class="input1" name="pct_from_dt" maxlength='10' dataformat="ymd" >&nbsp;~&nbsp;<input type="text" style="width:75" value="" class="input1" name="pct_to_dt" maxlength='10' dataformat="ymd" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pct_dt">
					</td>
					<td>
					<table class="search_sm2" border="0" style="width:409"> 
					<tr class="h23">
					<td width="0">Queue Source</td>
					<td width="" class="stm"><input type="radio" value="" class="trans" name="queue_source" checked>ALL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="FAX" class="trans" name="queue_source">Fax&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="EBKG" class="trans" name="queue_source">E-BKG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="SEANA" class="trans" name="queue_source">SEA-NACCS</td></tr> 
					</table>
					
					</td>
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
			
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
			
		<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80" class="tr_head">Summary</td>
					<td width="70"></td>
					<td width="40"></td>
					<td width="110" class="tr_head">Queue Detail(s)</td>
					<td width="70"></td>
					<td width="40" align="center"></td>
					<td width="100"></td>
					<td width="70"></td>
					<td width="40" align="center"></td>
					<td width="110"></td>
					<td width="70"></td>
					<td width="40" align="center"></td>
					<!--td width="100">FO Returned</td>
					<td width=""><input type="text" style="width:60;text-align:right" value=" " class="input2"></td-->
				</tr>
				<tr class="h23">
					<td width="80" class="tr2_head">TTL BKG</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="ttl_bkg" readonly></td>
					<td width="40" align="center"></td>
					<td width="110" class="tr2_head">Inputter Queue</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="inputter_queue" readonly></td>
					<td width="40" align="center">=</td>
					<td width="100" class="tr2_head">SR Transferred</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="sr_transferred" readonly></td>
					<td width="40" align="center">+</td>
					<td width="110" class="tr2_head">Inputting</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="inputting" readonly></td>
					<td width="40" align="center"></td>
					<!--td width="100">FO Returned</td>
					<td width=""><input type="text" style="width:60;text-align:right" value=" " class="input2" name="" readonly></td-->
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="80" class="tr2_head">SI Y</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="sr_y" readonly></td>
					<td width="40" align="center"></td>
					<td width="110" class="tr2_head">Rater Queue</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="rater_queue" readonly></td>
					<td width="40" align="center">=</td>
					<td width="100" class="tr2_head">Inputted</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="inputted" readonly></td>
					<td width="40" align="center">+</td>
					<td width="110" class="tr2_head">Rating</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="rating" readonly></td>
					<td width="40" align="center"></td>
					<!--td width="100">FO Returned</td>
					<td width=""><input type="text" style="width:60;text-align:right" value=" " class="input2" name="" readonly></td-->
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="80" class="tr2_head">SI N</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="sr_n" readonly></td>
					<td width="40" align="center"></td>
					<td width="110" class="tr2_head">Auditor Queue</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="auditor_queue" readonly></td>
					<td width="40" align="center">=</td>
					<td width="100" class="tr2_head">Rated</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="rated" readonly></td>
					<td width="40" align="center">+</td>
					<td width="110" class="tr2_head">Auditing</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="auditing" readonly></td>
					<td width="40" align="center">+</td>
					<td width="100" class="tr2_head">Audited</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="audited" readonly></td>
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="80" class=""></td>
					<td width="70"></td>
					<td width="40" align="center"></td>
					<td width="110" class="tr2_head">Stopped Queue</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="stopped_queue" readonly></td>
					<td width="40" align="center"></td>
					<td width="100" class=""></td>
					<td width="70"></td>
					<td width="40" align="center"></td>
					<td width="110" class="tr2_head"> F/OFC Returned</td>
					<td width="70"><input type="text" style="width:60;text-align:right" value="" class="input2" name="fofc_returned" readonly></td>
					<!--td width="40" align="center">+</td>
					<td width="100" class="tr2_head">Audited</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="" readonly></td-->
				</tr>
				<tr><td height="1"></td><td height="1"></td><td height="1"></td><td height="1"></td><td height="1"></td><td height="1"></td><td height="1"></td><td height="1"></td><td height="1"></td><td colspan="2" height="1" bgcolor="#808080"></td></tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="" class=""></td>
					<td width=""></td>
					<td width="" align="center"></td>
					<td width="" class="tr2_head">Queue Total</td>
					<td width="" colspan="6"><input type="text" style="width:60;text-align:right" value="" class="input2" name="queue_total" readonly></td>
					</tr>
				
				</table>
			
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
				
				<tr class="h23">
					<td width="160" class="tr2_head">BKG Matched Queue</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="BKG_matched_q" readonly></td>
				</tr>
				<tr><td height="1"></td></tr>
				<tr class="h23">
					<td width="160" class="tr2_head">BKG Unmatched Queue</td>
					<td width=""><input type="text" style="width:60;text-align:right" value="" class="input2" name="bst_unmatched_q" readonly></td>
				</tr>
				</table>
			
				
			</td></tr>
		</table>



<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"	cellspacing="0" style="padding-top: 5; ">
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
							<td id="div_return">
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
									<td class="btn1" name="btn_DownExcel">Down Excel</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
					</tr>
				</table>
	
			</td>
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