/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0756.JS
*@FileTitle  : Details per each package
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 var sheetObjects=new Array();
 var sheetCnt=0;
 var opener=window.dialogArguments;
 if (!opener) opener=parent;
 // Event handler processing by button click event  */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
    	 /***** using extra sheet valuable if there are more 2 sheets *****/
 		         var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
          if(document.getElementById("modalFlg").value == "Y"){
        	  var sheetCopy=opener.sheetObjects[3];
          }
     	try {
     		var srcName=ComGetEvent("name");
 					switch(srcName) {
 						case "btn_add":
 	 						var Rows=sheetObject1.DataInsert(-1);	 						
	 						sheetObjects[0].SetCellValue(Rows, "awk_cgo_seq",opener.document.getElementById("frm_awk_cgo_seq").value);
	 						sheetObjects[0].SetCellValue(Rows, "dim_seq",sheetObjects[0].GetCellValue(Rows, "seq"));
	 						sheetObjects[0].SetCellValue(Rows, "bkg_no",opener.document.getElementById("bkg_no").value);
						break;
 						case "btn_del": 							
 							ComRowHideDelete(sheetObject1, "DelChk");
 						break;
 						case "btn_ok": 
 							if(sheetObjects[0].RowCount()> 0){
 								opener.document.getElementById("details_button").setAttribute("style", "font-weight:bold;color:blue!important");
 							}else{
 								opener.document.getElementById("details_button").setAttribute("style", "font-weight:regular;color:##A0BAED");
 							}
 							var cnt=0;
 							for(var i=1; i<=sheetCopy.RowCount(); i++){
 								if(sheetCopy.GetCellValue(i, "DelChk") == "1"){
 									cnt++; 									
 								}
 							}
 							if (cnt > 0){
 								ComRowHideDelete(sheetCopy, "DelChk");
 							}
	 						sheetObjects[0].Copy2SheetCol(sheetCopy,"seq|ibflag|dim_len|dim_wdt|dim_hgt|indiv_pck_wgt|awk_cgo_seq|bkg_no|dim_seq","seq|ibflag|dim_len|dim_wdt|dim_hgt|indiv_pck_wgt|awk_cgo_seq|bkg_no|dim_seq",-1,-1,-1,2,false,false);
	 						for(var j=1; j<= sheetCopy.RowCount(); j++){
	 							if(sheetCopy.GetCellValue(j, "DelChk") == "1"){
	 								sheetCopy.SetCellValue(j, "DelChk","0",0);
	 							}
	 						}					
	 						ComClosePopup(); 
 						break;														
 						case "btn_close": 							
 							ComClosePopup(); 
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      * @param sheet_obj IBSheet Object
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
         if(document.getElementById("modalFlg").value == "Y"){
        	 for(var i=1; i<=opener.sheetObjects[3].RowCount(); i++){
            	 opener.sheetObjects[3].SetCellValue(i, "DelChk","0");
             }
			var sheetCopy=opener.sheetObjects[3];
			var rowVal=0;
			if(sheetCopy.RowCount()> 0){
				for(var i=1; i<=sheetCopy.RowCount(); i++){
					if(sheetCopy.GetCellValue(i, "awk_cgo_seq") == opener.document.getElementById("frm_awk_cgo_seq").value && sheetCopy.GetCellValue(i, "ibflag") != "D"){
						rowVal++;					
						sheetObjects[0].DataInsert(-1);
						sheetObjects[0].SetCellValue(rowVal, "ibflag",sheetCopy.GetCellValue(i, "ibflag"),0);
						sheetObjects[0].SetCellValue(rowVal, "dim_len",sheetCopy.GetCellValue(i, "dim_len"),0);
						sheetObjects[0].SetCellValue(rowVal, "dim_wdt",sheetCopy.GetCellValue(i, "dim_wdt"),0);
						sheetObjects[0].SetCellValue(rowVal, "dim_hgt",sheetCopy.GetCellValue(i, "dim_hgt"),0);
						sheetObjects[0].SetCellValue(rowVal, "indiv_pck_wgt",sheetCopy.GetCellValue(i, "indiv_pck_wgt"),0);
						sheetObjects[0].SetCellValue(rowVal, "bkg_no",sheetCopy.GetCellValue(i, "bkg_no"),0);
						sheetObjects[0].SetCellValue(rowVal, "awk_cgo_seq",sheetCopy.GetCellValue(i, "awk_cgo_seq"),0);
						sheetObjects[0].SetCellValue(rowVal, "dim_seq",sheetCopy.GetCellValue(i, "dim_seq"),0);
						sheetCopy.SetCellValue(i, "DelChk","1");
						
						sheetObjects[0].ColumnSort("dim_seq", "ASC");

					}	 						
				} 
			}
         }else{
        	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         }
     }
     
     function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
         sheetObj.ReNumberSeq();    
    }

     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 				var sheetID=sheetObj.id;
 				switch(sheetID) {
 					case "sheet1":
 					    with(sheetObj){
	 				      var HeadTitle1="|Seq||Length(CM)|Width(CM)|Height(CM)|Weight|awk_cgo_seq|bkg_no|dim_seq";
	 				      var headCount=ComCountHeadTitle(HeadTitle1);
	
	 				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	 				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	 				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	 				      InitHeaders(headers, info);
	
	 				      var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
	 				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	 				             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	 				             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dim_len",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	 				             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dim_wdt",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	 				             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dim_hgt",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	 				             {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"indiv_pck_wgt",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	 				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dim_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	 				      
	 				      SetWaitImageVisible(0);
	 				      InitColumns(cols);
	 				      SetSheetHeight(168);
 						}
				    break; 						
 			}
 	}
     /**
      * Sheet process handling
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
			case IBSEARCH:      //Retrieve	
				ComOpenWait(true);
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=COMMAND03;
					sheetObj.DoSearch("ESM_BKG_0055GS.do", FormQueryString(formObj) );
					if(document.getElementById("modalFlg").value != "Y"){
						sheetObjects[0].SetColHidden("DelChk",1);
					}
				}									
			break;
         }
     }
     /**
      * handling process for input validation
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return
      */
     function validateForm(sheetObj, formObj, sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
     
     function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
     	ComOpenWait(false);
     }