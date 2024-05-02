/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0102.js
*@FileTitle : Budget P/F SKD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
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
     * @class VOP_VSK_0102 : VOP_VSK_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0102() {
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

//yd_cd를  처리하는 Array
var ydCdsArr = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
     /*******************************************************/
    var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
					
				case "btn_New":
					clearAllData(sheetObject1,sheetObject2,formObject);
					break;
					
				case "btn_DownExcel":
					sheetObject2.Down2Excel(true);
					break;
					
				case "btns_search":
					openLandCdHelp(sheetObject2);
					break;	
				case "btns_search02":
					openPfLandTypeCdHelp(sheetObject2);
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
}

/**
 * 이벤트 컨드롤 정의
 */
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
	axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat  ('keyup', 'obj_change' , form);
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
            ComKeyOnlyNumber(event.srcElement, ".");
            break;
        case "eng":
            ComKeyOnlyAlphabet();
            break;
        case "engdn":
            ComKeyOnlyAlphabet('lower');
            break;
        case "engup":
            ComKeyOnlyAlphabet('upper');
            break;
        case "uppernum":
        	ComKeyOnlyAlphabet('uppernum');
            break;     
        default:
            ComKeyOnlyNumber(event.srcElement);
    }
}

/**
 * 필드 데이타가 CHANGE될 경우 이벤트
 */
function obj_change(){
	
	var formObject = document.form;
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
    var sheetObject1 = sheetObjects[0];
    /*******************************************************/
	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
            
        	case "vsl_slan_cd":
	        	var cnt = formObject.vsl_slan_cd.value;
				cnt = cnt.length;
	
				if(cnt == 3){
					doActionIBSheet(sheetObjects[0], formObject, SEARCH02);
				}
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
            InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"vsl_slan_cd",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"pf_svc_tp_cd",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"slan_stnd_flg",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"svc_dur_dys",    		false,          "",      dfNone);
            
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"stnd_svc_spd",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"brth_itval_dys",   false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"mml_usd_flg",  		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"sim_dt",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"sim_no",     	false,          "",      dfNone);
            
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_cd",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_knt",   false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n2nd_vsl_clss_cd",  		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"n2nd_vsl_clss_knt",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"n3rd_vsl_clss_cd",     	false,          "",      dfNone);
            
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n3rd_vsl_clss_knt",    		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"clpt_knt",   false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"ttl_dist",  		false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"max_spd",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"avg_spd",     	false,          "",      dfNone);
            
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"delt_flg",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"pf_skd_rmk",     	false,          "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"cre_dt",     	false,          "",      dfTimeHm);
            InitDataProperty(0, cnt++ , dtData,   		80,    	daCenter,  	false,    	prefix+"upd_dt",     	false,          "",      dfTimeHm);
            
            
            //CountPosition = 0;
            //SelectionMode = smSelectionList; //추가
            WaitImageVisible = false;
       }
        
        break;
        
        case "sheet2":      //sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 412;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                SelectHighLight = false;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;
                
                var HeadTitle1 = "|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Avg\nSea\nBUF\nSPD|Sea\nBUF\nSPD|Manv.|Manv.|Port\nTime|Port\nBUF|Cargo Volume|Cargo Volume|Cargo Volume|Cargo Volume|TMNL PRD|TMNL PRD|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
                var HeadTitle2 = "|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Avg\nSea\nBUF\nSPD|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|IPC|IPC|Ocean|Ocean|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
                var HeadTitle3 = "|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Avg\nSea\nBUF\nSPD|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|In|Out|In|Out|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
				var headCount = ComCountHeadTitle(HeadTitle1);

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(3, 1, 10, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, false, true, false, false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);		
                InitHeadRow(1, HeadTitle2, true);		
                InitHeadRow(2, HeadTitle3, true);		
                
                var prefix = "sheet2_";
                //데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 30, 	daCenter, 	false, 	prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	prefix+"Sel");
				InitDataProperty(0, cnt++ , dtSeq,			25,		daCenter,	true,	prefix+"No");
				InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,	prefix+"skd_dir_cd",		false,		"",		dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			44,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfEngUpKey,		0, 		false,		true,		5,			false,		false);
				
				InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"zd",				false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtCombo,		30,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfInteger,		0,		true,		true,		6,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		    30,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"sea_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daRight,	true,	prefix+"avg_sea_buf_spd",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sea_buf_spd",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"ib_ipcgo_qty",		false,	"",			dfInteger,		0);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"ob_ipcgo_qty",		false,	"",			dfInteger,		0);
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"ib_ocn_cgo_qty",	false,	"",			dfInteger,		0);
                                                                                            	
				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"ob_ocn_cgo_qty",	false,	"",			dfInteger,		0);
				InitDataProperty(0, cnt++ , dtData,			25,		daRight,	true,	prefix+"crn_knt",			false,	"",			dfInteger,		1);
				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfInteger,		0);
				InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	prefix+"turn_port_flg",		false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"turn_port_ind_cd",	false,	"",			dfNone,			0);
				
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"vsl_slan_cd",	false,	"",			dfNone,			0);
				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"pf_svc_tp_cd",	false,	"",			dfNone,			0);
                                         
				InitDataCombo(0, prefix+"skd_dir_cd", "W|E", "W|E");
				InitDataCombo(0, prefix+"yd_cd", "", "");
				InitDataCombo(0, prefix+"etb_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
				InitDataCombo(0, prefix+"etd_dy_cd", "MON|TUE|WED|THU|FRI|SAT|SUN", "MON|TUE|WED|THU|FRI|SAT|SUN");
				InitDataCombo(0, prefix+"turn_port_flg", "N|Y", "N|Y");
				
				InitDataValid(0, prefix+"port_cd", vtEngUpOnly);
				
				
				CountPosition = 0;
				SetSortDialog(false);		
				//SheetOutLineColor = RgbColor(0,0,0);
				RowHeight(0) = 10;
				RowHeight(1) = 10;
				RowHeight(2) = 10;
				WaitImageVisible = false;
				
										
               }
                break;
    }
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    
    var prefix = "sheet2_";
    switch(sAction) {

		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var sParam = "f_cmd="+ formObj.f_cmd.value +
							"&vsl_slan_cd=" +formObj.vsl_slan_cd.value+
							"&pf_svc_tp_cd=" +formObj.pf_svc_tp_cd.value;
				
		        var aryPrefix = new Array("sheet1_", "sheet2_");	//prefix 문자열 배열
		        var sXml = sheetObj.GetSearchXml("VOP_VSK_0102GS.do", sParam + "&" + ComGetPrefixParam(aryPrefix));
		    	
				var arrXml = sXml.split("|$$|");

				for(var inx=0; inx<arrXml.length; inx++){
					showSheetData(sheetObjects[inx],formObj,arrXml[inx]);
				}
				
				ComOpenWait(false);
			}
		break;
		
		case SEARCH02:
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = COMMAND12;
			var sParam = "f_cmd="+ formObj.f_cmd.value +
						"&vsl_slan_cd=" +formObj.vsl_slan_cd.value;

			var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do", sParam);
			var checkLane = ComGetEtcData(sXml, "checkLane");
			
			if(checkLane == undefined){
				sheetObj.LoadSearchXml(sXml);
				formObj.vsl_slan_cd.value = "";	
				formObj.vsl_slan_cd.focus();
				
			}else{
				var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
				
				if(vslSlanNm == ""){
					ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
					formObj.vsl_slan_cd.value = "";	
				}else{
					formObj.pf_svc_tp_cd.focus();
				}
			}
			
			ComOpenWait(false);
			
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
					formObj.vsl_slan_cd.value = sheetObj.CellValue(1,prefix+"vsl_slan_cd");
					formObj.slan_stnd_flg.value = sheetObj.CellValue(1,prefix+"slan_stnd_flg");
					formObj.pf_svc_tp_cd.value = sheetObj.CellValue(1,prefix+"pf_svc_tp_cd");
					formObj.n1st_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
					formObj.n1st_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_knt");
					formObj.n2nd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");
					formObj.n2nd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_knt");
					formObj.n3rd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
					formObj.n3rd_vsl_clss_knt.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_knt");
					formObj.svc_dur_dys.value = sheetObj.CellValue(1,prefix+"svc_dur_dys");
					formObj.brth_itval_dys.value = sheetObj.CellValue(1,prefix+"brth_itval_dys");
					formObj.mml_usd_flg.value = sheetObj.CellValue(1,prefix+"mml_usd_flg");
					
					var tempCreDt = sheetObj.CellValue(1,prefix+"cre_dt");
					var tempUpdDt = sheetObj.CellValue(1,prefix+"upd_dt");
					formObj.cre_dt.value = tempCreDt.substring(0,13)+":"+tempCreDt.substring(13,15);
					formObj.upd_dt.value = tempUpdDt.substring(0,13)+":"+tempUpdDt.substring(13,15);
					
					var ydCds = "";
					var ydCd = ComGetEtcData(sXml, "ydCd");
					if(ydCd && ydCd!=""){
						ydCds = ydCd.split("|");
					}

					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i] = ydCds[i];
						}
					}
					//[CDATA[23.4|21.0|17.7|19.27|20.31|0.00|118.64|1.43|1]
					
					var etcdts = "";
					var etcdt = ComGetEtcData(sXml, "etcdt");
					if(etcdt && etcdt!=""){
						etcdts = etcdt.split("|");
					}
					
					if(etcdts && etcdts != ""){
						formObj.min_max_spd.value = etcdts[8];
						formObj.cre_usr_id.value = etcdts[11];
						formObj.upd_usr_id.value = etcdts[12];
					}
					
				}else{
					clearAllData(sheetObjects[0], sheetObjects[1], formObj);
				}
			}

		break;
		
		case "sheet2":
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);

			setlastLowView(sheetObj);
			
			sheetObj.Redraw = true;
			
		break;
	}
}


/**
 * Calling Port ,Distance (P/S ~ P/S) 데이타 출력
 */
function viewDetailData(sheetObj,formObj){
	var cnt = sheetObj.RowCount;
	var prefix = "sheet2_";
	//Calling Port
	var callingPortCnt = cnt -1;
	formObj.clpt_knt.value = callingPortCnt+" ports";
	
	//Distance
	var disSum = 0;
	//var spdArr = new Array();
	for(var i=3; i<=cnt+2; i++){
		disSum += parseInt(sheetObj.CellValue(i,prefix+"lnk_dist"));
	}
	disSum = ComGetMaskedValue(disSum+"","int","");
	formObj.ttl_dist.value = disSum+" Miles";	
}


/**
 * SHEET2 그리드 Terminal 코드 이벤트
 */
function setSheetComboSinc(xmlStr, sheetObject, Row, Col){
	var xmlEtcData = ComGetEtcData(xmlStr, "yd_kind");
	
	if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
		sheetObject.CellComboItem(Row, sheetObject.id+"_yd_cd", xmlEtcData, xmlEtcData);
	}
}

/**
 * 화면을 초기화 한다.
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllData(sheetObj1,sheetObj2,formObj){
	formObj.vsl_slan_cd.value = "";
	formObj.pf_svc_tp_cd.value = "";
	formObj.brth_itval_dys.value = "";
	formObj.slan_stnd_flg.value = "";
	formObj.cre_dt.value = "";
	formObj.n1st_vsl_clss_cd.value = "";
	formObj.n1st_vsl_clss_knt.value = "";
	formObj.n2nd_vsl_clss_cd.value = "";
	formObj.n2nd_vsl_clss_knt.value = "";
	formObj.n3rd_vsl_clss_cd.value = "";
	formObj.n3rd_vsl_clss_knt.value = "";
	formObj.svc_dur_dys.value = "";
	formObj.mml_usd_flg.value = "";
	formObj.upd_dt.value = "";
	formObj.cre_usr_id.value = "";
	formObj.upd_usr_id.value = "";
	
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	
	document.form.vsl_slan_cd.focus();
}

/**
 * Lane Code Help 파일을 오픈한다
 */
function openLandCdHelp(sheetObj){
   var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
   var v_display = "0,0";
   var laneCd = document.form.vsl_slan_cd.value;
	////::JSK:://ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);
	
	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0203.do?vsl_slan_cd='+laneCd, 420, 500, targetObjList, v_display, true);
}

/**
 * P/F Lane Type Code Help 파일을 오픈한다  
 */
function openPfLandTypeCdHelp(sheetObj){
	 var targetObjList = "sheet1_pf_svc_tp_cd:pf_svc_tp_cd";
	 var v_display = "0,0";
	 var laneCd = document.form.vsl_slan_cd.value;
	 ComOpenPopupWithTarget('/hanjin/VOP_VSK_0108.do?vsl_slan_cd='+laneCd, 640, 490, targetObjList, v_display, true);
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

/*
 * CHM-201005742-01 Non-Weekly P/F SKD 조회
 */
/**
 * grid 출력 후 last 로우 Color 셋팅
 * @param sheetObj
 * @param formObj
 * @return
 */
function setlastLowView(sheetObj){

	var firstRow = sheetObj.HeaderRows;
	var lastRow = sheetObj.LastRow;
	
	var prefix = "sheet2_";
	
	if(sheetObj.RowCount > 0){
		//회색
		var grayColor = sheetObj.RgbColor(239, 235, 239);
		//흰색
		var whiteColor = sheetObj.RgbColor(255, 255, 255);
		
		// 첫째 Row
		sheetObj.CellBackColor(firstRow, prefix+"mnvr_in_hrs") = grayColor;
		sheetObj.CellFontColor(firstRow, prefix+"mnvr_in_hrs") = grayColor;
		
		// 마지막 Row
		for(var Col=sheetObj.SaveNameCol(prefix+"etd_dy_no"); Col<sheetObj.LastCol; Col++){
			if(Col!=sheetObj.SaveNameCol(prefix+"mnvr_in_hrs")){
				sheetObj.CellBackColor(lastRow, Col) = grayColor;
				sheetObj.CellFontColor(lastRow, Col) = grayColor;
			}
		}
	
	}
}
 


/* 개발자 작업  끝 */