/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_2004_01.js
*@FileTitle  : Hard Coding Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2015/06/24
=========================================================*/

/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	// public variable

	var sheetObjects=new Array();
	var sheetCnt=0;
	
	var childResult=0;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	// Event handler processing by button name */
     function processButtonClick(){
          /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
 		         var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					case "btn_New":
						doActionIBSheet(sheetObjects[0], formObject, IBRESET);
						break;
//					case "btn_Save":
//						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
//						break;
					case "btn_Detail":
						doActionIBSheet(sheetObjects[0], formObject, SEARCH01);
						break;
//					case "btn_excelup":
//						sheetObjects[0].RemoveAll();
//						sheetObjects[0].RenderSheet(0); 						
//						sheetObjects[0].LoadExcel({ Mode:"HeaderSkip"});
//						sheetObjects[0].RenderSheet(1);
//						break;
//					case "btn_RowAdd":
//						addRow();
//						break;
//					case "btn_RowDel":
//						deleteRow();
//						break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
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
     function setComboObject(combo_obj) {  
    		comboObjects[comboCnt++]=combo_obj;  
    	}
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         // Event needed for screen
//    	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
//    	axon_event.addListenerForm('click', 'obj_click', document.form); // click
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }
      function obj_KeyPress() {
  		var obj=event.srcElement;
  		switch(ComGetEvent("name")) {
  		case "hrd_cdg_id":
  			ComKeyOnlyAlphabet("uppernum", "95"); 
  			break;
  		default:
  			ComKeyOnlyAlphabet('upper');
  		}
  	}
   /**
      * setting sheet initial values and header
      * 
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
            	    with(sheetObj){
                 
	               //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	               var HeadTitle1="||Seq.|ID|Description|Attribute 1|Attribute 2|Attribute 3|Attribute 4|Attribute 5|Attribute 6|Attribute 7|Attribute 8|Attribute 9|Attribute 10";
	               var headCount=ComCountHeadTitle(HeadTitle1);
	               (headCount, 0, 0, true);
	
	               SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                      {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                      {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                      {Type:"Text",      Hidden:0, Width:200,  Align:"Left",  	ColMerge:1,   SaveName:"hrd_cdg_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
                      {Type:"Text",      Hidden:0, Width:385,  Align:"Left",    ColMerge:1,   SaveName:"hrd_cdg_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:400 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm6",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm7",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm8",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm9",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                      {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_nm10",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];
                
	               InitColumns(cols);
	               SetEditable(0);	               
	               SetSheetHeight(450);
	               SetColProperty(0 , 3, {AcceptKeys:"E|N|[_]" , InputCaseSensitive:1});
               }
               break;
         }
     }  
     // handling sheet process
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg(false);
	     switch(sAction) {
	     	case IBSEARCH:      //retrieve
//				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var sParam=FormQueryString(formObj);
				//ComShowMessage("sParam : " + sParam); 				
				sheetObj.DoSearch("ESM_BKG_2004_01GS.do",sParam);
				ComOpenWait(false);
				break;
	     	case IBRESET: // New
	     		if(!validateForm(sheetObj,formObj,sAction)) return false;
//				formObj.RemoveAll();
				formObj.reset();
				sheetObjects[0].RemoveAll();
//				initPage();
//	     		loadPage();
				break;
//	     	case IBSAVE: // Save
//				//if(!validateForm(sheetObj,formObj,sAction)) return false;
//				//			ComOpenWait(true, true);
//				formObj.f_cmd.value=MULTI;
//				var sheet2=sheetObjects[1];
//				var sParam=sheetObj.GetSaveString(false, true, "ibflag");
//				var sXml=sheetObjects[0].GetSaveData("ESM_BKG_2004_01GS.do", "f_cmd=" + MULTI + "&" +sParam);
//				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
//				if(State != "S"){
//					ComShowMessage(ComResultMessage(sXml));
//					ComOpenWait(false, false);
//					return false;
//				}else if(State == "S"){
//					ComShowCodeMessage('BKG00166');
//				}
//				formObj.hrd_cdg_id.value='';
//				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//				break;

			case SEARCH01:  //Detail
				//if(!validateForm(sheetObj,formObj,sAction)) return false;				
	   			var cnt=0;
				var row=0;
				for (var i=1 ; i < sheetObj.RowCount()+1 ; i++){
					if(sheetObj.GetCellValue(i, "check") == 1){
		    			 cnt++;
		    			 row=i;
		    		}
				}				 
				if(cnt != 1){
					 ComShowCodeMessage("BKG40076");//Please select one row
				     return false;
				}
	     		popupId(row); 
				break;
//			case SEARCH02:	//check if there is id in DB
//				formObj.f_cmd.value=SEARCH02;
//				sheetObj.SetWaitImageVisible(0);
//				var sXml=sheetObj.GetSaveData("ESM_BKG_2004_01GS.do", FormQueryString(formObj));
//				var valResult=ComGetEtcData(sXml, "hrd_id_cnt");
//				if(valResult == '1'){
//					ComShowCodeMessage('BKG95051');//The Same ID is existed.
//					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "hrd_cdg_id",'',0);
//				}
//               	break;
//			case SEARCH03:	        //check if there are some data on child table
//		      	  formObj.f_cmd.value=SEARCH03;
//				  sheetObj.SetWaitImageVisible(0); 		      	  
//				  var sXml=sheetObj.GetSaveData("ESM_BKG_2004_01GS.do", FormQueryString(formObj));
//		      	  childResult=ComGetEtcData(sXml, "child_cnt");
//		         break;   	
	     }
	 }
     /**
      * handling process for input validation
      */
      function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
    		 if (sAction == SEARCH01){
    			 if(sheetObj.Cellvalue(sheetObj.GetSelectRow(),"ibflag")=='I'){
    				 ComShowCodeMessage("BKG01129"); //Please Save First.
    				 return false;
    			 }
//    		 }else if (sAction == IBSAVE){    			
//    			//alert(1);
//		      	for (var i=1 ; i < sheetObj.RowCount()+1 ; i++){
//		      		//alert(2);
//		      		alert(sheetObj.Cellvalue(i, 3));
//		  	    	if (sheetObj.Cellvalue(i, 3) == ''){
//		  	    		//alert(3);
//		  	    		ComShowCodeMessage("BKG95017", 'ID');//"There is no data to {?msg1}. Please check again." // ($s) is mandatory. Please enter ($s).
//		  	    		sheetObj.SelectCell(i, "hrd_cdg_id", true, "");
//		  	    		return false;
//		  	    	}
//		  	    	if(sheetObj.Cellvalue(i,"ibflag") == 'D'){
//		  	    		//alert(4);
//		  	    		childResult=0;
//		  	    		formObj.f_cmd.value=SEARCH03;
//		  	    		formObj.frm_hrd_cdg_id.value=sheetObj.Cellvalue(i,"hrd_cdg_id");
//		  	    		doActionIBSheet(sheetObj, formObj, SEARCH03);
//				      	if(childResult != 0){
//				      	  //alert(5);
//						  ComShowCodeMessage('BKG95055');//"You can\'t delete this data.\nHard Coding Contents table data should be deleted first." // Hard Coding Contents table data should be deleted first
//						  doActionIBSheet(sheetObj, formObj, IBSEARCH);
//						  return false;
//						 }
//		  	    	}
//		      	}
//		      	//alert(7);
//	       	     if (!sheetObj.IsDataModified()){
//	       	    	//alert(6);
//					ComShowCodeMessage('BKG95053');//There is no data to Save.\n\n Please check again.
//					return false; 
//	    		 }
    		 }else if (sAction == IBRESET){
       	     	if (sheetObj.IsDataModified()){
 					if(!ComShowConfirm(ComGetMsg("BKG95054"))){ 
 						return false; //There is modified data.Do you want to continue?
 					}
    		    }
    		} 
    	 }
          return true;
      }
     /**
      * process when you enter retrieve condition
      */
     function obj_KeyUp() {
     	var formObject=document.form;
     	var srcName=ComGetEvent("name");
     	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
     	var srcValue=window.event.srcElement.getAttribute("value");
     }
//	  /**
//	   * Validation check- check if there is id in DB
//	   */
//	  function sheet1_OnChange(sheetObj, Row, Col, Value){
//	  	var formObj=document.form;
//	  	if(sheetObj.ColSaveName(Col) == "hrd_cdg_id"){
//	  		formObj.f_cmd.value=SEARCH02;
//	  		formObj.frm_hrd_cdg_id.value=sheetObj.GetCellValue(Row, Col);
//	  		doActionIBSheet(sheetObj, formObj, SEARCH02);
//	  		}
//	  	}
//	/**
//	 * add row process in sheet1
//	 * add one row
//	 */
// 	function addRow() {
// 	  with (sheetObjects[0]) {
//         var nowRow=GetSelectRow();
//       	 nowRow=DataInsert(-1);
//       	 sheetObjects[0].SelectCell(nowRow, 'hrd_cdg_id', true, '');
//         return true;
//          }
//	 }
//	/**
//	 * delete row process in sheet1
//	 * delete one row
//	 */  
//	 function deleteRow() {
//	     with (sheetObjects[0]) {
//	  		if (sheetObjects[0].CheckedRows("check") <= 0 ) {
//				ComShowCodeMessage("BKG00249");
//	 		}	 
//	         var sRowStr=FindCheckedRow("check"); 
//	         //alert(sRowStr);
//	         var arr=sRowStr.split("|"); 
//	         for (var i=0; i<arr.length; i++) {
//	        	 SetRowStatus(arr[i],"D");
//	             SetRowHidden(arr[i],"1");
//	         }
//	     }         
//	 }
	/**
	 * connected with ESM_BKG_2005_SEQ popup screen
	 */  
	 function popupId(row) {
	     with (sheetObjects[0]) {
	    	 	var num=row;
				var idx=sheetObjects[0].GetCellValue(num, "hrd_cdg_id");
				var idx1=sheetObjects[0].GetCellValue(num, "attr_nm1");
				var idx2=sheetObjects[0].GetCellValue(num, "attr_nm2");
				var idx3=sheetObjects[0].GetCellValue(num, "attr_nm3");
				var idx4=sheetObjects[0].GetCellValue(num, "attr_nm4");
				var idx5=sheetObjects[0].GetCellValue(num, "attr_nm5");
				var idx6=sheetObjects[0].GetCellValue(num, "attr_nm6");
				var idx7=sheetObjects[0].GetCellValue(num, "attr_nm7");
				var idx8=sheetObjects[0].GetCellValue(num, "attr_nm8");
				var idx9=sheetObjects[0].GetCellValue(num, "attr_nm9");
				var idx10=sheetObjects[0].GetCellValue(num, "attr_nm10");
	        	var sUrl="/opuscntr/ESM_BKG_2005_01.do?hrd_cdg_id="+idx+"&attr_nm1="+idx1+"&attr_nm2="+idx2+"&attr_nm3="+idx3+"&attr_nm4="+idx4+"&attr_nm5="+idx5+"&attr_nm6="+idx6+"&attr_nm7="+idx7+"&attr_nm8="+idx8+"&attr_nm9="+idx9+"&attr_nm10="+idx10;
	        	ComOpenPopup(sUrl, 835, 640, "", "0,0", true);
	     }         
	 }
	/**
	 * vaidation check in sheet1 and call  popupId function
	 */  	 
	 function sheet1_OnDblClick(sheetObj, row, col){
		 if(sheetObj.GetCellValue(row, 3) == ''){
			ComShowCodeMessage("BKG01129");//Please save first.
			sheetObj.SelectCell(row, 'hrd_cdg_id', true, '');
			sheetObj.hrd_cdg_id.focus();				
			return false;
	  	    	}
		 if(sheetObj.GetCellValue(row,"ibflag") == 'I'){
 			ComShowCodeMessage("BKG01129");//Please save first.
	    		return false;
		 }
	  		popupId(row);
	 }
