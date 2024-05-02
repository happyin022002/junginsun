<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_SCE_0035.jsp
*@FileTitle : EDI Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0060Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0060EventResponse"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
			//CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
            EsdSce0060Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
            EsdSce0060EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
			Exception serverException   = null;            			//error from server

			String strErrMsg = "";                                  //error message

			//String successFlag = "";
			//String codeList  = "";
			//String pageRows  = "100";

			DBRowSet rowSet      = null;                            //DB ResultSet

			int rowCount     = 0;                                   //count of DB resultSET list

			String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
			String bkg_no_split = JSPUtil.getNull(request.getParameter("bkg_no_split"));
			String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));
			String vvd = JSPUtil.getNull(request.getParameter("vvd"));
			String bl_no = JSPUtil.getNull(request.getParameter("bl_no"));
			String por_cd = JSPUtil.getNull(request.getParameter("por_cd"));
			String pol_cd = JSPUtil.getNull(request.getParameter("pol_cd"));
			String pod_cd = JSPUtil.getNull(request.getParameter("pod_cd"));
			String del_cd = JSPUtil.getNull(request.getParameter("del_cd"));
			String cop_no = JSPUtil.getNull(request.getParameter("cop_no"));
			String edi_grp_cd = JSPUtil.getNull(request.getParameter("edi_grp_cd"));


			if(bkg_no_split.equals("")){
				bkg_no_split = "  ";
			}



    try {

    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsdSce0060Event)request.getAttribute("Event");
            eventResponse = (EsdSce0060EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRowSet();
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
<title>Welcome to OPUS!</title>


<script type="text/javascript">

    function setupPage(){
        loadPage();
        doActionIBSheet0(sheetObjects[0],document.form,IBSEARCH)
    }

</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="cop_no" value="<%= cop_no %>" id="cop_no" />
<input type="hidden" name="edi_grp_cd" value="<%= edi_grp_cd %>" id="edi_grp_cd" />

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">Actual Activity Inquiry Pop-up</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"></col>
				<col width="243"></col>
				<col width="55"></col>
				<col width="202"></col>
				<col width="65"></col>
				<col width="*"></col>
			</colgroup>
			<tbody>
				<tr>
					<th>Booking No.</th>
					<td><input name="bkg_no" type="text" class="input" style="width:102px; text-transform:uppercase;" value="<%= bkg_no + bkg_no_split %>" id="bkg_no" /> </td>

					<th>B/L No.</th>
					<td><input name="bl_no" type="text" class="input" style="width:102px; text-transform:uppercase;" value="<%= bl_no %>" id="bl_no" /> </td>

					<th>CNTR No.</th>
					<td><input name="cntr_no" type="text" class="input" style="width:102px; text-transform:uppercase;" value="<%= cntr_no %>" id="cntr_no" /> </td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="80"></col>
				<col width="119"></col>
				<col width="30"></col>
				<col width="119"></col>
				<col width="30"></col>
				<col width="119"></col>
				<col width="30"></col>
				<col width="120"></col>
				<col width="30"></col>
				<col width="*"></col>
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input name="vvd" type="text" class="input" style="width:70px; text-transform:uppercase;" value="<%= vvd %>" id="vvd" /> </td>
					<th title="Place of Receipt">POR</th>
					<td><input name="por" type="text" class="input" style="width:70px; text-transform:uppercase;" value="<%= por_cd %>" id="por" /> </td>
					<th title="Port of Loading">POL</th>
					<td><input name="pol" type="text" class="input" style="width:70px; text-transform:uppercase;" value="<%= pol_cd %>" id="pol" /> </td>
					<th title="Port of Discharging">POD</th>
					<td><input name="pod" type="text" class="input" style="width:70px; text-transform:uppercase;" value="<%= pod_cd %>" id="pod" /> </td>
					<th title="Place of Delivery">DEL</th>
					<td><input name="del" type="text" class="input" style="width:70px; text-transform:uppercase;" value="<%= del_cd %>" id="del" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('t1sheet');</script>
	</div>
</div>
