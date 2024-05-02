/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_0124.js
*@FileTitle : Timely Rate Creation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.03.27 조정민
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
 * @class ESM_PRI_0124 : ESM_PRI_0124 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_0124() {
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

 // 공통전역변수


 var sheetObjects = new Array();
 var sheetCnt = 0;

 var comboObjects = new Array();
 var comboCnt = 0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject1 = sheetObjects[0];
	 /*******************************************************/
	 var formObject = document.form;

	 try {
		 var srcName = window.event.srcElement.getAttribute("name");

		 switch(srcName) {

		 case "btns_calendar1": //From 달력버튼
			 var cal = new ComCalendar();
			 cal.select(formObject.bkg_from_dt, 'yyyy-MM-dd');
			 break;

		 case "btns_calendar2": //To 달력버튼
			 var cal = new ComCalendar();
			 cal.select(formObject.bkg_to_dt, 'yyyy-MM-dd');
			 break;

		 case "btn_Retrieve":
             doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			 break;

		 case "btn_downexcel":
			 doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
			 break;
			 
         case "btn_com_ens_ob2":
             ComOpenPopup('/hanjin/COM_ENS_0B2.do?', 780, 450, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
             break;
             
         case "ComOpenPopupWithTarget":  // Office Code 가져오기 팝업
	         ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:ctrt_ofc_cd", "1,0,1,1,1,1,1,1", true);
	         break;
	         
         case "btn_new":
        	 formObject.reset();
        	 sheetObject1.RemoveAll();
        	 document.form.bkg_from_dt.value = ComGetNowInfo();
        	 document.form.bkg_to_dt.value = ComGetNowInfo();
			break;
		 } // end switch
	 }catch(e) {
 		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	 } finally {
 		ComOpenWait(false);
 	}
 }

 /**
  * IBSheet Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
 function setSheetObject(sheet_obj){

	 sheetObjects[sheetCnt++] = sheet_obj;

 }



 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
 function loadPage() {

      //IBMultiCombo 초기화
      comboCnt = comboObjects.length;
      for(var k=0;k<comboCnt;k++){
          initCombo(comboObjects[k],k+1);
      }
	 for(i=0;i<sheetObjects.length;i++){

		 //khlee-시작 환경 설정 함수 이름 변경
		 ComConfigSheet (sheetObjects[i] );

		 initSheet(sheetObjects[i],i+1);
		 //khlee-마지막 환경 설정 함수 추가
		 ComEndConfigSheet(sheetObjects[i]);
	 }
	 initControl();

	 
	 document.form.bkg_from_dt.value = ComGetNowInfo();
	 document.form.bkg_to_dt.value = ComGetNowInfo();

	 ComPriTextCode2ComboItem(rhqComboValue,rhqComboText,getComboObject(comboObjects, 'region'), "|", "\t" );


 }

  function initCombo(comboObj, comboNo) {
      switch (comboObj.id) {

          case "region":
              var i = 0;
              with (comboObj) {
                  DropHeight = 200;
                  UseAutoComplete = true;
                  ValidChar(2, 0);    // 영문대문자만 입력
                  MaxLength = 6;      // 6자리만 입력
              }
              break;

      }
  }
  
  function setComboObject(combo_obj) {
      comboObjects[comboCnt++] = combo_obj;
  }
  
  
  function initControl() {

        axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); //- 키보드 입력할때
        axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);  
        axon_event.addListenerFormat("KeyUp", "obj_KeyUp",  document.form);
    	axon_event.addListenerFormat("focus", "obj_onFocus", document.form);
    	axon_event.addListenerFormat("blur", "obj_onBlur", document.form);

    }
 /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch (sheetID) {
		
		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 450;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;				

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(6, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				var HeadTitle  = "RHQ|C.Office|C.Rep|Total BKG|Out of Date BKG|Ratio(%)";
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
          
				InitDataProperty(0, cnt++ , dtData,			 160,	daCenter,	 false,	"region",  	    false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 160,	daCenter,	 false,	"ctrt_ofc_cd", 	false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 160,	daCenter,	 false,	"ctrt_srep_cd", false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,		 	 160,	daCenter,	 false,	"ttl_cnt",    	false,	"",		dfInteger,	0,		false,	false); 
				InitDataProperty(0, cnt++ , dtData,	    	 160,	daCenter,	 false,	"s_e_cnt",  	false,	"",		dfInteger,	0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 160,	daCenter,	 false,	"ratio",    	false,	"",		dfFloat,	0,		false,	false);
		
				DataLinkMouse("s_e_cnt") = true;
			}
			break;		

		}
	}	

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

		case IBSEARCH:      //조회
			if (validateForm(sheetObj,formObj,sAction)) {	
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_PRI_0124GS.do", FormQueryString(formObj));
			}
			break;
	
		case IBDOWNEXCEL:      //download excel
			sheetObj.SpeedDown2Excel(-1);
	        break;
	        
	}
}
//
//      
//function obj_keydown(){
//    //enter key조회
//    var eleName = event.srcElement.name;
//    var formObj = document.form;       
//    var keyValue = null;
//    if(event == undefined || event == null) {
// 	   keyValue = 13;
//    }else{
// 	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//    }
//    if (keyValue == 13){
//    	   	if(formObj.vsl_cd.value=="") return;
//    	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//    }
//}	

function obj_keypress(){
    var obj = event.srcElement;
    var srcName = event.srcElement.getAttribute("name");
    var srcValue = event.srcElement.getAttribute("value");
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;
    switch(obj.dataformat){
        case "ymd": //날짜 입력하기
	  	  ComKeyOnlyNumber(obj);
	  	  if (srcValue.length == 4) {
	  		  document.form.elements[srcName].value = srcValue.substring(0,4) + "-";
	  	  }
	  	  if (srcValue.length > 4 && srcValue.indexOf('-') < 0) {
	  		  return;
	  	  }
	  	  if (srcValue.length == 7) {
	  		  document.form.elements[srcName].value = srcValue.substring(0,7) + "-";
	  	  }

            break;
        case "int": //숫자만 입력
            ComKeyOnlyNumber(obj);
            break;
        case "engup":
            ComKeyOnlyAlphabet('upper');
            break;
        case "uppernum":
            ComKeyOnlyAlphabet('uppernum');
            break;    
        default:
            //ComKeyOnlyNumber(obj);
            break;
    }
}


//VVD 탭키 처리
function obj_KeyUp() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

//function obj_onBlur() {
//	switch (event.srcElement.name) {
//	case "bkg_from_dt":
//		ComAddSeparator(event.srcElement);
//		break;
//	case "bkg_to_dt":
//		ComAddSeparator(event.srcElement);
//		break;
//	}
//}

//function obj_onFocus() {
//	//입력Validation 확인하기
//	switch (event.srcElement.name) {
//	case "bkg_from_dt":
//		ComClearSeparator(event.srcElement);
//		break;
//	case "bkg_to_dt":
//		ComClearSeparator(event.srcElement);
//		break;
//	}
//}
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
	  
	  switch (sAction) {

	      case IBSEARCH: //조회
	        var bkgfDtObj = formObj.bkg_from_dt.value;
	        var bkgtDtObj = formObj.bkg_to_dt.value;
	        var vslCd = formObj.vsl_cd.value;
	        var skdVoyNo = formObj.skd_voy_no.value;
	        var dirCd = formObj.skd_dir_cd.value;
	        
	      	if((bkgfDtObj =='' || bkgtDtObj =='') && (vslCd =='' || skdVoyNo =='' || dirCd =='')){
	      		ComShowCodeMessage("PRI00316", "'Port Closing Date' or 'T/VVD'");
	      		ComSetFocus(formObj.bkg_from_dt);
	      		return false;
	      	}
	      	
	      	if (bkgfDtObj != "" && !ComChkObjValid(formObj.bkg_from_dt, false, false, false,"ymd") ){
				ComShowCodeMessage('PRI00322', 'Port Closing Date');					
				ComSetFocus(formObj.bkg_from_dt);
				return false;                                                                                                                                                                                                                                                                                                                                                                                                                   
			}
	      	
	      	if (bkgtDtObj != "" && !ComChkObjValid(formObj.bkg_to_dt, false, false, false,"ymd") ){
				ComShowCodeMessage('PRI00322', 'Port Closing Date');					
				ComSetFocus(formObj.bkg_to_dt);
				return false;                                                                                                                                                                                                                                                                                                                                                                                                                   
			}
	      	
	      	if(!chkBkgDatePeriod(formObj)) {return false;}
	      	if(!chkBkgDate(formObj)) {return false;}
		      break;
	  }

	 return true;
 }
 
 
 function setCallBack0B2(aryPopupData) {
     var formObj = document.form;
     var strValue = aryPopupData[0][7];

     formObj.vsl_cd.value = strValue.substr(0,4);
     formObj.skd_voy_no.value = strValue.substr(4,4);
     formObj.skd_dir_cd.value = strValue.substr(8);

 } 
 
 
 function sheet1_OnClick(sheetObj, Row, Col) {
	 	var formObj = document.form;
		var colSaveName = sheetObj.ColSaveName(Col);

		switch (colSaveName) {

		case "s_e_cnt":
			if(sheetObj.CellValue(Row,"s_e_cnt") != "0"){
	            var param = "";
	            param = "ctrt_ofc_cd=" + sheetObj.CellValue(Row,"ctrt_ofc_cd");
	            param = param + "&" + "ctrt_srep_cd=" + sheetObj.CellValue(Row,"ctrt_srep_cd");
	            param = param + "&" + "vvd=" + formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
	            param = param + "&" + "bkg_from_dt=" + formObj.bkg_from_dt.value;
	            param = param + "&" + "bkg_to_dt=" + formObj.bkg_to_dt.value;
	            ComOpenPopup('/hanjin/ESM_PRI_0125.do?' + param, 820, 500, '', '1,0,1,1,1,1,1,1', true);
				break;
			}
		}

	}
 
 
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	 for( var idx = 0 + parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
			if( sheetObj.CellValue(idx,"s_e_cnt") != "0" ){
				sheetObj.CellFontUnderline(idx, "s_e_cnt") = true;
			}
		}
 }
 
 /**
  * Port Closing date 검색 조건의 from - to range를 check 한다.
  */
 function chkBkgDatePeriod(formObj) {
     var form = document.form;
     var fromVal = form.bkg_from_dt.value.replace(/-/g,'');
     var toVal = form.bkg_to_dt.value.replace(/-/g,'');

     var fromAddM = ComGetDateAdd(fromVal, "D", 62, "", true);
     if( parseInt(toVal,10) > parseInt(fromAddM,10) ) {
         ComShowCodeMessage("PRI00308", "check the date range.", "Maximum date range is 2 months");
         event.returnValue = false;
         ComSetFocus(formObj);
         return false;
     }
     return true;
 }
 
 /**
  * Port Closing date 검색 조건이 To date가 From date 보다 큰 경우를 체크한다.
  */
 
 function chkBkgDate(formObj) {
     var form = document.form;
     var fromVal = form.bkg_from_dt.value.replace(/-/g,'');
     var toVal = form.bkg_to_dt.value.replace(/-/g,'');
     
     if(fromVal != "" && toVal != "") {
         if( parseInt(fromVal,10) > parseInt(toVal,10) ) {
             //msgs['PRI00305'] = '{?msg1} start date can not be greater than end date.';
             ComShowCodeMessage("PRI00305", "'Port Closing Date'");
             event.returnValue = false;
             ComSetFocus(formObj);
             return false;
         }
     }
     return true;
 }
 /* 개발자 작업  끝 */