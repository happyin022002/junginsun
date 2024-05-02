/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0004.js
*@FileTitle : C/H Auditing - TRO vs. AR Rev
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-15
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-15 choice
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
 * @class ESD_EAS_0004 : 예)C/H Auditing - TRO vs. AR Rev 조회 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_EAS_0004() {
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
//		comConfigSheet(sheetObjects[i],SYSTEM_ENIS);
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
//  ComKeyOnlyAlphabet('uppernum');
}

/**
* BKG Creation manual <br>
**/
function manual_click() {
  //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//  form.boo_bkg_no.readOnly =!form.manual.checked;
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
//  return ComChkObjValid(event.srcElement);
}

/**
* HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
**/
function obj_focus(){
//  ComClearSeparator(event.srcElement);
}

/**
* HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
**/
function obj_keypress(){
//  ComKeyOnlyNumber(event.srcElement);
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
					duplicateCheck(sheetObject1);
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
			case "btns_office": 
				if( isInputField(formObject) ) {
					var ofc_cd = formObject.ctrl_ofc_cd.value;
					var selofc_cd = formObject.sel_ofc_cd.value;
					ComOpenWindow('ESD_EAS_COM_0001.screen?ctrl_ofc_cd='+ofc_cd+'&sel_ofc_cd='+selofc_cd, 'ESD_EAS_COM_0001', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				}
				break;
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
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
			sheetObj.DoSearch4Post("ESD_EAS_0004GS.do", EasFrmQryString(formObj));
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
				style.height = GetSheetHeight(12);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
//				MergeSheet = msPrevColumnMerge;
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				//InitRowInfo( 1, 1, 9, document.form.row_size.value);
				InitRowInfo( 2, 1, 10);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(30, 0, 0, true);

				//헤더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)

				var HeadTitle = "SEQ|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail|BKG Detail"
				+"|BKG Detail|BKG Detail|S/O|AR Inv.|(R)-(P)|CCT Ofc.|Ex.Rate|MANIFESTED AMT|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type|Investigation" ;

				var HeadTitle1 = "SEQ|Booking No.|B/L No.|POR|POL|POD|DEL|S/C No.|RFA No.|Cntr Q'ty|Bnd|Term|TRO Ofc.|TRO Loc."
				+"|TRO Q'ty|TRO Amt.|Exp Inv.(P)|Rev.(R)|(R)-(P)|CCT Ofc.|Ex.Rate|MANIFESTED AMT|TRO ID|S/O Ofc.|S/O ID|Rating Ofc.|Rating ID|Sts|Trm_Type|Investigation" ;
				
				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				HeadRowHeight = 12;
				
				//데이터속성	[ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,  	 40,	daCenter,  true,	"seq",			false,      "",			dfNone,			0,		true,		true,		0,		false,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"bkg_no",		false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,	     85,	daCenter,  true,	"bl_no",		false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  true,	"por_cd",		false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  true,	"pol_cd",		false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 50,	daCenter,  true,	"pod_cd",		false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,	     50,	daCenter,  true,	"del_cd",		false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"sc_no",      	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,	     80,	daCenter,  true,	"rfa_no",		false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"cntr_qty",  	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"bnd",         	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"term",        	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,  true,	"tro_ofc",     	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_loc",    	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"tro_qty_ch",     	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,	true,	"tro_amt",    	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,    true,	"exp_inv",     	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daRight,    true,	"ar_rev",      	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daRight,    true,	"rev_exp",     	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,   true,	"cct_ofc",    	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daRight,    true,	"ex_rate",     	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 110,	daRight,    true,	"chg_amt",     	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,  true,	"tro_id",      	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"so_ofc",     	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 60,	daCenter,  true,	"so_id",       	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 80,	daCenter,  true,	"rating_ofc",  	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"rating_id",    false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 30,	daCenter,  true,	"sts",         	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false); 
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"trm_type",    	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				InitDataProperty(0, cnt++ , dtData,		 70,	daCenter,  true,	"rmk_ctnt",    	false,      "",			dfNone,			0,		true,		true,		0,		true,	true,		"",		false);
				
		   }
			break;

	}
}

function sheet1_OnDblClick(sheetObj, row, col ){

    var selctrl_ofc_cd   =  "";
    var sels_type        =  "";
    var sels_bnd         =  "";
    var selsomonth       =  "";
    var selinvmonth      =  "";
    var selfromsodate    =  "";
    var seltosodate      =  "";
    var selfrominvdate   =  "";
    var seltoinvdate     =  "";
    var selbkgno         =  "";
    var selvvdno         =  "";
    var selblno          =  "";
    
    selctrl_ofc_cd  =	document.form.ctrl_ofc_cd.value.toUpperCase();
    sels_type       =	document.form.s_type.value.toUpperCase();
    sels_bnd        =	document.form.s_bnd.value.toUpperCase();
    selsomonth      =	document.form.somonth.value.toUpperCase();
    selinvmonth     =	document.form.invmonth.value.toUpperCase();
    selfromsodate   =	document.form.fromsodate.value.toUpperCase();
    seltosodate     =	document.form.tosodate.value.toUpperCase();
//    selfrominvdate  =	document.form.frominvdate.value.toUpperCase();
//    seltoinvdate    =	document.form.toinvdate.value.toUpperCase();
    selvvdno        =	document.form.vvdno.value.toUpperCase();
	selbkgno		=	sheetObj.CellValue(row, "bkg_no");
	selblno			=	document.form.blno.value.toUpperCase();
    
//    var selval = sheetObj.CellValue(row, "cntr_qty");
    if(col != 28){
//	    if( selval > 1 ){
	        ComOpenWindow('ESD_EAS_0904.screen?bkgno='+selbkgno+'&ctrl_ofc_cd='+selctrl_ofc_cd
				    +'&s_type='+sels_type+'&s_bnd='+sels_bnd+'&somonth='+selsomonth
				    +'&invmonth='+selinvmonth+'&fromsodate='+selfromsodate+'&tosodate='+seltosodate    
				    +'&frominvdate='+selfrominvdate+'&toinvdate='+seltoinvdate+'&vvdno='+selvvdno  
				    , 'ESD_EAS_0904', 'top=200, left=200, width=700, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=1');
//	    }else {
//	    	ComShowCodeMessage('EAS90006');
//	    }
    }else{
    	var theURL = "ESD_EAS_0901.do?bkg_no=" + sheetObj.CellValue(row, 'bkg_no') + "&eas_expn_tp_cd=CA";
    	var winName = "ESD_EAS_0901";
    	var features = "width=700,height=365,toolbar=no,location=no,status=yes,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
    	
    	ComOpenWindow(theURL,winName,features);
//    	openRemarkPopup(sheetObj.CellValue(row,"bkg_no"), sheetObj.CellValue(row,"bl_no"), 'CA');
    }
}


//Office의 Text 변경시
function fun_officeText() {
	document.form.ctrl_ofc_cd.value = document.form.ctrl_ofc_cd.value.toUpperCase();
	document.form.chk_office.checked = false;
}

function rtn_office_code(obj) {
	document.form.ctrl_ofc_cd.value = obj;
}


function selectText(obj) {

	if( obj.name == "fromsodate" ) {
		document.form.search_choice[0].checked = true;
		document.form.search_choice[1].checked = false;
		document.form.search_choice[2].checked = false;
		document.form.search_choice[3].checked = false;
//		document.form.search_choice[4].checked = false;
//		document.form.search_choice[5].checked = false;
		selectWhere();
		
	}else if( obj.name == "tosodate" ) {
		document.form.search_choice[0].checked = true;
		document.form.search_choice[1].checked = false;
		document.form.search_choice[2].checked = false;
		document.form.search_choice[3].checked = false;
//		document.form.search_choice[4].checked = false;
//		document.form.search_choice[5].checked = false;
		
		if( document.form.fromsodate.value == "YYYYMMDD" ){
			document.form.fromsodate.value = "";
		}
		document.form.tosodate.value = "";
		
//	}else if( obj.name == "frominvdate" ) {
//		document.form.search_choice[0].checked = false;
//		document.form.search_choice[1].checked = true;
//		document.form.search_choice[2].checked = false;
//		document.form.search_choice[3].checked = false;
//		document.form.search_choice[4].checked = false;
//		document.form.search_choice[5].checked = false;
//
//		selectWhere();
//		
//	}else if( obj.name == "toinvdate" ) {
//		document.form.search_choice[0].checked = false;
//		document.form.search_choice[1].checked = true;
//		document.form.search_choice[2].checked = false;
//		document.form.search_choice[3].checked = false;
//		document.form.search_choice[4].checked = false;
//		document.form.search_choice[5].checked = false;
//
//		if( document.form.frominvdate.value == "YYYYMMDD" ){
//			document.form.frominvdate.value = "";
//		}		
//		document.form.toinvdate.value = "";
//		
	}else if( obj.name == "bkgno" ) {
		document.form.search_choice[0].checked = false;
		document.form.search_choice[1].checked = true;
		document.form.search_choice[2].checked = false;
		document.form.search_choice[3].checked = false;
//		document.form.search_choice[4].checked = false;
//		document.form.search_choice[5].checked = false;
		
		selectWhere();
		
	}else if( obj.name == "vvdno" ) {
		document.form.search_choice[0].checked = false;
		document.form.search_choice[1].checked = false;
		document.form.search_choice[2].checked = true;
		document.form.search_choice[3].checked = false;
//		document.form.search_choice[4].checked = false;
//		document.form.search_choice[5].checked = false;
		
		selectWhere();
		
	}else if( obj.name == "blno" ) {
		document.form.search_choice[0].checked = false;
		document.form.search_choice[1].checked = false;
		document.form.search_choice[2].checked = false;
		document.form.search_choice[3].checked = true;
//		document.form.search_choice[4].checked = false;
//		document.form.search_choice[5].checked = false;
		
		selectWhere();
	}
	
	
}


function selectWhere() {

	if( document.form.search_choice[0].checked == true ) {

		document.form.d_type.value = "TRO";
		document.form.fromsodate.disabled = false;
		document.form.tosodate.disabled = false;
		document.form.fromsodate.value = "";
		document.form.tosodate.value = "";
		document.form.fromsodate.focus();
		
//		document.form.search_choice[1].checked = false;
//		document.form.search_choice[2].checked = false;
				
		document.form.search_choice[1].checked = false;
		document.form.bkgno.value = "";
		
		document.form.search_choice[2].checked = false;
		document.form.vvdno.value = "";

		document.form.search_choice[3].checked = false;
		document.form.blno.value = "";		
	
//	} else if( document.form.search_choice[1].checked == true ) {
//
//		document.form.d_type.value = "SO";
//		document.form.fromsodate.disabled = false;
//		document.form.tosodate.disabled = false;
//		document.form.fromsodate.value = "";
//		document.form.tosodate.value = "";
//		document.form.fromsodate.focus();
//		
//		document.form.search_choice[0].checked = false;
//		document.form.search_choice[2].checked = false;
//				
//		document.form.search_choice[3].checked = false;
//		document.form.bkgno.value = "";
//		
//		document.form.search_choice[4].checked = false;
//		document.form.vvdno.value = "";
//
//		document.form.search_choice[5].checked = false;
//		document.form.blno.value = "";		
//		
//		
//	} else if( document.form.search_choice[2].checked == true ) {
//
//		document.form.d_type.value = "INV";
//		document.form.fromsodate.disabled = false;
//		document.form.tosodate.disabled = false;
//		document.form.fromsodate.value = "";
//		document.form.tosodate.value = "";
//		document.form.fromsodate.focus();
//		
//		document.form.search_choice[0].checked = false;
//		document.form.search_choice[1].checked = false;
//				
//		document.form.search_choice[3].checked = false;
//		document.form.bkgno.value = "";
//		
//		document.form.search_choice[4].checked = false;
//		document.form.vvdno.value = "";
//
//		document.form.search_choice[5].checked = false;
//		document.form.blno.value = "";			

	} else if( document.form.search_choice[1].checked == true ) {

		document.form.d_type.value = ""
		document.form.bkgno.disabled = false;
		document.form.bkgno.focus();
			
		document.form.search_choice[0].checked = false;
		document.form.fromsodate.value = "YYYYMMDD";
		document.form.tosodate.value = "YYYYMMDD";
				
//		document.form.search_choice[1].checked = false;
//		document.form.search_choice[2].checked = false;
		
		document.form.search_choice[2].checked = false;
		document.form.vvdno.value = "";

		document.form.search_choice[3].checked = false;
		document.form.blno.value = "";
			
	} else if( document.form.search_choice[2].checked == true ) {

		document.form.d_type.value = ""
		document.form.vvdno.disabled = false;
		document.form.vvdno.focus();
		
		document.form.search_choice[0].checked = false;
		document.form.fromsodate.value = "YYYYMMDD";
		document.form.tosodate.value = "YYYYMMDD";

//		document.form.search_choice[1].checked = false;
//		document.form.search_choice[2].checked = false;

						
		document.form.search_choice[1].checked = false;
		document.form.bkgno.value = "";

		document.form.search_choice[3].checked = false;
		document.form.blno.value = "";		
	
	} else if( document.form.search_choice[3].checked == true ) {

		document.form.d_type.value = ""
		document.form.blno.disabled = false;
		document.form.blno.focus();
		
		document.form.search_choice[0].checked = false;
		document.form.fromsodate.value = "YYYYMMDD";
		document.form.tosodate.value = "YYYYMMDD";

//		document.form.search_choice[1].checked = false;
//		document.form.search_choice[2].checked = false;
						
		document.form.search_choice[1].checked = false;
		document.form.bkgno.value = "";

		document.form.search_choice[2].checked = false;
		document.form.vvdno.value = "";		
	
	}

}



/**
 * 조회데이타의 중복처리 확인 프로세스 처리
 */
function duplicateCheck(sheetObj) {
	var row = sheetObj.RowCount;
//	var i = 1;
	
	if(row >= 2){
		for(var i = 1; row > i; i++){
			var bkg_no1 = sheetObj.CellValue(i, "bkg_no");
			var bkg_no2 = sheetObj.CellValue(i+1, "bkg_no");
			if(bkg_no1 == bkg_no2){
				sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(0,192,192);
//				sheetObj.RowBackColor(i+1) = sheetObj.RgbColor(192,0,192);
			}
		}
	}

}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj){
	var result = true ;
	// 검색 조건 입력 여부

	if( !isInputField(formObj) ) {
		result = false ;
	}else if( formObj.search_choice[0].checked == false &&
		formObj.search_choice[1].checked == false && 
		formObj.search_choice[2].checked == false &&
//		formObj.search_choice[3].checked == false &&
//		formObj.search_choice[4].checked == false &&
		formObj.search_choice[3].checked == false  ){
		ComShowMessage('Please enter the inquiry option');
		result = false;
	}else if( formObj.search_choice[0].checked == true ){
			
		if( ComIsEmpty(formObj.fromsodate) || ComIsEmpty(formObj.tosodate)){
			
			ComShowCodeMessage('EAS90004', 'TRO Date');
			result = false;
			
		}
//	}else if( formObj.search_choice[1].checked == true ){
//		
//		if( ComIsEmpty(formObj.fromsodate) || ComIsEmpty(formObj.tosodate)  ){
//			ComShowCodeMessage('EAS90004', 'S/O Date');
//			result = false;
//			
//		}		
//		
//	}else if( formObj.search_choice[2].checked == true ){
//	
//		if( ComIsEmpty(formObj.fromsodate) || ComIsEmpty(formObj.tosodate)  ){
//			ComShowCodeMessage('EAS90004', 'INV Date');
//			result = false;
//			
//		}
	}else if( formObj.search_choice[1].checked == true ){
	
		if( ComIsEmpty(formObj.bkgno) ){
			ComShowCodeMessage('EAS90004', 'BKG No');
			result = false;
			
		}
	}else if( formObj.search_choice[2].checked == true ){
	
		if( ComIsEmpty(formObj.vvdno) ){
			ComShowCodeMessage('EAS90004', 'V.V.D');
			result = false;
			
		}
	}else if( formObj.search_choice[3].checked == true ){
	
		if( ComIsEmpty(formObj.blno) ){
			ComShowCodeMessage('EAS90004', 'B/L No');
			result = false;
		
		}
	}

	return result;
}

function isInputField(formObj) {
	var result    = true ;

	if( ComIsEmpty(formObj.ctrl_ofc_cd) ) {
		ComShowCodeMessage('EAS90004', 'TRO Office');
		result = false;
	}
	return result;
}

function chkLength(formObj, len){
		
		
		
	if( formObj.name = "fromsodate" ){
		
		
		if( document.form.fromsodate.value.length == len && document.form.fromsodate.value != 'YYYYMMDD' ){
			document.form.tosodate.focus();
			document.form.fromsodate.value = document.form.fromsodate.value.toUpperCase();
		}
	}
	
	if( formObj.name = "frominvdate" ){
		
		
		if( document.form.frominvdate.value.length == len && document.form.frominvdate.value != 'YYYYMMDD' ){
			document.form.toinvdate.focus();
			document.form.toinvdate.value = document.form.toinvdate.value.toUpperCase();
		}
	}
}

//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

// Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.ctrl_ofc_cd.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.ctrl_ofc_cd.value = "";
		ComShowMessage("Please input the 'TRO Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
	
		var url = "ESD_EAS_0004GS.do?f_cmd="+SEARCH11+"&ctrl_ofc_cd="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		
		request.open("GET", url, false);

		request.onreadystatechange = subCntorlOffice;
		
		request.send(null);
	} else {
		document.form.ctrl_ofc_cd.value = document.form.old_ofc_cd.value;
	}
}

// Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			
			document.form.ctrl_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
			
			
		}

	}

}


function changeDtlType() {

	var selbnd = document.form.s_bnd.value;
	var inhtml = "";
	
	if( selbnd == 'I' ){
	
		inhtml = "<select style=\"width:210;\" name=\"s_dtltype\" >&nbsp;";
		inhtml = inhtml + "<OPTION value=\"I-0\" selected >No Select</OPTION>";
		inhtml = inhtml + "<OPTION value=\"I-1\" >1.Canceled BKG</OPTION>";
		inhtml = inhtml + "<OPTION value=\"I-6\" >2.Frustrated Haul</OPTION>";
		inhtml = inhtml + "<OPTION value=\"I-2\" >3.Port CY ===> Door</OPTION>";
		inhtml = inhtml + "<OPTION value=\"I-3\" >4.Port Door ===> Inland </OPTION>";
		inhtml = inhtml + "<OPTION value=\"I-4\" >5.Different Inland Door</OPTION>";
		inhtml = inhtml + "<OPTION value=\"I-5\" >6.All[I-1,2,3,4,5]</OPTION>";
		inhtml = inhtml+"</select>";
	
	}else if ( selbnd == 'O' ){

		inhtml = "<select style=\"width:210;\" name=\"s_dtltype\" >&nbsp;";
		inhtml = inhtml + "<OPTION value=\"O-0\" selected >No Select</OPTION>";
		inhtml = inhtml + "<OPTION value=\"O-1\" >1.Canceled BKG</OPTION>";
		inhtml = inhtml + "<OPTION value=\"O-6\" >2.Frustrated Haul</OPTION>";
		inhtml = inhtml + "<OPTION value=\"O-2\" >3.Port CY ===> Door</OPTION>";
		inhtml = inhtml + "<OPTION value=\"O-3\" >4.Port Door ===> Inland </OPTION>";
		inhtml = inhtml + "<OPTION value=\"O-4\" >5.Different Inland Door</OPTION>";
		inhtml = inhtml + "<OPTION value=\"O-5\" >6.All[O-1,2,3,4,5]</OPTION>";
		inhtml = inhtml+"</select>";
		
	}else {
		inhtml = "<select style=\"width:210;\" name=\"s_dtltype\" >&nbsp;";
		inhtml = inhtml + "<OPTION value=\"OI-0\" selected >No Select</OPTION>";
		inhtml = inhtml + "<OPTION value=\"OI-1\" >1.Canceled BKG</OPTION>";
		inhtml = inhtml + "<OPTION value=\"OI-6\" >2.Frustrated Haul</OPTION>";
		inhtml = inhtml + "<OPTION value=\"OI-2\" >3.Port CY ===> Door</OPTION>";
		inhtml = inhtml + "<OPTION value=\"OI-3\" >4.Port Door ===> Inland </OPTION>";
		inhtml = inhtml + "<OPTION value=\"OI-4\" >5.Different Inland Origin/Destination</OPTION>";
		inhtml = inhtml + "<OPTION value=\"OI-5\" >6.All[O/I-1,2,3,4,5]</OPTION>";
		inhtml = inhtml+"</select>";	
	}
	
	document.form.all.ScriptDiv.innerHTML = inhtml;
}
