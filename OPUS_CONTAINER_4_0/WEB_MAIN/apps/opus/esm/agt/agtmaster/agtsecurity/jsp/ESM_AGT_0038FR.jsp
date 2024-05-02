<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_0038FR.jsp
*@FileTitle : Office code info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.14 추경원
* 1.0 Creation
=========================================================*/
%>

<%--
=========================================================================
Form Control중 A/R Office ComboBox가 변경시 Subject Office ComboBox를 재세팅한다.
=========================================================================
'[Table]
'	MDM_DTL_REV_LANE
'[JSP Code]
'	<iframe height="0" width="0" name="frmHidden"></iframe>
'	<input type="hidden" name="param1"><!-- ComboUtil에서 사용하는 codeItem -->
'	<input type="hidden" name="param2"><!-- All Display 유무(Y, N, [All])   -->
'	<input type="hidden" name="param3"><!-- Object Name  -->
'	<input type="hidden" name="param4"><!-- Trade Code   -->
'	...
'	
'	<td><%//<img class="nostar">%>Subject Office</td>
'	<td><div id="div_sbOfcCd"><%= sbOfcCd %></div></td>
'
'[JavaScript Code]
'	formObj.param1.value = <<codeItem>>;
'	formObj.param2.value = <<All 유무>>;
'	formObj.param3.value = <<Object Name>>;
'	formObj.param4.value = <<A/R Office Code>>;
'	formObj.target = "frmHidden";
'	formObj.action = "ESM_AGT_010FR.do";
'	formObj.submit();
=========================================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.CommonEvent" %>
<%
	String agnCd   = "";
	String arOfcCd = "";
	
	String strErrMsg 	= "";
	CommonEvent event 	= null;
	Exception serverException = null;
	
	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if(serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			event = (CommonEvent)request.getAttribute("Event");
			
			if(event != null){
				agnCd  = event.getString("param1");
				
				//A/R Office of Insert Office 를 구한다.
				arOfcCd = CodeUtil.getInstance().getAROfficeInfo(agnCd);
			}
		}
	}catch(Exception e){
		out.println(e.toString());
	}
%>
<script language="javascript">
	parent.document.getElementById("param2").value = "<%= arOfcCd %>";
	parent.setAROfficeInfo();
</script>
