<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0056.jsp
*@FileTitle  : VSL Reefer Spare Part Inventory
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
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0056Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id         =	account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm = account.getOfc_eng_nm();
		
		event = (EesMnr0056Event)request.getAttribute("Event");
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

<script  type="text/javascript">
    var currOfcCd = '<%=currOfcCd %>';
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
<input type="hidden" name="f_gubuns">
<input type="hidden" name="vsl_cd" value="">
<input type="hidden" name="vsl_cd2" value="">

<input type="hidden" name="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">
<input type="hidden" name="cost_ofc_cd" value="">
 
 
	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button><!-- 
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
	            <col width="30" />
	            <col width="400" />
	            <col width="50" />
	            <col width="250" />
	            <col width="50" />
	            <col width="250" />
	            <col width="*" />
	        </colgroup> 
	        <tbody>
				<tr>
					<th>Date</th>
					<td><select style="width:120px;" name="date_gubun" id="date_gubun" class="input1" ><!-- 
							 --><option value="0" selected>Supply Date</option><!-- 
							 --><option value="1" >Discharge Date</option><!-- 
							 --><option value="2" >Check Date</option><!-- 
						 --></select><input type="text" style="width:80px;text-align:center" class="input1" name="fromcal" id="fromcal" dataformat="ymd" required >~ <input type="text" style="width:80px;text-align:center" class="input1" name="tocal" id="tocal" dataformat="ymd" required ><button class="calendar ir" name="btn_calendar" id="btn_calendar" type="button"></button></td>
					<th>Lane</th>
					<td><input type="text" style="width:120px;text-align:left" class="input" name="vsl_slan_cd" id="vsl_slan_cd" dataformat="engup"><button class="input_seach_btn" name="btn_Lane" id="btn_Lane" type="button"></button></td>
					<th>Spare Type</th>
					<td><script  type="text/javascript">ComComboObject('combo_spr_tp_cd',2, 100 , 1, 0,0,false,1);</script><input type="hidden" name="spr_tp_cd" id="spr_tp_cd"></td>
					<td></td>
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
		<h3 class="title_design"> Reefer Spare Parts Inventory</h3>
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn"><!-- 
	         --><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
	         --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button><!-- 
	         --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
	         --><button type="button" class="btn_normal" name="btn_spare_type_list" id="btn_spare_type_list">Spare Type List</button><!-- 
	         --><button type="button" class="btn_normal" name="btn_workorder_history" id="btn_workorder_history">W/O History</button><!-- 
	     --></div>
	    <!-- opus_design_btn(E) -->
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script  type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- <script  type="text/javascript">ComSheetObject('sheet2');</script> -->
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_grid(E) -->
</div> 			
</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>