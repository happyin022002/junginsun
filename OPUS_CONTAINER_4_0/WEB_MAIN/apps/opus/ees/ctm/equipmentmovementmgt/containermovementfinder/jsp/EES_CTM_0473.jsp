<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0473.jsp
*@FileTitle : EQR Reference No Search
*@author     : CLT
*@version    : 1.0
*@since      : 2016/01/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0473Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0473Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet list count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMasterDataMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0473Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
  
  // Duration end date(Today)
  String pDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // Duration start date(Today -1 Month)
  String pDate1 = DateTime.addMonths(pDate2, -1, "yyyy-MM-dd");
%>

<script type="text/javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>

<form name="form">
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span>&nbsp;EQR Reference No Search</span></h2>
        <!-- page_title(E) -->
            
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn" >
        	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>&nbsp;<!--
            --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>&nbsp;<!--
        	--><button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->


<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 검색영역 -->
<div class="layer_popup_contents">
<div class="wrap_search">
    <div class="opus_design_inquiry">       
         <!-- biz_1 (S) -->
         <table border="0" >
	       <tr>
	         
	         <td width="90px"></td>
	         <th style="width:80px; text-align:left;">&nbsp;From<th style="width:150px; text-align:left;">&nbsp;To</th>
	         <th style="width:40px; text-align:left;"></th><td></td>
	         
	       </tr>
	       <tr>
	         
	         <td>
	           <input type="radio" name="etd_eta" id="etd_eta" value="D" class="trans" checked>ETD&nbsp;&nbsp;&nbsp;
	           <input type="radio" name="etd_eta" id="etd_eta" value="A" class="trans">ETA&nbsp;&nbsp;&nbsp;
	         </td>
	         <td style="text-align:left;"><input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1">~</td>
	         <td style="text-align:left;"><input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2"><!--
	            --><button type="button" class="calendar" name="btn_Calendar" id="btn_Calendar"></button></td>
	         <th></th><td></td>
	         
	       </tr>
           <tr>
           
             <th class="align_left">Location (ECC)</th>
             <td><input type="text" style="width:80px;ime-mode:disabled;" class="input" maxlength="5" tabindex="1" name="fm_ecc_cd" dataformat="engup"></td>
             <td><input type="text" style="width:80px;ime-mode:disabled;" class="input" maxlength="5" tabindex="2" name="to_ecc_cd" dataformat="engup"></td>
             <th class="align_left">Type</th>
	         <td>
	           <select style="width:80px;" tabindex="3" name="p_eq_type" id="p_eq_type">
                <option value="">ALL</option>
                <option value="T.VVD">T.VVD</option>
                <option value="T/R/W">T/R/W</option>
                <option value="LCC Int.">LCC Int.</option>
                <option value="ON/OFH">ON/OFH</option>
               </select> 
	         </td>
           </tr>
           <tr>
           
             <th class="align_left">Location</th>
             <td><input type="text" style="width:80px;ime-mode:disabled;" class="input" maxlength="5" tabindex="4" name="fm_loc_cd" dataformat="engup"></td>
             <td><input type="text" style="width:80px;ime-mode:disabled;" class="input" maxlength="5" tabindex="5" name="to_loc_cd" dataformat="engup"></td>
             <th class="align_left">Item</th>
	         <td>
	           <select style="width:80px;" tabindex="6" name="p_item" id="p_item">
                <option value="">ALL</option>
                <option value="T.VVD">T.VVD</option>
                <option value="Truck">Truck</option>
                <option value="Rail">Rail</option>
                <option value="Water">Water</option>
                <option value="B"> </option>
               </select> 
	         </td>
           </tr>
         </table>
         <!-- biz_1 (E) -->
    </div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" >
    <!-- opus_grid_btn(S) -->
    <!-- opus_grid_btn(E) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>

</form>