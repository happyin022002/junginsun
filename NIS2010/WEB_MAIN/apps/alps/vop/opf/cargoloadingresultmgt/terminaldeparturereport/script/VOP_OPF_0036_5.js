/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0036_5.js
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
    function vop_opf_0036_3() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    }

var sheetObjects = new Array();
var sheetCnt = 0;
var beforeLoadVolTab = 0;
var parentTabIdx = 3;
var enableButton = new Array(
								"btn_t5RowAdd",
								"btn_t5RowInsert",
								"btn_t5RowCopy",
								"btn_t5Delete"
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
				case "btn_t5RowAdd":
						var sheetObj = document.t5sheet1;
						var Row = sheetObj.DataInsert(-1);
						sheetObj.SelectCell(Row, "t5sheet1_cntr_no", true);
						break;

				case "btn_t5RowInsert":
						var sheetObj = document.t5sheet1;
						var Row = sheetObj.DataInsert();
						sheetObj.SelectCell(Row, "t5sheet1_cntr_no", true);
						break;

				case "btn_t5RowCopy":
						var sheetObj = document.t5sheet1;
						var Row = sheetObj.DataCopy();
						sheetObj.SelectCell(Row, "t5sheet1_cntr_no", true);
						break;
						
				case "btn_t5Delete":
						var sheetObj = document.t5sheet1;
						var prefixDel = "t5sheet1_del_chk";

						ComRowHideDelete(sheetObj, prefixDel);
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
			parent.doActionIBSheet(parentTabIdx, parent.document.form, IBSEARCH);
			parent.setTabEditSheet();
		}
		
		initControl();
		parent.frameButtonSheet(parent.document.t5frame, parent.readonlStatus());
		parent.topSync();
    }

	function initControl(){
		axon_event.addListener('blur', 't5sheet1_onblur', 't5sheet1', '');	
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
		var cnt = 0;
		var mustInput = (mBtnDis == "Y" ? true : false); 
		with (sheetObj) {
								// 높이 설정
			style.height = 400;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = (mBtnDis == "Y" ? true : false);

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "";
			if(mBtnDis == "Y"){
				HeadTitle1 = "|Sel.|Container No.|Type/Size|POL|From POD|To POD|Operator|Position|Reason";
			}else{
				HeadTitle1 = "|Container No.|Type/Size|POL|From POD|To POD|Operator|Position|Reason";
			}

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			var prefix = "t5sheet1_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,	true,		prefix + "ibflag");
			if(mBtnDis == "Y"){
				InitDataProperty(0, cnt++ , dtCheckBox,			30,		daCenter,	true,		prefix + "del_chk",		false,		"",					dfNone,		0,		true,		true);
			}
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "cntr_no",		mustInput,	"",					dfEngUpKey,	0,		true,		true,		13); //2010-12-23 P.H.D 변경 Update Edit = true
			InitDataProperty(0, cnt++ , dtComboEdit,		100,	daCenter,	true,		prefix + "sztp",		false,		"",					dfEngUpKey,	0,		true,		true,		2);
			InitDataProperty(0, cnt++ , dtComboEdit,		100,	daCenter,	true,		prefix + "pol",			false,		"",					dfEngUpKey,	0,		true,		true,		5);
			InitDataProperty(0, cnt++ , dtComboEdit,		100,	daCenter,	true,		prefix + "pre_pod",		mustInput,	"",					dfEngUpKey,	0,		true,		true,		5);
			InitDataProperty(0, cnt++ , dtComboEdit,		100,	daCenter,	true,		prefix + "pod",			mustInput,	"",					dfEngUpKey,	0,		true,		true,		5);
			InitDataProperty(0, cnt++ , dtPopupEdit,		100,	daCenter,	true,		prefix + "opr_cd",		mustInput,	"",					dfEngUpKey,	0,		true,		true,		3); //2010-12-23 P.H.D 변경 Update Edit = true
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "position",	false,		"",					dfNone,		0,		true,		true,		6);
			InitDataProperty(0, cnt++ , dtComboEdit,		100,	daLeft,		true,		prefix + "cod_rsn",		false,		"",					dfEngUpKey, 0,		true,		true,		2);
			
			InitDataValid(0, prefix + "cntr_no", vtEngUpOther, "1234567890");
			InitDataValid(0, prefix + "position", vtNumericOnly);
			
			InitDataCombo(0, prefix + "sztp", parent.mSztpName,  parent.mSztpCode);
			InitDataCombo(0, prefix + "cod_rsn", parent.mReasonName,  parent.mReasonCode);
		}

		podComboInit();
	}
	
	function podComboInit(sheetObj){
		var prefix = "t5sheet1_";
		
		document.t5sheet1.InitDataCombo(0, prefix + "pol", parent.mPodName,  parent.mPodCode);
		document.t5sheet1.InitDataCombo(0, prefix + "pre_pod", parent.mPodName,  parent.mPodCode);
		document.t5sheet1.InitDataCombo(0, prefix + "pod", parent.mPodName,  parent.mPodCode);
	}

	function t5sheet1_OnClick(sheetObj, Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "t5sheet1_pol" || sheetObj.ColSaveName(Col) == "t5sheet1_pre_pod" || sheetObj.ColSaveName(Col) == "t5sheet1_pod"){
			if(!parent.checkyDcDFlg){
				sheetObj.SelectCell(Row, Col, true);
			}
		}
	}

	function t5sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t5sheet1_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t5sheet1_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}
	}

	function t5sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t5sheet1_opr_cd" && sheetObj.CellValue(OldRow, "t5sheet1_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}

	function t5sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t5sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t5sheet1;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t5sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t5sheet1_";

		if(sheetObj.ColSaveName(Col) == prefix + "cntr_no"){
    		parent.duplCheck(sheetObj, Row, Col, Value, prefix + "cntr_no");	//imdg_segr_grp_no Value Duplication Check
			parent.checkCntrNo(sheetObj, Row, Col)
		}

		if(sheetObj.ColSaveName(Col) == prefix + "pol" || sheetObj.ColSaveName(Col) == prefix + "pre_pod" || sheetObj.ColSaveName(Col) == prefix + "pod"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}

		if(sheetObj.ColSaveName(Col) == prefix + "sztp"){
			parent.chkSzTpCombo(sheetObj, Row, Col, Value);
		}
	}

	function t5sheet1_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}
