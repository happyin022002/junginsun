/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_5002.js
*@FileTitle  : Percent Base Charge Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_5002 : business script for ESM_PRI_5002  
     */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var now_select_sheet1=0 ;
	var max_pct_bse_cd=0 ;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
   /**
    * Initializing and setting Sheet basics <br>
    * Setting body tag's onLoad event handler <br>
    * Adding pre-handling function after loading screen on the browser  <br>
    */
	function loadPage() {
    	initControl();
		for (i=0; i < sheetObjects.length; i++) {			
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);			
			ComEndConfigSheet(sheetObjects[i]);	
		}
		doActionIBSheet(sheetObjects[0], document.form , SEARCH01);
	}
	/**
     * Event handler processing by button name  <br>
     */
	function processButtonClick(){       
        var sheetObject1=sheetObjects[0];    
        var sheetObject2=sheetObjects[1];       
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_save": 
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
				case "btn_Retrieve": 
				case "btn_new":	
	 	     		if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
	 	     			if (ComShowCodeConfirm("PRI00006")) {
	 	     				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
	 	     				return false;
		 	     		}
	 	     		}
	 	     		doActionIBSheet(sheetObject1, formObject, SEARCH01);
					break;
				case "btn_rowadd1":
	                doActionIBSheet(sheetObject1, formObject,IBINSERT);
					break;
				case "btn_rowdelete1": 
					doActionIBSheet(sheetObject1, formObject, IBDELETE);					
					break;		
				case "btn_rowadd2":
	                doActionIBSheet(sheetObject2, formObject,	MODIFY01);
					break;
				case "btn_rowdelete2": 
					doActionIBSheet(sheetObject2, formObject, IBDELETE);					
					break;	
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
    /**
    * handling Axon event<br>
    */    
     function initControl() {         
        //axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        //axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);            
		//axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form	); 	
        //axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
     } 
  /**
	* registering IBSheet Object as list <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	* registering IBCombo Object as list  <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}	 
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
     	switch(sheetID) {
     	case "sheet1":
     	    with(sheetObj){
            
          var HeadTitle="ibflag|Sel.|Base Code|DP Seq.|Description|pri_scg_prf_use_yn|MAX_PCT_BSE_CD";
          var headCount=ComCountHeadTitle(HeadTitle);
          (headCount, 0, 0, true);

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pct_bse_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:"patt_desc",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pri_scg_prf_use_yn" },
                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"max_pct_bse_cd" } ];
           
          InitColumns(cols);
          resizeSheet();//SetSheetHeight(585);
          SetEditable(1);
          SetWaitImageVisible(0);
                //conversion of function[check again]CLT InitDataValid( 0, "dp_seq", vtNumericOnly );
          }


          	break;
     	case "sheet2":
     	    with(sheetObj){
           
          var HeadTitle="ibflag|Sel.|Base Code|CHG Code|CHG Name";
          var headCount=ComCountHeadTitle(HeadTitle);
          (headCount, 0, 0, true);

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pct_bse_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"chg_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);
          resizeSheet();//SetSheetHeight(585);
          SetEditable(1);
          SetWaitImageVisible(0);
          SetColProperty("chg_cd", {ComboText:scgCdText, ComboCode:scgCdValue} );
          }
          	break;
     	}
	}
	function resizeSheet(){ ComResizeSheet(sheetObjects[0]); ComResizeSheet(sheetObjects[1]); }
  /**
   * Handling sheet process <br>
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
	   try {
			ComOpenWait(true);
	 		sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {																		
		 		case SEARCH01: 	 			
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			formObj.f_cmd.value=SEARCH01;		 
		 			sheetObjects[1].RemoveAll();		 			
		 			sheetObj.RemoveAll();
		 			var sXml=sheetObj.GetSearchData("ESM_PRI_5002GS.do", FormQueryString(formObj));
		 			if(sXml != null) sheetObj.LoadSearchData(sXml,{Sync:0} );
		 			
	 		 		break;		 				 		
		 		case IBINSERT: // Row Add 1	
	                var idx=doRowChange(sheetObj, sheetObjects[1], sheetObj.GetSelectRow(), sheetObj.GetSelectRow()+ 1, sheetObj.GetSelectCol(), sheetObj.GetSelectCol, true);
	                if (idx < 0) {
	                    return false;
	                }
		 			with (sheetObjects[0]) { 
			 			var nowRow=GetSelectRow();
			 			
			 			
			 			var vPctBseCd = "0";
			 			if( parseInt(max_pct_bse_cd) + 1 < 10) {
			 				vPctBseCd = "0" + ( parseInt(max_pct_bse_cd) + 1 ).toString();
			 			} else {
			 				vPctBseCd = ( parseInt(max_pct_bse_cd) + 1 ).toString();
			 			}
			 			
			 			sheetObj.SetCellValue(idx, "pct_bse_cd", vPctBseCd );
			 			//sheetObj.SetCellValue(idx, "pct_bse_cd",parseInt(max_pct_bse_cd) + 1 );
			 			sheetObj.SetCellValue(idx, "dp_seq",parseInt(max_pct_bse_cd) + 1 );
			 			sheetObj.SetCellValue(idx, "pri_scg_prf_use_yn","N");
			 			sheetObj.SetCellEditable(idx, "pct_bse_cd",0 );
			 			max_pct_bse_cd=parseInt(max_pct_bse_cd) + 1
			 			now_select_sheet1=idx;
			 			sheetObjects[1].RemoveAll();
		 			}
		 			break; 
		 		case MODIFY01: // Row Add 2		 		
		 			with (sheetObjects[1]) { 
			 			var nowRow=GetSelectRow();
			 			maxRow=DataInsert(-1);
			 			sheetObj.SetCellValue(maxRow, "pct_bse_cd",sheetObjects[0].GetCellValue( now_select_sheet1 , "pct_bse_cd"));
			 			sheetObj.SetCellEditable(maxRow, "chg_cd",1 );
		 			}
		 			break; 	
		 		case IBDELETE:    
		 			
		 			var rowCnt = sheetObj.RowCount() - sheetObj.RowCount("D");
		 			if(rowCnt != null && rowCnt != "" && rowCnt > 0) {
		 				
		 				var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
		 				//only apply the right sheet
		 				if(sheetObj.id == "sheet2") {
				 			//Delete the selected Row
			 				var delRowIdx = sheetObj.GetSelectRow();
			 				if(delRowIdx > 0 && (chkArr == undefined || chkArr == null || chkArr.length == 0)) {
			 					ComShowCodeMessage("COM12114","the charge code to delete.");
			 					return false;
			 				}
		 				}
		 				
			 			//Delete the checked Rows
			 			if(chkArr != null && chkArr.length > 0) {
				 			var sChk = "";
				 			for(i=0 ; i< chkArr.length ; i++){
			 					if(sheetObj.GetCellValue( chkArr[i] , "pri_scg_prf_use_yn") == "Y"){
			 						ComShowCodeMessage("PRI01022");
			 						return false;
			 					}else{
			 						sChk+= "|"+chkArr[i];
			 					}
			 				}
			 				var sDel = sChk.substring(1, sChk.length);
			 				sheetObj.SetRowHidden( sDel ,1);
			 				
			 				for(i = chkArr.length - 1 ; i >= 0; i--){
			 					sheetObj.SetCellValue( chkArr[i] , "ibflag","D", 0);
			 				}
			 			}
	 				
		 			}
	 				
	 				
	 		 		break;			
		 		case IBSAVE: 	
		 			if (!validateForm(sheetObj,document.form,sAction)) {		 				
						return false;
					} 	
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
					if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
					    return;
					}
                    var sParamSheet2=sheetObjects[1].GetSaveString(true);
					if (sheetObjects[1].IsDataModified()&& sParamSheet2 == "") {
					    return;
					}
		 			formObj.f_cmd.value=MULTI;	
		 			var sParam=FormQueryString(formObj);
			 		if( sParamSheet1 != "" ){
						sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
					}
			 		if( sParamSheet2 != "" ){
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
					
					var sXml=sheetObj.GetSaveData("ESM_PRI_5002GS.do", sParam);
					sheetObj.LoadSaveData(sXml);
//		 			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
//		     	    if(sav != "F" ){
		     		   //sheetObjects[1].RenderSheet(0);
		     		   //sheetObjects[1].RemoveAll();
//					   doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		     		   //sheetObjects[1].RenderSheet(1);
//		       	    }
//		     	    sheetObj.LoadSaveData(sXml);
		 			break;			 							    
	 		}
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}finally {
			 ComOpenWait(false);
		}
	}
 	
 	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
 		max_pct_bse_cd=sheetObj.GetCellValue( 1 , "max_pct_bse_cd");
 	}
 	
 	/**
     * OnSaveEnd 시 발생한다.<br>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Code,Msg    
     * @return 없음
     * @author SHKIM
     * @version 2012.04.17
     */
 	function sheet1_OnSaveEnd(sheetObj, Code , Msg)  {
 		if (Code >= 0) {
 			doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
 		}
 	}
 	
     /**
     * checking validation process of inputed form data <br>
     */
 	function validateForm(sheetObj, formObj, sAction) {
    	 switch (sAction) {     	 		 
	    	 case IBSAVE:        
	            var dupRow1=sheetObj.ColValueDup("patt_desc");
	            var dupRow2=sheetObj.ColValueDup("dp_seq");
	            var dupRow3=sheetObjects[1].ColValueDup("chg_cd");
	            var sheet1_row_count=sheetObj.RowCount();
	            var sheet2_row_count=sheetObjects[1].RowCount();
 	     		if (sheetObjects[0].IsDataModified()== false && sheetObjects[1].IsDataModified()== false) {
	                ComShowCodeMessage("PRI00301");
 	     			return false;
 	     		}
 	     		var currentGetRowStatus=sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow());
 	     		if ( ( currentGetRowStatus!= "D" ) &&
 	     			 ( sheetObjects[1].RowCount() == 0 ||  sheetObjects[1].RowCount() == sheetObjects[1].RowCount("D") ) ) {
 	     			ComShowCodeMessage("PRI00319", "Percent Base Code");
 	     			return false;
 	     		}
	            if (dupRow1>0) {  
	            	sheetObj.SetSelectRow(dupRow1);
	                ComShowCodeMessage("PRI00342","Description");
	                ComSetFocus(sheetObj.ColValueDupRows("patt_desc"));	
	                return false;
	            }
	            if (dupRow2>0) {
	            	sheetObj.SetSelectRow(dupRow2);
	                ComShowCodeMessage("PRI00342","DP Seq.");
	                ComSetFocus(sheetObj.ColValueDupRows("dp_seq"));	
	                return false;
	            }
	            if (dupRow3>0) {
	            	sheetObjects[1].SetSelectRow(dupRow3);
	                ComShowCodeMessage("PRI00342","CHG Code");
	                ComSetFocus(sheetObjects[1].ColValueDupRows("chg_cd"));	
	                return false;
	            }	            
	            for(var i=0 ; i < sheet1_row_count+1 ; i++ ){
	            	if(ComTrimAll(sheetObjects[0].GetCellValue( i , "patt_desc")) == ""){
	            		ComShowCodeMessage("PRI00316","Description"); 
	            		return false;
	            	}else if(ComTrimAll(sheetObjects[0].GetCellValue( i , "dp_seq")) == ""){
	            		ComShowCodeMessage("PRI00316","DP Seq."); 
	            		return false;	            		
	            	}
	            }
	            for(var i=1 ; i < sheet1_row_count+1 ; i++ ){
	            	if(!ComIsNumber(sheetObjects[0].GetCellValue( i , "dp_seq"))){
	            		ComShowCodeMessage("PRI00311"); 
	            		return false;
	            	}
	            }	            
		    	 break;	    	 
    	 }
 		return true;
 	}
     /**
      * sheet에서 cell을 클릭한 경우 발생. <br>
      * <br><b>Example :</b>
      * <pre>
      *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} OldRow 
      * @param {int} OldCol 
      * @param {int} NewRow 
      * @param {int} NewCol 
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	 doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
     }
     var isFiredNested=false;
     var supressConfirm=false;
     /**
      * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
      * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
      * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
      * 
      * <br><b>Example :</b>
      * <pre>
      *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} OldRow 
      * @param {int} OldCol 
      * @param {int} NewRow 
      * @param {int} NewCol 
      * @param {String} sAction
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
         var formObj=document.form;
         var adjNewRow=NewRow;
         if (!isFiredNested && (OldRow != NewRow)) {
             if (sheetM.IsDataModified()) {
                 isFiredNested=true;
                 sheetM.SelectCell(OldRow, OldCol, false);
                 isFiredNested=false;
                 if (validateForm(sheetM,document.form,IBSAVE)) {
                     isFiredNested=true;
                     sheetM.SelectCell(NewRow, NewCol, false);
                     isFiredNested=false;
                 } else {
                     isFiredNested=true;
                     sheetM.SelectCell(OldRow, OldCol, false);
                     isFiredNested=false;
                     return -1;
                 }
             }
             if (sheetD.IsDataModified()) {
                 isFiredNested=true;
                 sheetM.SelectCell(OldRow, OldCol, false);
                 isFiredNested=false;
                 var rslt=false;
                 if (ComShowCodeConfirm("PRI00006")) {
                     supressConfirm=true;
                     adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
                     var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
                     supressConfirm=false;
                 }
                 if (rslt) {
                     isFiredNested=true;
                     sheetM.SelectCell(adjNewRow, NewCol, false);
                     isFiredNested=false;
                 } else {
                     isFiredNested=true;
                     sheetM.SelectCell(OldRow, OldCol, false);
                     isFiredNested=false;
                     return -1;
                 }
             }
             if (appendRow) {
                 isFiredNested=true;
                 var idx=sheetM.DataInsert(-1);
                 isFiredNested=false;
                 return idx;
             } else {  
            	sheetD.RemoveAll();
      			var formObj=document.form;
      			formObj.f_cmd.value=SEARCH02;
      			var param="f_cmd="   + formObj.f_cmd.value
      			+ "&pct_bse_cd="     + sheetM.GetCellValue(NewRow, "pct_bse_cd");
      			now_select_sheet1=NewRow ;
                try {
      			  	ComOpenWait(true);
      			  	var sXml=sheetD.GetSearchData("ESM_PRI_5002GS.do", param);
      			  	if(sXml != null) sheetD.LoadSearchData(sXml,{Sync:1} );
	                ComOpenWait(false);
                } catch (e) {
	   	            if (e == "[object Error]") {
	   	                ComShowMessage(OBJECT_ERROR);
	   	            } else {
	   	                ComShowMessage(e.message);
	   	            }
	   	       } finally {
	   	    	   ComOpenWait(false);
	   	       }
             } 
         }
     }
     /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
 	 */
 	function sheet2_OnComboChange(sheetObj, Row, Col, Code, Text){
 		var form=document.form;
 	    var colName=sheetObj.ColSaveName(Col);
 		switch(colName) {
 			case "chg_cd": 
 				var arr=Text.split ( "\t");
 				sheetObj.SetCellValue( Row, "chg_nm" ,arr[1],0);
 				break;
 		}
 	}	  
     /**
     * OnChange 이벤트 발생시 호출되는 function <br>
 	 */
 	function sheet2_OnChange(sheetObj, Row, Col, Value){
 		var form=document.form;
 	    var colName=sheetObj.ColSaveName(Col);
 		switch(colName) {
 			case "chg_cd": 
 				var sText=sheetObj.GetComboInfo( Row, Col, "Text" );
 				var idx=sheetObj.GetComboInfo( Row, Col, "SelectedIndex" );
 				var arrText=sText.split("|");
 				if ( idx > 0 ) {
 					sheet2_OnComboChange ( sheetObj, Row, Col, Value, arrText[idx] );
 				}
 				break;
 		}
 	}
