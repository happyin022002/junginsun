<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0144.jsp
*@FileTitle : Shipper Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.08 송호진
* 1.0 Creation
===========================================================
	' History :
	' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
	' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[144]
	' 2008.10.14 박상희 Shipper 검색조건으로 조회가 가능하도록 수정
    ' 2009.09.15 송호진 ALPS F/W 적용
    ' 2010.06.14 윤진영 UI표준처리 오픈시 마우스 포커싱
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event.EsmMas0144Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//	EsmMas0144Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String f_cust_cnt_cd 	= "";
    String f_cust_seq    	= "";
        
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.SalesRPT");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


//		event = (EsmMas0144Event)request.getAttribute(Event);
		
		f_cust_cnt_cd = request.getParameter("f_cust_cnt_cd");
		f_cust_seq = request.getParameter("f_cust_seq");
				
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Shipper Pop UP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		document.form.f_cust_cnt_cd.focus();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr>
    <td valign="top">


					<!-- : ( Title ) (S) -->
					<table width="100%" border="0">
					<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Shipper Table</td></tr>
					</table>
					<!-- : ( Title ) (E) -->


					<!--Button_L (S) -->
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
					<!--Button_L (E) -->


					<!-- TABLE '#D' : ( Search Options ) (S) -->
					<table class="search">
						<tr>
							<td class="bg">

								<!-- : ( Year ) (S) -->
								<table class="search" border="0" width="100%">
									<tr class="h23">
										<td id="td1" width="16%">Shipper Code</td>
										<td id="td2" width="12%"><input type="text" class="input1" style="width:30;" name="f_cust_cnt_cd" value="<%= f_cust_cnt_cd %>" maxlength="2" onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyUp="moveTab(this, f_cust_seq);" style="ime-mode:disabled"></td>
										<td id="td3" width="21%">Shipper Sequence</td>
										<td id="td4" width="57%"><input  type="text"  style="width:60;" name="f_cust_seq" value="<%= f_cust_seq %>" maxlength="6" onkeyPress="ComKeyOnlyNumber(this);" ></td>
									</tr>
								</table>
								<!-- : ( Year ) (E) -->


                    			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>


                    			<!-- : ( Grid ) (S) -->

                                <table width="100%" id="mainTable1">
                                    <tr>
                                        <td>
                                            <script language="javascript">ComSheetObject('sheet1');</script>
                                        </td>
                                    </tr>
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
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>

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