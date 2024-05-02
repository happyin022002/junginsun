<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_3009.jsp
*@FileTitle  : TRI Creation & Amendment - TRI Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.taaproposal.event.EsmPri3009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3009Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String trfCd = null;
    String trfNm = null;
    String trfPfxCd = null;
    String trfNo = null;
    Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TAAProposal");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri3009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        trfCd    = JSPUtil.getNull((String)eventResponse.getCustomData("trfCd"));
        trfNm    = JSPUtil.getNull((String)eventResponse.getCustomData("trfNm"));
        trfPfxCd = JSPUtil.getNull((String)eventResponse.getCustomData("trfPfxCd"));
        trfNo    = JSPUtil.getNull((String)eventResponse.getCustomData("trfNo"));
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript">
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
<input type="hidden" name="frm_trf_pfx_cd" value="<%=trfPfxCd %>" id="frm_trf_pfx_cd" />
<input type="hidden" name="frm_trf_no" value="<%=trfNo %>" id="frm_trf_no" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TRI Creation & Amendment - TRI Select</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_OK" 	id="btn_OK">OK</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>	
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Tariff Code</th>
	                    <td colspan="5"><input type="text" name="frm_trf_no" style="width:100px;text-align:center;" class="input2" value="<%=trfCd %>" readonly="readonly" id="frm_trf_no" /><input type="text" name="frm_trf_nm" style="width:265px;text-align:left;" class="input2" value="<%=trfNm %>" readonly="readonly" id="frm_trf_nm" /> </td>
	                    <th colspan="2">Commodity Code</th>
	                    <td colspan="2"><input type="text" name="frm_cmdt_cd" style="width:70px;text-align:center;" class="input" id="frm_cmdt_cd" /><button type="button" id="btn_cmdt" name="btn_cmdt" class="input_seach_btn"></button>
	                     	            <input type="text" name="frm_cmdt_nm" style="width:208px;" class="input2" value="" id="frm_cmdt_nm" readonly="readonly"/></td>
					</tr>	
					<tr>
						<th>Origin</th>
	                    <td><input type="text" name="frm_org_pnt_loc_cd" style="width:50px;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="5" class="input" id="frm_org_pnt_loc_cd" /> </td>
	                    <th>Origin Via</th>
	                    <td><input type="text" name="frm_org_via_port_cd" style="width:50px;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="5" class="input" id="frm_org_via_port_cd" /> </td>
	                    <th>Dest. Via</th>
	                    <td><input type="text" name="frm_dest_via_port_cd" style="width:50px;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="5" class="input" id="frm_dest_via_port_cd" /> </td>
	                    <th>Destination</th>
	                    <td><input type="text" name="frm_dest_pnt_loc_cd" style="width:70px;text-align:center;ime-mode:disabled;" dataformat="engup" maxlength="5" class="input" id="frm_dest_pnt_loc_cd" /> </td>
	                    <th>Tariff Rate Item(TRI)</th>
						<td><input type="text" name="frm_tri_no" style="width:192px;text-align:center;" class="input" id="frm_tri_no" /></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>			
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid clear" style="display:none;">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div class= "opus_design_data">
			<table class="grid_2">
				<tbody>
					<colgroup>
						<col width="25%"/>
						<col width="25%"/>
						<col width="25%"/>
						<col width="*"/>
				    </colgroup>
					<tr>
	                    <th style="text-align: center;font-weight: bold;">Origin</th>
	                    <th style="text-align: center;font-weight: bold;">Origin Via</th>
	                    <th style="text-align: center;font-weight: bold;">Destination Via</th>
	                    <th style="text-align: center;font-weight: bold;">Destination</th>
	                </tr>
	                <tr>
	                    <td><textarea name="frm_org_pnt_loc_nm" style="width:100%; height:80px;" class="textarea2" readonly="readonly"></textarea></td>
	                    <td><textarea name="frm_org_via_port_nm" style="width:100%; height:80px;" class="textarea2" readonly="readonly"></textarea></td>
	                    <td><textarea name="frm_dest_via_port_nm" style="width:100%; height:80px;" class="textarea2" readonly="readonly"></textarea></td>
	                    <td><textarea name="frm_dest_pnt_loc_nm" style="width:100%; height:80px;" class="textarea2" readonly="readonly"></textarea></td>
	                </tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</form>
