<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0118.jsp
*@FileTitle : COP Inquiry
*Open Issues :
*Change history :
*   - 2008-08-01 : COP Inquiry  화면 추가
*@LastModifyDate : 2008-08-01
*@LastModifier : kim Sang-Hyun
*@LastVersion : 1.0
* 2008-08-01 kim Sang-Hyun
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
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0118Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0118EventResponse"%>

<%
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		String userId=account.getUsr_id();

		EsdSce0118Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
		EsdSce0118EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)

		Exception serverException   = null;
		String strErrMsg = "";
		DBRowSet rowSet      = null;
		int rowCount     = 0;

			try {
				serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

			if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (EsdSce0118Event)request.getAttribute("Event");
	            eventResponse = (EsdSce0118EventResponse)request.getAttribute("EventResponse");
	            if (eventResponse != null) {
                	rowSet = eventResponse.getRowSet();
	                if(rowSet != null){
	                     rowCount = rowSet.getRowCount();
	                } // end if
	            } // end if
	        }
		} catch(Exception e){
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
<input type="hidden" name="old_cop_no">
<input type="hidden" name="new_cop_no">
<input type="hidden" name="cop_no_slave">
<input type="hidden" name="masterYN">
<input type="hidden" name="bkg_no">
<input type="hidden" name="user_id" value = <%=userId %>>


<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
						<table width="100%" border="0">
							<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;COP Inquiry</td></tr>
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
											<td class="btn1_line"></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
						</table>
				    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

					<table class="search">
						<tr>
							<td class="bg">
								<table class="search" border="0" style="width:750;">
									<tr class="h23">
										<td width="65">&nbsp;Cntr_NO. </td>
										<td><input name="cntr_no"  type="text" class="input" maxlength=11 style="width:122; text-transform:uppercase;" Onkeydown="onEnterKey(this)"  value="" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
									</tr>
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
			     	<table class="search">
						<tr>
							<td class="bg">
								<table class="height_10"><tr><td></td></tr></table>

			                    <table width="100%" id="mainTable">
			                        <tr><td>
			                             <script language="javascript">ComSheetObject('t1sheet');</script>
			                        </td></tr>
			                    </table>
							</td>
						</tr>
					</table>
			        </div>
</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->

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
</form>
</body>
</html>
