<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0054.jsp
*@FileTitle  : 항로 Simulation Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0054Event"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
  	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    EsmCoa0054Event  event = null;                				//PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse =  null;
    Exception serverException   = null;            				//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	String xml = "";
	//header
  	String headerCD = "";
    String headerNM = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.lanesimulation.EsmCoa0054Event");

	try {

		event = (EsmCoa0054Event)request.getAttribute("Event");
    	eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			if (eventResponse != null) {
				xml = HttpUtil.makeXML(request,response); 
	            xml = xml.replaceAll("\"", "'");

	            headerCD = eventResponse.getETCData("headerCD");
	            headerNM = eventResponse.getETCData("headerNM");
			} // end if
		} // end else

	}catch(Exception e) {
		log.error("ESM_COA_0054 Exception : "+e.toString());
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<!--
	var f_sim_rpt_noCode = "";
	var f_sim_rpt_noText = "";

    var header = "<%= headerCD %>";
    var headerNM = "<%= headerNM %>";

    //ComShowMessage(header + " : " + headerNM);
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(header, headerNM);
	}
-->
</script>

<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="f_txtTmp" id="f_txtTmp" />
<input type="hidden" name="header" value="<%= headerCD %>" id="header" />
<input type="hidden" name="headerNM" value="<%= headerNM %>" id="headerNM" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span>Simulation Result</span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 			id="btn_downexcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_creation2" 			id="btng_creation2">Creation (Variant Change)</button><!-- 		
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="50" />
					<col width="84" />
					<col width="84" />
					<col width="206" />
					<col width="*" />
				</colgroup>
				<tbody>
					 <tr>
                          <th>S/Lane</th>
                          <td><script type="text/javascript">ComComboObject('f_slan_cd', 1, 80, 0);</script></td>
                          <td><script type="text/javascript">ComComboObject('f_dept_cd2', 1, 80 , 0 )</script></td>
                          <td><script type="text/javascript">ComComboObject('f_sim', 1, 204 , 0 )</script></td>
                          <td><script type="text/javascript">ComComboObject('f_sim_rpt_no', 2, 150, 0);</script></td>
                      </tr>
                       <tr>
                          <th>Simulation No.</th>
                          <td colspan="4">
                              <input type="text" style="width:30px;" name="f_dept_cd" class="input2" maxlength="3" readonly"="" id="f_dept_cd" />
                              <input type="text" style="width:75px;" name="f_sim_dt" dataformat="ymd" maxlength="8" readonly="" class="input2" id="f_sim_dt" />
                              <input type="text" style="width:34px;" name="f_sim_no" class="input2" maxlength="3" onkeydown="onlyNumber(window);" onblur="fillSpace(this, 3, '0', 'left');" onfocus="this.select()" readonly="" id="f_sim_no" />
                          </td>
                      </tr>
				</tbody>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
			<div class="opus_design_grid clear">
				<div class="opus_design_inquiry">
					<table>
						<colgroup>
							<col width="50" />
							<col width="84" />
							<col width="84" />
							<col width="206" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th>Trade</th>
								<td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 66 , 0 )</script></td>
								<td>
									<select style="width:220px;" name="f_searchItem2" id="f_searchItem2" onChange="javascript:chgItem2(this);">
										<option value="0">Voyage PL By All Ships</option>
										<option value="1">Voyage PL By individual Vessel</option>
										<option value="2">Annual PL By All Ships</option>
									</select>
								</td>
								<td class="sm">
									<div id="div_tot_avg">
										<input type="radio" value="0" name="f_voy_view" class="trans" checked id="f_voy_view1" /><label for="f_voy_view1">Total</label><!-- 
										 --><input type="radio" value="1" name="f_voy_view" class="trans" id="f_voy_view2" /><label for="f_voy_view2">AVG PER VOY</label>
									</div>
									<div id="div_vessel">
										<script type="text/javascript">ComComboObject('f_vsl_cd', 1, 80, 0);</script>
									</div>
								</td>
								<td>
									<div id="" style="display:inline;border:none;width:130;height:16">
									<input type="radio" value="0" name="f_kor_eng" class="trans" onclick="javascript:chgHeader('0');" checked id="f_kor_eng1" /><label for="f_kor_eng1">KOR</label>
									<input type="radio" value="1" name="f_kor_eng" class="trans" onclick="javascript:chgHeader('1');" id="f_kor_eng2" /><label for="f_kor_eng2">ENG</label>
									</div>
								</td>
								<td align="right" valign="bottom" style="padding-right:3;">
							        <div id="div_zoom_in1" style="display:inline"> <!-- absolute / relative -->
									<img class="cursor" src="img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
									</div>
									<div id="div_zoom_out1" style="display:none">
									<img class="cursor" src="img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
									</div>
								</td>
							</tr>
						</tbody>
					</tbody>
				</table>
			</div>
			<div class="opus_design_btn">
				<span id="div_zoom_in1" style="display:inline"></span><button type="button" class="btn_down" name="bu_zoom_in1" 		id="bu_zoom_in1" alt="Zoom in(+)"></button><!-- 
				 --><span  id="div_zoom_out1" style="display:none"></span><button type="button" class="btn_up" name="bu_zoom_out1" 			id="bu_zoom_out1"></button><!-- 
			 --></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>				




</form>