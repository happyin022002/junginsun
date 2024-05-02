<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0037.jsp
*@FileTitle : EDI Search
*Open Issues :
*Change history :
*   - 2006-10-12 : UI 변경으로 인한 수정
*@LastModifyDate : 2006-10-12
*@LastModifier : Seong-mun Kang
*@LastVersion : 2.0
* 2006-08-29 yong cheon shin
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0037Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0037EventResponse"%>

<%
			ESD_SCE_0037Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
			ESD_SCE_0037EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
			Exception serverException   = null;            			//서버에서 발생한 에러

			String strErrMsg = "";                                  //에러메세지

			//String successFlag = "";
			//String codeList  = "";
			//String pageRows  = "100";

			String edi_grp_cd = JSPUtil.getNull(request.getParameter("edi_grp_cd"));
			String truck_vvd = JSPUtil.getNull(request.getParameter("vvd"));
			String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
			String bkg_no_split = JSPUtil.getNull(request.getParameter("bkg_no_split"));
			String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));

			DBRowSet rowSet      = null;                            //DB ResultSet

			int rowCount     = 0;                                   //DB ResultSet 리스트의 건수

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
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">

    function setupPage(){
    	    loadPage();
    	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         /*******************************************************/
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
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;EDI Sending History</td></tr>
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
