<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0744.jsp
*@FileTitle  : Direct NVO AMS File No
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event.VopScg5921Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg5921Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String caFlg = "";
	String bdrFlg = "";
	
	//parameter
	String portCd = "";
	String portNm = "";
	String portLmtSeq = "";
	String lmtWgtTpCd = "";
	String lmtWgtTpNm = "";
	//String portLmtRepDesc = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopScg5921Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		portCd = JSPUtil.getParameter(request, "port_cd");
		portLmtSeq = JSPUtil.getParameter(request, "port_lmt_seq");
		lmtWgtTpCd = JSPUtil.getParameter(request, "lmt_wgt_tp_cd");
		//portLmtRepDesc = JSPUtil.getParameter(request, "port_lmt_rep_desc");
		
		if("SGSIN".equals(portCd)){
			portNm = "Singapore";
		}else if("SAJED".equals(portCd)){
			portNm = "Jeddah";
		}else if("FRLEH".equals(portCd)){
			portNm = "Le Havre";
		}else if("CNSHA".equals(portCd)){
			portNm = "Shanghai";
		}
		
		if("GR".equals(lmtWgtTpCd)){
			lmtWgtTpNm = "GROSS";
		}else if("NT".equals(lmtWgtTpCd)){
			lmtWgtTpNm = "NET";
		}else if("NP".equals(lmtWgtTpCd)){
			lmtWgtTpNm = "NET POWDER";
		} else {
			lmtWgtTpNm = lmtWgtTpCd;
		}
		//System.out.println(">>>>>>>>>>>portLmtSeq >"+portLmtSeq);
		//portLmtRepDesc = portLmtRepDesc.replaceAll("\\n", "<br>");
		//System.out.println(">>>>>>>>>>>portLmtRepDesc >"+portLmtRepDesc);
		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="port_cd" id="port_cd" value="<%= portCd%>" />
<input type="hidden" name="port_lmt_seq" id="port_lmt_seq" value="<%= portLmtSeq%>" /> 
<input type="hidden" id="lmt_wgt_tp_cd" value="<%=lmtWgtTpCd%>" />
<!-- Developer Work	-->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Port Limits Class</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!-- 
		--></div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">

	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table>
				<tbody>
				<colgroup>
					<col width="90" />
					<col width="100" />
					<col width="90" />
					<col width="*" />					
				</colgroup>
					<tr>
						<th>Port Name</th>
						<td><input type="text" id="port_nm" value="<%=portNm%>" class="input" readonly></td>
						<th>Entry Type</th>
						<td><input type="text" id="lmt_wgt_tp_nm" value="<%=lmtWgtTpNm%>" class="input" readonly ></td>						
					</tr>
					<tr>
						<th>Rep. Desc</th>
						<%--<td colspan=3><input type="text" name="portLmt_rep_desc" value="<%=portLmtRepDesc%>" style="width:352px;text-align:left;" class="input" readonly></td>--%>
						<td colspan=3><textarea  rows="4" style="width:100%;resize:none;" name = "portLmtRepDesc" id="portLmtRepDesc" maxlength="1500" style="ime-mode:active"><%//=portLmtRepDesc%></textarea></td> 
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- opus_design_grid(S) -->
	<div class="opus_design_inquiry wFit">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical" style="padding-right:20px;">
			    <div class="layout_vertical_2" >
			    	<div id="mainTable" style="padding-left:30px">
						<!-- opus_grid_btn(S) -->
						<div class="opus_design_btn">
							<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Add</button><!-- 
		 					--><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button><!-- 
							--><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Del</button>
						</div>
						<!-- opus_grid_btn(E) -->				    	
			    		<script type="text/javascript">ComSheetObject('sheet1');</script>
			    	</div>
			    </div>
			    <div class="layout_vertical_2">
			    	<div id="mainTable" style="padding-left:60px;">
						<!-- opus_grid_btn(S) -->
						<div class="opus_design_btn">
							<button type="button" class="btn_normal" name="btn_RowAdd2" id="btn_RowAdd2">Add</button><!-- 
		 					--><button type="button" class="btn_normal" name="btn_copy2" id="btn_copy2">Copy</button><!-- 
							--><button type="button" class="btn_normal" name="btn_Delete2" id="btn_Delete2">Del</button>
						</div>
						<!-- opus_grid_btn(E) -->
			    		<script type="text/javascript">ComSheetObject('sheet2');</script>
			    	</div>
			    </div>
			</div>
		</div>
	</div>
	
	<div class= "wrap_result" style="display:none">
		<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>	
</div>
<!-- wrap_search(E) -->
<%--
<div class="wrap_result">
	<div class="opus_design_grid" >
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button>
		</div>
		<!-- opus_grid_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
</div> --%>

</form>
