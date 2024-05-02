<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0021.jsp
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.09 김종준
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
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//MVMT Status 멀티콤보 
	    String temp_cnmv_sts_cd = JSPUtil.getIBCodeCombo("", "", "CD02086", 0, "");
	    if(temp_cnmv_sts_cd != null && temp_cnmv_sts_cd.length() > 8) {
	    	cnmv_sts_cd = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Code = \"")+8, temp_cnmv_sts_cd.lastIndexOf("\""));
	    	cnmv_sts_nm = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Text = \"")+8, temp_cnmv_sts_cd.indexOf("\";")); 
	    }						
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Container Staying Days (Summary)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>");
	}
</script>
</head>
<body  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cnmv_sts_cd1" value="IC">
<input type="hidden" name="cnmv_sts_cd2" value="ID">
<input type="hidden" name="cnmv_sts_cd3" value="MT">
<input type="hidden" name="cnmv_sts_cd4" value="OP">
<input type="hidden" name="cnmv_sts_cd5" value="OC">
<input type="hidden" name="cnmv_sts_cd6" value="TN">
<input type="hidden" name="cnmv_sts_cd7" value="EN">
<input type="hidden" name="cnmv_sts_cd8" value="TS">

<input type="hidden" name="param_loc_type_code" value="">
<input type="hidden" name="param_loc_cd" value="">
<input type="hidden" name="param_cntr_tpsz_cd" value="">
<input type="hidden" name="param_dmg_flg" value="">
<input type="hidden" name="param_cntr_use_co_cd" value="">
<input type="hidden" name="param_over_stay_days" value="">
<input type="hidden" name="param_cnmv_sts_cd" value="">
<input type="hidden" name="param_uclm_ls_div_cd" value="">
<input type="hidden" name="param_full_flg" value="">
<input type="hidden" name="param_lstm_cd" value="">
<input type="hidden" name="param_soc_cd" value="">

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="80">Location by</td>
					<td width="92">
						<select style="width:100;" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="" selected>All (by RCC)</option>
							<option value="1">RCC (by LCC)</option>
							<option value="7">RCC (by ECC)</option>
							<option value="2">LCC (by ECC)</option>
							<option value="3">LCC (by SCC)</option>
							<option value="4">ECC (by SCC)</option>
							<option value="5">SCC (by Yard)</option>
							<option value="6">Yard</option>
							<!-- loc_cd --> 
						</select>
					</td>
					<td width="148"><input type="text" class="input2" name="loc_cd" style="ime-mode:inactive" readonly dataformat="engup" size="7" maxlength="7" fulfill  style="width:70;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
					
					<td width="87">TP/SZ</td>
					<td width="180">
						<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 115, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_cntr_tpsz_cd" readOnly=true  class="input" value=""> -->					
					</td>
					<td width="50">DMG</td> 
					<td width="150">
						<select name="dmg_flg" style="width:100;" class="input">
							<option value="" selected>Include</option>
							<option value="N">Exclude</option>
							<option value="Y">Only</option>
						</select>
					</td>
					<td width="100">Company</td>
					<td width="">
						<input type="text" class="input" name="tem_cntr_use_co_cd" readOnly=true style="width:30;" class="input" value="SML">
						<input type="hidden" name="cntr_use_co_cd" value="H">
					</td>
					
				</tr>
				<tr><td style="height:5"></td></tr>
				</table>	
					
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				    <td width="80">Sales OFC</td>
					<td width="250">
						<input type="text" name="ofc_cd" caption="Office" style="width:55;text-align:center;" class="input" value="" dataformat="engup" maxlength="5">
						<img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="87">MVMT Status</td>
					<td width="180">
						<script language="javascript">ComComboObject('cnmv_sts_cd', 1, 115, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_cnmv_sts_cd" readOnly=true  class="input" value=""> -->
					</td>
					<td width="50">Unclaim</td> 
					<td width="150"><select name="uclm_ls_div_cd" style="width:100;" class="input">
						<option value="E" selected>Exclude</option>	
						<option value="I">Include</option> 
						<option value="O">Only</option>
						</select>
					</td>
					<td width="100">Staying Day</td>
					<td width="" class="stm">
						<input type="text" name="over_stay_days" style="width:40; text-align:right;" dataformat="int" class="input" value="31">&nbsp;or over
					</td>
				</tr>
				<tr><td style="height:5"></td></tr>
				</table>			
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23"> 
					<td width="80">Cargo type</td>
					<td width="250">
						<select name="full_flg" style="width:80;" class="input">
							<option value="" selected></option>
							<option value="Y">Full</option>
							<option value="N">MTY</option>
						</select>
					</td>
					<td width="87">Lease Term</td>
					<td width="180">
						<script language="javascript">ComComboObject('lstm_cd', 1, 115, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_lstm_cd" readOnly=true  class="input" value=""> -->
					</td>
					<td width="50">S.O.C</td> 
					<td width="150">
						<select name="soc_cd" style="width:100;" class="input">
							<option value="1"selected>Exclude</option>
							<option value="">Include</option>
							<option value="2">Only</option>
						</select>
					</td>
					<td width="100">Within Free Day</td> 
					<td width="">
						<select name="free_cd" style="width:80;" class="input">
							<option value="1"selected>Exclude</option>
							<option value="">Include</option>
							<option value="2">Only</option>
						</select>
					</td>
				</tr> 
				</table>		
				<!--  biz_1   (E) -->

		</td></tr>
		</table>	
		<!-- 1 (E) -->
		
		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 			
			
			
			
			
<!--TAB  (S) -->
<div id="tabLayer" style="display:inline">			
		<!-- 2 (S) -->		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 1 (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1detail1" valuue="1">&nbsp;&nbsp;&nbsp;Detail&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1detail2">L/S & U/C Creation<td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

			
			</td></tr>
		</table>
		<!-- 2 (E) -->
</div>
<!--TAB  (E) -->		




<!--TAB  (S) -->
<div id="tabLayer" style="display:none">
		<!-- 2 (S) -->		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 1 (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1detail3" valuue="2">&nbsp;&nbsp;&nbsp;Detail&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1detail2">L/S & U/C Creation<td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					</tr></table>
					
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

			
			</td></tr>
		</table>
		<!-- 2 (E) -->
</div>
<!--TAB  (E) --> 




<!-- (TAB) Total S/Days (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>	
			<!-- Grid - 1 (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3ByMVMTStatus">By MVMT Status</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3detail">&nbsp;&nbsp;&nbsp;Detail&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

			
			</td></tr>
		</table>

</div>
<!-- (TAB) Total S/Days (E) -->
		
		
	
		<!--biz page (E)-->
	
	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>


</form>
</body>
</html>
