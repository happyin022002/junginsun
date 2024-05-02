<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0136.jsp
*@FileTitle  : Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String strUsr_id		= "";
	String strUsr_nm		= "";
    
	String strBlMkDesc    = "";
	
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {        
		strBlMkDesc = JSPUtil.getNullNoTrim(request.getParameter("bl_mk_desc"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<form name="form" method="post">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Remark</span></h2>
		<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_accept"	id="btn_accept">Accept</button><!--  
       	--><button type="button" class="btn_normal" name="btn_close"  id="btn_close">Close</button>
    </div>
    <!-- opus_design_btn(E) -->
	</div>
	
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
	                    <td width="100%"><textarea name="mark_desc" Style="width:100%" rows="9"><%=strBlMkDesc%></textarea></td>
	                </tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid" >
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>