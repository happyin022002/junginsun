/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0052.jsp
*@FileTitle  : Confirmation and Distribution 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30; 
 ***************************************************************************************/
/**
     * @extends 
     * @class ESM_SAQ_0052 : business script for ESM_SAQ_0052
     */
    function ESM_SAQ_0052() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=0;
    var save_lane;		
    var save_bound;		
    var save_vvd;		
    var retrieved=false;
    var generateversion=false;
 // Event handler processing by button click event */
    document.onclick=processButtonClick;
 // Event handler processing by button name */
        function processButtonClick(){
             var sheetObject=sheetObjects[0];
             var sheetObject1=sheetObjects[1];
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
            	    case "btn_retrieve":
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
            	    	retrieved=true;
    					ComEnableObject("btn_generateversion", true);
    					ComEnableObject("btn_release", true);  
        	            break;
            	    case "btn_generateversion":
            	    	if (retrieved == false) {
            	    		return;
            	    	}        	    
            	        doActionIBSheet(sheetObject,formObject,MULTI01);
            	        generateversion=true;
            	        break;
            	    case "btn_release":
            	    	if (retrieved == false) {
            	    		return;
            	    	}
            	    	if (generateversion == false) {
            	    		return;
            	    	}
            	    	var rtn=ComShowConfirm("Do you want to distribute Monthly Sales Quota?");
    					if (rtn == false) {
    						return;
    					}         	    	
            	        doActionIBSheet(sheetObject1,formObject,MULTI02);
            	        break;        	       
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowMessage(getMsg("COM12111"));
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
        function setComboObject(combo_obj){
    		comObjects[comboCnt++]=combo_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
        	optionSetting();
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            resizeSheet();
            
            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
           	var formObj=document.form;
           	setYearMonthObject(formObj.year, formObj.quarter);
    		ComEnableObject("btn_generateversion", false);
    		ComEnableObject("btn_release", false); 
    		document.form.year.focus();
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with(sheetObj){
		                 var HeadTitle="FLAG|SEQ|Version|Status|Distribute Date";
		                 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
		                 InitHeaders(headers, info);
		                 var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"mqta_rlse_ver_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"status",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"rlse_gdt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                  
		                 InitColumns(cols);
		                 SetEditable(0);
//		                 SetSheetHeight(539);
		                 SetFocusEditMode(default_edit_mode);
                          }
	                break;
                case 2:     //t1sheet1 init
                    with(sheetObj){
		                 var HeadTitle1="FLAG|SEQ|Trade|Bound|Version|SAQ TGT GRP CD|GLINE VER No.|MQTA RLSE VER No.";
		                 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		                 InitHeaders(headers, info);
		                 var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"mqta_ver_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"saq_tgt_grp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"gline_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mqta_rlse_ver_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		                  
		                 InitColumns(cols);
		                 SetEditable(0);
//		                 SetSheetHeight(539);
		                 SetFocusEditMode(default_edit_mode);
                }
                break;
        }
    }

    	function resizeSheet(){
            for(i=0;i<sheetObjects.length;i++){
                ComResizeSheet(sheetObjects[i]);
            }    		
    	}
    	
        function sheet1_OnSearchEnd(sheetObj , code,  msg){
        	var check_cmd = document.form.f_cmd.value;
        	if( check_cmd == SEARCHLIST){
	        	if (sheetObj.RowCount()> 0) {
	        		var formObj=document.form;
					var mqta_rlse_ver_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "mqta_rlse_ver_no");
					formObj.mqta_rlse_ver_no.value=mqta_rlse_ver_no;
					formObj.is_new_version.value="false";
					doActionIBSheet(sheetObjects[1], formObj, SEARCHLIST01);
				}
        	} else if (check_cmd == MULTI01){
        		var newVersionNo=sheetObj.GetCellValue(sheetObj.RowCount()-1, "mqta_rlse_ver_no");
            	var currentNewVersionNo=sheetObj.GetCellValue(sheetObj.RowCount(), "mqta_rlse_ver_no");
				if (newVersionNo == currentNewVersionNo) {
					ComShowMessage(getMsg("COM12115", "Version"));
					sheetObj.RowDelete(sheetObj.RowCount(), false);
				}
		   		sheetObj.SelectCell(sheetObj.RowCount(), "mqta_rlse_ver_no");  
		   		//sheetObjects[1].RenderSheet(1);
		   		sheet1_OnClick(sheetObjects[0], sheetObj.GetSelectRow(), 0, '');
        	} 
        }
      // handling sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
               case IBSEARCH: //search for sheet1(Retrieve)
    				formObj.f_cmd.value=SEARCHLIST;	
    		   		sheetObjects[0].RemoveAll();				
    		   		sheetObjects[1].RemoveAll();				
    		   		sheetObj.DoSearch("ESM_SAQ_0052GS.do", saqFormString(formObj));
    				
    				break;
    		   case SEARCHLIST01: //search for sheet2 by "mqta_rlse_ver_no" of sheet1
    		   		formObj.f_cmd.value=SEARCHLIST01;
    		   		sheetObj.DoSearch("ESM_SAQ_0052GS1.do", saqFormString(formObj) , {Sync:1} );
    		   		break;
    		   /*case SEARCHLIST02: //search for sheet1 by PK
    		   		formObj.f_cmd.value=SEARCHLIST02;
					sheetObj.DoSearch("ESM_SAQ_0052GS.do", saqFormString(formObj) );
    		   		break;
    		   	*/
    		   case MULTI01: //Generate Version()
		   		   // sheetObjects[1].RenderSheet(0);
                	formObj.f_cmd.value=MULTI01;
                	sheetObj.DoSearch("ESM_SAQ_0052GS2.do", saqFormString(formObj),{Append:true} );
                	
    		   		break;
               case MULTI02: //Distribute
    				formObj.f_cmd.value=MULTI02;
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }
    				 var preSts=new Array();
					 if(sheetObjects[1].IsDataModified()== false){
						 for (i=0; i<=sheetObjects[1].RowCount(); i++) {
							 preSts[i]=sheetObjects[1].GetRowStatus(i);
							 sheetObjects[1].SetRowStatus(i,"I");
						 }	 
					 }
    				doSaveSheet(sheetObj, "ESM_SAQ_0052GS.do", saqFormString(formObj), null, false);
//    				//reset
					 for (i=0; i<=sheetObjects[1].RowCount(); i++) {
						 sheetObjects[1].SetRowStatus(i,preSts[i]);
					 }	 
					 generateversion=false ;
//                 
    				break;		   		
                /*case IBSAVE: //Release
                	formObj.f_cmd.value=MULTI;
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }
    				doSaveSheet(sheetObj, "ESM_SAQ_0052GS.do", saqFormString(formObj));
    				doActionIBSheet(sheetObj, formObj, IBSEARCH);
                	break;
                */
            }
        } 
        //sheet1_OnClick(sheetObjects[0], sheetObj.SelectRow, 0, '');
        function sheet1_OnClick(sheetObj, row, col, value) {
    		sheetObjects[1].RemoveAll();
        	var formObj=document.form;
        	var mqta_rlse_ver_no=sheetObj.GetCellValue(row, "mqta_rlse_ver_no");
    		formObj.mqta_rlse_ver_no.value=mqta_rlse_ver_no;
    		for (i=0; i<=sheetObj.RowCount(); i++) {
    			if (sheetObj.GetRowStatus(i) != "I") {
    				sheetObj.SetRowStatus(i,"R");
    			}
    		}
    		if (sheetObj.GetRowStatus(row) != "I") {
    			sheetObj.SetRowStatus(row,"U");
    		}
    		if (sheetObj.GetRowStatus(row) == "I") {
    			formObj.is_new_version.value="true";
    		} else {
    			formObj.is_new_version.value="false";
    		}		
    		doActionIBSheet(sheetObjects[1], formObj, SEARCHLIST01);
        }    
        function sheet2_OnSaveEnd(sheetObj , ErrMsg){
    		var formObj=document.form;		
    		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }    
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
    		switch (sAction) {
    			case MULTI02:
    				var isValid=true;
    				var rows=sheetObj.RowCount();
    				for (i=1; i<rows; i++) {
    					var verNo=sheetObj.GetCellValue(i, "mqta_ver_no");
    					if (verNo == null || verNo == "") {
    						isValid=false;
    						sheetObj.SelectCell(i, "mqta_ver_no");
    						ComShowMessage(getMsg("SAQ90126", "Version"));
    						break;
    					}
    				}
    				return isValid;
    				break;
    			case IBSAVE:
    				var row=sheetObj.GetSelectRow();
    				if (formObj.mqta_rlse_ver_no.value == "") {
    					ComShowMessage(getMsg("COM12113", "Version"));
    					return false;
    				}
    				if (sheetObj.GetCellValue(row, "rlse_gdt") != "") {
    					ComShowMessage(getMsg("SAQ90128"));
    					return false;
    				}				
    				return true;		
    				break;
    		}
        }
        function optionSetting() {
    		SaqSearchOptionYear("year");
    		SaqSearchOptionQuarter("quarter");
        }
