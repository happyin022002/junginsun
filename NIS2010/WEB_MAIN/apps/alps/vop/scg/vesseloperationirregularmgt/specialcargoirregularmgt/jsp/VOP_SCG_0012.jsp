<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0012.jsp
*@FileTitle : SPCL CGO Irregular List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.16 김현욱
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg0012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%@page import="java.util.List"%>
<%@page import="com.hanjin.syscommon.common.table.MdmVslSvcLaneVO"%>
<%@page import="com.hanjin.syscommon.common.table.MdmCarrierVO"%>
<%@page import="com.hanjin.syscommon.common.table.MdmVslCntrVO"%>
<%@page import="com.hanjin.syscommon.common.table.ScgImdgClssCdVO"%>
<%@page import="com.hanjin.syscommon.common.table.ScgImdgCompGrpVO"%>
<%@page import="com.hanjin.syscommon.common.table.ScgImdgUnNoVO"%>
<%@page import="com.hanjin.syscommon.common.table.MdmLocationVO"%>

<%
	VopScg0012Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String pImdg_un_no     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.VesselOperationIrregularMgt.SpecialCargoIrregularMgt");
	
	//Combo String
	StringBuffer laneComboItem    = new StringBuffer();
	StringBuffer vslComboItem     = new StringBuffer();
	StringBuffer vslOprComboItem  = new StringBuffer();
	StringBuffer cgoOprComboItem  = new StringBuffer();
	StringBuffer classComboItem   = new StringBuffer();
	StringBuffer clsCompComboItem = new StringBuffer();
	StringBuffer unNoComboItem    = new StringBuffer();
	StringBuffer porComboItem     = new StringBuffer();
	StringBuffer polComboItem     = new StringBuffer();
	StringBuffer podComboItem     = new StringBuffer();
	StringBuffer delComboItem     = new StringBuffer();
	
	//Pre Condition
	String pop_mode     = "";
	String imdg_un_no   = "";
	String imdg_clss_cd = "";
	String pol_cd       = "";
	String pod_cd       = "";
	String slan_cd      = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0012Event)request.getAttribute("Event");
		pImdg_un_no = event.getAttribute("pImdg_un_no")==null?"":(String)event.getAttribute("pImdg_un_no");		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//0. Lane Combo
		List<MdmVslSvcLaneVO> laneCombo = (List<MdmVslSvcLaneVO>)eventResponse.getCustomData("laneCombo");
		if (laneCombo.size() > 0) {
        	int dataCount = laneCombo.size();
        	MdmVslSvcLaneVO[] vos = new MdmVslSvcLaneVO[dataCount];
        	laneCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			laneComboItem.append("|");
        		}
        		laneComboItem.append(vos[i].getVslSlanCd());
        	}
		}
		
		//1. Vessel Combo
		List<MdmVslCntrVO> vslCombo = (List<MdmVslCntrVO>)eventResponse.getCustomData("vslCombo");
		if (vslCombo.size() > 0) {
        	int dataCount = vslCombo.size();
        	MdmVslCntrVO[] vos = new MdmVslCntrVO[dataCount];
        	vslCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			vslComboItem.append("|");
        		}
        		vslComboItem.append(vos[i].getVslCd());
        	}
		}
		
		//2. VSL OPR Combo
		List<MdmCarrierVO> vslOprCombo = (List<MdmCarrierVO>)eventResponse.getCustomData("vslOprCombo");
		if (vslOprCombo.size() > 0) {
        	int dataCount = vslOprCombo.size();
        	MdmCarrierVO[] vos = new MdmCarrierVO[dataCount];
        	vslOprCombo.toArray(vos);
        	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			vslOprComboItem.append("|");
        		}
        		vslOprComboItem.append(vos[i].getCrrCd());
        	}
		}
		
		//3. CGO OPR Combo
		List<MdmCarrierVO> cgoOprCombo = (List<MdmCarrierVO>)eventResponse.getCustomData("cgoOprCombo");
		if (cgoOprCombo.size() > 0) {
        	int dataCount = cgoOprCombo.size();
        	MdmCarrierVO[] vos = new MdmCarrierVO[dataCount];
        	cgoOprCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			cgoOprComboItem.append("|");
        		}
        		cgoOprComboItem.append(vos[i].getCrrCd());
        	}
		}
		
		//4. Class Combo
		List<ScgImdgClssCdVO> classCombo = (List<ScgImdgClssCdVO>)eventResponse.getCustomData("classCombo");
		if (classCombo.size() > 0) {
        	int dataCount = classCombo.size();
        	ScgImdgClssCdVO[] vos = new ScgImdgClssCdVO[dataCount];
        	classCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			classComboItem.append("|");
        		}
        		classComboItem.append(vos[i].getImdgClssCd());
        	}
		}
		
		//5. Class Comp Combo
		List<ScgImdgCompGrpVO> clsCompCombo = (List<ScgImdgCompGrpVO>)eventResponse.getCustomData("clsCompCombo");
		if (clsCompCombo.size() > 0) {
        	int dataCount = clsCompCombo.size();
        	ScgImdgCompGrpVO[] vos = new ScgImdgCompGrpVO[dataCount];
        	clsCompCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			clsCompComboItem.append("|");
        		}
        		clsCompComboItem.append(vos[i].getImdgCompGrpCd());
        	}
		}
		
		//6. UN No. Combo
		List<ScgImdgUnNoVO> unNoCombo = (List<ScgImdgUnNoVO>)eventResponse.getCustomData("unNoCombo");
		if (unNoCombo.size() > 0) {
        	int dataCount = unNoCombo.size();
        	ScgImdgUnNoVO[] vos = new ScgImdgUnNoVO[dataCount];
        	unNoCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			unNoComboItem.append("|");
        		}
        		unNoComboItem.append(vos[i].getImdgUnNo());
        	}
		}
		
		//7. POR Combo
		List<MdmLocationVO> porCombo = (List<MdmLocationVO>)eventResponse.getCustomData("porCombo");
		if (porCombo.size() > 0) {
        	int dataCount = porCombo.size();
        	MdmLocationVO[] vos = new MdmLocationVO[dataCount];
        	porCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			porComboItem.append("|");
        		}
        		porComboItem.append(vos[i].getLocCd());
        	}
		}
		
		//8. POL Combo
		List<MdmLocationVO> polCombo = (List<MdmLocationVO>)eventResponse.getCustomData("polCombo");
		if (polCombo.size() > 0) {
        	int dataCount = polCombo.size();
        	MdmLocationVO[] vos = new MdmLocationVO[dataCount];
        	polCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			polComboItem.append("|");
        		}
        		polComboItem.append(vos[i].getLocCd());
        	}
		}
		
		//9. POD Combo
		List<MdmLocationVO> podCombo = (List<MdmLocationVO>)eventResponse.getCustomData("podCombo");
		if (podCombo.size() > 0) {
        	int dataCount = podCombo.size();
        	MdmLocationVO[] vos = new MdmLocationVO[dataCount];
        	podCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			podComboItem.append("|");
        		}
        		podComboItem.append(vos[i].getLocCd());
        	}
		}
		
		//10. DEL Combo
		List<MdmLocationVO> delCombo = (List<MdmLocationVO>)eventResponse.getCustomData("delCombo");
		if (delCombo.size() > 0) {
        	int dataCount = delCombo.size();
        	MdmLocationVO[] vos = new MdmLocationVO[dataCount];
        	delCombo.toArray(vos);
	
        	for (int i = 0; i < dataCount; i++) {
        		if (i != 0) {
        			delComboItem.append("|");
        		}
        		delComboItem.append(vos[i].getLocCd());
        	}
		}
		
		//Pre Condition
		pop_mode     = StringUtil.xssFilter(request.getParameter("pop_mode"))==null?"N":StringUtil.xssFilter(request.getParameter("pop_mode"));
		imdg_un_no   = StringUtil.xssFilter(request.getParameter("imdg_un_no"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_un_no"));
		imdg_clss_cd = StringUtil.xssFilter(request.getParameter("imdg_clss_cd"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_clss_cd"));
		pol_cd       = StringUtil.xssFilter(request.getParameter("pol_cd"))==null?"":StringUtil.xssFilter(request.getParameter("pol_cd"));
		pod_cd       = StringUtil.xssFilter(request.getParameter("pod_cd"))==null?"":StringUtil.xssFilter(request.getParameter("pod_cd"));
		slan_cd      = StringUtil.xssFilter(request.getParameter("slan_cd"))==null?"":StringUtil.xssFilter(request.getParameter("slan_cd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SPCL CGO Irregular List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	//Pre Condition
	var preConds = {
		pop_mode       : "<%=pop_mode%>",
		imdg_un_no     : "<%=imdg_un_no%>",
		imdg_clss_cd   : "<%=imdg_clss_cd%>",
		pol_cd         : "<%=pol_cd%>",
		pod_cd         : "<%=pod_cd%>",
		slan_cd        : "<%=slan_cd%>"
	}
		
	function setupPage(){
		if('Y' == preConds.pop_mode) {				
			//Show closing button
			document.all.popLayer.style.display = "";
			
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.pophistory.innerHTML = "";
			 	} else {
			  		document.getElementById("pophistory").innerHTML = "";
			 	}
			 	
			 	document.getElementById("mainBdy").className   = "popup_bg";
			 	document.getElementById("mainTbl").className   = "popup";
			 	document.getElementById("mainTbl").cellPadding = "10";
			 	document.getElementById("topLine").className   = "top";
			}catch(err) {
			 	ComShowMessage(err);
			}
		}
	
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		var comboItems = new Array();
		
		comboItems[0] = "<%=laneComboItem.toString()%>";    
		comboItems[1] = "<%=vslComboItem.toString()%>";    
		comboItems[2] = "<%=vslOprComboItem.toString()%>"; 
		comboItems[3] = "<%=cgoOprComboItem.toString()%>"; 
		comboItems[4] = "<%=classComboItem.toString()%>";  
		comboItems[5] = "<%=clsCompComboItem.toString()%>";                      
		comboItems[6] = "<%=unNoComboItem.toString()%>";                         
		comboItems[7] = "<%=porComboItem.toString()%>";                          
		comboItems[8] = "<%=polComboItem.toString()%>";                          
		comboItems[9] = "<%=podComboItem.toString()%>";                          
		comboItems[10] = "<%=delComboItem.toString()%>";  
		
		if( form.pImdg_un_no.value != ""){
		    ComScgMainToMakePopup();
		}

		loadPage(comboItems);
	}
</script>
</head>

<body id="mainBdy" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="pImdg_un_no" value ="<%=pImdg_un_no %>">

<!-- 개발자 작업	-->

<table id="mainTbl" width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td id="topLine"></td></tr>
	<tr>
		<td valign="top">
			<!--top menu (S)-->
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history" id="pophistory"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			<!--biz page (S)-->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table  class="search_sm2" border="0" style="width:380;" >
							<tr class="h23">
								<td width="60">Option</td>
								<td class="stm"><input name="irr_spcl_cgo_cate_cd" type="radio" value="" class="trans" checked>All
								    &nbsp;&nbsp;<input name="irr_spcl_cgo_cate_cd" type="radio" value="DG" class="trans">Dangerous Goods
								    &nbsp;&nbsp;<input name="irr_spcl_cgo_cate_cd" type="radio" value="AC" class="trans"  >Awkward Cargo</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="40">Period</td>
								<td width="280">&nbsp;
									<input name="irr_occr_from_dt" required type="text" style="width:80;" class="input1" dataformat="ymd" caption="Period" maxlength="8" size="10" value="2001-01-01">
									&nbsp;~&nbsp;
									<input name="irr_occr_to_dt" required type="text" style="width:80;" class="input1" dataformat="ymd" caption="Period" maxlength="8" size="10" value="<%=DateTime.getFormatDate(new java.util.Date(),"yyyyMMdd")%>">
									<img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="33">Lane</td>
								<td width="160">
									<script language="javascript">ComComboObject('vsl_slan_cd', 1, 104, 0, 0, 0, false);</script>
								</td>
								<td width="50">Vessel</td>
								<td width="100">
									<script language="javascript">ComComboObject('vsl_cd', 1, 60, 0, 0, 0, false);</script>
								</td>
								<td width="65">VSL OPR</td>
								<td width="112">
									<script language="javascript">ComComboObject('vsl_opr_tp_cd', 1, 60, 0, 0, 0, false);</script>
								</td>
								<td width="60">CGO OPR</td>
								<td width="">
									<script language="javascript">ComComboObject('cgo_opr_cd', 1, 60, 0, 0, 0, false);</script>
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="100">Irregulars Type</td>
								<td width="220">
									<script language="javascript">ComComboObject('spcl_cgo_irr_tp_cd', 3, 157, 0, 0, 0, false);</script>
								</td>
								<td width="33">Class</td>
								<td width="160">
									<script language="javascript">ComComboObject('imdg_clss_cd', 1, 60, 0, 0, 0, false);</script>&nbsp;
									<script language="javascript">ComComboObject('imdg_comp_grp_cd', 1, 40, 0, 0, 0, false);</script>
								</td>
								<td width="50">UN No.</td>
								<td width="100">
									<script language="javascript">ComComboObject('imdg_un_no', 1, 60, 0, 0, 0, false);</script>
								</td>
								<td width="65">AWK Type</td>
								<td width="">
									<script language="javascript">ComComboObject('cnt_spcl_cgo_cate_cd', 1, 60, 0, 0, 0, false);</script>
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="40">POR</td>
								<td width="100">&nbsp;
									<script language="javascript">ComComboObject('por_cd', 1, 80, 0, 0, 0, false);</script>
								</td>
								<td width="25">POL</td>
								<td width="100">&nbsp;
									<script language="javascript">ComComboObject('pol_cd', 1, 76, 0, 0, 0, false);</script>
								</td>
								<td width="33">POD</td>
								<td width="105">
									<script language="javascript">ComComboObject('pod_cd', 1, 70, 0, 0, 0, false);</script>
								</td>
								<td width="55">Delivery</td>
								<td width="125">
									<script language="javascript">ComComboObject('del_cd', 1, 70, 0, 0, 0, false);</script>
								</td>
								<td width="35">SHPR</td>
								<td width="165"><input name="s_cust_nm" type="text" style="width:140;" class="input" value=""></td>
								<td width="35">CNEE</td>
								<td width=""><input name="c_cust_nm" type="text" style="width:140;" class="input" value=""></td>								
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
		
			<!-- Grid BG Box  (S) -->
	     	<table class="search">
		       	<tr>
		       		<td class="bg">
						<!--  biz_2  (S) -->					
						<!-- Grid (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->					
					</td>
				</tr>
			</table>
			<!-- Grid BG Box  (S) -->
			<!--biz page (E)-->
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:5;"> 

		       	<tr>
		       		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
								<td  style='display:none'>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close"  id="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>	
							</tr>
						</table>
					</td>
				</tr>
			</table>
	    	<!--Button (E) -->	
		</td>
	</tr>
</table>

<div id="popLayer" style="display:none">
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close2">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
    					<!--Button (E) -->
	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>