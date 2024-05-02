<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0041.jsp
*@FileTitle : Ams Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.28
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.08.24 김도완
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.07.06 민정호 [CHM-201111866] US AMS : AMS Report 의 general의 조회 기능 보완
* 2011.09.28 민정호 [CHM-201113378] AMS Report에 조회 옵션 추가
* 2011.10.13 김봉균 [CHM-201112452-01] 미세관 RECEIVE 데이터 중 CUSRES 반영 요청
* 2011.11.15 민정호 [CHM-201114280] AMS Report 조회 기능 변경
* 2012.04.09 김봉균 [CHM-201216602-01] Rail AMS 수신시 hold / hold release 관련 보완 (ACE 관련)
* 2013.02.26 김보배 [CHM-201323166] [BKG] AMS Report 보완 요청
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
    String sOffice = "Origin";
    if ("ESM_BKG_0041_01".equals(request.getParameter("pgmNo"))) {
    	sOffice = "US";
    }

    //BAPLIE(ESM_BKG_1023)화면에서 Go to AMS Report 버튼 클릭이벤트 발생시
	String vvdCd = "";
	String polCd = "";
	String podCd = "";    
	String strLastPol = JSPUtil.getParameter(request, "lastPol");
	String strEventFrom = JSPUtil.getParameter(request, "eventFrom");
	if(strLastPol == null) {
		strLastPol = "";
	}
	if(strEventFrom == null) {
		strEventFrom = "";
	}
	
	vvdCd  = JSPUtil.getParameter(request, "vvd");
	if ("".equals(vvdCd) ) vvdCd  = JSPUtil.getParameter(request, "vvd_cd");

	polCd  = JSPUtil.getParameter(request, "pol_cd");
	podCd  = JSPUtil.getParameter(request, "pod_cd");
	
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pgm_no" value="ESM_BKG_0041">
<input type="hidden" name="h_vvd" value="">
<input type="hidden" name="retrieve_remains" value="">
<input type="hidden" name="retrieve_remains_for_report" value="">
<input type="hidden" name="office" value="<%=sOffice%>">
<input type="hidden" name="pol" value="<%=polCd%>">
<input type="hidden" name="pod" value="<%=podCd%>">
<input type="hidden" name="hub" value="">
<input type="hidden" name="del" value="">
<input type="hidden" name="hid_vvd" value="<%=vvdCd%>">
<input type="hidden" name="hid_last_pol" value="<%=strLastPol %>">
<input type="hidden" name="event_from" value="<%=strEventFrom %>">
<input type="hidden" name="search_discrepancy" value="N">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>

<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="660" valign="top">

						<table border="0"> 
					      	<tr class="h23">
					      		<td width="30">VVD</td>
								<td width="110"><input type="text" name="vvd" style="width:100;" class="input1" dataformat="eng" maxlength="9" required value="<%=vvdCd%>"></td>
								<td>
									<div id="lastPol" style="display:none;">
									<table border="0" style="width:150;">
									<tr class="h23">
										<td width="80">Last Foreign POL</td>
										<td width="70"><input type="text" name="last_pol" style="width:60;" class="input1" dataformat="eng" maxlength="5" required></td>
									</tr>
									</table>
									</div>
									<div id="general" style="position:absolute;left:335px;top:41px;">
									<table class="search" border="0" style="width:350;">
									<tr class="h23">
										<td width="35">POL</td>
										<td width="75"><input type="text" name="pol1" style="width:60;" class="input1" dataformat="eng" maxlength="5" required  value="<%=polCd%>"></td> 
										<td width="35">POD</td>
										<td width="75"><input type="text" name="pod1" style="width:60;" class="input1" dataformat="eng" maxlength="5" required  value="<%=podCd%>"></td> 
										<td width="85">HUB Location</td>
										<td width=""><input type="text" name="hub1" style="width:63;" class="input" dataformat="eng" maxlength="5"></td>
										<td width="35">DEL</td>
										<td width="75"><input type="text" name="del1" style="width:60;" class="input1" dataformat="eng" maxlength="5" required></td>
									</tr>
									</table>
									</div>
									<div id="general_1" style="display:none;">
									<table class="search" border="0" style="width:470;">
									<tr class="h23">
										<td width="35">POL</td>
										<td width="75"><input type="text" name="pol2" style="width:60;" class="input1" dataformat="eng" maxlength="5" required  value="<%=polCd%>"></td> 
										<td width="35">POD</td>
										<td width="75"><input type="text" name="pod2" style="width:60;" class="input1" dataformat="eng" maxlength="5" required  value="<%=podCd%>"></td>
										<td width="85">HUB Location</td>
										<td width="90"><input type="text" name="hub2" style="width:63;" class="input" dataformat="eng" maxlength="5"></td>
										<td width="35">DEL</td>
										<td width="75"><input type="text" name="del2" style="width:60;" class="input1" dataformat="eng" maxlength="5" required></td>
										<td width="30">RHQ</td>
										<td width="90">
											<script language="javascript">ComComboObject('rhq', 1, 70, 0,0,1);</script>
										</td>																				 										
									</tr>
									</table>
									</div>									
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="100">EQ Control OFC</td>
								<td width="70"><script language="javascript">ComComboObject('eq_ofc', 1, 60, 0, 0);</script></td>
								<td width="40">B/STF</td>
								<td width="80"><input type="text" name="b_stf" style="width:60;" class="input" dataformat="eng" maxlength="10"></td> 
								<td width="45">L/Rep.</td>
								<td width="70"><input type="text" name="l_rep" style="width:60;" class="input" dataformat="eng" maxlength="5"></td>
								<td width="63">R/D Term</td>
								<td width=""><script language="javascript">ComComboObject('rcv_term_cd', 2, 85, 0, 0);</script>&nbsp;
									<script language="javascript">ComComboObject('de_term_cd', 2, 85, 1, 0);</script></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="61">P/MIB TP</td>
								<td width="115">
								<select name="pmib_tp" style="width:110;">
								<option value="0"></option>
								<option value="61" >61</option>
								<option value="62">62</option>
								<option value="63">63</option>
								<option value="LC">Local Cargo</option>
								<option value="IP">IPI</option>
								<option value="L">Local clearance</option>
								<option value="I">P/MIB</option>
								</select></td>
								<td width="24">Filer</td>
								<td width="210">&nbsp;<script language="javascript">ComComboObject('filer', 2, 200, 1, 0);</script>
								</td>
								<td width="135">Customs Result Code</td>
								<td width=""><script language="javascript">ComComboObject('customs_result_code_grp', 2, 60, 0, 0);</script>
									&nbsp;<script language="javascript">ComComboObject('customs_result_code', 2, 49, 0, 0);</script>
								</td>
							</tr>
						</table>

						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="65">M.B/L No.</td>
								<td width="106"><input type="text" name="mbl_no" style="width:95;" class="input" dataformat="eng" fullfill="fullfill" maxlength="12" caption="M.B/L No."
									value="<%=(request.getParameter("bl_no")==null) ? "" : request.getParameter("bl_no")%>"></td> 
								<td width="106">Manifest File No.</td>
								<td width="120"><input type="text" name="ams_file_no" style="width:95;" class="input" dataformat="eng" maxlength="12"></td> 
								<td width="25"><input type="checkbox" name="excl_rls" class="trans" value="1"></td>
								<td width="50">
									Excl.Rls
								</td>
								<td width="25">
									<input type="checkbox" name="cntr_prt_flg" class="trans" value="1">
								</td>
								<td width="50">
									Partial
								</td>
								<td width="25">
									<input type="checkbox" name="final_flg" class="trans" value="1">
								</td>
								<td width="*">
									Final
								</td>								
							</tr>
						</table>
						<div id="railAms" style="display:none;">
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="65">Customer code</td>
								<td width="91"><input type="text" name="customer_cd" style="width:80;" class="input" dataformat="eng" maxlength="8"></td> 
								<td width="100">S/C No.</td>
								<td width="100"><input type="text" name="sc_no" style="width:92;" class="input" dataformat="eng" maxlength="9"></td> 
								<td width="130">CNTR TYPE</td>
								<td width="40"><input type="text" name="cntr_tp" style="width:30;" class="input" dataformat="eng" maxlength="2"></td> 
								<td width="105">CNTR No.</td>
								<td width="106"><input type="text" name="cntr_no" style="width:95;" class="input" dataformat="eng" maxlength="11"></td> 
								<td width="61">R.Billing Y/N</td>
								<td width="109">
								<select name="rbilling_yn" style="width:35;" >
									<option value=""></option>
									<option value="Y">Y</option>
									<option value="N">N</option>
								</select></td>						
							</tr>
						</table>
						</div>
					</td>
					<td width="300" valign="top">
						<table class="search" border="0" style="width:;">
							<tr class="h23">
								<td>
									<table id="changeTbl" class="grid2" border="0" style="width:100%;">
							      	<tr class="h23">
										<td id="useDateCond" width="%" rowspan="2" valign="top"><input type="checkbox" name="date_search" class="trans"></td>
										<td width="45%" class="tr2_head">
											<input type="radio" name="cust_arr_exp" value="SND" class="trans">&nbsp;Send Date&nbsp;&nbsp;&nbsp;</td>
										<td width="45%" class="tr2_head">
											<input type="radio" name="cust_arr_exp" value="RCV" class="trans">&nbsp;Receive Date</td>
									</tr>
									<tr class="h23">
										<td width="45%" class="tr2_head">
											<input type="radio" name="cust_arr_exp" value="ARR" class="trans" checked="checked">&nbsp;Arrival Date</td>
										<td width="45%" class="tr2_head"><input type="radio" name="cust_arr_exp" value="EXP" class="trans">&nbsp;Export Date&nbsp;&nbsp;</td>
									</tr>
									<tr class="h23">
										<td colspan="3">
											<input type="text" style="width: 75; ime-mode: disabled" class="input2"
												dataformat="ymd" name="fromd" caption="Sent Date" cofield="tod" maxlength="10">
											<input type="text" name="fromt" style="width:45" value="00:00" class="input2" dataformat="hm" maxlength="5">
											~
											<input type="text" style="width: 75; ime-mode: disabled" class="input2"
													dataformat="ymd" name="tod" caption="Sent Date" cofield="fromd" maxlength="10">
											<input type="text" name="tot" style="width:45" value="23:59" class="input2" dataformat="hm" maxlength="5">
											<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor" name="btn_calendar">
										</td>
							        </tr>
						      		</table>
								</td>
							</tr>
						</table>
						<table>
						<tr class="h23" id="contractType" style="display:none;">					
							<td width="90">Contract Type</td>
							<td width="54">
								<select name="contract_type" style="width:50;">
									<option value=""></option>
									<option value="SC" >SC</option>
									<option value="RFA">RFA</option>
									<option value="TAA">TAA</option>
								</select>
							</td>
							<td width="66">Error Status</td>
							<td width="98">
								<select name="err_type" style="width:98;">
									<option value=""></option>
									<option value="N">Not-Received</option>
									<option value="U">Un-Sent B/L</option>
								</select>
							</td>							
					    </tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
		
<table width="100%" class="button" border="0"> 
	<tr>
		<td class="btn2_bg">
        	<table border="0" cellpadding="0" cellspacing="0">
                <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BLInquiry">B/L Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_InquiryByCntr">B/L Inquiry by CNTR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BlCharge">B/L Charge</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td width="50%">
			<script language="javascript">ComTabObject('tab1')</script>
		</td>
	</tr>
</table>
				
<div id="tabLayer" style="display:inline">
<table class="search"> 
      	<tr>
      		<td class="bg">
			<table width="100%"  id="mainTable">
				<TR>
					<TD align="right">
						<div style="font-size:12px;font-family: dotum">[ B/L Count : <span id="bl_cnt"></span>]</div> 
					</TD>
				</TR>
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
<div id="tabLayer" style="display:none">
<table class="search">
      	<tr>
      		<td class="bg">
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
<div id="tabLayer" style="display:none">
<table class="search">
      	<tr>
      		<td class="bg">
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="85">Manifest TTL </td>
					<td width="60"><input type="text" name="manifest" style="width:50; text-align:center" class="input" readonly="readonly"></td>
					<td width="40" align="center">=</td>
					<td width="90">Accepted </td>
					<td width="60"><input type="text" name="accepted" style="width:50; text-align:center" class="input" readonly="readonly"></td> 
					<td width="40" align="center">+</td>
					<td width="60">Rejected</td>
					<td width="60"><input type="text" name="rejected" style="width:50; text-align:center" class="input" readonly="readonly"></td> 
					<td width="40" align="center">+</td>
					<td width="40">N/A</td>
					<td width="60"><input type="text" name="none" style="width:50; text-align:center" class="input" readonly="readonly"></td> 
					<td width="">&nbsp;</td>
				</tr>
				<tr class="h23">
					<td>Target  TTL </td>
					<td><input type="text" name="target" style="width:50; text-align:center; text-color:red" class="input2" readonly="readonly"></td>
					<td></td>
					<td><font color="red">Un-manifested</font></td>
					<td><input type="text" name="unmanifest" style="width:50; color:red; text-align:center"  class="input" readonly="readonly"></td>
					<td></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

			</div>
<div id="tabLayer" style="display:none">
<table class="search">
      	<tr>
      		<td class="bg">
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>

<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	<tr>
		<td>
		    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_RailAmsHistory">Rail AMS History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td>
		<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_2o4o">2O/4O </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				    
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_2q4q">2Q/4Q </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_2r4r">2R/4R </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_2z">2Z </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_6h6i">6H/6I </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_non3Z">Non-3Z</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_discrepancy">House B/L Discrepancy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>