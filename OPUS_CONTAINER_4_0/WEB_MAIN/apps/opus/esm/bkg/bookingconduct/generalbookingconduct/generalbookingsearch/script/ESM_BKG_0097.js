/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0097.js
*@FileTitle  : Reference Number
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // global variable

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var bkgRefNo = "";
 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
    	 /***** using extra sheet valuable if there are more 2 sheets *****/
    	 var sheetObject1=sheetObjects[0];
    	 /*******************************************************/
 		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
		     switch(srcName) {
				case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE); 
					break;
				case "btn_Copy":
					var showMemo="";
					var isFirst=true;
                    for(var i=1 ; i <= sheetObject1.LastRow() ; i++){
                        if(sheetObject1.GetCellValue(i, "cpy_desc_flg") == 1){
	    					if(isFirst){
                                showMemo=sheetObject1.GetCellValue(i, "bkg_ref_tp_nm") +":"+sheetObject1.GetCellValue(i, "cust_ref_no_ctnt");
	    						isFirst=false;
	    					}else{
                                showMemo=showMemo + ",  "+sheetObject1.GetCellValue(i, "bkg_ref_tp_nm") +":"+sheetObject1.GetCellValue(i, "cust_ref_no_ctnt");
	    					}
	    				}
	    			}										
					var calllFunc=ComGetObjValue(formObject.calllFunc);
					if(calllFunc != ''){
						if (ComFuncCheck("opener." + calllFunc)) ComFunc(showMemo);
						else if (ComFuncCheck("parent." + calllFunc)) ComFunc(showMemo);
					}	 
                    ComClosePopup(); 
					break;
				case "btn_Close":
                    ComClosePopup(); 
					break;		
		     } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
    	 var formObj=document.form;
         for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
         }                	 
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
     }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         switch(sheetNo) {
             case 1:      //t1sheet1 init
                with(sheetObj){
                    var HeadTitle="|Reference No.|Reference No.|Update To Memo";
                    
                    SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
                    
                    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"bkg_ref_tp_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_ref_no_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
                                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cpy_desc_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:1, Width:270,  Align:"Left",    ColMerge:0,   SaveName:"bkg_ref_tp_cd" },
                                 {Type:"Text",      Hidden:1, Width:270,  Align:"Left",    ColMerge:0,   SaveName:"ref_seq" },
                                 {Type:"Text",      Hidden:1, Width:270,  Align:"Left",    ColMerge:0,   SaveName:"bkg_no" } ];
                     
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetCountPosition(0);
                    SetWaitImageVisible(0);
                    SetSheetHeight(220);
                }
                 break;
         }
     }
     // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //Retrieve
            	formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_BKG_0097GS.do", FormQueryString(formObj) );
                break;
			case IBSAVE:        //save
            	var custRefNoCtnt = "";
            	var refNoIndex = null;
            	for (var idx=sheetObj.HeaderRows(); idx<=sheetObj.LastRow(); idx++) {
              		var bkgRefTpCd = sheetObj.GetCellValue(idx, "bkg_ref_tp_cd");
              		if(bkgRefTpCd == 'EBRF'){
              			custRefNoCtnt = sheetObj.GetCellValue(idx, "cust_ref_no_ctnt");
              			refNoIndex = idx;
              			break;
              		}
          	    } 
            	var saveCheck = true;
            	if(bkgRefNo != custRefNoCtnt)
            		saveCheck = ComShowConfirm('BKG Ref No. has been removed or changed. Please check eBooking request for correct reference.');
            	
            	if(saveCheck){
            		formObj.f_cmd.value = MULTI;
            		var params = FormQueryString(formObj);
                	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true),"sheet1_");
                    var sXml=sheetObj.GetSaveData("ESM_BKG_0097GS.do", params);
                	if(ComGetEtcData(sXml, "isSuccess") == "Y"){
                		ComBkgSaveCompleted();	
                		doActionIBSheet(sheetObj,formObj,IBSEARCH); 
                	} else {
        				sheetObj.LoadSaveData(sXml);
        			}
            	}else{
            		if(refNoIndex != null) sheetObj.SetCellValue(refNoIndex, "cust_ref_no_ctnt", bkgRefNo);
            	}
            break;            	
         }
     }
     /**
      * On Search End Event Handling<br>
      */ 	     
     function sheet1_OnSearchEnd(sheetObj,ErrMsg){
      	for (var idx=sheetObj.HeaderRows(); idx<=sheetObj.LastRow(); idx++) {
      		sheetObj.SetCellValue(idx,"ibflag","U");
      		var bkgRefTpCd = sheetObj.GetCellValue(idx, "bkg_ref_tp_cd");
      		if(bkgRefTpCd == 'EBRF') bkgRefNo = sheetObj.GetCellValue(idx, "cust_ref_no_ctnt");
  	    } 		
      }
     /**
      * On Save End Event Handling <br>
      */ 	
  	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
  		if (Code >=0) {
 			ComBkgSaveCompleted();			
 		}
 	}     
	/* Developer Work End */
