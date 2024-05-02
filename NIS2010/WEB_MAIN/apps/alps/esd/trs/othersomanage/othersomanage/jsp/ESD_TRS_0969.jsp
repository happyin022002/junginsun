<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0969.jsp
*@FileTitle : request.getParameter를 XML 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-02
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-11-02 poong_yeon
* 1.0 최초 생성
=========================================================*/
--%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.ArrayList"%>

<%
try{
	String prefix = request.getParameter("prefix");
	if(prefix == null) prefix = "";

	String [] ibflag = request.getParameterValues(prefix+"ibflag");
	if(ibflag == null || ibflag.length < 1)
	{
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%
		return;
	}

	ArrayList formV = new ArrayList();
	ArrayList sheetV = new ArrayList();
	String emStr = null;

	Enumeration emParamName = request.getParameterNames();
	while(emParamName.hasMoreElements())
	{
		emStr = (String) emParamName.nextElement();
		if(request.getParameterValues(emStr).length == ibflag.length){
			sheetV.add(emStr);
		}else if(request.getParameterValues(emStr).length == 1){
			formV.add(emStr);
		}
	}

	/* COLORDER 생성 */
	StringBuffer colOrder = new StringBuffer();
	for(int k=0; k<sheetV.size(); k++) {
		colOrder.append((String) sheetV.get(k));
		if(k != sheetV.size()-1) colOrder.append("|");
	}
	colOrder = new StringBuffer((colOrder==null?colOrder.toString():colOrder.toString().toLowerCase()));
	/* COLORDER 생성끝 */
%>
<SHEET>
	<DATA TOTAL="<%=ibflag.length%>" COLORDER="<%=colOrder%>">
<%
	for(int k=0; k<ibflag.length; k++) {
%>
	<TR>
<%
		for(int j = 0 ; j < sheetV.size() ; j++) {
%>
		<TD><![CDATA[<%=JSPUtil.getNull(request.getParameterValues((String)sheetV.get(j))[k]) %>]]></TD>
<%
		}
%>
	</TR>
<%
	}
%>
	</DATA>

<% if(formV.size() > 0){ %>
	<ETC-DATA>
<%
	String key = "";
	String value = "";
	for(int k=0; k<formV.size();k++)
	{
%>
<!-- 선택항목1. ETC-DATA 요소 -->
<%
		key = (String) formV.get(k);
		value = request.getParameter(key);
%>
		<ETC KEY='<%=JSPUtil.getNull(key)%>'><![CDATA[<%=JSPUtil.getNull(value)%>]]></ETC>
<%
	}
%>
	</ETC-DATA>
<% 
	}
%>
</SHEET>
<%
}catch(Exception e){
%>
<ERROR>
	<MESSAGE> <![CDATA[ <% out.println(e.getMessage()); %>]]> </MESSAGE>
</ERROR>
<%
	throw new Exception(e.getMessage());
}
%>