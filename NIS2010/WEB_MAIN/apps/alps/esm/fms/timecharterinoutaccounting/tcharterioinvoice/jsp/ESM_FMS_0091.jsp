<%
/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : ESM_FMS_0091.jsp
* @FileTitle : Off-Hire Expenses Detail
* Open Issues :
* Change history :
* @LastModifyDate : 2009.05.20
* @LastModifier : 정윤태
* @LastVersion : 1.0
* 2009.05.20 정윤태
* 1.0 최초 생성
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>

<%
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";	

	String usrId = "";
	String strUsr_nm		= "";
	String strOfc_nm		= "";
	
	String vsl_cd = "";
	String offh_fm_dt = "";
	String offh_fm_dt_hm = "";
	String offh_to_dt = "";
	String offh_to_dt_hm = "";
	String vnor_offh_knd_cd = "";
	String cr_chk_flg = "";
	String vnor_offh_ind = "";
	String flet_ctrt_no = "";
	String sheet_no = "";
	String inv_seq = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	usrId = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_nm = account.getOfc_eng_nm();
		
		vsl_cd = JSPUtil.replaceForHTML(request.getParameter("vsl_cd"));
		offh_fm_dt = JSPUtil.replaceForHTML(request.getParameter("offh_fm_dt"));
		offh_fm_dt_hm = JSPUtil.replaceForHTML(request.getParameter("offh_fm_dt_hm"));
		offh_to_dt = JSPUtil.replaceForHTML(request.getParameter("offh_to_dt"));
		offh_to_dt_hm = JSPUtil.replaceForHTML(request.getParameter("offh_to_dt_hm"));
		vnor_offh_knd_cd = JSPUtil.replaceForHTML(request.getParameter("vnor_offh_knd_cd"));		
		cr_chk_flg = JSPUtil.replaceForHTML(request.getParameter("cr_chk_flg"));	
		vnor_offh_ind = JSPUtil.replaceForHTML(request.getParameter("vnor_offh_ind"));
		flet_ctrt_no = JSPUtil.replaceForHTML(request.getParameter("flet_ctrt_no"));
		sheet_no = JSPUtil.replaceForHTML(request.getParameter("sheet_no"));
		inv_seq = JSPUtil.replaceForHTML(request.getParameter("inv_seq"));
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>

<html>
<head>
<title>Off-Hire Expenses</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

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

<body onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="ibflag">
<input type="hidden" name="inv_seq">
<input type="hidden" name="offh_seq">
<input type="hidden" name="ppay_hir_no">
<input type="hidden" name="ori_eff_dt">
<input type="hidden" name="ori_exp_dt">
<input type="hidden" name="ori_inv_usd_dys">
<input type="hidden" name="flet_ctrt_tp_gb">
<input type="hidden" name="search_yn">
<input type="hidden" name="curr_cd">
<input type="hidden" name="inv_desc">
<input type="hidden" name="usr_id" value="<%=usrId%>">

<input type="hidden" name="usr_nm" value="<%=strUsr_nm%>" >
<input type="hidden" name="ofc_nm" value="<%=strOfc_nm%>">
<input type="hidden" name="flet_offh_rsn_nm" >
<input type="hidden" name="vnor_offh_knd_cd"  value="<%=vnor_offh_knd_cd%>">
<input type="hidden" name="cr_chk_flg"  value="<%=cr_chk_flg%>">
<input type="hidden" name="vnor_offh_ind"  value="<%=vnor_offh_ind%>">
<input type="hidden" name="opener_flet_ctrt_no"  value="<%=flet_ctrt_no%>">
<input type="hidden" name="sheet_no"  value="<%=sheet_no%>">
<input type="hidden" name="opener_inv_seq"  value="<%=inv_seq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Off-Hire Expenses Detail</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Offhire Expenses</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">Contract No.</td>
					<td width="170"><select class="noinput" style="width:150;" name="flet_ctrt_no"><option value=""> </option></td>
					<td width="75">Vessel Code</td>
					<td width="265"><input type="text" style="width:54;text-align:center;" class="input1" maxlength="4" name="vsl_cd" required fullfill caption="Vessel Code" style="ime-mode:disabled" value="<%=vsl_cd%>">&nbsp;<input type="text" style="width:162;" class="input2" name="vsl_eng_nm" readonly></td> 
					<td width="85">Contract TP</td>
					<td width="129"><input type="text" style="width:70;text-align:center;" class="input2" name="flet_ctrt_tp_cd" readonly></td>

					<!-- td id="i_ppay_hir_no" style="display:none;"><select style="width:45;height:10;" class='input1' name="pay_hir_no"></select></td-->
					
				</tr>
				<tr class="h23">
					<td>Owner Code</td>																																																					<!-- width:161; -->
					<td colspan="3"><input type="text" style="width:30;text-align:center;" class="input2" name="cust_cnt_cd" readonly>&nbsp;<input type="text" style="width:67;text-align:center;" class="input2" name="cust_seq" readonly>&nbsp;<input type="text" style="width:380;" class="input2" name="vndr_lgl_eng_nm" readonly></td> 
					<td width="100">Owner Name</td>			<!-- width:185 -->
					<td colspan="2"><input type="text" style="width:185;" class="input2" name="ownr_nm" readonly></td></tr>
				<tr class="h23">
					<td width="100">Duration</td>
					<td width="510" colspan="3" class="stm"><input type="text" style="width:75;text-align:center;" class="input" name="eff_dt" maxlength="8" dataformat="ymd" value="<%=offh_fm_dt%>">&nbsp;<input type="text" style="width:50;text-align:center;" class="input" name="from_time" maxlength="4" dataformat="hm" value="<%=offh_fm_dt_hm%>">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="ef_dt">&nbsp;~&nbsp;<input type="text" style="width:75;text-align:center;" class="input" name="exp_dt" maxlength="8" dataformat="ymd" value="<%=offh_to_dt%>">&nbsp;<input type="text" style="width:50;text-align:center;" class="input" name="to_time" maxlength="4" dataformat="hm" value="<%=offh_to_dt_hm%>">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="ex_dt">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:60;text-align:right" class="input2" name="inv_usd_dys" readonly>&nbsp;Days&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="duration"></td> 
					<td width="50">VVD CD</td> 
					<td width="129"><select style="width:115;" class="noinput" name="bunker_vvd">
						</select></td>
					<td width="100">Accident Type</td> 
					<td width=""><select style="width:89;" class="noinput" name="flet_offh_rsn_cd"></select></td></tr>
				</table>
	    	<!-- sub_button (E) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">					
					<td><table class="search_sm2" border="0" style="width:270;">
							<tr class="h23">
								<td width="25"></td>
								<td width="73">Condition</td>
								<td  class="stm"><input type="radio" class="trans" name="condition" value="C" checked onClick="setCondition('C');">Creation&nbsp;&nbsp;<input type="radio" class="trans" name="condition" value="I" onClick="setCondition('I');">Inquiry</td>
							</tr> 
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Hire Information</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="85">Hire</td>
                    <td><input type="text" style="width:76;text-align:center;" class="input2" name="hir_eff_dt" readonly>&nbsp;<input type="text" style="width:45;text-align:center;" class="input2" name="hir_eff_dt_time" readonly>&nbsp~&nbsp;<input type="text" style="width:76;text-align:center;" class="input2" name="hir_exp_dt" readonly>&nbsp;<input type="text" style="width:45;text-align:center;" class="input2" name="hir_exp_dt_time" readonly>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:40;text-align:center;" class="input2" name="hir_hir_curr_n1st_cd" readonly>&nbsp;<input type="text" style="width:95;text-align:right;" class="input2" name="hir_hir_rt_n1st_amt" readonly>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:40;text-align:center;" class="input2" name="hir_hir_curr_n2nd_cd" readonly>&nbsp;<input type="text" style="width:95;text-align:right;" class="input2" name="hir_hir_rt_n2nd_amt" readonly></td></tr>
                </table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Other(s) Lump sum information</td></tr>
				</table>
				<table class="search" border="0" style="width:665;"> 
                <tr class="h23">
                    <td><!-- Grid  (S) -->
			                <script language="javascript">ComSheetObject('sheet1');</script>
			            <!-- Grid (E) -->
					</td>
                </tr>
                </table>
				<!--  biz_2   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_3  (S) -->
				
					<!-- Grid  (S) -->
					<table width="100%" class="search" id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</table> 
						<!-- Grid (E) -->

						<!--  Grid_button (S) -->
						<table width="100%" class="button"> 
	       					<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_add">Row&nbsp;Add</td>
									<td class="btn2_right"></td>
									</tr>
								</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_del">Row&nbsp;Del</td>
									<td class="btn2_right"></td>
									</tr>
								</table></td>
							</tr></table>
	    				<!-- Grid_button (E) -->
						<!-- Total 구하기 (S) -->
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="search" border="0" style="width:979;" align="left"> 
							<tr class='h23' id="totalAmount" style="display:none;">
								<td width='275'></td>
								<td width='90' valign="absmiddle">Total Amount</td>
								<td width='147' id="totalAmount1" valign="top"></td>
								<td id="totalAmount2" valign="top"></td>
							</tr>
						</table>
						<!-- Total 구하기 (E) -->
					
				<!--  biz_3   (E) -->
				
				</td></tr>
			</table>
		</td></tr>
	</table>
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
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
				<td id="btn_delete2" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete2">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_print" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
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

<!------- Print용 Hidden RD Object Start -------->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

</form>
</body>
</html>