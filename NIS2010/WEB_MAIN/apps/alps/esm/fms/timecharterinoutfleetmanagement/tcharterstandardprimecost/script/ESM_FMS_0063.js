/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0063.js
*@FileTitle : Hire Creation
*@LastModifyDate : 2009.05.13
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.13 최우석
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
     * @class Hire Creation : Hire Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0063() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initControl            = initControl;
    	this.obj_deactivate 		= obj_deactivate;
    	this.obj_keypress		    = obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.initConfirm			= initConfirm;
    	this.inputReadOnly			= inputReadOnly;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    	this.setMktRtAmt			= setMktRtAmt;
    	this.sheet1_OnChange		= sheet1_OnChange;
    	this.setStdHire				= setStdHire;
    	this.obj_activate			= obj_activate;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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
	         		if(!initConfirm()) return;
	         		form.searchType.value = "Retrieve";
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
	                break;
	
	 			case "btn_new":
	 				if(!initConfirm()) return;
    		 		ComResetAll();
    		 		inputReadOnly("0");
	                break;
	                
	 			case "btn_save":
	 				doActionIBSheet(sheetObject,formObject,IBSAVE);
	                break;
	                 
	 			case "btn_savetofile":
	 				//sheetObject.SpeedDown2Excel(-1);
	 				sheetObject.Down2Excel(-1);
	                break;
	                
	 			case "btn_dataErase":
	 				// 정말로 삭제하시겠습니까?
	 				if(ComShowCodeConfirm("FMS00003")) {
						doActionIBSheet(sheetObject,formObject,IBDELETE);
					}
	                break;
	
	 			case "btn_print":
	 				alert("btn_print");
	                break;
	                
	 			case "btn_hireCreation":
	 				if(!initConfirm()) return;
	 				form.searchType.value = "HireCreation";
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
	                break;
	                
	 			case "btn_marketRateApply":
	 				if(validateForm(sheetObject,formObject,"")) {
	 					setMktRtAmt(sheetObject);
	 				}
	                break;
	                
	 			case "btn_hbYrmon":
	 				var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.rngYr, 'yyyy-MM');
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
	 	    
	 	    sheetObjects[i].ExtendLastCol = false;
	    }

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
        //** Date 구분자 **/
      	DATE_SEPARATOR = "-";
      	
        //Axon 이벤트 처리1. 이벤트catch
      	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        axon_event.addListenerFormat('focus', 'obj_activate', form);
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Year의 Validation을 체크한다.<br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "rngYr":
	    		ComChkObjValid(event.srcElement);
    			break;
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
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
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

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
	                style.height = 405;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 2, 1, 3, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle1 = "|Seq|Market|Vessel Code|Vessel's \nFull Name|Flag|Type|Designed TEU|Designed TEU|Daily Hire Rate|Daily Hire Rate|Max 1T Rate|Std Hire of Max|Diff Hire-std\n(Max)|14Ton 1T Rate|Std Hire of 14Ton|Diff Hire-std\n(14Ton)|flet_ctrt_no|hb_yrmon|mkt_rt_aply_flg1|mkt_rt_amt|stnd_max_hir_amt1|stnd_14ton_hir_amt1|diff_stnd_max_hir_amt1|diff_stnd_14ton_hir_amt1|save_type";
	                var HeadTitle2 = "|Seq|Market|Vessel Code|Vessel's \nFull Name|Flag|Type|Max|14Ton|USD|Others to USD|Max 1T Rate|Std Hire of Max|Diff Hire-std\n(Max)|14Ton 1T Rate|Std Hire of 14Ton|Diff Hire-std\n(14Ton)|flet_ctrt_no|hb_yrmon|mkt_rt_aply_flg1|mkt_rt_amt|stnd_max_hir_amt1|stnd_14ton_hir_amt1|diff_stnd_max_hir_amt1|diff_stnd_14ton_hir_amt1|save_type";
	                var headCount = ComCountHeadTitle(HeadTitle1);
	                 
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 5, 0, true);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                 
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,  	30,     daCenter, 	true,	"ibflag");
	                InitDataProperty(0, cnt++ , dtSeq,         		100,    daCenter,  	true,	"Seq");
	                InitDataProperty(0, cnt++ , dtCheckBox,   	 	50,    	daCenter, 	true,   "mkt_rt_aply_flg",   		false,  "",	dfNone,   		0,	true,	true);
	                InitDataProperty(0, cnt++ , dtData,    			90,    	daCenter, 	true,   "vsl_cd",   				false,  "", dfNone,      	0,  false,	false);
	                InitDataProperty(0, cnt++ , dtData,  		  	160,    daLeft, 	true,   "vsl_eng_nm",  				false,  "", dfNone,      	0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtData,   	 		50,    	daCenter, 	true,   "vsl_cnt_cd",     	 		false,  "", dfNone,     	0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtData,   	 		50,    	daCenter, 	true,   "flet_ctrt_tp_cd",     	 	false,  "", dfNone,     0,  false,	false);
	 								                                                                                                                                                  
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	75,    	daRight,  	false,  "vsl_dznd_capa",     	 	false,  "", dfInteger,     	0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	75,    	daRight,  	false,  "bse_14ton_vsl_capa",     	false,  "", dfInteger,     	0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	85,    	daRight,  	false,  "hir_rt_n1st_amt",     	 	false,  "", dfFloat,		2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	95,    	daRight,  	false,  "hir_rt_n2nd_amt",     	 	false,  "", dfFloat,   		2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	95,    	daRight,  	true,   "max_teu_rt_amt",     		false,  "", dfFloat,   		2,  false,	false);
	                                                                                                                                               
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	110,    daRight,  	true,   "stnd_max_hir_amt",     	false,  "", dfFloat,   		2,  true,	true, 17);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	85,    	daRight,  	true,   "diff_stnd_max_hir_amt",    false,  "", dfFloat,		2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	95,    	daRight,  	true,   "teu_14ton_rt_amt",     	false,  "", dfFloat,		2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	110,   	daRight,  	true,   "stnd_14ton_hir_amt",     	false,  "", dfFloat,   		2,  true,	true, 17);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	85,    	daRight,  	true,   "diff_stnd_14ton_hir_amt",	false,	"", dfFloat,   		2,  false,	false);
	 				
	 				/* ------------------------------------------------------------------------------ */
	 				InitDataProperty(0, cnt++ , dtHidden,   	 	30,    	daCenter, 	true,   "flet_ctrt_no",     	 	false,  "", dfNone,     	0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtHidden,   	 	30,    	daCenter, 	true,   "hb_yrmon",     	 		false,  "", dfNone,     	0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtHidden,   	 	30,    	daCenter, 	true,   "mkt_rt_aply_flg1",     	false,  "", dfNone,     	0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtHidden,   	 	30,    	daCenter, 	true,   "mkt_rt_amt",     			false,  "", dfFloat,    	0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtHidden,   	 	30,    	daRight,  	true,   "stnd_max_hir_amt1",     	false,  "", dfFloat,   		2,  true,	true, 17);
	 				InitDataProperty(0, cnt++ , dtHidden,   	 	30,   	daRight,  	true,   "stnd_14ton_hir_amt1",     	false,  "", dfFloat,   		2,  true,	true, 17);
	 				InitDataProperty(0, cnt++ , dtHidden,   	 	30,    	daRight,  	true,   "diff_stnd_max_hir_amt1",   false,  "", dfFloat,		2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtHidden,   	 	30,    	daRight,  	true,   "diff_stnd_14ton_hir_amt1",	false,	"", dfFloat,   		2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtHidden,   	 	30,    	daCenter, 	true,   "save_type",     	 		false,  "", dfNone,     	0,  false,	false);
	 				/* ------------------------------------------------------------------------------ */
	 				
	 				MessageText("Sum")  = "Total Amount";
	            }
	 			break;
	     	}
	}
	
	/**
	 * Sheet관련 프로세스를 처리한다.<br>
	 */
	function doActionIBSheet(sheetObj,formObj,sAction,searchType) {
	     sheetObj.ShowDebugMsg = false;
	     switch(sAction) {
	     	case IBSEARCH:      // 조회
		 		if(validateForm(sheetObj,formObj,sAction)) {
		 			if(form.searchType.value == "Retrieve") {
						formObj.f_cmd.value = SEARCH;
		 			} else {
		 				formObj.f_cmd.value = SEARCH01;
		 			}
		 			
					sheetObj.DoSearch("ESM_FMS_0063GS.do", FormQueryString(formObj));
					inputReadOnly("1");
				}
	            break;
	
	 		case IBSAVE:        // 저장
		 		if(validateForm(sheetObj,formObj,sAction)) {
		 			if(form.searchType.value == "HireCreation") {
			 			for(var row=2; row<sheetObj.LastRow; row++) {
			 				if(sheetObj.CellValue(row, "save_type") == "I") {
			 					sheetObj.RowStatus(row)= "I";
			 				}
						}
		 			}

		  	  		formObj.f_cmd.value = MULTI;
		  	  		sheetObj.DoSave("ESM_FMS_0063GS.do", FormQueryString(formObj));
		  	  		setCellEditable(sheetObj);
		  	  	}
	            break;
	
	 		case IBINSERT:      // 입력
	 			break;

	 		case IBDELETE:      // 전체삭제
				if(validateForm(sheetObj,formObj,sAction)) {
					for(var row=2; row<sheetObj.LastRow; row++) {
						sheetObj.RowStatus(row)= "D";
					}
		    		formObj.f_cmd.value = REMOVE;
		  	  		sheetObj.DoSave("ESM_FMS_0063GS.do", FormQueryString(formObj));
		  	  		inputReadOnly("0");
				}
	 			break;
	     }
	}
	
	/**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
	function validateForm(sheetObj,formObj,sAction){
        if (!ComChkValid(formObj)) return false;
	
	    return true;
	}
	     
	/**
     * 변경된 데이터가 있을 경우 다른 작업시 진행여부를 체크한다.<br>
     **/
    function initConfirm() {
     	var okYn = true;
     	if(sheetObjects[0].isDataModified) {
     		// 입력 및 변경된 데이터가 있습니다.\n\n계속 진행하시겠습니까?
     		var okYn = ComShowCodeConfirm("FMS00002");
     	}
     	
     	return okYn;
    }

    /**
     * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
     **/
	function inputReadOnly(flag) {
	 	if(flag == "1") {
	 		form.rngYr.readOnly = true;
	 		form.btn_hbYrmon.style.cursor = "default";
	 		document.images["btn_hbYrmon"].name = "";
	 	} else {
	 		form.rngYr.readOnly = false;
	 		form.btn_hbYrmon.style.cursor = "hand";
	 		document.images["btn_hbYrmon"].name = "btn_hbYrmon";
	 	}
	}
	
	/**
     * Market체크여부를 설정한다.<br>
     **/
    function setCellEditable(sheetObj) {
    	var mktRtAmt = 0;
		for(var row=2; row<sheetObj.LastRow; row++) {
			mktRtAmt = sheetObj.CellValue(row, "mkt_rt_amt");
			if(mktRtAmt <= 0) {
				sheetObj.CellEditable(row, "mkt_rt_aply_flg") = false;
			}
			sheetObj.CellFont("FontName", row, "vsl_cd") = "Courier New";
		}
    }
    
    /**
     * Sheet에 OnSearchEnd 이벤트 발생시 Market체크여부를 설정한다.<br>
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setCellEditable(sheetObj);
    }

	/**
     * Market Rate Apply버튼 클릭시 Std Hire Of Max와 Std Hire of 14Ton값을 설정한다.<br>
     */
	function setMktRtAmt(sheetObj) {
		if(sheetObj.LastRow < 2) {
			ComShowCodeMessage("FMS00009", "Market Rate Apply");
			return false;
		}

		var cnt = 0;
		for(var row=2; row<sheetObj.LastRow; row++) {
			if(sheetObj.CellValue(row, "mkt_rt_aply_flg") == 1) {
				sheetObj.CellValue2(row, "stnd_max_hir_amt") = sheetObj.CellValue(row, "mkt_rt_amt");
				sheetObj.CellValue2(row, "stnd_14ton_hir_amt") = sheetObj.CellValue(row, "mkt_rt_amt");
				setStdHire(sheetObj, row);
				cnt += 1;
			}
		}
		
		if(cnt == 0) {
			ComShowCodeMessage("FMS00009", "Market Rate Apply");
			return false;
		}
		
		return true;
	}

	/**
     * Sheet에 OnChange 이벤트 발생시 setStdHire메소드를 호출한다.<br>
     */
	function sheet1_OnChange(sheetObj, row, col, value) {
		if(col == 2) {
			if(value == 0) {
				sheetObj.CellValue2(row, "stnd_max_hir_amt") = sheetObj.CellValue(row, "stnd_max_hir_amt1");
				sheetObj.CellValue2(row, "stnd_14ton_hir_amt") = sheetObj.CellValue(row, "stnd_14ton_hir_amt1");
				sheetObj.CellValue2(row, "diff_stnd_max_hir_amt") = sheetObj.CellValue(row, "diff_stnd_max_hir_amt1");
				sheetObj.CellValue2(row, "diff_stnd_14ton_hir_amt") = sheetObj.CellValue(row, "diff_stnd_14ton_hir_amt1");
			}
		} else if(col == 11) {
			setStdHire(sheetObj, row);
		} else if(col == 14) {
			setStdHire(sheetObj, row);
		}
	}

	/**
	 * stnd_max_hir_amt와 stnd_14ton_hir_amt 변경시 diff_stnd_max_hir_amt와 diff_stnd_14ton_hir_amt를 변경한다<br>
	 */
	function setStdHire(sheetObj, row) {
		sheetObj.CellValue2(row, "diff_stnd_max_hir_amt") = sheetObj.CellValue(row, "hir_rt_n1st_amt") - sheetObj.CellValue(row, "stnd_max_hir_amt");
		sheetObj.CellValue2(row, "diff_stnd_14ton_hir_amt") = sheetObj.CellValue(row, "hir_rt_n1st_amt") - sheetObj.CellValue(row, "stnd_14ton_hir_amt");
	}
	
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
	 */
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	/* 개발자 작업  끝 */