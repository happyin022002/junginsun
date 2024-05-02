/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0005.js
*@FileTitle  : ISO Code Creation  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author 
 */
/**
 * @extends 
 * @class ees_mst_0005 : business script for ees_mst_0005
 */
    function ees_mst_0005() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // common static variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var strOfcCd="";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
       	 var sheetObject1 = sheetObjects[0];
       	 /*******************************************************/
       	 var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName)
                {
   				case "btn_add":
   					doActionIBSheet(sheetObject1,formObject,IBINSERT);
   				break; 
   				case "btn_delete":
   					if(sheetObject1.FindCheckedRow("Sel")=="")
   					{
   						ComShowCodeMessage("MST00010");
   					}
   					else if(ComShowCodeConfirm("MST00005")) 
   					{ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
   					}
   				break;
   				case "btn_save":
   					doActionIBSheet(sheetObject1,formObject,IBSAVE);
   				break;														
   				case "btn_downexcel":
   					if(sheetObject1.RowCount() < 1){//no data
		        	     ComShowCodeMessage("COM132501");
	        	    }else{
	        	    	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	        	    }
   					
   				break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("MST00011",srcName+" Button Fail.");
        		} else {
        			ComShowCodeMessage("MST00011",e);
        		}
        	}
        }
        /**
         * registering IBsheet Object as list
         * adding process for list in case of needing batch processing with other items 
         * defining list on the top of source
         */
        function setSheetObject(sheet_obj)
        {
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() 
        {
            for(i=0;i<sheetObjects.length;i++)
            {
            	ComConfigSheet(sheetObjects[i] );
            	initSheet(sheetObjects[i],i+1);
            	ComEndConfigSheet(sheetObjects[i]);
            }
          doActionIBSheet(sheetObjects[0], document.form, SEARCH09);
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        
        function sheet1_OnLoadFinish(sheetObj){
            sheetObj.SetWaitImageVisible(0);
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            sheetObj.SetWaitImageVisible(1);
     	}
        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) 
        {
            var cnt=0;
            switch(sheetNo) 
            {
                case 1:      //sheet1 init
                    with(sheetObj){
	                  var HeadTitle="||Seq.|ISO Code|Description";
	                  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                  InitHeaders(headers, info);
	                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                         {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
	                         {Type:"Seq",       Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	                         {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"iso_cntr_tpsz_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
	                         {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"iso_cntr_tpsz_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 } ];
	                  InitColumns(cols);
	                  SetEditable(1);
	                  SetColProperty("iso_cntr_tpsz_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetColProperty("iso_cntr_tpsz_nm" , {AcceptKeys:"N|E|[ ]" , InputCaseSensitive:1});
	                 // SetSheetHeight(460);
	                  resizeSheet();
                    }
                break;
            }
        }
        
        
        function sheet1_OnSaveEnd(sheetObj, ErrMsg){
            if (ErrMsg == "") {
                doActionIBSheet(sheetObj,document.form,IBSEARCH);
            } 
   	  }
        
        // handling process for sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
			var selrow=sheetObj.GetSelectRow();
			switch(sAction) 
            {
      		case IBINSERT:      // inserting 
   				if ( selrow > 0 )
   				{
   					sheetObj.DataInsert(selrow);
   					sheetObj.SelectCell(selrow+1, 3, true);
   				}
   				else
   				{
   					sheetObj.DataInsert(-1);
   				}
   			break;
   			
   			case IBSEARCH:      //retrieve
   				if(sheetObj.id == "sheet1") {
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);					
					formObj.f_cmd.value=SEARCH;
	 				var xml="";
	 				xml=sheetObj.GetSearchData("EES_MST_0005GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSearchData(xml,{Sync:0} );
	 				ComOpenWait(false);
				}
			break;
			
   			case IBSAVE:        //save
   					if(sheetObj.id == "sheet1") 
   					{
   						if(validateForm(sheetObj,formObj,sAction)){
   							var sel_code=sheetObj.GetCellValue(selrow,"iso_cntr_tpsz_cd");
   							var cur_code="";
   							sheetObj.SetWaitImageVisible(0);
   							ComOpenWait(true);	   						
   							formObj.f_cmd.value=MULTI;
   							if(sheetObj.DoSave("EES_MST_0005GS.do", FormQueryString(formObj)))
   							{
   								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   								for(var i=1; i<=sheetObj.RowCount(); i++)
   								{
   									cur_code=sheetObj.GetCellValue(i,"iso_cntr_tpsz_cd");
   	   		   	            		if(sel_code == cur_code)
   	   		   	            		{
   	   		   	            			sheetObj.SelectCell(i, 3, true);
   	   		   	            			ComOpenWait(false);
   	   		   	            			return;
   	   		   	            		}
   								}		// End for
   							}
   						ComOpenWait(false);
   						}
   					}
   			break;
   			
   		 	case IBDELETE: // removing
   		 		ComRowHideDelete(sheetObj, "Sel");
   	   		 	sheetObj.SetSelectRow(selrow);
   		 		break;
   		 		
   		 	case SEARCH09:      //retrieving Officd Code
				if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "MST", strOfcCd) ) {
					div_ofc1.style.display="none";
					formObj.btn_save.style.display="none";
				}else{
					div_ofc1.style.display="";
					formObj.btn_save.style.display="";
				}
			break;
            }
        }
        
        function sheet1_OnChange(sheetObj, row, col, value)
        {
			if(sheetObj.ColSaveName(col) == "iso_cntr_tpsz_cd")
			{
                if(value.length != 4 && value.length != 0) 
                {
                    ComShowCodeMessage("MST01017");
                    sheetObj.SetCellValue(row,"iso_cntr_tpsz_cd","");
                    sheetObj.SelectCell(row, col-1, true);
                    return;
                }
                var cur_code="";
                var sel_code=sheetObj.GetCellValue(row,"iso_cntr_tpsz_cd");
                //  checking duplication onsheet
                for(var i=1; i<= sheetObj.RowCount(); i++)
                {
	               	 if(i != row)		
	               	 {
	               		 cur_code=sheetObj.GetCellValue(i,"iso_cntr_tpsz_cd");
	   	            	 if(sel_code == cur_code)
	   	            	 {
	   	            		 ComShowCodeMessage("MST00002",cur_code);
	   	            		 sheetObj.SetCellValue(row,"iso_cntr_tpsz_cd","");
	   	            		 sheetObj.SelectCell(row, col-1, true);
	   	            		 return;
	   	            	 }
	               	 }
                }		// End for
			}
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
       	 with(formObj){
        		 switch(sAction) {
        		 	case IBSAVE:
        		 	 		var total=sheetObj.GetTotalRows()+1;
        		 	 		var checkCount=0;
        		 	 		for (var i=0 ; i < total ; i++){
        		 	 			if (sheetObj.GetCellValue(i  ,"iso_cntr_tpsz_nm").trim().length == 0){
        		 	 				checkCount ++;
        						}
        		 	 		}
        		 	 		if (checkCount > 0){
        		 	 			ComShowCodeMessage("MST00001", "Description");
        						return false;
        					}
    	        		   break;
    			 }
    		  }
    		  return true;
        } 
        
    	function resizeSheet(){
     	    ComResizeSheet(sheetObjects[0]);
     	}
