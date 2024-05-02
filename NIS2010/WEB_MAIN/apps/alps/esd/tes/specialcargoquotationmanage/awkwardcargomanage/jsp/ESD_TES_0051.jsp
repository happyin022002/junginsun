<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0051.jsp
*@FileTitle : AWK Cargo Basic Management
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.04
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.04 이혜민
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
<%@ page import="com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event.EsdTes0051Event"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes0051Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String templateKey 		= null;
	String tmpKey[] 		= null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsdTes0051Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
				
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		// Excel Template File Key
		templateKey = eventResponse.getCustomData("templateKey").toString();
		
		tmpKey = templateKey.split("@");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>AWK Cargo Basic Management</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="tml_awk_cgo_trf_tp_cd">
<input type="hidden" name="yd_cd">
<input type="hidden" name="fm_yd_cd">
<input type="hidden" name="to_yd_cd">
<input type="hidden" name="lg_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="lg_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="lcl_amt">
<input type="hidden" name="usd_amt">
<input type="hidden" name="curr_cd">
<input type="hidden" name="usd_xch_dt">
<input type="hidden" name="select_row">
<input type="hidden" name="select_col">
<input type="hidden" name="prefix">
<input type="hidden" name="man_usd_amt">
<input type="hidden" name="calc_app_ext_cost">
<input type="hidden" name="total_sum_cost">
<input type="hidden" name="templateKey" value="<%=templateKey %>">
<input type="hidden" name="templateKey1" value="<%=tmpKey[0] %>">
<input type="hidden" name="templateKey2" value="<%=tmpKey[1]%>">
<input type="hidden" name="templateKey3" value="<%=tmpKey[2] %>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;AWK Cargo Basic Management</td></tr>
	        </table>
			<!--Page Title, Historical (E)-->
			<!--biz page (S)-->
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;" id="basictstab"> 
							<tr class="h23">
								<td width="50">Port</td>					
								<td width="250">
									<input type="text" name="port_cd" style="width:60;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_port" border="0" align="absmiddle" class="cursor">&nbsp;<script language="javascript">ComComboObject('tml_cd_combo', 1, 45, 1, 0);</script>
			                    </td>
								<td width="90">Year/Month</td>
								<td width="180">
									<input type="text" name="year_month"  dataformat="ym" style="width:60;text-align:center;ime-mode:disabled;" readonly class="input1" maxlength="6" value="">&nbsp;<img src="img/btns_calendar.gif" name="btn_Calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								<td width="140">Tariff Condition</td>
								<td width="450">
									<input type="text" name="cond_no" style="width:35;text-align:center;ime-mode:disabled;" readonly class="input2" value="">
									<input type="text" name="cond_desc" style="width:270;text-align:left;ime-mode:disabled;" readonly class="input2" value="">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_trfCond" border="0" align="absmiddle" class="cursor">
								</td>
			                    <td width="20"></td>
							</tr>
						</table>	
						<!-- biz_1  (E) -->		
		                <!-- biz_2  (S) -->
		                <table class="search" border="0" style="width:979;" id="shuttletab"> 
			                <tr class="h23">
			                  <td width="50">From</td>          
			                  <td width="140">
			                  	<input type="text" name="fm_loc_cd" style="width:60;text-align:center;" class="input" value="" onKeyPress="ComKeyOnlyAlphabet('uppernum')" style="ime-mode:disabled" maxlength="5">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_port_fr" border="0" align="absmiddle" class="cursor">
			                  </td>
			                  <td width="30">To</td>          
			                  <td width="145">
			                  	<input type="text" name="to_loc_cd" style="width:60;text-align:center;" class="input" value="" onKeyPress="ComKeyOnlyAlphabet('uppernum')" style="ime-mode:disabled" maxlength="5">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_port_to" border="0" align="absmiddle" class="cursor">
			                  </td>
			                  <td width="140">Tariff Condition</td>
							  <td width="450">
								  <input type="text" name="cond_no_t3" style="width:35;text-align:center;ime-mode:disabled;" readonly class="input2" value="">
								  <input type="text" name="cond_desc_t3" style="width:270;text-align:left;ime-mode:disabled;" readonly class="input2" value="">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_t3trfCond" border="0" align="absmiddle" class="cursor">
							  </td>
			                  <td width="250"></td>
			                </tr>
		                </table>  
		                <!-- biz_2  (E) --> 
					</td>
				</tr>
			</table>		
			
   			<table class="height_8"><tr><td></td></tr></table>	
    
			<!-- Tab ) (S) -->
		 	<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
		   		<tr><td width="40%">
					<script language="javascript">ComTabObject('tab1')</script>
					</td>
					<td style="text-align:right; color: #003399;">Please contact CCB for further inquires.</td>
				</tr>
			</table>
			<!-- Tab ) (E) --> 

			<!--TAB Basic (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search"> 
			    	<tr>
				    	<td class="bg" style="height:438" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet1');</script>
									</td>
								</tr>
							</table>			
							<!-- Grid (E) -->	
							<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
						       	<tr>
							       	<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1calc">Calculation</td>
															<td class="btn2_right"></td>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1rowadd">Row Add</td>
															<td class="btn2_right"></td>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1rowdelt">Row Delete</td>
															<td class="btn2_right"></td>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1rowcopy">Row Copy</td>
															<td class="btn2_right"></td>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t1exlform">Excel Form</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
					    	<!-- Button_Sub (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!--TAB Basic (E) -->


			<!--TAB T/S (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search"> 
				    <tr>
				    	<td class="bg" style="height:438" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet1');</script>
									</td>
								</tr>
							</table>			
							<!-- Grid (E) -->	
							<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
						       	<tr>
						       		<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2rowadd">Row Add</td>
															<td class="btn2_right"></td>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2rowdelt">Row Delete</td>
															<td class="btn2_right"></td>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2rowcopy">Row Copy</td>
															<td class="btn2_right"></td>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t2exlform">Excel Form</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
					    	<!-- Button_Sub (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!--TAB T/S (E) -->
			
			<!--TAB AddOn (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search"> 
				    <tr>
					    <td class="bg" style="height:438" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t3sheet1');</script>
									</td>
								</tr>
							</table>			
							<!-- Grid (E) -->	
							<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
						       	<tr>
						       		<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t3rowadd">Row Add</td>
															<td class="btn2_right"></td>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_t3rowdelt">Row Delete</td>
															<td class="btn2_right"></td>
										                    <td class="btn2_left"></td>
										                    <td class="btn2" name="btn_t3rowcopy">Row Copy</td>
										                    <td class="btn2_right"></td>
										                    <td class="btn2_left"></td>
															<td class="btn2" name="btn_t3exlform">Excel Form</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
					   		<!-- Button_Sub (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!--TAB AddOn (E) -->

			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
		       	<tr>
			       	<td class="btn1_bg">
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
									<td class="btn1" name="btn_New" id="btn_New">New</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_His" id="btn_His">History</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Exlup" id="btn_Exlup">Excel upload</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		    <!--Button (E) -->
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>

<form name="downform1" action="/hanjin/FileDownload" method="post" target="downifm">
	<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=tmpKey[0]%>">
</form>

<form name="downform2" action="/hanjin/FileDownload" method="post" target="downifm">
	<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=tmpKey[1]%>">
</form>

<form name="downform3" action="/hanjin/FileDownload" method="post" target="downifm">
	<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=tmpKey[2]%>">
</form>

<iframe name="downifm" style="display:none;"></iframe>
</body>
</html>