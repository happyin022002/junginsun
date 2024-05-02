<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0976.jsp
*@FileTitle  : Invoice Authority
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.event.EsdTrs0976Event"%>
<%

    SignOnUserAccount account = null; //Session 
	EsdTrs0976Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 
	int rowCount	 = 0;		
	String userId  = "";
	String today = DateTime.getFormatString("yyyyMMdd");
	//SignOnUserAccount account = null;

	try {

		   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		   userId=account.getUsr_id();


			event = (EsdTrs0976Event)request.getAttribute("Event");
               if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}
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
	
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">	
<input type="hidden" name="hid_cre_date" value="<%=today%>">
<input type="hidden" name="hid_cre_usr_id" value="<%=userId%>">
	
<!-- OUTER - POPUP (S)tart -->

<!-- popup_title_area(S) -->
<div class="page_title_area clear ">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>					
	    </div>
	    <!-- opus_design_btn(E) -->
    
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- popup_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">		
		<table class="search">
			<tr>
			<td>
				<table class="search_in" border="0" width="100%">
					<tbody>
						<colgroup>
							<col width="95">
							<col width="100">
							<col width="45">
							<col width="*">
						</colgroup>
						<tr class="h23">
			            	<th>Invoice Office</th>
							<td><input type="text" name='inv_ofc_cd' id='inv_ofc_cd' style="width: 74px;" value=""  onChange='getTextInvOfcCd(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' onBlur='value_upper(this)' dataformat="engup"></td>
							<th>Office</th>
							<td><input type="text" name='ofc_cd' id='ofc_cd' style="width: 74px" onChange='getTextOfcCd(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' onBlur='value_upper(this)' dataformat="engup">&nbsp;</td>
			             </tr>
			        </tbody>
				</table>
			</td>
			</tr>
		</table>		   		    	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >
		<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->		
			<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
			<button type="button" class="btn_normal" name="btng_del" id="btng_del">Row Delete</button>					
	    </div>
	    <!-- opus_design_btn(E) -->										
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->	
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<div class="header_fixed"></div>
</form>

