<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_COA_0137.jsp
*@FileTitle  : Node/Link U/C Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	String pageRows  = "100";

	Logger log = Logger.getLogger("com.clt.apps.StdUnitCost.CostStructure");

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
	var combo01Text = "=|>|>=|<|<=|<>|LIKE|NOT LIKE|IN";
	var combo01Code = "=|>|>=|<|<=|<>|LIKE|NOT LIKE|IN";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		
		sheetObjects[0].SelectCell(2, 3);
	}
</script>
<form name="form" id="form"> 
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_reset"  		id="btn_reset">New</button><!--SJH.20141223.MOD--><!--
		--><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_creation" 	id="btn_creation">Creation</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_loadexcel" 	id="btn_loadexcel">Load Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<tr class="h23">
						<th width="30px;" ><%//<img class="nostar">%>Node / Link Cost</th>
	                     <td>
							<select name="f_table_name" id="f_table_name" class="input1" style='width:200px;' onChange="changeTableName()">
								<OPTION value='COA_NOD_AVG_STND_COST'>Node Cost</OPTION>
								<OPTION value='COA_LNK_AVG_STND_COST'>Link Cost</OPTION>
							</select>
	                      </td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- layout_wrap (S) -->
	 <div class="layout_wrap">
	     <div class="layout_vertical_2" style="width:40%;" id="mainTable" name="mainTable">
	         <!-- opus_design_grid(S) -->
	         <h3><img src="/opuscntr/img/ico_star.gif" border="0" hspace="5">Condition Input</h3>
	         <div class="opus_design_grid">
	             <script type="text/javascript">ComSheetObject('sheet1');</script>
	         </div>
	         <!-- opus_design_grid(E) -->
	     </div>
	     <div class="layout_vertical_2" style="width:59%;float: right !important; padding-top:22px;">
	         <!-- opus_design_grid(S) -->
	         <div class="opus_design_grid"  id="mainTable" name="mainTable">
	    		<script type="text/javascript">ComSheetObject('sheet2');</script>
	         </div>
	         <!-- opus_design_grid(E) -->
	     </div>
	 </div>
	<!-- layout_wrap (E) -->

	 <!-- opus_design_grid(S) -->
	 <div class="opus_design_grid" id="mainTable" name="mainTable">
	    <!-- SJH.20141222.ADD : 200 LINE 없애기. -->
	    <!--<span><img src="/opuscntr/img/ico_star.gif" border="0" hspace="5">Maximum to retrieve is 10,000 rows and Maximum to save is 200 rows.</span>-->
	    <span><img src="/opuscntr/img/ico_star.gif" border="0" hspace="5">Maximum to retrieve is 10,000 rows.</span>
      	<div class="opus_design_btn">
	      <button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button>
	      <button type="button" class="btn_normal" name="btng_rowdel" id="btng_rowdel">Row Del.</button>
   		</div>
	    <script type="text/javascript">ComSheetObject('sheet3');</script>
	 </div>
	 <!-- opus_design_grid(E) -->
 </div>
</form>