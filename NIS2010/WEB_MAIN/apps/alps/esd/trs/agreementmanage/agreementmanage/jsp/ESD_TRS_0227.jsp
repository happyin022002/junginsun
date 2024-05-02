<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0227.jsp
*@FileTitle : Agreement Rate History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2010-03-18 cjh
* 1.0 최초 생성
* HISTORY
*
* 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
* 1.2 2011.06.29 민정호 [CHM-201111442] R9 CNTR 추가관련 로직 변경요청
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception					serverException		= null;			//서버에서 발생한 에러
	String						strErrMsg			= "";								 //에러메세지
	String	userId		= "";
	String	ofcCd		= "";

	String optionStr    = "";
	String selTRANSMODE = "";	//Trans Mode Combo
	String selCARGOMODE = "";	//Cargo Type Combo
	String selRAILSVC   = "";	//Rail Service Combo

	selTRANSMODE	= JSPUtil.getCodeCombo("ufm_agmt_trsp_tp_cd", "01"	,"style='width:98' disabled", "CD00283", 0, optionStr);
	selCARGOMODE	= JSPUtil.getCodeCombo("ufm_cgo_tp_cd",	"01"	,"style='width:98;' disabled", "CD00748", 0, optionStr);
	selRAILSVC		= JSPUtil.getCodeCombo("ufm_rail_svc_tp_cd",		"01"	,"style='width:136;' disabled", "CD00916", 1, optionStr);
	
	String agmt_no            = ((request.getParameter("fm_agmtno")==null )?"":request.getParameter("fm_agmtno"));		
	String trsp_agmt_rt_tp_cd = ((request.getParameter("fm_trsp_agmt_rt_tp_cd")==null )?"":request.getParameter("fm_trsp_agmt_rt_tp_cd"));
	
	String agmt_no2            = ((request.getParameter("agmt_no")==null )?"":request.getParameter("agmt_no"));		
	String trsp_agmt_rt_tp_cd2 = ((request.getParameter("trsp_agmt_rt_tp_cd")==null )?"":request.getParameter("trsp_agmt_rt_tp_cd"));	
	String gubun            = ((request.getParameter("gubun")==null )?"":request.getParameter("gubun"));	
	String route_gubun            = ((request.getParameter("route_gubun")==null )?"":request.getParameter("route_gubun"));	
	if("route".equals(route_gubun)){
		agmt_no = agmt_no2;
		trsp_agmt_rt_tp_cd = trsp_agmt_rt_tp_cd2;
	}
		
	String eq_knd_cd        = ((request.getParameter("fm_eq_knd_cd")==null )?"":request.getParameter("fm_eq_knd_cd"));
	String eqtpsz	        = ((request.getParameter("fm_eqtpsz")==null )?"":request.getParameter("fm_eqtpsz"));		// 추가-민정호
	String trsp_cost_mod_cd = ((request.getParameter("chk_trsp_cost_mod_cd")==null)?"":request.getParameter("chk_trsp_cost_mod_cd"));
	String agmt_trsp_tp_cd  = ((request.getParameter("chk_agmt_trsp_tp_cd")==null)?"":request.getParameter("chk_agmt_trsp_tp_cd"));
	String cgo_tp_cd        = ((request.getParameter("chk_cgo_tp_cd")==null)?"":request.getParameter("chk_cgo_tp_cd"));
	String cust_cd          = ((request.getParameter("chk_cust_cd")==null)?"":request.getParameter("chk_cust_cd"));
	String cmdt_grp_cd      = ((request.getParameter("chk_cmdt_grp_cd")==null)?"":request.getParameter("chk_cmdt_grp_cd"));
	String rail_svc_tp_cd   = ((request.getParameter("chk_rail_svc_tp_cd")==null)?"":request.getParameter("chk_rail_svc_tp_cd"));
	String fm_nod_cd        = ((request.getParameter("chk_fm_nod_cd")==null)?"":request.getParameter("chk_fm_nod_cd"));
	String fm_nod_yd        = ((request.getParameter("chk_fm_nod_yd")==null)?"":request.getParameter("chk_fm_nod_yd"));
	String via_nod_cd       = ((request.getParameter("chk_via_nod_cd")==null)?"":request.getParameter("chk_via_nod_cd"));
	String via_nod_yd       = ((request.getParameter("chk_via_nod_yd")==null)?"":request.getParameter("chk_via_nod_yd"));
	String dor_nod_cd       = ((request.getParameter("chk_dor_nod_cd")==null)?"":request.getParameter("chk_dor_nod_cd"));
	String dor_nod_yd       = ((request.getParameter("chk_dor_nod_yd")==null)?"":request.getParameter("chk_dor_nod_yd"));
	String to_nod_cd        = ((request.getParameter("chk_to_nod_cd")==null)?"":request.getParameter("chk_to_nod_cd"));
	String to_nod_yd        = ((request.getParameter("chk_to_nod_yd")==null)?"":request.getParameter("chk_to_nod_yd"));
	String trsp_dist_tp_cd  = ((request.getParameter("chk_trsp_dist_tp_cd")==null)?"":request.getParameter("chk_trsp_dist_tp_cd"));
	String trsp_agmt_dist   = ((request.getParameter("chk_trsp_agmt_dist")==null)?"":request.getParameter("chk_trsp_agmt_dist"));
	String dist_meas_ut_cd  = ((request.getParameter("chk_dist_meas_ut_cd")==null)?"":request.getParameter("chk_dist_meas_ut_cd"));

	String effective_date   = ((request.getParameter("effective_date")==null)?"":request.getParameter("effective_date"));	// 추가-민정호
	String delete_yn   = ((request.getParameter("delete_yn")==null)?"":request.getParameter("delete_yn"));	// 추가-민정호	
	
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
%>

<html>
<head>
<title>Agreement Rate History Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  var fm_nod_yd = "";
  function setupPage(){
    loadPage();
    
    var formObject = document.form;
    formObject.ufm_agmtno.value = "<%=agmt_no%>";
    formObject.ufm_trsp_agmt_rt_tp_cd.value = "<%=trsp_agmt_rt_tp_cd%>";
    formObject.ufm_trsp_cost_mod_cd.value = "<%=trsp_cost_mod_cd%>";
    formObject.ufm_agmt_trsp_tp_cd.value = "<%=agmt_trsp_tp_cd%>";
    formObject.ufm_cgo_tp_cd.value = "<%=cgo_tp_cd%>";
    formObject.ufm_cust_cd.value = "<%=cust_cd%>";
    formObject.ufm_cmdt_grp_cd.value = "<%=cmdt_grp_cd%>";
    formObject.ufm_rail_svc_tp_cd.value = "<%=rail_svc_tp_cd%>";
    
    formObject.fm_eq_knd_cd.value = "<%=eq_knd_cd%>";
    formObject.fm_eqtpsz.value = "<%=eqtpsz%>";						// 추가-민정호
    formObject.fm_fm_nod_cd.value = "<%=fm_nod_cd%>";
    formObject.fm_via_nod_cd.value = "<%=via_nod_cd%>";
    formObject.fm_dor_nod_cd.value = "<%=dor_nod_cd%>";
    formObject.fm_to_nod_cd.value = "<%=to_nod_cd%>";
//    formObject.fm_trsp_dist_tp_cd.value = "<%=trsp_dist_tp_cd%>";
//    formObject.fm_trsp_agmt_dist.value = "<%=trsp_agmt_dist%>";
//    formObject.fm_dist_meas_ut_cd.value = "<%=dist_meas_ut_cd%>";
    
    getComboList(formObject.fm_fm_nod_cd, document.fm_fm_nod_yd, 'F');
    getComboList(formObject.fm_via_nod_cd, document.fm_via_nod_yd, 'V');
    getComboList(formObject.fm_dor_nod_cd, document.fm_dor_nod_yd, 'D');
    getComboList(formObject.fm_to_nod_cd, document.fm_to_nod_yd, 'T');
    formObject.fm_fm_nod_yd.CODE = "<%=fm_nod_yd%>";
    formObject.fm_via_nod_yd.CODE = "<%=via_nod_yd%>";
    formObject.fm_dor_nod_yd.CODE = "<%=dor_nod_yd%>";
    formObject.fm_to_nod_yd.CODE = "<%=to_nod_yd%>";
    	    
  }
  
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">

<input type="hidden" name="fm_agmtno"	  			value="<%=agmt_no%>">
<input type="hidden" name="fm_trsp_agmt_rt_tp_cd"	value="<%=trsp_agmt_rt_tp_cd%>">
<input type="hidden" name="fm_trsp_cost_mod_cd"	  	value="<%=trsp_cost_mod_cd%>">
<input type="hidden" name="fm_agmt_trsp_tp_cd"	  	value="<%=agmt_trsp_tp_cd%>">
<input type="hidden" name="fm_cgo_tp_cd"	  		value="<%=cgo_tp_cd%>">
<input type="hidden" name="fm_cust_cd"	  			value="<%=cust_cd%>">
<input type="hidden" name="fm_cmdt_grp_cd"	  		value="<%=cmdt_grp_cd%>">
<input type="hidden" name="fm_rail_svc_tp_cd"	  	value="<%=rail_svc_tp_cd%>">

<input type="hidden" name="f_cmd" >
<input type="hidden" name="TRSP_SO_EQ_KIND" 		value="">
<input type="hidden" name="gubun" 					value="<%=gubun%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td>
      <!-- TABLE (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Agreement Rate History Inquiry</td></tr>
      </table>
      <!-- TABLE (E) -->
      
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
        </table>
      </td></tr>
      </table>
      <!--Button (E) -->
  
      <div id="MiniLayer" style="display:inline">
      <!--biz page (S)-->
      <table class="height_8"><tr><td></td></tr></table>  
      <!--  biz_1  (S) -->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:950;"> 
              <tr class="h23">
                <td width="" valign="top">
                  <table class="search" border="0" style="width:100%;">
                    <tr class="h23">
                      <td width="95" colspan="2">Agreement No.</td>
                      <td width="110"><input name="ufm_agmtno" type="text" style="width:98;" readonly></td>  
                      <td width="80" colspan="2">AGMT Type</td>
                      <td width="100">
                        <select style="width:98;" class="input" name="ufm_trsp_agmt_rt_tp_cd" disabled>
                          <option value="P">Pair</option>
                          <option value="D">Distance</option>
                          <option value="PD">Pair/Distance</option>
                          <option value="DP">Distance/Pair</option>
                        </select>
                      </td>  
                      <td width="80" colspan="2">Cost Mode</td>
                      <td width="100">
                        <select style="width:98;" class="input" name="ufm_trsp_cost_mod_cd" disabled>
                          <option value="DR">DR</option>
                          <option value="CY">CY</option>
                          <option value="BS">BS</option>
                          <option value="BF">BF</option>
                          <option value="MF">MF</option>
                        </select>
                      </td>  
                      <td width="77">Trans Mode</td>
                      <td width="100" colspan="2"><%=selTRANSMODE%></td>  
                    </tr>
                  
                    <tr class="h23">
                      <td colspan="2">Cargo Type</td>
                      <td><%=selCARGOMODE%></td>   
                      <td colspan="2">Customer Code</td>
                      <td><input name="ufm_cust_cd" type="text" style="width:98;" disabled></td>  
                      <td colspan="2">Commodity Group Code</td>
                      <td><input name="ufm_cmdt_grp_cd" type="text" style="width:98;" disabled></td>
                      <td>Rail Service</td>
                      <td colspan="2"><%=selRAILSVC%></td>  
                    </tr>

                    <tr class="h23">
                      <td colspan="2">From</td>
                      <td>
                        <input name="fm_fm_nod_cd" type="text" style="width:50;" class="input" onChange="getComboList(this, document.fm_fm_nod_yd, 'F');" onBlur="setgetUpper(this);">&nbsp;
                        <script language="javascript">ComComboObject('fm_fm_nod_yd', 1, 44, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0">
                      </td>
                      <td colspan="2">Via</td>
                      <td>
                        <input name="fm_via_nod_cd" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.fm_via_nod_yd, 'V');" onBlur="setgetUpper(this);">&nbsp;
                        <script language="javascript">ComComboObject('fm_via_nod_yd', 1, 44, 0);</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0">
                      </td>
                      <td colspan="2">Door</td>
                      <td>       
                        <input name="fm_dor_nod_cd" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.fm_dor_nod_yd, 'D');" onBlur="setgetUpper(this);">&nbsp;
                        <script language="javascript">ComComboObject('fm_dor_nod_yd', 1, 44, 0)</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0">
                      </td>
                      <td colspan="2">To</td>
                      <td>
                        <input name="fm_to_nod_cd" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.fm_to_nod_yd, 'T');" onBlur="setgetUpper(this);">&nbsp;
                        <script language="javascript">ComComboObject('fm_to_nod_yd', 1, 44, 0);</script><img src="/hanjin/img/blank.gif" width="4" height="1" border="0">
                      </td>
                    </tr>
                    
                    <tr class="h23">
                      <td colspan="2">Effective date</td>
                      <td>
              	<input type="text" name="effective_date" style="width:75" value="<%=effective_date%>" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);">
              	<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">                      
                      </td>  
                      <td colspan="2">EQ</td>
                      <td colspan="3">
                        <select style="width:90;" class="input" name="fm_eq_knd_cd" >
                          <option value=""></option>
                          <option value="U">Container</option>
                          <option value="Z">Chassis</option>
                          <option value="G">Genset</option>
                        </select>
					    <script language="javascript">ComComboObject('combo1', 1, 170, 1)</script>
					    <input type="hidden" name="fm_eqtpsz" value="">                          
                      </td>  
                      </td>
                      <td colspan="2">Delete&nbsp;<select name="delete_yn" style="width:52;">
                            <option value=""  <%if("".equals(delete_yn)) out.println("selected");%>>ALL</option>
							<option value="N" <%if("N".equals(delete_yn)) out.println("selected");%>>N</option>
							<option value="Y" <%if("Y".equals(delete_yn)) out.println("selected");%>>Y</option>
							</select></td>
                      <td>                      
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="50"></td>
              </tr>
              <tr><td></td></tr>
            </table>
          </td>
        </tr>
      </table>
      <!--  biz_1   (E) -->
      </div>
    </td>
  </tr>
</table>

<table class="height_8"><tr><td></td></tr></table>  

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"> 
  <tr>
    <td>
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">

            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr width="100%">
                <td width="100%">
                 <script language="javascript">ComSheetObject('sheet0');</script>
                </td>
                <td width="1%"></td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->			
<table width="100%" class="sbutton" cellpadding="10">
  <tr>
    <td class="popup" valign="top">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
          <td class="btn3_bg" height="71">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
<% 
	if("save".equals(gubun)){	
%>			              
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
<%
	}
%>	                
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_download">Download</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
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
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<script language="javascript">ComSheetObject('sheet_tpsz');</script>
</form>
</body>
</html>
