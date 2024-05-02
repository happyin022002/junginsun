<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4011.jsp
*@FileTitle  : Surcharge Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.surcharge.surcharge.event.EsmPri4011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri4011Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String[] svcScpCds = null; 
    String[] chgCd = null; 
    String[] pctBseCd = null;
    String[] scgImdgClssCd = null;
    String[] orgTrspModCd = null;
    String[] destTrspModCd = null;
    String[] usaSvcModCd = null;
    String[] prcRcvTermCd = null;
    String[] prcDeTermCd = null;
    String[] prcHngrBarTpCd = null;
    String[] payTermCd = null;
    String[] ratUtCd = null;
    String[] prcCgoTpCd = null;
    String[] currCd = null;
    String[] dirCallFlg = null;
    String[] socFlg = null;
    String[] ioGaCd = null;
    String[] subTrdCd = null;
    String[] cntrSzCd = null;
    String[] cnlTzCd = null;
    String[] bkgEsvcTpCd = null;    	//B/I
    String pSvcScpCd = null;
    
    Logger log = Logger.getLogger("com.clt.apps.Surcharge.Surcharge");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri4011Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

         
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        chgCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("chgCd"));
        pctBseCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("pctBseCd"), false);
        scgImdgClssCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scgImdgClssCd"),true,"|","\t","getCode","getName");
        orgTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("orgTrspModCd"), false,"|","\t","getCode","getName");
        destTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("destTrspModCd"), false,"|","\t","getCode","getName");
        usaSvcModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("usaSvcModCd"), false,"|","\t","getCode","getName");
        prcRcvTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcRcvTermCd"), false,"|","\t","getCode","getName");
        prcDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcDeTermCd"), false,"|","\t","getCode","getName");
        prcHngrBarTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcHngrBarTpCd"), false,"|","\t","getCode","getName");
        payTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("payTermCd"), false,"|","\t","getCode","getName");
        ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
        prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
        currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"), false,"|","\t");
        dirCallFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dirCallFlg"), false,"|","\t","getCode","getName");
        socFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("socFlg"), false,"|","\t","getCode","getName");
        ioGaCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ioGaCd"), false,"|","\t","getCode","getName");
        subTrdCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("subTrdCd"), true,"|","\t");
        cntrSzCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("cntrSzCd"),true,"|","\t");
        cnlTzCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cnlTzCd"), false,"|","\t","getCode","getName");
        bkgEsvcTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false,"|","\t","getCode","getName");
        pSvcScpCd = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    var svcScpComboValue = " |<%=svcScpCds[0]%>";  
    var svcScpComboText = " |<%=svcScpCds[1]%>";
    var chgCdComboValue = " |<%=chgCd[0]%>";
    var chgCdComboText = " |<%=chgCd[1]%>";
    var prcRcvTermCdComboValue = " |<%=prcRcvTermCd[0]%>";
    var prcRcvTermCdComboText = " |<%=prcRcvTermCd[1]%>";
    var prcDeTermCdComboValue = " |<%=prcDeTermCd[0]%>";
    var prcDeTermCdComboText = " |<%=prcDeTermCd[1]%>";
    var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>";
    var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";
    var scgImdgClssCdComboValue = "<%=scgImdgClssCd[0]%>";
    var scgImdgClssCdComboText = "<%=scgImdgClssCd[1]%>";
    var ratUtCdComboValue = " |<%=ratUtCd[0]%>";
    var ratUtCdComboText = " |<%=ratUtCd[1]%>";
    var cntrSzCdComboValue = " |<%=cntrSzCd[0]%>";
    var cntrSzCdComboText = " |<%=cntrSzCd[1]%>";
    
    var pctBseCdComboValue = " |<%=pctBseCd[0]%>"; 
    var pctBseCdComboText = " |<%=pctBseCd[1]%>";
    var orgTrspModCdValue = " |<%=orgTrspModCd[0]%>";
    var orgTrspModCdText = " |<%=orgTrspModCd[1]%>";
    var destTrspModCdValue = " |<%=destTrspModCd[0]%>";
    var destTrspModCdText = " |<%=destTrspModCd[1]%>";
    var usaSvcModCdValue = " |<%=usaSvcModCd[0]%>";
    var usaSvcModCdText = " |<%=usaSvcModCd[1]%>";
    var prcRcvTermCdValue = " |<%=prcRcvTermCd[0]%>";
    var prcRcvTermCdText = " |<%=prcRcvTermCd[1]%>";
    var prcDeTermCdValue = " |<%=prcDeTermCd[0]%>";
    var prcDeTermCdText = " |<%=prcDeTermCd[1]%>";
    var prcHngrBarTpCdValue = " |<%=prcHngrBarTpCd[0]%>";
    var prcHngrBarTpCdText = " |<%=prcHngrBarTpCd[1]%>";
    var payTermCdValue = " |<%=payTermCd[0]%>";
    var payTermCdText = " |<%=payTermCd[1]%>";
    var ratUtCdValue = " |<%=ratUtCd[0]%>";
    var ratUtCdText = " |<%=ratUtCd[1]%>";
    var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
    var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
    var scgImdgClssCdValue = " |<%=scgImdgClssCd[0]%>";
    var scgImdgClssCdText = " |<%=scgImdgClssCd[1]%>";
    var currCdValue = " |<%=currCd[0]%>";
    var currCdText = " |<%=currCd[1]%>";
    var dirCallFlgValue = "<%=dirCallFlg[0]%>";
    var dirCallFlgText = "<%=dirCallFlg[1]%>";
    var socFlgValue = "<%=socFlg[0]%>";
    var socFlgText = "<%=socFlg[1]%>";
    var ioGaCdValue = "<%=ioGaCd[0]%>";
    var ioGaCdText = "<%=ioGaCd[1]%>";
    var subTrdCdValue = " |<%=subTrdCd[0]%>";
    var subTrdCdText = " |<%=subTrdCd[1]%>";
    var cnlTzCdValue = " |<%=cnlTzCd[0]%>";
    var cnlTzCdText = " |<%=cnlTzCd[1]%>";
    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";
    
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
<input type="hidden" name="cd" >

<%
    if (!pSvcScpCd.equals("")) {
%>

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Surcharge Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
        --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_directdownexcel" id="btn_directdownexcel">Direct Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>


<%
    } else {
%>

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn"><!--
    --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
    --><button type="button" class="btn_normal" name="btn_directdownexcel" id="btn_directdownexcel">Direct Down Excel</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<%
    }
%>


<div class="wrap_search">
	<!-- inquiry_area(S) -->
	<div class="opus_design_inquiry">
	    <!--  biz_1 (S) -->
	    <table>
	        <colgroup>
	            <col width="75px"  />
	            <col width="115px" />
	            <col width="70px"  />
	            <col width="180px" />
	            <col width="90px"  />
	            <col width="110px" />
	            <col width="82px"  />
	            <col width="130px" />
	            <col width="25px"  />
	            <col width=""      />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>SVC Scope.</th>
	                <td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 80, 0, 0, 0, false);</script></td>
	                <th title="Place of Receipt">POR</th>
	                <td><input type="text" name="por_def_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled; width:80px;"></td> 
	                <th title="Port of Loading">POL</th>
	                <td><input type="text" name="pol_def_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled; width:80px;"></td>
	                <th title="Port of Discharging">POD</th>
	                <td><input type="text" name="pod_def_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled; width:80px;"></td>
	                <th title="Place of Delivery">DEL</th>
	                <td><input type="text" name="del_def_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled; width:80px;"></td>
	            </tr>
	            <tr>
	                <th>Charge</th>
	                <td><script type="text/javascript">ComComboObject('chg_cd', 2, 80, 0, 0, 0, false);</script></td>
	                <th>R/D</th> 
	                <td>
	                    <script type="text/javascript">ComComboObject('prc_rcv_term_cd', 1, 80, 0, 0, 0, false);</script><!--
	                    --><script type="text/javascript">ComComboObject('prc_de_term_cd', 1, 80, 0, 0, 0, false);</script>
	                </td>
	                <th>Access Date</th>
	                <td><input type="text" name="eff_dt" style="width:80px;" dataformat="ymd" maxlength="10" class="input1"></td>
	                <th>Update Date</th>
	                <td><input type="text" name="upd_dt" style="width:80px;" dataformat="ymd" maxlength="10" caption="Update Date" class="input"></td>
	                <th>Lane</th>
	                <td><input type="text" id="vsl_slan_cd" name="vsl_slan_cd" maxlength="3" dataformat="engup" style="ime-mode:disabled; width:80px;"></td>
	            </tr>
	            <tr>
	                <th>Cargo Type</th>
	                <td><script type="text/javascript">ComComboObject('prc_cgo_tp_cd', 2, 80, 0, 0, 0, false);</script></td>
	                <th>IMDG Class</th>
	                <td><script type="text/javascript">ComComboObject('scg_imdg_clss_cd', 2, 50, 0, 0, 0, false);</script></td>
	                <th>PER Type</th>
	                <td><script type="text/javascript">ComComboObject('rat_ut_cd', 2, 50, 0, 0, 0, false);</script></td>
	                <th>Size </th>
	                <td colspan="3"><script type="text/javascript">ComComboObject('cntr_sz_cd', 2, 50, 0, 0, 0, false);</script></td>
	            </tr>
	            <tr>
	                <td colspan="6"></td>
	                <td colspan="2"><input type="hidden" name="wdr_flg" id="wdr_flg" value="Y" class="trans"><label for="wdr_flg"><!-- <b>Inc. Deleted Data</b> --></label></td>
	                <td colspan="2">
	                    <button type="button" class="btn_etc" name="btn_loc_grp_pop" id="btn_loc_grp_pop">Location Group</button>
	                </td>
	            </tr>
	        </tbody>
	    </table>
	    <!--  biz_1   (E) -->   
	</div>
	<!-- inquiry_area(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div id="hiddenSheetLayer" style="display: none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>