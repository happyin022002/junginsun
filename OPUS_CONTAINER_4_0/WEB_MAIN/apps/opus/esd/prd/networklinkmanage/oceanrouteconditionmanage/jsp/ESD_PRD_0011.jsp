<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0011.jsp
*@FileTitle :  Calling Terminal Matrix by Lane/Carrier
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.event.EsdPrd0011Event"%>

<%
	EsdPrd0011Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	try {
		event = (EsdPrd0011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
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



<form method="post" name="form" id="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">


	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!-- 
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
	
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="60px" />
	            <col width="100px" />
	            <col width="60px" />
	            <col width="100px" />
	            <col width="60px" />
	            <col width="100px" />
	            <col width="70px" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr class="h23">
					<th>Port</th>
					<td><input class="input1" name="i_port_cd" id="i_port_cd" maxlength="5" type="text" style="width:70px;text-align:center" value="" tabIndex="1"  dataformat="engup" style="text-align:center"><!--
						 <img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_port" id="btn_port"> 
						--><button type="button" class="input_seach_btn" name="btn_port" id="btn_port"></button>
					</td>
					<th>Lane</th>
					<td><input name="i_vsl_slan_cd" id="i_vsl_slan_cd" maxlength="3" type="text" style="width:70px;text-align:center" value="" tabIndex="2"  dataformat="engup" style="text-align:center"><!--
						 <img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_slan" id="btn_slan"> 
						--><button type="button" class="input_seach_btn" name="btn_slan" id="btn_slan"></button>
					</td>
					<th>Carrier</th>
					<td><input name="i_crr_cd" id="i_crr_cd" maxlength="4" type="text" style="width:70px;text-align:center" value="" tabIndex="3"  dataformat="engup" style="text-align:center"><!-- 
						<img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_crr" id="btn_crr">
						 --><button type="button" class="input_seach_btn" name="btn_crr" id="btn_crr"></button>
					</td>
					<th>Terminal</th>
					<td><input name="i_tml_cd" id="i_tml_cd" maxlength="7" type="text" style="width:70px;text-align:center" value="" tabIndex="4"  dataformat="engup" style="text-align:center"><!--
						 <img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_tml" id="btn_tml"> 
						--><button type="button" class="input_seach_btn" name="btn_tml" id="btn_tml"></button>
					</td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
	        <button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_grid(E) -->
</div>	
</form>

<script type="text/javascript">
<!--

	  /*
		displaying values from form input
	  */
	  with(document.form)
	  {
		<%

        if(event != null){
          String i_port_cd   =event.getSearchOceanRouteConditionVO().getIPortCd();
          String i_vsl_slan_cd   =event.getSearchOceanRouteConditionVO().getIVslSlanCd();
          String i_crr_cd   =event.getSearchOceanRouteConditionVO().getICrrCd();
          String i_tml_cd   =event.getSearchOceanRouteConditionVO().getITmlCd();
        %>
        eval("i_port_cd" ).value = "<%= JSPUtil.getNull(i_port_cd)     %>";
        eval("i_vsl_slan_cd" ).value = "<%= JSPUtil.getNull(i_vsl_slan_cd)     %>";
        eval("i_crr_cd" ).value = "<%= JSPUtil.getNull(i_crr_cd)     %>";
        eval("i_tml_cd" ).value = "<%= JSPUtil.getNull(i_tml_cd)     %>";
        <% } %>
	   }
-->
</script>