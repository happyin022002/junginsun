<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0234.jsp
*@FileTitle : Agreement Rail Surcharge History
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2010-05-25 pjy
* 1.0 최초 생성
*
* 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%> 
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException = null;	//서버에서 발생한 에러
	String	  strErrMsg	= "";			//에러메세지
	String	  userId    = "";
	String	  ofcCd		= "";
	try {		
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String agmtNo = JSPUtil.getNull(request.getParameter("agmt_no"));
	String vndrSeq = JSPUtil.getNull(request.getParameter("vndr_seq"));
	String trspRailScgCd = JSPUtil.getNull(request.getParameter("trsp_rail_scg_cd"));
	String agmtRoutAllFlg = JSPUtil.getNull(request.getParameter("agmt_rout_all_flg"));
	String fmNodCd = JSPUtil.getNull(request.getParameter("fm_nod_cd"));
	String toNodCd = JSPUtil.getNull(request.getParameter("to_nod_cd"));
	String cgoTpCd = JSPUtil.getNull(request.getParameter("cgo_tp_cd"));
	String cngEffFmDt = JSPUtil.getNull(request.getParameter("eff_fm_dt"));
	String cngEffToDt = JSPUtil.getNull(request.getParameter("eff_to_dt"));
	String effective_date = JSPUtil.getNull(request.getParameter("effective_date"));
	String gubun = JSPUtil.getNull(request.getParameter("gubun"));
	String delete_yn   = ((request.getParameter("delete_yn")==null)?"":request.getParameter("delete_yn"));	// 추가-민정호
	
	String cngFmLocCd = "";
	String cngFmYardCd = "";
	String cngToLocCd = "";
	String cngToYardCd = "";	
	
	if( fmNodCd.length() == 0 ){
		cngFmLocCd = "";
		cngFmYardCd = "";		
	}else if( fmNodCd.length() < 6 ){
		cngFmLocCd = fmNodCd;
		cngFmYardCd = "";	
	}else{
		cngFmLocCd = fmNodCd.substring(0, 5);
		cngFmYardCd = fmNodCd.substring(5);	
	}
	
	if( toNodCd.length() == 0 ){
		cngToLocCd = "";
		cngToYardCd = "";			
	}else if( toNodCd.length() < 6 ){
		cngToLocCd = toNodCd;
		cngToYardCd = "";	
	}else{
		cngToLocCd = toNodCd.substring(0, 5);
		cngToYardCd = toNodCd.substring(5);	
	}
	
	String cngTrspRailScgCd = "";
	if( trspRailScgCd.equals("") ){
		cngTrspRailScgCd = "";
	}else if( trspRailScgCd.equals("FSG") ){
		cngTrspRailScgCd = "FSG";		
	}else if( trspRailScgCd.equals("ISG") ){
		cngTrspRailScgCd = "ISG";		
	}else{
		cngTrspRailScgCd = "NFSG";		
	}
%>
<html>
<head>
<title>Agreement Rail Surcharge History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    loadPage();
    
    var formObject = document.form;
    
    formObject.routeAll.value = "<%=agmtRoutAllFlg%>";
    
    if( formObject.routeAll.value == "0" ){
    	formObject.routeAll.checked = false;
    	formObject.routeAll.value = "";
    }else if( formObject.routeAll.value == "1" ){
    	formObject.routeAll.checked = true;
    	formObject.routeAll.value = "Y";
    }
            
    formObject.fm_fm_nod_cd.value = "<%=cngFmLocCd%>"; 
    formObject.fm_to_nod_cd.value = "<%=cngToLocCd%>";
    formObject.sel_scg.value = "<%=cngTrspRailScgCd%>";
//    formObject.fm_eff_fm_dt1.value = "<%=cngEffFmDt%>";
//    formObject.fm_eff_to_dt1.value = "<%=cngEffToDt%>";
    
    getComboList(formObject.fm_fm_nod_cd, document.fm_fm_nod_yd, 'F');
    getComboList(formObject.fm_to_nod_cd, document.fm_to_nod_yd, 'T');
    formObject.fm_fm_nod_yd.CODE = "<%=cngFmYardCd%>";
    formObject.fm_to_nod_yd.CODE = "<%=cngToYardCd%>";
    
//    getHypen(formObject.fm_eff_fm_dt1);
//    getHypen(formObject.fm_eff_to_dt1);

	formObject.gubun.value = "<%=gubun%>";
    loadPage2();
  }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="hid_fm_eff_fm_dt1" value="">
<input type="hidden" name="hid_fm_eff_to_dt1" value="">
<input type="hidden" name="agmtNo" value='<%=agmtNo%>'>
<input type="hidden" name="vndrSeq" value='<%=vndrSeq%>'>
<input type="hidden" name="trspRailScgCd" value='<%=trspRailScgCd%>'>
<input type="hidden" name="agmtRoutAllFlg" value='<%=agmtRoutAllFlg%>'>
<input type="hidden" name="fmNodCd" value='<%=fmNodCd%>'>
<input type="hidden" name="toNodCd" value='<%=toNodCd%>'>
<input type="hidden" name="cgoTpCd" value='<%=cgoTpCd%>'>
<input type="hidden" name="gubun" value='<%=gubun%>'>


<input type="hidden" name="f_cmd" >
<table width="100%" class="popup" cellpadding="10">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Agreement Rail Surcharge History</td>
        </tr>
      </table>
      <!-- : ( Title ) (E) -->
    
      <table class="height_8"><tr><td></td></tr></table>  
      <!--  biz_1  (S) -->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
          
            <!--  biz_2   (S) -->
            <table class="search" border="0" style="width:550;"> 
              <tr class="h23">
                <td width="" valign="top">
                  <table class="search" style="width:800;" border="0">
                    <tr class="h23">
                    	<td align="right">Agreement No</td>
                       	<td>&nbsp;<input name="agmtNo" type="text" style="width:100;" value="<%=agmtNo%>" readonly></td>
                    	<td align="right">Rail Company</td>
                       	<td>&nbsp;<input name="vndrSeq" type="text" style="width:100;" value="<%=vndrSeq%>" readonly></td>
                    	<td align="right">Cargo Type</td>
                       	<td>&nbsp;<select name="cgoTpCd" style="width:82;">
                       	<%if("F".equals(cgoTpCd)){%>
							<option value="F">Full</option>
						<%}else{ %>	
							<option value="M">Empty</option>
						<%} %>	
							</select>
                      </td>                                	                	                     	                       	
                  	</tr>                   
                    <tr class="h23">
                    	<td align="right">Route ALL</td>
                       	<td>&nbsp;<input type="checkbox" name="routeAll" value="" class="trans" onClick="javascript:fun_allRoute();"></td>
                    	<td align="right">ORG</td>
                       	<td>&nbsp;<input name="fm_fm_nod_cd" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.fm_fm_nod_yd, 'F');" onBlur="setgetUpper(this);">
                       	<script language="javascript">ComComboObject('fm_fm_nod_yd', 1, 45, 0)</script><img src="" width="4" height="1" border="0">
			  <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_frmnode'>
                       	</td>
                    	<td align="right">DEST</td>
                       	<td>&nbsp;<input name="fm_to_nod_cd" type="text" style="width:60;" maxlength="5" onChange="getComboList(this, document.fm_to_nod_yd, 'T');" onBlur="setgetUpper(this);">
<script language="javascript">ComComboObject('fm_to_nod_yd', 1, 48, 0);</script><img src="" width="4" height="1" border="0">
			  <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_tonode'>                       	
                       	</td>
                    </tr>   	
                    <tr class="h23">                       	
                    	<td align="right">SCG Kind</td>
                       	<td>&nbsp;
<select name="sel_scg" style="width:80;">
									<option value="" selected></option>
									<option value="FSG">Fuel</option>
									<option value="ISG">Incentive</option>
									<option value="NFSG">Other</option>
								</select>                       	
                       	</td>  
                    	<td align="right">Effective Date</td>
                       	<td>&nbsp;<input type="text" name="effective_date" style="width:75" value="<%=effective_date%>" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);">
              				<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btng_calendar">
              			</td>         
                    	<td align="right">Delete</td>
                       	<td>&nbsp;
							<select name="delete_yn" style="width:72;">
                            <option value=""  <%if("".equals(delete_yn)) out.println("selected");%>>ALL</option>
							<option value="N" <%if("N".equals(delete_yn)) out.println("selected");%>>N</option>
							<option value="Y" <%if("Y".equals(delete_yn)) out.println("selected");%>>Y</option>
							</select>                       	
                       	</td>                                	                	                     	                       	
                  	</tr>                  
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>

<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="popup" width="100%" cellpadding="10">
	<tr>
		<td class="bg">
		<table class="search" id="mainTable">
			<tr><td>
				<!-- : ( Button : Sub ) (E) -->
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td></tr>
		</table>
    </td></tr>
</table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton" cellpadding="10">
  <tr>
    <td class="popup" valign="top">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
          <td class="btn3_bg" height="71">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_retrieve" id="btng_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
<% 
	if("save".equals(gubun)){	
%>                
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_save" id="btng_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
<%	}	
%>                                
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>