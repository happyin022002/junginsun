<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0228.jsp
*@FileTitle : M&R Reefer Spare Parts W/O Inquiry Pop Up
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.10.13
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event.EesMnr0228Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0228Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
	//팝업용 데이타			 	
	String mnrOrdOfcCtyCd = ((request.getParameter("mnr_ord_ofc_cty_cd")==null )?"":request.getParameter("mnr_ord_ofc_cty_cd"));
	String mnrOrdSeq = ((request.getParameter("mnr_ord_seq")==null )?"":request.getParameter("mnr_ord_seq"));
	String costOfcCd = ((request.getParameter("cost_ofc_cd")==null )?"":request.getParameter("cost_ofc_cd"));
	try {     


		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
		
		
		event = (EesMnr0228Event)request.getAttribute("Event"); 
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
<title><span id="title"></span></title>
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
<input type="hidden" name="agmt_ofc_cty_cd" value="<%=mnrOrdOfcCtyCd%>">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">
<input type="hidden" name="sel_type" value="S">
<input type="hidden" name="cost_cd" value="MRRURC">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Reefer Spare Parts W/O Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
			<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100">W/O No. </td>
					<td width="140"><input type="text" name="mnr_ord_seq" style="width:140;" class="input2" value="<%=mnrOrdOfcCtyCd+mnrOrdSeq%>"   readonly></td>
					<td align="right">Date&nbsp;<input type="text" name="showDate" style="width:80;text-align:center;" class="input2" value="" readonly></td>
				</tr> 
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100">Agreement No.</td>
					<td width="280"><input type="text" name="vndr_seq" style="width:140;" class="input2" value="" readonly></td>
					<td width="60">EQ Type</td>
					<td width="220"><input type="text" name="eq_knd_cd" style="width:80;text-align:center;" class="input2" value="" readonly></td>
					<td width="120">Cost Control OFC</td>
					<td width=""><input type="text" name="cost_ofc_cd" style="width:80;text-align:center;" class="input2" value="<%=costOfcCd%>" readonly></td>
				</tr> 
				<tr class="h23">
					<td width="">Service Provider</td>
					<td width=""><input type="text" name="pic_eng_nm" style="width:250;text-align:left;" class="input2" value="" readonly></td>
					<td width="">Effective</td>
					<td width=""><input type="text" name="eff_dt" style="width:80;text-align:center;" class="input2" value="" readonly> ~ <input type="text" name="exp_dt" style="width:80;text-align:center;" class="input2" value="" readonly></td>
					<td width="">Currency</td>
					<td width=""><input type="text" name="curr_cd" style="width:80;text-align:center;" class="input2" value="" readonly></td>
				</tr> 
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="70">Supply To</td>
					<td width="130"><input type="text" name="spr_prt_spl_tp_cd" style="width:70;text-align:center;" class="input2" value="" readonly></td>
					<td width="60">VVD Code</td>
					<td width="120"><input type="text"  name="vsl_vvd" style="width:90;text-align:center;" class="input2" value="" readonly></td>
					<td width="30">Yard</td>
					<td width="100"><input type="text" name="spr_prt_spl_yd_cd" style="width:70;text-align:center;" class="input2" value="" readonly></td>
					<td width="80">Supply Date</td>
					<td width=""><input type="text" name="spr_prt_spl_dt" style="width:80;text-align:center;" class="input2" value="" readonly></td>
				
				</tr> 
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>				
				<!--  biz_1   (E) -->
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<!-- Grid (E) -->		
		
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table style="display:none;">
				<tr>
				<td>
				 <script language="javascript">ComComboObject('combo_vndr_seq',9, 0, 1, 1,2,false,1);</script>
				 <script language="javascript">ComComboObject('combo_eq_knd_cd',6, 80, 1, 1,1,false,1);</script>
				 <script language="javascript">ComComboObject('combo_spr_prt_spl_tp_cd',2, 60 , 1, 0,2,false,1);</script>
				 </td>
				 </tr>
				 </table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="600" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Recent Supply  Information</td></tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="80">Vessel Code</td>
							<td width="120"><input type="text" name="vsl_cd2" style="width:80;text-align:center;" class="input2" value="" readonly></td>
							<td width="80">Supply Yard</td>
							<td width=""><input type="text" name="spr_prt_spl_yd_cd2" style="width:80;text-align:center;" class="input2" value="" readonly></td>
						</tr> 
						<tr class="h23">
							<td width="">Supply Date</td>
							<td width=""><input type="text" name="spr_prt_spl_dt2" style="width:80;text-align:center;" class="input2" value="" readonly></td>
							<td width="">Supply S/P</td>
							<td width=""><input type="text" name="pic_eng_nm2" style="width:300;text-align:left;" class="input2" value="" readonly></td>
						</tr> 
						</table>
					</td>
					<td width="20"> </td>
					<td width="" valign="top">
						<table class="grid2" border="0" style="width:100%;"> 
						<tr class="tr2_head">
							<td >Remark(s)</td>
						</tr> 
						<tr>
							<td width="" class="input2"><textarea  name="ord_hdr_rmk" style="width:100%;height:45;"  class="textarea2" readonly></textarea></td>
						</tr> 
						</table>
				
					</td>
				</tr> 
				</table>
					
		
	
	</td></tr>
	</table>
</td></tr>
</table>
<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

                  <!-- Grid-1  (S) -->
		<table width="100%" id="hideTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
				<script language="javascript">ComSheetObject('sheet3');</script>
			</td>
		</tr>	
		</table> 
<!-- : ( Button : pop ) (E) -->
</form>			
			
</body>
</html>
