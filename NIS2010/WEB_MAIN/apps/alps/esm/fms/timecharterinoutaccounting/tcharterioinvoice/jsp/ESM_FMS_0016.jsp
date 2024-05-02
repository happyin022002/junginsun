<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0016.jsp
*@FileTitle : Charterer's Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2009.04.13 정윤태
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0016Event)request.getAttribute("Event");
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
<title>Charterer's Expenses</title>
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
<input type="hidden" name="ibflag">
<input type="hidden" name="curr_cd">
<input type="hidden" name="rev_yrmon">
 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
					<td class="title_s">Account Management</td></tr>
				</table>
				<table class="search" border="0" style="width:1000;"> 
				<tr class="h23">
					<td width="75">Vessel Code</td>
					<td width="230"><input type="text" style="width:54;text-align:center;" class="input1" maxlength="4" name="vsl_cd"  caption="Vessel Code" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vslpop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:132;" class="input2" name="vsl_eng_nm" readonly></td> 
					<td width="90">Contract type</td>
					<td width="100">&nbsp;<script language="javascript">ComComboObject('flet_ctrt_tp_cd', 1, 86, 1);</script></td>
					<td width="85">Contract No.</td>
					<td width="160"><input type="text" style="width:120;text-align:center;" class="input2" name="flet_ctrt_no" caption="Contract No." readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="contract_no" width="19" height="20" alt="" border="0" align="absmiddle"></td>					
					<!-- <td width="80"><input type="text" style="width:54;" class="input2" name="flet_ctrt_tp_cd" alt="" border="0" align="absmiddle" readonly></td> -->
					<td width="70">Item Name</td>
					<td width="">&nbsp;&nbsp;<input type="text" style="width:130;" class="input2" name="acct_itm_nm" readonly><input type="hidden" style="width:100;" class="input2" name="acct_cd"><input type="hidden" style="width:100;" class="input2" name="acct_itm_seq">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="item_name"><input type="checkbox" name="chkItemName" class="trans" checked onclick="setItemNameClear();" disabled></td>
			    </tr>

				<tr class="h23">
					<td>Owner Code</td><!-- width:175; -->
					<td colspan="4"><input type="text" style="width:40;" class="input2" name="cust_cnt_cd" readonly>&nbsp;<input type="text" style="width:75;text-align:center;" class="input2" name="cust_seq" readonly>&nbsp;<input type="text" style="width:300;" class="input2" name="vndr_lgl_eng_nm" readonly></td> 
					<td style="text-align:right;">Owner Name</td>
					<td colspan="2">&nbsp;&nbsp;<input type="text" style="width:200;" class="input2" name="ownr_nm" readonly></td>	
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				
					<td width="90"><input type="radio" name="dt_flg" value="I" class="trans">Invoice DT</td>
					<td width="90"><input type="radio" name="dt_flg" value="U" class="trans" checked>Update DT</td>
					<td width="243" class="stm"><input type="text" style="width:82;text-align:center;" class="input" name="from_chtr_inv_dt" maxlength="8" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="from_inv_dt">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input" name="to_chtr_inv_dt" maxlength="8" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="to_inv_dt"></td>					
					<td width="120">Charterer / Owner</td>
					<td width="118"><select style="width:100;" class="input1" name="chtr_pay_rcv_cd" onchange="setDataClear(this.value);">
								 	<option value="P" selected>Charterer</option>
                        			<option value="R">Owner</option>
                      			 </select></td>
                      			 
                   <td width="60">Approval</td>
								<td width="" class="stm" style="font-size:12;">
            						<select style="width:70;" class="input" name="apro_flg">
	            						<option value="A">All</option>
	            						<option value="Y">Y</option>
	            						<option value="N" selected>N</option>
            						</select>
                                </td>   			 
                    
			     </tr></table>
					
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				
						<!-- Grid  (S) -->
						<table width="100%" id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						
						<!-- Grid  (S) -->
						<table width="100%" id="mainTable" style="display:none;"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->

						<!--  Grid_button (S) -->
						<table width="100%" class="button"> 
	       					<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_sdms">SDMS</td>
									<td class="btn2_right"></td>
									</tr>
								</table></td>
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
								<td width='265'></td>
								<td width='90' valign="absmiddle">Total Amount</td>
								<td width='147' id="totalAmount1" valign="top"></td>
								<td id="totalAmount2" valign="top"></td>
							</tr>
						</table>
						<!-- Total 구하기 (E) -->
					
				<!--  biz_2   (E) -->
				
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
					<td class="btn1" name="btn_savetofile">Down&nbsp;Excel</td>
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