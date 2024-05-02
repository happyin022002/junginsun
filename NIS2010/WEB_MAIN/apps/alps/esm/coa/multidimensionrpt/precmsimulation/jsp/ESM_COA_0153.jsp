<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0153.jsp
*@FileTitle : Pre CM/OP Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.15 송호진
* 1.0 Creation
*=========================================================
* History
* 2008-05-16 Ari
* 1.0 최초 생성 CSR No.N200804140004, N200804146015, N200804146018
* 2008-06-13 임옥영 1. Office code 멀티콤보로 수정
*					2. void vol 숫자와 (.)만 입력되도록 수정
* 2008-07-02 전성진 CSR No.N200807070015
*					- Route error message 출력 관련 수정
* 2009-04-17 임옥영:N200904080070 D term, R term에 'I', 'O', 'T', 'M'추가
* 2009-04-21 Ari CSR No.N200904070080 CM/OP 변경에 따라 CM계산시 Office조건 빠질수 있도록 처리
* 2009-05-22 전윤주  N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
* 2009-06-10 박상희  N200905110270 COA_Pre CM/OP Simulation : Temp T/S Route 입력기능
* 2009-10-08 송호진 ALPS 전환
* 2009-10-22 송호진 PRD 연동 부분 ALPS 전환
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.05.13 김민아 [CHM-201110694-01] COA Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
* 2011.12.21 최윤성 [CHM-201115260-01] [COA] Pre CM/OP Simulation화면 U.I 변경요청 - Remark 문구추가
* 2012.01.02 최성민 [CHM-201114896-01] [COA] CM2 추가 개발 요청
* 2012.02.20 김종준 [CHM-201216268-01] [COA] Pre CM/OP 화면 Backandjob로 조회로  로직 변경
* 2012.03.09 이석준 [CHM-201216641] R/D Term Default를 CY로 변경하고, Combo에 Code+Name 값으로 보일 수 있도록 수정
* 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 - MTY P/Up CY 조회조건 추가 (Pre CM/OP Simulation)
* 2012.08.22 최윤성 [CHM-201219661] [COA] Pre CM/OP SImulation 화면상 Voide 조건에 따른 AWK Surcharge 추정 로직 변경
*                                  - Special Cargo 에 AWK를 선택 했을 시 CNTR Type 이 O,S,F,A 일 경우에 Void 필수로직 추가
* 2013.12.13 김수정 [CHM-201328111] [COA] EMU COST 변경 로직 Pre CM 반영 요청 - DEL Code, DEL Term 에 따른 MT Return CY 조회 추가
* 2014.12.10 이영헌 [CHM-201433087] Pre-CM/OP simulation 기능 추가 요청 CSR
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.PreCMSimulation");

	String userId  = "";
    String ofc_cd  = "";
    String ofc_lvl = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		userId = account.getUsr_id();
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		ofc_cd = eventResponse.getETCData("ofc_cd");
		ofc_lvl = eventResponse.getETCData("ofc_lvl");
	}catch(Exception e) {
		out.println(e.toString());
	}


%>
<html>
<head>
<title>Pre CM/OP Simulation</title>
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

<!-- 개발자 작업	-->
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param1">

<input type="hidden" name="f_user_id"  value="<%=userId%>">
<input type="hidden" name="f_ofc_cd"  value="<%=ofc_cd%>">
<input type="hidden" name="f_ofc_lvl" value="<%=ofc_lvl%>">

<input type="hidden" name="f_n_pol">
<input type="hidden" name="f_lane1">
<input type="hidden" name="f_port1">
<input type="hidden" name="f_lane2">
<input type="hidden" name="f_port2">
<input type="hidden" name="f_lane3">
<input type="hidden" name="f_port3">
<input type="hidden" name="f_lane4">
<input type="hidden" name="f_n_pod">

<input type="hidden" name="f_pctl_no">
<input type="hidden" name="f_pc_creation" value="N">
<input type="hidden" name="backendjob_key"> 


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110">Profit View</td>
					<td width="160">
						<script language="javascript">ComComboObject('f_cob_profit_vw',1, 95 , 1 )</script>
					</td>
					<td width="120">Profit Level</td>
					<!-- 
					<td width="150">
						<div id="tradeLv" style="display:inline">
							<SELECT style='width:72' name="f_cob_profit_lv2" >
							<OPTION value="C">CM</OPTION>
							<OPTION value="M">CM2</OPTION></SELECT>
						</div>
						<div id="officLv" style="display:none">
							<script language="javascript">ComComboObject('f_cob_profit_lv',1, 72 , 1 )</script>
						</div></td>
					 -->	
					<td width="130"><script language="javascript">ComComboObject('f_cob_profit_lv',1, 72 , 1 )</script></td>	
					<td width="100"></td>
					<td width="140"></td>
					<td width="90"></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="h23">
					<td >Revenue (USD)</td>
					<td><input name="f_g_rev" class="input1" type="text" style="width:50; ime-mode:disabled;" maxlength="25" onKeyUp="chkNumber(this); moveTab(this, f_spcl_dg);" onKeyPress="ComKeyOnlyNumber(this,'.'); setBfVal(this);"></td>
					<td>Special Cargo</td>
					<td colspan="4" class="sm">
						<input type="checkbox" class="trans" name="f_spcl_dg" value="Y" onKeyUp="moveTab(this, f_spcl_rf);">DG&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="f_spcl_rf" value="Y" onKeyUp="moveTab(this, f_spcl_ak);">RF&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="f_spcl_ak" value="Y" onKeyUp="moveTab(this, f_spcl_rf);" onClick="checkbox_OnChange(this);" >AK&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="f_spcl_bb" value="Y" onKeyUp="moveTab(this, f_spcl_soc);">BB&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="f_spcl_soc" value="Y" onKeyUp="moveTab(this, f_spcl_revmt);">S.O.C&nbsp;&nbsp;&nbsp;
						<input type="checkbox" class="trans" name="f_spcl_revmt" value="Y" onKeyUp="moveTab(this, f_cmdt_cd);">Revenue MT
               		</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="h23">
					<td>POR</td>
					<td><input name="f_por_cd" type="text" class="input1" required caption="POR" maxlength="5" style="width:50;ime-mode:disabled;" onKeyUp="checkLoc_onKeyUp(this, this.value);moveTab(this, f_por_node);" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						<input name="f_por_node" type="text" maxlength="2" style="width:20;ime-mode:disabled;" onKeyUp="isValidLocation(this, this.value);moveTab(this, f_pol_cd)" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_por" onClick="openLocationCode('getF_por_cd');"></td>
					<td>POL</td>
					<td><input name="f_pol_cd" type="text" class="input1" required caption="POL" maxlength="5" style="width:50;ime-mode:disabled;" onKeyUp="checkLoc_onKeyUp(this, this.value);moveTab(this, f_pod_cd);" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pol" onClick="openLocationCode('getF_pol_cd');"></td>
					<td>POD</td>
					<td><input name="f_pod_cd" type="text" maxlength="5" style="width:50;ime-mode:disabled;" onKeyUp="checkLoc_onKeyUp(this, this.value);moveTab(this, f_del_cd);" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pod" onClick="openLocationCode('getF_pod_cd');"></td>
					<td>DEL</td>
					<td><input name="f_del_cd" type="text" class="input1" required caption="DEL" maxlength="5" style="width:50;ime-mode:disabled;" onKeyUp="checkLoc_onKeyUp(this, this.value);moveTab(this, f_del_node);" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                        <input name="f_del_node" type="text" maxlength="2" style="width:20;ime-mode:disabled;" onKeyUp="checkLoc_onKeyUp(this, this.value);moveTab(this, f_r_term);" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                        <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_del" onClick="openLocationCode('getF_del_cd');"></td>
                    <td></td>
                    <td></td>
				</tr>
				<tr class="h23">
					<td>MTY P/Up CY</td>
					<td><input name="f_mty_pkup_yd_cd" type="text" class="input" required caption="PKUP" maxlength="5" style="width:50;ime-mode:disabled;" onKeyUp="checkLoc_onKeyUp(this, this.value);moveTab(this, f_mty_pkup_yd_node);" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						<input name="f_mty_pkup_yd_node" type="text" maxlength="2" style="width:20;ime-mode:disabled;" onKeyUp="moveTab(this, f_mty_rtn_yd_cd);" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_por" onClick="openLocationCode('getF_pkup_yd');"></td>
					<td>MTY RTN CY&nbsp;<input type="checkbox" class="trans" name="f_mty_rtn_yd_chk" value="Y" ></td>
					<td><input name="f_mty_rtn_yd_cd" readonly type="text" class="input2" required caption="RTN" maxlength="5" style="width:50;ime-mode:disabled;" onKeyUp="checkLoc_onKeyUp(this, this.value);moveTab(this, f_mty_rtn_yd_node);" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						<input name="f_mty_rtn_yd_node" readonly type="text" class="input2" maxlength="2" style="width:20;ime-mode:disabled;" onKeyUp="moveTab(this, f_r_term);" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_por" onClick="openLocationCode('getF_rtn_yd');"></td>
					<td>R/D Term</td>
					<td style="padding-left:2;">
						<script language="javascript">ComComboObject('f_r_term', 2, 37, true, 1, 2)</script>
						<script language="javascript">ComComboObject('f_d_term', 2, 37, true, 1, 2)</script>
					</td>
                	<td>Type/Size</td>
					<td width="110" style="padding-left:2;">
						<script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 74, true, 1, 'TP/SZ')</script>
					</td>
					<td width="120">Quantity (BOX)</td>
					<td><input name="f_qty" class="input1" type="text" style="width:30;ime-mode:disabled;" onKeyUp="chkNumber(this); moveTab(this, f_agmt_sgn_ofc_cd);" onKeyPress="ComKeyOnlyNumber(this,'.'); setBfVal(this);"></td>
				</tr>
				<tr class="h23">
					<td>Contract Office</td>
					<td style="padding-left:2;">
						<script language="javascript">ComComboObject('f_agmt_sgn_ofc_cd', 1, 74, true, 'Contract OFC')</script>
					</td>
					<td>Loading Office</td>
					<td style="padding-left:2;">
						<script language="javascript">ComComboObject('f_sls_ofc_cd', 1, 74, true, 'Loading OFC')</script>
					</td>
					<td>Booking Office</td>
					<td style="padding-left:2;">
						<script language="javascript">ComComboObject('f_bkg_ofc_cd', 1, 74, true, 'Booking OFC')</script>
					</td>
               		<td>Void (TEU)</td>
					<td><input name="f_void_qty" type="text" style="width:50;ime-mode:disabled;" onKeyUp="chkNumber(this); moveTab(this, f_clt_ofc_cd);" onKeyPress="ComKeyOnlyNumber(this,'.'); setBfVal(this);"></td>
				</tr>
				<tr class="h23">
					<td>Prepaid Office</td>
					<td style="padding-left:2;">
						<script language="javascript">ComComboObject('f_ppd_ofc_cd', 1, 74, false, 'Prepaid OFC')</script>
					</td>
					<td>Collect Office</td>
					<td style="padding-left:2;">
						<script language="javascript">ComComboObject('f_clt_ofc_cd', 1, 74, false, 'Collect OFC')</script>
					</td>
               		<td>Commodity</td>
					<td><input name="f_cmdt_cd" type="text" style="width:50" maxlength="6" style="ime-mode:disabled;" onKeyPress="ComKeyOnlyNumber(this);">
                    	<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_com" onClick="openCommodity('getF_commodity');">
                    </td>
               		<td></td>
               		<td></td>
               		<td></td>
               		<td></td>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( RHQ ) (S) -->
				<table width="100%" id="mainTable">
						  <tr>
							<td align="right" valign="bottom">
								<div id="div_zoom_in1" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
								</div>
								<div id="div_zoom_out1" style="display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
								</div>
							</td>
						  </tr>
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
				</table>
				<!-- : ( RHQ ) (E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<!-- 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd" onclick="javascript:callADD();">Row Add</td><td class="btn2_right"></td></tr></table></td>
 						-->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_pccreation" name="btng_pccreation" value="N">Temp P/C Generation</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_costdetail" name="btng_costdetail">Cost Detail</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( RHQ ) (S) -->
				<table width="100%" id="mainTable2" border="0">
						  <tr align="right">
							<td align="right" valign="bottom">
								<div id="div_zoom_in2" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in2" alt="Zoom in(+)">
								</div>
								<div id="div_zoom_out2" style="display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out2" alt="Zoom out(-)">
								</div>
							</td>
						  </tr>
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet2');</script>
			              </td></tr>



				</table>
				<table>


				<!-- : ( RHQ ) (E) -->
				<table width="100%" class="button">
				    <tr><td><img src="/hanjin/img/ico_star.gif" border=0> <strong>Remark</strong></td>
				        <td class="btn2_bg">

								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td><td class="btn2" id="btns_remarks" name="btns_remarks">Remarks</td><td class="btn2_right"></td>
												<td class="btn2_left"></td><td class="btn2" id="btns_constraints" name="btns_constraints">Constraints</td><td class="btn2_right"></td>
											</tr>
										</table>
									</td>
									<!-- Repeat Pattern -->
								</tr></table>

				        </td>
				    </tr>
					<tr><td class="sm">
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4"><font color="#0000FF"><b>If costs are marked in Blue, please contact each RHQ(NOG, UOG, AOG, WOG) and ask for more accurate costs. </b></font><br>
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4">This function utilizes the most recent sources in calculating cost. <br>
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4">Revenue = Ocean Freight + Surcharge<br>
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4">If you wish to simulate any non-existing routes, please follow the instruction. <br>
																									 &nbsp; 1. Input POR/POL/POD/DEL → 2. Click "Retrieve" → 3. Click "Row Add" → 4. Input the route & click "Apply"→ 5. Click "Temp P/C Generation" <br>
																									 &nbsp; By doing so, you should be able to input T/S Route temporarily.
						</td>
						<td>&nbsp;</td>
					</tr>
				</table>


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->



<!-- 개발자 작업  끝 -->
</form>
<span id="prd_form"></span>
</body>
</html>