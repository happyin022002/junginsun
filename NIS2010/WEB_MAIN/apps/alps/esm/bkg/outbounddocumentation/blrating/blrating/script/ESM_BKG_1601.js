/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1601.js
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
 * @class ESM_BKG_1601:ESM_BKG_1601 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/**
 * @extends  
 * @class ESM_BKG_1601 : ESM_BKG_1601 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1601() {
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
    sheet1.CountPosition =2;
	
    //html컨트롤 이벤트초기화    
	axon_event.addListenerForm('click', 'obj_click', form);	 
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');    	    	
    
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
	            style.height = 390;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	           
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            
	            //전체Merge 종류 [선택, Default msNone]
//	            MergeSheet = msHeaderOnly;
				MergeSheet =msPrevColumnMerge + msHeaderOnly;
	            
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	           
	           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(2, 1, 2, 100);
	            var HeadTitle1 = "|Seq||Booking No.|seq|Shipper|Shipper|Consignee|Consignee|bkg_ctrt_tp_cd|Contract|Contract Customer|C.Rep|L.Rep|" +
	            		"Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Charge Info|Reason|Remark|Status|rqst_usr_id|Request|Request|Request|rqst_usr_eml|" +
	            		"apro_usr_id|Approval/Reject|Approval/Reject|Approval/Reject|Approval/Reject|auth_flg";
	            var HeadTitle2 = "|Seq||Booking No.|chg_amd_seq|Code|Name|Code|Name|bkg_ctrt_tp_cd|Contract|Contract Customer|C.Rep|L.Rep|" +
        		        "Charge|Curr|Per|As-Is\nAmount|To-Be\nAmount|Difference|Reason|Remark|Status|rqst_usr_id|Team|User Name|Date|rqst_usr_eml|" + 
        		        "apro_usr_id|Team|User Name|Date|Remark|auth_flg";
	           
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	            
	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(false, false, true, true, false, false);
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);
	            
	            

				//데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX		            
				
				
	            InitDataProperty(0, cnt++, dtHiddenStatus,	30,	   daCenter, 	true,	"ibflag");
	            InitDataProperty(0, cnt++, dtData,			30,	   daCenter, 	true,	"seq", false,  "",  dfNone,	0,  false,  false);
	            InitDataProperty(0, cnt++, dtCheckBox,		30,	   daCenter, 	true,	"chk",      false,  "",  dfNone,  0,  true,   false);
				InitDataProperty(0, cnt++, dtPopup,			110,   daCenter,    true,   "bkg_no",              false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtHidden,		75,    daCenter,    true,   "chg_amd_seq",         false,    "",      dfNone,      0,    false,    false);
				
				InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "shpr_cd",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			155,   daLeft,      true,   "shpr_nm",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			60,    daCenter,    true,   "cnee_cd",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			155,   daLeft,      true,	"cnee_nm",	           false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtHidden,		90,    daCenter,    true,   "bkg_ctrt_tp_cd",      false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtPopup,			90,    daCenter,    true,   "ctrt_no",             false,    "",      dfNone,      0,    true,     true);
				InitDataProperty(0, cnt++, dtData,			155,   daLeft,      true,   "ctrt_pty_nm",         false,    "",      dfNone,      0,    true,     true);
				
				InitDataProperty(0, cnt++, dtData,			130,   daLeft,      true,   "ctrt_srep",           false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			130,   daLeft,      true,   "ob_srep",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "chg_cd",              false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "curr_cd",             false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			50,    daCenter,    true,   "rat_ut_cd",           false,    "",      dfNone,      0,    false,    false);
				
				InitDataProperty(0, cnt++, dtData,			80,    daRight,     true,   "crnt_chg_amt",        false,    "",      dfNullFloat, 2,    false,    false);				
				InitDataProperty(0, cnt++, dtData,			80,    daRight,     true,   "amd_chg_amt",         false,    "",      dfNullFloat, 2,    false,    false);
				InitDataProperty(0, cnt++, dtData,			80,    daRight,     true,   "diff_chg_amt",        false,    "",      dfNullFloat, 2,    false,    false);
				InitDataProperty(0, cnt++, dtData,			150,   daLeft,      true,   "chg_amd_rsn_cd",      false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			200,   daLeft,      true,   "chg_amd_rmk",         false,    "",      dfNone,      0,    false,    false);
				
				InitDataProperty(0, cnt++, dtData,			80,	   daCenter,    true,	"chg_amd_rqst_sts_cd", false,	 "",      dfNone,      0,	 false,	   false);
				InitDataProperty(0, cnt++, dtHidden,		30,    daCenter,    true,   "rqst_usr_id",         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			70,    daCenter,    true,   "rqst_ofc_cd",         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			100,    daLeft,      true,   "rqst_usr_nm",         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			85,    daCenter,    true,   "rqst_dt",             false,    "",      dfDateYmd,   0,    false,    false);
				
				InitDataProperty(0, cnt++, dtHidden,		90,    daLeft,      true,   "rqst_usr_eml",        false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtHidden,		130,   daLeft,      true,   "apro_usr_id",         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			70,    daCenter,    true,   "apro_ofc_cd",         false,    "",      dfNone,      0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			100,	   daLeft,      true,	"apro_usr_nm",	       false,    "",      dfNone,      0,	 false,	   false);
				InitDataProperty(0, cnt++, dtData,			85,	   daCenter,    true,	"apro_dt",	           false,	 "",      dfDateYmd,   0,    false,    false);
				InitDataProperty(0, cnt++, dtData,			200,   daLeft,  	 true,	"apro_rmk",	           false,	 "",      dfNone,      0,    false,    false);
				
				InitDataProperty(0, cnt++, dtHidden,		70,	   daCenter,    true,	"auth_flg",	       false,	 "",      dfNone,      0,	 false,	   false);
				
				

                ShowButtonImage = 2;
                UnEditableColor = RgbColor(255,255,255);
                FrozenCols = 4;

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
	    		break;
	    		
	    	case "btn_downexcel":
	    		doActionIBSheet(sheet1, form, IBDOWNEXCEL);
	    		break;
	    	case "btn_approve":
				if (sheet1.FindCheckedRow("chk") =="" ) {
					ComShowCodeMessage("BKG00249");
					return false;
				}
	    		if (!validateForm(sheet1, form, IBSAVE)) 
	    			return false;
	    		
				if (!ComShowCodeConfirm("BKG95003", "approve")) { return false; }
				ComOpenWindowCenter("ESM_BKG_1607.do?gubun=A", "ESM_BKG_1607", 400, 500, false);
				
//	    		doActionIBSheet(sheet1,form,IBSEARCH_ASYNC01);
	    		break;
	    	case "btn_reject":
				if (sheet1.FindCheckedRow("chk") =="" ) {
					ComShowCodeMessage("BKG00249");
					return false;
				}
	    		if (!validateForm(sheet1, form, IBSAVE)) 
	    			return false;
		
				if (!ComShowCodeConfirm("BKG95003", "reject")) { return false; }
				ComOpenWindowCenter("ESM_BKG_1607.do?gubun=R", "ESM_BKG_1607", 400, 500, false);
//	    		doActionIBSheet(sheet1,form,IBSEARCH_ASYNC02);
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
  * dtCheckBox  (1 또는 Y)=Check, (0 또는 N)=UnCheck 
  * @return 없음
  * @author 이승준
  * @version 2009.06.03
  */  	           
  function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	    var colname = sheetObj.ColSaveName(Col);  	 
    	switch(colname){
	    	case "chg_amd_rmk":
	    	case "apro_rmk":
	    		ComShowMemoPad(sheetObj,Row,Col,true,200,200); 
	    		break;
    	} 

   }
  
function sheet1_OnChange(sheetObj, Row, Col,Value){
	var startSelectedRow = sheetObj.FindText("seq",sheetObj.CellValue(Row,"seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
	var colSaveName = sheetObj.ColSaveName(Col);
	var check = sheetObj.CellValue(Row,"chk");
	var keySeq = sheetObj.CellValue(startSelectedRow,"seq");
	
	switch(colSaveName) {
	case "chk" : 
		if(startSelectedRow < 2) return;
		
		for(var i=startSelectedRow ; i<= sheetObj.LastRow ; i++) {
			if(eval(keySeq) < eval(sheetObj.CellValue(i, "seq")) ) {
  				break;
  			}
			if(keySeq == sheetObj.CellValue(i, "seq")) {
				sheetObj.CellValue2(i, "chk") = check;
			}
		}
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
        case "in_bkg_no" :
    	    break;
   
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
		    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1601", popParams, "");
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
	        	comRASCallPop(pgmNo, "ESM_BKG_1601", popParams, "");
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
//function setNew() {
//	var form = document.form;
//	var rhqObj = form.bkg_rhq_cd;
//	var officeObj = form.bkg_ofc_cd;
//    var ctrtTpCd = form.bkg_ctrt_tp_cd;
//    officeObj.RemoveAll();
//    rhqObj.Index = "-1";
//   	rhqObj.Code = gBkgRhqCd;
//    ctrtTpCd.Code = gCtrtTpCdDefault;
//    ctrtTpCd.BackColor = "#FFFFFF";
//   	sheet1.RemoveAll();
//}

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
 			sheet1.DoSearch("ESM_BKG_1601GS.do", FormQueryString(formObj));
	 			
 			break;
 			
		case IBDOWNEXCEL:      //download excel
		    sheet1.Down2Excel(-1); //, "chk|seq"
			break;
			
		case IBSEARCH_ASYNC01:		//Approve
				
			formObj.f_cmd.value = MULTI01;			
			var sParam = FormQueryString(formObj) + "&" + sheet1.GetSaveString(false,false,"chk");
			
			ComOpenWait(true);
			var sXml = sheet1.GetSaveXml("ESM_BKG_1601GS.do", sParam);
			sheet1.LoadSaveXml(sXml);
			ComOpenWait(false);
			
			if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
				ComShowCodeMessage("BKG95033"); // "Saved."
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		
		break;
			
		case IBSEARCH_ASYNC02:		//Reject
	
			
			formObj.f_cmd.value = MULTI02;			
			var sParam = FormQueryString(formObj) + "&" + sheet1.GetSaveString(false,false,"chk");
			
			ComOpenWait(true);
			var sXml = sheet1.GetSaveXml("ESM_BKG_1601GS.do", sParam);
			sheet1.LoadSaveXml(sXml);
			ComOpenWait(false);
			
			if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
				ComShowCodeMessage("BKG95033"); // "Saved."
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
	
    switch (sAction) {
	    
    	case IBSEARCH: //조회
    		if(form.in_bkg_no.value == ''){
    			if(!ComChkObjValid(fmDtObj)) { return false; }
        		if(!ComChkObjValid(toDtObj)) { return false; }
        		
    			if(!chkDate(fmDtObj)) {  return false; }
    			if(!chkDate(toDtObj)) { return false; }			
    		}
    		
	    	break;
	    
    	case IBSAVE: // Approve, Reject
    		var loginUsrId = formObj.usrId.value;
   		  	var sRow = sheetObj.FindStatusRow("I|U");
		    var arrRow = sRow.split(";");
		    for (i=0; i<arrRow.length-1; i++){
		    	var row = arrRow[i];
				if(loginUsrId == sheetObj.CellValue(row, "rqst_usr_id")){
					ComShowMessage(ComGetMsg("BKG95124",sheetObj.CellValue(row, "bkg_no")));
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
    var startRow = sheetObj.HeaderRows;
    var endRow = sheetObj.HeaderRows + sheetObj.RowCount;
	
	for(var i = startRow; i < endRow; i++) {
		if(sheetObj.CellValue(i, "chg_amd_rqst_sts_cd") != "Requested") {
			sheetObj.CellEditable(i, "chk") = false;
			sheetObj.CellBackColor(i, "chk") = sheetObj.RgbColor(239,240,243);
		}
		if(sheetObj.CellValue(i, "auth_flg") != "Y") {
			sheetObj.CellEditable(i, "chk") = false;
			sheetObj.CellBackColor(i, "chk") = sheetObj.RgbColor(239,240,243);
			
		}
	}
    
}   

