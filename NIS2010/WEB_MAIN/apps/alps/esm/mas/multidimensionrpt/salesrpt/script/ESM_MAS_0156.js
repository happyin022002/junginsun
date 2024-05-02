/*
 * =========================================================
 * 주  시 스 템 : ENIS
 * 서브  시스템 : Inquiry by BKG (ABC/STP)
 * 프로그램 ID  : ESM_MAS_0156.js
 * 프로그램 명  : Inquiry by BKG (ABC/STP)
 * 프로그램개요 : Inquiry by BKG (ABC/STP)
 * 작   성   자 : Park Eun Ju
 * 작   성   일 : 2008.06.16
 * =========================================================
 *  History : N200805307021
 *  2008.09.18 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (searchBKG061List, searchBkgAbcstp156List 쿼리수정)
 *  2009.10.21 김기식 Alps전환작업 
 *  2010.02.22 이연각 업무처리중 버튼사용 금지 처리
 *  2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
 * =========================================================
 */

/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_MAS_0156 : ESM_MAS_0156 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0156() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.setSheetObject = setSheetObject;
	this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
	this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
	this.sheet3_OnSearchEnd = sheet3_OnSearchEnd;
	this.chgProfit = chgProfit;
	this.popupAbcStpUnitCost = popupAbcStpUnitCost;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
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
		var sheetObject2 = sheetObjects[2];

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "bu_zoom_in":
					sheetObject2.style.height = sheetObject2.GetSheetHeight(sheetObject2.RowCount+3);
					div_zoom_in.style.display = "none";
					div_zoom_out.style.display = "inline";
					break;

				case "bu_zoom_out":
					sheetObject2.style.height = sheetObject2.GetSheetHeight(8);
					div_zoom_in.style.display = "inline";
					div_zoom_out.style.display = "none";
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
		var title = "";
		var formObject = document.form;
		
		ComSetFocus(formObject.f_bkg_no);
		loadingMode = true;
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1, title);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		// 멀티콤보 처리
    	//---------------------------------------------
    	for(k=0;k<comboObjects.length;k++){
    		initCombo(comboObjects[k], comboObjects[k].id);
    	}
    	//---------------------------------------------
    	loadingMode = false;
		
		if(formObject.f_bkg_no.value != ""){
			ComSetObjValue(formObject.f_pro_vw,ComGetObjValue(formObject.s_pro_vw));
		    chgProfit();
		    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		}
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
	function initSheet(sheetObj,sheetNo, title) {
		var cnt = 0;
		var colCnt = 0;
		var colTotNum = 0;
		var aryTitle = new Array();
		var t1 = "";
		if (title != ""){
			t1 = title;
			aryTitle = title.split("|");
		}
		
		switch(sheetNo) {
			case 1:		//sheet1 init
				with (sheetObj) {

					SheetWidth = mainTable1.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;
					Editable = false;
					InitRowInfo(2, 1, 9, 100);
					InitColumnInfo(16, 0, 0, true);
					InitHeadMode(false, false, false, true, false, false);

					var HeadTitle = "H|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|" +
						"Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|Possible Route Inquiry|T/Time";
					var HeadTitle1 = "H|Route No|POR|Inter Change|POL|Lane|1st T/S|Lane|2nd T/S|Lane|3rd T/S|Lane|POD|Inter Change|DEL|(day)" ;

					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, false);

					InitDataProperty(0, cnt++, dtHidden,	80, daCenter, true, "rout_no");
					InitDataProperty(0, cnt++, dtData,	80, daCenter, true, "rout_no2");
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true, "por");
					InitDataProperty(0, cnt++, dtData,	90, daCenter, true, "inter1");
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true, "pol");
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true, "lane1");
					InitDataProperty(0, cnt++, dtData,	70, daCenter, true, "ts1");
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true, "lane2");
					InitDataProperty(0, cnt++, dtData,	70, daCenter, true, "ts2");
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true, "lane3");
					InitDataProperty(0, cnt++, dtData,	70, daCenter, true, "ts3");
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true, "lane4");
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true, "pod");
					InitDataProperty(0, cnt++, dtData,	80, daCenter, true, "inter2");
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true, "del");
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true, "hrs",			false, "", dfInteger, 0, true, true);

					RangeBackColor(1, 21, 1, 34) = RgbColor(222, 251, 248);

					HeadRowHeight	= 10;
					CountPosition	= 0 ;
					style.height = GetSheetHeight(6) ;
				}
				break;
			case 2:		//sheet2 init
				with (sheetObj) {
					var tot = "";
					var colWidth1 = 0;
					if (t1 != ""){
						colCnt = aryTitle.length - 1;
						colTotNum = colCnt + 2;
					} else {
						colTotNum = 2;
					}

					SheetWidth = mainTable1.clientWidth;
					if (colTotNum == 2) {
						colWidth1 = 140;
					} else {
						colWidth1 = SheetWidth / colTotNum;
					}

					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msNone;
					Editable = false;
					InitRowInfo(1, 1, 9, 100);
					InitColumnInfo(colTotNum, 0, 0, true);
					InitHeadMode(false, false, false, true, false, false);
					var HeadTitle = "TP/SZ|"+t1+"Total" ;
					InitHeadRow(0, HeadTitle, false);

					InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cntr_tpsz_cd");
					if (t1 != "") {
						for (var i=0; i<colCnt ; i++) {
							InitDataProperty(0, cnt++, dtData,	80, daRight, true, aryTitle[i], false, "", dfNullFloatOrg, 2);
						}
					}
					InitDataProperty(0, cnt++, dtData, 90, daRight, false, "b0", false, tot, dfNullFloat, 2);

					CountPosition	= 0 ;
					style.height = GetSheetHeight(4) ;
				}
				break;
			case 3:		//sheet3 init
				with (sheetObj) {
					SheetWidth = mainTable3.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly; //msPrevColumnMerge;//msHeaderOnly; //msAll;
					Editable = false;
					InitRowInfo(1, 1, 9, 100);
					InitColumnInfo(10, 0, 0, true);
					InitHeadMode(false, false, false, true, false,false);

					var HeadTitle  = "H|Contract\nOffice|Activity\nOffice|Cost Code Name|Activity Group|Activity Name|UOM|Amount" ;
					InitHeadRow(0, HeadTitle, true);

					InitDataProperty(0, cnt++, dtHidden,	100,	daCenter,	true,	"gubun");
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	true,	"ctrt_ofc_cd");
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	true,	"cond_ofc_cd");
					InitDataProperty(0, cnt++, dtData,		150,	daLeft,	    true,	"mas_cost_src_cd_nm");
					InitDataProperty(0, cnt++, dtData,		150,	daLeft,	    true,	"ofc_clss_nm");
					InitDataProperty(0, cnt++, dtData,		200,	daLeft,		true,	"sls_act_cd_nm");  // sheet 에서 보여줄 정보
					InitDataProperty(0, cnt++, dtData,		50,	    daCenter,	true,	"div_meas_cd"); // excel down 시 보요줄 정보
					InitDataProperty(0, cnt++ ,dtData,		50,		daRight,	true,	"svc_trns_prc_amt", false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++ ,dtHidden,	50,		daRight,	true,	"stp_rev", false, "", dfFloat, 2, false, false);
					InitDataProperty(0, cnt++ ,dtHidden,	50,		daRight,	true,	"oth_cost", false, "", dfFloat, 2, false, false);

//					RangeBackColor(1, 6, 1, 7) = RgbColor(222, 251, 248);

					CountPosition	= 0 ;
					style.height = GetSheetHeight(15) ;					
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
	
	/**
	* sheet1조회후 상단 정보 세팅
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		
	}

	/**
	* sheet2조회후 Total데이터 계산
	*/
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		//total값 세팅
		var Col = sheetObj.SaveNameCol("b0");
		var totalLoad = 0.00;
		var totalRev = 0.00;

		for(var k=1 ; k < Col; k++) {
			totalLoad += parseFloat(sheetObj.CellValue(1, k));
			totalRev  += parseFloat(sheetObj.CellValue(2, k));
		}

		sheetObj.CellValue2(1,Col) = totalLoad;
		sheetObj.CellValue2(2,Col) = totalRev;

		//G.RPB, CM Per Box 값 세팅
		sheetObj.CellValue2(3,Col) = totalRev/totalLoad;
	}
	
	/**
	* sheet2조회후 Total데이터 계산
	*/
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		//total값 세팅
        var formObj = document.form;
        
        if(formObj.f_pro_vw.value == "R" && formObj.f_stp_flg[0].checked){
            sheetObjects[2].ShowSubSum("gubun", "7|8|9", -1, true, false, 1, "1=Net STP Income;svc_trns_prc_amt=|stp_rev|-|oth_cost|");
        } else {
            sheetObjects[2].ShowSubSum("ctrt_ofc_cd", "7", -1, true, false, 1, "1=Total");
        }
	}
	
	function chgProfit(){
	    var formObj = document.form;
	    
	    if(formObj.f_pro_vw.value == "R"){
	        td_stp1.style.display = "block";
	        td_stp2.style.display = "none";
	    } else {
			td_stp1.style.display = "none";
			td_stp2.style.display = "block";
	    }
	}
	
	/**
	* ABC/STP Unit Cost 팝업
	*/
	function popupAbcStpUnitCost(){
		var param = '?pgmNo=ESM_MAS_0012&f_bkg_no='+document.form.f_bkg_no.value+'&pro_vw='+document.form.f_pro_vw.value;
		//ComOpenWindow('ESM_MAS_0012.do?'+param, 'ABC/STP Unit Cost', 'width=900,height=540,menubar=0,status=1,scrollbars=1,resizable=1');
		ComOpenWindow('ESM_MAS_0012.do' + param, 'Shipper Pop', 'width=1020,height=480,menubar=0,status=1,scrollbars=1,resizable=1');
        
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0156GS2.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
		        		   
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_pro_vw, "code", "name");
				
				ComOpenWait(false);
				break;
			case IBSEARCH:		//조회
				if(validateForm(sheetObj,formObj,sAction)) {
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCHLIST01;
//					sheetObj.DoSearch4Post("ESM_MAS_156GS.do", masFormQueryString(formObj));
					var xml = sheetObjects[0].GetSearchXml("ESM_MAS_0156GS.do", masFormQueryString(formObj));
				    var xml_1 = searchEtcData("xml_1", xml, "1");
				    var xml_2 = searchEtcData("xml_2", xml, "1");
				    var xml_3 = searchEtcData("xml_3", xml, "1");
				    var header= searchEtcData("header", xml, "1");
					    
				    // Form Data setting
					//------------------------------------
				    formObj.f_ctrt_ofc_cd.value = searchEtcData("f_ctrt_ofc_cd", xml, "1");
				    formObj.f_sls_ofc_cd.value = searchEtcData("f_sls_ofc_cd", xml, "1");
				    formObj.f_ioc.value = searchEtcData("f_ioc", xml, "1");
				    formObj.f_rlane.value = searchEtcData("f_rlane", xml, "1");
				    formObj.f_vvd.value = searchEtcData("f_vvd", xml, "1");
				    formObj.f_sls_yrmon.value = searchEtcData("f_sls_yrmon", xml, "1");
				    formObj.f_cost_wk.value = searchEtcData("f_cost_wk", xml, "1");
//					IBS_EtcDataToForm2(formObj, sheetObj);
					
					sheetObj.RemoveEtcData();
					//------------------------------------
					sheetObjects[0].Redraw = false;
					sheetObjects[0].LoadSearchXml(xml_1);
					sheetObjects[0].Redraw = true;
					
					// Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
					sheetObjects[1].Redraw = false;
					sheetObjects[1].RemoveAll();
					sheetObjects[1].Reset();
					initSheet(sheetObjects[1], 2, header);
					sheetObjects[1].LoadSearchXml(xml_2);	
					sheetObjects[1].Redraw = true;

					sheetObjects[2].Redraw = false;
					sheetObjects[2].LoadSearchXml(xml_3);
					sheetObjects[2].Redraw = true;
					ComOpenWait(false);
				}
				break;

			case IBDOWNEXCEL:		//엑셀 다운로드
				var excelType = selectDownExcelMethod(sheetObj);
	
				switch (excelType) {
					case "AY":
						sheetObjects[0].Down2Excel(-1, false, false, true);
						sheetObjects[1].Down2Excel(0, true, false, true);
						sheetObjects[2].Down2Excel(-1, true, false, true);
						break;
					case "DY":
						sheetObjects[0].Down2Excel(-1, false, false, true);
						sheetObjects[1].Down2Excel(-1, true, false, true);
						sheetObjects[2].Down2Excel(-1, true, false, true);
						break;
					case "AN":
						sheetObjects[0].SpeedDown2Excel(-1, false, false);
						sheetObjects[1].SpeedDown2Excel(0, true, false);
						sheetObjects[2].SpeedDown2Excel(-1, true, false);
						break;
					case "DN":
						sheetObjects[0].SpeedDown2Excel(-1, false, false);
						sheetObjects[1].SpeedDown2Excel(-1, true, false);
						sheetObjects[2].SpeedDown2Excel(-1, true, false);
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
			if (f_bkg_no.value == "") {
				ComAlertFocus(f_bkg_no, ComGetMsg("MAS10002", "bkg_no", ""));
				return false;
			}
		}

		return true;
	}	
   
	