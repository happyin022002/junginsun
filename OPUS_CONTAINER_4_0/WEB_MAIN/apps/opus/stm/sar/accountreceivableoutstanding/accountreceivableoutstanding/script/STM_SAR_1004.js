/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1004.js
*@FileTitle  : Outstanding Aging Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/**
 * [STM_SAR-1004] Outstanding Aging Inquiry
 * @extends
 * @class Outstanding Aging Inquiry
 */
// ===================================================================================
// 1> global variable
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
var sheet2=null;
//IBMultiCombo
var comboObjects=new Array();
var combo1=null
var comboCnt=0;
// html form
var frm=null;
// Search List
var dataList=null;
var dataPos=0;  // index  from 0 
// combo1 office list
var ofcList=null;
/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
// ===================================================================================
// 2> initializing
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 **/
function loadPage() {
	//global variable set 
    frm=document.form;
    sheet1=sheetObjects[0];  
    sheet2=sheetObjects[1];
    sheetCnt=sheetObjects.length ;
	// sheet initialize
	for (var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBMultiCombo초기화
	combo1=comboObjects[0];
	comboCnt=comboObjects.length;
	for (var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
    //Form event register
    initControl();
    ComBtnDisable("btn_previous");
    ComBtnDisable("btn_next");
    frm.rct_cust_cnt_cd.disabled = true;
	frm.rct_cust_seq.disabled = true;

    // combo 및 초기 데이타 취득
    doActionIBSheet(INIT);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
		case "sheet1": 
		    with(sheetObj){
	        	  SetDataRowHeight(25);
			      var HeadTitle1="RHQ|AR_OFC_CODE|CUSTOMER_NUMBER|CUSTOMER_NAME|TTL_CNT|";
			      HeadTitle1 += "TTL_OTS|NOT_ARRIVED_CNT|NOT_ARRIVED_AMT|WI_TERM_CNT|WI_TERM_AMT|BAD_OTS_CNT|BAD_OTS_AMT|LT_CNT|LT_AMT|";
			      HeadTitle1 += "BELOW_30_CNT|BELOW_30_AMT|BELOW_60_CNT|BELOW_60_AMT|BELOW_90_CNT|BELOW_90_AMT|BELOW_120_CNT|BELOW_120_AMT|";
			      HeadTitle1 += "BELOW_180_CNT|BELOW_180_AMT|OVER_180_CNT|OVER_180_AMT";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount, 5, 0, true);
		
			      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_num",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col75",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col76",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col74",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col65",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col66",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col67",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col57",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col58",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col77",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col68",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col60",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col61",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col69",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col70",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col78",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col79",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col62",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col63",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col71",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col72",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col80",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col81",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(0);
			      SetVisible(false);
	            }
			break;	
		case "sheet2":
		    with(sheetObj){
			      SetDataRowHeight(25);
			      var HeadTitle1="RHQ|AR_OFC_CODE|CUSTOMER_NUMBER|CUSTOMER_NAME|";
			      HeadTitle1 += "col02|col03|col04|col05|col06|col07|col08|col09|col11|col12|col13|col14|col15|col16|col17|col18|col20|col21|col22|col23|";
			      HeadTitle1 += "col24|col25|col26|col27|col29|col30|col31|col32|col33|col34|col35|col36|col38|col39|col40|col41|col42|col43|col44|col45|";
			      HeadTitle1 += "col47|col48|col49|col50|col51|col52|col53|col54|col56|col57|col58|col59|col60|col61|col62|col63|col65|col66|col67|col68|";
			      HeadTitle1 += "col69|col70|col71|col72|col74|col75|col76|col77|col78|col79|col80|col81";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount, 5, 0, true);
		
			      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_num",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col02",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col03",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col04",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col05",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col06",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col07",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col08",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col09",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col11",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col12",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col13",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col14",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col15",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col16",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col17",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col18",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col20",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col21",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col22",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col23",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col24",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col25",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col26",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col27",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col29",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col30",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col31",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col32",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col33",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col34",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col35",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col36",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col38",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col39",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col40",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col41",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col42",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col43",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col44",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col45",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col47",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col48",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col49",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col50",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col51",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col52",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col53",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col54",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col56",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col57",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col58",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col59",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col60",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col61",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col62",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col63",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col65",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col66",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col67",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col68",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col69",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col70",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col71",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col72",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col74",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col75",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col76",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col77",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col78",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col79",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col80",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"col81",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(0);
			      SetVisible(false);
	            }
		    break;
	}
}
/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.SetMultiSelect(1);
//no support[check again]CLT 	comboObj.UseCode=true;
//no support[check again]CLT 	comboObj.LineColor="#7896B1";	
	comboObj.SetMultiSeparator(",");
	comboObj.SetDropHeight(240);
	comboObj.SetBackColor("#CCFFFD");
	comboObj.SetUseEdit(1);
}
// ===================================================================================
// Private function
// ===================================================================================
 /**
  * handling process for input validation
  */
 function validateForm() {
	 var due_dt=frm.due_dt.value;
	 if (ComIsNull(due_dt)) {
		 //msgs['COM12113'] = 'Please select {?msg1}';
		 ComShowCodeMessage("COM12113" , "As of Date");
		 frm.due_dt.focus();
		 return false;
	 }
	 frm.multi_clt_ofc_cd.value=combo1.GetSelectText();
	 if (ComIsNull(combo1.GetSelectText())) {
		 //msgs['COM12113'] = 'Please select {?msg1}';
		 ComShowCodeMessage("COM12113" , "Office");
		 frm.btn_multi_office_popup.focus();
		 return false;
	 }
	 if (ComIsNull(frm.bk1.value)) {
		 //msgs['SAR00013'] = 'Please enter {?msg1}.';
		 ComShowCodeMessage("SAR00013" , "Bucket");
		 frm.bk1.focus();
		 return false;
	 }
	 if (ComIsNull(frm.bk2.value)) {
		 //msgs['SAR00013'] = 'Please enter {?msg1}.';
		 ComShowCodeMessage("SAR00013" , "Bucket");
		 frm.bk2.focus();
		 return false;
	 }
	 if (ComIsNull(frm.bk3.value)) {
		 //msgs['SAR00013'] = 'Please enter {?msg1}.';
		 ComShowCodeMessage("SAR00013" , "Bucket");
		 frm.bk3.focus();
		 return false;
	 }
	 if (ComIsNull(frm.bk4.value)) {
		 //msgs['SAR00013'] = 'Please enter {?msg1}.';
		 ComShowCodeMessage("SAR00013" , "Bucket");
		 frm.bk4.focus();
		 return false;
	 }
	 if (ComIsNull(frm.bk5.value)) {
		 //msgs['SAR00013'] = 'Please enter {?msg1}.';
		 ComShowCodeMessage("SAR00013" , "Bucket");
		 frm.bk5.focus();
		 return false;
	 }
	 if (ComIsNull(frm.bk6.value)) {
		 //msgs['SAR00013'] = 'Please enter {?msg1}.';
		 ComShowCodeMessage("SAR00013" , "Bucket");
		 frm.bk6.focus();
		 return false;
	 }	 
     return true;
 }
 /**
  * display paging information
  */
  function displayPaing(dataList) {
	  document.getElementById("paging_info").innerText="[" + (dataPos+1) + " / " + dataList.length + "]";
  }
// ===================================================================================
// Form Event Processing
// ===================================================================================
// Button event handler
document.onclick=processButtonClick;
/**
 * Button event handler function
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	switch (srcName) {
	case "btn_due_dt":
		var cal=new ComCalendar();
        cal.select(frm.due_dt, 'yyyy-MM-dd');
		break;
	case "btn_retrieve":
		doActionIBSheet(SEARCHLIST);
		break;
	case "btn_next":
		if (dataList != null && dataPos < dataList.length) {
			// position +
			dataPos++;
			// form 설정
			SarMapToForm(frm, dataList[dataPos]);
			if (dataPos > 0) {
				ComBtnEnable("btn_previous");
			}		
			if (dataPos == dataList.length-1) {
				ComBtnDisable("btn_next");
			}		
			displayPaing(dataList);
		} 		
		break;
	case "btn_previous":
		if (dataList != null && dataPos < dataList.length) {
			// position +
			dataPos--;
			// form 설정
			SarMapToForm(frm, dataList[dataPos]);	
			if (dataPos == 0) {
				ComBtnDisable("btn_previous");
			}	
			if (dataList.length > 1) {
				ComBtnEnable("btn_next");
			}
			displayPaing(dataList);
		}
		break;		
	case "btn_office":		
		doActionIBSheet(COMMAND01);
		break;	
	case "btn_print":			
		if (sheet2.RowCount()<= 0 ) {
			// msgs["SAR00030"] = "There is no data to search.";
			ComShowCodeMessage("SAR00030");
			return false;
		}
		var sXml="<?xml version='1.0' ?><SHEET>";;
		sXml += SarRdGetDataXml(sheet2, 1);		
		// Search condition
		sXml += "<ETC>";
		sXml += "<due_dt>" + frm.due_dt.value + "</due_dt>"
		var bl_inv_tp=ComGetObjValue(frm.bl_inv_tp);
		if (bl_inv_tp == "") {
			bl_inv_tp="All";
		} else if (bl_inv_tp == "BL") {
			bl_inv_tp="BL";
		} else if (bl_inv_tp == "INV") {
			bl_inv_tp="Invoice";
		}
		sXml += "<bl_inv_tp>" + bl_inv_tp + "</bl_inv_tp>";
		var sum_ofc_cust_tp=ComGetObjValue(frm.sum_ofc_cust_tp);
		if (sum_ofc_cust_tp == "OFC") {
			sum_ofc_cust_tp="Office";
		} else if (frm.sum_ofc_cust_tp.value == "CUST") {
			sum_ofc_cust_tp="Customer";
		} 
		sXml += "<sum_ofc_cust_tp>"+sum_ofc_cust_tp+"</sum_ofc_cust_tp>";
		var sum_tp=ComGetObjValue(frm.sum_tp);
		if (sum_tp == "OFC") {
			sum_tp="Each Sum Offices";
		} else if (sum_tp == "") {
			sum_tp="Sum of Offices";
		} 
		sXml += "<sum_tp>" + sum_tp + "</sum_tp>"
		sXml += "<bl_curr_cd>" + ComGetObjValue(frm.bl_curr_cd) + "</bl_curr_cd>"
		var bl_sum_tp=ComGetObjValue(frm.bl_sum_tp);
		if(bl_sum_tp == "") {
			bl_sum_tp="ALL";
		}
		sXml += "<bl_sum_tp>" + bl_sum_tp + "</bl_sum_tp>"
		var cr_mk_flg=ComGetObjValue(frm.cr_mk_flg);
		if(cr_mk_flg == "") {
			cr_mk_flg="ALL";
		}
		sXml += "<cr_mk_flg>" + cr_mk_flg + "</cr_mk_flg>"
		sXml += "<bk1>" + frm.bk1.value + "</bk1>"
		sXml += "<bk2>" + frm.bk2.value + "</bk2>"
		sXml += "<bk3>" + frm.bk3.value + "</bk3>"
		sXml += "<bk4>" + frm.bk4.value + "</bk4>"
		sXml += "<bk5>" + frm.bk5.value + "</bk5>"
		sXml += "<bk6>" + frm.bk6.value + "</bk6>"
		sXml += "</ETC>";
		sXml += "</SHEET>";
		var rf=""; //"/rf ["+ RDServerIP + "/CPS_CNI_0063.do]";		
		var rpost="/rpost ["+ FormQueryString(frm) +"]";
		var rpaper="/rpaper [A4]";
		var rv="/rv " + SarRdCondAllValue(frm);
		frm.com_mrdArguments.value=rf + " " + rv + " " + rpost + " " + rpaper;
		frm.com_mrdBodyTitle.value="Outstanding Aging Inquiry";		
		frm.com_mrdPath.value="apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1004.mrd";
		frm.com_mrdXmlData.value=sXml;
		SarRdPopup(1000,600);
		break;		
	case "btn_excel":
		if (sheet1.RowCount()<= 0 ) {
			// msgs["SAR00030"] = "There is no data to search.";
			ComShowCodeMessage("SAR00030");
			return false;
		}
 		sheet1.Down2Excel({ HiddenColumn:1,TreeLevel:false,SheetName:"OutstandingAgingInquiry"});
		break;
	case "btn_cust":
		if (ComGetObjValue(frm.sum_ofc_cust_tp) != "CUST") {
			return;
		}
		var cust_cnt_cd="";
		var cust_seq="";		
		var classId="FNS_INV_0086";
		var param='?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId;
		ComOpenPopup('/opuscntr/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '0,0', false, false);		
		break;
	case "btn_new":		
		document.getElementById("paging_info").innerText="";
		//var combo1Text = document.form.combo1_text.value; 
		frm.reset();
		//document.form.combo1_text.value = combo1Text;
		combo1.SetSelectIndex(-1, true);
		combo1.SetSelectText(strUsr_ofc_cd);
		ComBtnDisable("btn_previous"); 
		ComBtnDisable("btn_next");
		frm.bil_to_cust_cnt_cd.value="";
		frm.bil_to_cust_seq.value="";
		sheet1.RemoveAll();
		sheet2.RemoveAll();
	}
}
/**
 * Form Event register
 */
function initControl() {
    // focus in
//    axon_event.addListenerFormat('beforeactivate', 'obj_activate',    frm);
    axon_event.addListenerFormat('change', 'obj_change', frm);
//    axon_event.addListenerFormat ('keydown', 'obj_keydown', frm);
//    axon_event.addListenerForm('keypress', 'obj_keypress', frm);
//    axon_event.addListenerForm ('keyup', 'obj_keyup', frm);
    axon_event.addListenerFormat('blur', 'obj_blur', frm);    
}
/**
 * HTML Control onChange
 */
function obj_change() {
    switch (ComGetEvent("name")) {
    case "rct_cust_seq":
		if (frm.rct_cust_cnt_cd.value != '' && frm.rct_cust_seq.value != '') {			
			frm.rct_cust_seq.value=ComLpad(frm.rct_cust_seq.value, 6, "0");
			doActionIBSheet(SEARCH06);
		}
		break;    
    default:
		break;
	}	
}
/** 
 * handling Keypress event of Object  <br>
 * checking validation of input value by dataformat of object  <br>
 */ 
function obj_keyup(){	
	switch (ComGetEvent("name")) {		
		case "rct_cust_cnt_cd":
			var rctCustCntCd=event.srcElement.value;			
			if (rctCustCntCd.length == 2) {
				frm.rct_cust_seq.focus();
			}
 		break;
	}
} 
/**
 * sum_ofc_cust_tp_onchange
 * HTML Control onChange
 */
function sum_ofc_cust_tp_onclick(obj) {
	if (obj.value == "OFC") {
		frm.rct_cust_cnt_cd.value="";
		frm.rct_cust_seq.value="";
		frm.rct_cust_nm.value="";
		frm.rct_cust_cnt_cd.className="input2";
		frm.rct_cust_seq.className="input2";
		frm.rct_cust_cnt_cd.disabled = true;
		frm.rct_cust_seq.disabled = true;
		frm.rct_cust_nm.className="input2";
		frm.bil_to_cust_cnt_cd.value="";
		frm.bil_to_cust_seq.value="";
	} else {
		frm.rct_cust_cnt_cd.className="";
		frm.rct_cust_seq.className="";	
		frm.rct_cust_cnt_cd.disabled = false;
		frm.rct_cust_seq.disabled = false;		
	}
}
/**
 * HTML Control KeyPress
 */
function obj_keypress() {		
	switch(event.srcElement.dataformat) {	
	case "engup":
		ComKeyOnlyAlphabet('upper'); 
		break;
	case "engnum":
		ComKeyOnlyAlphabet('uppernum'); 
		break;
	case "num":
    	//only number
		ComKeyOnlyNumber('num');
        break;
	case "int":
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "ymd":
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "float":
		ComKeyOnlyNumber(ComGetEvent(), "-.");
		break;
	default:
		//common standard: recognization only number, english
		var keycode="32";
		for(var i=33;  i <= 47; i++) keycode += "|" + i;
		for(var i=58;  i <= 64; i++) keycode += "|" + i;		
		for(var i=91;  i <= 96; i++) keycode += "|" + i;
		for(var i=123;  i <= 127; i++) keycode += "|" + i;
		ComKeyOnlyAlphabet('uppernum' , keycode);
		break;     
	}
}
/**
 * Handling OnKeyDown even <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param N/A
 * @return N/A
 * @author 
 * @version 2009.04.17
 */       
function obj_keydown(){
   //Proposal No,S/C No.,Retrieving by enter key
   var eleName=ComGetEvent("name");
   var keyValue=null;
   if(event == undefined || event == null) {
	   keyValue=13;
   } else {
	   keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
   }
   if (keyValue == 13 && eleName == "due_dt") {
	   doActionIBSheet(SEARCHLIST);
   }
}
/**
 * HTML Control Focus out
 **/
function obj_blur() {
	switch (ComGetEvent("name")) {
	case "due_dt":		
		ComChkObjValid(ComGetEvent());
		break;	
	default:
		break;
	}
}                                         
/**
 * HTML Control Foucs in
 */
function obj_activate(){
   var eleNm=ComGetEvent("name");
   if (eleNm == "due_dt") {
	   ComClearSeparator(ComGetEvent());
   }
}
/** 
 * call method when select event on popup(FNS_INV_0086)<br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {array} rowArray   
 * @return none
 * @see #
 * @author Park sung yong
 * @version 2014.03.24
 */
function getFNS_INV_0086(rowArray) {
	var colArray=rowArray[0];
	for(var i=0; i < colArray.length; i++) {
		debugConsole(i + ":" + colArray[i]);
	}
	frm.rct_cust_cnt_cd.value=colArray[8];
	frm.rct_cust_seq.value=ComLpad(colArray[9], 6, "0");
	frm.bil_to_cust_cnt_cd.value=colArray[8];
	frm.bil_to_cust_seq.value=colArray[9];
	frm.rct_cust_nm.value = colArray[4];
}
//===================================================================================
//Sheet Event
//===================================================================================
function sheet1_OnClick(sheetObj, row, col, value) {	
	return false;
}
function combo1_OnCheckClick(s_code, s_index ) {
	// checked all
	if (s_index == 0) {		
		var checked=false;
		if (combo1.GetItemCheck(s_index)) {
			checked=true;
		}
		for(var i=1; i < combo1.GetItemCount(); i++) {
			combo1.SetItemCheck(i,checked);
		}
		// agent all
	} else if (s_index == 1) {		
		var checked=false;
		if (combo1.GetItemCheck(s_index)) {
			checked=true;
		}
		if (ofcList != null && ofcList.length > 0) {
			for(var i=3; i < combo1.GetItemCount(); i++) {
				var ofcInfo=ofcList[i - 2].split("^");
				for(var j=0 ; j < 18 ; j++) {
					debugConsole(j + ":" +ofcInfo[j]);
				}
				if (ofcInfo[15] == "AGT") {					
					combo1.SetItemCheck(i,checked);
				}		
			}	
		}
	} else if (s_index == 2) {		
		var checked=false;
		if (combo1.GetItemCheck(s_index)) {
			checked=true;
		}
		if (ofcList != null && ofcList.length > 0) {
			for(var i=3; i < combo1.GetItemCount(); i++) {
				var ofcInfo=ofcList[i - 2].split("^");
				for(var j=0 ; j < 18 ; j++) {
					debugConsole(j + ":" +ofcInfo[j]);
				}
				if (ofcInfo[15] == "BRH") {					
					combo1.SetItemCheck(i,checked);
				}		
			}	
		}
	}
} 
//===================================================================================
//IBCombo Event
//===================================================================================
//===================================================================================
//do Action Processing 
//===================================================================================
/**
 * Do action 
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	//[Search]
	if (sAction == SEARCHLIST) {
		if (validateForm()) {
			sheet1.WaitImageVisible=false;
			var multiRhqCd="";
		    for(var i=3; i < combo1.GetItemCount(); i++) {
		    	if (combo1.GetItemCheck(i) == true){
		    		var j=0;
		    		j=j+1
			        var row=ofcList[i-2].split("^");
			        if (j > 0 ) {
			        	multiRhqCd +=  " , " + row[2] ;
			        } else {
			        	multiRhqCd +=  row[2] +"'";
			        }
		    	}
		    }		    
		    frm.rhq.value=multiRhqCd;
			frm.f_cmd.value=sAction;
			var param=FormQueryString(frm);		
			ComOpenWait(true); 
			var sXml;
			setTimeout( function () {
	 			sXml=sheet1.GetSearchData("STM_SAR_1004GS.do", param);
	 			SarOpenWait(false,true);
			} , 100); 	
			 
			setTimeout( function () {	
				dataList=SarXml2ListMap(sXml);
				document.getElementById("h_bk1").innerHTML=frm.bk1.value;
				document.getElementById("h_bk2").innerHTML=frm.bk2.value;
				document.getElementById("h_bk3").innerHTML=frm.bk3.value;
				document.getElementById("h_bk4").innerHTML=frm.bk4.value;
				document.getElementById("h_bk5").innerHTML=frm.bk5.value;
				document.getElementById("h_bk6").innerHTML=frm.bk6.value;
				if (dataList != null && dataList.length > 0) {
					// form 설정
					SarMapToForm(frm, dataList[0]);
					//Excel
					sheet1.LoadSearchData(sXml,{Sync:1} );
					//Print
					sheet2.LoadSearchData(sXml,{Sync:1} );
					if (dataList.length > 1) {					
					    ComBtnEnable("btn_next");
					}		
					dataPos=0;
					displayPaing(dataList);
				} else {
					// msgs['COM130401'] = 'There is no data to search.';
					ComShowCodeMessage("COM130401");
					//초기화 해야 되는건지...
					$("input[name*='col']").val("");
					sheet1.RemoveAll();
					sheet2.RemoveAll();
				}		
			} , 110);		
		}
		//[open]	 	
	} else if (sAction == INIT) {
		// set combo outstanding offfice code
		{
			frm.f_cmd.value=SEARCH03;		
			var param="f_cmd=" + SEARCH03 + "&ofc_lvl_tp=QUERY";
 			var sXml=sheet1.GetSearchData("SARCommonGS.do", param);
			var strOtsOfcCd=ComGetEtcData(sXml,"ots_ofc_cd");			
			if (!ComIsNull(strOtsOfcCd)) {
				ofcList=strOtsOfcCd.split("|");				
				// -------------------------------------------------------------------------------------------------------------------
				//|OtsOfcCd^ArOfcCd^RhqCd^OtsSmryCd^OtsCd^RepOtsOfcCd^RctTpCd^RctUnapyFlg^OfcEntrLvlCd^ArCurrCd^DpPrcsKnt^BankCtrlCd
				//|0       ^1      ^2    ^3        ^4    ^5          ^6      ^7          ^8           ^9       ^10       ^11     
				// -------------------------------------------------------------------------------------------------------------------
				combo1.InsertItem(0, "ALL", "ALL");				
				combo1.InsertItem(1, "Agent", "AGT");
				combo1.InsertItem(2, "Branch", "BRH");
				for (var i=1; i < ofcList.length; i++ ) {
					var ofcInfo=ofcList[i].split("^");				
					combo1.InsertItem(i+2, ofcInfo[0], ofcList[i]);					
				}				
				combo1.SetSelectText(strUsr_ofc_cd);
			}
		}		
	} else if (sAction == SEARCH06) {
		frm.f_cmd.value=sAction;
		frm.cust_cnt_cd.value=frm.rct_cust_cnt_cd.value;
		frm.cust_seq.value=frm.rct_cust_seq.value;
		frm.bil_to_cust_cnt_cd.value=frm.rct_cust_cnt_cd.value;
		frm.bil_to_cust_seq.value=frm.rct_cust_seq.value;
 		var sXml=sheet1.GetSearchData("SARCommonGS.do", FormQueryString(frm));
		if(SarShowXmlMessage(sXml) != "") {
				ComShowMessage(SarShowXmlMessage(sXml));				
				ComClearObject(frm.rct_cust_cnt_cd);
				ComClearObject(frm.rct_cust_seq);
				ComClearObject(frm.cust_nm);			
				frm.rct_cust_cnt_cd.focus();
			} else {
				frm.rct_cust_nm.value=ComGetEtcData(sXml,"cust_nm");
		}
	}	
}

