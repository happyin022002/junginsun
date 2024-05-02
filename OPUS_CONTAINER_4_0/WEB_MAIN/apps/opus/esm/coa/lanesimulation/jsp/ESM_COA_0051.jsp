<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0051.js
*@FileTitle  : LaneSimulation Step1 >> Vessel Register (Service Lane & Deployed Vessels Setting)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0051Event"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%
  	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    EsmCoa0051Event event     = null;	//PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg 	 = "";          //에러메세지
    String xml = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.lanesimulation.EsmCoa0051");

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
	      event = (EsmCoa0051Event)request.getAttribute("Event");
	      xml = HttpUtil.makeXML(request,response); 
          xml = xml.replaceAll("\"", "'");
        } 
    }catch(Exception e) {
        log.error("ESM_COA_0051.jsp Exception : " + e.toString());
        out.println(e.toString());
    }
%>


<script type="text/javascript">
<!--
    function setupPage(){
	    var errMessage    = "<%= strErrMsg %>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
-->
</script>
<iframe height="0" width="0" name="frmHidden"></iframe>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="f_dept_cd_1" value="" id="f_dept_cd_1" />
<input type="hidden" name="usr_id" value="" id="usr_id" />
<input type="hidden" name="f_txtTmp" id="f_txtTmp" />
<!--input type="hidden" name="vcd_count"--> <!-- vcd_count  -->
<input type="hidden" name="f_vsl_cd" id="f_vsl_cd" />
<input type="hidden" name="f_srow" id="f_srow" />
<input type="hidden" name="f_trd_cd" id="f_trd_cd" />
<input type="hidden" name="f_flag" id="f_flag" />
<input type="hidden" name="f_skd_dir_cd" id="f_skd_dir_cd" />
<input type="hidden" name="f_sect_no" id="f_sect_no" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_filemgmt" id="btn_filemgmt" type="button">File Mgmt</button><!--
		--><button class="btn_normal" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="10" />
			<col width="100" />
			<col width="100" />
			<col width="10" />
			<col width="100" />
			<col width="100" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr class="h23">
                <td><input type="radio" class="trans" name="f_ext_flg" value="N" onclick="javascript:viewBtn();" id="f_ext_flg" /> New Lane </td>
                <td><input type="radio" class="trans" name="f_ext_flg" value="Y" checked="" onclick="javascript:viewBtn();" id="f_ext_flg" /> Existing Lane  </td>
                <th>S/Lane</th>
                <td width="84" style="text-indent:2;"><script type="text/javascript">ComComboObject('f_slan_cd', 1, 80 , 0 )</script></td>
                <td width="84">
                	<div id="div_dept">
                	<script type="text/javascript">ComComboObject('f_dept_cd2',1, 80 , 0 )</script>
                	</div>
                </td>
                <td>
                	<div id="div_simNo">
                	<script type="text/javascript">ComComboObject('f_sim',1, 200 , 0 )</script>
                	</div>
                </td>
            </tr>
            <tr class="h23">
                <th>Simulation No.</th>
                <td>
                    <input type="text" style="width:30px;" name="f_dept_cd" maxlength="3" readonly="" class="input2" id="f_dept_cd" />
                    <input type="text" style="width:75px;" name="f_sim_dt" dataformat="ymd" maxlength="8" readonly="" class="input2" id="f_sim_dt" />
                    <input type="text" style="width:30px;" name="f_sim_no" maxlength="3" readonly="" class="input2" id="f_sim_no" />
                    <input type="text" style="width:180px;" name="f_usr_id" readonly="" class="input2" id="f_usr_id" />
                </td>
                <th>Remark</th>
                <td colspan = "3">
                    <input type="text" style="width:384px;" name="f_sim_rmk" id="f_sim_rmk" />
                </td>
            </tr>
            <tr class="h23">
            	<th>Working Steps</th>
            <tr>
            	<th>&nbsp;</th>
                <td><img class="cursor" src="img/opus/cost_step01_on.gif" border="0" name="step01"></td>
                <td><img class="cursor" src="img/opus/cost_step02.gif" border="0" name="step02"></td>
                <td><img class="cursor" src="img/opus/cost_step03.gif" border="0" name="step03"></td>
                <td><img class="cursor" src="img/opus/cost_step04.gif" border="0" name="step04"></td>
            </tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<h3 class=“title_design”>Service Lane & Deployed Vessels Setting</h3>
<div class="opus_design_grid">
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_lane" id="btn_lane" type="button">Lane Info. I/F</button><!--
		--><button class="btn_normal"  onClick="javascript:setVesselInfo1();" type="button">Reset Sub Trade</button><!--
		--><button class="btn_normal" name="btn_rowadd1" id="btn_rowadd1" type="button">Row Add</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_secdel" id="btn_secdel" type="button">Sect Del</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<table>
	<colgroup>
		<col width="10" />
		<col width="100" />
		<col width="100" />
		<col width="*" />
	</colgroup>
	<tbody>
		<tr class="h23">
            <td width="70%">
                <input type="radio" value="0" class="trans" name="radCode" checked="" id="radCode" />
                <input type="radio" value="1" class="trans" name="radCode" id="radCode" />
            </td>
			<td width="5%" align="right" valign="bottom" style="padding-right:3;">
		        <div id="div_zoom_in1" style="display:inline"> <!-- absolute / relative -->
				<img class="cursor" src="img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out1" style="display:none">
				<img class="cursor" src="img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
				</div>
			</td>
       	</tr>
	</tbody>
</table>
<!-- opus_design_grid(E) -->
<div class="opus_design_grid">
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_lane" id="btn_lane" type="button">VSL & BSA I/F</button><!--
		--><button class="btn_normal"  onClick="javascript:setVesselInfo2();" type="button">Set VSL Info.</button><!--
		--><button class="btn_normal" name="btn_rowadd1" id="btn_rowadd1" type="button">Row Add</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<script type="text/javascript">ComSheetObject('s1sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
