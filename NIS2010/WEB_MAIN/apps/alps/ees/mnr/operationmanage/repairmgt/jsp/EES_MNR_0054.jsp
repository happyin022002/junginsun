<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0054.jsp
*@FileTitle : M&R Reefer Spare Part Purchase W/O Creation
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.08.05
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.08.05 권영법   
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0054Event" %>
<%@ page import="org.apache.log4j.Logger" %>



<%

	EesMnr0054Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
		
		event = (EesMnr0054Event)request.getAttribute("Event"); 
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
<title>M&R Vessel Reefer Spare Part Purchase W/O Creation</title>   
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
<input type="hidden" name="mnr_wo_tp_cd" value="RFS">
<input type="hidden" name="spr_prt_no" value="">
<input type="hidden" name="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">
<input type="hidden" name="sel_type" value="S">
<input type="hidden" name="cost_cd" value="MRRUSP">

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
					<td class="btn1" name="btn_save">Delete</td>
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
					<td width="105">W/O No.</td>
					<td width="760">&nbsp;<input type="text" style="width:90;" class="input1" value="" name="mnr_ord_seq"  required dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_WONo"></td>
					<td width="40">Date</td>
					<td width="" align="right"><input type="text" style="width:75;" class="input2" value="" name="showDate" readonly></td>
				</tr> 
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="105">Agreement No.</td>
					<td width="270">&nbsp;<script language="javascript">ComComboObject('combo_vndr_seq',9, 250, 1, 1,2,false,1);</script>
					<input type="hidden" name="vndr_seq"></td>
					<td width="60">EQ Type</td>
					<td width="233">&nbsp;<script language="javascript">ComComboObject('combo_eq_knd_cd',6, 80, 1, 1,1,false,1);</script>
					<input type="hidden" name="eq_knd_cd"></td>
					<td width="110">Cost CTRL Office</td>
					<td align=""><input type="text" style="width:75;text-align:center;" class="input2" value="" name="cost_ofc_cd" readonly></td></tr> 
				<tr class="h23">
					<td>Service Provider</td>
					<td>&nbsp;<input type="text" style="width:250;" class="input2" value="" name="pic_eng_nm" readonly></td>
					<td>Effective</td>
					<td>&nbsp;<input type="text" style="width:80;" class="input2" value="" name="eff_dt"  readonly> ~ 
					<input type="text" style="width:80;" class="input2" value="" name="exp_dt"  readonly></td>
					<td>Currency</td>
					<td><input type="text" style="width:75;text-align:center;" class="input2" value="" name="curr_cd" readonly></td>
				</tr>
				</table>		
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="108">Supply To</td>
					<td width="100"><script language="javascript">ComComboObject('combo_spr_prt_spl_tp_cd',2, 60 , 1, 0,2,false,1);</script><input type="hidden" name="spr_prt_spl_tp_cd"></td>
					<td width="64">VVD Code </td>
					<td width="200"><input type="text" name="vsl_vvd" maxlength=9 style="width:120;" class="input" dataformat="engup"><!-- CNTC0810MM -->
					<input type="hidden" name="vsl_cd"><input type="hidden" name="skd_voy_no"><input type="hidden" name="skd_dir_cd">
					</td>
					<td width="80">Supply Date</td>
					<td><input name="spr_prt_spl_dt" type="text" style="width:80;text-align:center;"  dataformat="ymd" maxlength=8>&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_calendar"></td>
				</tr>
				</table>
				<!--  biz   (E) -->

		</td></tr></table>	
		
		<!-- 1 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				

					<!-- Grid-1  (S) -->
					<table width="100%"  id="mainTable"> 
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
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_add">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_delete">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_downExcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
					
			
		</td></tr>
		</table>			
		<!-- 1 (E) -->
		
		
		
		<!-- 2 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				
				<table class="search" border="0" style="width:979;">
				<tr><td class="title_h"></td>
					<td class="title_s" width="200">Recent Supply Information</td>
					<td>
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Detail">Detail(s)</td>
							<td class="btn2_right"></td></tr>
						</table>
							
					</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>	
				
				<!--  biz (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="85">Supply Vessel</td>
					<td width="120"><input type="text"  name="vsl_cd2" style="width:100; text-align:center;" class="input2" value="" readonly></td>
					<td width="80">Supply Yard</td>
					<td width="140"><input type="text" name="spr_prt_spl_yd_cd2" style="width:100;" class="input2" value=""  readonly></td>
					<td width="80">Supply Date</td>
					<td width="145"><input type="text" name="spr_prt_spl_dt2" style="width:100; text-align:center;" class="input2" value=""  readonly></td>
					<td width="72">Supply S/P</td>
					<td width=""><input type="text" name="pic_eng_nm2" style="width:230;" class="input2" value=""  readonly></td>
					</tr> 
				</table>				
				<!--  biz (E) -->
				
				<table height="10"><tr><td></td></tr></table>	
											
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Remark(s)</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>					

				<textarea name="ord_hdr_rmk" style="ime-mode:disabled" style="width:100%;height:60"></textarea>
						
			
		</td></tr>
		</table>		
		<!-- 2 (E) -->		
		
		<!--biz page (E)-->
                  <!-- Grid-1  (S) -->
		<table width="100%" id="hideTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
				<script language="javascript">ComSheetObject('sheet3');</script>
			</td>
		</tr>	
		</table> 
		
	
	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>

</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>