<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0079.jsp
*@FileTitle  : Control Office Exception Case Creation
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
<%@ page import="com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.event.EsdTrs0079Event"%>
<%
	EsdTrs0079Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //Error message
	int rowCount	 = 0;								  //List the number of DB ResultSet

	String userId = null;
	SignOnUserAccount account = null;

	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		event = (EsdTrs0079Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

    String costModeCd   = JSPUtil.getCodeCombo("search_trs_cost_md_cd", "01", "style='width:160'", "CD00744", 0, "000020::");
    String transModeCd  = JSPUtil.getCodeCombo("search_trs_md_cd", "01", "style='width:50'", "CD00283", 0, "000010::");
    String cargoTypeCd  = JSPUtil.getCodeCombo("search_cgo_tp_cd", "01", "style='width:50' onChange='resetCostMode(this.value);'", "CD00748", 0, "000010::");
%>
<script type="text/javascript">

<%= JSPUtil.getIBCodeCombo("cgo_tp_cd", "", "CD00748", 0, "")%>
<%= JSPUtil.getIBCodeCombo("trsp_cost_dtl_mod_cd", "", "CD00744", 0, "")%>
<%= JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "", "CD00283", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type='hidden' name='userId' value='<%=userId%>'>
<input type='hidden' name='TRSP_SO_EQ_KIND'>
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">



<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!--
	 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
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

<div id="MiniLayer" style="display:inline">
<!-- wrap_search(S) -->  
<div class="wrap_search">
    <!-- opus_design_inquiry (S) -->
    <div class="opus_design_inquiry wFit">
	   <table>
      	 <colgroup>
             <col width="120">
             <col width="160">
             <col width="80">
             <col width="180">
             <col width="80">
             <col width="160">
             <col width="100">
             <col width="*">
         </colgroup>
	      <tbody>
	       <tr>
	           <th>For COP/MTY Plan</th>
	           <td><%=cargoTypeCd%></td>
	           <th>Cost Mode</th>
	           <td><%=costModeCd%></td>
	           <th>Trans Mode</th>
	           <td><%=transModeCd%></td>
	           <th>Control Office</th>
	           <td>
	               <input id = "input_office" name = "input_office" type="text" onBlur = 'javascript:this.value=this.value.toUpperCase();' style="width:82px;" value="" dataformat="engup" otherchar=","><!-- 
	            --><button type = "button" class = "input_seach_btn" id = "btns_office" name = "btns_office"></button>&nbsp;
	           </td>
	       </tr>
	       </tbody>
	     </table>
	
	      <table>
          <colgroup>
                 <col width="120">
                 <col width="160">
                 <col width="80">
                 <col width="180">
                 <col width="80">
                 <col width="160">
                 <col width="100">
                 <col width="*">
             </colgroup>
          <tbody>
          <tr>
              <th>From</th>
              <td><input type="text" style="width:56px;" name="search_fm_loc" onchange="getComboList(this)" maxlength="5" id="search_fm_loc" dataformat="engup" /><!-- 
                  --><script type="text/javascript">ComComboObject('search_fm_yard', 1, 50, 0);</script><input type="hidden" name="temp_search_fm_yard" id="temp_search_fm_yard"><!-- 
               --><button type="button" name="btns_frmnode" id="btns_frmnode"  class="input_seach_btn"></button></td>
             
              <th>Via</th>
              <td><input type="text" style="width:56px;" name="search_via_loc" onchange="getComboList(this)" maxlength="5" id="search_via_loc" dataformat="engup" /><!-- 
               --><script type="text/javascript">ComComboObject('search_via_yard', 1, 50, 0);</script><input type="hidden" name="temp_search_via_yard" id="temp_search_via_yard"><!-- 
               --><button type="button" name="btns_vianode" id="btns_vianode"  class="input_seach_btn"></button></td>

              <th>To</th>
              <td><input type="text" style="width:56px;" name="search_to_loc" onchange="getComboList(this)" maxlength="5" id="search_to_loc" dataformat="engup" /><!-- 
               --><script type="text/javascript">ComComboObject('search_to_yard', 1, 50, 0);</script><input type="hidden" name="temp_search_to_yard" id="temp_search_to_yard"><!-- 
               --><button type="button" name="btns_tonode" id="btns_tonode"  class="input_seach_btn"></button></td>                        

              <th>Door</th>
              <td><input type="text" style="width:56px;" name="search_door_loc" onchange="getComboList(this)" maxlength="5" id="search_door_loc" dataformat="engup" /><!-- 
               --><script type="text/javascript">ComComboObject('search_door_yard', 1, 50, 0);</script><input type="hidden" name="temp_search_door_yard" id="temp_search_door_yard"><!-- 
               --><button type="button" name="btns_dorloc" id="btns_dorloc"  class="input_seach_btn"></button></td>                         
          </tr>
         </tbody>
       </table>
    </div>
    <!-- opus_design_inquiry (E) -->
</div>
<!-- wrap_search(E) -->  
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	    <!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="btng_rowdel" id="btng_rowdel">Row Delete</button>
				<button type="button" class="btn_normal" name="btng_save" id="btng_save">Save</button>
			</div>
			<!-- opus_grid_btn(E) -->
			
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<div class="header_fixed"></div>
</form>
