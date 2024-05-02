<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_7001.jsp
*@FileTitle  : MTY COD Confirmation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr7001Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr7001Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.eqtransportplannperform.eqtransportplannperform");
    CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesEqr7001Event)request.getAttribute("Event");
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

    function test(){
        alert("33");
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="editRow" id="editRow" />
<input type="hidden" name="editPort" id="editPort" />
<input type="hidden" name="editIbFlag" id="editIbFlag" />
<input type="hidden" name="sh2RC" id="sh2RC" />
<input type="hidden" name="n1stEtb" id="n1stEtb" />
<input type="hidden" name="yardcode" id="yardcode" />
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
		 --><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!-- 
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
				<col width="125">
				<col width="40">
				<col width="55">
				<col width="40">
				<col width="70">
				<col width="50">
				<col width="55">
				<col width="60">				
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
                    <td><input type="text" name="vvd" style="width:80px;ime-mode:disabled" class="input1" value="" dataformat="engup" maxlength="9" id="vvd" /><!-- 
                     --><button type="button" class="input_seach_btn" name="btn_vvd" id="btn_vvd"></button>
                    </td>
                    <th>Lane</th>
                    <td><input type="text" name="lane" style="width:35px;" class="input2" value="" readonly id="lane" />
                    </td>
                    <th>Bay</th>
                    <td>
                        <input type="text" name="bay" style="width:45px;" class="input2" value="" readonly id="bay" />
                    </td>
                    <th>Version</th>
                    <td><input type="text" name="version" style="width:25px;" class="input2" value="" readonly id="version" />
                    </td>
                    <th>Created by</th>
                    <td>
                        <input type="text" name="user" style="width:60px;" class="input2" value="<%= strUsr_id %>" readonly id="user" />
                    </td>
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
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_remove" id="btn_remove">Confirmation Delete</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_delete"  	id="btn_delete">Row Delete</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_rowadd2" id="btn_rowadd2">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_delete2"  	id="btn_delete2">Row Delete</button>
		</div>
		<!-- opus_design_btn(E) -->
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