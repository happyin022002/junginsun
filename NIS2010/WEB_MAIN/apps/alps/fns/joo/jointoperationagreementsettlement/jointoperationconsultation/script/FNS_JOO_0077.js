/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0077.js
*@FileTitle : AR Data Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.08 장강철
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
     * @class FNS_JOO_0077 : FNS_JOO_0077 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0077() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    /* 개발자 작업   */


    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
	var prefix = "sheet_1";

    var comboObjects = new Array();
    var comboCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             
             var sheetObject1 = sheetObjects[0];
             
             /*******************************************************/
             var formObject = document.form;
             var doc        = document.all;
       //     try {
                var srcName = window.event.srcElement.getAttribute("name");

                    switch(srcName) {

                        case "btn_Retrieve":
                            var objSheet;
 
                            if( formObject.re_divr_cd[0].checked == true){
                                if( formObject.sum_yn.checked == true){
                                    objSheet = sheetObjects[0];
                                }else{
                                    objSheet = sheetObjects[1];
                                }
                            }else if( formObject.re_divr_cd[1].checked == true){
                                if( formObject.sum_yn.checked == true){
                                    objSheet = sheetObjects[0];
                                }else{
                                    objSheet = sheetObjects[1];
                                }
                            }
                            doActionIBSheet( objSheet,document.form,IBSEARCH);
                            break;
                        
                        case "btn_New":
                            doActionIBSheet(sheetObjects[0],document.form,IBRESET);
                            break;
       
                        case "btn_DownExcel":
                            var paramObj = new Object();
                            paramObj.cols = 10;
                            var objSheet;
 
                            if( formObject.re_divr_cd[0].checked == true){
                                if( formObject.sum_yn.checked == true){
                                    objSheet = sheetObjects[0];
                                }else{
                                    objSheet = sheetObjects[1];
                                }
                            }else if( formObject.re_divr_cd[1].checked == true){
                                if( formObject.sum_yn.checked == true){
                                    objSheet = sheetObjects[0];
                                }else{
                                    objSheet = sheetObjects[1];
                                }
                            }
                            var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
                            objSheet.SpeedDown2Excel(-1, false,false, "", url );           
                            break;
                            
                } // end switch
//            }catch(e) {
//                if( e == "[object Error]") {
//                    ComShowMessage(OBJECT_ERROR);
//                } else {
//                    ComShowMessage(e);
//                }
//            }
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
         * IBCombo Object를 배열로 등록
         * param : combo_obj ==> 콤보오브젝트
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */ 
        function setComboObject(combo_obj) {  
            comboObjects[comboCnt++] = combo_obj;  
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
            // IBMultiCombo초기화
            for(var k=0; k<comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }         
            initControl();
            
        }
         function sheet1_OnLoadFinish(sheetObj) {
             doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
         }        
        
         /**
         * Combo 기본 설정
         * Combo의 항목을 설정한다.
         * @param comboObj 
         * @param comboIndex Number
         */
        function initCombo(comboObj, comboNo ) {
            var formObject = document.form
            
            switch(comboObj.id) {  
                case "jo_crr_cd":  
                    with (comboObj) { 
                        MultiSelect = false; 
                        UseAutoComplete = true;    
                        SetColAlign("left");        
                        SetColWidth("60");
                        DropHeight = 160;
                        ValidChar(2,0);
                        MaxLength = 3;
                     }  
                     break;       
                case "cb_ofc_cd":  
                    with (comboObj) { 
                        MultiSelect = false; 
                        UseAutoComplete = true;    
                        SetColAlign("left");        
                        SetColWidth("60");
                        DropHeight = 160;
                        ValidChar(2,0);
                        MaxLength = 6;
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
            var formObject = document.form;
            axon_event.addListenerForm  ('keydown' , 'ComKeyEnter',  formObject);  
            axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );
            
            axon_event.addListener      ('click',   'fnDocClick', "btn_yrmon_fr_back"       );         
            axon_event.addListener      ('click',   'fnDocClick', "btn_yrmon_fr_next"       );  
            axon_event.addListener      ('click',   'fnDocClick', "btn_yrmon_to_back"  );  
            axon_event.addListener      ('click',   'fnDocClick', "btn_yrmon_to_next"  );
            axon_event.addListener      ('click',   'fnDocClick', "re_divr_cd"  );
            axon_event.addListener      ('click',   'fnDocClick', "sum_yn"  );
 
            
            axon_event.addListenerFormat('blur'   ,  'fnDeactivate',  formObject);  
            axon_event.addListenerFormat('focus'  ,  'fnActivate'  ,  formObject);           
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
                        style.height = 420;
                        // 전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 3, 100);

                       var HeadTitle1 = "|Seq.|Account\nMonth|Carrier|Carrier Full Name|Cur.|Amount|USD Amount";
                                                
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
 
                        //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,       true,       "Status");
                        InitDataProperty(0, cnt++ , dtData,         80,     daCenter,       true,       "Seq");
                        InitDataProperty(0, cnt++ , dtData,         80,     daCenter,       true,       "acct_yrmon",    false,        "",                     dfDateYm,           0,          true,       true);
                        InitDataProperty(0, cnt++ , dtData,         80,     daCenter,       true,       "jo_crr_cd2",     false,        "",                     dfNone,             0,          true,       true);
                        InitDataProperty(0, cnt++ , dtData,         300,    daLeft,       	true,       "jo_crr_cd_nm",  false,      "",                     dfNone,             0,          true,       true);
                        InitDataProperty(0, cnt++ , dtData,         80,     daCenter,       true,       "locl_curr_cd",  false,      "",                     dfNone,             0,          true,       true);
                        					
						InitDataProperty(0, cnt++ , dtData,         95,     daRight,        true,       "csr_locl_amt",  false,      "",                     dfFloat,2,            true,       true);
 						InitDataProperty(0, cnt++ , dtData,         95,     daRight,        true,       "stl_usd_amt",  false,      "",                     dfFloat,2,            true,       true);
                    }
                    break;   
					
					case 3:      // sheet3 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 420;
                        // 전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 3, 100);

                       var HeadTitle1 = "|Seq.|Account Month|Carrier|Carrier Full Name|Cur.|Amount|USD Amount";
                                                
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false);

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
 
                        //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,       true,       "Status");
                        InitDataProperty(0, cnt++ , dtSeq,                  80,     daCenter,       true,       "Seq");
                        InitDataProperty(0, cnt++ , dtData,                 80,     daCenter,       true,       "acct_yrmon",    false,        "",                     dfDateYm,           0,          true,       true);
                        InitDataProperty(0, cnt++ , dtData,                 80,     daCenter,       true,       "jo_crr_cd2",     false,        "",                     dfNone,             0,          true,       true);
                        InitDataProperty(0, cnt++ , dtData,                500,     daLeft  ,       true,       "jo_crr_cd_nm",  false,      "",                     dfNone,             0,          true,       true);
                        InitDataProperty(0, cnt++ , dtData,                 80,     daCenter  ,       true,       "locl_curr_cd",  false,      "",                     dfNone,             0,          true,       true);
                        					
						InitDataProperty(0, cnt++ , dtData,              95,     daRight,        true,       "csr_locl_amt",  false,      "",                     dfFloat,2,            true,       true);
 						InitDataProperty(0, cnt++ , dtData,              95,     daRight,        true,       "stl_usd_amt",  false,      "",                     dfFloat,2,            true,       true);
                    }
                    break;    
              case 2:      // sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 420;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle1 = "|Account\nMonth|Lane|VVD|Revenue\nMonth|Carrier|Item|Cur.|Amount|USD Amount|B/L No.|Transaction No.";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다.
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,       true,       "Status");
                    InitDataProperty(0, cnt++ , dtData,                 70,     daCenter,       true,      "acct_yrmon",    false,        "",                     dfDateYm,           0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 70,     daCenter,       true,      "rlane_cd",      false,        "",                     dfNone,             0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 80,     daCenter,       true,      "vvd"     ,      false,        "",                     dfNone,             0,          true,       true);                    
                    InitDataProperty(0, cnt++ , dtData,                 80,     daCenter,       true,      "rev_yrmon",     false,        "",                     dfDateYm,             0,          true,       true);                    
                    InitDataProperty(0, cnt++ , dtData,                 80,     daCenter,       true,      "jo_crr_cd2",     false,        "",                     dfNone,             0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 70,     daCenter,       true,      "jo_stl_itm_cd",  false,      "",                     dfNone,0,            true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 80,     daCenter,       true,      "locl_curr_cd",  false,       "",                     dfNone,0,            true,       true);
					InitDataProperty(0, cnt++ , dtData,              	120,    daRight,        true,      "csr_locl_amt",  false,        "",                dfNullFloat,2,            true,       true);
					InitDataProperty(0, cnt++ , dtData,              	120,    daRight,        true,      "stl_usd_amt",  false,      "",                     dfFloat,2,            true,       true);
					InitDataProperty(0, cnt++ , dtData,                 100,    daCenter,       true,      "jo_bil_no"    ,  false,      "",                     dfNone,0,            true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 120,    daCenter,       true,      "tran_no"      ,  false,      "",                     dfNone,0,            true,       true);
                }
                break;      
				
				 case 4:      // sheet4 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 420;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                   var HeadTitle1 = "|Month|Lane|VVD|Revenue Month|Carrier|Amount|USD Amount|Curr|Item|B/L No.|Transaction No.";
                                            
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,       true,       "Status");
                    InitDataProperty(0, cnt++ , dtData,                 70,     daCenter,       true,       "acct_yrmon",    false,        "",                     dfDateYm,           0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 70,     daCenter,       true,       "rlane_cd",      false,        "",                     dfNone,             0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 80,     daCenter,       true,       "vvd"     ,      false,        "",                     dfNone,             0,          true,       true);                    
                    InitDataProperty(0, cnt++ , dtData,                 80,     daCenter,       true,       "rev_yrmon",     false,        "",                     dfDateYm,             0,          true,       true);                    
                    
                    InitDataProperty(0, cnt++ , dtData,                 80,     daCenter,       true,       "jo_crr_cd2",     false,        "",                     dfNone,             0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,              	120,     daRight,        true,      "csr_locl_amt",  false,        "",                dfNullFloat,2,            true,       true);
					InitDataProperty(0, cnt++ , dtData,              	95,     daRight,        true,       "stl_usd_amt",  false,      "",                     dfFloat,2,            true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 85,     daCenter,        true,      "locl_curr_cd",  false,       "",                     dfNone,0,            true,       true);                    
                    InitDataProperty(0, cnt++ , dtData,                 70,     daCenter,        true,      "jo_stl_itm_cd",  false,      "",                     dfNone,0,            true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 100,     daCenter,       true,      "jo_bil_no"    ,  false,      "",                     dfNone,0,            true,       true);
                    InitDataProperty(0, cnt++ , dtData,                 120,     daCenter,       true,      "tran_no"      ,  false,      "",                     dfNone,0,            true,       true);
                }
                break;      
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            var doc = document.all;
                    switch(sAction) {
                        case    IBCLEAR:      //jo_crr_cd Combo List 
                                formObj.f_cmd.value = SEARCH01;            
                                var param =  FormQueryString(formObj);  
                                var sXml = sheetObj.GetSearchXml("FNS_JOO_0077GS.do", param);
 
                                var aXml   = sXml.split("|$$|");
                                ComXml2ComboItem( aXml[0], formObj.jo_crr_cd, "code","code" );
                                formObj.jo_crr_cd.InsertItem(0, "All", "All");
                                formObj.jo_crr_cd.Index = 0;
                                
                                ComXml2ComboItem( aXml[1], formObj.cb_ofc_cd, "code","code" );
                                formObj.cb_ofc_cd.InsertItem(0, "All", "All");
                                
                                formObj.cb_ofc_cd.Code2 = strOfc_cd;//세션.
                                formObj.sum_yn.checked = true;
                                break;                              
                                
                        case    IBSEARCH:      //조회						
                                if( !validateForm(sheetObj,formObj,sAction) ){return;}
                                formObj.f_cmd.value = SEARCHLIST01;            
                                var param =  FormQueryString(formObj);  
 
                                
                                sheetObj.WaitImageVisible=false;
                                ComOpenWait(true);
                                sheetObj.LoadSearchXml(sXml);
								
								var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
								var sXml = sheetObj.GetSearchXml("FNS_JOO_0077GS.do" , SaveStr + "&" + FormQueryString(formObj));
				    			var arrXml = sXml.split("|$$|");	
								
								sheetObjects[0].RemoveAll();
								sheetObjects[1].RemoveAll();
								sheetObjects[2].RemoveAll();
								sheetObjects[3].RemoveAll();
								
								if (arrXml.length > 0) {	
									if (formObj.sum_yn.checked == true) {
										sheetObjects[0].LoadSearchXml(arrXml[0]);			
										sheetObjects[2].LoadSearchXml(arrXml[1]);	
									}		
												
									if (formObj.sum_yn.checked != true) {
										sheetObjects[1].LoadSearchXml(arrXml[0]);			
										sheetObjects[3].LoadSearchXml(arrXml[1]);
									}	
				 	   	  		}
                                ComOpenWait(false);
                                break;
                                
                        case    IBRESET:   
   
                                formObj.re_divr_cd[0].checked = true;
                                formObj.jo_crr_cd.Code2       = '';
                                formObj.sum_yn.checked        = true;
                                formObj.sum_yn.fireEvent("onclick");
                                sheetObjects[0].CellValue(0, "acct_yrmon") = "Acct Month";
                                fnBtnNew();   
                                formObj.yrmon_fr.value = yyyyMM;
                                formObj.yrmon_to.value = yyyyMM;                       
                                break;     
                    }
        }
   
         /**
         * 년월 NAVI 처리 이벤트 
         * @param void
         * @return void
         */
         function fnDocClick(){
             var obj = event.srcElement;
             var formObj = document.form;
             var doc = document.all;
 
             switch (obj.name){

                 case "btn_yrmon_fr_back":
                     if (formObj.yrmon_fr.value != "" ){
                         formObj.yrmon_fr.value = ComGetDateAdd(formObj.yrmon_fr.value+"-01","M",-1).substring(0,7);    
                     }

                     fnBtnNew();              
                 
                     break;
                case "btn_yrmon_fr_next":
                     if (formObj.yrmon_fr.value != "" ){
                        formObj.yrmon_fr.value = ComGetDateAdd(formObj.yrmon_fr.value+"-01","M",+1).substring(0,7);    
                     }
                     fnBtnNew();                      
              
                     break;
                case "btn_yrmon_to_back":
                    if (formObj.yrmon_to.value != "" ){
                        formObj.yrmon_to.value = ComGetDateAdd(formObj.yrmon_to.value+"-01","M",-1).substring(0,7);    
                    }
                    fnBtnNew();                
           
                    break;
               case "btn_yrmon_to_next":
                    if (formObj.yrmon_to.value != "" ){
                       formObj.yrmon_to.value = ComGetDateAdd(formObj.yrmon_to.value+"-01","M",+1).substring(0,7);    
                    }
                    fnBtnNew();                       
              
                    break; 
               case "re_divr_cd":
                    
                   if( formObj.re_divr_cd[0].checked == true){
                       sheetObjects[0].CellValue(0, "acct_yrmon") = "Acct Month";
 
                   }
                   if( formObj.re_divr_cd[1].checked == true){
                       sheetObjects[0].CellValue(0, "acct_yrmon") = "Rev Month";
                  
                       var objFire = eval('doc.btn_yrmon_fr_back');
                       fnSameFdateTdate( objFire  );
                   }  
                   fnBtnNew();
                   break;
               case "sum_yn": 
                   if( formObj.re_divr_cd[0].checked == true){
                       if( formObj.sum_yn.checked == true){
                           doc.sheet_acct_summary.style.display = "";
                           doc.sheet_acct_detail.style.display  = "none";
                       }else{
                           doc.sheet_acct_summary.style.display = "none";
                           doc.sheet_acct_detail.style.display  = "";
                       }
                   }else if( formObj.re_divr_cd[1].checked == true){
                       if( formObj.sum_yn.checked == true){
                           doc.sheet_acct_summary.style.display = "";
                           doc.sheet_acct_detail.style.display  = "none";
                       }else{
                           doc.sheet_acct_summary.style.display = "none";
                           doc.sheet_acct_detail.style.display  = "";
                       } 
                   }                   
                   fnBtnNew();
                   break;
             }
             fnSameFdateTdate(obj);
         }
        /**
         * fdate와 tdate 같게 처리
         */
        function fnSameFdateTdate(obj){ 

            var obj = event.srcElement;
            var formObj = document.form;
            var fireObjName = "";
            var targObjName = "";
            
            if( formObj.re_divr_cd[1].checked == false){
                return;    
            }
  
            switch(obj.name){
                   case "btn_yrmon_fr_back":
                        fireObjName="yrmon_fr";
                        break;
                   case "btn_yrmon_fr_next":
                        fireObjName="yrmon_fr";
                        break;
                   case "btn_yrmon_to_back":
                        fireObjName="yrmon_to";
                        break;
                   case "btn_yrmon_to_next":
                        fireObjName="yrmon_to";
                        break;
                         
                   case "yrmon_fr":
                        fireObjName="yrmon_fr";
                        break;
                       
                   case "yrmon_to":
                        fireObjName="yrmon_to";
                        break;                
            }
            if( fireObjName != ""){
                if( fireObjName == "yrmon_fr"){
                    targObjName = "yrmon_to";
                }else  if( fireObjName == "yrmon_to"){
                    targObjName = "yrmon_fr";
                }
                var objFir   = eval('formObj.'+fireObjName);
                var objTar   = eval('formObj.'+targObjName);
 
                objTar.value = objFir.value;
            }
        }
        /**
        * NEW 버튼 처리 
        * @param    void
        * @return   void
        */    
        function fnBtnNew(){
            var formObj = document.form;
        
            if( sheetObjects[0].RowCount > 0) {
                sheetObjects[0].RemoveAll();
                sheetObjects[2].RemoveAll();
            }
            if( sheetObjects[1].RowCount > 0) {
                sheetObjects[1].RemoveAll();
                sheetObjects[3].RemoveAll();
            }
        }   
         /**
          * <pre>
          *    form Element의 KeyPress Event 발생시 처리.
          *    
          * </pre>
          * @return
          */
         function fnObjKeyPress(){
             var obj = event.srcElement;
             var formObj = document.form;
             switch (obj.name){
                    case   'yrmon_fr':
                           ComKeyOnlyNumber( obj );
                           break;
                            
                    case   'yrmon_to':
                           ComKeyOnlyNumber( obj );
                           break;               
             }
 
         }
        /**
         * <pre>
         *     form element의 dataformat을 이용한 입력 Validate 처리,
         *     focus 잃었을때발생.
         * </pre>
         * 
         * @return void
         */ 
        function fnDeactivate(){ 
            switch(event.srcElement.name){
                case 'yrmon_fr':
                    ComAddSeparator(event.srcElement);
                    break;
                case 'yrmon_to':
                    ComAddSeparator(event.srcElement);
                    break;        
            }
            fnSameFdateTdate(event.srcElement);
        }
         /**
          * <pre>
          *     form element의 dataformat을 이용한 입력 Validate 처리,
          *     focus 얻었을때발생.
          * </pre>
          * 
          * @return void
          */ 
         function fnActivate(){
             switch(event.srcElement.name){
                 case 'yrmon_fr':
                     ComClearSeparator(event.srcElement);
                     break;
                 case 'yrmon_to':
                     ComClearSeparator(event.srcElement);
                     break;

             }
             fnSameFdateTdate(event.srcElement);
             event.srcElement.select();
         }        
 
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
    
            with(formObj){
                switch ( sAction ){
                     case IBSEARCH :
                           if (!ComChkValid(formObj)) return false;
                           
                           if( formObj.re_divr_cd[1].checked == true ){
                               if( yrmon_fr.value != yrmon_to.value  ){
                                   yrmon_fr.value  = yrmon_to.value; 
                               }
                           }
                           break;
                }
            }

            return true;
        }
		
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj)
		{
			//ShowSubSum("locl_curr_cd", "6|7", -1, false, false,-1, "acct_yrmon=Sub-Total");
		}
}
		
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj)
	{
		var formObj = document.form;
		for(i=sheetObj.LastRow; i > 0 ; i--){
			if ((formObj.re_divr_cd.value = "E") && (formObj.sum_yn.checked == true)) {	
				var addRow = sheetObjects[0].DataInsert(-1);
				sheetObjects[0].cellValue(addRow,"acct_yrmon") = "TOTAL";
				sheetObjects[0].cellValue(addRow,"locl_curr_cd") = sheetObjects[2].CellValue(i, "locl_curr_cd");	
				sheetObjects[0].cellValue(addRow,"csr_locl_amt") = sheetObjects[2].CellValue(i, "csr_locl_amt");	
				sheetObjects[0].cellValue(addRow,"stl_usd_amt") = sheetObjects[2].CellValue(i, "stl_usd_amt");				
				sheetObjects[0].RowBackColor(addRow) = sheetObj.RgbColor(247,225,236);	//색상설정
				sheetObjects[0].CellFont("FontBold", addRow, "acct_yrmon") = true;		//글자체 굵기설정
				sheetObjects[0].CellFont("FontBold", addRow, "locl_curr_cd") = true;	//글자체 굵기설정
				sheetObjects[0].CellFont("FontBold", addRow, "csr_locl_amt") = true;	//글자체 굵기설정
				sheetObjects[0].CellFont("FontBold", addRow, "stl_usd_amt") = true;		//글자체 굵기설정
				sheetObjects[0].CellValue(addRow, "Seq") = "";				
			} else if ((formObj.re_divr_cd.value = "E") && (formObj.sum_yn.checked != true)) {		
				var addRow = sheetObjects[0].DataInsert(-1);		
				sheetObjects[0].cellValue(addRow,"acct_yrmon") = "TOTAL";
				sheetObjects[0].cellValue(addRow,"locl_curr_cd") = sheetObjects[2].CellValue(i, "locl_curr_cd");	
				sheetObjects[0].cellValue(addRow,"csr_locl_amt") = sheetObjects[2].CellValue(i, "csr_locl_amt");	
				sheetObjects[0].cellValue(addRow,"stl_usd_amt") = sheetObjects[2].CellValue(i, "stl_usd_amt");				
				sheetObjects[0].RowBackColor(addRow) = sheetObj.RgbColor(247,225,236);	//색상설정
				sheetObjects[0].CellFont("FontBold", addRow, "acct_yrmon") = true;		//글자체 굵기설정
				sheetObjects[0].CellFont("FontBold", addRow, "locl_curr_cd") = true;	//글자체 굵기설정
				sheetObjects[0].CellFont("FontBold", addRow, "csr_locl_amt") = true;	//글자체 굵기설정
				sheetObjects[0].CellFont("FontBold", addRow, "stl_usd_amt") = true;		//글자체 굵기설정
				sheetObjects[0].CellValue(addRow, "Seq") = "";
			}			
				if (sheetObjects[2].CellValue(i, "locl_curr_cd") == "")  {
					sheetObjects[0].RemoveAll();
				}
		}
		for(i=sheetObjects[0].LastRow; i > 0 ; i--){
			if (sheetObjects[0].CellValue(i, "acct_yrmon") == "TOTAL") {
				sheetObjects[0].cellValue(i+1,"acct_yrmon") = "";
			} else {
				sheetObjects[0].CellValue(i, "Seq") = i;
			}
		}
	}
}
		
function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj)
	{
		var formObj = document.form;
		for(i=sheetObj.LastRow; i > 0 ; i--){
			if ((formObj.re_divr_cd.value = "R") && (formObj.sum_yn.checked == true)) {
				var addRow = sheetObjects[1].DataInsert(-1);
				sheetObjects[1].cellValue(addRow,"acct_yrmon") = "TOTAL";
				sheetObjects[1].cellValue(addRow,"locl_curr_cd") = sheetObjects[3].CellValue(i, "locl_curr_cd");	
				sheetObjects[1].cellValue(addRow,"csr_locl_amt") = sheetObjects[3].CellValue(i, "csr_locl_amt");	
				sheetObjects[1].cellValue(addRow,"stl_usd_amt") = sheetObjects[3].CellValue(i, "stl_usd_amt");				
				sheetObjects[1].RowBackColor(addRow) = sheetObj.RgbColor(247,225,236);	//색상설정
				sheetObjects[1].CellFont("FontBold", addRow, "acct_yrmon") = true;		//글자체 굵기설정
				sheetObjects[1].CellFont("FontBold", addRow, "locl_curr_cd") = true;	//글자체 굵기설정
				sheetObjects[1].CellFont("FontBold", addRow, "csr_locl_amt") = true;	//글자체 굵기설정
				sheetObjects[1].CellFont("FontBold", addRow, "stl_usd_amt") = true;		//글자체 굵기설정
				sheetObjects[1].CellValue(addRow, "Seq") = "";
			} else if ((formObj.re_divr_cd.value = "R") && (formObj.sum_yn.checked != true)) {
				var addRow = sheetObjects[1].DataInsert(-1);
				sheetObjects[1].cellValue(addRow,"acct_yrmon") = "TOTAL";
				sheetObjects[1].cellValue(addRow,"locl_curr_cd") = sheetObjects[3].CellValue(i, "locl_curr_cd");	
				sheetObjects[1].cellValue(addRow,"csr_locl_amt") = sheetObjects[3].CellValue(i, "csr_locl_amt");	
				sheetObjects[1].cellValue(addRow,"stl_usd_amt") = sheetObjects[3].CellValue(i, "stl_usd_amt");				
				sheetObjects[1].RowBackColor(addRow) = sheetObj.RgbColor(247,225,236);	//색상설정
				sheetObjects[1].CellFont("FontBold", addRow, "acct_yrmon") = true;		//글자체 굵기설정
				sheetObjects[1].CellFont("FontBold", addRow, "locl_curr_cd") = true;	//글자체 굵기설정
				sheetObjects[1].CellFont("FontBold", addRow, "csr_locl_amt") = true;	//글자체 굵기설정
				sheetObjects[1].CellFont("FontBold", addRow, "stl_usd_amt") = true;		//글자체 굵기설정
				sheetObjects[1].CellValue(addRow, "Seq") = "";
			}
				if (sheetObjects[3].CellValue(i, "locl_curr_cd") == "")  {
					sheetObjects[1].RemoveAll();
				}
		}
		for(i=sheetObjects[1].LastRow; i > 0 ; i--){
			if (sheetObjects[1].CellValue(i, "acct_yrmon") == "TOTAL") {
				sheetObjects[1].cellValue(i+1,"acct_yrmon") = "";
			} else {
				sheetObjects[1].CellValue(i, "Seq") = i;
			}
		}
		//formObj.yrmon_fr.focus();
	}
}
       /* 개발자 작업  끝 */