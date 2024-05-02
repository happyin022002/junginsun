<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2038.jsp
*@FileTitle  : RFA Authority Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.event.EsmPri2038Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>

<%
    EsmPri2038Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    String[] svcScpCds = null;
    Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.AuthorizationAssignment");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();


        event = (EsmPri2038Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var svcScpComboValue = "<%=svcScpCds[0]%>";
    var svcScpComboText = "<%=svcScpCds[1]%>";

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

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
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

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
    <!--biz page (S)-->              


        <!--  biz_2  (S) -->
        <table>
	        <tr class="h23">
	            <th width="80px">Control Office</th>
	            <td width="370px"><input type="text" name="cntr_ofc_cd" style="width:60px;"  value="<%=strOfc_cd %>" class="input2" readonly="readonly"></td>
	            <th width="40px">Authority Holder</th>
	            <td><input type="text" name="cntr_usr_id" style="width:200px;"  value="<%=strUsr_nm %>" class="input2" readonly="readonly"></td>
	        </tr>
        </table>
        <table>
            <tr class="h23">
                <th width="80px">Service Scope</th>
                <td width="399px"><script language="javascript">ComComboObject('svc_scp_cd', 2, 55, 0, 1, 0, false);</script>
                &nbsp;<input name="svc_scp_nm" type="text" style="width:291px;"  value="" class="input2" readonly="readonly" caption="Service Scope">
                </td>

                <th width="70px">User Office</th>
                <td width="200px"><input type="text" name="ofc_cd" style="width:55;ime-mode:disabled;" value="" class="input1" onKeyPress="ComKeyOnlyAlphabet('upper');" maxlength="6" dataformat="engup" required caption="User Office"></td>
                <th width="40px">User ID</th>
                <td><script language="javascript">ComComboObject('usr_id', 2, 100, 0, 0, 0, false);</script>
                &nbsp;<input name="usr_nm" type="text" style="width:160px;"  value="" class="input2" readonly="readonly" caption="User Name">
                </td>
            </tr>
        </table>
</div>
</div>
<div class="wrap_result">
    <!-- <table class="search" border="0" style="width:100%;">
        <tr class="h23">
        <td width="40%" valign="top">
        	<div class="opus_design_grid" id="mainTable" >	
             <script type="text/javascript">ComSheetObject('sheet1');</script>
            </div>
        </td>
        <td width="3%" valign=""></td>
        <td width="57%" valign="top">
        
        opus_design_grid(S)
		<div class="opus_design_grid" id="mainTable" >										
			그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음)
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음)					
		</div>
		opus_design_grid(E)
        
        
        opus_design_grid(S)
		<div class="opus_design_grid" style="display:none">										
			그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음)
				<script type="text/javascript">ComSheetObject('sheet3');</script>
			그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음)					
		</div>
		opus_design_grid(E)

        </td>
        </tr>
        </table> -->

        <!--  biz_2   (E) -->
        
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
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


    <!-- Hidden sheet for Transaction (S) -->
    <span style="display:none;">
        <script type="text/javascript">ComSheetObject('sheet3');</script>
    </span>
    <!-- Hidden sheet for Transaction (E) -->
	</div>


</div>

    
</form>
