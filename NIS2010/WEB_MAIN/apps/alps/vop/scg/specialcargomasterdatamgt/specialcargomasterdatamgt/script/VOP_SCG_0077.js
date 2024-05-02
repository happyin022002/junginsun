/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0077.js
*@FileTitle : Setup mail contents for SPCL CGO application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.09.25 김현욱
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
     * @class VOP_SCG_0077 : VOP_SCG_0077 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_SCG_0077() {
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

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var sheetObject = sheetObjects[0];
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
        
        initControl();
    }
     
    // 이벤트 Catch Listener
    function initControl() {
          // Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm   ('keyup',    'obj_keyup',      form);
          axon_event.addListenerForm   ('click',    'obj_click',      form);
    }
    
    // 업무 자바스크립트 OnClick 이벤트 처리
	function obj_click() {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		switch (event.srcElement.name) {
			case "auto_eml_flg":
				if (formObj.auto_eml_flg.checked) {
					for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {
	    				sheetObj.CellValue2(rowIdx,"auto_eml_flg") = "Y";
	    			}
				} else {
					for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {
	    				sheetObj.CellValue2(rowIdx,"auto_eml_flg") = "N";
	    			}
				}
				break;
		}
	}
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keyup() {
    	var sheetObj = sheetObjects[0];
    	with(event.srcElement) {
    		
    		var strLen = value.length;
    		if(strLen > 4000) {
    			ComSetObjValue(event.srcElement, ComGetObjValue(event.srcElement).substring(0, 4000));
    		}
    		
	    	switch(name) {
	    		case "dg_hdr_ctnt":
	    			sheetObj.CellValue2(1,"hdr_ctnt") = value;
	    			break;
	    		case "dg_ftr_ctnt":
	    			sheetObj.CellValue2(1,"ftr_ctnt") = value;
	    			break;
	    		case "ak_hdr_ctnt":
	    			sheetObj.CellValue2(2,"hdr_ctnt") = value;
	    			break;
	    		case "ak_ftr_ctnt":
	    			sheetObj.CellValue2(2,"ftr_ctnt") = value;
	    			break;
	    		case "bb_hdr_ctnt":
	    			sheetObj.CellValue2(3,"hdr_ctnt") = value;
	    			break;
	    		case "bb_ftr_ctnt":
	    			sheetObj.CellValue2(3,"ftr_ctnt") = value;
	    			break;
	    		case "rf_hdr_ctnt":
	    			sheetObj.CellValue2(4,"hdr_ctnt") = value;
	    			break;
	    		case "rf_ftr_ctnt":
	    			sheetObj.CellValue2(4,"ftr_ctnt") = value;
	    			break;
	    	}
    	}
    } 
    
    /**
     * sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function sheet1_OnLoadFinish(sheetObj) {	
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }  
     
    /**
     * Sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	
    	ComSetObjValue(formObj.dg_hdr_ctnt, sheetObj.CellValue(1,"hdr_ctnt"));
    	ComSetObjValue(formObj.dg_ftr_ctnt, sheetObj.CellValue(1,"ftr_ctnt"));
    	
    	ComSetObjValue(formObj.ak_hdr_ctnt, sheetObj.CellValue(2,"hdr_ctnt"));
    	ComSetObjValue(formObj.ak_ftr_ctnt, sheetObj.CellValue(2,"ftr_ctnt"));
    	
    	ComSetObjValue(formObj.bb_hdr_ctnt, sheetObj.CellValue(3,"hdr_ctnt"));
    	ComSetObjValue(formObj.bb_ftr_ctnt, sheetObj.CellValue(3,"ftr_ctnt"));
    	
    	ComSetObjValue(formObj.rf_hdr_ctnt, sheetObj.CellValue(4,"hdr_ctnt"));
    	ComSetObjValue(formObj.rf_ftr_ctnt, sheetObj.CellValue(4,"ftr_ctnt"));
    	
    	if(sheetObj.CellValue(1,"auto_eml_flg") == "Y") {
    		formObj.auto_eml_flg.checked = true;
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
            case 1:      //t1sheet1 init
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
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    var HeadTitle = "||Type|Header (Introduction)|Footer (Signature)||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,	     30,     daCenter, true,    "ibflag");
                    InitDataProperty(0, cnt++ , dtStatus,	 30,     daCenter, true,    "ibstatus");
                    InitDataProperty(0, cnt++ , dtData,		 100,    daLeft,   true,    "spcl_cgo_cd", 	  	true,     "",      dfNone,      0,     true,    true);
                    InitDataProperty(0, cnt++ , dtData,		 580,    daLeft,   true,    "hdr_ctnt", 	  	false,    "",      dfNone,      0,     true,    true, 4000);
                    InitDataProperty(0, cnt++ , dtData,	   	 150,    daLeft,   true,    "ftr_ctnt", 	    false,    "",      dfNone,      0,     true,    true, 4000);
                    InitDataProperty(0, cnt++ , dtData,	   	 150,    daLeft,   true,    "eml_snd_usr_id",   false,    "",      dfNone,      0,     true,    true, 4000);
                    InitDataProperty(0, cnt++ , dtData,	   	 30,     daCenter, true,    "auto_eml_flg",     false,    "",      dfNone,      0,     true,    true);

                    EditEnterBehavior = "newline";
                }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0077GS.do", FormQueryString(formObj));
				
				if(sXml.length > 0) sheetObj.LoadSearchXml(sXml, true); 
			
				break;
			
			case IBSAVE:        //저장
				var sParam = ComGetSaveString(sheetObj, true, true);
				if (!sheetObj.IsDataModified) return;
				
				//'저장하시겠습니까?'
        		if(!ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'
				
				formObj.f_cmd.value = MULTI;
				sParam += "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("VOP_SCG_0077GS.do", sParam); 
    			sheetObj.LoadSaveXml(sXml);
    			
    			for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {
    				if(sheetObj.CellValue(rowIdx,"ibflag") == 'I') {
    					sheetObj.CellValue2(rowIdx,"ibflag") = "U";
    					sheetObj.RowStatus(rowIdx) = "R";
    				}
    			}
				
				break;
				
        }
    }
    
	/* 개발자 작업  끝 */