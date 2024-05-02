/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EES_DOD_0016.js
*@FileTitle : DOD Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-11
*@LastModifier : Hong Seong Pil
*@LastVersion : 1.0
* 2016-05-11 Hong Seong Pil
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class EES_DOD_0016 : 예)DOD Collection Audit 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_DOD_0016() {
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
	    this.initCombo				= initCombo;
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수 
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

	
	var ROWMARK = "|";		// port code 
	var FIELDMARK = ",";	// port code
	
	var timer = null;
	var sheetNum = null;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		 /******************************************************/
		 var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				init_form();
				break;				
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_detail":
				goDetail();
			    break;
            case "btns_calendarto":
            	var cal = new ComCalendarFromTo();
    			cal.select(formObject.froms, formObject.tos, 'yyyy-MM-dd');
            	break;
            case "btns_multisearch":
            	var returntitle = '';
				if(ComGetObjValue(formObj.sch_flg) == 'SC')
					returntitle = 'S/C No.';
				else
					returntitle = 'RFA No.';
					
				var param = "?returnval=sc_rfa_no" + "&returntitle=" + returntitle;
  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
            	break;  			
            case "btns_ctrt_ofc":
				ComOpenPopup('COM_ENS_071.do', 770, 470, "getCtrtOfcCd", "1,0,1,1,1,1,1", true);
				break;	
            case "btns_customer":
				ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
			    break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }

	 
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		formObj = document.form;
		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}
		
 		//html컨트롤 이벤트초기화
 		initControl();
 		init_form();
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
  		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
  		axon_event.addListenerFormat('keypress','obj_keypress', document.form);			//- 키보드 입력할때
		axon_event.addListenerForm('change' , 'obj_change' , document.form );
		axon_event.addListener('blur', 'obj_blur', 'cust_cd');
		axon_event.addListener('blur', 'obj_deactivate', 'froms'); //- form OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListener('blur', 'obj_deactivate', 'tos'); //- form OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerForm('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
  	}
  	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj) {
		var cnt = 0;
		var sheetNo = sheetObj.id;

		switch(sheetNo) {

			case "sheet1":	  //IBSheet1 init
				with (sheetObj) {
					// 높이 설정
	                style.height = 370;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(2, 1, 4, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(21, 3, 0, false);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                //InitHeadMode(false, true, true, true, false,false) ;
	                InitHeadMode(true, false, true, true, false, false);
	                
					var HeadTitle1 = "|S/C No.|RFA No.|Customer|Customer" +
							         "|Contract\nOffice|DOD\nOffice|Location|TP/SZ|Cur." +
							         "|General Tariff|General Tariff|Special Tariff|Special Tariff|Adjust Amount|Adjust Amount|Invoice Amount\n(A/R I/F)|Invoice Amount\n(A/R I/F)|Pending Amount|Pending Amount|";
					var HeadTitle2 = "|S/C No.|RFA No.|Code|Name" +
							         "|Contract\nOffice|DOD\nOffice|Location|TP/SZ|Cur." +
							         "|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|";
					
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDummyCheck, 			 40,  daCenter, true,     "chk");
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"sc_no",			    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	true,	"rfa_no",			    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		60,	daCenter,	false,	"cust_cd",			    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		200,	daLeft,		false,	"cust_nm",			    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"req_ofc_cd",		    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"dod_ofc_cd",	    	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"loc_cd",			    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"cntr_tpsz_cd",	    	false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,	daCenter,	true,	"curr_cd",			    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"gen_trf_cntr",		    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"gen_trf_amt",		    false,          "",       dfFloat,    2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"spcl_trf_cntr",	    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"spcl_trf_amt",		    false,          "",       dfFloat,    2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"adjust_cntr",		    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"adjust_amt",		    false,          "",       dfFloat,    2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"invoice_cntr",		    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"invoice_amt",		    false,          "",       dfFloat,    2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"pending_cntr",		    false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,	80,	daRight,	false,	"pending_amt",		    false,          "",       dfFloat,    2,    false,       true);
					InitDataProperty(0, cnt++, dtStatus,	0,		daCenter,	false,	"ibflag",			    false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);

					ColHidden('ibflag')= true;

				}
				break;
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
	    		sheetObj.RemoveAll();
    			sheetObj.WaitImageVisible=false;
    			ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;

    			sheetObj.DoSearch("EES_DOD_0016GS.do", FormQueryString(formObj));
	       		ComOpenWait(false);

				break;
				
			case IBDOWNEXCEL:  //EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}

	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
	function init_form() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		document.getElementById("period").value = "D";
		document.getElementById("froms").setAttribute("dataformat", "ymd");
		document.getElementById("tos").setAttribute("dataformat", "ymd");
		document.getElementById("froms").setAttribute("maxLength", 8);
		document.getElementById("tos").setAttribute("maxLength", 8);
		document.getElementById("btns_calendarto").style.display = "";
		document.getElementById("froms").value = "";
		document.getElementById("tos").value = "";
		document.getElementById("from").value = "";
		document.getElementById("to").value = "";
		
		document.form.tpsz.value = "A";
		document.form.ar_if.value = "A";
		
		document.form.sch_flg[1].checked = true;
		document.form.sc_rfa_no.value = "";
		document.form.ctrt_ofc.value = "";
		document.form.curr_cd[0].checked = true;
		
		document.form.cust_flg[0].checked = true;
		comboObjects[0].Enable = false; 
    	comboObjects[0].Index="-1";
		document.form.cust_type.value = "";
    	document.form.cust_cd.value = "";
    	document.form.cust_nm.value = "";
    	
    	document.form.ofc_flg[0].checked = true;
    	document.form.chk_sub_ofc.checked = false;
    	document.form.rtn_loc_cd.value = "";
    	ofc_flg_click();
		
	}

	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "period":
				if (obj.value == "M") {
					document.getElementById("froms").setAttribute("dataformat", "ym");
					document.getElementById("tos").setAttribute("dataformat", "ym");
					document.getElementById("froms").setAttribute("maxLength", 6);
					document.getElementById("tos").setAttribute("maxLength", 6);
					document.getElementById("btns_calendarto").style.display = "none";
					document.form.froms.value = "";
					document.form.tos.value = "";
					document.form.from.value = "";
					document.form.to.value = "";
				} else if (obj.value == "W") {
					document.getElementById("froms").setAttribute("dataformat", "yw");
					document.getElementById("tos").setAttribute("dataformat", "yw");
					document.getElementById("froms").setAttribute("maxLength", 6);
					document.getElementById("tos").setAttribute("maxLength", 6);
					document.getElementById("btns_calendarto").style.display = "none";
					document.form.froms.value = "";
					document.form.tos.value = "";
					document.form.from.value = "";
					document.form.to.value = "";
				} else {
					document.getElementById("froms").setAttribute("dataformat", "ymd");
					document.getElementById("tos").setAttribute("dataformat", "ymd");
					document.getElementById("froms").setAttribute("maxLength", 8);
					document.getElementById("tos").setAttribute("maxLength", 8);
					document.getElementById("btns_calendarto").style.display = "";
					document.form.froms.value = "";
					document.form.tos.value = "";
					document.form.from.value = "";
					document.form.to.value = "";
				}
				document.form.froms.focus();
			break;
		}		
	}
	
	function obj_keypress(){
		switch (event.srcElement.dataformat) {
			case "ymd": case "ym": case "yw":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "engup":
		    	// 영대문자만
         		ComKeyOnlyAlphabet('upper');
		        break;
    	 	case "engnum":
		    	// 영대문자+숫자 
         		ComKeyOnlyAlphabet('uppernum');
		        break;
		}
	}
	
	function form_keyup() {
		var obj = null;
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyValue != 13) {
			ComKeyEnter('lengthnextfocus');
		} else {
			obj_deactivate();
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		formObj = document.form;
		var result = true ;
		
		switch(sAction) {
			case IBSEARCH:
				if(formObj.froms.value == ''){
					ComShowMessage(ComGetMsg("COM130201", "TRO Date From"));
					formObj.froms.focus();
					return false;
				}
				
				if(formObj.tos.value == ''){
					ComShowMessage(ComGetMsg("COM130201", "TRO Date To"));
					formObj.tos.focus();
					return false;
				}
				
				if(formObj.sc_rfa_no.value == '' && formObj.cust_cd.value == ''){
					ComShowMessage(ComGetMsg("COM130201", "S/C No. or RFA No. or Customer Code!"));
					formObj.sc_rfa_no.focus();
					return false;
				}
				
			break;
		}
		
		return result;
	}
	
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  
		
			case "cust_type": // CUSTOMER TYPE
	            with (comboObj) { 
	                MultiSelect = true; 
	//                UseAutoComplete = true; 
	                SetColAlign("left|left");   
	                SetColWidth("60|300");
	                DropHeight = 160;
	            }
	            comboObj.InsertItem( 0 , "All"  , "A" );
	            comboObj.InsertItem( 1 , "SHPR" , "S" );
	            comboObj.InsertItem( 2 , "CNEE" , "C" );
	            comboObj.InsertItem( 3 , "NTFY" , "N" );
	            comboObj.Code2 = "A,S,C,N";
            break;
		}
	}
	
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_deactivate() {

		var f = document.getElementById("froms");
		var t = document.getElementById("tos");
		sVal1 = f.value.replace(/\/|\-|\./g, "");
		sVal2 = t.value.replace(/\/|\-|\./g, "");

		switch (event.srcElement.name) {
		case "froms":
			if (ComChkObjValid(event.srcElement, false)) {

				if (f.getAttribute("dataformat") == "ym") {
					if (sVal1 != "" && sVal2 != "") {
						var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
						var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
						if (flag < 1) {
							//	ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								t.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
						document.getElementById("from").value = sVal1 + "01";
						document.getElementById("to").value = sVal2 + day;
					}

				} else if (f.getAttribute("dataformat") == "ymd") {
					if (sVal1 != "" && sVal2 != "") {
						var flag = ComChkPeriod(sVal1, sVal2);
						if (flag < 1) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;

						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								t.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
						document.getElementById("from").value = sVal1;
						document.getElementById("to").value = sVal2;
					}

					switch (event.srcElement.name) {
					case "froms":
						/*if (f.value != "" && t.value == "") {
							t.value = ComGetDateAdd(f.value, "D", 6, "");
							t.focus();
						}*/
						break;
					}
				} else { // 주별로 조회
					if (sVal1 != "" && sVal2 != "") {
						if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								t.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
						document.getElementById("from").value = sVal1;
						document.getElementById("to").value = sVal2;
					}
				}

			} else {
				if (f.getAttribute("dataformat") == "ym") {
					if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {

						event.srcElement.value = "";
						enterSwitch = false;
						event.srcElement.focus();
						event.srcElement.select();
						return false;
					}
				} else if (f.getAttribute("dataformat") == "ymd") {

					if (sVal1.length > 0 && !ComIsDate(sVal1) && event.srcElement.name == 'froms') {
						event.srcElement.value = "";
						event.srcElement.focus();
						event.srcElement.select();
						enterSwitch = false;
						return false;
					}

				} else { // 주별로 조회

					if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {
						event.srcElement.value = "";
						event.srcElement.focus();
						event.srcElement.select();
						enterSwitch = false;

						return false;
					}
				}
			}

			break;
		case "tos":
			if (ComChkObjValid(event.srcElement, false)) {

				if (t.getAttribute("dataformat") == "ym") {

					var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));

					if (sVal1 != "" && sVal2 != "") {
						var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
						if (flag < 1) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								event.srcElement.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
					}

					document.getElementById("from").value = sVal1 + "01";
					document.getElementById("to").value = sVal2 + day;
				} else if (t.getAttribute("dataformat") == "ymd") {
					if (sVal1 != "" && sVal2 != "") {
						var flag = ComChkPeriod(sVal1, sVal2);
						if (flag < 1) {
							if (event.srcElement.name == "tos") {
								enterSwitch = false;
								event.srcElement.value = "";
								t.focus();
								t.select();
								return false;
							}
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								event.srcElement.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
					}

					document.getElementById("from").value = sVal1;
					document.getElementById("to").value = sVal2;

					switch (event.srcElement.name) {
					case "froms":
						if (f.value != "" && t.value == "") {
							t.value = ComGetDateAdd(f.value, "D", 6, "");

						}
						break;
					}
				} else { // 주별로 조회
					if (sVal1 != "" && sVal2 != "") {
						if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								event.srcElement.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
					}
					document.getElementById("from").value = sVal1;
					document.getElementById("to").value = sVal2;
				}
				enterSwitch = true;
			} else {
				if (t.getAttribute("dataformat") == "ym") {
					if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					}
				} else if (t.getAttribute("dataformat") == "ymd") {
					if (sVal2.length > 0 && !ComIsDate(sVal2)) {
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					}

				} else { // 주별로 조회
					if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					}
				}
			}
			break;
		}
		return true;
	}
	
	function chkToDateWeekBlur() {
		var period = document.form.period.value;
		var toDate = document.form.tos.value;
		var frDate = document.form.froms.value;

		var toYearDate = toDate.substring(0, 4);
		var frYearDate = frDate.substring(0, 4);
		var toMonthDate = toDate.substring(5, 7);
		var frMonthDate = frDate.substring(5, 7);
		var frDayDate = "";
		var toDayDate = "";

		if (frDate.length > 7) {
			frDayDate = frDate.substring(8, 10);
			toDayDate = toDate.substring(8, 10);

		} else {
			frDayDate = "01";
			toDayDate = lastDay(toYearDate, toMonthDate);
		}

		var frDateFull = new Date(frYearDate, frMonthDate - 1, frDayDate);
		var toDateFull = new Date(toYearDate, toMonthDate - 1, toDayDate);
		var getDiffTime = toDateFull.getTime() - frDateFull.getTime();
		var retDate = Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
		var retMonth = ((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
		var retWeek = Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
		var week = "";
		var fromTo = 52;
		if (period == "M") {
		} else if (period == "W") {
			if (frYearDate == toYearDate) {
				week = eval(toMonthDate) - eval(frMonthDate) + 1;
			} else {
				betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
				if ((eval(toYearDate) - eval(frYearDate)) == 1) { //1년 차이일때
					week = betwMonth;
				} else {
					week = (eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
				}
			}
		} else if (period == "D") {
		}
	}
	
	function obj_activate() {
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
	}
	
	function sheet1_OnMouseMove(){
	}

	function lastDay(y, m) {
		var d, d2, s = "";
		d = new Date();
		d2 = new Date(y, m, "");
		s = d2.getDate();
		return (s);
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
    
	/*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCtrtOfcCd(aryPopupData) {
    	document.form.ctrt_ofc.value = aryPopupData[0][3];
    }
    
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value = aryPopupData[0][3];
    	document.form.cust_nm.value = aryPopupData[0][4];
    }
    
    function cust_click(){
    	//doEnableCondObj(event.srcElement.value);
    	var formObj = document.form;
   		if (formObj.cust_flg[0].checked ) {
    		comboObjects[0].Enable = false; 
        	comboObjects[0].Index="-1";
    	}else if (formObj.cust_flg[1].checked ) {
   			comboObjects[0].Enable = true; 
   	    	comboObjects[0].Index="0";
    	}
    	
    }
    
  	//멀티콤보 클릭 이벤트
    function cust_type_OnCheckClick(comboObj, index, code) {
        if(index==0) {
            //checked
            var bChk = comboObj.CheckIndex(index);
            for(var i = 1 ; i < comboObj.GetCount() ; i++) {
                comboObj.CheckIndex(i) = bChk;
            }
        } else {
            comboObj.CheckIndex(0) = false;
        }
    }    
    
	// Office Radio Button 클릭 이벤트 처리
	function ofc_flg_click() {
		var formObj = document.form;
		var ofcFlg = ComGetObjValue(formObj.ofc_flg);
		var comboObj = comboObjects[1];
		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			// RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.(SELHO는 All)
			var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
	   		if(usrRhqOfcCd == 'SELHO')
	   			usrRhqOfcCd = "All";
	   		
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
		} else {
			// Office
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND02);
			ComEnableObject(formObj.chk_sub_ofc, true);
		}
	}
	
	// IBCombo 데이터 조회 및 세팅
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
	   	 
		formObj.f_cmd.value = formCmd;
		var sXml = sheetObj.GetSearchXml("DODCommonFinderGS.do", FormQueryString(formObj));
		var sXml2 = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		switch(formCmd) {
			case COMMAND01:	// RHQ
				with (comboObj) {
					RemoveAll();
					MultiSelect = false;
					SetColWidth("45");
					ValidChar(2);	// 영대문자만 사용
				}
				var data = ComGetEtcData(sXml, "office");
				if (data != undefined && data != '') {
					var comboItems = data.split("|");
					comboObj.InsertItem(0, "All", "All");
					for (var i = 0 ; i < comboItems.length ; i++) {
						comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
					}
				}
				break;
			case COMMAND02: // Office
				with (comboObj) { 
					RemoveAll();
					MultiSelect = true;
					SetColWidth("95");
					ValidChar(2, 2); // 영대문자, 특수문자만 가능
				}
				var data = ComGetEtcData(sXml, "OFC_CD");
				if (data != undefined && data != '') {
					var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					var idx = 0;
					//로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
					if(data.indexOf(usrOfcCd) == -1) {
						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
						idx = 1;
					}
					var comboItems = data.split("|");
					for (var i=0 ; i < comboItems.length ; i++) {
						comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
					}
					// 로그인 User Office를 Default로 설정
					comboObj.Code = usrOfcCd;
				}
				break;
	   	 	case COMMAND03:	// Incl. Sub Office
	   	 		var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	   	 		if (subOfcCds != undefined && subOfcCds != '') {
	   	 			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
	   	 			if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
	   	 				subOfcCds = usrOfcCd + ',' + subOfcCds;
	   	 				comboObj.Code = subOfcCds;
	   	 			}
	   	 		break;
	   	 	case SEARCH20: // Customer Name 조회	
	     		var custCd = ComGetEtcData(sXml2, "PAYER_CODE");
	            var custNm = ComGetEtcData(sXml2, "PAYER_NM");
	            
	            if(custNm == null || custNm == "" || custNm == undefined) {
	            	ComSetObjValue(form.s_cust_gubun, "");
	                ComSetObjValue(form.cust_cd, "");
	                ComSetObjValue(form.cust_nm, "");
	                
	                ComShowCodeMessage("DOD20001", "Customer");
	                ComSetFocus(formObj.cust_cd);
	            } else {
	            	ComSetObjValue(form.cust_cd, custCd);
	                ComSetObjValue(form.cust_nm, custNm);
	            }
	            break;
	   	 		
		}
	}
	function doInclSubOfc() {
		var formObj = document.form;
		var comboObj = comboObjects[1]; 
		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if( ComIsEmpty(comboObj.Code) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			formObj.ofc_cd.value = ComGetObjValue(comboObj);
			formObj.tmp_ofc_cd.value = ComGetObjValue(comboObj);
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND03);
		} else {
			ComSetObjValue(comboObj, formObj.tmp_ofc_cd.value);
		}
	}
	
	function goDetail(){
		var sheetObj = sheetObjects[0];
   		var formObj = document.form;
   		var sUrl = '';
   		var iWidth	= '';
   		var iHeight = '';
   		
   		with(sheetObj) {
			if(CheckedRows("chk") == 0) {
     			ComShowCodeMessage('COM12114', '');
     			return;
     		}
			var chkCnt = 0;
     		var chkRows = FindCheckedRow("chk").split("|");
     		
     		var item_list = '';
     		var period = formObj.period.value;
     		var from = formObj.from.value;
     		var to = formObj.to.value;
     		var ar_if = formObj.ar_if.value;
     		
     		var cust_flg = "";
     		for(var i=0;i<formObj.cust_flg.length;i++){
     			if(formObj.cust_flg[i].checked == true){
     				cust_flg = formObj.cust_flg[i].value;
     			}
     		}
     		var cust_type = formObj.cust_type.value;
     		var curr_cd = "";
     		for(var i=0;i<formObj.curr_cd.length;i++){
     			if(formObj.curr_cd[i].checked == true){
     				curr_cd = formObj.curr_cd[i].value;
     			}
     		}
     		
     		for(var i=0; i < chkRows.length-1; i++) {
     			
     			if(CellValue(chkRows[i], "sc_no") != null && CellValue(chkRows[i], "sc_no") != ""){
     				item_list += "S|" + CellValue(chkRows[i], "sc_no") + "|";
     			}
     			if(CellValue(chkRows[i], "rfa_no") != null && CellValue(chkRows[i], "rfa_no") != ""){
     				item_list += "R|" + CellValue(chkRows[i], "rfa_no") + "|";
     			}
     			item_list += CellValue(chkRows[i], "dod_ofc_cd")+"|" ;
     			item_list += CellValue(chkRows[i], "loc_cd")+"|" ; 
     			item_list += CellValue(chkRows[i], "cntr_tpsz_cd")+"|" ;
     			item_list += CellValue(chkRows[i], "req_ofc_cd")+"|" ;
     			item_list += CellValue(chkRows[i], "cust_cd") +",";
     		}
     		sUrl	= 'EES_DOD_0017.do';
      		iWidth	= '1030';
      		iHeight	= '535';
      		var sScroll  = 'no';
       		var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
       		var leftpos = (screen.width - iWidth) / 2;
    		if (leftpos < 0)
    			leftpos = 0;
    		var toppos = (screen.height - iHeight) / 2;
    		if (toppos < 0)
    			toppos = 0;
    		var sFeatures =	"scroll:"+sScroll+";status:no;help:no;dialogWidth:" + iWidth
    						+ "px;dialogHeight:" + iHeight + "px;dialogLeft:"
    						+ leftpos + ";dialogTop:" + toppos;
       		
       		var args = new Array();
       		args["item_list"] = item_list;
       		args["period"] = period;
       		args["from"] = from;
       		args["to"] = to;
       		args["ar_if"] = ar_if;
       		args["cust_flg"] = cust_flg;
       		args["cust_type"] = cust_type;
    		window.showModalDialog(sUrl, args,sFeatures);
   		}
	}

	function obj_blur(){
        //입력Validation 확인하기 + 마스크구분자 넣기
    	var obj = event.srcElement;
        var objName = obj.name;
        
        if(objName == 'cust_cd') {
        	var formObj = document.form;
        	var custCd = ComGetObjValue(obj);
        	var custLen = ComGetLenByByte(custCd);

            if(custLen == 0) {
	            ComSetObjValue(formObj.cust_nm, "");
            	return;
            }

            if(custLen > 2) {
    			//첫 2자리가 영문자이면 CUSTOMER 조회
    			if(ComIsAlphabet(custCd.substring(0,2))) {
    				ComSetObjValue(formObj.s_cust_gubun, "2");
    	            ComSetObjValue(formObj.s_cust_cd, custCd);
    	            
    	            doActionIBCombo(sheetObjects[0], formObj, null, SEARCH20);
    	            
    			//아니면 VENDOR 조회
    			} else {
    				ComShowCodeMessage("DOD20001", "Customer");
    				ComSetObjValue(formObj.s_cust_gubun, "");
    	            ComSetObjValue(formObj.cust_cd, "");
    	            ComSetObjValue(formObj.cust_nm, "");
    	            ComSetFocus(formObj.cust_cd);
    				return;
    			}
    		} else {
    			ComShowCodeMessage("DOD20001", "Customer");
    			ComSetObjValue(formObj.s_cust_gubun, "");
                ComSetObjValue(formObj.cust_cd, "");
                ComSetObjValue(formObj.cust_nm, "");
                ComSetFocus(formObj.cust_cd);
    			return;
    		}
    	}
	}
