<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1121.jsp
*@FileTitle : Europe Advanced Manifest  : EXS Download  & Transmit
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.07
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.06.07 박성진
* 1.0 Creation
*--------------------------------------------------------
* History
* 2012.09.04 김보배 [CHM-201220027] [BKG] [EXS 신고화면 및 레포트화면] Released 추가 (조회조건 Status/ Summary 합계)
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}

    
    /**
     * bl별 머지 되도록 처리하기 위해
     * CoObject.js에 있는 함수를 오버라이딩 한것임
     * MemoPad에서 Apply 버튼을 눌렀을때 이 함수를 호출하며, MemoPad의 값을 IBSheet의 특정셀로 설정한다. <br>
     * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌으나 수정함. <br>
     */
	function setMemoValue(sValue,iMax) {
		try {
			if(sValue.length > iMax){
				ComShowMessage("characters long");
				return;
			}else{
				if (memoSheet == null) return;
				//memoSheet.CellValue(memoRow, memoCol) = sValue;
				setSameBlUpdateReason(memoRow, memoCol,sValue);//--js파일에 있음
				ComHideMemoPad(true);
				
			}
        } catch(err) { ComFuncErrMsg(err.message); }
	}
	
</script>
</head>


<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="call_type" value="ESM_BKG_1121">
<input type="hidden" name="p_send_yn" value="">
<input type="hidden" name="search_eu_pol_cd" value=''>

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->	
	
	<!--biz page (S)-->
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				    <td width="240">
						<table class="search_sm2" border="0" style="width:210;"> 
						<tr class="stm">
				   	    <td width="90"><input type="radio" name="p_data_cd" value="BL" class="trans" checked>B/L Data</td>
						<td width=""><input type="radio" name="p_data_cd" value="DL"   class="trans">Download Data</td>
						</tr>	
						</table>
				    </td>
					<td width="170">
						<table class="search_sm2" border="0" style="width:150;"> 
						<tr class="stm">
				   	    <td width="60"><input type="radio" name="p_error_cd"  value="" class="trans" checked>All  </td>
						<td width=""><input type="radio" name="p_error_cd"    value="E" class="trans">Error  B/L</td>
						</tr>	
						</table>
				    </td>
					<td width="170">
						<table class="search_sm2" border="0" style="width:150;"> 
						<tr class="stm">
				   	    <td width="60"><input type="radio" name="p_ori_amd_cd"  value="O" class="trans" checked>Original  </td>
						<td width=""><input type="radio" name="p_ori_amd_cd"    value="A" class="trans">Amendment</td>
						</tr>	
						</table>
				    </td>
					<td width="65">BKG OFC</td>
					<td width="90"><input type="text" style="width:70;" class="input" name="p_b_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td>
					<td width="70">Sales OFC</td>
					<td width="90"><input type="text" style="width:70;" class="input"  name="p_s_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td>
					<td width="70">BKG Staff</td>
					<td width=""><input type="text" style="width:70;" class="input" name="p_b_staff" value=""  maxlength='20'  dataformat='' style="ime-mode:disabled"></td>
				</tr>	
				</table>
				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">&nbsp;&nbsp;VVD</td>
					<td width="90"><input type="text" style="width:80;" class="input1" name="p_vvd_cd" value=""  maxlength='9' dataformat='engupnum' style="ime-mode:disabled"></td>
					<td width="60">EU POL</td>
					<td width="110">
						<script language="javascript">ComComboObject('p_pol_cd_temp', 1, 100, '');</script>
						<input type="hidden" style="width:70;" class="input1" name="p_pol_cd" value="" maxlength='5' dataformat='engup' style="ime-mode:disabled" >
						<input type="hidden" style="width:30;" class="input" name="p_pol_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
					<td width="30">POD</td>  
					<td width="95"><input type="text" style="width:50;" class="input" name="p_pod_cd" value="" maxlength='5' dataformat='engup' style="ime-mode:disabled" >
					<input type="text" style="width:30;" class="input" name="p_pod_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
					<td width="50">&nbsp;&nbsp;BL/No</td>
					<td width="105"><input type="text" style="width:90;" class="input" name="p_bl_no" value=""  maxlength='12' dataformat='engupnum' style="ime-mode:disabled">
					<td width="100"></td>
					<td width="100"></td>
					<td width="100"></td>
					<td width=""></td>
					<!-- 
					<td width="30">L/T</td>
					<td width="75">
						<select style="width: 70;" name="p_lt">
							<option value="" selected>All</option>
							<option value="L">Local</option>
							<option value="T">T/S</option>
						</select>
					</td>										
					<td width="80">Ack. Status</td>
					<td width="">
						<select style="width: 120;" name="p_ack_status">
							<option value="" selected>All</option>
							<option value="A">Accepted</option>
							<option value="R">Rejected</option>
							<option value="DNL">Do Not Load</option>
							<option value="NR">Not Received</option>
							<option value="NA">N/A</option>
						</select>
					</td>		
					 -->								
				</tr>	
				</table>
				
			
				</td></tr>
			</table>
			<!--  biz_1   (E) -->
		
		<table class="height_8"><tr><td></td></tr></table>	
		
			<!--Grid (s)-->
	<table class="search"> 
       	<tr><td class="bg">
    		<table class="search" border="0" style="width:979;"> 
				<tr class="st">
				<td height="20" width="" id="div_option"></td>
				</tr>	
				</table>
							
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!--Grid (E)-->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="60"></td>
				<td width="90"></td>
				<td width="490" align='center'></td>
				<td width="20" align='center'></td>
				<td width="60" style="color:red">Error B/L</td>
				<td width="70"><input type="text" style="width:65;" value="" class="input2"  id="div_ttl_err" style='color:red'></td>
				<td width="100">Total Container</td>
				<td width=""><input type="text" style="width:70;" value="" class="input2"  id="div_ttl_cntr">
				 			 <input type="hidden" style="width:70;" name="port_ofc_cd" value="" ></td>
				</tr>	
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="60">Total B/L</td>
				<td width="50"><input type="text" style="width:50;" value="" class="input2" id="div_ttl_bl"></td>
				<td width="20" align='center'> = </td>
				<td width="60" >Sent B/L</td>
				<td width="50"><input type="text" style="width:50;" value="" class="input2"  name="div_sent_bl_cnt" readonly></td>
				<td width="20" align='center'> + </td>
				<td width="80" style='color:red'>Un-Sent B/L</td>
				<td width="50"><input type="text" style="width:50;" value="" class="input2"  name="div_unsent_bl_cnt" readonly style='color:red'></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				<td width=""></td>
				</tr>	
				<tr class="h23">
				<td width="60">Sent B/L</td>
				<td width="50"><input type="text" style="width:50;" value="" class="input2"  name="div_sent_bl_cnt2" readonly></td>
				<td width="20" align='center'> = </td>
				<td width="60" >Accepted</td>
				<td width="50"><input type="text" style="width:50;" value="" class="input2"  name="div_a_cnt" readonly></td>
				<td width="20" align='center'> + </td>
				<td width="60" style='color:red'>Rejected</td>
				<td width="50"><input type="text" style="width:50;" value="" class="input2"  name="div_r_cnt" readonly style='color:red'></td>
				<td width="20" align='center'> + </td>
				<td width="80" style='color:red'>Do Not Load</td>
				<td width="50"><input type="text" style="width:50;" value="" class="input2"  name="div_dnl_cnt" readonly style='color:red'></td>
				<td width="20" align='center'> + </td>
				<td width="40" style='color:red'>Hold</td>
				<td width="50"><input type="text" style="width:50;" value="" class="input2"  name="div_h_cnt" readonly style='color:red'></td>
				<td width="20" align='center'> + </td>
				<td width="60">Released</td>
				<td width="50"><input type="text" style="width:50;" value="" class="input2"  name="div_l_cnt" readonly></td>
				<td width="20" align='center'> + </td>
				<td width="82" style='color:red'>Not Received</td>
				<td width=""><input type="text" style="width:50;" value="" class="input2"  name="div_nr_cnt" readonly style='color:red'></td>
				</tr>	
				</table>				
			</td></tr>
		</table>		
	<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;,padding-left:5;"> 
       	<tr><td class="">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel
					</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
		</td>
		<td class="">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_EDIDownload">Data Download</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BLAdd">B/L Add</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BLDelete">B/L Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Inquiry">B/L Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Transmit">EDI Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				 
			</tr>
			</table>
		</td></tr>
		</table>
		
		</td></tr>
		</table>
    <!--Button (E) -->	
<table width="100%" class='search'>
	<tr>
		<td width="100%"> * EORI No Validation : <a target='_blank' href="http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp" target="_blank">http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp  </a>	</td>
	</tr>
	<tr>
		<td width="100%"> * HS Code Validation : <a target='_blank' href="http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en" target="_blank">http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en  </a>	</td>
		
	</tr>
</table>

	</td></tr>
 </table>

</form>
<table width="100%" id="mainTable" style="display:none">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
	</tr>
</table>
<table width="100%" id="mainTable" style="display:none">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script></td>
	</tr>
</table>
</body>
</html>
