<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0204.jsp
*@FileTitle      : Sector-Office Relation Setting for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.08
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.08 SQM USER
* 1.0 Creation
* 2014.08.25 이혜민 [CHM-201431601] 팝업 오픈시 부모창 조회조건을 자동세팅하도록 수정
* 2014.09.23 이혜민 [CHM-201431753] Sector-Office Relation Setting 화면 내 Raw Data Export 버튼 생성건 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event.EsmSqm0204Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0204Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.datamanage.basicdata");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0204Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// pop_mode
	String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";	
	String p_bse_yr      = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd  = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String p_ofc_vw_cd   = JSPUtil.getParameter(request, "f_ofc_vw_cd", "");
	String p_sub_trd_cd  = JSPUtil.getParameter(request, "f_sub_trd_cd", "");
	String p_ias_rgn_cd  = JSPUtil.getParameter(request, "f_ias_rgn_cd", "");
	String p_dir_cd  	 = JSPUtil.getParameter(request, "f_dir_cd", "");
	String p_rlane_cd    = JSPUtil.getParameter(request, "f_rlane_cd", "");
%>
<html>
<head>
<title>Sector-Office Relation Setting for IAS Sector</title>
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

<% if (popMode.equals("Y")) { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Sector-Office Relation Setting for IAS Sector</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>
<body  onLoad="setupPage();">
<form name="form">
<table border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
<% } %>


<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="dataCnt" value="0">
<input type="hidden" name="popMode"      value="<%= popMode%>">
<input type="hidden" name="p_bse_yr"     value="<%= p_bse_yr%>">
<input type="hidden" name="p_bse_qtr_cd" value="<%= p_bse_qtr_cd%>">
<input type="hidden" name="p_ofc_vw_cd"  value="<%= p_ofc_vw_cd%>">
<input type="hidden" name="p_sub_trd_cd" value="<%= p_sub_trd_cd%>">
<input type="hidden" name="p_ias_rgn_cd" value="<%= p_ias_rgn_cd%>">
<input type="hidden" name="p_dir_cd"     value="<%= p_dir_cd%>">
<input type="hidden" name="p_rlane_cd"   value="<%= p_rlane_cd%>">

<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!--Button_L (S) -->
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
											<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
								<td class="btn1_line"></td>
								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Save" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Creation" name="btn_Creation">Creation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_RawDataDownExcel" name="btn_RawDataDownExcel">Raw Data Export</td>
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
			<!--Button_L (E) -->
		
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search">
							<tr>
  								<td width="95" rowspan="2">
									<table class="search_sm2" width="90">
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y"><label style="padding-left:2;">Yearly</label></td></tr>
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" checked><label style="padding-left:2;">Quarterly</label></td></tr>
									</table>
								</td>							
								<td width="">
									<table class="search" border="0">
										<tr class="h23">
											<td width="75">Year</td>
											<td width="80"><script language="javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1)</script></td>
											<td width="80"><div id="div_qtr">Quarter</div></td>
											<td width="80"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 60, 1, 1)</script></td>
											<td width="150" class='sm'><div id="div_period"></div></td>
											<td width="80">Office View</td>
											<td width="90"><script language="javascript">ComComboObject('f_ofc_vw_cd', 1, 70, 1, 1)</script></td>
											<td width="45">RHQ</td>
											<td width="85"><script language="javascript">ComComboObject('f_rhq_cd', 1, 65, 1)</script></td>
											<td width="45">Office</td>
											<td width="70"><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 65, 1)</script></td>
											<td>&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="75">Sub Trade</td>
											<td width="80"><script language="javascript">ComComboObject('f_sub_trd_cd', 1, 60, 1, 1)</script></td>
											<td width="80">IAS Region</td>
                                            <td width="80"><script language="javascript">ComComboObject('f_ias_rgn_cd', 1, 60, 1)</script></td>
											<td width="80">Lane Bound</td>
											<td width="70"><script language="javascript">ComComboObject('f_dir_cd', 1, 50, 1, 1)</script></td>
											<td width="80">R/Lane</td>
											<td width="90"><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 1, 1)</script></td>
											<td width="45">POL</td>
											<td width="85"><script language="javascript">ComComboObject('f_pol_cd', 1, 65, 1)</script></td>
											<td width="45">POD</td>
											<td width="70"><script language="javascript">ComComboObject('f_pod_cd', 1, 65, 1)</script></td>
											<td>&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>	
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>	

			<!-- Tab ) (S) -->
		   	<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
		     		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1');</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
			</table>
			<!-- Tab ) (E) -->

			<!--TAB Pair Active Edit (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search" border="0">
					<tr>
						<td class="bg_b1">
							<table class="height_10"><tr><td></td></tr></table>
							<table width="100%" id="mainTable">
								<tr>
									<td><script language="javascript">ComSheetObject('sheet1');</script></td>
								</tr>
							</table>
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
															<td class="btn2" name="btn_AddCreation">Add Creation</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" id="btn_Creation" name="btn_PairAdd">POL-POD Pair Add</td>
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
			<!--TAB Pair Active Edit (E) -->
			
			<!--TAB Pair by P/F SKD Group (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search" border="0">
					<tr>
						<td class="bg_b1">
							<table class="height_8"><tr><td></td></tr></table>
							<table class="search" border="0">
								<tr class="h23">
									<td width="75">P/F Group</td>
									<td width=""><script language="javascript">ComComboObject('f_pf_grp_cd', 2, 200, 1, 0, 1)</script></td>
								</tr>
							</table>
							<table class="height_10"><tr><td></td></tr></table>
							<table width="100%" id="mainTable">
								<tr>
									<td><script language="javascript">ComSheetObject('sheet2');</script></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<!--TAB Pair by P/F SKD Group (E) -->
			
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->
<% if (popMode.equals("Y")) { %>
      <!-- : ( Button : pop ) (S) -->
      <table width="100%" class="sbutton">
        <tr>
          <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
              <tr>
                <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_close">Close</td>
                            <td class="btn1_right"></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!-- : ( Button : pop ) (E) -->
<% } %>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>