<%--
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_AOC_3111.jsp
*@FileTitle : Cost & Guideline Tariff Status Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.05
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.event.EsdAoc3111Event"%>
<%
	EsdAoc3111Event  event = null;							//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;						//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   	//DB ResultSet
	String strErrMsg = "";								 	//에러메세지
	int rowCount	 = 0;								  	//DB ResultSet 리스트의 건수
	/*
	String toDate = DateTime.getFormatString("yyyyMMdd");
	String fmDate = DateTime.addDays(toDate, -7);
	fmDate = fmDate.substring(0,4) + "-" + fmDate.substring(4,6)+ "-" + fmDate.substring(6,8);  //월 저장
	toDate = DateTime.getFormatString("yyyy-MM-dd");
	*/
	
	String userId="";
	String ofc_cd="";
	String rhqCd = "";

	try {
		rhqCd = ((request.getParameter("rhq_cd")==null)?"":request.getParameter("rhq_cd"));
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId=account.getUsr_id();
	   	ofc_cd=account.getOfc_cd();
	   	//userAuth=account.getAuth();

		event = (EsdAoc3111Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		/*
		아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다.
		보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다.
		*/
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Cost & Guideline Tariff Status Monitoring</title>
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


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="rhq_cd" value="<%=rhqCd%>">
<input type="hidden" name="shq_flg">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr>
		       		<td class="btn1_bg">
	
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->


			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="55">RHQ</td>
								<td width="170"><script language="javascript">ComComboObject('combo_rhq', 1, 160, 1)</script></td>
								<td width="110">Cost Tariff Type</td>
								<td width="170">
									<select name="trf_tp" class="input" style="width:110;">
										<option value="" selected>All</option>
										<option value="I">Inland</option>
										<option value="O">Ocean Feeder</option>
									</select>
								</td>
								<td width="80">Bound</td>
								<td width="50">
									<select name="io_bnd_cd" class="input" style="width:50;">
										<option value="" selected>All</option>
										<option value="I">In</option>
										<option value="O">Out</option>
									</select>
								</td>
								<td width="40"></td>
								<td width="" colspan="2"><input type="checkbox" name="his_data" value="Y" class="trans">Incl. Historical Data</td>
							</tr>
							<tr class="h23">
								<td width="55">Date</td>
								<td width="170">
									<select name="dt_tp" class="input" style="width:160;">
										<option value="" selected></option>
										<option value="E">Effective From</option>
										<option value="C">Creation</option>
										<option value="U">Update</option>
									</select>
								</td>
								<td width="280" class="sm" colspan="2">
									<input name="fm_dt" type="text" style="width:90;text-align:center;" value="" onFocus='removeBarDate(this);' onBlur='aocBlurDate(this);'>&nbsp;&nbsp;~&nbsp;
									<input name="to_dt" type="text" style="width:90;text-align:center;" value="" onFocus='removeBarDate(this);' onBlur='aocBlurDate(this);'>
									<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar">
								</td>
								<td width="80">Interval (≥)</td>
								<td width="50"><input name="itval" type="text" dataformat="num" style="width:50;text-align:right;" value="" maxlength="3"></td>
								<td width="40"></td>
								<td width="50">Status</td>
								<td width=""><script language="javascript">ComComboObject('combo_sts', 1, 200, 1)</script></td>
							</tr>
							<tr class="h23">
								<td width="55">Country</td>
								<td width="170">
									<input name="cnt_cd" type="text" dataformat="engupcomma" style="width:110;">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_country">
									<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('cnt_cd');">
								</td>
								<td width="110">Cost Tariff No</td>
								<td width="170">
									<input name="cost_trf_no" type="text" dataformat="engupnumcomma" style="width:110;" value="">
									<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('cost_trf_no');">
								</td>
								<td width="130" colspan="2">Guideline Tariff No</td>
								<td width="90" colspan="2">
									<select name="ihc_trf_tp" class="input" style="width:85;">
										<option value="" selected>All</option>
										<option value="N">N/A</option>
										<option value="E">Existent</option>
									</select>
								</td>
								<td width="">
									<input name="ihc_trf_no" type="text" dataformat="engupnumcomma" style="width:200;">
									<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('ihc_trf_no');">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg">
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
	                        <tr>
	                        	<td>
	                            	<script language="javascript">ComSheetObject('sheet1');</script>
	                        	</td>
	                        </tr>
	                    </table>
						<!-- : ( Grid ) (E) -->
	
	
						<!-- : ( Button_ Sub ) (S) -->
						<table width="100%" class="button">
					       	<tr>
					       		<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
	
											<!-- Repeat Pattern -->
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
				
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_cost_tariff" name="btn_cost_tariff">Cost Tariff MGMT</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<!-- Repeat Pattern -->
	
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- : ( Button_ Sub ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

</form>
</body>
</html>