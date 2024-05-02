<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cgm_2006.jsp
 *@FileTitle : M.G.Set Master Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.28
 *@LastModifier : 조경완
 *@LastVersion : 1.0
 * 2009.06.09 박의수
 * 1.0 Creation
 *--------------------------------------------------
 * History
 * 2012.09.28 [CHM-201220357-01] 2011514 조경완 Disposal Indicator 추가
 * 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2006Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm2006Event event     = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount     = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log       = Logger .getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm2006Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
	
	String eqNo = StringUtil.xssFilter(request.getParameter("eq_no"));
	String boolPopYn = StringUtil.xssFilter(request.getParameter("pop_yn")); // Y/N
	
	if(eqNo == null) eqNo = "";
%>
<html>
<head>
<title>M.G. Set Master Inquiry</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->

<input type="hidden" name="eq_knd_cd" value="G" calss="input1">
<input type="hidden" name="master_save_flag" >
<input type="hidden" name="org_atch_dt" >
<input type="hidden" name="org_atch_yd_cd" >
<input type="hidden" name="org_dtch_dt" >
<input type="hidden" name="org_dtch_yd_cd" >
<input type="hidden" name="yd_cd" >
<input type="hidden" name="pop_yn" value="<%=boolPopYn%>">
                 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		
		
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">M.G. Set No.</td>
					<td width="125"><input type="text" style="ime-mode:disabled;width:100;text-align:center;" class="input1" name="eq_no" value="<%=eqNo %>" maxlength="10" dataformat="engup"></td>
					<td width="35">Type</td>
					<td width="105"><input type="text" name="eq_tpsz_cd" style="width:70;text-align:center;" class="input2" readonly></td>
					<td width="120">Manufactured Date</td>
					<td width="140"><input type="text" name="mft_dt" style="width:80;ime-mode:disabled;text-align:center;" dataformat="ymd" onfocus="domFunFocusDel(this)" class="input" maxlength="8">
                                 <img name="btn_Calendar_a" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                    </td>
					<td width="120">Warranty Date</td>
					<td width=""><input type="text" name="mgst_warr_end_dt" style="width:80;ime-mode:disabled;text-align:center;" dataformat="ymd" onfocus="domFunFocusDel(this)" class="input" maxlength="8">&nbsp;
                                 <img name="btn_Calendar_b" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
                    </td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">Model No.</td>
					<td width="265"><input type="text" name="eq_spec_no" style="width:230;text-align:center;" class="input2" readonly></td>
					<td width="120">Voltage</td>
					<td width="140" class="sm"><input type="text" name="mgst_vltg_capa" style="width:80;text-align:center;" class="input2" readonly>&nbsp;&nbsp;volt</td>
					<td width="120">Fuel Capacity</td>
					<td width="" class="sm"><input name="mgst_fuel_capa" type="text" style="width:80;text-align:center;" class="input2" readonly>&nbsp;&nbsp;ltrs</td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">Machine Serial No.</td>
					<td width="260"><input type="text" style="width:230;text-align:center;" class="input" name="mgst_mchn_ser_no" maxlength="15" dataformat="engup"></td>
					<td>
						<table class="search_sm2" border="0" style="width:570;"> 
						<tr class="h23">
							<td width="121">Current Hours</td>
							<td width="140" class="sm"><input name="mgst_run_hrs" type="text" style="width:80;text-align:right; ime-mode:disabled" class="input" dataformat="int" maxlength="4">&nbsp;&nbsp;hours</td>
							<td width="120">Last Updated Date</td>
							<td width=""><input name="mgst_run_hrs_upd_dt" type="text" style="width:130;text-align:center;" class="input2" readonly></td>
						</tr> 
						</table>
					</td>
				</tr>
				<tr class="h23">
				<td width="90">Tare&nbsp;Weight</td> 
                    <td width="250" class="stm">
                    	<input type="text" style="width:75;text-align:right;" class="input2" name="chss_tare_wgt" readonly>&nbsp;lbs&nbsp;
                    	<input type="text" style="width:75;text-align:right;" class="input2" name="chss_tare_wgt_kgs" readonly>&nbsp;KG
                    </td>
				</tr> 
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">On-Hire Status</td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">Status</td>
					<td width="125"><input type="text" name="aciac_div_cd" style="width:100;text-align:center;color:red;" class="input2" readonly></td>
					<td width="35">Yard</td>
					<td width="105"><input type="text" name="crnt_yd_cd" style="width:70;text-align:center;" class="input2" readonly></td>
					<td width="120">On-hire Date</td>
					<td width="140"><input type="text" name="onh_dt" style="width:80;text-align:center;" class="input2" readonly></td>
					<td width="120">On-hire Office</td>
					<td width=""><input type="text" name="onh_ofc_cd" style="width:80;text-align:center;" class="input2" readonly></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">Agreement No.</td>
					<td width="125"><input type="text" name="agreement_no" style="width:100;text-align:center;" class="input2" readonly></td>
					<td width="35">Term</td>
					<td width="105"><input type="text" name="agmt_lstm_cd" style="width:70;text-align:center;color:blue;" class="input2" readonly></td>
					<td width="120">Lessor</td>
					<td width=""><input type="text" name="vndr_lgl_eng_nm" style="width:340;" class="input2" readonly></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="112">Reference No.</td>
					<td width="260"><input type="text" name="agmt_ref_no" style="width:100;text-align:center;" class="input2" readonly></td>
					<td width="">
						<table border="0" style="width:600;" class="search_sm2">
					 	<tr class="h23">
							<td width="170"><input type="checkbox" value="" class="trans" name="cntr_chk"> CNTR&nbsp;&nbsp;
							<input type="text" name="atch_cntr" style="width:90;text-align:center;" class="input2" readonly></td>
							<td width="190"><input type="checkbox" value="" class="trans" name="chs_chk"> Chassis&nbsp;&nbsp;
							<input type="text" name="atch_chs" style="width:90;text-align:center;" class="input2" readonly></td>
							<td width="70"><input type="checkbox" value="" class="trans" name="bare_chk"> Bare </td>
							<td width=""><input type="checkbox" value="" class="trans" name="damage_chk"> Damage </td>
							<td width=""><input type="checkbox" value="" class="trans" name="disposal_chk"> Disposal </td>
						</tr>
						</table>
					</td>
				</tr> 
				</table>
				
			
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					<td width="110">Created Date</td>
					<td width="95"><input type="text" name="cre_dt" style="width:80;text-align:center;" class="input2" readonly></td>
					<td width="15" class="stm">By</td>
					<td width="157"><input type="text" name="cre_usr_id" style="width:100;text-align:center;" class="input2" readonly></td>
					<td width="90">Updated Date</td>
					<td width="95"><input type="text" name="upd_dt" style="width:80;text-align:center;" class="input2" readonly></td>
					<td width="15" class="stm">By</td>
					<td width=""><input type="text" name="upd_usr_id" style="width:100;text-align:center;" class="input2" readonly></td>
					</tr> 
				</table>
			
	</td>
	</tr> 
	</table>			
	<table class="height_8">
			<tr>
				<td colspan="8"></td>
			</tr>
		</table>			
	<table class="search"> 
       	<tr><td class="bg">			
				
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">M.G.Set Attach/Detach History</td></tr>
				</table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<!-- Grid (E) -->
<!--  Button_Sub (S) -->
                <table width="100%" class="button">
                    <tr>
                        <td class="btn2_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btn_delgrid">Row Delete</td>
                                        <td class="btn2_right"></td>
                                    </tr>
                                </table>
                                </td>
                            </tr>
                        </table>
                        </td>
                    </tr>
                </table>
                <!-- Button_Sub (E) -->
			</td>
			</tr>
		</table>
			
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve"  id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_chssmvmt">CHSS MVMT</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_status">Status</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_mnr">M&R</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>



<div style="display:none;">
	<!-- Grid  (S) -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table>
	<!-- Grid  (E) -->
</div>

<!-- 개발자 작업  끝 -->
		
</form>
</body>
</html>
