/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_mnr_0094.js
 *@FileTitle : Scrapping/Donation Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.10
 *@LastModifier : WanGyu Kim
 *@LastVersion : 1.0
 * 2009.09.10 WanGyu Kim
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
 * @class ees_mnr_0094 : ees_mnr_0094 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_mnr_0094() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* ********* General Functions ************* */
	// 공통전역변수
	var comboObjects = new Array();
	var comboCnt = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
         
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;

				case "btn_New":
					doActionIBSheet(sheetObject1, formObject, IBCLEAR, 1);
					break;
					
				//달력
				case "cre_dt_cal":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.cre_dt_fr, formObject.cre_dt_to, 'yyyy-MM-dd');
					break;
					
				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);
					break;

            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	// 버튼 설정
    	MnrWaitControl(true);
    	// IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	// IBSheet초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Axon이벤트 초기화
		initControl();

		//화면초기화
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);		
    }
    
  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt  = 0 ;
	    var formObject = document.form
	   
	    switch(comboNo) {
	    	case 1: 
	    	case 2: 
	    		with (comboObj) { 
	    			SetColAlign("left");         
	    			DropHeight = 160;  
	    		}
	    		break;
	    	case 3: 
	            with (comboObj) { 
			        SetColAlign("left");         
				    DropHeight = 160; 
				    SetColWidth("75");
					UseAutoComplete = true;
					UseEdit = true;
		        }
	            break;
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
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|Seq.|Type|EQ Type|EQ No.|TP/SZ|Curr.|Expense Amount|Income Amount|Request Office|Issue Yard|Issue Date";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	false,	"seq");
					InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		false,	"mnr_xtra_disp_tp_cd",	false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		false,	"eq_knd_cd",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"eq_no",				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"eq_tpsz_cd",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"curr_cd",				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"xtra_disp_expn_amt",	false,	"",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,	"xtra_disp_incm_amt",	false,	"",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"iss_ofc_cd",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,	"iss_yd_cd",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"iss_dt",				false,	"",	dfDateYmd,		0,	false,	false);
					
					SelectionMode = smSelectionRow;
					SelectHighLight = true;
					SelectFontBold = false;
					SelectBackColor = RgbColor(SelectBackColorR, SelectBackColorG,SelectBackColorB);
			   }
         break;
        }
    }

    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
	    //axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		//- 변경될때
    }

    /**
     * IBCombo Object를 배열로 등록
     * 
     * @param {IBCombo} combo_obj 배열로 등록될 IBCombo Object
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
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
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}	
	
	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
    	ComClearSeparator(event.srcElement);
    }
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	        
			case "engup":
	          	ComKeyOnlyAlphabet("uppernum");          
	            break;
	    } 
	}

	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change(){
		/*
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "eq_no":   
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
			}       
	    } 
	    */
	} 
    
    /**
     * Sheet1관련 프로세스 처리
     * 
     * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
     * @param {Form}formObj 프로세스 처리될 폼오브젝트
     * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);
	
	    		// 모든 쉬트를 초기화
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    		// Only Loading
	    		if (sActionIdx == 0) {
	    			// 조건부 콤보데이타 초기화
	    			for ( var i = 0; i < comboObjects.length; i++) {
	    				comboObjects[i].RemoveAll();
	    			}
	    			
	    			//(Type,EQ Type) 콤보  조회
					var sCondition = new Array (
						new Array("MnrGenCd","CD00032", "COMMON"), 		//Type
						new Array("MnrGenCd","SELHO","CUSTOM9"),		//EQ Type
						new Array("MdmOrganization","SEARCH","NOTHQ")	//Request Office
					)             
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
					//(Type,EQ Type) 콤보 설정       
					for(var i=0; i<comboList.length ; i++){
						if(comboList[i] != null){
							var sheetComboText = "";  
							var sheetComboCode = "";
							var sheetComboDefault = "";
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|"); 
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								if(j ==0){
									sheetComboDefault = tempText[0];      	
								}
								//조건부 콤보 세팅
								if(i==0) {
									formObj.mnr_xtra_disp_tp_cd.InsertItem(j, tempText[1] ,tempText[0]); //Type 
								} else if(i==1) {
									formObj.eq_knd_cd.InsertItem(j, tempText[1], tempText[0]); //EQ Type
								} else if(i==2) {
									formObj.iss_ofc_cd.InsertItem(j, tempText[0], tempText[0]); //Request Office
								}
							}
							//쉬트 콤보 값 세팅
							if(i==0) {
								sheetObjects[0].InitDataCombo (0, "mnr_xtra_disp_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
							} else if(i==1) {
								sheetObjects[0].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
							}
						}
					}
					formObj.mnr_xtra_disp_tp_cd.InsertItem(0, "ALL" ,"A");
					formObj.eq_knd_cd.InsertItem(0, "ALL", "A");
					formObj.iss_ofc_cd.InsertItem(0, "ALL", "A");
	    		}
	    		// 초기값 설정
	    		formObj.cre_dt_fr.value				= ComGetDateAdd(ComGetNowInfo("ymd"), "y", -1);
	    		formObj.cre_dt_to.value				= ComGetNowInfo("ymd"); 
	    		formObj.mnr_xtra_disp_tp_cd.Code	= "A";			//Type
	    		formObj.eq_knd_cd.Code 				= "A"; 	  		//EQ Type
	    		formObj.eq_knd_cd.Enable 			= true;			//EQ Type
	    		formObj.eq_no.value 				= ""; 	  		//EQ No
	    		formObj.eq_no.readOnly 				= false;		//EQ No
	    		formObj.iss_ofc_cd.Code				= currOfcCd;	//Creation Office
	    		
	    		// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
	    		sheetObj.WaitImageVisible = true;
	
	    		break;

	    	//조회
            case IBSEARCH:      
                if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0094GS.do",FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
                }
                break;
                
            //체크조회(EQ No)
			case IBSEARCH_ASYNC01:
				//2020-01-25 : 조회시 체크는 필요없을듯 하여 생략함.
				/*
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					var eqNo 			= formObj.eq_no.value; 
					var eqKndCd 		= formObj.eq_knd_cd.Code;
					
					var retArray = MnrGeneralCodeCheck(sheetObj,"EQN",eqNo + "," + eqKndCd);      
					 					
					if(retArray == null){ 	 
						ComShowCodeMessage("MNR00165",eqNo,"EQ No.");          				
						ComSetObjValue(formObj.eq_no, "");  	    
						ComSetFocus(formObj.eq_no); 
						return; 	     	          
					} 
				}
				*/		
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		// 조회시 체크
    		if (sAction == IBSEARCH) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {
    				return false;
    			}
    		}
    		//EQ No Validation 체크
    		else if (sAction == IBSEARCH_ASYNC01) {
				//EQ_TYPE 선택유무 체크 
    			var eqKndCd = formObj.eq_knd_cd.Code;
				if(eqKndCd == "" || eqKndCd == "A"){
					ComShowCodeMessage("MNR00119"); 
					ComSetObjValue(formObj.eq_no, "");     
					formObj.eq_knd_cd.focus();
					return false;	   	 
				} 
    		}
        }
        return true;
    }

