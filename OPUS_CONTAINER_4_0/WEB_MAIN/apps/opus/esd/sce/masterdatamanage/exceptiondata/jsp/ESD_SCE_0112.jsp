<%--=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0112.jsp
*@FileTitle : Exception Office Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-08-06 Hun-Il Jung
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0112Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%

		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
		EsdSce0112Event  event = null;                		
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
        	event = (EsdSce0112Event)request.getAttribute("Event");
        }
			} catch(Exception e) {
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
    	var errMessage = "<%=strErrMsg%>";
	    if (errMessage.length >= 1) {
	    	ComShowMessage(errMessage);
	    } // end if
			
	    loadPage();
	}
</script>

<body onLoad="setupPage()">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_ofc_cd">
<input type="hidden" name="f_ofc_cd2">
<input type="hidden" name="txtmapgofccd">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


<!-- ####### TABLE '#D' ::: 'LEFT' FRAME (START) ####### -->
<table width="100%" height="70%" border="0" cellpadding="0" cellspacing="0">
<tr>
	<td class="bodyright" width="100%">


		<table width="100%" height="30" class="title">
	  	<tr>
	  	  <td class="title">&nbsp;</td>
	    </tr>
		</table>

		<table width="100%" class="title">
	  	<tr>
	  	  <td class="title">Master Office</td>
	    </tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		<table class="height_5"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" style="width:200;">
						<tr class="h23">
							<td width="40">Office</td>
							<td width=""><input name="mst_ofc_cd" type="text" class="input" style="width:60; text-transform:uppercase;" maxlength="6" onKeyUp="this.value=this.value.toUpperCase()">
							<img onClick="openOfcPopUp(true,'mstofccd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

						</tr>
					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button">
		<tr><td class="align">

			<table class="button">
				<tr></tr>
				</table></td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

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
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_new" id="btn_new">New</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr></table>
						</td></tr>
					</table>
	    		<!-- : ( Button : Sub ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
</td>
<!-- ####### TABLE '#D' ::: 'LEFT' FRAME (END) ####### -->
<td width="">&nbsp;&nbsp;</td>
<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (START) ####### -->
<td class="bodyright" width="100%">


	<table width="100%" height="30" class="title">
  	<tr>
  	  <td class="title">&nbsp;</td>
    </tr>
	</table>

	<table width="100%" class="title">
  	<tr>
  	  <td class="title">
        Mapping Office
      </td>
    </tr>
	</table>
	<table class="height_5"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" style="width:600;">
						<tr class="h23">
							<td width="40">Office</td>
							<td width=""><input name="mapg_ofc_cd" type="text" class="input" style="width:60; text-transform:uppercase;" maxlength="6" onKeyUp="this.value=this.value.toUpperCase()">
							<img onClick="openOfcPopUp(true,'mapgofccd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

						</tr>
					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button">
		<tr><td class="align">

			<table class="button">
				<tr></tr>
				</table></td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('sheet2');</script>
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
								<tr><td class="btn2_left"></td><td class="btn2" name="dbtn_new" id="dbtn_new">New</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="dbtn_retrieve" id="dbtn_retrieve">Retrieve</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="dbtng_rowadd" id="dbtng_rowadd">Row Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="dbtn_save" id="dbtn_save">Save</td>
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

