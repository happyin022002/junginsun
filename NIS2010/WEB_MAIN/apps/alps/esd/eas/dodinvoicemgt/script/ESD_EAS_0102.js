/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName  : ESD_EAS_0102.js
*@FileTitle : DOD Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.09.12 이혜민
* 1.0 Creation
* 2015.08.24 [CHM-201537151] 조직코드변경작업
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESD_EAS_0102 : ESD_EAS_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_EAS_0102() {  
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

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

//RD
var rdObjects = new Array();
var rdCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	var rdObject = rdObjects[0];
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_payer_cd":
				if(!formObj.payer_cd.readOnly) {
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
				}
				break;

			case "f_tp_cd":
				f_tp_cd_OnChange();
				break;
				
			case "btn_Retrieve":
				ComBtnDisable("btn_fax");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
				
			case "btn_New":
				ComBtnDisable("btn_fax");
    	    	doActionIBSheet(sheetObj, formObj, IBCLEAR);   
    	        break;
    	     
			case "btn_DownExcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break; 
    	        
			case "btn_Ar_If":
				doActionIBSheet(sheetObj, formObj, MULTI);   
	            break;
	            
			case "btn_fax":
				ComSetObjValue(formObj.send_flg, "F");
				doActionIBSheet(sheetObj, formObj, MULTI02);   
	            break;
			case "btn_email":
				ComSetObjValue(formObj.send_flg, "E");
				doActionIBSheet(sheetObj, formObj, MULTI02);   
	            break;
    	        
			case "btn_Cancel":
				doActionIBSheet(sheetObj, formObj, MULTI01);   
	            break;    
    	        
            case "btn_Calendar": //달력버튼
            	if(formObj.btn_Calendar.style.cursor == "hand"){ //달력버튼이 활성화일때만
		            var cal = new ComCalendarFromTo();
		            cal.select(formObj.fm_cre_dt, formObj.to_cre_dt, 'yyyy-MM-dd');
            	}
	            break;
	            
		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage(){
	var formObj = document.form;
	
	 for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet(sheetObjects[i]);
         initSheet(sheetObjects[i],i+1);
         initControl(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
     
	 for(var k=0;k<comboObjects.length;k++){
         initCombo(comboObjects[k],comboObjects[k].id);
     }
	 //RD
	 initRdConfig(rdObjects[0]);
     
	 doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	 ComBtnDisable("btn_fax");
	 //ComBtnDisable("btn_email");
	 formObj.fm_cre_dt.focus();
}

/** 
 * RD 초기설정값<br>
 */
function initRdConfig(rdObject){
	var Rdviewer = rdObject;

	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0); 
	Rdviewer.setbackgroundcolor(128,128,128);
	Rdviewer.SetPageLineColor(128,128,128);
}

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj); 
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
	axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
	axon_event.addListenerForm('keypress', 'obj_keypress', formObj);
	axon_event.addListenerForm('keydown',  'ComKeyEnter', formObj);
	axon_event.addListenerFormat("change", "frmObj_OnChange", formObj);
}

/**
 * Form Element의 OnChange 이벤트
 */
function frmObj_OnChange() {
	var formObj = document.form;
    var elementName = window.event.srcElement.getAttribute("name");    
    with (document.form) {
        switch (elementName) {
            case "payer_cd":
				getPayerInfo();
                break;
        }
    }
}

/**
 * HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "engupnumcomma":	//숫자+영문대문자+Comma
			ComKeyOnlyAlphabet('uppernum', '44');
	        break;
		case "uppernum":
			// 영문 대문자만 입력하기, 영문대+숫자
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

function obj_activate() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	
	switch(event.srcElement.name){
		case "fm_cre_dt":
			//마스크 구분자 없애기
			ComClearSeparator (event.srcElement);
		break;
		case "to_cre_dt":
			//마스크 구분자 없애기
			ComClearSeparator (event.srcElement);
		break;
	}
}

function obj_deactivate(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	
	switch(event.srcElement.name){
		case "fm_cre_dt":
			//입력Validation 확인 및 마스킹 처리
			ComChkObjValid(event.srcElement);
		break;
		case "to_cre_dt":
			//입력Validation 확인 및 마스킹 처리
			ComChkObjValid(event.srcElement);
		break;
	}
}

function obj_keyup() {
	var formObject = document.form;
	switch (event.srcElement.name) {
		case "fm_cre_dt":
			var fromCreDt = ComReplaceStr(event.srcElement.value,"-","");
			
			if (fromCreDt.length == 8) {
				formObject.to_cre_dt.focus();
			}
 		break;

		}
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {

				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	  		  // Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				//var HeadTitle1 =  "STS||SEQ|INV No|A/R\nI/F|B/L No|INV Curr|INV AMT|Issued Date|Issuer|Payer|I/F No|I/F Date|I/F User|Status|Cancel User|Ref.No|bkg|cntc_pnt_nm|cntc_pnt_phn_no|cntc_pnt_fax_no|cntc_pnt_eml";
				var HeadTitle1 =  "STS|Fax|Invoice|SEQ|INV No|A/R\nI/F|Fax\nNo|Mail\nAddr|B/L No|INV Curr|INV AMT|Issued Date|INV OFC|Issuer|Payer|I/F No|I/F Date|I/F User|Status|Cancel User|Ref.No|bkg|cntc_pnt_nm|cntc_pnt_phn_no|cntc_pnt_fax_no|cntc_pnt_eml";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, true, true, false, false);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, false);
				
				// 전체 높이 설정
				style.height = GetSheetHeight(19);
				
				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtCheckBox,		50,	 	daCenter,	true,	"fax_email_chk",	false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0, cnt++ , dtCheckBox,		65,	 	daCenter,	true,	"chk",				false,	"",	dfNone,			0,	true,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			40,		daCenter,	true,	"seq",				false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtPopup,		100,	daCenter,	true,	"dod_inv_no",		false,	"",	dfNone,			0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,			35,		daCenter,	true,	"ar_if_flg",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			35,		daCenter,	true,	"fax_no_flg",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		35,		daCenter,	true,	"mail_addr_flg",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			95,		daCenter,	true,	"bl_no",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			55,		daCenter,	true,	"inv_curr_cd",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,		75,		daCenter,	true,	"ttl_inv_amt",		false,	"",	dfInteger,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			75,		daCenter,	true,	"cre_dt",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	true,	"cre_ofc_cd",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			90,		daLeft,	    true,	"cre_usr_nm",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			120,	daLeft,	    true,	"payr_nm",		    false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			95,		daCenter,	true,	"ar_if_no",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	true,	"ar_if_dt",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	true,	"ar_if_usr_id",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"dod_inv_sts_cd",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"cxl_usr_id",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"cn_ref_inv_no",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,	   120,		daCenter,	true,	"bkg_no",			false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		90,		daCenter,	true,	"cntc_pnt_nm",		false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	true,	"cntc_pnt_phn_no",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	true,	"cntc_pnt_fax_no",	false,	"",	dfNone,			0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	true,	"cntc_pnt_eml",		false,	"",	dfNone,			0,	false,	false);
			
				ShowButtonImage = 2; // 돋보기 버튼 항상보임
				AllowEvent4CheckAll = false;
				CheckAllImageVisible = true;
			}
			break;
	}
}

/**
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBCLEAR: 
			sheetObj.RemoveAll();
			initSheet(sheetObjects[0],1);
			formObj.reset();
			formObj.to_cre_dt.value = ComGetNowInfo();
			formObj.fm_cre_dt.value = ComGetNowInfo();
			ComEnableObject(formObj.fm_cre_dt,  true); 
			ComEnableObject(formObj.to_cre_dt,  true); 
			ComEnableObject(formObj.btn_Calendar,  true); 
			formObj.fm_cre_dt.className = "input1";
			formObj.to_cre_dt.className = "input1";
			ComEnableObject(formObj.m_dod_inv_no,  false);
			ComEnableObject(formObj.m_bl_no,  false);
			ComEnableObject(formObj.btn_m_dod_inv_no,  false); 
			ComEnableObject(formObj.btn_m_bl_no,  false);
			ComBtnDisable("btn_Ar_If");
			ComBtnDisable("btn_Cancel");
			break;	
		
		case IBSEARCH:
			sheetObj.WaitImageVisible = false;	
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);	
			formObj.f_cmd.value = SEARCH;

			var inv_ofc_cd	= ComGetObjValue(formObj.inv_ofc_cd);
		
			//formObj.cre_ofc_cd.value = inv_ofc_cd;
			ComSetObjValue(formObj.cre_ofc_cd, inv_ofc_cd);
			setParam(formObj);
			var sXml = sheetObj.GetSearchXml("ESD_EAS_0102GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);
			sheetObj.SumText(1, "seq") = "";
	        sheetObj.SumText(1, "dod_inv_no") = "TOTAL";
			ComOpenWait(false);
			break;
		
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
			break;	
			
		case MULTI:  // A/R Interface 
    		if(!validateForm(sheetObj,formObj,sAction)) return;
  		
    		if(!ComShowCodeConfirm('EAS80003')) return false;

    		//ComOpenWait Start
			sheetObj.WaitImageVisible=false;
	        ComOpenWait(true);
	        formObj.f_cmd.value = MULTI;
            
			var sParam = sheetObj.GetSaveString(false) +"&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESD_EAS_0102GS.do", sParam);
				
				//ComOpenWait End
			ComOpenWait(false);
				
				//3.저장 후 결과처리
			sheetObj.LoadSaveXml(sXml);
            var sus_yn = ComGetEtcData(sXml, "SUCCESS_YN") ;     
             	formObj.success_yn.value = sus_yn;
             
			
			//처리 완료 후 재조회
			doActionIBSheet(sheetObj, formObj, IBSEARCH);

			ComOpenWait(false);
			break;
			
		case MULTI01:   //Cancel      
			if (!validateForm(sheetObj, formObj, sAction)) return;
			
			if(!ComShowCodeConfirm('EAS80004')) return false;

			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);	
			formObj.f_cmd.value = MULTI01;
			var sParam = ComGetSaveString(sheetObj, false) + "&" + FormQueryString(formObj);

			var sXml = sheetObj.GetSaveXml("ESD_EAS_0102GS.do", sParam);
			
			sheetObj.LoadSaveXml(sXml);
			//재조회
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			ComOpenWait(false);
			break;	
			
		case MULTI02:   //Fax , Email      
			if (!validateForm(sheetObj, formObj, sAction)) return;
			sheetObj.WaitImageVisible = false;	
			ComOpenWait(true);
			var rtnSuccess = new Array();
			var rtnFailure = new Array();
			for(var i=1; i <= sheetObj.RowCount ; i++){		 
		    	if(sheetObj.CellValue(i, "fax_email_chk") == "1") {		    		
					//RD 호출
		    		var inv_no = sheetObj.CellValue(i, "dod_inv_no"); 
		    		ComSetObjValue(formObj.dod_inv_no, 			inv_no);
		    		ComSetObjValue(formObj.cntc_pnt_nm, 	    sheetObj.CellValue(i, "cntc_pnt_nm"));
		    		ComSetObjValue(formObj.cntc_pnt_phn_no, 	sheetObj.CellValue(i, "cntc_pnt_phn_no"));
		    		ComSetObjValue(formObj.cntc_pnt_fax_no, 	sheetObj.CellValue(i, "cntc_pnt_fax_no"));
		    		ComSetObjValue(formObj.cntc_pnt_eml, 		sheetObj.CellValue(i, "cntc_pnt_eml"));
		    		
					var rdParm = "/rv dod_inv_no[" + ComGetObjValue(formObj.dod_inv_no) +"]";
					var path = "";
					var rd_nm = "";
					if (formObj.dod_inv_no.value.substr(0,2) == "KA" ) {
			    		path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1003.mrd";
			    		rd_nm = "ESD_EAS_1003.mrd";
			    	} else if (formObj.dod_inv_no.value.substr(0,2) == "IN" ){                                                                                  
			    		path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1001.mrd";  
			    		rd_nm = "ESD_EAS_1001.mrd";
			    	} else {
			    		path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1004.mrd";
			    		rd_nm = "ESD_EAS_1004.mrd";
			    	}

					ComSetObjValue(formObj.rd_parm, rdParm);
					formObj.f_cmd.value = MULTI;
					var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("ESD_EAS_0101GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						//ComShowCodeMessage("EAS90041");
						rtnSuccess.push(inv_no + " >> Success");
					} else {
						//ComShowCodeMessage("EAS90042");
						rtnFailure.push("InoNo. : " + inv_no + " >> Error\n");
						
					}					
		        }
			}		
			if (rtnSuccess.length > 1){
				ComShowCodeMessage("EAS90041");
			}
			if (rtnFailure.length > 1){
				ComShowCodeMessage("EAS90044");
			}
			ComOpenWait(false);			
			break;		

		
    }
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction){
 	switch(sAction) {
 		case IBSEARCH: 
	 		var tp_cd  = ComGetObjValue(formObj.f_tp_cd[0]);
 			if(tp_cd == "D"){
	 			if((formObj.fm_cre_dt.value == "" && formObj.to_cre_dt.value == "")
	 				||(formObj.fm_cre_dt.value != "" && formObj.to_cre_dt.value == "") 
	 				|| (formObj.fm_cre_dt.value == "" && formObj.to_cre_dt.value != "")){
	 				ComShowCodeMessage("EAS90004", "Issued Date");
	 				return false;
	 			}
 				// 검색 기간 Check(1개월 이내에서만 검색 가능하게)
 				if(!checkMonthPeriod(formObj.fm_cre_dt, formObj.to_cre_dt, 1)){
 					ComShowCodeMessage("EAS80010", "1 month");
 					return false;
 				}
 			}else{
 				if(formObj.m_dod_inv_no.value == "" && formObj.m_bl_no.value == ""){
 					ComShowCodeMessage("COM12138", "INV No", "B/L No");
	 				return false;
	 			}
 			}
	     	break;
	     
 		case MULTI01:  // Cancel
	 		if(sheetObj.CheckedRows("chk") == 0) {
				ComShowCodeMessage('EAS80001', 'invoice');  
	 			return;
	 		}
	     	break;
	     	
 		case MULTI:  // A/R Interface
//			if(sheetObj.CheckedRows("chk") == 0) {
//				ComShowCodeMessage('EAS80001', 'invoice');  
//     			return;
//     		}
			
			var selectedCnt = 0;
			for (var i = 1 ; i < sheetObj.TotalRows + 1; i++) {
				if(sheetObj.CellValue(i, "chk") == 1) {
					if (sheetObj.CellValue(i, "ar_if_no") !=""){
						sheetObj.CellValue2(i, "ibflag") ="R" ; 
						sheetObj.CellValue2(i, "chk") = 0 ;
					}else{
					
					// 100건 이상 처리 못함.
					selectedCnt++
					}
					if(selectedCnt > 100){
						ComShowCodeMessage("EAS80002"); //Limited up to 100 invoices at a time
						return false;
					} 
				}
			}
			
			if(sheetObj.CheckedRows("chk") == 0) {
				ComShowCodeMessage('EAS80001', 'invoice');  
     			return;
     		}
			break;
 	}
 	return true;
}  

function sheet1_OnMouseUp(sheetObj,button,shift,x,y){
    with(sheetObj){
        var row = MouseRow;
        var col = MouseCol;
        var val = "";
        var colName = ColSaveName(col);
        if( row == "0" && row > -1 ){
//        	if( colName == "fax_email_chk"){
//        		for(var i=1; i <= sheetObj.RowCount ; i++){        			
//        			faxEmailSetCheck(sheetObj, i, colName, sheetObj.CellValue(i, colName));
//        		}        		
        		validateFaxEmailBtn(sheetObj);
//            }
        }        
        if( row != "0" && row > -1 ){            
            if( colName == "fax_email_chk"){
            	var rtn = validateCheck(sheetObj, row);
            	if(rtn == "false"){            		
            		alert("Please input Fax No.");
            	} else if(rtn == "N/A") {
            		alert("Invoice which was interfaced to A/R can't be sent by Fax.");
            	}
            	
            	faxEmailSetCheck(sheetObj, row, colName, sheetObj.CellValue(row, col));            	
            	validateFaxEmailBtn(sheetObj);
                return;
            }
        }        
    } // end with
}

function validateCheck(sheetObj, Row){
	var rtn = "false";
	if(sheetObj.CellValue(Row, "fax_no_flg") == "Y" 
		&& sheetObj.CellValue(Row, "ar_if_flg") == "N" 
		//&& sheetObj.CellValue(Row, "mail_addr_flg") == "Y"
			){
		rtn = "true";
	} else if(sheetObj.CellValue(Row, "ar_if_flg") != "N" ){
		rtn = "N/A";
	}
	
	return rtn;
}

function faxEmailSetCheck(sheetObj, Row, Col, val){	
	if(validateCheck(sheetObj, Row) == "true"
			&& val == "1"){
		sheetObj.CellValue2(Row, Col) = "Y";				
	} else {
		sheetObj.CellValue2(Row, Col) = "N";		
	}
	//validateFaxEmailBtn(sheetObj);
}

function validateFaxEmailBtn(sheetObj){
	var totalChecked = 0;
	for(var i=1; i <= sheetObj.RowCount ; i++){		 
    	if(sheetObj.CellValue(i, "fax_email_chk") == "1") {
        	totalChecked = totalChecked + 1;
        }
	}
	if(totalChecked > 0){
		ComBtnEnable("btn_fax");
		//ComBtnEnable("btn_email");
	} else {
		ComBtnDisable("btn_fax");
		//ComBtnDisable("btn_email");
	}
}

function f_tp_cd_OnChange() {
	var formObj    = document.form;
	var tp_cd  = ComGetObjValue(formObj.f_tp_cd[0]);
	if (tp_cd == "D") {  //Date 선택시
		formObj.m_dod_inv_no.value = "";
		formObj.m_bl_no.value = "";
		ComEnableObject(formObj.fm_cre_dt,  true); 
		ComEnableObject(formObj.to_cre_dt,  true); 
		ComEnableObject(formObj.btn_Calendar,  true); 
		formObj.fm_cre_dt.className = "input1";
		formObj.to_cre_dt.className = "input1";
		ComEnableObject(formObj.m_dod_inv_no,  false);
		ComEnableObject(formObj.m_bl_no,  false);
		ComEnableObject(formObj.btn_m_dod_inv_no,  false); 
		ComEnableObject(formObj.btn_m_bl_no,  false);
		
	}else{ 
		ComEnableObject(formObj.fm_cre_dt,  false); 
		ComEnableObject(formObj.to_cre_dt,  false); 
		ComEnableObject(formObj.btn_Calendar,  false); 
		
		ComEnableObject(formObj.m_dod_inv_no,  true);
		ComEnableObject(formObj.m_bl_no,  true);
		ComEnableObject(formObj.btn_m_dod_inv_no,  true); 
		ComEnableObject(formObj.btn_m_bl_no,  true);
		formObj.m_dod_inv_no.className = "input1";
		formObj.m_bl_no.className = "input1";
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	 var rowCnt = sheetObj.RowCount;
	 
		// 조회 데이터가 있을 때에만  A/R IF 및 Cancel 버튼 활성화
		if(rowCnt > 0){
			ComBtnEnable("btn_Ar_If");
			ComBtnEnable("btn_Cancel");
		}else{
			// 버튼 초기화
			ComBtnDisable("btn_Ar_If");
			ComBtnDisable("btn_Cancel");
		}
		
	for(var i=1; i <= rowCnt ; i++){
//		alert("dod_inv_sts_cd=="+sheetObj.CellValue(i,"dod_inv_sts_cd"));
//		if(sheetObj.CellValue(i,"ar_if_flg") == "Y" || sheetObj.CellValue(i,"dod_inv_sts_cd")!= "ISSUED"){
//			sheetObj.CellEditable(i, "chk") = false; 
//		}
		if(sheetObj.CellValue(i,"dod_inv_sts_cd")!= "ISSUED"){
			sheetObj.CellEditable(i, "chk") = false; 
		}
		if(validateCheck(sheetObj, i) == "true"){
			sheetObj.CellEditable(i, "fax_email_chk") = true; 
		}
		
		
	}
	sheetObj.SelectCell(0,0,false);
}

/*
* 각 공통팝업창 호출 함수 
*/
function doProcessPopup(srcName, arg) {
	
	var sheetObj = sheetObjects[0];
	var formObj	= document.form;
	var sUrl	= '';
	var sWidth	= '';
	var sHeight	= '';
	
	with(sheetObj) {
		switch(srcName) {

		    case 'btn_m_bl_no':			// B/L No 멀티입력 팝업 호출
			case 'btn_m_dod_inv_no':	// INV No 멀티입력 팝업 호출
			var flag = ComReplaceStr(srcName,"btn_m_","");
			
	  		// 멀티입력 팝업 타이틀 세부 내용 지정
				var returntitle = '';
				if(flag == 'bl_no')
					returntitle = 'B/L No.';
				else if(flag == 'dod_inv_no')
					returntitle = 'INV No.';
				
				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
				ComOpenPopup('ESD_EAS_MULTI.do'+param, 400, 380, 'getEas_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				return;
			break;
				
		} // switch-end
	} // with-end
	
var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
}

/*
* 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
* - 해당 필드에 멀티 입력값을 설정해준다.
*/
function getEas_Multi(rArray, return_val) {
	var targObj = eval("document.form.m_" + return_val);
	var retStr = rArray.toString().toUpperCase();
	
	ComSetObjValue(targObj, retStr);
}

function sheet1_OnPopupClick(sheetObj, Row, Col){
	var formObj    = document.form;
	if(sheetObj.ColSaveName(Col) == "dod_inv_no"){
		formObj.in_dod_inv_no.value = sheetObj.CellValue(sheetObj.SelectRow ,"dod_inv_no");
		formObj.cntc_pnt_nm.value = sheetObj.CellValue(sheetObj.SelectRow ,"cntc_pnt_nm");
		formObj.cntc_pnt_phn_no.value = sheetObj.CellValue(sheetObj.SelectRow ,"cntc_pnt_phn_no");
		formObj.cntc_pnt_fax_no.value = sheetObj.CellValue(sheetObj.SelectRow ,"cntc_pnt_fax_no");
		formObj.cntc_pnt_eml.value = sheetObj.CellValue(sheetObj.SelectRow ,"cntc_pnt_eml");
		var url = "ESD_EAS_0101.do";
		var returnValue = ComOpenWindowCenter(url, "ESD_EAS_0101", "950","735", true);
	}
}

function setParam(formObj){
	formObj.dod_inv_no.value = "";
	formObj.bl_no.value = "";
	var m_dod_inv_no = ComTrim(formObj.m_dod_inv_no.value);
	var m_bl_no = ComTrim(formObj.m_bl_no.value);
	if(m_dod_inv_no != ""){
		var dod_inv_no_arr = m_dod_inv_no.split(",");
		formObj.dod_inv_no.value = "'"+(ComReplaceStr(dod_inv_no_arr.toString(), ",", "', '"))+"'";
	}
	if(m_bl_no != ""){
		var bl_no_arr = m_bl_no.split(",");
		formObj.bl_no.value = "'"+(ComReplaceStr(bl_no_arr.toString(), ",", "', '"))+"'";
	}
}

function pointAutoMove(val) {
	if ( val.length == 8  ) {
		document.form.to_cre_dt.focus();
	}
}

function checkMonthPeriod(fmDtObj, toDtObj, monthCount){
	var fmDt 	= ComReplaceStr(fmDtObj.value, "-", "");
	var toDt 	= ComReplaceStr(toDtObj.value, "-", "");
	var tmpDt 	= ComGetDateAdd(fmDt, 'M', monthCount);
	if(ComChkPeriod(toDt, tmpDt) > 0){
		return true;
	}else{
		return false;
	}
}



/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboId) {

   var formObject = document.form
  
   with (comboObj) { 
	   if(comboId=="dod_loc_cd"){
		   
		   MultiSelect = true;
		   
		   comboObj.InsertItem(0, "ALL", "A");
		   comboObj.InsertItem(1, "KREIW", "KREIW");
		   comboObj.InsertItem(2, "KRPTK", "KRPTK");
		   comboObj.InsertItem(3, "KRINC", "KRINC");
		   comboObj.InsertItem(4, "KRKAN", "KRKAN");
		   comboObj.index = 0;
	   }else if(comboId=="inv_ofc_cd"){
			   
//			   MultiSelect = true;
			   
			   comboObj.InsertItem(0, "ALL", "A");
			   comboObj.InsertItem(1, "INCKS", "INCKS");  //INCBO
			   comboObj.InsertItem(2, "KANKS", "KANKS");  //KANBO
			   comboObj.InsertItem(3, "PUSSC", "PUSSC");  //PUSSC
//			   comboObj.index = 0; 
			   if(ComGetObjValue(formObject.cre_ofc_cd)=="INCKS"){  //INCBO
				   comboObj.index = 1;
			   }else if(ComGetObjValue(formObject.cre_ofc_cd)=="KANKS"){
				   comboObj.index = 2;
			   }else if(ComGetObjValue(formObject.cre_ofc_cd)=="PUSSC"){
				   comboObj.index = 3;
			   }else {
			       comboObj.index = 0;
			   }

		   }	   
	   

   }
           

}     

/**
 * rgnCdCombo의 MultiSelection OnCheckClick 이벤트 처리
 */
function dod_loc_cd_OnCheckClick(comboObj, index, code) {
    var dodLocCD = document.form.dod_loc_cd;
    // 선택된 Index가 없을 경우는 0번 Index 강제 선택
    if (comboObj.Text == null || comboObj.Text == "") {
        comboObj.CheckIndex(0) = true;

    } else {
        // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
        if (index == 0) {
            for(var i=1; i<comboObj.GetCount(); i++) {
                comboObj.CheckIndex(i) = false;
            }
            dodLocCD.value = "";

        // 다른Index가 선택된 경우는 Index 0을 해제
        } else {
            comboObj.CheckIndex(0) = false;
            dodLocCD.value = "'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'";
        }
    }
}

/*
 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
 */
function getCustCd(aryPopupData) {
	var formObj = document.form;
	ComSetObjValue(formObj.payer_cd, aryPopupData[0][3]);
	ComSetObjValue(formObj.payer_nm, aryPopupData[0][4]);	
}

function getPayerInfo(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	if(ComIsNull(formObj.payer_cd)){		
		ComSetObjValue(formObj.payer_nm, "");	
	}else{
		formObj.f_cmd.value = SEARCH02;
    	var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("ESD_EAS_0100GS.do", sParam);
		var vCustCd = ComGetEtcData(sXml, "cust_cd");
		var vCustNM = ComGetEtcData(sXml, "cust_nm");
		if(vCustCd == "null" || vCustCd == ""){
			ComShowCodeMessage("COM12114", "Payer");
			ComSetObjValue(formObj.payer_nm, "");	
		}else{
			ComSetObjValue(formObj.payer_cd, vCustCd);
			ComSetObjValue(formObj.payer_nm, vCustNM);
		}
	}
}	


/* 개발자 작업  끝 */ 