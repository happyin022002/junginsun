<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0026.jsp
*@FileTitle : Exception Category Registration
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================--%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0026Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>

<%
	
    CodeUtilBC codeUtil = new CodeUtilBCImpl() ;

%>
<%
    EsdSce0026Event			event			= null; //PDTO(Data Transfer Object including Parameters)
    Exception					serverException = null;	//
    DBRowSet					rowSet			= null; //DB ResultSet
    DBRowSet					rowSetCate		= null; //DB ResultSet

		String strErrMsg = "";                             	//
    int rowCount     = 0;                              	//DB ResultSet
		//String cateCdList = " ";
		//String cateNmList = " ";
		StringBuffer cateCdList = new StringBuffer();
		StringBuffer cateNmList = new StringBuffer();

    try {
        event = (EsdSce0026Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
    	out.println(e.getMessage()) ;
    }

%>
<html>
<head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>
<script language="javascript">


	<%=codeUtil.searchCodeComboSheet("copExptTp", "SCE_EXPT_CD", "SUBSTR(EXPT_CD,1,1) EXPT_TP_CD", "EXPT_CD_NM","SUBSTR(EXPT_CD, 2, LENGTH(EXPT_CD) ) = '0000000' AND ACT_FLG = 'Y'", null)%>
	<%=codeUtil.searchCodeNameListJsArray(true, "copExptTpNames","SCE_EXPT_CD", "SUBSTR(EXPT_CD,1,1) EXPT_TP_CD", "EXPT_CD_NM", "SUBSTR(EXPT_CD, 2, LENGTH(EXPT_CD) ) = '0000000' AND ACT_FLG = 'Y'")%>
	<%=codeUtil.searchCodeComboSheet("actCD", "mdm_activity", "act_cd", "act_cd", "act_tp_cd='T' AND act_flg='Y'", null)%>
	<%=codeUtil.searchCodeNameListJsArray(true, "actCDNames","mdm_activity", "act_cd", "act_nm", "act_tp_cd='T' AND act_flg='Y'")%>

    function setupPage(){
	    var errMessage = "<%=strErrMsg%>";
	    if (errMessage.length >= 1) {
	    	ComShowMessage(errMessage);
	    } // end if

		loadPage();
    	//var tests = document.getElementById("test");
    	//alert( tests.selectedIndex);
		//alert( tests.options[tests.selectedIndex].text);
    	//alert( tests.options[tests.selectedIndex].text.length);
    	//tests.style.width=tests.options[tests.selectedIndex].text.length*7;

	}
</script>

<body onLoad="setupPage()">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_expt_tp">
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

	<p><p><p>

	<table width="100%" class="title">
  	<tr>
  	  <td class="title">
        <img src="/opuscntr/img/icon_title_dot.gif" width="9" height="9">&nbsp;Exception Type Detail
      </td>
    </tr>
	</table>

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr><td class="btn1_bg">

										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="dbtn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="dbtn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
											<td class="btn1_line"></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="dbtn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="dbtn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
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
								<tr><td class="btn2_left"></td><td class="btn2" name="dbtng_rowadd" id="btng_rowadd">Row Add</td>
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

