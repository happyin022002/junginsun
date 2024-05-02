/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0009.jsp
*@FileTitle : Drop-off Charge Collection Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-20
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-20 choice
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
 * @class ESD_EAS_0006 : 예)MSC Checking 조회 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_EAS_0009() {
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

var isJORetrive = false; 

/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

	/**
	 * IBTab Object를 초기화 설정
	 * 탭 ID는 tab1,tab2,...
	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
	 */
	function InitTab() {
		try{
			with(document.all.tab1){
				InsertTab(0, "Dry Index" , 23 );
				InsertTab(1, "Tanker Index" , 23); 
				InsertTab(2, "Time Charter" , 23 );
				InsertTab(3, "Bunker Price" , 23 );
				InsertTab(4, "Ship Price" , 23); 
				InsertTab(5, "FFA Index" , 23 );
				TabBackColor(0)="146,174,230";
			}
		}catch(e){
			ComShowMessage(e);
		}
	}
	
	/**
	 * tab1의 onChange이벤트핸들러
	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	
	/**
	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
	 */
	function ChangeTab(tabObj,nItem){
		tabObj.BackColor="#FFFFFF";
		tabObj.TabBackColor(nItem)="146,174,230";
	
		var objs = document.all.item("tabLayer");
		objs[beforetab].style.display = "none";
		objs[nItem].style.display = "Inline";
	
		//--------------- 요기가 중요 --------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
		objs[beforetab].style.zIndex = 0;
		objs[nItem].style.zIndex = 9;
		//------------------------------------------------------//
		beforetab= nItem;
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
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
		   //khlee-시작 환경 설정 함수 이름 변경
//			comConfigSheet(sheetObjects[i],SYSTEM_ENIS);
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
//		document.form.somonth.focus();
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
//			axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//			axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//			axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//			axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//			axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//			axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
//			axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
	 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	function engnum_keypress() {
//	    ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation manual <br>
	 **/
	function manual_click() {
	    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//	    form.boo_bkg_no.readOnly =!form.manual.checked;
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
//	    return ComChkObjValid(event.srcElement);
	}

	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
	function obj_focus(){
//	    ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
//	    ComKeyOnlyNumber(event.srcElement);
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- end
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = 280;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "SEQ|MT Return CY|Haulage|Container Q'ty|Container Q'ty|Container Q'ty|Container Q'ty|Tariff Amount(EUR)|Tariff Amount(EUR)|Tariff Amount(EUR)|Tariff Amount(EUR)|TRO Amount\n(EUR)|DOD Amount\n(EUR)";
					var HeadTitle1 = "SEQ|MT Return CY|Haulage|D2|D4|D5|Sum|D2|D4|D5|Sum|TRO Amount\n(EUR)|DOD Amount\n(EUR)";
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);		
					InitHeadRow(1, HeadTitle1, true);		
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, true,     "seq",                  false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, true,     "cntr_rtn_yd_cd",      	false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, true,     "hlg_tp_cd",            false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "d2_qty",				false,          "",       dfNullInteger,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "d4_qty",               false,          "",       dfNullInteger,    	0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "d5_qty",     			false,          "",       dfNullInteger,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "cntr_qty",   			false,          "",       dfNullInteger,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "trf_d2_qty",      		false,          "",       dfNullInteger,    	0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "trf_d4_qty",         	false,          "",       dfNullInteger,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "trf_d5_qty",         	false,          "",       dfNullInteger,    	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "trf_amt",              false,          "",       dfNullFloat,  0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, true,    "tro_amt",              false,          "",       dfNullFloat,  0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, true,     "dod_amt",              false,          "",       dfNullFloat,  0,     false,       true);
					
					//sheetObj.ColHidden("bkg_no_split") = true;
				}
				break;
		}
	}

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
		 var sheetObject = sheetObjects[curTab-1];
		 /******************************************************/
		 var formObject = document.form;
		 if(curTab == 2)
			formObject = document.form2;
			
		try {
			
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "bttn_add":
					   doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "bttn_cancel":
					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "bttn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "bttn_remove":
					break;
				case "bttn_preview":
					sheetObject.ExcelPrint = "PreView";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_downexcel":
					sheetObject.ExcelPrint = "";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "bttn_print":
					sheetObject.ExcelPrint = "PrintOnly";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					break;
				case "btns_calendar1":
					 var cal = new calendarPopup();
					 cal.select(formObject.s_sdate, 's_sdate', 'yyyy-MM-dd');
					break;
				case "btns_calendar2":
					var cal = new calendarPopupFromTo();
					cal.displayType = "date";
					cal.select(formObject.s_sdate, 's_sdate',formObject.s_edate, 's_edate', 'yyyy-MM-dd');
					break;
				case "btns_office": 
				//if( validation_check() ) {
					var ofc_cd = formObject.ctrl_ofc_cd.value;
					ComOpenWindow('ESD_EAS_COM_0001.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_EAS_COM_0001', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				//}
				break;
				case "btns_cust": 
					ComOpenPopup('/hanjin/COM_ENS_0041.do', 770, 470, 'getCustomer', '1,0,1,1,1,1,1,1');
				break;
				
                case "cnt_btn":         
                	with(formObject)
                	{    	    
                	    var v_cnt_cd = cnt_cd.value;
                	    var classId = "COM_ENS_00M1";
            		    var param = '?cnt_cd='+v_cnt_cd+'&classId='+classId;
            		    var v_display = "1,0,1,1,1,0,0";
            		    var chkStr = v_display.substring(0,3)
            		  
            		    if(chkStr == "1,0") {
            		        ComOpenPopup('/hanjin/COM_ENS_00M1.do' + param, 565, 480, 'getCOM_ENS_00M1_1', v_display, true);
            		    } else {
            			    return;
            		    }
                	}
				break;
				case "btn_detail":
					//ComOpenWindow('ESD_EAS_0903.do?inv_no=PUS-07-05-TS-20', 'ESD_EAS_0903', 'top=200, left=200, width=800, height=600, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=1');
					sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
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
	

    function getCOM_ENS_0M1_1(rowArray) {
    	
    	var colArray = rowArray[0];	
    	document.all.cnt_cd.value = colArray[3];
    	document.all.cnt_nm.value = colArray[4];
 
    }	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH;
//				prompt('',"ESD_EAS_009GS.do?"+EasFrmQryString(formObj));
//				return;
				sheetObj.DoSearch4Post("ESD_EAS_0009GS.do", EasFrmQryString(formObj));
				break;	 
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){

	}

	function sheet1_OnClick(sheetObj, Row,Col,Value){

	}


//Office의 Text 변경시
function fun_officeText() {
	document.form.ctrl_ofc_cd.value = document.form.ctrl_ofc_cd.value.toUpperCase();
}

function rtn_office_code(obj) {
	document.form.ctrl_ofc_cd.value = obj;
}


function upperCase(obj) {
	obj.value = obj.value.toUpperCase();
	
}
function pointAutoMove(val) {
	if ( val.length == 8  ) {
		document.form.totrodate.focus();
	}
}

function selectText(obj) {
	if( obj.name == "fromtrodate" || obj.name == "totrodate" ) {
		selectWhere();
	}	
}

function selectWhere() {

		if ( document.form.fromtrodate.value == "yyyymmdd" ){
			document.form.fromtrodate.value = "";
			document.form.fromtrodate.focus();
		}	
		
		if ( document.form.totrodate.value == "yyyymmdd" ){
			document.form.totrodate.value = "";
		}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj){
formObj = document.form;
	var result = true ;
	// 검색 조건 입력 여부
	if( !isInputField(formObj) ) {
		result = false ;
	}
		
	if( ComIsEmpty(formObj.fromtrodate) || ComIsEmpty(formObj.totrodate) || formObj.totrodate =='yyyymmdd'){
		ComShowMessage("Please enter TRO Period.");
		result = false;
		
	}
	return result;
}

function isInputField(formObj) {
	var result    = true ;

	if( document.form.ctrl_ofc_cd.value=="" ) {
		ComShowMessage("Please enter TRO Office Code.");
		result = false;
	}
	return result;
}
	