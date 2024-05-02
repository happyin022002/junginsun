<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FNS_JOO_0091.jsp
*@FileTitle : BSA Information Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.30
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.12.30 김영오
* 1.0 Creation
* 2013.09.02 이수진 [CHM-201326325][BSA Information Entry] 시스템 UI 개선 요청 건
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0091Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0091Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");
	String crrCdList = "";
	String trdCdList = "";
	String ofcCdList = "";
	String joSrcList = "";
	String joSrcNmList = "";
	String joBkgTpList = "";
	String joBkgTpNmList = "";
	String trdLaneCrrList = "";
	String direction = "";
	String strToyyyyMMdd = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsJoo0091Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		crrCdList      = eventResponse.getETCData("CRR_CD_LIST");
		trdCdList      = eventResponse.getETCData("TRD_CD_LIST");
		ofcCdList	   = eventResponse.getETCData("OFC_CD");
		joSrcList      = eventResponse.getETCData("JO_SRC_CD");
		joSrcNmList    = eventResponse.getETCData("JO_SRC_NM");
		joBkgTpList    = eventResponse.getETCData("JO_BKG_TP_CD");
		joBkgTpNmList  = eventResponse.getETCData("JO_BKG_TP_NM");
		trdLaneCrrList = eventResponse.getETCData("TRD_LANE_CRR_LIST");
		strToyyyyMMdd = DateTime.getFormatDate(JSPUtil.getKST("yyyyMMdd"), "yyyyMMdd", "yyyy-MM-dd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Basic Information for Loading Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gUsrId = "<%=strUsr_id%>";
var gUsrNm = "<%=strUsr_nm%>";
var gCrrCd = "<%=crrCdList%>";
var gTrdCd = "<%=trdCdList%>";
var gOfcCd = "<%=ofcCdList%>";
var nJoSrcCd = "";
var gJoSrcCd = ("<%=joSrcList%>").split("|");
var gJoSrcNm = ("<%=joSrcNmList%>").split("|");
var gJoBkgTpCd = ("<%=joBkgTpList%>").split("|");
var gJoBkgTpNm = ("<%=joBkgTpNmList%>").split("|");
var gTrdLaneCrr = "<%=trdLaneCrrList%>";
//alert("<%=direction%>");
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="del_chk">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						
						<td width="40">Trade</td>
						<td align=""><script language="javascript">ComComboObject('trd_cd',1,55,0,0);</script></td>
						<td align="right">Lane</td>
						<td><script language="javascript">ComComboObject('rlane_cd',1,80,0,0);</script></td>
						<td align="right">Carrier</td>
						<td><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,0);</script></td>
						<td align="right">VVD</td>
	                    <td><input type="text" style="width:80" class="input" maxlength='9' value="" name="vvd_cd" dataformat="engup"></td>
						<td align="right">Direction</td>
						<td><script language="javascript">ComComboObject('skd_dir_cd', 1, 55, 0,0 );</script></td>
						<td align="right">YYYY-WW</td>
	                    <td>
	                    	<input type="text" name="fm_yr_wk" style="width:55;text-align:center" class="input"  fullfill maxlength="6"  value="" required>&nbsp;~&nbsp;<input type="text" name="to_yr_wk" style="width:55;text-align:center" class="input"  maxlength="6"  value="" required>
	                    </td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td align="right">Port</td>
	                    <td><input type="text" style="width:80" class="input" maxlength='5' value="" name="port_cd" dataformat="engup"></td>						
						<td align="right">RDR Finish</td>
	                    <td><script language="javascript">ComComboObject('jo_fsh_flg',1,55,0,0);</script></td>
	                    <td align="right">Price Finish</td>
	                    <td><script language="javascript">ComComboObject('jo_prc_flg',1,55,0,0);</script></td>
						<td align="right">Del</td>
						<td><script language="javascript">ComComboObject('delt_flg',1,55,0,0);</script></td>
						<td align="right">Rev/Exp</td>
						<td><script language="javascript">ComComboObject('re_divr_cd', 1, 55, 0,0 );</script></td>
						<td align="right">Revenue Port ETD</td>
	                    <td>
	                    	<input type="text" name="fm_etd_dt" style="width:75;text-align:center" class="input" caption="from etd date" requred dataformat="ymd" maxlength="8" cofield="to_etd_dt" value="" required>&nbsp;~&nbsp;<input type="text" name="to_etd_dt" style="width:75;text-align:center" class="input" caption="to etd date" requred dataformat="ymd" maxlength="8" cofield="fm_etd_dt" value="" required>&nbsp;<img src="img/btns_calendar.gif" name="etd_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
	                    </td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="40">Office</td>
						<td width="120"><script language="javascript">ComComboObject('ofc_cd', 1, 80, 0,0 );</script></td>
	                    <td width="100" align="right">Creation Date</td>
	                    <td width="230">
	                    	<input type="text" name="cre_dt_fr" style="width:75;text-align:center" class="input" caption="from date" requred dataformat="ymd" maxlength="8" cofield="cre_dt_to" value="" required>&nbsp;~&nbsp;<input type="text" name="cre_dt_to" style="width:75;text-align:center" class="input" caption="to date" requred dataformat="ymd" maxlength="8" cofield="cre_dt_fr" value="" required>&nbsp;<img src="img/btns_calendar.gif" name="cre_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
	                    </td>
	                    <td width="105">Add Carrier<input type="checkbox" value="Y" name="add_carrier" id="add_carrier" class="trans"></td>	                    
						<td width="100" align="right">Type to upload</td>
						<td width="100"><select name="upload_flg" style="width:70;" onChange="upload_flg_OnChange()">
							<option value="I" selected>New</option>							
							<option value="U">Update</option>							
							</select></td>
						<td width="65"></td>
	                    <td width="120"></td>							
					</tr>
				</table>
				<!--  biz_1   (E) -->
				
		  </td></tr>
		  </table>
		  <table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			<!-- Grid  (S) --> 
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%" id="sheet_main">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 	
			<!-- Grid (E) -->
	        <!-- Grid (S) -->	          
	          <div style="display:none">
	            <table width="100%"  id="mainTable">
	              <tr>
	                <td width="100%">
	                  <script language="javascript">ComSheetObject('sheet2');</script>
	                </td>
	              </tr>
	            </table>
	          </div>
	        <!-- Grid (E) -->
	        
	        <table width="100%"  id="mainTable">
                <tr>
                  <td width="100%" id="sheet_carrier" style="display:none">
                    <script language="javascript">ComSheetObject('sheet3');</script>
                  </td>
                </tr>
            </table>
	        
	        <!-- Grid (S) -->	          
	          <div style="display:none">
	            <table width="100%"  id="mainTable">
	              <tr>
	                <td width="100%">
	                  <script language="javascript">ComSheetObject('sheet4');</script>
	                </td>
	              </tr>
	            </table>
	          </div>
	        <!-- Grid (E) -->
	        
			</td></tr>
		</table>
		
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_carriers" name="btns_carriers" auth="C">Add Carriers</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td-->
						<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_copy" name="btns_copy" auth="C">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_add" name="btns_add" auth="C">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_insert" name="btns_insert" auth="C">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td-->
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_del" name="btns_del" auth="C">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<!--td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_loadExcel" name="btn_Format_DownExcel" auth="C">Format Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td-->
						<!--td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<!--tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_loadExcel" name="btn_loadExcel" auth="C">Load Excel</td>
						<td class="btn2_right"></td>
						</tr-->
						</table></td>
						</tr>
				</table>
			</td></tr>
			</table>
		
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_target_retrieve">Target Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_target_excel">Target Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_loadExcel">Load Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_history">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- Copyright (S) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html> 