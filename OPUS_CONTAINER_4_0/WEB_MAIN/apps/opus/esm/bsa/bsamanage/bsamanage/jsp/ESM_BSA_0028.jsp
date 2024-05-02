<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_028.jsp
*@FileTitle  : Inquire/Edit Slot-Cost
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0028Event"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBsa0028Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";
	int rowCount	 = 0;						//count of DB resultSET list
	
	String	headSet = "";
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.BSAManage");
	
	int trdCnt = 0;
	List<SearchBsaCrrRgstListVO> list = null;
	SearchBsaCrrRgstListVO vo = null;
	
	//String bsa_op_jb_cd = "";
	//String bsa_op_jb_nm = "";
	//String crr_cd = "";
    StringBuffer bsa_op_jb_cd = new StringBuffer();				//SJH.20150507.소스품질      		
    StringBuffer bsa_op_jb_nm = new StringBuffer();
    StringBuffer crr_cd = new StringBuffer();
    
	String bsaOpJbCd = "";
	int head_cnt = 0;
    String xml = ""; 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0028Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else{
           // Extracting the data gotten from serve while initial loading ..
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        	CommonBsaRsVO commonVO = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));        	
        	list = (List<SearchBsaCrrRgstListVO>) commonVO.getResultVOList();
			headSet = commonVO.getStrTemp();
			rowCount = list.size();
			
	
			for(int j=0; j<rowCount; j++){
				vo = (SearchBsaCrrRgstListVO) list.get(j);
//				bsa_op_jb_cd = bsa_op_jb_cd + "|" + vo.getBsaOpJbCd();
//				if(vo.getBsaOpJbCd().equals("001")){
//					bsa_op_jb_nm = bsa_op_jb_nm + "|" + vo.getBsaOpJbNm();;
//				} else {
//					bsa_op_jb_nm = bsa_op_jb_nm + "|" + vo.getBsaOpJbNm();
//				}
//				crr_cd       = crr_cd       + "|" + vo.getCrrCd();
				
                bsa_op_jb_cd.append("|").append(vo.getBsaOpJbCd());			//SJH.20150507.소스품질 
                bsa_op_jb_nm.append("|").append(vo.getBsaOpJbNm());
                crr_cd.append("|").append(vo.getCrrCd());				
					
			}
        } // end else
        //추가----------------------------------------------------------------------------------------- END

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%-- = ibTrade --%>
<%--= crr_cd --%>
<%--= headSet--%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage("<%=bsa_op_jb_nm%>","<%=crr_cd%>","<%=headSet%>");
		document.form.txtSDate.focus();
	}
</script>

<!-- 2014.11.19 김용습 - iframe을 div로 감싸서 div의 display를 none으로 설정하지 않으면 타이틀 아래 불필요한 하얀 여백이 생겨서, 해당 작업합니다 -->
<div style="display:none">
	<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
</div>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="param1" id="param1" />
<input type="hidden" name="param2" id="param2" />
<input type="hidden" name="param3" id="param3" />
<input type="hidden" name="param4" id="param4" />
<input type="hidden" name="param5" id="param5" />
<input type="hidden" name="param6" id="param6" />
<input type="hidden" name="param7" id="param7" />
<input type="hidden" name="param8" id="param8" />

<input type="hidden" name="head_cnt"  id="head_cnt" value="<%=head_cnt%>" />
<input type="hidden" name="bsa_op_jb_cd" id="bsa_op_jb_cd"  value="<%=bsa_op_jb_cd%>" />
<input type="hidden" name="bsa_op_jb_nm" id="bsa_op_jb_nm" value="<%=bsa_op_jb_nm%>"  />
<input type="hidden" name="crr_cd"  id="crr_cd"  value="<%=crr_cd%>" />
<input type="hidden" name="header2" id="header2"  value="<%=headSet%>" />
<input type="hidden" name="trdCnt" id="trdCnt" value="<%=trdCnt%>" />
<input type="hidden" name="bsa_op_jb_cd_len"  id="bsa_op_jb_cd_len" value="" />
<input type="hidden" name="crr_cd_len"  id="crr_cd_len" value="" />
<input type="hidden" name="sXml"  id="sXml"  value="<%=xml%>"/>
<input type="hidden" name="excl_yn"  id="excl_yn" value="N" />	<!-- 20150515.ADD -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
	    --><button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_save" id="btn_save">Save</button><!--
		--><button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button class="btn_normal" type="button" name="btn_LoadExcel" id="btn_LoadExcel" style="display:none">Load Excel</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
				<col width="20">
				<col width="50">
				<col width="100">
				<col width="70">
				<col width="90">
				<col width="50">
				<col width="80">
				<col width="50">
				<col width="*">
			</colgroup>
			<tr>
				<th>From</th>
				<td><!-- 
					 --><input class="input1" type="text" dataformat="ymd" name="txtSDate" id="txtSDate" style="width:75px;text-align:center;ime-mode:disabled;" autocomplete="off" ><!--
					 --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>	
				</td>
				<th>(ETD of 1st Port)</th>
				<th>Trade</th>
				<td><script type="text/javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
				<th>Lane</th>
				<td><div id="div_rLane"><script type="text/javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></div></td>
				<th>Dir.</th>
				<td><script type="text/javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
			</tr>
		</table>
	</div>
	<table><tr><td colspan="9" class="line_bluedot"></td></tr></table>		
	<div class= "opus_design_inquiry wFit">	
		<table>
			<colgroup>
				<col width="670">
				<col width="*">
			</colgroup>
			<tr>
				<td><div id="div_ui_slot" style="float:left; font-weight: bold"></div></td>
				<td><strong>Carriers with BSA only&nbsp;</strong><input type="checkbox" name="isExcludZero" id="isExcludZero" value="1" class="trans"></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn" id="di_rowadd_btn">
					<table>
						<tr>
							<td id="td_rowadd_btn"><!-- 
							 --><button class="btn_normal" type="button" name="btng_rowadd" style="display:none" id="btng_rowadd">Row Add</button><!--
							 --><button class="btn_normal" type="button" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
							</td>
							<td><!-- 
							 --><button type="button" class="btn_up btn_down mar_left_4 mar_btm_4" id="div_zoom_in" name="div_zoom_in"  style="display:none"  title="Zoom In (+)"></button><!-- 
							 --><button type="button" class="btn_down btn_down mar_left_4 mar_btm_4" id="div_zoom_out"  name="div_zoom_out" title="Zoom out(-)" ></button>
							</td>
						</tr>
					</table>	
			</div>
			<!-- opus_design_btn (E) -->
			<table>
				<tr id="tr_opt" style="display:none" >
					<td><!-- 
						 --><input type="radio" name="rdoType2" id="rdoType2_1" value="0" class="trans" onClick="changeSheet(this.value);"  checked><label for="rdoType2">Long Leg</label><!-- 
						 --><input type="radio" name="rdoType2" id="rdoType2_2" value="1" class="trans" onClick="changeSheet(this.value);"><label for="rdoType2">Short Leg</label>
					</td>
				</tr>
			</table>
	</div>
	<div id="tr_slot" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
	<div id="tr_rf_l" style="display:none" >
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div id="tr_rf_s" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<div id="tr_over_l" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<div id="tr_over_s" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
	<div id="tr_op_slot" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet6');</script>
	</div>	
</div>
</form>