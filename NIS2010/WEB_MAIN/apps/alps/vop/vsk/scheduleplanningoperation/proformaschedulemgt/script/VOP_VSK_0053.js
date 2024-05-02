/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0053.js
*@FileTitle : P/F SKD Creation (CCA)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.01 서창열
* 1.0 Creation
*  
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
=========================================================*/
/****************************************************************************************
 * 2010.08.17
 * <<20100817_01>>
 * [CSR?]
 * 양방향일 경우, 마지막 포트의 ETB, ETD간 검증은 하지 않는다.
 ****************************************************************************************/
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
     * @class VOP_VSK_0053 : VOP_VSK_0053 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0053() {
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
    var ydCdsArr = new Array();
    var beforeValue = null; //컬럼에 변경 전 정보를 보관함.
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var sheetObject1	= sheetObjects[0];
	var sheetObject2	= sheetObjects[1];
	var formObject		= document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
        switch(srcName) {
			case "btn_RowAdd":
				
				rowAdd(sheetObject1, sheetObject2, "", "btn_RowAdd");
				
				break;
				
			case "btn_RowInsert":
				
				rowAdd(sheetObject1, sheetObject2, "", "btn_RowInsert");
				
				break;
				
			case "btn_RowDelete":

				rowAdd(sheetObject1, sheetObject2, "", "btn_RowDelete");
				
				break;

			case "btn_Retrieve":
				
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				
				break;
				
			case "btn_New":
				
				rowAdd(sheetObject1, sheetObject2, formObject, "btn_New");
				
				break;
				
			case "btn_Save":
				
				doActionIBSheet(sheetObject2, formObject, IBSAVE);
				
				break;
				
			case "btns_search":
				
				openLaneCdHelp(sheetObject2);
				
				break;		
				
			case "btns_search02":
				
				openPfLaneTypeCdHelp(sheetObject2);
				
				break;
				
			case "btn_Delete":
				
					doActionIBSheet(sheetObject1,formObject,REMOVE);
				
				break;	
                
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
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
	document.form.vsl_slan_cd.focus();
	
	//2010.01.28 임창빈
	//Open시 초기값 설정.
	document.form.svc_dur_dys.value = "0";
	
	if(sheetObjects[0].RowCount == 0){
		sheetObjects[0].DataInsert(-1);
	}
}

/****************************************************************************************************************************************
 * Html 이벤트 컨드롤 정의 시작.
 * @return
 ****************************************************************************************************************************************/

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm	('focus', 		'obj_focus', 	formObj);
	axon_event.addListenerFormat('keypress', 	'obj_keypress', form);
	axon_event.addListenerForm	('keyup', 		'obj_keyup', 	form);
	axon_event.addListenerForm	('change', 		'obj_change', 	form);
}

function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * KEY PRESS 이벤트
 */
function obj_keypress() {
    switch(event.srcElement.dataformat){
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
            ComKeyOnlyAlphabet('upper');
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
 * 필드 데이타가 CHANGE될 경우 이벤트
 */
function obj_keyup(){
	var formObject = document.form;
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
    var sheetObject1 = sheetObjects[0];
    
    if(sheetObjects[0].RowCount == 0){
		sheetObjects[0].DataInsert(-1);
	}
    /*******************************************************/
	try {
		var eleObj = window.event.srcElement;
		var srcName = eleObj.getAttribute("name");
		
        switch(srcName) {
        	case "vsl_slan_cd":
				if(eleObj.value.length == 3){
					formObject.pf_svc_tp_cd.focus();
				}
				break;

        	case "pf_svc_tp_cd":
				if(eleObj.value.length == 4){
					sheetObject1.CellValue(1,"sheet1_pf_svc_tp_cd") = formObject.pf_svc_tp_cd.value;
					formObject.slan_stnd_flg.focus();
				}
				break;
        	
        	case "slan_stnd_flg":
        		sheetObject1.CellValue(1,"sheet1_slan_stnd_flg") = formObject.slan_stnd_flg.value;
        		break;
        	
        	case "svc_dur_dys":
        		sheetObject1.CellValue(1,"sheet1_svc_dur_dys") = formObject.svc_dur_dys.value;
        		break;
                
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 필드 데이타가 CHANGE될 경우 이벤트
 */
function obj_change(){
	var formObject = document.form;
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
    var sheetObject1 = sheetObjects[0];
    
    if(sheetObjects[0].RowCount == 0){
		sheetObjects[0].DataInsert(-1);
	}
    /*******************************************************/
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
        switch(srcName) {
        	case "vsl_slan_cd":
        		
        		var	vslSlanCd = formObject.vsl_slan_cd.value;
        		
        		if(VskIsNull(vslSlanCd)) {return;}
        		
	        	var sXml		= doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
	        	
	        	var vslSlanNm	= ComGetEtcData(sXml, "checkLane").split("|");
	  		  	var vslSvcTpCd	= ComGetEtcData(sXml, "checkLaneTpCd");
	  		  	var fdrDivCd = ComGetEtcData(sXml, "checkFdrDivCd");
	  		  	var dirCds		= ComGetEtcData(sXml, "checkDirCd");
	  		  	
	  		  	sheetObjects[1].InitDataCombo(0, "sheet2_skd_dir_cd", dirCds,dirCds);
				
				if(vslSlanNm == ""){
					formObject.vsl_slan_cd.value = "";
					formObject.pf_svc_tp_cd.value = "";
					formObject.vsl_slan_cd.focus();
					ComShowCodeMessage('VSK00021', vslSlanCd);
				}else{
					// 사용이 가능한 Lane
					// 1. VSL_SVC_TP_CD 가 'O'
					// 2. VSL_SVC_TP_CD 가 'O'가 아닐때, FDR_DIV_CD가 'O'인 경우
					//if(vslSvcTpCd == "O" || 
					//		(vslSvcTpCd != "O" && fdrDivCd == "O")){
						formObject.pf_svc_tp_cd.focus();
					//}
					//2014.07.07 VSL_SVC_TP_CD이 Trunk 일 경우도 포함 .. 
					//김기원차장님 요청으로 수정 됨 .. 
					//kjh
					/*
					else{
						formObject.vsl_slan_cd.value = "";
						formObject.pf_svc_tp_cd.value = "";
						formObject.vsl_slan_cd.focus();
						ComShowCodeMessage('VSK00039');
					}
					*/
				}
	        	
				sheetObject1.CellValue(1,"sheet1_vsl_slan_cd") = vslSlanCd;
				break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}

/****************************************************************************************************************************************
 * Html 이벤트 컨드롤 정의 종료
 ****************************************************************************************************************************************/

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
	var sheetID = sheetObj.id;
			
    switch(sheetID) {
    	case "sheet1":      //sheet1 init
		    with (sheetObj) {
		
		        // 높이 설정
		        style.height = 0;
		        
		        //전체 너비 설정
		        SheetWidth = 0;
		
		        //Host정보 설정[필수][HostIp, Port, PagePath]
		        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		        //전체Merge 종류 [선택, Default msNone]
		        MergeSheet = msNone;
		
		       //전체Edit 허용 여부 [선택, Default false]
		        Editable = false;
		
		        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		        InitRowInfo( 1, 1, 3, 100);
		
		        // 해더에서 처리할 수 있는 각종 기능을 설정한다
		        InitHeadMode(true, true, true, true, false,false)
		
		        var HeadTitle = "STATUS|VSL_SLAN_CD|PF_SVC_TP_CD|SLAN_STND_FLG|SVC_DUR_DYS|STND_SVC_SPD|BRTH_ITVAL_DYS|MML_USD_FLG|SIM_DT|SIM_NO|N1ST_VSL_CLSS_CD|N1ST_VSL_CLSS_KNT|N2ND_VSL_CLSS_CD|N2ND_VSL_CLSS_KNT|N3RD_VSL_CLSS_CD|N3RD_VSL_CLSS_KNT|CLPT_KNT|TTL_DIST|MAX_SPD|AVG_SPD|DELT_FLG|PF_SKD_RMK|CRE_DT|UPD_DT";
		        var headCount = ComCountHeadTitle(HeadTitle);
		        
		        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		        InitColumnInfo(headCount, 0, 0, true);
		
		        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		        InitHeadRow(0, HeadTitle, true);
		        
		        var prefix = "sheet1_";
		        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		        InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter, 	false, 		prefix+"ibflag");
//		        InitDataProperty(0, cnt++ , dtStatus, 30,  	daCenter, 	false, 		prefix+"ibflag");
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"vsl_slan_cd",    		false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"pf_svc_tp_cd",    		false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"slan_stnd_flg",    		false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"svc_dur_dys",    		false,          "",      dfNone);
		        
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"stnd_svc_spd",    		false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"brth_itval_dys",   		false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"mml_usd_flg",  			false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"sim_dt",     			false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"sim_no",     			false,          "",      dfNone);
		        
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_cd",    	false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_knt",   	false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n2nd_vsl_clss_cd",  	false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"n2nd_vsl_clss_knt",     false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"n3rd_vsl_clss_cd",     	false,          "",      dfNone);
		        
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n3rd_vsl_clss_knt",    	false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"clpt_knt",   			false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"ttl_dist",  			false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"max_spd",     			false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"avg_spd",     			false,          "",      dfNone);
		        
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"delt_flg",     			false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"pf_skd_rmk",     		false,          "",      dfNone);
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"cre_dt",     			false,          "",      dfTimeHm);
		        InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"upd_dt",     			false,          "",      dfTimeHm);
		        
		        
		        //CountPosition = 0;
		        //SelectionMode = smSelectionList; //추가
		        WaitImageVisible = false;
		   }
		    
		   break;
    
    case "sheet2":      //sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 432;
            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            
            var HeadTitle1 = "|Sel.|No.|DIR|Port Code|TMNL Code|ZD|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|Maneuvering|Maneuvering|Port\nTime|Port\nBuffer|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|TML Prod.|TML Prod.|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
            var HeadTitle2 = "|Sel.|No.|DIR|Port Code|TMNL Code|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|In|Out|Port\nTime|Port\nBuffer|IPC|IPC|Ocean|Ocean|.|.|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
            var HeadTitle3 = "||No.|DIR|Port Code|TMNL Code|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|In|Out|Port\nTime|Port\nBuffer|In|Out|In|Out|.|.|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
			var headCount = ComCountHeadTitle(HeadTitle1);

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(3, 1, 10, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, false, true, true, false, false);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);		
            InitHeadRow(1, HeadTitle2, true);		
            InitHeadRow(2, HeadTitle3, true);		
            
            var prefix = "sheet2_";
            //데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus, 30, 	daCenter, 	false, 	prefix+"ibflag");
//            InitDataProperty(0, cnt++ , dtStatus, 30, 	daCenter, 	false, 	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,	prefix+"Sel");
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"row_seq",           false,	"",			dfInteger,		0,		false,		false,		6,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix+"skd_dir_cd",		false,		"",		dfNone,			0);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"port_cd",			false,	"",			dfEngUpKey,		0, 		true,		true,		5,			false,		false);
			
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"zd",				false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfInteger,		0,      true,		true,		2,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0,      false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
                                                                                        	
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfInteger,		0,      true,		true,		2,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0,      false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfInteger,		0,		true,		true,		6,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                                                                                        	
			InitDataProperty(0, cnt++ , dtHidden,		55,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"sea_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"sea_buf_spd",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                                                                                        	
			InitDataProperty(0, cnt++ , dtHidden,		70,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		70,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"ib_ipcgo_qty",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		45,		daRight,	true,	prefix+"ob_ipcgo_qty",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		35,		daRight,	true,	prefix+"ib_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
                                                                                        	
			InitDataProperty(0, cnt++ , dtHidden,		45,		daRight,	true,	prefix+"ob_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		35,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfInteger,		0);
			InitDataProperty(0, cnt++ , dtHidden,		35,		daRight,	true,	prefix+"crn_knt",			false,	"",			dfInteger,		1);
			InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,	prefix+"turn_port_flg",		false,	"",			dfNone,			0);
			InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"turn_port_ind_cd",	false,	"",			dfNone,			0);

			InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"vsl_slan_cd",		false,	"",			dfNone,			0);
			InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"pf_svc_tp_cd",		false,	"",			dfNone,			0);
                                     
			InitDataCombo(0, prefix+"skd_dir_cd", "S|N", "S|N");
			InitDataCombo(0, prefix+"yd_cd", "", "");
			InitDataCombo(0, prefix+"etb_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
			InitDataCombo(0, prefix+"etd_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
			InitDataCombo(0, prefix+"turn_port_flg", "N|Y", "N|Y");
			
			InitDataValid(0, prefix+"port_cd", vtEngUpOther, "0123456789");
			CountPosition = 0;
			SetSortDialog(false);		
			//SheetOutLineColor = RgbColor(0,0,0);
			RowHeight(0) = 10;
			RowHeight(1) = 10;
			RowHeight(2) = 10;
			SelectHighLight = false;
			WaitImageVisible = false;
           }
            break;
    }
}

  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
//    alert(sAction);
    switch(sAction) {

		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
		        var aryPrefix = new Array("sheet1_", "sheet2_");	//prefix 문자열 배열
		        var	sParm = "f_cmd=" +formObj.f_cmd.value+
						"&vsl_slan_cd=" +formObj.vsl_slan_cd.value+
						"&pf_svc_tp_cd=" +formObj.pf_svc_tp_cd.value;
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do", sParm + "&" + ComGetPrefixParam(aryPrefix));
//				var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");

				sheetObjects[1].RemoveAll();	// sheet 2를 초기화 한다.

				for(var inx=0; inx<arrXml.length; inx++){
					showSheetData(sheetObjects[inx],formObj,arrXml[inx]);	//조회 내용 표시.
				}
				
				ComOpenWait(false);

				modifyPropertyByRow (sheetObjects[1]);
			}

			break;
		
		case SEARCH02:
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;
//			var loc_cd = formObj.port_cd.value;
			
			var sParam = "f_cmd=" + formObj.f_cmd.value + 
						"&loc_cd=" + formObj.port_cd.value;
			
//			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do?loc_cd="+loc_cd, sParam);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do", sParam);
//			alert(sParam);
//			alert(sXml);
			ComOpenWait(false);
			
			return sXml;

			break;
		
		case SEARCH03:		// Lane Code 변경시
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH03;
//			var sParam = FormQueryString(formObj);
//			var vslSlanCd  = formObj.vsl_slan_cd.value;
			var sParam = "f_cmd="+ formObj.f_cmd.value + 
						"&vsl_slan_cd="+ formObj.vsl_slan_cd.value;
			
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do?vslSlanCd="+vslSlanCd, sParam);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do", sParam);
//			alert(sParam);
//			alert(sXml);
			ComOpenWait(false);
			
			return sXml;
			
			break;
		
		case REMOVE:
			
			if((VskIsNull(formObj.vsl_slan_cd.value)) || (formObj.vsl_slan_cd.value.length < 3 )){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				return ;
			}
			
			if(VskIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return ;
			}
			
			if(!ComShowConfirm(ComGetMsg("VSK00005"))){
				return
			}
			
			if(validateForm(sheetObj,formObj, sAction)){
				//sheetObj : 첫번째 sheetObject이다.
//				sheetObj.CellValue(1,"sheet1_ibflag") = "D";
				sheetObj.RowStatus(1) = "D";
				   
			   ComOpenWait(true);
			   formObj.f_cmd.value = REMOVE;
			   var SaveStr = ComGetSaveString(sheetObjects);
			   var aryPrefix = new Array("sheet1_");
			   var sXml = sheetObj.GetSaveXml("VOP_VSK_0053GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			   	
			   if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
			   
			   // 2010.01.28 임창빈
			   // 저장 성공시 화면을 초기화 작업
			   if(!VskGetErrorXml(sXml)){
				  rowAdd( sheetObjects[0], sheetObjects[1], formObj, "btn_New");
			   }
			   
			   ComOpenWait(false);
			}
			
			break;
			
		case IBSAVE:        //저장
			
			if(validateForm(sheetObj,formObj,sAction)){
//				sheetObjects[0].CellValue(1,"sheet1_ibflag") = "I";
				sheetObjects[0].RowStatus(1) = "I";
				
				if(formObj.vsl_svc_tp_cd.value == "O"){
					formObj.n1st_vsl_clss_knt.value = 0;
				}else{
					var dur  = Number(formObj.svc_dur_dys.value);
					var mdur = Math.floor(dur/7);				
					sheetObjects[0].CellValue2(1, "sheet1_"+"brth_itval_dys")=7;
					sheetObjects[0].CellValue2(1, "sheet1_"+"n1st_vsl_clss_knt")=mdur;
					
				}
				 
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
	     	   	var SaveStr		= ComGetSaveString(sheetObjects);
	     	   	
	     	   	var aryPrefix	= new Array("sheet1_", "sheet2_");
	     	   	
	     	   	var sXml 		= sheetObj.GetSaveXml("VOP_VSK_0053GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	    
	     	   	sheetObjects[1].CheckAll("sheet2_Sel") = 0;
	     	   	if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
	     	   	
	     	    ComOpenWait(false);
			}
			
			break;
    }
}

/**
 * 조회 후 처리로직.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml){
	var prefix = sheetObj.id + "_";
	
	switch(sheetObj.id){
		case "sheet1":
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(sXml);
			
			var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
			if(dataNode){
				var totValue = dataNode.value;

				sheetObj.LoadSearchXml(sXml);

				if(totValue > 0){
					formObj.vsl_slan_cd.value 	= sheetObj.CellValue(1,prefix+"vsl_slan_cd");
					formObj.slan_stnd_flg.value = sheetObj.CellValue(1,prefix+"slan_stnd_flg");
					formObj.pf_svc_tp_cd.value 	= sheetObj.CellValue(1,prefix+"pf_svc_tp_cd");
					formObj.svc_dur_dys.value 	= sheetObj.CellValue(1,prefix+"svc_dur_dys");
					
					var tempCreDt = sheetObj.CellValue(1,prefix+"cre_dt");
					var tempUpdDt = sheetObj.CellValue(1,prefix+"upd_dt");
					
					if(tempCreDt != ""){
						formObj.cre_dt.value = tempCreDt.substring(0,13)+":"+tempCreDt.substring(13,15);
					}
					if(tempUpdDt != ""){
						formObj.upd_dt.value = tempUpdDt.substring(0,13)+":"+tempUpdDt.substring(13,15);
					}
					
					var ydCds = ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i] = ydCds[i];
						}
					}

					var etcdts = ComGetEtcData(sXml, "etcdt");
					formObj.min_max_spd.value = etcdts;

				}else{
					rowAdd(sheetObjects[0], sheetObjects[1], "", "btn_RowInsert");
				}
			}
		break;
		
		case "sheet2":

			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			
			if(sheetObj.RowCount > 0){
				sheetObjects[1].CheckAll("sheet2_Sel") = 0;

				for(var i=0; i<sheetObj.RowCount; i++){
					sheetObj.CellComboItem(sheetObj.HeaderRows+i, prefix+"yd_cd", ydCdsArr[i], ydCdsArr[i]);
					sheetObj.CellValue2(sheetObj.HeaderRows+i, prefix+"yd_cd") =  ydCdsArr[i];
//		    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
					sheetObj.RowStatus(sheetObj.HeaderRows+i) = "R";
				}
				
				sheetObj.Redraw = true;
			}
			
		break;
	}
}

/***
 * 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event
 * 
 * @param Row
 * @param Col
 * @param KeyCode
 * @param Shift
 * @return
 */
function sheet2_OnKeyUp(sheetObject, Row, Col, KeyCode) {
	if (KeyCode == 46) { // Del Key를 눌렀을 경우. (초기화 값을 설정함.)
		switch (Col){
		case 9 	:	//etb_tm_hrmnt
			sheetObject.CellValue2(Row, Col) 	= "00:00";
			break;
		case 12 :	//etd_tm_hrmnt
			sheetObject.CellValue2(Row, Col) 	= "00:00";
			break;	
		}
	}	
}

/**
 * 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event
 * 
 * @param sheetObject
 * @param Row
 * @param Col
 * @return
 */

function sheet2_OnClick(sheetObject, Row, Col) {
	var formObj = document.form;
	var sXml = null;
	var prefix = sheetObject.id + "_";
	var colSaveName = sheetObject.ColSaveName(Col);

	if(Row == 0 || Col == 0){return;}

	switch(colSaveName){
	case prefix+"yd_cd":
		
		var portCd= sheetObject.CellValue(Row, prefix+"port_cd");
		var idx   = sheetObject.GetComboInfo(Row, Col, "SelectedIndex");
		var	sCode = sheetObject.GetComboInfo(Row, Col, "Code");
		
		if (VskIsNull(portCd))		 {return;}	// Port Code 가 Null 이면 리턴함.
		if (sCode.indexOf("|") > -1) {return;}	// 데이터 있을 경우 리턴함.
		
		formObj.port_cd.value = portCd;
		sXml = doActionIBSheet(sheetObject, formObj, SEARCH02);

		setSheetComboSinc(sXml, sheetObject, Row, Col);
		
		break;
	}
}

/**
 * 셀의 값을 편집하기 직전에 이벤트가 발생한다. 셀에 단순 포커스 상태일때는 발생하지 않으며 편집을 시작하면
 * 편집 상태가 되기 직전에 이 이벤트가 발생한다.
 * : 변경 컬럼에 변경 전 값한다.
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnBeforeEdit(sheetObj, Row, Col){	
	beforeValue = sheetObj.CellValue(Row, Col);
}

/**
 * 특정 셀의 값을 편집한 직후에 Event가 발생한다.
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnAfterEdit(sheetObj, Row, Col){
	var colSaveName = sheetObj.ColSaveName(Col);
	var prefix 		= sheetObj.id + "_";
	var headCnt 	= sheetObj.HeaderRows;
	var rowCnt 		= sheetObj.RowCount;
	var ttlCnt 		= headCnt+rowCnt;	
	var oldValue;
	var newValue;
	
	switch(colSaveName){
	
		case prefix+"etb_tm_hrmnt":
			
			if (VskIsNull(sheetObj.CellValue(Row, Col))){
				sheetObj.CellValue2(Row, Col) = beforeValue;
			}
			
			break;
			
		case prefix+"etd_tm_hrmnt":
			
			if (VskIsNull(sheetObj.CellValue(Row, Col))){
				sheetObj.CellValue2(Row, Col) = beforeValue;
			}
			
			break;
			
		case prefix+"etb_dy_no":
			if(headCnt!=Row){return;}	// 첫줄은 ETB No만 적용함.
			
			var tempEtbDyNo = parseInt(sheetObj.CellValue(Row, Col));
		
			if(beforeValue==""){
				oldValue = 0;
			}else{
				oldValue = beforeValue.parseInt();
			}
			
			newValue = sheetObj.CellValue(Row, Col).parseInt();
			if(tempEtbDyNo != 0 && tempEtbDyNo != 1){
				sheetObj.CellValue2(Row, Col) = oldValue;
				ComShowCodeMessage("VSK00041");
				return;
			}
			
			break;
	
		case  prefix+"etb_dy_no":	
			// 첫줄은 경우 처리하지 않는다.
			if(headCnt==Row){return;}

			if(beforeValue==""){
				oldValue = 0;
			}else{
				oldValue = beforeValue.parseInt();
			}

			newValue = sheetObj.CellValue(Row, Col).parseInt();
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.CellValue2(Row, Col) = oldValue;
				calDayByNo(sheetObj, Row, Col); //Change Event 발생으로(-)값에 의해 Day 정보가 삭제가 됨으로 Before 값으로 다시 Day 정보 생성.
				
				return;
			}
			
			break;
			
		case  prefix+"etd_dy_no":
			if(beforeValue==""){
				oldValue = 0;
			}else{
				oldValue = beforeValue.parseInt();
			}

			newValue = sheetObj.CellValue(Row, Col).parseInt();
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.CellValue2(Row, Col) = oldValue;
				calDayByNo(sheetObj, Row, Col); //Change Event 발생으로(-)값에 의해 Day 정보가 삭제가 됨으로 Before 값으로 다시 Day 정보 생성.
				
				return;
			}
			
			break;
	}
}

/**
 * 셀의 값이 바뀌었을 때 발생하는 Event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var prefix 		= sheetObj.id + "_";
	var formObj 	= document.form;
	var headCnt 	= sheetObj.HeaderRows;
	var rowCnt 		= sheetObj.RowCount;
	var ttlCnt 		= headCnt+rowCnt;	
	
	if(Row <= 2){ return;}
	
	switch(Col) {
	case 3:	//skd_dir_cd
			for(var i=Row; i<=ttlCnt; i++){
				sheetObj.CellValue2(i, prefix+"skd_dir_cd") = Value;
			}

			modifyPropertyByRow(sheetObjects[1]);

			
			break;
			
	case 4:	//port_cd
			var tempVal = sheetObj.EditValue;
			if(tempVal.length == 0){
				return;
			}
			
			if(tempVal.length == 5){
				formObj.port_cd.value = tempVal;		
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH02);
				
				var chkPort = ComGetEtcData(sXml, "check_port");
				
				//ETC Data 존재.(Yard) 정보가 있을 경우.
				if(chkPort == "X"){
					if(VskIsNotNull(sXml)){
						var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
						xmlDoc.loadXML(sXml);
	
						var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
						if(dataNode){
							var totValue = dataNode.value;
	
							if(totValue > 0){
								sheetObj.CellValue2(Row, prefix+"yd_cd") = "";
								setSheetComboSinc(sXml, sheetObj, Row, Col);
							}else{
								sheetObj.CellComboItem(Row, prefix+"yd_cd", "", "");
							}
						}
					}
				}else{
					sheetObj.CellValue(Row, Col) = "";
					sheetObj.CellComboItem(Row, prefix+"yd_cd", " ", " ");
					ComShowCodeMessage('VSK00029', Value);
					sheetObj.SelectCell(Row, Col-1, true);
				}
			}else{
				sheetObj.CellValue(Row, Col) = "";
				sheetObj.CellComboItem(Row, prefix+"yd_cd", " ", " ");
				ComShowCodeMessage('VSK00029', tempVal);
				sheetObj.SelectCell(Row, Col-1, true);
			}
			
			break;
			
		case 5 :	//yd_cd
			
			break;
			
		case 7 :	//etb_dy_no
			if((headCnt==Row) && !(Value == 0 || Value == 1)){return;}	// 첫줄은 ETB No 변경은 제외함.
			calDayByNo(sheetObj, Row, Col);
			
			break;
			
		case 8 :	//etb_dy_cd
			
			if(headCnt!=Row){return;}	// 첫줄은 ETB Day 변경시에만 적용됨.
			
			calDayByNo(sheetObj, Row, Col);
			
			break;
			
		case 9 :	//etb_tm_hrmnt
			
			var etbTime = sheetObj.EditValue;
			
			if(ComChkLen(etbTime,4) == 2){
				sheetObj.SelectCell(Row, 10, true);
			}
			
			break;
			
		case 10 :	//etd_dy_no
			
			calDayByNo(sheetObj, Row, Col);
			
			break;
			
		case 12 :	//etd_dy_no
			
			var etdTime = sheetObj.EditValue;
			
			if(ComChkLen(etdTime,4) == 2){
				sheetObj.SelectCell(Row, 28, true);
			}
			
			break;
		
		case 28 :	//turn_port_flg
			
			break;
	} //end switch문
}

/**
 * SHEET2 그리드 Terminal 코드 이벤트
 */
function setSheetComboSinc(xmlStr, sheetObject, Row, Col){
	var ydKindCode 	= ComGetEtcData(xmlStr, "yd_kind");
	var ydNm 		= ComGetEtcData(xmlStr, "yd_nm");
	var ydTxt 		= "";
	
	if(VskIsNotNull(ydKindCode)){
		var ydKindCodeArr 	= ydKindCode.split("|");
		var ydNmArr 		= ydNm.split("|");
		var ydCnt 			= ydKindCodeArr.length;

		ydTxt = ydKindCodeArr[0] + "\t" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
			ydTxt = ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
		}

		sheetObject.CellComboItem(Row, sheetObject.id+"_yd_cd", ydTxt, ydKindCode);
	}
}

/**
 * Gird 출력, 추가, 삭제시 각 Row별 글자색, 배경색 등을 변경한다.
 * @param sheetObj
 * @return
 */

function modifyPropertyByRow (sheetObj){
	var headCnt 	= sheetObj.HeaderRows;
	var rowCnt 		= sheetObj.RowCount;
	var totalCnt 	= sheetObj.LastRow;
	var prefix 		= "sheet2_";
	var grayColor	= sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));//회색	
	var withrColor	= sheetObj.RgbColor(eval("255"),eval("255"),eval("255"));//흰색
	var blackColor 	= sheetObj.RgbColor(eval("0")  ,eval("0")  ,eval("0"));	 //검정
	
	for(var i=headCnt; i<=totalCnt; i++) {
		if (i == headCnt){
			sheetObj.CellEditable(i, prefix+"etb_dy_cd") = true;
		}else if(i == totalCnt){
			if (checkDirMode(sheetObj)=="TWO"){	// 양방향일 경우.
				sheetObj.CellEditable(i, prefix+"etd_dy_no") 		= false;
				sheetObj.CellEditable(i, prefix+"etd_tm_hrmnt") 	= false;
				
				sheetObj.CellFontColor(i, prefix+"etd_dy_no") 		= sheetObj.CellBackColor(i, prefix+"etd_dy_no");
				sheetObj.CellFontColor(i, prefix+"etd_dy_cd") 		= sheetObj.CellBackColor(i, prefix+"etd_dy_cd");
				sheetObj.CellFontColor(i, prefix+"etd_tm_hrmnt") 	= sheetObj.CellBackColor(i, prefix+"etd_tm_hrmnt");
			}else{									// 단방향일 경우
				sheetObj.CellEditable(i, prefix+"etd_dy_no") 		= true;
				sheetObj.CellEditable(i, prefix+"etd_tm_hrmnt") 	= true;
				
				sheetObj.CellFontColor(i, prefix+"etd_dy_no") 		= blackColor;
				sheetObj.CellFontColor(i, prefix+"etd_dy_cd") 		= blackColor;
				sheetObj.CellFontColor(i, prefix+"etd_tm_hrmnt")	= blackColor;
			}
		}else{
			sheetObj.CellEditable(i, prefix+"etb_dy_cd") 		= false;
			sheetObj.CellEditable(i, prefix+"etd_dy_no") 		= true;
			sheetObj.CellEditable(i, prefix+"etd_tm_hrmnt") 	= true;
			
			sheetObj.CellFontColor(i, prefix+"etd_dy_no") 		= blackColor;
			sheetObj.CellFontColor(i, prefix+"etd_dy_cd") 		= blackColor;
			sheetObj.CellFontColor(i, prefix+"etd_tm_hrmnt")	= blackColor;
		}
	}
}

/**
 * 화면을 초기화 및 Row 추가, 삭제를 한다.
 * @param sheetObj
 * @param formObj
 * @return
 */

function rowAdd(sheetObj1, sheetObj2, formObj, sAction){
	var sheetObj;
	var	i=0;

	switch (sAction) {
			
		case "btn_New" 		:
			
			formObj.vsl_slan_cd.value 	= "";
			formObj.pf_svc_tp_cd.value 	= "";
			formObj.slan_stnd_flg.value = "N";
			formObj.svc_dur_dys.value 	= "0";
			formObj.cre_dt.value 		= "";
			formObj.upd_dt.value 		= "";

			sheetObj1.RemoveAll();
			sheetObj2.RemoveAll();
			
			sheetObj	= sheetObj2;
			
		case "btn_RowInsert":
			
			sheetObj	= sheetObj2;
			
			break;
			
		case "btn_RowAdd"	:
			
			sheetObj	= sheetObj2;
			
			break;
			
		case "btn_RowDelete":
			
			sheetObj	= sheetObj2;
			
			break;
	}

	var headRows	= sheetObj.HeaderRows;
	var dataRows	= sheetObj.RowCount;
	var	ttlRows		= headRows + dataRows;
	var prefix		= sheetObj.id+"_";

	switch (sAction) {
	case "btn_RowDelete"	:
		
		var	selValue =false;
		
		for (i=headRows;i<ttlRows;i++ ){
			if (sheetObj.CellValue(i, prefix+"Sel")) {
				selValue = true;
				break;
			}
		}

		if (!selValue) {return;}	//선택된 Row 가 없을 경우

		if (ComShowConfirm(ComGetMsg("VSK00005"))) {
			for(i=sheetObj.LastRow; i>=sheetObj.HeaderRows; i-- ) {
				if(sheetObj.CellValue(i, prefix+"Sel")){
					sheetObj.RowDelete( i, false );
				}
			}
			
			sheetObj.CheckAll(prefix+"Sel") = 0;
		}
		
	break;
	
	default:
		var rowIdx		= sheetObj.SelectRow - 1;
		var insRow 		= 0;
		
		if (sAction == "btn_RowAdd"){
			insRow	= sheetObj.DataInsert(ttlRows);
		}else{
			insRow	= sheetObj.DataInsert(rowIdx);			
		}
		
		sheetObj.CellValue(insRow, prefix+"etb_dy_no") 		= 0;
		sheetObj.CellValue(insRow, prefix+"etb_dy_cd") 		= "MON";
		sheetObj.CellValue(insRow, prefix+"etb_tm_hrmnt") 	= "00:00";
		sheetObj.CellValue(insRow, prefix+"etd_dy_no") 		= 0;
		sheetObj.CellValue(insRow, prefix+"etd_dy_cd") 		= "MON";
		sheetObj.CellValue(insRow, prefix+"etd_tm_hrmnt") 	= "00:00";
		
		if (insRow==headRows){
			var sText 	= sheetObj.GetComboInfo(3,3, "Text");
			var arrText = sText.substring(0,1);
			sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_dir_cd") = arrText;
		}else{
			sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_dir_cd") = sheetObj.CellValue(insRow - 1, prefix+"skd_dir_cd");
		}
		
		sheetObj.SelectCell(insRow, prefix+"port_cd", true);
	
	}
	
	setClptSeq(sheetObj);
}

/**
 * Lane Code Help 파일을 오픈한다
 */
function openLaneCdHelp(sheetObj){
	var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd|sheet1_vsl_svc_tp_cd:vsl_svc_tp_cd";
	var v_display = "0,0";
	var formObj	= document.form;
	var laneCd	= formObj.vsl_slan_cd.value;

	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);
   
	//2014.07.07 김기원 차장님 요청으로 조건 삭제 
	//kjh
	//if(formObj.vsl_svc_tp_cd.value == "O"){
		formObj.pf_svc_tp_cd.focus();
	
	//}
	
	/*else if(formObj.vsl_svc_tp_cd.value != "" && formObj.vsl_svc_tp_cd.value != "O"){
		ComShowCodeMessage('VSK00039');
		formObj.vsl_slan_cd.value = "";
		formObj.vsl_slan_cd.focus();
	}
	*/
}

/**
 * P/F Lane Type Code Help 파일을 오픈한다  
 */
function openPfLaneTypeCdHelp(sheetObj){
	 var targetObjList = "sheet1_pf_svc_tp_cd:pf_svc_tp_cd";
	 var v_display = "0,0";
	 var laneCd = document.form.vsl_slan_cd.value;
	 ComOpenPopupWithTarget('/hanjin/VOP_VSK_0241.do?vsl_slan_cd='+laneCd, 620, 490, targetObjList, v_display, true);
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {

		case IBSEARCH:      //조회
			
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus();
				return false;
			}
			
			break;
			
		case REMOVE:      //삭제
			
//			if(sheetObj.CellValue(1,"sheet1_ibflag") == "I"){
			if(sheetObj.RowStatus(1) == "I"){
				ComShowCodeMessage("VSK00043");
				rowAdd(sheetObject1, sheetObject2, formObject, "btn_New");
				return false;
			}
			

			
			break;
			
		case IBSAVE:      //저장
			
			var headRows	= sheetObj.HeaderRows;
			var dataRows	= sheetObj.RowCount;
			var lastRow		= sheetObj.LastRow;
			var prefix 		= sheetObj.id + "_";
			var	i=0;
			
			if (dataRows == 0){		//Grid에 저장할 데이터가 없을 경우.
				ComShowCodeMessage('VSK00012');
				formObj.vsl_slan_cd.focus()
				return false;
			}
			
			if((VskIsNull(formObj.vsl_slan_cd.value)) || (formObj.vsl_slan_cd.value.length < 3 )){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus()
				return false;
			}

			if((VskIsNull(formObj.pf_svc_tp_cd.value)) || (formObj.pf_svc_tp_cd.value.length < 4 )){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			
			for(i=headRows;i<=lastRow; i++){
				if(sheetObj.CellValue(i, prefix+"skd_dir_cd").length < 1){
					ComShowCodeMessage("VSK01018", "Direction Code");
					sheetObj.SelectCell(i, prefix+"skd_dir_cd");
					return false;
				}
				
				if(sheetObj.CellValue(i, prefix+"port_cd").length < 5){
					ComShowCodeMessage("VSK01018", "Port Code");
					sheetObj.SelectCell(i, prefix+"port_cd");
					return false;
				}

				if(sheetObj.CellValue(i, prefix+"yd_cd").length < 2){
					ComShowCodeMessage("VSK01018", "Terminal Code");
					sheetObj.SelectCell(i, prefix+"yd_cd");
					return false;
				}					
			}
			
			if(!checkDuration(sheetObj, formObj)){
				return false;
			}
			
			if(!checkEtbEtd(sheetObj)){
				return false;
			}
			
			if(!checkSave(sheetObj)){
				return false;
			}

			// Master 정보 설정.
			var prefix = "sheet1_"
				
			sheetObjects[0].CellValue2(1,prefix+"vsl_slan_cd")		= formObj.vsl_slan_cd.value;
			sheetObjects[0].CellValue2(1,prefix+"slan_stnd_flg") 	= formObj.slan_stnd_flg.value;
			sheetObjects[0].CellValue2(1,prefix+"pf_svc_tp_cd") 	= formObj.pf_svc_tp_cd.value;
			sheetObjects[0].CellValue2(1,prefix+"svc_dur_dys") 		= formObj.svc_dur_dys.value;

			break;
	}

    return true;
}

/**
 * Enter키 이벤트
 * @param sheetObj
 * @param formObj
 * @return
 */
function doSearch(){
	var formObject = document.form;

	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}
         
function checkEtbEtd(sheetObj){
	var	headRows	= sheetObj.HeaderRows;
	var dataRows	= sheetObj.RowCount;
	var lastRow 	= sheetObj.LastRow;
	var prefix 		= sheetObj.id + "_";
	var retrnFlg 	= true;
	var firEtbNo 	= sheetObj.CellValue(headRows, prefix+"etb_dy_no");
	var firEtbDay 	= sheetObj.CellValue(headRows, prefix+"etb_dy_cd");

	if(dataRows >= 2){
		for(var i=headRows;i<=lastRow; i++){
			if(i==headRows){ //첫번째 Row...
				var etbNo 		= sheetObj.CellValue(i, prefix+"etb_dy_no"); 
				var etbDay 		= sheetObj.CellValue(i, prefix+"etb_dy_cd"); 
				var etbTime 	= sheetObj.CellValue(i, prefix+"etb_tm_hrmnt"); 
				var etdNo 		= sheetObj.CellValue(i, prefix+"etd_dy_no"); 
				var etdDay 		= sheetObj.CellValue(i, prefix+"etd_dy_cd"); 
				var etdTime 	= sheetObj.CellValue(i, prefix+"etd_tm_hrmnt");
				var calEtbTime 	= calcETBETD(etbNo,etbTime);
				var calEtdTime 	= calcETBETD(etdNo,etdTime);

				if((calEtdTime-calEtbTime) < 0.001){
					ComShowCodeMessage("VSK00048", sheetObj.CellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etd_dy_no",true);
					retrnFlg =  false;
					return;
				}
				
				if(!getCalWeek(firEtbNo,firEtbDay,etdNo,etdDay)){
					ComShowCodeMessage("VSK00049", sheetObj.CellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etd_dy_cd",true);
					retrnFlg =  false;
					return;
				}
			}else if(i == lastRow){
				var pastEtdNo		= sheetObj.CellValue(i-1, prefix+"etd_dy_no"); 
				var pastEtdDay 		= sheetObj.CellValue(i-1, prefix+"etd_dy_cd"); 
				var pastEtdTime 	= sheetObj.CellValue(i-1, prefix+"etd_tm_hrmnt");
				var etbNo 			= sheetObj.CellValue(i, prefix+"etb_dy_no"); 
				var etbDay 			= sheetObj.CellValue(i, prefix+"etb_dy_cd"); 
				var etbTime 		= sheetObj.CellValue(i, prefix+"etb_tm_hrmnt"); 
				
				var etdNo 		= sheetObj.CellValue(i, prefix+"etd_dy_no"); 
				var etdDay 		= sheetObj.CellValue(i, prefix+"etd_dy_cd"); 
				var etdTime 	= sheetObj.CellValue(i, prefix+"etd_tm_hrmnt");
				var calEtdTime 	= calcETBETD(etdNo,etdTime);
				
				var calPastEtdTime 	= calcETBETD(pastEtdNo,pastEtdTime);
				var calEtbTime 		= calcETBETD(etbNo,etbTime);
				
				// Previous Port ETD + 1(시간) 는 Current ETB 보다 작아야 한다.
				if(calEtbTime <= (calPastEtdTime + 1)){
					ComShowCodeMessage("VSK00050", sheetObj.CellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etb_dy_no",true);
					retrnFlg =  false;
					return;
				}
				
				if(!getCalWeek(firEtbNo,firEtbDay,etbNo,etbDay)){
					ComShowCodeMessage("VSK00049", sheetObj.CellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etb_dy_cd",true);
					retrnFlg =  false;
					return;
				}
				
				// <<20100817_01>>
				// 마지막 Row의 ETB/ETD간 검증은 단방향일때만 시행한다.
				if("ONE" === checkDirMode(sheetObj)){
					if((calEtdTime - calEtbTime) < 0.001){
						ComShowCodeMessage("VSK00048", sheetObj.CellValue(i, prefix+"port_cd"));
						sheetObj.SelectCell(i,prefix+"etd_dy_no",true);
						retrnFlg =  false;
						return;
					}
				}
				
			}else{
				var pastEtdNo 	= sheetObj.CellValue(i-1, prefix+"etd_dy_no"); 
				var pastEtdDay 	= sheetObj.CellValue(i-1, prefix+"etd_dy_cd"); 
				var pastEtdTime = sheetObj.CellValue(i-1, prefix+"etd_tm_hrmnt");
				var etbNo 		= sheetObj.CellValue(i, prefix+"etb_dy_no"); 
				var etbDay 		= sheetObj.CellValue(i, prefix+"etb_dy_cd"); 
				var etbTime 	= sheetObj.CellValue(i, prefix+"etb_tm_hrmnt"); 
				var etdNo 		= sheetObj.CellValue(i, prefix+"etd_dy_no"); 
				var etdDay 		= sheetObj.CellValue(i, prefix+"etd_dy_cd"); 
				var etdTime 	= sheetObj.CellValue(i, prefix+"etd_tm_hrmnt");
				var calPastEtdTime = calcETBETD(pastEtdNo,pastEtdTime);
				var calEtbTime 	= calcETBETD(etbNo,etbTime);
				var calEtdTime 	= calcETBETD(etdNo,etdTime);

				// Previous Port ETD + 1(시간) 는 Current ETB 보다 작아야 한다.
				if(calEtbTime <= (calPastEtdTime + 1)){
					ComShowCodeMessage("VSK00050", sheetObj.CellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etb_dy_no",true);
					retrnFlg =  false;
					return;
				}
				
				if((calEtdTime - calEtbTime) < 0.001){
					ComShowCodeMessage("VSK00048", sheetObj.CellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etd_dy_no",true);
					retrnFlg =  false;
					return;
				}
				
				if(!getCalWeek(firEtbNo,firEtbDay,etbNo,etbDay)){
					ComShowCodeMessage("VSK00049", sheetObj.CellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etb_dy_cd",true);
					retrnFlg =  false;
					return;
				}
				
				if(!getCalWeek(firEtbNo,firEtbDay,etdNo,etdDay)){
					ComShowCodeMessage("VSK00049", sheetObj.CellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etd_dy_cd",true);
					retrnFlg =  false;
					return;
				}
			}
		}
	}else{
		ComShowCodeMessage("VSK50011"); //Grid 데이터가 한개 이하일 경우...의미가 없는 P/F SKD 임..
		retrnFlg =  false;
	}
	
	return retrnFlg;
}

/**
 * ETB,ETD의 입력한 시간이 정확한지 체크
 * @param sheetObj
 * @param formObj
 * @return
 */
function calcETBETD(valNo,valTime){
	var tempValNo = parseInt(valNo);
	var tempValTime = valTime;

	var tempvalHrmnt = tempValTime.length;
	var tempvalTimeVal = 0;
	var tempvalHrmntVal = 0; 
	
	tempvalTimeVal = tempValTime.substring(0,2);
	tempvalHrmntVal = tempValTime.substring(2,4);
	tempvalHrmntVal = tempvalHrmntVal/100;
	
	var totNo = tempValNo * 24;

	var tot =  Number(totNo) + Number(tempvalTimeVal);
	tot = tot + Number(tempvalHrmntVal);

	return tot;
}

function getCalWeek(firEtbNo,etbDay,valNo,valDay){
	var dayCd = new Array("SUN","MON","TUE","WED","THU","FRI","SAT");
	var returnFlg = false;
	var reVal;
	var currPos;
	var nextPos;
	var gabNo = parseInt(valNo - firEtbNo);
	
	for(var i=0; i<dayCd.length; i++){
		if(etbDay == dayCd[i]){
			currPos = i;
		}
	}
	
	nextPos = parseInt(currPos + gabNo);
	reVal = nextPos % 7;

	if(valDay == dayCd[reVal]){
		returnFlg = true; 
	}
	
	return returnFlg;
}

/**
 * 첫번째 Row에 ETB No. Day 기준으로 변경이 발생한 Port에 No.를 참조하여 Day를 자동 변경한다. 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */

function calDayByNo(sheetObj, Row, Col){
	var headCnt		= sheetObj.HeaderRows;
	var rowCnt		= sheetObj.RowCount;
	var ttlCnt		= sheetObj.LastRow;
	var prefix 		= sheetObj.id + "_";
	var dayCd 		= new Array("SUN","MON","TUE","WED","THU","FRI","SAT");
	var firEtbNo	= sheetObj.CellValue(headCnt, prefix+"etb_dy_no");
	var firEtbDay	= sheetObj.CellValue(headCnt, prefix+"etb_dy_cd");
	var currPos		= 0;
	var nextPos		= 0;
	var valNo		= 0;
	var	reVal		= 0;
	var gabNo		= 0;
	
	for(var i=0; i<dayCd.length; i++){
		if(firEtbDay == dayCd[i]){
			currPos = i;	//첫번째 Port에 위치
		}
	}	
	
	if (headCnt == Row) { //첫번째 Row에 ETB No, Day가 바뀔때 전체 Day를 변경함.
		for(var i=Row; i<=ttlCnt; i++){
			if (i != headCnt){	// 첫번 Row에 ETB, No 변경은 무시함.
				valNo 	= sheetObj.CellValue(i, prefix+"etb_dy_no");
				gabNo 	= parseInt(valNo - firEtbNo);		
				nextPos = parseInt(currPos + gabNo);
				reVal 	= nextPos % 7;
				sheetObj.CellValue2(i, prefix+"etb_dy_cd") = dayCd[reVal];
			}
		
			valNo 	= sheetObj.CellValue(i, prefix+"etd_dy_no");
			gabNo 	= parseInt(valNo - firEtbNo);		
			nextPos = parseInt(currPos + gabNo);
			reVal 	= nextPos % 7;
			sheetObj.CellValue2(i, prefix+"etd_dy_cd") = dayCd[reVal];
		}
	} else{	// 바뀐 Row에 ETB, ETD Day만 변경함.

		switch (Col){
		case 7 :	//etb_dy_no
			valNo 	= sheetObj.CellValue(Row, prefix+"etb_dy_no");
			gabNo 	= parseInt(valNo - firEtbNo);		
			nextPos = parseInt(currPos + gabNo);
			reVal 	= nextPos % 7;
			sheetObj.CellValue2(Row, prefix+"etb_dy_cd") = dayCd[reVal];		
		break;
		
		case 10 :	//etd_dy_no
			valNo 	= sheetObj.CellValue(Row, prefix+"etd_dy_no");
			gabNo 	= parseInt(valNo - firEtbNo);		
			nextPos = parseInt(currPos + gabNo);
			reVal 	= nextPos % 7;
			sheetObj.CellValue2(Row, prefix+"etd_dy_cd") = dayCd[reVal];
		break;
		}
	}
}

/**
 * CLPT_SEQ 순차적으로 다시 생성
 * @param sheetObj
 * @return
 */

function setClptSeq(sheetObj){
	var headCnt = sheetObj.HeaderRows;
	var lastRow	= sheetObj.LastRow;
	var prefix 	= sheetObj.id + "_";
	var idx 	= 0;
	
	for(var i=headCnt; i<= lastRow; i++){
		sheetObj.CellValue2(i, prefix+"row_seq") = ++idx;
	}

	modifyPropertyByRow(sheetObj); // 첫번째 ETB Day 설정 때문에 실행.
}

/** sheet 데이타의 Dirction 이 단방향("ONE")인지 양방향("TWO")이지 체크한다
 *  
 * @param sheetObj
 * @return rtnValue
 */

function checkDirMode(sheetObj){
	var headRows 	= sheetObj.HeaderRows;
	var rowCnt 		= sheetObj.RowCount;
	var lastCnt 	= sheetObj.LastRow;
	var prefix 		= "sheet2_";
	var firstDirCd 	= "";
	var	rtnValue	= "ONE";
	
	if(rowCnt != 0){
		firstDirCd = sheetObj.CellValue(headRows, prefix+"skd_dir_cd");
		
		for(var k=headRows; k<=lastCnt; k++){
			if(sheetObj.CellValue(k, prefix+"skd_dir_cd") != firstDirCd){
				rtnValue	= "TWO";
				break;
			}
		}
	}

	return rtnValue;
}

/**
 * 저장 전 Check 사항을 점검한다.
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */

function checkSave(sheetObj){
	var headRows	= sheetObj.HeaderRows;
	var dataRows	= sheetObj.RowCount;
	var lastRows	= sheetObj.LastRow;
	var prefix 		= "sheet2_";
	var dirConfig	= checkDirMode(sheetObj);

	if(dirConfig == "TWO"){ //양방향.
		var firstPortDirCd = sheetObj.CellValue(headRows, prefix+"skd_dir_cd"); // 첫번째 Row 에 Direction 정보.
		var otherDirTurnCnt	= 0;
		var otherDirPortCnt = 0;
		var otherDirPos		= 0;
		var	chkFlag			= true;

		if(		sheetObj.CellValue(headRows, prefix+"port_cd") 		== sheetObj.CellValue(lastRows, prefix+"port_cd"		) &&
				sheetObj.CellValue(headRows, prefix+"yd_cd") 		== sheetObj.CellValue(lastRows, prefix+"yd_cd"		) &&
				sheetObj.CellValue(headRows, prefix+"etb_dy_cd") 	== sheetObj.CellValue(lastRows, prefix+"etb_dy_cd"	) &&
				sheetObj.CellValue(headRows, prefix+"etb_tm_hrmnt") == sheetObj.CellValue(lastRows, prefix+"etb_tm_hrmnt")
			  ){
				var lastEtdNo = (parseInt(sheetObj.CellValue(headRows, prefix+"etd_dy_no")) - parseInt(sheetObj.CellValue(headRows, prefix+"etb_dy_no"))) +
								 parseInt(sheetObj.CellValue(lastRows, prefix+"etb_dy_no"))	// Last Port ETD No 계산.
				
				sheetObj.CellValue(lastRows, prefix+"etd_dy_no") 	= lastEtdNo;
				sheetObj.CellValue(lastRows, prefix+"etd_dy_cd") 	= sheetObj.CellValue(headRows, prefix+"etd_dy_cd");
				sheetObj.CellValue(lastRows, prefix+"etd_tm_hrmnt") = sheetObj.CellValue(headRows, prefix+"etd_tm_hrmnt");
		}else{
			//First port/terminal code should be same last port/terminal code.
			ComShowCodeMessage("VSK00084");
			// 첫번째 Port 와 Last 정보 비교 후 이상이 있는지 확인함.
			if(sheetObj.CellValue(headRows,prefix+"port_cd") 	!= sheetObj.CellValue(lastRows,prefix+"port_cd")){
				sheetObj.SelectCell(headRows, prefix+"port_cd", true);
			}else if(sheetObj.CellValue(headRows,prefix+"yd_cd") != sheetObj.CellValue(lastRows,prefix+"yd_cd")){
				sheetObj.SelectCell(headRows, prefix+"yd_cd", true);
			}else if(sheetObj.CellValue(headRows,prefix+"etb_dy_cd") != sheetObj.CellValue(lastRows,prefix+"etb_dy_cd")){
				sheetObj.SelectCell(headRows, prefix+"etb_dy_cd", true);
			}else if(sheetObj.CellValue(headRows,prefix+"etb_tm_hrmnt") != sheetObj.CellValue(lastRows,prefix+"etb_tm_hrmnt")){
				sheetObj.SelectCell(headRows, prefix+"etb_tm_hrmnt", true);
			}
			
			return false;
		}
		
		
		
		for(var i=headRows; i<=lastRows; i++){
//			sheetObj.CellValue(i,prefix+"ibflag") = "I";
			sheetObj.RowStatus(i) = "I";
			
			//처음 입력한 포트의 dir_cd와 다른 첫번째 포트의 위치를 가져온다
			if(sheetObj.CellValue(i,prefix+"skd_dir_cd") != firstPortDirCd){
				if(sheetObj.CellValue(i,prefix+"turn_port_flg") == "Y"){
					otherDirTurnCnt++;
				}
				
				if (chkFlag){
					otherDirPos = i;
					chkFlag		= false;
				}
				
				otherDirPortCnt++;
			}
			
			//기존의 입력된 Turning Port Indicator의 F를 지운다
			if(sheetObj.CellValue(i,prefix+"turn_port_ind_cd") == "F"){
				sheetObj.CellValue(i,prefix+"turn_port_ind_cd") = sheetObj.CellValue(i, prefix+"turn_port_flg");
			}
			
			if (i==headRows){
				//첫번째 Port 는  Turning Port Indicator = N , Turning Port Flag = Y로 셋팅한다
				sheetObj.CellValue(i, prefix+"turn_port_ind_cd") 	= "N";
				/** Remove logic of setting first port to turning port */
				//::2014-05-09:://sheetObj.CellValue(i, prefix+"turn_port_flg") 		= "Y";
			}
			
			if( i != headRows && i != lastRows ){
				if(sheetObj.CellValue(i, prefix+"turn_port_flg") == "Y"){
					//alert('turning port');
					sheetObj.CellValue2(i, prefix+"turn_port_ind_cd")	= "Y";
				}else{
					//alert('no-turning port');
					sheetObj.CellValue2(i, prefix+"turn_port_ind_cd")	= "N";
				}
			}
			
			if (i==lastRows) {
				//마지막 Port 는  Turning Port Indicator = N , Turning Port Flag = Y로 셋팅한다
				sheetObj.CellValue(i, prefix+"turn_port_ind_cd") 	= "F";
				sheetObj.CellValue(i, prefix+"turn_port_flg") 		= "N";
			}
			
			// Turn Ind 값을 설정함.
			if(VskIsNull(sheetObj.CellValue(i,prefix+"turn_port_ind_cd"))){
				sheetObj.CellValue(i, prefix+"turn_port_ind_cd") = sheetObj.CellValue(i,prefix+"turn_port_flg");
			}
			
			// Manuvering In Time시간은 항상 1 시간으로 입력한다
			sheetObj.CellValue(i, prefix+"mnvr_in_hrs") = "1";
		}

		// 두번째 Direction 에 Port Code가 2 이하이면 P/F SKD로 의미가 없음.
		if(otherDirPortCnt < 2){
			//If direction is two types, port count should be over two.
			ComShowCodeMessage('VSK00104'); 
			return false;
		}

		/** Remove logic of setting first port to turning port */
		// 두번째 Direction 에 Turn Flag가 0 이면 P/F SKD로 의미가 없음.
		//if(otherDirTurnCnt == 0){
		//	//If direction is two types, turn port total should be over one.
		//	ComShowCodeMessage('VSK00009');
		//	sheetObj.SelectCell(otherDirPos, prefix+"turn_port_flg");
		//	return false;
		//}
		//::2014-05-09:://
		
	}else{	// 단방향
		
		for(var i=headRows; i<=lastRows; i++){
//			sheetObj.CellValue(i,prefix+"ibflag") 				= "I";
			sheetObj.RowStatus(i) = "I";
			sheetObj.CellValue(i, prefix+"turn_port_ind_cd") 	= "N";
			sheetObj.CellValue(i, prefix+"turn_port_flg") 		= "N";
			
			// Manuvering In Time시간은 항상 1 시간으로 입력한다
			sheetObj.CellValue(i, prefix+"mnvr_in_hrs") = "1";
		}
	}

	//입력된 Row 갯수가 2 이하일 경우 의미없을 P/F SKD로 간주함.
   if(dataRows < 2){
	   //"If direction changes, port total should be over two."
	   ComShowCodeMessage('VSK00008');
	   return false;
   }
   
   return true;
}

/**
 * 입력한 Direction이 단방향인지 양방향인지에 따른 Duration의 날자 체크
 * @param sheetObj
 * @param formObj
 * @return
 */

function checkDuration(sheetObj,formObj){
	
	if(VskIsNull(formObj.pf_svc_tp_cd.value)){
		ComShowCodeMessage('VSK00027', "P/F SKD Type");
		formObj.pf_svc_tp_cd.focus()
		return false;
	}

	if(VskIsNull(formObj.svc_dur_dys.value) || (parseInt(formObj.svc_dur_dys.value) <= 0)){
		ComShowCodeMessage('VSK00027', "Duration");
		formObj.svc_dur_dys.focus()
		return false;
	}
	
	//단방향일경우 : (Duration > 마지막 Port ETB - 첫번째 Port ETD)
	//양방향일경우 : (Duration = 마지막 Port ETB - 첫번째 Port ETB)
	//단방향,양방향 check
	var	dirCount 		= checkDirMode(sheetObj);
	var durationVal 	= formObj.svc_dur_dys.value;
	
	var firstRow 		= sheetObj.HeaderRows;
	var lastRow 		= sheetObj.LastRow;
	var prefix 			= "sheet2_";

	var lastEtbDyNo 	= parseInt(sheetObj.CellValue(lastRow,prefix+"etb_dy_no"));
	var lastEtbTmHrmnt 	= sheetObj.CellValue(lastRow,prefix+"etb_tm_hrmnt");
	var lastEtdDyNo 	= parseInt(sheetObj.CellValue(lastRow,prefix+"etd_dy_no"));
	
	if(dirCount == "ONE"){	// 단방향.
		var firstEtdDyNo 		= parseInt(sheetObj.CellValue(firstRow,prefix+"etd_dy_no"));
		var firstEtdTmHrmnt 	= sheetObj.CellValue(firstRow,prefix+"etd_tm_hrmnt");
		
		var tempLastEtbTmHrmnt 	= lastEtbTmHrmnt.length;
		var tempFirstEtdTmHrmnt = firstEtdTmHrmnt.length;
		
		var lastEtbTmHrmntVal 	= 0;
		var firstEtdTmHrmntVal	= 0;
		
		if(tempLastEtbTmHrmnt == 4){
			lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,2);
		}else{
			lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,1);
		}
		
		if(tempFirstEtdTmHrmnt == 4){
			firstEtdTmHrmntVal = firstEtdTmHrmnt.substring(0,2);
		}else{
			firstEtdTmHrmntVal = firstEtdTmHrmnt.substring(0,1);
		}

		var lastTot = parseInt(lastEtbDyNo * 24) + parseInt(lastEtbTmHrmntVal);
		var firstTot = parseInt(firstEtdDyNo * 24) + parseInt(firstEtdTmHrmntVal);

		var tempDur = parseInt(lastTot - firstTot);
		var durVal1 = parseInt(tempDur/24);
		
		if(durationVal <= durVal1){
			//Total duration should be always bigger than difference of (Last port ETB - First port ETB).
			ComShowCodeMessage("VSK00094");
			formObj.svc_dur_dys.focus();
			return false;
		}
		
		if(lastEtbDyNo > lastEtdDyNo){
			//({?msg1}) ETB cannot be larger than ETD.
			ComShowCodeMessage("VSK00048", sheetObj.CellValue(lastRow, prefix+"port_cd"));
			sheetObj.SelectCell(lastRow,prefix+"etd_dy_no",true);
			return false;
		}
	}else{	// 양방향
		var firstEtbDyNo 		= parseInt(sheetObj.CellValue(firstRow,prefix+"etb_dy_no"));
		var firstEtbTmHrmnt 	= sheetObj.CellValue(firstRow,prefix+"etb_tm_hrmnt");
		
		var tempLastEtbTmHrmnt 	= lastEtbTmHrmnt.length;
		var tempFirstEtbTmHrmnt = firstEtbTmHrmnt.length;
		
		var lastEtbTmHrmntVal 	= 0;
		var firstEtbTmHrmntVal 	= 0;
		
		if(tempLastEtbTmHrmnt == 4){
			lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,2);
		}else{
			lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,1);
		}
		
		if(tempFirstEtbTmHrmnt == 4){
			firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,2);
		}else{
			firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,1);
		}
		
		var lastTot 	= parseInt(lastEtbDyNo  * 24) + parseInt(lastEtbTmHrmntVal);
		var firstTot 	= parseInt(firstEtbDyNo * 24) + parseInt(firstEtbTmHrmntVal);
		
		var tempDur 	= parseInt(lastTot - firstTot);
		var durVal1 	= parseInt(tempDur/24);
		
		if(durationVal != durVal1){
			//Total duration and difference(Last port ETB - First port ETB) should be same.
			ComShowCodeMessage("VSK00095");
			formObj.svc_dur_dys.focus();
			return false;
		}
	}
	
	return true;
}

/* 개발자 작업  끝 */