<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0009.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0009Event"%>
<%//@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0009EventResponse"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%
    EsdSce0009Event         event           = null;    //PDTO(Data Transfer Object including Parameters)
    //EsdSce0009EventResponse eventResponse   = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception                serverException = null;    //서버에서 발생한 에러
    DBRowSet                 rowSet          = null;    //DB ResultSet
    String strErrMsg = "";  //에러메세지
    int rowCount	 = 0;

	try {

		event = (EsdSce0009Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}    

%>

<html>
<head>
<title>Supply Chain Event Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
   	    loadPage();
    }

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="cop_no" value="<%=event.getCOPReplanInfoVO().getCopNo()%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cntr_no">
<input type="hidden" name="bkg_no" value="<%=event.getCOPReplanInfoVO().getBkgNo()%>">
<input type="hidden" name="cop_sts_cd" value="<%=event.getCOPReplanInfoVO().getCopStsCd()%>">
<!-- 
<input type="hidden" name="bkg_no_split">
-->
<input type="hidden" name='bound_name' value="<%=event.getCOPReplanInfoVO().getBoundName()%>">
<input type="hidden" name='iscompled'  value="<%=event.getCOPReplanInfoVO().getIscompled()%>">
<input type="hidden" name='nodcd'  value="<%=event.getCOPReplanInfoVO().getNodcd()%>">
<input type="hidden" name='isnodchg'  value="<%=event.getCOPReplanInfoVO().getIsnodchg()%>">
<input type="hidden" name='frmcd'  value="<%=event.getCOPReplanInfoVO().getFrmcd()%>">
<input type="hidden" name='isfrmchg'  value="<%=event.getCOPReplanInfoVO().getIsfrmchg()%>">

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;COP Manual Replan</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<!-- table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">Cop Manual Change</span></td></tr>
			</table-->
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>

		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Target COP Infomation</td></tr>
				<tr><td class="height_2"></td></tr>
				</table>

				<table width="100%" id="mainTable">
				<!--<form name="form" action="ESD_SCE_0009Search.do" method="post">-->
				<!--<input type="hidden" name="f_cmd">-->


				       <tr><td>
				           <script language="javascript">ComSheetObject('sheet1');</script>
				       </td></tr>

				<!-- </form>-->
				</table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Possible Route Infomation</td></tr>
				<tr><td class="height_2"></td></tr>
				</table>

				<table width="100%" id="mainTable">
		<!--<form name="form2" action="ESD_SCE_0002Search.do" method="post">-->

		<!--<input type="hidden" name="cop_no">-->

				       <tr><td>
				           <script language="javascript">ComSheetObject('sheet2');</script>
				       </td></tr>

		<!--</form>-->
				</table>
				<!-- : ( Speed ) (E) -->

			</td></tr>

		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>




    </td></tr>
</table>
<!-- Outer Table (E)-->

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

