<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0035.jsp
*@FileTitle : EDI Search
*Open Issues :
*Change history :
*   - 2006-10-12 : UI 변경으로 인한 수정
*@LastModifyDate : 2006-10-12
*@LastModifier : Yong-cheon Shin
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
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0060Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0060EventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
			//CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
            EsdSce0060Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
            EsdSce0060EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
			Exception serverException   = null;            			//서버에서 발생한 에러

			String strErrMsg = "";                                  //에러메세지

			//String successFlag = "";
			//String codeList  = "";
			//String pageRows  = "100";

			DBRowSet rowSet      = null;                            //DB ResultSet

			int rowCount     = 0;                                   //DB ResultSet 리스트의 건수

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
<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){
        loadPage();
        doActionIBSheet0(sheetObjects[0],document.form,IBSEARCH)
    }

</script>

</head>


<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cop_no" value='<%= cop_no %>'>
<input type="hidden" name="edi_grp_cd" value='<%= edi_grp_cd %>'>

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Actual Activity Inquiry Pop-up</td></tr>
		</table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" style="width:750;">
						<tr class="h23">
							<td width="80">Booking No.</td>
							<td width="243"><input name="bkg_no"  type="text" class="input" style="width:102; text-transform:uppercase;"  value="<%= bkg_no + bkg_no_split %>"></td>

							<td width="55">B/L No.</td>
							<td width="202"><input name="bl_no"  type="text" class="input" style="width:102; text-transform:uppercase;"  value="<%= bl_no %>"></td>

							<td width="65">CNTR No.</td>
							<td><input name="cntr_no"  type="text" class="input" style="width:102; text-transform:uppercase;"  value="<%= cntr_no %>"></td>


						</tr>
					</table>
					<table class="search" border="0" style="width:750;">
						<tr class="h23">
							<td width="80">VVD</td>
							<td width="119"><input name="vvd" type="text"  class="input" style="width:70; text-transform:uppercase;"  value="<%= vvd %>" ></td>
							<td width="30">POR</td>
							<tD width="119"><input name="por"   type="text" class="input" style="width:70; text-transform:uppercase;"  value="<%= por_cd %>"></TD>
							<TD width="30">POL</td>
							<td width="119"><input name="pol"  type="text" class="input" style="width:70; text-transform:uppercase;"  value="<%= pol_cd %>"></td>
							<td width="30">POD</td>
							<td width="120"><input name="pod"  type="text" class="input" style="width:70; text-transform:uppercase;"  value="<%= pod_cd %>"></td>
							<td width="30">DEL</td>
							<td><input name="del"  type="text" class="input" style="width:70; text-transform:uppercase;"  value="<%= del_cd %>">

							</td>
						</tr>

					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab">
       	<tr><td>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

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
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->

</td></tr>
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


</body>

</html>

