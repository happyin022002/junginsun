<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0034.jsp
*@FileTitle : EQ Availability
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.06.24 김종준
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0034Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EqavailAbilityFinder.EqavailAbilityFinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim0034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>EQ Operation Trend (Inventory Trend)</title>
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



<body  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 

<input type="hidden" name="param_loc_type_code" value=""> 
<input type="hidden" name="param_loc_cd" value=""> 
<input type="hidden" name="param_cntr_tpsz_cd_val1" value=""> 
<input type="hidden" name="param_cntr_tpsz_cd_val2" value=""> 
<input type="hidden" name="param_cntr_tpsz_cd_val3" value=""> 
<input type="hidden" name="param_cntr_tpsz_cd_val4" value=""> 


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->


<div id="showMin" style="display:inline">	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="95">Location Level</td>
					<td width="220">
						<select style="width:60;" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="S" selected>SCC</option>
							<option value="Y">Yard</option>
						</select>
						<input type="text" class="input1" name="loc_cd" style="ime-mode:inactive" required dataformat="engup" size="7"   style="width:70;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="50">TP/SZ</td>
					<td width="300">
						<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 100, 1);</script>					
						&nbsp;<input type="text" name="cntr_tpsz_cd_val1" dataformat="engup" size="2" maxlength="2" fulfill style="width:30;" class="input1" value="D2">&nbsp;<input type="text" name="cntr_tpsz_cd_val2" dataformat="engup" size="2" maxlength="2" fulfill style="width:30;" class="input" value="D4">&nbsp;<input type="text" name="cntr_tpsz_cd_val3" dataformat="engup" size="2" maxlength="2" fulfill style="width:30;" class="input" value="D5">&nbsp;<input type="text" name="cntr_tpsz_cd_val4" dataformat="engup" size="2" maxlength="2" fulfill style="width:30;" class="input" value="D7">
					</td>
					<td width="50">Period</td>
					<td class="stm">
						<input type="text" name="fm_fcast_dt" style="width:80;" readonly class="input2" value="">&nbsp;~&nbsp;
						<input type="text" name="to_fcast_dt" style="width:80;" readonly class="input2" value="">&nbsp;
					</td>
					<td align="right">
						<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" style="color:3D5A7A;"  name="past_Br" id="past_Br">Past BR</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
					</td>					
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
</div>			

		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr>
       		<td class="bg">
			<!-- Grid - 1 (S) -->
			<div id="showsheet1" style="display:block">	
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<table width="100%">
								<tr>
									<td>
										<table>
											<tr>
												<td align="right">
													<img class="cursor" img src="img/bu_next01.gif" border="0" name="btn_minimize1" id="btn_minimize1">
												</td>
											</tr>
											<tr>
												<td>
												<script language="javascript">ComSheetObject1('sheet1');</script>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table> 			
			</div>
			<!-- Grid - 1 (E) -->

			<!-- Grid - 2 (S) -->
			<div id="showsheet2" style="display:block">
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<table width="100%">
								<tr>
									<td>
										<table>
											<tr>
												<td align="right">
													<img class="cursor" img src="img/bu_next01.gif" border="0" name="btn_minimize2" id="btn_minimize2">
												</td>
											</tr>
											<tr>
												<td>
												<script language="javascript">ComSheetObject1('sheet2');</script>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>

						</td>
					</tr>
				</table> 			
			</div>
			<!-- Grid - 2 (E) -->
			<!--  Grid_button (E) -->
			</td>
		</tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>
</form>
</body>
</html>
