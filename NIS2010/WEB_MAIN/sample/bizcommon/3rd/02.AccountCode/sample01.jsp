<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<!--==============================================================================
'주  시 스 템 : 
'서브  시스템 : 샘플
'프로그램 ID : sample_approval_route.jsp
'프로그램 명  : javascript 샘플 구성
'프로그램개요 : javascript 샘플 구성 화면 이벤트들을 수행한다.
'작   성   자 : 노형춘
'작   성   일 : 2007.03.09
==================================================================================
'수정자/수정일 : 
'수정사유/내역 : 
==============================================================================-->
<html>
<head>
<title>팝업 샘플</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script language="javascript" type="text/javascript" src="/hanjin/js/CoMessage.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoAxon.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoCommon.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoFormControl.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoPopup.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoCalendar.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoObject.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/IBSheetInfo.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoWait.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoBiz.js"></script>
<script language="javascript" src="sample01.js"></script>

<link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>
<body style="margin-left:20; margin-top:50">
<form name="form" style="width:800;">
  
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td valign="top" height="475">       
        <table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#D0B0AC">
          <tr>
          <th colspan="4"><b>02. Account Code</b> </th>
          </tr>
<tr>
	<td width="180" class="title">
          		Account:<br>
            	Description:<br>
            	Display Option:
            </td>
            <td width="520" bgcolor="#EFEFEF">
              <input name="acct_cd" type="text" size="10" maxlength=6 style="height:22"><br>
              <input name="acct_eng_nm" type="text" size="10" maxlength=6 style="height:22"><br>
              <input name="dispaly" type="text" size="20" maxlength="13" value="0,0" style="height:22" readonly>
              <input name="cnt_btn" type="button" class="button" value="클릭">
              <input type="button" onclick="reset()" value="지우기">
              </td>
          </tr>
          <tr>
            <td bgcolor="#FFFFFF" align="left" colspan="4">
            	<pre>
ComOpenPopupWithTarget('/hanjin/COM_ENS_N11.do?classId=COM_ENS_N11&' + param, 500, 380, 'acct_cd:acct_cd|acct_eng_nm:acct_eng_nm', v_display + ',1', true);

ComOpenPopup('/hanjin/COM_ENS_N11.do?classId=COM_ENS_N11&' + param, 500, 380, 'getCOM_ENS_N11', v_display + ',1', true);
            	</pre>
            </td>
          </tr>
        </table>
        <br>

        </td>
    </tr>
  </table>
</form>
</body>
<iframe id="apro_frame" style="display:none">
</html>