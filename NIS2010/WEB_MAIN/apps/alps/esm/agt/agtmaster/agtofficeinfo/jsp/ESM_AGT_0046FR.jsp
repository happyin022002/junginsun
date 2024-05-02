<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_046FR.jsp
*@FileTitle : Agent Other Commission Office Vs Vendor Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : SangJun Kwon
*@LastVersion : 1.0
* 2008-01-30 SangJun Kwon
* 1.0 최초 생성
=========================================================*/ 
--%>

<%--
=========================================================================
화면에서 Insert 나 Delete 시 Office 콤보의 값을 바꿔준다.
=========================================================================
'[Table]
'	AGT_OFC_VNDR_MTCH
'[JSP Code]
'	<iframe height="0" width="0" name="frmHidden"></iframe>
'	...
'	
'	<td><img class="nostar">Subject Office</td>
'	<td><div id="div_sbOfcCd"><%= sbOfcCd %></div></td>
'
'[JavaScript Code]
'	formObj.target = "frmHidden";
'	formObj.action = "ESM_AGT_046FR.do";
'	formObj.submit();
=========================================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.event.CommonEvent" %>

<%
	String ofcCd 		= "";
	String arOfcCd 		= "";
	String cboOfcCd		= "";
	String strErrMsg	= "";
	CommonEvent event 	= null;
	Exception serverException = null;
	
	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if(serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			
			event = (CommonEvent)request.getAttribute("Event");
				
			// Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션') 
			cboOfcCd = ComboUtil.getCodeCombo("cboOfcCd", arOfcCd, " style='width:85'", "OfcVndrMachList", ofcCd, "&lt;&lt;select&gt;&gt;", "");
			
		}
	}catch(Exception e){
		out.println(e.toString());
	}
%>
<div id="div_ofc_cd"><%= cboOfcCd %></div>
<script language="javascript">
	parent.document.getElementById("div_ofc_cd").innerHTML = div_ofc_cd.innerHTML;
</script>
