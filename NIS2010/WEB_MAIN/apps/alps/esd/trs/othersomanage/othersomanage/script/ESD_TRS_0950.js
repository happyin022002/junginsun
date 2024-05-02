/**
 * @extends Bkg
 * @class ESD_TRS_0950 : Other S/O Equipment File Import
 */
function ESD_TRS_0950() {
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

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

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

			
			case "btng_fileimport":
				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
				break;

			case "btng_delete":
				doActionIBSheet(sheetObject,formObject,IBDELETE);
				break;

			case "btng_verify":
				importEqNo(sheetObject, formObject);
				break;

			 case "btn_close":
				  window.close();
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
				InitColumnInfo(13, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "Seq.|STS||EQ No|Verify Result" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,		false,    "eq_seq",			false,		"",		dfNone,		0,		false,		false	);
				InitDataProperty(0, cnt++ , dtStatus,		100,		daCenter,		false,    "ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,		false,    "ibcheck");
				InitDataProperty(0, cnt++ , dtData,			80,	daLeft,			false,    "eq_no",				false,		"",		dfNone,		0,		false,		false	);
				InitDataProperty(0, cnt++ , dtData,			170,	daLeft,			false,    "verify_result",	false,		"",		dfNone,		0,		false,		false	);

				InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"vndr_seq");
				InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"vndr_abbr_nm");
				InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,  "lstm_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"ownr_co_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,  "usr_co_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"mvmt_sts_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,  "lst_sts_yd_cd");
				InitDataProperty(0, cnt++ , dtHidden,     0, daCenter,	false,	"mvmt_dt");

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
			break;
		case IBDELETE:        //저장
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');

			for(var k=checkArray.length-2; k>=0; k--)
			{
				sheetObj.RowDelete(checkArray[k], false);
			}
			break;

	   case IBINSERT:      // 입력
			sheetObj.DataInsert();
			break;


	   case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
			break;

	   case IBLOADEXCEL:        //엑셀 업로드
			sheetObj.RemoveAll();
			sheetObj.LoadExcel();

			var costMode = window.dialogArguments.document.form.trs_cost_md_cd.value;

			if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' ){
				for(var i=1; i<sheetObj.RowCount+1; i++){
					sheetObj.CellValue2(i, 'eq_no') = cntrCheckDigit(sheetObj.CellValue(i, 'eq_no'));		
				}
			}
			break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){

	}
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

function importEqNo(sheetObj, formObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	sheetObj.RemoveEtcData();
	var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
	if(queryStr=='') return false;

//	var costMode = window.dialogArguments.document.form.trs_cost_md_cd.value;
var costMode = "CY";

	if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' ){
		document.form.f_cmd.value = SEARCH01;
	}else if(costMode=='HD' || costMode=='HN' || costMode=='HF'){
		document.form.f_cmd.value = SEARCH02;
	}else if(costMode=='GN' || costMode=='GF'){
		document.form.f_cmd.value = SEARCH03;
	}else{
		ComShowCodeMessage('TRS90205');
		window.dialogArguments.form.trs_cost_md_cd.focus();
		return;
	}
	var searchXml = sheetObj.GetSaveXml("ESD_TRS_0018GS.do", queryStr+'&'+TrsFrmQryString(formObj));
	sheetObj.LoadSearchXml(searchXml, false, -1, true); //LoadSearchXml이 끝나면 sheet1_OnSearchEnd가 진행

}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if (verifyEqNo(sheetObj)) //2007.03.07 : 박수민 과장 요청으로 VERIFY로직 삭제..
		{
			window.dialogArguments.importEqNo(sheetObj, self.window);
		}
	}
}


/**
* S/O Creation시 2주이내에 create됐는지 여부 확인
*/
function verifyEqNo(sheetObj)
{
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var returnFlag = true;

	if(checkList == '')
	{
		ComShowCodeMessage('COM12176');
		return false;
	}

	for(var k=0; k<checkArray.length-1; k++)
	{
		var row = checkArray[k];
		var eq_no = sheetObj.CellValue(row, 'eq_no');
		
		if(sheetObj.EtcData(eq_no) != '' &&  sheetObj.EtcData(eq_no) != undefined)
		{
			sheetObj.CellValue2(row, 'verify_result') = 'OK';
			sheetObj.RowBackColor(row) = 15723503;
		}else
		{
			sheetObj.CellValue2(row, 'verify_result') = 'Not Hanjin data';
			sheetObj.RowBackColor(row) = sheetObj.RgbColor(238,255,226);
			sheetObj.CellValue2(row, 'ibcheck') = '0'; //이경우 부모창으로 전송되지 않도록 체크해제
		}
	}
	return returnFlag;

}