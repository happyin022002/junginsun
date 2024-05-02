<%--=========================================================================
'주  시 스 템 : ENIS
'서브  시스템 : 항로_구간별 OP Level 생성/조회/변경
'프로그램 ID  : apps/enis/esm/coa/lanesimulation/jsp/ESM_COA_0053.jsp
'프로그램 명  : 항로_구간별 OP Level 생성/조회/변경
'프로그램개요 : 항로_구간별 OP Level 생성/조회/변경
'작   성   자 : Park Eun Ju
'작   성   일 : 2006.09.15
=============================================================================
* History
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2008,11.06 전성진 CSR No.N200811050011
*					- 메뉴명 수정, 링크 밑줄 표시
* 2009.03.31 박은주 S2K-09U-002(Lane Simulation System 개선)
* 2009.06.15 배진환 N200905220060 Lane Simulation System 수정사항
* 2009.07.20 윤진영 Alps전환작업
* 2010.05.03 윤진영 port clss capa삭제
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                   - 파일 타이틀 주석내의 파일명 수정
=========================================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.lanesimulation.event.EsmCoa0053Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
  	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    EsmCoa0053Event  event = null;                				//PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse =  null;
    Exception serverException   = null;            				//서버에서 발생한 에러
    String strErrMsg 	= "";   								//에러메세지
    String xml = "";
    String v_ext_flg = "";
    String v_op_header_cd = "";
    String v_op_header_nm = "";
    String v_cm_header_cd = "";
    String v_cm_header_nm = "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.coa.lanesimulation.EsmCoa0053Event");
    try {
        event = (EsmCoa0053Event)request.getAttribute("Event");
        eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            v_ext_flg     = JSPUtil.getNull(request.getParameter("f_ext_flg"));
            if(v_ext_flg.equals("")) v_ext_flg = "N";

            xml = HttpUtil.makeXML(request,response);
            xml = xml.replaceAll("\"", "'");

            v_op_header_cd = eventResponse.getETCData("op_header_cd");
            v_op_header_nm = eventResponse.getETCData("op_header_nm");
            v_cm_header_cd = eventResponse.getETCData("cm_header_cd");
            v_cm_header_nm = eventResponse.getETCData("cm_header_nm");
        }

    }catch(Exception e) {
        log.error("ESM_COA_0053 Exception : "+e.toString());
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Inquire/Edit OP Level Cost</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage("<%= v_op_header_cd %>","<%= v_op_header_nm %>","<%= v_cm_header_cd %>","<%= v_cm_header_nm %>");
    }
</script>
</head>
<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_txtTmp" > <!-- simNo       -->
<input type="hidden" name="f_ext_flg" value="<%= v_ext_flg %>"> <!-- New Lane, Existing Lane 체크유무       -->
<input type="hidden" name="f_tml_cd" >
<input type="hidden" name="f_cm_header" value="<%= v_cm_header_cd %>">
<input type="hidden" name="f_op_header" value="<%= v_op_header_cd %>">
<input type="hidden" name="sXml" value="<%=xml%>">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Cost Calculation CM/OP</td></tr>
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
	                          	<script language="javascript">ComComboObject('f_dept_cd2', 1, 80 , 0 )</script>
	                          </td>
	                          <td>
	                          	<script language="javascript">ComComboObject('f_sim', 1, 204 , 0 )</script>
	                          </td>
	                          <td>&nbsp;</td>
	                      </tr>
	                </table>

	                <table class="search_in" border="0">
	                      <tr class="h23">
	                          <td width="110">Simulation No.</td>
	                          <td width="317">
	                              <input type="text" style="width:30;" name="f_dept_cd" class="input2" maxlength="3" readOnly >&nbsp;&nbsp;-&nbsp;
                                <input type="text" style="width:75;" name="f_sim_dt" dataformat="ymd" maxlength="8" readOnly class="input2">
	                              <input type="text" style="width:34;" name="f_sim_no" class="input2" maxlength="3"  readOnly>
	                              <!--input type="text" style="width:75;" name="f_sim_dt" class="input2" maxlength="8"  dataformat="ymd" onblur="ComAddSeparator(this);" onFocus="ComClearSeparator(this);this.select();" readOnly>
	                              <input type="text" style="width:34;" name="f_sim_no" class="input2" maxlength="3"  onBlur="fillSpace(this, 3, '0', 'left');" onfocus="this.select()" readOnly-->
	                              <input type="text" style="width:75;" name="f_usr_id" class="input2" readOnly>
	                          </td>
	                          <td width="55">Remark</td>
	                          <td><input type="text" style="width:100%;" name="f_sim_rmk"></td>
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
	                                      <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step02.gif" border="0" name="step02"></td>
	                                      <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step03_on.gif"    border="0" name="step03"></td>
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

					<table class="search" border="0" width="100%">
						<tr>
							<td colspan="2" height="30" valign="top"><img src="/hanjin/img/alps/cost_step03s.gif" height="22" border="0"></td>
							<td width="25" align="right" valign="bottom" style="padding-right:3;">
						        <div id="div_zoom_in1" style="display:inline"> <!-- absolute / relative -->
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
								</div>
								<div id="div_zoom_out1" style="display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
								</div>
							</td>
						</tr>
					</table>

					<!-- **************** Tab BG Box - 'B' (InSide) (S) ********************* -->
					<!-- TABLE '#E' : ( Tab ) (S) -->
					<table class="tab">
						<tr><td><script language="javascript">ComTabObject('tab1','#F3F2F8')</script></td></tr>
					</table>
					<!-- TABLE '#E' : ( Tab ) (E) -->

<!-- Tab1 ///////////////////////////////////////////////////////////////////////////////////////////////// -->
					<div id="tabLayer" style="display:inline">

	                <!-- TABLE '#D' : ( Search Options ) (S) -->
					<table class="search" border="0" style="border-top:1px solid white;">
					<tr><td class="bg">

								<table class="height_10"><tr><td></td></tr></table>

	                            <table class="search" border="0">
	                                <tr>
	                                    <td class="title_h"></td>
	                                    <td class="title_s">Lane Summary</td>
	                                    <td class="gray" rowspan="2">(TEU)</td>
	                                </tr>
	                                <tr><td class="height_5" colspan="2"></td></tr>
	                            </table>
	                            <table width="100%" id="mainTable1">
	                                <tr>
	                                    <td>
	                                        <script language="javascript">ComSheetObject('sheet1');</script>
	                                    </td>
	                                </tr>
	                            </table>

	                            <!-- : ( Button : Grid ) (E) -->
	                            <table class="line_bluedot"><tr><td></td></tr></table>
	                            <table class="search" border="0">
	                                <tr>
	                                    <td class="title_h"></td>
	                                    <td class="title_s">Route Summary</td></tr>
	                                    <tr><td class="height_10" colspan="2"></td>
	                                </tr>
	                            </table>
	                            <!-- : ( Cost Items ) (S) -->
	                            <table class="search_in" border="0">
	                                <tr class="h23">
	                                    <td width="10%">Cost Items</td>
	                                    <td width="40%">
	                                    	<script language="javascript">ComComboObject('f_sgrp_cost_cd', 1, 150 , 0 )</script>
	                                    </td>
	                                    <td width="6%">Route</td>
	                                    <td width="10%" class="sm"><input type="radio" value="0" name="rdoCode" class="trans" onClick="javascript:displayType(0);" checked>&nbsp;Unit Cost&nbsp;</td>
	                                    <td class="sm"><input type="radio" value="1" name="rdoCode" class="trans" onClick="javascript:displayType(1);">&nbsp;AMT Calculation</td>
	                                </tr>
	                            </table>
	                            <!-- : ( Port Pair  ) (E) -->
	                            <table class="search" border="0">
	                                <tr>
	                                    <td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;<input type="text" name="subtitle" style="width:234;" class="transgray" readonly></td>
	                                    <td class="gray" rowspan="2">(TEU)</td>
	                                </tr>
	                                <tr><td class="height_5"></td></tr>
	                            </table>
	                            <!-- : ( Grid : POL / POD ) (S) -->
	                            <!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
	                            'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
	                            <table width="100%" id="mainTable2">
	                                <tr>
	                                    <td>
	                                        <script language="javascript">ComSheetObject('sheet2');</script>
	                                    </td>
	                                </tr>
	                            </table>
	                            <!-- : ( Grid : POL / POD ) (E) -->

								<!--  Button_Sub (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td >
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr id="tr_save1">
												<td class="btn2_left"></td>
												<td class="btn2" id="btn_save1" name="btn_save1">Save</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<!-- Repeat Pattern -->

									</tr></table>
								</td></tr>
								</table>
						    	<!-- Button_Sub (E) -->

	                            <table width="100%" id="mainTable3">
	                                <tr>
	                                    <td>
	                                        <script language="javascript">ComSheetObject('sheet3');</script>
	                                    </td>
	                                </tr>
	                            </table>
	                        </td>
	                    </tr>
	                </table>
	                <!-- TABLE '#D' : ( Search Options ) (E) -->


					</div>

<!-- Tab2 ///////////////////////////////////////////////////////////////////////////////////////////////// -->
					<div id="tabLayer" style="display:inline">
					<!-- TABLE '#E' : ( Tab (1) - 'B' ) (S) -->
					<table class="search" border="0" style="border-top:1px solid white;">
					<tr><td class="bg">

								<table class="height_10"><tr><td></td></tr></table>
								<table class="search" border="0" style="width:719;">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">Port Charge</td>
									</tr>
									<tr><td class="height_5"></td></tr>
								</table>
								<!-- : ( Port ) (S) -->
								<table width="100%" id="mainTable4">
									<tr><td>
									<script language="javascript">ComSheetObject('sheet4');</script>
									</td></tr>
								</table>
								<!-- : ( Port ) (E) -->

								<!--  Button_Sub (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btn_create" name="btn_create">Creation</td><td class="btn2_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btn_save" name="btn_save">Save</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->

									</tr></table>
								</td></tr>
								</table>
						    	<!-- Button_Sub (E) -->


							</td>
						</tr>
					</table>
					<!-- TABLE '#E' : ( Tab (1) - 'B' ) (E) -->
					</div>


<!-- Tab3 ///////////////////////////////////////////////////////////////////////////////////////////////// -->
					<div id="tabLayer" style="display:none">
					<!-- TABLE '#E' : ( Tab (2) - 'B' ) (S) -->
					<table class="search" border="0" style="border-top:1px solid white;">
					<tr><td class="bg">
								<table class="height_10"><tr><td></td></tr></table>
								<table class="search" border="0" >
									<tr>
										<td class="title_h"></td>
										<td class="title_s">Bunker Cost</td>
										<td align="right" valign="top" width="50%" height="18" >
											<div id="dir_bnk_consum" style="display:none">
												<img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
												<a href="javascript:callVslConsum();" class="purple">Consumption Matrix by Class</a> &nbsp;
											</div>
										</td>
									</tr>
									<tr><td class="height_5" colspan="3"></td></tr>
								</table>
								<!-- : ( No. ) (S) -->
								<table width="100%" id="mainTable5">
									<tr><td>
									<script language="javascript">ComSheetObject('sheet5');</script>
									</td></tr>
								</table>
								<!-- : ( No. ) (E) -->

								<!--  Button_Sub (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btn_save" name="btn_save">Save</td><td class="btn2_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btng_basic" name="btng_basic">Basic</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->

									</tr></table>
								</td></tr>
								</table>
						    	<!-- Button_Sub (E) -->

							</td>
						</tr>
					</table>
					<!-- TABLE '#E' : ( Tab (2) - 'B' ) (E) -->
					</div>

<!-- Tab4 ///////////////////////////////////////////////////////////////////////////////////////////////// -->
					<div id="tabLayer" style="display:none">
					<!-- TABLE '#E' : ( Tab (3) - 'B' ) (S) -->
					<table class="search" border="0" style="border-top:1px solid white;">
					<tr><td class="bg">
								<table class="height_10"><tr><td></td></tr></table>
								<table class="search" border="0" style="width:719;">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">Vessel's Daily Hire (Own & Chartered)</td>
									</tr>
									<tr><td class="height_5"></td></tr>
								</table>
								<table class="search" border="0" >
									<tr class="h23">
										<td width="100">Source Period</td>
										<td width="300" class="sm">
											<input type="text" style="width:60;" class="input1" name="f_fm_yyyymm" maxlength="6" onKeyPress="ComKeyOnlyNumber(window)" onKeyUp="moveTab(this, f_to_yyyymm);" onFocus="this.value=ComReplaceStr(this.value, '-', '');"  onBlur="addDash(this , 4);">&nbsp;&nbsp;-&nbsp;
											<input type="text" style="width:60;" class="input1" name="f_to_yyyymm" maxlength="6" onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="addDash(this , 4);">&nbsp;&nbsp;&nbsp;&nbsp;(YYYY-MM)</td>
										<td width="55">Layup</td>
										<td width="160" class="stm">
											<input type="radio" name="f_layup_flg" class="trans" value="Y" onClick="javascript:setLayup();">&nbsp;Y
											<input type="text" name="f_lyp_cost_amt" class="noact2" style="width:60;text-align:right" maxlength="6" onkeydown="onlyNumber(window);" onblur="this.value=format(this.value,'#,###');setLayup();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<!--<input type="text" name="f_lyp_cost_amt" class="noact2" style="width:60;text-align:right" maxlength="6" onblur="this.value=ComAddComma2(this.value,'#,###');setLayup();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->
											<input type="radio" name="f_layup_flg" class="trans" value="N" onClick="javascript:setLayup();" checked>&nbsp;N</td>
										<td align="right">
											<img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
											<a href="javascript:callTCO();" class="purple" style="font-weight:normal;">TC/O Hire Table</a> &nbsp;</td>
									</tr>
								</table>
								<!-- : ( Reg. ) (S) -->
								<table width="100%" id="mainTable6">
									<tr><td>
										<script language="javascript">ComSheetObject('sheet6');</script>
									</td></tr>
								</table>
								<!-- : ( Reg. ) (E) -->

								<!--  Button_Sub (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btn_create" name="btn_create">Creation</td><td class="btn2_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btn_save" name="btn_save">Save</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->

									</tr></table>
								</td></tr>
								</table>
						    	<!-- Button_Sub (E) -->

							</td>
						</tr>
					</table>
					<!-- TABLE '#E' : ( Tab (3) - 'B' ) (E) -->
					</div>

<!-- Tab5 ///////////////////////////////////////////////////////////////////////////////////////////////// -->
					<div id="tabLayer" style="display:none">
					<!-- TABLE '#E' : ( Tab (4) - 'B' ) (S) -->
					<table class="search" border="0" style="border-top:1px solid white;">
					<tr><td class="bg">
								<table class="height_10"><tr><td></td></tr></table>
								<table class="search" border="0" style="width:719;">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">Network Cost Calculation</td>
									</tr>
									<tr><td class="height_5"></td></tr>
								</table>
								<!-- : ( No. ) (S) -->
								<table width="100%" id="mainTable7">
									<tr><td>
									<script language="javascript">ComSheetObject('sheet7');</script>
									</td></tr>
								</table>
								<!-- : ( No. ) (E) -->

								<!--  Button_Sub (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btn_create" name="btn_create">Creation</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->

									</tr></table>
								</td></tr>
								</table>
						    	<!-- Button_Sub (E) -->


							</td>
						</tr>
					</table>
					<!-- TABLE '#E' : ( Tab (4) - 'B' ) (E) -->
					<!-- **************** Tab BG Box - 'B' (InSide) (E) ********************* -->
					</div>

<!-- Tab6 ///////////////////////////////////////////////////////////////////////////////////////////////// -->
					<div id="tabLayer" style="display:none">
					<!-- TABLE '#E' : ( Tab (4) - 'B' ) (S) -->
					<table class="search" border="0" style="border-top:1px solid white;">
					<tr><td class="bg">
								<table class="height_10"><tr><td></td></tr></table>
								<table class="search" border="0" style="width:719;">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">Network Cost After Ocean T/S</td>
									</tr>
									<tr><td class="height_5"></td></tr>
								</table>
								<!-- : ( No. ) (S) -->
								<table width="100%" id="mainTable8">
									<tr><td>
									<script language="javascript">ComSheetObject('sheet8');</script>
									</td></tr>
								</table>
								<!-- : ( No. ) (E) -->



						</td>
						</tr>
					</table>
					<!-- TABLE '#E' : ( Tab (4) - 'B' ) (E) -->
					<!-- **************** Tab BG Box - 'B' (InSide) (E) ********************* -->
					</div>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>