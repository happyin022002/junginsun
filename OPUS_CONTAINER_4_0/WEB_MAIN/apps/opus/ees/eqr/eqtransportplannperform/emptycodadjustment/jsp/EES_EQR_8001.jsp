<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_8001.jsp
*@FileTitle  : MTY Repo Inquiry by VVD 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr8001Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr8001Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.eqtransportplannperform.emptycodadjustment");
    CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesEqr8001Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
	<%= tpszUtil.getTpSzCodeCombo("eqr", "hidtpszall", "", "", "", "Y", "")%>
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
<input type="hidden" name="version" id="version" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

	<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="130">
				<col width="25">
				<col width="55">
				<col width="40">
				<col width="70">
				<col width="80">
				<col width="190">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
                    <td><input type="text" name="vvd" style="width:80px;ime-mode:disabled" class="input1" value="" dataformat="engup" maxlength="9" id="vvd" /><button type="button" name="btn_vvd" id="btn_vvd" class="input_seach_btn"></button></td>
                    <th>Lane</th>
                    <td><input type="text" name="lane" style="width:35px;" class="input2" value="" readonly id="lane" /></td>
                    <th>Bay</th>
                    <td><input type="text" name="bay" style="width:60px;" class="input2" value="" readonly id="bay" /></td>
                    <th>Created by</th>
                    <td><input type="text" name="user" style="width:70px;" class="input2" value="<%= strUsr_id %>" readonly id="user" /></td>
                    <td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->	
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_data">
		<table class="grid_2">
			<colgroup>
				<col width="160">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Remark(s)</th>
                	<td><textarea  rows="2" name="remark" id="remark" style="width:100%; resize: none;"></textarea></td>
				</tr>
			</tbody>
		</table>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_etc" name="HRBTN" style="width:100px;text-align:left" id="HRBTN" onclick="popHRBTN();"></button><!-- 
			 --><button type="button" class="btn_etc" name="RMBTN" style="width:110px;text-align:left" id="RMBTN" onclick="popRMBTN();"></button><!-- 
			 --><button type="button" class="btn_etc" name="DMBTN" style="width:100px;text-align:left" id="DMBTN" onclick="popDMBTN();"></button><!-- 
		 --></div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
</form>