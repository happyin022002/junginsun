<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_POPUP_YNC.jsp
*@FileTitle : ESM_BKG_POPUP_YNC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation	
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>

<%
String message = JSPUtil.getParameter(request, "message" , "");
%>

<script type="text/javascript">
	function setupPage(){
	}
</script>


<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>popup title</span></h2>
		
		<div class="opus_design_btn">
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<th colspan="2" class="align_center"><%= message %></th>
					</tr>
					<tr>
							<td class="align_center">
							<button type="button" class="btn_etc" name="btn_Yes" id="btn_Yes" onClick="ComPopUpReturnValue('Y');">Yes</button>
							</td>
							<td class="align_center">
							<button type="button" class="btn_etc" name="btn_No" id="btn_No" onClick="ComPopUpReturnValue('N');">No</button>
							</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
