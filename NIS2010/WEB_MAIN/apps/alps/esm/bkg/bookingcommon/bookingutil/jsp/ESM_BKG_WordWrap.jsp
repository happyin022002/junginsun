<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_WordWrap.jsp
*@FileTitle : temp
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.04.28 이일민
* 1.0 Creation
=========================================================*/
%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %> 
<%@ page contentType="text/html; charset=UTF-8"%>
<textarea id="mk_desc">
<%=StringUtil.xssFilter(request.getParameter("mk_desc")) %></textarea>
<textarea id="mk_desc_old">
<%=StringUtil.xssFilter(request.getParameter("mk_desc")) %></textarea>
<textarea id="dg_cmdt_desc">
<%=StringUtil.xssFilter(request.getParameter("dg_cmdt_desc")) %></textarea>
