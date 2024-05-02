<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0017.jsp
*@FileTitle : Break-Bulk CGO Application Details for Own BKG
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
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0017Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	String strCgoSeq 	= StringUtil.xssFilter(request.getParameter("bb_cgo_seq"));
	String strRqstSeq 	= StringUtil.xssFilter(request.getParameter("spcl_cgo_apro_rqst_seq"));
	String strRow 		= StringUtil.xssFilter(request.getParameter("row"));
	String strScgFlg	= StringUtil.xssFilter(request.getParameter("scg_flg"));
	String strType		= StringUtil.xssFilter(request.getParameter("type"));
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0017Event)request.getAttribute("Event");
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
<title>Break-Bulk CGO Application Details for Own BKG</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bb_cgo_seq" value="<%=strCgoSeq %>">
<input type="hidden" name="spcl_cgo_apro_rqst_seq" value="<%=strRqstSeq %>">
<input type="hidden" name="row" value="<%=strRow %>">
<input type="hidden" name="scg_flg" value="<%=strScgFlg %>">
<input type="hidden" name="type" value="<%=strType %>">

<input type="hidden" name="temp_cntr_no">
<input type="hidden" name="cntr_tpsz_cd">
<input type="hidden" name="temp_grs_wgt">
<input type="hidden" name="temp_net_wgt">

<input type="hidden" name="mailYn" value="N">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Break-Bulk CGO Application Details for Own BKG </td></tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!--biz page (S)-->
			<table class="search"> 
		       	<tr>
		       		<td class="bg">
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="" valign=""top>
									<!--  biz_1  (S) -->
									<table class="search" border="0" style="width:570;"> 
										<tr class="h23">
											<td width="50">BKG No.</td>
											<td width="112"><input type="text" name="bkg_no" style="width:100;" class="input2" readonly value="<%=strBkgNo %>"></td>
											<td width="50">B/L No.</td>
											<td width=""><input type="text" name="bl_no" style="width:100;" class="input2" readonly value=""></td> 
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
												<!--  biz_2_1_2  (E) -->
											</td>
										</tr>
									</table>
									<!--  biz_2_1  (E) -->
									<table class="height_8"><tr><td></td></tr></table>
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
									<table class="height_2"><tr><td></td></tr></table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="80">Total Weight</td>
											<td width="230"><input type="text" name="weight_sum" style="width:120;text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" name="wgt_ut_cd" style="width:35;text-align:center;" class="input2" readonly value=""></td>
											<td width="70">Void Space</td>
											<td width=""><input type="text" name="ovr_void_slt_qty" style="width:60;text-align:right;" class="input2" readonly value="">&nbsp;<input type="text" style="width:35;text-align:center;" class="input2" readonly value="FEU"></td>
										</tr>
									</table>
									<!--  biz_2_2  (E) -->
								</td>
								<td width="19">&nbsp;</td>
								<td width="480" valign="top">
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="">Detail Information For Cargo Sequence&nbsp;<input type="text" name="Seq" style="width:20;text-align:center;" class="input2" readonly value=""></td>
											<td width="110">Break Bulk Term</td>
											<td width="">
												<select name="rcv_term_cd" style="width:40;" class="input2" disabled>
													<option value="" ></option>
													<option value="D">D</option>
													<option value="I">I</option>
													<option value="S">S</option>
													<option value="T">T</option>							
													<option value="Y">Y</option>
												</select>&nbsp;
												<select name="de_term_cd" style="width:40;" class="input2" disabled>
													<option value="" ></option>
													<option value="D">D</option>
													<option value="O">O</option>
													<option value="S">S</option>
													<option value="T">T</option>							
													<option value="Y">Y</option>
												</select>
											</td> 
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="80">Commodity</td>
											<td width="">
												<input type="text" name="cmdt_cd" style="width:50;" class="input2" readonly value="">
												<input type="text" name="cmdt_nm" style="width:318;" class="input2" readonly value="">
												<img src="img/btns_search.gif" name="btns_Commodity" class="cursor" width="19" height="20" border="0" align="absmiddle">
											</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="80">Sling Point</td>
											<td width="80">
												<select name="slng_pnt_flg" style="width:50;" class="input2" disabled>
													<option value="" ></option>
													<option value="Y">Y</option>
													<option value="N">N</option>
												</select>
											</td>
											<td width="110">Center Of Gravity</td>
											<td width=""><input type="text" name="grav_ctr_desc" style="width:207;" class="input2" readonly value=""></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="130">Cargo Packing Detail</td>
											<td width=""><input type="text" name="pck_dtl_desc" style="width:347;" class="input2" readonly value=""></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="130">Loading Method</td>
											<td width="110" style="padding-left:0;">
												<select name="cgo_lodg_mzd_cd" style="width:100;" class="input2" disabled>
													<option value="" ></option>
													<option value="G" style="color:black;">Gantry</option>
													<option value="F">Floating</option>
													<option value="M">Mobile</option>
													<option value="O">Others</option>
												</select>
											</td>
											<td width="130" align="right">Load.side&nbsp;</td>
											<td width="110" style="padding-left:0;">
												<select name="cgo_lodg_sd_cd" style="width:100;" class="input2" disabled>
													<option value="" ></option>
													<option value="S">Sea(barge)</option>
													<option value="L">Landing</option>
												</select>				
											</td>
											<!-- <td style="width:150;text-align:right;">DG container S/N</td>
											<td width="">&nbsp;
												<input name="bb_dcgo_seq" type="text" style="width:53;" class="input2" readonly value="">
												<img name="btns_DgCntrSeq" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
											</td> -->
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
									       <td width="130">Discharging Method</td>
											<td width="110" style="padding-left:0;">
												<select name="cgo_dchg_mzd_cd" style="width:100;" class="input2" disabled>
													<option value="" ></option>
													<option value="G">Gantry</option>
													<option value="F">Floating</option>
													<option value="M">Mobile</option>
													<option value="O">Others</option>
												</select>
											</td> 
											<td width="130" align="right">Disch.side&nbsp;</td>
											<td width="110" style="padding-left:0;">
												<select name="cgo_dchg_sd_cd" style="width:100;" class="input2" disabled>
													<option value="" ></option>
													<option value="S">Sea(barge)</option>
													<option value="L">Landing</option>
												</select>				
											</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="130">DG container S/N</td>
											<td width="">
												<input name="bb_dcgo_seq" type="text" style="width:53;" class="input2" readonly value="">
												<img name="btns_DgCntrSeq" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
											</td>
										</tr>
									</table>
									
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="130">Secure & Dunnage</td>
											<td width=""><input type="text" name="scr_dng_ctnt" style="width:347;" class="input2" readonly value=""></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="130">Special Request</td>
											<td width=""><input type="text" name="spcl_rqst_desc" name="scr_dng_ctnt" style="width:347;" class="input2" readonly value=""></td>
										</tr>
									</table>
									
									<table width="480" class="search"> 
							       		<tr class="h23">
							       			<td width="80">Remark(s)</td>
											<td><input type="text" name="diff_rmk" style="width:100%;" class="input2" readonly value=""></td>									
										</tr>
									</table>
									
									<!--  Button_Sub (S) -->
							
							    	<!-- Button_Sub (E) -->						
									<table width="100%" class="button"> 
										<tr>
											<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_AttachedFile" id="btn_AttachedFile">Attached File</td>
																	<td class="btn2_right"></td>
																</tr>
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
						<!--  biz_2  (E) -->
						<!--biz page-5 (S)-->
						<table class="line_bluedot"><tr><td height="20"></td></tr></table>
			       		<!--  biz_3 (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="110">Approval by</td>
								<td width="135"><input type="text" name="auth_usr_id" style="width:91;" class="input1" readonly value=""></td>
								<td width="70">Date (GMT)</td>
								<td width="" colspan="2"><input type="text" name="auth_dt" style="width:80;" class="input1" readonly value=""></td> 
							</tr>
							<tr class="h23">
								<td width="">Approval</td>
								<td width=""><select name="spcl_cgo_auth_cd" style="width:91;" class="input1" style="font-weight:bold;">
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
						<!--  biz_3   (E) -->	
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