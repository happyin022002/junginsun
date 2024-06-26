/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_3005.js
*@FileTitle  : Hard Coding Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/

/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var IBEDIT=901;

// Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
      /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	         var sheetObject=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
         switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
			case "btn_Add":
				doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
				break;
			case "btn_Del":
				doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
				break;
			case "btn_Edit":
				doActionIBSheet(sheetObjects[0], formObject, IBEDIT); 				
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
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
}
 
function initControl() {
	var formObject = document.form;
    axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
} 
 
function bkg_keypress(){
    switch(event.srcElement.dataformat){
    	case "engup":
        //영문대문자
			ComKeyOnlyAlphabet('upper','44|95|32');
        break;
      case "engupnum":
        //숫자+"영문대분자"입력하기
      	ComKeyOnlyAlphabet('uppernum','44|95|32');
        break;
      case "engdnnum":
        //숫자+"영문대분자"입력하기
      	ComKeyOnlyAlphabet('lowernum');
        break;
      case "num":
        //숫자 입력하기
        ComKeyOnlyNumber(event.srcElement);
        break;	            
      default:
    }
}   
 
/**
 * setting sheet initial values and header
 * 
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     switch(sheetNo) {
         case 1:      //sheet1 init
        	 with(sheetObj){             
               //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        	 var HeadTitle1 = "|	||Seq|Region|Country|Last Name|First Name|Active|Creation Date|Creation User ID|Update Date|Update User ID";
               var headCount=ComCountHeadTitle(HeadTitle1);
               (headCount, 0, 0, true);

               SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:5, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                  {Type:"Radio",	Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"radio_chk" },
                  {Type:"Text",     Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_esig_seq",  	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                  {Type:"Seq",		Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                  {Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"region_nm",    	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                  {Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",    		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                  {Type:"Text",     Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"esig_lst_nm",  	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                  {Type:"Text",     Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"esig_n1st_nm",   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                  {Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_flg",      	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                  {Type:"Text",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",   		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                  {Type:"Text",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",  	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                  {Type:"Text",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",			KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                  {Type:"Text",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",  	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            
               InitColumns(cols);
               SetEditable(1);	               
               SetSheetHeight(450);
               //SetColProperty(0 , 3, {AcceptKeys:"E|N|[_]" , InputCaseSensitive:1});
           }
           break;
     }
 }  
 // handling sheet process
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
     	case IBSEARCH:      //retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = SEARCH;			
			sheetObj.DoSearch("ESM_BKG_3005GS.do", FormQueryString(formObj));
			break;
     	case IBCLEAR:
     		formObj.country_code.value = "";
     		formObj.esignature_last_name.value = "";
     		sheetObj.RemoveAll();
            break;
     	case IBINSERT: 		// New
			var url = "/opuscntr/ESM_BKG_3100.do";
			var winName = "ESM_BKG_3100";
			var reqWin = ComOpenWindowCenter(url, winName, 600, 430, true, true); 	
			break;
     	case IBDELETE: 		// delete
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			if(!ComShowCodeConfirm('COM12165', 'data')) return false; 	
			
			formObj.f_cmd.value = REMOVE;			
      	    sheetObj.WaitImageVisible=false;
      	    ComOpenWait(true);      	   
      	    var sParam = FormQueryString(formObj) + "&bl_esig_seq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_esig_seq");
      	    sheetObj.GetSaveData("ESM_BKG_3005GS.do", sParam);
      	    ComOpenWait(false);	
      	    
      	    doActionIBSheet(sheetObj,formObj,IBSEARCH);
			break;			
     	case IBEDIT: 		// edit
			if(sheetObj.GetSelectRow() < 0 || sheetObj.GetCellValue(sheetObj.GetSelectRow(), "radio_chk") == 0) {
				ComShowCodeMessage("COM12113", "Data");
				return false;
			}
     		var url = "/opuscntr/ESM_BKG_3100.do?bl_esig_seq=";
			var params = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_esig_seq");
			var winName = "ESM_BKG_3100";
			var reqWin = ComOpenWindowCenter(url + params, winName, 600, 500, true, true); 	
			break;
     }
 }

function searchESignatureList() {
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
}
	
 /**
  * handling process for input validation
  */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:
			break;
		case IBDELETE:
			if(sheetObj.GetSelectRow() < 0 || sheetObj.GetCellValue(sheetObj.GetSelectRow(), "radio_chk") == 0) {
				ComShowCodeMessage("COM12113", "Data");
				return false;
			}
			break;
	 }
     return true;
}


