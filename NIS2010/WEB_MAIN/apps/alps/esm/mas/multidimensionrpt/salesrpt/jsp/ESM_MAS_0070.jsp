<%--
=========================================================================
'주  시 스 템 : ENIS
'서브  시스템 : Weekly Sales Report By Office 1
'프로그램 ID  : apps/enis/esm/mas/multidimensionrpt/sales/jsp/ESM_MAS_070.jsp
'프로그램 명  : Weekly Sales Report By Office 1
'프로그램개요 : Weekly Sales Report By Office 1
'작   성   자 : Park Eun Ju
'작   성   일 : 2006.11.27
=========================================================================
'수정자/수정일 :
'수정사유/내역 :
' History :
' 2008.02.22 박은주 N200802220016 MAS 조회 기간 관련 수정 요청
'                  2007년 7월 이전, 2007년 27주 이전 data 조회시 조회 불가 및 Error Message 보여줌
' 2008.02.15 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청
'                  Year, Month, Week관련 화면변경
' 2008.03.21 박은주 R200803125390 P/L 화면 보완 요청_1,2번항목
'                  Week선택시에 Month, Week를 입력할수 있도록 변경[060,062,070]
' 2008.04.07 박은주 N200804020018 MAS Report 수정 요청
'                  1. Inquiry by Customized Condition
'                   - Pop-up 화면에 연결된 table 변경 : data 조회 가능하도록 변경
'                      (첨부파일 참조)　
'                   - 화면 하단에 아래 메세지 수정 및 추가
'                      ▶ Please reset the report form - in the event that an error occurs.
'                      ▶ If you want to check all costs related to the booking, please include
'                          the BKG number when retrieving the data and double click it.
'                  2. Office Report vs QTA
'                   - 기간 표시 (타화면 참조)
'                  3. Inquiry by BKG
'                   - Cost Detail 조회시 TP/SZ를 선택하고 조회할 경우 Error 발생  : 수정 요망
' 2008.05.07 박은주 R200804296325 css 파일 참조 확인 및 수정 요청
' 2008.06.10 박은주 N200805307020 Split 01-MAS_화면 개발 및 수정
' 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 소스분리
' 2008.11.20 전윤주 N200811060003 MAS_Report 기능 개선(2)Week Display 추가
' 2008.12.08 박상희 N200811270017 STP Income/Cost Inquiry 링크 제거
'            박은주 N200811270013 STP Income/Cost Inquiry 링크 제거
' 2008.12.15 박상희 N200811270017 MAS_Office Report vs QTA 내 STP 관련 소스 수정
' 2009.02.03 박상희 N200901210013 N200901210013 Office구조 변경 관련 적용
' 2009.02.12 박상희 N200902050040  Reefer PFMC & QTA만 조회하는 Option 추가
' 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
' 2009.04.03 배진환 N200903170122 MAS_Multi-dimension report 조회권한 변경
' 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
' 2009.05.18 배진환 N200905130071 - MAS_조회 조건 입력 관련 수정
* 2009.09.29 김기식 Alps전환작업
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.05.09 최윤성 [CHM-201110694-01] MAS Report 화면 combo box validation 추가
* 2012.02.10 김종준 [CHM-201216123-01] Office Report vs QTA에서 선택 옵션에서, "Special Only"를 "Reefer Only" 옆에 추가 생성 요청 CSR
* 2012.12.14 최윤성 [CHM-201222075-01] [MAS] Account별 QTA 조회 기능 추가  - Customer 조건 추가
* 2013.06.03 성미영 [CHM-201324894] Split 01-[MAS] MAS Report내 "IAS Region " / "Bound2" 추가
* 2013.07.10 성미영 [CHM-201325516] Split 01-[MAS] Customer Segmentation 관련 변경사항 MDM DB 변경
* 2014.04.25 최성민 [CHM-201429994] [MAS] Office Report vs QTA 화면 항목 추가 (IAS Sector Sales)
* 2014.06.10 최성민 [CHM-201430587] [MAS] Office Report vs QTA 옵션 변경
=========================================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException   = null;					//
	String strErrMsg 	= "";							//
	//String successFlag 	= "";
    String userId   = "";
    String ofc_cd   = "";
    String ofc_lvl  = "";
	String prevWeek = "";
	String f_ofc_lvl1 	= "";
	String f_ofc_cd 	= "";
	String f_ofc_lvl2 	= "";

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId = account.getUsr_id();
	        ofc_cd = account.getOfc_cd();  //.getUserOffice2();
	        ofc_lvl = account.getUsr_auth_tp_cd();  //.getUserLevel();
	        f_ofc_cd = account.getOfc_cd();
		} // end else
//		N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조껀 SELHO.  1로 바꿔준다
		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;

	}catch(Exception e) {
		out.println(e.toString());
	}


%>
<html>
<head>
<title>Office Report-vs QTA</title>
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
<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_yearweek">
<input type="hidden" name="f_pre_week">
<input type="hidden" name="s_ofc_cd" value="<%=ofc_cd %>">
<input type="hidden" name="l_ofc_cd" value="<%=f_ofc_cd %>">
<input type="hidden" name="f_ofc_lvl" value="<%=ofc_lvl %>">
<input type="hidden" name="f_view_cust">
<input type="hidden" name="div_nm">
<input type="hidden" name="param_size">


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
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search" style="height:173;" width="100%">
		<tr><td class="bg" valign="top" width="100%">
					<!-- : ( Year ) (S) -->
					<table class="search_in" border="0">
						<tr class="h23" id="tr0" style="display:block;">
							<td width="32">Year</td>
							<td width="70"><input type="text" class="input1" style="width:40" name="f_year2" maxlength="4" onkeyPress="ComKeyOnlyNumber(this)" onKeyUp="ComKeyEnter('LengthNextFocus');" onChange="setPeriod1(this);changeCostYrmon(this.value);"></td>
							<td width="40">Week</td>
							<td width="50"><input  type="text"  style="width:30;" name="f_wk" maxlength="2" onkeyPress="ComKeyOnlyNumber(this);"  onBlur="this.value=ComLpad(this, 2, '0');" onKeyUp="ComKeyEnter('LengthNextFocus');" onChange="this.value=ComLpad(this, 2, '0');setPeriod1(this);"></td>
							<td class="sm"><div id="div_period1">&nbsp;</div></td>
						</tr>
					</table>
					<table class="search_in" border="0">
                         <tr class="h23" id="tr1" style="display:none;"><td colspan="5"><script language="javascript">masPeriod3_ofc();</script></td></tr>
                         <tr class="h23">
                         	<td class="gray_tit" style="color:#4361b6" style="font-size:8pt;" colspan="5">
				        	   [ by Mon - effective from July(2007) &nbsp;&nbsp;
				        	    by Week - effective from 27WK(2007) ]
                       	    </td>
                         </tr>
					</table>
					<!-- : ( Year ) (E) -->

					<table class="search_in" border="0">
					<tr><td class="line_bluedot" style="height:11;"></td></tr>
					</table>

					<!-- : ( from By View ) (S) -->
                    <table class="search_in" border="0" >
                        <tr class="h23">
                        	<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
                        	
		                            <td width="85">Profit View</td>
		                            <td width="160">
		                            	<script language="javascript">ComComboObject('f_pro_vw',1, 140 , 1 )</script>
		                            </td>
		                            <td width="75">Office View</td>
		                            <td width="130">
		                            	<script language="javascript">ComComboObject('f_ofc_vw',1, 100 , 1 )</script>
		                            </td>
		                            
		                            <td width="80" id="td_lvl1">Profit Level</td>
		                            <td width="120" id="td_lvl2">
		                            	<script language="javascript">ComComboObject('f_pro_lvl',1, 110 , 1 )</script>
		                            </td>
                        			<td width="70">Report</td>
                        			<td><select name="f_rpt_item" onChange="chgHeader();" style="width:110;">
										<option value="1" selected>Trade</option>
										<option value="2">Sub-Trade</option>
										<option value="3">Lane</option>
										<option value="4">VVD</option>
										</select>
									</td>		                            
                        			
                       			</tr>

					<tr><td class="line_bluedot" style="height:11;" colspan="9"></td></tr>
					<tr class="h23">
							<td width="90" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
							<td width="85">Office Level1</td>
							<td width="160">
								<script language="javascript">ComComboObject('f_ofc_lvl1',1, 140 , 1 )</script>
							</td>
							<td width="75">Office</td>
							<td width="130">
								<script language="javascript">ComComboObject('f_ofc_cd',1, 100 , 0 )</script>
							</td>
							<td width="80">Office Level2</td>
							<td width="120">
								<script language="javascript">ComComboObject('f_ofc_lvl2',1, 110 , 1 )</script>
							</td>
							<td width="40">&nbsp;</td>
							<td width="150">&nbsp;</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
						  <td width="80">&nbsp;</td>
						  <td width="600">
							<table border="0" style="height:15; width:590;">
		                		<tr class="h23">
		                  			<td style="padding-left:10;">
									    <input type="checkbox" class="trans" name="f_bkg_sts" value="Y">&nbsp;Waiting Booking Include&nbsp;&nbsp;&nbsp;
    									<input type="checkbox" class="trans" name="f_dir_sts" value="Y" >&nbsp;Bound Display&nbsp;&nbsp;&nbsp;
		    							<input type="checkbox" class="trans" name="f_ofc_sts" value="Y" >&nbsp;Office Display&nbsp;&nbsp;&nbsp;
				  					   <input type="checkbox" class="trans" name="f_excl_sts" value="Y">&nbsp;Excluding Sub
				  					</td>
				            	</tr>
				          	</table>
				      	  </td>
						  <td id="tr3" style="width:285;display:none">
							<table border="0" style="height:15; width:285;">
		               			<tr class="h23">
		                			<td style="width:140;">
								      	<input type="checkbox" class="trans" name="f_wk_sts" value="Y">&nbsp;Week Display&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    </td>
								    <td style="width:140;">
								      	<input type="checkbox" class="trans" name="f_r_month_sts" value="Y">&nbsp;R.Month Display
								    </td>
				            	</tr>
				            </table>
				          </td>
				          
				      	  <td>&nbsp;</td>
					   </tr>
					   
					   <tr id="tr3">
						  <td width="80">&nbsp;</td>
						  <td width="600">
							<table border="0" style="width:590;">
		                		<tr id="spcl1" class="h23">
		                  			<td style="padding-left:8; width:235;">									  
									    <table border="0" id = "spcl2">
										    <tr class="h23">
											    <td>
											    <input type="checkbox" class="trans" name="f_rf_sts" value="Y">&nbsp;Reefer Only&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											    <input type="checkbox" class="trans" name="f_sc_sts" value="Y">&nbsp;Special Only&nbsp;
											    </td>
										    </tr>
									    </table>
				  					</td>
				  					<td style="width:192;">&nbsp; </td>
				  					<td style="padding-left:10;">
				  						<table border="0">
										    <tr class="h23">
											    <td><input type="checkbox" class="trans" name="f_hul_bnd_sts" value="Y">Trade Dir. Display
											    </td>
										    </tr>
									    </table>
									    
								    </td>
				            	</tr>
				          	</table>
				      	  </td>
                         <!--  @@@ 요기 밑에  TD 추가함  -->				      	  
						  <td id="tr3" >
							<table border="0" style="width:285;">
		               			<tr class="h23">
		                			<td style="width:140;">
								      	<input type="checkbox" class="trans" name="f_ias_rgn_sts" value="Y">IAS Region Display
								    </td>
								    <td style="width:140;">
								      	<input type="checkbox" class="trans" name="f_ias_secter_sts" value="Y">IAS Sector Display
								    </td>
				            	</tr>
				            </table>
				          </td>				      	  
				      	  
				      	  
					   </tr>
					</table>
					
					<table class="search_in" border="0">
						<tr id="tr4" style="display:none">
							<td>
								<table class="search_in" border="0">
									<tr>
										<td colspan="5" class="line_bluedot" style="height:11;"></td>
									</tr>
									<tr class="h23">
										<td width="90" class="gray_tit">
											<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Customer
										</td>
										<td width="110">Core Customer</td>
										<td width="150" style="padding-left:2px;">
											<script language="javascript">ComComboObject('f_key_acct_group_cd', 1, 316, 1)</script>
										</td>						
										<td width="70">H/O Team</td>
										<td width="280" style="padding-left:2px;">
											<script language="javascript">ComComboObject('f_ofc_team_cd', 1, 80, 1)</script>
										</td>	
									</tr>
									
									<tr class="h23">
										<td></td>
										<td>Regional Customer</td>
										<td style="padding-left:2px;">
											<script language="javascript">ComComboObject('f_ra_acct_group_cd', 1, 316, 1)</script>
										</td>
										<td width="70">RHQ Team</td>
										<td width="280" style="padding-left:2px;">
											<script language="javascript">ComComboObject('f_rhq_cd', 1, 80, 1)</script>
										</td>	

										
									</tr>
									
									<tr class="h23">
										<td></td>
										<td colspan="4">
											<table class="search">
												<tr class="h23">
													<td width="160"><input type="checkbox" class="trans" name="f_otr_key_acct" value="Y">&nbsp;Core Customer</td>
													<td width="170"><input type="checkbox" class="trans" name="f_otr_regional_acct" value="Y">&nbsp;Regional Customer</td>
													<td width="420"><input type="checkbox" class="trans" name="f_gcust_sts" value="Y">&nbsp;G.Customer Display</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					
					<table class="search_in" border="0">
			            <tr id="tr2" style="display:none">
			              <td>
			                <table class="search_in" border="0">
			                  <tr>
			                    <td class="line_bluedot" style="height:11;" colspan="9"></td>
			                  </tr>
			                  <tr class="h23" >
			                    <td width="90" class="gray_tit" rowspan="3" valign="top" style="padding-top:5;"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
			                    <td width="70">Trade</td>
			                    <td width="160" style="padding-left:2;">
			                    	<script language="javascript">ComComboObject('f_trd_cd',1, 140 , 0 )</script>
			                    </td>
			                    <td width="75">Sub Trade</td>
			                    <td width="130" style="padding-left:2;">
			                    	<script language="javascript">ComComboObject('f_sub_trd_cd',1, 100 , 0 )</script>
			                    </td>
			                    <td width="80">IAS Region</td>
			                    <td width="120" style="padding-left:2;">
			                    	<script language="javascript">ComComboObject('f_ias_rgn_cd',1, 110 , 0 )</script>
			                    </td>
			                    <td width="40"></td>
			                    <td width="150">
			                    </td>
			                  </tr>
			                  <!--  @@@ 요기 밑에 한줄 추가함  -->
			                  <tr class="h23" >
			                    <td width="70">Lane</td>
			                    <td width="160" style="padding-left:2;">
			                    	<script language="javascript">ComComboObject('f_rlane_cd',1, 140 , 0 )</script>
			                    </td>
			                    <td width="75">Bound</td>
			                    <td width="130" style="padding-left:2;">
			                    	<script language="javascript">ComComboObject('f_skd_dir_cd',1, 100 , 0 )</script>
			                    </td>                    
			                    <td width="80">Trade Dir.</td>
			                    <td width="120" style="padding-left:2;">
			                    	<script language="javascript">ComComboObject('f_hul_bnd_cd',1, 110 , 0 )</script>
			                    </td>
			                    <td width="40">VVD</td>
			                    <td width="150">
			                        <input type="text" style="width:40;" maxlength="4" name="f_vsl_cd" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled">
			                        <input type="text" style="width:40;" maxlength="4" name="f_skd_voy_no" onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled">
			                        <input type="text" style="width:22;" maxlength="1" name="f_dir_cd" onKeyPress="ComKeyOnlyAlphabet('upper');" style="ime-mode:disabled">
			                    </td>                    
			                  </tr>   
			                   
			                  <!--  IAS Sector Display 전용  -->
			                  <tr class="h23" id="tr_ias_sector" style="display:none">
			                                        
			                    <td>POL</td>
								<td>
									<input type="text" style="width:117;" name="f_pol_cd" value="" maxlength="5" onKeyUp="checkLoc_onKeyUp(this, this.value);moveTab(this, f_pod_cd);" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="f_icon_search3" onClick="openLocationCode('getPOL');">
								</td>
								
			                    <td>POD</td>
								<td>
									<input type="text" style="width:77" name="f_pod_cd" value="" maxlength="5" onKeyUp="checkLoc_onKeyUp(this, this.value);" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="f_icon_search3" onClick="openLocationCode('getPOD');">
								</td> 
																
			                    <td>Main/Sector</td>
								<td><select name="f_mn_sctr"  style="width:110;">
										<option value="" selected>All</option>
										<option value="M">Main</option>
										<option value="S">Sector</option>
										</select>
									</td>	
			                    <td colspan="2">&nbsp;</td>              
			                  </tr>                    
			                  
			                </table>
			              </td>
			            </tr>
					</table>
					<!-- : ( from By View ) (E) -->
				</td>
				</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>


		<!-- **************** Tab BG Box - 'B' (InSide) (S) ********************* -->
		<!-- TABLE '#E' : ( Tab ) (S) -->
		<table class="tab">
			<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- TABLE '#E' : ( Tab ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

					<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s"><div id="div_label1">Weekly Sales Report</div></td>
							<td class="gray"></td>
							<td align="right">
								<!--<a href="javascript:openSTPIncome();" class="purple">STP Income/Cost Inquiry</a>
							--></td> 
						</tr>
					</table>



<!-- Tab1 ///////////////////////////////////////////////////////////////////////////////////////////////// -->
					<div id="tabLayer" style="display:inline; ">
					<table width="100%" class="search">
						<tr><td class="gray" style="text-align:left; padding:2,5;"><div id="div_title"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9"> VS Pre. Week</div></td>
							<td width="70" class="gray" class="title_h">(1USD, TEU)</td>
							<td width="20" class="gray">
								<div id="div_toggle_prev1" style="position:relative; left:0px; top:px; display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_prev1" alt="Zoom in(+)">
								</div>
								<div id="div_toggle_next1" style="position:relative; left:0px; top:px; display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_next1" alt="Zoom out(-)">
								</div>
							</td>
						</tr>
						<tr><td class="height_2"></td></tr>
					</table>
					<!-- TABLE '#E' : ( 1 - Grid Table ) (S) -->
					<table class="search" border="0">
						<tr>
							<td width="12%" valign="bottom">
								<table width="100%" id="mainTable">
									<tr>
										<td>
										<div id="div_sheet1"><script language="javascript">ComSheetObject('sheet1');</script></div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

					<table class="height_10"><tr><td></td></tr></table>
					<!-- TABLE '#E' : ( 1 - Grid Table ) (E) -->
					<table width="100%" class="search">
						<tr><td class="gray" style="text-align:left; padding:5,5;"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9"> BKG CM Variance Factor</td>
							<td width="20" class="gray">
								<div id="div_toggle_prev2" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_prev2" alt="Zoom in(+)">
								</div>
								<div id="div_toggle_next2" style="position:relative; left:0px; top:px; display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_next2" alt="Zoom out(-)">
								</div>
							</td>
						</tr>
					</table>
					<!-- TABLE '#E' : ( 2 - Grid Table ) (S) -->
					<table class="search" border="0">
						<tr>
							<td width="100%" valign="bottom">
								<table width="100%" id="mainTable">
									<tr>
										<td>
										<div id="div_sheet2"><script language="javascript">ComSheetObject('sheet2');</script></div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td class="sm" align="right"><img src="/hanjin/img/ico_star.gif" border="0" hspace="3" align="absmiddle">CPB - Cost Per Box &nbsp;</td>
						</tr>
					</table>
					<!-- table class="search" class="height_10"><tr><td></td></tr></table -->
					</div>

<!-- Tab2 ///////////////////////////////////////////////////////////////////////////////////////////////// -->
					<div id="tabLayer" style="display:none">
					<!-- TABLE '#E' : ( Tab (2) - 'B' ) (S) -->

					<!-- TABLE '#E' : ( 2 - Grid Table ) (E) -->
					<!-- table class="line_bluedot"><tr><td></td></tr></table -->
					<table id="orgSht1" width="100%" class="search">
						<tr>
							<td class="gray" style="text-align:left; padding:2,5;"><div id="div_title2"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9"> VS QTA</div></td>
							<td width="20" class="gray">
								<div id="div_toggle_prev3" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_prev3" alt="Zoom in(+)">
								</div>
								<div id="div_toggle_next3" style="position:relative; left:0px; top:px; display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_next3" alt="Zoom out(-)">
								</div>
							</td>
						</tr>
						<tr><td class="height_2"></td></tr>
					</table>
					<!-- TABLE '#E' : ( 3 - Grid Table ) (S) -->
					<table id="orgSht2" class="search" border="0">
						<tr>
							<td width="12%" valign="bottom">
								<table width="100%" id="mainTable">
									<tr>
										<td>
										<div id="div_sheet3"><script language="javascript">ComSheetObject('sheet3');</script></div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table class="height_10"><tr><td></td></tr></table>
					<!-- TABLE '#E' : ( 3 - Grid Table ) (E) -->
					<table id="orgSht3" width="100%" class="search">
						<tr><td class="gray" style="text-align:left; padding:5,5;"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9"> BKG CM Variance Factor</td>
							<td width="20" class="gray">
								<div id="div_toggle_prev4" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_prev4" alt="Zoom in(+)">
								</div>
								<div id="div_toggle_next4" style="position:relative; left:0px; top:px; display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_next4" alt="Zoom out(-)">
								</div>
							</td>
						</tr>
					</table>


					<!-- TABLE '#E' : ( 4 - Grid Table ) (S) -->
					<table id="orgSht4" class="search" border="0">
						<tr>
							<td width="100%" valign="bottom">
								<!-- : ( Grid ) (S) -->
								<table width="100%" id="mainTable">
									<tr>
										<td>
										<div id="div_sheet4"><script language="javascript">ComSheetObject('sheet4');</script></div>
										</td>
									</tr>
								</table>
								<!-- : ( Grid ) (E) -->
							</td>
						</tr>
					</table>
					
					<table id="copySht1" width="100%" class="search">
						<tr>
							<td class="gray" style="text-align:left; padding:2,5;"><div id="div_title2"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9"> VS QTA</div></td>
							<td width="20" class="gray">
								<div id="div_toggle_prev5" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_prev5" alt="Zoom in(+)">
								</div>
								<div id="div_toggle_next5" style="position:relative; left:0px; top:px; display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_next5" alt="Zoom out(-)">
								</div>
							</td>
						</tr>
						<tr><td class="height_2"></td></tr>
					</table>
					<!-- TABLE '#E' : ( 3 - Grid Table ) (S) -->
					<table id="copySht2" class="search" border="0">
						<tr>
							<td width="12%" valign="bottom">
								<table width="100%" id="mainTable">
									<tr>
										<td>
										<div id="div_sheet5"><script language="javascript">ComSheetObject('sheet5');</script></div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table class="height_10"><tr><td></td></tr></table>
					<!-- TABLE '#E' : ( 3 - Grid Table ) (E) -->
					<table id="copySht3" width="100%" class="search">
						<tr><td class="gray" style="text-align:left; padding:5,5;"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9"> BKG CM Variance Factor</td>
							<td width="20" class="gray">
								<div id="div_toggle_prev6" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_prev6" alt="Zoom in(+)">
								</div>
								<div id="div_toggle_next6" style="position:relative; left:0px; top:px; display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_next6" alt="Zoom out(-)">
								</div>
							</td>
						</tr>
					</table>


					<!-- TABLE '#E' : ( 4 - Grid Table ) (S) -->
					<table id="copySht4" class="search" border="0">
						<tr>
							<td width="100%" valign="bottom">
								<!-- : ( Grid ) (S) -->
								<table width="100%" id="mainTable">
									<tr>
										<td>
										<div id="div_sheet6"><script language="javascript">ComSheetObject('sheet6');</script></div>
										</td>
									</tr>
								</table>
								<!-- : ( Grid ) (E) -->
							</td>
						</tr>
					</table>
					<!-- TABLE '#E' : ( 4 - Grid Table ) (E) -->
					</div>

		
		            <!--  Button_Sub (S) -->
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
		                            <td class="btn2" id="btn_downexcel2" name="btn_downexcel2">Down Excel</td>
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


					<table class="search" border="0">
					<tr><td height="18"><img src="/hanjin/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
					<tr><td style="padding-left:11;" class="sm">
						<!-- img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
						CM for H/O = Total Revenue - Full Cost - EMU - Agt Comm - Own Vol Activity Cost - Oth Vol Activity Cost<br>
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
						BKG CM for Non-H/O = Total Revenue - Full Cost - EMU - Agt Comm - Own Vol Activity Cost - STP Cost<br>
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
						Branch CM for Non-H/O = BKG CM + STP Rev - Oth Vol Activity Cost -->

						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
						BKG CM = Total Revenue - Full Cost - EMU - Agt Comm - Own Vol Activity Cost - Oth Vol Activity Cost<br>
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
						Branch CM for Non-H/O = BKG CM + STP Profit<br>
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
						STP Profit = Balance(by SVC OFC) + Balance(CONT OFC)<br>
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
						Balance(by SVC OFC) = STP Revenue - Oth-Vol Activity Cost(by SVC OFC)<br>
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
						Balance(CONT OFC) = Oth-Vol Activity Cost(CONT OFC)	 - STP Cost</td></tr>
					</table>


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


