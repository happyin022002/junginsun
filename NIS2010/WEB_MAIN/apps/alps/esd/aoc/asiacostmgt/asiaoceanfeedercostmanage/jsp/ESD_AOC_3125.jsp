<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_AOC_3125.jsp
*@FileTitle : Ocean Feeder Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.event.EsdAoc3125Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%
	EsdAoc3125Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdAoc3125Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String costFactorCd  = JSPUtil.getCodeCombo("f_sys_src_cd" , "01", "style='width:120'", "CD03050", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Ocean Feeder Cost Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("f_sys_src_cd" , "", "CD03050", 0, "")%>

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
<input type="hidden" name="bnt_flg" value="N">

<input type="hidden" name="excel_date_flg">
<input type="hidden" name="excel_from_dt">
<input type="hidden" name="excel_to_dt">
<input type="hidden" name="excel_eff_to_dt">
<input type="hidden" name="excel_cost_trf_no">
<input type="hidden" name="excel_pctl_io_bnd_cd">
<input type="hidden" name="excel_from_nod_cd">
<input type="hidden" name="excel_to_nod_cd">
<input type="hidden" name="excel_cost_factor_cd">
<input type="hidden" name="excel_sys_src_cd">
<input type="hidden" name="excel_adjustment_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
			<!--Page Title, Historical (E)-->
	
			<!--Button (S) -->
	        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
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
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				                    <tr>
					                    <td class="btn1_left"></td>
					                    <td class="btn1" name="btn_disp_excel">Down Excel without Displaying</td>
					                    <td class="btn1_right"></td>
				                    </tr>
				                	</table>
				                </td>
				            </tr>
			            </table>
		        	</td>
		        </tr>
	        </table>
			<!--Button (E) -->
	    	
			<!--biz page (S)-->
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="78">Date</td>
								<td width="400" colspan="3">
									<script language="javascript">ComComboObject('date_flg', 1, 104, 1, 0);</script>
									<input type="hidden" name="now_date" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd")%>">
									<input type="hidden" name="last_day" value="<%=DateTime.lastDayOfMonth(DateTime.getFormatDate(new Date(),"yyyyMMdd"))%>">
									<input type="text" name="from_dt" style="width:80;" class="input" dataformat="ymd" maxlength="8" caption="From to Date">&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:80;" class="input" dataformat="ymd" maxlength="8" caption="From to Date">&nbsp;<img src="img/btns_calendar.gif" name="from_to_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								<td width="90">Effective as of</td>
								<td width="170"><input type="text" name="eff_to_dt" style="width:80;" class="input" dataformat="ymd" maxlength="8">&nbsp;<img src="img/btns_calendar.gif" name="bnt_eff_to_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="84">Cost Tariff No</td>
								<td width="">
									<input name="cost_trf_no" type="text" dataformat="uppernumcomma" style="width:100;">
									<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="so_OnPopupClick('cost_trf_no');">
								</td>
							</tr>
							<tr class="h23">
								<td width="78">Pre/Post</td>
								<td width="130"><script language="javascript">ComComboObject('pctl_io_bnd_cd', 1, 104, 1, 0);</script></td>
								<td width="100">From</td>
								<td width="170">
									<input name="from_nod_cd" type="text" dataformat="uppernumcomma" style="width:100;">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_from">
									<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="so_OnPopupClick('from');">
								</td>
								<td width="90">To</td>
								<td colspan="3">
									<input name="to_nod_cd" type="text" dataformat="uppernumcomma" style="width:100;">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_to">
									<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="so_OnPopupClick('to');">
								</td>
							</tr>
							<tr class="h23">
								<td width="78">Cost Factor</td>
								<td><script language="javascript">ComComboObject('cost_factor_cd', 1, 104, 1, 0);</script></td>
								<td>System Source</td>
								<td><script language="javascript">ComComboObject('sys_src_cd', 1, 104, 1, 0);</script></td>
								<td>Adjustment</td>
								<td colspan="3"><script language="javascript">ComComboObject('adjustment_cd', 1, 104, 1, 0);</script></td>
							</tr>
						</table>
						<!-- biz_1  (E) -->		
					</td>
				</tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>
	
			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) -->
	
			<!-- TAB [ Dry ] (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search"> 
					<tr>
						<td class="bg" style="height:338" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
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
															<td class="btn2" name="btn_cost_detail1">Cost Detail</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_down_excel1">Down Excel</td>
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
			<!-- TAB [ Dry ] (E) -->
			
				
			<!-- TAB [ Dangerous ] (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search"> 
					<tr>
						<td class="bg" style="height:338" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
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
															<td class="btn2" name="btn_down_excel2">Down Excel</td>
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
			<!-- TAB [ Dangerous ] (E) -->
			
			
			<!-- TAB [ Reefer ] (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search"> 
					<tr>
						<td class="bg" style="height:338" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet3');</script>
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
															<td class="btn2" name="btn_cost_detail3">Cost Detail</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_down_excel3">Down Excel</td>
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
			<!-- TAB [ Reefer ] (E) -->

		</td>
	</tr>
</table>

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
<iframe name="CommandFrame" style="display:none"></iframe>
</body>
</html>