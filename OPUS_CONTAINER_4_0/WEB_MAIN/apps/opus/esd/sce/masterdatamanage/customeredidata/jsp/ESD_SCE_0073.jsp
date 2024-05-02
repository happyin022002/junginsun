<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0073.jsp
*@FileTitle  : My Performance Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0073Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
		EsdSce0073Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;            				
		String newOld = JSPUtil.getNull(request.getParameter("newOld"));             	
		String repNm = JSPUtil.getNull(request.getParameter("repNm"));
		String grpId = JSPUtil.getNull(request.getParameter("grpId"));
		String grpNm = JSPUtil.getNull(request.getParameter("grpNm"));
		String tpId = JSPUtil.getNull(request.getParameter("tpId"));

		String strErrMsg = "";                                  	
		DBRowSet rowSet      = null;                            //DB ResultSet
		int rowCount     = 0;                                   //DB ResultSet 	
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId=account.getUsr_id();

    	try{
	    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	    	if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (EsdSce0073Event)request.getAttribute("Event");
	        }
		} catch(Exception e) {
	        out.println(e.toString());
	    }
%>

<script type="text/javascript">
    function setupPage(){
        loadPage();
        var formObject = document.form ;
    }
</script>
<base target="_self"/>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="newOld" value=<%=newOld%>>
<input type="hidden" name="user_id" value=<%=userId%>>
<input type="hidden" name="cre_usr_id" value=<%=userId%>>
<input type="hidden" name="edi_grp_cd" value=<%=grpId%>>
<input type="hidden" name="edi_grp_id" value=<%=grpId%>>
<input type="hidden" name="tp_cd" value="">
<input type="hidden" name="edi_grp_desc" value="">
<input type="hidden" name="edi_cgo_rmk" value="">
<input type="hidden" name="sendClose" value="">

	<div class="page_title_area clear">
		<h2 class="page_title"><span>My Performance Report</span></h2>
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- Repeat Pattern -->
			<% if(newOld.equals("1") || newOld.equals("2") || newOld.equals("3")){ %>
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<% } %>
			
			<% if(newOld.equals("2")){ %>
				<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
				<button type="button" class="btn_normal" name="btn_save1" id="btn_save1">Save</button>
			<% } else if(newOld.equals("1") || newOld.equals("3")){%>
				<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
			<% } else if(newOld.equals("4")){ %>
				<button type="button" class="btn_normal" name="btn_save1" id="btn_save1">Save</button>
			<% } %>
			
			<%if(newOld.equals("2")){%>
				<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button>
			<% } else if(newOld.equals("1")){%>
				<button type="button" class="btn_normal" name="btn_ok1" id="btn_ok1">OK</button>
			<% } %>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			<!-- Repeat Pattern -->
		</div>
		<!-- opus_design_btn(E) -->
	</div>


	<div class="wrap_search">
	    <div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <tbody>
				<tr>
					<th width="30" style="text-align:left;">Report Name</th>
					<% if(newOld.equals("2")){ %>
						<td>
							<%=codeUtil.searchCodeCombo("mycust"," ( select edi_grp_cd a, cust_trd_prnr_id b, edi_grp_desc c, edi_cgo_rmk d from edi_usr_cust where cre_usr_id = '"+userId+"' and edi_sts_seq = '2' )   "
							        ," a||'%'||b||'%'||c  "
							        ," d ","a"," style='width:290px' onChange=javascript:onValueChange('mycust',this.form)","1:: ")%>
						</td>
					<% } else if((newOld.equals("1")) || (newOld.equals("3"))){ %>
						<td>
							<input name="mycust"  type="text" class="input" style="width:291px;"  value="" >
						</td>
					<% } else if(newOld.equals("4")) { %>
						<td>
							<input name="mycust"  type="text" class="input" style="width:291px;"  value="<%=repNm%>" readonly>
						</td>
					<% } %>
				</tr>
				<tr>
					<th style="text-align:left;">Group ID </th>
					<% if((newOld.equals("1")) || (newOld.equals("3"))){ %>
						<td width="298">
							<input name="cs_grp_id"  type="text" class="input" style="width:70px; text-transform:uppercase;"  value=""  onfocusout="javascript:onObjectFocusout(this.form)">
							<input name="tp_id"  type="text" class="input" style="width:70px; text-transform:uppercase;"  value="" onfocusout="javascript:onObjectTpId(this.form)">
							<input name="grp_nm"  type="text" class="input" style="width:120px; text-transform:uppercase;"  value="">
							<button type="button" class="input_seach_btn" onClick="openCustomer()"></button>
						</td>
					<%} else if(newOld.equals("2")){%>
						<td>
							<input name="cs_grp_id"  type="text" class="input" style="width:70px; text-transform:uppercase;"  value="" readonly>
							<input name="tp_id"  type="text" class="input" style="width:70px; text-transform:uppercase;"  value="" readonly>
							<input name="grp_nm"  type="text" class="input" style="width:120px; text-transform:uppercase;"  value="" readonly>
						</td>
						<td>
						</td>
					<%} else if(newOld.equals("4")){ %>
						<td>
							<input name="cs_grp_id"  type="text" class="input" style="width:70px; text-transform:uppercase;"  value="<%=grpId%>" readonly>
							<input name="tp_id"  type="text" class="input" style="width:70px; text-transform:uppercase;"  value="<%=tpId%>" readonly>
							<input name="grp_nm"  type="text" class="input" style="width:120px; text-transform:uppercase;"  value="<%=grpNm%>" readonly>
						</td>
						<td>
						</td>
					<% } %>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		  
	    </div>    
	    <!-- inquiry_area(E) -->
	</div>
	
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