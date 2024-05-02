/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0092.js
*@FileTitle : On-Hire Total Summary By Lease Term & Year
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.10.07 진준성
* 1.0 Creation
* 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
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
     * @class EES_LSE_0092 : EES_LSE_0092 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0092() {
    	this.processButtonClick = processButtonClick;
    	this.setSheetObject     = setSheetObject;
    	this.setComboObject     = setComboObject;
    	this.loadPage           = loadPage;
    	this.initSheet          = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet    = doActionIBSheet;
    	this.setTabObject       = setTabObject;
    	this.validateForm       = validateForm;
    	this.obj_change         = obj_change;
    	this.obj_keypress       = obj_keypress;
    	this.validateForm       = validateForm;
    	this.loc_tp_OnChange    = loc_tp_OnChange;
    	this.sheet1_OnSort      = sheet1_OnSort;
    	this.sheet1_OnDblClick  = sheet1_OnDblClick;
    	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
    	this.combo2_OnCheckClick 	= combo2_OnCheckClick;
    	this.combo1_OnBlur 			= combo1_OnBlur;
    	this.combo2_OnBlur 			= combo2_OnBlur;
    	this.combo1_OnKeyDown 		= combo1_OnKeyDown;
    	this.combo2_OnKeyDown 		= combo2_OnKeyDown;
    }

   	/* 개발자 작업	*/
  //공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    //Combo Object Array
    var comboObjects = new Array();
    var comboCnt = 0;

    var arrTpSz  = new Array();
    var arrTpSz2 = new Array();
    var arrMonth  = [["jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"],["H","H","H","H","H","H","H","H","H","H","H","H"]];

    //버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    function initControl() {
    	var formObj = document.form;
    	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
    	axon_event.addListenerFormat('change','obj_change',formObj);       //- 변경될때.
    	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
    	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
    	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
    	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
    }

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcObj  = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    		case "btn_DownExcel1":
    			sheetObject1.SpeedDown2Excel(-1);
    			break;

    		case "btn_DownExcel2":
    			sheetObject2.SpeedDown2Excel(-1);
    			break;

    		case "btn_Retrieve":
    			if ( srcObj.style.filter == "" ) {
    				sheetObject1.RemoveAll();
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			}
    			break;

    		case "btn_New":
    			sheetObject1.RemoveAll();
    	    	var now = new Date();
    	        var year= now.getFullYear();
    	        var mon = (now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);
    	        //document.form.period_stdt.value = year + "-01";
    	        //document.form.period_eddt.value = year + "-" + mon;
    	        document.form.period_stdt.value = "";
    	        document.form.period_eddt.value = "";

    			formObject.loc_cd.value = "";
    			formObject.loc_tp[0].selected = true;
    			ComEnableObject(document.form.btns_search1, false);

    			document.form.supplier.value = "";
    	        document.form.vndr_seq.value = "";
    	        //ComEnableObject(document.form.btns_search2, false);

    			for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
    				comboObjects[0].CheckIndex(i)=false;
    			}
    			formObject.lstm_cd.value = "";
    			for(var i = 1 ; i < comboObjects[1].GetCount(); i++ ){
    				comboObjects[1].CheckIndex(i)=false;
    			}
    			comboObjects[0].CheckIndex(0) = true;
    			comboObjects[1].CheckIndex(0) = true;
    			formObject.cntr_tpsz_cd.value = "";

    			for(var i = 0 ; i <  12 ; i++ ){
    				sheetObject1.ColHidden(arrMonth[0][i]) = false;
    			}

    			ComSetFocus(document.form.period_stdt);
    			break;


    		case "btns_calendar1":
      			if ( srcObj.style.filter == "" ) {
      				var cal = new ComCalendar();
      				cal.setDisplayType('month');
      				cal.select(formObject.period_stdt, "yyyy-MM");
      			}
      			break;

      		case "btns_calendar2":
      			if ( srcObj.style.filter == "" ) {
      				var cal = new ComCalendar();
      				cal.setDisplayType('month');
      				cal.select(formObject.period_eddt, "yyyy-MM");
      			}
      			break;

    		case "btns_search1":      // loc_cd
    		if ( srcObj.style.filter == "" ) {

    			openPopup("1");

    		}
    		break;

    		case "btns_search2":     // lessor
    		if ( srcObj.style.filter == "" ) {
    			openPopup("2");
    		}
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
    * IBMultiCombo Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }

    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {

    	for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );

    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}

    	initControl();

    	/* IBMultiCombo 초기화 */
    	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
    		initCombo(comboObjects[k], k+1);
    	}
    }

    function sheet1_OnLoadFinish(){
    	/* IBMulti Combo Item Setting */
    	doActionIBSheet(sheetObjects[0], document.form,IBCREATE);
    	comboObjects[0].InsertItem(0, 'ALL', 'ALL');
    	comboObjects[0].InsertItem(1, 'OW' , 'OW');
    	comboObjects[0].InsertItem(2, 'LP' , 'LP');
    	comboObjects[0].InsertItem(3, 'OL' , 'OL');
    	comboObjects[0].InsertItem(4, 'LT' , 'LT');

    	var now = new Date();
        var year= now.getFullYear();
        var mon = (now.getMonth()+1)>9 ? ''+(now.getMonth()+1) : '0'+(now.getMonth()+1);
        //document.form.period_stdt.value = year + "-01";
        //document.form.period_eddt.value = year + "-" + mon;

    	comboObjects[0].CheckIndex(0) = true;
    	comboObjects[1].CheckIndex(0) = true;
    	ComEnableObject(document.form.btns_search1, false);
    	//document.form.period_stdt.focus();
    	//ComEnableObject(document.form.btns_search2, false);
    	ComSetFocus(document.form.period_stdt);
    }
    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var sheetid = sheetObj.id;

    	switch(sheetid) {
    	case "sheet1":
    		with (sheetObj) {

    			// 높이 설정
    			style.height = 355;
    			//전체 너비 설정
    			SheetWidth = 984;//mainTable.clientWidth;

    			//Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    			//전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msPrevColumnMerge;

    			//전체Edit 허용 여부 [선택, Default false]
    			Editable = false;

    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo(1, 3, 10, 100);
       			var HeadTitle = "|Year|AGMT No.|Term|Location(LCC)|TP/SZ|Supplier|Result|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec|G.TTL|";
    			var headCount = ComCountHeadTitle(HeadTitle);

    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(headCount, 0, 0, true);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(false, true, false, true, false,false);

    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle, true);

    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			for(var i = 0; i < 3; i ++) {
    				cnt = 0;
	    	        InitDataProperty(i, cnt++ , dtHiddenStatus, 0,    daCenter, true,  "ibflag");
	    	        InitDataProperty(i, cnt++ , dtData,        50,    daCenter, true,  "year_month",  false,  "",     dfNone);
	    	        InitDataProperty(i, cnt++ , dtData,        80,    daCenter, true,  "agmt_no",     false,  "",     dfNone);
	    	        InitDataProperty(i, cnt++ , dtData,        80,    daCenter, true,  "lstm_cd",     false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        90,    daCenter, true,  "loc_cd",      false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        50,    daCenter, true,  "tysz",        false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daCenter, true,  "supplier",    false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daCenter, true,  "result",      false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "jan",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "feb",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "mar",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "apr",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "may",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "jun",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "jul",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "aug",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "sep",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "oct",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "nov",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "dec",         false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtData,        80,    daRight,  true,  "div_total",   false,  "",     dfNone);
	      			InitDataProperty(i, cnt++ , dtAutoSum,     80,    daRight,  true,  "auto_sum",    false,  "",     dfNone);
    			}

				ColHidden("auto_sum") = true;
      			SelectBackColor = LSE_SELECT_BACK_COLOR;
    			CountPosition   = 0;
    			FrozenCols = 8;
    		}
    		break;
    	}
    }

    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	//sheetObj.ShowDebugMsg = false;
    	switch(sAction) {

    	case IBSEARCH:      //조회
    	if(validateForm(sheetObj,formObj,sAction))
    		if (sheetObj.id == "sheet1"){
  			    formObj.f_cmd.value = SEARCH;

  			    sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
    			var sXml = sheetObj.GetSearchXml("EES_LSE_0092GS.do",FormQueryString(formObj));
    			ComOpenWait(false);

    			if(ComGetTotalRows(sXml) > 0){

    			    var stdt = formObj.period_stdt.value;
    			    var eddt = formObj.period_eddt.value;

    			    stYear = stdt.substr(0,4);
    			    edYear = eddt.substr(0,4);
    			    stdt = stdt.substr(5,7);
    			    eddt = eddt.substr(5,7);

    			    if(stYear == edYear){
    				    for(var i = Number(stdt) ; i <= Number(eddt) ; i++ ){
           		    	    arrMonth[1][i-1] = "S";
        		        }
    			    }else{

    				    for(var i = Number(stdt) ; i <= 12 ; i++ ){
        		    	    arrMonth[1][i-1] = "S";
        		        }
    				    for(var i = 1 ; i <= Number(eddt) ; i++ ){
        		    	   arrMonth[1][i-1] = "S";
        		        }
    			    }

    			    for(var i = 0 ; i <  12 ; i++ ){
    				    if(arrMonth[1][i] == "H"){
    					    sheetObj.ColHidden(arrMonth[0][i]) = true;
    				    }else{
    					    sheetObj.ColHidden(arrMonth[0][i]) = false;
    				    }
    			    }

					sheetObj.Redraw = false;
    				sheetObj.LoadSearchXml(sXml);

					for ( var idx = sheetObj.HeaderRows ; idx <= sheetObj.LastRow ; idx++ ) {
						//비율계산에 대한 '%' 기호추가
						for(var i = 0; i <= sheetObj.LastCol; i++) {
							switch(sheetObj.ColSaveName(i)) {
								case "jan": case "feb": case "mar": case "apr":
								case "may": case "jun": case "jul": case "aug":
								case "sep": case "oct": case "nov": case "dec":
								case "div_total":
									var vCommaValue = Number(sheetObj.CellValue(idx, i));
									//비율계산에 대한 '%' 기호추가
									if ( sheetObj.CellValue(idx, "result") == "Ratio" ) {
										sheetObj.CellValue(idx, i) = ComGetMaskedValue(vCommaValue, "float");
										sheetObj.CellValue(idx, i) += "%";
									} else {
										sheetObj.CellValue(idx, i) = ComGetMaskedValue(vCommaValue, "int");
									}
									break;
								default : //do nothing
							}
						}
					}

					sheetObj.CellValue(sheetObj.LastRow -2, "year_month") = "G.TTL";
					sheetObj.Redraw = true;
    			} else {
					sheetObj.LoadSearchXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");
    			}
    		}
    	break;

    	case IBCREATE: //tpsz 콤보생성
    	formObj.f_cmd.value = SEARCH02;
    	sheetObj.WaitImageVisible = false;
    	var sXml2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
    	sheetObj.WaitImageVisible = true;

    	if ( sXml2 != "" ) {
    		comboObjects[1].InsertItem(0 , 'ALL','ALL');
    		LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
    		vOrcCntrTpszCd = ComGetEtcData(sXml2, "cntr_tpsz_cd");
    		formObj.tysz.value = vOrcCntrTpszCd;
    	}
    	break;

    	case IBSEARCH_ASYNC01:      //상세조회
    	if(validateForm(sheetObj,formObj,sAction)) {
    		if(sheetObj.id == "sheet2") {
    			formObj.f_cmd.value = SEARCH01;
    			sheetObj.DoSearch("EES_LSE_0036GS.do",FormQueryString(formObj));
    		}
    	}
    	break;
    	}
    }

    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
    	with(sheetObj){
    		with(formObj){
    			switch(sAction) {
    			case IBSEARCH:      //조회

    			var periodStdt = formObj.period_stdt.value;
    			periodStdt = periodStdt.replaceStr("-","");
    			var periodEtdt = formObj.period_eddt.value;
    			periodEtdt = periodEtdt.replaceStr("-","");
    			if ( periodStdt == "" ) {
    				ComShowCodeMessage("LSE01010");
    				ComSetFocus(formObj.period_stdt);
    				return false;
    				break;
    			}
    			if ( periodEtdt == "" ) {
    				ComShowCodeMessage("LSE01011");
    				ComSetFocus(formObj.period_eddt);
    				return false;
    				break;
    			}
    			if ( Number(periodStdt) > Number(periodEtdt)) {
    				ComShowCodeMessage("LSE01051");
    				ComSetFocus(formObj.period_stdt);
    				return false;
    				break;
    			}
    			if(formObj.cntr_tpsz_cd.value == ""  && comboObjects[1].CheckIndex(0) == false ){
    				ComShowCodeMessage("LSE01015");
    				formObj.combo2.focus();
    				return false;
    				break;
    			}
    			break;
    			}
    		}
    	}
    	return true;
    }

    /**
    * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
    */
    function obj_blur(){
    	var obj = event.srcElement;
    	switch(obj.name){
    	case "period_stdt":
    		//숫자이면서 천단위 구분을 하지 않는다.
    		ComChkObjValid(obj);
    		break;
    	case "period_eddt":
    		//숫자이면서 천단위 구분을 하지 않는다.
    		ComChkObjValid(obj);
    		break;
    	case "btns_calendar3":
    		//숫자이면서 천단위 구분을 하지 않는다.
    		ComChkObjValid(obj);
    		break;
    	default:
    		//Validation 전체 체크(길이,format,최대,최소 등등)
    	break;
    	}
    }

    /**
    * 콤보 초기설정값, 헤더 정의
    * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
    * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.id) {
    	case "combo1":
    		with(comboObj) {
    			DropHeight = 250;
    			MultiSelect = true;
    			//MaxSelect = 1;
    			MultiSeparator = ",";
    			Style = 1;
    			UseAutoComplete = true;
    			//영문(대)+특수문자 - Lease Term
    			ValidChar(2,2);
    		}
    		break;

    	case "combo2":
    		with(comboObj) {
    			DropHeight = 200;
    			MultiSelect = true;
    			//MaxSelect = 1;
    			MultiSeparator = ",";
    			Style = 0;
    			UseAutoComplete = true;
    			//영문(대)+특수문자,숫자 - TP/SZ
    			ValidChar(2,3);
    		}
    		break;

    	}
    }

    /**
     * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
     * @return
     * @deprecated
     */
    function combo1_OnCheckClick(comboObj, index, code) {
    	if(index==0) {
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
            //ComEnableObject(document.form.btns_search2, false);
            //document.form.supplier.value = "";
            //document.form.vndr_seq.value = "";
    	} else if(index==4) {
    		for(var i = 0 ; i < 4 ; i++) {
				comboObj.CheckIndex(i) = false;
			}
    		//ComEnableObject(document.form.btns_search2, true);
    		//document.form.supplier.value = "";
    		//document.form.vndr_seq.value = "";
    	} else {
    		comboObj.CheckIndex(0) = false;
    		comboObj.CheckIndex(4) = false;
    		//ComEnableObject(document.form.btns_search2, true);
    		//document.form.supplier.value = "";
    		//document.form.vndr_seq.value = "";
    	}
    }

    /**
    * combo1_OnBlur
    */
    function combo1_OnBlur(comboObj, Index_Code, Text) {
    	var formObj = document.form;
    	if( comboObj.CheckIndex(0)){
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = false;
    		}
    		formObj.lstm_cd.value = "";
    	}else if(comboObj.Text == ""){
    		comboObj.CheckIndex(0) = true;
    		formObj.lstm_cd.value = "";
    	}else{
    	    formObj.lstm_cd.value = ComGetObjValue(comboObj);
    	}
    }

    /**
    * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
    * @return
    */
    function combo2_OnCheckClick(comboObj, index, code) {
    	if(index==0) {
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }

    /**
    * combo2_OnBlur
    */
    function combo2_OnBlur(comboObj, Index_Code, Text) {
    	var formObj = document.form;
    	if( comboObj.CheckIndex(0)){
    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    			comboObj.CheckIndex(i) = false;
    		}
    		formObj.cntr_tpsz_cd.value = "";
    	}else if(comboObj.Text == ""){
    		comboObj.CheckIndex(0) = true;
    		formObj.cntr_tpsz_cd.value = "";
    	}else{
    	    formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
    	}
    }

    /**
    * combo1_OnKeyDown
    */
    function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
    	with(comboObj) {
    	    if(KeyCode == 13){
 		        sheetObjects[0].RemoveAll();
 			    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    }
    	}
    }

    /**
    * combo2_OnKeyDown
    */
    function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
    	with(comboObj) {
    		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
    			comboObj.Text = "";
    		}else if(KeyCode == 13){
     		    sheetObjects[0].RemoveAll();
     			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    		}
    	}
    }

    /**
    * Key-Down Event 처리
    */
    function obj_keydown() {
    	var obj      = event.srcElement;
    	var vKeyCode = event.keyCode;
    	var formObj  = document.form;
    	var srcObj  = window.event.srcElement;
    	if ( vKeyCode == 13 ) {
    		switch(obj.name) {
    		    case "aaa":
    		    default :
    			    if ( srcObj.style.filter == "" ) {
    				    sheetObjects[0].RemoveAll();
    				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			    }
    	    }
    	}
    }

    /**
    * Pop-up Open 부분<br>
    * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
    * @param object 대상 Object
    * @param Row 대상Object가 IBSheet일 경우 해당 Row index
    */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;
    	if ( type == "1" ) {
    		switch(formObj.loc_tp.value) {
    		case "R" :	//RCC
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430,"setPopData_DeliveryLoc", "0,1,1,1,1,1,1", true);
    		break;
    		case "L" :	//LCC
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430,"setPopData_DeliveryLoc", "0,1,1,1,1,1,1", true);
    		break;
    		case "S" :	//SCC
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430,"setPopData_DeliveryLoc", "0,1,1,1,1,1,1", true);
    		break;
    		default : 	//do nothing
    		}
    	} else if ( type == "2") {
    		//if( comboObjects[0].CheckIndex(4)){
    		    // Lessor
    			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '0,1,1,1,1,1,1,1', true);
    		//}else{
    			// M/Facturer
    			//ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '0,1,1,1,1,1,1,1', true);
    		//}
    	}
    }

    /**
    * DeliveryLoc(Yard) Pop-up Return Value 처리 부분<br>
    * @param {arry} returnedValues Pop-up 화면의 Return value array
    * @param Row 대상Object가 IBSheet일 경우 해당 Row index
    * @param Col 대상Object가 IBSheet일 경우 해당 Col index
    * @param 대상IBSheet의 Sheet Array index
    */
    function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;
        var strLocCd = "";
        var j = 0;
        if(formObj.loc_tp.value == "R"){
        	j = 11;
        }else if(formObj.loc_tp.value == "L"){
        	j = 10;
        }else if(formObj.loc_tp.value == "S"){
        	j = 8;
        }
    	for (var i = 0 ; i < aryPopupData.length ;i++ ) {
    		if(i == 0){
    		    strLocCd =  aryPopupData[i][j] ;
    		}else{
    			strLocCd = strLocCd + "," + aryPopupData[i][j] ;
    		}
    	}
    	formObj.loc_cd.value = strLocCd;
    }

    /**
    * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
    * @param {arry} returnedValues Pop-up 화면의 Return value array
    * @param Row 대상Object가 IBSheet일 경우 해당 Row index
    * @param Col 대상Object가 IBSheet일 경우 해당 Col index
    * @param 대상IBSheet의 Sheet Array index
    */
    function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	var strVndrNm  = "";
    	var strVndrSeq = "";

        for (var i = 0 ; i < aryPopupData.length ;i++ ) {
    		if(i == 0){
    			strVndrNm  =  ComLtrim(aryPopupData[i][2],"0");
    			strVndrSeq =  ComLtrim(aryPopupData[i][2],"0");
    		}else{
    			strVndrNm  = strVndrNm  + "," + ComLtrim(aryPopupData[i][2],"0");
    			strVndrSeq = strVndrSeq + "," + ComLtrim(aryPopupData[i][2],"0");
    		}
    	}
        formObj.supplier.value = strVndrNm;
    	formObj.vndr_seq.value = strVndrSeq;
    }

    /**
    * HTML Control의 Value가 변경되었을 경우 처리한다.
    */
    function obj_change(){
    	var obj      = event.srcElement;
    	var formObj  = document.form;
    	switch(obj.name) {

    	case "loc_tp":		//Location Type
    	formObj.loc_cd.value = "";
    	if(obj.value == "") {
    		ComEnableObject(formObj.btns_search1, false);
    	} else {
    		ComEnableObject(formObj.btns_search1, true);
    	}
    	break;

    	case "period_stdt":		//Location Code
    	if(formObj.period_eddt.value != ""){
    		checkDatePeriod( formObj.period_stdt , formObj.period_eddt , "ym") ;
    	}
    	break;

    	case "period_eddt":		//Location Code
    	checkDatePeriod( formObj.period_stdt , formObj.period_eddt , "ym") ;
    	break;
    	}
    }
    /**
    * HTML Control의 키보드 이벤트 방 포멧처리 한다.
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
    		if(obj.name == "loc_cd") {
	            ComKeyOnlyAlphabet('uppernum');
        	}else{
        		ComKeyOnlyAlphabet('upper');
        	}
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
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			//소계 Title Merge 처리
			if(SearchRows > 0) {
				var strRows = ComFindAll(sheetObj, "agmt_no", "S.TTL");
				var arrStrRows = strRows.split("|");
				for ( var i = 0 ; i < arrStrRows.length ; i++ ) {
					if ( i%3 == 0 ) {
						SetMergeCell(arrStrRows[i], 2, 3, 5);
					}
				}

				//합계 Title Merge 처리
				var strRows2 = ComFindAll(sheetObj, "year_month", "G.TTL");
				var arrStrRows2 = strRows2.split("|");
				for ( var i = 0 ; i < arrStrRows2.length ; i++ ) {
					if ( i%3 == 0 ) {
						SetMergeCell(arrStrRows2[i], 1, 3, 6);
					}
				}

				for(var i = 0; i < arrStrRows2.length; i++) {
					var vRowIdx = parseInt(arrStrRows2[i]);
					CellAlign(vRowIdx +3, "result") = daCenter;

					for(var j = 0; j < LastCol; j++) {
						CellText(vRowIdx +3, j) = CellText(vRowIdx, j);
					}
				}

				sheetObj.RowDelete(LastRow -5, false);
				sheetObj.RowDelete(LastRow -4, false);
				sheetObj.RowDelete(LastRow -3, false);
				sheetObj.CellValue(LastRow -2, "year_month") = "G.TTL";
				sheetObj.SetMergeCell(LastRow -2, 1, 3, 6);
			}
		}
    }

	/* 개발자 작업  끝 */