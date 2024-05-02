<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0162.jsp
*@FileTitle  : Inquire/Edit Over Used Slot Price
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>

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
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0162Event"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO"%>
<%@ page import="com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0162Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.BSAManage");

	//String bsa_op_jb_cd = "";
	//String bsa_op_jb_nm = "";
	//String crr_cd = "";
    StringBuffer bsa_op_jb_cd = new StringBuffer();				//SJH.20150507.소스품질      		
    StringBuffer bsa_op_jb_nm = new StringBuffer();
    StringBuffer crr_cd = new StringBuffer();
    
	int head_cnt = 0;
	List<SearchBsaCrrRgstListVO> list = null;	
	SearchBsaCrrRgstListVO vo = null;
    String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0162Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    	CommonBsaRsVO rtnVo = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));

		list = rtnVo.getResultVOList();
		rowCount = list.size();

		for(int j=0; j<rowCount; j++){
			vo = list.get(j);
//			bsa_op_jb_cd = bsa_op_jb_cd + "|" + vo.getBsaOpJbCd();
			bsa_op_jb_cd.append("|").append(vo.getBsaOpJbCd());			//SJH.20150507.소스품질 
			if(vo.getBsaOpJbCd().equals("001")){
//				bsa_op_jb_nm = bsa_op_jb_nm + "|Initial Slots";
				bsa_op_jb_nm.append("|Initial Slots");					//SJH.20150507.소스품질 
			} else {
//				bsa_op_jb_nm = bsa_op_jb_nm + "|" + vo.getBsaOpJbNm();
				bsa_op_jb_nm.append("|").append(vo.getBsaOpJbNm());		//SJH.20150507.소스품질 
			}
//			crr_cd       = crr_cd       + "|" + vo.getCrrCd();
            crr_cd.append("|").append(vo.getCrrCd());					//SJH.20150507.소스품질 
            
			head_cnt++;

		} //end of for

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");

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
		loadPage("<%=bsa_op_jb_nm%>","<%=crr_cd%>");
		document.form.txtSDate.focus();
	}
</script>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">

<!-- 2014.11.19 김용습 - iframe을 div로 감싸서 div의 display를 none으로 설정하지 않으면 타이틀 아래 불필요한 하얀 여백이 생겨서, 해당 작업합니다 -->
<div style="display:none">
	<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
</div>

<form method="post" name="form">
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

<input type="hidden" name="head_cnt" value="<%=head_cnt%>" id="head_cnt" />
<input type="hidden" name="bsa_op_jb_cd" value="<%=bsa_op_jb_cd%>" id="bsa_op_jb_cd" />
<input type="hidden" name="bsa_op_jb_nm" value="<%=bsa_op_jb_nm%>" id="bsa_op_jb_nm" />
<input type="hidden" name="crr_cd" value="<%=crr_cd%>" id="crr_cd" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
	  --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>			
			<colgroup>
				<col width="54" />
				<col width="100" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
			<tr>
				<th>From</th>
				<td>
					<!-- <input class="input1" type="text" dataformat="ymd" name="txtSDate" style="width:75;text-align:center;ime-mode:disabled;" maxlength="8" onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"  OnBeforeDeactivate="ComAddSeparator(this);"  OnBeforeActivate="ComClearSeparator(this);" /> -->
					<input class="input1" type="text" dataformat="ymd" name="txtSDate" style="width:75px;text-align:center;ime-mode:disabled;" maxlength="8" autocomplete="off" /><!-- 
					 --><button type="button" name="btns_calendar1" id="btns_calendar1" class="calendar ir"></button>
				</td>
				<td><strong>(ETD of 1st Port)</strong></td>
				<td></td>
			</tr>
			</tbody>
		</table>
	</div>
	<table><tr><td class="line_bluedot"></td></tr></table>
	<div class= "opus_design_inquiry wFit">			
		<table>
			
			<colgroup>
				<col width="54" />
				<col width="70" />
				<col width="50" />
				<col width="70" />
				<col width="50" />
				<col width="120" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
		
					<th>Lane</th>
					<td><div id="div_rLane"><script type="text/javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></div></td>
		
					<th>Dir.</th>
					<td><script type="text/javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
					<td>
						<lable for="isExcludZero"><strong>Carriers with BSA only</strong></lable>&nbsp;<input type="checkbox" name="isExcludZero" id="isExcludZero" value="1" class="trans">
					</td>
		
				</tr>
			</tbody>
		</table>
		
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class= "opus_design_inquiry">
				<table>
					<tbody>
						<tr>
							<td>
								<!-- 2014.12.26 김용습 - 컬럼 이동 라디오 버튼 구현 -->
								<div>
								<b>
								<input type="radio" name="rdoType1" id="rdoType1" value="001" class="trans"checked OnClick="moveToCharterIn()"/>&nbsp; Charter In &nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoType1" id="rdoType1" value="002" class="trans" OnClick="moveToBasicSlots()"/>&nbsp; Initial Slots &nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoType1" id="rdoType1" value="002" class="trans" OnClick="moveToBasicLeased()"/>&nbsp; Basic Leased &nbsp;&nbsp;&nbsp;
								<input type="radio" name="rdoType1" id="rdoType1" value="002" class="trans" OnClick="moveToAdditionalLeased()"/>&nbsp; Additional Leased &nbsp;&nbsp;&nbsp;			
								</b>					
					    		</div>
							</td>
							<td>
								<div class="opus_design_btn">
							    	<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
							 		--><button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button><!-- 
							 	 	 --><div id="div_zoom_in" name="div_zoom_in" style="display:inline">
							 	 		<button type="button" class="btn_down" id="bu_zoom_in" name="bu_zoom_in" title="Zoom In (+)" style="margin-left:5px"></button>
							 	 	</div><!-- 
							 		--><div id="div_zoom_out" name="div_zoom_out" style="display:none">
							 			<button type="button" class="btn_up" id="bu_zoom_out" name="bu_zoom_out" title="Zoom out(-)" style="margin-left:5px"></button>
							 		</div>
					 			</div>
							</td>
							
								
						</tr>	
					</tbody>
				</table>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		
<!--  <b><font color='#454545'>* Charter In =  </font><br>
	<font color='#050099'>* Joint Operating Carrier's Slot Price =  </font><br>
	<font color='#8041D9'>* Basic Leased =  </font><br>
	<font color='#99004C'>* Additional Leased =  </font><br></b> -->
	
		</div>
	<!-- opus_design_grid(E) -->
</div>
</form>



<script type="text/javascript">
<!--
	with(document.form) {
		//Setting initial value
		//if (txtSDate.value == "") { txtSDate.value = getCurrDate("-"); } /* current data  */
	}
-->
</script>