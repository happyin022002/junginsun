/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0078 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0078() {
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

			case "btng_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;

			case 'btng_delete':
				doActionIBSheet(sheetObject,formObject,IBDELETE);
				break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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
    //Axon ??? ??1. ???catch
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
}

//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
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
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//            ComKeyOnlyNumber(event.srcElement);
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
				style.height = GetSheetHeight(10);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 2, 0, true);
//				InitColumnInfo(11, 2, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "STS||Office|Cost Mode|Trans Mode|Bound|Remarks|Created Date|Creation Office|User ID" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				//데이터속성       [ROW, COL,    DATATYPE,  WIDTH,  DATAALIGN, COLMERGE,   SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtStatus,     30,   daCenter,   false,    "ibflag");
				InitDataProperty(0, cnt++,  dtDummyCheck, 30,   daCenter,   false,    "ibcheck");
				InitDataProperty(0, cnt++ , dtData,	      80,	daCenter,	false,    "wo_instr_ofc_cd",	true,	"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtCombo,	 150,	daCenter,	false,    "trsp_cost_mod_cd",	true,	"",			dfNone,			0,			false,			true	);
				InitDataProperty(0, cnt++ , dtCombo,	 120,	daCenter,	false,    "trsp_crr_mod_cd",	true,	"",			dfNone,			0,			false,			true	);
				InitDataProperty(0, cnt++ , dtCombo,	  60,	daCenter,	false,    "trsp_bnd_cd",		true,	"",			dfNone,			0,			false,			true	);
				InitDataProperty(0, cnt++ , dtData,	     200,	daLeft,		false,    "wo_instr_rmk",		true,	"",			dfNone,			0,			true,			true	);
				InitDataProperty(0, cnt++ , dtData,	      80,	daCenter,	false,    "cre_dt",				false,	"",			dfDateYmd,		0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	     100,	daCenter,	false,    "cre_ofc_cd",			false,	"",			dfNone,			0,			false,			false	);
				InitDataProperty(0, cnt++ , dtData,	     100,	daCenter,	false,    "cre_usr_id",			false,	"",			dfNone,			0,			false,			false	);

				InitDataCombo(0, 'trsp_crr_mod_cd' , " |"+f_trsp_crr_mod_cdText , " |"+f_trsp_crr_mod_cdCode);
				InitDataCombo(0, 'trsp_cost_mod_cd', " |"+f_trsp_cost_mod_cdText, " |"+f_trsp_cost_mod_cdCode);
				InitDataCombo(0, 'trsp_bnd_cd'     , " |"+f_trsp_bnd_cdText     , " |"+f_trsp_bnd_cdCode);
				ColHidden('ibflag')			= true;
		   }
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction))
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch4Post("ESD_TRS_0078GS.do", TrsFrmQryString(formObj));
			break;
		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}

			var sheetObj1 = sheetObjects[1];
			
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}
			var checkArray = checkList.split('|');

			sheetObj.RemoveEtcData();
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESD_TRS_0078GS.do", TrsFrmQryString(formObj), 'ibcheck',false);
			
			break;

		case IBINSERT:      // 입력
			sheetObj.DataInsert(-1);
			var row = sheetObj.SelectRow;
//			sheetObj.CellValue2(row, 'wo_instr_ofc_cd')= formObj.FORM_USR_OFC_CD.value;
//			sheetObj.CellValue2(row, 'cre_ofc_cd'     )= formObj.FORM_USR_OFC_CD.value;
//			sheetObj.CellValue2(row, 'cre_usr_id'     )= formObj.FORM_CRE_USR_ID.value;
			sheetObj.CellValue2(row, 'wo_instr_ofc_cd')= formObj.f_usr_ofc_cd.value;
			sheetObj.CellValue2(row, 'cre_ofc_cd'     )= formObj.f_usr_ofc_cd.value;
			sheetObj.CellValue2(row, 'cre_usr_id'     )= formObj.f_cre_usr_id.value;			
			
			sheetObj.CellValue2(row, 'ibcheck'        )= 1;
			break;

		case IBDELETE:
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}
			var checkArray = checkList.split('|');
			for(var k=checkArray.length-2; k>=0; k--)
			{
				if(sheetObj.RowStatus(checkArray[k]) == 'I')
					sheetObj.RowDelete(checkArray[k], false);
			}
			checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			if(checkList== '') return false;
			//-------------[ 200890819 CJO add s]---------------
			if(checkArray.length > 0) {
				for(var d=0; d<checkArray.length-1; d++){
					var delIdx = checkArray[d];
					sheetObj.CellValue(delIdx, 'ibflag')= "D";
				}
			}
			//-------------[ 200890819 CJO add e]---------------
			var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
			formObj.f_cmd.value = REMOVE01;
			sheetObj.DoSave("ESD_TRS_0078GS.do",TrsFrmQryString(formObj),'ibcheck',false);

			for(var k=checkArray.length-2; k>=0; k--)
			{
				sheetObj.RowDelete(checkArray[k], false);
			}
			break;

		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
			break;

	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){

	return true;
}



  /**
 * MInimize 클릭시 이벤트 관련
 */
function Minimize(nItem)
{

	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";


		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =20;

	}
	else
	{
		objs.style.display = "inline";

		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =10;

	}

}

function sheet1_OnChange(sheetObj, row, col, value){
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	switch(colName){
		case 'trsp_cost_mod_cd':
		case 'trsp_crr_mod_cd':
		case 'trsp_bnd_cd':
			if( sheetObj.ColValueDup('trsp_cost_mod_cd|trsp_crr_mod_cd|trsp_bnd_cd') != -1)
			{
				ComShowCodeMessage('COM12115', 'CostMode and TransMode and Bound');
				sheetObj.CellValue2(row, colName) = '';
				return;
			}
			break;
	}
	sheetObj.CellValue2(row, 'ibcheck')= 1;
}





