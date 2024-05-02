<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0010.jsp
*@FileTitle : COP Manual Batch Update
*Open Issues :
*Change history :
    요건 및 UI 변경에 따른 수정
*@LastModifyDate : 2006-10-19
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-02 Seong-mun Kang
* 1.0 최초생성
=========================================================*/
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="com.clt.apps.opus.esd.sce.copmanage.COPManageSC" %>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.COPManageEvent" %>


<%

	String str_bkg_no 			= "";
	String str_bkg_no_split 	= "";
	String str_in_cntr_no 		= "";
	String str_in_cntr_tp		= "";
	String str_in_chg_cntr_no	= "";
	String str_in_chg_cntr_tp	= "";

	String f_return 			= "";

	//minestar - Partial Type 추가 시작
	String szCntrPChk			= "";
	String szChgCntrPChk			= "";
	// minestar - Partial Type 추가 끝

	try {

		str_bkg_no 			= request.getParameter("bkg_no");
		str_bkg_no_split 	= request.getParameter("bkg_no_split");
		str_in_cntr_no 		= request.getParameter("cntr_no");
		str_in_cntr_tp 		= request.getParameter("cntr_tpsz");
		str_in_chg_cntr_no 	= request.getParameter("chg_cntr_no");
		str_in_chg_cntr_tp 	= request.getParameter("chg_cntr_tpsz");

		//TODO - minestar - Partial Type 추가 시작
		szCntrPChk			= request.getParameter("p_chk");
		szChgCntrPChk		= request.getParameter("chg_p_chk");
		// minestar Partial Type 추가 끝



		COPManageSC copman = new COPManageSC();
		
		if( szCntrPChk == null && szChgCntrPChk == null)
		{
			// 이전 로직 - minestar
			f_return = copman.checkSORoute( str_bkg_no, str_bkg_no_split, str_in_cntr_no, str_in_cntr_tp, str_in_chg_cntr_no, str_in_chg_cntr_tp);
		} else {
			// 신규 로직 - minestar
			f_return = copman.checkAttachCntr( str_bkg_no, str_bkg_no_split, str_in_cntr_no, str_in_cntr_tp, str_in_chg_cntr_no, str_in_chg_cntr_tp, szCntrPChk, szChgCntrPChk);
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Sync With OPUS </title>
</head>

<script language="JavaScript">

document.onreadystatechange=checkReady;

function checkReady(){
	formObject = document.form;
	var result = '';
	result = '<%=f_return%>';

  if (document.readyState=='complete'){
  	self.status = "";
    self.status = result;
    self.status = "";
    self.defaultStatus=result;
  }else if (document.readyState=='완료'){
  	self.status = "";
    self.status = result;
    self.status = "";
    self.defaultStatus=result;
  }
  	self.status = "";
    self.status = result;
    self.status = "";

}

</script>

<body   >

<form method="post" name="form">
<input	type="hidden" name="f_cmd" value="<%=f_return%>">
</form>
</body>
</html>