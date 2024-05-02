<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SCO_0200.jsp
*@FileTitle  : AP Cost Activity Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0200Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%
    StmSco0200Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg    = "";   				//에러메세지
	int rowCount	    = 0;					//DB ResultSet Count of list
	
	String strUsr_id    = "";
	String strUsr_nm    = "";
	String strUsr_ofc   = "";
		
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sco.statementcommon.StatementCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (StmSco0200Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server
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
<form  name="form">
<input type="hidden"  name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save"  		id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>	
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
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100"/>
				<col width="250"/>
				<col width="100"/>
				<col width="200"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>Source Module</th>
					<td><script language="javascript">ComComboObject('src_mdl_cd', 2, 200, 1, 0,0,false,1);</script></td>
					<th>Cost Code</th>
					<td><input type="text" style="width:150" class="input" name="act_cost_cd"></td>
					<th>Delete Flag</th>
		           	<td><select name="del_flg" class="input" style="width:50;" id="del_flg">
		                <option value="N">N</option>
		                <option value="Y">Y</option>
		                </select></td>
				</tr>	
			</tbody>
		
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_RowDelete" 	id="btn_RowDelete">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	
</form>
