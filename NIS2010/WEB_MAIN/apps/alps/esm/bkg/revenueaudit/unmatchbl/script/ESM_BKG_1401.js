/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1401.js
*@FileTitle : Audit by CNTR Qty Discrepancy
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.19 김대호
* 1.0 Creation
* 2013.04.24 김진주 [CHM-201324159] [BKG/DOC - Revenue Audit Systme] 수입심사 시스템 보완 요청 (김진주 수석님)
=========================================================*/
/**
 * @fileoverview Audit by CNTR Qty Discrepancy 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESM_BKG_1401:ESM_BKG_1401 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/**
 * @extends  
 * @class ESM_BKG_1401 : ESM_BKG_1401 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1401() {
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
var gCtrtTpCdDefault = "S";

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
* @author 김대호
* @version 2010.01.19
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
* @author 김대호
* @version 2010.01.19
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
* @author 김대호
* @version 2010.01.19
*/ 
function loadPage() {
	
	var form = document.form;	
    sheet1 = sheetObjects[0];
    sheet2 = sheetObjects[1];
    sheetCnt = sheetObjects.length ;
    

    for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
    //IBSheet 초기화
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
    }

    //IBMultiCombo 초기화
    comboCnt = comboObjects.length;
    for(var k=0;k<comboCnt;k++){
        initCombo(comboObjects[k],k+1);
    }
    
    sheet1.WaitImageVisible = false;
    sheet1.CountPosition =0;
	
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
			InsertTab(cnt++, "BKG Rating vs AK Application", -1);
			InsertTab(cnt++, "AK Application vs Bay Plan", -1);

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
* sheet1_OnLoadFinish 이벤트핸들러 구현 <br>
* IBSheet를 초기화 한후에 선처리해야 하는 기능을 추가한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/
/*
function sheet1_OnLoadFinish(sheetObj) {
	var form = document.form;	

}
*/

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
	ComBkgTextCode2ComboItem(rhqComboValue,        rhqComboValue,       getComboObject(comboObjects, 'bkg_rhq_cd'),  "|", "\t" );
	getComboObject(comboObjects, 'bkg_rhq_cd').Code2 = gBkgRhqCd; // 초기화시에는 이벤트 발생 안시킴. 초기화시 office 자동 셋팅함.(java와 맞춰준다.)
	ComBkgTextCode2ComboItem(officeComboValue,     officeComboValue,    getComboObject(comboObjects, 'bkg_ofc_cd'),  "|", "\t" );	
	getComboObject(comboObjects, 'bkg_ofc_cd').Code2 = form.strOfc_cd.value;
    ComBkgTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'), "|", "\t" );
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'), "|", "\t" ); 
	getComboObject(comboObjects, 'bkg_ctrt_tp_cd').Code2 = gCtrtTpCdDefault;
	
	
	document.form.bdr_flg.InsertItem(0,'','');
	document.form.bdr_flg.InsertItem(1,'Yes','Y');
	document.form.bdr_flg.InsertItem(2,'No','N');
	
	ComBkgTextCode2ComboItem(chargeFlgComboValue,  chargeFlgComboText,  getComboObject(comboObjects, 'charge_flg'),  	"|", "\t" );

    ComBkgTextCode2ComboItem(cntrTpszComboValue,		cntrTpszComboText,	getComboObject(comboObjects, 'cntr_tpsz_cd'),  	"|", "\t" );
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
* @author 김대호
* @version 2010.01.19
*/ 
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	var sheetID = sheetObj.id;
   
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
	            //높이 설정
	            style.height = 390;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	           
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	            
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	           
	           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(2, 1, 2, 100);
	            var HeadTitle1 = "|RHQ|Office|B/L No.|BKG Date|Appl. Date|POL ETD|T/VVD|Contract\nType|Contract No.|Commodity|Commodity|Scope|POR|POL|POD|DEL|TERM|TERM|" +
	            		"Shipper|Consignee|Notify|Contract Customer|BDR\nStatus|Split\nStatus|Charge\nStatus|Bill\nType|RDN\nIssuance|RDN\nStatus|" +
	            		"Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|BKG Volume|BKG Volume|AK Application|AK Application|AK Application|Bay\nPlan|bl_cnt";
	            var HeadTitle2 = "|RHQ|Office|B/L No.|BKG Date|Appl. Date|POL ETD|T/VVD|Contract\nType|Contract No.|Code|Name|Scope|POR|POL|POD|DEL|R|D|" +
	            		"Shipper|Consignee|Notify|Contract Customer|BDR\nStatus|Split\nStatus|Charge\nStatus|Bill\nType|RDN\nIssuance|RDN\nStatus|" +
	            		"Charge|Curr|Rate|RatedAs|Per|Amount|Term|M|TP/SZ|Qty|TP/SZ|Qty|Void(FEU)|Bay\nPlan|bl_cnt";
	           
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	            
	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false);
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);
	            
	            

				//데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX		            
				
				
				//InitDataProperty(0, cnt++ , dtDummyCheck,	40,	daCenter,	false,	"chk",					false,	"",  dfNone,	0,	true     ,true );
	            InitDataProperty(0, cnt++, dtHiddenStatus,	30,	   daCenter, 	true,	"ibflag");
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "bkg_rhq_cd",        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "bkg_ofc_cd",        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtPopup,			120,   daCenter,    true,   "bkg_no",            false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			75,    daCenter,    true,   "bkg_cre_dt",        false,    "",      dfDateYmd,   0,    false,    false);
				
				InitDataProperty(0, cnt++, dtData,			75,    daCenter,    true,   "rt_aply_dt",        false,    "",      dfDateYmd,   0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			80,	   daCenter,    true,	"pol_etd",	         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			75,    daCenter,    true,   "t_vvd",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "bkg_ctrt_tp_cd",    false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtPopup,			100,   daCenter,    true,   "ctrt_no",           false,    "",      dfNone,      0,    true,     true);
				
				InitDataProperty(0, cnt++, dtData,			45,    daCenter,    true,   "cmdt_cd",           false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			90,    daLeft,      true,   "cmdt_nm",           false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			45,    daCenter,    true,   "svc_scp_cd",        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "por_cd",            false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "pol_cd",            false,    "",      dfNone,      0,    true,     true);
				
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "pod_cd",            false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "del_cd",            false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			30,    daCenter,    true,   "rcv_term_cd",       false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			30,    daCenter,    true,   "de_term_cd",        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			130,   daLeft,      true,   "shpr_nm",           false,    "",      dfNone,      0,    true,     true);
				
				InitDataProperty(0, cnt++, dtData,			130,   daLeft,      true,   "cnee_nm",           false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			130,   daLeft,      true,   "fwdr_nm",           false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			130,   daLeft,      true,   "ctrt_cust_nm",      false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			60,	   daCenter,    true,	"bdr_flg",	         false,	   "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			70,	   daCenter,    true,	"split_flg",	     false,	   "",      dfNone,      0,	   false,	 false);
				
				InitDataProperty(0, cnt++, dtData,			70,	   daCenter,    true,	"charge_flg",	     false,	   "",      dfNone,      0,	   false,	 false);
				InitDataProperty(0, cnt++, dtData,			80,	   daCenter,    true,	"rt_bl_tp_cd",	     false,	   "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtPopup,			120,   daCenter,    true,   "rdn_no",            false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			80,	   daCenter,    true,	"rdn_sts_nm",	     false,	   "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "chg_cd",            false,    "",      dfNone,      0,    false,    false);
				
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "curr_cd",           false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "chg_ut_amt",        false,    "",      dfNullFloat, 2,    false,    false);
				InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "rat_as_qty",        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			35,    daCenter,    true,   "rat_ut_cd",         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "chg_amt",           false,    "",      dfNullFloat, 2,    false,    false);
				
				InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"frt_term_cd",	     false,	   "",      dfNone,      0,	   false,	 false);
				InitDataProperty(0, cnt++, dtData,			35,	   daCenter,    true,	"auto_rat_cd",	     false,	   "",      dfNone,      0,	   false,	 false);
				InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"cntr_tpsz_cd",	     false,	   "",      dfNone,      0,	   false,	 false);
				InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"op_cntr_qty",	     false,	   "",      dfNone,      0,	   false,	 false);
				InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"ak_cntr_tpsz_cd",	 false,	   "",      dfNone,      0,	   false,	 false);
				
				InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"ak_cntr_qty",	     false,    "",      dfNone,      0,	   false,	 false);
				InitDataProperty(0, cnt++, dtData,			60,	   daCenter,    true,	"void_slt_qty",	     false,	   "",      dfNone,      0,	   false,	 false);
				InitDataProperty(0, cnt++, dtPopup,			20,	   daCenter,    true,	"bay_plan",	         false,	   "",      dfNone,      0,	   true,	 true);
				InitDataProperty(0, cnt++, dtHidden,		40,	   daCenter,    true,	"bl_cnt",	         false,	   "",      dfNone,      0,	   false,	 false);
				
				

                ShowButtonImage = 2;
                UnEditableColor = RgbColor(255,255,255);
                FrozenCols = 4;

	      	}
	      	break;
	      	
		case "sheet2":
			with (sheet2) {
            //높이 설정
            style.height = 390;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;
           
            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            
            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;
            
            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
           
           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 2, 100);
            var HeadTitle1 = "|RHQ|Office|B/L No.|Contract\nType|Contract No.|POR|POL|POD|DEL|Container|TPSZ|AK Application\nVoid (FEU)|" +
            		"Bay Plan (Loading Port)|Bay Plan (Loading Port)|Bay Plan (Loading Port)|Bay Plan (Loading Port)|Bay Plan (Loading Port)|Bay Plan (Loading Port)|Bay Plan (Loading Port)|" +
            		"Bay Plan (RDR Port)|Bay Plan (RDR Port)|Bay Plan (RDR Port)|Bay Plan (RDR Port)|Bay Plan (RDR Port)|Bay Plan (RDR Port)|Bay Plan (RDR Port)";
            var HeadTitle2 = "|RHQ|Office|B/L No.|Contract\nType|Contract No.|POR|POL|POD|DEL|Container|TPSZ|AK Application\nVoid (FEU)|" +
            		"VVD|POL|POD|TPSZ|Position|Bay Plan\nVoid (FEU)|Diff|VVD|POL|POD|TPSZ|Position|Bay Plan\nVoid (FEU)|Diff";
           
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
            
            //해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);
            
            

			//데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX		            
			
			
			//InitDataProperty(0, cnt++ , dtDummyCheck,	40,	daCenter,	false,	"chk",					false,	"",  dfNone,	0,	true     ,true );
            InitDataProperty(0, cnt++, dtHiddenStatus,	30,	   daCenter, 	true,	"ibflag");
			InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "bkg_rhq_cd",        false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "bkg_ofc_cd",        false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtPopup,			120,   daCenter,    true,   "bkg_no",            false,    "",      dfNone,      0,    true,     true);
			InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "bkg_ctrt_tp_cd",    false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtPopup,			100,   daCenter,    true,   "ctrt_no",           false,    "",      dfNone,      0,    true,     true);
			InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "por_cd",            false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "pol_cd",            false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "pod_cd",            false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "del_cd",            false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,			90,    daCenter,    true,   "cntr_no",           false,    "",      dfNone,      0,    false,    false);
			InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"cntr_tpsz_cd",	     false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			90,	   daCenter,    true,	"void_slt_qty",	     false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			90,	   daCenter,    true,	"vvd",	             false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			60,	   daCenter,    true,	"pol",	             false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			60,	   daCenter,    true,	"pod",	             false,    "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"sztp",	             false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,		    80,	   daCenter,    true,	"position",	         false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			80,	   daCenter,    true,	"void_vol",	         false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"void_diff",	     false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			90,	   daCenter,    true,	"rdr_vvd",	         false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			60,	   daCenter,    true,	"rdr_pol",	         false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			60,	   daCenter,    true,	"rdr_pod",	         false,    "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"rdr_sztp",	         false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,		    80,	   daCenter,    true,	"rdr_position",	     false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			80,	   daCenter,    true,	"rdr_void_vol",	     false,	   "",      dfNone,      0,	   false,	 false);
			InitDataProperty(0, cnt++, dtData,			40,	   daCenter,    true,	"rdr_void_diff",	 false,	   "",      dfNone,      0,	   false,	 false);
			
			

            ShowButtonImage = 2;
            UnEditableColor = RgbColor(255,255,255);
            FrozenCols = 4;
			
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
* @author 김대호
* @version 2010.01.19
*/ 
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
		// RHQ
		case "bkg_rhq_cd":
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
         // Charge Status
		case "charge_flg":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
            	UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 1;      // 1자리만 입력
            }
            break;

            // Container Type Size Code
   		case "cntr_tpsz_cd":
               var i=0;
               with(comboObj) {
               	MultiSelect = true;
               	Style = 0;
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
* @author 김대호
* @version 2010.01.19
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
	    		param = param + "&" + "vvd_cd=" + form.t_vvd.value;
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
	    		}else{
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
* @author 김대호
* @version 2010.01.19
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
  * @author 이승준
  * @version 2009.06.03
  */  	           
  function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	    var colname = sheetObj.ColSaveName(Col);  	 
  	switch(colname){
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
* @author 김대호
* @version 2010.02.26
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
* @author 김대호
* @version 2010.01.19
*/ 
function obj_deactivate() {
	var form = document.form;
	var formObj = event.srcElement;
    var srcName = formObj.getAttribute("name");
    switch(srcName) {
		case "t_vvd":
			var classNm = "input";
			if(formObj.value.length < formObj.maxLength) {
				classNm = "input1";
			}
			form.fm_dt.className = classNm;
			form.to_dt.className = classNm;
			break;
		case "ctrt_no":
			var ctrtTpCd = form.bkg_ctrt_tp_cd;
			if("" != formObj.value) {
				ctrtTpCd.className = "mult_combo1";
				ctrtTpCd.BackColor = "#CCFFFD";
			}else{
				ctrtTpCd.className = "mult_combo";
				ctrtTpCd.BackColor = "#FFFFFF";
			}
			break;
		case "bkg_no":
			break;
		default :
			ComChkObjValid(formObj);
	}

}

//===================================================================================
//UI Object Event Handler
//===================================================================================
/** 
 * vvd : Vessel SKD & Code Inquiry부분. <br>
 * <br><b>Example :</b>	
 * <pre>
 * </pre>
 * @param {arry} aryPopupData
 * @return 없음
 * @see #
 * @author 김대호
 * @version 2010.01.19
 */ 
function setCallBack0B2(aryPopupData) {
	var form = document.form;
	form.t_vvd.value = aryPopupData[0][7];
} 

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
  * @author 김대호                                                                               
  * @version 2009.10.28                                                         
  */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	 	var form = document.form;
	 	var colName = sheet1.ColSaveName(Col);
		var sName      = sheet1.ColSaveName(Col);
		var scRfaNo    = sheet1.CellValue(Row, "ctrt_no");	
		var ctrtTpCd   = sheet1.CellValue(Row, "bkg_ctrt_tp_cd");	
		var bkgNo 	   = sheet1.CellValue(Row, "bkg_no");    			
		var rdnNo      = sheet1.CellValue(Row, "rdn_no");
		var rctRhqCd   = sheet1.CellValue(Row, "bkg_rhq_cd");
		var rctOfcCd   = sheet1.CellValue(Row, "bkg_ofc_cd"); 	
	 	switch(colName){
	 		case "bkg_no":
		    	if(null == bkgNo || "" == bkgNo) { return; }
		    	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
		    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1401", popParams, "");
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
	        	comRASCallPop(pgmNo, "ESM_BKG_1401", popParams, "");
				break;
				
			case "rdn_no":
				//rdnNo = "RDN090086";
			    //B/L No ( <- B/L No ), Receipt RHQ ( <- RHQ ), Receipt Office( <- Office ), Responsible RHQ ( <- RHQ ), Responsible Office ( <- Office ) 항목 복사해 줌
				var popParams = "rdn_no=" + rdnNo + "&bl_no=" + bkgNo + "&rct_rhq_cd=" + rctRhqCd + "&rct_ofc_cd=" + rctOfcCd;
	    		comRASCallPop("ESM_BKG_0426", "ESM_BKG_1401", popParams, "");
				break;
				
			case "bay_plan":
				var pgmNo = "&pgmNo=ESM_BKG_1409";
				var url = "ESM_BKG_1409.do?func=&bkg_no="+bkgNo+pgmNo;
				ComOpenWindowCenter(url, "ESM_BKG_1051", 600, 400, false);
				
				break;
		 	}
}

/** 
 * sheet2 팝업연결 선택시 발생하는 sheet1_OnPopupClick 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {IBSheet} sheetObj : 시트오브젝트  
 * @param  {Long} Row : 해당 셀의 Row Index
 * @param  {Long} Col : 해당 셀의 Column Index
 * @return  
 * @see #
 * @author 김대호                                                                               
 * @version 2009.10.28                                                         
 */
function sheet2_OnPopupClick(sheetObj, Row, Col) {
	 	var form = document.form;
	 	var colName = sheet2.ColSaveName(Col);
		var sName      = sheet2.ColSaveName(Col);
		var scRfaNo    = sheet2.CellValue(Row, "ctrt_no");	
		var ctrtTpCd   = sheet2.CellValue(Row, "bkg_ctrt_tp_cd");	
		var bkgNo 	   = sheet2.CellValue(Row, "bkg_no");   
	 	switch(colName){
	 		case "bkg_no":
		    	if(null == bkgNo || "" == bkgNo) { return; }
		    	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
		    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1401", popParams, "");
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
	        	comRASCallPop(pgmNo, "ESM_BKG_1401", popParams, "");
				break;
				
		 	}
}


/** 
* RHQ 콤보 변경시 호출하는 bkg_rhq_cd_OnChange <br>
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
function bkg_rhq_cd_OnChange(rhqObj, Code, Text) {
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
	var rhqObj = form.bkg_rhq_cd;
	var officeObj = form.bkg_ofc_cd;
    var ctrtTpCd = form.bkg_ctrt_tp_cd;
    officeObj.RemoveAll();
    rhqObj.Index = "-1";
   	rhqObj.Code = gBkgRhqCd;
    ctrtTpCd.Code = gCtrtTpCdDefault;
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
        	formObj.f_cmd.value = SEARCH01;
        	sheetObj.DoSearch("ESM_BKG_1401GS.do", FormQueryString(formObj));
	 			
 			break;
        case IBSEARCH_ASYNC01: //조회
        	formObj.f_cmd.value = SEARCH02;
        	sheetObj.DoSearch("ESM_BKG_1401GS.do", FormQueryString(formObj));
		 			
	 		break;
 			
		case IBDOWNEXCEL:      //download excel
			sheetObj.SpeedDown2Excel(-1); //, "chk|seq"
			break;
			
		case IBSAVE:		//저장
	
			if (!ComShowCodeConfirm("BKG95003", "save Remarks")) { return false; }
			
			formObj.f_cmd.value = MULTI01;
			
		var sParam = FormQueryString(formObj);
		var sParamSheet1 = sheet1.GetSaveString();
		
		sParam += "&" + sParamSheet1;
			
		ComOpenWait(true);
		
		var sXml = sheet1.GetSaveXml("ESM_BKG_1401GS.do", sParam);
		
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
	
	var vvdBool = false;
	var vvd = form.t_vvd;
	if(vvd.value.length == vvd.maxLength){ vvdBool = true; }
	
    var fmDtObj  = form.fm_dt;
    var toDtObj    = form.to_dt;
	var fmDtValue = fmDtObj.value.replace(/-/g,'');
	var toDtValue   = toDtObj.value.replace(/-/g,'');
	
	if(fmDtValue != "" && toDtValue != "") {

		if( parseInt(fmDtValue,10) > parseInt(toDtValue,10) ) {
			ComShowCodeMessage("BKG95026", "From Date", "To Date");
			event.returnValue = false;			
			ComSetFocus(formObj);
			return false;
		}

		var fromAddDays = ComGetDateAdd(fmDtValue, "D", 30, "", true); // 31일
		if( !vvdBool && ( parseInt(toDtValue,10) > parseInt(fromAddDays,10) ) ) {
			ComShowCodeMessage("BKG95027", "31 days"); // "The period of Date can't be over {?msg1}."
			event.returnValue = false;		
			ComSetFocus(formObj);
			return false;
		}
		
	}
	
	if(!vvdBool) {
		if("" == formObj.value){
			ComShowCodeMessage("BKG95025", formObj.caption); // msgs['BKG95025'] = "Please input {?msg1}."
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
	
	var rhq       = form.bkg_rhq_cd; 
	var fmDtObj   = form.fm_dt;	
	var toDtObj   = form.to_dt;
	var fmDtValue = fmDtObj.value;	
	var toDtValue = toDtObj.value;
	var vvdObj    = form.t_vvd;
	var ctrtTyObj = form.bkg_ctrt_tp_cd;
	var ctrtNoObj = form.ctrt_no;
	var bkgNo     = form.bkg_no.value;
	
    switch (sAction) {
	    
    	case IBSEARCH: //조회
    		
    		if(bkgNo == "" || bkgNo == null){
    	
	    		if(null == rhq.Code || "" == rhq.Code){
					ComShowCodeMessage("BKG95031", "RHQ");
					event.returnValue = false;
					ComSetFocus(rhq);
					return false;	
	    		}
	    	
	    		if(!ComChkObjValid(fmDtObj)) { return false; }
	    		if(!ComChkObjValid(toDtObj)) { return false; }
	
	    		if("" == vvdObj.value && ("" == fmDtValue || "" == toDtValue)) {
					 ComShowCodeMessage("BKG95025", "Date or T/VVD"); // "Please input {?msg1}."
					 if("" == fmDtObj.value) {
						 ComSetFocus(fmDtObj);
					 }else{
						 ComSetFocus(toDtObj);
					 }
					 return false;
				}
	    		
				if(!chkDate(fmDtObj)) {  return false; }
				if(!chkDate(toDtObj)) { return false; }
				
				if(ctrtNoObj.value != "" && (null == ctrtTyObj.Code || "" == ctrtTyObj.Code) ) {
					ComShowCodeMessage("BKG95031", "Contract Type");
					event.returnValue = false;
					ComSetFocus(ctrtTyObj);
					return false; 
				}
    		}
			
	    	break;
	    	
    }

    return true;
    
}  

/** 
* sheet1 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
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

