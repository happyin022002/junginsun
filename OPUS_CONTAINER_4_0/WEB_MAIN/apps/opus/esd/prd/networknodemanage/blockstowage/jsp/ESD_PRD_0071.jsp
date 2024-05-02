<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0071.jsp
*@FileTitle  :  Block Stowage Group Creation & Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.event.EsdPrd0071Event"%>
<%
	EsdPrd0071Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //error from server
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //error message
    int rowCount     = 0;                                  //count of DB resultSET list
    try {
        event = (EsdPrd0071Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    function setupPage(){
	    loadPage();
    }
</script>
<form name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button>
		<button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr class="h23">
					 <th style="width:40px;text-align:left;">Status</th>
                        <td style="width:90px;"><select name="del_flag" style="width: 70;">
                            <option value="A">All</option>
                            <option value="N" selected>Live</option>
                            <option value="Y">Deleted</option>
                        </select></td>
                        <th style="width:35px;text-align:left;">POD</th>
                        <td style="width:70px;"><input type="text" name="pod_code" id="pod_code" value="" maxlength="5"  style="width: 60px;text-align:center" dataformat="engup" style="text-align:center" ></td>
                         <th style="width:30px;text-align:left;">HUB</th>
                        <td style="width:70px;"><input type="" name="hub_code" id="hub_code"  value="" maxlength="5" style="width: 60px;text-align:center" dataformat="engup" style="text-align:center"></td>
                         <th style="width:35px;text-align:left;">LANE</th>
                        <td style="width:70px;"><input type="" name="lane_code" id="lane_code" value="" maxlength="3" style="width: 60px;text-align:center" dataformat="engup" style="text-align:center"></td>
                        <th style="width:45px;text-align:left;">GROUP</th>
                        <td style="width:70px;"><input type="" name="group_code" id="group_code" value="" maxlength="3" style="width: 60px;text-align:center" dataformat="engup" style="text-align:center"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->


<!-- opus_design_grid(S) -->
<div class="wrap_result" >
	<div class="opus_design_grid ">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_RowCopy" 	id="btn_RowCopy">Row Copy</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>