/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0090.js
*@FileTitle  : Special Stowage Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // global variable

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var retFlag="";
 var messageFlg="";
 
 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          var sheetObject3=sheetObjects[2];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_Ok":
 					setPopupToParent(sheetObject, formObject);
                    break;
 				case "btn_Close":
 					//setPopupToParent(sheetObject, formObject);
                    ComClosePopup(); 
                    break;
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject2,formObject,SEARCH01);
 					doActionIBSheet(sheetObject,formObject,IBSEARCH);
 					htmlSheetSync();
                    break;
 				case "btn_Save":
					//  Blocking when saving after BDR 
					if (formObject.corr_no.value == "" && formObject.bdr_flg.value == "Y") {
						ComShowMessage(ComGetMsg("BKG00004"));
						return;
					}
					ComOpenWait(true); //add to show processing image
					setTimeout( function () {
						messageFlg="save";
	 					retFlag="";
	 					doActionIBSheet(sheetObject3,formObject,MULTI);
	 					if (retFlag == "Y") {
		 					doActionIBSheet(sheetObject2,formObject,SEARCH01);
		 					doActionIBSheet(sheetObject,formObject,IBSEARCH);
		 					htmlSheetSync();
	 					}
	 					ComOpenWait(false);
				    } , 100);
                    break;
 				case "btn_Request":
					//  Blocking when saving after BDR 
					if (formObject.corr_no.value == "" && formObject.bdr_flg.value == "Y") {
						ComShowMessage(ComGetMsg("BKG00004"));
						return;
					}
					if (formObject.bdr_flg.value == "Y" && formObject.corr_no.value != "") {
						ComShowMessage(ComGetMsg("BKG08076"));
						return;
					}

					ComOpenWait(true); //add to show processing image
					setTimeout( function () {
						messageFlg="request";
	 					retFlag="";
	 					doActionIBSheet(sheetObject3,formObject,MULTI);
	 					if (retFlag == "Y") {
	 	 					retFlag="";
		 					formObject.rqst_apro_cd.value="R";
		 					doActionIBSheet(sheetObject3,formObject,COMMAND01);
		 					if (retFlag == "Y") {
			 					doActionIBSheet(sheetObject2,formObject,SEARCH01);
			 					doActionIBSheet(sheetObject,formObject,IBSEARCH);
		 		 				htmlSheetSync();
		 					}
	 					}
	 					ComOpenWait(false);
				    } , 100);
                    break;
 				case "btn_CancelReq":
					//  Blocking when saving after BDR 
					if (formObject.corr_no.value == "" && formObject.bdr_flg.value == "Y") {
						ComShowMessage(ComGetMsg("BKG00004"));
						return;
					}
					if (formObject.bdr_flg.value == "Y" && formObject.corr_no.value != "") {
						ComShowMessage(ComGetMsg("BKG08076"));
						return;
					}
					messageFlg="cancelReq";
// 					if (ComShowConfirm(ComGetMsg("BKG00670", 1))) {
 					if (ComShowConfirm(ComGetMsg("BKG00670"))) {
 						ComOpenWait(true); //add to show processing image
 						setTimeout( function () {
	 	 					retFlag="";
		 					formObject.rqst_apro_cd.value="C";
		 					doActionIBSheet(sheetObject3,formObject,COMMAND02);
		 					if (retFlag == "Y") {
			 					doActionIBSheet(sheetObject2,formObject,SEARCH01);
			 					doActionIBSheet(sheetObject,formObject,IBSEARCH);
		 						htmlSheetSync();
		 					}
		 					ComOpenWait(false);
 					    } , 100);
 					} else {
						return;
					}
                    break;

            	// approval inquiry pop-up...
 				case "btn_approval":
 					if (document.getElementById("bkg_no").value != "" ) {
 						//ComOpenPopup("VOP_SCG_1016.do?scg_flg=ST&bkg_no=" + formObject.bkg_no.value, 1100, 550, "", '0,0', true);
 						ComOpenPopup("VOP_SCG_1019.do?scg_flg=SS&bkg_no=" + formObject.bkg_no.value, 950, 550, "", '0,0', true);
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
       * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         } 		
    	 if (opener){ 
    		 document.form.bkg_no.value = opener.form.bkg_no.value;
    	 }
    	 else if (parent){ 
    		 document.form.bkg_no.value =parent.form.bkg_no.value;
    	 }
         
    	 //get booking information
         doActionIBSheet(sheetObjects[1],document.form,SEARCH01);

         //get stowage code 
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         
         htmlSheetSync();

    	 // getting script to show input value in Main
//    	 if (opener) document.form.stwg_rmk.value =opener.form.stwg_rmk.value;
//    	 else if (parent) document.form.stwg_rmk.value =parent.form.stwg_rmk.value;

    	 
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
                    var HeadTitle="|Sel.|Type|Detail";
                    
                    SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"val",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"name",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
                }
                 break;
         
             case 2:      //t1sheet2 init
                 with(sheetObj){
					var HeadTitle="|TP/SZ|Vol.";
					
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
					             {Type:"Float",     Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 }
					           ];
					
		            InitColumns(cols);
                    SetEditable(0);	
					SetCountPosition(0);
					SetSheetWidth(280);
					SetWaitImageVisible(0);
					SetSheetHeight(ComGetSheetHeight(sheetObj, 7));                 
             	}
                break;

             case 3:      //t1sheet2 init
                 with(sheetObj){
					var HeadTitle="|RQST_USR_ID|RQST_DT|RQST_GDT|SPCL_CGO_APRO_CD|STWG_CD|STWG_RMK";
					
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"rqst_usr_id",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"rqst_gdt",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"stwg_cd", 	   		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"stwg_rmk",    		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   }
					           ];
					
		            InitColumns(cols);
                    SetEditable(0);	
                    sheetObj.SetVisible(0);                
             	}
                break;                

             case 4:      //t1sheet2 init
                 with(sheetObj){
					var HeadTitle="|POR_CD|DEL_CD|RCV_TERM_CD|DE_TERM_CD|BDR_FLG|CORR_NO";
					
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",  		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",  		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",  	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",  	KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"bdr_flg",		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0,   },
					             {Type:"Text",      Hidden:0, Width:130,   Align:"Center",  ColMerge:0,   SaveName:"corr_no",  		KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0,   }
					           ];
					
		            InitColumns(cols);
                    SetEditable(0);	
                    sheetObj.SetVisible(0);                
             	}
                break;     
         }
     }
   // handling of Sheet 
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //search
            	formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_BKG_0090GS.do", FormQueryString(formObj) );
            break;

            case SEARCH01:      //container & stowage information search
            	formObj.f_cmd.value=SEARCH01;
    			var resultXml=sheetObj.GetSearchData("ESM_BKG_0090GS.do", FormQueryString(formObj));
    			var arrXml=resultXml.split("|$$|");

    			sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} ); //Container Information
    			sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} ); //Stowage Information
    			sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} ); //Booking Information
    			
    			if(sheetObjects[2].GetTotalRows()!= 0){
        			document.getElementById("rqst_usr_id").value=sheetObjects[2].GetCellValue(1, "rqst_usr_id");
        			document.getElementById("rqst_dt").value=sheetObjects[2].GetCellValue(1, "rqst_dt");
        			document.getElementById("rqst_gdt").value=sheetObjects[2].GetCellValue(1, "rqst_gdt");
        			document.getElementById("stwg_cd").value=sheetObjects[2].GetCellValue(1, "stwg_cd");
        			document.getElementById("stwg_rmk").value=sheetObjects[2].GetCellValue(1, "stwg_rmk");
        			document.getElementById("spcl_cgo_apro_cd").value=sheetObjects[2].GetCellValue(1, "spcl_cgo_apro_cd");
        			document.getElementById("saved_stwg_cd").value=sheetObjects[2].GetCellValue(1, "stwg_cd");
        			document.getElementById("saved_stwg_rmk").value=sheetObjects[2].GetCellValue(1, "stwg_rmk");
        			
    			}else{
        			document.getElementById("rqst_usr_id").value="";
        			document.getElementById("rqst_dt").value="";
        			document.getElementById("rqst_gdt").value="";
        			document.getElementById("stwg_cd").value="";
        			document.getElementById("stwg_rmk").value="";
        			document.getElementById("spcl_cgo_apro_cd").value="";  
        			document.getElementById("saved_stwg_cd").value="";
        			document.getElementById("saved_stwg_rmk").value="";  				
    			}

    			if(sheetObjects[3].GetTotalRows()!= 0){
    				document.form.por_cd.value=sheetObjects[3].GetCellValue(1, "por_cd");
    				document.form.del_cd.value=sheetObjects[3].GetCellValue(1, "del_cd");
    				document.form.rcv_term_cd.value=sheetObjects[3].GetCellValue(1, "rcv_term_cd");
    				document.form.de_term_cd.value=sheetObjects[3].GetCellValue(1, "de_term_cd");
    				document.form.bdr_flg.value=sheetObjects[3].GetCellValue(1, "bdr_flg");
    				document.form.corr_no.value=sheetObjects[3].GetCellValue(1, "corr_no");
    			}
    			
            	break;
            
            case MULTI://save
            	if (validateForm(sheetObj,formObj,sAction)){
	            	formObj.f_cmd.value=MULTI;
	            	var sParam=FormQueryString(formObj);
	            	var rXml=sheetObj.GetSaveData("ESM_BKG_0090GS.do", sParam);

	        		var State=ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
	        		var rMsg=ComResultMessage(rXml);
	        		if (State == "S") {
	        			if(messageFlg == "save"){
	        				ComShowMessage(ComGetMsg("BKG00166"));
	        			}
	        			// After saving completed normally, screen viewed again in case
	        			// retFlag is 'Y'.
	        			retFlag="Y";
	        		}else{
	            		ComShowMessage(rMsg);
	            	}
            	}
            break;
            
            case COMMAND01:// request
        		formObj.button.value="N";
            	if (validateForm(sheetObj,formObj,sAction)){
	            	formObj.f_cmd.value=COMMAND01;
	            	var sParam=FormQueryString(formObj);
	            	var rXml=sheetObj.GetSaveData("ESM_BKG_0090GS.do", sParam);
	            	var rMsg=ComResultMessage(rXml);
	            	if (rMsg == ''){
	            		ComShowMessage(ComGetMsg("BKG08102"));
	        			retFlag="Y";
	            	}else{
	            		ComShowMessage(rMsg);
	            	}
            	}
            break;

            case COMMAND02:// request cancel
        		formObj.button.value="Y";
            	if (validateForm(sheetObj,formObj,sAction)){
	            	formObj.f_cmd.value=COMMAND01;
	            	var sParam=FormQueryString(formObj);
	            	var rXml=sheetObj.GetSaveData("ESM_BKG_0090GS.do", sParam);
	            	var rMsg=ComResultMessage(rXml);
	            	if (rMsg == ''){
	            		ComShowMessage(ComGetMsg("BKG08103"));
	        			retFlag="Y";
	            	}else{
	            		ComShowMessage(rMsg);
	            	}
            	}
            break;

         }
     }

     function setPopupToParent(sheetObject, formObj){
    	var stwgRmk=formObj.stwg_rmk.value;
//    	var stwgRmk=formObj.saved_stwg_rmk.value;
    	var stwgCd="";
     	for (var i=sheetObject.HeaderRows(); i<=sheetObject.LastRow(); i++) {
            if(sheetObject.GetCellValue(i,"chk") == 1){
                stwgCd=sheetObject.GetCellValue(i,"val");
     			break;
     		}
 	    }
//    	var stwgCd=formObj.saved_stwg_cd.value;
		var calllFunc=formObj.calllFunc.value;
		if(calllFunc != ''){
			if (ComFuncCheck("opener." + calllFunc)) ComFunc(new Array(stwgCd, stwgRmk));
			else if (ComFuncCheck("parent." + calllFunc)) ComFunc(new Array(stwgCd, stwgRmk));
		}         	
        ComClosePopup(); 
     }
     // setting main information
     function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	 // setting StowageCode in Main 
    	var stwg_cd=ComTrimAll(document.form.stwg_cd.value);
    	if(stwg_cd.length > 0){
         	for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
                if(sheetObj.GetCellValue(i,"val") == stwg_cd){
         			sheetObj.SetCellValue(i,"chk",1);
         			break;
         		}
     	    } 		    		
    	}
     }
	/* End of developer's work */
     
 	/**
 	 * handling process for input validation
 	 */
 	function validateForm(sheetObj, formObj, sAction) {
 		with (formObj) {
 			stwg_cd.value = "";
 	     	for (var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
 	            if(sheetObjects[0].GetCellValue(i,"chk") == 1){
 	            	stwg_cd.value=sheetObjects[0].GetCellValue(i,"val");
 	     			break;
 	     		}
 	 	    }
 	     	
 	     	if(messageFlg == "request" && stwg_cd.value == ""){
 	     		 ComShowCodeMessage("BKG95031", "Stowage Type");
 	     		 return false;
 	     	}
 			
 		}
 		return true;
 	}

 // Setting sheet data of clicked row in html in case sheet click.
 	function htmlSheetSync() {
 		var formObject=document.form;

 		if(formObject.bdr_flg.value=="Y"){
 			document.getElementById("btn_CancelReq").disabled = true;
 			document.getElementById("btn_Request").disabled = true;
 			document.getElementById("btn_Save").disabled = true;
 		}else{
	 		if(document.getElementById("spcl_cgo_apro_cd").value == "R" || document.getElementById("spcl_cgo_apro_cd").value == "Y"){
	 			document.getElementById("btn_CancelReq").disabled = false;
	 			document.getElementById("btn_Request").disabled = true;
	 			document.getElementById("btn_Save").disabled = true;
	 		} else{
	 			document.getElementById("btn_CancelReq").disabled = true;
	 			document.getElementById("btn_Request").disabled = false;
	 			document.getElementById("btn_Save").disabled = false;
	 		}
 		}
 	}