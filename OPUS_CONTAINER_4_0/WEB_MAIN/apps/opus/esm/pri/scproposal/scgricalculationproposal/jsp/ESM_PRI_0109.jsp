<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0109.jsp
*@FileTitle  : GRI Calculation - Arbitrary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0109Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri0109Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCGRICalculationProposal");


    String sPropNo      = "";
    String sAmdtSeq     = "";
    String sSvcScpCd    = "";
    String sAddChgTpCd  = "";
    String sOrgDestTpCd = "";
    String sEffDt   = "";
    String sApplFlg = "";
    String sPropStsCd = "";
    
    String[] pers = null;
    String[] cargos = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0109Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        sPropNo      = JSPUtil.getNullNoTrim(request.getParameter("sPropNo"));
        sAmdtSeq     = JSPUtil.getNullNoTrim(request.getParameter("sAmdtSeq"));
        sSvcScpCd    = JSPUtil.getNullNoTrim(request.getParameter("sSvcScpCd"));
        sAddChgTpCd  = JSPUtil.getNullNoTrim(request.getParameter("sAddChgTpCd"));
        sOrgDestTpCd = JSPUtil.getNullNoTrim(request.getParameter("sOrgDestTpCd"));
        sEffDt       = JSPUtil.getNullNoTrim(request.getParameter("sEffDt"));
        sApplFlg     = JSPUtil.getNullNoTrim(request.getParameter("sApplFlg"));
        sPropStsCd   = JSPUtil.getNullNoTrim(request.getParameter("sPropStsCd"));
        
        // per Data 
        pers = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("per"), false);
        // cargo type Data 
        cargos = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargo"), true , "|", "\t", "getCode", "getName");

    }catch(Exception e) {
        out.println(e.toString());
    }

%>
<script type="text/javascript">

    var perComboValue = " |<%=pers[0]%>";
    var perComboText = " |<%=pers[1]%>";

    var cargoComboValue = " |<%=cargos[0]%>";
    var cargoComboText = " |<%=cargos[1]%>";

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
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="prop_no" value="<%=sPropNo%>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=sAmdtSeq%>" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="<%=sSvcScpCd%>" id="svc_scp_cd" />
<input type="hidden" name="add_chg_tp_cd" value="<%=sAddChgTpCd%>" id="add_chg_tp_cd" />
<input type="hidden" name="org_dest_tp_cd" value="<%=sOrgDestTpCd%>" id="org_dest_tp_cd" />
<input type="hidden" name="n1st_cmnc_dt" value="<%=sEffDt%>" id="n1st_cmnc_dt" />
<input type="hidden" name="n1st_cmnc_amdt_seq" value="<%=sAmdtSeq%>" id="n1st_cmnc_amdt_seq" />
<input type="hidden" name="gri_appl_tp_cd" value="<%=sApplFlg%>" id="gri_appl_tp_cd" />
<input type="hidden" name="prop_sts_cd" value="<%=sPropStsCd%>" id="prop_sts_cd" />

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
			<h2 class="page_title"><span>GRI Calculation</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_OK" id="btn_OK">OK</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_Cancle" id="btn_Cancle">Cancel</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result"> 
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
					<button class="btn_normal" type="button"  name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
				 --><button class="btn_normal" type="button"  name="btn_RowCopy" id="btn_RowCopy">Row Copy</button><!-- 
				 --><button class="btn_normal" type="button"  name="btn_Delete" id="btn_Delete">Delete</button>
			</div>			
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry wFit">
			<table style="height:32px">
				<colgroup>
					<col width="110">
					<col width="120">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
                        <th class="sm">Applying Option</th>
                        <td class="sm">
                            <input type="radio" class="trans" name="rdo_appl_option" id="radio_rdo_appl_option" value="F" checked><label for="radio_rdo_appl_option">Amount</label>
                            <input type="radio" class="trans" name="rdo_appl_option" id="radio_rdo_appl_option1" value="P"><label for="radio_rdo_appl_option1">Percentage (%)</label>
                        </td>
                        <td></td>
                    </tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
					<button class="btn_normal" type="button"  name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button><!-- 
				 --><button class="btn_normal" type="button"  name="btn_RowCopy2" id="btn_RowCopy2">Row Copy</button><!-- 
				 --><button class="btn_normal" type="button"  name="btn_Delete2" id="btn_Delete2">Delete</button><!-- 
				 --><button class="btn_normal" type="button" name="btn_Save2" id="btn_Save2">Save</button>
			</div>			
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
    		<script type="text/javascript">ComSheetObject('sheet4');</script>
   			<script type="text/javascript">ComSheetObject('sheet5');</script>
    		<script type="text/javascript">ComSheetObject('sheet6');</script>
		</div>
	</div>	
</div>
<!-- layer_popup_contents(E) -->
</form>