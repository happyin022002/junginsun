<%--=========================================================================
'주  시 스 템 : E-NIS
'서브  시스템 : COP 상세조회
'프로그램 ID  : apps/alps/esd/sce/copmanage/jsp/ESD_SCE_0006.jsp
'프로그램 명  : COP 상세조회
'프로그램개요 : COP 상세조회 화면 이벤트들을 수행한다.
'작   성   자 : Se-Hoon PARK
'작   성   일 : 2006.07.03
=============================================================================
'수정자/수정일 :
'수정사유/내역 :
=========================================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.online.edisend.event.EdiSendEvent"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.online.edisend.event.EdiSendEventResponse"%>
<%
	EdiSendEvent event = null;
	EdiSendEventResponse eventResponse = null;
	Exception serverException   = null;			//서버에서 발생한 에러
	
	String successFlag = "";
	String strErrMsg = "";                                  //에러메세지
    try {
        event = (EdiSendEvent)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{

            eventResponse = (EdiSendEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	successFlag = eventResponse.getSuccessFlag();             
            } // end if
        } // end else
    }catch(Exception e) {
        out.println("event : " + e.toString());
    }
%>
<html>
<head>
<title>EDI SEND</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
	    var errMessage = "<%=strErrMsg%>";
	    if (errMessage.length >= 1) {
	    	showErrMessage(errMessage);
	    } // end if
//### =========================================================================
//### 탭을 사용하는 화면인 경우 추가한다.
//	     InitTab();
//### =========================================================================
		loadPage();

	}
</script>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd"> 
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" height="40%" border="0" cellpadding="0" cellspacing="0">
	<tr class="h23">
		<td width="137"><img class="cursor" src="/hanjin/img/enis/button/btn_retrieve.gif" width="66" height="20" border="0" name="btn_retrieve"></td>
		<td width="170">
	    	<script language="javascript">ComSheetObject('sheet1');</script>
	    </td>
	</tr>
</table>
<table>
	<tr>
		<td>
			org_yd_cd
		</td>
		<td>
			<input type = "text" name="org_yd_cd" value = "" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			event_dt
		</td>
		<td> 
			<input type = "text" name="event_dt" value = "" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			bkg_no
		</td>
		<td>
			<input type = "text" name="bkg_no" value = 'MAC5B290601' size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			bkg_no_split 
		</td>
		<td>
			<input type = "text" name="bkg_no_split" value = "  " size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			nod
		</td>
		<td>
			<input type = "text" name="nod" value = "CNSHAY1" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			vip_tp_gid
		</td>
		<td> 
			<input type = "text" name="vip_tp_gid" value = "" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			edi_id
		</td>
		<td> 
			<input type = "text" name="edi_id" value = "" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			cntr_no
		</td>
		<td> 
			<input type = "text" name="cntr_no" value = "FSCU9238616" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			edircv_id
		</td>
		<td>
			<input type = "text" name="edircv_id" value = "" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			call_from
		</td>
		<td>
			<input type = "text" name="call_from" value = "COP" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			bl_no
		</td>
		<td>
			<input type = "text" name="bl_no" value = "" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			group_seq
		</td>
		<td>
			<input type = "text" name="group_seq" value = "2" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			cnmv_dt_tm
		</td>
		<td>
			<input type = "text" name="cnmv_dt_tm" value = "2006/09/27 00:00:00" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			edi_sts
		</td>
		<td>
			<input type = "text" name="edi_sts" value = "EE" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			cnmv_full_flg
		</td>
		<td>
			<input type = "text" name="cnmv_full_flg" value = "F" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			skd_voyage_no
		</td>
		<td>
			<input type = "text" name="skd_voyage_no" value = "0040" size=20 width=100 >
		</td>
	</tr>
	<tr>
		<td>
			skd_dir_cd
		</td>
		<td>
			<input type = "text" name="skd_dir_cd" value = "E" size=20 width=100 >
		</td>
	</tr>
	
	<tr>
		<td>
			vsl_cd
		</td>
		<td>
			<input type = "text" name="vsl_cd" value = "SMOL" size=20 width=100 >
		</td>
	</tr>
</table>
</form>
</body>
</html>
	
