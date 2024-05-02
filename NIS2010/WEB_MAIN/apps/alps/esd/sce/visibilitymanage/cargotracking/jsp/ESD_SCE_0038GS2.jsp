<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0038GS.jsp
*@FileTitle : US Cargo Tracking
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-24
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-11-24 SeongMun_Kang
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.event.ESD_SCE_0038EventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.event.ESD_SCE_0038Event" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC" %>

<%
	ESD_SCE_0038Event         event           = null;
    ESD_SCE_0038EventResponse eventResponse   = null;
    RequestDataSetBC         dataSet         = null;
    String                   custCode        = "";
    String                   custName        = "";
    String                   strErrMsg       = "" ;
    Exception                serverException = null;


    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event         = (ESD_SCE_0038Event)request.getAttribute("Event");
            eventResponse = (ESD_SCE_0038EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	dataSet  = event.getDataSet() ;
                custName = eventResponse.getCustName() ;
                custCode = dataSet.getString("cust_cnt_seq") ;
            } // end if
        } // end else
    }catch(Exception e) {
        //serverException = e ;
        //strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        out.println(e.getMessage());
    }

%>

<script language="javascript">
	var errMsg   = "<%=strErrMsg%>" ;
	var custName = "<%=custName%>" ;
	var custCode = "<%=custCode%>" ;

	if(errMsg==""){
		var formObj = parent.document.form ;
	
		if(custName!=""){
			formObj.cust_nm.value = custName ;
		}
	}
	else{
		ComShowMessage(errMsg) ;
	}

</script>
 