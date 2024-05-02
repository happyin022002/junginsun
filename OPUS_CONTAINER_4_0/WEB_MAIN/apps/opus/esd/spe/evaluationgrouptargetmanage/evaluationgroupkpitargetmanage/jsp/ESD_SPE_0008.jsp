<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SPE_0008.jsp
*@FileTitle  : KPI Target 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.event.EsdSpe0008Event"%>
<%@ page import="com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSpe0008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list
	int cnt			 = 0;
	List<SearchEGIdAllListVO> egidList = null;
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EvaluationGroupTargetManage.EvaluationGroupKpiTargetManage");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsdSpe0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		egidList = eventResponse.getRsVoList();
		cnt = egidList.size();
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		loadPage();
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eg_id_form" id="eg_id_form" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn"><button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	<span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />				
				<col width="150" />				
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>EG ID</th>
					<td><!-- 
					 --><select name="eg_id" style="width:180px" onChange="document.form.eg_rhq_cd.value='';document.form.eg_cty_cd.value='';document.form.svc_cate_cd.value='';"><!-- 
					 	--><option value="" selected>&lt;&lt; select &gt;&gt;</option>
						<%					
							for(int j=0; j<cnt; j++){
								SearchEGIdAllListVO vo = egidList.get(j);
								String egId = vo.getEgId();
	
								String sel = null;
								if(j==0){
									sel = "select";
								}else{
									sel = "";
								}
						%><!-- 
					 	--><option value="<%=egId%>" <%=sel%>><%=egId%></option>
						<%}%><!-- 
					 --></select><!-- 
					 --></td>
					<th>Year</th>
					<%
						Calendar cal = Calendar.getInstance();
						java.text.DateFormat df = new SimpleDateFormat("yyyy");
						String year = df.format(cal.getTime());
					%>
					<td><select name="ev_yr" style="width:70px" class="input1"><!-- 
					 --><option value="2007" <% if("2007".equals(year)) out.println("selected"); %>>2007</option><!-- 
					 --><option value="2008" <% if("2008".equals(year)) out.println("selected"); %>>2008</option><!-- 
					 --><option value="2009" <% if("2009".equals(year)) out.println("selected"); %>>2009</option><!-- 
					 --><option value="2010" <% if("2010".equals(year)) out.println("selected"); %>>2010</option><!-- 
					 --><option value="2011" <% if("2011".equals(year)) out.println("selected"); %>>2011</option><!-- 
					 --><option value="2012" <% if("2012".equals(year)) out.println("selected"); %>>2012</option><!-- 
					 --><option value="2013" <% if("2013".equals(year)) out.println("selected"); %>>2013</option><!-- 
					 --><option value="2014" <% if("2014".equals(year)) out.println("selected"); %>>2014</option><!-- 
					 --><option value="2015" <% if("2015".equals(year)) out.println("selected"); %>>2015</option><!-- 
					 --><option value="2016" <% if("2016".equals(year)) out.println("selected"); %>>2016</option><!-- 
					 --><option value="2017" <% if("2017".equals(year)) out.println("selected"); %>>2017</option><!-- 
					 --></select><!-- 
					 --></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="80" />				
				<col width="55" />				
				<col width="70" />				
				<col width="70" />				
				<col width="70" />				
				<col width="70" />				
				<col width="150" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>EG Choicer</th>
					<th>Level 1</th>
					<td><!-- 
					 --><select name="eg_rhq_cd" style="width:124px" onChange="document.form.eg_id.value='';"><!-- 
					 --><option value="" selected>&lt;&lt; select &gt;&gt;</option><!-- 
					 --><option value="NYC">NYC</option><!-- 
					 --><option value="HAM">HAM</option><!-- 
					 --><option value="SHA">SHA</option><!-- 
					 --><option value="SIN">SIN</option><!-- 
					 --></select></td>
					<th>Level 2</th>
					<td><input type="text" name="eg_cty_cd" dataformat="engup" style="width:125px;" value="" maxlength="3" onblur="document.form.eg_id.value='';" id="eg_cty_cd" /> </td>
					<th>Level 3</th>
					<td><select name="svc_cate_cd" style="width:125px" onChange="document.form.eg_id.value='';"><!-- 
					 --><option value="" selected>&lt;&lt; select &gt;&gt;</option><!-- 
					 --><option value="TR"> Truck</option><!-- 
					 --><option value="RL"> Rail</option><!-- 
					 --><option value="CY"> ODCY</option><!-- 
					 --><option value="TM"> Terminal</option><!-- 
					 --><option value="WT"> Water</option><!-- 
					 --><option value="EQ"> EQ M&amp;R</option><!-- 
					 --></select></td>
					<td><input type="radio" name="mapped" value="A" class="trans pad_rgt_4" checked id="mapped" />&nbsp;All&nbsp;&nbsp;<input type="radio" name="mapped" value="Y" class="trans pad_rgt_4 pad_left_4" id="mapped" />&nbsp;Mapped&nbsp;&nbsp;<input type="radio" name="mapped" value="N" class="trans pad_left_4" id="mapped" />&nbsp;Unmapped</td>
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
			<button class="btn_accent" name="btn_save" id="btn_save" type="button">Save</button>
		</div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>