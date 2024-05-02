<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0013.jsp
*@FileTitle  : BKG Creation Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.event.EsmSaq0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BasicDataManage.TargetGroup");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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

<div class="page_title_area clear">
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
   
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn" ><!--
    --><button type="button" class="btn_accent" name="btn_retrieve"  	id="btn_retrieve" >Retrieve</button><!--
    --><button type="button" class="btn_normal" name="btn_new" 	id="btn_new">New</button><!--
    --><button type="button" class="btn_normal" name="btn_rowadd" 	id="btn_rowadd">Row Add</button><!-- 
    --><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!--
    --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button></div>
    <!-- opus_design_btn(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>

<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="50" />
			<col width="70" />
			<col width="80" />
			<col width="80" />
			<col width="90" />
			<col width="100" />
			<col width="" />
		</colgroup>
		<tbody>
			<tr>
				<th>Trade</th>
				<td><script type="text/JavaScript">ComComboObject("trade", 2, 60, 0, 0);</script></td>
				<th>Sub Trade</th>
				<td><script type="text/JavaScript">ComComboObject("sub_trd_cd", 3, 50, 0, 0 , 1);</script></td>
				<th>Target Group</th>
				<td><script type="text/JavaScript">ComComboObject("saq_tgt_grp_cd", 2, 80, 0, 0);</script></td>
				<td></td>
			</tr>
		</tbody>
		</table>
		
</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
  		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- wrap_result(E) -->	
</form>
