<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0213.jsp
*@FileTitle      : QTA Set up for IAS Sector by Head Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* History
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2015.09.17 김용습 [CHM-201537764] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Raw Data Export 버튼 신규 생성 
* 2016.01.28 Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
* 2016.02.05 SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0213Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0213Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.planning.planning");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0213Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>QTA Set up for IAS Sector by Head Office</title>
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
<input type="hidden" name="f_p_cnt">
<input type="hidden" name="f_c_cnt">
<input type="hidden" name="f_t_cnt">
<input type="hidden" name="f_fm_wk">
<input type="hidden" name="f_to_wk">
<input type="hidden" name="f_ias_sctr_flg" value="Y">

<!-- 개발자 작업	-->

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
								<td id="btn_Creation">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1"  name="btn_Creation">Creation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td  id="btn_AddCreation">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1"  name="btn_AddCreation">Add-Creation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td id="btn_Freezing" >
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Freezing">Freezing</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td id="btn_AddFreezing">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1"  name="btn_AddFreezing">Add-Freezing</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td id="btn_Transfer">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1"  name="btn_Transfer">1Q Transfer</td>
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
						<table class="search_in">
							<tr>
  								<td width="105" rowspan="2">
									<table class="search_sm2" width="95">
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y"><label style="padding-left:2;">Yearly</label></td></tr>
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" checked><label style="padding-left:2;">Quarterly</label></td></tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="70">Year</td>
											<td width="80"><script language="javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1)</script></td>
											<td width="75"><div id="div_qtr">Quarter</div></td>
											<td width="90"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 60, 1, 1)</script></td>
											<td width="140" class='sm' colspan = '2'><div id="div_period"></div></td>
											<td width="80">Office View</td>
											<td width="75"><script language="javascript">ComComboObject('f_ofc_vw_cd', 1, 70, 1, 1)</script></td>
											<td width="40">RHQ</td>
											<td width="75"><script language="javascript">ComComboObject('f_rhq_cd', 1, 70, 1)</script></td>
											<td width="40">Office</td>
											<td width="75"><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 70, 1)</script></td>
										</tr>
										<tr class="h23">
											<td width="70">Sub Trade</td>
											<td width="80"><script language="javascript">ComComboObject('f_sub_trd_cd', 1, 60, 1)</script></td>
											<td width="75">IAS Region</td>
                                            <td width="90"><script language="javascript">ComComboObject('f_ias_rgn_cd', 1, 85, 1)</script></td>
											<td width="60">R/Lane</td>
											<td width="80"><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 1)</script></td>
											<td width="80"><div id="div_dir">Lane Bound</div></td>
											<td width="75">
												<div id="div_dir_cd"><script language="javascript">ComComboObject('f_dir_cd', 1, 70, 1)</script></div>
												<div id="div_trd_dir" style="display:none;"><script language="javascript">ComComboObject('f_hul_bnd_cd', 1, 70, 1)</script></div>
											</td>
											<td colspan="4"><input type="checkbox" name="f_click" class="trans">&nbsp;Trade Dir.</td>
										</tr>
										<tr class="h23">
											<td width="70">P/F Group</td>
											<td width="80"><script language="javascript">ComComboObject('f_pf_grp_cd', 2, 80, 1,0,1)</script></td>
											<td width="75">Supply</td>
                                            <td width="90"><script language="javascript">ComComboObject('f_fnal_bsa_capa', 1, 60, 1)</script></td>
											<td width="60">POL</td>
											<td width="80"><script language="javascript">ComComboObject('f_pol_cd', 1, 70, 1)</script></td>
											<td width="80">POD</td>
											<td width="75"><script language="javascript">ComComboObject('f_pod_cd', 1, 70, 1)</script></td>
											<td width="40">Main</td>
											<td width="">
												<select  name="f_sqm_mn_sctr_flg" style="width:60;" class="input">
													<option value="All" selected="selected">All</option>
													<option value="Y">Y</option>
													<option value="N">N</option>
												</select>
											</td>	
											<td colspan="2"></td>
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

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg_b1">
						<table class="height_10"><tr><td></td></tr></table>
						<table width="100%" class="search">
							<tr>
								<td style="text-align:right;">[Unit : $/TEU]</td>
							</tr>
						</table>
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
						
							
						<!-- : ( Button : Sub ) (S) -->
						<table width="100%" class="button">
							<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btn_sectoradd">Sector Add</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td></tr>
						</table>
						<!-- : ( Button : Sub ) (E) -->
						
						
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>