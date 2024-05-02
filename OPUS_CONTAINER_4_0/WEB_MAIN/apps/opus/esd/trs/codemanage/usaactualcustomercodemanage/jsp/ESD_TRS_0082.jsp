<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0082.jsp
*@FileTitle : USA Actual Customer Code Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-16
*@LastModifier : Kim Jun Ho
*@LastVersion : 1.0
* 2007-10-16 Kim Jun Ho
* History
* 2010.09.03 최종혁 [CHM-201005753] Actual customer 'Status flag' 변경시 표기사항 일부 변경 요청
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.event.EsdTrs0082Event"%>
<%
	EsdTrs0082Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId="";
	String ofc_cd="";
	SignOnUserAccount account= null;
	try {
	    account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    userId=account.getUsr_id();
	    ofc_cd=account.getOfc_cd();
	    event = (EsdTrs0082Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	var act_cust_bnd_cdText = "IN|OUT";
	var act_cust_bnd_cdCode = "I|O";
	var delt_flgText = "LIVE|DELETED";
	var delt_flgCode = "N|Y";

	function setupPage(){

		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}  // end if
		loadPage();
	}

</script>
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="iPage">
	<input type="hidden" name="login_ofc_cd" value="<%=ofc_cd%>">
	<input type="hidden" name="login_usr_id" value="<%=userId%>">
	<input type="hidden" name="login_date" value="<%=today%>">
	<input type="hidden" name="sel_trsp_act_cust_no">
	<input type="hidden" name="mst_dtl_indicator">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->            
   
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
         --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
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


<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table>
            <colgroup>
                <col width="150" />
                <col width="50" />
                <col width="150" />
                <col width="150" />
                <col width="100" />
                <col width="80" />
                <col width="80" />
                <col width="80" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr class="h23">
                    <th>Status</th>
                    <td><select name="status" style="width:100;"><option value="A">ALL</Option><option value="N">Live</Option><option value="Y">Deleted</Option></select></td>
                    <th>Bound</th>
                    <td style="padding-left:3;"><select name="bound" style="width:100;"><option value="A">ALL</Option><option value="I">IN</Option><option value="O">OUT</Option></select></td>
                    <th>Door</th>
                    <td><input name="dor_loc" type="text" style="width:56;" onchange='getComboList(this)'  maxlength=5 dataformat="engup"><script language="javascript">ComComboObject('dor_nod', 1, 55, 0);</script></td>
                    <th>Customer Code</th>
                    <td align="right"><input type="text" style="width:103" name='input_cust_cd' maxlength=8 dataformat="engup"><!--  
                    	--><button type="button" name="btng_customer" id="btng_customer"  class="input_seach_btn"></button></td>
                    <td></td>
                </tr><tr class="h23">
                    <th>Actual Customer Name</th>
                    <td colspan="5"><input name="input_cust_nm" type="text" style="width:100%;" value="" dataformat="engup"></td>
                    <th>Creation Office</th>
                    <td style="padding-left:3;"><input name="input_cre_ofc_cd" type="text" style="width:103;" value="<%=ofc_cd%>" onchange="javascript:fun_officeText();" dataformat="engup"><!--  
                    	--><button type="button" name="btns_multiofc" id="btns_multiofc" class="multiple_inq ir"></button></button>
                    </td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">    
	 <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button><!-- 
            --><button type="button" class="btn_normal" name="btng_rowadd1" id="btng_rowadd1">Row Add 1</button><!-- 
            --><button type="button" class="btn_normal" name="btng_rowadd2" id="btng_rowadd2">Row Add 2</button><!-- 
            --><button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>
        </div>
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
    <div style="height:10px"></div>
    <div class="opus_design_grid">
    	<script language="javascript">ComSheetObject('sheet2');</script>
    </div>
    <div class="opus_design_grid">
    	<script language="javascript">ComSheetObject('sheet3');</script>
    </div>
</div>
<div class="header_fixed"></div>
</form>