<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0009.jsp
*@FileTitle : Inland Link Management 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.event.EsdPrd0009Event"%>

<%
	EsdPrd0009Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								  //count of DB resultSET list
	String optStr="|000010: : ";
	 String org_cd = "";
	 String dest_cd = "";
	try {
		event = (EsdPrd0009Event)request.getAttribute("Event");
		if(event != null){
			org_cd   = JSPUtil.getNull(event.getPrdInlndEachLnkVO().getIOrgCd());
			dest_cd   = JSPUtil.getNull(event.getPrdInlndEachLnkVO().getIDestCd());
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("dist_ut_cd", "01", "CD00797", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("rail_crr_tp_cd", "01", "CD00287", 0, optStr)%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
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
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
				<button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
				<button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button>
				<button type="button" class="btn_normal" name="btn_update"   id="btn_update">Update</button>
				<button type="button" class="btn_normal" name="btn_loadexcel"   id="btn_loadexcel">Load Excel</button>
				<button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button>
				
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
	            <col width="130px" />
	            <col width="100px" />
	             <col width="200px" />
	            <col width="100px" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr class="h23">
					<th>Origin</th>
					<td><input class="input1 align_center" name="i_org_cd" id="i_org_cd" maxlength="7" type="text" style="width:130px" value=""  tabIndex="1"  dataformat="engup"><!-- onChange="validateLocation(this.value,1);" 
						--><button type="button" class="input_seach_btn" name="btn_org_loc" id="btn_org_loc"></button>
					</td>
					<th>Destination</th>
					<td><input class="input1 align_center" name="i_dest_cd" id="i_dest_cd" maxlength="7" type="text" style="width:130px" value=""  tabIndex="2"  dataformat="engup"><!-- onChange="validateLocation(this.value,2);" 
						--><button type="button" class="input_seach_btn" name="btn_dest_loc" id="btn_dest_loc"></button>
					</td>
					<th>Agreement No</th>
					<td><input class="align_center"  name="i_agmt_no" id="i_agmt_no" maxlength="9" type="text" style="width:130px" value=""  tabIndex="3" dataformat="engup">
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
	<div class="opus_design_grid">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
	        <button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</form>

<script type="text/javascript">
<!--

	  
	  with(document.form)
	  {
		
		eval("i_org_cd" ).value = "<%=org_cd%>";
		eval("i_dest_cd" ).value = "<%=dest_cd%>";
		
	   }
-->
</script>