<%--
=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0077.jsp
*@FileTitle  : Exception Ack Rail Road
*@author     : CLT
*@version    : 1.0
*@since      : 2016/04/19
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
	Exception					serverException		= null;			
	String						strErrMsg			= "";	
	try {
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
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
      	}	  
		loadPage();
  	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<div class="page_title_area clear">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<div class="opus_design_btn">			
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--		
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--		
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100">
				<col width="130">
				<col width="*">
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>Rail Road</th>
					<td><script type="text/javascript">ComComboObject('sel_railroad',2, 90 , 1 )</script><!-- 
					 --><input name="rail_road_name" type="text" style="width:272px;" readonly class="input2" id="rail_road_name" />
					 </td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_rowadd" 	id="btng_rowadd">Row Add</button>
			<button type="button" class="btn_accent" name="btng_delete" 	id="btng_delete">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
