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
<%@ page import="com.hanjin.apps.alps.esd.sce.batch.batchexceptionidentify.event.IbatchVisibilityEvent"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.batch.batchexceptionidentify.event.IbatchVisibilityEventResponse"%>
<%
	IbatchVisibilityEvent event = null;
	IbatchVisibilityEventResponse eventResponse = null;
	Exception serverException   = null;			//서버에서 발생한 에러
	
	String successFlag = "";
	String strErrMsg = "";                                  //에러메세지
    try {
        event = (IbatchVisibilityEvent)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{

            eventResponse = (IbatchVisibilityEventResponse)request.getAttribute("EventResponse");
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
<title>COP 상세조회</title>
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
<table  class="search" border="0" >
	<tr>
		<td>
			Please, Select one from lower part : <img class="cursor" src="/hanjin/img/enis/button/btn_retrieve.gif" width="66" height="20" border="0" name="btn_retrieve">
		</td>					
	</tr>
</table>
<table width="100%" height="40%" border="0" cellpadding="0" cellspacing="0">
	<tr class="h23">
		<td width="137"></td>
		<td width="170">
	    	<script language="javascript">ComSheetObject('sheet1');</script>
	    </td>
	</tr>
	<tr>
		<td>
		<INPUT type = "checkbox" name = "check1" onClick="javascript:onCheck('check1')"  value = "cntr_ack">		
			<img class="star">Container Actual value Event
		<br>			
		<INPUT type = "checkbox" name = "check2" onClick="javascript:onCheck('check2')"  value = "vsl_upd">
			<img class="star">VSL SKD Update			
		<br>
		<INPUT type = "checkbox" name = "check3" onClick="javascript:onCheck('check3')"  value = "batch_ack">		
			<img class="star">No Actual Batch value Event			
		<br>
		<INPUT type = "checkbox" name = "check4" onClick="javascript:onCheck('check4')"  value = "vsl_ack">		
			<img class="star">VSL Actual value Event
			<br>
		<INPUT type = "checkbox" name = "check5" onClick="javascript:onCheck('check5')"  value = "estm_act_ack">		
			<img class="star">Estimate/Actual date manual update Event(cop-act-nod)
			<br>
		<INPUT type = "checkbox" name = "check6" onClick="javascript:onCheck('check6')"  value = "cop_ack">		
			<img class="star">Estimate/Actual date manual update Event(detail)	
			<br>		
		</td>
	</tr>	
</table>
<table>
	<tr>
		<td>
			COP DTL SEQ(cntr actual) 
		</td>
		<td>
			<input type = "text" name="cop_dtl_seq" value = "" size=20 width=100 disabled>
		</td>
	</tr>
	<tr>
		<td>
			COP NO(cntr actual)
		</td>
		<td> 
			<input type = "text" name="cop_no" value = "" size=20 width=100 disabled>
		</td>
	</tr>
	<tr>
		<td>
			COP GRP SEQ(cntr actual) 
		</td>
		<td>
			<input type = "text" name="cop_grp_seq" value = "" size=20 width=100 disabled>
		</td>
	</tr>
	<tr>
		<td>
			VVD 
		</td>
		<td>
			<input type = "text" name="vvd" value = "" size=20 width=100 disabled>
		</td>
	</tr>
	<tr>
		<td>
			VPS PORT CD
		</td>
		<td>
			<input type = "text" name="vps_port_cd" value = "" size=20 width=100 disabled>
		</td>
	</tr>
	<tr>
		<td>
			VPS EVNT TP CD
		</td>
		<td> 
			<input type = "text" name="vps_evnt_tp_cd" value = "" size=20 width=100 disabled>
		</td>
	</tr>
<table>
	<tr>
		<td>
			ACT CD
		</td>
		<td> 
			<input type = "text" name="act_cd" value = "" size=20 width=100 disabled>
		</td>
	</tr>
	<tr>
		<td>
			NOD CD
		</td>
		<td> 
			<input type = "text" name="nod_cd" value = "" size=20 width=100 disabled>
		</td>
	</tr>
	<tr>
		<td>
			ESTIMATE DATE 
		</td>
		<td>
			<input type = "text" name="estm_dt" value = "" size=20 width=100 disabled>
		</td>
	</tr>
	<tr>
		<td>
			ACTUAL DATE
		</td>
		<td> 
			<input type = "text" name="act_dt" value = "" size=20 width=100 disabled>
		</td>
	</tr>
</table>
</table>
</form>
</body>
</html>
	
