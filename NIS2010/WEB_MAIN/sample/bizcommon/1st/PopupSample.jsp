<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<!--==============================================================================
'주  시 스 템 : 
'서브  시스템 : 샘플
'프로그램 ID  : PopupSample.html
'프로그램 명  : javascript 샘플 구성
'프로그램개요 : javascript 샘플 구성 화면 이벤트들을 수행한다.
'작   성   자 : 박상률/2006.08.03
'작   성   일 : 
==================================================================================
'수정자/수정일 : 
'수정사유/내역 : 
==============================================================================-->
<% 
//2015.06.18 partner.hanjin.com security essue
//System.out.println(request.getHeader("host"));
//System.out.println(account == null);

String sppDomain = SiteConfigFactory.get("COM.SPP.DOMAIN");
String sppLoginJsp = SiteConfigFactory.get("COM.SPP.LOGIN.JSP");
  
if(sppDomain != null && request.getHeader("host").contains(sppDomain)){%>
  <script>
    document.location.href = '<%=sppLoginJsp%>';
  </script>
<%
	return;
  }
%>
<html>
<head>
<title>팝업 샘플</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script language="javascript" type="text/javascript" src="/hanjin/js/CoMessage.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoCommon.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoFormControl.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoPopup.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoCalendar.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoObject.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/IBSheetInfo.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoWait.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoBiz.js"></script>
<script language="javascript" type="text/javascript" src="PopupSample.js"></script>

<style type="text/css">
<!--
.functionName {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12pt;
	font-style: normal;
	font-weight: bold;
	color: #0066CC;
}
td {
	font-size: 11pt;
	line-height: 150%;
}
.td-title {
	background-color: #F1D1C9;
}

a:link {text-decoration: none;color:#333333}
a:visited {text-decoration: none;color:#333333}
a:active {text-decoration: none;color:#F8352C}
a:hover {text-decoration:none;color:#F8352C;}

-->
</style>
</head>
<body style="margin-left:10">
<form name="theForm" style="width:800;">
<A name=TOP>
  <br><h1>Hanjin Popup Sample</h1><br><br>
  
  <BR><HR>
  <B>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;※ BIZ 공통 목록 <BR>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_011">01. Commodity (COM_ENS_011)(완료)<BR></A>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_021">02. Contract (COM_ENS_021)(완료)<BR></A>

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_041">04. Customer (COM_ENS_041)(완료)<BR></A> 
  <!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_042">04. Actual Customer (COM_ENS_042)(완료)<BR></A>-->
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_051">05. Location (COM_ENS_051)(완료)<BR></A>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_061">06. Node (COM_ENS_061)(완료)<BR></A>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_071">07. Office (COM_ENS_071)(완료)<BR></A>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_081">08. Lane (COM_ENS_081)(완료)<BR></A>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_091">09-01. Staff (COM_ENS_091)(완료)<BR></A>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_092">09-02. Notified Subscriber (COM_ENS_092)(완료)<BR></A>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_0A1">10. Vessel (COM_ENS_0A1)(완료)<BR></A>

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_0B2">11. VVD (COM_ENS_0B2)(완료)<BR></A>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="#COM_ENS_0C1">12. Service Provider (COM_ENS_0C1)(완료)<BR></A>
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;※ 관련 샘플 추가  <BR>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href="./sample_ibsheet/UI_ESD_PRD_004.html" target="_blank">01. IB시트 Cell에서의 Biz 공통 팝업 호출 <BR></A>
  </B>
  
  <BR><HR>
  
  <BR><BR>
  
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td valign="top" height="475"><h3>▶ javascript 사용 예제</h3>

<A name=COM_ENS_011>        
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="4" bgcolor="#F1D1C9"><b>01. Commodity (COM_ENS_011)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="150">
            	Commodity Code:<br>
            	REP Commodity:<br>
            	IMDG CLASS:<br>
            	Keyword:<br>
            	Display Option:
            </td>
            <td width="550" bgcolor="#EFEFEF">
              <input name="cmdt_cd" type="text" size="50" style="height:22"><br>
              <input name="rep_cmdt_cd" type="text" size="50" style="height:22"><br>
              <select style="width:50;" name="rep_imdg_lvl_cd">&nbsp;
						<option value="" selected>ALL</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						</select>
			  <br>
              <input name="cmdt_nm" type="text" size="50" style="height:22"><br>
              <input name="cmdt_dispaly" type="text" size="20" maxlength="13" value="1,0,1,1,1,1,1" style="height:22">
              <input name="cmdt_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기"></td>
          </tr>
<tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
              - IB Sheet Cell에서의 공통 팝업창 호출 (<b><font color="blue">상기 예의 경우 Port</font></b>) <br>
              <br>
              - 메소드 정의 : function ComOpenPopupInSheet(url, width, height, func, dispaly, row, col)
              <br>
* @param {string} sUrl 필수,호출될 팝업 주소 <br>
* @param {int} iWidth 필수,팝업 창의 넓이 <br>
* @param {int} iHeight 필수,팝업 창의 높이 <br>
* @param {string} sFunc 필수,팝업에서 최종 확인을 했을때 데이터를 받을 부모창(opener)의 자바스크립트 함수명 <br>
* @param {string} sDisplay 필수,팝업창에 있는 그리드의 컬럼 히든여부 설정(1:보임, 0:숨김) <br>
* @param {bool} bModal 선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false <br>
* @param {bool} b2ndSheet 선택,Sheet 2개인 팝업 오픈시 true 1개인 팝업 오픈시 false, default=false <br>
* @param {int} iRow 선택,Sheet의 Cell의 Row Index <br>
* @param {int} iCol 선택,Sheet의 Cell의 Col Index <br>
* @param {int} iSheetIdx 선택,Sheet의 sheetObjects 배열 Index <br>
* @returns object<br>
* bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object <br>
* bModal=true로 오픈된 경우 리턴값 : 팝업창의 window.returnValue값 <br> 
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
            	<pre>
"0,1"로 하면 popup에서 컬럼명이 checkbox를 찾고,
1,0이면 컬럼명이 radio 컬럼을 찾으며,
0,0이면 선택된 row를 찾아서 return합니다. 
ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 778, 450, 'getCOM_ENS_011_1', dispaly, true);
            	</pre>
            </td>
          </tr>
        </table>
        <br>
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_021><BR><BR>        
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="4" bgcolor="#F1D1C9"><b>02. Contract (COM_ENS_021)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="100">
            	Contract No:<br>
            	CustomerName:<br>
            	Display Option:
            </td>
            <td width="600" bgcolor="#EFEFEF">
              <input name="cnt_txt1" type="text" size="3" maxlength="3" value=""> <input name="cnt_txt2" type="text" size="6" maxlength="6"><br>
              <input name="cnt_txt5" type="text" size="50"><br>
              <input name="cnt_display" type="text" size="15" value="1,0,1,1,1,1,1,1" maxlength="15">(예: 1,0,1,1,1,1,1,1)&nbsp&nbsp
              <input name="cnt_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기"></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : display- 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
            	<pre>
예). display 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,1,1,1,1'
ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 778, 440, 'getCOM_ENS_021_1', display, true);
            	</pre>
            </td>
          </tr>
        </table>
        <br>             
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_041><BR><BR>        
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="4" bgcolor="#F1D1C9"><b>04. Customer (COM_ENS_041)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="100">
            	Customer Code:<br>
            	Sales Office:<br>
            	Customer Name:<br>
            	Display Option:
            </td>
            <td width="600" bgcolor="#EFEFEF">
              <input name="cust01_txt1" type="text" size="50" value=""><br>
              <input name="cust01_txt3" type="text" size="50"><br>                     
              <input name="cust01_txt4" type="text" size="50"><br>
              <input name="cust01_display" type="text" size="20" value="1,0,1,1,1,1,1,1,1,1" maxlength="19">(예: 1,0,1,1,1,1,1,1,1,1)&nbsp&nbsp
              <input name="cust01_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기"></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : display- 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
            	<pre>
예). display 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,1,1,1,1,1,1'
ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 768, 400, 'getCOM_ENS_041_1', display);
            	</pre>
            </td>
          </tr>
        </table>
        <br>        
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_051><BR><BR>
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="4" bgcolor="#F1D1C9"><b>05. Location (COM_ENS_051)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="100">
            	Conti:<br>
            	Sub Conti:<br>
            	Country:<br>
            	State:<br>
            	Control Office:<br>
            	Loc Code:<br>
            	Loc Name:<br>
            	Port Only:<br>
            	System:<br>
            	Display Option:
            </td>
            <td width="600" bgcolor="#EFEFEF">
              <input name="com_ens_051_conti_cd" type="text" size="50" style="height:22"><br>
              <input name="com_ens_051_sconti_cd" type="text" size="50" style="height:22"><br>
              <input name="com_ens_051_cnt_cd" type="text" size="50" style="height:22"><br>
              <input name="com_ens_051_loc_state" type="text" size="50" style="height:22"><br>
              <input name="com_ens_051_loc_eq_ofc" type="text" size="50" style="height:22"><br>
              <input name="com_ens_051_loc_cd" type="text" size="50" style="height:22"><br>
              <input name="com_ens_051_loc_desc" type="text" size="50" style="height:22"><br>
              <input name="com_ens_051_loc_port_ind" type="checkbox" value="1"><br>
              <select name="com_ens_051_sys_code" style="width:150;">&nbsp;
				<option value="ENIS" selected>e-NIS</option>
				<option value="BMS">BMS</option>
			  </select><br>	
              <input name="com_ens_051_dispaly" type="text" size="20" value="1,0,1,1,1,1,1,1,1,1,1,1" maxlength="23" style="height:22">
              <input name="com_ens_051_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기"></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : dispaly   - 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
            	<pre>
예). dispaly 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,0,1,1,1,1,0,1,1'
ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 410, 'getCOM_ENS_051_1', dispaly);
            	</pre>
            </td>
          </tr>
        </table>
        <br>
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_061><BR><BR>
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="4" bgcolor="#F1D1C9"><b>06. Node (COM_ENS_061)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="150">
            	Country :<br>
            	Location :<br>
            	Control Office :<br> 
            	Node :<br>
            	Node Name :<br>
            	Yard/Zone :<br>
            	Search Yard/Zone Only :<br>
            	Display Option:
            </td>
            <td width="550" bgcolor="#EFEFEF">
              <input name="com_ens_061_cnt_cd" type="text" size="20" style="height:22"><br>
              <input name="com_ens_061_loc_cd" type="text" size="20" style="height:22"><br>
              <input name="com_ens_061_ofc_cd" type="text" size="20" style="height:22"><br>
              <input name="com_ens_061_node_cd" type="text" size="20" style="height:22"><br>
              <input name="com_ens_061_node_nm" type="text" size="20" style="height:22"><br>
              <input name="com_ens_061_mode" type="radio" value="yard" checked onClick="javascript:chgCom_ens_061_mode();">Yard 
              <input name="com_ens_061_mode" type="radio" value="zone" onClick="javascript:chgCom_ens_061_mode();">Zone<br>            
              <input name="com_ens_061_mode_only" type="checkbox" value="Y"> (체크시 Yard/Zone 선택조회 불가함)
              <br>
              <script>
              	function chgCom_ens_061_mode() {              		
              		if(document.all.com_ens_061_mode[0].checked) {
              			document.all.com_ens_061_display.value = "1,0,1,1,1,1,1,1,1,1,1,1";
              			document.all.divCom_ens_061_mode.innerText = "1,0,1,1,1,1,1,1,1,1,1,1";
              			document.all.com_ens_061_display.maxLength = 23;
              		} else {
              			document.all.com_ens_061_display.value = "1,0,1,1,1,1,1,1,1,1";
              			document.all.divCom_ens_061_mode.innerText = "1,0,1,1,1,1,1,1,1,1";
              			document.all.com_ens_061_display.maxLength = 19;
              		}
              	}
	          </script>
              <input name="com_ens_061_display" type="text" size="20" maxlength="23" value="1,0,1,1,1,1,1,1,1,1,1,1" style="height:22">(예: <div id="divCom_ens_061_mode" style="display:inline">1,0,1,1,1,1,1,1,1,1,1,1</div>)&nbsp&nbsp
              <input name="com_ens_061_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기"></td>
          </tr>          
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : display- 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
            	<pre>
예). display 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,1,1,1,1,1,1,1,1'
ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 425, 'getCOM_ENS_061_1', display);
            	</pre>
            </td>
          </tr>
        </table>
        <br>             
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_071><BR><BR>
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="4" bgcolor="#F1D1C9"><b>07. Office (COM_ENS_071)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="150">
            	<!-- Call TYpe:<br>-->
            	Office Type:<br>
            	Parent Office:<br>
            	Office Code:<br>
            	Office Name:<br>            	
            	Display Option:
            </td>
            <td width="550" bgcolor="#EFEFEF">              		  
              <select name=ofc_lev style="width:60;">&nbsp;
				<option value="1" selected>SHQ</option>
				<option value="2">RHQ</option>
				<option value="3">GOF</option>
				<option value="4">SOF</option>
				<option value="5">LOF</option>
				<option value="6">AGT</option>
			  </select>			  
			  <br>
              <input name="ofc_pts_cd" type="text" size="50" style="height:22"><br>
              <input name="ofc_cd" type="text" size="50" style="height:22"><br>
              <input name="ofc_nm" type="text" size="50" style="height:22"><br>
              <input name="ofc_dispaly" type="text" value="1,0,1,1,1,1,1,1" size="18" maxlength="15" style="height:22">
              <input name="ofc_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기"></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : dispaly   - 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
            	<pre>
예). dispaly 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,0,1,1,1'
ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 770, 410, 'getCOM_ENS_071_1', dispaly);
            	</pre>
            </td>
          </tr>
        </table>
        <br>
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_081><BR><BR>
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="6" bgcolor="#F1D1C9"><b>08. Lane (COM_ENS_081)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="100">
            	Lane Kind :<br>
            	<div id="divRevLane" style="display:inline">
            	Trade :<br>
            	Sub Trade :<br>
            	</div>
            	Lane Code :<br>
            	Lane Name :<br>
            	SVC Type :<br>
            	Display Option:
            </td>
            <td width="600" bgcolor="#EFEFEF">
              <select name="com_ens_081_mode" onChange="javascript:chgLaneMode(this);">
              	<option value="rev" selected>Revenue Lane</option>
              	<option value="svc">Service Lane</option>
              </select><br>
              <script>				              	
				function chgLaneMode(Object) {				    
				    var divList = eval("divRevLane");				    
				    if(divList.length) {				        
				        for(var i=0; i<divList.length; i++) {				            
				            if(Object.value == "rev") {
				                divList[i].style.display = "inline";
				            } else {
				                divList[i].style.display = "none";
				            }
				        }
				    }
				}
              </script>
              <div id="divRevLane" style="display:inline">
              <input name="com_ens_081_trade_cd" type="select" size="20" style="height:22"><br>
              <input name="com_ens_081_sub_trade_cd" type="select" size="20" style="height:22"><br>
              </div>
              <input name="com_ens_081_lane_cd" type="select" size="20" style="height:22"><br>
              <input name="com_ens_081_lane_nm" type="text" size="20" style="height:22"><br>
              <select name="com_ens_081_svc_tp">
              	<option selected value="">ALL</option>
              	<option value="I">Indepedent Join</option>
              	<option value="J">Joint Operation</option>
              	<option value="S">Space Charter</option>
              	<option value="O">Off Lane</option>
              </select><br>              
              <!-- input name="com_ens_081_lane_tp" type="radio">Off Lane <input name="com_ens_081_lane_tp" type="radio" checked>Lane <br-->
              <input name="com_ens_081_display" type="text" size="20" maxlength="15" value="1,0,1,1,1,1,1,1" style="height:22">(예: 1,0,1,1,1,1,1,1)&nbsp&nbsp
              <input name="com_ens_081_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기">
            </td>
            <td width="50" bgcolor="#F5E7C5" align="center">
            	출력
            </td>
            <td width="270" bgcolor="#EFEFEF">
              ▶ <b>Revenue Lane</b><br>
            	1) rln_trade_cd : Trade 코드<br>
            	2) rln_sub_trade_cd  : Sub Trade 코드<br>
            	3) rlane_cd  : Revenue Lane 코드<br>
            	4) rlane_nm  : Revenue Lane 명<br>
            	2) vsl_tp_cd : Revenue Lane 타입<br>
              ▶ <b>Service Lane</b><br>
            	1) vsl_slan_cd   : Service Lane 코드<br>
            	2) vsl_slan_nm   : Service Lane 명<br>
            	3) vsl_svc_tp_cd : Service Lane 타입<br>
            	4) co_cd  : 선사 코드<br>
            </td>
          </tr>          
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="6">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : display- 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="6">
            	<pre>
예). display 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,1,1,1,1'
ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 420, 'getCOM_ENS_081_1', display);
            	</pre>
            </td>
          </tr>
        </table>
        <br>             
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_091><BR><BR>
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="6" bgcolor="#F1D1C9"><b>09-01. Staff (COM_ENS_091)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="100">
            	Office Code :<br>            	
            	User Code :<br>
            	User Name :<br>
            	E-Mail :<br>
            	Display Option:
            </td>
            <td width="600" bgcolor="#EFEFEF">              
              <input name="com_ens_091_ofc_cd" type="text" size="20" style="height:22"><br>
              <input name="com_ens_091_user_cd" type="select" size="20" style="height:22"><br>
              <input name="com_ens_091_user_nm" type="select" size="20" style="height:22"><br>
              <input name="com_ens_091_user_email" type="select" size="20" style="height:22"><br>
              <input name="com_ens_091_display" type="text" size="20" maxlength="11" value="1,0,1,1,1,1" style="height:22">(예: 1,0,1,1,1,1)&nbsp&nbsp
              <input name="com_ens_091_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기">
            </td>            
          </tr>          
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="6">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : display- 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="6">
            	<pre>
예). display 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,1,1,1,1'
ComOpenPopup('/hanjin/COM_ENS_091.do' + param, 780, 535, 'getCOM_ENS_091_1', display,true, true);
            	</pre>
            </td>
          </tr>
        </table>
        <br>             
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_092><BR><BR>
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="6" bgcolor="#F1D1C9"><b>09-02. Notified Subscriber (COM_ENS_092)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="100">
            	User ID :<br>
            	E-Mail :
            </td>
            <td width="600" bgcolor="#EFEFEF">              
              <input name="com_ens_092_user_id" type="select" size="20" style="height:22"><br>
              <input name="com_ens_092_user_email" type="select" size="20" style="height:22">
              <input name="com_ens_092_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기">
            </td>            
          </tr>          
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="6">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : display- 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)<br>
              => Notified Subscriber 의 경우 display를 'none'으로 세팅한다.              
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="6">
            	<pre>
예). display 속성 -> 'none'
ComOpenPopup('/hanjin/COM_ENS_092.do' + param, 810, 450, 'getCOM_ENS_092', '1,0,1,1,1,1,0,0,0,0,0,0,0,0,0', true);
            	</pre>
            </td>
          </tr>
        </table>
        <br>             
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_0A1><BR><BR>	  
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="4" bgcolor="#F1D1C9"><b>10. Vessel (COM_ENS_0A1)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="100">
            	Vessel Code:<br>
            	Vessel Name:<br>
            	Carrier:<br>
            	Display Option:
            </td>
            <td width="600" bgcolor="#EFEFEF">
              <input name="sp1_txt1" type="text" size="50" value=""><br>
              <input name="sp1_txt2" type="text" size="50"><br>
              <input name="sp1_txt3" type="text" size="50"><br>
              <input name="sp1_display" type="text" value="1,0,1,1,1,1,1" size="8" maxlength="13">(예: 1,0,1,1,1,1,1)&nbsp&nbsp
              <input name="sp1_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기"></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : display- 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr> 
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
            	<pre>
예). display 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,0,1,1'
ComOpenPopup('/hanjin/COM_ENS_0A1.do' + param, 618, 420, 'getCOM_ENS_0A1_1', display);	// radio PopUp  
            	</pre>
            </td>
          </tr>
        </table>
        <br>
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_0B2><BR><BR>
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="6" bgcolor="#F1D1C9"><b>11. VVD (COM_ENS_0B2)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="100">
            	ETD / ETA :<br>
            	Period :<br> 
            	LANE :<br>
            	VVD :<br>
            	PORT :<br>
            	Operator :<br>
            	Display Option:
            </td>
            <td width="600" bgcolor="#EFEFEF">
              <select name="vslskd02_etdeta" style="width:60; height:22">&nbsp;
				<option value="D" selected>ETD</option>
				<option value="A">ETA</option>
			  </select><br>
              <input name="vslskd02_sdate" type="text" size="10" style="height:22" value="">              
              <img class="cursor" src="/hanjin/img/enis/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="vslskd02_calendar1">
              ~              
              <input name="vslskd02_edate" type="text" size="10" style="height:22" value="">
              <img class="cursor" src="/hanjin/img/enis/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="vslskd02_calendar2"><br>
              <input name="vslskd02_lane" type="text" size="20" style="height:22"><br>
              <input name="vslskd02_vvd" type="text" size="20" style="height:22"><br>
              <input name="vslskd02_loc" type="text" size="20" style="height:22" value=""><br>
              <input name="vslskd02_oper" type="text" size="20" style="height:22"><br>

              <input name="vslskd02_display" type="text" size="20" maxlength="20" value="1,0,1,1,1,1,1,1" style="height:22">(예: 1,0,1,1,1,1,1,1)&nbsp&nbsp
              <input name="vesselskd02_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기">
            </td>
            <td width="50" bgcolor="#F5E7C5" align="center">
            	출력
            </td>
            <td width="270" bgcolor="#EFEFEF">
            	1) slan_cd : Lane 코드<br>
            	2) vps_port_cd  : Port 코드<br>
            	3) vps_etd_dt : ETD date<br>
            	4) vps_eta_dt : ETA date<br>
            	5) vvd : VVD 코드<br>
            </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="6">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : display- 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="6">
            	<pre>
예). display 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,1,1,1,1'
ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 770, 400, 'getCOM_ENS_0B2_1', display);
            	</pre>
            </td>
          </tr>
        </table>
        <br>             
<A href="#TOP">↑ Top<BR></A>

<A name=COM_ENS_0C1><BR><BR>
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <td colspan="4" bgcolor="#F1D1C9"><b>12. Service Provider (COM_ENS_0C1)</b> </td>
          <tr>
            <td width="100"  bgcolor="#F5E7C5" align="center">입력</td>
            <td width="200">
            	Country:<br>
            	Service Provider Code:<br>
            	Service Provider Name:<br>
            	Control Office:<br>
            	Parent Service Provider Code:<br> 
            	Original Service Provider Code:<br> 
            	Display Option:
            </td>
            <td width="600" bgcolor="#EFEFEF">
              <input name="sp_txt1" type="text" size="10"><br> 
              <input name="sp_vndr_cd" type="text" size="50"><br>             
              <input name="sp_txt2" type="text" size="50"><br>
              <input name="sp_txt4" type="text" size="10"><br>
              <input name="sp_txt5" type="text" size="10" maxlength="8"><br>
              <input name="sp_txt6" type="text" size="10" maxlength="8"><br>
              <input name="sp_display" type="text" size="20" maxlength="20" value="1,0,1,1,1">(예: 1,0,1,1,1)&nbsp&nbsp
              <input name="sp_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기"></td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
              - 공통 팝업창 호출 <br>
              @param : url    - 호출될 팝업 주소 <br>
              @param : width  - 팝업 넓이 <br>
              @param : height - 팝업 높이 <br>
              @param : func   - 팝업에서 최종 확인을 했을때 데이터를 받을 부모창의 메소드명 <br>
              @param : display- 팝업 그리드의 컬럼 히든여부 설정 (1:보임, 0:숨김) <br>
              radio화면 = '1,0,...' &nbsp&nbsp&nbsp check화면 = '0,1,...' &nbsp&nbsp&nbsp radio, check가 필요없는 화면 = '0,0,...'<br>
              @param : bModal  - 팝업의 Modal 여부 (true:Modal, false:일반팝업) <br>
              <br>
              function ComOpenPopup(url, width, height, func, display, bModal)
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
            	<pre>
예). display 속성(radio:1, check:0)을 다음과 같이 한다 -> '1,0,1,1,1'
ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 450, 'getCOM_ENS_0C1', '1,0,1,1,1', true);
            	</pre>
            </td>
          </tr>
        </table>
        <br>             
<A href="#TOP">↑ Top<BR></A>


        </td>
    </tr>
  </table>
</form>
</body>
</html>