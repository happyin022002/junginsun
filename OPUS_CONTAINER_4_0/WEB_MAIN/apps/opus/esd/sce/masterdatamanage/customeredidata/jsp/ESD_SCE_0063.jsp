﻿<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0063.jsp
*@FileTitle  : Vessel SKD Query(Common Popup)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0063Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0063EventResponse"%>
<%
    EsdSce0063Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    EsdSce0063EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;            //error from server
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //error message
    int rowCount     = 0;                                  //count of DB resultSET list

    try {
        event = (EsdSce0063Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (EsdSce0063EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRs();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                } // end if
            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<head>
<title>VVD</title>

<script type="text/javascript">
    function setupPage(){

        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage();
    }
</script>
</head>
<form method="post" name="form" onSubmit="return false;" style="margin-top:-16px;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="sdate_hidden" id="sdate_hidden" />
<input type="hidden" name="edate_hidden" id="edate_hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">VVD Inquiry</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ok" 	id="btn_ok">Ok</button><!--  
		--><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />
				<col width="80" />
				<col width="50" />
				<col width="80" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>ETD/ETA</th>
				<td><select class="input1" name="etdeta" style="width:75px;">
					<option value="D">ETD</option>
					<option value="A" selected>ETA</option>
					</select></td>
				<td  class="stm" colspan="4"><!-- 
					 --><input type="text" style="width:75px;" name="sdate" dataformat="ymd" required="" onblur="ComChkObjValid(this, false, false, true)" id="sdate" /><!-- 
					 --><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button><!-- 
					 --><input type="text" style="width:75px;" name="edate"  dataformat="ymd" required="" onblur="ComChkObjValid(this, false, false, true)" id="edate" /><!-- 
					 --><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>
				</td>
			</tr>
			<tr>
				<th>Lane</th>
				<td><input type="text" style="width:75px;" name="lane_cd" maxlength="" onkeyup="javascript:upper(this);" id="lane_cd" /> </td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" style="width:75px;" name="pol_cd" maxlength="" onkeyup="javascript:upper(this);" id="pol_cd" /> </td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" style="width:75px;" name="pod_cd" maxlength="" onkeyup="javascript:upper(this);" id="pod_cd" /> </td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_grid clear">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_new" 	id="btn_new">New</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>				
</form>



 <%@include file="../jsp/common.jsp"%>