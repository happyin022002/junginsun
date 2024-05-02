<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2017.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsr_Cnt_cd	= "";
	String strUsr_eml		= "";
	
	String dar_no           = "";
	String ctrt_no          = "";
	String rqst_flg			= "";
	String save_sts_cd      = "";
	String apvl_path_cd     = "";	
	String cust_cd		    = "";	
	
	String apvl_no			= "";
	String status			= "";
	
	
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm 		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strUsr_Cnt_cd	= account.getCnt_cd();
		strUsr_eml		= account.getUsr_eml();

		event = (EesDmt2017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		dar_no       = JSPUtil.getParameter(request, "dar_no");
		ctrt_no    	 = JSPUtil.getParameter(request, "ctrt_no");
		rqst_flg     = JSPUtil.getParameter(request, "rqst_flg");
		save_sts_cd  = JSPUtil.getParameter(request, "save_sts_cd");
		apvl_path_cd = JSPUtil.getParameter(request, "apvl_path_cd");	
		cust_cd		 = JSPUtil.getParameter(request, "cust_cd");			
		apvl_no		 = JSPUtil.getParameter(request, "apvl_no");		
		status		 = JSPUtil.getParameter(request, "status");	
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>After Booking Request Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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

<body class="popup_bg" onLoad="setupPage();" onUnLoad="unLoadPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="dmdt_chg_sts_cd">
<input type="hidden" name="fm_mvmt_yd_cd">
<input type="hidden" name="to_mvmt_yd_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="fm_mvmt_dt">
<input type="hidden" name="to_mvmt_dt">
<input type="hidden" name="yd_cd1">
<input type="hidden" name="loc_cd">
<input type="hidden" name="vvd_cd">
<input type="hidden" name="chk_yd_cd"	value="Y">
<input type="hidden" name="chk_loc_cd"	value="Y">
<input type="hidden" name="backendjob_key">		<!-- BackEndJob Key -->
<input type="hidden" name="backendjob_id">		<!-- BackEndJob 구분 ID -->

<input type="hidden" name="aft_expt_dar_no" value="<%= dar_no %>">

<input type="hidden" name="spec_rsn_cd">

<input type="hidden" name="h_detail_1_rsn_field_name">
<input type="hidden" name="h_detail_1_rsn_field_type">
<input type="hidden" name="h_detail_1_rsn_field_size">
<input type="hidden" name="h_detail_1_rsn_field_format">
<input type="hidden" name="h_detail_1_rsn_field_item">
<input type="hidden" name="h_detail_1_rsn_field_cond">
<input type="hidden" name="h_detail_1_rsn_field_popup">
<input type="hidden" name="h_detail_1_rsn_field_value">
<input type="hidden" name="h_detail_2_rsn_field_name">
<input type="hidden" name="h_detail_2_rsn_field_type">
<input type="hidden" name="h_detail_2_rsn_field_size">
<input type="hidden" name="h_detail_2_rsn_field_format">
<input type="hidden" name="h_detail_2_rsn_field_item">
<input type="hidden" name="h_detail_2_rsn_field_cond">
<input type="hidden" name="h_detail_2_rsn_field_popup">
<input type="hidden" name="h_detail_2_rsn_field_value">
<input type="hidden" name="h_detail_3_rsn_field_name">
<input type="hidden" name="h_detail_3_rsn_field_type">
<input type="hidden" name="h_detail_3_rsn_field_size">
<input type="hidden" name="h_detail_3_rsn_field_format">
<input type="hidden" name="h_detail_3_rsn_field_item">
<input type="hidden" name="h_detail_3_rsn_field_cond">
<input type="hidden" name="h_detail_3_rsn_field_popup">
<input type="hidden" name="h_detail_3_rsn_field_value">
<input type="hidden" name="h_detail_4_rsn_field_name">
<input type="hidden" name="h_detail_4_rsn_field_type">
<input type="hidden" name="h_detail_4_rsn_field_size">
<input type="hidden" name="h_detail_4_rsn_field_format">
<input type="hidden" name="h_detail_4_rsn_field_item">
<input type="hidden" name="h_detail_4_rsn_field_cond">
<input type="hidden" name="h_detail_4_rsn_field_popup">
<input type="hidden" name="h_detail_4_rsn_field_value">
<input type="hidden" name="h_detail_5_rsn_field_name">
<input type="hidden" name="h_detail_5_rsn_field_type">
<input type="hidden" name="h_detail_5_rsn_field_size">
<input type="hidden" name="h_detail_5_rsn_field_format">
<input type="hidden" name="h_detail_5_rsn_field_item">
<input type="hidden" name="h_detail_5_rsn_field_cond">
<input type="hidden" name="h_detail_5_rsn_field_popup">
<input type="hidden" name="h_detail_5_rsn_field_value">

<input type="hidden" name="h_detail_6_rsn_field_name">
<input type="hidden" name="h_detail_6_rsn_field_type">
<input type="hidden" name="h_detail_6_rsn_field_size">
<input type="hidden" name="h_detail_6_rsn_field_format">
<input type="hidden" name="h_detail_6_rsn_field_item">
<input type="hidden" name="h_detail_6_rsn_field_cond">
<input type="hidden" name="h_detail_6_rsn_field_popup">
<input type="hidden" name="h_detail_6_rsn_field_value">

<input type="hidden" name="h_detail_7_rsn_field_name">
<input type="hidden" name="h_detail_7_rsn_field_type">
<input type="hidden" name="h_detail_7_rsn_field_size">
<input type="hidden" name="h_detail_7_rsn_field_format">
<input type="hidden" name="h_detail_7_rsn_field_item">
<input type="hidden" name="h_detail_7_rsn_field_cond">
<input type="hidden" name="h_detail_7_rsn_field_popup">
<input type="hidden" name="h_detail_7_rsn_field_value">

<input type="hidden" name="h_detail_8_rsn_field_name">
<input type="hidden" name="h_detail_8_rsn_field_type">
<input type="hidden" name="h_detail_8_rsn_field_size">
<input type="hidden" name="h_detail_8_rsn_field_format">
<input type="hidden" name="h_detail_8_rsn_field_item">
<input type="hidden" name="h_detail_8_rsn_field_cond">
<input type="hidden" name="h_detail_8_rsn_field_popup">
<input type="hidden" name="h_detail_8_rsn_field_value">

<input type="hidden" name="h_detail_9_rsn_field_name">
<input type="hidden" name="h_detail_9_rsn_field_type">
<input type="hidden" name="h_detail_9_rsn_field_size">
<input type="hidden" name="h_detail_9_rsn_field_format">
<input type="hidden" name="h_detail_9_rsn_field_item">
<input type="hidden" name="h_detail_9_rsn_field_cond">
<input type="hidden" name="h_detail_9_rsn_field_popup">
<input type="hidden" name="h_detail_9_rsn_field_value">

<input type="hidden" name="ctrt_no" value="<%= ctrt_no %>">
<input type="hidden" name="rqst_flg" value="<%= rqst_flg %>">
<input type="hidden" name="save_sts_cd" value="<%= save_sts_cd %>">
<input type="hidden" name="apvl_path_cd" value="<%= apvl_path_cd %>">
<input type="hidden" name="cust_cd" value="<%= cust_cd %>">

<input type="hidden" name="fm_dt">
<input type="hidden" name="to_dt">

<input type="hidden" name="retrive_flg">

<input type="hidden" name="bkg_no">
<input type="hidden" name="cntr_no">

<input type="hidden" name="uc_cgo_psbl_flg">
<input type="hidden" name="gnte_ltr_cd">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;After Booking Request Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80">DAR No. </td>
						<td width="140"><input type="text" name="dar_no" style="width:120;"  value="<%= dar_no %>" class="input2" ></td>
						<td width="60">APVL No.</td>
						<td width="160"><input type="text" name="apvl_no" style="width:120;" value="<%= apvl_no %>" class="input2" ></td>
						<td width="60">Status</td>
						<td width="150"><input type="text" name="status" style="width:145;" class="input2" value="<%= status %>"></td>
						<td width="">					
							<table class="search" border="0">
								<tr><td class="title_s">&nbsp;&nbsp;&nbsp;<font color="red">*</font>&nbsp;: Mandatory Item</td></tr>
							</table>
						</td>
					</tr>
				</table>
		</td></tr>
	</table>		
	<table class="height_5"><tr><td></td></tr></table>
	<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr>
				<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
	<!-- Tab (E) -->

	<!-- ********************* 	Tab-1 START 	********************** -->
		<div id="tabLayer" style="display:inline">
		<table class="search" id="mainTable" > 
		<tr><td class="bg" >
		<table class="search" style="width: 100%;"> 		
			<tr class="h23">
				<td width="470" valign="top">
				
					<table class="height_8"><tr><td></td></tr></table>
					<table class="search" border="0">
						<tr class="h23">
							<td width="120"><font color="red">*</font>Reason of D/C Request</td>
							<td width="340"><textarea name="rsn_dc_rqst" dataformat="engup3" style="width:340;height:45;" class="input"></textarea></td>							
							<td width="">&nbsp;</td>
						</tr>
						<tr class="h23">
							<td width="120"><font color="red">*</font>Reason of Late Clearance</td>
							<td width="340"><textarea name="rsn_cle_delay" dataformat="engup3" style="width:340;height:45;" class="input"></textarea></td>						
							<td width="">&nbsp;</td>
						</tr>
						<tr class="h23">
							<td width="120"><font color="red">*</font>Customer's Request Letter</td>
							<td width="340">&nbsp;<script language="javascript">ComSheetObject('t1sheet1');</script></td>						
							<td width="">&nbsp;</td>
						</tr>
						<tr>
							<td width="120">&nbsp;</td>
							<td width="">
								<table width="350" class="button"> 
						       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" id="btn_crl_upload" name="btn_crl_upload">File Upload</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" id="btn_crl_file_delete" name="btn_crl_file_delete">File Delete</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>							
										</tr></table>
								</td></tr>
								</table>
							</td>
						</tr>
						<tr>
							<td width="" colspan="2">&nbsp;</td>
						</tr>
						</tr>
						<tr class="h23">
							<td width="120">Actual Cost(for all BKG)</td>
							<td width="340">&nbsp;<script language="javascript">ComSheetObject('t1sheet2');</script></td>						
							<td width="">&nbsp;</td>
						</tr>
						
						
						<tr class="h23">
							<td width="120">Other Attachment If Needed</td>
							<td width="340">&nbsp;<script language="javascript">ComSheetObject('t1sheet3');</script></td>
						</tr>
						<tr>
							<td width="120">&nbsp;</td>
							<td width="350">
								<table width="100%" class="button"> 
						       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" id="btn_oain_upload" name="btn_oain_upload">File Upload</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" id="btn_oain_file_delete" name="btn_oain_file_delete">File Delete</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>							
										</tr></table>
								</td></tr>
								</table>
							</td>
						</tr>		
					</table>
				</td>
				
				<td width="479" valign="top">
					<table class="search" border="0">
						
						<tr class="h23">
							<td width="120"><font color="red">*</font>Cargo Invoice</td>
							<td width="350"><script language="javascript">ComSheetObject('t1sheet5');</script></td>
						</tr>
						<tr>
							<td width="120">&nbsp;</td>
							<td width="350">
								<table width="100%" class="button"> 
						       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" id="btn_cin_upload" name="btn_cin_upload">File Upload</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" id="btn_cin_file_delete" name="btn_cin_file_delete">File Delete</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>							
										</tr></table>
								</td></tr>
								</table>
							</td>
						</tr>		
						<tr><td width="" colspan="2">&nbsp;</td></tr>				
						<tr><td width="" colspan="2">&nbsp;</td></tr>
						<tr class="h23">
							<td width="" colspan="2"><font color="red">*</font>Uncollected Cargo Possibility&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="ucCgoPsblFlg1" value="Y" class="trans" onClick="setHighLow('1')">High&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="ucCgoPsblFlg2" value="N" class="trans" onClick="setHighLow('2')">Low</td>
						</tr>
						<tr><td width="" colspan="2">&nbsp;</td></tr>				
						<tr><td width="" colspan="2">&nbsp;</td></tr>						
						<tr class="h23">
							<td width="120">Expected Clearance Date (Long Staying ONLY)</td>
							<td width="350"><script language="javascript">ComSheetObject('t1sheet6');</script></td>
						</tr>						
						<tr><td width="" colspan="2">&nbsp;</td></tr>
						<tr class="h23">							
							<td width="120">&nbsp;</td>
							<td width="350"><input type="checkbox" name="gnteLtrCd_V" value="N" class="trans" >Volume&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										    <input type="checkbox" name="gnteLtrCd_P" value="N" class="trans" >Payment</td>
						</tr>
						<tr><td width="" colspan="2">&nbsp;</td></tr>
						<tr class="h23">
							<td width="120">Guarantee Letter</td>
							<td width="350"><script language="javascript">ComSheetObject('t1sheet7');</script></td>
						</tr>	
						<tr>
							<td width="120">&nbsp;</td>
							<td width="350">
								<table width="100%" class="button"> 
						       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" id="btn_gtl_upload" name="btn_gtl_upload">File Upload</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" id="btn_gtl_file_delete" name="btn_gtl_file_delete">File Delete</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>							
										</tr></table>
								</td></tr>
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
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	</div>
	<!-- ********************* Tab-1 END ********************** -->


 	  <!--  Tab_2 (S) -->
	<div id="tabLayer" style="display:none">	
	<table class="search" id="mainTable" > 
	<tr><td class="bg" >
		<table class="search">	
			<tr class="h23">
				<td width="" colspan = "2"><script language="javascript">ComSheetObject('t2sheet1');</script></td>
			</tr>
			<tr>
				<td width="450" >
					<input type="radio" name="pfmc_flg" value="Y0" class="trans">PFMC of the previous one year until the request date</a>
				</td>
				<td width="" >
					<input type="radio" name="pfmc_flg" value="60" class="trans">PFMC of the previous 6 months until the request date</a>
				</td>
			</tr>
			<tr>
				<td width="450" >
					<input type="radio" name="pfmc_flg" value="Y3" class="trans">PFMC of the previous one year until 3 months ago</a>
				</td>
				<td width="" >
					<input type="radio" name="pfmc_flg" value="63" class="trans">PFMC of the previous 6 months until 3 months ago</a>
				</td>
			</tr>
			<tr>
				<td width="" colspan = "2">
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" id="btn_pfmc_retrieve" name="btn_pfmc_retrieve">Retrieve</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>						
							</tr></table>
					</td></tr>
					</table>
				</td>
			</tr>
		</table>
	</td>
	</tr>	
	<tr>
		<td class="bg" >
		<table class="search">		
			<tr>
				<td width="">&nbsp;</td>
			</tr>
			<tr class="h23">
				<td width=""  colspan = "2"><script language="javascript">ComSheetObject('t2sheet2');</script></td>
			</tr>
			<tr>
				<td width="450" >
					<input type="radio" name="lcc_flg" value="Y0" class="trans">PFMC of the previous one year until the request date</a>
				</td>
				<td width="" >
					<input type="radio" name="lcc_flg" value="60" class="trans">PFMC of the previous 6 months until the request date</a>
				</td>
			</tr>
			<tr>
				<td width="450" >
					<input type="radio" name="lcc_flg" value="Y3" class="trans">PFMC of the previous one year until 3 months ago</a>
				</td>
				<td width="" >
					<input type="radio" name="lcc_flg" value="63" class="trans">PFMC of the previous 6 months until 3 months ago</a>
				</td>
			</tr>
			<tr>
				<td width="" colspan = "2">
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" id="btn_lcc_retrieve" name="btn_lcc_retrieve">Retrieve</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>						
							</tr></table>
					</td></tr>
					</table>
				</td>
			</tr>
		</table>
	</td>
	</tr>
	</table>
    </div>
    
 	  <!--  Tab_3 (S) -->
	<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable" > 
	<tr><td class="bg" >
		<table class="search">	
			<tr class="h23">
				<td width=""><script language="javascript">ComSheetObject('t3sheet1');</script></td>
			</tr>	
			
			<tr>
				<td >
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" id="btn_full_row_add" name="btn_full_row_add">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" id="btn_full_row_delete" name="btn_full_row_delete">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>							
							</tr></table>
					</td></tr>
					</table>
				</td>
			</tr>	
			
			<tr>
				<td width=""><b>** <font color="red">All</font> of your following up reaction from customer. **</b></td>
			</tr>
			<tr>
				<td width="">&nbsp;&nbsp;&nbsp;- Your action should be supported by written or system record. (not accept only verbal story-telling)</td>
			</tr>
			<tr>
				<td width="">&nbsp;&nbsp;&nbsp;- Customer's reaction should be supported by written msg, and supported by official documents/evidences about their reason of pending.</td>
			</tr>

		</table>
	</td>
	</tr>
	</table>
    </div>
    
 	  <!--  Tab_3 (S) -->
	<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable" > 
	<tr><td class="bg" >
		<table class="search">	
			
			<tr><td class="title_s">Request Detail</td></tr>
			
			<tr class="h23">
				<td><script language="javascript">ComSheetObject('t4sheet1');</script></td>
			</tr>
			
			<tr>
				<td width="" >&nbsp;</td>
			</tr>
			<tr>
				<td width="" >&nbsp;<b><font color="red"><span id="detail_explanation"></span></font></b></td>
			</tr>
			
			<tr>
				<td width="" >&nbsp;</td>
			</tr>
					
			<tr class="h23" >
				<td>
				<table width="100%"  id="t4sheet2_id" style="display:none"> 
					
					<tr class="h23" >
						<td><table width="100%" > 
							<tr><td class="title_s" width="220">Attached File (5MB limit per file)</td>
								<td><table width=""  id="t4sheet2_down"  style="display:none" > 
									<tr><td width=""><a href=# onclick = downloadFileINT('iepore_20151228135154403.xlsx')><strong>Download File</strong></a></td></tr>
									</table>
								</td>
							</tr>
							</table>
						</td>
					</tr>
					<tr class="h23">
						<td><script language="javascript">ComSheetObject('t4sheet2');</script></td>
					</tr>
					<tr>
						<td>
							<table width="100%" class="button"> 
					       	<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" id="btn_aer_upload" name="btn_aer_upload">File Upload</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" id="btn_aer_file_delete" name="btn_aer_file_delete">File Delete</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>							
									</tr></table>
							</td></tr>
							</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td width="" >&nbsp;</td>
			</tr>
			
			<tr class="h23" >
				<td><table width="100%"  id="t4sheet3_id" style="display:none"> 
					<tr><td width="100%"><script language="javascript">ComSheetObject('t4sheet3');</script></td></tr>
					</table>
				</td>
			</tr>
			
			<tr>
				<td>
					<table width="100%" class="button" style="display:none" id="t4sheet3_button" > 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" id="btn_aer_row_add" name="btn_aer_row_add">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" id="btn_aer_row_delete" name="btn_aer_row_delete">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>							
							</tr></table>
					</td></tr>
					</table>
				</td>
			</tr>
			
		</table>
	</td>
	</tr>
	</table>
    </div>
    
    
 	  <!--  Tab_3 (S) -->
	<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable" > 
	<tr><td class="bg" >
		<table class="search">	
			
			<tr><td class="title_s">Approval Detail</td></tr>
			
			<tr class="h23">
				<td><script language="javascript">ComSheetObject1('t5sheet1');</script></td>
			</tr>
			
		</table>
	</td>
	</tr>
	</table>
    </div>
    
   </td></tr>
</table>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    <% if (!"N".equals(save_sts_cd)) { %>	    
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			<% } %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
<script language="javascript">ComUploadObject("upload1", '<%=session.getId()%>');</script>
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
<!-- 개발자 작업  끝 -->
</body>
</html>