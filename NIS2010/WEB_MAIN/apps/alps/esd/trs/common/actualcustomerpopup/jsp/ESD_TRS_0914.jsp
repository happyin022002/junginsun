<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0914.jsp
*@FileTitle : Other SO
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-04
*@LastModifier : poong
*@LastVersion : 1.0
* 2006-10-04 poong
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}

	String sContiCd		= JSPUtil.getNull(request.getParameter("conti_cd")		);	/* 2007-11-23	*/
	//sContiCd			= "";

	String sDorZnCd		= JSPUtil.getNull(request.getParameter("zone_cd")		);	/* 2007-11-23	*/
	String sBoundCd		= JSPUtil.getNull(request.getParameter("bound_cd")		);	/* 2007-11-23	*/

	String sDorLocCd 	= JSPUtil.getNull(request.getParameter("act_loc")		);

	String sDorNodCd	= sDorLocCd;

	String sDorNodeMaxLength	= "7";
	sDorNodCd			=  sDorLocCd + sDorZnCd;

	String sTxtLocation	= "Door Node";
	String sTxtCustCode	= "Customer Code";
	String sTxtCustName	= "Factory Name";


	if( "A".equals(sContiCd) || "M".equals(sContiCd) )
	{
		//sTxtLocation	= "Door Node";
		//sTxtCustCode	= "Actual Customer Code";
		//sTxtCustName	= "Actual Customer Name";

		sDorNodCd		=  sDorLocCd + sDorZnCd;
		sDorNodeMaxLength	= "7";
	}


	String act_cust_cd 	= JSPUtil.getNull(request.getParameter("act_cust_cd")	);
	act_cust_cd			= "0".equals(act_cust_cd) ? "" : act_cust_cd			 ;
	String fctry_nm 	= JSPUtil.getNull(request.getParameter("fctry_nm")	);
	String row 			= JSPUtil.getNull(request.getParameter("row")			);

%>
<html>
<head>
<title>Detail Input Pop up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd"								>
	<input type="hidden" name="iPage"								>
	<input type="hidden" name="ACT_CUST_CNT_CD"						>
	<input type="hidden" name="ACT_CUST_SEQ"						>
	<input type="hidden" name="USA_TRSP_ACT_CUST_NO"				>
	<input type="hidden" name="INIT_FLAG"	value='Y'				>
	<input type="hidden" name="CONTI_CD"	value='<%=sContiCd%>'	>
	<input type="hidden" name="BOUND_CD"	value='<%=sBoundCd%>'	>
	<input type="hidden" name="ROW" 		value='<%=row%>'		>

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Actual Customer Help</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0">
						<tr class="h23">
							<td width="10%"><%=sTxtLocation%></td>
							<td width="16%"><input type="text" align='center' style="width:80;" name='dor_nod_cd' value='<%=sDorNodCd%>' onKeyup='enterCheck(this);setgetUpper(this);' maxlength='<%=sDorNodeMaxLength%>'></td>
							<td width="14%"><%=sTxtCustCode%></td>
							<td width="18%"><input type="text" style="width:80;" name='act_cust_cd' value='<%=act_cust_cd%>' onKeyup='enterCheck(this);setgetUpper(this);' maxlength='8'></td>
							<td width="12%"><%=sTxtCustName%></td>
							<td><input type="text" style="width:99%;" name='fctry_nm' value='<%=fctry_nm%>'onKeyup='enterCheck(this)' maxlength='50'></td>
						</tr>
					</table></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Grid ) (S) -->
                    <table width="100%" id="mainTable">
                    <tr><td>
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td></tr>
                    </table>
					<!-- : ( Grid ) (E) -->

					<table class="line_bluedot"><tr><td></td></tr></table>

					<!-- : ( Grid ) (S) -->
                    <table width="100%" id="subTable">
                    <tr><td>
                        <script language="javascript">ComSheetObject('sheet2');</script>
                    </td></tr>
                    </table>
					<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->

		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->



</form>
</body>
</html>
