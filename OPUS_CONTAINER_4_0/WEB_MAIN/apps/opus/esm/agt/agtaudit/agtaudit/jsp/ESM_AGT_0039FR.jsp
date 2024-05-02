<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_039FR.jsp
*@FileTitle : Agent Commission Maintenance & Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-21
*@LastModifier : JungHyung,Kim
*@LastVersion : 1.0
* 2007-02-21 JungHyung,Kim
* 1.0 최초 Insert
=========================================================*/
--%>

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
'	formObj.action = "ESM_AGT_039FR.do";
'	formObj.submit();
=========================================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.CommonEvent" %>

<%
	String arOfcCd 		= "";
	String sbOfcCd 		= "";
	String codeItem 	= "";
	String objectNm 	= "";
	String isAll	    = ""; 
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
				codeItem = event.getString("param1");
				isAll    = Utils.iif(event.getString("param2") == null, "", event.getString("param2"));
				objectNm = event.getString("param3");
				arOfcCd  = event.getString("param4");
				
				//Combo Data : getCodeCombo('Tag Name','Init Value', 'Additional Properties', 'Biz name', 'Condition Code', 'Whole check', 'Additional Option') 
				sbOfcCd  = ComboUtil.getCodeCombo(objectNm, arOfcCd, "style='width:85;', class='input1'", codeItem, arOfcCd, isAll, "");
			}
		}
	}catch(Exception e){
		out.println(e.toString());
	}
%>
<div id="div_sbOfcCd"><%= sbOfcCd %></div>
<script language="javascript">
	parent.document.getElementById("div_sbOfcCd").innerHTML = div_sbOfcCd.innerHTML;
</script>
