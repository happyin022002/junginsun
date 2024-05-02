<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5021
*@FileTitle  : Port Limits Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.event.VopScg5021Event"%>
<%
	VopScg5021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet List the number of
	SignOnUserAccount account = null;

	try {

		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (VopScg5021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end if

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


<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_cre_usr_id" value="<%=account.getUsr_id()%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" id="btn_retrieve" name="btn_retrieve">Retrieve</button><!--
			--><button class="btn_normal" type="button" id="btn_new" name="btn_new">New</button><!--
			--><button class="btn_normal" type="button" id="btn_save" name="btn_save">Save</button><!--
			--></div>
   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit" style="height:25px">
		<table>
			<colgroup>
				<col width="5"/>
				<col width="120"/>		
			</colgroup> 
			<tbody>
				<tr>
					<td>
						<input type="radio" name="un_loc_cd_flg" value="S" class="trans" id="un_loc_cd_flg" checked/>&nbsp;&nbsp;<b>Singapore</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="un_loc_cd_flg" value="J" class="trans" id="un_loc_cd_flg" />&nbsp;&nbsp;<b>Jeddah</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="un_loc_cd_flg" value="L" class="trans" id="un_loc_cd_flg" />&nbsp;&nbsp;<b>Le Havre</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <!-- input type="radio" name="un_loc_cd_flg" value="C" class="trans" id="un_loc_cd_flg" />&nbsp;&nbsp;<b>Shanghai</b-->
					</td>					
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class= "wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_grid">
	<!-- opus_design_btn (E) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_up" name="btns_up" id="btns_up"></button><!--
			 --><button type="button" class="btn_down" name="btns_down" id="btns_down"></button><!--
			 --><button type="button" class="btn_accent" name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_accent" name="btn_rowins" id="btn_rowins">Row Insert</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button><!-- 
		 -->
		 </div>
		<!-- opus_design_btn(E) -->
		<div id="SHEET1" style="display:inline">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div id="SHEET2" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
</form>