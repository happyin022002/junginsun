/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0652.js
*@FileTitle  : Customer Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // Event handler processing by button click event  */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1]; 
        var sheetObject3=sheetObjects[2];		         
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)){
						sheetObject1.RemoveAll();
						sheetObject2.RemoveAll();
						sheetObject3.RemoveAll();
						doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					}
				break;
				case "btn_Add":
					sheetObject3.DataInsert(-1);
				break;
				case "btn_Delete":
					ComRowHideDelete(sheetObject3,"chk");
				break;
				case "btn_Save":
					if(validateForm(sheetObject3,formObject,IBSAVE)){
						doActionIBSheet(sheetObject3, formObject, IBSAVE);
					}
				break;
				case "btn_Select":
					if(validateSelect(sheetObject1, sheetObject3, formObject)){
						var rArray = getLocalCheckedRows(sheetObject1);
						comPopupSend(sheetObject1, sheetObject2, sheetObject3, formObject);	
					}
				break; 							
				case "btn_Close":
					ComClosePopup(); 
				break;						
				case "btn_DownExcel":
				if(sheetObject3.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject3.Down2Excel({HiddenColumn: 1, DownRows:"Visible"});
				}
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
     * adding first-served functions after loading screen
     */
    function loadPage() {   	 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);            
        }        

        initControl();
        
 		var formObj=document.form;
        if(formObj.cust_cnt_cd.value.length == 2 && (formObj.cust_seq.value.length > 0 || formObj.cust_nm.value.length > 2)){
  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }         
 		
    }
   	function initControl() {
        axon_event.addListenerForm('keydown', 'ComKeyEnter', document.form);
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
            case "sheet1":      //sheet1 init
                with(sheetObj){
            		var bHidden = (document.form.bkgCustTpCd.value=="S")?1:0;
					var HeadTitle="|Sel.|Status|Code|Name|Location|Type|FMC|S.OFC|Customer Address";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pb",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"customer_code",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
					             {Type:"Text",      Hidden:0,  Width:225,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:35 },
					             {Type:"Text",      Hidden:0,  Width:55,  Align:"Left",    ColMerge:0,   SaveName:"loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:35 },
					             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"cust_div_flag",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:bHidden,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"frt_fwrd_fmc_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:600,  Align:"Left",    ColMerge:0,   SaveName:"bzet_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd" },
					             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq" },
					             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg" } ];
					
					InitColumns(cols);
					
					SetEditable(1);
					SetCountPosition(0);
					SetWaitImageVisible(0);
					SetSheetHeight(ComGetSheetHeight(sheetObj, 6));

            }
                break;
                
            case "sheet2":      //sheet2 init
                with(sheetObj){
					var HeadTitle="|S.OFC|S.REP|S.REP Name";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"srep_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"srep_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					
					InitColumns(cols);
					
					SetEditable(0);
					SetCountPosition(0);
					SetSheetHeight(ComGetSheetHeight(sheetObj, 6));
				}
                break;
                
            case "sheet3":      //sheet3 init
            	with(sheetObj){
            		var bHidden = (document.form.bkgCustTpCd.value=="F")?1:0;
	            	var HeadTitle="|Sel.|Part|Contact Person|Tel|Mobile|Fax|E-mail|FWDR Code|Remark(s)";
	
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	            	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cntc_pson_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:"A-All|B-BKG|S-S/I", ComboCode:"AL|BK|SI" },
	            	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	            	             {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"phn_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
	            	             {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_mphn_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
	            	             {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"fax_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
	            	             {Type:"Text",      Hidden:0,  Width:165,  Align:"Left",    ColMerge:0,   SaveName:"cntc_eml",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	            	             {Type:"Text",      Hidden:bHidden,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"fwrd_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8, AcceptKeys:"E|N", InputCaseSensitive:1 },
	            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"diff_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_seq" },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd" },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq" } ];
	            	 
	            	InitColumns(cols);
	            	
	            	SetEditable(1);
					SetCountPosition(0);
//					SetSheetHeight(ComGetSheetHeight(sheetObj, 9));
					resizeSheet();
            	}
				

                break;
        }
    }
    
    function resizeSheet(){
   	         ComResizeSheet(sheetObjects[2]);
   }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		case IBSEARCH:      
			formObj.f_cmd.value=SEARCH01;
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0652GS.do" , FormQueryString(formObj));
			break;
		case IBSAVE:        
			formObj.f_cmd.value=MULTI;
			var sParam=FormQueryString(formObj);
			// get customer code of Sheet1
			var chkCustCd;
			var chkCustSeq;
			for (var ir=sheet1.HeaderRows(); ir<sheet1.HeaderRows()+sheet1.RowCount(); ir++) {
	     		if(sheet1.GetCellValue(ir,"chk") == "1"){
	      			chkCustCd=sheet1.GetCellValue(ir,"cust_cnt_cd");
	      			chkCustSeq=sheet1.GetCellValue(ir,"cust_seq");
	     		}
	 	    } 		 
			for (var i3=sheet3.HeaderRows(); i3<sheet3.HeaderRows()+sheet3.RowCount(); i3++) {
	     		if(sheet3.GetCellValue(i3,"ibflag") == "I"){
	     			sheet3.SetCellValue(i3,"cust_cnt_cd",chkCustCd);
	     			sheet3.SetCellValue(i3,"cust_seq",chkCustSeq);
		 	    } 	
			}
			sheetObj.DoSave("ESM_BKG_0652GS.do?detail_cust_cnt_cd=" + chkCustCd + "&detail_cust_seq=" + chkCustSeq , FormQueryString(formObj));
			break;
		case IBINSERT:     
			break;
        }
    }
    // Part Validation
	function validateSelect(sheetObj1, sheetObj3, formObject){
		for ( i=1 ; i <= sheetObj1.LastRow() ; i++ ){
			if(sheetObj1.GetCellValue(i, "chk") == "1" && sheetObj1.GetCellValue(i, "delt_flg") == "Y"){
				ComShowCodeMessage("BKG00353",sheetObj1.GetCellValue(i, "cust_cnt_cd"),sheetObj1.GetCellValue(i, "cust_seq"));
    			return false;
    		}
    		// error in case of Status is 'NO USE' 
			if(sheetObj1.GetCellValue(i, "chk") == "1" && sheetObj1.GetCellValue(i, "pb") == "NO USE"){
				ComShowCodeMessage("BKG02004",sheetObj1.GetCellValue(i, "cust_cnt_cd")+sheetObj1.GetCellValue(i, "cust_seq"));
    			return false;
    		}
    		// in case of BLACK
			if(sheetObj1.GetCellValue(i, "chk") == "1" && sheetObj1.GetCellValue(i, "pb") == "BLACK"){
    			ComShowCodeMessage("BKG00055");
        	}
    	}
		var isFlag=true;
		for ( i=1 ; i <= sheetObj3.LastRow() ; i++ ){
	    	if(isFlag){
	    		if(sheetObj3.GetCellValue(i, "chk") == "1"){
	    			for(j=1 ; j < sheetObj3.LastRow() ; j++){
	    				if(sheetObj3.GetCellValue(j, "chk") == "1" && i != j){
	    					if(sheetObj3.GetCellValue(j, "bkg_cntc_pson_tp_cd") == "AL"){
	    						isFlag=false;
	    						break;
	    					}	        	
	    					if(sheetObj3.GetCellValue(j, "bkg_cntc_pson_tp_cd") == sheetObj3.GetCellValue(i, "bkg_cntc_pson_tp_cd")){
	    						isFlag=false;
	    						break;	        			 
	    					}
	    					if(sheetObj3.GetCellValue(i, "bkg_cntc_pson_tp_cd") == "AL" && sheetObj3.GetCellValue(j, "bkg_cntc_pson_tp_cd") != ""){
	    						isFlag=false;
	    						break;	        			 	        			 
	    					}        				 
	    				}
	    			}
	    		}        		 
	    	}else{
	    		break;
	    	}
	    }    
	    if(!isFlag){
	    	ComShowCodeMessage("BKG01022");
	    }	    
	    return isFlag;
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		 switch (sAction) {
		 	case IBSEARCH: 
		 		if (ComChkLen(formObj.cust_cnt_cd,2) != 2 || !ComIsAlphabet(formObj.cust_cnt_cd)) {
		 			ComShowCodeMessage("BKG00186");
					formObj.cust_cnt_cd.focus();
					return false;
		 		}else if(ComIsNull(formObj.cust_seq.value) && formObj.cust_nm.value.length < 2){
		 			ComShowCodeMessage("BKG00404", "Customer Seq. or Name");
		 			formObj.cust_seq.focus();
		 			return false;
				}else{
					formObj.cust_cnt_cd.value=formObj.cust_cnt_cd.value.toUpperCase();
				}
				break;
		 	case IBSAVE:
		 		var sheet3=sheetObjects[2];			
		 		for (var i=sheet3.HeaderRows(); i<=sheet3.LastRow(); i++) {
		 			if(sheet3.GetCellValue(i, "cntc_pson_nm").length>100){
		 			 	ComShowCodeMessage("BKG04012", "Contact Person", "100");
		 				return false;
		 			}
		 			if(sheet3.GetCellValue(i, "phn_no").length>50){
		 			 	ComShowCodeMessage("BKG04012", "Tel No", "50");
		 				return false;
		 			}
		 			if(sheet3.GetCellValue(i, "cntc_pson_mphn_no").length>50){
		 			 	ComShowCodeMessage("BKG04012", "Mobile No", "50");
		 				return false;
		 			}		 			
		 			if(sheet3.GetCellValue(i, "fax_no").length>50){
		 			 	ComShowCodeMessage("BKG04012", "Fax No", "50");
		 				return false;
		 			}		 			
		 			if(sheet3.GetCellValue(i, "cntc_eml").length>100){
		 			 	ComShowCodeMessage("BKG04012", "Email address", "100");
		 				return false;		 				
		 			}
		 		}
		 		break;
		}
		return true;
    }

     /**
      * handling sheet1 OnDBLClick 
      * @param {ibsheet} sheet   
      * @param {long} row
      * @param {long} col 
      * @param {string} value
     */
    function sheet1_OnDblClick(sheet , row, col) {  
     	var formObj=document.form; 
     	if(sheet.GetCellValue(row,"delt_flg") == "Y"){
     		sheet.SetCellFontColor(row,col,"#FF0000");
 		} 		    	
     	sheet.SetCellValue(row,"chk",1);	//sheet1_OnChange event fire
    }     
    //font color is red in case of Delete Flag is 'Y'
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    	if (sheetObj.LastRow()>=1) sheetObj.SetCellValue(1,"chk",1);
    	for (var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++) {
    		if(sheetObj.GetCellValue(ir,"delt_flg") == "Y"){
	    		sheetObj.SetRangeFontColor(ir,3,ir,8,"#FF0000");
    		}
	    } 		
    	ComOpenWait(false);
    }
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var formObj=document.form;
    	if(sheetObj.ColSaveName(Col) == "chk" && Value=="1"){        		
			var chkCustCd=sheetObj.GetCellValue(Row,"cust_cnt_cd");
			var chkCustSeq=sheetObj.GetCellValue(Row,"cust_seq");
    		formObj.f_cmd.value=SEARCH02;
    		var sXml=sheetObj.GetSearchData("ESM_BKG_0652GS.do", "detail_cust_cnt_cd=" + sheetObj.GetCellValue(Row,"cust_cnt_cd") + "&detail_cust_seq=" + sheetObj.GetCellValue(Row,"cust_seq") + "&" + FormQueryString(formObj));
      		var arrXml=sXml.split("|$$|");
      		if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0]);
      		if (arrXml.length > 1) sheetObjects[2].LoadSearchData(arrXml[1]);
    	}
    }
    /**
     * handling OnSaveEnd event <br>
     * @param {ibsheet} sheetObj
     * @param {string} ErrMsg
     */ 	
 	function sheet3_OnSaveEnd(sheetObj, ErrMsg)  {
 		if (ErrMsg == "") {
			ComBkgSaveCompleted();			
		}
	}     
	//double click -> select
    function sheet3_OnDblClick(sheetObj , row, col) {  
    	if(sheetObj.ColSaveName(col)=="chk"){
       	 	var formObj=document.form;
       	 	sheetObj.SetCellValue(row,"chk","1",0);
			comPopupSend(sheetObjects[0], sheetObjects[1], sheetObjects[2], formObj);
    	}
    }     
    
    function sheet3_OnChange(sheetObj, Row, Col, Value){
    	var formObj = document.form;
    	if(sheetObj.ColSaveName(Col) == "fwrd_cnt_cd" && Value != ''){       
    		formObj.f_cmd.value = SEARCH03;
    		var sXml = sheetObj.GetSearchData("ESM_BKG_0652GS.do", "fwrd_cnt_cd=" + Value + "&cntr_cust_tp_cd=B" + "&" + FormQueryString(formObj));
    		if(ComGetEtcData(sXml, "custCntCd") == undefined){
    			ComShowCodeMessage("BKG00044", "FWDR Code");
    			sheetObj.SetCellValue(Row, "fwrd_cnt_cd", "");
    			sheetObj.SelectCell(Row, Col);
    		}
    	}
    }
    
    /**
     * send screen info to Main
     */     
	function comPopupSend(sheetObj1, sheetObj2, sheetObj3, formObj){
		 var calllFunc=formObj.calllFunc.value;
		 var bkgCustTpCd=formObj.bkgCustTpCd.value;
		 var rArray1=null;
		 var rArray2=null;
		 
		 rArray1 = getLocalCheckedRows(sheetObj1);
		 if(sheetObj3.RowCount("R") > 0){
			 rArray2 = getLocalCheckedRows(sheetObj3);
		 }
		 var lOfc = "";
		 var lRep = ""; 
		 if (sheetObj2.GetSelectRow() > 0) {
			 lOfc = sheetObj2.GetCellValue(sheetObj2.GetSelectRow(),"ofc_cd");
			 lRep = sheetObj2.GetCellValue(sheetObj2.GetSelectRow(),"srep_cd");
		 } 

		 if (ComFuncCheck("opener." + calllFunc)) ComFunc(bkgCustTpCd, rArray1, rArray2, lOfc, lRep);
		 else if (ComFuncCheck("parent." + calllFunc)) ComFunc(bkgCustTpCd, rArray1, rArray2, lOfc, lRep);
		 
		 ComClosePopup(); 
	}  
	
    function getLocalCheckedRows(sheetObj,colName) {
   		var checkRows;
   		var colsCnt=sheetObj.LastCol()+ 1;
   		var rArray=null; // row data
   		var cArray=null; // col data
   		checkRows = sheetObj.FindCheckedRow('chk');
   		if(checkRows == "")  return null;
   		
   		var arrRows = checkRows.split("|");
   		rArray = new Array(arrRows.length);
   		for(var idx = 0; idx < arrRows.length; idx++){
   			var ir = parseInt(arrRows[idx]);
   			cArray=null;
	  		if(colName != null && colName != "") {
	  			cArray=sheetObj.GetCellValue(ir, colName);
	  		} else {
	  			cArray = new Array(colsCnt);
		  		for(var j = 0; j < colsCnt; j++) {
		  			cArray[j] = sheetObj.GetCellValue(ir, j);
                }
           }
           rArray[idx]=cArray;
   		}
   	  	return rArray;
   	}       
