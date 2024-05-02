<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0930.jsp
*@FileTitle : ESM_BKG_0930
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.11
*@LastModifier : 계기훈
*@LastVersion : 1.1
* 2009.07.10 김승민
* 1.0 Creation
* 2012.01.30 박성호[CHM-201215846] BKG CLL 수신 ID 추가 건 ( KRINCYG, KRKIMYG)
* 2012.02.06 박성호[CHM-201215846] BKG CLL 수신 ID 추가 건 ( KRINCYG, KRKIMYG)
* 2015.10.16 [CHM-201538422] 선광신컨테이너 터미널 이용관련 EDI 문서 송수신 위한 APLS 셋팅 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0930Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0930Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0930Event)request.getAttribute("Event");
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
<title>ESM_BKG_0930</title>
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
<input type="hidden" name="in_cll_type">
<input type="hidden" name="in_bkg_sts_cd">
<input type="hidden" name="in_cntr_cfm_flg">
<input type="hidden" name="in_final_edi_flg" value="N">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
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
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="670">
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
							<td width="30">&nbsp;&nbsp;VVD</td>
							<td width="120"><input type="text" style="width:80;text-align:center" class="input1" dataformat="uppernum" maxlength="9" value="" name="in_vvd_cd" style="ime-mode:disabled"></td>
							<td width="30">POL</td>
							<td width="110"><input type="text" style="width:50;text-align:center" class="input1" dataformat="upper" maxlength="5" value="" name="in_pol_cd" style="ime-mode:disabled">&nbsp;<input type="text" style="width:30;text-align:center" class="input" dataformat="uppernum" value="" maxlength="2" name="in_pol_yd_cd" style="ime-mode:disabled"></td>
							<td width="304">
									<table class="search_sm2" border="0" style="width:300"> 
									<tr class="h23">
									  <td>TYPE</td>
									  <td class="stm"><input type="radio" value="" class="trans" name="in_cll_type_tmp" checked>&nbsp;CLL&nbsp;&nbsp;<input type="radio" value="" class="trans" name="in_cll_type_tmp">&nbsp;LOCAL&nbsp;&nbsp;<input type="radio" value="" class="trans" name="in_cll_type_tmp">&nbsp;T/S<input type="radio" value="" class="trans" name="in_cll_type_tmp">&nbsp;&nbsp;EMPTY</td>
									</tr>
									</table>
							</td>
							
							</tr>
						</table>
				<table class="search" border="0" style="width:100%;;"> 
				   <tr class="h23">
					<td width="304">
						<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
							<td width="80">BKG Status</td>
					    	  <td width="" class="stm"><input type="radio" value="" class="trans" name="in_bkg_sts_cd_tmp" checked>&nbsp;ALL&nbsp;&nbsp;<input type="radio" value="" class="trans" name="in_bkg_sts_cd_tmp">&nbsp;Firm<input type="radio" value="" class="trans" name="in_bkg_sts_cd_tmp">&nbsp;&nbsp;Waiting</td>
							  </td>
							  </tr>
						</table>
					 </td>
					 <td width="35"> </td>
					 <td width="350">
						<table class="search_sm2" border="0" style="width:300;"> 
							<tr class="h23">
							<td width="120">Container Confirm</td>
							<td width="" class="stm"><input type="radio" value="" class="trans" name="in_cntr_cfm_flg_tmp" checked>&nbsp;ALL&nbsp;&nbsp;<input type="radio" value="" class="trans" name="in_cntr_cfm_flg_tmp">&nbsp;Yes<input type="radio" value="" class="trans" name="in_cntr_cfm_flg_tmp">&nbsp;&nbsp;No</td>
							  </td>
							</tr>
							
						</table>
					</td>
					</tr>
					</table>
					</td>
					<td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
							<td width="80">Receiver</td>
							<td width="100" style="padding-left:2"><select style="width:90;" class="input" name="in_rcv_id">
							<option value="">--select--</option>
							<option value="BCTOC071">HBCT</option>
							<option value="UTCOC010">UTC</option>
							<option value="PECTC010">PECT</option>
							<option value="HJKCC010">KCT</option>
							<option value="BICTC010">SBTC</option>
							<option value="GICTC010">HSGT</option>
							<option value="KEKMC050">KEKMC</option>
							<option value="KEKYC010">KEKYC</option>
							<option value="HDKMC010">HDKMC</option>
							<option value="HDKYC010">HDKYC</option>
							<option value="ICTPC050">ICT</option>
							<option value="DPCTC010">DPCTC010</option>
							<option value="KITKC071">KITKC071</option>
							<option value="DKCTC010">DKCTC010</option>
							<option value="PCCTC050">PCCTC050</option>
							<option value="HJTST100">HJTST100</option>
							<option value="HJTST200">HJTST200</option>
							<option value="PNCOC010">PNCOC010</option>
							<option value="SICTC030">SICT</option>
							<option value="PCTCC030">PCTCC030</option>
							<option value="DBFCC011">DBFCC011</option>
							<option value="HJNPC010">HJNPC010</option>
							<option value="KJTCC050">KJTCC050</option>
							<option value="E1CTC010">E1CTC010</option>
							<option value="UDITC010">UDITC010</option>
							<option value="HPNTC010">HPNTC</option>
							<option value="JUCTC050">JUCTC</option>
							<option value="PNITC010">PNIT</option>
							<option value="BNCTC010">KRPUSBN</option>
							<option value="HJGIC010">KRGINYG</option>
							<option value="HJKPC010">KRGINKT</option>
							<option value="SNCTC030">SNCT</option>
							<option value="TEST1212">TEST1212</option>
							<option value="HJITC010">KRINCHN</option>
							<option value="KEGWC050">KEGWC050</option>
							</select></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_EDISend">EDI Send</td>
						<td class="btn2_right"></td></tr>
						</table></td>
							</tr>
							<tr class="h23">
								<td width="">T/VSL Code</td>
								<td width="" style="padding-left:2"><input type="text" style="width:90;text-align:center" class="input" dataformat="uppernum" maxlength="6" value="" name="in_ktml_cd" style="ime-mode:disabled"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_finalEDISend">Final EDI Send</td>
										<td class="btn2_right"></td>
									</tr>
								</table></td>
							</tr>
							<tr class="h23">
								<td width="">Final EDI Date</td>
								<td width="" style="padding-left:2" colspan="2"><input type="text" style="width:120;text-align:center" class="input2" dataformat="uppernum" maxlength="10" value="" name="in_max_edi_snd_dt" style="ime-mode:disabled" readonly="true"></td>
							</tr>
						</table>
					</td>
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
				<!--  Button_Sub (S) -->
				
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="">Update</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td-->
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_CopyTsPodMlbDel">Copy TS/POD/MLB/YD</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><select style="width:72;" class="input" name="in_sort_type" onChange="goSearch();">
							<option value="" selected>Sort</option>
							<option value="1">POD</option>
							<option value="2">A.POD</option>
							<option value="3">VVD</option>
							<option value="4">MLB</option>
							<option value="5">TYPE</option>
							<option value="6">CNTR</option>
							<option value="7">WEIGHT</option>
							</select></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
			<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!--  biz_2 (S) -->
			<table width="100%" class="grid2" id="mainTable"> 
			<tr>
				<td class="tr2_head2" width="35">D2	</td>
				<td width="30"><input type="text" name="d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D4	</td>
				<td width="30"><input type="text" name="d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D5</td>
				<td width="30"><input type="text" name="d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D7	</td>
				<td width="30"><input type="text" name="d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D8</td>
				<td width="30"><input type="text" name="d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D9	</td>
				<td width="30"><input type="text" name="d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DW	</td>
				<td width="30"><input type="text" name="dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DX	</td>
				<td width="30"><input type="text" name="dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R2	</td>
				<td width="30"><input type="text" name="r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R4</td>
				<td width="30"><input type="text" name="r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R5	</td>
				<td width="30"><input type="text" name="r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F2	</td>
				<td width="30"><input type="text" name="f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F4	</td>
				<td width="30"><input type="text" name="f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F5	</td>
				<td width="30"><input type="text" name="f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			<tr>
				<td class="tr2_head2">O2	</td>
				<td><input type="text" name="o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O4		</td>
				<td><input type="text" name="o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O5		</td>
				<td><input type="text" name="o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O7		</td>
				<td><input type="text" name="o7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S2	</td>
				<td><input type="text" name="s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S4		</td>
				<td><input type="text" name="s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T2</td>
				<td><input type="text" name="t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T4		</td>
				<td><input type="text" name="t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A2	</td>
				<td><input type="text" name="a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A4		</td>
				<td><input type="text" name="a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A5		</td>
				<td><input type="text" name="a5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P2	</td>
				<td><input type="text" name="p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P4	</td>
				<td><input type="text" name="p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">Z2	</td>
				<td><input type="text" name="z2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
		
				</tr>
			<tr>
				<td class="tr2_head2">Z4	</td>
				<td><input type="text" name="z4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">D3	</td>
				<td><input type="text" name="d3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">R9	</td>
				<td><input type="text" name="r9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" style="font-size:8">ETC		</td>
				<td><input type="text" name="etc" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td class="tr2_head2" colspan="2"><b>Total</b>	</td>
				<td  colspan="2"><input type="text" name="totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			</table>
		<table width="" class="grid2" id="mainTable"> 
		 	<tr>
				<td class="tr2_head" width="37">Local		</td>
				<td width="32"><input type="text" name="local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full	</td>
				<td width="30"><input type="text" name="localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">T/S		</td>
				<td width="30"><input type="text" name="ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full			</td>
				<td width="30"><input type="text" name="tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">WGT					</td>
				<td width="40"><input type="text" name="wgt" value="" size="10" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
		</table>
		<!--  biz_2  (E) -->
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
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
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
					<td class="btn1" name="btn_PrintPreview">Print Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Summary">Summary</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Special_CGO">Special CGO</td>
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
</form>
</body>
</html>