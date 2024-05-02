
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0030.jsp
*@FileTitle  : Inquire/Edit Supply & Slot-swap By VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event.EsmBsa0030Event"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchOpJobCarrierListVO"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBsa0030Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.SPCManage");
	
	String tmp = "";
	String prevWeek = "";
	String crrCD = "";
	String saveNM = "";			// sheet? save name    
	String crr_cnt = "";	    // Number of crr_cd in op_job_cd
	List<SearchOpJobCarrierListVO> list = null;	
	SearchOpJobCarrierListVO vo = null;
    String xml = "";
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    	CommonBsaRsVO commonVO = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));
    	prevWeek =eventResponse.getETCData("prevWk");
    	
		list = commonVO.getResultVOList();
		rowCount = list.size();
		int cnt = 0;
	    StringBuffer sb1 = new StringBuffer();										//SJH.20150507.소스품질      		
	    StringBuffer sb2 = new StringBuffer();
	    // Handling for items of header in sheet 
	    //---------------------------------------------------------------------------------
	    if(rowCount>0){																	//20150615.ADD : 데이타 없는 경우..
	    	for(int j=0; j<rowCount; j++){
				vo = list.get(j);
				//saveNM = saveNM + vo.getCrrCd() + vo.getBsaOpJbCd() + "|";
				//crrCD = crrCD + vo.getCrrCd() + "|";
				sb1.append(vo.getCrrCd()).append(vo.getBsaOpJbCd()).append("|");		//SJH.20150507.소스품질 
				sb2.append(vo.getCrrCd()).append("|");									//SJH.20150507.소스품질 
				if(tmp.equals("") || vo.getBsaOpJbCd().equals(tmp)){
					cnt++;
				} else {
					crr_cnt = crr_cnt + cnt +"|";
					cnt = 1;
				}
				tmp = vo.getBsaOpJbCd();
			}
			crr_cnt = crr_cnt + cnt ;
			saveNM = sb1.toString();													//SJH.20150507.소스품질 
			saveNM = saveNM.substring(0, saveNM.length()-1);
			crrCD = sb2.toString();														//SJH.20150507.소스품질 
			crrCD = crrCD.substring(0, crrCD.length()-1);
	    }
		
		
		log.debug("crr_cnt   : " + crr_cnt);
		log.debug("crrCD     : " + crrCD);
		log.debug("saveNM    : " + saveNM);
				
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
	   
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var formObj = document.form;
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		
        document.form.txtYear.focus();		
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
	<iframe height="0" width="0" name="frmHidden"></iframe>
</div>

<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd" id="f_cmd" /> <input type="hidden"
		name="pagerows" id="pagerows" /> <input type="hidden" name="flag"
		id="flag" /> <input type="hidden" name="reset_flag" id="reset_flag" />
	<input type="hidden" name="header" id="header" value="<%= saveNM %>">
	<input type="hidden" name="param1" id="param1">
	<!-- Gubun   |   Methode Name   | codeItem     -->
	<input type="hidden" name="param2" id="param2">
	<!-- Year    |   vsl_cd         | All /        -->
	<input type="hidden" name="param3" id="param3">
	<!--         |   skd_voy_no     | Methode Name -->
	<input type="hidden" name="param4" id="param4">
	<!--         |   dir_cd         | trd_cd       -->
	<input type="hidden" name="param5" id="param5">
	<!-- fmMonth |                  |              -->
	<input type="hidden" name="param6" id="param6">
	<!-- toMonth |                  |              -->
	<input type="hidden" name="param7" id="param7">
	<!-- fmWeek  |                  |              -->
	<input type="hidden" name="param8" id="param8">
	<!-- toWeek  |                  |              -->

	<input type="hidden" name="crr_cnt" id="crr_cnt" value="<%= crr_cnt%>">
	<input type="hidden" name="crr_cd" id="crr_cd" value="<%= crrCD %>">
	<input type="hidden" name="saveNM" id="saveNM" value="<%= saveNM %>">
	<input type="hidden" name="hValue" id="hValue"> <input
		type="hidden" name="sXml" id="sXml" value="<%=xml%>">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	     --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->

	<!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<!--  MiniLayer (S) -->
			<div>
				<table>
					<tbody>
						<colgroup>
							<col width="610">
							<col width="150">
							<col width="75">
							<col width="30">
							<col width="*">
						</colgroup>
						<tr>
							<td><script type="text/javascript">initPeriod();</script></td>
							<td></td>
							<th><label for="isExcludZero">Carriers with BSA only</label></th>
							<td><input type="checkbox" name="isExcludZero" id="isExcludZero" value="1" class="trans"></td>
							<td></td>
						</tr>
					</tbody>
				</table>
					</div>
					</div>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<tr>
						<th width="30">Trade</th>
						<td width="80"><script type="text/javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
						<th width="35">&nbsp;</th>
						<th width="40">Lane</th>
						<td width="80"><script type="text/javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></td>
						<th width="35">&nbsp;</th>
						<th width="60">Direction</th>
						<td width="80"><script type="text/javascript">ComComboObject('cobDir', 1, 70 , 0 )</script>	</td>
						<th width="35">&nbsp;</th>
						<th width="40">IOC</th>
						<td width="80"><script type="text/javascript">ComComboObject('cobIOC', 1, 70 , 0 )</script>	</td>
						<th width="55">&nbsp;</th>
						<th width="40">VVD</th>
						<td><input type="text" size="4" name="txtVsl_cd" id="txtVsl_cd"	maxlength="4" dataformat="engup" onKeyUp="moveTab(this, txtSkd_voy_no);" style="ime-mode: disabled; width: 65px;"><!-- 
							--><input type="text" size="4" name="txtSkd_voy_no" id="txtSkd_voy_no" maxlength="4" dataformat="num" onKeyUp="moveTab(this, txtDir_cd);"style="ime-mode: disabled; width: 65px;"><!-- 
							--><input type="text" size="1" name="txtDir_cd" id="txtDir_cd" maxlength="1" dataformat="enguponly" onBlur="chkVVD();" style="ime-mode: disabled; width: 30px;">
						</td>
					</tr>
				</tbody>
			</table>
	</div>
	</div>
	<!-- opus_design_inquiry(E) -->

	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div id="div_gubun" style="float:left; font-weight: bold"></div>
			<div class="grid_option_right">
		        <div class="opus_design_btn">
		             <div id="div_zoom_in" style="display: none"><button type="button" class="btn_up mar_left_4" name="bu_zoom_in" id="bu_zoom_in" title="Zoom in(+)"></button></div>
		         	<div id="div_zoom_out"><button type="button" class="btn_down mar_left_4" name="bu_zoom_out" id="bu_zoom_out" title="Zoom out(-)"></button></div>
		        </div>
   			</div>  

			<div id="RadioLayer0">
				<div class="opus_design_btn">
					<table>
						<tr>
							<td>
								<button class="btn_normal" type="button" id="btng_creation" name="btng_creation">Creation</button><!--
							 --><button class="btn_normal" type="button" id="btn_skdinquiry0" name="btn_skdinquiry0">SKD Inquiry</button><!--
							 --><button class="btn_normal" type="button" id="btng_reset0" name="btng_reset0">Reset</button></td>
						</tr>
					</table>
				</div>
				<!-- opus_design_btn (E) -->

				<div id="mainTable1">
					<script type="text/javascript">ComSheetObject('sheet0');</script>
				</div>
<!-- 				<div>
					* Basic Slots = Basic slot allocation among joint operating
					carriers <br> * Basic Lease = Slots leased by Company to other
					carriers <br> * Basic Chartered = Slots chartered by Company
					from other carriers <br> * Additional Lease = Additional slots
					leased by Company to other carriers <br> * Additional
					Chartered = Additional slots chartered by Company from other
					carriers
				</div> -->
			</div>
			<!-- opus_design_grid(E) -->

			<div id="RadioLayer1" style="display:none">
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<table>
						<tr>
							<td>
								<button class="btn_normal" type="button" id="btn_skdinquiry1" name="btn_skdinquiry1">SKD Inquiry</button><!--  
								--><button class="btn_normal" type="button" id="btng_reset1" name="btng_reset1">Reset</button>
							</td>
						</tr>
					</table>
					<!-- opus_design_btn (S) -->
				</div>
				<div id="mainTable2">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
<!-- 				<div>
					* Basic Slots = Basic slot allocation among joint operating
					carriers <br> * Basic Lease = Slots leased by Company to other
					carriers <br> * Basic Chartered = Slots chartered by Company
					from other carriers <br> * Additional Lease = Additional slots
					leased by Company to other carriers <br> * Additional
					Chartered = Additional slots chartered by Company from other
					carriers
				</div> -->
			</div>

			<div id="RadioLayer2" style="display:none">
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<table>
						<tr>
							<td>
								<button class="btn_normal" type="button" id="btn_skdinquiry2" name="btn_skdinquiry2">SKD Inquiry</button><!--  
								--><button class="btn_normal" type="button" id="btng_reset2" name="btng_reset2">Reset</button>
							</td>
						</tr>
					</table>
				</div>
				<!-- opus_design_btn (E) -->
				<div id="mainTable1">
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>
<!-- 				<div>
					* Basic Slots = Basic slot allocation among joint operating
					carriers <br> * Basic Lease = Slots leased by Company to other
					carriers <br> * Basic Chartered = Slots chartered by Company
					from other carriers <br> * Additional Lease = Additional slots
					leased by Company to other carriers <br> * Additional
					Chartered = Additional slots chartered by Company from other
					carriers
				</div> -->
			</div>

			<div id="RadioLayer3" style="display:none">
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<table>
						<tr>
							<td>
								<button class="btn_normal" type="button" id="btn_skdinquiry3" name="btn_skdinquiry3">SKD Inquiry</button><!--  
								--><button class="btn_normal" type="button" id="btng_reset3" name="btng_reset3">Reset</button>
							</td>
						</tr>
					</table>
				</div>
				<!-- opus_design_btn (E) -->
				<div id="mainTable4">
					<script type="text/javascript">ComSheetObject('sheet3');</script>
				</div>
				<!-- <div>
					* Basic Slots = Basic slot allocation among joint operating
					carriers <br> * Basic Lease = Slots leased by Company to other
					carriers <br> * Basic Chartered = Slots chartered by Company
					from other carriers <br> * Additional Lease = Additional slots
					leased by Company to other carriers <br> * Additional
					Chartered = Additional slots chartered by Company from other
					carriers
				</div> -->
				
			</div>
		</div>
	</div>
	<!-- wrap_result(E) -->
	
	
</form>
