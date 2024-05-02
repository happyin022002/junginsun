/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0019.js
 *@FileTitle : Receivable Charge & Invoice Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.26
 *@LastModifier : 장준우
 *@LastVersion : 1.0
 * 2009.08.26 장준우
 * 1.0 Creation
 * ======================================================
 * 2010.09.15 남궁진호 [CHM-201005908-01] errMsg코드변경에 따른 에러코드 수정
 *            LSE01053,LSE01054,LSE01055 ->LSE01153,LSE01154,LSE01155
 * 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
 * 2011.05.16 나상보 [CHM-201110759-01] Split 02-BKG 이외 모듈에서 INVOICE 로 I/F 하는 로직에 ERP 호출 분리
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
	 * @class EES_LSE_0019 : EES_LSE_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0019() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject 	= setSheetObject;
		this.loadPage 			= loadPage;
		this.sheet1_OnLoadFinish = sheet1_OnLoadFinish;
		this.initControl 		= initControl;
		this.obj_blur 			= obj_blur;
		this.obj_focus 			= obj_focus;
		this.obj_change 		= obj_change;
		this.obj_keypress 		= obj_keypress;
		this.obj_keyup 			= obj_keyup;
		this.obj_keydown 		= obj_keydown;
		this.initSheet 			= initSheet;
		this.doActionIBSheet 	= doActionIBSheet;
		this.sheet1_OnChange 	= sheet1_OnChange;
		this.sheet1_OnMouseMove = sheet1_OnMouseMove;
		this.sheet1_OnPopupClick = sheet1_OnPopupClick;
		this.sheet1_OnDblClick 	= sheet1_OnDblClick;
		this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
		this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
		this.sheet1_OnSaveEnd 	= sheet1_OnSaveEnd;
		this.sheet2_OnSaveEnd 	= sheet2_OnSaveEnd;
		this.openPopup 			= openPopup;
		this.setPopData_Lessor 	= setPopData_Lessor;
		this.setPopData_Currency = setPopData_Currency;
		this.setPopData_Agreement = setPopData_Agreement;
		this.setPopData_Customer = setPopData_Customer;
		this.checkXchRateAvail = checkXchRateAvail;
		this.setDynamicCurrcyList = setDynamicCurrcyList;
		this.callbackSetQtyYrmon = callbackSetQtyYrmon;
		this.callbackSetInvIsuDt = callbackSetInvIsuDt;
		this.validateForm 		= validateForm;
		this.clearForm 			= clearForm;
	}


	/* 개발자 작업	*/


	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcObj  = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;

 				case "btn_RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObject1, formObj, IBINSERT);
 					}
                	break;

				case "btn_Delete":
					if ( ComIsBtnEnable(srcName) ) {
						with(sheetObject1) {
							for(var i = LastRow; i >= HeaderRows; i--) {
								if(CellValue(i, "sheet1_del_chk") == 1) {
									var vDelFlag = RowStatus(i)== "I";
		 							CellValue2(i, "sheet1_del_chk")= 0;
									RowHidden(i)= vDelFlag;
									RowStatus(i)= vDelFlag ? "D" : RowStatus(i);
								}
							}
						}
 					}
                    break;

				case "btn_new":
					ComResetAll();
					setDynamicCurrcyList(true);
					ComEnableObject(formObj.to_curr_rt, false);
					ComEnableObject(formObj.to_curr_cd, false);
					//ComEnableObject(formObj.btns_search2,false);
					formObj.to_curr_rt.className  = "input2";
					formObj.to_curr_cd.className  = "input2";

					ComEnableObject(formObj.cust_cnt_cd, false);
					ComEnableObject(formObj.cust_seq, false);
					ComEnableObject(formObj.btns_cust1,false);
					ComEnableObject(formObj.btns_cust2,false);
					formObj.cust_cnt_cd.className  = "input2";
					formObj.cust_seq.className  = "input2";

					formObj.locl_tax_flg.disabled = true;

					ComEnableObject(formObj.inv_isu_dt, false);
					ComEnableObject(formObj.inv_due_dt, false);
					ComEnableObject(formObj.btns_calendar2,false);
					ComEnableObject(formObj.btns_calendar3,false);
					formObj.inv_isu_dt.className  = "input2";
					formObj.inv_due_dt.className  = "input2";

					// 조회 전 데이터 가공 방지를 위한 버튼 콘트롤
					sheet1_OnLoadFinish(sheetObject1);
					break;

				case "btns_calendar1":
 					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.setEndFunction('callbackSetQtyYrmon');
					cal.select(formObj.qty_yrmon, 'yyyy-MM');
             	 	break;

             	case "btns_calendar2":
 					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendar();
						cal.setEndFunction('callbackSetInvIsuDt');
		                cal.select(formObj.inv_isu_dt, "yyyy-MM-dd");
					}
					break;

             	case "btns_calendar3":
 					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendar();
		                cal.select(formObj.inv_due_dt, "yyyy-MM-dd");
					}
					break;

             	case "btns_search1": 	// Form Lessor Search
					openPopup("1");
					break;
				/*
				case "btns_search2":	// Form Currency Code 조회 팝업
					if(formObj.btns_search2.style.cursor == "hand") {
 						openPopup("2");
					}
 					break;
				*/
				case "btn_preparation":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
					break;

				case "btn_charge":
					//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
					break;

				case "btn_recharge":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
					break;

				case "btn_invoice":
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC06);
					break;

				case "btn_confirm":
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC13);
					break;

				case "btn_print":
					var rdPath  = "";

					var rdParam = "/rv VNDR_SEQ["+ ComGetObjValue(formObj.inv_vndr_seq) +"]"
								+ " USR_ID['"+ ComGetObjValue(formObj.usr_id) +"']"
								+ " QTY_YRMON['"+ ComGetUnMaskedValue(ComGetObjValue(formObj.qty_yrmon), "ym") +"']"
							    + " COST_YRMON['"+ ComGetObjValue(formObj.cost_yrmon) +"']"
							    + " INV_NO['"+ ComGetObjValue(formObj.inv_no) +"']"
							    + " INV_ISU_DT['"+ ComGetUnMaskedValue(ComGetObjValue(formObj.inv_isu_dt), "ymd") +"']"
							    + " INV_DUE_DT['"+ ComGetUnMaskedValue(ComGetObjValue(formObj.inv_due_dt), "ymd") +"']"
							    + " LSTM_CD['"+ sheetObjects[1].CellValue(1, "sheet2_lstm_cd") +"']";
					
					if(formObj.ofc_cd.value == "HAMRUO") {// 구주포멧(EUR)
						rdPath  = 'apps/alps/ees/lse/containerrentalcost/receivablerentalcost/report/EES_LSE_0019_01.mrd';	
					} else if(formObj.ofc_cd.value == "SINRS" || formObj.ofc_cd.value == "SINRSO") {// 서남아 지역 본부 일 경우
						rdPath  = 'apps/alps/ees/lse/containerrentalcost/receivablerentalcost/report/EES_LSE_0019.mrd';
						
						var ofcaddr = "SM Line Corporation \n" // Lessor office address
									+ "GST REG NO M90361370G \n"
									+ "460 Alexandra Road #07-02 PSA Building \n"
									+ "Singapore 119963 ";
									
						var bankinfo = "               Beneficiary : SM Line Corporation \n" // Lessor Bank Information
									 + "               Account no : USD 0170030636 \n"
									 + "               At bank : STANDARD CHARTERED BANK, \n"
									 + "                                BATTERY ROAD BRANCH, \n"
									 + "               Bank address : 6 Battery Road, #07-00, Singapore 049909 \n"
									 + "               SWIFT CODE: SCBLSGSGXXX ";
								 
						rdParam = rdParam  		    
							    + " OFC_ADDR['"+ ofcaddr +"']"
								+ " BANK_INFO['"+ bankinfo +"']";  
					} else{// 나머지 지역
						rdPath  = 'apps/alps/ees/lse/containerrentalcost/receivablerentalcost/report/EES_LSE_0019.mrd';

						var ofcaddr = "SM Line Corporation \n" // Lessor office address
									+ "25-11, Yoido-Dong, Youngdeungpo-Ku \n"
									+ "Seoul Korea ";
						
						var bankinfo = "               Bank Account to Deposit : 061-JCD-100181 \n" // Lessor Bank Information
									 + "               Swift Code : KOEXKRSE \n"
									 + "               Bank Name : Korea Exchange Bank YOIDO Branch Office \n"
									 + "                                      In favor of SM Line Corporation ";
						
						rdParam = rdParam  		    
							    + " OFC_ADDR['"+ ofcaddr +"']"
								+ " BANK_INFO['"+ bankinfo +"']";
					}

					var vFeatures = "status=no, resizable=no, scrollbars=no, width=" + 700
							  	  + ", height=" + 700 + ", left=" + (screen.width -700) / 2
							  	  + ", top=" + (screen.height -700) / 2;

					formObj.com_mrdPath.value = rdPath;
					formObj.com_mrdArguments.value = rdParam;
					formObj.com_mrdTitle.value = "Receivable Invoice Report";
					formObj.com_mrdBodyTitle.value = "Receivable Invoice Report";
					ComOpenRDPopup(vFeatures);
					break;

				case "btn_cntr":
					openPopup("3");
					break;

				case "btn_downexcel":
					sheetObject2.Down2Excel();
					break;

				case "btns_cust1": //CUST 조회버튼
					if(formObj.btns_cust1.style.cursor == "hand") {
						openPopup("5");
					}
					break;

				case "btns_cust2": //CUST 조회버튼
					if(formObj.btns_cust2.style.cursor == "hand") {
						openPopup("6");
					}
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
    	var formObj = document.form;

        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
            if(i!=2) {
            	ComEndConfigSheet(sheetObjects[i]);
            }
        }
    }

	/**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* Axon Control Setting*/
		initControl();

		// 조회 전 데이터 가공 방지를 위한 버튼 콘트롤
		LseComBtnControl(false, "btn_preparation|btn_charge|btn_recharge|btn_invoice|btn_confirm|btn_print|btn_cntr|btn_RowAdd|btn_Delete");

		/* Preparation 가용여부 조회 */
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);

		/* Invoice Number 조회 */
    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);

		/* 초기 Focus Setting */
		setDynamicCurrcyList(true);
		//ComSetFocus(formObj.qty_yrmon);
		//ComEnableObject(formObj.btns_search2,false);
		ComEnableObject(formObj.to_curr_cd, false);
		ComEnableObject(formObj.btns_cust1,false);
		ComEnableObject(formObj.btns_cust2,false);
		ComEnableObject(formObj.btns_calendar2,false);
		ComEnableObject(formObj.btns_calendar3,false);
		formObj.locl_tax_flg.disabled = true;
    }

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerForm('focus',			'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',		'obj_change',	formObj); //- 변경될때.
  	}

	//이벤트 중복방지 변수
	var preEventType = null;
  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;

		if(preEventType == event.type) {
			preEventType = null;
			return;
		}

	    switch(obj.name){
	    	case "qty_yrmon" :
	    		//Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj);
	            break;
	        case "vndr_seq" :
	    		/* 숫자이면서 천단위 구분을 하지 않는다. */
	            ComChkObjValid(obj, true, false, false);
	            break;
	        case "cust_seq" :
	    		/* 숫자이면서 천단위 구분을 하지 않는다. */
	            ComChkObjValid(obj, true, false, false);
	            break;
	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
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
			//ComSetNextFocus(obj);
		} else {
		    //마스크구분자 없애기
		    ComClearSeparator(event.srcElement);
		}
	}

	/**
	 * OnChange Event 처리
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;

		switch(obj.name) {
			case "qty_yrmon" :
				if ( ComTrim(obj.value) != "" ) {
					var vQtyYrmon = obj.value;
					ComResetAll();
					ComSetObjValue(formObj.qty_yrmon, vQtyYrmon);
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;

			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  				}
  				break;

  			case "inv_isu_dt":	//Invoice Issue Date
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC11);
	        		if(ComIsDate(formObj.inv_isu_dt.value)) {
	        			var addDays = formObj.ofc_cd.value == "HAMRUO" ? 30 : 14;
	        			ComSetObjValue(formObj.inv_due_dt, 	ComGetDateAdd(obj.value, "D", addDays));
	        		}
  				}
				break;

			case "to_curr_rt":	//Exchange Rate
				if ( ComTrim(obj.value) != "" ) {
					//경리환율 변경 범위 체크
					if (checkXchRateAvail() == true) {
						formObj.locl_tax_flg.disabled = formObj.to_curr_cd.value == "KRW" ? false: true;
						formObj.locl_tax_flg.value    = formObj.to_curr_cd.value == "KRW" ? "Y" : "N";

						var vChgAmt = Number(ComGetUnMaskedValue(formObj.fm_chg_amt.value, "float")) *
									  Number(ComGetUnMaskedValue(formObj.to_curr_rt.value, "float"));
						var vTaxAmt = formObj.locl_tax_flg.value == "N" ? 0 : (vChgAmt / 10);
						var vTtlAmt = vChgAmt + vTaxAmt;

						if(formObj.to_curr_cd.value == "KRW") {
							ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(),  "float"));
							ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(),  "float"));
							ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(),  "float"));
						} else {
							ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(2), "float"));
							ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
							ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
						}
						ComSetObjValue(formObj.ttl_curr_cd,	formObj.to_curr_cd.value);
					} else {
						ComShowCodeMessage("LSE01153");
						ComSetFocus(formObj.to_curr_rt);
					}
				}
				break;
  			case "to_curr_cd":	//Currency Code
				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
					ComSetFocus(formObj.to_curr_rt);
				} else {
					clearForm(obj.name);
				}
				break;

			case "cust_cnt_cd":	//Customer Code
			case "cust_seq":	//Customer Name
				if ( ComTrim(formObj.cust_seq.value) != "" ) {
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC12);
				}
				break;

			case "locl_tax_flg":	//Customer Code
				if ( ComTrim(formObj.to_chg_amt.value) != "" ) {
					var vChgAmt = Number(ComGetUnMaskedValue(formObj.to_chg_amt.value, "float"));
					var vTaxAmt = formObj.locl_tax_flg.value == "N" ? 0 : (vChgAmt / 10);
					var vTtlAmt = vChgAmt + vTaxAmt;

					if(formObj.to_curr_cd.value == "KRW") {
						ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(), "float"));
						ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(), "float"));
					} else {
						ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
						ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
					}
					ComSetObjValue(formObj.ttl_curr_cd,	formObj.to_curr_cd.value);
				}
				break;
		}
	}

	/**
	 * Key-Press Event 처리
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
	            ComKeyOnlyAlphabet();
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
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj = event.srcElement;

  		switch(obj.name) {
  			case "vndr_seq":
				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
			case "cust_cnt_cd":
				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
  			case "cust_seq":
				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

			case "to_curr_rt":
  			case "to_curr_cd":
  			case "inv_isu_dt":
				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

  			default :
			  	ComKeyEnter('LengthNextFocus');
  		}
  	}

   	/**
	 * Key-Down Event 처리
	 */
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
   			switch(obj.name) {
				case "vndr_seq":
	  				if ( ComTrim(obj.value) == "" ) {
						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					}
					break;

				case "to_curr_rt":	//Currency Rate
				case "to_curr_cd":	//Currency Code
				case "cust_seq"	 :	//Customer Code
				case "inv_isu_dt":	//Invoice Issue Date
				case "inv_due_dt":	//Invoice Due Date
					break;			//do nothing

				default :
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
   		}
   	}
  	// 2. 이벤트처리함수 -- End

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetId = sheetObj.id;

        switch(sheetId) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
					var prefix = sheetId +"_";
                    // 높이 설정
                    style.height = 242;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|||SEQ|STS|STS|Lessee|Lessee|AGMT No|AGMT No||Term|Effective date|Effective date|Currency|Charge Amount|Credit Amount|Invoice No|Invoice No|Invoice No|Invoice No||||||||||||||||||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,	prefix +"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	prefix +"del_chk");
					InitDataProperty(0, cnt++ , dtRadioCheck,	40,		daCenter,	true,	prefix +"rdo_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	prefix +"seq_no");

					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix +"lse_cntr_chg_rst_cd",  false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix +"lse_cntr_chg_sts_cd",  false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix +"vndr_seq", 			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,	prefix +"vndr_abbr_nm", 		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix +"agmt_cty_cd",  	 	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtPopupEdit,	60,		daCenter,	true,	prefix +"agmt_seq",   			false,	"",	dfNone,		0,	false,	true);
                    InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,	prefix +"agmt_no",   			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix +"lstm_cd",   			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,	prefix +"eff_dt", 				false,	"",	dfDateYmd,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,	prefix +"exp_dt", 				false,	"",	dfDateYmd,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	prefix +"curr_cd",				false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,	prefix +"ttl_chg_amt",   		false,	"",	dfNullFloat,2,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,	prefix +"cr_amt",   			false,	"",	dfNullFloat,2,	false,	false);

					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	prefix +"inv_chk",  			false,	"",	dfNone,		0,	true,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	prefix +"inv_no",  				false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	prefix +"inv_cre_dt",  			false,	"",	dfDateYmd,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	prefix +"inv_cre_usr_id",  		false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix +"cost_yrmon",   		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix +"qty_yrmon",   			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix +"rcv_rntl_seq",   		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix +"ref_no",   			false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix +"inv_isu_dt",  			false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix +"inv_due_dt",  			false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	prefix +"inv_if_flg",   		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	false,	prefix +"if_err_rsn",   		false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	prefix +"cust_cnt_cd",   		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	prefix +"cust_seq",   			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	prefix +"cust_eng_nm",   		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	false,	prefix +"locl_xch_rt",   		false,	"",	dfNullFloat,3,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	prefix +"locl_curr_cd",			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	prefix +"locl_tax_flg",			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	false,	prefix +"locl_tax_amt",   		false,	"",	dfNullFloat,2,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	false,	prefix +"locl_chg_amt", 		false,	"",	dfNullFloat,2,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	false,	prefix +"locl_ttl_chg_amt", 	false,	"",	dfNullFloat,2,	false,	false);

                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	prefix +"cfm_flg",   			false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	prefix +"inv_cre_ofc_cd",		false,	"",	dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	prefix +"cfm_ofc_cd",  			false,	"",	dfNone,		0,	false,	false);

					SelectBackColor = LSE_SELECT_BACK_COLOR;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					ColHidden(prefix +"rdo_chk") = true;
               }
                break;


            case "sheet2":    //sheet2 init
                with (sheetObj) {
					var prefix = sheetId +"_";

                    // 높이 설정
                    style.height = 165;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|AGMT No||||Term|TP/SZ|Charge Type|Invoice Amount|Used Days|Qty|Rate|";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,	prefix +"ibflag");
                    InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,	prefix +"agmt_no", 			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	prefix +"agmt_cty_cd", 		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix +"agmt_seq", 		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	prefix +"rcv_rntl_seq",		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,	prefix +"lstm_cd", 			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,	prefix +"cntr_tpsz_cd", 	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	prefix +"lse_rcv_chg_tp_cd",false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			120,	daRight,	false,	prefix +"cost_amt",			false,	"",	dfNullFloat, 2);
                    InitDataProperty(0, cnt++ , dtData,			120,	daRight,	false,	prefix +"bil_dys",   		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			120,	daRight,	false,	prefix +"cntr_cnt",  		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			120,	daRight,	false,	prefix +"chg_rt_amt",		false,	"",	dfNullFloat, 2);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	prefix +"cost_yrmon",   	false,	"",	dfNone);
                	CountPosition = 0;
               }
                break;

               case "sheet3":    //sheet3 init
                with (sheetObj) {
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
               }
                break;
        }
    }

  	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.DoSearch4Post("EES_LSE_0019GS.do",FormQueryString(formObj)+ "&IBPREFIX=sheet1_");
					}
				}
				break;

			case IBINSERT:		// 입력
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						var prefix = sheetObj.id +"_";
						var Row = sheetObj.DataInsert(-1);

						sheetObj.CellValue2(Row, prefix +"del_chk") = 1;
						sheetObj.CellValue2(Row, prefix +"lse_cntr_chg_sts_cd") = "N";
						sheetObj.CellValue2(Row, prefix +"qty_yrmon") = ComGetUnMaskedValue(ComGetObjValue(formObj.qty_yrmon), "ym");
						sheetObj.SelectCell(Row, prefix +"agmt_seq");
					}
				}
				break;

			case IBSEARCH_ASYNC01:	//Preparation 가용여부 확인
				if(validateForm(sheetObj, formObj, sAction)) {
					sheetObj.WaitImageVisible = false;
					var param = "f_cmd="+SEARCH01+"&qty_yrmon="+ComGetObjValue(formObj.qty_yrmon);
					var sXml = sheetObj.GetSearchXml("EES_LSE_0019GS.do",param);
					sheetObj.WaitImageVisible = true;

					if(sXml != "") {
						if ( ComGetEtcData(sXml, "exec_flag") != undefined ) {
							var vExecFlag = ComGetEtcData(sXml, "exec_flag");
							// 조회 후 데이터 가공을 위한 버튼 콘트롤
							LseComBtnControl(vExecFlag == "FALSE", "btn_preparation");
							LseComBtnControl(vExecFlag != "FALSE", "btn_RowAdd|btn_Delete");
						}
					}
				}
				break;

			case IBSEARCH_ASYNC02:	//조회(Form Lessor No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
							ComSetFocus(formObj.vndr_nm);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("vndr_seq");
 						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						clearForm("vndr_seq");;
					}
				}
				break;

			case IBSEARCH_ASYNC03:	//저장 - Preparation 선택시
				if ( validateForm(sheetObj, formObj, sAction) ) {
					ComOpenWait(true, "mainTable");

					var param = "f_cmd="+COMMAND01+"&qty_yrmon="+ComGetObjValue(formObj.qty_yrmon);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSaveXml("EES_LSE_0019GS.do", param);
					sheetObj.WaitImageVisible = true;
 					ComOpenWait(false, "mainTable");

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "TRANS_RESULT_KEY") != undefined ) {
							var errMsg = LseComGetErrMsg(sXml);
							var vResultKey = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
							// 조회 후 데이터 가공을 위한 버튼 콘트롤
							LseComBtnControl(vResultKey == "F", "btn_preparation");
							LseComBtnControl(vResultKey != "F", "btn_RowAdd|btn_Delete");

							if ( errMsg != "" && errMsg != undefined) {
								ComShowMessage(errMsg);
							}

							if(vResultKey == "S") {//성공시 내역조회
								doActionIBSheet(sheetObj, formObj, IBSEARCH);
							}
						}
					}
				}
				break;

			case IBSEARCH_ASYNC04:	//저장 - Charge Creation 선택시
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						ComOpenWait(true, "mainTable");
						formObj.f_cmd.value = MULTI01;
						var sXml = "";

						for(var i = 0; i <= sheetObj.RowCount; i++) {
							if(sheetObj.CellValue(i, "sheet1_del_chk")) {
								sheetObj.CellValue(i, "sheet1_rdo_chk") = 1;
								var sParam = sheetObj.GetSaveString(false, true, "sheet1_rdo_chk")
										   + "&IBPREFIX=sheet1_&"+ FormQueryString(formObj);
								sheetObj.WaitImageVisible = false;
								sXml = sheetObj.GetSaveXml("EES_LSE_0019GS.do", sParam);
								sheetObj.WaitImageVisible = true;

								if(/ERROR/.test(sXml)) {
									sheetObj.CellValue2(i, "sheet1_lse_cntr_chg_rst_cd") = "Fail";
									sheetObj.CellFontColor(i, "sheet1_lse_cntr_chg_rst_cd") = sheetObj.RgbColor(255, 0, 0);
								} else {
									sheetObj.CellValue2(i, "sheet1_del_chk") = 0;
									sheetObj.CellValue2(i, "sheet1_lse_cntr_chg_rst_cd") = "OK";
									sheetObj.CellFontColor(i, "sheet1_lse_cntr_chg_rst_cd") = sheetObj.RgbColor(0, 0, 255);
									doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC07);
								}
								sheetObj.SelectCell(i, "sheet1_del_chk");
							}
						}

						ComOpenWait(false, "mainTable");
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" && errMsg != undefined) {
							ComShowMessage(errMsg);
						} else {
							ComShowCodeMessage("LSE10001");
						}
					}
				}
				break;

			case IBSEARCH_ASYNC05:	//저장 - RE Creation 선택시
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						ComOpenWait(true, "mainTable");
						formObj.f_cmd.value = MULTI02;
						var sXml = "";

						for(var i = 0; i <= sheetObj.RowCount; i++) {
							if(sheetObj.CellValue(i, "sheet1_del_chk")) {
								sheetObj.CellValue(i, "sheet1_rdo_chk") = 1;
								var sParam = sheetObj.GetSaveString(false, true, "sheet1_rdo_chk")
										   + "&IBPREFIX=sheet1_&"+ FormQueryString(formObj);
								sheetObj.WaitImageVisible = false;
								sXml = sheetObj.GetSaveXml("EES_LSE_0019GS.do", sParam);
								sheetObj.WaitImageVisible = true;

								if(/ERROR/.test(sXml)) {
									sheetObj.CellValue2(i, "sheet1_lse_cntr_chg_rst_cd") = "Fail";
									sheetObj.CellFontColor(i, "sheet1_lse_cntr_chg_rst_cd") = sheetObj.RgbColor(255, 0, 0);
								} else {
									sheetObj.CellValue2(i, "sheet1_del_chk") = 0;
									sheetObj.CellValue2(i, "sheet1_lse_cntr_chg_rst_cd") = "OK";
									sheetObj.CellFontColor(i, "sheet1_lse_cntr_chg_rst_cd") = sheetObj.RgbColor(0, 0, 255);
									doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC07);
								}
								sheetObj.SelectCell(i, "sheet1_del_chk");
							}
						}

						ComOpenWait(false, "mainTable");
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" && errMsg != undefined) {
							ComShowMessage(errMsg);
						} else {
							ComShowCodeMessage("LSE10001");
						}
					}
				}
				break;

			case IBSEARCH_ASYNC06:	//저장 - Invoice Creation 선택시
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet2") {
						formObj.f_cmd.value = MULTI03;
						sheetObj.DoSave("EES_LSE_0019GS.do", FormQueryString(formObj)+ "&IBPREFIX=sheet2_", -1, false);
					}
				}
				break;

			case IBSEARCH_ASYNC07:	//Callback 처리결과 확인
				if(validateForm(sheetObj, formObj, sAction)) {
					sheetObj.WaitImageVisible = false;
					var param = "f_cmd="+SEARCH02+ "&IBPREFIX=sheet1_&"+ sheetObj.GetSaveString(false, true, "sheet1_rdo_chk");
					var sXml = sheetObj.GetSearchXml("EES_LSE_0019GS.do", param.replace(/sheet1_/g, ""));
					sheetObj.WaitImageVisible = true;

					if(sXml != "") {
						var index = sheetObj.FindCheckedRow("sheet1_rdo_chk").split("|");
						sheetObj.CellValue2(index[0], "sheet1_inv_chk") = 0;
						sheetObj.CellValue2(index[0], "sheet1_lse_cntr_chg_sts_cd") = ComGetEtcData(sXml, "lse_cntr_chg_sts_cd");
						sheetObj.CellValue2(index[0], "sheet1_ttl_chg_amt") = ComGetEtcData(sXml, "ttl_chg_amt");
						sheetObj.CellValue2(index[0], "sheet1_cr_amt") = ComGetEtcData(sXml, "cr_amt");
						sheetObj.CellValue2(index[0], "sheet1_curr_cd") = ComGetEtcData(sXml, "curr_cd");
						sheetObj.CellValue2(index[0], "sheet1_rcv_rntl_seq") = ComGetEtcData(sXml, "rcv_rntl_seq");

						var vChgStsCd = sheetObj.CellValue(index[0], "sheet1_lse_cntr_chg_sts_cd");
			    		sheetObj.CellEditable(index[0], "sheet1_del_chk") = vChgStsCd != "I";
			    		sheetObj.CellEditable(index[0], "sheet1_inv_chk") = vChgStsCd == "C";
			    		sheetObj.CellEditable(index[0], "sheet1_agmt_seq") = false;
					}
				}
				break;

			case IBSEARCH_ASYNC08: 	//Invoice No Setting
				if(validateForm(sheetObj, formObj, sAction)) {
					sheetObj.WaitImageVisible = false;
					var param = "f_cmd="+SEARCH03+"&qty_yrmon="+ComGetObjValue(formObj.qty_yrmon);
					var sXml = sheetObj.GetSearchXml("EES_LSE_0019GS.do",param);
					sheetObj.WaitImageVisible = true;

					if(sXml != "") {
						if ( ComGetEtcData(sXml, "invoice_no") != undefined ) {
							if ( ComGetEtcData(sXml, "invoice_no") != "" ) {
								var vInvoiceNo = ComGetEtcData(sXml, "invoice_no");
								ComSetObjValue(formObj.invoice_no,  vInvoiceNo);

							} else {
								ComShowCodeMessage("LSE01048");
								formObj.invoice_no.value = "";
							}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" && errMsg != undefined) {
								ComShowMessage(errMsg);
							}
							formObj.invoice_no.value = "";
						}
					}
				}
				break;

			case IBSEARCH_ASYNC09:	//조회 - Invoice Summary
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet2") {
						var param = "f_cmd="+SEARCH04+"&cost_yrmon="+ComGetObjValue(formObj.cost_yrmon)
					  			  + "&rcv_rntl_seq="+ ComGetObjValue(formObj.rcv_rntl_seq)+ "&IBPREFIX=sheet2_";
						sheetObj.DoSearch4Post("EES_LSE_0019GS.do", param);

						ComEnableObject(formObj.cust_cnt_cd, true);
						ComEnableObject(formObj.cust_seq, true);
						ComEnableObject(formObj.inv_isu_dt, true);
						ComEnableObject(formObj.inv_due_dt, true);
						ComEnableObject(formObj.btns_cust1,true);
						ComEnableObject(formObj.btns_cust2,true);
						ComEnableObject(formObj.btns_calendar2,true);
						ComEnableObject(formObj.btns_calendar3,true);

						formObj.cust_cnt_cd.className  = "input1";
						formObj.cust_seq.className  = "input1";
						formObj.inv_isu_dt.className = "input1";
						formObj.inv_due_dt.className = "input1";
						//formObj.locl_tax_flg.disabled = false;
					}
				}

				break;

			case IBSEARCH_ASYNC10:	//조회(Form Currency Code 입력시)
 				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH07+"&curr_cd="+ComGetObjValue(formObj.to_curr_cd);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "curr_cd") != undefined ) {
							var vCurrCode = ComGetEtcData(sXml, "curr_cd");
							ComSetObjValue(formObj.to_curr_cd, vCurrCode);
							ComSetNextFocus(formObj.to_curr_cd);
							formObj.locl_tax_flg.disabled = vCurrCode == "KRW" ? false : true;
							formObj.locl_tax_flg.value    = vCurrCode == "KRW" ? "Y"   : "N";

							//환율적용 Invoice Amount 조회
							if(formObj.inv_isu_dt.value != "") {
								doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC11);
							}
						} else {
							ComShowCodeMessage("LSE01048");
							clearForm("to_curr_cd");
							ComSetFocus(formObj.to_curr_cd);
						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						clearForm("to_curr_cd");
						ComSetFocus(formObj.to_curr_cd);
					}
				}
				break;

			case IBSEARCH_ASYNC11:	//Invoice Amount 조회
				if ( validateForm(sheetObj, formObj, sAction) ) {
					sheetObj.WaitImageVisible = false;
					formObj.f_cmd.value = SEARCH05;
					var sXml = sheetObj.GetSearchXml("EES_LSE_0019GS.do", FormQueryString(formObj));
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if(ComGetEtcData(sXml, "inv_isu_dt") == undefined) {
							ComShowCodeMessage("LSE01048");
							clearForm("inv_isu_dt");
							ComSetFocus(formObj.inv_isu_dt);
						} else {
							ComSetObjValue(formObj.to_curr_rt,	ComGetMaskedValue(ComGetEtcData(sXml, "to_curr_rt"), "float"));
							ComSetObjValue(formObj.usd_xch_rt,	ComGetMaskedValue(ComGetEtcData(sXml, "to_curr_rt"), "float"));
							ComSetObjValue(formObj.to_curr_cd,	ComGetEtcData(sXml, "to_curr_cd"));

							//=========================================================================================
							//if(formObj.inv_no.value == formObj.invoice_no.value) {//Invoice 생성모드
							formObj.locl_tax_flg.disabled = formObj.to_curr_cd.value == "KRW" ? false: true;
							formObj.locl_tax_flg.value    = formObj.to_curr_cd.value == "KRW" ? "Y" : "N";

							var vChgAmt = Number(ComGetUnMaskedValue(ComGetEtcData(sXml, "to_chg_amt"), "float"));
							var vTaxAmt = formObj.locl_tax_flg.value == "N" ? 0 : (vChgAmt / 10);
							var vTtlAmt = vChgAmt + vTaxAmt;

							if(formObj.to_curr_cd.value == "KRW") {
								ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(), "float"));
								ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(), "float"));
								ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(), "float"));
							} else {
								ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(2), "float"));
								ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
								ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
							}
							ComSetObjValue(formObj.ttl_curr_cd,	ComGetEtcData(sXml, "to_curr_cd"));

							if(ComGetEtcData(sXml, "inv_isu_dt") != ComGetUnMaskedValue(formObj.inv_isu_dt.value, "ymd")) {
								ComShowCodeMessage("LSE01131", formObj.inv_isu_dt.value);
								if(ComGetEtcData(sXml, "inv_isu_dt") != "") {//GL_DT의 존재시
									ComSetObjValue(formObj.inv_isu_dt,	ComGetEtcData(sXml, "inv_isu_dt"));
									ComSetFocus(formObj.inv_isu_dt);
									ComSetNextFocus(formObj.inv_due_dt);

									//설정된 일자에 해당하는 Ex,Rate를 재조회한다.
									doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC11);
								} else {
									clearForm("inv_isu_dt");
									ComSetFocus(formObj.inv_isu_dt);
									break;
								}
							}

							//통화코드 옵션을 로그인 사용자에 따라 동적 재설정한다.
							setDynamicCurrcyList(false);
							ComEnableObject(formObj.to_curr_rt, true);
							ComEnableObject(formObj.to_curr_cd, true);

							//ComEnableObject(formObj.btns_search2,  true);
							formObj.to_curr_rt.className = "input1";
							formObj.to_curr_cd.className = "input1";
							//}
							//=========================================================================================
						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" && errMsg != undefined) {
							ComShowMessage(errMsg);
						}
						clearForm("inv_isu_dt");
						ComSetFocus(formObj.inv_isu_dt);
					}
				}
				break;

			case IBSEARCH_ASYNC12: // Customer Name 조회
				if(validateForm(sheetObj, formObj, sAction)) {
					var actCustCntCd = formObj.cust_cnt_cd.value;
					var actCustSeq = formObj.cust_seq.value;

					formObj.f_cmd.value = SEARCH03;
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);
					sheetObj.WaitImageVisible = true;

					if(sXml != "") {
						if ( ComGetEtcData(sXml, "cust_eng_nm") != undefined ) {
							if ( ComGetEtcData(sXml, "cust_eng_nm") != "" ) {
								var vCustNm = ComGetEtcData(sXml, "cust_eng_nm");
								ComSetObjValue(formObj.cust_nm,   vCustNm);

							} else {
								ComShowCodeMessage("LSE01048");
								formObj.cust_seq.value = "";
								formObj.cust_nm.value = "";
							}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" && errMsg != undefined) {
								ComShowMessage(errMsg);
							}
							formObj.cust_seq.value = "";
							formObj.cust_nm.value = "";
						}
					}
				}
				break;

			case IBSEARCH_ASYNC13:	//저장 - Invoice Confirm 선택시
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet2") {
						formObj.f_cmd.value = MULTI04;
						var sXml = sheetObj.GetSaveXml("EES_LSE_0019GS.do", FormQueryString(formObj) +sheetObj.GetSaveString(true, false) + "&IBPREFIX=sheet2_", false);

						//INV I/F 로직 변경으로 인해 업데이트 되지 않았을 경우 해당 사유 알림 
						var arIfNo = ComGetEtcData(sXml, "arIfNo");
						var arIfNoArr = arIfNo.split("::");
						if(arIfNoArr[0] == "S"){
							ComShowCodeMessage("LSE10001");
							doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
						}else{
							ComShowMessage("ERROR : "+ arIfNoArr[1]);
						}
					}
				}
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
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;

		with(sheetObj) {
			var prefix = sheetObj.id +"_";
			var sName = ColSaveName(Col);

			switch(sName) {
				case prefix +"agmt_seq":
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="+ SEARCH03 + "&agmt_cty_cd=HHO"+ "&agmt_seq="+ CellValue(Row,Col);
						WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
 						WaitImageVisible = true;

 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "agmt_seq") != undefined) {
				 				if (ComGetEtcData(sXml, "agmt_seq") != "") {
				 					CellValue2(Row, Col) = ComGetEtcData(sXml, "agmt_seq");
				 					CellValue2(Row, prefix +"lstm_cd") = "";
				 					CellValue(Row, prefix +"lstm_cd")  = ComGetEtcData(sXml, "lstm_cd");
		 						} else {
		 							ComShowCodeMessage("LSE01039");
				 					CellValue(Row, Col) = "";
		 						}
 							} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
			 					CellValue(Row, Col) = "";
 								SelectCell(Row, Col);
 							}
 						}
					} else {
						CellValue2(Row, prefix +"lse_cntr_chg_rst_cd") = "";
						CellValue2(Row, prefix +"vndr_seq") = "";
	 					CellValue2(Row, prefix +"vndr_abbr_nm") = "";
	 					CellValue2(Row, prefix +"agmt_cty_cd") = "";
	 					CellValue2(Row, prefix +"agmt_seq") = "";
	 					CellValue2(Row, prefix +"agmt_no") = "";
	 					CellValue2(Row, prefix +"lstm_cd") = "";
	 					CellValue2(Row, prefix +"eff_dt") = "";
	 					CellValue2(Row, prefix +"exp_dt") = "";
	 					CellValue2(Row, prefix +"cost_yrmon") = "";
	 					CellValue2(Row, prefix +"ref_no") = "";
					}
					break;
				case prefix +"lstm_cd":
					if(CellValue(Row,Col) != "") {
						if(/SO|MO/.test(Value) == false) {
							ComShowCodeMessage("LSE10007", "\'SO\',\'MO\'");
		 					CellValue(Row, prefix +"agmt_seq") = "";
						} else {
			 				var param = "f_cmd="+ SEARCH06 +"&agmt_seq="+ CellValue(Row, prefix +"agmt_seq")
			 						  + "&qty_yrmon="+ CellValue(Row, prefix +"qty_yrmon");

				        	sheetObj.WaitImageVisible = false;
							var sXml = sheetObj.GetSearchXml("EES_LSE_0019GS.do", param);
							sheetObj.WaitImageVisible = true;

							if(sXml != "") {
								if (ComGetEtcData(sXml, "agmt_seq") != undefined) {
					 				if (ComGetEtcData(sXml, "rcv_rntl_seq") == "") {
					 					CellValue2(Row, prefix +"vndr_seq") = ComGetEtcData(sXml, "vndr_seq");
					 					CellValue2(Row, prefix +"vndr_abbr_nm") = ComGetEtcData(sXml, "vndr_abbr_nm");
					 					CellValue2(Row, prefix +"agmt_cty_cd") = ComGetEtcData(sXml, "agmt_cty_cd");
					 					CellValue2(Row, prefix +"agmt_seq") = ComGetEtcData(sXml, "agmt_seq");
					 					CellValue2(Row, prefix +"agmt_no") = ComGetEtcData(sXml, "agmt_no");
					 					CellValue2(Row, prefix +"lstm_cd") = ComGetEtcData(sXml, "lstm_cd");
					 					CellValue2(Row, prefix +"eff_dt") = ComGetEtcData(sXml, "eff_dt");
					 					CellValue2(Row, prefix +"exp_dt") = ComGetEtcData(sXml, "exp_dt");
					 					CellValue2(Row, prefix +"cost_yrmon") = ComGetEtcData(sXml, "cost_yrmon");
					 					CellValue2(Row, prefix +"ref_no") = ComGetEtcData(sXml, "ref_no");
			 						} else {
			 							ComShowCodeMessage("LSE01055");
					 					CellValue(Row, prefix +"agmt_seq") = "";
			 						}
	 							}
							}
						}
					}
					break;

				case prefix +"inv_chk":
					var vInvCheck = FindCheckedRow(prefix +"inv_chk").split("|");
					var vRcvRntlNo = "";
					var vInvAgmtNo = "";
					var vInvLstmCd = "";

					clearForm("inv_isu_dt");

					if(vInvCheck.length == 1) {
						clearForm("invoice_no");
					} else if(vInvCheck.length == 2) {
						ComSetObjValue(formObj.inv_no, formObj.invoice_no.value);
						ComSetObjValue(formObj.inv_vndr_seq, CellValue(vInvCheck[0], "sheet1_vndr_seq"));
						ComSetObjValue(formObj.inv_vndr_abbr_nm, CellValue(vInvCheck[0], "sheet1_vndr_abbr_nm"));
						ComSetObjValue(formObj.cost_yrmon, CellValue(vInvCheck[0], "sheet1_cost_yrmon"));
						ComSetObjValue(formObj.cust_cnt_cd, "");
						ComSetObjValue(formObj.cust_seq,    "");
						ComSetObjValue(formObj.cust_nm,     "");
					}

					var vVenderSeq = CellValue(Row, "sheet1_vndr_seq");
					if(Value == 1 && vVenderSeq != formObj.inv_vndr_seq.value) {
						ComShowCodeMessage("LSE01110");
						CellValue2(Row, "sheet1_inv_chk") = 0;
						return;
					}

					for(var i = 0; i < vInvCheck.length; i++) {
						if(vInvCheck[i] != "") {
							vRcvRntlNo += CellValue(vInvCheck[i], "sheet1_rcv_rntl_seq") +"|";
							vInvAgmtNo += CellValue(vInvCheck[i], "sheet1_agmt_seq") +"|";
							vInvLstmCd += CellValue(vInvCheck[i], "sheet1_lstm_cd") +"|";
						}
					}
					ComSetObjValue(formObj.rcv_rntl_seq, vRcvRntlNo.substr(0,vRcvRntlNo.length -1));
					ComSetObjValue(formObj.inv_agmt_seq, vInvAgmtNo.substr(0,vInvAgmtNo.length -1));
					ComSetObjValue(formObj.inv_lstm_cd,  vInvLstmCd.substr(0,vInvLstmCd.length -1));

					if(vInvCheck.length > 1) {
						doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC09);
					} else {
						LseComBtnControl(false, "btn_invoice|btn_confirm|btn_print|btn_cntr");
					}
					break;

				default :
					//do nothing
			}
		}
 	}

 	/**
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			//마우스 위치를 행과 컬럼과 값 가져오기
			var prefix = sheetObj.id +"_";
			if(MouseRow >= HeaderRows && ColSaveName(MouseCol) == prefix +"inv_no") {
				MouseToolTipText = CellText(MouseRow, prefix +"if_err_rsn");
			} else {
				MouseToolTipText = "";
			}

			var linkFlag = CellValue(MouseRow, MouseCol) != "";
			DataLinkMouse(prefix +"inv_no") = linkFlag;
			DataLinkMouse(prefix +"inv_cre_usr_id") = linkFlag;
		}
	}

	/**
	 * sheet1_OnMouseMove :: 마우스로 해더를 눌러 소트가 완료되었을 때 발생하는 Event
	 */
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		with(sheetObj) {
			var sName = ColSaveName(Col);
			var prefix = sheetObj.id +"_";

			switch(sName) {
				case prefix +"lse_cntr_chg_rst_cd":
					ColumnSort(prefix +"lse_cntr_chg_sts_cd", SortArrow);
					break;
				case prefix +"agmt_cty_cd":
					ColumnSort(prefix +"agmt_seq", SortArrow);
					break;
				case prefix +"inv_chk":
					ColumnSort(prefix +"inv_no", SortArrow);
					break;
			}
		}
	}

	/**
 	 * Sheet의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "sheet1_agmt_seq":		//Agreement No Pop-up
					openPopup("4", Row, Col);
					break;
			}
 		}
    }

	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);

		if(sheetObj.MousePointer != "Hand") return;

		with(sheetObj) {
			switch(sName) {
				case "sheet1_inv_no":
					var vInvIfFlg = CellValue(Row, "sheet1_inv_if_flg") == "";
					var vCreOfcCd = CellValue(Row, "sheet1_inv_cre_ofc_cd");
					var vCrimFlg  =	vInvIfFlg && formObj.ofc_cd.value == vCreOfcCd;

					if(vCrimFlg) {//INV Confirm 처리전
						clearForm("inv_cfrm");
					} else {//INV Interface 처리완료
						clearForm("invoice_no");
					}

					CheckAll2("sheet1_inv_chk") = 0;
					ComSetObjValue(formObj.inv_no, CellValue(Row, "sheet1_inv_no"));
					ComSetObjValue(formObj.inv_vndr_seq, CellValue(Row, "sheet1_vndr_seq"));
					ComSetObjValue(formObj.inv_vndr_abbr_nm, CellValue(Row, "sheet1_vndr_abbr_nm"));
					ComSetObjValue(formObj.cost_yrmon,  CellValue(Row, "sheet1_cost_yrmon"));
					ComSetObjValue(formObj.rcv_rntl_seq, "");
					ComSetObjValue(formObj.inv_agmt_seq, "");
					ComSetObjValue(formObj.inv_lstm_cd,  "");
					ComSetObjValue(formObj.cust_cnt_cd,   CellValue(Row, "sheet1_cust_cnt_cd"));
					ComSetObjValue(formObj.cust_seq,      CellValue(Row, "sheet1_cust_seq"));
					ComSetObjValue(formObj.cust_nm,       CellValue(Row, "sheet1_cust_eng_nm"));

					ComSetObjValue(formObj.inv_isu_dt,   CellText(Row, "sheet1_inv_isu_dt"));
					ComSetObjValue(formObj.inv_due_dt,   CellText(Row, "sheet1_inv_due_dt"));
					ComSetObjValue(formObj.to_curr_rt,   ComGetMaskedValue(CellValue(Row, "sheet1_locl_xch_rt"), "float"));
					ComSetObjValue(formObj.to_curr_cd,   CellValue(Row, "sheet1_locl_curr_cd"));
					ComSetObjValue(formObj.locl_tax_flg, CellValue(Row, "sheet1_locl_tax_flg"));

					//Invoice Summary 내역조회
					var param = "f_cmd="+SEARCH04+"&cost_yrmon="+CellValue(Row, "sheet1_cost_yrmon")
							  + "&inv_no="+ CellValue(Row, Col)+ "&IBPREFIX=sheet2_";
					sheetObjects[1].DoSearch4Post("EES_LSE_0019GS.do", param);

					//환율적용 Invoice Amount 조회
					if(formObj.inv_isu_dt.value != "") {
						//================================================================================ 추가작업[2010.04.22]
						//doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC11);
						//환율적용 로직을 삭제하고 I/F 여부에 따른 Invoice Confirm 기능으로 전환한다.
						//================================================================================
					}

					//================================================================================
					//일괄청구에 따른 Local 금액의 정산방식의 특별한 지침이 없는 경우에는
					//데이터의 혼돈을 피하기 위하여 현재와 같이 이벤트 방식으로 계산한다.
					var vChgAmt = Number(ComGetUnMaskedValue(formObj.fm_chg_amt.value, "float")) *
								  Number(ComGetUnMaskedValue(formObj.to_curr_rt.value, "float"));
					var vTaxAmt = formObj.locl_tax_flg.value == "N" ? 0 : (vChgAmt / 10);
					var vTtlAmt = vChgAmt + vTaxAmt;

					if(formObj.to_curr_cd.value == "KRW") {
						ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(), "float"));
						ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(), "float"));
						ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(), "float"));
					} else {
						ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(2), "float"));
						ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
						ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
					}
					ComSetObjValue(formObj.ttl_curr_cd,	formObj.to_curr_cd.value);
					//================================================================================

					LseComBtnControl(!vCrimFlg, "btn_print");
					LseComBtnControl(false, "btn_invoice");
					LseComBtnControl(vCrimFlg, "btn_confirm");
					LseComBtnControl(true, "btn_cntr");
				break;
				case "sheet1_inv_cre_usr_id":
					//사용자정보 화면을 팝업한다.
					ComUserPopup(CellValue(Row, Col));
				break;
			}
		}
	}

 	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;

    	with(sheetObj) {
    		var prefix = sheetObj.id +"_";
    		ColFontColor(prefix +"inv_cre_usr_id") = RgbColor(0, 0, 255);

    		for(var i = 0; i <= SearchRows; i++) {
    			if(CellValue(i, prefix +"cfm_flg") == "N") {//Non Inv-IF
    				CellFontColor(i, prefix +"inv_no") = RgbColor(133, 133, 133);
    			} else if(CellValue(i, prefix +"if_err_rsn") == "") {//Success Inv-IF
    				CellFontColor(i, prefix +"inv_no") = RgbColor(0, 0, 255);
    			} else {//Faile Inv-IF
					CellFontColor(i, prefix +"inv_no") = RgbColor(255, 0, 0);
    			}

    			var vChgStsCd = CellValue(i, prefix +"lse_cntr_chg_sts_cd");
    			var vCfrmFlag = CellValue(i, prefix +"cfm_flg")
    			CellEditable(i, prefix +"del_chk") = vChgStsCd != "I";
    			CellEditable(i, prefix +"inv_chk") = vChgStsCd == "C" || vChgStsCd == "I" && vCfrmFlag == "N";
    		}
    	}

		// 조회 후 데이터 가공을 위한 버튼 콘트롤
		LseComBtnControl(true, "btn_charge|btn_recharge");
		LseComBtnControl(false, "btn_invoice|btn_confirm|btn_print|btn_cntr");

		/* Invoice Number 조회 */
    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);

    	/* Invoice Summary 초기화 */
    	clearForm("invoice_no");
    }

    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		var formObj = document.form;
    		var prefix = sheetObj.id +"_";

    		for(var i = HeaderRows; i <= SearchRows; i++) {
				if(CellValue(i, prefix +"rcv_rntl_seq") == "") {
					RowBackColor(i) = LSE_TOTCOL_BACK_COLOR;
				} else {
					CellValue(i, prefix +"cost_yrmon") = formObj.cost_yrmon.value;
				}
			}

			// 조회 후 데이터 가공을 위한 버튼 콘트롤
			if(formObj.inv_no.value == formObj.invoice_no.value) {//Invoice 생성모드
				LseComBtnControl(SearchRows > 0, "btn_invoice");
				LseComBtnControl(false, "btn_confirm");
				LseComBtnControl(false, "btn_print");
				LseComBtnControl(true, "btn_cntr");
			}

			if(SearchRows > 0) {
				var vInvAmt = Number(CellValue(LastRow , prefix +"cost_amt"));
				ComSetObjValue(formObj.fm_chg_amt,	ComGetMaskedValue(vInvAmt.toFixed(2), "float"));
				ComSetObjValue(formObj.fm_curr_cd,	"USD");
			} else {
				ComSetObjValue(formObj.fm_chg_amt,	"0.00");
				ComSetObjValue(formObj.fm_curr_cd,	"USD");
			}
    	}
    }

 	/**
     * 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if(!/Error/.test(ErrMsg)) {
    		//doActionIBSheet(sheetObj, document.form, IBSEARCH);
    	}
    }

    /**
     * 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;

    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
    		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    	}
    }

 	/**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Popup for FORM, 3:Location Popup for GRID
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;

    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "2" ) {
			ComOpenPopup('/hanjin/COM_ENS_N13.do', 500, 420, 'setPopData_Currency', '1,0,1', true);
    	} else if( type == "3") {
    		var formObj = document.form;
    		ComOpenWindowCenter("/hanjin/EES_LSE_0044.do?"+ FormQueryString(formObj), "EES_LSE_0044", 900,430, true);
    	} else if( type == "4") {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement',  '1,0', false, false, Row, Col, 0);
    	} else if( type == "5") {
    		var v_cust_cnt_cd = formObj.cust_cnt_cd.value;
			var v_cust_seq = formObj.cust_seq.value;
			var classId = "FNS_INV_0013";
			var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;

			ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, '', 'width=900,height=650');
    	} else if( type == "6") {
    		var v_cust_cnt_cd = formObj.cust_cnt_cd.value;
			var v_cust_seq = formObj.cust_seq.value;
			var v_cust_nm = sheetObjects[2].UrlEncoding(formObj.cust_nm.value);
			var classId = "FNS_INV_0086";
			var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;

			ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'setPopData_Customer', '1,0,1,1,1', false, false);
    	}

    	return;
    }

    /**
	 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj = sheetObjects[SheetIdx];
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
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
			ComSetObjValue(formObj.to_curr_cd, aryPopupData[0][2]);

			//환율적용 Invoice Amount 조회
			if(formObj.inv_isu_dt.value != "") {
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC11);
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
    function setPopData_Agreement(aryPopupData, Row, Col, sheetIdx) {
    	var prefix = "sheet1_";

    	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var vLeaseTerm = aryPopupData[0][6];
				if(vLeaseTerm == "SO"||vLeaseTerm == "MO") {
					CellValue2(Row, prefix +"agmt_seq") = aryPopupData[0][4];
					CellValue2(Row, prefix +"lstm_cd")  = "";
					CellValue(Row,  prefix +"lstm_cd")  = aryPopupData[0][6];
				} else {
					ComShowCodeMessage("LSE10007", "\'SO\',\'MO\'");
 					CellValue(Row, prefix +"agmt_seq") = "";
				}
			}
		}
    }

	/**
	 * 팝업창(FNS_INV_0086)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값
	 */
	function setPopData_Customer(rowArray) {
		var colArray = rowArray[0];
		var formObj = document.form;

		formObj.cust_cnt_cd.value = colArray[8];
		formObj.cust_seq.value = colArray[9];
		formObj.cust_nm.value = colArray[4];
	}

	/**
	 * 경리환율 변경입력의 허용 범위를 확인한다.
	 */
	function checkXchRateAvail() {
		var rtnValue = false;
		var formObj = document.form;
		var usdXchRt = formObj.usd_xch_rt.value;	//조회된 경리환율
		var invXchRt = formObj.to_curr_rt.value;	//입력한 경리환율
		var maxInvXchRt = 0;
		var minInvXchRt = 0;

		if (!ComIsNull(formObj.usd_xch_rt) && !ComIsNull(formObj.to_curr_rt)) {
			maxInvXchRt = Number(ComReplaceStr(usdXchRt,",","")) * 1.5;
			minInvXchRt = Number(ComReplaceStr(usdXchRt,",","")) * 0.5;

			if (Number(ComReplaceStr(invXchRt,",","")) <= Number(maxInvXchRt) &&
				Number(ComReplaceStr(invXchRt,",","")) >= Number(minInvXchRt)) {
				formObj.to_curr_rt.value = ComAddComma(invXchRt);
				rtnValue = true;
			} else {
				formObj.to_curr_rt.value = ComAddComma(usdXchRt);
			}
		}
		return rtnValue;
	}

	/**
	 * 통화코드 옵션을 사용자에 따라 동적으로 재설정한다.
	 */
	function setDynamicCurrcyList(initFlag) {
		var formObj = document.form;
		var ofcCode = formObj.ofc_cd.value;
		var options = formObj.to_curr_cd.options;

		if(initFlag == true) {
			for(var i = 0; i < options.length; i++) {
				options[i] = null;
			}
			options[0] = new Option("","");
			options[1] = new Option("KRW","KRW");
			options[2] = new Option("EUR","EUR");
			options[3] = new Option("USD","USD");
		} else if(initFlag == false) {
			for(var i = 0; i < options.length; i++) {
				if(/^HAM*/.test(ofcCode) && options[i].value == "KRW" ||
				   /^SEL*/.test(ofcCode) && options[i].value == "EUR") {
					options[i] = null;
					break;
				}
			}
		}
	}

	/**
	 * 달력선택 이후에 처리될 콜백 메서드를 정의한다.
	 */
	function callbackSetQtyYrmon() {
		var formObj  = document.form;
		var vQtyYrmon = formObj.qty_yrmon.value;
		ComResetAll();
		ComSetObjValue(formObj.qty_yrmon, vQtyYrmon);

		try {
			doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC01);
		} catch(e) {
			//do nothing
		}
	}

	/**
	 * 달력선택 이후에 처리될 콜백 메서드를 정의한다.
	 */
	function callbackSetInvIsuDt() {
		var formObj  = document.form;
		try {
			doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC11);
			if(ComIsDate(formObj.inv_isu_dt.value)) {
				var addDays = formObj.ofc_cd.value == "HAMRUO" ? 30 : 14;
				ComSetObjValue(formObj.inv_due_dt, 	ComGetDateAdd(formObj.inv_isu_dt, "D", addDays));
			}
		} catch(e) {
			//do nothing
		}
	}

    /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      	//조회
    			case IBSEARCH_ASYNC03:	//저장 - Preperation
    			case IBSEARCH_ASYNC09:	//조회 - Invoice Summary
    				return ComChkValid(formObj);
    				break;
    			case IBSEARCH_ASYNC11:	//조회 - Invoice Amount
    				if(formObj.inv_isu_dt.value == "") {
    					ComShowCodeMessage("LSE01111");
    					ComSetFocus(formObj.inv_isu_dt);
    					return false;
    				} else {
    					return ComChkValid(formObj);
    				}
    				break;
    			case IBSEARCH_ASYNC12:	//조회 - Customer Name
    				if(formObj.cust_cnt_cd.value == "") {
    					ComShowCodeMessage("LSE01154");
    					ComSetObjValue(formObj.cust_seq, "");
    					ComSetFocus(formObj.cust_cnt_cd);
    					return false;
    				} else {
    					return ComChkValid(formObj);
    				}
				default :	//do nothing
    		}
    	}

	    with(sheetObj) {
	    	var prefix = sheetObj.id +"_";

    		switch(sAction) {
	    		case IBSEARCH_ASYNC04:	//저장 - Charge Creation
	    			if(FindCheckedRow(prefix +"del_chk") == "") {
	    				ComShowMessage(MessageText("UserMsg13"));
	    				return false;
	    			}

	    			//특정 컬럼 내에 중복된 값이 존재하는지 여부를 확인
					var dupRow = ColValueDup("sheet1_agmt_seq|sheet_1_cost_yrmon", false);
					if(dupRow != -1 && RowStatus(dupRow) == "I") {
						ComShowCodeMessage("LSE01055");
						CellValue(dupRow, prefix +"agmt_seq") = "";
						return false;
					}

	    			for(var i = 0; i <= RowCount; i++) {
	    				var vChgStsCd = CellValue(i, prefix +"lse_cntr_chg_sts_cd");

	    				if(CellValue(i, prefix +"del_chk") == 1) {
	    					if(RowStatus(i) == "I" && CellValue(i, prefix +"agmt_seq") == "") {
	    						ComShowCodeMessage("LSE01006");
		    					SelectCell(i, prefix +"agmt_seq");
		    					return false;
	    					} else if(vChgStsCd == "C") {
		    					ComShowCodeMessage("LSE01058");
		    					SelectCell(i, prefix +"del_chk");
		    					return false;
		    				}
	    				}
	    			}
	    			return true;
	    			break;

	    		case IBSEARCH_ASYNC05:	//저장 - RE Creation
	    			if(FindCheckedRow(prefix +"del_chk") == "") {
	    				ComShowMessage(MessageText("UserMsg13"));
	    				return false;
	    			}

					//==================================================================
					// 주)Charge Creation & Charge Recreation의 기능통합으로 추후 분리시 삭제 - 2009.11.13
					//------------------------------------------------------------------
					//특정 컬럼 내에 중복된 값이 존재하는지 여부를 확인
					var dupRow = ColValueDup("sheet1_agmt_seq|sheet_1_cost_yrmon", false);
					if(dupRow != -1 && RowStatus(dupRow) == "I") {
						ComShowCodeMessage("LSE01055");
						CellValue(dupRow, prefix +"agmt_seq") = "";
						return false;
					}

	    			for(var i = 0; i <= RowCount; i++) {
	    				var vChgStsCd = CellValue(i, prefix +"lse_cntr_chg_sts_cd");

	    				if(CellValue(i, prefix +"del_chk") == 1) {
	    					if(RowStatus(i) == "I" && CellValue(i, prefix +"agmt_seq") == "") {
	    						ComShowCodeMessage("LSE01006");
		    					SelectCell(i, prefix +"agmt_seq");
		    					return false;
	    					}
	    				}
						//===============================================================
						// 주)Charge Recreation 작업시 원 유효성 검증로직 추후 분리시 복원 - 2009.11.13
						//------------------------------------------------------------------
	    				//if(vChgStsCd == "N" && CellValue(i, prefix +"del_chk")) {
	    				//	ComShowCodeMessage("LSE01114");
	    				//	SelectCell(i, prefix +"del_chk");
	    				//	return false;
	    				//}
	    			}

	    			return true;
	    			break;

	    		case IBSEARCH_ASYNC06:	//저장 - Invoice Creation
	    		case IBSEARCH_ASYNC13:	//저장 - Invoice Confirm
	    			if(formObj.cust_cnt_cd.value == "") {
						ComShowCodeMessage("LSE01154");
    					ComSetFocus(formObj.cust_cnt_cd);
    					return false;
    				} else if(formObj.cust_seq.value == "") {
						ComShowCodeMessage("LSE01155");
    					ComSetFocus(formObj.cust_seq);
    					return false;
    				} else if(formObj.inv_isu_dt.value == "") {
    					ComShowCodeMessage("LSE01111");
    					ComSetFocus(formObj.inv_isu_dt);
    					return false;
    				} else if(formObj.inv_due_dt.value == "") {
    					ComShowCodeMessage("LSE01112");
    					ComSetFocus(formObj.inv_due_dt);
    					return false;
    				}
	    			return true;
	    			break;

	    		default : 	//do nothing
    		}
    	}

        return true;
	}

	/**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
			case "invoice_no":
				setDynamicCurrcyList(true);

				ComSetObjValue(formObj.inv_no, "");
				ComSetObjValue(formObj.inv_vndr_seq, "");
				ComSetObjValue(formObj.inv_vndr_abbr_nm, "");
				ComSetObjValue(formObj.cost_yrmon,  "");
				ComSetObjValue(formObj.rcv_rntl_seq,"");
				ComSetObjValue(formObj.inv_agmt_seq,"");
				ComSetObjValue(formObj.inv_lstm_cd, "");

				ComSetObjValue(formObj.fm_chg_amt,	"");
				ComSetObjValue(formObj.fm_curr_cd,	"");
				ComSetObjValue(formObj.to_curr_rt,	"");
				ComSetObjValue(formObj.usd_xch_rt,	"");
				ComSetObjValue(formObj.to_chg_amt,	"");
				ComSetObjValue(formObj.to_curr_cd,	"");
				ComSetObjValue(formObj.inv_isu_dt,	"");
				ComSetObjValue(formObj.inv_due_dt,	"");

				ComSetObjValue(formObj.cust_cnt_cd,	"");
				ComSetObjValue(formObj.cust_seq,	"");
				ComSetObjValue(formObj.cust_nm,	"");
				ComSetObjValue(formObj.tax_amount,	"");
				ComSetObjValue(formObj.ttl_chg_amt,	"");
				ComSetObjValue(formObj.ttl_curr_cd,	"");
				ComSetObjValue(formObj.locl_tax_flg,"N");

				ComEnableObject(formObj.cust_cnt_cd, false);
				ComEnableObject(formObj.cust_seq, false);
				ComEnableObject(formObj.inv_isu_dt,false);
				ComEnableObject(formObj.inv_due_dt,false);
				ComEnableObject(formObj.to_curr_rt, false);
				ComEnableObject(formObj.to_curr_cd, false);
				ComEnableObject(formObj.btns_cust1,false);
				ComEnableObject(formObj.btns_cust2,false);
				//ComEnableObject(formObj.btns_search2,  false);
				ComEnableObject(formObj.btns_calendar2,false);
				ComEnableObject(formObj.btns_calendar3,false);

				formObj.cust_cnt_cd.className  = "input2";
				formObj.cust_seq.className  = "input2";
				formObj.inv_isu_dt.className  = "input2";
				formObj.inv_due_dt.className  = "input2";
				formObj.to_curr_rt.className  = "input2";
				formObj.to_curr_cd.className  = "input2";
				formObj.locl_tax_flg.disabled = true;

				sheetObjects[1].RemoveAll();
				break;
			case "to_curr_rt":
			case "to_curr_cd":
			case "inv_isu_dt":
				setDynamicCurrcyList(true);
				ComSetObjValue(formObj.to_curr_rt,	"");
				ComSetObjValue(formObj.usd_xch_rt,	"");
				ComSetObjValue(formObj.to_chg_amt,	"");
				ComSetObjValue(formObj.to_curr_cd,	"");
				ComSetObjValue(formObj.inv_isu_dt,	"");
				ComSetObjValue(formObj.inv_due_dt,	"");
				ComSetObjValue(formObj.tax_amount,	"");
				ComSetObjValue(formObj.ttl_chg_amt,	"");
				ComSetObjValue(formObj.ttl_curr_cd,	"");
				ComSetObjValue(formObj.locl_tax_flg,"N");

				ComEnableObject(formObj.to_curr_rt, false);
				ComEnableObject(formObj.to_curr_cd, false);
				//ComEnableObject(formObj.btns_search2,false);

				formObj.to_curr_rt.className  = "input2";
				formObj.to_curr_cd.className  = "input2";
				formObj.locl_tax_flg.disabled = true;
				ComSetFocus(formObj.inv_isu_dt);
				break;
			case "cust_cnt_cd":
				ComSetObjValue(formObj.cust_cnt_cd, "");
				ComSetObjValue(formObj.cust_seq,  	"");
				ComSetObjValue(formObj.cust_nm,		"");
				break;
			case "cust_seq":
				ComSetObjValue(formObj.cust_seq,  	"");
				ComSetObjValue(formObj.cust_nm,		"");
				break;
			case "inv_cfrm":
				setDynamicCurrcyList(false);
				ComEnableObject(formObj.to_curr_rt, true);
				ComEnableObject(formObj.to_curr_cd, true);
				ComEnableObject(formObj.cust_cnt_cd, true);
				ComEnableObject(formObj.cust_seq, true);
				ComEnableObject(formObj.inv_isu_dt, true);
				ComEnableObject(formObj.inv_due_dt, true);
				ComEnableObject(formObj.btns_cust1,true);
				ComEnableObject(formObj.btns_cust2,true);
				ComEnableObject(formObj.btns_calendar2,true);
				ComEnableObject(formObj.btns_calendar3,true);
				//ComEnableObject(formObj.btns_search2,  true);

				formObj.to_curr_rt.className = "input1";
				formObj.to_curr_cd.className = "input1";
				formObj.cust_cnt_cd.className  = "input1";
				formObj.cust_seq.className  = "input1";
				formObj.inv_isu_dt.className = "input1";
				formObj.inv_due_dt.className = "input1";
				break;
		}
	}

	/* 개발자 작업  끝 */