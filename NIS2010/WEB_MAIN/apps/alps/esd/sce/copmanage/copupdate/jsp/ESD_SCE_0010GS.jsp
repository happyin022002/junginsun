<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copupdate.event.ESD_SCE_0010EventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC" %>
<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0010.jsp
*@FileTitle : COP Manual Batch Update
*Open Issues :
*Change history :
    요건 및 UI 변경에 따른 수정
*@LastModifyDate : 2006-10-19
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-02 Seong-mun Kang
* 1.0 최초생성
=========================================================*/ 
--%>

<%
	ESD_SCE_0010EventResponse eventResponse   = (ESD_SCE_0010EventResponse)request.getAttribute("EventResponse");
	RequestDataSetBC         dataSet         = null ;
	Exception                serverException = null;
	String                   strErrMsg       = "" ;
	String                   failCopNo       = "" ;
	
	try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        else{
        	if(eventResponse!=null){
        		dataSet   = eventResponse.getDataSet() ;
        		failCopNo = dataSet.getString("fail_cop_no").trim() ;
        	}
        }
    }catch(Exception e) {
        serverException = e ;
        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        out.println(e.toString());
    }

%>

<script language="javascript">
	var errMsg    = "<%=strErrMsg%>" ;
	var failCopNo = "<%=failCopNo%>" ;
	
	if(errMsg==""){
		if(failCopNo==""){
			showErrMessage(getMsg('SCE90005')) ;
		}
		else{
			showErrMessage(getMsg('SCE90027', failCopNo)) ;
		}
		opener.doActionIBSheet(opener.sheetObjects[0],opener.document.form,opener.IBSEARCH);
		opener.focus() ;
		self.close() ;
	}
	else{
		showErrMessage(errMsg) ;
		history.back() ;
	}
</script>
