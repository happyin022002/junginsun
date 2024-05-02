<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0716.jsp
*@FileTitle  : BB Cargo Split 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0716Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%
	EsmBkg0716Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkg_no		= "";
	String strSplit_Reason  = "";
	String strSplitCntrSplitNo = "";
	String strLastSplitNo = "";
	String strOrgSplit="";
	String strValidateSplitNo="";
	String strBkgSplitNo ="";
	String strcntrExists ="";
	String strcntrPopExists ="";

	int iSplitCount =0;

	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSplitCombine");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0716Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strBkg_no = event.getBkgBlNoVO().getBkgNo();
		strSplit_Reason = event.getSplitReason();  //M:Memo C:Customer
		iSplitCount = (event.getSplitCnt().length()<1)? 0:Integer.parseInt(event.getSplitCnt())+Integer.parseInt(event.getLastSplitNo());
		strSplitCntrSplitNo = event.getSplitCntrSplitNo();
		strLastSplitNo =event.getLastSplitNo();
		strOrgSplit = event.getOrgSplit();
		strValidateSplitNo =  event.getValidateSplitNo();
		strBkgSplitNo = event.getBkgSplitNo();
		strcntrExists = event.getCntrExists();
	    strcntrPopExists = event.getCntrPopExists();

	}catch(Exception e) {
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
<input type="hidden" name="splitCnt" value="<%=iSplitCount%>" id="splitCnt" />
<input type="hidden" name="splitReason" value="<%=strSplit_Reason%>" id="splitReason" />
<input type="hidden" name="splitCntrSplitNo" value="<%=strSplitCntrSplitNo%>" id="splitCntrSplitNo" />
<input type="hidden" name="lastSplitNo" value="<%=strLastSplitNo%>" id="lastSplitNo" />
<input type="hidden" name="orgSplit" value="<%=strOrgSplit%>" id="orgSplit" />
<input type="hidden" name="validateSplitNo" value="<%=strValidateSplitNo%>" id="validateSplitNo" />
<input type="hidden" name="bkgsplitno" value="<%=strBkgSplitNo%>" id="bkgsplitno" />
<input type="hidden" name="cntrExists" value="<%=strcntrExists%>" id="cntrExists" />
<input type="hidden" name="cntrPopExists" value="<%=strcntrPopExists%>" id="cntrPopExists" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>BB Application Split</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_new" 	id="btn_new">New</button><!--
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
<div class="layer_popup_contents">	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<!-- opus_design_inquiry (S) -->
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>BKG No.</th>
						<td><input type="text" style="width:100px;" class="input" name="bkg_no" value="<%=strBkg_no%>" disabled id="bkg_no" />  </td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry (E) -->
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>