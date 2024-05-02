/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_SCG_0091.js
*@FileTitle : Vessel SKD (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.02.02 이도형
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
	 * @class VOP_SCG_0107 : VOP_SCG_0107 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_SCG_0107() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}

	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var prefix = "scgPckRef_";
 
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;
	
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");

	 		switch(srcName) {
	 		case "btn_RowAdd1":
 				var row = sheetObject.DataInsert(-1);
 				sheetObject.CellValue(row,"imdg_pck_instr_cd") = formObject.imdg_pck_instr_cd.value;
 				sheetObject.CellValue(row,"imdg_pck_instr_seq") = formObject.imdg_pck_instr_seq.value;
 				sheetObject.CellValue(row,"regu_dp_no") = formObject.regu_dp_no.value;
 				sheetObject.CellValue(row, "pck_ref_cd") = "OPM";
				sheetObject.SelectCell(row, 2);
				break;
			
			case "btn_RowCopy1":
				var row = sheetObject.DataCopy();
				sheetObject.SelectCell(row, 2);				
				break;
				
			case "btn_RowDelete1":
				ComRowHideDelete(sheetObject, "del_chk");
				break;
	 		case "btn_RowAdd2":
	 			var row = sheetObject2.DataInsert(-1);
				sheetObject2.SelectCell(row, 5);
				sheetObject2.CellValue2(row, prefix+"imdg_pck_instr_cd") = formObject.imdg_pck_instr_cd.value;
				sheetObject2.CellValue2(row, prefix+"imdg_pck_instr_seq") = formObject.imdg_pck_instr_seq.value;
				sheetObject2.CellValue2(row, prefix+"pck_ref_cd") = "OPM";
				break;
			
			case "btn_RowCopy2":
				var row = sheetObject2.DataCopy();
				sheetObject.SelectCell(row, 5);				
				break;
				
			case "btn_RowDelete2":
				ComRowHideDelete(sheetObject2, prefix+"del_chk");
			
				break;				
				
			case "btn_Retrieve":
				doActionIBSheet(sheetObject,document.form,SEARCH02);
				break;
				
			case "btn_Save":
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
			case "btn_close":
 				window.close();
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/

    function initControl() {
    	axon_event.addListener('keydown',	'ComKeyEnter', 			'form');
   	 	axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
    }

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
					tabIndex = -1;
            	 
					// 높이 설정
					style.height = 237;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					var HeadTitle = "|Del|||||DP\nSeq.|Packing\nMethod|Ref. No.|Maximum mass(kg)\n for solids and for combination\n packagings (liquid and solid)|Maximum contents in litres\n for liquid(*3)";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
                 
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	"ibflag",		 false,	"",      	dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	"del_chk",		 false, "",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,	"imdg_pck_instr_cd",		 true,	"",      	dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"imdg_pck_instr_seq",	 false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,	"sub_seq",	 		 false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	0,	    daCenter,  	true,   "pck_ref_cd",  		 false,  "",     	dfNone,    		0,     		false,    	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"regu_dp_no",		 true,	"",			dfNone,			0,			false,		false, 4);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"imdg_pck_mzd_cd",	 false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"ref_div_no",		 false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			260,		daCenter,	false,	"max_mass",		 false,	"",			dfNone,			2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"max_ctnt",		 false,	"",			dfNone,			2,			true,		true);
 										
					InitDataValid(0, "imdg_pck_mzd_cd", vtEngUpOther, "0123456789"); // 영대문자,숫자만 입력
					InitDataValid(0, "max_mass", vtNumericOther, "."); // 숫자만 입력
					InitDataValid(0, "max_ctnt", vtNumericOther, "."); // 숫자만 입력
				}
				break;
			case 2:      // sheet2 init
			with (sheetObj) {
				tabIndex = -1;
        	 
				// 높이 설정
				style.height = 237;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);

	 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 			InitColumnInfo(8, 0, 0, true);

	 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 			InitHeadMode(true, true, false, true, false,false)

	 			var HeadTitle = "||||Chk.|Ref. No.|Description|";

	 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 			InitHeadRow(0, HeadTitle, true);

	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	prefix+"ibflag");
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix+"imdg_pck_instr_cd",  			false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix+"imdg_pck_instr_seq",  		false,  "",      dfNone,    0,     false,    	false);
	 			InitDataProperty(0, cnt++ , dtHidden,		30,    	daCenter,  	false,	prefix+"pck_ref_cd");
	 			InitDataProperty(0, cnt++ , dtCheckBox, 	30,    	daCenter,   true,   prefix+"del_chk",			false,  "",      dfNone,	0,     true,    	true);
	 			InitDataProperty(0, cnt++ , dtData,        	80,		daCenter,   true,   prefix+"ref_div_no", 			true,	"",      dfNone,	0,     false,		true,		4);
	 			InitDataProperty(0, cnt++ , dtData,        	80,		daLeft,   	true,   prefix+"ref_desc", 			true,	"",      dfNone,	0,     true,		true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	30,	    daCenter,  	true,   prefix+"delt_flg",  		false,  "",      dfNone,    0,     false,    	false,		500);
										
			}
			break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
        	case IBSAVE:      //Country Code조회
	        	formObj.f_cmd.value = MULTI01;
			    var saveStr = "&"+sheetObjects[0].GetSaveString(false, true, "ibflag");
			    saveStr += "&"+sheetObjects[1].GetSaveString(false, true, prefix+"ibflag");
			    if(saveStr != "&&"){
			    	var sXml = sheetObj.GetSaveXml("VOP_SCG_0107GS.do", "f_cmd="+formObj.f_cmd.value+saveStr, false);
					sheetObj.LoadSaveXml(sXml);
					return true;
			    }else{
			    	return false;
			    }
				break;
        		
        	case SEARCH02:      //조회
	        	formObj.f_cmd.value = SEARCH02;
	      		var aryPrefix = new Array( "","scgPckRef_");                
		 	   	var sXml = sheetObj.GetSearchXml("VOP_SCG_0107GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam( aryPrefix ));
		 	   	var arrXml = sXml.split("|$$|");
		 	    sheetObjects[0].LoadSearchXml(arrXml[0]);
		 	    sheetObjects[1].LoadSearchXml(arrXml[1]);
				break;    
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		return true;
	}

	/**
	 * 엔터키로 연결된 화면 대표 이벤트
	 */
	function enter_keypress(){
//		VskKeyEnter();
	}


/* 개발자 작업  끝 */