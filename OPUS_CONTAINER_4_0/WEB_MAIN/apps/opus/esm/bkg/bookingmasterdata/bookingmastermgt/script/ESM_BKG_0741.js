/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_0741.js
*@FileTitle  : booking master data
*@author     : CLT
*@version    : 1.0
*@since      : 29/04/2014
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * business script for esm_bkg_0741
	 */
    
 // global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var maxCtrl=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 /**
	 * registering IBSheet Object as list adding process for list in case of
	 * needing batch processing with other items defining list on the top of
	 * source
	 * 
	 * @param sheet_obj
	 *            IBSheet Object
	 */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
		 * initializing sheet implementing onLoad event handler in body tag
		 * adding first-served functions after loading screen.
		 */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }           
           document.getElementById('office_0').style.display='block';
			document.form.cho_ofc_0[0].checked=true;  	   			
//			for (var i=0 ; i < 30 ; i++){
//				sheetObjects[0].SetColHidden(10+i,1);
//			}
//			sheetObjects[0].RenderSheet(1);
			// setting Height
			sheetObjects[0].SetSheetHeight(300);
		// setting Weight
			// sheetObjects[0].SheetWidth=mainTable.clientWidth;
			sheetObjects[0].SetVisible(1);
			
			if (document.getElementById("btn_celladd")) {
				ComBtnEnable("btn_celladd");
			}
			// ComBtnEnable("btn_celladd");
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			document.form.ofc_cd_0.focus();  
			initControl();
     }
     /**
		 * init control
		 */
      function initControl() {
      	var formObject=document.form;
      	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject);
      	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject);
      }
     /**
		 * setting sheet initial values and header param : sheetObj, sheetNo
		 * adding case as numbers of counting sheets
		 * 
		 * @param sheetObj
		 *            sheet Object
		 * @param sheetNo
		 */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 				var sheetID=sheetObj.id;
 				switch(sheetID) {
 					case "sheet1":
 					    with(sheetObj){
 				      var HeadTitle1="|Sel.|Seq.|H.OFC|GSO|Region|S/I Notification|BKG Notification|chk_op|Controlled OFC";
 				      for (var i=0 ; i < 30 ; i++){
 				      HeadTitle1 += "|Controlled OFC";
 				      }
 				      var headCount=ComCountHeadTitle(HeadTitle1);

 				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

 				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
 				      InitHeaders(headers, info);

 				      var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
 				             {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Del",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"hndl_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"gso_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"si_ntfc_eml",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"bkg_ntfc_eml",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chk_op" },
 				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1} ];
 				            for (var i = 0 ; i < 30 ; i++){
 				            	cols.push({Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_ofc_cd_"+i, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
 				            	//InitDataValid(0, 	9+i, vtEngUpOther,"");
 				      }
 				      InitColumns(cols);
 				      SetEditable(1);
 				      SetSheetHeight(300);
 				      
 				      }
					break;
 			}
 	}
   // Event handler processing by button name */
      function processButtonClick(){
           /** *** using extra sheet valuable if there are more 2 sheets **** */
  		         var sheetObject1=sheetObjects[0];
           /** **************************************************** */
           var formObject=document.form;
      	try {
      		var srcName=ComGetEvent("name");
      		 if(ComGetBtnDisable(srcName)) return false;
  					switch(srcName) {
  						case "btn_retrieve":
  							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  						break;
  						case "btn_save":
  							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
  						break;
  						case "btn_close":
  							ComClosePopup(); 
  						break;
  						case "btn_delete":
  							doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
  						break;
  						case "btn_add":
  							 addRow();
  						break;
  						case "btn_DownExcel":
  							if(sheetObjects[0].RowCount() < 1){//no data
  								ComShowCodeMessage("COM132501");
  							}else{
  								sheetObjects[0].Down2Excel({ HiddenColumn:-1});
  							}
  							
  						break;
  						case "btn_celladd":
  							addCell();
  						break;
              } // end switch
      	}catch(e) {
//      		if( e == "[object Error]") {
//      			ComShowMessage(OBJECT_ERROR);
//      		} else {
//      			ComShowMessage(e);
//      		}
      	}
      }  
      /**
		 * Sheet process handling
		 * 
		 * @param sheetObj
		 * @param formObj
		 * @param sAction
		 * @return
		 */
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
         switch(sAction) {
				case IBSEARCH:      // Retrieve
					if(!validateForm(sheetObj,formObj,sAction)) return; 						 					
					formObj.f_cmd.value=SEARCH; 
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					searchXml=sheetObj.GetSearchData("ESM_BKG_0741GS.do" , FormQueryString(formObj));
					maxCtrl=ComGetEtcData(searchXml,"maxCtrl");
					sheetObjects[0].RenderSheet(0);
					sheetObjects[0].RenderSheet(1);
					sheetObjects[0].LoadSearchData(searchXml);
					for (var i=0 ; i < 30 ; i++){
						if(i < maxCtrl){
							sheetObjects[0].SetColHidden(10+i,0);
						}else{
							sheetObjects[0].SetColHidden(10+i,1);
						}
						
					} 	
				break;
				case IBSAVE:        // Save
					sheetObj=sheetObjects[0];
					for (var i=1 ; i < sheetObj.RowCount()+1 ; i++){
						sheetObj.SetCellValue(i,"chk_op",'B:0',0);
						if( sheetObj.GetCellValue(i,"hndl_ofc_cd")==""){
  							ComShowCodeMessage("BKG00404","H.OFC", "H.OFC");
  							// ComShowCodeMessage('BKG03056',"B.OFC: " +
							// bkg_ofc_cd + ", POR: " + por_cd);
  						  return false;
  						}
						if (sheetObj.GetCellValue(i,0) == "I" || sheetObj.GetCellValue(i,0) == "U"){
							var ofc = "";
							for (var j=0 ; j < 30 ; j++){
								if (sheetObj.GetCellValue(i,10+j) != ''){
									if(ofc == ""){
										ofc = sheetObj.GetCellValue(i,10+j);
									} else {
										ofc = ofc + ":" + sheetObj.GetCellValue(i,10+j);
									}
								}
							}
							sheetObj.SetCellValue(i,'ctrl_ofc_cd',ofc,0);
						}
					} 
					
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI; 
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("");
	                sheetObj.DoSave("ESM_BKG_0741GS.do", sParam);
				break;
				case IBDELETE:      // Delete
					ComRowHideDelete(sheetObj, "Del");
				break;
         }
         ComOpenWait(false);
     }

     /**
		 * handling process for input validation
		 * 
		 * @param sheetObj
		 *            sheet Object
		 * @param formObj
		 *            form Object
		 * @param sAction
		 */
     function validateForm(sheetObj,formObj,sAction){
    	// if (!ComChkValid(formObj)) return false;
 			if (formObj.cho_ofc_0[0].checked == true){
 				formObj.chk_op.value='B:0'; 
 			}else if (formObj.cho_ofc_0[1].checked == true){
 				formObj.chk_op.value='B:1'; 
 			}else if (formObj.cho_ofc_0[2].checked == true){
 				formObj.chk_op.value='B:2'; 
 			}else if (formObj.cho_ofc_0[3].checked == true){
 				formObj.chk_op.value='B:3'; 
 			}
 			formObj.ofc_cd.value=formObj.ofc_cd_0.value; 	
         return true;
     }

	function sheet1_OnSearchEnd(code, message) {
		sheetObjects[0].RenderSheet(0);
		for (var i=1 ; i < sheetObjects[0].RowCount()+1 ; i++){
			var tempCtrl=sheetObjects[0].GetCellValue(i,'ctrl_ofc_cd').split(",");
			for (var j=0 ; j <tempCtrl.length ; j++){
				sheetObjects[0].SetCellValue(i,'ctrl_ofc_cd_' + j,tempCtrl[j],0);
			}
		}	
		sheetObjects[0].RenderSheet(1);
	}

     
      /**
		 * sheet2 change handling
		 * 
		 * @param sheetObj
		 * @param Row
		 * @param Col
		 * @param Value
		 * @return
		 */
      function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	  with (sheetObj) {
     		 var formObj=document.form;
       		 if (Col != 0 && Col != 1 && Col != 2 && Col != 6 && Col != 7){
       			 formObj.ofc_cd.value=GetCellValue(Row,Col);
       			 if (formObj.ofc_cd.value != ''){
	       			 formObj.ofc_ty.value=Col;
	       			 formObj.f_cmd.value=SEARCH01; 
	       			 var sParam=FormQueryString(formObj);
	       			 var sXml=sheetObj.GetSaveData("ESM_BKG_0741GS.do", sParam);
	         	     if (ComGetEtcData(sXml,"check") == "N"){
	         	    	ComShowCodeMessage("BKG01107");
	         	    	 SelectCell(Row, Col, true, '');
	  		         }else{
	  		        	 if (Col != 3 && Col != 4 && Col != 5){
	  		        		 for (var i=0 ; i < 30 ; i++){
	  		        			 if (Col != 9+i){
	  		        				 if (GetCellValue(Row,Col) == GetCellValue(Row,9+i)){
		  		        				 // alert("Exist Control Office CD");
		  		        				 ComShowCodeMessage("BKG04024");// Same
																		// part
																		// code
																		// exist.
		  		        				 SelectCell(Row, Col, true, '');
		  		        				 break;
		  		        			 }
	  		        			 }
	  		        		 }
	  		        	 }else if (Col == 3){
	  		        		if (ComGetEtcData(sXml,"chkHOFC") == "N"){
	  		        			ComShowCodeMessage("BKG04024");// Office
																// already exist
 		        				SelectCell(Row, Col, true, '');
	  		        		}
	  		        	 }
	  		         }
       			 }
       		 }
       	 }
      }  
     /**
		 * add row
		 */
     function addRow(){
    		 sheetObjects[0].DataInsert(-1);
    		 sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(), 3, true, '');
    	// }
     }
     /**
		 * add Cell
		 */    
     function addCell(){    	     	
         maxCtrl++;	
	  	 sheetObjects[0].RenderSheet(0);
		 sheetObjects[0].SetColHidden(9+maxCtrl,0);
		 sheetObjects[0].RenderSheet(1);
		 sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(), 9+maxCtrl, true, '');
     }
