<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0073.jsp
*@FileTitle : My Performance Report
*Open Issues :
*Change history :
* 2008-04-03 sanghyun kim
* 1.0 쳿첿 ??????
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0073Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
		EsdSce0073Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;            			//???밿?????? 뮿?????? ??????
		String newOld = JSPUtil.getNull(request.getParameter("newOld"));              // 1 ??´면 new , 2 ??´면 Modify
		String repNm = JSPUtil.getNull(request.getParameter("repNm"));
		String grpId = JSPUtil.getNull(request.getParameter("grpId"));
		String grpNm = JSPUtil.getNull(request.getParameter("grpNm"));
		String tpId = JSPUtil.getNull(request.getParameter("tpId"));
		String openPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));

		String strErrMsg = "";                                  //?????￢???¸꽿
		DBRowSet rowSet      = null;                            //DB ResultSet
		int rowCount     = 0;                                   //DB ResultSet 리꿤뿸꽿 건꽿
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId=account.getUsr_id();

    	try{
	    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	    	if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (EsdSce0073Event)request.getAttribute("Event");
	        }
		} catch(Exception e) {
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
        var formObject = document.form ;
    }
</script>
<base target="_self"/>
</head>
<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="newOld" value=<%=newOld%>>
<input type="hidden" name="user_id" value=<%=userId%>>
<input type="hidden" name="cre_usr_id" value=<%=userId%>>
<input type="hidden" name="edi_grp_cd" value=<%=grpId%>>
<input type="hidden" name="edi_grp_id" value=<%=grpId%>>
<input type="hidden" name="tp_cd" value="">
<input type="hidden" name="edi_grp_desc" value="">
<input type="hidden" name="edi_cgo_rmk" value="">
<input type="hidden" name="sendClose" value="">
<input type="hidden" name="openPgmNo" value="<%=openPgmNo%>">
<input type="hidden" name="openRepNm" value="<%=repNm%>">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;My Performance Report</td></tr>
		</table>


		<table class="search">
			<tr>
				<td class = "bg">
					<table class="search" border="0" style="width:470;">
						<tr class="h23">
							<td width="90">&nbsp;Report Name </td>
							<td width="180"><script language="javascript">ComComboObject("mycust", 1,292, 0, 0, 0, false);</script></td>
						</tr>
						<tr class="h23">
							<td width="90">&nbsp;Group ID </td>
							<td width="298">
								<input name="cs_grp_id"  type="text" class="input" style="width:70; text-transform:uppercase;"  value=""  onChange="javascript:onObjectFocusout(this.form)">
								<input name="tp_id"  type="text" class="input" style="width:70; text-transform:uppercase;"  value="" onChange="javascript:onObjectTpId(this.form)">
								<input name="grp_nm"  type="text" class="input" style="width:120; text-transform:uppercase;"  value="" >
								<img onClick="openCustomer()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
							<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
												<td class="btn2_right"></td></tr></table></td>
												<!-- Repeat Pattern -->
											</tr></table>

							</td>
						</tr>
					</table>
				</td>
			</tr>
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
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_delete" id="btn_delete">Delete</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
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