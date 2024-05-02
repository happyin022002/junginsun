/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0008.js
*@FileTitle : Capital Budgeting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.07.06 정윤태
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* 2011.02.11 이준범 [CHM-201108853-01]
* 제목 : ALPS FMS Capital Budgeting Excel Download 관련
* 보완 : Hidden Sheet3를 생성하여, Sheet1와 Sheet2를  Sheet3으로 Merge 하여 Excel Download 하도록 처리
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
     * @class ESM_FMS_0008 : ESM_FMS_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0008() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 	= setSheetObject;
    	this.loadPage 			= loadPage;
    	this.initSheet 			= initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 	= doActionIBSheet;
    	this.setTabObject 		= setTabObject;
    	this.validateForm 		= validateForm;
        this.eng_keypress		= eng_keypress;
        this.vsl_cd_change		= vsl_cd_change;
        this.obj_deactivate		= obj_deactivate;
        this.obj_activate		= obj_activate;
        this.obj_keypress		= obj_keypress;
        this.setVslCd			= setVslCd;
        this.controlScrollBar	= controlScrollBar;
        this.durationReadonly   = durationReadonly;
        this.formReset			= formReset;
        this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
        this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
        this.setInitCellProperty= setInitCellProperty;
    }

    // 공통전역변수
	
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
	
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var rdObjects = new Array();
    var rdCnt = 0;
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObject = sheetObjects[0];
	 	var sheetObject1 = sheetObjects[1];
	 	var sheetObject2 = sheetObjects[2];
	
	 	/*******************************************************/
	  	var formObject = document.form;
	
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	
	     	switch(srcName) {
	 			case "btn_retrieve":
	 				doActionIBSheet(sheetObject,formObject,IBSEARCH);
	             	break;
	
	 			case "btn_new":
	 				formReset();
	             	break;
	
	 			case "btn_savetofile":
	 				sheetObject2.SpeedDown2Excel(-1);	 				
	             	break;
	
	 			case "btn_print":
	 				rdOpen(rdObjects[0], document.form);
	             	break;
	             	
	 			case "ef_dt": 
					var cal = new ComCalendar();
					cal.select(form.eff_dt, 'yyyy-MM-dd');
					break;
				 
	 			case "ex_dt": 
					var cal = new ComCalendar();
					cal.select(form.exp_dt, 'yyyy-MM-dd');
					break;
				 
	 			case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0022");
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
	 	for(i=0;i<sheetObjects.length;i++){
	
	 		//khlee-시작 환경 설정 함수 이름 변경
	     	ComConfigSheet (sheetObjects[i] );
	
	     	initSheet(sheetObjects[i],i+1);
	 		//khlee-마지막 환경 설정 함수 추가
	     	ComEndConfigSheet(sheetObjects[i]);
	 	}
	
	 	for(k=0;k<tabObjects.length;k++){
	     	initTab(tabObjects[k],k+1);
	 	}
	 	
	 	//html컨트롤 이벤트초기화
        initControl();
	 	
	 	sheetObjects[0].ExtendLastCol = false;
    	sheetObjects[1].ExtendLastCol = false;
    	//sheetObjects[2].ExtendLastCol = false;
	 	
	 	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	 	//doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    	
    	//RD
		initRdConfig(rdObjects[0]);
	}
	
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
	 	var cnt = 0;
	 	var sheetID = sheetObj.id;
	 	switch(sheetID) {
	     	case "sheet1":
	         	with (sheetObj) {
	
	             	// 높이 설정
	             	style.height = 340;
	             	//전체 너비 설정
	             	SheetWidth = mainTable.clientWidth;
	             	
	             	//Host정보 설정[필수][HostIp, Port, PagePath]
	             	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	             	
	             	//전체Merge 종류 [선택, Default msNone]
	             	MergeSheet = msHeaderOnly;
	             	
	            	//전체Edit 허용 여부 [선택, Default false]
	             	Editable = false;
	             	
	             	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	             	InitRowInfo( 2, 1, 3, 100);
	             	
	             	// 해더에서 처리할 수 있는 각종 기능을 설정한다
	             	InitHeadMode(true, true, false, true, false, false)
	             	
	             	var HeadTitle1 = "Installment\nDate|Vessel\nCode|Vessel Full Name|Withdrawal From SML|Withdrawal From SML|Withdrawal From SML|Withdrawal From SML|Receipt From Charterer|Receipt From Charterer|Receipt From Charterer|Receipt From Charterer";
	             	var HeadTitle2 = "Installment\nDate|Vessel\nCode|Vessel Full Name|Cur 1|Amount|Cur 2|Amount|Cur 1|Amount|Cur 2|Amount";
	             	
	             	var headCount = ComCountHeadTitle(HeadTitle1);
	             	
	             	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	             	InitColumnInfo(headCount, 0, 0, true);
	             	
	             	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	             	InitHeadRow(0, HeadTitle1, true);
	             	InitHeadRow(1, HeadTitle2, true);
	             	
	             	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	             	InitDataProperty(0, cnt++ , dtData,      85,	daCenter,  	true,     	"eff_dt",     		false,          "",      dfDateYmd,   	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      50,	daCenter,  	true,     	"vsl_cd",      		false,          "",      dfNone,      	0,     false,       true);
	             	
	 				InitDataProperty(0, cnt++ , dtData,      173, 	daLeft,  	true,     	"vsl_eng_nm",		false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,     	"ti_curr_cd",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"ti_inv_amt",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,   	"ti_curr_cd2",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"ti_inv_amt2",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 				
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,     	"to_curr_cd",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"to_inv_amt",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,     	"to_curr_cd2",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"to_inv_amt2",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 			}
	         	break;
	
	      	case "sheet2":
	         	with (sheetObj) {
	         		//높이 설정
	             	//style.height = 42;
	         		style.height = 0;
	             		
	         		//전체 너비 설정
	             	SheetWidth = mainTable.clientWidth;
	             		
	             	//Host정보 설정[필수][HostIp, Port, PagePath]
	             	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	             		
	             	//전체Merge 종류 [선택, Default msNone]
	             	MergeSheet = msHeaderOnly;
	             		
	            	//전체Edit 허용 여부 [선택, Default false]
	             	Editable = false;
	             		
	             	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	             	InitRowInfo(1, 1, 3, 100);
	             		
	             	// 해더에서 처리할 수 있는 각종 기능을 설정한다
	             	InitHeadMode(false, true, false, true, false, false);
	             		
	             	var HeadTitle1 = "Installment\nDate|Vessel\nCode|Vessel Full Name|Withdrawal From SML|Withdrawal From SML|Withdrawal From SML|Withdrawal From SML|Receipt From Charterer|Receipt From Charterer|Receipt From Charterer|Receipt From Charterer";
	             	var headCount = ComCountHeadTitle(HeadTitle1);
	             	
	             	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	             	InitColumnInfo(headCount, 0, 0, true);
	             		
	             	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	             	InitHeadRow(0, HeadTitle1, true, true);
	             		
	             	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	             	InitDataProperty(0, cnt++ , dtData,      85,	daCenter,  	true,     	"eff_dt",     		false,          "",      dfDateYmd,   	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      50,	daCenter,  	true,     	"vsl_cd",      		false,          "",      dfNone,      	0,     false,       true);
	
	 				InitDataProperty(0, cnt++ , dtData,      173, 	daLeft,  	true,     	"vsl_eng_nm",		false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,     	"ti_curr_cd",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"ti_inv_amt",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,   	"ti_curr_cd2",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"ti_inv_amt2",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 			
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,     	"to_curr_cd",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"to_inv_amt",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,     	"to_curr_cd2",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"to_inv_amt2",     	false,          "",      dfNullFloat, 	2,     false,       true);

	 				SetSortDialog(false);
	 				CountPosition = 0;
	 				FocusAfterProcess = false;
	 			}
	         	break;
	         	
	      	case "sheet3":
	         	with (sheetObj) {
	             	// 높이 설정
	             	style.height = 0;
	             	//전체 너비 설정
	             	SheetWidth = mainTable.clientWidth;
	             	
	             	//Host정보 설정[필수][HostIp, Port, PagePath]
	             	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	             	
	             	//전체Merge 종류 [선택, Default msNone]
	             	MergeSheet = msHeaderOnly;
	             	
	            	//전체Edit 허용 여부 [선택, Default false]
	             	Editable = false;
	             	
	             	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	             	InitRowInfo( 2, 1, 3, 100);
	             	
	             	// 해더에서 처리할 수 있는 각종 기능을 설정한다
	             	InitHeadMode(true, true, false, true, false, false)
	             	
	             	var HeadTitle1 = "Installment\nDate|Vessel\nCode|Vessel Full Name|Withdrawal From SML|Withdrawal From SML|Withdrawal From SML|Withdrawal From SML|Receipt From Charterer|Receipt From Charterer|Receipt From Charterer|Receipt From Charterer";
	             	var HeadTitle2 = "Installment\nDate|Vessel\nCode|Vessel Full Name|Cur 1|Amount|Cur 2|Amount|Cur 1|Amount|Cur 2|Amount";
	             	
	             	var headCount = ComCountHeadTitle(HeadTitle1);
	             	
	             	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	             	InitColumnInfo(headCount, 0, 0, true);
	             	
	             	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	             	InitHeadRow(0, HeadTitle1, true);
	             	InitHeadRow(1, HeadTitle2, true);
	             	
	             	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	             	InitDataProperty(0, cnt++ , dtData,      85,	daCenter,  	true,     	"eff_dt",     		false,          "",      dfDateYmd,   	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      50,	daCenter,  	true,     	"vsl_cd",      		false,          "",      dfNone,      	0,     false,       true);
	             	
	 				InitDataProperty(0, cnt++ , dtData,      173, 	daLeft,  	true,     	"vsl_eng_nm",		false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,     	"ti_curr_cd",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"ti_inv_amt",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,   	"ti_curr_cd2",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"ti_inv_amt2",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 				
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,     	"to_curr_cd",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"to_inv_amt",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      40,  	daCenter,  	false,     	"to_curr_cd2",     	false,          "",      dfNone,      	0,     false,       true);
	 				InitDataProperty(0, cnt++ , dtData,      124,  	daRight,   	false,     	"to_inv_amt2",     	false,          "",      dfNullFloat, 	2,     false,       true);
	 			}
	         	break;	         	
	 		}
	}
	
	/**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
	function doActionIBSheet(sheetObj,formObj,sAction,gubun) {
	 	sheetObj.ShowDebugMsg = false;
	 	switch(sAction) {
	 	
	   		case IBSEARCH:      //조회
	   		
	   			if(!validateForm(sheetObj,formObj,sAction))  return true;

	   			formObj.f_cmd.value = SEARCH;
	   			
	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0008GS.do" , FormQueryString(formObj));

    			var arrXml = sXml.split("|$$|");	
				
				if (arrXml.length > 0) {
 	   	  			
					sheetObjects[0].LoadSearchXml(arrXml[0]);
 	   	  			sheetObjects[1].RemoveAll();
 	   	  			sheetObjects[1].LoadSearchXml(arrXml[1]);
 	   	  			var total = ComFmsGetAttr(arrXml[1], "DATA", "TOTAL");
 	   	  			if(total > 0) {
 	   	  				sheetObjects[1].style.height = 20 + (total * 20);
     	  			} else {
 	   	  				sheetObjects[1].style.height = 0;
 	   	  			}
 	   	  			sheetObjects[2].RemoveAll();
 	   	  			sheetObjects[2].LoadSearchXml(arrXml[0]);
 	   	  		    
 	   	  		    var sheet3_row = sheetObjects[0].LastRow;	   	  		     	   	  		 
 	   	  		    
 	   	  			for( var row=1; row<=sheetObjects[1].LastRow; row++ ) {

 	   	  				var iRow = sheet3_row + row; 	   	  				
 	   	  				sheetObjects[2].DataInsert(-1);
 	   	  				if ( row == 1 ) {
 	   	  					sheetObjects[2].CellText(iRow, "eff_dt") = "Total Amount";
 	   	  				} else {
 	   	  				    sheetObjects[2].CellText(iRow, "eff_dt") = ""; 
 	   	  				}
 	   	  			    
 	   	  				sheetObjects[2].CellValue2(iRow, "ti_curr_cd")  = sheetObjects[1].CellValue(row, "ti_curr_cd");
 	   	  				sheetObjects[2].CellValue2(iRow, "ti_inv_amt")  = sheetObjects[1].CellValue(row, "ti_inv_amt");
 	   	  				sheetObjects[2].CellValue2(iRow, "ti_curr_cd2") = sheetObjects[1].CellValue(row, "ti_curr_cd2");
 	   	  				sheetObjects[2].CellValue2(iRow, "ti_inv_amt2") = sheetObjects[1].CellValue(row, "ti_inv_amt2");
 	   	  			    sheetObjects[2].CellValue2(iRow, "to_curr_cd")  = sheetObjects[1].CellValue(row, "to_curr_cd");
 	   	  			    sheetObjects[2].CellValue2(iRow, "to_inv_amt")  = sheetObjects[1].CellValue(row, "to_inv_amt");
 	   	  			    sheetObjects[2].CellValue2(iRow, "to_curr_cd2") = sheetObjects[1].CellValue(row, "to_curr_cd2");
 	   	  			    sheetObjects[2].CellValue2(iRow, "to_inv_amt2") = sheetObjects[1].CellValue(row, "to_inv_amt2"); 	   	  			    
			        }
 	   	  			
 	   	  			controlScrollBar();
 	   	  		} else {
 	   	  			sheetObjects[1].style.height = 0;
 	   	  		}
				
				//durationReadonly();

	         	break;
	 		
	 		case IBROWSEARCH:      //조회
	 			if(gubun == "Vessel") {
			    	if(formObj.vsl_cd.value == "") {
			    		formObj.vsl_eng_nm.value = "";
			    		return;
			    	}
			    	
			    	formObj.f_cmd.value = SEARCH01;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
		   			
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
		   				//formObj.vsl_cd.readOnly = true;
		   				//formObj.btn_vslpop.style.cursor = "default";
		   				//document.images["btn_vslpop"].name = "no_btn_vslpop";
		   				
		   				document.body.focus();
		   				
					} else {
						formObj.vsl_cd.value = "";
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
						return;
					}
		   			
				}
	 			break;
	 	}
	}
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
    	
        //Axon 이벤트 처리1. 이벤트catch
    	//2010.11.24 이상민 [CHM-201007233-01] : vsl_cd 는 eng_keypress-> engnum_keypress로 변경
        axon_event.addListener  ('keypress', 'engnum_keypress', 'vsl_cd');
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');		  //Vessel Code 입력 후 Name정보 가져오기

        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    }
    
    //Axon 이벤트 처리2. 이벤트처리함수 --- start
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
     
     /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
    function engnum_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('uppernum');
    } 
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "shp_spd_qty": 
	    	case "vsl_dznd_capa": 
	    	case "bse_14ton_vsl_capa": 
	    	case "rf_cntr_plg_qty": 
	    	case "ddwt_cgo_capa_qty": 
	    	case "grs_wgt": 
	    	case "nrt_wgt":
	    	case "cust_seq":
	    		//숫자이면서 천단위 구분을 하지 않는다.
	    		//ComChkObjValid(obj, bMsg, bTrim, bMasked)
    			ComChkObjValid(event.srcElement, true, false, false);
    			break;

    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
    	//마스크구분자 없애기
    	ComClearSeparator(event.srcElement);
    }
     
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Vessel');
    }
     
    //Axon 이벤트 처리2. 이벤트처리함수 --- end
     
    /**
	  * Vessel Code 입력부분.<br>
	  * @param {arry} aryPopupData
	  */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
		
		form.vsl_cd.readOnly = true;
		form.btn_vslpop.style.cursor = "default";
		document.images["btn_vslpop"].name = "no_btn_vslpop";
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
	function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
        if(!ComChkValid(formObj)) return false;
    	
    	var lastDay = ComGetLastDay(formObj.eff_dt.value.substring(0,4), 2);
    	
    	var yearDay = 364;
    	
    	if(   parseInt(formObj.eff_dt.value.substring(5,7)) <= 2 
    	   && lastDay == 29) {
    		yearDay = 365;
    	}
    	//var yearDay = lastDay == 29 ? 365 : 364;

    	if(ComGetDaysBetween(formObj.eff_dt.value, formObj.exp_dt.value) > yearDay) {
    		ComAlertFocus(form.exp_dt, ComGetMsg('FMS01174'));
    		return false;
    	}
        
	 	return true;
	}
    
    /**
     * Duration 정보를 수정할 수 없도록한다. <br>
     * @return 없음
     **/
    function durationReadonly() {
    	form.ef_dt.style.cursor = "default";
		form.ex_dt.style.cursor = "default";
		document.images["ef_dt"].name = "no_ef_dt";
		document.images["ex_dt"].name = "no_ex_dt";
		
		form.eff_dt.className = "input2";
		form.exp_dt.className = "input2";
		
		form.eff_dt.readOnly = true;
		form.exp_dt.readOnly = true;
    }
	 	
 	/**
     * 화면을 초기화한다. <br>
     * @return 없음
     * @see #ComResetAll
     **/
	function formReset() {
		ComResetAll();
		
		//document.all.btn_creation.style.display = "";
    	//document.all.btn_save.style.display = "none";
    	//document.all.btn_delete.style.display = "none";
		
		form.ef_dt.style.cursor = "hand";
		form.ex_dt.style.cursor = "hand";
		document.images["ef_dt"].name = "ef_dt";
		document.images["ex_dt"].name = "ex_dt";
		
		form.eff_dt.className = "input1";
		form.exp_dt.className = "input1";
		
		form.eff_dt.readOnly = false;
		form.exp_dt.readOnly = false;
		
		sheetObjects[1].style.height = 0;
		controlScrollBar();
		
		form.vsl_cd.readOnly = false;
		form.btn_vslpop.style.cursor = "hand";
		document.images["btn_vslpop"].name = "btn_vslpop";

	}
     
    /**
     * 데이타 조회시 스크롤바를  자동으로 컨트롤한다 <br>
     **/
 	function controlScrollBar() {
 		try{
 			top.syncHeight()
 		} catch(err){ComFuncErrMsg(err.message);}
 	}
 	
 	/**
     * 
     * @param sheetObj
     * @param olTopRow
     * @param oldLeftCol
     * @param newTopRow
     * @param newLeftCol
     * @return
     */
    function sheet1_OnScroll(sheetObj, olTopRow, oldLeftCol, newTopRow, newLeftCol) {
    	sheetObjects[1].LeftCol = newLeftCol;
    }
    
    /**
     * 
     * @param sheetObj
     * @param olTopRow
     * @param oldLeftCol
     * @param newTopRow
     * @param newLeftCol
     * @return
     */
    function sheet2_OnScroll(sheetObj, olTopRow, oldLeftCol, newTopRow, newLeftCol) {
    	sheetObjects[0].LeftCol = newLeftCol;
    }
     
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
  		ComColFontName(sheetObj, "1"); 
  		
  		setInitCellProperty(sheetObj);
  	}
     
    /**
     * 
     * @param sheetObj
     * @param errMsg
     * @return
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
        for(var row=1; row<=sheetObj.LastRow; row++) {
            if(row == 1) {
     			sheetObj.CellText(row, "eff_dt") = "Total Amount";
     		} else {
     			sheetObj.CellText(row, "eff_dt") = "";
     		}
     		sheetObj.RowBackColor(row) = sheetObj.RgbColor(255,230,251); 
     		sheetObj.CellFont("FontBold", row, "eff_dt") = true;
     		//sheetObj.CellFont("FontBold", row, "flet_ctrt_tp_cd") = true;
     		//sheetObj.CellFont("FontBold", row, "ownr_nm") = true;
     		//sheetObj.CellFont("FontBold", row, "vsl_dznd_capa") = true;
     		sheetObj.CellFont("FontBold", row, "ti_curr_cd")  = true;
     		sheetObj.CellFont("FontBold", row, "ti_inv_amt")  = true;
     		sheetObj.CellFont("FontBold", row, "ti_curr_cd2") = true;
     		sheetObj.CellFont("FontBold", row, "ti_inv_amt2") = true;
     		sheetObj.CellFont("FontBold", row, "to_curr_cd")  = true;
     		sheetObj.CellFont("FontBold", row, "to_inv_amt")  = true;
     		sheetObj.CellFont("FontBold", row, "to_curr_cd2") = true;
     		sheetObj.CellFont("FontBold", row, "to_inv_amt2") = true;
        }
        
        ComColFontName(sheetObj, "1"); 
        
        setInitCellProperty(sheetObj);
    }
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     **/
    function setInitCellProperty(sheetObj) {
    	for(var ir=1; ir<=sheetObj.LastRow; ir++) {
			if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, "ti_curr_cd"))) {
				
				sheetObj.InitCellProperty(ir, 4, dtNull, daRight, "ti_inv_amt", "", dfNullInteger);
			}
			
			if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, "ti_curr_cd2"))) {
				
				sheetObj.InitCellProperty(ir, 6, dtNull, daRight, "ti_inv_amt2", "", dfNullInteger);
			}
			
			if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, "to_curr_cd"))) {
				
				sheetObj.InitCellProperty(ir, 8, dtNull, daRight, "to_inv_amt", "", dfNullInteger);
			}
			
			if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, "to_curr_cd2"))) {
				
				sheetObj.InitCellProperty(ir, 10, dtNull, daRight, "to_inv_amt2", "", dfNullInteger);
			}
		}
    }
     
    /**
  	 * 페이지에 있는 RD Object를 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
  	 * @param {rdObject} rdObject    RD Object
  	 **/
  	function initRdConfig(rdObject){
  	    var Rdviewer = rdObject ;
  	    Rdviewer.style.height = 0;
  	    Rdviewer.style.width = 0;
  	    
  	    Rdviewer.AutoAdjust = true;
  	    Rdviewer.ViewShowMode(0);

  		Rdviewer.setbackgroundcolor(128,128,128);
  		Rdviewer.SetPageLineColor(128,128,128);
  	}

	function rdOpen(rdObject, formObject){
		if(sheetObjects[0].RowCount == 0) {
			ComShowCodeMessage("FMS00015");
			return;
		}
		
		var Rdviewer = rdObject ;

		var usrId = form.usr_id.value;
		var effDt = form.eff_dt.value.replace(/-/g,"");
		var expDt = form.exp_dt.value.replace(/-/g,"");
		var vslCd = form.vsl_cd.value;

		var rdParam = '/rp ' + '[' + usrId + '] [' + effDt + '] [' + expDt + '] [' + vslCd + ']';
		var rdFile = 'ESM_FMS_009.mrd';
	
		// 열고자 하는 RD 파일을 지정한다.
	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutfleetmanagement/tcharterioinquiry/report/'+rdFile, RDServer+rdParam);
		Rdviewer.CMPrint (); //인쇄 시작
	}