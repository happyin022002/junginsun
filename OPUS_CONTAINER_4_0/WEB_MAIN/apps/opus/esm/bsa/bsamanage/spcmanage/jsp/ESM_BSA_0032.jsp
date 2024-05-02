<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0032.jsp
*@FileTitle  : Inquire/Edit Supply & Slot-swap By VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event.EsmBsa0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	EsmBsa0032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.SPCManage");
	String prevWeek = "";
	String xml = "";
	
	//Combo Data : getCodeCombo('tag name','initial value', 'added elements', 'task name', 'condition code', 'Check all', 'Added option')
	//String cobTrade   = ComboUtil.getCodeCombo("cobTrade", "", " onChange='cobTrade_OnChange(this);'  style='width:70'", "trade", "", "All", "");
	//String cobLane    = ComboUtil.getCodeCombo("cobLane",  "", " style='width:80'", "rLane", "", "All", "");
	//String cobDir     = JSPUtil.getCodeCombo("cobDir", "", " style='width:70'", "CD00593", 0, "000001: :All");
	//String cobIOC     = JSPUtil.getCodeCombo("cobIOC", "", " style='width:80'", "CD00206", 0, "000020: :All");
	//String cobCarrier = ComboUtil.getCodeCombo("cobCarrier", "", " onChange='cobCarrier_onChange(this);' style='width:70'", "BSACarrier", "J", "N", "");


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");
    	prevWeek =eventResponse.getETCData("prevWk");
    	
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage() {
		var formObj = document.form;

		loadPage();

        formObj.txtYear.value = ComGetNowInfo("yy");  
        formObj.txtFmMonth.value = ComGetNowInfo("mm"); 
        formObj.txtToMonth.value = ComGetNowInfo("mm"); 
        formObj.txtFmMonth.value = ComLpad(formObj.txtFmMonth, 2, '0');
        formObj.txtToMonth.value = ComLpad(formObj.txtToMonth, 2, '0');
        formObj.txtFmWeek.value = "<%=prevWeek%>";
        formObj.txtToWeek.value = "<%=prevWeek%>";

       setPeriod(formObj.txtToWeek);
	}
</script>
<!-- 2014.11.19 김용습 - iframe을 div로 감싸서 div의 display를 none으로 설정하지 않으면 타이틀 아래 불필요한 하얀 여백이 생겨서, 해당 작업합니다 -->
<div style="display:none">
	<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
</div>

<!-- <form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();"> -->
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="param1" id="param1"> <!-- Gubun   |  Methode Name -->
<input type="hidden" name="param2" id="param2"> <!-- Year    |  vsl_cd       -->
<input type="hidden" name="param3" id="param3"> <!--         |  skd_voy_no   -->
<input type="hidden" name="param4" id="param4"> <!--         |  dir_cd       -->
<input type="hidden" name="param5" id="param5"> <!-- sMonth  |               -->
<input type="hidden" name="param6" id="param6"> <!-- eMonth  |               -->
<input type="hidden" name="param7" id="param7"> <!-- sWeek   |               -->
<input type="hidden" name="param8" id="param8"> <!-- eWeek   |               -->
<input type="hidden" name="sXml" value="<%= xml %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><!-- <button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button> -->
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
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<!--  MiniLayer (S) -->
				<div style="width:50%"><script type="text/javascript">initPeriod();</script></div>
				<table class="search_in">
					<tr><td class="line_bluedot"></td></tr>
				</table>
						<table>
							<colgroup>
					            <col width="52">
					            <col width="57">
					            <col width="75">
					            <col width="96">
					            <col width="57">
					            <col width="101">
					            <col width="44">
					            <col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th>Trade</th>
									<td><script type="text/javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
									<th>Lane</th>
									<td><div id="div_rLane"><script type="text/javascript">ComComboObject('cobLane', 1, 80 , 0 )</script></div></td>
									<th>Dir.</th>
									<td><script type="text/javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
									<th>IOC</th>
									<td><script type="text/javascript">ComComboObject('cobIOC', 1, 80 , 0 )</script></td>
								</tr>
							</tbody>
						</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width: 100%">
	
	    <div class="layout_vertical_2" style="width:64%">
			<div class="opus_design_grid">
				<table>
					<colgroup>
			            <col width="52">
			            <col width="181">
			            <col width="260">
			            <col width="*">
					</colgroup>
						<tbody>
							<tr>
								<th>Carrier</th>
								<td><script type="text/javascript">ComComboObject('cobCarrier', 1, 70 , 0 )</script></td>
								<td><input type="radio" value="007" class="trans" name="rdoCode"  id="rdoCode1" onClick="rdoCode_onClick('BSA');" checked><label for="rdoCode1"><b>BSA</b></label><!--  
									 --><!-- <input type="radio" value="015" class="trans" name="rdoCode" id="rdoCode2" onClick="rdoCode_onClick('Slot Price');"><label for="rdoCode2"><b>Slot Price</b></label>
									 --><input type="radio" value="016" class="trans" name="rdoCode" id="rdoCode3" onClick="rdoCode_onClick('Weight Limit');"><label for="rdoCode3"><b>Weight Limit</b></label>
								</td>
								<!-- opus_design_btn (S) -->
								<td>
									<div class="opus_design_btn" ><!-- 
									   --><button class="btn_normal" type="button" name="btn_skdinquiry" id="btn_skdinquiry">SKD Inquiry</button><!--
									   --><button class="btn_normal" type="button" name="btng_save1" id="btng_save1">Save</button><!--
									   --><button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
									</div>
								</td>
								<!-- opus_design_btn (E) -->
							</tr>
						</tbody>
					</table>
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
		</div>
		
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 2%">
			<div style="height:300px"></div>
		</div>
		<!-- layout_vertical_2(E) -->
		
	    <div class="layout_vertical_2" style="width:34%">
			<div class="opus_design_grid">
					<!-- opus_design_btn (S) -->
					<div class="opus_design_btn" >
						<table>
							<tr>
								<td><!-- 
									--><button class="btn_normal" type="button" name="btng_portadd" id="btng_portadd">Port Add</button><!--
									--><button class="btn_normal" type="button" name="btng_save" id="btng_save">Save</button><!--
									--><button class="btn_normal" type="button" name="btn_downexcel2" id="btn_downexcel2">Down Excel</button>
								</td>
								<td style="display:inline" ><!-- 
									--><button type="button" class="btn_down mar_left_4" id="btn_zoom_in" name="btn_zoom_in" title="Zoom In (+)"></button>
								</td>
							</tr>
						</table>
					</div>
					<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
		
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>