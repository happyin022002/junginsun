<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0232.jsp
*@FileTitle : Agreement Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-18
*@LastModifier : cjh
*@LastVersion : 1.0
* 2010-03-18 cjh
* 1.0 최초 생성
 * History
 * 2010.09.13 최종혁 [CHM-201005934] [TRS] AGMT Verification Error 내용 table 추가 요청
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

	String optionStr2   = "000020::";
	String selTRANSMODE = "";	//Trans Mode Combo
	String selCARGOMODE = "";	//Cargo Type Combo
	String selHJSCNT    = "";	//HJS/CNT Combo
	String selRAILSVC   = "";	//Rail Service Combo

	selTRANSMODE	= JSPUtil.getCodeCombo("fm_agmt_trsp_tp_cd", "01"	,"style=width:80", "CD00283", 0, optionStr2);
	selCARGOMODE	= JSPUtil.getCodeCombo("fm_cgo_tp_cd",			"01"	,"style='width:98;'", "CD00748", 0, optionStr2);
	selHJSCNT		= JSPUtil.getCodeCombo("fm_hjscnt","01"	,"onChange='vndr_change();'  style='width:98;'", "CD00919", 0, optionStr2);
	selRAILSVC		= JSPUtil.getCodeCombo("fm_rail_svc_tp_cd",		"01"	,"style='width:95;'", "CD00916", 1, optionStr2);

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
<title>Agreement Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    loadPage();
  }
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="old_ofc_cd" >
<input type="hidden" name="chk_agmt_no" >
<input type="hidden" name="chk_trsp_agmt_rt_tp_ser_no" >
<input type="hidden" name="chk_trsp_agmt_rt_tp_cd" >
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
      
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
                      <td class="btn1" id="btn_reset" name="btn_reset">Reset</td>
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
  
      <!--biz page (S)-->
      <div id="MiniLayer" style="display:inline">
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">

            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="100">Agreement No.</td>
                <td width="120">
                  <input name="fm_agmtno" type="text" style="width:72;" class="input1" value="" onBlur="setgetUpper(this);">
                  <img name='btn_agmtno' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="108">Service Provider</td>
                <td width="253">
                  <input name="fm_vndr_prmry_seq" type="text" style="width:80;" class="input1" value="" onBlur="vender_blur();">
                  <input name="fm_vndr_prmry_nm" type="text" style="width:117;" class="input" value="" readonly>
                  <img name='btn_serviceprovider' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="97">Contract Office</td>
                <td width="85"><input name="fm_ctrt_ofc_cd" type="text" style="width:80;" class="input1" value="" onkeyup="upper(this)"></td>
                <td><input name="chk_office" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice();">&nbsp;Incl. Sub OFC</td>
              </tr>
            </table>
            <table class="search" border="0" style="width:786;"> 
              <tr class="h23">
                <td width="100">AGMT Type</td>
                <td width="120">
                  <select style="width:95;" class="input" name="fm_trsp_agmt_rt_tp_cd" >
                    <option value="A" selected>ALL</option>
                    <option value="P">P</option>
                    <option value="D">D</option>
                    <option value="PD">PD</option>
                    <option value="DP">DP</option>
                  </select>
                </td>
                <td width="108">Effective AGMT</td>
                <td width="140">
                  <select style="width:80;" class="input" name="fm_effective_agmt" >
                    <option value="C" selected>LATEST</option>
                    <option value="A">ALL</option>
                  </select>
                </td>
                <td width="108">SML/CNT</td>
                <td width="210">
                  <%=selHJSCNT%>
                  <input name="fm_cust_cd" type="text" style="width:80;" class="input1">
                  <img name='btn_vndr_prmry_seq' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="vndr_OnPopupClick();">
                </td>
              </tr>
              <tr class="h23">
                <td width="">Cost Mode</td>
                <td width="">
                  <select style="width:95;" class="input" name="fm_trsp_cost_mod_cd" >
                    <option value="A" selected>ALL</option>
                    <option value="DR">DR</option>
                    <option value="CY">CY</option>
                    <option value="BS">BS</option>
                    <option value="BF">BF</option>
                    <option value="MF">MF</option>
                    <option value="DC">DC</option>
                    <option value="MM">MM</option>
                  </select>
                </td>
                <td width="">Trans Mode</td>
                <td width="">
                  <%=selTRANSMODE%>
                </td>
                <td width="">Cargo Type</td>
                <td width="">
                  <%=selCARGOMODE%>
                </td>
              </tr>
              <tr class="h23">
                <td width="">Rail Service</td>
                <td width="">
                  <%=selRAILSVC%>
                </td>
                <td width="">Commodity Code</td>
                <td>
                  <input name="fm_cmdt_grp_cd" type="text" style="width:80;" class="input1" value="">
                </td>
                <td width="">Surcharge Kind</td>
                <td>
                  <select name="fm_trsp_scg_cd" style="width:98;" class="input">
                    <option value="A" selected>ALL</option>
                    <option value="F">Fuel(FUA,FUE)</option>
                    <option value="O">Others</option>
                  </select>
                </td>
              </tr>
            </table>
          <!--  biz_1   (E) -->
          </td>
        </tr>
      </table>
      </div>
    
      <table class="height_8"><tr><td></td></tr></table>  
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
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet0');</script>
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->

            <!-- : ( Button_ Sub ) (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <!-- Repeat Pattern -->
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_allrateinquiry" name="btng_allrateinquiry">Rate Inquiry By AGMT NO.</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>

                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_rateinquiry" name="btng_rateinquiry">Rate Inquiry</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>

                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_allsurchargeinquiry" name="btng_allsurchargeinquiry">Surcharge Inquiry By AGMT NO.</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>

                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_surchargeinquiry" name="btng_surchargeinquiry">Surcharge Inquiry</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>

                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <!-- Repeat Pattern -->
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- : ( Button_ Sub ) (E) -->
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table class="height_10"><tr><td colspan="8"></td></tr></table>
</form>
</body>
</html>
