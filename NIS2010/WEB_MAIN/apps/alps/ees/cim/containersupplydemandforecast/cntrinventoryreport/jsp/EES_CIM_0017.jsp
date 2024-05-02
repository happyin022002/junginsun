<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0017.jsp
*@FileTitle : Sea Inventory  
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.06.03 김종준
* 1.0 Creation

* ========================================================
* 2010.11.16 이상민 [CHM-201007040-01]
* 1. SEA Inventory 검색조건 CMDT추가, 빠른 Grid "Speed"옵션 추가
* 2. 3번째 탭 CNTR List 외 탭에서 CMDT조건 Hide
* 3. CMDT 체크시 MST_CONTAINER와 BKG_BOOKING 조인하여 CMDT / REMARK select
* 2011.10.12 신자영 [CHM-201113678-01] [CIM] SEA-INVENTORY POL-POD 검색 관련 보완
* 2012.05.03 신자영 [CHM-201217579-01] [CIM] Sea-Inventory 기능 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";


	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerSupplyDemandForecast.CNTRInventoryReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCim0017Event)request.getAttribute("Event");
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
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">

    function setupPage(){
	    loadPage();
    }

</script>
<body  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="head_cntr_tpsz_cd" value=""> 

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
	<td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
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
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="40">&nbsp;Lane</td>
						<td width="270">
							<input type="text" name="slan_cd"  style="ime-mode:inactive" dataformat="engup" size="3" maxlength="3" fulfill style="width:43;" class="input" value="">&nbsp;<img class="cursor" name="btn_lane" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
						<td width="75">TP/SZ</td>
						<td width="120">
							<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 115, 1);</script>
							<!-- <input type="checkbox" class="input2" name="chk_cntr_tpsz_cd" class="input" value=""> -->					
						</td>
						<td width="38">&nbsp;</td>
						<td width="89">IMM. Exit<input type="checkbox" name="imdt_ext_flg" value="Y" class="trans"></td>
						<td width="110">
							&nbsp;Plastic Floor<input type="checkbox" name="plst_flr_flg" value="Y" class="trans">
						</td>
						<td width="110">
							Company&nbsp;<input type="text" class="input" name="tem_cntr_use_co_cd" readOnly=true style="width:30;" class="input" value="SML">
	       								 <input type="hidden" name="cntr_use_co_cd" value="H">
						</td>
						<td>Prefix&nbsp;<input type="text" name="cntr_no" style="width:40;" dataformat="engup" size="4" maxlength="4" fulfill class="input" value=""></td>
					</tr>
					<tr><td style="height:4"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="60">&nbsp;VVD&nbsp;&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vvd" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="250">
							<input type="text" name="vvd1" style="ime-mode:inactive" dataformat="engup" size="9" maxlength="9" fulfill style="width:75;" class="input" value="" >
							<input type="text" name="vvd2" style="ime-mode:inactive" dataformat="engup" size="9" maxlength="9" fulfill style="width:75;" class="input" value="">
							<input type="text" name="vvd3" style="ime-mode:inactive" dataformat="engup" size="9" maxlength="9" fulfill style="width:75;" class="input" value=""></td>
						<td width="75">Lease Term</td>
						<td width="120">
							<script language="javascript">ComComboObject('lstm_cd', 1, 115, 1);</script>
							<!-- <input type="checkbox" class="input2" name="chk_lstm_cd" readOnly=true  class="input" value=""> -->
						</td>
						<td width="38">&nbsp;</td>
						<td width="89">Off-hire<input type="checkbox" name="off_hire_flg" value="Y" class="trans"></td>
						<td height="100%">
						<!--  2010.11.16 이상민 [CHM-201007040-01] 3번탭 CNTR List Click시 search조건 CMDT, Speed 활성화  -->
							<div id = "show_add_info" style = "display:'none'" >
							<table border="0" class="search_sm2" width="100%">
								<tr class="h23">
									<td width="65">Add Info</td>
									<td class="stm">
										<input type="checkbox" name="view_commodity" value="Y" class="trans">CMDT
									</td>
									<td>Speed&nbsp;<input type="checkbox" name="speed" class="trans" value="Y"></td>
								</tr>
							</table>
							</div>
							<div id = "hide_add_info" style = "display:''" >
							<table border="0" class="search_sm2" style="background-color:#F3F2F8; border:4px solid #F3F2F8" width="100%" >
								<tr class="h23" >
									<td width="65">&nbsp;</td>
									<td class="stm">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table>
							</div>
						<!--  끝 2010.11.16 이상민 [CHM-201007040-01] 3번탭 CNTR List Click시 search조건 CMDT, Speed 활성화  -->
						</td>
						<!--td>Speed&nbsp;<input type="checkbox" name="speed" class="trans" checked value="Y"></td-->
					</tr>
					<tr><td style="height:4"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 					
					<tr class="h23">
						<td width="310" rowspan="2">
							<table class="search_sm2" border="0" width="98%"> 
								<tr class="h23">
									<td><input type="radio" name="route_tp_cd" value="V" class="trans" checked>On-board&nbsp;</td>
									<td><input type="radio" name="route_tp_cd" value="B" class="trans">Booking&nbsp;</td>
									<td></td>
								</tr> 
								<tr class="h23">
									<td>&nbsp;POL&nbsp;<input type="text" name="pol_cd" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill style="width:42;" class="input" value="">&nbsp;<img class="cursor" name="btns_pol_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
									<td>&nbsp;POD&nbsp;<input type="text" name="pod_cd" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill style="width:42;" class="input" value="">&nbsp;<img class="cursor" name="btns_pod_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
									<td>&nbsp;DEL&nbsp;<input type="text" name="del_cd" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill style="width:42;" class="input" value="">&nbsp;<img class="cursor" name="btns_del_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
								</tr> 
							</table>
						</td>
						<td width="75">Cargo Type</td>
						<td width="120">
							<select name="full_flg" style="width:115;" class="input">
								<option value="" selected></option>
								<option value="Y">Full</option>
								<option value="N">MTY</option>
							</select>
						</td>
						<td width="30">&nbsp;DMG</td>
						<td width="90">
							<select name="dmg_flg" style="width:75;" class="input">
								<option value="" selected>Include</option>
								<option value="N">Exclude</option>
								<option value="Y">Only</option>
							</select>
						</td>
						<td>
							<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="65">Reefer</td>
								<td width="" class="stm">
									<input type="checkbox" name="rf_tp_cd_c" value="C" class="trans">CA&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="rf_tp_cd_h" value="H" class="trans">HU&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="rf_tp_cd_m" value="M" class="trans">MG&nbsp; 
									<input type="checkbox" name="rf_cntr" value="N" class="trans">Reefer
									<input type="checkbox" name="rd_cgo_flg" value="Y" class="trans">R/D
								</td>
							</tr>
							</table>
						</td>
					</tr>
					<tr class="h23">
						<td width="75">Staying Day</td>
						<td width="120"class="stm"><input type="text" name="stay_days" style="ime-mode:inactive" dataformat="int" style="width:40; text-align:right;" size="5" maxlength="5" style="width:50;" class="input" value="">&nbsp;or over</td>
						<td width="">&nbsp;S.O.C</td> 
						<td width="">
							<select name="soc_cd" style="width:75;" class="input">
								<option value="1"selected>Exclude</option>
								<option value="">Include</option>
								<option value="2">Only</option>
							</select>
						</td>
						<td>
							<table class="search_sm2" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="65">EQ MGMT</td>
								<td width="" class="stm">
									<input type="checkbox" name="cntr_hngr_rck_cd" value="Y" class="trans">Hanger Rack/Bar&nbsp;
									<input type="checkbox" name="disp_flg" value="Y" class="trans">DPSL&nbsp;&nbsp;
									<input type="checkbox" name="d2_payld_flg" value="Y" class="trans">D2-LP
								</td>
							</tr>
							</table>
						</td>
					</tr> 

				</table>
				<!--  biz_1   (E) -->
				</td>
					</tr> 
				</table>
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
		
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 


<!--TAB Inventory (S) -->
<div id="tabLayer" style="display:inline"> 
	
		<table class="search"> 
       	<tr><td class="bg">			
				
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->

					
			

			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
</div>
<!--TAB Inventory (E) --> 



<!--TAB POL-POD (S) -->
<div id="tabLayer" style="display:none">

			<!-- Grid  (S) -->
	     	<table class="search"> 
	       	<tr><td class="bg">
				<table class="search_sm">
					<tr class="h23">
						<td width="35">View</td>
						<td width="" class="stm">
							<input type="Radio" name="pol_pod_wise" value="POL" class="trans" checked>POL-wise&nbsp;&nbsp;&nbsp;
							<input type="Radio" name="pol_pod_wise" value="POD" class="trans">POD-wise&nbsp;&nbsp;&nbsp;
							<input type="Radio" name="pol_pod_wise" value="ETD_POL_A" class="trans">ETD POL ASC&nbsp;&nbsp;&nbsp;
							<input type="Radio" name="pol_pod_wise" value="ETD_POL_D" class="trans">ETD POL DESC&nbsp;&nbsp;&nbsp;
							<input type="Radio" name="pol_pod_wise" value="ETA_POD_A" class="trans">ETA POD ASC&nbsp;&nbsp;&nbsp;
							<input type="Radio" name="pol_pod_wise" value="ETA_POD_D" class="trans">ETA POD DESC
						</td>
					</tr>
				</table>
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
	
				<!--  Grid_button (S) -->
			
				</td></tr>
			</table>			

	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

</div>
<!--TAB POL-POD (E) -->  



<!--TAB CNTR List (S) -->
<div id="tabLayer" style="display:none">

		<table class="search"> 
       	<tr><td class="bg">			
				
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->

					
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_movement">Movement</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_master">&nbsp;&nbsp;&nbsp;Master&nbsp;&nbsp;&nbsp;</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>				
	    	<!-- Button_Sub (E) -->	
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

</div>
<!--TAB CNTR List (E) --> 

	
	
<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>
</form>
</body>
</html>
