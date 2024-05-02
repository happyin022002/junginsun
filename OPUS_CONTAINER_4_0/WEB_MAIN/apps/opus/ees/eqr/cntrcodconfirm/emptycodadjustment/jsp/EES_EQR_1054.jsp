<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_6002.jsp
*@FileTitle : Remark by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1054Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesEqr1054Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";					
	int rowCount	 = 0;					//DB ResultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1054Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">

	function setupPage(){
		
		document.form.vessel_remark.value = ComGetEtcData(document.form.xml.value, "vesselremark");
		
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
	//	loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" >
<input type="hidden" name="div"  value="S">
<input type="hidden" name="xml"  value="<%=xml%>">
<input type="hidden" name="row" value="<%=StringUtil.xssFilter(request.getParameter("row"))%>">
<input type="hidden" name="weekdivision" value="<%=StringUtil.xssFilter(request.getParameter("weekdivision"))%>">
<input type="hidden" name="vvd" value="<%=event.getEmptyCODVVDVO().getVvd()%>">

		
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Remark by VVD</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
			<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->


<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<!-- inquiry_area(S) -->
	<div class="opus_design_inquiry">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="30%" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td>
						<input type="text" style="width:200" value="WK:<%=event.getEmptyCODVVDVO().getWeek()%>,   <%=event.getEmptyCODVVDVO().getLane()%>/ <%=event.getEmptyCODVVDVO().getVvd()%>" class="input2">
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->


	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<!-- opus_grid_design_btn(S) -->
		<div class="opus_design_grid">
			<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
				<td align="center"><b>Vessel Schedule Remark</b></td>
				</tr>
				<tr>
				<td><textarea style="width:100%" rows="5" class="textarea" name="vessel_remark"  disabled></textarea></td>
				</tr>
			</table> 
       		<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
				<td align="center"><b>Note</b></td>
				</tr>
				<tr>
				<td><textarea style="width:100%" rows="7" class="textarea" name="remark"><%=event.getEmptyCODVVDVO().getRemark()%></textarea></td>
				</tr>
			</table> 
			
		</div>
		
		
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- popup_contens_area(E) -->




</form>