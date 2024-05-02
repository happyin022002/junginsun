/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0158.js
*@FileTitle : Office/Volum Activity
*Open Issues :
*Change history :
	* 2009-10-27 Choi In Kyung
	* 1.0 최초 생성
	* 2009.10.27 최인경 ALPS New Framework 적용   
	* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
	* 2010.04.15 이중환 FormQueryString -> coaFormQueryString 변경
	* 2011.01.25 송민석 CHM-201108507-01 MEXBA 조회토록 수정
	* 2011.05.09 최윤성 [CHM-201110694-01] COA Report 화면 combo box validation 추가
	* 2011.06.21 이석준 [CHM-201111642-01] COA Logistics Exp. By Office화면에서 R.Month / S.Month 구분요청 
	* 2011.08.31 최성민 [CHM-201113156-01] [COA] Logistics Exp. By Office화면에서 R.Month / S.Month 구분 관련
	* 2011.10.07 이석준 [CHM-201113815-01] Logistics PFMC Report 화면 수정 요청  R.Month / S.Month 구분 관련
	* 2014.03.25 박찬민 CHM-201429466 [COA] Logistics vol. by office 화면
*@LastModifyDate : 2010.04.15
*@LastModifier : 이중환
*@LastVersion : 1.1
=========================================================*/
/**
 * @fileoverview 
 * @author 한진해운
 */
/**
* @extends logisticsrpt
* @class ESM_COA_0158 : ESM_COA_0158 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
*/
function ESM_COA_0158() {
    	this.processButtonClick		= processButtonClick;
    	this.clearDatePeriod 		= clearDatePeriod;
    	this.setPeriod 				= setPeriod;
    	this.changeKpiType			= changeKpiType;
    	this.reportChange			= reportChange;
    	this.changeHideColumn		= changeHideColumn;
    	this.f_trd_cd_OnChange		= f_trd_cd_OnChange;
    	this.changeRHQCd			= changeRHQCd;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.chkValidSearch			= chkValidSearch;
    	this.validateForm 			= validateForm;
}
   
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					break;

				case "btn_DownExcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "bu_zoom_in1":
					if(sheetObject.Rows > 13){
						sheetObject.style.height = sheetObject.GetSheetHeight(sheetObject.Rows);
						div_zoom_out1.style.display = "inline";
						div_zoom_in1.style.display = "none";
						parent.syncHeight();
					}
					break;

				case "bu_zoom_out1":
					if(sheetObject.Rows >13){
						sheetObject.style.height = sheetObject.GetSheetHeight(13);
						div_zoom_in1.style.display = "inline";
						div_zoom_out1.style.display = "none";
						parent.syncHeight();
					}
					break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
                ComShowMessage(ComGetMsg("COM12111", "", ""));
            } else {
                ComShowMessage(e);
            }
		}
	}

    /**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function clearDatePeriod(){
		document.form.txtWeek.value = "";
		document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
	}

	/**
	* month, week가 변경되었을때 Period를 변경한다.
	*/
	function setPeriod(obj){
		ComCoaSetPeriod(obj);
	}
	
	   /**
	    * kpl 타입
	    */
	   function changeKpiType(kpiType) {
	 	    if(kpiType == '2') {
		        div_mnKpi.style.display = "none";
		        div_lgsKpi.style.display = "inline";
		    } else {
		        div_mnKpi.style.display = "inline";
		        div_lgsKpi.style.display = "none";
		    }      
	   }
	   
	    /**
		* rhq, office조건 활성화/비활성화
		*/
		function reportChange(tp){
		    if(tp == '1') {// RHQ, Office 모두 비활성화(선택 불가)
			    document.form.f_rhq_cd.Enable = false;
		        document.form.f_ctrl_ofc_cd.Enable = false;
		        document.form.f_rhq_cd.Index = 0;
		    	document.form.f_ctrl_ofc_cd.Index = 0; 
		    } else if(tp == '2') {//Office 비활성화, RHQ만 선택 가능
		    	document.form.f_rhq_cd.Enable = true;
	        	document.form.f_ctrl_ofc_cd.Enable = false;	
	        	document.form.f_ctrl_ofc_cd.Index = 0; 
		    } else {//RHQ 필수 선택(All 불가), Office 선택 가능
		    	document.form.f_rhq_cd.Enable = true;
	        	document.form.f_ctrl_ofc_cd.Enable = true;	     
		    }
		}          
		
		function changeHideColumn(){
		    if(document.form.f_isViewAct.checked == false)  {
		        sheetObjects[0].ColHidden("cost_act_grp_nm") = true;
		    } else {
		        sheetObjects[0].ColHidden("cost_act_grp_nm") = false;
		    }
		}

		/**
		* ifram을 이용하여 R.Lane 표시
		*/
		function f_rhq_cd_OnChange(obj, code) {
			if (loadingMode == true)
				return;
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			if (obj.Text != "") {
				formObj.f_cmd.value = SEARCHLIST13;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0081GS.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_ctrl_ofc_cd, "code", "code");
				formObj.f_ctrl_ofc_cd.Index = 0;
			}
		}

		
		
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		var formObject = document.form;
		initControl();
		loadingMode = true;
	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	    // 멀티콤보 처리
		//---------------------------------------------
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k], comboObjects[k].id);
		}
		//---------------------------------------------
		loadingMode = false;
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		formObject.f_rhq_cd.Enable = false;
		formObject.f_ctrl_ofc_cd.Enable = false;
	}
	/**
	 * 멀티콤보 항목을 설정한다.
	 */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
			Index = 0;
			DropHeight = 300;
			ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
			IMEMode=0;
			MaxLength = 6;
		}
	}
	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerForm('click',	 'obj_click',	    formObject); //- 변경될때.
	}	
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;

		switch(sheetNo) {
			case 1:	//sheet1 init
				with (sheetObj) {

					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msPrevColumnMerge;//??Merge ?? [??, Default msNone]
					Editable = false;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(15, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(false, false, false, true, false,false) ;// 해더에서 처리할 수 있는 각종 기능을 설정한다

					var HeadTitle = "H|subsum|S.Month|R.Month|Week|RHQ|Control Office|H|Cost Group|H|KPI|Volume|Expense|Unit Cost|kpiOrder";
					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,	true,	"p_report",		    	false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++,  dtHidden,   50,     daCenter,   true,   "cost_yrmonwk",   		false,  "",     dfNone,     0,  true,   true);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"cost_yrmon",			false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	true,	"cost_rmon",			false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	true,	"cost_wk",				false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		180,	daCenter,	true,	"rhq_cd",				false,	"",		dfNone,		0,	true,	true);
					
					InitDataProperty(0, cnt++ , dtData,	    180,	daCenter,	true,	"ctrl_ofc_cd",			false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,	"cost_act_grp_tp_cd",	false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	100,	daCenter,	true,	"lgs_kpi_cost_grp_nm",	false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	80,	    daLeft,		true,	"kpi_cd",	        	false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		230,	daLeft,		true,	"kpi_nm",	        	false,	"",		dfNone,		0,	true,	true);
					
					InitDataProperty(0, cnt++ , dtData,	    60,		daRight,	true,	"vol",					false,	"",		dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	90,		daRight,	true,	"total_cost",			false,	"",		dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daRight,	true,	"unit_cost",			false,	"",		dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daRight,	true,	"kpi_order",			false,	"",		dfFloat,	2,	true,	true);
					
					//HeadRowHeight  = 10;
					CountPosition  = 0 ;
					style.height = GetSheetHeight(13) ;
					
			}
				break;
		}
	}
	/**
	 * IBCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
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
	* sheet1조회후   hidden setting
	*/
	function sheet1_OnSearchEnd(sheetObj, errMessge) {
		var formObj = document.form;
    		
		//sheetObj.LastRow
		//sheetObj.CellValue(sheetObj.LastRow, "vol") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "vol");
		//1:worldwide, 2:RHQ, 3:Control Office
		//1:RHQ, 2:Control Office, 3:Sub Office
	    sheetObj.ColHidden("rhq_cd") = false;
	    sheetObj.ColHidden("ctrl_ofc_cd") = false;
	    sheetObj.ColHidden("ofc_cd") = false;
	    
	    if(sheetObj.CellValue(1, "p_report") == '1'){
		    sheetObj.ColHidden("rhq_cd") = true;
		    sheetObj.ColHidden("ctrl_ofc_cd") = true;
		    sheetObj.ColHidden("ofc_cd") = true;
 	    } else if(sheetObj.CellValue(1, "p_report") == '2'){ //2
	 	    sheetObj.ColHidden("ctrl_ofc_cd") = true;
		    sheetObj.ColHidden("ofc_cd") = true;
		}
		
	    if(formObj.f_split_mw.checked){								
			sheetObj.ShowSubSum( "p_report",               "vol",    -1, true, false, 2, "2=TOTAL" );					
			sheetObj.ShowSubSum( "cost_yrmonwk" ,          "vol",    -1, true, false, 2, "2=Mon/Week" );			
		} else {
			sheetObj.ShowSubSum( "p_report",              "vol",    -1, true, false, 9, "9=TOTAL");			    
		}	    
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
		case IBCLEAR:          //조회
	        sheetObj.WaitImageVisible = false;
			formObj.f_cmd.value = INIT;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0158GS.do", coaFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
	        
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_rhq_cd, "code", "code");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ctrl_ofc_cd, "code", "code");
			
			break;	
		case IBSEARCH:	//조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1" ) {
						// 업무처리중 버튼사용 금지 처리
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						formObj.f_cmd.value = SEARCHLIST01;
						
						// S.Month/R.Month/Week visible 조절
//						1) Period 의 Week 을 선택하고, Split by Month/Week 체크하면 : S.Month, R.Month, Week 세 칼럼 표시 → 현재의 화면과 동일 
//						Period 의 Week 을 선택하고, Split by Month/Week 체크 안하면 : S.Month, R.Month, Week 세 칼럼 모두 생략/삭제/숨기기 
//
//						2) Period 의 Month 를 선택하고, Split by Month/Week 체크하면 : (의미있는) R.Month 칼럼만 표시 
//						Period 의 Month 를 선택하고, Split by Month/Week 체크 안하면 : S.Month, R.Month, Week 세 칼럼 모두 생략

						//20100415 이중환, FormQueryString -> coaFormQueryString 변경
						// f_chkprd[0].checked : Week, f_split_mw.checked :split by Month/Week 켜짐
//						InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"cost_yrmon",			false,	"",		dfNone,		0,	true,	true);
//						InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	true,	"cost_rmon",			false,	"",		dfNone,		0,	true,	true);
//						InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	true,	"cost_wk",				false,	"",		dfNone,		0,	true,	true);
//						
//						alert(formObj.f_chkprd[0].checked+ "" +formObj.f_split_mw.checked)
						if (formObj.f_chkprd[0].checked && formObj.f_split_mw.checked)
						{
							sheetObj.ColHidden("cost_yrmon") = false;
							sheetObj.ColHidden("cost_rmon")  = false;
							sheetObj.ColHidden("cost_wk")    = false;
						}
						if (formObj.f_chkprd[0].checked && !formObj.f_split_mw.checked){
							sheetObj.ColHidden("cost_yrmon") = true;
							sheetObj.ColHidden("cost_rmon")  = true;
							sheetObj.ColHidden("cost_wk")    = true;
						}
						if (formObj.f_chkprd[1].checked && formObj.f_split_mw.checked){
							sheetObj.ColHidden("cost_yrmon") = true;
							sheetObj.ColHidden("cost_rmon")  = false;
							sheetObj.ColHidden("cost_wk")    = true;
						}
						if (formObj.f_chkprd[1].checked && !formObj.f_split_mw.checked) {
							sheetObj.ColHidden("cost_yrmon") = true;
							sheetObj.ColHidden("cost_rmon")  = true;
							sheetObj.ColHidden("cost_wk")    = true;							
						}
						sheetObj.DoSearch4Post("ESM_COA_0158GS.do", coaFormQueryString(formObj));
						ComOpenWait(false);
					}
				}
				
				break;
			case IBSAVE:	//저장
				break;

			case IBINSERT:	// 입력
				sheetObj.DataInsert();
				break;

			case IBCOPYROW:		//행복사
				sheetObj.DataCopy();
				break;

			case IBDOWNEXCEL:		//엑셀다운로드
				var excelType = selectDownExcelMethod(sheetObj);

				switch (excelType) {
					case "AY":
						sheetObj.Down2Excel(0, false, false, true);
						break;
					case "DY":
						sheetObj.Down2Excel(-1, false, false, true);
						break;
					case "AN":
						sheetObj.SpeedDown2Excel(0, false, false);
						break;
					case "DN":
						sheetObj.SpeedDown2Excel(-1, false, false);
						break;
				}

				break;

			case IBLOADEXCEL:		//엑셀업로드
				sheetObj.LoadExcel();
				break;
		}
	}
	
	/**
	* 검색시 필수입력사항 체크
	*/
	function chkValidSearch(){
		var formObj = document.form;

		with(formObj){
			if (f_year.value == "") {
				ComShowMessage(ComGetMsg("COM12114", "Year"));
				f_year.focus();
				return false;
			}
			if (f_chkprd[1].checked && f_fm_mon.value != "" && f_to_mon.value == ""){
				ComShowMessage(ComGetMsg("COM12114", "Month"))
				f_to_mon.focus();
				return false;
			}
			if (f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value != "") {
				ComShowMessage(ComGetMsg("COM12114", "Month"));
				f_fm_mon.focus();
				return false;
			}
			if (f_chkprd[1].checked && f_fm_mon.value > f_to_mon.value) {
				ComShowMessage(ComGetMsg("COA10011","Month","From","To"));
				f_to_mon.focus();
				return false;
			}			
			if (f_fm_wk.value != "" && f_to_wk.value == ""){
				ComShowMessage(ComGetMsg("COM12114", "Week"));
				f_to_wk.focus();
				return false;
			}
			if (f_fm_wk.value == "" && f_to_wk.value != ""){
				ComShowMessage(ComGetMsg("COM12114", "Week"));
				f_fm_wk.focus();
				return false;
			}
			
			if (f_fm_wk.value > f_to_wk.value) {
				ComShowMessage(ComGetMsg("COA10011","Week","From","To"));
				f_to_wk.focus();
				return false;
			}
			if(f_fm_mon.value == "" && f_fm_wk.value == ""){
				return false;
			}
			
			
			// 3 Mon or 5 Week
			for(var i=0;i<f_chkprd.length;i++)
			{
			  if(f_chkprd[i].checked) vChkPrd = f_chkprd[i].value;
			}

			if(!isValidYear(f_year,false,true)) return false;
			if(!isValidMonth(f_fm_mon,false,true)) return false;
			if(!isValidMonth(f_to_mon,false,true)) return false;
			if(!isValidWeek(f_fm_wk,false,true)) return false;
			if(!isValidWeek(f_to_wk,false,true)) return false;
		}
		return true;
	}
	
 	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (f_year.value == "") {
				ComShowMessage(ComGetMsg("COM12114", "Year"));
				f_year.focus();
				return false;
			}

			if(!isValidYear(f_year,false,true)) return false;
			if(f_fm_mon.value == "" && f_fm_wk.value == ""){
				ComShowMessage(ComGetMsg("COM12138", "Month", "Week"));
				return false;
			}
			if(f_chkprd[0].checked && f_fm_wk.value == ""  && f_to_wk.value == ""){
			    // [COM12114] : Week 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Week"));
			    f_fm_wk.focus();
			    return false;
			}
			if(f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == ""){
			    // [COM12114] : Month 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Month"));
			    f_fm_mon.focus();
			    return false;
			}

			if(!chkValidSearch()) return false;
 
//			if(f_report.selectedIndex == 2) {//control office
//			    if(f_rhq_cd.Index == 0 || f_rhq_cd.Code == '') {
//    				ComShowMessage(ComGetMsg("COM12113", "RHQ"));
//    				f_rhq_cd.focus();
//    				return false;
//			    }
//			}  // 2014.03.25 박찬민 CHM-201429466 [COA] Logistics vol. by office 화면 
		}
		return true;
	}
	
	function obj_click(){ 	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "f_chkprd":
	    	        sheetObj.RemoveAll();  
				break;
				
	    		case "f_split_mw":
	    			sheetObj.RemoveAll();  
	    		break;		    		
	    	}       
	    } 
	} 		