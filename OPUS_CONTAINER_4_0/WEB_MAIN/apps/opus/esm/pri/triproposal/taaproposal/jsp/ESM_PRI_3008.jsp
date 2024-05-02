<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3008.jsp
*@FileTitle  : TAA No Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.taaproposal.event.EsmPri3008Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>

<%
    EsmPri3008Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String[] svcScpCds = null;
    Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TAAProposal");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri3008Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
    }catch(Exception e) {
        out.println(e.toString());
    }
%>



<script type="text/javascript">
    var svcScpComboValue = "|<%=svcScpCds[0]%>";
    var svcScpComboText = " \t |<%=svcScpCds[1]%>";

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

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TAA No. Inquiry</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_OK" 	id="btn_OK">OK</button><!--  
			--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		</div>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="90" />
					<col width="90" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
	                    <td width="85">Service Scope</td>
	                    <td width="85"><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 80, 0, 0, 0, false);</script></td>
	                    <td><input name="svc_scp_nm" id="svc_scp_nm" type="text" style="width:393px;text-align:left;" class="input2" readonly="readonly" caption="Service Scope">
	                    </td>
	                </tr>
	                <tr>
	                    <td width="85">Customer</td>
	                    <td width="90"><input type="text" style="width: 25px;" dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" id="ctrt_cust_cnt_cd" class="input" caption="Customer Code" required><!-- 
									 --><input type="text" style="width: 55px;" dataformat="num" name="ctrt_cust_seq" id="ctrt_cust_seq"  maxlength="6" class="input" caption="Customer Sequence"  required><!-- 
									 --><input type="Hidden" style="width:0px;"><!-- 
	                                 --><button type="button" id="btn_ctrt_cust" name="btn_ctrt_cust" class="input_seach_btn"></button></td>
	                    <td><input type="text" style="width: 187px;" name="ctrt_cust_nm" id="ctrt_cust_nm" readonly="readonly" class="input2"></td>
	                </tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>			
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable">
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--  
				--><button type="button" class="btn_normal" name="btn_New" 	id="btn_New">New</button><!--  
			--></div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid clear" id="mainTable" style="display:none;" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>		
</div>	
</form>