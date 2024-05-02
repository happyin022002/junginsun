/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0970.js
 *@FileTitle : ESM_BKG_0970
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.24
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.08.24 경종윤
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY 
 * 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가. 
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class ESM_BKG_0970 : ESM_BKG_0970 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0970() {

	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}


//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

/**
 * 콤보 Object를 comboObjects 배열에 등록
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}


//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
     var sheetObject = sheetObjects[0];

     /*******************************************************/
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn1_Retrieve":
					doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;

				case "btn1_DownExcel":
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
					break;
				case "btn_calendar":
					visibleFalse("2");

					var cal = new ComCalendarFromTo();
	                cal.select(formObject.snd_dt_from, formObject.snd_dt_to, 'yyyy-MM-dd');

					break;
					
				case "d_type0": // Declration 선택시(All)
				case "d_type1": // Declration 선택시(Discharging)
				case "d_type2": // Declration 선택시(Trasit)
				case "d_type3": // Declration 선택시(Loading)
				case "d_type4": // Declration 선택시(Pre-Carriage)
				case "d_type5": // Declration 선택시(On-Carriage)
					
					var dTypeVal = declarationCheckValue();  // 선택된 체크박스 값 구하기
					dTypeCheckValidate(dTypeVal, srcName);	// 체크 벨리데이션
					
					break;
					
				case "vvd_cd" :
				case "port_cd" :
					visibleFalse("1");
					break;
					
				case "snd_dt_from" :
				case "snd_dt_to" :
					visibleFalse("2");
					break;
					
				case "search_type" :
					if(formObject.search_type[0].checked) {
						visibleFalse("1");
					} else {
						visibleFalse("2");
					}
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
 * 조회조건 visible
 * @param searchType ("1" : VVD, PORT 활성화, "2" : Transmit Date 활성화)
 * @return
 */
function visibleFalse(searchType) {
	
	var formObject = document.form;
	
	if(searchType == "1") {
		formObject.vvd_cd.readOnly = false;
		formObject.vvd_cd.className = "input1";
		/*
		 * 2012.03.15 port_cd 0965일때 콤보 처리
		 * */
		if(formObject.call_gubun.value == "ESM_BKG_0965"){
			formObject.port_cd.BackColor = "#CCFFFD";
			formObject.port_cd.Style = 1;//0 -편집 가능,1 -편집 불가능
		}else{
			formObject.port_cd.readOnly = false;
			formObject.port_cd.className = "input1";
		}
		
		formObject.snd_dt_from.value = "";
		formObject.snd_dt_to.value = "";
		formObject.snd_dt_from.readOnly = true;
		formObject.snd_dt_from.className = "input2";
		formObject.snd_dt_to.readOnly = true;
		formObject.snd_dt_to.className = "input2";
		formObject.search_type[0].checked = true;
		
	} else {
		
		formObject.snd_dt_from.readOnly = false;
		formObject.snd_dt_from.className = "input1";
		formObject.snd_dt_to.readOnly = false;
		formObject.snd_dt_to.className = "input1";
		
		formObject.vvd_cd.value = "";
		formObject.vvd_cd.readOnly = true;
		formObject.vvd_cd.className = "input2";
		/*
		 * 2012.03.15 port_cd 0965일때 콤보 처리
		 * */
		if(formObject.call_gubun.value == "ESM_BKG_0965"){
			formObject.port_cd.Text = "";
			formObject.port_cd.BackColor = "#E8E7EC";
		}else{
			formObject.port_cd.readOnly = true;
			formObject.port_cd.className = "input2";
			formObject.port_cd.value = "";
		}
		
		formObject.search_type[1].checked = true;
		
		//날짜 셋팅
		if(formObject.snd_dt_from.value == "" && formObject.snd_dt_to.value == "") {
			initSearchDate();
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(dType, callGubun) {
	
	var formObj = document.form;
	
    for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
    }	
	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	//doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    
    //MultiCombo초기화 
    for(var k=0;k < comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	//alert("dtype : " + dType);

	// Declaration Setting
	if(callGubun == "ESM_BKG_0965") {
	
		if (dType == "") {
			formObj.d_type0.checked = true;
			formObj.d_type.value = ""; 
		} else if (dType == "D") {
			formObj.d_type1.checked = true;
			formObj.d_type.value = "D"; 
		} else if (dType == "T") {
			formObj.d_type2.checked = true;
			formObj.d_type.value = "T"; 
		} else if (dType == "L") {
			formObj.d_type3.checked = true;
			formObj.d_type.value = "L"; 
		} else if (dType == "P") {
			formObj.d_type4.checked = true;
			formObj.d_type.value = "P"; 
		} else if (dType == "O") {
			formObj.d_type5.checked = true;
			formObj.d_type.value = "O"; 
		} else {
			formObj.d_type0.checked = true;
			formObj.d_type.value = ""; 
		}
		
	} else {
		
		if(dType == "") {
			formObj.d_type[0].checked = true;
		} else if(dType == "D") {
			formObj.d_type[1].checked = true;
		} else if(dType == "T") {
			formObj.d_type[2].checked = true;
		} else if(dType == "L") {
			formObj.d_type[3].checked = true;
		} else {
			formObj.d_type[0].checked = true;
		}
	}
	setHideField(callGubun);
	
	// Declaration Setting
	if(formObj.call_gubun.value == "ESM_BKG_0965") {
		// port_cd 콤보 세팅
		doActionIBSheet(sheetObjects[0], formObj, COMMAND11);
	}
	
	//  선택적 필수 조회조건 셋팅
	visibleFalse("1");
	
	
	if(formObj.pgmNo.value != "ESM_BKG_0970") {
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}

}

/**
 * Combo Object 초기화
 * 
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comNo) {
	switch (comboObj.id) {
		case "port_cd":
			with (comboObj) {
				BackColor = "#CCFFFD";
			}
			break;
	} // end switch
}

	/**
	 * 0966화면에서 오픈시 Bl No. / Container No. / Un No. / Error Message 필드를 안 보여준다. 
	 * @return
	 */
	function setHideField(callGubun) {
		
		if(callGubun == "ESM_BKG_0966") {
			sheetObjects[0].ColHidden("bl_no") = true;
			sheetObjects[0].ColHidden("cntr_no") = true;
			sheetObjects[0].ColHidden("imdg_un_no") = true;
			//sheetObjects[0].ColHidden("cstms_err_msg") = true;
			sheetObjects[0].ColHidden("dg") = true;
		}
	}

	/**
	 * 화면 로딩 완료 후 이벤트
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		
	 }   



/**
 * declaration 필드 선택값 리턴
 * 
 * @return
 */
function declarationCheckValue() {
	
	var formObj = document.form;
	var retVal = "";

	for ( var i = 0; i <= 5; i++) {
		var dTypeFlag = "formObj.d_type" + i + ".checked";
		var dTypeValue = "formObj.d_type" + i + ".value";
		
		if (eval(dTypeFlag)) {
			retVal += eval(dTypeValue);
		}
	} // end for(i)

	return retVal;
}

/**
 * Declaration 체크 Validation
 * @return
 */
function dTypeCheckValidate(dTypeVal, srcName) {
	
	var formObj = document.form;
	
	//alert("srcName : " + srcName + "\ndTypeVal : " + dTypeVal);
	
	switch (srcName) {
	
		case "d_type0" :	// All 
			
			//alert(">> " + formObj.d_type0.checked);
			
			if(formObj.d_type0.checked) {
				formObj.d_type0.checked = true;
			} else {
				formObj.d_type0.checked = false;
			}
			
			formObj.d_type1.checked = false;
			formObj.d_type2.checked = false;
			formObj.d_type3.checked = false;
			formObj.d_type4.checked = false;
			formObj.d_type5.checked = false;
			
			break;
		case "d_type1" :	// Discharging 
			formObj.d_type0.checked = false;
			switch (dTypeVal) {
				case "AD" : 
				case "DT" :
				case "DL" :
				case "DP" :
				case "DLP" :
					formObj.d_type1.checked = false;
			
			}
			break;
		case "d_type2" : 	// Transit
			formObj.d_type0.checked = false;
			switch (dTypeVal) {
				case "AT" :
				case "DT" :
				case "TL" :
				case "TP" :
				case "TO" :
				case "TLP" :
				case "DTO" :
					formObj.d_type2.checked = false;
			}
			break;
		case "d_type3" : 	// Loading
			formObj.d_type0.checked = false;
			switch (dTypeVal) {
				case "AL" :
				case "DL" :
				case "TL" :
				case "LO" :
				case "DLO" :
					formObj.d_type3.checked = false;
			}
			break;
		case "d_type4" : 	// Pre-Carriage
			formObj.d_type0.checked = false;
			switch (dTypeVal) {
				case "AP" :
				case "DP" :
				case "TP" :
				case "PO" :
				case "DPO" :
					formObj.d_type4.checked = false;
			}
			break;
		case "d_type5" : 	// On-Carriage
			formObj.d_type0.checked = false;
			switch (dTypeVal) {
				case "AO" :
				case "TO" :
				case "LO" :
				case "PO" :
				case "LPO" :
					formObj.d_type5.checked = false;
			}
			break;
		default : 
			formObj.d_type1.checked = false;
			break;
			
	} // end switch
	
	var newType = declarationCheckValue();
	formObj.d_type.value = (newType == "LP") ? "PL" : newType;
	
}


/**
 * 날자 셋팅
 * @return
 */
function initSearchDate() {
	document.form.snd_dt_from.value=ComGetDateAdd(null, 'd', -7, '-');
	document.form.snd_dt_to.value=ComGetNowInfo('ymd','-');
}

/**
 * 날자 범위 검증(한달)
 * @return
 */
function validateSearchDate() {
//	document.form.snd_dt_from.value=ComGetDateAdd(null, 'd', -7, '-');
//	document.form.snd_dt_to.value=ComGetNowInfo('ymd','-');
	
	var formObj = document.form;
	
	var fromDt = formObj.snd_dt_from.value;
	var toDt = formObj.snd_dt_to.value;
	
	var retVal = ComGetDaysBetween(fromDt, toDt);
	
	//alert("retVal : " + retVal);
	
	
}


/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
	var sheetId = sheetObj.id;

    switch(sheetId) {

        case "sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 380;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

				var HeadTitle1 = "|Seq|Message Key Number|Sent Type|Sent Type|Transmit Date|VVD|PORT|Declaration Type|Security file Number|B/L No.|Container No.|UN No.|Status|Acknowledge Date|Approval Date|Received Error Message|DG\nInquiry|Transmit ID|cntr_cgo_seq|IMO class|Flashpoint|PG|Packings|QUANTITY|Net WGT|Grs WGT|Substance|Hazardous contents";
				var HeadTitle2 = "|Seq|Message Key Number|||Transmit Date|VVD|PORT|Declaration Type|Security file Number|B/L No.|Container No.|UN No.|Status|Acknowledge Date|Approval Date|Received Error Message|DG\nInquiry|Transmit ID|cntr_cgo_seq|IMO class|Flashpoint|PG|Packings|QUANTITY|Net WGT|Grs WGT|Substance|Hazardous contents";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++, dtHiddenStatus,  1, 		daCenter, 		true,		"ibflag");
				InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenterTop,	true,		"seq",				false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			200,	daLeftTop,		true,		"msg_snd_no",		false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,		daCenterTop,	true,		"msg_func_id",		false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenterTop,	true,		"auto_snd_tp_cd",	false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			140,	daCenterTop,	true,		"snd_dt",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenterTop,	true,		"vvd_cd",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenterTop,	true,		"port_cd",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daCenterTop,	true,		"eur_dg_decl_tp_cd",false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			150,	daCenterTop,	true,		"scr_file_no",		false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenterTop,	true,		"bl_no",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenterTop,	true,		"cntr_no",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenterTop,	true,		"imdg_un_no",		false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			150,	daCenterTop,	true,		"ack_rcv_sts_cd",	false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			130,	daCenterTop,	true,		"ack_dt",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			130,	daCenterTop,	true,		"apro_dt",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			250,	daLeftTop,		true,		"cstms_err_msg",	false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtPopup,		0,		daCenterTop,	true,		"dg",				false,		"",		dfNone,			0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenterTop,	true,		"tran_id",			false,		"",		dfNone,			0,		false,		false);

				InitDataProperty(0, cnt++ , dtHidden,		0,		daCenterTop,	true,		"cntr_cgo_seq",		false,		"",		dfNone,			0,		false,		false);
												
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenterTop,	true,		"imdg_clss_cd",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenterTop,	true,		"flsh_pnt_cdo_temp",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenterTop,	true,		"imdg_pck_grp_cd",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenterTop,	true,		"eur_pck_desc",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenterTop,	true,		"pck_qty",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenterTop,	true,		"net_wgt",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenterTop,	true,		"grs_wgt",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenterTop,	true,		"prp_shp_nm",			false,		"",		dfNone,			0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,			50,		daCenterTop,	true,		"hzd_desc",			false,		"",		dfNone,			0,		false,		false);
				
				CountPosition = 2;
				
				ShowButtonImage = 1;

				// 틀고정 설정 (vvd_cd)
				FrozenCols = 6;
				
				// 멀티로우 드로우로 선택 설정
				MultiSelection = true;
				
                // 자동 행 높이 지정
                AutoRowHeight = false;
                // 행 높이 설정
                DataRowHeight = 22;
				
		}
		break;

    }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {

		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0970GS.do", FormQueryString(formObj));
			
			sheetObj.LoadSearchXml(sXml);
			
			break;
		case IBDOWNEXCEL: // 엑셀
			if(!validateForm(sheetObj,formObj,sAction)) return false;
		
		    var columnSkipList = "";
		  
		    if(formObj.call_gubun.value == "ESM_BKG_0965") {
		    	columnSkipList = "ibflag|auto_snd_tp_cd|ack_rcv_sts_cd|ack_dt|apro_dt|cstms_err_msg|dg|tran_id|cntr_cgo_seq";
		    } else {
			    columnSkipList = "ibflag|cntr_cgo_seq|imdg_clss_cd|flsh_pnt_cdo_temp|imdg_pck_grp_cd|eur_pck_desc|pck_qty|net_wgt|grs_wgt|prp_shp_nm|hzd_desc";
		    }
		
		    sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, columnSkipList, "");
					
			break;
		case COMMAND11 : //  PORT 조회
			
			formObj.f_cmd.value = SEARCH11;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=BE&cstms_div_id=EUR_BE_PORT_LIST");
			ComXml2ComboItem(sXml, formObj.port_cd, "pod_cd", "pod_cd");
			formObj.port_cd.Code = formObj.in_port_cd.value;
			
			if(formObj.port_cd.Index < 0) formObj.port_cd.Index2 = 0;

			ComOpenWait(false);
			
			break;			
    }
}

/**
 * 시트를 클릭했을 때 처리
 */
function sheet1_OnClick(sheetObj, row, col) {

	var rowCnt = sheetObj.RowCount;
	var colSaveName = sheetObj.ColSaveName(col);

	/* Row Focus 색상 및 글자  기본값으로 변경 */
	sheetObj.SelectFontBold  = false;
	sheetObj.SelectBackColor = "16186087";
	
	switch(colSaveName) {
		/* 긴 문자열 MemoPad 처리*/
		case "cstms_err_msg" :
			
			if(sheetObj.CellValue(row,col) == "") return false;
			
			ComShowMemoPad(sheetObj, null, null, true, 400, 100);
			break;
			
	} // end switch

}


/**
 * 조회 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	
	if(ErrMsg == "") {
	
		var rowCnt = sheetObj.RowCount;
		
		/*
		 * status 값 셋팅
		 */
		for(var i = 0; i <= rowCnt; i++) {
			
			var ackRcvStsCd = sheetObj.CellValue(i, "ack_rcv_sts_cd");
			var msgSndNo = sheetObj.CellValue(i, "msg_snd_no");
			
			sheetObj.CellFontColor(i, "ack_rcv_sts_cd") = sheetObj.RgbColor(255, 255, 255);
			
			if (msgSndNo == "" && ackRcvStsCd == "") { // empty
				sheetObj.CellValue2(i, "ack_rcv_sts_cd") = "Empty Message not sent";
				sheetObj.CellBackColor(i,"ack_rcv_sts_cd") = sheetObj.RgbColor(128, 128, 128); // gray
	
			} else if (msgSndNo != "" && ackRcvStsCd == "") {
				sheetObj.CellValue2(i, "ack_rcv_sts_cd") = "Processing";
				sheetObj.CellBackColor(i,"ack_rcv_sts_cd") = sheetObj.RgbColor(128, 128, 128); // gray
			} else if (ackRcvStsCd == "A") {
				sheetObj.CellValue2(i, "ack_rcv_sts_cd") = "Sent, Accepted";
				sheetObj.CellBackColor(i,"ack_rcv_sts_cd") = sheetObj.RgbColor(0, 0, 255);	// blue
	
			} else if (ackRcvStsCd == "C") {
				sheetObj.CellValue2(i, "ack_rcv_sts_cd") = "Sent, Wrong but Acceptable";
				sheetObj.CellBackColor(i,"ack_rcv_sts_cd") = sheetObj.RgbColor(0, 128, 0); //yellowgreen
	
			} else if (ackRcvStsCd == "R") {
				sheetObj.CellValue2(i, "ack_rcv_sts_cd") = "Sent, Not Acceptable";
				sheetObj.CellBackColor(i,"ack_rcv_sts_cd") = sheetObj.RgbColor(255, 0, 0); // read
			}
	
		} // end for(i)
		
	}
	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {

		case IBSEARCH:
			
			if(formObj.d_type.value == "") {
				if(formObj.call_gubun.value == "ESM_BKG_0965") {
					formObj.d_type0.checked = true;
				} else {
					formObj.d_type.checked = true;
				}
			}
			
			if(formObj.search_type[0].checked) {
				if(formObj.call_gubun.value == "ESM_BKG_0965"){
					if(!ComChkObjValid(formObj.vvd_cd)) return false;
					
					if(formObj.port_cd.Code == "" ){
						ComShowCodeMessage('BKG00104','Port');
						return false;
					}
				}else{
					if(!ComChkObjValid(formObj.vvd_cd) || !ComChkObjValid(formObj.port_cd)) return false;
				}
			} else {
				if(!ComChkObjValid(formObj.snd_dt_from) || !ComChkObjValid(formObj.snd_dt_to)) return false;
			}
			
			if(!ComChkObjValid(formObj.bl_no) || !ComChkObjValid(formObj.cntr_no)) return false;
			
			// from - to 범위값이 31일이 넘으면 오류
			if(ComGetDaysBetween(formObj.snd_dt_from.value, formObj.snd_dt_to.value) > 30) {
				ComShowCodeMessage('BKG00605');
				ComSetFocus(formObj.snd_dt_to);
				return false;
			}
			
			break;
			
		case IBDOWNEXCEL:
			
			var rowCnt = sheetObj.RowCount;
			
			if(rowCnt == 0) {
        		ComShowCodeMessage('BKG00095');
        		return false;
			}
			
			break;
			
	} // end switch
	
	return true;

}
 
 
/**
 * 팝업버튼 클릭시 이벤트
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @returnN
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var formObj = document.form;
	
	var callGubun = formObj.call_gubun.value;
	
	with (sheetObj) {
		var sName = ColSaveName(Col);

		switch (sName) {
			case "dg":
				
				var dType = "";
				/*
				if(callGubun == "ESM_BKG_0966") { // ANTWERP 이외 지역이면
					if(formObj.d_type[1].checked) {
						dType = "D";
					} else if(formObj.d_type[2].checked) {
						dType = "T";
					} else if(formObj.d_type[3].checked) {
						dType = "L";
					}
				} else { // ANTWERP 이면
					dType = formObj.d_type.value;
				}
				*/
				
				var declarationType = sheetObj.CellValue(Row, "eur_dg_decl_tp_cd");
				if(declarationType == "Discharging") {
					dType = "D";
				} else if(declarationType == "Transit") {
					dType = "T";
				} else if(declarationType == "Loading") {
					dType = "L";
				} else if(declarationType == "Pre-carriage") {
					dType = "P";
				} else if(declarationType == "On-Carriage") {
					dType = "O";
				} else if(declarationType == "Discharging + On-Carriage") {
					dType = "DO";
				} else if(declarationType == "Pre-carriage + Loading") {
					dType = "PL";
				}
				
				sUrl = "ESM_BKG_0967.do?";
				sParam = "callGubun="+ callGubun
					+ "&d_type="+dType
					+ "&vvd_cd="+sheetObj.CellValue(Row, 'vvd_cd')
					+ "&port_cd="+sheetObj.CellValue(Row, 'port_cd')
					+ "&bl_no="+sheetObj.CellValue(Row, 'bl_no')
					+ "&cntr_no="+sheetObj.CellValue(Row, 'cntr_no')
					+ "&cntr_cgo_seq="+sheetObj.CellValue(Row, 'cntr_cgo_seq');
				
				//alert(sUrl + sParam);
				rtnVal = ComOpenWindowCenter(sUrl + sParam, "ESM_BKG_0967", 1024, 670, true);
				
				
				break;

		} // end switch

	} // end with

}


