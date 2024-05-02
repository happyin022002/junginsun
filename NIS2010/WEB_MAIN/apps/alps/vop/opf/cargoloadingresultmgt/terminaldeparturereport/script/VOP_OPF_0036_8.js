/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0036_8.js
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation

* 2011.11.07 김민아 [CHM-201114250-01] TDR내 SKD& Condition Tap 삭제 - parentTabIdx 수정
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
     * @class vop_opf_0036 : vop_opf_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0036_9() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    }

var sheetObjects = new Array();
var sheetCnt = 0;
var beforeSlotTab = 0;
var parentTabIdx = 6;
var enableButton = new Array(
								"btn_t8BsaImport",
								"btn_t8RowAdd",
								"btn_t8RowInsert",
								"btn_t8RowCopy",
								"btn_t8Delete"
							);

var mBtnDis = "N";

	document.onclick = processButtonClick;

   	/* 개발자 작업	*/

    function processButtonClick(){

		/*******************************************************/
		var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_t8RowAdd":
						var sheetObj = sheetObjCur(); //document.all.item("t8sheet" + (beforeSlotTab + 1));
						var Row = sheetObj.DataInsert(-1);
						sheetObj.SelectCell(Row, "t8sheet" + (beforeSlotTab + 1) + "_opr_cd", true);

						//Row Add시 Ratio Type저장
						if(sheetObj.id == "t8sheet1"){
							sheetObj.CellValue(Row, "t8sheet1_ratio_type") = "T";
						}
						break;
				case "btn_t8RowInsert":
						var sheetObj = sheetObjCur(); //document.all.item("t8sheet" + (beforeSlotTab + 1));
						var Row = sheetObj.DataInsert();
						sheetObj.SelectCell(Row, "t8sheet" + (beforeSlotTab + 1) + "_opr_cd", true);
						
						//Row Add시 Ratio Type저장
						if(sheetObj.id == "t8sheet1"){
							sheetObj.CellValue(Row, "t8sheet1_ratio_type") = "T";
						}
						break;
				case "btn_t8RowCopy":
						var sheetObj = sheetObjCur();
						var Row = sheetObj.DataCopy();
						sheetObj.SelectCell(Row, "t8sheet" + (beforeSlotTab + 1) + "_opr_cd", true);
						break;
				case "btn_t8Delete":
						var sheetObj = sheetObjCur(); //document.all.item("t8sheet" + (beforeSlotTab + 1));
						var prefixDel = "t8sheet" + (beforeSlotTab + 1) + "_del_chk";
						ComRowHideDelete(sheetObj, prefixDel);
						break;
				case "btn_t8BsaImport":
						parent.doActionIBSheetImport3(beforeSlotTab, parent.document.form);
						break;
				//Disch Vol Tab Change
				case "chk_Slot":
						disSlotTabChange();
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

	function sheetObjCur(){
		var sheetObj = null;
		switch(beforeSlotTab){
			case 0:
				sheetObj = document.t8sheet1;
				break;
			case 1:
				sheetObj = document.t8sheet2;
				break;
			case 2:
				sheetObj = document.t8sheet3;
				break;
			case 3:
				sheetObj = document.t8sheet4;
				break;
		}

		return sheetObj;
	}

	function disSlotTabChange(changeSheet){
		if(changeSheet == null || changeSheet == undefined)
			changeSheet = false;
			
		var formObject = document.form;
		var idx = 0;
		var oldBeforeSlotTab = beforeSlotTab;

		for(; idx < formObject.chk_Slot.length; idx++){
			if(formObject.chk_Slot[idx].checked)
				break;
		}

		if(mBtnDis == "Y"){
			if(idx == 0){
				document.all.item("btn_t8BsaImport").innerHTML = " Import Allocation";
			}else if(idx == 1){
				document.all.item("btn_t8BsaImport").innerHTML = " Import Sub Allocation";
			}else if(idx == 2){
				document.all.item("btn_t8BsaImport").innerHTML = " Import Load Vol.";
			}else if(idx == 3){
				document.all.item("btn_t8BsaImport").innerHTML = " Import BSA & Slot Swap";
			}
		}

		if(idx==0 && changeSheet){
			beforeSlotTab = idx;
			setTimeout("disSlotTabChangeExec(" + oldBeforeSlotTab + ", "+ idx + ")", 100 );
		}else if(idx == beforeSlotTab){
			return;
		}else{
			var objs = document.all.item("t8sheetDiv");
			objs[idx].style.display = "inline";
			objs[beforeSlotTab].style.display = "none";

			objs[beforeSlotTab].style.zIndex = objs[idx].style.zIndex -1 ;
			
			beforeSlotTab = idx;
			
			//2010.12.21 P.H.D. 
			parent.frameButtonSheetSub(parent.document.t8frame, idx);
			var updateSys = parent.document.form.sys_create.value.toUpperCase().substring(0, 2);
			var bEdt = false;
			
			if (updateSys != ""){
				if (idx == 1){
					if (updateSys == "IN"){
						bEdt = true;
					}
					
					var prefix = "t8sheet2_";

					if(mBtnDis == "Y"){
						sheetObjects[1].InitDataProperty(0,  3, dtAutoSumEx, 80, daRight, true, prefix + "hc_ld_20", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
						sheetObjects[1].InitDataProperty(0,  7, dtAutoSumEx, 80, daRight, true,	prefix + "hc_ld_40", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
						sheetObjects[1].InitDataProperty(0, 11, dtAutoSumEx, 80, daRight, true,	prefix + "hc_ld_45", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
					}else{
						sheetObjects[1].InitDataProperty(0,  2, dtAutoSumEx, 80, daRight, true, prefix + "hc_ld_20", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
						sheetObjects[1].InitDataProperty(0,  6, dtAutoSumEx, 80, daRight, true,	prefix + "hc_ld_40", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
						sheetObjects[1].InitDataProperty(0, 10, dtAutoSumEx, 80, daRight, true,	prefix + "hc_ld_45", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
					}
				}
			}
		}
	}

	
	function disSlotTabChangeExec(beforeSlotTab, idx){
		var objs = document.all.item("t8sheetDiv");

		objs[beforeSlotTab].style.display = "none";
		objs[idx].style.display = "inline";

		objs[beforeSlotTab].style.zIndex = objs[idx].style.zIndex -1 ;
	}
	

	function slotTabButton(){
		if(beforeSlotTab == 0){
			document.all.item("btn_t8BsaImport").innerHTML = " Import Allocation";

			if(parent.document.form.sys_create.value.toUpperCase().substring(0, 2) == "IN"){
				ComBtnEnable("btn_t8BsaImport");
			}else{
				ComBtnDisable("btn_t8BsaImport");
			}

			ComBtnDisable("btn_t8RowAdd");
			ComBtnDisable("btn_t8RowInsert");
			ComBtnDisable("btn_t8RowCopy");
			ComBtnDisable("btn_t8Delete");
			
		}else if(beforeSlotTab == 1){
			document.all.item("btn_t8BsaImport").innerHTML = " Import Sub Allocation";

			if(parent.document.form.sys_create.value.toUpperCase().substring(0, 2) == "IN"){
				ComBtnEnable("btn_t8BsaImport");
			}else{
				ComBtnDisable("btn_t8BsaImport");
			}

			ComBtnDisable("btn_t8RowAdd");
			ComBtnDisable("btn_t8RowInsert");
			ComBtnDisable("btn_t8RowCopy");
			ComBtnDisable("btn_t8Delete");
		}else if(beforeSlotTab == 2){
			document.all.item("btn_t8BsaImport").innerHTML = " Import Load Vol.";

			if(parent.document.form.sys_create.value.toUpperCase().substring(0, 2) == "IN"){
				ComBtnEnable("btn_t8BsaImport");

				ComBtnEnable("btn_t8RowAdd");
				ComBtnEnable("btn_t8RowInsert");
				ComBtnEnable("btn_t8RowCopy");
				ComBtnEnable("btn_t8Delete");
			}else{
				ComBtnDisable("btn_t8BsaImport");
				ComBtnDisable("btn_t8RowAdd");
				ComBtnDisable("btn_t8RowInsert");
				ComBtnDisable("btn_t8RowCopy");
				ComBtnDisable("btn_t8Delete");
			}
		}else{
			document.all.item("btn_t8BsaImport").innerHTML = " Import BSA & Slot Swap";
			
			if(parent.document.form.sys_create.value.toUpperCase().substring(0, 2) == "IN"){
				ComBtnEnable("btn_t8RowAdd");
				ComBtnEnable("btn_t8RowInsert");
				ComBtnEnable("btn_t8RowCopy");
				ComBtnEnable("btn_t8Delete");
			}else{
				ComBtnDisable("btn_t8BsaImport");
				ComBtnDisable("btn_t8RowAdd");
				ComBtnDisable("btn_t8RowInsert");
				ComBtnDisable("btn_t8RowCopy");
				ComBtnDisable("btn_t8Delete");
			}
		}
	}

	/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(btnDis) {
		mBtnDis = btnDis;
		//Disable Button;
		// IBMultiCombo초기화
        for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		if(parent.bRetrive){
			parent.doActionIBSheetMulti(parentTabIdx, parent.document.form);
			parent.setTabEditSheet();
		}
		
		//2010.12.21 P.H.D. 
		//parent.frameButtonSheet(parent.document.t8frame, parent.readonlStatus());
		//2011.10.28 0042소스에는 해당 함수가 없어 스크립트 에러발생하여 0036만 해당 함수를 call 할 수 있도록 분기함
		if(mBtnDis == "Y"){
			parent.frameButtonSheetSub(parent.document.t8frame, 0);
		}
		parent.topSync();
    }

	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
    }
	
	function initSheet(sheetObj,sheetNo) {
		var cnt= 0;
		var mustInput = (mBtnDis == "Y" ? true : false); 
		switch(sheetObj.id){
			case "t8sheet1":
                with (sheetObj) {
										// 높이 설정
                    style.height = 360;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = (mBtnDis == "Y" ? true : false);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
					
					var HeadTitle1 = "";
					var HeadTitle2 = "";

					if(mBtnDis == "Y"){
						HeadTitle1 = "|Sel";
						HeadTitle2 = "|Sel";
					}

					HeadTitle1 = HeadTitle1 + "|Operator|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Weight\nper TEU|BSA Type|Ratio\nType";
					HeadTitle2 = HeadTitle2 + "|Operator|Basic Slot|Slot Swap|Slot Release|TTL Allocation|Basic WGT|WGT Swap|WGT Release|TTL Weight|Weight\nper TEU|BSA Type|Ratio\nType";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t8sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		prefix + "ibflag");
					if(mBtnDis == "Y"){
						InitDataProperty(0, cnt++ , dtCheckBox,				30,		daCenter,	true,		prefix + "del_chk");
					}
					InitDataProperty(0, cnt++ , dtPopupEdit,			120,	daCenter,	true,		prefix + "opr_cd",					mustInput,	"",		dfEngUpKey,		0,		false,		true, 3);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			85,		daRight,	true,		prefix + "bsa_slot",				false,		"",		dfInteger,		0,		true,		true, 5);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			85,		daRight,	true,		prefix + "swap_slot",				false,		"",		dfInteger,		0,		true,		true, 5);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			85,		daRight,	true,		prefix + "release_slot",			false,		"",		dfInteger,		0,		true,		true, 5);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			85,		daRight,	true,		prefix + "ttl_alloc",				false,		"",		dfInteger,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			85,		daRight,	true,		prefix + "bsa_wgt",					false,		"",		dfFloat,		1,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			85,		daRight,	true,		prefix + "swap_wgt",				false,		"",		dfFloat,		1,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			85,		daRight,	true,		prefix + "release_wgt",				false,		"",		dfFloat,		1,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			85,		daRight,	true,		prefix + "ttl_weight",				false,		"",		dfFloat,		1,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					80,		daRight,	true,		prefix + "teu",						false,		"",		dfFloat,		3,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,				60,		daCenter,	true,		prefix + "bsa_type",				false,		"",		dfNone,			1,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,				60,		daCenter,	true,		prefix + "ratio_type",				false,		"",		dfNone,			1,		true,		true);
		//dtHidden
					InitDataCombo(0, prefix + "bsa_type", "Used|Fixed", "U|F");
					InitDataCombo(0, prefix + "ratio_type", "Ton|Weight", "T|W");
				}
				break;
			case "t8sheet2":
                with (sheetObj) {
										// 높이 설정
                    style.height = 360;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = (mBtnDis == "Y" ? true : false);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "";
					var HeadTitle2 = "";

					if(mBtnDis == "Y"){
						HeadTitle1 = "|Sel";
						HeadTitle2 = "|Sel";
					}

					HeadTitle1 = HeadTitle1 +  "|Operator|20 High Cubic|20 High Cubic|20 High Cubic|20 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|45'|45'|45'|45'|45'";
					HeadTitle2 = HeadTitle2 +  "|Operator|Loaded|BSA(T)|Over Ratio(T)|Add Slot(T)|Loaded|BSA(F)|Over Ratio(F)|Add Slot(T)|Loaded|BSA(F)|Under Ratio(F)|Over Ratio(F)|Add Slot(T)";

					var headCount = ComCountHeadTitle(HeadTitle2);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t8sheet2_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		prefix + "ibflag");
					if(mBtnDis == "Y"){
						InitDataProperty(0, cnt++ , dtCheckBox,				30,		daCenter,	true,		prefix + "del_chk");
					}
					InitDataProperty(0, cnt++ , dtPopupEdit,			80,		daCenter,	true,		prefix + "opr_cd",					mustInput,	"",		dfEngUpKey,		0,		false,		true, 4);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			80,		daRight,	true,		prefix + "hc_ld_20",				false,		"",		dfInteger,		0,		true,		true, 4);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			80,		daRight,	true,		prefix + "hc_bsa_20",				false,		"",		dfInteger,		0,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					85,		daRight,	true,		prefix + "hc_or_20",				false,		"",		dfFloat,		3,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			80,		daRight,	true,		prefix + "hc_add_20",				false,		"",		dfInteger,		0,		false,		false, 6);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			80,		daRight,	true,		prefix + "hc_ld_40",				false,		"",		dfInteger,		0,		true,		true, 4);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			80,		daRight,	true,		prefix + "hc_bsa_40",				false,		"",		dfInteger,		0,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					85,		daRight,	true,		prefix + "hc_or_40",				false,		"",		dfFloat,		3,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			80,		daRight,	true,		prefix + "hc_add_40",				false,		"",		dfInteger,		0,		false,		false, 6);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			80,		daRight,	true,		prefix + "hc_ld_45",				false,		"",		dfInteger,		0,		true,		true, 4);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			80,		daRight,	true,		prefix + "hc_bsa_45",				false,		"",		dfInteger,		0,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					85,		daRight,	true,		prefix + "hc_ur_45",				false,		"",		dfFloat,		3,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					85,		daRight,	true,		prefix + "hc_or_45",				false,		"",		dfFloat,		3,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			80,		daRight,	true,		prefix + "hc_add_45",				false,		"",		dfInteger,		0,		false,		false, 6);
					//InitDataProperty(0, cnt++ , dtAutoSum,				80,		daCenter,	true,		prefix + "ratio_type",				false,		"",		dfNone,			0,		false,		false, 6);

					if(mBtnDis == "Y")
						FrozenCols = 3;
					else
						FrozenCols = 2;
				}
				break;

			case "t8sheet3":
				slotPortDep(sheetObj);
				break;

			case "t8sheet4":
				slotPortDep(sheetObj);
				break;
		}

	}


	function slotPortDep(sheetObj){
		var cnt = 0;
		var mustInput = (mBtnDis == "Y" ? true : false); 
		with (sheetObj) {
								// 높이 설정
			style.height = 358;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = (mBtnDis == "Y" ? true : false);

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "";
			var HeadTitle2 = "";

			if(mBtnDis == "Y"){
				HeadTitle1 = "|Sel";
				HeadTitle2 = "|Sel";
			}

			if(sheetObj.id == "t8sheet3"){
				HeadTitle1 = HeadTitle1 + "|Operator|Status|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|Grand TTL Used Slot|Grand TTL Used Slot";
				HeadTitle2 = HeadTitle2 + "|Operator|Status|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)";
			}else if(sheetObj.id == "t8sheet4"){
				HeadTitle1 = HeadTitle1 + "|Operator|Status|Ratio_TP|Bsa_TP|Teu|realse_slot|realse_weight|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|Add Slot\n(HC/45)|Grand TTL Used Slot|Grand TTL Used Slot|BSA\n(+ Slot Swap)|BSA\n(+ Slot Swap)|Over Used Slot|Over Used Slot|Over Slot Settlement|Over Slot Settlement";
				HeadTitle2 = HeadTitle2 + "|Operator|Status|Ratio_TP|Bsa_TP|Teu|realse_slot|realse_weight|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|Add Slot\n(HC/45)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot(TEU)|By";
			}

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var cellCol = "";
			
			if(sheetObj.id == "t8sheet3")
				cellCol = "trade_full|trade_mt|trade_ab|trade_sub_slot|trade_sub_wgt|inter_full|inter_mt|inter_ab|inter_sub_slot|inter_sub_wgt|grand_ttl_slot|grand_ttl_wgt";
			else if(sheetObj.id == "t8sheet4")
				cellCol = "trade_full|trade_mt|trade_ab|trade_sub_slot|trade_sub_wgt|inter_full|inter_mt|inter_ab|inter_sub_slot|inter_sub_wgt|inter_45|grand_ttl_slot|grand_ttl_wgt|bsa_slot|bsa_wgt|over_slot|over_wgt|over_settle|over_settle_by";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = sheetObj.id + "_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		prefix + "ibflag");
			if(mBtnDis == "Y"){
				InitDataProperty(0, cnt++ , dtCheckBox,				30,		daCenter,	true,		prefix + "del_chk");
			}
			InitDataProperty(0, cnt++ , dtPopupEdit,			80,		daCenter,	true,		prefix + "opr_cd",					mustInput,	"",		dfEngUpKey,		0,		false,		true, 3);
			InitDataProperty(0, cnt++ , dtHidden,				80,		daCenter,	true,		prefix + "status",					true,		"",		dfEngUpKey,		0,		false,		true, 3);

			if(sheetObj.id == "t8sheet4"){
				InitDataProperty(0, cnt++ , dtHidden,		60,		dtHidden,	true,		prefix + "ratio_type",				false,		"",		dfNone,			0,		false,		false, 3);
				InitDataProperty(0, cnt++ , dtHidden,		60,		dtHidden,	true,		prefix + "bsa_type",				false,		"",		dfNone,			0,		false,		false, 3);
				InitDataProperty(0, cnt++ , dtHidden,		60,		dtHidden,	true,		prefix + "teu",						false,		"",		dfFloat,		0,		false,		false, 6);
				InitDataProperty(0, cnt++ , dtHidden,		60,		dtHidden,	true,		prefix + "release_slot",			false,		"",		dfFloat,		0,		false,		false, 6);
				InitDataProperty(0, cnt++ , dtHidden,		60,		dtHidden,	true,		prefix + "release_wgt",				false,		"",		dfFloat,		0,		false,		false, 6);
			}

			var arrCol = cellCol.split("|");
			//over_slot|over_wgt|over_settle|over_settle_by
			for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
				if(arrCol[idxCol] == "trade_sub_wgt" || arrCol[idxCol] == "inter_sub_wgt")	//Float고 작성가능.
					InitDataProperty(0, cnt++ , dtAutoSumEx,			70,	daRight,	true,		prefix + arrCol[idxCol],				false,		"",		dfFloat,		1,		true,		true, 7);
				else if(arrCol[idxCol] == "trade_sub_slot" || arrCol[idxCol] == "inter_sub_slot" || arrCol[idxCol] == "grand_ttl_slot" || arrCol[idxCol] == "bsa_slot" || arrCol[idxCol] == "over_slot" || arrCol[idxCol] == "inter_45")	//Integer고 작성불가능.
					InitDataProperty(0, cnt++ , dtAutoSumEx,			70,	daRight,	true,		prefix + arrCol[idxCol],				false,		"",		dfInteger,		1,		false,		false);
				else if(arrCol[idxCol] == "grand_ttl_wgt" || arrCol[idxCol] == "bsa_wgt" || arrCol[idxCol] == "over_wgt" || arrCol[idxCol] == "over_settle")					//Float고 작성불가능.
					InitDataProperty(0, cnt++ , dtAutoSumEx,			70,	daRight,	true,		prefix + arrCol[idxCol],				false,		"",		dfInteger,		0,		false,		false);
				else if(arrCol[idxCol] == "over_settle_by")
					InitDataProperty(0, cnt++ , dtCombo,				65,	daCenter,	false,		prefix + arrCol[idxCol],				false,		"",		dfNone,			0,		false,		false);
				else
					InitDataProperty(0, cnt++ , dtAutoSumEx,			70,	daRight,	true,		prefix + arrCol[idxCol],				false,		"",		dfInteger,		0,		true,		true, 4);
			}

			if(sheetObj.id == "t8sheet4")
				InitDataCombo(0, prefix + "over_settle_by", " |Slot|Weight|Fixed|Used", " |S|W|F|U");
			
			if(mBtnDis == "Y"){
				FrozenCols = 4;
			}
			InitDataValid(0, prefix + "opr_cd", vtEngUpOnly);
		}
	}

	function t8sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t8sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t8sheet1;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t8sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}

		if(sheetObj.ColSaveName(OldCol) == "t8sheet1_opr_cd" && sheetObj.CellValue(OldRow, "t8sheet1_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
	}

	function t8sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t8sheet1_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t8sheet1_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

	function t8sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t8sheet1_";

		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t8sheet1_opr_cd");	//imdg_segr_grp_no Value Duplication Check
		}

		if(sheetObj.ColSaveName(Col) == prefix + "bsa_slot" || sheetObj.ColSaveName(Col) == prefix + "swap_slot" || sheetObj.ColSaveName(Col) == prefix + "release_slot"){
			var ttl_alloc = parseInt(sheetObj.CellValue(Row, prefix + "bsa_slot")) + 
							parseInt(sheetObj.CellValue(Row, prefix + "swap_slot")) +
							parseInt(sheetObj.CellValue(Row, prefix + "release_slot"));
			
			sheetObj.CellValue(Row, prefix + "ttl_alloc") = ttl_alloc;
		}

		if(sheetObj.ColSaveName(Col) == prefix + "bsa_wgt" || sheetObj.ColSaveName(Col) == prefix + "swap_wgt" || sheetObj.ColSaveName(Col) == prefix + "release_wgt"){
			var ttl_alloc = parseFloat(sheetObj.CellValue(Row, prefix + "bsa_wgt")) + 
							parseFloat(sheetObj.CellValue(Row, prefix + "swap_wgt")) +
							parseFloat(sheetObj.CellValue(Row, prefix + "release_wgt"));
			
			sheetObj.CellValue(Row, prefix + "ttl_weight") = ttl_alloc;
		}

		if(sheetObj.ColSaveName(Col) == prefix + "release_slot" || sheetObj.ColSaveName(Col) == prefix + "release_wgt"){
			if(parseFloat(sheetObj.CellValue(Row, prefix + "release_slot")) > 0 || parseFloat(sheetObj.CellValue(Row, prefix + "release_wgt")) > 0){
				sheetObj.CellValue(Row, prefix + "bsa_type") = "F";
			}else if(parseFloat(sheetObj.CellValue(Row, prefix + "release_slot")) == 0 && parseFloat(sheetObj.CellValue(Row, prefix + "release_wgt")) == 0){
				sheetObj.CellValue(Row, prefix + "bsa_type") = "U";
			}
		}
	}

	function t8sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t8sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t8sheet2;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t8sheet2_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}
		if(sheetObj.ColSaveName(OldCol) == "t8sheet2_opr_cd" && sheetObj.CellValue(OldRow, "t8sheet2_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
	}

	function t8sheet2_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t8sheet2_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t8sheet2_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

	function t8sheet2_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t8sheet2_";
		
		with(sheetObj){

			if(ColSaveName(Col) == prefix + "opr_cd"){
				parent.duplCheck(sheetObj, Row, Col, Value, "t8sheet2_opr_cd");	//imdg_segr_grp_no Value Duplication Check
			}

			//{(Loaded – 20’ High Cubic Sub Allocation) x Over Ratio} x 2, 소수점 2째자리 반올림 (I-Stowage 에서 제공)
			if(ColSaveName(Col) == prefix + "hc_ld_20" || ColSaveName(Col) == prefix + "hc_bsa_20" || ColSaveName(Col) == prefix + "hc_or_20"){
				if(parseInt(CellValue(Row,  prefix + "hc_ld_20")) > 0 && parseInt(CellValue(Row,  prefix + "hc_bsa_20")) > 0 && parseFloat(CellValue(Row,  prefix + "hc_or_20")) > 1){
					if(parseInt(CellValue(Row,  prefix + "hc_ld_20")) > parseInt(CellValue(Row,  prefix + "hc_bsa_20"))){
						var addSlot = 
						( 
							parseInt(CellValue(Row,  prefix + "hc_ld_20")) - parseInt(CellValue(Row,  prefix + "hc_bsa_20"))
						) *
						(CellValue(Row,  prefix + "hc_or_20") - 1);
 
						CellValue(Row,  prefix + "hc_add_20") = ComRound(addSlot);
					}else{
						CellValue(Row,  prefix + "hc_add_20") = "0";
					}
				}else{
					CellValue(Row,  prefix + "hc_add_20") = "0";
				}
			}
			 
			 //{(Loaded – 40’ High Cubic Sub Allocation) x Over Ratio} x 2, 소수점 2째자리 반올림 (I-Stowage 에서 제공)
			if(ColSaveName(Col) == prefix + "hc_ld_40" || ColSaveName(Col) == prefix + "hc_bsa_40" || ColSaveName(Col) == prefix + "hc_or_40"){
				if(parseInt(CellValue(Row,  prefix + "hc_ld_40")) > 0 && parseInt(CellValue(Row,  prefix + "hc_bsa_40")) > 0 && parseFloat(CellValue(Row,  prefix + "hc_or_40")) > 1){
					if(parseInt(CellValue(Row,  prefix + "hc_ld_40")) > parseInt(CellValue(Row,  prefix + "hc_bsa_40"))){
						var addSlot = 
						( 
							parseInt(CellValue(Row,  prefix + "hc_ld_40")) - parseInt(CellValue(Row,  prefix + "hc_bsa_40"))
						) *
						(CellValue(Row,  prefix + "hc_or_40") - 1) * 2;

						CellValue(Row,  prefix + "hc_add_40") = ComRound(addSlot);
					}else{
						CellValue(Row,  prefix + "hc_add_40") = "0";
					}
				}else{
					CellValue(Row,  prefix + "hc_add_40") = "0";
				}
			}

			//IF HC_LD_45 > HC_BSA_45 THEN (( HC_LD_45 - HC_BSA_45 ) * HC_OR_45 * 2 ) ELSE (( HC_BSA_45 - HC_LD_45 ) * HC_UR_45 * 2 )
			if(ColSaveName(Col) == prefix + "hc_ld_45" || ColSaveName(Col) == prefix + "hc_bsa_45" || ColSaveName(Col) == prefix + "hc_or_40" || ColSaveName(Col) == prefix + "hc_or_45"){
				if(parseInt(CellValue(Row,  prefix + "hc_ld_45")) > 0 && parseInt(CellValue(Row,  prefix + "hc_bsa_45")) > 0){
					//Under일 경우...
					if(
						( parseInt(CellValue(Row,  prefix + "hc_ld_45")) <= parseInt(CellValue(Row,  prefix + "hc_bsa_45")) ) &&
						( parseFloat(CellValue(Row,  prefix + "hc_ur_45")) > 1 ) 
					   ){
						var addSlot = parseInt(CellValue(Row,  prefix + "hc_ld_45")) * (CellValue(Row,  prefix + "hc_ur_45") - 1) * 2;
						CellValue(Row,  prefix + "hc_add_45") = ComRound(addSlot);
					//Over의 경우.
					}else if(
						( parseInt(CellValue(Row,  prefix + "hc_ld_45")) > parseInt(CellValue(Row,  prefix + "hc_bsa_45")) ) &&
						( parseFloat(CellValue(Row,  prefix + "hc_ur_45")) > 1 )  && ( parseFloat(CellValue(Row,  prefix + "hc_or_45")) > 1 )
					   ){
						var addSlot = ( parseInt(CellValue(Row,  prefix + "hc_bsa_45")) * (CellValue(Row,  prefix + "hc_ur_45") - 1) * 2 ) + 
									  ( (	parseInt(CellValue(Row,  prefix + "hc_ld_45")) -
											parseInt(CellValue(Row,  prefix + "hc_bsa_45"))
										)
										* (CellValue(Row,  prefix + "hc_or_45") - 1) * 2 )
							          ;
						CellValue(Row,  prefix + "hc_add_45") = ComRound(addSlot);
					}else{
						CellValue(Row,  prefix + "hc_add_45") = "0";
					}
				}else{
					CellValue(Row,  prefix + "hc_add_45") = "0";
				}
			}
		}
	}

	function t8sheet3_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t8sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t8sheet3;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t8sheet3_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}
		if(sheetObj.ColSaveName(OldCol) == "t8sheet3_opr_cd" && sheetObj.CellValue(OldRow, "t8sheet3_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
	}

	function t8sheet3_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t8sheet3_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t8sheet3_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

	function t8sheet3_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t8sheet3_";
		
		with(sheetObj){

			if(ColSaveName(Col) == prefix + "opr_cd"){
				parent.duplCheck(sheetObj, Row, Col, Value, "t8sheet3_opr_cd");	//imdg_segr_grp_no Value Duplication Check
			}

			//{(Loaded – 20’ High Cubic Sub Allocation) x Over Ratio} x 2, 소수점 2째자리 반올림 (I-Stowage 에서 제공)
			if(ColSaveName(Col) == prefix + "trade_full" || ColSaveName(Col) == prefix + "trade_mt" || ColSaveName(Col) == prefix + "trade_ab"){
				CellValue(Row, prefix + "trade_sub_slot") = parseInt(CellValue(Row, prefix + "trade_full")) +
					                                        parseInt(CellValue(Row, prefix + "trade_mt")) +
															parseInt(CellValue(Row, prefix + "trade_ab")) ;

				CellValue(Row, prefix + "grand_ttl_slot") = parseInt(CellValue(Row, prefix + "trade_sub_slot")) + parseInt(CellValue(Row, prefix + "inter_sub_slot"));
			}

			if(ColSaveName(Col) == prefix + "inter_full" || ColSaveName(Col) == prefix + "inter_mt" || ColSaveName(Col) == prefix + "inter_ab"){
				CellValue(Row, prefix + "inter_sub_slot") = parseInt(CellValue(Row, prefix + "inter_full")) +
					                                        parseInt(CellValue(Row, prefix + "inter_mt")) +
															parseInt(CellValue(Row, prefix + "inter_ab")) ;

				CellValue(Row, prefix + "grand_ttl_slot") = parseInt(CellValue(Row, prefix + "trade_sub_slot")) + parseInt(CellValue(Row, prefix + "inter_sub_slot"));
			}
			
			//Weight가 메롱.....
			if(ColSaveName(Col) == prefix + "trade_sub_wgt" || ColSaveName(Col) == prefix + "inter_sub_wgt"){
				CellValue(Row, prefix + "grand_ttl_wgt") =	parseInt(CellValue(Row, prefix + "trade_sub_wgt")) +
															parseInt(CellValue(Row, prefix + "inter_sub_wgt")) ;
			}
		}
	}

	function t8sheet4_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t8sheet4_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t8sheet4;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t8sheet4_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}
		if(sheetObj.ColSaveName(OldCol) == "t8sheet4_opr_cd" && sheetObj.CellValue(OldRow, "t8sheet4_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
	}

	function t8sheet4_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t8sheet4_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t8sheet4_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

	function t8sheet4_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t8sheet4_";
 
		with(sheetObj){

			if(ColSaveName(Col) == prefix + "opr_cd"){
				parent.duplCheck(sheetObj, Row, Col, Value, "t8sheet4_opr_cd");	//imdg_segr_grp_no Value Duplication Check
			}

			//{(Loaded – 20’ High Cubic Sub Allocation) x Over Ratio} x 2, 소수점 2째자리 반올림 (I-Stowage 에서 제공)
			if(ColSaveName(Col) == prefix + "trade_full" || ColSaveName(Col) == prefix + "trade_mt" || ColSaveName(Col) == prefix + "trade_ab"){
				CellValue(Row, prefix + "trade_sub_slot") = parseInt(CellValue(Row, prefix + "trade_full")) +
					                                        parseInt(CellValue(Row, prefix + "trade_mt")) +
															parseInt(CellValue(Row, prefix + "trade_ab")) ;

				CellValue(Row, prefix + "grand_ttl_slot") = parseInt(CellValue(Row, prefix + "trade_sub_slot")) + 
															parseInt(CellValue(Row, prefix + "inter_sub_slot")) + 
															parseInt(CellValue(Row, prefix + "inter_45"));

				if(parseInt(CellValue(Row, prefix + "grand_ttl_slot")) > parseInt(CellValue(Row, prefix + "bsa_slot"))){
					CellValue(Row, prefix + "over_slot") = CellValue(Row, prefix + "grand_ttl_slot") - CellValue(Row, prefix + "bsa_slot");
				}else{
					CellValue(Row, prefix + "over_slot") = "0";
				}
			}

			if(ColSaveName(Col) == prefix + "inter_full" || ColSaveName(Col) == prefix + "inter_mt" || ColSaveName(Col) == prefix + "inter_ab"){
				CellValue(Row, prefix + "inter_sub_slot") = parseInt(CellValue(Row, prefix + "inter_full")) +
					                                        parseInt(CellValue(Row, prefix + "inter_mt")) +
															parseInt(CellValue(Row, prefix + "inter_ab")) ;
				//over_slot|over_wgt
				CellValue(Row, prefix + "grand_ttl_slot") = parseInt(CellValue(Row, prefix + "trade_sub_slot")) + 
															parseInt(CellValue(Row, prefix + "inter_sub_slot")) + 
															parseInt(CellValue(Row, prefix + "inter_45"));

				if(parseInt(CellValue(Row, prefix + "grand_ttl_slot")) > parseInt(CellValue(Row, prefix + "bsa_slot"))){
					CellValue(Row, prefix + "over_slot") = CellValue(Row, prefix + "grand_ttl_slot") - CellValue(Row, prefix + "bsa_slot");
				}else{
					CellValue(Row, prefix + "over_slot") = "0";
				}
			}

			//Weight
			if(ColSaveName(Col) == prefix + "trade_sub_wgt" || ColSaveName(Col) == prefix + "inter_sub_wgt"){
				CellValue(Row, prefix + "grand_ttl_wgt") =	parseFloat(CellValue(Row, prefix + "trade_sub_wgt")) +
															parseFloat(CellValue(Row, prefix + "inter_sub_wgt")) ;

				if(parseFloat(CellValue(Row, prefix + "grand_ttl_wgt")) > parseFloat(CellValue(Row, prefix + "bsa_wgt"))){
					CellValue(Row, prefix + "over_wgt") = CellValue(Row, prefix + "grand_ttl_wgt") - CellValue(Row, prefix + "bsa_wgt");
				}else{
					CellValue(Row, prefix + "over_wgt") = "0";
				}
			}
			
			//Weight
			if(ColSaveName(Col) == prefix + "inter_45"){
				CellValue(Row, prefix + "grand_ttl_slot") =	parseInt(CellValue(Row, prefix + "trade_sub_slot")) +
															parseInt(CellValue(Row, prefix + "inter_sub_slot")) + 
															parseInt(CellValue(Row, prefix + "inter_45")) ;

				if(parseFloat(CellValue(Row, prefix + "grand_ttl_wgt")) > parseFloat(CellValue(Row, prefix + "bsa_wgt"))){
					CellValue(Row, prefix + "over_slot") = CellValue(Row, prefix + "grand_ttl_wgt") - CellValue(Row, prefix + "bsa_wgt");
				}else{
					CellValue(Row, prefix + "over_slot") = "0";
				}
			}

			if(ColSaveName(Col) == prefix + "over_slot" || ColSaveName(Col) == prefix + "over_wgt"){
				var over_settle = "0";

				if(CellValue(Row, prefix + "ratio_type") == "T" && CellValue(Row, prefix + "bsa_type") == "U"){
					if( parseInt(CellValue(Row, prefix + "over_slot")) > 0 ){
						over_settle = parseInt(CellValue(Row, prefix + "over_slot"));
					}else{
						over_settle = 0;
					}
				}else if(CellValue(Row, prefix + "ratio_type") == "T" && CellValue(Row, prefix + "bsa_type") == "F"){
					over_settle = parseInt(CellValue(Row, prefix + "release_slot"));
				}else if(CellValue(Row, prefix + "ratio_type") == "W" && CellValue(Row, prefix + "bsa_type") == "U"){
					if( parseInt(CellValue(Row, prefix + "over_wgt")) > 0 && parseFloat(CellValue(Row, prefix + "teu")) > 0 ){
						over_settle = parseFloat(CellValue(Row, prefix + "over_wgt")) / parseFloat(CellValue(Row, prefix + "teu"));
					}else{
						over_settle = 0;
					}
				}else if(CellValue(Row, prefix + "ratio_type") == "W" && CellValue(Row, prefix + "bsa_type") == "F"){
					over_settle = parseFloat(CellValue(Row, prefix + "release_wgt")) / parseFloat(CellValue(Row, prefix + "teu"));
				}

				CellValue(Row, prefix + "over_settle") = ComRound(over_settle, 1);
			}
/*			
Change History OverSettle(_ .. _)
----------------
--4th Change
----------------
				if(CellValue(Row, prefix + "ratio_type") == "T"){
					if(parseInt(CellValue(Row, prefix + "grand_ttl_slot")) > parseInt(CellValue(Row, prefix + "bsa_slot"))){
						CellValue(Row, prefix + "over_settle") = parseInt(CellValue(Row, prefix + "grand_ttl_slot")) - parseInt(CellValue(Row, prefix + "bsa_slot"));
					}else{
						CellValue(Row, prefix + "over_settle") = "0";
					}
				}else{
					if(parseFloat(CellValue(Row, prefix + "grand_ttl_wgt")) > parseFloat(CellValue(Row, prefix + "bsa_wgt"))){
						if(parseFloat(CellValue(Row, prefix + "teu")) > 0){
							CellValue(Row, prefix + "over_settle") = 
											(	parseFloat(CellValue(Row, prefix + "grand_ttl_wgt")) - 
												parseFloat(CellValue(Row, prefix + "bsa_wgt"))
											)	/	parseFloat(CellValue(Row, prefix + "teu"))
								;
						}else{
							CellValue(Row, prefix + "over_settle") = "0";
						}
					}else{
						CellValue(Row, prefix + "over_settle") = "0";
					}
				}

----------------
--3th Change
----------------
			if(ColSaveName(Col) == prefix + "over_slot" || ColSaveName(Col) == prefix + "over_wgt"){
				var wgt_val  = CellValue(Row, prefix + "over_wgt")  / CellValue(Row, prefix + "teu");
				
				if(CellValue(Row, prefix + "over_slot") > wgt_val){
					CellValue(Row, prefix + "over_settle") = CellValue(Row, prefix + "over_slot");
					CellValue(Row, prefix + "over_settle_by") = "S";
				}else{
					CellValue(Row, prefix + "over_settle") = "";
					CellValue(Row, prefix + "over_settle_by") = "W";
				}
			}

----------------
--2nd Change
----------------
			if(ColSaveName(Col) == prefix + "grand_ttl_slot" || ColSaveName(Col) == prefix + "grand_ttl_wgt"){
				var slot_val = CellValue(Row, prefix + "grand_ttl_slot") / CellValue(Row, prefix + "teu");
				var wgt_val  = CellValue(Row, prefix + "grand_ttl_wgt")  / CellValue(Row, prefix + "teu");

				if(CellValue(Row, prefix + "grand_ttl_slot") > wgt_val)
					CellValue(Row, prefix + "over_settle") = CellValue(Row, prefix + "grand_ttl_slot");
				else
					CellValue(Row, prefix + "over_settle") = "";
			}
*/
		}
	}
