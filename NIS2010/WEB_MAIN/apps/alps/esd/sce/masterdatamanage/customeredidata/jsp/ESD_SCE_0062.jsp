<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0035.jsp
*@FileTitle : EDI Search
*Open Issues :
*@LastModifyDate : 2006-10-12
*@LastModifier : Yong-cheon Shin
*@LastVersion : 2.0
* 2006-08-29 yong cheon shin
* 1.0 최초 생성
*Change history :
* 2006-10-12 : UI 변경으로 인한 수정
* 2012.04.12 채창호 CHM-201217464-01:SCEM(Customer EDI) upgrade project 관련 화면 수정 요청(1)
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0062Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
			//CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
			EsdSce0062Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
			Exception serverException   = null;            			//서버에서 발생한 에러

			String mycust = JSPUtil.getNull(request.getParameter("mycust"));   // 버튼 보이고 숨기기~

			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    	String userId=account.getUsr_id();

	    	String strErrMsg = "";                                  //에러메세지

			//String successFlag = "";
			//String codeList  = "";
			//String pageRows  = "100";

			DBRowSet rowSet      = null;                            //DB ResultSet

			int rowCount     = 0;                                   //DB ResultSet 리스트의 건수

			//String iPage;

			//String grp_nm = "";

			//System.out.println("dist : " + JSPUtil.getNull(request.getParameter("dist")));


    try {

    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsdSce0062Event)request.getAttribute("Event");
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
        var formObject = document.form ;
          formObject.cs_nm.focus();
    }

</script>

</head>


<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="temp_edi_grp">
<input type="hidden" name="temp_edi_id">
<input type="hidden" name="temp_edi_nm">
<input type="hidden" name="user_id" value=<%=userId%>>
<input type="hidden" name="mycust" value=<%=mycust%>>
<input type="hidden" name="sendClose">
<input type="hidden" name="temp_cs_cd">
<input type="hidden" name="temp_sc_no">
<input type="hidden" name="temp_tp_id">
<input type="hidden" name="temp_cs_nm">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Customer Inquiry</td></tr>
		</table>

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
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" style="width:450;">
						<tr class="h23">
							<td width="25%">&nbsp;&nbsp; Customer Code </td>
							<td><input name="cs_cd"  type="text" class="input" style="width:102; text-transform:uppercase;"  value="" onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
							<td align=right>&nbsp;Contract No&nbsp;</td>
							<td><input name="sc_no"  type="text" class="input" style="width:102; text-transform:uppercase;"  value="" onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
						</tr>
						<tr class="h23">
							<td width="25%">&nbsp;&nbsp; TP ID </td>
							<td><input name="tp_id"  type="text" class="input" style="width:102; text-transform:uppercase;"  value="" onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
                            <td align=right>&nbsp;SM LINE TP ID&nbsp;</td>
							<td><input name="hj_tp_id"  type="text" class="input" style="width:102; text-transform:uppercase;"  value="" onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
						</tr>
						<tr class="h23">
							<td width="25%">&nbsp;&nbsp; Customer Name </td>
							<td colspan=3><input name="cs_nm"  type="text" class="input" style="width:102; text-transform:uppercase;"  value="" onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
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
					<% if(mycust.equals("1")){ %>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<% } else if(mycust.equals("2")){%>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<% } else if(mycust.equals("3")){%>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<% } else if(mycust.equals("4")){%>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<% } else {%>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_add">Add To My Cust</td><td class="btn1_right"></td></tr></table></td>
					<% } %>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


</body>

</html>

