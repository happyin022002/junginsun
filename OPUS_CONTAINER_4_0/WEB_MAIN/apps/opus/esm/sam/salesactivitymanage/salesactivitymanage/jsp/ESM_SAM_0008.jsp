<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0008.jsp
*@FileTitle  : Sales Activity Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event.EsmSam0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSam0008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsrSrepCd		= "";
	String pSrep_cd			= "";
	String pCus_cd			= "";
	String pAct_no			= "";

	Logger log = Logger.getLogger("com.clt.apps.SalesActivityManage.SalesActivityManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsrSrepCd = account.getSrep_cd();

		event = (EsmSam0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		// pSrep_cd = JSPUtil.getParameter(request, "srep_cd");
		pCus_cd  = JSPUtil.getParameter(request, "cust_cd");
		pAct_no  = JSPUtil.getParameter(request, "sls_act_seq");
		pSrep_cd  = JSPUtil.getParameter(request, "srep_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}

	// 달력에 오늘 날짜를 default로 보여주기 위해 현재 날짜를 받아오는 변수 선언
	String currentDate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="now_date" id="now_date" value="<%=currentDate%>">
<input type="hidden" name="user_name" id="user_name" value="<%=strUsr_nm%>">
<input type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="in_usr_srep_cd" id="in_usr_srep_cd" value="<%=strUsrSrepCd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50"/>
				<col width="150"/>
				<col width="50"/>
				<col width="*"/>				
			</colgroup> 
			<tr>
				<th>Customer</th>
                <td><input name="cust_cd" id="cust_cd" type="text" style="width:70px;" class="input1" value="<%=pCus_cd%>" maxlength="8" dataformat="engup"><input name="cust_lgl_eng_nm" id="cust_lgl_eng_nm" type="text" style="width:130px;" class="input2" value="" readOnly><button type="button" id="btn_ComEns041Pop" name="btn_ComEns041Pop" class="input_seach_btn"></button></td>
                <th>Activity</th>
                <td><input name="sls_act_seq" id="sls_act_seq" type="text" style="width:70px;" class="input1" value="<%=pAct_no%>" maxlength="8" dataformat="engup"><button type="button" id="btn_act" name="btn_act" class="input_seach_btn"></button></td>
			</tr>
			<tr>
				<!-- 2014.07.31 김용습 - Rep뒤에 . 붙임, width 조정 -->
				<th>Sales Rep.</th>
       	        <td><input name="srep_cd" id="srep_cd" type="text" style="width:50px;" dataformat="engup" class="input1" value="<%=pSrep_cd%>"><input name="srep_nm" type="text" style="width:179px;" class="input2" readOnly></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<div  class="opus_design_inquiry">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap ">
			    <!-- <div class="layout_vertical_2"> -->
			    <!-- 2014.08.01 김용습 - 레이아웃 정렬을 위해 table 및 colgroup 추가 -->
			    <table>
			    <colgroup>
				 <col width="800"/>
				 <col width="30"/>				
				</colgroup>
			     <tr>
			      <td>
					<table>
						<colgroup>
							<col width="100"/>
							<col width="310"/>
							<col width="50"/>
							<col width="100"/>
							<col width="50"/>
							<col width="*" />				
						</colgroup>
						<tr>
							<th>Contact Person</th>
							<td><input name="cntc_pson_nm" type="text" style="width:220px;" class="input" value="" id="cntc_pson_nm" /> </td>
							<th>Class</th>
							<td><script type="text/javascript">ComComboObject('sls_rpt_clss_cd', 1, 100, 1, 0 ,0 ,false)</script></td>
							<th>Visit Date </th>
							<td><input name="sls_act_act_dt" type="text" style="width:73px;" class="input1" value="<%=currentDate%>" dataformat="ymd" maxlength="10" id="sls_act_act_dt" /><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button>
						 </tr>
				 	</table>
				 	<table>
					 	<colgroup>
							<col width="100"/>
							<col width="*" />				
						</colgroup>
						 <tr>
							 <th>Summary</th>
							 <!-- 2014.07.31 김용습 - width 변경 -->
							 <td><input name="sls_rpt_smry_desc" type="text" style="width:628px;" class="input" value="" id="sls_rpt_smry_desc" /> </td>
						 </tr>
			  		</table>
				 	<table>
					 	<colgroup>
							<col width="100"/>
							<col width="*" />				
						</colgroup>
						 <tr>
							  <th>Problem</th>
							  <td>
									<select name="prb_clss_cd" id="prb_clss_cd" class="input" style="width:80px;">
										<option value="A" >A</option>
										<option value="B" selected>B</option>
										<option value="C" >C</option>
										<option value="D">D</option>
									</select>
									<!-- 2014.07.31 김용습 - 하기 textarea를 하나의 td를 더 생성해 그쪽으로 이동 -->
									<!-- <textarea name="prb_desc" id="prb_desc" style="width:536px"></textarea> -->
								</td>
								<td>
									<!-- 2014.07.31 김용습 - width 변경 -->
									<div>
										<textarea name="prb_desc" id="prb_desc" style="width:532px"></textarea>
									</div>
								</td>
					   </tr>
				   	</table>
				 	<table>
					 	<colgroup>
							<col width="100"/>
							<col width="*" />				
						</colgroup>
					   	<tr>
							<th>Suggestion</th>
							<td>
								<select name="sgs_clss_cd" id="sgs_clss_cd" class="input" style="width:80px;">
								<option value="A" >A</option>
								<option value="B" selected>B</option>
								<option value="C" >C</option>
								<option value="D">D</option>
								</select>
								<!-- 2014.07.31 김용습 - 하기 textarea를 하나의 td를 더 생성해 그쪽으로 이동 -->
								<!-- <textarea name="sgs_desc" id="sgs_desc" style="width:536px"></textarea> -->
							</td>
							<td>
								<!-- 2014.07.31 김용습 - width 변경 -->
								<div>
									<textarea name="sgs_desc" id="sgs_desc" style="width:532px"></textarea>
								</div>
							</td>
						</tr>
					</table>
				 	<table>
					 	<colgroup>
							<col width="100"/>
							<col width="*" />				
						</colgroup>
						<tr>
							<th>Next Plan</th>
							<td>
								<select name="nxt_pln_clss_cd" id="nxt_pln_clss_cd" class="input" style="width:80px;">
									<option value="A" >A</option>
									<option value="B" selected>B</option>
									<option value="C" >C</option>
									<option value="D">D</option>
								</select>
								<!-- 2014.07.31 김용습 - 하기 textarea를 하나의 td를 더 생성해 그쪽으로 이동 -->
								<!-- <textarea name="nxt_pln_desc" id="nxt_pln_desc" style="width:536px"></textarea> -->
							</td>
							<td>
								<!-- 2014.07.31 김용습 - width 변경 -->
								<div>
									<textarea name="nxt_pln_desc" id="nxt_pln_desc" style="width:532px"></textarea>
								</div>								
							</td>
						</tr>
					</table>
				 	<table>
					 	<colgroup>
							<col width="100"/>
							<col width="300"/>
							<col width="50"/>
							<col width="*" />				
						</colgroup>
						<tr>
							<th>Visit Place</th>
							<td><input name="vst_plc_ctnt" type="text" style="width:223px;" class="input" value="" id="vst_plc_ctnt" /> </td>
							<th>Give Away</th>
							<td><input name="sls_prmt_desc" type="text" style="width:266px;" class="input" value="" id="sls_prmt_desc" /> </td>
						</tr>
					</table>
					<td>
					<td>
						<table>
			       		<tr>
							<th style="float: left;">Areas</th>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="Asia" class="trans" id="biz_area_cd" />Asia</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="N.Europe" class="trans" id="biz_area_cd" />N.Europe</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="Med" class="trans" id="biz_area_cd" />Med</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="M.East" class="trans" id="biz_area_cd" />M.East</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="S.America" class="trans" id="biz_area_cd" />S.America</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="N.America" class="trans" id="biz_area_cd" />N.America</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="IPBC" class="trans" id="biz_area_cd" />IPBC</td>
						</tr>              
				   </table>	
					 </td>
					 </tr>
					</table>
			    <!-- </div> -->
			    
			    <!-- 2014.08.01 김용습 - 화면을 줄일 시 해당 부분이 왼쪽 레이아웃 부분과 겹치는 문제가 발생하여 왼쪽 레이아웃에 별도의 공간을 만들어 넣음 -->
			    <!-- <div class="layout_vertical_2">
			       <table>
			       		<tr>
							<th style="float: left;">Areas</th>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="Asia" class="trans" id="biz_area_cd" />Asia</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="N.Europe" class="trans" id="biz_area_cd" />N.Europe</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="Med" class="trans" id="biz_area_cd" />Med</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="M.East" class="trans" id="biz_area_cd" />M.East</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="S.America" class="trans" id="biz_area_cd" />S.America</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="N.America" class="trans" id="biz_area_cd" />N.America</td>
						</tr>
						<tr>
							  <td><input name="biz_area_cd" type="radio" value="IPBC" class="trans" id="biz_area_cd" />IPBC</td>
						</tr>              
				   </table>				   
			    </div> -->
			</div>
			<!-- layout_wrap(E) -->
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<div  class="opus_design_inquiry">
			<table class="grid2 wFit">
	          	<tr>
	          		<!-- 2014.07.31 김용습 - td -> th로 변경 -->
	            	<th width="120px">Content</th>
	                <td>
	                	<div>
	                		<textarea name="free_rpt_ctnt" id="free_rpt_ctnt" style="width:100%;height:300px"></textarea>
	                	</div>
	                </td>
	            </tr>
          	</table>	
        </div>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- 2014.08.01 김병국 - 3번째 탭 디자인 수정 -->
	<!-- opus_design_grid(S) -->
        <div class="opus_design_grid" name="tabLayer" id="tabLayer">
               <div  class="opus_design_inquiry ">
                       <table class="wFit">
                              <tr>
                                <th class="align_left" width="70"><h3 style="margin-bottom:0" class="title_design2">ServiesProvided</h3></th>
                                <th class="align_center" width="70"> </th>
                                <th class="align_center" width="70">1</th>
                                <th class="align_center" width="70">2</th>
                                <th class="align_center" width="70">3</th>
                                <th class="align_center" width="70">4</th>
                                <th class="align_center" width="70">5</th>                        
                                <th class="align_left">Remarks(Reasons)</th>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspService Scope</td>
                                <td class="align_center"><input name="satsfc_cd_ses" type="radio" value="" class="trans" checked id="satsfc_cd_ses" OnClick="OnChangeRadioButton()"/></td>
                                <td class="align_center" class="align_right"><input name="satsfc_cd_ses" type="radio" value="1" class="trans" id="satsfc_cd_ses" /> </td>
                                <td class="align_center"><input name="satsfc_cd_ses" type="radio" value="2" class="trans" id="satsfc_cd_ses" /> </td>
                                <td class="align_center"><input name="satsfc_cd_ses" type="radio" value="3" class="trans" id="satsfc_cd_ses" /> </td>
                                <td class="align_center"><input name="satsfc_cd_ses" type="radio" value="4" class="trans" id="satsfc_cd_ses" /> </td>
                                <td class="align_center"><input name="satsfc_cd_ses" type="radio" value="5" class="trans" id="satsfc_cd_ses" /> </td>
                                <td class="align_left"><input name="satsfc_cd_ses_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_ses_rsn" /> </td>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspSchedule Reliability</td>
                                <td class="align_center"><input name="satsfc_cd_scr" type="radio" value="" class="trans" checked id="satsfc_cd_scr" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_scr" type="radio" value="1" class="trans" id="satsfc_cd_scr" /> </td>
                                <td class="align_center"><input name="satsfc_cd_scr" type="radio" value="2" class="trans" id="satsfc_cd_scr" /> </td>
                                <td class="align_center"><input name="satsfc_cd_scr" type="radio" value="3" class="trans" id="satsfc_cd_scr" /> </td>
                                <td class="align_center"><input name="satsfc_cd_scr" type="radio" value="4" class="trans" id="satsfc_cd_scr" /> </td>
                                <td class="align_center"><input name="satsfc_cd_scr" type="radio" value="5" class="trans" id="satsfc_cd_scr" /> </td>
                                <td class="align_left"><input name="satsfc_cd_scr_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_scr_rsn" /> </td>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspEquipment Supply</td>
                                <td class="align_center"><input name="satsfc_cd_eqs" type="radio" value="" class="trans" checked id="satsfc_cd_eqs" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_eqs" type="radio" value="1" class="trans" id="satsfc_cd_eqs" /> </td>
                                <td class="align_center"><input name="satsfc_cd_eqs" type="radio" value="2" class="trans" id="satsfc_cd_eqs" /> </td>
                                <td class="align_center"><input name="satsfc_cd_eqs" type="radio" value="3" class="trans" id="satsfc_cd_eqs" /> </td>
                                <td class="align_center"><input name="satsfc_cd_eqs" type="radio" value="4" class="trans" id="satsfc_cd_eqs" /> </td>
                                <td class="align_center"><input name="satsfc_cd_eqs" type="radio" value="5" class="trans" id="satsfc_cd_eqs" /> </td>
                                <td class="align_left"><input name="satsfc_cd_eqs_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_eqs_rsn" /> </td>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspCarrier Haulage</td>
                                <td class="align_center"><input name="satsfc_cd_cah" type="radio" value="" class="trans" checked id="satsfc_cd_cah" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_cah" type="radio" value="1" class="trans" id="satsfc_cd_cah" /> </td>
                                <td class="align_center"><input name="satsfc_cd_cah" type="radio" value="2" class="trans" id="satsfc_cd_cah" /> </td>
                                <td class="align_center"><input name="satsfc_cd_cah" type="radio" value="3" class="trans" id="satsfc_cd_cah" /> </td>
                                <td class="align_center"><input name="satsfc_cd_cah" type="radio" value="4" class="trans" id="satsfc_cd_cah" /> </td>
                                <td class="align_center"><input name="satsfc_cd_cah" type="radio" value="5" class="trans" id="satsfc_cd_cah" /> </td>
                                <td class="align_left"><input name="satsfc_cd_cah_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_cah_rsn" /> </td>
                              </tr>
                              <tr>
                                <th class="align_left"><h3 style="margin-bottom:0" class="title_design2">E-Business</h3></th>   
                              </tr>
                              <tr>
                                      <td class="align_left">&nbsp&nbsp&nbsp&nbspServices Provided</td>
                                      <td class="align_center"><input name="satsfc_cd_sep" type="radio" value="" class="trans" checked id="satsfc_cd_sep" OnClick="OnChangeRadioButton()"/> </td>
                                      <td class="align_center"><input name="satsfc_cd_sep" type="radio" value="1" class="trans" id="satsfc_cd_sep" /> </td>
                                      <td class="align_center"><input name="satsfc_cd_sep" type="radio" value="2" class="trans" id="satsfc_cd_sep" /> </td>
                                      <td class="align_center"><input name="satsfc_cd_sep" type="radio" value="3" class="trans" id="satsfc_cd_sep" /> </td>
                                      <td class="align_center"><input name="satsfc_cd_sep" type="radio" value="4" class="trans" id="satsfc_cd_sep" /> </td>
                                      <td class="align_center"><input name="satsfc_cd_sep" type="radio" value="5" class="trans" id="satsfc_cd_sep" /> </td>
                                      <td class="align_left"><input name="satsfc_cd_sep_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_sep_rsn" /> </td>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspReliability</td>
                                <td class="align_center"><input name="satsfc_cd_rel" type="radio" value="" class="trans" checked id="satsfc_cd_rel" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_rel" type="radio" value="1" class="trans" id="satsfc_cd_rel" /> </td>
                                <td class="align_center"><input name="satsfc_cd_rel" type="radio" value="2" class="trans" id="satsfc_cd_rel" /> </td>
                                <td class="align_center"><input name="satsfc_cd_rel" type="radio" value="3" class="trans" id="satsfc_cd_rel" /> </td>
                                <td class="align_center"><input name="satsfc_cd_rel" type="radio" value="4" class="trans" id="satsfc_cd_rel" /> </td>
                                <td class="align_center"><input name="satsfc_cd_rel" type="radio" value="5" class="trans" id="satsfc_cd_rel" /> </td>
                                <td class="align_left"><input name="satsfc_cd_rel_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_rel_rsn" /> </td>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspUser Friendliness </td>
                                <td class="align_center"><input name="satsfc_cd_usf" type="radio" value="" class="trans" checked id="satsfc_cd_usf" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_usf" type="radio" value="1" class="trans" id="satsfc_cd_usf" /> </td>
                                <td class="align_center"><input name="satsfc_cd_usf" type="radio" value="2" class="trans" id="satsfc_cd_usf" /> </td>
                                <td class="align_center"><input name="satsfc_cd_usf" type="radio" value="3" class="trans" id="satsfc_cd_usf" /> </td>
                                <td class="align_center"><input name="satsfc_cd_usf" type="radio" value="4" class="trans" id="satsfc_cd_usf" /> </td>
                                <td class="align_center"><input name="satsfc_cd_usf" type="radio" value="5" class="trans" id="satsfc_cd_usf" /> </td>
                                <td class="align_left"><input name="satsfc_cd_usf_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_usf_rsn" /> </td>
                              </tr>
                              <tr>
                                <th class="align_left"><h3 style="margin-bottom:0" class="title_design2">Customer Service</h3></th>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspBooking Confirmation </td>
                                <td class="align_center"><input name="satsfc_cd_boc" type="radio" value="" class="trans" checked id="satsfc_cd_boc" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_boc" type="radio" value="1" class="trans" id="satsfc_cd_boc" /> </td>
                                <td class="align_center"><input name="satsfc_cd_boc" type="radio" value="2" class="trans" id="satsfc_cd_boc" /> </td>
                                <td class="align_center"><input name="satsfc_cd_boc" type="radio" value="3" class="trans" id="satsfc_cd_boc" /> </td>
                                <td class="align_center"><input name="satsfc_cd_boc" type="radio" value="4" class="trans" id="satsfc_cd_boc" /> </td>
                                <td class="align_center"><input name="satsfc_cd_boc" type="radio" value="5" class="trans" id="satsfc_cd_boc" /> </td>
                                <td class="align_left"><input name="satsfc_cd_boc_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_boc_rsn" /> </td>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspDocumentation and Billing </td>
                                <td class="align_center"><input name="satsfc_cd_dob" type="radio" value="" class="trans" checked id="satsfc_cd_dob" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_dob" type="radio" value="1" class="trans" id="satsfc_cd_dob" /> </td>
                                <td class="align_center"><input name="satsfc_cd_dob" type="radio" value="2" class="trans" id="satsfc_cd_dob" /> </td>
                                <td class="align_center"><input name="satsfc_cd_dob" type="radio" value="3" class="trans" id="satsfc_cd_dob" /> </td>
                                <td class="align_center"><input name="satsfc_cd_dob" type="radio" value="4" class="trans" id="satsfc_cd_dob" /> </td>
                                <td class="align_center"><input name="satsfc_cd_dob" type="radio" value="5" class="trans" id="satsfc_cd_dob" /> </td>
                                <td class="align_left"><input name="satsfc_cd_dob_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_dob_rsn" /> </td>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspAttitude of Staff </td>
                                <td class="align_center"><input name="satsfc_cd_ats" type="radio" value="" class="trans" checked id="satsfc_cd_ats" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_ats" type="radio" value="1" class="trans" id="satsfc_cd_ats" /> </td>
                                <td class="align_center"><input name="satsfc_cd_ats" type="radio" value="2" class="trans" id="satsfc_cd_ats" /> </td>
                                <td class="align_center"><input name="satsfc_cd_ats" type="radio" value="3" class="trans" id="satsfc_cd_ats" /> </td>
                                <td class="align_center"><input name="satsfc_cd_ats" type="radio" value="4" class="trans" id="satsfc_cd_ats" /> </td>
                                <td class="align_center"><input name="satsfc_cd_ats" type="radio" value="5" class="trans" id="satsfc_cd_ats" /> </td>
                                <td class="align_left"><input name="satsfc_cd_ats_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_ats_rsn" /> </td>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspClaims handling </td>
                                <td class="align_center"><input name="satsfc_cd_clh" type="radio" value="" class="trans" checked id="satsfc_cd_clh" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_clh" type="radio" value="1" class="trans" id="satsfc_cd_clh" /> </td>
                                <td class="align_center"><input name="satsfc_cd_clh" type="radio" value="2" class="trans" id="satsfc_cd_clh" /> </td>
                                <td class="align_center"><input name="satsfc_cd_clh" type="radio" value="3" class="trans" id="satsfc_cd_clh" /> </td>
                                <td class="align_center"><input name="satsfc_cd_clh" type="radio" value="4" class="trans" id="satsfc_cd_clh" /> </td>
                                <td class="align_center"><input name="satsfc_cd_clh" type="radio" value="5" class="trans" id="satsfc_cd_clh" /> </td>
                                <td class="align_left"><input name="satsfc_cd_clh_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_clh_rsn" /> </td>
                              </tr>
                              <tr>
                                <th class="align_left"><h3 style="margin-bottom:0" class="title_design2">Sales</h3></th>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspQuotations and Rate Request </td>
                                <td class="align_center"><input name="satsfc_cd_qur" type="radio" value="" class="trans" checked id="satsfc_cd_qur" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_qur" type="radio" value="1" class="trans" id="satsfc_cd_qur" /> </td>
                                <td class="align_center"><input name="satsfc_cd_qur" type="radio" value="2" class="trans" id="satsfc_cd_qur" /> </td>
                                <td class="align_center"><input name="satsfc_cd_qur" type="radio" value="3" class="trans" id="satsfc_cd_qur" /> </td>
                                <td class="align_center"><input name="satsfc_cd_qur" type="radio" value="4" class="trans" id="satsfc_cd_qur" /> </td>
                                <td class="align_center"><input name="satsfc_cd_qur" type="radio" value="5" class="trans" id="satsfc_cd_qur" /> </td>
                                <td class="align_left"><input name="satsfc_cd_qur_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_qur_rsn" /> </td>
                              </tr>
                              <tr>
                                <td class="align_left">&nbsp&nbsp&nbsp&nbspConsultancy</td>
                                <td class="align_center"><input name="satsfc_cd_cun" type="radio" value="" class="trans" checked id="satsfc_cd_cun" OnClick="OnChangeRadioButton()"/> </td>
                                <td class="align_center"><input name="satsfc_cd_cun" type="radio" value="1" class="trans" id="satsfc_cd_cun" /> </td>
                                <td class="align_center"><input name="satsfc_cd_cun" type="radio" value="2" class="trans" id="satsfc_cd_cun" /> </td>
                                <td class="align_center"><input name="satsfc_cd_cun" type="radio" value="3" class="trans" id="satsfc_cd_cun" /> </td>
                                <td class="align_center"><input name="satsfc_cd_cun" type="radio" value="4" class="trans" id="satsfc_cd_cun" /> </td>
                                <td class="align_center"><input name="satsfc_cd_cun" type="radio" value="5" class="trans" id="satsfc_cd_cun" /> </td>
                                <td class="align_left"><input name="satsfc_cd_cun_rsn" type="text" style="width:500px;" class="input" value="" id="satsfc_cd_cun_rsn" /> </td>
                              </tr>
                               <tr>
                                <th class="align_left"><h3 style="margin-bottom:0" class="title_design2">What Should be Improved</h3></th>      
                                <td colspan="7" class="align_left"><input name="satsfc_cd_wh_imp" type="text" style="width:100%" id="satsfc_cd_wh_imp" /> </td>
                              </tr>
                              <tr>
                                <th class="align_left"><h3 style="margin-bottom:0" class="title_design2">Customer Recommendation</h3></th>
                                <td colspan="7" class="align_left"><input name="satsfc_cd_recom" type="text" style="width:100%" id="satsfc_cd_recom" /> </td>
                               </tr>
                              <tr>
                                      <th class="align_left"><h3 style="margin-bottom:0" class="title_design2">Satisfaction Report Completed</h3></th>
                                      <td colspan="5" class="align_left">
                                              <select name="satsfc_cd_rep_comp" class="input" style="width:80px;">
                                                     <option value="Y" selected>Y</option>
                                                     <option value="N" >N</option>
                                             </select>
                                      </td>
                                      <th class="align_left">Reason</th>
                                      <td class="align_left"><input name="satsfc_cd_rsn" type="text" style="width:100%" class="input" value="" id="satsfc_cd_rsn" /> </td>
                              </tr>
            </table>
        </div>
        </div>
        <!-- opus_design_grid(E) -->

	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</form>