/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_067.js
*@FileTitle :
*Open Issues :
*Change history :  CSR No. N200801154876 주간 대상항차 기준 변경 관련 요청
                  (PFMC by ECC Pair 화면) 전윤주
*@LastModifyDate : 2008-02-28
*@LastModifier : Jeon Yunju
* 2009.02.04 김태윤 N200901190016 - MAS_조직개편 관련 기능 수정 changeCostYrmon추가, chgOffice수정
* 2009.09.16 김기식 Alps전환작업
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2013.01.16 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정 
=========================================================*/

/**
 * @fileoverview 
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_MAS_0067 : ESM_MAS_0067 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0067() {
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

				case "btng_bkgdetail":
					doActionIBSheet2(sheetObject1,formObject,IBSEARCH);
					break;

				case "btng_costdetail":
					openCostDetail();
					break;

				case "btng_downexcel":
					doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
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
					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
					Editable = false; //전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(20, 1, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다

					var HeadTitle = "POR|DEL|R.Lane|Bound|REV POL|REV POD|Type|Load|Full PFMC|Full PFMC|Full PFMC|MT Repo.\nSimulated|Full vs Simulated MT|Full vs Simulated MT|Full PFMC|Full PFMC|Full PFMC|MT Repo.\nSimulated|Full vs Simulated MT|Full vs Simulated MT";
					var HeadTitle1 = "POR|DEL|R.Lane|Bound|REV POL|REV POD|Type|Load|G.REV|Cost|CM|MT Repo.\nSimulated|Cost Saving|Credit AMT|G.REV|Cost|CM|MT Repo.\nSimulated|Cost Saving|Credit AMT" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, false);

					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"por");
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"del");
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"rlane_cd");
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"dir_cd");
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"pol");
					InitDataProperty(0, cnt++ , dtData,		55,	daCenter,	true,	"pod");
					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd");
					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,	true,	"bkg_qty",		false,	"",		dfNullFloatOrg,	2);

					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"rev",			false,	"",		dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"cost",			false,	"",		dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"cm",			false,	"",		dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"repo_cost_amt",false,	"",		dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"save",			false,	"",		dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"cr_amt",		false,	"",		dfNullFloatOrg, 2);

					//hidden
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"rev2",			false,	"|rev|/|bkg_qty|",			dfNullInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"cost2",		false,	"|cost|/|bkg_qty|",			dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"cm2",			false,	"|cm|/|bkg_qty|",			dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"repo_cost_amt2",false,	"|repo_cost_amt|/|bkg_qty|",dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"save2",		false,	"|save|/|bkg_qty|",			dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	true,	"cr_amt2",		false,	"|cr_amt|/|bkg_qty|",		dfNullFloatOrg, 2);

					RangeBackColor(1, 8, 1, 10) = RgbColor(222, 251, 248);	// ENIS
					RangeBackColor(1, 11, 1, 13) = RgbColor(222, 251, 248);	// ENIS

					RangeBackColor(1, 8, 1, 10) = RgbColor(222, 251, 248);	// ENIS
					RangeBackColor(1, 17, 1, 19) = RgbColor(222, 251, 248);	// ENIS

					HeadRowHeight	= 10;
					CountPosition	= 0 ;
					style.height = GetSheetHeight(15) ;

				}
				break;

			case 2:	//sheet2 init
				with (sheetObj) {
					SheetWidth = mainTable.clientWidth;//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
					Editable = false;//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(9, 1, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

					var HeadTitle = "BKG No.|Type|Load|Full PFMC|Full PFMC|Full PFMC|MT Repo.\nSimulated|Full vs Simulated MT|Full vs Simulated MT";
					var HeadTitle1 = "BKG No.|Type|Load|G.REV|Cost|CM|MT Repo.\nSimulated|Cost Saving|Credit AMT" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, false);

					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter	,true,	"bkg_no");
					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	"cntr_tpsz_cd");
					InitDataProperty(0, cnt++ , dtAutoSum,	60,	daRight,		true,	"bkg_qty",			false,	"",	dfNullFloatOrg,	2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	 	true,	"rev",				false,	"",	dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,		true,	"cost",				false,	"",	dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,		true,	"cm",				false,	"",	dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	 	true,	"repo_cost_amt",	false,	"",	dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	 	true,	"save",				false,	"",	dfNullFloatOrg, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,	70,	daRight,	 	true,	"cr_amt",			false,	"",	dfNullFloatOrg, 2);

					RangeBackColor(1, 4, 1, 6) = RgbColor(222, 251, 248);	// ENIS
					RangeBackColor(1, 8, 1, 9) = RgbColor(222, 251, 248);	// ENIS

					HeadRowHeight	= 10;
					CountPosition	= 0 ;
					style.height = GetSheetHeight(10) ;

				}
				break;
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
	* sheet2을 더블클릭하여 팝업을 띄운다.
	*/
	function sheet2_OnDblClick(sheetObj , row, col){
		openCostDetail();
	}


	/**
	* sheet1조회가 끝나면 hidden 처리
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		changeViewColumn(sheetObj, document.form.code.value);//
	}


	/**
	* Cost detail정보를 팝업창에서 띄워준다.
	*/
	function openCostDetail(){
		if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
			if(sheetObjects[1].RowCount>0){//sheet2에 데이터가 있을때
				var obj = sheetObjects[1];
				var cond = '';
				var row = obj.SelectRow;
				cond = cond + "&f_bkg_no=" +obj.CellValue(row, "bkg_no");
				ComOpenWindow('ESM_MAS_0066.do?'+ masFormQueryString(document.form)+cond, '_Invoice', 'width=750,height=400,menubar=0,status=0,scrollbars=0,resizable=0');
				//noRtnPopup('ESM_MAS_0066.do?'+ masFormQueryString(document.form)+cond, 'width=750,height=400,menubar=0,status=0,scrollbars=0,resizable=0');
			} else {
				ComShowMessage(ComGetMsg('MAS10005', 'Sheet2'));
			}
		} else {
			ComShowMessage(ComGetMsg('MAS10005', 'Sheet1'));
		}
	}

	/**
	* radio 버튼 클릭 시 hidden값 변경<br>
	* initSheet에서 hidden값 초기화
	*/
	function LayerView( kind ){
		changeViewColumn(sheetObjects[0], kind);
	}

	/**
	* hidden값 변경<br>
	*
	*/
	function changeViewColumn(sObj, vId){
		if ( vId == "1" ){//뒷부분	hidden
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
 			var sXml = sheetObj.GetSearchXml("ESM_MAS_0067GS.do", masFormQueryString(formObj));
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
    //changeCostYrmon
    
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
        
        ComOpenWindow2('ESM_MAS_0144.do'+param, '', 'width=600,height=450,menubar=0,status=0,scrollbars=0,resizable=0');
    }
		
	/**
	*
	*/
	function comPopupLoc(flag) {
		display = "1,0,1,1,1,1,1,1";
		param = "?cont_tp=AEF&flag="+flag;
		ComOpenPopup('/hanjin/COM_ENS_021.do' + param, 780, 500, 'getComEns021_1', display, true);	// radio PopUp
	}

	function getComEns021_1(rowArray) {
		var colArray = rowArray[0];
		//document.all.f_sc.value = colArray[8] +	colArray[9];
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
	
	/**
	*
	* year, month, week가 변경되었을때 보여지는 Period를 변경한다. 
	* (CSR No. N200801154876)
	* */
	
	function setPeriod(obj) {
		ComMasSetPeriod(obj);
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
		        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		        
		        if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_rhq_cd, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_sls_ofc_cd, "code", "code");
				
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
				formObj.f_skd_dir_cd.value = "";
				formObj.f_rlane_cd.value = "";
				formObj.f_cntr_tpsz_cd.value = getComboObjValue(formObj.f_cntr_tpsz_cd_s);				
				formObj.f_pol.value = formObj.f_pol_s.value;
				formObj.f_pod.value = formObj.f_pod_s.value;
				formObj.f_por.value = formObj.f_por_s.value;
				formObj.f_del.value = formObj.f_del_s.value;
				
				formObj.f_shipper.value = formObj.txtShipper.value;
				
				sheetObj.DoSearch4Post("ESM_MAS_0067GS.do", masFormQueryString(formObj)+"&f_sch_mode=4");
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
					var obj = sheetObjects[0];
					var cond = '';
					var row = obj.SelectRow;
					
					formObj.f_trd_cd.value = "";
					formObj.f_skd_dir_cd.value = obj.CellValue(row, "dir_cd");
					formObj.f_rlane_cd.value = obj.CellValue(row, "rlane_cd");
					formObj.f_cntr_tpsz_cd.value = obj.CellValue(row, "cntr_tpsz_cd");
					formObj.f_pol.value = obj.CellValue(row, "pol");
					formObj.f_pod.value = obj.CellValue(row, "pod");
					formObj.f_por.value = obj.CellValue(row, "por");
					formObj.f_del.value = obj.CellValue(row, "del");
					
					formObj.f_shipper.value = formObj.txtShipper.value;

					sheetObj.DoSearch4Post("ESM_MAS_0067GS2.do", masFormQueryString(formObj) + "&f_sch_mode=3");
					ComOpenWait(false);
				} else {
					ComShowMessage(ComGetMsg('MAS10005', 'Sheet1'));
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
 		    // [MAS1009] = Year 값을 확인하십시오.
 		    	ComShowCodeMessage('MAS10009','Year','YYYY');
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
	                ComShowMessage(ComGetMsg("MAS10011","Month","From","To"));
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
	 function getComboObjValue(obj){
	 	if (ComGetObjValue(obj) == "All") return "";
	 	return ComGetObjValue(obj);
	 } 
