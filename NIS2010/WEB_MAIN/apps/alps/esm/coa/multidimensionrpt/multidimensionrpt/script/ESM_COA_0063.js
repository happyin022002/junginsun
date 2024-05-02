/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0063.js
*@FileTitle :
*Open Issues :
*Change history : sheet1, sheet2 통합으로 sheet2관련 부분 삭제
*               :  CSR No. N200801154876 주간 대상항차 기준 변경 관련 요청
                  (PFMC by Office 화면) 전윤주
*@LastModifyDate : 2008-02-28
*@LastModifier : IM OKYOUNG
*              : Jeon Yunju
* 2009.02.04 김태윤 N200901190016 - COA_조직개편 관련 기능 수정 changeCostYrmon추가, chgOffice수정
* 2009.09.16 김기식 Alps전환작업 
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
=========================================================*/

/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_COA_0063 : ESM_COA_0063 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0063() {
	this.processButtonClick = processButtonClick;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initCombo 			= initCombo;
	this.setSheetObject 	= setSheetObject;
	this.setComboObject 	= setComboObject;
	this.sheet1_OnDblClick 	= sheet1_OnDblClick;
	this.sheet2_OnDblClick 	= sheet2_OnDblClick;
	this.openBKGDetail 		= openBKGDetail;
	this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
	this.layerView 			= layerView;
	this.changeViewColumn 	= changeViewColumn;
	this.setPeriod 			= setPeriod;
	this.chgOffice 			= chgOffice;
	this.changeCostYrmon 	= changeCostYrmon;
	this.fTrdCdOnChange 	= fTrdCdOnChange;
	this.comPopupLoc		= comPopupLoc;
	this.getComEns021_1 	= getComEns021_1;
	this.getComEns021_2 	= getComEns021_2;
	this.doActionIBSheet 	= doActionIBSheet;
	this.doActionIBSheet2 	= doActionIBSheet2;
	this.chkValidSearch 	= chkValidSearch;
	this.validateForm 		= validateForm;
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

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					sheetObject1.RemoveAll();
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
					break;

				case "btng_routedetail":
					doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
					break;

				case "btng_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;

				case "btng_bkgdetail":
					openBKGDetail();
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
		var formObject = document.form;
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
		
		//---------------------------------------------
        formObject.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
        formObject.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
        formObject.f_year.focus();
		
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
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
					Editable = false;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(16, 1, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

					var HeadTitle = "Trade|Bound|Type|Load|Full PFMC|Full PFMC|Full PFMC|MT Repo.\nSimulated|Full vs Simulated MT|Full vs Simulated MT|Full PFMC|Full PFMC|Full PFMC|MT Repo.\nSimulated|Full vs Simulated MT|Full vs Simulated MT";
					var HeadTitle1 = "Trade|Bound|Type|Load|G.REV|Cost|CM|MT Repo.\nSimulated|Cost Saving|Credit AMT|G.REV|Cost|CM|MT Repo.\nSimulated|Cost Saving|Credit AMT" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, false);

					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"trd_cd");
					InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"dir_cd");
					InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"cntr_tpsz_cd");
					InitDataProperty(0, cnt++ , dtAutoSum,	    60,	daRight,		true,	"bkg_qty",			false,	"",					dfNullFloatOrg,	2);

					InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	true,	"rev",				false,	"",						dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	true,	"cost",				false,	"",						dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	true,	"cm",				false,	"",						dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	120,	daRight,	true,	"repo_cost_amt",	false,	"",						dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	120,	daRight,	true,	"save",				false,	"",						dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	60,		daRight,	true,	"cr_amt",			false,	"",						dfNullFloatOrg,	2);

					//hidden
					InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	true,	"rev2",				false,	"|rev|/|bkg_qty|",			dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	true,	"cost2",			false,	"|cost|/|bkg_qty|",			dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	true,	"cm2",				false,	"|cm|/|bkg_qty|",			dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	120,	daRight,	true,	"repo_cost_amt2",	false,	"|repo_cost_amt|/|bkg_qty|",dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	120,	daRight,	true,	"save2",			false,	"|save|/|bkg_qty|",			dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	60,		daRight,	true,	"cr_amt2",			false,	"|cr_amt|/|bkg_qty|",		dfNullFloatOrg,	2);

					RangeBackColor(1, 4, 1, 6) = RgbColor(222, 251, 248);	// ENIS
					RangeBackColor(1, 8, 1, 9) = RgbColor(222, 251, 248);	// ENIS
					RangeBackColor(1, 10, 1, 12) = RgbColor(222, 251, 248);	// ENIS
					RangeBackColor(1, 14, 1, 15) = RgbColor(222, 251, 248);	// ENIS

					HeadRowHeight	= 10;
					CountPosition	= 0 ;
					style.height = GetSheetHeight(10) ;

			}
				break;
			case 2:	//sheet2 init
				with (sheetObj) {

					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
					Editable = false; //전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(14, 1, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다

					var HeadTitle = "R.Lane|Bound|REV POL|REV POD|POR|DEL|Type|Load|Full PFMC|Full PFMC|Full PFMC|MT Repo.\nSimulated|Full vs Simulated MT|Full vs Simulated MT";
					var HeadTitle1 = "R.Lane|Bound|REV POL|REV POD|POR|DEL|Type|Load|G.REV|Cost|CM|MT Repo.\nSimulated|Cost Saving|Credit AMT" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, false);

					//데이터속성	[ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter, true,	"rlane_cd",		false,		"",		dfNone,		0,	 true,		true);
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter, true,	"dir_cd",		false,		"",		dfNone,		0,	 true,		true);
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter, true,	"pol",			false,		"",		dfNone,		0,	 true,		true);
					InitDataProperty(0, cnt++ , dtData,		55,	daCenter, true,	"pod",			false,		"",		dfNone,		0,	 true,		true);
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter, true,	"por",			false,		"",		dfNone,		0,	 true,		true);
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter, true,	"del",			false,		"",		dfNone,		0,	 true,		true);
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter, true,	"cntr_tpsz_cd",	false,		"",		dfNone,		0,	 true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,  true,	"bkg_qty",		false,		"",		dfNullFloatOrg,	2,	 true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,  true,	"rev",			false,		"",		dfNullFloatOrg,	2,	 true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,  true,	"cost",			false,		"",		dfNullFloatOrg,	2,	 true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,  true,	"cm",			false,		"",		dfNullFloatOrg,	2,	 true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,  true,	"repo_cost_amt",false,		"",		dfNullFloatOrg,	2,	 true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,  true,	"save",			false,		"",		dfNullFloatOrg,	2,	 true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,  true,	"cr_amt",false,		"",		dfNullFloatOrg,	2,	 true,		true);

					RangeBackColor(1, 8, 1, 10) = RgbColor(222, 251, 248);  // ENIS
					RangeBackColor(1, 11, 1, 13) = RgbColor(222, 251, 248);  // ENIS

					HeadRowHeight  = 10;
					CountPosition  = 0 ;
					style.height = GetSheetHeight(15) ;

			}
				break;
		}
	}
	
	function getComboObjValue(obj){
    	if (ComGetObjValue(obj) == "All") return "";
    	return ComGetObjValue(obj);
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
	* IBSheet Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
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
	* sheet1을 더블클릭하여 상세조회한다
	*/
	function sheet1_OnDblClick(sheetObj , row, col){
		doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH);
	}


	/**
	* sheet2 더블클릭하여 팝업을 띄운다.
	*/
	function sheet2_OnDblClick(sheetObj , row, col){
		openBKGDetail();
	}

	/**
	* BKG detail정보를 팝업창에서 띄워준다.
	*/
	function openBKGDetail(){
		if(!validateForm(sheetObjects[0],document.form,IBSEARCH)) return false;
		if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
			if(sheetObjects[1].RowCount>0){//sheet2에 데이터가 있을때
				var cond = '';
				var obj1 = sheetObjects[0];
				var obj2 = sheetObjects[1];
				var row = obj1.SelectRow;
				var row2 = obj2.SelectRow;
				
				document.form.f_trd_cd.value = obj1.CellValue(row, "trd_cd");
				document.form.f_skd_dir_cd.value = obj2.CellValue(row2, "dir_cd");
				document.form.f_cntr_tpsz_cd.value = obj2.CellValue(row2, "cntr_tpsz_cd");
				document.form.f_rlane_cd.value = obj2.CellValue(row2, "rlane_cd");
								
				cond = cond + "&f_pol=" + obj2.CellValue(row2, "pol")
						+ "&f_pod=" + obj2.CellValue(row2, "pod")
						+ "&f_por=" + obj2.CellValue(row2, "por")
						+ "&f_del=" + obj2.CellValue(row2, "del")
						+ "&f_sch_mode=3";
				
				ComOpenWindow('ESM_COA_0065.do?' + coaFormQueryString(document.form) + cond, '_BKG'
						, 'width=750,height=400,menubar=0,status=0,scrollbars=0,resizable=0');
				
				//noRtnPopup('ESM_COA_0065.do?' + coaFormQueryString(document.form) + cond ,
				//'width=750,height=400,menubar=0,status=0,scrollbars=0,resizable=0');
			} else {
					ComShowMessage(ComGetMsg('COA10005', 'Sheet2'));
			}
		} else {
			ComShowMessage(ComGetMsg('COA10005', 'Sheet1'));
		}
	}


	/**
	* sheet1조회가 끝나면 hidden 처리
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		changeViewColumn(sheetObj, '1');//
	}

	/**
	* radio 버튼 클릭 시 hidden값 변경<br>
	* initSheet에서 hidden값 초기화
	*/
	function layerView( kind ){
		changeViewColumn(sheetObjects[0], kind);
	}

	/**
	* hidden값 변경<br>
	*
	*/
	function changeViewColumn(sObj, vId){
		if ( vId == "1" ){//뒷부분  hidden
			sObj.ColHidden("rev") = false;
			sObj.ColHidden("cost") = false;
			sObj.ColHidden("cm") = false;
			sObj.ColHidden("repo_cost_amt") = false;
			sObj.ColHidden("save") = false;
			sObj.ColHidden("cr_amt") = false;

			sObj.ColHidden("rev2") = true;
			sObj.ColHidden("cost2") = true;
			sObj.ColHidden("cm2") = true;
			sObj.ColHidden("repo_cost_amt2") = true;
			sObj.ColHidden("save2") = true;
			sObj.ColHidden("cr_amt2") = true;

		} else if ( vId == "2") {//앞부분 hidden
			sObj.ColHidden("rev") = true;
			sObj.ColHidden("cost") = true;
			sObj.ColHidden("cm") = true;
			sObj.ColHidden("repo_cost_amt") = true;
			sObj.ColHidden("save") = true;
			sObj.ColHidden("cr_amt") = true;

			sObj.ColHidden("rev2") = false;
			sObj.ColHidden("cost2") = false;
			sObj.ColHidden("cm2") = false;
			sObj.ColHidden("repo_cost_amt2") = false;
			sObj.ColHidden("save2") = false;
			sObj.ColHidden("cr_amt2") = false;
		}
	}

    /**
	*
	* year, month, week가 변경되었을때 보여지는 Period를 변경한다. 
	* (CSR No. N200801154876)
	* */
	
	function setPeriod(obj) {
		ComCoaSetPeriod(obj);
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
 			var sXml = sheetObj.GetSearchXml("ESM_COA_0063GS.do", coaFormQueryString(formObj));
 			var arrXml = sXml.split("|$$|");
 			if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.f_sls_ofc_cd, "code", "code");
 			formObj.f_sls_ofc_cd.Index=0;
         }
	}

     /*
     * 년, 월 데이터가 변경되면 ofc_cd리스트를 새로 가져온다
     */
    function changeCostYrmon(val){
        if(val != '') chgOffice(document.form.f_rhq_cd);
    }
	 /**
	  * trade변경시 R.Lane combo변경
	  */
	function f_trd_cd_s_OnChange(obj) {
		if (loadingMode == true)
			return;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (obj.Text != "") {
			formObj.f_cmd.value = SEARCHLIST11;
			formObj.f_trd_cd.value = getComboObjValue(formObj.f_trd_cd_s);
			formObj.f_skd_dir_cd.value = getComboObjValue(formObj.f_skd_dir_cd_s);
			formObj.f_cntr_tpsz_cd.value = getComboObjValue(formObj.f_cntr_tpsz_cd_s);
			formObj.f_rlane_cd.value = getComboObjValue(formObj.f_rlane_cd_s);
			
			var sXml = sheetObj.GetSearchXml("ESM_COA_0063GS.do", coaFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd_s, "code", "code");
			formObj.f_rlane_cd_s.Index = 0;
		}
	}
	 
	
	/**
     * Shipper PopUp 화면을 열어 준다
     * 
     */
    function shipperPopUp(){
        var formObj = document.form;
        var param = "";
        var tmp = formObj.f_shipper.value;
        
        formObj.f_cmd.value = "";
        if(tmp.length == 0){
			param = "?f_cust_cnt_cd=&f_cust_seq="
        }
        if(tmp.length >0 && tmp.length< 3){
            param = "?f_cust_cnt_cd=" + tmp +"&f_cust_seq="; 
        } else if(tmp.length>2) {
            param = "?f_cust_cnt_cd=" + tmp.substring(0,2) + "&f_cust_seq=" + tmp.substring(2); 
        }
        
        ComOpenWindow2('ESM_COA_0144.do'+param, '', 'width=600,height=450,menubar=0,status=0,scrollbars=0,resizable=0');
    }

	function comPopupLoc(flag) {
		display = "1,0,1,1,1,1,1,1";
		param = "?cont_tp=AEF&flag="+flag;
		ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 780, 500, 'getComEns021_1', display, true);	// radio PopUp
	}

	function getComEns021_1(rowArray) {
		var colArray = rowArray[0];
		//document.all.f_sc.value = colArray[8] + colArray[9];
		document.all.f_sc.value = colArray[2];
	}

	function getComEns021_2(rowArray) {

		var gubun = ',';

		// 초기화
		document.all.f_rfa.value = "";

		for(var i=0; i<rowArray.length; i++){
			if(i == rowArray.length-1) gubun = '';
			colArray = rowArray[i];
			document.all.f_rfa.value += colArray[8] + gubun;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCLEAR:          //조회
		        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
		        
				var sXml = document.form.sXml.value; 
				document.form.sXml.value = "";
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				var arrXml = sXml.split("|$$|");
				formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		        
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_rhq_cd, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_sls_ofc_cd, "code", "code");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_trd_cd_s, "code", "code");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_rlane_cd_s, "code", "code");
				
				if (arrXml.length > 4)
					ComXml2ComboItem(arrXml[4], formObj.f_skd_dir_cd_s, "code", "code");
				if (arrXml.length > 5)
					ComXml2ComboItem(arrXml[5], formObj.f_r_cmdt, "code", "code|name");
				if (arrXml.length > 6)
					ComXml2ComboItem(arrXml[6], formObj.f_usa_mode, "code", "code");
				if (arrXml.length > 7)
					ComXml2ComboItem(arrXml[7], formObj.f_cntr_tpsz_cd_s, "code", "code");
				
				
				ComOpenWait(false);
				break;
			case IBSEARCH:	//조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST01;
				
				formObj.f_trd_cd.value = getComboObjValue(formObj.f_trd_cd_s);
				formObj.f_skd_dir_cd.value = getComboObjValue(formObj.f_skd_dir_cd_s);
				formObj.f_cntr_tpsz_cd.value = getComboObjValue(formObj.f_cntr_tpsz_cd_s);
				formObj.f_rlane_cd.value = getComboObjValue(formObj.f_rlane_cd_s);
				
				formObj.f_shipper.value = formObj.txtShipper.value;
				
				sheetObj.DoSearch4Post("ESM_COA_0063GS.do", coaFormQueryString(formObj)+"&f_sch_mode=1");
				ComOpenWait(false);
				break;

			case IBDOWNEXCEL:	//엑셀 다운로드
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

	// Sheet관련 프로세스 처리
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:	//조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCHLIST01;
					
					var cond = '';
					var row = sheetObjects[0].SelectRow;
					
					formObj.f_trd_cd.value = sheetObjects[0].CellValue(row, "trd_cd");
					formObj.f_skd_dir_cd.value = sheetObjects[0].CellValue(row, "dir_cd");
					formObj.f_cntr_tpsz_cd.value = sheetObjects[0].CellValue(row, "cntr_tpsz_cd");
					formObj.f_rlane_cd.value = getComboObjValue(formObj.f_rlane_cd_s);
					
					formObj.f_shipper.value = formObj.txtShipper.value;
					
					sheetObj.DoSearch4Post("ESM_COA_0063GS2.do", coaFormQueryString(formObj) + "&f_sch_mode=2");
					ComOpenWait(false);
				} else {
					ComShowMessage(ComGetMsg('COA10005', 'Sheet1'));
				}
				break;

		case IBDOWNEXCEL:	//엑셀 다운로드
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
     * 검색시 필수입력사항 체크 (CSR No. N200801154876)
     */
    function chkValidSearch(){
        var formObj = document.form;

		with(formObj){
			if(f_year.value == ""){
                ComShowMessage(ComGetMsg("COM12114","Year",""));
                f_year.focus();
                return false;
            }
            if(!ComIsDate(f_year, "yyyy")){
 		    // [COA1009] = Year 값을 확인하십시오.
 		    	ComShowCodeMessage('COA10009','Year','YYYY');
 		    	f_year.focus();
 		    	return false;
 		    }
            
            if(f_chkprd[0].checked){
            	if (f_to_wk.value == ""){
	                ComShowMessage(ComGetMsg("COM12114", "week", ""));
	                f_to_wk.focus();
	                return false;
	            }
	            if (f_fm_wk.value == ""){
	                ComShowMessage(ComGetMsg("COM12114", "Week", ""));
	                f_fm_wk.focus();
	                return false;
	            }
	            if(!ComIsWeek(f_fm_wk.value)){
					ComShowMessage(ComGetMsg("COM12114", "Week"));
					f_fm_wk.focus();
					return false;
				}
				if(!ComIsWeek(f_to_wk.value)){
					ComShowMessage(ComGetMsg("COM12114", "Week"));
					f_to_wk.focus();
					return false;
				}
            }else{
            	if (f_to_mon.value == ""){
	                ComShowMessage(ComGetMsg("COM12114", "month", ""))
	                f_to_mon.focus();
	                return false;
	            }   
	            if (f_fm_mon.value == "" ) {
	                ComShowMessage(ComGetMsg("COM12114", "Month", ""));
	                f_fm_mon.focus();
	                return false;
	            }
	            if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
	                ComShowMessage(ComGetMsg("COA10011","Month","From","To"));
	                return false;
	            }
	            if(!ComIsMonth(f_fm_mon.value)){ 
					ComShowMessage(ComGetMsg("COM12114", "Month"));
					f_fm_mon.focus();
					return false;
				}
				if(!ComIsMonth(f_to_mon.value)){
					ComShowMessage(ComGetMsg("COM12114", "Month"));
					f_to_mon.focus();
					return false;
				}
            }
		}
		return true;
    }
    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 (CSR No. N200801154876)
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if (f_year.value == "") {
			    // [COM12114] : Year 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Year"));
			    f_year.focus();
				return false;
			}
			if(f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == ""){
			    // [COM12114] : Month 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Month"));
			    f_fm_mon.focus();
			    return false;
			}
			if(f_chkprd[0].checked && f_fm_wk.value == ""  && f_to_wk.value == ""){
			    // [COM12114] : Week 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Week"));
			    f_fm_wk.focus();
			    return false;
			}
		    if(!isValidYear(f_year,false,true)) return false;
		    if(!chkValidSearch()) return false;
			if(f_fm_mon.value == "" && f_fm_wk.value == ""){
			    // [COM12138] : Month 과 Week 중 하나는 입력하세요.
			    ComShowMessage(ComGetMsg("COM12138", "Month", "Week"));
			    return false;
			}
        }

        return true;
    }
    
