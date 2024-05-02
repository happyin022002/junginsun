<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0401.js
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg0401Event"%>
<%@ page import="org.apache.log4j.Logger" %> 

<%
	EsmBkg0401Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0401Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="hrd_cdg_id" value="CND_AVCNTC_OFC_SET" id="hrd_cdg_id" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
   <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
   <!-- page_title(E) -->
  
   <!-- opus_design_btn(S) -->
   <div class="opus_design_btn">
       <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_Save"   id="btn_Save">Save</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_Delete"   id="btn_Delete">Delete</button>
   </div>
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
<div class="opus_design_inquiry wFit">
	<table>
        <colgroup>
           <col width="80" />
           <col width="*" />
       </colgroup>	         
       <tbody>
		<tr>
			<th>Office Code</th>
			<td><input type="text" style="width:85px;ime-mode:disabled" class="input1" required name="attr_ctnt1" id ="attr_ctnt1" maxlength="6" dataformat="enguponly" caption="Office Code" value="<%=strOfc_cd%>"></td>
		</tr>
		</tbody>
	</table>
	<table class = "grid_2" style = "width: 510px">
       <colgroup>
          <col width="80" />
          <col width="*" />
      </colgroup>	         
      <tbody>
		<tr>
			<th><strong>Address</strong></th>							
			<td><textarea style="resize:none; width:420px;ime-mode:disabled;overflow:hidden" rows="7" name="frm_attr_ctnt2" id="frm_attr_ctnt2"></textarea></td>
		</tr>
	</tbody>
</table>
</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid clear" style="display:none">
	<!-- opus_design_inquiry(E) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>