<%--
=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0001.jsp
*@FileTitle : Geographic Hierarchy
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-30
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-08-30 kimyoungchul
* 1.0
* 2009.07.01 alps framework 구조로 변경 Noh Seung Bae
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.event.EsdPrd0001Event"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.prdcommon.event.PrdCommonEvent %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO"%>
<%@ page import="java.util.List"%>
<%
    //EsdPrd001Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;            //서버에서 발생한 에러
	List list = null;
    //DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //
    int rowCount     = 0;                                  //DB ResultSet
    //String successFlag = "";
    //String codeList  = "";
    //String pageRows  = "100";

    try {
       /*
       */
       //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       //userId=account.getSawonNo();
       //userAuth=account.getAuth();


       /*
       */
        //event = (EsdPrd001Event)request.getAttribute("Event");
       /*
       */
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
       /*
       */
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                list = eventResponse.getRsVoList();
            } // end if
        } // end else
    }catch(Exception e) {
     	//e.printStackTrace();
        out.println(e.toString());
    }


%>
<html>
<script Language="JavaScript">
	var list = parent.document.form.select2;
	var l_cnt = list.length;
	// remove first!!
	for(i=0;i<l_cnt-1;i++){
		list.remove(list.length-1);
	}

	// add new options !
<%
	for(int i=0; i< list.size(); i++){
		ContinentVO vo = (ContinentVO)list.get(i);
%>
	list.options[list.length] = new Option('<%=vo.getContiCode()%>', '<%=vo.getContiCode()%>');
<%
	}
%>
</script>
<body>
AAAAAA
</body>
</html>