<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_3001.jsp
*@FileTitle  : Controlling Party Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/03
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg3001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg3001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg3001Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ctrl_pty_seq">
<input type="hidden" name="inet_ftp_auth_flg">
<!-- page_title_area(S) -->
	<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	    --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button>
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
	<div class="opus_design_inquiry wFit">
		    <table>
		         <colgroup>
		            <col width="150" />
		            <col width="210" />
		            <col width="150" />
		            <col width="210" />
		            <col width="80" />
		            <col width="210" />
		            <col width="80" />
		            <col width="*" />
		        </colgroup> 
		        <tbody>
					<tr>
						<th>Controlling Party Name</th>
						<td><input type="text" style="width:200px; ime-mode:abled" name="ctrl_pty_nm" class="input" dataformat="exceptengdn"></td>
						<th>Controlling Description</th>
						<td><input type="text" style="width:200px; ime-mode:abled" name="ctrl_pty_desc" class="input" ></td>
						<th>IB Coustomer</th>
						<td>
							<input type="text" name="cust_cnt_cd" dataformat="enguponly" maxlength="2" style="width:35px;ime-mode:disabled" >
							<input type="text" name="cust_seq" dataformat="num" maxlength="8" style="width:80px;ime-mode:disabled" >
							<button type="button" class="input_seach_btn" name="cust_pop" id="cust_pop"></button>
						</td>
						<th>BL Group Name</th>
						<td><input type="text" style="width:190px; ime-mode:abled" name="bl_grp_nm" class="input" dataformat="exceptengdn"></td>
					</tr>
					
				</tbody>
			</table>
	</div>
</div>


<div class="wrap_result">
	<div class="opus_design_grid wFit">
<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2" style ="width: 50%">
<!--         opus_design_grid(S) -->
        <div class="opus_design_grid">
        <div class="opus_design_btn">		
			<button type="button" class="btn_normal" name="btn_RowAdd1" id="btn_RowAdd1">Row Add</button>
			<button type="button" class="btn_normal" name="btn_RowDel1" id="btn_RowDel1">Row Delete</button>
		</div>
			<h3 class="title_design mar_btm_8">Controlling Party</h3>
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
<!--         opus_design_grid(E) -->
    </div>
    <div class="layout_vertical_2" style ="width: 50%">
<!--         opus_design_grid(S) -->
        <div class="opus_design_grid">
        <div class="opus_design_btn">		
			<button type="button" class="btn_normal" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button>
			<button type="button" class="btn_normal" name="btn_RowDel2" id="btn_RowDel2">Row Delete</button>
		</div>
			<h3 class="title_design mar_btm_8">Internet B/L Control Party</h3>
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
<!--         opus_design_grid(E) -->
    </div>
    <div class="layout_vertical_2" style ="width: 100%">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn"><!--
	    --><button type="button" class="btn_normal" name="btn_RowAdd3" id="btn_RowAdd3">Row Add</button><!--
	    --><button type="button" class="btn_normal" name="btn_RowDel3" id="btn_RowDel3">Row Delete</button><!--
	    --></div>
	    <!-- opus_design_btn(E) -->
		<h3 class="title_design mar_btm_8">BL Group</h3>
	    <script type="text/javascript">ComSheetObject('sheet3');</script>
    </div>

</div>
</div>
</div>
</form>