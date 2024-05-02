/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0036_4.js
*@FileTitle  : TDR Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
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
var sheetObjects=new Array();
var sheetCnt=0;
var beforeLoadVolTab=0;
var parentTabIdx=3; 
var enableButton=new Array(
								"btn_t4RowAdd",
								"btn_t4RowInsert",
								"btn_t4RowCopy",
								"btn_t4Delete",
								"btn_t4ImportPart"
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
				case "btn_t4RowAdd":
						var sheetObj=sheetObjCur();
						var Row=sheetObj.DataInsert(-1);
//						if(beforeLoadVolTab == 0 || beforeLoadVolTab == 1 || beforeLoadVolTab == 2)
							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_opr_cd", true);
//						else
//							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_pod", true);
						break;
				case "btn_t4RowInsert":
						var sheetObj=sheetObjCur();
						var Row=sheetObj.DataInsert();
//						if(beforeLoadVolTab == 0 || beforeLoadVolTab == 1 || beforeLoadVolTab == 2)
							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_opr_cd", true);
//						else
//							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_pod", true);
						break;
				case "btn_t4RowCopy":
						var sheetObj=sheetObjCur();
						var Row=sheetObj.DataCopy();
//						if(beforeLoadVolTab == 0 || beforeLoadVolTab == 1 || beforeLoadVolTab == 2)
							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_opr_cd", true);
//						else
//							sheetObj.SelectCell(Row, "t4sheet" + (beforeLoadVolTab + 1) + "_pod", true);
						break;
				case "btn_t4Delete":
						var sheetObj=sheetObjCur();
						var prefixDel="t4sheet" + (beforeLoadVolTab + 1) + "_del_chk";
						ComRowHideDelete(sheetObj, prefixDel);
						break;
				//Disch Vol Tab Change
				case "chk_LoadVol":
					disLoadTabChange();
					break;
				case "btn_t4ImportPart":
					parent.doActionIBSheetImport2(beforeLoadVolTab, parent.document.form);
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
	function sheetObjCur(){
		var sheetObj=null;
		switch(beforeLoadVolTab){
			case 0:
				sheetObj=t4sheet1;
				break;
			case 1:
				sheetObj=t4sheet2;
				break;
			case 2:
				sheetObj=t4sheet3;
				break;
			case 3:
				sheetObj=t4sheet4;
				break;
		}
		return sheetObj;
	}
	function disLoadTabChange(changeSheet){
		if(changeSheet == null || changeSheet == undefined)
			changeSheet=false;
		var formObject=document.form;
		var idx=0;
		var oldBeforeLoadVolTab=beforeLoadVolTab;
		for(; idx < formObject.chk_LoadVol.length; idx++){
			if(formObject.chk_LoadVol[idx].checked)
				break;
		}
		
		parent.frameButtonSheet(parent.document.t4frame, parent.readonlStatus());
		
		//변경된데이터 적용후 Tab Change시에.
		if(idx == 0 && changeSheet){
			beforeLoadVolTab=idx;
			setTimeout("disLoadTabChangeExec(" + oldBeforeLoadVolTab + ", "+ idx + ")", 100 );
		}else if(idx == beforeLoadVolTab){
			return;
		}else{
			var objs=document.all.item("t4sheetDiv");
			objs[idx].style.display="inline";
			objs[beforeLoadVolTab].style.display="none";
			updateSheetSize();
			objs[beforeLoadVolTab].style.zIndex=objs[idx].style.zIndex -1 ;
			beforeLoadVolTab=idx;
		}
/*
		document.all.item("btn_t4ImportPart").innerHTML=(	 idx == 0 ? "Ocean" : 
															(idx == 1 ? "Inter Port" : 
															(idx == 2 ? "Special Cargo" : "Break-Bulk" )));															
*/		
		
		
		updateSheetSize();
	}
	function disLoadTabChangeExec(beforeLoadVolTab, idx){
		var objs=document.all.item("t4sheetDiv");
		objs[beforeLoadVolTab].style.display="none";
		objs[idx].style.display="inline";
		objs[beforeLoadVolTab].style.zIndex=objs[idx].style.zIndex -1 ;
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
		podComboInit();
		if(parent.bRetrive){
			parent.doActionIBSheetMulti(parentTabIdx, parent.document.form);
			parent.setTabEditSheet();
		}
		initControl();
		parent.frameButtonSheet(parent.document.t4frame, parent.readonlStatus());
		parent.topSync(); 
		parent.iframeResize(true);
		
    }
	function initControl(){
//		axon_event.addListener('blur', 't4sheet1_onblur', 't4sheet1', '');	
//		axon_event.addListener('blur', 't4sheet2_onblur', 't4sheet2', '');	
//		axon_event.addListener('blur', 't4sheet3_onblur', 't4sheet3', '');	
//		axon_event.addListener('blur', 't4sheet4_onblur', 't4sheet4', '');	
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
		
		switch(sheetObj.id){
			case "t4sheet1":
				var cnt=0;
				with(sheetObj){
			        var cellCol="";
			        var prefix="";
			        var HeadTitle1="";
			        var HeadTitle2="";
			        var HeadTitle3="";
			        var subTitle1=(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2" ? "Outbound" : "Inbound");
			        if(sheetObj.id == "t3sheet1"){
			        	cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|full_ts_20|full_ts_2h|full_ts_40|full_ts_4h|full_ts_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|et_ts_20|et_ts_2h|et_ts_40|et_ts_4h|et_ts_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
			        }else{
			        	cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
			        }
			        prefix=sheetObj.id + "_";
			        if(sheetObj.id == "t3sheet1"){
				        HeadTitle1="|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
				        HeadTitle2="|Sel.|Operator|POD|idx_Sheet|chk_valid|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo| | | | |";
				        HeadTitle3="|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
			        }else{
				        HeadTitle1="|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
				        HeadTitle2="|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
			        }
			        var headCount=ComCountHeadTitle(HeadTitle1);
			       
			        var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        if(sheetObj.id == "t3sheet1"){
			        	 var headers = [ { Text:HeadTitle1, Align:"Center"},
			        	                  { Text:HeadTitle2, Align:"Center"},
			        	                  { Text:HeadTitle3, Align:"Center"}];
					}else{
						 var headers = [ { Text:HeadTitle1, Align:"Center"},
						                  { Text:HeadTitle2, Align:"Center"}];
					}
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			        InitHeaders(headers, info);
			        var cols=[ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						        {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						        {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3} ];
			        
			        if(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2"){
			        	cols.push({Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 });
			        }else{
			        	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			        }
				        cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"idx_sheet",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				        cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_valid",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				        var arrCol=cellCol.split("|");
				       
				        if(sheetObj.id == "t3sheet1"){
					        for(var idxCol=0; idxCol < arrCol.length; idxCol++){
						        if(arrCol[idxCol].length == 5)
						        	cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
						        else
						        	////cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
						        	cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
					        }
				        }else{
					        for(var idxCol=0; idxCol < arrCol.length; idxCol++){
						        if(arrCol[idxCol].length == 5)
						        	cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
						        else
						        	////cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
						        	cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
					        }
					        if(sheetObj.id == "t3sheet1"){
					        	FrozenCols=3;
				        }
				        InitColumns(cols);
				       
			        }

			       // var cols = [  ];
			         
			        InitColumns(cols);
			        SetEditable(1);
			        SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});
			        //SetSheetHeight(360);
			        InitComboNoMatchText(1,"",1);
				}
				break;
				
			case "t4sheet2":
				var cnt=0;
				with(sheetObj){
			        var cellCol="";
			        var prefix="";
			        var HeadTitle1="";
			        var HeadTitle2="";
			        var HeadTitle3="";
			        var subTitle1=(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2" ? "Outbound" : "Inbound");
			        if(sheetObj.id == "t3sheet1"){
			        	cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|full_ts_20|full_ts_2h|full_ts_40|full_ts_4h|full_ts_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|et_ts_20|et_ts_2h|et_ts_40|et_ts_4h|et_ts_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
			        }else{
			        	cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
			        }
			        prefix=sheetObj.id + "_";
			        if(sheetObj.id == "t3sheet1"){
				        HeadTitle1="|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
				        HeadTitle2="|Sel.|Operator|POD|idx_Sheet|chk_valid|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo| | | | |";
				        HeadTitle3="|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
			        }else{
				        HeadTitle1="|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
				        HeadTitle2="|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
			        }
			        var headCount=ComCountHeadTitle(HeadTitle1);
			       
			        var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        if(sheetObj.id == "t3sheet1"){
			        	 var headers = [ { Text:HeadTitle1, Align:"Center"},
			        	                  { Text:HeadTitle2, Align:"Center"},
			        	                  { Text:HeadTitle3, Align:"Center"}];
					}else{
						 var headers = [ { Text:HeadTitle1, Align:"Center"},
						                  { Text:HeadTitle2, Align:"Center"}];
					}
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			        InitHeaders(headers, info);
			        var cols=[ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						        {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						        {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3} ];
			        if(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2"){
			        	cols.push({Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 });
			        }else{
			        	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			        }
				        cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"idx_sheet",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				        cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_valid",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				        var arrCol=cellCol.split("|");
				       if(sheetObj.id == "t3sheet1"){
					        for(var idxCol=0; idxCol < arrCol.length; idxCol++){
						        if(arrCol[idxCol].length == 5)
						        	cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
						        else
						        	cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
					        }
				        }else{
					        for(var idxCol=0; idxCol < arrCol.length; idxCol++){
						        if(arrCol[idxCol].length == 5)
						        	cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
						        else
						        	cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
					        }
					        if(sheetObj.id == "t3sheet1"){
					        	FrozenCols=3;
				        }
				        InitColumns(cols);
				       
			        }

			       // var cols = [  ];
			         
			        InitColumns(cols);
			        SetEditable(1);
			        SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});
			        //SetSheetHeight(360);
			        InitComboNoMatchText(1,"",1);
				}
				break;
				
			case "t4sheet3":
	              with(sheetObj){
	                 var cnt=0;
			         var HeadTitle1="|Sel.|Operator|POD|idx_sheet|DG Cargo|DG Cargo|DG Cargo|DG Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo";
			         var HeadTitle2="|Sel.|Operator|POD|idx_sheet|Quantity|Quantity|Weight(Ton)|Weight(Ton)|Quantity|Quantity|Weight(Ton)|Weight(Ton)|Quantity|Quantity|Weight(Ton)|Weight(Ton)";
			         var HeadTitle3="|Sel.|Operator|POD|idx_sheet|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'";
			         var headCount=ComCountHeadTitle(HeadTitle1);
			         var cellCol="dg_20_qty|dg_40_qty|dg_20_wgt|dg_40_wgt|rf_20_qty|rf_40_qty|rf_20_wgt|rf_40_wgt|ak_20_qty|ak_40_qty|ak_20_wgt|ak_40_wgt";
			         var prefix=sheetObj.id + "_";

			         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			         var headers = [ { Text:HeadTitle1, Align:"Center"},
			           { Text:HeadTitle2, Align:"Center"},
			           { Text:HeadTitle3, Align:"Center"} ];
			         InitHeaders(headers, info);

			         var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 } ];
			         if(id == "t4sheet4")
					         cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 });
				     else
					         cols.push({Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
			         cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"idx_sheet",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			         var arrCol = cellCol.split("|");
			         for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
			        	 if(idxCol % 4 == 0 || idxCol % 4 == 1)
			        		 	cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
			        	 else
			        		 	cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
			         	}

			         InitColumns(cols);
			
			         SetEditable(1);
			         SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});
			         //SetSheetHeight(360);
			         InitComboNoMatchText(1,"",1);
                     }


				break;
				
			case "t4sheet4":
				var cnt=0;
		        with(sheetObj){
//                    	SetColProperty(prefix+"crane", {ComboText:"G/Crane|F/Crane", ComboCode:"G|F"} );
	                  var HeadTitle1="|Sel.|Operator|POD|Dimension (L X W X H)|Dimension (L X W X H)|Dimension (L X W X H)|Slot|Weight (Ton)|Crane Type|Working Time|Working Time|Container No.|cod_chk";
	                  var headCount=ComCountHeadTitle(HeadTitle1);
	                  var prefix=sheetObj.id + "_";
	                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                  InitHeaders(headers, info);
	                  var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                  cols.push({Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"opr_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 });
	                  if(id == "t4sheet3")
	                	  cols.push({Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 });
	                  else
	                	  cols.push({Type:"ComboEdit", Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
	                  cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dml",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
	                  cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dmb",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
	                  cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dmh",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
	                  cols.push({Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"slot",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 });
	                  cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"weight",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                  cols.push({Type:"Combo",     Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:prefix+"crane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:"|G/Crane|F/Crane", ComboCode:"|G|F" });
	                  cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"commence", KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                  cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"complete", KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                  cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 });
	                  cols.push({Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cod_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                  
//	                  InitDataCombo(0, prefix + "crane", "G/Crane|F/Crane", "G|F");
	                  SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
	 
	                  InitColumns(cols)	
	                  SetEditable(1);
	                  SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});
	                  //SetSheetHeight(360);
//	                  InitComboNoMatchText(1,"",1);

		}
		        break;
		}
	}
	
	function podComboInit(){
		parent.document.t4frame.t4sheet1.SetColProperty("t4sheet1_pod_cd", {ComboText:parent.mLoadPodName, ComboCode:parent.mLoadPodCode} );
		parent.document.t4frame.t4sheet2.SetColProperty("t4sheet2_pod_cd", {ComboText:parent.mLoadPodName, ComboCode:parent.mLoadPodCode} );
		parent.document.t4frame.t4sheet3.SetColProperty("t4sheet3_pod", {ComboText:parent.mLoadPodName, ComboCode:parent.mLoadPodCode} );
		parent.document.t4frame.t4sheet4.SetColProperty("t4sheet4_pod", {ComboText:parent.mLoadPodName, ComboCode:parent.mLoadPodCode} );
	}
	function t4sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t4sheet1_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t4sheet1_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
		}
	}
	function t4sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t4sheet1_opr_cd" && sheetObj.GetCellValue(OldRow, "t4sheet1_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}
	function t4sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t4sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t4sheet1;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t4sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix="t4sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "pod_cd"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t4sheet1_opr_cd|t4sheet1_pod_cd");	//imdg_segr_grp_no Value Duplication Check
		}
		if(sheetObj.ColSaveName(Col) == prefix + "pod_cd"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}
	}
	function t4sheet2_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t4sheet2_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t4sheet2_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
		}
	}
	function t4sheet2_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t4sheet2_opr_cd" && sheetObj.GetCellValue(OldRow, "t4sheet2_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}
	function t4sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t4sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t4sheet2;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t4sheet2_OnChange(sheetObj, Row, Col, Value){
		var prefix="t4sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "pod_cd"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t4sheet2_opr_cd|t4sheet2_pod_cd");	//imdg_segr_grp_no Value Duplication Check
		}
		if(sheetObj.ColSaveName(Col) == prefix + "pod_cd"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}
	}
	function t4sheet3_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t4sheet3_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t4sheet3_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
		}
	}
	function t4sheet3_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t4sheet3_opr_cd" && sheetObj.GetCellValue(OldRow, "t4sheet3_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}
	function t4sheet3_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t4sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t4sheet3;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t4sheet3_OnChange(sheetObj, Row, Col, Value){
		var prefix="t4sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "pod"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t4sheet3_opr_cd|t4sheet3_pod");	//imdg_segr_grp_no Value Duplication Check
		}
		if(sheetObj.ColSaveName(Col) == prefix + "pod"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}
	}
	function t4sheet4_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t4sheet4_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t4sheet4_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
//			popupSheet=document.t4sheet4;
//			popupPrefix="t4sheet4_";
//			popupColNm="opr_cd";
//			ComOpenPopup("COM_ENS_0N1.do", 430, 400, "setCallBackOprCd", "0,0,1,1,1,1", false, false, Row, Col, 0);
		}
	}
	function t4sheet4_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis == "Y"){
			if(sheetObj.ColSaveName(OldCol) == "t4sheet4_opr_cd" && sheetObj.GetCellValue(OldRow, "t4sheet4_opr_cd") != "" && parent.mCheckValue){
				parent.checkOprCd(sheetObj, OldRow, OldCol);
			}
		}
	}
	function t4sheet4_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t4sheet4_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t4sheet4;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t4sheet4_OnChange(sheetObj, Row, Col, Value){
		var prefix="t4sheet4_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd" || sheetObj.ColSaveName(Col) == prefix + "pod" || sheetObj.ColSaveName(Col) == prefix + "cntr_no"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t4sheet4_opr_cd|t4sheet4_pod|t4sheet4_cntr_no");	//imdg_segr_grp_no Value Duplication Check
		}
		if(sheetObj.ColSaveName(Col) == prefix + "cntr_no"){
			parent.checkCntrNo(sheetObj, Row, Col)
		}
		if( (	Col == sheetObj.SaveNameCol(prefix + "commence") ||Col == sheetObj.SaveNameCol(prefix + "complete")) && sheetObj.GetCellValue(Row, Col) != ""){
			var dateTmp=sheetObj.GetCellValue(Row, Col);
			if(!ComIsDate(dateTmp.substring(0, 8), "ymd") || !ComIsTime(dateTmp.substring(8), "hm")){
				alert(ComGetMsg('COM12187', 'yyyy-mm-dd hh:mm'));
				sheetObj.SelectCell(Row, Col, true);
				return;
			}
			if(sheetObj.GetCellValue(Row, prefix + "commence") != "" && sheetObj.GetCellValue(Row, prefix + "complete") != "" ){
				var tmpMM=sheetObj.EvalDateDiff("N", sheetObj.GetCellText(Row, prefix + "commence") + ":00",sheetObj.GetCellText(Row, prefix + "complete") + ":00");
				if(tmpMM < 0){		//어떻게 해야 할지를
					ComShowCodeMessage('OPF50013', "Completed Date", "Commeced Date");
					sheetObj.SetCellValue(Row, prefix + "commence","");
					sheetObj.SetCellValue(Row, prefix + "complete","");
					sheetObj.SelectCell(Row, prefix + "commence", true);
					return;
				}
			}
		}
		if(sheetObj.ColSaveName(Col) == prefix + "pod"){
			parent.chkPortCombo(sheetObj, Row, Col, Value);
		}
	}
	function t4sheet1_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}
	function t4sheet2_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}
	function t4sheet3_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}
	function t4sheet4_onblur(){
		if(mBtnDis == "Y" && parent.mCheckValue){
			parent.checkOprCd(parent.mPopUpEditSheet, parent.mPopUpEditRow, parent.mPopUpEditCol);
		}
	}
	
	function t4sheet1_OnSearchEnd(sheetObj, code, errMsg){
		setTotalText(sheetObj, 3);
	}
	
	function t4sheet2_OnSearchEnd(sheetObj, code, errMsg){
		setTotalText(sheetObj, 3);
	}
	
	function t4sheet3_OnSearchEnd(sheetObj, code, errMsg){
		setTotalText(sheetObj, 3);
	}
	
	function t4sheet4_OnSearchEnd(sheetObj, code, errMsg){
		setTotalText(sheetObj, 2);
	}
	
	function setTotalText(sheet, col) {
		if(sheet.RowCount()<= 0 )  {
			return;
		}
		sheet.SetSumText(0,col,"Total");
	}
	
	function updateSheetSize(sheetObj){
		var sheetObj1;
		var sheetObj2;
		var sheetObj3;
		var sheetObj4;
		
  	  if(typeof sheetObj == "undefined") {
  		  for(var i=0; i<sheetObjects; i++) {
  			  if($("#" + sheetObjects[i].id).hidden)
  				sheetObj = sheetObjects[i];
  		  }
		  sheetObj1 = sheetObjects[0];
		  sheetObj2 = sheetObjects[1];
		  sheetObj3 = sheetObjects[2];
		  sheetObj4 = sheetObjects[3];
	  }
	  var obj1 = $("#" + sheetObj1.id).offset();
	  var obj2 = $("#" + sheetObj2.id).offset();
	  var obj3 = $("#" + sheetObj3.id).offset();
	  var obj4 = $("#" + sheetObj4.id).offset();
	  var marginDefault = 160;
	  var marginHeight1 = obj1.top + marginDefault;
	  var marginHeight2 = obj2.top + marginDefault;
	  var marginHeight3 = obj3.top + marginDefault;
	  var marginHeight4 = obj4.top + marginDefault;
	  var winHeight = $(parent.window).height();
	  var sheetHeight1 = winHeight - marginHeight1;
	  var sheetHeight2 = winHeight - marginHeight2;
	  var sheetHeight3 = winHeight - marginHeight3;
	  var sheetHeight4 = winHeight - marginHeight4;

	  sheetObj1.SetSheetHeight(sheetHeight1 > 90?sheetHeight1 - 20:90);
	  sheetObj2.SetSheetHeight(sheetHeight2 > 90?sheetHeight2 - 20:90);
	  sheetObj3.SetSheetHeight(sheetHeight3 > 90?sheetHeight3 - 20:90);
	  sheetObj4.SetSheetHeight(sheetHeight4 > 90?sheetHeight4 - 20:90);
     } 
