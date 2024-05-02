<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0997.jsp
*@FileTitle : COD Comfirm Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.08.06 최영희
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0997Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.syscommon.common.table.BkgCodVvdVO"%>

<%
	EsmBkg0997Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";  
	String strAsList = "";
	String strAsCode = "";
	String strAsText = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo = "";
	String strCodRqstSeq = "";
	StringBuffer strParamVvd= new StringBuffer();
	String strCodCntrNo ="";
	String strCodDg = "";
	String strCodBb = "";
	String strCodAk = "";
	String strCodRf = "";

	Logger log = Logger.getLogger("com.hanjin.apps.BookingCorrection.CODCorrection");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strAsList=JSPUtil.getIBCodeCombo("", "", "CD01637", 0, "");
		
		if(strAsList != null && strAsList.length() > 8) {
			strAsCode = strAsList.substring(strAsList.indexOf("Code = \"")+8, strAsList.lastIndexOf("\""));
			strAsText = strAsList.substring(strAsList.indexOf("Text = \"")+8, strAsList.indexOf("\";"));  
		}

		event = (EsmBkg0997Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		for(int i=0;i<event.getBkgCodVvdVOs().length;i++){
			strParamVvd.append("&codVslCd="+event.getBkgCodVvdVOs()[i].getVslCd());
			strParamVvd.append("&codPodClptIndSeq="+event.getBkgCodVvdVOs()[i].getPodClptIndSeq()); 
			strParamVvd.append("&codSkdVoyNo="+event.getBkgCodVvdVOs()[i].getSkdVoyNo()); 
			strParamVvd.append("&codVslSeq="+event.getBkgCodVvdVOs()[i].getVslSeq()); 
			strParamVvd.append("&codSkdDirCd="+event.getBkgCodVvdVOs()[i].getSkdDirCd());
			strParamVvd.append("&codBkgNo="+event.getBkgCodVvdVOs()[i].getBkgNo());
			strParamVvd.append("&codCodRqstSeq="+event.getBkgCodVvdVOs()[i].getCodRqstSeq());
			strParamVvd.append("&codSlanCd="+event.getBkgCodVvdVOs()[i].getSlanCd());
			strParamVvd.append("&codPolYdCd="+event.getBkgCodVvdVOs()[i].getPolYdCd());
			strParamVvd.append("&codPolClptIndSeq="+event.getBkgCodVvdVOs()[i].getPolClptIndSeq());
			strParamVvd.append("&codVslPrePstCd="+event.getBkgCodVvdVOs()[i].getVslPrePstCd());
			strParamVvd.append("&codPodYdCd="+event.getBkgCodVvdVOs()[i].getPodYdCd());
			strParamVvd.append("&codVvdOpCd="+event.getBkgCodVvdVOs()[i].getVvdOpCd()); 
		}
		
		strCodCntrNo = event.getCodCntrNo();
		strCodDg = event.getCodDg();
		strCodBb = event.getCodBb();
		strCodAk = event.getCodAk();
		strCodRf = event.getCodRf();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
  
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strBkgNo =JSPUtil.getNull(event.getBkgBlNoVO().getBkgNo());
        strCodRqstSeq =JSPUtil.getNull(event.getCodRqstSeq());
		 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>COD Comfirm Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=strAsCode%>","<%=strAsText%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=strBkgNo%>">
<input type="hidden" name="cod_rqst_seq" value="<%=strCodRqstSeq%>">
 
<input type="hidden" name="splitcount" value="2">
<input type="hidden" name="lastSplitNo">
<input type="hidden" name="memoSplitNo">
<input type="hidden" name="custSplitNo">
<input type="hidden" name="qtySplitNo">
<input type="hidden" name="cntrSplitNo">
<input type="hidden" name="dgCntrSplitNo">
<input type="hidden" name="rfCntrSplitNo">
<input type="hidden" name="akCntrSplitNo">
<input type="hidden" name="bbCntrSplitNo">
<input type="hidden" name="troSplitNo">
<input type="hidden" name="bkgsplitno">
<input type="hidden" name="codflag" value="Y">
<input type="hidden" name="bl_no">
<input type="hidden" name="tvvd">
<input type="hidden" name="por_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="del_cd">
<input type="hidden" name="stwg_cd">
<input type="hidden" name="rail_blk_cd">
<input type="hidden" name="fd_grd_flg">
<input type="hidden" name="hngr_flg">
<input type="hidden" name="hot_de_flg">
<input type="hidden" name="prct_flg">
<input type="hidden" name="stop_off_loc_cd">
<input type="hidden" name="spcl_hide_flg">
<input type="hidden" name="remark">
<input type="hidden" name="dg">
<input type="hidden" name="rf">
<input type="hidden" name="ak">
<input type="hidden" name="bb">
<input type="hidden" name="pctl_no">
<input type="hidden" name="rtn_route">
<input type="hidden" name="bdr_flag">
<input type="hidden" name="tro_flg">
<input type="hidden" name="splitFlg">
<input type="hidden" name="bkgStsCd"> 
<input type="hidden" name="paramVvd" value="<%=strParamVvd%>"> 
<input type="hidden" name="codCntrNo" value="<%=strCodCntrNo%>"> 
<input type="hidden" name="codDg" value="<%=strCodDg%>"> 
<input type="hidden" name="codBb" value="<%=strCodBb%>"> 
<input type="hidden" name="codAk" value="<%=strCodAk%>"> 
<input type="hidden" name="codRf" value="<%=strCodRf%>"> 
 
 <!-- CA Reason hidden -->
<input type="hidden" name="ca_rsn_cd">
<input type="hidden" name="ca_remark">

<!-- 개발자 작업	-->
<table width="590" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;COD Confirm</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) --> 
		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="">Original Booking will be split and the selected container(s) will be moved to below BKG. Do you want to continue?
					</td></tr>
				</table>
				<table class="height_10"><tr><td></td></tr></table>
				<!-- box(S) -->		
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
					<tr class="tr2_head">
						<td width=""  colspan="4">Type of Split</td>
					</tr>
					<tr align="center">
						<td width=""  width="90"><input type="radio" value="C" class="trans" name="splitreason" checked></td>
						<td width="" class="noinput2" width="200"><input type="text" style="width:130;text-align:center" value=" Customer" class="noinput2" ></td>
						<td width=""  width="90"><input type="radio" value="M" class="trans" name="splitreason"></td>
						<td width="" class="noinput2" width="" ><input type="text" style="width:130;text-align:center" value=" Memo B/L" class="noinput2"></td>
					</tr>
				</table>	
				<!-- box(E) -->	
				<table width="0"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<table class="height_10"><tr><td></td></tr></table>
				<!-- Grid_2 (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid_2 (E) -->	
				<table class="height_10"><tr><td></td></tr></table>
				<!-- Grid_3 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid_3 (E) -->										
				<!-- box(S) 		
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
						<tr class="tr2_head">
							<td width="" >Move</td>
							<td width="">Booking No.</td>
						</tr>
						<tr align="center">
							<td width=""  width="60"><input type="radio" value="" class="trans"></td>
							<td width="" class="noinput2"><input type="text" style="width:130;text-align:center" value=" KOR6202001" class="noinput2">	</td>
							</tr>
						<tr align="center">
							<td width="" ><input type="radio" value="" class="trans"></td>
							<td width="" class="noinput2"><input type="text" style="width:130;text-align:center" value=" KOR6202001" class="noinput2">	</td>
							</tr>
				</table>	
				 box(E) -->			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	</td></tr>
</table> 
<table class="height_5"><tr><td></td></tr></table>
<table><tr><td>
	<table width="0"  id="mainTable"  border="0"> 
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet4');</script>
			</td>
		</tr>
	</table> 
	<table width="0"  id="mainTable"  border="0"> 
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet5');</script>
			</td>
		</tr>
	</table> 
	<table width="0"  id="mainTable"  border="0"> 
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet6');</script>
			</td>
		</tr>
	</table> 
</td></tr></table>
<table width="100%" class="sbutton" border="0" >
	<tr><td height="71" class="popup">	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr><td>
			    	<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_ok">Ok</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				<td class="btn1_line"></td>		
				<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
					</tr></table>
				</td></tr>
				</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<%@include file="/bizcommon/include/common_alps.jsp"%>
</form>
</body>
</html>