<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0947.jsp
*@FileTitle  : Customs Result Code Setup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0947Event"%>
<%@ page import="com.clt.syscommon.common.table.MdmCountryVO" %>
<%@ page import="com.clt.syscommon.common.table.MdmPortVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
    EsmBkg0947Event  event = null;                 //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //occurring error in server
    String strErrMsg = "";                         //error message
    int rowCount     = 0;                          //List count of DB ResultSet 
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String strCnt_cd		= "";
    String strPgmNo         = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd().substring(0,4);
        strCnt_cd = account.getCnt_cd();
        event = (EsmBkg0947Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        //When initial screen loading, adding logic extrat data obtained from the server.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strPgmNo = request.getParameter("pgmNo");
 
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    var userOfficeCode = "<%=strOfc_cd%>";    
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

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_accent" name="btn_Save"  		id="btn_Save">Save</button>
		<button type="button" class="btn_accent" name="btn_Excel" 		id="btn_Excel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
		 		<col width="4%"/>
				<col width="3%"/>
				<col width="3%"/>
				<col width="7%"/>
				<col width="2%"/>
				<col width="10%"/>
				<col width="3%"/>
				<col width="*" />
		    </colgroup>
		    <tr>
				<th>Country</th> 
				<td><input type="text" name="cnt_cd" id="cnt_cd" style="width:33px; ime-mode: disabled; text-align:center;" class="input" value="<%=strCnt_cd%>"dataformat="engup" maxlength="2" fullfill caption="Country"></td>
				<th>Code</th> 
				<td><input type="text" name="cstms_dspo_cd" id="cstms_dspo_cd" style="width:100px; ime-mode: disabled;" class="input" dataformat="engup" maxlength="2" fullfill caption="Code"></td>
				<th>Type</th> 
				<td><script type="text/javascript">ComComboObject('dspo_tp_cd', 1, 120, 1, 0);</script></td>
				<th>Total</th> 
				<td><input type="text" name="total" id="total" style="width:40px; text-align:center;" class="input2" readonly></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>	
<!-- opus_design_grid(E) -->
</div>
</form>