<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4002.jsp
*@FileTitle  : Rating Unit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.ratingunit.event.EsmPri4002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri4002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] ratUtGrpCd		= null;
	String[] cntrSzCd		= null;
	
	Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.RatingUnit");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri4002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		ratUtGrpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ratUtGrpCd"),false,"|","\t","getCode","getName");
		cntrSzCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("cntrSzCd"), false);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var ratUtGrpComboValue = " |<%=ratUtGrpCd[0]%>";  
    var ratUtGrpComboText = " |<%=ratUtGrpCd[1]%>";
    var ratUtGrpCdValue = " |<%=ratUtGrpCd[0]%>";  
    var ratUtGrpCdText = " |<%=ratUtGrpCd[1]%>";
    var cntrSzCdValue = " |<%=cntrSzCd[0]%>";  
    var cntrSzCdText = " |<%=cntrSzCd[1]%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input name="cd" id="cd" type="hidden" value="">
<!-- developer job	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button><!-- Rating Unit Inquiry -->
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button>
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

<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
	<!-- opus_design_inquiry(S) -->
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
	    <table>
	         <colgroup>
	            <col width="50" />
	            <col width="60" />
	            <col width="50" />
	            <col width="120" />
	            <col width="100" />
	            <col width=* />	            
	        </colgroup> 
	        <tbody>
				<tr>
					<th>Unit</th>
					<td><input type="text" name="rat_ut_cd" id="rat_ut_cd" maxlength="2" style="width:75px; ime-mode:disabled;" class="input" dataformat="engup" ></td>
					<th>Character</th>
					<td><script type="text/javascript">ComComboObject('rat_ut_grp_cd', 1, 100, 0, 0, 0, false);</script></td>
					<td><input type="checkbox" name="f_delt_flg" id="f_delt_flg" class="trans"><label for="f_delt_flg"><b>Including Deleted Unit</b></label></td>
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
	<div class="opus_design_grid" style="display:none">	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet0');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
	</div>
	<!-- opus_design_grid(E) -->	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>




