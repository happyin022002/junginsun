<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : ESM_BKG_1056.jsp
*@FileTitle : ESM_BKG_1056
*@author : CLT
*@version : 1.0
*@since : 2014.04.23
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	//"typecode : FM, TO"
	String typecode = request.getParameter("typecode");
	String fmSelect = "";
	String toSelect = "";
	if("FM".equals(typecode)) fmSelect = "selected";
	if("TO".equals(typecode)) toSelect = "selected";
%>

<script type="text/javascript">
    function setupPage()
    {  
	    loadPage();
	    document.getElementById("title").innerHTML = " Container Loading List_Summary_SPP List";
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="typecode" value="<%=typecode %>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<span id="title"></span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
</div>
<!-- page_location(E) -->
<!-- 검색영역 -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
		  		<col width="50"></col>
		  		<col width="*"></col>	  		
		  	</colgroup>
			<tbody>			
				<tr>
					<th>Entry Type</th>
					<td width="">
						<select style="width:55px;" class="input" name="entryTp" id="entryTp" onchange="javascript:funcSetDefault();"><!-- 
								 --><option value="" >All</option><!-- 
								 --><option value="TO" <%=toSelect %>>TO</option><!-- 
								 --><option value="FM" <%=fmSelect %>>FM</option><!-- 
							 --></select>
					</td>					
				</tr>					
			</tbody>
		</table>
	</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
	<div class="opus_design_grid">	
		<div class="opus_design_btn">
		   <button type="button" class="btn_normal" name="btn_Add">Row Add</button><!-- 
		    --><button type="button" class="btn_normal" name="btn_Delete">Row Delete</button><!-- 
		 --></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- 시트영역 -->
</form>					