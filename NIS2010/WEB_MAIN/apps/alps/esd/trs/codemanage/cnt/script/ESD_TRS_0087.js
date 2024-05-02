/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TRS_0087.js
*@FileTitle : CNT(Customer Nominated Trucker) Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 김도현
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History
=========================================================*/
/**
 * @extends Trs
 * @class ESD_TRS_0087 : invoice office authority management
 */
 function ESD_TRS_0087(){
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
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects 	 = new Array();


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 초기 이벤트 등록 
 */
function initControl() {
	axon_event.addListenerForm  ( 'blur'     ,'obj_blur'      ,document.form ); //- 포커스 나갈때
	axon_event.addListenerFormat( 'focus'    ,'obj_focus'     ,document.form ); //- 포커스 들어갈때
	axon_event.addListenerForm  ( 'change'   ,'obj_change'    ,document.form );
	axon_event.addListenerFormat( 'keypress' ,'obj_keypress'  ,document.form); //- 키보드 입력할때
} 

var	ofcSelected = "";
var	invOfcCdSelected = "";
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName){
			case "btn_retrieve":
				if(validateFormSearch(formObject)) {
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				}
			break;
			
			case 'btng_rowadd':
				doActionIBSheet(sheetObject,formObject,IBINSERT);
			break;

			case "btng_save":    
				doActionIBSheet(sheetObject,formObject, MULTI);
			break;

			case "btng_reject":    
				doActionIBSheet(sheetObject,formObject, MODIFY02);
			break;

			case "btng_approval":    
				doActionIBSheet(sheetObject,formObject, MODIFY03);
			break;

			case "btng_cancel":    
				doActionIBSheet(sheetObject,formObject, MODIFY04);
			break;
			    
			case "btng_comparison":
				openComparison();
			break;
				
			case "btng_agmt_creation":
				openAgmtCreationNo();
			break;
				
			case "btng_agmt_correction":
				openAgmtCorrection();
			break;
				
			/* [Date] */	
			case "btns_calendar":
				getCalendar();
			break;
				
			/* [Effective Date] */
			case "btns_onecalendar":
				var cal = new ComCalendar();
				cal.displayType = "date";
        		cal.select(formObject.s_eff_dt, 'yyyyMMdd');
        	break;
        		
			/* [Customer] */
			case 'btng_customer':
				popCustomer();
			break;
				
			/* [Trucker] */
			case "btn_serviceprovider":
				rep_OnPopupClick();
			break;
				
			case "btng_downexcel":
				sheetObject.Down2Excel(-1, false, false, true);
			break;
			
			case "btng_rowcopy":
				rowCopy(sheetObject);
			break;
			
			case "btng_rowdelete":
				doActionIBSheet(sheetObject,formObject, MODIFY05);
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

 function loadPage() {
	 var formObject = document.form;
	 for(i=0;i<sheetObjects.length;i++){
		 //-시작 환경 설정 함수 이름 변경
		 ComConfigSheet(sheetObjects[i]);
		 initSheet(sheetObjects[i],i+1);
		 //-마지막 환경 설정 함수 추가
		 ComEndConfigSheet(sheetObjects[i]);
	 }

    /* IBMultiCombo 초기화 */
 	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
 		initCombo(comboObjects[k], k+1);
 	}
	 
 	 /* Date/Status Combo 호출 */
	 getStatusListCombo();
	 
	 formObject.s_eff_dt.value = ComGetNowInfo("ymd");
	 
	 initControl();
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
			style.height = GetSheetHeight(18) ;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

		    //전체Edit 허용 여부 [선택, Default false]
		    Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 10, 100);

			// 9 - 2 = 7 = 36+2=38
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(51, 6, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);
			
			var HeadTitle1 = "|status|Seq|Contract|Contract|Sales\nOffice|Sales Person|Sales Person|Customer|Customer|Contract Effective Date|Contract Effective Date|MQC|CNT\nType|Name of Preferred Trucker|Name of Preferred Trucker|SCAC Code|Route|Route|Route|Route|Route|Route|Route|Destination|CNTR\nType|CNT/CPT/HPT Rate|CNT/CPT/HPT Rate|CNT/CPT/HPT Rate|CNT/CPT/HPT Rate|SML Trucker Rate|SML Trucker Rate|Comments\nFrom Sales Part|Comments\nFrom Operation Part|Approval\nNumber|Status|Date|Date|Date|Date|Approval\nOffice|Approval User|Approval User|Attachment|AttachFlag|AGMT|AGMT No|SML AGMT No|Bound|appno";
			var HeadTitle2 = "|status|Seq|Type|Number|Sales\nOffice|ID|Name|Code|Name|From|To|MQC|CNT\nType|Code|Name|SCAC Code|From|From|From|Door|Door|To|To|Destination|CNTR\nType|Basic|Fixed/Ratio|%|Fuel|Basic|Fuel|Comments\nFrom Sales Part|Comments\nFrom Operation Part|Approval\nNumber|Status|Saved|Requested|Rejected|Approved|Approval\nOffice|ID|Name|Attachment|AttachFlag|AGMT|AGMT No|SML AGMT No|Bound|appno";
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true); 
			InitHeadRow(1, HeadTitle2, true);

			HeadRowHeight = 12;
			//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCheckBox,	   30,	daCenter,   true,	"sel", 			  					false,    "",      dfNone,          0,         true,        true);
			InitDataProperty(0, cnt++ , dtStatus,      50,  daCenter,   true,   "ibflag",         					false,    "",      dfNone,          0,         true,        true,   0,  false, true,  "", false);		
			InitDataProperty(0, cnt++ , dtData,        40,	daCenter,   true,	"seq",     							false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtCombo,       40,	daCenter,   true,	"prc_ctrt_tp_cd",     				false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        80,	daCenter,   true,	"prc_ctrt_no",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        50,	daCenter,   true,	"sls_ofc_cd",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        50,	daCenter,   true,	"ctrt_cust_srep_cd",    			false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,       120,	daLeft,   	true,	"ctrt_cust_srep_nm",    			false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        60,	daCenter,   true,	"ctrt_cust_cnt_cd",     			false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,       120,	daLeft,   	true,	"ctrt_cust_nm",     				false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        70,	daCenter,   true,	"ctrt_eff_dt",     					false,    "",      dfUserFormat2,   0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        70,	daCenter,   true,	"ctrt_exp_dt",     					false,    "",      dfUserFormat2,   0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        70,	daCenter,   true,	"fnl_mqc_desc",     				false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtCombo,       50,	daCenter,   true,	"cust_nomi_trkr_ind_cd",     		false,    "",      dfNone,          0,         true,       true, 20);
			InitDataProperty(0, cnt++ , dtPopupEdit,   60,	daCenter,   true,	"vndr_seq",     					false,    "",      dfNone,          0,         false,       true, 6);
			InitDataProperty(0, cnt++ , dtData,       150,	daLeft,   	true,	"vndr_nm",     						false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        80,	daCenter,   true,	"usa_edi_cd",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtCombo,	   50,	daCenter,	true,	"io_bnd_cd",     				    false,    "",      dfNone,   		0,         true,  	    true,  7,   false,  false,     "",    false);
			InitDataProperty(0, cnt++ , dtData,        50,	daCenter,   true,	"fm_nod_cd",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtCombo,       40,	daCenter,   true,	"fm_nod_yard",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        50,	daCenter,   true,	"dor_nod_cd",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtCombo,       40,	daCenter,   true,	"dor_nod_yard",     				false,    "",      dfNone,          0,         true,        true, 20);
			InitDataProperty(0, cnt++ , dtData,        50,	daCenter,   true,	"to_nod_cd",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtCombo,       40,	daCenter,   true,	"to_nod_yard",     					false,    "",      dfNone,          0,         true,        true, 20);
			InitDataProperty(0, cnt++ , dtData,       150,	daLeft,   	true,	"mty_pkup_rtn_yd_nm",     			false,    "",      dfNone,          0,         true,        true, 20);
			InitDataProperty(0, cnt++ , dtCombo,       50,	daCenter,   true,	"cntr_tpsz_cd",     				false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        80,	daRight,   	true,	"cust_nomi_trkr_bzc_amt",   		false,    "",      dfFloat,         2,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtCombo,	   80,	daRight,	true,	"cust_nomi_trkr_fuel_div_cd",       false, 	  "",	   dfFloat,   	    2,   	   false,  		true);
			InitDataProperty(0, cnt++ , dtData,        40,	daRight,   	true,	"cust_nomi_trkr_fuel_rto",  		false,    "",      dfFloat,   	    0,   	   false,  		true);
			InitDataProperty(0, cnt++ , dtData,        80,	daRight,   	true,	"cust_nomi_trkr_fuel_amt",  		false,    "",      dfFloat,         2,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        80,	daRight,   	true,	"hjs_trkr_bzc_amt",     			false,    "",      dfFloat,         2,         true,        true, 18);
			InitDataProperty(0, cnt++ , dtData,        80,	daRight,   	true,	"hjs_trkr_fuel_amt",     			false,    "",      dfFloat,         2,         true,        true, 13);
			InitDataProperty(0, cnt++ , dtData,       105,	daLeft,   	true,	"cost_desc",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,       120,	daLeft,   	true,	"apro_his_desc",     				false,    "",      dfNone,          0,         true,        true, 200);
			InitDataProperty(0, cnt++ , dtData,       100,	daLeft,   	true,	"apro_no2",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtCombo,       80,	daCenter,   true,	"disp_sts_cd",     					false,    "",      dfNone,          0,         false,       false, 20);
			InitDataProperty(0, cnt++ , dtData,        70,	daCenter,   true,	"cust_nomi_trkr_sav_dt",    		false,    "",      dfDateYmd,       0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        70,	daCenter,   true,	"cust_nomi_trkr_rqst_dt",   		false,    "",      dfDateYmd,       0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        70,	daCenter,   true,	"cust_nomi_trkr_rjct_dt",   		false,    "",      dfDateYmd,       0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        70,	daCenter,   true,	"cust_nomi_trkr_apro_dt",   		false,    "",      dfDateYmd,       0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        80,	daCenter,   true,	"apro_ofc_cd",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        80,	daLeft,     true,	"apro_usr_id",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,       100,	daLeft,   	true,	"apro_usr_nm",     					false,    "",      dfNone,          0,         false,       true, 20);			
			InitDataProperty(0, cnt++,  dtPopup, 	   90,  daCenter, 	true, 	"attach_flag", 	                    false,    "",	   dfNone, 			0,	       true, 	    true);
			InitDataProperty(0, cnt++,  dtHidden, 	  130,  daLeft, 	true, 	"expn_aud_rslt_rmk", 	            false,    "",	   dfNone, 			0,	       true, 	    true);			
			InitDataProperty(0, cnt++ , dtData,        40,	daCenter,   true,	"hjs_cust_nomi_trkr_agmt_no_yn",	false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,        10,	daLeft,   	true,	"hjs_cust_nomi_trkr_agmt_no",   	false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtData,       100,	daCenter,   true,	"hjs_trkr_agmt_no",     			false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtHidden,      60,	daLeft,   	true,	"rgst_usr_id",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtHidden,      70,	daLeft,   	true,	"rgst_ofc_cd",     					false,    "",      dfNone,          0,         false,       true, 20);
			InitDataProperty(0, cnt++ , dtHidden,	 	0,	daCenter,	true,	"apro_no");
		

            InitUserFormat2(0, "ctrt_eff_dt", "####-##-##", "-|:" );
            InitUserFormat2(0, "ctrt_exp_dt", "####-##-##", "-|:" );
			InitDataCombo(0, 'io_bnd_cd', " |"+io_bnd_cdText,	" |"+io_bnd_cdCode);
            InitDataCombo(0, 'disp_sts_cd', "|"+disp_sts_cdText,"|"+disp_sts_cdCode);
            InitDataCombo(0, "prc_ctrt_tp_cd",  " |S/C|RFA",  " |S|R");
            InitDataCombo(0, "cntr_tpsz_cd", " |D4|R5", " |D4|R5");
            InitDataCombo(0, 'cust_nomi_trkr_fuel_div_cd', " |"		+cust_nomi_trkr_fuel_div_cdText,	" |"+cust_nomi_trkr_fuel_div_cdCode);
            // CNT 는 안보이게 처리
            InitDataCombo(0, 'cust_nomi_trkr_ind_cd','CPT|HPT|MIC|CNT','CPT|HPT|MIC|CNT', '', '', 0, '', '', 'CPT|HPT|MIC');
            InitDataValid(0, "vndr_seq", 		vtNumericOnly);
            InitDataValid(0, "fm_nod_cd", vtEngUpOnly);
            InitDataValid(0, "dor_nod_cd", vtEngUpOnly);
            InitDataValid(0, "to_nod_cd", vtEngUpOnly);
			ColHidden('ibflag')= true;
			ColHidden('hjs_trkr_agmt_no')= true;
			}
			break;
			
			
    	case 2 :
    		with (sheetObj) {
    			style.height = 0; // 높이 설정
    			SheetWidth = 0; //전체 너비 설정
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
    			MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
    			Editable = false; //전체Edit 허용 여부 [선택, Default false]
    			InitRowInfo( 1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitColumnInfo(1, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false,false)

    			var HeadTitle0 = "mutistatus";

    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle0, true);

    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "mutistatus", false, "", dfNone, 0, false, false);						
    		}		
    		break;
			
		}
	}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	try {
		sheetObj.ShowDebugMsg = false;

		var checkedRow = sheetObj.FindCheckedRow("sel");
		var rowArr = checkedRow.split("|"); 
		
		switch(sAction) {
	        case IBSEARCH:	// Retrieve                      
		        formObj.f_cmd.value = SEARCH03;
		        sheetObj.DoSearch("ESD_TRS_0087GS.do", TrsFrmQryString(formObj));
		    break;
		        
			case IBINSERT:
				//생성 후 기본값 설정하기
				var Row = sheetObj.DataInsert(-1);
				
//				sheetObj.CellValue2(Row, 'disp_sts_cd') = "00";
				sheetObj.CellValue2(Row, 'disp_sts_cd') = "";
				sheetObj.CellValue2(Row, 'rgst_usr_id') = formObj.fm_account_usr_id.value;
			break;
			
			case MODIFY01:	// Save
				if( !confirm(ComGetMsg('TRS90535', 'Save')) ) {
					return false;
				}
				
				// Save버튼 클릭시 Request('01') 상태가 아닌 경우가 하나 이상 존재시
				for(i=0; i < rowArr.length-1; i++) {
					var disp_sts_cd = sheetObj.CellValue( rowArr[i], "disp_sts_cd");
					if( disp_sts_cd != '00' && disp_sts_cd != '01') {
						// selected item have already been approved
						ComShowCodeMessage('TRS90538');
						return false;
					}
				}
				
				formObj.f_cmd.value = MODIFY01;
            	sheetObj.DoSave("ESD_TRS_0087GS.do",TrsFrmQryString(formObj),'',false);
				break;	
			case MODIFY02:	// Reject
				if( sheetObj.CheckedRows("sel") < 1 ) {
					ComShowMessage(ComGetMsg("TRS90036"));
					return false;
				} else {
					if( !confirm(ComGetMsg('TRS90535', 'Reject')) ) {
						return false;
					}
					
					// Reject, Approval 버튼 클릭시 Appoval('03') 또는 Reject('02')인 자료가 하나 이상 선택되어 있는 경우
					for(i=0; i < rowArr.length-1; i++) {
						var disp_sts_cd = sheetObj.CellValue( rowArr[i], "disp_sts_cd");
						if( disp_sts_cd == '02' || disp_sts_cd == '03' ) {
							// selected item have already been approved
							ComShowCodeMessage('TRS90538');
							return false;
						}
					}

					formObj.f_cmd.value = MODIFY02;
	            	sheetObj.DoSave("ESD_TRS_0087GS.do",TrsFrmQryString(formObj),'sel',false);
				}
			break;	
			case MODIFY03:	//Approval
				if( sheetObj.CheckedRows("sel") < 1 ) {
					ComShowMessage(ComGetMsg("TRS90036"));
					return false;
				} else {
					if(validateSave(sheetObj,formObj, MODIFY03)){
						if( !confirm(ComGetMsg('TRS90535', 'Approval')) ) {
							return false;
						}
						
						// Reject, Approval 버튼 클릭시 Appoval('03') 또는 Reject('02')인 자료가 하나 이상 선택되어 있는 경우
						for(i=0; i < rowArr.length-1; i++) {
							var disp_sts_cd = sheetObj.CellValue( rowArr[i], "disp_sts_cd");
							if( disp_sts_cd == '02' || disp_sts_cd == '03' ) {
								// selected item have already been approved
								ComShowCodeMessage('TRS90538');
								return false;
							}
						}

						formObj.f_cmd.value = MODIFY03;
		            	sheetObj.DoSave("ESD_TRS_0087GS.do",TrsFrmQryString(formObj),'sel',false);
					}
				}
			break;	
			case MODIFY04:	// Cancel
				if( sheetObj.CheckedRows("sel") < 1 ) {
					ComShowMessage(ComGetMsg("TRS90036"));
					return false;
				} else {
					// Cancel 결제를 취소하는 기능이므로 결제가 되지 않은 자료(Approval 또는 Reject)상태가 아닌 자료가 하나 이상 선택되었을 경우
					for(i=0; i < rowArr.length-1; i++) {
						var disp_sts_cd = sheetObj.CellValue( rowArr[i], "disp_sts_cd");
						if( disp_sts_cd != '02' && disp_sts_cd != '03' ) {
							// selected item are not approved.
							ComShowCodeMessage('TRS90539');
							return false;
						}
					}
					
					if( !confirm(ComGetMsg('TRS90535', 'Cancel')) ) {
						return false;
					}
					formObj.f_cmd.value = MODIFY04;
	            	sheetObj.DoSave("ESD_TRS_0087GS.do",TrsFrmQryString(formObj),'sel',false);
				}
				break;	
				
			case MULTI:	//Save
				if( sheetObj.CheckedRows("sel") < 1 ) {
					ComShowMessage(ComGetMsg("TRS90036"));
					return false;
				} else {
					if(validateSave(sheetObj,formObj, MULTI)){
						if( !confirm(ComGetMsg('TRS90535', 'Save')) ) {
							return false;
						}
						formObj.f_cmd.value = MULTI;
		            	sheetObj.DoSave("ESD_TRS_0087GS.do",TrsFrmQryString(formObj),'sel',false);
					}
				}
			 break;
			 
			case MODIFY05:	// Delete
				if( sheetObj.CheckedRows("sel") < 1 ) {
					ComShowMessage(ComGetMsg("TRS90036"));
					return false;
				} else {
					// Row Delete 는 Request 상태인경우만 가능
					for(i=0; i < rowArr.length-1; i++) {
						var disp_sts_cd				= sheetObj.CellValue( rowArr[i], "disp_sts_cd");
						var cust_nomi_trkr_ind_cd	= sheetObj.CellValue( rowArr[i], "cust_nomi_trkr_ind_cd");
						
						if(cust_nomi_trkr_ind_cd == "CNT"){
							ComShowCodeMessage('TRS90528', 'CNT Type');
							return false;
						}else{
							if( disp_sts_cd == '02') {
								// selected item are not approved.
								ComShowCodeMessage('TRS90538');
								return false;
							}
						}
					}
					if( !confirm(ComGetMsg('TRS90535', 'Delete')) ) {
						return false;
					}
					
					formObj.f_cmd.value = MODIFY05;
	            	sheetObj.DoSave("ESD_TRS_0087GS.do",TrsFrmQryString(formObj),'sel',false);
				}
			 break;
			}	
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}
	}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}
}
/**
 * Sheet PopUp Event
 */
function sheet1_OnPopupClick(sheetObj, Row, Col, value) {
	if (sheetObj.ColSaveName(Col) == "vndr_seq") {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackLocation", "1,0,1,1,1,1,1", true, false, Row);
	} else if (sheetObj.ColSaveName(Col) == "attach_flag") {		
		if (sheetObj.CellValue(Row, 'apro_no') != "") {
			var parentObj = window.dialogArguments;
			//var url = "/hanjin/ESD_TRS_0977.do?attchRow="+Row+"&atch_file_lnk_id="+sheetObj.CellValue(Row, 'expn_aud_rslt_rmk');
			var url = "/hanjin/ESD_TRS_0977.do?attchRow="+Row+"&atch_file_lnk_id="+sheetObj.CellValue(Row, 'expn_aud_rslt_rmk')+"&key1="+sheetObj.cellValue(Row, 'apro_no')+"&call_menu_id=ESD_TRS_0087";
			ComOpenPopup(url, 550, 360, "","1,0,1,1,1", true);
		} else {
			ComShowCodeMessage('TRS90526');
			return;
		}		
	}
}

/**
* 콜백 함수. <br>
* @param  {Array} aryPopupData	필수	 Array Object
* @param  {Int} row				필수 선택한 Row
* @param  {Int} col				필수 선택한 Column
* @param  {Int} sheetIdx			필수 Sheet Index
* @return 없음
* @author 
* @version 2013.03.21
*/   
function callBackLocation(aryPopupData, row, col, sheetIdx){
   var sheetObj = sheetObjects[0];
   var vndrSeq = "";
   var vndrNm = "";
   var i = 0;

   for(i = 0; i < aryPopupData.length; i++){
	   vndrSeq = vndrSeq + aryPopupData[i][2];
	   vndrNm = vndrNm + aryPopupData[i][4];
   }
   sheetObj.CellValue2(row, "vndr_seq") = vndrSeq;
   sheetObj.CellValue2(row, "vndr_nm") = vndrNm;
   
   if(vndrSeq != '') {
	   getUsaEdiCd(sheetObj, row, 'pop');
   }
   
   getAgmtNo(sheetObj, row);
}


/**
 * vndr seq 정로를 통해 SCAC code 취득
 */
function getUsaEdiCd(sheetObj, row, type) {
	var vndr_seq = sheetObj.cellValue(row, 'vndr_seq');
	var sParam = "f_cmd=" + SEARCH05 + "&vndr_seq=" + vndr_seq;
	
	var sXml = sheetObj.GetSearchXml("ESD_TRS_0086GS.do",  sParam);
	var arrXml = sXml.split("|$$|");
	
	// 데이터가 있으면 입력
	if( ComGetTotalRows(sXml) > 0 ) {
		var list = TrsXmlToListMap(arrXml);
		if( list.length > 0 ) {
			sheetObj.CellValue2(row, 'vndr_nm')		= list[0]["vndr_nm"];
			sheetObj.CellValue2(row, 'usa_edi_cd')	= list[0]["usa_edi_cd"];
		}
	} else {
		// 일반 검색에서 취득한 vndr_seq로 취득한 정보가 없으면 공백 
		if(type != 'pop') {
			sheetObj.CellValue2(row, 'vndr_seq') = "";
			sheetObj.CellValue2(row, 'vndr_nm') = "";
			sheetObj.CellValue2(row, 'usa_edi_cd') = "";
		} else {
			sheetObj.CellValue2(row, 'usa_edi_cd') = "";
		}
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
 function validateForm(sheetObj,formObj,sAction){
 	return true;
 }
 
 /**
  * Save 버튼 클릭시 Validation
  */
 function validateSave(sheetObj,formObj, sAction){
		var checkedRow = sheetObj.FindCheckedRow("sel");
		var rowArr = checkedRow.split("|");
		var rtnVal =  true;
		
		if( sheetObj.RowCount("I") == 0 && sheetObj.RowCount("U") == 0 ) {
			ComShowCodeMessage("TRS90381");
			return false;
		}
	
		for(i=0; i < rowArr.length-1; i++) {
			var disp_sts_cd = sheetObj.CellValue( rowArr[i], "disp_sts_cd");
			
			// Save 일때 Approval 일때 다르게 처리 Approval 일때는 00 일경우만 처리
			
			// Approval 일때 Save 되지 않았을때 처리
			if( sAction == MODIFY03 && disp_sts_cd == '') {
				// selected item have already been approved
				ComShowCodeMessage('TRS90526');
				rtnVal =  false;
				return false;
			}
			

			if( disp_sts_cd != '' && disp_sts_cd != '00' && disp_sts_cd != '01' ) {
				// selected item have already been approved
				ComShowCodeMessage('TRS90538');
				rtnVal =  false;
				return false;
			}else if(sheetObj.CellValue( rowArr[i], "prc_ctrt_tp_cd")=="") {
				ComShowCodeMessage("COM130201", "Contract Type");
				rtnVal =  false;
				return false;
			}else if(sheetObj.CellValue( rowArr[i], "prc_ctrt_no")=="") {
				ComShowCodeMessage("COM130201", "Contract Number");
				rtnVal =  false;
				return false;
			}else if(sheetObj.CellValue( rowArr[i], "vndr_seq")=="") {
				ComShowCodeMessage("COM130201", "Name of Preferred Trucker Code");
				rtnVal =  false;
				return false;
			}else if(sheetObj.CellValue( rowArr[i], "io_bnd_cd")=="") {
				ComShowCodeMessage("COM130201", "Route Bound");
				rtnVal =  false;
				return false;
			}else if(sheetObj.CellValue( rowArr[i], "cntr_tpsz_cd")=="") {
				ComShowCodeMessage("COM130201", "CNTR Type");
				rtnVal =  false;
				return false;
			}else if(sheetObj.CellValue( rowArr[i], "cust_nomi_trkr_ind_cd")=="") {
				ComShowCodeMessage("COM130201", "CNT Type");
				rtnVal =  false;
				return false;
			}else if(sheetObj.CellValue( rowArr[i], "cust_nomi_trkr_bzc_amt")=="" || sheetObj.CellValue( rowArr[i], "cust_nomi_trkr_bzc_amt")=="0" ) {
				ComShowCodeMessage("COM130201", "CNT Rate(Basic)");
				rtnVal =  false;
				return false;
			}else{
				rtnVal = true;
			}
		}
		
		return rtnVal
 }
 
	// 조회 후 콤보박스를 클릭 시 대응
function sheet1_OnClick(sheetObj, row , col , value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	var disp_sts_cd = sheetObj.CellValue(row,"disp_sts_cd");

	// status 가 Request saved이거나 Reject상태만 수정 가능
	if(disp_sts_cd == '' || disp_sts_cd == '00' || disp_sts_cd == '01') {
		switch(colName){
			case('fm_nod_yard'):
				var fm_nod_cd = sheetObj.CellValue(row,"fm_nod_cd");
				if(fm_nod_cd != '') {
					getCntYardOriginDestSheetCombo(sheetObj, formObj, row, col, "fm_nod_yard", fm_nod_cd);
				} else {
					sheetObj.CellValue(row,"fm_nod_cd") = "";
				}
			
			break;
			
			case('dor_nod_yard'):
				var dor_nod_cd = sheetObj.CellValue(row,"dor_nod_cd");
  			    var dor_nod_yard = sheetObj.CellValue(row,"dor_nod_yard");
				if(dor_nod_cd != '') {
					getCntYardOriginDestSheetCombo(sheetObj, formObj, row, col, "dor_nod_yard", dor_nod_cd);
				} else {
					sheetObj.CellValue(row,"dor_nod_cd") = "";
				}
			break;
			
			case('to_nod_yard'):
				var to_nod_cd = sheetObj.CellValue(row,"to_nod_cd");
  			    var to_nod_yard = sheetObj.CellValue(row,"to_nod_yard");
				if(to_nod_cd != '') {
					getCntYardOriginDestSheetCombo(sheetObj, formObj, row, col, "to_nod_yard", to_nod_cd);
				} else {
					sheetObj.CellValue(row,"to_nod_cd") = "";
				}
			break;
		}
	}
}


/**
 * Sheet1 의 Change 이벤트를 정의한다.
 * @param SheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet1_OnChange(sheetObj, row, col, value){
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	
	switch(colName) {
		
		case('fm_nod_cd'):
			if( sheetObj.cellValue(row, 'fm_nod_cd') != '' ) {
				var lvdor = doSepRemove(sheetObj.CellValue(row,"fm_nod_cd").toUpperCase(), " ");
				sheetObj.CellValue2(row,"fm_nod_cd") = lvdor;
				
				if( doengnumcheck(lvdor) ) {
					if( lvdor.length == 5 ) {
						getCntYardOriginDestSheetCombo(sheetObj, formObj, row, col, "fm_nod_yard", lvdor);
					} else {
						sheetObj.CellComboItem(row, "fm_nod_yard", "", "");
						sheetObj.CellValue2(row, "fm_nod_yard") = "";
					}
				} else {
					sheetObj.CellValue2(row,"fm_nod_cd") = "";
					sheetObj.SelectCell(row,"fm_nod_cd");
					sheetObj.CellComboItem(row, "fm_nod_yard", "", "");
					sheetObj.CellValue2(row, "fm_nod_yard") = "";
				}
			} else {
				sheetObj.CellValue2(row,"fm_nod_cd") = "";
				sheetObj.SelectCell(row,"fm_nod_cd");
				sheetObj.CellComboItem(row, "fm_nod_yard", "", "");
				sheetObj.CellValue2(row, "fm_nod_yard") = "";
			}
			
			getAgmtNo(sheetObj, row);
		break;
		
		// 콤보
		case('fm_nod_yard'):
			if( sheetObj.cellValue(row, 'io_bnd_cd') == '' ) {
				ComShowCodeMessage("COM130201", "Origin Route Bound");
				sheetObj.CellValue2(row, "fm_nod_yard") = "";
				break;
			}
			if( sheetObj.CellValue(row, 'fm_nod_yard') != '') {
				getAgmtNo(sheetObj, row);
			}
		break;
		
		case('dor_nod_cd'):
			if( sheetObj.cellValue(row, 'dor_nod_cd') != '' ) {
				var lvdor = doSepRemove(sheetObj.CellValue(row,"dor_nod_cd").toUpperCase(), " ");
				sheetObj.CellValue2(row,"dor_nod_cd") = lvdor;
				
				if( doengnumcheck(lvdor) ) {
					if( lvdor.length == 5 ) {
						// 5자리일 경우 Location 값의 정확성을위하여 Zone Code 제거한다.
						sheetObj.CellComboItem(row, "dor_nod_yard", "", "");
						sheetObj.CellValue2(row, "dor_nod_yard") = "";
						
						getDorLocNm(sheetObj, row);
					} else {
						sheetObj.CellComboItem(row, "dor_nod_yard", "", "");
						sheetObj.CellValue2(row, "dor_nod_yard") = "";
					}
				} else {
					sheetObj.CellValue2(row,"dor_nod_cd") = "";
					sheetObj.SelectCell(row,"dor_nod_cd");
					sheetObj.CellComboItem(row, "dor_nod_yard", "", "");
					sheetObj.CellValue2(row, "dor_nod_yard") = "";
				}
			} else {
				sheetObj.CellValue2(row,"dor_nod_cd") = "";
				sheetObj.SelectCell(row,"dor_nod_cd");
				sheetObj.CellComboItem(row, "dor_nod_yard", "", "");
				sheetObj.CellValue2(row, "dor_nod_yard") = "";
				sheetObj.CellValue2(row, "mty_pkup_rtn_yd_nm") = "";
			}
			
			//getAgmtNo(sheetObj, row);
		break;
		
		case('dor_nod_yard'):
			if( sheetObj.cellValue(row, 'io_bnd_cd') == '' ) {
				ComShowCodeMessage("COM130201", "Origin Route Bound");
				sheetObj.CellValue2(row, "dor_nod_yard") = "";
				break;
			}
		
			if( sheetObj.CellValue(row, 'dor_nod_cd') != '' && sheetObj.CellValue(row, 'dor_nod_yard') != '') {
				getDorYdNm(sheetObj, row);
			}else{
				sheetObj.CellValue2(row, "dor_yd_nm") = "";
				getDorLocNm(sheetObj, row);
			}

			if( sheetObj.CellValue(row, 'dor_nod_cd') != '') {
				getAgmtNo(sheetObj, row);
			}
			
		break;
		
		case('to_nod_cd'):
			if( sheetObj.cellValue(row, 'to_nod_cd') != '' ) {
				var to_nod_cd = sheetObj.cellValue(row, 'to_nod_cd');
				var lvdor = doSepRemove(sheetObj.CellValue(row,"to_nod_cd").toUpperCase(), " ");
				sheetObj.CellValue2(row,"to_nod_cd") = lvdor;
				
				if( doengnumcheck(lvdor) ) {
					if( lvdor.length == 5 ) {
						getCntYardOriginDestSheetCombo(sheetObj, formObj, row, col, "to_nod_yard", lvdor);
					} else {
						if( lvdor.length == 0 ) {
							sheetObj.CellComboItem(row, "to_nod_yard", "", "");
						} else {
							errMsg = ComGetMsg("TRS90122");
							ComShowMessage(errMsg);
							sheetObj.CellValue2(row,"to_nod_cd") = "";
							sheetObj.SelectCell(row,"to_nod_cd");
							sheetObj.CellComboItem(row, "to_nod_yard", "", "");
							sheetObj.CellValue2(row, "to_nod_yard") = "";
						}
					}
				} else {
					sheetObj.CellValue2(row,"to_nod_cd") = "";
					sheetObj.SelectCell(row,"to_nod_cd");
					sheetObj.CellComboItem(row, "to_nod_yard", "", "");
					sheetObj.CellValue2(row, "to_nod_yard") = "";
				}
			} else {
				sheetObj.CellValue2(row,"to_nod_cd") = "";
				sheetObj.SelectCell(row,"to_nod_cd");
				sheetObj.CellComboItem(row, "to_nod_yard", "", "");
				sheetObj.CellValue2(row, "to_nod_yard") = "";
			}
			
//			getMtRetrunYd(sheetObj, row);
		break;
		
		// 콤보
		case('to_nod_yard'):
			if( sheetObj.cellValue(row, 'io_bnd_cd') == '' ) {
				ComShowCodeMessage("COM130201", "Dest Route Bound");
				sheetObj.CellValue2(row, "to_nod_yard") = "";
				break;
			}
//			if( sheetObj.cellValue(row, 'to_nod_yard') != '' && sheetObj.cellValue(row, 'io_bnd_cd') == 'I' ) {
//				getMtRetrunYd(sheetObj, row);
//				break;
//			}
			
			if( sheetObj.cellValue(row, 'to_nod_yard') == '') {
				sheetObj.CellComboItem(row, "to_nod_yard", "", "");
//				sheetObj.CellValue(row,"mty_pkup_rtn_yd_nm") = "";
			}
//			getMtRetrunYd(sheetObj, row);
			
			if( sheetObj.CellValue(row, 'to_nod_yard') != '') {
				getAgmtNo(sheetObj, row);
			}
		break;
		
		case('vndr_seq'):
			var vndr_seq = sheetObj.CellValue(row, "vndr_seq");
//			var vndr_nm = "";
//			
//			formObj.f_cmd.value = SEARCH06;
//			var queryString = "vndr_seq="+vndr_seq;
//	
//			sheetObj.DoRowSearch("ESD_TRS_0087GS.do",TrsFrmQryString(formObj)+"&"+ queryString);
//	
//			vndr_nm = sheetObj.EtcData('vndr_nm');
			if(vndr_seq !="" && vndr_seq !=null && vndr_seq != undefined){
				getUsaEdiCd(sheetObj, row, 'input');
			}else{
				sheetObj.CellValue2(row, "vndr_seq") = "";
				sheetObj.CellValue2(row, "vndr_nm")  = "";
			}
			sheetObj.RemoveEtcData();
			getAgmtNo(sheetObj, row);
		break;	
		
 		case ('prc_ctrt_no'):
	 		if( sheetObj.cellValue(row, 'prc_ctrt_no') != '' ) {
 				if(sheetObj.cellValue(row, 'prc_ctrt_tp_cd') == '') {
 					ComShowCodeMessage("COM130201", "Route Bound Contract Type");
 					sheetObj.CellValue2(row, "prc_ctrt_no") = "";
 					break;
 				}
 				
	 			formObj.f_cmd.value = SEARCH07;
	 			
	 			var prc_ctrt_tp_cd = sheetObj.cellValue(row, 'prc_ctrt_tp_cd');
	 			var prc_ctrt_no = doSepRemove(sheetObj.CellValue(row,"prc_ctrt_no").toUpperCase(), " ");
	 			sheetObj.CellValue2(row,"prc_ctrt_no") = prc_ctrt_no;
	 			
	 			var urlStr = 'prc_ctrt_tp_cd=' + prc_ctrt_tp_cd + '&prc_ctrt_no='+prc_ctrt_no+'&Row='+row;
	 			
	 			var sXml = sheetObj.GetSearchXml("ESD_TRS_0086GS.do", FormQueryString(formObj)+ "&" + urlStr);
	 			var arrXml = sXml.split("|$$|");
	 			
		 		if( ComGetTotalRows(sXml) == 0 ) {
		 			sheetObj.CellValue2(row, 'prc_ctrt_no') = "";
		 			sheetObj.CellValue2(row, 'sls_ofc_cd') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_srep_cd') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_srep_nm') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_cd') = "";
		 			sheetObj.CellValue2(row, 'ctrt_cust_nm') = "";
		 			sheetObj.CellValue2(row, 'ctrt_eff_dt') = "";
		 			sheetObj.CellValue2(row, 'ctrt_exp_dt') = "";
		 			sheetObj.CellValue2(row, 'fnl_mqc_desc') = "";
		 			
		 		} else if( ComGetTotalRows(sXml) > 0 ) {
	 				var list = TrsXmlToListMap(arrXml);
	 				
	 				if( list.length > 0 ) {
	 					sheetObj.CellValue2(row, 'sls_ofc_cd')				= list[0]["sls_ofc_cd"];
	 					sheetObj.CellValue2(row, 'ctrt_cust_srep_cd')		= list[0]["ctrt_cust_srep_cd"];
	 					sheetObj.CellValue2(row, 'ctrt_cust_srep_nm')		= list[0]["ctrt_cust_srep_nm"];
	 					sheetObj.CellValue2(row, 'ctrt_cust_cnt_cd')		= list[0]["ctrt_cust_cd"];
	 					sheetObj.CellValue2(row, 'ctrt_cust_nm')			= list[0]["ctrt_cust_nm"];
	 					sheetObj.CellValue2(row, 'ctrt_eff_dt')				= list[0]["ctrt_eff_dt"];
	 					sheetObj.CellValue2(row, 'ctrt_exp_dt')				= list[0]["ctrt_exp_dt"];
	 					sheetObj.CellValue2(row, 'fnl_mqc_desc')			= list[0]["fnl_mqc_desc"];
	 				}
		 		}
	 		}
	 		break;	 		
	}
			
}

 
 /**
  * 저장후 발생하는 이벤트를 처리
  */
  function sheet1_OnSaveEnd(sheetObj, errMsg) {
  	var formObj = document.form;
  	if( errMsg != null && errMsg != '' ) {
		} else {
			// save sucess
			ComShowCodeMessage("TRS90511");
			
			if( formObj.f_cmd.value == MULTI || formObj.f_cmd.value == MODIFY01
				|| formObj.f_cmd.value == MODIFY02
				|| formObj.f_cmd.value == MODIFY03
				|| formObj.f_cmd.value == MODIFY04
				|| formObj.f_cmd.value == MODIFY05) {
				doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}
		}
	}
  
    /**
   * Status Date 멀티 달력 입력 Pop-Up
   */
  function getCalendar() {
  	var cal = new ComCalendarFromTo();
  	cal.displayType = "date";
  	cal.select(document.form.s_fm_dt, document.form.s_to_dt, 'yyyyMMdd');
  }
  /**
   * Status Date 멀티 달력 입력 Pop-Up - 일자에 더하기를 한다.
   */
  function getDateBetween(obj) {
  	document.form.s_to_dt.value = ComGetDateAdd(obj.value,'d', 14, '');
  }
  /**
   * Status Date 멀티 달력 입력 Pop-Up - Enter Key시 지연대리 요청 20070115
   */
  function doSearchEnter() {
  	if( event.keyCode == 13 ) {
  		var sheetObject = sheetObjects[0];
  		var sheetObject1 = sheetObjects[1];
  		var formObject = document.form;
  		if( validateFormSearch(formObject) ) {
  			sheetObject1.RemoveAll(); //Single Transportation의 쉬트 내용을 제거
  			doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
  		}
  	}
  }
  
  	/**
  	 * date 체크
  	 */
	function validateFormSearch(formObj) {
		var sFmDate = doSepRemove(doSepRemove(formObj.s_fm_dt.value, " "), "-");
		var sToDate = doSepRemove(doSepRemove(formObj.s_to_dt.value, " "), "-");
		var sEffDt = doSepRemove(doSepRemove(formObj.s_eff_dt.value, " "), "-");
		
		// from date
		if( sFmDate == "" ) {
			formObj.s_fm_dt.value = "";
		} else {
			if(!ComIsDate(formObj.s_fm_dt.value)){
				formObj.s_fm_dt.value = '';
				formObj.s_fm_dt.focus();
				return false;
			}
		}
		// to date
		if( sToDate == "" ) {
			formObj.s_to_dt.value = "";
		} else {
			if(!ComIsDate(formObj.s_to_dt.value)){
				formObj.s_to_dt.value = '';
				formObj.s_to_dt.focus();
				return false;
			}
		}
		// Effective Date
		if( sEffDt == "" ){
			formObj.s_eff_dt.value = "";
		} else {
			if(!ComIsDate(formObj.s_eff_dt.value)){
				formObj.s_eff_dt.value = '';
				formObj.s_eff_dt.focus();
			}
		}
		
		if( sFmDate != "" && sToDate != "" ) { //날짜 체크하는 부분
			if( dateCalcuration(sFmDate, sToDate) < 0 ) {
				errMsg = ComGetMsg("TRS90118");
				ComShowMessage(errMsg);
				return false;
			}
		}
		
		return true;
	}
  
  /**
   * Customer Popup
   */
  function popCustomer(){
  	ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'setCustomerPop', '1,0,1,1,1,1,1,1');
  }

  /**
   * customer Popup
   */
  function setCustomerPop(rowArray){
  	var formObj = document.form;
  	var colArray = '';
  	
  	if(rowArray.length>0)
  	{
  		formObj.s_cust_seq.value = rowArray[0][3];
  		formObj.s_cust_seq_nm.value = rowArray[0][4];
  	}

  }
  
  
  /**
   * Trucker Popup
   */
  function rep_OnPopupClick() {
  	 var formObject = document.form;
  	 var cmdt_cd_val ="";   //향후 사용가능 예정변수
  	 var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
  	 var cmdt_desc_val ="";   //향후 사용가능 예정변수
  	 var classId ="getCOM_ENS_rep";
  	 var xx1="";  //CONTI
  	 var xx2="";  //SUB CONTI
  	 var xx3="";  //COUNTRY
  	 var xx4="";  //STATE
  	 var xx5="";  //CONTROL OFFIC
  	 var xx6="";  //LOC CODE
  	 var xx7="";  //LOC NAME
  	 var xx8="";
  	 var xx9="";

  	 var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
  	 ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
  }

  /**
   * Trucker 팝업호출 : 팝업에서 단일 선택을 한경우..
   */
  function getCOM_ENS_rep(rowArray) {
  	var formObj = document.form;
  	for(var i=0; i<rowArray.length; i++) 
  	{
  		var colArray = rowArray[0];
  		var colArray2 = colArray[2];
  		var colArray3 = colArray[3];
  		var colArray4 = colArray[4];
  		formObj.s_vndr_seq.value =colArray2;
  		formObj.s_vndr_seq_nm.value =colArray4;
  	}
  }
  
  
  /**
   * Date/Status Combo 셋팅
   **/  
  function getStatusListCombo()
 {
 	  var formObj = document.form;
 	  var TySzList = getStatusListList(sheetObjects[1], formObj);	  
 	  var TySzArray = new Array();	  	 
 	  TySzArray = TySzList.split("|");
 	  document.divcombo.RemoveAll();
 	  document.stscombo.RemoveAll();
 	  for(var i=0; i<TySzArray.length; i++)
 	  {
 		  document.divcombo.InsertItem(i, TySzArray[i].substring(3), TySzArray[i].substring(0,2));
 		  document.stscombo.InsertItem(i, TySzArray[i].substring(3), TySzArray[i].substring(0,2));
 	  }
 	  
 	  document.divcombo.Index=0;	  
 }
 
 /**
  * Date/Status Combo 조회
  **/
  function getStatusListList(sheetObj, formObject)
  {
  	 sheetObj.WaitImageVisible  = false;
  	 formObject.f_cmd.value = SEARCH02;
  	 var queryString = TrsFrmQryString(formObject);
  	 sheetObj.DoRowSearch("ESD_TRS_0087GS.do", queryString);
  	 sheetObj.WaitImageVisible  = true;
  	 return sheetObj.EtcData('MUTI_STATUS');
  }  
 
  /**
   * Date/Status Combo 속성 설정
   **/
  function initCombo (comboObj, comboNo) {
		 switch(comboObj.id) {
		   	 case "divcombo":
					with(comboObj) {
						DropHeight = 150;
						MultiSelect = false;
						UseAutoComplete = true;
						MultiSeparator = ",";
						Style = 0;
						ValidChar(2,3);
					}
				break;
		   	 case "stscombo":
					with(comboObj) {
						//BackColor = "cyan";
						DropHeight = 150;
						MultiSelect = true;
						UseAutoComplete = true;
						MultiSeparator = ",";
						Style = 0;
					}
				break;
		 }      	
	}

  
  /**
   * IBCombo Object를 배열로 등록
   * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
   * 배열은 소스 상단에 정의
  */
  function setComboObject(combo_obj){
      comboObjects[comboCnt++] = combo_obj;
  }
  
  /**
   * Date/Status Combo 속성 설정 - divcombo_OnBlur
   **/
  function divcombo_OnBlur(comboObj, Index_Code, Text) {
  	var formObj = document.form;
  	formObj.s_dt_div_cd.value = ComGetObjValue(comboObj);
  }

  /**
   * Date/Status Combo 속성 설정 - stscombo_OnBlur
   **/
  function stscombo_OnBlur(comboObj, Index_Code, Text) {
  	var formObj = document.form;
  	formObj.s_disp_sts_cd.value = ComGetObjValue(comboObj);
  }
  
  //참고 URL : http://alpsdev.hanjin.com:9400/hanjin/ESD_TRS_0231.do?MENU=Y&pgmNo=ESD_TRS_0231&pid=ESD_TRS_M002
  /*
  * Comparison조회 팝업 Open
  */
  function openComparison() {
  	var formObject = document.form;
  	var Option = "width=1000,height=620,menubar=0,status=0,scrollbars=0,resizable=1";
  	var param = "";
  	window.open('/hanjin/ESD_TRS_0231.do?MENU=Y&pgmNo=ESD_TRS_0231&pid=ESD_TRS_M002' + param, "popup", Option);
  }

  //참고 URL : http://alpsdev.hanjin.com:9400/hanjin/ESD_TRS_0221.do?MENU=Y&pgmNo=ESD_TRS_0221&pid=ESD_TRS_M002
  /*
  * AGMT Creation조회 팝업 Open
  */
  function openAgmtCreationNo() {
  	var formObject = document.form;
  	var Option = "width=1000,height=620,menubar=0,status=0,scrollbars=0,resizable=1";
  	var param = "";
  	window.open('/hanjin/ESD_TRS_0221.do?MENU=Y&pgmNo=ESD_TRS_0221&pid=ESD_TRS_M002' + param, "popup", Option);
  }

  //참고 URL : http://alpsdev.hanjin.com:9400/hanjin/ESD_TRS_0224.do?MENU=Y&pgmNo=ESD_TRS_0224&pid=ESD_TRS_M002
  /*
  * AGMT Correction조회 팝업 Open
  */
  function openAgmtCorrection() {
  	var formObject = document.form;
  	var Option = "width=1000,height=620,menubar=0,status=0,scrollbars=0,resizable=1";
  	var param = "";
  	window.open('/hanjin/ESD_TRS_0224.do?MENU=Y&pgmNo=ESD_TRS_0224&pid=ESD_TRS_M002' + param, "popup", Option);
  }
  
	/*
	 * customer or Trucker name Search as code
	 */
	function setSearchName(div, cost) {
		var formObj = document.form;
			// Customer
			if(div == 'cust') {
					formObj.f_cmd.value = SEARCH06;
					var s_cust_seq = doSepRemove(cost.toUpperCase(), " ");
					formObj.s_cust_seq.value = s_cust_seq;
					
					var sXml = sheetObjects[0].GetSearchXml("ESD_TRS_0086GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					var list = TrsXmlToListMap(arrXml);
					
					if(list.length > 0) {
						formObj.s_cust_seq_nm.value = list[0]['cust_lgl_eng_nm'];
					}else{
						formObj.s_cust_seq_nm.value = '';
					}
			// Trucker
			} else {
				formObj.f_cmd.value = SEARCH05;
				var s_vndr_seq = doSepRemove(cost.toUpperCase(), " ");
				formObj.s_vndr_seq.value = s_vndr_seq;
				
				var sXml = sheetObjects[0].GetSearchXml("ESD_TRS_0086GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				var list = TrsXmlToListMap(arrXml);
				
				if(list.length > 0) {
					formObj.s_vndr_seq_nm.value = list[0]['vndr_nm'];
				}else{
					formObj.s_vndr_seq_nm.value = '';
				}
			}
	}
	
	//  Destination을 조회
	function getMtRetrunYd(sheetObj, row) {
		var to_nod_cd		= sheetObj.cellValue(row, 'to_nod_cd');
		var to_nod_yard	    = sheetObj.CellValue(row, 'to_nod_yard');
		
	   if(to_nod_yard != ""){
			var sParam = "f_cmd=" + SEARCH04 
			           + "&to_nod_cd=" + to_nod_cd 
			           + "&to_nod_yard=" + to_nod_yard
			           ;
	
			var sXml = sheetObj.GetSearchXml("ESD_TRS_0087GS.do", sParam);
			var yd_nm = ComGetEtcData(sXml, "yd_nm");
			sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm')	= yd_nm;
	   }else{
		   sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm')	= "";
	   }
	   //Agreement No조회
	   getAgmtNo(sheetObj, row);
	}
	
//  Door Yard Name을 조회
	function getDorLocNm(sheetObj, row) {
		var dor_loc = sheetObj.cellValue(row, 'dor_nod_cd');
		var dor_yard = sheetObj.cellValue(row, 'dor_nod_yard');
		
		if(dor_loc!= ''){
			var queryString = "f_cmd=" + SEARCH08
				            + "&dor_nod_cd="+dor_loc+dor_yard;
			var sXml = sheetObj.GetSearchXml("ESD_TRS_0087GS.do",queryString);
			var arrXml = sXml.split("|$$|");

	 		if( ComGetTotalRows(sXml) == 0 ) {
	 			sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm') = "";
	 		} else if( ComGetTotalRows(sXml) > 0 ) {
				var list = TrsXmlToListMap(arrXml);
				if( list.length > 0 ) {
					sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm')	= list[0]["zn_nm"];
				}
	 		}
		}else{
 			sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm') = "";
		}
	   
	}
	
	//  Door Yard Name을 조회
	function getDorYdNm(sheetObj, row) {
		var dor_loc = sheetObj.cellValue(row, 'dor_nod_cd');
		var dor_yard = sheetObj.cellValue(row, 'dor_nod_yard');
		
		if(dor_loc!= '' && dor_yard != ''){
			var queryString = "f_cmd=" + SEARCH07
				            + "&dor_nod_cd="+dor_loc+dor_yard;
			var sXml = sheetObj.GetSearchXml("ESD_TRS_0087GS.do",queryString);
			var arrXml = sXml.split("|$$|");

	 		if( ComGetTotalRows(sXml) == 0 ) {
	 			sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm') = "";
	 		} else if( ComGetTotalRows(sXml) > 0 ) {
				var list = TrsXmlToListMap(arrXml);
				if( list.length > 0 ) {
					sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm')	= list[0]["zn_nm"];
				}
	 		}
		}else{
 			sheetObj.CellValue2(row, 'mty_pkup_rtn_yd_nm') = "";
		}
	   
	}	
	
	
	// Agreement No조회
	function getAgmtNo(sheetObj, row) {
		var vndr_seq		= sheetObj.CellValue(row, 'vndr_seq');
		var io_bnd_cd		= sheetObj.CellValue(row, 'io_bnd_cd');
		var fm_nod_cd		= sheetObj.CellValue(row, 'fm_nod_cd');
		var fm_nod_yard	    = sheetObj.CellValue(row, 'fm_nod_yard');
		var dor_nod_cd		= sheetObj.CellValue(row, 'dor_nod_cd');
		var dor_nod_yard	= sheetObj.CellValue(row, 'dor_nod_yard');
		var to_nod_cd		= sheetObj.CellValue(row, 'to_nod_cd');
		var to_nod_yard	    = sheetObj.CellValue(row, 'to_nod_yard');

		var sParam = "f_cmd=" + SEARCH05
				   + "&vndr_seq=" + vndr_seq
				   + "&io_bnd_cd=" + io_bnd_cd
				   + "&fm_nod_cd=" + fm_nod_cd
				   + "&fm_nod_yard=" + fm_nod_yard
				   + "&dor_nod_cd=" + dor_nod_cd
				   + "&dor_nod_yard=" + dor_nod_yard 
			       + "&to_nod_cd=" + to_nod_cd 
			       + "&to_nod_yard=" + to_nod_yard
			       ;

		var sXml = sheetObj.GetSearchXml("ESD_TRS_0087GS.do", sParam);
		
		var agmt_flg = ComGetEtcData(sXml, "agmt_flg");
		var agmt_no = ComGetEtcData(sXml, "agmt_no");
		sheetObj.CellValue2(row, 'hjs_cust_nomi_trkr_agmt_no_yn')	= agmt_flg;
		sheetObj.CellValue2(row, 'hjs_cust_nomi_trkr_agmt_no')	= agmt_no;
		sheetObj.CellValue2(row, 'hjs_trkr_agmt_no')	= agmt_no;
	}
	
	/**
	 *  Status가 ‘Request’일 때에 한정하여 선택한 Row를 Copy 
	 *
	 */
		
   function rowCopy(sheetObj){
		var checkedRow = sheetObj.FindCheckedRow("sel");
		var chkRowArr = checkedRow.split("|"); 
		
		for(var i= 0;i<chkRowArr.length-1;i++){			// 복사대상
			//Status가 Request’일 경우
//			if(sheetObj.CellValue(chkRowArr[i], 'disp_sts_cd')=="01"){
				sheetObj.DataInsert(-1);
				sheetObj.CellValue(sheetObj.SelectRow,"io_bnd_cd") = sheetObj.CellValue(chkRowArr[i],"io_bnd_cd");
				
				for(var j= 0;j<sheetObj.LastCol;j++ ){		// 컬럼
					
					if(sheetObj.ColSaveName(j) == "disp_sts_cd"){
						//sheetObj.CellValue(chkRowArr[i],"dor_nod_yard") = "00";
//						sheetObj.CellValue(sheetObj.SelectRow,"disp_sts_cd") = "00";
						sheetObj.CellValue(sheetObj.SelectRow,"disp_sts_cd") = "";
					}else if( sheetObj.ColSaveName(j)!="ibflag" && 
						sheetObj.ColSaveName(j)!= "seq" &&
						sheetObj.ColSaveName(j)!= "cust_nomi_trkr_sav_dt" &&
						sheetObj.ColSaveName(j)!= "cust_nomi_trkr_rqst_dt" &&
						sheetObj.ColSaveName(j)!= "cust_nomi_trkr_rjct_dt" &&
						sheetObj.ColSaveName(j)!= "cust_nomi_trkr_apro_dt" &&
						sheetObj.ColSaveName(j)!= "apro_ofc_cd" &&
						sheetObj.ColSaveName(j)!= "apro_usr_id" &&
						sheetObj.ColSaveName(j)!= "apro_usr_nm" &&
						sheetObj.ColSaveName(j)!= "hjs_cust_nomi_trkr_agmt_no_yn" &&
						sheetObj.ColSaveName(j)!= "apro_no2" &&
						sheetObj.ColSaveName(j)!= "apro_no"){
						
						if(sheetObj.ColSaveName(j)== "fm_nod_yard"){
							var fm_nod_yard = sheetObj.CellValue(chkRowArr[i],"fm_nod_yard")
							sheetObj.CellComboItem(sheetObj.SelectRow,"fm_nod_yard",fm_nod_yard,fm_nod_yard);
						}
						if(sheetObj.ColSaveName(j)== "dor_nod_yard"){
							var dor_nod_yard = sheetObj.CellValue(chkRowArr[i],"dor_nod_yard");
							sheetObj.CellComboItem(sheetObj.SelectRow,"dor_nod_yard",dor_nod_yard,dor_nod_yard);
						}
						if(sheetObj.ColSaveName(j)== "to_nod_yard"){
							var to_nod_yard = sheetObj.CellValue(chkRowArr[i],"to_nod_yard")
							sheetObj.CellComboItem(sheetObj.SelectRow,"to_nod_yard",to_nod_yard,to_nod_yard);
						}
						
						sheetObj.CellValue(sheetObj.SelectRow,j) = sheetObj.CellValue(chkRowArr[i],j);
					} 
				}
				
				// rgst_usr_id
				sheetObj.CellValue(sheetObj.SelectRow, 'rgst_usr_id') = document.form.fm_account_usr_id.value;
				
				getAgmtNo(sheetObj, chkRowArr[i]);
//			}
		}
   }
   
	/**
	 * HTML Control의 onkeypress이벤트 처리<br>
	 **/
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	}
	
	/**
	 * HTML Control의 onchange이벤트 처리<br>
	 **/
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_fm_dt":
			case "s_to_dt":
			case "s_eff_dt":
				if(!ComChkObjValid(obj)){
					obj.value = "";
					obj.focus();
				};
			break;
		}
	} 
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "s_to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "s_eff_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		}
	}
	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_fm_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_to_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_eff_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}

	/**
	 * sheet내의 combo를 가져와서 등록한다.(셀단위)
	 * @param sheetObj - sheet객체
	 * @param formObject - 검색조건이 되는 form 객체
	 * @param row - combo가 세팅될 row
	 * @param colName - combo가 세팅될 컬럼alias
	 * @param value - 조회조건 location값
	 **/
	function getCntYardOriginDestSheetCombo(sheetObj, formObject, row, col, colName, value)
	{
		var srcValue = sheetObj.CellValue(row, colName);
		sheetObj.InitCellProperty(row, colName, dtCombo);
		
		if (colName == "dor_nod_yard") {
			is_zone = "Y";
		}else{
			is_zone = "";
		}
		
		formObject.f_cmd.value = SEARCH01;
		var queryString = "isZone="+is_zone+"&srcValue="+srcValue+"&col="+colName+"&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
		sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
		
		fm_yard_value = sheetObj.EtcData('nod');
		sheetObj.RemoveEtcData();
		sheetObj.CellComboItem(row, colName, " |"+fm_yard_value, " |"+fm_yard_value);

		if(fm_yard_value == '')
		{
			ComShowMessage(ComGetMsg('COM12161', value));
			sheetObj.CellValue2(row, col)="";
			sheetObj.SelectCell(row, col);
		}

	}