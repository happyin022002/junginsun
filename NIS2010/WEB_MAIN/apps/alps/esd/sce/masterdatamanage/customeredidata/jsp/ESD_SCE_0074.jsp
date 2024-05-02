<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0074.jsp
*@FileTitle : Missing List
*Open Issues :
*Change history :
* 2008-04-04 sanghyun kim
* 1.0 최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0074Event"%>
<%//@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0074EventResponse"%>
<%@ page import="com.hanjin.framework.core.layer.event.EventResponse"%>

<%
    EsdSce0074Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
    //EsdSce0074EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
    EventResponse eventResponse = null;
	Exception serverException   = null;            			//서버에서 발생한 에러

	String strErrMsg = "";                                  //에러메세지
	DBRowSet rowSet      = null;                            //DB ResultSet
	int rowCount     = 0;                                   //DB ResultSet 리스트의 건수

	String diff = JSPUtil.getNull(request.getParameter("diff"));   // total 인지  missing 인지 on-time-list인지를 구분한다.
	String missing_cnt = JSPUtil.getNull(request.getParameter("missing_cnt"));    //    missing or total 의 갯수
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
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){
        loadPage();
        var formObject = document.form ;
    }

</script>
</head>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="edi_sts" value="<%=missing_status%>">
<input type="hidden" name="day" value="<%=day%>">
<input type="hidden" name="cust_sts" value="<%=cust_sts%>">
<input type="hidden" name="missing_cnt" value="<%=missing_cnt%>">
<input type="hidden" name="cs_grp_id" value="<%=cs_grp_id%>">
<input type="hidden" name="trs_mode" value="<%=trs_mode%>">
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="por" value="<%=por%>">
<input type="hidden" name="pol" value="<%=pol%>">
<input type="hidden" name="pod" value="<%=pod%>">
<input type="hidden" name="del" value="<%=del%>">
<input type="hidden" name="diff" value="<%=diff%>">
<input type="hidden" name="title_row" value="<%=title_Row%>">
<input type="hidden" name="pol_fromdate" value="<%=fromddt%>"><!-- poletdDate1 pol_fromdate -->
<input type="hidden" name="pol_todate" value="<%=toddt%>"><!-- poletdDate2 pol_todate -->
<input type="hidden" name="pod_fromdate" value="<%=fromadt%>"><!-- podetaDate1 pod_fromdate -->
<input type="hidden" name="pod_todate" value="<%=toadt%>"><!--podetaDate2  pod_todate -->
<input type="hidden" name="bkg_no" value="<%=bkgno%>">
<input type="hidden" name="bl_no" value="<%=blno%>">
<input type="hidden" name="cntr_no" value="<%=cntrno%>">
<input type="hidden" name="copsts" value="<%=copsts%>">
<input type="hidden" name="sendClose" value="">
<input type="hidden" name="pagerows" value="300">
<input type="hidden" name="i_page" value="1">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<% if(diff.equals("1")){ %>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<td class="title"><img src="/hanjin/img/icon_title_dot.gif" width="9" height="9"> Missing List </td></tr>
			</table>
		<% } else if(diff.equals("2"))  { %>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<td class="title"><img src="/hanjin/img/icon_title_dot.gif" width="9" height="9"> Total List </td></tr>
			</table>
		<% } else { %>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<td class="title"><img src="/hanjin/img/icon_title_dot.gif" width="9" height="9"> On-Time List </td></tr>
			</table>
		<% } %>



			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr><td class="btn1_bg">

										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<% if(diff.equals("1") || diff.equals("2")){ %>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btng_send" id="btng_send">Send</td><td class="btn1_right"></td></tr></table></td>
											<% } %>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_saveas" id="btn_saveas">Save As</td><td class="btn1_right"></td></tr></table></td>

											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
						</table>


		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
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
					</table>
				</td>
			</tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>

		<table class="tab">
       		<tr><td>
		</table>

		<div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
				<tr>
					<td class="bg">
						<table class="height_10"><tr><td></td></tr></table>

	                    <table width="100%" id="mainTable">
	                        <tr><td>
	                             <script language="javascript">ComSheetObject('t1sheet');</script>
	                        </td></tr>
	                    </table>
					<!-- : ( Speed ) (E) -->

				</td></tr>
			</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>

	</td></tr>
</table>

</body>
</html>
