<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0502.jsp
*@FileTitle : Credit & Incentive Summary.
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 
* 1.0 최초 생성 2016.04.26
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.CodeComboUtil"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%@ page import="com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.event.EsdEas0502Event"%>

<%
	EsdEas0502Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지
	String strUsr_ofc_cd = "";
	String strUsr_rhq_ofc_cd = "";
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수

	String today = DateTime.getFormatString("yyyy");

	SignOnUserAccount account= null;

	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_ofc_cd = account.getOfc_cd();
		strUsr_rhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EsdEas0502Event)request.getAttribute("Event");

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
	<title>Credit & Incentive Summary</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script language="javascript">
		function setupPage(){
			var errMessage = "<%=strErrMsg%>";
			if (errMessage.length >= 1) {
				ComShowMessage(errMessage);
			}  // end if
			loadPage();
		}
	</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="ofc_cd"			value="<%=strUsr_ofc_cd%>">
    <input type="hidden" name="usr_rhq_ofc_cd"	value="<%=strUsr_rhq_ofc_cd%>">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
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
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
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
			<table class="search" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr class="h23">
								<td style="width:800;">
									<div id='div_year' style="display:inline;width:800px;">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr class="h23">
												<td width="30">Year</td>
												<td width="50" ><input name="s_bse_yr" type="text" style="width:40;text-align:center;" class="input" maxlength="4" value="<%=today%>" onKeyPress="ComKeyOnlyNumber(this)"></td>
												<td width="110">Summary Division</td>
												<td width="120">
													<select name="s_smmr_div_cd" style="width:110;" onClick="javascript:chgSmmrDivCd(this.value);">
														<option value="R" >RHQ</option>
														<option value="C" >Credit Source</option>
													</select>
												</td>
												<td width="35">RHQ</td>
												<td width="90" style="padding-left: 1;">
													<script language="javascript">ComComboObject('s_rhq_cd',1,79,1,0,0);</script>
												</td>
												<td width="90">Credit Source</td>
												<td width="130">
													<select name="s_cr_src_cd_tab1" style="width:130;">
														<option value="" ></option>
														<option value="TES" >Terminal</option>
														<option value="TRS" >Transporation</option>
														<option value="VSL" >Vessel Operation</option>
													</select>
												</td>	
											</tr>
										</table>
									</div>
									<div id='div_period' style="display:none;width:550;">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr class="h23">
												<td width="70">Issue Date</td>
												<td width="240">
													<input type="text" name="s_fm_dt" dataformat="ymd" maxlength="8" size="10" style="width:80; text-align: center;" class="input"	onKeyPress="ComKeyOnlyNumber(this)">
													<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt=""border="0" align="absmiddle" class="cursor"> ~ 
													<input type="text" name="s_to_dt" dataformat="ymd" maxlength="8" size="10" style="width:80; text-align: center;" class="input" onKeyPress="ComKeyOnlyNumber(this)">
													<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
												</td>
												<td width="90">Credit Source</td>
												<td width="130">
													<select name="s_cr_src_cd_tab2" style="width:130;">
														<option value="" ></option>
														<option value="MNR" >Refrigerator Parts Credit</option>
														<option value="MGR" >Welfare Card Mileage</option>
													</select>
												</td>	
											</tr>
										</table>	
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
			<table class="height_10"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Tab ) (S) -->
	     	<table class="tab">
	       		<tr>
	       			<td><script language="javascript">ComTabObject('tab1')</script></td>
	       		</tr>
			</table>
	        <table class="search" id="mainTable"> 
	        	<tr>
	          		<td class="bg">
						<!-- TABLE '#D' : ( Tab ) (E) -->
				        <div id="tabLayer" style="display:inline">
							<table class="search" border="0">
								<tr>
									<td class="bg">
					                    <table width="100%" id="mainTable">
					                        <tr>
					                        	<td>
					                        		 <div id='div_rhq' style="display:inline">
			 		                            	 <script language="javascript">ComSheetObject('sheet1');</script>
			 		                            	 </div>
					                        	</td>
					                        </tr>
					                        <tr>
					                        	<td>
					                        		 <div id='div_src' style="display:none">
			 		                            	 <script language="javascript">ComSheetObject('sheet2');</script>
			 		                            	 </div>
					                        	</td>
					                        </tr>
					                     </table>
									</td>
								</tr>
							</table>
			 			  </div>
					      <div id="tabLayer" style="display:none">
							<table class="search" border="0">
								<tr>
									<td class="bg">
					                    <table width="100%" id="mainTable">
					                        <tr>
					                        	<td>
						                            	<script language="javascript">ComSheetObject('sheet3');</script>
						                        </td>
						                       
						                     </tr>
					                    </table>
									</td>
								</tr>
							</table>
							
						  </div>
						</td>

					</tr>
				</table>
			</td>
		</tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
