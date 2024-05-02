<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_150.jsp
*@FileTitle  : Continent Pair
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0150Event"%>
<%
    EsmCoa0150Event  event = null;     //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null; //서버에서 발생한 에러
    String strErrMsg    = "";           //에러메세지
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.lanesimulation.EsmCoa0150Event");
		String ibDir = "";
		String ibIOC = "";
		String v_slan_cd = "";

    try {

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsmCoa0150Event)request.getAttribute("Event");
        } // end else
		v_slan_cd     = JSPUtil.getNull(request.getParameter("f_slan_cd"));

    }catch(Exception e) {
        log.error("EsmCoa0150Event Exception : "+e.toString());
    }
%>



<script type="text/javascript">
<!--
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
-->
</script>


<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="dept_cd" id="dept_cd" />
<input type="hidden" name="usr_id" id="usr_id" />
<input type="hidden" name="slan_cd" id="slan_cd" />
<input type="hidden" name="sim_no" id="sim_no" />
<input type="hidden" name="sim_dt" id="sim_dt" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Create Continent Pair Table</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="*" />
					<col width="*" />
					<col width="*" />
					<col width="*" />
					<col width="*" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
                        <th>Simulation No.</th>
                        <td style="padding-left:3">
                            <input type="text" style="width:30px;" name="f_dept_cd" id="f_dept_cd" value="<%= JSPUtil.getNull(request.getParameter("f_dept_cd")) %>" class="noact2" maxlength="3"  readOnly >- <!-- 
                             --><input type="text" style="width:75px;" name="f_sim_dt" id="f_sim_dt" dataformat="ymd" value="<%= JSPUtil.getNull(request.getParameter("f_sim_dt")) %>" class="noact2" maxlength="8" onblur="ComAddSeparator(this);" onFocus="ComClearSeparator(this); this.select();" readOnly><!-- 
                             --><input type="text" style="width:30px;" name="f_sim_no" id="f_sim_no" value="<%= JSPUtil.getNull(request.getParameter("f_sim_no")) %>" class="noact2" maxlength="3" onKeyPress="ComKeyOnlyNumber(window);" onfocus="this.select()" readOnly><!-- 
                             --><input type="text" style="width:75px;" name="f_usr_id" id="f_usr_id" value="<%= JSPUtil.getNull(request.getParameter("f_usr_id")) %>" class="noact2" readOnly>
                            <!-- : 'Simulation No, Description' from (Step_02) -->
                        </td>
						<th>S/Lane</th>
						<td><input type="text" style="width:45px" name="f_slan_cd" id="f_slan_cd"  value="<%= JSPUtil.getNull(request.getParameter("f_slan_cd")) %>" class="noact2" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled" readOnly></td>
						<td></td>
						<th>Revenue Lane</th>
						<td><input type="text" style="width:45px" name="f_rlane_cd" id="f_rlane_cd"  value="<%= JSPUtil.getNull(request.getParameter("f_rlane_cd")) %>" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button><!--
			--></div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>