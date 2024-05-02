/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1423.js
*@FileTitle : India DTH BKG List for Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 조창우
*@LastVersion : 1.0
* 2016.04.29 조창우
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview Audit by CNTR Qty Discrepancy 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESM_BKG_1423:ESM_BKG_1423 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/**
 * @extends  
 * @class ESM_BKG_1423 : ESM_BKG_1423 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1423() {
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
* @author 조창우
* @version 2016.04.29
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
* @author 조창우
* @version 2016.04.29
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
* @author 조창우
* @version 2016.04.29
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
    
    gBkgRhqCd = form.strRhq_ofc_cd.value;
       
	initIBComboItem();
    
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
* @author 조창우
* @version 2016.04.29
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
 * @author 조창우
 * @version 2016.04.29
 */
function initIBComboItem() {
	ComBkgTextCode2ComboItem(rhqComboValue,      rhqComboValue,    getComboObject(comboObjects, 'bkg_rhq_cd'),  "|", "\t" );
    ComBkgTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText,  getComboObject(comboObjects, 'svc_scp_cd'), "|", "\t" );
    ComBkgTextCode2ComboItem(soBndComboValue,    soBndComboValue,  getComboObject(comboObjects, 'so_bnd'),  "|", "\t" );
    ComBkgTextCode2ComboItem(audStsCdComboValue, audStsCdComboText,  getComboObject(comboObjects, 'aud_sts_cd'),  "|", "\t" );
    
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
* @author 조창우
* @version 2016.04.29
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
	            var HeadTitle1 = "|BKG|APPL DATE|bkg_ctrt_tp_cd|Contract|POR|POL|POD|DEL|CNTR|BKG Remark|BKG Remark|Local Shuttle Check|Local Shuttle Check|Local Shuttle Check|OTH:Cur/Rate/Rated As/Per/Amount|DTH:Cur/Rate/Rated As/Per/Amount|NST:Cur/Rate/Rated As/Per/Amount|Audit\nResult|Audit\nDate|RDN No|bl_cnt";
	            var HeadTitle2 = "|BKG|APPL DATE|bkg_ctrt_tp_cd|Contract|POR|POL|POD|DEL|CNTR|External|Internal|SO No|SO From|SO To|OTH:Cur/Rate/Rated As/Per/Amount|DTH:Cur/Rate/Rated As/Per/Amount|NST:Cur/Rate/Rated As/Per/Amount|Audit\nResult|Audit\nDate|RDN No|bl_cnt";
	           
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
				InitDataProperty(0, cnt++, dtPopup,			120,   daCenter,    true,   "bkg_no",            false,    "",      dfNone,      0,    true,     true);
				
				InitDataProperty(0, cnt++, dtData,			75,    daCenter,    true,   "rt_aply_dt",        false,    "",      dfDateYmd,   0,    false,    false);
				InitDataProperty(0, cnt++, dtHidden,		60,    daCenter,    true,   "bkg_ctrt_tp_cd",    false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtPopup,			90,    daCenter,    true,   "ctrt_no",           false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "por_cd",            false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "pol_cd",            false,    "",      dfNone,      0,    true,     true);
				
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "pod_cd",            false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "del_cd",            false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			80,    daCenter,    true,   "cntr_no",           false,    "",      dfNone,      0,    true,     true);
				/**/
				InitDataProperty(0, cnt++, dtData,		   220,    daLeft,      true,   "xter_rmk",          false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,		   220,    daLeft,      true,   "inter_rmk",         false,    "",      dfNone,      0,    false,    false);
				/**/
				InitDataProperty(0, cnt++, dtData,			80,    daCenter,    true,   "so_no",             false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			68,    daCenter,    true,   "fm_nod_cd",         false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			68,    daCenter,    true,   "to_nod_cd",         false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			213,   daLeft,      true,   "oth",               false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			213,   daLeft,      true,   "dth",               false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			213,   daLeft,      true,   "nst",               false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			68,    daCenter,    true,   "aud_sts_cd",        false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			68,    daCenter,    true,   "rev_aud_dt",        false,    "",      dfDateYmd,   0,    true,    true);
				InitDataProperty(0, cnt++, dtData,			70,    daCenter,    true,   "rdn_no",            false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtHidden,		30,	   daCenter,    true,	"ttl_bkg_cnt",	     false,	   "",      dfNone,      0,	   true,	 true);

				

                ShowButtonImage = 2;
                UnEditableColor = RgbColor(255,255,255);
                FrozenCols = 2;

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
* @author 조창우
* @version 2016.04.29
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
* @author 조창우
* @version 2016.04.29
*/ 
function processButtonClick(){
	var form = document.form;
	//var rdoDateObj = form.rdoDate;
	
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
				
	    	case "btn_retrieve":
	    		if (validateForm(sheet1, form, IBSEARCH)) {
	    			ComOpenWait(true);
	    			sheet1.WaitImageVisible = false;
	    			doActionIBSheet(sheet1, form, IBSEARCH);
	    			ComOpenWait(false);
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
* @author 조창우
* @version 2016.04.29
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
  * @author 조창우
  * @version 2016.04.29
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
* @author 조창우
* @version 2016.04.29
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
* @author 조창우
* @version 2016.04.29
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
 * @author 조창우
 * @version 2016.04.29
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
  * @author 조창우                                                                               
  * @version 2016.04.29                                                         
  */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	 	var form = document.form;
	 	var colName = sheet1.ColSaveName(Col);
		var sName      = sheet1.ColSaveName(Col);
		var scRfaNo    = sheet1.CellValue(Row, "ctrt_no");	
		var ctrtTpCd   = sheet1.CellValue(Row, "bkg_ctrt_tp_cd");	
		var bkgNo 	   = sheet1.CellValue(Row, "bkg_no");    	
	 	switch(colName){
	 		case "bkg_no":
		    	if(null == bkgNo || "" == bkgNo) { return; }
		    	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
		    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1423", popParams, "");
				break;
	 	
			case "ctrt_no":
	        	if(null == scRfaNo || "" == scRfaNo) { return; }
	    		var pgmNo = "ESM_PRI_0004";
	    		var scRfaNoP = scRfaNo.substr(0, 3);
	    		var scRfaNoS = scRfaNo.substr(3);
	        	var popParams = "sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS + "&eff_dt=" + form.fm_dt.value + "&exp_dt=" + form.to_dt.value;
		    	if(ctrtTpCd == "R") { // RFA
		    		pgmNo = "ESM_PRI_2019";
		    		popParams = "s_rfa_no=" + scRfaNo;
		    	}
		    	else if(ctrtTpCd == "T") { // TAA
		    		pgmNo = "ESM_PRI_3007";
		    		popParams = "cond_taa_no=" + scRfaNo;  
		    	}
	        	comRASCallPop(pgmNo, "ESM_BKG_1423", popParams, "");
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
* @author 조창우
* @version 2016.04.29
*/ 
function setNew() {
	var form = document.form;
	var rhqObj = form.bkg_rhq_cd;
    rhqObj.Index = "-1";
   	rhqObj.Code = gBkgRhqCd;

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
* @author 조창우
* @version 2016.04.29
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	   
	sheet1.ShowDebugMsg = false;
         
	switch(sAction) {
        case IBSEARCH: //조회
        	formObj.f_cmd.value = SEARCH;
 			sheet1.DoSearch("ESM_BKG_1423GS.do", FormQueryString(formObj));
	 			
 			break;
 			
		case IBDOWNEXCEL:      //download excel
		    sheet1.SpeedDown2Excel(-1); //, "chk|seq"
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
* @author 조창우
* @version 2016.04.29
*/ 
function chkDate(formObj) {
	
	var form = document.form;
	
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
		if( parseInt(toDtValue,10) > parseInt(fromAddDays,10)  ) {
			ComShowCodeMessage("BKG95027", "31 days"); // "The period of Date can't be over {?msg1}."
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
* @author 조창우
* @version 2016.04.29
*/ 
function validateForm(sheetObj, formObj, sAction){	
	var form = document.form;
	
	var rhq       = form.bkg_rhq_cd; 
	var soBnd       = form.so_bnd;
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
    		if(null == soBnd.Code || "" == soBnd.Code){
				ComShowCodeMessage("BKG95031", "Bound");
				event.returnValue = false;
				ComSetFocus(soBnd);
				return false;	
    		}
    		if(!ComChkObjValid(fmDtObj)) { return false; }
    		if(!ComChkObjValid(toDtObj)) { return false; }
    		
			if(!chkDate(fmDtObj)) {  return false; }
			if(!chkDate(toDtObj)) { return false; }
			
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
* @author 조창우
* @version 2010.04.29
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
    var form = document.form;
    if(sheetObj.RowCount > 0){
    	form.bl_cnt.value = sheetObj.CellValue(2,"ttl_bkg_cnt");
    }else{
    	    	form.bl_cnt.value = "0";
    }

}   

