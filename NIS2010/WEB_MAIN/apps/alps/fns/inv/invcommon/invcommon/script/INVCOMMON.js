/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : invcommon.js
*@FileTitle : INVCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.24 김세일
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class invcommon : invcommon 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function invcommon() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

	
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	
	function obj_keypress(){
//		alert('a');
//		 alert(event.keyCode);
//		 comboid_OnKeyDown(comboObj,event.keyCode,0)
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "ymd":
	            //숫자+"-"입력하기
	        	ComKeyOnlyNumber(event.srcElement);
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
	            break;
	        case "uppernum":
	        	//영문대+숫자 
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	    }
	}
	
	
	function MakeComboObject(cmbObj, arrStr) {
	    //IBMultiCombo초기화

//		cmbObj.ShowCol = 10;
		for (var i = 0; i < arrStr.length;i++ ) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
		}
   		cmbObj.DropHeight = 190;

	}
	
	//INVCommonGS.do 에서 off_cd 콤보박스 출력시 사용(sheetObj : 그리드객체, formObj : 폼객체, cmbObj : 콤보대상객체, allYn : ALL 추가여부(Y)
	function ComboObject_OfcCd(sheetObj, formObj, cmbObj, all, select_yn) {
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
		
		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
		var arrStr = sStr.split("|");
		MakeComboObject_OfcCd(cmbObj, arrStr, all);

		var arrStr2 = arrStr[1].split("^");
		var ar_ofc_cd = arrStr2[3];
		if(select_yn != "N"){
			cmbObj.text = ar_ofc_cd;
		}
        cmbObj.DropHeight = 190;
   	 }
	//INVCommonGS.do 에서 off_cd 콤보박스 출력시 사용(cmbObj : 대상객체, arrStr : 데이타 배열, allYn : ALL 추가여부(Y)
	function MakeComboObject_OfcCd(cmbObj, arrStr, allYn) {
		cmbObj.RemoveAll(); 
   		for (var i = 1; i < arrStr.length;i++ ) {
   			var arrStr2 = arrStr[i].split("^");
   			var ar_ofc_cd = arrStr2[1];
   			cmbObj.InsertItem(i-1, ar_ofc_cd, ar_ofc_cd);
   		}
   		if(allYn=='Y'){
   		cmbObj.InsertItem(0, "ALL", "ALL");
   		}
   		cmbObj.BackColor = "#CCFFFD";
   	 }
	
	//INVCommonGS.do 에서 off_cd 콤보박스 출력시 사용(cmbObj : 대상객체, arrStr : 데이타 배열, allYn : ALL 추가여부(Y)
	function MakeComboObject_OfcCd_Re(cmbObj, arrStr, allYn) {
		cmbObj.RemoveAll(); 
   		for (var i = 1; i < arrStr.length;i++ ) {
   			var arrStr2 = arrStr[i].split("^");
   			var ar_ofc_cd = arrStr2[1];
   			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
   		}
   		if(allYn=='Y'){
   		cmbObj.InsertItem(0, "ALL", "ALL^ALL");
   		}
   		cmbObj.BackColor = "#CCFFFD";
   	 }
	
	 //그리드에서  SelectRow/RowCount 보여준다. sheetObj, formObj, gubun(search, delete), delNum:삭제한 갯수
	 function getCountFormat(sheetObj, formObj, gubun, delNum){
		 var dis_count = "";
		 if(gubun == "search"){
			 formObj.delCount.value = "0";
			dis_count = "["+ sheetObj.SelectRow + " / " + sheetObj.RowCount +"]";
		 }else if(gubun == "delete"){
			var delCount = Number(formObj.delCount.value);
			if(delCount == "") delCount = 0;
			//var selNum = sheetObj.SelectRow-delNum - delCount;
			var selNum = 1;
			var totNum = sheetObj.RowCount-delNum - delCount;
			dis_count = "["+ selNum + " / " + totNum+"]";
			formObj.delCount.value = delNum + delCount;
		 }
		 sheetObj.CountFormat = dis_count;
	 }
	
	
	
	/* 개발자 작업  끝 */