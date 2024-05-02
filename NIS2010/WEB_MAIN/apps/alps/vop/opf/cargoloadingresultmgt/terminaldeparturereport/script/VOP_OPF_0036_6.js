/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0036_6.JS
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation
* History --------------------------------------------------
* No. Date       Modifier  CSR No.        Content
* 1   2010.06.08 K.H.U                    Accout, Party 입력자리수 변경, (3,3)-->(6,12)
* 2   2011.08.16 김민아        CHM-201112982-01   [TDR] R/H의 acct 관련 보완요청 : 모든 Reason에 대하여 Carrier code (3digits)로 선택 또는 입력 가능하도록 수정
                                                                                                                                                    입력값 Validation 보완
* 3   2011.11.07 김민아      [CHM-201114250-01]  TDR내 SKD& Condition Tap 삭제 - parentTabIdx 수정
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
    function vop_opf_0036_6() {
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
	var parentTabIdx = 4;
	var enableButton = new Array(
									"btn_t6Import",
									"btn_t6RowAdd",
									"btn_t6RowInsert",
									"btn_t6RowCopy",
									"btn_t6Delete",
									"btn_t6DownTemplete"
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
				case "btn_t6Import":
						var sheetObj = document.t6sheet1;
						sheetObj.RemoveAll();
						sheetObj.LoadExcel(-1, 1, "", 2);
						break;

				case "btn_t6RowAdd":
						var sheetObj = document.t6sheet1;
						var Row = sheetObj.DataInsert(-1);
						sheetObj.SelectCell(Row, "t6sheet1_cntr_no", true);
						break;

				case "btn_t6RowInsert":
						var sheetObj = document.t6sheet1;
						var Row = sheetObj.DataInsert();
						sheetObj.SelectCell(Row, "t6sheet1_cntr_no", true);
						break;

				case "btn_t6RowCopy":
						var sheetObj = document.t6sheet1;
						var Row = sheetObj.DataCopy();
						sheetObj.SelectCell(Row, "t6sheet1_cntr_no", true);
						break;
						
				case "btn_t6Delete":
						var sheetObj = document.t6sheet1;
						var prefixDel = "t6sheet1_del_chk";

						ComRowHideDelete(sheetObj, prefixDel);
						break;
				case "btn_t6DownTemplete":
						var sheetObj = document.t6sheet1;
/*
						var prefix = "t6sheet1_";
						var arrMustCol = "cntr_no|respb_cntr_no|opr_cd|precell|position|shift_rsn|account|party".split("|");
						sheetObj.Redraw = false;
						for(var idx = 0; idx < arrMustCol.length; idx++){
							sheetObj.CellValue(0, prefix + arrMustCol[idx]) = "* " + sheetObj.CellValue(0, prefix + arrMustCol[idx]);
						}
*/
						sheetObj.DirectDown2Excel("apps/alps/vop/opf/cargoloadingresultmgt/terminaldeparturereport/jsp/VOP_OPF_0036.xml");
/*
						for(var idx = 0; idx < arrMustCol.length; idx++){
							sheetObj.CellValue(0, prefix + arrMustCol[idx]) = sheetObj.CellValue(0, prefix + arrMustCol[idx]).substring(2);
						}
						sheetObj.Redraw = true;
*/
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
		parent.frameButtonSheet(parent.document.t6frame, parent.readonlStatus());
		parent.topSync();
    }

	function initControl(){
		axon_event.addListener('blur', 't6sheet1_onblur', 't6sheet1', '');	
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
				HeadTitle1 = "|Seq.|Sel.|Container No.|Responsible\nCNTR No.|Type\n/Size|F/M|POL|Operator|From Position|To Position|Reason|Account|Responsible\n Party|File Attached|check_row";
			}else{
				HeadTitle1 = "|Seq.|Container No.|Responsible\nCNTR No.|Type\n/Size|F/M|POL|Operator|From Position|To Position|Reason|Account|Responsible\n Party|File Attached|check_row";
			}
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			var prefix = "t6sheet1_";

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//
			InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,	false,		prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtSeq,				40,		daCenter,	true,		prefix + "seq");
			if(mBtnDis == "Y"){
				InitDataProperty(0, cnt++ , dtCheckBox,			30,		daCenter,	true,		prefix + "del_chk",		false,		"",					dfNone,		0,		true,		true);
			}
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "cntr_no",			mustInput,	"",					dfEngUpKey,	0,		true,		true,		13);
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "respb_cntr_no",	mustInput,	"",					dfEngUpKey,	0,		true,		true,		14);
			InitDataProperty(0, cnt++ , dtComboEdit,			50,	daCenter,	true,		prefix + "sztp",			false,		"",					dfEngUpKey,	0,		true,		true,		4);
			
			InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,	true,		prefix + "fe",				mustInput,	"",					dfEngUpKey,	0,		true,		true,		1);
			
			InitDataProperty(0, cnt++ , dtComboEdit,		70,		daCenter,	true,		prefix + "pol",				false,		"",					dfEngUpKey,	0,		true,		true,		5);
			InitDataProperty(0, cnt++ , dtPopupEdit,			70,	daCenter,	true,		prefix + "opr_cd",			mustInput,	"",					dfEngUpKey,	0,		true,		true,		3);
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "precell",			mustInput,	"",					dfNone,		0,		true,		true,		6);
			InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "position",		mustInput,	"",					dfNone,		0,		true,		true,		6);
			InitDataProperty(0, cnt++ , dtPopupEdit,			70,	daCenter,	true,		prefix + "shift_rsn",		mustInput,	"",					dfEngUpKey,	0,		true,		true,		3);
			InitDataProperty(0, cnt++ , dtPopupEdit,		70,		daCenter,	true,		prefix + "account",			mustInput,	"",					dfEngUpKey,	0,		true,		true,		3);
			InitDataProperty(0, cnt++ , dtData,					90,	daCenter,	true,		prefix + "party",			mustInput,	"",					dfEngUpKey,	0,		true,		true,		12);
			InitDataProperty(0, cnt++ , dtPopupFormat,		80,		daCenter,	true,		prefix + "file_atch",		false,		"",					dfNone,		0,		true,		true,		12);
			InitDataProperty(0, cnt++ , dtHidden,			5,		daCenter,	true,		prefix + "check_row",		false,		"",					dfNone,		0,		true,		true,		3);
			
			InitDataValid(0, prefix + "cntr_no",       vtEngUpOther, "1234567890");
			InitDataValid(0, prefix + "precell",       vtNumericOnly );
			InitDataValid(0, prefix + "position",      vtNumericOnly );
			InitDataValid(0, prefix + "shift_rsn",     vtEngUpOnly   );
			InitDataValid(0, prefix + "opr_cd",        vtEngUpOnly   );
			InitDataValid(0, prefix + "account",       vtEngUpOnly   );
			InitDataValid(0, prefix + "respb_cntr_no", vtEngUpOther, "1234567890");

			InitDataCombo(0, prefix + "sztp", parent.mSztpName,  parent.mSztpCode);
			
			InitDataCombo(0,   prefix + "fe", " |F|M", " |F|E");
			
			FrozenCols = 4;

			podComboInit();
		}
	}

	function podComboInit(){
		var prefix = "t6sheet1_";
		document.t6sheet1.InitDataCombo(0, prefix + "pol", parent.mPodName,  parent.mPodCode);
	}

	function fileUploadPopUp(sheetObj, Row, editFlag ) {
		var sParam = "vsl_cd="         + parent.getObjValue("vsl_cd");
		sParam += "&skd_voy_no="       + parent.getObjValue("skd_voy_no");
		sParam += "&skd_dir_cd="       + parent.getObjValue("skd_dir_cd");
		sParam += "&vps_port_cd="      + parent.getObjValue("yd_cd").substring(0, 5);
		sParam += "&cltp_ind_seq="     + parent.getObjValue("clpt_ind_seq");
		sParam += "&cntr_hndl_knd_cd=ST";
		sParam += "&cntr_no="          + sheetObj.CellValue(Row, "t6sheet1_cntr_no");
		sParam += "&editable="         + editFlag ;
		var fileCount = ComOpenPopupWithTarget('/hanjin/VOP_OPF_9036.do?' + sParam, 740, 393, "vsl_cd:vsl_cd", "0,1,1,1,1,1,1", true);
		if ( editFlag == "Y" ) {
			if ( parseInt ( fileCount) > 0 ) {
				sheetObj.CellValue2 ( Row, "t6sheet1_file_atch") = "File Attached";
				sheetObj.CellFontUnderline ( Row, "t6sheet1_file_atch") = true;
			} else sheetObj.CellValue2 ( Row, "t6sheet1_file_atch") = "";
		}
		//alert ( fileCount );
		
	}
	
	function t6sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t6sheet1_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t6sheet1_", "opr_cd", Row, Col);
			parent.mCheckValue = false;
		}

		if(sheetObj.ColSaveName(Col) == "t6sheet1_account"){
			parent.getCallBackOprCd(sheetObj, "t6sheet1_", "account", Row, Col);
			parent.mCheckValue = false;
		}

//		if(sheetObj.ColSaveName(Col) == "t6sheet1_party"){
//			parent.getCallBackOprCd(sheetObj, "t6sheet1_", "party", Row, Col);
//			parent.mCheckValue = false;
//		}

		if(Col == sheetObj.SaveNameCol("t6sheet1_shift_rsn")){
			ComOpenPopupWithTarget('/hanjin/VOP_OPF_0040.do?shift_rsn=' + sheetObj.CellValue(Row, "t6sheet1_shift_rsn"), 740, 530, "vsl_cd:vsl_cd", "0,1,1,1,1,1,1", true);
			/*
			var l_rsn_cd = sheetObj.CellValue(Row, Col);
			if ( l_rsn_cd == "BIC" || l_rsn_cd == "QIC" ) {
				sheetObj.CellValue2( Row, "t6sheet1_account" ) = "CUS";
			} else if ( l_rsn_cd == "BIT" || l_rsn_cd == "QIT" ) {
				sheetObj.CellValue2( Row, "t6sheet1_account" ) = "TML";
			}
			*/
		}
		if(sheetObj.ColSaveName(Col) == "t6sheet1_file_atch") {
			if ( sheetObj.RowStatus(Row) == "I" ) {
				ComShowMessage ( "Please save it first");
				return;
			}
			fileUploadPopUp ( sheetObj, Row, "Y" );
		}

	}

	function t6sheet1_OnClick(sheetObj, Row, Col, Value){
		var prefix = "t6sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "file_atch" && sheetObj.CellValue ( Row, Col ) != '' && mBtnDis != "Y" ) { 
			fileUploadPopUp ( sheetObj, Row, "N" )
		}
	}

	
	function t6sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}

		if(sheetObj.ColSaveName(OldCol) == "t6sheet1_opr_cd" && sheetObj.CellValue(OldRow, "t6sheet1_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
		
		if(sheetObj.ColSaveName(OldCol) == "t6sheet1_account" && sheetObj.CellValue(OldRow, "t6sheet1_account") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}

		if(sheetObj.ColSaveName(OldCol) == "t6sheet1_party" && sheetObj.CellValue(OldRow, "t6sheet1_party") != "" && parent.mCheckValue){
			//parent.checkOprCd(sheetObj, OldRow, OldCol);	//수정[1]
		}

		if(sheetObj.CellValue(OldRow, OldCol) != "" && sheetObj.ColSaveName(OldCol) == "t6sheet1_shift_rsn" && parent.mCheckValue){
    		parent.checkShiftReason(sheetObj, OldRow, OldCol, sheetObj.CellValue(OldRow, OldCol));
		}
	}

	function t6sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t6sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "shift_rsn" 
			|| sheetObj.ColSaveName(Col) == prefix + "account" ) { // 수정[2] || sheetObj.ColSaveName(Col) == prefix + "party"){	//수정[1]
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue = true;
				parent.mPopUpEditSheet = document.t6sheet1;
				parent.mPopUpEditRow = Row;
				parent.mPopUpEditCol = Col;
			}
		}
	}

	function t6sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix = "t6sheet1_";

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

	function t6sheet1_OnLoadExcel(sheetObj){
		
		var prefix = "t6sheet1_";
		for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
			sheetObj.CellValue(idxRow, prefix + "check_row") = "N";

			sheetObj.CellValue2(idxRow, prefix + "cntr_no") = sheetObj.CellValue(idxRow,  prefix + "cntr_no").toUpperCase();
			sheetObj.CellValue2(idxRow, prefix + "respb_cntr_no") = sheetObj.CellValue(idxRow,  prefix + "respb_cntr_no").toUpperCase();
			sheetObj.CellValue2(idxRow, prefix + "opr_cd") = sheetObj.CellValue(idxRow,  prefix + "opr_cd").toUpperCase();
			sheetObj.CellValue2(idxRow, prefix + "shift_rsn") = sheetObj.CellValue(idxRow,  prefix + "shift_rsn").toUpperCase();
			sheetObj.CellValue2(idxRow, prefix + "account") = sheetObj.CellValue(idxRow,  prefix + "account").toUpperCase();
			sheetObj.CellValue2(idxRow, prefix + "party") = sheetObj.CellValue(idxRow,  prefix + "party").toUpperCase();
		}
	}

	function t6sheet1_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue && parent.mPopUpEditSheet != null && parent.mPopUpEditSheet != undefined ){
			// Reason 은 Operator의 Validation 과 다르므로 분기하여 Call 한다. 
			if(parent.mPopUpEditSheet.ColSaveName ( parent.mPopUpEditCol ) == "t6sheet1_shift_rsn"){
				parent.checkShiftReason(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol, parent.mPopUpEditSheet.CellValue(parent.mPopUpEditRow, parent.mPopUpEditCol));
			} else{
				parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
			}
		}
	}
	
	function t6sheet1_OnSearchEnd (sheetObj, ErrMsg ) {
		var prefix = "t6sheet1_";
		for(var idxRow = sheetObj.HeaderRows; idxRow <= sheetObj.LastRow; idxRow++){
			sheetObj.CellFontUnderline ( idxRow, prefix + "file_atch" ) = true;
		}
		
	}
