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
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0061Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
			CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
			//ESD_SCE_0061Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
			//ESD_SCE_0061EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)
			//Exception serverException   = null;            			//서버에서 발생한 에러

			//String strErrMsg = "";                                  //에러메세지


			//DBRowSet rowSet      = null;                            //DB ResultSet

			//int rowCount     = 0;                                   //DB ResultSet 리스트의 건수

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
<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
                //getCodeComboSheet(String variable, String table, String valueField, String textField, String whereField, String orderByField)
	<%=codeUtil.searchCodeComboSheet("CUST_EDI_STS_CD", "EDI_GRP_CGO", "CUST_EDI_STS_CD", "CUST_EDI_STS_CD", "edi_grp_cd = '"+edi_grp_cd+"' AND EDI_STND_STS_CD='"+edi_sts+"'", null)%>

    function setupPage(){
        loadPage();
        var formObject = document.form ;
    }

</script>

</head>


<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="bkg_no" value=<%=bkg_no %>>
<input type="hidden" name="bkg_no_split" value=<%=bkg_no_split %>>
<input type="hidden" name="cntr_no" value=<%=cntr_no %>>
<input type="hidden" name="edi_sts" value=<%=edi_sts %>>
<input type="hidden" name="edi_grp_cd" value=<%=edi_grp_cd %>>
<input type="hidden" name="cust_st">
<input type="hidden" name="dtl_nod_cd" value=''>
<input type="hidden" name="TRANS_RESULT_KEY" value=''>




<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Cargo Tracking EDI Save/Send - individual</td></tr>
		</table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="Grid2" border="0" style="width:480;">
						<tr class="h23">
							<td  width=70 align="middle" style="background-color:#EAE9F3;">BKG No</td>
							<td width=100><%= bkg_no + bkg_no_split %></td>
							<td  width=80 align="middle" style="background-color:#EAE9F3;">CNTR No</td>
							<td width=120 colspan=4><%= cntr_no %></td>
						</tr>
						<tr class="h23">
							<td  width=70 align="middle" style="background-color:#EAE9F3;">EDI STS</td>
							<td  width=400 colspan=6><input type='text' style="border:0;width=400" name='edi_sts_desc' value='' readonly>
							<%= ediDesc %>
							</td>
						</tr>
						<tr class="h23">
							<td  width=70 align="middle" style="background-color:#EAE9F3;">CUST STS</td>
							<td  colspan=6>
							<textarea width=400 colspan=6 style="border:0;width=400" name='cust_sts_desc' value='' readonly  cols="100">
							</textarea>
							</td>
						</tr>
					</table>
				</td></tr>
		</table>
<table class="height_10"><tr><td></td></tr></table>
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
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btng_edisend" id="btng_edisend">Send</td><td class="btn1_right"></td></tr></table></td>
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

