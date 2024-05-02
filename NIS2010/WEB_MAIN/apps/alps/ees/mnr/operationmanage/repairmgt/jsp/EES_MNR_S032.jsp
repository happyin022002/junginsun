<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S032.jsp
*@FileTitle : Repair Result creatioln by W/O
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.09.29
*@LastModifier : 손흥식
*@LastVersion : 1.0
* 2009.09.29 손흥식   
* 2009.11.20 권영법   
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnrS032Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

EesMnrS032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	String strVndr_seq		= "";
	String strVndr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
	        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
		  strOfc_cd = account.getOfc_cd(); 
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();
	
		event = (EesMnrS032Event)request.getAttribute("Event"); 
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
<title>W/O List & Repair Completion Creation</title>   
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
<input type="hidden" name="mnr_wo_tp_cd" value="EST">

<input type="hidden" name="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">

<input type="hidden" name="com_mrdPath" value="">  
<input type="hidden" name="com_mrdArguments" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">W/O List & Repair Completion Creation</td></tr>
			</table>
			<!--Page Title, Historical (E)-->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrive">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_clear">New</td>
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
					<td width="60">EQ Type </td>
					<td width="150" style="padding-left:2;"><script language="javascript">ComComboObject('combo_eq_knd_cd',2, 100 , 1, 1,2,false,1);</script>
					<input type="hidden" name="eq_knd_cd"></td>
					<td width="105" >W/O Issue Date</td>	
					<td width="257">		
					<input type="text" style="width:80;text-align:center" class="input1" name="fromcal" dataformat="ymd" required  fulfill>
						&nbsp~&nbsp<input type="text" style="width:80;text-align:center" class="input1" name="tocal" dataformat="ymd" required  fulfill>&nbsp<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar">
					</td>
					<td width="165"  style="padding-left:2;">Repair Completion Status</td><!-- comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab-->
					<td><script language="javascript">ComComboObject('combo_rpr_rslt_sts',2, 100 , 1, 0,2,false,1);</script>
					<input type="hidden" name="rpr_rslt_sts"></td>
				
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">     
					<td width="60">EQ No.</td>
					<td width="150"><input name="eq_no" type="text" style="width:98;text-align:center;" class="input" dataformat="engup" value=""></td>   
					<td width="105">EST No.</td>
					<td width="120" style="padding-left:2;"><input name="rqst_ref_no" type="text" style="width:80;text-align:center;" class="input" dataformat="engup" value=""></td>  
					<td width="55">W/O No.</td> 
					<td width=""><input name="mnr_ord_seq" type="text" style="width:132" class="input" dataformat="engup" value=""></td>   
					
				</tr>  
				</table>	
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">	  
				<td width="100">Service Provider</td> 
				<td width="337"><input type="text" name="vndr_seq" caption="Service Provider" style="width:55;text-align:left;" class="input2" value="<%=strVndr_seq %>" readonly>&nbsp;<input type="text" name="vndr_nm" caption="Service Provider" style="width:180;" class="input2" value="<%=strVndr_nm%>" readonly></td>	 
				<td width="55">C.Office</td>     
				<td width=""> <input name="cost_ofc_cd" type="text" style="width:70;text-align:center;" class="input2" dataformat="engup" value="<%=strOfc_cd %>" readOnly></td> 
				  
				</tr>  
				</table>					
				<!--  biz   (E) -->

		</td></tr></table>	
		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_downExcel">Down&nbsp;Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_loadExcel">Load&nbsp;Excel</td>   
							<td class="btn2_right"></td>
							</tr>
							</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Detail">Detail(s)</td> 
					<td class="btn2_right"></td> 
					</tr>
					</table></td>
											
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Print">Print</td> 
					<td class="btn2_right"></td> 
					</tr>
					</table></td>
													
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

	
	
	</td></tr>
		</table>



</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>