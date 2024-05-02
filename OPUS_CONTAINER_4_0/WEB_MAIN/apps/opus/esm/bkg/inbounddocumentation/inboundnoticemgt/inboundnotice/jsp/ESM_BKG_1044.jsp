<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1044.jsp
*@FileTitle  : Add Concerned Party
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1044Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%

	String cust_cnt_cd = JSPUtil.getNull(request.getParameter("cust_cnt_cd"));
	String cust_seq = JSPUtil.getNull(request.getParameter("cust_seq"));
	String cust_nm = JSPUtil.getNull(request.getParameter("cust_nm"));
	String ofc_cd  = JSPUtil.getNull(request.getParameter("ofc_cd"));

	EsmBkg1044Event event = null;
	Exception serverException   = null;	

	String strErrMsg = "";
	try 
	{
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	   	event = (EsmBkg1044Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) 
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}
	catch(Exception e) 
	{
		out.println(e.toString());
	}

%>

<script type="text/javascript">
    function setupPage()
    {  
	    loadPage();
    }
</script>

<form name="form"> 
<input type="hidden" name="f_cmd" value="" id="f_cmd" />
<input type="hidden" name="office" value="<%=ofc_cd%>" id="office" />
<input type="hidden" name="origin_cust_seq" value="<%=cust_seq%>" id="origin_cust_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Add Concerned Party</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Save" 			id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" 			id="btn_Close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>				
				<col width="70"/>
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr class="h23">
					<th>Customer</th>
					<td>
						<input type="text" style="width:25px;" class="input2" value="<%=cust_cnt_cd%>" name="cust_cnt_cd" readonly id="cust_cnt_cd" /><!-- 
						 --><input type="text" style="width:60px;" class="input2" value="" name="cust_seq" readonly id="cust_seq" /><!-- 
						 --><input type="text" style="width:300px;" class="input2" value="<%=cust_nm%>" name="cust_lgl_eng_nm" readonly id="cust_lgl_eng_nm" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 			id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Add" 			id="btn_Add">Add</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_Delete" 			id="btn_Delete">Delete</button>		
		</div>
		<!-- opus_design_btn(E) -->		
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->	
	
</div>
</form>