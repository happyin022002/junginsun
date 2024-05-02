/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0037.js
 *@FileTitle : B/L Inquiry: Container Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.02
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.07.02 이수빈
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
 * @class B/L Inquiry: Container Information : B/L Inquiry: Container Information 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0037() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.doActionIBSheet 		= doActionIBSheet;
    this.setComboObject 		= setComboObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var seal_knd_str = "M|E";
var seal_pty_tp_str = "CA|SH|AA|CU|AB|AC|TO";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	  var sheetObject = sheetObjects[0];
      /*******************************************************/
      var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				doActionIBSheet(sheetObjects[2],document.form,IBROWSEARCH);								
			break; 
			
			case "btn_save":
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);	
			break;
			
			case "btn_add":
				doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
			break;
			
			case "btn_del":
				doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
			break;																					

			case "btn_close":
				window.close();
			break;


         } // end switch
 	}catch(e) {
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
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
 function loadPage() {
     for(i=0;i<sheetObjects.length;i++){

     //khlee-시작 환경 설정 함수 이름 변경
         ComConfigSheet (sheetObjects[i] );

         initSheet(sheetObjects[i],i+1);
     //khlee-마지막 환경 설정 함수 추가
         ComEndConfigSheet(sheetObjects[i]);
     }
	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	 doActionIBSheet(sheetObjects[2],document.form,IBROWSEARCH);

	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}


/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;
     var sheetID = sheetObj.id;

     switch(sheetID) {
     
         case "sheet1":      //sheet1 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 240;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                 //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;
                 FocusEditMode = 2;
                 FocusAfterProcess = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

				 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(11, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false);

                 var HeadTitle1 = "|Sel.|Seq.|B/L No.|CONTAINER|TY/SZ|SEAL No. 1|SEAL No. 2|SEAL No. 2|Type|";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,    	daCenter,  	 false,  	"ibflag");
                 InitDataProperty(0, cnt++ , dtDummyCheck,		40,		daCenter,	 true,		"Sel");
                 InitDataProperty(0, cnt++ , dtSeq,				50,		daCenter,	 true,		"Seq");
                 InitDataProperty(0, cnt++ , dtHidden,		 	120,   	daCenter,    false,     "bl_no",   		false,    "",      dfNone,	0,     true,		true);
                 InitDataProperty(0, cnt++ , dtData,		 	110,   	daCenter,    false,     "cntr_no",   	false,    "",      dfNone,	0,     true,		true,	14);      
                 
                 InitDataProperty(0, cnt++ , dtData,      		60,   	daCenter,    false,     "cntr_tpsz_cd", false,    "",      dfNone, 		0,     false,		false);
                 InitDataProperty(0, cnt++ , dtData, 			110,   	daCenter,    false,     "seal_no",    	false,    "",      dfNone, 		0,     true,		true);
                 InitDataProperty(0, cnt++ , dtData, 			110,   	daCenter,    false,     "seal_no2",    	false,    "",      dfNone, 		0,     true,		true);
                 InitDataProperty(0, cnt++ , dtPopup,      		20,   	daCenter,    false,     "seal_no3",     false,    "",      dfNone, 		0,     true,		true);
                 InitDataProperty(0, cnt++ , dtCombo,      		50,   	daCenter,    false,     "full_mty_cd",  false,    "",      dfNone, 		0,     true,		true);

                 InitDataProperty(0, cnt++ , dtHidden,     		130,   	daCenter,    false,     "bak_cntr_no",	false,    "",      dfNone, 		0,     true,		true);
		   	 	 
                 ShowButtonImage = 2;									
		   	 	 InitDataCombo(0, "full_mty_cd",	 "F\tFull|P\tEmpty","F|M");

		   	 	 InitDataValid(0, "cntr_no", 	vtEngUpOther, 	"1234567890");
		   	 	 InitDataValid(0, "seal_no", 	vtEngOther, 	"1234567890");
		   	 	 InitDataValid(0, "seal_no2", 	vtEngOther, 	"1234567890");
             }
             break;

         case "sheet2":
         case "sheet3":
			
             with (sheetObj) {
                 // 높이 설정
                 //style.height = 100;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(1, 1, 2, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(8, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)

                 var HeadTitle = "||BL NO|Container|Seal Seq|Seal No|knd_cd|pty_tp";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	             InitDataProperty(0, cnt++ , dtStatus,		30,   	daCenter,       true,         "ibflag");
				 InitDataProperty(0, cnt++ , dtDummyCheck,	 0,  	daCenter,       false,        "sel");
                 InitDataProperty(0, cnt++ , dtData,     	80,      daCenter,       false,       "bl_no",          false,    "",      dfNone,    0,        true,        true);
                 InitDataProperty(0, cnt++ , dtData,     	140,     daRight,        false,       "cntr_no",        false,    "",      dfNone,    2,        true,        true);
                 InitDataProperty(0, cnt++ , dtData,     	140,     daRight,        false,       "seal_no_seq",    false,    "",      dfNone,    2,        true,        true);
                 
                 InitDataProperty(0, cnt++ , dtData,     	140,     daRight,        false,       "seal_no",        false,    "",      dfNone,    2,        true,        true);
                 InitDataProperty(0, cnt++,  dtData,         40,     daCenter,  	 false,    	  "seal_knd_cd",    false,    "",      dfNone,    0,        true,        true);
                 InitDataProperty(0, cnt++,  dtData,         50,     daCenter,  	 false,       "seal_pty_tp_cd", false,    "",      dfNone,    0,        true,        true);
                 
				 DataAutoTrim = false;
             }
         break;

     }
 }

/**
 * Sheet관련 프로세스 처리
 */ 
function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
    //sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	 
	switch(sAction) {
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;
    		ComOpenWait(true);
	        formObj.f_cmd.value = SEARCH;
	        formObj.sheet_id.value = sheetObj.id;
			sheetObj.DoSearch("ESM_BKG_0037GS.do", FormQueryString(formObj));
    		ComOpenWait(false);
			break;
		
		case IBROWSEARCH:   //Container 별 Seal No. 조회
	        formObj.f_cmd.value = SEARCH;
	        formObj.sheet_id.value = sheetObj.id;
			sheetObj.DoSearch("ESM_BKG_0037GS.do", FormQueryString(formObj));
			if(sheetObj.RowCount == 0) sheetObj.RemoveAll();
		 	break;
		
		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) return false;
		 	if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
	    		ComOpenWait(true);
		        formObj.f_cmd.value = MULTI;

        		var sheetObj2 = sheetObjects[2];
		        var sheet1Xml = "";
		        var sheet2Xml = "";
		        // Container 변경 내역 저장
		        if(sheetObj.GetSaveString() != ""){
	    	        formObj.sheet_id.value = sheetObj.id;
		        	var params = FormQueryString(formObj)+"&"+sheetObj.GetSaveString();
			        sheet1Xml = sheetObj.GetSaveXml("ESM_BKG_0037GS.do", params);
			        var state = ComGetEtcData(sheet1Xml,ComWebKey.Trans_Result_Key);
			        if (state == "S") {
				        // Seal No. 변경 내역 저장
				        if(sheetObj2.GetSaveString() != ""){
			    	        formObj.sheet_id.value = sheetObj2.id;
			    	        sheetObj2.ColumnSort("bl_no|cntr_no", "ASC");
			    	        for(var i=0; i<sheetObj2.RowCount+1; i++){
			    	        	if(sheetObj2.RowStatus(i) == "R"){
			    	        		sheetObj2.RowStatus(i) = "U";
			    	        	}
			    	        }
				        	sheetObj2.DoSave("ESM_BKG_0037GS.do", FormQueryString(formObj), -1, false);
				        }
		        		doActionIBSheet(sheetObj,formObj,IBSEARCH);
		        		doActionIBSheet(sheetObj2,formObj,IBROWSEARCH);
			        }else{
			        	return false;
			        }
		        }
	    		ComOpenWait(false);
		 	}
		 	break;
		
		case IBINSERT:      // 입력
			sheetObj.DataInsert(-1);
			sheetObj.CellValue(sheetObj.SelectRow, "bl_no") = formObj.bl_no.value;
			sheetObj.CellValue(sheetObj.SelectRow, "full_mty_cd") = "";
			break;
		
		case IBDELETE:      // 삭제
			if(sheetObj.CheckedRows(1) == 0){
				ComShowCodeMessage('BKG00249'); // No Selected Row
				return;
			}
			ComShowCodeMessage('BKG03037');
			ComRowHideDelete(sheetObj,"Sel");
			break;
			
		case SEARCH01: // 그리드에서 Container No. 입력시 조회
			if(!validateForm(sheetObj,formObj,sAction,Row,Col))return false;
			
			formObj.f_cmd.value = SEARCH01;
			var val = sheetObj.CellValue(Row,Col);
			var params = FormQueryString(formObj)+"&"+sheetObj.GetSaveString();
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0037GS.do", params);
    		var cntr_no = ComGetEtcData(sXml, "cntr_no");
    		var cntr_tpsz_cd = ComGetEtcData(sXml, "cntr_tpsz_cd");
    		
    		if(cntr_no == undefined){
    			ComShowCodeMessage("BKG06012", val);
    			sheetObj.CellValue2(Row, "cntr_no") = "";
    			sheetObj.CellValue2(Row, "cntr_tpsz_cd") = "";
    			//sheetObj.ReturnCellData(Row, "cntr_no");
    			sheetObj.SelectCell(Row, "cntr_no");
    		}else{
				sheetObj.CellValue2(Row, "cntr_tpsz_cd") = cntr_tpsz_cd; 
				sheetObj.CellValue2(Row, "cntr_no") = cntr_no;
    		}
			break;
    }
}

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
		case IBSEARCH: { // 조회
			//기본포멧체크
	    	if (!ComChkObjValid(formObj.bl_no)) return false;
			break;
		}
		case IBSAVE: { // 저장
			//기본포멧체크
			var sheetObj1 = sheetObjects[0];
			var sheetObj2 = sheetObjects[2];
	    	if (!ComChkObjValid(formObj.bl_no)) return false;
			if (sheetObj1.GetSaveString() == "" && sheetObj2.GetSaveString() == ""){ 
				ComShowCodeMessage('BKG00743'); // 변경된 데이터가 없음
				return false;
			}
			else{
				for( var i=sheetObj2.HeaderRows; i<=sheetObj2.LastRow; i++ ){
					if(sheetObj2.CellText(i, "bl_no") == ""){
						sheetObj2.CellValue2(i, "bl_no") = formObj.bl_no.value;
					}
				}
			}
			break;
		}
		case SEARCH01: {
			return true;
			break;
		}
     }

     return true;
 }
 
/**
 * 시트 Change 이벤트 처리
 */
 function sheet1_OnChange(sheetObj, row, col, val){

	var formObject 	  = document.form;
    var col_save_name = sheetObj.ColSaveName(col);
 	if (col_save_name != "Sel"){
	    var bl_no         = sheetObj.CellValue(row, "bl_no");
	    var cntr_no       = sheetObj.CellValue(row, "cntr_no").toUpperCase();
 	}
 	
 	if (col_save_name == "cntr_no"){
 		if(cntr_no == 'NC') {
 			sheetObj.CellValue2(row, "cntr_tpsz_cd") = "";
 			sheetObj.CellValue(row, "seal_no") = "";
 			sheetObj.CellValue(row, "seal_no2") = "";
 			return;
 		}
 		
 		for(i=1; i<sheetObj.RowCount+1; i++){
 			if(i != row && sheetObj.CellValue(i, "cntr_no") == val){
 				//Container No. {?msg1} is duplicated. Check container number.
 				ComShowCodeMessage("BKG00965", val);
 				sheetObj.CellValue2(row, col) = "";
 				return;
 			}
 		}
 		doActionIBSheet(sheetObj,formObject,SEARCH01,row,col);
 	}

	/* seal_no */
	if (col_save_name == "seal_no" || col_save_name == "seal_no2") {
		var fmObject = sheetObjects[2];
		var arrRow = findText(fmObject, "cntr_no", cntr_no);
		var len = arrRow.length;
		if(len <= 1){
			if(val != ''){
				var newRow = fmObject.DataInsert(-1);
				fmObject.CellValue2(newRow, "bl_no") = bl_no;
				fmObject.CellValue2(newRow, "cntr_no") = cntr_no;
				fmObject.CellValue2(newRow, "seal_no") = val;					
			}
			else{
				if (col_save_name == "seal_no") {
					fmObject.CellValue2(arrRow[0], "seal_no") = val;
				}
				else{
					fmObject.CellValue2(arrRow[0], "seal_no") = val;
				}
			}
		} else {
			if (col_save_name == "seal_no") {
				fmObject.CellValue2(arrRow[0], "seal_no") = val;
			}
			else{
				fmObject.CellValue2(arrRow[1], "seal_no") = val;
			}
		}
		rowDelete(fmObject, "seal_no", '');
		setAllSealNo();			
	}
 }

/**
 * IBSheet에 셀 클릭시 팝업 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
    var bl_no = sheetObj.CellValue(Row, "bl_no");
    var cntr_no = sheetObj.CellValue(Row, "cntr_no");
    
	var url = "ESM_BKG_0697.do?bl_no=" +bl_no+ "&cntr_no=" + cntr_no;
	ComOpenWindowCenter(url, "ESM_BKG_0697", 360, 390, true);
}


/**
 * Multi Seal No. Input 팝업을 띄우기 위한 관련 함수이다.
 * 이하는 ESM_BKG_0079_04.js 에 정의된 함수를 복사한 것
 * 원본 함수 대비 약간의 변경 있음..
 */ 
function rowDelete(sheetObj, colName, colValue){
	var arrRow = findText(sheetObj, colName, colValue);
	for (ir = 0; ir < arrRow.length; ir++) {
		if(arrRow[arrRow.length-1-ir]=='') continue;
		sheetObj.RowStatus(arrRow[arrRow.length-1-ir]) = 'D';
	}
}

/**
 * sheetObject의 특정 컬럼의 조건값에 해당하는 열의 Index를 구하는 함수.
 */
function findText(sheetObj, colName, colValue){
	var idxs = new Array();
	var rcnt = sheetObj.RowCount + 1;
	for (ix = 1; ix < rcnt; ix++) {
		if(sheetObj.RowStatus(ix) != 'D' && sheetObj.CellValue(ix, colName) == colValue){
			idxs.push(''+ix);
		}
	}
	return idxs;
}


/**
 * 모든 Container Seal No 세팅
 */
function setAllSealNo(){
	var cntrObj = sheetObjects[0];
	
	var cntrCount = cntrObj.RowCount + 1;
	for(idx=1;idx<cntrCount;idx++){
		setSealNo(cntrObj.CellValue(idx, "cntr_no"));
	}
}

/**
 * 팝업에서 설정한 데이터 Seal No Hidden, Container 시트에 반영
 */
function setSealNo(cntr_no){
	var fmObject = sheetObjects[2]; // SealNo Hidden Sheet
	var toObject = sheetObjects[0]; // Container Sheet

	// Container 그리드 데이터 행의 개수 확인
	var arrToRow = findText(toObject, "cntr_no", cntr_no);
	if(arrToRow.length == 0){
		return;
	}
	if(arrToRow.length > 1){
		return;
	}		

	// SealNo 그리드 데이터 행의 개수 확인
	var arrFmRow = findText(fmObject, "cntr_no", cntr_no);
	if(arrFmRow.length == 1){
		toObject.CellValue2(arrToRow[0], "seal_no") = arrFmRow[0] == '' ? "" : fmObject.CellValue(arrFmRow[0], "seal_no");
		toObject.CellValue2(arrToRow[0], "seal_no2") = '';
	} else if(arrFmRow.length > 1){
		toObject.CellValue2(arrToRow[0], "seal_no") = arrFmRow[0] == '' ? "" : fmObject.CellValue(arrFmRow[0], "seal_no");
		toObject.CellValue2(arrToRow[0], "seal_no2") = arrFmRow[1] == '' ? "" : fmObject.CellValue(arrFmRow[1], "seal_no");
	} else {
		toObject.CellValue2(arrToRow[0], "seal_no") = '';
		toObject.CellValue2(arrToRow[0], "seal_no2") = '';
	}
}

/* 개발자 작업  끝 */