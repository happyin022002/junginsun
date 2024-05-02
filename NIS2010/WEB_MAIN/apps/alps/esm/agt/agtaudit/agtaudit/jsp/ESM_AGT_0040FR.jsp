<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESM_AGT_040FR.jsp
*@FileTitle : Agent Commission Report에서 Form의 Combo를 재세팅한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-16
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-03-16 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.event.CommonEvent" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.event.CommonEventResponse" %>

<%
	String userId = "";
	String cboData 			= "";
	String divId 			= "";
	String cboNm 			= "";
	String defaultValue		= "";
	String addProperties	= "";
	String workName	    	= ""; 
	String param			= "";
	String allYN			= "";
	String addOption		= "";
	String strErrMsg		= "";
	
	String[] strItem		= null;
	String header			= "";
	String colNm			= "";
	
	CommonEvent event 	= null;
	Exception serverException = null;

	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if(serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			event 		= (CommonEvent)request.getAttribute("Event");
			if(event != null){
				userId			= JSPUtil.getNull(event.getString("userId"));
				divId			= JSPUtil.getNull(event.getString("param1"));
				cboNm			= JSPUtil.getNull(event.getString("param2"));
				defaultValue	= JSPUtil.getNull(event.getString("param3"));
				addProperties	= JSPUtil.getNull(event.getString("param4"));
				workName		= JSPUtil.getNull(event.getString("param5"));
				param			= JSPUtil.getNull(event.getString("param6"));
				allYN			= event.getString("param7");
				addOption		= event.getString("param8");
				
				if((defaultValue.trim()).length() > 0) { // 실행 되지 않는 구문임...
					strItem = CodeUtil.getInstance().getAGTCommRptDefaultItem(userId, Integer.parseInt(defaultValue));
				} else {	// 항상 실행 되는 구문임, Default로 셋팅한다.
					strItem = CodeUtil.getInstance().getAGTCommRptDefaultItem("SYSTEM", 1);
				}

				if(strItem != null && strItem.length > 1) {
					header = strItem[0];
					colNm = strItem[1];
				}

				cboData = ComboUtil.getCodeCombo(cboNm, defaultValue, addProperties, workName, param, allYN, addOption);
			}
		}
	}catch(Exception e){
		out.println(e.toString());
	}
%>
<div id="div_cbo1"><%= cboData %></div>
<script language="javascript">
	parent.reSetHeader("<%=header%>", "<%=colNm%>");
	parent.document.getElementById("<%=divId%>").innerHTML = div_cbo1.innerHTML;
</script>
