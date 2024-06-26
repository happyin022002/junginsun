<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0046_05.jsp
*@FileTitle : RDR Creation – VSL Alloc
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004605Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf004605Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.RegionDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf004605Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RDR Creation – VSL Alloc</title>
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

<body  onLoad="setupPage();" topmargin="0" leftmargin="0">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="vsl_cd">
<input type="hidden" name="voy_no">
<input type="hidden" name="dir_cd">
<input type="hidden" name="region">
<input type="hidden" name="port_cd">

<input type="hidden" name="segment" value='AL'>
<input type="hidden" name="crr_cd"><!-- sheet1의 Operator Code Valid Check 사용. -->
<table class="search" id="mainTable">
<tr>
<td class="bg">
    <!-- Grid (S) -->
        <table width="100%"  id="mainTable">
            <tr>
                <td width="100%">
                    <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
            </tr>
        </table>
     <!-- Grid (E) -->
     
    <!--  Button_Sub (S) -->
            <!--  Button_Sub (S) -->
            <table width="100%" class="button">
            <tr>
                <td width="180">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2_1" name="btn_ImportAllocation"  auth='c' id="btn_ImportAllocation">Import Allocation</td>
                    <td class="btn2_right"></td>
                    </tr>
                    </table>
                </td>
                <td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                               <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                               <tr><td class="btn2_left"></td>
                               <td class="btn2_1" name="btn_Row_Add"   auth='c' id="btn_Row_Add" >Row Add</td>
                               <td class="btn2_right"></td>
                               </tr>
                               </table></td>
                               <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                               <tr><td class="btn2_left"></td>
                               <td class="btn2_1" name="btn_Row_Insert"  auth='c'  id="btn_Row_Insert">Row Insert</td>
                               <td class="btn2_right"></td>
                               </tr>
                               </table></td>
                               <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                               <tr><td class="btn2_left"></td>
                               <td class="btn2_1" name="btn_Row_Copy"  auth='c' id="btn_Row_Copy">Row Copy</td>
                               <td class="btn2_right"></td>
                               </tr>
                               </table></td>
                               <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                               <tr><td class="btn2_left"></td>
                               <td class="btn2_1" name="btn_Row_Delete"  auth='c' id="btn_Row_Delete">Row Delete</td>
                               <td class="btn2_right"></td>
                               </tr>
                               </table></td>
                </tr>
                </table>
            </td>
         </tr>
         </table>
      <!-- Button_Sub (E) -->
</td>
</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>