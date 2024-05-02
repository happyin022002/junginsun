<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0354.js
*@FileTitle  : Canada ACI: Location of Goods Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0354Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0354Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0354Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->


	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	    </div>
	    <!-- opus_design_btn(E) -->


	    <!-- page_location(S) -->
	    <div class="location">
	        <span id="navigation"></span>
	    </div>
	    <!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->

	<div class="wrap_search">
		<!-- opus_design_inquiry (S) -->
		<div class="opus_design_inquiry">
		    <table>
		        <colgroup>
		            <col width="40" />
		            <col width="100" />
		            <col width="40" />
		            <col width="100" />
		            <col width="40" />
					<col width="*" />	                        
		        </colgroup>
		        <tbody>
					<tr>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" style="width:50px;" class="input1" name="p_pod_cd" maxlength="5" required="" fullfill="" dataformat="engup" value="" id="p_pod_cd" /></td>
						<th title="Place of Delivery">DEL</th>
						<td><input type="text" style="width:50px;" class="input" name="p_del_cd" maxlength="5" dataformat="engup" value="" id="p_del_cd" /></td>
						<th>HUB</th>
						<td><input type="text" style="width:50px;" class="input" name="p_hub_loc_cd" maxlength="5" dataformat="engup" value="" id="p_hub_loc_cd" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry (E) -->
	</div>

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
		    <div class="opus_design_btn"><!--
		    --><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
		    --><button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button><!--
		    --><button type="button" class="btn_normal" name="btn_RowCopy" id="btn_RowCopy">Row Copy</button><!--
		    --></div>
		    <!-- opus_design_btn(E) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) --> 
	</div>
</form>