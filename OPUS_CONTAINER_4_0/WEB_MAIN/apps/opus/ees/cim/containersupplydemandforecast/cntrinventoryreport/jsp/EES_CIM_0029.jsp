<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0029.jsp
*@FileTitle  : Stock Report (CNTR Data)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>



<%
	EesCim0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCim0029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

    function setupPage(){  

	    loadPage();
    }

</script>



<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="loc_cd" value="<%=event.getInvtOptionVO().getLocCd() %>" id="loc_cd" />
<input type="hidden" name="loc_type_code" value="<%=event.getInvtOptionVO().getLocTypeCode() %>" id="loc_type_code" />
<input type="hidden" name="cntr_tpsz_cd" value="<%=event.getInvtOptionVO().getCntrTpszCd() %>" id="cntr_tpsz_cd" />
<input type="hidden" name="yard_cd" value="<%=event.getInvtOptionVO().getYardCd() %>" id="yard_cd" />
<input type="hidden" name="obj_cntr_tpsz_cd" value="<%=event.getInvtOptionVO().getObjCntrTpszCd() %>" id="obj_cntr_tpsz_cd" />
<input type="hidden" name="lvl" value="<%=event.getInvtOptionVO().getLvl() %>" id="lvl" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Stock Report (CNTR Data)</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Downexcel" 	id="btn_Downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
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
	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
					<th>Total</th>
					<td><input type="text" name="total_cnt" style="width:60px;text-align:right" readonly class="tr_head3" value="" id="total_cnt" />  <input type="text" name="total" style="width:570px;text-align:left" readonly class="tr_head3" value="" id="total" /> </td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>			