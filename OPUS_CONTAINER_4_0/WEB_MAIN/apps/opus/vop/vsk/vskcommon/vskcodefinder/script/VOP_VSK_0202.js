/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_vsk_0202.js
*@FileTitle  : Lane Code Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class vop_vsk_0202 : business script for vop_vsk_0202
 */
 // public variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var LANE="lane";
 var ROWMARK="|";
 var FIELDMARK=",";
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
 function processButtonClick(){
      var sheetObject1=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
 		if (!ComIsBtnEnable(srcName)) return;  
         switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH,"grid");
				break;
			case "btn_Select":
				var cnt=sheetObject1.RowCount();
				if(cnt > 0){
					comPopupOK();
					//ComPopUpReturnValue(sheetObj.GetCellValue(sheetObj.GetSelectRow(),'sheet1_vsl_slan_cd'));
				}else{
					ComClosePopup(); 
				}
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
         } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage('VSK00011');
 		} else {
 			ComShowMessage(e.message);
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
 /** 
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */ 
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
     
     for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
     initControl();
     document.form.vsl_slan_cd.focus();
 }
 /**
 * setting combo initial values and header
 * param : comboObj, comboNo
 * adding case as numbers of counting combos
 */ 
function initCombo(comboObj, comboNo) {
    var formObject=document.form
    switch(comboNo) {  
          case 1: 
           with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "35");
				SetColWidth(1, "150");
				//SetBackColor("#CCFFFD");
				//SetFontColor("#000000");
				SetColBackColor(0,"#CCFFFD");
				SetColFontColor(0,"#000000");
				SetColBackColor(1,"#CCFFFD");
				SetColFontColor(1,"#000000");
 					SetDropHeight(160);
 		    	}
           
 			doActionIBCombo(sheetObjects[0],formObject,IBSEARCH,comboObj,SEARCH,LANE);
 			break; 
 	     } 
 	}
/**
 * registering initial event 
 **/
function initControl() {
	DATE_SEPARATOR="/";
	var formObject=document.form;
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat  ('keyup', 'obj_change' , form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH, "ComCd");
}


/**
 * Handling data change event
 */
function obj_change(){
	var formObject=document.form;
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
            case "vsl_slan_cd":
//            	formObject.vsl_slan_cd.value="";
            	var cnt=formObject.vsl_slan_cd.value;
				cnt=cnt.length;
				if(cnt == 3){
					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH, "ComCd");
				}
            	break;	
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}
 // Retrieving Lane SVC Type in input field
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      // Retrieve
			if(validateForm(sheetObj,formObj,sAction)){
				if (sheetObj.id == "sheet1") {				
					//Initializing combo
					sComboObj.RemoveAll();
					formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("VSK_COMGS.do", FormQueryString(formObj));
					var comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
					addComboItem(sComboObj,comboItems);				
				}
			}
            break;
    }
}
/**
 * Adding data to combo field
 */	
function addComboItem(comboObj,comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
	}   		
	comboObj.InsertItem(0, "ALL","");
	comboObj.SetSelectIndex(0);
	}
 /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     switch(sheetNo) {
         case 1:      // sheet1 init
        	 with(sheetObj){
	           var HeadTitle="|Lane|Lane Name|Lane Service Type";
	           var prefix="sheet1_";
	
	           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	           var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	           var headers = [ { Text:HeadTitle, Align:"Center"} ];
	           InitHeaders(headers, info);
	
	           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:310,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_svc_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            
	           InitColumns(cols);
	
	           SetEditable(0);
	           SetCountPosition(0);
	           SetSheetHeight(280);
           }
         break;
         }
     }
   // handling sheet process
 function doActionIBSheet(sheetObj,formObj,sAction,flag) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
        case IBSEARCH:      //Retrieve
        	  if(flag == "grid"){
        		  sheetObj.SetWaitImageVisible(0);
        		  ComOpenWait(true);
	        	  formObj.f_cmd.value=COMMAND11;
	        	  var tempVslSvcTpCd=comboObjects[0].GetSelectText();
	        	  if(tempVslSvcTpCd == "ALL" || tempVslSvcTpCd == ""){
	        		  formObj.vsl_svc_tp_cd.value="";
	        	  }else{
	        		  formObj.vsl_svc_tp_cd.value=tempVslSvcTpCd;
	        	  }
	              //sheetObj.DoSearch("VOP_VSK_0202GS.do?op_=0202",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	        	  sheetObj.DoSearch("VOP_VSK_0202GS.do?op_=0202",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
	        	  ComOpenWait(false);
        	  }else{
        		  if(formObj.vsl_slan_cd.value == ""){
        			  return;
        		  }
        		  sheetObj.SetWaitImageVisible(0);
        		  ComOpenWait(true);
        		  formObj.f_cmd.value=COMMAND12;
        		  //var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202" , FormQueryString(formObj));
        		  var sXml=sheetObj.GetSearchData("VOP_VSK_0202GS.do?op_=0202" , FormQueryString(formObj));
        		  var checkLane=ComGetEtcData(sXml, "checkLane");
      			  if(checkLane == undefined){
      				  sheetObj.LoadSearchData(sXml,{Sync:1} );
      				  formObj.vsl_slan_cd.value="";	
      				  formObj.vsl_slan_cd.focus();
      			  }else{
      				  var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
      				  if(vslSlanNm == ""){
      					  ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
      					  formObj.vsl_slan_cd.value="";	
          				  formObj.vsl_slan_cd.focus();
      				  }else{
      					  formObj.vsl_slan_nm.focus();
      				  }
      			  }
      			 ComOpenWait(false);
        	  }
             break;
		case IBINSERT:
             break;
     }
 }
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
     }
     return true;
 }
 /**
  * Returning to Parent Screen
  */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	
	/*var a = new Array();	
	for(var i = 0; i< sheetObj.ColCount; i++){
		a[i] = sheetObj.GetCellValue(sheetObj.GetSelectRow(), i);
	}
	ComPopUpReturnValue(a);
	*/
	//ComPopUpReturnValue(sheetObj.GetCellValue(sheetObj.GetSelectRow(),'sheet1_vsl_slan_cd'));
	comPopupOK();
}


//function sheet1_OnClick(sheetObj, Row, Col){
////	comPopupOK();
////window.returnValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'sheet1_vsl_slan_cd');
//	ComPopUpReturnValue(sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'sheet1_vsl_slan_cd'));
//}
 /**
  * Handling enter key
  * @param sheetObj
  * @param formObj
  * @return
  */
function DoSearch(){
 	var formObject=document.form;
 	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH,"grid");
 }

