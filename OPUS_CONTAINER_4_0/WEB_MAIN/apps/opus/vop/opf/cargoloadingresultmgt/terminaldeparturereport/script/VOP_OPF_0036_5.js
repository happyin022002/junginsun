/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0036_5.js
*@FileTitle  : TDR Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 
     */
    /**
     * @extends 
     * @class vop_opf_0036 : vop_opf_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
var sheetObjects	= new Array();
var sheetCnt		= 0;
var beforeLoadVolTab= 0;
var parentTabIdx	= 4; 
var enableButton	= new Array(
								"btn_t5RowAdd",
								"btn_t5RowInsert",
								"btn_t5RowCopy",
								"btn_t5Delete"
							);
var mBtnDis="N";
	document.onclick=processButtonClick;
   	/* 개발자 작업	*/
    function processButtonClick(){
		/*******************************************************/
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_t5RowAdd":
						var sheetObj=t5sheet1;
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SelectCell(Row, "t5sheet1_cntr_no", true);
						break;
				case "btn_t5RowInsert":
						var sheetObj=t5sheet1;
						var Row=sheetObj.DataInsert();
						sheetObj.SelectCell(Row, "t5sheet1_cntr_no", true);
						break;
				case "btn_t5RowCopy":
						var sheetObj=t5sheet1;
						var Row=sheetObj.DataCopy();
						sheetObj.SelectCell(Row, "t5sheet1_cntr_no", true);
						break;
				case "btn_t5Delete":
						var sheetObj=t5sheet1;
						var prefixDel="t5sheet1_del_chk";
						ComRowHideDelete(sheetObj, prefixDel);
						break;
			} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    
	/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(btnDis) {
		mBtnDis=btnDis;
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
		parent.iframeResize(true);
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
		sheetObjects[sheetCnt++]=sheet_obj;
    }
    
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var mustInput=(mBtnDis == "Y" ? true : false); 
		with (sheetObj) {
            var HeadTitle1="";
            if(mBtnDis == "Y"){
            	HeadTitle1="|Sel.|Container No.|Type/Size|POL|From POD|To POD|Operator|Position|Reason";
            }else{
            	HeadTitle1="|Container No.|Type/Size|POL|From POD|To POD|Operator|Position|Reason";
            }
            var headCount=ComCountHeadTitle(HeadTitle1);
            var prefix="t5sheet1_";

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" } ];
            	if(mBtnDis == "Y"){
            		cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
            	}
            cols.push({Type:"Text",      Hidden:0,  Width:120, Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 });
            cols.push({Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"sztp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 });
            cols.push({Type:"ComboEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pol",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
            cols.push({Type:"ComboEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pre_pod",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
            cols.push({Type:"ComboEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
            cols.push({Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });
            cols.push({Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"position", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
            cols.push({Type:"ComboEdit", Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cod_rsn",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 });

            InitColumns(cols);

            SetEditable((mBtnDis=="Y"?1:0));
            SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});
            SetColProperty(prefix+"sztp", {ComboText:parent.mSztpName, ComboCode:parent.mSztpCode});
            SetColProperty(prefix+"cod_rsn", {ComboText:parent.mReasonName, ComboCode:parent.mReasonCode});
            
            SetColProperty(prefix+"position", {AcceptKeys:"N"});
            
//          var prefix="t5sheet1_";
//          SetColProperty(prefix+"pol", {ComboText:parent.mPodName, ComboCode:parent.mPodCode});
//    		SetColProperty(prefix+"pre_pod", {ComboText:parent.mPodName, ComboCode:parent.mPodCode});
//    		SetColProperty(prefix+"pod", {ComboText:parent.mPodName, ComboCode:parent.mPodCode});
            
            SetSheetHeight(400);
		}
		podComboInit();
	}
	
	function podComboInit(sheetObj){
		var prefix="t5sheet1_";
		parent.document.t5frame.t5sheet1.SetColProperty(prefix+"pol", {ComboText:parent.mPodName, ComboCode:parent.mPodCode} );
		parent.document.t5frame.t5sheet1.SetColProperty(prefix+"pre_pod", {ComboText:parent.mPodName, ComboCode:parent.mPodCode} );
		parent.document.t5frame.t5sheet1.SetColProperty(prefix+"pod", {ComboText:parent.mPodName, ComboCode:parent.mPodCode} );
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
			parent.mCheckValue=false;
		}
	}
	function t5sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t5sheet1_opr_cd" && sheetObj.GetCellValue(OldRow, "t5sheet1_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}
	function t5sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t5sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t5sheet1;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t5sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix="t5sheet1_";
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
	
	function updateSheetSize(sheetObj){
    	  if(typeof sheetObj == "undefined") {
    		  sheetObj = sheetObjects[0];
    	  }    	  
    	  var obj = $("#" + sheetObj.id).offset();
    	  var marginDefault = 160;
    	  var marginHeight = obj.top + marginDefault;
    	  var winHeight = $(parent.window).height();
    	  var sheetHeight = winHeight - marginHeight;

    	  with(sheetObj){
    		  ComResizeSheet(sheetObjects[0]);
    		//SetSheetHeight(sheetHeight > 90?sheetHeight-80:90);
    	  }    
    }   
