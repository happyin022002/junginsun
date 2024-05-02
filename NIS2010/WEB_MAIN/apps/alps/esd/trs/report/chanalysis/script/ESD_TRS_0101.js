/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0101 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0101() {
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
//var calPop = new ComCalendarGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0 ;

var rdObjects = new Array();

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  */
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
				if (ComIsNull(formObject.so_fmdt) || ComIsEmpty(formObject.so_todt) || formObject.so_todt.value =="YYYYMMDD" || formObject.so_fmdt.value =="YYYYMMDD" )	{
						ComShowCodeMessage("TRS90124");
						return false;
				}
				if (formObject.so_fmdt.value.length == 8 ){
					if(ComGetDaysBetween(formObject.so_fmdt, formObject.so_todt) < 0) {
						ComShowCodeMessage("TRS90118");
						formObject.so_fmdt.focus();
						return false
					} else if ( dateCalcuration(formObject.so_fmdt.value , formObject.so_todt.value) > 365 ) {
						ComShowCodeMessage("TRS90101");
						return false;
					}
				} else if (formObject.so_fmdt.value.length == 6 ){
					if (formObject.so_fmdt.value != formObject.so_todt.value)	{
						ComShowCodeMessage("TRS90101");
						return false;
					}
				}

				doActionIBSheet(sheetObject,formObject,IBSEARCH,"");
			break;

			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
			break;

			case "btn_minimize":
				Mincount = (Mincount+1)%2 ;
				Minimize(Mincount);
			break;

			case "btns_calendar1":
				var cal = new ComCalendar();
				cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
			break;

			case "btng_sodetail":
				if ( dateCalcuration(formObject.so_fmdt.value , formObject.so_todt.value) > 31 ) {
					ComShowMessage( "Possible inquiry period is limited to 1 month.");
					return false;
				}

				goSoInquiry(sheetObject, formObject);
				break;

			case "btng_print":
// 본 시트에 넣어둔 다음 팝업을 열어 팝업에 RD 에 XML 을 셋팅한다.
			sheetObject.InitDataProperty2(0,1 , dtData, "width=60; data-align=daCenter; col-merge=false");



				doActionIBSheet(sheetObject,formObject,SEARCH01,"");

				break;        
				
			case "btng_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL,"");
			break;

			case "btns_calendar":
				getCalendar();
				
			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;

			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;

			case "btns_office": //M CNTR
				if( validation_check() ) {
					var ofc_cd = formObject.input_office.value;
					ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				}
			
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e);
		}
	}
}

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
function loadPage(){
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	sheetObjects[0].ExtendLastCol = false;
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	// 초기 설정 적용
		sheetObject.ColHidden("rev_2")=false ;
//	sheetObject.ColHidden("rev_3")=false ;
	sheetObject.ColHidden("wo_cost")=false ;
	sheetObject.ColHidden("inv_cost")=false ;
	sheetObject.ColHidden("diff_3")=false ;
	sheetObject.ColHidden("diff_4")=false ;
	change_cntp()

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
				style.height = GetSheetHeight(15) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 23);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(37, 5, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, true,false) ;

				var HeadTitle =  "Sts|Office|Bound|BKG\nTerm|TRO Status|D2|D4|D5|D7|D etc|R2|R4|R5|R7|R8|O/S 2|O/S 4|O5|O7|F/A 2|F/A 4|F5|P2|P4|T2|T4|TTL\n(BOX)|TRO Rev|Recal Rev\n(TRO)|Cost\n(W/O)|Cost\n(INV)|Recal Cost\n(W/O)|Profit\n(W/O)|Profit\n(INV)|Profit\n(TMP)" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성[ROW,COL,DATATYPE,    WIDTH,DATAALIGN,COLMERGE,SAVENAME,      KEYFIELD, CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0,cnt++,dtHiddenStatus,30,daCenter,false,"ibflag",   false, "", dfNone, 0, true , true,   0, false,	 true, "", false);
//				InitDataProperty(0,cnt++,dtStatus,  30,daCenter,false,    "ibflag",   false, "", dfNone, 0, true , true,   0, false,	 true, "", false);

/* 1*/			InitDataProperty(0,cnt++, dtData,   100,daCenter, false,    "wrk_ofc",   false, "", dfNone, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   50,daCenter, false,    "trsp_bnd_cd",    false, "", dfNone, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtHidden,   60,daCenter, false,    "term",  false, "", dfNone, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtHidden,   100,daCenter, false,    "tro_sts",   false, "", dfNone, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "d2",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "d4",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "d5",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "d7",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "d_etc",    false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "r2",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);


/* 11*/			InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "r4",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "r5",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "r7",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "r8",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);				
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "o2",      false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "o4",        false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "o5",        false, "", dfNumber, 0, false, false, 30, false,	 false, "", false); //20121022
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "o7",        false, "", dfNumber, 0, false, false, 30, false,	 false, "", false); //2018.05.08 추가 [CSR #3841]
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "f2",        false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "f4",      false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "f5",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "p2",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "p4",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);

/* 21*/			InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "t2",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "t4",       false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,   40,daCenter, false,    "vol_tot",  false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,  120,daRight, false,    "rev_1",	false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,  120,daRight, false,    "rev_2",	false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
//				InitDataProperty(0,cnt++, dtHidden,  120,daRight, false,    "rev_3",	false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,  120,daRight, false,    "wo_cost",   false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,  120,daRight, false,    "inv_cost",   false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,  120,daRight, false,    "recal_wo",   false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,  120,daRight, false,    "profit_wo",   false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);

				InitDataProperty(0,cnt++, dtData,  120,daRight, false,    "profit_inv",   false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtData,  120,daRight, false,    "profit_tmp",   false, "", dfNumber, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtHidden,   40,daCenter, false,    "vol_20",      false, "", dfNone, 0, false, false, 30, false,	 false, "", false);
				InitDataProperty(0,cnt++, dtHidden,   40,daCenter, false,    "vol_40",      false, "", dfNone, 0, false, false, 30, false,	 false, "", false);
			}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, chkflg) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회

			formObj.hid_fmdt.value = removeBar(formObj.so_fmdt.value);
			formObj.hid_todt.value = removeBar(formObj.so_todt.value);

			if(chkflg == "date") {
				formObj.f_cmd.value = SEARCH09;
				sheetObj.DoRowSearch("ESD_TRS_0101GS.do", TrsFrmQryString(formObj));
			} else{
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TRS_0101GS.do", TrsFrmQryString(formObj));
			}

		break;


		case SEARCH01:      //조회

			if( sheetObj.rowcount==0 ) {
				errMsg = 'No data found.';
				ComShowMessage(errMsg);
				return;
			}

			formObj.f_cmd.value = SEARCH01;

//			noRtnPopup('/hanjin/ESD_TRS_0206.do', 'width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0');            
			ComOpenPopup('/hanjin/ESD_TRS_0206.do', 800,688,'', '1,0,1,1,1,1,1,1');

		break;
		
		case IBDOWNEXCEL:        // excel down
			//sheetObj.SpeedDown2Excel(-1);
			sheetObj.Down2Excel(-1);
		break;
	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {

var i=0;
	
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {

		// week 입력했을때 해당 기간 찾아넣는다.
		if( document.form.f_cmd.value == SEARCH09 ){  
			document.form.so_fmdt.value = addBar( sheetObj.EtcData('fm_dt') );
			document.form.so_todt.value = addBar( sheetObj.EtcData('to_dt') );
		} else if(document.form.f_cmd.value == SEARCH ){ 

			

			var backCol = sheetObj.RgbColor(255,204,153 );

			for ( i=1; i<= sheetObj.rowcount ; i++ )	{

			if( sheetObj.CellValue(i, "wrk_ofc")  == 'TOTAL' )	 {
				sheetObj.RowBackColor(i) =    backCol;
			}

		}

	}
}
}



/**
 * MInimize 클릭시 이벤트 관련
 */
function Minimize(nItem) {
	var objs = document.all.item("showMin");
	if ( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =20;
	} else {
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(15);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =10;
	}
}


/**
 * ofc팝업호출
 */
function ofc_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_ofc";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 772, 450, 'getCOM_ENS_ofc', '1,0,1,1,1,1,1,1,1,1,1,1');
}
	  

//  string을 읽어들여 db 저장을 위해 하이픈('-')을 제거
function removeBar(str) {
	var value = "";
	for ( var i = 0; i < str.length; i++ ) {
		var ch = str.charAt(i);
		if ( ch != '-' ) value = value + ch;
	}
	return value;
}

// 유효 날짜 체크(2)
function isValidDate(date) {
	var year = date.substring(0,4);
	var month = date.substring(4,6);
	var day = date.substring(6,8);

	if (isDatecheck(year, month, day) ) {
		return true;
	} else {
		return false;
	}
}
	   
// 유효 날짜 체크(1)
function isDatecheck( year,month,day ) {
	if ( parseInt( year ) >= 1900  && checkMonth( month ) && checkDay( year, month, day ) ) {
		return true;
	} else {
		return false;
	}
}

// 월 체크
function checkMonth( month ) {
	var intmonth = parseInt( month , 10 )
	if( intmonth >= 1  && intmonth <= 12  ) {
		return true;
	} else {
		return false;
	}
}

// 유효 날짜 체크
function checkDay( yyyy, mm, dd ) {
	var monthDD = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	var im = parseInt(mm,10) - 1;
	if( ( (yyyy % 4 == 0) && (yyyy % 100 != 0)) || (yyyy % 400 == 0) ) {
		monthDD[1] = 29;
	}
	if( parseInt( dd , 10 ) <= 0 || parseInt( dd , 10 ) > monthDD[im] ) {
		return false;
	} else {
		return true;
	}
}

//날자포맷으로 yyyy-mm-dd
function addBar(dt) {
	var dat="";
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	return dat; 
}

//날자포맷으로 yyyy-mm-dd
function addBar_from(obj) {
	var formObject = document.form;
	var dt=obj.value;
	var dat=dt;
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.so_fmdt.value= dat;
}

//날자포맷으로 yyyy-mm-dd
function addBar_to(obj) {
	var formObject = document.form;
	var dt=obj.value;
	var dat=dt;
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.so_todt.value= dat;
}

/*
 * 멀티 달력 입력 Pop-Up
 */

function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.from_date, 'from_date', document.form.to_date, 'to_date', 'yyyy-MM-dd');
}

/**
 * 콤보박스 -bound
 */
function bound_OnChange_1(obj) {
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_boundmode.value=codeval;
}

/**
 * 콤보박스 -bound
 */
function bound_OnChange_2(obj) {
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_bkgterm.value=codeval;
}

/**
 * 콤보박스 -bound
 */
function bound_OnChange_3(obj) {
	var codeval =obj.value;
	var formObject = document.form;

	formObject.hid_trosts.value=codeval;
}

/**
 * 콤보박스 -bound
 */
function bound_OnChange_4(obj) {
	var codeval =obj.value;
	var formObject = document.form;
	var sheetObject = sheetObjects[0];

	if( codeval=='I') {
	sheetObject.ColHidden("rev_2")=true ;
//	sheetObject.ColHidden("rev_3")=false ;
	sheetObject.ColHidden("wo_cost")=true ;
	sheetObject.ColHidden("inv_cost")=false ;
	sheetObject.ColHidden("diff_3")=true ;
	sheetObject.ColHidden("diff_4")=false ;
	} else if(codeval=='W') {
	sheetObject.ColHidden("rev_2")=false ;
//	sheetObject.ColHidden("rev_3")=true ;
	sheetObject.ColHidden("wo_cost")=false ;
	sheetObject.ColHidden("inv_cost")=true ;
	sheetObject.ColHidden("diff_3")=false ;
	sheetObject.ColHidden("diff_4")=true ;


	} else 	{
	sheetObject.ColHidden("rev_2")=false ;
//	sheetObject.ColHidden("rev_3")=false ;
	sheetObject.ColHidden("wo_cost")=false ;
	sheetObject.ColHidden("inv_cost")=false ;
	sheetObject.ColHidden("diff_3")=false ;
	sheetObject.ColHidden("diff_4")=false ;

	}

}


function focusDate(obj) {
	var f =  document.form;
	var dt = obj.value;

	if( dt == "YYYYMMDD"){
	obj.value = "";
	
	} else {
	}
}

function focusWeek(obj) {
	var f =  document.form;
	var dt = obj.value;

	if( dt == "YYYYWW"){
	obj.value = "";
	
	} else {
	}
}
function focusMonth(obj) {
	var f =  document.form;
	var dt = obj.value;

	if( dt == "YYYYMM"){
	obj.value = "";
	
	} else {
	}
}
function focusYear(obj) {
	var f =  document.form;
	var dt = obj.value;

	if( dt == "YYYY"){
	obj.value = "";
	
	} else {
	}
}

function BlurDate(obj) {
	var f =  document.form;
	var dt = obj.value;


	f.week.value="YYYYWW";
	f.month.value="YYYYMM";
	f.year.value="YYYY";
	f.radio_period[0].checked= true;
	change_period();

	if( dt == "" || dt == "YYYYMMDD"){
		obj.value = "YYYYMMDD";

	} else {
		if ( dt.length == 8) {
			if( isValidDate(dt)  ) {
				addBar(obj);
				getHypen(obj);
//				 if(obj.name == "so_fmdt" ) {
//					f.so_todt.value = ComGetDateAdd(obj.value, 15);
//				 }
				return;
			} else {
				ComShowCodeMessage("TRS90070");
				obj.value = "";
				obj.select();
				obj.focus();
				return;
			}
		}


		ComShowCodeMessage("TRS90070");
		obj.value = "";
		obj.select();
		obj.focus();
		return;
	}

}

function Blurweek(obj) {
	var f =  document.form;
	var dt = obj.value;

	if(dt.length != 6 || dt=="" || dt=="YYYYWW"){ obj.value = "YYYYWW";	return;	}

	f.hid_week.value = dt;

	f.month.value="YYYYMM";
	f.year.value="YYYY";
	f.radio_period[1].checked= true;
	change_period();


	doActionIBSheet(sheetObjects[0] ,f ,IBSEARCH,"date");
}

function Blurmonth(obj) {
	var f =  document.form;
	var dt = obj.value;

	if(dt.length != 6 || dt=="YYYYMM" || dt=="YYYYMM"){ obj.value = "YYYYMM";	return;	}

	f.hid_week.value = dt;

	f.week.value="YYYYWW";
//	formObject.month.value="";
	f.year.value="YYYY";
	f.radio_period[2].checked= true;
	change_period();



	doActionIBSheet(sheetObjects[0] ,f ,IBSEARCH,"date");

}

function Bluryear(obj) {
	var f =  document.form;
	var dt = obj.value;

	if(dt.length != 4 || dt=="" || dt=="YYYY"){ obj.value = "YYYY";	return;	}


	f.week.value="YYYYWW";
	f.month.value="YYYYMM";
	f.radio_period[3].checked= true;
	change_period();


	f.so_fmdt.value = dt+"0101";
	f.so_todt.value = dt+"1231";

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
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.input_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.input_office.value = document.form.old_ofc_cd.value;
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
			document.form.input_office.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.input_office.value = obj;
}

//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.input_office.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.input_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;		
		} else {
			ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
			return false;
		}
	}
}


// so inquiry에서 조회
function goSoInquiry(sheetObj,formObj){
	// WO MAX 인지 확인.
	if( sheetObj.rowcount==0 ) return;


var p_sofmdt = formObj.so_fmdt.value;
var p_sotodt = formObj.so_todt.value;
var p_woofc  = sheetObj.CellValue(sheetObj.SelectRow,  "wrk_ofc" );
var p_trosts = formObj.hid_trosts.value;
var p_bnd    = sheetObj.CellValue(sheetObj.SelectRow,  "trsp_bnd_cd" );
var p_term   = formObj.hid_bkgterm.value;
var p_onlycy   = formObj.hid_onlycy.value;
var p_colhd  = sheetObj.CellValue(0 ,  sheetObj.SelectCol);	
var r_sotype = 'Y';
var p_fmnode = formObj.frm_node.value+document.frm_yard.CODE;
var p_tonode = formObj.to_node.value+document.to_yard.CODE;


if (sheetObj.SelectCol == 1 ) {  // OFFICE 선택시
	p_trosts = "";
	p_bnd = "";
	p_term = "";
	p_col_hd = "";

} else if (sheetObj.SelectCol == 2 ) {  // BND 선택시..
	p_trosts = "";

	p_onlycy = "";
	p_col_hd = "";

} else if (sheetObj.SelectCol == 3 ) { // TRO TERM 선택시..
	p_trosts = "";
	p_col_hd = "";

} else if (sheetObj.SelectCol == 4 ) { // TRO STS 선택시
	p_col_hd = "";
}

	if ( p_woofc.substring(0,3) =='SUB' ) p_woofc = "";  
	 else if (p_woofc.substring(0,3) =='TOT' ) p_woofc = formObj.input_office.value; ;  
	if ( p_bnd.substring(0,3) =='I+O' ) {p_bnd = ""; r_sotype = 'Y'	}
	 else if ( p_bnd.substring(0,1) =='M' ) {p_bnd = ""; r_sotype = 'M';	}

	if ( p_term.substring(0,3) =='SUB' ) p_term = ""
		else p_term=p_term.substring(0,1);  
	if ( p_trosts.substring(0,3) =='SUB' ) p_trosts = ""  
		else p_trosts=p_trosts.substring(0,1);
		
if( p_fmnode.length <5 ){p_fmnode = ''}            
if( p_tonode.length <5 ){p_tonode = ''}



// tpsz 외에 선택되면 tpsz = all
if( sheetObj.SelectCol < 5 | sheetObj.SelectCol > 23 ) p_colhd = "";  
if( p_colhd == "O/S 2") p_colhd = "O2";
else if( p_colhd == "O/S 4") p_colhd = "O4";
else if( p_colhd == "O5") p_colhd = "O5"; //20121022
else if( p_colhd == "O7") p_colhd = "O7"; //2018.05.08 추가 [CSR #3841]
else if( p_colhd == "F/A 2") p_colhd = "F2";
else if( p_colhd == "F/A 4") p_colhd = "F4";
else if( p_colhd == "D etc") p_colhd = "XX";  //D etc 는 잠정적으로 없다.


	var param = "?opener=chreport"
				+ "&invar_sofmdt=" + removeBar(p_sofmdt)
			    + "&invar_sotodt="+  removeBar(p_sotodt)
				+ "&invar_ofc="+ p_woofc
				+ "&invar_bnd="+ p_bnd
				+ "&invar_term="+ p_term
				+ "&invar_onlycy="+ p_onlycy
				+ "&invar_trosts="+ p_trosts
				+ "&invar_colhd="+ p_colhd
				+ "&invar_sotype="+ r_sotype
				+ "&invar_from_node="+ p_fmnode
				+ "&invar_to_node="+ p_tonode

	window.open('ESD_TRS_0019.do'+param, 'OpneHistoryWin', "scroll:no,status:yes,help:no,width=930,Height=470");

}



function change_cntp(){
	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	var val="";	

	if ( formObject.radio_cntp[0].checked == true ) {
		sheetObject.ColHidden("d2")=false;
		sheetObject.ColHidden("d4")=false;
		sheetObject.ColHidden("d5")=false;
		sheetObject.ColHidden("d7")=false;
		sheetObject.ColHidden("d_etc")=false;
		sheetObject.ColHidden("r2")=false;
		sheetObject.ColHidden("r4")=false;
		sheetObject.ColHidden("r5")=false;
		sheetObject.ColHidden("r7")=false;
		sheetObject.ColHidden("r8")=false;
		sheetObject.ColHidden("o2")=false;
		sheetObject.ColHidden("o4")=false;
		sheetObject.ColHidden("o5")=false;
		sheetObject.ColHidden("o7")=false;
		sheetObject.ColHidden("f2")=false;
		sheetObject.ColHidden("f4")=false;
		sheetObject.ColHidden("f5")=false;
		sheetObject.ColHidden("p2")=false;
		sheetObject.ColHidden("p4")=false;
		sheetObject.ColHidden("t2")=false;
		sheetObject.ColHidden("t4")=false;

	}else if( formObject.radio_cntp[1].checked == true ) {
		sheetObject.ColHidden("d2")=true;
		sheetObject.ColHidden("d4")=true;
		sheetObject.ColHidden("d5")=true;
		sheetObject.ColHidden("d7")=true;
		sheetObject.ColHidden("d_etc")=true;
		sheetObject.ColHidden("r2")=true;
		sheetObject.ColHidden("r4")=true;
		sheetObject.ColHidden("r5")=true;
		sheetObject.ColHidden("r7")=true;
		sheetObject.ColHidden("r8")=true;
		sheetObject.ColHidden("o2")=true;
		sheetObject.ColHidden("o4")=true;
		sheetObject.ColHidden("o5")=true;
		sheetObject.ColHidden("o7")=true;
		sheetObject.ColHidden("f2")=true;
		sheetObject.ColHidden("f4")=true;
		sheetObject.ColHidden("f5")=true;
		sheetObject.ColHidden("p2")=true;
		sheetObject.ColHidden("p4")=true;
		sheetObject.ColHidden("t2")=true;
		sheetObject.ColHidden("t4")=true;
	}else{

	}
}

function fun_chekcbox(lvobj) {
//	sheetObjects[0].RemoveAll();

  if(document.form.chk_cyterm.checked   ){
	  document.form.hid_bkgterm.value = 'Y';
  } else {
	  document.form.hid_bkgterm.value = '';
  }
//  if(document.form.chk_onlycy.checked   ){
//	  document.form.hid_onlycy.value = 'Y';
//  } else {
//	  document.form.hid_onlycy.value = '';
//  }  
   document.form.hid_onlycy.value = ''; 

  if(document.form.chk_fr.checked   ){
	  document.form.hid_trosts.value = 'F';
  } else {
	  document.form.hid_trosts.value = '';
  }

  if(document.form.chk_mty.checked   ){
	  document.form.hid_inclmty.value = 'Y';
  } else {
	  document.form.hid_inclmty.value = '';
  }

}

function change_period(){
	var formObject = document.form;
	var sheetObject = formObject.sheet1;
	var val="";	

	if ( formObject.radio_period[0].checked == true ) {
		formObject.hid_period.value="D";   //S/O Creation  
	}else if( formObject.radio_period[1].checked == true ) {
		formObject.hid_period.value="W";   //W/O Issue
	}else if( formObject.radio_period[2].checked == true ) {
		formObject.hid_period.value="M";   //Invoice Confirm 
	}else if( formObject.radio_period[3].checked == true ) {
		formObject.hid_period.value="Y";   //Invoice Confirm 
	}else{
		formObject.hid_period.value="";
	}
}

function dateAppointed(dt_flag ){

	var formObject = document.form;

/*
  if (dt_flag =="W" )  {
//	formObject.week.value="";
	formObject.month.value="";
	formObject.year.value="";
	formObject.radio_period[1].checked= true;
  } else if (dt_flag =="M" )  {
	formObject.week.value="";
//	formObject.month.value="";
	formObject.year.value="";
	formObject.radio_period[2].checked= true;
  } else if (dt_flag =="Y" )  {
	formObject.week.value="";
	formObject.month.value="";
//	formObject.year.value="";
	formObject.radio_period[3].checked= true;
  }



change_period();

*/

}


/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	obj.value = lvobj;
	if( lvobj == "" ) {
		obj.value = "";
		comObj.RemoveAll();
		return false;
	} else if( lvobj.length != 5 ) {
		obj.focus();
		errMsg = ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		return false;
	}
	if( !doengnumcheck(lvobj) ) {
		obj.value = "";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if( sep == 'F' ) {
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'D' ) {
		lvDelNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'P' ) {
		lvDelNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.focus();
}

/**
* Rail Road combo 선택시 textfield의 값 변경하는 이벤트
**/
function rail_road_code_OnChange(combo, Index_Code, Text) {

	if ( document.form.rail_road_name.value == Text )  return;

	document.form.rail_road_name.value = combo.GetText(Index_Code,1);
	
}

/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){

	var formObject = document.form;	

	sheetObjects[0].RemoveAll();  //TAB1 sheet
	sheetObjects[1].RemoveAll();  //TAB2 sheet

	formObject.frm_yard.RemoveAll();
	formObject.to_yard.RemoveAll();


	tabObjects[0].SelectedIndex = 0; //tab 이동

	formObject.date_type.value="I";
	formObject.fm_date.value="YYYYMM";
	formObject.to_date.value="YYYYMM";
	formObject.comp_cd.value="A";
	formObject.rail_road_code.Text = "";
	formObject.rail_road_name.value="";
	formObject.status.value="A";
	formObject.io_bound.value="A";
	formObject.frm_node.value="";
	formObject.frm_yard.value="";
	formObject.to_node.value="";
	formObject.to_yard.value="";
	formObject.ctrl_ofc.value="";
	
//	formObject.input_cre_ofc_cd.value=formObject.login_ofc_cd.value;
}	

/**
 * 공통 Node popup
 */
 function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
 	formObject.frm_node.value = lvLoc;
	getYardCombo(document.frm_yard, sheetObjects[0], formObject, lvLoc);
	document.frm_yard.CODE = lvYard;
}



/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var sheetObject = sheetObjects[0];			
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.to_node.value = lvLoc;
	getYardCombo(document.to_yard, sheetObject, formObject, lvLoc);
	document.to_yard.CODE = lvYard;
}