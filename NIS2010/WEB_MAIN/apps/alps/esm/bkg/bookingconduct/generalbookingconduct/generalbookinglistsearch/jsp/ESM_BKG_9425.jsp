<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_9425.jsp
*@FileTitle : Empty REPO BKG Inquiry
*Open Issues :
*Change history : 2015.07.29, YongChan Shin, CHM-201537230, Empty Repo BKG Inquiry 화면 조회옵션 추가
*@LastModifyDate : 2015.07.29
*@LastModifier : YongChan Shin
*@LastVersion : 1.0
* 2015.07.29, YongChan Shin
* 1.0 Creation
* ======================================================
* 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
* 2011.11.24 금병주 [CHM-201114690-01] MTY BKG Inquiry 기능에 G.TTL(TEU 기준) 추가
* 2015.07.29 YongChan Shin [CHM-201537230] Empty Repo BKG Inquiry 화면 조회옵션 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg9425Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg9425Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingListSearch");
	
	String bkgOfcCd  = JSPUtil.getCodeCombo("bkg_ofc_cd","","style='width:80;'class=input1","CD02723",0,"000000: :");

	// TP/SZ select 박스
    String optionStr2 = "000001: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr2);	

    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg9425Event)request.getAttribute("Event");
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
<title>Empty REPO BKG Inquiry</title>
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
<input type="hidden" name="today">
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
					<td width="100"><input type="radio" name="bkg_date_tp" value="B" class="trans"  checked>BKG
										   <input type="radio" name="bkg_date_tp" value="E" class="trans" >ETA</td>
					<td width="230"><input type="text" style="width:80;" class="input1" name="cre_from_dt" value="" style="ime-mode:disabled"  maxlength=10 dataformat="ymd" >&nbsp;~&nbsp;<input type="text" style="width:80;" class="input1" name="cre_to_dt"  value="" maxlength=10 dataformat="ymd" >&nbsp;<img name="btns_Calendar" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="70">RHQ Office</td>
					<td width="100"><%= bkgOfcCd %></td>
					<!-- td width="100">&nbsp;<select style="width:80;"class="input1" name="bkg_ofc_cd">
						<option value="" selected></option>
						<option value="NYCNA">NYCNA</option>
						<option value="HAMUR">HAMUR</option>
						<option value="SHAAS">SHAAS</option>
						<option value="SINWA">SINWA</option>
						</select></td-->
					<td width="30">BKG</td>
					<td width="140"><input type="text" style="width:100;" class="input" value="" name="bkg_no" style="ime-mode:disabled"  dataformat="engupnum" maxlength=13  ></td>
					<td width="30"> B/L</td>
					<td width="120"><input type="text" style="width:95;" class="input" value="" name="bl_no" style="ime-mode:disabled"  dataformat="engupnum" maxlength=13  ></td>
					<td width="30">CNTR</td>
					<td width=""><input type="text" style="width:80;" class="input" value="" name="cntr_no1" style="ime-mode:disabled"  dataformat="engupnum" maxlength=10>&nbsp;<input type="text" style="width:18;" class="input" value="" name="cntr_no2" style="ime-mode:disabled"  dataformat="int" maxlength=1></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="330">
					
						<table class="search_sm2" border="0" style="width:295;"> 
							<tr class="h23">
								<td width="50">&nbsp;VVD CD</td>
								<td width="" class="stm"><input type="text" style="width:80;" class="input" value="" name="vvd_cd" style="ime-mode:disabled"  dataformat="engupnum" maxlength=11>&nbsp;<input type="radio" name="vvd_cd_flg" value="A" class="trans" checked> All&nbsp;&nbsp;<input type="radio" name="vvd_cd_flg" value="E" class="trans"> Excl. Pre/Post</td>
							</tr>
						</table>
					
					</td>
					<td width="25">POL</td>
					<td width="90"><input type="text" style="width:50;" class="input" value="" name="pol_cd" style="ime-mode:disabled"  dataformat="engupnum" maxlength=5></td>
					<td width="25">POD</td>
					<td width="80"><input type="text" style="width:50;" class="input" value="" name="pod_cd" style="ime-mode:disabled"  dataformat="engupnum" maxlength=5></td>
					<td width="25">Pre</td>
					<td width="95"><input type="text" style="width:50;" class="input" value="" name="pre_rly_port_cd" style="ime-mode:disabled"  dataformat="engupnum" maxlength=5></td>
					<td width="30">Post</td>
					<td width="92"><input type="text" style="width:50;" class="input" value="" name="pst_rly_port_cd" style="ime-mode:disabled"  dataformat="engupnum" maxlength=5></td>
					<td width="100">CNTR Attached</td>
					<td width=""><select style="width:60;"class="input" name="cntr_attach">
						<option value="A" selected>All</option>
						<option value="Y">Yes</option>
						<option value="N">No</option>
						</select>
					</td>
					
				</tr>
				</table>

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">

					<td width="85" align="center">BKG Status</td>
					<td width="70">
					    <select style="width:60;"class="input" name="bkg_status">
						<option value="A" selected>All</option>
						<option value="L">VL</option>
						<option value="D">VD</option>
						</select>
					</td>		
                    <td width="68" align="right">TP/SZ</td>
                    <td width="80"><%= cntrTpsz %></td>
                    <td width="">&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 192, 1 )</script></td>
				</tr>
				</table>				
			
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- Grid (E) -->
				<!--  biz_2   (E) -->
				
				<table class="height_2"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="370">
					<!-- /*
					 2011.11.24 g.ttl 필드 추가 후 row를 2줄로 변경 kbj
					*/ -->
						<table class="grid2" border="0" style="width:300;"> 
							<tr>
								<td width="35" class="tr_head3" align="center" rowspan="2"><strong>Total</strong></td>
								<td width="35" class="tr_head3">TEU</td>
								<td width="40" class=""><input type="text" style="width:55;text-align:right" class="noinput" value="" name="sum_teu" readonly></td>	
								<td width="60" class="tr_head3">FEU</td>
								<td width="40" class=""><input type="text" style="width:55;text-align:right" class="noinput" value="" name="sum_feu" readonly></td>	
							</tr>  
							<tr>
								<td width="35" class="tr_head3">BOX</td>
								<td width="40" class=""><input type="text" style="width:55;text-align:right" class="noinput" value="" name="sum_box" readonly></td>	
								<td width="60" class="tr_head3">G.TTL(TEU)</td>
								<td width="40" class=""><input type="text" style="width:55;text-align:right" class="noinput" value="" name="sum_g_ttl" readonly></td>
							</tr> 
						</table>  
					
					</td>
					<td align="right">
						<table class="grid2" border="0" style="width:670;"> 
							<tr class="h23">
								<td width="18" class="tr2_head" align="right">D2</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value=""  name="sum_d2" readonly></td>
								<td width="18" class="tr2_head" align="right">D4</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_d4" readonly></td>
								<td width="18" class="tr2_head" align="right">D5</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_d5" readonly></td>
								<td width="18" class="tr2_head" align="right">D7</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_d7" readonly></td>
								<td width="18" class="tr2_head" align="right">DX</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_dx" readonly></td>
								<td width="18" class="tr2_head" align="right">R2</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_r2" readonly></td>
								<td width="18" class="tr2_head" align="right">R5</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_r5" readonly></td>
								<td width="18" class="tr2_head" align="right">R9</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_r9" readonly></td>
								<td width="18" class="tr2_head" align="right">F2</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_f2" readonly></td>
								<td width="18" class="tr2_head" align="right">F4</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_f4" readonly></td>
							</tr>
							
							<tr class="h23">
								<td width="18" class="tr2_head" align="right">F5</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_f5" readonly></td>
								<td width="18" class="tr2_head" align="right">O2</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_o2" readonly></td>
								<td width="18" class="tr2_head" align="right">O4</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_o4" readonly></td>
								<td width="18" class="tr2_head" align="right">O5</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_o5" readonly></td>
								<td width="18" class="tr2_head" align="right">O7</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_o7" readonly></td>
								<td width="18" class="tr2_head" align="right">A2</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_a2" readonly></td>
								<td width="18" class="tr2_head" align="right">A4</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_a4" readonly></td>
								<td width="18" class="tr2_head" align="right">A5</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_a5" readonly></td>
								<td width="18" class="tr2_head" align="right">S4</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_s2" readonly></td>
								<td width="18" class="tr2_head" align="right">S4</td>
								<td width="32"><input type="text" style="width:32;text-align:right" class="noinput" value="" name="sum_s4" readonly></td>
							</tr>
						</table>									
					</td>
				</tr>
				</table>				
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table class="search" width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr class="h23">
	       	<td class="stm" align="left">* () : No. of GOH</td>
	       	<td class="btn1_bg" align="right">
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cntr">CNTR Info.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_HangerDownExcel">GOH CNTR List</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr></table>
		</td></tr>
		</table>
    <!--Button (E) -->

		</td></tr>
		</table>
<!-- 개발자 작업  끝 -->
</form>
<table id="mainTable">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table>
<table id="mainTable">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table>
</body>
</html>