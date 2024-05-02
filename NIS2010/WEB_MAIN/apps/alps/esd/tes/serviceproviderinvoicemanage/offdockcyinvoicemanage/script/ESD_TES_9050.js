/**
 * @fileoverview Off-Dock CY Container List - Total Amount 에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_9050 : Off-Dock CY Container List - Total Amount 에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TES_9050() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject = sheetObjects[0];

         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

         	    case "btn_ok":
    	            ComShowMessage ("btn_ok button click");
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;

 
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage (ComGetMsg('TES23028')); //ComShowMessage ("지금은 사용하실 수가 없습니다");
    		} else {
    			ComShowMessage (e);
    		}
    	}
    }

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @return     
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    * @return
    */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
		}

		var formObj = document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    }

    /**
    * 시트 초기설정값, 헤더 정의
    * @param {ibsheet} sheetObj IBSheet Object
    * @param {int} sheetNo 	시트오브젝트 태그의 아이디에 붙인 일련번호
    * 							시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    * @return
    */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
                                        
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "Cost Group|Cost Code|Amount";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtCombo,      150,    daCenter,  true,    "calc_cost_grp_cd",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,      100,    daCenter,  false,    "lgs_cost_cd",       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtAutoSum,   100,    daCenter,  false,    "inv_amt",       false,          "",      dfFloat,    2,     false,       false);

					InitDataCombo(0 , "calc_cost_grp_cd", "TMNL Cost|Storage by Day|Storage by Pool", "TM|SD|SP");
                    
//					ShowSubSum(1, "inv_amt");
					ShowSubSum(1, "2");
               }
                break;
        }
    }

    /**
    * Sheet 관련 프로세스 처리
    * @param {ibsheet} sheetObj 	IBSheet Object
    * @param {form} formObj		Form Object
    * @param {int} sAction			실행할 액션 구분 값
    * @return
    */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value = SEARCHLIST;
//				ComShowMessage ('일단 대기');
			    sheetObj.DoSearch4Post("ESD_TES_9050Popup.do", tesFrmQryStr(formObj));
			    break;
		}
	}

	
    /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} formObj		Form Object
	 * @param {int} sAction			실행할 액션 구분 값
	 * @return
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			/**
			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
			 */
			//if (!isNumber(formObj.iPage)) {
			//	return false;
		   // }
		}
		
		return true;
	}
	

	 /**
	  * 조회가 완료되고 발생하는 이벤트
	  * @param {ibsheet}	main_hidden	Coincidence sheet
	  * @param {string}	ErrMsg		error message
	  * @return
	  */
	function sheet_OnSearchEnd(sheetObj,errMsg){
		
		//sheetObj.ShowSubSum(0, "2");
		sheetObj.ShowSubSum("calc_cost_grp_cd", "2", -1, false, false, -1, "calc_cost_grp_cd=;lgs_cost_cd=Sub Total");

		if(errMsg!=null){
			ComShowMessage (errMsg);
		}
	}

