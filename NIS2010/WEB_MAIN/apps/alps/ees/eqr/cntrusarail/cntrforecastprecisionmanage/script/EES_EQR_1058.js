/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1058.js
*@FileTitle : MTY Rail Arrival Inquiry
*Open Issues :
*Change history :
** No.   Ver.    Modifier         modifier date    explanation
* 1      1.1     chae Chang ho    2010-04-13       FormQueryString 사용금지로 eqrFormQryStr으로 대체
*@LastModifyDate : 2009.10.07
*@LastModifier : 이행지
*@LastVersion : 1.0
*
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
     * @author 한진해운
     */

    /**
     * @extends 
     * @class EES_EQR_1058 : EES_EQR_1058 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1058() { 
    	this.processButtonClick		= tprocessButtonClick;
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
	var gubun = null;
	
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
		srcName = window.event.srcElement.getAttribute("name");
		
		try {	
			switch(srcName) {
				case "btn_retrieve":
					sheetObject.RemoveAll();
					if(validateForm(sheetObject,formObject,IBSEARCH)){
						initSheet(sheetObject,1,'Y');
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
					}
					break;
				
				case "btn_new": 
					sheetObject.RemoveAll();
					//formObject.fm_dt.value = "";
					//formObject.to_dt.value = "";
					formObject.org_loc.value = "";
					formObject.dest_loc.value = "";
					tpszChange('');
					gubun = "A";
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
					var cal = new ComCalendar();
	 	    		cal.select(formObject.fm_dt, "yyyy-MM-dd");
                    break;
				
				case "btn_orgloc":
                	var display 	  = '1,0,1,1,0,1,1,1,1,0,1,1';
  				    ComOpenPopup('/hanjin/COM_ENS_051.do', 770, 410, 'setOrgLoc', display);
  				    break;
    
				case "btn_destloc":
                	var display 	  = '1,0,1,1,0,1,1,1,1,0,1,1';
                	ComOpenPopup('/hanjin/COM_ENS_051.do', 770, 410, 'setDestLoc', display);
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
			initSheet(sheetObjects[i],i+1, "N");
			ComEndConfigSheet(sheetObjects[i]);   //khlee-마지막 환경 설정 함수 추가
		}
		for(p=0;p< comboObjects.length;p++){
			initCombo (comboObjects[p],p+1);
		}
		formObject.diff_date.value = "0";
		
		gubun = "A";
		for(i=0; i <formObject.gubun.length; i++){
			if(formObject.gubun[i].checked){
				gubun = formObject.gubun[i].value;
			}
		}
		
		tpszChange('');		// TP/SZ ALL로 초기화
        initControl();
        if(formObject.fm_dt.value != null){
        	calToDate();
        }
        // 2010.02.09 남연호과장님의 추가 사항 요청으로 화면 오픈시
        // 자동 조회가 되도록 변경
        sheetObject.RemoveAll();
		if(validateForm(sheetObject,formObject,IBSEARCH)){
			initSheet(sheetObject,1,'Y');
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
		}
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
	function initSheet(sheetObj,sheetNo, flag) {
		var cnt = 0;
		var sDate = formObject.fm_dt.value;
		var eDate = formObject.to_dt.value;
		var diffDay = 0;
		var i = 0;		
		if(flag == "Y"){
			diffDay = ComGetDaysBetween(formObject.fm_dt, formObject.to_dt);
			formObject.diff_date.value = diffDay;
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
				MergeSheet = msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 1, 100);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				totalCols = 4 + (2 * (diffDay + 1));
				InitColumnInfo(totalCols, 4, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, false, true, false,false)
				
				var titleText = (gubun =="A" || gubun == null) ? "Dest.Loc.|Dest.Yard|TP/SZ|" : "Dest.Yard.|Org.Yard|TP/SZ|";
				var HeadTitle = titleText;
				var HeadTitle2 = titleText;
				for( i=0; i <= diffDay; i++ ){
				if(flag == "Y")
					HeadTitle += "|" +calc_Date(sDate,i,true);
					HeadTitle += "|" +calc_Date(sDate,i,true);
					HeadTitle2 += "|" + "TTL";
					HeadTitle2 += "|" + "Arrived";
 				}
				
				
				
				var dateWidth = eval(( SheetWidth - ( 60+65+40) ) / 16);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle+"|", true);
				InitHeadRow(1, HeadTitle2+"|", true);
				
				//데이터속성    [ROW, COL,  DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,		60,		daCenter, true,    "dest1",		false,		"",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++, dtData,		65,		daCenter, true,    "dest2",		false,		"",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++, dtData,		40,		daCenter, true,   "tpsz",		false,		"",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++, dtHidden,	50,		daCenter, true,   "gubun",		false,		"",       dfNone,       0,     false,       false);
				for( i=0; i <= diffDay; i++ ){
					InitDataProperty(0, cnt++ , dtData,	dateWidth-5,	daCenter, false,"day_"+i  ,       false,          "",       dfNone,       0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,	dateWidth+4,	daCenter, false,"day_"+i+"_mt"  ,       false,          "",       dfNone,       0,     false,       false);
				}
				HeadRowHeight= 20;
				
				SelectHighLight = false;
				ExtendLastCol = false;

			}
			sheetObj.AutoSumBottom = false;
			sheetObj.RowMerge(0) = true;
			sheetObj.RowMerge(1) = true;
			
			
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
				InitColumnInfo(5, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, true, false, false, false);
				
				var HeadTitle = "chk||CNTR No.|MT";
									
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDummyCheck,    120,    daCenter, true,    "check"       ,       false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,   	 300,    daCenter, true,    "gubun"       ,       false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,     	 120,    daCenter, true,    "eq_no"       ,       false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,     	 120,    daCenter, true,    "mt"       ,       false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,     	 120,    daCenter, true,    "mvmt_sts_cd"       ,       false,          "",       dfNone,       0,     false,       false);
				
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
				var sXml = sheetObj.GetSearchXml("EES_EQR_1058GS.do", eqrFormQryStr(formObj));
				sheetObj.LoadSearchXml(sXml);
				formObj.f_cmd.value = SEARCH01 ;
				detailXml = sheetObj.GetSearchXml("EES_EQR_1058GS.do", eqrFormQryStr(formObj));
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
	 * @param {object}	sheet_obj - Sheet Object
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
	 * 		ComOpenPopup('/hanjin/COM_ENS_051.do', 770, 410, 'setOrgLoc', display);
	 * </pre>
	 * @param {Array}	rowArray - 결과값
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setOrgLoc(rowArray) {
		var colArray = rowArray[0];
		document.form.org_loc.value = colArray[3];
		document.form.dest_loc.focus();	
	}
	
	/**
	 * 설  명 : Location(COM_ENS_051) 공통 팝업의 결과로 호출되는 함수  <br>
	 * <br><b>Example : </b>
	 * <pre>
	 * 		공통팝업 호출시 function명 정의.
	 * 		ComOpenPopup('/hanjin/COM_ENS_051.do', 770, 410, 'setDestLoc', display);
	 * </pre>
	 * @param {Array}	rowArray - 결과값
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setDestLoc(rowArray) {
		var colArray = rowArray[0];
		document.form.dest_loc.value = colArray[3];	
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
		var diffDay = ComGetDaysBetween(formObj.fm_dt, formObj.to_dt);
		switch (sAction) {
			case IBSEARCH:
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
				if( diffDay < 0 ) {
					ComShowCodeMessage('COM12133','End date','start date','greater') ;
					formObj.fm_dt.value = "";
					formObj.to_dt.value = "";
					formObj.fm_dt.focus() ;
					return false ;
				}
				if ( diffDay > 7 ){
					ComShowCodeMessage('EQR90228'); // Date period is over seven days. please reselect date.
				}
				break;
			default:
				return false;
				break;
		}
		return true;
	}
	
	/**
	 * 설  명 : 조회 함수를 이용하여 조회가 완료되고 발생하는 이벤트 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSearchEnd(sheetObj, errMsg)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {String}	errMsg  - 조회 후 메시지
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var totalRange = sheetObj.GetColSameDataRange(sheetObj.LastRow-1,0).split('|');
		var firstPoint = totalRange[0];
		var size = eval(totalRange[1]) - eval(totalRange[0])+1;

		sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 3);

		/* 세로머지 되면서 가로머지는 아직 확정적으로 지원되는 사항이 아니라서 사용하지 않기로 함. 
		if( sheetObj.RowCount > 1){
			//sheetObj.SetMergeCell (firstPoint,0,1,2);
			sheetObj.SetMergeCell (firstPoint,0,size,2);
		}
		*/

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
		if(Col > 3){
			ComOpenWait(true);
			with(sheetObj){
				var dest1 = CellValue(Row, "dest1");
				var dest2 = CellValue(Row, "dest2");
				var tpsz = CellValue(Row, "tpsz");
				var etaDt = ComGetUnMaskedValue(CellValue(0, Col), "ymd");
				var detail = CellValue(Row, "gubun");
			}
			sheetObjects[1].LoadSearchXml(detailXml);
			
			//Summury 시트에서 선택한 정보의 Detail 내역을 선택하여 XML 생성
			if(dest1 != "Total"){
				if(dest2 != "Total"){
					if(tpsz == "G.Total"){
						var startRow =  sheetObjects[1].FindText("gubun", etaDt+"ZZZZZZZZZZZZ", 0, 0, false);
					}else if(tpsz != "Total"){
						var startRow =  sheetObjects[1].FindText("gubun", etaDt+dest1+dest2+tpsz, 0, 0, false);
					}else{
						var startRow =  sheetObjects[1].FindText("gubun", etaDt+dest1+dest2, 0, 0, false);
					}					
				}else{
					if(tpsz != "Total"){
						var startRow =  sheetObjects[1].FindText("gubun", etaDt+dest1+"ZZZZZZZ"+tpsz, 0, 0, false);
					}else{
						var startRow =  sheetObjects[1].FindText("gubun", etaDt+dest1, 0, 0, false);
					}					
				}				
			}else{
				var startRow =  sheetObjects[1].FindText("gubun", etaDt+"ZZZZZZZZZZZZ"+tpsz, 0, 0, false);
			} 

			var endRow = startRow + parseInt(sheetObj.CellValue(Row, Col));
			for (var i = startRow; i< endRow; i++){
				sheetObjects[1].CellValue(i, "check") = 1;
			}
	
			popUpXml = ComMakeSearchXml(sheetObjects[1], false, "check", "eq_no|mvmt_sts_cd");
			ComOpenWait(false);
			
			var param = "?dest1=" + dest1 + "&dest2=" + dest2 + "&tpsz=" + tpsz + "&eta_dt=" + etaDt + "&gubun=" + gubun + "&opn_scr=1058";
			ComOpenPopup('/hanjin/EES_EQR_1060.do'+param, 400, 500, '', '0,1', true);
		}
	}	 
	
	function changeCheckBox(ch_gubun){
		if(gubun != ch_gubun){
			gubun = ch_gubun;
		}
	}
	
	/**
	 * 설  명 : To Date = From Date + 7  <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     calToDate()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function calToDate(){
		var to_dt = calc_Date(formObject.fm_dt.value,7,true);
		
		if (formObject.fm_dt.value != "" && to_dt == "") {
			ComShowCodeMessage('EQR90222','YYYY-MM-DD');
			formObject.fm_dt.value = "";
			formObject.to_dt.value = "";
			formObject.fm_dt.focus();
			return false;
		} else {
			formObject.to_dt.value = to_dt;
		}
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

    	if(srcName == "fm_dt" && formObject.fm_dt.value.length == 10){
    		calToDate();
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
			if (formObject.fm_dt.value.length == 10){
				calToDate();
			}
		}
	}
	
	/**
	 * 설  명 : Form Object Event - Focusin <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     form_blur()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function form_focusin(){
    	if(srcName == "fm_dt"){
    		var tmp = delete_Char(formObject.fm_dt.value,'-');
    		if ( tmp.length == 8){
    			calToDate();
    		}
    	}
		if(srcName == "btns_calendar"){
    		calToDate();
    	}
	}
	
	/**
	 * 설  명 : Form Object Event - Click <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     form_click()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function form_click(){
	  	srcName = window.event.srcElement.getAttribute("name");
    	if(srcName == "gubun"){
    		var radioCnt = formObject.gubun.length;
	   		var checkValue = null;

	   		for ( var i=0; i < radioCnt; i++ ){
	   			if ( formObject.gubun[i].checked == true ){
	   				checkValue = formObject.gubun[i].value;
	   				changeCheckBox(checkValue);
	   			}
	   		}
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
		if (keyValue == 13 ) {
		} else {
			if(srcName == "fm_dt" ){
				var tmp = delete_Char(formObject.fm_dt.value,'-');
	    		if ( tmp.length == 8){
	    			formObject.fm_dt.value = ComGetMaskedValue(formObject.fm_dt.value, "ymd");
	    			calToDate();
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
	 *     form_blur()
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
	 *     form_blur()
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
	}
	/**
	 * 설  명 :페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initControl() {
		axon_event.addListenerForm	('blur',			'form_blur',			formObject); //- 클릭시
		axon_event.addListenerForm	('focusin',			'form_focusin',			formObject); //- 클릭시
		axon_event.addListenerForm	('click',			'form_click',			formObject); //- 클릭시
		axon_event.addListenerForm	('change',			'form_change',			formObject); //- 클릭시
		axon_event.addListenerFormat('keyup',			'form_keyup',			form);
		axon_event.addListenerFormat('beforedeactivate','obj_beforedeactivate',	form);
		axon_event.addListenerFormat('beforeactivate',	'obj_beforeactivate',	form);
		// 화면 어디에서나 enterkey를 누르면 조회가 되도록 하는 설정  
		axon_event.addListener      ('keydown',         'ComKeyEnter'        , 'form');
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