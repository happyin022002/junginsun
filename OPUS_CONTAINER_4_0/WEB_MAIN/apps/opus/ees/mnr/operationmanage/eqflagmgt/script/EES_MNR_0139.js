/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0139.js
*@FileTitle  : Damage Flagging/Unflagging Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;       
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;    
var comboValue="";  
var verifyCheck=false;      
var retComboVal="";   
var opener = window.dialogArguments;
// Event handler processing by button click event */
	document.onclick=processButtonClick;  
// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) { 
		        case "btn_new":  
                    doActionIBSheet(sheetObject, formObject, IBCLEAR);
                    break;   
                 case "btn_loadExcel": 
                	sheetObject.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:"0",WorkSheetName:"",Append:false,ColumnMapping:"||||1|2|3"});
					                  
                    break;          		     
		        case "btn_ok":
                    if(sheetObject.FindCheckedRow("checkbox") == ""){
						ComShowCodeMessage("MNR00038","SELECT ");             	   
					} else if(!verifyCheck){  
						ComShowCodeMessage("MNR00157");          		 	  
					} else {     
						comPopupOK_139(sheetObject,formObject); 	
					}   
					break;         
		        case "btn_Save":    
                    doActionIBSheet(sheetObject, formObject, IBSAVE); 
                    break;        
		        case "btn_RowAdd":                  
                    doActionIBSheet(sheetObject, formObject, IBINSERT);        
                    break; 
		        case "btn_RowDel":                     
                    doActionIBSheet(sheetObject, formObject, IBDELETE);        
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
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    } 
  	/** 
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject. 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj){     
    	comboObjects[comboCnt++]=combo_obj;  
	}     
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() { 
		MnrWaitControl(true); 
		if (!opener) opener = parent;
        for(i=0;i<sheetObjects.length;i++){
        	//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
        	//
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }  
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
    }  
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObj){
		             var HeadTitle="|Sel|Del|Seq|EQ No.|Yard|Flagging/Unflagging Date|System Verify Result";
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_check",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",        KeyField:0,   CalcLogic:"",   Format:"" },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg1",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg2",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                 {Type:"Date",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"inp_msg3",   KeyField:1,   CalcLogic:"",   Format:"YmdHm",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"inp_msg5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg4",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		             SetColProperty(0 ,"inp_msg1" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		             SetColProperty(0 ,"inp_msg2" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		             SetEditable(1);
		             SetEditableColorDiff(0);
		             SetSelectionMode(smSelectionRow);
		             SetSheetHeight(250);
             }
              break;  
        }  
    }
	/**   
	 * setting combo basic info    
	 * @param	{IBMultiCombo}	combo_obj	ComboObject. 
	 * @param	{Number}	comboNo		ComboObject tag serial number 
	 * adding case as numbers of counting combos 
	 */     
	function initCombo (comboObj, comboNo) {   
	    //var cnt  = 0 ; 
	    var formObject=document.form
	    switch(comboNo) {    
	          case 1: 
	           with (comboObj) { 
	        	  SetColAlign(0, "left");
	        	  SetDropHeight(160);
		    }      
	           break;    
	     } 
	}   
  // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			 case IBSAVE:        //saving
              		formObj.f_cmd.value=MULTI;   
					formObj.eq_type.value=comboValue;     
					for(var i=1; i <= sheetObj.RowCount(); i++){
						sheetObj.SetRowStatus(i,"I");
					}          
					var sParam=sheetObj.GetSaveString(false, true);
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);  
 				    var sXml=sheetObj.GetSaveData("EES_MNR_0139GS.do", sParam);
 				    sheetObj.LoadSaveData(sXml);
					for(var i=1; i <= sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i,"checkbox") == 1){
							sheetObj.SetRowBackColor(i,"#F0FFFF");
							sheetObj.SetCellEditable(i,"inp_msg1",0);
							sheetObj.SetCellEditable(i,"inp_msg2",0);
							sheetObj.SetCellEditable(i,"inp_msg3",0);
						} else {                 
							sheetObj.SetRowBackColor(i,"#F7E5EB");
							sheetObj.SetCellEditable(i,"checkbox",0);
						}                          
					}         
					verifyCheck=true;
					retComboVal=comboValue;         
                break;      
			case IBINSERT:  // ROWADD                   
					var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row,"inp_msg3",ComGetNowInfo("ymd")+" " + ComGetNowInfo("hm"),0);
					sheetObj.SetCellEditable(Row,"checkbox",0);
					verifyCheck=false;                       
	      		break; 
			case IBDELETE:  // ROWDELETE   
					for(var i=sheetObj.RowCount(); i > 0; i--){
						if(sheetObj.GetCellValue(i,"del_check") == 1){
							sheetObj.RowDelete(i, false);
						}     	
					}           
				break;
			case IBCLEAR: //  retrieving Combo Data and initializing sheet 
					MnrWaitControl(true);
					sheetObj.SetWaitImageVisible(0);
					//initializing Combo Data  
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					}     
					var sCondition=new Array (
						new Array("MnrGenCd","", "CUSTOM9")
					)	
					var comboList=MnrComSearchCombo(sheetObj,sCondition); 
					//setting combo1 EQ_TYPE        
					if(comboList[0] != null){	       
						for(var j=0; j < comboList[0].length;j++){ 
							var tempText=comboList[0][j].split("|");  
							comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
							//setting return value    
							if(formObj.eq_type.value != "" && formObj.eq_type.value == tempText[0].trim()){ 
								comboObjects[0].SetSelectCode(tempText[0]);
							}  
						}			    
					}		  	 
					//initializing sheet
					sheetObj.RemoveAll();
					verifyCheck=false;  
					sheetObj.SetWaitImageVisible(1);
                  	MnrWaitControl(false);  
	      	   	break; 	
        } 
    }  
	/**
     * setting return value to parent form.
     */
	function comPopupOK_139(sheetObj,formObject) {
		var formObject=document.form; 
		var rArray=new Array(); //list containing row data
		var ret_val=new Array(); 
		ret_val[0]=retComboVal;    
		ret_val[1]=ComGetObjValue(formObject.dmg_flag); 
	    var sRow=sheetObj.FindCheckedRow("checkbox");
	    //setting row as list.          
	    var arrRow=sRow.split("|");   
	    for (idx=0; idx < arrRow.length; idx++){     
			var cArray=new Array(); // list containing col data
			cArray[0]=sheetObj.GetCellValue(arrRow[idx], "inp_msg1");
			cArray[1]=sheetObj.GetCellValue(arrRow[idx], "inp_msg2");
			cArray[2]=sheetObj.GetCellValue(arrRow[idx], "inp_msg3");
			cArray[3]=sheetObj.GetCellValue(arrRow[idx], "inp_msg6");
			rArray[idx]=cArray;                            
		}       
		opener.getEES_MNR_139(rArray,ret_val);  
		ComClosePopup(); 
	}   
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }   
    /**
     * initializing Tab
     * setting Tab items.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                }
             break;
         }
    }
    /** 
     * Event when clicking Tab
     * activating selected tab items.
     */
    function tab1_OnChange(tabObj , nItem)
    {  
        var objs=document.all.item("tabLayer"); 
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem; 
    }
    /**
     * handling process for input validation
     */ 
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){  
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }       
        return true; 
    }   
 	/**  
	 * combo1 Change event      
	 * @param	{IBMultiCombo}		comboObj	comboObject  
	 * @param 	{Number} 			Index_Code 	selected row 
	 * @param 	{String} 			Text 		selected Text  
	 */  
	function combo1_OnChange(comboObj,Index_Code, Text){ 
		comboValue=comboObj.GetSelectCode();
	}     
	/**  
	 * combo1 Checkbox event      
	 * @param	{IBSheet}		sheetObj	comboObject  
	 * @param 	{String} 			Row 		Row 
	 * @param 	{String} 			Col 		Col 
	 */  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){  
		if(sheetObj.ColSaveName(Col) == 'checkbox')
		{
			if(sheetObj.GetCellValue(Row,Col) != 1){
				sheetObj.SetRowBackColor(Row,"#F7E5FF");
			} else {                            
				sheetObj.SetRowBackColor(Row,"#F7E5FF");
				sheetObj.SetCellValue(Row,"inp_msg5","",0);
				sheetObj.SetCellEditable(Row,"checkbox",0);
				sheetObj.SetCellEditable(Row,"inp_msg1",1);
				sheetObj.SetCellEditable(Row,"inp_msg2",1);
				sheetObj.SetCellEditable(Row,"inp_msg3",1);
				verifyCheck=false;        
			} 
		}				
	} 
	//showing message after saving
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){ 
		if (ErrMsg == "") {   
			ComShowCodeMessage("MNR00158");         
		} else { 
			ComShowCodeMessage("MNR00159",ErrMsg);   
		}       
	}
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		for(var i=1; i <= sheetObj.RowCount(); i++){
			sheetObj.SetRowStatus(i,"R");
			sheetObj.SetCellEditable(i,"checkbox",0);
		}
	}
	/* developer job */
