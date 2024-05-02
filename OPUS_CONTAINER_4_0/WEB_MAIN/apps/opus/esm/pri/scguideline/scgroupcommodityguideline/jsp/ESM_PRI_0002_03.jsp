<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0002_03.jsp
 *@FileTitle  : Commodity Group Guideline Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri000203Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.framework.component.util.code.CodeUtil"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000203Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	//int rowCount   = 0;                       //count of DB resultSET list
	
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] strCust_nm  = new String[4];
	
	//Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGroupCommodityGuideline");
	ArrayList<CodeInfo> custList = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri000203Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		 
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		custList = (ArrayList<CodeInfo>)CodeUtil.getInstance().getCodeSelect("CD01714", 0);
		
		if (custList != null && custList.size() > 0) {
			for (int i = 0; i < custList.size(); i++) {
				CodeInfo row = custList.get(i);
				strCust_nm[i] = row.getName();
				
			}
		}
	}catch(Exception e) {
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />


<input type="hidden" name="svc_scp_cd" value="" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="" id="gline_seq" />
<input type="hidden" name="prc_cust_tp_cd" value="N" id="prc_cust_tp_cd" />
<input type="hidden" name="grp_cmdt_seq" value="" id="grp_cmdt_seq" />
<input type="hidden" name="cd" value="" id="cd" />
<input type="hidden" name="yn_data" value="N" id="yn_data" />

<div class="opus_design_title clear">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>


<div class="opus_design_inquiry" style="width:650px;margin-top:-25px;">
	<table>
		<colgroup>
			<col width="40px" />
			<col width="10px" />
			<col width="550px" />
			<col width="*" />
		</colgroup>
		<tr>
			<th class="sm">Customer Type</th>
			<td class="sm"></td>
			<td class="sm">
				<input type="radio" name="prc_cust_cd" class="trans" checked><span id="cust_tp1"> <%= strCust_nm[0]%></span>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="prc_cust_cd"  class="trans"><span id="cust_tp2">  <%= strCust_nm[1]%></span>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="prc_cust_cd"  class="trans"><span id="cust_tp3">  <%= strCust_nm[2]%></span>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="prc_cust_cd"  class="trans"><span id="cust_tp4">  <%= strCust_nm[3]%></span>&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td></td>
		</tr>
	</table>
</div>


<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2" style="width:27%;">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
    
   <div class="layout_vertical_2" style="width: 3%; text-align: center; margin-top: 170px;">
        <button type="button" class="btn_right"></button>	
   </div>
		    
    <div class="layout_vertical_2" style="width:70%;">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
</div>
<!-- layout_wrap(E) -->

<div class="opus_design_grid" id="sheetHidden" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
</form>
