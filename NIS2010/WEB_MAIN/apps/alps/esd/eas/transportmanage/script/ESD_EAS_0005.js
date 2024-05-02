/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0005.js
*@FileTitle : Cancelled BKG’s Cntr Tracing
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-19
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-19 choice
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends Bkg
 * @class ESD_EAS_0005 : 예)Cancelled BKG’s Cntr Tracing 조회 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_EAS_0005() {
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

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
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
//    ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation manual <br>
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
//    ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
//    ComKeyOnlyNumber(event.srcElement);
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

	 var sheetObject1 = sheetObjects[0];
	 var formObject  = document.form;

	try{
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				if( validateForm(formObject) ) {
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				}
				break;

			case "btn_new":
				sheetObject1.RemoveAll();
				formObject.reset();
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				break;

			case "btn_calendar1":
				 var cal = new calendarPopup();
				 cal.select(formObject.occr_dt1, 'occr_dt1', 'yyyy-MM-dd');
				break;

			case "btn_calendar2":
        	        var cal = new calendarPopupFromTo();
	  				cal.displayType = "date";
					cal.select(formObject.occr_dt1, 'occr_dt1',formObject.occr_dt2, 'occr_dt2', 'yyyy-MM-dd');
				break;
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111') ;
		} else {
			ComShowMessage(e);
		}
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch4Post("ESD_EAS_0005GS.do", EasFrmQryString(formObj));
			break;
	   case IBDOWNEXCEL:        //엑셀 다운로드
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
}

function resetSearchCondition(formObj){
	
	formObj.reset();
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(16);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 2, 1, 10);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(28, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = " Seq.|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|BKG Data|TRO Loc.|TRO Q'ty"
				+"|CCT Ofc.|Exp Inv.|TRO Amt.|AR Rev.|Rev_Exp|Ex.Rate|TRO Ofc.|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type" ;

				var HeadTitle1 = " Seq.|Booking No.|B/L No.|POR|POL|POD|DEL|S/C No.|RFA No.|Cntr No.|Bnd|Term|TRO Loc.|TRO Q'ty"
				+"|CCT Ofc.|Exp Inv.|TRO Amt.|AR Rev.|Rev_Exp|Ex.Rate|TRO Ofc.|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type" ;
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//HeadRowHeight = 12;
				
				//데이터속성	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	 40,	daCenter,  true,	"seq",				false,		  "",	   dfNone,   	0,	 		true ,	   true );
				InitDataProperty(0, cnt++ , dtData,		 90,	daCenter,  false,	"bkg_no",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     95,	daCenter,  false,	"bl_no",       false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"por_cd",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"pol_cd",      false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,  false,	"pod_cd",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  false,	"del_cd",      false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 85,	daCenter,  false,	"sc_no",      	false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,	     85,	daCenter,  false,	"rfa_no",     	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 85,	daCenter,  false,	"cntr_no",   	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"bnd",         false,		  "",	   dfNone,	 	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"term",        false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_loc",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_qty",     false,		  "",	   dfNone,   	0,	 		false,	   false);				
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"cct_ofc",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"exp_inv",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"tro_amt",    	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"ar_rev",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"rev_exp",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,   true,	"ex_rate",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"tro_ofc",     false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_id",      false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"so_ofc",     	false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"so_id",       false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"rating_ofc",  false,		  "",	   dfNone,   	0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"rating_id",   false,		  "",	   dfNone,    0,	 		false,	   false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"sts",         false,		  "",	   dfNone,   	0,	 		false,	   false); 
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"trm_type",    false,		  "",	   dfNone,   	0,	 		false,	   false);

				HeadRowHeight = 20 ;
		   }
			break;

	}
}

//Office의 Text 변경시
function fun_officeText() {
	document.form.bkgno.value = document.form.bkgno.value.toUpperCase();
	document.form.blno.value = document.form.blno.value.toUpperCase();
	//document.form.cntrno.value = document.form.cntrno.value.toUpperCase();
}


function selectText(obj) {

	if( obj.name == "bkgno" ) {
		document.form.search_choice[0].checked = true;
	}else if( obj.name == "blno" ) {
		document.form.search_choice[1].checked = true;
	}
//	else if( obj.name == "cntrno"  ) {
//		document.form.search_choice[2].checked = true;
//	}
	
	selectWhere();
}


function selectWhere() {

	if( document.form.search_choice[0].checked == true ) {

		document.form.bkgno.disabled = false;
		document.form.bkgno.value = "";
		document.form.bkgno.focus();
		
		document.form.search_choice[1].checked = false;
		document.form.blno.value = "";
	
//		document.form.search_choice[2].checked = false;
//		document.form.cntrno.value = "";
		
	} else if( document.form.search_choice[1].checked == true ) {

		document.form.blno.disabled = false;
		document.form.blno.value = "";
		document.form.blno.focus();
		
		document.form.search_choice[0].checked = false;
		document.form.bkgno.value = "";
	
//		document.form.search_choice[2].checked = false;
//		document.form.cntrno.value = "";

	}
//	else if( document.form.search_choice[2].checked == true ) {
//
//		document.form.cntrno.disabled = false;
//		document.form.cntrno.value = "";
//		document.form.cntrno.focus();
//		
//	} 

}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj){

	var result = true ;
	
	if( formObj.search_choice[0].checked == false &&
		formObj.search_choice[1].checked == false ){
		ComShowMessage('Please enter the inquiry option');
		result = false;
	}else if( formObj.search_choice[0].checked == true ){
		if( ComIsEmpty(formObj.bkgno) ){
			ComShowCodeMessage('EAS90004', 'Cancelled BKG No');
			result = false;
		}
	}else if( formObj.search_choice[1].checked == true ){
		if( ComIsEmpty(formObj.blno) ){
			ComShowCodeMessage('EAS90004', 'Cancelled B/L No');
			result = false;
		}
	}
//	else if( formObj.search_choice[2].checked == true ){
//	
//		if( ComIsEmpty(formObj.cntrno) ){
//			ComShowCodeMessage('EAS90004', 'Cancelled Container');
//			result = false;
//			
//		}
//		
//		if( ComIsEmpty(formObj.bkgno) || ComIsEmpty(formObj.blno) ){
//			ComShowCodeMessage('EAS90004', 'Cancelled BKG No or Cancelled B/L No');
//			result = false;
//			
//		}
//	}

	return result;
}
