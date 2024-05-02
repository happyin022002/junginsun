<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0016.jsp
*@FileTitle : Awkward CGO Application Details for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.06 이도형
* 1.0 Creation
*=========================================================
*History
*2011.01.05 이행지 [CHM-201007766-01] [VO-SCG] 다수 SEQ. REJECT 시 RJT사유 입력 개선요청
*2011.01.12 이행지 [CHM-201108316-01] [SCG] Reject N(all)추가요청
*2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가
*2012.12.17 진마리아 [CHM-201221870-01] [VOP-SCG] AWK application special stowage 수정 
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
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0016Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strBkgNo 	= StringUtil.xssFilter(request.getParameter("bkg_no"));
	String strVvdCd 	= StringUtil.xssFilter(request.getParameter("vvd_cd"));
	String strCgoSeq 	= StringUtil.xssFilter(request.getParameter("awk_cgo_seq"));
	String strRqstSeq 	= StringUtil.xssFilter(request.getParameter("spcl_cgo_apro_rqst_seq"));
	String strRow 		= StringUtil.xssFilter(request.getParameter("row"));
	String strScgFlg	= StringUtil.xssFilter(request.getParameter("scg_flg"));
	String strType		= StringUtil.xssFilter(request.getParameter("type"));
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopScg0016Event)request.getAttribute("Event");
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
<title>Awkward CGO Application Details for Own BKG</title>
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
		document.form.auth_dt.value = toDays;
		
		loadPage(); 
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" onUnLoad="win_close();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="frm_awk_cgo_seq" value="">
<input type="hidden" name="temp_cntr_no" value="">
<input type="hidden" name="cntr_tpsz_cd" value="">

<input type="hidden" name="temp_grs_wgt" value="">
<input type="hidden" name="temp_net_wgt" value="">
<input type="hidden" name="title_id" value="awk">

<input type="hidden" name="awk_cgo_seq" value="<%=strCgoSeq %>">
<input type="hidden" name="spcl_cgo_apro_rqst_seq" value="<%=strRqstSeq %>">
<input type="hidden" name="row" value="<%=strRow %>">
<input type="hidden" name="scg_flg" value="<%=strScgFlg %>">
<input type="hidden" name="type" value="<%=strType %>">

<input type="hidden" name="mailYn" value="N">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Awkward CGO Application Details for Own BKG  </td></tr>
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
											<td width="120"><input type="text" name="bkg_no" style="width:100;" class="input2" readOnly value="<%=strBkgNo %>"></td>
											<td width="115">Booking Combine</td>
											<td width=""><input type="text" name="bkg_combine" style="width:235;" class="input2" readOnly value=""></td> 
										</tr>
									</table>
									
									<table class="search" border="0" style="width:570;"> 
										<tr class="h23">
											<td width="50">B/L No.</td>
											<td width="120"><input type="text" name="bl_no" style="width:100;" class="input2" readOnly value=""></td> 
											<td width="115">Booking Split</td>
											<td width=""><input type="text" name="bkg_split" style="width:235;" class="input2" readOnly value=""></td>
										</tr>
									</table>
				
									<table class="search" border="0" style="width:570;"> 
										<tr class="h23">
											<td width="50">VVD CD</td>
											<td width="112"><input type="text" name="vvd_cd" style="width:100;" class="input2" readonly value=""></td>
											<td width="50" align="right">POL&nbsp;</td>
											<td width="85"><input type="text"  name="pol_cd" style="width:50;" class="input2" readonly value="">&nbsp;<input type="text" name="pol_nod_cd" style="width:25;" class="input2" readonly value=""></td>
											<td width="62" align="left">
												<table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_PolCd">Info.</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td width="27">POD</td>
											<td width="86"><input type="text"  name="pod_cd" style="width:50;" class="input2" readonly value="">&nbsp;<input type="text" name="pod_nod_cd" style="width:25;" class="input2" readonly value=""></td>
											<td width="" align="left">
												<table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_PodCd">Info.</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
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
	
						<!--biz page-1 (E)-->
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="150">Awkward Total Package</td>
								<td width="80"><input type="text" name="package_sum" style="width:35;text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" name="pck_tp_cd" style="width:25;text-align:center;" class="input2" readonly value=""></td>
								<td width="145">Awkward Total Weight</td>
								<td width=""><input type="text" name="weight_sum" style="width:100;text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" name="wgt_ut_cd" style="width:35;text-align:center;" class="input2" readonly value=""></td>
							</tr>
						</table>
					
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
						<!-- biz 2,3,4 - frame (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="230" valign="top">
								<!-- biz 2 - frame (S) -->
									<!-- biz_2-1  (S) -->
									<table width="220" class="search"  id="mainTable"> 
										<tr>
											<td width="220">
												<script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table> 
									<!-- biz_2-1 (E) -->
									<table class="height_8"><tr><td></td></tr></table>
									<!-- biz_2-2  (S) -->
									<table width="220" class="search"  id="mainTable"> 
										<tr>
											<td width="220">
												<script language="javascript">ComSheetObject('sheet2');</script>
											</td>
										</tr>
									</table>  
									<!-- biz_2-2 (E) -->
									<!--Grid (S)-->
									<table width="0"  id="mainTable">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet3');</script>
											</td>
										</tr>
									</table>
									<!--Grid (E)-->
									<!--Grid (S)-->
									<table width="100"  id="mainTable">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet4');</script>
											</td>
										</tr>
									</table>
									<!--Grid (E)-->
									<!--Grid (S)-->
									<table width="0"  id="mainTable">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet5');</script>
											</td>
										</tr>
									</table>
									<!--Grid (E)-->
									<!--Grid (S)-->
									<table width="0"  id="mainTable">
										<tr>
											<td width="0">
												<script language="javascript">ComSheetObject('sheet6');</script>
											</td>
										</tr>
									</table>
									<!--Grid (E)-->									
								</td>
								<!-- biz 2 - frame (E) -->	

								<td width="749" valign="top">
	
									<!-- biz 3 - frame (S) -->
									<!--  biz_3  (S) -->
									<table class="search" border="0" style="width:749;"> 
										<tr class="h23">
											<td width="226">Cargo Detail for Container Sequence</td>
											<td width="320"><input type="text" name="frm_seq" style="width:25;text-align:center;" class="input2" readonly value=""></td>
											<td width="102">Awkward Term</td>
											<td width="">
												<select name="rcv_term_cd" style="width:35;" class="input2" disabled>
													<option value="D">D</option>
													<option value="I">I</option>
													<option value="S">S</option>
													<option value="T">T</option>							
													<option value="Y">Y</option>							
												</select>
												<select name="de_term_cd" style="width:35;" class="input2" disabled>						
													<option value="D">D</option>
													<option value="O">O</option>
													<option value="S">S</option>
													<option value="T">T</option>							
													<option value="Y">Y</option>
												</select>
											</td> 
										</tr>
									</table>
									<!--  biz_3   (E) -->					
									<!-- biz 3 - frame (E) -->
								
									<!-- biz 4 - frame (S) -->
									<!--  biz_4  (S) -->
									<table class="search" border="0" style="width:749;"> 
										<tr class="h23">
											<td width="74">Package</td>
											<td width="150"><input type="text" name="frm_pck_qty" style="width:50; text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" name="frm_pck_tp_cd" style="width:25;text-align:center;" class="input2" readonly value="">&nbsp;<img src="img/btns_search.gif" name="btns_Package" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
											<td width="92">Gross Weight</td>
											<td width="200"><input type="text" name="frm_grs_wgt" style="width:90; text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" name="wgt_ut_cd1" style="width:35; text-align:center;" class="input2" readonly value=""></td> 
											<td width="78">Net Weight</td>
											<td style="padding-left:1;"><input type="text" name="frm_net_wgt" style="width:88; text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" name="wgt_ut_cd2" style="width:35; text-align:center;" class="input2" readonly value=""></td>
										</tr>
									</table>
						
									<table class="search" border="0" style="width:749;"> 
										<tr class="h23">
											<td width="74">Commodity</td>
											<td width="406"><input type="text" name="frm_cmdt_cd" style="width:50; text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" name="frm_cmdt_nm" style="width:278;" class="input2" readonly value="">&nbsp;<img src="img/btns_search.gif" name="btns_Commodity" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
											<td width="115">DG container S/N</td>
											<td width="" style="padding-left:0;"><input type="text" name="frm_cntr_cgo_seq" style="width:60; text-align:right;" class="input2" readonly value="">&nbsp;<img src="img/btns_search.gif" name="btns_DgCntrSeq" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
										</tr>
									</table>
						
									<table class="search" border="0" style="width:749;"> 
										<tr class="h23">
											<td width="400" colspan="2" rowspan="5" style="padding:8,10,8,0;">
							
												<!-- dimention info(s) -->
												<table border="0" style="width:400; background-color:white;" class="grid2"> 
													<tr class="tr2_head">
														<td colspan="6">Dimension Information (unit : cm)</td>
														<td rowspan="3" colspan="2" align="left" style="background-color:#f3f2f8; border-right:1px solid #f3f2f8; border-top:1px solid #f3f2f8; padding-left:10;">
															<br><br><br>
															<br style="font-size:1px;">
															<input type="checkbox" name="dgFlag" class="trans" disabled>D/G BKG	
															<input type="checkbox" name="inGauge" class="trans" disabled>In Gauge										
														</td>
													</tr>
													<tr class="tr2_head2">
														<td width=""></td>
														<td width="" colspan="2">Length</td> 
														<td width="" colspan="2">Width</td>
														<td width="">Height</td> 
													</tr>
													<tr>
														<td class="tr2_head2">Total Dimension</td>
														<td class="input2" align="right" colspan="2"><input name="ttl_dim_len" type="text" style="width:80;text-align:right;border:0" class="input2" readonly value="" ></td> 
														<td class="input2" align="right" colspan="2"><input name="ttl_dim_wdt" type="text" style="width:80;text-align:right;border:0" class="input2" readonly value="" ></td>
														<td class="input2" align="right"><input name="ttl_dim_hgt" type="text" style="width:39;text-align:right;border:0" class="input2" readonly value="" ></td> 
													</tr>
													<tr class="tr2_head2">
														<td width="" rowspan="2">Over Dimension</td>
														<td width="">Front</td> 
														<td width="">Rear</td> 
														<td width="">Left</td>
														<td width="">Right</td> 
														<td width="">Height</td> 
														<td width="" colspan="2">Void Space</td>
													</tr>
													<tr>
														<td width="11%" class="input2" align="right"><input name="ovr_fwrd_len" type="text" style="width:37;text-align:right;border:0"  class="input2" readonly value="" ></td> 
														<td width="11%" class="input2" align="right"><input name="ovr_bkwd_len" type="text" style="width:37;text-align:right;border:0" class="input2" readonly value="" ></td> 
														<td width="11%" class="input2" align="right"><input name="ovr_lf_len" type="text" style="width:37;text-align:right;border:0" class="input2" readonly value="" ></td> 
														<td width="11%" class="input2" align="right"><input name="ovr_rt_len" type="text" style="width:37;text-align:right;border:0" class="input2" readonly value="" ></td> 
														<td width="11%" class="input2" align="right"><input name="ovr_hgt" type="text" style="width:37;text-align:right;border:0" class="input2" readonly value="" ></td> 
														<td width="11%" class="input2" align="right"><input name="ovr_void_slt_qty" type="text" style="width:50;text-align:right;border:0" class="input2" readonly value="" ></td>
														<td width="11%" class="input2" align="center" class="tr2_head2">FEU</td>
													</tr>
												</table>
												<!-- dimention info(s) -->
												<!--  Button_Sub (S) -->
												<table width="400" class="button"> 
											       	<tr>
											       		<td class="btn2_bg">
															<table border="0" cellpadding="0" cellspacing="0">
																<tr>
																	<td>
																		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																			<tr>
																				<td class="btn2_left"></td>
																				<td class="btn2" name="btn_Criteria">Criteria</td>
																				<td class="btn2_right"></td>
																			</tr>
																		</table>
																	</td>
																	<td>
																		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																			<tr>
																				<td class="btn2_left"></td>
																				<td class="btn2" id="details_button" name="btn_Details">Details</td>
																				<td class="btn2_right"></td>
																			</tr>
																		</table>
																	</td>
																	<!-- td>
																		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																			<tr>
																				<td class="btn2_left"></td>
																				<td class="btn2" name="">Convert Inch to cm</td>
																				<td class="btn2_right"></td>
																			</tr>
																		</table>
																	</td-->																
																</tr>
															</table>
														</td>
													</tr>
												</table>
										    	<!-- Button_Sub (E) -->							
											</td>
											<td align="right">Corner Post Status&nbsp;</td>
											<td style="padding-left:2;">
												<select name="crn_pst_sts_cd" style="width:148;" class="input2" disabled>
													<option value="1" >1 Feet Extension</option>
													<option value="2" >2 Feet Extension</option>
													<option value="3" >3 Feet Extension</option>
													<option value="4" >4 Feet Extension</option>
													<option value="5" >5 Feet Extension</option>
													<option value="E">Erect-No Extension</option>
													<option value="F">FOLDING</option>
												</select>
											</td>
										</tr>
										<tr class="h23">
											<td width="175">Over Height after Extension</td>
											<td><input type="text" name="frm_xtd_ovr_qty" style="width:148;" class="input2" readonly value=""></td>
										</tr>
										<tr class="h23">
											<td align="right">Post Lock Pin&nbsp;</td>
											<td style="padding-left:2;">
												<select name="pst_lck_pin_flg" style="width:148;" class="input2" disabled>
													<option value="Y">Engage</option>
													<option value="N" >No</option>
												</select>
											</td>
										</tr>
										<tr class="h23">
											<td align="right">Gravity Center&nbsp;</td>
											<td><input name="frm_grav_ctr_desc" type="text" style="width:148;" class="input2" readonly value="" maxlength="50"></td>
										</tr>
									</table>
									<!--  biz_4   (E) -->
						
									<!--  Button_Sub (S) -->
									<table width="749" class="search"> 
										<tr class="h23">
											<td width="120">Stowage Request&nbsp;</td>
											<td width="230"><input type="text" name="stwg_cd" style="width:210;" class="input2" readonly value=""></td>
											<td width="175">Stowage Request(Remark)&nbsp;</td>
											<td width="215"><input type="text" name="stwg_rqst_desc" style="width:210;" class="input2" readonly value=""></td>
										</tr>
									</table>
									<table width="749" class="search">
							       		<tr class="h23">
											<td width="120">Remark(s)&nbsp;</td>
											<td width="500"><input type="text" name="diff_rmk" style="width:480;" class="input2" readonly value=""></td>									
											<td width="120">
												<table width="118" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_AttachedFile" name="btn_AttachedFile">Attached File</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
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
								<td width="135"><input type="text" name="auth_usr_id" style="width:109;" class="input1" readonly value=""></td>
								<td width="70">Date (GMT)</td>
								<td width="" colspan="2"><input type="text" name="auth_dt" style="width:80;" class="input1" readonly value=""></td> 
							</tr>
							<tr class="h23">
								<td width="">Approval</td>
								<td width=""><select name="spcl_cgo_auth_cd" style="width:109;" class="input1" style="font-weight:bold;">
									<option value="Y" style="color:green;">Y</option>
									<option value="A" style="color:green;">Y(all)</option>
									<option value="N" style="color:red;">N</option>
                                    <option value="M" style="color:red;">N(all)</option>
									<option value="P" style="color:blue;">P</option>
									<option value="" style="color:orange;"></option>
									</select>
								</td>
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
<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>
	
	
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