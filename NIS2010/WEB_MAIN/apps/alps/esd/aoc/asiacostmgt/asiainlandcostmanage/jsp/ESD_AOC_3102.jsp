<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_AOC_3102.jsp
*@FileTitle : Inland Cost Management(SHA/SIN)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.14
*@LastModifier : 이혜민
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2013.01.14 CHM-201322300 이혜민 [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.event.EsdAoc3102Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdAoc3102Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String trf_no = "";
	String cnt_cd = "";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
		trf_no = ((StringUtil.xssFilter(request.getParameter("trf_no"))==null)?"":StringUtil.xssFilter(request.getParameter("trf_no")));
		if(!trf_no.equals("")){
			cnt_cd = trf_no.substring(0,2);
		}
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdAoc3102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
    // change to table name
	String transModeCdOut  = JSPUtil.getCodeCombo("f_trsp_crr_mod_cd_out" , "01", "style='width:120'", "CD03067", 0, "000010:ALL:ALL");
	String transModeCdIn  = JSPUtil.getCodeCombo("f_trsp_crr_mod_cd_in" , "01", "style='width:120'", "CD03068", 0, "000010:ALL:ALL");
	String transModeCd  = JSPUtil.getCodeCombo("f_trns_mode_cd" , "01", "style='width:120'", "CD00283", 0, "000010:ALL:ALL");
	String sysSrcAgmtCd  = JSPUtil.getCodeCombo("f_sys_src_cd" , "01", "style='width:120'", "CD03050", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Inland Cost Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("f_trsp_crr_mod_cd_out" , "", "CD03067", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("f_trsp_crr_mod_cd_in" , "", "CD03068", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("f_trns_mode_cd" , "", "CD00283", 0, "")%>
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
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="trf_no" value="<%=trf_no%>">
<input type="hidden" name="cost_trf_sts_cd" value="">
<input type="hidden" name="in_btn_sts">
<input type="hidden" name="in_cost_trf_bat_seq">
<input type="hidden" name="reset_flg">
<input type="hidden" name="rout_grp_no">

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
				                <td class="btn1_line"></td>
				                <td>
					                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_confirm">Confirm</td>
						                    <td class="btn1_right"></td>
					                    </tr>
					                </table>
				                </td>
				                <td>
					                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_confirm_cancel">Confirm Cancel</td>
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
								<td width="90">Country</td>
								<td width="100"><input type="text" style="width:70;text-align:center;" class="input1" name="in_cnt_cd" value="<%=cnt_cd%>" dataformat="upper" maxlength="2" caption="Country Code">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_cnt_cd" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="90">Cost Tariff No</td>
								<td width="100">
									<script language="javascript">ComComboObject('in_cost_trf_no', 1, 95, 1, 1);</script>
								</td>
								<td width="50">Port</td>
								<td width="90">
									<input name="in_from_nod_cd" type="text" dataformat="uppernum" style="width:60;" maxlength="7">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_from">
								</td>
								<td width="30">LOC</td>
								<td width="140">
									<input name="in_to_nod_cd" type="text" dataformat="uppernum" style="width:60;" maxlength="7">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_to">
								</td>
								<td width="50">Bound</td>
								<td width="133"><input type="text" name="io_bnd_nm" style="width:50;text-align:center;" class="input2" readonly></td>
								<td width="30">AVG</td>
								<td><input type="text" name="avg_cnt" style="width:50;text-align:right;" class="input2" readonly></td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:979;"> 	
							<tr class="h23">
								<td width="90">Effective From</td>
								<td width="100"><input type="text" name="eff_fm_dt" style="width:90;text-align:center;" class="input2" readonly></td>
								<td width="90">Update Date</td>
								<td width="100"><input type="text" name="upd_dt" style="width:90;text-align:center;" class="input2" readonly></td>
								<td width="50">Status</td>
								<td width="90"><input type="text" name="cost_trf_sts_nm" style="width:80;text-align:center;" class="input2" readonly></td>
								<td width="30">User</td>
								<td width="140"><input type="text" name="upd_usr_id" style="width:120;text-align:left;" class="input2" readonly></td>
								<td width="90">Weight Criteria (KGS)</td>
								<td>20' </td><td><input type="text" name="cntr_20ft_crte_wgt" style="width:60;text-align:right;" class="input2" readonly></td>
								<td>40' </td><td><input type="text" name="cntr_40ft_crte_wgt" style="width:60;text-align:right;" class="input2" readonly></td>
							</tr>
						</table>
						<!-- biz_1  (E) -->		
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
	
			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td></tr>
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
															<td class="btn2" name="btn_save">Save</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td class="btn1_line"></td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_route_detail">Route Detail</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_cost_detail">Cost Detail</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_agmt_inq">AGMT INQ</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_loc_group">LOC Group</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_down_excel">Down Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_load_excel">Load Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_copy_rf">Copy to RF route</td>
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
		
			
			<!-- TAB [ DG, Overweight ] (S) -->
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
															<td class="btn2" name="btn_save2">Save</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td class="btn1_line"></td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2" name="btn_down_excel2">Down Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td class="btn1_line"></td>
                                                <td>
                                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr>
                                                            <td class="btn2_left"></td>
                                                            <td class="btn2" name="btn_owt_verify_rule">Overweight verification rule</td>
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
			<!-- TAB [ DG, Overweight ] (E) -->
			
			
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
														<td class="btn2" name="btn_delete3">Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_save3">Save</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td class="btn1_line"></td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_down_excel3">Down Excel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_load_excel3">Load Excel</td>
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
			
		
			<table class="height_8"><tr><td></td></tr></table>
		
			<table class="search"> 
	       		<tr>
		       		<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="60">T.Mode</td>
								<td width="80"><script language="javascript">ComComboObject('co_tran_mode', 1, 68, 1, 0);</script></td>
								<td width="60">Trans 20’</td>
								<td width="80"><script language="javascript">ComComboObject('co_trans20_src', 1, 80, 1, 0);</script></td>
								<td width="50"><script language="javascript">ComComboObject('co_trans20', 1, 50, 1, 0);</script></td>
								<td width="60"><input type="text" name="in_trans20" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
								<td width="50">MTY 20’</td>
								<td width="82"><script language="javascript">ComComboObject('co_mty20_src', 1, 80, 1, 0);</script></td>
								<td width="82"><script language="javascript">ComComboObject('co_mty20', 1, 82, 1, 0);</script></td>
								<td width="60"><input type="text" name="in_mty20" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input2" readonly></td>
								<td width="60">TMNL 20’</td>
								<td width="80"><script language="javascript">ComComboObject('co_tmnl20_src', 1, 80, 1, 0);</script></td>
								<td width="50"><script language="javascript">ComComboObject('co_tmnl20', 1, 50, 1, 0);</script></td>
								<td width=""><input type="text" name="in_tmnl20" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
				                <td width="70">
					                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
					                    	<td class="btn1_left"></td>
					                    	<td class="btn1" name="btn_apply">Apply</td>
					                    	<td class="btn1_right"></td>
					                    </tr>
					                </table>
				                </td>
							</tr>
							<tr class="h23">
								<td>R/D Term</td>
								<td><script language="javascript">ComComboObject('co_rd_type', 1, 68, 1, 0);</script></td>
								<td>Trans 40’</td>
								<td><script language="javascript">ComComboObject('co_trans40_src', 1, 80, 1, 0);</script></td>
								<td><script language="javascript">ComComboObject('co_trans40', 1, 50, 1, 0);</script></td>
								<td><input type="text" name="in_trans40" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
								<td>MTY 40’</td>
								<td><script language="javascript">ComComboObject('co_mty40_src', 1, 80, 1, 0);</script></td>
								<td><script language="javascript">ComComboObject('co_mty40', 1, 82, 1, 0);</script></td>
								<td><input type="text" name="in_mty40" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input2" readonly></td>
								<td>TMNL 40’</td>
								<td><script language="javascript">ComComboObject('co_tmnl40_src', 1, 80, 1, 0);</script></td>
								<td><script language="javascript">ComComboObject('co_tmnl40', 1, 50, 1, 0);</script></td>
								<td><input type="text" name="in_tmnl40" style="width:45;text-align:right;" dataformat="float" maxlength="6" class="input"></td>
				                <td width="70">
					                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
					                    	<td class="btn1_left"></td>
					                    	<td class="btn1" name="btn_reset">Reset</td>
					                    	<td class="btn1_right"></td>
					                    </tr>
					                </table>
				                </td>
							</tr>
		 				</table>
						<!-- biz_1  (E) -->		
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr>
	      	<td class="bg">	
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
	      	<td class="bg">	
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>