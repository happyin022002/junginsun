/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0001.js
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
* 1.0 최초 생성
=========================================================*/
	/**
	 * @extends Bkg
	 * @class ESD_EAS_0001 : 예)COD vs. TPB 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0001() {
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

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){

		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH, "btn_retrieve"  );
					break;

				case "btn_new":
					fn_reset();
					break;
						
				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
					
				case "port":
					if ( formObject.btns_radio_ofc[0].checked == true ) {
						formObject.port.value="";
					}else {
						formObject.port.disabled = true;
					}
					break;
				
				case "fmMonth":
					if ( formObject.btns_radio_date[0].checked == true ) {
						formObject.fmMonth.value="";
					}else {
						formObject.fmMonth.disabled = true;
					}
					break;
					
				case "toMonth":
					if ( formObject.btns_radio_date[0].checked == true ) {
						formObject.toMonth.value="";
					}else {
						formObject.toMonth.disabled = true;
					}
					break;
				
				case "office":
					if ( formObject.btns_radio_ofc[1].checked == true ) {
						formObject.office.value="";
					}else {
						formObject.office.disabled = true;
					}
					break;
					
				case "vvd":
					if ( formObject.btns_radio_date[1].checked == true ) {
						formObject.vvd.value="";
					}else {
						formObject.vvd.disabled = true;
					}
					break;
			
				case "btn_loc_cd":	//Location 조회 팝업
					//Rehandling port 라디오 버튼이 체크가 되어있으면 활성화를 하자.

					if (formObject.btns_radio_ofc[0].checked == true) {
						var cnt_cd = "";
						var loc_cd = formObject.port.value;
				    	var sUrl = "/hanjin/ESD_EAS_0910.do";
						var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
						if(rVal){
							formObject.port.value = rVal;
							//loc_cd_onchange();
						}		
					}
					break;
					
       	       case "btn_ofc_cd" :
       	    	   
       	    	    //Rehandling Office 라디오 버튼이 체크가 되어있으면 활성화를 하자.
       	    	    if (formObject.btns_radio_ofc[1].checked == true) {
						var cnt_cd = "";
						var ofc_cd = formObject.office.value;
						if (ofc_cd == "") {
							ofc_cd = formObject.login_ofc_cd.value;
						}
				    	var sUrl = "/hanjin/ESD_EAS_0911.do?ofc_cd="+ofc_cd+"&param_nm=office";
						var rVal = ComOpenPopupWithTarget(sUrl, 425, 440, "", "0,0", true);
       	    	    }
         	        break;		
				case "m_cntr_no":
				case "m_vvd":
 					doProcessPopup(srcName);   
 					break;
			} // end switch

		} catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("COM12111");
			} else {
				ComShowMessage(e);
			}
		}
	}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
       initSheet(sheetObjects[i],i+1);
       //khlee-마지막 환경 설정 함수 추가
       ComEndConfigSheet(sheetObjects[i]);
   }
	//html컨트롤 이벤트초기화
	initControl();
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, srcName) {

	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:

			if(!validateForm(sheetObj, formObj, IBSEARCH	, "btn_retrieve" ))	return false;

			document.form.port.value = document.form.port.value.toUpperCase();

			sheetObjects[0].RemoveAll();
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_EAS_0001GS.do", EasFrmQryString(formObj));
			break;
					
		case IBDOWNEXCEL: //ExcelDownload
		    sheetObj.Down2Excel(0, false, false, true, "", "", false, false, "", false, "cntr_hndl_knd_cd");
			break;

	}
}


/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
	 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	function engnum_keypress() {
	//    ComKeyOnlyAlphabet('uppernum');
	}

	/**
	 * BKG Creation manual <br>
	 **/
	function manual_click() {
	    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
	//    form.boo_bkg_no.readOnly =!form.manual.checked;
	}

	/**
	 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
	 **/
	function bkgno_keyup() {
	    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value = "";
	    else
		form.boo_bl_no.value = form.hdn_boo_bl_no.value;
		*/
	}

	/**
	 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_blur(){
	    //입력Validation 확인하기
	//    return ComChkObjValid(event.srcElement);
	}

	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
	 **/
	function obj_focus(){
	//    ComClearSeparator(event.srcElement);
	}

	/**
	 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
	 **/
	function obj_keypress(){
	//    ComKeyOnlyNumber(event.srcElement);
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- end



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
				style.height = GetSheetHeight(15) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				// 4341.11.20 Investigation 추가
				var HeadTitle1 = "Seq.|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TOR Data|TPB Data|TPB Data|TPB Data|TPB Data|BL Data|BL Data|Investigation|Investigation|";
				var HeadTitle2 = "Seq.|Office|Port|VVD(O)|Call IND Seq|Lane|ATD|CNTR No.|RESPB CNTR No.|SZTP|POL|OPR Code|Precell|Position|Reason|Party|File Attached|TPB No.|Amount\n(USD)|TPB OFC|3rd Party|BKG NBR|Amount\n(USD)|Investigation|Investigation|";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
                 

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,        40,   daCenter,  true,    "seq",      	false,          "",      dfNone,      0,     false,       false,           8);
				InitDataProperty(0, cnt++ , dtData,       70,   daCenter,  true,    "ofc_cd",    	false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "port_cd",      false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "vvd",      	false,          "",      dfNone,      0,     false,       false,           9);
				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "clpt_ind_seq", false,          "",      dfNone,      0,     false,       false,           3);
				
				InitDataProperty(0, cnt++ , dtData,       40,   daCenter,  true,    "lane_cd",      false,          "",      dfNone,      0,     false,       false,           9);
				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "act_dep_dt",   false,          "",      dfNone,      0,     false,       false,           10);
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "cntr_no",      false,          "",      dfNone,      0,     false,       false,           10);
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "respb_cntr_no",false,          "",      dfNone,      0,     false,       false,           10);
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "sztp", 		false,          "",      dfNone,      0,     false,       false,           13);
				
				InitDataProperty(0, cnt++ , dtData,       50,   daCenter,  true,    "pol",     		false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "opr_cd",       false,          "",      dfNone,      0,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "precell", 		false,          "",      dfNone,      0,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "position",     false,          "",      dfNone,      0,     false,       false,           5);
				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "shift_rsn",    false,          "",      dfNone,      0,     false,       false,           2);
				
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "party",       	false,          "",      dfNone,      0,     false,       false,           8);
				InitDataProperty(0, cnt++ , dtPopupFormat, 120, daCenter,  true,	"file_atch",	false,			"",      dfNone,	  0,	 true,		  false,		   12);
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "tpb_no",   	false,          "",      dfNone,      0,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtData,       80,   daRight,   true,    "tpb_amt_usd",  false,          "",      dfFloat,     2,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "tpb_ofc",   	false,          "",      dfNone,      0,     false,       false,           14);
				
				InitDataProperty(0, cnt++ , dtData,       80,   daCenter,  true,    "tpb_pty_3rd",  false,          "",      dfNone,      0,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtData,       90,   daCenter,  true,    "bkg_no",   	false,          "",      dfNone,      0,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtData,       90,   daRight,   true,    "bl_amt",   	false,          "",      dfFloat,     2,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    "rmk_ctnt_yn", 	false,          "",      dfNone,      0,     false,       false,           14);
				InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  true,	"rmk_ctnt",    	false,		    "",   	 dfNone,   	  0,	 false,	   	  false);              
				InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  true,	"cntr_hndl_knd_cd",false,	    "",	   	 dfNone,   	  0,	 false,	   	  false);               
				
				ColHidden('ibflag') = true;
			}
			break;

	}
}


/**
 * Investigation Remark 등록 수정 팝업. //4341.11.24
 * 
 */
function sheet1_OnDblClick(sheetObj, row, col ){

	//Investigation
    if ((col == 23) && (sheetObj.CellValue(row,'rmk_ctnt_yn') == "Y")) {
    	var theURL = "ESD_EAS_0901.do?bkg_no=" + sheetObj.CellValue( row, 'bkg_no') + "&eas_expn_tp_cd=RH";
    	var winName = "ESD_EAS_0901";
    	var features = "width=700,height=365,toolbar=no,location=no,status=yes,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
    	
    	ComOpenWindow(theURL,winName,features);
    	
    //file Attached 	
    } else if( (sheetObj.ColSaveName(col) == "file_atch") && (sheetObj.CellValue ( row, col ) != '') ) { 
		fileUploadPopUp( sheetObj, row);
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, srcName){
    var formObject = document.form;	
	var sheetObject1 = sheetObjects[0];

	switch(sAction) {
		case IBSEARCH:
			switch(srcName){
				case "btn_retrieve":
					if ( formObject.btns_radio_date[0].checked == true && formObject.btns_radio_ofc[0].checked == true) {
						var check_fmmonth 	= formObject.fmMonth.value ;
						var check_tomonth 	= formObject.toMonth.value ;
					
						if(check_fmmonth == '' || check_fmmonth == null || check_fmmonth == 'YYYYMMDD'
							|| check_tomonth == '' || check_tomonth == null || check_tomonth == 'YYYYMMDD') 
						{
							ComShowCodeMessage('EAS90007');
							fn_reset();
							return false;
						}
						formObject.office.value = "";
						formObject.vvd.value = "";
					} else if( formObject.btns_radio_date[1].checked == true && formObject.btns_radio_ofc[0].checked == true) {
						var check_vvd = formObject.vvd.value ;
						if(check_vvd == '' || check_vvd == null) 
						{
							ComShowCodeMessage("EAS90008");
							fn_reset();
							return false;
						}
						formObject.office.value = "";
						formObject.fmMonth.value = "YYYYMMDD";
						formObject.toMonth.value = "YYYYMMDD";					
					} else if( formObject.btns_radio_date[0].checked == true && formObject.btns_radio_ofc[1].checked == true) {
						var check_fmmonth 	= formObject.fmMonth.value ;
						var check_tomonth 	= formObject.toMonth.value ;
						if(check_fmmonth == '' || check_fmmonth == null || check_fmmonth == 'YYYYMMDD'
							|| check_tomonth == '' || check_tomonth == null || check_tomonth == 'YYYYMMDD') 
						{
							ComShowCodeMessage("EAS90007");
							fn_reset();
							return false;
						}
						formObject.port.value = "";	
						formObject.vvd.value = "";
					} else if( formObject.btns_radio_date[1].checked == true && formObject.btns_radio_ofc[1].checked == true) {
						var check_vvd = formObject.vvd.value ;
						if(check_vvd == '' || check_vvd == null) 
						{	
							ComShowCodeMessage("EAS90008");
							fn_reset();
							return false;
						}
						formObject.port.value = "";	
						formObject.fmMonth.value = "YYYYMMDD";
						formObject.toMonth.value = "YYYYMMDD";					
					}
					
					// 조건+날짜 일시 날짜는 1년 , 조건없이 날짜로만 조회할시 3개월 
					if ( formObject.btns_radio_date[0].checked == true) {
						
						var check_fmmonth 	= formObject.fmMonth.value ;
						var check_tomonth 	= formObject.toMonth.value ;
						
						//1. 날짜 형식 체크 
						if (check_fmmonth.substring(4,6) > 12) {
							ComShowMessage("The date you input is out of the range.");
							document.form.fmMonth.value = "";
							return false;
						} 
						if (check_fmmonth.substring(4,6) == 00) {
							ComShowMessage("The date you input is out of the range.");
							document.form.fmMonth.value = "";
							return false;
						} 
						if (check_tomonth.substring(4,6) > 12) {
							ComShowMessage("The date you input is out of the range.");
							document.form.toMonth.value = "";
							return false;
						} 
						if (check_tomonth.substring(4,6) == 00) {
							ComShowMessage("The date you input is out of the range.");
							document.form.toMonth.value = "";
							return false;
						} 
						
						// 년 월 을 변수로 받는다.
						var fm_yyyy = Number(check_fmmonth.substring(0,4));
						var to_yyyy = Number(check_tomonth.substring(0,4));
						var fm_mm   = Number(check_fmmonth.substring(4,6));
						var to_mm   = Number(check_tomonth.substring(4,6));
						
						// 12진수로 변환
						var fmyyyymm12 =(fm_yyyy*12)+fm_mm;
						var toyyyymm12 =(to_yyyy*12)+to_mm;
						var between_fm_to = toyyyymm12-fmyyyymm12;
						if (between_fm_to < 0) {
							ComShowMessage("The date you input is out of the range.");
							return false;
						}
						
						// 2. 검색기간 체크
						// 검색조건 = 날짜 + 그외 = 1년
						if ((formObject.btns_radio_ofc[0].checked == true && formObject.port.value != "") ||
								(formObject.btns_radio_ofc[1].checked == true && formObject.office.value != "") ||
									(formObject.btns_radio_date[1].checked == true && formObject.vvd.value != "")) {
							// from + 1년 처리 
							if (between_fm_to > 11) {
//								if (String(fm_mm).length == 1) {
//									fm_mm = "0"+fm_mm; 
//								}
//								
//								formObject.toMonth.value = String(fm_yyyy+1)+String(fm_mm);
								formObject.toMonth.value = ComGetDateAdd(check_fmmonth, "Y", 1, "");
							} 
							
						// 검색조건 = 날짜만 = 3개월
						} else {
							
//							ComChkPeriod
//							-1 : 인자가 올바르지 않아 에러 발생
//							0 : fromDate > toDate
//							1 : fromDate < toDate
//							2 : fromDate = toDate
//							if( 0 == ComChkPeriod ( check_tomonth ,ComGetDateAdd(check_fmmonth, "D", 90)) ) {
//								alert('90 over');
//							} else {
//								alert('ComChkPeriod:'+ComChkPeriod ( check_tomonth ,ComGetDateAdd(check_fmmonth, "D", 90)));
//							}
							
							
							// +3개월 처리
							if (between_fm_to > 2) {
								
//								var new_to_month =  Number(fm_mm+2);
//								if (new_to_month > 12) {
//									fm_yyyy = fm_yyyy + 1 ;
//									new_to_month = new_to_month - 12;
//								}
//								
//								if (String(new_to_month).length == 1) {
//									new_to_month = "0"+new_to_month; 
//								}
//								
//								formObject.toMonth.value = String(fm_yyyy)+String(new_to_month);
								formObject.toMonth.value = ComGetDateAdd(check_fmmonth, "M", 3, "");
							} 
							
						}
						
					}
					
				break;
			}
		break;
	}
	return true;
}

/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset(){

	var formObject = document.form;	
	sheetObjects[0].RemoveAll();

	formObject.port.value="";
	formObject.fmMonth.value="YYYYMMDD";
	formObject.toMonth.value="YYYYMMDD";
	formObject.office.value="";
	formObject.vvd.value="";
	formObject.cntr_no.value="";
	formObject.btns_radio_date[0].checked = true;
	formObject.fmMonth.disabled = false;
	formObject.toMonth.disabled = false;
}	

function fun_Focus(obj)
{
	var val = obj.value;
	obj.value = val;
	obj.select();
}

/**
 * 라디오버튼을 누를시 period
 */
function change_period(){
	var formObject = document.form;
	var val="";	
	
	if ( formObject.btns_radio_date[0].checked == true && formObject.btns_radio_ofc[0].checked == true ) {
		formObject.fmMonth.disabled = false;
		formObject.toMonth.disabled = false;
		formObject.vvd.disabled = true;
		formObject.port.disabled = false;
		formObject.office.disabled = true;
	}else if ( formObject.btns_radio_date[1].checked == true && formObject.btns_radio_ofc[0].checked == true ) {
		formObject.vvd.disabled = false;
		formObject.fmMonth.disabled = true;
		formObject.toMonth.disabled = true;
		formObject.port.disabled = false;
		formObject.office.disabled = true;
	}else if ( formObject.btns_radio_date[0].checked == true && formObject.btns_radio_ofc[1].checked == true ) {
		formObject.fmMonth.disabled = false;
		formObject.toMonth.disabled = false;
		formObject.vvd.disabled = true;
		formObject.office.disabled = false;
		formObject.port.disabled = true;
	}else if ( formObject.btns_radio_date[1].checked == true && formObject.btns_radio_ofc[1].checked == true ) {
		formObject.vvd.disabled = false;
		formObject.fmMonth.disabled = true;
		formObject.toMonth.disabled = true;
		formObject.office.disabled = false;
		formObject.port.disabled = true;
	}
}

function sheet1_OnPopupClick(sheetObj, Row, Col){
	if(sheetObj.ColSaveName(Col) == "file_atch" && sheetObj.CellValue ( Row, Col ) != '') { 
		fileUploadPopUp (sheetObj, Row);
	}

}

function sheet1_OnClick(sheetObj, Row, Col, Value){
	if(sheetObj.ColSaveName(Col) == "file_atch" && sheetObj.CellValue ( Row, Col ) != '') { 
		fileUploadPopUp ( sheetObj, Row);
	}
}	

function fileUploadPopUp(sheetObj, Row) {
	
	var sParam = "vsl_cd="         + sheetObj.CellValue(Row, "vvd").substring(0, 4);
	sParam += "&skd_voy_no="       + sheetObj.CellValue(Row, "vvd").substring(4, 8);
	sParam += "&skd_dir_cd="       + sheetObj.CellValue(Row, "vvd").substring(8, 9);
	sParam += "&vps_port_cd="      + sheetObj.CellValue(Row, "port_cd").substring(0, 5);
	sParam += "&cltp_ind_seq="     + sheetObj.CellValue(Row, "clpt_ind_seq");
	sParam += "&cntr_hndl_knd_cd=" + sheetObj.CellValue(Row, "cntr_hndl_knd_cd");
	sParam += "&cntr_no="          + sheetObj.CellValue(Row, "cntr_no");
	sParam += "&editable="         + "N" ;
	
	var fileCount = ComOpenPopupWithTarget('/hanjin/ESD_EAS_0912.do?' + sParam, 740, 393, "vsl_cd:vsl_cd", "0,1,1,1,1,1,1", true);
	
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

  			case 'm_vvd':		// VVD. 멀티입력 팝업 호출
  			case 'm_cntr_no':		// CNTR No. 멀티입력 팝업 호출
  				var flag = ComReplaceStr(srcName,"m_","");
  			
		  		// 멀티입력 팝업 타이틀 세부 내용 지정
  				var returntitle = '';
  				if(flag == 'bkg_no')
  					returntitle = 'BKG No.';
  				else if(flag == 'bl_no')
  					returntitle = 'B/L No.';
  				else if(flag == 'cntr_no')
  					returntitle = 'CNTR No.';
  				else if(flag == 'vvd')
  					returntitle = 'VVD.';
  				
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
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }