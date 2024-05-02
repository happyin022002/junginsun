<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0111.jsp
*@FileTitle  : Hanger Rack/Bar History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0111Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0111Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		rhqOfcCd  = account.getRhq_ofc_cd();
		currOfcCd = account.getOfc_cd();

		event = (EesMnr0111Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script  type="text/javascript">
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=rhqOfcCd %>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="key_value">
<input type="hidden" name="usr" value="<%=strUsr_id %>">
<input type="hidden" name="f_gubuns">
<input type="hidden" name="cost_ofc_cd">
<input type="hidden" name="self_ofc_cd" value="<%=currOfcCd%>">
<input type="hidden" name="mnr_grp_tp_cd" value="RPR">
<input type="hidden" name="mnr_wo_tp_cd" value="RFS">
<input type="hidden" name="sel_type" value="S">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title">Hanger Rack/Bar History</span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!-- 
		     --></div>
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
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="70" />
	            <col width="200" />
	            <col width="100" />
	            <col width="240" />
	            <col width="100" />
	            <col width="120" />
	            <col width="50" />
	            <col width="*" />
	        </colgroup> 
	        <tbody>
				<tr>
					<th>Location By</th>
					<td><!-- 
						 --><script  type="text/javascript">ComComboObject('p_loc_tp',1, 60 , 1,0);</script><!--
						 --><input type="text" name="p_loc_cd" id="p_loc_cd" caption="Location" style="width:70px;ime-mode:disabled;" value="" class="input2"  dataformat="engup" maxlength="5" readonly ><!-- 
		            	 --><button class="input_seach_btn" name="btns_search" id="btns_search" type="button"></button><!-- 
					 --></td>
					<th>History Period</th>
					<td><!-- 
						 --><input type="text" style="width:80px;" class="input" name="from_date" dataformat="ymd" maxlength="10" cofield="to_date">~ <!-- 
						 --><input type="text" style="width:80px;" class="input" name="to_date" dataformat="ymd" maxlength="10" cofield="from_date"><!--
						 --><button class="calendar ir" name="cre_dt_cal" id="cre_dt_cal" type="button"></button><!-- 
					 --></td>
					<th>EQ Type</th>
					<td><script  type="text/javascript">ComComboObject('eq_knd_cd',1, 100 , 1,0)</script></td>
					<th>TP/SZ</th>
					<td><script  type="text/javascript">ComComboObject('eq_tpsz_cd', 2, 100 ,0)</script></td>
				</tr>
				<tr>
					<th>Tariff Type</th>
					<td><script  type="text/javascript">ComComboObject('mnr_hngr_trf_cd',1, 162 , 1,0);</script></td>
					<th>Hanger Rack Type</th>
					<td><script  type="text/javascript">ComComboObject('mnr_hngr_rck_cd',1, 202 , 1,0)</script></td>
					<th>Hanger Bar Type</th>
					<td><script  type="text/javascript">ComComboObject('mnr_hngr_bar_tp_cd',1, 100 , 1,0)</script></td>
					<th>Bound</th>
					<td><script  type="text/javascript">ComComboObject('bound_tp_cd',1, 100 , 1,0)</script></td>
				</tr>
				<tr>
					<th>EQ No.</th>
					<td width="" colspan="3" align="left"><input type="text" name="eq_list" style="width:259px;" class="input" dataformat="engup"><button class="multiple_inq ir" name="eq_no_multi" id="eq_no_multi" type="button"></button></td>
					<td width="" colspan="4"></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>	
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable">
		<h3 class="title_design">Hanger Rack/Bar History</h3>
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script  type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
