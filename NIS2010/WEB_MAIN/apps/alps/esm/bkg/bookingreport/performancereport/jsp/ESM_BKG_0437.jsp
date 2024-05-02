<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0437.jsp
	 *@FileTitle : Queue List
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 * 2013.11.06 [CHM-201327291][SZP DPCS] 라이브 적용일자 및 시스템 개선사항 요청
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0437Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0437Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String mrdSaveDialogDir = "";
	
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
	mrdSaveDialogDir = strTemp1 + strTemp2;
		
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0437Event) request.getAttribute("Event");
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
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdBodyTitle" value="e-Booking &amp; SI Preview">
<input type="hidden" name="com_zoomIn" value="3">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=mrdSaveDialogDir%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_zoomIn">

	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="ch_usr_id">
	<input type="hidden" name="curr_page" value="1">
	<input type="hidden" name="rows_per_page" value="50">
	<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
	<input type="hidden" name="tmp_dura_from_dt">
	<input type="hidden" name="tmp_dura_to_dt">
	<input type="hidden" name="grp_cd">
	<input type="hidden" name="dpcs_ofc_cd" value="SZPSC">

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

			<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="22"><input type="radio" class="trans" name="chk_key" value="DT" checked></td>
                        <td style="padding-left:2px;">
	                        <table border="0">
		                		<tr class="h23">
		                  			<td width="50">Period </td>
		                  			<td style="background-color: #E9E9E9; border:1px solid #A3A4C7; padding:2px 8px 2px 2px;">
			                        	<select style="width:60;" class="input1" name="prd_flg">
											<option value="T" selected>TRNS</option>
											<option value="W">UPDT</option>
										</select>
										<input type="text" style="width:70" maxlength="10" dataformat="ymd" name="dura_from_dt" value="<%= DateTime.addDays(JSPUtil.getKST("yyyy-MM-dd"),-1,"yyyy-MM-dd") %>" class="input1">&nbsp;~&nbsp;
										<input type="text" style="width:70"  maxlength="10" dataformat="ymd" name="dura_to_dt" value="<%=JSPUtil.getKST("yyyy-MM-dd") %>" class="input1">
										<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_dura_date">
									</td>
								</tr>
							</table>
                        </td>
                        <td width="30">Input</td>
                        <td width="45"><script language="javascript">ComComboObject("input",1,45,1,0,1);</script></td>
                        <td width="30">Rate</td>
                        <td width="45"><script language="javascript">ComComboObject("rate",1,45,1,0,1);</script></td>
                        <td width="20">QA</td>
                        <td width="45"><script language="javascript">ComComboObject("qa",1,45,1,0,1);</script></td>
                        <td width="55">BL Proof</td>
                        <td width="45"><script language="javascript">ComComboObject("fax",1,45,1,0,1);</script></td>
                        <td width="50">SI Kind</td>
						<td width="80">
							<script language="javascript">ComComboObject("sr_amd_tp_cd",1,80,1,0,1);</script>
						</td>
                        <!--<td width="25">RGN</td>
                        <td width="80"><script language="javascript">ComComboObject("region",2,80,1,0,1);</script></td>-->
                        <td width="25">STS</td>
                        <td width="80"><script language="javascript">ComComboObject("sts",2,80,1,0,1);</script></td>
                        <td width="25">SRC</td>
                        <td width=""><script language="javascript">ComComboObject("src_cd",2,60,1,0,1);</script></td>
                        
                    </tr>
                </table>
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                    
                        <td width="22"><input type="radio" class="trans" name="chk_key" value="VVD"></td>
                         <td width="50">VVD</td>
                        <td width="90"><input type="text" style="width:80;ime-mode:disabled" value="" name="vvd_cd" maxlength="9" fullfill dataformat="engupnum" class="input" caption="VVD"></td>
                        	<td width="30">POL</td>
                        <td width="70"><input type="text" style="width:60;ime-mode:disabled" value="" name="pol_cd" maxlength="5" dataformat="engupnum" class="input" caption="POL"></td>
                        <td width="30">POD</td>
                        <td width="70"><input type="text" style="width:60;ime-mode:disabled" value="" name="pod_cd" maxlength="5" dataformat="engupnum" class="input"></td>
                        
                        <!--<td width="50">SI Kind</td>
						<td width="90">
							<script language="javascript">ComComboObject("sr_amd_tp_cd",1,80,1,0,1);</script>
						</td>-->	
                        <td width="30">Lane</td>
                        <td width="78"><script language="javascript">ComComboObject("slan_cd",2,70,0,0,0);</script></td>
                        
                        
                        <td width="60">BKG OFC</td>
                        <td width="68"><input type="text" style="width:60;ime-mode:disabled" value=""  name="bkg_ofc_cd" maxlength="6" dataformat="engup" class="input"></td>
                        
                        <td width="70">RTN OFC</td>
                        <td width=""><input type="text" style="width:60;ime-mode:disabled" value=""  name="return_to" maxlength="6" dataformat="engup" class="input"></td>
                        <td>SPLIT BKG&nbsp;<input type="checkbox" value="Y" name="split_only_flg" class="trans" tabindex="6"></td>
                        <td width="">Set Search&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name="btn_SRCH_SET" align="absmiddle">&nbsp;<input type="checkbox" value="Y" name="set_slct_flg" class="trans" tabindex="6"></td>
                    </tr>
                </table>
                <table class="search" border="0" style="width: 979;"> 
				<tr class="h23">
					<td width="22"><input type="radio" class="trans" name="chk_key" value="BKG"></td>
					<td width="50">BKG No.</td>
                    <td width="110"><input type="text" style="width:100;ime-mode:disabled" value="" name="bkg_no" maxlength="13" dataformat="engupnum" class="input" caption="BKG NO"></td>
                        
					<td width="68">Customer</td>
					<td width="270">
						<script language="javascript">ComComboObject("bkg_cust_tp_cd",1,50,1,0,1);</script> 
						<input type="text" style="width: 25;" class="input" dataformat="engup" maxlength="2" name="cust_cnt_cd" value="" tabindex="41">
						<input type="text" style="width: 55;" class="input" dataformat="int" maxlength="6" name="cust_seq" value=""  tabindex="42">
						<input type="text" style="width: 120;" class="input" dataformat="etc" maxlength="500" name="cust_nm" value="" tabindex="43"></td>
					<td width="60">Contract</td>
						<td width="50"><script language="javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 50, 0, 0, 0, false);</script></td>
						<td width="95"><input type="text" name="contract_no" style="width:85;text-align:center;ime-mode:disabled" value="" caption="Contract No" dataformat="uppernum" maxLength="12"></td>
						
					<td width="60">Sales Rep</td>
					<td width="70">
						<input type="text" style="width:60;ime-mode:disabled" value="" name="srep_cd" maxlength="6" dataformat="engupnum" class="input">
					</td>
					<!--<td width="">Set Search&nbsp;<img class="cursor" src="img/btns_search.gif" width="49" height="20" border="0" name="btn_SRCH_SET" align="absmiddle">&nbsp;<input type="checkbox" value="Y" name="set_slct_flg" class="trans" tabindex="6"></td>-->
					<td width="25">PIC</td>
					<td width="80">
						<input type="text" style="width:80;ime-mode:disabled" value="" name="pic_id" maxlength="20" class="input">
					</td>
					
					<td width=""></td>
				</tr>	
				</table>
                <!--  biz_1   (E) -->
			</td></tr></table>

		    <table class="height_8"><tr><td></td></tr></table>

   			<table class="search"><tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" class="search" id="mainTable">
					<tr><td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td></tr>
				</table>
				<!-- Grid (E) -->
				
				<table class="height_2"><tr><td></td></tr></table>
				<!--  biz_3 (S) -->
                <table align="left" width="100%" cellspacing="15" cellpadding="5" border="0">
                    <tr>
                        <td width="150" valign="top">
                            <table width="100%" border="0" style="background-color:white;" class="grid2"> 
                                <tr><td class="tr_head2" width="80" align="left"> TTL BKG </td>
                                    <td class="input2" align="right" id="total_bkg"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> TTL Queue </td>
                                    <td class="input2" align="right" id="total_sr"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> Return to Cust.</td>
                                    <td class="input2" align="right" id="total_rtn_cust"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> Return to FO </td>
                                    <td class="input2" align="right" id="total_rtn_fo"></td>
                                </tr>                                
                                <tr><td class="tr_head2" width="80" align="left"> Rtn to Rtn</td>
                                    <td class="input2" align="right" id="total_rtn"></td>
                                </tr>
                            </table>
                        </td>
                        <td width="150" valign="top">
                            <table width="100%" border="0" style="background-color:white;" class="grid2"> 
                                <tr><td class="tr_head2" width="80" align="left"> Input : Y </td>
                                    <td class="input2" align="right" id="total_input"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> Rate : Y </td>
                                    <td class="input2" align="right" id="total_rate"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> QA : Y </td>
                                    <td class="input2" align="right" id="total_qa"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> B/L Proof : Y </td>
                                    <td class="input2" align="right" id="total_fax"></td>
                                </tr>
                            </table>
                        </td>
                        <td width="150" valign="top">
                            <table width="100%" border="0" style="background-color:white;" class="grid2"> 
                                <tr><td class="tr_head2" width="80" align="left"> Pending </td>
                                    <td class="input2" align="right" id="total_pending"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> Working </td>
                                    <td class="input2" align="right" id="total_working"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> Canceled </td>
                                    <td class="input2" align="right" id="total_canceled"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> Completed </td>
                                    <td class="input2" align="right" id="total_completed"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> N/A </td>
                                    <td class="input2" align="right" id="total_na"></td>
                                </tr>
                            </table>
                        </td>
                        <td width="150" valign="top">
                            <table width="100%" border="0" style="background-color:white;" class="grid2">
                            	<tr><td class="tr_head2" width="80" align="left"> Doc. Cut Off - 1 Day Over </td>
                                    <td class="input2" align="right" id="total_cutoff"></td>
                                </tr> 
                                <tr><td class="tr_head2" width="80" align="left"> Today BDR </td>
                                    <td class="input2" align="right" id="total_bdr"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> Today PCT </td>
                                    <td class="input2" align="right" id="total_pct"></td>
                                </tr>
                            </table>
                        </td>
                        <td width="150" valign="top">
                            <table width="100%" border="0" style="background-color:white;" class="grid2"> 
                                <tr><td class="tr_head2" width="80" align="left"> Urgent </td>
                                    <td class="input2" align="right" id="total_urgent"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> VIP </td>
                                    <td class="input2" align="right" id="total_vip"></td>
                                </tr>
                                <tr><td class="tr_head2" width="80" align="left"> Normal </td>
                                    <td class="input2" align="right" id="total_normal"></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
					<!--  biz_3   (E) -->	
			</td></tr></table>
		</td>
	</tr>
</table>

<!--Button (S) -->
<table width="1024" class="button" border="0" cellpadding="0"
	cellspacing="0" style="padding-top: 5; ">
	<tr>		
		<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td> </td>
					<td class="btn1_line"></td>
					<td>
					<table id="div_Delete" width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Delete">Delete</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
                     <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                         <tr><td class="btn1_left"></td>
                         <td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
                         <td class="btn1_right"></td>
                         </tr>
                     </table></td>
					<td><table id="div_Split"  border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Split" id="btn_Split">Check&nbsp;Split&nbsp;Detail</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td id="div_pic"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_pic">PIC&nbsp;Assign</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td id="div_pic"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_stsc">STS&nbsp;Change</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td id="div_pic"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_corr">Correction&nbsp;Change</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_detail">Go to Queue Detail(s)</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
			</table>
      		</td>
	</tr>
</table>
<!--Button (E) --> 
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		<script language="javascript">ComSheetObject("sheet2");</script>
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
<form name="form2" method="POST">
	<input type="hidden" name="message"> 
</form>	
</body>
</html>