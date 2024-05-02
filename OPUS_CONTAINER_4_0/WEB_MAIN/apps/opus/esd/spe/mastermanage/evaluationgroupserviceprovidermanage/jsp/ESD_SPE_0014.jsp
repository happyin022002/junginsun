<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SPE_0014.jsp
*@FileTitle  : EG VS S/P
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
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
<%@ page import="com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO"%>
<%@ page import="com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.event.EsdSpe0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSpe0014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.clt.apps.MasterManage.EvaluationGroupServiceProviderManage");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsdSpe0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		egidList = eventResponse.getRsVoList() ;
		cnt=egidList.size();
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
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="eg_id_form" id="eg_id_form" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />
<input type="hidden" name="r_flg" id="r_flg" />

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
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>EG ID</th>
					<td><!-- 
					--><select name="eg_id" style="width:180" onChange="document.form.eg_rhq_cd.value='';document.form.eg_cty_cd.value='';document.form.svc_cate_cd.value='';"><!-- 
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
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="70" />				
				<col width="50" />				
				<col width="70" />				
				<col width="100" />				
				<col width="100" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>EG Choicer</th>
					<th>Level 1</th>
					<td><!-- 
					--><select name="eg_rhq_cd" style="width:124" onChange="document.form.eg_id.value='';"><!-- 
					--><option value="" selected>&lt;&lt; select &gt;&gt;</option><!-- 
					--><option value="NYC">NYC</option><!-- 
					--><option value="HAM">HAM</option><!-- 
					--><option value="SHA">SHA</option><!-- 
					--><option value="SIN">SIN</option><!-- 
					--></select></td>
					<th>Level 2</th>
					<td><input type="text" name="eg_cty_cd" style="width:125px;" value="" maxlength="3" onblur="document.form.eg_id.value='';" id="eg_cty_cd" /> </td>
					<th>Level 3</th>
					<td><select name="svc_cate_cd" style="width:125" onChange="document.form.eg_id.value='';"><!-- 
					--><option value="" selected>&lt;&lt; select &gt;&gt;</option><!-- 
					--><option value="TR"> Truck</option><!-- 
					--><option value="RL"> Rail</option><!-- 
					--><option value="CY"> ODCY</option><!-- 
					--><option value="TM"> Terminal</option><!-- 
					--><option value="WT"> Water</option><!-- 
					--><option value="EQ"> EQ M&amp;R</option><!-- 
					--></select></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<h3 class="title_design">Evaluation Group Mapping VS Service Provider</h3>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" id="btng_rowadd" name="btng_rowadd">Row Add</button><!--
			--><button class="btn_normal" type="button" id="btn_delete" name="btn_delete">Delete</button><!--
			--><button class="btn_normal" type="button" id="btn_save" name="btn_save">Save</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>