/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0012.js
*@FileTitle : Drop Off Charge Collection Inqury List 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-21
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-21 choice
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
 * @class ESD_EAS_0012 : 예)Drop Off Charge Collection Inqury 조회 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_EAS_0012() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
//    this.initTab                = initTab;
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

var btnsOfcEnalbe = true;
var btnsCustEnalbe = true;
var selTpCd;


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
		// bkg_no에 체크되게
		selectTpCd("1");
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
		 
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
					style.height = 360;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);


					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "SEQ|TRO Office|Booking|Term|BKG Qty|SC/RFA/TAA|Haulage|Merchant CD|Import Merchant|Cust TP|Container No.|T/S|POR|POL|POD|DEL|TRO Date|MT Retrun(TRO)|Return CY(MVMT)|Applied Date|Curr|Rate in Tar|Rate in RFA|TRO Amt|DOD Amt";
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);		
									   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,   	 40,    daCenter, true,     "seq",              false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       70,    daCenter, false,    "cre_ofc_cd",       false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "bkg_no",			false,          "",       dfNone,    	0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,       40,    daCenter, false,    "de_term_cd",        false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       70,    daCenter, false,    "bkg_qty",	        false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       100,    daCenter, false,    "sc_rfa_taa",        false,          "",       dfNone,    	0,     false,       true);
										
					InitDataProperty(0, cnt++, dtData,       70,    daCenter, false,    "hlg_tp_cd",        false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "mer_cd",	        false,          "",       dfNone,    	0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,      200,    daLeft,   false,    "cust_cd",     		false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "cust_tp",	        false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,      100,    daCenter, false,    "cntr_no",      	false,          "",       dfNone,    	0,     false,       true); 
					InitDataProperty(0, cnt++, dtData,       30,    daCenter, false,    "cntr_tpsz_cd",     false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "por_cd",           false,          "",       dfNone,    	0,     false,       true);
					
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "pol_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "pod_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter, false,    "del_cd",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       80,    daCenter, false,    "cre_dt",           false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       110,   daCenter, false,    "cntr_rtn_yd_cd",   false,          "",       dfNone,   	0,     false,       true);

					InitDataProperty(0, cnt++, dtData,       110,   daCenter, false,    "mt_mvmt_org_yd_cd",    false,          "",       dfNone,   	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       110,   daCenter, false,    "mt_applied_dt",    false,          "",       dfNone,   	0,     false,       true,-1,false,true,"VL Date");
					InitDataProperty(0, cnt++, dtData,       40,    daCenter, false,    "curr_cd",          false,          "",       dfNone,    	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       100,    daCenter, false,    "tar_amt",          false,          "",       dfNullFloat,  0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       100,    daCenter, false,    "rfa_rt",          false,          "",       dfNullFloat,  0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "tro_amt",          false,          "",       dfNullFloat,  0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       60,    daCenter, false,    "dod_amt",          false,          "",       dfNullFloat,  0,     false,       true);
					
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
		 var sheetObject = sheetObjects[curTab-1];
		 /******************************************************/
		 var formObject = document.form;
		 if(curTab == 2)
			formObject = document.form2;
			
		try {
			
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
//				case "bttn_add":
//					   doActionIBSheet(sheetObject,formObject,IBINSERT);
//					break;
//				case "bttn_cancel":
//					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
//					break;
//				case "bttn_save":
//					doActionIBSheet(sheetObject,formObject,IBSAVE);
//					break;
				case "bttn_remove":
					break;
//				case "bttn_preview":
//					sheetObject.ExcelPrint = "PreView";
//					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//					break;
				case "btn_downexcel":
					sheetObject.ExcelPrint = "";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
//				case "bttn_print":
//					sheetObject.ExcelPrint = "PrintOnly";
//					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					break;
				case "btns_calendar1":
					 var cal = new calendarPopup();
					 cal.select(formObject.s_sdate, 's_sdate', 'yyyy-MM-dd');
					break;
				case "btns_calendar2":
					var cal = new calendarPopupFromTo();
					cal.displayType = "date";
					cal.select(formObject.s_sdate, 's_sdate',formObject.s_edate, 's_edate', 'yyyy-MM-dd');
					break;
				case "btns_office": 
					if (btnsOfcEnalbe) {
						var url_str;
	                    url_str = 'ESD_EAS_COM_0002.screen'
	                    url_str = url_str + '?ctrl_ofc_cd='+(formObject.ctrl_ofc_cd.value==""?ofc_cd:formObject.ctrl_ofc_cd.value);
	                    url_str = url_str + '&param_nm=ctrl_ofc_cd'
	                    window.showModalDialog(url_str,  window, "dialogWidth:425px; dialogHeight:440px; help:no; status:no; resizable:yes;");
					}
          	        break;
				case "btns_cust": 
					if (btnsCustEnalbe) {
						ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'getCustomer', '1,0,1,1,1,1,1,1');
					}
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
	
	function getCustomer(rArray){
		var cArray = rArray[0];
		
		document.form.cust_cd.value = cArray[3];		
		document.form.cust_nm.value = cArray[4]; 
    }	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH;
				
				// 1. sel_tp_cd의 값에 따라서 form의 값을 설정한다.
				form.sel_tp_cd.value = selTpCd; 
				setFormValueBySelectType(selTpCd);
				
     			var sXml = sheetObj.GetSearchXml("ESD_EAS_0012GS.do", EasFrmQryString(formObj));
				var arrXml = sXml.split("|$$|");

				sheetObj.LoadSearchXml(sXml);
				
				break;	 
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
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
		document.form.ctrl_ofc_cd.value = document.form.ctrl_ofc_cd.value.toUpperCase();
	}
	
	function rtn_office_code(obj) {
		document.form.ctrl_ofc_cd.value = obj;
	}
	
	
	function upperCase(obj) {
		obj.value = obj.value.toUpperCase();
		
	}
	
	
	function pointAutoMove(val,type) {
		
		if ( val.length == 8  ) {

			switch (type) {
		
			case '1':
				document.form.totrodate_t.focus();
				break;
				
			case '2':
				document.form.totrodate_r.focus();
				break;
			
			case '3':
				document.form.totrodate_i.focus();
				break;
			
			case '4':
				document.form.totrodate_m.focus();
				break;
			}
		}
	}
	
	function selectText(obj) {
		
		var objName = obj.name;

		
		if(objName.indexOf("_t") > 0) {
			if(objName.indexOf("tromonth")==0) {
				document.form.search_choice_t[0].checked = true;
			} else if (objName.indexOf("fromtrodate")==0 || objName.indexOf("totrodate")==0) {
				document.form.search_choice_t[1].checked = true;
			}
			selectWhere('t');
			
		} else if(objName.indexOf("_r")> 0) {
			if(objName.indexOf("tromonth")==0) {
				document.form.search_choice_r[0].checked = true;
			} else if (objName.indexOf("fromtrodate")==0 || objName.indexOf("totrodate")==0) {
				document.form.search_choice_r[1].checked = true;
			}
			selectWhere('r');
			
		} else if(objName.indexOf("_i")> 0) {
			if(objName.indexOf("tromonth")==0) {
				document.form.search_choice_i[0].checked = true;
			} else if (objName.indexOf("fromtrodate")==0 || objName.indexOf("totrodate")==0) {
				document.form.search_choice_i[1].checked = true;
			}
			selectWhere('i');
			
		} else if(objName.indexOf("_m")> 0) {
			if(objName.indexOf("tromonth")==0) {
				document.form.search_choice_m[0].checked = true;
			} else if (objName.indexOf("fromtrodate")==0 || objName.indexOf("totrodate")==0) {
				document.form.search_choice_m[1].checked = true;
			}
			selectWhere('m');
		}
		
	}
	
	
	function selectWhere(type) {
		
		switch(type) {
			
			case  't' :
		
				if( document.form.search_choice_t[0].checked == true ) {
			
					document.form.tromonth_t.disabled = false;
					document.form.tromonth_t.value = "";
					document.form.tromonth_t.focus();
						
					document.form.search_choice_t[1].checked = false;
					document.form.fromtrodate_t.value = "yyyymmdd";
					document.form.fromtrodate_t.disabled = true;
					document.form.totrodate_t.value = "yyyymmdd";
					document.form.totrodate_t.disabled = true;
							
				} else if( document.form.search_choice_t[1].checked == true ) {
			
					document.form.fromtrodate_t.disabled = false;
					document.form.totrodate_t.disabled = false;
					if ( document.form.fromtrodate_t.value == "yyyymmdd" ){
						document.form.fromtrodate_t.value = "";
						document.form.fromtrodate_t.focus();
					}	
					
					if ( document.form.totrodate_t.value == "yyyymmdd" ){
						document.form.totrodate_t.value = "";
					}
			
					document.form.search_choice_t[0].checked = false;
					document.form.tromonth_t.value = "yyyymm";
					document.form.tromonth_t.disabled = true;
				}
				break;
			
			case  'r' :
				
				if( document.form.search_choice_r[0].checked == true ) {
					
					document.form.tromonth_r.disabled = false;
					document.form.tromonth_r.value = "";
					document.form.tromonth_r.focus();
					
					document.form.search_choice_r[1].checked = false;
					document.form.fromtrodate_r.value = "yyyymmdd";
					document.form.fromtrodate_r.disabled = true;
					document.form.totrodate_r.value = "yyyymmdd";
					document.form.totrodate_r.disabled = true;
					
				} else if( document.form.search_choice_r[1].checked == true ) {
					
					document.form.fromtrodate_r.disabled = false;
					document.form.totrodate_r.disabled = false;
					if ( document.form.fromtrodate_r.value == "yyyymmdd" ){
						document.form.fromtrodate_r.value = "";
						document.form.fromtrodate_r.focus();
					}	
					
					if ( document.form.totrodate_r.value == "yyyymmdd" ){
						document.form.totrodate_r.value = "";
					}
					
					document.form.search_choice_r[0].checked = false;
					document.form.tromonth_r.value = "yyyymm";
					document.form.tromonth_r.disabled = true;
				}
				break;
				
			case  'i' :
				
				if( document.form.search_choice_i[0].checked == true ) {
					
					document.form.tromonth_i.disabled = false;
					document.form.tromonth_i.value = "";
					document.form.tromonth_i.focus();
					
					document.form.search_choice_i[1].checked = false;
					document.form.fromtrodate_i.value = "yyyymmdd";
					document.form.fromtrodate_i.disabled = true;
					document.form.totrodate_i.value = "yyyymmdd";
					document.form.totrodate_i.disabled = true;
					
				} else if( document.form.search_choice_i[1].checked == true ) {
					
					document.form.fromtrodate_i.disabled = false;
					document.form.totrodate_i.disabled = false;
					if ( document.form.fromtrodate_i.value == "yyyymmdd" ){
						document.form.fromtrodate_i.value = "";
						document.form.fromtrodate_i.focus();
					}	
					
					if ( document.form.totrodate_i.value == "yyyymmdd" ){
						document.form.totrodate_i.value = "";
					}
					
					document.form.search_choice_i[0].checked = false;
					document.form.tromonth_i.value = "yyyymm";
					document.form.tromonth_i.disabled = true;
				}
				break;
				
			case  'm' :
				
				if( document.form.search_choice_m[0].checked == true ) {
					
					document.form.tromonth_m.disabled = false;
					document.form.tromonth_m.value = "";
					document.form.tromonth_m.focus();
					
					document.form.search_choice_m[1].checked = false;
					document.form.fromtrodate_m.value = "yyyymmdd";
					document.form.fromtrodate_m.disabled = true;
					document.form.totrodate_m.value = "yyyymmdd";
					document.form.totrodate_m.disabled = true;
					
				} else if( document.form.search_choice_m[1].checked == true ) {
					
					document.form.fromtrodate_m.disabled = false;
					document.form.totrodate_m.disabled = false;
					if ( document.form.fromtrodate_m.value == "yyyymmdd" ){
						document.form.fromtrodate_m.value = "";
						document.form.fromtrodate_m.focus();
					}	
					
					if ( document.form.totrodate_m.value == "yyyymmdd" ){
						document.form.totrodate_m.value = "";
					}
					
					document.form.search_choice_m[0].checked = false;
					document.form.tromonth_m.value = "yyyymm";
					document.form.tromonth_m.disabled = true;
				}
				break;
		}
	
	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(formObj){
	
		formObj = document.form;
		var result = true;		
		if( !isInputField(selTpCd) ) {
			
			return false ;
		} 
		switch(selTpCd) {
		
			case '1':	  //IBSheet1 init
		
				break;
			
			
			case '2':
				// 검색 조건 입력 여부
				if( formObj.search_choice_t[0].checked == true ){
					if( ComIsEmpty(formObj.tromonth_t) || !chkMonthValue(formObj.tromonth_t.value) ){
						ComShowMessage("Please enter TRO Month.");
						result = false;
					}
				}else if( formObj.search_choice_t[1].checked == true ){
				
					if( ComIsEmpty(formObj.fromtrodate_t) || ComIsEmpty(formObj.totrodate_t) ){
						ComShowMessage("Please enter TRO Period.");
						result = false;
					}
				}
				break;
			
			case '3':	  //IBSheet1 init
			
				if( formObj.search_choice_r[0].checked == true ){
					
					if( ComIsEmpty(formObj.tromonth_r) || !chkMonthValue(formObj.tromonth_r.value) ){
						ComShowMessage("Please enter MT Return Period.");
						result = false;
					}
				}else if( formObj.search_choice_r[1].checked == true ){
				
					if( ComIsEmpty(formObj.fromtrodate_r) || ComIsEmpty(formObj.totrodate_r) ){
						ComShowMessage("Please enter MT Return Period.");
						result = false;
					}
				}
				break;
			
			case '4':	  //IBSheet1 init
				if( formObj.search_choice_i[0].checked == true ){
					
					if( ComIsEmpty(formObj.tromonth_i) || !chkMonthValue(formObj.tromonth_i.value) ){
						ComShowMessage("Please enter MT Return Period.");
						result = false;
					}
				}else if( formObj.search_choice_i[1].checked == true ){
				
					if( ComIsEmpty(formObj.fromtrodate_i) || ComIsEmpty(formObj.totrodate_i) ){
						ComShowMessage("Please enter MT Return Period.");
						result = false;
					}
				}
				break;
			
			case '5':	  //IBSheet1 init
			
				if( formObj.search_choice_m[0].checked == true ){
					
					if( ComIsEmpty(formObj.tromonth_m) || !chkMonthValue(formObj.tromonth_m.value) ){
						ComShowMessage("Please enter MT Return Period.");
						result = false;
					}
				}else if( formObj.search_choice_m[1].checked == true ){
				
					if( ComIsEmpty(formObj.fromtrodate_m) || ComIsEmpty(formObj.totrodate_m) ){
						ComShowMessage("Please enter MT Return Period.");
						result = false;
					}
				}
				break;
			
		}
	
		return result;
	}
	
	function isInputField(selTpCd) {
		var result    = true ;
		
		// MT Return Loc 값 체크 - 2,5,7자리가 아니면 에러.
		if (document.form.return_cy.value !="") {
			if (document.form.return_cy.value.length != 2 && document.form.return_cy.value.length != 5 && document.form.return_cy.value.length != 7) {
				ComShowMessage("Please check MT Return Loc");
				return false;
			}	
		}
		
		switch(selTpCd) {
		
		case '1' : 
			if( document.form.bkg_no.value=="" ) {
				ComShowMessage("Please enter BKG NO.");
				result = false;
			}
			break;
		
		case '2' : 
			if( document.form.ctrl_ofc_cd.value=="" ) {
				ComShowMessage("Please enter TRO Office Code.");
				result = false;
			}
			break;
			
		case '3' : 
			if( document.form.rfa_no.value=="" ) {
				ComShowMessage("Please enter RFA Code.");
				result = false;
			}
			break;
			
		case '4' : 
			if( document.form.cust_cd.value=="" ) {
				ComShowMessage("Please enter Customer Code.");
				result = false;
			}
			break;
			
		case '5' : 
			if( document.form.return_cy.value=="" ) {
				ComShowMessage("Please enter Return Loc Code.");
				result = false;
			} 
			break;
		}
		return result;
	}
		
	
	function selectTpCd (val) {
	
		selTpCd = val;
		
		switch(val) {
			case "1":			
				
				// BKG_NO 가 선택된 경우 - BKG 이외의 모든 폼을 비활성화 한다.
				setDisableBKG(false);
				setDisableTRO(true);
				setDisableRFA(true);
				setDisableIM(true);
				setDisableMT(true);
				// BKG_NO 가 선택된 경우 - BKG 이외의 모든 폼의 값을 지운다.
				
				//deleteBKG()
				deleteTRO();
				deleteRFA();
				deleteIM();
				deleteMT();
				
				
				break;
			case "2":
				// TRO_OFFICE 가 선택된 경우 - TRO_OFFICE,MT Return Loc 이외의 모든 폼을 비활성화 한다.
				setDisableBKG(true);
				setDisableTRO(false);
				setDisableRFA(true);
				setDisableIM(true);
				setDisableMT(true);			

				deleteBKG()
				//deleteTRO();
				deleteRFA();
				deleteIM();
				deleteMT();
				
				form.ctrl_ofc_cd.value = form.fst_ofc_cd.value;
				
				break;
			case "3":
				// RFA 가 선택된 경우 - RFA,MT Return Loc 이외의 모든 폼을 비활성화 한다.
				setDisableBKG(true);
				setDisableTRO(true);
				setDisableRFA(false);
				setDisableIM(true);
				setDisableOnlyMT(false);	
				
				deleteBKG()
				deleteTRO();
				//deleteRFA();
				deleteIM();
				deleteMT();				
				break;
			case "4":
				// Import Merchant 선택된 경우  - Import Merchant ,MT Return Loc 이외의 모든 폼을 비활성화 한다.
				setDisableBKG(true);
				setDisableTRO(true);
				setDisableRFA(true);
				setDisableIM(false);
				setDisableOnlyMT(false);	
				
				deleteBKG()
				deleteTRO();
				deleteRFA();
				//deleteIM();
				deleteMT();
				
				break;
			case "5":
				// MT Return Loc 가 선택된 경우  -MT Return Loc 이외의 모든 폼을 비활성화 한다.
				setDisableBKG(true);
				setDisableTRO(true);
				setDisableRFA(true);
				setDisableIM(true);
				setDisableMT(false);			
				
				deleteBKG()
				deleteTRO();
				deleteRFA();
				deleteIM();
				//deleteMT();
				
				break;
		}
	}
		
	function setDisableBKG(setFlg) {	
		form.bkg_no.disabled = setFlg;
	}
	
	function setDisableTRO(setFlg) {	
		
		btnsOfcEnalbe = !setFlg;
		form.ctrl_ofc_cd.disabled = setFlg;
		form.haul_cd_t.disabled = setFlg;
		form.search_choice_t1.disabled = setFlg;
		form.search_choice_t2.disabled = setFlg;
		form.tromonth_t.disabled = setFlg;
		form.fromtrodate_t.disabled = setFlg;
		form.totrodate_t.disabled = setFlg;
	}
	function setDisableRFA(setFlg) {		
		form.rfa_no.disabled = setFlg;
		form.haul_cd_r.disabled = setFlg;
		form.search_choice_r1.disabled = setFlg;
		form.search_choice_r2.disabled = setFlg;
		form.tromonth_r.disabled = setFlg;
		form.fromtrodate_r.disabled = setFlg;
		form.totrodate_r.disabled = setFlg;
		
	}
	function setDisableIM(setFlg) {	
		btnsCustEnalbe = !setFlg;	
		form.cust_cd.disabled = setFlg;
		form.cust_nm.disabled = setFlg;
		form.haul_cd_i.disabled = setFlg;
		form.search_choice_i1.disabled = setFlg;
		form.search_choice_i2.disabled = setFlg;
		form.tromonth_i.disabled = setFlg;
		form.fromtrodate_i.disabled = setFlg;
		form.totrodate_i.disabled = setFlg;	
	}
	
	function setDisableMT(setFlg) {	
		form.return_cy.disabled = setFlg;
		form.haul_cd_m.disabled = setFlg;
		form.search_choice_m1.disabled = setFlg;
		form.search_choice_m2.disabled = setFlg;
		form.tromonth_m.disabled = setFlg;
		form.fromtrodate_m.disabled = setFlg;
		form.totrodate_m.disabled = setFlg;	
	}
	
	function setDisableOnlyMT(setFlg) {	
		form.return_cy.disabled = setFlg;
		form.haul_cd_m.disabled = !setFlg;
		form.search_choice_m1.disabled = !setFlg;
		form.search_choice_m2.disabled = !setFlg;
		form.tromonth_m.disabled = !setFlg;
		form.fromtrodate_m.disabled = !setFlg;
		form.totrodate_m.disabled = !setFlg;	
	}

	function deleteBKG(){
		form.bkg_no.value = '';
	}
	function deleteTRO(){
		form.ctrl_ofc_cd.value ='';
		form.haul_cd_t.value = '';
		form.tromonth_t.value ='';
		form.fromtrodate_t.value ='yyyymmdd';
		form.totrodate_t.value ='yyyymmdd';
	}
	function deleteRFA(){
		form.rfa_no.value = '';		
		form.haul_cd_r.value = '';
		form.tromonth_r.value ='';
		form.fromtrodate_r.value ='yyyymmdd';
		form.totrodate_r.value ='yyyymmdd';
	}
	function deleteIM(){
		form.cust_cd.value = '';
		form.cust_nm.value = '';
		form.haul_cd_i.value = '';
		form.tromonth_i.value ='';
		form.fromtrodate_i.value ='yyyymmdd';
		form.totrodate_i.value ='yyyymmdd';
	}
	function deleteMT(){
		form.return_cy,value = '';
		form.haul_cd_m.value = '';
		form.tromonth_m.value ='';
		form.fromtrodate_m.value ='yyyymmdd';
		form.totrodate_m.value ='yyyymmdd';
		form.return_cy.value ='';
	}
	
	function setFormValueBySelectType(type) {
		
		switch(type) {
		
		case '1': 
			form.haul_cd.value = '';
			form.tromonth.value ='';
			form.fromtrodate.value ='';
			form.totrodate.value ='';
			form.mt_rtn_mth.value = '';
			form.fromtrodate.value = '';
			form.totrodate.value = '';
			break;
		case '2':
			form.haul_cd.value = form.haul_cd_t.value;
			form.tromonth.value ='';
			form.fromtrodate.value ='';
			form.totrodate.value ='';
			form.tromonth.value =form.tromonth_t.value=='yyyymm'?'':form.tromonth_t.value;
			form.fromtrodate.value = form.fromtrodate_t.value=='yyyymmdd'?'':form.fromtrodate_t.value;
			form.totrodate.value = form.totrodate_t.value=='yyyymmdd'?'':form.totrodate_t.value;
			break;
		case '3':
			form.haul_cd.value = form.haul_cd_r.value;
			form.tromonth.value ='';
			form.fromtrodate.value ='';
			form.totrodate.value ='';
			form.mt_rtn_mth.value =form.tromonth_r.value=='yyyymm'?'':form.tromonth_r.value;
			form.fm_mt_rtn_prd.value = form.fromtrodate_r.value=='yyyymmdd'?'':form.fromtrodate_r.value;
			form.to_mt_rtn_prd.value = form.totrodate_r.value=='yyyymmdd'?'':form.totrodate_r.value;
			break;
		case '4':
			form.haul_cd.value = form.haul_cd_i.value;
			form.tromonth.value ='';
			form.fromtrodate.value ='';
			form.totrodate.value ='';
			form.mt_rtn_mth.value = form.tromonth_i.value=='yyyymm'?'':form.tromonth_i.value;
			form.fm_mt_rtn_prd.value = form.fromtrodate_i.value=='yyyymmdd'?'':form.fromtrodate_i.value;
			form.to_mt_rtn_prd.value = form.totrodate_i.value=='yyyymmdd'?'':form.totrodate_i.value;
			break;
		case '5':
			form.haul_cd.value = form.haul_cd_m.value;
			form.tromonth.value ='';
			form.fromtrodate.value ='';
			form.totrodate.value ='';
			form.mt_rtn_mth.value =form.tromonth_m.value=='yyyymm'?'':form.tromonth_m.value;
			form.fm_mt_rtn_prd.value = form.fromtrodate_m.value=='yyyymmdd'?'':form.fromtrodate_m.value;
			form.to_mt_rtn_prd.value = form.totrodate_m.value=='yyyymmdd'?'':form.totrodate_m.value;		
			break;	
		}
	}
	
	
