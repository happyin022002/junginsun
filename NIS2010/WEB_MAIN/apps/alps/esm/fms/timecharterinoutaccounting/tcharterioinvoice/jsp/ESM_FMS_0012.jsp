<%
/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : ESM_FMS_0012.jsp
* @FileTitle : Prepayments
* Open Issues :
* Change history :
* @LastModifyDate : 2009.06.22
* @LastModifier : 정윤태 
* @LastVersion : 1.0
* 2009.06.22 정윤태
* 1.0 최초 생성
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";	
	
	String usrId = "";
	String strUsr_nm		= "";
	String strOfc_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	usrId = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_nm = account.getOfc_eng_nm();
	   	
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
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

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
<input type="hidden" name="ppay_hir_no">
<input type="hidden" name="ori_eff_dt">
<input type="hidden" name="ori_exp_dt">
<input type="hidden" name="ori_inv_usd_dys">
<input type="hidden" name="flet_ctrt_tp_gb">
<input type="hidden" name="usr_id" value="<%=usrId%>">
<!-- for print -->
<input type="hidden" name="usr_nm" value="<%=strUsr_nm%>" >
<input type="hidden" name="ofc_nm" value="<%=strOfc_nm%>">
<input type="hidden" name="hire_no">
<input type="hidden" name="chk_pay_hir_no">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	</td></tr>
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Hire Creation & Inquiry</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				    <td width="75">Vessel Code</td><!-- width="265" -->
					<td width="265"><input type="text" style="width:54;text-align:center;" class="input1" maxlength="4" name="vsl_cd" required fullfill caption="Vessel Code" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vslpop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:162;" class="input2" name="vsl_eng_nm" readonly></td> 
					<td width="85">Contract TP</td><!-- td width="129" -->
					<td width="130">&nbsp;<script language="javascript">ComComboObject('flet_ctrt_tp_cd', 1, 86, 1);</script></td>
					<td width=82>Contract No.</td>
					<td width="170"><input type="text" style="width:120;text-align:center;" class="input1" maxlength="15" name="flet_ctrt_no" fullfill caption="Contract No." readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="contract_no" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<!-- <td width="130"><input type="text" style="width:70;text-align:center;" class="input2" name="flet_ctrt_tp_cd" readonly></td> -->
					<td width="60">Hire No.</td><!-- width="60" --> 
					<td id="c_ppay_hir_no" style="display:;"><input type="text" style="width:45;text-align:center;" class="input1" maxlength="5" name="pay_hir_no" dataformat="int" readonly></td>
					<td id="i_ppay_hir_no" style="display:none;"><script language="javascript">ComComboObject('pay_hir_no', 1, 47, 2);</script></td>		
				</tr>																			
				<tr class="h23">
					<td>Owner Code</td>																																																					<!-- width:161; -->
					<td colspan="3"><input type="text" style="width:30;text-align:center;" class="input2" name="cust_cnt_cd" readonly>&nbsp;<input type="text" style="width:67;text-align:center;" class="input2" name="cust_seq" readonly>&nbsp;<input type="text" style="width:386;" class="input2" name="vndr_lgl_eng_nm"  readonly></td> 
					<td>Owner Name</td>						<!-- width:185; -->
					<td colspan="3"><input type="text" style="width:235;" class="input2" name="ownr_nm" readonly></td></tr>
				<tr class="h23">
					<td width="100">Duration</td>
					<td width="510" colspan="3" class="stm"><input type="text" style="width:75;text-align:center;" class="input" name="eff_dt" maxlength="8" dataformat="ymd">&nbsp;<input type="text" style="width:50;text-align:center;" class="input" name="from_time" maxlength="4" dataformat="hm">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="ef_dt">&nbsp;~&nbsp;<input type="text" style="width:75;text-align:center;" class="input" name="exp_dt" maxlength="8" dataformat="ymd">&nbsp;<input type="text" style="width:50;text-align:center;" class="input" name="to_time" maxlength="4" dataformat="hm">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="ex_dt">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:60;text-align:right" class="input2" name="inv_usd_dys" readonly>&nbsp;Days</td> 
					<td width="85">Condition</td>
					<td colspan="3" class="stm">
									<table class="button" width="85%" border="0">
									<tr><td><input type="radio" class="trans" name="condition" value="C" checked onClick="setHireNo('C');">Creation&nbsp;&nbsp;<input type="radio" class="trans" name="condition" value="I" onClick="setHireNo('I');">Inquiry<td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_execute">Execute</a></td>
												<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
									</tr></table>
					</td>
				</tr>
				<tr class="h23">
					<td width="100">Address Comm.</td>
					<td width="100" class="stm"><input type="text" style="width:45;text-align:right;" class="input2" name="acmm_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Address Comm." readonly> %<input type="checkbox" value="N" class="trans" name="acmm_flg"></td>
					<td width="78">&nbsp;Brokerage</td>
					<td colspan="5" class="stm"><input type="text" style="width:45;text-align:right;" class="input2" name="flet_brog_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Brokerage" readonly> %<input type="checkbox" value="N" class="trans" name="brog_flg"></td>
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
					<td class="title_s">Other Lumpsum information</td></tr>
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
								<table border="0" cellpadding="0" cellspacing="0">
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_delete">Row&nbsp;Del</td>
									<td class="btn2_right"></td>
									</tr>
								</table>
							</td></tr></table>
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
				<td id="btn_delete2" style="display:''"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete2">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr id="hire_invoice" style="display:none;"><td class="btn1_left"></td>
					<td class="btn1" name="btn_invoice">Hire&nbsp;Invoice</td>
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
</form>
</body>
</html>