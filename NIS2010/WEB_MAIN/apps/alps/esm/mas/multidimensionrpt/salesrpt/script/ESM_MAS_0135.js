/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0135.js
*@FileTitle : STP Income Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2007-04-06 Ari
* 1.0 최초 생성
' History :
* 2009.10.06 김기식 Alps전환작업
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================*/

/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_MAS_0135 : ESM_MAS_0135 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0135() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.setSheetObject = setSheetObject;
	this.setRetrieveAction = setRetrieveAction;
	this.viewControl = viewControl;
	this.chgOffice = chgOffice;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 공통전역변수 */
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");

		try {
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "btn_close":
					window.close();
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
		loadingMode = true;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        // 멀티콤보 처리
    	//---------------------------------------------
    	for(k=0;k<comboObjects.length;k++){
    		initCombo(comboObjects[k], comboObjects[k].id);
    	}
    	//---------------------------------------------
    	loadingMode = false;
	}
	/**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
     function initCombo (comboObj, comboId) {
     	with (comboObj) {
     		Index = 0;
     		DropHeight = 300;
     	}
     }
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var formObj = document.form;
		
		switch(sheetNo) {
			case 1:		//sheet1 init
				with (sheetObj) {

					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "")	InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msPrevColumnMerge;				//전체Merge 종류 [선택, Default msNone]
					Editable = false;				//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 1, 1, 9, 100);		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					//MassOfSearch = 1;//대량데이타조회시
					InitColumnInfo(7, 0, 0, true);	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle = "Activity\nOffice|Contract\nOffice|BKG No.|Activity|STP\nRevenue|Oth-Vol\nActivity Cost|Net STP\nIncome" ;
					InitHeadRow(0, HeadTitle, false);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

					InitDataProperty(0, cnt++, dtData,		80,	    daCenter,	true,	"");
					InitDataProperty(0, cnt++, dtData,		80,	    daCenter,	true,	"");
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	true,	"");
					InitDataProperty(0, cnt++, dtData,		200,	daCenter,	true,	"");
					InitDataProperty(0, cnt++, dtAutoSum,	90,		daRight,	true,	"stp_rev",	false,		"",		dfFloatOrg,	2);
					InitDataProperty(0, cnt++, dtAutoSum,	90,		daRight,	false,	"oth_vlo",	false,		"",		dfFloatOrg,	2);
					InitDataProperty(0, cnt++, dtAutoSum,	90,		daRight,	false,	"net_stp_income",	false,		"",		dfFloatOrg,	2);

					CountPosition	= 2 ;
					style.height = GetSheetHeight(20) ;
					viewControl("N");

				}
				break;
		}
	}
	/**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
     function setComboObject(combo_obj){
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
	
	/*화면이 로드 되면서 바로 retrieve 되도록 */
	function setRetrieveAction(){
		sheetObject = sheetObjects[0];
		formObject = document.form;
		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}
	
	/**
	 * STP Income/STP Cost 선택에 따라서 화면에 달리 보여준다.
	 */
	function viewControl(param) {
	    var formObj = document.form;
	    var sheetObj = sheetObjects[0];
	    
	    if(param == "Y"){
	        sheetObj.CellValue("0","stp_rev") = "STP\nRevenue";
	        sheetObj.ColHidden("net_stp_income") = false;
	    } else {
	        sheetObj.CellValue("0","stp_rev") = "STP\nCost";
	        sheetObj.ColHidden("net_stp_income") = true;
	        
	    }
	}
	 /**
     * Office Level 변경시 Office combo변경
     */
     function f_rhq_cd_OnChange(obj, code){
     	 if (loadingMode == true) return;  
     	 chgOffice(obj);
     }

     /**
     * 본부 콤보변경시... 
     */
     function chgOffice(obj){
     	var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if(obj.Text != ""){
        	formObj.f_cmd.value = SEARCHLIST13;
     		var sXml = sheetObj.GetSearchXml("ESM_MAS_0135GS2.do", masFormQueryString(formObj));
     		var arrXml = sXml.split("|$$|");
     		if (arrXml.length > 0)
     		ComXml2ComboItem(arrXml[0], formObj.f_sls_ofc_cd, "code", "code");
     		formObj.f_sls_ofc_cd.Index=0;
        }
     }
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCLEAR:          //조회
	    	
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0135GS2.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
		        		   
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_rhq_cd, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_sls_ofc_cd, "code", "code");
				
				ComOpenWait(false);
				break;
				
			case IBSEARCH:		//조회
				if(validateForm(sheetObj,formObj,sAction)){
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESM_MAS_0135GS.do", masFormQueryString(formObj));
					ComOpenWait(false);
				}
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
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (formObj.f_year.value == "") {
				// [COM12114] : Year 를(을) 확인하세요.
				ComShowMessage(ComGetMsg("COM12114", "Year"));
				formObj.f_year.focus();
				return false;
			}
			if (formObj.f_wk.value == "") {
				// [COM12114] : Week 를(을) 확인하세요.
				ComShowMessage(ComGetMsg("COM12114", "Week"));
				formObj.f_wk.focus();
				return false;
			}
		}

		return true;
	}
	
