<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0001.jsp
*@FileTitle  : EQ Status Code Creation
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
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%
	EesMst0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerSpecMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		strOfc_cd = account.getOfc_cd();
	   
		event = (EesMst0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">

<%=OfficeCodeMgr.getOfficeCodeListToJS("000001", "MST")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		// Ofc_cd 지정.
		strOfcCd = "<%=strOfc_cd%>";
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
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
   
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn" >
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_normal" name="btn_save"  id="btn_save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>
    </div>
    <!-- opus_design_btn(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<div class="wrap_result">
	<div class="layout_wrap">
		<div class="layout_vertical_2" style="padding-right:5px">
			 <div class="opus_design_grid" style="padding-top: 37px;">
				    <div class="opus_design_btn"  id = "div_ofc1" name = "div_ofc1" style = "display:none">
						<button type="button" class="btn_normal" name="btn_add"  	id="btn_add">Row Add</button><!-- 
						--><button type="button" class="btn_normal" name="btn_delete" 	id="btn_delete">Delete</button>
				    </div>
           			<script type="text/javascript">ComSheetObject('sheet1');</script>
        	</div>
		</div>
		
		<div class="layout_vertical_2"  style="padding-right:1px">				
		<div class= "opus_design_inquiry" style="text-align: right;height:29px">
		STS&nbsp;<input type="text" name="cntr_sts_cd" id="cntr_sts_cd" style="width:78px;text-align:center" class="input" readonly>
    	</div>
        
        <div class="opus_design_grid">
        	<div class="opus_design_btn"  id="div_ofc2" name="div_ofc2" style = "display:none;">
				<button type="button" class="btn_normal" name="btn_add2" id="btn_add2">Row Add</button>
				<button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button>
		    </div>
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
		</div>
	</div>
</div>
<!-- opus_design_grid(S) -->

<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>
