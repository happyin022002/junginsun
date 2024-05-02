/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0036_7.js
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
var sheetObjects=new Array();
var sheetCnt=0;
var beforeLoadVolTab=0;
var parentTabIdx=6;
var enableButton=new Array(
								"btn_t7RowAdd", 
								"btn_t7RowInsert",
								"btn_t7RowCopy",
								"btn_t7Delete"
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
				case "misDischLoad":
					for(var cnt=0; cnt < formObject.misDischLoad.length; cnt++){
						if(formObject.misDischLoad[cnt].checked){
							parent.document.form.misHandleChk.value=formObject.misDischLoad[cnt].value;
							break;
						}
					}
					parent.filterMishandle(t7sheet1, parent.document.form.misHandleChk.value);
					var t7SheetObj=t7sheet1;
				    for(var idxRow=t7SheetObj.HeaderRows(); idxRow <= t7SheetObj.LastRow(); idxRow++){
				        if( !t7SheetObj.GetRowHidden(idxRow)  ){
	                        t7SheetObj.SetSelectRow(idxRow);
	                        break;
				        }				    
				    }
					break;
				case "btn_t7RowAdd":
						var sheetObj=t7sheet1;
						var prefix="t7sheet1_";
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(Row, prefix + "mishandle_chk",parent.document.form.misHandleChk.value);
						sheetObj.SelectCell(Row, prefix + "cntr_no");
						break;
				case "btn_t7RowInsert":
						var sheetObj=t7sheet1;
						var prefix="t7sheet1_";
						var Row=sheetObj.DataInsert();
						sheetObj.SetCellValue(Row, prefix + "mishandle_chk",parent.document.form.misHandleChk.value);
						sheetObj.SelectCell(Row, prefix + "cntr_no");
						break;
				case "btn_t7RowCopy":
						var sheetObj=t7sheet1;
						var Row=sheetObj.DataCopy();
						break;
				case "btn_t7Delete":
						var sheetObj=t7sheet1;
					    var prefixDel="t7sheet1_Sel";
						ComRowHideDelete(sheetObj, prefixDel);
						break;
				//misDischLoad Tab Change
				/*case "misDischLoad":
						disLoadTabChange();
						break;*/
			} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /*function disLoadTabChange(changeSheet){
		if(changeSheet == null || changeSheet == undefined)
			changeSheet=false;
		var formObject=document.form;
		var idx=0;
		var oldBeforeLoadVolTab=beforeLoadVolTab;
		for(; idx < formObject.chk_LoadVol.length; idx++){
			if(formObject.chk_LoadVol[idx].checked)
				break;
		}
		updateSheetSize();
		//변경된데이터 적용후 Tab Change시에.
		if(idx == 0 && changeSheet){
			beforeLoadVolTab=idx;
			setTimeout("disLoadTabChangeExec(" + oldBeforeLoadVolTab + ", "+ idx + ")", 100 );
		}else if(idx == beforeLoadVolTab){
			return;
		}else{
			var objs=document.all.item("t7sheetDiv");
			objs[idx].style.display="inline";
			objs[beforeLoadVolTab].style.display="none";
			objs[beforeLoadVolTab].style.zIndex=objs[idx].style.zIndex -1 ;
			beforeLoadVolTab=idx;
		}
	
	}
	function disLoadTabChangeExec(beforeLoadVolTab, idx){
		var objs=document.all.item("t7sheetDiv");
		objs[beforeLoadVolTab].style.display="none";
		objs[idx].style.display="inline";
		objs[beforeLoadVolTab].style.zIndex=objs[idx].style.zIndex -1 ;
	}*/
	
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
        parent.iframeResize(true);
		if(parent.bRetrive){
			parent.doActionIBSheet(parentTabIdx, parent.document.form, IBSEARCH);
			parent.setTabEditSheet();
		}
		initControl();
		parent.frameButtonSheet(parent.document.t7frame, parent.readonlStatus());
		parent.topSync();
    }
	function initControl(){
		axon_event.addListener('blur', 't7sheet1_onblur', 't7sheet1', '');	
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
            	HeadTitle1="|Sel.|Container No.|Operator|Type/Size|POL|POD|Position|Weight|Remark|CHK";
            }else{
            	HeadTitle1="|Container No.|Operator|Type/Size|POL|POD|Position|Weight|Remark|CHK";
            }
            var headCount=ComCountHeadTitle(HeadTitle1);
            var prefix="t7sheet1_";

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" } ];
            if(mBtnDis == "Y"){
            	cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Sel",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
            }
            cols.push({Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 });
            cols.push({Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });
            cols.push({Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"sztp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
            cols.push({Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
            cols.push({Type:"ComboEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
            cols.push({Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"position",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6, AcceptKeys:"N" });
            cols.push({Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"weight",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, ApproximateType:2 });
            cols.push({Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:70 });
            cols.push({Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:1,   SaveName:prefix+"mishandle_chk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:70 });

            InitColumns(cols);

            SetEditable((mBtnDis=="Y"?1:0));
            SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});
            SetColProperty(0 ,prefix+"cntr_no", {AcceptKeys:"N|E", InputCaseSensitive:1});
            SetColProperty(prefix+"sztp", {ComboText:parent.mSztpName, ComboCode:parent.mSztpCode} );
            podComboInit();
            SetSheetHeight(360);
		}
	}
	function podComboInit(){
		var prefix="t7sheet1_";
		parent.document.t7frame.t7sheet1.SetColProperty(prefix+"pol", {ComboText:parent.mPodName, ComboCode:parent.mPodCode} );
		parent.document.t7frame.t7sheet1.SetColProperty(prefix+"pod", {ComboText:parent.mPodName, ComboCode:parent.mPodCode} );
	}
	function t7sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t7sheet1_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t7sheet1_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
		}
	}
	function t7sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}
		if(sheetObj.ColSaveName(OldCol) == "t7sheet1_opr_cd" && sheetObj.GetCellValue(OldRow, "t7sheet1_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
	}
	function t7sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t7sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t7sheet1;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t7sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix="t7sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "cntr_no"){
    		parent.duplCheck(sheetObj, Row, Col, Value, prefix + "cntr_no");	//imdg_segr_grp_no Value Duplication Check
			parent.checkCntrNo(sheetObj, Row, Col)
		}
		if(sheetObj.ColSaveName(Col) == prefix + "pol" || sheetObj.ColSaveName(Col) == prefix + "pod"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}	
	}
	function t7sheet1_onblur(){
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
