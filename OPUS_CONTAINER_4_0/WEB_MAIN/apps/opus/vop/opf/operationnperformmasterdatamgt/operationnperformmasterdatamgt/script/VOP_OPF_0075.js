/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0075.js
*@FileTitle  : Restow Reason Code (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
　
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class vop_opf_0075 : vop_opf_0075 business script for
     */
   	/* Developer performance	*/
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
       　
	         var sheetObject1=sheetObjects[0];
	         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		var prefix="sheet2_"
            switch(srcName) {
				case "btn_RowAdd":
					//doActionIBSheet(sheetObject2,formObject,IBINSERT);
					var row=sheetObject2.DataInsert(-1);
					//sheetObject2.CellText(row, prefix+"rstwg_cd_tp_cd") = sheetObject1.CellText(sheetObject1.SelectRow, "sheet1_rstwg_cd_tp_cd");
					sheetObject2.SetCellValue(row, prefix+"delt_flg","N");
					sheetObject2.SelectCell(row,prefix+"rstwg_rsn_cd",true);
					break;
				case "btn_RowInsert":
					//doActionIBSheet(sheetObject2,formObject,"IBINSERT01");
					var row=sheetObject2.DataInsert();
					//sheetObject2.CellText(row, prefix+"rstwg_cd_tp_cd") = sheetObject1.CellText(sheetObject1.SelectRow, "sheet1_rstwg_cd_tp_cd");
					sheetObject2.SetCellValue(row, prefix+"delt_flg","N");
					sheetObject2.SelectCell(row,prefix+"rstwg_rsn_cd",true);
					break;
				case "btn_RowCopy":
					var row=sheetObject2.DataCopy();
					//validateCode(sheetObject2,row,2,sheetObject2.CellValue(row, prefix+"rstwg_rsn_cd"));
					break;
				case "btn_RowDelete":
					ComRowHideDelete(sheetObject2,"sheet2_del_chk");
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject2,formObject,IBSEARCH, sheetObject1);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
					break;
				case "btn_Close":
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
			for(i=0;i<sheetObjects.length;i++){
	        //change start configuration method name 
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
	        //add last configuration method 
				ComEndConfigSheet(sheetObjects[i]);
			}
	    	//Sheet1 Default Data Setting..
			initDefaultSheet(sheetObjects[0], document.form);
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH, sheetObjects[0]);
	}
    /**
     * Sheet1  Default Data Setting.
     * setting data in case of loading page on browser
     */
    function initDefaultSheet(sheetObj, formObj){
    	var prefix="sheet1_";
    	sheetObj.DataInsert();
    	sheetObj.DataInsert();
    	sheetObj.SetCellText(1, prefix+"rstwg_cd_tp_cd" ,"S");
    	sheetObj.SetCellText(1, prefix+"shifting_method" ,"Restow cell to cell");
    	sheetObj.SetCellText(2, prefix+"rstwg_cd_tp_cd" ,"D");
    	sheetObj.SetCellText(2, prefix+"shifting_method" ,"Restow via quay");
    	//sheetObj.SelectRow = 1;
    }
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
                    with (sheetObj) {
	                    var HeadTitle="|Code|Shifting Method";
	                    var headCount=ComCountHeadTitle(HeadTitle);
	                    //(headCount, 0, 0, true);
	                    var prefix="sheet1_";
	
	                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                    var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                    InitHeaders(headers, info);
	
	                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rstwg_cd_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                           {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"shifting_method", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                     
	                    InitColumns(cols);
	
	                    SetEditable(0);
	                    FocusStyle=0;
	                    SetSheetHeight(120);
					}
                    break;
                case "sheet2":
                    with (sheetObj) {

	                    var HeadTitle="|Sel.|No.|Code|Account and Reason|";
	                    var headCount=ComCountHeadTitle(HeadTitle);
	                    //(headCount, 0, 0, true);
	                    var prefix="sheet2_";
	
	                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                    InitHeaders(headers, info);
	
	                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                           {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
	                           {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
	                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rstwg_rsn_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
	                           {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"rstwg_rsn_cd_full_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	                           {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"delt_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                     
	                    InitColumns(cols);
	
	                    SetEditable(1);
	                    //SetSheetHeight(440);
	                    resizeSheet();
					}
                    break;
            }
        }
        function resizeSheet(){
            ComResizeSheet(sheetObjects[1], 70);
        }
        function doActionIBSheet(sheetObj,formObj,sAction, sheetObj1) {
        	sheetObj.ShowDebugMsg(false);
    	    switch(sAction) {
    	      case IBSEARCH:      //Retrieve
    	        formObj.f_cmd.value=SEARCH;
    	        sheetObj.DoSearch("VOP_OPF_0075GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
    	        break;
    	      case IBSAVE:        //save
    	        if(!validateForm(sheetObj,formObj,sAction)) {
    	            return false;
    	        }//end if
    	        formObj.f_cmd.value=MULTI;
    	        sheetObj.DoSave("VOP_OPF_0075GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"), -1, false);
    	        break;
    	    }
    	}
        /**
         * Code Length Check.
         */
        function sheet2_OnChange(sheetObj, row, col, value){
        	if(sheetObj.ColSaveName(col)=="sheet2_rstwg_rsn_cd"){
        		if(value.length!=1){
    	    		//ComShowMessage("Data Length 2");
    	    		ComShowCodeMessage("OPF50007", "Code","2");
    	    		sheetObj.SelectCell(row,col,true);
    	    		return false;
    	        }
        	}
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	if(sheetObj.RowCount()>0){
        		// Code duplication check
        		for(i=1; i< (sheetObj.RowCount()+1); i++){
        			for(j=i+1; j< (sheetObj.RowCount()+1); j++){
        				if(sheetObj.GetCellValue(i,"sheet2_rstwg_rsn_cd").length != 1){
        					ComShowCodeMessage("OPF50007", "Code","2");
        					sheetObj.SelectCell(i,"sheet2_rstwg_rsn_cd",true);
        					return false;
        				}
        				else if(sheetObj.GetCellValue(i,"sheet2_rstwg_rsn_cd") != null
        						&& sheetObj.GetCellValue(i,"sheet2_rstwg_rsn_cd") != ""
        							&& sheetObj.GetCellValue(i,"sheet2_rstwg_rsn_cd")==sheetObj.GetCellValue(j,"sheet2_rstwg_rsn_cd"))
            			{
            				//ComShowMessage("Code is already exist.");
            				ComShowCodeMessage("OPF50005", "Data");
            				if(sheetObj.GetRowStatus(i)=="I"){
            					sheetObj.SelectCell(i,"sheet2_rstwg_rsn_cd",true);
            				}else{
            					sheetObj.SelectCell(j,"sheet2_rstwg_rsn_cd",true);
            				}
		    				return false;
            			}
        			}
        		}
        	}
            return true;
        }
        function sheet2_OnSaveEnd(sheetObj, Code, ErrMsg) {
        	 ComOpenWait(false);// always exist at first line
//        	 if(Code == 0){
//        	  ComShowCodeMessage("COM132601");
//        	}
        }
	/* Developer performance  end */
