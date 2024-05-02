<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0228.jsp
*@FileTitle : e-Booking n SI Process
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.21 전용진
* 1.0 Creation
===============================================================================
 History
* 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
* 2010.10.01 변종건 [CHM-201006149] E-BOOKING & SI set search의 조회 옵션에 Lane 정보를 추가하여 해당 Lane의 VVD로 접수된 요청 사항을 조회
* 2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
* 2011.05.25~06.03 김진승 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청 - Check Split Detail 버튼 추가.
* 2012.01.07 이재위 [CHM-201221995] Split - Email 접수 Draft B/L Correction 분류 시스템 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0228Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg0228Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String StrRhq_ofc_cd	= "";
	String mrdSaveDialogDir = "";
	
	String isInquiry = "N";
	
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");

	String sXml = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		StrRhq_ofc_cd = account.getRhq_ofc_cd();
	   
		event = (EsmBkg0228Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);	
		
		
		String userHome = System.getProperty("user.home");
		String fileSep = System.getProperty("file.separator");
		
		if( userHome != null && fileSep != null ){
			mrdSaveDialogDir = userHome+fileSep;
		}
		
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		//inquiry mode
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & SI Process</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	var userOfc_cd = "<%=strOfc_cd%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onload="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdBodyTitle" value="e-Booking &amp; SI Preview">
<input type="hidden" name="com_zoomIn" value="3">
<input type="hidden" name="isInquiry" value="<%=isInquiry%>">
<!-- Reject용 변수	-->
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="rhq_ofc_cd" value = "<%=StrRhq_ofc_cd%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="vvd2" value="">
<input type="hidden" name="vsl_nm2" value="">
<input type="hidden" name="bkg_por_cd2" value="">
<input type="hidden" name="por_nm2" value="">
<input type="hidden" name="bkg_pol_cd2" value="">
<input type="hidden" name="pol_nm2" value="">
<input type="hidden" name="bkg_pod_cd2" value="">
<input type="hidden" name="pod_nm2" value="">
<input type="hidden" name="bkg_del_cd2" value="">
<input type="hidden" name="del_nm2" value="">
<input type="hidden" name="inttra_rtv" value="N">
<!-- 개발자 작업	-->
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=mrdSaveDialogDir%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_zoomIn">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr><td valign="top">
	
	
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="84">Request Date</td>
					<td width="230">
					  <input type="text" style="width: 80"  class="input1" name="rqst_from_dt" caption="Request DT" dataformat="ymd" tabindex="1">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width: 80"  class="input1" name="rqst_to_dt" caption="Request DT" dataformat="ymd" tabindex="2">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
					</td>
					<td width="210">VVD&nbsp;<input type="text" style="width: 80;" maxlength="9" dataformat="eng" class="input" name="vvd" value="" tabindex="3"></td>
					<td width="205">Booking Agent Code&nbsp;<input type="text" style="width: 25;" maxlength="2" dataformat="engup" class="input" name="chn_agn_cd" value="" tabindex="4"></td>
					<td width="38">Lane</td>
                    <td width="78"><input type="text" style="width: 60;ime-mode:disabled" class="input" dataformat="eng" name="lane" maxlength="3" value="" tabindex="5"></td>
					<td>Set Search&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name="btn_SRCH_SET" align="absmiddle">&nbsp;<input type="checkbox" value="Y" name="set_slct_flg" class="trans" tabindex="6"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="84">Request No.</td>
					<td width="230"><input type="text" style="width: 161;" style="ime-mode:disabled" dataformat="etc" caption="Request No." class="input" maxlength="25" name="xter_rqst_no" value="" tabindex="11">&nbsp;<input type="text" style="width: 22;" class="input" name="xter_rqst_seq" maxlength="2" dataformat="int" value="" tabindex="12"></td>
					<td width="210">Via&nbsp;
						<!--  %=HTMLUtil.getComboString("xter_rqst_via_cd", "width:150;", "", "","","All", xter_rqst_via_cd)% -->
						<script language="javascript">ComComboObject('xter_rqst_via_cd', 2, 147, 1, 0, 2);</script>
					</td>
					<td width="207">Doc Type&nbsp;
						<!-- %=getComboString("doc_tp_cd", "width:110;", "", "","","All", doc_tp_cd)%-->
						<script language="javascript">ComComboObject('doc_tp_cd',2, 108, '');</script>
					</td>  
					<td width="38">Origin</td>
					<td width="78"><input type="text" style="width: 25;" maxlength="2" dataformat="engup" class="input" name="origin" value="" tabindex="15"></td>
					<td width="54">Delivery</td>
					<td width="">
						<!-- %=HTMLUtil.getComboString("delivery", "width:75;", "", "","","All", delivery)%-->
						<script language="javascript">ComComboObject('delivery',2, 60, '');</script>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
				<tr class="h23">
				<td width="84">Booking No.</td>
				<td width="230"><input type="text" style="width: 110;" dataformat="eng" maxlength="13" class="input" name="bkg_no" value="" tabindex="20"> 
					Split &nbsp;<input type="checkbox" value="Y" id="split_bkg_yn" name="split_bkg_yn" class="trans" tabindex="21"></td>
				<td width="100">Request Status</td>
					<td width="110">
						<!-- %=getComboString_RqstSts("xter_bkg_rqst_sts_cd", "width:73;", "", "","","All", xter_bkg_rqst_sts_cd)%-->
						<script language="javascript">ComComboObject('xter_bkg_rqst_sts_cd',2, 73, '');</script>
					</td>
					<td width="95">Handling Office</td>
					<td width="112"><input type="text" style="width: 75;" class="input" dataformat="engup" name="hndl_ofc_cd" maxlength="5" value="<%=strOfc_cd%>" tabindex="22"></td>
					<td width="38">POL</td>
					<td width="78"><input type="text" style="width: 60;" style="ime-mode:disabled" class="input" dataformat="uppernum" name="pol_cd" maxlength="5" value="" tabindex="23"></td>
					<td width="52">POD</td>
					<td width=""><input type="text" style="width: 60;" style="ime-mode:disabled" class="input" dataformat="uppernum" name="pod_cd" maxlength="5" value="" tabindex="24"></td>
				</tr>
					</table>
				<table class="search" border="0" style="width: 979;"> 
				<tr class="h23">
					<td width="84">P/O No.</td>
					<td width="230"><input type="text" style="width: 161;" class="input" dataformat="etc" maxlength="30" name="po_no" value="" tabindex="30"></td>
					<td width="100">Upload Status</td>
					<td width="110">
						<!-- %=HTMLUtil.getComboString("bkg_upld_sts_cd", "width:73;", "", "","","All", bkg_upld_sts_cd)%-->
						<script language="javascript">ComComboObject('bkg_upld_sts_cd',2, 73, '');</script>
					</td>
					<td width="95">Upload Office</td>
					<td width="112"><input type="text" style="width: 76;" class="input" name="ofc_cd" maxlength="5" dataformat="eng" value="" tabindex="32"></td>
					<td width="38">POR</td>
					<td width="78"><input type="text" style="width: 60;" class="input" dataformat="engupnum" name="por_cd" maxlength="5" value="" tabindex="33"></td>
					<td width="52">DEL</td>
					<td width=""><input type="text" style="width: 60;"  style="ime-mode:disabled" class="input" dataformat="uppernum" name="del_cd" maxlength="5" value="" tabindex="34"></td>
				</tr>	
				</table>
				<table class="search" border="0" style="width: 979;"> 
				<tr class="h23">
					<td width="84">Customer</td>
					<td width="230"><select name="bkg_cust_tp_cd" style="width:57;">
						<option value="S" selected>SH</option>
						<option value="F">FF</option>
						<option value="C">CN</option>
						</select>
						<input type="text" style="width:25;" class="input" dataformat="engup" maxlength="2" name="cust_cnt_cd" value="" tabindex="41">
						<input type="text" style="width:55;" class="input" dataformat="int" maxlength="6" name="cust_seq" value=""  tabindex="42">
						<input type="text" style="width:75;" class="input" dataformat="etc" maxlength="200" name="cust_nm" value="" tabindex="43">
					</td>
					<td width="100">Web Auto<br>
					<td width="110">
						<input type="checkbox" value="Y" id="sys_upld_flg " name="sys_upld_flg" class="trans" tabindex="31" onclick="javascript:sysUploadFlg_onClick(this);"></td>
					</td>
					<td width="45">EDI ID</td>
					<td width="162"><input type="text" style="width: 126;" class="input" dataformat="etc" name="xter_sndr_id" value="" tabindex="45"></td>
					<td width="*">E-mail&nbsp;<input type="text" style="width: 190;" class="input" name="cntc_eml" value="" tabindex="46"></td></tr>
				</tr>	
				</table>
				<table class="search" border="0" style="width: 979;"> 
				<tr class="h23">
					<td width="84">F/O Status</td>
					<td width="80">
						<select id="bl_fnt_ofc_yn" name="bl_fnt_ofc_yn" style="width:70;">
						<option value="" selected>ALL</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select>
					</td>
					<td width="75">No Rate STS</td>
					<td width="72" style="padding-left:2">
					  <select style="width:68;" name="non_rt_sts_cd">
						<option value="" selected>All</option>
						<option value="F">Firm</option>
						<option value="R">No Rate</option>
					   </select>
					 </td>
					<td width="100">Web S/I Audit</td>
					<td width="110">
						<select id="si_aud_flg" name="si_aud_flg" style="width:70;">
						<option value="" selected>ALL</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select>
					</td>
					<td width="45">VGM </td>
					<td width="160">
						<select id="vgm_flg" name="vgm_flg" style="width:70;">
						<option value="" selected>ALL</option>
						<option value="Y">Y</option>
						<option value="I">I</option>
						<option value="N">N</option>
						</select>
					</td>
					<td width="*">&nbsp;Portal Ctrct&nbsp;<input type="checkbox" value="Y" name="portal_ctrct_flg" class="trans" onclick="javascript:portalCtrctFlg_onClick(this);"></td>
					 </tr>
				</table>
				
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
			<!-- Grid (E) -->
			

			<!--  Button_Sub (S) -->
			<table width="100%" class="button" id="buttonLayer"> 
	       	<tr>
	       	<td class="btn2_bg" style="text-align:left;">
	       		<table border="0" cellpadding="0" cellspacing="0">
	       			<tr>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_preview">Preview</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_previewprint">Multi&nbsp;Print</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_bkg_no_save">BKG No Save</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_check_split_detail">Check Split Detail</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
					</tr>
				</table>
	       	</td>
	       	<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_hold" id="btn_hold">&nbsp;Hold&nbsp;</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_upload" id="btn_upload">Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_reject">Reject</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_pending">Pending</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
  					</tr>			
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr id="btn_retrieve_inttra1"><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve_inttra" id="btn_retrieve_inttra">Inttra Reject Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr id="btn_reject_inttra1"><td class="btn1_left"></td>
					<td class="btn1" name="btn_reject_inttra" id="btn_reject_inttra">Inttra Multi Reject</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_exceldown">Down Excel</td>
						<td class="btn1_right"></td>
						</tr>
						</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
	</td></tr>
</table>
<!-- <div id="msg" style="position:absolute;left:0;top:0;width:0;height:0;"></div> -->
</form>
</body>
</html>
<!-- 
<script language="javascript" for="sheet1" event="OnMouseMove(Button, Shift, X, Y)">
  Row = MouseRow;
  Col = MouseCol;
  if (Col == 36) {
	  sText = CellText(Row,"upld_usr_nm");
	  MouseToolTipText = sText
	  MousePointer = "Hand";
	  window.status = MousePointer;
  }
</script> 
-->
<%!
    public String getComboString(String name, String style, String css, String script, String selectedValue, String firstOption, List<BkgComboVO> comboList){
        StringBuffer html = new StringBuffer("");
        int len = comboList==null ? 0 : comboList.size();
        html.append("<select name=\""+name+"\" style=\""+style+"\"" + ((css==null || css.equals(""))? "" : " class=\""+css+"\"") + "" + ((script==null || script.equals(""))? "" : " onChange=\""+script+"()\"") + ">\n");
        html.append("<option value=\""+firstOption+"\" "+((firstOption.equals(selectedValue))? "selected" : "")+">"+firstOption+"</option>\n");
        for(int i=0;i<len;i++){
            BkgComboVO vo = comboList.get(i);
		if ( "B".equals(vo.getVal()) || "S".equals(vo.getVal()) || "U".equals(vo.getVal()) ) {
	            html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getName()+"</option>\n");
		}
        }
        html.append("</select>\n");
        return html.toString();
    }

    public String getComboString_RqstSts(String name, String style, String css, String script, String selectedValue, String firstOption, List<BkgComboVO> comboList){
        StringBuffer html = new StringBuffer("");
        int len = comboList==null ? 0 : comboList.size();
        html.append("<select name=\""+name+"\" style=\""+style+"\"" + ((css==null || css.equals(""))? "" : " class=\""+css+"\"") + "" + ((script==null || script.equals(""))? "" : " onChange=\""+script+"()\"") + ">\n");
        html.append("<option value=\""+firstOption+"\" "+((firstOption.equals(selectedValue))? "selected" : "")+">"+firstOption+"</option>\n");
        for(int i=0;i<len;i++){
            BkgComboVO vo = comboList.get(i);
		if ( !"T".equals(vo.getVal()) ) {
	            html.append("<option value=\""+vo.getVal()+"\" "+((vo.getVal().equals(selectedValue))? "selected" : "")+">"+vo.getName()+"</option>\n");
		}
        }
        html.append("</select>\n");
        return html.toString();
    }
%>