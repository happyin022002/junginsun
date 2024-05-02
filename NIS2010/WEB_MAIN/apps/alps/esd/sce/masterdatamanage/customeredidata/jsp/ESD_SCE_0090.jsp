<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0090.jsp
*@FileTitle : Vessel Estimation Accunt
*Open Issues :
*@LastVersion : 1.0
* 2008-04-07 kim sang hyun
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0090Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
			CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
            EsdSce0090Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
			Exception serverException   = null;            			//서버에서 발생한 에러

			String strErrMsg = "";                                  //에러메세지
			DBRowSet rowSet      = null;                            //DB ResultSet
			int rowCount     = 0;                                   //DB ResultSet 리스트의 건수

			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			String userId=account.getUsr_id();
	
    try {

    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (EsdSce0090Event)request.getAttribute("Event");
            
        }//if
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
        var formObject = document.form ;
    }
</script>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_user_id" value=<%=userId%>>
<input type="hidden" name="f_group_id">
<input type="hidden" name="f_tp_id">
<input type="hidden" name="f_group_name">
<input type="hidden" name="f_cnt">
<input type="hidden" name="f_cnt1">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                    	<tr class="h23">
                    		<td>&nbsp;
								My Customer
                    		</td>
                    		<td>
                    			<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_add1" id="btng_add1">Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_delete1" id="btn_delete1">Delete</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_save1" id="btn_save1">Save</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr></table>
						</td></tr>
					</table>
                    		</td>
                    	</tr>
                        <tr HIDDEN="TRUE">
                        	<td colspan="2">
                            	 <script language="javascript">ComSheetObject('t0sheet');</script>
                        	</td>
                        </tr>
                    </table>

				<!-- : ( grid ) (E) -->
			</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>

		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                    	<tr class="h23">
                    		<td>&nbsp;
								My Performance Report
                    		</td>
                    		<td>
	                    		<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_add2" id="btng_add2">Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_delete2" id="btn_delete2">Delete</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_save2" id="btn_save2">Save</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr></table>
						</td></tr>
					</table>
                    		</td>
                    	</tr>
                        <tr>
                        	<td colspan="2">
                            	 <script language="javascript">ComSheetObject('t1sheet');</script>
                        	</td>
                        </tr>
                    </table>

				<!-- : ( grid ) (E) -->
			</td></tr>
		</table>
		<table class="height_10"><tr><td></td></tr></table>
    </td></tr>
</table>
<!-- Outer Table (E)-->
</body>
</html>