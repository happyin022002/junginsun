<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0106.jsp
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2013.05.03 최문환 [CHM-201324134]Split 01-VOP-SCG] B.Bulk Cargo application상 Loading/Discharging Method 강제사항으로 변경 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0106Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>

<%
	EsmBkg0106Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	String bkgNo = "";
	String screenName = "";
	
	String isInquiry = "N";	
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//inquiry mode
	if (screen.getName().indexOf("Q") >= 0){
		isInquiry = "Y";
	} else {
		isInquiry = "N";			
	}
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0106Event)request.getAttribute("Event");
		bkgNo = event.getBkgNo();
				
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
<title>Break Bulk Cargo Application</title>
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
<input type="hidden" name="temp_cntr_no">
<input type="hidden" name="temp_grs_wgt">
<input type="hidden" name="temp_net_wgt" value="0">
<input type="hidden" name="title_id" value="bb">
<input type="hidden" name="diff_rmk" value="">
<input type="hidden" name="row_cnt" value="">
<input type="hidden" name="button" value="N">
 
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>	
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">BKG No.</td>
					<td width="130"><input name="bkg_no" type="text" style="width:96;" class="input" value="<%=bkgNo%>" maxlength="13">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
					</td>
					<td width="50">B/L No.</td>
					<td width="130"><input name="bl_no" type="text" style="width:113;" class="input" value="" maxlength="12"></td> 
					<td width="125">Requested by/Date</td>
					<td width="220"><input name=rqst_usr_id type="text" style="width:90;" class="input2" value="" readonly>&nbsp;<input name="rqst_dt" type="text" style="width:115;" class="input2" value="" readonly></td>
					<td width="155" class="sm"><input name="rqst_gdt" type="text" style="width:115;" class="input2" value="" readonly> (GMT)</td>
					<td width="60">Approval</td>
					<td><input name="auth_cd" type="text" style="width:20;" class="input2_1" value="" readonly>&nbsp;<img name="btn_approval" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="50">T/VVD</td>
					<td width="130"><input name="tvvd" type="text" style="width:90;" class="input2" value="" readonly></td>
					<td width="20">POL</td>
					<td width="92"><input name="pol_cd" type="text" style="width:50;" class="input2" value="" readonly>&nbsp;<input name="pol_nod_cd" type="text" style="width:30;" class="input2" value="" readonly></td>
					<td width="80"><table width="55" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_pol_cd">Info.</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
					<td width="30">POD</td>
					<td width="92"><input name="pod_cd" type="text" style="width:50;" class="input2" value="" readonly>&nbsp;<input name="pod_nod_cd" type="text" style="width:30;" class="input2" value="" readonly></td>
					<td width=""><table width="55" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_pod_cd">Info.</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
					
					</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480">
						<!--  biz_2_1  (S) -->
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="230" valign="top">
									<!--  biz_2_1_1  (S) -->
									<!--grid (s)-->
									<table width="100%"  id="mainTable">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table>
									<!--grid (E)-->
									<!--  biz_2_1_1  (E) -->
								
								</td>
								<td width="20">&nbsp;</td>
								<td width="230" valign="top">
									<!--  biz_2_1_2  (S) -->
									
									<!--grid (s)-->
									<table width="100%"  id="mainTable">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet2');</script>
											</td>
										</tr>
									</table>
									<!--grid (E)-->
									<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
	       					<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_cntr_add">Row Add</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_cntr_delete">Row Delete</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									
								</tr></table>
							</td></tr>
						</table>
	    				<!-- Button_Sub (E) -->
									<!--  biz_2_1_2  (E) -->
								
								</td>
							</tr>
						</table>
						<!--  biz_2_1  (E) -->
						
						
						<!--  biz_2_2  (E) -->
					</td>
					<td width="19">&nbsp;</td>
					<td width="480" valign="top">
					
						
					</td>
				</tr>
				</table>
				<!--  biz_2  (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						
				
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="480">
						
						<!--  biz_2_2  (S) -->
						<!--grid (s)-->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet4');</script>
								</td>
							</tr>
						</table>
						
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet5');</script>
								</td>
							</tr>
						</table>
						<!--grid (E)-->
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
	       					<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_cargo_add">Row Add</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_cargo_delete">Row Delete</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_Copy">Copy</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								</tr></table>
							</td></tr>
						</table>
	    				<!-- Button_Sub (E) -->
						<table class="height_2"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="80">Total Weight</td>
								<td width="230"><input name="weight_sum" type="text" style="width:120;text-align:right;" class="input2" value="" readonly>&nbsp;
								<select name="wgt_ut_cd" style="width:55;" class="input">							
							<option value="KGS">KGS</option>
							<option value="LBS">LBS</option></select>
							<!-- <input name="wgt_ut_cd" type="text" style="width:55;" class="input2" value="" readonly> --> </td>
								<td width="70">Void Space</td>
								<td width=""><input name="ovr_void_slt_qty" type="text" style="width:60;text-align:right;" class="input1" value="">&nbsp;<input type="text" style="width:35;" class="input2" value=" FEU" readOnly></td>
							</tr>
						</table>
						
						
						</td>
						<td width="19">&nbsp;</td>
						<td width="480" valign="top">
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="294">Detail Information For Cargo Sequence&nbsp;<input name="Seq" type="text" style="width:20;" class="input2" value=""></td>
								<td width="102">Break Bulk Term</td>
										<td width=""><select name="rcv_term_cd" style="width:34;">
												<option value="Y">Y</option>
												<option value="D">D</option>
												<option value="S">S</option>
												<option value="T">T</option>							
												<option value="I">I</option>
											</select>&nbsp;
											<select name="de_term_cd" style="width:34;">
												<option value="Y">Y</option>
												<option value="D">D</option>
												<option value="S">S</option>
												<option value="T">T</option>							
												<option value="O">O</option>
											</select></td>
							
							</tr>
						</table>
						
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="70">Commodity</td>
								<td width=""><input name="cmdt_cd" type="text" style="width:55;" class="input1" value="" maxlength="6">&nbsp;<input name="cmdt_nm" type="text" style="width:325;" class="input1" value="" readonly>&nbsp;<img name="btn_cmdt" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="70">Sling Point</td>
								<td width="90" style="padding-left:2;"><select name="slng_pnt_flg" style="width:50;">
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
								<td width="110">Center Of Gravity</td>
								<td width=""><input name="grav_ctr_desc" type="text" style="width:205;" class="input" value=""></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="130">Cargo Packing Detail</td>
								<td width=""><input name="pck_dtl_desc" type="text" style="width:347;" class="input" value=""></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="130">Loading Method</td>
								<td width="120"><select name="cgo_lodg_mzd_cd" style="width:100;" class="input1">
						<option value=""></option>		
						<option value="G">Gantry</option>
						<option value="F">Floating</option>
						<option value="M">Mobile</option>
						<option value="O">Others</option>
						</select></td>
							<!-- <td width="">DG container S/N&nbsp;<input name="bb_dcgo_seq" type="text" style="width:53;" class="input2" value="" readOnly>&nbsp;<img name="dg_container_seq" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" readonly></td> -->
							<td width="110">Load.side</td>
								<td width="">
									<select name="cgo_lodg_sd_cd" style="width:100;" class="input1">
										<option value=""></option>		
										<option value="S">Sea(barge)</option>
										<option value="L">Land</option>
									</select>
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="130">Discharging Method</td>
								<td width="120">
									<select name="cgo_dchg_mzd_cd" style="width:100;" class="input1">
										<option value=""></option>		
										<option value="G">Gantry</option>
										<option value="F">Floating</option>
										<option value="M">Mobile</option>
										<option value="O">Others</option>
									</select>
								</td>
								<td width="110">Disch.side</td>
								<td width="">
									<select name="cgo_dchg_sd_cd" style="width:100;" class="input1">
										<option value=""></option>		
										<option value="S">Sea(barge)</option>
										<option value="L">Land</option>
									</select>
								</td>
							</tr>
						</table>						
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="130">Secure & Dunnage</td>
								<td width=""><input name="scr_dng_ctnt" type="text" style="width:347;" class="input" value=""></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="130">Special Request</td>
								<td width=""><input name="spcl_rqst_desc" type="text" style="width:347;" class="input" value=" "></td>
							</tr>
							<tr class="h23">
								<td width="">Approval Ref. No.</td>
								<td><input name="aply_no" type="text" style="width:347;" class="input" value="" readonly></td>	
							</tr>
						</table>
						<table class="search" border="0" style="width:480;">
							<tr class="h23">
								<td width="130">DG container S/N</td>
								<td width="350"><input name="bb_dcgo_seq" type="text" style="width:53;" class="input2" value="" readOnly>&nbsp;<img name="dg_container_seq" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" readonly></td>
							</tr> 
						</table>
						<table class="search" border="0" style="width:480;"> 
							<tr class="h23">
								<td width="285"></td>
								<td width="95"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_Remark" id="btn_Remark">Remark(s)</td>
												<td class="btn2_right"></td>
												</tr>
								</table></td>
								<td width="130"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
												<td class="btn2" id="btn_RequestCancel" name="btn_RequestCancel">Request Cancel</td>
												<td class="btn2_right"></td>
												</tr>
								</table></td>
							</tr>
						</table>
						
						</td>
					
					</tr>
				</table>
			</td></tr>
			</table>			
				
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
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
						<td class="btn1" name="btn_attach_file" id="btn_attach_file">Attach File</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_terminal_information">Terminal Information</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Request" id="btn_Request">Request</td>
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
		
	<!--biz page (E)-->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>	
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>
	
</form>
</body>
</html>
