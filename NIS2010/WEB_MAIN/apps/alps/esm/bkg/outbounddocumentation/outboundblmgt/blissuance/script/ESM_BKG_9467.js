/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_9467.js
*@FileTitle : Web OB/L Paper Management
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2015.04.13 조정민
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * @extends 
 * @class esm_bkg_9467 : esm_bkg_9467 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_9467() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
	this.setTabObject 			= setTabObject;
	//this.sheet1_OnClick      = sheet1_OnClick;
}

   	/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var arrMultiCombo;//멀티콤보 세팅할 변수
var iterator = "|$$|";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
			
		case "btn_save":
			doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;
			
		case "btns_calendar":
			if(beforetab == 0){
				var cal = new ComCalendarFromTo();
				cal.select(formObject.cre_from_dt, formObject.cre_to_dt,'yyyy-MM-dd');
			}
			break;
			
			
		case "btn_downExcel":
			if(beforetab == 0){
				sheetObjects[0].SpeedDown2Excel(-1);
			}else{
				sheetObjects[1].SpeedDown2Excel(-1);
			}
			break;
			
			
		case "btn_add":
			var newRow = sheetObject.DataInsert(-1);
			sheetObject.CellValue2(newRow,"dtrb_yr") = formObject.dtrb_yr.Code;
			break;
			
		case "btn_delete":
			if (sheetObject.FindCheckedRow("del_check") != "") {
				ComRowHideDelete(sheetObject, "del_check");
			} else {
				ComShowCodeMessage("BKG00249");// "No Selected Row";
			}
			break;
			


		case "btn_history":
			var _Width = '800';
			var _Height = '500';
			var param = '';
			
			var selRows = sheetObject.FindCheckedRow("del_check");
			var idxArr = selRows.split("|");

			if(idxArr.length > 2 ){
				ComShowMessage(ComGetMsg("BKG40076"));
				return false;
			}else if(idxArr.length != 1 ) {
				param = "dtrb_yr=" + sheetObject.CellValue(idxArr[0],"dtrb_yr")
	  				+ "&rhq_cd=" + sheetObject.CellValue(idxArr[0],"rhq_cd")
	  				+ "&ofc_cd=" + sheetObject.CellValue(idxArr[0],"ofc_cd")
	  				+ "&cust_cnt_cd=" + sheetObject.CellValue(idxArr[0],"cust_cnt_cd")
	  				+ "&cust_seq=" + sheetObject.CellValue(idxArr[0],"cust_seq");

			}

			var url = "ESM_BKG_9468.do?" + param;
			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true)
			break;
			
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
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
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param tab_obj
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;
}    
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt  = 0 ;
                InsertTab( cnt++ , "Distribution by year" , -1 );
                InsertTab( cnt++ , "Total" , -1 );
            }
         break;

     }
}

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm("keydown",	"obj_keydown", formObject);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", formObject);
	axon_event.addListenerFormat("focus", "form_onFocus", formObject);
	axon_event.addListenerFormat("blur" , "form_onBlur" , formObject);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);

}

function obj_deactivate() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (srcName == "bl_no") {
		formObj.elements[srcName].value = srcValue.toUpperCase();
	}
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

    
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
    initControl();
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}

	function obj_keypress(){
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	    switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	            break;
	        case "engnum"://숫자+"영문대소"입력하기
    	  	  	ComKeyOnlyAlphabet('num'); 
	        	break;	      
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "etc": //모든 문자 가능하지만 영문은 대문자로
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	        	break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
	case 1:      //sheet1 init
		with (sheetObj) {
			//높이 설정
//			style.height = 140;
			style.height = 400;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//Sheet의 행 다중선택 불가
			MultiSelection = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(14, 0, 0, true);

			//헤더에서 처리할 수 있는 각종 기능을 설정한다
//			InitHeadMode(true, true, true, true, false, false);
			InitHeadMode(true, true, true, true, false,false);

			var HeadTitle1 = "||Seq||RHQ|Office|Cust Code|Cust Code|Cust Name|Distribution|Issued W/BL|Accumulated\nIssued W/BL|Balance|Date";
			var HeadTitle2 = "||Seq||RHQ|Office|Cust Code|Cust Code|Cust Name|Distribution|Issued W/BL|Accumulated\nIssued W/BL|Balance|Date";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  30, daCenter,  true,       "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,      40, daCenter,  true,       "del_check");
			InitDataProperty(0, cnt++ , dtSeq, 	         30, daCenter,  true,       "seq");
			InitDataProperty(0, cnt++ , dtHidden, 		 70, daCenter,  true,       "dtrb_yr",   		false,          "",      dfNone,      	  	0,     false,       true);
			InitDataProperty(0, cnt++ , dtComboEdit, 	 60, daCenter,  true,       "rhq_cd",   		false,          "",      dfNone,      	  	0,     false,       true,		6);
			InitDataProperty(0, cnt++ , dtComboEdit,	 70, daCenter,	true,		"ofc_cd",   		false,          "",      dfNone,      	  	0,     false,       true,		6);
			InitDataProperty(0, cnt++ , dtData, 	     30, daCenter,  true,       "cust_cnt_cd",   	false,          "",      dfNone,      	  	0,     false,       true,		2);
			InitDataProperty(0, cnt++ , dtData, 	     70, daRight,   true,       "cust_seq",   		false,          "",      dfNone,      	  	0,     false,       true,		6);
			InitDataProperty(0, cnt++ , dtData, 	    200, daLeft, 	true,   	"cust_nm",     		false,          "",      dfNone,     		0,     false,       false);
//			InitDataProperty(0, cnt++ , dtData, 	     20, daCenter,  true,   	"cust_dtrb_seq",    false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData,	   		100, daRight, 	false,   	"cust_dtrb_knt", 	false,          "",      dfInteger,     	0,     true,        true);
			InitDataProperty(0, cnt++ , dtData, 	    100, daRight,  	false,      "cust_wdr_knt",  	false,      	"",      dfInteger,      	0,     false,       false);
			InitDataProperty(0, cnt++ , dtData, 	    100, daRight,  	false,      "cust_accm_wdr_knt",false,     		"",      dfInteger,      	0,     false,       false);
			InitDataProperty(0, cnt++ , dtData,         100, daRight,  	false,   	"bal_knt",    		false,          "|cust_dtrb_knt|-|cust_accm_wdr_knt|",      dfInteger,     	0,     false,       false);
			InitDataProperty(0, cnt++ , dtData,         80, daCenter,  false,   	"upd_dt",    		false,          "",      dfNone,     		0,     false,       false);

			InitDataValid(0, "rhq_cd", vtEngUpOnly);
			InitDataValid(0, "ofc_cd", vtEngUpOnly);
			InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
			InitDataValid(0, "cust_seq", vtNumericOnly);

		}
		break;
		case 2:      //sheet1 init
			with (sheetObj) {
				//높이 설정
	//			style.height = 140;
				style.height = 360;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//Sheet의 행 다중선택 불가
				MultiSelection = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 0, 0, true);
	
				//헤더에서 처리할 수 있는 각종 기능을 설정한다
	//			InitHeadMode(true, true, true, true, false, false);
				InitHeadMode(false, true, true, true, false,false);
	
				var HeadTitle1 = "|Seq||RHQ|Office|Cust Code|Cust Code|Cust Name|Distribution|Issued W/BL|Balance|Date";
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  30, daCenter,  true,       "ibflag");
				InitDataProperty(0, cnt++ , dtSeq, 	         40, daCenter,  true,       "seq");
				InitDataProperty(0, cnt++ , dtHidden, 		 50, daCenter,  true,       "dtrb_yr",   		false,          "",      dfNone,      	  	0,     false,       true);
				InitDataProperty(0, cnt++ , dtData, 	     60, daCenter,  true,       "rhq_cd",   		false,          "",      dfNone,      	  	0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,	 	     70, daCenter,	true,		"ofc_cd",   		false,          "",      dfNone,      	  	0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 	     30, daCenter,  true,       "cust_cnt_cd",   	false,          "",      dfNone,      	  	0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 	     70, daRight,   true,       "cust_seq",   		false,          "",      dfNone,      	  	0,     false,       false);
				InitDataProperty(0, cnt++ , dtData, 	    200, daCenter,  true,   	"cust_nm",     		false,          "",      dfNone,     		0,     false,       false);
//				InitDataProperty(0, cnt++ , dtData, 	     20, daCenter,  true,   	"cust_dtrb_seq",    false,          "",      dfNone,     		0,     false,       true);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	130, daRight, 	false,   	"cust_dtrb_knt", 	false,          "",      dfInteger,     	0,     false,        false);
				InitDataProperty(0, cnt++ , dtAutoSumEx, 	130, daRight,  	false,      "cust_wdr_knt",  	false,          "",      dfInteger,      	0,     false,       false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,    130, daRight,  	false,   	"bal_knt",    		false,          "|cust_dtrb_knt|-|cust_wdr_knt|",      dfInteger,     	0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         100, daCenter,  false,   	"upd_dt",    		false,          "",      dfNone,     		0,     false,       false);
	
			}
			break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    // sheetObj.ShowDebugMsg = 1;
    switch(sAction) {

    
	case IBCLEAR:      //Combo조회
		formObj.f_cmd.value = SEARCH01;
		sheetObj.WaitImageVisible=false;
		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_9467GS.do", FormQueryString(formObj));
		arrMultiCombo = sXml.split(iterator); 
		if (sXml.length > 0){	
			ComXml2ComboItem(arrMultiCombo[0], formObj.dtrb_yr, "val", "name");
		}     
		if (sXml.length > 1){	
  			var arrCombo = ComXml2ComboString(arrMultiCombo[1], "cd", "cd");
  			arrCombo[1] =" \t |"+ arrCombo[1];
  			arrCombo[0] =" |"+ arrCombo[0];
  			sheetObjects[0].InitDataCombo(0, "rhq_cd", arrCombo[0], arrCombo[1]);    	  
		}     
		if (sXml.length > 2){	
  			var arrCombo = ComXml2ComboString(arrMultiCombo[2], "val", "name");
  			arrCombo[1] =" \t |"+ arrCombo[1];
  			arrCombo[0] =" |"+ arrCombo[0];
			sheetObjects[0].InitDataCombo(0, "ofc_cd", arrCombo[0], arrCombo[1]);    	  
		}  
		var dt = new Date();
		formObj.dtrb_yr.Code = dt.getYear();
		break;

		
	case IBSEARCH: //조회Retrieve
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}
		sheetObj.WaitImageVisible=true;
    	formObj.f_cmd.value = SEARCH;
		if (beforetab == 0) {
			sheetObjects[0].DoSearch("ESM_BKG_9467GS.do", FormQueryString(formObj));
		}else{
			sheetObjects[1].DoSearch("ESM_BKG_9467GS.do", FormQueryString(formObj));
//			sheetObjects[1].SumText(0, "seq") = "";
//			sheetObjects[1].SumText(0, "cust_nm") = "TOTAL";
			sheetObjects[1].SubSumBackColor = sheetObjects[1].RgbColor(214,243,214)
			sheetObjects[1].ShowSubSum("rhq_cd", "cust_dtrb_knt|cust_wdr_knt|bal_knt", -1 , true, false, 3, "3=Sub Total");
			sheetObjects[1].SubSumBackColor = sheetObjects[1].RgbColor(214,243,150)
			sheetObjects[1].ShowSubSum("ofc_cd", "cust_dtrb_knt|cust_wdr_knt|bal_knt", -1 , true, false, 4, "4=Sub Total");
		}
		
		break;

 	case IBSAVE: // Save
 		
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}
		var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
		var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_9467GS.do", "f_cmd=" + MULTI + "&" +sParam);
		var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
		if(State != "S"){
			ComShowMessage(ComResultMessage(sXml));
			ComOpenWait(false, false);
			return false;
		}else if(State == "S"){
			ComShowCodeMessage('BKG00166');
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		break;
    }
}
    
	/**
 * Tab Change 이벤트
 * @param tabObj
 * @param nItem
 */
function tab1_OnChange(tabObj , nItem)
{

   var objs = document.all.item("tabLayer");
   var sheetObj = sheetObjects[0];
   var formObj = document.form;
   if(nItem == 0){

       ComBtnEnable("btn_save");
       ComBtnEnable("btn_add");
       ComBtnEnable("btn_delete");
       formObj.cre_from_dt.className = "input";
       formObj.cre_to_dt.className = "input";
       formObj.dtrb_yr.DeleteItem("ALL"); 
	   var dt = new Date();
	   formObj.dtrb_yr.Code = dt.getYear();
	   formObj.roc_div.value = "0";
//       doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

   }else if(nItem == 1){
       ComBtnDisable("btn_save");
       ComBtnDisable("btn_add");
       ComBtnDisable("btn_delete");
       formObj.cre_from_dt.className = "input2";
       formObj.cre_to_dt.className = "input2";
	   formObj.dtrb_yr.InsertItem(0, "ALL", "ALL");
	   formObj.dtrb_yr.Code = "ALL";
	   formObj.cre_from_dt.value = "";
	   formObj.cre_to_dt.value = "";
	   formObj.roc_div.value = "1";
	   
   }
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab = nItem;


}
/**
 *  Enter 버튼 누를 시 조회처리
 */	
function obj_keydown() {
	var obj      = event.srcElement;
	var vKeyCode = event.keyCode;
	var formObj  = document.form;

	if ( vKeyCode == 13 ) { //엔터키가 눌러졌을때
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	return true;
}

function sheet1_OnChange(sheetObj, Row, Col, Value,val2){
  	var formObj = document.form;

  	if(sheetObj.ColSaveName(Col) == "rhq_cd"){
  		if(!ComIsEmpty(sheetObj.CellValue(Row,"rhq_cd"))){
  			sheetObj.WaitImageVisible=false;
  			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0000_1GS.do","f_cmd="+SEARCH19+"&ofc_cd="+sheetObj.CellValue(Row,"rhq_cd"));
  			arrMultiCombo = sXml.split(iterator);
  			if (ComGetTotalRows(arrMultiCombo[0]) == 0){
  				ComShowCodeMessage("BKG00044",'RHQ'); 
  				sheetObj.CellValue2(Row,"rhq_cd") = "";
  				return false;
  			} 
  			if (sXml.length > 0){	
  				setIBCombo(sheetObjects[0],arrMultiCombo[0],"ofc_cd",false,0, " ", " ", "val");
  				sheetObj.CellValue(Row,"ofc_cd") = " ";
  			} 
  		}
    
  	}else if(sheetObj.ColSaveName(Col) == "ofc_cd"){
  		if(!ComIsEmpty(sheetObj.CellValue(Row,"ofc_cd"))){
			var output_text = fnOfcCdCheck(sheetObj.CellValue(Row,"ofc_cd"));
			if ('Y' != output_text) {
		 		ComShowCodeMessage("BKG00044",'Office'); 
		 		sheetObj.CellValue2(Row,"ofc_cd") = "";
		 		return false;
			}
  		}
  	}else if(sheetObj.ColSaveName(Col) == "cust_cnt_cd" || sheetObj.ColSaveName(Col) == "cust_seq"){
  		if(sheetObj.CellValue(Row,"cust_cnt_cd").length == 2 && sheetObj.CellValue(Row,"cust_seq").length > 0){
  			sheetObj.WaitImageVisible=false;
  			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0102GS.do","f_cmd="+SEARCH01+"&cust_cnt_cd="+sheetObj.CellValue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.CellValue(Row,"cust_seq"));
//  			if(ComGetEtcData(sXml, "cust_nm")==""){
//  				ComShowCodeMessage('BKG00458');
//  			}
  			State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
  			if ( State == "S" ) {	
  				sheetObj.CellValue2(Row,"cust_nm") = ComGetEtcData(sXml, "cust_nm");
  			}else{
  				fnExceptionMessage(sXml);
  			}
  			
  			
  		}

  	}
  	
  	
  	if(sheetObj.ColSaveName(Col) == "rhq_cd" || sheetObj.ColSaveName(Col) == "ofc_cd"
  		||sheetObj.ColSaveName(Col) == "cust_cnt_cd" || sheetObj.ColSaveName(Col) == "cust_seq"){
  		if(!ComIsEmpty(sheetObj.CellValue(Row,"rhq_cd")) && !ComIsEmpty(sheetObj.CellValue(Row,"ofc_cd"))
  				&& sheetObj.CellValue(Row,"cust_cnt_cd").length == 2 && sheetObj.CellValue(Row,"cust_seq").length > 0){
  			
  			sheetObj.WaitImageVisible=false;
  			var param = "f_cmd="+SEARCH02
  					  +"&dtrb_yr="+sheetObj.CellValue(Row,"dtrb_yr")  
					  +"&rhq_cd="+sheetObj.CellValue(Row,"rhq_cd")
					  +"&ofc_cd="+sheetObj.CellValue(Row,"ofc_cd")
			          +"&cust_cnt_cd="+sheetObj.CellValue(Row,"cust_cnt_cd")
			          +"&cust_seq="+sheetObj.CellValue(Row,"cust_seq");
  			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_9467GS.do",param);
  			if(ComGetEtcData(sXml, "chk_flg")=="Y"){
  				ComShowCodeMessage('BKG06134');
  				sheetObj.CellValue2(Row,"cust_seq") = "";
  				sheetObj.CellValue2(Row,"cust_nm") = "";
  			}
  		}
  	}
}


/**
 * fnOfcCdCheck  
 * ofc_cd 유효성 체크
 * @param v_ofc_cd
 * @return output_text
 */
function fnOfcCdCheck(v_ofc_cd) {
	 var sheetObj = sheetObjects[0];
	 var param = param + "&f_cmd=" + SEARCHLIST19 + "&input_text=" + v_ofc_cd;
	 var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	 var output_text = ComGetEtcData(sXml, "output_text");
	 return output_text;
}

/**
* fnExceptionMessage 
*/
function fnExceptionMessage(rXml){
	var rMsg = ComGetEtcData(rXml,"Exception");
	var rmsg = rMsg.split("<||>");
	if(rmsg[3] != undefined && rmsg[3].length > 0) {
		ComShowMessage(rmsg[3]);
	}else{
		sheetObjects[0].LoadSaveXml(rXml);
	}
}
	

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		case IBSEARCH:	//retrieve
			if( formObj.cre_from_dt.value != "" && formObj.cre_to_dt.value == ""){
				ComShowCodeMessage( "COM12114", "Duration"  );
				formObj.cre_to_dt.focus();
				return false;
			}
			if( formObj.cre_from_dt.value == "" && formObj.cre_to_dt.value != ""){
				ComShowCodeMessage( "COM12114", "Duration"  );
				formObj.cre_from_dt.focus();
				return false;
			}
			if (formObj.cre_from_dt.value != "" && formObj.cre_to_dt.value != "") {
				if (ComGetDaysBetween(formObj.cre_from_dt,formObj.cre_to_dt) < 0) {
					ComShowMessage(msgs['BKG00818']);
					return false;
				}
			}

		
			
			break;
			
		case IBSAVE:

			for(var ir=sheetObj.HeaderRows ;ir<=sheetObj.RowCount ;ir++ ){
				
				if(ComIsEmpty(sheetObj.CellValue(ir,"rhq_cd"))){
					ComShowCodeMessage("BKG01101", "RHQ");
					sheetObj.SelectCell(ir, "rhq_cd") ;
					return false;
				}
				if(ComIsEmpty(sheetObj.CellValue(ir,"ofc_cd"))){
					ComShowCodeMessage("BKG01101", "Office");
					sheetObj.SelectCell(ir, "ofc_cd") ;
					return false;
				}
				if(ComIsEmpty(sheetObj.CellValue(ir,"cust_cnt_cd"))||ComIsEmpty(sheetObj.CellValue(ir,"cust_seq"))){
					ComShowCodeMessage("BKG01101", "Customer Code");
					sheetObj.SelectCell(ir, "cust_seq") ;
					return false;
				}

			}
			break;

		}
	}

    return true;
}