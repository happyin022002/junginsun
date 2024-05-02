<!--%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_028.jsp
*@FileTitle : Cost Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*%-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0028Event"%>
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
<input type="hidden" name="lgs_cost_subj_cd1">
<input type="hidden" name="lgs_cost_dtl_cd1">
<input type="hidden" name="command_h">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
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
	<table class="search_in" border="0">
		<tr>
		<th width="40px">Subject Code</th>
		<td width="120px">
			<script language="javascript">ComComboObject('lgs_cost_subj_cd',1, 90 , 0, 1)</script>
		</td>
		<th width="80px" class="align_left">Detail Code</th>
		<td>
			<script language="javascript">ComComboObject('lgs_cost_dtl_cd',1, 90 , 0, 0 )</script>			
		</td></tr>
	</table>
</div>
<!-- 검색영역 -->
</div>

<div class="wrap_result">
<!-- 시트영역 -->
<div class="opus_design_grid">		
	<script language="javascript">ComSheetObject('sheet1');</script>
	<DIV style="display:none">
       <script language="javascript">ComSheetObject('sheet2');</script>
	</DIV>				
</div>
<!-- 시트영역 -->

<h3 class="title_design">Detail Explanation</h3>
	<table class="wFit">
	<tr style="height:30px">
		<td><input type="radio" id="del_flg_y" name="del_flg_y" value="" disabled class="trans"><label for="del_flg_y">Live</label>
		<input type="radio" id="del_flg_n" name="del_flg_n" disabled class="trans"><label for="del_flg_n">Delete</label></td></tr>
	<tr>
		<td><textarea name="txtEvent" style="height:100px;" readonly></textarea>
		</td></tr>
	</table>
</div>
<!-- 데이타영역 -->

</form>
		