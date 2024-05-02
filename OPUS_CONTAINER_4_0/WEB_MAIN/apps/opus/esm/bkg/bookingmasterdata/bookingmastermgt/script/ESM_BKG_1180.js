/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1180.js
*@FileTitle : E-BKG Handling Office Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2014.11.24 정인선
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
 * @class esm_bkg_1180 : esm_bkg_1180 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1180() {
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
var reSearch = true;
var maxCtrl = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

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
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}           
	if(!(document.form.screenName.value.indexOf("Q") < 0)){
		sheetObjects[0].Editable = false;
		sheetObjects[0].ColHidden("Del") = true;
	}
	initControl();
 }

 /**
  * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  * 
  * @param {ibsheet}
  *            sheetObj IBSheet Object
  * @param {int}
  *            sheetNo sheetObjects 배열에서 순번
  */
 function initControl() {
	var formObject = document.form;
  	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
	axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');          
 }
  
 /**
  * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
  **/
function obj_keypress(){
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
		case "engupnum":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "engnum":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet('num');
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
		case 1:
			with (sheetObj) {
				var HeadTitle1 = "|Sel.|Seq.|BKG OFC|Office Country code|Partner Office Code|Partner Office Name|POL|POR|Date|User ID";
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var headCount = ComCountHeadTitle(HeadTitle1);
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
 
				InitHeaders(headers, info);
				var cols = [ 
				            {Type:"Status",    Hidden:1,	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				            {Type:"CheckBox",  Hidden:0, 	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
				            {Type:"Seq",       Hidden:0, 	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				            {Type:"Text",      Hidden:0,  	Width:170,  Align:"Center",  ColMerge:0,   SaveName:"hndl_ofc_cd",		KeyField:1,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1, 	InputCaseSensitive:1, EditLen:5},
				            {Type:"Text",      Hidden:0,  	Width:200,  Align:"Center",  ColMerge:0,   SaveName:"vt_cust_cnt_cd",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1,	InputCaseSensitive:1, EditLen:2},
				            {Type:"Text",      Hidden:0,  	Width:200,  Align:"Center",  ColMerge:0,   SaveName:"vt_cust_ofc_cd",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1,	InputCaseSensitive:1},
				            {Type:"Text",      Hidden:0,  	Width:200,  Align:"Center",  ColMerge:0,   SaveName:"vt_cust_ofc_nm",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1},
				            {Type:"Text",      Hidden:0,  	Width:170,  Align:"Center",  ColMerge:0,   SaveName:"pol_cd",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1,	InputCaseSensitive:1, EditLen:5},
				            {Type:"Text",      Hidden:0,  	Width:170,  Align:"Center",  ColMerge:0,   SaveName:"por_cd",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1, 	InputCaseSensitive:1, EditLen:5},
				            {Type:"Text",      Hidden:0,  	Width:170,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
				            {Type:"Text",      Hidden:0,  	Width:170,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",		KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
				            {Type:"Text",      Hidden:1,  	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_hndl_ofc_seq",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1 }
				            ];

				InitColumns(cols);
				SetSheetHeight(500);
			}
			break;
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
		case "btn_retrieve":
			
			var SaveStr1 = sheetObjects[0].GetSaveString(0);
			if(SaveStr1 != ""){
				if(ComShowCodeConfirm('BKG00254')){
					reSearch = false;
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				}
			}
			if(reSearch)
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btn_Del":
			doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
			break;
		case "btn_Add":
		 addRow();
		 	break;
		case "btn_new":
			ComResetAll();
			break;
		} // end switch 
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
		}
	}finally{
		ComOpenWait(false);
	}
}  
      
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj, formObj, sAction)) return; 	
			reSearch = true;
			formObj.f_cmd.value = SEARCH; 
			sheetObj.DoSearch("ESM_BKG_1180GS.do" , FormQueryString(formObj));
			break;
		
		case IBSAVE:        //저장
			if(!validateForm(sheetObj, formObj, sAction)) return;
			formObj.f_cmd.value = MULTI;   
			sheetObj.DoSave("ESM_BKG_1180GS.do", FormQueryString(formObj));
			break;
			
		case IBDELETE:      // 삭제
			ComRowHideDelete(sheetObjects[0], "del_chk");
			break;
     }
 }


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	with(formObj){
		switch(sAction) {
		case IBSAVE:
			if (!sheetObj.IsDataModified()){
				ComShowCodeMessage('BKG00989');
				return false; //There is no updated data to save.
			}
			for (var i = sheetObj.HeaderRows() ; i < sheetObj.RowCount() +1 ; i++){
				if(sheetObj.GetCellValue(i,"ibflag") == "I" || sheetObj.GetCellValue(i,"ibflag") == "U"){
					if (sheetObj.GetCellValue(i, "hndl_ofc_cd") == ''){
						sheetObj.SetSelectRow(i);
						sheetObj.SetSelectCol(3);
//						ComShowCodeMessage("BKG00104", "BKG OFC");//Mandatory item is missing. Please enter ({?msg1})
						ComShowMessage("(Seq. " + i + ") Mandatory item is missing. Please enter (BKG OFC)");
						return false; //
					}
					if(sheetObj.GetCellValue(i, "vt_cust_cnt_cd") != ""){
						
						var sXml = sheetObj.GetSearchData("ESM_BKG_1180GS.do" , "f_cmd=" + SEARCH02 + "&vt_cust_cnt_cd=" + sheetObj.GetCellValue(i, "vt_cust_cnt_cd"));
						var vtCustCntCd = ComGetEtcData(sXml, "vt_cust_cnt_cd");
						if(vtCustCntCd == null || vtCustCntCd == ''){
							sheetObj.SetSelectRow(i);
							sheetObj.SetSelectCol(4);
//							ComShowCodeMessage("BKG00464", sheetObj.GetCellValue(i, "vt_cust_cnt_cd"), " Office Country Code");
							ComShowMessage("(Seq. " + i + ") Country code is invalid (" + sheetObj.GetCellValue(i, "vt_cust_cnt_cd") + ", Office Country Code)");
							sheetObj.SetCellValue(i, "vt_cust_cnt_cd", "");
							return false;
						}
					}
					
					var vtCustOfcCd = ComTrim(sheetObj.GetCellValue(i, "vt_cust_ofc_cd"));
					if(vtCustOfcCd == '' && sheetObj.GetCellValue(i, "pol_cd") == '' && sheetObj.GetCellValue(i, "por_cd") == ''){
						sheetObj.SetSelectRow(i);
						if(vtCustOfcCd == ''){
							sheetObj.SetSelectCol(5);
						}else if(sheetObj.GetCellValue(i, "pol_cd") == ''){
							sheetObj.SetSelectCol(7);
						}else if(sheetObj.GetCellValue(i, "por_cd") == ''){
							sheetObj.SetSelectCol(8);
						}
						ComShowMessage("(Seq. " + i + ") You should input one value at least among Partner office code and POL and POR. ");
						return false;
					}
					
					if(sheetObj.GetCellValue(i,"ibflag") == "I" || sheetObj.GetCellValue(i,"ibflag") == "U"){
						var tempXml = sheetObj.GetSearchData("ESM_BKG_1180GS.do" , "f_cmd=" + SEARCH + "&" + sheetObj.RowSaveStr(i) + "&insert_check=check");
						var size = ComGetEtcData(tempXml, "SIZE");
						if(size != undefined){
							sheetObj.SetSelectRow(i);
							sheetObj.SetSelectCol(3);
							ComShowMessage("(Seq. " + i + ") is duplicated.");
//							ComShowCodeMessage("BKG95007", sheetObj.GetCellValue(i, "hndl_ofc_cd"));
							return false;
						}
					}
				}
			}
			break;
		}
	}
	return true;	
}
 
/**
 * 셀변경후  이벤트 처리
 */ 
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	with (sheetObj) {
		var formObj = document.form;
		if(ColSaveName(Col) == "hndl_ofc_cd"){
			if(Value == "") return;
			ComSetObjValue(document.form.vel_type, "ofcCd");
			ComSetObjValue(document.form.vel_data, Value);
			formObj.f_cmd.value = SEARCH01; 
			var saveXml = sheetObj.GetSearchData("ESM_BKG_1180GS.do", FormQueryString(formObj)); 
			if(ComGetEtcData(saveXml, "TRANS_RESULT_KEY") == "F"){
				sheetObj.SetCellValue(Row, "hndl_ofc_cd", "");
				ComShowCodeMessage('BKG00806');
				sheetObj.SetSelectCol(3); 
			}
		}
		else if(ColSaveName(Col) == "pol_cd"){
			if(Value == "") return;
			ComSetObjValue(document.form.vel_type, "polCd");
			ComSetObjValue(document.form.vel_data, Value);
			formObj.f_cmd.value = SEARCH01; 
			var saveXml = sheetObj.GetSearchData("ESM_BKG_1180GS.do", FormQueryString(formObj)); 
			if(ComGetEtcData(saveXml, "TRANS_RESULT_KEY") == "F"){
				sheetObj.SetCellValue(Row, "pol_cd", "");
				ComShowCodeMessage('BKG00061', Value);
				sheetObj.SetSelectCol(5); 
			}
		}
		else if(ColSaveName(Col) == "por_cd"){
			if(Value == "") return;
			ComSetObjValue(document.form.vel_type, "porCd");
			ComSetObjValue(document.form.vel_data, Value);
			formObj.f_cmd.value = SEARCH01; 
//			ComOpenWait(true);
			var saveXml = sheetObj.GetSearchData("ESM_BKG_1180GS.do", FormQueryString(formObj)); 
			if(ComGetEtcData(saveXml, "TRANS_RESULT_KEY") == "F"){
				sheetObj.SetCellValue(Row, "por_cd", "");
				ComShowCodeMessage('BKG00061', Value);
				sheetObj.SetSelectCol(6); 
			}
		}
	}
}  

function sheet1_OnSaveEnd(sheetObj, errMsg) {
	if(errMsg == "") doActionIBSheet(sheetObj,document.form,IBSEARCH) ;
	reSearch = true;
}

/**
 * 로우추가이벤트 처리 
 */  
 function addRow(){
	sheetObjects[0].DataInsert(-1);
	sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, 3, true, ''); 
 }

/* 개발자 작업  끝 */