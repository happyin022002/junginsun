/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_mst_0004.js
*@FileTitle : Lease Term Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
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
     * @class ees_mst_0004 : business script for ees_mst_0004
     */
 // common static variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var sheet1=null;
//html form
 var frm=null;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
 		  var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
				case "btn_downexcel":
					 if(sheetObject1.RowCount() < 1){//no data
						  ComShowCodeMessage("COM132501");
						}else{
							sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
						}
					
				break;
				case "btn_save":
				   //in case of Purchase option = "Y", checking
			       for(var i=1; i<=sheetObject1.RowCount(); i++){
						if(sheetObject1.GetCellValue(i,6) == "Y"){
							if (sheetObject1.GetCellValue(i,7) == "" || sheetObject1.GetCellValue(i,7) == "0" || sheetObject1.GetCellValue(i,7) == "0.00"){
								 ComShowCodeMessage("MST00001","Purchase Price" );
								 sheetObject1.SetCellValue(i,7,"");
								 sheetObject1.SelectCell(i,7, true);
								 return;
							} 
						}
			    	  //mandatory Check
							for (var j=1; j <= 8; j++){
								if( j == "3" || j == "4" || j == "6" || j == "8"){
									if (j == "3" && sheetObject1.GetCellValue(i,j).length == 1){
										ComShowCodeMessage("MST00001","Lease Term");
										sheetObject1.SetCellValue(i,j,"");
										sheetObject1.SelectCell(i, j, true);
										return;
							}
						if (sheetObject1.GetCellValue(i,j) == ""){
				        		ComShowCodeMessage("MST00001","Lease Term,Description,Purchase Option,Display Sequence");
				        		sheetObject1.SetCellValue(i,j,"");
				        		sheetObject1.SelectCell(i, j, true);
				        		return;
				          	}
				          }
			    	  }
					var lstm_cd=sheetObject1.GetCellValue(i,"lstm_cd");
			    	  if (lstm_cd.trim() == ""){
	       			     ComShowCodeMessage("MST00001","Lease Term");
	       			     sheetObject1.SelectCell(i,3, true);
	         		     return;				    		  
			    	  }
		           }
	        		// in case of duplicated lstm_cd exists, showing message
	        		var dupRows = sheetObject1.ColValueDupRows("lstm_cd");
	        		var arrRow=dupRows.split(",");
			        if (dupRows != ""){
		       			 //error message : Data is duplicated, Please check data again.
						ComShowCodeMessage("MST00002", sheetObject1.GetCellValue(arrRow[0],3));
		       			 sheetObject1.SelectCell(arrRow[0], 3, true);
		       			 return;				        	
			        } 
	        		// in case of duplicated dp_seq exists, showing message
	        		dupRows = sheetObject1.ColValueDupRows("dp_seq");
	        		arrRow=dupRows.split(",");
			        if (dupRows != ""){
		       			 //error message : Data is duplicated, Please check data again.
						ComShowCodeMessage("MST00002", sheetObject1.GetCellValue(arrRow[0],8));
		       			 sheetObject1.SelectCell(arrRow[0], 8, true);
		       			 return;				        	
			        } 	
			        doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
				case "btn_add":
					sheetObject1.DataInsert();
				break;
				case "btn_del":
   					if(sheetObject1.FindCheckedRow("del_chk")=="")
   					{
   						ComShowCodeMessage("MST00010");
   					}
   					else if(ComShowCodeConfirm("MST00005")) 
   					{ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
   					}
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
      * initailizing form control
      */
     function initControl() {
         // change
         axon_event.addListenerForm('change', 'obj_change', frm);
      	 // focus in
         axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);         
     }     
     /**
      * HTML Control Foucs in
      */
     function obj_change(){
     }
     function obj_deactivate(){
     }
    // ===================================================================================
    // sheet handling event
    // ===================================================================================
    /**
     *  handling event chaging onsheet1 
     * pur_opt_flg : pur_opt_flg 
     * @param {long} Row Index
     * @param {long} Column Index
     * @param {string} value  
     * 
     */
     function sheet1_OnChange(sheet , row , col , value) {
		var pur_opt_flg=sheet.GetCellValue(row,"pur_opt_flg");
		var lstm_cd=sheet.GetCellValue(row,"lstm_cd");
		if (sheet.GetCellValue(row, "lstm_cd") == "OW" && pur_opt_flg == "Y") {
	    	ComShowCodeMessage("MST01029");
			sheet.SetCellValue(row, "pur_opt_flg","N");
	    }
	    if (pur_opt_flg == "N"){
	    	sheet.SetCellValue(row, "pur_prc","0");
	    }
     }
 	//checking mandatory 
 	function sheet1_OnAfterEdit(sheetObj,Row,Col){
 		var sName=sheetObj.ColSaveName(Col);
		var lstm_cd=sheetObj.GetCellValue(Row,"lstm_cd");
        for(var i=1; i<= sheetObj.RowCount(); i++)
        {
            //in case of Purchase option = "Y", checking
			if(sheetObj.GetCellValue(i,6) == "Y" && sheetObj.GetCellValue(i,3) != "OW"){
				if (sheetObj.GetCellValue(i,7) == "" || sheetObj.GetCellValue(i,7) == "0" || sheetObj.GetCellValue(i,7) == "0.00"){
       			     ComShowCodeMessage("MST00001", "Purchase Price");
       			     sheetObj.SelectCell(i,7, true);
         		     return;
       		    }         		
        	}	
        	 //  checking duplicated lstm_cd onsheet
	       	 if(i != Row)		
	       	 {
				var cur_code=sheetObj.GetCellValue(i,"lstm_cd");
	       		 if(lstm_cd == cur_code && lstm_cd != "")
	       		 {
	       			 //error message : Data is duplicated, Please check data again.
	       			 ComShowCodeMessage("MST00002",cur_code);
	       		     sheetObj.SelectCell(Row, 2, true);
	       			 return;
	       		 }
	       	 }
        }//End for 		
        //mandatory Check
        //if( Col == "3" || Col == "4" || Col == "6" || Col == "8"){
        if (sName == "lstm_cd" || sName == "lstm_nm" || sName == "pur_opt_flg" || sName == "dp_seq"){
			if (sName == "lstm_cd" && sheetObj.GetCellValue(Row,Col).length == 1){
     			 ComShowCodeMessage("MST00001","Lease Term");
      		     sheet1.SetCellValue(Row,Col,"");
      		     sheet1.SelectCell(Row, Col-1, true);
      			 return;
        	}
if (sheetObj.GetCellValue(Row,Col) == ""){
      			 ComShowCodeMessage("MST00001","Lease Term,Description,Purchase Option,Display Sequence");
      		     sheet1.SetCellValue(Row,Col,"");
      		     sheet1.SelectCell(Row, Col-1, true);
      			 return;
        	}
        }
 	}
 	/**
 	 * handling event click onsheet <br>
 	 * @param {IBsheet} sheetObj    IBsheet Object
 	 * @param {IBsheet} row     	 Row Index
 	 * @param {IBsheet} col     	 column Index
 	 **/
 	function sheet1_OnClick(sheetObj, row, col) {
 	} 	
     /**
      * registering IBsheet Object as list
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
    	 frm=document.form;    	  
    	 sheet1=sheetObjects[0];
         for(i=0;i<sheetObjects.length;i++){
	         ComConfigSheet(sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	         ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();  
         doActionIBSheet(sheetObjects[0], document.form, SEARCH09);
     }
     function sheet1_OnLoadFinish(sheetObj) {
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
     }
      /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
                    with(sheetObj){
							
									
					  var HeadTitle="||Seq.|Lease Term|Description|Lease Period(Years)|Purchase Option|Purchase Price(USD)|Display\nSequence|Remark(s)";
					  var prefix="sheet1_";

					  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

					  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					  var headers = [ { Text:HeadTitle, Align:"Center"} ];
					  InitHeaders(headers, info);

					  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
							 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
							 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
							 {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"lstm_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
							 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"lse_prd_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							 {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pur_opt_flg",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"pur_prc",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"diff_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 } ];
					   
							InitColumns(cols);
							SetColProperty("pur_opt_flg", {ComboText:"No|Yes", ComboCode:"N|Y"} );
							SetEditable(1);
							
							SetColProperty(0, "lstm_cd",  {AcceptKeys:"E" , InputCaseSensitive:1});
							SetColProperty(0, "lstm_nm", {AcceptKeys:"E|[0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ ]" , InputCaseSensitive:1});
							SetColProperty(0, "lse_prd_ctnt",  {AcceptKeys:"E|[0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ ]" , InputCaseSensitive:1});
							SetColProperty(0, "diff_rmk", {AcceptKeys:"E|[0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ ]"});
							SetColProperty(0, "dp_seq", {AcceptKeys:"N"});
							/*InitDataValid(0, "lstm_cd", vtEngUpOnly); //upper case
							InitDataValid(0, "lstm_nm", vtEngUpOther, "0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ ");   //only alphabet
							InitDataValid(0, "lse_prd_ctnt", vtEngUpOther, "0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ "); //alphabet & number
							InitDataValid(0, "diff_rmk", vtEngOther, "0123456789-~[](){}_|*&^%$#@!,'<>.?/-=\+ ");   //only alphabet
							InitDataValid(0, "dp_seq", vtNumericOnly);   //only number
*/							//SetSheetHeight(448);
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
         switch(sAction) {
            case IBSEARCH:      //retrieve
			   if(sheetObj.id == "sheet1") {
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);				   
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("EES_MST_0004GS.do", FormQueryString(formObj) );
					ComOpenWait(false);
			   }
            break;
 			case IBSAVE:        //save
				if(validateForm(sheetObj,formObj,sAction)){
					var sel_code=sheetObj.GetCellValue(selrow,"lstm_cd");
					var cur_code="";
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("EES_MST_0004GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				}
            break;
 			case IBDELETE:      // removing
	   	   		if (sheetObj.id == 'sheet1') {  
					sheetObj.SelectFontBold=false;
		   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk"); 
						sheetObj.SelectFontBold=true;
					}
				}    			
			break;
 			case SEARCH09:      //retrieving Officd Code
				if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "MST", strOfcCd) ) {
					div_ofc1.style.display="none";
					div_ofc2.style.display="none";
				}else{
					div_ofc1.style.display="";
					div_ofc2.style.display="";
				}
				sheet1_OnLoadFinish();
				break;
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
							if (sheetObj.GetCellValue(i  ,"lstm_nm").trim().length == 0){
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
 	/** 
 	 * hiddingsheet
 	 * @param 	{IBsheet} 	sheetObj
 	 */   	 	       
 	function MstAllSheetHidden(sheetObj){    
 		for (var idx=1; idx <= sheetObj.RowCount(); idx++){
 			sheetObj.SetRowHidden(idx,1);
 		}  	
 	}          

 	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}

