/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_BKG_1422.js
*@FileTitle : WSC BKG List for Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2011.07.25 조정민
* 1.0 Creation
=========================================================*/
/**
 * @extends  
 * @class ESM_BKG_1422 : ESM_BKG_1422 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1422() {
	this.setSheetObject			= setSheetObject;
	this.setComboObject		= setComboObject;	
	this.loadPage				= loadPage;
	this.initSheet					= initSheet;
	this.initCombo				= initCombo;
	this.obj_click					= obj_click;
	this.obj_keypress			= obj_keypress;
	this.obj_deactivate			= obj_deactivate;
	this.processButtonClick		= processButtonClick;
	this.doActionIBSheet		= doActionIBSheet;
}
    
//===================================================================================
//전역변수
//===================================================================================
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1;

var comboObjects = new Array();
var comboCnt = 0;
//업무전역변수
var gCurrDate;
var gXml = "";


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
* @author 조정민
* @version 2016.04.15
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
* @author 조정민
* @version 2016.04.15
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
* @author 조정민
* @version 2016.04.15
*/ 
function loadPage() {
	
	var form = document.form;	
    sheet1 = sheetObjects[0];
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
    
    sheet1.WaitImageVisible = false;
    sheet1.CountPosition =0;
	
    //html컨트롤 이벤트초기화    
	axon_event.addListenerForm('click', 'obj_click', form);	 
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');    	    	
    
	gCurrDate = ComGetNowInfo('ymd', '-');
	form.from_dt.value = gCurrDate;
	form.to_dt.value = gCurrDate;
    
	for(var i = 0; i < form.length; i++){
		var chkEl = form.elements[i];
 		var chkYN = "N";
		if(chkEl.id == "chk_sub_exclusion") {
	 		if(chkEl.checked) { chkYN = "Y"; }
	 		eval("form."+chkEl.name.substr(4)).value = chkYN;
		}
	}
    
	initIBComboItem();
    
    sheet1.WaitImageVisible = true;
    
    setNew()
    
}

/**
 * OnKeyPress event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_keypress()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */ 
function obj_activate() {
	ComClearSeparator (event.srcElement);	   
}

/**
 * Onbeforedeactivate  event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_deactivate()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */ 
function obj_deactivate() {
    ComChkObjValid(event.srcElement);
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
* @author 조정민
* @version 2016.04.15
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
* @author 조정민
* @version 2016.04.15
 * @version 2010.01.19
 */
function initIBComboItem() {
    ComBkgTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'), "|", "\t" );   
    ComBkgTextCode2ComboItem(rTermComboValue,      rTermComboText,      getComboObject(comboObjects, 'rcv_term_cd'), 	"|", "\t" );
    ComBkgTextCode2ComboItem(dTermComboValue,      dTermComboText,      getComboObject(comboObjects, 'de_term_cd'),  	"|", "\t" );
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
* @author 조정민
* @version 2016.04.15
*/ 
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	var sheetID = sheetObj.id;
   
	switch(sheetID) {
			
		case "sheet1":
	      	with (sheet1) {
		            //높이 설정
		            style.height = 420;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		           
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            
		            //전체Merge 종류 [선택, Default msNone]
		           //MergeSheet = msAll; 
		            MergeSheet = msPrevColumnMerge + msHeaderOnly;
		            //전체Edit 허용 여부 [선택, Default false]
		           
		           Editable = true;
		           
		           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(3, 1, 10, 100);
	                var HeadTitle1 = "BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|BKG|W/O|W/O|W/O|W/O|W/O|W/O|W/O|W/O|W/O|W/O|TPB|TPB|TPB|TPB|TPB|TPB|BkgCnt";
	                var HeadTitle2 = "BKG|R/D Term|R/D Term|Scope|POR|POL|POD|DEL|Contract No|CNTR TPSZ|WSC Charge|WSC Charge|BKG|CNTR TPSZ|CNTR No|Trans Sercive\nOrder Type|Trans\nCarrier Mode|From|To|W/O No|Instruction|W/O Issue Date|BKG|Exp Type|Exp Type|TPB No|Curr|Amount|BkgCnt";
	                var HeadTitle3 = "BKG|Rcv|De|Scope|POR|POL|POD|DEL|Contract No|CNTR TPSZ|Curr|Amount|BKG|CNTR TPSZ|CNTR No|Trans Sercive\nOrder Type|Trans\nCarrier Mode|From|To|W/O No|Instruction|W/O Issue Date|BKG|Main|Sub|TPB No|Curr|Amount|BkgCnt";
		           
	                var headCount = ComCountHeadTitle(HeadTitle1);

		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, false);
		            
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            InitHeadRow(1, HeadTitle2, true);
		            InitHeadRow(2, HeadTitle3, true);
		                        
		            //데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX	
//					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter, 	true,	"ibflag");
					InitDataProperty(0, cnt++, dtData,    120,	daCenter,		true,   "bkg_no",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     35,	daCenter,		true,   "rcv_term_cd",			false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     35,	daCenter,		true,   "de_term_cd",			false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     45,	daCenter,		true,   "svc_scp_cd",			false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData  ,   50,	daCenter,		true,   "por_cd",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     50,	daCenter,		true,   "pol_cd",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     50,	daCenter,		true,   "pod_cd",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,	   50,	daCenter,		true,	"del_cd",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,    100,	daCenter,		true,   "ctrt_no",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     70,	daCenter,		true,   "rat_ut_cd",			false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,	   35,	daCenter,		true,	"curr_cd",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,	  150,	daRight,		true,	"chg_amt",				false,	"",      dfFloat,		2,	  false,	false);
					InitDataProperty(0, cnt++, dtData,	  120,	daCenter,		true,   "trs_bkg_no",			false,	"",      dfNone,	    0,	  false,    false);
					InitDataProperty(0, cnt++, dtData,     70,	daCenter,		true,   "eq_tpsz_cd",			false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,	  120,	daCenter,		true,	 "eq_no",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,    100,	daCenter,		true,   "trsp_cost_dtl_mod",	false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,    100,	daCenter,		true,   "trsp_crr_mod_cd",		false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     60,	daCenter,		true,   "fm_nod_cd",			false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     60,	daCenter,		true,   "to_nod_cd",			false,	"",      dfNone,      0,    false,    false);
					

					InitDataProperty(0, cnt++, dtData,     80,	daCenter,		true,   "wo_no",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,    200,	daLeft,			true,   "wo_rmk",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,    120,	daCenter,		true,   "locl_cre_dt",			false,	"",      dfNone,	    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,    120,	daCenter,		true,   "tpb_bkg_no",			false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     35,	daCenter,		true,   "main",					false,	"",      dfNone,	    0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     65,	daCenter,		true,   "sub",					false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,    100,	daCenter,		true,   "n3pty_no",				false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,     35,	daCenter,		true,   "cfm_curr_cd",			false,	"",      dfNone,      0,    false,    false);
					InitDataProperty(0, cnt++, dtData,    120,	daRight,		true,   "inv_amt",				false,	"",      dfFloat,		2,    false,    false);
					InitDataProperty(0, cnt++, dtHidden,   40,	daCenter,		true,	"bkg_cnt",				false,	"",		 dfNone,		0,	  false,	false);

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
* @author 조정민
* @version 2016.04.15
*/ 
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
		// Scope
		case "svc_scp_cd":
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
* @author 조정민
* @version 2016.04.15
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
	        	
	        case "btns_calendar2": //달력버튼
	        	var cal = new ComCalendar();
	        	cal.select(form.to_dt, 'yyyy-MM-dd');
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
* @author 조정민
* @version 2016.04.15
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
* Object 의 Onbeforedeactivate 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다. <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 조정민
* @version 2016.04.15
*/ 
//function obj_deactivate() {
//	var form = document.form;
//	var formObj = event.srcElement;
//    var srcName = formObj.getAttribute("name");
//    switch(srcName) {
//		case "ctrt_no":
//			var ctrtTpCd = form.bkg_ctrt_tp_cd;
//			if("" != formObj.value) {
//				ctrtTpCd.className = "mult_combo1";
//				ctrtTpCd.BackColor = "#CCFFFD";
//			}else{
//				ctrtTpCd.className = "mult_combo";
//				ctrtTpCd.BackColor = "#FFFFFF";
//			}
//			break;
////		default :
////			ComChkObjValid(formObj);
//	}
//
//}


/** 
* 화면 폼입력값에 초기화 하는 setNew <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 조정민
* @version 2016.04.15
*/ 
function setNew() {
	var form = document.form;
   	sheet1.RemoveAll();
	form.search_option.value = "A";
	form.from_dt.value = gCurrDate;
	form.to_dt.value = gCurrDate;
	form.svc_scp_cd.value = "";
	form.rcv_term_cd.value = "";
	form.de_term_cd.value = "";
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
* @author 조정민
* @version 2016.04.15
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	   
	sheet1.ShowDebugMsg = false;
         
	switch(sAction) {
        case IBSEARCH: //조회
        	formObj.f_cmd.value = SEARCH;     	
			var sXml = sheet1.GetSearchXml("ESM_BKG_1422GS.do",FormQueryString(formObj));
			sheet1.LoadSearchXml(sXml);
	 			
 			break;
 			
		case IBDOWNEXCEL:      //download excel
		    sheet1.SpeedDown2Excel(-1); //, "chk|seq"
			//sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
			break;
			
 			
	}
	
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
* @author 조정민
* @version 2016.04.15
*/ 
function validateForm(sheetObj, formObj, sAction){
	
	var form = document.form;
	
	var fmDtObj   = form.from_dt;	
	var toDtObj   = form.to_dt;
	var fmDtValue = fmDtObj.value;	
	var toDtValue = toDtObj.value;
	var svcScpCd = form.svc_scp_cd;
	
    switch (sAction) {
	    
    	case IBSEARCH: //조회
    		    	
	     		if(!ComChkObjValid(fmDtObj)) { return false; }
	    		if(!ComChkObjValid(toDtObj)) { return false; }
	
	     		if("" == fmDtValue || "" == toDtValue){
	    			 ComShowCodeMessage("BKG95025", "Period"); // "Please input {?msg2}."
	    			 if("" == fmDtValue){
	    				 ComSetFocus(fmDtObj);
	    			 }else{
	    				 ComSetFocus(toDtObj);
	    			 }
	    			 return false;
	     		}
	    		
	    		if( "" != fmDtValue && "" != toDtValue && ( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) ) {
	    			 ComShowCodeMessage("BKG95026", "From Date", "To Date");
	    			 ComSetFocus(fmDtObj);
	    			 return false;
	     		}
	
	    		var fromAddDays = ComGetDateAdd(fmDtValue, "D", 31, "", true);
	    		if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
	    			ComShowCodeMessage("BKG95027", "1 Month"); // "The period of Date can't be over {?msg1}."
	    			ComSetFocus(fmDtObj);
	    			return false;
	    		}
	    		
//	    		if(null == svcScpCd.Code || "" == svcScpCd.Code){
//	    			ComShowCodeMessage("BKG95031",'Service Scope');
//	    			event.returnValue = false;
//	    			ComSetFocus(svcScpCd);
//	    			return false;
//	    		}

	    	break;
	    	
    }

    return true;
    
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
* @author 조정민
* @version 2016.04.15
*/ 
function chkDate(formObj) {
	
	var form = document.form;
	
    var fmDtObj  = form.from_dt;
    var toDtObj  = form.to_dt;
	var fmDtValue = fmDtObj.value.replace(/-/g,'');
	var toDtValue = toDtObj.value.replace(/-/g,'');
	
	if(fmDtValue != "" && toDtValue != "") {

		if( parseInt(fmDtValue,10) > parseInt(toDtValue,10) ) {
			ComShowCodeMessage("BKG95026", "From Date", "To Date");
			event.returnValue = false;			
			ComSetFocus(formObj);
			return false;
		}

		var fromAddDays = ComGetDateAdd(fmDtValue, "D", 30, "", true); // 31일
		if( parseInt(toDtValue,10) > parseInt(fromAddDays,10) ) {
			ComShowCodeMessage("BKG95027", "31 days"); // "The period of Date can't be over {?msg1}."
			event.returnValue = false;		
			ComSetFocus(formObj);
			return false;
		}
		
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
    	form.bkg_cnt.value = sheetObj.CellValue(3,"bkg_cnt");
    }else{
    	    	form.bkg_cnt.value = "0";
    }
    
}  
