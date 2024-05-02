<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_9254.jsp
*@FileTitle  : 3rd Party Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/20
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
   	String tml_so_ofc_cty_cd	= request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String tml_so_seq			= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";
	String tml_so_dtl_seq		= request.getParameter("tml_so_dtl_seq")!=null&&!request.getParameter("tml_so_dtl_seq").equals("")?request.getParameter("tml_so_dtl_seq"):"";
	String inv_no				= request.getParameter("inv_no")!=null&&!request.getParameter("inv_no").equals("")?request.getParameter("inv_no"):"";
%>
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
    function setupPage(){
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
<input type="hidden" name="tml_so_dtl_seq" value='<%=tml_so_dtl_seq%>'>
<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>&nbsp;3rd Party Interface</span></h2>
		
		<div class="opus_design_btn"> 
			 <button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr class="h23">
					<td width="10%">Source No.</td>
					<td><input type="text" readOnly style="width:80" value="<%=inv_no%>"></td>
					</tr>
				</tbody>
			</table>
			<script language="javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
</div>
<div class="header_fixed"></div>
</form>