/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2011.jsp
*@FileTitle  : M.G.Set Off-Hire Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_2011 : ees_cgm_2011 business script for
     */
    function ees_cgm_2011() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* developer job	*/
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
             /***** use additional sheet var in case of more than 2 tap each sheet *****/
        	 var sheetObject1=sheetObjects[0];
        	 var sheetObject2=sheetObjects[1];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
                    case "New":
                    	sheetObject1.RemoveAll();
     					formObject.reset();
     					document.forms[0].sts_evnt_ofc_cd.value="";
     					document.forms[0].sts_evnt_yd_cd.value="";
     					document.forms[0].sts_evnt_dt.value="";
    					break;
                    case "Row_Add":
                    	doActionIBSheet(sheetObject1,formObject,IBINSERT);
    					break;
                    case "Delete":
                    	doActionIBSheet(sheetObject1,formObject,REMOVE);
    					break;
                    case "btn_verify":
                   	    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                        break;
                    case "Save":
                    	doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					break;
                    case "btn_loadexcel":
                      	//sheetObject1.SpeedDown2Excel();  
                     	doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
                         break
                    case "ComOpenPopupWithTargetYard":
             			//ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:sts_evnt_yd_cd", "1,0,1,1,1,1,1", true);
             			ComOpenPopup("/opuscntr/EES_LSE_0101.do", 800, 615, "setPopData_AvailYard", '1,0', true, false);//, Row, Col, 0);
             			
             			break;
                    case "ComOpenPopupWithTargetOffice":
             			ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do?pgmNo=COM_ENS_071', 800, 520, "ofc_cd:sts_evnt_ofc_cd", "1,0,1,1,1,1,1", true);
//             			Matched_Chk('Office');
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
         			ComShowMessage(OBJECT_ERROR);
         		} else {
         			ComShowMessage(e.message);
         		}
        	}
        }
        /**
         * New Yard Code Pop-up Return Value handling<br>
         * chungpa 20100415 new yard popup
         */
        function setPopData_AvailYard(aryPopupData, Row, Col, sheetIdx) {
        	var formObj=document.form;
        	if(aryPopupData.length > 0) {
        		formObj.sts_evnt_yd_cd.value=aryPopupData[0][4]; //Yard
        		Matched_Chk('Yard');
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
             		//
                 ComConfigSheet (sheetObjects[i] );
                 initSheet(sheetObjects[i],i+1);
             		//
                 ComEndConfigSheet(sheetObjects[i]);
             }
             sheet1_OnLoadFinish(sheet1);
         }
         /**
          * 
          * @param sheetObj
          * @return
          */
         function sheet1_OnLoadFinish(sheetObj) {
             sheetObj.SetWaitImageVisible(0);
             formObj=document.form;
             // axon event regist
//             axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
//             axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
//             axon_event.addListenerFormat('beforeactivate',	  'obj_activate',   formObj);
             axon_event.addListener('change', 'obj_change', 'sts_evnt_ofc_cd');
//             axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
             axon_event.addListenerForm 	 ('focusout', 'obj_focusout',   formObj);
             // reset
             initControl(sheetObjects[0]); 
             sheetObj.SetWaitImageVisible(1);
        }
          /**
           * init control of form <br>
           * @param  {object} sheetObj	
           * @return 
           * @author 
           * @version
           */
          function initControl(sheetObj){
          	// Form object
          	  formObj=document.form;
              // axon event regist
              //  focus
//              formObj.sts_evnt_ofc_cd.focus();
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
	                  var HeadTitle="|||Seq.|M.G.Set No.|Type|Lease Term|On-Hire Date|Agreement No.|Reference No.|Lessor|Verify Result|||";
	                  var headCount=ComCountHeadTitle(HeadTitle);
	
	                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                  InitHeaders(headers, info);
	
	                  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"onh_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"agreement",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",  ColMerge:0,   SaveName:"vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:0,   SaveName:"verify",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_ofc_cd" },
	                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_yd_cd" },
	                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_dt" } ];
	                   
	                  InitColumns(cols);
	                  SetEditable(1);
	                  SetColProperty(0 ,"eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
//	                  SetSheetHeight(380);
	                  resizeSheet()
                  }
                  break;
            }
        }
        function resizeSheet(){
            ComResizeSheet(sheetObjects[0]);
        }
      // handling process for Sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            switch(sAction) {
                 case IBSEARCH:      //retrieve
			 		 	var verifyFlag=false; 
			              var chkFlag=false;
					 	  formObj.f_cmd.value=SEARCHLIST;
//			              var sXm = sheetObj.DoSave("EES_CGM_1009GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
//			             var sXml = sheetObj.GetSearchXml("EES_CGM_1009GS.do");
			             queryString="f_cmd=" + SEARCHLIST ;
//			    		 var sXml = sheetObj.GetSearchXml ("EES_CGM_1009GS.do", queryString+"&"+params);
			    		 for(i=1; i<=sheetObj.RowCount(); i++){
			    			 var del_chk=sheetObj.GetCellValue(i, "del_chk");
								// 
								if(del_chk == "1"  ) {
									sheetObj.SetRowStatus(i,"U");
									//ComShowMessage(sheetObj.CellValue(i, "ibflag"));
									sheetObj.SetCellValue(i, "sts_evnt_dt",formObj.sts_evnt_dt.value);
									chkFlag=true;
								}
						 }
			    		 var params=sheetObj.GetSaveString(true);
					 	 if(sheetObj.RowCount()>0  && chkFlag)
					 	 {
					  		sheetObj.SetWaitImageVisible(0);
					 	    ComOpenWait(true);
					 	    sheetObj.DoSearch("EES_CGM_2011GS.do",  queryString+"&"+params );
						 	for(i=1; i<=sheetObj.RowCount(); i++){
						 		var verify=sheetObj.GetCellValue(i, "verify");
			 					// 
			 					if(verify != "OK"  ) {
			 						if(sheetObj.GetCellValue(i, "eq_no") == ""){
			 							sheetObj.SetCellValue(i, "del_chk","1");
			 						}else{
			 							verifyFlag=true;
			 						} 							
			 					}
							}
						 	ComOpenWait(false);
						 	if(verifyFlag )
			 			 	{
			 			 		ComShowCodeMessage("CGM10005", "Please check up the Verify Result.");
			 			 	}
			 		 	 }
			 		 	 else
			 		 	 {
			 		 		ComShowCodeMessage("CGM10008");
			 		 	 }
						 sheet_delete2(sheetObj);
			             break;
                    break;
    			 case IBSAVE:        //saving
    			 	var actionFlag=false; 
    			    var VerifyFlag=false;
    			 	// 
    					if(formObj.sts_evnt_ofc_cd.value == "" || formObj.sts_evnt_ofc_cd.value == null) {
    						ComShowCodeMessage("CGM10004", "Office");
    						return;
    					}
    					if(formObj.sts_evnt_yd_cd.value == "" || formObj.sts_evnt_yd_cd.value == null) {
    						ComShowCodeMessage("CGM10004", "Yard");
    						return;
    					}
    					var yard=formObj.sts_evnt_yd_cd.value;
    					if(yard.length != 7) {
    						ComShowCodeMessage('CGM10044','Yard(7)');
    						return;
    					}
    					if(formObj.sts_evnt_dt.value == "" || formObj.sts_evnt_dt.value == null) {
    						ComShowCodeMessage("CGM10004", "Off-Hire Date");
    						return;
    					}
    					for(i=1; i<=sheetObj.RowCount(); i++){
    						var verify=sheetObj.GetCellValue(i, "verify");
    						// 
    						if(verify == "OK" && sheetObj.GetCellValue(i, "del_chk")== "1" ) {
    							sheetObj.SetCellValue(i, "sts_evnt_ofc_cd",formObj.sts_evnt_ofc_cd.value);
    							sheetObj.SetCellValue(i, "sts_evnt_yd_cd",formObj.sts_evnt_yd_cd.value);
    							sheetObj.SetCellValue(i, "sts_evnt_dt",formObj.sts_evnt_dt.value);
//    							ComShowMessage(formObj.sts_evnt_ofc_cd.value);
//    							ComShowMessage(sheetObj.CellValue(i, "sts_evnt_ofc_cd"));
//    							sheetObj.CellValue(i, "ibflag")  = "U";
    							sheetObj.SetRowStatus(i,"U");
    							actionFlag=true; 
    						}
    						else if(verify == "" && sheetObj.GetCellValue(i, "del_chk")== "1" ) {
    							ComShowCodeMessage("CGM10004", "verify");
    							actionFlag=false; 
    							break;
    						}
    						else if(verify != "OK" && sheetObj.GetCellValue(i, "del_chk")== "1" ) {
    							VerifyFlag=true; 
    							break;
    						}
    						else
    						{
    							sheetObj.SetRowStatus(i,"R");
//    							sheetObj.CellValue(i, "ibflag")  = "";
    						}
    					}
    					if(VerifyFlag){
    				        	ComShowCodeMessage("CGM10005");
    				    }else if(actionFlag){
    						var params=sheetObj.GetSaveString(true);
    						formObj.f_cmd.value=MULTI;
    						queryString="f_cmd=" + MULTI ;
    						var params=sheetObj.GetSaveString(true);
//    						ComShowMessage(" params ... "+params);
    						sheetObj.SetWaitImageVisible(0);
					 	    ComOpenWait(true);
    						if(sheetObj.DoSave("EES_CGM_2011GS.do",queryString + "&" + ComGetPrefixParam("")))
    						{
//    							ComRowHideDelete(sheetObj,"del_chk");
    					 		sheet_delete(sheetObj);
    						}
    						 ComOpenWait(false);
//    						sheetObj.DoSave("EES_CGM_1009GS.do",queryString + "&" + params);
    					}
    					else
    					{
    						ComShowCodeMessage("CGM10008");
    					}
    		             break;
    			 case IBINSERT:      // inserting
    	 			sheetObj.DataInsert(-1);
    		        break;
    			 case REMOVE:	
//    		 		ComRowHideDelete(sheetObj,"del_chk");
    		 		sheet_delete(sheetObj);
    			    break;
    		 	 case IBLOADEXCEL:	// EXCEL UPLOAD
    	 			if (sheetObj.id == "sheet1") {
    	 				sheetObj.RemoveAll();
	 					sheetObj.LoadExcel();
    	 			}; 
    	 			break;
    		 	 case IBSEARCH_ASYNC02:	// Office Code  Validation check 
    			   	formObj.f_cmd.value=COMMAND01;
    			   	formObj.ofc_cd.value=formObj.sts_evnt_ofc_cd.value;
    			   	var sXml=sheetObj.GetSearchData("CgmValidationGS.do", FormQueryString(formObj));
    			   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
    			   	if(sCheckResult == COM_VALIDATION_FALSE){
    			   		ComShowCodeMessage('CGM10009','Office');
    			   		formObj.sts_evnt_ofc_cd.value="";
//    			   		formObj.sts_evnt_ofc_cd.focus();
    			   	} else {
    			   		Matched_Chk('Office');
    			   	}
    			   	break;
    		 	 case IBSEARCH_ASYNC03:	// Office Code  Validation check 
    			   	formObj.f_cmd.value=COMMAND01;
    			   	formObj.yd_cd.value=formObj.sts_evnt_yd_cd.value;
    			   	var sXml=sheetObj.GetSearchData("Check_YardGS.do", FormQueryString(formObj));
    			   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
    			   	if(sCheckResult == COM_VALIDATION_FALSE){
    			   		ComShowCodeMessage('CGM10009','Yard');
    			   		formObj.sts_evnt_yd_cd.value="";
//    			   		formObj.sts_evnt_yd_cd.focus();
    			   	} else {
    			   		Matched_Chk('Yard');
    			   	}
    			   	break;
            }
        }
         /**
          * sheet deleting 
          * @param sheetObj
          * @return
          */
          function sheet_delete(sheetObj)
          {
        	  for(i=sheetObj.RowCount(); i>0; i--){
        		  if(sheetObj.GetCellValue(i, "ibflag") != "" &&  sheetObj.GetCellValue(i, "del_chk")=="1") {
      				sheetObj.RowDelete(i, false);
      			}
      		 }
          }
          /**
           * sheet deleting 
           * @param sheetObj
           * @return
           */
          function sheet_delete2(sheetObj)
          {
        	  for(i=sheetObj.RowCount(); i>0; i--){
        		  if(sheetObj.GetCellValue(i, "ibflag") != ""   && sheetObj.GetCellValue(i, "eq_no")== "") {
      				sheetObj.RowDelete(i, false);
      			}
      		 }
          }
      	function showCalendar(){
          	var form=document.form;
          	var cal=new ComCalendar();
              //cal.setDisplayType('month');
          	cal.setEndFunction("processEndCal"); 
            cal.select(form.sts_evnt_dt, "yyyy-MM-dd");
        }
         function processEndCal(){
        	 var form=document.form;
        	 var dt=ComReplaceStr(form.form_day.value,"-","");
        	 var dt2=ComReplaceStr(form.sts_evnt_dt.value,"-","");
             if(dt2 > dt){
            	 form.sts_evnt_dt.value="";
//            	 form.sts_evnt_dt.focus();
            	 ComShowCodeMessage('CGM10069');
            	 return ;
     	    }  else {
     	    	var sheetObj=sheetObjects[0];
    				// chassis no check
    				for(jj=1; jj<sheetObj.RowCount()+1; jj++){
    					sheetObj.SetCellValue(jj, "verify","");
    				}
     	    }
         }
      	function sheet1_OnChange(sheetObj, Row, Col){
      		var sheetObj=sheetObjects[0];
      	 	var formObj=document.form;
      	 	var prefix="";
      	 	var chk=true;
//      	 	var Dupchk   = false;
      	 	var eqNoCol=sheetObj.SaveNameCol( "eq_no");
     	 	if (Col == eqNoCol && Row !=0) {
     	 		var cellValue=sheetObj.GetCellValue(Row, Col); 
     	 		if (cellValue != ''){
     	 		    // Form parameter  value setting
 	 				if(Row >1)
 	 				{
 	 					// chassis no check
 	 					for(i=1; i<sheetObj.RowCount(); i++){
 	 						if(sheetObj.GetCellValue(i, "eq_no")== cellValue && Row != i )
 		 					{
 		 						chk=false;
 		 					}
 		 				}
 	 					if(chk == true)
 	 					{
 	 						OnChack(sheetObj, Row, Col,cellValue);
 	 					}
 	 					else
 	 					{
 	 						//ComShowMessage('Please check up the Duplicated Chassis No.');
 	 			        	ComShowCodeMessage("CGM10017"," Chassis No.");
 	 			        	// Setting Cell value to Null
 	 						sheet_row_clear(sheetObj, Row, Col);
 	 					}
 	 				}
 	 				else
 	 				{
 	 					OnChack(sheetObj, Row, Col,cellValue);
 	 				}
     	 		} else {
     	 		    // Setting Cell value to Null
     	 			sheet_row_clear(sheetObj, Row, Col);
     	 		}
     	 	}
      	}
      	function OnChack(sheetObj, Row, Col,cellValue){
      		var sheetObj=sheetObjects[0];
      	 	var formObj=document.form;
      		formObj.f_cmd.value=SEARCH;
     		formObj.eq_no.value=cellValue;
     		var sXml=sheetObj.GetSearchData("EES_CGM_2011GS.do", FormQueryString(formObj));
             if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
     			// check message out
             	//ComShowMessage('CGM20007');
             	ComShowCodeMessage("CGM10004", "Chassis No");
             	// Setting Cell value to Null
             	sheet_row_clear(sheetObj, Row, Col);
     		}
             else
             {
             	sheetObj.SetCellValue(Row, "eq_tpsz_cd", DomXml2String(sXml, "eq_tpsz_cd"));
             	sheetObj.SetCellValue(Row, "agmt_lstm_cd", DomXml2String(sXml, "agmt_lstm_cd"));
             	sheetObj.SetCellValue(Row, "onh_dt", DomXml2String(sXml, "onh_dt"));
         		sheetObj.SetCellValue(Row, "agreement", DomXml2String(sXml, "agreement"));
         		sheetObj.SetCellValue(Row, "agmt_ref_no", DomXml2String(sXml, "agmt_ref_no"));
         		sheetObj.SetCellValue(Row, "vndr_seq", DomXml2String(sXml, "vndr_seq"));
         		sheetObj.SetCellValue(Row, "vndr_nm", DomXml2String(sXml, "vndr_nm"));
         		sheetObj.SetCellValue(Row, "verify", '');
             }
      	}
     	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
    		if(isExceedMaxRow(msg))return;
    		
     	// chassis no check
    		for(iChk=1; iChk<sheetObj.RowCount()+1; iChk++){
    			var cellValue=sheetObj.cellValue(iChk, "eq_no"); 
    			if (cellValue != ''){
    				formObj.f_cmd.value=SEARCH;
    		 		formObj.eq_no.value=cellValue;
    		 		//alert(Row);
    		 		var sXml=sheetObj.GetSearchData("EES_CGM_2011GS.do", FormQueryString(formObj));
    		         if(DomXml2String(sXml, "eq_no") == null || DomXml2String(sXml, "eq_no") == "") {
    		          	// Setting Cell value to Null
	    		          	sheetObj.SetCellValue(iChk, "eq_tpsz_cd", '');
	    		          	sheetObj.SetCellValue(iChk, "agmt_lstm_cd", '');
	    		          	sheetObj.SetCellValue(iChk, "onh_dt", '');
	    		      		sheetObj.SetCellValue(iChk, "agreement", '');
	    		      		sheetObj.SetCellValue(iChk, "agmt_ref_no", '');
	    		      		sheetObj.SetCellValue(iChk, "vndr_seq", '');
	    		      		sheetObj.SetCellValue(iChk, "vndr_nm", '');
	    		      		sheetObj.SetCellValue(iChk, "verify", '');
    		  		  } else {
    		        	  sheetObj.SetCellValue(iChk, "eq_tpsz_cd", DomXml2String(sXml, "eq_tpsz_cd"));
		             	  sheetObj.SetCellValue(iChk, "agmt_lstm_cd", DomXml2String(sXml, "agmt_lstm_cd"));
		             	  sheetObj.SetCellValue(iChk, "onh_dt", DomXml2String(sXml, "onh_dt"));
		         		  sheetObj.SetCellValue(iChk, "agreement", DomXml2String(sXml, "agreement"));
		         		  sheetObj.SetCellValue(iChk, "agmt_ref_no", DomXml2String(sXml, "agmt_ref_no"));
		         		  sheetObj.SetCellValue(iChk, "vndr_seq", DomXml2String(sXml, "vndr_seq"));
		         		  sheetObj.SetCellValue(iChk, "vndr_nm", DomXml2String(sXml, "vndr_nm"));
		         		  sheetObj.SetCellValue(iChk, "verify", '');
    		          }
    			}
    		}
     	}
       	 /**
       	  * Setting Cell value to Null
       	  * @param sheetObj
       	  * @param Row
       	  * @param Col
       	  * @return
       	  */
       	function sheet_row_clear(sheetObj, Row, Col)
       	{
         	// Setting Cell value to Null 
     		sheetObj.SetCellValue(Row, Col, '');
     		sheetObj.SetCellValue(Row,  "eq_tpsz_cd", '');
     		sheetObj.SetCellValue(Row,  "agmt_lstm_cd", '');
     		sheetObj.SetCellValue(Row,  "onh_dt", '');
     		sheetObj.SetCellValue(Row,  "agreement", '');
     		sheetObj.SetCellValue(Row,  "agmt_ref_no", '');
     		sheetObj.SetCellValue(Row,  "vndr_seq", '');
     		sheetObj.SetCellValue(Row,  "vndr_nm", '');
     		sheetObj.SetCellValue(Row,  "verify", '');
     		// focus to grid
     		sheetObj.SelectCell(Row, Col, true);
       	}
       	/** 
           * Object Keypress event handling  <br>
           * 
           * @param  
           * @return 
           * @author 
           * @version
           */ 
          function obj_keypress(){
         	 obj=ComGetEvent();
         	 if(obj.dataformat == null) return;
         	 window.defaultStatus=obj.dataformat;
         	 switch(obj.dataformat) {
         	 	case "ymd":
         	 		ComKeyOnlyNumber(obj);
         	        break;
         	    case "eng":
         	    	if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum')
         	        else ComKeyOnlyAlphabet('upper');
         	        break;
         	    case "engup":
         	        if(obj.name=="sts_evnt_ofc_cd") ComKeyOnlyAlphabet('uppernum')
         	        else ComKeyOnlyAlphabet('upper');
         	        break;
         	    case "engdn":
         	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
         	        else ComKeyOnlyAlphabet('lower');
         	        break;
         	 }
          }
          /** 
           * Object deactivate event handling  <br>
           * @param  
           * @return 
           * @author 
           * @version
           */
          function obj_deactivate(){
         	 var formObj=document.form;
         	 obj=ComGetEvent();
         	 if(obj.name=="sts_evnt_dt"  ){
         		 with(formObj){
         			 var creDtFr=ComReplaceStr(sts_evnt_dt.value,"-","");
     	        }
     	        ComChkObjValid(ComGetEvent());
             }
         }
        /** 
         * Object change event handling  <br>
         * @param  
         * @return 
         * @author 
         * @version
         */  
        function obj_change(){
        	 var formObj=document.form;
        	 var sheetObj=sheetObjects[0];
//        	 obj=ComGetEvent();
        	 switch(ComGetEvent("name")){
        	 	case "sts_evnt_ofc_cd":
        	 		if(formObj.sts_evnt_ofc_cd.value != ''){
        	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
        	 			break;
        	 		}
//        	 	case "sts_evnt_yd_cd":
//        	 		if(formObj.sts_evnt_yd_cd.value != ''){
//        	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
//        	 			break;
//        	 		} 
        	 }
        }
         /**
          * YA_CD value check
          * @return
          */
         function obj_keyup(){
    	    	 var formObj=document.form;
    	    	 var sheetObj=sheetObjects[0];
    	    	 obj=ComGetEvent();
    	    	 switch(ComGetEvent("name")){
    	    	 	case "sts_evnt_yd_cd":
        		    ComKeyEnter('lengthnextfocus');
        		    /*
    	    	    var sts_evnt_yd_cd;
        	    	sts_evnt_yd_cd=formObj.sts_evnt_yd_cd.value;
        	    	if (sts_evnt_yd_cd.length == 7) {
        	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
        	    	}
        	    	*/
        	    	break;
    	    	 }
    	    }
      /**
       * AXON event handling
       */
      function obj_activate(){
          ComClearSeparator(ComGetEvent());
      }
       /**
        * yard and office check
        * @param chk
        * @return
        */
       function Matched_Chk(chk){
 		 formObj=document.form;
 		 var sheetObj=sheetObjects[0];
 		 if(formObj.sts_evnt_yd_cd.value != "" && formObj.sts_evnt_ofc_cd.value != "" ){
 			 formObj.f_cmd.value=SEARCH01;
 			    formObj.ofc_cd.value=formObj.sts_evnt_ofc_cd.value;		//   ( location)
 			    formObj.loc_cd.value=formObj.sts_evnt_yd_cd.value.substr(0,5);
 			    var sXml=sheetObj.GetSearchData("cgm_Check_LocationGS.do", FormQueryString(formObj));
 			    if(DomXml2String(sXml, "chk")!="OK"){
 					ComShowCodeMessage("CGM10028");
 					if(chk == 'Yard'){
 						formObj.sts_evnt_yd_cd.value="";
// 						formObj.sts_evnt_yd_cd.focus();
 					} else {
 						formObj.sts_evnt_ofc_cd.value="";
// 						formObj.sts_evnt_ofc_cd.focus();
 					}
 					return;
 			    }
 		 }
       }  
       // work javascript OnFocusOut event handling
       function obj_focusout() {
       	switch(ComGetEvent("name")){ 
       	case "sts_evnt_dt":
       		 var form=document.form;
 	    	 var dt=ComReplaceStr(form.form_day.value,"-","");
 	    	 var dt2=ComReplaceStr(form.sts_evnt_dt.value,"-","");;
 	         if(form.sts_evnt_dt.value!="" &&  dt2 > dt){
 	        	 form.sts_evnt_dt.value="";
// 	        	 form.sts_evnt_dt.focus();
 	        	 ComShowCodeMessage('CGM10069');
 	        	 return;
 	 	    }  else {
 	 	    	var sheetObj=sheetObjects[0];
 	 	 					// chassis no check
 				for(jj=1; jj<sheetObj.RowCount()+1; jj++){
 					sheetObj.SetCellValue(jj, "verify","");
  				}
 				return;			
 	 	    }
 	 		break;
	 	case "sts_evnt_yd_cd":
	 		var formObj=document.form;
	 		var sheetObj=sheetObjects[0];
    	    var sts_evnt_yd_cd;
    	    sts_evnt_yd_cd=formObj.sts_evnt_yd_cd.value;
	    	if (sts_evnt_yd_cd.length == 7) {
	    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	}
	    	break;   	    		  
       	}
       } 
	/* developer job end */