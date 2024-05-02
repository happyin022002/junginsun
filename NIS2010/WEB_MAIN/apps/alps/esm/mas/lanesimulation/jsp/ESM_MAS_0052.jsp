<%--=========================================================================
'주  시 스 템 : ALP
'서브  시스템 : Proforma SKD 조회/변경
'프로그램 ID  : apps/enis/esm/mas/lanesimulation/jsp/ESM_MAS_052.jsp
'프로그램 명  : Proforma SKD 조회/변경
'프로그램개요 : Proforma SKD 조회/변경
'작   성   자 : Park Eun Ju
'작   성   일 : 2006.09.06
=============================================================================
' History :
' 20080219 박은주 N200802040018 MAS 내 항로 Simulation 로직 변경
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
' 2008,11.06 전성진 CSR No.N200811050011
'					- 메뉴명 수정
' 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
. 2009.06.15 배진환 N200905220060 Lane Simulation System 수정사항
' 2009.08.27 윤진영 ALPS 환경으로 변경작업
' 2010.02.23 윤진영 duration1 editable false로 변경.
' 2010.06.14 윤진영 CHM-200901719 UI표준처리 open시 조회버튼에  포커스
' 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.lanesimulation.event.EsmMas0052Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
  	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    EsmMas0052Event event     = null;     //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg  = "";            //에러메세지
    String xml = "";
    String v_ext_flg  = "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.mas.lanesimulation.EsmMas0052");

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	xml = HttpUtil.makeXML(request,response); 
            xml = xml.replaceAll("\"", "'");
            
            v_ext_flg     = JSPUtil.getNull(request.getParameter("f_ext_flg"));
            if(v_ext_flg.equals("")) v_ext_flg = "N";
        } // end else
        
    }catch(Exception e) {
        log.error("ESM_MAS_052 Exception : "+e.toString());
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Inquire/Edit Proforma SKD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<!--
    function setupPage(){

        var errMessage = "<%=strErrMsg%>";

        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
-->
</script>
</head>


<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_txtTmp"> <!-- simNo       -->
<input type="hidden" name="f_ext_flg" value="<%= v_ext_flg %>"> <!-- New Lane, Existing Lane 체크유무       -->
<input type="hidden" name="f_header"> <!--        -->
<input type="hidden" name="f_totsum">
<input type="hidden" name="f_lod_ttl_qty">
<input type="hidden" name="f_sect_no">
<input type="hidden" name="f_port_arr">
<input type="hidden" name="f_yard_arr">
<input type="hidden" name="f_save_flg" value="false"><!--1,2 step save구분-->
<input type="hidden" name="f_calcu_btn_flg" value="false"><!--1차 save이후에 true가 된다-->
<input type="hidden" name="sXml" value="<%=xml%>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Port/Route Register</td></tr>
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
                    <tr>
                        <td class="bg">
                            <!-- : ( Select 'Simulation No' ) (S) -->
                            <table class="search_in" border="0">
                                <tr class="h23">
                                    <td width="110">S/Lane</td>
                                    <td width="84" style="text-indent:2;">
                                    	<script language="javascript">ComComboObject('f_slan_cd', 1, 80 , 0 )</script>
                                    </td>
                                    <td width="84">
                                    		<script language="javascript">ComComboObject('f_dept_cd2',1, 80 , 0 )</script>
                                    </td>
                                    <td>
                                    		<script language="javascript">ComComboObject('f_sim',1, 200 , 0 )</script>
                                    </td>
	                          		<td>&nbsp;</td>
                                </tr>
                            </table>

                            <table class="search_in" border="0">
                                <tr class="h23">
                                    <td width="110">Simulation No.</td>
                                    <td width="317">
                                        <input type="text" style="width:30;" name="f_dept_cd" maxlength="3" readOnly  class="input2">&nbsp;&nbsp;-&nbsp;
                                        <input type="text" style="width:75;" name="f_sim_dt" dataformat="ymd" maxlength="8" readOnly class="input2">
                                        <input type="text" style="width:34;" name="f_sim_no" maxlength="3" onkeydown="onlyNumber(window);" onBlur="fillSpace(this, 3, '0', 'left');" onfocus="this.select()" readOnly class="input2">
										<!--input type="text" style="width:75;" name="f_sim_dt" maxlength="8" dataformat="ymd" onblur="ComAddSeparator(this);" onFocus="ComClearSeparator(this); this.select();" readOnly class="input2">
										<input type="text" style="width:34;" name="f_sim_no" maxlength="3" onBlur="fillSpace(this, 3, '0', 'left');" onfocus="this.select()" readOnly class="input2"-->										                                        
                                        <input type="text" style="width:75;" name="f_usr_id" readOnly class="input2" >
                                    </td>
                                    <td width="55">Remark</td>
                                    <td><input type="text" style="width:100%;" name="f_sim_rmk" class="noact2"></td>
                                </tr>
                            </table>

                            <table class="search_in" border="0">
                            <tr class="h23">
                            	<td>Working Steps</td></tr>
                            <tr><td valign="top">
                                        <table class="search" border="0">
                                            <tr>
                                            	<td width="110">&nbsp;</td>
                                                <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step01.gif"    border="0" name="step01"></td>
                                                <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step02_on.gif" border="0" name="step02"></td>
                                                <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step03.gif"    border="0" name="step03"></td>
                                                <td><img class="cursor" src="/hanjin/img/alps/cost_step04.gif"    border="0" name="step04"></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                            <!-- : ( Select 'Simulation No' ) (E) -->
                        </td>
                    </tr>
                </table>
                <!-- TABLE '#D' : ( Search Options ) (E) -->


                <table class="height_10"><tr><td></td></tr></table>


				<!-- **************** Tab BG Box - 'A' (OutSide) (S) ********************* -->
				<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (S) -->
		     	<table class="search" border="0">
			       	<tr>
						<td class="bg">

							<table class="search" border="0">
								<tr><td height="30" valign="top"><img src="/hanjin/img/alps/cost_step02s.gif" height="22" border="0"></td></tr>
							</table>

							<!-- **************** Tab BG Box - 'B' (InSide) (S) ********************* -->
							<!-- TABLE '#E' : ( Tab ) (S) -->
							<table class="tab">
								<tr><td><script language="javascript">ComTabObject('tab1','#F3F2F8')</script></td></tr>
							</table>
							<!-- TABLE '#E' : ( Tab ) (E) -->

<!-- Tab1 Port/TMNL Setting ///////////////////////////////////////////////////////////////////////////////////////////////// -->
							<div id="tabLayer" style="display:inline">
							<table class="search" border="0">
								<tr>
									<td class="bg">
										<table class="search" border="0" style="width:719;">
											<tr>
												<td class="title_h"></td>
												<td class="title_s">Port TML Setting</td>
											</tr>
											<tr><td height="3"></td></tr>
										</table>
										
										<!--20090925 Design 추가 부분-->
										<table class="search_in" border="0">
											<tr class="h23">
												<td>Lane</td>
												<td><input type="text" style="width:84;" name="f_slan_cd2" class="input2"></td>
												<td>Sea Speed</td>
												<td class="stm">
													<input type="text" style="width:40;" class="input2" name="f_min_speed" value="">&nbsp;&nbsp;~&nbsp;
													<input type="text" style="width:40;" class="input2" name="f_max_speed" value="">&nbsp;&nbsp;&nbsp;&nbsp;</td>
												<td>Duration1</td>
												<td colspan="2"><input type="text" style="width:35;" class="input2" name="f_svc_dur_dys"></td>
												<td colspan="2">Duration2</td>
												<td colspan="3"><input type="text" style="width:35;" class="input2" name="f_svc_dur_dys_result"></td>												
												<td rowspan="2" align="right" style="width:47;"><div id="arrow_direction"><input class='input2' style="font-weight:bold;font:14px;color:#ff0080;" type='button' value=' ▶ ' onClick='show_next();'></div></td>
											</tr>
											<tr class="h23">
												<td width="80">Vessel Class</td>
												<td width="320">
													<input type="text" style="width:55;" class="input2" name="n1st_vsl_clss_cd"  value="">
													<input type="text" style="width:25;" class="input2" name="n1st_vsl_clss_knt" value="">&nbsp;&nbsp;
													<input type="text" style="width:55;" class="input2" name="n2nd_vsl_clss_cd"  value="">
													<input type="text" style="width:25;" class="input2" name="n2nd_vsl_clss_knt" value="">&nbsp;&nbsp;
													<input type="text" style="width:55;" class="input2" name="n3nd_vsl_clss_cd"  value="">
													<input type="text" style="width:25;" class="input2" name="n3nd_vsl_clss_knt" value=""></td>
												<td width="70">Frequency</td>
												<td width="150"><input type="text" style="width:25;" 
												                      onChange="javascript:freQuencyChg()"
												                      class="input1" name="f_brth_itval_dys"></td>
												<td width="95">First Port ETB</td>
												<td width="25" class="stm">No.</td>
												<td width="35"><input type="text" style="width:25;" name="fpeNo" class="input1" maxlength="1" value="0" onchange="chgFfe(1);"></td>
												<td width="22" class="stm">Day</td>
												<td width="63">
													<select name="fpeCd" style="width:53;" class="input1" onchange="chgFfe(2);">
														<option value="MON" selected>MON</option>
														<option value="TUE">TUE</option>
														<option value="WED">WED</option>
														<option value="THU">THU</option>
														<option value="FRI">FRI</option>
														<option value="SAT">SAT</option>
														<option value="SUN">SUN</option>
													</select></td>
												<td width="30" class="stm">Time</td>
												<td><input type="text" style="width:45;" name="fpeHm" class="input1" maxlength="5" value="00:00" onchange="chgFfe(3);"></td>
											</tr>
										<tr><td height="3"></td></tr>
										</table>
										<!--20090925 Design 추가 부분-->
										<!-- : ( No. ) (S) -->
										<table width="100%" id="mainTable">
											<tr>
												<td><script language="javascript">ComSheetObject('sheet1');</script></td>
											</tr>
										</table>
										<!-- : ( No. ) (E) -->
										<!--  Button_Sub (S) -->
										<table width="100%" class="button">
											<tr>
												<td class="btn2_bg">
													<table border="0" cellpadding="0" cellspacing="0">
														<tr>
															<!-- Repeat Pattern -->
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr><td class="btn2_left" id="btn_calcuration_pre" name="btn_calcuration_pre"></td><td class="btn2" id="btn_calcuration" name="btn_calcuration" onClick="javascript:setCalcuration();">Calculation</td><td class="btn2_right" id="btn_calcuration_next" name="btn_calcuration_next"></td></tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr><td class="btn2_left"></td><td class="btn2" onClick="javascript:setYardInfo();">Set Yard</td><td class="btn2_right"></td></tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr><td class="btn2_left"></td><td class="btn2" id="btn_rowadd1" name="btn_rowadd1">Row Add</td><td class="btn2_right"></td></tr>
																</table>
															</td>
															<td>
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr><td class="btn2_left"></td><td class="btn2" id="btn_save1" name="btn_save1">Save</td><td class="btn2_right"></td></tr>
																</table>
															</td>
															<td id="td_getPT" style="display:<% if(v_ext_flg.equals("Y"))out.print("block"); else out.print("none");%>">
																<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr><td class="btn2_left"></td><td class="btn2" id="btng_getopdays1"  name="btng_getopdays1">Get OP Days</td><td class="btn2_right"></td></tr>
																</table>
															</td>
															<!-- Repeat Pattern -->
														</tr>
													</table>
												</td>
											</tr>
										</table>
										<!-- Button_Sub (E) -->
										<table class="search" border="0">
                      <tr class="h23">
                        <td class="gray_tit" style="padding-left:0;"><img src="/hanjin/img/ico_star.gif">&nbsp;<strong>Remark</strong></td>
                      </tr>
                      <tr class="h23">
                        <td class="gray_tit" colspan="2" style="padding-left:10;">
                          <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                               Click Retrieve button - Click Get OP days - Click Save - Click tab 'Route Projection' - Click Creation - Click tab 'Port TMNL Setting' - Click Retrieve - Click '▶' - Click Calculation - Click Save.
                        </td>
                      </tr>
                    </table>	
									</td>
								</tr>
							</table>
							</div>


<!-- Tab2  Route Projection ///////////////////////////////////////////////////////////////////////////////////////////////// -->
							<div id="tabLayer" style="display:none">
							<table class="search" border="0">
								<tr>
									<td class="bg">
			                            <table class="search" border="0">
			                                <tr>
			                                    <td class="title_h"></td>
			                                    <td class="title_s">Lane Projection</td>
			                                    <td class="gray" rowspan="2">(TEU, USD)</td>
			                                </tr>
											<tr><td height="3"></td></tr>
			                            </table>
			                            <!-- : ( No. ) (S) -->
			                            <table width="100%" id="mainTable2">
			                                <tr>
			                                    <td>
			                                        <script language="javascript">ComSheetObject('sheet2');</script>
			                                    </td>
			                                </tr>
			                            </table>
			                            <!-- : ( No. ) (E) -->

										<!--  Button_Sub (S) -->
										<table width="100%" class="button">
									       	<tr><td class="btn2_bg">
											<table border="0" cellpadding="0" cellspacing="0">
											<tr>

												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" id="btn_save2" name="btn_save2">Save</td><td class="btn2_right"></td></tr></table></td>
												<!-- Repeat Pattern -->


											</tr></table>
										</td></tr>
										</table>
								    	<!-- Button_Sub (E) -->


			                            <table class="line_bluedot"><tr><td></td></tr></table>

										<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (S) -->
								     	<table class="search" border="0">
									       	<tr>
												<td>
													<!-- **************** Tab BG Box - 'B' (InSide) (S) ********************* -->
													<table class="tab">
														<tr><td><script language='javascript'>  ComTabObject('tab2','#F3F2F8', '100%', null, false) </script></td></tr>
													</table>

													<!-- **************** Tab BG Box - 'E' (InSide) (S) ********************* -->
													<div id="tabLayer2" style="display:inline">
													<table class="search" border="0" style="border-top:1px solid white;">
														<tr>
															<td class="bg">
																<table  border="0" style="width:963; height:35;">
																	<tr class="h23">
																		<td width="440">
																			<input type="radio" name="rdoCode" value="0" class="trans" onClick="javascript:displayType(0);" checked>Port Pair Vol. (Before)&nbsp;
																			<input type="radio" name="rdoCode" value="1" class="trans" onClick="javascript:displayType(1);">Port Pair %&nbsp;
																			<input type="radio" name="rdoCode" value="2" class="trans" onClick="javascript:displayType(2);">Port Pair Vol. (After)
																		</td>
																		<td width="37">Trade</td>
																		<td width="75">
																			<script language="javascript">ComComboObject('f_trd_cd', 1, 60 , 0 )</script>
																		</td>
																		<td width="40">R/Lane</td>
																		<td width="75">
																			<div id="div_rLane">
																				<script language="javascript">ComComboObject('f_rlane_cd', 1, 60 , 0 )</script>
																			</div>
																		</td>
																		<td width="25">Dir.</td>
																		<td width="55">
																			<script language="javascript">ComComboObject('f_dir_cd', 1, 40 , 0 )</script>
																		</td>
																		<td width="90">Source Period</td>
																		<td>
																			<select name="f_prd_cd" style='width:110;'>
																				<option value="1">Latest 1 Month</option>
																				<option value="2">Latest 2 Month</option>
																				<option value="3">Latest 3 Month</option>
																			</select>
																		</td>
																	</tr>
																</table>
																<table width="100%" id="mainTable3">
																	<tr>
																		<td><script language="javascript">ComSheetObject('sheet3');</script></td>
																	</tr>
																</table>
																<!--  Button_Sub (S) -->
																<table width="100%" class="button">
																	<tr>
																		<td class="btn2_bg">
																			<table border="0" cellpadding="0" cellspacing="0">
																				<tr>
																					<!-- Repeat Pattern -->
																					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr><td id="btn_create_left" class="btn2_left"></td><td class="btn2" id="btn_create" name="btn_create">Create</td><td id="btn_create_right" class="btn2_right"></td></tr></table></td>
																					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"><tr><td id="btn_save3_left" class="btn2_left"></td><td class="btn2" id="btn_save3" name="btn_save3"> Save </td><td id="btn_save3_right" class="btn2_right"></td></tr></table></td>
																					<!-- Repeat Pattern -->
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

													<div id="tabLayer2" style="display:none">
													<table class="search" border="0" style="border-top:1px solid white;">
														<tr>
															<td class="bg">
																<table height="35"><tr><td></td></tr></table>
																<table width="100%" id="mainTable4">
																	<tr>
																		<td><script language="javascript">ComSheetObject('sheet4');</script></td>
																	</tr>
																</table>
																<!--  Button_Sub (S) -->
																<table width="100%" class="button">
																	<tr>
																		<td class="btn2_bg">
																			<table border="0" cellpadding="0" cellspacing="0">
																				<tr>
																					<!-- Repeat Pattern -->
																					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																						<tr><td class="btn2_left"></td><td class="btn2" id="btn_save4" name="btn_save4">Save</td><td class="btn2_right"></td></tr></table></td>
																					<!-- Repeat Pattern -->
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
												</td>
											</tr>
			                            </table>
			                    	</td>
			                	</tr>
			                </table>
							<!-- TABLE '#E' : ( Tab (2) - 'B' ) (E) -->
							</div>

<!-- Tab3 TMNL Transit Time ///////////////////////////////////////////////////////////////////////////////////////////////// -->
							<div id="tabLayer" style="display:none">
							<!-- TABLE '#E' : ( Tab (2) - 'B' ) (S) -->
							<table class="search" border="0">
								<tr>
									<td class="bg">
										<table class="search" border="0" style="width:719;">
											<tr>
												<td class="title_h"></td>
												<td class="title_s">TML Transit Time</td>
											</tr>
											<tr><td height="3"></td></tr>
										</table>
										<!-- : ( No. ) (S) -->
										<table width="100%" id="mainTable5">
											<tr>
												<td>
												<script language="javascript">ComSheetObject('sheet5');</script>
												</td>
											</tr>
										</table>
										<!-- : ( No. ) (E) -->


										<!--  Button_Sub (S) -->
										<table width="100%" class="button">
									       	<tr><td class="btn2_bg">
											<table border="0" cellpadding="0" cellspacing="0">
											<tr>

												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" id="btn_creation" name="btn_creation">Creation</td><td class="btn2_right"></td></tr></table></td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" id="btn_save5" name="btn_save5">Save</td><td class="btn2_right"></td></tr></table></td>
												<!-- Repeat Pattern -->


											</tr>
										</table>
									</td>
								</tr>
							</table>
							<!-- Button_Sub (E) -->
							<!-- TABLE '#E' : ( Tab (2) - 'B' ) (E) -->
							</div>
<!-- Tab3 ///////////////////////////////////////////////////////////////////////////////////////////////// -->

                        </td>
                    </tr>
                </table>
                <!-- TABLE '#D' : ( Search Options ) (E) -->




</td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>
