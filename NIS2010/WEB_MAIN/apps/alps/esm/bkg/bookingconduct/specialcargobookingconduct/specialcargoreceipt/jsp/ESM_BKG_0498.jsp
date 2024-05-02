<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0498.jsp
*@FileTitle : Reefer Cargo Application
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
 2011.05.11 변종건 [CHM-201110122-01][AK, RF] CNTR#부재상태의 Approval Pending시 CNTR#입력가능
 2012.10.15 조정민 [CHM-201220509] [Special Cargo Application] Email기능 추가 - RF,AK (DG기존재)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0498Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>

<%
	EsmBkg0498Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0498Event)request.getAttribute("Event");
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
<title>RF Cargo Application</title>
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


<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="diff_rmk">
<input type="hidden" name="temp_cntr_no">
<input type="hidden" name="temp_grs_wgt">
<input type="hidden" name="temp_net_wgt">
<input type="hidden" name="cntr_tpsz_cd">
<input type="hidden" name="vessel_nm">
<input type="hidden" name="title_id" value="rf">
<input type="hidden" name="button" value="N">
<input type="hidden" name=kr_flag value="">
<input type="hidden" name=cmdt_flag value="">
<input type="hidden" name=desc_flag value="">
<input type="hidden" name=co_flag value="">

<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="com_content" value="">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>	
	

		<!--biz page-1 (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">BKG No.</td>
					<td width="130"><input type="text" name="bkg_no" style="width:96;" class="input1" value="<%=bkgNo%>">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
					</td>
					<td width="170">B/L No.&nbsp;<input type="text" name="bl_no" style="width:113;" class="input" value=""></td> 
					<td  valign="top" colspan="2">
						<table class="search_sm2" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="">Requested by/Date</td>
							<td width=""><input type="text" name="rqst_usr_id" style="width:90;" class="input2" value="" readOnly></td>
							<td width=""><input type="text" name="rqst_dt" style="width:115;" class="input2" value="" readOnly></td>
							<td width="" class="sm"><input name="rqst_gdt" type="text" style="width:115;" class="input2" value="" readOnly> (GMT)</td>
							<td width="" align="right" colspan="4" >Approval &nbsp;<input name="auth_cd" type="text" style="width:20;" class="input2" value="" readOnly>&nbsp;<img name="btn_approval" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>			
						</tr>
						</table>
						
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr><td colspan="15"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></td></tr>
				<tr class="h23">
					
					<td width="50">T/VVD</td>
					<td width="130"><input name="tvvd" type="text" style="width:110;" class="input2" value="" readOnly></td>
					<td width="20">POL</td>
					<td width="120"><input name="pol_cd" type="text" style="width:45;" class="input2" value="" readOnly>&nbsp;<input name="pol_nod_cd" type="text" style="width:30;" class="input2" value="" readOnly></td>
					<td width="20">POD</td>
					<td width=""><input name="pod_cd" type="text" style="width:45;" class="input2" value="" readOnly>&nbsp;<input name="pod_nod_cd" type="text" style="width:30;" class="input2" value="" readOnly></td>
					
					
				</tr>
				
				</table>
				<!--  biz_2   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			<!--  biz_3  (S) -->
			
						<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="175">Application Total Package</td>
							<td width="185"><input name="package_sum" type="text" style="width:110;text-align:right;" class="input2" value="" readOnly>&nbsp;<input name="pck_type_cd" type="text" style="width:38;" class="input2" value="" readOnly></td>
							<td width="170">Application Total Weight</td>
							<td width=""><input name="weight_sum" type="text" style="width:110;text-align:right;" class="input2" value="" readOnly>&nbsp;<input name="wgt_ut" type="text" style="width:38;" class="input2" value="" readOnly></td></tr>
						</table>
					
						<!--  biz_3   (E) -->
					
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
		<!--biz page-1 (E)-->
	
	
	
		<!-- biz 2,3 - frame (S) -->
		<table class="search"> 
       	<tr><td width="349"  rowspan="2" style="padding-right:10px;" valign="top">
	


				<!-- biz 2 - frame (S) -->
									
						<!-- biz_2-1  (S) -->
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
						<!-- biz_2-1 (E) -->
						
						<table class="height_8"><tr><td></td></tr></table>
						
						<!-- biz_2-2  (S) -->
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
						<!-- biz_2-2 (E) -->
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_add">Row Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_delete">Row Delete</td>
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
						
						
					
				<!-- biz 2 - frame (E) -->
	
			</td>
			<td valign="top">
			
				<!-- biz 3 - frame (S) -->
								
						
				<!-- biz 3 - frame (E) -->
				
			
		
				<table class="height_5"><tr><td></td></tr></table>
				<!-- biz 4 - frame (S) -->
								
						<!--  biz_4  (S) -->
						<table class="search" border="0" style="width:620;"> 
						
						<tr class="h23">
							<td colspan="5">Cargo Detail for Container Sequence&nbsp;<input name="seq" type="text" style="width:30;" class="input2" value="" readOnly></td>
							</tr>
						<tr class="h23">
							<td>Commodity</td>
							<td colspan="4"><input name="cmdt_cd" type="text" style="width:71;text-align:right;" class="input1" value="" maxlength="6">&nbsp;<input name="cmdt_nm" type="text" style="width:333;" class="input2" value="" readonly>&nbsp;<img src="img/btns_search.gif" name="cmdt_button" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
						<tr class="h23">
							<td>Temperature</td>
							<td colspan ="2"><select style="width:35;" class="input1" name="plusMinus1"><option value="+">+</option><option value="-">-</option></select>&nbsp;<input type="text" name="cdo_temp" style="width:40;text-align:right;" class="input1" value="" dataformat="float" pointcount="1" maxlength="4">&nbsp;<input type="text" style="width:22;" class="input2" value="&ordm;C" readOnly>&nbsp;<select style="width:35;" class="input1" name="plusMinus2"><option value="+">+</option><option value="-">-</option></select>&nbsp;<input type="text" name="fdo_temp"style="width:40;text-align:right;" class="input1" value="" dataformat="float" pointcount="1" maxlength="4">&nbsp;<input type="text" style="width:22;" class="input2" value="&ordm;F" readOnly></td>
							<td>Nature</td>
							<td align="right"><select name="clng_tp_cd" style="width:95;" class="input1"><option value=""></option><option value="F">Frozen</option><option value="C" >Chilled</option><option value="S" >Fresh</option></select></td></tr>
						<tr class="h23">
							<td width="115">Ventilation</td>
							<td width="271"><input type="text" name="vent_rto" style="width:61;text-align:right;" class="input1" value="" dataformat="float" pointcount="1" maxlength="4">&nbsp;<select name="cntr_vent_tp_cd" style="width:80;" class="input1"><option value="P">% Open</option><option value="C" >CMH</option></select></td>
							<td width="115">&nbsp;</td>
							<td width="60">Humidity</td>
							<td align="right"><input type="text" name="humid_no" style="width:69;text-align:right;" class="input" value="">&nbsp;<input type="text" style="width:22;" class="input2" value="%" readOnly></td></tr>
						</table>

						
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="search" border="0" style="width:620;"> 
						<tr class="h23">
							<td width="115">Package</td>
							<td width="271"><input type="text" name="pck_qty" style="width:115;text-align:right;" class="input" value="">&nbsp;<input type="text" name="pck_tp_cd" style="width:25;" class="input" value="" maxlength="2">&nbsp;<img src="img/btns_search.gif" name="pck_button" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="" class=""><input type="checkbox" name="ctrl_atms_flg" class="trans">Control Atmosphere (CA)</td>
						</tr>
							
						<tr class="h23">
							<td>Gross Weight</td>
							<td><input type="text" name="grs_wgt" style="width:144;text-align:right;" class="input1" value="" dataformat="float" pointcount="3" maxlength="11">&nbsp;<select name="wgt_ut_cd1" style="width:65;" class="input"><option value="KGS">KGS</option><option value="LBS" >LBS</option></select></td> 
							<td class=""><input type="checkbox" name="modi_atms_flg" class="trans">Modified CA (MA)</td>
						</tr>
							
						<tr class="h23">
							<td>Net Weight</td>
							<td><input type="text" name="net_wgt" style="width:144;text-align:right;" class="input" value="" dataformat="float" pointcount="3" maxlength="11">&nbsp;<input type="text" name="wgt_ut_cd2" style="width:65;" class="input2" value="" readonly></td>
							<td class=""><input type="checkbox" name="humid_ctrl_flg" class="trans">Humidity Control (HM)</td>
						</tr>
						
						<tr class="h23">
							<td></td>
							<td></td>
							<td class=""><input type="checkbox" name="atfc_atms_flg" class="trans">Artificial Atmosphere (AA)</td>
						</tr>
						
						</table>
						
						<table class="search" border="0" style="width:620;"> 
						<tr class="h23">
							<td width="115">DG container S/N</td>
							<td width="280"><input type="text" name="rf_dcgo_seq" style="width:60;text-align:right;" class="input2" value="" readOnly>&nbsp;<img src="img/btns_search.gif" name="dg_container_seq" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="40">Drain</td>
							<td width=""><select name="cntr_drn_cd" style="width:65;" class="input"><option value="N">N/A</option><option value="O" >Open</option><option value="C" >Close</option></select></td></tr>
						<tr class="h23">
						<td width="115">Approval Ref. No.</td>
						<td><input name="aply_no" type="text" style="width:212;" class="input" value="" readonly></td>
						</tr>
						</table>
						

						<!--  biz_4   (E) -->
						
						<table class="search" height=8><tr><td></td></tr></table>
						
						<!--  Button_Sub (S) -->
						<table width="620" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_Remark" id="btn_Remark">Remark(s)</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
			
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" id="btn_RequestCancel" name="btn_RequestCancel">Request&nbsp;Cancel</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>

								
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
				
						
					
				<!-- biz 4 - frame (E) -->
				
				
				
			</td></tr>
						</table>	
			
		<!-- biz 2,3 - frame (E) -->
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
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_email">E-mail</td>
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
	
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>	

<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>
	
</form>
</body>
</html>
