<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0087.jsp
*@FileTitle :GL Inquiry of Owner's Account
*@LastModifyDate : 2012.06.18
*@LastModifier : 전상화
*@LastVersion : 1.0
* 2012.06.18 전상화
* 1.0 Creation
* 
* 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0087Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0087Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0087Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>
<html>
<head>
<title>Owner's Account</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="searchType">
 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
      	<tr><td align="right">
	    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_stl">Settle Creation</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
					</tr>
				</table></td>  	
				<!--<td class="btn1_line"></td>-->			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_saveToFile">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr></table>
		</td></tr>
	</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
	<table class="search"> 
      	<tr><td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">GL Inquiry of Owner's Account</td></tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="120"><input type="radio" value="L" name="dt_opt" class="trans" checked>Ledger Date</td>
				<td width="320"><input type="text" name="ldgr_dt" class="input1" maxlength="8" dataformat="ymd" fullfill caption="Ledger Date" style="width:80;text-align:center;ime-mode:disabled;" value="">&nbsp;<img src="img/btns_calendar.gif" name="btn_ldgrDt" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td>
				
				<td width="90">&nbsp;&nbsp;Settled</td>
				<td width="280"><select style="width:78;" class="input" name="stl_flg">
						<option value="A" selected>All</option>
                        <option value="Y">Yes</option>
                        <option value="N">No</option></select></td>
				<td width=""></td>
				<td width=""></td>
			</tr>
			
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="120"><input type="radio" value="E" name="dt_opt" class="trans">Effective Date</td>
				<td width="320"><input type="text" name="eff_dt1" class="input1" maxlength="8" dataformat="ymd" fullfill caption="Effective Date From" style="width:80;text-align:center;ime-mode:disabled;" value="">&nbsp;<img src="img/btns_calendar.gif" name="btn_effDt1" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="eff_dt2" class="input1" maxlength="8" dataformat="ymd" fullfill cofield="eff_dt1" caption="Effective Date To" style="width:80;text-align:center;ime-mode:disabled;" value="">&nbsp;<img src="img/btns_calendar.gif" name="btn_effDt2" class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td>
				
				<td width="90">&nbsp;&nbsp;Vessel Code</td>
				<td width="280">
				<input type="text" name="vsl_cd" style="width:57;text-align:center;ime-mode:disabled" class="input" maxlength="4" fullfill caption="Vessel Code">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vslPop" width="19" height="20" alt="" border="0" align="absmiddle">
				
				&nbsp;<input type="text" style="width:140;" class="input2" name="vsl_eng_nm" readonly>
				<input type="checkbox" name="btn_vslCdClr" class="trans">
				</td>
				<td width=""></td>
				<td width=""></td>
			</tr>
			
			</table>

			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
			<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet');</script>
						</td>
					</tr>
				</table> 					 
					<!-- Grid (E) -->
		
		
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
   			<tr class="h23">
	   			<td width="228" style="text-align:right;">Total Amount&nbsp;&nbsp;</td>
	   			<td>
	    			<table border="0" width=110>
	    				<tr>
	    					<td><input type="text" name="amountSum_Owner_01" style="width:100;text-align:right;" class="input2" dataformat="float" value="" readonly ></td>
	    				</tr>
	    			</table>
	   			</td>
	   			<td width="128" style="text-align:right;">Checked Amount&nbsp;&nbsp;</td>
	   			<td>
	    			<table border="0" width=120>
	    				<tr>
	    					<td><input type="text" name="chk_amt" style="width:100;text-align:right;" class="input2" dataformat="float" value="" readonly ></td>
	    				</tr>
	    			</table>
	   			</td>
	   		<td width=400>&nbsp;</td>
   		
   		</tr>
   	</table>		
		
	
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
      	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>   
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_stl">Settle Creation</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
					</tr>
				</table></td>  				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_saveToFile">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
				
			</table>
		</td></tr>
	</table>
    <!--Button (E) -->

</td></tr>
</table>
<!-- 
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>