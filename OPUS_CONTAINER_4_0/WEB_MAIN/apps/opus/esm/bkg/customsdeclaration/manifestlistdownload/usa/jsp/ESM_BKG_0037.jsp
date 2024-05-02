<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0037.jsp
*@FileTitle  : B/L Inquiry: Container Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0037Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCntCd			= "";
    String strBlNo         = "";
    String strTrnkBdrFlg   = "";
    
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0037Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntCd = JSPUtil.getNullNoTrim(request.getParameter("cnt_cd"));
		strBlNo  = JSPUtil.getNullNoTrim(request.getParameter("bl_no"));
        strTrnkBdrFlg = JSPUtil.getNullNoTrim(request.getParameter("trnk_bdr_flg"));
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="cnt_cd" id="cnt_cd" value="<%="".equals(strCntCd) ? "US" : strCntCd%>">
<input type="hidden" name="trnk_bdr_flg" id="trnk_bdr_flg" value="<%=strTrnkBdrFlg%>">
<input type="hidden" name="sheet_id" id="sheet_id">
<input type="hidden" name="cn_flg" id="cn_flg" value="Y">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Manifest Details by B/L : Container Information</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
		    	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		     --><button type="button" class="btn_normal"  name="btn_save" id="btn_save">Save</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>
<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			 <table> 
	            <colgroup>
	                <col width="30">
	                <col width="*">
	            </colgroup>
	            <tbody>
		             <tr>
                        <th>B/L No.</th>
                        <td><input type="text" name="bl_no" id="bl_no" class="input1" style="width:100px;" dataformat="eng" maxlength="12" required caption="B/L No." value="<%=strBlNo%>"></td>
                    </tr>	
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >	
		<div class="opus_design_btn">
			<button class="btn_normal" type="button"  name="btn_add" id="btn_add">Row Add</button><!-- 
		 --><button class="btn_normal" type="button"  name="btn_del" id="btn_del">Row Delete</button>
		</div>			
		 <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid" id="mainTable" style="display: none;">	
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
	<div class="opus_design_grid" id="mainTable" style="display: none;">	
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>