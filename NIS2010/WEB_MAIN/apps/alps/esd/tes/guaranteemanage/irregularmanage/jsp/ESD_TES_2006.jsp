<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_2006.jsp
*@FileTitle : Irregular Creation & Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.14 yOng hO lEE
* 1.0 Creation
* 2012.02.03 박성호 [CHM-201215762] [TES] US Irregular/Guarantee 보완 사항 구현
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.event.EsdTes2006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes2006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String		successFlag		= "";
	String		codeList		= "";
	String		pageRows		= "100";

	String		strUsr_id		= "";
	String		strUsr_nm		= "";
	String		strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GuaranteeManage.IrregularManage");

	String		referer			= JSPUtil.getNull(request.getHeader("REFERER"));

	String		gnte_no			= JSPUtil.getParameter(request, "gnte_no		".trim(), "");
	String		irr_no			= JSPUtil.getParameter(request, "irr_no			".trim(), "");
	String		gnte_flg		= JSPUtil.getNull(JSPUtil.getParameter(request, "gnte_flg".trim(), ""), "N");
	String		inq_flg			= JSPUtil.getNull(JSPUtil.getParameter(request, "inq_flg".trim(), ""), "N");
	String		gnte_tp_cd		= JSPUtil.getParameter(request, "gnte_tp_cd		".trim(), "");
	String		curr_cd			= JSPUtil.getParameter(request, "curr_cd		".trim(), "");
	String		ttl_amt			= JSPUtil.getParameter(request, "ttl_amt		".trim(), "");
	String		bkg_sts_cd		= JSPUtil.getParameter(request, "bkg_sts_cd		".trim(), "");
	String		cntr_list		= JSPUtil.getParameter(request, "cntr_list		".trim(), "");
	String		cntr_seq		= JSPUtil.getParameter(request, "cntr_seq		".trim(), "");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsdTes2006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	/** 조회 화면 이동시 재조회하기 추가    **/
	String pre_cond_irr_no 				= request.getParameter("pre_cond_irr_no")!=null&&!request.getParameter("pre_cond_irr_no").trim().equals("")?request.getParameter("pre_cond_irr_no"):"";
	String pre_cond_cost_ofc_cd 		= request.getParameter("pre_cond_cost_ofc_cd")!=null&&!request.getParameter("pre_cond_cost_ofc_cd").trim().equals("")?request.getParameter("pre_cond_cost_ofc_cd"):"";
	String pre_cond_cre_usr_id 			= request.getParameter("pre_cond_cre_usr_id")!=null&&!request.getParameter("pre_cond_cre_usr_id").trim().equals("")?request.getParameter("pre_cond_cre_usr_id"):"";
	String pre_cond_gnte_tp_cd 			= request.getParameter("pre_cond_gnte_tp_cd")!=null&&!request.getParameter("pre_cond_gnte_tp_cd").trim().equals("")?request.getParameter("pre_cond_gnte_tp_cd"):"";
	String pre_cond_fm_cre_dt 			= request.getParameter("pre_cond_fm_cre_dt")!=null&&!request.getParameter("pre_cond_fm_cre_dt").trim().equals("")?request.getParameter("pre_cond_fm_cre_dt"):"";
	String pre_cond_to_cre_dt 			= request.getParameter("pre_cond_to_cre_dt")!=null&&!request.getParameter("pre_cond_to_cre_dt").trim().equals("")?request.getParameter("pre_cond_to_cre_dt"):"";
	
%>
<html>
<head>
<title>Irregular Creation & Adjustment</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="DB_DATE">
<input type="hidden" name="dmy_flg">
<!-- Container No. 로 Booking No. 입력위한 RowId -->
<input type="hidden" name="rowId">	
<input type="hidden" name="is_valid_TPB">

<!--	상세조회 화면에서 이동해 왔을 경우 바로 다시 조회 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위한 값들. 	-->
<input name="pre_cond_irr_no" 			type="hidden" value="<%=JSPUtil.getNull(pre_cond_irr_no)%>">
<input name="pre_cond_cost_ofc_cd" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_cost_ofc_cd)%>">
<input name="pre_cond_cre_usr_id" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_cre_usr_id)%>">
<input name="pre_cond_gnte_tp_cd" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_gnte_tp_cd)%>">
<input name="pre_cond_fm_cre_dt" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_fm_cre_dt)%>">
<input name="pre_cond_to_cre_dt" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_to_cre_dt)%>">

<!-- DEPART Validation Check Use -->
<input type="hidden" name="is_valid_dept_no">
<input type="hidden" name="dept_no">
<!--  Cost Office Code 가져오기 위한 임의 값 설정. 여기에서는 의미 없는 값. TESCommon에 기 구현된 로직 사용키 위함. -->
<input type="hidden" name="yd_cd" value='___'>

<!-- Container Info Select Use	-->
<input type="hidden" name="bkg_no_tmp">
<input type="hidden" name="cntr_no_tmp">
<input type="hidden" name="is_valid_cntr_info">
<input type="hidden" name="mst_cntr_exist">

<!-- Print Use	-->
<input type="hidden" name="is_valid_print">
<input type="hidden" name="irr_no_hidden">

<!-- Retrieve Use	-->
<input type="hidden" name="retrieveFlg"		value='N'>
										
<input type="hidden" name="regflag"			value="Y">
<input type="hidden" name="referer"			value="<%=referer%>">
<input type="hidden" name="inq_flg"			value="<%=inq_flg%>">
<input type="hidden" name="gnte_flg"		value="<%=gnte_flg%>">
<input type="hidden" name="gnte_no"			value="<%=gnte_no %>">
<input type="hidden" name="cre_ofc_cd"		value="<%=strOfc_cd%>">

<!-- Guarantee Transfer Irregular Creation Use	-->
<input type="hidden" name="gnte_tp_cd_gnte"	value="<%=gnte_tp_cd%>">
<input type="hidden" name="curr_cd_gnte"	value="<%=curr_cd%>">
<input type="hidden" name="ttl_amt_gnte"	value="<%=ttl_amt%>">
<input type="hidden" name="bkg_sts_cd_gnte"	value="<%=bkg_sts_cd%>">
<input type="hidden" name="cntr_list"		value="<%=cntr_list%>">
<input type="hidden" name="cre_flg"         value="I">

<!-- Guarantee Transfer Irregular Creation Use	-->
<input type="hidden" name="cntr_seq"		value="<%=cntr_seq %>">

<!-- TPB I/F TPB Use BillingCase Code Get Temp ( 2014-01-26 )	-->
<input type="hidden" name="n3pty_bil_tp_cd_tmp"		value="">

<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="/hanjin/img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_irregular">Irregular</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_guarantee">Guarantee</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_tpbif">TPB I/F</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

		</tr>
		</table></td>
		</tr>
		</table>
    <!--Button (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table class="search">
	       	<tr><td class="bg">

						<!-- TABLE '#D' : ( Search Options-1 ) (S) -->
						<table class="search_in" border="0"">
							<tr class="h23">
								<td width="125">Reference Number</td>
								<td width="150">
									<input type="text" style="width:100" name="irr_no" value="<%=irr_no %>" maxlength="12" OnKeyUp="isApNum2(this)">
									&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_refno">
								</td>
								<td width="100">Office Code</td>
								<td width="90"><input type="text" style="width:70" name="ofc_cd" value="<%=strOfc_cd %>" class="input2" readonly></td>
								<td width="100">USER ID</td>
								<td width="100"><input type="text" style="width:75" name="cre_usr_id" value="<%=strUsr_id %>" class="input2" readonly></td>
								<td width="100">Creation Date</td>
								<td width="120"><input type="text" style="width:89" name="cre_dt" class="input2" readonly></td>
								<td width="50">Delete</td>
								<td><input type="text" style="width:30" name="delt_flg" class="input2" readonly></td>
							</tr>
						</table>

						<table class="search_in" border="0">
							<tr class="h23">
								<td width="125">Type</td>
								<td width="150">
									<select name="gnte_tp_cd" OnChange="JavaScript:setTypeCntrDt();">
										<option value="ST">Storage</option>
										<option value="FL">Flip</option>
										<option value="CY">Other</option>
									</select>
								</td>
								<td width="100">Currency Code</td>
								<td width="90">
									<select name="curr_cd">
										<option value="USD">USD</option>
										<option value="CAD">CAD</option>
									</select>
								</td>
								<td width="100">Booking Status</td>
								<td width="100">
									<select name="bkg_sts_cd">
										<option value="F">Firm</option>
										<option value="X">Canceled</option>
									</select>
								</td>
								<td width="100">Irregular Type</td>
								<td>
									<select name="irr_tp_cd" OnChange="irrTpCdChange()">
										<option value="I">Irregularity</option>
										<option value="O">Operation Cost</option>
									</select>
								</td>
						</tr>
						</table>
						<!-- TABLE '#D' : ( Search Options-1 ) (E) -->

						<table class="line_bluedot"><tr><td></td></tr></table>

						<!-- TABLE '#D' : ( Search Options-2 ) (S) -->
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="75">DEPART</td>
								<td width="180" style="padding-left:1"><input type="text" name="cost_ofc_cd" style="width:50;" maxlength="6" class='input1' OnKeyUp='tes_isApNum(this);upper(this);' OnBlur='validateDeptNo();'></td>
								<td width="60">Amount</td>
								<td width=""><input type="text" name="irr_ttl_amt" style="width:190;" maxlength="13" class="input2" readonly></td>
								<td rowspan="3"  align="right">
								
								<!-- Irregularity 인 경우	-->	
								<div name="irLayer" id="irLayer" style="display:inline">
									<table class="grid" border="0" width="430">
				    					<tr class="h23">
											<td width="110" class="tr2_head" rowspan="4">Irregularity</td>
											<td><input type="checkbox" name="irr_stf_err_flg" 		value="Y" class="trans">Staff Error</td>
											<td><input type="checkbox" name="irr_late_dis_flg"		value="Y" class="trans">Late Dispatch</td></tr>
			    						<tr class="h23">
			    							<td><input type="checkbox" name="irr_sys_err_flg"		value="Y" class="trans">System Error</td>
			    							<td><input type="checkbox" name="irr_lack_of_flw_flg"	value="Y" class="trans">Lack of follow</td></tr>
			    						<tr class="h23">
			    							<td><input type="checkbox" name="irr_chss_shtg_flg"		value="Y" class="trans">Chassis Shortage</td>
			    							<td><input type="checkbox" name="irr_cxl_wo_flg"		value="Y" class="trans">Canceled Work order</td></tr>
			    						<tr class="h23">
			    							<td><input type="checkbox" name="irr_otr_flg"			value="Y" class="trans">Other</td>
			    							<td><input type="checkbox" name="irr_eq_shtg_flg"		value="Y" class="trans">EQ Shortage</td></tr>
									</table>
								</div>
								
								<!-- Operation Cost 인 경우	-->					
								<div name="irLayer" id="irLayer" style="display:none">
									<table class="grid" border="0" width="430">
				    					<tr class="h23">
											<td width="110" class="tr2_head" rowspan="5">Operation Cost</td>
											<td><input type="checkbox" name="op_cost_ocp_flg"		value="Y" class="trans">OCP</td>
											<td><input type="checkbox" name="op_cost_sptg_icrz_flg" value="Y" class="trans">Spot Increase</td></tr>
			    						<tr class="h23">
			    							<td><input type="checkbox" name="op_cost_tnk_ord_flg"		value="Y" class="trans">Tank Order</td>
			    							<td><input type="checkbox" name="op_cost_otr_tml_chss_flg"	value="Y" class="trans">Other TML CHZ</td></tr>
			    						<tr class="h23">
			    							<td><input type="checkbox" name="op_cost_team_trkg_flg"	value="Y" class="trans">Team Trucking</td>
			    							<td><input type="checkbox" name="op_cost_mnr_flg"		value="Y" class="trans">M&R</td></tr>
			    						<tr class="h23">
			    							<td><input type="checkbox" name="op_cost_xtra_ft_flg"	value="Y" class="trans">EXT.Freetime</td>
			    							<td><input type="checkbox" name="op_cost_tri_axl_flg"	value="Y" class="trans">Triaxle(Covered by S/C or B/L)</td></tr>
									</table>	
								</div>								
								</td>
							</tr>

							<tr class="h23">
								<td width="75">RESP PART</td>
								<td width="" colspan="3"><textarea name="respb_pty_nm" style="width:430; height:42;"></textarea></td>
							</tr>
							<tr class="h23">
								<td>
									<table class="search" border="0">
										<tr><td class="title_h"></td>
											<td class="title_s">Reason</td></tr>
										<tr><td class="height_5"></td></tr>
									</table>
								</td>
								<td colspan="3"></td>
							</tr>
							  <tr class="h23">
								    <td colspan="4" rowspan="3"><textarea name="irr_rsn_rmk" style="width:505; height:63;"></textarea></td>
								    <td>
								    	<table class="search" border="0">
										<tr><td width="30"></td>
										    <td class="title_h"></td>
										    <td class="title_s">Preventive Measurement</td></tr>
										<tr><td class="height_5"></td></tr>
									</table></td>
								  </tr>
								  <tr class="h23" rowspan="2">
								    <td align="right"><textarea name="irr_prvt_rmk" style="width:430; height:42;"></textarea></td>
							  </tr>
						</table>

						<!-- TABLE '#D' : ( Search Options-2 ) (E) -->
					</div>
					<table class="line_bluedot"><tr><td></td></tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
	       	<tr><td class="bg">

			<!-- Grid  (S) -->

			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button">
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>

						<!-- Repeat Pattern -->

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowdelete" id="btng_rowdelete">Row Delete</td>
							<td class="btn2_right"></td></tr></table></td>
							</tr></table></td>
						<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
			</table>
	    	<!-- : ( Button : Sub ) (E) -->
	    	</td></tr>
			</table>
			</td></tr>
		</table>


	    </td></tr>
	</table>
	</td></tr>
</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->



<!-- Outer Table (E)-->

<div style='display:none'>
<!-- Irregular Header Info Grid  (S) -->
<table width="100%"  id="mainTable">
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table>
<!-- Header Info Grid (E) -->

</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>