/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0072.js
*@FileTitle : Manhour Item Registration & Pop Up
*@LastModifyDate : 2009.05.12
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.08 최우석
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
     * @class Manhour Item Registration : Manhour Item Registration 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0072() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.initConfirm			= initConfirm;
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
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
	                break;
	
	     		case "btn_new":
	     			if(!initConfirm()) return;
    				ComResetAll();
	                break;
	
	 			case "btn_save":
	 				doActionIBSheet(sheetObject,formObject,IBSAVE);
	                break;
	
	 			case "btn_add":
	 				var row = sheetObject.DataInsert(-1);
	                break;
	
	     		case "btn_del":
	     			ComRowHideDelete(sheetObject, "DelChk");
	                break;
	
	 			case "btn_ins":
	 				var row = sheetObject.DataInsert();
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
	
	 	    //khlee-시작 환경 설정 함수 이름변경
	 	    ComConfigSheet (sheetObjects[i] );
	
	         initSheet(sheetObjects[i],i+1);
	     	//khlee-마지막 환경 설정 함수 추가
	         ComEndConfigSheet(sheetObjects[i]);
	         
	         sheetObjects[i].ExtendLastCol = false;
	     }
	
	     //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	  
	
	/**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
		
		sheetObj.WaitImageVisible = true;   
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
	                 style.height = 240;
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
	
	                 var HeadTitle = "|Sel|Seq|Manhour Item Name|man_hr_list_seq";
	                 var headCount = ComCountHeadTitle(HeadTitle);
	                 
	                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                 InitColumnInfo(headCount, 0, 0, true);
	
	                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                 InitHeadRow(0, HeadTitle, true);
	
	                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                 InitDataProperty(0, cnt++ , dtHiddenStatus,	40,    	daCenter,  	false,   "ibflag");
	                 InitDataProperty(0, cnt++ , dtDummyCheck,      40,    	daCenter,  	false,   "DelChk");
	                 InitDataProperty(0, cnt++ , dtDataSeq,    			40,    	daCenter,  	true,    "Seq"); 
	                 InitDataProperty(0, cnt++ , dtData,      		300,   	daLeft,  	true,    "man_hr_itm_nm",		true,	"",	dfNone,	0,	true,	true, 50);
	                 InitDataProperty(0, cnt++ , dtHidden,      	30,   	daCenter,  	true,    "man_hr_list_seq",		false,	"",	dfNone,	0,	true,	true);
	                 
	                 InitDataValid(0, "man_hr_itm_nm", vtEngOther, "!@#$%^&*(){}[]|:;~`',.\"/-0123456789 ");
	            }
	 			break;
	     }
	}
	
    /**
	 * Sheet관련 프로세스를 처리한다.<br>
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg = false;
	     switch(sAction) {
	 		case IBSEARCH:      //조회
		 		formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_FMS_0072GS.do", FormQueryString(formObj));
	            break;
	
	 		case IBSAVE:        //저장
	 			if(validateForm(sheetObj,formObj,sAction)) {
			 		formObj.f_cmd.value = MULTI;
		  	  		sheetObj.DoSave("ESM_FMS_0072GS.do", FormQueryString(formObj));
	 			}
	            break;
	            
	 		case IBINSERT:      // 입력
	 			break;
	 	}
	}

	/**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
	function validateForm(sheetObj,formObj,sAction){
		 if (sAction == IBSAVE) {
	    	for(var i=1; i<sheetObj.LastRow; i++) {
	    		
	    		if(sheetObj.CellValue(i, "ibflag") == "D") {
	    			continue;
	    		}
	    		
	    		row1 = sheetObj.CellValue(i, "man_hr_itm_nm");
	    		for(var j=i+1; j<=sheetObj.LastRow; j++) {
	    			row2 = sheetObj.CellValue(j, "man_hr_itm_nm");
	    			
	    			if(sheetObj.CellValue(j, "ibflag") == "D") {
		    			continue;
		    		}

	    			if(row1.trim() == row2.trim()) {
	    				// 동일한 shp_yd_nm이 존재합니다
	    				ComShowCodeMessage("FMS00008", "Manhour Item Name");
	    				sheetObj.SelectCell(j, "man_hr_itm_nm");
	    				return false;
	    			}
	    		}
	    	}
    	}
		 
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

    /* 개발자 작업  끝 */