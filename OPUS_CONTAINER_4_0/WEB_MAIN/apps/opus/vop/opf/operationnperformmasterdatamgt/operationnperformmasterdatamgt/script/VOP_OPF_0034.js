/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_OPF_0034.js
*@FileTitle : COD Reject Reason Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
       　
	         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_RowAdd":
					var row=sheetObject1.DataInsert(-1);
					sheetObject1.SetCellText(row, "delt_flg" ,"N");
					sheetObject1.SelectCell(row,"cod_rjct_cd",true);
					break;
				case "btn_RowInsert":

					var row=sheetObject1.DataInsert();
					sheetObject1.SetCellText(row, "delt_flg" ,"N");
					sheetObject1.SelectCell(row,"cod_rjct_cd",true);
					break;
				case "btn_RowCopy":
					sheetObject1.DataCopy();
					break;
				case "btn_RowDelete":
					ComRowHideDelete(sheetObject1,"del_chk");

					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
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
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
	            	with(sheetObj){
			             var HeadTitle="|Sel.|No.|Code|Description|";
			             var headCount=ComCountHeadTitle(HeadTitle);
			
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			             var headers = [ { Text:HeadTitle, Align:"Center"} ];
			             InitHeaders(headers, info);
			
			             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
			                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cod_rjct_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 , FullInput
:1 },
			                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Left",    ColMerge:1,   SaveName:"cod_rjct_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			              
			             InitColumns(cols);
			
			             SetEditable(1);
			             SetColProperty(0 ,"cod_rjct_cd" ,  {AcceptKeys:"E" , InputCaseSensitive:1});
	                      //conversion of function[check again]CLT                         InitDataValid(0, "cod_rjct_cd", vtEngUpOnly);
		                //SetSheetHeight(480);
			             resizeSheet();
	            	}
               break;
            }
        }
        
        function resizeSheet(){
            ComResizeSheet(sheetObjects[0]);
        }
        
        function doActionIBSheet(sheetObj,formObj,sAction) {
        	sheetObj.ShowDebugMsg(false);
    	    switch(sAction) {
    	      case IBSEARCH:      //Retrieve
    	        formObj.f_cmd.value=SEARCH;
     	        sheetObj.DoSearch("VOP_OPF_0034GS.do", FormQueryString(formObj) );
    	        break;
    	      case IBSAVE:        //save
    	    	  if(!validateForm(sheetObj,formObj,sAction)){
    	    		  return false;
    	    	  }
    	        formObj.f_cmd.value=MULTI;
    	        sheetObj.DoSave("VOP_OPF_0034GS.do", FormQueryString(formObj), -1, false);
    	        break;
    	    }
    	}
        /**
         * Code Data Validation Check.
         */
        function sheet1_OnChange(sheetObj, row, col, value){
        	if(sheetObj.ColSaveName(col)=="cod_rjct_cd"){
        		if(value.length!=3){
            		//ComShowMessage("Data Length 3");
            		ComShowCodeMessage("OPF50007", "Code","3");
            		sheetObj.SelectCell(row,col,true);
            		return false;
            	}
        	}
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	if(sheetObj.RowCount()>0){
            		// check duplication data of Reject Reason Code 
            		for(i=1; i< (sheetObj.RowCount()+1); i++){
            			if(sheetObj.GetCellValue(i,"cod_rjct_cd").length!=3){
                    		ComShowCodeMessage("OPF50007", "Code","3");
                    		sheetObj.SelectCell(i,"cod_rjct_cd",true);
                    		return false;
                    	}
            			for(j=i+1; j< (sheetObj.RowCount()+1); j++){
            				if(sheetObj.GetCellValue(i,"cod_rjct_cd") != null
            						&& sheetObj.GetCellValue(i,"cod_rjct_cd") != ""
            							&& sheetObj.GetCellValue(i,"cod_rjct_cd")==sheetObj.GetCellValue(j,"cod_rjct_cd"))
	            			{
	            				//ComShowMessage("Reject Reason Code is already exist.");
	            				ComShowCodeMessage("OPF50005", "Data");
	            				if(sheetObj.GetRowStatus(i)=="I"){
	            					sheetObj.SelectCell(i,"cod_rjct_cd",true);
	            				}else{
	            					sheetObj.SelectCell(j,"cod_rjct_cd",true);
	            				}
			    				return false;
	            			}
            			}
            		}
            	}
            }
            return true;
        }
	/* Developer performance  end */
