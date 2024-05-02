<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0032.jsp
*@FileTitle  : Customer EDI Information 
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
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0032Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
    EsdSce0032Event  event = null;                			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;            			//error from server

	String strErrMsg = "";                                  //error message
	DBRowSet rowSet      = null;                            //DB ResultSet
	int rowCount     = 0;                                   //count of DB resultSET list

    try {
    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (EsdSce0032Event)request.getAttribute("Event");
            
        }//if
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form method="post" name="form" id="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="130">
            <col width="100">
            <col width="100">
            <col width="100">
            <col width="100">
            <col width="91">
            <col width="*">
		</colgroup>
		<tbody>
			<tr>
				<th>EDI Customer Group</th>
				<td colspan="5"><input type="text" name="grp_nm" id="grp_nm" style="width:67px;" dataformat="engup" onfocusout="javascript:onObjectFocusout('grp_nm','cs_grp_id',this.form)">
				&nbsp;<%=codeUtil.searchCodeCombo("cs_grp_id"," (select edi_grp_cd a,  edi_grp_desc from edi_group order by a) " ,"a edi_grp_cd","'('||a||') '||edi_grp_desc "," a"," onChange=javascript:onValueChange('cs_grp_id',this.form) style=\"width:760px;\"","1:: ")%></td>
			</tr>
			<tr>
				<th>Customer TP ID</th>
				<td><%=codeUtil.searchCodeCombo("cs_tp_id"," edi_group e","distinct(cust_trd_prnr_id)","cust_trd_prnr_id","trim(cust_trd_prnr_id) is not null","e.cust_trd_prnr_id"," onChange=javascript:onValueChange('cs_tp_id',this.form) style=\"width:145px;\"","1::ALL")%></td>
				<th>Company TP ID</th>
				<td><%=codeUtil.searchCodeCombo("co_tp_id"," edi_group e","distinct(prov_trd_prnr_id)" ,"prov_trd_prnr_id","trim(prov_trd_prnr_id) is not null","e.prov_trd_prnr_id"," onChange=javascript:onValueChange('co_tp_id',this.form)  style=\"width:145px;\"","1::ALL")%></td>
				<th>S/C No.</th>
				<td><%=codeUtil.searchCodeCombo("sc_no"," edi_grp_cust c","distinct(sc_no)" ,"sc_no","trim(sc_no) is not null","c.sc_no"," onChange=javascript:onValueChange('sc_no',this.form) style=\"width:150px;\"","1::ALL")%></td>
				<td></td>
			</tr>
			<tr>
				<th>Customer Code</th>
				<td colspan="5"><input type="text" name='cs_nm' id='cs_nm' style="width:67px;" dataformat="engup"  onfocusout="javascript:onObjectFocusout('cs_nm','cs_cd',this.form)">
				&nbsp;<%=codeUtil.searchCodeCombo("cs_cd"," edi_grp_cust egc, mdm_customer mc ","distinct(egc.cust_cnt_cd || egc.cust_seq)" ,"'('||egc.cust_cnt_cd || egc.cust_seq||')'||mc.cust_lgl_eng_nm","egc.cust_cnt_cd = mc.cust_cnt_cd and  egc.cust_seq = mc.cust_seq",""," onChange=javascript:onValueChange('cs_cd',this.form) style=\"width:760px;\"","1::ALL")%></td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>

<!-- opus_tab_btn(S) -->
<div class="wrap_result">
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!--TAB Master B/L (S) -->
<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet');</script>
</div>
<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t2sheet');</script>
</div>
</div>

<!-- opus_design_inquiry(E) -->

</form>