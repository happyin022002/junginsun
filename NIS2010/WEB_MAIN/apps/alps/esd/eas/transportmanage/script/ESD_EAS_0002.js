/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0002.js
*@FileTitle : Route UnMatch List 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-03
*@LastModifier : Hosam_Lee
*@LastVersion : 1.0
* 2006-11-06 Hosam_Lee
* 1.0 최초 생성
* * N200903200050 EAS 보완요청 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends Bkg
	 * @class ESD_EAS_0002 : 예)Route UnMatch List 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0002() {
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

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		 /******************************************************/
		 var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "bttn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;				
			case "btns_office": 
			//if( validation_check() ) {
				var ofc_cd = formObject.ctrl_ofc_cd.value;
				ComOpenWindow('ESD_EAS_COM_0001.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_EAS_COM_001', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
			//}
			break;
			case "btn_detail":
				//openWindow('ESD_EAS_0903.do?inv_no=PUS-07-05-TS-20', 'ESD_EAS_0903', 'top=200, left=200, width=800, height=600, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=1');
				sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
				break;

			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
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
	         
	 	document.form.somonth.focus();
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



	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * * N200903200050 EAS 보완요청 
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
	                style.height = GetSheetHeight(15) ;
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
					InitColumnInfo(17, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "SEQ|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|B/L Data|S/O Data|S/O Data|S/O Data|S/O Data|S/O Data|Investigation";
					var HeadTitle1 = "SEQ|VVD|BKG NO|S|B/L NO|BD|TM|POR|POL|POD|DEL|FROM|VIA|TO|T/Mode|Office|Investigation";
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
					
					HeadRowHeight = 12;					
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, true,     "seq",              false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "vvd",            	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bkg_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "bkg_status",       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bl_no",            false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "bound",     		false,          "",       dfNone,    0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "term",      		false,          "",       dfNone,    0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_por",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_pol",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_pod",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "bkg_del",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_from",          false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_via",          false,          "",       dfNone,    0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_to",            false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "trans_mode",       false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "so_ofc_cd",        false,          "",       dfNone,    0,     false,       true);					
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, true,     "rmk_ctnt",     	false,          "",       dfNone,    0,     false,       true);

				}
				break;
		}
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
				sheetObj.DoSearch4Post("ESD_EAS_0002GS.do", EasFrmQryString(formObj));
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

	
	function sheet1_OnDblClick(sheetObj,Row,Col){
		var param;
		var theURL;
		var winName;
		var features;
		
	   	var bkg_no = ComTrim(sheetObj.CellValue(Row, 'bkg_no'));

	   	var so_ofc_cd = ComTrim(sheetObj.CellValue(Row, 'so_ofc_cd'));

	   	if(Col != 16){
			param = "?bkg_no="+bkg_no+"&so_ofc_cd="+so_ofc_cd;
			theURL = "ESD_EAS_0903.do"+param;
			winName = "ESD_EAS_0903";
			features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=yes,alwaysRaised,dependent,titlebar=no,width=800,height=550";
			ComOpenWindow(theURL,winName,features);
			
		}else if(Col == 16){
	    	var theURL = "ESD_EAS_0901.do?bkg_no=" + sheetObj.CellValue( Row, 'bkg_no') + "&eas_expn_tp_cd=RU";
	    	var winName = "ESD_EAS_0901";
	    	var features = "width=700,height=365,toolbar=no,location=no,status=yes,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
	    	
	    	ComOpenWindow(theURL,winName,features);
			
//			openRemarkPopup(sheetObj.CellValue(Row,"bkg_no"), sheetObj.CellValue(Row,"bl_no"), 'RU');
    	}
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
		document.form.tosodate.focus();
	}
}

function selectText(obj) {

	if( obj.name == "somonth" ) {
		document.form.search_choice[0].checked = true;
	}else if( obj.name == "fromsodate" || obj.name == "tosodate" ) {
		document.form.search_choice[1].checked = true;
	}
	
	selectWhere();
}


function selectWhere() {

	if( document.form.search_choice[0].checked == true ) {

		document.form.somonth.disabled = false;
		document.form.somonth.value = "";
		document.form.somonth.focus();
			
		document.form.search_choice[1].checked = false;
		document.form.fromsodate.value = "yyyymmdd";
		document.form.fromsodate.disabled = true;
		document.form.tosodate.value = "yyyymmdd";
		document.form.tosodate.disabled = true;
				
	} else if( document.form.search_choice[1].checked == true ) {

		document.form.fromsodate.disabled = false;
		document.form.tosodate.disabled = false;
		if ( document.form.fromsodate.value == "yyyymmdd" ){
			document.form.fromsodate.value = "";
			document.form.fromsodate.focus();
		}	
		
		if ( document.form.tosodate.value == "yyyymmdd" ){
			document.form.tosodate.value = "";
		}

		document.form.search_choice[0].checked = false;
		document.form.somonth.value = "yyyymm";
		document.form.somonth.disabled = true;
	
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

	if( formObj.search_choice[0].checked == true ){
		if( ComIsEmpty(formObj.somonth) || !chkMonthValue(formObj.somonth.value) ){
			var errMsg = ComGetMsg("EAS90004" , 'S/O Month');
			ComShowMessage(errMsg);
			result = false;
		}
	}else if( formObj.search_choice[1].checked == true ){
		if( ( ComIsEmpty(formObj.fromsodate) || !chkDateValue(formObj.fromsodate.value) ) && ( ComIsEmpty(formObj.tosodate) || !chkDateValue(formObj.tosodate.value) ) ){
			var errMsg = ComGetMsg("EAS90004" , 'S/O Date');
			ComShowMessage(errMsg);				
			result = false;
		}
	}
	if(formObj.ctrl_ofc_cd.value == '') {
		var errMsg = ComGetMsg("EAS90004" , 'S/O Office');
		ComShowMessage(errMsg);
		result = false;
	}
	return result;
}

function isInputField(formObj) {
	var result    = true ;

//	if( document.form.ctrl_ofc_cd.value=="" ) {
//		showErrMessage(getMsg('EAS90002', 'S/O Office'));
//		result = false;
//	}
	return result;
}
	