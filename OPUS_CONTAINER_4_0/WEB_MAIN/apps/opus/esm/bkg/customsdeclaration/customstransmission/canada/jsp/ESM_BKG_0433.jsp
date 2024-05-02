<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0433.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%

	String rcvMsgTpId= JSPUtil.getNull(request.getParameter("rcvMsgTpId"));
	String vvdCd=JSPUtil.getNull(request.getParameter("vvdCd"));
	String polCd=JSPUtil.getNull(request.getParameter("polCd"));
	String podCd=JSPUtil.getNull(request.getParameter("podCd"));
	String blNo=JSPUtil.getNull(request.getParameter("blNo"));
	String rcv_dt=JSPUtil.getNull(request.getParameter("rcv_dt"));
	String rcv_seq=JSPUtil.getNull(request.getParameter("rcv_seq"));
	
	try {
	
	}catch(Exception e) {
		out.println(e.toString());
	}

 %>
<script type="text/javascript">
	function open_rcv_file(){
	
		var param = "/opuscntr/ESM_BKG_0434.do" 
		+ "?pgmNo=ESM_BKG_0434&cnt_cd=CA&io_bnd_cd=I"
		+ "&rcv_dt=" + "<%=rcv_dt%>"
		+ "&rcv_seq=" +  "<%= rcv_seq%>"
		+ "&rcvMsgTpId=" + "<%= rcvMsgTpId%>"
		+ "&vvdCd=" + "<%= vvdCd%>"
		+ "&polCd=" + "<%= polCd%>"
		+ "&podCd=" + "<%= podCd%>"
		+ "&blNo=" + "<%= blNo%>" ;
		
		ComOpenWindowCenter(param, "0434", 600, 500, false);
	}
</script>
<form name="form">


<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Canada ACI: View MSG</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			    <button type="button" class="btn_accent" name="btn_view" id="btn_view" onclick="open_rcv_file()">View Received File</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close" onClick="ComClosePopup();">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
		
<input type="hidden" name="rcv_msg_tp_id" value="<%= rcvMsgTpId%>">
<input type="hidden" name="rcv_dt" value="<%= rcv_dt%>">
<input type="hidden" name="rcv_seq" value="<%=rcv_seq %>">
<input type="hidden" name="vvd_cd" value="<%= vvdCd%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="pod_cd" value="<%= podCd%>">
<input type="hidden" name="bl_no" value="<%= blNo %>">
		
			<table> 
				<colgroup>
					<col width="80">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>997</th>
						<td>
								<input type="text" style="width: 25px" value="<%=StringUtil.xssFilter(request.getParameter("p1"))%>" class="input"><!-- 
								 --><input type="text" style="width: 360px" value="<%=StringUtil.xssFilter(request.getParameter("p2"))%>" class="input">
						</td>
					</tr>
					<tr>
						<th>824</th>
						<td>
							<input type="text" style="width: 25px" value="<%=StringUtil.xssFilter(request.getParameter("p3"))%>" class="input"><!-- 
							 --><input type="text" style="width: 360px" value="<%=StringUtil.xssFilter(request.getParameter("p4"))%>" class="input">
						</td>
					</tr>
					<tr>
						<th>Error Note</th>
						<td><textarea style="width: 390px; height: 70px"><%=StringUtil.xssFilter(request.getParameter("p5"))%></textarea></td>
					</tr>
					<tr>
						<th>Reject Code</th>
						<td><input type="text" style="width: 50px" value="<%=StringUtil.xssFilter(request.getParameter("p6"))%>" class="input"></td>
					</tr>
					<tr>
						<th>Field Desc.</th>
						<td><textarea style="width: 390px; height: 70px"><%=StringUtil.xssFilter(request.getParameter("p7"))%></textarea></td>
					</tr>
					<tr>
						<th>Message Text</th>
						<td><textarea style="width: 390px; height: 70px"><%=StringUtil.xssFilter(request.getParameter("p8"))%></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</form>