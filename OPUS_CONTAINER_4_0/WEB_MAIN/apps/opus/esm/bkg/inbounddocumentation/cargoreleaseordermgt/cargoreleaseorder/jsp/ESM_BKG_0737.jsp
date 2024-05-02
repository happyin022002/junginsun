<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG-0737.jsp
*@FileTitle  : Korea Cargo Release (D/O)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0737Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0737Event event     = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //error from server
    String strErrMsg = "";                    //error message
    int rowCount     = 0;                     //count of DB resultSET list

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";

    String strUsr_id   = "";
    String strUsr_nm   = "";

    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.FullReleaseOrder");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg0737Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // get data from server when load page ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>



<script language="javascript">
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
<input type="hidden" name="pagerows">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>eDO Transmit</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_submit" id="btn_submit">전송</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
				<table>
	                <tr>
	                    <td width="140">D/O 발급 신청서</td>
	                    <td width="240"><input type="radio" name='rdo_5JN' class="trans" disabled onClick="TransmitDataSet('N')">&nbsp;대상&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JN' class="trans" disabled onClick="TransmitDataSet('A')">&nbsp;승인&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JN' class="trans" disabled onClick="TransmitDataSet('R')">&nbsp;거부&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JN' class="trans" disabled onClick="TransmitDataSet('P')">&nbsp;보류</td>
	                    <td width=""><!--edo_rjct_rsn--><input type="text" name='rej_rmk' style="width:100%;" class="input2" readonly onChange="rejRmkDataSet('1')"maxlength='1000'></td>
	                </tr>
	                <tr>
	                    <td>자가운송 요청 동의서</td>
	                    <td><input type="radio" name='rdo_5JM' class="trans" disabled onClick="TransmitDataSet('N')">&nbsp;대상&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JM' class="trans" disabled onClick="TransmitDataSet('A')">&nbsp;승인&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JM' class="trans" disabled onClick="TransmitDataSet('R')">&nbsp;거부&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JM' class="trans" disabled onClick="TransmitDataSet('P')">&nbsp;보류</td>
	                    <td><!--edo_rjct_rsn--><input type="text" name='rej_rmk' style="width:100%;" class="input2" readonly onChange="rejRmkDataSet('2')" maxlength='1000'></td>
	                </tr>
	                <tr>
	                    <td>보세운송 요청 동의서</td>
	                    <td><input type="radio" name='rdo_5JK' class="trans" disabled onClick="TransmitDataSet('N')">&nbsp;대상&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JK' class="trans" disabled onClick="TransmitDataSet('A')">&nbsp;승인&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JK' class="trans" disabled onClick="TransmitDataSet('R')">&nbsp;거부&nbsp;&nbsp;&nbsp;<input type="radio" name='rdo_5JK' class="trans" disabled onClick="TransmitDataSet('P')">&nbsp;보류</td>
	                    <td><!--edo_rjct_rsn--><input type="text" name='rej_rmk' style="width:100%;" class="input2" readonly onChange="rejRmkDataSet('3')" maxlength='1000'></td>
	                </tr>    
                </table>
			
				<table>
					<tbody>
						<tr>
							<td>
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</tbody>
				</table>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->

<input type='hidden' id = 'h_approvals' name ='h_approvals' value="<%=JSPUtil.getNull(request.getParameter("approvals"))%>">
<input type='hidden' id = 'h_last_rlse_sts_cd' name ='h_last_rlse_sts_cd' value="<%=JSPUtil.getNull(request.getParameter("last_rlse_sts_cd"))%>">
<input type='hidden' id = 'rqst_no' name ='rqst_no' value="<%=JSPUtil.getNull(request.getParameter("rqst_no"))%>">
<input type='hidden' id = 'bkg_no' name ='bkg_no' value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<input type='hidden' id = 'edo_ack_cd_arr' name ='edo_ack_cd_arr'>
<input type='hidden' id = 'self_trans_chk_flg' name ='self_trans_chk_flg'>
<input type='hidden' id = 'mrn_no' name ='mrn_no' value="<%=JSPUtil.getNull(request.getParameter("mrn_no"))%>">
<input type='hidden' id = 'msn_no' name ='msn_no' value="<%=JSPUtil.getNull(request.getParameter("msn_no"))%>">
<input type='hidden' id = 'pod_cd' name ='pod_cd' value="<%=JSPUtil.getNull(request.getParameter("pod_cd"))%>">
<input type='hidden' id = 'del_cd' name ='del_cd' value="<%=JSPUtil.getNull(request.getParameter("del_cd"))%>">
<input type='hidden' id = 'de_term_desc' name ='de_term_desc' value="<%=JSPUtil.getNull(request.getParameter("de_term_desc"))%>">
</form>
