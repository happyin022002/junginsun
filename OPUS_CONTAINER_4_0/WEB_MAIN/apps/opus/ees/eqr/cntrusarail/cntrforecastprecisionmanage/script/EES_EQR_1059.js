/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1059.js
*@FileTitle : MTY Rail Trans Result
*Open Issues :
*Change history :
** No.   Ver.    Modifier         modifier date    explanation
* 1      1.1     chae Chang ho    2010-04-13       FormQueryString 사용금지로 eqrFormQryStr으로 대체
*@LastModifyDate : 2009.10.07
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
* =======================================================
* 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 
     */

    /**
     * @extends 
     * @class EES_EQR_1059 : EES_EQR_1059 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1059() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0 ;
	
	var sheetObject = null;
	var sheetRow    = 0 ;
	var tpszArr = new Array();
	
	var detailXml = null;
	var popUpXml = null;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	document.onfocusin=bluring;

	var formObject = null;
	var srcName = null;
	
	/**
	 * 설  명 : 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <b>Example : </b>
	 * <pre>
	 *    processButtonClick()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function processButtonClick(){
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					sheetObject.RemoveAll();
					if(validateForm(sheetObject,formObject,IBSEARCH)){
						initSheet(sheetObject,1);
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
					}
					break;
				
				case "btn_new": 
					sheetObject.RemoveAll();
					formObject.reset();
					tpszChange('');
					break;
				
				case "btn_downexcel":
					sheetObject.Down2Excel(-1, false, false, true);
					break;
				
				case "btn_print":
					var title = document.all.title.innerText;
					if(sheetObject.RowCount('') > 0){ 
						sheetObject.Down2Print(true,2,title);
					}
					if(sheetObject.RowCount('') == 0){
						ComShowCodeMessage("EQR90095"); // ComShowMessage('Print 할 Data가 없습니다.');
					}
					break;
				
				case "btns_calendar":
					var cal = new ComCalendarFromTo();
                    cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
                    break;
				
				case "btn_orgloc":
                	var display 	  = '1,0,1,1,0,1,1,1,1,0,1,1';
  				    ComOpenPopup('/opuscntr/COM_ENS_051.do', 770, 410, 'setOrgLoc', display);
  				    break;
    
				case "btn_destloc":
                	var display 	  = '1,0,1,1,0,1,1,1,1,0,1,1';
                	ComOpenPopup('/opuscntr/COM_ENS_051.do', 770, 410, 'setDestLoc', display);
  				    break;
			
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("EQR90004"); //ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);  //ComShowMessage(e);
			}
		}
	}
	
	/**
	 * 설  명 :  Sheet 기본 설정 및 초기화 <br>
	 *          body 태그의 onLoad 이벤트핸들러 구현<br>
	 *          화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function loadPage() {
		sheetObject = sheetObjects[0];    /* 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 */
		formObject = document.form;
		
		for(var i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);  //khlee-시작 환경 설정 함수 이름 변경
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);  //khlee-마지막 환경 설정 함수 추가
		}
		for(p=0;p< comboObjects.length;p++){
			initCombo (comboObjects[p],p+1);
		}
		
		tpszChange('');
        initControl();
	}
	
	/**
	 * 설  명 :  시트 초기설정값, 헤더 정의 <br>
	 *          시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     initSheet(sheetObj,sheetNo,tpszValue)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {Number}	sheetNo  - Sheet Number (시트오브젝트 태그의 아이디에 붙인 일련번호)
	 * @param {String}	tpszValue  - Container Tpsz
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sDate = formObject.fm_dt.value;
		var eDate = formObject.to_dt.value;
		var i = 0;
		
		if(( comboObjects[0].Text == null || comboObjects[0].Text == "")){
			tpszArr = tpszallText.split("|");
		} else {
			tpszArr = (comboObjects[0].Text).split(",") ;
		}
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 400;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 1, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					totalCols = 3 + tpszArr.length + 1;
					InitColumnInfo(totalCols, 3, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					var gubun = gubunValue();
					var titleText = (gubun =="A" || gubun == null) ? "Origin Loc.|Dest. Loc." : "Origin Yard|Dest. Yard";
					
					var HeadTitle = titleText+ "|Total";
					for(j=0; j <= tpszArr.length; j++ ){
						HeadTitle += "|" +tpszArr[j];
					}
					HeadTitle = HeadTitle ;
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter, true,    "dest1"       ,       false,          "",       dfNone,       0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter, false,    "dest2"       ,       false,          "",       dfNone,       0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      55,    daCenter, false,     "total"  ,       false,          "",       dfNumber,       0,     false,       false);
					
					for(k=0; k < tpszArr.length; k++ ){
						InitDataProperty(0, cnt++ , dtData,      50,    daCenter, false,     tpszArr[k].toLowerCase()+"_qty"  ,       false,          "",       dfNumber,       0,     false,       false);
					}
					InitDataProperty(0, cnt++ , dtHidden,   60,    daCenter, false,    "gubun"       ,            false,          "",       dfNone,       0,     false,      false);

					HeadRowHeight= 20;
					SelectHighLight = false;
					ExtendLastCol = false;
				}
				break;
				
			case 2:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 1, 100);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(4, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, true, false, false, false);
				
				var HeadTitle = "chk|||CNTR No.";
									
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDummyCheck,    120,    daCenter, true,    "check"       ,       false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   	 300,    daCenter, true,    "gubun"       ,       false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,     	 120,    daCenter, true,    "eq_no"       ,       false,          "",       dfNone,       0,     false,       false);
				
				HeadRowHeight= 20;
				CountPosition = 0;
				SelectHighLight = false;
				ExtendLastCol = false;
			}
			break;
		}
	}
	
	/**
	 * 설  명 :  Combo 기본 설정 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     initCombo(comboObj,comboNo)
	 * </pre>
	 * @param {object}	comboObj - Combo Object
	 * @param {Number}	comboNo  - Combo Number
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initCombo (comboObj, comboNo) {
		var cnt  = 0 ;
		
		switch(comboNo) {		
			// Type Size
			case 1:
				with (comboObj) {				
					DropHeight = 12 * 20;
					
					var menuname = tpszallText.split('|'); 
					var menucode = tpszallCode.split('|'); 
					
					MultiSelect = true;
					MaxSelect = menuname.length;
					MultiSeparator = ",";
					
					for(i=0; i<menuname.length; i++) {
						InsertItem(cnt++, menuname[i], menucode[i]);                      		
					} 
				}
				break;
		}
	}
	
	/**
	 * 설  명 : Sheet관련 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     doActionIBSheet(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {	
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBSEARCH:			
				formObj.f_cmd.value = SEARCHLIST ;
				var sXml = sheetObj.GetSearchXml("EES_EQR_1059GS.do", eqrFormQryStr(formObj));
//				sheetObj.LoadSearchXml(sXml);
				var arrXml = sXml.split("|$$|");
				sheetObj.LoadSearchXml(arrXml[0]);
				detailXml = (arrXml[1]);
				break;
			
			case IBDOWNEXCEL:		// excel down
				//sheetObj.SpeedDown2Excel();
				sheetObj.Down2Excel(-1, false, false, true);				
				break;
		}
	}
	
	/**
	 * 설  명 : IBSheet Object를 배열로 등록 <br>
	 *         향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *         배열은 소스 상단에 정의<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setComboObject(sheet_obj)
	 *    </pre>
	 * @param  {object}	sheet_obj - Sheet Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * 설  명 : IBCombo Object를 배열로 등록 <br>
	 *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *          배열은 소스 상단에 정의<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     setComboObject(combo_obj)
	 * </pre>
	 * @param {object}	combo_obj - Combo Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
	 * 설  명 : TP/SZ 종류 변경시 코드 설정 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     tpszChange('')
	 * </pre>
	 * @param {String}	key - tpsz Combo Value('' - ALL, D - Dry, R - Refer, O - O/T, F - F/R)
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function tpszChange(key){
		switch (key) {
		case "":
			comboObjects[0].Code = consTpsz;                            
			break;
		case "D":
			comboObjects[0].Code = consTpszDry;                
			break;
		case "R":
			comboObjects[0].Code = consTpszRfr;
			break;
		case "O":
			comboObjects[0].Code = consTpszOt;
			break;
		case "F":
			comboObjects[0].Code = consTpszFr;
			break;
		}
	}
	
	/**
	 * 설  명 : Location(COM_ENS_051) 공통 팝업의 결과로 호출되는 함수  <br>
	 * <br><b>Example : </b>
	 * <pre>
	 * 		공통팝업 호출시 function명 정의.
	 * 		ComOpenPopup('/opuscntr/COM_ENS_051.do', 770, 410, 'setOrgLoc', display);
	 * </pre>
	 * @param {Array}	rowArray - 결과값
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setOrgLoc(rowArray) {
		var colArray = rowArray[0];
		formObject.org_loc.value = colArray[3];
		formObject.dest_loc.focus();	
	}
	
	/**
	 * 설  명 : Location(COM_ENS_051) 공통 팝업의 결과로 호출되는 함수  <br>
	 * <br><b>Example : </b>
	 * <pre>
	 * 		공통팝업 호출시 function명 정의.
	 * 		ComOpenPopup('/opuscntr/COM_ENS_051.do', 770, 410, 'setDestLoc', display);
	 * </pre>
	 * @param {Array}	rowArray - 결과값
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setDestLoc(rowArray) {
		var colArray = rowArray[0];
		formObject.dest_loc.value = colArray[3];	
	}
	
	/**
	 * 설  명 : 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     validateForm(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH:
				if( !ComIsEmpty(formObj.date_kind) ) {
					var diffDay = ComGetDaysBetween(formObject.fm_dt, formObject.to_dt);
				
					if( ComIsEmpty(formObj.fm_dt) ) {
						ComShowCodeMessage('EQR90191','Date') ;
						formObj.fm_dt.focus() ;
						return false ;
					}
					if( ComIsEmpty(formObj.to_dt) ) {
						ComShowCodeMessage('EQR90191','Date') ;
						formObj.to_dt.focus() ;
						return false ;
					}
					if(diffDay > 183 ){
						ComShowCodeMessage('COM12133','Between Days','183 days','lesser') ;
						formObj.to_dt.value = "";
						formObj.to_dt.focus() ;
						return false ;
					}
				} else {
					ComShowCodeMessage('COM12113', 'date') ;
					formObj.date_kind.focus() ;
					return false;
				}
				break;
			
			default:
				return false;
				break;
			}
		return true;
	}
	
	/**
	 * 설  명 : 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnClick(sheetObj, Row, Col, Val)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {Long}	Row  - 해당 셀의 Row Index
	 * @param {Long}	Col  - 해당 셀의 Column Index
	 * @param {String}	Val  - 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Val) {
		sheetObj.SelectHighLight = true;
	}
	
	/**
	 * 설  명 : Gubun Value 구하기 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     gubunValue()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01 
	 * @return gubunValue
	 */
	function gubunValue() {
		var gubunValue = null;
		formObject = document.form;
		
		for(i=0; i <formObject.gubun.length; i++){
			if(formObject.gubun[i].checked){
				gubunValue = formObject.gubun[i].value;
			}
		}
		return gubunValue;
	}
	
	/**
	 * 설  명 : Radio Button 클릭시 점선 없애기 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     calToDate()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function bluring() { 
		if(event.srcElement.type=="radio") {
			document.body.focus(); 
		}
	}
	
	/**
	 * 설  명 : Form Object Event - Blur <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     form_blur()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function form_blur(){
		srcName = window.event.srcElement.getAttribute("name");
		if ( srcName == "fm_dt"){
			formObject.fm_dt.value = ComGetMaskedValue(formObject.fm_dt.value, "ymd");
		}
		if ( srcName == "to_dt"){
			formObject.to_dt.value = ComGetMaskedValue(formObject.to_dt.value, "ymd");
		}
	}

	/** 
	 * 설  명 : Form Object Event - KeyUp <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     form_keyup()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function form_keyup() {
		srcName = window.event.srcElement.getAttribute("name");
		var obj = null;
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
		if (keyValue == 229 ) { // 마우스 선택시
			if(srcName == "fm_dt" ){
				formObject.fm_dt.value = delete_Char(formObject.fm_dt.value,'-');
			} else if(srcName == "to_dt" ){
				formObject.to_dt.value = delete_Char(formObject.to_dt.value,'-');
			}
		} else {
			if(srcName == "fm_dt" ){
				var tmp = delete_Char(formObject.fm_dt.value,'-');
	    		if ( tmp.length == 8){
	    			formObject.fm_dt.value = ComGetMaskedValue(formObject.fm_dt.value, "ymd");
	    			if( keyValue == 229){
	    				formObject.fm_dt.value = delete_Char(formObject.fm_dt.value,'-');
	    				return;
	    			}
		    		if ( formObject.fm_dt.value.length == 10){
		    			formObject.to_dt.focus();
		    		}
	    		}
			}
			if(srcName == "to_dt" ){
				var tmp = delete_Char(formObject.to_dt.value,'-');
	    		if ( tmp.length == 8){
	    			formObject.to_dt.value = ComGetMaskedValue(formObject.to_dt.value, "ymd");
	    		}
			}
			if(srcName == "dest_loc" || srcName == "org_loc" ){
				upperCase_Num();
			}
		}
	}

	/**
	 * 설  명 : Form Object의 Change Event <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     form_change()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function form_change(){
	  	var srcName = window.event.srcElement.getAttribute("name");
	   	
	   	if ( srcName == "location"){
	   		displayType();
	   	}
	   	if ( srcName == "cntrTpsz"){
	   		var index = formObject.cntrTpsz.selectedIndex;
	   		tpszChange(formObject.cntrTpsz.options[index].value);
	   	}
	}
	
	/**
	 * 설  명 : Form Object Event - BeforeDeactivate <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     obj_beforedeactivate()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function obj_beforedeactivate() {
		srcName = window.event.srcElement.getAttribute("name");
		ComClearSeparator(event.srcElement);
	}
	
	/**
	 * 설  명 : Form Object Event - BeforeActivate <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     obj_beforeactivate()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function obj_beforeactivate() {
		srcName = window.event.srcElement.getAttribute("name");
		if ( srcName == "fm_dt"){
			formObject.fm_dt.value = ComGetMaskedValue(formObject.fm_dt.value, "ymd");
			ComClearSeparator(event.srcElement);
			ComSetFocus(event.srcElement);
		}
		if ( srcName == "to_dt"){
			formObject.to_dt.value = ComGetMaskedValue(formObject.to_dt.value, "ymd");
			ComClearSeparator(event.srcElement);
			ComSetFocus(event.srcElement);
		}
	}
	
	/**
	 * 설  명 :페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initControl() {
		axon_event.addListenerForm	('blur',			'form_blur',			formObject);
		axon_event.addListenerFormat('keyup',			'form_keyup',			form);
		axon_event.addListenerForm	('change',			'form_change',			formObject);
		axon_event.addListenerFormat('beforedeactivate','obj_beforedeactivate',	form);
		axon_event.addListenerFormat('beforeactivate',	'obj_beforeactivate',	form);
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}
	 
	 /**
	  * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
	  * 
	  * @param {sheetObj}
	  *            String : 해당 IBSheet셀 명
	  * @param {Row}
	  *            Long : 해당 셀의 Row Index
	  * @param {Col}
	  *            Long : 해당 셀의 Column Index
	  * @param {Value}
	  *            String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	  * @param {CellX}
	  *            Long : 해당셀의 X좌표
	  * @param {CellY}
	  *            Long : 해당셀의 Y좌표
	  * @param {CellW}
	  *            Long : 해당셀의 가로 넓이값
	  * @param {CellH}
	  *            Long : 해당셀의 세로 높이값
	  */
	 function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
		if(Col > 1){
			ComOpenWait(true);
			with(sheetObj){
				var dest1 = CellValue(Row, "dest1");
				var dest2 = CellValue(Row, "dest2");
				var tpsz = CellValue(0, Col);
				var gubun = gubunValue();
			}
			sheetObjects[1].LoadSearchXml(detailXml);
			
			//Summury 시트에서 선택한 정보의 Detail 내역을 선택하여 XML 생성
			if(dest1 != "Total"){
				if(dest2 != "Total"){
					if(tpsz != "Total"){
						var startRow =  sheetObjects[1].FindText("gubun", dest1+dest2+tpsz, 0, 0, false);
					}else{
						var startRow =  sheetObjects[1].FindText("gubun", dest1+dest2, 0, 0, false);
					}					
				}else{
					if(tpsz != "Total"){
						var startRow =  sheetObjects[1].FindText("gubun", dest1+"ZZZZZ"+tpsz, 0, 0, false);
					}else{
						var startRow =  sheetObjects[1].FindText("gubun", dest1, 0, 0, false);
					}					
				}			
			}else{
				if(dest2 != "G.Total"){
					if(tpsz != "Total"){
						var startRow =  sheetObjects[1].FindText("gubun", "ZZZZZ"+dest2+tpsz, 1, 0, false);
					}else{
						var startRow =  sheetObjects[1].FindText("gubun", "ZZZZZ"+dest2, 1, 0, false);
					}
				}else{
					if(tpsz != "Total"){
						var startRow =  sheetObjects[1].FindText("gubun", "ZZZZZZZZZZ"+tpsz, 1, 0, false);
					}else{
						var startRow =  sheetObjects[1].FindText("gubun", "ZZZZZZZZZZ", 1, 0, false);
					} 
				}
			}
			var endRow = startRow + parseInt(sheetObj.CellValue(Row, Col));
			for (var i = startRow; i< endRow; i++){
				sheetObjects[1].CellValue(i, "check") = 1;
			}
	
			popUpXml = ComMakeSearchXml(sheetObjects[1], false, "check", "eq_no");
			ComOpenWait(false);
			
			var param = "?dest1=" + dest1 + "&dest2=" + dest2 + "&tpsz=" + tpsz + "&gubun=" + gubun +"&opn_scr=1059";
			ComOpenPopup('/opuscntr/EES_EQR_1060.do'+param, 400, 500, '', '0,1', true);
		}
	}
	 
	/**
	 * 설  명 : 팝업 페이지(EES_EQR_1060)에서 호출하여 Detail 정보를 담고 있는 detailXml을 리턴한다. <br>
	 * 
	 * @see #링크연결
	 * @author 나상보
	 * @version 2011.06.22
	 */
	function setPopUpXml(){
		 return popUpXml;
	 }
	
	
	 
	/* 개발자 작업  끝 */