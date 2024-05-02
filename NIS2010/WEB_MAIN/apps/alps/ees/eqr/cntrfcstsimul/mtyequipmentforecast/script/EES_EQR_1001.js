/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1001.js
*@FileTitle : OP/MG Forecast Input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
* ======================================================
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1001 : EES_EQR_1001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_EQR_1001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.setTabObject 			= setTabObject;
    	this.sheet1_OnPopupClick = sheet1_OnPopupClick;	
    }
    // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var IBSEARCH01  = 29;
    var IBSEARCH02  = 30;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var HeadTitleCnt = 0;
    var yyyyMm = "";

    var focFlag1 = true;	//스크롤 제어용
    var focFlag2 = true;
    var mainXml = "";
    
    var saveFlag = "0";		//세이브 버튼 및 시트 수정  제어용(0,1,2,3)
    
    var comboObjects = new Array();
    var comboCnt = 0 ;

    var tmpWk = "";
	var popupEditFlg = "N"; // +Other 가 popup 화면에 의하여 변경 되었는지 판단
	
	var refe2kind = ""; // BKG,COP
	
	// -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //     
    var tpszallText = "D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"; 
    var tpszallCode = "D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"; 
    var tpszdryText = "D2|D4|D5|D7";    // DRY TYPE SIZE
    var tpszdryCode = "D2|D4|D5|D7";
    var tpszrfrText = "R2|R5|R9";       // RFR TYPE SIZE
    var tpszrfrCode = "R2|R5|R9";
    var tpszotText  = "O2|S2|O4|S4|O5"; // OT  TYPE SIZE 
    var tpszotCode  = "O2|S2|O4|S4|O5";
    var tpszfrText  = "F2|A2|F4|A4|F5|A5"; // FR  TYPE SIZE 
    var tpszfrCode  = "F2|A2|F4|A4|F5|A5"; 
    
    var consTpsz      = "D2,D4,D5,D7,R2,R5,R9,O2,S2,O4,S4,O5,F2,A2,F4,A4,F5,A5";
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = "D2,D4,D5,D7";
    var consTpszRfr   = "R2,R5,R9";
    var consTpszOt    = "O2,S2,O4,S4,O5";
    var consTpszFr    = "F2,A2,F4,A4,F5,A5";
    // -- Cntr Tpsz 콤보 하드코딩으로 변경 -- //
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var shtCnt = 0;
    	var sheet1 = sheetObjects[shtCnt];
    	var formObject = document.form;
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {
			
			case "btn_new":		//조회조건 초기화
				sheetObjects[0].Redraw = false;
				initSheet(sheetObjects[0],1);     // 해더 타이틀까지 새로하기 위함
				sheetObjects[0].Redraw = true;
				sheetObjects[1].Redraw = false;
				sheetObjects[1].RemoveAll();
				initSheet2(sheetObjects[1]);      //초기 sheet2 디지인 세팅
				sheetObjects[1].Redraw = true;
				sheetObjects[2].Redraw = false;
                initSheet(sheetObjects[2],3);     // 해더 타이틀까지 새로하기 위함
                sheetObjects[2].Redraw = true;
				
				formObject.reset();
                document.form.cntrTpsz.selectedIndex = 1; // Dry 선택
                tpszChange('D'); // Dry 선택
				document.form.init_flag.value = "INIT";
				ComSetFocus(document.form.loc_cd);
				break;
				
    		case "btn_Retrieve":
    			if (doActionIBSheet(sheetObjects[0], formObject, IBSEARCH)) {
					doActionIBSheet(sheetObjects[1], formObject, SEARCH04);
					
				}
                initSheet(sheetObjects[2],3); // 해더 타이틀까지 새로하기 위함
				
    			break;
    		
			case "btn_save":
    			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
    			break;
				
    		case "btn_downExcel":
				sheetObjects[0].Down2Excel(-1,false,true,true,"","",false,false,"",true,"w1_img|w2_img|w3_img|w4_img|w5_img|w6_img|w7_img|w8_img|w9_img");
				sheetObjects[1].Down2Excel(-1,true,true,true,"","",false,false,"",true,"");
				sheetObjects[2].Down2Excel(-1,true,true,true,"","",false,false,"",true,"");
    			break;
				
			case "btn_loc_cd":	//Location 조회 팝업
				var code_type = formObject.loc_grp_cd.value;

				if(code_type == "E") {
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd", "0,1,1,1,1,1", true);
				}else if(code_type == "S") {	
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
    		    }else if(code_type == "L"){
    		    	ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "lcc_cd:loc_cd", "0,1,1,1,1,1", true);
    		    }
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
     * 초기 이벤트 등록 
     */
    function initControl() {
     	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');							//LOC_CD keyup 이벤트 처리
     	axon_event.addListener('keyup', 'from_bse_dt_onkeyUp', 'from_bse_dt');					//from_bse_dt keyup 이벤트 처리
     	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
     	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				//form OnBeforeDeactivate이벤트에 코드 처리
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');								//엔터키 조회 이벤트처리
     	axon_event.addListenerForm('click', 'viewFlag_click', form);							//DRY,SPLC(RF, OT, FR), ALL 체크시 이벤트 정의
     	axon_event.addListener('blur', 'obj_blur', 'loc_cd');									//Location  blur 이벤트 처리
     	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
        axon_event.addListenerForm('change','form_change',form);
    }    
    
	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
				break;
			case "fcast_yrwk":
				ComKeyOnlyNumber(event.srcElement);// 알파벳 대문자,숫자만 입력허용
				if ( formObject.fcast_yrwk.value.length == 4 ) {
					document.form.fcast_yrwk.value = document.form.fcast_yrwk.value.substr(0,4)+"-";
				}
				if ( formObject.fcast_yrwk.value.length == 7 ) {
					formObject.fcast_yrwk.value = ComGetMaskedValue(formObject.fcast_yrwk.value,   "ym");
				}
				break;
		}
	}
    
	/**
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
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
     * 설  명 : IBCombo Object를 배열로 등록 <br>
     *          향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     *          배열은 소스 상단에 정의<br>
     * <br><b>Example : </b>
     * <pre>
     *     setComboObject(combo_obj)
     * </pre>
     * @param {object}  combo_obj - Combo Object
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * LOC_CD keyup 이벤트 처리
     * LOC_CD keyup시 대분자로 처리
     */
	function loc_cd_onkeyUp() {
		var formObject = document.form;
		document.getElementById("loc_cd").setAttribute("maxLength",5);
		if ( formObject.loc_cd.value.length == 5 ) { 
			if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
				ComSetFocus(document.form.fcast_yrwk);
			}
		}
	}
	
    /**
     * Balance Report ID  beforeactivate 이벤트 처리
     * Balance Report ID  beforeactivate -없애기
     */    
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	
	/**
	 * Balance Report ID  beforedeactivate 이벤트 처리
	 * Balance Report ID  beforedeactivate YYYY-MM 포멧 처리
	 */	
	function obj_deactivate() {
		ComClearSeparator(event.srcElement);
		obj = event.srcElement;
		if (obj.name == "fcast_yrwk") {
			if ( document.form.fcast_yrwk.value !='' ) {
				ComAddSeparator(event.srcElement);
			}
		}
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
            sheetObjects[i].Visible = true;
        }
        initControl();
        document.form.init_flag.value = 'INIT';
        ComSetFocus(document.form.loc_cd);
		
		for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
		
		document.form.cntrTpsz.selectedIndex = 1; // Dry 선택
        tpszChange('D'); // Dry 선택
        
        // 0주차로 스크롤 이동 ()  
        sheetObjects[0].LeftCol = 58;  
        //sheetObjects[0].LeftCol = 40;  
	}

	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
	    var shtID = sheetObj.id;
	
        if(( comboObjects[0].Text == null || comboObjects[0].Text == "")){
            tpszArr = tpszallText.split("|");
        } else {
            tpszArr = (comboObjects[0].Text).split(",") ;
        }
	
	    switch(shtID) {
	    	case "sheet1":      //sheet1 init
	    		with (sheetObj) {
	    			   // 높이 설정
	    			   style.height = 310;
	                   //전체 너비 설정
	                   SheetWidth = mainTable1.clientWidth;
					   AutoSizeMode = true;
	                   //Host정보 설정[필수][HostIp, Port, PagePath]
	                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                   //전체Merge 종류 [선택, Default msNone]
	                   MergeSheet = msPrevColumnMerge;

	                   //전체Edit 허용 여부 [선택, Default false]
	                   Editable = true;

	                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                   InitRowInfo(2, 1, 22, 100);
	                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                   InitHeadMode(false, false, false, false, false,false);
                       //InitHeadMode(true, true, true, true, false,false);

	                   // headTitle = "Week|Title|Title||G.TTL|D.TTL|D2|D4|D5|D7|S.TTL|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|||||||";
					   headTitle1 = "Title|Title"
					                +"|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)|Week (-3)"
                                    +"|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)|Week (-2)"
                                    +"|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)|Week (-1)"
                                    +"|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)|Week (0)"
                                    +"|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)|Week (+1)"
                                    +"|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)|Week (+2)"
                                    +"|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)|Week (+3)"
                                    +"|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)|Week (+4)"
                                    +"|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)|Week (+5)"
					                +"|w1_wk|w2_wk|w3_wk|w4_wk|w5_wk|w6_wk|w7_wk|w8_wk|w9_wk"
									+"|w1_f|w2_f|w3_f|w4_f|w5_f|w6_f|w7_f|w8_f|w9_f"
									+"|w4_ef|w5_ef|w6_ef|w7_ef|w8_ef|w9_ef"
									+"|dp_seq|loc_cd|loc_grp_cd|mty_bal_tp_cd|ibflag";
					   headTitle2 = "Title|Title"
                                    +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5" 
                                    +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5" 
                                    +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5" 
                                    +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5" 
                                    +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5" 
                                    +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5" 
                                    +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5" 
                                    +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5" 
                                    +"||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5" 
									+"|w1_wk|w2_wk|w3_wk|w4_wk|w5_wk|w6_wk|w7_wk|w8_wk|w9_wk"
									+"|w1_f|w2_f|w3_f|w4_f|w5_f|w6_f|w7_f|w8_f|w9_f"
					                +"|w4_ef|w5_ef|w6_ef|w7_ef|w8_ef|w9_ef"
									+"|dp_seq|loc_cd|loc_grp_cd|mty_bal_tp_cd|ibflag";
					   
					   
	                   var headCnt  = headTitle2.split("|").length;
	                   HeadTitleCnt = headCnt;
	                   InitColumnInfo(headCnt, 0, 2, true);
	                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                   //Rows = 36;
	                   Rows = 14;	                   
	                   InitHeadRow(0, headTitle1, true);
					   InitHeadRow(1, headTitle2, true);
	                   sheetObj.FrozenCols = 0;

	                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					   
                        InitDataProperty(0, cnt++ , dtData,     100,   daCenter,     true,       "title",            false,  "",      dfNone,            0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,   100,   daCenter,     true,       "item",             false,  "",      dfNone,            0,     true,       true);
					    
						InitDataProperty(0, cnt++ , dtImageText, 20,   daCenter,     true,      "w1_img",       false,  "",      dfNone,            0,     false,       false);
					    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_ttl",       false,  "",      dfNullInteger,     0,     false,      false,  6);
					    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_d2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_d4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_d5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_d7",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_r2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_r5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_r9",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_o2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_s2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_o4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_s4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_o5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_f2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_a2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_f4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_a4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_f5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_a5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						// PopUp 화면들에 O5 타입에 대한 구현이 없어 Hidden 으로 둠
						
						InitDataProperty(0, cnt++ , dtImageText, 20,   daCenter,     true,      "w2_img",       false,  "",      dfNone,            0,     false,      false);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_ttl",        false,  "",     dfNullInteger,     0,     false,       false,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_d2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_d4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_d5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_d7",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_r2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_r5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_r9",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_o2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_s2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_o4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_s4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_o5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_f2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_a2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_f4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_a4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_f5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_a5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						
						InitDataProperty(0, cnt++ , dtImageText, 20,   daCenter,     true,      "w3_img",       false,  "",      dfNone,            0,     false,       false);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_ttl",        false,  "",      dfNullInteger,     0,     false,       false,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_d2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_d4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_d5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_d7",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_r2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_r5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_r9",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_o2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_s2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_o4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_s4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_o5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_f2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_a2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_f4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_a4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_f5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_a5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
						
						InitDataProperty(0, cnt++ , dtImageText, 20,   daCenter,     true,      "w4_img",       false,  "",      dfNone,            0,     false,       false);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_ttl",        false,  "",      dfNullInteger,     0,     false,       false,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_d2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_d4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_d5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_d7",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_r2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_r5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_r9",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_o2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_s2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_o4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_s4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_o5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_f2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_a2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_f4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_a4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_f5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_a5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						
						InitDataProperty(0, cnt++ , dtImageText, 20,   daCenter,     true,      "w5_img",       false,  "",      dfNone,            0,     false,       false);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_ttl",        false,  "",      dfNullInteger,     0,     false,       false,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_d2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_d4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_d5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_d7",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_r2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_r5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_r9",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_o2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_s2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_o4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_s4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_o5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_f2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_a2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_f4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_a4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_f5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w5_a5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						
						InitDataProperty(0, cnt++ , dtImageText, 20,   daCenter,     true,      "w6_img",       false,  "",      dfNone,            0,     false,       false);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_ttl",        false,  "",      dfNullInteger,     0,     false,       false,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_d2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_d4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_d5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_d7",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_r2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_r5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_r9",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_o2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_s2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_o4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_s4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_o5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_f2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_a2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_f4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_a4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_f5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w6_a5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						
						InitDataProperty(0, cnt++ , dtImageText, 20,   daCenter,     true,      "w7_img",       false,  "",      dfNone,            0,     false,       false);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_ttl",        false,  "",      dfNullInteger,     0,     false,       false,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_d2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_d4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_d5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_d7",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_r2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_r5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_r9",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_o2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_s2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_o4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_s4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_o5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_f2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_a2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_f4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_a4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_f5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w7_a5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						
						InitDataProperty(0, cnt++ , dtImageText, 20,   daCenter,     true,      "w8_img",       false,  "",      dfNone,            0,     false,       false);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_ttl",       false,  "",      dfNullInteger,     0,     false,       false,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_d2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_d4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_d5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_d7",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_r2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_r5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_r9",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_o2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_s2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_o4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_s4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_o5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_f2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_a2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_f4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_a4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_f5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w8_a5",        false,  "",      dfNullInteger,     0,     true,       true,   6);

						InitDataProperty(0, cnt++ , dtImageText, 20,   daCenter,     true,      "w9_img",       false,  "",      dfNone,            0,     false,       false);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_ttl",       false,  "",      dfNullInteger,     0,     false,       false,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_d2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_d4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_d5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_d7",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_r2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_r5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_r9",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_o2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_s2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_o4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_s4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_o5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_f2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_a2",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_f4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_a4",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_f5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w9_a5",        false,  "",      dfNullInteger,     0,     true,       true,   6);
						
						InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "w1_wk",        false,  "",      dfNone,     0,     true,       true,   6);
                        InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "w2_wk",        false,  "",      dfNone,     0,     true,       true,   6);
                        InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "w3_wk",        false,  "",      dfNone,     0,     true,       true,   6);
                        InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "w4_wk",        false,  "",      dfNone,     0,     true,       true,   6);
                        InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "w5_wk",        false,  "",      dfNone,     0,     true,       true,   6);
                        InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "w6_wk",        false,  "",      dfNone,     0,     true,       true,   6);
                        InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "w7_wk",        false,  "",      dfNone,     0,     true,       true,   6);
                        InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "w8_wk",        false,  "",      dfNone,     0,     true,       true,   6);
                        InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "w9_wk",        false,  "",      dfNone,     0,     true,       true,   6);
						
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w1_f",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w2_f",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w3_f",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w4_f",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w5_f",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w6_f",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w7_f",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w8_f",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w9_f",        false,  "",      dfNone,     0,     true,       true,   6);
						
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w4_ef",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w5_ef",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w6_ef",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w7_ef",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w8_ef",        false,  "",      dfNone,     0,     true,       true,   6);
						InitDataProperty(0, cnt++ , dtHidden,      20,   daRight,     false,      "w9_ef",        false,  "",      dfNone,     0,     true,       true,   6);
						
                        InitDataProperty(0, cnt++ , dtHidden,     50,   daRight,     false,      "dp_seq",           false,  "",      dfNone,            0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,     50,   daRight,     false,      "loc_cd",           false,  "",      dfNone,            0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,     50,   daRight,     false,      "loc_grp_cd",       false,  "",      dfNone,            0,     true,       true);
						InitDataProperty(0, cnt++ , dtHidden,     50,   daRight,     false,      "mty_bal_tp_cd",    false,  "",      dfNone,            0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHiddenStatus,   50,  daCenter,     false,      "ibflag");
					   
					   InitHeadColumn(0, "Inventory|MG FCST|MG PFMC|Repo In|OW&On-hire|+ Others|OP FCST|OP FCST(Sales)|OP PFMC|Repo Out|Balance(FCST)|Balance(PFMC)",daCenterTop);
					   InitHeadColumn(1, "Inventory|MG FCST|MG PFMC|Repo In|OW&On-hire|+ Others|OP FCST|OP FCST(Sales)|OP PFMC|Repo Out|Balance(FCST)|Balance(PFMC)",daCenterTop);
					   
	                   ImageList(0) = "img/btns_search_off.gif";
	                   ImageList(1) = "img/btns_search.gif";     // popup icon 이미지
	                   ImageList(2) = "img/btns_note.gif";       // MG/OP LOG 이미지
	                   
	                   //SelectHighLight = false;
					   SelectionMode = smSelectionFree; // 선택영역 표시
					   
	                   sheetObj.HeadRowHeight = 23;
	                   //RowHeightMin = 10; 
	                   CountPosition = 0;
	                   initSheet1(sheetObjects[0]);	  //초기 sheet1 디지인 세팅
	                   HeadFontBold = true;
	                   AutoRowHeight = false;	 	  //높이를 자동으로 조정하지 않고, 1줄 높이로 고정한다
	                   
					   ExtendLastCol = true; 
					   
					   SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
                       SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
                       SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
	    		}
	    		break;

             case "sheet2":      //sheet2 init
                with (sheetObj) {
                    style.height = 182;//122//162;

                    SheetWidth = mainTable2.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); 

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 6, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false);
                    ScrollBar = 1;
                    CountPosition = 0;
                    
                    headTitle1 = "Title|Title"
                               +"|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average"
                               +"|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average"
                               +"|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average"
                               +"|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average|Past 3 Week's Average"
                               +"|wky_sim_tp_cd|dp_seq";
                    headTitle2 = "Title|Title|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|wky_sim_tp_cd|dp_seq";

                    var headCnt  = headTitle2.split("|").length;
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCnt, 0, 2, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, headTitle1, true);
                    InitHeadRow(1, headTitle2, true);

                    Rows = 5;

                    InitDataProperty(0, cnt++ , dtData,      100,   daCenterTop, true,       "title",            false,  "",      dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,    75,   daCenterTop, true,       "item",             false,  "",      dfNone);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "ttl",           false,  "",      dfNullInteger,     0,     true,       true,   6);
                    
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "d2_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "d4_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "d5_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "d7_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "r2_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "r5_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "r9_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "o2_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "s2_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "o4_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "s4_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "o5_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "f2_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "a2_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "f4_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "a4_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "f5_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "a5_qty",        false,  "",      dfNullInteger,     0,     true,       true,   6);
                    
                    InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "wky_sim_tp_cd", false,  "",      dfNone,     0,     true,       true,   6);
                    InitDataProperty(0, cnt++ , dtHidden,      50,   daRight,     false,      "dp_seq",        false,  "",      dfNone,     0,     true,       true,   6);
                    
                    InitHeadColumn("title", "OP|MG|Repo Out", daCenter);
                    InitHeadColumn("item",  "OP|MG|Repo Out", daCenter);

                    SelectHighLight = false;
                    initSheet2(sheetObj);
					MessageText("UserMsg14") = "";
					
					SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
                    SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
                    SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
                }
                break;  

            case "sheet3":      //sheet3 init
                with (sheetObj) {
					style.height = 182; //
					
					SheetWidth = mainTable3.clientWidth;
					
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 8, 100);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false);
					
                 	ScrollBar = 1;
                    CountPosition = 0;
//					headTitle1 = "Title|Title||Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week|Week"
//                               +"| Week| Week| Week| Week| Week| Week| Week| Week| Week| Week| Week| Week| Week| Week| Week| Week| Week| Week|code|w1_wk|w2_wk";
//                    headTitle2 = "Title|Title||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|F2|A2|F4|A4|F5|O5|code|w1_wk|w2_wk";
					
                    headTitle1 = "Title|Title||Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)|Week(0)"
                                            +"|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)|Week(+1)"
                                            +"|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)|Week(+2)"
                                            +"|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)|Week(+3)"
                                            +"|code|w1_wk|w2_wk|w3_wk|w4_wk";
                    headTitle2 = "Title|Title||TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"
                    	                    +"|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"
                    	                    +"|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"
                    	                    +"|TTL|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5"                    	                    
                    	                    +"|code|w1_wk|w2_wk|w3_wk|w4_wk";
             
					var headCnt  = headTitle2.split("|").length;
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCnt, 0, 3, true);
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, headTitle1, true);
					InitHeadRow(1, headTitle2, true);
					
                    Rows = 7;
					
					InitDataProperty(0, cnt++ , dtData,      40,   daCenterTop, true,       "title",        false,  "",      dfNone);
                    InitDataProperty(0, cnt++ , dtData,      80,   daCenterTop, true,       "item",         false,  "",      dfNone);
					InitDataProperty(0, cnt++ , dtHidden,     0,   daCenterTop, false,       "",             false,  "",      dfNone);
					
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_ttl",       false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_d2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_d4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_d5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_d7",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_r2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_r5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_r9",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_o2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_s2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_o4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_s4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_o5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_f2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_a2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_f4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_a4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_f5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w1_a5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_ttl",       false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_d2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_d4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_d5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_d7",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_r2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_r5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_r9",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_o2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_s2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_o4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_s4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_o5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_f2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_a2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_f4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_a4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_f5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w2_a5",        false,  "",      dfNullInteger,     0,     false,      false,  6);

                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_ttl",       false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_d2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_d4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_d5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_d7",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_r2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_r5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_r9",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_o2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_s2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_o4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_s4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_o5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_f2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_a2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_f4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_a4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_f5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w3_a5",        false,  "",      dfNullInteger,     0,     false,      false,  6);

                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_ttl",       false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_d2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_d4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_d5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_d7",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_r2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_r5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_r9",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_o2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_s2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_o4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_s4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_o5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_f2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_a2",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_f4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_a4",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_f5",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    InitDataProperty(0, cnt++ , dtData,      50,   daRight,     false,      "w4_a5",        false,  "",      dfNullInteger,     0,     false,      false,  6);

					InitDataProperty(0, cnt++ , dtHidden,    50,   daRight,     false,      "code",         false,  "",      dfNullInteger,     0,     false,      false,  6);
					InitDataProperty(0, cnt++ , dtHidden,    50,   daRight,     false,      "w1_wk",        false,  "",      dfNullInteger,     0,     false,      false,  6);
					InitDataProperty(0, cnt++ , dtHidden,    50,   daRight,     false,      "w2_wk",        false,  "",      dfNullInteger,     0,     false,      false,  6);
					InitDataProperty(0, cnt++ , dtHidden,    50,   daRight,     false,      "w3_wk",        false,  "",      dfNullInteger,     0,     false,      false,  6);
					InitDataProperty(0, cnt++ , dtHidden,    50,   daRight,     false,      "w4_wk",        false,  "",      dfNullInteger,     0,     false,      false,  6);
                    
					InitHeadColumn("title", "OP|OP|OP|OP|MG", daCenter);
                    InitHeadColumn("item",  "TTL|MT Picked Up|Full Gate-in|The rest|MG", daCenter);
					
					SetMergeCell(0, 0, 2, 2); // 헤더 강제 merge 				
//			        SetMergeCell(6, 0, 1, 2); // MG 강제 머지
							      
			        
                    //ExtendLastCol = true;
                    SelectHighLight = false;
					initSheet3(sheetObj);
					MessageText("UserMsg14") = "";
					
					SetSortDialog(false);     // Ctrl+S 소트 다이얼로그 방지
                    SetSelectDialog(false);   // Ctrl+H 필터 다이얼로그 방지
                    SetExcelColDialog(false); // Ctrl+P 엑셀 다이얼로그 방지
				}
                break;
	    }
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,initFlag) {
		sheetObj.ShowDebugMsg = false;  
	    switch(sAction) {
	       case IBSEARCH: // 메인 sheet 조회

	    	   if(!validateForm(sheetObj,formObj,sAction)) return;
	    	   if ( !ComIsDate(formObj.fcast_yrwk.value, "yw") ) {
	    		   ComShowMessage(msgs["CIM30003"]);

	    		   formObj.fcast_yrwk.focus();
	    		   return;
	    	   }
	    	   
	    	   sheetObj.WaitImageVisible = false;
	    	   ComOpenWait(true); 
	    	   sheetObj.Redraw = false;

               sheetObjects[0].RemoveAll();
               
               formObj.f_cmd.value = SEARCH03;
               formObj.init_flag.value = "search";
	    	   
        	   mainXml = sheetObj.GetSearchXml("EES_EQR_1001GS.do" , FormQueryString(form));
        	   sheetObj.LoadSearchXml(mainXml);


       			// LCC QTY를 먼저 입력하지 않으면, ECC/SCC 를 입력하지 못하도록 SAVE버튼, GRID 를 비활성화
       			// 2013년, 송현애 과장 요청으로 기능 제거  
        	   /*
	    	   saveFlag = ComGetEtcData(mainXml,"save_flag");

	    	   if(saveFlag == "T"){
	    		   ComBtnEnable("btn_save");
	    		   sheetObj.Editable = true;
	    	   }else{
	    		   ComBtnDisable("btn_save");
	    		   sheetObj.Editable = false;
	    		   ComShowCodeMessage("EQR01003");
	    	   }
	    	   */
        	   
        	   // 
	    	   saveFlag = ComGetEtcData(mainXml,"save_flag");
	    	   if(saveFlag == "0") {
	    		   ComBtnEnable("btn_save");
	    		   sheetObj.Editable = true;
	    	   }else{  // 1,2,3 인 경우(수정 불가)
	    		   /*
	    		   msgs['EQR01136'] = 'Impossible to update past week's data.';   
	    		   msgs['EQR01137'] = 'FCAST cannot be updated this time. \n Plz contact CDO-EQ for FCST Revision.';     
	    		   msgs['EQR01138'] = 'FCST revision for accuracy evaluation only available by 17:00, Friday.';
	    		   */ 	    		   
	    		   if(saveFlag == "1")      ComShowCodeMessage("EQR01136");  // 과거주(Location의 LOCAL TIME) 인 경우
	    		   else if(saveFlag == "2") ComShowCodeMessage("EQR01137");  // 이번주(Location의 LOCAL TIME) 인 경우
	    		   else if(saveFlag == "3") ComShowCodeMessage("EQR01138");  // 미래주차(current) 이지만 금요일 17:00시 지남
	    		   ComBtnDisable("btn_save");
	    		   sheetObj.Editable = false;
	    	   }	    	   	   
	    	   
			   sheetObj.Redraw = true;
	    	   ComOpenWait(false);
			   return true;
	    	   break;
			   
            case SEARCH04: // Reference1 조회
               sheetObj.RemoveAll();
               sheetObj.WaitImageVisible=false;
               ComOpenWait(true); 
               sheetObj.Redraw = false;
               formObj.f_cmd.value = SEARCH04;
               sXml = sheetObj.GetSearchXml("EES_EQR_1001GS.do" , FormQueryString(form));
               sheetObj.LoadSearchXml(sXml);
			   ComOpenWait(false); 
               sheetObj.Redraw = true;
               break;	
			   
			case SEARCH05: // Reference2 조회
               sheetObj.WaitImageVisible=false;
               ComOpenWait(true); 
               sheetObj.Redraw = false;
               formObj.f_cmd.value = SEARCH05;		   
				if (refe2kind == "BKG") {//BKG 클릭한거면
					sXml = sheetObj.GetSearchXml("EES_EQR_1001GS.do", FormQueryString(formObj) + "&kind=" + refe2kind);
					if(parseInt(ComGetTotalRows(sXml)) == 4){//조회 결과가 4줄이 맞으면
						
						sheetObj.RowDelete(5,false);
						sheetObj.RowDelete(4,false);
						sheetObj.RowDelete(3,false);
						sheetObj.RowDelete(2,false);
						sheetObj.LoadSearchXml(sXml, true, 2);
						var weekStr1 = sheetObj.CellValue(2,"w1_wk").substr(4,2) + " Week(0)";
						var weekStr2 = sheetObj.CellValue(2,"w2_wk").substr(4,2) + " Week(+1)";
						var weekStr3 = sheetObj.CellValue(2,"w3_wk").substr(4,2) + " Week(+2)";
						var weekStr4 = sheetObj.CellValue(2,"w4_wk").substr(4,2) + " Week(+3)";
						//for(var i=3; i<21; i++){
						for(var i=3; i<22; i++){		
							sheetObj.CellValue2(0,i)        = weekStr1;
//							sheetObj.CellValue2(0,i+(18*1)) = weekStr2;
//							sheetObj.CellValue2(0,i+(18*2)) = weekStr3;
//							sheetObj.CellValue2(0,i+(18*3)) = weekStr4;
							sheetObj.CellValue2(0,i+(19*1)) = weekStr2;
							sheetObj.CellValue2(0,i+(19*2)) = weekStr3;
							sheetObj.CellValue2(0,i+(19*3)) = weekStr4;							
						}
					}
				} else if(refe2kind == "COP"){//COP 클릭한거면
					sXml = sheetObj.GetSearchXml("EES_EQR_1001GS.do", FormQueryString(formObj) + "&kind=" + refe2kind);
					if (parseInt(ComGetTotalRows(sXml)) == 1) {//조회 결과가 1줄이 맞으면

						sheetObj.RowDelete(6, false);
						sheetObj.LoadSearchXml(sXml, true, 6);
						var weekStr1 = sheetObj.CellValue(6,"w1_wk").substr(4,2) + " Week(0)";
                        var weekStr2 = sheetObj.CellValue(6,"w2_wk").substr(4,2) + " Week(+1)";
                        var weekStr3 = sheetObj.CellValue(6,"w3_wk").substr(4,2) + " Week(+2)";
                        var weekStr4 = sheetObj.CellValue(6,"w4_wk").substr(4,2) + " Week(+3)";
                        //for(var i=3; i<21; i++){
                        for(var i=3; i<22; i++){ 	
                            sheetObj.CellValue2(0,i)    = weekStr1;
//							sheetObj.CellValue2(0,i+(18*1)) = weekStr2;
//							sheetObj.CellValue2(0,i+(18*2)) = weekStr3;
//							sheetObj.CellValue2(0,i+(18*3)) = weekStr4;
							sheetObj.CellValue2(0,i+(19*1)) = weekStr2;
							sheetObj.CellValue2(0,i+(19*2)) = weekStr3;
							sheetObj.CellValue2(0,i+(19*3)) = weekStr4;							
                        }
					}
				}
				sheetObj.InitHeadColumn("title", "OP|OP|OP|OP|MG", daCenter);
				sheetObj.InitHeadColumn("item", "TTL|MT Picked Up|Full Gate-in|The rest|MG", daCenter);
				
				initSheet3(sheetObj);
			   
			   ComOpenWait(false); 
               sheetObj.Redraw = true;
               break;   
            
			case SEARCH06: // 직전 주차 조회
			   formObj.f_cmd.value = SEARCH06;
               sXml = sheetObj.GetSearchXml("EES_EQR_1001GS.do" , FormQueryString(form)+"&week="+tmpWk);
			   var beforeweek = ComGetEtcData(sXml,"beforeweek");
			   return beforeweek;
               break;

			case IBSEARCH02: // location focusOut
				var flag = false;
				formObj.inquiryLevel.value = formObj.loc_grp_cd.value;
				formObj.location.value = formObj.loc_cd.value;
				
				formObj.f_cmd.value = SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_EQR_1001GS.do",FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
								
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						if (document.form.loc_grp_cd.value == "E") {
							ComShowCodeMessage("EQR01006");
						}else if (document.form.loc_grp_cd.value == "S") {
							ComShowCodeMessage("EQR01007");
						}else if (document.form.loc_grp_cd.value == "L") {
							ComShowCodeMessage("EQR01005");
						}
						
						document.form.loc_cd.value = "";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd);
						return true;
					}
				} else {
					ComSetFocus(document.form.fcast_yrwk);
				}				
				break;		    	   

	       case IBSAVE: // 메인 sheet 저장
	    	   if(validateForm(sheetObj,formObj,sAction))
	    		   
    		   if (!ComShowCodeConfirm("COM130101")) return;

	    	   formObj.f_cmd.value = MULTI01;
	    	   for ( var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.rowCount; i++ ) {
	    	       // MG Fcst, OW&OnHire, OP Fcst 만 저장 대상 로우, 그 외는 트랜잭션 제외
	    		   if ( i != 3 && i != 6 && i != 8) {
	    			   sheetObj.RowStatus(i) = "R";
	    		   }else if(   sheetObj.CellValue(i,"w4_ef")!="Y"
				            && sheetObj.CellValue(i,"w5_ef")!="Y"
							&& sheetObj.CellValue(i,"w6_ef")!="Y"
							&& sheetObj.CellValue(i,"w7_ef")!="Y"
							&& sheetObj.CellValue(i,"w8_ef")!="Y"	
							&& sheetObj.CellValue(i,"w9_ef")!="Y"	
						   ){
				   	   sheetObj.RowStatus(i) = "R";
				   }
	    	   }
	    	   sheetObj.Redraw = false;
			   var result = false;
	    	   if ( sheetObj.GetSaveString() == '' ) {
	    		   ComShowMessage(sheetObj.MessageText("UserMsg13"));	//There is no contents to save
	    	   } else {
	    		   sheetObj.DoSave("EES_EQR_1001GS.do",FormQueryString(formObj),"ibflag",false);
	    	   }
	    	   sheetObj.Redraw = true;
			   
			   break;
	    }
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(formObj){
			if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
    		   return false;
			} else {			
				if (!ComChkValid(formObj)) return false;	
				return true;		
			}
	    }
	    return true;
	}
	
	/**
	 * 화면 폼입력시 널입력시 0으로 변환
	 */	
    function sheet1_OnKeyUp(sheetObject, Row, Col, Value) {
    	if ( document.form.init_flag.value != 'INIT' ) {
			//
	    	if (sheetObject.CellEditable(Row, Col)) {// 편집가능으로 설정된 Cell 일 경우
		    	if ( sheetObject.CellValue(Row,Col) == '' ) {	//data format int형 널 방지
		    		sheetObject.CellValue2(Row,Col) = 0;
		    	}
	    	}
    	}
    }
    
	/**
	 * sheet1 초기 디자인 세팅
	 */
	function initSheet1(sheetObj){
		if(sheetObj.RowCount > 0){
			
		}else{
			return false;
		}
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if (    sheetObj.CellValue(i, "dp_seq") == "2" // MG FCST
                ||	sheetObj.CellValue(i, "dp_seq") == "5" // OW&On-hire
                ||	sheetObj.CellValue(i, "dp_seq") == "7") { // OP FCST
                sheetObj.RowEditable(i) = true;			
				sheetObj.CellFontColor(i,"title") = sheetObj.RgbColor(0,0,255);
			}else{
				sheetObj.RowEditable(i) = false;
			}
		}
		setLeftFontColor(sheetObj);
		chgBackColor(sheetObj);
	}
    
	/**
     * sheet2 초기 디자인 세팅
     */
    function initSheet2(sheetObj){
        for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            sheetObj.CellBackColor(i,"title") = sheetObj.RgbColor(255,255,255);
			sheetObj.CellAlign(i,"title") = daCenter;
            sheetObj.CellFont("FontBold", i,"title") = true;
		}
	}
	
	/**
     * sheet3 초기 디자인 세팅
     */
    function initSheet3(sheetObj){
        for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            sheetObj.CellBackColor(i,"title") = sheetObj.RgbColor(255,255,255);
            sheetObj.CellAlign(i,"title") = daCenter;
            sheetObj.CellFont("FontBold", i,"title") = true;
			
			sheetObj.CellBackColor(i,"item") = sheetObj.RgbColor(255,255,255);
            sheetObj.CellAlign(i,"item") = daCenter;
            sheetObj.CellFont("FontBold", i,"item") = true;
        }
        sheetObj.CellFontUnderline(2,"title") = true;
        sheetObj.CellFontUnderline(6,"title") = true;	
    }
	
    /**
     * left폰트 변경
     */
	function setLeftFontColor(sheetObj) {
		for ( var i=0; i<=sheetObj.rowCount; i++ ) {
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
		   		if ( j ==0 || j ==1) {
			   		sheetObj.CellAlign(i,j) = daCenter;
				   	sheetObj.CellFont("FontBold", i,j) = true;
		   		}
		   	}
		}
	}
	
    /**
     * sheet1 배경색 변경
     */
	function chgBackColor(sheetObj) {
	   	for ( var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.rowCount; i++ ) {
	   		sheetObj.RowStatus(i) = "R";
	   		sheetObj.CellEditable(i,"w1_ttl") = false;
	   		sheetObj.CellEditable(i,"w2_ttl") = false;
	   		sheetObj.CellEditable(i,"w3_ttl") = false;
			sheetObj.CellEditable(i,"w4_ttl") = false;
            sheetObj.CellEditable(i,"w5_ttl") = false;
            sheetObj.CellEditable(i,"w6_ttl") = false;
			sheetObj.CellEditable(i,"w7_ttl") = false;
			sheetObj.CellEditable(i,"w8_ttl") = false;
			sheetObj.CellEditable(i,"w9_ttl") = false;			
	   	
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
				
				if(sheetObj.ColSaveName(j).substr(3,3) == "ttl" 
				    || sheetObj.ColSaveName(j).substr(3,3) == "img"){ // ttl column 및 icon column 회색 표시
					if  ( i==12 || i==13) { 
                            sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#D0EC7F");
                        } else {
                            sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(240,240,240);
                        }
				}else{
			   		if(sheetObj.ColSaveName(j).substr(1,1) == "1" 
					    || sheetObj.ColSaveName(j).substr(1,1) == "2"
					    || sheetObj.ColSaveName(j).substr(1,1) == "3"){ // 1 ~ 3 주차 회색 표시
			   			if  ( i==12 || i==13) { 
	                        sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#D0EC7F");
	                    } else {
	                        sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(240,240,240);
	                    }
			   		} else { // 나머지 주차 및 타이틀란 컬러 표시 
			   			if ( i>=3 && i <=7) {
	                        sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#F6FAFB");
	                    } else if  ( i>=8 && i <=11 && i != 9) { 
	                        sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#FFEAEA");
	                    } else if  ( i==12 || i==13) { 
	                        sheetObj.CellBackColor(i,j) = sheetObj.WebColor2SysColor("#D0EC7F");
	                    } else {
	                        sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(255,255,255);
	                    }
					}
				}
		   	}
	   	}
	}
	
    /**
     * sheet1 손가락 모양으로 마우스 커서 변경
     */
	function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y) {
	    var col = sheetObj.MouseCol;
	    var i = sheetObj.MouseRow;
	    if ( document.form.init_flag.value != 'INIT' ) { 
			if ( sheetObj.ColSaveName(col).substr(3,3) == "img" && i >= sheetObj.HeaderRows && sheetObj.CellImage(i,col) > 0) { // 해당조건에 맞게 마우스 커서 변경
				sheetObj.MousePointer = "Hand";  // 손가락 모양으로 마우스 커서 변경
			}
	    }
	}
	
	/**
     * sheet1 손가락 모양으로 마우스 커서 변경
     */
    function sheet3_OnMouseMove(sheetObj,Button, Shift, X, Y) {
        var col = sheetObj.MouseCol;
        var i = sheetObj.MouseRow;
        if ( document.form.init_flag.value != 'INIT' ) { 
            if ( col == 0 && i > 1 && i < 7 ) { // 해당조건에 맞게 마우스 커서 변경
                sheetObj.MousePointer = "Hand";  // 손가락 모양으로 마우스 커서 변경
            }
        }
    }
	
	/**
     * sheet1 조회종료
     * sheet1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        sheetObj.Editable = true;
		sheetObj.EditableColor   = sheetObj.RgbColor(0,0,0);
        sheetObj.UnEditableColor = sheetObj.RgbColor(0,0,0);
        //sheetObj.SelectHighLight = false;
		
        //if(ErrMsg)
		  //alert(ErrMsg);

        if(sheetObj.RowCount("R")>1){
            for(var j=2;j<HeadTitleCnt;j++){
                var weekStr = sheetObj.CellValue(2,sheetObj.ColSaveName(j).substr(0,2)+"_wk"); // 6자리 주차
                if(sheetObj.ColSaveName(j).substr(0,2)=="w1"){
                    weekStr = weekStr.substr(4,2)+" Week (-3)" ;
				}else if(sheetObj.ColSaveName(j).substr(0,2)=="w2"){
                    weekStr = weekStr.substr(4,2)+" Week (-2)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w3"){
                    weekStr = weekStr.substr(4,2)+" Week (-1)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w4"){
                    weekStr = weekStr.substr(4,2)+" Week (0)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w5"){
                    weekStr = weekStr.substr(4,2)+" Week (+1)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w6"){
                    weekStr = weekStr.substr(4,2)+" Week (+2)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w7"){
                    weekStr = weekStr.substr(4,2)+" Week (+3)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w8"){
                    weekStr = weekStr.substr(4,2)+" Week (+4)" ;
                }else if(sheetObj.ColSaveName(j).substr(0,2)=="w9"){
                    weekStr = weekStr.substr(4,2)+" Week (+5)" ;
                }
                
				sheetObj.CellValue2(0,j) = weekStr ;
				
				//if(sheetObj.ColSaveName(j)=="w9_o5")
				if(sheetObj.ColSaveName(j)=="w9_a5")	
				    break;
            }

			//for(var i=1; i<=7; i++){
			for(var i=1; i<=9; i++){
				sheetObj.CellImage(3,"w"+i+"_img") = 2; // 로그 팝업 이미지
				sheetObj.CellImage(8,"w"+i+"_img") = 2; 
				sheetObj.CellImage(9,"w"+i+"_img") = 1;	 // OP FCST(Sales)
				
				if(i<=3 && sheetObj.CellValue(2,"w"+i+"_f")=="Y"){
					sheetObj.CellImage(5,"w"+i+"_img") = 1; // 조회 팝업 이미지
					sheetObj.CellImage(7,"w"+i+"_img") = 1;
					sheetObj.CellImage(11,"w"+i+"_img") = 1;
				}else if(i>3){
					sheetObj.CellImage(5,"w"+i+"_img") = 1; // 조회 팝업 이미지
	                sheetObj.CellImage(7,"w"+i+"_img") = 1;
	                sheetObj.CellImage(11,"w"+i+"_img") = 1;
				}
			}
			calcBalance();
			calcAllTotal();
			initSheet1(sheetObj);
		}
    }
	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        // sheet2 의 합계 구하기 
        calcTotalSheet2();
    }
    
    function sheet3_OnSearchEnd(sheetObj, ErrMsg){
        // sheet3 의 합계 구하기 
        calcTotalSheet3();
    }
	
	function calcAllTotal(){
		var sheetObj = sheetObjects[0];
		//for (var week = 1; week <= 7; week++) {
		for (var week = 1; week <= 9; week++) {	
			for (var row = sheetObj.HeaderRows; row < sheetObj.HeaderRows + sheetObj.RowCount; row++) {
                calcTotal(week,row);
			}
		}
	}
	
	function calcTotal(week,row){
		//sheet1 해당 week, 해당 row 의 합계 구하기
        var sheetObj = sheetObjects[0];
        
		//if(week < 1 || week > 7 || row < sheetObj.HeaderRows || row > sheetObj.HeaderRows + sheetObj.RowCount ){
		if(week < 1 || week > 9 || row < sheetObj.HeaderRows || row > sheetObj.HeaderRows + sheetObj.RowCount ){	
			return false;
		}
		
		var tpsz_cd = form.tpsztype.Text;
        var arr_tpsz = tpsz_cd.split(",");

        var tmpSum = 0;
        for (var j = 0; j < arr_tpsz.length; j++) { //선택된 Container Type/Size
            tmpSum = tmpSum + parseInt(sheetObj.CellValue(row,"w" + week + "_" + arr_tpsz[j].toLowerCase()));
        }
        sheetObj.CellValue2(row,"w"+week+"_ttl") = tmpSum;
        
        if(row == 12 || row == 13){ // Balance 인 경우, 색상 지정
            if(tmpSum < 0){ // 마이너스는 빨간색
                sheetObj.CellFontColor(row,"w"+week+"_ttl") = sheetObj.RgbColor(255,0,0);
            }else{ // 파란색
                sheetObj.CellFontColor(row,"w"+week+"_ttl") = sheetObj.RgbColor(0,0,255);
            }
        }
     }
	
	function calcTotalSheet2(){
		// sheet2 의 합계 구하기 
		sheetObj = sheetObjects[1];		
        var tpsz_cd = form.tpsztype.Text;
        var arr_tpsz = tpsz_cd.split(",");
        
        var tmpSum = 0;
        for(var row = sheetObj.HeaderRows; row < sheetObj.HeaderRows + sheetObj.RowCount; row++){
            tmpSum = 0;
            for (var j = 0; j < arr_tpsz.length; j++) { //선택된 Container Type/Size
                tmpSum = tmpSum + parseInt(sheetObj.CellValue(row,arr_tpsz[j].toLowerCase()+"_qty"));
            }
            sheetObj.CellValue2(row,"ttl") = tmpSum;
        }
	}
	
	function calcTotalSheet3(){
        // sheet3 의 합계 구하기 
		sheetObj = sheetObjects[2];       
        var tpsz_cd = form.tpsztype.Text;
        var arr_tpsz = tpsz_cd.split(",");
        
        var tmpSum1 = 0;
        var tmpSum2 = 0;
        var tmpSum3 = 0;
        var tmpSum4 = 0;        
        for(var row = sheetObj.HeaderRows; row < sheetObj.HeaderRows + sheetObj.RowCount; row++){
            tmpSum1 = 0;
            tmpSum2 = 0;
            tmpSum3 = 0;
            tmpSum4 = 0;            
            for (var j = 0; j < arr_tpsz.length; j++) { //선택된 Container Type/Size
                tmpSum1 = tmpSum1 + parseInt(sheetObj.CellValue(row,"w1_"+arr_tpsz[j].toLowerCase()));
                tmpSum2 = tmpSum2 + parseInt(sheetObj.CellValue(row,"w2_"+arr_tpsz[j].toLowerCase()));
                tmpSum3 = tmpSum3 + parseInt(sheetObj.CellValue(row,"w3_"+arr_tpsz[j].toLowerCase()));
                tmpSum4 = tmpSum4 + parseInt(sheetObj.CellValue(row,"w4_"+arr_tpsz[j].toLowerCase()));                
            }
            sheetObj.CellValue2(row,"w1_ttl") = tmpSum1;
            sheetObj.CellValue2(row,"w2_ttl") = tmpSum2;
            sheetObj.CellValue2(row,"w3_ttl") = tmpSum3;
            sheetObj.CellValue2(row,"w4_ttl") = tmpSum4;            
        }
    }
	
	function calcBalance(){
		//for(var week=1; week<=7; week++){
		for(var week=1; week<=9; week++){
			calcBalanceFcst(week,"d2");
			calcBalanceFcst(week,"d4");
			calcBalanceFcst(week,"d5");
			calcBalanceFcst(week,"d7");
			calcBalanceFcst(week,"r2");
			calcBalanceFcst(week,"r5");
			calcBalanceFcst(week,"r9");
			calcBalanceFcst(week,"o2");
			calcBalanceFcst(week,"s2");
			calcBalanceFcst(week,"o4");
			calcBalanceFcst(week,"s4");
			calcBalanceFcst(week,"f2");
			calcBalanceFcst(week,"a2");
			calcBalanceFcst(week,"f4");
			calcBalanceFcst(week,"a4");
			calcBalanceFcst(week,"f5");
			calcBalanceFcst(week,"a5");
			calcBalanceFcst(week,"o5");
		}
		for(var week=1; week<=3; week++){
            calcBalancePfmc(week,"d2");
            calcBalancePfmc(week,"d4");
            calcBalancePfmc(week,"d5");
            calcBalancePfmc(week,"d7");
            calcBalancePfmc(week,"r2");
            calcBalancePfmc(week,"r5");
            calcBalancePfmc(week,"r9");
            calcBalancePfmc(week,"o2");
            calcBalancePfmc(week,"s2");
            calcBalancePfmc(week,"o4");
            calcBalancePfmc(week,"s4");
            calcBalancePfmc(week,"f2");
            calcBalancePfmc(week,"a2");
            calcBalancePfmc(week,"f4");
            calcBalancePfmc(week,"a4");
            calcBalancePfmc(week,"f5");
            calcBalancePfmc(week,"a5");
            calcBalancePfmc(week,"o5");
        }
	}
	
	/**
     * 
     * 
     */
    function calcBalanceFcst(week,tpsz){ // week:1~9 ,tpsz:d2~,
        var sheetObj = sheetObjects[0];
		//if(week < 1 || week >7 ){
		if(week < 1 || week >9 ){		
			return false;
		}
			if(week!=1 && sheetObj.CellValue(2,"w"+week+"_f")=="Y"){
				// 앞 주의 Balance(FCST) 를 Inventory 로 함
				sheetObj.CellValue2(2,"w"+week+"_"+tpsz) = sheetObj.CellValue(12,"w"+(week-1)+"_"+tpsz);
			}
			
			//inventory + MG + Repo in + OW&OnHire + (+)Others - OP - Repo out
			var tmpTotal = parseInt(sheetObj.CellValue(2,"w"+week+"_"+tpsz)) // Inventory
			             + parseInt(sheetObj.CellValue(3,"w"+week+"_"+tpsz)) // MG FCST
			             + parseInt(sheetObj.CellValue(5,"w"+week+"_"+tpsz)) // Repo In
	                     + parseInt(sheetObj.CellValue(6,"w"+week+"_"+tpsz)) // OW&On-Hire
						 + parseInt(sheetObj.CellValue(7,"w"+week+"_"+tpsz)) // +Others
						 - parseInt(sheetObj.CellValue(8,"w"+week+"_"+tpsz)) // OP FCST
						 // 2014-11-18 EQ Forecast 프로젝트
						 - parseInt(sheetObj.CellValue(11,"w"+week+"_"+tpsz)) // Repo Out
						 ;
			sheetObj.CellValue(12,"w"+week+"_"+tpsz) = tmpTotal; // Balance(FCST)		
			
			if(tmpTotal < 0){ // 마이너스는 빨간색
				sheetObj.CellFontColor(12,"w"+week+"_"+tpsz) = sheetObj.RgbColor(255,0,0);
			}else{ // 파란색
				sheetObj.CellFontColor(12,"w"+week+"_"+tpsz) = sheetObj.RgbColor(0,0,255);
			}
			
	}
	
	function calcBalancePfmc(week,tpsz){ // week:1~3 중 과거 주차일 경우 ,tpsz:d2...,
        var sheetObj = sheetObjects[0];
        if(week < 1 || week >3 || sheetObj.CellValue(2,"w"+week+"_f")!="N"){
            return false;
        }
            //inventory + MG + Repo in + OW&OnHire + (+)Others - OP - Repo out
            var tmpTotal = parseInt(sheetObj.CellValue(2,"w"+week+"_"+tpsz)) // Inventory
                         + parseInt(sheetObj.CellValue(4,"w"+week+"_"+tpsz)) // MG PFMC
                         + parseInt(sheetObj.CellValue(5,"w"+week+"_"+tpsz)) // Repo In
                         + parseInt(sheetObj.CellValue(6,"w"+week+"_"+tpsz)) // OW&On-Hire
                         + parseInt(sheetObj.CellValue(7,"w"+week+"_"+tpsz)) // +Others
                         // 2014-11-18 EQ Forecast 프로젝트 
                         - parseInt(sheetObj.CellValue(10,"w"+week+"_"+tpsz)) // OP PFMC
                         - parseInt(sheetObj.CellValue(11,"w"+week+"_"+tpsz)) // Repo Out
                         ;
            sheetObj.CellValue(13,"w"+week+"_"+tpsz) = tmpTotal; // Balance(PFMC)         
            
			if(tmpTotal < 0){ // 마이너스는 빨간색
                sheetObj.CellFontColor(13,"w"+week+"_"+tpsz) = sheetObj.RgbColor(255,0,0);
            }else{ // 파란색
                sheetObj.CellFontColor(13,"w"+week+"_"+tpsz) = sheetObj.RgbColor(0,0,255);
            }
    }
	
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
    function sheet1_OnClick(sheetObj, row, col, value) {
    	var dp_seq = sheetObj.CellValue(row,"dp_seq");
    	
 		if ( document.form.init_flag.value != 'INIT' || true) {
 	    	switch (sheetObj.ColSaveName(col)) {
 	    		case "w1_img" :   		
				case "w2_img" : 
				case "w3_img" : 
				case "w4_img" : 
				case "w5_img" : 
				case "w6_img" : 
				case "w7_img" :
				case "w8_img" :
				case "w9_img" :	
				
				    if(sheetObj.CellImage(row,col)=="-1" || sheetObj.CellImage(row,col)=="0"){ // popup 이미지 없거나, off 이면
						break;
					}
					
					var fcast_yrwk = "";
					var inp_yrwk = "";
					var repo_pln_yrwk = "";
					var popSaveFlag = saveFlag ;
										
				    if(sheetObj.ColSaveName(col).substr(1,1) >= 4) {  // 4 : Current Week ~ 미래주차를 확인
				        fcast_yrwk    = sheetObj.CellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk");
                        inp_yrwk      = sheetObj.CellValue(row,"w3_wk");
						repo_pln_yrwk = sheetObj.CellValue(row,"w4_wk");
						
				    }else{  // 과거주차 는 history 만 조회됨.
						fcast_yrwk = sheetObj.CellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk");
						//repo_pln_yrwk = sheetObj.CellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk");
						repo_pln_yrwk = sheetObj.CellValue(row,"w4_wk");
						if( sheetObj.CellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk").substr(4,5) == '01' ){
							tmpWk = sheetObj.CellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk");
							inp_yrwk = doActionIBSheet(sheetObjects[1],form,SEARCH06);
						}else{
                            inp_yrwk = parseInt(sheetObj.CellValue(row,"w"+ sheetObj.ColSaveName(col).substr(1,1) +"_wk"))-1;
						}
						popSaveFlag = "";
					}
					
					var searchFlag = 0;
					var index = document.form.cntrTpsz.selectedIndex;
                    if ( document.form.cntrTpsz.options[index].value == "D" )      searchFlag = 0; // DRY 선택
                    else if ( document.form.cntrTpsz.options[index].value == "R" ) searchFlag = 1; // SPCL 선택
                    else if ( document.form.cntrTpsz.options[index].value == "O" ) searchFlag = 1; // SPCL 선택
                    else if ( document.form.cntrTpsz.options[index].value == "F" ) searchFlag = 1; // SPCL 선택
                    else searchFlag = 2; // ALL 선택  
					
 	    			if ( dp_seq == 10 ) {  //repo out  		
	    				var param = "loc_cd=" + document.form.loc_cd.value
				 				   +"&fcast_yrwk=" + fcast_yrwk
				 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
 	    						   +"&inp_yrwk=" + inp_yrwk
 	    						   +"&save_flag=" + popSaveFlag
 	    						   +"&f_cmd=" + SEARCH
								   +"&tpsz_flag=" + document.form.tpsztype.Text;//현재 선택된 tpsz(콤마로 구분)
 	    			 	ComOpenPopup("/hanjin/EES_EQR_1047.do?"+ param,1000, 700, "setOwOnHireValue", "1,0,1,1,1,1,1,1", true);
						
 	    			}else if ( dp_seq == 4 ) {    //Repo. In 	    				
	 	    			var param = "loc_cd=" + document.form.loc_cd.value
		 				   +"&fcast_yrwk=" + fcast_yrwk
		 				   +"&repo_pln_yrwk=" + repo_pln_yrwk //ComTrimAll(document.form.fcast_yrwk.value, "-", "")		 				   
		 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
		 				   +"&f_cmd=" + SEARCH;
    					ComOpenPopup("/hanjin/EES_EQR_1044.do?"+ param,1015, 705, "setOwOnHireValue", "1,0,1,1,1,1,1,1", true);
    					
 	    			}else if ( dp_seq == 2 ) {    // MG Forecast Log 팝업 오픈
	 	    			var param = "loc_cd=" + document.form.loc_cd.value
	 	    			   +"&inp_yrwk=" + inp_yrwk //sheetObj.CellValue(row,"inp_yrwk") 
		 				   +"&fcast_yrwk=" + fcast_yrwk //ComTrimAll(sheetObj.CellValue(row,"yyyy_ww"), "-", "")
		 				   +"&repo_pln_yrwk=" + repo_pln_yrwk //ComTrimAll(document.form.fcast_yrwk.value, "-", "")		 				   
		 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
		 				   +"&tp_cd=" + sheetObj.CellValue(row,"mty_bal_tp_cd")
		 				   +"&search_flag=" + searchFlag
		 				   +"&f_cmd=" + INIT ;
    					ComOpenPopup("/hanjin/EES_EQR_1043.do?"+ param, 1015, 705, "MG/OP Forecast", "1,0,1,1,1,1,1,1", true);

 	    			}else if ( dp_seq == 7 ) {    // OP Forecast Log 팝업 오픈
	 	    			var param = "loc_cd=" + document.form.loc_cd.value
	 	    			   +"&inp_yrwk=" + inp_yrwk 
		 				   +"&fcast_yrwk=" + fcast_yrwk // ComTrimAll(sheetObj.CellValue(row,"yyyy_ww"), "-", "")
		 				   +"&repo_pln_yrwk=" + repo_pln_yrwk//ComTrimAll(document.form.fcast_yrwk.value, "-", "")		 				   
		 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
		 				   +"&tp_cd=" + sheetObj.CellValue(row,"mty_bal_tp_cd")
		 				   +"&search_flag=" + searchFlag
		 				   +"&f_cmd=" + INIT ;
 	    				ComOpenPopup("/hanjin/EES_EQR_1043.do?"+ param, 1015, 705, "MG/OP Forecast", "1,0,1,1,1,1,1,1", true);

 	    			} else if ( dp_seq == 6 ) {  //+ Others,- Others
 	    				var repo_flag ="MINUS";
 	    				if ( dp_seq == 6 ) { //+ Others
 	    					repo_flag = "PLUS";
 	    				}
 	    		 		var param = "loc_cd=" + document.form.loc_cd.value
				 				   +"&fcast_yrwk=" + fcast_yrwk
				 				   +"&tp_cd=" + sheetObj.CellValue(row,"mty_bal_tp_cd")
				 				   +"&inp_yrwk=" + inp_yrwk 
				 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
				 				   +"&save_flag=" + popSaveFlag
				 				   +"&repo_flag=" + repo_flag
								   +"&search_flag=" + searchFlag;
 	    		 		ComOpenPopup("/hanjin/EES_EQR_1046.do?"+ param,700, 490, "", "1,0,1,1,1,1,1,1", true);
 	    		 		
 	    			} else if ( dp_seq == 8 ) {		// Sales Forecast Detail 팝업 오픈
 	    				var param = "loc_cd=" + document.form.loc_cd.value
				 				   +"&fcast_yrwk=" + fcast_yrwk	//ComTrimAll(sheetObj.CellValue(row,"yyyy_ww"), "-", "")
				 				   +"&repo_pln_yrwk=" + repo_pln_yrwk	//ComTrimAll(document.form.fcast_yrwk.value, "-", "")
				 				   +"&loc_grp_cd=" + document.form.loc_grp_cd.value
				 				   +"&search_flag=" + searchFlag
				 				   +"&pop_mode=Y" + "&f_cmd=" + INIT ;
 	    				ComOpenPopup("/hanjin/EES_EQR_1004.do?"+ param, 1070, 625, "Sales Forecast Detail", "1,0,1,1,1,1,1,1", true);
 	    			}
 	       			break;
 	    	}
     	} 
    }
    
	function sheet3_OnClick(sheetObj, row, col, value){
		var formObj = document.form;
		if (col == 0) {
			if (document.form.init_flag.value != "INIT") {
				if(row==6){
					refe2kind = "COP";
					doActionIBSheet(sheetObj, formObj, SEARCH05);
				}else if(row>1 && row<6){
					refe2kind = "BKG";
					doActionIBSheet(sheetObj, formObj, SEARCH05);
				}
			}
		}
	}
	
//	/**
//     * 셀에 키입력 했을때 발생하는 이벤트 <br>
//     * @param {ibsheet} sheetObj    IBSheet Object
//     * @param {ibsheet} row         sheetObj의 선택된 Row
//     * @param {ibsheet} col         sheetObj의 선택된 Col
//     **/
//     function sheet1_OnAfterEdit(sheetObj, Row, Col){
//	    if(sheetObj == sheetObjects[0]){
//            
//			if (sheetObj.ColSaveName(Col).substr(3,3) != "img") {  //image_button 아닐때
//                if ( sheetObj.CellValue(Row,Col) == '' ) {  //data format int형 널 방지
//                    sheetObj.CellValue2(Row,Col) = 0;
//                }
//            }
//			
//			if(sheetObj.CellSearchValue(Row,Col) != sheetObj.CellValue(Row,Col)){ // 값이 변경된 경우만
//			    var sName = sheetObj.ColSaveName(Col);
//	            if(parseInt(sName.substr(1,1)) > 3 && parseInt(sName.substr(1,1)) < 8){
//					sheetObj.CellValue(Row,sName.substr(0,2)+"_ef") = "Y"; // 주차별 edited 판단을 위한 flag
//	            }
//				
//				var week = sName.substr(1,1);
//				var tpsz = sName.substr(3,2);
//				
//				calcTotal(week, Row);  // 편집행 합계 재계산
//				for(var i=week; i<=7; i++){
//					calcBalanceFcst(i,tpsz); // 뒷 주차도 다시 계산
//					calcTotal(i, 2);   //Inventory
//					calcTotal(i, 11);  //Balance(FCST)
//	                calcTotal(i, 12);  //Balance(PFMC)
//				}
//			}
//	    }
//	 }
    
	function sheet1_OnChange(sheetObj, Row, Col, Value){ // Ctrl+V 입력 위해 OnChange 사용
		// sheet1 의 값이 변경된 경우 호출
		
		if ( //sheetObj.CellSearchValue(Row, Col) != sheetObj.CellValue(Row, Col) // 초기 조회시 제외
		    sheetObj.CellValue(Row,"dp_seq")!=""                            // Balance 제외
			&& sheetObj.ColSaveName(Col).substr(3,3) != "img"                  // icon column 제외
			&& sheetObj.ColSaveName(Col).substr(3,3) != "ttl"                  // ttl column 제외
			&& sheetObj.ColSaveName(Col).substr(3,2) != "ef" ) {               // edit flag 제외
			
			if (  sheetObj.ColSaveName(Col).substr(1, 1) == "4" ||
			      sheetObj.ColSaveName(Col).substr(1, 1) == "5" ||
			      sheetObj.ColSaveName(Col).substr(1, 1) == "6" ||
			      sheetObj.ColSaveName(Col).substr(1, 1) == "7" ||
			      sheetObj.ColSaveName(Col).substr(1, 1) == "8" ||
			      sheetObj.ColSaveName(Col).substr(1, 1) == "9" 
			   ) { // 1~3 과거 주차 제외
			  	
                    if ( sheetObj.CellValue(Row,Col) == '' ) {  //data format int형 널 방지
	                    sheetObj.CellValue2(Row,Col) = 0;
	                }
				
                var sName = sheetObj.ColSaveName(Col);
                //if( ( parseInt(sName.substr(1,1)) > 3 && parseInt(sName.substr(1,1)) < 8)
                if( ( parseInt(sName.substr(1,1)) > 3 && parseInt(sName.substr(1,1)) < 10) 		
				        &&( sheetObj.CellValue(Row,"dp_seq")==2        // MG FCST
						    || sheetObj.CellValue(Row,"dp_seq")==5     // OW&On-Hire
							|| sheetObj.CellValue(Row,"dp_seq")==7)	){ // OP FCST
                    
					sheetObj.CellValue(Row,sName.substr(0,2)+"_ef") = "Y"; // 주차별 edited 판단을 위한 flag
                
	                var week = sName.substr(1,1);
	                var tpsz = sName.substr(3,2);
	                
	                calcTotal(week, Row);  // 편집행 합계 재계산
	                //for(var i=week; i<=7; i++){
	                for(var i=week; i<=9; i++){ 	
	                    calcBalanceFcst(i,tpsz); // 뒷 주차도 다시 계산
	                    calcTotal(i, 2);   //Inventory
	                    calcTotal(i, 12);  //Balance(FCST)
	                    calcTotal(i, 13);  //Balance(PFMC)
	                }
				}
            }
		}
     }
	
    /**
     * 저장 완료시 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if ( ErrMsg == '' ) {	//success
    		ComShowMessage(ComGetMsg("COM130102", "Data"));
			for(var i=sheetObj.HeaderRows; i<=sheetObj.HeaderRows+sheetObj.RowCount; i++){
				sheetObj.CellValue(i,"ibflag") = "R"; // ibflag 초기화
				sheetObj.CellValue(i,"w4_ef") = "";   // edit flag 초기화
				sheetObj.CellValue(i,"w5_ef") = "";
				sheetObj.CellValue(i,"w6_ef") = "";
				sheetObj.CellValue(i,"w7_ef") = "";
				sheetObj.CellValue(i,"w8_ef") = "";
				sheetObj.CellValue(i,"w9_ef") = "";
			}
			
    	} else {	//error message 발생시 초기 데이타 세팅
    		sheetObj.LoadSearchXml(mainXml);
    	}
    	sheetObj.Redraw = true;
    	sheetObj.ShowMsgMode=false;
    }
    
	/**
     * 설  명 :  Combo 기본 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     initCombo(comboObj,comboNo)
     * </pre>
     * @param {object}  comboObj - Combo Object
     * @param {Number}  comboNo  - Combo Number
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function initCombo (comboObj, comboNo) {
        var cnt  = 0 ;
        
        switch(comboNo) {       
            // Type Size
            case 1:
                with (comboObj) {               
                    DropHeight = 12 * 20;
                    
                    var menuname = tpszallText.split('|'); 
                    var menucode = tpszallCode.split('|'); 
                    
                    MultiSelect = true;
                    MaxSelect = menuname.length;
                    MultiSeparator = ",";
                    
                    for(i=0; i<menuname.length; i++) {
                        InsertItem(cnt++, menuname[i], menucode[i]);                            
                    } 
                }
                break;
        }
    }
	
	/**
     * 설  명 : TP/SZ 종류 변경시 코드 설정 <br>
     * <br><b>Example : </b>
     * <pre>
     *     tpszChange('')
     * </pre>
     * @param {String}  key - tpsz Combo Value('' - ALL, D - Dry, R - Refer, O - O/T, F - F/R)
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function tpszChange(key){
        switch (key) {
        case "":
            comboObjects[0].Code = consTpsz;                            
            break;
        case "D":
            comboObjects[0].Code = consTpszDry;                
            break;
        case "R":
            comboObjects[0].Code = consTpszRfr;
            break;
        case "O":
            comboObjects[0].Code = consTpszOt;
            break;
        case "F":
            comboObjects[0].Code = consTpszFr;
            break;
        }
    }
	
	/**
     * 설  명 : Form Object의 Change Event <br>
     * <br><b>Example : </b>
     * <pre>
     *     form_change()
     * </pre>
     * @see #링크연결
     * @author 작성자
     * @version 2009.01.01
     */
    function form_change(){
        var srcName = window.event.srcElement.getAttribute("name");

        if ( srcName == "cntrTpsz"){
            var index = document.form.cntrTpsz.selectedIndex;
            tpszChange(document.form.cntrTpsz.options[index].value);
        }
    }
	
	function tpsztype_OnChange(){
		setGridHidden(form.tpsztype.Text);
		calcAllTotal();    // sheet1 TTL 재 계산
		calcTotalSheet2(); // sheet2 TTL 재 계산
		calcTotalSheet3(); // sheet3 TTL 재 계산
	}
	
	/*
	 * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
	 * OnloadPage,OnSearchEnd event에서 호출
	 * @param {String} tpsz_cd
	 * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
	 */
	function setGridHidden(tpsz_cd){
	    var sheetObj  = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var sheetObj3 = sheetObjects[2];
	    var arr_tpsz  = tpsz_cd.split(",");
	
	    for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size	   
	        for(var j=0;j<arr_tpsz.length;j++){ //선택된 Container Type/Size
	            if(consTpszArr[i] == arr_tpsz[j]){
	                sheetObj.ColHidden("w1_"+consTpszArr[i].toLowerCase())= false;
		            sheetObj.ColHidden("w2_"+consTpszArr[i].toLowerCase())= false;
		            sheetObj.ColHidden("w3_"+consTpszArr[i].toLowerCase())= false;
		            sheetObj.ColHidden("w4_"+consTpszArr[i].toLowerCase())= false;
		            sheetObj.ColHidden("w5_"+consTpszArr[i].toLowerCase())= false;
		            sheetObj.ColHidden("w6_"+consTpszArr[i].toLowerCase())= false;
		            sheetObj.ColHidden("w7_"+consTpszArr[i].toLowerCase())= false;
		            sheetObj.ColHidden("w8_"+consTpszArr[i].toLowerCase())= false;
		            sheetObj.ColHidden("w9_"+consTpszArr[i].toLowerCase())= false;
					
					sheetObj2.ColHidden(consTpszArr[i].toLowerCase()+"_qty")= false;
					
					sheetObj3.ColHidden("w1_"+consTpszArr[i].toLowerCase())= false;
					sheetObj3.ColHidden("w2_"+consTpszArr[i].toLowerCase())= false;
                    sheetObj3.ColHidden("w3_"+consTpszArr[i].toLowerCase())= false;
                    sheetObj3.ColHidden("w4_"+consTpszArr[i].toLowerCase())= false;   					
					break;
	            }else if(j==arr_tpsz.length-1){ //선택된 Container Type/Size 에 없는 Type/Size
					sheetObj.ColHidden("w1_"+consTpszArr[i].toLowerCase())= true;
	                sheetObj.ColHidden("w2_"+consTpszArr[i].toLowerCase())= true;
	                sheetObj.ColHidden("w3_"+consTpszArr[i].toLowerCase())= true;
	                sheetObj.ColHidden("w4_"+consTpszArr[i].toLowerCase())= true;
	                sheetObj.ColHidden("w5_"+consTpszArr[i].toLowerCase())= true;
	                sheetObj.ColHidden("w6_"+consTpszArr[i].toLowerCase())= true;
	                sheetObj.ColHidden("w7_"+consTpszArr[i].toLowerCase())= true;
	                sheetObj.ColHidden("w8_"+consTpszArr[i].toLowerCase())= true;
	                sheetObj.ColHidden("w9_"+consTpszArr[i].toLowerCase())= true;
	                
	                sheetObj2.ColHidden(consTpszArr[i].toLowerCase()+"_qty")= true;
					
                    sheetObj3.ColHidden("w1_"+consTpszArr[i].toLowerCase())= true;
                    sheetObj3.ColHidden("w2_"+consTpszArr[i].toLowerCase())= true;
                    sheetObj3.ColHidden("w3_"+consTpszArr[i].toLowerCase())= true;
                    sheetObj3.ColHidden("w4_"+consTpszArr[i].toLowerCase())= true;                    
				}
			}       
	    }
	}
	
	/**
     * 팝업에서 선택한 OW&On-hire total값 Setting.
    */
    function setOwOnHireValue(saveName,value){
		var week = sheetObjects[0].ColSaveName(sheetObjects[0].SelectCol).substr(0,2);
        var realSaveName = week+"_"+saveName.substr(0,2);
		
		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow,realSaveName) =  ComAddComma(value);
    }
	
	/* 개발자 작업  끝 */   