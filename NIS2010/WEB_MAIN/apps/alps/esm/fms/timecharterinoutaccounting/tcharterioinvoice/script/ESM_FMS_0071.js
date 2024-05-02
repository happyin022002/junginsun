/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : ESM_FMS_0071.js
* @FileTitle : Bunker Price Selection
* Open Issues :
* Change history :
* @LastModifyDate : 2011.03.18
* @LastModifier : 유재민
* @LastVersion : 1.0
* 2009.08.08 정윤태
* 1.0 최초 생성
* 
*  History
*  2011.03.18 유재민 [CHM-201109295-01] Location 조회불가건 수정 보완 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview Bunker Price 를 Interface 하기 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     * @author 한진해운
     */

    /**
     * @extends FMS
     * @class Bunker Price Selection : Bunker Price를 Interface 해 온다
     */
    function ESM_FMS_0071() {
    	this.initControl        = initControl;
        this.validateForm       = validateForm;
        this.setSheetObject		= setSheetObject;
        this.processButtonClick	= processButtonClick;
        this.loadPage			= loadPage;		
        this.initSheet			= initSheet;
        this.doActionIBSheet	= doActionIBSheet;
        this.initTab			= initTab;
        this.obj_keypress		= obj_keypress;
        this.obj_deactivate		= obj_deactivate;
        this.obj_activate		= obj_activate;
        this.obj_change			= obj_change;
        this.setLocCd			= setLocCd;
        this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
    }

	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
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
                    
				case "btn_locPop":
    				ComOpenPopup("COM_ENS_051.do", 720, 460,"setLocCd", "1,0,1,1,1", false, false, 0, 0, 0, "COM_ENS_051");
					break;
                    
				case "cal_from_dt": 
					var cal = new ComCalendar();
					cal.select(form.from_dt, 'yyyy-MM-dd');
					break;
				 
				case "cal_to_dt":
				    var cal = new ComCalendar();
					cal.select(form.to_dt, 'yyyy-MM-dd');	
					break;
					
				case "btn_execute":
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

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        initControl();

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
                    style.height = 142;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    
                    var HeadTitle1 = " ||Date|Location Code|Bunker Price|Bunker Price";
                    var HeadTitle2 = " ||Date|Location Code|IFO(380CST)|MDO";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtHiddenStatus,	00,		daCenter,		true,		"hdnStatus");
                    InitDataProperty(0, cnt++, 	dtRadioCheck,	0,    	daCenter,  		true,		"radio",   			false,     "",      dfNone,	    	0,     true,        true);
                    InitDataProperty(0, cnt++, 	dtDummyCheck,  	0,    	daCenter,  		true,   	"check",   			false,     "",      dfNone,   		0,     true,        true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"evnt_dt",     		false,     "", 		dfDateYmd,		0,     false);
					InitDataProperty(0, cnt++ , dtData,   		110,	daCenter,		true,		"port_cd",			false,     "", 		dfNone,			0,     false);
					InitDataProperty(0, cnt++ , dtData,   		100,	daRight,		true,		"foil_act_prc",		false,     "", 		dfNullFloat,	2,     false);
					InitDataProperty(0, cnt++ , dtData,   		100,	daRight,  		true,		"doil_act_prc",		false,     "", 		dfNullFloat,	2,     false);
                                                                   		
					//InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,		true,		"Check",			false,     "", 		dfNone,			0,     true);
					
					CountPosition = 0;
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
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           	case IBSEARCH:      //조회

           		if(!validateForm(sheetObj,formObj,sAction))  return true;

           		formObj.f_cmd.value = SEARCH;
  			
           		sheetObj.DoSearch("ESM_FMS_0071GS.do" , FormQueryString(formObj));

                break;

           	case IBROWSEARCH:      //조회
 			
	           	formObj.f_cmd.value = SEARCH03;
	
	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
	   			var locNm = ComGetEtcData(sXml, "locNm");
	   			
	   			if(typeof locNm != "undefined" && locNm != "" ) {
	   				formObj.loc_nm.value = locNm;
				} else {
					formObj.loc_cd.value = "";
					// 존재하지 않는 Location Code입니다
					ComAlertFocus(formObj.loc_cd, ComGetMsg("FMS00006", "Location Code"));
					return;
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
  		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
  		axon_event.addListenerFormat('keypress', 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
  		axon_event.addListenerForm  ('keypress', 'eng_keypress', form); 			//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
  		axon_event.addListenerForm  ('change', 'obj_change', form); 				//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
  	}
  	
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "from_dt":
	    	case "to_dt":
	    		//숫자만 입력
    			ComChkObjValid(event.srcElement);
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
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
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
    	if((event.srcElement.name == "vsl_cd") ||
    	   (event.srcElement.name == "loc_cd")) { 
    		//영대문자 자동변환
    		ComKeyOnlyAlphabet('uppernum');
    	}
    }
     
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function obj_change() {
    	if(event.srcElement.name == "loc_cd") {
    		form.loc_nm.value = "";
    		doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH);
    	}
    }
     
    /**
 	 * Location Code 입력부분.<br>
 	 * @param {arry} aryPopupData
 	 */
 	function setLocCd(aryPopupData) {
 		form.loc_cd.value = aryPopupData[0][3];
 		form.loc_nm.value = aryPopupData[0][4];
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
    	
		if(parseInt(formObj.from_dt.value.trimAll('-')) > parseInt(formObj.to_dt.value.trimAll('-'))) {
			ComAlertFocus(formObj.to_dt, ComGetMsg('FMS01715'));
			return;
		}
    	
    	return true;
    }
    
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		
 		ComColFontName(sheetObj, "3"); 
 	}
