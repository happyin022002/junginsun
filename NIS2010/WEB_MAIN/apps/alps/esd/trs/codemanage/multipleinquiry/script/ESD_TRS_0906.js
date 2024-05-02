/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0906 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0906() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수 */
//var calPop = new calendarPopupGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;

var sheet = null

if(sheet == 2) {
	var sheetObj = sheetObjects[1];
} else {
	var sheetObj = sheetObjects[0];
}

/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
			
			case "btng_rowadd":
    			doActionIBSheet(sheetObject,formObject,IBINSERT);
			break;
			
			case "btng_apply":
				comPopupOK(sheetObject,formObject);
			break;
			
			case "btn_close":
				window.close();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	var opener_len = 0;
	
	// openerval
	if( !(document.form.openerval.value == '' || document.form.openerval.value == undefined) ){
		// default token 값
		var token = ",";
		// token 값이 전달되었을경우
		if( !(document.form.token.value == '' || document.form.token.value == undefined) ){
			token = document.form.token.value;
		}
		
		var opener_val = document.form.openerval.value;
		var opener_vals = opener_val.split(token);
		opener_len = opener_vals.length;
		
		for(i=0; i < opener_vals.length; i++) {
			var row = sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue(row, "multiplekey") = opener_vals[i];
		}
	}
	
	for(i=opener_len; i < 6; i++) {
		sheetObjects[0].DataInsert(i);
	}
	onload();

	//html컨트롤 이벤트초기화
	initControl();

}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
}

//Axon 이벤트 처리2. 이벤트처리함수 --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//    ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//    form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value = "";
    else
	form.boo_bl_no.value = form.hdn_boo_bl_no.value;
	*/
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
    //입력Validation 확인하기
//    return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//    ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//    ComKeyOnlyNumber(event.srcElement);
}

	//Axon 이벤트 처리2. 이벤트처리함수 --- end

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
				// 높이 설정
				style.height = 180;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, false, false, false,false)

				var HeadTitle = "Seq.|Chk|header";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,        CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,      30,    daCenter,  false,    "",				false,          "",       dfNone,        0,       false,      false);
				InitDataProperty(0, cnt++ , dtCheckBox, 30,    daCenter,  false,    "check",		false,          "",       dfNone,        0,       true,       true);
				InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "multiplekey",  false,			"",       dfNone,        0,       true,       true,	  50,	 true,	 true,	   "",	  false);
			}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBINSERT:      // 입력
			var lvcnt = 0;
			var lvrow = sheetObj.RowCount;
			if( !isNaN(formObj.row_count.value) ) {
				lvcnt = eval(formObj.row_count.value);
				if( !donumberheck(lvcnt) ) {
					for(i=lvrow; i < lvcnt+lvrow; i++){
						sheetObj.DataInsert(i);
					}
				} else {
					sheetObj.DataInsert(-1);
					formObj.row_count.value = "1";
				}
			} else {
				formObj.row_count.value = "1";
			}
		break;
		
		case IBCOPYROW:        //행 복사
			sheetObj.DataCopy();
		break;

		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
		break;

		case IBLOADEXCEL:        //엑셀 업로드
			sheetObj.LoadExcel();
		break;
	}
}

/**
 * Location 이나 Contry Code 입력시 이벤트처리 
 *
 */
function sheet1_OnChange(sheetObj, row, col, value){
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	var inputStr = delSpace(value);
	switch(colName){
		case 'multiplekey':
			for (var i = 0; i < inputStr.length; i++) {
				var oneChar = inputStr.charAt(i);
				if (oneChar != "") {
					if ( hanCheck(oneChar) ) {
						var errMessage = ComGetMsg('COM12127','Multiple Inquiry data!','','');  
						ComShowMessage(errMessage);
						sheetObj.CellValue(row,col)="";
						formObject.sheet1.SelectCell(row, col);
						loopval ="N";
						break;
					}else{
						continue;
					}
				} else {
					break;
				}
			}
			var chkval=ComTrim(sheetObj.CellValue(row, 'multiplekey'));
			if(chkval=="") {
				sheetObj.CellValue(row,'check')="0";
				sheetObj.CellValue(row,col)="";
			} else {
				sheetObj.CellValue(row,'check')="1";
			}
		break;
	}
}

// 한글 여부 체크.
// 입력 문자열이 한글이면 true, 한글이 아니면 false.
function hanCheck(str) {
	var str1 = getByteLenval(str);
	if(str.length*2 == str1) // 한글이면
		return true;
	else    // 한글이 아니면
		return false;
}

// 입력받은 String의 Byte Size를 구한다.
function getByteLenval(str) {
	var len = 0;
	if( str == null ) return 0;
	for( var i = 0 ; i < str.length ; i++ ) {
		var c = escape(str.charAt(i));
		if ( c.length == 1 ) len ++;
		else if( c.indexOf("%u") != -1 ) len += 2;
		else if( c.indexOf("%") != -1 ) len += c.length/3;
	}
	return len;
} 

// 문자열 사이의 공백을 제거
function delSpace(str) {
	var trimstr = str;
	for (var i=0; i< str.length;i++) {
		trimstr = trimstr.replace(' ' ,'');
	}
	return trimstr;
}
	
function comPopupOK(sheetObj,formObject) {
	var formObject = document.form;
	var checkRows;
	var colsCnt = sheetObj.LastCol + 1;
	var rows = sheetObj.Rows;

	var rArray = null; //행데이터를 담고 있는 배열
	var cArray = null; //열데이터를 담고 있는 배열

	var return_val = formObject.returnval.value;

	checkRows = sheetObj.CheckedRows("check");
	if(checkRows == 0) {
		ComShowCodeMessage("TRS90036");
		return;
	} else {
		var idx = 0;
		var chkval = "";
		rArray = new Array(checkRows);

		for(var i = 0; i < rows; i++) {
			if(sheetObj.CellValue(i, "check") == 1) {
				cArray = new Array(colsCnt);
				for(var j=0; j<cArray.length; j++) {
					chkval=sheetObj.CellValue(i, 'multiplekey');
					if(chkval=="") {
						var errMessage = ComGetMsg('COM12114','Multiple Inquiry data!','','');  
						ComShowMessage(errMessage);
						sheetObj.CellEditable(i,'multiplekey') = true;
						sheetObj.SelectCell(i, 'multiplekey');
						return;
					}
					cArray[j] = chkval;
				}
				chkval=sheetObj.CellValue(i, 'multiplekey');
				rArray[idx++] = chkval;
			}
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(0,0,0);
		}
	}
	var xxx = sheetObj.FindCheckedRow("check"); 
	var xxxRow = xxx.split("|");
	var errcnt = 0;
	var dupcnt = 0;
	for(var i = 0; i < xxxRow.length-2; i++){
		for(var j = i+1; j < xxxRow.length-1; j++){
			if(sheetObj.CellValue(xxxRow[i],'multiplekey') == sheetObj.CellValue(xxxRow[j],'multiplekey')){				
				sheetObj.RowBackColor(xxxRow[j]) = sheetObj.RgbColor(255,255,0);
				if(errcnt == 0){
					dupcnt = xxxRow[j];
				}
				errcnt++;
			}
		}
	}
	if(errcnt > 0){
		var errMessage = ComGetMsg('COM12115','Multiple Inquiry data!','','');  
		ComShowMessage(errMessage);
		//sheetObj.CellValue(xxx,'multiplekey')="";
		sheetObj.CellEditable(dupcnt,'multiplekey') = true;
		sheetObj.SelectCell(dupcnt, 'multiplekey');
	}else{
		var return_row = formObject.returnrow.value;
		if(return_row == '' || return_row == undefined){
			opener.getTRS_ENS_906(rArray,return_val);  //호출하는 부모js에 getTRS_ENS_906펑션을 붙여넣으면됩니다.
		}else{
			opener.getTRS_ENS_906(rArray,return_val,return_row);  //호출하는 부모js에 getTRS_ENS_906펑션을 붙여넣으면됩니다.
		}
		window.close();
	}	
}

function onload() {
	var formObject = document.form;
	//formObject.sheet1.ColHidden(1) = true;	// 마지막컬럼인인 특정셋팅 컬럼인지는 모르겠으나 히든설정이 안되는것도 있음(수정바람~~!)
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,return_val) {
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[i];
		//formObject.sheet1.CellValue2(row_val, col_val) = colArray;
	}
}

//MoveColumnPos("stockNm", "payAmt");

function sheet1_OnKeyDown1(sheetObj, row, col, keycode, Shift) {
	var colName = sheetObj.ColSaveName(col);
	if( keycode == 9 || keycode == 13 ){
		sheetObj.CellEditable(row,'multiplekey') = true;
	}
}

function sheet1_OnKeyUp(sheetObj, row, col, keycode, Shift) {
	var colName = sheetObj.ColSaveName(col);
	if( keycode == 9 || keycode == 13 ){
		sheetObj.CellEditable(row,'multiplekey') = true;
		sheetObj.SelectCell(row, 'multiplekey');
	}
}

/**
 * 숫자에 대한 유효성을 체크.
 */
function donumberheck(obj) {
	var lveng = /[0-9]/;
	if( lveng.test(obj) ) {
		return false;
	}
	return true;
}