/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1002.js
*@FileTitle : Basic Tariff Creation - Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.04 김태균
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
     * @class EES_DMT_1002 : EES_DMT_1002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_1002() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
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

	var comboObjects = new Array();
	var comboCnt = 0;
	
	//  업무전역변수
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	var PERIOD_GAP 	= 15;
	var IBNEXT		= 51;
	
	var old_xcld_sat_flg = "";
	var old_xcld_sun_flg = "";
	var old_xcld_hol_flg = "";

	// F/Time Commence 
	var old_dmdt_chg_cmnc_tp_cd = "";
	var old_cmnc_hr = "";
	var old_currency = "";
	
	var sheet3_xml = "";
	var sheet4_xml = "";
	var expt_flg = "N";
	
	var cmnc_hr_array = new Array("01","02","03","04","05","06","07","08","09","10"
								  ,"11","12","13","14","15","16","17","18","19","20","21","22","23");

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		 
		/*******************************************************/
		var formObject = document.form;

    	try {
     		var srcObj = window.event.srcElement;
    		var srcName = srcObj.getAttribute("name");
    		
    		switch(srcName) {
	         	case "btns_calendar1": //달력 버튼
	         		if(srcObj.style.cursor == "hand") {
	         			var cal = new ComCalendar();
    					cal.select(formObject.eff_dt, 'yyyy-MM-dd');
	         		}
             		
					break;
		         
		        case "btns_calendar2": //달력 버튼
		        	if(srcObj.style.cursor == "hand") {
		                var cal = new ComCalendar();
		                cal.select(formObject.exp_dt, 'yyyy-MM-dd');
		        	}
	                break;
	            
		        case "btn_add":
		        	if(srcObj.style.cursor == "hand") {
		        		ComSheet2SheetCheck(sheetObject1, sheetObject2, "checkBox");
		        	}
	                break;
	                
		        case "btn_del":
		        	if(srcObj.style.cursor == "hand") {
		        		ComSheet2SheetCheck(sheetObject2, sheetObject1, "checkBox");
		        	}
	                break;
	                
				case "btn_rowadd":
		        	if(ComIsBtnEnable(srcName)) {
		        		doActionIBSheet(sheetObject3,formObject,IBINSERT);
		        	}
					break;

				case "btn_rowdelete":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject3,formObject,IBDELETE);
					}
					break;

				case "btn_rowadd2":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject4,formObject,IBINSERT);
					}
					break;

				case "btn_rowdelete2":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject4,formObject,IBDELETE);
					}
					break;

				case "btn_save":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					break;
				
				case "btn_next":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject2,formObject,IBNEXT);
					}
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
    	//Grid 조회
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

	    //Axon 이벤트 처리
	    initAxonControl();
	    
	    var formObj = document.form;
    	var today = "";
    	var v_dmdt_bzc_trf_grp_nm = "";
		//국가별 통화량
		searchCurrencyList(ComGetObjValue(formObj.cvrg_cnt_cd));
		
		//국가별 Free Time 설정
		wknd1.innerHTML = ComGetObjValue(formObj.wknd1);
		wknd2.innerHTML = ComGetObjValue(formObj.wknd2);

        //Update
    	if(ComGetObjValue(formObj.button_mode) == "U" ) {
    		setIntitUpdate();
            //TRF_RGN, TRF_GRP를 Select 한다.
            for(var i = 0; i < sheetObjects.length; i++){
    			//Update 일 경우는 첫번째 시트는 조회 하지 않는다.
    			if( i == 0) continue;
                doActionIBSheet(sheetObjects[i],formObj,IBSEARCH);
            }
            v_dmdt_bzc_trf_grp_nm = ComGetObjValue(formObj.dmdt_bzc_trf_grp_nm);
            
            //
//            ComEnableObject(formObj.btn_add, false);
//        	ComEnableObject(formObj.btn_del, false);
            ComEnableObject(formObj.btn_add, true);
        	ComEnableObject(formObj.btn_del, true);

        	changeGroupType(formObj.dmdt_trf_grp_tp_cd);
            
        //Expire
    	}else if(ComGetObjValue(formObj.button_mode) == "E" ){
    		setInitExpire();
    		for(var i = 0; i < sheetObjects.length; i++){
    			//Expire 일 경우는 첫번째 시트는 조회 하지 않는다.
    			if( i == 0) continue;
                doActionIBSheet(sheetObjects[i],formObj,IBSEARCH);
            }
            v_dmdt_bzc_trf_grp_nm = ComGetObjValue(formObj.dmdt_bzc_trf_grp_nm);
    		changeGroupType(formObj.dmdt_trf_grp_tp_cd);
    	//Create
    	//	Group Type:초기값(Billable)
    	//	Group Name, Eff_dt, Exp_dt, F/Time Exclusion, F/Time Commence:공백
    	//	CNTR Type, Cargo Type:그룹에 존재하는 Combination을 제외한 CNTR-Cargo Type 조회
    	}else if(ComGetObjValue(formObj.button_mode) == "C" ){
    		setInitCreate();
            //for(var i=0;i<sheetObjects.length;i++){
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
            //}

            formObj.dmdt_chg_cmnc_tp_cd.selectedIndex = -1;

    	}
    	ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, v_dmdt_bzc_trf_grp_nm);
    	
    	//cvrg region, state 셋팅
    	if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_ste_cd));
    	} else {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_rgn_cd));
    	}
    	//org_dest region, state 셋팅
    	if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd,  ComGetObjValue(formObj.org_dest_ste_cd));
    	} else {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd,  ComGetObjValue(formObj.org_dest_rgn_cd));
    	}	   
    	
		if ( ComGetObjValue(formObj.button_mode) == "E" ){
			formObj.xtn_flg.readOnly = false;
			formObj.xtn_flg.disabled = false;
		} else {
			formObj.xtn_flg.readOnly = true;
			formObj.xtn_flg.disabled = true;	
		}
    }
    
	function initAxonControl() { 
	    //Axon 이벤트 처리1. 이벤트catch 
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerFormat('blur',	'obj_blur',		document.form); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
	}

	//Axon 이벤트 처리2. 이벤트처리함수  
	function obj_keypress(){ 
		switch(event.srcElement.dataformat){
		case "engup":
	    	// 영문대+숫자 
    		ComKeyOnlyAlphabet('uppernum', ',');
	        break;
    	case "engup2":
	    	// 영문대+숫자+예외문자
    		DmtComKeyOnlyAlphabet('uppernum', ',');
	        break;
    	case "int":
    		//숫자 만입력하기
    		ComKeyOnlyNumber(event.srcElement);
    		break;
    	case "engup3":
    		DmtComKeyOnlyAlphabet('upperchar');
    		break;
    	default:
         	// 숫자만입력하기(정수,날짜,시간)
            ComKeyOnlyNumber(event.srcElement);
	    }   
	}
//	function obj_activate() {
//		
//	    obj = event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus = obj.dataformat;
//
//	    switch(obj.dataformat) {
//        case "engup":
//          	ComKeyOnlyAlphabet('uppernum');          
//            break;   
//	    }   
//	}
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        ComClearSeparator(event.srcElement);
    	//alert("focus_in");
    }
	
    //포커스가 나갈 때
    function obj_blur(){
		var formObject = document.form;
    	//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;
		if(obj.name != "dmdt_bzc_trf_grp_nm")
			ComChkObjValid(obj);
		
		if(obj.name == "eff_dt"){
			var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject);
			var exp_dt_y = ComGetDateAdd(obj.value, "Y", 1);
			var exp_dt = ComGetDateAdd(exp_dt_y, "D", -1);
			if ( ofcCurrDate >= exp_dt ){
				exp_dt_y = ComGetDateAdd(ofcCurrDate, "Y", 1);
				exp_dt = ComGetDateAdd(exp_dt_y, "D", -1);
			}
				
			formObject.exp_dt.value = exp_dt;
		}
		
		if(obj.name == "exp_dt"){
			if ( obj.value != formObject.exp_dt_old.value ){
				var ofcCurrDate = formObject.eff_dt.value;
				var end_dt = ComGetDateAdd(ofcCurrDate, "D", 366);
				
				if ( obj.value >= end_dt ){
					ComAlertFocus(formObject.exp_dt, ComGetMsg('DMT01178'));
					formObject.exp_dt.value = formObject.exp_dt_old.value;
					return false;
				} else {
					formObject.exp_dt_old.value = obj.value;
				}
			}
			if( formObject.button_mode.value == "E" ){
				if ( obj.value != formObject.exp_dt_1.value ){
					formObject.xtn_flg.readOnly = true;
					formObject.xtn_flg.disabled = true;				
				} else {
					formObject.xtn_flg.readOnly = false;
					formObject.xtn_flg.disabled = false;
				}
			}
		}
		
		if(obj.name == "xcld_sat_flg"){
			alert(obj.value);
		}
		
		if(obj.name == "xtn_exp_dt"){
			var formObject = document.form;
			var xtn_exp_dt = ComGetDateAdd(formObject.xtn_eff_dt.value, "D", 365).replace(/-/gi,"");
			var obj_value = formObject.xtn_exp_dt.value;		
			
			if ( obj_value.replace(/-/gi,"") >= xtn_exp_dt){	
				ComShowCodeMessage("DMT01178", "Extension ");
				formObject.xtn_exp_dt.value = ComGetDateAdd(formObject.xtn_eff_dt.value, "D", 365);
				return false;
			}
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
                    style.height = 222;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 7, 100);

                    var HeadTitle = "||CNTR Type|Cargo Type|cntr_code|cargo_code";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,     0,		daCenter,	false,	"checkBox");
					InitDataProperty(0, cnt++ , dtData,      	180,	daCenter,	false,	"dmdt_cntr_tp_nm",		false,	"",		dfNone,			0,	false,		true,	10, false, false);
					InitDataProperty(0, cnt++ , dtData,      	150,	daCenter,	false,	"dmdt_cgo_tp_nm",		false,	"",		dfNone,			0,	false,		true,	20, false, false);
					InitDataProperty(0, cnt++ , dtHidden,      	180,	daCenter,	false,	"dmdt_cntr_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,      	150,	daCenter,	false,	"dmdt_cgo_tp_cd");

					CountPosition = 0;		// 건수 정보를 표시하지 않음.
               }
                break;


            case 2:      // sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 222;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

					// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 7, 100);

                    var HeadTitle = "||CNTR Type|Cargo Type|cntr_code|cargo_code";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,      		0,		daCenter,	false,	"checkBox");
					InitDataProperty(0, cnt++ , dtData,      			180,		daCenter,	false,	"dmdt_cntr_tp_nm",		false,	"",		dfNone,			0,	false,		true,	10, false, false);
					InitDataProperty(0, cnt++ , dtData,      			150,		daCenter,	false,	"dmdt_cgo_tp_nm",		false,	"",		dfNone,			0,	false,		true,	20, false, false);
					InitDataProperty(0, cnt++ , dtHidden,      			180,		daCenter,	false,	"dmdt_cntr_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,      			150,		daCenter,	false,	"dmdt_cgo_tp_cd");

					CountPosition = 0;		// 건수 정보를 표시하지 않음.

			   }
                break;

            case 3:      // sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 142;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 2, 100);

                    var HeadTitle = "|CNTR Q'ty|CNTR Q'ty|Free Day|";
					var HeadTitle2 = "|From|Up To|Free Day|";
					
					var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)


					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,		"ft_fm_qty",	true,		"",			dfInteger,		0,			false,		false,		2, 		false, 		false);
					InitDataProperty(0, cnt++ , dtData,    		90,		daCenter,	false,		"ft_to_qty",	false,		"",			dfNullInteger,		0,			true,		true,		2, 		false, 		false);
					InitDataProperty(0, cnt++ , dtData,      	70,		daCenter,	true,		"ft_dys",		true,		"",			dfInteger,		0,			true,		true,		2, 		false, 		false);
					InitDataProperty(0, cnt++ , dtHidden,      	70,		daCenter,	true,		"trf_ft_seq");
					
					CountPosition = 0;		// 건수 정보를 표시하지 않음.

			   }
                break;

            case 4:      // sheet4 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 142;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 2, 100);

					var HeadTitle = "|Over Day|Over Day|Rate Per Day|Rate Per Day|Rate Per Day|Rate Per Day|Rate Per Day|";
					var HeadTitle2 = "|From|Up To|20 FT|40 FT|H/C|45 FT|R9|";

					var headCount = ComCountHeadTitle(HeadTitle);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	false,	"ft_ovr_dys",		true,	"",		dfInteger,		0,			false,		false,	2, false, false);
					InitDataProperty(0, cnt++ , dtData,    		50,	daCenter,	false,	"ft_und_dys",		false,	"",		dfNullInteger,	0,			true,		true,	2, false, false);
					InitDataProperty(0, cnt++ , dtData,      	95,	daRight,	true,	"cntr_20ft_rt_amt",		true,	"",		dfFloat,	    2,			true,		true,	20, false, false);
					InitDataProperty(0, cnt++ , dtData,      	95,	daRight,	true,	"cntr_40ft_rt_amt",		true,	"",		dfFloat,	    2,			true,		true,	20, false, false);
					InitDataProperty(0, cnt++ , dtData,      	95,	daRight,	true,	"cntr_hc_rt_amt",		true,	"",		dfFloat,	    2,			true,		true,	20, false, false);
					InitDataProperty(0, cnt++ , dtData,      	95,	daRight,	true,	"cntr_45ft_rt_amt",		true,	"",		dfFloat,	    2,			true,		true,	20, false, false);
					InitDataProperty(0, cnt++ , dtData,      	95,	daRight,	true,	"cntr_r9_rt_amt",		true,	"",		dfFloat,    	2,			true,		true,	20, false, false);
					InitDataProperty(0, cnt++ , dtHidden,      	95,	daRight,	true,	"trf_rt_seq");
					
					CountPosition = 0;		// 건수 정보를 표시하지 않음.

			   }
                break;

        }
    }

	// 콤보관련 데이터를 조회하는 함수
	function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {
			//Tariff Type 불러오기
			case IBSEARCH:
				var comboDatas;
				
				switch(sComboAction) {
						
					//3-1.Currency 항목 조회
					case COMMAND05:
						//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						ComSetObjValue(formObj.f_cmd, COMMAND05);
						//2.조회조건으로 조회실행
						var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

						ComClearCombo(formObj.currency);
						comboDatas = ComGetEtcData(sXml, sComboKey);
						if (comboDatas != undefined) {
							comboDatas = " = |" + comboDatas;
							addComboItem(formObj.currency,comboDatas,true);
						}
						break;		
				};
				break;
        }
		sheetObj.WaitImageVisible = true;
    }	
	  // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	    switch(sAction) {

			case IBSEARCH:      //조회
				if(sheetObj.id == "sheet1") {
					
					if(ComGetObjValue(formObj.button_mode) == "C") {
						ComSetObjValue(formObj.f_cmd, SEARCH);
					}else{
						ComSetObjValue(formObj.f_cmd, SEARCH04);
					}
					
                    //ComOpenWait Start
                    sheetObj.WaitImageVisible=false;
                    ComOpenWait(true);
					
					sheetObj.DoSearch("EES_DMT_1002GS.do", FormQueryString(formObj));
					
                    //ComOpenWait End
                    ComOpenWait(false);

                    //TOTAL COUNT = 0이면 Next 버튼 비활성화
					if(sheetObj.TotalRows == 0) {
						ComBtnDisable("btn_next");
					}

				} else if(sheetObj.id == "sheet2") {
					ComSetObjValue(formObj.f_cmd, SEARCH01);
					setParameters(SEARCH01);	//

                    //ComOpenWait Start
                    sheetObj.WaitImageVisible=false;
                    ComOpenWait(true);
					
					//전체 조회
					var sXml = sheetObj.GetSearchXml("EES_DMT_1002GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
					
                    //ComOpenWait End
                    ComOpenWait(false);

					//FormSetting
					ComSetObjValue(formObj.cmnc_hr, 	ComTrim(ComGetEtcData(sXml, "cmnc_hr")));
					ComSetObjValue(formObj.curr_cd, 	ComTrim(ComGetEtcData(sXml, "curr_cd")));
					ComSetObjValue(formObj.currency, 	ComTrim(ComGetEtcData(sXml, "curr_cd")));
					ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, ComTrim(ComGetEtcData(sXml, "dmdt_bzc_trf_grp_nm")));
					ComSetObjValue(formObj.dmdt_chg_cmnc_tp_cd, ComTrim(ComGetEtcData(sXml, "dmdt_chg_cmnc_tp_cd")));
					ComSetObjValue(formObj.dmdt_trf_grp_tp_cd, 	ComTrim(ComGetEtcData(sXml, "dmdt_trf_grp_tp_cd")));
					
					//입력일 경우는 eff_dt를 공란으로 처리한다.
					if(ComGetObjValue(formObj.button_mode) == "C") {
						ComSetObjValue(formObj.eff_dt, 		"");
					}else{
						ComSetObjValue(formObj.eff_dt, 		ComTrim(ComGetEtcData(sXml, "eff_dt")));
					}
					ComSetObjValue(formObj.exp_dt, 		ComTrim(ComGetEtcData(sXml, "exp_dt")));
					ComSetObjValue(formObj.exp_dt_old, 		ComTrim(ComGetEtcData(sXml, "exp_dt")));
					ComSetObjValue(formObj.exp_dt_1, 		ComTrim(ComGetEtcData(sXml, "exp_dt")));
					
					if(ComTrim(ComGetEtcData(sXml, "xcld_hol_flg")) == "Y") {
						ComSetObjValue(formObj.xcld_hol_flg, "Y");
					}else{
						ComSetObjValue(formObj.xcld_hol_flg, "");
					}
					if(ComTrim(ComGetEtcData(sXml, "xcld_sat_flg")) == "Y") {
						ComSetObjValue(formObj.xcld_sat_flg, "Y");
					}else{
						ComSetObjValue(formObj.xcld_sat_flg, "");
					}
					if(ComTrim(ComGetEtcData(sXml, "xcld_sun_flg")) == "Y") {
						ComSetObjValue(formObj.xcld_sun_flg, "Y");
					}else{
						ComSetObjValue(formObj.xcld_sun_flg, "");
					}
					
					if(ComTrim(ComGetEtcData(sXml, "bzc_trf_xtn_flg")) == "Y" && ComGetObjValue(formObj.button_mode) != "E") {
						ComSetObjValue(formObj.bzc_trf_xtn_flg, "Y");
						formObj.xtn_flg.value = "Y";
						formObj.xtn_flg.checked = true;
					} else if ( ComGetObjValue(formObj.button_mode) == "E" ) {
						ComSetObjValue(formObj.bzc_trf_xtn_flg, "N");
						ComSetObjValue(formObj.xtn_flg, "N");
						formObj.xtn_flg.checked = false;
					}else{
						ComSetObjValue(formObj.bzc_trf_xtn_flg, "N");
						formObj.xtn_flg.value = "N";
						formObj.xtn_flg.checked = false;
					}			
					if ( ComGetObjValue(formObj.button_mode) == "U" && formObj.bzc_trf_xtn_flg.value == "Y"){
						formObj.eff_dt.readOnly = true;
						formObj.eff_dt.className = "input2";
					}
					
				} else if(sheetObj.id == "sheet3") {
					if(ComGetObjValue(formObj.button_mode) == "U") {
						if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							setParameters(SEARCH02);		

		                    //ComOpenWait Start
		                    sheetObj.WaitImageVisible=false;
		                    ComOpenWait(true);
							
							sheetObj.DoSearch("EES_DMT_1002GS.do", FormQueryString(formObj));

		                    //ComOpenWait End
		                    ComOpenWait(false);

		                    sheetObj.CellValue(sheetObj.LastRow, "ft_to_qty") = "";
						}
					}else if(ComGetObjValue(formObj.button_mode) == "E") {
						if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							setParameters(SEARCH02);		
		                    
							//ComOpenWait Start
		                    sheetObj.WaitImageVisible=false;
		                    ComOpenWait(true);
							
//							sheetObj.DoSearch("EES_DMT_1002GS.do", FormQueryString(formObj));
		                    sheet3_xml = sheetObj.GetSearchXml("EES_DMT_1002GS.do", FormQueryString(formObj));
		                    if (sheet3_xml != "") sheetObj.LoadSearchXml(sheet3_xml);
		                    
							//ComOpenWait End
		                    ComOpenWait(false);

							sheetObj.CellValue(sheetObj.LastRow, "ft_to_qty") = "";
						}
					}
					
				} else if(sheetObj.id == "sheet4") {
					if(ComGetObjValue(formObj.button_mode) == "U") {
						if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
							ComSetObjValue(formObj.f_cmd, SEARCH03);
							setParameters(SEARCH03);		

							//ComOpenWait Start
		                    sheetObj.WaitImageVisible=false;
		                    ComOpenWait(true);

		                    sheetObj.DoSearch("EES_DMT_1002GS.do", FormQueryString(formObj));
							
							//ComOpenWait End
		                    ComOpenWait(false);

		                    sheetObj.CellValue(sheetObj.LastRow, "ft_und_dys") = "";
						}
					}else if(ComGetObjValue(formObj.button_mode) == "E") {
						if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
							ComSetObjValue(formObj.f_cmd, SEARCH03);
							setParameters(SEARCH03);		

							//ComOpenWait Start
		                    sheetObj.WaitImageVisible=false;
		                    ComOpenWait(true);

//							sheetObj.DoSearch("EES_DMT_1002GS.do", FormQueryString(formObj));
		                    sheet4_xml = sheetObj.GetSearchXml("EES_DMT_1002GS.do", FormQueryString(formObj));
		                    if (sheet4_xml != "") sheetObj.LoadSearchXml(sheet4_xml);

							//ComOpenWait End
		                    ComOpenWait(false);

							sheetObj.CellValue(sheetObj.LastRow, "ft_und_dys") = "";
						}
					}
				}
				
				break;
			
			case IBINSERT:
				if (sheetObj.id == "sheet3") {
					var row = sheetObj.DataInsert(-1);
					//첫행
					if(row == 2) {
						sheetObj.CellValue2(row, "ft_fm_qty") = 1;
						sheetObj.SelectCell(row, "ft_to_qty");
					} else {
						//Up to 입력해야 Row Add 가능 
						if(sheetObj.CellValue(row - 1, "ft_to_qty") == "") {
							ComShowCodeMessage("DMT02002", "Up to");
							sheetObj.RowDelete(-1,false);
						}else{
							var value = parseInt(sheetObj.CellValue(row - 1, "ft_to_qty")) + 1;;
							sheetObj.CellValue2(row, "ft_fm_qty") = value;
							sheetObj.SelectCell(row, "ft_to_qty");
						}
					}
				} else if(sheetObj.id == "sheet4") {
					var row = sheetObj.DataInsert(-1);
					//첫행
					if(row == 2) {
						sheetObj.CellValue2(row, "ft_ovr_dys") = 1;
						sheetObj.SelectCell(row, "ft_und_dys");
					} else {
						//Up to 입력해야 Row Add 가능 
						if(sheetObj.CellValue(row - 1, "ft_und_dys") == "") {
							ComShowCodeMessage("DMT02002", "Up to");
							sheetObj.RowDelete(-1,false);
						}else{
							var value = parseInt(sheetObj.CellValue(row - 1, "ft_und_dys")) + 1;
							sheetObj.CellValue2(row, "ft_ovr_dys") = value;
							sheetObj.SelectCell(row, "ft_und_dys");
						}
					}
				}
				break;

			case IBDELETE:
				if (sheetObj.id == "sheet3") { 
					sheetObj.RowDelete(sheetObj.RowCount+1, false);
				} else if(sheetObj.id == "sheet4") {
					sheetObj.RowDelete(sheetObj.RowCount+1, false);
				}
				break;

			case IBSAVE:        //저장
				if(ComGetObjValue(formObj.button_mode) == "C" || (ComGetObjValue(formObj.button_mode) == "E" && ComGetObjValue(formObj.xtn_flg) == "Y" )) {
					ComSetObjValue(formObj.f_cmd, MULTI);
					setParameters(MULTI);
				}else if(ComGetObjValue(formObj.button_mode) == "U") {
					ComSetObjValue(formObj.f_cmd, MULTI01);
					setParameters(MULTI01);
				}else if(ComGetObjValue(formObj.button_mode) == "E") {
					ComSetObjValue(formObj.f_cmd, MULTI02);
					setParameters(MULTI02);
				}
				
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				//Free Time 0 가능하게
				var ft_day_zero_check = false;
				
				if(ComGetObjValue(formObj.button_mode) == "C" || ComGetObjValue(formObj.button_mode) == "U" || (ComGetObjValue(formObj.button_mode) == "E" && ComGetObjValue(formObj.xtn_flg) == "Y" )) {
					if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
						for(var i = 2 ; i < sheetObjects[2].RowCount +2; i++) {
							if(sheetObjects[2].CellValue(i, "ft_dys") == 0) {
								ft_day_zero_check = true;
								break;
							}
						}
					}
				}
				
				if(ft_day_zero_check) {
					if(!ComShowCodeConfirm('DMT01138')) return false;
				}
				//
				
				sheetObjects[2].CellValue2(sheetObjects[2].LastRow, "ft_to_qty") = 0;
				sheetObjects[3].CellValue2(sheetObjects[3].LastRow, "ft_und_dys") = 0;
				
				var sParam1 = sheetObjects[1].GetSaveString(true); 
				var sParam2 = sheetObjects[2].GetSaveString(true); 
				var sParam3 = sheetObjects[3].GetSaveString(true); 
				var sParam4 = FormQueryString(formObj);

				sheetObjects[2].CellValue2(sheetObjects[2].LastRow, "ft_to_qty") = "";
				sheetObjects[3].CellValue2(sheetObjects[3].LastRow, "ft_und_dys") = "";
				
				sParam1 = ComSetPrifix(sParam1, "grid1") + "&";
				sParam2 = ComSetPrifix(sParam2, "grid2") + "&";
				sParam3 = ComSetPrifix(sParam3, "grid3") + "&";
				
				var sParam = sParam1 + sParam2 + sParam3 + FormQueryString(formObj);

                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
				
				var sXml = sheetObj.GetSaveXml("EES_DMT_1002GS.do", sParam);
				//3.저장 후 결과처리
				sheetObj.LoadSaveXml(sXml);
				
                //ComOpenWait End
                ComOpenWait(false);
				
				//저장후 버튼 처리
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
				
				//4.저장후 저장버튼 처리
				if(ComGetObjValue(formObj.success_yn) == "Y"){
					//////////////////////////////////////////////////////
					
					if(ComGetObjValue(formObj.button_mode) == "C" || ComGetObjValue(formObj.button_mode) == "U" ){
						sheetObjects[1].RemoveAll();
						ComBtnDisable("btn_save");
						if(sheetObj.RowCount == 0){
							ComBtnDisable("btn_next");
						}else{
							ComBtnEnable("btn_next");
						}
						//UPDATE를 한번하고 나면 NEXT를 눌러서 CREATE작업을 할 수 있다.
						if(ComGetObjValue(formObj.button_mode) == "U"){
							ComSetObjValue(formObj.button_mode, "C");
						}
					}else{
						//sheetObjects[0].RemoveAll();
						ComBtnDisable("btn_save");
						if(sheetObj.RowCount == 0){
							ComBtnDisable("btn_next");
						}else{
							ComBtnEnable("btn_next");
						}
					}
					////////////////////////////////////////////
				}else{
					ComBtnEnable("btn_save");
					ComBtnDisable("btn_next");
				}
					
				break;
				
			case IBNEXT:
				for(var i = sheetObj.TotalRows+1 ; i > 0 ; i--) {
					sheetObj.RowDelete(-1,false);
				}
				
				ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, "");
				//ComSetObjValue(formObj.eff_dt, 	ComGetObjValue(formObj.eff_dt));
				ComSetObjValue(formObj.exp_dt, 	"");
				//ComSetObjValue(formObj.cmnc_hr, ComGetObjValue(formObj.cmnc_hr));
				//ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.curr_cd));
				
				formObj.xcld_hol_flg.checked = false;
				formObj.xcld_sat_flg.checked = false;
				formObj.xcld_sun_flg.checked = false;

				formObj.dmdt_trf_grp_tp_cd.selectedIndex 	= 0;
				//formObj.dmdt_chg_cmnc_tp_cd.selectedIndex 	= -1;
				//formObj.currency.selectedIndex 				= -1;
				
				changeGroupType(formObj.dmdt_trf_grp_tp_cd);
				
				for(var i = sheetObjects[2].RowCount+1 ; i > 0 ; i--) {
					sheetObjects[2].RowDelete(-1,false);
				}
				
				for(var i = sheetObjects[3].RowCount+1 ; i > 0 ; i--) {
					sheetObjects[3].RowDelete(-1,false);
				}
				
				ComBtnEnable("btn_save");
				if(sheetObjects[0].RowCount == 0){
					ComBtnDisable("btn_next");
				}else{
					ComBtnEnable("btn_next");
				}
				
				break;
		
        }
    }
	
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		var currency = ComGetObjValue(formObj.currency);
		
		ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.currency));	//curr_cd
	}	

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		
    		switch(sAction) {
    			case IBSAVE:
    				//Create, Update
    				if(ComGetObjValue(formObj.button_mode) == "C" || ComGetObjValue(formObj.button_mode) == "U") {
    					//Billable, Group Name
    					if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd)=="B" && ComGetObjValue(formObj.dmdt_bzc_trf_grp_nm) == "") {
							ComAlertFocus(formObj.dmdt_trf_grp_tp_cd, ComGetMsg('DMT02002', "Group Name"));
							return false;
						}
    					//Effective DT
	    				if(ComGetObjValue(formObj.eff_dt) == "") {
	    					ComAlertFocus(formObj.dmdt_trf_grp_tp_cd, ComGetMsg('DMT02002', "Effective DT"));
							return false;
	    				}
    					//Expiration DT
	    				if(ComGetObjValue(formObj.exp_dt) == "") {
	    					ComAlertFocus(formObj.dmdt_trf_grp_tp_cd, ComGetMsg('DMT02002', "Expiration DT"));
							return false;
	    				}
    					//exp_dt >= eff_dt 
    					var from_dt = ComGetObjValue(formObj.eff_dt);
    					var to_dt	= ComGetObjValue(formObj.exp_dt);
    					
    					if(ComChkPeriod(from_dt, to_dt) == 0) {
    						ComAlertFocus(formObj.exp_dt, ComGetMsg('COM12133', "Expiration Date", "Effective Date", "greater than or equal"));
							return false;
    					}
	    				
	    				//Billable 일 경우
	    				if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd)=="B") {
	    				
		    				if(ComGetObjValue(formObj.dmdt_chg_cmnc_tp_cd) == "") {
		    					ComAlertFocus(formObj.dmdt_chg_cmnc_tp_cd, ComGetMsg('DMT02002', "F/Time Commence"));
								return false;
		    				}
		    				if(ComGetObjValue(formObj.dmdt_chg_cmnc_tp_cd) == "3") {
		    					if(ComGetObjValue(formObj.cmnc_hr) == "") {
		    						ComAlertFocus(formObj.cmnc_hr, ComGetMsg('DMT02002', "F/Time Commence Hour"));
									return false;
		    					}
		    				}
		    				
		    				if(ComTrim(ComGetObjValue(formObj.currency)) == "") {
		    					ComAlertFocus(formObj.currency, ComGetMsg('DMT02002', "Currency"));
								return false;
		    				}
	    				}
						
	    				//combination이 0이면 저장 불가 처리 
	    				if(sheetObjects[1].TotalRows == 0) {
	    					ComShowCodeMessage("DMT02002", "CNTR, CGO Type");
	    					return false;
	    				}
						
	    				//Billable 일 경우
	    				if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
	    					if(sheetObjects[2].RowCount == 0 ) {
	    						ComShowCodeMessage("DMT02002", "F/Time");
	    						return false;
	    					}
	    					if(sheetObjects[3].RowCount == 0 ) {
	    						ComShowCodeMessage("DMT02002", "Rate");
	    						return false;
	    					}
	    				}

	    				//Billable 일 경우
	    				if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
		    				//F/Time Exclusion check 
		    				for(var i = sheetObjects[2].HeaderRows ; i < sheetObjects[2].LastRow; i++) {
		    					
		    					if(sheetObjects[2].CellValue(i, "ft_fm_qty") == "") {
		    						ComShowCodeMessage("DMT02002", "CNTR Q'ty From");
		    						sheetObjects[2].SelectCell(i, "ft_fm_qty");
		    						return false;
		    					}
		    					
		    					//맨마지막 제외하고 TO 체크
		    					if(i != parseInt(sheetObjects[2].LastRow)) {
		    						if(sheetObjects[2].CellValue(i, "ft_to_qty") == "") {
		    							ComShowCodeMessage("DMT02002", "CNTR Q'ty Up To");
			    						sheetObjects[2].SelectCell(i, "ft_to_qty");
			    						return false;
			    					}	
		    					}
		 					}
		    				
		    				//F/Time Commence check 
		    				for(var i = sheetObjects[3].HeaderRows; i< sheetObjects[3].LastRow; i++) {
		    					if(sheetObjects[3].CellValue(i, "ft_ovr_dys") == "") {
		    						ComShowCodeMessage("DMT02002", "Over Day From");
		    						sheetObjects[3].SelectCell(i, "ft_ovr_dys");
		    						return false;
		    					}
		    					//맨마지막 제외하고 TO 체크
		    					if(i != parseInt(sheetObjects[3].LastRow)) {
		    						if(sheetObjects[3].CellValue(i, "ft_und_dys") == "") {
		    							ComShowCodeMessage("DMT02002", "Over Day Up To");
			    						sheetObjects[3].SelectCell(i, "ft_und_dys");
			    						return false;
			    					}	
		    					}		    					
		    					if(sheetObjects[3].CellValue(i, "cntr_20ft_rt_amt") == 0) {
		    						ComShowCodeMessage("DMT02002", "Rate Per Day 20FT");
		    						sheetObjects[3].SelectCell(i, "cntr_20ft_rt_amt");
		    						return false;
		    					}
		    					if(sheetObjects[3].CellValue(i, "cntr_40ft_rt_amt") == 0) {
		    						ComShowCodeMessage("DMT02002", "Rate Per Day 40FT");
		    						sheetObjects[3].SelectCell(i, "cntr_40ft_rt_amt");
		    						return false;
		    					}
		    					if(sheetObjects[3].CellValue(i, "cntr_hc_rt_amt") == 0) {
		    						ComShowCodeMessage("DMT02002", "Rate Per Day H/C");
		    						sheetObjects[3].SelectCell(i, "cntr_hc_rt_amt");
		    						return false;
		    					}
		    					if(sheetObjects[3].CellValue(i, "cntr_45ft_rt_amt") == 0) {
		    						ComShowCodeMessage("DMT02002", "Rate Per Day 45FT");
		    						sheetObjects[3].SelectCell(i, "cntr_45ft_rt_amt");
		    						return false;
		    					}
		    					if(sheetObjects[3].CellValue(i, "cntr_r9_rt_amt") == 0) {
		    						ComShowCodeMessage("DMT02002", "Rate Per Day R9");
		    						sheetObjects[3].SelectCell(i, "cntr_r9_rt_amt");
		    						return false;
		    					}
		 					}
		    				
		    				// Rate Check : Rate Per Day의 입력한 Row별 합이 0 일 경우를 확인한다. (Billable 일 경우에는 반드시 Rate 정보를 입력하도록 한다.)
		    				var sumRateAmtByRow= 0.0;
		    				var LastRow = sheetObjects[3].RowCount + 1		    			
		    				
		    				if (LastRow > 0 ) {
		    					sumRateAmtByRow = parseFloat(sheetObjects[3].CellValue(LastRow, "cntr_20ft_rt_amt"));
		    					sumRateAmtByRow += parseFloat(sheetObjects[3].CellValue(LastRow, "cntr_40ft_rt_amt"));
		    					sumRateAmtByRow += parseFloat(sheetObjects[3].CellValue(LastRow, "cntr_hc_rt_amt"));
		    					sumRateAmtByRow += parseFloat(sheetObjects[3].CellValue(LastRow, "cntr_45ft_rt_amt"));
		    					sumRateAmtByRow += parseFloat(sheetObjects[3].CellValue(LastRow, "cntr_r9_rt_amt"));
		    			
		    					if (sumRateAmtByRow == 0){
		    						ComShowCodeMessage("DMT02002", "Rate Per Day");
		    						sheetObjects[3].SelectCell(LastRow, "cntr_20ft_rt_amt");
		    						return false;
		    					}
		    				}
	    				}

	    				//Billable
	    				if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {

		    				//마지막 줄의 Up to는 반드시 공란이어야함 
		    				var last_ft_to_qty = sheetObjects[2].CellValue(sheetObjects[2].LastRow, "ft_to_qty" );
		    				var last_ft_und_dys = sheetObjects[3].CellValue(sheetObjects[3].LastRow, "ft_und_dys" );
		    				
		    				if(last_ft_to_qty != "" || last_ft_to_qty != 0) {
		    					ComShowCodeMessage("DMT00149");
		    					return false;
		    				}
		    				
		    				if(last_ft_und_dys != "" || last_ft_und_dys != 0) {
		    					ComShowCodeMessage("DMT00150");
		    					return false;
		    				}
		    				
		    				// Free Time Check : From, Up To Data Check
		    				for(var i = sheetObjects[2].HeaderRows ; i < sheetObjects[2].LastRow; i++) {
		    					if(ComParseInt(sheetObjects[2].CellValue(i, "ft_fm_qty")) > ComParseInt(sheetObjects[2].CellValue(i, "ft_to_qty"))) {
		    						ComShowCodeMessage("DMT01032", "[CNTR Q'ty] ");
		    						sheetObjects[2].CellValue2(i, "ft_to_qty") = "";
		    						return false;
		    					}
		 					}
		    				
		    				// Rate Check : From, Up To Data Check 
		    				for(var i = sheetObjects[3].HeaderRows; i < sheetObjects[3].LastRow; i++) {
		    					if(ComParseInt(sheetObjects[3].CellValue(i, "ft_ovr_dys")) > ComParseInt(sheetObjects[3].CellValue(i, "ft_und_dys"))) {
		    						ComShowCodeMessage("DMT01032", "[Over Day] ");
		    						sheetObjects[3].CellValue2(i, "ft_und_dys") = "";
		    						return false;
		    					}
		 					}

	    				}
	    			//Expire 일때
    				}else if(ComGetObjValue(formObj.button_mode) == "E") {
    					if(ComGetObjValue(formObj.eff_dt) == "") {
	    					ComAlertFocus(formObj.dmdt_trf_grp_tp_cd, ComGetMsg('COM12113', "Effective Date"));
							return false;
	    				}
    					//exp_dt >= eff_dt 
    					var from_dt = ComGetObjValue(formObj.eff_dt);
    					var to_dt	= ComGetObjValue(formObj.exp_dt);
    					
    					if(ComChkPeriod(from_dt, to_dt) == 0) {
    						ComAlertFocus(formObj.exp_dt, ComGetMsg('COM12133', "Expiration Date", "Effective Date", "greater than or equal"));
							return false;
    					}    					

    					//currency
	    				if(ComTrim(ComGetObjValue(formObj.currency)) == "") {
	    					ComAlertFocus(formObj.currency, ComGetMsg('DMT02002', "Currency"));
							return false;
	    				}
    				}
    				
    				break;
    		}
        }

        return true;
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj,comboDatas,isOnlyCode) {
		var comboItem;
		var comboItems;
		var val;
		var txt;
		if (comboDatas != undefined) {
			comboItems = comboDatas.split(ROWMARK);	
	    	for (var i = 0 ; i < comboItems.length ; i++) {
    			comboItem = comboItems[i].split(FIELDMARK);
				val = comboItem[0];
				txt = isOnlyCode ? comboItem[0] : comboItem[1];
				ComAddComboItem(comboObj,val,txt);
    		}
		}   		
	}
	
    /**
     * Rate Adjustment Sheet 의 Currency 를 조회하는 함수
     */	
	function searchCurrencyList(cnt_cd) {
		var sheetObj = sheetObjects[3];
		var formObj = document.form;
		ComSetObjValue(formObj.cnt_cd, cnt_cd);
	
		doActionIBCombo(sheetObj,formObj,IBSEARCH,COMMAND05,"CURRENCY");
	}

	/**
	 * Group Type이 Billable 일 경우 활성화, Exempted 일 경우 비활성화
	 * @param object
	 * @return
	 */
    function changeGroupType(object) {
    	var formObj = document.form;
    	
    	if(ComGetObjValue(object) == "B") {
    		//Expire인 경우
    		if(ComGetObjValue(formObj.button_mode) == "E") {
    			ComEnableObject(formObj.dmdt_bzc_trf_grp_nm, false);
	   			ComEnableObject(formObj.xcld_sat_flg, false);
	   			ComEnableObject(formObj.xcld_sun_flg, false);
	   			ComEnableObject(formObj.xcld_hol_flg, false);
	   			
	   			//F/Time Commence
	   			ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, false);
   				ComEnableObject(formObj.cmnc_hr, false);
   				formObj.cmnc_hr.className = "input2";
	   			
	   			ComEnableObject(formObj.currency, false);
	   			//CNTR QTY 활성화
				sheetObjects[2].Editable = false;
	   			//Over Day 활성화
				sheetObjects[3].Editable = false;
				
				//RowAdd
				ComBtnDisable("btn_rowadd");
				ComBtnDisable("btn_rowdelete");
				ComBtnDisable("btn_rowadd2");
				ComBtnDisable("btn_rowdelete2");
				
				formObj.dmdt_bzc_trf_grp_nm.className = "input2";
	   			formObj.dmdt_chg_cmnc_tp_cd.className = "input2";
	   			formObj.currency.className = "input2";
	   			
	   			
    		}else {
				ComEnableObject(formObj.dmdt_bzc_trf_grp_nm, true);
	   			ComEnableObject(formObj.xcld_sat_flg, true);
	   			ComEnableObject(formObj.xcld_sun_flg, true);
	   			ComEnableObject(formObj.xcld_hol_flg, true);
	   			
	   			//F/Time Commence
	   			ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, true);
	   			
	   			if(ComGetObjValue(formObj.dmdt_chg_cmnc_tp_cd) == "3") {
	   				ComEnableObject(formObj.cmnc_hr, true);
	   				formObj.cmnc_hr.className = "input1";
	   			} else {
	   				ComEnableObject(formObj.cmnc_hr, false);
	   				formObj.cmnc_hr.className = "input2";
	   			}
	   			
	   			ComEnableObject(formObj.currency, true);
	   			//CNTR QTY 활성화
				sheetObjects[2].Editable = true;
	   			//Over Day 활성화
				sheetObjects[3].Editable = true;
				
				//RowAdd
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowdelete");
				ComBtnEnable("btn_rowadd2");
				ComBtnEnable("btn_rowdelete2");
				
				ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, "");
	   			
	   			formObj.dmdt_bzc_trf_grp_nm.className = "input1";
	   			formObj.dmdt_chg_cmnc_tp_cd.className = "input1";
	   			formObj.currency.className = "input1";
    		}
   			
    	}else if(ComGetObjValue(object) == "N"){
   			ComEnableObject(formObj.dmdt_bzc_trf_grp_nm, false);
   		
   			ComEnableObject(formObj.xcld_sat_flg, false);
   			ComEnableObject(formObj.xcld_sun_flg, false);
   			ComEnableObject(formObj.xcld_hol_flg, false);
   			
   			//F/Time Commence
   			ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, false);
   			ComEnableObject(formObj.cmnc_hr, false);
   			ComEnableObject(formObj.currency, false);
   			
   			//CNTR QTY 활성화
			sheetObjects[2].Editable = false;
   			//Over Day 활성화
			sheetObjects[3].Editable = false;
			
			//RowAdd
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowdelete");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_rowdelete2");
			
			//Group Name Expemted
			ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, "Exempted");
   			formObj.dmdt_bzc_trf_grp_nm.className = "input2";
			
			//F/Time Exclusion
			ComSetObjValue(formObj.xcld_sat_flg, "");
			ComSetObjValue(formObj.xcld_sun_flg, "");
			ComSetObjValue(formObj.xcld_hol_flg, "");
			
			//for(var i = sheetObjects[2].TotalRows+1 ; i > 1 ; i--) {
			for(var i = sheetObjects[2].RowCount+1 ; i > 1 ; i--) {
				sheetObjects[2].RowHidden(i)= true;
				//sheetObjects[2].RowDelete(-1,false);
				sheetObjects[2].RowStatus(i) = "D";
				
			}
			
			//F/Time Commence
			formObj.dmdt_chg_cmnc_tp_cd.selectedIndex = -1;
			formObj.currency.selectedIndex = -1;
			
			//myCombo.Code = -1;
			ComSetObjValue(formObj.cmnc_hr, "");
			//ComSetObjValue(formObj.currency, "");
			
			//for(var i = sheetObjects[3].TotalRows+1 ; i > 1 ; i--) {
			for(var i = sheetObjects[3].RowCount+1 ; i > 1 ; i--) {
				sheetObjects[3].RowHidden(i)= true;
				//sheetObjects[3].RowDelete(-1,false);
				sheetObjects[3].RowStatus(i) = "D";
			}
    	}
    }
    /**
     * F/Time Commence 설정
     * @param object
     * @return
     */
    function changeGroupCd1(object) {
    	var formObj = document.form;

    	if(ComGetObjValue(object) == "3") {
    		ComEnableObject(formObj.cmnc_hr, true);
			formObj.cmnc_hr.className = "input1";
    	} else {
    		ComEnableObject(formObj.cmnc_hr, false);
			formObj.cmnc_hr.className = "input2";
			ComSetObjValue(formObj.cmnc_hr, "");
    	}
    }
    
    //2자리 체크, 숫자 체크(01 ~ 23)
    function changeCmncHr() {
    	var formObj = document.form;
    	var tempCheck = false;
    	
    	for(var i = 0 ; i< cmnc_hr_array.length; i++) {
    		if(ComGetObjValue(formObj.cmnc_hr) == cmnc_hr_array[i]) {
    			tempCheck = true;
    			break;
    		}
    	}
    	if(!tempCheck) {
			ComShowCodeMessage("COM12187","01 ~ 23");
			ComClearObject(formObj.cmnc_hr);
			ComSetFocus(formObj.cmnc_hr);
			return;
    	}
    }
    
    /**
     * 
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnClick(sheetObj, row, col, Value) {
    	//전체선택 적용
        if(sheetObj.ColSaveName(col) == "checkBox")
              ComSyncAllCheck(sheetObj, col, Value);
    	
    }
    
    function sheet2_OnClick(sheetObj, row, col, Value) {
    	//전체선택 적용
        if(sheetObj.ColSaveName(col) == "checkBox")
             ComSyncAllCheck(sheetObj, col, Value);
    }
    
    //F/Time Exclusion 값을 변경한 후 이벤트 처리
    function sheet3_OnAfterEdit(sheetObj, row, col) {
    	var sName = sheetObj.ColSaveName(col);
    	var value = sheetObj.CellValue(row, col);
    	
    	if(sName == "ft_to_qty") {
			var ft_to_num = parseInt(sheetObj.CellValue(row, "ft_to_qty"));
			var ft_fm_num = parseInt(sheetObj.CellValue(row, "ft_fm_qty"));
			
			if(ft_fm_num > ft_to_num) {
				ComShowCodeMessage("DMT01032", "[CNTR Q'ty] ");
				sheetObj.CellValue2(row, "ft_to_qty") = "";
				return;
			}
    		//ft_to_qty 값을 변경시 다음행의 ft_fm_qty = ft_to_qty + 1로 처리한다.
			sheetObj.CellValue2(row+1, "ft_fm_qty") = parseInt(sheetObj.CellValue(row, "ft_to_qty")) + 1;
    	}
    }

    //F/Time Commence 값을 변경한 후 이벤트 처리
    function sheet4_OnAfterEdit(sheetObj, row, col) {
    	var sName = sheetObj.ColSaveName(col);
    	var value = sheetObj.CellValue(row, col);

    	if(sName == "ft_und_dys") {
    		var ft_ovr_num = parseInt(sheetObj.CellValue(row, "ft_ovr_dys"));
			var ft_und_num = parseInt(sheetObj.CellValue(row, "ft_und_dys"));
			
			if( ft_ovr_num > ft_und_num) {
				ComShowCodeMessage("DMT01032", "[Over Day] ");
				sheetObj.CellValue2(row, "ft_und_dys") = "";
				return;
			}
    		//ft_und_dys 값을 변경시 다음행의 ft_ovr_dys = ft_und_dys + 1로 처리한다.
			sheetObj.CellValue2(row+1, "ft_ovr_dys") = parseInt(sheetObj.CellValue(row, "ft_und_dys")) + 1;
    	}
    }
    
    /**
	 * sheet1 조회 후 처리
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
		
	}
    /**
     * Expire Button Click
     */
    function setInitExpire() {
    	var formObj = document.form;
    	
    	//값 셋팅
    	if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA" ) {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd, ComGetObjValue(formObj.org_dest_ste_cd));
    	}else{
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd, ComGetObjValue(formObj.org_dest_rgn_cd));
    	}
    	
    	if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA" ) {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd, ComGetObjValue(formObj.cvrg_ste_cd));
    	}else{
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd, ComGetObjValue(formObj.cvrg_rgn_cd));
    	}
		ComEnableObject(formObj.btns_clendar1, false);
		ComEnableObject(formObj.btns_clendar2, true);
		ComEnableObject(formObj.btn_add, false);
		ComEnableObject(formObj.btn_del, false);
		
    	//비활성화
		formObj.dmdt_trf_grp_tp_cd.disabled = true;
		formObj.dmdt_bzc_trf_grp_nm.readOnly = true;
		formObj.eff_dt.readOnly = true;
		
		if( formObj.exp_dt.vaule == undefined ){
			formObj.exp_dt.readOnly = false;
			formObj.exp_dt.className = "input1";
		} else {
			formObj.exp_dt.readOnly = true;
			formObj.exp_dt.className = "input2";
		}
		formObj.dmdt_chg_cmnc_tp_cd.disabled = true;
		formObj.cmnc_hr.readOnly = true;
		formObj.currency.disabled = true;
		
		formObj.dmdt_trf_grp_tp_cd.className = "input2";
		formObj.dmdt_bzc_trf_grp_nm.className = "input2";
		formObj.eff_dt.className = "input2";
		formObj.dmdt_chg_cmnc_tp_cd.className = "input2";
		formObj.cmnc_hr.className = "input2";
		formObj.currency.className = "input2";
		

		//Button
		ComBtnDisable("btn_rowadd");
		ComBtnDisable("btn_rowdelete");
		ComBtnDisable("btn_rowadd2");
		ComBtnDisable("btn_rowdelete2");
		ComBtnDisable("btn_next");
		// F/Time Commence 
		ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, false);
		ComEnableObject(formObj.cmnc_hr, false);
		ComEnableObject(formObj.currency, false);
		ComEnableObject(formObj.xcld_sat_flg, false);
		ComEnableObject(formObj.xcld_sun_flg, false);
		ComEnableObject(formObj.xcld_hol_flg, false);
		
		for(var i=0; i < sheetObjects.length ; i++) {
			sheetObjects[i].Editable = false;
		}
		
    }
    
    function setIntitUpdate() {
    	var formObj = document.form;
		ComEnableObject(formObj.btns_clendar1, true);
		ComEnableObject(formObj.btns_clendar2, false);

		ComEnableObject(formObj.btn_add, true);
		ComEnableObject(formObj.btn_del, true);
		formObj.eff_dt.readOnly = false;
		formObj.exp_dt.readOnly = false;
    	
		//Button
		ComBtnEnable("btn_rowadd");
		ComBtnEnable("btn_rowdelete");
		ComBtnEnable("btn_rowadd2");
		ComBtnEnable("btn_rowdelete2");
		ComBtnDisable("btn_next");
		// F/Time Commence 
		ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, true);
		ComEnableObject(formObj.cmnc_hr, true);
		ComEnableObject(formObj.currency, true);
		
		//
    }

    
    function setInitCreate() {
    	var formObj = document.form;

    	ComEnableObject(formObj.btns_clendar1, true);
   		formObj.eff_dt.readOnly = false;
		ComEnableObject(formObj.btns_clendar2, false);
		formObj.exp_dt.readOnly = false;
		ComEnableObject(formObj.btn_add, true);
		ComEnableObject(formObj.btn_del, true);
		
		//Button
		ComBtnEnable("btn_rowadd");
		ComBtnEnable("btn_rowdelete");
		ComBtnEnable("btn_rowadd2");
		ComBtnEnable("btn_rowdelete2");
		ComBtnDisable("btn_next");
		
		// F/Time Commence 
		ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, true);
		ComEnableObject(formObj.cmnc_hr, false);
		ComEnableObject(formObj.currency, true);
		
		formObj.dmdt_chg_cmnc_tp_cd.className 	= "input1";
		formObj.cmnc_hr.className 				= "input2";
		formObj.currency.className 				= "input1";
    }
    //onUnLoad Event
    function unLoadPage(){
		window.returnValue="Y";
    }
    
    /*
	 * Extension
	 */
	function doXtnFlg() {
		var formObj = document.form;
		
		if(formObj.xtn_flg.checked) {
			
			formObj.xtn_flg.value = "Y";
			formObj.bzc_trf_xtn_flg.value = "Y";
			ComSetDisplay('xtn_dt_chk', true);
			formObj.exp_dt.readOnly = true;
			formObj.exp_dt.className = "input2";
			ComEnableObject(formObj.btns_clendar2, false);
			
			formObj.xtn_eff_dt.value = ComGetDateAdd(formObj.exp_dt.value, "D", 1);
			
			var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObj);
			var xtn_eff_dt_y = ComGetDateAdd(formObj.xtn_eff_dt.value, "Y", 1);
			var xtn_eff_dt = ComGetDateAdd(xtn_eff_dt_y, "D", -1);
			if ( ofcCurrDate >= xtn_eff_dt ){
				xtn_eff_dt_y = ComGetDateAdd(ofcCurrDate, "Y", 1);
				xtn_eff_dt = ComGetDateAdd(xtn_eff_dt_y, "D", -1);
			}
			
			formObj.xtn_exp_dt.value = xtn_eff_dt;			

			//Button
			ComBtnEnable("btn_rowadd");
			ComBtnEnable("btn_rowdelete");
			ComBtnEnable("btn_rowadd2");
			ComBtnEnable("btn_rowdelete2");
			
			ComEnableObject(formObj.xcld_sat_flg, true);
			ComEnableObject(formObj.xcld_sun_flg, true);
			ComEnableObject(formObj.xcld_hol_flg, true);
			
			// F/Time Commence 
			ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, true);
			ComEnableObject(formObj.cmnc_hr, true);
			ComEnableObject(formObj.currency, true);
			
			formObj.dmdt_chg_cmnc_tp_cd.className 	= "input1";
//			formObj.cmnc_hr.className 				= "input2";
			changeGroupCd1(formObj.dmdt_chg_cmnc_tp_cd);
			formObj.currency.className 				= "input1";
			
			old_xcld_sat_flg = formObj.xcld_sat_flg.checked;
			old_xcld_sun_flg = formObj.xcld_sun_flg.checked;
			old_xcld_hol_flg = formObj.xcld_hol_flg.checked;

			// F/Time Commence 
			old_dmdt_chg_cmnc_tp_cd = formObj.dmdt_chg_cmnc_tp_cd.value;
			old_cmnc_hr = formObj.cmnc_hr.value;
			old_currency = formObj.currency.value;
			
			sheetObjects[2].Editable = true;
			sheetObjects[3].Editable = true;
			
			for(var i = 1 ; i < sheetObjects[1].RowCount +1; i++) {
				sheetObjects[1].CellValue(i, "ibflag") = "U";
			}
			
		} else {

			formObj.xtn_flg.value = "N";
			formObj.bzc_trf_xtn_flg.value = "N";
			ComSetDisplay('xtn_dt_chk', false);
			formObj.exp_dt.readOnly = false;
			formObj.exp_dt.className = "input1";
			ComEnableObject(formObj.btns_clendar2, true);
			

			//Button
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowdelete");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_rowdelete2");
			
			ComEnableObject(formObj.xcld_sat_flg, false);
			ComEnableObject(formObj.xcld_sun_flg, false);
			ComEnableObject(formObj.xcld_hol_flg, false);
			
			// F/Time Commence 
			ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, false);
			ComEnableObject(formObj.cmnc_hr, false);
			ComEnableObject(formObj.currency, false);
			
			formObj.dmdt_chg_cmnc_tp_cd.className 	= "input2";
			formObj.cmnc_hr.className 				= "input2";
			formObj.currency.className 				= "input2";

			if ( old_xcld_sat_flg ){
				formObj.xcld_sat_flg.checked = true;
				formObj.xcld_sat_flg.value = "Y";
			} else {
				formObj.xcld_sat_flg.checked = false;
				formObj.xcld_sat_flg.value = "N";				
			}
			
			if ( old_xcld_sun_flg ){
				formObj.xcld_sun_flg.checked = true;
				formObj.xcld_sun_flg.value = "Y";
			} else {
				formObj.xcld_sun_flg.checked = false;
				formObj.xcld_sun_flg.value = "N";				
			}
			
			if ( old_xcld_hol_flg ){
				formObj.xcld_hol_flg.checked = true;
				formObj.xcld_hol_flg.value = "Y";
			} else {
				formObj.xcld_hol_flg.checked = false;
				formObj.xcld_hol_flg.value = "N";
			}
			
			// F/Time Commence 
			formObj.dmdt_chg_cmnc_tp_cd.value = old_dmdt_chg_cmnc_tp_cd;
			formObj.cmnc_hr.value = old_cmnc_hr;
			formObj.currency.value = old_currency;
			
			if (sheet3_xml != "") sheetObjects[2].LoadSearchXml(sheet3_xml);
			if (sheet4_xml != "") sheetObjects[3].LoadSearchXml(sheet4_xml);
			
			sheetObjects[2].CellValue(sheetObjects[2].LastRow, "ft_to_qty") = "";
			sheetObjects[3].CellValue(sheetObjects[3].LastRow, "ft_und_dys") = "";

			sheetObjects[2].Editable = false;
			sheetObjects[3].Editable = false;

			for(var i = 1 ; i < sheetObjects[1].RowCount +1; i++) {
				sheetObjects[1].CellValue(i, "ibflag") = "N";
			}
		}
	}
	
//	function doXtnExpDtBlur() {
//		var formObject = document.form;
//		var xtn_exp_dt = ComGetDateAdd(formObject.xtn_eff_dt.value, "D", 365).replace(/-/gi,"");
//		var obj_value = formObject.xtn_exp_dt_1.value;		
//		
//		if ( expt_flg != "N" ) return false;
//
//		expt_flg = "Y";
//		if ( obj_value.replace(/-/gi,"") >= xtn_exp_dt){	
//			ComShowCodeMessage("DMT01178", "Extension ");
//			formObject.xtn_exp_dt_1.value = ComGetDateAdd(formObject.xtn_eff_dt.value, "D", 365);
//			expt_flg = "N";
//			return false;
//		}
//		expt_flg = "N";
//	}	