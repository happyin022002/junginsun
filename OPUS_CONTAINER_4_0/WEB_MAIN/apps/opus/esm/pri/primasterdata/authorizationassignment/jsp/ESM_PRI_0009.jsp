<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0009.jsp
*@FileTitle  : S/C & TRI Authority Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.event.EsmPri0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="java.util.List"%>

<%
    EsmPri0009Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error happened at server side
    String strErrMsg = "";                      //Error Message
    int rowCount     = 0;                       //DB ResultSet List Count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String[] svcScpCds = null;
    Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.AuthorizationAssignment");
    String[] authFlg = null;  

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();


        event = (EsmPri0009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // Adding the code extract data from server when initialization loading. 
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data creation
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        authFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("authFlg"), false ,"|","\t","getCode","getName");
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var svcScpComboValue = "|<%=svcScpCds[0]%>";
    var svcScpComboText = "|<%=svcScpCds[1]%>";
    var authFlgValue = "<%=authFlg[0]%>";
    var authFlgText = "<%=authFlg[1]%>"; 

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
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
<!--Page Title, Historical (E)-->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="1" />
            <col width="93" />
            <col width="60" />
            <col width="1" />
            <col width="60" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr>
                <th>Control Office</th>
                <td><input type="text" name="cntr_ofc_cd" style="width:70px;"  value="<%=strOfc_cd %>" class="input2" readonly="readonly"></td>
                <th>Authority Holder</th>
                <td><input type="text" name="cntr_usr_id" style="width:200px;"  value="<%=strUsr_nm %>" class="input2" readonly="readonly"></td>
            </tr>
            <tr>
                <th>Service Scope</th>
                <td colspan="5"><script language="javascript">ComComboObject('svc_scp_cd', 2, 70, 0, 1, 0, false);</script><!-- 
                --><input name="svc_scp_nm" type="text" style="width:320px;"  value="" class="input2" readonly="readonly" caption="Service Scope">
                </td>
                <th>User Office</th>
                <td><input type="text" name="ofc_cd" style="width:60px;ime-mode:disabled;" value="" class="input1" dataformat="enguponly" onKeyPress="ComKeyOnlyAlphabet('upper');" maxlength="6" required caption="User Office"></td>
                <th>User ID</th>
                <td>
                	<script language="javascript">ComComboObject('usr_id', 2, 100, 0, 0, 0, false);</script>
                	<input name="usr_nm" type="text" style="width:160px;"  value="" class="input2" readonly="readonly" caption="User Name">
                </td>
            </tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	
	   <!-- layout_vertical_2(S) -->
	   <div class="layout_vertical_2 pad_rgt_8" style="width:40%">
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid" id="mainTable">
	           <script type="text/javascript">ComSheetObject('sheet1');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	   </div>
	   <!-- layout_vertical_2(E) -->
	   
	   
	   <!-- layout_vertical_2(S) -->
	   <div class="layout_vertical_2" style="width:60%">
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid" id="mainTable">
	           <script type="text/javascript">ComSheetObject('sheet2');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	   </div>
	   <!-- layout_vertical_2(E) -->
	   
	</div>
	<!-- layout_wrap(E) -->	
    <!-- Grid  (S) -->
	<!-- <table class="search" border="0" style="width:100%;">
        <tr class="h23">
	        <td width="40%" valign="top">
	            <table width="100%" id="mainTable">
	                <tr>
	                    <td width="100%">
							그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음)
						    <script type="text/javascript">ComSheetObject('sheet1');</script>
						    그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음)
	                    </td>
	                </tr>
	            </table>
	        </td>
	        <td width="3%" valign=""></td>
	        <td width="57%" valign="">
	            <table width="100%"  id="mainTable">
	                <tr>
	                    <td width="100%">
	                    	그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음)
	    					<script type="text/javascript">ComSheetObject('sheet2');</script>
	    					그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음)    				
	                    </td>
	                </tr>
	            </table>
			</td>
		</tr>
	</table> -->
</div>

<div class="opus_design_grid" style="display:none;">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet3');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>