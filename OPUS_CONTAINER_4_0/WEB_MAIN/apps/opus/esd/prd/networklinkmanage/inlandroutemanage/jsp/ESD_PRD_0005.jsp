<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0005.jsp
*@FileTitle  : Inland Route Management (Europe/China/Asia)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0005Event"%>

<%
	EsdPrd0005Event  event = null;
    Exception serverException   = null;
    DBRowSet rowSet      = null;
    String strErrMsg = "";
    int rowCount     = 0;
    String selInvCodeNoSort ="";
    String selPlanCodeNoSort = "";
    String optStr = "000010::";
    String optStr2="|000010: : ";
    try {
        event = (EsdPrd0005Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        selInvCodeNoSort = JSPUtil.getCodeCombo("i_inv", "01", "width='144' onChange='setCombindMode();'", "CD00126", 0, optStr);
        selPlanCodeNoSort = JSPUtil.getCodeCombo("i_rout_pln_cd", "01", "width='140'", "CD00127", 0, optStr);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("rail_crr_tp_cd", "01", "CD00287", 0, optStr2)%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>



<form method="post" name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<!-- if(!checkMandatory() ) return; // setting i_ord_cd(from),i_dest_cd(to) -->
<input type="hidden" name="i_org_cd" id="i_org_cd" />
<input type="hidden" name="i_dest_cd" id="i_dest_cd" />
<!-- first and last route - sheetObj2  -->
<input type="hidden" name="i_rout_org_nod_cd" id="i_rout_org_nod_cd" />
<input type="hidden" name="i_rout_dest_nod_cd" id="i_rout_dest_nod_cd" />

<input type="hidden" name="i_rout_seq" id="i_rout_seq" />
<input type="hidden" name="i_hub_search_gb" id="i_hub_search_gb" />
<input type="hidden" name="i_front_gb" id="i_front_gb" />
<input type="hidden" name="i_undefine_nod" id="i_undefine_nod" />
<input type="hidden" name="i_new_route_cd" id="i_new_route_cd" />
<input type="hidden" name="i_sel_row" id="i_sel_row" />
<input type="hidden" name="disable_bkg_flg" id="disable_bkg_flg" />
<input type="hidden" name="prio_seq_combo" id="prio_seq_combo" />

<input type="hidden" name="detail_org_i_inv" id="detail_org_i_inv" />
<input type="hidden" name="detail_org_i_rout_pln_cd" id="detail_org_i_rout_pln_cd" />
<input type="hidden" name="detail_org_i_bkg_flg" id="detail_org_i_bkg_flg" />
<!-- input type="hidden" name="detail_org_i_mcntr_rout_flg"-->
<input type="hidden" name="i_mcntr_rout_flg" value="" id="i_mcntr_rout_flg" />
<input type="hidden" name="cnt_cd" value="" id="cnt_cd" />


	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_minimize"   id="btn_minimize">Minimize</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button><!-- 
				 -->&nbsp;Delete Flag&nbsp;<input name="i_del_flg" id="i_del_flg" type="checkbox" class="trans"  value="Y" onClick="changeDeltFlg()" unchecked>
		    </div>
		    <!-- opus_design_btn(E) -->
	    
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	
	</div>
	<!-- page_title_area(E) -->
	
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="60" />
	            <col width="70" />
	            <col width="120" />
	            <col width="40" />
	            <col width="40" />
	            <col width="70" />
	             <col width="30" />
	            <col width="100" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr>
					<td><input type="hidden" name="rBtnIrgCd" id="rBtnIrgCd" value="I"><input type="radio" name='r_inbound' id="r_inbound" value='I' class="trans" onClick="changeSelection('I')" checked>&nbsp;<lable for="r_inbound">IB</lable></td>
				    <td><input type="radio" name='r_inbound' id="r_inbound" value='O' class="trans" onClick="changeSelection('O')">&nbsp;<lable for="r_inbound">OB</lable></td>
				    <td><div id="div_desc"><input type="radio" name='r_inbound' id="r_inbound" value='B' class="trans" onClick="changeSelection('B')"><lable for="r_inbound">TMNL SHTL</lable></div></td>
					<td><script type="text/javascript"> 
						var desc = "Terminal Shuttle IRG for COP change " ;
						document.all.div_desc.title = desc;
						</script>
					</td>
					
					<th>From</th>
					<td><input class="input1" name="i_org_cd_ib" id="i_org_cd_ib" type="text" required caption="From" maxlength="7" tabIndex="1" style="width:70px;text-align:center" dataformat="engup" style="text-align:center" ><!-- 
	                	 --><button type="button" id="ib_org_tml_btn" name="ib_org_tml_btn" class="input_seach_btn"></button>
					</td>
					
					<th>To</th>
					<td><input class="input1" name="i_dest_cd_ib" id="i_dest_cd_ib" type="text" required caption="To"  maxlength="7" tabIndex="2" style="width:70px;text-align:center" dataformat="engup" style="text-align:center"><!-- 
	                	 --><button type="button" id="ib_dest_loc_btn" name="ib_dest_loc_btn" class="input_seach_btn"></button>
					</td>
	                <td align="right"><input type="hidden" name="rBtnNodTyCd1" id="rBtnNodTyCd1" value="Y"><!-- 
	                	 --><input type="radio" name='nod_tp_cd1' id="nod_tp_cd1" value='Y' class="trans" onClick="changeNodTy1('Y')" checked><lable for="nod_tp_cd1">Yard</lable>&nbsp;&nbsp;&nbsp;<!-- 
	                	 --><input type="radio" name='nod_tp_cd1' id="nod_tp_cd1" value='Z' class="trans" onClick="changeNodTy1('Z')"><lable for="nod_tp_cd2">Zone</lable>
	                </td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
		<h3 class="title_design mar_top_12">If you want to change priority, please double-click on priority column.</h3>
					
	</div>
	<!-- opus_design_grid(E) -->



	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="minimize">
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="80"/>
					<col width="50"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>Booking Flag</th>
						<td><input name="i_bkg_flg" id="i_bkg_flg" type="checkbox" class="trans" value="" onClick="checkedBkgFlg()" unchecked></td>
						<td><!-- MT<input name="i_mcntr_rout_flg" type="checkbox" class="trans" value="Y" unchecked > --></td>
					</tr>
				</tbody>
			</table>
		</div>
					
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btng_clear" id="btng_clear">Clear</button>
	        <button type="button" class="btn_normal" name="btng_new" id="btng_new">New</button>
	        <button type="button" class="btn_normal" name="btng_listlink" id="btng_listlink">List Link</button>
	        <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
	        <button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>
	        <button type="button" class="btn_normal" name="btng_saveas" id="btng_saveas">Save AS</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="60"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr><td height="5"></td></tr>
					<tr>
						<th>Remarks</th>
						<td><input name="i_route_rmk" id="i_route_rmk" type="text" style="width:900px"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
					
	</div>
	<!-- opus_design_grid(E) -->

	<!-- div id="minimize" -->
	<div style="visibility:hidden;">
		<table>
			<colgroup>
				<col width="170"/>
				<col width="330"/>
				<col width="90"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<td><img src="/opuscntr/img/ico_star.gif" >INV Billing &amp;INV Pattern </td>
					<td>
					<!-- <select name="i_inv" style="width:144">
					<option value="0" selected>CT Combine Thru Bill</option>
					<option value="0">Combine & Rule 11</option>
					</select> -->
						<%=selInvCodeNoSort %>
		
					</td>
					<td><img src="/opuscntr/img/ico_star.gif" >Route Plan</td>
					<td>&nbsp;
					    <!--
						<select name="i_rout_plan" style="width:215">
						<option value="0" selected>65 Shuttle To Ramp For Domestic</option>
						<option value="0">80 Shuttle To Shuttle For Inti</option>
						<option value="0">82 Shuttle To Ramp For Inti</option>
						<option value="0">85 Ramp To Ramp For Inti</option>
						<option value="0">87 Ramp To Shuttle For Inti</option>
						<option value="0">45 Ramp To Ramp For Domestic</option>
						</select>
						 -->
						<%=selPlanCodeNoSort %>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
					
</div>				
</form>
