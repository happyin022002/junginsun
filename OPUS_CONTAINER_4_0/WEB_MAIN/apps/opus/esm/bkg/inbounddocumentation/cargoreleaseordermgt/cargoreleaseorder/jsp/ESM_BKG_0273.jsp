<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0273.jsp
*@FileTitle : Full CNTR Release Order History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0273Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0273Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.CargoReleaseOrderBC");

    String bl_no = JSPUtil.getNull(request.getParameter("bl_no"));
    String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));
    String mode = "";
    if(bl_no.length() >= 12) mode = "POPUP";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg0273Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_rad" value="VVD">
<input type="hidden" name="f_mod" value="<%=mode %>">


<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
   <div class="opus_design_btn">
	   <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
	   <button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	   <button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
	   <%if(bl_no.length() >= 12){ %>
          <button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
       <%} %>
   </div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search">
	<div class="opus_design_inquiry">		
		<table class="search" border="0" style="width:979px;"> 
		     <tr>        
		       <td>
		         <table class="search sm" border="0" style="width:98%;"> 
		           <tr>             
		             <th width="132px"><input type="radio" value="" class="trans" name="rad_rlse_dt">&nbsp;Released Date</th>
		             <td width="225px"><input type="text" style="width:78px;ime-mode:disabled;" caption="Released Date"  class="input1" value="" name="in_cre_dt_from" dataformat="ymd">&nbsp;~&nbsp;<input type="text" style="width:78px;ime-mode:disabled;" caption="Released Date" class="input1" value="" name="in_cre_dt_to" dataformat="ymd">
					<button type="button" id="btn_dtt" name="btn_dtt" class="calendar ir"></button></td>
		             <th width="43px"><input type="radio" value="" class="trans" name="rad_vvd">&nbsp;VVD</th>
		             <td width="90px"><input type="text" style="width:90px;ime-mode:disabled;" caption="VVD" class="input1" value="" name="in_vvd" dataformat="engup"  maxlength="9"  fullfill="fullfill"></td>
		             <th width="25px">POD</th>
		             <td width="65px"><input type="text" style="width:55px;ime-mode:disabled;" caption="POD" class="input1" value="" name="in_pod_cd" dataformat="engup"  maxlength="5"  fullfill="fullfill"></td>
		             <th width="85px"><input type="radio" value="" class="trans" name="rad_bl">&nbsp;B/L No.</th>
		             <td width=""><input type="text" style="width:95px;ime-mode:disabled;" caption="B/L No" value="<%=bl_no %>" name="in_bl_no" dataformat="engup" maxlength="12"  ></td>
		           </tr> 
		         </table>
		       </td>
		       <th width="25px">CNTR</th>
		       <td width="95px"><input type="text" style="width:90px;ime-mode:disabled;" class="input" value="<%=cntr_no %>" name='in_cntr_no' dataformat="engup"  maxlength="14"></td>
		       <th width="54px">P/Up CY</th>
		       <td width="65px"><input type="text" style="width:65px;ime-mode:disabled;" class="input" value="" name="in_yd_cd" dataformat="engup"  maxlength="7"></td>
		     </tr> 
		</table>        
	</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
	<div class="opus_design_grid">	
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- 시트영역 -->

</form>
 