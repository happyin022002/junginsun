/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0974.js
*@FileTitle : Master Booking Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.24 전용진
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
     * @class ESM_BKG_0974 : ESM_BKG_0974 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0974() {
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
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
					case "btn_ConfirmCombine":
						if(!validateForm(sheetObject,formObject,"btn_ConfirmCombine")) {
							return false;
						}
						comPopupOK2(sheetObject);
					break;
					case "btn_Close":
							window.close();
					break;

            } // end switch
    	}catch(e) {
		if (e == "[object Error]") {
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
        initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

	function initControl() {
		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- 키보드 입력할때
	        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}

	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}

	/**
     * comPopupOK
     */
	function comPopupOK2(sheetObj) {
		var formObj = document.form;	
		var rArray = new Array(); //행데이터를 담고 있는 배열
	    var sRow = sheetObj.FindCheckedRow("slct_flg");
	    //가져온 행을 배열로 반든다.	 	  	 	      
	    var arrRow = sRow.split("|"); 	   
		var cArray = new Array();   		  	   
	    for (idx = 0; idx < arrRow.length - 1; idx++){	     
			 //열데이터를 담고 있는 배열 		 	 
			cArray[idx] = sheetObj.CellValue(arrRow[idx], "bkg_no");
		}

		// 모달창인 경우 opener를 구해온다.
    		if(!opener) opener = window.dialogArguments;
		window.close();
		opener.callBack0974(cArray);
	} 

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 170;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|Master|Seq|Booking No.|B/L No.|Status|SO No.|Shipper|POR|POR|DEL|DEL|CNTR Vol.";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 50,     daCenter,  true,        "ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,	50,		daCenter,	true,		"slct_flg",		false,		"",		dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			25,		daCenter,	true,		"seq",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"bkg_no",		false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"bl_no",		false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,		"bkg_sts_cd",	false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"twn_so_no",	false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			125,	daLeft,		true,		"shipper",		false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"por_cd",		false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,		"por_nod_cd",	false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"del_cd",		false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	true,		"del_nod_cd",	false,		"",		dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"cntr_vol",		false,		"",		dfNone,			0,		false,		true);
					WordWrap = false;
					CountPosition = 2;
			}
			break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          case IBSEARCH:      //조회
//		          if(validateForm(sheetObj,formObj,sAction))
	       	var sXml = formObj.sXml.value;
	       	var arrXml = sXml.split("|$$|");
	       	for(var i = 0; i < arrXml.length; i++){ 
	       		sheetObjects[i].Redraw = false;    
	       		if(i > 0) {
     				sheetObjects[i].WaitImageVisible = false;	
	       		}  
	       		sheetObjects[i].LoadSearchXml(arrXml[i]); 
	       		sheetObjects[i].Redraw = true; 
	       	}
              break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
		switch(sAction) {
		case "btn_ConfirmCombine":
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
		}
        }

        return true;
    }
