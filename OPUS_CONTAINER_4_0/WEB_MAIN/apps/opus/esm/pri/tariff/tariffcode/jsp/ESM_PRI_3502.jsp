<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3502.jsp
*@FileTitle  : Tariff Code Creation 
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
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffcode.event.EsmPri3502Event"%>
<%@ page import="com.clt.syscommon.common.table.PriTariffVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3502Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String inlandFlag = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String trfInlndFlg     = null;				//combo var
	String isPopup = null;
	
	String[] scopeCd = null;

	Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffCode");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EsmPri3502Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		scopeCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("scopeList"), true);
		isPopup = JSPUtil.getNull(request.getParameter("is_popup")); //POP UP Screen or not
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=ConstantMgr.getScacCodeToJS()%>
    var scopeCdValue = " |<%=scopeCd[0]%>";
    var scopeCdText = " |<%=scopeCd[1]%>";
    
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
<input type="hidden" name="strusr_id" value="<%=strUsr_id %>">
<input type="hidden" name="strofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="successFlag" value ="Y">
<input type="hidden" name="trf_inlnd_flg" value="">

<%
    if (isPopup.equals("true")) {
%>
<div class="layer_popup_title">
	<!-- page(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<h2 class="page_title"><span>Tariff Code Creation</span></h2>
	
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
		</div>
	
	</div>
</div>
<%
    } else {
%>
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
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
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
<%
    }
%>

<%
    if (isPopup.equals("true")) {
%>
<div class="layer_popup_contents">
<%
    }
%>
<!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<!--  MiniLayer (S) -->
			<table>
				<tbody>
					<tr>
		                <th width="90">Tariff Code</th>
						<td width="347"><input type="text" name="trf_pfx_cd" style="width:50px;" class="input2" value="" readonly><!-- 
						--><input type="text" name="trf_no" maxlength="3" style="width:50px;text-align:center;" class="input1" value=""  dataformat="engup" 
							onkeyup="upper(this); javascript:searchTariffCodeName(this);" /></td>
						<th width="90">Inland Rates</th>
						<td width="100"><script type="text/javascript">ComComboObject("inland_rates", 0, 60, 0, 1, 0, false); </script></td>
		            </tr>
		            <tr>
		                <th>Tariff Name</th>
						<td colspan="3"><input type="text" name="trf_nm" style="width:505px" class="input2"  value=""  maxlength="100"  dataformat="eng" otherchar=" " readOnly></td>
		            </tr>
		            <tr>
		            	<th>Organization</th>
						<td><input type="text" name="trf_orz_nm" style="width:260px;" class="input2" value="" maxlength="100"></td>
						<th>Type</th>
						<td style=""><input type="text" name="trf_orz_tp_nm" style="width:57px;margin-left:3px;" class="input2" value="VOCC" maxlength="4" dataformat="engup" onkeyup="validationForm(this);" readonly></td>
		            	<td>
			            	<div id="flagLayer1" style="display:none">
								<table border="0" cellpadding="0" cellspacing="0"  >
									<tr>
										<td>Create Flag</td>
										<td><input type="text" name="cre_flg" style="width:500px;" class="input1"  value="  "></td>
									</tr>
								</table>
							</div>
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
			<h3 class="title_design">Tariff Scope</h3>
			<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="btn_rowdelete" id="btn_rowdelete">Row Delete</button>
			</div>
			<!-- opus_grid_btn(E) -->
		
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- page(E) -->
<%
    if (isPopup.equals("true")) {
%>
</div>
<%
    }
%>
</form>