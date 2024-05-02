/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7002.js
*@FileTitle : DEM/DET Office Inquiry by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.13 mun jung cheol
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
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
     * @class EES_DMT_7002 : EES_DMT_7002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_7002() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

    //  업무전역변수
    var COUNTRY     = "CNT";
    var LOCATION    = "LOC";
    var YARD        = "YD";
    
    var ROWMARK     = "|";
    var FIELDMARK   = "=";
    
    var ORIGIN = "Origin";
    var DESTINATION = "Destination";

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

                    case "btn_retrieve":
                        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                        break;

                    case "btn_new":
                    var formObj = document.form;
                    ComResetAll();
                    doActionIBCombo(sheetObjects[0],formObj,comboObjects[0],SEARCHLIST02);
                    doActionIBCombo(sheetObjects[0],formObj,comboObjects[1],SEARCH02);
                        break;

                    case "btn_downExcel":
                        sheetObjects[0].speedDown2Excel(-1);
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

    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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

        // IBMultiCombo초기화 
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }

        //html컨트롤 이벤트초기화
        initControl();
    }

   // 이벤트 처리 함수 선언
    function initControl() {
        axon_event.addListenerFormat('keypress','obj_keypress', document.form);         //- 키보드 입력할때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');    // 'Incl. CNTR Column' CheckBox 클릭시
    }
     
    //포커스가 나갈 때
    function obj_blur(){
        
        //입력Validation 확인하기 + 마스크구분자 넣기
        var obj = event.srcElement;
       
        if(obj.value.length > 0 && obj.value.length < 5) {
            ComShowCodeMessage('DMT00110', 'Location');
            ComClearObject(obj);
            ComSetFocus(obj);
        }        
        ComChkObjValid(obj);
    }
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        var obj = event.srcElement;
        ComClearSeparator(obj);
        
        //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
    
    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
         switch(event.srcElement.dataformat){
            case "engup":
                // 영문대
                ComKeyOnlyAlphabet('upper');
                break;
    	 	case "engnum":
		    	// 영대문자+숫자 
         		ComKeyOnlyAlphabet('uppernum');
		        break;
            case "int":
                //숫자 만입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                // 숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
         }
     }
    
    /*
     * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
     */
    function doInclSubOfc() {
          var formObj = document.form;
    
          if (formObj.chk_sub_ofc.checked) { // Sub Office 포함
              if (ComIsEmpty(comboObjects[0].Code)) {
                  ComShowCodeMessage('COM12113', "DEM/DET Office");
                  formObj.chk_sub_ofc.checked = false;
                  return;
              }

              formObj.ofc_cd.value = ComGetObjValue(comboObjects[0]);
              formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[0]);
              doActionIBCombo( sheetObjects[0] , formObj , comboObjects[0] , IBSEARCH_ASYNC03);
          } else {
              ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);
          }
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
                    style.height = 425;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle1 = "Seq.|DMT OFC|I/B|O/B|YD Code|Yard Name|Del.|Character|Marine|CY|CFS|Rail|Barge|Pseudo|CTRL OFC";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtSeq  , 35  , daCenter , true , "seq"       , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 60  , daCenter , true , "dmtofc"    , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 40  , daCenter , true , "ib"        , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 40  , daCenter , true , "ob"        , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 70  , daCenter , true , "ydcode"    , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 300 , daLeft   , true , "yardname"  , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 35  , daCenter , true , "del"       , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 75  , daCenter , true , "character" , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 50  , daCenter , true , "marine"    , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 30  , daCenter , true , "cy"        , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 30  , daCenter , true , "cfs"       , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 30  , daCenter , true , "rail"      , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 50  , daCenter , true , "barge"     , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 55  , daCenter , true , "pseudo"    , false , "" , dfNone );
                    InitDataProperty( 0 , cnt++ , dtData , 60  , daCenter , true , "ctrlofc"   , false , "" , dfNone );
                    //CountPosition = 0;
                }
            break;
        }
    }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)) return;
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("EES_DMT_7002GS.do", FormQueryString(formObj));
            break;
                
         }
     }
     
     /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
        var formObj = document.form;
        
        switch(comboObj.id) {  
        
            case "office": 
                with (comboObj) { 
                    //MultiSelect = false;
                    UseAutoComplete = true;
                    SetColAlign("left");
                    DropHeight = 160;
                    ColBackColor(0) = "white";
                    ColBackColor(1) = "white";
                    ValidChar(2); // 영어대문자 사용
                    MaxLength = 5;
                }
                doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
            break;
            
            case "combo3":
                with (comboObj) {
                    MultiSelect = false;
                    UseAutoComplete = true;
                    SetColAlign("left|left");        
                    SetColWidth("30|300");
                    DropHeight = 160;
                    ValidChar(2,0);     //영문 대문자
                    IMEMode = 0;
                    MaxLength = 2;
                    ColBackColor(0) = "white";
                    ColBackColor(1) = "white";
                }
                doActionIBCombo(sheetObjects[0],formObj,comboObj,SEARCH02);
                
            break;
            
            case "combo5":
                with (comboObj) {
                    MultiSelect = false; 
                    UseAutoComplete = true;    
                    SetColAlign("left");
                    SetColWidth("50");
                    DropHeight = 160;
                    ValidChar(2,1);     //영문 대문자, 숫자
                    MaxLength = 2;
                }
                comboObj.InsertItem(0, "", "");
            break;
        }
    }
   
   
    // IBCombo 데이터 조회 및 세팅
    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
         sheetObj.ShowDebugMsg = false;
         sheetObj.WaitImageVisible = false;
         
         formObj.f_cmd.value = formCmd;
         ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.yd_cd1));
         
         switch(formCmd) {
            case COMMAND06: // RHQ
                with (comboObj) { 
                    RemoveAll();
                    MultiSelect = false;
                    SetColWidth("45");
                    ValidChar(2);   // 영대문자만 사용
                    //MaxLength = 6;
                }
            
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var data = ComGetEtcData(sXml, "common_cd");
                if (data != undefined && data != '') {
                    var comboItems = data.split("|");
                    comboObj.InsertItem(0, "All", "All");
                    
                    for (var i = 0 ; i < comboItems.length ; i++) {
                        comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);     
                    }
                }
                break;
         
            case SEARCHLIST02: // Office
                with (comboObj) { 
                    RemoveAll();
                    MultiSelect = true;
                    SetColWidth("95");
                    ValidChar(2, 2); // 영대문자, 특수문자만 가능
                }
            
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var data = ComGetEtcData(sXml, "OFC_CD");
                
                if (data != undefined && data != '') {
					var usrOfcCd = ComGetObjValue(formObj.h_user_office);
 					var idx = 0;
 					
 					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx = 1;
 					}
 					
 		    	    var comboItems = data.split("|");
 		    	    for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
 		         	}
 	    	  		
 	    	  		// 로그인 User Office를 Default로 설정
	    	  		comboObj.Code = usrOfcCd;
				}
                break;
                
            case COMMAND01: // Incl. Sub Office
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
            	var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	    	 	
		 		if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd = ComGetObjValue(formObj.h_user_office);
					
					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds = usrOfcCd + ',' + subOfcCds;
	    	   			
					comboObj.Code = subOfcCds;
		 		}
		 		break;
                
            //Yard 입력완료시 Yard List 조회
            case SEARCH14:
            	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

                //Continent 콤보 Empty 상태로 초기화
            	comboObjects[2].Code = "-1";
            	comboObjects[2].RemoveAll();                      
            	
            	var comboDatas = ComGetEtcData(sXml, YARD);

                if (comboDatas == undefined ||comboDatas == "") {
                	ComShowCodeMessage('DMT00110','Location');
                    ComClearObject(formObj.yd_cd1);
                    ComSetFocus(formObj.yd_cd1);
                }else{
                    
                    var comboItems = comboDatas.split(ROWMARK);
                    addComboItem1(comboObjects[2],comboItems);    
                    setComboItem(comboObjects[2],comboItems);
                    
                }
                break;
                            
			//2. COUNTRY LIST
			case SEARCH02:
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var comboDatas = ComGetEtcData(sXml, COUNTRY);
                if (comboDatas != undefined ||comboDatas != "") {
                    var comboItems = comboDatas.split(ROWMARK);
                    addComboItem(comboObjects[1],comboItems); //COUNTRY
                }else{
                    ComShowCodeMessage("DMT06001");
                    clearObjectValue(sObj);
                }
                //comboObjects[1].Code = document.form.usr_cnt_cd.value;
                break;
                            
            case IBSEARCH_ASYNC03:      
                //3. Sub Office comboList
                formObj.f_cmd.value = COMMAND01;
                var sXml2 = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                var subOfcCds = ComGetEtcData(sXml2, "OFC_CD");
	    	 	
		 		if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd = ComGetObjValue(formObj.h_user_office);
					
					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds = usrOfcCd + ',' + subOfcCds;
	    	   			
					comboObj.Code = subOfcCds;
		 		}
		 		break;
        }
         
         sheetObj.WaitImageVisible = true;
    }
    
    // 'Incl. Sub Office' 체크박스가 체크된 상태에서  Office 멀티콤보를 선택하지 못하도록 한다.
    function office_OnCheckClick(comboObj, index, code) {
        var formObj = document.form;
        
        if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
    }
    
	// 멀티콤보 KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
     
 	
    function keyPress() {
        var eventKey = window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    document.onkeypress = keyPress ; 


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            formObj.demdetoff.value = ComGetObjValue(formObj.office);
            formObj.countrycd.value = ComGetObjValue(formObj.combo3);
            formObj.yardnodee.value = ComGetObjValue(formObj.combo5);
            formObj.yardlocat.value = ComGetObjValue(formObj.yd_cd1);
//            if ( formObj.demdetoff.value == "" && formObj.countrycd.value == "" && formObj.yardlocat.value == "" ) {
//                return false;
//            }
        }
        return true;
    }
    
    // 마우스가 Sheet 위에서 움직일 때 발생하는 Event
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y)
    {
        with(sheetObj)
        {
            var colName = ColSaveName(MouseCol);        // SaveName을 가져온다.
            var msg = "";
            switch(colName)
            {
                case "dmtofc":
                    msg = "DEM/DET Office";
                    break;
                
                case "ib":
                    msg = "I/B Collection";
                    break;
                    
                case "ob":
                    msg = "O/B Collection";
                    break;
                    
                case "del":
                    msg = "Yard Delete Flag";
                    break;
                    
                case "marine":
                    msg = "Marine Terminal";
                    break;
                    
                case "rail":
                    msg = "Rail Ramp";
                    break;
                    
                case "barge":
                    msg = "Barge Ramp";
                    break;
                
                default:
                    msg = "";
                    break;
            }
            
            MouseToolTipText = msg;     // ToolTip의 내용 설정
            
        }
    }
    
    /*
     * yd_cd1 조회필드에서 LOCATION에 해당하는 YARD 정보를 조회하는 함수
     */     
    function checkYard1(obj) {
        if(isAlphaNum()) {
            checkYard1_sub2(obj);
        }
    }
    
    /*
     * yd_cd1 입력시 yd_cd list를 조회한다.
     */
    function checkYard1_sub2(obj) {
        var formObj = document.form;
        var yardCd1 = ComTrim(ComGetObjValue(obj));
        if (yardCd1.length == 5) {
            doActionIBCombo(sheetObjects[0],formObj,comboObjects[1],SEARCH14);
        }
    }
    
function combo3_OnBlur(){
//     alert( ComGetObjValue(comboObjects[1]) );
}
     
    /**
     * 콤보필드에 데이터를 추가해준다.
     */ 
    function addComboItem(comboObj, comboItems) {
        for (var i = 0 ; i < comboItems.length ; i++) {
            var comboItem = comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);        
        }           
    }
     
    /**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */ 
    function setComboItem(comboObj,comboItems) {
        var checkedItem = comboItems[0].split(FIELDMARK);
        comboObj.Text = checkedItem[0];
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */ 
    function addComboItem1(comboObj, comboItems) {
        for (var i = 0 ; i < comboItems.length ; i++) {
            var comboItem = comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[1], comboItem[0]);     
        }           
    }
    /* 개발자 작업  끝 */