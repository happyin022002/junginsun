<%
/*
=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_03.jsp
*@FileTitle  : Commodity Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri000103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] strCust_nm  = new String[4];
	java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo> custList = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();	   
		event = (EsmPri000103Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		custList = (java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo>)com.clt.framework.component.util.code.CodeUtil.getInstance().getCodeSelect("CD01714", 0);
		if (custList != null && custList.size() > 0) {
			for (int i = 0; i < custList.size(); i++) {
				com.clt.framework.component.util.code.CodeInfo row = custList.get(i);
				strCust_nm[i] = row.getName();				
			}
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" value="" type="hidden" />
<input id="gline_seq" name="gline_seq" value="" type="hidden" />
<input id="prc_cust_tp_cd" name="prc_cust_tp_cd" value="N" type="hidden" />
<input id="grp_cmdt_seq" name="grp_cmdt_seq" value="" type="hidden" />
<input id="cd" name="cd" value="" type="hidden" />
<input id="yn_data" name="yn_data" value="N" type="hidden" />

<!-- page_title_area(S) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

<!-- page_title_area(E) -->

<!-- <div class="wrap_search"> -->
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry" style="width:600px;margin-top:-25px;">
	
	
		<table>
			<colgroup>
				<col width="40px" />
				<col width="10px" />
				<col width="500px" />
				<col width="%" />
			</colgroup>
			<tr>
				<th class="sm">Customer Type</th>
				<td class="sm"></td>
				<td class="sm"><input type="radio" name="prc_cust_cd" class="trans" checked><span id="cust_tp1"> <%= strCust_nm[0]%></span><label></label><input type="radio" name="prc_cust_cd"  class="trans"><span id="cust_tp2">  <%= strCust_nm[1]%></span><label></label><input type="radio" name="prc_cust_cd"  class="trans"><span id="cust_tp3">  <%= strCust_nm[2]%></span><label></label><input type="radio" name="prc_cust_cd"  class="trans"><span id="cust_tp4">  <%= strCust_nm[3]%></span></td>
				<td></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->

<!-- </div> -->

<!-- <div class="wrap_result"> -->
	<!-- layout_wrap (S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width: 49%">
		       <!-- opus_design_grid(S) -->
				     <div class="opus_design_grid">
				         <div class="opus_design_btn">
							<button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">CMDT Group Copy</button>
							<button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button>
							<button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Delete</button>
						</div>
						<script type="text/javascript">ComSheetObject('sheet1');</script>
				    </div>
			   <!-- opus_design_grid(E) -->
		    </div>
		    
		    <div class="layout_vertical_2" style="width: 3%; text-align: center; margin-top: 170px;">
		       <button type="button" class="btn_right"></button>				
		    </div>
		    
		     <div class="layout_vertical_2" style="width: 48%">
		         <!-- opus_design_grid(S) -->
				     <div class="opus_design_grid">
				         <div class="opus_design_btn">
							<button type="button" class="btn_normal" name="btn_Add2" id="btn_Add2">Row Add</button>
							<button type="button" class="btn_normal" name="btn_Del2" id="btn_Del2">Delete</button>
						</div>
						<script type="text/javascript">ComSheetObject('sheet2');</script>
				    </div>
			   <!-- opus_design_grid(E) -->
		    </div>
		</div>
	<!-- layout_wrap (E) -->
	<!-- opus_design_grid(S) -->
	     <div class="opus_design_grid" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	    </div>
	<!-- opus_design_grid(E) -->
<!-- </div> -->
</form>