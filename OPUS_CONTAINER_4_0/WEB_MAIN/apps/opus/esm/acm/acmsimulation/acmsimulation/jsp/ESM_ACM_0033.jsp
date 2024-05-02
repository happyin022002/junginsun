<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_ACM_0033.jsp
*@FileTitle  : Agent Commission Mass Simulation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0033Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMCalculation.AGNCommCalculation");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0033Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>

<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<input type="hidden" name="vvd_cd"><!-- Multi VVD -->
<input type="hidden" name="ac_tp_cd"><!-- Commission Account -->
<input type="hidden" name="agmt_no1"><!-- Multi AGMT No.1 (Applied) -->
<input type="hidden" name="agmt_no2"><!-- Multi AGMT No.2 (Should have been applied) -->
<input type="hidden" name="ac_sts_cd"><!-- Commission Status -->
<input type="hidden" name="ac_sts_cd2"><!-- Commission Status중 Interfaced를 클릭했는지 여부 -->
<input type="hidden" name="ofc_cd"><!-- Multi Office -->
<input type="hidden" name="loc_cd"><!-- Multi Loc -->
<input type="hidden" name="sim_flg" value="M">
<input type="hidden" name="excel_flg">


<div class="page_title_area clear ">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_grid wFit">
		<h3 class="title_design">Search Condition</h3>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_search" id="btn_search">Simulation Target Search</button>
		</div>

		<div class="layout_wrap" style="width:1102px;">
		    <div class="layout_vertical_2">
				<div class= "opus_design_inquiry">
					<table>
						<colgroup>
							<col width="50"/>
							<col width="*" />
						</colgroup>	
						<tbody>	
							<tr>
		                    	<th>Date</th>
		                     	<td><%=JSPUtil.getCodeCombo("date_div", "", "tabindex='1' style='width:125px;'", "CD03025", 0, "")%><!-- 
		                      	 --><input name="date_fm" id="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="2">~&nbsp;<!-- 
		                      	 --><input name="date_to" id="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="3"><!--
		                      	 --><button type="button" class="calendar" name="btn_calendar" id="btn_calendar" ></button>
		                    	</td>
		                	</tr>
			            </tbody>
		            </table>
	            
	            	<table>
						<tbody>	
							<colgroup>
								<col width="50px">
								<col width="100px">
								<col width="135px">
								<col width="*">
							</colgroup>
			            	<tr>
			                	<th width="45px" title="Vessel Voyage Direction">VVD</th>
			                    <td><%=JSPUtil.getCodeCombo("vvd_div", "", "tabindex='7' style='width:125px;'", "CD03024", 0, "")%></td>
			                    <!-- Memo Sheet (S) -->
			                    <td id="memo_sheet1_td"><div id="memo_sheet1_div"><script type="text/javascript">ComSheetObject("memo_sheet1");</script></div></td>
			                    <!-- Memo Sheet (E) -->
								<td><button type="button" class="btn_etc" name="btn2_vvd_cd" id="btn2_vvd_cd" >Multi VVD</button></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class= "opus_design_inquiry">
					<table>
						<tbody>	
							<colgroup>
								<col width="40px">
								<col width="40px">
								<col width="40px">
								<col width="40px">
								<col width="40px">
								<col width="60px">
								<col width="60px">
								<col width="*">
							</colgroup>
							<tr style="height:33px;"><th colspan="8" style="text-align:left">Commission Account</th></tr>
		               		<tr>
		                 		<td class="pad_left_8" colspan="4"><!-- 
		                 		 --><input type="checkbox" name="comm_stnd_cost_div" id="1" class="trans" value="G"><label for="1">General</label><!--
		                 		 --><input type="checkbox" name="comm_stnd_cost_div" id="2" class="trans" value="H"><label for="2">CHF</label><!--
		                 		 --><input type="checkbox" name="comm_stnd_cost_div" id="6" class="trans" value="N"><label for="6">CSF</label><!--
		                 		 --><input type="checkbox" name="comm_stnd_cost_div" id="7" class="trans" value="R"><label for="7">RCSF</label><!--
		                 		 --><input type="checkbox" name="comm_stnd_cost_div" id="3" class="trans" value="S"><label for="3">T/S</label><!--
		                 		 --><input type="checkbox" name="comm_stnd_cost_div" id="4" class="trans" value="K"><label for="4">Brokerage</label></th><!--
		                 		 --><input type="checkbox" name="comm_stnd_cost_div" id="5" class="trans" value="C"><label for = "5">Cross Booking</label></th>
		                 		</td>
		                 		
		               		</tr>							
		              	</tbody>
					</table>
				</div>
				<div class= "opus_design_inquiry">	
					<table>
						<tbody>	
							<colgroup>
								<col width="182px">
								<col width="135px">
								<col width="*">
							</colgroup>
							<tr style="height:33px;"><th colspan="3" style="text-align:left">Agreement Condition</th></tr>
				            <tr>
				                <td class="pad_left_8"><input type="radio" name="agmt_div" id="agmt_div_01" class="trans" value="A"><label for = "agmt_div_01">Applied</label></td>
				                <td id="memo_sheet2_td"><div id="memo_sheet2_div"><script type="text/javascript">ComSheetObject("memo_sheet2");</script></div></td>
						  		<td><button type="button" class="btn_etc" name="btn2_agmt_no1" id="btn2_agmt_no1" >Multi AGMT No.</button></td>
							</tr>
						</tbody>
					</table>  
					<table>
						<tbody>	
							<colgroup>
								<col width="182px">
								<col width="135px">
								<col width="*" >
							</colgroup>	
							<tr>              
			                    <td class="pad_left_8"><input type="radio" name="agmt_div" id="agmt_div_02" class="trans" checked value="S"><label for = "agmt_div_02">Should have been applied</label></td>
			                    <td id="memo_sheet3_td"><div id="memo_sheet3_div"><script type="text/javascript">ComSheetObject("memo_sheet3");</script></div></td>
								<td><button type="button" class="btn_etc" name="btn2_agmt_no2" id="btn2_agmt_no2" >Multi AGMT No.</button></td>  
							</tr>
						</tbody>
					</table>
				</div>
			</div>				
			<div class="layout_vertical_2" >   
				<div class= "opus_design_inquiry">
					<table>
						<colgroup>
							<col width="54px">
							<col width="113px">
							<col width="120px">
							<col width="90px">
							<col width="50px">
							<col width="*">
						</colgroup>
						<tbody>	
							<tr style="height:33px;"><th colspan="6" style="text-align:left">Commission Status</th></tr>
			                <tr>
			                      <td class="pad_left_8" style="text-align:left;"><input type="checkbox" name="ac_sts_div" id="ac_sts_div_01" class="trans"><label for = "ac_sts_div_01">All</label></td><!--
			                      --><td style="text-align:left;"><input type="checkbox" name="ac_sts_div" id="ac_sts_div_02" class="trans" value="CS,CN"><label for = "ac_sts_div_02">Calculated</label></td><!--
			                      --><td style="text-align:left;"><input type="checkbox" name="ac_sts_div" id="ac_sts_div_03" class="trans" value="CE"><label for = "ac_sts_div_03">Calculation Error</label></td><!--
			                      --><td style="text-align:left;"><input type="checkbox" name="ac_sts_div" id="ac_sts_div_04" class="trans" value="RS"><label for = "ac_sts_div_04">Requested</label></td><!--
			                      --><td style="text-align:left;"><input type="checkbox" name="ac_sts_div" id="ac_sts_div_05" class="trans" value="CB"><label for = "ac_sts_div_05">Cross Booking</label></td><!--
			                      --><td></td>
			                 </tr>
			                 <tr>
			                	 <td class="pad_left_8" style="text-align:left;"><input type="checkbox" name="ac_sts_div" id="ac_sts_div_06" class="trans" value="AS"><label for = "ac_sts_div_06">Audited</label></td><!--
			                      --><td style="text-align:left;"><input type="checkbox" name="ac_sts_div" id="ac_sts_div_07" class="trans" value="PS"><label for = "ac_sts_div_07">Approve</label></td><!--
			                      --><td style="text-align:left;"><input type="checkbox" name="ac_sts_div" id="ac_sts_div_08" class="trans" value="IF"><label for = "ac_sts_div_08">Interface</label></td><!--
			                      --><td style="text-align:left;"><input type="checkbox" name="ac_sts_div" id="ac_sts_div_09" class="trans" value="RR,AR,PR"><label for = "ac_sts_div_09">Rejected</label></td><!--
			                      --><td colspan="2"></td>
			                 </tr>
		                 </tbody>
		            </table>
				</div>
				<div class= "opus_design_inquiry">
					<table>
						<tbody>	
							<colgroup>
								<col width="30px"/>
								<col width="100px"/>
								<col width="135px"/>
								<col width="*" />
							</colgroup>
			                <tr>
			                    <th>Office</th>
			                    <td><%=JSPUtil.getCodeCombo("ofc_div", "", "tabindex='4' caption='Office' style='width:100px;'", "CD03036", 0, " ")%><%=JSPUtil.getCodeCombo("port_div", "", "tabindex='4'  caption='Route' style='width:70px;'", "CD01773", 0, " ")%></td>
			                    <td id="memo_sheet4_td"><div id="memo_sheet4_div"><script type="text/javascript">ComSheetObject("memo_sheet4");</script></div></td>
								<td><button type="button" class="btn_etc" name="btn2_ofc_cd" id="btn2_ofc_cd" >Multi Office</button></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class= "opus_design_inquiry">
					<table>
						<tbody>
							<colgroup>
								<col width="30px">
								<col width="50px">
								<col width="50px">
								<col width="50px">
								<col width="50px">
								<col width="50px">
								<col width="135px">
								<col width="*">
							</colgroup>
							<tr style="height:33px;"><th colspan="8" style="text-align:left">Route & Bound</th></tr>
			                <tr>
			                  <th>Route</th>
			                  <td><input type="radio" name="route_div" id="r_1" class="trans" value="POR"><label for = "r_1">POR</label></td><!-- 
			                   --><td><input type="radio" name="route_div" id="r_2" class="trans" value="POL"><label for = "r_2">POL</label></td><!--
			                   --><td><input type="radio" name="route_div" id="r_3" class="trans" value="POD"><label for = "r_3">POD</label></td><!--
			                   --><td><input type="radio" name="route_div" id="r_4" class="trans" value="DEL"><label for = "r_4">DEL</label></td><!--
			                   --><td><input type="radio" name="route_div" id="r_5" class="trans" value="TSP"><label for = "r_5">T/S Port</label></td><!--
			                   --><td id="memo_sheet5_td"><div id="memo_sheet5_div"><script type="text/javascript">ComSheetObject("memo_sheet5");</script></div></td><!--
							   --><td><button type="button" class="btn_etc" name="btn2_loc_cd" id="btn2_loc_cd" >Multi Loc</button></td> 
			                </tr>
			            </tbody>
			        </table>
					<table>
						<colgroup>
							<col width="100">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
			                  <th>Commission Bound</th>
			                  <td> <%=JSPUtil.getCodeCombo("io_bnd_cd", "", "tabindex='4' style='width:100px;'", "CD03037", 0, "")%></td>
			                </tr>
						 </tbody>
					</table>
				</div>
			</div>
		</div>
		
		<!-- <table>
			<tr><td align="right"><button type="button" id="btn_search" name="btn_search" class="btn_etc">Simulation Target Search</button></td></tr>
			<tr class="line_bluedot"><td></td></tr>
		</table> -->
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<div class="opus_design_grid wFit">
			<h3 class="title_design">Batch Condition</h3>
			
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_chk_sts" id="btn_chk_sts">Check Batch Status</button>
				<button type="button" class="btn_normal" name="btn_start_clc" id="btn_start_clc">Start Simulation</button>
			</div>
			<div class= "opus_design_inquiry wFit">
				<table>
					<tbody>
						<colgroup>
							<col width="110"/>
							<col width="213"/>
							<col width="165"/>
							<col width="*"/>
					    </colgroup>	
						<tr>
							<th>Total Target Bookings</th>
							<td><input name="ttl_bkg" type="text" tabindex="11" class="input2" style="width:120px; text-align:right;" readonly="" id="ttl_bkg"/><!--
							--><button type="button" id="btn2_bkg_expt" name="btn2_bkg_expt" class="btn_etc">BKG Export</button></td>
							<th>Simulation Number</th>
							<td><input name="sml_no1" type="text" tabindex="12" class="input2" style="width:120px; text-align:right;" readonly="" id="sml_no1" /></td>
						</tr>
						<tr>
							<th>Calculation Remark</th>
							<td colspan="4"><input name="clc_rmk" type="text" maxlength="500" caption="Calculation Remark" class="input1" style="width:500px; ime-mode:disabled;" tabindex="15" id="clc_rmk" /></td>
						</tr>	
					</tbody>
				</table>	
			</div>
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<div class="opus_design_grid wFit">
			<h3 class="title_design">Simulation Result</h3>	
			<table>
				<tbody>
					<colgroup>
						<col width="130"/>
						<col width="*"/>
				    </colgroup>			    
					<tr>
						<th>Simulation Number</th>
						<td><input name="sim_no" type="text" tabindex="16" class="input2" style="width:120px; text-align:right;" readonly="" id="sim_no" /><!--
		                       --><button type="button" id="btn_sml_popup" name="btn_sml_popup" class="input_seach_btn"></button><!--
							--><button type="button" id="btn2_downexcel" name="btn2_downexcel" class="btn_etc">Down Excel</button>
						</td>
		
					</tr>
				</tbody>
			</table>		
		</div>
	</div>

</div>
<!-- opus_design_inquiry(E) -->
<!-- 개발자 작업 끝 -->
</form>