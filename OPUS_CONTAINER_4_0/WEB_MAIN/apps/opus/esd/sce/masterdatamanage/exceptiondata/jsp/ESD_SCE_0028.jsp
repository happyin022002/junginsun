<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.framework.component.util.JSPUtil" %>
<%
/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_SCE_0028.jsp
 *@FileTitle : Exception Notification Subscriber Registration
 *Open Issues :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0028Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
		EsdSce0028Event  event = null;                		
		Exception serverException   = null;            			//???밿?????? 뮿?????? ??????

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
	        	event = (EsdSce0028Event)request.getAttribute("Event");
	        }
		} catch(Exception e) {
	        out.println(e.toString());
	    }
%>

<%
	int        rowSize  = 50 ;
%>

<html>
<head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<script language="javascript">
	<%=codeUtil.searchCodeComboSheet("copSubscGrpCd", "COM_INTG_CD_DTL", "INTG_CD_VAL_CTNT", "INTG_CD_VAL_DP_DESC", "INTG_CD_ID = 'CD00956'", "INTG_CD_VAL_CTNT")%>


    function setupPage(){
	    loadPage();
    }

</script>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr><td class="btn1_bg">

										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
											<td class="btn1_line"></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
						</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="115">Subscriber Group</td>
							<td width="250"><%=codeUtil.searchCodeCombo("SubscriberGroup","COM_INTG_CD_DTL","INTG_CD_VAL_CTNT", "INTG_CD_VAL_DP_DESC", "INTG_CD_ID = 'CD00956'" ,"INTG_CD_VAL_CTNT", "style='width:150;'", "1::ALL")%></td>
							<td width="120">Notification Office</td>
							<td><input name="ofc_cd" type="text" style="width:90; text-transform:uppercase;" maxlength="6" onKeyUp="this.value=this.value.toUpperCase()">&nbsp;<img onClick="openOfcPop(false,'ofc_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( Speed ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr></table>
						</td></tr>
					</table>
	    		<!-- : ( Button : Sub ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>

