/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0001.js
*@FileTitle : Expense Summary by Office 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-5
*@LastModifier : ay han
*@LastVersion : 1.6 
* 2009-02-27 ay han
* 1.0 최초 생성 
* N200902240170 2009-03-05 Pending list ofc 매뉴얼 입력 가능 조정
=========================================================*/ 

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0001 : Booking .
 */
function ESD_TRS_0001() {
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

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;

			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
			break;

			case "btn_minimize":
				Mincount = (Mincount+1)%2 ;
				Minimize(Mincount);
			break;

			case "btng_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			break;

			case "btns_calendar":
				getCalendar();
			break;
			
			case "btns_office": //M CNTR
				if( validation_check() ) {
					var ofc_cd = formObject.input_office.value;
					ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
				}
			
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
				MergeSheet = msPrevColumnMerge;   //msPrevColumnMerge/msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 23);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, true,true) ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle =  "Cargo|Planned Departure D/T|Bound|Trunk VVD|Mode|Mode|QTY" ;
				var HeadTitle1 = "Cargo|Planned Departure D/T|Bound|Trunk VVD|Cost|Trans.|QTY" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, false);

				//데이터속성[ROW,COL,DATATYPE,    WIDTH,DATAALIGN,COLMERGE,SAVENAME,      KEYFIELD, CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,cnt++, dtData,   150,daCenter, true,    "cargo",   false, "", dfNone);
				InitDataProperty(0,cnt++, dtData,   150,daCenter, true,    "duedate", false, "", dfDateYmd,	0, false, false, 30, false,	 true, "", false);
				InitDataProperty(0,cnt++, dtData,   150,daCenter, true,    "bound",   false, "", dfNone, 0, false, false, 30, false,	 true, "", false);
				InitDataProperty(0,cnt++, dtData,   130,daCenter, true,    "truckvvd",false, "", dfNone, 0, false, false, 30, false,	 true, "", false);
				InitDataProperty(0,cnt++, dtData,   130,daCenter, true,    "cost",    false, "", dfNone, 0, false, false, 30, false,	 true, "", false);
				InitDataProperty(0,cnt++, dtData,   130,daCenter, true,    "trans",   false, "", dfNone, 0, false, false, 30, false,	 true, "", false);
				InitDataProperty(0,cnt++, dtAutoSum,130,daRight,  true,    "qty",     false, "", dfInteger,	0, false, false, 30, false,	 true, "", false);
				InitDataProperty(0,cnt++, dtHidden,   100,daRight,  true,  "tree");

				CountPosition =0 ;
				SelectHighLight=false;
				InitTreeInfo(7 , "tree");
				sheet1_OnDblClick(sheetObj, 1,1);
//              sheet1_OnDblClick(sheetObj, 2,2);
			}
		break;
		case 2:      //sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0 ;
			//전체 너비 설정
			SheetWidth = 0;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;   //msPrevColumnMerge/msHeaderOnly

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 23);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(1, 3, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, true,true) ;

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			var HeadTitle =  "VSL_CD" ;
			

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			

			//데이터속성[ROW,COL,DATATYPE,    WIDTH,DATAALIGN,COLMERGE,SAVENAME,      KEYFIELD, CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,cnt++, dtData,   150,daCenter, true,    "VSL_CD",   false, "", dfNone);
			CountPosition =0 ;
			SelectHighLight=false;
		}
	break;		
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.hid_from_date.value = removeBar(formObj.from_date.value);
			formObj.hid_to_date.value = removeBar(formObj.to_date.value);
			formObj.ofc_cd.value = document.form.input_office.value

			//combo_setting();

			var xxx = formObj.sel_costmode.value;
			if(xxx =="CY"){
				formObj.hid_cost.value="Y";
			}else if(xxx =="DR"){
				formObj.hid_cost.value="D";
			}else if(xxx =="LS"){
				formObj.hid_cost.value="L";
			}else if(xxx =="TS"){
				formObj.hid_cost.value="S";
			}else{
				formObj.hid_cost.value="ALL";
			}

			formObj.f_cmd.value = SEARCH;

			sheetObj.DoSearch4Post("ESD_TRS_0001GS.do", TrsFrmQryString(formObj));
			sheetObj.SubSumBackColor = sheetObj.RgbColor(197,208,208);
			sheetObj.ShowSubSum("cargo",   "qty", 0, false, false, -1, "0=%s;1=Sub QTY;7=cargo");
			sheetObj.SubSumBackColor = sheetObj.RgbColor(207,218,218);
			sheetObj.ShowSubSum("duedate", "qty", 0, false, false, -1, "0=%s;1=%s;2=Sub QTY;7=duedate");
			sheetObj.SubSumBackColor = sheetObj.RgbColor(217,228,228);
			sheetObj.ShowSubSum("bound",   "qty", 0, false, false, -1, "0=%s;1=%s;2=%s;3=Sub QTY;7=bound");
			sheetObj.SubSumBackColor = sheetObj.RgbColor(227,238,238);
			sheetObj.ShowSubSum("truckvvd","qty", 0, false, false, -1, "0=%s;1=%s;2=%s;3=%s;4=Sub QTY;7=truckvvd");
			sheetObj.SubSumBackColor = sheetObj.RgbColor(237,248,248);
			sheetObj.ShowSubSum("cost",    "qty", 0, false, false, -1, "0=%s;1=%s;2=%s;3=%s;4=%s;5=Sub QTY;7=cost");
				
//sheetObj.InitTreeInfo("tree", "");
//sheetObj.FitColWidth();
			sheet1_OnDblClick(sheetObj, 1,1);
		break;
		
		case IBDOWNEXCEL:        // excel down
			sheetObj.SpeedDown2Excel();
		break;
	}
}

//트리를 더블크릭하는경우
function sheet1_OnDblClick(sheetObj ,row,col) {
	with (sheetObj) {
		switch (col) {
			case 1:
				col =1;
				row =4;
			break;
			case 2:
				col = 2;
				row = 4;
			break;
			case 3:
				row = 5;
			break;
			case 4:
				row = 6;
			break;
			default:
			return;
		}
		Redraw = false;
		var level = RowLevel(row);
		var bShow = 1;
		//트리를 접는 경우
		if (ColHidden(col+1)) {
			level++;
			bShow = 2
		}

		ShowTreeLevel(level, bShow);
		if ( col == 1) {
			ColHidden(col+1) = true;
		}
		ColHidden(col+1) = !ColHidden(col+1);
		for (ic=col+2; ic<6; ic++) ColHidden(ic) = true;
		Redraw = true;
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
 * IBCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * 라디오버튼을 누를시 delete상태변경을 위해서 hidden값으로 반대값을 넣는다. 
 */
function change_val_1(){
	var formObject = document.form;
	if ( formObject.btng_cargo[0].checked == true ) {
		formObject.hid_cargo.value="ALL";
	}else if( formObject.btng_cargo[1].checked == true ) {
		formObject.hid_cargo.value="FULL";
	}else{
		formObject.hid_cargo.value="EMPTY";
	}
}
	
/**
 * 라디오버튼을 누를시 delete상태변경을 위해서 hidden값으로 반대값을 넣는다.
 */
function change_val_2(){
	var formObject = document.form;
	if ( formObject.btng_bound[0].checked == true ) {
		formObject.hid_bound.value="ALL";
	}else if( formObject.btng_bound[1].checked == true ) {
		formObject.hid_bound.value="I";
	}else{
		formObject.hid_bound.value="O";
	}
	var x1=formObject.sel_costmode.value;
	var x2=formObject.sel_transmode.value;
}

/**
 * vvd팝업호출
 */
function vvd_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_VVD";
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
	ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 772, 420, 'getCOM_ENS_VVD', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * popSearchPiCommCodeGrid 프로세스 처리
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;

	if(myWin != null) myWin.close();
	url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
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
	  
/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_VVD(rowArray) {
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[7];
		document.form.trunk_vvd.value = colArray2;						
	}
}
	  
/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_ofc(rowArray) {
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[7];
		document.form.ofc_cd.value = colArray2;
	}
}

/**
 * vvd체크.
 */
function vvd_check(obj) {
	var formObject = document.form;
	var value="";
	var xxx=obj.value;

	if(xxx!=""){
		formObject.f_cmd.value = SEARCH02;
		var queryString = "searchStr="+value+"&"+TrsFrmQryString(formObject);
		formObject.sheet2.DoRowSearch("ESD_TRS_0001GS.do", queryString);
		if(!check_vvd(formObject.sheet2.EtcData('CNT_CD'),obj)) return;
	}
}

/**
 * S/C Number 입력시 존재여부체크 
 *
 */
function check_vvd(value, obj) {
	var formObject = document.form;
	if( value == 0) {
		var errMessage = ComGetMsg('COM12114','Trunk vvd data','','');  
		ComShowMessage(errMessage);
		formObject.trunk_vvd.value="";
		formObject.trunk_vvd.select();
		formObject.trunk_vvd.focus();
	}
}

/**
 * S/C Number 입력시 존재여부체크 
 *
 */
function check_ofc(value, obj) {
	var formObject = document.form;
	if( value == 0) {
		var errMessage = ComGetMsg('COM12114','Ofc code data','','');  
		ComShowMessage(errMessage);
		return false;
	} else {
		return true;
	}
}

//'-' 없애기
function fun_Focus(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}

//'-' 없애기
function fun_Focus_del(obj){
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
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





//  blur시 데이타체크
function BlurDate(obj) {
	var f =  document.form;
	var dt = obj.value;
	if( dt == ""){
	}else{
		if ( isValidDate(dt)) {
			if( dt.length == 8 ) {
				addBar(obj);
				return;
			} else {
				ComShowCodeMessage("TRS90070");
				obj.select();
				obj.focus();
				return;
			}
		}
		ComShowCodeMessage("TRS90070");
		obj.select();
		obj.focus();
		return;
	}
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
	formObject.from_date.value= dat;
}

//날자포맷으로 yyyy-mm-dd
function addBar_to(obj) {
	var formObject = document.form;
	var dt=obj.value;
	var dat=dt;
	if( dt.length == 8 ) {
		dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
	}
	formObject.to_date.value= dat;
}

/*
 * 멀티 달력 입력 Pop-Up
 */

function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.from_date, document.form.to_date, 'yyyy-MM-dd');
}

/*쉬트선택시 value를 리턴
function sheet1_OnSelectCell(r1,c1,r2,c2) {
	var sheetObj = sheetObjects[0];
	window.status= sheetObj.RowLevel(r2);
}
*/

/**
 * 최초 ONLOAD시에 화면에 뿌려줄내용!!!
 *
 */
/*
function fn_combo(){
	var formObject = document.form;
	var cnt  = 0 ;
	var value="";
	var valueArray;
	var combotextArray;

	formObject.hid_rhq.value=formObject.sel_rhqmode.value;
	formObject.f_cmd.value = SEARCH03;
	var queryString = "searchStr="+value+"&"+TrsFrmQryString(formObject);
	formObject.sheet1.DoRowSearch("ESD_TRS_0001_01GS.do", queryString);
	var combotext = formObject.sheet1.EtcData('OFC_CD');
	if ( combotext == "undefined" || combotext == "" || combotext == null) {
		return;
	}
	combotextArray =  combotext.split("--");
	valueArray_1 = combotextArray;
}

function combo_setting(){
	var formObject = document.form;
	//콤보박스 로직이후 세션에서 읽어온값을 셋팅해주는 부분입니다.
	var ofc_val=formObject.ofc_cd.value;
	//ofc_val="PUSBB";
	formObject.combo1.Text  = ofc_val;
	var xx1 =formObject.combo1.Text;
	if(xx1 =="" || xx1 ==null){
		formObject.ofc_cd.value ="";
	}else{
		formObject.ofc_cd.value =formObject.combo1.Text;
	}
}
*/
/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
/*function rhq_OnChange(obj){
	var codeval =obj.value;
	var formObject = document.form;
	formObject.hid_rhq.value=codeval;
	fn_combo();
}
*/


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


/*		
* N200902240170 2009-03-05 Pending list ofc 매뉴얼 입력 가능 조정
*/		
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