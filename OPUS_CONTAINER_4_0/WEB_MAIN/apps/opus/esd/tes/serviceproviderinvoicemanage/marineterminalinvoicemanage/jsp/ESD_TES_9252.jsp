<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_9252.jsp
*@FileTitle  : TES 3rd Party Billing Input Popup - Marine Terminal Invoice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String tml_so_ofc_cty_cd = request.getParameter("tml_so_ofc_cty_cd"	)!=null&&!request.getParameter("tml_so_ofc_cty_cd"	).equals("")?request.getParameter("tml_so_ofc_cty_cd" 	):"";
	String tml_so_seq		 = request.getParameter("tml_so_seq"		)!=null&&!request.getParameter("tml_so_seq"			).equals("")?request.getParameter("tml_so_seq"			):"";
	String tml_so_dtl_seq 	 = request.getParameter("tml_so_dtl_seq"	)!=null&&!request.getParameter("tml_so_dtl_seq"		).equals("")?request.getParameter("tml_so_dtl_seq" 		):"";
	String inv_no		  	 = request.getParameter("inv_no"		 	)!=null&&!request.getParameter("inv_no"				).equals("")?request.getParameter("inv_no"				):"";
	String curr_cd		  	 = request.getParameter("curr_cd"		 	)!=null&&!request.getParameter("curr_cd"			).equals("")?request.getParameter("curr_cd"				):"";
%>


<script language="javascript">
<%= JSPUtil.getIBCodeCombo("combo01", "01", "CD00583", 0, "")%>
	function setupPage(){
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tml_so_ofc_cty_cd"	 	 value="<%=tml_so_ofc_cty_cd%>">
<input type="hidden" name="tml_so_seq"				 value="<%=tml_so_seq		%>">
<input type="hidden" name="tml_so_dtl_seq"		 	 value="<%=tml_so_dtl_seq	%>">
<input type="hidden" name="inv_no"					 value="<%=inv_no			%>">
<input type="hidden" name="curr_cd"					 value="<%=curr_cd			%>">


<!-- OUTER - POPUP (S)tart -->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>3rd Party Interface</span></h2>
		
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
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
</div>
</form>

