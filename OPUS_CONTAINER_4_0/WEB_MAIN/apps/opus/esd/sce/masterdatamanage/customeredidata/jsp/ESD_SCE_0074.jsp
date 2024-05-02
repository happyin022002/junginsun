<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0074.jsp
*@FileTitle  :  Missing List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0074Event"%>
<%//@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0074EventResponse"%>
<%@ page import="com.clt.framework.core.layer.event.EventResponse"%>

<%
    EsdSce0074Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
    //EsdSce0074EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
    EventResponse eventResponse = null;
	Exception serverException   = null;            			//Error on server side

	String strErrMsg = "";                                  //Error Message
	DBRowSet rowSet      = null;                            //DB ResultSet
	int rowCount     = 0;                                   //DB ResultSet List Count

	String diff = JSPUtil.getNull(request.getParameter("diff"));   // distinguish between total, missing, on-time-list
	String missing_cnt = JSPUtil.getNull(request.getParameter("missing_cnt"));    //    missing or total Count
	String title_Row = JSPUtil.getNull(request.getParameter("title_row"));
	String day = JSPUtil.getNull(request.getParameter("clickday"));	         // 2   ~ 1 day   4   1~2 day   6   2~3      8   3 ~

	String missing_status = JSPUtil.getNull(request.getParameter("missing_status"));
	String cs_grp_id = JSPUtil.getNull(request.getParameter("cs_grp_id"));
	String cust_sts = JSPUtil.getNull(request.getParameter("cust_sts"));

	String trs_mode = JSPUtil.getNull(request.getParameter("trs_mode"));
	String vvd = JSPUtil.getNull(request.getParameter("vvd"));
	String por = JSPUtil.getNull(request.getParameter("por"));
	String pol = JSPUtil.getNull(request.getParameter("pol"));
	String pod = JSPUtil.getNull(request.getParameter("pod"));
	String del = JSPUtil.getNull(request.getParameter("del"));
	String fromddt = JSPUtil.getNull(request.getParameter("fromddt"));
	String toddt = JSPUtil.getNull(request.getParameter("toddt"));
	String fromadt = JSPUtil.getNull(request.getParameter("fromadt"));
	String toadt = JSPUtil.getNull(request.getParameter("toadt"));
	String bkgno = JSPUtil.getNull(request.getParameter("bkg_no"));
	String blno = JSPUtil.getNull(request.getParameter("bl_no"));
	String cntrno = JSPUtil.getNull(request.getParameter("cntr_no"));
	String copsts = JSPUtil.getNull(request.getParameter("copsts"));

	try {
    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsdSce0074Event)request.getAttribute("Event");
            //eventResponse = (EsdSce0074EventResponse)request.getAttribute("EventResponse");
            eventResponse = (EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
               // rowSet = eventResponse.getRowSet();
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

<script type="text/javascript">

    function setupPage(){
        loadPage();
        var formObject = document.form ;
    }

</script>


<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="edi_sts" value="<%=missing_status%>" id="edi_sts" />
<input type="hidden" name="day" value="<%=day%>" id="day" />
<input type="hidden" name="cust_sts" value="<%=cust_sts%>" id="cust_sts" />
<input type="hidden" name="missing_cnt" value="<%=missing_cnt%>" id="missing_cnt" />
<input type="hidden" name="cs_grp_id" value="<%=cs_grp_id%>" id="cs_grp_id" />
<input type="hidden" name="trs_mode" value="<%=trs_mode%>" id="trs_mode" />
<input type="hidden" name="vvd" value="<%=vvd%>" id="vvd" />
<input type="hidden" name="por" value="<%=por%>" id="por" />
<input type="hidden" name="pol" value="<%=pol%>" id="pol" />
<input type="hidden" name="pod" value="<%=pod%>" id="pod" />
<input type="hidden" name="del" value="<%=del%>" id="del" />
<input type="hidden" name="diff" value="<%=diff%>" id="diff" />
<input type="hidden" name="title_row" value="<%=title_Row%>" id="title_row" />
<input type="hidden" name="pol_fromdate" value="<%=fromddt%>" id="pol_fromdate" />
<input type="hidden" name="pol_todate" value="<%=toddt%>" id="pol_todate" />
<input type="hidden" name="pod_fromdate" value="<%=fromadt%>" id="pod_fromdate" />
<input type="hidden" name="pod_todate" value="<%=toadt%>" id="pod_todate" />
<input type="hidden" name="bkg_no" value="<%=bkgno%>" id="bkg_no" />
<input type="hidden" name="bl_no" value="<%=blno%>" id="bl_no" />
<input type="hidden" name="cntr_no" value="<%=cntrno%>" id="cntr_no" />
<input type="hidden" name="copsts" value="<%=copsts%>" id="copsts" />
<input type="hidden" name="sendClose" value="" id="sendClose" />
<input type="hidden" name="pagerows" value="300" id="pagerows" />
<input type="hidden" name="i_page" value="1" id="i_page" />

	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
	   
	   <% if(diff.equals("1")){ %>
			<h2 class="page_title"><span>Missing List </span></h2>
		<% } else if(diff.equals("2"))  { %>
			<h2 class="page_title"><span> Total List </span></h2>
		<% } else { %>
			<h2 class="page_title"><span> On-Time List </span></h2>
		<% } %>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<% if(diff.equals("1") || diff.equals("2")){ %><button type="button" class="btn_accent" name="btng_send" 	id="btng_send">Send</button><% } %><!--
			--><button type="button" class="btn_normal" name="btn_saveas" id="btn_saveas">Save As</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
						<% if(diff.equals("1") || diff.equals("2")){ %>
						<tr class="h23">
							<td>
								&nbsp;&nbsp; Status :&nbsp; <%=missing_status%> (<%=missing_cnt%>)
							</td>
						</tr>
						<% } else if(diff.equals("3") || diff.equals("4")){ %>
						<tr class="h23">
							<td>
								&nbsp;&nbsp; Delays :&nbsp; <%=title_Row%>
							</td>
						</tr>
						<tr class="h23">
							<td>
								&nbsp;&nbsp; Status :&nbsp;  <%=missing_status %>
							</td>
						</tr>
						<% } %>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
		   <script type="text/javascript">ComSheetObject('t1sheet');</script>
		</div>
	</div>
 
</form>
