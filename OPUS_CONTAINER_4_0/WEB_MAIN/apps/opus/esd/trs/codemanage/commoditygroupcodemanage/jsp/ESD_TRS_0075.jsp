<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0075
*@FileTitle  : Commodity Group Code Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.event.EsdTrs0075Event"%>
<%
	EsdTrs0075Event event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	String strErrMsg 			= "";			//Error message
	int rowCount	 			= 0;			//List the number of DB ResultSet
	String userId  				= "";
	String today 				= DateTime.getFormatString("yyyyMMdd");

	try {

		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId=account.getUsr_id();
		event = (EsdTrs0075Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null)
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();

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
<input type="hidden" name="iPage">
<input type="hidden" name="cre_usr_id" value="<%=userId%>">
<input type="hidden" name="cre_dt" value="<%=today%>">
<input type="hidden" name="upd_usr_id" value="<%=userId%>">
<input type="hidden" name="upd_dt" value="<%=today%>">
<input type="hidden" name="insert_val" value="N">
<input type="hidden" name="delete_val" value="Y">
<input type="hidden" name="hid_row">
<input type="hidden" name="hid_col">
<input type="hidden" name="hid_vndr_seq" value="">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->		
			
	<!-- opus_design_btn(S) -->
	<!-- <div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button>
	</div> -->
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
<div class="layout_wrap">
<div class="opus_design_inquiry">
<div class="layout_vertical_2" style="width:48%; margin-right:4%" >
						<div class="opus_design_btn" style="padding:0;">
							<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
							<button type="button" class="btn_accent" name="btn_retrieve1" id="btn_retrieve1">Retrieve</button><!-- 
							 --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!-- 
						 --></div>				
				
					    <table>
					        <tbody>
								<tr class="h23">
									<th width="135">Service Provider</th>
									<td width="134"><input name="vndr_cd" type="text" style="width:100%;" class="input1"  onBlur="vndr_check(this);"  onFocus='fun_Focus(this)' maxlength="9" dataformat="engup"></td>
									<td><input name="vndr_nm" type="text" style="width:100%;" class="input1" onBlur="vndr_nm_check(this);"  onFocus='fun_Focus(this)' maxlength="100" dataformat="engup"></td>
									<td width="23" class="align_right" style="padding-right:0;"><button type="button" class="input_seach_btn" name="" id="" style="margin-right:0;"  onClick="vndr_OnPopupClick();"></button>
									
									</td>
								</tr>
								<tr class="h23">
									<th>S/P Commodity Group</th>
									<td><input name="vndr_commoodity_cd" type="text" style="width:100%;"  onFocus='fun_Focus(this)' onBlur="han_check(this,'A');" dataformat="engup"></td>
									<td colspan="2" style="padding-right:0;"><input name="vndr_commoodity_nm" type="text" style="width:100%;"  onFocus='fun_Focus(this)'  maxlength="100"  onBlur="han_check(this,'B');" style="margin-right:0;" dataformat="engup"></td>
								</tr>
							</tbody>
						</table>
				</div>
				</div>
				
				 <div class="layout_vertical_2" style="width:48%">
<div class="opus_design_inquiry">

						<div class="opus_design_btn" style="padding:0;">
							<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
							<button type="button" class="btn_accent" name="btn_retrieve2" id="btn_retrieve2">Retrieve</button>
						</div>
						<!-- opus_design_btn(E) -->
					    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
				    <table>
				        <tbody>
				        	<colgroup>
								<col width="110"/>
								<col width="130"/>
								<col width="29"/>
								<col width="*"/>
							</colgroup>
							<tr class="h23">
								<th>Rep. Commodity</th>
								<td><input name="rep_cmdt_cd" type="text" value="" style="width:100%;" maxlength="4" onBlur="rep_commodity_check(this);"  onFocus='fun_Focus(this)' dataformat="engup"></td>
								<td><button type="button" class="input_seach_btn" name="" id="" onClick="rep_OnPopupClick();"></button></td>
								<td><input name="rep_cmdt_nm" class="input2" type="text" style="width:100%; margin-right:0!important;" readonly  title="This inputbox cant't write" dataformat="engup"></td>
							</tr>
							<tr class="h23">
								<th>Commodity</th>
								<td><input name="cmdt_cd" type="text" style="width:100%;" maxlength="6"  onBlur="commodity_check(this);"  onFocus='fun_Focus(this)' dataformat="engup"></td>
								<td><button type="button" class="input_seach_btn" name="" id="" onClick="commodity_OnPopupClick()"></button></td>
								<td><input name="cmdt_nm"  class="input2" type="text" style="width:100%; margin-right:0;" readonly  title="This inputbox cant't write" dataformat="engup"></td>
							</tr>
						</tbody>
					</table>
				</div>
				</div>
</div>
</div>
<!-- wrap_search(S) --> <!-- no TAB  -->
<div class="wrap_result">	
	<!-- opus_design_inquiry(S) -->	
	<div class="opus_design_inquiry"> 
		<!-- layout_wrap (S) -->	
		<div class="layout_wrap">
			<!--  LEFT (S) -->
		    <div class="layout_vertical_2" style="width:48%;">
				<!-- layout_wrap : inquiry 01 (S) -->	
				
				<!-- layout_wrap : inquiry 01 (E) -->	
				
				<!-- opus_design_grid 01 (S) -->
				<div class="opus_design_grid">
				    			
				    <!-- opus_grid_btn(S) -->
					<div class="opus_design_btn"><!-- 
						 --><button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
						 --><button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button>
					</div>
					<!-- opus_grid_btn(E) -->

				    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
				    <script type="text/javascript">ComSheetObject('sheet1');</script>
				    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
				</div>
				<!-- opus_design_grid 01 (E) -->	
				<!-- opus_design_grid 02 (S) -->
				<div class="opus_design_grid">
				    			
				    <!-- opus_grid_btn(S) -->
					<div class="opus_design_btn"><!-- 
						 --><button type="button" class="btn_normal" name="btng_save2" id="btng_save2">Save</button><!-- 
						 --><button type="button" class="btn_normal" name="btng_update2" id="btng_update2">Delete</button><!-- 
					 --></div>
					<!-- opus_grid_btn(E) -->

				    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
				    <script type="text/javascript">ComSheetObject('sheet2');</script>
				    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
				</div>
				<!-- opus_design_grid 02 (E) -->				
			</div>
		    <div class="layout_vertical_2 align_center" style="width:4%;">
				<img src="/opuscntr/img/img_arrow.gif" style="position:relative; top:300px;">
		    </div>
		    <div class="layout_vertical_2" style="width:48%">
				<!-- layout_wrap : inquiry 02 (S) -->
				
				<!-- layout_wrap : inquiry02 (E) -->	
				<!-- opus_design_grid 03 (S) -->
				<div class="opus_design_grid">
				    <!-- opus_grid_btn(S) -->
					<div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btng_apply" id="btng_apply">Apply</button>
					</div>
					<!-- opus_grid_btn(E) -->
				    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
				    <script type="text/javascript">ComSheetObject('sheet3');</script>
				    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
				</div>
				<!-- opus_design_grid(E) -->
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet4');</script>
				</div>
				<!-- opus_design_grid 03 (E) -->
		    </div>	
		</div>
		<!-- layout_wrap (E) -->	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<!-- wrap_search(E) -->
<div class="header_fixed"></div>
</div></form>
