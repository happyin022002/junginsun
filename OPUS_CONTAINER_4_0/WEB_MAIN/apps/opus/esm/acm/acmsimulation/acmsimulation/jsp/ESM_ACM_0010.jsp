<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0010.jsp
*@FileTitle  :  Agent Commission Simulation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0010Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수
  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";
  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMSimulation.ACMSimulation");
  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0010Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
  } catch(Exception e) {
    out.println(e.toString());
  }
%>

<script type="text/javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- 개발자 작업 -->
<input type="hidden" name="vvd_cd" id="vvd_cd"><!-- Multi VVD -->
<input type="hidden" name="bl_no" id="bl_no"><!-- Multi B/L No -->
<input type="hidden" name="agmt_no" id="agmt_no"><!-- Multi AGMT No. -->
<input type="hidden" name="sim_flg" value="S">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_simulation" id="btn_simulation" >Start Simulation</button>
		</div>
		<!-- opus_design_btn(E) -->	
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<h3  class="title_design">Target Search Condition</h3>
	<div class= "opus_design_inquiry wFit">
	      <table>
			<tbody>
				<colgroup>
					<col width="50">
					<col width="120">
					<col width="70">
					<col width="214">
					<col width="50">
					<col width="100">
					<col width="96">
					<col width="*">
				</colgroup>
					<tr>
      					<th>Office</th>
		                 <td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:100px;" tabindex="1"></select></td>
		                 <th>Sub Office</th>
		                 <td><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width: 100px;" tabindex="2"></select></td>
		                 <!--
			    				 <th>Office</th>
			                     <td><select name="ar_ofc_cd" id="agn_cd" caption="Office" class="input1" style="width:125px;" tabindex="2"></select></td>
		                 -->
	                     <th>Commission Status</th>
		                 <td><%=JSPUtil.getCodeCombo("ac_sts_cd", "", "tabindex='3' style='width:135px;'", "CD03039", 0, "")%></td>
              			 <th>Date</th>
                         <td> <%=JSPUtil.getCodeCombo("date_div", "", "tabindex='4' style='width:135px;'", "CD03025", 0, "")%><!-- 
                       	 	 --><input name="date_fm" id="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5">~  <!-- 
                        	 --><input name="date_to" id="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6"><!-- 
                        	 --><button type="button" class="calendar" name="btn_calendar" id="btn_calendar" ></button>
                         </td>
	               </tr>
	         </tbody>
	       </table>
	       
	       <table>
				<colgroup>
					<col width="10">
					<col width="50">
					<col width="150">
					<col width="223">
					<col width="105">
					<col width="60">
					<col width="124">
					<col width="117">
					<col width="*">
				</colgroup>
				 <tbody>
	               <tr>
	               		<td></td>
	                    <td><%=JSPUtil.getCodeCombo("vvd_div", "", "tabindex='7' style='width:75px; font-weight:bold; color:#313131;'", "CD03024", 0, "")%></td>
	                    <!-- Memo Sheet (S) -->
	                    <td id="memo_sheet1_td">
	                      <div id="memo_sheet1_div">
	                      	<script type="text/javascript">ComSheetObject("memo_sheet1");</script>
	                      </div>
	                    </td>
	                    <!-- Memo Sheet (E) -->
					    <td><button type="button" class="btn_etc" name="btn2_vvd_cd" id="btn2_vvd_cd" >Multi VVD</button></td>
					    <th>B/L No</th>
                        <!-- Memo Sheet (S) -->
                        <td id="memo_sheet2_td"  style="width:132px;" >
	                        <div id="memo_sheet2_div">
	                              <span><script type="text/javascript">ComSheetObject("memo_sheet2");</script></span>
	                        </div>
                        </td>
                        <!-- Memo Sheet (E) -->
					    <td><button type="button" class="btn_etc" name="btn2_bl_no" id="btn2_bl_no" >Multi B/L No</button></td>
				        <th>Simulation No.</th>
                        <td><input name="sim_no" id="sim_no" type="text" dataformat="engup" maxlength="20" style="width:94px;" tabindex="8"><!-- 
                     		--><button type="button" class="input_seach_btn" name="btn_smlt_popup" id="btn_smlt_popup"></button>
                        </td>
					 </tr>
	      		 </tbody>
			</table>                     

				<table>
				<tbody>
					<colgroup>
						<col width="185">
						<col width="18">
						<col width="200">
						<col width="87">
						<col width="80">
						<col width="*">
					</colgroup> 
				          <tr>
				               <th>Display bookings before BDR</th>
				               <td><input name="bdr_flg" id="bdr_flg" type="checkbox" class="trans" tabindex="11" value="Y"></td>
				               <th>Display Advanced Bookings</th>
				               <td><input name="bkg_sts_cd" id="bkg_sts_cd" type="checkbox" class="trans" tabindex="12" value="A"></td>
				               <th>Select</th>
								<td colspan="7"><input name="slct_start" id="slct_start" type="text" dataformat="int" style="width:40px;" maxlength="5"  tabindex="9">~  
								<input name="slct_end" id="slct_end" type="text" dataformat="int" style="width:40px;" maxlength="5" tabindex="10"> 
								<button type="button" class="btn_etc" name="btn2_check" id="btn2_check" >Check</button><button type="button" class="btn_etc" name="btn2_uncheck" id="btn2_uncheck" >Uncheck</button></td>
						  </tr> 
		             </tbody>
				</table>
		 </div>
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody> 
					<colgroup>
						<col width="125">
						<col width="*">
					</colgroup>
		 	 		<tr>
		                <th>Simulation Remark</th>
		                <td><input name="sim_rmk" id="sim_rmk" type="text" maxlength="100" class="input1" style="width:290px; ime-mode:disabled;" tabindex="13"></td>
		              </tr>
		        </tbody>
			</table>
		</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
    <div class="opus_design_tab" >
		<script type="text/javascript">ComTabObject("tab1")</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer">
   		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="tab1btn_downexcel" id="tab1btn_downexcel">Down Excel</button>
		</div>
		<!--     	 <h3 class="title_design">Selected Agreement</h3> -->
    	<script type="text/javascript">ComSheetObject('tab1sheet1');</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:none">
   		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="tab2btn_downexcel" id="tab2btn_downexcel">Down Excel</button>
		</div>
		<!--     	 <h3 class="title_design">Selected Agreement</h3> -->
    	 <script type="text/javascript">ComSheetObject('tab2sheet1');</script>
	</div>
</div>
</form>