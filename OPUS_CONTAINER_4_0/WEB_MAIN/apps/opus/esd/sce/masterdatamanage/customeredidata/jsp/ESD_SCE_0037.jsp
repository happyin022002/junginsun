<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0037.jsp
*@FileTitle : EDI Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0037Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0037EventResponse"%>

<%
			ESD_SCE_0037Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
			ESD_SCE_0037EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
			Exception serverException   = null;            			//error from server

			String strErrMsg = "";                                  //error message

			//String successFlag = "";
			//String codeList  = "";
			//String pageRows  = "100";

			String edi_grp_cd = JSPUtil.getNull(request.getParameter("edi_grp_cd"));
			String truck_vvd = JSPUtil.getNull(request.getParameter("vvd"));
			String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
			String bkg_no_split = JSPUtil.getNull(request.getParameter("bkg_no_split"));
			String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));

			DBRowSet rowSet      = null;                            //DB ResultSet

			int rowCount     = 0;                                   //count of DB resultSET list

			//String iPage;


    try {

    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (ESD_SCE_0037Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0037EventResponse)request.getAttribute("EventResponse");
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
<html>
<head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">

    function setupPage(){
    	    loadPage();
    	 
         var sheetObject = sheetObjects[0];
  
         var formObject = document.form;
    	    doActionIBSheet(sheetObject,formObject,IBSEARCH);

    }

</script>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<input    type="hidden" name="edi_grp_cd" value="<%=edi_grp_cd %>">
<input    type="hidden" name="vvd" value="<%=truck_vvd %>">
<input    type="hidden" name="bkg_no"  value="<%=bkg_no %>">
<input    type="hidden" name="bkg_no_split"  value="<%=bkg_no_split %>">
<input    type="hidden" name="cntr_no"  value="<%=cntr_no %>">


<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp;EDI Sending History</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">


				<table class="search" border="0" style="width:717;">
						<tr class="h23">
							<td width="70">Truck VVD</td>
							<td width="150"><input type="text" name='truck_vvd_cd' style="width:100" value="<%=truck_vvd %>"></td>
							<td width="65">CNTR No.</td>
							<td width=""><input type="text" name='cntr_no_cd' style="width:100" value="<%=cntr_no %>"></td>
							</tr>

					</table>


				<!-- : ( Speed ) (S) -->

                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


</body>
</html>
