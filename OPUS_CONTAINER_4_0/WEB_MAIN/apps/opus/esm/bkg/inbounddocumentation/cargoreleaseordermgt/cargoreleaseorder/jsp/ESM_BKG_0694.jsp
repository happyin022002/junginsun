<%
 /*
 =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   esm_bkg_0694.jsp
*@FileTitle  : DO LIST CHECK REPORT(JAPAN)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
 */
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0694Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0694Event  event = null;        //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //error from server
    String strErrMsg = "";            //error message
    int rowCount   = 0;            //DB ResultSet List count
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String mainpage = "";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
         
         
        event = (EsmBkg0694Event)request.getAttribute("Event");
        mainpage = JSPUtil.getNull(request.getParameter("mainPage"));
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows %>">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button><!--
		 --><button type="button" class="btn_normal" name="btn_cargo" id="btn_cargo">Cargo Release</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
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
			<!--  biz_1  (S) -->
			<table>
				<tbody>
					<tr>
						<th width="70"><input type="radio" value="F" checked="true" name="rd_flag" id="rd_flag_vvd"><label for="rd_flag_vvd"><strong>VVD</strong></label></th>
						<td width="50"> 
						 	<input type="text" class="input1" style="width:100px" value="" name="vvd" id="vvd" caption="VVD" minlength="9" dataformat="engup" maxlength="9" fullfill="true" required="true" /><!-- 
						 --><input type="hidden" name="vsl_cd" id="vsl_cd" /><!-- 
						 --><input type="hidden" name="skd_voy_no" id="skd_voy_no" /><!-- 
						 --><input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
						</td>
						<th width="10">POD</th>
						<td width="50"><input type="text" style="width: 60px;ime-mode:disabled" class="input1" value="" name="pod_cd" id="pod_cd" caption="POD" maxlength="5" fullfill="true" dataformat="engup" /></td>
						<th width="20">D/O</th>
						<td width="110">  
							<select style="width: 70px;" class="input1" name="rlse_sts_cd"> 
								<option value="Y" selected>Yes</option> 
							 	<option value="N">No</option>
							 	<option value="*">All</option>
						 	</select>
						</td>
						<th width="100"><input type="radio" value="S" name="rd_flag" id="rd_flag_office"><label for="rd_flag_office"><strong>Issue Office</strong></label></th>
						<td width="55"><input type="text" style="width: 50px;" class="input1" dataformat="enguponly" value="" name="evnt_ofc_cd" id="evnt_ofc_cd" caption="Issue Office" maxlength="5" style="ime-mode:disabled"></td>
						<th width="50">D/O Date</th>
						<td> 
							<input type="text" style="width: 75px;" class="input1" value="" name="evnt_dt_start" id="evnt_dt_start" dataformat="ymd" maxlength="10" caption="D/O Start Date" cofield="evnt_dt_end" style="width:100px;" style="ime-mode:disabled"/>
						 	~
							<input type="text" style="width: 75px;" class="input1" value="" name="evnt_dt_end" id="evnt_dt_end" dataformat="ymd" maxlength="10" caption="D/O End Date" cofield="evnt_dt_start"style="width:100px;" style="ime-mode:disabled"><!-- 
						 --><button type="button" class="calendar ir" name="btn_evnt_dt" id="btn_evnt_dt"></button>
						</td>
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
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>