/*=========================================================
*@FileName : EES_CIM_0064.js
*Copyright(c) 2011 CyberLogitec
*@FileTitle : UC Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.09
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History
=========================================================*/
/**
 * @extends 
 * @class EES_CIM_0064 : invoice office authority management
 */
 function EES_CIM_0064(){
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

// Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

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
			// 조회.
			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject,formObject,IBSEARCH);						
				}											
				break;
			// 화면 초기화.	
			case "btn_new":
				init_form();
				break;
			// 엑셀 다운로드.	
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			// 조회조건 Date 팝업.	
			case "btns_calendar":
				getCalendar();
				break;
			// 팝업 테스트.	
			case 'btng_Shipper':
				openFileUploadPopup('UC1232014002','SHI','','');	// UC Details - Shipper 팝업 호출
				break;
			case 'btng_Consignee':
				openFileUploadPopup('UC1232014002','CON','','');	// UC Details - Consignee 팝업 호출
				break;
			case 'btng_Activity':
				openUcActivityPopup('UC1232014002','UCA','N');	// UC Activity 팝업 호출
				break;
			case 'btng_vol_dtl_cs':
				openVolDtlPopup('UC1232014002','','N');	// UC Case No만 입력 시 해당 데이터만 조회하는 팝업호출
				break;
			case 'btng_vol_dtl_bl':
				openVolDtlPopup('','DXB306366601','N');	// BL No만 입력 시 컨테이너 멀티선택할 수 있는 팝업호출 - Contract of Carriage에서 사용
				break;
			case 'btng_inv_exchange':
				openHelpExchangePopup('inv');	// UC Details - Invoice Value 팝업 호출
				break;
			case 'btng_cur_exchange':
				openHelpExchangePopup('crnt');	// UC Details - Current Value 팝업 호출
				break;
			case 'btng_ots_exchange':
				openHelpExchangePopup('ots');	// Outstanding Charge & Cost - Help Exchange 팝업 호출
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
 
 /*     *//**
  * IBMultiCombo Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
 function setComboObject(combo_obj) {
	 comboObjects[comboCnt++] = combo_obj;
 }

 function loadPage() {
	 for(i=0;i<sheetObjects.length;i++){
		 //-시작 환경 설정 함수 이름 변경
		 ComConfigSheet(sheetObjects[i]);
		 initSheet(sheetObjects[i],i+1);
		 //-마지막 환경 설정 함수 추가
		 ComEndConfigSheet(sheetObjects[i]);
	 }
	// IBMultiCombo초기화 
    for(var k=0;k<comboObjects.length;k++){  	    	
        initCombo(comboObjects[k],k+1);
    } 		 

    getComboList(document.uc_sts_cd , uc_sts_cdCode , uc_sts_cdText , ''); 					// 멀티 콤보 (UC Status) 설정
    getComboList(document.uc_disp_opt_cd , uc_disp_opt_cdCode , uc_disp_opt_cdText , ''); 	// 멀티 콤보 (UC Type) 설정
    getComboList(document.uc_rsn_cd , uc_rsn_cdCode , uc_rsn_cdText , ''); 					// 멀티 콤보 (Disposal) 설정
    getComboList(document.uc_piclb_cd , uc_piclb_cdCode , uc_piclb_cdText , ''); 			// 멀티 콤보 (P&I Cover) 설정
    
    // 조회조건 설정(A, B)
    //chg_retrieve_gb();
    
	//html컨트롤 이벤트초기화
	initControl();
	chg_case_gb();
	chg_retrieve_gb();
 }
 
 
 /**
  * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에
  * 붙인 일련번호 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form;   
	switch(comboNo) {       
	case 1: 
		with (comboObj) {	
		       // UC Stats
			   DropHeight = 320;                         
		}   
		break;   
	case 2: 
		with (comboObj) { 
			   // UC Seq
			   DropHeight = 320; 
		}   
		break; 
	case 3: 
		with (comboObj) { 
			   // UC RSN CD
			   DropHeight = 320;
		}   
		break; 
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
    	case 1:      //sheet1 init
	    	with (sheetObj) {
				// 높이 설정
//    			alert(GetSheetHeight(20));
				style.height = GetSheetHeight(14);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			    //전체Edit 허용 여부 [선택, Default false]
			    Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);

				var HeadTitle1 = "SEQ|Case No|Status|HNDL RHQ|HDNL OFC|Counter RHQ|Counter OFC|VVD|B/L No|No. of B/L|CNTR No|TP/SZ|No. of CNTR|Commodity|Shipper|Consignee|Notify Party|POL|POL DT|POD|POD DT|UC Date|Close Date|Creation Date|Update Date|UC Days|Days from Disc|UC Reasons|Disposal|Charge & Cost|Recovered|Net Loss|1st Notice|2nd Notice|3rd Notice|Final Notice|P&I Club|P&I Cover|Handler|Fact Findings & Activities|Handing Office Opinion|Counter Office Opinion|Local Hemo|HO Hemo";
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				//InitColumnInfo(58, 3, 0, true);
				InitColumnInfo(headCount, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				HeadRowHeight = 12;
				//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       30,   daRight,   	true,   "rnum",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       90,  	daCenter,   true,   "uc_cs_no",         	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,   true,   "uc_sts_cd",         	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       65,  	daCenter,   true,   "hndl_rhq_cd",        	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       63,  	daCenter,   true,   "hndl_brnc_cd",       	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       80,  	daCenter,   true,   "kntr_rhq_cd",        	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       80,  	daCenter,   true,   "kntr_brnc_cd",       	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       75,  	daCenter,   true,   "vvd",         			false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       87,  	daCenter,   true,   "bl_no",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       87,  	daCenter,   true,   "bl_cnt",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       80,  	daCenter,  	true,   "cntr_no",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       50,  	daCenter,  	true,   "cntr_tpsz_cd",         false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       80,  	daCenter,  	true,   "cntr_cnt",        		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       290,  daLeft,   	true,   "cmdt",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       290,  daLeft,   	true,   "shpr",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       290,  daLeft,   	true,   "cnee",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       290,  daLeft,   	true,   "noti",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       47,  	daCenter,   true,   "pol_cd",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       70,  	daCenter, 	true,   "pol_etd",         		false,    "",      dfUserFormat2,   0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       47,  	daCenter,  	true,   "pod_cd",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       70,  	daCenter, 	true,   "pod_eta",         		false,    "",      dfUserFormat2,   0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       70,  	daCenter, 	true,   "cnee_uc_dt",         	false,    "",      dfUserFormat2,   0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       70,  	daCenter, 	true,   "uc_clz_dt",         	false,    "",      dfUserFormat2,   0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       85,  	daCenter, 	true,   "cre_dt",         		false,    "",      dfUserFormat2,   0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       85,  	daCenter, 	true,   "upd_dt",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       53,  	daRight,  	true,   "uc_dys",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       89,  	daRight,  	true,   "days_from_disc",     	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       70,  	daCenter,   true,   "uc_rsn_cd",     		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       57,  	daCenter,   true,   "uc_disp_opt_cd",     	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       100,  daRight,  	true,   "ots_otr_cost_amt",   	false,    "",      dfFloat,         2,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       100,  daRight,  	true,   "ots_rcvr_amt",       	false,    "",      dfFloat,         2,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       100,  daRight,  	true,   "net_loss",         	false,    "",      dfFloat,         2,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       70,  	daCenter, 	true,   "uc_cgo_n1st_ntc_dt", 	false,    "",      dfUserFormat2,   0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       70,  	daCenter, 	true,   "uc_cgo_n2nd_ntc_dt", 	false,    "",      dfUserFormat2,   0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       70,  	daCenter, 	true,   "uc_cgo_n3rd_ntc_dt", 	false,    "",      dfUserFormat2,   0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       70,  	daCenter, 	true,   "uc_cgo_fnl_ntc_dt",  	false,    "",      dfUserFormat2,   0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       100,  daCenter,   true,   "uc_piclb_cd",       	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,       100,  daCenter,   true,   "ots_insur_cvr_amt",  	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        70,  daCenter,   true,   "hndl_upd_id",        	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);

				InitDataProperty(0, cnt++ , dtData,        200,  daLeft,   true,   "fact_fnd_act_desc",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        200,  daLeft,   true,   "hndl_ofc_opin_desc",    false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        200,  daLeft,   true,   "kntr_ofc_opin_desc",    false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        200,  daLeft,   true,   "uc_cgo_rhq_mm_desc",    false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
				InitDataProperty(0, cnt++ , dtData,        200,  daLeft,   true,   "uc_cgo_ho_mm_desc",     false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);

				//그리드 코드:네임 셋팅
				// UC Type(UC_RSN_CD)은 그리드에 없음
				//InitDataCombo(0, 'uc_sts_cd', UF_getComboStringForSheet(uc_sts_cdCode, uc_sts_cdText),uc_sts_cdCode);
				//InitDataCombo(0, 'uc_disp_opt_cd', UF_getComboStringForSheet(uc_disp_opt_cdCode, uc_disp_opt_cdText),uc_disp_opt_cdCode);
				
				//dfUserFormat2
				InitUserFormat2(0, "pol_etd", "####-##-##", "-|:" );
				InitUserFormat2(0, "pod_eta", "####-##-##", "-|:" );
				InitUserFormat2(0, "cre_dt", "####-##-##", "-|:" );
				InitUserFormat2(0, "uc_cgo_n1st_ntc_dt", "####-##-##", "-|:" );
				InitUserFormat2(0, "uc_cgo_n2nd_ntc_dt", "####-##-##", "-|:" );
				InitUserFormat2(0, "uc_cgo_n3rd_ntc_dt", "####-##-##", "-|:" );
				InitUserFormat2(0, "uc_cgo_fnl_ntc_dt", "####-##-##", "-|:" );
				InitUserFormat2(0, "cnee_uc_dt", "####-##-##", "-|:" );
				InitUserFormat2(0, "uc_clz_dt", "####-##-##", "-|:" );
				
			}
			break;
		}
	}

	/**
	 * Sheet 조회후 처리. 
	 * 
	 * @param {ibsheet}		sheetObj	sheet Objcet
	 **/
	function sheet1_OnSearchEnd(sheetObj){
	
		// 멀티 콤보 (UC Status)
		var ucStsComboNoList = uc_sts_cdCode;
		var ucStsComboNmList = uc_sts_cdText;
		var ucStsComboNoArray = new Array();
		var ucStsComboNmArray = new Array();
		ucStsComboNoArray = ucStsComboNoList.split("|");
   		ucStsComboNmArray = ucStsComboNmList.split("|");
   		// 멀티 콤보 (Disposal)
		var ucDispOptComboNoList = uc_disp_opt_cdCode;
		var ucDispOptComboNmList = uc_disp_opt_cdText;
		var ucDispOptComboNoArray = new Array();
		var ucDispOptComboNmArray = new Array();
		ucDispOptComboNoArray = ucDispOptComboNoList.split("|");
   		ucDispOptComboNmArray = ucDispOptComboNmList.split("|");
		// 멀티 콤보 (P&I Cover)
		var ucPiclbComboNoList = uc_piclb_cdCode;
		var ucPiclbComboNmList = uc_piclb_cdText;
		var ucPiclbComboNoArray = new Array();
		var ucPiclbComboNmArray = new Array();
		ucPiclbComboNoArray = ucPiclbComboNoList.split("|");
   		ucPiclbComboNmArray = ucPiclbComboNmList.split("|");
   		
   		// 멀티 콤보 (UC Reasons)
   		var ucRsnComboNoList = uc_rsn_cdCode;
   		var ucRsnComboNmList = uc_rsn_cdText;
   		var ucRsnComboNoArray = new Array();
   		var ucRsnComboNmArray = new Array();
   		ucRsnComboNoArray = ucRsnComboNoList.split("|");
   		ucRsnComboNmArray = ucRsnComboNmList.split("|");
   
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			//멀티 콤보 (UC Status)
	   		for(var j=0; j<ucStsComboNoArray.length; j++)
	   		{
				if(sheetObj.CellValue(i,'uc_sts_cd')==ucStsComboNoArray[j]){
					sheetObj.ToolTipText(i,'uc_sts_cd') = ucStsComboNmArray[j];
				}
	   		}
	   		//멀티 콤보 (Disposal)
	   		for(var k=0; k<ucDispOptComboNoArray.length; k++)
	   		{
				if(sheetObj.CellValue(i,'uc_disp_opt_cd')==ucDispOptComboNoArray[k]){
					sheetObj.ToolTipText(i,'uc_disp_opt_cd') = ucDispOptComboNmArray[k];
				}
	   		}
			//멀티 콤보 (P&I Cover)
	   		for(var j=0; j<ucPiclbComboNoArray.length; j++)
	   		{
				if(sheetObj.CellValue(i,'uc_piclb_cd')==ucPiclbComboNoArray[j]){
					sheetObj.ToolTipText(i,'uc_piclb_cd') = ucPiclbComboNmArray[j];
				}
	   		}
	   		//멀티 콤보 (UC Reason)
	   		for(var j=0; j<ucRsnComboNoArray.length; j++)
	   		{
	   			if(sheetObj.CellValue(i,'uc_rsn_cd')==ucRsnComboNoArray[j]){
	   				sheetObj.ToolTipText(i,'uc_rsn_cd') = ucRsnComboNmArray[j];
	   			}
	   		}
		} 		    	
	}
 
 /**
  * Sheet관련 프로세스 처리
  */
  function doActionIBSheet(sheetObj,formObj,sAction) {
	try {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			// 조회. 
	        case IBSEARCH:
		        formObj.f_cmd.value = SEARCH01;
		        sheetObj.DoSearch("EES_CIM_0064GS.do", FormQueryString(formObj));
		        break;
		     // 엑셀 다운로드.    
  			case IBDOWNEXCEL:
  				sheetObj.SpeedDown2Excel(true);
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
  * 조회시 필수 항목 유효성검증 프로세스 처리 (조회조건:1 - 3개중에 하나이상 keyword는 필수 입력)
  */
 function validateFormSearch(formObj){
		var lvUcCsNo = ComTrimAll(formObj.s_uc_cs_no.value, " ");
		var lvBlNo = ComTrimAll(formObj.s_bl_no.value, " ");
		var lvCntrNo = ComTrimAll(formObj.s_cntr_no.value, " ");

		if (document.form.s_retrieve_gb[0].checked) {
			if( lvUcCsNo == "" && lvBlNo == "" && lvCntrNo == "" ) {
				errMsg = ComGetMsg("CIM30032");
				ComShowMessage(errMsg);
				return false;
			}
		}else{
			if (ComTrim(formObj.s_cnee_uc_dt_fr.value) == "" || ComTrim(formObj.s_cnee_uc_dt_to.value) == ""){
				ComShowCodeMessage("CIM21001", "Date");
				return false;
			}
		}
		return true;
	}
 
 /**
  * Date 멀티 달력 입력 Pop-Up
  */
 function getCalendar() {
 	var cal = new ComCalendarFromTo();
 	if (document.form.s_retrieve_gb[1].checked) {
	 	cal.displayType = "date";
	 	cal.select(document.form.s_cnee_uc_dt_fr, document.form.s_cnee_uc_dt_to, 'yyyy-MM-dd');
 	}
 }
 
 /**
  * Date 멀티 달력 입력 Pop-Up - 일자에 더하기를 한다. - 사용하지 않음
  */
 function getDateBetween(obj) {
 	//document.form.s_cnee_uc_dt_to.value = ComGetDateAdd(obj.value,'d', 14, '');
 }

  /**
   * UC Status 선택시 textfield의 값 변경하는 이벤트
   */
  function uc_sts_cd_OnChange(combo, Index_Code, Text) {
	  if ( document.form.uc_sts_cd_nm.value == Text )  return;
	  document.form.uc_sts_cd_nm.value = combo.GetText(Index_Code,1);
  }
  
  /**
   *  Disposal 선택시 textfield의 값 변경하는 이벤트
   */
  function uc_disp_opt_cd_OnChange(combo, Index_Code, Text) {
	  if ( document.form.uc_disp_opt_cd_nm.value == Text )  return;
	  document.form.uc_disp_opt_cd_nm.value = combo.GetText(Index_Code,1);
  }
  
  /**
   * UC Type 선택시 textfield의 값 변경하는 이벤트
   */
  function uc_rsn_cd_OnChange(combo, Index_Code, Text) {
	  if ( document.form.uc_rsn_cd_nm.value == Text )  return;
	  document.form.uc_rsn_cd_nm.value = combo.GetText(Index_Code,1);
  }

  /**
   * 조회구분(Radio Button) Click Event
   */
  function chg_retrieve_gb() {
		var formObj = document.form;
		
		if (formObj.s_retrieve_gb[0].checked) {
			ComEnableObject(formObj.s_uc_cs_no,true);
			ComEnableObject(formObj.s_bl_no,true);
			ComEnableObject(formObj.s_cntr_no,true);
			formObj.s_case_gb[0].disabled = true;// 라디오 버튼 비활성화
			formObj.s_case_gb[1].disabled = true;// 라디오 버튼 비활성화
			formObj.s_case_gb[0].checked = true;
			byCaseFlag=="A";
			chg_case_gb();
			
			ComEnableObject(formObj.s_cnee_uc_dt_gb,false);
			//ComEnableObject(formObj.s_cnee_uc_dt_fr,false);
			//ComEnableObject(formObj.s_cnee_uc_dt_to,false);
			ComEnableObject(formObj.s_hndl_rhq_cd,false);
			ComEnableObject(formObj.s_hndl_brnc_cd,false);
			ComEnableObject(formObj.s_uc_dys_gb,false);
			ComEnableObject(formObj.s_uc_dys_fr,false);
			ComEnableObject(formObj.s_uc_dys_to,false);
			ComEnableObject(formObj.s_kntr_rhq_cd,false);
			ComEnableObject(formObj.s_kntr_brnc_cd,false);
			ComEnableObject(formObj.s_pol_cd,false);
			ComEnableObject(formObj.s_pod_cd,false);
			formObj.uc_sts_cd.Enable = false;
			formObj.uc_disp_opt_cd.Enable = false;
			formObj.uc_rsn_cd.Enable = false;
			
			formObj.s_cnee_uc_dt_gb.value = "";
			formObj.s_cnee_uc_dt_fr.value = "";
			formObj.s_cnee_uc_dt_to.value = "";
			formObj.s_hndl_rhq_cd.value = "";
			formObj.s_hndl_brnc_cd.value = "";
			formObj.s_uc_dys_gb.value = "";
			formObj.s_uc_dys_fr.value = "";
			formObj.s_uc_dys_to.value = "";
			formObj.s_kntr_rhq_cd.value = "";
			formObj.s_kntr_brnc_cd.value = "";
			formObj.s_pol_cd.value = "";
			formObj.s_pod_cd.value = "";
			formObj.uc_sts_cd.Code = "";
			formObj.uc_disp_opt_cd.Code = "";
			formObj.uc_rsn_cd.Code = "";
		} else if(formObj.s_retrieve_gb[1].checked) {
			
			ComEnableObject(formObj.s_uc_cs_no,false);
			ComEnableObject(formObj.s_bl_no,false);
			ComEnableObject(formObj.s_cntr_no,false);
			ComEnableObject(formObj.s_cnee_uc_dt_gb,true);
			//ComEnableObject(formObj.s_cnee_uc_dt_fr,true);
			//ComEnableObject(formObj.s_cnee_uc_dt_to,true);
			formObj.s_cnee_uc_dt_gb.value = "A";
			formObj.s_cnee_uc_dt_fr.value = formObj.date_fr.value;
			formObj.s_cnee_uc_dt_to.value = formObj.date_to.value;
			ComEnableObject(formObj.s_hndl_rhq_cd,true);
			ComEnableObject(formObj.s_hndl_brnc_cd,true);
			ComEnableObject(formObj.s_uc_dys_gb,true);
			ComEnableObject(formObj.s_uc_dys_fr,true);
			ComEnableObject(formObj.s_uc_dys_to,true);
			ComEnableObject(formObj.s_kntr_rhq_cd,true);
			ComEnableObject(formObj.s_kntr_brnc_cd,true);
			ComEnableObject(formObj.s_pol_cd,true);
			ComEnableObject(formObj.s_pod_cd,true);
			formObj.uc_sts_cd.Enable = true;
			formObj.uc_disp_opt_cd.Enable = true;
			formObj.uc_rsn_cd.Enable = true;
			formObj.s_case_gb[0].disabled  = false;// 라디오 버튼 활성화
			formObj.s_case_gb[1].disabled  = false;// 라디오 버튼 활성화

			formObj.s_uc_cs_no.value = "";
			formObj.s_bl_no.value = "";
			formObj.s_cntr_no.value = "";
		}
  }
  /**
   * 조회구분(Radio Button) Click Event
   */
  var byCaseFlag = "A";
  function chg_case_gb() {
	  var formObj = document.form;
	  var sheetObj = sheetObjects[0];
	  
	  if (formObj.s_case_gb[0].checked) { // By Container
		  if(byCaseFlag=="B"){
			  sheetObj.RemoveAll();
		  }
		  byCaseFlag = "A";
		  sheetObj.ColHidden("cntr_cnt") = true; 
		  sheetObj.ColHidden("bl_cnt") = true; 
		  sheetObj.ColHidden("ots_rcvr_amt") = true; 
		  sheetObj.ColHidden("ots_otr_cost_amt") = true; 
		  sheetObj.ColHidden("net_loss") = true; 
		  sheetObj.ColHidden("bl_no") = false; 
		  sheetObj.ColHidden("ots_insur_cvr_amt") = false; 
		  sheetObj.ColHidden("cntr_no")  = false; 
		  sheetObj.ColHidden("cntr_tpsz_cd")  = false; 
		  sheetObj.ColHidden("cmdt") = false; 
		  sheetObj.ColHidden("shpr") = false; 
		  sheetObj.ColHidden("cnee") = false; 
		  sheetObj.ColHidden("noti") = false; 
		  sheetObj.ColHidden("uc_cgo_n1st_ntc_dt") = false; 
		  sheetObj.ColHidden("uc_cgo_n2nd_ntc_dt") = false; 
		  sheetObj.ColHidden("uc_cgo_n3rd_ntc_dt") = false; 
		  sheetObj.ColHidden("uc_cgo_fnl_ntc_dt") = false; 
		  sheetObj.ColHidden("uc_piclb_cd") = false; 
		  sheetObj.ColHidden("vvd") = false; 
		  sheetObj.ColHidden("pol_etd") = false; 
		  sheetObj.ColHidden("pod_eta") = false; 
		  
		  sheetObj.ColHidden("fact_fnd_act_desc") = false; 
		  sheetObj.ColHidden("hndl_ofc_opin_desc") = false;
		  sheetObj.ColHidden("kntr_ofc_opin_desc") = false;
		  sheetObj.ColHidden("uc_cgo_rhq_mm_desc") = false;
		  sheetObj.ColHidden("uc_cgo_ho_mm_desc") = false;
		  sheetObj.ColHidden("upd_dt") = false;
		  
	  } else if(formObj.s_case_gb[1].checked) { // By Case
		  if(byCaseFlag=="A"){
			  sheetObj.RemoveAll();
		  }
		  byCaseFlag = "B";
		  sheetObj.ColHidden("cntr_cnt") = false; 
		  sheetObj.ColHidden("bl_cnt") = false; 
		  sheetObj.ColHidden("ots_rcvr_amt") = false; 
		  sheetObj.ColHidden("ots_otr_cost_amt") = false; 
		  sheetObj.ColHidden("net_loss") = false; 
		  sheetObj.ColHidden("bl_no") = true; 
		  sheetObj.ColHidden("ots_insur_cvr_amt") = true; 	
		  sheetObj.ColHidden("cntr_no")  = true; 
		  sheetObj.ColHidden("cntr_tpsz_cd")  = true; 
		  sheetObj.ColHidden("cmdt") = true; 
		  sheetObj.ColHidden("shpr") = true; 
		  sheetObj.ColHidden("cnee") = true; 
		  sheetObj.ColHidden("noti") = true; 
		  sheetObj.ColHidden("uc_cgo_n1st_ntc_dt") = true; 
		  sheetObj.ColHidden("uc_cgo_n2nd_ntc_dt") = true; 
		  sheetObj.ColHidden("uc_cgo_n3rd_ntc_dt") = true; 
		  sheetObj.ColHidden("uc_cgo_fnl_ntc_dt") = true; 
		  sheetObj.ColHidden("uc_piclb_cd") = true; 
		  sheetObj.ColHidden("vvd") = true; 
		  sheetObj.ColHidden("pol_etd") = true; 
		  sheetObj.ColHidden("pod_eta") = true; 
		  
		  sheetObj.ColHidden("fact_fnd_act_desc") = true; 
		  sheetObj.ColHidden("hndl_ofc_opin_desc") = true;
		  sheetObj.ColHidden("kntr_ofc_opin_desc") = true;
		  sheetObj.ColHidden("uc_cgo_rhq_mm_desc") = true;
		  sheetObj.ColHidden("uc_cgo_ho_mm_desc") = true;
		  sheetObj.ColHidden("upd_dt") = true;
	  }
  }
   
  /**
   * New 버튼 클릭시 화면 초기화.
   */
  function init_form() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		formObj.s_uc_cs_no.value = "";
		formObj.s_bl_no.value = "";
		formObj.s_cntr_no.value = "";
//		formObj.s_cnee_uc_dt_gb.value = "";
//		formObj.s_cnee_uc_dt_fr.value = "";
//		formObj.s_cnee_uc_dt_to.value = "";
		formObj.s_hndl_rhq_cd.value = "";
		formObj.s_hndl_brnc_cd.value = "";
		formObj.s_uc_dys_gb.value = "";
		formObj.s_uc_dys_fr.value = "";
		formObj.s_uc_dys_to.value = "";
		formObj.s_kntr_rhq_cd.value = "";
		formObj.s_kntr_brnc_cd.value = "";
		formObj.s_pol_cd.value = "";
		formObj.s_pod_cd.value = "";
		
		formObj.uc_sts_cd.Code = "";
		formObj.uc_disp_opt_cd.Code = "";
		formObj.uc_rsn_cd.Code = "";
		
		sheetObj.RemoveAll();
	    // By Case 초기화
		formObj.s_case_gb[0].checked= true;	
	    
		formObj.s_retrieve_gb[0].checked= true;			
		chg_retrieve_gb();
		chg_case_gb();
	}
  
  /**
   * 외부 콤보박스의 리스트 가져오기 Rail Road
   **/
   function getComboList( combo , code , text , option) {
		var comboNoList = code;
		var comboNmList = text;
		var comboNoArray = new Array();
		var comboNmArray = new Array();
   
		comboNoArray = comboNoList.split("|");
   		comboNmArray = comboNmList.split("|");
   
   		combo.RemoveAll();

   		for(var i=0; i<comboNoArray.length; i++)
   		{
  			combo.InsertItem(i, comboNoArray[i]+'|'+comboNmArray[i],  comboNoArray[i]);
   		}

   		combo.InsertItem(0, option ,  option);
   }

   /**
    * code1|code2|...와 name1|name2|...를 합하여 code1\tname1|code2\tname2|...형태로 return한다.
    * @param code
    * @param name
    * @return
    */
   function UF_getComboStringForSheet(code, name){

  	  var codeArr = code.split("|");
  	  var nameArr = name.split("|");
  	  
  	  if (codeArr.length == 0) return "";
  	  
  	  var cnt = codeArr.length;
  	  
  	  //둘중 짧은걸로 한다.
  	  if (codeArr.length > nameArr.length)
  		  cnt = nameArr.length;
  	  
  	  var rtnString ="";
  	  
  	  for (var inx=0; inx < cnt; inx++){
  		  if (inx==cnt-1)
  		  	  rtnString = rtnString+codeArr[inx]+" : "+nameArr[inx];
  		  else
  		  	  rtnString = rtnString+codeArr[inx]+" : "+nameArr[inx]+"|";
  	  }
  	  
  	  return rtnString;
   }

   /**
    * [Uncollected Cargo] - UC Activity 팝업을 띄우는 함수 
    * @param : uc_cs_no
    * @param : uc_cgo_file_id
    * @param : pIsReadOnly
    */
   function openUcActivityPopup(uc_cs_no, uc_cgo_file_id, pIsReadOnly) {
   	var theURL = "EES_CIM_0066.do?uc_cs_no="+uc_cs_no+"&uc_cgo_file_id="+uc_cgo_file_id+"&is_read_only="+pIsReadOnly;
   	var winName = "EES_CIM_0066";
   	var features = "scroll:no;status:no;help:no;dialogWidth:1000px;dialogHeight:550px";
   	ComOpenWindow(theURL,winName,features,true);
   }

   /**
    * [Uncollected Cargo] - UC VOL_DTL 팝업을 띄우는 함수 
    * @param : uc_cs_no
    * @param : bl_no
    * @param : pIsReadOnly
    */
   function openVolDtlPopup(uc_cs_no, bl_no, pIsReadOnly) {
   	var theURL = "EES_CIM_0070.do?uc_cs_no="+uc_cs_no+"&bl_no="+bl_no+"&is_read_only="+pIsReadOnly;
   	var winName = "EES_CIM_0070";
   	var features = "scroll:no;status:no;help:no;dialogWidth:300px;dialogHeight:500px";
   	ComOpenWindow(theURL,winName,features,true);
   }

   /**
    * [Uncollected Cargo] - UC Help Exchange 팝업을 띄우는 함수 
    * @param : exch_pop_gb
    * @param : pIsReadOnly
    */
   function openHelpExchangePopup(exch_pop_gb, pIsReadOnly) {
   	var theURL = "EES_CIM_0071.do?exch_pop_gb="+exch_pop_gb+"&is_read_only="+pIsReadOnly;
   	var winName = "openHelpExchangePopup";
   	var features = "scroll:no;status:no;help:no;dialogWidth:535px;dialogHeight:170px";
   	ComOpenWindow(theURL,winName,features,true);
   }
   
	/**KEY Event<br>
	*/
	function obj_keypress(){
		switch(event.srcElement.dataformat){
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "ymd":
			//숫자+"-"입력하기
			ComKeyOnlyNumber(event.srcElement,"-");
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			if(event.srcElement.name=="s_uc_cs_no" || event.srcElement.name=="s_bl_no" || event.srcElement.name=="s_cntr_no") ComKeyOnlyAlphabet('uppernum')
			else ComKeyOnlyAlphabet('upper');
			break;
		case "num":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('num');
			break;
		case "uppernum":
			//영문대+숫자 
			ComKeyOnlyAlphabet('uppernum');
			break;
		default:
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
		}
	} 
   
	/**KEY Event<br>
	*/
	function initControl() {
	    axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리	    
	    axon_event.addListenerFormat('blur',' obj_deactivate', document.form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	}
	
	function sheet1_OnDblClick(sheetObj,Row,Col,Value){
		var colNm = sheetObj.ColSaveName(Col);
		var sUrl = "/hanjin/EES_CIM_0063.do";
		var param = '?uc_cs_no=' + sheetObj.CellValue(Row,"uc_cs_no");
		var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=1,resizable=1";
		window.open(sUrl + param, "EES_CIM_0063", myOption);
	}
	
	function sheet1_OnClick(sheetObj,Row,Col,Value){
        var value  = sheetObj.CellValue(Row,Col);
        if(value == ""){return;}
        if( sheetObj.ColSaveName(Col) == "fact_fnd_act_desc" || sheetObj.ColSaveName(Col) == "hndl_ofc_opin_desc" || sheetObj.ColSaveName(Col) == "kntr_ofc_opin_desc" || sheetObj.ColSaveName(Col) == "uc_cgo_rhq_mm_desc" || sheetObj.ColSaveName(Col) == "uc_cgo_ho_mm_desc")
        {
            ComShowMemoPad(sheetObj, Row, Col, true);
        }
	}
	
	function obj_deactivate() {
		  var chgObj = event.srcElement;
		  // DB Validation 항목을 제외한 항목들 format check
		  if (!ComChkObjValid(chgObj)) {
			   event.srcElement.value  = "";
			   event.srcElement.select();
			   ComSetFocus(chgObj);
			   return;
		  }
   } 
