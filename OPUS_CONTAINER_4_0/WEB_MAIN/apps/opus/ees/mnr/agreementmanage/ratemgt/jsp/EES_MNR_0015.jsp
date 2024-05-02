<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0015.jsp
*@FileTitle  : M&R Agreement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.event.EesMnr0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.EQFlagMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!--Use a common at MNR  -->
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script type="text/javascript">ComSheetObject('sheet1');</script>

<form name="form">
<input type="hidden" name="local_ofc_cd" id="local_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Hidden variable for retrieve by indexing -->
<input type="hidden" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd">
<input type="hidden" name="agmt_seq" id="agmt_seq">
<!-- Hidden variable for using TPSZ of non-fixed -->
<input type="hidden" name="agmt_type_tpsz" id="agmt_type_tpsz">
<!-- Hidden variable for using VO of non-fixed -->
<input type="hidden" name="agmt_display_type" id="agmt_display_type">
<input type="hidden" name="agmt_prifix" id="agmt_prifix">
<!-- Hidden variable for latest version status -->
<input type="hidden" name="isversionup" id="isversionup" value="N">

<!-- Hidden variable for PARTER -->
<input type="hidden" name="ctrl_ofc_cd" id="ctrl_ofc_cd" value="<%=strOfc_cd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_del" 	id="btn_del">Delete</button><!-- 
		--><button type="button" class="btn_normal" name="btn_versionup" 	id="btn_versionup">Version_Up</button><!-- 
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100">
				<col width="150">
				<col width="75">
				<col width="*">
			</colgroup>
			<tr>
				<th>Agreement No.</th>
				<td><!-- 
					 --><input required tabindex="1" type="text" name="agmt_no" id="agmt_no"  style="width:100px;" class = "input1" value = "" dataformat="engup"><!-- 
					 --><button type="button" name="btn_agmt_no" id="btn_agmt_no" class="input_seach_btn"></button></td>
				<th>Version No.</th>
				<td><script type="text/javascript">ComComboObject('agmt_ver_no', 2, 50, 1, 1,0,false,2);</script></td>
				
			</tr>
		</table>
	</div>
	<div class="opus_design_inquiry">
		<table class="line_bluedot"><tr><td></td></tr></table>
	</div>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="310">
				<col width="70">
				<col width="80">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr>
				<th>Service Provider</th>
				<td>
					<input required tabindex="3" type="text" name="vndr_seq" id="vndr_seq" caption="Service Provider" style="width:55px;text-align:left;" class="input1" value="" dataformat="num" maxlength="6"><!-- 
					 --><button type="button" name="btn_vndr" id="btn_vndr" class="input_seach_btn"></button><!-- 
					 --><input type="text" name="vndr_nm" id="vndr_nm" caption="Service Provider" style="width:190px;" class="input2" value="" readonly>
				</td>
				<th>Currency</th>
				<td><script type="text/javascript">ComComboObject('curr_cd', 2, 60, 1, 1,0,false,4);</script></td>
				<th>Agreement Office</th>
				<td><script type="text/javascript">ComComboObject('agmt_ofc_cd', 1, 80, 1, 1);</script></td>
			</tr>
			<tr>
				<th>Effect Period</th>
				<td>
					<input required  type="text" name="eff_dt" id="eff_dt" dataformat="ymd"    class="input1"  caption="Effect Period From Date"  maxlength="10" style="width:78px"  cofield="exp_dt" value=""><!-- 
	                 -->~ <input required  type="text" name="exp_dt" id="exp_dt" dataformat="ymd"   class="input1"  caption="Effect Period To Date"        maxlength="10"  size="10"  cofield="eff_dt"><!-- 
	                 --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
				</td>
				<th>Pay Terms</th>
				<td>
					<input required name="pay_term_dys" id="pay_term_dys" type="text" style="width:42px;text-align:right;" class="input1" value="" maxlength="3" dataformat="num" >&nbsp;days
				</td>
				<th>AGMT Sign Date</th>
				<td><!-- 
					 --><input required  name="agmt_dt" id="agmt_dt" type="text" style="width:79px" class="input1" value="" dataformat="ymd" maxlength="10"><!-- 
					 --><button type="button" class="calendar ir" name="btn_calendar1" id="btn_calendar1"></button></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="309">
				<col width="70">
				<col width="*">
			</colgroup>
			<tr>
				<th>Tariff No.</th>
				<td><script type="text/javascript">ComComboObject('trf_no', 8, 270, 1, 0,0,false,1);</script></td>
				<th>Ref. No.</th>
				<td><input required type="text"  maxlength="20" name="agmt_ref_no" id="agmt_ref_no" style="width:280px;" class="input1" value="" dataformat="engupetc" ></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="240">
				<col width="140">
				<col width="*">				
			</colgroup>
			<tr>
				<th>EQ Type</th>
				<td>
					<script type="text/javascript">ComComboObject('eq_knd_cd',1, 78 , 1,1)</script>
				</td>
				<th>Old Agreement No.</th>
				<td><input type="text" name="old_agmt_no" id="old_agmt_no" style="width:200px;" class="input2" value="" dataformat="engup" disabled></td>
			</tr>
		</table>
		<table>
            <colgroup>
                <col width="100">
                <col width="120">
                <col width="100">
                <col width="150">
                <col width="100">
                <col width="120">
                <col width="100">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>Create User</th>
                    <td><input type="text" style="width:80px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
                    </td>
                    <th>Create Date/Time</th>
                    <td><input type="text" style="width:120px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
                    </td>
                    <th>Last Update User</th>
                    <td><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
                    </td>
                    <th>Last Update Date/Time</th>
                    <td><input type="text" style="width:120px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
                    </td>
                </tr>
            </tbody>
        </table>
	</div>
</div>
<!-- opus_design_inquiry(S) -->
		
<!-- layout_wrap(S) -->
<div class="wrap_result">
<div class="layout_wrap" style="height:310px;">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2 mar_rgt_12 sm" style="width: 49%;">
		<!-- opus_tab_btn(S) -->
		<div style="margin-right:10px;margin-left:10px;">
			<div class="opus_design_tab">
				<script type="text/javascript"> ComTabObject ('tab1')</script>
			</div>
			<!-- opus_tab_btn(E) -->
			<!--TAB Repair (S) -->
			<div id="tabLayer" style="display: none">
				<!-- Grid  (S) -->
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title1"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t1add" id="btn_t1add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t1del"  	id="btn_t1del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t1sheet1');</script>
				</div>
				<!-- Grid (E) -->
				<!--  (Repair) Deleting Additional requests of RC type -->
			</div>
			<!--TAB Repair (E) -->
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title2"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t2add" id="btn_t2add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t2del"  	id="btn_t2del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t2sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title3"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t3add" id="btn_t3add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t3del"  	id="btn_t3del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t3sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title4"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t4add" id="btn_t4add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t4del"  	id="btn_t4del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t4sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title5"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t5add" id="btn_t5add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t5del"  	id="btn_t5del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t5sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title6"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t6add" id="btn_t6add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t6del"  	id="btn_t6del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t6sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title7"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t7add" id="btn_t7add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t7del"  	id="btn_t7del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t7sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title8"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t8add" id="btn_t8add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t8del"  	id="btn_t8del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t8sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title9"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t9add" id="btn_t9add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t9del"  	id="btn_t9del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t9sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title10"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t10add" id="btn_t10add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t10del"  	id="btn_t10del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t10sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title11"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t11add" id="btn_t11add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t11del"  	id="btn_t11del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t11sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title12"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t12add" id="btn_t12add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t12del"  	id="btn_t12del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t12sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title13"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t13add" id="btn_t13add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t13del"  	id="btn_t13del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t13sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title14"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t14add" id="btn_t14add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t14del"  	id="btn_t14del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t14sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title15"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t15add" id="btn_t15add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t15del"  	id="btn_t15del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t15sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title16"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t16add" id="btn_t16add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t16del"  	id="btn_t16del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t16sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title17"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t17add" id="btn_t17add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t17del"  	id="btn_t17del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t17sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title18"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t18add" id="btn_t18add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t18del"  	id="btn_t18del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t18sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title19"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t19add" id="btn_t19add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t19del"  	id="btn_t19del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t19sheet1');</script>
				</div>
			</div>
			
			<div id="tabLayer" style="display: none">
				<div class="opus_design_grid">
					<h3 class="title_design" id="sheet_title20"></h3>
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_t20add" id="btn_t20add">Row Add</button>
						<button type="button" class="btn_normal" name="btn_t20del"  	id="btn_t20del">Row Delete</button>
					</div>
					<script type="text/javascript">ComSheetObject('t20sheet1');</script>
				</div>
			</div>
		</div>
	</div>
     <!-- layout_vertical_2(E) -->
   	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2 sm" style="width: 50%; position:relative; ">
			<h3 class="title_design" style="position:absolute;">Cost CTRL Office & Partner Infomation</h3>
			<div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button>
					<button type="button" class="btn_normal" name="btn_s1del"  	id="btn_s1del">Row Delete</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
	</div>
     <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->
	<div class="opus_design_inquiry" style="margin-top:-20px !important; ">
		<table class="grid2">
			<colgroup>
				<col width="65">
				<col width="*">
			</colgroup>
		   <tr>
		   		<th>Remark(s)</th>
				<td><textarea name="agmt_rmk" id="agmt_rmk"  style="width:100%;ime-mode:disabled;resize:none" rows="3" maxlength="4000"></textarea></td>
		   </tr>
		</table>
	</div>
</div>
</form>