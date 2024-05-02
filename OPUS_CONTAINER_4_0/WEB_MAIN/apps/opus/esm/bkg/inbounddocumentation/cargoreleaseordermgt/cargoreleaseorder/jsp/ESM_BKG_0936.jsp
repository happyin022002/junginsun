<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0936.jsp
*@FileTitle  : DO Receiver and Ultimate Consignee(Incl. House BL No) Setting
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0936Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO" %>
<%@ page import="java.util.List" %>

<%
    EsmBkg0936Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");
    
    // Local에 사용할 변수 선언
    String doNo = "";
    int iSize = 0;
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmBkg0936Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        if (strErrMsg.equals("")) {
        
            // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
            GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
            doNo       = JSPUtil.getParameter(request, "do_no");
        }
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var parDoNo = "<%=doNo%>";

    var errMessage = "<%=strErrMsg%>";
    
    function setupPage(){
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업    -->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>DO Receiver and Ultimate Consignee(Incl. House BL No) Setting</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--  
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="sm"> 
              <tr>
                <td width="60">&nbsp;&nbsp;D/O No.</td> 
                <td>
                  <input type="text" name="do_no" minlength="10" maxlength="12" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" readonly="true" style="width:100; text-align:center;" class="input2" value="">
                </td>
              </tr>
            </table>
			<table> 
				<tbody>
					  <tr>
		                <td width="120">House B/L No.</td> 
		                <td colspan="3"><input type="text" name="hbl_no" maxlength="20" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="width:100%" class="input" value=""></td>
		              </tr>
		              <tr>
		                <td>Ultimate Consignee</td> 
		                <td colspan="3"><input type="text" name="rcvr_cnee_nm" maxlength="500" style="width:100%" class="input" value=""></td>
		              </tr>
		              <tr>
		                <td>Receipt Company</td> 
		                <td colspan="3"><input type="text" name="rcvr_co_nm" maxlength="50" style="width:100%" class="input" value=""></td>
		              </tr>
		              <tr>
		                <td width="120">Contact Phone</td> 
		                <td width="200"><input type="text" name="rcvr_phn_no" style="ime-mode:disabled"  maxlength="20" style="width:100%" class="input" value=""></td>
		                <td width="80">PIC</td> 
		                <td width=""><input type="text" name="pic_nm" maxlength="100" style="width:100%" class="input" value=""></td>
		              </tr>
		              <tr>
		                <td>E-Mail Address</td> 
		                <td><input type="text" name="rcvr_eml" style="ime-mode:disabled" maxlength="200" style="width:100%" class="input" value=""></td>
		                <td>Order B/L</td> 
		                <td><input type="text" name="cust_to_ord_flg_nm" style="width:100%" class="input2" readonly="true" value=""></td>
		              </tr>
				</tbody>
			</table>
			 <table >
				  <tr>
				    <td>
				      <script language="javascript">ComSheetObject('sheet1');</script>
				    </td>
				  </tr>
			</table>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->
<!-- 개발자 작업  끝 -->
</form>
