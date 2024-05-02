<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0003.jsp
*@FileTitle  :  물류비용 코드 등록
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO"%>

<%
	Exception serverException   = null;								//Error from server
	String strErrMsg = "";													//Error message
	GeneralEventResponse eventResponse = null;
	String hdCode = "";
	String hdText = "";
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
        }	
	}catch(Exception e) {
		out.println(e);
	}
	if (eventResponse != null) {
    	CostStructureSoCodeRtnVO retVo = (CostStructureSoCodeRtnVO)eventResponse.getCustomData("retVo");

    	hdCode = retVo.getHeaderCode();
    	hdText = retVo.getHeaderText();			
    }
%>



<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=hdCode%>', '<%=hdText%>');
	}
</script>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="f_header_code" value="<%=hdCode%>" id="f_header_code" />
<input type="hidden" name="f_header_text" value="<%=hdText%>" id="f_header_text" />

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Register Cost Item</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="200" />					
					<col width="75" />
					<col width="250" />
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th><input type="radio" value="1" class="trans" name="code" onclick="goURL(1)" id="code" /><label for="code">Cost Element</label><input type="radio" value="2" class="trans" name="code" checked="" id="code" /><label for="code">So Cost Code</label></th>
						<th>Sub Group</th>
						<td>
							<!--사이즈 가변 처리 요망 -->
							<script type="text/javascript">ComComboObject('f_sgrp_cost_cd',2, 220 , 0 )</script>
						</td>
						<th>COA Code</th>
						<td>
							<script type="text/javascript">ComComboObject('f_stnd_cost_cd',1, 220 , 0 )</script>
						</td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>	
	<div class="wrap_result">		
		<!-- opus_design_grid(S) -->
		<table>
				<tr>
					<td><h3 class="title_design">Register Cost Items</h3></td>
					<td>
						<div class="opus_design_btn">
							<button type="button" class="btn_etc" name="btng_hidecheckbox" id="btng_hidecheckbox">Hide Check Box</button>
						</div>
					</td>
				</tr>
			</table>
		<div class="opus_design_grid "  id="mainTable">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
				--><button type="button" class="btn_accent" name="btng_save" id="btng_save">Save</button><!--
			--></div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>		
</form>
<iframe height="0" width="0" name="frmHidden"></iframe>
<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
</form>