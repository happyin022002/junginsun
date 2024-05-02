<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_2001_01.jsp
*@FileTitle  : Customs Common Code
*@author     : CLT
*@version    : 1.0
*@since      : 2015/06/24
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg200101Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg200101Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg200101Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="chk_cnt_cd">
<input type="hidden" name="chk_cstms_div_id">
<input type="hidden" name="chk_cnt">
<input type="hidden" name="chk_attr_nm1">
<input type="hidden" name="chk_attr_nm2">
<input type="hidden" name="chk_attr_nm3">
<input type="hidden" name="chk_attr_nm4">
<input type="hidden" name="chk_attr_nm5">


	
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	    --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button>
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
		            <col width="60" />
		            <col width="60" />
		            <col width="170" />
		            <col width="80" />
		            <col width="*" />
		        </colgroup> 
		        <tbody>
					<tr>
						<th>Country</th> 
						<td><input type="text" style="width:30px; ime-mode:disabled" name="frm_cnt_cd" class="input1" dataformat="engup" maxlength="2" caption="Country Code"></td>
						<th>Division ID</th>
						<td><input type="text" style="width:150px; ime-mode:disabled" name="frm_cstms_div_id" class="input" dataformat="engup" otherchar="_-" maxlength="20"></td>
						<th>Description</th>
						<td><input type="text" style="width:500px; ime-mode:abled" name="frm_cstms_cd_desc" class="input" maxlength="4000"></td>
					</tr>
					
				</tbody>
			</table>
		    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn"><!--
	    --><button type="button" class="btn_normal" name="btn_exceldown1" id="btn_exceldown1">Down Excel</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<div class="opus_design_grid sm">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn"><!--
	    --><button type="button" class="btn_normal" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button><!--
	    --><button type="button" class="btn_normal" name="btn_RowDel2" id="btn_RowDel2">Row Delete</button><!--
	    --><button type="button" class="btn_normal" name="btn_exceldown2" id="btn_exceldown2">Down Excel</button><!--
	    --><button type="button" class="btn_normal" name="btn_excelup2" id="btn_excelup2">Load Excel</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
	<!--biz page (E)-->
</div>

</form>