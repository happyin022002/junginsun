/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0033.js
*@FileTitle : Lease Expense-CNTR/CHSS
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.24 장준우
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
     * @class EES_LSE_0033 : EES_LSE_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0033() {
    	this.processButtonClick     = processButtonClick;
		this.setSheetObject         = setSheetObject;
		this.loadPage               = loadPage;
		this.initControl            = initControl;
		this.obj_blur               = obj_blur;
		this.obj_focus              = obj_focus;
		this.obj_change             = obj_change;
		this.obj_keypress           = obj_keypress;
		this.obj_keyup              = obj_keyup;
		this.obj_keydown            = obj_keydown;
		this.obj_click				= obj_click;
		this.initSheet              = initSheet;
		this.doActionIBSheet        = doActionIBSheet;
		this.setTabObject           = setTabObject;
		this.initTab                = initTab;
		this.tab1_OnChange          = tab1_OnChange;
		this.t1sheet1_OnChange      = t1sheet1_OnChange;
		this.t2sheet1_OnChange      = t2sheet1_OnChange;
		this.t1sheet1_OnAfterEdit   = t1sheet1_OnAfterEdit;
		this.t2sheet1_OnAfterEdit   = t2sheet1_OnAfterEdit;
		this.sheet2_OnSearchEnd     = sheet2_OnSearchEnd;
		this.sheet2_OnSaveEnd       = sheet2_OnSaveEnd;
		this.sheet3_OnLoadExcel		= sheet3_OnLoadExcel;
		this.validateForm           = validateForm;
		this.clearForm				= clearForm;
    }

   	/* 개발자 작업	*/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         var sheetObject5 = sheetObjects[4];

         /*******************************************************/
         var formObject = document.form;

    	try {
				var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

				case "btn_Retrieve":
					formObject.cmd_type.value = "SEARCH";
					doActionIBSheet(sheetObject4,formObject,IBSEARCH);
				break;

				case "btn_NewVersion":
					formObject.cmd_type.value = "NEWVER";
					doActionIBSheet(sheetObject4,formObject,IBSEARCH);
				break;

				case "btn_New":
					for(var i = 1; i <= sheetObject1.LastRow; i++) {
						for(var j = 1; j < sheetObject1.LastCol; j++)
							sheetObject1.CellText(i, j) = "";
					}
					for(var i = 1; i <= sheetObject2.LastRow; i++) {
						for(var j = 1; j < sheetObject2.LastCol; j++)
							sheetObject2.CellText(i, j) = "";
					}
					for(var i = 1; i <= sheetObject3.LastRow; i++) {
						for(var j = 1; j < sheetObject3.LastCol; j++)
							sheetObject3.CellText(i, j) = "";
					}
					sheetObject4.RemoveAll();
					formObject.reset();
					ComEnableObject(formObject.btns_DownFile,  false);
					ComSetFocus(formObject.pln_yr);
				break;

				case "btn_Save":
					formObject.cmd_type.value = "SAVE";
					doActionIBSheet(sheetObject4,formObject,IBSAVE);
				break;

				case "btn_VersionUp":
					formObject.cmd_type.value = "VERUP";
					doActionIBSheet(sheetObject4,formObject,IBSAVE);
				break;

				case "btn_LoadExcel":
					doActionIBSheet(sheetObject5,formObject,IBLOADEXCEL);
				break;

				case "btns_DownFile":
					if(formObject.btns_DownFile.style.cursor == "default") return;

					//해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
					var vHeadCols1 = "CNTR|CNTR|CNTR|CNTR|CNTR|CNTR|CNTR|CHSS|CHSS|CHSS|CHSS|CHSS|CHSS|CHSS|CHSS".split("|");
					var vHeadCols2 = "LP	(A)|OL	(B)|LT	(C)|ST	(D)|DR COST	(E)|SB	(G)|SO	(H)|LP	(A)|OL	(B)|LT	(C)|ST	(D)|N/P	(F)|C/P	(G)|MG.SET	(H)|SEN Rev	(I)".split("|");

					with (sheetObject5) {
						for(var i = 0; i < vHeadCols1.length; i++) {
							var index = DataInsert();
							CellValue2(index, "expns_type") = vHeadCols1[i];
							CellValue2(index, "lease_term") = vHeadCols2[i];
						}
						ColBackColor("expns_type") = HeadBackColor;
						ColBackColor("lease_term") = HeadBackColor;

						Down2Excel();
					}
				break;

				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);
					sheetObject2.SpeedDown2Excel(-1, true, false);
					sheetObject3.SpeedDown2Excel(-1, true, false);
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
    	var formObj = document.form;

		for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		/* IBTab 초기화 */
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}

		/* Axon Control Setting*/
		initControl();

		/* 초기 Focus Setting */
		ComEnableObject(formObj.btns_DownFile,  false);
		ComSetFocus(formObj.pln_yr);
    }

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('change',		'obj_change',	formObj); //- 변경될때.
		axon_event.addListenerForm('click',			'obj_click',	formObj); //- 클릭하였을 때
  	}

	//이벤트 중복방지 변수
	var preEventType = null;
  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;

		if(preEventType == event.type) {
			preEventType = null;
			return;
		}

	    switch(obj.name){
	    	case "pln_yr":
  				//Validation 전체 체크(길이,format,최대,최소 등등)
	            if(ComChkObjValid(obj, true, false, false) == false) {
	            	ComSetFocus(obj);
	            }
	    		break;
	        case "ver_seq":
	            //숫자이면서 천단위 구분을 하지 않는다.
	            ComChkObjValid(obj, true, false, false);
	            break;
	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj);
	        	break;
	    }
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus(){
		var obj  = event.srcElement;
		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    //마스크구분자 없애기
		    ComClearSeparator(event.srcElement);
		}
	}

	/**
	 * OnChange Event 처리
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[3];

		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
	    		case "pln_yr":
	    			if(ComChkObjValid(obj, false, false, false)) {
	    				doActionIBSheet(sheetObjects[3], formObj, IBSEARCH);
	    				formObj.ver_seq.focus();
	    			}
	    			break;
			}
	    }
	}

	/**
	 * Key-Press Event 처리
	 */
  	function obj_keypress() {
		var obj = event.srcElement;

		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}

  	/**
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj = event.srcElement;

  		switch(obj.name) {
			case "pln_yr":
				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
			case "ver_seq":
  				ComKeyEnter('LengthNextFocus');
  				break;
  		}
  	}

   	/**
	 * Key-Down Event 처리
	 */
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
   			formObj.cmd_type.value = "SEARCH";
   			doActionIBSheet(sheetObjects[3], formObj, IBSEARCH);
   			formObj.ver_seq.focus();
   		}
   	}

   	/**
     * Click Event 처리
     */
   	function obj_click() {
   		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		switch (obj.name) {
  			case "cre_usr_id":
  				if(obj.value != "") {
  					//사용자정보 화면을 팝업한다.
					ComUserPopup(obj.value);
  				}
  				break;
  		}
   	}
  	// 2. 이벤트처리함수 -- End

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetid = sheetObj.id;
		switch(sheetid){
			case "t1sheet1":
				with (sheetObj){

					// 높이 설정
					style.height = 285;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 11, 100);

					var HeadTitle1 = "Lease Term|JAN|FEB|MAR|1/4 QTA|APR|MAY|JUN|2/4 QTA|JUL|AUG|SEP|3/4 QTA|OCT|NOV|DEC|4/4 QTA|G.TTL|";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 1, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);


					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		175,daLeft,		false,	"lease_term",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"JAN",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"FEB",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"MAR",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"1QTA",		false,	"|JAN|+|FEB|+|MAR|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"APR",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"MAY",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"JUN",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"2QTA",		false,	"|APR|+|MAY|+|JUN|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"JUL",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"AUG",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"SEP",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"3QTA",		false,	"|JUL|+|AUG|+|SEP|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"OCT",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"NOV",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"DEC",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"4QTA",		false,	"|OCT|+|NOV|+|DEC|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"GTTL",		false,	"|1QTA|+|2QTA|+|3QTA|+|4QTA|", dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	160,daLeft,		false,	"h_lease_term",	false,	"",	dfNone);

					//해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
					InitHeadColumn(0, "LP	(A)|OL	(B)|LT	(C)|ST	(D)|DR COST	(E)|S.TTL	(F)=(A+B+C+D+E)|SB	(G)|SO	(H)|CNTR Exp	(I)=(F+G)|CNTR Rev	(J)=(-H)|Net CNTR Exp (K)=(I-J)", daLeft);
					//						1		2		3		4			5					6			7		8					9					10					11
					RowEditable(6) = false;
					RowEditable(9) = false;
					RowEditable(10) = false;
					RowEditable(11) = false;

					//좌측헤더의 내용을 히든셀에 복사한다.
					for(var i = 0; i < Rows; i++) {
						CellText(i, "h_lease_term") = CellText(i, "lease_term");
					}

					CountPosition = 0;
					SelectionMode = 0;
				}
				break;

			case "t2sheet1":
				with (sheetObj){

					// 높이 설정
					style.height = 285;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 13, 100);

					var HeadTitle1 = "Lease Term|JAN|FEB|MAR|1/4 QTA|APR|MAY|JUN|2/4 QTA|JUL|AUG|SEP|3/4 QTA|OCT|NOV|DEC|4/4 QTA|G.TTL|";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 1, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		175,daLeft,		false,	"lease_term",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"JAN",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"FEB",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"MAR",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"1QTA",		false,	"|JAN|+|FEB|+|MAR|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"APR",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"MAY",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"JUN",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"2QTA",		false,	"|APR|+|MAY|+|JUN|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"JUL",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"AUG",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"SEP",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"3QTA",		false,	"|JUL|+|AUG|+|SEP|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"OCT",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"NOV",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"DEC",		false,	"",	dfFloat,        2,		true,		true,	11);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"4QTA",		false,	"|OCT|+|NOV|+|DEC|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		105,	daRight,	false,	"GTTL",		false,	"|1QTA|+|2QTA|+|3QTA|+|4QTA|", dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	160,daLeft,		false,	"h_lease_term",	false,	"",	dfNone);

					//해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
					InitHeadColumn(0, "LP	(A)|OL	(B)|LT	(C)|ST	(D)|S.TTL	(E)=(A+B+C+D)|N/P	(F)|C/P	(G)|MG.SET	(H)|SEN Rev	(I)|CHSS Exp	(J)=(E+F+G+H)|CHSS Rev	(K)=(-I)|Net CHSS Exp (L)=(J-K)", daLeft);
					//						1		2		3		4			5					6		7			8			9				10							11						12
					RowEditable(5)  = false;
					RowEditable(10) = false;
					RowEditable(11) = false;
					RowEditable(12) = false;


					//좌측헤더의 내용을 히든셀에 복사한다.
					for(var i = 0; i < Rows; i++) {
						CellText(i, "h_lease_term") = CellText(i, "lease_term");
					}

					CountPosition = 0;
					SelectionMode = 0;

				}
				break;

			case "sheet1":
				with (sheetObj){

					// 높이 설정
					style.height = 120;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "G.TTL|JAN|FEB|MAR|1/4 QTA|APR|MAY|JUN|2/4 QTA|JUL|AUG|SEP|3/4 QTA|OCT|NOV|DEC|4/4 QTA|G.TTL";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 1, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		175,daLeft,		false,	"title",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"JAN",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"FEB",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"MAR",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"1QTA",		false,	"|JAN|+|FEB|+|MAR|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"APR",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"MAY",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"JUN",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"2QTA",		false,	"|APR|+|MAY|+|JUN|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"JUL",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"AUG",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"SEP",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"3QTA",		false,	"|JUL|+|AUG|+|SEP|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"OCT",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"NOV",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		95,	daRight,	false,	"DEC",		false,	"",	dfFloat,        2,		true,		true,	12);
					InitDataProperty(0, cnt++ , dtData,		110,	daRight,	false,	"4QTA",		false,	"|OCT|+|NOV|+|DEC|",	dfFloat,        2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		105,	daRight,	false,	"GTTL",		false,	"|1QTA|+|2QTA|+|3QTA|+|4QTA|", dfFloat,        2,		false,		false);

					//해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
					InitHeadColumn(0, "CNTR/CHSS Exp|CNTR/CHSS Rev|G.TTL(CNTR/CHSS Exp-Rev)", daLeft);

					RowEditable(1) = false;
					RowEditable(2) = false;
					RowEditable(3) = false;

					CountPosition = 0;
					SelectionMode = 0;

				}
				break;

			case "sheet2":
				with (sheetObj){

					// 높이 설정
					style.height = 218;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "상태|PLN_YR|PLN_Seq.|VER_Seq.|EQ_KND_CD|EQ_TERM_NM|EXPN_MON_CD|EXPN_AMT";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);


					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,		100,	daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"pln_yr",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"pln_seq",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"ver_seq",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"eq_knd_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"eq_term_nm",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"expn_mon_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"expn_amt",			false,	"",	dfFloat, 2,		false,		false);

					Visible  = false;
				}
				break;

			case "sheet3":
				with (sheetObj){

					// 높이 설정
					style.height = 255;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "CNTR/CHSS|Lease Term|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);


					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		85, daCenter,	true,	"expns_type",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		90, daLeft,		true,	"lease_term",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"JAN",			false,	"",	dfFloat,  	2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"FEB",			false,	"",	dfFloat,  	2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"MAR",			false,	"",	dfFloat,	2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"APR",			false,	"",	dfFloat,    2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"MAY",			false,	"",	dfFloat,    2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"JUN",			false,	"",	dfFloat,    2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"JUL",			false,	"",	dfFloat,    2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"AUG",			false,	"",	dfFloat,    2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"SEP",			false,	"",	dfFloat,    2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"OCT",			false,	"",	dfFloat,    2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"NOV",			false,	"",	dfFloat,    2,	true,	true,	11);
					InitDataProperty(0, cnt++ , dtData,		65,	daRight,	false,	"DEC",			false,	"",	dfFloat,    2,	true,	true,	11);

					CountPosition = 0;
					SelectionMode = 0;
				}
				break;
		}
	}

	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet2") {
						formObj.f_cmd.value = SEARCH;

						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						sheetObj.DoSearch4Post("EES_LSE_0033GS.do",FormQueryString(formObj));
						ComOpenWait(false);
					}
				}
				break;

			case IBLOADEXCEL://EXCEL UPLOAD
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet3") {
						sheetObj.LoadExcel(1,1,"",-1,14,"",false,false,"");
					}
				}
				break;

			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id == "sheet2") {
						formObj.f_cmd.value = MULTI;
						sheetObj.DoSave("EES_LSE_0033GS.do", FormQueryString(formObj));
					}
				}

				break;
        }
    }


    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "CNTR" , -1 );
                    InsertTab( cnt++ , "CHSS" , -1 );

                }
             break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {

        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }

	/**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function t1sheet1_OnChange(sheetObj , Row, Col, Val) {
    	//-------------------------------------------------------------------
    	//LP|OL|LT|ST|DR COST|S.TTL|SB|SO|CNTR Exp|CNTR Rev|Net CNTR Exp
		//  1  2  3  4 		 5	   6  7  8		  9		  10		  11
		//-------------------------------------------------------------------
    	with(sheetObj) {
    		if(Row == 8 && Val > 0) {//SO (G)
				CellValue(Row,Col) = -Number(Val);
    		}
	    	//S.TTL
	    	CellValue2(6, Col)   = ComputeSum("|" + Col + "|", 1, 5);
	    	//CNTR Exp
	    	CellValue2(9, Col)  = ComputeSum("|" + Col + "|", 6, 7);
	    	//CNTR Rev
	    	CellValue2(10, Col)  = -Number(ComputeSum("|" + Col + "|", 8, 8));
	    	//Net CNTR Exp
	    	CellValue2(11, Col)  = CellValue(9, Col) - CellValue(10, Col);


	    	//CNTR/CHSS Exp
	    	sheetObjects[2].CellValue2(1, Col) = Number(CellValue(9, Col))  + Number(sheetObjects[1].CellValue(10, Col));
	    	//CNTR/CHSS Rev
	    	sheetObjects[2].CellValue2(2, Col) = Number(CellValue(10, Col)) + Number(sheetObjects[1].CellValue(11, Col));
	    	//G.TTL(CNTR/CHSS Exp -Rev)
	    	sheetObjects[2].CellValue2(3, Col) = sheetObjects[2].CellValue(1, Col) - sheetObjects[2].CellValue(2, Col);


	    	//변경된 값을 찾아 동기화한다.
	    	if(waitDoc.getElementById(WAIT_DIV_NAME).style.visibility=="hidden") {
				var vEqTermNm = CellValue(Row, "h_lease_term").slice(0,2);
				var vExpnMonCd = ColSaveName(Col);

				for(var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].RowCount; i++) {
					var tEqKndCd = sheetObjects[3].CellValue(i, "eq_knd_cd");
					var tEqTermNm = sheetObjects[3].CellValue(i, "eq_term_nm");
					var tExpnMonCd = sheetObjects[3].CellValue(i, "expn_mon_cd");

					if("U" == tEqKndCd && vEqTermNm == tEqTermNm && vExpnMonCd == tExpnMonCd) {
						if(Row == 8 && CellValue(Row, Col) > 0) {//SO (G)
							sheetObjects[3].CellValue2(i, "expn_amt") = -Number(CellValue(Row, Col));
						} else {
							sheetObjects[3].CellValue2(i, "expn_amt") = CellValue(Row, Col);
						}
						break;
					}
				}
	    	}
    	}
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function t2sheet1_OnChange(sheetObj , Row, Col, Val) {
    	//LP|OL|LT|ST|S.TTL|N/P|C/P|MG.SET|SEN Rev|CHSS Exp|CHSS Rev|Net CHSS Exp
		//	1  2  3  4	   5   6   7	  8		  9		  10	   11		   12
    	with(sheetObj) {
    		if(Row == 9 && Val > 0) {//SEN Rev
				CellValue(Row,Col) = -Number(Val);
    		}
	    	//S.TTL
	    	CellValue2(5, Col)   = ComputeSum("|" + Col + "|", 1, 4);
	    	//CHSS Exp
	    	CellValue2(10, Col)  = ComputeSum("|" + Col + "|", 5, 8);
	    	//CHSS Rev
	    	CellValue2(11, Col)  = -Number(ComputeSum("|" + Col + "|", 9, 9));
	    	//Net CHSS Exp
	    	CellValue2(12, Col)  = CellValue(10, Col) - CellValue(11, Col);


	    	//CNTR/CHSS Exp
	    	sheetObjects[2].CellValue2(1, Col) = Number(sheetObjects[0].CellValue(9, Col)) + Number(CellValue(10, Col));
	    	//CNTR/CHSS Rev
	    	sheetObjects[2].CellValue2(2, Col) = Number(sheetObjects[0].CellValue(10, Col)) + Number(CellValue(11, Col));
	    	//G.TTL(CNTR/CHSS Exp -Rev)
	    	sheetObjects[2].CellValue2(3, Col) = sheetObjects[2].CellValue(1, Col) - sheetObjects[2].CellValue(2, Col);


	    	//변경된 값을 찾아 동기화한다.
	    	if(waitDoc.getElementById(WAIT_DIV_NAME).style.visibility=="hidden") {
				var vEqTermNm = CellValue(Row, "h_lease_term").split("\t")[0];
				var vExpnMonCd = ColSaveName(Col);

				for(var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].RowCount; i++) {
					var tEqKndCd = sheetObjects[3].CellValue(i, "eq_knd_cd");
					var tEqTermNm = sheetObjects[3].CellValue(i, "eq_term_nm");
					var tExpnMonCd = sheetObjects[3].CellValue(i, "expn_mon_cd");

					if("Z" == tEqKndCd && vEqTermNm == tEqTermNm && vExpnMonCd == tExpnMonCd) {
						if(Row == 9 && CellValue(Row, Col) > 0) {//SEN Rev
							sheetObjects[3].CellValue2(i, "expn_amt") = -Number(CellValue(Row, Col));
						} else {
							sheetObjects[3].CellValue2(i, "expn_amt") = CellValue(Row, Col);
						}
						break;
					}
				}
	    	}
    	}
    }

    /**
     * 특정 셀의 값을 편집한 직후에 발생하는 Event
     */
    function t1sheet1_OnAfterEdit(sheetObj, Row,Col) {
    	with(sheetObj) {
	    	//변경된 값을 찾아 동기화한다.
			var vEqTermNm = CellValue(Row, "h_lease_term").split("\t").slice(0,1);
			var vExpnMonCd = ColSaveName(Col);

			for(var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].RowCount; i++) {
				var tEqKndCd = sheetObjects[3].CellValue(i, "eq_knd_cd");
				var tEqTermNm = sheetObjects[3].CellValue(i, "eq_term_nm");
				var tExpnMonCd = sheetObjects[3].CellValue(i, "expn_mon_cd");

				if("U" == tEqKndCd && vEqTermNm == tEqTermNm && vExpnMonCd == tExpnMonCd) {
					if(Row == 8 && CellValue(Row, Col) > 0) {//SO (G)
						sheetObjects[3].CellValue2(i, "expn_amt") = -Number(CellValue(Row, Col));
					} else {
						sheetObjects[3].CellValue2(i, "expn_amt") = CellValue(Row, Col);
					}
					break;
				}
			}
    	}
    }

    /**
     * 특정 셀의 값을 편집한 직후에 발생하는 Event
     */
    function t2sheet1_OnAfterEdit(sheetObj, Row,Col) {
    	with(sheetObj) {
	    	//변경된 값을 찾아 동기화한다.
			var vEqTermNm = CellValue(Row, "h_lease_term").split("\t").slice(0,1);
			var vExpnMonCd = ColSaveName(Col);

			for(var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].RowCount; i++) {
				var tEqKndCd = sheetObjects[3].CellValue(i, "eq_knd_cd");
				var tEqTermNm = sheetObjects[3].CellValue(i, "eq_term_nm");
				var tExpnMonCd = sheetObjects[3].CellValue(i, "expn_mon_cd");

				if("Z" == tEqKndCd && vEqTermNm == tEqTermNm && vExpnMonCd == tExpnMonCd) {
					if(Row == 9 && CellValue(Row, Col) > 0) {//SEN Rev
						sheetObjects[3].CellValue2(i, "expn_amt") = -Number(CellValue(Row, Col));
					} else {
						sheetObjects[3].CellValue2(i, "expn_amt") = CellValue(Row, Col);
					}
					break;
				}
			}
    	}
    }

    /**
     * 가로 스크롤 또는 세로 스크롤이 움직였을때 발생하는 Event
     */
    function sheet1_OnScroll(sheetObj, OldTopRow, OldLeftCol, NewTopRow, NewLeftCol) {
    	with(sheetObj) {
			if(OldLeftCol != NewLeftCol) {
				if(OldLeftCol > NewLeftCol) {
					sheetObjects[0].SelectCell(0, NewLeftCol);
					sheetObjects[1].SelectCell(0, NewLeftCol);
				} else {
					sheetObjects[0].SelectCell(0, NewLeftCol +7);
					sheetObjects[1].SelectCell(0, NewLeftCol +7);
				}
      		}
    	}
    }

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;

		ComOpenWait(true, "tabLayer");
    	//조회 결과를 t1sheet1, t2sheet1, sheet1에 할당한다.
    	with(sheetObj) {
    		for(var i = HeaderRows; i <= RowCount; i++) {
    			var vEqKndCd = CellValue(i, "eq_knd_cd");
    			var vEqTermNm = CellValue(i, "eq_term_nm");
    			var vExpnMonCd = CellValue(i, "expn_mon_cd");
    			var vExpnAmt = CellValue(i, "expn_amt");

    			if(vEqKndCd == "U") {//CNTR
    				var vRowIdx = sheetObjects[0].FindText("h_lease_term", vEqTermNm, 0, 0);
    				sheetObjects[0].CellValue(vRowIdx, vExpnMonCd) = vExpnAmt;
    			} else if(vEqKndCd == "Z") {//CHSS
    				var vRowIdx = sheetObjects[1].FindText("h_lease_term", vEqTermNm, 0, 0);
    				sheetObjects[1].CellValue(vRowIdx, vExpnMonCd) = vExpnAmt;
    			} else {
    				//do nothing
    			}
    		}

			//버젼 관리번호를 설정한다.
    		document.form.ver_seq.value = CellValue(1, "ver_seq");
    		ComEnableObject(formObj.btns_DownFile,  true);
    	}
    	ComOpenWait(false, "tabLayer");
    }

	/**
     * 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;

    	if(!/Error/.test(ErrMsg)) {
    		if(formObj.cmd_type.value == "VERUP") {
    			formObj.ver_seq.value = "";
    		}

    		ComShowCodeMessage("LSE10001");
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}
    }

	/**
	 * 엑셀에서 데이터를 모두 읽어들였을때 발생하는 Event
	 * @param sheetObj
	 */
	function sheet3_OnLoadExcel(sheetObj) {
		ComOpenWait(true, "tabLayer");
		//조회 결과를 t1sheet1, t2sheet1, sheet1에 할당한다.
    	with(sheetObj) {
    		for(var i = HeaderRows; i <= RowCount; i++) {
    			for(var j = 2; j <= LastCol; j++) {
    				var vEqTermNm  = CellValue(i, "lease_term");
    				var vExpnAmt   = CellValue(i, j);
	    			var vExpnMonth = ColSaveName(j);

	    			if(i < 8) {//CNTR
	    				var vRowIdx = sheetObjects[0].FindText("h_lease_term", vEqTermNm, 0, 0);
						sheetObjects[0].CellValue(vRowIdx, vExpnMonth) = vExpnAmt;
	    			} else if(i < 17) {//CHSS
	    				var vRowIdx = sheetObjects[1].FindText("h_lease_term", vEqTermNm, 0, 0);
						sheetObjects[1].CellValue(vRowIdx, vExpnMonth) = vExpnAmt;
	    			} else {
	    				//do nothing
	    			}

					var vRowIdx = (12*i)-12+j-1;
					if((i == 7 || i == 15) && vExpnAmt > 0) {//SO or SEN Rev
	    				sheetObjects[3].CellValue2(vRowIdx, "expn_amt") = -Number(vExpnAmt);
					} else {
						sheetObjects[3].CellValue2(vRowIdx, "expn_amt") = vExpnAmt;
					}
    			}
    		}

			RemoveAll();
    	}
    	ComOpenWait(false, "tabLayer");
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSEARCH:      //조회
    			case IBLOADEXCEL:	//업로드
	    			if ( formObj.pln_yr.value == "" ) {
						ComShowCodeMessage("LSE01036");
						ComSetFocus(formObj.pln_yr);
						return false;
						break;
					}

    				return ComChkValid(formObj, false);
    				break;
    		}

    		with(sheetObj) {
	    		switch(sAction) {
		    		case IBSAVE:		//저장
		    			if(formObj.cmd_type.value == "VERUP") {
	    					for(var i = HeaderRows; i <= LastRow; i++) {
	    						RowStatus(i) = "I";
	    					}
		    			}
		    			return true;
		    			break;
		    		default : 	//do nothing
	    		}
	    	}
		}

        return true;
    }

    /**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName)
	{
		var formObj = document.form;
		switch(fieldName) {
			case "pln_yr":
				formObj.ver_seq.value  = "";
				break;
		}
	}

	/* 개발자 작업  끝 */