<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0061.js
*@FileTitle  : Cargo Tracking EDI Save/Send - individual
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
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0061Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
			CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
			//ESD_SCE_0061Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
			//ESD_SCE_0061EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
			//Exception serverException   = null;            			//Error On Server Side

			//String strErrMsg = "";                                  //Error Message


			//DBRowSet rowSet      = null;                            //DB ResultSet

			//int rowCount     = 0;                                   //DB ResultSet List Count

			String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
			String bkg_no_split = JSPUtil.getNull(request.getParameter("bkg_no_split"));
			String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));

			String edi_sts = JSPUtil.getNull(request.getParameter("edi_sts"));

			String edi_grp_cd = JSPUtil.getNull(request.getParameter("edi_grp_cd"));
			String ediDesc = "";

			//String custDesc = "";
/*
    try {

    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (ESD_SCE_0061Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0061EventResponse)request.getAttribute("EventResponse");
            //STS,VSL,EVENT,ediDesc
            if (eventResponse != null) {
                rowSet = eventResponse.getRowSet1();
                if(rowSet != null){
                     rowCount = rowSet.getRowCount();
                     out.println("rowCount:"+rowCount);
                     if(rowSet.next()){
                      	ediDesc = JSPUtil.getNull(rowSet.getString("ediDesc"));
                        out.println("ediDesc:"+ediDesc);
                     }
                } // end if
            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }
*/
%>
<script language="javascript">
                //getCodeComboSheet(String variable, String table, String valueField, String textField, String whereField, String orderByField)
	<%=codeUtil.searchCodeComboSheet("CUST_EDI_STS_CD", "EDI_GRP_CGO", "CUST_EDI_STS_CD", "CUST_EDI_STS_CD", "edi_grp_cd = '"+edi_grp_cd+"' AND EDI_STND_STS_CD='"+edi_sts+"'", null)%>

    function setupPage(){
        loadPage();
        var formObject = document.form ;
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="bkg_no" value="<%=bkg_no %>" id="bkg_no" />
<input type="hidden" name="bkg_no_split" value="<%=bkg_no_split%>" id="bkg_no_split" />
<input type="hidden" name="cntr_no" value="<%=cntr_no%>" id="cntr_no" />
<input type="hidden" name="edi_sts" value="<%=edi_sts%>" id="edi_sts" />
<input type="hidden" name="edi_grp_cd" value="<%=edi_grp_cd %>" id="edi_grp_cd" />
<input type="hidden" name="cust_st" id="cust_st" />
<input type="hidden" name="dtl_nod_cd" value="" id="dtl_nod_cd" />
<input type="hidden" name="TRANS_RESULT_KEY" value="" id="TRANS_RESULT_KEY" />

		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Cargo Tracking EDI Save/Send - individual</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><!--
				--><button type="button" class="btn_normal" name="btng_edisend" 		id="btng_edisend">Send</button><!--
				--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
			<div class="location">
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) -->
		</div>
		<!-- page_title_area(E) -->
	
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table class="grid_2" style="width: 480px;">
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="160"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>BKG No</th>
						<td><%= bkg_no + bkg_no_split %></td>
						<th>CNTR No</th>
						<td><%= cntr_no %></td>
					</tr>	
					<tr>
						<th>EDI STS</th>
						<td colspan="3"><input type='text' style="border:0;width:400px"  name='edi_sts_desc' id='edi_sts_desc' value='' readonly><%= ediDesc %></td>						
					</tr>	
					<tr>
						<th>CUST STS</th>
						<td colspan="3"><textarea  colspan=6 style="border:0;width:400px" name='cust_sts_desc' id='cust_sts_desc' value='' readonly  cols="100"></textarea></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="wrap_result">
			<div class="opus_design_grid clear" >
					<script type="text/javascript">ComSheetObject('t1sheet');</script>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	

</form>




