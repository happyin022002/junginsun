<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1022.jsp
*@FileTitle : Lease Agreement Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.17 김창식
* 1.0 Creation
*--------------------------------------------------
* History
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1022Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm1022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	
	String agmtNo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//agmtNo = request.getParameter("agmt_no");
		agmtNo = StringUtil.xssFilter(request.getParameter("agmt_no"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Lease Agreement Detail</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- Form Hidden -->


<input type="hidden" name ="action_flag">
<input type="hidden" name ="intg_cd_id">
<input type="hidden" name="ofc_cd">

<input type="hidden" name ="eq_knd_cd">
<input type="hidden" name="agmt_ofc_cty_cd">
<input type="hidden" name="agmt_seq">
<input type="hidden" name="lst_ver_flg">

<!--  Previous Data -->
<input type="hidden" name="pre_eff_dt">
<input type="hidden" name="pre_exp_dt">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Lease Agreement Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="95">Agreement No.</td>
					<td width="100"><input type="text" name="agmt_no" readonly maxlength="9" style="width:80;" class="input2" value="<%=agmtNo %>"></td>
					<td width="52">Version</td>
					<td width="70"><script language="javascript">ComComboObject('agmt_ver_no', 1, 46, 1, 0, 0, false);</script></td>
					<td width="85">Reference No.</td>
					<td width="110"><input type="text" name="agmt_ref_no" readonly style="width:90;" class="input2" value=""></td>
					<td width="60">Currency</td>
					<td width="80"><input type="text" name="curr_cd" readonly style="width:60;" class="input2" value=""></td>
					<td width="112">Agreement Office</td>
					<td><input type="text" name="agmt_iss_ofc_cd" readonly style="width:60;" class="input2" value=""></td>
					
						
				</tr> 
				</table>
				<!--  biz_1  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="95">Lease Term</td>
					<td width="90" style="padding-left:0"><input type="text" name="agmt_lstm_cd" readonly style="width:40;" class="input2" value=""></td>
					<td width="105">Agreement Date</td>
					<td width="115"><input type="text" name="agmt_dt" readonly style="width:80;" class="input2" value=""></td>
					<td width="130">Agreement Eff. Date</td>
					<td><input type="text" name="agmt_eff_dt" readonly style="width:80;" class="input2" value="">&nbsp;~&nbsp;<input type="text" name="agmt_exp_dt"  readonly style="width:80;ime-mode:disabled" class="input2" value=""></td>
				
					</tr> 
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="95">Lessor</td>
					<td width="310"><input type="text" name="vndr_seq" readonly style="width:68;" class="input2" value="">&nbsp;<input type="text" name="vndr_lgl_eng_nm" readonly style="width:203;" class="input2" value=""></td>
					<td width="130">Rate Eff. Date</td>
					<td width="200"><input type="text" name="eff_dt" readonly style="width:80;" class="input2" value="">&nbsp;~&nbsp;<input type="text" name="exp_dt"  readonly style="width:80;ime-mode:disabled" class="input2" value=""></td>
					<td width="">
						<div id="poolLayer" style="visibility:hidden">
						<table class="search" border="0">
						<tr class="h23">
							<td width="40" align="right">Pool</td>
							<td>&nbsp;<input type="text" name="chss_pool_cd" readonly style="width:80;" class="input2" value=""></td>
						</tr>
						</table>
						</div>
					</td>
					
				</tr> 
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!--  biz_1  (E) -->
				
				<table class="search" border="0" style="width:784;"> 
				<tr class="h23">
					<td width="350" valign="top">
					<!--  biz_2  (S) -->
					<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">Rental Rate Type</td></tr>
					</table>
					<table class="search_sm2" border="0" style="width:330;height:83;"> 
						<tr class="h23">
							<td><input type="radio" name="eq_rntl_tp_cd" disabled value="" class="trans" checked>Fixed&nbsp;&nbsp;&nbsp;<input type="radio" name="eq_rntl_tp_cd" disabled value="" class="trans">Tier(Unit/Day)&nbsp;&nbsp;&nbsp;<input type="radio" name="eq_rntl_tp_cd" disabled value="" class="trans">Tier(Used Days)</td>
						</tr> 
						<tr class="h23">
							<td class="stm">&nbsp;&nbsp;Payment Term&nbsp;<input type="text" name="pay_term_dys" readonly style="width:30;" class="input2" value="">&nbsp;Days</td>
						</tr> 
					</table>
					<!--  biz_2   (E) -->
					</td>
					<td width="20">&nbsp;&nbsp;&nbsp;</td>
					<td width="" valign="top">
					<!--  biz_3  (S) -->
					<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">Damage Protection Plan(USD)</td></tr>
					</table>
					<table class="search_sm" border="0" style="width:400;"> 
						<tr class="h23">
							<td width="130" rowspan="2"><input type="radio" name="dpp_tp_cd" disabled value="" class="trans" checked>General DPP</td>
							<td width="120" class="stm">Rate</td>
							<td width=""><input type="text" name="dpp_rt_amt" readonly style="width:60;text-align:right;" class="input2" value=""></td>
						</tr> 
						<tr class="h23">
							<td width="" class="stm">Coverage Amount</td>
							<td><input type="text" name="dpp_cvrg_amt" readonly style="width:60;text-align:right;" class="input2" value=""></td>
						</tr>
						<tr class="h23">
							<td><input type="radio" name="dpp_tp_cd" disabled value="" class="trans">Lumpsum DPP</td>
							<td width="" class="stm">Lumpsum Amount</td>
							<td><input type="text" name="lmsm_amt" readonly style="width:60;text-align:right;" class="input2" value=""></td>
						</tr>  
					</table>
					<!--  biz_3   (E) -->
					</td></tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0">
					<tr class="h23">
						<td colspan="3">
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="160">On-hire Handling Charge</td>
							<td width="125"><input type="text" name="onh_hndl_rt_amt" readonly style="width:60;text-align:right;" class="input2" value=""></td>
							<td width="155">Off-hire Handling Charge</td>
							<td><input type="text" name="offh_hndl_rt_amt" readonly style="width:60;text-align:right;" class="input2" value=""></td>
						</tr> 
					</table>
						</td>
					</tr>
				
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Drop Off Limit</td></tr>
				</table>
				<table class="search" border="0" style="width:784;"> 
				<tr class="h23">
						<td width="350">
						<table class="search_sm" border="0"  style="width:330;">
								<tr class="h23">
									<td width="65">&nbsp;&nbsp;Period</td>
									<td class="stm"><input type="radio" name="drp_off_lmt_prd_cd" disabled value="" class="trans" checked>Per Month&nbsp;&nbsp;&nbsp;<input type="radio" name="drp_off_lmt_prd_cd" disabled value="" class="trans">Per Year</td>
								</tr>
						</table>
					
					</td>
					<td width="20">&nbsp;&nbsp;&nbsp;</td>
					<td width="">
						<table class="search_sm" border="0"  style="width:405;">
								<tr class="h23">
									<td width="280"><input type="radio" name="drp_off_lmt_tp_cd" disabled value="" class="trans" checked>Fixed Quantity&nbsp;&nbsp;&nbsp;<input type="radio" name="drp_off_lmt_tp_cd" disabled value="" class="trans">Guaranted Portion</td>
									<td width="" class="stm">
										<div id="qtyLayer">
										<table border="0"><tr><td>
											<input type="text" name="drp_off_lmt_qty" readonly style="width:80;text-align:right;ime-mode:disabled" class="input2" value="">&nbsp;
										</td></tr></table>
										</div>
										<div id="rtoLayer" style="display:none">
										<table border="0"><tr><td>
											<input type="text" name="drp_off_lmt_rto" readonly style="width:80;text-align:right;ime-mode:disabled" class="input2" value="">&nbsp;%
										</td></tr></table>
										</div>
									</td>
								</tr>
						</table>
					
					</td>
					</tr>
				</table>
				<!--  biz_4   (E) -->
				
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<!-- Tab (S) Hire,  Other Exp,  Payment Term,  Redelivery,  CP file up, Certi File up,-->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab  (E) -->
		
<!--TAB Rental Rate (S) -->

<div id="tabLayer" style="display:Inline">

		<!-- Tab BG Box  (S) -->
     <table class="search"> 
       		<tr><td class="bg" style="height:135" valign="top">
				<!--  biz_5  (E) -->
			<!-- Grid  (S) -->
				<div id="t3sheetLayer1" style="display:Inline">
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet1');</script>
							</td>
						</tr>
					</table>
				</div>	  
			<!-- Grid (E) -->
			<!-- Grid  (S) -->
				<div id="t3sheetLayer2" style="display:none">
					<!--table class="height_5"><tr><td></td></tr></table-->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet2');</script>
							</td>
						</tr>
					</table>  
				</div>	
			<!-- Grid (E) -->
			<!-- Grid  (S) -->
				<div id="t3sheetLayer3" style="display:none">
					<!--table class="height_5"><tr><td></td></tr></table-->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet3');</script>
							</td>
						</tr>
					</table>  
				</div>	
			<!-- Grid (E) -->
			
		
	<!-- Tab BG Box  (S) -->
</td></tr>
</table> 

</div>

<!--TAB Rental Rate (E) --> 

<!--TAB Depr. For Casualty Value (S) -->

<div id="tabLayer" style="display:none">
	
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg" style="height:135" valign="top">
			<!--  biz_5  (S) -->
				<table class="search" border="0" style="width:784;"> 
				<tr class="h23">
					<td width="135">Monthly Depreciation</td>
					<td width="160" class="stm"><input type="text" name="mon_dpc_rt_amt" readonly style="width:80;text-align:right;" class="input2" value="">&nbsp;%</td>
					<td width="110">Max. Depreciation</td>
					<td width="160" class="stm"><input type="text" name="max_dpc_rt_amt" readonly style="width:80;text-align:right;" class="input2" value="">&nbsp;%</td>
					<td width="80">Initial Factor</td>
					<td class="stm"><input type="text" name="init_dpc_rt_amt" readonly style="width:80;text-align:right;" class="input2" value="">&nbsp;%</td>
					</tr>  
				</table>
				<!--  biz_5  (E) -->
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid (E) -->
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	

</div>

<!--TAB Depr. For Casualty Value (E) --> 

<!--TAB Surcharge (S) -->

<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg" style="height:135" valign="top">
			<!--  biz_5  (S) -->
				<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">Surcharge for Registration</td></tr>
					</table>
				<!--  biz_5  (E) -->
			<!-- Grid  (S) -->
					<table width="70%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table> 
			<!-- Grid (E) -->
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
		

</div>

<!--TAB Surcharge (E) -->  

<!--TAB Remark (S) -->

<div id="tabLayer" style="display:none">


		<!-- Tab BG Box  (S) -->
     <table class="search"> 
       		<tr><td class="bg" style="height:135" valign="top">	
				<!--  biz_5  (E) -->
			<!-- Grid  (S) -->
			<table width="100%" class="search"> 
			<tr class="" align="center"><td><textarea name="diff_rmk" readonly style="width:100%;height:100;"></textarea></td>
			</tr>
			</table> 
			<!-- Grid (E) -->
			
		
	<!-- Tab BG Box  (S) -->
</td></tr>
</table> 


</div>

<!--TAB Remark (E) -->  
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 


	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
				
			</tr>
		</table></td></tr>
		</table> 
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->

<div id="hiddenLayer" style="display:none">
	<script language="javascript">ComSheetObject('sheet');</script>  
</div>

</form>
</body>
</html>