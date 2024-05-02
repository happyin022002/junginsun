<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0280.jsp
*@FileTitle : Fuel Surcharge (FUA) Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
===============================================================================
 History
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.event.EsdTrs0280Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	EsdTrs0280Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String optionStr2   = "000020::";
	String usr_id	= "";
	String ofc_cd	  = "";
	String selTRANSMODE = "";	//Trans Mode Combo

	selTRANSMODE	= JSPUtil.getCodeCombo("fm_agmt_trsp_tp_cd", "01"	,"style=width:80", "CD00283", 0, optionStr2);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		usr_id = account.getUsr_id();
		ofc_cd = account.getOfc_cd();

		event = (EsdTrs0280Event)request.getAttribute("Event");
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
<title>Delivery Monitor Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_cost_mod_cd",	"", "CD02177", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("agmt_trsp_tp_cd",	"", "CD00283", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cgo_tp_cd",			"", "CD00748", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("rail_svc_tp_cd",	"", "CD00916", 0, "")%>
	<%= BizComUtil.getIBCodeCombo("curr_cd",		"", "CURR", 0, "")%>
	
	<%= JSPUtil.getIBCodeCombo("trsp_scg_cd",	    "", "CD00917", 0, "")%>

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
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="fm_old_ofc_cd" >
	<input type="hidden" name="fm_ofc_cd"	  value="<%=ofc_cd%>">
	<input type="hidden" name="fm_usr_id"	  value="<%=usr_id%>">
	<input type="hidden" name="header_row"	>	
	<!-- Outer Table (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
		<tr>
			<td>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
					<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
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
												<td class="btn1" id="btn_new" name="btn_new">New</td>
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
									<td width="10%">Agreement No.</td>
									<td width="13%">
										<input name="fm_agmtno" type="text" style="width:80;" class="input1" maxlength="9"  dataformat="engup">
										<img name='btn_agmtno' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
									</td>
									<td width="8%">S/P Code</td>
									<td width="20%">
										<input name='fm_vndr_prmry_seq' type="text" style="width:50" class="input1" maxlength="6" dataformat="num" onBlur="vender_blur();">
										<input name="fm_vndr_prmry_nm" type="text" style="width:100;" class="input" readonly>
						                <img name='btn_serviceprovider' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
									</td>
									<td width="10%">Contract Office</td>
									<td >
										<input name="fm_ctrt_ofc_cd" type="text" style="width:80;" class="input1" value="" dataformat="engup">
					                	<input name="chk_office" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice();">&nbsp;Incl. Sub OFC
									</td>									
								</tr>
								<tr class="h23">
									<td>Effective AGMT</td>
									<td>
						                  <select style="width:80;" class="input" name="fm_effective_agmt" >
						                    <option value="C" selected>LATEST</option>
						                    <option value="A">ALL</option>
						                  </select>		
						            </td>							
						            <td>Cost Mode</td>
					                <td>
					                  <select style="width:95;" class="input" name="fm_trsp_cost_mod_cd" >
					                    <option value="" selected>ALL</option>
					                    <option value="DR">DR</option>
					                    <option value="CY">CY</option>
					                    <option value="BS">BS</option>
					                    <option value="BF">BF</option>
					                    <option value="MF">MF</option>
					                    <option value="DC">DC</option>
					                    <option value="MM">MM</option>
					                  </select>
					                </td>
									<td>Trans Mode</td>
					                <td>
					                  <%=selTRANSMODE%>
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
		       	<tr><td><script language="javascript">ComTabObject('tab1' )</script></td></tr>
				</table>
				<!-- TABLE '#D' : ( Tab ) (E) -->
						
				<div id="tabLayer" style="display:inline">

				<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
				<table class="search" border="0">
					<tr> 
						<td class="bg">
							<table width="100%" id="mainTable">
		                        <tr>
		                        	<td>
		                             	<script language="javascript">ComSheetObject('t1sheet1');</script>
			                        </td>
			                   </tr>
		                    </table>
				            <table>
				              <tr class="bg_b1" height="5">
				                <td class="title_h"></td>
				                <td align="left" class="title_s">Verify Error&nbsp;:&nbsp;</td>
				                <td align="left" valign="bottom">&nbsp;<input type="text"  class="input2" style="width:30;valign:bottom;" id="verify_result1" name="verify_result1" value="0" readonly></td>
				                <td align="left" valign="bottom">&nbsp;&nbsp;<input type="text"  class="input2" style="width:304;valign:bottom;font-color:red;" id="verify_result_str1" name="verify_result_str1" value="( UPDATE DISABLE! )" readonly></td>
				                <td align="left" class="title_s">&nbsp;&nbsp;&nbsp;Updated Row Count&nbsp;:&nbsp;</td>
				                <td align="left" valign="bottom">&nbsp;
				                  <input type="text"  class="input2" style="width:35;valign:bottom;" id="updated_rows_cnt1" name="updated_rows_cnt1" value="0" readonly>&nbsp;/
				                  <input type="text"  class="input2" style="width:35;valign:bottom;" id="total_rows_cnt1" name="total_rows_cnt1" value="0" readonly>&nbsp;
				                  <input type="hidden" id="verify_check_yn1" name="verify_check_yn1" value="N">
				                  <input type="hidden" id="message1" name="message1">
				                  <input type="hidden" id="nosave1" name="nosave1" value="N">
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
															<td class="btn2"  id="btng_row_del1" name="btng_row_del1">Delete</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_loadexcel1" name="btng_loadexcel1">File Import</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_verify1" name="btng_verify1">Verify</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_update1" name="btng_update1">Update</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_down_excel1" name="btng_down_excel1">Down Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_rate_history1" name="btng_rate_history1">Rate History</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_verify_rule1" name="btng_verify_rule1">Verify Rule</td>
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
				<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
				</div>
				
				<div id="tabLayer" style="display:none">
				<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<table width="100%" id="mainTable">
		                        <tr>
		                        	<td>
		                            	<script language="javascript">ComSheetObject('t2sheet1');</script>
			                        </td>
			                   </tr>
		                    </table>
				            <table>
				              <tr class="bg_b1" height="5">
				                <td class="title_h"></td>
				                <td align="left" class="title_s">Verify Error&nbsp;:&nbsp;</td>
				                <td align="left" valign="bottom">&nbsp;<input type="text"  class="input2" style="width:30;valign:bottom;" id="verify_result2" name="verify_result2" value="0" readonly></td>
				                <td align="left" valign="bottom">&nbsp;&nbsp;<input type="text"  class="input2" style="width:304;valign:bottom;font-color:red;" id="verify_result_str2" name="verify_result_str2" value="( UPDATE DISABLE! )" readonly></td>
				                <td align="left" class="title_s">&nbsp;&nbsp;&nbsp;Updated Row Count&nbsp;:&nbsp;</td>
				                <td align="left" valign="bottom">&nbsp;
				                  <input type="text"  class="input2" style="width:35;valign:bottom;" id="updated_rows_cnt2" name="updated_rows_cnt2" value="0" readonly>&nbsp;/
				                  <input type="text"  class="input2" style="width:35;valign:bottom;" id="total_rows_cnt2" name="total_rows_cnt2" value="0" readonly>&nbsp;
				                  <input type="hidden" id="verify_check_yn2" name="verify_check_yn2" value="N">
				                  <input type="hidden" id="message2" name="message2">
				                  <input type="hidden" id="nosave2" name="nosave2" value="N">
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
															<td class="btn2"  id="btng_row_del2" name="btng_row_del2">Delete</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_loadexcel2" name="btng_loadexcel2">File Import</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_verify2" name="btng_verify2">Verify</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_update2" name="btng_update2">Update</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_down_excel2" name="btng_down_excel2">Down Excel</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_rate_history2" name="btng_rate_history2">Rate History</td>
															<td class="btn2_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2"  id="btng_verify_rule2" name="btng_verify_rule2">Verify Rule</td>
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
				<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
				</div>
				
			</td>
		</tr>
	</table>
	<!-- Outer Table (E)-->
</form>
</body>
</html>