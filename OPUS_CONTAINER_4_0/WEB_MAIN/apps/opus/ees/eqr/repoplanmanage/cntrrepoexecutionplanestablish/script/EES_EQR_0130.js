/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_EQR_0130.js
*@FileTitle  : BKG Split
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/03
=========================================================*/
	// common static variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event 
	document.onclick=processButtonClick;
    // Event handler processing by button name 
    function processButtonClick() {
        var sheetObject=sheetObjects[0]; 
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(!ComIsBtnEnable(srcName) ) return;
            switch(srcName) {
     	        case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					break;
				case "btn_downexcel":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					}
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						 doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
					}

    	            
					break;
				case "btn_loadexcel":
					doActionIBSheet2(sheetObject1,formObject,IBLOADEXCEL);
					break;
        	    case "btns_add":
                    for( i=1; i < sheetObject.RowCount()+1; i++) {
                    	if(sheetObject.GetCellValue(i, "sel")==1) {
                    		var bkgno=sheetObject.GetCellValue(i, 2);
							var count=0;
							for(j=1; j<sheetObject1.RowCount()+1; j++) {
								if(bkgno==sheetObject1.GetCellValue(j, 2)) {
									count++;
									break;
								}
							}
						    if(count==0) {                    
			  	            	row=sheetObject1.DataInsert(-1);
        			  	  		sheetObject1.SetCellValue(row, 1,1,0);
								sheetObject1.SetCellValue(row, 2,sheetObject.GetCellValue(i, 2),0);
								sheetObject1.SetCellValue(row, 3,sheetObject.GetCellValue(i, 3),0);
								sheetObject1.SetCellValue(row, 4,sheetObject.GetCellValue(i, 4),0);
								sheetObject1.SetCellValue(row, 5,sheetObject.GetCellValue(i, 5),0);
							}
        			    }
			      	}
                    break;
        	    case "btns_del":
                    var selrow=sheetObject1.GetSelectRow();
                    if(selrow > 0) {
                    	for( i=sheetObject1.RowCount(); i > 0; i--) {
                    		if(sheetObject1.GetCellValue(i, "sel1")==1) {
	                        		sheetObject1.RowDelete(i, false);
                        	}
                        }
                   }
        	        break;
				case "btng_splitbkgcre":
					goOpenWindow();
					break;
				case "btn_close":
				ComClosePopup();
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			//ComShowMessage(OBJECT_ERROR);
    			ComShowCodeMessage("EQR90004");
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
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetObject=sheetObjects[0];               
        var formObject=document.form;
   		//var opener=window.dialogArguments; // creating parent object
		doActionIBSheet(sheetObject,formObject,IBSEARCH);        
    }
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
		             var HeadTitle="SEQ|Sel|CNTR No|T/S|MVMT|POD" ;
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sel",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(350);
                      }
                break;
            case 2:      //IBSheet2 init
                with(sheetObj){
					var HeadTitle="SEQ|Sel|CNTR No|T/S|MVMT|POD" ;					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);					
					var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					{Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sel1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					
					InitColumns(cols);					
					SetEditable(1); 
					SetSheetHeight(350);
            	}
                break;
        }
    }
  // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //retrieve
                if(validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value=SEARCHLIST;
                     sheetObj.DoSearch("EES_EQR_0130GS.do", eqrFormQryStr(formObj) );
                }
                break;
			case IBDOWNEXCEL:        // excel down
				if(validateForm(sheetObj,formObj,sAction))
 				sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
				break;
			case IBLOADEXCEL:        // excel down                
				break;
        }
    }
  // handling process for Sheet
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBDOWNEXCEL:        // excel down
				if(validateForm(sheetObj,formObj,sAction))
				//sheetObj.SpeedDown2Excel();
 				sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
				break;
			case IBLOADEXCEL:        // excel down
				if(validateForm(sheetObj,formObj,sAction))
                var i=0;
                var j=0;
                var excel_cntr_no="";
     			sheetObj.LoadExcel({ Mode:"HeaderSkip"});
     			break;
        }
    }    
    
    
    function sheet2_OnLoadExcel(sheetObj, result, code, msg) {
		if (isExceedMaxRow(msg))return;
		
		var sheetObject1=sheetObjects[1];
        var formObj=document.form;
        var excel_cntr_no="";
        formObj.f_cmd.value=SEARCHLIST01;
        for(i=1; i<sheetObj.RowCount()+1; i++) {
        	excel_cntr_no += sheetObj.GetCellValue(i, "cntr_no") + ((i == sheetObj.RowCount() ) ? "" : ",");
	    }
	    formObj.excel_cntr_no.value=excel_cntr_no;
	    if(excel_cntr_no!="") {
            	sheetObj.DoSearch("EES_EQR_0130GS.do", eqrFormQryStr(formObj) );
        }	
	}
    
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(iPage)) {
//
//                    return false;
//                }
        }
        return true;
    }
    // cntr_no     --> t1_cntrno
    // cntr_tpsz   --> t1_tpszno
    // cntr_status --> t1_cntrstatus
	function goOpenWindow() {
		var formObject=document.form;
		var opener=window.dialogArguments; // creating parent object
		if(!opener) opener=parent;
		var sheetObj=sheetObjects[1];         
		var targetRow=formObject.targetRow.value;
		var cntr_no="";
		var cntr_tpsz="";
		var cntr_status="";
		if(sheetObj.RowCount()> 0) {
			for(var i=1; i<sheetObj.RowCount()+1; i++) {
				cntr_no     += sheetObj.GetCellValue(i, "cntr_no")     + ((i == sheetObj.RowCount()) ? "" : ",");
				cntr_tpsz   += sheetObj.GetCellValue(i, "cntr_tpsz_cd")   + ((i == sheetObj.RowCount()) ? "" : ",");
				cntr_status += sheetObj.GetCellValue(i, "mvmt_sts_cd") + ((i == sheetObj.RowCount()) ? "" : ",");
			}	
			opener.settingValue_split(cntr_no, cntr_tpsz, cntr_status, targetRow);    				
    		//closeWindow();
    		ComClosePopup();
		}else {
			ComShowCodeMessage("EQR90063"); 
		}							
	}
	function sheet1_OnDblClick(sheetObject, selrow, col, val) {    		
    	sheetObject.SetCellValue(selrow, "sel",1,0);
    	var bkgno=sheetObject.GetCellValue(selrow, 2);
		var count=0;
		var sheetObject1=sheetObjects[1];
		for(j=1; j<sheetObject1.RowCount()+1; j++) {
			if(bkgno==sheetObject1.GetCellValue(j, 2)) {
				count++;
				break;
			}
		}
		if(count==0) {                    
			row=sheetObject1.DataInsert(-1);
    		sheetObject1.SetCellValue(row, 1,1,0);
			sheetObject1.SetCellValue(row, 2,sheetObject.GetCellValue(selrow, 2),0);// CNTR NO
			sheetObject1.SetCellValue(row, 3,sheetObject.GetCellValue(selrow, 3),0);// TS
			sheetObject1.SetCellValue(row, 4,sheetObject.GetCellValue(selrow, 4),0);// POD
			sheetObject1.SetCellValue(row, 5,sheetObject.GetCellValue(selrow, 5),0);// MVMT
		}  						      	 				
	}
	function sheet2_OnDblClick(sheetObject, selrow, col, val) {    		
		sheetObject.RowDelete(selrow, false);
	}    
	/* closing window
	*/

