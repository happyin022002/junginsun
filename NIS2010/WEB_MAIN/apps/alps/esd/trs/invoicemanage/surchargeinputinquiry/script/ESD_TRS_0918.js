/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0918.js
*@FileTitle : surcharge 입력/수정/삭제화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.20
*@LastModifier : 이인영
*@LastVersion : 1.3
* 2006.11.09 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.03.17 양봉준    1.1 [N200902240180] [TRS] TPB 대상 건 I/F 가능 시점 추가 요청
* 2010.12.21  최 선	1.2 [CHM-201007798] [TRS] W/O Addional 상 항목추가 요청
* 2011.04.20  이인영	1.3 [CHM-201109692] [TRS] S/O type ER 인 경우에 대한 additional 칼럼 사용시 일부 칼럼 비활성화 처리 요청
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/ 
/**
 * @class ESD_TRS_0918 : Surchage input inquiry popup
 */
function ESD_TRS_0918() {
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

var prefix = 'surcharge_';
var invfix = '';
var sheetObjects = new Array();
var sheetCnt = 0;

var saveFlag = false;

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

        	    case "btn_close":
					if(saveFlag) return;
    	            window.close();
        	      break;

				case "btn_save":
					if(saveFlag) return;
					if(formObject.open_mode.value != 'search')
					doActionIBSheet(sheetObject,formObject,IBSAVE);
        	    break;

				case "btns_calendar":
					if(saveFlag) return;
	       	        if(formObject.open_mode.value != 'search' && formObject.SCPPAL_chk.checked) getCalendar();
        	        break;
				    
				case "btns_calendar2":
					if(saveFlag) return;
	       	        if(formObject.open_mode.value != 'search' && formObject.SCCDAL_chk.checked) getCalendar2();
        	        break;
        	        
				case "btns_stop_loc":
					if(saveFlag) return;
					if(formObject.open_mode.value != 'search' && formObject.SCMDAL_chk.checked) openHireYardPopup('stop_node');
					break;

				case "btns_scale_loc":
					if(saveFlag) return;
					if(formObject.open_mode.value != 'search' && formObject.SCSSAL_chk.checked) openHireYardPopup('scale_node');
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('COM12111');
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
	
	if(!opener){
        opener = window.dialogArguments;
	}
	
	document.stop_yard.Enable = false;
	document.scale_yard.Enable = false;
	
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	if (formObj.step_cd.value=='IV'){
		invfix = 'inv_'
	}else{
		invfix = '';
	}

	if(formObj.open_mode.value == 'search'){
		doActionIBSheet(sheetObj, formObj, 'SEARCH_BY_SHEET');
		if(sheetObj.RowCount < 1){
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		calCurrencyChange(sheetObj, formObj);
		bindSheettoForm(sheetObj, formObj);
		setDisplayForm(sheetObj, formObj);
	}else if(formObj.open_mode.value == 'search2'){
	    doActionIBSheet(sheetObj, formObj, IBSEARCH);
		calCurrencyChange(sheetObj, formObj);
		bindSheettoForm(sheetObj, formObj);
		setDisplayForm(sheetObj, formObj);
	}else if(formObj.open_mode.value == 'modify'){
		doActionIBSheet(sheetObj, formObj, 'SEARCH_BY_SHEET');
		if(sheetObj.RowCount < 1){
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}

		bindSheettoForm(sheetObj, formObj);
		setEnableForm(sheetObj, formObj);
		
		//[CHM-201432964]Surcharge 항목 중 ENSF 활성화 요청(MT) by 박진영D
//		if (formObj.cgo_tp_cd.value == 'M') {
//			formObj.SCENAL_chk.disabled = true;
//		}
		
		if (formObj.agmt_flg.value == "Y") {
			formObj.SCTLAL_chk.disabled = true;
		}

	}else if(formObj.open_mode.value == 'multiple'){
		setEnableForm(sheetObj, formObj);
		
		//[CHM-201432964]Surcharge 항목 중 ENSF 활성화 요청(MT) by 박진영D
//		if (formObj.cgo_tp_cd.value == 'M') {
//			formObj.SCENAL_chk.disabled = true;
//		}
		if (formObj.agmt_flg.value == 'Y') {
			formObj.SCTLAL_chk.disabled = true;
		}
	}
	
	// Bkg Cargo Type에 의해 Surcharge 항목을 비활성화 시킴 
	// Type(M) = Empty
	if(formObj.cgo_tp_cd.value == 'M'){
		formObj.SCALAL_chk.disabled = true;
		formObj.SCCDAL_chk.disabled = true;
		formObj.SCDPAL_chk.disabled = true;
		formObj.SCDRAL_chk.disabled = true;
		formObj.SCFGAL_chk.disabled = true;
		formObj.SCGNAL_chk.disabled = true;
		formObj.SCHZAL_chk.disabled = true;
		formObj.SCINAL_chk.disabled = true;
		formObj.SCMDAL_chk.disabled = true;
		formObj.SCOSAL_chk.disabled = true;
		formObj.SCOWAL_chk.disabled = true;
		formObj.SCPPAL_chk.disabled = true;
		formObj.SCSSAL_chk.disabled = true;
		formObj.SCSTAL_chk.disabled = true;
		formObj.SCTDAL_chk.disabled = true;
		
		if (formObj.agmt_flg.value == 'Y') {
			formObj.SCTLAL_chk.disabled = true;
		}
	}

	doActionIBSheet(sheetObjects[1], formObj, 'SEARCH_CODE_NAME');
	checkTPBIf();
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
				style.height = 0;
				//전체 너비 설정
				SheetWidth = 0;
//				style.height=GetSheetHeight(10);
				//전체 너비 설정
//				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(67, 2, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtStatus,30,daCenter,	false,	prefix+"ibflag");
				InitDataProperty(0, cnt++,dtCheckBox,30,daCenter,	false,	prefix+"ibcheck");
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'unique_cd'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 40,daCenter,	false,  prefix+'trsp_so_ofc_cty_cd'     ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'trsp_so_seq'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'lgs_cost_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'lgs_cost_full_nm'       ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  prefix+'scg_amt'                ,false,"",dfFloat,2,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'chss_no'      			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incur_dt'      			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fne_cuz_desc'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fumg_cost_tp_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'mgst_tpsz_cd'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_knt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_cuz_desc'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'stop_loc_nod_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'grs_wgt'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'wo_grs_wgt_meas_ut_cd'  ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incrt_dt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scl_stop_plc_nod_cd'    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'sto_dys'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no'              ,false,"",dfNone,0,true,true);
				//InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no_split'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'wt_hrs'					,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'otr_rmk'                ,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'rf_hndl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'rf_mgst_usg_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'tri_axl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ovr_wgt_prmt_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ovr_wgt_otr_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ovr_wgt_rmk'			,false,"",dfNone,0,true,true);


				
				InitDataProperty(0, cnt++ , dtData,	80,daCenter,	false,  prefix+'inv_scg_amt'			,false,"",dfFloat,2,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_chss_no'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incur_dt'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fne_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fumg_cost_tp_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_mgst_tpsz_cd'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_knt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_stop_loc_nod_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_grs_wgt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 100,daCenter,	false,  prefix+'inv_grs_wgt_meas_ut_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incrt_dt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scl_stop_plc_nod_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_sto_dys'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no'			,false,"",dfNone,0,true,true);
				//InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no_split'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_wt_hrs'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_otr_rmk'			,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_rf_hndl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_rf_mgst_usg_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_tri_axl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ovr_wgt_prmt_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ovr_wgt_otr_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ovr_wgt_rmk'		,false,"",dfNone,0,true,true);
				

				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_bil_flg'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_cnt_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_seq'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_vndr_seq'         ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_ofc_cd'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_amt'              ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_desc'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_ofc_cd'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_usr_id'             ,false,"",dfNone,0,true,true);
		   
		   }
		   break;
		   
	        case 2:      //t1sheet1 init
			with (sheetObj) {
				style.height=0;
				//전체 너비 설정
//				style.height=GetSheetHeight(10);
				//전체 너비 설정
//				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  false,	"lgs_cost_full_nm",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,   daCenter,  false,	"lgs_cost_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtStatus,     0,   daCenter,   true,	"ibflag");
			}
			break;
			
		   case 3:      //t1sheet1 init
			with (sheetObj) {
				style.height=0;
				//전체 너비 설정
				SheetWidth = 0;
				
//         		style.height=GetSheetHeight(10);
				//전체 너비 설정
//				SheetWidth = mainTable.clientWidth;
//
//				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 2,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
				
				var HeadTitle = "SO OFC|SO SEQ|IF_FLG";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  'if_so_ofc'    ,false,		"",		dfNone,		0,	false,		false,		4, false, true);
                InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  'if_so_seq'    ,false,		"",		dfNone,		0,	false,		false,		4, false, true);
                InitDataProperty(0, cnt++ , dtData,	 80,daCenter,	false,  'if_flg'    ,false,		"",		dfNone,		0,	false,		false,		4, false, true);
			}
			break;     

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_TRS_0918GS.do", TrsFrmQryString(formObj));
			break;

		case IBSAVE:      //저장	
	    	var sheetObj2 = sheetObjects[2];
		    var if_flg = sheetObj2.CellValue(1, 'if_flg');
			ComOpenWait(true);	
			getSumTotalAmount();
			if (!validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(false);
				return;
			}
			saveFlag = true;
			putData(sheetObj, formObj);
			if(formObj.open_mode.value == 'multiple'){
				setSurchargeInputInquiry_multiple( sheetObj, formObj);
			}else{
				setSurchargeInputInquiry( sheetObj, formObj);
			}
			saveFlag = false;
			ComOpenWait(false);
			if(formObj.open_mode.value == 'multiple'){
				ComShowCodeMessage('COM12116', 'Surcharge Apply');
			}
			window.close();
		break;

		case 'SEARCH_BY_SHEET':
			var queryStr = '';
			var colName = '';
			var sheetObj_surcharge = opener.sheetObjects[formObj.sheet_arr_no.value];
			for(var row=1; row<sheetObj_surcharge.RowCount+1; row++){
				if(formObj.unique_cd.value == sheetObj_surcharge.CellValue(row, prefix+'unique_cd')){
					for(var i=0; i<= sheetObj_surcharge.LastCol; i++){
						colName = sheetObj_surcharge.ColSaveName(i);
						queryStr += '&'+colName +'='+sheetObj_surcharge.CellValue(row, colName);
					}
				}
			}
			sheetObj.DoSearch4Post("ESD_TRS_0969.screen", queryStr, TrsFrmQryString(formObj), true);
			break;
		case 'SEARCH_CODE_NAME':
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch4Post("ESD_TRS_0918GS.do", TrsFrmQryString(formObj));
			break;
	}
}


/**
 * Surcharge Input Inquiry popup으로부터 data 전송받기
 **/
function setSurchargeInputInquiry(pop_sheetObj, formObj)
{
	var row = formObj.main_row.value;
	var unique_cd = formObj.unique_cd.value;
	var surcharge_sheetObj = opener.sheetObjects[formObj.sheet_arr_no.value];
	var main_sheetObj = opener.sheetObjects[0];
	// 이전에 세팅됐던 값은 지워버린다.
	try{ 
		for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
		{
			if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd) surcharge_sheetObj.RowDelete(a, false);
		}
		
		var queryStr = pop_sheetObj.GetSaveString(true, true);
		if(queryStr !=''){
			var url = '?prefix='+prefix;
			surcharge_sheetObj.DoSearch4Post("ESD_TRS_0969.screen"+url, queryStr,'', true);
		
			//------------------- SCOWAL항목의 무게 단위를 부모창시트에 설정 ----------------------
			var scg_row_cnt = surcharge_sheetObj.RowCount;
			for(i=1;i<=scg_row_cnt;i++){ //부모창의 surcharge_sheetObj의 모든 행에 대해 for문으로 돌리면서 
				var scg_unq_cd = surcharge_sheetObj.CellValue(i,prefix+'unique_cd');
				if(scg_unq_cd == unique_cd){ //부모창 시트의 unique_cd가 팝업창의 unique_cd 파라미터와 동일한 것을 찾고
					var scg_lgs_cd = surcharge_sheetObj.CellValue(i,prefix+'lgs_cost_cd');
					if(scg_lgs_cd=="SCOWAL"){ //그중 lgs_cost_cd 가 SCOWAL인 것을 찾아서
						//해당 행에 weightUnit값을 세팅
						if (invfix == undefined || invfix == ""){
							surcharge_sheetObj.CellValue2(i,prefix+'wo_grs_wgt_meas_ut_cd') = formObj.weightUnit.value;
						} else if(invfix == "inv_") {
							surcharge_sheetObj.CellValue2(i,prefix+'inv_grs_wgt_meas_ut_cd') = formObj.weightUnit.value;
						}
					}
				}
			}
			//----------------------------------------------------------------------
			
		}
		main_sheetObj.CellValue(row, invfix+'etc_add_amt') = formObj.surcharge_total.value;
	} catch(e) {
		saveFlag = false;
		ComShowMessage(e);
	}
}

/**
 * Surcharge Input Inquiry popup으로부터 data 전송받기
 **/
function setSurchargeInputInquiry_multiple(pop_sheetObj, formObj)
{
	var row = formObj.main_row.value;
	var unique_cd = formObj.unique_cd.value;
	var surcharge_sheetObj = opener.sheetObjects[formObj.sheet_arr_no.value];
	var main_sheetObj = opener.sheetObjects[0];

	// 이전에 세팅됐던 값은 지워버린다.
	try{
		var queryStr = pop_sheetObj.GetSaveString(true, true);
		var url = '?prefix='+prefix;
		queryStr	+= '&multi_ofc_cty_cdStr='	+ multi_ofc_cty_cdStr;
		queryStr	+= '&multi_so_seqStr='		+ multi_so_seqStr;
		queryStr	+= '&multi_cgo_tp_cdStr='	+ multi_cgo_tp_cdStr;
		queryStr	+= '&mode=copy_surcharge_popup';
		pop_sheetObj.DoSearch4Post("ESD_TRS_0970.screen"+url, queryStr,'', false);
		var main_surcharge_queryStr = surcharge_sheetObj.GetSaveString(true, true);
		main_surcharge_queryStr	+= '&multi_ofc_cty_cdStr='	+ multi_ofc_cty_cdStr;
		main_surcharge_queryStr	+= '&multi_so_seqStr='		+ multi_so_seqStr;
		main_surcharge_queryStr += '&mode=main_surcharge_dup_check';
		pop_sheetObj.DoSearch4Post("ESD_TRS_0970.screen"+url, main_surcharge_queryStr,'', true);
		queryStr = pop_sheetObj.GetSaveString(true, true);
		if(queryStr == '') {
			surcharge_sheetObj.RemoveAll();
		}else{
			var url = '?prefix='+prefix;
			surcharge_sheetObj.DoSearch4Post("ESD_TRS_0969.screen"+url, queryStr,'', false);
		}

		for(var k=0; k<multi_ofc_cty_cdArray.length;k++){
			main_sheetObj.CellValue2(check_rowArray[k], invfix+'etc_add_amt') = formObj.surcharge_total.value;
			if(formObj.step_cd.value != 'IV'){
				searchLocalCurr2UsdCurr(surcharge_sheetObj, main_sheetObj, opener.document.form, check_rowArray[k]);
			}
		}
		if(formObj.step_cd.value == 'IV'){
			opener.setSumOfInvoiceTotalAmount2(main_sheetObj, opener.document.form);
		//	opener.setNumOfEQ2(main_sheetObj, opener.document.form);
		}
	} catch(e) {
		saveFlag = false;
//     supplement 에서 save시에 error 뜸.
//		ComShowMessage(e);
	}
}

function searchLocalCurr2UsdCurr(sheetObj, main_sheetObj, formObj, row){

	sheetObj.RemoveEtcData();
	if(main_sheetObj.CellValue(row, 'po_local_curr_cd') == '') return; 

	var url = 'LOCAL_TOT_AMT='+main_sheetObj.CellValue(row, 'po_local_curr_tot_amt');
	url += '&CURR_CD='+main_sheetObj.CellValue(row, 'po_local_curr_cd');
	formObj.f_cmd.value = SEARCH03;

	sheetObj.DoSearch4Post("ESD_TRS_0023GS.do", url+'&'+TrsFrmQryString(formObj), '', true);
	if(sheetObj.EtcData('amt_usd') != undefined && sheetObj.EtcData('amt_usd') != ''){
		main_sheetObj.CellValue2(row, 'po_usd_curr_tot_amt') = sheetObj.EtcData('amt_usd');
	}
}


function calCurrencyChange(sheetObj, formObj){
	if(formObj.cal_logic.value == '' || formObj.cal_logic.value == null) return;

	var rateValue = Number(formObj.rate.value);
	var amt = 0;

	switch(formObj.cal_logic.value){
		case('TM'):
			for(var i=1; i<sheetObj.RowCount+1; i++){
				amt = Number(sheetObj.CellValue(i, prefix+invfix+'scg_amt'));
				sheetObj.CellValue2(i, prefix+invfix+'scg_amt') = myRound(amt * rateValue);
			}
		break;

		case('DV'):
			for(var i=1; i<sheetObj.RowCount+1; i++){
				amt = Number(sheetObj.CellValue(i, prefix+invfix+'scg_amt'));
				sheetObj.CellValue2(i, prefix+invfix+'scg_amt') = myRound(amt / rateValue);
			}
		break;
	}
}

function bindSheettoForm(sheetObj, formObj){
	for(var i=1; i< sheetObj.RowCount+1; i++)
	{
		if (sheetObj.CellValue(i, prefix+'lgs_cost_cd').substring(2,4) == 'FU') continue;
		if (sheetObj.CellValue(i, prefix+'lgs_cost_cd').substring(2,4) == 'HL') continue;
		var lgs_cost_cd_value_tmp = sheetObj.CellValue(i, prefix+'lgs_cost_cd');

		lgs_cost_cd_value_tmp = 'SC'+lgs_cost_cd_value_tmp.substring(2);

		var chk_obj = eval('formObj.'+lgs_cost_cd_value_tmp+'_chk');
		var txt_obj = eval('formObj.'+lgs_cost_cd_value_tmp+'_txt');
		var scg_amt = sheetObj.CellValue(i, prefix+invfix+'scg_amt');
		if(scg_amt == undefined || ComTrim(scg_amt) == '' || Number(scg_amt) == 0) continue;

		if(formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD'){
			txt_obj.value = chkAmtPos_JPY(sheetObj.CellValue(i, prefix+invfix+'scg_amt'));
		}else{
			txt_obj.value = sheetObj.CellValue(i, prefix+invfix+'scg_amt');
		}

		if(txt_obj.value != '' && Number(txt_obj.value) != 0) chk_obj.checked = true;
		

		var lgs_cost_cd_value = sheetObj.CellValue(i, prefix+'lgs_cost_cd');
		switch(lgs_cost_cd_value.substring(2)) {
			case 'CDAL':
				formObj.chss_no.value = sheetObj.CellValue(i, prefix+invfix+'chss_no');
				formObj.incur_dt.value = sheetObj.CellValue(i, prefix+invfix+'incur_dt');
				//formObj.chasis_drayage_type_size.value = sheetObj.CellValue(i, prefix+invfix+'chss_mgst_tpsz_cd');
				break;
			
			case 'DRAL':
				if(sheetObj.CellValue(i, prefix+invfix+'dry_run_rlbl_pty_tp_cd') == 'HJ')
				{
					formObj.reliable_party[0].checked  = true;
				}else if (sheetObj.CellValue(i, prefix+invfix+'dry_run_rlbl_pty_tp_cd') == 'CS')
				{
					formObj.reliable_party[1].checked  = true;
				}
				break;
			
			case 'FIAL':
				formObj.cause.value = sheetObj.CellValue(i, prefix+invfix+'fne_cuz_desc');
				break;

			case 'FGAL':
				if(sheetObj.CellValue(i, prefix+invfix+'fumg_cost_tp_cd') == 'FE'){
					formObj.cost_rdo[0].checked  = true;
				}else if (sheetObj.CellValue(i, prefix+invfix+'fumg_cost_tp_cd') == 'ED'){
					formObj.cost_rdo[1].checked  = true;
				}else if (sheetObj.CellValue(i, prefix+invfix+'fumg_cost_tp_cd') == 'FC'){
					formObj.cost_rdo[2].checked  = true;
				}
			break;

			case 'GNAL':
				formObj.getset_tp_sz.value = sheetObj.CellValue(i, prefix+invfix+'mgst_tpsz_cd');
				//Reefer Handling flag
				if(sheetObj.CellValue(i, prefix+invfix+'rf_hndl_flg')=="Y"){
					formObj.flg_reefer_hd.checked = true; 
				}else{
					formObj.flg_reefer_hd.checked = false;					
				}
				//Reefer
				if(sheetObj.CellValue(i, prefix+invfix+'rf_mgst_usg_flg')=="Y"){
					formObj.flg_reefer_gs.checked = true ;					
				}else{
					formObj.flg_reefer_gs.checked = false ;
				}

				break;

			case 'INAL':
				if(sheetObj.CellValue(i, prefix+invfix+'insp_rf_pti_cstms_tp_cd') == 'RP')
				{
					formObj.reefer_rdo[0].checked  = true;
				}else if (sheetObj.CellValue(i, prefix+invfix+'insp_rf_pti_cstms_tp_cd') == 'CS')
				{
					formObj.reefer_rdo[1].checked  = true;
				}
				break;

			case 'LFAL':
				formObj.number_lifting.value = sheetObj.CellValue(i, prefix+invfix+'lftg_knt');
				formObj.number_cause.value = sheetObj.CellValue(i, prefix+invfix+'lftg_cuz_desc');
				break;

			case 'MDAL':
				var nod = sheetObj.CellValue(i, prefix+invfix+'stop_loc_nod_cd');
				formObj.stop_loc.value = nod.substring(0,5);
				if(nod.length>5){
					getComboList(formObj.stop_loc);
					document.stop_yard.Enable = true;
					document.stop_yard.Code = nod.substring(5,7);
				}
				break;

			case 'OWAL':
				formObj.gross_weight.value = sheetObj.CellValue(i, prefix+invfix+'grs_wgt');
				//Over Weight Tri-axle flag
				if(sheetObj.CellValue(i, prefix+invfix+'tri_axl_flg')=="Y"){
					formObj.flg_tri_axle.checked = true;					
				}else{
					formObj.flg_tri_axle.checked = false;
				}
				//Over Weight Permit/Handling  flag
				if( sheetObj.CellValue(i, prefix+invfix+'ovr_wgt_prmt_flg')=="Y"){
					formObj.flg_permit.checked = true;	
				}else{
					formObj.flg_permit.checked = false;
				}
				
				//Over Weight Others  flag
				if(sheetObj.CellValue(i, prefix+invfix+'ovr_wgt_otr_flg')=="Y"){
					formObj.flg_others.checked = true ;
				}else{
					formObj.flg_others.checked = false ;
				}
				
				formObj.gross_weight_rmk.value = sheetObj.CellValue(i, prefix+invfix+'ovr_wgt_rmk');
				
				 //Over Weight(Tri-axle)에 값이 있을 경우 다시 팝업 띄웠을 때
				formObj.gross_weight.disabled = false;

				var wo_grs_wgt_meas_ut_cd = sheetObj.CellValue(i, prefix+'wo_grs_wgt_meas_ut_cd');
				var inv_grs_wgt_meas_ut_cd = sheetObj.CellValue(i, prefix+'inv_grs_wgt_meas_ut_cd');

				if (wo_grs_wgt_meas_ut_cd != undefined && wo_grs_wgt_meas_ut_cd != ""){
					formObj.weightUnit.value = wo_grs_wgt_meas_ut_cd;
				} else if (inv_grs_wgt_meas_ut_cd != undefined && inv_grs_wgt_meas_ut_cd != ""){
					formObj.weightUnit.value = inv_grs_wgt_meas_ut_cd;
				} else {
					formObj.weightUnit.value = ""
				}
				
				formObj.weightUnit.disabled = false;
				
				break;

			case 'PPAL':
				formObj.incurred_date.value = sheetObj.CellValue(i, prefix+invfix+'incrt_dt');
				break;

			case 'SSAL':
				var nod = sheetObj.CellValue(i, prefix+invfix+'scl_stop_plc_nod_cd');
				formObj.scale_loc.value = nod.substring(0,5);
				if(nod.length>5) {
					getComboList(formObj.scale_loc);
					document.scale_yard.Enable = true;
					document.scale_yard.Code = nod.substring(5,7);
				}
				break;
				break;

			case 'SRAL':
				formObj.days.value = sheetObj.CellValue(i, prefix+invfix+'sto_dys');
				break;

			case 'STAL':
				formObj.outbound_booking_no.value = sheetObj.CellValue(i, prefix+invfix+'ob_bkg_no');
				break;

			case 'WTAL':
				formObj.waiting_hour.value = sheetObj.CellValue(i, prefix+invfix+'wt_hrs');
				break;

			case 'OTAL':
				formObj.remarks.value = sheetObj.CellValue(i, prefix+invfix+'otr_rmk');
				break;
		}
	}
	getSumTotalAmount();
}


function setDisplayForm(sheetObj, formObj){
/*
	조회시 조회가 된 항목만 보여준다.
	먼저 모든 항목을 display = none; 시킨뒤
	sheet 내용을 검색하여 조회된 항목만 block시킨다.
*/
//document.all.SCALAL_01.style.display = "none";
//document.all.SCLWAL_01.style.display = "none";
//document.all.SCCDAL_01.style.display = "none";
//document.all.SCDPAL_01.style.display = "none";
//document.all.SCDRAL_01.style.display = "none";
//document.all.SCFRAL_01.style.display = "none";
//document.all.SCFIAL_01.style.display = "none";
//document.all.SCFGAL_01.style.display = "none";
//document.all.SCGNAL_01.style.display = "none";
//document.all.SCHZAL_01.style.display = "none";
//document.all.SCINAL_01.style.display = "none";
//document.all.SCLFAL_01.style.display = "none";
//document.all.SCMDAL_01.style.display = "none";
//document.all.SCOSAL_01.style.display = "none";
//document.all.SCOWAL_01.style.display = "none";
//document.all.SCPPAL_01.style.display = "none";
//document.all.SCRCAL_01.style.display = "none";
//document.all.SCSSAL_01.style.display = "none";
//document.all.SCSRAL_01.style.display = "none";
//document.all.SCSTAL_01.style.display = "none";
//document.all.SCSNAL_01.style.display = "none";
//document.all.SCSFAL_01.style.display = "none";
//document.all.SCTDAL_01.style.display = "none";
//document.all.SCTLAL_01.style.display = "none";
//document.all.SCWTAL_01.style.display = "none";
//document.all.SCOTAL_01.style.display = "none";
//document.all.SCENAL_01.style.display = "none";
//
//document.all.SCALAL_02.style.display = "none";
//document.all.SCLWAL_02.style.display = "none";
//document.all.SCCDAL_02.style.display = "none";
//document.all.SCDPAL_02.style.display = "none";
//document.all.SCDRAL_02.style.display = "none";
//document.all.SCFRAL_02.style.display = "none";
//document.all.SCFIAL_02.style.display = "none";
//document.all.SCFGAL_02.style.display = "none";
//document.all.SCGNAL_02.style.display = "none";
//document.all.SCHZAL_02.style.display = "none";
//document.all.SCINAL_02.style.display = "none";
//document.all.SCLFAL_02.style.display = "none";
//document.all.SCMDAL_02.style.display = "none";
//document.all.SCOSAL_02.style.display = "none";
//document.all.SCOWAL_02.style.display = "none";
//document.all.SCPPAL_02.style.display = "none";
//document.all.SCRCAL_02.style.display = "none";
//document.all.SCSSAL_02.style.display = "none";
//document.all.SCSRAL_02.style.display = "none";
//document.all.SCSTAL_02.style.display = "none";
//document.all.SCSNAL_02.style.display = "none";
//document.all.SCSFAL_02.style.display = "none";
//document.all.SCTDAL_02.style.display = "none";
//document.all.SCTLAL_02.style.display = "none";
//document.all.SCWTAL_02.style.display = "none";
//document.all.SCOTAL_02.style.display = "none";
//document.all.SCENAL_02.style.display = "none";

document.all.btn_save.style.display = "none";
document.all.btn_save_left.style.display = "none";
document.all.btn_save_right.style.display = "none";
document.all.btn1_line.style.display = "none";


formObj.SCALAL_chk.disabled = true;
formObj.SCLWAL_chk.disabled = true;
formObj.SCCDAL_chk.disabled = true;
formObj.SCDPAL_chk.disabled = true;
formObj.SCDRAL_chk.disabled = true;
formObj.SCFRAL_chk.disabled = true;
formObj.SCFIAL_chk.disabled = true;
formObj.SCFGAL_chk.disabled = true;
formObj.SCGNAL_chk.disabled = true;
formObj.SCHZAL_chk.disabled = true;
formObj.SCINAL_chk.disabled = true;
formObj.SCLFAL_chk.disabled = true;
formObj.SCMDAL_chk.disabled = true;
formObj.SCOSAL_chk.disabled = true;
formObj.SCOWAL_chk.disabled = true;
formObj.SCPPAL_chk.disabled = true;
formObj.SCRCAL_chk.disabled = true;
formObj.SCSSAL_chk.disabled = true;
formObj.SCSRAL_chk.disabled = true;
formObj.SCSTAL_chk.disabled = true;
formObj.SCSNAL_chk.disabled = true;
formObj.SCSFAL_chk.disabled = true;
formObj.SCTDAL_chk.disabled = true;
formObj.SCTLAL_chk.disabled = true;
formObj.SCWTAL_chk.disabled = true;
formObj.SCOTAL_chk.disabled = true;
formObj.SCENAL_chk.disabled = true;

}


function setEnableForm(sheetObj, formObj){

	for(var i=1; i< sheetObj.RowCount+1; i++){
		var scg_amt = sheetObj.CellValue(i, prefix+invfix+'scg_amt');
		if(scg_amt == undefined || ComTrim(scg_amt) == '') continue;

        var cost_cd = sheetObj.CellValue(i, prefix+'lgs_cost_cd');
        cost_cd = cost_cd.substr(0,1)+'C'+cost_cd.substr(2);

        var chk_obj = eval('formObj.'+cost_cd+'_chk');
        var txt_obj = eval('formObj.'+cost_cd+'_txt');
        
        if(chk_obj == null || chk_obj == undefined || chk_obj == 'undefined') continue;
        if(chk_obj.checked){
        	txt_obj.disabled = false;
        }
    
		var lgs_cost_cd_value = sheetObj.CellValue(i, prefix+'lgs_cost_cd');

		switch(lgs_cost_cd_value.substring(2)){
			case 'CDAL':
				//formObj.chasis_drayage_type_size.disabled = false;
				formObj.chss_no.disabled = false;
				formObj.incur_dt.disabled = false;
				break;
			
			case 'DRAL':
				formObj.reliable_party[0].disabled = false;
				formObj.reliable_party[1].disabled = false;
				break;
			
			case 'FIAL':
				formObj.cause.disabled = false;
				break;

			case 'FGAL':
				formObj.cost_rdo[0].disabled = false;
				formObj.cost_rdo[1].disabled = false;
				formObj.cost_rdo[2].disabled = false;
				break;

			case 'GNAL':
				formObj.getset_tp_sz.disabled = false;
				formObj.flg_reefer_hd.disabled = false;
				formObj.flg_reefer_gs.disabled = false;
			break;

			case 'INAL':
				formObj.reefer_rdo[0].disabled = false;
				formObj.reefer_rdo[1].disabled = false;
				break;

			case 'LFAL':
				formObj.number_lifting.disabled = false;
				formObj.number_cause.disabled = false;
				break;

			case 'MDAL':
				formObj.stop_loc.disabled = false;
				document.stop_yard.Enable = true;
				break;
				
			case 'OWAL':
				formObj.gross_weight.disabled = false;
				formObj.weightUnit.disabled = false;
				formObj.flg_tri_axle.disabled = false;
				formObj.flg_permit.disabled = false;
				formObj.flg_others.disabled = false;
				formObj.gross_weight_rmk.disabled = false;
				break;

			case 'PPAL':
				formObj.incurred_date.disabled = false;
				break;

			case 'SSAL':
				formObj.scale_loc.disabled = false;
				document.scale_yard.Enable = true;
				break;

			case 'SRAL':
				formObj.days.disabled = false;
				break;

			case 'STAL':
				formObj.outbound_booking_no.disabled = false;
				break;

			case 'WTAL':
				formObj.waiting_hour.disabled = false;
				break;

			case 'OTAL':
				formObj.remarks.disabled = false;
				break;
		}
	}
}


function getSumTotalAmount(inputObj){
	var formObj = document.form;

	if(inputObj != undefined &&  inputObj != null && (formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD')){
		inputObj.value = chkAmtPos_JPY(inputObj.value);
	}else if(inputObj != undefined && inputObj != null){
		inputObj.value = chkAmtPos(inputObj.value);
	}

	checkNumber(formObj.SCALAL_txt,true);
	checkNumber(formObj.SCLWAL_txt,true);
	checkNumber(formObj.SCCDAL_txt,true);
	checkNumber(formObj.SCDPAL_txt,true);
	checkNumber(formObj.SCDRAL_txt,true);
	checkNumber(formObj.SCFRAL_txt,true);
	checkNumber(formObj.SCFIAL_txt,true);
	checkNumber(formObj.SCFGAL_txt,true);
	checkNumber(formObj.SCGNAL_txt,true);
	checkNumber(formObj.SCHZAL_txt,true);
	checkNumber(formObj.SCINAL_txt,true);
	checkNumber(formObj.SCLFAL_txt,true);
	checkNumber(formObj.SCMDAL_txt,true);
	checkNumber(formObj.SCOSAL_txt,true);
	checkNumber(formObj.SCOWAL_txt,true);
	checkNumber(formObj.SCPPAL_txt,true);
	checkNumber(formObj.SCRCAL_txt,true);
	checkNumber(formObj.SCSSAL_txt,true);
	checkNumber(formObj.SCSRAL_txt,true);
	checkNumber(formObj.SCSTAL_txt,true);
	checkNumber(formObj.SCSNAL_txt,true);
	checkNumber(formObj.SCSFAL_txt,true);
	checkNumber(formObj.SCTDAL_txt,true);
	checkNumber(formObj.SCTLAL_txt,true);
	checkNumber(formObj.SCWTAL_txt,true);
	checkNumber(formObj.SCOTAL_txt,true);
	checkNumber(formObj.SCENAL_txt,true);

	var totalAmt =	
		Number(formObj.SCALAL_txt.value) +
		Number(formObj.SCLWAL_txt.value) +
		Number(formObj.SCCDAL_txt.value) +
		Number(formObj.SCDPAL_txt.value) +
		Number(formObj.SCDRAL_txt.value) +
		Number(formObj.SCFRAL_txt.value) +
		Number(formObj.SCFIAL_txt.value) +
		Number(formObj.SCFGAL_txt.value) +
		Number(formObj.SCGNAL_txt.value) +
		Number(formObj.SCHZAL_txt.value) +
		Number(formObj.SCINAL_txt.value) +
		Number(formObj.SCLFAL_txt.value) +
		Number(formObj.SCMDAL_txt.value) +
		Number(formObj.SCOSAL_txt.value) +
		Number(formObj.SCOWAL_txt.value) +
		Number(formObj.SCPPAL_txt.value) +
		Number(formObj.SCRCAL_txt.value) +
		Number(formObj.SCSSAL_txt.value) +
		Number(formObj.SCSRAL_txt.value) +
		Number(formObj.SCSTAL_txt.value) +
		Number(formObj.SCSNAL_txt.value) +
		Number(formObj.SCSFAL_txt.value) +
		Number(formObj.SCTDAL_txt.value) +
		Number(formObj.SCTLAL_txt.value) +
		Number(formObj.SCWTAL_txt.value) +
		Number(formObj.SCOTAL_txt.value) +
	    Number(formObj.SCENAL_txt.value) ;

	formObj.surcharge_total.value = totalAmt;
	return totalAmt;
}

function setCheckedForm(chkObj)
{
	var objName = chkObj.name.split('_')[0];
	var txtObj = eval('document.form.'+objName+'_txt');
	var formObj = document.form;
	
	if(chkObj.checked){
		txtObj.disabled = false;
		switch(objName){
			case 'SCCDAL':
				//formObj.chasis_drayage_type_size.disabled = false;
				formObj.chss_no.disabled = false;
				formObj.incur_dt.disabled = false;
				break;
				
			case 'SCDRAL':
				formObj.reliable_party[0].disabled = false;
				formObj.reliable_party[1].disabled = false;
				break;
			
			case 'SCFIAL':
				formObj.cause.disabled = false;
				break;

			case 'SCFGAL':
				formObj.cost_rdo[0].disabled = false;
				formObj.cost_rdo[1].disabled = false;
				formObj.cost_rdo[2].disabled = false;
			break;

			case 'SCGNAL':
				formObj.getset_tp_sz.disabled = false;
				formObj.flg_reefer_hd.disabled = false;
				formObj.flg_reefer_gs.disabled = false;
			break;

			case 'SCINAL':
				formObj.reefer_rdo[0].disabled = false;
				formObj.reefer_rdo[1].disabled = false;
				break;

			case 'SCLFAL':
				formObj.number_lifting.disabled = false;
				formObj.number_cause.disabled = false;
				break;

			case 'SCMDAL':
				formObj.stop_loc.disabled = false;
				document.stop_yard.Enable = true;
				break;

			case 'SCOWAL':
				formObj.gross_weight.disabled = false;
				formObj.weightUnit.disabled = false;
				formObj.flg_tri_axle.disabled = false;
				formObj.flg_permit.disabled = false;
				formObj.flg_others.disabled = false;
				formObj.gross_weight_rmk.disabled = false;
				
				break;

			case 'SCPPAL':
				formObj.incurred_date.disabled = false;
				break;

			case 'SCSSAL':
				formObj.scale_loc.disabled = false;
				document.scale_yard.Enable = true;
				break;

			case 'SCSRAL':
				formObj.days.disabled = false;
				break;

			case 'SCSTAL':
				formObj.outbound_booking_no.disabled = false;
				break;

			case 'SCWTAL':
				formObj.waiting_hour.disabled = false;
				break;

			case 'SCOTAL':
				formObj.remarks.disabled = false;
				break;
		}	
	}else{
		txtObj.value = '';
		txtObj.disabled = true;
		switch(objName){
			case 'SCCDAL':
				//formObj.chasis_drayage_type_size.disabled = true;
				//formObj.chasis_drayage_type_size.value = '';
				formObj.chss_no.disabled = true;
				formObj.chss_no.value = '';
				formObj.incur_dt.disabled = true;
				formObj.incur_dt.value = '';
				break;
				
			case 'SCDRAL':
				formObj.reliable_party[0].disabled = true;
				formObj.reliable_party[1].disabled = true;
				break;
			
			case 'SCFIAL':
				formObj.cause.disabled = true;
				formObj.cause.value = '';
				break;

			case 'SCFGAL':
				formObj.cost_rdo[0].disabled = true;
				formObj.cost_rdo[1].disabled = true;
				formObj.cost_rdo[2].disabled = true;
			break;

			case 'SCGNAL':
				formObj.getset_tp_sz.disabled = true;
				formObj.flg_reefer_hd.disabled = true;
				formObj.flg_reefer_hd.checked = false;
				formObj.flg_reefer_gs.disabled = true;
				formObj.flg_reefer_gs.checked = false;
				formObj.getset_tp_sz.value="";
			break;

			case 'SCINAL':
				formObj.reefer_rdo[0].disabled = true;
				formObj.reefer_rdo[1].disabled = true;
				break;

			case 'SCLFAL':
				formObj.number_lifting.disabled = true;
				formObj.number_cause.disabled = true;
				formObj.number_lifting.value = '';
				formObj.number_cause.value = '';
				break;

			case 'SCMDAL':
				formObj.stop_loc.disabled = true;
				document.stop_yard.Enable = false;
				formObj.stop_loc.value = '';
				document.stop_yard.RemoveAll();
				break;

			case 'SCOWAL':
				formObj.gross_weight.disabled = true;
				formObj.gross_weight.value = '';
				formObj.weightUnit.disabled = true;
				formObj.weightUnit.value = 'LBS';
			
				formObj.flg_tri_axle.disabled = true;
				formObj.flg_tri_axle.checked = false;
				formObj.flg_permit.disabled = true;
				formObj.flg_permit.checked = false;
				formObj.flg_others.disabled = true;
				formObj.flg_others.checked = false;
				formObj.gross_weight_rmk.disabled = true;
				formObj.gross_weight_rmk.value ="";
			break;

			case 'SCPPAL':
				formObj.incurred_date.disabled = true;
				formObj.incurred_date.value = '';
				break;

			case 'SCSSAL':
				formObj.scale_loc.disabled = true;
				document.scale_yard.Enable = false;
				formObj.scale_loc.value = '';
				document.scale_yard.RemoveAll();
				break;

			case 'SCSRAL':
				formObj.days.disabled = true;
				formObj.days.value = '';
				break;

			case 'SCSTAL':
				formObj.outbound_booking_no.disabled = true;
				formObj.outbound_booking_no.value = '';
				break;

			case 'SCWTAL':
				formObj.waiting_hour.disabled = true;
				formObj.waiting_hour.value = '';
				break;

			case 'SCOTAL':
				formObj.remarks.disabled = true;
				formObj.remarks.value = '';
				break;
		}	

	}
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'stop_loc':
			case 'scale_loc':
				getComboList(obj);
				break;
		}
	}
}

/**
 * 외부 콤보박스의 리스트 가져오기
 **/
function getComboList(obj)
{
	var yard_obj = null;
	var formObj = document.form;

	obj.value = obj.value.toUpperCase();

	if(obj.name == 'stop_loc') yard_obj = document.stop_yard;
	else if(obj.name == 'scale_loc') yard_obj = document.scale_yard;
	
	var locValue = obj.value;

	if(ComTrim(locValue) == ''){
		yard_obj.RemoveAll();
		return;
	}
	getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
}

/**
* 공통 Node popup
*/
function openHireYardPopup( btn_obj )
{
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_061_1";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var returnFunction = 'setStopNode';
	if(btn_obj == 'scale_node') returnFunction = 'setScaleNode';

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * popSearchPiCommCodeGrid 프로세스 처리
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;

	if(myWin != null) myWin.close();
	url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}

/**
* fmNode를 팝업을 통해 세팅
*/
function setStopNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.stop_loc.value = loc;
	getComboList(document.form.stop_loc);
	document.stop_yard.CODE = yard;
}

/**
* fmNode를 팝업을 통해 세팅
*/
function setScaleNode(rowArray) {
	var formObject = document.form;

	var colArray = rowArray[0];
	var node = colArray[3];
	
	var loc = node.substring(0,5);
	var yard = node.substring(5,7);

	document.form.scale_loc.value = loc;
	getComboList(document.form.scale_loc);
	document.scale_yard.CODE = yard;
}

function getCalendar(){
	var cal = new ComCalendar();
     cal.displayType = "date";
     cal.select(document.form.incurred_date, 'yyyyMMdd');
}

function getCalendar2(){
	var cal = new ComCalendar();
     cal.displayType = "date";
     cal.select(document.form.incur_dt, 'yyyyMMdd');
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSAVE:      //조회
			if(formObj.SCALAL_chk.checked){ 
				if(formObj.SCALAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Additional Labor');
					formObj.SCALAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCALAL_txt,true)) return false;
			}
			if(formObj.SCLWAL_chk.checked) { 
				if(formObj.SCLWAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Seasonal Surcharge');
					formObj.SCLWAL_txt.focus();
					return false;
				}
			}
			if(formObj.SCCDAL_chk.checked){ 
				if(formObj.SCCDAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Chassis Drayage');
					formObj.SCCDAL_txt.focus();
					return false;
				}else if(formObj.chss_no.value=='') { 
					ComShowCodeMessage('COM12114','Chassis No');
					formObj.chss_no.focus();
					return false;
				}else if(formObj.incur_dt.value=='') { 
					ComShowCodeMessage('COM12114','Incurred Date');
					formObj.incur_dt.focus();
					return false;
				}else if(!checkNumber(formObj.SCCDAL_txt,true)) return false;
			}
			
			if(formObj.SCDPAL_chk.checked){ 
				if(formObj.SCDPAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Drop and Pull (Drop and Pick up/Bob tail)');
					formObj.SCDPAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCDPAL_txt,true)) return false;
			}
			if(formObj.SCDRAL_chk.checked){ 
				if(formObj.SCDRAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Dry Run');
					formObj.SCDRAL_txt.focus();
					return false;
				}else if(!formObj.reliable_party[0].checked && !formObj.reliable_party[1].checked) { 
					ComShowCodeMessage('COM12114','Reliable Party');
					formObj.reliable_party[0].focus();
					return false;
				}else if(!checkNumber(formObj.SCDRAL_txt,true)) return false;
			}
			if(formObj.SCFRAL_chk.checked){ 
				if(formObj.SCFRAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Ferry Cost ');
					formObj.SCFRAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCFRAL_txt,true)) return false;
			}
			if(formObj.SCFIAL_chk.checked){ 
				if(formObj.SCFIAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Fine');
					formObj.SCFIAL_txt.focus();
					return false;
				}else if(formObj.cause.value=='') { 
					ComShowCodeMessage('COM12114','Cause');
					formObj.cause.focus();
					return false;
				}else if(!checkNumber(formObj.SCFIAL_txt,true)) return false;
			}
			if(formObj.SCFGAL_chk.checked){ 
				if(formObj.SCFGAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Fulmigation/Cleaning');
					formObj.SCFGAL_txt.focus();
					return false;
				}else if(!formObj.cost_rdo[0].checked && !formObj.cost_rdo[1].checked && !formObj.cost_rdo[2].checked) { 
					ComShowCodeMessage('COM12114','Cost');
					formObj.cost_rdo[0].focus();
					return false;
				}else if(!checkNumber(formObj.SCFGAL_txt,true)) return false;
			}
			if(formObj.SCGNAL_chk.checked){ 
				if(formObj.SCGNAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Reefer');
					formObj.SCGNAL_txt.focus();
					return false;
				}else if(formObj.flg_reefer_gs.checked == false && formObj.flg_reefer_hd.checked == false){ 
					ComShowCodeMessage('TRS90386','Please check detailed item');
					return false;
				}else if(formObj.flg_reefer_gs.checked == true && formObj.getset_tp_sz.value==''){ 
					ComShowCodeMessage('COM12114','Gen-Set Type/Size');
					//Explorer 8에서 오류 발생하여 주석처리 2014.05.13 신동일
					//formObj.getset_tp_sz.focus();
					return false;
				}else if(!checkNumber(formObj.SCGNAL_txt,true)) return false;
			}
			if(formObj.SCHZAL_chk.checked){ 
				if(formObj.SCHZAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','HAZMAT(DG)');
					formObj.SCHZAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCHZAL_txt,true)) return false;
			}
			if(formObj.SCINAL_chk.checked){ 
				if(formObj.SCINAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Inspection');
					formObj.SCINAL_txt.focus();
					return false;
				}else if(!formObj.reefer_rdo[0].checked && !formObj.reefer_rdo[1].checked) { 
					ComShowCodeMessage('COM12114','Inspection');
					formObj.reefer_rdo[0].focus();
					return false;
				}else if(!checkNumber(formObj.SCINAL_txt,true)) return false;
			}
			if(formObj.SCLFAL_chk.checked){ 
				if(formObj.SCLFAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Lifting Charge');
					formObj.SCLFAL_txt.focus();
					return false;
				}else if(formObj.number_lifting.value=='') { 
					ComShowCodeMessage('COM12114','Number Of Lifting');
					formObj.number_lifting.focus();
					return false;
				}else if(formObj.number_cause.value=='') { 
					ComShowCodeMessage('COM12114','Cause');
					formObj.number_cause.focus();
					return false;
				}else if(!checkNumber(formObj.SCLFAL_txt,true)) return false;
				else if(!checkNumber(formObj.number_lifting,true)) return false;
			}
			if(formObj.SCMDAL_chk.checked){ 
				if(formObj.SCMDAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Multiple Delivery');
					formObj.SCMDAL_txt.focus();
					return false;
				}else if(formObj.stop_loc.value.length != 0 && formObj.stop_loc.value.length != 5 ) { 
					ComShowCodeMessage('COM12114','Stop Location');
					formObj.stop_loc.focus();
					return false;
				}else if(!checkNumber(formObj.SCMDAL_txt,true)) return false;
			}
			if(formObj.SCOSAL_chk.checked){ 
				if(formObj.SCOSAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Over Size(OOG)');
					formObj.SCOSAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCOSAL_txt,true)) return false;
			}
			if(formObj.SCOWAL_chk.checked){
				if(formObj.SCOWAL_txt.value=='') {
					ComShowCodeMessage('COM12114','Over Weight');
					formObj.SCOWAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCOWAL_txt,true)){
					return false;
				}
				//[CHM-201432648]Over weight 항목 개선 by 박진영D Start
				if(!formObj.flg_tri_axle.checked && !formObj.flg_permit.checked && !formObj.flg_others.checked){
					alert('At least one of three sub items of Over Weight should be selected.');
					return false;
				}
				else{
					if(formObj.flg_tri_axle.checked){
						if(formObj.gross_weight.value=='') {
							ComShowCodeMessage('COM12114','Gross Weight');
							formObj.gross_weight.focus();
							return false;
						}else if(!checkNumber(formObj.gross_weight,true)){
							return false;
						}
					}
					if(formObj.flg_others.checked){
						formObj.gross_weight_rmk.value = formObj.gross_weight_rmk.value.trim();
						if(formObj.gross_weight_rmk.value=='') {
							ComShowCodeMessage('COM12114','Others Remarks');
							formObj.gross_weight_rmk.focus();
							return false;
						}
					}
				}
				//[CHM-201432648]Over weight 항목 개선 by 박진영D End
			}
			if(formObj.SCPPAL_chk.checked){ 
				if(formObj.SCPPAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Pre-Pull');
					formObj.SCPPAL_txt.focus();
					return false;
				}else if(formObj.incurred_date.value=='') { 
					ComShowCodeMessage('COM12114','Incurred Date');
					formObj.incurred_date.focus();
					return false;
				}else if(!checkNumber(formObj.SCPPAL_txt,true)) return false;
			}
			if(formObj.SCRCAL_chk.checked){ 
				if(formObj.SCRCAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Redirection Charge');
					formObj.SCRCAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCRCAL_txt,true)) return false;
			}
			if(formObj.SCSSAL_chk.checked){ 
				if(formObj.SCSSAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Scale Stop');
					formObj.SCSSAL_txt.focus();
					return false;
				}else if(formObj.scale_loc.value.length != 0 && formObj.scale_loc.value.length != 5 ) { 
					ComShowCodeMessage('COM12114','Scale Stop Place');
					formObj.scale_loc.focus();
					return false;
				}else if(!checkNumber(formObj.SCSSAL_txt,true)) return false;
			}
			if(formObj.SCSRAL_chk.checked){ 
				if(formObj.SCSRAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Storage');
					formObj.SCSRAL_txt.focus();
					return false;
				}else if(formObj.days.value=='') { 
					ComShowCodeMessage('COM12114','Day');
					formObj.days.focus();
					return false;
				}else if(!checkNumber(formObj.SCSRAL_txt,true)) return false;
				else if(!checkNumber(formObj.days,true)) return false;
			}
			if(formObj.SCSTAL_chk.checked){ 
				if(formObj.SCSTAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Street Turn');
					formObj.SCSTAL_txt.focus();
					return false;
				}else if(formObj.outbound_booking_no.value=='') { 
					ComShowCodeMessage('COM12114','Outbound Booking No');
					formObj.outbound_booking_no.focus();
					return false;
				}else if(!checkNumber(formObj.SCSTAL_txt,true)) return false;
			}
			if(formObj.SCSNAL_chk.checked){ 
				if(formObj.SCSNAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Weekend / Holiday');
					formObj.SCSNAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCSNAL_txt,true)) return false;
			}
			if(formObj.SCSFAL_chk.checked){ 
				if(formObj.SCSFAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Swing / Flip');
					formObj.SCSFAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCSFAL_txt,true)) return false;
			}
			if(formObj.SCTDAL_chk.checked){ 
				if(formObj.SCTDAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','T-DOC Fee');
					formObj.SCTDAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCTDAL_txt,true)) return false;
			}
			if(formObj.SCTLAL_chk.checked){ 
				if(formObj.SCTLAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Toll Fee');
					formObj.SCTLAL_txt.focus();
					return false;
				}else if(!checkNumber(formObj.SCTLAL_txt,true)) return false;
			}
			if(formObj.SCWTAL_chk.checked){ 
				if(formObj.SCWTAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Waiting Charges');
					formObj.SCWTAL_txt.focus();
					return false;
				}else if(formObj.waiting_hour.value=='') { 
					ComShowCodeMessage('COM12114','Waiting Hour');
					formObj.waiting_hour.focus();
					return false;
				}else if(!checkNumber(formObj.SCWTAL_txt,true)) return false;
				else if(!checkNumber(formObj.waiting_hour,true)) return false;
			}
			if(formObj.SCOTAL_chk.checked){ 
				if(formObj.SCOTAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','Other Surcharge');
					formObj.SCOTAL_txt.focus();
					return false;
				}else if(formObj.remarks.value=='') { 
					ComShowCodeMessage('COM12114','Remarks');
					formObj.remarks.focus();
					return false;
				}else if(!checkNumber(formObj.SCOTAL_txt,true)) return false;
			}
			if(formObj.SCENAL_chk.checked){ 
				if(formObj.SCENAL_txt.value=='') { 
					ComShowCodeMessage('COM12114','ENSF');
					formObj.SCENAL_txt.focus();
					return false;
				}
				else if(!checkNumber(formObj.SCENAL_txt,true)) {
					return false;
				}
			}
		break;
	}
	return true;
}

/**
 * number check
 **/
function checkNumber(obj, delflag)
{
	var objName = obj.name.split('_')[0];
	var chars = "0123456789.-";
	if(!ComIsContainsCharsOnly(obj,chars))
	{
		ComShowCodeMessage('COM12122', eval(objName+'_01').innerText);
		if (delflag) obj.value = '';
		return false
	}
	return true;
}

/**
 * 각 항목의 값을  sheet에 적용
 **/
function putData(sheetObj, formObj)
{
	var checkObj = formObj.SCALAL_chk;

	if(checkObj.checked && Number(formObj.SCALAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCLWAL_chk;
	if(checkObj.checked && Number(formObj.SCLWAL_txt.value)!=0){ 
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCCDAL_chk;
	if(checkObj.checked && Number(formObj.SCCDAL_txt.value)!=0){ 
		var row = putDataCommon(sheetObj,checkObj);
		//sheetObj.CellValue2(row, prefix+invfix+'chss_mgst_tpsz_cd') = formObj.chasis_drayage_type_size.value; 
		sheetObj.CellValue2(row, prefix+invfix+'chss_no') = formObj.chss_no.value; 
		sheetObj.CellValue2(row, prefix+invfix+'incur_dt') = formObj.incur_dt.value; 
	}else{
		removeDataCommon(sheetObj,checkObj);
	}
	
	checkObj = formObj.SCDPAL_chk;
	if(checkObj.checked && Number(formObj.SCDPAL_txt.value)!=0){ 
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCDRAL_chk;
	if(checkObj.checked && Number(formObj.SCDRAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		if(formObj.reliable_party[0].checked)
		sheetObj.CellValue2(row, prefix+invfix+'dry_run_rlbl_pty_tp_cd') = formObj.reliable_party[0].value;
		else sheetObj.CellValue2(row, prefix+invfix+'dry_run_rlbl_pty_tp_cd') = formObj.reliable_party[1].value;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCFRAL_chk;
	if(checkObj.checked && Number(formObj.SCFRAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCFIAL_chk;
	if(checkObj.checked && Number(formObj.SCFIAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		sheetObj.CellValue2(row, prefix+invfix+'fne_cuz_desc') = formObj.cause.value;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCFGAL_chk;
	if(checkObj.checked && Number(formObj.SCFGAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		if(formObj.cost_rdo[0].checked){
			sheetObj.CellValue2(row, prefix+invfix+'fumg_cost_tp_cd') = formObj.cost_rdo[0].value;
		}else if(formObj.cost_rdo[1].checked){
			sheetObj.CellValue2(row, prefix+invfix+'fumg_cost_tp_cd') = formObj.cost_rdo[1].value;	
		}else{
			sheetObj.CellValue2(row, prefix+invfix+'fumg_cost_tp_cd') = formObj.cost_rdo[2].value;	
		} 
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCGNAL_chk;
	if(checkObj.checked && Number(formObj.SCGNAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		var chk_reefer_hd_val ="N"
	    var chk_reefer_gs_val ="N"
	    if(formObj.flg_reefer_hd.checked) chk_reefer_hd_val ="Y";
	    if(formObj.flg_reefer_gs.checked) chk_reefer_gs_val ="Y";			
		sheetObj.CellValue2(row, prefix+invfix+'mgst_tpsz_cd') = formObj.getset_tp_sz.value;
		sheetObj.CellValue2(row, prefix+invfix+'rf_hndl_flg') = chk_reefer_hd_val;
		sheetObj.CellValue2(row, prefix+invfix+'rf_mgst_usg_flg') = chk_reefer_gs_val;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCHZAL_chk;
	if(checkObj.checked && Number(formObj.SCHZAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCINAL_chk;
	if(checkObj.checked && Number(formObj.SCINAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		if(formObj.reefer_rdo[0].checked)
		sheetObj.CellValue2(row, prefix+invfix+'insp_rf_pti_cstms_tp_cd') = formObj.reefer_rdo[0].value;
		else sheetObj.CellValue2(row, prefix+invfix+'insp_rf_pti_cstms_tp_cd') = formObj.reefer_rdo[1].value;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCLFAL_chk;
	if(checkObj.checked && Number(formObj.SCLFAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		sheetObj.CellValue2(row, prefix+invfix+'lftg_knt') = formObj.number_lifting.value;
		sheetObj.CellValue2(row, prefix+invfix+'lftg_cuz_desc') = formObj.number_cause.value;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}
	
	checkObj = formObj.SCMDAL_chk;
	if(checkObj.checked && Number(formObj.SCMDAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		var nod = formObj.stop_loc.value;
		if(document.stop_yard.Code != undefined) nod+= document.stop_yard.Code;
		sheetObj.CellValue2(row, prefix+invfix+'stop_loc_nod_cd') = nod;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCOSAL_chk;
	if(checkObj.checked && Number(formObj.SCOSAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCOWAL_chk;
	if(checkObj.checked && Number(formObj.SCOWAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		var chk_tri_axl_val = "N";
		var chk_prmt_val = "N";
		var chk_otr_val = "N";
		
		if(formObj.flg_tri_axle.checked) chk_tri_axl_val = "Y";
		if(formObj.flg_permit.checked) chk_prmt_val = "Y";
		if(formObj.flg_others.checked) chk_otr_val = "Y";
		
		sheetObj.CellValue2(row, prefix+invfix+'grs_wgt') = formObj.gross_weight.value;
		sheetObj.CellValue2(row, prefix+invfix+'tri_axl_flg') = chk_tri_axl_val;
		sheetObj.CellValue2(row, prefix+invfix+'ovr_wgt_prmt_flg') = chk_prmt_val;
		sheetObj.CellValue2(row, prefix+invfix+'ovr_wgt_otr_flg') = chk_otr_val;
		sheetObj.CellValue2(row, prefix+invfix+'ovr_wgt_rmk') = formObj.gross_weight_rmk.value;
		
		//[CHM-201432964]Surcharge 항목 중 ENSF 활성화 요청(MT) by 박진영D 
		if(invfix == "inv_") {
			sheetObj.CellValue2(row, prefix+invfix+'inv_grs_wgt_meas_ut_cd') = formObj.weightUnit.value;
		}else{
			sheetObj.CellValue2(row, prefix+invfix+'wo_grs_wgt_meas_ut_cd') = formObj.weightUnit.value;
		}
		
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCPPAL_chk;
	if(checkObj.checked && Number(formObj.SCPPAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		sheetObj.CellValue2(row, prefix+invfix+'incrt_dt') = formObj.incurred_date.value;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCRCAL_chk;
	if(checkObj.checked && Number(formObj.SCRCAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCSSAL_chk;
	if(checkObj.checked && Number(formObj.SCSSAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		var nod = formObj.scale_loc.value;
		if(document.stop_yard.Code != undefined) nod+= document.scale_yard.Code;
		sheetObj.CellValue2(row, prefix+invfix+'scl_stop_plc_nod_cd') = nod;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCSRAL_chk;
	if(checkObj.checked && Number(formObj.SCSRAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		sheetObj.CellValue2(row, prefix+invfix+'sto_dys') = formObj.days.value;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCSTAL_chk;
	if(checkObj.checked && Number(formObj.SCSTAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		sheetObj.CellValue2(row, prefix+invfix+'ob_bkg_no') = formObj.outbound_booking_no.value;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCSNAL_chk;
	if(checkObj.checked && Number(formObj.SCSNAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCSFAL_chk;
	if(checkObj.checked && Number(formObj.SCSFAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCTDAL_chk;
	if(checkObj.checked && Number(formObj.SCTDAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCTLAL_chk;
	if(checkObj.checked && Number(formObj.SCTLAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCWTAL_chk;
	if(checkObj.checked && Number(formObj.SCWTAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		sheetObj.CellValue2(row, prefix+invfix+'wt_hrs') = formObj.waiting_hour.value;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}

	checkObj = formObj.SCOTAL_chk;
	if(checkObj.checked && Number(formObj.SCOTAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
		sheetObj.CellValue2(row, prefix+invfix+'otr_rmk') = formObj.remarks.value;
	}else{
		removeDataCommon(sheetObj,checkObj);
	}
	
	checkObj = formObj.SCENAL_chk;
	if(checkObj.checked && Number(formObj.SCENAL_txt.value)!=0){
		var row = putDataCommon(sheetObj,checkObj);
	}else{
		removeDataCommon(sheetObj,checkObj);
	}
}

/**
 * 공통 항목의 값을  sheet에 적용
 **/
function putDataCommon(sheetObj, chkObj)
{
	var objName = chkObj.name.split('_')[0];
	var txtObj = eval('document.form.'+objName+'_txt');
	var formObj = document.form;

	if(objName != 'SCCDAL'){
		objName = 'S'+formObj.cgo_tp_cd.value+objName.substring(2);
	}

	var row = sheetObj.FindText(prefix+'lgs_cost_cd', objName);
	
	if(row == -1){
		row = sheetObj.DataInsert(-1);
	}

	if(formObj.so_seq.value != undefined && formObj.so_seq.value != ''){
		sheetObj.CellValue2(row, prefix+'trsp_so_ofc_cty_cd') = formObj.ofc_cty_cd.value;
		sheetObj.CellValue2(row, prefix+'trsp_so_seq') = formObj.so_seq.value;
	}

	if(formObj.unique_cd.value != undefined && formObj.unique_cd.value != ''){
		sheetObj.CellValue2(row, prefix+'unique_cd') = formObj.unique_cd.value;
	}

	sheetObj.CellValue2(row, prefix+'lgs_cost_cd') = objName;
	sheetObj.CellValue2(row, prefix+'lgs_cost_full_nm') = getCodeName(objName);
	sheetObj.CellValue2(row, prefix+invfix+'scg_amt') = txtObj.value;

	return row;
}

/**
 * 존재하지 않는 data를  sheet에서 삭제
 **/
function removeDataCommon(sheetObj, chkObj)
{
	var formObj = document.form;
	var objName = chkObj.name.split('_')[0];
	objName = 'S'+formObj.cgo_tp_cd.value+objName.substring(2);
	var row = sheetObj.FindText(prefix+'lgs_cost_cd', objName);
	
	var un_invfix = null;
	if (invfix == 'inv_') un_invfix = '';
	else un_invfix = 'inv_';

	if(row != -1) {
		var scg_amt = sheetObj.CellValue(row, prefix+un_invfix+'scg_amt');

		if( (scg_amt == undefined || ComTrim(scg_amt) == '' || scg_amt == 0)){
			sheetObj.RowDelete(row, false);
		}else{
			if(formObj.so_seq.value != undefined && formObj.so_seq.value != ''){
				sheetObj.CellValue2(row, prefix+'trsp_so_ofc_cty_cd') = formObj.ofc_cty_cd.value;
				sheetObj.CellValue2(row, prefix+'trsp_so_seq') = formObj.so_seq.value;
			}

			if(formObj.unique_cd.value != undefined && formObj.unique_cd.value != ''){
				sheetObj.CellValue2(row, prefix+'unique_cd') = formObj.unique_cd.value;
			}
		}
	}
}

/**
 * CODE에 따른 CODE NAME을 반환해준다.
 * CODE NAME은 페이지 로딩시 가져온다.
 **/
function getCodeName(code_val){
	var sheetObj = sheetObjects[1];
	var index = sheetObj.FindText('lgs_cost_cd', code_val);

	return sheetObj.CellValue(index, 'lgs_cost_full_nm');
}

function checkIncurredDate(obj){
	var objLength = obj.value.length;
	if( objLength > 0 ){
		if(objLength != 8 ){
			
			ComShowCodeMessage('COM12114', 'date format : YYYYMMDD');
			obj.value = '';
			return;
		}else if (!checkDateFormat(obj.value))
		{
			ComShowCodeMessage('COM12114', 'date format : YYYYMMDD');
			obj.value = '';
			return;
		}
	}
}


//N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 
function checkTPBIf() {

	var formObj = document.form;
	var sheetObj = sheetObjects[2];

			formObj.f_cmd.value = SEARCH04;
			sheetObj.DoSearch4Post("ESD_TRS_0918GS.do", TrsFrmQryString(formObj));
//	var if_flg = sheetObj.CellValue(1, 'if_flg')
	var if_flg = sheetObj.EtcData('if_flg')
	if (if_flg=='Y'){
			ComShowMessage("This S/O was already interfaced to TPB and no more interface is available. \n\n Please have them manually processed, if necessary, in TPB " );
	}
 return if_flg;
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	var formObj = document.form;
	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'incurred_date':
				checkIncurredDate(obj);
				obj.focus();
			break;
		}
	}
}