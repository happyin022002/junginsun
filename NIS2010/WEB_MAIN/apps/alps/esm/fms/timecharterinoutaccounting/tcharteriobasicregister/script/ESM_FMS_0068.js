/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0068.js
*@FileTitle : Revenue Port Management
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 유재민
*@LastVersion : 1.0
* 2009.07.15 최우석
* 1.0 Creation
* 
* History
* 2011.03.18 유재민 [CHM-201109295-01] Location 조회불가건 수정 보완 요청
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
     * @class esm_fms_0068 : esm_fms_0068 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0068() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnChange 		= sheet1_OnChange;
    	this.initConfirm			= initConfirm;
    	this.setLaneCd				= setLaneCd;
    	this.initControl            = initControl;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_keypress			= obj_keypress;
    	this.obj_change				= obj_change;
    	this.inputReadOnly			= inputReadOnly;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
	    /*******************************************************/
	    var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	        switch(srcName) {
				case "btn_add":
					sheetObject.DataInsert(-1);
	                break;
	
	            case "btn_ins":
	            	sheetObject.DataInsert();
	                break;
	
	            case "btn_del":
	            	ComRowHideDelete(sheetObject, "DelChk");
	                break;
	
	            case "btn_retrive":
	            	if(!initConfirm()) return;
	                doActionIBSheet(sheetObject,formObject,IBSEARCH);
	                form.search_type.value = "retrive";
	                break;
	
	            case "btn_new":
	            	if(!initConfirm()) return;
    		 		ComResetAll();
    		 		inputReadOnly();
	                break;
	
	            case "btn_save":
	                doActionIBSheet(sheetObject,formObject,IBSAVE);
	                break;
	            
	            case "btn_slanpop":
	            	ComOpenPopup("ESM_FMS_0036.do", 620, 440, "setLaneCd", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0036");
	                break;
	            
				case "btn_savetofile":
	                sheetObject.SpeedDown2Excel(-1);
	                break;
	                
				case "btn_deleteAll":
	            	// 정말로 삭제하시겠습니까?
	 				if(ComShowCodeConfirm("FMS00003")) {
						doActionIBSheet(sheetObject, formObject, IBDELETE);
					}
	                break;
	                
				case "btn_revInterface":
					if(!initConfirm()) return;
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "esm064_0001");
					form.search_type.value = "interface";
					break;
				
				case "btn_rPort":
					inputReadOnly();
					break;
				
				case "btn_condition":
					inputReadOnly();
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
		for(i=0;i<sheetObjects.length;i++) {
	    	// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
	    	// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			
			sheetObjects[i].ExtendLastCol = false;
	    }
	    
	    initControl();
	    
	    inputReadOnly();
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
	    var cnt = 0;
	
	    switch(sheetNo) {
	        case 1:      //t1sheet1 init
	            with (sheetObj) {
	
	                // 높이 설정
	                style.height = 300;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle = "|Sel|Seq|Service Lane|Revenue Lane|Service Lane Direction|Fin Direction|I/O Code|Start Port|End Port";
	                var headCount = ComCountHeadTitle(HeadTitle);
	                
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,  	true,   "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40, 	daCenter,   false,	"DelChk");
					InitDataProperty(0, cnt++ , dtDataSeq,    	40, 	daCenter,  	true,	"Seq");
					InitDataProperty(0, cnt++ , dtData,      	130,   	daCenter,  	true,   "slan_cd", 			true,	"",	dfNone,	0,	false,	true, 	3);
					InitDataProperty(0, cnt++ , dtData,      	130,   	daCenter,  	false,  "rlane_cd",	 		true,   "", dfNone, 0,  false,	true, 	5);
					InitDataProperty(0, cnt++ , dtData,       	150,   	daCenter,  	false,  "skd_dir_cd",  		true,   "", dfNone, 0,  false,	true, 	1);
					InitDataProperty(0, cnt++ , dtData,       	150,   	daCenter,  	false,  "rev_dir_cd",  		true,   "", dfNone, 0,  false,	true, 	1);
					InitDataProperty(0, cnt++ , dtData,       	100,   	daCenter,  	false,  "flet_ioc_cd",  	false,  "", dfNone, 0,  true,	true, 	3)
					InitDataProperty(0, cnt++ , dtData,   	   	100,   	daCenter,  	true,   "st_port_cd",   	false,  "", dfNone,	0,  true,	true, 	5);
					InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  	true,   "fnl_port_cd",   	false,  "", dfNone,	0,  true,	true, 	5);
					
					InitDataValid(0, "slan_cd",		vtEngUpOnly);
					InitDataValid(0, "rlane_cd",	vtEngUpOnly);
					InitDataValid(0, "skd_dir_cd",	vtEngUpOnly);
					InitDataValid(0, "rev_dir_cd",	vtEngUpOnly);
					InitDataValid(0, "flet_ioc_cd",	vtEngUpOnly);
					InitDataValid(0, "st_port_cd",	vtEngUpOther, "0123456789");
					InitDataValid(0, "fnl_port_cd",	vtEngUpOther, "0123456789");
	           	}
				break;
		}
	}

	/**
	 * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다.<br>
	 **/
	function doActionIBSheet(sheetObj, formObj, sAction, objNm, row) {
	    sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	       	case IBSEARCH:      //조회
       			if(objNm == "slan_cd") {
       				form.f_cmd.value = SEARCH05;
       				var param = FormQueryString(formObj) + "&lane_cd=" + formObj.slan_cd.value;
       				var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , param);
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			if(typeof cdName != "undefined" && cdName != "" ) {
		   				formObj.slan_cd.value = cdName;
					} else {
						formObj.slan_cd.value = "";
						ComAlertFocus(formObj.slan_cd, ComGetMsg("FMS00006", "Lane"));
					}
    		   			
       			} else if(objNm == "rlane_cd") {
       				form.f_cmd.value = SEARCH07;
       				var param = FormQueryString(formObj) + "&rlane_cd=" + formObj.rlane_cd.value;
       				var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , param);
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			if(typeof cdName != "undefined" && cdName != "" ) {
		   				formObj.rlane_cd.value = cdName;
					} else {
						formObj.rlane_cd.value = "";
						ComAlertFocus(formObj.rlane_cd, ComGetMsg("FMS00006", "Lane"));
					}

       			} else if(objNm == "esm064_0001") {
       				formObj.f_cmd.value = SEARCH01;
       				sheetObj.DoSearch("ESM_FMS_0068GS.do", FormQueryString(formObj));

       			} else {
			       	if(validateForm(sheetObj, formObj, sAction)) {
						formObj.f_cmd.value = SEARCH;
						sheetObj.DoSearch("ESM_FMS_0068GS.do", FormQueryString(formObj));
					}
       			}
	            break;

	       	case IBROWSEARCH:
	       		if(objNm == "slan_cd") {
       				form.f_cmd.value = SEARCH05;
       				var param = FormQueryString(formObj) + "&lane_cd=" + sheetObj.CellValue(row, objNm);
       				var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", param);
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			if(typeof cdName != "undefined" && cdName != "" ) {
		   				sheetObj.CellValue2(row, objNm) = cdName;
					} else {
						ComShowMessage(ComGetMsg("FMS00006", "Lane"));
						sheetObj.CellValue2(row, objNm) = "";
	 					sheetObj.SelectCell(row, objNm);
					}
    		   			
       			} else if(objNm == "rlane_cd") {
       				var param = "f_cmd=" + SEARCH07 + "&rlane_cd=" + sheetObj.CellValue(row, objNm);
       				var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , param);
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			if(typeof cdName != "undefined" && cdName != "" ) {
		   				sheetObj.CellValue2(row, objNm) = cdName;
					} else {
						ComShowMessage(ComGetMsg("FMS00006", "Lane"));
						sheetObj.CellValue2(row, objNm) = "";
	 					sheetObj.SelectCell(row, objNm);
					}
		   			
       			} if(objNm == "st_port_cd") {
       				form.f_cmd.value = SEARCH04;
       				var param = FormQueryString(formObj) + "&loc_cd=" + sheetObj.CellValue(row, objNm);
       				var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", param);
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			if(typeof cdName != "undefined" && cdName != "" ) {
		   				sheetObj.CellValue2(row, objNm) = cdName;
					} else {
						ComShowMessage(ComGetMsg("FMS00006", "Port"));
						sheetObj.CellValue2(row, objNm) = "";
	 					sheetObj.SelectCell(row, objNm);
					}
		   			
       			} if(objNm == "fnl_port_cd") {
       				form.f_cmd.value = SEARCH04;
       				var param = FormQueryString(formObj) + "&loc_cd=" + sheetObj.CellValue(row, objNm);
       				var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", param);
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			if(typeof cdName != "undefined" && cdName != "" ) {
		   				sheetObj.CellValue2(row, objNm) = cdName;
					} else {
						ComShowMessage(ComGetMsg("FMS00006", "Port"));
						sheetObj.CellValue2(row, objNm) = "";
	 					sheetObj.SelectCell(row, objNm);
					}
       			}
	       		break;
	
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					
					if(form.search_type.value == "interface") {
						// 전체 Data를 삭제하고 다시 생성하시겠습니까?
						if(!ComShowCodeConfirm("FMS01343")) {
							return;
						}
					
			    		for(var row=1; row<=sheetObj.LastRow; row++) {
			    			sheetObj.RowStatus(row)= "I";
			    		}
			    	}
					
					if(!sheetObj.IsDataModified || (sheetObj.GetSaveString() == "")) {
						ComShowCodeMessage("FMS00007");
						return;
					}
					
					var param = FormQueryString(formObj) + "&" + ComFmsSetPrifix(sheetObj.GetSaveString(),"sheet1_");
					var sXml = sheetObj.GetSaveXml("ESM_FMS_0068GS.do", param);
				  	sheetObjects[0].LoadSaveXml(sXml);
				}
	            break;

			case IBDELETE:      // 전체삭제
				for(var row=1; row<=sheetObj.LastRow; row++) {
					sheetObj.RowStatus(row)= "D";
				}
	    		formObj.f_cmd.value = REMOVE;
	  	  		sheetObj.DoSave("ESM_FMS_0068GS.do", FormQueryString(formObj));
	 			break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 Validation을 체크한다.<br>
	 */
	function validateForm(sheetObj,formObj,sAction) {
		 
		if(form.search_type.value == "interface") {
			return true;
		}

		if(sAction == IBSAVE) {
			var idx = 0;
			var sourceKey = "";
			var targetKey = "";
			for(var i=0; i<sheetObj.LastRow; i++) {
				++idx;
				
				if(sheetObj.CellValue(idx, "ibflag") == "D") {
    				continue;
    			}
				
				sourceKey = sheetObj.CellValue(idx, "rlane_cd") + sheetObj.CellValue(idx, "skd_dir_cd") + sheetObj.CellValue(idx, "rev_dir_cd");
				for(var j=idx+1; j<=sheetObj.LastRow; j++) {
					if(sheetObj.CellValue(j, "ibflag") == "D") {
	    				continue;
	    			}
					
					targetKey = sheetObj.CellValue(j, "rlane_cd") + sheetObj.CellValue(j, "skd_dir_cd") + sheetObj.CellValue(j, "rev_dir_cd");
					if(sourceKey == targetKey) {
						ComShowCodeMessage("FMS00008", "[Revenue Lane] [Service Lane Direction] [Fin Direction]");
						return false;
					}
				}
			}
		}

	    return true;
	}
	
	/**
     * sheet1의 OnChange이벤트 발생시 Service Lane, Revenue Lane, Start Port, End Port의 Validation을 체크한다.<br>
     */
	function sheet1_OnChange(sheetObj, row, col, value) {
    	if(value == "") {
    		return;
    	}

		if (sheetObj.ColSaveName(col) == "slan_cd") {
			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "slan_cd", row);
		} else if (sheetObj.ColSaveName(col) == "rlane_cd") {
			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "rlane_cd", row);
		} else if (sheetObj.ColSaveName(col) == "st_port_cd") {
			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "st_port_cd", row);
		} else if (sheetObj.ColSaveName(col) == "fnl_port_cd") {
			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "fnl_port_cd", row);
		}
	}

    /**
     * 변경된 데이터가 있을 경우 다른 작업시 진행여부를 체크한다.<br>
     **/
    function initConfirm() {
    	var okYn = true;
     	if(sheetObjects[0].isDataModified) {
     		var okYn = ComShowCodeConfirm("FMS00002");
     	}
     	
     	return okYn;
    }

    /**
 	 * Lane Code 팝업창에서 선택한 Lane Code를 Form항목에 설정한다.<br>
 	 * @param {arry} aryPopupData
 	 */
 	function setLaneCd(aryPopupData){
 		form.slan_cd.value = aryPopupData[0][3];
 	}
 	
 	/**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
 	function initControl() {
 		// Axon 이벤트 처리1. 이벤트catch
 		axon_event.addListener      ('keypress',        'engnum_keypress' , 'slan_cd', 'rlane_cd');  // 영문 대문자/숫자만 입력하기
     	axon_event.addListenerForm  ('blur'				, 'obj_deactivate'	, form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  	, form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        axon_event.addListenerForm  ('change'			, 'obj_change'		, form); 	//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
 	}
 	
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function engnum_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('uppernum');
    } 
    
 	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다.<br>
     **/
    function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다.<br>
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
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onchange이벤트에서 Service Lane, Revenue Lane를 체크한다.<br>
     */
 	function obj_change() {
 		if((event.srcElement.name == "slan_cd") && (event.srcElement.value.length == 3)) {
 	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"slan_cd");
 		} else if((event.srcElement.name == "rlane_cd") && (event.srcElement.value.length == 5)) {
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"rlane_cd");
 		}
 	}
    
    /**
     * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
     **/
    function inputReadOnly() {
    	if(form.btn_rPort[0].checked) {			// Inquiry
    		if(form.btn_condition[0].checked) {
    			form.slan_cd.disabled = false;
    			form.slan_cd.className = "input";
       			form.rlane_cd.disabled = true;
       			form.rlane_cd.value = "";
       			form.rlane_cd.className = "input2";
       			
    	    	document.images["btn_slanpop"].name = "btn_slanpop";
    	    	form.btn_slanpop.style.cursor = "hand";
    	    	
    		} else if(form.btn_condition[1].checked) {
    			form.slan_cd.disabled = true;
       			form.slan_cd.value = "";
       			form.slan_cd.className = "input2";
    			form.rlane_cd.disabled = false;
    			form.rlane_cd.className = "input";
       			
       			document.images["btn_slanpop"].name = "no_btn_slanpop";
    	    	form.btn_slanpop.style.cursor = "default";
    		}
    	
	    	form.btn_condition[0].disabled = false;
	    	form.btn_condition[1].disabled = false;

	    	ComBtnDisable("btn_revInterface");
	    	ComBtnEnable("btn_retrive");
	    	
	    	if(form.search_type.value == "interface") {
	    		sheetObjects[0].RemoveAll();
	    	}
	    	
	    	form.search_type.value = "retrive";
    		
    	} else if(form.btn_rPort[1].checked) {	// Creation
    		form.slan_cd.disabled = true;
   			form.slan_cd.value = "";
   			form.slan_cd.className = "input2";

   			form.rlane_cd.disabled = true;
   			form.rlane_cd.value = "";
   			form.rlane_cd.className = "input2";

    		document.images["btn_slanpop"].name = "no_btn_slanpop";
	    	form.btn_slanpop.style.cursor = "default";
    		
	    	form.btn_condition[0].disabled = true;
	    	form.btn_condition[1].disabled = true;
	    	form.btn_condition[0].checked = true;

	    	ComBtnEnable("btn_revInterface");
    		ComBtnDisable("btn_retrive");
    		
    		if(form.search_type.value == "retrive") {
    			sheetObjects[0].RemoveAll();
	    	}
    		
    		form.search_type.value = "interface";
    		
    	} else if(form.btn_condition[0].checked) {
			form.slan_cd.disabled = false;
			form.slan_cd.className = "input";
   			form.rlane_cd.disabled = true;
   			form.rlane_cd.value = "";
   			form.rlane_cd.className = "input2";
   			
	    	document.images["btn_slanpop"].name = "btn_slanpop";
	    	form.btn_slanpop.style.cursor = "hand";
	    	
		} else if(form.btn_condition[1].checked) {
			form.slan_cd.disabled = true;
   			form.slan_cd.value = "";
   			form.slan_cd.className = "input2";
			form.rlane_cd.disabled = false;
			form.rlane_cd.className = "input";
   			
   			document.images["btn_slanpop"].name = "no_btn_slanpop";
	    	form.btn_slanpop.style.cursor = "default";
		}
    }

    /**
 	 * slan_cd,rlane_cd,skd_dir_cd의 Font를 변경한다.<br>
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg) {
 		ComColFontName(sheetObj, "slan_cd", "Courier New");
 		ComColFontName(sheetObj, "rlane_cd", "Courier New"); 
 		ComColFontName(sheetObj, "skd_dir_cd", "Courier New");
 		ComColFontName(sheetObj, "rev_dir_cd", "Courier New"); 
 		ComColFontName(sheetObj, "flet_ioc_cd", "Courier New"); 
 		ComColFontName(sheetObj, "st_port_cd", "Courier New"); 
 		ComColFontName(sheetObj, "fnl_port_cd", "Courier New"); 
 	}
	/* 개발자 작업  끝 */