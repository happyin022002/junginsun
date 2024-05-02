<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CESD_SCE_0109.jsp
*@FileTitle  : Location Inquery/POR/POL/POD/DEL(Popup) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.bizcommon.location.event.ComEns051Event"%>
<%
	ComEns051Event  event = null;                        //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;                    //error from server
	DBRowSet rowSet      = null;                           //DB ResultSet
	String strErrMsg = "";                                 //error message
	int rowCount     = 0;                                  //count of DB resultSET list

	String usr_ofc_cd = "";
	String diff = JSPUtil.getNull(request.getParameter("diff"));
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        //userId=account.getSawonNo();
        //userAuth=account.getAuth();
        usr_ofc_cd = account.getOfc_cd();


	    event = (ComEns051Event)request.getAttribute("Event");
	   //serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);					//	?

	    if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	    }
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

	   // InitTab();
        loadPage();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="loc_port_ind" id="loc_port_ind" />
<input type="hidden" name="lcc_cd" value="" id="lcc_cd" />
<input type="hidden" name="sysCode" id="sysCode" />
<input    type="hidden" name="diff" id="diff"  value='<%=diff%>'>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Location / Port Code Inquiry</span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!-- 
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <table>
	    	<colgroup>
	            <col width="50" />
	            <col width="180" />
	            <col width="30" />
	            <col width="180" />
	            <col width="30" />
	            <col width="125" />
	            <col width="35" />
	            <col width="*" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Continent</th>
					<td><input name="conti_cd" type="text" style="width:60px;" onkeyup="javascript:upper(this);" id="conti_cd" /> </td>
					<th>Sub Continent</th>
					<td><input name="sconti_cd" type="text" style="width:60px;" onkeyup="javascript:upper(this);" id="sconti_cd" /> </td>
					<th>Country</th>
					<td><input name="cnt_cd" type="text" style="width:60px;" onkeyup="javascript:upper(this);" id="cnt_cd" /> </td>
					<th>State</th>
					<td><input name="loc_state" type="text" style="width:50px;" onkeyup="javascript:upper(this);" id="loc_state" /> </td>
				<tr>
					<th>Control Office</th>
					<td><input name="loc_eq_ofc" type="text" style="width:60px;" onkeyup="javascript:upper(this);" id="loc_eq_ofc" /> </td>
					<th>Location Code</th>
					<td><input name="loc_cd" type="text" style="width:60px;" onkeyup="javascript:upper(this);" id="loc_cd" /> </td>
					<th>Location Name</th>
					<td colspan="3"><input name="loc_nm" type="text" style="width:210px;" id="loc_nm" /><input name="chk_port_ind" type="checkbox" value="Y" class="trans" id="chk_port_ind" /><label for ="chk_port_ind">Port Only</label></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

<SCRIPT type="text/javascript">
<!--
       with(document.form)
      {
        <%
        if(event != null){

        	//String conti_cd     = event.getConti_cd();
            //String sconti_cd = event.getScontiCd();
            String cnt_cd     = event.getCntCd();
            //String loc_state     = event.getLocState();
            String loc_eq_ofc     = event.getLocEqOfc();
            String loc_cd     = event.getLocCd();
            //String loc_desc     = event.getLocDesc();
            //String loc_port_ind     = event.getLocPortInd();
            //String sysCode     = event.getSysCode();

		  	if(!"N".equals(loc_eq_ofc)) {
        %>
        		eval("loc_eq_ofc").value = "<%=usr_ofc_cd%>";
        <%
        	}
        %>

	        eval("cnt_cd").value     = "<%=cnt_cd%>";
	        eval("loc_eq_ofc").value     = "<%=loc_eq_ofc%>";
	        eval("loc_cd").value     = "<%=loc_cd%>";


        <% } %>
       }
-->
</SCRIPT>

<%@ include file="/apps/opus/esd/sce/common/commonpopup/include/common.jsp"%>


