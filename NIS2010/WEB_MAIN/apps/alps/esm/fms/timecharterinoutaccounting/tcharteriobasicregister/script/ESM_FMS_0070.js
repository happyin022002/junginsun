/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0070.js
*@FileTitle : Vendor Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.16 윤세영
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
     * @class Vendor Customer Inquiry : Vendor Customer Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0070() {
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
				case "btn_retrieve":
					if (formObject.search_name.value.length < 3) {
						ComAlertFocus(formObject.search_name, ComGetMsg('FMS01331'));
						return;
					}
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;
			
				case "btn_confirm":
					comPopupOK();
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
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    	initControl();
    }


    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        document.form.search_name.focus();
        
        //Vendor인 경우는 국가코드 컬럼을 안보이게 처리
        if (document.form.cond_flag[0].checked) {
        	sheetObjects[0].ColHidden("cd_cnt") = true;
    	}	
    }


    /**
     * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 영문대문자 또는 영문소문자로 자동 변경 제어한다. <br>
     * 예를 들어 다음과 같이 사용한다.<br>
     *     &lt;input type="text" name="txtName" <font color="red">style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')"</font>&gt; <br>
     * 인자로 사용되는 sFlag 인자의 설정값은 다음과 같다. <br>
     * sFlag = "upper"      : 영문대문자만 입력할수 있고, 대문자로 자동 변환된다. <br>
     * sFlag = "lower"      : 영문소문자만 입력할수 있고, 소문자로 자동 변환된다. <br>
     * sFlag = "uppernum"   : 영문대문자와 숫자만 입력할수 있고, 대문자로 자동 변환된다. <br>
     * sFlag = "lowernum"   : 영문소문자와 숫자만 입력할수 있고, 소문자로 자동 변환된다. <br>
     * sFlag = "num"        : 영문과 숫자 입력할수 있고, 자동 변환없이 그대로 표시한다. <br>
     * sFlag = 설정안한경우 : 영문만 입력할수 있고, 자동변환없이 그대로 표시한다. <br>
     * <font color="red">주의!</font> style="ime-mode:disabled"은 반드시 설정해야 기능이 정확히 처리된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;input type="text" name="txtType" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('lower')"&gt;
     * </pre>
     * @param {string} sFlag 선택,영문모드, default=""
     * @returns 없음 <br>
     * @see #ComKeyOnlyNumber
     */
    function ComKeyOnlyAlphabetNum(sFlag)
    {
        try {
	        var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            var bCanNum  = false;
            //ComDebug('key  = '+keyValue);

            if (sFlag==undefined || sFlag==null || sFlag.constructor!=String) sFlag="";
            sFlag = sFlag.toLowerCase();

			if (sFlag.substr(sFlag.length-3)=="num") bCanNum=true;

            if (sFlag.length > 3){
                if (sFlag.length > 5) sFlag = sFlag.substr(0,5);
            }

            if(keyValue >= 97 && keyValue <= 122){                  //소문자
                if (sFlag=="upper") event.keyCode = keyValue + 65 - 97;
                event.returnValue = true;
            } else if(keyValue >= 65 && keyValue <= 90){            //대문자
                if (sFlag=="lower") event.keyCode = keyValue + 97 - 65;
                event.returnValue = true;
            } else if(bCanNum && keyValue >= 48 && keyValue <= 57) {//숫자
                event.returnValue = true;
            } else {
                event.returnValue = false;
            }
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
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
                    InitRowInfo(1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                    InitHeadMode(true, true, false, true, false,false)
					var HeadTitle = "||Seq|Vendor/Customer\nName|Vendor/Customer\nCode|Vendor/Customer\nCode";
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD,	CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  
                    InitDataProperty(0, cnt++, 	dtRadioCheck,	0,    	daCenter,  	false,		"radio",   		false,      "",     dfNone,	    	0,     		true,       true);
                    InitDataProperty(0, cnt++, 	dtCheckBox,  	0,    	daCenter,  	false,   	"check",   		false,      "",     dfNone,   		0,     		true,       true);
					InitDataProperty(0, cnt++ , dtSeq,    		30,    	daCenter,  	true,    	"Seq");
					InitDataProperty(0, cnt++ , dtData,			300,	daLeft,   	false,    	"cd_name",		false,      "",     dfNone,   		0,     		false,       false);
					InitDataProperty(0, cnt++ , dtData,  		30,		daCenter,   false,    	"cd_cnt",		false,      "",     dfNone,   		0,     		false,       false);														 
					InitDataProperty(0, cnt++ , dtData,   		40,		daCenter,   false,    	"cd_seq",		false,      "",     dfNone,   		0,     		false,       false);														 
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
     * @param {String}  gubun     	처리할 gubun 값
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
//        sheetObj.ShowDebugMsg = true;
        switch(sAction) {
        	case IBSEARCH:      //조회

        		if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value = SEARCH;
        			sheetObj.DoSearch("ESM_FMS_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
        		}
        		break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	화면 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	sheetObj의 입력값
     * @return {boolean} 정상 여부
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }

     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		ComColFontName(sheetObj, "cd_cnt", "Courier New"); 	
	}	

	/* 개발자 작업  끝 */