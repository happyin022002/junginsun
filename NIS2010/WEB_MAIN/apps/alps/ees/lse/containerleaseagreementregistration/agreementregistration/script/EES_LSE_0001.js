/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0001.js
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 노정용S
*@LastVersion : 1.5
*
* 2009.05.26 노정용S
* 1.0 Creation
*
* 2009.09.16 노정용S by 이유목S
* 1.1 Modification
* Lease Term 이 'LT' 일 경우에만 Genearl Data 의 Spec No. 입력 가능.
* function Container Spec No. Cell Control 추가.
*
* 2009.10.13 노정용S by 정필성C
* 1.2 Modification
* Per-diem Location 을 제외한 각 Sheet 의 Location 은 SCC. Per-Diem Location 은 LCC.
*
* 2009.10.20 노정용S by 이유목S
* 1.3 Modification
* Creation Mode 시 General Tab 에 1 Row 추가
*
* 2010.03.02 노정용S by 정필성C
* 1.4 Modification
* Lease Term 이 LT/ST 일 경우에만 Yearly DEPR/MAX DEPR/DEPR Level 필수처리. 그 외 Term 에서는 옵션.
* DB Table(LSE_AGREEMENT) 의 관련 컬럼(DPC_VAL_FLG)이 Not Null 로 설정되어 있음.
* DPC_VAL_FLG 의 입력값이 있을 경우에만 넘김. 그렇지 않다면 컬럼의 Default 값이 입력됨.
*
* 2010.03.08 노정용S by 정필성C
* 1.5 Modification
* Per-Diem Location 도 SCC 로 변경
* 2010.12.08 남궁진호 [CHM-201007442-01] LT일때 Per-Diem LCC로 변경
* 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
* 2014.10.07 채창호  [CHM-201432294][선반영][LSE]비용지급 전표 결재 기능 - 3차
* 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 노정용
	 */

	/**
	 * @extends
	 * @class ees_lse_0001 : ees_lse_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0001() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setTabObject 			= setTabObject;
		this.setComboObject         = setComboObject;
		this.loadPage 				= loadPage;
		this.initControl            = initControl;
		this.obj_blur               = obj_blur;
		this.obj_focus              = obj_focus;
		this.obj_change             = obj_change;
		this.obj_click              = obj_click;
		this.obj_keypress           = obj_keypress;
		this.obj_keyup              = obj_keyup;
		this.obj_keydown            = obj_keydown;
		this.initSheet 				= initSheet; 
		this.initTab                = intiTab;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.t1sheet1_OnLoadFinish  = t1sheet1_OnLoadFinish;
		this.t1sheet1_OnSearchEnd	= t1sheet1_OnSearchEnd;
		this.t1sheet1_OnChange		= t1sheet1_OnChange;
		this.t1sheet1_OnPopupClick	= t1sheet1_OnPopupClick; 
		this.t2sheet1_OnPopupClick	= t2sheet1_OnPopupClick;
		this.t2sheet1_OnChange		= t2sheet1_OnChange;
		this.t3sheet1_OnPopupClick	= t3sheet1_OnPopupClick;
		this.t3sheet1_OnChange		= t3sheet1_OnChange;
		this.t4sheet1_OnPopupClick	= t4sheet1_OnPopupClick;
		this.t4sheet1_OnChange		= t4sheet1_OnChange;
		this.t5sheet1_OnSearchEnd	= t5sheet1_OnSearchEnd;
		this.tab1_OnChange			= tab1_OnChange;
		this.combo1_OnChange		= combo1_OnChange;
		this.getGeneralCntrTypeSize	= getGeneralCntrTypeSize;
		this.setCntrTypeSizeCol		= setCntrTypeSizeCol;
		this.setCntrTypeSizeRow		= setCntrTypeSizeRow;
		this.openPopupPage			= openPopupPage;
		this.setPopData_Agreement	= setPopData_Agreement;
		this.setPopData_AgreementVer= setPopData_AgreementVer;
		this.setPopData_Lessor		= setPopData_Lessor;
		this.setPopData_Currency	= setPopData_Currency;
		this.setPopData_EffDate		= setPopData_EffDate;
		this.setPopData_DeliveryLoc	= setPopData_DeliveryLoc;
		this.setPopData_CntrSpecNo	= setPopData_CntrSpecNo;
		this.setAsyncData			= setAsyncData;
		this.setFormEnable			= setFormEnable;
		this.validateForm 			= validateForm;
		this.setDuration			= setDuration;
		this.checkEffDate			= checkEffDate;
		this.checkDuplicateCol		= checkDuplicateCol;
		this.control_Spec_No		= control_Spec_No;
		this.control_Loc			= control_Loc;
	}

	/* 개발자 작업 */

	/* 공통전역변수 Start *****************************************************/
	// Tab Object Array
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	// Sheet Object Array
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;
	
	//파일업로드를 사용하기 위한
	var uploadObjects = new Array();
	var uploadCnt = 0;

	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq  = "";
	var fileUploadFlag = false;
	var fileSaveFlag = false;
	
	/* 화면 설정 구분 : 조회/신규입력/수정용 */
	var formActionType;
	/* 현재 Active 상태의 컨테이너 타입/사이즈 코드 문자열 : "|"로 연결 */
	var orgCntrTpSzCd;
	/* 현재 Active 상태의 컨테이너 타입/사이즈 코드 배열 */
	var arrOrgCntrTpSzCd;

	/* 화면 설정 구분 코드 */
	var MODE_CREATE = 1001;
	var MODE_MODIFY = 1002;
	var MODE_SEARCH = 1003;
	var MODE_VRSNUP = 1004;

	/* 각 탭의 컬럼 갯수 */
	var t2TabColCnt = 0;
	var t3TabColCnt = 0;
	var t4TabColCnt = 0;
	var t5TabColCnt = 0;

	var SEARCH_ENABLE = true;

	/* 공통전역변수 End *****************************************************/

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1  = sheetObjects[0];   //t1sheet1. General
		var sheetObject2  = sheetObjects[1];   //t2sheet1. Per-diem
		var sheetObject3  = sheetObjects[2];   //t3sheet1. Lifting Charges
		var sheetObject4  = sheetObjects[3];   //t4sheet1. DOL/DOC
		var sheetObject5  = sheetObjects[4];   //t4sheet2. Desc.
		var sheetObject6  = sheetObjects[5];   //t5sheet1. Penalty
		var sheetObject7  = sheetObjects[6];   //t6sheet1. DPP
		var sheetObject8  = sheetObjects[7];   //t7sheet1. AGMT Attach
		/*******************************************************/
		var formObj = document.form;

		//try {
			var srcObj  = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();

					/* 조회가능하도록 Form 설정 */
					setFormEnable(MODE_SEARCH, formObj);

					/* General Tab - Container Spec No. Column Hidden 처리 */
					sheetObject1.ColHidden("cntr_spec_no") = true;

					/* Per-diem Tab - Location Column Hidden 처리 */
					sheetObject2.ColHidden("loc_cd") = false;

					tabObjects[0].SelectedIndex = 0;

					/* Per-diem Tab - Container TP/SZ Column Hidden 처리 */
					for ( var i = sheetObject2.FrozenCols ; i <= sheetObject2.LastCol ; i++ ) {
						sheetObject2.ColHidden(i) = true;
					}

					/* Lifting Charges Tab - Container TP/SZ Column Hidden 처리 */
					for ( var i = sheetObject3.FrozenCols ; i <= sheetObject3.LastCol ; i++ ) {
						sheetObject3.ColHidden(i) = true;
					}

					/* DOL/DOC Tab - Container TP/SZ Column Hidden 처리 */
					for ( var i = sheetObject4.FrozenCols ; i <= sheetObject4.LastCol ; i++ ) {
						sheetObject4.ColHidden(i) = true;
					}

					/* Penalty Tab - Container TP/SZ Column Hidden 처리 */
					for ( var i = sheetObject6.FrozenCols ; i <= sheetObject6.LastCol ; i++ ) {
						sheetObject6.ColHidden(i) = true;
					}
					break;

				case "btn_Create":
					ComSetObjValue(formObj.agmt_seq, "");

					/* 입력 가능하도록 Form 설정 */
					setFormEnable(MODE_CREATE, formObj);
					break;

				case "btn_Save":
					if ( ComIsBtnEnable(srcName) ) {
						/* 저장 버튼 클릭 시 confirm window message 설정 */
						var vSaveMsgCode = "";

						if ( formActionType == MODE_CREATE ) {
							vSaveMsgCode = "COM12147";
						} else if ( formActionType == MODE_MODIFY ) {
							vSaveMsgCode = "COM12154";
						}

						/* confirm window */
						if ( ComShowCodeConfirm(vSaveMsgCode, "Lease Agreement") ) {
							doActionIBSheet(sheetObject1, formObj, IBSAVE);
						}
					}
					break;

				case "btn_VersionUp":
					if ( ComIsBtnEnable(srcName) ) {
						if ( ComShowCodeConfirm("LSE01018") ) {
							openPopupPage("4");
						}
					}
					break;

				case "btns_search1":		// Agreement Pop-up
					if ( srcObj.style.filter == "" ) {
					openPopupPage("1");
					}
					break;

				case "btns_search2":		// Lessor(Service Provider) Pop-up
					if ( srcObj.style.filter == "" ) {
						openPopupPage("2");
					}
					break;

				case "btns_search3":		// Currency Pop-up
					openPopupPage("3");
					break;

				case "btns_calendar1":		// Effective Date (FromTo)
					if ( srcObj.style.filter == "" ) {
						if ( formObj.eff_dt.className == "input2" ) {
							var cal = new ComCalendar();
							cal.setEndFunction('setDuration');
			                cal.select(formObj.exp_dt, 'yyyy-MM-dd');
						} else {
							var cal = new ComCalendarFromTo();
							ComSetObjValue(formObj.f_cmd, "0");
							cal.setEndFunction('setDuration');
							cal.select(formObj.eff_dt, formObj.exp_dt, 'yyyy-MM-dd');
						}
					}
					break;

				case "btns_calendar2":		// Agmt Date
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendar();
		                cal.select(formObj.agmt_dt, 'yyyy-MM-dd');
					}
					break;

				case "btns_calendar3":		// Build Up Date
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendar();
		                cal.select(formObj.bld_up_dt, 'yyyy-MM-dd');
					}
					break;

				case "btn_t1RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject1, formObj, IBINSERT);
					}
					break;

				case "btn_t1RowDelete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject1, "del_chk");
 						sheetObject1.CheckAll("del_chk") = 0;
 					}
					break;

				case "btn_t1LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject1, formObj, IBLOADEXCEL);
					}
					break;

				case "btn_t1DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject1, formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_t2RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject2, formObj, IBINSERT);
					}
					break;

				case "btn_t2RowDelete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject2, "del_chk");
 						sheetObject2.CheckAll("del_chk") = 0;
 					}
					break;

				case "btn_t2LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject2, formObj, IBLOADEXCEL);
					}
					break;

				case "btn_t2DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject2, formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_t3RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject3, formObj, IBINSERT);
					}
					break;

				case "btn_t3RowDelete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject3, "del_chk");
 						sheetObject3.CheckAll("del_chk") = 0;
 					}
					break;

				case "btn_t3LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject3, formObj, IBLOADEXCEL);
					}
					break;

				case "btn_t3DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject3, formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_t4RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject4, formObj, IBINSERT);
					}
					break;

				case "btn_t4RowDelete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject4, "del_chk");
 						sheetObject4.CheckAll("del_chk") = 0;
 					}
					break;

				case "btn_t4LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject4, formObj, IBLOADEXCEL);
					}
					break;

				case "btn_t4DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject4, formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_t4RowAdd2":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject5, formObj, IBINSERT);
					}
					break;

				case "btn_t4RowDelete2":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject5, "del_chk");
 						sheetObject5.CheckAll("del_chk") = 0;
 					}
					break;

				case "btn_t6LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject7, formObj, IBLOADEXCEL);
					}
					break;

				case "btn_t6DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject7, formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_t7RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
						if (sheetObject8.LastRow == 3){
							ComShowCodeMessage("LSE01156", " 3 OR less");
							return;
						}else{
							doActionIBSheet(sheetObject8, formObj, IBINSERT);
						}
					}
					break;

				case "btn_t7RowDelete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject8, "del_chk");
 						sheetObject8.CheckAll("del_chk") = 0;
 					}
					break;
				case "btns_gwcontact":
					openGwContract();
					//openresetdomain();
				    break;
			} // end switch
		//} catch(e) {
		//	if( e == "[object Error]") {
		//		ComShowMessage(OBJECT_ERROR);
		//	} else {
		//		ComShowMessage(e);
		//	}
		//}
	}
	function openresetdomain() {
		//document.domain = "";
	    alert(document.domain);	
	}

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}

    /**
     * IBMultiCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++] = combo_obj;
	}

    /**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj){
		uploadObjects[uploadCnt++] = uploadObj;
	}

	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files = "";
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj = document.form;

		orgCntrTpSzCd    = ComGetObjValue(formObj.org_cntr_tpsz_cd);
		arrOrgCntrTpSzCd = orgCntrTpSzCd.split("|");

		/* IBTab 초기화 */
		for ( var i = 0 ; i < tabObjects.length ; i++ ) {
			initTab(tabObjects[i], i+1);
		}

		/* IBSheet 초기화 */
		for ( var j = 0 ; j < sheetObjects.length ; j++ ) {
			ComConfigSheet(sheetObjects[j]);
			initSheet(sheetObjects[j], j+1);
			ComEndConfigSheet(sheetObjects[j]);
		}

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		
		ComConfigUpload(uploadObjects[0], "/hanjin/LSE_INTGS.do");

		/* Axon Control Setting*/
		initControl();

		/* Form Field Enable/Disable Setting*/
		setFormEnable(MODE_SEARCH, formObj);
	}

  	/* Axon 이벤트 처리 Start ****************************************************************************/
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
		//axon_event.addListenerFormat('beforedeactivate', 'obj_blur',formObj); //- 포커스 나갈때
  		axon_event.addListenerForm('blur', 		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerForm('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress','obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',	'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',	'obj_change',	formObj); //- 변경될때.
		axon_event.addListenerForm('click',		'obj_click',	formObj); //- 변경될때.
  	}

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur() {
		var obj = event.srcElement;

	    switch(obj.name){
	        case "agmt_seq":
	        	/* 숫자이면서 천단위 구분을 하지 않는다. */
	            //if ( !ComChkObjValid(obj, true, false, false) ) {
	            //	ComSetObjValue(obj, "");
	    		//}
	            break;

	        case "vndr_seq":
	            /* 숫자이면서 천단위 구분을 하지 않는다. */
	            ComChkObjValid(obj, true, false, false);
	            break;

	        default:
	            /* Validation 전체 체크(길이,format,최대,최소 등등) */
	            ComChkObjValid(obj);
	        	break;
	    }
  	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus(){
		var obj  = event.srcElement;
		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    /* 마스크구분자 없애기 */
		    ComClearSeparator(event.srcElement);
		}
	}

	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;

		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(obj.name) {
	    		case "agmt_seq":
	    			ComSetObjValue(formObj.agmt_ver_seq, "");
	    			if ( SEARCH_ENABLE ) {
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    			}
					break;

	    		case "vndr_seq":
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
				   	break;

	    		case "curr_cd":
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
				   	break;

	    		//case "eff_dt":
	    		//	break;
	    		case "exp_dt":
	    			setDuration();
	    			break;

	    		case "agmt_chg_val":
	    			sheetObjects[5].CellValue(1, "agmt_chg_val") = ComGetObjValue(formObj.agmt_chg_val);
	    			break;
			}
	    }
	}

	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_click(){
		var obj     = event.srcElement;
		var formObj = document.form;

		switch(obj.name) {
			case "dpp_tp_cd":
				with(sheetObjects[6]) {
	    			if ( ComGetObjValue(obj) == "Y" ) {
	    				/* DPP Coverage가 'Y'일 경우 조회모드일 경우 기존 데이터 조회 */
	    				if ( formActionType == MODE_MODIFY ) {
	    					doActionIBSheet(sheetObjects[6], formObj, IBSEARCH);
	    				}

	    				/* DPP Tab 활성화 */
	    				tabObjects[0].TabEnable(5)= true;
	    			} else {
						/* DPP Tab 비활성화 */
						tabObjects[0].TabEnable(5)= false;

	    				/* DPP Coverage가 'N'일 경우 기존 데이터 삭제처리 */
						for ( var i = HeaderRows ; i <= LastRow ; i++ ) {
							RowStatus(i)= "D";
						}
	    			}
				}
    			break;
		}
	 }

	/**
	 * HTML Control의 Key-Press Event 처리한다.
	 */
  	function obj_keypress() {
		var obj = event.srcElement;

		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	        	if ( obj.name == "lse_ctrt_no" ) {
	        		ComKeyOnlyAlphabet("num","45|95");
	        	//} else if ( obj.name == "ref_no" ) {
	        	//	ComDebug(event.keyCode);
	        	//	ComKeyOnlyAlphabet("num","8|32|44|45|46|95");
	        	} else {
	        		ComKeyOnlyAlphabet();
	        	}
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
        		ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}

  	/**
  	 * HTML Control의 Key-Up Event 처리한다.
  	 */
  	function obj_keyup() {
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
			case "agmt_seq":
  				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

 			case "vndr_seq":
  				if ( ComTrim(ComGetObjValue(obj)) == "" ) {
  					ComSetObjValue(formObj.vndr_nm,"");
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

 			default:
  				ComKeyEnter('LengthNextFocus');
  				break;
  		}
  	}

  	/**
   	 * HTML Control의 Key-Down Event 처리한다.
   	 */
  	function obj_keydown() {
  		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		switch (obj.name) {
  			case "agmt_seq":
		  		if ( vKeyCode == 13 ) {
		  			ComSetObjValue(formObj.agmt_ver_seq, "");
		  			SEARCH_ENABLE = false;
		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		  			SEARCH_ENABLE = true;
		  		}
		  		break;

  			case "lse_vndr_url":
  				// 힌글입력방지
        		if ( event.keyCode == "229" ) {
        			event.returnValue = false;
        			return true;
        		}
        		break;

  			case "agmt_rmk":
  				// 힌글입력방지
        		if ( event.keyCode == "229" ) {
        			event.returnValue = false;
        			return true;
        		}

  				if ( ComGetLenByByte(obj) > 999) {
	  				ComShowCodeMessage("LSE01021");
	  				return false;
	  			}
	  			break;
  		}
  	}
  	// 2. 이벤트처리함수 -- End
  	/* Axon 이벤트 처리 End ****************************************************************************/

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "t1sheet1":      // t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 170;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);

					var HeadTitle1 = "||TP/SZ|Spec No.|Qty|REPL Value|PUR OPT Price|PUR OPT Period|Gate In|Gate Out|Remarks|";

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,		daCenter,	false,	"del_chk");
					InitDataProperty(0, cnt++, dtCombo,			60,		daCenter,	false,	"cntr_tpsz_cd",		true,	"",	dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++, dtPopup,			100,	daCenter,	false,	"cntr_spec_no",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			70,		daRight,	false,	"qty",				false,	"",	dfInteger,	0,	true,	true,	6);
					InitDataProperty(0, cnt++, dtData,			100,	daRight,	false,	"repl_value",		false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			120,	daRight,	false,	"pur_price",		false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			120,	daRight,	false,	"pur_period",		false,	"",	dfInteger,	0,	true,	true,	5);
					InitDataProperty(0, cnt++, dtData,			95,		daRight,	false,	"gate_in",			false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			95,		daRight,	false,	"gate_out",			false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			130,	daLeft,		false,	"gen_rmk",			false,	"",	dfNone,		0,	true,	true,	500);
					InitDataProperty(0, cnt++, dtHidden,		80,		daCenter,	false,	"loc_cd",			false,	"",	dfNone);

					ColHidden("cntr_spec_no") = true;

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t2sheet1":      // t2sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 180;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 8, 100);

					var HeadTitle1 = "||LOC(LCC)|No. of TEU|"+orgCntrTpSzCd;

					t2TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t2TabColCnt, 4, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,	daCenter,	false,	"del_chk");
					InitDataProperty(0, cnt++, dtPopupEdit,		75,	daCenter,	false,	"loc_cd",		true,	"",	dfNone,			0,	false,	true, 5);
					InitDataProperty(0, cnt++, dtData,			90,	daRight,	false,	"agmt_chg_val",	false,	"",	dfNullInteger,	0,	false,	true, 6);

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_n1_amt", false, "",  dfNullFloat, 2, true, true, 6);');
					}

					InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('ColHidden("cntr'+(i+1)+'_n1_amt") = true;');
					}

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t3sheet1":      // t3sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 180;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 8, 100);

					var HeadTitle1 = "|||LOC(SCC)";
					var HeadTitle2 = "|||LOC(SCC)";

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						HeadTitle1 = HeadTitle1 + "|" + arrOrgCntrTpSzCd[i] + "|" + arrOrgCntrTpSzCd[i];
						HeadTitle2 = HeadTitle2 + "|L/On|L/Off";
					}

					t3TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t3TabColCnt, 4, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,	daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++, dtHidden,		90,	daRight,	true,	"agmt_chg_val");
					InitDataProperty(0, cnt++, dtPopupEdit,		75,	daCenter,	true,	"loc_cd",		true, "", dfNone, 0, false, true, 5);

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_n1_amt", false, "", dfNullFloat, 2, true, true, 6);');
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_n2_amt", false, "", dfNullFloat, 2, true, true, 6);');
					}

					InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('ColHidden("cntr'+(i+1)+'_n1_amt") = true;');
						eval('ColHidden("cntr'+(i+1)+'_n2_amt") = true;');
					}

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t4sheet1":      // t4sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 140;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 6, 100);

					var HeadTitle1 = "||LOC(SCC)";
					var HeadTitle2 = "||LOC(SCC)";

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						HeadTitle1 = HeadTitle1 + "|" + arrOrgCntrTpSzCd[i] + "|" + arrOrgCntrTpSzCd[i];
						HeadTitle2 = HeadTitle2 + "|DOL|DOC";
 					}

					t4TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t4TabColCnt, 3, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,	daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++, dtPopupEdit,		75,	daCenter,	true,	"loc_cd",	true, "", dfNone, 0, false, true, 5);

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 55, daRight, false, "cntr'+(i+1)+'_chg_val", false, "", dfNullInteger,	0, true, true, 6);');
						eval('InitDataProperty(0, cnt++, dtData, 65, daRight, false, "cntr'+(i+1)+'_n1_amt",  false, "", dfNullFloat,	2, true, true, 8);');
					}

					InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('ColHidden("cntr'+(i+1)+'_chg_val") = true;');
						eval('ColHidden("cntr'+(i+1)+'_n1_amt") = true;');
					}

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t4sheet2":      // t4sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 80;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					var HeadTitle1 = "||LOC(SCC)|Depot|Address|E-mail|PIC|Contact No.|Turn in Ref. No.";

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,		daCenter,	false,	"del_chk");
					InitDataProperty(0, cnt++, dtPopupEdit,		75,		daCenter,	false,	"loc_cd",				true,	"",	dfNone,		true,	false,	5);
					InitDataProperty(0, cnt++, dtData,			150,	daLeft,		false,	"dpt_desc",				false,	"",	dfNone,		true,	true,	500);
					InitDataProperty(0, cnt++, dtData,			310,	daLeft,		false,	"addr_desc",			false,	"",	dfNone,		true,	true,	500);

					InitDataProperty(0, cnt++, dtData,			130,	daLeft,		false,	"lse_pson_ctrt_eml",	false,	"",	dfNone,		true,	true,	100);
					InitDataProperty(0, cnt++, dtData,			100,	daLeft,		false,	"ctrt_pson_desc",		false,	"",	dfNone,		true,	true,	500);
					InitDataProperty(0, cnt++, dtData,			80,		daLeft,		false,	"ctrt_no_desc",			false,	"",	dfNone,		true,	true,	500);
					InitDataProperty(0, cnt++, dtData,			100,	daLeft,		false,	"turn_ref_no_desc",		false,	"",	dfNone,		true,	true,	500);

					InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;

			case "t5sheet1":      // t5sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 80;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2);

					var HeadTitle1 = "TP/SZ|"+orgCntrTpSzCd+"|||";

					t5TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t5TabColCnt, 0, 1, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//InitHeadMode(true, true, false, true, false, false);
					InitHeadMode(false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData,			70,	daCenter,	false,	"TP/SZ");

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('InitDataProperty(0, cnt++, dtData, 65, daRight, false, "cntr'+(i+1)+'_n1_amt", false, "",  dfNullFloat, 2, true, true, 8);');
 					}
					InitDataProperty(0, cnt++, dtHiddenStatus,	0,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtHidden,		90,	daRight,	true,	"loc_cd");
					InitDataProperty(0, cnt++, dtHidden,		90,	daRight,	true,	"agmt_chg_val");

					InitHeadColumn("TP/SZ", "Rate/Day", daCenter);

					for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						eval('ColHidden("cntr'+(i+1)+'_n1_amt") = true;');
					}

					CountPosition = 0;

					SelectBackColor = LSE_SELECT_BACK_COLOR;

					MessageText("UserMsg14") = "";
				}
				break;

             case "t6sheet1":      // t6sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 140;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth-20;
 					//SheetWidth = 979;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 10, 100);

                     var HeadTitle1 = "|||TP/SZ|DPP|DPP|DPP|DPP";
                     var HeadTitle2 = "|||TP/SZ|Free Days|Coverage Amt|Lump Sum Rate|Daily Rate";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false, false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	true,	"loc_cd",				false);
                     InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	true,	"cntr_rntl_chg_tp_cd",	false);
                     InitDataProperty(0, cnt++, dtData,			150,	daCenter,	true,	"cntr_tpsz_cd",			false,  "",  dfNone,	0,	false,	false);
                     InitDataProperty(0, cnt++, dtData,			195,	daRight,	true,	"agmt_chg_dys",			false,  "",  dfInteger,	0,	true,	true, 5);
                     InitDataProperty(0, cnt++, dtData,			195,	daRight,	true,	"n1st_chg_amt",			false,  "",  dfFloat,   2,	true,	true, 8);
                     InitDataProperty(0, cnt++, dtData,			195,	daRight,	true,	"agmt_chg_val",			false,  "",  dfFloat,   2,	true,	true, 8);
                     InitDataProperty(0, cnt++, dtData,			195,	daRight,	true,	"n2nd_chg_amt",			false,  "",  dfFloat,	2,	true,	true, 8);

                     SelectBackColor = LSE_SELECT_BACK_COLOR;
                 }
                 break;
 			case "t7sheet1":      // t7sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 140;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth-20;
					//SheetWidth = 979;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					var HeadTitle1 = "||Seq|File|";

					t8TabColCnt = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(t8TabColCnt, 3, 0, false);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,	40,	daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	true,	"file_dtl_seq");
					InitDataProperty(0, cnt++, dtPopupEdit,		75,	daCenter,	true,	"file_path_nm",	true, "", dfNone, 0, false, true, 5);
					InitDataProperty(0, cnt++ , dtHidden,		90,	daLeft,		false,	"org_file_nm",	false,		"",		dfNone,			0,	false,	false);

					//InitDataValid(0, "loc_cd",	vtEngUpOther , "0123456789");

					SelectBackColor = LSE_SELECT_BACK_COLOR;
				}
				break;
		}
     }

     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "General",			-1 );
                     InsertTab( cnt++ , "Per Diem",			-1 );
                     InsertTab( cnt++ , "Lifting Charge",	-1 );
                     InsertTab( cnt++ , "DOL/DOC",			-1 );
                     InsertTab( cnt++ , "Penalty",			-1 );
                     InsertTab( cnt++ , "DPP",				-1 );
                     InsertTab( cnt++ , "AGMT Attach",		-1 );
                 }
                 break;
         }
     }

	/**
	 * 콤보 초기설정값, 헤더 정의
	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			//lstm_cd
			case "combo1":
				with(comboObj) {
					DropHeight = 250;
					MultiSelect = false;
					UseAutoComplete = true;
					ValidChar(2,0);
				}
		       	break;

		    //cntr_dpc_lvl_cd
			case "combo2":
				with(comboObj) {
					DropHeight = 250;
					MultiSelect = false;
					UseAutoComplete = true;
					ValidChar(2,0);
				}
		       	break;

		    //dpc_val_flg
			case "combo3":
				with(comboObj) {
					DropHeight = 250;
					MultiSelect = false;
					UseAutoComplete = true;
					ValidChar(2,0);
				}
	        	break;
		}
	}

	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBCREATE:
				sheetObj.WaitImageVisible = false;

				/* Lease Term Form Combo Item Setting */
				ComSetObjValue(formObj.f_cmd, SEARCH01);
		     	var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		        if ( sXml != "" ) {
		        	var termNm = ComGetEtcData(sXml, "lease_term_full_nm");
		        	var termCd = ComGetEtcData(sXml, "lease_term_cd");

		        	var arrTermNm = termNm.split("|");
		        	var arrTermCd = termCd.split("|");

		        	// SELCOE 가 아닌 부서도 'OW|LP|OL|LT|ST|OF'를 제외한 Term의 Agreement를 생성할 수 있다.
		        	var j = 0;
		        	for ( var i = 0 ; i < arrTermCd.length ; i++ ) {
		        		if ( ComGetObjValue(formObj.usr_ofc_cd) == "SELCON" || ComGetObjValue(formObj.usr_ofc_cd) == "SELPPS") {
		        			comboObjects[0].InsertItem(i, arrTermCd[i]+"|"+arrTermNm[i], arrTermCd[i]);
		        		} else {
		        			if ( !(arrTermCd[i] == "OW"
		        				|| arrTermCd[i] == "LP"
		        				|| arrTermCd[i] == "OL"
		        				|| arrTermCd[i] == "LT"
		        				|| arrTermCd[i] == "ST"
		        				|| arrTermCd[i] == "OF") ) {
		        				comboObjects[0].InsertItem(j, arrTermCd[i]+"|"+arrTermNm[i], arrTermCd[i]);
		        				j++;
		        			}
		        		}
		        	}
		        	comboObjects[0].SetColWidth("40|220");
	        		//comboObjects[0].Index = 1;
		        }

		        /* DEPR Level Form Combo Item Setting */
				var strText = "Daily|Monthly|Yearly";
        		var strCode = "D|M|Y";

        		LseComText2ComboItem(comboObjects[1], strText, strCode, "|");

		        /* DPC_VAL_FLG Level Form Combo Item Setting */
				var strText2 = "Manufacture Date|On-Hire Date";
        		var strCode2 = "N|Y";

        		LseComText2ComboItem(comboObjects[2], strText2, strCode2, "|");

        		/* Container Type/Size Grid Combo Item Setting */
        		if ( orgCntrTpSzCd != "" ) {
        			sheetObj.InitDataCombo(0, "cntr_tpsz_cd", " |"+orgCntrTpSzCd, " |"+orgCntrTpSzCd);
        		}

        		ComSetFocus(formObj.agmt_seq);
        		sheetObj.WaitImageVisible = true;

		        break;

			case IBSAVE:        //저장
 			 	if ( validateForm(sheetObj,formObj,sAction) ) {
	            	if ( sheetObj.id == "t1sheet1") {
	            		/* Save Type Setting */
						if ( formActionType == MODE_CREATE ) {
							ComSetObjValue(formObj.f_cmd, ADD);
						} else if ( formActionType == MODE_MODIFY ) {
							ComSetObjValue(formObj.f_cmd, MODIFY);
						} else if ( formActionType == MODE_VRSNUP ) {
							ComSetObjValue(formObj.f_cmd, COMMAND01);
						}

	            		/* Term Value Setting */
						ComSetObjValue(formObj.lstm_cd, 		ComGetObjValue(comboObjects[0]));

						/* DEPR Level Value Setting */
						ComSetObjValue(formObj.cntr_dpc_lvl_cd, ComGetObjValue(comboObjects[1]));
						ComSetObjValue(formObj.dpc_val_flg,     ComGetObjValue(comboObjects[2]));

						/* InActive Flag Value Setting */
						if ( formObj.chk_agmt_act_flg.checked ) {
							ComSetObjValue(formObj.agmt_act_flg, "Y");
						} else {
							ComSetObjValue(formObj.agmt_act_flg, "N");
						}

						/* ICF Flag Value Setting */
						if ( formObj.chk_itchg_fee_flg.checked ) {
							ComSetObjValue(formObj.itchg_fee_flg, "Y");
						} else {
							ComSetObjValue(formObj.itchg_fee_flg, "N");
						}

						var sParam = FormQueryString(formObj);

						if ( formActionType == MODE_CREATE
							|| formActionType == MODE_MODIFY ) {

							if (sheetObjects[0].IsDataModified == true) {
								if ( validateForm(sheetObjects[0],formObj,sAction) ) {
									var sSheetParam = sheetObjects[0].GetSaveString();
									sSheetParam = ComSetPrifix(sSheetParam, "t1sheet1_");
									sParam = sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}

							if (sheetObjects[1].IsDataModified == true) {
								if ( validateForm(sheetObjects[1],formObj,sAction) ) {
									var sSheetParam = sheetObjects[1].GetSaveString();
									sSheetParam = ComSetPrifix(sSheetParam, "t2sheet1_");
									sParam = sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}

							if (sheetObjects[2].IsDataModified == true) {
								if ( validateForm(sheetObjects[2],formObj,sAction) ) {
									var sSheetParam = sheetObjects[2].GetSaveString();
									sSheetParam = ComSetPrifix(sSheetParam, "t3sheet1_");
									sParam = sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}

							if (sheetObjects[3].IsDataModified == true) {
								if ( validateForm(sheetObjects[3],formObj,sAction) ) {
									var sSheetParam = sheetObjects[3].GetSaveString();
									sSheetParam = ComSetPrifix(sSheetParam, "t4sheet1_");
									sParam = sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}

							if (sheetObjects[4].IsDataModified == true) {
								if ( validateForm(sheetObjects[4],formObj,sAction) ) {
									var sSheetParam = sheetObjects[4].GetSaveString();
									sSheetParam = ComSetPrifix(sSheetParam, "t4sheet2_");
									sParam = sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}

							if ( sheetObjects[5].CellValue(1, "agmt_chg_val") != ComGetObjValue(formObj.agmt_chg_val) ) {
								sheetObjects[5].CellValue(1, "agmt_chg_val") = ComGetObjValue(formObj.agmt_chg_val);
							}

							if (sheetObjects[5].IsDataModified == true) {
								if ( validateForm(sheetObjects[5],formObj,sAction) ) {
									if ( ComTrim(ComGetObjValue(formObj.agmt_chg_val)) == "" ) {
										ComShowCodeMessage("LSE01043");
										if ( tabObjects[0].SelectedIndex != 4 ) {
											tabObjects[0].SelectedIndex = 4;
										}
										ComSetFocus(formObj.agmt_chg_val);
										return;
									}
									/* Penalty 신규입력시 ibflag "I"로 설정, "loc_cd"를 "KRSEL"로 설정 */
									if ( formActionType == MODE_CREATE ) {
										sheetObjects[5].RowStatus(sheetObjects[5].LastRow) = "I";
										sheetObjects[5].CellValue(1, "loc_cd")       = "KRSEL";
									}

									var sSheetParam = sheetObjects[5].GetSaveString();
									sSheetParam = ComSetPrifix(sSheetParam, "t5sheet1_");
									sParam = sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}

							if (sheetObjects[6].IsDataModified == true) {
								if ( validateForm(sheetObjects[6],formObj,sAction) ) {
									var sSheetParam = sheetObjects[6].GetSaveString();
									sSheetParam = ComSetPrifix(sSheetParam, "t6sheet1_");
									sParam = sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}
							
							if (sheetObjects[7].IsDataModified == true) {
								for( var ii = sheetObjects[7].HeaderRows; ii <= sheetObjects[7].LastRow; ii++){
									if (sheetObjects[7].RowStatus(ii) != "D") sheetObjects[7].RowStatus(ii) = "I";
								}
								if ( validateForm(sheetObjects[7],formObj,sAction) ) {
									var sSheetParam = sheetObjects[7].GetSaveString();
									sSheetParam = ComSetPrifix(sSheetParam, "t7sheet1_");									
									sParam = sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}
						}

						/* Save Action */
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSaveXml("EES_LSE_0001GS.do" , sParam);
						ComOpenWait(false);

						sheetObj.LoadSaveXml(sXml);

						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							/* Return Value Setting & Re-Search Action */
							if ( formActionType == MODE_CREATE ) {
								ComShowCodeMessage("COM12149", "Lease Agreement");
								/* New Agreement Sequence Value Setting */
								ComSetObjValue(formObj.agmt_seq, ComGetEtcData(sXml, "agmt_seq"));
								doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							} else if ( formActionType == MODE_MODIFY ) {
								ComShowCodeMessage("COM12156", "Lease Agreement");
								doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							} else if ( formActionType == MODE_VRSNUP ) {
								ComShowCodeMessage("COM12116", "Lease Agreement Version-Up");
								/* New Agreement Version Sequence Value Setting */
								ComSetObjValue(formObj.agmt_ver_seq, ComGetEtcData(sXml, "agmt_ver_seq"));
								doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							}
						}
	            	}
 			 	}
                break;

			case IBSEARCH:      //조회
				/* Org 컨테이너 타입/사이즈 코드 재설정 : Form Data 설정시 Org 컨테이너 타입/사이즈 코드 데이터가 삭제됨으로 재설정. */
				ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);

				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "t6sheet1" ) {
						/* DPP Tab */
						ComSetObjValue(formObj.f_cmd, SEARCH01);
	            	} else {
						sheetObj.Redraw = false;
	            		ComSetObjValue(formObj.f_cmd, SEARCH);
	            	}

					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("EES_LSE_0001GS.do" , FormQueryString(formObj));

					if ( sheetObj.id == "t6sheet1" ) {
						sheetObj.LoadSearchXml(sXml);
						sheetObj.WaitImageVisible = true;
					} else {
						var arrXml = sXml.split("|$$|");
						if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);

						var vLstmCd = ComGetEtcData(arrXml[0],"lstm_cd");

						/* 소속부서가 "SELCOE"일 경우 모든 Agreement CRU 가능. 그 외에는 "OW,LP,OL,LT,ST,OF" CRU 불가 */
						if ( vLstmCd != undefined ) {
							if ( ComGetObjValue(formObj.usr_ofc_cd) != "SELCON" && ComGetObjValue(formObj.usr_ofc_cd) != "SELPPS") {
								if ( vLstmCd == "OW" || vLstmCd == "LP" || vLstmCd == "OL"
								  || vLstmCd == "LT" || vLstmCd == "ST" || vLstmCd == "OF" ) {
									ComShowCodeMessage("LSE01040");
									sheetObj.Redraw = true;
									ComResetAll();

									/* 조회가능하도록 Form 설정 */
									if ( formActionType != MODE_SEARCH ) {
										setFormEnable(MODE_SEARCH, formObj);
									}
									ComOpenWait(false);
									return;
								}
							}
						}

						if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
						if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
						if (arrXml.length > 3) sheetObjects[3].LoadSearchXml(arrXml[3]);
						if (arrXml.length > 4) sheetObjects[4].LoadSearchXml(arrXml[4]);
						if (arrXml.length > 5) sheetObjects[5].LoadSearchXml(arrXml[5]);
						if (arrXml.length > 6) sheetObjects[6].LoadSearchXml(arrXml[6]);
						if (arrXml.length > 7) sheetObjects[7].LoadSearchXml(arrXml[7]);
					}

					ComOpenWait(false);

					formObj.combo2.Enable = true;
					formObj.combo3.Enable = true;
				}
	            break;

			case IBSEARCH_ASYNC01:	//조회(Form Lessor No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetNextFocus(formObj.vndr_seq);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							ComSetObjValue(formObj.vndr_seq, "");
 							ComSetObjValue(formObj.vndr_nm, "");
 							ComSetFocus(formObj.vndr_seq);
 						}
					} else {
						ComShowCodeMessage("LSE01019");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}
				}
				break;

 			case IBSEARCH_ASYNC02:	//조회(Form Curr 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH07+"&curr_cd="+ComGetObjValue(formObj.curr_cd);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "curr_cd") != undefined ) {
							ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
							ComSetNextFocus(formObj.curr_cd);
						} else {
							//ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.curr_cd, "");
							ComSetFocus(formObj.curr_cd);
						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						ComSetObjValue(formObj.curr_cd, "");
						ComSetFocus(formObj.curr_cd);
					}
				}
				break;

 			case IBINSERT:
 				switch (sheetObj.id) {
 					case "t1sheet1":
 						var Row = sheetObj.DataInsert(-1);

 						/*
 						 * General Data 신규입력
 						 *  1. "LOC_CD"에 "KRSEL" 입력
 						 */
 						sheetObj.CellValue2(Row, "loc_cd") = "KRSEL";
 						sheetObj.SelectCell(Row, "cntr_tpsz_cd");

 						break;

 					case "t2sheet1":
 						var Row = sheetObj.DataInsert(-1);

 						/*
 						 * Per-diem Data 신규입력
 						 *  1. Agreement가 "LT" 일 경우 LOC_CD를 입력받으며, 아닐 경우에는 "LOC_CD"에 "KRSEL" 입력
                         *  2. Agreement가 "LT"일 경우 "AGMT_CHG_VAL"에 "1" Setting, 그외 입력받음.
 						 */
						if ( ComGetObjValue(formObj.combo1) == "LT" ) {
 							sheetObj.CellValue2(Row, "agmt_chg_val") = "1";
 							sheetObj.SelectCell(Row, "loc_cd");
 						} else {
 							sheetObj.CellValue2(Row, "loc_cd") = "KRSEL";
 							if ( sheetObj.RowCount == 1 ) {
 								sheetObj.CellValue(Row, "agmt_chg_val") = "1";
 								sheetObj.CellEditable(Row, "agmt_chg_val") = false;
 							} else {
 								sheetObj.SelectCell(Row, "agmt_chg_val");
 							}
 						}

 						break;

 					case "t3sheet1":
 						var Row = sheetObj.DataInsert(-1);
 						sheetObj.CellValue2(Row, "agmt_chg_val") = "1";
 						sheetObj.SelectCell(Row, "loc_cd");
 						break;

 					case "t4sheet1":
 						var Row = sheetObj.DataInsert(-1);
 						sheetObj.SelectCell(Row, "loc_cd");
 						break;

 					case "t4sheet2":
 						var Row = sheetObj.DataInsert(-1);
 						sheetObj.SelectCell(Row, "loc_cd");
 						break;

 					case "t7sheet1":
 						var Row = sheetObj.DataInsert(-1);
 						//sheetObj.SelectCell(Row, "");
 						break;
 				}
 				break;

 			case IBDOWNEXCEL:
 				with(sheetObj) {
 					var vSheetName = ComReplaceStr(tabObjects[0].TabText(tabObjects[0].SelectedIndex),"/","_");
					if ( ToTalRows < 1 ) {
						var row = DataInsert(0);
						RowHidden(row) = true;
						Down2Excel(-1, false, false, true, "", "", false, false, vSheetName);
						RowDelete(row, false);
					} else {
						Down2Excel(-1, false, false, true, "", "", false, false, vSheetName);
					}
 				}
 				break;

 			case IBLOADEXCEL:
 				with(sheetObj) {
 				ComOpenWait(true);

 					var vAppendStartRowIdx = 0;

					if ( RowCount == 0 ) {
						vAppendStartRowIdx = HeaderRows
					} else {
						vAppendStartRowIdx = LastRow+1;
					}

					var vAppendFlag = LoadExcel();

					switch (id) {
	 					case "t1sheet1":
							if ( vAppendFlag ) {
								for ( var idx = LastRow ; idx >= vAppendStartRowIdx ; idx-- ) {
									CellValue2(idx,"loc_cd") = "KRSEL";
									checkDuplicateCol(sheetObj, idx, "cntr_tpsz_cd", CellValue(idx,"cntr_tpsz_cd"));
								}
							}
							break;

	 					case "t2sheet1":
							if ( vAppendFlag ) {
								for ( var idx = LastRow ; idx >= vAppendStartRowIdx ; idx-- ) {
									if ( ComGetObjValue(formObj.combo1) == "LT" ) {
			 							sheetObj.CellValue2(idx, "agmt_chg_val") = "1";
			 							checkDuplicateCol(sheetObj, idx, "loc_cd", CellValue(idx,"loc_cd"));
			 							setAsyncData(sheetObj, idx, "loc_cd", CellValue(idx,"loc_cd"), "2");
			 						} else {
			 							sheetObj.CellValue2(idx, "loc_cd") = "KRSEL";
			 							checkDuplicateCol(sheetObj, idx, "agmt_chg_val", CellValue(idx,"agmt_chg_val"));
			 						}
								}
							}
							break;

	 					case "t3sheet1":
							if ( vAppendFlag ) {
								for ( var idx = LastRow ; idx >= vAppendStartRowIdx ; idx-- ) {
		 							sheetObj.CellValue2(idx, "agmt_chg_val") = "1";
		 							checkDuplicateCol(sheetObj, idx, "loc_cd", CellValue(idx,"loc_cd"));
		 							setAsyncData(sheetObj, idx, "loc_cd", CellValue(idx,"loc_cd"), "2");
								}
							}
							break;

	 					case "t4sheet1":
							if ( vAppendFlag ) {
								for ( var idx = LastRow ; idx >= vAppendStartRowIdx ; idx-- ) {
		 							checkDuplicateCol(sheetObj, idx, "loc_cd", CellValue(idx,"loc_cd"));
		 							setAsyncData(sheetObj, idx, "loc_cd", CellValue(idx,"loc_cd"), "2");
								}
							}
							break;

	 					case "t6sheet1":
							if ( vAppendFlag ) {
								for ( var idx = LastRow ; idx >= vAppendStartRowIdx ; idx-- ) {
									checkDuplicateCol(sheetObj, idx, "cntr_tpsz_cd", CellValue(idx,"cntr_tpsz_cd"));
								}
							}
							break;
					}

					ComOpenWait(false);

	 				switch (id) {
	 					case "t2sheet1":
	 					case "t3sheet1":
	 					case "t4sheet1":
							for ( var idx = LastRow ; idx >= vAppendStartRowIdx ; idx-- ) {
								if ( CellValue( idx, "loc_cd") == "" ) {
									ComShowCodeMessage("LSE01037");
									SelectCell(idx,"loc_cd");
									break;
								}
							}
	 						break;
	 				}
 				}

 				break;
		}
	}

	function t1sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}

	/**
	 * Lease Agreement Master/General Tab IBSheet Object Search-End Event
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;

		if ( ErrMsg == "" ) {

			/* 화면모드를 수정모드로 설정 */
			if ( formActionType != MODE_MODIFY ) {
				setFormEnable(MODE_MODIFY, formObj);
			}
			ComEtcDataToForm(formObj, sheetObj);

			/* InActive CheckBox Setting */
			if ( ComGetObjValue(formObj.agmt_act_flg) == "Y" ) {
				formObj.chk_agmt_act_flg.checked = true;
			} else {
				formObj.chk_agmt_act_flg.checked = false;
			}

			/* ICF Flag CheckBox Setting */
			if ( ComGetObjValue(formObj.itchg_fee_flg) == "Y" ) {
				formObj.chk_itchg_fee_flg.checked = true;
			} else {
				formObj.chk_itchg_fee_flg.checked = false;
			}

			comboObjects[0].Code = ComGetObjValue(formObj.lstm_cd);
			comboObjects[1].Code = ComGetObjValue(formObj.cntr_dpc_lvl_cd);
			comboObjects[2].Code = ComGetObjValue(formObj.dpc_val_flg);

			/* DPP Coverage 의 값이 'N' 일 경우 DPP Tab 비활성화 */
			if ( ComGetObjValue(formObj.dpp_tp_cd) == "Y" ) {
				if ( tabObjects[0].TabEnable(5) == false ) {
					tabObjects[0].TabEnable(5)= true;
				}
			} else {
				if ( tabObjects[0].TabEnable(5) == true ) {
					tabObjects[0].TabEnable(5)= false;
				}
			}

			/* Mask 추가 */
			ComAddSeparator(form.eff_dt, "ymd");
			ComAddSeparator(form.exp_dt, "ymd");
			ComAddSeparator(form.agmt_dt, "ymd");
			ComAddSeparator(form.bld_up_dt, "ymd");

			/* Duration 계산 */
			setDuration();

			/* Lease Term 에 따른 General Sheet Control */
			control_Spec_No(ComGetObjValue(formObj.combo1));

			sheetObj.Redraw = true;

			tabObjects[0].SelectedIndex = 0;

			/* Effective Date Editable 설정 */
			//ComDebug(ComGetObjValue(formObj.agmt_lst_ver_seq));
			//ComDebug(ComGetObjValue(formObj.agmt_ver_seq));
			if ( ComGetObjValue(formObj.agmt_lst_ver_seq) == ComGetObjValue(formObj.agmt_ver_seq) ) {
				if ( ComGetObjValue(formObj.agmt_lst_ver_seq) != "1" ) {
					/* Last Version 이면서 '1'이 아닌 경우 eff_dt 수정불가 */
					if ( formObj.eff_dt.className != "input2" ) {
						ComEnableObject(formObj.eff_dt, false);
					}
				} else {
					/* Last Version 이면서 '1'인 경우 eff_dt 수정가능 */
					if ( formObj.eff_dt.className != "input1" ) {
						LseComMndtForm(formObj,"eff_dt");
					}

					/* Last Version 이면서 '1'인 경우 btns_calendar1 클릭가능 */
					if ( formObj.btns_calendar1.style.filter != "" ) {
						ComEnableObject(formObj.btns_calendar1, true);
					}
				}

				if ( formObj.exp_dt.className != "input1" ) {
					LseComMndtForm(formObj,"exp_dt");
				}

				LseComBtnControl(false, "btn_Retrieve");
				LseComBtnControl(true,  "btn_Save|btn_VersionUp|btn_t1RowAdd|btn_t1RowDelete|btn_t1LoadExcel|btn_t1DownExcel|btn_t2RowAdd|btn_t2RowDelete|btn_t2LoadExcel|btn_t2DownExcel|btn_t3RowAdd|btn_t3RowDelete|btn_t3LoadExcel|btn_t3DownExcelbtn_t4RowAdd|btn_t4RowDelete|btn_t4LoadExcel|btn_t4DownExcel|btn_t4RowAdd2|btn_t4RowDelete2|btn_t6LoadExcel|btn_t6DownExcel");
			} else {
				/* Last Version 이 아니면 수정불가. */
				if ( formObj.eff_dt.className != "input2" ) {
					ComEnableObject(formObj.eff_dt, false);
				}
				if ( formObj.exp_dt.className != "input2" ) {
					ComEnableObject(formObj.exp_dt, false);
				}
				if ( formObj.btns_calendar1.style.filter == "" ) {
					ComEnableObject(formObj.btns_calendar1, false);
				}

				LseComBtnControl(true, "btn_Retrieve|btn_New|btn_Create|btn_t1DownExcel|btn_t2DownExcel|btn_t3DownExcel|btn_t4DownExcel|btn_t6DownExcel");
				LseComBtnControl(false, "btn_Save|btn_VersionUp|btn_t1RowAdd|btn_t1RowDelete|btn_t1LoadExcel|btn_t2RowAdd|btn_t2RowDelete|btn_t2LoadExcel|btn_t3RowAdd|btn_t3RowDelete|btn_t3LoadExcel|btn_t4RowAdd|btn_t4RowDelete|btn_t4LoadExcel|btn_t4RowAdd2|btn_t4RowDelete2|btn_t6LoadExcel");
			}

		} else {
			ComResetAll();

			sheetObj.Redraw = true;

			/* 조회가능하도록 Form 설정 */
			if ( formActionType != MODE_SEARCH ) {
				setFormEnable(MODE_SEARCH, formObj);
			}
		}

		/* Org 컨테이너 타입/사이즈 코드 재설정 : Form Data 설정시 Org 컨테이너 타입/사이즈 코드 데이터가 삭제됨으로 재설정. */
		ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);
	}

	/**
	 * General Tab IBSheet Object Change Event
	 */
	function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);

		switch(colName) {
			case "cntr_tpsz_cd":
				checkDuplicateCol(sheetObj, Row, colName, Value);
				break;
		}
	}

	/**
	 * Sheet의 OnPopupClick Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t1sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName = sheetObj.ColSaveName(Col);
		switch (sName) {
			case "cntr_spec_no":
				/* Delivery Location Pop-up */
				openPopupPage("6", Row, Col, 0);
				break;
	 	}
	}

	/**
	 * Sheet의 OnPopupClick Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t2sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName = sheetObj.ColSaveName(Col);
		switch (sName) {
			case "loc_cd":
				/* Delivery Location Pop-up */
				openPopupPage("5", Row, Col, 1);
				break;
	 	}
	}

	/**
	 * Sheet의 OnChange Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function t2sheet1_OnChange(sheetObj, Row, Col, Value)  {
		var sName = sheetObj.ColSaveName(Col);
		switch(sName) {
			case "loc_cd":		// Grid Location Code Check
				checkDuplicateCol(sheetObj, Row, "loc_cd", Value);
				setAsyncData(sheetObj, Row, Col, Value);
				break;
		}
 	}

	/**
	 * Sheet의 OnPopupClick Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t3sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName = sheetObj.ColSaveName(Col);
		switch (sName) {
			case "loc_cd":
				/* Delivery Location Pop-up */
				openPopupPage("5", Row, Col, 2);
				break;
		}
	}

	/**
	 * Sheet의 OnChange Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function t3sheet1_OnChange(sheetObj, Row, Col, Value)  {
		var sName = sheetObj.ColSaveName(Col);
		switch(sName) {
			case "loc_cd":		// Grid Location Code Check
				checkDuplicateCol(sheetObj, Row, "loc_cd", Value);
				setAsyncData(sheetObj, Row, Col, Value);
				break;
		}
 	}

	/**
	 * Sheet의 OnPopupClick Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t4sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName = sheetObj.ColSaveName(Col);
		switch (sName) {
			case "loc_cd":
				/* Delivery Location Pop-up */
				openPopupPage("5", Row, Col, 3);
				break;
		}
	}

	 /**
	 * Sheet의 OnPopupClick Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t4sheet2_OnPopupClick(sheetObj,Row,Col) {
		var sName = sheetObj.ColSaveName(Col);
		switch (sName) {
			case "loc_cd":
				/* Delivery Location Pop-up */
				openPopupPage("5", Row, Col, 4);
				break;
		}
	}

 	/**
 	 * Sheet의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function t7sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {

				case "file_path_nm":
					if ( fileUploadFlag ) {
			    		return;
			    	}

			    	var upObj = uploadObjects[0];
				    var fileName = sheetObj.OpenFileDialog("");
				 	//var fileName = sheetObj.OpenFileDialog("", "", "", "Excel|*.xls|Excel|*.XLS|Text|*.txt|Text|*.TXT");
				 	var relativePath = "";
				 	var fileType     = "";
					var badFile = false;

					if ( fileName.indexOf("\\") == -1 ) {
						badFile = true;
					} else {
						relativePath = fileName.substr(fileName.lastIndexOf("\\") + 1);         // File Name
						fileType     = relativePath.substr(relativePath.lastIndexOf(".") + 1);  // File Type

						//TXT, XLS
						//if ( fileType.toUpperCase() != "TXT" && fileType.toUpperCase() != "CSV" ) {
						//	badFile = true;
						//}
					}

				 	if ( !badFile ) {
				 		ComOpenWait(true);
				 		fileUploadFlag = true;
				 		sheetObj.CellValue2(Row, "file_path_nm")   = relativePath;

				 		// 기존파일을 모두 지운후 추가함
				 		upObj.Files = "";
				 		var ret  = upObj.AddFile(fileName);
						var sXml = upObj.DoUpload(true);
						uploadFileName = ComGetEtcData(sXml,"filename");
						sheetObj.CellValue2(Row, "org_file_nm") = uploadFileName;
						
						fileUploadFlag = false;
						ComOpenWait(false);
				 	} else {
				 		if ( fileName != "<USER_CANCEL>" ) {
				 			ComShowCodeMessage("LSE01097");
				 		}
					}
				 	break;
			}
 		}
    }
    
    /**
	 * sheet7_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function t7sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var linkFlag = CellValue(MouseRow, MouseCol) != "";
			DataLinkMouse("file_path_nm") = linkFlag;
		}
	}		
	
	/**
	 * sheet7_OnClick
	 */
	function t7sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);

		if(sheetObj.MousePointer != "Hand") return;

		with(sheetObj) {
			switch(sName) {
				case "file_path_nm":
					location.href = "/hanjin/FileDownload?key="+CellText(Row, "org_file_nm");
					break;
			}
		}
	}
	
	/**
	 * Sheet의 OnChange Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function t4sheet1_OnChange(sheetObj, Row, Col, Value)  {
		var sName = sheetObj.ColSaveName(Col);
		switch(sName) {
			case "loc_cd":		// Grid Location Code Check
				checkDuplicateCol(sheetObj, Row, "loc_cd", Value);
				setAsyncData(sheetObj, Row, Col, Value);
				break;
		}
 	}
	 
	/**
	 * Sheet의 OnChange Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function t4sheet2_OnChange(sheetObj, Row, Col, Value)  {
		var sName = sheetObj.ColSaveName(Col);
		switch(sName) {
			case "loc_cd":		// Grid Location Code Check
				checkDuplicateCol(sheetObj, Row, "loc_cd", Value);
				setAsyncData(sheetObj, Row, Col, Value);
				break;
		}
 	}

	/**
	 * Penalty Tab IBSheet Object Search-End Event
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;

		if ( sheetObj.SearchRows > 0 ) {
			ComSetObjValue(formObj.agmt_chg_val, sheetObj.CellValue(1,"agmt_chg_val"));
		} else {
			ComSetObjValue(formObj.agmt_chg_val, "");
			sheetObj.CellValue(1, "loc_cd") = "KRSEL";
			sheetObj.RowStatus(1) = "R";
		}
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var formObj = document.form;
		var objs    = document.all.item("tabLayer");

		objs[nItem].style.display     = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 ------------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//--------------------------------------------------------//
		beforetab = nItem;

		if ( formActionType == MODE_MODIFY || formActionType == MODE_CREATE ) {
			switch(nItem) {
				case 1 :	// Per-diem
					//if ( ComGetObjValue(formObj.combo1) == "LT" ) {
					//	sheetObjects[1].ColHidden("agmt_chg_val") = true;
					//	sheetObjects[1].ColHidden("loc_cd")       = false;
					//} else {
					//	sheetObjects[1].ColHidden("agmt_chg_val") = false;
					//	sheetObjects[1].ColHidden("loc_cd")       = true;
					//}
					control_Loc(formObj.combo1);
					break;
			}
		}

		/* General Tab에 있는 Container Type/Size Column만 Show */
		switch(nItem) {
			case 1 :	// Per-diem
				setCntrTypeSizeCol(sheetObjects[0], sheetObjects[1]);
				break;

			case 2 :	// Lifting Charges
				setCntrTypeSizeCol(sheetObjects[0], sheetObjects[2]);
				break;

			case 3 :	// DOL/DOC
				setCntrTypeSizeCol(sheetObjects[0], sheetObjects[3]);
				break;

			case 4 :	// Penalty
				setCntrTypeSizeCol(sheetObjects[0], sheetObjects[5]);
				break;

			case 5 :	// DPP
				setCntrTypeSizeRow(sheetObjects[0], sheetObjects[6]);
				break;
		}
	}

	/*
	 * Lease Term OnChange Event 처리
	 */
	function combo1_OnChange(comboObj, idx, text) {
		var formObj = document.form;
		control_Spec_No(ComGetObjValue(comboObj));
		control_Loc(ComGetObjValue(comboObj));
		if ( ComGetObjValue(comboObj) == "ST" || ComGetObjValue(comboObj) == "LT" ) {
			LseComMndtForm2(true, formObj, "dpc_rto|max_dpc_rto|combo2|combo3");
		} else {
			LseComMndtForm2(false, formObj, "dpc_rto|max_dpc_rto|combo2|combo3");
		}
	}

	/**
	 * Sheet Object 내 Container Type/Size 코드들을 문자열로 반환
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function getGeneralCntrTypeSize(sheetObj) {
		var vSelectedCntrTpSz = "";
		if ( sheetObj.RowCount > 0 ) {
			for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
				if ( sheetObj.RowHidden(i) == false ) {
					if ( vSelectedCntrTpSz != "" ) {
						vSelectedCntrTpSz = vSelectedCntrTpSz + "|" + sheetObj.CellValue(i, "cntr_tpsz_cd");
					} else {
						vSelectedCntrTpSz = sheetObj.CellValue(i, "cntr_tpsz_cd");
					}
				}
			}
		}
		return vSelectedCntrTpSz;
	}

    /**
	 * Per-diem/Lifting Charges/DOLDOC/Penalty Tab Container Type/Size Setting
	 * Target Sheet 의 Container Type/Size Column 형태로 있는 경우
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeCol(sourceSheetObj, targetSheetObj) {
		var vSelectedCntrTpSz = getGeneralCntrTypeSize(sourceSheetObj);
		var vShowSheetWidth   = 0;
		var vStartCntrColIdx  = 0;

		if ( vSelectedCntrTpSz != "" ) {
			with(targetSheetObj) {
				if ( FrozenCols == 0 ) {
					vStartCntrColIdx = 1;
				} else {
					vStartCntrColIdx = FrozenCols;
				}

				/* Frozen된 Column의 Width 계산(Hidden Column 제외) */
				for ( var colIdx = 0 ; colIdx < vStartCntrColIdx ; colIdx++ ) {
					if ( ColHidden(colIdx) == false ) {
						vShowSheetWidth = vShowSheetWidth + ColWidth(colIdx);
					}
				}

				Redraw = false;
				/* General Tab에 입력된 Container Type/Size Column의 Width 계산  */
				for ( var colIdx = vStartCntrColIdx ; colIdx <= LastCol ; colIdx++ ) {
					/* Header Title이 있으면서 General Grid에 있는 Container Type/Size Code와 같을 경우 Hidden false, 다를 경우 Hidden true */
					if ( CellValue(0, colIdx) != "" ) {
						if ( vSelectedCntrTpSz.match(CellValue(0, colIdx)) ) {
							if ( ColHidden(colIdx) == true ) {
								ColHidden(colIdx) = false;
							}
							vShowSheetWidth = vShowSheetWidth + ColWidth(colIdx);
						} else {
							if ( ColHidden(colIdx) == false ) {
								//for ( var i = HeaderRows ; i <= RowCount+(HeaderRows-1) ; i++ ) {
								for ( var i = HeaderRows ; i <= LastRow ; i++ ) {
									CellValue2(i, colIdx) = "";
								}
								ColHidden(colIdx) = true;
							}
						}
					}
				}

				if ( RowCount >= ViewRows ) {
					vShowSheetWidth = vShowSheetWidth + 20;
				} else {
					vShowSheetWidth = vShowSheetWidth + 10;
				}

				if ( vShowSheetWidth > mainTable.clientWidth-20 ) {
					SheetWidth = mainTable.clientWidth-20;
				} else {
					SheetWidth = vShowSheetWidth;
				}

				Redraw = true;
			}
		}

		targetSheetObj.Visible = true;
	}

    /**
	 * DPP Tab Container Type/Size Setting
	 * Target Sheet 의 Container Type/Size Row 형태로 있는 경우
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeRow(sourceSheetObj, targetSheetObj) {
		var formObj = document.form;

		/* Source Sheet Container Type/Size */
		var vGeneralCntrTpSz = getGeneralCntrTypeSize(sourceSheetObj);

		/* Target Sheet Container Type/Size */
		var vDppCntrTpSz     = getGeneralCntrTypeSize(targetSheetObj);

		with(targetSheetObj) {
			if ( RowCount > 0 ) {
				/* Target Sheet Container Type/Size 가 있을 경우 비교하여 입력 */
				if ( (vGeneralCntrTpSz != "") && (vGeneralCntrTpSz != vDppCntrTpSz) ) {
					var arrGeneralCntrTpSz = vGeneralCntrTpSz.split("|");
					/* DPP Sheet에 없을 경우 신규입력 */
					for ( var i = 0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						if ( !vDppCntrTpSz.match(arrGeneralCntrTpSz[i]) ) {
							var Row = DataInsert(-1);
							CellValue2(Row, "cntr_tpsz_cd")        = arrGeneralCntrTpSz[i];
							CellValue2(Row, "loc_cd")              = "KRSEL";
							CellValue2(Row, "cntr_rntl_chg_tp_cd") = "DPPV";
						}
					}
					var arrDppCntrTpSz = vDppCntrTpSz.split("|");
					for ( var i = 0 ; i < arrDppCntrTpSz.length ; i++ ) {
						if ( !vGeneralCntrTpSz.match(arrDppCntrTpSz[i]) ) {
							var Row = FindText("cntr_tpsz_cd", arrDppCntrTpSz[i]);
							RowHidden(Row)= true;		//1.행 숨기기
							RowStatus(Row)= "D";		//2.트랜잭션 상태 "삭제"로 만들기
						}
					}
				}
			} else {
				/* DPP Sheet에 Container Type/Size 가 없을 경우 모두 입력 */
				if ( vGeneralCntrTpSz != "" ) {
					var arrGeneralCntrTpSz = vGeneralCntrTpSz.split("|");
					for ( var i = 0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						var Row = DataInsert(-1);
						CellValue2(Row, "cntr_tpsz_cd")        = arrGeneralCntrTpSz[i];
						CellValue2(Row, "loc_cd")              = "KRSEL";
						CellValue2(Row, "cntr_rntl_chg_tp_cd") = "DPPV";
					}
				}
			}
		}
	}

	/**
	 * Pop-up Open 부분<br>
	 * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
	 * @param object 대상 Object
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 */
	function openPopupPage(type, Row, Col, SheetIdx) {
		var formObj = document.form;

		if ( type == "1" ) {
			if ( ComGetObjValue(formObj.agmt_ver_seq) != "" ) {
				ComOpenPopup('/hanjin/EES_LSE_0002.do?agmt_seq='+ComGetObjValue(formObj.agmt_seq), 850, 450, 'setPopData_AgreementVer', '1,0', true);
			} else {
				ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 430, 'setPopData_Agreement', '1,0', true);
			}
		} else if ( type == "2" ) {
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 470, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
		} else if ( type == "3") {
			ComOpenPopup('/hanjin/COM_ENS_N13.do', 500, 420, 'setPopData_Currency', '1,0', true);
		} else if ( type == "4") {
			var url = '/hanjin/EES_LSE_0096.do?agmt_cty_cd='+ComGetObjValue(formObj.agmt_cty_cd)+'&agmt_seq='+ComGetObjValue(formObj.agmt_seq);
			var returnVal = ComOpenWindowCenter(url, "", 520, 450, true);
			if( returnVal != undefined && returnVal != "" ) {
				setPopData_EffDate(returnVal);
			}
		} else if ( type == "5" ) {
			ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430, 'setPopData_DeliveryLoc', '1,0,1,1,0,0,0,0', false, false, Row, Col, SheetIdx);
		} else if ( type == "6" ) {
			with(sheetObjects[SheetIdx]) {
				var own_cntr_flg = "";
				if ( ComGetObjValue(formObj.combo1) == "OW" || ComGetObjValue(formObj.combo1) == "LP" || ComGetObjValue(formObj.combo1) == "OL" ) {
					own_cntr_flg = "Y";
				} else {
					own_cntr_flg = "N";
				}
				var cntr_tpsz_cd = CellValue(Row, "cntr_tpsz_cd");
				if ( cntr_tpsz_cd == "" ) {
					ComShowCodeMessage("LSE01015");
					sheetObjects[0].SelectCell(Row, "cntr_tpsz_cd");
					return;
				}
				ComOpenPopup('/hanjin/EES_MST_0022.do?own_cntr_flg='+own_cntr_flg+'&cntr_tpsz_cd='+cntr_tpsz_cd+'&active_flag=3', 1010, 650, 'setPopData_CntrSpecNo', '0,0', false, false, Row, Col, SheetIdx);
			}
    	}
	}

	/**
	 * Agreement Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( aryPopupData.length > 0 ) {

			if ( ComGetObjValue(formObj.usr_ofc_cd) != "SELCON" && ComGetObjValue(formObj.usr_ofc_cd) != "SELPPS") {
				if ( aryPopupData[0][6] == "OW" || aryPopupData[0][6] == "LP" || aryPopupData[0][6] == "OL"
				  || aryPopupData[0][6] == "LT" || aryPopupData[0][6] == "ST" || aryPopupData[0][6] == "OF" ) {
					ComShowCodeMessage("LSE01040");
					ComSetFocus(formObj.agmt_seq);
					return;
				}
			}

			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);

			doActionIBSheet(sheetObj, formObj, IBSEARCH);
      	}
	 }

	/**
	 * Agreement Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_AgreementVer(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( aryPopupData.length > 0 ) {

			if ( ComGetObjValue(formObj.usr_ofc_cd) != "SELCON" && ComGetObjValue(formObj.usr_ofc_cd) != "SELPPS") {
				if ( aryPopupData[0][5] == "OW" || aryPopupData[0][5] == "LP" || aryPopupData[0][5] == "OL"
				  || aryPopupData[0][5] == "LT" || aryPopupData[0][5] == "ST" || aryPopupData[0][5] == "OF" ) {
					ComShowCodeMessage("LSE01040");
					ComSetFocus(formObj.agmt_seq);
					return;
				}
			}

			ComSetObjValue(formObj.agmt_seq,     aryPopupData[0][4]);
			ComSetObjValue(formObj.agmt_ver_seq, aryPopupData[0][8]);

			doActionIBSheet(sheetObj, formObj, IBSEARCH);
      	}
	}

	/**
	 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}

	/**
	 * Currency Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.curr_cd, aryPopupData[0][1]);
		}
	}

	/**
	 * Version-Up Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_EffDate(popupData) {
		var formObj  = document.form;
		if ( popupData != "" ) {
			var arrPopupData = popupData.split("|");

			ComSetObjValue(formObj.eff_dt, arrPopupData[0]);
			ComSetObjValue(formObj.exp_dt, arrPopupData[1]);

			formActionType = MODE_VRSNUP;
			doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
		}
	}

	/**
	 * Location Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_DeliveryLoc(aryPopupData, Row, Col, sheetIdx) {
		if ( aryPopupData.length > 0 ) {
			with(sheetObjects[sheetIdx]) {
				var sName = ColSaveName(Col);
				switch(sName) {
					case "loc_cd":
						var dupRow = FindText(Col, aryPopupData[0][10]);
						if ( dupRow != -1 && Row != dupRow ) {
							CellValue2(Row,Col) = "";
						} else {
							/*
							 * 2009.10.13 SCC 로 변경  Per-diem 은 LCC.
							 * 2010.03.08 Per-Diem Location도 SCC 로 변경 : 정필성C 요청.
							 * 2010.12.17 Per-Diem Location은 LCC 로 변경 : 정필성C 요청.
							 */
														
							if ( sheetIdx != 1 ) {
								CellValue2(Row,Col)  = aryPopupData[0][9];
							} else {
								CellValue2(Row,Col)  = aryPopupData[0][11];
							}

						}
						break;
				}
			}
		}
	}

	/**
	 * Container Spec No. Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_CntrSpecNo(aryPopupData, Row, Col, sheetIdx) {
		var formObj = document.form;
		if ( aryPopupData.length > 0 ) {
			with(sheetObjects[sheetIdx]) {
				var sName = ColSaveName(Col);
				switch(sName) {
					case "cntr_spec_no":
						if ( ComTrim(ComGetObjValue(formObj.vndr_seq)) == ComTrim(aryPopupData[0][8]) ) {
							CellValue2(Row,Col) = aryPopupData[0][2];
						} else {
							ComShowCodeMessage("LSE01130");
							SelectCell(Row, Col);
						}
						break;
				}
			}
		}
	}

	/**
	 * Sheet Object 내 Location Code 변경 시 Validation 처리 부분<br>
	 * @param sheetObj
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param Value
	 * @param Type
	 */
	function setAsyncData(sheetObj, Row, Col, Value, Type) {
		 if (Type==undefined || Type==null) Type = "1";

		 with(sheetObj) {
			if ( CellValue(Row,Col) != "" ) {
				var loc_tp     = "";
				var loc_col_nm = "";

				/*
				 * 2010.12.17 Per-Diem Location 도 LCC 로 변경 : 정필성C 요청.
				 */
				if (sheetObj==sheetObjects[1]){
					loc_tp = "LCC";
					loc_col_nm = "lcc_cd";					
				}else{
					loc_tp = "SCC";
					loc_col_nm = "scc_cd";					
				}

				var param = "f_cmd="  + SEARCH05
						 + "&loc_cd=" + Value
						 + "&loc_tp=" + loc_tp;

				WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
				WaitImageVisible = true;

				if ( sXml != "" ) {
					if ( ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S" ) {
						if ( ComGetEtcData(sXml, loc_col_nm) != "" ) {
							var vLccCd = ComGetEtcData(sXml, loc_col_nm);
							CellBackColor(Row, Col) = RgbColor(0,0,0);
						} else {
							if ( type == "1" ) {
								ComShowCodeMessage("LSE01037");
								CellValue2(Row,Col) = "";
							} else {
								CellValue2(Row,Col) = "";
								CellBackColor(Row, Col) = RgbColor(255,255,0);
							}
						}
					} else {
						if ( type == "1" ) {
							ComShowCodeMessage("LSE01037");
							CellValue2(Row,Col) = "";
							SelectCell(Row,Col);
						} else {
							CellValue2(Row,Col) = "";
							CellBackColor(Row, Col) = RgbColor(255,255,0);
						}
					}
				}
			}
		}

		return;
	}

	
	/**
	 * 화면 처리 구분에 따른 Form 내 Objects 사용여부 처리 부분<br>
	 * @param type
	 * @param formObj
	 */
	function setFormEnable(type, formObj) {
		switch(type) {
			case MODE_SEARCH :
				if ( formActionType != MODE_SEARCH ) {
					formActionType = MODE_SEARCH;
					LseComEnableForm(false, formObj, "agmt_cty_cd|agmt_ver_seq|dt_drtn|vndr_nm|ofc_cd|cre_usr_id|cre_dt|dpc_rto");
					LseComMndtForm(formObj,"agmt_seq");
					if ( formObj.vndr_seq.className != "input2" ) {
						ComEnableObject(formObj.vndr_seq, false);
					}
					if ( formObj.eff_dt.className != "input2" ) {
						ComEnableObject(formObj.eff_dt, false);
					}
					if ( formObj.exp_dt.className != "input2" ) {
						ComEnableObject(formObj.exp_dt, false);
					}
				
					ComEnableManyObjects(true, formObj.btns_search1);
					LseComBtnControl(false, "btn_Save|btn_VersionUp|btn_t1RowAdd|btn_t1RowDelete|btn_t1LoadExcel|btn_t1DownExcel|btn_t2RowAdd|btn_t2RowDelete|btn_t2LoadExcel|btn_t2DownExcel|btn_t3RowAdd|btn_t3RowDelete|btn_t3LoadExcel|btn_t3DownExcelbtn_t4RowAdd|btn_t4RowDelete|btn_t4LoadExcel|btn_t4DownExcel|btn_t4RowAdd2|btn_t4RowDelete2|btn_t6LoadExcel|btn_t6DownExcel");
					LseComBtnControl(true,  "btn_Retrieve|btn_Create");
				}
				ComSetFocus(formObj.agmt_seq);
				break

			case MODE_MODIFY :
				if ( formActionType != MODE_MODIFY ) {
					formActionType = MODE_MODIFY;

					LseComEnableForm(true, formObj, "agmt_cty_cd|agmt_ver_seq|dt_drtn|vndr_nm|ofc_cd|cre_usr_id|cre_dt|lse_agmt_doc_desc|dpc_rto_val");
					LseComMndtForm(formObj,"agmt_seq|lse_ctrt_no|ref_no|curr_cd|lse_agmt_doc_desc");

					if ( ComGetObjValue(formObj.combo1) == "ST" || ComGetObjValue(formObj.combo1) == "LT" ) {
						LseComMndtForm2(true, formObj, "dpc_rto|max_dpc_rto|combo2|combo3");
					} else {
						LseComMndtForm2(false, formObj, "dpc_rto|max_dpc_rto|combo2|combo3");
					}

					ComEnableObject(formObj.vndr_seq, false);
					ComEnableObject(formObj.btns_search2, false);
					formObj.combo1.Enable = false;
				}

				ComSetFocus(formObj.agmt_seq);
				break;

			case MODE_CREATE :
				if ( formActionType != MODE_CREATE ) {
					ComResetAll();
					formActionType = MODE_CREATE;
					LseComEnableForm(true, formObj, "agmt_cty_cd|agmt_ver_seq|dt_drtn|vndr_nm|ofc_cd|cre_usr_id|cre_dt|lse_agmt_doc_desc|dpc_rto_val");

					/* Agreement No가 입력가능이면 입력불가로 변경. */
					if ( formObj.agmt_seq.className != "input2" ) {
						ComEnableManyObjects(false, formObj.agmt_seq);
					}

					ComEnableObject(formObj.btns_search1, false);
					//LseComMndtForm(formObj, "combo1|eff_dt|exp_dt|vndr_seq|lse_ctrt_no|ref_no|curr_cd|dpc_rto|max_dpc_rto");
					LseComMndtForm(formObj, "combo1|eff_dt|exp_dt|vndr_seq|lse_ctrt_no|ref_no|curr_cd|lse_agmt_doc_desc");

					/* DEPR Level Default Value Setting (Default Value : Daily, N) */
					ComSetObjValue(formObj.combo2,"D");
					ComSetObjValue(formObj.combo3,"N");

					/* DEPR 관련 옵션처리 */
					LseComMndtForm2(false, formObj, "dpc_rto|max_dpc_rto|combo2|combo3");

					/* DPP Type Default Value Setting (Default Value : DDP) */
					formObj.dpp_tp_cd[1].checked = true;

					/* DPP Tab 비활성화 */
					tabObjects[0].TabEnable(5)= false;

					/* Currency Defalut Value Setting (Defautl Value : USD) */
					ComSetObjValue(formObj.curr_cd, "USD");

					LseComBtnControl(false, "btn_Retrieve|btn_Create|btn_VersionUp");
					LseComBtnControl(true, "btn_Save|btn_t1RowAdd|btn_t1RowDelete|btn_t1LoadExcel|btn_t1DownExcel|btn_t2RowAdd|btn_t2RowDelete|btn_t2LoadExcel|btn_t2DownExcel|btn_t3RowAdd|btn_t3RowDelete|btn_t3LoadExcel|btn_t3DownExcel|btn_t4RowAdd|btn_t4RowDelete|btn_t4LoadExcel|btn_t4DownExcel|btn_t4RowAdd2|btn_t4RowDelete2|btn_t5LoadExcel|btn_t5DownExcel");

					tabObjects[0].SelectedIndex = 0;

					/* Creation Mode 시 General Tab 에 1 Row 추가 ( 2009.10.20 이유목 수석 요청) */
					doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
				}
				//ComSetFocus(formObj.vndr_seq);
				ComSetFocus(formObj.combo1);
				break;
		}

		ComEnableObject(formObj.chk_agmt_act_flg, false);
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
   function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSEARCH:
				if ( ComGetObjText(formObj.agmt_seq) == "" ) {
					ComShowCodeMessage("LSE01006");
					ComSetFocus(formObj.agmt_seq);
					return false;
				} else {
					if ( !ComChkObjValid(formObj.agmt_seq, true, false, false) ) {
						ComSetFocus(formObj.agmt_seq);
						return false;
					}
				}
				break;

			case IBSEARCH_ASYNC01:
				if( ComGetObjText(formObj.vndr_seq) == "" ) {
					ComShowCodeMessage("LSE01044");
					ComSetFocus(formObj.vndr_seq);
					return false;
				}
				break;

			case IBSAVE:
				switch (sheetObj.id) {
					case "t7sheet1" :
						if (sheetObj.LastRow == 2){
							if (sheetObj.CellText(1,"file_path_nm") == sheetObj.CellText(2,"file_path_nm")){
								ComShowCodeMessage("LSE01005", "[file name]");
								return false;
							}
						}
						if (sheetObj.LastRow == 3){
							if (sheetObj.CellText(1,"file_path_nm") == sheetObj.CellText(2,"file_path_nm") ||
								sheetObj.CellText(1,"file_path_nm") == sheetObj.CellText(3,"file_path_nm") ||
								sheetObj.CellText(2,"file_path_nm") == sheetObj.CellText(3,"file_path_nm")){
								ComShowCodeMessage("LSE01005", "[file name]");
								return false;
							}
						}
						break;
					case "t1sheet1" :
		     			/* Modify 시 Agreement No. Validataion */
		     			if ( formActionType == MODE_MODIFY ) {
		     				if( ComGetObjValue(formObj.agmt_seq) == "" ) {
		         				ComShowCodeMessage("LSE01006");
		         				ComSetFocus(formObj.agmt_seq);
		         				return false;
		         			}
		     			}

		     			/* Lease Term Validataion */
		     			if ( ComGetObjValue(formObj.combo1) == "" ) {
		     				ComShowCodeMessage("LSE01009");
		     				ComSetFocus(formObj.combo1);
		     				return false;
		     			}

		     			/* LT,ST 일 경우에만 필수체크 by 정필성C 요청(2010.03.02) */
		     			if ( ComGetObjValue(formObj.combo1) == "LT" || ComGetObjValue(formObj.combo1) == "ST" ) {
		     				/* Yearly DEPR Default Value Setting */
		     				if ( ComGetObjValue(formObj.dpc_rto) == "" ) {
			     				//ComSetObjValue(formObj.dpc_rto, "0.0");
			     				ComShowCodeMessage("LSE01145");
			     				ComSetFocus(formObj.dpc_rto);
			     				return false;
			     			} else {
			     				if ( ComChkObjValid(formObj.dpc_rto) == false ) {
			     					ComSetFocus(formObj.dpc_rto);
			     					return false;
			     				}
			     			}

		     				/* MAX DEPR Default Value Setting */
			     			if ( ComGetObjValue(formObj.max_dpc_rto) == "" ) {
			     				//ComSetObjValue(formObj.max_dpc_rto, "0.0");
			     				ComShowCodeMessage("LSE01142");
			     				ComSetFocus(formObj.max_dpc_rto);
			     				return false;
			     			} else {
			     				if ( ComChkObjValid(formObj.max_dpc_rto) == false ) {
			     					ComSetFocus(formObj.max_dpc_rto);
			     					return false;
			     				}
			     			}

			     			/* DEPR Level Valiation */
			     			if ( ComGetObjText(formObj.combo2) == "" ) {
			     				ComShowCodeMessage("LSE01144");
			     				ComSetFocus(formObj.combo2);
			     				return false;
			     			}
			     			if ( ComGetObjText(formObj.combo3) == "" ) {
			     				ComShowCodeMessage("LSE01144");
			     				ComSetFocus(formObj.combo3);
			     				return false;
			     			}
		     			}

		     			if ( !checkEffDate() ) {
		     				//ComSetFocus(formObj.exp_dt);
		     				return false;
		     			}

		     			/* Lessor No. Validation */
		     			if ( ComGetObjText(formObj.vndr_seq) == "" ) {
		     				ComShowCodeMessage("LSE01044");
		     				ComSetFocus(formObj.vndr_seq);
		     				return false;
		     			}

		     			/* URL Valiation */
		     			/*
		     			if ( ComGetObjText(formObj.lse_vndr_url) == "" ) {
		     				ComShowCodeMessage("LSE01143");
		     				ComSetFocus(formObj.lse_vndr_url);
		     				return false;
		     			}
		     			*/

		     			/* Contract No. Valiation */
		     			if ( ComGetObjText(formObj.lse_ctrt_no) == "" ) {
		     				ComShowCodeMessage("LSE01052");
		     				ComSetFocus(formObj.lse_ctrt_no);
		     				return false;
		     			}

		     			/* Reference No. Valiation */
		     			if ( ComGetObjText(formObj.ref_no) == "" ) {
		     				ComShowCodeMessage("LSE01093");
		     				ComSetFocus(formObj.ref_no);
		     				return false;
		     			}

		     			/* Pay Term Default Value Setting */
		     			if ( ComGetObjValue(formObj.lse_pay_term_dys) == "" ) {
		     				ComSetObjValue(formObj.lse_pay_term_dys, "0");
		     			}

		     			/* Currency Valiation */
		     			if ( ComGetObjText(formObj.curr_cd) == "" ) {
		     				ComShowCodeMessage("LSE01012");
		     				ComSetFocus(formObj.curr_cd);
		     				return false;
		     			}
                        
		     			
		     			if ( ComGetObjValue(formObj.combo1) == "LT" || ComGetObjValue(formObj.combo1) == "ST" || ComGetObjValue(formObj.combo1) == "LP" ) {
		     				/* lse_agmt_doc_desc Valiation */
		     				if ( ComGetObjText(formObj.lse_agmt_doc_desc) == "" ) {
		     					ComShowCodeMessage("LSE01157");
		     					ComSetFocus(formObj.lse_agmt_doc_desc);
		     					return false;
		     				}
		     			}
		     			
		     			/* DII/DIO Fee Default Value Setting */
		     			if ( ComGetObjValue(formObj.dir_itchg_fee_amt) == "" ) {
		     				ComSetObjValue(formObj.dir_itchg_fee_amt, "0");
		     			}

		     			/* Free Days Default Value Setting */
		     			if ( ComGetObjValue(formObj.lse_free_dys) == "" ) {
		     				ComSetObjValue(formObj.lse_free_dys, "0");
		     			}

		     			/* General Tab Value Check */
		     			if ( sheetObj.RowCount > 0 ) {
		     				for ( var i = sheetObj.HeaderRows ; i <= sheetObj.RowCount; i++ ) {

		     					/* Container Type-Size Value Check */
		     					if ( ComTrim(sheetObj.CellValue(i, "cntr_tpsz_cd")) ==  "" && sheetObj.RowStatus(i) != "D" ) {
		     						ComShowCodeMessage("LSE01015");
		     						sheetObj.SelectCell(i, "cntr_tpsz_cd");
		     						return false;
		     					}

		     					var agmtLstmCd = ComGetObjValue(formObj.combo1);
		     					/* Lease Term 이 "OW/LP/OL/LT/OF" 일 경우 QTY는 필수 : QTY 필수 Check 안함 by 이유목S */
		     					/*
		     					if ( agmtLstmCd == "OW" || agmtLstmCd == "LP" || agmtLstmCd == "OL"
		     					  || agmtLstmCd == "LT" || agmtLstmCd == "OF" ) {
		     						if ( ComTrim(sheetObj.CellValue(i, "qty")) ==  "" ) {
		     							ComShowCodeMessage("LSE01014");
			     						sheetObj.SelectCell(i, "qty");
			     						return false;
		     						}
		     					}
		     					*/
		     					/* Lease Term 이 "LT/ST/OF/SB" 일 경우 REPL Value 는 필수. 2009/10/22 정필성C 요청 */
		     					if ( agmtLstmCd == "LT" || agmtLstmCd == "ST"
		     					  || agmtLstmCd == "OF" || agmtLstmCd == "SB" ) {
			     					var value = ComTrim(sheetObj.CellValue(i, "repl_value"));
		     						if ( value == "" || value*100 == 0 ) {
			     						ComShowCodeMessage("LSE01126");
			     						tabObjects[0].SelectedIndex = 0;
				     					sheetObj.SelectCell(i, "repl_value");
				     					return false;
			     					}
			     				}
		     				}
		     			} else {
		     				ComShowCodeMessage("LSE01015");
		     				doActionIBSheet(sheetObj, formObj, IBINSERT);
		     				return false;
		     			}
						break;
				}
				break;
		}

		return true;
    }

	/**
	 * Effective Date 입력 시 Duration 계산 처리 부분<br>
	 */
    function setDuration() {
    	var formObj = document.form;

    	if ( !checkEffDate() ) {
       		ComSetFocus(formObj.exp_dt);
       		return;
       	}

   		var input1 = ComReplaceStr(ComGetObjValue(formObj.eff_dt), "-", "");
   		var input2 = ComReplaceStr(ComGetObjValue(formObj.exp_dt), "-", "");
   		var duration = LseComGetMonthsDateDiff(input1, input2);
		ComSetObjValue(formObj.dt_drtn, duration);
    }

	/**
	 * Effective Date Validation 처리 부분<br>
	 */
    function checkEffDate() {
    	var formObj = document.form;

		/* Effective Date Validation(eff_dt) */
		if( ComGetObjValue(formObj.eff_dt) == "" ) {
			ComShowCodeMessage("LSE01010");
			ComSetFocus(formObj.eff_dt);
			return false;
		} else if ( !ComIsDate(formObj.eff_dt) ) {
			ComShowCodeMessage("LSE01020");
			ComSetObjValue(formObj.eff_dt,"");
			ComSetFocus(formObj.eff_dt);
			return false;
		}

		/* Effective Date Validation(exp_dt) */
		if( ComGetObjValue(formObj.exp_dt) == "" ) {
			ComShowCodeMessage("LSE01011");
			ComSetFocus(formObj.exp_dt);
			return false;
		} else if ( !ComIsDate(formObj.exp_dt) ) {
			ComShowCodeMessage("LSE01026");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}

		/* Effective Date Validation(eff_dt < exp_dt) */
		var vEffDt = ComReplaceStr(ComGetObjValue(formObj.eff_dt),"-","");
		var vExpDt = ComReplaceStr(ComGetObjValue(formObj.exp_dt),"-","");
		if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
			ComShowCodeMessage("LSE01051");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}
		return true;
    }

	/**
	 * Sheet Column 내 데이터 Duplication 처리 부분<br>
	 */
	function checkDuplicateCol(sheetObj, Row, colName, Value) {
		var formObj = document.form;

		if ( Value != "" ) {
			var dupRow = sheetObj.FindText(colName, Value);

			if ( dupRow != -1 && Row != dupRow && sheetObj.RowStatus(dupRow) != "D" ) {
				if ( sheetObj.id == "t1sheet1" ) {
					ComShowCodeMessage("LSE01008");
					sheetObj.CellValue2(Row, colName) = " ";
				} else if ( sheetObj.id == "t6sheet1" ) {
					/* Container Type/Size Duplication 시 기존 Row 에 Value 설정하고 Upload 된 Row 는 삭제 */
					sheetObj.CellValue2(dupRow,"agmt_chg_dys") = sheetObj.CellValue(Row, "agmt_chg_dys");
					sheetObj.CellValue2(dupRow,"n1st_chg_amt") = sheetObj.CellValue(Row, "n1st_chg_amt");
					sheetObj.CellValue2(dupRow,"agmt_chg_val") = sheetObj.CellValue(Row, "agmt_chg_val");
					sheetObj.CellValue2(dupRow,"n2nd_chg_amt") = sheetObj.CellValue(Row, "n2nd_chg_amt");
					sheetObj.RowDelete(Row, false);
				} else if ( sheetObj.id == "t2sheet1" ) {
					if ( ComGetObjValue(formObj.combo1) == "LT" ) {
						ComShowCodeMessage("LSE01059");
					} else {
						ComShowCodeMessage("LSE01060");
					}
					sheetObj.CellValue2(Row, colName) = "";
				} else {
					ComShowCodeMessage("LSE01059");
					sheetObj.CellValue2(Row, colName) = "";
				}
			}
		} else {
			if ( sheetObj.id == "t1sheet1" ) {
				sheetObj.CellValue2(Row, colName) = " ";
			} else {
				sheetObj.CellValue2(Row, colName) = "";
			}
		}
	}


	/**
	 * Container Spec No. Cell Control
	 * - Lease Term 이 'LT' 일 경우에만 Genearl Data 의 Spec No. 입력 가능.
	 * - 2009.09.16 by 이유목 수석 요청
	 */
	function control_Spec_No(code) {
		var sheetObj = sheetObjects[0];
		if ( code == "LT" ) {
			sheetObj.ColHidden("cntr_spec_no") = false;
		} else {
			sheetObj.ColHidden("cntr_spec_no") = true;
		}
	}

	/**
	 * Per-diem Location/No. of TEU Cell Control
	 * - Lease Term 이 'LT' 일 경우에만 Per-diem Data 의 Location 입력 가능. 그 외 No. of TEU 입력 가능.
	 */
	function control_Loc(code) {
		var formObj = document.form;
		if ( ComGetObjValue(formObj.combo1) == "LT" ) {
			sheetObjects[1].ColHidden("agmt_chg_val") = true;
			sheetObjects[1].ColHidden("loc_cd")       = false;
		} else {
			sheetObjects[1].ColHidden("agmt_chg_val") = false;
			sheetObjects[1].ColHidden("loc_cd")       = true;
		}
	}
	
	function openGwContract(){
		var formObject = document.form;
		var csrGwUrl = document.form.csr_gw_url.value;

		var iframeObj = document.getElementsByTagName("IFRAME");
		//alert(iframeObj.length);
		for (var i = 0; i < iframeObj.length; i++) {
			if(iframeObj[i].id == "gwrequest")
			    iframeObj[i].parentNode.removeChild(iframeObj[i]);
		}

		
		ifrm = document.createElement("IFRAME");
		ifrm.setAttribute("id", "gwrequest");
		ifrm.style.width = 0+"px";
		ifrm.style.height = 0+"px";
		 
		if(formObject.lse_agmt_doc_desc.value == null || formObject.lse_agmt_doc_desc.value == ""){

			var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACT&parameter=ALPS|LSE");// + param;
			ifrm.setAttribute("src", url);
			document.body.appendChild(ifrm);
		}else {
			var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACTVIEW&parameter="+formObject.lse_agmt_doc_no.value);
			ifrm.setAttribute("src", url);
			document.body.appendChild(ifrm);
	
		}

	}

	
	function openPop() {
		document.frames["ifr"].location.href = "proxy.html";
	}

	function receiveMessage(event) {
		//document.all.txtResult.value = event.data;
		returnGwLink(event.data)
	}

	if(window.addEventListener) {
		window.addEventListener("message", receiveMessage, false);
	}

	if(window.attachEvent) {
		window.attachEvent("onmessage", receiveMessage);
	}

	if(document.attachEvent) {
		document.attachEvent("onmessage", receiveMessage);
		
	}
	
	function returnGwLink(msg){
		msg = msg.split(",");
		/* IBTab 초기화 */

		 var formObj = document.form;
		 var gw_no = msg[0];
		 var gw_desc = msg[1];
		 
		 ComSetObjValue(formObj.lse_agmt_doc_no, gw_no);
		 ComSetObjValue(formObj.lse_agmt_doc_desc, gw_desc);

	}
		
	function gw_del(){
		 var formObj = document.form;
		 ComSetObjValue(formObj.lse_agmt_doc_no, "");
		 ComSetObjValue(formObj.lse_agmt_doc_desc, "");
	}
	/* 개발자 작업  끝 */
