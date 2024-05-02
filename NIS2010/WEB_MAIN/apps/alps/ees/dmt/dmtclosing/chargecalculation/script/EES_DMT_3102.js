/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3102.js
*@FileTitle : Partial Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.08.03 황효근
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.04.27 김경섭 [CHM-201110831-01] [ESS-DMT] Charge Partial : SAVE시 VALIDATION 보완
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class EES_DMT_3102 : EES_DMT_3102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3102() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    

 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;

 // Yard Code Validation
 var IBCHKYARDCD = 99;
 
 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
          var sheetObj = sheetObjects[0];
          
          /*******************************************************/
          var formObj = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
 				case "btn_RowInsert":
 					processRowInsert(sheetObj);
 					break;

 				case "btn_Delete":
 					processRowDel(sheetObj);
 					break;
 			
 				case "btn_Update":
 					processUpdate();
 					break;

 				case "btn_Save":
 					doActionIBSheet(sheetObj,formObj,IBSAVE);
 					break;
 					
 				case "btn_Close":
 					window.close();
 					break;
 					
 				case "btns_calendar": //달력 버튼
					var cal = new ComCalendar();
					cal.select(formObj.upd_dt, 'yyyy-MM-dd');
					break;
					
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }
     
     
     /**
      * IBSheet Grid의 RowAdd 버튼 기능을 처리한다.
      */
     function processRowInsert(sheetObj) {
    	 sheetObj.DataAutoTrim = false;

    	 with(sheetObj) {
    		 
    		 // 미입력된  To Date가  있는지 체크
    		 for(var i=TopRow; i < LastRow; i++) {
 	 			if(CellValue(i, "to_mvmt_dt") == '') {
 	 				ComShowCodeMessage('DMT02002', 'To Date');
	 				SelectCell(i, "to_mvmt_dt");
	 				return;
 	 			}
 	 			
 	 			if(CellValue(i, "to_mvmt_yd_cd") == '') {
 	 				ComShowCodeMessage('DMT02002', 'To Yard');
	 				SelectCell(i, "to_mvmt_yd_cd");
	 				return;
 	 			}
    		 }
    		 
    		 var currRow = SelectRow;
    		 if(CellValue(currRow, "dmdt_ar_if_cd") == 'Y') {
    			 ComShowCodeMessage('DMT01024');
    			 return;
    		 }
    		 
    		 if(CellValue(currRow, "dmdt_chg_sts_cd") == 'I' && CellValue(currRow, "dmdt_ar_if_cd") == 'N') {
    			 if(!ComShowCodeConfirm('DMT01025'))
    				 return;
    			 
    			 CellValue2(currRow, "partial_mark") = 'Y';
    		 }
    		 
    		 
    		 var newRow = DataCopy();
        	 currRow = newRow-1;
        	 
        	 CellEditable(currRow, "to_mvmt_dt")	= true;
        	 CellEditable(currRow, "to_mvmt_yd_cd")	= true;
        	 
        	 
	    	 var toMvmtDt		= CellValue(currRow, "to_mvmt_dt");
	    	 var toMvmtDtTime	= CellValue(currRow, "to_mvmt_dt_time");
	    	 var toMvmtYdCd		= CellValue(currRow, "to_mvmt_yd_cd");
	    	 var toMvmtStsCd	= CellValue(currRow, "to_mvmt_sts_cd");
	    	 
	    	 CellValue2(currRow, "to_mvmt_dt")		= '';
	    	 CellValue2(currRow, "to_mvmt_sts_cd")	= "DR";
	    	 
	    	 if(toMvmtYdCd == '') {
	    		 var fmMvmtYdCd = CellValue(currRow, "fm_mvmt_yd_cd");
	    		 CellValue2(currRow, "to_mvmt_yd_cd") = fmMvmtYdCd;
	    		 toMvmtYdCd = fmMvmtYdCd;
	    	 }
	    	 
	    	 // 새로 추가된 Row의 해당 항목을 세팅한다.
	    	 CellValue2(newRow, "fm_mvmt_dt")		= '';
	    	 CellValue2(newRow, "fm_mvmt_dt_time")	= toMvmtDtTime;
	    	 CellValue2(newRow, "fm_mvmt_yd_cd")	= toMvmtYdCd
	    	 CellValue2(newRow, "fm_mvmt_sts_cd")	= 'DR';
	    	 CellValue2(newRow, "to_mvmt_dt")		= toMvmtDt;
	    	 CellValue2(newRow, "to_mvmt_sts_cd")	= toMvmtStsCd;
	    	 CellValue2(newRow, "chg_type")			= 'B';
	    	 CellValue2(newRow, "partial_mark")		= '';
//	    	 CellValue2(newRow, "ofc_trns_flg")		= 'N';
	    	 
//	    	 CellValue2(newRow, "act_cnt_cd")		= '';
//	    	 CellValue2(newRow, "bzc_trf_aply_dt")	= '';
	    	 CellValue2(newRow, "calc_dt")			= '';
	    	 CellValue2(newRow, "cfm_dt")			= '';
	    	 CellValue2(newRow, "cfm_ofc_cd")		= '';
	    	 CellValue2(newRow, "cfm_usr_id")		= '';
	    	 CellValue2(newRow, "chg_seq")			= '';
	    	 CellValue2(newRow, "corr_rmk")			= '';
	    	 CellValue2(newRow, "cre_dt")			= '';
	    	 CellValue2(newRow, "cre_ofc_cd")		= '';
	    	 CellValue2(newRow, "cre_usr_id")		= '';
	    	 //CellValue2(newRow, "cust_seq")			= '';
	    	 CellValue2(newRow, "dmdt_ar_if_cd")	= '';
	    	 CellValue2(newRow, "dmdt_chg_sts_cd")	= '';
	    	 CellValue2(newRow, "dmdt_inv_no")		= '';
	    	 CellValue2(newRow, "mvmt_umch_seq")	= '';
	    	 CellValue2(newRow, "rfa_expt_mapg_seq")= '';
	    	 CellValue2(newRow, "rfa_expt_ver_seq")	= '';
	    	 CellValue2(newRow, "sc_rfa_expt_aply_dt")	= '';
	    	 CellValue2(newRow, "web_cre_dt")		= '';
	    	 CellValue2(newRow, "web_cre_usr_id")	= '';
	    	 CellValue2(newRow, "web_ind_flg")		= '';
	    	 CellValue2(newRow, "web_mty_dt")		= '';
	    	 CellValue2(newRow, "web_ntfy_pic_nm")	= '';
	    	 CellValue2(newRow, "web_ntfy_pic_telcm_no") = '';
	    	 
	    	 SelectCell(currRow, "to_mvmt_dt");
    	 }
     }

	
     /**
      * IBSheet Grid의 RowDelete 버튼 기능을 처리한다.
      */
     function processRowDel(sheetObj) {
    	 
    	 with(sheetObj) {
	    	 var delRow = SelectRow;
	    	 
	    	 if(delRow == TopRow) {
	    		 ComShowCodeMessage('DMT01070');
				return;
	    	 }
			
	    	 if(CellValue(delRow, "dmdt_chg_sts_cd") == 'I') {
	    		 ComShowCodeMessage('DMT01026');
	    		 return;
	    	 }
	    	 
	    	 if(CellValue(delRow, "cre_usr_id") != '') {
	    		 ComShowCodeMessage('DMT01071');
	    		 return;
	    	 }
	    	 
	    	 // 삭제할 Row가 마지막 Row면, 마지막 Row - 1의 Row항목을 Setting한다. 
	    	 if(delRow == LastRow) {
	    		 var prevRow = delRow-1;
	    		 CellValue2(prevRow, "to_mvmt_dt")		= CellValue(delRow, "to_mvmt_dt");
	    		 CellValue2(prevRow, "to_mvmt_yd_cd")	= CellValue(delRow, "to_mvmt_yd_cd");
	    		 CellValue2(prevRow, "to_mvmt_sts_cd")	= CellValue(delRow, "to_mvmt_sts_cd");
	    		 //CellValue2(prevRow, "dmdt_chg_sts_cd")	= CellValue(delRow, "dmdt_chg_sts_cd");
	    	 } else {
	    		 // 삭제할 Row가 마지막 Row가 아닐때, 삭제할 Row의 일부 항목을 삭제Row + 1 Row에 Setting한다.
	    		 var nextRow = delRow + 1;
	    		 CellValue2(nextRow, "fm_mvmt_dt")		= CellValue(delRow, "fm_mvmt_dt");
	    		 CellValue2(nextRow, "fm_mvmt_yd_cd")	= CellValue(delRow, "fm_mvmt_yd_cd");
	    		 CellValue2(nextRow, "fm_mvmt_sts_cd")	= CellValue(delRow, "fm_mvmt_sts_cd");
	    		 //CellValue2(nextRow, "dmdt_chg_sts_cd")	= CellValue(delRow, "dmdt_chg_sts_cd");
	    	 }
			
	    	 RowDelete(delRow, false);
	    	 
	    	 // 2010-05-27 추가
	    	 if(CellEditable(LastRow, "to_mvmt_dt")) {
	    		 CellEditable(LastRow, "to_mvmt_dt")	= false;
	    		 CellEditable(LastRow, "to_mvmt_yd_cd")	= false;
	    	 }
    	 }
     }
   
     
     /**
      * Update 버튼 기능을 처리한다.
      */
     function processUpdate() {
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 
    	 var updDt = ComGetUnMaskedValue(formObj.upd_dt, "ymd");
    	 if(updDt != '') {
    		 //ComShowCodeMessage('DMT00102', 'Update Date');
    		 //return;
    		 
	    	 /*
	    	 ComChkPeriod(fromDate, toDate)
	    	 0 : fromDate > toDate
	    	 1 : fromDate < toDate
	    	 2 : fromDate = toDate
	    	 */
    		 //var currDt = ComGetNowInfo();
    		 var currDt = DmtComOfficeCurrDate(sheetObj, formObj);
    		 if(ComChkPeriod(updDt, currDt) != 1) {
	  			ComShowCodeMessage('DMT01022');
	  			ComSetFocus(formObj.upd_dt);
	  			return;
    		 }
    		 
    		 for(var i=sheetObj.TopRow; i <= sheetObj.LastRow; i++) {
    			 sheetObj.CellValue(i, "to_mvmt_dt") = updDt;
    		 }
    	 }
    	 
    	 var updYdCd = ComGetObjValue(formObj.upd_yd_cd);
    	 if(updYdCd != '') {
    		 for(var i=sheetObj.TopRow; i <= sheetObj.LastRow; i++) {
    			 sheetObj.CellValue(i, "to_mvmt_yd_cd") = updYdCd;
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
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         initControl();
         doInit();
	}
     
     
	function doInit() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		/*
		var dmdtTrfCd = ComGetObjValue(formObj.dmdt_trf_cd);
		var toMvmtStsCds; 
		
		switch(dmdtTrfCd) {
			case "DMIF" :
				toMvmtStsCds = 'ID|EN|TN|DR';
				break;
			case "DMOF" :
				toMvmtStsCds = 'VL|EN|TN|DR';
				break;
			case "DTIC" :
				toMvmtStsCds = 'MT|DR';
				break;
			case "DTOC" :
				toMvmtStsCds = 'OC|DR';
				break;
			case "CTIC" :
				toMvmtStsCds = 'MT|DR';
				break;
			case "CTOC" :
				toMvmtStsCds = 'VL|DR';
				break;
		} */
		
		//sheetObj.InitDataCombo(0,  "to_mvmt_sts_cd", toMvmtStsCds, toMvmtStsCds);
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		
		//var toMvmtYdCd = sheetObj.CellValue(sheetObj.TopRow, "to_mvmt_yd_cd")
		//ComSetObjValue(formObj.upd_yd_cd, toMvmtYdCd);
	}

	
	function initControl() {
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',	'obj_focus',	form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress','obj_keypress', form); //- 키보드 입력할때
		//axon_event.addListener('blur',	'sheet_blur', 'sheet1'); //- sheet focus out
		//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		//axon_event.addListenerForm('keydown', 'ComKeyEnter', document.form, 'corr_rmk');
	}
	
	
	//포커스가 나갈 때
	function obj_blur(){
		//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;
		ComChkObjValid(obj);
	}
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        ComClearSeparator(event.srcElement);
    }
    
    
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
		    	// 영문대+숫자 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //숫자 만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }
	
	

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
                     // 높이 설정
                     style.height = 202;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(66, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false, false);

                     var HeadTitle	= "|Seq.|CNTR No.|T/S|G/B|Office|From|From|From|From|To|To|To|To|INV No.|Partial|A/R|||||||||||||";
                     var HeadTitle1	= "|Seq.|CNTR No.|T/S|G/B|Office|Date|Date|Yard|STS|Date|Date|Yard|STS|INV No.|Partial|A/R|||||||||||||";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     InitHeadRow(1, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,   true,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"cntr_no",				false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"cntr_tpsz_cd",			false,	"",	dfNone,		0,	false,	false);	
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"chg_type",				false,	"",	dfNone,		0,	false,	false, -1, false, true, "General/Balance Charge Type");
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"ofc_cd",				false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"fm_mvmt_dt",			false,	"",	dfDateYmd,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,   		40,		daCenter,	true,	"fm_mvmt_dt_time",		false,	"",	dfTimeHm,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"fm_mvmt_yd_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"fm_mvmt_sts_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"to_mvmt_dt",			false,	"",	dfDateYmd,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,   		40,		daCenter,	true,	"to_mvmt_dt_time",		false,	"",	dfTimeHm,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"to_mvmt_yd_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"to_mvmt_sts_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"dmdt_inv_no",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"partial_mark",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,	"dmdt_ar_if_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		30,		daCenter,	true,	"chg_seq",				false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,  		30,		daCenter,	true,	"dmdt_chg_sts_cd",      false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"corr_rmk",             false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"mvmt_umch_seq",        false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"fm_mvmt_yr",           false,  "",	dfNone,		0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"fm_mvmt_seq",          false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"fm_mvmt_split_no",     false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"to_mvmt_yr",           false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"to_mvmt_seq",          false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"to_mvmt_split_no",     false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"bzc_trf_seq",          false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"bzc_dmdt_de_term_cd",  false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"bzc_trf_grp_seq",      false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"rfa_expt_apro_no",     false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"rfa_expt_dar_no",      false,  "",	dfNone,		0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"rfa_rqst_dtl_seq",     false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"aft_expt_apro_no",     false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"aft_expt_dar_no",      false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"aft_expt_adj_seq",     false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"sc_no",                false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"sc_expt_ver_seq",      false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"sc_expt_grp_seq",      false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cust_cnt_cd",          false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cust_seq",          	false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"act_cnt_cd",			false,  "",	dfNone,		0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"act_cust_seq",         false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cfm_dt",               false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cfm_usr_id",           false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cfm_ofc_cd",           false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cre_dt",               false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cre_usr_id",           false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cre_ofc_cd",           false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"ofc_trns_flg",         false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"calc_dt",              false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,	"web_ind_flg",          false,  "",	dfNone,		0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"web_cre_usr_id",       false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"web_cre_dt",           false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"web_ntfy_pic_nm",		false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"web_ntfy_pic_telcm_no",false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"web_mty_dt",           false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"svr_id",				false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cntr_cyc_no",			false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"dmdt_trf_cd",			false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"dmdt_chg_loc_div_cd",	false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"inv_dtl_seq",			false,  "",	dfNone,		0,	false,  false);
					
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"ft_end_dt",			false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"dul_tp_expt_flg",		false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"cxl_bkg_chg_flg",		false,  "",	dfNone,		0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,		daCenter,	true,	"ofc_rhq_cd",			false,  "",	dfNone,		0,	false,  false);
					
					
					InitDataValid(0, "to_mvmt_yd_cd", vtEngUpOther, "0123456789");
					CountPosition = 0;
					ToolTipOption = "balloon:true;width:50;";
					
					MessageText("UserMsg16") = "missing!";
 			  				
				} // with end
				break;
         } // switch end
     }

	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg = false;
	     switch(sAction) {
	
	        case IBSEARCH:      //조회
	        	//if(!validateForm(sheetObj,formObj,sAction)) return;
	        	sheetObj.WaitImageVisible = true;
	        
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("EES_DMT_3102GS.do", FormQueryString(formObj));
                break;
	
	        case IBSAVE:        //저장
	        	if(!validateForm(sheetObj,formObj,sAction)) return;
 				
				//formObj.f_cmd.value = MULTI;
				//sheetObj.DoAllSave("EES_DMT_3102GS.do", FormQueryString(formObj));
				
	        	sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
	         	
	         	formObj.f_cmd.value = COMMAND01;
	         	ComSetObjValue(formObj.backendjob_id, "PARTIAL");
	         	var params = sheetObj.GetSaveString(true, true) + "&" + FormQueryString(formObj);
	         	
	         	var sXml = sheetObj.GetSaveXml("EES_DMT_3102GS.do", params);
				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
				
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.WaitImageVisible = false;
					sheetObj.RequestTimeOut = 10000;
					timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
				}
	        	break;
	        	
	        case IBCHKYARDCD:
	        	formObj.f_cmd.value = SEARCH14;
	        	
	        	sheetObj.WaitImageVisible = false;
	    		var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	    		sheetObj.WaitImageVisible = true;
	    		
	    		var data = ComGetEtcData(sXml, "YD");
	    		
	    		if (data != undefined && data != '') {
					ComSetObjValue(formObj.yd_cd1, "Y");
				} else {
					ComSetObjValue(formObj.yd_cd1, "N");
				}
	        	break;
	     }
     }

	
	 /**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	 function getBackEndJobStatus() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[0];
	
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
	
	 	var params		= "f_cmd=" + COMMAND02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml		= sheetObj.GetSearchXml("EES_DMT_3102GS.do", params);
	 	var jobState 	= ComGetEtcData(sXml, "jb_sts_flg");
	 	
	 	// jobState == "2" BackEndJob 진행중......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob이 성공 하였습니다.
	 		getBackEndJobLoadFile();
	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		// BackEndJob을 실패 하였습니다.
	 		var jbUsrErrMsg	= ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DMT01125");
	 		
	 		ComOpenWait(false);
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		// 이미 BackEndJob 결과 파일을 읽었습니다.
	 		ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 }

	// BackEndJob 성공종료시 결과데이터를 반영한다. 
	function getBackEndJobLoadFile() {
	 	var formObj = document.form;
	 	var sheetObj = sheetObjects[0];
	 	
	 	var fCmd = MULTI;
	 	ComSetObjValue(formObj.f_cmd, fCmd);
	 	
	 	var params = "f_cmd=" + fCmd + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml = sheetObj.GetSaveXml("EES_DMT_3102GS.do", params);
	 	sheetObj.LoadSaveXml(sXml);
	 	ComOpenWait(false);
	}

	/*
	function sheet_blur() {
		var sheetObj = sheetObjects[0];
		sheet1_OnSelectCell(sheetObj, sheetObj.SelectRow, sheetObj.SelectCol, 0, 0);
	}
	
	function sheet1_OnSelectCell(sheetObj, row, col, newRow, newCol) {

		with(sheetObj) {
			var colName = ColSaveName(col);
			if(colName != 'to_mvmt_dt') return;
			
			if(row == LastRow || newRow == LastRow) return;
			
			var value = CellValue(row, col);
			if(ComIsEmpty(value)) {
				ComShowCodeMessage('DMT03028', 'To date');
				SelectCell(row, col);
				return;
			}
		}
	}*/


	 /*
	  * 셀의 값이 바뀌었을 때 발생하는 Event   OnAfterEdit
	  */
	  function sheet1_OnChange(sheetObj, row, col, value) {
		 with(sheetObj) {
			 DataAutoTrim = false;
			 if(row == LastRow) return;
			 
			 var colName = ColSaveName(col);
			 
			 if(colName == 'to_mvmt_dt' || colName == 'to_mvmt_yd_cd' || colName == 'to_mvmt_sts_cd') {
				 
				 var formObj = document.form;
				 var childRow = row+1;
				 
				 if(colName == 'to_mvmt_dt') {
					var fmMvmtDt = CellValue(row, "fm_mvmt_dt");
					var toMvmtDt = CellValue(childRow, "to_mvmt_dt");
					
					if(toMvmtDt == '' && childRow == LastRow) {
						//toMvmtDt = ComGetNowInfo();
						toMvmtDt = DmtComOfficeCurrDate(sheetObj, formObj);
					}
					
					if(ComChkPeriod(fmMvmtDt, value) != 1 || ComChkPeriod(value, toMvmtDt) != 1) {
			  			ComShowCodeMessage('DMT01023');
			  			CellValue2(row, "to_mvmt_dt") = ""; // input date clear
			  			SelectCell(row, "to_mvmt_dt");
			  			return;
		    		}
					
					// 'G' 분할
					if(row == TopRow) {
						fmMvmtDt = CellValue(row, "ft_end_dt");
						
						/*
				    	 ComChkPeriod(fromDate, toDate)
				    	 0 : fromDate > toDate
				    	 1 : fromDate < toDate
				    	 2 : fromDate = toDate
				    	 */
						if(ComChkPeriod(fmMvmtDt, value) != 1 || ComChkPeriod(value, toMvmtDt) != 1) {
							ComShowCodeMessage('DMT01073');
				  			CellValue2(row, "to_mvmt_dt") = ""; // input date clear
				  			SelectCell(row, "to_mvmt_dt");
				  			return;
			    		 }
					}
					 
					CellValue2(childRow, 'fm_mvmt_dt') = value;

				 } else if(colName == 'to_mvmt_yd_cd') {
					 var isValid = true;
					 
					 if(value == '') {
						 CellValue2(row, 'to_mvmt_yd_cd') = '';
						 CellValue2(childRow, 'fm_mvmt_yd_cd') = '';
						 return;
					 } else if(value.length < 7) {
						 isValid = false;
					 } else {
						 ComSetObjValue(formObj.yd_cd1, value);
						 // To Yard Code Validaion
						 doActionIBSheet(sheetObj, formObj, IBCHKYARDCD);
						 	
						 if(ComGetObjValue(formObj.yd_cd1) == 'N')
							 isValid = false;
					 }
					 
					 if(!isValid) {
						 ComShowCodeMessage('DMT00110', 'Yard');
						 CellValue2(row, 'to_mvmt_yd_cd') = '';
						 CellValue2(childRow, 'fm_mvmt_yd_cd') = '';
						 return;
					 }
					 
					 CellValue2(childRow, 'fm_mvmt_yd_cd') = value;
					 
				 } else
					 CellValue2(childRow, 'fm_mvmt_sts_cd') = value;
			 }
		 }
	 }
	 
	 
	 /*
	  * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	  */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		var cntrTpszCd = ComGetObjValue(formObj.cntr_tpsz_cd);	
		
		with(sheetObj) {
			for(var i = 2; i <= LastRow; i ++) {
				CellValue2(i, "cntr_tpsz_cd") = cntrTpszCd;
				//CellEditable(Row, Col) = true;
			}
		}
	}
	
	
	/**
     * 저장후 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	// 처리 성공
    	if(ErrMsg != '') return;
    	
		ComShowCodeMessage('DMT00007');
		
		var opener = window.dialogArguments;
		opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
		self.close();
    }
    
	
	/**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	 function validateForm(sheetObj,formObj,sAction){
	     
		 with(formObj){
	    	 var chgStsCd = ComGetObjValue(dmdt_chg_sts_cd);
	    	 
	    	 switch(sAction) {
	    	 	case IBSAVE:
	    	 		for(var i=sheetObj.TopRow; i < sheetObj.LastRow; i++) {
	    	 			if(sheetObj.CellValue(i, "to_mvmt_dt") == '') {
	    	 				ComShowCodeMessage('DMT02002', 'To Date');
	    	 				sheetObj.SelectCell(i, "to_mvmt_dt");
	    	 				return false;
	    	 			}
	    	 			
	    	 			if(sheetObj.CellValue(i, "to_mvmt_yd_cd") == '') {
	    	 				ComShowCodeMessage('DMT02002', 'To Yard');
	    	 				sheetObj.SelectCell(i, "to_mvmt_yd_cd");
	    	 				return false;
	    	 			}
	    	 			
	    	 			
	    	 			var arIfCd = sheetObj.CellValue(i, "dmdt_ar_if_cd");
	    	 			/*
	    	 			if(arIfCd == 'Y') {
	    	 				ComShowCodeMessage('DMT01024');
	    	 				return false;
	    	 			}
	    	 			*/
	    	 			
	    	 			if(chgStsCd == 'I' && arIfCd == 'N') {
	    	 				if(!ComShowCodeConfirm('DMT01025'))
	    	 					return false;
	    	 			}
	    	 			
	    	 			// Web MT Notification 되고  To Movement Status가 "DR" 이면,
	    	 			// 메세지 출력후 "YES" 선택하면  Web Indicator를 "N" 으로 Setting하고 Save 진행 
	    	 			var webIndFlg = sheetObj.CellValue(i, "web_ind_flg");
	    	 			var toMvmtStsCd = sheetObj.CellValue(i, "to_mvmt_sts_cd");
	    	 			
	    	 			if(webIndFlg == 'Y' && toMvmtStsCd == 'DR') {
	    	 				if(ComShowCodeConfirm('DMT01027')) {
	    	 					sheetObj.CellValue2(i, "web_ind_flg") = "N";
	    	 				} else
	    	 					return false;
	    	 			}
	    	 		} // for - end
	    	 		
	    	 		
	    	 		if(sheetObj.CellValue(sheetObj.LastRow, "to_mvmt_sts_cd") == "DR") {
	    	 			//var lastToMvmtDt = sheetObj.CellValue(sheetObj.LastRow, "to_mvmt_dt");
	    	 			//var currDt = ComGetNowInfo();
	    	 			var currDt = DmtComOfficeCurrDate(sheetObj, formObj);
	    	 			 
	    	 			for(var i=sheetObj.TopRow; i < sheetObj.LastRow; i++) {
		    	 			var toMvmtDt = sheetObj.CellValue(i, "to_mvmt_dt");
		    	 			
		    	    		 if(ComChkPeriod(toMvmtDt, currDt) != 1) {
		    		  			ComShowCodeMessage('DMT01046');
		    		  			return false;
		    	    		 }
		    	 		}
	    	 			
	    	 			 /*
	    		    	 ComChkPeriod(fromDate, toDate)
	    		    	 0 : fromDate > toDate
	    		    	 1 : fromDate < toDate
	    		    	 2 : fromDate = toDate
	    		    	 */
	    	 		}
	    	 		
	    	 		with(sheetObj) {
	    	 			//var chgSeq = 1; (2010-05-27 수정)
		    	 		for(var i=TopRow; i <= LastRow; i++) {
		    	 			//CellValue2(i, "chg_seq") = chgSeq++; (2010-05-27 수정)
		    	 			
		    	 			// 추가된 Row 일 경우
		    	 			if(CellValue(i, "cre_usr_id") == '') {
		    	 				if(CellValue(i, "to_mvmt_dt") != '')
		    	 					CellValue2(i, "dmdt_chg_sts_cd") = 'F';
		    	 				else
		    	 					CellValue2(i, "dmdt_chg_sts_cd") = 'L';
		    	 			}
		    	 		}
	    	 		}
	    	 		
	    	 		break;
	    	 		
	    	 } // switch - end
	     } // with -end
	
		 //return false;
	     return true;
	 }
    

	/* 개발자 작업  끝 */