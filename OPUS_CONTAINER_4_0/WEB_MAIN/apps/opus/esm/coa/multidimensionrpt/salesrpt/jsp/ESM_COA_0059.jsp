<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0059.jsp
*@FileTitle  : RPT Pop UP for the office weekly atypical performance analysis
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException = null;
    String strErrMsg = "";
    String userId = "";
    String selGroup = "";

    Logger log = Logger.getLogger("com.clt.opus.esm.coa.ESM_COA_0059");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //ADD----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        //ADD----------------------------------------------------------------------------------------- END

    }catch(Exception e) {
    	log.error("JSP Exception : " + e.toString());
    }
%>

<script type="text/javascript">
<!--
	$(".btn_gnb_hide").css("display","none");
	$(".header_fixed").css("display","none");
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";

        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
-->
</script>
<div style="height:0px">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
</div>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="f_group" id="f_group" />
<input type="hidden" name="f_header" id="f_header" />
<input type="hidden" name="f_headernm" id="f_headernm" />
<input type="hidden" name="f_dividename" id="f_dividename" />

<div class="layer_poup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title" style="padding-left: 0px; !important;"><span>Set Customized RPT Form</span></h2>
		<!-- page_title(E) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_New" id="btn_New">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		</div>
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="120">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Select Customized Form</th>
	                	<td><script type="text/javascript">ComComboObject('f_selgroup',1, 150 , 0 )</script></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_inquiry(E) --><!-- 
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table> -->
	</div>
	<div class="wrap_result">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
			<!-- layout_vertical_2(S) -->
			<div class="layout_flex_fixed pad_rgt_8" style="width:260px">
				<!-- opus_design_grid(E) -->	
				<div class="opus_design_grid" id="mainTable1" style="margin-bottom:0!importnat">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
				<!-- opus_design_grid(E) -->	
			</div>
	     	<!-- layout_vertical_2(E) -->
	   		<!-- layout_vertical_2(S) -->
			<div class="layout_flex_fixed" style="width:30px">
				<div style="margin-top: 100px;"><button type="button" class="btn_right" name="btns_add" id="btns_add"></button></div>
				<div class="mar_top_4"><button type="button" class="btn_left" name="btns_del" id="btns_del"></button></div>
			</div>
		     <!-- layout_vertical_2(E) -->
	   		<!-- layout_vertical_2(S) -->
			<div class="layout_flex_fixed pad_rgt_8" style="width:260px">
				<!-- opus_design_grid(E) -->	
				<div class="opus_design_grid" id="mainTable2" style="margin-bottom:0!important">
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>
				<!-- opus_design_grid(E) -->
			</div>
		     <!-- layout_vertical_2(E) -->
	   		<!-- layout_vertical_2(S) -->
			<div class="layout_flex_flex" style="padding-left:550px">
				<div style="margin-top: 100px;"><button type="button" class="btn_up" name="btns_up" id="btns_up"></button></div>
				<div class="mar_top_4"><button type="button" class="btn_down" name="btns_down" id="btns_down"></button></div>
			</div>
		     <!-- layout_vertical_2(E) -->
		</div>
		<!-- layout_wrap(E) -->
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="200">
					<col width="*">
				</colgroup>
				<tr>
	                <td><input type="radio" class="trans" name="saveYn" value="n" id="saveYn" />Use This Setting At This Time Only</td>
	                <td></td>
	              </tr>
	              <tr>
	                <td><input type="radio" class="trans" name="saveYn" value="y" checked id="saveYn" />Save This Setting For Later As</td> 
	                <td><input type="text" style="width:160px;" name="f_savename" value="" id="f_savename" /></td>
	              </tr>
			</table>
		</div>
	</div>	
</div>
</form>