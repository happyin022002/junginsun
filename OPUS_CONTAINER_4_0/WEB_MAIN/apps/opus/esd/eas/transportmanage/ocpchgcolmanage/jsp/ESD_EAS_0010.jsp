<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0010.jsp
*@FileTitle : OCP Charge Collection Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.event.EsdEas0010Event"%>


<%

	SignOnUserAccount account = null; //Session 
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
<title>OCP Charge Collection Management</title>
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

		     	<table class="search" border="0">
	              <tr><td class="bg">
		                  <table class="search_in" border="0">
		                    	<tr class="h23">
			                      <td width="120"><%//<img class="nostar">%>Control Office</td>
			                      <td width="120">
			                        <input  type="text" name="s_ctrl_ofc_cd" id="s_ctrl_ofc_cd" style="width:60;" value="<%=account.getOfc_cd()%>" onChange="javascript:fun_officeText();" onKeyup="javascript:upperCase(this);">
						            <img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office" >
			                      </td>
			                     
			                      <td width="170"><%//<img class="nostar">%>MT Return Loc/Yard</td>
			                      <td width="120">
			                      	<input name="s_mt_rtn_cd" type="text" style="width:60" value="" onKeyup="javascript:upperCase(this);">
			                      	<img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_loc" >
			                      </td>
     		                      
			                      <td width="67"><%//<img class="nostar">%>Booking</td>
			                      <td width="120" class="stm"><input type="text" style="width:95" name="s_bkg_no" value="" onKeyUp="chkField(this, 'eng_num', true, 13)" maxlength="13" ></td>
		                    	
		                    	  <td width="80"><%//<img class="nostar">%>Consignee </td>
			                      <td width="300">
			                        <input type="text" style="width:60" name="s_cnee_no">
			                        <img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust" >
			                        <input type="text" style="width:180" name="s_cust_nm">			                        
			                      </td>	
		                    	
		                    	</tr>
		                    </table>
                    
		                    <table class="search_in" border="0">
			                    <tr class="h23">
  		  	                        
			                      	<td width="125"><%//<img class="nostar">%>MT Return Period</td>
			                      	
			                      	<td>
			                        <input type="text" style="width:65" name="fm_dt" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8); pointAutoMove(this.value);" maxlength="8" >
			                        &nbsp;~&nbsp;
			                        <input type="text" style="width:65" name="to_dt" value="yyyymmdd" onClick="selectText(this);" onKeyUp="chkField(this, 'num', true, 8)" maxlength="8" >
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
			<table class="gridtitle"><tr><td>● BKG-OCP : This is the total OCP charge of a booking, not the OCP charge of a container.<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Be careful in checking the OCP charge for each container.
			<td></td></tr></table>
			

    </td></tr>
</table>
<!-- Outer Table (E)-->

</body>
</html>
