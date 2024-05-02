/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_084GS.jsp
*@FileTitle : UsaRailYardManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-11
*@LastModifier : Jun Yong Park
*@LastVersion : 1.0
* 2009-05-11 Jun Yong Park
* 1.0 최초 생성
* N200905150040 2009-05-20 [TRS]USA RAIL YARD 정보 저장 화면 개발
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_084 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_084() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				//조회시 이벤트
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
				
				//저장버튼을 누를시
                case "btng_save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

				//btns_tonode 버튼을 누를시 history 팝업을 뛰운다.
				case "btn_reset": 
					fn_reset();
				break;
				
				case "btn_close": 
					window.close();
				break;				


            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowCodeMessage("TRS90392");
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

        }
		var formObject = document.form;
		formObject.yard.focus();		
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
                    style.height = 240;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Sel|STS|Yard Code|Yard Name|Yard City|Yard State|Office State|Office Address|Office City|Office Zip";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,				KEYFIELD, CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,  40,   daCenter,  true,    "sel"); 
                    InitDataProperty(0, cnt++ , dtStatus,    30,   daCenter,  true,    "ibflag");      
                    InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,		"yd_cd",			true,		"",			dfNone,         0,       false,		false,		7,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,     130,   daCenter,  true,		"yd_nm",		true,		"",			dfNone,				0,       false,		false,		50,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  true,    "yd_loc_cty_nm",   false,		"",			dfNone,	      		0,		 true,		true,		50,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  true,    "yd_loc_ste_cd",			false,		"",			dfNone,         0,       true,		true,		2,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,   true,    "yd_ctrl_ofc_ste_cd",				false,		"",			dfNone,			0,       true,		true,		2,	false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,     130,    daCenter,  true,    "yd_ctrl_ofc_addr",		false,		"",			dfNone,				0,       true,		true,		200,		false,		true,	   "",	  false);
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "yd_ctrl_ofc_cty_nm",   false,		"",			dfNone,			    0,       true,		true,		50,		false,		true,	   "",	  false);                    
                    InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,    "yd_ctrl_ofc_zip_cd",		false,		"",			dfNone,				0,       true,		true,		10,	false,		true,	   "",	  false);				
                 
               }
                break;
        }
    }



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

		switch(sAction) {

			// 조회
			case IBSEARCH:  
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TRS_0084GS.do", TrsFrmQryString(formObj));
                break;

			// 저장
            case IBSAVE:   
	            formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESD_TRS_0084GS.do", TrsFrmQryString(formObj),"sel",false);
                break;
                
            // REMOVE
			case "btn_reset": 
				fn_reset();
			break;
        }
    }
    
    /*
	 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_003.js에도 존재).
	 */
	function getComboList_val(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류

		var formObj = document.form;
		var formObject = document.form;
		var charval = "Y";
		var inputStr=obj.value;
		var lvFromNode = "";
		var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
		var yard_obj = null;
		obj.value = lvobj;
		if( lvobj == "" ) {
			obj.value = "";

			if(obj.name == 'yard') yard_obj = document.rail_yard;
			
			var locValue = obj.value;

			if(ComTrim(locValue) == ''){
				yard_obj.RemoveAll();
				return;
			}

		} else if( lvobj.length != 5 ) {
			ComShowCodeMessage("TRS90074");
			if(sep=="F"){
				formObject.yard.select();
				formObject.yard.focus();
				document.rail_yard.RemoveAll();

			}else{
			}
			//return false;
		}else{
			for (var i = 0; i < inputStr.length; i++)
			{
				 var oneChar = inputStr.charAt(i)
				 if (oneChar != "")
				 {
					   if (  (oneChar >= "a" && oneChar <= "z" ) || (oneChar >= "A" && oneChar <= "Z" ) || (oneChar >= "0" && oneChar <= "9" )){
					   }else {
						   charval ="N";
						   break;
					   }
				 }else{
					charval ="N";
					break;
				 }
			}

			if(charval=="Y"){
				if( sep == 'F' ){
					lvFromNode = getYardZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
				}else{
				}
			}else{
				if( sep == 'F' ){				
					var errMessage = ComGetMsg('COM12130','YARD DATA','','');  
					ComShowMessage(errMessage);
					obj.value = "";
					formObj.yard.focus();
					formObj.yard.select();
					document.rail_yard.RemoveAll();
				}
			}
		}
		comObj.focus();
	}


	/**
	 * 포커스이벤트
	 */
	function fun_Focus(obj){
		var val = obj.value;
		obj.value = val;
		obj.select();
	}

	
	/**
	 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		if(errMsg!= "") return;
		  // doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}


	/**
	 * 리셋펑션
	 */
	function fn_reset(){

		var formObject = document.form;	

		sheetObjects[0].RemoveAll();
		
		formObject.yard.value="";

		formObject.rail_yard.RemoveAll(); // combo 데이터삭제
	}	

