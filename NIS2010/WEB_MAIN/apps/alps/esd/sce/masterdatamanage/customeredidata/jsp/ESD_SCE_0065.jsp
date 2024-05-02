<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0065.jsp
*@FileTitle : EDI Search
*Open Issues :
*Change history :
*   - 2006-10-12 : UI 변경으로 인한 수정
*   - 2007-11-13 : CUST STS 콤보 추가
*@LastModifyDate : 2007-11-13
*@LastModifier : Jeong-Seon, An
*@LastVersion  : 2.0
* 1.0 최초 생성 : 2006-08-29 yong cheon shin
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;

	//main 화면에서 보낸 Parameter
	String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
	String bkg_no_split = JSPUtil.getNull(request.getParameter("bkg_no_split"));
	String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));
	String cs_grp_id = JSPUtil.getNull(request.getParameter("cs_grp_id"));
	String f_cmd = JSPUtil.getNull(request.getParameter("f_cmd"));
	String nod = JSPUtil.getNull(request.getParameter("nod"));
	
	//EDI STS 검색 조건: Default
	//String queryOption = "cgo.edi_grp_cd = '" + cs_grp_id + "' and cgo.edi_stnd_sts_cd = sts.edi_stnd_sts_cd and sts.co_div_cd = cgo.co_div_cd order by edi_sts_seq";
	//Group by 추가
	String queryOption = "cgo.edi_grp_cd = '" + cs_grp_id + "' and cgo.edi_stnd_sts_cd = sts.edi_stnd_sts_cd and sts.co_div_cd = cgo.co_div_cd GROUP BY cgo.edi_stnd_sts_cd, sts.edi_sts_desc order by edi_sts_seq ";
	//EDI STS콤보에서 선택한 값이 있는 경우
	String edi_idx = JSPUtil.getNull(request.getParameter("edi_selected_idx"));
	//EDI STS콤보에서 선택한 값이 없는 경우
	if (edi_idx.equals("")) edi_idx = "0";

	//CUST STS 컬럼 값: Default
	String custQryCOL = " 'VSL:' || decode(EDI_VSL_TP_CD, '1', 'TRUNK', '2', 'NOT TRUNK', '3', 'ALL') || ' / EVENT:' || decode(EDI_EVNT_CD, '1', 'FIRST', '2', 'NOT FIRST', '3', 'LAST', '4', 'NOT LAST', '5', 'ALL') custDesc ";
	String custQryOPT = null ;
	if (request.getParameter("cust_opt") != null && !request.getParameter("cust_opt").equals("")){
		//CUST STS 검색옵션 지정(EDI STS콤보에서 선택 값에 따른)
		custQryOPT =  JSPUtil.getNull(request.getParameter("cust_opt"));
	}else{
		//CUST STS 검색옵션 지정(EDI STS콤보에서 선택 값이 없는 경우): Default
		custQryOPT = " edi_grp_cd = '"+cs_grp_id+"' " ;
	}

	//최종 사용될 CUST STS쿼리 onValueChange('cust_st',this.form)
	String combo2= null;
	combo2 = codeUtil.searchCodeCombo("cust_st"," EDI_GRP_CGO where  "+ custQryOPT
	        ,"CUST_EDI_STS_CD cust_st "
	        ,"CUST_EDI_STS_CD || ' - ' || "+custQryCOL+ " " ,""," onChange=javascript:custcomboChange('cust_sts',this.value); ","1:: ");

%>
<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

function screenReload(){

form.action = 'ESD_SCE_0065.do';
form.submit();

}
</script>
<base target="_self"/>
</head>


<body onLoad='loadPage();'>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="bkg_no" value = '<%=bkg_no %>'>
<input type="hidden" name="bkg_no_split" value = '<%= bkg_no_split %>'>
<input type="hidden" name="cntr_no" value = '<%= cntr_no %>'>
<input type="hidden" name="cs_grp_id" value = '<%= cs_grp_id %>'>
<input type="hidden" name="dist" value = ''>
<input type="hidden" name="cust_sts" value = ''>
<input type="hidden" name="cust_opt" value = '<%= custQryOPT %>'>
<input type="hidden" name="load_chk" value = 'FAIL'>
<input type="hidden" name="edi_selected_idx" value = '<%= edi_idx %>'>
<input type="hidden" name="cust_st">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Cargo Tracking EDI Save - Group</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" style="width:500;">
						<tr class="h23">
							<td width="21%">&nbsp;&nbsp; EDI STS </td>
							<td>&nbsp;<%=codeUtil.searchCodeCombo("edi_sts"," edi_grp_cgo cgo , edi_cgo_stnd_sts sts where " + queryOption
							        ,"cgo.edi_stnd_sts_cd edi_sts "
							        ,"cgo.edi_stnd_sts_cd || ' - ' || sts.edi_sts_desc cs_desc , MIN(sts.edi_sts_seq) edi_sts_seq   " ,""," onChange=javascript:comboChange('edi_sts'); ","1:: ")%>
							</td>
<!-- [ComboUSAGE] getCodeCombo(String selectName, String table, String valueField, String textField, String orderByField, String options, String addOption)	-->
                        </tr>
                        <tr class="h23">
							<td width="21%">&nbsp;&nbsp; CUST STS </td>
							<td>&nbsp;<%=combo2%>
							</td>
						</tr>
						<tr class="h23">
							<td width="21%">&nbsp;&nbsp; Actual Date </td>
							<td>&nbsp;<input name="act_dt" onKeyUp='enterCheck();' type="text" class="input" style="width:130; text-transform:uppercase;"  value="">
							    &nbsp;(YYYY/MM/DD HH:MM:SS)
							</td>
						</tr>
						<tr class="h23">
							<td width="21%">&nbsp;&nbsp; Location </td>
							<td>&nbsp;<input name="nod"  type="text" class="input" style="width:130; text-transform:uppercase;"  value="">
							</td>
						</tr>

					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->

</td></tr>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
			
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <span id="btn_v">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
				</span>
			</table>

		</td></tr>
</table>

</body>
<%
	if(!f_cmd.equals("")){
	    Exception serverException = null;                     //서버에서 발생한 에러	

	    String strErrMsg = "";                                //에러메세지
	    String locCd = null;
	    try {
	        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	        if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }
	       
	    }catch(Exception e) {
	        out.println(e.toString());
	    }		
%>
<script>
		var opener = window.dialogArguments;
		if("<%=strErrMsg%>" == ''){
			opener.researchScreen();
			self.close();	
		}else{
			//var btnStr = "<tr>";
			//btnStr += "<table width='100%' border='0' cellpadding='0' cellspacing='0' class='button'>";
			//btnStr += "<tr><td class='btn1_left'></td><td class='btn1' name='btn_save' id='btn_save'>Save</td><td class='btn1_right'></td></tr></table></td>";
			//btnStr += "<td><table width='100%' border='0' cellpadding='0' cellspacing='0' class='button'>";
			//btnStr += "<tr><td class='btn1_left'></td><td class='btn1' name='btn_close' id='btn_close'>Close</td><td class='btn1_right'></td></tr></table></td>";
			//btnStr += "</tr>";
			//document.getElementById('btn_v').innerHTML = btnStr;
	
			alert("The location code(<%=nod%>) is not registered in DB(location)");		
		}

</script>

<%
	}
%>

</html>

