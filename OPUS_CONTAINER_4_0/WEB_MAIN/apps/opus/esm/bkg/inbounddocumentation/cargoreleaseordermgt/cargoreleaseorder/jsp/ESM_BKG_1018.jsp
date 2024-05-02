<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   esm_bkg_1018.jsp
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
  String do_no_t = JSPUtil.getNull(request.getParameter("do_no"));
%>

<script type="text/javascript">
    function setupPage()
    {  
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="old_rmk" id="old_rmk" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Cargo Release Remark</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_Retrieve"  	id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="40">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>D/O No.</th>
		                <td><input type="text" style="width:90px;" class="input" value="<%=do_no_t%>" name="do_no" readonly id="do_no" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_data">
          	<table class="grid_2"> 
	            <tr>
	            	<th>D/O Remark (For Print)</th>
	            </tr>
	            <tr>
	            	<td><textarea style="width:100%;overflow-y:hidden;text-indent:0px;resize:none;"  rows="5" name="do_prn_rmk" id="do_prn_rmk"></textarea></td>
	            </tr>
	        </table>
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>