<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_cim_1050.jsp
*@FileTitle : Match-back by Vessel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr7003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesEqr7003Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String tVvd = "";
    String tPod = "";
    String tVersion = "";
    Logger log = Logger.getLogger("com.clt.apps.eqtransportplannperform.eqtransportplannperform");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesEqr7003Event)request.getAttribute("Event");
        tVvd = StringUtil.xssFilter((String)request.getParameter("vvd"));
        tPod = StringUtil.xssFilter((String)request.getParameter("pod"));
        tVersion = StringUtil.xssFilter((String)request.getParameter("version"));
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

<head>
<title>Welcome to OPUS!</title>


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
<input type="hidden" name="version" value="<%= tVersion %>" id="version" />

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="HEADTITLE">Revenue MTY CNTR List</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_accent" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" id="btn_downexcel" name="btn_downexcel">Down Excel</button><!--
		 --><button type="button" class="btn_normal" id="btn_close" name="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30"></col>
				<col width="120"></col>
				<col width="30"></col>
				<col width="100"></col>
				<col width="*"></col>
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
	                <td><input type="text" name="vvd" style="width:80px;ime-mode:disabled" class="input1" dataformat="engup" maxlength="9" value="<%= tVvd %>" id="vvd" /> </td>
	                <th title="Port of Discharging">POD</th>
	                <td>
	                    <select style="width:65px;" class="input" name="pod">
	                    	<option value="" selected></option>
	                    </select>
	                </td>
	                <td></td>
				</tr>
			</tbody>
		</table>
		
	</div>
</div>

<div class="wrap_result">
	<div class="layout_wrap">
		<div class="layout_vertical_2" style="width: 49%;">
			<h3 class="title_design">Source : Master</h3>
			<div class="opus_design_grid">
	           <script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
		</div>
		<div class="layout_vertical_2" style="width: 2%;">
			<table><tr><td>&nbsp;</td></tr></table>
		</div>
		 <div class="layout_vertical_2" style="width: 49%;">
		 	<h3 class="title_design">Source : MTY BKG</h3>
			<div class="opus_design_grid">
	           <script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
		 </div>
	</div>
	<div class="opus_design_grid">
        <script type="text/javascript">ComSheetObject('sheet3');</script>
    </div>
</div>
</form>