/*=========================================================

*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_081.js
*@FileTitle : Office/Location별 Activity
*Open Issues :
*Change history :
* 2006-11-28 Kim Youngchul 1.0 최초 생성
* 2008-02-26 전성진 CSR.No R200802265273
*					- 대상항차 조회시 WK로 조회하면 SLS_YRMON 사용하게 변경
* 2008-04-03 전성진 CSR No. N200803310003 
*					- 물류레포트 파일 분리          
* 2008-05-07 전성진 CSR No. R200804296328 
*					- css 파일 참조 확인 및 수정 
* 2008-05-09 전성진 CSR No. N200804140007 
*					- load, void vol -> teu / vol -> box 기준으로 변경, Colume에도 단위 입력.
* 					- Box/TEU 선택옵션 삭제
* 2008-07-24 김태윤 CSR No. N200803310003 
*					- 물류레포트 Vol 분리  
* 2009.10.14 최인경 ALPS New Framework 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이중환 FormQueryString -> masFormQueryString 변경
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.05.09 최윤성 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 
* 2011.06.21 이석준 [CHM-201111642-01] MAS Logistics Exp. By Office화면에서 R.Month / S.Month 구분요청
* 2011.08.31 최성민 [CHM-201113156-01] [MAS] Logistics Exp. By Office화면에서 R.Month / S.Month 구분 관련
* 2011.10.07 이석준 [CHM-201113815-01] Logistics PFMC Report 화면 수정 요청  R.Month / S.Month 구분 관련
* 2012.02.28 김종준 [CHM-201216446-01] [MAS] MAS화면 err msg 확인요청
* 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
*@LastModifyDate : 2010.04.14
*@LastModifier : 이중환
*@LastVersion : 1.1
=========================================================*/
/**
 * @fileoverview 
 * @author 한진해운
 */
/**
* @extends 
* @class ESM_MAS_0081 : ESM_MAS_0081 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
*/
function ESM_MAS_0081() {
    	this.processButtonClick		= processButtonClick;
    	this.clearDatePeriod 		= clearDatePeriod;
    	this.setPeriod 				= setPeriod;
    	this.changeKpiType 			= changeKpiType;
    	this.reportChange 			= reportChange;
    	this.changeHideColumn 		= changeHideColumn;
    	this.f_trd_cd_OnChange 		= f_trd_cd_OnChange;
    	this.changeRHQCd 			= changeRHQCd;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.sheet1_OnDblClick 		= sheet1_OnDblClick;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    	this.sheet2_OnSearchEnd		= sheet2_OnSearchEnd;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.chkValidSearch 		= chkValidSearch;
    	this.validateForm 			= validateForm;
}
    
// 공통전역변수
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
		var sheetObject1 = sheetObjects[1];

		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_new":
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					formObject.reset();
					break;

				case "btn_DownExcel":
					if(sheetObject.RowCount>0){//sheet1에 데이터가 있을때
						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					}
					if(sheetObject1.RowCount>0){//sheet2에 데이터가 있을때
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}
					break;

				case "btng_Detail":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				
				case "bu_Zoom_in1":
					if(sheetObject.Rows > 8){
						sheetObject.style.height = sheetObject.GetSheetHeight(sheetObject.Rows);
						div_zoom_out1.style.display = "inline";
						div_zoom_in1.style.display = "none";
						parent.syncHeight();
					}
					break;

				case "bu_Zoom_out1":
					if(sheetObject.Rows >8){
						sheetObject.style.height = sheetObject.GetSheetHeight(8);
						div_zoom_in1.style.display = "inline";
						div_zoom_out1.style.display = "none";
						parent.syncHeight();
					}
					break;

				case "bu_Zoom_in2":
					if(sheetObject1.Rows>8){
						sheetObject1.style.height = sheetObject1.GetSheetHeight(sheetObject1.Rows+2);
						div_zoom_out2.style.display = "inline";
						div_zoom_in2.style.display = "none";
						parent.syncHeight();
					}
					break;

				case "bu_Zoom_out2":
					if(sheetObject1.Rows>8){
						sheetObject1.style.height = sheetObject.GetSheetHeight(8);
						div_zoom_in2.style.display = "inline";
						div_zoom_out2.style.display = "none";
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
		}finally {
			ComOpenWait(false);
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
		ComMasSetPeriod(obj);
	}
	
	 //kpl
	 function changeKpiType(kpiType) {
	 	 	if(kpiType == '1') {
	 		   div_mnKpi.style.display = "inline";
	 		   div_lgsKpi.style.display = "none";
	 		   div_lgsKpi3.style.display = "none";
	 		} else if(kpiType == '2') { 
	 		   div_mnKpi.style.display = "none";
	 		   div_lgsKpi.style.display = "inline";
	 		   div_lgsKpi3.style.display = "none";
	 		} else {
	 			div_mnKpi.style.display = "none";
	 			div_lgsKpi.style.display = "none";
	 			div_lgsKpi3.style.display = "inline";
	 		}	 	    
	 }

		/**
		* ifram을 이용하여 R.Lane 표시
		*/
	    function changeLgsKpi() {
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			
			formObj.f_cmd.value = SEARCHLIST14;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0081GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) ComXml2ComboItem(arrXml[0], formObj.f_lgs_kpi_cd, "code", "name");
			if (arrXml.length > 1) ComXml2ComboItem(arrXml[1], formObj.f_lgs_kpi3_cd, "code", "name");
			formObj.f_lgs_kpi_cd.Index = 0;
			formObj.f_lgs_kpi3_cd.Index = 0;
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
	 * ifram을 이용하여 RHQ OFFICE 표시
	 */
	 function f_rhq_cd_OnChange(obj, code) {
		if (loadingMode == true)
			return;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (obj.Text != "") {
			formObj.f_cmd.value = SEARCHLIST13;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0081GS.do", masFormQueryString(formObj));
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
					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]  msPrevColumnMerge
					Editable = false;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					//MassOfSearch = 1;//대량데이타조회시
					InitColumnInfo(15, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(false, false, false, true, false,false) ;// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle = "H|subsum|S.Month|R.Month|Week|RHQ|Control Office|H|Cost Group|H|KPI|Volume (BOX)|Cost|Unit Cost|kpiOrder";
					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성	[ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,	true,	"p_report",		    false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++,  dtHidden,   50,     daCenter,   true,  	"cost_yrmonwk",   	false, "",      dfNone,     0,  true,   true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"cost_yrmon",		false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,   60,		daCenter,	true,	"cost_rmon",		false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"cost_wk",			false,	"",		dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"rhq_cd",			false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,	    100,	daCenter,	true,	"ctrl_ofc_cd",		false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daCenter,	true,	"cost_act_grp_tp_cd",false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,	    100,	daCenter,	true,	"lgs_kpi_cost_grp_nm",false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	80,	    daLeft,		true,	"kpi_cd",	        false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		140,	daLeft,		true,	"kpi_nm",	        false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,	    100,	daRight,	true,	"vol",				false,	"",	dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,	    90,		daRight,	true,	"total_cost",		false,	"",	dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	"unit_cost",		false,	"",	dfFloat,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,	80,		daRight,	true,	"kpi_order",		false,	"",	dfFloat,	2,	true,	true);

					//HeadRowHeight  = 10;
					CountPosition  = 0 ;
					style.height = GetSheetHeight(8) ;
					WaitImageVisible = false;
					
			}
				break;
			case 2:	//sheet2 init
				with (sheetObj) {

					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone] msPrevColumnMerge
					Editable = false;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo(2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					//InitRowInfo(1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]

					//MassOfSearch = 1;//대량데이타조회시
					//InitColumnInfo(11, 7, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 7, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					//InitColumnInfo(9, 7, 0, true);// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false) ;// ???? ??? ? ?? ?? ??? ????
					//var HeadTitle  = "H|RHQ|Control Office|Sub Office|Cost Group|KPI|In/Out|Volume\n(BOX)|Expense|Expense|Expense";
					//var HeadTitle1 = "H|RHQ|Control Office|Sub Office|Cost Group|KPI|In/Out|Volume\n(BOX)|Account|Amount|Unit Cost";
					var HeadTitle  = "H|RHQ|Control Office|Cost Group|KPI|In/Out|Volume\n(BOX)|Cost|Cost|Cost";
					var HeadTitle1 = "H|RHQ|Control Office|Cost Group|KPI|In/Out|Volume\n(BOX)|Account|Amount|Unit Cost";
					//var HeadTitle = "H|RHQ|Control Office|Cost Group|KPI|In/Out|Volume\n(BOX)|Amount|Unit Cost";
					
					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성	[ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,	true,	"p_report",		      false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"rhq_cd",			  false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,	    100,	daCenter,	true,	"ctrl_ofc_cd",		  false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,	    80,		daCenter,	true,	"lgs_kpi_cost_grp_nm",false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,	    140,	daLeft,		true,	"kpi_nm",	          false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,	    45,		daCenter,	true,	"in_out",		      false,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		90,	    daRight,	true,	"vol",				  false,	"",	dfFloatOrg,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		180,	daLeft,  	true,	"stnd_cost_nm",       false,	"",	dfNone,	    0,  true,	true);
					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,	"total_cost",		  false,	"",	dfFloatOrg,	2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,		80,	    daRight,	true,	"unit_cost",		  false,	"",	dfFloatOrg,	2,	true,	true);

					//HeadRowHeight  = 10;
					CountPosition  = 0 ;
					RangeBackColor(1, 7, 1, 10) = RgbColor(222, 251, 248);  // ENIS
					style.height = GetSheetHeight(8) ;
					HeadRowHeight = 20;
					WaitImageVisible = false;
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
	* sheet1을 더블클릭하여 상세조회한다
	*/
	function sheet1_OnDblClick(sheetObj, row, col){
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	}

	/**
	* sheet1을 새로 조회하면 sheet2의 데이터를 초기화한다.
	*/
	function sheet1_OnSearchEnd(sheetObj, errMessge) {
		sheetObjects[1].RemoveAll();
    		
		//sheetObj.LastRow
		//sheetObj.CellValue(sheetObj.LastRow, "vol") = docObjects[0].CellValue(docObjects[0].SelectRow, "vol");
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
		
		if(document.form.f_split_mw.checked){								
			sheetObj.ShowSubSum( "p_report",              "total_cost",    -1, true, false, 2, "2=TOTAL" );					
			sheetObj.ShowSubSum( "cost_yrmonwk" ,        "total_cost",    -1, true, false, 2, "2=Mon/Week" );			
		}else {
			sheetObj.ShowSubSum( "p_report",              "total_cost",    -1, true, false, 9, "9=TOTAL");			    
		}				
		
		sheetObj.ShowSubSum( "lgs_kpi_cost_grp_nm", "total_cost",    -1, true, false , 9, "9=CostGroup" );
	}

	/**
	* sheet2을 조회가 끝나고 volume세팅
	*/
	function sheet2_OnSearchEnd(sheetObj, errMessge) {
		//sheetObj.LastRow
		//sheetObj.CellValue(sheetObj.LastRow, "vol") = docObjects[0].CellValue(docObjects[0].SelectRow, "vol");
		//1:RHQ, 2:Control Office, 3:Sub Office
	    sheetObj.ColHidden("rhq_cd") = false;
	    sheetObj.ColHidden("ctrl_ofc_cd") = false;
	    sheetObj.ColHidden("ofc_cd") = false;

	    if(sheetObj.CellValue(2, "p_report") == '1'){
		    sheetObj.ColHidden("rhq_cd") = true;
		    sheetObj.ColHidden("ctrl_ofc_cd") = true;
		    sheetObj.ColHidden("ofc_cd") = true;
 	    } else if(sheetObj.CellValue(2, "p_report") == '2'){ //2
	 	    sheetObj.ColHidden("ctrl_ofc_cd") = true;
		    sheetObj.ColHidden("ofc_cd") = true;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
		case IBCLEAR:          //조회	    	
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0081GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
	        
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_rhq_cd, "code", "code");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ctrl_ofc_cd, "code", "code");
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], formObj.f_lgs_mn_kpi_cd, "code", "name");
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_lgs_kpi_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_lgs_kpi3_cd, "code", "name");
						
			ComOpenWait(false);
			break;		
		case IBSEARCH:	//조회
				if(validateForm(sheetObj,formObj,sAction)) {
				
					if ( sheetObj.id == "sheet1" ) {
						// 업무처리중 버튼사용 금지 처리
						ComOpenWait(true);
						formObj.f_cmd.value = SEARCHLIST01;
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
						//20100415 이중환, FormQueryString -> masFormQueryString 변경
						sheetObj.DoSearch4Post("ESM_MAS_0081GS.do", masFormQueryString(formObj));
						//ComOpenWait(false);
					}
					else if ( sheetObj.id == "sheet2" ) {
						if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
							formObj.f_cmd.value = SEARCHLIST02;
							var sheetObject = sheetObjects[0];
							//sheet1의 선택된 행들을 쿼리로
							var selrow = sheetObject.SelectRow;							
							var selValue = "";							

							selValue = sheetObject.CellValue(selrow, "cost_yrmon").replace("X", "");
							formObj.s_cost_yrmon2.value = selValue;						    
						    selValue = sheetObject.CellValue(selrow, "cost_wk").replace("X", "");
						    formObj.s_cost_wk2.value = selValue;	
							formObj.s_rhq_cd.value = sheetObject.CellValue(selrow, "rhq_cd");
							formObj.s_cntr_ofc_cd.value = sheetObject.CellValue(selrow, "ctrl_ofc_cd");
							
							formObj.s_lgs_kpi_cost_grp_cd.value = sheetObject.CellValue(selrow, "cost_act_grp_tp_cd");
							
							formObj.s_kpi_cd.value = sheetObject.CellValue(selrow, "kpi_cd");

							//20100415 이중환, FormQueryString -> masFormQueryString 변경
							sheetObj.DoSearch4Post("ESM_MAS_0081GS2.do", masFormQueryString(formObj));
						} else {
							ComShowMessage(ComGetMsg('MAS10005', 'Sheet1'));
						}
					}
				}
				
				break;
			case IBSAVE:		//저장
				break;

			case IBINSERT:	// 입력
				sheetObj.DataInsert();
				break;

			case IBCOPYROW:		//행 복사
				sheetObj.DataCopy();
				break;

			case IBDOWNEXCEL:		//엑셀 다운로드
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

			case IBLOADEXCEL:		//엑셀 업로드
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
				ComShowMessage(ComGetMsg("MAS10011","Month","From","To"));
				f_to_mon.focus();
				return false;
			}
			if(f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == ""){
			    // [COM12114] : Month 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Month"));
			    f_fm_mon.focus();
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
				ComShowMessage(ComGetMsg("MAS10011","Week","From","To"));
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
            /*
			if(vChkPrd == "M" && (ComParseInt(f_to_mon.value) - ComParseInt(f_fm_mon.value)) > 2){
				ComShowMessage(ComGetMsg("MAS10038","3 Months"));
				f_fm_mon.focus();
				return false;
    			}
    		if(vChkPrd == "W" && (ComParseInt(f_to_wk.value) - ComParseInt(f_fm_wk.value)) > 4){
    				ComShowMessage(ComGetMsg("MAS10038","5 Weeks"));
    				f_fm_wk.focus();
    				return false;
    			}
            */
			
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

			if(!chkValidSearch()) return false;
			
			if(f_report.selectedIndex == 2) {//control office
			    if(f_rhq_cd.Index == 0) {
			    	ComShowMessage(ComGetMsg("COM12113", "RHQ"));
    				f_rhq_cd.focus();
    				return false;
			    }
			    
			}
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