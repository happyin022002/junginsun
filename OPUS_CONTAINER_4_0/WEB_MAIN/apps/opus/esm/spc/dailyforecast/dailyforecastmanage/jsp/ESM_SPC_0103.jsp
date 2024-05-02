<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0103.jsp
*@FileTitle  : Account Registration 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String srep_id    = JSPUtil.getParameter(request, "srep_id", "");
	String srep_nm    = JSPUtil.getParameter(request, "srep_nm", "");
	String rlane_cd   = JSPUtil.getParameter(request, "rlane_cd", "");
	String trd_cd     = JSPUtil.getParameter(request, "trd_cd", "");
	String sub_trd_cd = JSPUtil.getParameter(request, "sub_trd_cd", "");
	String bound      = JSPUtil.getParameter(request, "bound", "");
	String rgn_ofc_cd = JSPUtil.getParameter(request, "rgn_ofc_cd", "");
	String sub_ofc_cd = JSPUtil.getParameter(request, "sub_ofc_cd", "");
	String ioc_cd     = JSPUtil.getParameter(request, "ioc_cd", "");
	String acc_tp     = JSPUtil.getParameter(request, "acc_tp", "");
	boolean isChild   = !(srep_id + rlane_cd + trd_cd + sub_trd_cd + bound + rgn_ofc_cd + sub_ofc_cd + ioc_cd + acc_tp).equals("");
	
	EsmSpc0103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.DailyForecast.Dailyforecastmanage");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmSpc0103Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
%>
<script type="text/javascript">
	var ofc_cd     = "<%=ofc_cd%>";
	var srep_id    = "<%=srep_id%>";
	var srep_nm    = "<%=srep_nm%>";
	var rlane_cd   = "<%=rlane_cd%>";
	var trd_cd     = "<%=trd_cd%>";
	var sub_trd_cd = "<%=sub_trd_cd%>";
	var bound      = "<%=bound%>";
	var rgn_ofc_cd = "<%=rgn_ofc_cd%>";
	var sub_ofc_cd = "<%=sub_ofc_cd%>";
	var ioc_cd     = "<%=ioc_cd%>";
	var is_child   = "<%=isChild%>";

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
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
   <% if(isChild){ %>
	<h2 class="page_title"><button type="button"><span>Account Registration</span></button></h2>
	<% } else { %>
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<% } %>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" style="display:<%=isChild?"none":"inline"%>" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" style="display:<%=isChild?"none":"inline"%>" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_rowadd" 	id="btn_rowadd">Row Add</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<% if(!isChild){ %>
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<% } %>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table id="searchCondition" style="display:none;">
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Sales Office</th>
					<td><script type="text/javascript">ComComboObject("rgnOffice", 2, 80, 0, 1);initData_rgnOffice();</script></td>
					<th>Sub-Office</th>
					<td><script type="text/javascript">ComComboObject("subOffice", 2, 80, 0, 1);</script></td>
					<th>Sales Rep</th>
					<td><script type="text/javascript">ComComboObject("salesRep", 4, 80, 0, 1);</script></td>
					<th>IOC</th>
					<td><select name="ioc" id="ioc" class="input1" style="width:80px;"><!--
							--><option value=""></option><!--
							--><option value="O">OCN</option><!--
							--><option value="I">IPC</option><!--
							--><option value="T">TS</option>
						</select>
					</td>				
				</tr>	
				<tr>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject("trade", 2, 80, 0, 1);</script></td>
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject("subTrade", 3, 80, 0, 1, 1);</script></td>
					<th>Lane</th>
					<td><script type="text/javascript">ComComboObject("lane", 4, 80, 0, 1, 2);</script></td>
					<th>Bound</th>
					<td><select name="bound" id="bound" style="width:80px;" class="input1"></select></td>			
					<th>Account Type</th>						
					<td><select style="width:110px;" name="accountType" id="selAccountType">
						  <option value="A">All</option>
						  <option value="B">BCO</option>
						  <option value="N">Non-BCO</option>
						  </select>
					</td>	
				</tr>	
			</tbody>
		</table>
		
		<table id="searchInformation" style="display:none;">
			<tbody>
				<colgroup>
					<col width="40"/>
					<col width="20"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Sales Rep</th>
					<td> : </td>
					<td><span id="search_srep_nm" name="search_srep_nm"></span>&nbsp;[<span id="search_srep_id" name="search_srep_id"></span>]</td>
				</tr>	
				<tr>
					<td>Lane</td>
					<td> : </td>
					<td><span id="search_trd_cd" name="search_trd_cd"></span>&nbsp;/&nbsp;<span id="search_sub_trd_cd" name="search_sub_trd_cd"></span>&nbsp;/&nbsp;<span id="search_rlane_cd" name="search_rlane_cd"></span>&nbsp;/&nbsp;<span id="search_bound" name="search_bound"></span>&nbsp;/&nbsp;<span id="search_ioc_cd" name="search_ioc_cd"></span></td>
				</tr>	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<!-- <div id="tabLayer" style="display:"> -->
	<!-- <div>
		<table class="mar_btm_12">
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="*"/>
				</colgroup>
				 <tr>
					<th>Account Type</th>
					<td><select style="width:110px;" name="accountType" id="selAccountType" onchange="changeAccountType();"><option value="C">Contractor</option><option value="S">Shipper</option></select></td>
				</tr> 
			</tbody>
		</table>
		</div> -->
		<div class="opus_design_grid clear" >
			<%if(isChild){%>
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_ok" 	id="btn_ok">Account Reload</button>
					<button type="button" class="btn_normal" name="btn_close"  id="btn_close">Close</button>
				</div>
			<%}%>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- </div> -->
</div>
<!-- opus_design_grid(E) -->
</form>