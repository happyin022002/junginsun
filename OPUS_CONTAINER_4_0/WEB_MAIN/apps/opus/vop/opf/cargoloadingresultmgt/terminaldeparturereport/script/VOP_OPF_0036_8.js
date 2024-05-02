/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0036_8.js
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
var beforeSlotTab=0;
var parentTabIdx=7; 
var enableButton=new Array(
								"btn_t8BsaImport",
								"btn_t8RowAdd",
								"btn_t8RowInsert",
								"btn_t8RowCopy",
								"btn_t8Delete"
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
				case "btn_t8RowAdd":
						var sheetObj=sheetObjCur(); //document.all.item("t8sheet" + (beforeSlotTab + 1));
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SelectCell(Row, "t8sheet" + (beforeSlotTab + 1) + "_opr_cd", true);
						//Row Add시 Ratio Type저장
						if(sheetObj.id == "t8sheet1"){
							sheetObj.SetCellValue(Row, "t8sheet1_ratio_type","T");
						}
						break;
				case "btn_t8RowInsert":
						var sheetObj=sheetObjCur(); //document.all.item("t8sheet" + (beforeSlotTab + 1));
						var Row=sheetObj.DataInsert();
						sheetObj.SelectCell(Row, "t8sheet" + (beforeSlotTab + 1) + "_opr_cd", true);
						//Row Add시 Ratio Type저장
						if(sheetObj.id == "t8sheet1"){
							sheetObj.SetCellValue(Row, "t8sheet1_ratio_type","T");
						}
						break;
				case "btn_t8RowCopy":
						var sheetObj=sheetObjCur();
						var Row=sheetObj.DataCopy();
						sheetObj.SelectCell(Row, "t8sheet" + (beforeSlotTab + 1) + "_opr_cd", true);
						break;
				case "btn_t8Delete":
						var sheetObj=sheetObjCur(); //document.all.item("t8sheet" + (beforeSlotTab + 1));
						var prefixDel="t8sheet" + (beforeSlotTab + 1) + "_del_chk";
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
    			ComShowMessage(e.message);
    		}
    	}
    }
	function sheetObjCur(){
		var sheetObj=null;
		switch(beforeSlotTab){
			case 0:
				sheetObj=t8sheet1;
				break;
			case 1:
				sheetObj=t8sheet2;
				break;
			case 2:
				sheetObj=t8sheet3;
				break;
			case 3:
				sheetObj=t8sheet4;
				break;
		}
		return sheetObj;
	}
	function disSlotTabChange(changeSheet){
		if(changeSheet == null || changeSheet == undefined)
			changeSheet=false;
		var formObject=document.form;
		var idx=0;
		var oldBeforeSlotTab=beforeSlotTab;
		for(; idx < formObject.chk_Slot.length; idx++){
			if(formObject.chk_Slot[idx].checked)
				break;
		}
		if(mBtnDis == "Y"){
			if(idx == 0){
				document.all.item("btn_t8BsaImport").innerHTML=" Import Allocation";
			}else if(idx == 1){
				document.all.item("btn_t8BsaImport").innerHTML=" Import Sub Allocation";
			}else if(idx == 2){
				document.all.item("btn_t8BsaImport").innerHTML=" Import Load Vol.";
			}else if(idx == 3){
				document.all.item("btn_t8BsaImport").innerHTML=" Import BSA & Slot Swap";
			}
		}
		
		parent.frameButtonSheetSub(parent.document.t8frame, 0);
		
		if(idx==0 && changeSheet){
			beforeSlotTab=idx;
			setTimeout("disSlotTabChangeExec(" + oldBeforeSlotTab + ", "+ idx + ")", 100 );
		}else if(idx == beforeSlotTab){
			return;
		}else{
			var objs=document.all.item("t8sheetDiv");
			objs[idx].style.display="inline";
			objs[beforeSlotTab].style.display="none";
			updateSheetSize();
			objs[beforeSlotTab].style.zIndex=objs[idx].style.zIndex -1 ;
			beforeSlotTab=idx;
			//2010.12.21 P.H.D. 
			parent.frameButtonSheetSub(parent.document.t8frame, idx);
			var updateSys=parent.document.form.sys_create.value.toUpperCase().substring(0, 2);
			var bEdt=false;
			
			////:2016-12-14:////var fmt="NullInteger";
			var fmt="NullFloat";
			
			if (updateSys != ""){
				if (idx == 1){
					if (updateSys == "IN"){
						bEdt=true;
					} 
					var prefix="t8sheet2_";
					if(mBtnDis == "Y"){
//						sheetObjects[1].InitDataProperty(0,  3, dtAutoSumEx, 80, daRight, true, prefix + "hc_ld_20", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
//						sheetObjects[1].InitDataProperty(0,  7, dtAutoSumEx, 80, daRight, true,	prefix + "hc_ld_40", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
//						sheetObjects[1].InitDataProperty(0, 11, dtAutoSumEx, 80, daRight, true,	prefix + "hc_ld_45", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
						sheetObjects[1].SetColProperty(0, 3,{Type:dtAutoSumEx,UpdateEdit:bEdt,InsertEdit:bEdt,Format:fmt});
						sheetObjects[1].SetColProperty(0, 7,{Type:dtAutoSumEx,UpdateEdit:bEdt,InsertEdit:bEdt,Format:fmt});
						sheetObjects[1].SetColProperty(0,11,{Type:dtAutoSumEx,UpdateEdit:bEdt,InsertEdit:bEdt,Format:fmt});
					}else{
//						sheetObjects[1].InitDataProperty(0,  2, dtAutoSumEx, 80, daRight, true, prefix + "hc_ld_20", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
//						sheetObjects[1].InitDataProperty(0,  6, dtAutoSumEx, 80, daRight, true,	prefix + "hc_ld_40", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
//						sheetObjects[1].InitDataProperty(0, 10, dtAutoSumEx, 80, daRight, true,	prefix + "hc_ld_45", false,	"",	dfInteger,	0,  bEdt,  bEdt, 4);
						sheetObjects[1].SetColProperty(0, 2,{Type:dtAutoSumEx,UpdateEdit:bEdt,InsertEdit:bEdt,Format:fmt});
						sheetObjects[1].SetColProperty(0, 6,{Type:dtAutoSumEx,UpdateEdit:bEdt,InsertEdit:bEdt,Format:fmt});
						sheetObjects[1].SetColProperty(0,10,{Type:dtAutoSumEx,UpdateEdit:bEdt,InsertEdit:bEdt,Format:fmt});
					}
				}
			}
		}
		updateSheetSize();
	}
	function disSlotTabChangeExec(beforeSlotTab, idx){
		var objs=document.all.item("t8sheetDiv");
		objs[beforeSlotTab].style.display="none";
		objs[idx].style.display="inline";
		objs[beforeSlotTab].style.zIndex=objs[idx].style.zIndex -1 ;
	}
	function slotTabButton(){
		if(beforeSlotTab == 0){
			document.all.item("btn_t8BsaImport").innerHTML=" Import Allocation";
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
			document.all.item("btn_t8BsaImport").innerHTML=" Import Sub Allocation";
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
			document.all.item("btn_t8BsaImport").innerHTML=" Import Load Vol.";
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
			document.all.item("btn_t8BsaImport").innerHTML=" Import BSA & Slot Swap";
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
		mBtnDis=btnDis;
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
		parent.frameButtonSheetSub(parent.document.t8frame, 0);
		parent.topSync();
		parent.iframeResize(true);
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
		
		switch(sheetObj.id){
			case "t8sheet1":
                with (sheetObj) {
	                var HeadTitle1="";
	                var HeadTitle2="";
	                if(mBtnDis == "Y"){
	                	HeadTitle1="|Sel";
	                	HeadTitle2="|Sel";
	                }
	                HeadTitle1=HeadTitle1 + "|Operator|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (TEU)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Allocation (Ton)|Weight\nper TEU|BSA Type|Ratio\nType";
	                HeadTitle2=HeadTitle2 + "|Operator|Basic Slot|Slot Swap|Slot Release|TTL Allocation|Basic WGT|WGT Swap|WGT Release|TTL Weight|Weight\nper TEU|BSA Type|Ratio\nType";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                var prefix="t8sheet1_";
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                                { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" } ];
	                if(mBtnDis == "Y"){
	                	cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" });
	                }
	                cols.push({Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:3});
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bsa_slot",     KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"swap_slot",    KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"release_slot", KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_alloc",    KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bsa_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1, EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"swap_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1, EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"release_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1, EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_weight",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, });
	                cols.push({Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"teu",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0, });
	                cols.push({Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bsa_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
	                cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ratio_type",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
	
	                InitColumns(cols);
	
	                SetEditable((mBtnDis == "Y" ? 1 : 0));
	                SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});
	                SetColProperty(prefix+"bsa_type", {ComboText:"Used|Fixed", ComboCode:"U|F"} );
	                SetColProperty(prefix+"ratio_type", {ComboText:"Ton|Weight", ComboCode:"T|W"} );
	                //SetSheetHeight(360);
				}
				break;
				
			case "t8sheet2":
                with (sheetObj) {
	                var HeadTitle1="";
	                var HeadTitle2="";
	                if(mBtnDis == "Y"){
	                	HeadTitle1="|Sel";
	                	HeadTitle2="|Sel";
	                }
	                HeadTitle1=HeadTitle1 +  "|Operator|20 High Cubic|20 High Cubic|20 High Cubic|20 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|40 High Cubic|45'|45'|45'|45'|45'";
	                HeadTitle2=HeadTitle2 +  "|Operator|Loaded|BSA(T)|Over Ratio(T)|Add Slot(T)|Loaded|BSA(F)|Over Ratio(F)|Add Slot(T)|Loaded|BSA(F)|Under Ratio(F)|Over Ratio(F)|Add Slot(T)";
	                var headCount=ComCountHeadTitle(HeadTitle2);
	                var prefix="t8sheet2_";
	
	                SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"},
	                                { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" } ];
	                if(mBtnDis == "Y"){
	                	cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" });
	                }
	                cols.push({Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:3});
	                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_ld_20",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_bsa_20",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoAvg",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_or_20",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_add_20",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_ld_40",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_bsa_40",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoAvg",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_or_40",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_add_40",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_ld_45",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_bsa_45",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoAvg",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_ur_45",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoAvg",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_or_45",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	                cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hc_add_45",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
	                if(mBtnDis == "Y")
	                	FrozenCols=3;
	                else
	                	FrozenCols=2;
	                InitColumns(cols);
	                SetEditable((mBtnDis == "Y" ? 1 : 0));
	                SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});
	                //SetSheetHeight(360);
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
		var cnt=0;
		var mustInput=(mBtnDis == "Y" ? true : false); 
		with (sheetObj) {
            var HeadTitle1="";
            var HeadTitle2="";
            if(mBtnDis == "Y"){
            	HeadTitle1="|Sel";
            	HeadTitle2="|Sel";
            }
            if(sheetObj.id == "t8sheet3"){
            	HeadTitle1=HeadTitle1 + "|Operator|Status|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|Grand TTL Used Slot|Grand TTL Used Slot";
            	HeadTitle2=HeadTitle2 + "|Operator|Status|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)";
            }else if(sheetObj.id == "t8sheet4"){
            	HeadTitle1=HeadTitle1 + "|Operator|Status|Ratio_TP|Bsa_TP|Teu|realse_slot|realse_weight|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Sub TTL Used Slot|Sub TTL Used Slot|Add Slot\n(HC/45)|Grand TTL Used Slot|Grand TTL Used Slot|BSA\n(+ Slot Swap)|BSA\n(+ Slot Swap)|Over Used Slot|Over Used Slot|Over Slot Settlement|Over Slot Settlement";
            	HeadTitle2=HeadTitle2 + "|Operator|Status|Ratio_TP|Bsa_TP|Teu|realse_slot|realse_weight|M/Trade\nCGO (Full)|M/Trade\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|InterPort\nCGO (Full)|InterPort\nCGO (MTY)|Add Slot\n(AK/BB)|Slot\n(TEU)|Slot\n(Ton)|Add Slot\n(HC/45)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot\n(TEU)|Slot\n(Ton)|Slot(TEU)|By";
            }
            var headCount=ComCountHeadTitle(HeadTitle1);
            var cellCol="";
            if(sheetObj.id == "t8sheet3")
            	cellCol="trade_full|trade_mt|trade_ab|trade_sub_slot|trade_sub_wgt|inter_full|inter_mt|inter_ab|inter_sub_slot|inter_sub_wgt|grand_ttl_slot|grand_ttl_wgt";
            else if(sheetObj.id == "t8sheet4")
            	cellCol="trade_full|trade_mt|trade_ab|trade_sub_slot|trade_sub_wgt|inter_full|inter_mt|inter_ab|inter_sub_slot|inter_sub_wgt|inter_45|grand_ttl_slot|grand_ttl_wgt|bsa_slot|bsa_wgt|over_slot|over_wgt|over_settle|over_settle_by";
            var prefix=sheetObj.id + "_";

            SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"},
                            { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" } ];
            if(mBtnDis == "Y"){
            	cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" });
            }
            cols.push({Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:3});
            cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"status",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 });
            
            if(sheetObj.id == "t8sheet4"){
            	cols.push({Type:"Text",      Hidden:1, Width:60,   Align:undefined, ColMerge:1,   SaveName:prefix+"ratio_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 });
            	cols.push({Type:"Text",      Hidden:1, Width:60,   Align:undefined, ColMerge:1,   SaveName:prefix+"bsa_type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 });
            	cols.push({Type:"Text",      Hidden:1, Width:60,   Align:undefined, ColMerge:1,   SaveName:prefix+"teu",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
            	cols.push({Type:"Text",      Hidden:1, Width:60,   Align:undefined, ColMerge:1,   SaveName:prefix+"release_slot",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
            	cols.push({Type:"Text",      Hidden:1, Width:60,   Align:undefined, ColMerge:1,   SaveName:prefix+"release_wgt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
            }
            
            var arrCol=cellCol.split("|");
            for(var idxCol=0; idxCol < arrCol.length; idxCol++){
            	if(arrCol[idxCol] == "trade_sub_wgt" || arrCol[idxCol] == "inter_sub_wgt")	//Float고 작성가능.
            		cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
            	else if(arrCol[idxCol] == "trade_sub_slot" || arrCol[idxCol] == "inter_sub_slot" || arrCol[idxCol] == "grand_ttl_slot" || arrCol[idxCol] == "bsa_slot" || arrCol[idxCol] == "over_slot" || arrCol[idxCol] == "inter_45")	//Integer고 작성불가능.
            		cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
            	else if(arrCol[idxCol] == "grand_ttl_wgt" || arrCol[idxCol] == "bsa_wgt" || arrCol[idxCol] == "over_wgt" || arrCol[idxCol] == "over_settle")					//Float고 작성불가능.
            		cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
            	else if(arrCol[idxCol] == "over_settle_by")
            		cols.push({Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            	else
            		cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
        	}
            InitColumns(cols);
            if(sheetObj.id == "t8sheet4")
            	SetColProperty(prefix+"over_settle_by", {ComboText:"Slot|Weight|Fixed|Used", ComboCode:"S|W|F|U"} );
            if(mBtnDis == "Y"){
            	SetFrozenCol(4);
            }
			SetEditable((mBtnDis == "Y" ? 1 : 0));
			SetColProperty(0 ,prefix+"opr_cd", {AcceptKeys:"E", InputCaseSensitive:1});
			InitComboNoMatchText(1,"",1);
			//SetSheetHeight(358);
		}
	}
	function t8sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t8sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t8sheet1;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t8sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}
		if(sheetObj.ColSaveName(OldCol) == "t8sheet1_opr_cd" && sheetObj.GetCellValue(OldRow, "t8sheet1_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
	}
	function t8sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t8sheet1_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t8sheet1_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
		}
	}
	function t8sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix="t8sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
    		parent.duplCheck(sheetObj, Row, Col, Value, "t8sheet1_opr_cd");	//imdg_segr_grp_no Value Duplication Check
		}
		if(sheetObj.ColSaveName(Col) == prefix + "bsa_slot" || sheetObj.ColSaveName(Col) == prefix + "swap_slot" || sheetObj.ColSaveName(Col) == prefix + "release_slot"){
			var ttl_alloc=parseInt(sheetObj.GetCellValue(Row, prefix + "bsa_slot")) +
			parseInt(sheetObj.GetCellValue(Row, prefix + "swap_slot")) +
			parseInt(sheetObj.GetCellValue(Row, prefix + "release_slot"));
			sheetObj.SetCellValue(Row, prefix + "ttl_alloc",ttl_alloc);
		}
		if(sheetObj.ColSaveName(Col) == prefix + "bsa_wgt" || sheetObj.ColSaveName(Col) == prefix + "swap_wgt" || sheetObj.ColSaveName(Col) == prefix + "release_wgt"){
			var ttl_alloc=parseFloat(sheetObj.GetCellValue(Row, prefix + "bsa_wgt")) +
			parseFloat(sheetObj.GetCellValue(Row, prefix + "swap_wgt")) +
			parseFloat(sheetObj.GetCellValue(Row, prefix + "release_wgt"));
			sheetObj.SetCellValue(Row, prefix + "ttl_weight",ttl_alloc);
		}
		if(sheetObj.ColSaveName(Col) == prefix + "release_slot" || sheetObj.ColSaveName(Col) == prefix + "release_wgt"){
			if(parseFloat(sheetObj.GetCellValue(Row, prefix + "release_slot")) > 0 || parseFloat(sheetObj.GetCellValue(Row, prefix + "release_wgt")) > 0){
				sheetObj.SetCellValue(Row, prefix + "bsa_type","F");
			}else if(parseFloat(sheetObj.GetCellValue(Row, prefix + "release_slot")) == 0 && parseFloat(sheetObj.GetCellValue(Row, prefix + "release_wgt")) == 0){
				sheetObj.SetCellValue(Row, prefix + "bsa_type","U");
			}
		}
	}
	function t8sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t8sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t8sheet2;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t8sheet2_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}
		if(sheetObj.ColSaveName(OldCol) == "t8sheet2_opr_cd" && sheetObj.GetCellValue(OldRow, "t8sheet2_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
	}
	function t8sheet2_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t8sheet2_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t8sheet2_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
		}
	}
	function t8sheet2_OnChange(sheetObj, Row, Col, Value){
		var prefix="t8sheet2_";
		with(sheetObj){
			if(ColSaveName(Col) == prefix + "opr_cd"){
				parent.duplCheck(sheetObj, Row, Col, Value, "t8sheet2_opr_cd");	//imdg_segr_grp_no Value Duplication Check
			}
			//{(Loaded – 20’ High Cubic Sub Allocation) x Over Ratio} x 2, 소수점 2째자리 반올림 (I-Stowage 에서 제공)
			if(ColSaveName(Col) == prefix + "hc_ld_20" || ColSaveName(Col) == prefix + "hc_bsa_20" || ColSaveName(Col) == prefix + "hc_or_20"){
				if(parseInt(GetCellValue(Row,  prefix + "hc_ld_20")) > 0 && parseInt(GetCellValue(Row,  prefix + "hc_bsa_20")) > 0 && parseFloat(GetCellValue(Row,  prefix + "hc_or_20")) > 1){
					if(parseInt(GetCellValue(Row,  prefix + "hc_ld_20")) > parseInt(GetCellValue(Row,  prefix + "hc_bsa_20"))){
						var addSlot=
						( 
								parseInt(GetCellValue(Row,  prefix + "hc_ld_20")) - parseInt(GetCellValue(Row,  prefix + "hc_bsa_20"))
						) *
						(GetCellValue(Row,  prefix + "hc_or_20") - 1);
						SetCellValue(Row,  prefix + "hc_add_20",ComRound(addSlot));
					}else{
						SetCellValue(Row,  prefix + "hc_add_20","0");
					}
				}else{
					SetCellValue(Row,  prefix + "hc_add_20","0");
				}
			}
			 //{(Loaded – 40’ High Cubic Sub Allocation) x Over Ratio} x 2, 소수점 2째자리 반올림 (I-Stowage 에서 제공)
			if(ColSaveName(Col) == prefix + "hc_ld_40" || ColSaveName(Col) == prefix + "hc_bsa_40" || ColSaveName(Col) == prefix + "hc_or_40"){
				if(parseInt(GetCellValue(Row,  prefix + "hc_ld_40")) > 0 && parseInt(GetCellValue(Row,  prefix + "hc_bsa_40")) > 0 && parseFloat(GetCellValue(Row,  prefix + "hc_or_40")) > 1){
					if(parseInt(GetCellValue(Row,  prefix + "hc_ld_40")) > parseInt(GetCellValue(Row,  prefix + "hc_bsa_40"))){
						var addSlot=
						( 
								parseInt(GetCellValue(Row,  prefix + "hc_ld_40")) - parseInt(GetCellValue(Row,  prefix + "hc_bsa_40"))
						) *
						(GetCellValue(Row,  prefix + "hc_or_40") - 1) * 2;
						SetCellValue(Row,  prefix + "hc_add_40",ComRound(addSlot));
					}else{
						SetCellValue(Row,  prefix + "hc_add_40","0");
					}
				}else{
					SetCellValue(Row,  prefix + "hc_add_40","0");
				}
			}
			//IF HC_LD_45 > HC_BSA_45 THEN (( HC_LD_45 - HC_BSA_45 ) * HC_OR_45 * 2 ) ELSE (( HC_BSA_45 - HC_LD_45 ) * HC_UR_45 * 2 )
			if(ColSaveName(Col) == prefix + "hc_ld_45" || ColSaveName(Col) == prefix + "hc_bsa_45" || ColSaveName(Col) == prefix + "hc_ur_45" || ColSaveName(Col) == prefix + "hc_or_45"){
				if(parseInt(GetCellValue(Row,  prefix + "hc_ld_45")) > 0 && parseInt(GetCellValue(Row,  prefix + "hc_bsa_45")) > 0){
					//Under일 경우...
					if(
							( parseInt(GetCellValue(Row,  prefix + "hc_ld_45")) <= parseInt(GetCellValue(Row,  prefix + "hc_bsa_45")) ) &&
							( parseFloat(GetCellValue(Row,  prefix + "hc_ur_45")) > 1 )
					   ){
						var addSlot=parseInt(GetCellValue(Row,  prefix + "hc_ld_45")) * (GetCellValue(Row,  prefix + "hc_ur_45") - 1) * 2;
						SetCellValue(Row,  prefix + "hc_add_45",ComRound(addSlot));
					//Over의 경우.
					}else if(
							( parseInt(GetCellValue(Row,  prefix + "hc_ld_45")) > parseInt(GetCellValue(Row,  prefix + "hc_bsa_45")) ) &&
							( parseFloat(GetCellValue(Row,  prefix + "hc_ur_45")) > 1 )  && ( parseFloat(GetCellValue(Row,  prefix + "hc_or_45")) > 1 )
					   ){
						var addSlot=( parseInt(GetCellValue(Row,  prefix + "hc_bsa_45")) * (GetCellValue(Row,  prefix + "hc_ur_45") - 1) * 2 ) +
						( (	parseInt(GetCellValue(Row,  prefix + "hc_ld_45")) -
								parseInt(GetCellValue(Row,  prefix + "hc_bsa_45"))
										)
										* (GetCellValue(Row,  prefix + "hc_or_45") - 1) * 2 )
							          ;
							SetCellValue(Row,  prefix + "hc_add_45",ComRound(addSlot));
					}else{
						SetCellValue(Row,  prefix + "hc_add_45","0");
					}
				}else{
					SetCellValue(Row,  prefix + "hc_add_45","0");
				}
			}
		}
	}
	function t8sheet3_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t8sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t8sheet3;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t8sheet3_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}
		if(sheetObj.ColSaveName(OldCol) == "t8sheet3_opr_cd" && sheetObj.GetCellValue(OldRow, "t8sheet3_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
	}
	function t8sheet3_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t8sheet3_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t8sheet3_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
		}
	}
	function t8sheet3_OnChange(sheetObj, Row, Col, Value){
		var prefix="t8sheet3_";
		with(sheetObj){
			if(ColSaveName(Col) == prefix + "opr_cd"){
				parent.duplCheck(sheetObj, Row, Col, Value, "t8sheet3_opr_cd");	//imdg_segr_grp_no Value Duplication Check
			}
			//{(Loaded – 20’ High Cubic Sub Allocation) x Over Ratio} x 2, 소수점 2째자리 반올림 (I-Stowage 에서 제공)
			if(ColSaveName(Col) == prefix + "trade_full" || ColSaveName(Col) == prefix + "trade_mt" || ColSaveName(Col) == prefix + "trade_ab"){
				SetCellValue(Row, prefix + "trade_sub_slot",parseInt(GetCellValue(Row, prefix + "trade_full")) +
						parseInt(GetCellValue(Row, prefix + "trade_mt")) +
						parseInt(GetCellValue(Row, prefix + "trade_ab"))) ;
				SetCellValue(Row, prefix + "grand_ttl_slot",parseInt(GetCellValue(Row, prefix + "trade_sub_slot")) + parseInt(GetCellValue(Row, prefix + "inter_sub_slot")));
			}
			if(ColSaveName(Col) == prefix + "inter_full" || ColSaveName(Col) == prefix + "inter_mt" || ColSaveName(Col) == prefix + "inter_ab"){
				SetCellValue(Row, prefix + "inter_sub_slot",parseInt(GetCellValue(Row, prefix + "inter_full")) +
						parseInt(GetCellValue(Row, prefix + "inter_mt")) +
						parseInt(GetCellValue(Row, prefix + "inter_ab"))) ;
				SetCellValue(Row, prefix + "grand_ttl_slot",parseInt(GetCellValue(Row, prefix + "trade_sub_slot")) + parseInt(GetCellValue(Row, prefix + "inter_sub_slot")));
			}
			//Weight가 메롱.....
			if(ColSaveName(Col) == prefix + "trade_sub_wgt" || ColSaveName(Col) == prefix + "inter_sub_wgt"){
				SetCellValue(Row, prefix + "grand_ttl_wgt",parseInt(GetCellValue(Row, prefix + "trade_sub_wgt")) +
						parseInt(GetCellValue(Row, prefix + "inter_sub_wgt"))) ;
			}
		}
	}
	function t8sheet4_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t8sheet4_";
		if(sheetObj.ColSaveName(Col) == prefix + "opr_cd"){
			if(KeyCode >= 65 && KeyCode<= 90){
				parent.mCheckValue=true;
				parent.mPopUpEditSheet=document.t8sheet4;
				parent.mPopUpEditRow=Row;
				parent.mPopUpEditCol=Col;
			}
		}
	}
	function t8sheet4_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(mBtnDis != "Y"){
			return;
		}
		if(sheetObj.ColSaveName(OldCol) == "t8sheet4_opr_cd" && sheetObj.GetCellValue(OldRow, "t8sheet4_opr_cd") != "" && parent.mCheckValue){
			parent.checkOprCd(sheetObj, OldRow, OldCol);
		}
	}
	function t8sheet4_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t8sheet4_opr_cd"){
			parent.getCallBackOprCd(sheetObj, "t8sheet4_", "opr_cd", Row, Col);
			parent.mCheckValue=false;
		}
	}
	function t8sheet4_OnChange(sheetObj, Row, Col, Value){
		var prefix="t8sheet4_";
		with(sheetObj){
			if(ColSaveName(Col) == prefix + "opr_cd"){
				parent.duplCheck(sheetObj, Row, Col, Value, "t8sheet4_opr_cd");	//imdg_segr_grp_no Value Duplication Check
			}
			//{(Loaded – 20’ High Cubic Sub Allocation) x Over Ratio} x 2, 소수점 2째자리 반올림 (I-Stowage 에서 제공)
			if(ColSaveName(Col) == prefix + "trade_full" || ColSaveName(Col) == prefix + "trade_mt" || ColSaveName(Col) == prefix + "trade_ab"){
				SetCellValue(Row, prefix + "trade_sub_slot",parseInt(GetCellValue(Row, prefix + "trade_full")) +
						parseInt(GetCellValue(Row, prefix + "trade_mt")) +
						parseInt(GetCellValue(Row, prefix + "trade_ab"))) ;
				SetCellValue(Row, prefix + "grand_ttl_slot",parseInt(GetCellValue(Row, prefix + "trade_sub_slot")) +
						parseInt(GetCellValue(Row, prefix + "inter_sub_slot")) +
						parseInt(GetCellValue(Row, prefix + "inter_45")));
				if(parseInt(GetCellValue(Row, prefix + "grand_ttl_slot")) > parseInt(GetCellValue(Row, prefix + "bsa_slot"))){
					SetCellValue(Row, prefix + "over_slot",GetCellValue(Row, prefix + "grand_ttl_slot") - GetCellValue(Row, prefix + "bsa_slot"));
				}else{
					SetCellValue(Row, prefix + "over_slot","0");
				}
			}
			if(ColSaveName(Col) == prefix + "inter_full" || ColSaveName(Col) == prefix + "inter_mt" || ColSaveName(Col) == prefix + "inter_ab"){
				SetCellValue(Row, prefix + "inter_sub_slot",parseInt(GetCellValue(Row, prefix + "inter_full")) +
						parseInt(GetCellValue(Row, prefix + "inter_mt")) +
						parseInt(GetCellValue(Row, prefix + "inter_ab"))) ;
				//over_slot|over_wgt
				SetCellValue(Row, prefix + "grand_ttl_slot",parseInt(GetCellValue(Row, prefix + "trade_sub_slot")) +
						parseInt(GetCellValue(Row, prefix + "inter_sub_slot")) +
						parseInt(GetCellValue(Row, prefix + "inter_45")));
				if(parseInt(GetCellValue(Row, prefix + "grand_ttl_slot")) > parseInt(GetCellValue(Row, prefix + "bsa_slot"))){
					SetCellValue(Row, prefix + "over_slot",GetCellValue(Row, prefix + "grand_ttl_slot") - GetCellValue(Row, prefix + "bsa_slot"));
				}else{
					SetCellValue(Row, prefix + "over_slot","0");
				}
			}
			//Weight
			if(ColSaveName(Col) == prefix + "trade_sub_wgt" || ColSaveName(Col) == prefix + "inter_sub_wgt"){
				SetCellValue(Row, prefix + "grand_ttl_wgt",parseFloat(GetCellValue(Row, prefix + "trade_sub_wgt")) +
						parseFloat(GetCellValue(Row, prefix + "inter_sub_wgt"))) ;
				if(parseFloat(GetCellValue(Row, prefix + "grand_ttl_wgt")) > parseFloat(GetCellValue(Row, prefix + "bsa_wgt"))){
					SetCellValue(Row, prefix + "over_wgt",GetCellValue(Row, prefix + "grand_ttl_wgt") - GetCellValue(Row, prefix + "bsa_wgt"));
				}else{
					SetCellValue(Row, prefix + "over_wgt","0");
				}
			}
			//Weight
			if(ColSaveName(Col) == prefix + "inter_45"){
				SetCellValue(Row, prefix + "grand_ttl_slot",parseInt(GetCellValue(Row, prefix + "trade_sub_slot")) +
						parseInt(GetCellValue(Row, prefix + "inter_sub_slot")) +
						parseInt(GetCellValue(Row, prefix + "inter_45")));
				if(parseFloat(GetCellValue(Row, prefix + "grand_ttl_wgt")) > parseFloat(GetCellValue(Row, prefix + "bsa_wgt"))){
					SetCellValue(Row, prefix + "over_slot",GetCellValue(Row, prefix + "grand_ttl_wgt") - GetCellValue(Row, prefix + "bsa_wgt"));
				}else{
					SetCellValue(Row, prefix + "over_slot","0");
				}
			}
			if(ColSaveName(Col) == prefix + "over_slot" || ColSaveName(Col) == prefix + "over_wgt"){
				var over_settle="0";
				if(GetCellValue(Row, prefix + "ratio_type") == "T" && GetCellValue(Row, prefix + "bsa_type") == "U"){
					if( parseInt(GetCellValue(Row, prefix + "over_slot")) > 0 ){
						over_settle=parseInt(GetCellValue(Row, prefix + "over_slot"));
					}else{
						over_settle=0;
					}
				}else if(GetCellValue(Row, prefix + "ratio_type") == "T" && GetCellValue(Row, prefix + "bsa_type") == "F"){
					over_settle=parseInt(GetCellValue(Row, prefix + "release_slot"));
				}else if(GetCellValue(Row, prefix + "ratio_type") == "W" && GetCellValue(Row, prefix + "bsa_type") == "U"){
					if( parseInt(GetCellValue(Row, prefix + "over_wgt")) > 0 && parseFloat(GetCellValue(Row, prefix + "teu")) > 0 ){
						over_settle=parseFloat(GetCellValue(Row, prefix + "over_wgt")) / parseFloat(GetCellValue(Row, prefix + "teu"));
					}else{
						over_settle=0;
					}
				}else if(GetCellValue(Row, prefix + "ratio_type") == "W" && GetCellValue(Row, prefix + "bsa_type") == "F"){
					over_settle=parseFloat(GetCellValue(Row, prefix + "release_wgt")) / parseFloat(GetCellValue(Row, prefix + "teu"));
				}
				SetCellValue(Row, prefix + "over_settle",ComRound(over_settle, 1));
			}
/*			
Change History OverSettle(_ .. _)
----------------
--4th Change
----------------
if(GetCellValue(Row, prefix + "ratio_type") == "T"){
if(parseInt(GetCellValue(Row, prefix + "grand_ttl_slot")) > parseInt(GetCellValue(Row, prefix + "bsa_slot"))){
SetCellValue(Row, prefix + "over_settle",parseInt(GetCellValue(Row, prefix + "grand_ttl_slot")) - parseInt(GetCellValue(Row, prefix + "bsa_slot")));
					}else{
						SetCellValue(Row, prefix + "over_settle","0");
					}
				}else{
if(parseFloat(GetCellValue(Row, prefix + "grand_ttl_wgt")) > parseFloat(GetCellValue(Row, prefix + "bsa_wgt"))){
if(parseFloat(GetCellValue(Row, prefix + "teu")) > 0){
SetCellValue(Row, prefix + "over_settle",
(	parseFloat(GetCellValue(Row, prefix + "grand_ttl_wgt")) -
parseFloat(GetCellValue(Row, prefix + "bsa_wgt"))
)	/	parseFloat(GetCellValue(Row, prefix + "teu"))
								;
						}else{
							SetCellValue(Row, prefix + "over_settle","0");
						}
					}else{
						SetCellValue(Row, prefix + "over_settle","0");
					}
				}
----------------
--3th Change
----------------
			if(ColSaveName(Col) == prefix + "over_slot" || ColSaveName(Col) == prefix + "over_wgt"){
var wgt_val=GetCellValue(Row, prefix + "over_wgt")  / GetCellValue(Row, prefix + "teu");
if(GetCellValue(Row, prefix + "over_slot") > wgt_val){
SetCellValue(Row, prefix + "over_settle",GetCellValue(Row, prefix + "over_slot"));
					SetCellValue(Row, prefix + "over_settle_by","S");
				}else{
					SetCellValue(Row, prefix + "over_settle","");
					SetCellValue(Row, prefix + "over_settle_by","W");
				}
			}
----------------
--2nd Change
----------------
			if(ColSaveName(Col) == prefix + "grand_ttl_slot" || ColSaveName(Col) == prefix + "grand_ttl_wgt"){
var slot_val=GetCellValue(Row, prefix + "grand_ttl_slot") / GetCellValue(Row, prefix + "teu");
var wgt_val=GetCellValue(Row, prefix + "grand_ttl_wgt")  / GetCellValue(Row, prefix + "teu");
if(GetCellValue(Row, prefix + "grand_ttl_slot") > wgt_val)
SetCellValue(Row, prefix + "over_settle",GetCellValue(Row, prefix + "grand_ttl_slot"));
				else
					SetCellValue(Row, prefix + "over_settle","");
			}
*/
		}
	}

	function t8sheet1_OnSearchEnd(sheet, ErrMsg) {
		setTotalText(sheet);
	}

	function t8sheet2_OnSearchEnd(sheet, ErrMsg) {
		setTotalText(sheet);
	}

	function t8sheet3_OnSearchEnd(sheet, ErrMsg) {
		setTotalText(sheet);
	}

	function t8sheet4_OnSearchEnd(sheet, ErrMsg) {
		setTotalText(sheet);
	}

	function setTotalText(sheet) {
		if(sheet.RowCount()<= 0 )  {
			return;
		}
		
		if(mBtnDis == "Y"){
			sheet.SetSumText(0,2,"TTL");
		}else {
			sheet.SetSumText(0,1,"TTL");
		}
		
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
