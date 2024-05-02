<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SPE_002.jsp
*@FileTitle  : S/P Category 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.event.EsdSpe0002Event"%>
<%@page import=" com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchOfficeCodeAllListVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSpe0002Event  event = null;						//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;					//Error from server
	String strErrMsg = "";								//Error message
	int rowCount	 = 0;								//The count of DB ResultSet list
	int otherRowCount = 0;
	String vndr_seq = "";
	String vndr_abbr_nm ="";
	List<SearchOfficeCodeAllListVO> list = null;
	SearchOfficeCodeAllListVO vo =null;
	try {
		event = (EsdSpe0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");			
		list = eventResponse.getRsVoList();		
		rowCount=list.size();
	} catch(Exception e) {
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

	function setNull() {
	        var sen_nm = eval(document.form.eg_cty_cd);
	        while (0 < sen_nm.options.length){
	            sen_nm.options[0] = null;
	        }
	    }
	
	
	function setSubOption(x){
		setNull();
		var count = 1;
		var eg_rhq_cd = x.options[x.selectedIndex].value;
		values = new Array(count); 
		var index = 0;
		var temp = '';
	<%
	
		if(rowCount>0){
			for(int j=0; j<rowCount; j++){
				vo = list.get(j);					
				String oFc_cd = vo.getOfcCd();
				String rEg_group = vo.getRegGroup();
	%>
			if(eg_rhq_cd == '<%=rEg_group%>'){
					values[index++] = '<%=oFc_cd%>';
					count++;
				}			
	<%		}
		}
	%>
		for(ctr=0;ctr<count;ctr++) {
			document.form.eg_cty_cd.options[ctr]=new Option(values[ctr],values[ctr]); 
		}
}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="150" />				
				<col width="200" />				
				<col width="160" />				
				<col width="*" />		
				<col width="560" />			
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Service Provider Code</th>
					<td><input type="text" name="vndr_seq" dataformat="engup" style="width:130px;" maxlength="6" value="<%=vndr_seq %>" id="vndr_seq" /><button type="button" id="btn_sp" name="btn_sp" class="input_seach_btn"></button></td>
					<th>Service Provider Name</th>
					<td colspan="2"><input type="text" name="vndr_abbr_nm" style="width:100%" value="<%=vndr_abbr_nm %>" readonly id="vndr_abbr_nm" /></td>
		   		</tr>
		   		<tr>
		   			<th>Regional H/Q</th>
					<td><!-- 
					 --><select name="eg_rhq_cd"  style="width:130px" onchange="setSubOption(this)"><!-- 
						 --><option value="" selected>&lt;&lt; select &gt;&gt;</option><!-- 
						 --><option value="NYC">NYC</option><!-- 
						 --><option value="HAM">HAM</option><!-- 
						 --><option value="SHA">SHA</option><!-- 
						 --><option value="SIN">SIN</option><!-- 
					 --></select></td>
					<th>Control Office</th>
					<td><select name="eg_cty_cd"  style="width:135px"><option value="" selected>&lt;&lt; select &gt;&gt;</option></select></td>
					 <td><!-- 
					 --><input type="radio" name="mapped" value="A" class="trans" checked id="mapped" />&nbsp;All&nbsp;&nbsp;<!-- 
					 --><input type="radio" value="Y" name="mapped" class="trans" id="mapped" />&nbsp;Mapped&nbsp;&nbsp;<!-- 
					 --><input type="radio" value="N" name="mapped" class="trans" id="mapped" />&nbsp;Unmapped&nbsp;&nbsp;<!-- 
					 --></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_save" id="btn_save" type="button">Save</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>