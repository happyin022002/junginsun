/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4008.js
*@FileTitle : Issued Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.08 김태균
* 1.0 Creation
* * 2011.05.20 김태균[CHM-201110830-01] [DMT] Issued Invoice Inquiry 화면 보완 요청
* * 2011.06.21 김현화[CHM-201111654-01] Issued Invoice Inquiry 화면 기능 변경
*              - POP-UP Close 후 다시 조회되지 않도록 함.
===================================================================================*/
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
     * @class EES_DMT_4008 : EES_DMT_4008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4008() {
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

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

	var COMMON_TARIFF_CD = "common_tariff_cd";
	var USER_TARIFF_TYPE = "user_tariff_type"; 
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var PERIOD_GAP = 15;
	var USR_TRF_TP;
	var Mincount = 0 ;
	

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	var sheetObject3 = sheetObjects[2]; 
    	/*******************************************************/
    	var formObject = document.form;

    	try {
     		var srcObj = window.event.srcElement;
     		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

	             	case "btns_calendar": //달력 버튼
		         		if(srcObj.style.cursor == "hand") {
		    	            var cal = new ComCalendarFromTo();
		    	            cal.select(form.s_issue_fm,  form.s_issue_to,  'yyyy-MM-dd');
		         		}
						break;
						
	 				case "btn_issue_usr":
	 					if(srcObj.style.cursor == "hand") {
	 						openPopup('issue_usr_id');
	 					}
	 					break;						

	 				case "btns_multisearch1":
	 					if(srcObj.style.cursor == "hand") {
		 					openPopup('s_invoice_no');
	 					}
	 					break;						
	 				case "btns_multisearch2":
	 					if(srcObj.style.cursor == "hand") {
	 						openPopup('s_bkg_no');
	 					}
	 					break;						

	 				case "btns_multisearch3":
	 					if(srcObj.style.cursor == "hand") {
	 						openPopup('s_bl_no');
	 					}
	 					break;						
	 					
	             	case "btns_cust_cd":
	             		openPopup('s_payer_cd');
	 					break;
	 					
					case "btn_Retrieve":
						sheetObject1.CheckAll('chk') = 0
						initButton();
						
						if (ComGetObjValue(formObject.srch_tp_cd) == "G") {
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
							doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
						}
						else {
							doActionIBSheet(sheetObject3,formObject,IBSEARCH);
						}
						break;

					case "btn_New":
						initControl();
						ofc_enable();
						break;
						
					case "btn_Minimize":
						Mincount = (Mincount+1)%2 ;
	                    Minimize(Mincount);
						break;
						
					case "btn_Cancel":
						// 체크된 행을 가져와 유효한 오피스인지 확인한다.
						var checkedRows = sheetObject1.FindCheckedRow("chk").split("|");
						for(var i=0; i < checkedRows.length - 1; i++) {
			        		var cre_ofc_cd = sheetObject1.CellValue(checkedRows[i], 'cre_ofc_cd');
			        		// Session Office와 Invoice Office가 다르면 오류 메세지 
			        		if(cre_ofc_cd != ComGetObjValue(formObject.session_ofc_cd)) {
			        			ComShowCodeMessage('DMT03024', cre_ofc_cd, ComGetObjValue(formObject.session_ofc_cd));
			        			return;
			        		}
			        	}
						// 확인 메세지를 띄운 후 Cancel 작업 수행
						if (ComShowCodeConfirm('DMT03025')) {							
							// Reason 입력 팝업을 띄운다. 멀티 캔슬건이기에 파라미터로 멀티를 준다.
							var url = "EES_DMT_4106.do?multi=Y";
							//반환값은 Cancel 성공한 Row의 행 번호이다. 
							var returnValue = ComOpenWindowCenter(url, "EES_DMT_4106", "420","450", true);
							if(returnValue != null && returnValue != '') {
								var successRows = returnValue.split(',');
								if (successRows.length != 0) {
									for(var i in successRows) {
										sheetObject1.CellValue(successRows[i], 'dmdt_inv_sts_cd') = 'X';
									}
								}
							}							
						}
						
						break;
							
					case "btn_Detail":
				    	var sheetObj = ComGetObjValue(formObject.srch_tp_cd) == "G" ? sheetObject1 : sheetObject3;
						openPopupWindow(sheetObj, formObject, srcName)
						break;

					case "btn_DownExcel":
	 					if(ComIsBtnEnable(srcName)) {
					    	var sheetObj = ComGetObjValue(formObject.srch_tp_cd) == "G" ? sheetObject1 : sheetObject3;	 						
	 						doActionIBSheet(sheetObj,formObject,IBDOWNEXCEL);
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

	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
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
        
     // IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    
		// html컨트롤 이벤트초기화
		initAxonControl();
		
		// column enable/disable
		ofc_enable();
		
		// 버튼 상태 초기화
		initButton();

		initSearchType();
    }
    
    function initSearchType() {
    	var formObj = document.form;
    	
    	var usrCntCd = ComGetObjValue(formObj.usr_cnt_cd);
    	
    	if (usrCntCd == "IN") {
    		// TAX INV Summary 항목 추가( S )
    		var op = new Option();
    		op.value = "S";
    		op.text = "TAX INV Summary";
    		
    		formObj.srch_tp_cd.options.add(op);
    	}
    }
    
    // 화면 깜빡임때문에 sheet1_OnLoadFinish 이벤트 적용
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj = document.form;
    	
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST);		// Tariff Type
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[2], SEARCH15);		// INV STS
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[3], SEARCHLIST02);	// Issue OFC
    }
    
    
    function initAxonControl() {
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListener('change',  'obj_change',  'srch_tp_cd');
		axon_event.addListenerFormat('blur',	'obj_blur',		document.form); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때

    }
    
	// BKG No, BL No 입력값의  Validation을 처리하기 위한 이벤트 함수
	function obj_change() {
		var obj = event.srcElement;
		
		if (obj.name = "srch_tp_cd") {
			var formObj = document.form;
			
			if (ComGetObjValue(obj) == 'G') {
				mainTableG.style.display = 'inline';
				mainTableS.style.display = 'none';
				
				// Group by 조회조건 설정
				ComEnableObject(formObj.s_group_by, true);
				
				// 조회결과 초기화
				sheetObjects[2].removeAll();
			} 
			else {
				mainTableG.style.display = 'none';
				mainTableS.style.display = 'inline';
				
				// Group by 조회조건 설정
				ComSetObjValue(formObj.s_group_by,  "1");
				ComEnableObject(formObj.s_group_by, false);
				
				// 조회결과 초기화
				sheetObjects[0].removeAll();
				sheetObjects[1].removeAll();
				sheetObjects[3].removeAll();
			}
		}
	}
	
    //포커스가 나갈 때
    function obj_blur(){
    	//입력Validation 확인하기 + 마스크구분자 넣기
		var obj = event.srcElement;
		
		if (obj.name == 's_bkg_no' || obj.name == 's_bl_no' || obj.name == 's_invoice_no') {
			
		} else if(obj.name == 's_payer_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCH20);
		} 
		else {
			ComChkObjValid(obj);
		}
    }
    
    /**
     * HTML Control Foucs in
     */
	function obj_focus(){
		var obj = event.srcElement;
		ComClearSeparator(obj);
        
		//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
	}
    
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
		    	// 영문대+숫자 
        		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
        	case "engup2":
		    	// 영문대+숫자+예외문자
        		DmtComKeyOnlyAlphabet('uppernum', ',');
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
	
    function ofc_enable(){
    	var formObj = document.form;
    	
    	var issueOffice = comboObjects[3];
    	
    	//Issue Office
    	issueOffice.Enable = true; 
    	issueOffice.Index="0";

    	//Issue Date
		ComEnableObject(formObj.s_issue_fm, true);
		ComEnableObject(formObj.s_issue_to, true);
		//ComEnableObject(formObj.s_inv_over, true);
		ComEnableObject(formObj.s_inv_over_fm, true);
		ComEnableObject(formObj.s_inv_over_to, true);
		ComEnableObject(formObj.s_issue_usr_id, true);
		
	    //Period Date 초기화
		ComSetObjValue(formObj.today_dt, ComGetMaskedValue(formObj.today_dt.value, "ymd"));
		var temp_day = ComGetDateAdd(ComGetObjValue(formObj.today_dt), "M", -1);
		ComSetObjValue(formObj.s_issue_fm, temp_day);
		ComSetObjValue(formObj.s_issue_to, ComGetObjValue(formObj.today_dt));
		
		//Issue Office 초기화(로그인 User Office를 Default)
  		var usr_ofc_cd = formObj.usr_ofc_cd.value;
  		issueOffice.Code = usr_ofc_cd;
		
		//OFC ClassName
    	formObj.s_issue_fm.className 		= "input1";
    	formObj.s_issue_to.className 		= "input1";
//		formObj.s_inv_over.className		= "input";
		formObj.s_inv_over_fm.className		= "input";
		formObj.s_inv_over_to.className		= "input";
		formObj.s_issue_usr_id.className	= "input";
		
//		formObj.s_inv_over.readOnly 		= false;
		formObj.s_inv_over_fm.readOnly 		= false;
		formObj.s_inv_over_to.readOnly 		= false;
		formObj.s_issue_usr_id.readOnly 	= false;
		formObj.s_issue_fm.readOnly = false;
		formObj.s_issue_to.readOnly = false;

		ComEnableObject(formObj.btns_calendar, true);
		ComEnableObject(formObj.btn_issue_usr, true);
		ComEnableObject(formObj.chk_sub_ofc, true);
		
		ComSetObjValue(formObj.s_inv_check, "N");
		
		//INV 
		ComEnableObject(formObj.s_bkg_no, true);
		ComEnableObject(formObj.s_bl_no, true);
		ComEnableObject(formObj.s_invoice_no, true);

    	ComSetObjValue(formObj.s_bkg_no, "");
    	ComSetObjValue(formObj.s_bl_no, "");
    	ComSetObjValue(formObj.s_invoice_no, "");
    	
		ComEnableObject(formObj.btns_multisearch1, false);
		ComEnableObject(formObj.btns_multisearch2, false);
		ComEnableObject(formObj.btns_multisearch3, false);
		
    	formObj.s_bkg_no.className 		= "input2";
    	formObj.s_bl_no.className		= "input2";
    	formObj.s_invoice_no.className 	= "input2";
    	
		//inv disabled
		formObj.s_invoice_no.readOnly 	= true;
		formObj.s_bkg_no.readOnly 		= true;
		formObj.s_bl_no.readOnly 		= true;
		
    }    
    function inv_enable(){
    	var formObj = document.form;
    	
    	//OFC
    	comboObjects[3].Enable = false; 
    	comboObjects[3].Index="-1";

		ComEnableObject(formObj.s_issue_fm, true);
		ComEnableObject(formObj.s_issue_to, true);

		formObj.s_issue_fm.className = "input2";
    	formObj.s_issue_to.className = "input2";
//    	formObj.s_inv_over.className = "input2";
    	formObj.s_inv_over_fm.className = "input2";
    	formObj.s_inv_over_to.className = "input2";
    	formObj.s_issue_usr_id.className = "input2";

		ComEnableObject(formObj.btns_calendar, false);
		ComEnableObject(formObj.btn_issue_usr, false);
		
		ComEnableObject(formObj.chk_sub_ofc, false);
    	
		ComSetObjValue(formObj.s_issue_fm, "");
		ComSetObjValue(formObj.s_issue_to, "");
//		ComSetObjValue(formObj.s_inv_over, "");
		ComSetObjValue(formObj.s_inv_over_fm, "");
		ComSetObjValue(formObj.s_inv_over_to, "");
		ComSetObjValue(formObj.s_issue_usr_id, "");
		ComSetObjValue(formObj.chk_sub_ofc, "");
		
		formObj.s_issue_fm.readOnly = true;
		formObj.s_issue_to.readOnly = true;
//		formObj.s_inv_over.readOnly = true;
		formObj.s_inv_over_fm.readOnly = true;
		formObj.s_inv_over_to.readOnly = true;
		formObj.s_issue_usr_id.readOnly = true;
		
		//INV
		ComEnableObject(formObj.s_bkg_no, true);
		ComEnableObject(formObj.s_bl_no, true);
		ComEnableObject(formObj.s_invoice_no, true);

    	formObj.s_bkg_no.className 	= "input1";
    	formObj.s_bl_no.className		= "input1";
    	formObj.s_invoice_no.className 	= "input1";
    	
    	ComSetObjValue(formObj.s_bkg_no, "");
    	ComSetObjValue(formObj.s_bl_no, "");
    	ComSetObjValue(formObj.s_invoice_no, "");
    	
		ComEnableObject(formObj.btns_multisearch1, true);
		ComEnableObject(formObj.btns_multisearch2, true);
		ComEnableObject(formObj.btns_multisearch3, true);
    	
		formObj.s_bkg_no.readOnly 	= false;
		formObj.s_bl_no.readOnly 	= false;
		formObj.s_invoice_no.readOnly = false;

		ComSetObjValue(formObj.s_inv_check, "Y");
		
    }    


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 270;
                    //전체 너비 설정
                    SheetWidth = mainTableG.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(3, 1, 1, 100);

					var HeadTitle1 = "||Seq.|INV No|Partial|AR IF|STS|Tariff|BKG No.|B/L No.|POR|POL|POD|DEL|CNTR No.|S/C No.|RFA No.|TAA No.|CTRT OFC|F/T|Cur.|Incurred AMT";
					HeadTitle1 += "|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Billing AMT|Tax AMT|Payable AMT|Uncollected AMT|Port";
					HeadTitle1 += "|ISS DT|ISS OFC|ISS ID|ISS Name|I/F No.|I/F DT|I/F OFC|I/F ID|I/F Name|INV Over|Payer CD|Payer Name|Credit/Ref.|Inv. Remark|payer delt flg|cntr_cnt|dmdt_inv_tp_cd";
	
					var HeadTitle2 = "||Seq.|INV No|Partial|AR IF|STS|Tariff|BKG No.|B/L No.|POR|POL|POD|DEL|CNTR No.|S/C No.|RFA No.|TAA No.|CTRT OFC|F/T|Cur.|Incurred AMT";
					HeadTitle2 += "|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Billing AMT|Tax AMT|Payable AMT|Uncollected AMT|Port";
					HeadTitle2 += "|ISS DT|ISS OFC|ISS ID|ISS Name|I/F No.|I/F DT|I/F OFC|I/F ID|I/F Name|INV Over|Payer CD|Payer Name|Credit/Ref.|Inv. Remark|payer delt flg|cntr_cnt|dmdt_inv_tp_cd";
	
					var HeadTitle3 = "||Seq.|INV No|Partial|AR IF|STS|Tariff|BKG No.|B/L No.|POR|POL|POD|DEL|CNTR No.|S/C No.|RFA No.|TAA No.|CTRT OFC|F/T|Cur.|Incurred AMT";
					HeadTitle3 += "|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Billing AMT|Tax AMT|Payable AMT|Uncollected AMT|Port";
					HeadTitle3 += "|ISS DT|ISS OFC|ISS ID|ISS Name|I/F No.|I/F DT|I/F OFC|I/F ID|I/F Name|INV Over|Payer CD|Payer Name|Credit/Ref.|Inv. Remark|payer delt flg|cntr_cnt|dmdt_inv_tp_cd";
	
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE,	SAVENAME,  		KEYFIELD,	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT,	UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++,	dtCheckBox,		30,		daCenter,		true,     	"chk");
                    InitDataProperty(0,	cnt++ ,	dtSeq,			35,		daCenter,		true,		"seq");                                       	
                    InitDataProperty(0,	cnt++ ,	dtData,			90,		daCenter,		true,		"dmdt_inv_no",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			45,		daCenter,		true,		"inv_prt_flg",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			40,		daCenter,		true,		"dmdt_ar_if_cd",	false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			30,		daCenter,		true,		"dmdt_inv_sts_cd",	false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			40,		daCenter,		true,		"dmdt_trf_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			95,		daCenter,		true,		"bkg_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		90,		daCenter,		true,		"bl_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daCenter,		true,		"por_cd",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daCenter,		true,		"pol_cd",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daCenter,		true,		"pod_cd",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daCenter,		true,		"del_cd",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,		daCenter,		true,		"cntr_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			70,		daCenter,		true,		"sc_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,		daCenter,		true,		"rfa_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,		daCenter,		true,		"taa_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daCenter,		true,		"ctrt_ofc",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			30,		daCenter,		true,		"ft_dys",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			30,		daCenter,		true,		"chg_curr_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			100,	daRight,		true,		"org_chg_amt",		false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			100,	daRight,		true,		"dmdt_expt_amt",	false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			100,	daRight,		true,		"dc_amt",			false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			100,	daRight,		true,		"bil_amt",			false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,		daCenter,		true,		"inv_curr_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			100,	daRight,		true,		"inv_chg_amt",		false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			100,	daRight,		true,		"tax_amt",			false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			100,	daRight,		true,		"inv_amt",			false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			100,	daRight,		true,		"uncol_amt",		false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			50,		daCenter,		true,		"port",				false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			70,		daCenter,		true,		"cre_dt",			false,		"",			dfDateYmd,		0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			50,		daCenter,		true,		"cre_ofc_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daLeft,			true,		"issue_id",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,		daLeft,			true,		"issue_nm",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,		daCenter,		true,		"ar_if_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			70,		daCenter,		true,		"ar_if_dt",			false,		"",			dfDateYmd,		0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			50,		daCenter,		true,		"ar_if_ofc_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daLeft,			true,		"ar_if_usr_id",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,		daLeft,			true,		"ar_if_usr_nm",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daCenter,		true,		"inv_over",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daCenter,		true,		"act_payr_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			200,	daLeft,			true,		"act_payr_nm",		false,		"",			dfNone,			0,			false,		true,		30);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,		daCenter,		true,		"cr_inv_no",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,			300,	daCenter,		true,		"inv_rmk",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtHidden,	 	0,		daLeft,			true,		"act_delt_flg",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtHidden,	 	0,		daLeft,			true,		"cntr_cnt",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtHidden,	 	0,		daLeft,			true,		"dmdt_inv_tp_cd",	false,		"",			dfNone,			0,			false);
                    

                    FrozenCols = SaveNameCol("bkg_no");
					ToolTipOption = "balloon:true;width:50;";

					CountPosition = 0;

					//말줄임표
                    Ellipsis = true;
			}
            break;
            
            case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 90;
                    //전체 너비 설정
                    SheetWidth = mainTableG.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

					var HeadTitle1 = "||Charges|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Charges|INV Cur.|Billing AMT|Tax AMT|Payable AMT";
	
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
                    //데이터속성    	[ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, 	COLMERGE,	SAVENAME,  			KEYFIELD,	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT,	UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		"ibflag");
                    InitDataProperty(0,	cnt++ ,	dtData,		100,		daCenter,	true,		"t_name",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		70,			daRight,	true,		"t_charges",		false,		"",			dfNone,			0,			false);                                       	
                    InitDataProperty(0,	cnt++ ,	dtData,		30,			daCenter,	true,		"t_curr",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"t_incurred_amt",	false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"t_expt_amt",		false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,			daRight,	true,		"t_dc_amt",			false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"t_bil_amt",		false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		70,			daRight,	true,		"t_chr_cnt",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		50,			daCenter,	true,		"t_inv_curr",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"t_inv_chg_amt",	false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,			daRight,	true,		"t_tax_amt",		false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"t_inv_amt",		false,		"",			dfNullFloat,	2,			false);

					ToolTipOption = "balloon:true;width:50;";
					ToolTipText(0,"t_charges") = "Charge by Container";
					ToolTipText(0,"t_chr_cnt") = "Charge by Container";
					CountPosition = 0;

                }
            break;

            case "sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 360;
                    //전체 너비 설정
                    SheetWidth = mainTableS.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

					var HeadTitle = "|Issue Office|SM GSTN No|BKG No|SEZ(Y/N)|Cust GSTN No.|Cust Name|Inv No.|Issue Date|Total Inv Amount|SM State Code|Cust State Code|Reverse Charge|POR|DEL|SAC Code|Total Taxable Amount|IGST Rate|IGST Amount|CGST Rate|CGST Amount|SGST Rate|SGST Amount|UGST Rate|UGST Amount|Total Amount";
	
					var headCount = ComCountHeadTitle(HeadTitle) + 4;	// 4 : hidden column count

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    	[ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, 	COLMERGE,	SAVENAME,  			KEYFIELD,	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT,	UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		"ibflag");
                    InitDataProperty(0,	cnt++ ,	dtData,		 80,		daCenter,	true,		"iss_ofc_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		120,		daLeft,		true,		"sm_gstn_no",		false,		"",			dfNone,			0,			false);                                       	
                    InitDataProperty(0,	cnt++ ,	dtData,		 80,		daCenter,	true,		"bkg_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		 60,		daCenter,	true,		"sez_flg",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		120,		daCenter,	true,		"cust_gstn_no",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		150,		daLeft,		true,		"cust_nm",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,		daCenter,	true,		"dmdt_inv_no",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		 80,		daCenter,	true,		"iss_dt",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		110,		daRight,	true,		"ttl_inv_amt",		false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		110,		daCenter,	true,		"sm_ste_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		110,		daCenter,	true,		"cust_ste_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,		daCenter,	true,		"rvs_chg_flg",		false,		"",			dfNone,			0,			false);
					
					InitDataProperty(0,	cnt++ ,	dtData,		 50,		daCenter,	true,		"por_cd",			false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		 50,		daCenter,	true,		"del_cd",			false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		 80,		daCenter,	true,		"sac_cd",			false,		"",			dfNone,			0,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		140,		daRight,	true,		"inv_chg_amt",		false,		"",			dfNullFloat,	2,			false);
					
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"ida_igst_rto",		false,		"",			dfNullFloat,	2,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"ida_igst_amt",		false,		"",			dfNullFloat,	2,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"ida_cgst_rto",		false,		"",			dfNullFloat,	2,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"ida_cgst_amt",		false,		"",			dfNullFloat,	2,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"ida_sgst_rto",		false,		"",			dfNullFloat,	2,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"ida_sgst_amt",		false,		"",			dfNullFloat,	2,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"ida_ugst_rto",		false,		"",			dfNullFloat,	2,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"ida_ugst_amt",		false,		"",			dfNullFloat,	2,			false);
					InitDataProperty(0,	cnt++ ,	dtData,		100,		daRight,	true,		"inv_amt",			false,		"",			dfNullFloat,	2,			false);

                    InitDataProperty(0,	cnt++ ,	dtHidden, 	  0,		daLeft,		true,		"cre_ofc_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtHidden, 	  0,		daLeft,		true,		"dmdt_trf_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtHidden, 	  0,		daLeft,		true,		"cntr_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtHidden, 	  0,		daLeft,		true,		"dmdt_inv_tp_cd",	false,		"",			dfNone,			0,			false);
					
					CountPosition = 0;
                }
            break;
            
            case "sheet4":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 270;
                    //전체 너비 설정
                    SheetWidth = mainTableG.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Seq.|INV No|Partial|AR IF|STS|Tariff|BKG No.|B/L No.|POR|POL|POD|DEL|CNTR No.|S/C No.|RFA No.|CTRT OFC|F/T|Cur.|Incurred AMT";
					HeadTitle1 += "|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Billing AMT|Tax AMT|Payable AMT|Port";
					HeadTitle1 += "|ISS DT|ISS OFC|ISS ID|ISS Name|I/F No.|I/F DT|I/F OFC|I/F ID|I/F Name|INV Over|Payer CD|Payer Name|Credit/Ref.|Inv. Remark|payer delt flg|Container No|Starting Date|Ending Date|Overdays";
	
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE,	SAVENAME,  		KEYFIELD,	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT,	UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
                    InitDataProperty(0,	cnt++ ,	dtSeq,		35,		daCenter,	true,		"SEQ");                                       	
                    InitDataProperty(0,	cnt++ ,	dtData,		70,		daCenter,	true,		"dmdt_inv_no",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		45,		daCenter,	true,		"inv_prt_flg",		false,		"",			dfNone,			0,			false);
                                                                                                                                        	
                    InitDataProperty(0,	cnt++ ,	dtData,		40,		daCenter,	true,		"dmdt_ar_if_cd",	false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		30,		daCenter,	true,		"dmdt_inv_sts_cd",	false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		40,		daCenter,	true,		"dmdt_trf_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		95,		daCenter,	true,		"bkg_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtHidden,	90,		daCenter,	true,		"bl_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"por_cd",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"pol_cd",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"pod_cd",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"del_cd",			false,		"",			dfNone,			0,			false);
                                                                                                                                        	
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"cntr_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		70,		daCenter,	true,		"sc_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"rfa_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"ctrt_ofc",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		30,		daCenter,	true,		"ft_dys",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		30,		daCenter,	true,		"chg_curr_cd",		false,		"",			dfNone,			0,			false);
                    
                    InitDataProperty(0,	cnt++ ,	dtData,		100,	daRight,	true,		"org_chg_amt",		false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,	daRight,	true,		"dmdt_expt_amt",	false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,	daRight,	true,		"dc_amt",			false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,	daRight,	true,		"bil_amt",			false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"inv_curr_cd",		false,		"",			dfNone,			0,			false);
                    
                    InitDataProperty(0,	cnt++ ,	dtData,		100,	daRight,	true,		"inv_chg_amt",		false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,	daRight,	true,		"tax_amt",			false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,	daRight,	true,		"inv_amt",			false,		"",			dfNullFloat,	2,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		50,		daCenter,	true,		"port",				false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		70,		daCenter,	true,		"cre_dt",			false,		"",			dfDateYmd,		0,			false);
                    
                    InitDataProperty(0,	cnt++ ,	dtData,		50,		daCenter,	true,		"cre_ofc_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		50,		daLeft,		true,		"issue_id",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daLeft,		true,		"issue_nm",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"ar_if_no",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		70,		daCenter,	true,		"ar_if_dt",			false,		"",			dfDateYmd,		0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		50,		daCenter,	true,		"ar_if_ofc_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daLeft,		true,		"ar_if_usr_id",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daLeft,		true,		"ar_if_usr_nm",		false,		"",			dfNone,			0,			false);
                    
                    InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"inv_over",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		60,		daCenter,	true,		"act_payr_cd",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		200,	daLeft,		true,		"act_payr_nm",		false,		"",			dfNone,			0,			false,		true,		30);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"cr_inv_no",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		300,	daCenter,	true,		"inv_rmk",			false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtHidden,	200,	daLeft,		true,		"act_delt_flg",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"cntr_no_s",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"fm_mvmt_dt",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"to_mvmt_dt",		false,		"",			dfNone,			0,			false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,		"fx_ft_ovr_dys",	false,		"",			dfNone,			0,			false);


                    FrozenCols = SaveNameCol("bkg_no");
					ToolTipOption = "balloon:true;width:50;";

					CountPosition = 0;

					//말줄임표
                    Ellipsis = true;
			}
            break;

        }
    }

	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) {  
   	    	case "office": 
   	    		with (comboObj) { 
   					MultiSelect = true;
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
  					SetColWidth("60|250");
  					DropHeight = 160;
  					
					ValidChar(2);	// 영어대문자 사용
					MaxLength = 6;
   		    	}
   				break; 
   				
   	    	case "tariff_type":
   	    		with (comboObj) { 
   					MultiSelect = true;
					SetColAlign("left|left");        
					SetColWidth("45|310");
					DropHeight = 160;
   		    	}
   				break; 
   				
   	    	case "ar_if":
   	    		var rhq_ofc_cd = ComGetObjValue(formObj.session_rhq_ofc_cd);
   	    		with (comboObj) { 
   	    			if(rhq_ofc_cd == "NYCRA" || rhq_ofc_cd == "SELHO" ) {
   	    				MultiSelect = true;
   						SetColAlign("left|left");        
   						SetColWidth("100|200");
   	    			}else{
   	    				MultiSelect = false;
   						SetColAlign("left");        
   						SetColWidth("100");
   	    			}
					DropHeight = 170;
					addComboItem(comboObj, comboNo);					
   		    	}
   				break; 

   	    	case "invoice_status":
   	    		with (comboObj) { 
					MultiSelect = true;
					SetColAlign("left");        
					SetColWidth("80");
					DropHeight = 160;
   		    	}
   	    		break;

   	    }
   	}
    
   	// Sheet관련 프로세스 처리
   	function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

           case IBSEARCH:      //조회
           
               sheetObj.RemoveAll();
           	   ComSetObjValue(formObj.f_cmd, SEARCH);
        	   setParameters(SEARCH);
        	   if (validateForm(sheetObj,formObj,sAction)) {
        		   if (ComGetObjValue(formObj.s_group_by) == "1") {
        			   sheetObj.ColHidden("cntr_no") = true;
        			   sheetObj.ColHidden("ft_dys") = true;
        		   } 
        		   else {
        			   sheetObj.ColHidden("cntr_no") = false;
        			   sheetObj.ColHidden("ft_dys") = false;
        		   }
        		   
                   //ComOpenWait Start
                   sheetObj.WaitImageVisible=false;
                   ComOpenWait(true);
                   
        		   sheetObj.DoSearch("EES_DMT_4008GS.do", FormQueryString(formObj));
        		   
                   //ComOpenWait End
                   ComOpenWait(false);

                   if(sheetObj.TotalRows > 0 ) {
        			   searchButton();
        		   }else{
        			   initButton();
        		   }
        		   
					var rowcount = sheetObj.TotalRows+3;//HEAD값이 3줄임
					var lastIndex = 0;//마지막 컨테이너에 나머지값을 모두 할당하기 위한 구분값 
					var sum_charge = 0;//인보이스에 대한 요금합계금액
					var sum_tax = 0;//인보이스에 대한 세금합계금액
					var avg_charge = 0;//각 컨테이너에 할당할 인보인스 요금 합계에 대한 평균 요금 금액 
					var avg_tax = 0;// 각 컨테이너에 할당할 인보인스 세금 합계에 대한  평균 세금 금액
					var dmdt_inv_no= '';//각 컨테이너별로 평균금액 할당하기 위한  기준 인보이스 값 할당  
					var uncolAmt= 0;//각값을 할당하고 남은 미수금 금액 
					var z = 0;
        		   
        		   for(var i = 3; i < rowcount ; i++) {
        			   if(sheetObj.CellValue(i, "act_delt_flg") == "Y") {
        				  //Payer Code가 더이상 유효하지 않은 Code일 경우 빨간색으로 보이며, 말풍선 “Payer Code not available any more!”
        				   sheetObj.CellBackColor(i,"act_payr_cd") = sheetObj.RgbColor(255, 0, 0);
        				   sheetObj.CellBackColor(i,"act_payr_nm") = sheetObj.RgbColor(255, 0, 0);
        			   }
        			   //조회조건 컨테이너로 볼때만 동작 
        			   if(true) continue;
        			   
        			   //컨테이너번호가 변경될때 
        			   if(dmdt_inv_no == '' || dmdt_inv_no != sheetObj.CellValue(i, "dmdt_inv_no") ){
							size =  sheetObj.CellValue(i, "cntr_cnt") == '' ? '0' : sheetObj.CellValue(i, "cntr_cnt");
							sum_charge = sheetObj.CellValue(i, "col_charge") == '' ? '0' : sheetObj.CellValue(i, "col_charge");
							sum_tax =  sheetObj.CellValue(i, "col_tax") == '' ? '0' : sheetObj.CellValue(i, "col_tax");
							avg_charge = getCalcAvg(sum_charge, size, -2 ,sheetObj.CellValue(i, "inv_curr_cd"));
							avg_tax = getCalcAvg(sum_tax, size, -2 ,sheetObj.CellValue(i, "inv_curr_cd"));
							lastIndex =  size;
							z=1;//기준점 
        			   }
        			   
        				if (z == lastIndex) { 
        					//마지막 row 
        					avg_charge= sum_charge;
        					avg_tax=sum_tax;
        				}else{
        					sum_charge = sum_charge - avg_charge;
        					sum_tax = sum_tax - avg_tax;
        				}
        				
        				sheetObj.CellValue(i, "col_charge")=avg_charge;
        				sheetObj.CellValue(i, "col_tax")=avg_tax;
        				uncolAmt=DMTtrimCurrencyAmount(sheetObj.CellValue(i, "inv_curr_cd"), (parseFloat(sheetObj.CellValue(i, "inv_amt"))) - (parseFloat(avg_charge)+parseFloat(avg_tax)));
        				
        				sheetObj.CellValue(i, "uncol_amt")=uncolAmt ;	
        				dmdt_inv_no = sheetObj.CellValue(i, "dmdt_inv_no");
        				z++;
        		   }
        	   }
        	   break;
           case IBSEARCH_ASYNC01:      //조회
               sheetObj.RemoveAll();
           	   if(ComGetObjValue(formObj.s_payer_cd) != "" || ComGetObjValue(formObj.s_sc_no) != "" || ComGetObjValue(formObj.s_rfa_no) != ""|| ComGetObjValue(formObj.s_taa_no) != ""){
		       	   ComSetObjValue(formObj.f_cmd, SEARCH01);
		    	   setParameters(SEARCH01);
		    	   if (validateForm(sheetObj,formObj,sAction)) {
		    		   
		               //ComOpenWait Start
		               sheetObj.WaitImageVisible=false;
		               ComOpenWait(true);
		               
		    		   sheetObj.DoSearch("EES_DMT_4008GS.do", FormQueryString(formObj));
		    		   
		               //ComOpenWait End
		               ComOpenWait(false);
	
		    	   }
           	   }
    	   break;        	   
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				
				if (sheetObj.id == "sheet1" && ComGetObjValue(formObj.usr_ofc_cd) == "SAOSC" && ComGetObjValue(formObj.s_group_by) == "2") {
					var hidSheetObj = sheetObjects[3];
					
		           	ComSetObjValue(formObj.btn_id, "btn_downexcel"); 
		           	hidSheetObj.RemoveAll();
		           	ComSetObjValue(formObj.f_cmd, SEARCH);
					if (ComGetObjValue(formObj.s_group_by) == "1") {
						hidSheetObj.ColHidden("cntr_no") = true;
						hidSheetObj.ColHidden("ft_dys") = true;
	        		} 
					else {
	        			hidSheetObj.ColHidden("cntr_no") = false;
	        			hidSheetObj.ColHidden("ft_dys") = false;
	        		}
	        		   
	                //ComOpenWait Start
					hidSheetObj.WaitImageVisible=false;
	                ComOpenWait(true);
	                  
	                hidSheetObj.DoSearch("EES_DMT_4008GS.do", FormQueryString(formObj));
	        		   
	                //ComOpenWait End
	                ComOpenWait(false);

		           	ComSetObjValue(formObj.btn_id, "");
		           	hidSheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'CheckBox');
				} 
				else {
					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'CheckBox','',false,'',true);
				}
				break;

        }
    }
	/**
	 * 평균값 구하기 
	 */
	function getCalcAvg(nCalcVal, nSize, nDigit,nCurrCd){
		var nAvgVal = nCalcVal / nSize;
		nAvgVal = Math.floor(nAvgVal / Math.pow(10, nDigit)) * Math.pow(10, nDigit);		
		return DMTtrimCurrencyAmount(nCurrCd,nAvgVal);
	}
	/**
	 * EES_DMT_4002 팝업 호출
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
		if (srcName == "btn_Detail") {
			var invTpCd = sheetObj.CellValue(sheetObj.SelectRow, "dmdt_inv_tp_cd");
			
			if (invTpCd == "T" || invTpCd == "R" ){
				var url = "EES_DMT_4002.do"
					+"?group_by="+ComGetObjValue(formObj.s_group_by)
					//+"&chg_type="+ComGetObjValue(formObj.s_chg_type)
					+"&ofc_cd="+sheetObj.CellValue(sheetObj.SelectRow, "cre_ofc_cd")
					+"&bkg_no="+sheetObj.CellValue(sheetObj.SelectRow, "bkg_no")
					+"&dmdt_trf_cd="+sheetObj.CellValue(sheetObj.SelectRow, "dmdt_trf_cd")
					+"&cntr_no="+sheetObj.CellValue(sheetObj.SelectRow, "cntr_no")
					+"&invoice_no="+sheetObj.CellValue(sheetObj.SelectRow, "dmdt_inv_no")
					+"&invoice_issue=2"	//Invoice Issue AFTER
					;
	
				var returnValue = ComOpenWindowCenter(url, "EES_DMT_4002", EES_DMT_4002_WIDTH, EES_DMT_4002_HEIGHT, true);
				if (returnValue == "Y") {
					//2011.06.21 김현화
					//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
				}
			} 
			else {
				var url = "EES_DMT_4004P.do"
					+"?dmdt_inv_no="+sheetObj.CellValue(sheetObj.SelectRow, "dmdt_inv_no")
					+"&caller=4008"
					;
				ComOpenWindowCenter(url, "EES_DMT_4004", "1036","738", true);
			}

		}
	}

	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
		sheetObj.ShowDebugMsg = false;
    	sheetObj.WaitImageVisible = false;
   	 
    	formObj.f_cmd.value = formCmd;
    	var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
   	 
		switch(comboObj.id) {
			case "office":
				if(formCmd== SEARCHLIST02) {
					// Office List
					var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
					var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
					
					// 2010.03.18 수정
					if (ofc_cds != undefined && ofc_cds != '') {
						var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
	 					var idx = 0;
						
	 					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
	 					if(ofc_cds.indexOf(usrOfcCd) == -1) {
	 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
	 						idx = 1;
	 					}
	 					
						var comboCodeArr = ofc_cds.split("|");
						var comboTextArr = ofc_nms.split("|");
						
						for (var i = 0 ; i < comboTextArr.length ; i++) {
							comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
						}
						
						// 로그인 User Office를 Default로 설정
		    	  		comboObj.Code = usrOfcCd;
					}
					
				}else{// formCmd == COMMAND01
 	    		   	var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
 	    	   		if (subOfcCds != undefined && subOfcCds != '') {
 	    	   			// 조회된 Sub Office 중에서  기존 콤보리스트에 없는 것은 제거한다.
 	    	   			var arrOfcCd = subOfcCds.split(',');
 	    	   			var str = '';
 	    	   			for(var i=0; i<arrOfcCd.length; i++) {
 	    	   				var idx = comboObj.FindIndex(arrOfcCd[i], 0);
 	    	   				if(idx != -1)
 	    	   					str = str + ',' + arrOfcCd[i];
 	    	   			}
 	    	   			str = str.substring(1);
 	    	   			
 	    	   			// 하위점소 조회대상 Office 목록에  로그인 Office 포함시, 하위점소 조회결과에 로그인 Office가 없을시 추가해준다.
 	    	   			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
 	    	   			if(comboObj.Code.indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
 	    	   				str = usrOfcCd + ',' + str;
 	    	   			}
 	    	   			comboObj.Code = str;
 	    	   		}
				}
	    	    break;
	        	
	        case "tariff_type":
		 		// Tariff type comboList
				var data = ComGetEtcData(sXml, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems = data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem = comboItems[0].split(FIELDMARK);
				}
				
				var data2 = ComGetEtcData(sXml, USER_TARIFF_TYPE);
				// User Setup Tariff Type 이 없을 경우 Default값으로.
				if(data2 == '') data2 = 'CTIC,DMIF';
				
				comboObj.Code2 = data2;
				USR_TRF_TP = data2;
				formObj.usr_trf_tp.value = data2;
				break;
				
	        case "invoice_status":
		 		// Invoice Status comboList
				var data = ComGetEtcData(sXml, "COMMON_CD");
				if (data != undefined && data != '') {
					var comboItems = data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
				}
				break;
				
				

        }
        sheetObj.WaitImageVisible = true;
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
 	function addComboItem(comboObj,comboItems) {
 		var formObj = document.form;
 		
 		switch(comboObj.id) {
 			case "tariff_type":
		  		comboObj.InsertItem(0, "All|All", "All");
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split(FIELDMARK);
		  			comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
		  		break;
		  	
 			case "ar_if":
  				if(ComGetObjValue(formObj.session_rhq_ofc_cd) == "NYCRA" || ComGetObjValue(formObj.session_rhq_ofc_cd) == "SELHO") {
  	  				comboObj.InsertItem(0, "All|", "All");
  	  				comboObj.InsertItem(1, "No|", "N");
  	  				comboObj.InsertItem(2, "Yes|", "Y");
  	  				comboObj.InsertItem(3, "Hold|All Reasons", "H");
  					comboObj.InsertItem(4, "Hold(Litigation)|Collection Agency/Litigation Only", "L");
  					comboObj.Code = "All,N,Y,H,L";
  				}else{
  	  				comboObj.InsertItem(0, "All|", "A");
  	  				comboObj.InsertItem(1, "No|", "N");
  	  				comboObj.InsertItem(2, "Yes|", "Y");
  	  				comboObj.Code = "A";
  				}
  				break;
  				
 			case "invoice_status":
 				comboObj.InsertItem(0, "All", "All");
	  			comboObj.CheckIndex(0) = true;
		  		for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		var comboItem = comboItems[i].split(FIELDMARK);
		  			comboObj.InsertItem(i+1, comboItem[1], comboItem[0]);
		  			comboObj.CheckIndex(i+1) = true;
		  	   	}
		  		break;
 		}
 	}    
 	
    //Payer 체크
    function doActionText(sheetObj, formObj, object, formCmd) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;

		ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.s_payer_cd));
		var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
		
		if(cust_len == 0){
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_payer_cd, "");
			ComSetObjValue(formObj.s_payer_nm, "");
			return;
		}
		
		var cre_cnt_cd = "";
		
		if(cust_len > 2) {
			var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
			//2자리가 영문자이면 CUSTOMER 조회
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
			//아니면 VENDOR 조회
			}else{
				ComSetObjValue(formObj.s_cust_gubun, "1");
			}
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_payer_cd, "");
			ComSetObjValue(formObj.s_payer_nm, "");
			return;
		}	
		
		ComSetObjValue(formObj.f_cmd, formCmd);
		
		var sXml 	= sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		var cust_cd = ComGetEtcData(sXml, "PAYER_CODE");
		var cust_nm = ComGetEtcData(sXml, "PAYER_NM");
		var delt_flg = ComGetEtcData(sXml, "DELT_FLG");
		
		if(cust_nm == null || cust_nm == "") {
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_payer_cd, "");
			ComSetObjValue(formObj.s_payer_nm, "");
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetFocus(formObj.s_payer_cd);
		}else{
			ComSetObjValue(formObj.s_payer_cd, ComGetObjValue(formObj.s_cust_cd));
			ComSetObjValue(formObj.s_payer_nm, cust_nm);
		}
        sheetObj.WaitImageVisible = true;
		
    }
	//멀티콤보 클릭 이벤트
	function tariff_type_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	} 	

	//멀티콤보 클릭 이벤트
	function ar_if_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	} 	
	//멀티콤보 클릭 이벤트
	function coll_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	} 	

	//멀티콤보 클릭 이벤트
	function invoice_status_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	} 	
	

	//멀티콤보 클릭 이벤트
	function office_OnCheckClick(comboObj, index, code) {
		// 2010.03.18 수정
		var formObj = document.form;
   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
		//setMultiCombo(comboObj, index, code) ;
	} 	
	
	/*
	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
	 */
	function doInclSubOfc() {
		var formObj = document.form;
		
		var issueOfcCombo = comboObjects[3];	// Issue OFC
		
		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if( ComIsEmpty(comboObjects[0].Code) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			formObj.ofc_cd.value = ComGetObjValue(issueOfcCombo);										//combo값을 ofc_cd 값 셋팅
			formObj.tmp_ofc_cd.value = ComGetObjValue(issueOfcCombo);									//combo값을 tmp_ofc_cd 값 셋팅
			doActionIBCombo(sheetObjects[0], formObj, issueOfcCombo, COMMAND01)						//sub office 체크 했을때
		} else {
			ComSetObjValue(issueOfcCombo, formObj.tmp_ofc_cd.value);
		}
	} 	

	
	/*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function openPopup(flag, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'issue_usr_id':		// Issue Name Inquiry Popup
					ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 570, "setUsrNm", "1,0,1,1,1,1,1", true);
					break;
				
	  			case 's_invoice_no':		// CNTR No. 멀티입력 팝업 호출
	  			case 's_bkg_no':		// BKG No. 멀티입력 팝업 호출
	  			case 's_bl_no':		// B/L No. 멀티입력 팝업 호출
		  			var returntitle = '';
	  				if(flag == 's_bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 's_bl_no')
	  					returntitle = 'B/L No.';
	  				else if(flag == 's_invoice_no')
	  					returntitle = 'Invoice No.';
	  				
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;	  			

	  			case 's_payer_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getPayerCd", "1,0,1,1,1,1,1", true);
					break;
					
	  				
	  		} // switch-end
  		} // with-end
  		
  		if(sUrl.indexOf('.do') != -1) {
  			var sWinName = ComReplaceStr(sUrl, '.do', '');
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		} else if(sUrl != '') {
	  		ComOpenWindow('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/' + sUrl,'p'
						,'scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=' + sWidth + ',height=' + sHeight + ',left=0,top=0');
  		}
  	}
  	
  	/*
  	 * Issue Name 공통팝업에서 선택한 Issue Name, Issue Code값을 해당 필드에 설정 
  	 */
	function setUsrNm(aryPopupData){
  		document.form.s_issue_usr_id.value = aryPopupData[0][4];
  	}  	
	
	
     /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }
    
    function getPayerCd(aryPopupData){
    	document.form.s_payer_cd.value = aryPopupData[0][3];
    	document.form.s_payer_nm.value = aryPopupData[0][4];
    }
    
    function ofc_inv_click(){
    	//doEnableCondObj(event.srcElement.value);
    	var formObj = document.form;
   		if (formObj.ofc_inv_chk[0].checked) {
   			ofc_enable();

    	} 
   		else if (formObj.ofc_inv_chk[1].checked) {
    		inv_enable();
    	}
    	
    }
    
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		
		ComSetObjValue(formObj.s_issue_ofc, ComGetObjValue(formObj.office));
		ComSetObjValue(formObj.s_dmdt_trf_cd, ComGetObjValue(formObj.tariff_type));
		ComSetObjValue(formObj.s_dmdt_ar_if_cd, ComGetObjValue(formObj.ar_if));
		ComSetObjValue(formObj.s_dmdt_inv_sts_cd, ComGetObjValue(formObj.invoice_status));
		
		if (formObj.ofc_inv_chk[0].checked ) {
			ComSetObjValue(formObj.s_inv_check, "N");
		} 
		else {
			ComSetObjValue(formObj.s_inv_check, "Y");
		}
		if (sAction == SEARCH || sAction == SEARCH01) {
			ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.s_payer_cd));
			var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
			if (cust_len > 2) {
				var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
				//2자리가 영문자이면 CUSTOMER 조회
				if (ComIsAlphabet(char_chk)) {
					ComSetObjValue(formObj.s_cust_gubun, "2");
				//아니면 VENDOR 조회
				} 
				else {
					ComSetObjValue(formObj.s_cust_gubun, "1");
				}
			}
		}		
	}   
	
	/*
	 * Tool Tip(Issued, Cancelled, Credit)
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y ) {
		//마우스 위치를 행과 컬럼과 값 가져오기
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		var sName = sheetObj.ColSaveName(sheetObj.MouseCol);
		
		if (sName == "dmdt_inv_sts_cd") {
			var sText = sheetObj.CellText(Row,Col);

			//풍선도움말 만들기
			if (sText == "I") {
				sheetObj.MouseToolTipText = "Issued";
			} 
			else if (sText == "C") {
				sheetObj.MouseToolTipText = "Credit Note";
			} 
			else if (sText == "X") {
				sheetObj.MouseToolTipText = "Cancelled";
			} 
			else {
				sheetObj.MouseToolTipText = "";
			}
			
			//마우스 모양 설정하기
			sheetObj.MousePointer = "Hand";
		} 
		else if (sName == "act_payr_cd") {
			var sText = sheetObj.CellText(Row, "act_delt_flg");
			if (sText == "Y") {
				sheetObj.MouseToolTipText = "Payer Code not available any more!";
			} 
			else {
				sheetObj.MouseToolTipText = "";
			}
			//마우스 모양 설정하기
			sheetObj.MousePointer = "Hand";
		} 
		else if (sName == "act_payr_nm") {
			var sText = sheetObj.CellText(Row, "act_delt_flg");
			if (sText == "Y") {
				sheetObj.MouseToolTipText = "Payer Code not available any more!";
			} 
			else {
				sheetObj.MouseToolTipText = "";
			}
			//마우스 모양 설정하기
			sheetObj.MousePointer = "Hand";
		} 
		else {
			sheetObj.MouseToolTipText = "";
		}
	}
	 
	/*
	 * Tool Tip(Issued, Cancelled, Credit)
	 */
	function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y ) {
		//마우스 위치를 행과 컬럼과 값 가져오기
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		var sName = sheetObj.ColSaveName(sheetObj.MouseCol);
		
		if (sName == "t_charges" || sName == "t_chr_cnt") {
			var sText = sheetObj.CellText(Row,Col);

			//풍선도움말 만들기
			sheetObj.MouseToolTipText = "Charge by Container";
			
			//마우스 모양 설정하기
			sheetObj.MousePointer = "Hand";
		} 
		else {
			sheetObj.MouseToolTipText = "";
		}
	}	 

	/*
	 * 더블클릭 팝업(4002)
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		
		openPopupWindow(sheetObj, document.form, "btn_Detail");
	}

	/*
	 * 더블클릭 팝업(4002)
	 */
	function sheet3_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		
		openPopupWindow(sheetObj, document.form, "btn_Detail");
	}
	
	// 멀티콤보 Click Event Catch
 	function office_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	
 	
 	// 멀티콤보 KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		
    		switch(sAction) {
    			case IBSEARCH:
		        	//tariff type Valid check
		        	if(ComGetObjValue(formObj.tariff_type) == "") {
		        		ComAlertFocus(formObj.tariff_type, ComGetMsg('COM12113', "Tariff Type"));
		        		return false;
		        	}
		        	//A/R I/F Valid check
		        	if(ComTrim(ComGetObjValue(formObj.ar_if)) == "") {
		        		ComAlertFocus(formObj.ar_if, ComGetMsg('COM12113', "A/R I/F"));
		        		return false;
		        	}
		        	//A/R I/F Valid check
		        	if(ComTrim(ComGetObjValue(formObj.invoice_status)) == "") {
		        		ComAlertFocus(formObj.invoice_status, ComGetMsg('COM12113', "Invoice Staus"));
		        		return false;
		        	}
		        	//OFC CHECKED
		        	if (formObj.ofc_inv_chk[0].checked ) {
		        		if(ComTrim(ComGetObjValue(formObj.office)) == "") {
			        		ComAlertFocus(formObj.office, ComGetMsg('COM12113', "Office"));
			        		return false;
			        	}
		        		var fm_dt = ComTrim(ComGetObjValue(formObj.s_issue_fm));
    					var to_dt = ComTrim(ComGetObjValue(formObj.s_issue_to));
    					
    					//null check
    					if(fm_dt == "") {
    						ComAlertFocus(formObj.s_issue_fm, ComGetMsg('DMT02002', "Issued Date"));
    						return false;
    					}
    					if(fm_dt == "") {
    						ComAlertFocus(formObj.s_issue_to, ComGetMsg('DMT02002', "Issued Date"));
    						return false;
    					}
    					//from , to 유효성 체크
    					if(ComChkPeriod(fm_dt, to_dt) == 0) {
    			  			ComShowCodeMessage('DMT01048');
    			  			ComSetFocus(formObj.s_issue_fm);
    			  			return false;
    					}
    					//from, to 2년 유효성 체크
    					var fm_dt_three_month = ComGetDateAdd(fm_dt, "M", 24);
    					if(ComChkPeriod(to_dt, fm_dt_three_month) == 0) {
    			  			ComShowCodeMessage('COM12133', "To Date", "From Date", "2 year");
    			  			ComSetFocus(formObj.s_issue_fm);
    			  			return false;
    					}
		        		var over_fm = ComTrim(ComGetObjValue(formObj.s_inv_over_fm));
    					var over_to = ComTrim(ComGetObjValue(formObj.s_inv_over_to));
    					
    					//null check
    					if(over_fm == "") {
    						ComSetObjValue(formObj.s_inv_over_fm, "0");
    					}
    					if(over_to == "") {
    						ComSetObjValue(formObj.s_inv_over_to, "0");
    					}
    					//from , to 유효성 체크
    					//if(ComChkPeriod(over_fm, over_to) == 0) {
    					var dif_day = over_to - over_fm;
    					if(dif_day < 0){
    			  			ComShowCodeMessage('DMT01031', "To Over Day", "From Over Day");
    			  			ComSetFocus(formObj.s_inv_over_fm);
    			  			return false;
    					}

			        //INV CHECKED
		        	}else if (formObj.ofc_inv_chk[1].checked ) {
		        		if(ComIsNull(formObj.s_invoice_no) && ComIsNull(formObj.s_bkg_no) && ComIsNull(formObj.s_bl_no)) {
             				ComShowCodeMessage('DMT00102', 'Invoice No. or BKG No. or B/L No.');
                 			return false;
             			}

             			var invoiceNo = ComGetObjValue(formObj.s_invoice_no);
             			if(invoiceNo != '') {
             				var arrInvoiceNo = invoiceNo.split(',');
             				for (var i=0; i<arrInvoiceNo.length; i++) {
             					//=========================================================================
             					// 2017.09.06 인도세법 변경으로 인해서 invoice no. 가 12자리까지 확장됨.
             					// 그에 따라 아래 invoice no 자리수 체크로직을 9자리에서 12자리로 변경함.
             					//=========================================================================   
    	     					// 인도지역에서 발행한 invoice no 는 12자리, 그 이외는 모두 9자리 입니다.
    	     					if (ComChkLen(arrInvoiceNo[i], 9) != 2 && ComChkLen(arrInvoiceNo[i], 12) != 2) {
    	     						ComAlertFocus(formObj.s_invoice_no, ComGetMsg('COM12175', 'Invoice No.', '9', '12'));
    	                 			return false;
    	     					}
             				}
             			}
             			var bkgNo = ComGetObjValue(formObj.s_bkg_no);
             			if(bkgNo != '') {
             				var arrBkgNo = bkgNo.split(',');
             				for(var i=0; i<arrBkgNo.length; i++) {
             					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
             						ComAlertFocus(formObj.s_bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
    	                 			return false;
             					}
             				}
             			}
             			
             			var blNo = ComGetObjValue(formObj.s_bl_no);
             			if(blNo != '') {
             				var arrBlNo = blNo.split(',');
             				for(var i=0; i<arrBlNo.length; i++) {
             					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
             						ComAlertFocus(formObj.s_bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
    	                 			return false;
             					}
             				}
             			}
             			
		        	}

    				
    				
    				break;
    		}
        }

        return true;

    }
    
	/*
	 *  초기화 
	 */		
	function initSearchControls() {
		var formObj = document.form;
		
		for(var k=0;k<comboObjects.length;k++){
			comboObjects[k].Code = "-1";
			comboObjects[k].RemoveAll();
		}
		
		formObj.s_group_by.selectedIndex = 0;

//		ComSetObjValue(formObj.s_inv_over, 		"0");
		ComSetObjValue(formObj.s_inv_over_fm, 	"0");
		ComSetObjValue(formObj.s_inv_over_to, 	"0");
		ComSetObjValue(formObj.s_issue_usr_id, 	"");		
		ComSetObjValue(formObj.s_payer_cd, 		"");	
		ComSetObjValue(formObj.s_payer_nm, 		"");
		ComSetObjValue(formObj.s_sc_no, 		"");
		ComSetObjValue(formObj.s_rfa_no, 		"");
		ComSetObjValue(formObj.s_taa_no, 		"");

		ComSetObjValue(formObj.s_payer_gubun, 		"");
		ComSetObjValue(formObj.s_dmdt_trf_cd, 		"");
		ComSetObjValue(formObj.s_dmdt_ar_if_cd, 	"");
		ComSetObjValue(formObj.s_dmdt_inv_sts_cd, 	"");
		ComSetObjValue(formObj.s_issue_ofc, 		"");
		
		formObj.ofc_inv_chk[0].checked = true;
	}		    
	
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function Minimize(nItem)
    {
        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
    	    objs.style.display = "none";
    	    //sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(23);
    	    sheetObjects[0].style.height = 400;
    	}
    	else
    	{
    	    objs.style.display = "inline";
    	    //sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(17);
    	    sheetObjects[0].style.height = 270;
    	}
    }
	/*
	 * 조회결과 정보 초기화
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
	}	
    
	/*
	 * 버튼 초기화
	 */
	function initButton() {
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnEnable("btn_Minimize");
		ComBtnDisable("btn_Cancel");
		ComBtnDisable("btn_Detail");
		ComBtnDisable("btn_DownExcel");
		
	}
	
	function searchButton() {
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnEnable("btn_Minimize");
		ComBtnEnable("btn_Detail");
		ComBtnEnable("btn_DownExcel");
	}
	
	function cancelBtnEnable() {
		ComBtnEnable("btn_Cancel");
	}
    
	// 체크박스 상태가 변경되면 Cancel 버튼 활성화 여부를 결정한다
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
    	if(Col == 1) 
    		checkCancelBtnEnable(sheetObj) ;
    }
    
    /**
     * checkCancelBtnEnable : 체크한 Row의 INV STS 값이 'I' 만 있는 경우 Cancel 버튼을 활성화한다 
     * @param sheetObj
     * */
    function checkCancelBtnEnable(sheetObj) {
    	var flag = true;
    	var checkedRows = sheetObj.FindCheckedRow("chk").split("|");
    	// 헤더의 올체크 체크박스를 Row 선택 상태에 맞추어 변경한다.
    	if(checkedRows.length - 1 == sheetObj.TotalRows) {
    		sheetObj.HeadCheck(0, 'chk') = true;
        	sheetObj.HeadCheck(1, 'chk') = true;
        	sheetObj.HeadCheck(2, 'chk') = true;
    	} else  {
    		sheetObj.HeadCheck(0, 'chk') = false;
    		sheetObj.HeadCheck(1, 'chk') = false;
    		sheetObj.HeadCheck(2, 'chk') = false;
    	}
    		
    	// 체크된 행이 없으면 Cancel Btn 비활성화
    	if(checkedRows.length - 1 == 0){
    		flag = false;
    	} else {
    		for(var i=0; i<checkedRows.length - 1; i++) {
        		var sts_cd = sheetObj.CellValue(checkedRows[i], 'dmdt_inv_sts_cd');
        		if (sts_cd != 'I') {
        			flag = false;
        			break;
        		}
        	}
    	}    	
    	if (flag) ComBtnEnable("btn_Cancel");
    	else ComBtnDisable("btn_Cancel");
    }

    
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initControl() {
		//조회필드 초기화
		initSearchControls();
		//조회결과 정보 초기화
		initResultControls();
		//Combo 초기화
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		//DATA 초기화
		var formObj = document.form;
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST);		// Tariff Type
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[2], SEARCH15);		// INV STS
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[3], SEARCHLIST02);	// Issue OFC

		initButton();
	}