<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_1022.jsp
*@FileTitle : Dangerous CGO Application Details for Partner Lines
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.26 김현욱
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg1022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg1022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows111  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.PartnerLinesDangerousCargoApproval");
	
	String pop_mode       = "";
	
	String rgn_shp_opr_cd = "";
	String cgo_opr_cd 	  = "";
	String bkg_ref_no	  = "";
	String vsl_cd         = "";
	String skd_voy_no     = "";
	String skd_dir_cd     = "";
	String crr_cd         = "";
	String spcl_cgo_rqst_seq = "";
	String slan_cd           = "";
	String pol_cd            = "";
	String eta_dt            = "";
	String pod_cd            = "";
	
	String spcl_cntr_seq     = "";
	String spcl_cgo_seq      = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg1022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		pop_mode          = StringUtil.xssFilter(request.getParameter("mode"             ))==null?"":StringUtil.xssFilter(request.getParameter("mode"             ));
		
		rgn_shp_opr_cd    = StringUtil.xssFilter(request.getParameter("rgn_shp_opr_cd"   ))==null?"":StringUtil.xssFilter(request.getParameter("rgn_shp_opr_cd"   ));
		cgo_opr_cd 	 	  = StringUtil.xssFilter(request.getParameter("cgo_opr_cd" 	    ))==null?"":StringUtil.xssFilter(request.getParameter("cgo_opr_cd"       ));
		bkg_ref_no	      = StringUtil.xssFilter(request.getParameter("bkg_ref_no" 	    ))==null?"":StringUtil.xssFilter(request.getParameter("bkg_ref_no" 	   ));
		vsl_cd            = StringUtil.xssFilter(request.getParameter("vsl_cd"           ))==null?"":StringUtil.xssFilter(request.getParameter("vsl_cd"           ));
		skd_voy_no        = StringUtil.xssFilter(request.getParameter("skd_voy_no"       ))==null?"":StringUtil.xssFilter(request.getParameter("skd_voy_no"       ));
		skd_dir_cd        = StringUtil.xssFilter(request.getParameter("skd_dir_cd"       ))==null?"":StringUtil.xssFilter(request.getParameter("skd_dir_cd"       ));
		crr_cd            = StringUtil.xssFilter(request.getParameter("crr_cd"           ))==null?"":StringUtil.xssFilter(request.getParameter("crr_cd"           ));
		spcl_cgo_rqst_seq = StringUtil.xssFilter(request.getParameter("spcl_cgo_rqst_seq"))==null?"":StringUtil.xssFilter(request.getParameter("spcl_cgo_rqst_seq"));
		slan_cd           = StringUtil.xssFilter(request.getParameter("slan_cd"          ))==null?"":StringUtil.xssFilter(request.getParameter("slan_cd"          ));
		pol_cd            = StringUtil.xssFilter(request.getParameter("pol_cd"           ))==null?"":StringUtil.xssFilter(request.getParameter("pol_cd"           ));
		//pol_cd            = pol_cd + (StringUtil.xssFilter(request.getParameter("pol_clpt_ind_seq" ))==null?"":StringUtil.xssFilter(request.getParameter("pol_clpt_ind_seq" )));
		eta_dt            = StringUtil.xssFilter(request.getParameter("eta_dt"           ))==null?"":StringUtil.xssFilter(request.getParameter("eta_dt"           ));
		pod_cd            = StringUtil.xssFilter(request.getParameter("pod_cd"           ))==null?"":StringUtil.xssFilter(request.getParameter("pod_cd"           ));
		//pod_cd            = pod_cd + (StringUtil.xssFilter(request.getParameter("pod_clpt_ind_seq" ))==null?"":StringUtil.xssFilter(request.getParameter("pod_clpt_ind_seq" )));
		
		spcl_cntr_seq     = StringUtil.xssFilter(request.getParameter("spcl_cntr_seq"    ))==null?"":StringUtil.xssFilter(request.getParameter("spcl_cntr_seq"    ));
		spcl_cgo_seq      = StringUtil.xssFilter(request.getParameter("spcl_cgo_seq"     ))==null?"":StringUtil.xssFilter(request.getParameter("spcl_cgo_seq"     ));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Dangerous CGO Application Details for Partner Lines</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	
	//초기조회조건
	var preConds = {
		pop_mode          : "<%=pop_mode%>",
		rgn_shp_opr_cd    : "<%=rgn_shp_opr_cd%>",
		cgo_opr_cd        : "<%=cgo_opr_cd%>",
		bkg_ref_no        : "<%=bkg_ref_no%>",
		vsl_cd            : "<%=vsl_cd%>",
		skd_voy_no        : "<%=skd_voy_no%>",
		skd_dir_cd        : "<%=skd_dir_cd%>",
		crr_cd            : "<%=crr_cd%>",
		spcl_cgo_rqst_seq : "<%=spcl_cgo_rqst_seq%>",
		slan_cd           : "<%=slan_cd%>",
		pol_cd            : "<%=pol_cd%>",
		eta_dt            : "<%=eta_dt%>",
		pod_cd            : "<%=pod_cd%>",
		spcl_cntr_seq     : "<%=spcl_cntr_seq%>",
		spcl_cgo_seq      : "<%=spcl_cgo_seq%>"
	}
	
	var user_id = '<%=strUsr_id%>';
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" onUnLoad="win_close();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="ibflag"      value="I">
<input type="hidden" name="dg_flg"      value="Y">
<input type="hidden" name="awk_flg"     value="N">
<input type="hidden" name="pre_chk_flg" value="N">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Dangerous CGO Application Details for Partner Lines </td></tr>
			</table>
			<!-- : ( Title ) (E) -->
		
			<!--biz page (S)-->
			<table class="search" id="mainTable"> 
       			<tr>
       				<td class="bg">
			
						<!--  biz_1  (S) -->
						<input type="hidden" name="org_cgo_opr_cd">
						<input type="hidden" name="org_bkg_ref_no">
						<input type="hidden" name="org_vsl_cd">
						<input type="hidden" name="org_skd_voy_no">
						<input type="hidden" name="org_skd_dir_cd">
						<input type="hidden" name="org_crr_cd">
						<input type="hidden" name="org_slan_cd">
						<table class="search" border="0" style="width:997;"> 
							<tr class="h23">
								<td width="55">RSO</td>
								<td width="170"><input name="rgn_shp_opr_cd" type="text" style="width:40;" class="input2" value="" caption="RSO" readOnly></td>
								<td width="95">BKG Company</td>
								<td width="160"><input name="cgo_opr_cd" id="cgo_opr_cd" type="text" style="width:40;" class="input1" value="" caption="BKG Company" maxlength="4" dataformat="engup" style="ime-mode:disabled" required>&nbsp;<img name="btn_Carrier" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="120">BKG Reference No.</td>
								<td width=""><input name="bkg_ref_no" type="text" style="width:130;" class="input1" value="" caption="BKG Reference No." maxlength="30" style="ime-mode:disabled" required></td>
							</tr>
							<tr class="h23">
								<td width="">VVD CD</td>
								<td><input name="vsl_cd" type="text" style="width:40;" class="input1" value="" fullfill caption="Vessel Code" maxlength="4" dataformat="engup" style="ime-mode:disabled" required>&nbsp;<input name="skd_voy_no" type="text" style="width:40;" class="input1" value="" fullfill caption="Schedule Voyage Number" maxlength="4" dataformat="engup" style="ime-mode:disabled" required>&nbsp;<input name="skd_dir_cd" type="text" style="width:25;" class="input1" value="" fullfill caption="Schedule Direction Code" maxlength="1" dataformat="engup" style="ime-mode:disabled" required>&nbsp;<img name="btn_VVDpop" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
									<input name="crr_cd" type="hidden">
									<input name="spcl_cgo_rqst_seq" type="hidden">
									<input name="slan_cd" type="hidden">
								</td>
								<td width="">POL</td>
								<td width="160">
									<script language="javascript">ComComboObject('pol_cd', 2, 102, 1, 1);</script>
									<input name="eta_dt" type="hidden">
								</td>
								<td width="30">POD</td>
								<td width="">
									<script language="javascript">ComComboObject('pod_cd', 2, 102, 1, 1);</script>
								</td>
							</tr>
						</table>				
						<!--  biz_1   (E) -->
				
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="search" border="0" style="width:997;"> 
							<tr class="h23">
								<td width="200" valign="middle">
									<!-- Title -->
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">CNTR Seq.</td>
										</tr>
									</table>
									<!-- Title -->
						
									<!-- Grid - 1 (S) -->
									<table width="100%"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject1('sheet1');</script>
											</td>
										</tr>
									</table>
									<!-- Grid - 1 (E) -->	
									<!--  Button_Sub (S) -->
									<table width="190" class="button"> 
								       	<tr>
								       		<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn2_Add">Add</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn2_Delete">Delete</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn2_Copy">Copy</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
							    	<!-- Button_Sub (E) -->
							
								</td>
								<td valign="middle">
									<table class="search_sm" border="0" style="width:;"> 
										<tr class="h23">
											<td>
												<!--  biz_2   (S) -->
												<table class="search" border="0" style="width:;"> 
													<tr class="h23">
														<td width="68">Cargo Seq.</td>
														<td>
															<script language="javascript">ComComboObject('spcl_cgo_seq', 3, 70, 1, 1);</script>&nbsp;/&nbsp;<input name="cntr_cgo_seq_sum" type="text" style="width:25;text-align:center;" class="input2" value="" readOnly>
														</td>
														<td width="">
															<!--  Button_Sub (S) -->
															<table width="100%" class="button"> 
													       		<tr>
													       			<td class="btn2_bg" style="padding-bottom:4;">
																		<table border="0" cellpadding="0" cellspacing="0">
																			<tr>
																				<td>
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn2_UN_Information">UN Information</td>
																							<td class="btn2_right"></td>
																						</tr>
																					</table>
																				</td>
																				<td>
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn2_Restrictions">Restrictions</td>
																							<td class="btn2_right"></td>
																						</tr>
																					</table>
																				</td>
																				<td>
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn2_Pre_Checking_Report" id="btn2_Pre_Checking_Report">Pre-Checking Report</td>
																							<td class="btn2_right"></td>
																						</tr>
																					</table>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
		    												<!-- Button_Sub (E) -->
		    											</td>
													</tr>
												</table> 
												<table class="search" border="0" style="width:;"> 
													<tr class="h23">
														<td width="68">IMO Class</td>
														<td width="60"><input name="imdg_clss_cd" type="text" style="width:27;" class="input2" value="" readOnly caption="IMO Class">&nbsp;<input name="imdg_comp_grp_cd" type="text" style="width:15;" class="input2" value="" readOnly caption="IMO Class"></td>
														<td width="40">UN No.</td>
														<td width="70"><input name="imdg_un_no" type="text" style="width:37;" class="input1" value="" caption="Un No." maxlength="4" dataformat="engup" style="ime-mode:disabled" required><input name="imdg_un_no_seq" type="hidden" caption="Un No. Sequence" required>&nbsp;<img name="btn_Un_No" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" required></td>
														<td width="84">Gross Weight</td>
														<td width="130"><input name="grs_wgt" id="grs_wgt" type="text" style="width:75;text-align:right;" class="input1" value="0.000" caption="Gross Weight"  maxlength="15" size="15" dataformat="float" pointcount="3" required>&nbsp;<input name="wgt_ut_cd" type="text" style="width:30;" class="input2" value="KGS" maxlength="3" dataformat="engup" style="ime-mode:disabled" readOnly></td>
												   		<td width="70">Net Weight</td>
														<td width="130"><input name="net_wgt" id="net_wgt" type="text" style="width:75;text-align:right;" class="input1" value="0.000" caption="Net Weight" maxlength="15" size="15" dataformat="float" pointcount="3" required>&nbsp;<input name="wgt_ut_cd2" type="text" style="width:30;" class="input2" value="KGS" maxlength="3" dataformat="engup" style="ime-mode:disabled" readOnly></td>
														<td width="">
															<!--  Button_Sub (S) -->
															<table width="100%" class="middle"> 
														       	<tr>
														       		<td class="btn2_bg">
																		<table border="0" cellpadding="0" cellspacing="0">
																			<tr>
																				<td>
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn2_Package_Qty_Type" id="btn2_Package_Qty_Type">PKG Q'ty/Type</td>
																							<td class="btn2_right"></td>
																						</tr>
																					</table>
																					<input type="hidden" name="out_n1st_imdg_pck_qty" required caption="Package Q'ty & Type">
																					<input type="hidden" name="out_n1st_imdg_pck_cd" required caption="Package Q'ty & Type">
																					<input type="hidden" name="out_n1st_imdg_pck_desc">
																					<input type="hidden" name="out_n2nd_imdg_pck_qty">
																					<input type="hidden" name="out_n2nd_imdg_pck_cd">
																					<input type="hidden" name="out_n2nd_imdg_pck_desc">
																					<input type="hidden" name="intmd_n1st_imdg_pck_qty">
																					<input type="hidden" name="intmd_n1st_imdg_pck_cd">
																					<input type="hidden" name="intmd_n1st_imdg_pck_desc">
																					<input type="hidden" name="intmd_n2nd_imdg_pck_qty">
																					<input type="hidden" name="intmd_n2nd_imdg_pck_cd">
																					<input type="hidden" name="intmd_n2nd_imdg_pck_desc">
																					<input type="hidden" name="in_n1st_imdg_pck_qty">
																					<input type="hidden" name="in_n1st_imdg_pck_cd">
																					<input type="hidden" name="in_n1st_imdg_pck_desc">
																					<input type="hidden" name="in_n2nd_imdg_pck_qty">
																					<input type="hidden" name="in_n2nd_imdg_pck_cd">
																					<input type="hidden" name="in_n2nd_imdg_pck_desc">
																					<input type="hidden" name="max_in_pck_qty" caption="Package Q'ty & Type">
																					<input type="hidden" name="max_in_pck_tp_cd" caption="Package Q'ty & Type">
																					<input type="hidden" name="hcdg_pck_rstr_desc">
																					<input type="hidden" name="hcdg_intmd_bc_rstr_desc">
																					<input type="hidden" name="hcdg_tnk_rstr_desc">
																					<input type="hidden" name="imdg_lmt_qty">
																					<input type="hidden" name="imdg_lmt_qty_meas_ut_cd">
																					<input type="hidden" name="imdg_expt_qty_cd">
																					<input type="hidden" name="imdg_spcl_provi_no">
																					<input type="hidden" name="hcdg_flg">
																					<input type="hidden" name="imdg_subs_rsk_lbl_rmk">
																					<input type="hidden" name="grs_capa_qty">
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
													    	<!-- Button_Sub (E) -->
													    </td>
													</tr>
												</table> 
												<table class="search" border="0" style="width:;"> 
													<tr class="h23">
														<td width="">Proper Shipping Name</td>
														<td width=""><input name="prp_shp_nm" type="text" style="width:100%;" class="input1" value="" required caption="Proper Shipping Name"></td>
													</tr>
													<tr class="h23">
														<td width="143">Hazardous Contents</td>
														<td width=""><input name="hzd_desc" type="text" style="width:100%;" class="input" value="" caption="Hazardous Contents" maxlength="4000" dataformat="engup" style="ime-mode:disabled" ></td>
													</tr>
												</table> 
												<table class="search" border="0" style="width:;"> 
													<tr class="h23">
													</tr>
												</table> 
				
												<table class="search" border="0" style="width:;"> 
													<tr class="h23">
														<td width="70">Flash Point</td>
														<td width="145" class="stm"><input name="flsh_pnt_cdo_temp" type="text" style="width:54;text-align:right;" class="input" value="" caption="Flash Point" maxlength="4" size="3" dataformat="int" maxnum="999" style="ime-mode:disabled">&nbsp;℃</td>
														<td width="89">Packing Group</td>
														<td width="100"><input name="imdg_pck_grp_cd" type="text" style="width:60;" class="input2" value="" readOnly></td>
														<td width="70">PSA Group</td>
														<td width="110"><input name="psa_no" type="text" style="width:25;" class="input2" value="" readOnly>&nbsp;<input type="text" style="width:25;" class="input2" value=" " readOnly></td>
														<td width="89">Limited Q'ty</td>
														<td width="55">
													   		<script language="javascript">ComComboObject('imdg_lmt_qty_flg', 1, 45, 1, 1, 0, false);</script>&nbsp;
													   	</td>
														<td>
															<!--  Button_Sub (S) -->
															<table width="100%" class="middle"> 
														       	<tr>
														       		<td class="btn2_bg">
																		<table border="0" cellpadding="0" cellspacing="0">
																			<tr>
																				<td>
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn2_HCDG" id="btn2_HCDG">HCDG</td>
																							<td class="btn2_right"></td>
																						</tr>
																					</table>
																				</td>																		
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
		    												<!-- Button_Sub (E) -->
		    											</td>
													</tr>
												</table>	
												<table class="search" border="0" style="width:;"> 
													<tr class="h23">
														<td width="70">Sub Label</td>
														<td width="145"><input name="n1st_imdg_subs_rsk_lbl_cd" type="text" style="width:25;" class="input" value="" caption="Sub Label" maxlength="3" size="2" dataformat="float" pointcount="1">&nbsp;<input name="n2nd_imdg_subs_rsk_lbl_cd" type="text" style="width:25;" class="input" value="" caption="Sub Label" maxlength="3" size="2" dataformat="float" pointcount="1">&nbsp;<input name="n3rd_imdg_subs_rsk_lbl_cd" type="text" style="width:25;" class="input" value="" caption="Sub Label" maxlength="3" size="2" dataformat="float" pointcount="1">&nbsp;<input name="n4th_imdg_subs_rsk_lbl_cd" type="text" style="width:25;" class="input" value="" caption="Sub Label" maxlength="3" size="2" dataformat="float" pointcount="1"></td>
														<!-- 
														<td width="95">															
															<table width="86" class="middle"> 
														       	<tr>
														       		<td class="btn2_bg">
																		<table border="0" cellpadding="0" cellspacing="0">
																			<tr>
																				<td>
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn2_Sub_Remark" id="btn2_Sub_Remark">Remark(s)</td>
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
													    -->
														<td width="89">Cargo Status</td>
														<td width="100">
															<script language="javascript">ComComboObject('dcgo_sts_cd', 1, 62, 1, 0, 0, false);</script>
														</td>
														<td width="105">Marine Pollutant</td>
														<td width="75">
													   		<script language="javascript">ComComboObject('mrn_polut_flg', 1, 42, 1, 0, 0, false);</script>
													   	</td>
														<td width="89">Excepted Q'ty</td>
														<td width="">
															<script language="javascript">ComComboObject('imdg_expt_qty_flg', 1, 45, 1, 1, 0, false);</script>
													   	</td>
													</tr>
												</table> 
												<table class="search" border="0" style="width:100%;"> 
													<tr class="h23">
														<td width="410">
															<table class="grid2" border="0" style="width:99%;"> 
																<tr class="h23">
																	<td class="tr2_head" width="130">Emergency Contact</td>
																	<td class=""><input name="emer_cntc_phn_no" type="text" style="width:100%;" class="noinput" value="" caption="Emergent Contact" maxlength="22" size="20" dataformat="engup" style="ime-mode:disabled"></td>
																</tr>
																<tr class="h23">
																	<td class="tr2_head" width="130">Contact Person</td>
																	<td class=""><input name="emer_cntc_pson_nm" type="text" style="width:100%;" class="noinput" value="" caption="Contact Person" maxlength="100" dataformat="engup" style="ime-mode:disabled"></td>
																</tr>
															</table>
														</td>
														<td>
															<table class="search" border="0" style="width:%;"> 
																<tr class="h23">
																	<td width="120"> Segregation Group</td>
																	<td><input name="imdg_segr_grp_no" type="text" style="width:100%;" class="input" value="" caption="Segregation Group" maxlength="100" size="15" dataformat="engup" style="ime-mode:disabled"></td>
																</tr>
															</table>
															<table class="height_2"><tr><td></td></tr></table>
															<!--  Button_Sub (S) -->
															<table width="" class="search"> 
													       		<tr>
													       			<td class="btn2_bg">
																		<table border="0" cellpadding="0" cellspacing="0">
																			<tr>
																				<td>
																					<input type="hidden" name="ems_no">
																					<input type="hidden" name="ctrl_temp_ctnt">
																					<input type="hidden" name="emer_rspn_gid_no">
																					<input type="hidden" name="emer_rspn_gid_chr_no">
																					<input type="hidden" name="emer_temp_ctnt">
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn2_Other_Emergency_Information">Other Emergency Information</td>
																							<td class="btn2_right"></td>
																						</tr>
																					</table>
																				</td>																					
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
													    	<!-- Button_Sub (E) -->
														</td>														
													</tr>
												</table>
				
												<table class="height_10"><tr><td></td></tr></table>
												<!--  Button_Sub (S) -->
												<table width="100%"> 
											       	<tr>
												       	<td class="btn2_bg">
															<table class="search" border="0" cellpadding="0" cellspacing="0">
																<tr class="h23">
																	<td style="width:70;">
																	 	<!-- 
																		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																			<tr>
																				<td class="btn2_left"></td>
																				<td class="btn2" name="btn3_Remark">Remark</td>
																				<td class="btn2_right"></td>
																			</tr>
																		</table>
																		-->
																		Remark
																	</td>
																	<td style="width:430;">
																		<textarea id="diff_rmk" name="diff_rmk" style="width:430;height:30;" class="input" dataformat="engup" style="ime-mode:disabled"></textarea>
																	</td>
																	<td align="right" valign="bottom">
																		<table width="100%" border="0" cellpadding="0" cellspacing="0">
																			<tr>
																				<td style="width:120;"></td>
																				<td>
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn3_Row_Add">Add</td>
																							<td class="btn2_right"></td>
																						</tr>
																					</table>
																				</td>
																				<td>
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn3_Row_Copy">Copy</td>
																							<td class="btn2_right"></td>
																						</tr>
																					</table>
																				</td>
																				<td>
																					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr>
																							<td class="btn2_left"></td>
																							<td class="btn2" name="btn3_Row_Delete">Delete</td>
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
										    	<!-- Button_Sub (E) -->
											</td>
										</tr>
									</table>
									<!--  biz_2   (E) -->
								</td>
							</tr>
						</table>
					
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<!--  biz_3   (S) -->
						<table class="search" border="0" style="width:;"> 
							<tr class="h23">
								<td width="108">Application Date</td>
								<td width="155"><input name="auth_dt" type="text" style="width:80;" class="input" value="<%=DateTime.getFormatDate(new java.util.Date(),"yyyy-MM-dd")%>" dataformat="ymd" caption="Application Date" maxlength="8" size="10">&nbsp;<img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" ></td>
								<td width="80">Approval by</td>
								<td width="130"><input type="text" style="width:90;text-align:center;" class="input" value="<%=strUsr_id%>" readonly="readonly"></td>
								<td width="36">Date</td>
								<td width=""><input type="text" style="width:120;text-align:center;" class="input" value="<%=DateTime.getFormatDate(new java.util.Date(),"yyyy-MM-dd HH:mm")%>" readonly="readonly"></td>
								<td width="">
							   	Pre-Checking Status : Carr. &nbsp;<input type="text" style="width:20;" class="input2" value="" readonly="readonly" name = "pre_crr"> &nbsp;Port&nbsp;<input type="text" style="width:20;" class="input2" value="" readonly="readonly" name = "pre_opr">&nbsp;Pack.&nbsp;<input type="text" style="width:20;" class="input2" value="" readonly="readonly" name = "pre_pck">&nbsp;Seg.&nbsp;<input type="text" style="width:20;" class="input2" value="" readonly="readonly" name = "pre_sgr">
							    </td>
							</tr>
							
							
							<tr class="h23">
								<td width="">Appvoval</td>
								<td width="" colspan="5">
							   		<select name="auth_sts_cd" style="width:82;" class="input1" style="font-weight:bold;">
										<option value="R" style="color:orange;">R</option>
										<option value="Y" style="color:green;">Y</option>
										<option value="N" style="color:red;">N</option>										
									</select>
							   </td>
							</tr>
							<tr class="h23">
								<td width="">Approval Ref. No.</td>
								<td width="" colspan="5"><input name="apro_ref_no" type="text" style="width:130;" class="input2" value="" caption="Approval Ref. No." maxlength="30" dataformat="engup" style="ime-mode:disabled"></td>
							</tr>
						</table> 
						<!--  biz_3   (E) -->
					</td>
				</tr>
			</table>
			<!--biz page (E)--> 
			
<table class="height_5"><tr><td></td></tr></table>

		</td>
	</tr>
</table>

<!-- Container Info Sheet (S) -->
<script language="javascript">ComSheetObject('sheet2');</script>
<!-- Container Info Sheet (E) -->

<!--IBUpload Component (S) -->
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!--IBUpload Component (E) -->
<!--IBUpload Component (S) -->
<script language="javascript">ComSheetObject('sheet3');</script>
<!--IBUpload Component (E) -->

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

	    	<!--Button (S) -->	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr>
	       			<td class="btn3_bg">
			    		<table border="0" cellpadding="0" cellspacing="0">
			    			<tr>
			    				<!-- 
			    				<td>
			    					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>	
								-->
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_New">New</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>	
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Attach_File" id="btn1_Attach_File">Attach File</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>	
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Save">Save</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>	
			    				<td>
			    					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Mail">Mail</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>	
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Close">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>	
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button (E) -->
			
		</td>
	</tr>
</table>		
<!-- : ( Button : pop ) (E) -->

<span id="progressPop"></span>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>