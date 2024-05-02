/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0183.js
*@FileTitle  : Customer Code Entry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer's work*/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
      /***** using extra sheet valuable if there are more 2 sheets *****/
	  var sheetObject1=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
      try {
    	  var srcName=ComGetEvent("name");
    	  if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					case "btn_new":
						sheetObject1.RemoveAll();
						formObject.reset();
					break;
					case "btn_Close":
						window.close();
						break;
					case "btn_sendfile":
						if (validateForm(sheetObjects[0], formObject, COMMAND01)) {
							ComOpenPopup("/opuscntr/ESM_BKG_0184.do?msg_tp_cd=C&rcv_snd_div_cd=S&popup=y" 
									+ "&ref_seq="	+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ref_seq" )
									+ "&anr_decl_no="	+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "anr_decl_no" )
									, 700, 610, "0002", "1,0", false);
						}
					break;
					case "btn_receivefile":
						if (validateForm(sheetObjects[0], formObject, COMMAND01)) {
							ComOpenPopup("/opuscntr/ESM_BKG_0184.do?msg_tp_cd=C&rcv_snd_div_cd=R&popup=y" 
									+ "&ref_seq="	+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ref_seq" )
									+ "&anr_decl_no="	+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "anr_decl_no" )
									, 700, 610, "0002", "1,0", false);
						}
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
    if( document.form.bl_no.value != '' ){
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
    if( document.form.popup.value == 'y' ){
    	//document.getElementById("navi").style.display = "none";
    	//document.getElementById("headtitle").innerHTML="<tr><td class='title'><img src='img/icon_title_dot.gif' align='absmiddle'><span id='title'></span></td></tr>"
    }
    //document.form.bl_no.value = 'JXBE02310007' ;
    initControl();
}

function initControl() {
     //handling Axon event1. event catch
//	 axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
//	 axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	 axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 }

/**
 * handling in case of inserting searching condition   
 */

//function obj_KeyUp() {
//	var formObject=document.form;
//	var blno=formObject.bl_no.value;
//	var cntrno=formObject.cntr_no.value;
//	if ( ComChkLen(blno, 12) == "2" ) {
//		formObject.cntr_no.focus();
//	}
//	if ( ComChkLen(cntrno, 14) == "2" ) {
//    		formObject.target_bl.focus();
//    	}
//}

   /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
			var sheetID=sheetObj.id;
			switch(sheetID) {
				case "sheet1":
					with(sheetObj){
					var HeadTitle1="|Seq.|DIV|Number|Send\nStatus|Receive\nStatus|Send ID|Send\nOffice|Send Date|Receive Date|Error\nCode|Error Description|Declaration No";
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataGetRowMerge:1 } );
			        var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers=[ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
			        var cols=[ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ref_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"div",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"edi_snd_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"edi_snd_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"snd_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			             {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",          KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",          KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"edi_msg_err_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"err_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"anr_decl_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 } ];
			        InitColumns(cols);
			        SetEditable(1);
			        SetEllipsis(1);
			        
			        SetCountPosition(0);
	                SetSheetHeight(510);
			        }
 				break;
 			}
 	}
   // handling of Sheet 
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					//alert("test1");
				var target;
				if ( formObj.target_bl.checked ){
					target='bl_log';
					if ( formObj.target_cntr.checked )
						target='all';
				} else if( formObj.target_cntr.checked ) {
					target='cntr_log';
				} else {
					target='bl_log';
				}
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0183GS.do?target=" +target, FormQueryString(formObj));
				sheetObj.RenderSheet(0);
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.RenderSheet(1);
			}
		break;
     }
 }
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
	 switch (sAction) {
 		case IBSEARCH: 
 			if (formObj.bl_no.value == "" ) 
 			{
 				ComShowCodeMessage('BKG00626', 'B/L No');
// 				formObj.bl_no.focus();
 				return false;
 			}
 			return true;
 		break;
 		
 		case COMMAND01: //EDIT BL
 			if (sheetObjects[0].RowCount()<= 0) {
				ComShowCodeMessage("BKG00395");
				return false;
			}
 			return true;
		break;
	 }
}
 /**
  * method which can be displayed at memo pad 
  * 
  * @param sheetObj
  * @param row
  * @param col
  * @return
  */
 function sheet1_OnClick(sheetObj, row, col){
	 if( col == 11 ) {
		 //alert( sheetObj.CellValue(row,col) );
		 if( sheetObj.GetCellValue(row,col) != '' )
			 ComShowMemoPad(sheetObj, null, null, true, 400, 80);	// odd number of row is not editable
	 }
 }  
