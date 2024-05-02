<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0233.jsp
*@FileTitle  : Agreement Header Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%> 
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException = null;	//Error occurred on the server
	String	  strErrMsg	= "";			//Error message
	String	  userId    = "";
	String	  ofcCd		= "";
	String    agmt_no   = ((request.getParameter("agmt_no")==null )?"":request.getParameter("agmt_no"));
	try {		
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String mainRow = JSPUtil.getNull(request.getParameter("main_row"));
%>

<script language="javascript">
  function setupPage(){
    loadPage();
  }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="mainRow" value='<%=mainRow%>'>

<input type="hidden" name="f_cmd" >

	
	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title"><span>Agreement Header Inquiry</span></h2>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_retrieve" id="btng_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btng_ok"  	 id="btng_ok">OK</button><!--
	        	--><button type="button" class="btn_normal" name="btng_close"   id="btng_close">Close</button>
			</div>
		</div>
	</div>
	<!-- popup_title_area(E) -->
	
	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
		<!-- wrap_search(S) -->
		<div class="wrap_search">
	
		    <!-- inquiry_area(S) -->	    
		    <div class="opus_design_inquiry">
		        <table> 
		            <colgroup>
		                <col width="100px" />
		                <col width="45px" />
		                <col width="190px" />
		                <col width="100px" />	                
		                <col width="" />
		            </colgroup>
		            <tbody>
		                <tr>
		                    <th>Service Provider</th>
		                    <td>
		                    	<input name="combo_svc_provider" type="text" style="width:50px;" value=""  maxlength="6" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)'><!--
		                    	--><input name="svc_provider" type="text" style="width:105px;" value="" title="This inputbox cant't write"><!--
	                      		--><button type="button" class="input_seach_btn" id='btn_provider' name='btn_provider'></button>	                      		
		                    </td>
		                    <th>Agreement No.</th>
		                    <td>
		                    	<input name="agmt_no" id="agmt_no" type="text" style="width:70px;" value="<%=agmt_no%>" onKeyup="javascript:doSearchEnter();" dataformat="engup">
		                    </td>	
		                    <td></td>                    
						</tr>
						<tr>
							<th>Reference No.</th>
							<td>
								<input name="agmt_ref_no" type="text" style="width:159px;" value=""  maxlength="15" onKeyup="javascript:doSearchEnter();">
							</td>
							<th>Contract Office</th>
							<td>
								<input name="ctrt_ofc_cd" type="text" style="width:70px;" dataformat="engup" value="" maxlength="6" onKeyup="javascript:doSearchEnter();" dataformat="engup">
							</td>
							<td></td>
						</tr>					
					</tbody>
				</table>
			</div>
		</div>
		<!-- wrap_search(E) -->
		
		<!-- wrap_result(S) -->
		<div class="wrap_result">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable">
				<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    	<script type="text/javascript">ComSheetObject('sheet1');</script>
		    	<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<!-- wrap_result(E) -->
	</div>	
	<!-- popup_contens_area(E) -->
	<div class="header_fixed"></div>
</form>