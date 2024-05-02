<!--%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_027.jsp
*@FileTitle : Cost Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/%-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0027Event"%>
<%
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error Message
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<!--		
	function setupPage(){		
	    var errMessage = "<%=strErrMsg%>";
	    if (errMessage.length >= 1) {
	    	ComShowMessage(errMessage);
	    }

		loadPage();	
	}
	
//-->
</script>

<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="gb" value="ADD">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	     --><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Delete</button><!-- 
	     --><button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search">
<!-- 검색영역 -->
<div class="opus_design_inquiry wFit">		
	<table>
	<colgroup>
      <col width="1" />      
      <col width="50" />
      <col width="120" />
      <col width="50" />
      <col width="165" />
      <col width="*" />
    </colgroup>
	
	<tr class="h23">
		<th><%//<img class="nostar">%> Cost Code</th>
		<td><input type="text" name="lgs_cost_cd" maxlength="6" style="width:100px" class="input1" value="" onKeyUp="autowrite();"></td>
		<th><%//<img class="nostar">%> Full Name</th>
		<td colspan="3"><input class="input1" name="lgs_cost_full_nm" maxlength="50" type="text" style="width:526px" value="" onKeyUp="syncData(this);"></td>
	</tr>
	<tr class="h23">
		<th><%//<img class="nostar">%> Abbr. Name</th>
		<td><input class="input1" name="lgs_cost_abbr_nm" maxlength="20" type="text" style="width:100px" value="" onKeyUp="syncData(this);"></td>
		<th><%//<img class="nostar">%> Output Sequence</th>
		<td><input class="input1" name="lgs_cost_opt_no" maxlength="4" type="text" style="width:60px" value="" onKeyUp="syncData(this);"></td>
		<th><%//<img class="nostar">%>COM Acct. CD</th>
		<td class="stm"><b>COM</b> <script type="text/javascript"> ComComboObject('acct_cd', 1, 85, 1, 1)</script>
			
			<b>Other Carriers</b> <select name="crr_acct_cd" id="crr_acct_cd" style="width:83px;" onChange="syncData(this);">
			<option value=""></option>
			<option value="110911">110911</option>
			<option value="512019">512019</option>
			<option value="512029">512029</option>
			<option value="512039">512039</option>
			<option value="512069">512069</option>
			<option value="512071">512071</option>
			<option value="512119">512119</option>
			<option value="512229">512229</option>
			<option value="512429">512429</option>
			</select></td>
	</tr>
	</table>
</div>
<!-- 검색영역 -->
</div>

<div class="wrap_result">
<!-- 데이타영역 -->
<div class="opus_design_inquiry wFit">

	<table>
      	<tr><td>
			<!-- : ( BKG Information ) (S) -->			
				<h3 class="title_design">Detail Explanation</h3>			
			<table>
			<tr>
				<td><textarea name="lgs_cost_rmk" style="width:100%; height:200px; resize: none;" onKeyUp="syncDataRmk(this);"></textarea></td></tr>
			</table>
			<!-- : ( BKG Information ) (E) -->

			<table class="height_5"><tr><td></td></tr></table>

			<!-- : ( Week ) (S) -->
			<table class="grid2 wFit">
			<tr>
				<th width="100"><%//<img class="nostar">%> Cost Class</th>
				<td width="200"><input type="text" name="lgs_cost_cd_clss_lvl" style="width:130px" value="" readonly></td>
				<th width="100"> Subject Code</th>
				<td width="250"><input type="text" name="lgs_cost_subj_cd" maxlength="2" style="width:130px" value="" readonly></td>
				<th width="100"> Detail Code</th>
				<td>
					<input type="text" name="lgs_cost_dtl_cd" maxlength="4" style="width:130px" value="" readonly>
				</td>
			</tr>
			<tr class="h23">
				<th><%//<img class="nostar">%> User ID</th>
				<td><input type="text" name="cre_usr_id" style="width:130px" value="" readonly></td>
				<th> Registered Date</th>
				<td><input type="text" name="cre_dt" style="width:130px" value="" readonly></td>
				<th> Update Date</th>
				<td>
				<input type="text" name="upd_dt" style="width:130px" value="" readonly>
				</td></tr>
			</table>
			<!-- : ( Week ) (E) -->
		</td></tr>
	</table>
</div>
<!-- 데이타영역 -->

<!-- 시트영역 -->
<div class="opus_design_grid" style="display:none;">	
	<script type="text/javascript">ComSheetObject('sheet');</script>
</div>
<!-- 시트영역 -->
</div>
</form>

