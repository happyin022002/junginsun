/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1092.js
*@FileTitle : Audit by Commodity And Route
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.29 류선우
* 1.0 Creation
=========================================================
History
 2011.01.14 이정수 [CHM-201007610] RAS 기능 보완 및 Logic 보완 6
 2013.10.29 김진주 [CHM-201327066] [BKG/DOC - Revenue Audit System] Non-Charged RDN 자동발행메일 수신인 추가 등
=========================================================
*/
/**
 * @fileoverview Audit by Commodity And Route 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESM_BKG_1092:ESM_BKG_1092 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/**
 * @extends  
 * @class ESM_BKG_1092 : ESM_BKG_1092 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1092() {
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
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1;
var sheet2;
var sheet3;

var comboObjects = new Array();
var comboCnt = 0;
//업무전역변수
var gCurrDate;
var gXml = "";
var gLocationObj;
var gBkgRhqCd;
var gIsSearchDt = true;
var gIsSearchCharge = true;
var sheet_height = 20;
var first_load0 = true;

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
* @author 류선우
* @version 2010.04.29
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
* @author 류선우
* @version 2010.04.29
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
* @author 류선우
* @version 2010.04.29
*/ 
function loadPage() {
	
	var form = document.form;	
    sheet1 = sheetObjects[0];
    sheet2 = sheetObjects[1];    
    sheet3 = sheetObjects[2];        
    sheetCnt = sheetObjects.length ;

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
    
    //chg_cd1 비활성화
    document.form.chg_cd1.Index = "-1";
	document.form.chg_cd1.Enable = false;
    
    //html컨트롤 이벤트초기화    
	axon_event.addListenerForm('click', 'obj_click', form);	 
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
    axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    
    gBkgRhqCd = form.strRhq_ofc_cd.value;
    gCurrDate = ComGetNowInfo('ymd', '-');

    ComOpenWait(true);
	doActionIBSheet2(sheet2, form, IBSEARCH_ASYNC01);
	ComOpenWait(false);
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
* @author 류선우
* @version 2009.08.12
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
 * @author 류선우
 * @version 2009.12.15
 */
function initIBComboItem() {
	ComBkgTextCode2ComboItem(rhqComboValue,        rhqComboValue,       getComboObject(comboObjects, 'bkg_rhq_cd'),  "|", "\t" );
	getComboObject(comboObjects, 'bkg_rhq_cd').Code2 = gBkgRhqCd; // 초기화시에는 이벤트 발생 안시킴. 초기화시 office 자동 셋팅함.(java와 맞춰준다.)
	ComBkgTextCode2ComboItem(gsoComboValue,        gsoComboValue,       getComboObject(comboObjects, 'bkg_gso_cd'),  "|", "\t" );
	ComBkgTextCode2ComboItem(officeComboValue,     officeComboValue,    getComboObject(comboObjects, 'bkg_ofc_cd'),  "|", "\t" );	
//	getComboObject(comboObjects, 'bkg_ofc_cd').Code2 = form.strOfc_cd.value;
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'), "|", "\t" );
	getComboObject(comboObjects, 'bkg_ctrt_tp_cd').Code2 = "S";
    ComBkgTextCode2ComboItem(cargoTypeComboValue,  cargoTypeComboText,  getComboObject(comboObjects, 'cargo_type'),  	"|", "\t" );
    ComBkgTextCode2ComboItem(usaSvcModCdComboValue,usaSvcModCdComboText,getComboObject(comboObjects, 'usa_svc_mod_cd'), "|", "\t" );
    ComBkgTextCode2ComboItem(svcScpCdComboValue,   svcScpCdComboText,   getComboObject(comboObjects, 'svc_scp_cd'),  	"|", "\t" );
    ComBkgTextCode2ComboItem(rTermComboValue,      rTermComboText,      getComboObject(comboObjects, 'rcv_term_cd'), 	"|", "\t" );
    ComBkgTextCode2ComboItem(dTermComboValue,      dTermComboText,      getComboObject(comboObjects, 'de_term_cd'),  	"|", "\t" );

	document.form.bdr_flg.InsertItem(0,'','');
	document.form.bdr_flg.InsertItem(1,'Yes','Y');
	document.form.bdr_flg.InsertItem(2,'No','N');
	ComBkgTextCode2ComboItem(bkgStatuCdComboValue, bkgStatuCdComboText, getComboObject(comboObjects, 'bkg_sts_cd'),  	"|", "\t" );
	getComboObject(comboObjects, 'bkg_sts_cd').Code2 = "F";
    ComBkgTextCode2ComboItem(splitFlgComboValue,   splitFlgComboText,   getComboObject(comboObjects, 'split_flg'),   	"|", "\t" );
	ComBkgTextCode2ComboItem(chargeFlgComboValue,  chargeFlgComboText,  getComboObject(comboObjects, 'charge_flg'),  	"|", "\t" );
	getComboObject(comboObjects, 'charge_flg').Code2 = "C";
	ComBkgTextCode2ComboItem(ratingTypeComboValue, ratingTypeComboText, getComboObject(comboObjects, 'auto_rat_flg'),	"|", "\t" );

    ComBkgTextCode2ComboItem(ratUtCdComboValue,   ratUtCdComboText,     getComboObject(comboObjects, 'rat_ut_cd'),  	"|", "\t" );
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
* @author 류선우
* @version 2010.04.29
*/ 
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	var sheetID = sheetObj.id;
   
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
		            //높이 설정
		            //style.height = 360;
	      			//sheetObj.DataRowHeight = 3;
	      			style.height = GetSheetHeight(sheet_height);
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly + msPrevColumnMerge;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(2, 1, 2, 100);

		        	var HeadTitle1 = "Seq.|RHQ|Office|B/L No.|BKG Date|Appl.Date|POL ETD|T/VVD|Contract\nType|Contract No.|Rep.\nCMDT Code|CMDT Code|Commodity|Commodity (M&D)|Cargo Type|Cargo Type|Cargo Type|Cargo Type|Cargo Type|Cargo Type|EQ Sub|Scope|POR|POL|POD|DEL|R/D Term|R/D Term|USA\nSVC Mode|Shipper|Consignee|Notify|Contract|Contract|Contract|BDR\nStatus|BKG\nStatus|Split\nStatus|Charge\nStatus|Rating\nType|Bill\nType|Rater ID|RDN Issuance|RDN Status|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|bkg_no|bkg_ctrt_tp_cd|bl_cnt|row_cnt";
		        	var HeadTitle2 = "Seq.|RHQ|Office|B/L No.|BKG Date|Appl.Date|POL ETD|T/VVD|Contract\nType|Contract No.|Rep.\nCMDT Code|CMDT Code|Commodity|Commodity (M&D)|DG|RF|AK|BB|RD|HG|EQ Sub|Scope|POR|POL|POD|DEL|R|D|USA\nSVC Mode|Shipper|Consignee|Notify|Customer|Type|Seg.|BDR\nStatus|BKG\nStatus|Split\nStatus|Charge\nStatus|Rating\nType|Bill\nType|Rater ID|RDN Issuance|RDN Status|Charge|Cur|Rate|Rated As|Per|Amount|M|bkg_no|bkg_ctrt_tp_cd|bl_cnt|row_cnt";

		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(false, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            InitHeadRow(1, HeadTitle2, true);

//데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
		    		InitDataProperty(0, cnt++ , dtData,	40,		daCenter,true,	"bkg_seq"				,	false,	"", dfNone,0,false,false);
		            InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"bkg_rhq_cd"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"bkg_ofc_cd"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtPopup,110,	daCenter,true,	"bl_no"					,	false,	"", dfNone,0,true,true);
		    		InitDataProperty(0, cnt++ , dtData,	80,		daCenter,true,	"bkg_cre_dt"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	80,		daCenter,true,	"rt_aply_dt"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	80,		daCenter,true,	"vps_etd_dt"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	80,		daCenter,true,	"vvd"					,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	70,		daCenter,true,	"bkg_ctrt_tp_nm"		,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtPopup,100,	daCenter,true,	"ctrt_no"				,	false,	"", dfNone,0,true,true);
		    		InitDataProperty(0, cnt++ , dtData,	80,		daCenter,true,	"rep_cmdt_cd"			,	false,	"", dfNone,0,false,false);
		    		
		    		InitDataProperty(0, cnt++ , dtData,	70,		daCenter,true,	"cmdt_cd"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	150,	daLeft	,true,	"cmdt_nm"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	150,	daLeft	,true,	"cstms_desc"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	30,		daCenter,true,	"dcgo_flg"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	30,		daCenter,true,	"rc_flg"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	30,		daCenter,true,	"awk_cgo_flg"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	30,		daCenter,true,	"bb_cgo_flg"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	30,		daCenter,true,	"rd_cgo_flg"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	30,		daCenter,true,	"hngr_flg"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	50,		daCenter,true,	"eq_subst_flg"			,	false,	"", dfNone,0,false,false);
		    		
		    		InitDataProperty(0, cnt++ , dtData,	50,		daCenter,true,	"svc_scp_cd"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"por_cd"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"pol_cd"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"pod_cd"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"del_cd"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	30,		daCenter,true,	"rcv_term_cd"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	30,		daCenter,true,	"de_term_cd"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"usa_svc_mod_nm"		,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	270,	daLeft	,true,	"s_cust_nm"				,	false,	"", dfNone,0,false,false);
		    		
		    		InitDataProperty(0, cnt++ , dtData,	270,	daLeft	,true,	"c_cust_nm"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	270,	daLeft	,true,	"n_cust_nm"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	200,	daLeft	,true,	"ctrt_cust_nm"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	40,		daCenter,true,	"ctrt_cust_tp_cd"		,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"ctrt_cust_val_sgm_nm"	,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"bdr_flg"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	60,		daCenter,true,	"bkg_sts_nm"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	70,		daCenter,true,	"split_nm"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	70,		daCenter,true,	"charge_nm"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	80,		daCenter,true,	"auto_rat_nm"			,	false,	"", dfNone,0,false,false);
		    		
		    		InitDataProperty(0, cnt++ , dtData,	70,		daCenter,true,	"rt_bl_tp_nm"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	80,		daCenter,true,	"rater_id"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtPopup,100,	daCenter,true,	"rdn_no"				,	false,	"", dfNone,0,true,true);
		    		InitDataProperty(0, cnt++ , dtData,	80,		daCenter,true,	"rdn_sts_nm"			,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	50,		daCenter,true,	"chg_cd"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	50,		daCenter,true,	"curr_cd"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	120,	daRight,true,	"chg_ut_amt"			,	false,	"", dfNullFloat,2,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	100,	daRight,true,	"rat_as_qty"			,	false,	"", dfNullFloat,3,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	40,		daCenter,true,	"rat_ut_cd"				,	false,	"", dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ , dtData,	120,	daRight,true,	"chg_amt"				,	false,	"", dfNullFloat,2,false,false);

		    		InitDataProperty(0, cnt++ , dtData,	30,		daCenter,true,	"auto_rat_cd"			,	false,	"", dfNone,0,false,false);

		    		InitDataProperty(0, cnt++ ,dtHidden,90     ,daCenter,true,	"bkg_no"            	,	false,	"",	dfNone,0,false,false);
		    		InitDataProperty(0, cnt++ ,dtHidden,90     ,daCenter,true,	"bkg_ctrt_tp_cd"        ,	false,	"",	dfNone,0,false,false);
		    		InitDataProperty(0, cnt++, dtHidden,    50,    daCenter,    true,   "bl_cnt",    false,    "",      dfNone,      0,    false,    false);
		    		InitDataProperty(0, cnt++, dtHidden,    50,    daCenter,    true,   "row_cnt",   false,    "",      dfNone,      0,    false,    false);
		    		
		    		CountPosition = 0;
					FrozenCols = 4;
	                UnEditableColor = RgbColor(255,255,255);
	                ShowButtonImage = 2;
	      	}
	      	break;
	      	
		case "sheet2": // 콤보용
	  		with (sheet2) {
		
	            //높이 설정
	            style.height = 100;
	            //전체 너비 설정
	            SheetWidth = 300;
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            //전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(1, 1, 2, 100);
	            var HeadTitle1 = "Seq.|chg_cd|chg_nm|rep_chg_cd"
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false);
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            
//데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME      ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtDataSeq,40	  ,daCenter ,false   ,"seq"                                           );            
InitDataProperty(0 ,cnt++ ,dtData   ,50   ,daLeft   ,false   ,"chg_cd"      ,false   ,""        ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtData   ,200  ,daLeft   ,false   ,"chg_nm"      ,false   ,""        ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtData   ,50   ,daLeft   ,false   ,"rep_chg_cd"  ,false   ,""        ,dfNone    ,0 );
	            
			}
			break;
			
		case "sheet3": // backendjob 용
	  		with (sheet3) {
		
	            //높이 설정
	            style.height = 20;
	            //전체 너비 설정
	            SheetWidth = 300;
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            //전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(1, 1, 2, 100);
	            var HeadTitle1 = "f_text1"
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false);
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            
//데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME   ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtData   ,200  ,daLeft   ,false   ,"f_text1"  ,false   ,""        ,dfNone    ,0 );
	            
	            var idx = sheet3.DataInsert();
	            
				Visible = false; // backendjob 용으로 같이씀 참고 : 0015
	
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
* @author 류선우
* @version 2010.04.29
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
                MaxLength = 5;
			}
			break;
		// gso
		case "bkg_gso_cd":
			var i = 0;
			with (comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력				
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
			// Contract type
        case "bkg_ctrt_tp_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
				UseAutoComplete = true;
            	ValidChar(2, 2);    // 영문대문자만 입력 + 특수문자
            }
            break;      
		// scope
		case "svc_scp_cd":
			var i = 0;
			with (comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 3;
			}
			break;
		// charge
		case "chg_cd":
			var i = 0;
			with (comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 3;      // 3자리만 입력
			}
			break;
		case "chg_cd1":
			var i = 0;
			with (comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 3;      // 3자리만 입력
			}
			break;				
		// R/D Term
		case "rcv_term_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 260;
            	UseAutoComplete = true;
				ValidChar(1, 0);    // 영문만입력
            }
            break;    
        // R/D Term    
		case "de_term_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 260;
            	UseAutoComplete = true;
				ValidChar(1, 0);    // 영문만입력            	
            }
            break;  
        // cargo type
		case "cargo_type":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
            	UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 2;      // 2자리만 입력
            }
            break;
        // BKG Status
		case "bkg_sts_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
            	UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 1;      // 1자리만 입력
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
        // Split Status
		case "split_flg":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
            	UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 1;      // 1자리만 입력
            }
            break;  

         // Rating Unit
		case "rat_ut_cd":
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
* @author 류선우
* @version 2010.04.29
*/ 
function processButtonClick(){
	var form = document.form;
	var rdoDateObj = form.rdoDate;
    try {
	    var srcName = window.event.srcElement.getAttribute("name");
	    switch(srcName) {
	        case "btns_calendar1": //달력버튼
	        	var cal = new ComCalendar();
	        	cal.select(form.from_dt, 'yyyy-MM-dd');
	        	break;
	        
	        case "btns_calendar2":
		        var cal = new ComCalendar();
		        cal.select(form.to_dt, 'yyyy-MM-dd');
		        break;

	        case "ctrt_popup":
	        	var pgmNo = "";
	        	
	        	var ctrtTpCd = getComboObject(comboObjects, 'bkg_ctrt_tp_cd').Code;
	        	if(ctrtTpCd == "S") { // S/C
	 				pgmNo = "ESM_PRI_0062";
	 			}
	 			else if(ctrtTpCd == "R") { // RFA
	 	    		pgmNo = "ESM_PRI_2043";
	 	    	}
	 	    	else if(ctrtTpCd == "T") { // TAA
		    		pgmNo = "ESM_PRI_3007";
		    	}
	        	comRASCallPop(pgmNo, "ESM_BKG_1092", "", "");
				break;

	        case "cmdt_popup":
				var param = "";
	    		param = param + "&" + "cmdt_cd=" + form.cmdt_cd.value;
	    		ComOpenPopup('/hanjin/COM_ENS_011.do?' + param, 620, 450, 'setCallBackCmdtPopup', '1,0,1,1,1,1,1,1', true);
				break;

	        case "vvd_popup":
				var param = "";
	    		param = param + "&" + "vvd_cd=" + form.vvd.value;
	    		ComOpenPopup('/hanjin/COM_ENS_0B2.do?' + param, 780, 470, 'setCallBackVVDPopup', '1,0,1,1,1,1,1,1', true);
				break;

				
			case "btn_por_cd":
			case "btn_pol_cd":
			case "btn_pod_cd":
			case "btn_del_cd":
				gLocationObj = eval("form."+(srcName.substr(4))); 
				ComOpenPopup("COM_ENS_051.do", 800, 460,"setLocationCd", "1,0,1,1,1", true);
				break;
				
	    	case "btn_retrieve":
	    		if (validateForm(sheet1, form, IBSEARCH)) {
	    			//doActionIBSheet(sheet1, form, IBSEARCH);
	    			doActionIBSheet(sheet2, form, IBBATCH);	    			
	    		}
	    		break;
	    		
	    	case "btn_new":
	    		//form.reset();
	    		ComResetAll();
	    		setNew();
	    		break;
	    		
	    	case "btn_downexcel":
	    		doActionIBSheet(sheet1, form, IBDOWNEXCEL);
	    		break;
	    		
			case "bu_zoom_in":
				sheet_height = getSheetHeightCnt(sheet1,"MAX",1);
				sheet1.style.height = sheet1.GetSheetHeight(sheet_height);
				div_zoom_in.style.display = "none";
				div_zoom_out.style.display = "inline";
				parent.syncHeight();
				break;

			case "bu_zoom_out":
				sheet_height = getSheetHeightCnt(sheet1,"MIN",0);
				sheet1.style.height = sheet1.GetSheetHeight(sheet_height);
				div_zoom_in.style.display = "inline";
				div_zoom_out.style.display = "none";
				parent.syncHeight();
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
* @author 류선우
* @version 2010.04.29
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
    case "engupnum":
	        //숫자+"영문대분자"입력하기
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
* @author 류선우
* @version 2009.08.24
*/
function obj_click(){
	var form = document.form;
	var obj = event.srcElement;
	switch(obj.name){
		case "r_date":
			form.search_date.value = obj.value;
			break;

		case "bill_type_all":
	 		var tf = false;
	 		if(obj.checked) {
	 			tf = true;
	 		}
	 		setBillTypeCheckBox(tf);
	 		break;
	 		
		case "chg_tp":
			form.charge_type.value = obj.value;
			break;
		
		case "chg_cond":
			form.charge_condition.value = obj.value;
			break;	
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
* @author 류선우
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
* @author 류선우
* @version 2010.04.29
*/ 
function obj_deactivate() {
	var form = document.form;
	var formObj = event.srcElement;
    var srcName = formObj.getAttribute("name");
    switch(srcName) {
		case "ctrt_no":
		case "cmdt_cd":
		case "cust_seq":
		case "cust_nm":
		case "por_cd":
		case "del_cd":
		case "pol_cd":
		case "pod_cd":
			break;

		case "vvd":
		case "bl_no":
			getSearchCondtion(formObj);
			break;
		
		default :
			ComChkObjValid(formObj);
	}

}

//===================================================================================
//UI Object Event Handler
//===================================================================================
/** 
* Location 코드 조회 팝업 창 리턴값을 받는 setLocationCd <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} aryPopupData  : 시트오브젝트  
* @return 없음
* @see #
* @author 류선우
* @version 2010.04.29
*/ 
function setLocationCd(aryPopupData) {
	gLocationObj.value = aryPopupData[0][3];
} 

/** 
* cmdt : Commodity Code Inquiry부분. <br>
* <br><b>Example :</b>	
* <pre>
* </pre>
* @param {arry} aryPopupData
* @return 없음
* @see #
* @author 류선우
* @version 2010.04.29
*/ 
function setCallBackCmdtPopup(aryPopupData) {
	var form = document.form;
	form.cmdt_cd.value = aryPopupData[0][2];
} 

/** 
 * vvd : Vessel SKD & Code Inquiry부분. <br>
 * <br><b>Example :</b>	
 * <pre>
 * </pre>
 * @param {arry} aryPopupData
 * @return 없음
 * @see #
 * @author 류선우
 * @version 2010.04.29
 */ 
function setCallBackVVDPopup(aryPopupData) {
	var form = document.form;
	form.vvd.value = aryPopupData[0][7];
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
 * @author 류선우                                                                               
 * @version 2009.10.28                                                         
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
 	var form = document.form;
 	var colName = sheetObj.ColSaveName(Col);
 	switch(colName){
		case "bl_no":
         	var bkgNo = sheetObj.CellValue(Row, "bkg_no");
         	if(null == bkgNo || "" == bkgNo) { return; }

         	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
        	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1092", popParams, "");
 			break;

		case "ctrt_no":
         	var ctrtNo = sheetObj.CellValue(Row, "ctrt_no");
         	if(null == ctrtNo || "" == ctrtNo) { return; }

         	var form = document.form;
 			var ctrtTpCd = sheetObj.CellValue(Row, "bkg_ctrt_tp_cd");
 			
 			var pgmNo = "";
 			var popParams = "";

 			if(ctrtTpCd == "S") { // S/C
 				pgmNo = "ESM_PRI_0004";
     			popParams = "sc_no_p=" + ctrtNo.substr(0,3) + "&sc_no_s=" + ctrtNo.substr(3);
 			}
 			else if(ctrtTpCd == "R") { // RFA
 	    		pgmNo = "ESM_PRI_2019";
 	    		popParams = "s_rfa_no=" + ctrtNo;
 	    	}
 	    	else if(ctrtTpCd == "T") { // TAA
	    		pgmNo = "ESM_PRI_3007";
	    		popParams = "cond_taa_no=" + ctrtNo;  
	    	}
        	comRASCallPop(pgmNo, "ESM_BKG_1092", popParams, "");
 		    break;
 		 
		case "rdn_no":
			var rdnNo   = sheetObj.CellValue(Row, "rdn_no");
			var blNo 	= sheetObj.CellValue(Row, "bl_no");
			var rhqCd   = sheetObj.CellValue(Row, "bkg_rhq_cd");
			var ofcCd   = sheetObj.CellValue(Row, "bkg_ofc_cd");

		    //B/L No ( <- B/L No ), Receipt RHQ ( <- RHQ ), Receipt Office( <- Office ), Responsible RHQ ( <- RHQ ), Responsible Office ( <- Office ) 항목 복사해 줌
			var popParams = "rdn_no=" + rdnNo + "&bl_no=" + blNo + "&rct_rhq_cd=" + rhqCd + "&rct_ofc_cd=" + ofcCd;
    		comRASCallPop("ESM_BKG_0426", "ESM_BKG_0256", popParams, "");
			break;
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
    initIBComboItem();
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
* @author 류선우
* @version 2010.04.29
*/ 
function bkg_rhq_cd_OnChange(rhqObj, Code, Text) {
	var form = document.form;
	var params = "";
	var sXml = "";
	//var idx = rhqObj.Index;
	var officeObj = form.bkg_ofc_cd;
	var gsoObj = form.bkg_gso_cd;
	
	officeObj.RemoveAll();
	gsoObj.RemoveAll();
	
	if(null == Code || "" == Code) {
		officeObj.InsertItem(0, "", "");
	}else{
		params = "f_cmd=" + COMMAND02 + "&etc2=" + Code;
		sXml = sheet1.GetSearchXml("RASCommonGS.do?", params);
		ComXml2ComboItem(sXml, officeObj, "cd", "cd");
		officeObj.InsertItem(0, "", "");
		officeObj.Code = form.strOfc_cd.value;
		
		params = "f_cmd=" + COMMAND02 + "&etc2=" + Code + "&rhq_set=gso";
		sXml = sheet1.GetSearchXml("RASCommonGS.do?", params);
		ComXml2ComboItem(sXml, gsoObj, "cd", "cd");
		gsoObj.InsertItem(0, "", "");
	}
}
/** 
* GSO 콤보 변경시 호출하는 bkg_gso_cd_OnChange <br>
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
function bkg_gso_cd_OnChange(gsoObj, Code, Text) {
	var form = document.form;
	var params = "";
	var sXml = "";
	//var idx = rhqObj.Index;
	var officeObj = form.bkg_ofc_cd;
	
	officeObj.RemoveAll();
	
	if(null == Code || "" == Code) {
		//gso가 없을땐 RHQ기준 Office List를 보여줌
		params = "f_cmd=" + COMMAND02 + "&etc2=" + form.bkg_rhq_cd.Code;
		sXml = sheet1.GetSearchXml("RASCommonGS.do?", params);
		ComXml2ComboItem(sXml, officeObj, "cd", "cd");
		officeObj.InsertItem(0, "", "");
		officeObj.Code = form.strOfc_cd.value;
	}else{
		params = "f_cmd=" + COMMAND02 + "&etc2=" + Code + "&etc4=" + Code;
		sXml = sheet1.GetSearchXml("RASCommonGS.do?", params);
		ComXml2ComboItem(sXml, officeObj, "cd", "cd");
		officeObj.InsertItem(0, "", "");
		officeObj.Code = form.strOfc_cd.value;
	}
}

/** 
* Bill Type 선택시 B/L COVERED TYPE CODE 를 선택해지 유무를 해주는 setBillTypeCheckBox <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {boolean} tf
* @return 없음
* @see #
* @author 류선우
* @version 2010.04.29
*/ 
function setBillTypeCheckBox(tf) {
	/*
	공통코드 : B/L COVERED TYPE CODE ( CD01639 )
	B CO-BIZ B/L ( 대상 아님 )
	C COVERED B/L
	M MASTER B/L
	N NORMAL B/L
	*/
	var form = document.form;
	form.bill_type_n.checked = tf;
	form.bill_type_m.checked = tf;
	form.bill_type_c.checked = tf;	
	form.bill_type_b.checked = tf;		
}

/** 
* 화면 폼입력값에 초기화 하는 setNew <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 류선우
* @version 2010.04.29
*/ 
function setNew() {
	var form = document.form;
	var rhqObj = form.bkg_rhq_cd;
	var officeObj = form.bkg_ofc_cd;
	var bkgCtrtTpObj = form.bkg_ctrt_tp_cd;
	var bkgStatusObj = form.bkg_sts_cd;
	var chargeStatusObj = form.charge_flg;

	form.from_dt.className = "input1";
	form.to_dt.className = "input1";
	form.ctrt_no.className = "input1";

	officeObj.RemoveAll();
    // RHQ 는 이벤트 태움.
    rhqObj.Index = "-1";
   	rhqObj.Code = gBkgRhqCd;
   	bkgCtrtTpObj.Code2 = "S";
   	bkgStatusObj.Code2 = "F";
   	chargeStatusObj.Code2 = "C";
   	
   	
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
* @author 류선우
* @version 2010.04.29
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	   
	sheet1.ShowDebugMsg = false;
         
	switch(sAction) {
        case IBSEARCH: //조회
        	formObj.f_cmd.value = SEARCH;
 			sheet1.DoSearch("ESM_BKG_1092GS.do", FormQueryString(formObj));
 			
 			break;

        case IBBATCH: //backendjob
        	try {

        		formObj.f_cmd.value = COMMAND01;
        		
    			ComOpenWait(true);
    			sheet1.WaitImageVisible = false;
    			sheet3.WaitImageVisible = false;	    	
        		
    			var sXml = sheet3.GetSearchXml("ESM_BKG_1092GS.do", FormQueryString(formObj));
    			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
    			if (backendJobKey.length > 0) {
    				formObj.backendjob_key.value = backendJobKey;
    				sheet3.RequestTimeOut = 10000;
    				timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에
    																// getBackEndJobStatus함수
    																// 실행 - 재귀호출
    			}else{
        			ComOpenWait(false);
    			}
        	}catch(e){
        		ComShowMessage(e);
    			ComOpenWait(false);
	    	}
 			break;
 			
		case IBDOWNEXCEL:      //download excel
		    sheet1.SpeedDown2Excel(-1); //, "chk|seq"
			//sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
			break;
 			
	}
}

/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet2 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 류선우
* @version 2010.04.29
*/ 
function doActionIBSheet2(sheetObj, formObj, sAction) {
	   
	sheet2.ShowDebugMsg = false;
         
	switch(sAction) {
		case IBSEARCH_ASYNC01:
        	gXml = sheet2.GetSearchXml("RASCommonGS.do?", "f_cmd=" + SEARCHLIST09);
			ComXml2ComboItem(gXml, formObj.chg_cd, "chg_cd", "chg_cd|chg_nm");
			ComXml2ComboItem(gXml, formObj.chg_cd1, "chg_cd", "chg_cd|chg_nm");
			formObj.chg_cd.InsertItem(0, "", "");
			formObj.chg_cd1.InsertItem(0, "", "");
 			sheet2.LoadSearchXml(gXml);
			break;
	}
}

/**
* BackEndJob 관련 Status='3' 이 될때까지 확인한다.
*/
function getBackEndJobStatus() {
	try {
		var form = document.form;
		form.f_cmd.value = SEARCH;
		var sXml = sheet3.GetSearchXml("ESM_BKG_1092GS.do", FormQueryString(form));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer);
		} else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
			ComShowCodeMessage("BKG95019"); //msgs['BKG95019'] = 'Failed to download. Please try again.';
			clearInterval(timer);	
			ComOpenWait(false);	
		} else if (jobState == "5") {
			ComShowCodeMessage("BKG95020"); //msgs['BKG95020'] = 'Data was downloaded successfully.'
			clearInterval(timer);
			ComOpenWait(false);	
		}
	}catch(e){
		ComShowMessage(e);
		ComOpenWait(false);
	}
}

/**
* BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital)
*/
function getBackEndJobLoadFile() {
	try {
		var form = document.form;
		form.f_cmd.value = SEARCHLIST;
		
		var formString = "f_cmd=" + form.f_cmd.value + "&backendjob_key=" + form.backendjob_key.value;
		var sXml = sheet1.GetSearchXml("ESM_BKG_1092GS.do", formString);
		sheet1.LoadSearchXml(sXml);

		if(sheet1.RowCount > 0){
			form.bl_cnt.value = parseInt(sheet1.CellValue(2,"bl_cnt"));
		}else{
			form.bl_cnt.value = "0";
		}
		
	}catch(e){
		ComShowMessage(e);
	}finally{        	
		ComOpenWait(false);        		
	}
}

/** 
* VVD 의 입력값에 대한 조회조건 상태를 체크하는 getSearchCondtion <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  
* @return {boolean}
* @see #
* @author 류선우
* @version 2010.04.29
*/ 
function getSearchCondtion(formObj){
	
	var form = document.form;

	var srcName = formObj.getAttribute("name");
	 
    switch(srcName) {
	case "vvd":
	case "bl_no":

		if(form.vvd.maxLength == form.vvd.value.length ||
		   form.bl_no.maxLength == form.bl_no.value.length ) {
			form.from_dt.className = "input";
			form.to_dt.className = "input";

			form.ctrt_no.className = "input";
		}
		else {
			form.from_dt.className = "input1";
			form.to_dt.className = "input1";

			form.ctrt_no.className = "input1";
		}
		
		if(srcName == "bl_no" && form.bl_no.maxLength == form.bl_no.value.length) {
			getComboObject(comboObjects, 'bkg_rhq_cd').Code = "";
		}
		

		break;
	
	default:
		break;
    }

    return true;
    
/*
	gIsSearchDt = false;
	gIsSearchCharge = false;
	var form = document.form;
	var reVal = "0";
	var dtClassNm = "input";
	var fmDtObj = form.from_dt;
	var toDtObj = form.to_dt;

	var srcObj = form.vvd;
	
	var chargeObj = form.chg_cd;
	var chargeFlgObj = form.charge_flg;
	if(vvdObj.maxLength == vvdObj.value.length){
		chargeObj.className = "mult_combo";
		chargeObj.BackColor = "#FFFFFF";
		dtClassNm = "input";
		// 조회조건 RHQ 외에 옵션
	}else{
		gIsSearchDt = true;
		if(chargeFlgObj.Code == "N"){
			chargeObj.className = "mult_combo";
			chargeObj.BackColor = "#FFFFFF";
			// 100일
			dtClassNm = "input1";			
			reVal = "100";
		}else{
			gIsSearchCharge = true;
			chargeObj.className = "mult_combo1";
			chargeObj.BackColor = "#CCFFFD";
			// 31일
			dtClassNm = "input1";						
			reVal = "31";
		}
	}	

	fmDtObj.className = dtClassNm;
	toDtObj.className = dtClassNm;
	
	return reVal;
*/
}

/** 
* 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 chkDate <br>
* Application 날짜 Validation을 체크한다. <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {String} chkDays : 조회가능한 최대날짜
* @return {boolean}
* @see #
* @author 류선우
* @version 2010.04.29
*/ 
function chkDate(chkDays) {
	
	var form = document.form;
	
    var fmDtObj   = form.from_dt;
    var toDtObj   = form.to_dt;
	var fmDtValue = fmDtObj.value.replace(/-/g,'');
	var toDtValue = toDtObj.value.replace(/-/g,'');

	if(fmDtObj.className == "input1" && fmDtValue == ""){
		ComShowCodeMessage("BKG95025", fmDtObj.caption);
		event.returnValue = false;		
		ComSetFocus(fmDtObj);
		return false;
	}
	
	if(!ComChkObjValid(fmDtObj)) { return false; }
	
	if(toDtObj.className == "input1" && toDtValue == ""){
		ComShowCodeMessage("BKG95025", toDtObj.caption);
		event.returnValue = false;		
		ComSetFocus(toDtObj);
		return false;
	}
	
	if(!ComChkObjValid(toDtObj)) { return false; }

	if( parseInt(fmDtValue,10) > parseInt(toDtValue,10) ) {
		ComShowCodeMessage("BKG95026", "From Date", "To Date");
		event.returnValue = false;
		ComSetFocus(fmDtObj);
		return false;
	}
	
	if(fmDtValue != "" && toDtValue != "") {
		var fromAddDays = ComGetDateAdd(fmDtValue, "D", parseInt(chkDays, 10) - 1, "", true);
		if( parseInt(toDtValue,10) > parseInt(fromAddDays,10) ) {
			ComShowCodeMessage("BKG95027", chkDays + " days"); // "The period of Date can't be over {?msg1}."
			event.returnValue = false;		
			ComSetFocus(fmDtObj);
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
* @author 류선우
* @version 2010.04.29
*/ 
function validateForm(sheetObj, formObj, sAction){
	
	var form = document.form;

	var rhqObj    = form.bkg_rhq_cd;

	var fmDtObj   = form.from_dt;	
	var toDtObj   = form.to_dt;
	var vvdObj    = form.vvd;
	var ctrtNoObj = form.ctrt_no;
	var blNoObj   = form.bl_no;
	var cmdtObj	  = form.cmdt_cd;

	var fmDtValue = fmDtObj.value;	
	var toDtValue = toDtObj.value;
	
    switch (sAction) {
	    
    	case IBSEARCH: //조회

			if((null == rhqObj.Code || "" == rhqObj.Code) && blNoObj.maxLength != blNoObj.value.length) {
				ComShowCodeMessage("BKG95031", "RHQ");
				ComSetFocus(rhqObj);
				return false;
			}

			if(!ComChkObjValid(fmDtObj)) { return false; }
			if(!ComChkObjValid(toDtObj)) { return false; }
			
			if("" == ctrtNoObj.value && "" == cmdtObj.value) {
				 ComShowCodeMessage("BKG95025", "Contract No. or Commodity."); // "Please input {?msg2}."
				 ComSetFocus(ctrtNoObj);
				 return false;
			}

//			if("" == ctrtNoObj.value && "" == blNoObj.value && "" == vvdObj.value) {
//				 ComShowCodeMessage("BKG95025", "Contract No."); // "Please input {?msg2}."
//				 ComSetFocus(ctrtNoObj);
//				 return false;
//			}

			if("" == blNoObj.value && "" == vvdObj.value && ("" == fmDtValue || "" == toDtValue)) {
				 ComShowCodeMessage("BKG95025", "Date"); // "Please input {?msg2}."
				 if("" == fmDtObj.value) {
					 ComSetFocus(fmDtObj);
				 }else{
					 ComSetFocus(toDtObj);
				 }
				 return false;
			}

			if(!chkDate(100)) { return false; }

			break;
    }

    return true;
    
}

/**
 * chg_cd 변경시 활성화됨<br>
 * 
 * <br><b>Example :</b>
 * <pre>
 * 		
 * </pre>
 * @param {comboObj} comboObj    필수,comboObj Object
 * @param {String} code    
 * @param {String} text 
 * @return 없음   
 * @author 이정수
 * @version 2010.12.23
 */ 
function chg_cd_OnChange(comboObj, code, text) {
		//alert(code);
		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
			if(code == "") {
				document.form.chg_cd1.Index = "-1";
				document.form.chg_cd1.Enable = false;
			} else {
				document.form.chg_cd1.Index = "-1";
				document.form.chg_cd1.Enable = true;
			}
		} 
		
}
