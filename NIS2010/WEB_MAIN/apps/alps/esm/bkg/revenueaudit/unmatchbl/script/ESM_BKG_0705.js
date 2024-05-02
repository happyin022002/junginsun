/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0705.js
*@FileTitle : COD BKG Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview Audit by Hanger Installation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESM_BKG_0705:ESM_BKG_0705 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/**
 * @extends  
 * @class ESM_BKG_0705 : ESM_BKG_0705 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0705() {
	this.setSheetObject 		= setSheetObject;
	this.setComboObject         = setComboObject;	
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo              = initCombo;
	this.obj_click              = obj_click;
	this.obj_keypress           = obj_keypress;
	this.obj_deactivate         = obj_deactivate;
	this.processButtonClick		= processButtonClick;
	this.doActionIBSheet 		= doActionIBSheet;
}
    
//===================================================================================
//전역변수
//===================================================================================
//공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1;
var sheet2;

var comboObjects = new Array();
var comboCnt = 0;
//업무전역변수
var gCurrDate;
var gCurrFromDate;
var gCurrToDate;
var gXml = "";
var gBkgRhqCd;

//===================================================================================
//페이지 초기화
//===================================================================================
/** 
* IBSheet Object를 sheetObjects 배열로 등록 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj IBSheet Object
* @return 없음
* @see #
* @author 
* @version 
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
* IBMultiCombo Object를 comboObjects 배열에 등록 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBMultiCombo} combo_obj : IBMultiCombo Object
* @return 없음
* @see #
* @author 
* @version 
*/ 
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/** 
* body 태그의 onLoad 이벤트핸들러 구현 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 
* @version
*/ 
function loadPage() {
	
	var form = document.form;	
    sheet1 = sheetObjects[0];
    sheet2 = sheetObjects[1];
    sheetCnt = sheetObjects.length ;
    
    for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

    //IBMultiCombo 초기화
    comboCnt = comboObjects.length;
    for(var k=0;k<comboCnt;k++){
        initCombo(comboObjects[k],k+1);
    }
    
    //IBSheet 초기화
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
    }
    
    sheet1.WaitImageVisible = false;
    sheet1.CountPosition =0;
    sheet2.CountPosition =0;
	
    //html컨트롤 이벤트초기화    
	axon_event.addListenerForm('click', 'obj_click', form);	 
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');    	    	
    
    gBkgRhqCd = form.strRhq_ofc_cd.value;	
    initIBComboItem();    
    sheet1.WaitImageVisible = true;
    
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {

			var cnt = 0;
			InsertTab(cnt++, "COD Application", -1);
			InsertTab(cnt++, "Diversion C/A (by Merchant Request)", -1);

		}
		break;

	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;

}


/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	tabItem = nItem;
	
	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	
}

/**
 * IBMultiCombo 에 Item을 setting한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     initIBComboItem();
 * </pre>
 * @return 없음
 * @author 김대호
 * @version 2010.01.19
 */
function initIBComboItem() {
	ComBkgTextCode2ComboItem(rhqComboValue,        rhqComboValue,       getComboObject(comboObjects, 'rhq_cd'),  "|", "\t" );
	getComboObject(comboObjects, 'rhq_cd').Code2 = gBkgRhqCd; // 초기화시에는 이벤트 발생 안시킴. 초기화시 office 자동 셋팅함.(java와 맞춰준다.)
	ComBkgTextCode2ComboItem(officeComboValue,     officeComboValue,    getComboObject(comboObjects, 'bkg_ofc_cd'),  "|", "\t" );	
	getComboObject(comboObjects, 'bkg_ofc_cd').Code2 = form.strOfc_cd.value;
    ComBkgTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'), "|", "\t" );
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'), "|", "\t" );  
    ComBkgTextCode2ComboItem(codRqstRsnCdComboValue, codRqstRsnCdComboText, getComboObject(comboObjects, 'cod_rqst_rsn_cd'), "|", "\t" );
}

/** 
* Sheet 기본 설정 및 초기화 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {IBSheet} sheetObj : 시트오브젝트
* @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
* @return 없음
* @see #
* @author 
* @version 
*/ 
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	var sheetID = sheetObj.id;
   
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
		            //높이 설정
		            style.height = 370;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msPrevColumnMerge + msHeaderOnly;
		            //MergeSheet = msPrevColumnMerge + msHeaderOnly;
		            //MergeSheet = msAll;
		            //MergeSheet = msPrevColumnMerge;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(2, 1, 2, 100);
					var HeadTitle1 = "Seq.|RHQ|Office|Scope|B/L No.|BDR\nStatus|Appl. Date|POL ETD|C.Type|Contract No.|COD Reason|Self-Audit|RDN\nIssuance|RDN\nStatus|Remarks\n(Office)|Remarks\n(Auditor)|" 
									+"Route(Old)|Route(Old)|Route(Old)|Route(Old)|Route(New)|Route(New)|Route(New)|Route(New)|OFT|OFT|OFT|DVC|DVC|DVC|COD Application|COD Application|COD Application|COD Application|bkg_no|bl_cnt|cod_rqst_seq|"
					var HeadTitle2 = "Seq.|RHQ|Office|Scope|B/L No.|BDR\nStatus|Appl. Date|POL ETD|C.Type|Contract No.|COD Reason|Self-Audit|RDN\nIssuance|RDN\nStatus|Remarks\n(Office)|Remarks\n(Auditor)|" 
						        	+"POR|POL|POD|DEL|POR|POL|POD|DEL|Per|Cur.|Amt|Per|Cur.|Amt|Charge|Per|Cur.|Amt|bkg_no|bl_cnt|cod_rqst_seq|";
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            InitHeadRow(1, HeadTitle2, true);

					//데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX		            
					InitDataProperty(0 ,cnt++, dtData,      40,    daCenter ,   true,   "seq",              false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      50,    daCenter,    true,   "rhq_cd",           false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      50,    daCenter,    true,   "bkg_ofc_cd",       false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      45,    daCenter,    true,   "svc_scp_cd",       false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtPopup,     120,   daCenter,    true,   "bl_no",            false,    "",      dfNone,      0,    true,     true);
					InitDataProperty(0, cnt++, dtData,	    60,	   daCenter,    true,	"bdr_flg",	        false,	  "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      75,    daCenter,    true,   "rt_aply_dt",       false,    "",      dfDateYmd,   0,    false,    false);
					InitDataProperty(0, cnt++, dtData,	    80,	   daCenter,    true,	"vps_etd_dt",	    false,	  "",      dfDateYmd,   0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      75,    daCenter,    true,   "bkg_ctrt_tp_cd",   false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtPopup,     100,   daCenter,    true,   "ctrt_no",          false,    "",      dfNone,      0,    true,     true);
					InitDataProperty(0, cnt++, dtPopup,	    150,   daCenter,    true,	"cod_rqst_rsn_cd",	false,	  "",      dfNone,      0,	  true,		true);
					InitDataProperty(0, cnt++, dtPopup,	    70,	   daCenter,    true,	"self_audit",	    false,	  "",      dfNone,      0,	  true,	    true);
					InitDataProperty(0, cnt++, dtPopup,     90,    daCenter,    true,   "rdn_no",           false,    "",      dfNone,      0,    true,     true);
					InitDataProperty(0, cnt++, dtData,	    80,	   daCenter,    true,	"rdn_sts_nm",	    false,	  "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,		200,   daLeft,		true,	"umch_rsn_rmk",	  	false,	  "",      dfNone,	    0,	  true,		true );
					InitDataProperty(0, cnt++, dtData,		200,   daLeft,		true,	"rgn_grp_avc_rmk",	false,	  "",      dfNone,	    0,	  true,		true );
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "old_por_yd_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "old_pol_yd_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "old_pod_yd_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "old_del_yd_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "new_por_yd_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "new_pol_yd_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "new_pod_yd_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "new_del_yd_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      40,    daCenter,    true,   "oft_rat_ut_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      40,    daCenter,    true,   "oft_curr_cd",      false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "oft_amt",          false,    "",      dfNullFloat, 2,    false,    false);
					InitDataProperty(0, cnt++, dtData,      40,    daCenter,    true,   "dvc_rat_ut_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      40,    daCenter,    true,   "dvc_curr_cd",      false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "dvc_amt",          false,    "",      dfNullFloat, 2,    false,    false);
					InitDataProperty(0, cnt++, dtData,      50,    daCenter,    true,   "cod_chg_cd",		false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      40,    daCenter,    true,   "cod_rat_ut_cd",    false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      40,    daCenter,    true,   "cod_curr_cd",      false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "cod_amt",          false,    "",      dfNullFloat, 2,    false,    false);
					InitDataProperty(0, cnt++, dtHidden,    50,    daCenter,    true,   "bkg_no",           false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtHidden,    50,    daCenter,    true,   "bl_cnt",           false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtHidden,    50,    daCenter,    true,   "cod_rqst_seq",     false,    "",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtHiddenStatus,30,  daCenter, 	true,	"ibflag");
					
                    ShowButtonImage = 2;
                    UnEditableColor = RgbColor(255,255,255);                    
                    FrozenCols = 5;

	      	}
	      	break;
		case "sheet2":
	      	with (sheet2) {
            //높이 설정
            style.height = 370;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;
            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge + msHeaderOnly;
            //MergeSheet = msPrevColumnMerge + msHeaderOnly;
            //MergeSheet = msAll;
            //MergeSheet = msPrevColumnMerge;
            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 2, 100);
			var HeadTitle1 = "Seq.|RHQ|Office|Scope|B/L No.|BDR\nStatus|Appl. Date|POL ETD|Contract|Contract|new_corr_no|old_corr_no|" 
							+"Route(Old)|Route(Old)|Route(Old)|Route(Old)|Route(Old)|Route(New)|Route(New)|Route(New)|Route(New)|DVC|DVC|DVC|DVC|DVC|bkg_no|bl_cnt|"
			var HeadTitle2 = "Seq.|RHQ|Office|Scope|B/L No.|BDR\nStatus|Appl. Date|POL ETD|Type|Number|new_corr_no|old_corr_no|" 
				        	+"Seq.|POR|POL|POD|DEL|POR|POL|POD|DEL|Cur.|Rate|Rated As|Per|Amount|bkg_no|bl_cnt|";
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
            //해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false);
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

			//데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX		            
			InitDataProperty(0 ,cnt++, dtData,      40,    daCenter ,   true,   "seq",              false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      50,    daCenter,    true,   "rhq_cd",           false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      50,    daCenter,    true,   "bkg_ofc_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      45,    daCenter,    true,   "svc_scp_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtPopup,     120,   daCenter,    true,   "bl_no",            false,    "",      dfNone,      0,    true,     true);
			InitDataProperty(0, cnt++, dtData,	    60,	   daCenter,    true,	"bdr_flg",	        false,	  "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      75,    daCenter,    true,   "rt_aply_dt",       false,    "",      dfDateYmd,   0,    false,    false);
			InitDataProperty(0, cnt++, dtData,	    80,	   daCenter,    true,	"vps_etd_dt",	    false,	  "",      dfDateYmd,   0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      50,    daCenter,    true,   "bkg_ctrt_tp_cd",   false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtPopup,     100,   daCenter,    true,   "ctrt_no",          false,    "",      dfNone,      0,    true,     true);
			InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,    true,   "new_corr_no",      false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,    true,   "old_corr_no",      false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0 ,cnt++, dtData,      40,    daCenter ,   true,   "ca_seq",           false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "old_por_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "old_pol_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "old_pod_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "old_del_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "new_por_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "new_pol_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "new_pod_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      70,    daCenter,    true,   "new_del_cd",       false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      40,    daCenter,    true,   "dvc_curr_cd",      false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      80,    daRight,     true,   "dvc_chg_ut_amt",   false,    "",      dfNullFloat, 2,    false,    false);
			InitDataProperty(0, cnt++, dtData,      60,    daRight,     true,   "dvc_rat_as_qty",   false,    "",      dfNullFloat, 2,    false,    false);
			InitDataProperty(0, cnt++, dtData,      40,    daCenter,    true,   "dvc_rat_ut_cd",    false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,      80,    daRight,     true,   "dvc_chg_amt",      false,    "",      dfNullFloat, 2,    false,    false);
			InitDataProperty(0, cnt++, dtHidden,    50,    daCenter,    true,   "bkg_no",           false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtHidden,    50,    daCenter,    true,   "bl_cnt",           false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtHiddenStatus,30,  daCenter, 	true,	"ibflag");
			
            ShowButtonImage = 2;
            UnEditableColor = RgbColor(255,255,255);                    
            FrozenCols = 5;

  	}
			break;
	      	
	}
}

/** 
* IBMultiCombo 기본 설정 및 초기화 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
* 콤보가 다수일 경우 시트 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {IBMultiCombo} comboObj : 시트오브젝트
* @param {int} comboNo : 콤보오브젝트 태그의 아이디에 붙인 일련번호  
* @return 없음
* @see #
* @author 
* @version 
*/ 
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
		// RHQ
		case "rhq_cd":
			var i = 0;
			with (comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 5;      // 3자리만 입력
			}
			break;
		// office
		case "bkg_ofc_cd":
			var i = 0;
			with (comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력				
			}
			break;
		// scope
		case "svc_scp_cd":
			var i = 0;
			with (comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 3;      // 3자리만 입력
			}
			break;
		// Contract type
        case "bkg_ctrt_tp_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
				UseAutoComplete = true;
            	ValidChar(2, 2);    // 영문대문자만 입력 + 특수문자
            }
            break;
		// Contract type
        case "cod_rqst_rsn_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
				UseAutoComplete = true;
            	ValidChar(2, 0);    // 영문대문자만 입력 + 특수문자
            }
            break;    

	}
}      

//===================================================================================
//버튼 이벤트 처리
//===================================================================================
document.onclick = processButtonClick;

/** 
* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 
* @version 
*/ 
function processButtonClick(){
	var form = document.form;
	var rdoDateObj = form.rdoDate;
    try {
	    var srcName = window.event.srcElement.getAttribute("name");
	    switch(srcName) {
	        case "btns_calendar1": //달력버튼
	        	var cal = new ComCalendar();
	        	cal.select(form.fm_dt, 'yyyy-MM-dd');
	        	break;
	        
	        case "btns_calendar2":
		        var cal = new ComCalendar();
		        cal.select(form.to_dt, 'yyyy-MM-dd');
		        break;
	        
			case "btn_com_ens_ob2":
				var param = "";
	    		//param = param + "lane_cd=" + ComGetObjValue(form.vsl_slan_cd);
				//param = "loc_cd="+ComGetObjValue(form.pol_cd);
	    		//param = param + "&" + "pod_cd="+ComGetObjValue(form.pod_cd);
	    		param = param + "&" + "vvd_cd=" + form.vvd.value;
	    		//param = param + "&" + "etd_cd="+form.etd_cd.value;
	    		ComOpenPopup('/hanjin/COM_ENS_0B2.do?' + param, 780, 470, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
				break;
				
	    	case "btn_retrieve":
	    		if (validateForm(sheet1, form, IBSEARCH)) {
	    			ComOpenWait(true);	    			
	    			
	    			if (tabObjects[0].SelectedIndex == 0){
	    				sheet1.WaitImageVisible = false;
	    				doActionIBSheet(sheet1, form, IBSEARCH);
	    			} else {
	    				sheet2.WaitImageVisible = false;
		    			doActionIBSheet(sheet2, form, IBSEARCH_ASYNC01);
	    			}
	    			
	    			ComOpenWait(false);	    			
	    		}
	    		break;
	    		
	    	case "btn_new":
	    		//form.reset();
	    		ComResetAll();
	    		setNew();
	    		break;
	    		
	    	case "btn_downexcel":
	    		if (tabObjects[0].SelectedIndex == 0){
	    			doActionIBSheet(sheet1, form, IBDOWNEXCEL);
	    		} else {
	    			doActionIBSheet(sheet2, form, IBDOWNEXCEL);
	    		}
	    		break;
	    	case "btn_save":
				doActionIBSheet(sheet1,form,IBSAVE);
				break;

	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
 		}
 	}
}

//===================================================================================
//Axson Event Handler
//===================================================================================
/** 
* Object 의 Keypress 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 
* @version 
*/ 
function obj_keypress(){
	var obj = event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus = obj.dataformat;
	switch(obj.dataformat){
 	case "ymd": //날짜 입력하기
		ComKeyOnlyNumber(obj,"-"); 
		break;
 	case "int": //숫자만 입력
 	case "number": //숫자만 입력 	
 		ComKeyOnlyNumber(obj);
 		break;
 	case "engup":
 		ComKeyOnlyAlphabet('upper');
 		break;
 	case "uppernum":
 		ComKeyOnlyAlphabet('uppernum');
 		break;
 	default:
 		//ComKeyOnlyNumber(obj);
 		break;
	}
}

/**
* Object 의 Onclick 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 
* @version 
*/
function obj_click(){
	var form = document.form;
	var obj = event.srcElement;
	switch(obj.name){
	 	case "rdo_date":
	 		form.search_date.value = obj.value;
	 		break;	 		
	 		
	 	case "bill_type_all":
	 		var tf = false;
	 		if(obj.checked) {
	 			tf = true;
	 		}
	 		setBillTypeCheckBox(tf);
	 		break;
	}
 	//if(obj.dataformat == null) return;
}

/**
 * OnClick 이벤트 발생시 호출되는 function <br>
 * 주소입력시 메모장을 화면에 표시한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
 * @return 없음
 * @author 
 * @version 
 */  	           
 function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	    var colname = sheetObj.ColSaveName(Col);  	 
 	switch(colname){
//	    	case "umch_rsn_rmk":
//	    		ComShowMemoPad(sheetObj,Row,Col,false,200,200); 
//	    		break;
//	    	case "rgn_grp_avc_rmk":
//	    		ComShowMemoPad(sheetObj,Row,Col,false,200,200);
//	    		break;
 	}    	 


 }

/**
* OnBeforeActivate event를 처리한다. <br>
* <br><b>Example :</b>
* <pre>
*     obj_activate()
* </pre>
* @param 없음
* @return 없음
* @see #
* @author 
* @version 
*/      
function obj_activate() {
    ComClearSeparator (event.srcElement);
}

/** 
* Object 의 Onbeforedeactivate 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다. <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 
* @version 
*/ 
function obj_deactivate() {
	var form = document.form;
	var formObj = event.srcElement;
    var srcName = formObj.getAttribute("name");
    switch(srcName) {
		default :
			ComChkObjValid(formObj);
	}

}

//===================================================================================
//UI Object Event Handler
//===================================================================================


 /** 
  * sheet1 팝업연결 선택시 발생하는 sheet1_OnPopupClick 이벤트핸들러 <br>
  * <br><b>Example :</b>
  * <pre>
  * </pre>
  * @param  {IBSheet} sheetObj : 시트오브젝트  
  * @param  {Long} Row : 해당 셀의 Row Index
  * @param  {Long} Col : 해당 셀의 Column Index
  * @return  
  * @see #
  * @author                                                                            
  * @version                                                     
  */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
 	var form = document.form;
 	var colName = sheet1.ColSaveName(Col);
	var sName      = sheet1.ColSaveName(Col);
	var scRfaNo    = sheet1.CellValue(Row, "ctrt_no");	
	var ctrtTpCd   = sheet1.CellValue(Row, "bkg_ctrt_tp_cd");	
	var bkgNo 	   = sheet1.CellValue(Row, "bkg_no");   		
	var blNo 	   = sheet1.CellValue(Row, "bl_no");   			
	var rdnNo      = sheet1.CellValue(Row, "rdn_no");
	var rctRhqCd   = sheet1.CellValue(Row, "rhq_cd");
	var rctOfcCd   = sheet1.CellValue(Row, "bkg_ofc_cd"); 	
	var codRqstSeq = sheet1.CellValue(Row, "cod_rqst_seq");
 	switch(colName){
		case "bl_no":
			if(null == bkgNo || "" == bkgNo) { return; }
        	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
	    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_0705", popParams, "");
			break;
 	
		case "ctrt_no":
        	if(null == scRfaNo || "" == scRfaNo) { return; }
    		var pgmNo = "ESM_PRI_0004";
    		var scRfaNoP = scRfaNo.substr(0, 3);
    		var scRfaNoS = scRfaNo.substr(3);
        	var popParams = "sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS + "&eff_dt=" + form.fm_dt.value + "&exp_dt=" + form.to_dt.value;
	    	if(ctrtTpCd == "RFA") { // RFA
	    		pgmNo = "ESM_PRI_2019";
	    		popParams = "s_rfa_no=" + scRfaNo;
	    	}
	    	else if(ctrtTpCd == "TAA") { // TAA
	    		pgmNo = "ESM_PRI_3007";
	    		popParams = "cond_taa_no=" + scRfaNo;  
	    	}
        	comRASCallPop(pgmNo, "ESM_BKG_0705", popParams, "");
			break;
			
		case "rdn_no":
			//rdnNo = "RDN090086";
		    //B/L No ( <- B/L No ), Receipt RHQ ( <- RHQ ), Receipt Office( <- Office ), Responsible RHQ ( <- RHQ ), Responsible Office ( <- Office ) 항목 복사해 줌
			var popParams = "rdn_no=" + rdnNo + "&bl_no=" + blNo + "&rct_rhq_cd=" + rctRhqCd + "&rct_ofc_cd=" + rctOfcCd;
    		comRASCallPop("ESM_BKG_0426", "ESM_BKG_0705", popParams, "");
			break;
			
		case "self_audit":
			var _Width = '1000';
			var _Height = '728';
			var pgmNo = "&pgmNo=ESM_BKG_0263";
			var popParams = "bl_no="+blNo+"&ca_flg=N"; 
			var url = "ESM_BKG_0263.do?" + popParams + pgmNo;
			ComOpenPopupWithTarget(url, _Width, _Height, "","none",false);
			break;
		case "cod_rqst_rsn_cd":
			var param="?mainPage=false&bkg_no="+bkgNo;
			param+="&cod_rqst_seq="+codRqstSeq;
			param+="&popFlg=S";
			param+="&pgmNo=ESM_BKG_0156_Q";
	 		ComOpenWindowCenter("/hanjin/ESM_BKG_0156_P.do"+param, "ESM_BKG_0156", 1024, 730, true, "yes");
			break;
	 	}
 } 	 

/** 
 * sheet2 팝업연결 선택시 발생하는 sheet2_OnPopupClick 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {IBSheet} sheetObj : 시트오브젝트  
 * @param  {Long} Row : 해당 셀의 Row Index
 * @param  {Long} Col : 해당 셀의 Column Index
 * @return  
 * @see #
 * @author                                                                            
 * @version                                                     
 */
function sheet2_OnPopupClick(sheetObj, Row, Col) {
	var form = document.form;
	var colName = sheetObj.ColSaveName(Col);
	var sName      = sheetObj.ColSaveName(Col);
	var scRfaNo    = sheetObj.CellValue(Row, "ctrt_no");	
	var ctrtTpCd   = sheetObj.CellValue(Row, "bkg_ctrt_tp_cd");	
	var bkgNo 	   = sheetObj.CellValue(Row, "bkg_no");   	
	switch(colName){
		case "bl_no":
			if(null == bkgNo || "" == bkgNo) { return; }
       	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
	    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_0705", popParams, "");
			break;
	
		case "ctrt_no":
       	if(null == scRfaNo || "" == scRfaNo) { return; }
   		var pgmNo = "ESM_PRI_0004";
   		var scRfaNoP = scRfaNo.substr(0, 3);
   		var scRfaNoS = scRfaNo.substr(3);
       	var popParams = "sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS + "&eff_dt=" + form.fm_dt.value + "&exp_dt=" + form.to_dt.value;
	    	if(ctrtTpCd == "RFA") { // RFA
	    		pgmNo = "ESM_PRI_2019";
	    		popParams = "s_rfa_no=" + scRfaNo;
	    	}
	    	else if(ctrtTpCd == "TAA") { // TAA
	    		pgmNo = "ESM_PRI_3007";
	    		popParams = "cond_taa_no=" + scRfaNo;  
	    	}
       	comRASCallPop(pgmNo, "ESM_BKG_0705", popParams, "");
			break;
	 	}
} 	      
 
/** 
* RHQ 콤보 변경시 호출하는 rhq_cd_OnChange <br>
* Office 콤보를 셋팅해준다. <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBMultiCombo} rhqObj : 콤보오브젝트  
* @param  {String} Code : 콤보코드값
* @param  {String} Text : 콤보에 보여지는 텍스트
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function rhq_cd_OnChange(rhqObj, Code, Text) {
	var form = document.form;
	//var idx = rhqObj.Index;
	var officeObj = form.bkg_ofc_cd;
	officeObj.RemoveAll();
	if(null == Code || "" == Code) {
		officeObj.InsertItem(0, "", "");
	}else{
		var params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
		var sXml = sheet1.GetSearchXml("RASCommonGS.do?", params);
		ComXml2ComboItem(sXml, officeObj, "cd", "cd");
		officeObj.InsertItem(0, "", "");
		officeObj.Code = form.strOfc_cd.value;
	}
}

/** 
* 화면 폼입력값에 초기화 하는 setNew <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function setNew() {
	var form = document.form;
	var rhqObj = form.rhq_cd;
	var officeObj = form.bkg_ofc_cd;
    var ctrtTpCd = form.bkg_ctrt_tp_cd;
    officeObj.RemoveAll();
    rhqObj.Index = "-1";
   	rhqObj.Code = gBkgRhqCd;
    ctrtTpCd.BackColor = "#FFFFFF";
   	sheet1.RemoveAll();
}

//===================================================================================
//서버 조회/저장
//===================================================================================
/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	   
	sheet1.ShowDebugMsg = false;
         
	switch(sAction) {
        case IBSEARCH: //조회
        	formObj.f_cmd.value = SEARCH;
 			sheet1.DoSearch("ESM_BKG_0705GS.do", FormQueryString(formObj));
        
 			break;
 			
        case IBSEARCH_ASYNC01: //조회
        	formObj.f_cmd.value = SEARCH02;
        	sheetObj.DoSearch("ESM_BKG_0705GS.do", FormQueryString(formObj));
		 			
	 		break;
 			
		case IBDOWNEXCEL:      //download excel
			sheetObj.SpeedDown2Excel(-1); //, "chk|seq"
			//sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
			break;
		case IBSAVE:		//저장
		
		   if (!ComShowCodeConfirm("BKG95003", "save Remarks")) { return false; }
		
		   formObj.f_cmd.value = MULTI01;
		
	       var sParam = FormQueryString(formObj);
	       var sParamSheet1 = sheet1.GetSaveString();
	       	       
	       
	       if (!sheet1.IsDataModified && sParamSheet1 == ""){
	    	   ComShowCodeMessage("BKG08246");
	    	   return;
	       }

	
	       sParam += "&" + sParamSheet1;
		
	       ComOpenWait(true);
	
	       var sXml = sheet1.GetSaveXml("ESM_BKG_0705GS.do", sParam);
	
	       sheet1.LoadSaveXml(sXml);


	       ComOpenWait(false);        		

	       if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
	    	   ComShowCodeMessage("BKG95033"); // "Saved."
	       }
	
	       break;
 			
	}
}

/** 
* 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 chkDate <br>
* Application 날짜 Validation을 체크한다. <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {object} formObj : 폼 오브젝트
* @return {boolean}
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function chkDate(formObj) {
	
	var form = document.form;
		
    var fmDtObj   = form.fm_dt;
    var toDtObj   = form.to_dt;
	var fmDtValue = fmDtObj.value.replace(/-/g,'');
	var toDtValue = toDtObj.value.replace(/-/g,'');
	
	if(fmDtValue != "" && toDtValue != "") {

		if( parseInt(fmDtValue,10) > parseInt(toDtValue,10) ) {
			ComShowCodeMessage("BKG95026", "From Date", "To Date");
			event.returnValue = false;			
			ComSetFocus(formObj);
			return false;
		}
		var fromAddDays = ComGetDateAdd(fmDtValue, "D", 99, "", true); // 100 일
		if( parseInt(toDtValue,10) > parseInt(fromAddDays,10) ) {
			ComShowCodeMessage("BKG95027", "100 days"); // "The period of Date can't be over {?msg1}."
			event.returnValue = false;		
			ComSetFocus(formObj);
			return false;
		}
		
	}
	
	return true;
}

/** 
* 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function validateForm(sheetObj, formObj, sAction){
	
	var form = document.form;
	
	var rhq       = form.rhq_cd; 
	var fmDtObj   = form.fm_dt;	
	var toDtObj   = form.to_dt;
	var fmDtValue = fmDtObj.value;	
	var toDtValue = toDtObj.value;
	
    switch (sAction) {
	    
    	case IBSEARCH: //조회
    	
    		if(null == rhq.Code || "" == rhq.Code){
				ComShowCodeMessage("BKG95031", "RHQ");
				event.returnValue = false;
				ComSetFocus(rhq);
				return false;	
    		}
    	
			if(!ComChkObjValid(fmDtObj)) { return false; }
			if(!ComChkObjValid(toDtObj)) { return false; }
	
			if("" == fmDtValue || "" == toDtValue) {
				 ComShowCodeMessage("BKG95025", "Date"); // "Please input {?msg1}."
				 if("" == fmDtObj.value) {
					 ComSetFocus(fmDtObj);
				 }else{
					 ComSetFocus(toDtObj);
				 }
				 return false;
			}
    	
			if(!chkDate(fmDtObj)) {  return false; }
			if(!chkDate(toDtObj)) { return false; }
			
			if(!chkDate(fmDtObj)) {  return false; }
			if(!chkDate(toDtObj)) { return false; }

			break;
			
    }

    return true;
    
}    
/** 
* sheet2 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 류선우
* @version 2010.04.29
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
    var form = document.form;
    if(sheetObj.RowCount > 0){
    	form.bl_cnt.value = sheetObj.CellValue(2,"bl_cnt");
    }else{
    	    	form.bl_cnt.value = "0";
    }
    
}
/** 
* sheet2 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 류선우
* @version 2010.04.29
*/ 
function sheet2_OnSearchEnd(sheetObj, errMsg) {
    var form = document.form;
    if(sheetObj.RowCount > 0){
    	form.bkg_cnt.value = sheetObj.CellValue(2,"bl_cnt");
    }else{
    	    	form.bkg_cnt.value = "0";
    }
    
}