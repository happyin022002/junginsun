<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_1035.jsp
*@FileTitle  : CY or Destuffing Setup(Vietnam) Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1035Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1035Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from the server
    String strErrMsg = "";                      // error messege
    int rowCount     = 0;                       //the number of DB ResultSet List

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.CargoReleaseOrderMgtSC.CargoReleaseOrderBC");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg1035Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // extract additional data obtained from the server during Initial loading ..
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
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<input type="hidden" name="pagerows">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>CY or Destuffing Setup (Vietnam)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Setup" id="btn_Setup">Setup</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			 <table width="100%"  id="mainTable">
                <tr class="h23">
                    <td width="130">CY or Destuffing</td>
                    <td width="">
                        <select style="width:270;" name='vn_cgo_de_cd'>
                            <option value="A" selected>CY Delivery “HANG GIAO THANG TAI BAI”</option>
                            <option value="B">CY Destuffing “HANG RUT RUOT TAI BAI”</option>
                        </select>
                    </td>
                </tr> 
               </table>      
		</div>
	</div>

	<div class="wrap_result" style='display:none'>
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->       
</form>