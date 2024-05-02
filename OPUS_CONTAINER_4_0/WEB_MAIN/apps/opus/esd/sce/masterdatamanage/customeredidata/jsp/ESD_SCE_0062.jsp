<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0062.jsp
*@FileTitle  : Customer Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0062Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
		EsdSce0062Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;            			//Setting error at server side.

		String mycust = JSPUtil.getNull(request.getParameter("mycust"));   // Setting visible/in-visible Button.

		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId=account.getUsr_id();

    	String strErrMsg = "";                                  //Error Message
		DBRowSet rowSet      = null;                            //DB ResultSet

		int rowCount     = 0;                                   //DB ResultSet List Count


    try {

    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsdSce0062Event)request.getAttribute("Event");
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">

    function setupPage(){
        loadPage();
        var formObject = document.form ;
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="temp_edi_grp">
<input type="hidden" name="temp_edi_id">
<input type="hidden" name="temp_edi_nm">
<input type="hidden" name="user_id" value=<%=userId%>>
<input type="hidden" name="mycust" value=<%=mycust%>>
<input type="hidden" name="sendClose">
<input type="hidden" name="temp_cs_cd">
<input type="hidden" name="temp_sc_no">
<input type="hidden" name="temp_tp_id">
<input type="hidden" name="temp_cs_nm">


	<div class="page_title_area clear">
		<h2 class="page_title"><span>Customer Inquiry</span></h2>
		
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"> 
				 <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
				 --><% if(mycust.equals("1")){ %><!-- 
					 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!-- 
				 --><% } else if(mycust.equals("2") || mycust.equals("3")){%><!-- 
					 --><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!-- 
				 --><% } else {%><!-- 
					 --><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Add To My Cust</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button> 
				 <% } %> 
			</div>
			<!-- opus_design_btn(E) -->
	</div>


<!-- popup_contens_area(S) -->

    <!-- inquiry_area(S) -->
    <div class="wrap_search">
	    <div class="opus_design_inquiry wFit">
		    <table>
		        <tbody>
					<tr>
						<th width="80">Customer Code </th>
						<td width="80"><input name="cs_cd"  type="text" class="input" style="width:102px; text-transform:uppercase;"  value="" onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
						<th width="80">Contract No</th>
						<td><input name="sc_no"  type="text" class="input" style="width:102px; text-transform:uppercase;"  value="" onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
					</tr>
					<tr>
						<th>TP ID </th>
						<td><input name="tp_id"  type="text" class="input" style="width:102px; text-transform:uppercase;"  value="" onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
						<th>Customer Name </th>
						<td><input name="cs_nm"  type="text" class="input" style="width:102px; text-transform:uppercase;"  value="" onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
					</tr>
				</tbody>
			</table>
	    </div>    
	</div>
	 <!-- inquiry_area(E) -->
	 
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('t1sheet');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	

<!-- popup_contens_area(E) -->

</form>