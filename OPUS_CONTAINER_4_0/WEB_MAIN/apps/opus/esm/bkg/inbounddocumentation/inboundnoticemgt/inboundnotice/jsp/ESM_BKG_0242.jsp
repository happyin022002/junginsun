<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0242.jsp
*@FileTitle  : Customer Information
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0242Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	EsmBkg0242Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0242Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        loadPage();
    }
</script>

<form name="form" id="form">
<input name="f_cmd" id="f_cmd" type="hidden" />
<input name="pagerows" id="pagerows" type="hidden" />
<input type="hidden" name="bkg_no" id="bkg_no" 			value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>">
<input type="hidden" name="bkg_cust_tp_cd" id="bkg_cust_tp_cd" 	value="<%=StringUtil.xssFilter(request.getParameter("bkg_cust_tp_cd"))%>">
<input type="hidden" name="tab_idx" id="tab_idx" 		value="<%=JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("tab_idx")),"")%>">
    
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Customer Information</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
<div class="location">
    <span id="navigation"></span>
</div>
<!-- page_location(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab sm">
		<script  type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

    <div id="tabLayer" style="display:inline">
    	<div class="opus_design_inquiry">  <!-- TAB  -->
    	    <table> 
    			<colgroup>
    			    <col width="100"/>
    			    <col width="120"/>
    			    <col width="80"/>
    			    <col width="*"/>
    			</colgroup>
    			<tbody>
                    <tr>
                        <th>Customer Code</th>
                        <td><input type="text" style="width:30px;" class="input2" value="" name="cust_cnt_cd" id="cust_cnt_cd" readOnly><input type="text" style="width:55px;" class="input2" value="" name="cust_seq" id="cust_seq" readOnly></td>
                        <th>MDA Name</th>
                        <td><input type="text" style="width:181px;" class="input2" value="" name="mdm_name" id="mdm_name" readOnly></td>
                    </tr>
                    <tr>
                        <th valign="top">B/L Info. Name</th>
                        <td colspan="3"><textarea style="width:100%" rows="2"  name="bl_name" id="bl_name" readOnly></textarea></td>
                    </tr>
                    <tr>
                        <th valign="top">Address</th>
                        <td colspan="3"><textarea style="width:100%" rows="3"  name="address" id="address" readOnly></textarea></td>
                    </tr>
                    <tr>
                        <th>Rep CMDT</th>
                        <td colspan="3"><input type="text" style="width:100%;" class="input2" name="rep_cmdt" id="rep_cmdt" readOnly></td>
                    </tr>
                    <tr>
                        <th>Fax No.</th>
                        <td colspan="3"><input type="text" style="width:100%;" class="input2" value="" name="fax_no" id="fax_no" readOnly></td>
                    </tr>
                    <tr>
                        <th>E-Mail Address</th>
                        <td colspan="3"><input type="text" style="width:100%;" class="input2" value="" name="email" id="email" readOnly></td>
                    </tr>
    			</tbody>
    		</table>
    	</div>
    	<div class="opus_design_grid" >
    		<script  type="text/javascript">ComSheetObject('t1sheet1');</script>
    	</div>    	
    </div>
    <!-- TAB   Consignee (S) -->

    <!-- TAB   Consignee (S) -->
    <div id="tabLayer" style="display:none">
    	<div class="opus_design_inquiry">  <!-- TAB  -->
    	    <table> 
    			<colgroup>
    			    <col width="100"/>
    			    <col width="120"/>
    			    <col width="80"/>
    			    <col width="*"/>
    			</colgroup>
    			<tbody>
                    <tr>
                        <th>Customer Code</th>
                        <td><input type="text" style="width:30px;" class="input2" value="" name="cust_cnt_cd" id="cust_cnt_cd" readOnly><input type="text" style="width:55px;" class="input2" value="" name="cust_seq" id="cust_seq" readOnly></td>
                        <th>MDA Name</th>
                        <td><input type="text" style="width:181px;" class="input2" value="" name="mdm_name" id="mdm_name" readOnly></td>
                    </tr>
                    <tr>
                        <th valign="top">B/L Info. Name</th>
                        <td colspan="3"><textarea style="width:100%" rows="2"  name="bl_name" id="bl_name" readOnly></textarea></td>
                    </tr>
                    <tr>
                        <th valign="top">Address</th>
                        <td colspan="3"><textarea style="width:100%" rows="3"  name="address" id="address" readOnly></textarea></td>
                    </tr>
                    <tr>
                        <th>Rep CMDT</th>
                        <td colspan="3"><input type="text" style="width:100%;" class="input2" value="" name="rep_cmdt" id="rep_cmdt" readOnly></td>
                    </tr>
                    <tr>
                        <th>Fax No.</th>
                        <td colspan="3"><input type="text" style="width:100%;" class="input2" value="" name="fax_no" id="fax_no" readOnly></td>
                    </tr>
                    <tr>
                        <th>E-Mail Address</th>
                        <td colspan="3"><input type="text" style="width:100%;" class="input2" value="" name="email" id="email" readOnly></td>
                    </tr>
    			</tbody>
    		</table>
    	</div>
    	<div class="opus_design_grid" >
    		<script  type="text/javascript">ComSheetObject('t2sheet1');</script>
    	</div>    	
    </div>
    <!-- TAB   (S) -->

    <!-- TAB   Also Notify (S) -->
    <div id="tabLayer" style="display:none">
    	<div class="opus_design_inquiry">  <!-- TAB  -->
    	    <table> 
    			<colgroup>
    			    <col width="100"/>
    			    <col width="120"/>
    			    <col width="80"/>
    			    <col width="*"/>
    			</colgroup>
    			<tbody>
                    <tr>
                        <th>Customer Code</th>
                        <td><input type="text" style="width:30px;" class="input2" value="" name="cust_cnt_cd" id="cust_cnt_cd" readOnly><input type="text" style="width:55px;" class="input2" value="" name="cust_seq"  id="cust_seq" readOnly></td>
                        <th>MDA Name</th>
                        <td><input type="text" style="width:181px;" class="input2" value="" name="mdm_name" id="mdm_name" readOnly></td>
                    </tr>
                    <tr>
                        <th valign="top">B/L Info. Name</th>
                        <td colspan="3"><textarea style="width:100%" rows="2" name="bl_name" id="bl_name" readOnly></textarea></td>
                    </tr>
                    <tr>
                        <th valign="top">Address</th>
                        <td colspan="3"><textarea style="width:100%" rows="3"  name="address" id="address" readOnly></textarea></td>
                    </tr>
                    <tr>
                        <th>Rep CMDT</th>
                        <td colspan="3"><input type="text" style="width:100%;" class="input2" value="" name="rep_cmdt" id="rep_cmdt" readOnly></td>
                    </tr>
                    <tr>
                        <th>Fax No.</th>
                        <td colspan="3"><input type="text" style="width:100%;" class="input2" value="" name="fax_no" id="fax_no" readOnly></td>
                    </tr>
                    <tr>
                        <th>E-Mail Address</th>
                        <td colspan="3"><input type="text" style="width:100%;" class="input2" value="" name="email" id="email" readOnly></td>
                    </tr>
    			</tbody>
    		</table>
    	</div>
    	<div class="opus_design_grid" >
    		<script  type="text/javascript">ComSheetObject('t3sheet1');</script>
    	</div>    	
    </div>
    <!-- TAB   Also Notify (E) -->

</div>
</div>
<!-- popup_contens_area(E) -->
</form>