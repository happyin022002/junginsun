<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0018.jsp
*@FileTitle : Reefer CGO Application Details for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.07.13 이도형
* 1.0 Creation
*=========================================================
*History
*2011.01.05 이행지 [CHM-201007766-01] [VO-SCG] 다수 SEQ. REJECT 시 RJT사유 입력 개선요청
*2011.01.12 이행지 [CHM-201108316-01] [SCG] Reject N(all)추가요청
*=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0018Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo 	= StringUtil.xssFilter(request.getParameter("bkg_no"));
	String strVvdCd 	= StringUtil.xssFilter(request.getParameter("vvd_cd"));
	String strCgoSeq 	= StringUtil.xssFilter(request.getParameter("rc_seq"));
	String strRqstSeq 	= StringUtil.xssFilter(request.getParameter("spcl_cgo_apro_rqst_seq"));
	String strRow 		= StringUtil.xssFilter(request.getParameter("row"));
	String strScgFlg	= StringUtil.xssFilter(request.getParameter("scg_flg"));
	String strType		= StringUtil.xssFilter(request.getParameter("type"));
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0018Event)request.getAttribute("Event");
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
<title>Reefer CGO Application Details for Own BKG</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		var toDay = new Date();
	    var year  = toDay.getFullYear();
	    var month = toDay.getMonth() + 1;
	    var day   = toDay.getDate();
	    var hours = toDay.getHours();
	    var minutes = toDay.getMinutes();
	    if(month < 10) month = '0' + month;
	    if(day < 10) day = '0' + day;
	    if(hours < 10) hours = '0' + hours;
	    if(minutes < 10) minutes = '0' + minutes;
	    //var toDays = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes;
	    var toDays = year + '-' + month + '-' + day;
		document.form.auth_usr_id.value = '<%=strUsr_id%>';
		document.form.vvd_cd.value = '<%=strVvdCd%>';
		document.form.vsl_cd.value = '<%=strVvdCd.substring(0,4)%>';
		document.form.skd_voy_no.value = '<%=strVvdCd.substring(4,8)%>';
		document.form.skd_dir_cd.value = '<%=strVvdCd.substring(8,9)%>';
		document.form.auth_dt.value = toDays;
		
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="temp_cntr_no">
<input type="hidden" name="temp_grs_wgt">
<input type="hidden" name="temp_net_wgt">
<input type="hidden" name="cntr_tpsz_cd">

<input type="hidden" name="rc_seq" value="<%=strCgoSeq %>">
<input type="hidden" name="spcl_cgo_apro_rqst_seq" value="<%=strRqstSeq %>">
<input type="hidden" name="row" value="<%=strRow %>">
<input type="hidden" name="scg_flg" value="<%=strScgFlg %>">
<input type="hidden" name="type" value="<%=strType %>">

<input type="hidden" name="bkg_por_cd">
<input type="hidden" name="bkg_por_yd_cd">
<input type="hidden" name="bkg_del_cd">
<input type="hidden" name="bkg_del_yd_cd">
<input type="hidden" name="org_trns_mod_cd">
<input type="hidden" name="dest_trns_mod_cd">

<input type="hidden" name="bkg_pol_cd">
<input type="hidden" name="bkg_pol_yd_cd">
<input type="hidden" name="bkg_pod_cd">
<input type="hidden" name="bkg_pod_yd_cd">

<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="mailYn" value="N">

<input type="hidden" name="org_spcl_cgo_auth_cd">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Reefer CGO Application Details for Own BKG </td></tr>
			</table>
			<!-- : ( Title ) (E) -->
	
			<!--biz page-1 (S)-->
			<table class="search"> 
		       	<tr>
		       		<td class="bg">
				 		<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="" valign="top">
									<!--  biz_1  (S) -->
									<table class="search" border="0" style="width:570;"> 
										<tr class="h23">
											<td width="50">BKG No.</td>
											<td width="112"><input type="text" name="bkg_no" style="width:100;" class="input2" readOnly value="<%=strBkgNo %>"></td>
											<td width="50">B/L No.</td>
											<td width=""><input type="text" name="bl_no" style="width:100;" class="input2" readOnly value=""></td> 
										</tr>
									</table>
				
									<table class="search" border="0" style="width:570;"> 
										<tr class="h23">
											<td width="50">VVD CD</td>
											<td width="112"><input type="text" name="vvd_cd" style="width:100;" class="input2" readOnly value=""></td>
											<td width="50" align="right">POL&nbsp;</td>
											<td width="85"><input type="text"  name="pol_cd" style="width:50;" class="input2" readOnly value="">&nbsp;<input type="text" name="pol_nod_cd" style="width:25;" class="input2" readonly value=""></td>
											<td width="20" align="left">
												<!-- table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_PolCd">Info.</td>
														<td class="btn2_right"></td>
													</tr>
												</table-->
											</td>
											<td width="27">POD</td>
											<td width="86"><input type="text"  name="pod_cd" style="width:50;" class="input2" readOnly value="">&nbsp;<input type="text" name="pod_nod_cd" style="width:25;" class="input2" readonly value=""></td>
											<!-- td width="" align="left">
												<table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_PodCd">Info.</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td-->
											<td width="140" align="left"></td>
										</tr>
									</table>
									<!--  biz_1   (E) -->
								</td>
								<td width="">
									<!--  biz_2  (S) -->
									<table class="search" border="0" style="width:409;"> 
										<tr class="h23">
											<td width="63">BKG.Staff</td>
											<td width="230">
												<input type="text" name="rqst_usr_nm" style="width:150;" class="input2" readOnly value="">
												<input type="text" name="rqst_usr_id" style="width:65;" class="input2" readonly value="">
											</td>
											<td width="65">BKG.Office</td>
											<td width=""><input type="text" name="rqst_ofc_cd" style="width:50;" class="input2" readOnly value=""></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:409;"> 
										<tr class="h23">
											<td width="145">Requested Date (GMT)</td>
											<td width=""><input type="text" name="rqst_gdt" style="width:111;" class="input2" readOnly value=""></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:409;"> 
										<tr class="h23">
											<td width="25">Tel.</td>
											<td width="140"><input type="text" name="rqst_usr_phn_no" style="width:120;" class="input2" readOnly value=""></td>
											<td width="43">E-mail</td>
											<td width=""><input type="text" name="rqst_usr_eml" style="width:100%;" class="input2" readOnly value=""></td>
										</tr>
									</table>
									<!--  biz_2   (E) -->
								</td>
							</tr>
						</table>
	
						<table class="line_bluedot"><tr><td></td></tr></table>
						<!--biz page-1 (E)-->
	
						<!-- biz 2,3,4 - frame (S) -->
						<table class="search"> 
					       	<tr>
					       		<td width="309" rowspan="2" style="padding-right:10px;" valign="top">
									<!-- biz 2 - frame (S) -->
									<!-- biz_2-1  (S) -->
									<table width="100%" class="search"  id="mainTable"> 
										<tr>
											<td width="100%">
											<script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table>  
									<!-- biz_2-1 (E) -->
									
									<table class="height_8"><tr><td></td></tr></table>
									
									<!-- biz_2-2  (S) -->
									<table width="100%" class="search"  id="mainTable"> 
										<tr>
											<td width="100%">
											<script language="javascript">ComSheetObject('sheet2');</script>
											</td>
										</tr>
									</table> 						
									<!-- biz_2-2 (E) -->
									
									<!--Grid (S)-->
									<table width="100%" class="search"  id="mainTable" > 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet3');</script>
											</td>
										</tr>
									</table>
									<!--Grid (E)-->
									
									<!--Grid (S)-->
									<table width="100%" class="search"  id="mainTable" > 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet4');</script>
											</td>
										</tr>
									</table>
									<!--Grid (E)-->
									<!-- biz 2 - frame (E) -->	
								</td>
								<td valign="top">
									<!-- biz 3 - frame (S) -->
									<!--  biz_3  (S) -->
									<table class="search" border="0" style="width:660;"> 
										<tr class="h23">
											<td width="175">Application Total Package</td>
											<td width="170"><input type="text" name="package_sum" style="width:75; text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" name="pck_type_cd" style="width:25;text-align:center;" class="input2" readonly value=""></td>
											<td width="170">Application Total Weight</td>
											<td width="" align="right"><input type="text" name="weight_sum" style="width:120; text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" name="wgt_ut" style="width:35;text-align:center;" class="input2" readonly value=""></td>
										</tr>
									</table>
									<table class="line_bluedot"><tr><td></td></tr></table>
									<table class="search" border="0" style="width:660;"> 
										<tr class="h23">
											<td>Cargo Detail for Container Sequence &nbsp; &nbsp; &nbsp;<input type="text" name="seq" style="width:25;text-align:center;" class="input2" readOnly value="<%=strCgoSeq %>"></td>
										</tr>
									</table>
									<!--  biz_3   (E) -->					
									<!-- biz 3 - frame (E) -->
								</td>
							</tr>
							<tr>
								<td valign="top">		
									<!-- biz 4 - frame (S) -->
									<!--  biz_4  (S) -->
									<table class="search" border="0" style="width:660;"> 
										<tr class="h23">
											<td width="115">Commodity</td>
											<td colspan="4">
												<input type="text" name="cmdt_cd" style="width:50;" class="input2" readOnly value="">
												<input type="text" name="cmdt_nm" style="width:355;" class="input2" readOnly value="">
												<img src="img/btns_search.gif" name="btns_Commodity" width="19" height="20" border="0" align="absmiddle" class="cursor">
											</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:660;"> 
										<tr class="h23">
											<td>Temperature</td>
											<td>
												<input type="text" name="cdo_temp" style="width:40; text-align:right;" class="input2" readOnly value="">&nbsp;&deg;C&nbsp;&nbsp;&nbsp;
												<input type="text" name="fdo_temp" style="width:40; text-align:right;" class="input2" readOnly value="">&nbsp;&deg;F
											</td>
											<td>Nature</td>
											<td>
												<select name="clng_tp_cd" style="width:93;" class="input2" disabled >
													<option value="" ></option>
													<option value="S" >Fresh</option>
													<option value="C" >Chilled</option>
													<option value="F" >Frozen</option>
												</select>
											</td>
										</tr>
										<tr class="h23">
											<td width="115">Ventilation</td>
											<td width="280">
												<input type="text" name="vent_rto" style="width:55; text-align:right;" class="input2" readonly value="">
												<select name="cntr_vent_tp_cd" style="width:79;" class="input2" disabled>
													<option value="" ></option>
													<option value="P" >% Open</option>
													<option value="C" >CMH</option>
												</select>
											</td>
											<td width="60">Humidity</td>
											<td><input type="text" name="humid_no" style="width:69; text-align:right;" class="input2" readonly value="">&nbsp;%</td>
										</tr>
									</table>
							
									<table class="search" border="0" style="width:660;"> 
										<tr class="h23">
											<td width="115">Package</td>
											<td width="271">
												<input type="text" name="pck_qty" style="width:55; text-align:right;" class="input2" readonly value="">
												<input type="text" name="pck_tp_cd" style="width:35;text-align:center;" class="input2" readonly value="">
												<img src="img/btns_search.gif" name="btns_Package" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
											</td>
											<td width="" class=""><input type="checkbox" name="ctrl_atms_flg" class="trans" disabled>Control Atmosphere (CA)</td>
										</tr>
										<tr class="h23">
											<td>Gross Weight</td>
											<td>
												<input type="text" name="grs_wgt" style="width:144; text-align:right;" class="input2" readonly value="">
												<select name="wgt_ut_cd1" style="width:65;" class="input2" disabled>
													<option value="" ></option>
													<option value="KGS" >KGS</option>
													<option value="LBS" >LBS</option>
												</select>
											</td> 
											<td class=""><input type="checkbox" name="modi_atms_flg" class="trans" disabled>Modified CA (MA)</td>
										</tr>
										<tr class="h23">
											<td>Net Weight</td>
											<td>
												<input type="text" name="net_wgt" style="width:144; text-align:right;" class="input2" readonly value="">
												<select name="wgt_ut_cd2" style="width:65;" class="input2" disabled>
													<option value="" ></option>
													<option value="KGS" >KGS</option>
													<option value="LBS" >LBS</option>
												</select>
											</td>	
											<td class=""><input type="checkbox" name="humid_ctrl_flg" class="trans" disabled>Humidity Control (HM)</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:660;"> 
										<tr class="h23">
											<td width="115">DG container S/N</td>
											<td width="110">
												<input type="text" name="rf_dcgo_seq" style="width:65; text-align:right;" class="input2" readonly value="">
												<img src="img/btns_search.gif" name="btns_DgCntrSeq" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
											</td>
											<td width="38">Drain</td>
											<td width="">
												<select name="cntr_drn_cd" style="width:65;" class="input2" disabled>
													<option value="" ></option>
													<option value="N" >N/A</option>
													<option value="O" >Open</option>
													<option value="C" >Close</option>
												</select>
											</td>
										</tr>
									</table>
									<!--  biz_4   (E) -->
									<!--  Button_Sub (S) -->
									<table width="660" class="search"> 
							       		<tr class="h23">
							       			<td width="115" >Remark(s)</td>
											<td><input type="text" name="diff_rmk" style="width:100%;" class="input2" readonly value=""></td>						
										</tr>
									</table>
							    	<!-- Button_Sub (E) -->
									<!-- biz 4 - frame (E) -->
								</td>
							</tr>
						</table>
						<!-- biz 2,3,4 - frame (E) -->
						<!--biz page-5 (S)-->
						<table class="line_bluedot"><tr><td height="20"></td></tr></table>		
						<!--  biz_5  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="110">Approval by</td>
								<td width="135"><input type="text" name="auth_usr_id" style="width:100;" class="input1" readonly value=""></td>
								<td width="70">Date (GMT)</td>
								<td width="" colspan="2"><input type="text" name="auth_dt" style="width:80;" class="input1" readonly value=""></td> 
							</tr>
							<tr class="h23">
								<td width="">Approval</td>
								<td width=""><select name="spcl_cgo_auth_cd" style="width:100;" class="input1" style="font-weight:bold;">
									<option value="Y" style="color:green;">Y</option>
									<option value="A" style="color:green;">Y(all)</option>
									<option value="N" style="color:red;">N</option>
                                    <option value="M" style="color:red;">N(all)</option>
									<option value="P" style="color:blue;">P</option>
									<option value="" style="color:orange;"></option>
									</select></td>
								<td width="">RJT Code</td>
								<td width="100" style="padding-left:2;"> 
									<script language="javascript">ComComboObject('spcl_cgo_auth_rjct_cd', 2, 80, 0, 2);</script>								
								</td>
								<td width="70">Remark(s)</td>
								<td><input type="text" name="spcl_cgo_auth_rmk" style="width:100%;" class="input" value=""></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="110">Approval Ref. No.</td>
								<td><input type="text" name="apro_ref_no" style="width:378;" class="input2" value="" maxlength="50" disabled></td>
							</tr>	
						</table>
						<!--  biz_5   (E) -->							
						<!--biz page-5 (E)-->
					</td>
				</tr>
			</table>	
		</td>
	</tr>
</table>
<table class="height_5"><tr><td></td></tr></table>

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr>
		       		<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_ApprovalDetails">Approval Details</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td width="">
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Mail">Mail</td>
											<td class="btn1_right"></td>
									</tr>
									</table>
								</td>
								<td width="">
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Prev">Prev.</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td width="">
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Next">Next</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td width="">
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					    <!--Button (E) -->	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>