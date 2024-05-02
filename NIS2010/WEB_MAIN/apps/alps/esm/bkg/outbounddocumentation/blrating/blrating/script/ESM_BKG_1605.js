/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1605.js
*@FileTitle : Group & Multi B/L Rating
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.19 김대호
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview Audit by CNTR Qty Discrepancy 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESM_BKG_1605:ESM_BKG_1605 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/**
 * @extends  
 * @class ESM_BKG_1605 : ESM_BKG_1605 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1605() {
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
var prefix1 = "sheet1_";

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
    sheetCnt = sheetObjects.length ;

//    //IBMultiCombo 초기화
//    comboCnt = comboObjects.length;
//    for(var k=0;k<comboCnt;k++){
//        initCombo(comboObjects[k],k+1);
//    }
    
    //IBSheet 초기화
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
    }
    
    sheet1.WaitImageVisible = false;
//    sheet1.ColBackColor(prefix1 + "bkg_no") = sheet1.ColBackColor(prefix1 + "ctrt_pty_nm");
	
    //html컨트롤 이벤트초기화    
	axon_event.addListenerForm('click', 'obj_click', form);	 
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');    	    	
    
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    
    sheet1.WaitImageVisible = true;
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
	            style.height = 340;
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
	            var HeadTitle1 = "| |BKG No.|Contract|Contract|Contract Party|Shipper|Shipper|Consignee|Consignee|Actual\nCustomer|Actual\nCustomer|" +
	            		"T-VVD|Volume|Partial|POR|POL|POD|DEL|TERM|TERM|Special|Special|Special|Special|Special|Special|POL ETD|Appl. Date|Scope|Term|Container\nConfirm|" +
	            		"Rating|Self Audit|Result|Reason|External Remark|S/C Note|Conversion\nComplete|Self\nCheck|cmdt_cd|bdr_flg|trf_itm_no|note_rt_seq|prop_no|amdt_seq|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|bl_no|sc_val_flg";
	            var HeadTitle2 = "| |BKG No.|Type|Number|Contract Party|Code|Name|Code|Name|Actual\nCustomer|Actual\nCustomer|" +
	            		"T-VVD|Volume|Partial|POR|POL|POD|DEL|R|D|DG|RF|AK|BB|RD|HG|POL ETD|Appl. Date|Scope|Term|Container\nConfirm|" +
	            		"Rating|Self Audit|Result|Reason|External Remark|S/C Note|Conversion\nComplete|Self\nCheck|cmdt_cd|bdr_flg|trf_itm_no|note_rt_seq|prop_no|amdt_seq|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|bl_no|sc_val_flg";
	           
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	            
	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, true, true, false, false);
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);
	            
	            

				//데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX		            
				
				
				//InitDataProperty(0, cnt++ , dtDummyCheck,	40,	daCenter,	false,	"chk",					false,	"",  dfNone,	0,	true     ,true );
	            InitDataProperty(0, cnt++, dtHiddenStatus,	30,	   daCenter, 	true,	prefix1 + "ibflag");
	            InitDataProperty(0,	cnt++, dtCheckBox,      20,	   daCenter,	true,	prefix1 + "chk",                false,    "",	   dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtPopup,			110,   daCenter,    true,   prefix1 + "bkg_no",             false,    "",      dfNone,      0,    true,     true);
	            InitDataProperty(0, cnt++, dtCombo,			50,    daCenter,    true,   prefix1 + "bkg_ctrt_tp_cd",     false,    "",      dfNone,      0,    false,    false);
	            InitDataProperty(0, cnt++, dtPopup,			100,   daCenter,    true,   prefix1 + "ctrt_no",            false,    "",      dfNone,      0,    true,     true);
	            InitDataProperty(0, cnt++, dtData,			150,   daLeft,      true,   prefix1 + "ctrt_pty_nm",        false,    "",      dfNone,      0,    false,    false);
				
	            
	            InitDataProperty(0, cnt++, dtData,			75,    daCenter,    true,   prefix1 + "shpr_cd",            false,    "",      dfDateYmd,   0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			150,   daLeft,      true,   prefix1 + "shpr_nm",            false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			75,    daCenter,    true,   prefix1 + "cnee_cd",            false,    "",      dfDateYmd,   0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			150,   daLeft,      true,   prefix1 + "cnee_nm",            false,    "",      dfNone,      0,    false,    false);

				InitDataProperty(0, cnt++, dtData,			75,    daCenter,    true,   prefix1 + "act_cust_cd",        false,    "",      dfDateYmd,   0,    false,    false);
				InitDataProperty(0, cnt++, dtHidden,		150,   daLeft,      true,   prefix1 + "act_cust_nm",        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			75,    daCenter,    true,   prefix1 + "t_vvd",              false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			130,   daLeft,      true,   prefix1 + "bkg_cz_desc",        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			60,	   daCenter,    true,	prefix1 + "cntr_prt_flg",	    false,	  "",      dfNone,      0,    false,    false);
				
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   prefix1 + "por_cd",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   prefix1 + "pol_cd",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   prefix1 + "pod_cd",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   prefix1 + "del_cd",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			25,    daCenter,    true,   prefix1 + "rcv_term_cd",        false,    "",      dfNone,      0,    false,    false);
				
				InitDataProperty(0, cnt++, dtData,			25,    daCenter,    true,   prefix1 + "de_term_cd",         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			25,	   daCenter,    true,	prefix1 + "dcgo_flg",	        false,	  "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			25,	   daCenter,    true,	prefix1 + "rc_flg",	            false,	  "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			25,	   daCenter,    true,	prefix1 + "awk_cgo_flg",	    false,	  "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			25,	   daCenter,    true,	prefix1 + "bb_cgo_flg",	        false,	  "",      dfNone,      0,    false,    false);
				
				InitDataProperty(0, cnt++, dtData,			25,	   daCenter,    true,	prefix1 + "rd_cgo_flg",	        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			25,	   daCenter,    true,	prefix1 + "hngr_flg",	        false,	  "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			80,	   daCenter,    true,	prefix1 + "pol_etd_dt",	        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			75,    daCenter,    true,   prefix1 + "rt_aply_dt",         false,    "",      dfDateYmd,   0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			45,    daCenter,    true,   prefix1 + "svc_scp_cd",         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtCombo,			60,	   daCenter,    true,	prefix1 + "frt_term_cd",	    false,	  "",      dfNone,      0,	  true,	    true);
				InitDataProperty(0, cnt++, dtCombo,			80,	   daCenter,    true,	prefix1 + "cntr_cfm_sts_cd",    false,	  "",      dfNone,      0,    false,    false);
	            InitDataProperty(0, cnt++, dtCombo,			60,	   daCenter,    true,	prefix1 + "rat_flg",	        false,    "",      dfNone,      0,    false,    false);
	            InitDataProperty(0, cnt++, dtPopup,			60,	   daCenter,    true,	prefix1 + "aud_sts_cd",	        false,    "",      dfNone,      0,    true,     true);
	            InitDataProperty(0, cnt++, dtCombo,			60,	   daCenter,    true,	prefix1 + "grp_rat_rslt_cd",	false,    "",      dfNone,      0,    false,    false);
				
				InitDataProperty(0, cnt++, dtCombo,			90,	   daCenter,    true,	prefix1 + "grp_rat_fail_rsn_cd",false,	  "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			150,   daLeft,      true,	prefix1 + "xter_rmk",	        false,	  "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtPopup,			60,	   daCenter,    true,	prefix1 + "sc_note",	        false,	  "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			70,	   daCenter,    true,	prefix1 + "conv_cfm_flg",	    false,	  "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtCheckBox,		60,	   daCenter,    true,	prefix1 + "grp_rat_chk_flg",	false,	  "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtHidden,		45,    daCenter,    true,   prefix1 + "cmdt_cd",            false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtHidden,		45,    daCenter,    true,   prefix1 + "bdr_flg",            false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtHidden,		45,    daCenter,    true,   prefix1 + "trf_itm_no",         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtHidden,        70,	   daCenter,    true,	prefix1 + "note_rt_seq",	    false,	  "",      dfNone,      0,	  false,	false);
				InitDataProperty(0, cnt++, dtHidden,        70,	   daCenter,    true,	prefix1 + "prop_no",	        false,	  "",      dfNone,      0,	  false,	false);
				InitDataProperty(0, cnt++, dtHidden,        70,	   daCenter,    true,	prefix1 + "amdt_seq",	        false,	  "",      dfNone,      0,	  false,	false);
				InitDataProperty(0, cnt++, dtHidden,        70,	   daCenter,    true,	prefix1 + "gen_spcl_rt_tp_cd",  false,	  "",      dfNone,      0,	  false,	false);
				InitDataProperty(0, cnt++, dtHidden,        70,	   daCenter,    true,	prefix1 + "cmdt_hdr_seq",	    false,	  "",      dfNone,      0,	  false,	false);
				InitDataProperty(0, cnt++, dtHidden,        70,	   daCenter,    true,	prefix1 + "rout_seq",	        false,	  "",      dfNone,      0,	  false,	false);
				InitDataProperty(0, cnt++, dtHidden,        70,	   daCenter,    true,	prefix1 + "bl_no",	            false,	  "",      dfNone,      0,	  false,	false);
				InitDataProperty(0, cnt++, dtHidden,        70,	   daCenter,    true,	prefix1 + "sc_val_flg",         false,	  "",      dfNone,      0,	  false,	false);
							

                ShowButtonImage = 2;
                

//                UnEditableColor = RgbColor(255,255,255);
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
* @author 김대호
* @version 2010.01.19
*/ 
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
		// Contract type
        case "bkg_ctrt_tp_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
				UseAutoComplete = true;
            	ValidChar(2, 2);    // 영문대문자만 입력 + 특수문자
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
	        
			case "btn_vvd":
				var param = "";
	    		param = param + "&" + "vvd_cd=" + form.t_vvd.value;
	    		ComOpenPopup('/hanjin/COM_ENS_0B2.do?' + param, 780, 470, 'setCallBackVVD', '1,0,1,1,1,1,1,1', true);
				break;
				
	    	case "btn_retrieve":
	    		if (validateForm(sheet1, form, IBSEARCH)) {
	    			ComOpenWait(true);
	    			sheet1.WaitImageVisible = false;
	    			doActionIBSheet(sheet1, form, IBSEARCH);
	    			ComOpenWait(false);
	    		}
	    		break;
	    		
	    	case "btn_new":
	    		ComResetAll();
	    		setNew();
	    		break;
	    		
	    	case "btn_downexcel":
	    		doActionIBSheet(sheet1, form, IBDOWNEXCEL);
	    		break;
	    		
	    	case "btn_save":
				doActionIBSheet(sheet1,form,IBSAVE);
	    		break;
	    		
	    	case "btn_autorating":
				doActionIBSheet(sheet1,form,COMMAND01);
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
	case prefix1 + "xter_rmk":
  		ComShowMemoPad(sheetObj,Row,Col,true,200,200); 
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
//			var classNm = "input";
//			if(formObj.value.length < formObj.maxLength) {
//				classNm = "input1";
//			}
//			form.fm_dt.className = classNm;
//			form.to_dt.className = classNm;
			break;
		case "bkg_no":
		case "ctrt_srep_cd":
		case "cust_seq":
		case "ob_srep_cd":
			break;
		case "ctrt_no":
//			var ctrtTpCd = form.bkg_ctrt_tp_cd;
//			if("" != formObj.value) {
//				ctrtTpCd.className = "mult_combo1";
//				ctrtTpCd.BackColor = "#CCFFFD";
//			}else{
//				ctrtTpCd.className = "mult_combo";
//				ctrtTpCd.BackColor = "#FFFFFF";
//			}
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
function setCallBackVVD(aryPopupData) {
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
		
		
	 	switch(colName){
	 		case prefix1 + "bkg_no":
	 			var bkg_no 	   = sheet1.CellValue(Row, prefix1 + "bkg_no");   
		    	if(null == bkg_no || "" == bkg_no) { return; }
		    	var popParams = "bkg_no=" + bkg_no + "&openTab=B8";
		    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1605", popParams, "");
				break;
	 	
			case prefix1 + "ctrt_no":
				var ctrt_tp_cd   = sheet1.CellValue(Row, prefix1 + "bkg_ctrt_tp_cd");
				var ctrt_no = sheet1.CellValue(Row, prefix1 + "ctrt_no");
				var rt_aply_dt = sheet1.CellValue(Row, prefix1 + "rt_aply_dt");
				var cmdt_hdr_seq = sheet1.CellValue(Row, prefix1 + "cmdt_hdr_seq");
				var rout_seq = sheet1.CellValue(Row, prefix1 + "rout_seq");
				var svc_scp_cd = sheet1.CellValue(Row, prefix1 + "svc_scp_cd");
				var gen_spcl_tp = sheet1.CellValue(Row, prefix1 + "gen_spcl_rt_tp_cd");
				var trf_itm_no = sheet1.CellValue(Row, prefix1 + "trf_itm_no");
				
				
				var ctrtType;
				if(ctrt_tp_cd == "S") ctrtType = 'sc';
				if(ctrt_tp_cd == "R") ctrtType = 'rfa';
				if(ctrt_tp_cd == "T") ctrtType = 'taa';
				var param = param + "&f_cmd=" + SEARCH02 + "&ctrtType=" + ctrtType+"&ctrtNo=" + ctrt_no+"&applicationDate=" + rt_aply_dt ;
		        var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0079_08GS.do", param);		        
		        var amdt_seq = ComGetEtcData(sXml, "amdt_seq");		        
		        if(amdt_seq == '' || amdt_seq == null || amdt_seq == 'null' || amdt_seq == undefined || amdt_seq == 'undefined'){
					ComShowCodeMessage("BKG08204");//"The duration in contract does not matched with booking. please check application date.";
					return false;
				}
				
				
				if(ctrt_tp_cd == "S"){
					ComOpenWindowCenter("ESM_PRI_0087.do?sc_no="+ctrt_no+"&amdt_seq="+amdt_seq+"&s_cmdt_hdr_seq="+cmdt_hdr_seq
							 +"&s_rout_seq="+rout_seq+"&s_svc_scp_cd="+svc_scp_cd+"&s_gen_spcl_rt_tp_cd="+gen_spcl_tp, "", '1024', '700', false, "yes");

				} else if(ctrt_tp_cd == "R"){
					if(ctrt_no.substring(5,6) =="G"){
						ComOpenWindowCenter("ESM_PRI_2120.do?s_rfa_no="+ctrt_no+"&s_amdt_seq="+amdt_seq+"&s_cmdt_hdr_seq="+cmdt_hdr_seq
								 +"&s_rout_seq="+rout_seq+"&s_svc_scp_cd="+svc_scp_cd, "", '1024', '700', false, "yes");	
					} else {
						ComOpenWindowCenter("ESM_PRI_2020.do?s_rfa_no="+ctrt_no+"&s_amdt_seq="+amdt_seq+"&s_cmdt_hdr_seq="+cmdt_hdr_seq
								 +"&s_rout_seq="+rout_seq+"&s_svc_scp_cd="+svc_scp_cd, "", '1024', '700', false, "yes");	
					}
				} else {
					ComOpenWindowCenter("ESM_PRI_3019.do?taa_no="+ctrt_no+"&amdt_seq="+amdt_seq+"&s_tri_no="+trf_itm_no, "", '1024', '700', false, "yes");
				}
				
				break;
				
			case prefix1 + "sc_note":
                //SC Note는 Rating 완료 후 
				var _Width = '1000';
				var _Height = '500';
				var pgmNo = "&pgmNo=ESM_BKG_0270";
				
				var svc_scp_cd =  sheet1.CellValue(Row, prefix1 + "svc_scp_cd");   
				var bkg_no = sheet1.CellValue(Row, prefix1 + "bkg_no");   
				var sc_no = sheet1.CellValue(Row, prefix1 + "ctrt_no");
				var ctrt_tp_cd   = sheet1.CellValue(Row, prefix1 + "bkg_ctrt_tp_cd");
				var rt_aply_dt = sheet1.CellValue(Row, prefix1 + "rt_aply_dt");
				var note_rt_seq = sheet1.CellValue(Row, prefix1 + "note_rt_seq");
				var prop_no = sheet1.CellValue(Row, prefix1 + "prop_no");
				var amdt_seq = sheet1.CellValue(Row, prefix1 + "amdt_seq");
				var svc_scp_cd = sheet1.CellValue(Row, prefix1 + "svc_scp_cd");
				var gen_spcl_rt_tp_cd = sheet1.CellValue(Row, prefix1 + "gen_spcl_rt_tp_cd");
				var cmdt_hdr_seq = sheet1.CellValue(Row, prefix1 + "cmdt_hdr_seq");
				var rout_seq = sheet1.CellValue(Row, prefix1 + "rout_seq");
				
				/* 2010.1.21 Prop No, Seq, ScpCd 없을경우 Note 팝업을 오픈 하지 않는다 */
				if(ctrt_tp_cd != 'S') {
					return;
				}
				if((prop_no+amdt_seq+svc_scp_cd).length <= 0 | prop_no+amdt_seq+svc_scp_cd =='') return;
				
				var param = 
				'bkg_no=' + bkg_no + 
				'&application_date=' + rt_aply_dt + 
				'&sc_no=' + sc_no + 
				'&svc_scp_cd=' + svc_scp_cd + 
				'&note_rt_seq=' + note_rt_seq + 
				'&prop_no=' + prop_no +
				'&amdt_seq=' + amdt_seq + 
				'&gen_spcl_rt_tp_cd=' +gen_spcl_rt_tp_cd +
				'&cmdt_hdr_seq=' + cmdt_hdr_seq + 
				'&rout_seq=' + rout_seq;
				var url = "ESM_BKG_0270.do?" + param + pgmNo;
				ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
				break;
				
		 	case prefix1 + "aud_sts_cd":
		 		var _Width = '1000';
				var _Height = '728';
				var pgmNo = "&pgmNo=ESM_BKG_0263";
				var popParams = "bl_no="+sheet1.CellValue(Row, prefix1 + "bkg_no") +"&ca_flg=N"; 
				var url = "ESM_BKG_0263.do?" + popParams + pgmNo;
				ComOpenPopupWithTarget(url, _Width, _Height, "","none",false);
		 		break;
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
//    var ctrtTpCd = form.bkg_ctrt_tp_cd;
//    ctrtTpCd.Code = gCtrtTpCdDefault;
//    ctrtTpCd.BackColor = "#FFFFFF";
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
	var aryPrefix = new Array(prefix1);
         
	switch(sAction) {
	
	case IBCLEAR: // 화면 로딩시 코드 조회
	    formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1605GS.do", FormQueryString(formObj));
		
		var arrXml = sXml.split("|$$|");
		ComXml2ComboItem(arrXml[0], formObj.grp_rat_rslt_cd, "val", "name");
		formObj.grp_rat_rslt_cd.InsertItem(0, 'All',' ');
		formObj.grp_rat_rslt_cd.index = 0;

		ComXml2ComboItem(arrXml[4], formObj.rat_flg, "val", "name");
		formObj.rat_flg.InsertItem(0, 'All',' ');
		formObj.rat_flg.index = 0;
		
		ComXml2ComboItem(arrXml[4], formObj.sc_note, "val", "name");
		formObj.sc_note.InsertItem(0, 'All',' ');
		formObj.sc_note.index = 0;
		
		ComXml2ComboItem(arrXml[4], formObj.grp_rat_chk_flg, "val", "name");
		formObj.grp_rat_chk_flg.InsertItem(0, 'All',' ');
		formObj.grp_rat_chk_flg.index = 0;		

		ComXml2ComboItem(arrXml[5], formObj.cntr_cfm_sts_cd, "val", "name");
		formObj.cntr_cfm_sts_cd.InsertItem(0, 'All',' ');
		formObj.cntr_cfm_sts_cd.index = 0;

		setIBCombo(sheetObj, arrXml[4], prefix1 + "rat_flg", true, "", "","","name");
		setIBCombo(sheetObj, arrXml[0], prefix1 + "grp_rat_rslt_cd", true, "", "","","name");
		setIBCombo(sheetObj, arrXml[1], prefix1 + "bkg_ctrt_tp_cd", true, "", "","","name");
		setIBCombo(sheetObj, arrXml[2], prefix1 + "frt_term_cd", false, "", "","","name");
		setIBCombo(sheetObj, arrXml[3], prefix1 + "grp_rat_fail_rsn_cd", true, "", "","","name");
		setIBCombo(sheetObj, arrXml[5], prefix1 + "cntr_cfm_sts_cd", true, "", "","","name");
			
		sheetObj.DataAutoTrim = true;	

		
	   break;
    case IBSEARCH: //조회
    	formObj.f_cmd.value = SEARCH;
    	ComOpenWait(true); // 대기창 보임
    	var sXml = sheetObj.GetSearchXml("ESM_BKG_1605GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

		var arrXml = sXml.split("|$$|");
		var State = ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
		if ( State == "S" ) {
			for ( var inx = 0; inx < arrXml.length; inx++) {
				sheetObjects[inx].LoadSearchXml(arrXml[inx]);
			}
		}
		ComOpenWait(false); 
		break;
		
	case IBDOWNEXCEL:      //download excel
	    sheet1.SpeedDown2Excel(-1); //, "chk|seq"
		break;
		
	case IBSAVE:		//저장
		if(sheetObj.RowCount("U") == 0){
			ComShowCodeMessage("BKG00989"); 
			return false;
		}
		
		if(!validateForm(sheetObj,document.form,IBSAVE)) {
			return false;
		}
		formObj.f_cmd.value = MULTI01;
		var sParam = FormQueryString(formObj);
		var sParamSheet1 = sheet1.GetSaveString();
		sParam += "&" + sParamSheet1;
		ComOpenWait(true);
		
		var sXml = sheet1.GetSaveXml("ESM_BKG_1605GS.do", sParam);
		sheet1.LoadSaveXml(sXml);
		ComOpenWait(false);        		

		if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
			ComShowCodeMessage("BKG95033"); // "Saved."
		}
		doActionIBSheet(sheet1, form, IBSEARCH);
		break;
		
	case COMMAND01: //Autorating
		if (sheetObj.CheckedRows(prefix1 + "chk") == 0) {
			ComShowMessage(msgs['BKG00567']);
			return false;
		}
		if (sheetObj.CheckedRows(prefix1 + "chk") > 100) {
			ComShowCodeMessage("BKG08325", "100");
			return false;
		}
		if(!validateForm(sheetObj,document.form,IBSAVE)) {
			return false;
		}
		
		formObj.f_cmd.value = MULTI02;
		
		var sParam = FormQueryString(formObj);
		var sParamSheet1 = sheet1.GetSaveString();
		sParam += "&" + sParamSheet1;
		ComOpenWait(true);
		
		var sXml = sheet1.GetSaveXml("ESM_BKG_1605GS.do", sParam);
		sheet1.LoadSaveXml(sXml);
		ComOpenWait(false);        		

		if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
			ComShowCodeMessage("BKG95033"); // "Saved."
		}
		doActionIBSheet(sheet1, form, IBSEARCH);
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

		var fromAddDays = ComGetDateAdd(fmDtValue, "D", 6, "", true); // 31일
		if( !vvdBool && ( parseInt(toDtValue,10) > parseInt(fromAddDays,10) ) ) {
			ComShowCodeMessage("BKG95027", "7 days"); // "The period of Date can't be over {?msg1}."
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
	
	var fmDtObj   = form.fm_dt;	
	var toDtObj   = form.to_dt;
	var fmDtValue = fmDtObj.value;	
	var toDtValue = toDtObj.value;
	var vvdObj    = form.t_vvd;
	var ctrtTyObj = form.bkg_ctrt_tp_cd;
	var ctrtNoObj = form.ctrt_no;
	
    switch (sAction) {
	    
    	case IBSEARCH: //조회
    	
    		if(!ComChkObjValid(fmDtObj)) { return false; }
    		if(!ComChkObjValid(toDtObj)) { return false; }

    		if("" == vvdObj.value && ("" == fmDtValue || "" == toDtValue)) {
    			if(!ComIsNull(formObj.bkg_no)){
    				return true;
    			} else {
    				ComShowCodeMessage("BKG95025", "Date or T/VVD"); // "Please input {?msg1}."
      				 return false;
   				 
    			}
				 
			}
    		
			if(!chkDate(fmDtObj)) { return false; }
			if(!chkDate(toDtObj)) { return false; }
			
			if(
					ComIsNull(formObj.ctrt_no) 	&&
					ComIsNull(formObj.cust_cnt_cd) &&
					ComIsNull(formObj.cust_seq) &&
					ComIsNull(formObj.por_cd) &&
					ComIsNull(formObj.pol_cd) &&
					ComIsNull(formObj.pod_cd) &&
					ComIsNull(formObj.del_cd) &&
					ComIsNull(formObj.bkg_ofc_cd) &&
					ComIsNull(formObj.doc_usr_id) &&
					ComIsNull(formObj.bkg_no) &&
					ComIsNull(formObj.ctrt_ofc_cd) &&
					ComIsNull(formObj.ctrt_srep_cd) &&
					ComIsNull(formObj.ob_sls_ofc_cd) &&
					ComIsNull(formObj.ob_srep_cd)
					){
				
				ComShowCodeMessage("BKG08346");  
				return false;
			}

			if(!ComIsNull(formObj.cust_seq)){
				if(!ComIsNumber(formObj.cust_seq)){
		 			ComShowCodeMessage("BKG00340");
					formObj.cust_seq.focus();
					return false;
				}
			}


			if(!ComIsNull(formObj.cust_cnt_cd) || !ComIsNull(formObj.cust_seq)){
				if(formObj.bkg_cust_tp_cd.value == ""){
		 			ComShowCodeMessage("BKG95062");
					formObj.bkg_cust_tp_cd.focus();
					return false;
				}
			}
			
	    	break;
	    	
    	case IBSAVE: // 저장, Autorating
    		for (var idx=2; idx < sheetObj.RowCount+2; idx++){
    			if('U' == sheetObj.CellValue(idx, prefix1 + "ibflag") && 'Y' == sheetObj.CellValue(idx, prefix1 + "rc_flg") && sheetObj.CellValue(idx, prefix1 + "frt_term_cd") != 'P'){
    				ComShowCodeMessage("BKG08131");
    				sheetObj.SelectCell(idx, prefix1 + "frt_term_cd");
    				return false;
    				
    			}
    			if('U' == sheetObj.CellValue(idx, prefix1 + "ibflag") && 'Y' == sheetObj.CellValue(idx, prefix1 + "hngr_flg") && sheetObj.CellValue(idx, prefix1 + "frt_term_cd") != 'P'){
    				ComShowCodeMessage("BKG08131");
    				sheetObj.SelectCell(idx, prefix1 + "frt_term_cd");
    				return false;
    			}
    		}
    		
    		break;
	    	
    }

    return true;
    
}


/**
 * Sheet관련 컬럼 OnChange 엑션 이벤트 처리 
 * @param sheetObj, Row, Col, Value
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (sheetObj.ColSaveName(Col) == prefix1 + "frt_term_cd") {
		// 1.부킹 Main에 Reefer 이면 OFT 는 PPD 이어야 함
		if('Y' == sheetObj.CellValue(Row, prefix1 + "rc_flg") && sheetObj.CellValue(Row, prefix1 + "frt_term_cd") != 'P'){
			ComShowCodeMessage("BKG08131");
			sheetObj.CellValue(Row, prefix1 + "frt_term_cd") = 'P';
		}
		//2.부킹 Main에 Hanger 이고 Charge code가 GOH 는 PPD 이어야 함
		if('Y' == sheetObj.CellValue(Row, prefix1 + "hngr_flg") && sheetObj.CellValue(Row, prefix1 + "frt_term_cd") != 'P'){
			ComShowCodeMessage("BKG08133");
			sheetObj.CellValue(Row, prefix1 + "frt_term_cd") = 'P';
		}
	}
	
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

	sheetObj.ColBackColor(prefix1 + "bkg_no") = sheetObj.RgbColor(239,240,243);
	sheetObj.ColBackColor(prefix1 + "ctrt_no") = sheetObj.RgbColor(239,240,243);
	sheetObj.ColBackColor(prefix1 + "sc_note") = sheetObj.RgbColor(239,240,243);
	
	for (var idx=2; idx < sheetObj.RowCount+2; idx++){
		
		if(sheetObj.CellValue(idx, prefix1 + "bdr_flg") == "Y"
			|| sheetObj.CellValue(idx, prefix1 +"svc_scp_cd") == ""
			|| sheetObj.CellValue(idx, prefix1 +"rt_aply_dt") == "")
		{
			sheetObj.CellEditable(idx, prefix1 +"chk") = false;
		}
		
		if(sheetObj.CellValue(idx, prefix1 +"sc_note") == 'Y'){
			sheetObj.CellFontColor(idx, prefix1 +"sc_note") = sheetObj.RgbColor(0, 0, 255);
		}
		
		if(sheetObj.CellValue(idx, prefix1 +"grp_rat_rslt_cd") == 'S'
			&& sheetObj.CellValue(idx, prefix1 +"aud_sts_cd") != 'N' ){
			sheetObj.CellEditable(idx, prefix1 + "grp_rat_chk_flg") = true;
		}
		
		if(sheetObj.CellValue(idx, prefix1 +"bkg_ctrt_tp_cd") == 'S' && sheetObj.CellValue(idx, prefix1 +"sc_val_flg") == 'N'){
			sheetObj.CellFontColor(idx, prefix1 +"ctrt_no") = sheetObj.RgbColor(255, 0, 0);
		}
	}
}   
function changeCtrtOfcCdSub(obj) {
	var formObj = document.form;
	if (obj.checked) {
		document.form.ctrt_ofc_cd_sub.value = "Y";
	} else {
		document.form.ctrt_ofc_cd_sub.value = "N";
	}    			
}

function changeObSlsOfcCdSub(obj) {
	var formObj = document.form;
	if (obj.checked) {
		document.form.ob_sls_ofc_cd_sub.value = "Y";
	} else {
		document.form.ob_sls_ofc_cd_sub.value = "N";
	}    			
}
