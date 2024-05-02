/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0010.js
*@FileTitle : OCP Charge Collection Management
*Open Issues :
*Change history :
*@LastModifyDate : 20010-10-21
*@LastModifier : Jeongsoo Lee
*@LastVersion : 1.0
* 2010-10-21 Jeongsoo Lee
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends Bkg
 * @class ESD_EAS_0010 : 예)Drop Off Charge Collection Inqury 조회 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_EAS_0010() {
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
/* 공통전역변수 */
//var calPop = new calendarPopupGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var isJORetrive = false; 

/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

	/**
	 * IBTab Object를 초기화 설정
	 * 탭 ID는 tab1,tab2,...
	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
	 */
	function InitTab() {
		try{
			with(document.all.tab1){
				InsertTab(0, "Dry Index"    , 23 );
				InsertTab(1, "Tanker Index" , 23 ); 
				InsertTab(2, "Time Charter" , 23 );
				InsertTab(3, "Bunker Price" , 23 );
				InsertTab(4, "Ship Price"   , 23 ); 
				InsertTab(5, "FFA Index"    , 23 );
				TabBackColor(0)="146,174,230";
			}
		}catch(e){
			ComShowMessage(e);
		}
	}
	
	/**
	 * tab1의 onChange이벤트핸들러
	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	
	/**
	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
	 */
	function ChangeTab(tabObj,nItem){
		tabObj.BackColor="#FFFFFF";
		tabObj.TabBackColor(nItem)="146,174,230";
	
		var objs = document.all.item("tabLayer");
		objs[beforetab].style.display = "none";
		objs[nItem].style.display = "Inline";
	
		//--------------- 요기가 중요 --------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
		objs[beforetab].style.zIndex = 0;
		objs[nItem].style.zIndex = 9;
		//------------------------------------------------------//
		beforetab= nItem;
	}

	/**
	 * IBSheet Object를 배열로 등록
	 * comSheetObject(id)에서 호출한다
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
		   //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
//		document.form.somonth.focus();
		//html컨트롤 이벤트초기화
		initControl();
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch
//			axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//			axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//			axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//			axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//			axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//			axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
//			axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');	
		axon_event.addListenerForm('change', 'obj_change', document.form);
		axon_event.addListenerForm('blur', 'obj_deactivate', document.form); //- form OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
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

	var imsi = 0;
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_deactivate() {
		switch (event.srcElement.name) {
		case "location":
			if (document.form.location.value != "") {
				if (imsi == 0) {
					var status = doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
					if (!status) {
						imsi = 0;
					}
				}
			}
			break;

		}
		return true;
	}


	/** 콤보 change 이벤트 처리
	 * 
	 * @return
	 */
	function obj_change() {

		obj = event.srcElement;
		if (obj.name == "inquiryLevel") {
			if (obj.value == "Y") {
				document.getElementById("location").setAttribute("maxLength", 7);
				document.getElementById("location").focus();
			} else {
				document.getElementById("location").setAttribute("maxLength", 5);
				document.getElementById("location").focus();
			}
		}  
	}	
	
	function obj_keypress() {
		switch (event.srcElement.name) {
		case "location":
			if (document.form.inquiryLevel.value == "Y") {
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
			} else {
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
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
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = 365;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(23, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "Sts|SEQ|Control\nOffice|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|Booking Information|OCP Information|OCP Information|OCP Information|OCP Information|Collection Information|Collection Information|Collection Information|Investigation\n& Note";
					var HeadTitle2 = "Sts|SEQ|Control\nOffice|Booking|Container|T/S|RCV tm|DEL tm|Shipper|Consignee|POR|POL|POD|DEL|SC or RFA or TAA|Inbound Release|Inbound Release|MT Return|MT Return|BKG-OCP|BKG-OCP|TPB|Investigation\n& Note";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus,    30,    daCenter,  true,    "ibflag",  false,    "",         dfNone,     0,          false,      true);
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, true,     "seq",              false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, true,    "ctrl_ofc_cd",       false,          "",       dfNone,    	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "bkg_no",			false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "cntr_no",            false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "ts_cd",     		false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "rcv_tm",     		false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "del_tm",     		false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "shpr_no",      	false,          "",       dfNone,    	0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "cnee_no",      	false,          "",       dfNone,    	0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "por_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "pol_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "pod_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "del_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       110,    daCenter, false,    "sc_rfa_cd",           false,          "",       dfNone,    	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "ib_rlse_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "ib_rlse_dt",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "mt_rtn_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "mt_rtn_dt",           false,          "",       dfNone,    	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       30,    daCenter, false,    "bkg_ocp_tp",          false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daRight, false,    "bkg_ocp_amt",          false,          "",       dfNullFloat,  2,     false,       true);
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "tpb_cd",          false,          "",       dfNone,  0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,      250,    daLeft,  true,    "rmk_ctnt",          false,          "",       dfNone,  0,     true,       true);
					
					//sheetObj.ColHidden("bkg_no_split") = true;
				}
				break;
		}
	}

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
		 var sheetObject = sheetObjects[0];
		 /******************************************************/
		 var formObject = document.form;
//		 if(curTab == 2)
//			formObject = document.form2;
			
		try {
			
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "bttn_add":
					   doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "bttn_cancel":
//					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "bttn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "bttn_remove":
					break;
				case "bttn_preview":
					sheetObject.ExcelPrint = "PreView";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_downexcel":
					sheetObject.ExcelPrint = "";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "bttn_print":
					sheetObject.ExcelPrint = "PrintOnly";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					break;
				case "btns_calendar1":
					 var cal = new calendarPopup();
					 cal.select(formObject.fm_dt, 's_sdate', 'yyyy-MM-dd');
					break;
				case "btns_calendar2":
					var cal = new calendarPopupFromTo();
					cal.displayType = "date";
					cal.select(formObject.to_dt, 's_sdate',formObject.s_edate, 's_edate', 'yyyy-MM-dd');
					break;
				//case "btns_office": 
				//if( validation_check() ) {
					//var ofc_cd = formObject.s_ctrl_ofc_cd.value;
					//ComOpenWindow('ESD_EAS_COM_0001.screen?s_ctrl_ofc_cd='+ofc_cd, 'ESD_EAS_COM_0001', 'top=200, left=200, width=410, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				//}
				//break;
				case "btns_cust": 
					ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'getCustomer', '1,0,1,1,1,1,1,1');
				break;
//				case "btns_loc": 
//					ComOpenPopup('/hanjin/COM_ENS_051.do', 770, 470, 'getLocation', '1,0,1,1,1,1,1,1');
//				break;
				
                case "cnt_btn":         
                	with(formObject)
                	{    	    
                	    var v_cnt_cd = cnt_cd.value;
                	    var classId = "COM_ENS_0M1";
            		    var param = '?cnt_cd='+v_cnt_cd+'&classId='+classId;
            		    var v_display = "1,0,1,1,1,0,0";
            		    var chkStr = v_display.substring(0,3)
            		  
            		    if(chkStr == "1,0") {
            		        ComOpenPopup('/hanjin/COM_ENS_0M1.do' + param, 565, 480, 'getCOM_ENS_0M1_1', v_display, true);
            		    } else {
            			    return;
            		    }
                	}
				break;
				//case "btn_detail":
				//	//ComOpenWindow('ESD_EAS_0903.do?inv_no=PUS-07-05-TS-20', 'ESD_EAS_0903', 'top=200, left=200, width=800, height=600, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=1');
				//	sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, sheetObject.SelectCol);
				//	break;
				case "btns_office": //M CNTR
					//if( validation_check() ) {
						var ofc_cd = formObject.s_ctrl_ofc_cd.value;
						if( ofc_cd.length > 5 ){
							ofc_cd = ofc_cd.substr(0,5);
						}
						ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
					//}
				break;		
				case "btn_loc_cd": //Location 조회 팝업
					var cnt_cd = "";
					var loc_cd = "";
					cnt_cd = formObject.inquiryLevel.value;
					loc_cd = formObject.location.value;
					if (formObject.inquiryLevel.value != 'A') {
						if (formObject.inquiryLevel.value == 'C') { //Country
							var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
							ComOpenPopup("/hanjin/COM_ENS_0M1.do", 565, 650, "popupFinish", "1,0,1,1,1,1,1,1", true);
						} else if (formObject.inquiryLevel.value == 'Y') { //YARD
							var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
							ComOpenPopup("/hanjin/COM_ENS_061.do", 755, 650, "popupFinish2", "1,0,1,1,1,1,1,1", true);
						} else {
							var loc_code = "";

							if (formObject.inquiryLevel.value == "R") {
								loc_code = "rcc_cd";
							} else if (formObject.inquiryLevel.value == "L") {
								loc_code = "lcc_cd";
							} else if (formObject.inquiryLevel.value == "E") {
								loc_code = "ecc_cd";
							} else if (formObject.inquiryLevel.value == "S") {
								loc_code = "scc_cd";
							}

							var param = "?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
							ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
						}
					}
					break;			
				case "m_cntr_no":
				case "m_bkg_no":
 					doProcessPopup(srcName);    
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
	 * Location popup close시 호출되는 함수
	 *
	 */
//	function getLocation(rArray) {
//		var cArray = rArray[0];
//		document.all.s_mt_rtn_cd.value = cArray[3];
//	}

	
	function getCustomer(rArray){
		var cArray = rArray[0];
		
		document.form.s_cnee_no.value = cArray[3];		
		document.form.s_cust_nm.value = cArray[4]; 
    }	
	/**
	 * Location by loc_cd 팝업에서 선택한 값 Setting.
	 */
	function popupFinish(aryPopupData, row, col, sheetIdx) {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		formObject.location.value = aryPopupData[0][3]
	}

	/**
	 * Location by yard_cd 팝업에서 선택한 값 Setting.
	 */
	function popupFinish2(aryPopupData, row, col, sheetIdx) {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		formObject.location.value = aryPopupData[0][3]
	}	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
//		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH;
//				prompt('',"ESD_EAS_0010GS.do?"+EasFrmQryString(formObj));
//				return;
				sheetObj.DoSearch4Post("ESD_EAS_0010GS.do", EasFrmQryString(formObj));
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
			case IBSAVE:        //저장
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESD_EAS_0010GS.do", EasFrmQryString(formObj));
				break;	

			case IBSEARCH_ASYNC03: //location focusOut
//				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value = SEARCH02;
					imsi++;
					if (formObj.location.value == "") {
						return true;
					}
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0010GS.do", FormQueryString(formObj));
					var sCheck = ComGetEtcData(sXml, "check");
					if (sCheck != "OK") {
						var inquiryLevel = document.getElementById("inquiryLevel").value;
						if (document.form.location.value != "") {
							if (inquiryLevel == "L") {
								formObj.location.value = "";
								ComShowCodeMessage("EAS29018");
								ComSetFocus(document.form.location);
								sheetObj.WaitImageVisible = true;

								return false;

							} else if (inquiryLevel == "E") {
								formObj.location.value = "";
								ComShowCodeMessage("EAS29019");
								ComSetFocus(document.form.location);
								sheetObj.WaitImageVisible = true;
								return false;
							} else if (inquiryLevel == "S") {
								formObj.location.value = "";
								ComShowCodeMessage("EAS29020");
								sheetObj.WaitImageVisible = true;
								ComSetFocus(document.form.location);
								return false;
							} else if (inquiryLevel == "Y") {
								formObj.location.value = "";
								ComShowCodeMessage("EAS29021");
								sheetObj.WaitImageVisible = true;
								ComSetFocus(document.form.location);
								return false;
							} else if (inquiryLevel == "R") {
								formObj.location.value = "";
								ComShowCodeMessage("EAS29008");
								sheetObj.WaitImageVisible = true;
								ComSetFocus(document.form.location);
								return false;
							}
						} else {
							return true;
						}
						
					}
					ComSetFocus(document.form.soc);
//				} else {
//					return;
//				}
				sheetObj.WaitImageVisible = true;
				break;		
				//location focusOut---------------
		}
	}
	

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){

	}

	function sheet1_OnClick(sheetObj, Row,Col,Value){
	
	}


//Office의 Text 변경시
function fun_officeText() {
	document.form.s_ctrl_ofc_cd.value = document.form.s_ctrl_ofc_cd.value.toUpperCase();
}

function rtn_office_code(obj) {
	document.form.s_ctrl_ofc_cd.value = obj;
}


function upperCase(obj) {
	obj.value = obj.value.toUpperCase();
	
}
function pointAutoMove(val) {
	if ( val.length == 8  ) {
		document.form.to_dt.focus();
	}
}

function selectText(obj) {
	//alert("obj.name : "+obj.name);
	if( obj.name == "fm_dt" || obj.name == "to_dt" ) {
		selectWhere();
	}	
}


function selectWhere() {

	if ( document.form.fm_dt.value == "yyyymmdd" ){
		document.form.fm_dt.value = "";
		document.form.fm_dt.focus();
	}	
	
	if ( document.form.to_dt.value == "yyyymmdd" ){
		document.form.to_dt.value = "";
	}
}

function setNull() {
	if ( document.form.fm_dt.value == "yyyymmdd" ){
		document.form.fm_dt.value = "";
	}	
	if ( document.form.to_dt.value == "yyyymmdd" ){
		document.form.to_dt.value = "";
	}
	if ( document.form.s_ctrl_ofc_cd.value != "" ){
		document.form.s_ctrl_ofc_cd.value = "";
	}
//	if ( document.form.s_mt_rtn_cd.value != "" ){
//		document.form.s_mt_rtn_cd.value = "";
//	}
	if ( document.form.location.value != "" ){
		document.form.location.value = "";
	} 
	if ( document.form.s_cnee_no.value != "" ){
		document.form.s_cnee_no.value = "";
	}
	if ( document.form.s_cust_nm.value != "" ){
		document.form.s_cust_nm.value = "";
	}
	
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
//	formObj = document.form;
		var result = true ;
		// 검색 조건 입력 여부
/*		if( !isInputField(formObj) ) {
			result = false ;
		}*/
		if( ComIsEmpty(formObj.s_bkg_no) ){
			//alert("부킹이 없다");
			if( ComIsEmpty(formObj.fm_dt) || ComIsEmpty(formObj.to_dt) || formObj.to_dt.value == "yyyymmdd"){
				ComShowMessage("Please enter MT Return Period.");
				result = false;
			}
			else {
				var days = ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value);
				
//				ComChkPeriod
//				-1 : 인자가 올바르지 않아 에러 발생
//				0 : fromDate > toDate
//				1 : fromDate < toDate
//				2 : fromDate = toDate
				if( 0 == ComChkPeriod ( formObj.to_dt.value ,ComGetDateAdd(formObj.fm_dt.value, "M", 3)) ) {
					ComShowMessage("MT Return Period Should not exceed 3 month duration.");
					result = false;
				}
				
//				if (days > 90){
//					ComShowMessage("MT Return Period Should not exceed 3 month duration.");
//					result = false;
//				}	
			}	
		}
		
		else {
//			//alert("부킹이 있다");
//			if( formObj.s_ctrl_ofc_cd.value != "" || formObj.s_mt_rtn_cd.value != "" || formObj.s_cnee_no.value != "" || formObj.s_cust_nm.value !="" ){
			if( formObj.s_ctrl_ofc_cd.value != "" || formObj.location.value != "" || formObj.s_cnee_no.value != "" || formObj.s_cust_nm.value !="" ){
				setNull();
				ComShowMessage(ComGetMsg("EAS90021", "", "", ""));
				result = false;
			}
			else if ( formObj.fm_dt.value != "" && formObj.to_dt.value == "" ){
				ComShowMessage("Please enter MT Return Period.");
				result = false;
			}
		}	
	return result;
		
}

function isInputField(formObj) {
	var result    = true ;

	if( document.form.s_ctrl_ofc_cd.value=="" ) {
		ComShowMessage("Please enter TRO Office Code.");
		result = false;
	}
	return result;
}

/**
 * Investigation Remark 등록 수정 팝업. //4341.11.24
 * 
 */

/*function sheet1_OnDblClick(sheetObj, row, col ){
	
    if(col == 21){
    	var theURL = "ESD_EAS_0905.do?bkg_no=" + sheetObj.CellValue( row, 'bkg_no') + "&cntr_no=" + sheetObj.CellValue( row, 'cntr_no') + "&bl_no=" + sheetObj.CellValue( row, 'bl_no') + "&eas_expn_tp_cd=CO&rmk_ctnt_seq=1" + "&rmk_ctnt=" + sheetObj.CellValue( row, 'ctrt_no');
    	var winName = "ESD_EAS_0905";
    	var features = "width=700,height=365,toolbar=no,location=no,status=yes,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
    	
    	ComOpenWindow(theURL,winName,features);
    }
}*/


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

		    case 'm_bkg_no':		// BKG No. 멀티입력 팝업 호출
			case 'm_cntr_no':		// CNTR No. 멀티입력 팝업 호출
				var flag = ComReplaceStr(srcName,"m_","");
			
	  		// 멀티입력 팝업 타이틀 세부 내용 지정
				var returntitle = '';
				if(flag == 'bkg_no') {
					returntitle = 'BKG No.';
					flag = 's_'+flag;
				}
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
	