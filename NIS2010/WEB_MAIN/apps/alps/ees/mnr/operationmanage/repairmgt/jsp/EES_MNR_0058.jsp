<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0058.jsp
*@FileTitle : M&R Extra Expense W/O Creation
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.06.03
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.26 정영훈   
* 1.0 Creation    
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0058Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0058Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
	        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
		
		event = (EesMnr0058Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	    	   
	}catch(Exception e) {   
		out.println(e.toString());
	}
%>
<html>
<head>
<title>M&R Extra Expense W/O Creation</title>   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var selectOfc  = "<% out.print(currOfcCd + "|" + currOfcEngNm); %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	
</script>
</head>
    
<body  onLoad="setupPage();">
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_gubuns">
<input type="hidden" name="mnr_grp_tp_cd" value="RPR">
<input type="hidden" name="mnr_wo_tp_cd" value="EXT">

<input type="hidden" name="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">
<input type="hidden" name="file_seq" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
	
		
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_W/O_Creation">W/O Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_W/O_Send">W/O Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="104">W/O No.</td> 
					<td width="235">&nbsp;<input required type="text" style="width:90;" class="input1" value="" name="mnr_ord_seq" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_WONo"></td>
					<td width="95"></td>
					<td width="233"></td>
					<td width="110">Date</td>
					<td width=""><input type="text" style="width:75;" class="input2" value="" name="showDate" readonly></td>
				</tr> 
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="105">Agreement No.</td>
					<td width="270">&nbsp;<script language="javascript">ComComboObject('combo_vndr_seq',12, 250, 1, 1,2,false,1);</script>
					<input type="hidden" name="vndr_seq">
					</td>	
					<td width="60">EQ Type</td>
					<td width="233">&nbsp;<script language="javascript">ComComboObject('combo_eq_knd_cd',6, 80, 1, 1,1,false,1);</script>
					<input type="hidden" name="eq_knd_cd">
					</td>
					<td width="110">Cost CTRL Office</td>
					<td align=""><input type="text" style="width:75;text-align:center;" class="input2" value="" name="cost_ofc_cd"></td></tr> 
				<tr class="h23">
					<td>Service Provider</td>
					<td width="270">&nbsp;<input type="text" style="width:250;" class="input2" value="" name="pic_eng_nm" readonly></td>
					<td>Effective</td>
					<td>&nbsp;<input type="text" style="width:80;" class="input2" value="" name="eff_dt"  readonly> ~ 
					<input type="text" style="width:80;" class="input2" value="" name="exp_dt"  readonly></td>
					<td>Currency</td>
					<td><input type="text" style="width:75;text-align:center;" class="input2" value="" name="curr_cd"></td>
				</tr>
				</table>
				<!--  biz   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="105">Cost Type</td><!-- ComComboObject('combo4',1, 100 , 1,1)-->
					<td>&nbsp;<script language="javascript">ComComboObject('combo_cost_cd',2, 250 , 1, 1,2,false,1);</script>
					<input type="hidden" name="cost_cd">
					</td>
				</tr> 
				</table>
					<!-- Grid-1  (S) -->
					<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>	
					</table> 
					<!-- Grid-1 (E) -->	

					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
						
							<!-- 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [S] -->
							<td align="left" id="UploadExcelFormfile">
								<span id="extraWOForm" style="display:block;">
									<a href="/hanjin/apps/alps/ees/mnr/mnrcommon/attachfile/ExtraWOForm.xls" target="_blank">Extra W/O Form</a>&nbsp;&nbsp;&nbsp;
								</span>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_loadExcel">Load Excel </td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<!-- 2014.12.02 Chang Young Kim [CHM-201432567] Extra W/O, Hanger Rack/Bar Installation/ Removal 생성 시 Load Excel 기능 추가 요청 [E] -->
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowDel">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_excelDown">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
					
			
		
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			<!-- Expense for / Evidence attached (S) -->
			<table class="search" width="979">
			<tr><td width="680" style="padding-right:20" valign="top">
			
					<table border="0" style="width:100%; background-color:white;" class="grid2"> 
					<tr class="tr2_head">
						<td>Expense For</td></tr>
					<tr><td><textarea name="ord_hdr_rmk"  style="ime-mode:disabled" style="width:100%; height:96;" maxlength="4000">Pls supply the parts to the vsl today.</textarea></td></tr>
					</table>				
			
				</td>
				<td width="279" valign="top">
					
					<!-- Grid - Evidence Attached (S) -->
					<table border="0" style="width:100%; background-color:white;">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script></td>
					</tr>
					</table>
					<!-- Grid - Evidence Attached (E) -->
					

					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_File_Add">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_File_Del">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
				
				</td></tr>
			</table>	
			<!-- Expense for / Evidence attached (E) -->
			
		</td></tr>
		</table>		
		<!-- 2 (E) -->		
		
		<!--biz page (E)-->
		
		
	
	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
    <!-- Grid-1  (S) -->
	<table width="100%" id="hideTable">
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>	
	</table> 

<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
</form>			
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>