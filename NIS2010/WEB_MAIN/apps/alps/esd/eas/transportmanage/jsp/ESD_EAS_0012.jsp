<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0012.jsp
*@FileTitle : Drop Off Charge Collection Inqury
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-21
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-21 choice
* 1.0 최초 생성
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0012Event"%>


<%

	SignOnUserAccount account = null; //Session 정보
	String ctrl_user_id = "";
	String old_ofc_cd = "";
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		ctrl_user_id = account.getUsr_id();
		old_ofc_cd = account.getOfc_cd();
	}catch(Exception e) {
		out.println("<!-- acount ... error -->");
	}
%>

<html>
<head>
<title>Drop Off Charge Collection Inqury</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ctrl_user_id" value="<%=ctrl_user_id%>">
<input type="hidden" name="old_ofc_cd" value="<%=old_ofc_cd%>">

<input type="hidden" name="haul_cd" >
<input type="hidden" name="tromonth" >
<input type="hidden" name="fromtrodate" >
<input type="hidden" name="totrodate" >
<input type="hidden" name="mt_rtn_mth" >
<input type="hidden" name="fm_mt_rtn_prd" >
<input type="hidden" name="to_mt_rtn_prd" >
<input type="hidden" name="fst_ofc_cd" value="<%=account.getOfc_cd()%>">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
						<tr><td class="btn1_bg">

								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

									<td class="btn1_line"></td>

									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->

								</tr></table>

						</td></tr>
					</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table class="search" border="0">
	              <tr><td class="bg">
	              		<table class="search_in" border="0">
			                    <tr class="h23">
			                      <td width="1" ><input type="radio" name="sel_tp_cd" value="1" class="trans" onClick="selectTpCd(this.value);" checked></td>
			                      <td width="110">Booking No.</td>
			                      <td><input name="bkg_no" type="text" style="width:120" value="" onKeyup="javascript:upperCase(this);"></td>
			                      
			                    </tr>
			            </table>	
		                  <table class="search_in" border="0">
		                    	<tr class="h23">
			                      <td width="10"><input type="radio" name="sel_tp_cd" value="2" class="trans" onClick="selectTpCd(this.value);" ></td>
			                      <td width="110">TRO Office</td>
			                      <td width="240">
			                        <input  type="text" name="ctrl_ofc_cd" style="width:60;"  onChange="javascript:fun_officeText();" onKeyup="javascript:upperCase(this);">
						            <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office" >
			                      </td>
			                      <td width="60">Haulage</td>
			                      <td width="40"><select name="haul_cd_t" style="width:40;" >
			                          <option value="X" selected> </option>
			                          <option value="A">All</option>
			                          <option value="M">M</option>
			                          <option value="C">C</option>
			                          </select></td>
			                      <td width="140">
			                        <input type="radio" id="search_choice_t1" name="search_choice_t" value="MM" class="trans" onClick="selectWhere('t');" checked>
			                        TRO Month</td>
			                      <td>
			                        <input type="text" style="width:65" id="tromonth_t" name="tromonth_t" value="" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 6)" maxlength="6" >
			                      </td>
			                      <td width="140">
			                        <input type="radio" id="search_choice_t2" name="search_choice_t" value="DD" class="trans" onClick="selectWhere('t');">
			                        TRO Period</td>
			                      <td class="stm">
			                        <input type="text" style="width:65" name="fromtrodate_t" id="fromtrodate_t" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8); pointAutoMove(this.value,'1');" maxlength="8" >
			                        ~
			                        <input type="text" style="width:65" name="totrodate_t" id="totrodate_t" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8)" maxlength="8" >
			                      </td>
		                    	</tr>
		                    </table>
		                    <table class="search_in" border="0">
		                    	<tr class="h23">
			                     <td width="10"><input type="radio" name="sel_tp_cd" value="3" class="trans" onClick="selectTpCd(this.value);"></td>
			                      <td width="110">RFA</td>
			                      <td width="240"><input name="rfa_no" type="text" style="width:120" value="" onKeyup="javascript:upperCase(this);"></td>
			                      <td width="60">Haulage</td>
			                      <td width="40"><select name="haul_cd_r" style="width:40;" >
			                          <option value="X" selected> </option>
			                          <option value="A">All</option>
			                          <option value="M">M</option>
			                          <option value="C">C</option>
			                          </select></td>
			                      <td width="140">
			                        <input type="radio" name="search_choice_r" id="search_choice_r1" value="MM" class="trans" onClick="selectWhere('r');" checked>
			                        MT Return Month</td>
			                      <td>
			                        <input type="text" style="width:65" name="tromonth_r" value="" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 6)" maxlength="6" >
			                      </td>
			                      <td width="140">
			                        <input type="radio" name="search_choice_r" id="search_choice_r2" value="DD" class="trans" onClick="selectWhere('r');">
			                        MT Return Period</td>
			                      <td class="stm">
			                        <input type="text" style="width:65" name="fromtrodate_r" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8); pointAutoMove(this.value,'2');" maxlength="8" >
			                        ~
			                        <input type="text" style="width:65" name="totrodate_r" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8)" maxlength="8" >
			                      </td>
		                    	</tr>
		                    </table>
		                    <table class="search_in" border="0">
		                    	<tr class="h23">
			                      <td width="10"><input type="radio" name="sel_tp_cd" value="4" class="trans" onClick="selectTpCd(this.value);"></td>
			                      <td width="110">Import Merchant</td>
			                      <td width="240"> 
			                        <input type="text" style="width:60" name="cust_cd" onKeyup="javascript:upperCase(this);" >
			                        <input type="text" style="width:150" name="cust_nm">
			                        <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust" >
			                      </td>
			                      <td width="60">Haulage</td>
			                      <td width="40"><select name="haul_cd_i" style="width:40;" >
			                          <option value="X" selected> </option>
			                          <option value="A">All</option>
			                          <option value="M">M</option>
			                          <option value="C">C</option>
			                          </select></td>
			                      <td width="140">
			                        <input type="radio" name="search_choice_i" id="search_choice_i1" value="MM" class="trans" onClick="selectWhere('i');" checked>
			                        MT Return Month</td>
			                      <td>
			                        <input type="text" style="width:65" name="tromonth_i" value="" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 6)" maxlength="6" >
			                      </td>
			                      <td width="140">
			                        <input type="radio" name="search_choice_i" id="search_choice_i2" value="DD" class="trans" onClick="selectWhere('i');">
			                        MT Return Period</td>
			                      <td class="stm">
			                        <input type="text" style="width:65" name="fromtrodate_i" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8); pointAutoMove(this.value,'3');" maxlength="8" >
			                        ~
			                        <input type="text" style="width:65" name="totrodate_i" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8)" maxlength="8" >
			                      </td>
		                    	</tr>
		                    </table>
		                    <table class="search_in" border="0">
		                    	<tr class="h23">
			                      <td width="10"><input type="radio" name="sel_tp_cd" value="5" class="trans" onClick="selectTpCd(this.value);"></td>
			                      <td width="110">MT Return Loc</td>
			                      <td width="240">
			                        <input name="return_cy" type="text" style="width:60" value="" onKeyup="javascript:upperCase(this);"></td>
			                      <td width="60">Haulage</td>
			                      <td width="40"><select name="haul_cd_m" style="width:40;" >
			                          <option value="X" selected> </option>
			                          <option value="A">All</option>
			                          <option value="M">M</option>
			                          <option value="C">C</option>
			                          </select></td>
			                      <td width="140">
			                        <input type="radio" name="search_choice_m" id="search_choice_m1" value="MM" class="trans" onClick="selectWhere('m');" checked>
			                        MT Return Month</td>
			                      <td>
			                        <input type="text" style="width:65" name="tromonth_m" value="" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 6)" maxlength="6" >
			                      </td>
			                      <td width="140">
			                        <input type="radio" name="search_choice_m" id="search_choice_m2" value="DD" class="trans" onClick="selectWhere('m');">
			                        MT Return Period</td>
			                      <td class="stm">
			                        <input type="text" style="width:65" name="fromtrodate_m" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8); pointAutoMove(this.value,'4');" maxlength="8" >
			                        ~
			                        <input type="text" style="width:65" name="totrodate_m" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8)" maxlength="8" >
			                      </td>
		                    	</tr>
		                    </table>
	               </td></tr>
		</table>


		<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>


			<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg">
				<table width="100%" id="mainTable">
		              <tr><td>
		                     <script language="javascript">ComSheetObject('sheet1');</script>
		              </td></tr>
				</table>
					</td>
				</tr> 
			</table>
			<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
			<table class="height_10"><tr><td></td></tr></table>
			<table class="gridtitle"><tr><td>● DOD Amt : This is the total DOD amount of a booking, not the DOD amount of a container.</td><td></td></tr></table>
			

    </td></tr>
</table>
<!-- Outer Table (E)-->

</body>
</html>
