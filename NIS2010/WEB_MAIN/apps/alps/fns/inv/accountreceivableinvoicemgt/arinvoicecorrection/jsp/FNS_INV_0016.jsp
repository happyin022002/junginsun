<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0016.jsp
*@FileTitle : Invoice Item Correction(General)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.04 김세일
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String bl_src_no		= "";
	String ar_ofc_cd		= "";
	String classId		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (FnsInv0016Event)request.getAttribute("Event");
		
		bl_src_no       = event.getBlSrcNo();
		ar_ofc_cd   	= event.getArOfcCd();
		classId   		= event.getClassId();
		
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
<title>Invoice Item Correction(General)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();" <%=!classId.equals("")?"class=popup_bg":""%>>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ofc" value="">
<input type="hidden" name="ofc_cd" value="">
<input type="hidden" name="pagetype" value = ""><!-- OFFICE LIST -->
<input type="hidden" name="ar_ofc_cd2"><!-- OFFICE LIST -->
<input type="hidden" name="zn_ioc_cd">
<input type="hidden" name="act_inv_flag" value="N">
<input type="hidden" name="other_flag" value="Y">
<input type="hidden" name="cr_flg">
<input type="hidden" name="ots_smry_cd">
<input type="hidden" name="cust_cr_flg">
<input type="hidden" name="cr_term_dys">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="lcl_curr">
<input type="hidden" name="curr_cd">
<input type="hidden" name="usd_xch_rt">
<input type="hidden" name="xch_rt_n3rd_tp_cd">
<input type="hidden" name="xch_rt_usd_tp_cd">
<input type="hidden" name="xch_rt_dt">
<input type="hidden" name="obrd_cd">
<input type="hidden" name="vvd">
<input type="hidden" name="lcl_vvd">
<input type="hidden" name="port">
<input type="hidden" name="bnd">
<input type="hidden" name="inv_ttl_locl_amt">
<input type="hidden" name="inv_cust_flg">
<input type="hidden" name="sail_dt">
<input type="hidden" name="mod_flag">
<input type="hidden" name="loc_cd">
<input type="hidden" name="svr_id">
<input type="hidden" name="dest_trns_svc_mod_cd">
<input type="hidden" name="inv_svc_scp_cd">
<input type="hidden" name="inv_dup_flg">
<input type="hidden" name="changed_cust_cd">
<!-- 개발자 작업	-->
<table width="100%" <%=!classId.equals("")?"class=popup cellpadding=10":"border=0 cellpadding=0 cellspacing=0 style='padding-top: 2; padding-left: 5;' "%>>
<% if(!classId.equals("")){ %>
<tr><td class="top"></td></tr>
<%}%>
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<% if(classId.equals("")){ %>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">			
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"	align="absmiddle"><span id="navigation"></span></td>
			</tr>			
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<%}else{%>
		<!-- : ( Title ) (S) -->
			<table width="540" border="0">
			<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Item Correction</td></tr>
			</table>
			<!-- : ( Title ) (E) -->
		<%}%>	
		
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="50" align="right" style="padddign-right: 4">B/L
						No.</td>
						<td width="140"><input type="text" style="width: 100;"
							class="input" name="bl_no" id="bl_no" value="" maxlength="12"
							dataformat="uppernum"
							onKeyDown="javascript:keyEnterRetreive(event)"></td>
						<td width="55">BKG No.</td>
						<td width="120"><input type="text" style="width: 100;"
							class="input2" name="bkg_no" value="" maxlength="11" readonly></td>
						<td width="75">Invoice No.</td>
						<td width="150"><input type="text" style="width: 130;"
							class="input" name="str_inv_no" id="str_inv_no" value=""
							maxlength="15" dataformat="uppernum"></td>
						<td width="50">I/F No.</td>
						<td width="140"><input type="text" style="width: 100;"
							class="input2" name="if_no" value="" maxlength="11" readonly>
						</td>
						<td width="40">Office</td>
						<td><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 1, 1);</script></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>


		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0"
			width=100%>
			<tr>
				<td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) --> <!--TAB Correction (S) -->
		<div id="tabLayer" style="display: inline">

		<table class="search">
			<tr>
				<td class="bg">

				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">Actual Cust.</td>
						<td width="606"><input type="text" style="width: 40;"
							name="act_cust_cnt_cd" value="" onblur="fn_act_cust_chg();"
							dataformat="engup" maxlength="2" required>&nbsp;<input
							type="text" style="width: 50;" name="act_cust_seq"
							onblur="fn_act_cust_chg();" value="" maxlength="6" dataformat="num" required>&nbsp;<img
							class="cursor" src="img/btns_search.gif" name="btn_actcust"
							width="19" height="20" border="0" align="absmiddle">&nbsp;<input
							type="text" style="width: 250;" name="cust_nm" value=""
							class="input2">&nbsp;<input type="text"
							style="width: 150;" name="cust_rgst_no" value="" class="input2" dataformat="num" maxlength="20" onblur="fn_rgst_chg();">&nbsp;<img
							class="cursor" src="img/btns_search.gif" name="btn_custNm"
							id="btn_custSer" width="19" height="20" border="0"
							align="absmiddle"></td>
						<td width="90">INV Cust.</td>
						<td><input type="text" style="width: 30;"
							name="inv_cust_cnt_cd" value=""
							onblur="fn_ex_rate_chg();fn_inv_cust_chg();" dataformat="engup"
							maxlength="2" required>&nbsp;<input type="text"
							style="width: 100;" name="inv_cust_seq" value=""
							onblur="fn_ex_rate_chg();fn_inv_cust_chg();" maxlength="6" dataformat="num"
							required>&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_cust" width="19" height="20"
							border="0" align="absmiddle"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">Credit Limit</td>
						<td width="289"><input type="text" style="width: 40;"
							name="cr_curr_cd" value="" class="input2" readonly>&nbsp;<input
							type="text" style="width: 100; text-align: right;" name="cr_amt"
							value="" class="input2" readonly></td>
						<td width="75">Credit Term</td>
						<td width="242">&nbsp;O/B&nbsp;<input type="text"
							style="width: 29;" name="ob_cr_term_dys" value="" class="input2"
							readonly>&nbsp;&nbsp;&nbsp;I/B&nbsp;<input type="text"
							style="width: 29;" name="ib_cr_term_dys" value="" class="input2"
							readonly></td>
						<td width="90">CRDT Office</td>
						<td><input type="text" style="width: 100;"
							name="cr_clt_ofc_cd" value="" class="input2" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">LCL VVD</td>
						<td width="150"><input type="text" style="width: 80;"
							name="local_vvd" value="" class="input"
							onblur="fn_vvd_bound_pol_pod_chg();" maxlength="9"
							dataformat="uppernum"></td>
						<td width="39">Scope</td>
						<td width="100">&nbsp;<input type="text" style="width: 55;"
							name="svc_scp_cd" value="" class="input2" readonly></td>
						<td width="75">Bound</td>
						<td width="242"><input type="text" style="width: 73;"
							name="io_bnd_cd" value="" class="input2" readonly></td>
						<td width="90">S/A Date</td>
						<td><input type="text" style="width: 77;" name="sail_arr_dt"
							value="" class="input2" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">Trunk VVD</td>
						<td width="150"><input type="text" style="width: 80;"
							name="trunk_vvd" value="" class="input" maxlength="9"
							dataformat="uppernum"></td>
						<td width="39">Lane</td>
						<td width="100">&nbsp;<input type="text"
							style="width: 55;" name="slan_cd" value="" class="input2"
							readonly></td>
						<td width="75">POR/POL</td>
						<td width="242"><input type="text" style="width: 73;"
							name="por_cd" value="" class="input2" readonly> / <input
							type="text" style="width: 73;" name="pol_cd" value=""
							class="input2" onblur="fn_vvd_bound_pol_pod_chg();" maxlength="5"
							dataformat="uppernum"></td>
						<td width="90">POD/DEL</td>
						<td><input type="text" style="width: 50;" name="pod_cd"
							value="" class="input" onblur="fn_vvd_bound_pol_pod_chg();"
							maxlength="5" dataformat="uppernum">&nbsp;/&nbsp;<input
							type="text" style="width: 50;" name="del_cd" value=""
							class="input2" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">C/A No.</td>
						<td width="289"><input type="text" style="width: 140;"
							name="bkg_corr_no" value="" class="input2" readonly></td>
						<td width="75">C/A Date</td>
						<td width="242"><input type="text" style="width: 161;"
							name="bkg_corr_dt" value="" class="input2" readonly></td>
						<td width="90">SML Ref.</td>
						<td><input type="text" style="width: 150;"
							name="hjs_stf_ctnt" value=""></td>
					</tr>
					<tr class="h23">
						<td width="">INV Ref.No.</td>
						<td width=""><input type="text" style="width: 140;"
							class="input" name="inv_ref_no" value="" maxlength="25"></td>
						<td width="">BKG Ref.No.</td>
						<td><input type="text" style="width: 161;" class="input2"
							readonly name="bkg_ref_no" value=""></td>
						<td>S/I Ref.No.</td>
						<td><input type="text" style="width: 150;" value=""
							name="si_ref_no" class="input2" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">Description</td>
						<td width="606"><input type="text" style="width: 525;"
							class="input" name="inv_rmk" value=""></td>
						<td width="90">Rev. Type</td>
						<td width="60"><input type="text" style="width: 50;"
							class="input2" readonly name="rev_tp_cd" value=""></td>
						<td width="53">Source</td>
						<td><input type="text" style="width: 40;" class="input2"
							readonly name="rev_src_cd" value=""></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">Master B/L</td>
						<td width="289"><input type="text" style="width: 100;"
							class="input" name="mst_bl_no" value="" dataformat="uppernum"></td>
						<td width="75">RFA No.</td>
						<td width="242"><input type="text" style="width: 100;"
							class="input" name="rfa_no" value="" maxlength="11"></td>
						<td width="90">S/C No.</td>
						<td><input type="text" style="width: 100;" name="sc_no"
							value="" maxlength="20"></td>
					</tr>
					<tr class="h23">
						<td>Sales Rep.</td>
						<td><input type="text" style="width: 100;" class="input"
							name="srep_cd" value="" maxlength="5"></td>
						<td>Weight</td>
						<td><input type="text" style="width: 100; text-align: right"
							class="input" name="cgo_wgt" value=""></td>
						<td>Measure</td>
						<td><input type="text" style="width: 100; text-align: right"
							name="cgo_meas_qty" value=""></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">WHF DEC</td>
						<td width="289"><input type="text" style="width: 100;"
							class="input2" readonly name="whf_decl_no" value=""></td>
						<td width="75">WHF Date</td>
						<td width="242"><input type="text" style="width: 100;"
							class="input2" readonly name="whf_decl_cfm_dt" value=""></td>
						<td width="90">TEU/FEU</td>
						<td width=""><input type="text" style="width: 50;"
							name="bkg_teu_qty" value="" readonly>&nbsp;/&nbsp;<input type="text" style="width: 50;" name="bkg_feu_qty"
							value="" readonly>&nbsp;<img src="img/btns_search.gif"
							width="19" height="20" alt="" border="0" name="btn_container"
							align="absmiddle" class="cursor"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">I/F Date</td>
						<td width="289"><input type="text" style="width: 78;"
							class="input2" readonly name="bl_inv_if_dt" value=""></td>
						<td width="75">Good Date</td>
						<td width="242"><input type="text" style="width: 78;"
							class="input2" readonly name="bl_inv_cfm_dt" value=""></td>
						<td width="90">Eff. Date</td>
						<td><input type="text" style="width: 78;" class="input2"
							readonly name="gl_eff_dt" value=""></td>
					</tr>
					<tr class="h23">
						<td>INV No.</td>
						<td><input type="text" style="width: 100;" class="input2"
							readonly name="inv_no" value=""></td>
						<td>Issue Date</td>
						<td><input type="text" style="width: 78;" class="input2"
							readonly name="iss_dt" value=""></td>
						<td>Due Date</td>
						<td><input type="text" style="width: 78;" class="input2"
							readonly name="due_dt" value=""></td>
					</tr>
					<tr class="h23">
						<td>FWDR Code</td>
						<td colsapn="5"><input type="text" style="width: 30;"
							class="input" name="frt_fwrd_cnt_cd" value="" maxlength="2"
							dataformat="engup">&nbsp;<input type="text"
							style="width: 65;" class="input" name="frt_fwrd_cust_seq" dataformat="num"
							value="" maxlength="6"></td>
					</tr>
				</table>

				</td>
			</tr>

			<!--Button (S) -->

			<!--Button (E) -->

			<!-- Grid  (S) -->

			<script language="javascript">ComSheetObject('sheet1');</script>
			<script language="javascript">ComSheetObject('sheet2');</script>

			<!-- Grid (E) -->


			<!--  Button_Sub (S) -->

			<!-- Button_Sub (E) -->
			</td>
			</tr>
		</table>

		</div>
		<!--TAB Correction (E) --> <!--TAB Charge (S) -->
		<div id="tabLayer" style="display: none">

		<table class="search">
			<tr>
				<td class="bg">
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">By Currency</td>
					</tr>
				</table>
				<!--  biz_1   (E) --> <!-- Grid  (S) -->
				<table width="60%" id="mainTable">
					<tr>
						<td width="60%"><script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) --> <!--  biz_2  (S) -->

				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>

				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">By Charge</td>
					</tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('t2sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --> <!--  biz_2   (E) --></td>
			</tr>
		</table>

		</div>
		<!--TAB Charge (E) --> <!-- Grid  (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet5');</script>
				</td>
			</tr>
		</table>
		
<!--Button (E) -->
	</td>
</tr>
</table>		
<% if(classId.equals("")){ %>		
		<!-- Grid (E) --> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
<%
	}
	else {
%>
		<!-- : ( Button : Sub ) (S) -->
		<table width="100%" class="sbutton">
		<tr>
			<td height="71" class="popup">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
    					<table border="0" cellpadding="0" cellspacing="0">
    					<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_retrieve">Retrieve</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_new">New</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td class="btn1_line"></td>
							<td>
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_save">Save</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td class="btn1_line"></td>
							<td>
								<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
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
		<!-- : ( Button : Sub ) (E) -->
<%
	}
%>		
</form>
<form name="form2"><input type="hidden" name="f_cmd">
<input	type="hidden" name="pagerows">
<input type="hidden" name="bl_src_no" value="<%=bl_src_no %>">
<input type="hidden" name="ar_ofc_cd" value="<%=ar_ofc_cd %>">
<input type="hidden" name="classId" value="<%=classId %>"></form>
<!-- 개발자 작업  끝 -->
</body>
</html>