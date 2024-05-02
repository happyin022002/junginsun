<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292_04.jsp
*@FileTitle  : C/S Screen(Notice & B/L Copy)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029204Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg029204Event  event = null;            //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfcCd         = "";
    Logger log = Logger.getLogger("com.clt.apps.CsScreenMgtSC.CsScreenBC");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfcCd  = account.getOfc_cd();
        event = (EsmBkg029204Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    var strUsr_id    = "<%=strUsr_id%>";
    var lginOfcCd    = "<%=strOfcCd %>"; //login user Ofc Cd
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="bl_no" value="<%=JSPUtil.getNull(request.getParameter("bl_no")) %>" id="bl_no" />
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getNull(request.getParameter("bkg_no")) %>" id="bkg_no" />
<input type="hidden" name="h_mrd_id" value="" id="h_mrd_id" />
<input type="hidden" name="h_local_lang_flg" value="" id="h_local_lang_flg" />
<!-- RD Part  -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="" id="com_mrdTitle" />
<input type="hidden" name="com_mrdDisableToolbar" value="" id="com_mrdDisableToolbar" />
<input type="hidden" name="com_mrdBodyTitle" value="" id="com_mrdBodyTitle" />

	<!-- opus_grid_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_t5Preview" id="btn_t5Preview">Preview</button><!--  
		--><button type="button" class="btn_normal" name="btn_t5Master" id="btn_t5Master">Master Data</button><!--  
		--><button type="button" class="btn_normal" name="btn_t5SendAn" id="btn_t5SendAn">Send A/N</button><!--  
		--><button type="button" class="btn_normal" name="btn_t5AnTemplate" id="btn_t5AnTemplate">A/N Template</button><!--  
		--><button type="button" class="btn_normal" name="btn_t5SendOBl" id="btn_t5SendOBl">Send O.B/L</button>
	</div>
	<!-- opus_grid_btn(E) -->

<div class= "wrap_search_tab">
	<div class="opus_design_inquiry wFit"> 
	
		<table> 
			<colgroup>
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="15%" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th><h3 class="title_design">Consignee Code</h3></th>
	                <td><input type="text" style="width:90px;" class="input2" value="" name="frm_t5sheet1_cust_cd_c" readonly></td>
	                <th>Name</th>
	                <td><input type="text" style="width:180px;" class="input2" value="" name="frm_t5sheet1_cust_nm_c" readonly></td>
	                <th>Address</th>
	                <td><input type="text" style="width:350px;" class="input2" value="" name="frm_t5sheet1_cust_addr_c" readonly></td>
	            </tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" >
	<script type="text/javascript">ComSheetObject('t5sheet1');</script>
	<script type="text/javascript">ComSheetObject('t5sheet2');</script>
</div>
<!-- opus_design_grid(E) -->

<div class="opus_design_inquiry"> 
	<table> 
		<colgroup>
			<col width="50" />
			<col width="50" />
			<col width="50" />
			<col width="50" />
			<col width="50" />
			<col width="*" />
		</colgroup>
		<tbody>
	        <tr>
	        	<th><h3 class="title_design">Notify Code</h3></th>
	            <td><input type="text" style="width:90px;" class="input2" value="" name="frm_t5sheet1_cust_cd_n" readonly></td>
	            <th>Name</th>
	            <td><input type="text" style="width:180px;" class="input2" value="" name="frm_t5sheet1_cust_nm_n" readonly></td>
	            <th>Address</th>
	            <td><input type="text" style="width:350px;" class="input2" value="" name="frm_t5sheet1_cust_addr_n" readonly></td>
	         </tr>
		</tbody>
	</table>
</div>

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" >
	<script type="text/javascript">ComSheetObject('t5sheet3');</script>
</div>
<!-- opus_design_grid(E) -->

<div class="opus_design_inquiry"> 
	<table> 
		<colgroup>
			<col width="50" />
			<col width="50" />
			<col width="50" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th><h3 class="title_design">A. Notify Code</h3></th>
				<td><input type="text" style="width:90px;" class="input2" value="" name="frm_t5sheet1_cust_cd_a" readonly></td>
				<th>Name & Address</th>
				<td><input type="text" style="width:576px;" class="input2" value="" name="frm_t5sheet1_cust_nm_a" readonly></td> 
				
			</tr>
		</tbody>
	</table>
</div>
</div>
</form> 