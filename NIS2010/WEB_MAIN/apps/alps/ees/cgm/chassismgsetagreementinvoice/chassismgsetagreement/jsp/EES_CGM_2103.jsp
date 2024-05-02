<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2103.jsp
*@FileTitle : Lease Agreement Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.18 김창식
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2103Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm2103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EesCgm2103Event)request.getAttribute("Event");
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

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Lease Agreement Detailed </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="105">Agreement No.</td>
					<td width="150"><input type="text" name="agmt_no" readonly style="width:80;" class="input2" value="<%=agmtNo %>"></td>
					<td width="50">Version</td>
					<td width="122"><script language="javascript">ComComboObject('agmt_ver_no', 1, 60, 1, 0, 0, false);</script></td>
					<td width="50">Ref. No.</td>
					<td width="152"><input type="text" name="agmt_ref_no" readonly style="width:80;" class="input2" value=""></td>
					<td width="115">Agreement Office</td>
					<td width=""><input type="text" name="agmt_iss_ofc_cd" readonly style="width:58;" class="input2" value=""></td>
				</tr>
				</table>		
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="105">Lease Term</td>
					<td width="150"><input type="text" name="agmt_lstm_cd" readonly style="width:50;" class="input2" value=""></td>
					<td width="110">Agreement Date</td>
					<td width="152"><input type="text" name="agmt_dt" readonly style="width:105;" class="input2" value=""></td>
					<td width="130">Agreement Eff. Date</td>
					<td width=""><input type="text" name="agmt_eff_dt" readonly style="width:80;" class="input2" value="">&nbsp;~&nbsp;<input type="text" name="agmt_exp_dt" readonly style="width:80;" class="input2" value=""></td>
				</tr>
				</table>		
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">Lessor</td>
					<td width="467"><input type="text" name="vndr_seq" readonly style="width:51;" class="input2" value="">&nbsp;<input type="text" name="vndr_lgl_eng_nm" readonly style="width:365;" class="input2" value=""></td>
					<td width="130">Rate Eff. Date</td>
					<td width=""><input type="text" name="eff_dt" readonly style="width:80;" class="input2" value="">&nbsp;~&nbsp;<input type="text" name="exp_dt" readonly style="width:80;" class="input2" value=""></td>
				
				</tr>
				</table>		
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="105">Payment Term</td>
					<td width="150" class="stm"><input type="text" name="pay_term_dys" readonly style="width:50;" class="input2" value=""> days</td>
					<td width="155">On-hire Handling Charge</td>
					<td width="105"><input type="text" name="onh_hndl_rt_amt" readonly style="width:60;text-align:right;" class="input2" value=""></td>
					<td width="155">Off-hire Handling Charge</td>
					<td width=""><input type="text" name="offh_hndl_rt_amt" readonly style="width:57;text-align:right;" class="input2" value=""></td>
				</tr>
				</table>	
				
		</td></tr>
		</table>	
		<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr>
				<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
		
		<!-- Tab3 (S) -->
		<div id="tabLayer" style="display:none">
			<table class="search"  height="120" valign="top">
		    	<tr>
					<td class="bg">
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Rental Rate (USD)</td></tr>
						<tr><td class="height_5"></td></tr>
						</table>
						<table border="0" style="width:517; background-color:white;" class="grid2"> 
						<tr class="tr2_head"><td width="25%">Type</td>
							<td width="38%">During Build-up Period</td> 
							<td>During Fixed Period</td> 
						</tr>
						<tr><td class="tr2_head2">CLG</td>
							<td class="align_r"><input type="text" name="mgst_bldp_rt_amt_clg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td> 
							<td class="align_r"><input type="text" name="mgst_lse_fx_rt_amt_clg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td> 
							</tr>
						<tr><td class="tr2_head2">UMG</td>
							<td class="align_r"><input type="text" name="mgst_bldp_rt_amt_umg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td>
							<td class="align_r"><input type="text" name="mgst_lse_fx_rt_amt_umg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td>  
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
		</div>
		<!-- Tab3 (E) -->
		
		<!-- Tab1 (S) -->
		<div id="tabLayer" style="display:inline">
		<table class="search"  height="120" valign="top"> 
       		<tr><td class="bg" valign="top">		
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="147">&nbsp;Monthly Depreciation</td>
					<td width="160"class="sm"><input type="text" name="mon_dpc_rt_amt" readonly style="width:100;text-align:right;ime-mode:disabled" class="input2" value="">&nbsp;&nbsp;%</td>
					<td width="115">Max. Depreciation</td>
					<td width="160" class="sm"><input type="text" name="max_dpc_rt_amt" readonly style="width:100;text-align:right;ime-mode:disabled" class="input2" value="">&nbsp;&nbsp;%</td>
					<td width="88">Initial Factor</td>
					<td width=""class="sm"><input type="text" name="init_dpc_rt_amt" readonly style="width:100;text-align:right;ime-mode:disabled" class="input2" value="">&nbsp;&nbsp;%</td>
					</tr> 
				</table>
				<!-- Grid  (S) -->
				<!-- Grid (E) -->
				<table border="0" style="width:250; background-color:white;" class="grid2"> 
				<tr class="tr2_head"><td width="25%">Type</td>
					<td>Initial Value(USD)</td> 
				</tr>
				<tr><td class="tr2_head2">CLG</td>
					<td class="align_r"><input type="text" name="onh_init_val_amt_clg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td> 
					</tr>
				<tr><td class="tr2_head2">UMG</td>
					<td class="align_r"><input type="text" name="onh_init_val_amt_umg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td> 
					</tr>
				</table>
				
					
			</td></tr>
		</table>
		</div>
		<!-- Tab1 (E) -->
		
		<!-- Tab2 (S) -->
		<div id="tabLayer" style="display:none">
			<table class="search"  height="120" valign="top">
		    	<tr>
					<td class="bg" valign="top">
						<table border="0" style="width:517; background-color:white;" class="grid2"> 
						<tr class="tr2_head"><td width="25%">Type</td>
							<td width="38%">Post Trip Charge (POTC)	</td> 
							<td>Pre Trip Charge (PRTC)</td> 
						</tr>
						
						<tr><td class="tr2_head2">CLG</td>
							<td class="align_r"><input type="text" name="mgst_potc_scg_rt_amt_clg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td> 
							<td class="align_r"><input type="text" name="mgst_prtc_scg_rt_amt_clg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td> 
							</tr>
						<tr><td class="tr2_head2">UMG</td>
							<td class="align_r"><input type="text" name="mgst_potc_scg_rt_amt_umg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td>
							<td class="align_r"><input type="text" name="mgst_prtc_scg_rt_amt_umg" readonly style="border:0;width:100%;text-align:right;ime-mode:disabled" class="input2"></td>  
							</tr>
						</table>		
					</td>
				</tr>
			</table>
		</div>
		<!-- Tab2 (E) -->
		
		<table class="height_8"><tr><td></td></tr></table>
	
	<table class="search">
		    	<tr>
					<td class="bg">
				<table class="grid2" border="0" style="width:100%;"> 
				<tr>
				<tr>
					<td width="80" class="tr2_head">Remark(s)</td>
					<td width="" class=""><textarea name="diff_rmk" readonly style="width:100%;height:60"></textarea></td>
				</tr>
				</table>
	</td></tr>
</table> 
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Search Options ) (E) -->
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
</form>
</body>

<!-- hidden 처리 (S)-->
<div id="mainTable" style="display:none">
<script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- hidden 처리 (E)-->
</html>