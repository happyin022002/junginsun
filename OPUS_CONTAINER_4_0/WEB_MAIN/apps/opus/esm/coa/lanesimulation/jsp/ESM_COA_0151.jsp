<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0151.jsp
*@FileTitle  : LaneSimulation >> Step3 >> Tap3 >> Consumption Matrix by Class(popup)
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
<%@ page import="com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0151Event"%>
<%
    EsmCoa0151Event  event = null;     //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null; //서버에서 발생한 에러
    String strErrMsg    = "";           //에러메세지
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.lanesimulation.ESM_COA_0151");

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsmCoa0151Event)request.getAttribute("Event");
        } // end else
      
    }catch(Exception e) {
        log.error("ESM_COA_151 Exception : "+e.toString());
        out.println(e.toString());
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
<form name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="f_slan_cd" value="<%= JSPUtil.getNull(request.getParameter(" f_slan_cd"))=""  %>" id="f_slan_cd" />
<input type="hidden" name="f_sim_dt" value="<%= JSPUtil.getNull(request.getParameter(" f_sim_dt"))=""  %>" id="f_sim_dt" />
<input type="hidden" name="f_sim_no" value="<%= JSPUtil.getNull(request.getParameter(" f_sim_no"))=""  %>" id="f_sim_no" />
<input type="hidden" name="f_vsl_clss_capa" value="<%= JSPUtil.getNull(request.getParameter(" f_vsl_capa"))=""  %>" id="f_vsl_clss_capa" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Create Consumption Matrix By Class</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent"  type="button" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!-- 
		 --><button class="btn_normal"  type="button" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="120">
					<col width="*">
				</colgroup>
				<tr>
                    <th>Vessel Class</th>
                    <td>
                    	<script type="text/javascript">ComComboObject('cobVslCls', 1, 100 , 0 )</script>
                    </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<table class="line_bluedot"><tr><td></td></tr></table>
<div class="wrap_result">
	<div class="opus_design_grid"  id="mainTable">
		<div class="opus_design_btn">
		     	<button type="button" class="btn_normal" id="btng_rowadd" name="btng_rowadd">Size Add</button><!-- 
			 --><button type="button" class="btn_normal"  id="btng_save" name="btng_save">Save</button><!-- 
			 --><button type="button" class="btn_normal"  id="btng_sizedel" name="btng_sizedel">Size Del.</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</form>