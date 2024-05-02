/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   STM_SAR_0003.js
*@FileTitle  : Multi Office Code Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/**
 * [STM_SAR-0003] Multi Office Code Popup
 * @extends
 * @class Multi Office Code inquery & select
 */
// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================
// ===================================================================================
// global variable
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
var selOfcCds = new Array(); 
/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
// ===================================================================================
// initializing
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 **/
function loadPage(paramSelOfcCds) {
    //전역 변수 설정 
    frm=document.form;
    sheet1=sheetObjects[0];   
    sheetCnt=sheetObjects.length ;
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    selOfcCds = paramSelOfcCds;
    // Retrieve multi offfice coode
	doActionIBSheet(SEARCHLIST);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
	        var HeadTitle1="|Select|Office Code|ofc_brnc_agn_tp_cd|rhq_cd|ar_curr_cd|ots_smry_cd|dp_prcs_knt|bank_ctrl_cd|ofc_entr_lvl_cd|ots_ofc_cd|ots_cd|rct_tp_cd|rep_ots_ofc_cd|rct_unapy_flg";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);

	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkbox" },
	               {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ots_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_brnc_agn_tp_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rhq_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ar_curr_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ots_smry_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dp_prcs_knt" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bank_ctrl_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_entr_lvl_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ar_ofc_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ots_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rct_tp_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rep_ots_ofc_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rct_unapy_flg" } ];
	         
	        InitColumns(cols);
	        resizeSheet();
	        //SetSheetHeight(460);
	        SetEditable(1);
			break;
		}
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}

// ===================================================================================
// Private function
// ===================================================================================
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
     return true;
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
	if(ComGetBtnDisable(srcName)) return false;
	var chkALL=frm.chkALL;
	var chkBRH=frm.chkBRH;
	var chkAGT=frm.chkAGT;
	switch (srcName) {	
	case "btn_OK":
		comPopupOK();
		break;
	case "btn_Close":
		ComClosePopup(); 
		break;
	case "chkALL":				
		if (chkALL.checked) {
			sheet1.CheckAll("checkbox",1,1);
		} else {
			sheet1.CheckAll("checkbox",0,1);
		}		
		// other checkbox unchcked
		chkBRH.checked=false;
		chkAGT.checked=false;
		break;
	case "chkBRH":		 		
		checkRowByOfcTpCd("BRH", chkBRH.checked);		
		break;
	case "chkAGT":		 		
		checkRowByOfcTpCd("AGT", chkAGT.checked);
		break;
	}
}
/**
 * Button event handler function
 *  @param {string} ofcTpCd office type 
 *  @param {boolean} checked  checkbox checked  
 */
function checkRowByOfcTpCd(ofcTpCd, checked) {	
	for(var row=1; row <= sheet1.RowCount(); row++) {
		var ofc_brnc_agn_tp_cd=sheet1.GetCellValue(row, "ofc_brnc_agn_tp_cd");
		if (ofc_brnc_agn_tp_cd == ofcTpCd) {
			if (checked) {
				sheet1.SetCellValue(row,  "checkbox",1,0);
			} else {
				sheet1.SetCellValue(row,  "checkbox",0,0);
			}
		}
	}
}
// ===================================================================================
// Sheet Event & do Action Processing 
// ===================================================================================
/**
 * Do action 
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST) {
		sheet1.WaitImageVisible=false;
		ComOpenWait(true);  
		setTimeout( function () {
			frm.f_cmd.value=SEARCHLIST;		
			var sXml=sheet1.GetSearchData("STM_SAR_0003GS.do", FormQueryString(frm));
			sheet1.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
			
			// parameter 체크박스 설정 
			for(var i=0; i < selOfcCds.length; i++) {		
				for(var row=1; row <= sheet1.RowCount(); row++) {
					var paramOfcCd=selOfcCds[i];
					var sheetOfcCd=sheet1.GetCellValue(row, "ots_ofc_cd");
					if (paramOfcCd == sheetOfcCd) {			
						sheet1.SetCellValue(row, "checkbox",1);
					}
				}
			}
	    } , 100);
		
	}
}
