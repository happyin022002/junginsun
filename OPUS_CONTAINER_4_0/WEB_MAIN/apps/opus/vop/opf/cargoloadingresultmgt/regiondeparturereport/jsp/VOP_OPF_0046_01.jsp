<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0046_01.jsp
*@FileTitle  : RDR Creation ? VSL Mvmt
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004601Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf004601Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.RegionDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf004601Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		if (isInIframe()) {
			$('.header_fixed, .gnb_wrap').hide();
			$('.wrap, .gnb_wrap').css('padding-top', '0px');
		}
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	
	function isInIframe() {
	    try {
	        return window.self !== window.top;
	    } catch (e) {
	        return true;
	    }
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="voy_no" id="voy_no" />
<input type="hidden" name="dir_cd" id="dir_cd" />
<input type="hidden" name="region" id="region" />
<input type="hidden" name="port_cd" id="port_cd" />


	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Row_Add" id="btn_Row_Add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_Row_Insert" id="btn_Row_Insert" type="button">Row Insert</button><!--		
			--><button class="btn_normal" name="btn_Row_Copy" id="btn_Row_Copy" type="button">Row Copy</button><!--
			--><button class="btn_normal" name="btn_Row_Delete" id="btn_Row_Delete" type="button">Row Delete</button><!--
			--><button class="btn_normal" name="btn_ImportVesselMovement" id="btn_ImportVesselMovement" type="button">Import Vessel Movement</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div class="opus_desgin_data">
			<table class="line_bluedot"><tr><td></td></tr></table>
			<table class="search">
				<tbody>
					<colgroup>
						<col width="100px">
						<col width="*">
					</colgroup>
					<tr class="h23">
		          		<th>Next Port ETA</th>
		          		<td><input type="text" name="next_port" id="next_port" style="width:50px;" class="input2" readonly><input type="text" name="eta" id="eta" style="width:110px;" class="input2" readonly></td>
		      		</tr>
		      		<tr class="h23">
		          		<th>Canal</th>
		          		<td><input type="text" name="next_canal" id="next_canal" style="width:50px;" class="input2" readonly><input type="text" name="eta_canal" id="eta_canal" style="width:110px;" class="input2" readonly></td>
		      		</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->

</form>