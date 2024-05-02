<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0069.jsp
*@FileTitle : Pre Checking Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.23 김현욱
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0069Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0069Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");
	
	String popType          = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0069Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//팝업유형 : R(단순 첵), S(Special Request용), B(Back Ground 첵)
		popType = StringUtil.xssFilter(request.getParameter("pop_type"))==null?"":StringUtil.xssFilter(request.getParameter("pop_type"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Pre Checking Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var popType = "<%=popType%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(popType);
		
		//해상도에 따른 스크롤 생성 (기준:1400,1050)		
		document.body.scroll = "auto";			
	}
</script>
</head>

<body CLASS="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="tabSelectedIdx" value="0">
<input type="hidden" name="t1retrieve_flg" value="N">
<input type="hidden" name="t2retrieve_flg" value="N">
<input type="hidden" name="t3retrieve_flg" value="N">
<input type="hidden" name="t4retrieve_flg" value="N">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table class="popup" width="100%" border="0" cellpadding="10">
		<tr><td class="top"></td></tr>
				<tr>
					<td valign="top">
				
						<!-- : ( Title ) (S) -->
						<table width="100%" border="0">
							<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Pre Checking Report </td></tr>
						</table>
						<!-- : ( Title ) (E) -->
					
						<!--biz page (S)-->
						<table class="search" id="mainTable"> 
				       		<tr>
				       			<td class="bg">

									<!--  biz_1  (S) -->
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s" width="180">Checking Result Summary</td>
											<td width="" class="stm" style="color:#000000">( If you want to check details, double-click at the symbol of  'X,O,N/A,M")[*X-Invalid,O-OK, N/A-Not Applicable, M-Manual, △-Restriction/Permit]</td>
										</tr>
										<tr><td class="height_5"></td></tr>
									</table>
									<!--  biz_1   (E) -->
									<!-- Grid - 1 (S) -->
									<table width="100%" class="search"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table> 
									<!-- Grid - 1 (E) -->	
							</td></tr></table>
									<!--  biz_2  (S) -->
							<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							<!-- Tab ) (S) -->
				     		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:100%;">
				       			<tr>
				       				<td width="100%">
										<script language="javascript">ComTabObject('tab1')</script>
									</td>
								</tr>
							</table>
							<!-- Tab ) (E) -->
					        <!-- Tab 4 (S) -->		
							<div id="tabLayer" style="display:none;">
							<table class="search"> 
				       		<tr>
				       		<td class="bg">
									<!--  biz_3   (E) -->
									<!-- Grid - 1 (S) -->
									
									<table class="search" border="0" style="width:897;">
									<tr class="h23">	
											<td width="160">Segregation Validation</td>
											<td width="" class="stm" style="color:#ff0000" id="rsltStr"></td>
									</tr>	
									</table>
									<table width="100%" class="search"  id="mainTable"> 
										<tr>
										    <td width="100%">
												<script language="javascript">ComSheetObject('t3sheet1');</script>
											</td>
										</tr>
									</table>
									
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
									
									<table class="search" border="0" style="width:897;"> 
										<tr class="h23">	
											<td width="">Port Prohibition En-route</td>
										</tr>
									</table>
									<table width="100%" class="search" id="mainTable" style="width:897;"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('t4sheet1');</script>
											</td>
										</tr>
									</table> 
									
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
									
									<table class="search" border="0" style="width:897;"> 
										<tr class="h23">	
											<td width="">Vessel Operator’s Prohibition</td>
										</tr>
									</table>	
									<!--  biz_2   (E) -->
									<!-- Grid - 1 (S) -->
									<table width="100%" class="search"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('t4sheet2');</script>
											</td>
										</tr>
									</table> 
									<!-- Grid - 1 (E) -->
									
									<div id="spLayer" style="display:">
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
									
									<table class="search" border="0" style="width:897;"> 
										<tr class="h23">
											<td width="210">	
												<table class="search" border="0">
													<tr>
														<td class="title_h"></td>
														<td class="title_s" width="170">Reason for Special Request</td>
														<td width="33"><input name="spReq" id="spReq" type="checkbox" value="Y" class="trans"></td>
													</tr>
													<tr><td class="height_5"></td></tr>
												</table>
											</td>
											<td width="*" class="stm" id="spReqStr">&nbsp;</td>
										</tr>
									</table> 
									<!-- Grid - 1 (S) -->
									<table width="100%" class="search"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('t1sheet1');</script>
											</td>
										</tr>
									</table> 
									<!-- Container Info Sheet (S) -->
									<script language="javascript">ComSheetObject('t1sheet2');</script>
									<!-- Container Info Sheet (E) -->
									<!-- Grid - 1 (E) -->	
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
																	<td class="btn2" name="btn_add">Row&nbsp;Add</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_insert">Row Insert</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_copy">Row Copy</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_delete">Row Delete</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									</div>
									
									
							</td></tr></table>
							</div>
							<!-- Tab 4 (E) -->
							<!-- Tab 1 (S) -->
							<div id="tabLayer" style="display:inline;">
							<table class="search"> 
				       		<tr>
				       			<td class="bg">
				       			<table class="search" border="0" style="width:897;"> 
										<tr class="h23">	
											<td width="">Following mandated items are missing or improperly described</td>
										</tr>
										<tr>
											<td width="100%">
											<script language="javascript">ComSheetObject('t1sheet0');</script>
											</td>
										</tr>
									</table>
									
									
				       			</td></tr></table></div>
							<!-- Tab 1 (E) -->
							<!-- Tab 2 (S) -->
							<div id="tabLayer" style="display:none;">
							<table class="search" style="width:897;"> 
				       		<tr>
				       		<td class="bg">
								<table class="search" border="0" style="width:897;">
									<tr class="h23">
										<td width="148">UN No./Seq.</td>
										<td width="">&nbsp;<input type="text" style="width:130;" name='imdg_un_no' fullfill  readonly class="input2" required maxlength='4' style="ime-mode:disabled"   caption='UN No.'  value="" >&nbsp;<input type="text" style="width:19;"  name='imdg_un_no_seq'  readonly class="input2"  caption='UN No./Seq.' maxlength='2'   minlength='1' required   value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:583;" readonly class="input2" name='prp_shp_nm' value=""></td>
									</tr>
								</table>
								<table class="search_in" border="0" style="width:897;">
									<tr class="h23">
										<td width="150">Class</td>
										<td width="132"><input type="text" style="width:130;" readonly class="input2" name='imdg_clss_cd' value=""></td>
										<td width="52"></td>
										<td width="90">Pack Group</td>
										<td width="50"><input type="text" style="width:30;" readonly class="input2" name='imdg_pck_grp_cd' value=""></td>
										<td width="89">Cargo Status</td>
										<td width="80">
											<script language="javascript">ComComboObject('dcgo_sts_cd', 1, 62, 1, 3, 0, false);</script>
										</td>
										<td width="89">Limited Q'ty</td>
										<td width="70">
									   		<script language="javascript">ComComboObject('imdg_lmt_qty_flg', 1, 45, 1, 3, 0, false);</script>&nbsp;
									   	</td>
										<td width="95">Excepted Q'ty</td>
										<td width="">
											<script language="javascript">ComComboObject('imdg_expt_qty_flg', 1, 45, 1, 3, 0, false);</script>
									   	</td>
									</tr>
									<tr class="h23">
										<td width="">Grs. Weight</td>
										<td width=""><input type="text" style="width:130;text-align:right"  readonly class="input2" name='grs_wgt' value=""></td>
										<td width=""><input type="text" style="width:40;" readonly class="input2" name='grs_wgt_ut' value="KGS"></td>
										<td width="">Net Weight</td>
										<td colspan="2"><input type="text" style="width:130;text-align:right"  readonly class="input2" name='net_wgt' value=""></td>
										<td width=""><input type="text" style="width:40;" readonly class="input2" name='net_wgt_ut' value="KGS"></td>
										<td width="">Total Capacity</td>
										<td colspan="2"><input type="text" style="width:130;text-align:right"  readonly class="input2" name='ttl_capa' value=""></td>
										<td width=""><input type="text" style="width:40;" readonly class="input2" name='ttl_capa_ut' value="L"></td>
									</tr>
								</table>
								<table class="search_in" border="0" style="width:897;">
									<tr class="h23">
										<td width="150">Outer PKG Qty</td>
										<td width="60"><input type="text" style="width:130;text-align:right"  readonly class="input2" name='out_imdg_pck_qty1' value=""></td>
										<td width="70"><input type="text" style="width:40;"  readonly class="input2" name='out_imdg_pck_cd1' value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td width=""><input type="text" style="width:563;" readonly class="input2" name='out_imdg_pck_desc1' value=""></td>
									</tr>
									<tr class="h23">
										<td width="150">Intermidiate PKG Qty</td>
										<td width="60"><input type="text" style="width:130;text-align:right"  readonly class="input2" name='intmd_imdg_pck_qty1' value=""></td>
										<td width="70"><input type="text" style="width:40;"  readonly class="input2" name='intmd_imdg_pck_cd1' value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td width=""><input type="text" style="width:563;" readonly class="input2" name='intmd_imdg_pck_desc1' value=""></td>
									</tr>
									<tr class="h23">
										<td width="150">Inner PKG Qty(Total)</td>
										<td width="60"><input type="text" style="width:130;text-align:right"  readonly class="input2" name='in_imdg_pck_qty1' value=""></td>
										<td width="70"><input type="text" style="width:40;"  readonly class="input2" name='in_imdg_pck_cd1' value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td width=""><input type="text" style="width:563;" readonly class="input2" name='in_imdg_pck_desc1' value=""></td>
									</tr>
								</table>
								<table class="search_in" border="0" style="width:897;">
									<tr class="h23">
										<td width="150">Outer : Grs. Wgt/Unit</td>
										<td width="132"><input type="text" style="width:130;text-align:right" readonly class="input2" name='out_grs_per_ut' value=""></td>
										<td width="52"><input type="text" style="width:40;" readonly class="input2" name='out_grs_wgt_ut' value="KGS"></td>
										<td width="90">Net Wgt/Unit</td>
										<td width="139"><input type="text" style="width:130;text-align:right" readonly class="input2" name='out_net_per_ut' value=""></td>
										<td width="80"><input type="text" style="width:40;" readonly class="input2" name='out_grs_net_ut' value="KGS"></td>
										<td width="89">Capa/Unit</td>
										<td width="165"><input type="text" style="width:155;text-align:right" readonly class="input2" name='out_ttl_capa_per_ut' value=""></td>
										<td width=""><input type="text" style="width:44;" readonly class="input2" name='out_ttl_capa_ut' value="L"></td>
									</tr>
									<tr class="h23">
										<td width="150">Inner : Grs. Wgt/Unit</td>
										<td width="132"><input type="text" style="width:130;text-align:right" readonly class="input2" name='in_grs_per_ut' value=""></td>
										<td width="52"><input type="text" style="width:40;" readonly class="input2" name='in_grs_wgt_ut' value="KGS"></td>
										<td width="90">Net Wgt/Unit</td>
										<td width="139"><input type="text" style="width:130;text-align:right" readonly class="input2" name='in_net_per_ut' value=""></td>
										<td width="80"><input type="text" style="width:40;" readonly class="input2" name='in_grs_net_ut' value="KGS"></td>
										<td width="89">Capa/Unit</td>
										<td width="165"><input type="text" style="width:155;text-align:right" readonly class="input2" name='in_ttl_capa_per_ut' value=""></td>
										<td width=""><input type="text" style="width:44;" readonly class="input2" name='in_ttl_capa_ut' value="L"></td>
									</tr>
								</table>
							</td></tr></table>
							<table class="height_8"><tr><td></td></tr></table>
							<table class="search" border="0" style="width:897;">
								<tr>
									<td class="bg">
										<!-- : ( Grid ) (S) -->
										<table class = "search" id="mainTable" style="width:897;">
											<tr>
												<td class="title_h"></td>
												<td class="title_s">Restriction Regulatory</td>
											</tr>
											<tr>
											<td colspan="2"><script language="javascript">ComSheetObject('t2sheet1');</script></td>
											</tr>
										</table>
										<table class = "search" id="mainTable" style="width:897;">
											<tr><td colspan="15" class="line_bluedot"></td></tr>
										</table>
										<table class = "search" id="mainTable" style="width:897;">
											<tr>
												<td class="title_h"></td>
												<td class="title_s">Reason of Invalid Details</td>
											</tr>
											<tr>
											<td colspan="2"><script language="javascript">ComSheetObject('t2sheet2');</script></td>
											</tr>
										</table>
										<table class = "search" id="mainTable" style="width:897;">
											<tr><td colspan="15" class="line_bluedot"></td></tr>
										</table>
										<table class = "search" id="mainTable" style="width:897;">
											<tr>
												<td class="title_h"></td>
												<td class="title_s">Special Packaging Instruction & Provisions to be reffered</td>
											</tr>
											<tr>
											<td colspan="2"><script language="javascript">ComSheetObject('t2sheet3');</script></td>
											</tr>
										</table>
										<!-- : ( Grid ) (E) -->
									</td>
								</tr>
							</table>
							</div>
							
							<!-- Tab 2 (E) -->
								</td>
							</tr>
						</table>
						<!--biz page (E)--> 
					<table style="height:5"><tr><td colspan="6"></td></tr></table>
					</td>
				</tr>
			</table>	
			
		
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr>
		       		<td class="btn3_bg">
		       			<div id="spBtnLayer1" style="display:">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
		    						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_sp_request">Special Request</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>	
							</tr>
						</table>
						</div>
						<div id="spBtnLayer2" style="display:none">
						<table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
		    						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>	
							</tr>
						</table>	
						</div>
					    <!--Button (E) -->	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->		
	
</form>


<!-- 개발자 작업  끝 -->

</body>
</html>