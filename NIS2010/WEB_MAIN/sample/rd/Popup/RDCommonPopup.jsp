<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoPopup.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MRD Common Popup Sample</h1>
<form name="form">
<br><hr size=5 noshade>
Mrd Sample1
<br>
<input type="text" size="200" name="com_mrdPath" value="sample/rd/mrdSample/TESTWithParam.mrd">
<br>
Mrd Param1
<br>
<input type="text" size="200" name="com_mrdArguments" value="/rp [김정훈] [안녕하세요]">
<br><hr size=5 noshade>
Mrd Sample2
<br>
<input type="text" size="200" name="com_mrdPath" value="sample/rd/mrdSample/TEST.mrd">
<br>
Mrd Param2
<br>
<input type="text" size="200" name="com_mrdArguments" value="">
<br><hr size=5 noshade>
Default 저장 디렉토리
<input type="text" size="200" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\">
<br><hr size=5 noshade>
Default 저장 파일명
<input type="text" size="200" name="com_mrdSaveDialogFileName" value="SaveFileName">
<br><hr size=5 noshade>
Default 저장 파일 확장자
<input type="text" size="200" name="com_mrdSaveDialogFileExt" value="pdf">
<br><hr size=5 noshade>
저장 허용 확장자
<input type="text" size="200" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<br><hr size=5 noshade>
팝업 Title
<input type="text" size="200" name="com_mrdTitle" value="Report Designer Common Popup Sample">
<br><hr size=5 noshade>
프린트 시 페이지 크기 설정 : 0-A3, 1-A4, 2-B4, 3-B5, 4-LETTER, 5-136, 6-80, 7-A1, 8-A2, 9-A5
이 기능을 활성화 시키면 사용자가 설정한 프린터 용지 기억 기능이 disable 됩니다.
<input type="text" size="200" name="com_mrdPrintPaperSize" value="1">
<br><hr size=5 noshade>
Toolbar Disable 지정
<br>
index : Disable할 툴바 항목의 인덱스. 0-파일저장,1-인쇄,2-찾기,3-목차만들기,4-화면확대,5-화면축소,12-리포팅중지,13-엑셀로보기,14-아래아한글로보기, 15-PDF로보기, 16-파워포인트로보기, 17-워드로보기
<br>
반드시 0;1;2;3;4;5;12;13;14;15;16;17 형태로 써주세요.
<br>
0 -> 정상
<br>
0; -> 에러
<br>
전부 enable 시키는 경우는 값을 안 넣으면 됩니다.
<br>
<input type="text" size="200" name="com_mrdDisableToolbar" value="0;1;2;3;4;5;12;13;14;15;16;17">
<br><hr size=5 noshade>
페이지 내의 제목 지정
<input type="text" size="200" name="com_mrdBodyTitle" value="Report Sample">
<br><hr size=5 noshade>
시작 화면 크기 설정
<input type="text" size="200" name="com_zoomIn">
<br><hr size=5 noshade>
Batch DB 설정 Flag (Y / N)
<select name="com_isBatch">
	<option value="Y">Y</option>
	<option value="N" selected>N</option>
</select>
<br><hr size=5 noshade>

<!-- input type="button" value="fire" onclick="ComOpenRDPopupModal('dialogWidth:750px;dialogHeight:690px')"-->
<input type="button" value="fire" onclick="ComOpenRDPopup()">
</body>
</form>
</html>